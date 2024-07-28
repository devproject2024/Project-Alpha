package net.one97.paytm.games.view.pfg.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.u;
import java.lang.reflect.Constructor;
import kotlin.g.b.k;
import net.one97.paytm.games.R;

public final class KSwipeRefreshLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private View f35749a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f35750b;

    /* renamed from: c  reason: collision with root package name */
    private c f35751c;

    /* renamed from: d  reason: collision with root package name */
    private View f35752d;

    /* renamed from: e  reason: collision with root package name */
    private c f35753e;

    /* renamed from: f  reason: collision with root package name */
    private e f35754f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f35755g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f35756h;

    /* renamed from: i  reason: collision with root package name */
    private float f35757i;
    private b j;

    public KSwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public KSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSwipeRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35754f = e.DEFAULT;
        this.f35755g = true;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.KSwipeRefreshLayout);
        int i3 = obtainStyledAttributes.getInt(R.styleable.KSwipeRefreshLayout_refreshMode, 0);
        String string = obtainStyledAttributes.getString(R.styleable.KSwipeRefreshLayout_refreshView);
        String string2 = obtainStyledAttributes.getString(R.styleable.KSwipeRefreshLayout_loadView);
        setMode(i3);
        if (string == null) {
            try {
                k.a();
            } catch (Exception unused) {
            }
        }
        Class<?> cls = Class.forName(string);
        k.a((Object) cls, "Class.forName(refreshViewName!!)");
        Constructor<?> constructor = cls.getConstructor(new Class[]{Context.class});
        k.a((Object) constructor, "clazz.getConstructor(Context::class.java)");
        Object newInstance = constructor.newInstance(new Object[]{getContext()});
        if (newInstance instanceof View) {
            setRefreshView((View) newInstance);
        }
        if (string2 == null) {
            try {
                k.a();
            } catch (Exception unused2) {
            }
        }
        Class<?> cls2 = Class.forName(string2);
        k.a((Object) cls2, "Class.forName(loadViewName!!)");
        Constructor<?> constructor2 = cls2.getConstructor(new Class[]{Context.class});
        k.a((Object) constructor2, "clazz.getConstructor(Context::class.java)");
        Object newInstance2 = constructor2.newInstance(new Object[]{getContext()});
        if (newInstance2 instanceof View) {
            setLoadView((View) newInstance2);
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = getChildAt(i2);
                if ((!k.a((Object) childAt, (Object) this.f35750b)) && (!k.a((Object) childAt, (Object) this.f35752d))) {
                    this.f35749a = childAt;
                    return;
                } else if (i2 != childCount) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f35750b;
        if (view != null) {
            measureChildWithMargins(view, i2, 0, i3, 0);
        }
        View view2 = this.f35749a;
        if (view2 != null) {
            measureChildWithMargins(view2, i2, 0, i3, 0);
        }
        View view3 = this.f35752d;
        if (view3 != null) {
            measureChildWithMargins(view3, i2, 0, i3, 0);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, "ev");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f35757i = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.f35757i;
            if ((rawY > 10.0f && a()) || (rawY < -10.0f && b())) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r0 != 3) goto L_0x0116;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r9, r0)
            int r0 = r9.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x011b
            r2 = 0
            r3 = 2
            if (r0 == r1) goto L_0x00b8
            r4 = 3
            if (r0 == r3) goto L_0x0017
            if (r0 == r4) goto L_0x00b8
            goto L_0x0116
        L_0x0017:
            float r0 = r9.getRawY()
            float r5 = r8.f35757i
            float r0 = r0 - r5
            int r5 = a((float) r0)
            net.one97.paytm.games.view.pfg.refresh.e r6 = r8.f35754f
            int[] r7 = net.one97.paytm.games.view.pfg.refresh.a.f35760b
            int r6 = r6.ordinal()
            r6 = r7[r6]
            r7 = 0
            if (r6 == r1) goto L_0x0077
            if (r6 == r3) goto L_0x0056
            if (r6 == r4) goto L_0x0035
            goto L_0x0116
        L_0x0035:
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x004b
            boolean r0 = r8.b()
            if (r0 == 0) goto L_0x004b
            r8.b(r5)
            net.one97.paytm.games.view.pfg.refresh.c r0 = r8.f35753e
            if (r0 == 0) goto L_0x0116
            r0.a(r5)
            goto L_0x0116
        L_0x004b:
            r8.b(r2)
            float r0 = r9.getRawY()
            r8.f35757i = r0
            goto L_0x0116
        L_0x0056:
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x006c
            boolean r0 = r8.a()
            if (r0 == 0) goto L_0x006c
            r8.b(r5)
            net.one97.paytm.games.view.pfg.refresh.c r0 = r8.f35751c
            if (r0 == 0) goto L_0x0116
            r0.a(r5)
            goto L_0x0116
        L_0x006c:
            r8.b(r2)
            float r0 = r9.getRawY()
            r8.f35757i = r0
            goto L_0x0116
        L_0x0077:
            int r2 = a((float) r0)
            r8.b(r2)
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0085
            net.one97.paytm.games.view.pfg.refresh.e r0 = net.one97.paytm.games.view.pfg.refresh.e.DOWNPULL
            goto L_0x0087
        L_0x0085:
            net.one97.paytm.games.view.pfg.refresh.e r0 = net.one97.paytm.games.view.pfg.refresh.e.UPPULL
        L_0x0087:
            r8.f35754f = r0
            net.one97.paytm.games.view.pfg.refresh.e r0 = r8.f35754f
            int[] r2 = net.one97.paytm.games.view.pfg.refresh.a.f35759a
            int r0 = r0.ordinal()
            r0 = r2[r0]
            if (r0 == r1) goto L_0x00a9
            if (r0 == r3) goto L_0x0099
            goto L_0x0116
        L_0x0099:
            net.one97.paytm.games.view.pfg.refresh.c r0 = r8.f35753e
            if (r0 == 0) goto L_0x00a0
            r0.a()
        L_0x00a0:
            net.one97.paytm.games.view.pfg.refresh.c r0 = r8.f35753e
            if (r0 == 0) goto L_0x0116
            r0.a(r5)
            goto L_0x0116
        L_0x00a9:
            net.one97.paytm.games.view.pfg.refresh.c r0 = r8.f35751c
            if (r0 == 0) goto L_0x00b0
            r0.a()
        L_0x00b0:
            net.one97.paytm.games.view.pfg.refresh.c r0 = r8.f35751c
            if (r0 == 0) goto L_0x0116
            r0.a(r5)
            goto L_0x0116
        L_0x00b8:
            float r0 = r9.getRawY()
            float r4 = r8.f35757i
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            int r0 = a((float) r0)
            net.one97.paytm.games.view.pfg.refresh.e r4 = r8.f35754f
            int[] r5 = net.one97.paytm.games.view.pfg.refresh.a.f35761c
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r1) goto L_0x0101
            if (r4 == r3) goto L_0x00d8
            goto L_0x0116
        L_0x00d8:
            android.view.View r1 = r8.f35752d
            if (r1 == 0) goto L_0x00e0
            int r5 = r1.getMeasuredHeight()
        L_0x00e0:
            if (r0 <= r5) goto L_0x00f9
            int r0 = -r5
            r8.b(r0)
            net.one97.paytm.games.view.pfg.refresh.e r0 = net.one97.paytm.games.view.pfg.refresh.e.REFRESHING
            r8.f35754f = r0
            net.one97.paytm.games.view.pfg.refresh.b r0 = r8.j
            if (r0 == 0) goto L_0x00f1
            r0.b()
        L_0x00f1:
            net.one97.paytm.games.view.pfg.refresh.c r0 = r8.f35753e
            if (r0 == 0) goto L_0x0116
            r0.b()
            goto L_0x0116
        L_0x00f9:
            net.one97.paytm.games.view.pfg.refresh.e r0 = net.one97.paytm.games.view.pfg.refresh.e.DEFAULT
            r8.f35754f = r0
            r8.b(r2)
            goto L_0x0116
        L_0x0101:
            android.view.View r1 = r8.f35750b
            if (r1 == 0) goto L_0x0109
            int r5 = r1.getMeasuredHeight()
        L_0x0109:
            if (r0 <= r5) goto L_0x010f
            r8.a((int) r5)
            goto L_0x0116
        L_0x010f:
            net.one97.paytm.games.view.pfg.refresh.e r0 = net.one97.paytm.games.view.pfg.refresh.e.DEFAULT
            r8.f35754f = r0
            r8.b(r2)
        L_0x0116:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L_0x011b:
            float r9 = r9.getRawY()
            r8.f35757i = r9
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.view.pfg.refresh.KSwipeRefreshLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        b(i2);
        this.f35754f = e.REFRESHING;
        b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
        c cVar = this.f35751c;
        if (cVar != null) {
            cVar.b();
        }
    }

    private static int a(float f2) {
        float abs = Math.abs(f2);
        float f3 = (0.25f * abs) + ((abs * 100.0f) / (abs + 100.0f));
        return f2 > 0.0f ? (int) f3 : (int) (-f3);
    }

    public final void setRefreshView(View view) {
        if (view != null) {
            View view2 = this.f35750b;
            if (view2 != null) {
                removeView(view2);
            }
            this.f35750b = view;
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
            addView(view);
            if (view instanceof c) {
                this.f35751c = (c) view;
            }
        }
    }

    public final void setLoadView(View view) {
        if (view != null) {
            View view2 = this.f35752d;
            if (view2 != null) {
                removeView(view2);
            }
            this.f35752d = view;
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
            addView(view);
            if (view instanceof c) {
                this.f35753e = (c) view;
            }
        }
    }

    private final boolean a() {
        return !u.b(this.f35749a, -1) && this.f35755g && this.f35750b != null;
    }

    private final boolean b() {
        if (u.b(this.f35749a, 1) || !this.f35756h || this.f35752d == null) {
            return false;
        }
        return true;
    }

    private final void b(int i2) {
        if (this.f35749a != null) {
            if (i2 != 0 || this.f35754f != e.REFRESHING) {
                View view = this.f35750b;
                if (view != null) {
                    int paddingLeft = getPaddingLeft();
                    int paddingTop = (getPaddingTop() - view.getMeasuredHeight()) + i2;
                    view.layout(paddingLeft, paddingTop, getMeasuredWidth() - getPaddingRight(), view.getMeasuredHeight() + paddingTop);
                }
                View view2 = this.f35749a;
                if (view2 != null) {
                    view2.layout(getPaddingLeft(), getPaddingTop() + i2, getMeasuredWidth() - getPaddingRight(), (getMeasuredHeight() - getPaddingBottom()) + i2);
                }
                View view3 = this.f35752d;
                if (view3 != null) {
                    int paddingLeft2 = getPaddingLeft();
                    int measuredHeight = (getMeasuredHeight() - getPaddingBottom()) + i2;
                    view3.layout(paddingLeft2, measuredHeight, getMeasuredWidth() - getPaddingRight(), view3.getMeasuredHeight() + measuredHeight);
                }
            }
        }
    }

    public final void setOnRefreshListener(b bVar) {
        k.c(bVar, "refreshListener");
        this.j = bVar;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KSwipeRefreshLayout f35758a;

        a(KSwipeRefreshLayout kSwipeRefreshLayout) {
            this.f35758a = kSwipeRefreshLayout;
        }

        public final void run() {
            View a2 = this.f35758a.f35750b;
            this.f35758a.a(a2 != null ? a2.getMeasuredHeight() : 200);
        }
    }

    public final void setRefresh(boolean z) {
        c cVar;
        if (z) {
            new Handler().postDelayed(new a(this), 50);
            return;
        }
        int i2 = a.f35762d[this.f35754f.ordinal()];
        if (i2 == 1) {
            c cVar2 = this.f35751c;
            if (cVar2 != null) {
                cVar2.c();
            }
        } else if (i2 == 2 && (cVar = this.f35753e) != null) {
            cVar.c();
        }
        this.f35754f = e.DEFAULT;
        b(0);
    }

    public final void setRefreshMode(d dVar) {
        k.c(dVar, "mode");
        setMode(dVar.getMode());
    }

    private final void setMode(int i2) {
        if (i2 == 0) {
            this.f35755g = true;
            this.f35756h = false;
        } else if (i2 == 1) {
            this.f35755g = false;
            this.f35756h = true;
        } else if (i2 != 2) {
            this.f35755g = false;
            this.f35756h = false;
        } else {
            this.f35755g = true;
            this.f35756h = true;
        }
    }

    /* access modifiers changed from: protected */
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        k.c(layoutParams, "p");
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        k.c(attributeSet, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b(0);
    }
}
