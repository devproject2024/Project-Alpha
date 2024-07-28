package net.one97.paytm.fastag.dependencies;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRStatusFlow;
import net.one97.paytm.fastag.R;

public class CJRStateProgressView extends View {
    ArrayList<a> A;
    ArrayList<b> B;
    ArrayList<CJRStatusFlow> C;
    Drawable D;
    Drawable E;
    Drawable F;

    /* renamed from: a  reason: collision with root package name */
    final float f13568a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    final float f13569b = 10.0f;

    /* renamed from: c  reason: collision with root package name */
    final float f13570c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    final float[] f13571d = {12.0f, 10.0f};

    /* renamed from: e  reason: collision with root package name */
    final DashPathEffect f13572e = new DashPathEffect(this.f13571d, 0.0f);

    /* renamed from: f  reason: collision with root package name */
    Context f13573f;

    /* renamed from: g  reason: collision with root package name */
    int f13574g = 5;

    /* renamed from: h  reason: collision with root package name */
    float f13575h;

    /* renamed from: i  reason: collision with root package name */
    float f13576i;
    float j;
    float k;
    float l;
    float m;
    float n;
    float o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u = -7829368;
    int v = Color.parseColor("#20bf7a");
    int w = -65536;
    String x;
    String y;
    Paint z = new Paint();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        Drawable f13577a;

        /* renamed from: b  reason: collision with root package name */
        float f13578b;

        /* renamed from: c  reason: collision with root package name */
        Point f13579c;

        a(Drawable drawable, float f2, Point point) {
            this.f13577a = drawable;
            this.f13578b = f2;
            this.f13579c = point;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f13580a;

        /* renamed from: b  reason: collision with root package name */
        Point f13581b;

        /* renamed from: c  reason: collision with root package name */
        Point f13582c;

        /* renamed from: d  reason: collision with root package name */
        boolean f13583d;

        b(int i2, Point point, Point point2, boolean z) {
            this.f13580a = i2;
            this.f13581b = point;
            this.f13582c = point2;
            this.f13583d = z;
        }
    }

    public CJRStateProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13573f = context;
        this.f13575h = this.f13573f.getResources().getDimension(R.dimen.item_status_progress_big_circle_radius);
        this.f13576i = this.f13573f.getResources().getDimension(R.dimen.item_status_progress_small_circle_radius);
        this.j = this.f13573f.getResources().getDimension(R.dimen.item_status_line_width);
        this.k = this.f13573f.getResources().getDimension(R.dimen.item_order_status_text_size);
        this.l = this.f13573f.getResources().getDimension(R.dimen.item_order_date_text_size);
        this.m = this.f13573f.getResources().getDimension(R.dimen.item_order_text_top_margin);
        this.n = this.f13573f.getResources().getDimension(R.dimen.item_order_text_height);
        this.o = this.f13573f.getResources().getDimension(R.dimen.item_status_progress_start_end_padding);
        this.s = this.f13573f.getResources().getColor(R.color.greyish_brown);
        this.t = this.f13573f.getResources().getColor(R.color.color_909090);
        this.u = this.f13573f.getResources().getColor(R.color.item_status_small_circle_color);
        this.w = this.f13573f.getResources().getColor(R.color.item_status_redish_color);
        this.v = this.f13573f.getResources().getColor(R.color.item_status_greenish_color);
        this.E = this.f13573f.getResources().getDrawable(R.drawable.gree_tick_icon);
        this.D = this.f13573f.getResources().getDrawable(R.drawable.auto_cancel_icon);
        this.F = this.f13573f.getResources().getDrawable(R.drawable.small_grey_circle);
        this.x = this.f13573f.getResources().getString(R.string.format_yyyy_mm_dd_hh_mm_ss_str);
        this.y = this.f13573f.getResources().getString(R.string.format_dd_MMMM_str);
        setLayerType(1, (Paint) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02bb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r1 = r16
            r8 = r17
            super.onDraw(r17)
            int r0 = r16.getWidth()
            r1.q = r0
            int r0 = r16.getHeight()
            r1.r = r0
            int r0 = r1.q
            int r2 = r1.f13574g
            int r0 = r0 / r2
            r9 = 2
            int r0 = r0 / r9
            r1.p = r0
            int r0 = r1.p
            float r2 = r1.o
            int r2 = (int) r2
            int r0 = r0 + r2
            r1.p = r0
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r0 = r1.C
            if (r0 == 0) goto L_0x02c6
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0030
            goto L_0x02c6
        L_0x0030:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.A = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.B = r0
            int r0 = r1.p
            float r2 = (float) r0
            float r3 = r1.f13575h
            r4 = 0
            r10 = 1
            int r5 = r1.q     // Catch:{ Exception -> 0x0054 }
            int r0 = r0 * 2
            int r5 = r5 - r0
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r0 = r1.C     // Catch:{ Exception -> 0x0054 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x0054 }
            int r0 = r0 - r10
            int r5 = r5 / r0
            float r4 = (float) r5
            goto L_0x005c
        L_0x0054:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x005c:
            r11 = 0
            r5 = r2
            r2 = 0
            r6 = 0
        L_0x0060:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r7 = r1.C
            int r7 = r7.size()
            java.lang.String r12 = "grey"
            if (r2 >= r7) goto L_0x0112
            android.graphics.Point r7 = new android.graphics.Point
            int r13 = (int) r5
            int r14 = (int) r3
            r7.<init>(r13, r14)
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r13 = r1.C
            java.lang.Object r13 = r13.get(r2)
            if (r13 == 0) goto L_0x010e
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r13 = r1.C
            java.lang.Object r13 = r13.get(r2)
            net.one97.paytm.common.entity.shopping.CJRStatusFlow r13 = (net.one97.paytm.common.entity.shopping.CJRStatusFlow) r13
            java.lang.String r13 = r13.getColor()
            boolean r12 = r13.equalsIgnoreCase(r12)
            java.lang.String r14 = "6"
            if (r12 != 0) goto L_0x00dc
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r12 = r1.C
            java.lang.Object r12 = r12.get(r2)
            net.one97.paytm.common.entity.shopping.CJRStatusFlow r12 = (net.one97.paytm.common.entity.shopping.CJRStatusFlow) r12
            java.lang.String r12 = r12.getId()
            boolean r12 = r14.equals(r12)
            if (r12 == 0) goto L_0x00ae
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r12 = r1.C
            java.lang.Object r12 = r12.get(r2)
            net.one97.paytm.common.entity.shopping.CJRStatusFlow r12 = (net.one97.paytm.common.entity.shopping.CJRStatusFlow) r12
            boolean r12 = r12.ismIsCurrentStatus()
            if (r12 != 0) goto L_0x00ae
            goto L_0x00dc
        L_0x00ae:
            java.lang.String r12 = "red"
            boolean r12 = r13.equalsIgnoreCase(r12)
            if (r12 == 0) goto L_0x00c9
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$a r12 = new net.one97.paytm.fastag.dependencies.CJRStateProgressView$a
            android.graphics.drawable.Drawable r13 = r1.D
            float r14 = r1.f13575h
            r12.<init>(r13, r14, r7)
            if (r6 == 0) goto L_0x00ff
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$b r13 = new net.one97.paytm.fastag.dependencies.CJRStateProgressView$b
            int r14 = r1.w
            r13.<init>(r14, r6, r7, r11)
            goto L_0x0100
        L_0x00c9:
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$a r12 = new net.one97.paytm.fastag.dependencies.CJRStateProgressView$a
            android.graphics.drawable.Drawable r13 = r1.E
            float r14 = r1.f13575h
            r12.<init>(r13, r14, r7)
            if (r6 == 0) goto L_0x00ff
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$b r13 = new net.one97.paytm.fastag.dependencies.CJRStateProgressView$b
            int r14 = r1.v
            r13.<init>(r14, r6, r7, r11)
            goto L_0x0100
        L_0x00dc:
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$a r12 = new net.one97.paytm.fastag.dependencies.CJRStateProgressView$a
            android.graphics.drawable.Drawable r13 = r1.F
            float r15 = r1.f13576i
            r12.<init>(r13, r15, r7)
            if (r6 == 0) goto L_0x00ff
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$b r13 = new net.one97.paytm.fastag.dependencies.CJRStateProgressView$b
            int r15 = r1.u
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r0 = r1.C
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJRStatusFlow r0 = (net.one97.paytm.common.entity.shopping.CJRStatusFlow) r0
            java.lang.String r0 = r0.getId()
            boolean r0 = r14.equals(r0)
            r13.<init>(r15, r6, r7, r0)
            goto L_0x0100
        L_0x00ff:
            r13 = 0
        L_0x0100:
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRStateProgressView$a> r0 = r1.A
            r0.add(r12)
            if (r13 == 0) goto L_0x010c
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRStateProgressView$b> r0 = r1.B
            r0.add(r13)
        L_0x010c:
            float r5 = r5 + r4
            r6 = r7
        L_0x010e:
            int r2 = r2 + 1
            goto L_0x0060
        L_0x0112:
            android.graphics.Paint r0 = r1.z
            android.graphics.PathEffect r0 = r0.getPathEffect()
            android.graphics.Paint r2 = r1.z
            float r3 = r1.j
            r2.setStrokeWidth(r3)
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRStateProgressView$b> r2 = r1.B
            java.util.Iterator r13 = r2.iterator()
        L_0x0125:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x0165
            java.lang.Object r2 = r13.next()
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$b r2 = (net.one97.paytm.fastag.dependencies.CJRStateProgressView.b) r2
            android.graphics.Paint r3 = r1.z
            int r4 = r2.f13580a
            r3.setColor(r4)
            boolean r3 = r2.f13583d
            if (r3 == 0) goto L_0x0144
            android.graphics.Paint r3 = r1.z
            android.graphics.DashPathEffect r4 = r1.f13572e
            r3.setPathEffect(r4)
            goto L_0x0149
        L_0x0144:
            android.graphics.Paint r3 = r1.z
            r3.setPathEffect(r0)
        L_0x0149:
            android.graphics.Paint r7 = r1.z
            android.graphics.Point r3 = r2.f13581b
            int r3 = r3.x
            float r3 = (float) r3
            android.graphics.Point r4 = r2.f13581b
            int r4 = r4.y
            float r4 = (float) r4
            android.graphics.Point r5 = r2.f13582c
            int r5 = r5.x
            float r5 = (float) r5
            android.graphics.Point r2 = r2.f13582c
            int r2 = r2.y
            float r6 = (float) r2
            r2 = r17
            r2.drawLine(r3, r4, r5, r6, r7)
            goto L_0x0125
        L_0x0165:
            android.graphics.Paint r2 = r1.z
            r2.setPathEffect(r0)
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRStateProgressView$a> r0 = r1.A
            java.util.Iterator r0 = r0.iterator()
        L_0x0170:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01ab
            java.lang.Object r2 = r0.next()
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$a r2 = (net.one97.paytm.fastag.dependencies.CJRStateProgressView.a) r2
            android.graphics.drawable.Drawable r3 = r2.f13577a
            android.graphics.Point r4 = r2.f13579c
            int r4 = r4.x
            float r4 = (float) r4
            float r5 = r2.f13578b
            float r4 = r4 - r5
            int r4 = (int) r4
            android.graphics.Point r5 = r2.f13579c
            int r5 = r5.y
            float r5 = (float) r5
            float r6 = r2.f13578b
            float r5 = r5 - r6
            int r5 = (int) r5
            android.graphics.Point r6 = r2.f13579c
            int r6 = r6.x
            float r6 = (float) r6
            float r7 = r2.f13578b
            float r6 = r6 + r7
            int r6 = (int) r6
            android.graphics.Point r7 = r2.f13579c
            int r7 = r7.y
            float r7 = (float) r7
            float r13 = r2.f13578b
            float r7 = r7 + r13
            int r7 = (int) r7
            r3.setBounds(r4, r5, r6, r7)
            android.graphics.drawable.Drawable r2 = r2.f13577a
            r2.draw(r8)
            goto L_0x0170
        L_0x01ab:
            android.graphics.Paint r0 = r1.z
            int r2 = r1.s
            r0.setColor(r2)
            android.graphics.Paint r0 = r1.z
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.CENTER
            r0.setTextAlign(r2)
            android.graphics.Paint r0 = r1.z
            r0.setAntiAlias(r10)
            r0 = 0
        L_0x01bf:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r2 = r1.C
            int r2 = r2.size()
            if (r0 >= r2) goto L_0x02bf
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRStatusFlow> r2 = r1.C
            java.lang.Object r2 = r2.get(r0)
            net.one97.paytm.common.entity.shopping.CJRStatusFlow r2 = (net.one97.paytm.common.entity.shopping.CJRStatusFlow) r2
            if (r2 == 0) goto L_0x02bb
            java.lang.String r3 = r2.getText()
            java.lang.String r4 = r2.getmCreatedAt()
            java.lang.String r4 = com.paytm.utility.i.a(r4)
            java.lang.String r5 = r1.x
            java.lang.String r6 = r1.y
            java.lang.String r4 = com.paytm.utility.i.a(r4, r5, r6)
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRStateProgressView$a> r5 = r1.A
            java.lang.Object r5 = r5.get(r0)
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$a r5 = (net.one97.paytm.fastag.dependencies.CJRStateProgressView.a) r5
            android.graphics.Point r5 = r5.f13579c
            int r5 = r5.x
            java.util.ArrayList<net.one97.paytm.fastag.dependencies.CJRStateProgressView$a> r6 = r1.A
            java.lang.Object r6 = r6.get(r0)
            net.one97.paytm.fastag.dependencies.CJRStateProgressView$a r6 = (net.one97.paytm.fastag.dependencies.CJRStateProgressView.a) r6
            android.graphics.Point r6 = r6.f13579c
            int r6 = r6.y
            android.graphics.Paint r7 = r1.z
            float r13 = r1.k
            r7.setTextSize(r13)
            java.lang.String r2 = r2.getColor()
            boolean r2 = r12.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0215
            android.graphics.Paint r2 = r1.z
            int r7 = r1.t
            r2.setColor(r7)
        L_0x0215:
            android.graphics.Paint r2 = r1.z
            float r7 = r1.l
            r2.setTextSize(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r7 = ""
            if (r2 == 0) goto L_0x0229
            java.lang.String[] r2 = new java.lang.String[]{r7}
            goto L_0x0259
        L_0x0229:
            r2 = 32
            int r2 = r3.indexOf(r2)
            r13 = -1
            if (r2 == r13) goto L_0x0247
            java.lang.String r13 = r3.substring(r11, r2)
            int r14 = r3.length()
            if (r2 >= r14) goto L_0x0248
            if (r2 < 0) goto L_0x0248
            int r7 = r3.length()
            java.lang.String r7 = r3.substring(r2, r7)
            goto L_0x0248
        L_0x0247:
            r13 = r3
        L_0x0248:
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto L_0x0253
            java.lang.String[] r2 = new java.lang.String[r10]
            r2[r11] = r13
            goto L_0x0259
        L_0x0253:
            java.lang.String[] r2 = new java.lang.String[r9]
            r2[r11] = r13
            r2[r10] = r7
        L_0x0259:
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 != 0) goto L_0x0290
            int r7 = r2.length
            if (r7 <= r10) goto L_0x0283
            r3 = r2[r11]
            float r7 = (float) r5
            float r13 = (float) r6
            float r14 = r1.m
            float r14 = r14 + r13
            float r15 = r1.f13575h
            float r14 = r14 + r15
            android.graphics.Paint r15 = r1.z
            r8.drawText(r3, r7, r14, r15)
            r2 = r2[r10]
            float r3 = r1.m
            float r13 = r13 + r3
            float r3 = r1.f13575h
            float r13 = r13 + r3
            float r3 = r1.n
            float r13 = r13 + r3
            android.graphics.Paint r3 = r1.z
            r8.drawText(r2, r7, r13, r3)
            r2 = 1
            goto L_0x0291
        L_0x0283:
            float r2 = (float) r5
            float r7 = (float) r6
            float r13 = r1.m
            float r7 = r7 + r13
            float r13 = r1.f13575h
            float r7 = r7 + r13
            android.graphics.Paint r13 = r1.z
            r8.drawText(r3, r2, r7, r13)
        L_0x0290:
            r2 = 0
        L_0x0291:
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L_0x02bb
            if (r2 == 0) goto L_0x02ab
            float r2 = (float) r5
            float r3 = (float) r6
            float r5 = r1.m
            float r3 = r3 + r5
            float r5 = r1.f13575h
            float r3 = r3 + r5
            float r5 = r1.n
            float r3 = r3 + r5
            float r3 = r3 + r5
            android.graphics.Paint r5 = r1.z
            r8.drawText(r4, r2, r3, r5)
            goto L_0x02bb
        L_0x02ab:
            float r2 = (float) r5
            float r3 = (float) r6
            float r5 = r1.m
            float r3 = r3 + r5
            float r5 = r1.f13575h
            float r3 = r3 + r5
            float r5 = r1.n
            float r3 = r3 + r5
            android.graphics.Paint r5 = r1.z
            r8.drawText(r4, r2, r3, r5)
        L_0x02bb:
            int r0 = r0 + 1
            goto L_0x01bf
        L_0x02bf:
            android.graphics.Paint r0 = r1.z
            int r2 = r1.w
            r0.setColor(r2)
        L_0x02c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.dependencies.CJRStateProgressView.onDraw(android.graphics.Canvas):void");
    }
}
