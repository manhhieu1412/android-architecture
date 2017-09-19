package vn.com.vng.todoapp.ui.todolist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.com.vng.todoapp.ui.base.BaseController
import vn.com.vng.todoapp.ui.widget.ActionBarLayout

/**
 * Created by hieuvm on 9/17/17.
 * *
 */
abstract class TodoListController : BaseController {
    constructor() : super()

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return ActionBarLayout(activity!!.baseContext)
    }

    override fun onViewBound(view: View) {
        view.setBackgroundColor(Color.BLUE)
    }
}