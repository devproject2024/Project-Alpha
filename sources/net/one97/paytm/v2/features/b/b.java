package net.one97.paytm.v2.features.b;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.R;

public final class b implements View.OnTouchListener {

    /* renamed from: f  reason: collision with root package name */
    public static final a f20073f = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String q;
    private static final int r = 20;
    /* access modifiers changed from: private */
    public static final int s = 100;
    /* access modifiers changed from: private */
    public static final int t = 100;

    /* renamed from: a  reason: collision with root package name */
    final a f20074a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f20075b;

    /* renamed from: c  reason: collision with root package name */
    Float f20076c;

    /* renamed from: d  reason: collision with root package name */
    Float f20077d;

    /* renamed from: e  reason: collision with root package name */
    public View f20078e;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f20079g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f20080h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20081i;
    private final GestureDetector j;
    private Context k;
    private int l;
    private Integer m;
    private Integer n;
    private Integer o;
    private Integer p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(Context context, a aVar) {
        k.c(context, "ctx");
        k.c(aVar, "swipeListener");
        this.j = new GestureDetector(context, new C0358b());
        this.k = context;
        this.f20074a = aVar;
    }

    static {
        String name = b.class.getName();
        k.a((Object) name, "ScratchCardTouchListener::class.java.name");
        q = name;
    }

    public final View a() {
        View view = this.f20078e;
        if (view == null) {
            k.a("containerView");
        }
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b9, code lost:
        if (java.lang.Math.abs(((float) r2.intValue()) - r12.getY()) > ((float) r)) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            java.lang.String r0 = "containerView"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r12, r0)
            r10.f20078e = r11
            float r0 = r12.getRawX()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.o = r0
            float r0 = r12.getRawY()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.p = r0
            java.lang.Float r0 = r10.f20076c
            if (r0 != 0) goto L_0x0030
            float r0 = r11.getX()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r10.f20076c = r0
        L_0x0030:
            java.lang.Float r0 = r10.f20077d
            if (r0 != 0) goto L_0x003e
            float r0 = r11.getY()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r10.f20077d = r0
        L_0x003e:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            android.content.Context r1 = r10.k
            if (r1 == 0) goto L_0x0294
            android.app.Activity r1 = (android.app.Activity) r1
            android.view.WindowManager r1 = r1.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            r1.getMetrics(r0)
            int r0 = r0.widthPixels
            int r1 = r0 / 2
            java.lang.Float r2 = r10.f20076c
            if (r2 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            float r2 = r2.floatValue()
            r11.setX(r2)
            java.lang.Float r2 = r10.f20077d
            if (r2 != 0) goto L_0x006d
            kotlin.g.b.k.a()
        L_0x006d:
            float r2 = r2.floatValue()
            r11.setY(r2)
            int r2 = r12.getAction()
            r3 = 1
            if (r2 == 0) goto L_0x0275
            r4 = 2
            r5 = 0
            if (r2 == r3) goto L_0x0197
            if (r2 == r4) goto L_0x0083
            goto L_0x028d
        L_0x0083:
            java.lang.Integer r2 = r10.m
            if (r2 != 0) goto L_0x008a
            kotlin.g.b.k.a()
        L_0x008a:
            int r2 = r2.intValue()
            float r2 = (float) r2
            float r6 = r12.getX()
            float r2 = r2 - r6
            float r2 = java.lang.Math.abs(r2)
            int r6 = r
            float r6 = (float) r6
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x00bb
            java.lang.Integer r2 = r10.n
            if (r2 != 0) goto L_0x00a6
            kotlin.g.b.k.a()
        L_0x00a6:
            int r2 = r2.intValue()
            float r2 = (float) r2
            float r6 = r12.getY()
            float r2 = r2 - r6
            float r2 = java.lang.Math.abs(r2)
            int r6 = r
            float r6 = (float) r6
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x028d
        L_0x00bb:
            r10.f20080h = r5
            float r2 = r12.getRawX()
            int r2 = (int) r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.o = r2
            float r2 = r12.getRawY()
            int r2 = (int) r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.p = r2
            java.lang.Integer r2 = r10.o
            if (r2 != 0) goto L_0x00da
            kotlin.g.b.k.a()
        L_0x00da:
            int r2 = r2.intValue()
            java.lang.Integer r6 = r10.m
            if (r6 != 0) goto L_0x00e5
            kotlin.g.b.k.a()
        L_0x00e5:
            int r6 = r6.intValue()
            int r2 = r2 - r6
            float r2 = (float) r2
            r11.setX(r2)
            java.lang.Integer r2 = r10.p
            if (r2 != 0) goto L_0x00f5
            kotlin.g.b.k.a()
        L_0x00f5:
            int r2 = r2.intValue()
            java.lang.Integer r6 = r10.n
            if (r6 != 0) goto L_0x0100
            kotlin.g.b.k.a()
        L_0x0100:
            int r6 = r6.intValue()
            int r2 = r2 - r6
            float r2 = (float) r2
            r11.setY(r2)
            java.lang.Integer r2 = r10.o
            if (r2 != 0) goto L_0x0110
            kotlin.g.b.k.a()
        L_0x0110:
            int r2 = r2.intValue()
            r6 = 4591738658415193368(0x3fb921fb54442d18, double:0.09817477042468103)
            if (r2 < r1) goto L_0x015a
            java.lang.Integer r2 = r10.o
            if (r2 != 0) goto L_0x0122
            kotlin.g.b.k.a()
        L_0x0122:
            int r2 = r2.intValue()
            int r2 = r2 - r1
            double r2 = (double) r2
            double r2 = r2 * r6
            float r2 = (float) r2
            r11.setRotation(r2)
            java.lang.Integer r11 = r10.o
            if (r11 != 0) goto L_0x0135
            kotlin.g.b.k.a()
        L_0x0135:
            int r11 = r11.intValue()
            int r2 = r1 / 2
            int r2 = r2 + r1
            if (r11 <= r2) goto L_0x0156
            java.lang.Integer r11 = r10.o
            if (r11 != 0) goto L_0x0145
            kotlin.g.b.k.a()
        L_0x0145:
            int r11 = r11.intValue()
            int r1 = r1 / 4
            int r0 = r0 - r1
            if (r11 <= r0) goto L_0x0152
            r10.l = r4
            goto L_0x028d
        L_0x0152:
            r10.l = r5
            goto L_0x028d
        L_0x0156:
            r10.l = r5
            goto L_0x028d
        L_0x015a:
            java.lang.Integer r0 = r10.o
            if (r0 != 0) goto L_0x0161
            kotlin.g.b.k.a()
        L_0x0161:
            int r0 = r0.intValue()
            int r0 = r0 - r1
            double r8 = (double) r0
            double r8 = r8 * r6
            float r0 = (float) r8
            r11.setRotation(r0)
            java.lang.Integer r11 = r10.o
            if (r11 != 0) goto L_0x0174
            kotlin.g.b.k.a()
        L_0x0174:
            int r11 = r11.intValue()
            int r0 = r1 / 2
            if (r11 >= r0) goto L_0x0193
            java.lang.Integer r11 = r10.o
            if (r11 != 0) goto L_0x0183
            kotlin.g.b.k.a()
        L_0x0183:
            int r11 = r11.intValue()
            int r1 = r1 / 4
            if (r11 >= r1) goto L_0x018f
            r10.l = r3
            goto L_0x028d
        L_0x018f:
            r10.l = r5
            goto L_0x028d
        L_0x0193:
            r10.l = r5
            goto L_0x028d
        L_0x0197:
            float r0 = r12.getRawX()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.o = r0
            float r0 = r12.getRawY()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.p = r0
            int r0 = r10.l
            if (r0 != 0) goto L_0x01c9
            boolean r0 = r10.f20080h
            if (r0 == 0) goto L_0x01b6
            return r3
        L_0x01b6:
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            net.one97.paytm.v2.features.b.b$c r1 = new net.one97.paytm.v2.features.b.b$c
            r1.<init>(r10, r11)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2 = 10
            r0.postDelayed(r1, r2)
            goto L_0x0270
        L_0x01c9:
            if (r0 != r3) goto L_0x021d
            float r0 = r12.getRawX()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.o = r0
            float r0 = r12.getRawY()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.p = r0
            java.lang.Integer r0 = r10.o
            if (r0 != 0) goto L_0x01e8
            kotlin.g.b.k.a()
        L_0x01e8:
            int r0 = r0.intValue()
            java.lang.Integer r1 = r10.m
            if (r1 != 0) goto L_0x01f3
            kotlin.g.b.k.a()
        L_0x01f3:
            int r1 = r1.intValue()
            int r0 = r0 - r1
            float r0 = (float) r0
            r11.setX(r0)
            java.lang.Integer r0 = r10.p
            if (r0 != 0) goto L_0x0203
            kotlin.g.b.k.a()
        L_0x0203:
            int r0 = r0.intValue()
            java.lang.Integer r1 = r10.n
            if (r1 != 0) goto L_0x020e
            kotlin.g.b.k.a()
        L_0x020e:
            int r1 = r1.intValue()
            int r0 = r0 - r1
            float r0 = (float) r0
            r11.setY(r0)
            net.one97.paytm.v2.features.b.a r11 = r10.f20074a
            r11.a()
            goto L_0x0270
        L_0x021d:
            if (r0 != r4) goto L_0x0270
            float r0 = r12.getRawX()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.o = r0
            float r0 = r12.getRawY()
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.p = r0
            java.lang.Integer r0 = r10.o
            if (r0 != 0) goto L_0x023c
            kotlin.g.b.k.a()
        L_0x023c:
            int r0 = r0.intValue()
            java.lang.Integer r1 = r10.m
            if (r1 != 0) goto L_0x0247
            kotlin.g.b.k.a()
        L_0x0247:
            int r1 = r1.intValue()
            int r0 = r0 - r1
            float r0 = (float) r0
            r11.setX(r0)
            java.lang.Integer r0 = r10.p
            if (r0 != 0) goto L_0x0257
            kotlin.g.b.k.a()
        L_0x0257:
            int r0 = r0.intValue()
            java.lang.Integer r1 = r10.n
            if (r1 != 0) goto L_0x0262
            kotlin.g.b.k.a()
        L_0x0262:
            int r1 = r1.intValue()
            int r0 = r0 - r1
            float r0 = (float) r0
            r11.setY(r0)
            net.one97.paytm.v2.features.b.a r11 = r10.f20074a
            r11.b()
        L_0x0270:
            r10.f20080h = r5
            r10.f20079g = r5
            goto L_0x028d
        L_0x0275:
            float r11 = r12.getX()
            int r11 = (int) r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.m = r11
            float r11 = r12.getY()
            int r11 = (int) r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10.n = r11
            r10.f20081i = r3
        L_0x028d:
            android.view.GestureDetector r11 = r10.j
            boolean r11 = r11.onTouchEvent(r12)
            return r11
        L_0x0294:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type android.app.Activity"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20100a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f20101b;

        c(b bVar, View view) {
            this.f20100a = bVar;
            this.f20101b = view;
        }

        public final void run() {
            if (!this.f20100a.f20079g) {
                View view = this.f20101b;
                Float f2 = this.f20100a.f20076c;
                if (f2 == null) {
                    k.a();
                }
                view.setX(f2.floatValue());
                View view2 = this.f20101b;
                Float f3 = this.f20100a.f20077d;
                if (f3 == null) {
                    k.a();
                }
                view2.setY(f3.floatValue());
                this.f20101b.setRotation(0.0f);
                b.d(this.f20100a);
            }
        }
    }

    /* renamed from: net.one97.paytm.v2.features.b.b$b  reason: collision with other inner class name */
    final class C0358b extends GestureDetector.SimpleOnGestureListener {
        public final boolean onDown(MotionEvent motionEvent) {
            k.c(motionEvent, "e");
            return true;
        }

        public C0358b() {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            k.c(motionEvent, "e1");
            k.c(motionEvent2, "e2");
            try {
                float rawX = motionEvent2.getRawX() - motionEvent.getRawX();
                if (Math.abs(rawX) <= ((float) b.s) || Math.abs(f2) <= ((float) b.t)) {
                    return true;
                }
                b.this.f20079g = true;
                if (rawX > 0.0f) {
                    b.this.f20074a.b();
                    return true;
                }
                b.this.f20074a.a();
                return true;
            } catch (Exception unused) {
                String unused2 = b.q;
                q.b("Exception caused while swiping scratch card");
                return true;
            }
        }

        public final void onLongPress(MotionEvent motionEvent) {
            b.this.f20080h = true;
            View a2 = b.this.a();
            Float f2 = b.this.f20076c;
            if (f2 == null) {
                k.a();
            }
            a2.setX(f2.floatValue());
            View a3 = b.this.a();
            Float f3 = b.this.f20077d;
            if (f3 == null) {
                k.a();
            }
            a3.setY(f3.floatValue());
            b.this.a().setRotation(0.0f);
        }
    }

    public static final /* synthetic */ void d(b bVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(bVar.k, R.anim.scratch_card_shake);
        CycleInterpolator cycleInterpolator = new CycleInterpolator(0.5f);
        k.a((Object) loadAnimation, "bounceAnimation");
        loadAnimation.setInterpolator(cycleInterpolator);
        View view = bVar.f20078e;
        if (view == null) {
            k.a("containerView");
        }
        if (view != null) {
            view.startAnimation(loadAnimation);
        }
    }
}
