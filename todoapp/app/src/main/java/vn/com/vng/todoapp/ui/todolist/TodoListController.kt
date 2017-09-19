package vn.com.vng.todoapp.ui.todolist

import android.graphics.Color
import android.view.*
import vn.com.vng.todoapp.R
import vn.com.vng.todoapp.ui.base.BaseController
import vn.com.vng.todoapp.widget.ActionBarLayout

/**
 * Created by hieuvm on 9/17/17.
 * *
 */
abstract class TodoListController : BaseController {
    constructor() : super()

    init {

    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return ActionBarLayout(activity!!.baseContext)
    }

    override fun onViewBound(view: View) {
        view.setBackgroundColor(Color.BLUE)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.id.home, menu)
    }
}