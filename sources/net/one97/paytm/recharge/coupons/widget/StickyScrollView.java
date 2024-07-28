package net.one97.paytm.recharge.coupons.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ScrollView;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.recharge.R;

public class StickyScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<View> f62322a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f62323b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public float f62324c;

    /* renamed from: d  reason: collision with root package name */
    private int f62325d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f62326e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f62327f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f62328g;

    /* renamed from: h  reason: collision with root package name */
    private int f62329h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f62330i;
    private final Runnable j;
    private boolean k;

    public StickyScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StickyScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842880);
    }

    public StickyScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new Runnable() {
            public final void run() {
                if (StickyScrollView.this.f62323b != null) {
                    StickyScrollView stickyScrollView = StickyScrollView.this;
                    int a2 = stickyScrollView.a(stickyScrollView.f62323b);
                    StickyScrollView stickyScrollView2 = StickyScrollView.this;
                    int b2 = StickyScrollView.b(stickyScrollView2, stickyScrollView2.f62323b);
                    StickyScrollView stickyScrollView3 = StickyScrollView.this;
                    StickyScrollView.this.invalidate(a2, b2, stickyScrollView3.c(stickyScrollView3.f62323b), (int) (((float) StickyScrollView.this.getScrollY()) + ((float) StickyScrollView.this.f62323b.getHeight()) + StickyScrollView.this.f62324c));
                }
                StickyScrollView.this.postDelayed(this, 16);
            }
        };
        this.k = true;
        setup();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StickyScrollView, i2, 0);
        this.f62329h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyScrollView_stuckShadowHeight, (int) ((context.getResources().getDisplayMetrics().density * 10.0f) + 0.5f));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.StickyScrollView_stuckShadowDrawable, -1);
        if (resourceId != -1) {
            this.f62330i = context.getResources().getDrawable(resourceId);
        }
        obtainStyledAttributes.recycle();
    }

    public void setShadowHeight(int i2) {
        this.f62329h = i2;
    }

    public void setup() {
        this.f62322a = new ArrayList<>();
    }

    /* access modifiers changed from: private */
    public int a(View view) {
        int left = view.getLeft();
        while (view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            left += view.getLeft();
        }
        return left;
    }

    private int b(View view) {
        int top = view.getTop();
        while (view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            top += view.getTop();
        }
        return top;
    }

    /* access modifiers changed from: private */
    public int c(View view) {
        int right = view.getRight();
        while (view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            right += view.getRight();
        }
        return right;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.f62328g) {
            this.f62327f = true;
        }
        if (this.f62323b != null) {
            b();
        }
        this.f62322a.clear();
        e(getChildAt(0));
        a();
        invalidate();
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.f62327f = z;
        this.f62328g = true;
    }

    public void addView(View view) {
        super.addView(view);
        e(view);
    }

    public void addView(View view, int i2) {
        super.addView(view, i2);
        e(view);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        e(view);
    }

    public void addView(View view, int i2, int i3) {
        super.addView(view, i2, i3);
        e(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        e(view);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f62323b != null) {
            canvas.save();
            canvas.translate((float) (getPaddingLeft() + this.f62325d), ((float) getScrollY()) + this.f62324c + ((float) (this.f62327f ? getPaddingTop() : 0)));
            canvas.clipRect(0.0f, this.f62327f ? -this.f62324c : 0.0f, (float) (getWidth() - this.f62325d), (float) (this.f62323b.getHeight() + this.f62329h + 1));
            if (this.f62330i != null) {
                this.f62330i.setBounds(0, this.f62323b.getHeight(), this.f62323b.getWidth(), this.f62323b.getHeight() + this.f62329h);
                this.f62330i.draw(canvas);
            }
            canvas.clipRect(0.0f, this.f62327f ? -this.f62324c : 0.0f, (float) getWidth(), (float) this.f62323b.getHeight());
            if (String.valueOf(this.f62323b.getTag()).contains("-hastransparancy")) {
                g(this.f62323b);
                this.f62323b.draw(canvas);
                f(this.f62323b);
            } else {
                this.f62323b.draw(canvas);
            }
            canvas.restore();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 0) {
            this.f62326e = true;
        }
        if (this.f62326e) {
            this.f62326e = this.f62323b != null;
            if (this.f62326e) {
                if (motionEvent.getY() > ((float) this.f62323b.getHeight()) + this.f62324c || motionEvent.getX() < ((float) a(this.f62323b)) || motionEvent.getX() > ((float) c(this.f62323b))) {
                    z = false;
                }
                this.f62326e = z;
            }
        } else if (this.f62323b == null) {
            this.f62326e = false;
        }
        if (this.f62326e) {
            motionEvent.offsetLocation(0.0f, ((((float) getScrollY()) + this.f62324c) - ((float) b(this.f62323b))) * -1.0f);
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f62326e) {
            motionEvent.offsetLocation(0.0f, (((float) getScrollY()) + this.f62324c) - ((float) b(this.f62323b)));
        }
        if (motionEvent.getAction() == 0) {
            this.k = false;
        }
        if (this.k) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            super.onTouchEvent(obtain);
            this.k = false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.k = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a();
    }

    private void a() {
        float f2;
        Iterator<View> it2 = this.f62322a.iterator();
        View view = null;
        View view2 = null;
        while (true) {
            int i2 = 0;
            if (!it2.hasNext()) {
                break;
            }
            View next = it2.next();
            int b2 = (b(next) - getScrollY()) + (this.f62327f ? 0 : getPaddingTop());
            if (b2 <= 0) {
                if (view != null) {
                    int b3 = b(view) - getScrollY();
                    if (!this.f62327f) {
                        i2 = getPaddingTop();
                    }
                    if (b2 <= b3 + i2) {
                    }
                }
                view = next;
            } else {
                if (view2 != null) {
                    int b4 = b(view2) - getScrollY();
                    if (!this.f62327f) {
                        i2 = getPaddingTop();
                    }
                    if (b2 >= b4 + i2) {
                    }
                }
                view2 = next;
            }
        }
        if (view != null) {
            if (view2 == null) {
                f2 = 0.0f;
            } else {
                f2 = (float) Math.min(0, ((b(view2) - getScrollY()) + (this.f62327f ? 0 : getPaddingTop())) - view.getHeight());
            }
            this.f62324c = f2;
            View view3 = this.f62323b;
            if (view != view3) {
                if (view3 != null) {
                    b();
                }
                this.f62325d = a(view);
                d(view);
            }
        } else if (this.f62323b != null) {
            b();
        }
    }

    private void d(View view) {
        this.f62323b = view;
        if (String.valueOf(this.f62323b.getTag()).contains("-hastransparancy")) {
            f(this.f62323b);
        }
        if (((String) this.f62323b.getTag()).contains("-nonconstant")) {
            post(this.j);
        }
    }

    private void b() {
        if (String.valueOf(this.f62323b.getTag()).contains("-hastransparancy")) {
            g(this.f62323b);
        }
        this.f62323b = null;
        removeCallbacks(this.j);
    }

    private void e(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                String valueOf = String.valueOf(viewGroup.getChildAt(i2).getTag());
                if (valueOf != null && valueOf.contains("sticky")) {
                    this.f62322a.add(viewGroup.getChildAt(i2));
                } else if (viewGroup.getChildAt(i2) instanceof ViewGroup) {
                    e(viewGroup.getChildAt(i2));
                }
            }
            return;
        }
        String str = (String) view.getTag();
        if (str != null && str.contains("sticky")) {
            this.f62322a.add(view);
        }
    }

    private static void f(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(0.0f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private static void g(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(1.0f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    static /* synthetic */ int b(StickyScrollView stickyScrollView, View view) {
        int bottom = view.getBottom();
        while (view.getParent() != stickyScrollView.getChildAt(0)) {
            view = (View) view.getParent();
            bottom += view.getBottom();
        }
        return bottom;
    }
}
