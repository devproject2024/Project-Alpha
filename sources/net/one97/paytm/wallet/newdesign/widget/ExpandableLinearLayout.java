package net.one97.paytm.wallet.newdesign.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.wallet.newdesign.R;

public class ExpandableLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f71473a;

    /* renamed from: b  reason: collision with root package name */
    public TimeInterpolator f71474b;

    /* renamed from: c  reason: collision with root package name */
    public int f71475c;

    /* renamed from: d  reason: collision with root package name */
    public int f71476d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71477e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f71478f;

    /* renamed from: g  reason: collision with root package name */
    private int f71479g;

    /* renamed from: h  reason: collision with root package name */
    private int f71480h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f71481i;
    private ExpandableSavedState j;
    /* access modifiers changed from: private */
    public boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private List<Integer> p;
    private ViewTreeObserver.OnGlobalLayoutListener q;

    public ExpandableLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExpandableLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f71474b = new LinearInterpolator();
        this.f71475c = 0;
        this.f71476d = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.f71477e = false;
        this.o = false;
        this.p = new ArrayList();
        a(context, attributeSet, i2);
    }

    public ExpandableLinearLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f71474b = new LinearInterpolator();
        this.f71475c = 0;
        this.f71476d = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.f71477e = false;
        this.o = false;
        this.p = new ArrayList();
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.expandableLayout, i2, 0);
        this.f71473a = obtainStyledAttributes.getInteger(R.styleable.expandableLayout_ael_duration, 300);
        this.f71478f = obtainStyledAttributes.getBoolean(R.styleable.expandableLayout_ael_expanded, false);
        this.f71479g = obtainStyledAttributes.getInteger(R.styleable.expandableLayout_ael_defaultChildIndex, Integer.MAX_VALUE);
        this.f71480h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.expandableLayout_ael_defaultPosition, Integer.MIN_VALUE);
        int integer = obtainStyledAttributes.getInteger(R.styleable.expandableLayout_ael_interpolator, 8);
        obtainStyledAttributes.recycle();
        this.f71474b = d.a(integer);
        this.k = this.f71478f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        super.onMeasure(i2, i3);
        boolean z = false;
        if (!this.n) {
            this.p.clear();
            int childCount = getChildCount();
            if (childCount > 0) {
                int i9 = 0;
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    if (i10 > 0) {
                        i9 = this.p.get(i10 - 1).intValue();
                    }
                    List<Integer> list = this.p;
                    if (a()) {
                        i8 = childAt.getMeasuredHeight() + layoutParams.topMargin;
                        i7 = layoutParams.bottomMargin;
                    } else {
                        i8 = childAt.getMeasuredWidth() + layoutParams.leftMargin;
                        i7 = layoutParams.rightMargin;
                    }
                    list.add(Integer.valueOf(i8 + i7 + i9));
                }
                int intValue = this.p.get(childCount - 1).intValue();
                if (a()) {
                    i6 = getPaddingTop();
                    i5 = getPaddingBottom();
                } else {
                    i6 = getPaddingLeft();
                    i5 = getPaddingRight();
                }
                this.f71476d = intValue + i6 + i5;
                this.n = true;
            } else {
                throw new IllegalStateException("The expandableLinearLayout must have at least one child");
            }
        }
        if (!this.m) {
            if (!this.f71478f) {
                setLayoutSize(this.f71475c);
            }
            if (this.l) {
                setLayoutSize(this.o ? this.f71476d : this.f71475c);
            }
            int size = this.p.size();
            int i11 = this.f71479g;
            if (size > i11 && size > 0 && !this.f71477e) {
                int a2 = a(i11) + (a() ? getPaddingBottom() : getPaddingRight());
                if (a2 > this.f71475c) {
                    z = true;
                }
                this.k = z;
                setLayoutSize(a2);
                requestLayout();
                b();
            }
            int i12 = this.f71480h;
            if (i12 > 0 && (i4 = this.f71476d) >= i12 && i4 > 0) {
                a(i12, 0, (TimeInterpolator) null);
            }
            this.m = true;
            ExpandableSavedState expandableSavedState = this.j;
            if (expandableSavedState != null) {
                setLayoutSize(expandableSavedState.f71484a);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        ExpandableSavedState expandableSavedState = new ExpandableSavedState(super.onSaveInstanceState());
        expandableSavedState.f71484a = getCurrentPosition();
        return expandableSavedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExpandableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExpandableSavedState expandableSavedState = (ExpandableSavedState) parcelable;
        super.onRestoreInstanceState(expandableSavedState.getSuperState());
        this.j = expandableSavedState;
    }

    public void setListener(a aVar) {
        this.f71481i = aVar;
    }

    public void setDuration(int i2) {
        if (i2 >= 0) {
            this.f71473a = i2;
            return;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(i2)));
    }

    public void setExpanded(boolean z) {
        if (this.l) {
            this.o = z;
        }
        int currentPosition = getCurrentPosition();
        if (z && currentPosition == this.f71476d) {
            return;
        }
        if (z || currentPosition != this.f71475c) {
            this.k = z;
            setLayoutSize(z ? this.f71476d : this.f71475c);
            requestLayout();
        }
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.f71474b = timeInterpolator;
    }

    public final void a(int i2, long j2, TimeInterpolator timeInterpolator) {
        if (!this.f71477e && i2 >= 0 && this.f71476d >= i2) {
            if (j2 <= 0) {
                this.k = i2 > this.f71475c;
                setLayoutSize(i2);
                requestLayout();
                b();
                return;
            }
            int currentPosition = getCurrentPosition();
            if (timeInterpolator == null) {
                timeInterpolator = this.f71474b;
            }
            a(currentPosition, i2, j2, timeInterpolator).start();
        }
    }

    private int a(int i2) {
        if (i2 >= 0 && this.p.size() > i2) {
            return this.p.get(i2).intValue();
        }
        throw new IllegalArgumentException("There aren't the view having this index.");
    }

    public int getClosePosition() {
        return this.f71475c;
    }

    public void setClosePosition(int i2) {
        this.f71475c = i2;
    }

    public int getCurrentPosition() {
        return a() ? getMeasuredHeight() : getMeasuredWidth();
    }

    public void setClosePositionIndex(int i2) {
        this.f71475c = a(i2);
    }

    public void setInRecyclerView(boolean z) {
        this.l = z;
    }

    private boolean a() {
        return getOrientation() == 1;
    }

    private void setLayoutSize(int i2) {
        if (a()) {
            getLayoutParams().height = i2;
        } else {
            getLayoutParams().width = i2;
        }
    }

    public final ValueAnimator a(int i2, final int i3, long j2, TimeInterpolator timeInterpolator) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.setDuration(j2);
        ofInt.setInterpolator(timeInterpolator);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandableLinearLayout.this.a(valueAnimator);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                boolean unused = ExpandableLinearLayout.this.f71477e = true;
                if (ExpandableLinearLayout.this.f71481i != null) {
                    a unused2 = ExpandableLinearLayout.this.f71481i;
                    if (ExpandableLinearLayout.this.f71476d == i3) {
                        ExpandableLinearLayout.this.f71481i.a();
                    } else if (ExpandableLinearLayout.this.f71475c == i3) {
                        ExpandableLinearLayout.this.f71481i.b();
                    }
                }
            }

            public final void onAnimationEnd(Animator animator) {
                boolean z = false;
                boolean unused = ExpandableLinearLayout.this.f71477e = false;
                ExpandableLinearLayout expandableLinearLayout = ExpandableLinearLayout.this;
                if (i3 > expandableLinearLayout.f71475c) {
                    z = true;
                }
                boolean unused2 = expandableLinearLayout.k = z;
                if (ExpandableLinearLayout.this.f71481i != null) {
                    a unused3 = ExpandableLinearLayout.this.f71481i;
                    if (i3 == ExpandableLinearLayout.this.f71476d) {
                        a unused4 = ExpandableLinearLayout.this.f71481i;
                    } else if (i3 == ExpandableLinearLayout.this.f71475c) {
                        a unused5 = ExpandableLinearLayout.this.f71481i;
                    }
                }
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        if (a()) {
            getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        } else {
            getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        }
        requestLayout();
    }

    private void b() {
        a aVar = this.f71481i;
        if (aVar != null) {
            if (this.k) {
                aVar.a();
            } else {
                aVar.b();
            }
            this.q = new ViewTreeObserver.OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    ExpandableLinearLayout.this.c();
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(this.q);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.q);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.q);
        }
    }
}
