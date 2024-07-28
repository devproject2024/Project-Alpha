package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.ui.c;
import com.google.android.exoplayer2.y;
import com.google.android.exoplayer2.z;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

public class PlayerControlView extends FrameLayout {
    private final Drawable A;
    private final float B;
    private final float C;
    private final String D;
    private final String E;
    /* access modifiers changed from: private */
    public z F;
    /* access modifiers changed from: private */
    public d G;
    private c H;
    private b I;
    /* access modifiers changed from: private */
    public y J;
    private boolean K;
    private boolean L;
    private boolean M;
    /* access modifiers changed from: private */
    public boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    /* access modifiers changed from: private */
    public int S;
    private boolean T;
    private long U;
    private long[] V;
    private boolean[] W;

    /* renamed from: a  reason: collision with root package name */
    private final a f33541a;
    private long[] aa;
    private boolean[] ab;
    private long ac;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final View f33542b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final View f33543c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f33544d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f33545e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View f33546f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final View f33547g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f33548h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f33549i;
    private final View j;
    private final TextView k;
    /* access modifiers changed from: private */
    public final TextView l;
    private final c m;
    /* access modifiers changed from: private */
    public final StringBuilder n;
    /* access modifiers changed from: private */
    public final Formatter o;
    private final ah.a p;
    private final ah.b q;
    private final Runnable r;
    private final Runnable s;
    private final Drawable t;
    private final Drawable u;
    private final Drawable v;
    private final String w;
    private final String x;
    private final String y;
    private final Drawable z;

    public interface b {
    }

    public interface c {
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    static {
        n.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        int i3 = R.layout.exo_player_control_view;
        this.O = 5000;
        this.P = 15000;
        this.Q = 5000;
        this.S = 0;
        this.R = 200;
        this.U = -9223372036854775807L;
        this.T = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlayerControlView, 0, 0);
            try {
                this.O = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_rewind_increment, this.O);
                this.P = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_fastforward_increment, this.P);
                this.Q = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_show_timeout, this.Q);
                i3 = obtainStyledAttributes.getResourceId(R.styleable.PlayerControlView_controller_layout_id, i3);
                this.S = obtainStyledAttributes.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, this.S);
                this.T = obtainStyledAttributes.getBoolean(R.styleable.PlayerControlView_show_shuffle_button, this.T);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R.styleable.PlayerControlView_time_bar_min_update_interval, this.R));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.p = new ah.a();
        this.q = new ah.b();
        this.n = new StringBuilder();
        this.o = new Formatter(this.n, Locale.getDefault());
        this.V = new long[0];
        this.W = new boolean[0];
        this.aa = new long[0];
        this.ab = new boolean[0];
        this.f33541a = new a(this, (byte) 0);
        this.G = new e();
        this.r = new Runnable() {
            public final void run() {
                PlayerControlView.this.k();
            }
        };
        this.s = new Runnable() {
            public final void run() {
                PlayerControlView.this.b();
            }
        };
        LayoutInflater.from(context).inflate(i3, this);
        setDescendantFocusability(262144);
        c cVar = (c) findViewById(R.id.exo_progress);
        View findViewById = findViewById(R.id.exo_progress_placeholder);
        if (cVar != null) {
            this.m = cVar;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, (AttributeSet) null, 0, attributeSet2);
            defaultTimeBar.setId(R.id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.m = defaultTimeBar;
        } else {
            this.m = null;
        }
        this.k = (TextView) findViewById(R.id.exo_duration);
        this.l = (TextView) findViewById(R.id.exo_position);
        c cVar2 = this.m;
        if (cVar2 != null) {
            cVar2.a(this.f33541a);
        }
        this.f33544d = findViewById(R.id.exo_play);
        View view = this.f33544d;
        if (view != null) {
            view.setOnClickListener(this.f33541a);
        }
        this.f33545e = findViewById(R.id.exo_pause);
        View view2 = this.f33545e;
        if (view2 != null) {
            view2.setOnClickListener(this.f33541a);
        }
        this.f33542b = findViewById(R.id.exo_prev);
        View view3 = this.f33542b;
        if (view3 != null) {
            view3.setOnClickListener(this.f33541a);
        }
        this.f33543c = findViewById(R.id.exo_next);
        View view4 = this.f33543c;
        if (view4 != null) {
            view4.setOnClickListener(this.f33541a);
        }
        this.f33547g = findViewById(R.id.exo_rew);
        View view5 = this.f33547g;
        if (view5 != null) {
            view5.setOnClickListener(this.f33541a);
        }
        this.f33546f = findViewById(R.id.exo_ffwd);
        View view6 = this.f33546f;
        if (view6 != null) {
            view6.setOnClickListener(this.f33541a);
        }
        this.f33548h = (ImageView) findViewById(R.id.exo_repeat_toggle);
        ImageView imageView = this.f33548h;
        if (imageView != null) {
            imageView.setOnClickListener(this.f33541a);
        }
        this.f33549i = (ImageView) findViewById(R.id.exo_shuffle);
        ImageView imageView2 = this.f33549i;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.f33541a);
        }
        this.j = findViewById(R.id.exo_vr);
        setShowVrButton(false);
        Resources resources = context.getResources();
        this.B = ((float) resources.getInteger(R.integer.exo_media_button_opacity_percentage_enabled)) / 100.0f;
        this.C = ((float) resources.getInteger(R.integer.exo_media_button_opacity_percentage_disabled)) / 100.0f;
        this.t = resources.getDrawable(R.drawable.exo_controls_repeat_off);
        this.u = resources.getDrawable(R.drawable.exo_controls_repeat_one);
        this.v = resources.getDrawable(R.drawable.exo_controls_repeat_all);
        this.z = resources.getDrawable(R.drawable.exo_controls_shuffle_on);
        this.A = resources.getDrawable(R.drawable.exo_controls_shuffle_off);
        this.w = resources.getString(R.string.exo_controls_repeat_off_description);
        this.x = resources.getString(R.string.exo_controls_repeat_one_description);
        this.y = resources.getString(R.string.exo_controls_repeat_all_description);
        this.D = resources.getString(R.string.exo_controls_shuffle_on_description);
        this.E = resources.getString(R.string.exo_controls_shuffle_off_description);
    }

    public z getPlayer() {
        return this.F;
    }

    public void setPlayer(z zVar) {
        boolean z2 = true;
        com.google.android.exoplayer2.g.a.b(Looper.myLooper() == Looper.getMainLooper());
        if (!(zVar == null || zVar.j() == Looper.getMainLooper())) {
            z2 = false;
        }
        com.google.android.exoplayer2.g.a.a(z2);
        z zVar2 = this.F;
        if (zVar2 != zVar) {
            if (zVar2 != null) {
                zVar2.b((z.a) this.f33541a);
            }
            this.F = zVar;
            if (zVar != null) {
                zVar.a((z.a) this.f33541a);
            }
            e();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.L = z2;
        j();
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        boolean z2 = false;
        if (jArr == null) {
            this.aa = new long[0];
            this.ab = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.g.a.a(zArr);
            if (jArr.length == zArr2.length) {
                z2 = true;
            }
            com.google.android.exoplayer2.g.a.a(z2);
            this.aa = jArr;
            this.ab = zArr2;
        }
        j();
    }

    public void setVisibilityListener(c cVar) {
        this.H = cVar;
    }

    public void setProgressUpdateListener(b bVar) {
        this.I = bVar;
    }

    public void setPlaybackPreparer(y yVar) {
        this.J = yVar;
    }

    public void setControlDispatcher(d dVar) {
        if (dVar == null) {
            dVar = new e();
        }
        this.G = dVar;
    }

    public void setRewindIncrementMs(int i2) {
        this.O = i2;
        g();
    }

    public void setFastForwardIncrementMs(int i2) {
        this.P = i2;
        g();
    }

    public int getShowTimeoutMs() {
        return this.Q;
    }

    public void setShowTimeoutMs(int i2) {
        this.Q = i2;
        if (c()) {
            d();
        }
    }

    public int getRepeatToggleModes() {
        return this.S;
    }

    public void setRepeatToggleModes(int i2) {
        this.S = i2;
        z zVar = this.F;
        if (zVar != null) {
            int o2 = zVar.o();
            if (i2 == 0 && o2 != 0) {
                this.G.a(this.F, 0);
            } else if (i2 == 1 && o2 == 2) {
                this.G.a(this.F, 1);
            } else if (i2 == 2 && o2 == 1) {
                this.G.a(this.F, 2);
            }
        }
        h();
    }

    public boolean getShowShuffleButton() {
        return this.T;
    }

    public void setShowShuffleButton(boolean z2) {
        this.T = z2;
        i();
    }

    public boolean getShowVrButton() {
        View view = this.j;
        return view != null && view.getVisibility() == 0;
    }

    public void setShowVrButton(boolean z2) {
        View view = this.j;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.j;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.R = ae.a(i2, 16, 1000);
    }

    public final void a() {
        if (!c()) {
            setVisibility(0);
            if (this.H != null) {
                getVisibility();
            }
            e();
            l();
        }
        d();
    }

    public void b() {
        if (c()) {
            setVisibility(8);
            if (this.H != null) {
                getVisibility();
            }
            removeCallbacks(this.r);
            removeCallbacks(this.s);
            this.U = -9223372036854775807L;
        }
    }

    public final boolean c() {
        return getVisibility() == 0;
    }

    private void d() {
        removeCallbacks(this.s);
        if (this.Q > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = this.Q;
            this.U = uptimeMillis + ((long) i2);
            if (this.K) {
                postDelayed(this.s, (long) i2);
                return;
            }
            return;
        }
        this.U = -9223372036854775807L;
    }

    private void e() {
        f();
        g();
        h();
        i();
        j();
    }

    /* access modifiers changed from: private */
    public void f() {
        boolean z2;
        if (c() && this.K) {
            boolean m2 = m();
            View view = this.f33544d;
            int i2 = 8;
            boolean z3 = true;
            if (view != null) {
                z2 = (m2 && view.isFocused()) | false;
                this.f33544d.setVisibility(m2 ? 8 : 0);
            } else {
                z2 = false;
            }
            View view2 = this.f33545e;
            if (view2 != null) {
                if (m2 || !view2.isFocused()) {
                    z3 = false;
                }
                z2 |= z3;
                View view3 = this.f33545e;
                if (m2) {
                    i2 = 0;
                }
                view3.setVisibility(i2);
            }
            if (z2) {
                l();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r7 = this;
            boolean r0 = r7.c()
            if (r0 == 0) goto L_0x008b
            boolean r0 = r7.K
            if (r0 != 0) goto L_0x000c
            goto L_0x008b
        L_0x000c:
            com.google.android.exoplayer2.z r0 = r7.F
            r1 = 0
            if (r0 == 0) goto L_0x006c
            com.google.android.exoplayer2.ah r0 = r0.D()
            boolean r2 = r0.a()
            if (r2 != 0) goto L_0x006c
            com.google.android.exoplayer2.z r2 = r7.F
            boolean r2 = r2.w()
            if (r2 != 0) goto L_0x006c
            com.google.android.exoplayer2.z r2 = r7.F
            int r2 = r2.s()
            com.google.android.exoplayer2.ah$b r3 = r7.q
            r0.a((int) r2, (com.google.android.exoplayer2.ah.b) r3)
            com.google.android.exoplayer2.ah$b r0 = r7.q
            boolean r0 = r0.f31132d
            r2 = 1
            if (r0 != 0) goto L_0x0046
            com.google.android.exoplayer2.ah$b r3 = r7.q
            boolean r3 = r3.f31133e
            if (r3 == 0) goto L_0x0046
            com.google.android.exoplayer2.z r3 = r7.F
            boolean r3 = r3.b()
            if (r3 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r3 = 0
            goto L_0x0047
        L_0x0046:
            r3 = 1
        L_0x0047:
            if (r0 == 0) goto L_0x004f
            int r4 = r7.O
            if (r4 <= 0) goto L_0x004f
            r4 = 1
            goto L_0x0050
        L_0x004f:
            r4 = 0
        L_0x0050:
            if (r0 == 0) goto L_0x0058
            int r5 = r7.P
            if (r5 <= 0) goto L_0x0058
            r5 = 1
            goto L_0x0059
        L_0x0058:
            r5 = 0
        L_0x0059:
            com.google.android.exoplayer2.ah$b r6 = r7.q
            boolean r6 = r6.f31133e
            if (r6 != 0) goto L_0x0067
            com.google.android.exoplayer2.z r6 = r7.F
            boolean r6 = r6.c()
            if (r6 == 0) goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            r2 = r0
            r0 = r1
            r1 = r3
            goto L_0x0070
        L_0x006c:
            r0 = 0
            r2 = 0
            r4 = 0
            r5 = 0
        L_0x0070:
            android.view.View r3 = r7.f33542b
            r7.a((boolean) r1, (android.view.View) r3)
            android.view.View r1 = r7.f33547g
            r7.a((boolean) r4, (android.view.View) r1)
            android.view.View r1 = r7.f33546f
            r7.a((boolean) r5, (android.view.View) r1)
            android.view.View r1 = r7.f33543c
            r7.a((boolean) r0, (android.view.View) r1)
            com.google.android.exoplayer2.ui.c r0 = r7.m
            if (r0 == 0) goto L_0x008b
            r0.setEnabled(r2)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.g():void");
    }

    /* access modifiers changed from: private */
    public void h() {
        ImageView imageView;
        if (c() && this.K && (imageView = this.f33548h) != null) {
            if (this.S == 0) {
                imageView.setVisibility(8);
            } else if (this.F == null) {
                a(false, (View) imageView);
                this.f33548h.setImageDrawable(this.t);
                this.f33548h.setContentDescription(this.w);
            } else {
                a(true, (View) imageView);
                int o2 = this.F.o();
                if (o2 == 0) {
                    this.f33548h.setImageDrawable(this.t);
                    this.f33548h.setContentDescription(this.w);
                } else if (o2 == 1) {
                    this.f33548h.setImageDrawable(this.u);
                    this.f33548h.setContentDescription(this.x);
                } else if (o2 == 2) {
                    this.f33548h.setImageDrawable(this.v);
                    this.f33548h.setContentDescription(this.y);
                }
                this.f33548h.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        ImageView imageView;
        String str;
        ImageView imageView2;
        if (c() && this.K && (imageView = this.f33549i) != null) {
            if (!this.T) {
                imageView.setVisibility(8);
                return;
            }
            if (this.F == null) {
                a(false, (View) imageView);
                this.f33549i.setImageDrawable(this.A);
                imageView2 = this.f33549i;
            } else {
                a(true, (View) imageView);
                this.f33549i.setImageDrawable(this.F.p() ? this.z : this.A);
                imageView2 = this.f33549i;
                if (this.F.p()) {
                    str = this.D;
                    imageView2.setContentDescription(str);
                }
            }
            str = this.E;
            imageView2.setContentDescription(str);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        long j2;
        int i2;
        long j3;
        z zVar = this.F;
        if (zVar != null) {
            boolean z2 = false;
            boolean z3 = true;
            this.M = this.L && a(zVar.D(), this.q);
            this.ac = 0;
            ah D2 = this.F.D();
            if (!D2.a()) {
                int s2 = this.F.s();
                int i3 = this.M ? 0 : s2;
                int b2 = this.M ? D2.b() - 1 : s2;
                long j4 = 0;
                i2 = 0;
                while (true) {
                    if (i3 > b2) {
                        break;
                    }
                    if (i3 == s2) {
                        this.ac = com.google.android.exoplayer2.c.a(j4);
                    }
                    D2.a(i3, this.q);
                    long j5 = -9223372036854775807L;
                    if (this.q.f31137i == -9223372036854775807L) {
                        com.google.android.exoplayer2.g.a.b(this.M ^ z3);
                        break;
                    }
                    int i4 = this.q.f31134f;
                    while (i4 <= this.q.f31135g) {
                        D2.a(i4, this.p, z2);
                        int i5 = this.p.f31128f.f32791b;
                        int i6 = i2;
                        int i7 = 0;
                        while (i7 < i5) {
                            long a2 = this.p.a(i7);
                            if (a2 != Long.MIN_VALUE) {
                                j3 = a2;
                            } else if (this.p.f31126d != j5) {
                                j3 = this.p.f31126d;
                            } else {
                                i7++;
                                j5 = -9223372036854775807L;
                            }
                            long j6 = j3 + this.p.f31127e;
                            if (j6 >= 0 && j6 <= this.q.f31137i) {
                                long[] jArr = this.V;
                                if (i6 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.V = Arrays.copyOf(this.V, length);
                                    this.W = Arrays.copyOf(this.W, length);
                                }
                                this.V[i6] = com.google.android.exoplayer2.c.a(j6 + j4);
                                this.W[i6] = this.p.c(i7);
                                i6++;
                            }
                            i7++;
                            j5 = -9223372036854775807L;
                        }
                        i4++;
                        i2 = i6;
                        z2 = false;
                        j5 = -9223372036854775807L;
                    }
                    j4 += this.q.f31137i;
                    i3++;
                    z2 = false;
                    z3 = true;
                }
                j2 = j4;
            } else {
                i2 = 0;
                j2 = 0;
            }
            long a3 = com.google.android.exoplayer2.c.a(j2);
            TextView textView = this.k;
            if (textView != null) {
                textView.setText(ae.a(this.n, this.o, a3));
            }
            c cVar = this.m;
            if (cVar != null) {
                cVar.setDuration(a3);
                int length2 = this.aa.length;
                int i8 = i2 + length2;
                long[] jArr2 = this.V;
                if (i8 > jArr2.length) {
                    this.V = Arrays.copyOf(jArr2, i8);
                    this.W = Arrays.copyOf(this.W, i8);
                }
                System.arraycopy(this.aa, 0, this.V, i2, length2);
                System.arraycopy(this.ab, 0, this.W, i2, length2);
                this.m.setAdGroupTimesMs(this.V, this.W, i8);
            }
            k();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        long j2;
        if (c() && this.K) {
            z zVar = this.F;
            long j3 = 0;
            if (zVar != null) {
                j3 = this.ac + zVar.z();
                j2 = this.ac + this.F.A();
            } else {
                j2 = 0;
            }
            TextView textView = this.l;
            if (textView != null && !this.N) {
                textView.setText(ae.a(this.n, this.o, j3));
            }
            c cVar = this.m;
            if (cVar != null) {
                cVar.setPosition(j3);
                this.m.setBufferedPosition(j2);
            }
            removeCallbacks(this.r);
            z zVar2 = this.F;
            int k2 = zVar2 == null ? 1 : zVar2.k();
            long j4 = 1000;
            if (k2 == 3 && this.F.n()) {
                c cVar2 = this.m;
                long min = Math.min(cVar2 != null ? cVar2.getPreferredUpdateDelay() : 1000, 1000 - (j3 % 1000));
                float f2 = this.F.q().f33727b;
                if (f2 > 0.0f) {
                    j4 = (long) (((float) min) / f2);
                }
                postDelayed(this.r, ae.a(j4, (long) this.R, 1000));
            } else if (k2 != 4 && k2 != 1) {
                postDelayed(this.r, 1000);
            }
        }
    }

    private void l() {
        View view;
        View view2;
        boolean m2 = m();
        if (!m2 && (view2 = this.f33544d) != null) {
            view2.requestFocus();
        } else if (m2 && (view = this.f33545e) != null) {
            view.requestFocus();
        }
    }

    private void a(boolean z2, View view) {
        if (view != null) {
            view.setEnabled(z2);
            view.setAlpha(z2 ? this.B : this.C);
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void a(z zVar) {
        ah D2 = zVar.D();
        if (!D2.a() && !zVar.w()) {
            D2.a(zVar.s(), this.q);
            int e2 = zVar.e();
            if (e2 == -1 || (zVar.u() > 3000 && (!this.q.f31133e || this.q.f31132d))) {
                a(zVar, 0);
            } else {
                a(zVar, e2, -9223372036854775807L);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(z zVar) {
        ah D2 = zVar.D();
        if (!D2.a() && !zVar.w()) {
            int s2 = zVar.s();
            int d2 = zVar.d();
            if (d2 != -1) {
                a(zVar, d2, -9223372036854775807L);
            } else if (D2.a(s2, this.q).f31133e) {
                a(zVar, s2, -9223372036854775807L);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(z zVar) {
        if (zVar.f() && this.O > 0) {
            a(zVar, zVar.u() - ((long) this.O));
        }
    }

    /* access modifiers changed from: private */
    public void d(z zVar) {
        if (zVar.f() && this.P > 0) {
            a(zVar, zVar.u() + ((long) this.P));
        }
    }

    private void a(z zVar, long j2) {
        a(zVar, zVar.s(), j2);
    }

    private boolean a(z zVar, int i2, long j2) {
        long t2 = zVar.t();
        if (t2 != -9223372036854775807L) {
            j2 = Math.min(j2, t2);
        }
        return this.G.a(zVar, i2, Math.max(j2, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = true;
        long j2 = this.U;
        if (j2 != -9223372036854775807L) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                b();
            } else {
                postDelayed(this.s, uptimeMillis);
            }
        } else if (c()) {
            d();
        }
        e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.K = false;
        removeCallbacks(this.r);
        removeCallbacks(this.s);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.s);
        } else if (motionEvent.getAction() == 1) {
            d();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.F == null || !a(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                d(this.F);
            } else if (keyCode == 89) {
                c(this.F);
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    d dVar = this.G;
                    z zVar = this.F;
                    dVar.a(zVar, !zVar.n());
                } else if (keyCode == 87) {
                    b(this.F);
                } else if (keyCode == 88) {
                    a(this.F);
                } else if (keyCode == 126) {
                    this.G.a(this.F, true);
                } else if (keyCode == 127) {
                    this.G.a(this.F, false);
                }
            }
        }
        return true;
    }

    private boolean m() {
        z zVar = this.F;
        if (zVar == null || zVar.k() == 4 || this.F.k() == 1 || !this.F.n()) {
            return false;
        }
        return true;
    }

    private static boolean a(ah ahVar, ah.b bVar) {
        if (ahVar.b() > 100) {
            return false;
        }
        int b2 = ahVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            if (ahVar.a(i2, bVar).f31137i == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    final class a implements View.OnClickListener, c.a, z.a {
        public /* synthetic */ void a() {
            z.a.CC.$default$a(this);
        }

        public /* synthetic */ void a(i iVar) {
            z.a.CC.$default$a((z.a) this, iVar);
        }

        public /* synthetic */ void a(boolean z) {
            z.a.CC.$default$a((z.a) this, z);
        }

        public /* synthetic */ void b(boolean z) {
            z.a.CC.$default$b(this, z);
        }

        public /* synthetic */ void e() {
            z.a.CC.$default$e(this);
        }

        public /* synthetic */ void f() {
            z.a.CC.$default$f(this);
        }

        private a() {
        }

        /* synthetic */ a(PlayerControlView playerControlView, byte b2) {
            this();
        }

        public final void a(long j) {
            boolean unused = PlayerControlView.this.N = true;
            if (PlayerControlView.this.l != null) {
                PlayerControlView.this.l.setText(ae.a(PlayerControlView.this.n, PlayerControlView.this.o, j));
            }
        }

        public final void b(long j) {
            if (PlayerControlView.this.l != null) {
                PlayerControlView.this.l.setText(ae.a(PlayerControlView.this.n, PlayerControlView.this.o, j));
            }
        }

        public final void a(long j, boolean z) {
            boolean unused = PlayerControlView.this.N = false;
            if (!z && PlayerControlView.this.F != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                PlayerControlView.a(playerControlView, playerControlView.F, j);
            }
        }

        public final void a(int i2) {
            PlayerControlView.this.f();
            PlayerControlView.this.k();
        }

        public final void b() {
            PlayerControlView.this.h();
            PlayerControlView.this.g();
        }

        public final void c() {
            PlayerControlView.this.i();
            PlayerControlView.this.g();
        }

        public final void d() {
            PlayerControlView.this.g();
            PlayerControlView.this.j();
        }

        public final void a(ah ahVar) {
            PlayerControlView.this.g();
            PlayerControlView.this.j();
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x00ca A[LOOP:0: B:38:0x00ad->B:52:0x00ca, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                com.google.android.exoplayer2.ui.PlayerControlView r0 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.z r0 = r0.F
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.view.View r1 = r1.f33543c
                if (r1 != r9) goto L_0x0017
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                r9.b((com.google.android.exoplayer2.z) r0)
                return
            L_0x0017:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.view.View r1 = r1.f33542b
                if (r1 != r9) goto L_0x0025
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                r9.a((com.google.android.exoplayer2.z) r0)
                return
            L_0x0025:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.view.View r1 = r1.f33546f
                if (r1 != r9) goto L_0x0033
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                r9.d((com.google.android.exoplayer2.z) r0)
                return
            L_0x0033:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.view.View r1 = r1.f33547g
                if (r1 != r9) goto L_0x0041
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                r9.c((com.google.android.exoplayer2.z) r0)
                return
            L_0x0041:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.view.View r1 = r1.f33544d
                r2 = 1
                if (r1 != r9) goto L_0x0081
                int r9 = r0.k()
                if (r9 != r2) goto L_0x005e
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.y r9 = r9.J
                if (r9 == 0) goto L_0x0077
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.y unused = r9.J
                goto L_0x0077
            L_0x005e:
                int r9 = r0.k()
                r1 = 4
                if (r9 != r1) goto L_0x0077
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.d r9 = r9.G
                int r1 = r0.s()
                r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r9.a(r0, r1, r3)
            L_0x0077:
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.d r9 = r9.G
                r9.a((com.google.android.exoplayer2.z) r0, (boolean) r2)
                return
            L_0x0081:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.view.View r1 = r1.f33545e
                r3 = 0
                if (r1 != r9) goto L_0x0094
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.d r9 = r9.G
                r9.a((com.google.android.exoplayer2.z) r0, (boolean) r3)
                return
            L_0x0094:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.widget.ImageView r1 = r1.f33548h
                if (r1 != r9) goto L_0x00d1
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.d r9 = r9.G
                int r1 = r0.o()
                com.google.android.exoplayer2.ui.PlayerControlView r4 = com.google.android.exoplayer2.ui.PlayerControlView.this
                int r4 = r4.S
                r5 = 1
            L_0x00ad:
                r6 = 2
                if (r5 > r6) goto L_0x00cd
                int r7 = r1 + r5
                int r7 = r7 % 3
                if (r7 == 0) goto L_0x00c5
                if (r7 == r2) goto L_0x00c1
                if (r7 == r6) goto L_0x00bc
            L_0x00ba:
                r6 = 0
                goto L_0x00c6
            L_0x00bc:
                r6 = r4 & 2
                if (r6 == 0) goto L_0x00ba
                goto L_0x00c5
            L_0x00c1:
                r6 = r4 & 1
                if (r6 == 0) goto L_0x00ba
            L_0x00c5:
                r6 = 1
            L_0x00c6:
                if (r6 == 0) goto L_0x00ca
                r1 = r7
                goto L_0x00cd
            L_0x00ca:
                int r5 = r5 + 1
                goto L_0x00ad
            L_0x00cd:
                r9.a((com.google.android.exoplayer2.z) r0, (int) r1)
                return
            L_0x00d1:
                com.google.android.exoplayer2.ui.PlayerControlView r1 = com.google.android.exoplayer2.ui.PlayerControlView.this
                android.widget.ImageView r1 = r1.f33549i
                if (r1 != r9) goto L_0x00e7
                com.google.android.exoplayer2.ui.PlayerControlView r9 = com.google.android.exoplayer2.ui.PlayerControlView.this
                com.google.android.exoplayer2.d r9 = r9.G
                boolean r1 = r0.p()
                r1 = r1 ^ r2
                r9.b(r0, r1)
            L_0x00e7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.a.onClick(android.view.View):void");
        }
    }

    static /* synthetic */ void a(PlayerControlView playerControlView, z zVar, long j2) {
        int i2;
        ah D2 = zVar.D();
        if (!playerControlView.M || D2.a()) {
            i2 = zVar.s();
        } else {
            int b2 = D2.b();
            i2 = 0;
            while (true) {
                long a2 = com.google.android.exoplayer2.c.a(D2.a(i2, playerControlView.q).f31137i);
                if (j2 < a2) {
                    break;
                } else if (i2 == b2 - 1) {
                    j2 = a2;
                    break;
                } else {
                    j2 -= a2;
                    i2++;
                }
            }
        }
        if (!playerControlView.a(zVar, i2, j2)) {
            playerControlView.k();
        }
    }
}
