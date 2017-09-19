package vn.com.vng.todoapp

import android.app.Application
import android.os.StrictMode
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import timber.log.Timber
import vn.com.vng.todoapp.provider.CrashlyticsTree

/**
 * Created by hieuvm on 9/8/17.
 * *
 */
class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            StrictMode.enableDefaults()
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashlyticsTree())
        }

        _instance = this
        refWatcher = LeakCanary.install(this)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        private var _instance: Application? = null
        var refWatcher: RefWatcher? = null

        fun instance(): Application {
            return _instance!!
        }

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}