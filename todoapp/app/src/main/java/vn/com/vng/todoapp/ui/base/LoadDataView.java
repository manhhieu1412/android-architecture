package vn.com.vng.todoapp.ui.base;

/**
 * Created by hieuvm on 9/19/17.
 * *
 */

public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void onError(String message);

    void showMessage(String message);

    void hideKeyboard();

}
