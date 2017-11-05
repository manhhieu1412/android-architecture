package vn.com.vng.todoapp

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import vn.com.vng.todoapp.internal.di.component.DaggerAppComponent
import vn.com.vng.todoapp.provider.CrashlyticsTree
import javax.inject.Inject


/**
 * Created by hieuvm on 9/8/17.
 * *
 */
class AndroidApplication : Application(), HasActivityInjector {

    var activityInjector: DispatchingAndroidInjector<Activity>? = null
        @Inject set

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().create(this).inject(this)

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


    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector as AndroidInjector<Activity>
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