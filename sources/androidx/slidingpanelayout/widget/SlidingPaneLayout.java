package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.u;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    int f4519a;

    /* renamed from: b  reason: collision with root package name */
    View f4520b;

    /* renamed from: c  reason: collision with root package name */
    float f4521c;

    /* renamed from: d  reason: collision with root package name */
    int f4522d;

    /* renamed from: e  reason: collision with root package name */
    boolean f4523e;

    /* renamed from: f  reason: collision with root package name */
    int f4524f;

    /* renamed from: g  reason: collision with root package name */
    final androidx.customview.a.c f4525g;

    /* renamed from: h  reason: collision with root package name */
    boolean f4526h;

    /* renamed from: i  reason: collision with root package name */
    final ArrayList<b> f4527i;
    private int j;
    private Drawable k;
    private Drawable l;
    private final int m;
    private boolean n;
    private float o;
    private float p;
    private float q;
    private d r;
    private boolean s;
    private final Rect t;
    private Method u;
    private Field v;
    private boolean w;

    public interface d {
    }

    public SlidingPaneLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4519a = -858993460;
        this.s = true;
        this.t = new Rect();
        this.f4527i = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.m = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        u.a((View) this, (androidx.core.h.a) new a());
        u.c((View) this, 1);
        this.f4525g = androidx.customview.a.c.a((ViewGroup) this, 0.5f, (c.a) new c());
        this.f4525g.f3236c = f2 * 400.0f;
    }

    public void setParallaxDistance(int i2) {
        this.f4524f = i2;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f4524f;
    }

    public void setSliderFadeColor(int i2) {
        this.f4519a = i2;
    }

    public int getSliderFadeColor() {
        return this.f4519a;
    }

    public void setCoveredFadeColor(int i2) {
        this.j = i2;
    }

    public int getCoveredFadeColor() {
        return this.j;
    }

    public void setPanelSlideListener(d dVar) {
        this.r = dVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r18) {
        /*
            r17 = this;
            r0 = r18
            boolean r1 = r17.b()
            if (r1 == 0) goto L_0x0012
            int r2 = r17.getWidth()
            int r3 = r17.getPaddingRight()
            int r2 = r2 - r3
            goto L_0x0016
        L_0x0012:
            int r2 = r17.getPaddingLeft()
        L_0x0016:
            if (r1 == 0) goto L_0x001d
            int r3 = r17.getPaddingLeft()
            goto L_0x0026
        L_0x001d:
            int r3 = r17.getWidth()
            int r4 = r17.getPaddingRight()
            int r3 = r3 - r4
        L_0x0026:
            int r4 = r17.getPaddingTop()
            int r5 = r17.getHeight()
            int r6 = r17.getPaddingBottom()
            int r5 = r5 - r6
            if (r0 == 0) goto L_0x0065
            boolean r7 = r18.isOpaque()
            r8 = 1
            if (r7 == 0) goto L_0x003d
            goto L_0x0052
        L_0x003d:
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 18
            if (r7 >= r9) goto L_0x0051
            android.graphics.drawable.Drawable r7 = r18.getBackground()
            if (r7 == 0) goto L_0x0051
            int r7 = r7.getOpacity()
            r9 = -1
            if (r7 != r9) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r8 = 0
        L_0x0052:
            if (r8 == 0) goto L_0x0065
            int r7 = r18.getLeft()
            int r8 = r18.getRight()
            int r9 = r18.getTop()
            int r10 = r18.getBottom()
            goto L_0x0069
        L_0x0065:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0069:
            int r11 = r17.getChildCount()
            r12 = 0
        L_0x006e:
            r13 = r17
            if (r12 >= r11) goto L_0x00c4
            android.view.View r14 = r13.getChildAt(r12)
            if (r14 == r0) goto L_0x00c4
            int r15 = r14.getVisibility()
            r6 = 8
            if (r15 == r6) goto L_0x00bb
            if (r1 == 0) goto L_0x0084
            r6 = r3
            goto L_0x0085
        L_0x0084:
            r6 = r2
        L_0x0085:
            int r15 = r14.getLeft()
            int r6 = java.lang.Math.max(r6, r15)
            int r15 = r14.getTop()
            int r15 = java.lang.Math.max(r4, r15)
            r16 = r1
            if (r1 == 0) goto L_0x009b
            r0 = r2
            goto L_0x009c
        L_0x009b:
            r0 = r3
        L_0x009c:
            int r1 = r14.getRight()
            int r0 = java.lang.Math.min(r0, r1)
            int r1 = r14.getBottom()
            int r1 = java.lang.Math.min(r5, r1)
            if (r6 < r7) goto L_0x00b6
            if (r15 < r9) goto L_0x00b6
            if (r0 > r8) goto L_0x00b6
            if (r1 > r10) goto L_0x00b6
            r6 = 4
            goto L_0x00b7
        L_0x00b6:
            r6 = 0
        L_0x00b7:
            r14.setVisibility(r6)
            goto L_0x00bd
        L_0x00bb:
            r16 = r1
        L_0x00bd:
            int r12 = r12 + 1
            r0 = r18
            r1 = r16
            goto L_0x006e
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.f4527i.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4527i.get(i2).run();
        }
        this.f4527i.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        } else if (mode2 != 1073741824) {
            i5 = 0;
            i4 = 0;
        } else {
            i5 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.f4520b = null;
        int i14 = i5;
        int i15 = paddingLeft;
        int i16 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (true) {
            i6 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f4531c = z;
            } else {
                if (layoutParams.f4529a > 0.0f) {
                    f2 += layoutParams.f4529a;
                    if (layoutParams.width == 0) {
                    }
                }
                int i17 = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, 1073741824);
                } else {
                    i12 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                } else {
                    i13 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(i12, i13);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i14) {
                    i14 = Math.min(measuredHeight, i4);
                }
                i15 -= measuredWidth;
                boolean z3 = i15 < 0;
                layoutParams.f4530b = z3;
                boolean z4 = z3 | z2;
                if (layoutParams.f4530b) {
                    this.f4520b = childAt;
                }
                z2 = z4;
            }
            i16++;
            z = false;
        }
        if (z2 || f2 > 0.0f) {
            int i18 = paddingLeft - this.m;
            int i19 = 0;
            while (i19 < childCount) {
                View childAt2 = getChildAt(i19);
                if (childAt2.getVisibility() != i6) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i6) {
                        boolean z5 = layoutParams2.width == 0 && layoutParams2.f4529a > 0.0f;
                        if (z5) {
                            i8 = 0;
                        } else {
                            i8 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.f4520b) {
                            if (layoutParams2.f4529a > 0.0f) {
                                if (layoutParams2.width != 0) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams2.height == -2) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                } else if (layoutParams2.height == -1) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                } else {
                                    i9 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                                if (z2) {
                                    int i20 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    i7 = i18;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                                    if (i8 != i20) {
                                        childAt2.measure(makeMeasureSpec, i9);
                                    }
                                    i19++;
                                    i18 = i7;
                                    i6 = 8;
                                } else {
                                    i7 = i18;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i8 + ((int) ((layoutParams2.f4529a * ((float) Math.max(0, i15))) / f2)), 1073741824), i9);
                                    i19++;
                                    i18 = i7;
                                    i6 = 8;
                                }
                            }
                        } else if (layoutParams2.width < 0 && (i8 > i18 || layoutParams2.f4529a > 0.0f)) {
                            if (!z5) {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams2.height == -2) {
                                i11 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                i10 = 1073741824;
                            } else if (layoutParams2.height == -1) {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                            } else {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i18, i10), i11);
                        }
                    }
                }
                i7 = i18;
                i19++;
                i18 = i7;
                i6 = 8;
            }
        }
        setMeasuredDimension(size, i14 + getPaddingTop() + getPaddingBottom());
        this.n = z2;
        if (this.f4525g.f3234a != 0 && !z2) {
            this.f4525g.e();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean b2 = b();
        if (b2) {
            this.f4525g.f3238e = 2;
        } else {
            this.f4525g.f3238e = 1;
        }
        int i11 = i4 - i2;
        int paddingRight = b2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = b2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s) {
            this.f4521c = (!this.n || !this.f4526h) ? 0.0f : 1.0f;
        }
        int i12 = paddingRight;
        int i13 = i12;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f4530b) {
                    int i15 = i11 - paddingLeft;
                    int min = (Math.min(i12, i15 - this.m) - i13) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f4522d = min;
                    int i16 = b2 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f4531c = ((i13 + i16) + min) + (measuredWidth / 2) > i15;
                    int i17 = (int) (((float) min) * this.f4521c);
                    i7 = i16 + i17 + i13;
                    this.f4521c = ((float) i17) / ((float) this.f4522d);
                    i6 = 0;
                } else {
                    i6 = (!this.n || (i10 = this.f4524f) == 0) ? 0 : (int) ((1.0f - this.f4521c) * ((float) i10));
                    i7 = i12;
                }
                if (b2) {
                    i8 = (i11 - i7) + i6;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i7 - i6;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                i12 += childAt.getWidth();
                i13 = i7;
            }
        }
        if (this.s) {
            if (this.n) {
                if (this.f4524f != 0) {
                    a(this.f4521c);
                }
                if (((LayoutParams) this.f4520b.getLayoutParams()).f4531c) {
                    a(this.f4520b, this.f4521c, this.f4519a);
                }
            } else {
                for (int i18 = 0; i18 < childCount; i18++) {
                    a(getChildAt(i18), 0.0f, this.f4519a);
                }
            }
            a(this.f4520b);
        }
        this.s = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.s = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.n) {
            this.f4526h = view == this.f4520b;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.n && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f4526h = !androidx.customview.a.c.b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.n || (this.f4523e && actionMasked != 0)) {
            this.f4525g.d();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f4525g.d();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f4523e = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.p = x;
                this.q = y;
                if (androidx.customview.a.c.b(this.f4520b, (int) x, (int) y) && c(this.f4520b)) {
                    z = true;
                    if (!this.f4525g.a(motionEvent) || z) {
                        return true;
                    }
                    return false;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.p);
                float abs2 = Math.abs(y2 - this.q);
                if (abs > ((float) this.f4525g.f3235b) && abs2 > abs) {
                    this.f4525g.d();
                    this.f4523e = true;
                    return false;
                }
            }
            z = false;
            if (!this.f4525g.a(motionEvent)) {
            }
            return true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.n) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4525g.b(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.p = x;
            this.q = y;
        } else if (actionMasked == 1 && c(this.f4520b)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.p;
            float f3 = y2 - this.q;
            int i2 = this.f4525g.f3235b;
            if ((f2 * f2) + (f3 * f3) < ((float) (i2 * i2)) && androidx.customview.a.c.b(this.f4520b, (int) x2, (int) y2)) {
                c();
            }
        }
        return true;
    }

    private boolean c() {
        if (!this.s && !b(0.0f)) {
            return false;
        }
        this.f4526h = false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, float f2, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & 16777215);
            if (layoutParams.f4532d == null) {
                layoutParams.f4532d = new Paint();
            }
            layoutParams.f4532d.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f4532d);
            }
            b(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.f4532d != null) {
                layoutParams.f4532d.setColorFilter((ColorFilter) null);
            }
            b bVar = new b(view);
            this.f4527i.add(bVar);
            u.a((View) this, (Runnable) bVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.n && !layoutParams.f4530b && this.f4520b != null) {
            canvas.getClipBounds(this.t);
            if (b()) {
                Rect rect = this.t;
                rect.left = Math.max(rect.left, this.f4520b.getRight());
            } else {
                Rect rect2 = this.t;
                rect2.right = Math.min(rect2.right, this.f4520b.getLeft());
            }
            canvas.clipRect(this.t);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public final void b(View view) {
        Field field;
        if (Build.VERSION.SDK_INT >= 17) {
            u.a(view, ((LayoutParams) view.getLayoutParams()).f4532d);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.w) {
                try {
                    this.u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException unused) {
                }
                try {
                    this.v = View.class.getDeclaredField("mRecreateDisplayList");
                    this.v.setAccessible(true);
                } catch (NoSuchFieldException unused2) {
                }
                this.w = true;
            }
            if (this.u == null || (field = this.v) == null) {
                view.invalidate();
                return;
            } else {
                try {
                    field.setBoolean(view, true);
                    this.u.invoke(view, (Object[]) null);
                } catch (Exception unused3) {
                }
            }
        }
        u.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private boolean b(float f2) {
        int i2;
        if (!this.n) {
            return false;
        }
        boolean b2 = b();
        LayoutParams layoutParams = (LayoutParams) this.f4520b.getLayoutParams();
        if (b2) {
            i2 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f2 * ((float) this.f4522d))) + ((float) this.f4520b.getWidth())));
        } else {
            i2 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f2 * ((float) this.f4522d)));
        }
        androidx.customview.a.c cVar = this.f4525g;
        View view = this.f4520b;
        if (!cVar.a(view, i2, view.getTop())) {
            return false;
        }
        a();
        u.g(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f4525g.f()) {
            return;
        }
        if (!this.n) {
            this.f4525g.e();
        } else {
            u.g(this);
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.k = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.l = drawable;
    }

    @Deprecated
    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(androidx.core.content.b.a(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(androidx.core.content.b.a(getContext(), i2));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        super.draw(canvas);
        if (b()) {
            drawable = this.l;
        } else {
            drawable = this.k;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (b()) {
                i3 = childAt.getRight();
                i2 = intrinsicWidth + i3;
            } else {
                int left = childAt.getLeft();
                int i4 = left - intrinsicWidth;
                i2 = left;
                i3 = i4;
            }
            drawable.setBounds(i3, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.b()
            android.view.View r1 = r9.f4520b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.f4531c
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0058
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f4520b
            if (r4 == r5) goto L_0x0055
            float r5 = r9.o
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f4524f
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.o = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0043
            int r5 = -r5
        L_0x0043:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0055
            float r5 = r9.o
            if (r0 == 0) goto L_0x004e
            float r5 = r5 - r6
            goto L_0x0050
        L_0x004e:
            float r5 = r6 - r5
        L_0x0050:
            int r6 = r9.j
            r9.a(r4, r5, r6)
        L_0x0055:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(float):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean c(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.n || !layoutParams.f4531c || this.f4521c <= 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.n;
        savedState.f4533a = z ? !z || this.f4521c == 1.0f : this.f4526h;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        if (!savedState.f4533a) {
            c();
        } else if (this.s || b(1.0f)) {
            this.f4526h = true;
        }
        this.f4526h = savedState.f4533a;
    }

    class c extends c.a {
        c() {
        }

        public final boolean b(View view, int i2) {
            if (SlidingPaneLayout.this.f4523e) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f4530b;
        }

        public final void a(int i2) {
            if (SlidingPaneLayout.this.f4525g.f3234a != 0) {
                return;
            }
            if (SlidingPaneLayout.this.f4521c == 0.0f) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.a(slidingPaneLayout.f4520b);
                SlidingPaneLayout.this.sendAccessibilityEvent(32);
                SlidingPaneLayout.this.f4526h = false;
                return;
            }
            SlidingPaneLayout.this.sendAccessibilityEvent(32);
            SlidingPaneLayout.this.f4526h = true;
        }

        public final void a(View view, int i2) {
            SlidingPaneLayout.this.a();
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f4520b == null) {
                slidingPaneLayout.f4521c = 0.0f;
            } else {
                boolean b2 = slidingPaneLayout.b();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.f4520b.getLayoutParams();
                int width = slidingPaneLayout.f4520b.getWidth();
                if (b2) {
                    i2 = (slidingPaneLayout.getWidth() - i2) - width;
                }
                slidingPaneLayout.f4521c = ((float) (i2 - ((b2 ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft()) + (b2 ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) slidingPaneLayout.f4522d);
                if (slidingPaneLayout.f4524f != 0) {
                    slidingPaneLayout.a(slidingPaneLayout.f4521c);
                }
                if (layoutParams.f4531c) {
                    slidingPaneLayout.a(slidingPaneLayout.f4520b, slidingPaneLayout.f4521c, slidingPaneLayout.f4519a);
                }
            }
            SlidingPaneLayout.this.invalidate();
        }

        public final void a(View view, float f2, float f3) {
            int i2;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.b()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f2 < 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.f4521c > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f4522d;
                }
                i2 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f4520b.getWidth();
            } else {
                i2 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 > 0 || (i3 == 0 && SlidingPaneLayout.this.f4521c > 0.5f)) {
                    i2 += SlidingPaneLayout.this.f4522d;
                }
            }
            SlidingPaneLayout.this.f4525g.a(i2, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public final int a(View view) {
            return SlidingPaneLayout.this.f4522d;
        }

        public final int c(View view, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f4520b.getLayoutParams();
            if (SlidingPaneLayout.this.b()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f4520b.getWidth());
                return Math.max(Math.min(i2, width), width - SlidingPaneLayout.this.f4522d);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i2, paddingLeft), SlidingPaneLayout.this.f4522d + paddingLeft);
        }

        public final int d(View view, int i2) {
            return view.getTop();
        }

        public final void a(int i2, int i3) {
            SlidingPaneLayout.this.f4525g.a(SlidingPaneLayout.this.f4520b, i3);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f4528e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f4529a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        boolean f4530b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4531c;

        /* renamed from: d  reason: collision with root package name */
        Paint f4532d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4528e);
            this.f4529a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f4533a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel, (ClassLoader) null);
            this.f4533a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4533a ? 1 : 0);
        }
    }

    class a extends androidx.core.h.a {

        /* renamed from: b  reason: collision with root package name */
        private final Rect f4535b = new Rect();

        a() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
            androidx.core.h.a.c a2 = androidx.core.h.a.c.a(cVar);
            super.onInitializeAccessibilityNodeInfo(view, a2);
            Rect rect = this.f4535b;
            a2.a(rect);
            cVar.b(rect);
            a2.c(rect);
            cVar.d(rect);
            cVar.d(a2.b());
            cVar.a(a2.f3041a.getPackageName());
            cVar.b(a2.f3041a.getClassName());
            cVar.e(a2.f3041a.getContentDescription());
            cVar.i(a2.f3041a.isEnabled());
            cVar.g(a2.f3041a.isClickable());
            cVar.b(a2.f3041a.isFocusable());
            cVar.c(a2.f3041a.isFocused());
            cVar.e(a2.c());
            cVar.f(a2.f3041a.isSelected());
            cVar.h(a2.f3041a.isLongClickable());
            cVar.a(a2.f3041a.getActions());
            int movementGranularities = Build.VERSION.SDK_INT >= 16 ? a2.f3041a.getMovementGranularities() : 0;
            if (Build.VERSION.SDK_INT >= 16) {
                cVar.f3041a.setMovementGranularities(movementGranularities);
            }
            a2.f3041a.recycle();
            cVar.b((CharSequence) SlidingPaneLayout.class.getName());
            cVar.b(view);
            ViewParent k = u.k(view);
            if (k instanceof View) {
                cVar.d((View) k);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i2);
                if (!a(childAt) && childAt.getVisibility() == 0) {
                    u.c(childAt, 1);
                    cVar.c(childAt);
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!a(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private boolean a(View view) {
            return SlidingPaneLayout.this.c(view);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final View f4536a;

        b(View view) {
            this.f4536a = view;
        }

        public final void run() {
            if (this.f4536a.getParent() == SlidingPaneLayout.this) {
                this.f4536a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.b(this.f4536a);
            }
            SlidingPaneLayout.this.f4527i.remove(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return u.j(this) == 1;
    }
}
