package net.one97.paytm.paymentsBank.pdc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
import java.util.List;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse;

public class PDCVerticalStateProgressView extends View {
    /* access modifiers changed from: private */
    public static final Typeface G = Typeface.create(Typeface.DEFAULT, 0);
    /* access modifiers changed from: private */
    public static final Typeface H = Typeface.create(Typeface.DEFAULT, 1);
    Drawable A;
    Drawable B;
    Drawable C;
    Drawable D;
    Drawable E;
    Drawable F;
    private Context I;
    private int J;
    private float K;
    private float L;
    private float M;
    private float N = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    float f18719a;

    /* renamed from: b  reason: collision with root package name */
    float f18720b;

    /* renamed from: c  reason: collision with root package name */
    float f18721c;

    /* renamed from: d  reason: collision with root package name */
    float f18722d;

    /* renamed from: e  reason: collision with root package name */
    float f18723e;

    /* renamed from: f  reason: collision with root package name */
    float f18724f;

    /* renamed from: g  reason: collision with root package name */
    float f18725g;

    /* renamed from: h  reason: collision with root package name */
    float f18726h;

    /* renamed from: i  reason: collision with root package name */
    float f18727i;
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
    String w;
    Paint x = new Paint();
    ArrayList<b> y = new ArrayList<>();
    List<PDCTrackOrderResponse.StatusFlow> z;

    public PDCVerticalStateProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = context;
        this.f18719a = this.I.getResources().getDimension(R.dimen.pb_item_status_progress_big_circle_radius);
        this.f18720b = this.I.getResources().getDimension(R.dimen.pb_item_status_progress_small_circle_radius);
        this.f18721c = this.I.getResources().getDimension(R.dimen.pb_item_status_line_width);
        this.f18722d = this.I.getResources().getDimension(R.dimen.pb_item_order_status_text_size);
        this.f18723e = this.I.getResources().getDimension(R.dimen.pb_item_order_date_text_size);
        this.f18724f = this.I.getResources().getDimension(R.dimen.pb_item_order_text_top_margin);
        this.f18725g = this.I.getResources().getDimension(R.dimen.pb_item_order_text_height);
        this.K = this.I.getResources().getDimension(R.dimen.pb_item_status_progress_start_end_padding);
        this.L = this.I.getResources().getDimension(R.dimen.dimen_30dp);
        this.f18727i = this.I.getResources().getDimension(R.dimen.pb_normal_vertical_line_height);
        this.j = this.I.getResources().getDimension(R.dimen.pb_circle_to_line_gap);
        this.k = this.I.getResources().getDimension(R.dimen.pb_status_date_text_width);
        this.l = this.I.getResources().getDimension(R.dimen.pb_vert_tl_detail_gap_to_arrow_y);
        this.M = this.I.getResources().getDimension(R.dimen.dimen_20dp);
        this.o = this.I.getResources().getColor(R.color.greyish_brown);
        this.p = this.I.getResources().getColor(R.color.color_909090);
        this.q = this.I.getResources().getColor(R.color.item_status_small_circle_color);
        this.s = this.I.getResources().getColor(R.color.item_status_redish_color);
        this.r = this.I.getResources().getColor(R.color.item_status_greenish_color);
        this.C = this.I.getResources().getDrawable(R.drawable.pb_green_tick_icon);
        this.D = this.I.getResources().getDrawable(R.drawable.pb_small_green_circle);
        this.F = this.I.getResources().getDrawable(R.drawable.pb_delivery_delayed);
        this.B = this.I.getResources().getDrawable(R.drawable.pb_auto_cancel_icon);
        this.A = this.I.getResources().getDrawable(R.drawable.pb_dispatch_due_icon);
        this.E = this.I.getResources().getDrawable(R.drawable.pb_small_grey_circle);
        this.v = this.I.getResources().getString(R.string.pb_format_yyyy_mm_dd_hh_mm_ss_str);
        this.w = this.I.getResources().getString(R.string.pb_format_dd_MMM_str);
        this.f18726h = this.L;
        setLayerType(1, (Paint) null);
    }

    private void setViewHeight(float f2) {
        setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (f2 + this.M)));
    }

    public final Point a(List<PDCTrackOrderResponse.StatusFlow> list, int i2, boolean z2, String str) {
        this.u = str;
        this.z = list;
        this.J = i2;
        if (z2) {
            this.f18726h = this.K;
        } else {
            this.f18726h = this.L;
        }
        Point point = new Point(0, 0);
        if (list != null && list.size() > 0) {
            point = c();
        }
        setViewHeight(this.N);
        invalidate();
        return point;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Point c() {
        /*
            r19 = this;
            r1 = r19
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.y = r0
            float r0 = r1.f18724f
            float r2 = r1.f18726h
            android.graphics.Point r3 = new android.graphics.Point
            r4 = 0
            r3.<init>(r4, r4)
            android.graphics.Point r5 = new android.graphics.Point
            int r0 = (int) r0
            int r2 = (int) r2
            r5.<init>(r0, r2)
            r6 = 0
            r0 = r3
            r3 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0020:
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r10 = r1.z
            int r10 = r10.size()
            r11 = 1
            if (r3 >= r10) goto L_0x020f
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r10 = r1.z
            java.lang.Object r10 = r10.get(r3)
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow r10 = (net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse.StatusFlow) r10
            if (r10 == 0) goto L_0x0209
            int r7 = r1.o
            r10.getLabel()
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r12 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            r0.<init>(r12)
            java.lang.String r12 = "UTC"
            java.util.TimeZone r12 = java.util.TimeZone.getTimeZone(r12)
            r0.setTimeZone(r12)
            java.lang.String r12 = r10.getDate()     // Catch:{ ParseException -> 0x0057 }
            if (r12 == 0) goto L_0x005f
            java.lang.String r12 = r10.getDate()     // Catch:{ ParseException -> 0x0057 }
            java.util.Date r0 = r0.parse(r12)     // Catch:{ ParseException -> 0x0057 }
            goto L_0x0060
        L_0x0057:
            r0 = move-exception
            boolean r12 = com.paytm.utility.b.v
            if (r12 == 0) goto L_0x005f
            r0.printStackTrace()
        L_0x005f:
            r0 = 0
        L_0x0060:
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat
            java.lang.String r13 = r1.w
            r12.<init>(r13)
            java.lang.String r13 = "GMT+5:30"
            java.util.TimeZone r13 = java.util.TimeZone.getTimeZone(r13)
            r12.setTimeZone(r13)
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = r12.format(r0)
            goto L_0x0079
        L_0x0077:
            java.lang.String r0 = ""
        L_0x0079:
            r13 = r0
            java.lang.String r0 = r10.getLabel()
            java.lang.String r12 = r1.u
            boolean r0 = r0.equalsIgnoreCase(r12)
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$d r15 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$d
            float r14 = r1.f18723e
            android.graphics.Point r12 = new android.graphics.Point
            r12.<init>(r5)
            r17 = r12
            r12 = r15
            r16 = r14
            r14 = r7
            r2 = r15
            r15 = r16
            r16 = r0
            r12.<init>(r13, r14, r15, r16, r17)
            java.util.ArrayList<net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$b> r12 = r1.y
            r12.add(r2)
            int r2 = r1.r
            int r12 = r5.x
            float r12 = (float) r12
            float r13 = r1.f18724f
            float r14 = r1.k
            float r13 = r13 + r14
            float r12 = r12 + r13
            int r12 = (int) r12
            r5.x = r12
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x00b6
            int r8 = r5.x
            float r8 = (float) r8
            goto L_0x00b9
        L_0x00b6:
            int r12 = (int) r8
            r5.x = r12
        L_0x00b9:
            r12 = -1
            java.lang.String r13 = "green"
            int r13 = r13.hashCode()
            r14 = -1008851410(0xffffffffc3de262e, float:-444.29828)
            if (r13 == r14) goto L_0x00d1
            r14 = 112785(0x1b891, float:1.58045E-40)
            if (r13 == r14) goto L_0x00d1
            r14 = 98619139(0x5e0cf03, float:2.1140903E-35)
            if (r13 == r14) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            r12 = 0
        L_0x00d1:
            if (r12 == 0) goto L_0x0126
            if (r12 == r11) goto L_0x00fa
            r2 = 2
            if (r12 == r2) goto L_0x00e9
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a r2 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a
            android.graphics.drawable.Drawable r11 = r1.E
            float r12 = r1.f18720b
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r5)
            r2.<init>(r11, r12, r13)
            int r11 = r1.q
            goto L_0x0154
        L_0x00e9:
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a r2 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a
            android.graphics.drawable.Drawable r11 = r1.F
            float r12 = r1.f18719a
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r5)
            r2.<init>(r11, r12, r13)
            int r11 = r1.t
            goto L_0x0154
        L_0x00fa:
            java.lang.String r11 = r1.u
            java.lang.String r12 = r10.getLabel()
            boolean r11 = r11.equalsIgnoreCase(r12)
            if (r11 == 0) goto L_0x0117
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a r2 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a
            android.graphics.drawable.Drawable r11 = r1.B
            float r12 = r1.f18719a
            android.graphics.Point r13 = new android.graphics.Point
            r13.<init>(r5)
            r2.<init>(r11, r12, r13)
            int r11 = r1.s
            goto L_0x0154
        L_0x0117:
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a r11 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a
            android.graphics.drawable.Drawable r12 = r1.A
            float r13 = r1.f18719a
            android.graphics.Point r14 = new android.graphics.Point
            r14.<init>(r5)
            r11.<init>(r12, r13, r14)
            goto L_0x014f
        L_0x0126:
            java.lang.String r11 = r1.u
            java.lang.String r12 = r10.getLabel()
            boolean r11 = r11.equalsIgnoreCase(r12)
            if (r11 == 0) goto L_0x0141
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a r11 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a
            android.graphics.drawable.Drawable r12 = r1.C
            float r13 = r1.f18719a
            android.graphics.Point r14 = new android.graphics.Point
            r14.<init>(r5)
            r11.<init>(r12, r13, r14)
            goto L_0x014f
        L_0x0141:
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a r11 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$a
            android.graphics.drawable.Drawable r12 = r1.D
            float r13 = r1.f18720b
            android.graphics.Point r14 = new android.graphics.Point
            r14.<init>(r5)
            r11.<init>(r12, r13, r14)
        L_0x014f:
            r18 = r11
            r11 = r2
            r2 = r18
        L_0x0154:
            java.util.ArrayList<net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$b> r12 = r1.y
            r12.add(r2)
            java.lang.String r12 = r10.getLabel()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0195
            java.lang.String r12 = r10.getStatusDetailTxt()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0195
            java.util.ArrayList<net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$b> r15 = r1.y
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$d r14 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$d
            java.lang.String r13 = r10.getLabel()
            float r10 = r1.f18722d
            android.graphics.Point r12 = new android.graphics.Point
            int r4 = r5.x
            float r4 = (float) r4
            float r6 = r1.f18724f
            float r4 = r4 + r6
            int r4 = (int) r4
            int r6 = r5.y
            r12.<init>(r4, r6)
            r4 = r12
            r12 = r14
            r6 = r14
            r14 = r7
            r7 = r15
            r15 = r10
            r16 = r0
            r17 = r4
            r12.<init>(r13, r14, r15, r16, r17)
            r7.add(r6)
        L_0x0195:
            if (r9 == 0) goto L_0x01b9
            int r0 = r5.x
            int r4 = r5.y
            float r4 = (float) r4
            float r6 = r2.f18728a
            float r7 = r1.j
            float r6 = r6 + r7
            float r4 = r4 - r6
            int r4 = (int) r4
            net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$c r6 = new net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$c
            android.graphics.Point r7 = new android.graphics.Point
            r7.<init>(r9)
            android.graphics.Point r9 = new android.graphics.Point
            r9.<init>(r0, r4)
            float r0 = r1.f18721c
            r6.<init>(r11, r7, r9, r0)
            java.util.ArrayList<net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView$b> r0 = r1.y
            r0.add(r6)
        L_0x01b9:
            float r0 = r1.f18727i
            int r4 = r1.J
            float r4 = (float) r4
            float r6 = r1.l
            float r4 = r4 - r6
            float r0 = r0 + r4
            android.graphics.Point r4 = new android.graphics.Point
            int r6 = r5.x
            int r7 = r5.y
            r4.<init>(r6, r7)
            int r6 = r5.y
            float r6 = (float) r6
            float r7 = r2.f18728a
            float r9 = r1.j
            float r7 = r7 + r9
            float r6 = r6 + r7
            int r6 = (int) r6
            r5.y = r6
            android.graphics.Point r6 = new android.graphics.Point
            r6.<init>(r5)
            int r7 = r5.y
            float r7 = (float) r7
            float r9 = r2.f18728a
            float r10 = r1.j
            float r9 = r9 + r10
            float r9 = r9 + r0
            float r7 = r7 + r9
            int r7 = (int) r7
            r5.y = r7
            int r7 = r5.x
            float r7 = (float) r7
            float r9 = r1.k
            float r10 = r1.f18724f
            float r9 = r9 + r10
            float r7 = r7 - r9
            int r7 = (int) r7
            r5.x = r7
            float r2 = r2.f18728a
            float r7 = r1.j
            float r2 = r2 + r7
            float r2 = r2 + r0
            float r0 = r1.N
            int r7 = r5.y
            float r7 = (float) r7
            float r0 = java.lang.Math.max(r0, r7)
            r1.N = r0
            r7 = r2
            r0 = r4
            r9 = r6
        L_0x0209:
            int r3 = r3 + 1
            r4 = 0
            r6 = 0
            goto L_0x0020
        L_0x020f:
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r2 = r1.z
            if (r2 == 0) goto L_0x023b
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x023b
            java.util.List<net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow> r2 = r1.z
            int r3 = r2.size()
            int r3 = r3 - r11
            java.lang.Object r2 = r2.get(r3)
            net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse$StatusFlow r2 = (net.one97.paytm.paymentsBank.pdc.response.PDCTrackOrderResponse.StatusFlow) r2
            java.util.List r3 = r2.getActions()
            if (r3 == 0) goto L_0x0236
            java.util.List r2 = r2.getActions()
            int r2 = r2.size()
            if (r2 != 0) goto L_0x023b
        L_0x0236:
            float r2 = r1.N
            float r2 = r2 - r7
            r1.N = r2
        L_0x023b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.pdc.view.PDCVerticalStateProgressView.c():android.graphics.Point");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.m = getWidth();
        this.n = getHeight();
        this.x.setAntiAlias(true);
        Iterator<b> it2 = this.y.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            Paint paint = this.x;
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
        float f18728a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f18729b;

        /* renamed from: c  reason: collision with root package name */
        private Point f18730c;

        public final void a(Paint paint) {
        }

        a(Drawable drawable, float f2, Point point) {
            super((byte) 0);
            this.f18729b = drawable;
            this.f18728a = f2;
            this.f18730c = point;
        }

        public final void a(Canvas canvas, Paint paint) {
            this.f18729b.setBounds((int) (((float) this.f18730c.x) - this.f18728a), (int) (((float) this.f18730c.y) - this.f18728a), (int) (((float) this.f18730c.x) + this.f18728a), (int) (((float) this.f18730c.y) + this.f18728a));
            this.f18729b.draw(canvas);
        }
    }

    static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private int f18731a;

        /* renamed from: b  reason: collision with root package name */
        private Point f18732b;

        /* renamed from: c  reason: collision with root package name */
        private Point f18733c;

        /* renamed from: d  reason: collision with root package name */
        private float f18734d;

        c(int i2, Point point, Point point2, float f2) {
            super((byte) 0);
            this.f18731a = i2;
            this.f18732b = point;
            this.f18733c = point2;
            this.f18734d = f2;
        }

        public final void a(Paint paint) {
            paint.setStrokeWidth(this.f18734d);
            paint.setColor(this.f18731a);
            paint.setColor(this.f18731a);
        }

        public final void a(Canvas canvas, Paint paint) {
            canvas.drawLine((float) this.f18732b.x, (float) this.f18732b.y, (float) this.f18733c.x, (float) this.f18733c.y, paint);
        }
    }

    static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        boolean f18735a;

        /* renamed from: b  reason: collision with root package name */
        private String f18736b;

        /* renamed from: c  reason: collision with root package name */
        private int f18737c;

        /* renamed from: d  reason: collision with root package name */
        private float f18738d;

        /* renamed from: e  reason: collision with root package name */
        private Point f18739e;

        /* renamed from: f  reason: collision with root package name */
        private int f18740f = -1;

        public d(String str, int i2, float f2, boolean z, Point point) {
            super((byte) 0);
            this.f18738d = f2;
            this.f18737c = i2;
            this.f18739e = point;
            if (str == null) {
                this.f18736b = "";
            } else {
                this.f18736b = str;
            }
            this.f18735a = z;
        }

        public final void a(Paint paint) {
            if (this.f18735a) {
                paint.setTypeface(PDCVerticalStateProgressView.H);
            } else {
                paint.setTypeface(PDCVerticalStateProgressView.G);
            }
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(this.f18738d);
            paint.setColor(this.f18737c);
        }

        public final void a(Canvas canvas, Paint paint) {
            String str = this.f18736b;
            float f2 = (float) this.f18739e.x;
            float f3 = (float) this.f18739e.y;
            int i2 = this.f18740f;
            if (i2 <= 0) {
                a(paint);
                Rect rect = new Rect();
                String str2 = this.f18736b;
                paint.getTextBounds(str2, 0, str2.length(), rect);
                i2 = rect.height();
                this.f18740f = i2;
            }
            canvas.drawText(str, f2, f3 + (((float) i2) / 2.0f), paint);
        }
    }
}
