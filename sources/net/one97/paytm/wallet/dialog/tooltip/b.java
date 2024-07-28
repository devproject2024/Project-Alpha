package net.one97.paytm.wallet.dialog.tooltip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import net.one97.paytm.wallet.R;

public class b implements PopupWindow.OnDismissListener {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f70330b = b.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f70331c = R.style.simpletooltip_default;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int f70332d = R.color.simpletooltip_background;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int f70333e = R.color.simpletooltip_text;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f70334f = R.color.simpletooltip_arrow;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final int f70335g = R.dimen.simpletooltip_margin;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final int f70336h = R.dimen.simpletooltip_padding;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final int f70337i = R.dimen.simpletooltip_animation_padding;
    /* access modifiers changed from: private */
    public static final int j = R.integer.simpletooltip_animation_duration;
    /* access modifiers changed from: private */
    public static final int k = R.dimen.simpletooltip_arrow_width;
    /* access modifiers changed from: private */
    public static final int l = R.dimen.simpletooltip_arrow_height;
    /* access modifiers changed from: private */
    public static final int m = R.dimen.simpletooltip_overlay_offset;
    /* access modifiers changed from: private */
    public final View A;
    private final boolean B;
    private final float C;
    private final boolean D;
    /* access modifiers changed from: private */
    public final float E;
    private View F;
    /* access modifiers changed from: private */
    public ViewGroup G;
    /* access modifiers changed from: private */
    public final boolean H;
    /* access modifiers changed from: private */
    public ImageView I;
    private final Drawable J;
    /* access modifiers changed from: private */
    public final boolean K;
    private AnimatorSet L;
    private final float M;
    private final float N;
    private final float O;
    private final long P;
    private final float Q;
    private final float R;
    private final boolean S;
    /* access modifiers changed from: private */
    public boolean T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private final View.OnTouchListener Y;
    private final ViewTreeObserver.OnGlobalLayoutListener Z;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f70338a;
    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener aa;
    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener ab;
    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener ac;
    private final ViewTreeObserver.OnGlobalLayoutListener ad;
    private final Context n;
    private C1417b o;
    /* access modifiers changed from: private */
    public c p;
    private final int q;
    /* access modifiers changed from: private */
    public final int r;
    /* access modifiers changed from: private */
    public final boolean s;
    /* access modifiers changed from: private */
    public final boolean t;
    /* access modifiers changed from: private */
    public final boolean u;
    /* access modifiers changed from: private */
    public final View v;
    /* access modifiers changed from: private */
    public View w;
    private final int x;
    private final int y;
    private final CharSequence z;

    /* renamed from: net.one97.paytm.wallet.dialog.tooltip.b$b  reason: collision with other inner class name */
    public interface C1417b {
    }

    public interface c {
    }

    /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }

    private b(a aVar) {
        LinearLayout.LayoutParams layoutParams;
        int i2 = 0;
        this.T = false;
        this.Y = new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return b.this.u;
            }
        };
        this.Z = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                PopupWindow e2 = b.this.f70338a;
                if (e2 != null && !b.this.T) {
                    if (b.this.E <= 0.0f || ((float) b.this.v.getWidth()) <= b.this.E) {
                        c.a(e2.getContentView(), (ViewTreeObserver.OnGlobalLayoutListener) this);
                        e2.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(b.this.aa);
                        PointF k = b.k(b.this);
                        e2.setClippingEnabled(true);
                        e2.update((int) k.x, (int) k.y, e2.getWidth(), e2.getHeight());
                        e2.getContentView().requestLayout();
                        b.l(b.this);
                        return;
                    }
                    View i2 = b.this.v;
                    float h2 = b.this.E;
                    ViewGroup.LayoutParams layoutParams = i2.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams((int) h2, i2.getHeight());
                    } else {
                        layoutParams.width = (int) h2;
                    }
                    i2.setLayoutParams(layoutParams);
                    e2.update(-2, -2);
                }
            }
        };
        this.aa = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                float f2;
                float f3;
                PopupWindow e2 = b.this.f70338a;
                if (e2 != null && !b.this.T) {
                    c.a(e2.getContentView(), (ViewTreeObserver.OnGlobalLayoutListener) this);
                    e2.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(b.this.ac);
                    e2.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(b.this.ab);
                    if (b.this.H) {
                        RectF a2 = c.a(b.this.A);
                        RectF a3 = c.a(b.this.w);
                        int i2 = -1;
                        if (b.this.r == 1 || b.this.r == 3) {
                            float paddingLeft = ((float) b.this.w.getPaddingLeft()) + c.a();
                            float width = ((a3.width() / 2.0f) - (((float) b.this.I.getWidth()) / 2.0f)) - (a3.centerX() - a2.centerX());
                            f3 = width > paddingLeft ? (((float) b.this.I.getWidth()) + width) + paddingLeft > a3.width() ? (a3.width() - ((float) b.this.I.getWidth())) - paddingLeft : width : paddingLeft;
                            float top = (float) b.this.I.getTop();
                            if (b.this.r != 3) {
                                i2 = 1;
                            }
                            f2 = ((float) i2) + top;
                        } else {
                            f2 = ((float) b.this.w.getPaddingTop()) + c.a();
                            float height = ((a3.height() / 2.0f) - (((float) b.this.I.getHeight()) / 2.0f)) - (a3.centerY() - a2.centerY());
                            if (height > f2) {
                                f2 = (((float) b.this.I.getHeight()) + height) + f2 > a3.height() ? (a3.height() - ((float) b.this.I.getHeight())) - f2 : height;
                            }
                            float left = (float) b.this.I.getLeft();
                            if (b.this.r != 2) {
                                i2 = 1;
                            }
                            f3 = left + ((float) i2);
                        }
                        ImageView r = b.this.I;
                        int i3 = (int) f3;
                        if (Build.VERSION.SDK_INT >= 11) {
                            r.setX((float) i3);
                        } else {
                            ViewGroup.MarginLayoutParams c2 = c.c(r);
                            c2.leftMargin = i3 - r.getLeft();
                            r.setLayoutParams(c2);
                        }
                        ImageView r2 = b.this.I;
                        int i4 = (int) f2;
                        if (Build.VERSION.SDK_INT >= 11) {
                            r2.setY((float) i4);
                        } else {
                            ViewGroup.MarginLayoutParams c3 = c.c(r2);
                            c3.topMargin = i4 - r2.getTop();
                            r2.setLayoutParams(c3);
                        }
                    }
                    e2.getContentView().requestLayout();
                }
            }
        };
        this.ab = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                PopupWindow e2 = b.this.f70338a;
                if (e2 != null && !b.this.T) {
                    c.a(e2.getContentView(), (ViewTreeObserver.OnGlobalLayoutListener) this);
                    if (b.this.p != null) {
                        c unused = b.this.p;
                    }
                    c unused2 = b.this.p = null;
                    b.this.w.setVisibility(0);
                }
            }
        };
        this.ac = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                PopupWindow e2 = b.this.f70338a;
                if (e2 != null && !b.this.T) {
                    c.a(e2.getContentView(), (ViewTreeObserver.OnGlobalLayoutListener) this);
                    if (b.this.K) {
                        b.v(b.this);
                    }
                    e2.getContentView().requestLayout();
                }
            }
        };
        this.ad = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (b.this.f70338a != null && !b.this.T && !b.this.G.isShown()) {
                    b.this.b();
                }
            }
        };
        this.n = aVar.f70348a;
        this.q = aVar.j;
        this.y = aVar.E;
        this.r = aVar.f70356i;
        this.s = aVar.f70349b;
        this.t = aVar.f70350c;
        this.u = aVar.f70351d;
        this.v = aVar.f70352e;
        this.x = aVar.f70353f;
        this.z = aVar.f70354g;
        this.A = aVar.f70355h;
        this.B = aVar.k;
        this.C = aVar.l;
        this.D = aVar.m;
        this.E = aVar.n;
        this.H = aVar.o;
        this.Q = aVar.y;
        this.R = aVar.x;
        this.J = aVar.p;
        this.K = aVar.q;
        this.M = aVar.r;
        this.N = aVar.s;
        this.O = aVar.t;
        this.P = aVar.w;
        this.o = aVar.u;
        this.p = aVar.v;
        this.S = aVar.z;
        ViewGroup viewGroup = (ViewGroup) this.A.getRootView();
        if (viewGroup.getChildCount() == 1 && (viewGroup.getChildAt(0) instanceof FrameLayout)) {
            viewGroup = (ViewGroup) viewGroup.getChildAt(0);
        }
        this.G = viewGroup;
        this.U = aVar.A;
        this.X = aVar.D;
        this.V = aVar.B;
        this.W = aVar.C;
        this.f70338a = new PopupWindow(this.n, (AttributeSet) null, 16842870);
        this.f70338a.setOnDismissListener(this);
        this.f70338a.setWidth(this.V);
        this.f70338a.setHeight(this.W);
        this.f70338a.setBackgroundDrawable(new ColorDrawable(0));
        this.f70338a.setOutsideTouchable(true);
        this.f70338a.setTouchable(true);
        this.f70338a.setTouchInterceptor(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (!b.this.t && motionEvent.getAction() == 0 && (x < 0 || x >= b.this.w.getMeasuredWidth() || y < 0 || y >= b.this.w.getMeasuredHeight())) {
                    return true;
                }
                if (!b.this.t && motionEvent.getAction() == 4) {
                    return true;
                }
                if (motionEvent.getAction() != 0 || !b.this.s) {
                    return false;
                }
                b.this.b();
                return true;
            }
        });
        this.f70338a.setClippingEnabled(false);
        this.f70338a.setFocusable(this.S);
        View view = this.v;
        if (view instanceof TextView) {
            ((TextView) view).setText(this.z);
        } else {
            TextView textView = (TextView) view.findViewById(this.x);
            if (textView != null) {
                textView.setText(this.z);
            }
        }
        View view2 = this.v;
        float f2 = this.N;
        view2.setPadding((int) f2, (int) f2, (int) f2, (int) f2);
        LinearLayout linearLayout = new LinearLayout(this.n);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int i3 = this.r;
        if (!(i3 == 0 || i3 == 2)) {
            i2 = 1;
        }
        linearLayout.setOrientation(i2);
        int i4 = (int) (this.K ? this.O : 0.0f);
        linearLayout.setPadding(i4, i4, i4, i4);
        if (this.H) {
            this.I = new ImageView(this.n);
            this.I.setImageDrawable(this.J);
            int i5 = this.r;
            if (i5 == 1 || i5 == 3) {
                layoutParams = new LinearLayout.LayoutParams((int) this.Q, (int) this.R, 0.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams((int) this.R, (int) this.Q, 0.0f);
            }
            layoutParams.gravity = 17;
            this.I.setLayoutParams(layoutParams);
            int i6 = this.r;
            if (i6 == 3 || i6 == 2) {
                linearLayout.addView(this.v);
                linearLayout.addView(this.I);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.V, this.W, 0.0f);
                layoutParams2.gravity = 17;
                this.v.setLayoutParams(layoutParams2);
                this.w = linearLayout;
                this.w.setVisibility(4);
                this.f70338a.setContentView(this.w);
            }
            linearLayout.addView(this.I);
        }
        linearLayout.addView(this.v);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(this.V, this.W, 0.0f);
        layoutParams22.gravity = 17;
        this.v.setLayoutParams(layoutParams22);
        this.w = linearLayout;
        this.w.setVisibility(4);
        this.f70338a.setContentView(this.w);
    }

    public final void b() {
        if (!this.T) {
            this.T = true;
            PopupWindow popupWindow = this.f70338a;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    public void onDismiss() {
        View view;
        AnimatorSet animatorSet;
        this.T = true;
        if (Build.VERSION.SDK_INT >= 11 && (animatorSet = this.L) != null) {
            animatorSet.removeAllListeners();
            this.L.end();
            this.L.cancel();
            this.L = null;
        }
        ViewGroup viewGroup = this.G;
        if (!(viewGroup == null || (view = this.F) == null)) {
            viewGroup.removeView(view);
        }
        this.G = null;
        this.F = null;
        this.o = null;
        c.a(this.f70338a.getContentView(), this.Z);
        c.a(this.f70338a.getContentView(), this.aa);
        c.a(this.f70338a.getContentView(), this.ab);
        c.a(this.f70338a.getContentView(), this.ac);
        c.a(this.f70338a.getContentView(), this.ad);
        this.f70338a = null;
    }

    public static class a {
        int A = 0;
        int B = -2;
        int C = -2;
        boolean D = false;
        int E = 0;
        private int F;
        private int G;
        private int H;

        /* renamed from: a  reason: collision with root package name */
        final Context f70348a;

        /* renamed from: b  reason: collision with root package name */
        boolean f70349b = true;

        /* renamed from: c  reason: collision with root package name */
        boolean f70350c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f70351d = false;

        /* renamed from: e  reason: collision with root package name */
        View f70352e;

        /* renamed from: f  reason: collision with root package name */
        int f70353f = 16908308;

        /* renamed from: g  reason: collision with root package name */
        CharSequence f70354g = "";

        /* renamed from: h  reason: collision with root package name */
        View f70355h;

        /* renamed from: i  reason: collision with root package name */
        int f70356i = 4;
        int j = 80;
        boolean k = true;
        float l = -1.0f;
        boolean m = true;
        float n;
        boolean o = true;
        Drawable p;
        boolean q = false;
        float r = -1.0f;
        float s = -1.0f;
        float t = -1.0f;
        C1417b u;
        c v;
        long w;
        float x;
        float y;
        boolean z;

        public a(Context context) {
            this.f70348a = context;
        }

        public final a a(CharSequence charSequence) {
            this.f70354g = charSequence;
            return this;
        }

        public final a a(View view) {
            this.f70355h = view;
            return this;
        }

        public final a b() {
            this.j = 48;
            return this;
        }

        public final a c() {
            this.q = false;
            return this;
        }

        public final a d() {
            this.o = false;
            return this;
        }

        public final b a() throws IllegalArgumentException {
            int i2;
            Context context = this.f70348a;
            if (context == null) {
                throw new IllegalArgumentException("Context not specified.");
            } else if (this.f70355h != null) {
                if (this.F == 0) {
                    this.F = c.a(context, b.f70332d);
                }
                if (this.E == 0) {
                    this.E = -16777216;
                }
                if (this.G == 0) {
                    this.G = c.a(this.f70348a, b.f70333e);
                }
                if (this.f70352e == null) {
                    TextView textView = new TextView(this.f70348a);
                    int f2 = b.f70331c;
                    if (Build.VERSION.SDK_INT >= 23) {
                        textView.setTextAppearance(f2);
                    } else {
                        textView.setTextAppearance(textView.getContext(), f2);
                    }
                    textView.setBackground(this.f70348a.getResources().getDrawable(R.drawable.ic_tooltip_2));
                    textView.setTextSize(12.0f);
                    textView.setTextColor(this.G);
                    this.f70352e = textView;
                }
                if (this.H == 0) {
                    this.H = c.a(this.f70348a, b.f70334f);
                }
                if (this.r < 0.0f) {
                    this.r = this.f70348a.getResources().getDimension(b.f70335g);
                }
                if (this.s < 0.0f) {
                    this.s = this.f70348a.getResources().getDimension(b.f70336h);
                }
                if (this.t < 0.0f) {
                    this.t = this.f70348a.getResources().getDimension(b.f70337i);
                }
                if (this.w == 0) {
                    this.w = (long) this.f70348a.getResources().getInteger(b.j);
                }
                if (Build.VERSION.SDK_INT < 11) {
                    this.q = false;
                }
                if (this.o) {
                    if (this.f70356i == 4) {
                        int i3 = this.j;
                        if (i3 != 17) {
                            if (i3 == 48) {
                                i2 = 3;
                            } else if (i3 != 80) {
                                if (i3 == 8388611) {
                                    i2 = 2;
                                } else if (i3 == 8388613) {
                                    i2 = 0;
                                } else {
                                    throw new IllegalArgumentException("Gravity must have be CENTER, START, END, TOP or BOTTOM.");
                                }
                            }
                            this.f70356i = i2;
                        }
                        i2 = 1;
                        this.f70356i = i2;
                    }
                    if (this.p == null) {
                        this.p = new a(this.H, this.f70356i);
                    }
                    if (this.y == 0.0f) {
                        this.y = this.f70348a.getResources().getDimension(b.k);
                    }
                    if (this.x == 0.0f) {
                        this.x = this.f70348a.getResources().getDimension(b.l);
                    }
                }
                int i4 = this.A;
                if (i4 < 0 || i4 > 1) {
                    this.A = 0;
                }
                if (this.l < 0.0f) {
                    this.l = this.f70348a.getResources().getDimension(b.m);
                }
                return new b(this, (byte) 0);
            } else {
                throw new IllegalArgumentException("Anchor view not specified.");
            }
        }
    }

    public final void a() {
        if (!this.T) {
            this.w.getViewTreeObserver().addOnGlobalLayoutListener(this.Z);
            this.w.getViewTreeObserver().addOnGlobalLayoutListener(this.ad);
            this.G.post(new Runnable() {
                public final void run() {
                    if (b.this.G.isShown()) {
                        b.this.f70338a.showAtLocation(b.this.G, 0, b.this.G.getWidth(), b.this.G.getHeight());
                    } else {
                        String unused = b.f70330b;
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("Tooltip has been dismissed.");
    }

    static /* synthetic */ PointF k(b bVar) {
        PointF pointF = new PointF();
        RectF b2 = c.b(bVar.A);
        PointF pointF2 = new PointF(b2.centerX(), b2.centerY());
        int i2 = bVar.q;
        if (i2 == 17) {
            pointF.x = pointF2.x - (((float) bVar.f70338a.getContentView().getWidth()) / 2.0f);
            pointF.y = pointF2.y - (((float) bVar.f70338a.getContentView().getHeight()) / 2.0f);
        } else if (i2 == 48) {
            pointF.x = pointF2.x - (((float) bVar.f70338a.getContentView().getWidth()) / 2.0f);
            pointF.y = (b2.top - ((float) bVar.f70338a.getContentView().getHeight())) - bVar.M;
        } else if (i2 == 80) {
            pointF.x = pointF2.x - (((float) bVar.f70338a.getContentView().getWidth()) / 2.0f);
            pointF.y = b2.bottom + bVar.M;
        } else if (i2 == 8388611) {
            pointF.x = (b2.left - ((float) bVar.f70338a.getContentView().getWidth())) - bVar.M;
            pointF.y = pointF2.y - (((float) bVar.f70338a.getContentView().getHeight()) / 2.0f);
        } else if (i2 == 8388613) {
            pointF.x = b2.right + bVar.M;
            pointF.y = pointF2.y - (((float) bVar.f70338a.getContentView().getHeight()) / 2.0f);
        } else {
            throw new IllegalArgumentException("Gravity must have be CENTER, START, END, TOP or BOTTOM.");
        }
        return pointF;
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void l(net.one97.paytm.wallet.dialog.tooltip.b r8) {
        /*
            boolean r0 = r8.X
            if (r0 != 0) goto L_0x0056
            boolean r0 = r8.B
            if (r0 == 0) goto L_0x0010
            android.view.View r0 = new android.view.View
            android.content.Context r1 = r8.n
            r0.<init>(r1)
            goto L_0x0020
        L_0x0010:
            net.one97.paytm.wallet.dialog.tooltip.OverlayView r0 = new net.one97.paytm.wallet.dialog.tooltip.OverlayView
            android.content.Context r3 = r8.n
            android.view.View r4 = r8.A
            int r5 = r8.U
            float r6 = r8.C
            int r7 = r8.y
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x0020:
            r8.F = r0
            boolean r0 = r8.D
            if (r0 == 0) goto L_0x0032
            android.view.View r0 = r8.F
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            r1.<init>(r2, r2)
            r0.setLayoutParams(r1)
            goto L_0x0048
        L_0x0032:
            android.view.View r0 = r8.F
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            android.view.ViewGroup r2 = r8.G
            int r2 = r2.getWidth()
            android.view.ViewGroup r3 = r8.G
            int r3 = r3.getHeight()
            r1.<init>(r2, r3)
            r0.setLayoutParams(r1)
        L_0x0048:
            android.view.View r0 = r8.F
            android.view.View$OnTouchListener r1 = r8.Y
            r0.setOnTouchListener(r1)
            android.view.ViewGroup r0 = r8.G
            android.view.View r8 = r8.F
            r0.addView(r8)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.dialog.tooltip.b.l(net.one97.paytm.wallet.dialog.tooltip.b):void");
    }

    static /* synthetic */ void v(b bVar) {
        int i2 = bVar.q;
        String str = (i2 == 48 || i2 == 80) ? "translationY" : "translationX";
        View view = bVar.w;
        float f2 = bVar.O;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, new float[]{-f2, f2});
        ofFloat.setDuration(bVar.P);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        View view2 = bVar.w;
        float f3 = bVar.O;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, str, new float[]{f3, -f3});
        ofFloat2.setDuration(bVar.P);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.L = new AnimatorSet();
        bVar.L.playSequentially(new Animator[]{ofFloat, ofFloat2});
        bVar.L.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                if (!b.this.T) {
                    b bVar = b.this;
                    if (bVar.f70338a != null && bVar.f70338a.isShowing()) {
                        animator.start();
                    }
                }
            }
        });
        bVar.L.start();
    }
}
