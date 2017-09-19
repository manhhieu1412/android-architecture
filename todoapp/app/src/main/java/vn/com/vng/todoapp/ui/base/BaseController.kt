package vn.com.vng.todoapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import vn.com.vng.todoapp.AndroidApplication
import vn.com.vng.todoapp.provider.DialogProvider

/**
 * Created by hieuvm on 9/17/17.
 * *
 */
abstract class BaseController : Controller {

    constructor() : super()
    constructor(args: Bundle?) : super(args)

    private var mUnbinder: Unbinder? = null
    private var hasExited: Boolean = false

    private var mDialogProvider: DialogProvider? = null

    protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflateView(inflater, container)
        mUnbinder = ButterKnife.bind(this, view)
        onViewBound(view)
        return view
    }

    open fun onViewBound(view: View) {
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        mUnbinder?.unbind()
        mUnbinder = null
    }

    override fun onDestroy() {
        super.onDestroy()
        if (hasExited) {
            AndroidApplication.refWatcher?.watch(this)
        }
    }

    override fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super.onChangeEnded(changeHandler, changeType)
        hasExited = !changeType.isEnter
        if (isDestroyed) {
            AndroidApplication.refWatcher?.watch(this)
        }
    }

    fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onError(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun showMessage(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun hideKeyboard() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}