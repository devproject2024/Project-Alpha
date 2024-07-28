package net.one97.paytm.fastag.dependencies;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.model.CJRStatusFlow;

public class CJRVerticalStateProgressView extends View {
    /* access modifiers changed from: private */
    public static final Typeface F = Typeface.create(Typeface.DEFAULT, 0);
    /* access modifiers changed from: private */
    public static final Typeface G = Typeface.create(Typeface.DEFAULT, 1);
    Drawable A;
    Drawable B;
    Drawable C;
    Drawable D;
    Drawable E;
    private Context H;
    private int I;
    private float J;
    private float K;
    private float L;
    private float M = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    float f13584a;

    /* renamed from: b  reason: collision with root package name */
    float f13585b;

    /* renamed from: c  reason: collision with root package name */
    float f13586c;

    /* renamed from: d  reason: collision with root package name */
    float f13587d;

    /* renamed from: e  reason: collision with root package name */
    float f13588e;

    /* renamed from: f  reason: collision with root package name */
    float f13589f;

    /* renamed from: g  reason: collision with root package name */
    float f13590g;

    /* renamed from: h  reason: collision with root package name */
    float f13591h;

    /* renamed from: i  reason: collision with root package name */
    float f13592i;
    float j;
    float k;
    float l;
    int m;
    int n;
    int o;
    int p;
    int q = -7829368;
    int r = Color.parseColor("#20bf7a");
    int s = -65536;
    int t = Color.parseColor("#f8aa02");
    String u;
    String v;
    Paint w = new Paint();
    ArrayList<b> x = new ArrayList<>();
    ArrayList<CJRStatusFlow> y;
    Drawable z;

    public CJRVerticalStateProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = context;
        this.f13584a = this.H.getResources().getDimension(R.dimen.item_status_progress_big_circle_radius);
        this.f13585b = this.H.getResources().getDimension(R.dimen.item_status_progress_small_circle_radius);
        this.f13586c = this.H.getResources().getDimension(R.dimen.item_status_line_width);
        this.f13587d = this.H.getResources().getDimension(R.dimen.item_order_status_text_size);
        this.f13588e = this.H.getResources().getDimension(R.dimen.item_order_date_text_size);
        this.f13589f = this.H.getResources().getDimension(R.dimen.item_order_text_top_margin);
        this.f13590g = this.H.getResources().getDimension(R.dimen.item_order_text_height);
        this.J = this.H.getResources().getDimension(R.dimen.item_status_progress_start_end_padding);
        this.K = this.H.getResources().getDimension(R.dimen.dimen_30dp);
        this.f13592i = this.H.getResources().getDimension(R.dimen.normal_vertical_line_height);
        this.j = this.H.getResources().getDimension(R.dimen.circle_to_line_gap);
        this.k = this.H.getResources().getDimension(R.dimen.status_date_text_width);
        this.l = this.H.getResources().getDimension(R.dimen.vert_tl_detail_gap_to_arrow_y);
        this.L = this.H.getResources().getDimension(R.dimen.dimen_20dp);
        this.o = this.H.getResources().getColor(R.color.greyish_brown);
        this.p = this.H.getResources().getColor(R.color.color_909090);
        this.q = this.H.getResources().getColor(R.color.item_status_small_circle_color);
        this.s = this.H.getResources().getColor(R.color.item_status_redish_color);
        this.r = this.H.getResources().getColor(R.color.item_status_greenish_color);
        this.B = this.H.getResources().getDrawable(R.drawable.gree_tick_icon);
        this.C = this.H.getResources().getDrawable(R.drawable.small_green_circle);
        this.E = this.H.getResources().getDrawable(R.drawable.delivery_delayed);
        this.A = this.H.getResources().getDrawable(R.drawable.auto_cancel_icon);
        this.z = this.H.getResources().getDrawable(R.drawable.dispatch_due_icon);
        this.D = this.H.getResources().getDrawable(R.drawable.small_grey_circle);
        this.u = this.H.getResources().getString(R.string.format_yyyy_mm_dd_hh_mm_ss_str);
        this.v = this.H.getResources().getString(R.string.format_dd_MMM_str);
        this.f13591h = this.K;
        setLayerType(1, (Paint) null);
    }

    private void setViewHeight(float f2) {
        setLayoutParams(new FrameLayout.LayoutParams(-1, (int) ((f2 + this.L) - this.f13592i)));
    }

    public final Point a(ArrayList<CJRStatusFlow> arrayList, int i2, boolean z2) {
        this.y = arrayList;
        this.I = i2;
        if (z2) {
            this.f13591h = this.J;
        } else {
            this.f13591h = this.K;
        }
        Point point = new Point(0, 0);
        if (arrayList != null && arrayList.size() > 0) {
            point = c();
        }
        setViewHeight(this.M);
        invalidate();
        return point;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e1 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0203  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Point c() {
        /*
            r26 = this;
            r1 = r26
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.x = r0
            float r0 = r1.f13589f
            float r2 = r1.f13591h
            android.graphics.Point r3 = new android.graphics.Point
            r4 = 0
            r3.<init>(r4, r4)
            android.graphics.Point r5 = new android.graphics.Point
            int r0 = (int) r0
            int r2 = (int) r2
            r5.<init>(r0, r2)
            r6 = 0
            r7 = r3
            r3 = 0
            r8 = 0
            r9 = 0
        L_0x001f:
            java.util.ArrayList<net.one97.paytm.fastag.model.CJRStatusFlow> r0 = r1.y
            int r0 = r0.size()
            if (r3 >= r0) goto L_0x0248
            java.util.ArrayList<net.one97.paytm.fastag.model.CJRStatusFlow> r0 = r1.y
            java.lang.Object r0 = r0.get(r3)
            r10 = r0
            net.one97.paytm.fastag.model.CJRStatusFlow r10 = (net.one97.paytm.fastag.model.CJRStatusFlow) r10
            if (r10 == 0) goto L_0x023e
            int r11 = r1.o
            java.lang.String r12 = r10.getColor()
            r10.getText()
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r13 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            r0.<init>(r13)
            java.lang.String r13 = "UTC"
            java.util.TimeZone r13 = java.util.TimeZone.getTimeZone(r13)
            r0.setTimeZone(r13)
            java.lang.String r13 = r10.getmCreatedAt()     // Catch:{ ParseException -> 0x005b }
            if (r13 == 0) goto L_0x0063
            java.lang.String r13 = r10.getmCreatedAt()     // Catch:{ ParseException -> 0x005b }
            java.util.Date r0 = r0.parse(r13)     // Catch:{ ParseException -> 0x005b }
            goto L_0x0064
        L_0x005b:
            r0 = move-exception
            boolean r13 = com.paytm.utility.b.v
            if (r13 == 0) goto L_0x0063
            r0.printStackTrace()
        L_0x0063:
            r0 = 0
        L_0x0064:
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
            java.lang.String r14 = r1.v
            r13.<init>(r14)
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = r13.format(r0)
            goto L_0x0074
        L_0x0072:
            java.lang.String r0 = ""
        L_0x0074:
            java.lang.String r13 = "grey"
            boolean r13 = r13.equalsIgnoreCase(r12)
            java.lang.String r14 = "dotted_grey"
            if (r13 != 0) goto L_0x0084
            boolean r13 = r14.equalsIgnoreCase(r12)
            if (r13 == 0) goto L_0x0086
        L_0x0084:
            int r11 = r1.p
        L_0x0086:
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$d r13 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$d
            float r15 = r1.f13588e
            android.graphics.Point r2 = new android.graphics.Point
            r2.<init>(r5)
            r13.<init>(r0, r11, r15, r2)
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$b> r0 = r1.x
            r0.add(r13)
            int r0 = r1.r
            int r2 = r5.x
            float r2 = (float) r2
            float r13 = r1.f13589f
            float r15 = r1.k
            float r13 = r13 + r15
            float r2 = r2 + r13
            int r2 = (int) r2
            r5.x = r2
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x00ad
            int r2 = r5.x
            float r8 = (float) r2
            goto L_0x00b0
        L_0x00ad:
            int r2 = (int) r8
            r5.x = r2
        L_0x00b0:
            int r13 = r12.hashCode()
            r15 = 3
            r2 = 2
            r4 = 1
            switch(r13) {
                case -1008851410: goto L_0x00d7;
                case -451034156: goto L_0x00cf;
                case 112785: goto L_0x00c5;
                case 98619139: goto L_0x00bb;
                default: goto L_0x00ba;
            }
        L_0x00ba:
            goto L_0x00e1
        L_0x00bb:
            java.lang.String r13 = "green"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x00e1
            r13 = 0
            goto L_0x00e2
        L_0x00c5:
            java.lang.String r13 = "red"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x00e1
            r13 = 1
            goto L_0x00e2
        L_0x00cf:
            boolean r13 = r12.equals(r14)
            if (r13 == 0) goto L_0x00e1
            r13 = 3
            goto L_0x00e2
        L_0x00d7:
            java.lang.String r13 = "orange"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x00e1
            r13 = 2
            goto L_0x00e2
        L_0x00e1:
            r13 = -1
        L_0x00e2:
            if (r13 == 0) goto L_0x0144
            if (r13 == r4) goto L_0x011e
            if (r13 == r2) goto L_0x010d
            if (r13 == r15) goto L_0x00fc
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a r0 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a
            android.graphics.drawable.Drawable r2 = r1.D
            float r4 = r1.f13585b
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r5)
            r0.<init>(r2, r4, r13)
            int r2 = r1.q
            goto L_0x016c
        L_0x00fc:
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a r0 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a
            android.graphics.drawable.Drawable r2 = r1.D
            float r4 = r1.f13585b
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r5)
            r0.<init>(r2, r4, r13)
            int r2 = r1.q
            goto L_0x016c
        L_0x010d:
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a r0 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a
            android.graphics.drawable.Drawable r2 = r1.E
            float r4 = r1.f13584a
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r5)
            r0.<init>(r2, r4, r13)
            int r2 = r1.t
            goto L_0x016c
        L_0x011e:
            boolean r2 = r10.ismIsCurrentStatus()
            if (r2 == 0) goto L_0x0135
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a r0 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a
            android.graphics.drawable.Drawable r2 = r1.A
            float r4 = r1.f13584a
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r5)
            r0.<init>(r2, r4, r13)
            int r2 = r1.s
            goto L_0x016c
        L_0x0135:
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a r2 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a
            android.graphics.drawable.Drawable r4 = r1.z
            float r13 = r1.f13584a
            android.graphics.Point r15 = new android.graphics.Point
            r15.<init>(r5)
            r2.<init>(r4, r13, r15)
            goto L_0x0167
        L_0x0144:
            net.one97.paytm.fastag.model.CJRStatusDetails r2 = r10.getmStatusDetails()
            if (r2 == 0) goto L_0x0159
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a r2 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a
            android.graphics.drawable.Drawable r4 = r1.B
            float r13 = r1.f13584a
            android.graphics.Point r15 = new android.graphics.Point
            r15.<init>(r5)
            r2.<init>(r4, r13, r15)
            goto L_0x0167
        L_0x0159:
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a r2 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$a
            android.graphics.drawable.Drawable r4 = r1.C
            float r13 = r1.f13585b
            android.graphics.Point r15 = new android.graphics.Point
            r15.<init>(r5)
            r2.<init>(r4, r13, r15)
        L_0x0167:
            r25 = r2
            r2 = r0
            r0 = r25
        L_0x016c:
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$b> r4 = r1.x
            r4.add(r0)
            net.one97.paytm.fastag.model.CJRStatusDetails r4 = r10.getmStatusDetails()
            if (r4 != 0) goto L_0x019c
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$b> r4 = r1.x
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$d r13 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$d
            java.lang.String r15 = r10.getText()
            float r6 = r1.f13587d
            r22 = r8
            android.graphics.Point r8 = new android.graphics.Point
            r23 = r7
            int r7 = r5.x
            float r7 = (float) r7
            r24 = r3
            float r3 = r1.f13589f
            float r7 = r7 + r3
            int r3 = (int) r7
            int r7 = r5.y
            r8.<init>(r3, r7)
            r13.<init>(r15, r11, r6, r8)
            r4.add(r13)
            goto L_0x01a2
        L_0x019c:
            r24 = r3
            r23 = r7
            r22 = r8
        L_0x01a2:
            if (r9 == 0) goto L_0x01ea
            int r3 = r5.x
            int r4 = r5.y
            float r4 = (float) r4
            float r6 = r0.f13593a
            float r7 = r1.j
            float r6 = r6 + r7
            float r4 = r4 - r6
            int r4 = (int) r4
            boolean r6 = r14.equalsIgnoreCase(r12)
            if (r6 == 0) goto L_0x01d4
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$c r6 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$c
            android.graphics.Point r7 = new android.graphics.Point
            r7.<init>(r9)
            android.graphics.Point r8 = new android.graphics.Point
            r8.<init>(r3, r4)
            float r3 = r1.f13586c
            r21 = 1
            r16 = r6
            r17 = r2
            r18 = r7
            r19 = r8
            r20 = r3
            r16.<init>(r17, r18, r19, r20, r21)
            goto L_0x01e5
        L_0x01d4:
            net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$c r6 = new net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$c
            android.graphics.Point r7 = new android.graphics.Point
            r7.<init>(r9)
            android.graphics.Point r8 = new android.graphics.Point
            r8.<init>(r3, r4)
            float r3 = r1.f13586c
            r6.<init>(r2, r7, r8, r3)
        L_0x01e5:
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView$b> r2 = r1.x
            r2.add(r6)
        L_0x01ea:
            float r2 = r1.f13592i
            net.one97.paytm.fastag.model.CJRStatusDetails r3 = r10.getmStatusDetails()
            if (r3 == 0) goto L_0x0203
            int r3 = r1.I
            float r3 = (float) r3
            float r4 = r1.l
            float r3 = r3 - r4
            float r2 = r2 + r3
            android.graphics.Point r7 = new android.graphics.Point
            int r3 = r5.x
            int r4 = r5.y
            r7.<init>(r3, r4)
            goto L_0x0205
        L_0x0203:
            r7 = r23
        L_0x0205:
            int r3 = r5.y
            float r3 = (float) r3
            float r4 = r0.f13593a
            float r6 = r1.j
            float r4 = r4 + r6
            float r3 = r3 + r4
            int r3 = (int) r3
            r5.y = r3
            android.graphics.Point r3 = new android.graphics.Point
            r3.<init>(r5)
            int r4 = r5.y
            float r4 = (float) r4
            float r0 = r0.f13593a
            float r6 = r1.j
            float r0 = r0 + r6
            float r0 = r0 + r2
            float r4 = r4 + r0
            int r0 = (int) r4
            r5.y = r0
            int r0 = r5.x
            float r0 = (float) r0
            float r2 = r1.k
            float r4 = r1.f13589f
            float r2 = r2 + r4
            float r0 = r0 - r2
            int r0 = (int) r0
            r5.x = r0
            float r0 = r1.M
            int r2 = r5.y
            float r2 = (float) r2
            float r0 = java.lang.Math.max(r0, r2)
            r1.M = r0
            r9 = r3
            r8 = r22
            goto L_0x0242
        L_0x023e:
            r24 = r3
            r23 = r7
        L_0x0242:
            int r3 = r24 + 1
            r4 = 0
            r6 = 0
            goto L_0x001f
        L_0x0248:
            r23 = r7
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.dependencies.CJRVerticalStateProgressView.c():android.graphics.Point");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.m = getWidth();
        this.n = getHeight();
        Iterator<b> it2 = this.x.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            this.w.reset();
            this.w.setAntiAlias(true);
            Paint paint = this.w;
            next.a(paint);
            next.a(canvas, paint);
        }
    }

    static abstract class b {
        public abstract void a(Canvas canvas, Paint paint);

        public abstract void a(Paint paint);

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        float f13593a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f13594b;

        /* renamed from: c  reason: collision with root package name */
        private Point f13595c;

        public final void a(Paint paint) {
        }

        a(Drawable drawable, float f2, Point point) {
            super((byte) 0);
            this.f13594b = drawable;
            this.f13593a = f2;
            this.f13595c = point;
        }

        public final void a(Canvas canvas, Paint paint) {
            this.f13594b.setBounds((int) (((float) this.f13595c.x) - this.f13593a), (int) (((float) this.f13595c.y) - this.f13593a), (int) (((float) this.f13595c.x) + this.f13593a), (int) (((float) this.f13595c.y) + this.f13593a));
            this.f13594b.draw(canvas);
        }
    }

    static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private int f13596a;

        /* renamed from: b  reason: collision with root package name */
        private Point f13597b;

        /* renamed from: c  reason: collision with root package name */
        private Point f13598c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13599d;

        /* renamed from: e  reason: collision with root package name */
        private float f13600e;

        c(int i2, Point point, Point point2, float f2) {
            this(i2, point, point2, f2, false);
        }

        c(int i2, Point point, Point point2, float f2, boolean z) {
            super((byte) 0);
            this.f13596a = i2;
            this.f13597b = point;
            this.f13598c = point2;
            this.f13600e = f2;
            this.f13599d = z;
        }

        public final void a(Paint paint) {
            paint.setStrokeWidth(this.f13600e);
            paint.setColor(this.f13596a);
            paint.setColor(this.f13596a);
            if (this.f13599d) {
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 50.0f));
            }
        }

        public final void a(Canvas canvas, Paint paint) {
            canvas.drawLine((float) this.f13597b.x, (float) this.f13597b.y, (float) this.f13598c.x, (float) this.f13598c.y, paint);
        }
    }

    static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        boolean f13601a;

        /* renamed from: b  reason: collision with root package name */
        private String f13602b;

        /* renamed from: c  reason: collision with root package name */
        private int f13603c;

        /* renamed from: d  reason: collision with root package name */
        private float f13604d;

        /* renamed from: e  reason: collision with root package name */
        private Point f13605e;

        /* renamed from: f  reason: collision with root package name */
        private int f13606f = -1;

        public d(String str, int i2, float f2, Point point) {
            super((byte) 0);
            this.f13604d = f2;
            this.f13603c = i2;
            this.f13605e = point;
            if (str == null) {
                this.f13602b = "";
            } else {
                this.f13602b = str;
            }
            this.f13601a = false;
        }

        public final void a(Paint paint) {
            if (this.f13601a) {
                paint.setTypeface(CJRVerticalStateProgressView.G);
            } else {
                paint.setTypeface(CJRVerticalStateProgressView.F);
            }
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(this.f13604d);
            paint.setColor(this.f13603c);
        }

        public final void a(Canvas canvas, Paint paint) {
            String str = this.f13602b;
            float f2 = (float) this.f13605e.x;
            float f3 = (float) this.f13605e.y;
            int i2 = this.f13606f;
            if (i2 <= 0) {
                a(paint);
                Rect rect = new Rect();
                String str2 = this.f13602b;
                paint.getTextBounds(str2, 0, str2.length(), rect);
                i2 = rect.height();
                this.f13606f = i2;
            }
            canvas.drawText(str, f2, f3 + (((float) i2) / 2.0f), paint);
        }
    }
}
