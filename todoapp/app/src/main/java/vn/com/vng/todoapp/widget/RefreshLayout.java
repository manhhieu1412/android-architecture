package vn.com.vng.todoapp.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by hieuvm on 9/19/17.
 * *
 */

public class RefreshLayout extends TwinklingRefreshLayout {
    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private OnRefreshListener mOnRefreshListener;

    public void setOnRefreshListener(OnRefreshListener listener) {
        mOnRefreshListener = listener;
    }

    @Override
    public final void setOnRefreshListener(RefreshListenerAdapter refreshListener) {
        super.setOnRefreshListener(refreshListener);
    }

    public interface OnRefreshListener {
        void onRefresh();

        void onLoadMore();
    }
}
