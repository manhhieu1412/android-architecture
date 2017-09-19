package vn.com.vng.todoapp.ui.todolist;

import vn.com.vng.todoapp.ui.base.IPresenter;
import vn.com.vng.todoapp.ui.base.LoadDataView;

/**
 * Created by hieuvm on 9/19/17.
 * *
 */

public interface TodoListContract {

    interface View extends LoadDataView {

    }

    interface Presenter extends IPresenter<View> {

    }
}
