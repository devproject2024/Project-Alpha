package com.alipay.mobile.nebula.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5PullContainer extends FrameLayout implements H5OverScrollListener {
    public static final int DEFALUT_DURATION = 600;
    public static final String TAG = "H5PullContainer";
    private View contentView;
    private Flinger flinger = new Flinger();
    private boolean handleM57OverScroll = false;
    protected int headerHeight;
    private View headerView;
    private int lastY;
    /* access modifiers changed from: private */
    public int offsets = 0;
    private boolean overScrolled;
    /* access modifiers changed from: private */
    public H5PullAdapter pullAdapter;
    protected int state = H5PullState.STATE_FIT_CONTENT;

    public H5PullContainer(Context context) {
        super(context);
        init();
    }

    public H5PullContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public H5PullContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    private void init() {
        if (H5Utils.isUCM57()) {
            this.handleM57OverScroll = true;
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
            if (h5ConfigProvider != null) {
                this.handleM57OverScroll = true ^ H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equalsIgnoreCase(h5ConfigProvider.getConfig("h5_handleM57OverScroll"));
            }
        }
    }

    private static int getScrollY(View view) {
        if (view != null) {
            return view.getScrollY();
        }
        return 0;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return handleTouch(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    private boolean canPull() {
        H5PullAdapter h5PullAdapter = this.pullAdapter;
        if ((h5PullAdapter == null || h5PullAdapter.canPull()) && this.contentView != null) {
            return true;
        }
        return false;
    }

    private boolean canRefresh() {
        H5PullAdapter h5PullAdapter = this.pullAdapter;
        return h5PullAdapter != null && h5PullAdapter.canRefresh();
    }

    private boolean handleTouch(MotionEvent motionEvent) {
        boolean z = false;
        if (!canPull()) {
            return false;
        }
        int action = motionEvent.getAction();
        int top = this.contentView.getTop();
        boolean z2 = action == 1 || action == 3;
        if (z2) {
            this.overScrolled = false;
        }
        if (top <= 0 || !z2) {
            if (action == 2) {
                int scrollY = getScrollY(this.contentView);
                int y = ((int) (motionEvent.getY() - ((float) this.lastY))) / 2;
                boolean z3 = this.overScrolled && scrollY <= 0;
                if (this.handleM57OverScroll && this.offsets == 0) {
                    z3 &= y > 0;
                }
                if (z3) {
                    this.offsets += y;
                    if (this.offsets > 300) {
                        y /= 2;
                    }
                    moveOffset(y);
                    z = true;
                }
                this.lastY = (int) motionEvent.getY();
            }
            return z;
        }
        if (hasHeader()) {
            if (this.state == H5PullState.STATE_OVER) {
                fitExtras();
            } else if (this.state == H5PullState.STATE_FIT_EXTRAS) {
                int i2 = this.headerHeight;
                if (top > i2) {
                    this.flinger.recover(top - i2);
                }
            } else {
                int i3 = H5PullState.STATE_OPEN;
            }
            return false;
        }
        this.flinger.recover(top);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        View view = this.contentView;
        if (view != null) {
            i6 = view.getTop();
            View view2 = this.contentView;
            view2.layout(0, i6, i4, view2.getMeasuredHeight() + i6);
        } else {
            i6 = 0;
        }
        int i7 = i6 - this.headerHeight;
        if (hasHeader()) {
            this.headerView.layout(0, i7, i4, this.headerHeight + i7);
        }
    }

    /* access modifiers changed from: private */
    public boolean moveOffset(int i2) {
        if (this.contentView == null) {
            return false;
        }
        if (this.state != H5PullState.STATE_FIT_EXTRAS) {
            int top = this.contentView.getTop() + i2;
            if (top <= 0) {
                i2 = -this.contentView.getTop();
            } else {
                int i3 = this.headerHeight;
                if (top <= i3) {
                    if ((this.state == H5PullState.STATE_OVER || this.state == H5PullState.STATE_FIT_CONTENT) && this.flinger.isFinished()) {
                        H5PullAdapter h5PullAdapter = this.pullAdapter;
                        if (h5PullAdapter != null) {
                            h5PullAdapter.onOpen();
                        }
                        this.state = H5PullState.STATE_OPEN;
                    }
                    H5PullAdapter h5PullAdapter2 = this.pullAdapter;
                    if (h5PullAdapter2 != null) {
                        h5PullAdapter2.onProgressUpdate((int) ((((float) top) / ((float) this.headerHeight)) * 100.0f));
                    }
                } else if (top > i3 && this.state == H5PullState.STATE_OPEN) {
                    H5PullAdapter h5PullAdapter3 = this.pullAdapter;
                    if (h5PullAdapter3 != null) {
                        h5PullAdapter3.onOver();
                    }
                    this.state = H5PullState.STATE_OVER;
                }
            }
        }
        this.contentView.offsetTopAndBottom(i2);
        if (hasHeader()) {
            this.headerView.offsetTopAndBottom(i2);
        }
        invalidate();
        return true;
    }

    private boolean hasHeader() {
        View view = this.headerView;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private void fitExtras() {
        if (this.state != H5PullState.STATE_FIT_EXTRAS) {
            this.state = H5PullState.STATE_FIT_EXTRAS;
            if (hasHeader()) {
                this.flinger.recover(this.contentView.getTop() - this.headerHeight);
            }
            H5PullAdapter h5PullAdapter = this.pullAdapter;
            if (h5PullAdapter != null) {
                h5PullAdapter.onLoading();
            }
        }
    }

    public void setContentView(View view) {
        this.contentView = view;
        addView(this.contentView, 0);
    }

    public void setPullableView(H5PullableView h5PullableView) {
        if (h5PullableView != null) {
            h5PullableView.setH5OverScrollListener(this);
        }
    }

    public void fitContent() {
        View view;
        if (this.state == H5PullState.STATE_FIT_EXTRAS && (view = this.contentView) != null) {
            int top = view.getTop();
            if (top > 0) {
                this.flinger.recover(top);
            }
            this.state = H5PullState.STATE_FIT_CONTENT;
        }
    }

    public boolean isBackToTop() {
        return this.contentView.getTop() <= 0;
    }

    public void setPullAdapter(H5PullAdapter h5PullAdapter) {
        View view = this.headerView;
        if (view != null) {
            removeView(view);
            this.headerView = null;
        }
        this.pullAdapter = h5PullAdapter;
    }

    public void onOverScrolled(int i2, int i3, int i4, int i5) {
        View view = this.contentView;
        if (view != null && getScrollY(view) <= 0 && i3 < 0 && i5 <= 0) {
            this.overScrolled = true;
        }
    }

    public void notifyViewChanged() {
        if (this.headerView == null) {
            updateHeader();
        }
        if (this.headerView == null) {
            return;
        }
        if (!canRefresh()) {
            this.headerView.setVisibility(8);
        } else {
            this.headerView.setVisibility(0);
        }
    }

    private void updateHeader() {
        if (getChildCount() > 0) {
            this.headerView = this.pullAdapter.getHeaderView();
            View view = this.headerView;
            if (view != null) {
                view.measure(0, 0);
                this.headerHeight = this.headerView.getMeasuredHeight();
                addView(this.headerView, 0, new FrameLayout.LayoutParams(-1, this.headerHeight));
                return;
            }
            return;
        }
        throw new IllegalStateException("content view not added yet");
    }

    class Flinger implements Runnable {
        private boolean finished = true;
        private int lastScrollY;
        private Scroller scroller;

        public Flinger() {
            this.scroller = new Scroller(H5PullContainer.this.getContext());
        }

        public void run() {
            if (this.scroller.computeScrollOffset()) {
                boolean unused = H5PullContainer.this.moveOffset(this.lastScrollY - this.scroller.getCurrY());
                this.lastScrollY = this.scroller.getCurrY();
                H5PullContainer.this.post(this);
                return;
            }
            this.finished = true;
            H5PullContainer.this.removeCallbacks(this);
            if (H5PullContainer.this.pullAdapter != null) {
                H5PullContainer.this.pullAdapter.onFinish();
            }
        }

        public void recover(int i2) {
            try {
                H5PullContainer.this.removeCallbacks(this);
                this.lastScrollY = 0;
                int unused = H5PullContainer.this.offsets = 0;
                this.finished = false;
                this.scroller.startScroll(0, 0, 0, i2, H5PullContainer.DEFALUT_DURATION);
                H5PullContainer.this.post(this);
            } catch (Throwable th) {
                H5Log.e(H5PullContainer.TAG, th);
            }
        }

        public boolean isFinished() {
            return this.finished;
        }
    }
}
