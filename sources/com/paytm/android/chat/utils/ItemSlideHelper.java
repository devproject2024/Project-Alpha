package com.paytm.android.chat.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.h.d;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;

public class ItemSlideHelper implements GestureDetector.OnGestureListener, RecyclerView.k {
    public static final int DEFAULT_DURATION = 200;
    boolean isSwipe = false;
    private int mActivePointerId;
    private Callback mCallback;
    /* access modifiers changed from: private */
    public Animator mExpandAndCollapseAnim;
    private d mGestureDetector;
    private boolean mIsDragging;
    private View mLastTargetView;
    private int mLastX;
    private int mLastY;
    private int mMaxVelocity;
    private int mMinVelocity;
    /* access modifiers changed from: private */
    public View mTargetView;
    private int mTouchSlop;

    public interface Callback {
        View findTargetView(float f2, float f3);

        RecyclerView.v getChildViewHolder(View view);

        int getHorizontalRange(RecyclerView.v vVar);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public ItemSlideHelper(Context context, Callback callback) {
        this.mCallback = callback;
        this.mGestureDetector = new d(context, this);
        if (Build.VERSION.SDK_INT >= 3) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            if (Build.VERSION.SDK_INT >= 4) {
                this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            }
            this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        }
    }

    private boolean isExpanded() {
        View view = this.mTargetView;
        return view != null && view.getScrollX() == getHorizontalRange();
    }

    /* access modifiers changed from: private */
    public boolean isCollapsed() {
        View view = this.mTargetView;
        return view != null && view.getScrollX() == 0;
    }

    private boolean inView(int i2, int i3) {
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        int width = view.getWidth() - getHorizontalRange();
        return new Rect(width, this.mTargetView.getTop(), getHorizontalRange() + width, this.mTargetView.getBottom()).contains(i2, i3);
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Animator animator = this.mExpandAndCollapseAnim;
        if ((animator != null && animator.isRunning()) || this.mTargetView == null) {
            return;
        }
        if (this.mGestureDetector.a(motionEvent)) {
            this.mIsDragging = false;
            return;
        }
        motionEvent.getX();
        motionEvent.getY();
        motionEvent.getActionMasked();
    }

    private void horizontalDrag(int i2) {
        int scrollX = this.mTargetView.getScrollX();
        int scrollY = this.mTargetView.getScrollY();
        int i3 = scrollX + i2;
        if (i3 <= 0) {
            this.mTargetView.scrollTo(0, scrollY);
            return;
        }
        int horizontalRange = getHorizontalRange();
        if (Math.abs(i3) < horizontalRange) {
            this.mTargetView.scrollTo(i3, scrollY);
        } else {
            this.mTargetView.scrollTo(horizontalRange, scrollY);
        }
    }

    public boolean smoothHorizontalExpandOrCollapse(float f2) {
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        int scrollX = view.getScrollX();
        int horizontalRange = getHorizontalRange();
        if (this.mExpandAndCollapseAnim != null) {
            return false;
        }
        int i2 = 200;
        int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            if (i3 > 0) {
                horizontalRange = 0;
            }
            i2 = (int) ((1.0f - (Math.abs(f2) / ((float) this.mMaxVelocity))) * 200.0f);
        } else if (scrollX <= horizontalRange / 2) {
            horizontalRange = 0;
        }
        if (horizontalRange == scrollX) {
            return false;
        }
        final boolean z = horizontalRange == 0;
        if (Build.VERSION.SDK_INT >= 11) {
            this.mExpandAndCollapseAnim = ObjectAnimator.ofInt(this.mTargetView, "scrollX", new int[]{horizontalRange});
            this.mExpandAndCollapseAnim.setDuration((long) i2);
            this.mExpandAndCollapseAnim.addListener(new Animator.AnimatorListener() {
                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    if (z) {
                        ItemSlideHelper.this.setTag(false);
                    }
                }

                public final void onAnimationEnd(Animator animator) {
                    Animator unused = ItemSlideHelper.this.mExpandAndCollapseAnim = null;
                    if (!z) {
                        ItemSlideHelper.this.setTag(true);
                    }
                    if (ItemSlideHelper.this.isCollapsed()) {
                        ItemSlideHelper.this.mTargetView.setBackgroundColor(0);
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                    Animator unused = ItemSlideHelper.this.mExpandAndCollapseAnim = null;
                }
            });
            this.mExpandAndCollapseAnim.start();
        }
        return true;
    }

    public void smoothHorizontal(float f2) {
        View view = this.mTargetView;
        if (view != null) {
            view.setBackgroundColor(0);
            int scrollX = this.mTargetView.getScrollX();
            int horizontalRange = getHorizontalRange();
            int i2 = 200;
            if (f2 != 0.0f) {
                i2 = (int) ((1.0f - (Math.abs(f2) / ((float) this.mMaxVelocity))) * 200.0f);
            } else if (scrollX <= horizontalRange / 2) {
                horizontalRange = 0;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                this.mExpandAndCollapseAnim = ObjectAnimator.ofInt(this.mTargetView, "scrollX", new int[]{horizontalRange});
                this.mExpandAndCollapseAnim.setDuration((long) i2);
                this.mExpandAndCollapseAnim.addListener(new Animator.AnimatorListener() {
                    public final void onAnimationRepeat(Animator animator) {
                    }

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        Animator unused = ItemSlideHelper.this.mExpandAndCollapseAnim = null;
                        ItemSlideHelper.this.setTag(true);
                        if (ItemSlideHelper.this.isCollapsed()) {
                            ItemSlideHelper.this.mTargetView.setBackgroundColor(0);
                        }
                    }

                    public final void onAnimationCancel(Animator animator) {
                        Animator unused = ItemSlideHelper.this.mExpandAndCollapseAnim = null;
                    }
                });
                this.mExpandAndCollapseAnim.start();
            }
        }
    }

    public boolean endAnimation() {
        Animator animator = this.mExpandAndCollapseAnim;
        if (animator == null || !animator.isRunning()) {
            return false;
        }
        try {
            this.mExpandAndCollapseAnim.end();
            return true;
        } catch (NullPointerException unused) {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void setTag(boolean z) {
        RecyclerView.v childViewHolder;
        View view = this.mTargetView;
        if (view != null && (childViewHolder = this.mCallback.getChildViewHolder(view)) != null) {
            childViewHolder.itemView.setTag(R.id.isShow, Boolean.valueOf(z));
            childViewHolder.itemView.setTag(R.id.position, Integer.valueOf(childViewHolder.getAdapterPosition()));
        }
    }

    public int getHorizontalRange() {
        return this.mCallback.getHorizontalRange(this.mCallback.getChildViewHolder(this.mTargetView));
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (Math.abs(f2) <= ((float) this.mMinVelocity) || Math.abs(f2) >= ((float) this.mMaxVelocity) || smoothHorizontalExpandOrCollapse(f2)) {
            return false;
        }
        isCollapsed();
        return true;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Animator animator;
        int actionMasked = motionEvent.getActionMasked();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (recyclerView.getScrollState() != 0) {
            if (this.mTargetView != null) {
                smoothHorizontalExpandOrCollapse(100.0f);
                this.mTargetView.setBackgroundColor(0);
                setTag(false);
            }
            return false;
        }
        Animator animator2 = this.mExpandAndCollapseAnim;
        if (animator2 == null || !animator2.isRunning()) {
            this.isSwipe = false;
            if (actionMasked == 0) {
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mLastX = (int) motionEvent.getX();
                this.mLastY = (int) motionEvent.getY();
                if (this.mTargetView != null) {
                    smoothHorizontalExpandOrCollapse(100.0f);
                    this.mTargetView.setBackgroundColor(0);
                    setTag(false);
                }
                this.mTargetView = this.mCallback.findTargetView((float) x, (float) y);
                return false;
            } else if (actionMasked != 1 && (actionMasked == 2 || actionMasked != 3)) {
                return false;
            } else {
                this.mLastTargetView = this.mTargetView;
                if (inView(x, y)) {
                    if (!isExpanded()) {
                        return false;
                    }
                    endAnimation();
                    return false;
                } else if (!isCollapsed() || ((animator = this.mExpandAndCollapseAnim) != null && animator.isRunning())) {
                    return true;
                } else {
                    return false;
                }
            }
        } else if (this.mLastTargetView == this.mTargetView && !inView(x, y)) {
            return true;
        } else {
            return false;
        }
    }
}
