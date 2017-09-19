package vn.com.vng.todoapp.ui.base;

import android.support.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

/**
 * Created by huuhoa on 12/11/16.
 * Based presenter for implement common behaviours
 */

public abstract class AbstractPresenter<View extends LoadDataView> implements IPresenter<View> {
    protected final CompositeDisposable mSubscription = new CompositeDisposable();
    protected View mView;


    /**
     * Call to attach a view to presenter.
     * <p>
     * The best time to call this function is when a view is created by Android framework
     */
    @CallSuper
    @Override
    public void attachView(View view) {
        Timber.d("attachView: %s", view);
        mView = view;
    }

    /**
     * Call to remove/detach the attached view from presenter.
     * This is done to break the memory reference between presenter and view, so the GC will
     * know how to collect them.
     * <p>
     * detachView is called when the view is about to be destroyed by Android framework
     */
    @CallSuper
    @Override
    public void detachView() {
        Timber.d("detachView: %s", mView);
        mSubscription.clear();
        mView = null;
    }

    /**
     * notify the presenter that view is destroyed (onDestroy on Activity, Fragment)
     */
    @CallSuper
    @Override
    public void destroy() {
        Timber.d("destroy is called");
    }

    /**
     * notify the presenter that view is resumed (onResume on Activity, Fragment)
     */
    @Override
    public void resume() {
    }

    /**
     * notify the presenter that view is paused (onPause on Activity, Fragment)
     */
    @Override
    public void pause() {
    }
}