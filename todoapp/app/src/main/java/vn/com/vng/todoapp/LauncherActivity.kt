package vn.com.vng.todoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.jaeger.library.StatusBarUtil
import timber.log.Timber
import vn.com.vng.todoapp.ui.HomeController

/**
 * Created by hieuvm on 9/8/17.
 * *
 */
class LauncherActivity : AppCompatActivity() {

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        StatusBarUtil.setTranslucent(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val container = findViewById(R.id.container) as ViewGroup

        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(HomeController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}