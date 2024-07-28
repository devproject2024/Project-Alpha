package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.p;
import androidx.core.h.u;
import java.lang.reflect.Method;

public class ListPopupWindow implements p {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1553a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f1554b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f1555c;
    private DataSetObserver A;
    private Drawable B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;

    /* renamed from: d  reason: collision with root package name */
    private Context f1556d;

    /* renamed from: e  reason: collision with root package name */
    public DropDownListView f1557e;

    /* renamed from: f  reason: collision with root package name */
    int f1558f;

    /* renamed from: g  reason: collision with root package name */
    public int f1559g;

    /* renamed from: h  reason: collision with root package name */
    public int f1560h;

    /* renamed from: i  reason: collision with root package name */
    int f1561i;
    int j;
    public View k;
    public AdapterView.OnItemClickListener l;
    final e m;
    final Handler n;
    public boolean o;
    public PopupWindow p;
    private ListAdapter q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private View z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f1553a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            try {
                f1555c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                f1554b = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.r = -2;
        this.f1558f = -2;
        this.t = 1002;
        this.f1560h = 0;
        this.x = false;
        this.y = false;
        this.f1561i = Integer.MAX_VALUE;
        this.j = 0;
        this.m = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.f1556d = context;
        this.n = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i2, i3);
        this.f1559g = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.s = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.s != 0) {
            this.u = true;
        }
        obtainStyledAttributes.recycle();
        this.p = new AppCompatPopupWindow(context, attributeSet, i2, i3);
        this.p.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.A;
        if (dataSetObserver == null) {
            this.A = new b();
        } else {
            ListAdapter listAdapter2 = this.q;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.q = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.A);
        }
        DropDownListView dropDownListView = this.f1557e;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.q);
        }
    }

    public final void i() {
        this.o = true;
        this.p.setFocusable(true);
    }

    public final Drawable b() {
        return this.p.getBackground();
    }

    public final void a(Drawable drawable) {
        this.p.setBackgroundDrawable(drawable);
    }

    public final int f() {
        return this.f1559g;
    }

    public final void b(int i2) {
        this.f1559g = i2;
    }

    public final int c() {
        if (!this.u) {
            return 0;
        }
        return this.s;
    }

    public final void a(int i2) {
        this.s = i2;
        this.u = true;
    }

    public final void a(Rect rect) {
        this.I = rect != null ? new Rect(rect) : null;
    }

    public final void d(int i2) {
        Drawable background = this.p.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.f1558f = this.H.left + this.H.right + i2;
            return;
        }
        this.f1558f = i2;
    }

    public final void d() {
        this.p.dismiss();
        a();
        this.p.setContentView((View) null);
        this.f1557e = null;
        this.n.removeCallbacks(this.m);
    }

    public final void a(PopupWindow.OnDismissListener onDismissListener) {
        this.p.setOnDismissListener(onDismissListener);
    }

    private void a() {
        View view = this.z;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.z);
            }
        }
    }

    public final void j() {
        this.p.setInputMethodMode(2);
    }

    public final void k() {
        DropDownListView dropDownListView = this.f1557e;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public final boolean e() {
        return this.p.isShowing();
    }

    public final boolean l() {
        return this.p.getInputMethodMode() == 2;
    }

    public final ListView g() {
        return this.f1557e;
    }

    /* access modifiers changed from: package-private */
    public DropDownListView a(Context context, boolean z2) {
        return new DropDownListView(context, z2);
    }

    public final void n() {
        this.w = true;
        this.v = true;
    }

    class b extends DataSetObserver {
        b() {
        }

        public final void onChanged() {
            if (ListPopupWindow.this.p.isShowing()) {
                ListPopupWindow.this.a_();
            }
        }

        public final void onInvalidated() {
            ListPopupWindow.this.d();
        }
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            ListPopupWindow.this.k();
        }
    }

    class e implements Runnable {
        e() {
        }

        public final void run() {
            if (ListPopupWindow.this.f1557e != null && u.M(ListPopupWindow.this.f1557e) && ListPopupWindow.this.f1557e.getCount() > ListPopupWindow.this.f1557e.getChildCount() && ListPopupWindow.this.f1557e.getChildCount() <= ListPopupWindow.this.f1561i) {
                ListPopupWindow.this.p.setInputMethodMode(2);
                ListPopupWindow.this.a_();
            }
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.p != null && ListPopupWindow.this.p.isShowing() && x >= 0 && x < ListPopupWindow.this.p.getWidth() && y >= 0 && y < ListPopupWindow.this.p.getHeight()) {
                ListPopupWindow.this.n.postDelayed(ListPopupWindow.this.m, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.n.removeCallbacks(ListPopupWindow.this.m);
                return false;
            }
        }
    }

    class c implements AbsListView.OnScrollListener {
        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        c() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1 && !ListPopupWindow.this.l() && ListPopupWindow.this.p.getContentView() != null) {
                ListPopupWindow.this.n.removeCallbacks(ListPopupWindow.this.m);
                ListPopupWindow.this.m.run();
            }
        }
    }

    private int a(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.p.getMaxAvailableHeight(view, i2, z2);
        }
        Method method = f1554b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.p, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
            }
        }
        return this.p.getMaxAvailableHeight(view, i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v50, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v51, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_() {
        /*
            r15 = this;
            androidx.appcompat.widget.DropDownListView r0 = r15.f1557e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1
            r3 = 0
            r4 = -1
            if (r0 != 0) goto L_0x00b5
            android.content.Context r0 = r15.f1556d
            androidx.appcompat.widget.ListPopupWindow$1 r5 = new androidx.appcompat.widget.ListPopupWindow$1
            r5.<init>()
            r15.G = r5
            boolean r5 = r15.o
            r5 = r5 ^ r2
            androidx.appcompat.widget.DropDownListView r5 = r15.a(r0, r5)
            r15.f1557e = r5
            android.graphics.drawable.Drawable r5 = r15.B
            if (r5 == 0) goto L_0x0024
            androidx.appcompat.widget.DropDownListView r6 = r15.f1557e
            r6.setSelector(r5)
        L_0x0024:
            androidx.appcompat.widget.DropDownListView r5 = r15.f1557e
            android.widget.ListAdapter r6 = r15.q
            r5.setAdapter(r6)
            androidx.appcompat.widget.DropDownListView r5 = r15.f1557e
            android.widget.AdapterView$OnItemClickListener r6 = r15.l
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r15.f1557e
            r5.setFocusable(r2)
            androidx.appcompat.widget.DropDownListView r5 = r15.f1557e
            r5.setFocusableInTouchMode(r2)
            androidx.appcompat.widget.DropDownListView r5 = r15.f1557e
            androidx.appcompat.widget.ListPopupWindow$2 r6 = new androidx.appcompat.widget.ListPopupWindow$2
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r15.f1557e
            androidx.appcompat.widget.ListPopupWindow$c r6 = r15.E
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r15.C
            if (r5 == 0) goto L_0x0056
            androidx.appcompat.widget.DropDownListView r6 = r15.f1557e
            r6.setOnItemSelectedListener(r5)
        L_0x0056:
            androidx.appcompat.widget.DropDownListView r5 = r15.f1557e
            android.view.View r6 = r15.z
            if (r6 == 0) goto L_0x00ae
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r2)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r4, r3, r8)
            int r8 = r15.j
            if (r8 == 0) goto L_0x0085
            if (r8 == r2) goto L_0x007e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "Invalid hint position "
            r0.<init>(r5)
            int r5 = r15.j
            r0.append(r5)
            goto L_0x008b
        L_0x007e:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x008b
        L_0x0085:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x008b:
            int r0 = r15.f1558f
            if (r0 < 0) goto L_0x0092
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0094
        L_0x0092:
            r0 = 0
            r5 = 0
        L_0x0094:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r3)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00af
        L_0x00ae:
            r0 = 0
        L_0x00af:
            android.widget.PopupWindow r6 = r15.p
            r6.setContentView(r5)
            goto L_0x00d0
        L_0x00b5:
            android.widget.PopupWindow r0 = r15.p
            r0.getContentView()
            android.view.View r0 = r15.z
            if (r0 == 0) goto L_0x00cf
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00d0
        L_0x00cf:
            r0 = 0
        L_0x00d0:
            android.widget.PopupWindow r5 = r15.p
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f2
            android.graphics.Rect r6 = r15.H
            r5.getPadding(r6)
            android.graphics.Rect r5 = r15.H
            int r5 = r5.top
            android.graphics.Rect r6 = r15.H
            int r6 = r6.bottom
            int r5 = r5 + r6
            boolean r6 = r15.u
            if (r6 != 0) goto L_0x00f8
            android.graphics.Rect r6 = r15.H
            int r6 = r6.top
            int r6 = -r6
            r15.s = r6
            goto L_0x00f8
        L_0x00f2:
            android.graphics.Rect r5 = r15.H
            r5.setEmpty()
            r5 = 0
        L_0x00f8:
            android.widget.PopupWindow r6 = r15.p
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0103
            r6 = 1
            goto L_0x0104
        L_0x0103:
            r6 = 0
        L_0x0104:
            android.view.View r7 = r15.k
            int r8 = r15.s
            int r6 = r15.a(r7, r8, r6)
            boolean r7 = r15.x
            r8 = -2
            if (r7 != 0) goto L_0x0178
            int r7 = r15.r
            if (r7 != r4) goto L_0x0116
            goto L_0x0178
        L_0x0116:
            int r7 = r15.f1558f
            if (r7 == r8) goto L_0x013f
            r1 = 1073741824(0x40000000, float:2.0)
            if (r7 == r4) goto L_0x0124
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
        L_0x0122:
            r10 = r1
            goto L_0x015a
        L_0x0124:
            android.content.Context r7 = r15.f1556d
            android.content.res.Resources r7 = r7.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r7 = r7.widthPixels
            android.graphics.Rect r9 = r15.H
            int r9 = r9.left
            android.graphics.Rect r10 = r15.H
            int r10 = r10.right
            int r9 = r9 + r10
            int r7 = r7 - r9
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            goto L_0x0122
        L_0x013f:
            android.content.Context r7 = r15.f1556d
            android.content.res.Resources r7 = r7.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r7 = r7.widthPixels
            android.graphics.Rect r9 = r15.H
            int r9 = r9.left
            android.graphics.Rect r10 = r15.H
            int r10 = r10.right
            int r9 = r9 + r10
            int r7 = r7 - r9
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            goto L_0x0122
        L_0x015a:
            androidx.appcompat.widget.DropDownListView r9 = r15.f1557e
            r11 = 0
            r12 = -1
            int r13 = r6 - r0
            r14 = -1
            int r1 = r9.a(r10, r11, r12, r13, r14)
            if (r1 <= 0) goto L_0x0176
            androidx.appcompat.widget.DropDownListView r6 = r15.f1557e
            int r6 = r6.getPaddingTop()
            androidx.appcompat.widget.DropDownListView r7 = r15.f1557e
            int r7 = r7.getPaddingBottom()
            int r6 = r6 + r7
            int r5 = r5 + r6
            int r0 = r0 + r5
        L_0x0176:
            int r1 = r1 + r0
            goto L_0x017a
        L_0x0178:
            int r6 = r6 + r5
            r1 = r6
        L_0x017a:
            boolean r0 = r15.l()
            android.widget.PopupWindow r5 = r15.p
            int r6 = r15.t
            androidx.core.widget.g.a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r15.p
            boolean r5 = r5.isShowing()
            if (r5 == 0) goto L_0x01fa
            android.view.View r5 = r15.k
            boolean r5 = androidx.core.h.u.M(r5)
            if (r5 != 0) goto L_0x0196
            return
        L_0x0196:
            int r5 = r15.f1558f
            if (r5 != r4) goto L_0x019c
            r5 = -1
            goto L_0x01a4
        L_0x019c:
            if (r5 != r8) goto L_0x01a4
            android.view.View r5 = r15.k
            int r5 = r5.getWidth()
        L_0x01a4:
            int r6 = r15.r
            if (r6 != r4) goto L_0x01d2
            if (r0 == 0) goto L_0x01ab
            goto L_0x01ac
        L_0x01ab:
            r1 = -1
        L_0x01ac:
            if (r0 == 0) goto L_0x01c0
            android.widget.PopupWindow r0 = r15.p
            int r6 = r15.f1558f
            if (r6 != r4) goto L_0x01b6
            r6 = -1
            goto L_0x01b7
        L_0x01b6:
            r6 = 0
        L_0x01b7:
            r0.setWidth(r6)
            android.widget.PopupWindow r0 = r15.p
            r0.setHeight(r3)
            goto L_0x01d5
        L_0x01c0:
            android.widget.PopupWindow r0 = r15.p
            int r6 = r15.f1558f
            if (r6 != r4) goto L_0x01c8
            r6 = -1
            goto L_0x01c9
        L_0x01c8:
            r6 = 0
        L_0x01c9:
            r0.setWidth(r6)
            android.widget.PopupWindow r0 = r15.p
            r0.setHeight(r4)
            goto L_0x01d5
        L_0x01d2:
            if (r6 == r8) goto L_0x01d5
            r1 = r6
        L_0x01d5:
            android.widget.PopupWindow r0 = r15.p
            boolean r6 = r15.y
            if (r6 != 0) goto L_0x01e0
            boolean r6 = r15.x
            if (r6 != 0) goto L_0x01e0
            goto L_0x01e1
        L_0x01e0:
            r2 = 0
        L_0x01e1:
            r0.setOutsideTouchable(r2)
            android.widget.PopupWindow r6 = r15.p
            android.view.View r7 = r15.k
            int r8 = r15.f1559g
            int r9 = r15.s
            if (r5 >= 0) goto L_0x01f0
            r10 = -1
            goto L_0x01f1
        L_0x01f0:
            r10 = r5
        L_0x01f1:
            if (r1 >= 0) goto L_0x01f5
            r11 = -1
            goto L_0x01f6
        L_0x01f5:
            r11 = r1
        L_0x01f6:
            r6.update(r7, r8, r9, r10, r11)
            return
        L_0x01fa:
            int r0 = r15.f1558f
            if (r0 != r4) goto L_0x0200
            r0 = -1
            goto L_0x0208
        L_0x0200:
            if (r0 != r8) goto L_0x0208
            android.view.View r0 = r15.k
            int r0 = r0.getWidth()
        L_0x0208:
            int r5 = r15.r
            if (r5 != r4) goto L_0x020e
            r1 = -1
            goto L_0x0211
        L_0x020e:
            if (r5 == r8) goto L_0x0211
            r1 = r5
        L_0x0211:
            android.widget.PopupWindow r5 = r15.p
            r5.setWidth(r0)
            android.widget.PopupWindow r0 = r15.p
            r0.setHeight(r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 > r1) goto L_0x0233
            java.lang.reflect.Method r0 = f1553a
            if (r0 == 0) goto L_0x0238
            android.widget.PopupWindow r5 = r15.p     // Catch:{ Exception -> 0x0231 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0231 }
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0231 }
            r6[r3] = r7     // Catch:{ Exception -> 0x0231 }
            r0.invoke(r5, r6)     // Catch:{ Exception -> 0x0231 }
            goto L_0x0238
        L_0x0231:
            goto L_0x0238
        L_0x0233:
            android.widget.PopupWindow r0 = r15.p
            r0.setIsClippedToScreen(r2)
        L_0x0238:
            android.widget.PopupWindow r0 = r15.p
            boolean r5 = r15.y
            if (r5 != 0) goto L_0x0244
            boolean r5 = r15.x
            if (r5 != 0) goto L_0x0244
            r5 = 1
            goto L_0x0245
        L_0x0244:
            r5 = 0
        L_0x0245:
            r0.setOutsideTouchable(r5)
            android.widget.PopupWindow r0 = r15.p
            androidx.appcompat.widget.ListPopupWindow$d r5 = r15.D
            r0.setTouchInterceptor(r5)
            boolean r0 = r15.w
            if (r0 == 0) goto L_0x025a
            android.widget.PopupWindow r0 = r15.p
            boolean r5 = r15.v
            androidx.core.widget.g.a((android.widget.PopupWindow) r0, (boolean) r5)
        L_0x025a:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 > r1) goto L_0x0270
            java.lang.reflect.Method r0 = f1555c
            if (r0 == 0) goto L_0x0277
            android.widget.PopupWindow r1 = r15.p     // Catch:{ Exception -> 0x026e }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x026e }
            android.graphics.Rect r5 = r15.I     // Catch:{ Exception -> 0x026e }
            r2[r3] = r5     // Catch:{ Exception -> 0x026e }
            r0.invoke(r1, r2)     // Catch:{ Exception -> 0x026e }
            goto L_0x0277
        L_0x026e:
            goto L_0x0277
        L_0x0270:
            android.widget.PopupWindow r0 = r15.p
            android.graphics.Rect r1 = r15.I
            r0.setEpicenterBounds(r1)
        L_0x0277:
            android.widget.PopupWindow r0 = r15.p
            android.view.View r1 = r15.k
            int r2 = r15.f1559g
            int r3 = r15.s
            int r5 = r15.f1560h
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 19
            if (r6 < r7) goto L_0x028b
            r0.showAsDropDown(r1, r2, r3, r5)
            goto L_0x02a5
        L_0x028b:
            int r6 = androidx.core.h.u.j(r1)
            int r5 = androidx.core.h.e.a(r5, r6)
            r5 = r5 & 7
            r6 = 5
            if (r5 != r6) goto L_0x02a2
            int r5 = r0.getWidth()
            int r6 = r1.getWidth()
            int r5 = r5 - r6
            int r2 = r2 - r5
        L_0x02a2:
            r0.showAsDropDown(r1, r2, r3)
        L_0x02a5:
            androidx.appcompat.widget.DropDownListView r0 = r15.f1557e
            r0.setSelection(r4)
            boolean r0 = r15.o
            if (r0 == 0) goto L_0x02b6
            androidx.appcompat.widget.DropDownListView r0 = r15.f1557e
            boolean r0 = r0.isInTouchMode()
            if (r0 == 0) goto L_0x02b9
        L_0x02b6:
            r15.k()
        L_0x02b9:
            boolean r0 = r15.o
            if (r0 != 0) goto L_0x02c4
            android.os.Handler r0 = r15.n
            androidx.appcompat.widget.ListPopupWindow$a r1 = r15.F
            r0.post(r1)
        L_0x02c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.a_():void");
    }

    public final int m() {
        if (!this.p.isShowing()) {
            return -1;
        }
        return this.f1557e.getSelectedItemPosition();
    }
}
