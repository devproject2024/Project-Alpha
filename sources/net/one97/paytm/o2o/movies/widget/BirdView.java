package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat;

public class BirdView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final float f76111a;

    /* renamed from: b  reason: collision with root package name */
    private final CJRSeat f76112b;

    /* renamed from: c  reason: collision with root package name */
    private int f76113c;

    /* renamed from: d  reason: collision with root package name */
    private int f76114d;

    /* renamed from: e  reason: collision with root package name */
    private CJRMoviesSession f76115e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f76116f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    private Paint f76117g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f76118h;

    public BirdView(Context context, float f2, CJRSeat cJRSeat, int i2, int i3, CJRMoviesSession cJRMoviesSession) {
        super(context);
        this.f76111a = f2;
        this.f76112b = cJRSeat;
        this.f76113c = i2;
        this.f76114d = i3;
        this.f76115e = cJRMoviesSession;
        this.f76116f.setColor(context.getResources().getColor(R.color.white));
        this.f76118h = new Paint();
        this.f76118h.setColor(context.getResources().getColor(net.one97.paytm.common.assets.R.color.color_8D8D8D));
        this.f76117g = new Paint();
        this.f76117g.setColor(context.getResources().getColor(R.color.paytm_blue));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0133 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r22) {
        /*
            r21 = this;
            r0 = r21
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeat r1 = r0.f76112b
            net.one97.paytm.o2o.movies.common.movies.seats.CJRSeatLayout r1 = r1.getSeatLayout()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRColAreas r1 = r1.getColAreas()
            java.util.ArrayList r1 = r1.getObjArea()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0014:
            int r6 = r1.size()
            if (r4 >= r6) goto L_0x0137
            java.lang.Object r6 = r1.get(r4)
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjArea r6 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjArea) r6
            if (r6 == 0) goto L_0x0133
            java.util.ArrayList r7 = r6.getObjRow()
            if (r7 == 0) goto L_0x0133
            java.util.ArrayList r7 = r6.getObjRow()
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x0133
            java.lang.String r7 = r6.getAreaCode()
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            r9 = 1
            if (r8 != 0) goto L_0x007b
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r0.f76115e
            if (r8 == 0) goto L_0x007b
            java.util.ArrayList r8 = r8.getMoviesSessionDetails()
            if (r8 == 0) goto L_0x007b
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = r0.f76115e
            java.util.ArrayList r8 = r8.getMoviesSessionDetails()
            java.util.Iterator r8 = r8.iterator()
        L_0x0051:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x007b
            java.lang.Object r10 = r8.next()
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails r10 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSessionDetails) r10
            if (r10 == 0) goto L_0x0051
            net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesPriceDetails r11 = r10.getMoviesPriceDetails()
            if (r11 == 0) goto L_0x0051
            java.lang.String r11 = r10.getAreaCatCode()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0051
            java.lang.String r10 = r10.getAreaCatCode()
            boolean r10 = r7.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x0051
            r7 = 1
            goto L_0x007c
        L_0x007b:
            r7 = 0
        L_0x007c:
            if (r7 == 0) goto L_0x0133
            int r7 = r0.f76113c
            float r7 = (float) r7
            float r5 = r5 + r7
            java.util.ArrayList r6 = r6.getObjRow()
            r7 = -1
            java.util.Iterator r6 = r6.iterator()
        L_0x008b:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0133
            java.lang.Object r8 = r6.next()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow r8 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjRow) r8
            if (r7 <= 0) goto L_0x00a3
            int r10 = r8.getGridRowId()
            int r10 = r10 - r7
            if (r10 <= r9) goto L_0x00a3
            float r7 = r0.f76111a
            float r5 = r5 + r7
        L_0x00a3:
            if (r8 == 0) goto L_0x012d
            java.util.ArrayList r7 = r8.getObjSeat()
            if (r7 == 0) goto L_0x012d
            java.util.ArrayList r7 = r8.getObjSeat()
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x012d
            java.util.ArrayList r7 = r8.getObjSeat()
            int r10 = r0.f76114d
            int r10 = r10 - r9
            java.util.Iterator r7 = r7.iterator()
            r11 = 0
        L_0x00c1:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x012a
            java.lang.Object r12 = r7.next()
            net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat r12 = (net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat) r12
            if (r12 == 0) goto L_0x00c1
            int r13 = r12.getGridSeatNum()
            if (r13 < 0) goto L_0x00c1
            int r13 = r12.getGridSeatNum()
            int r10 = r13 - r10
            if (r10 <= r9) goto L_0x00e5
            int r10 = r10 + -1
            float r10 = (float) r10
            float r14 = r0.f76111a
            float r10 = r10 * r14
            float r11 = r11 + r10
        L_0x00e5:
            java.lang.String r10 = r12.getSeatStatus()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00fd
            java.lang.String r10 = r12.getSeatStatus()
            java.lang.String r14 = "0"
            boolean r10 = r10.equalsIgnoreCase(r14)
            if (r10 == 0) goto L_0x00fd
            r10 = 1
            goto L_0x00fe
        L_0x00fd:
            r10 = 0
        L_0x00fe:
            r14 = 1065353216(0x3f800000, float:1.0)
            float r16 = r11 + r14
            float r17 = r5 + r14
            float r15 = r0.f76111a
            float r18 = r11 + r15
            float r18 = r18 - r14
            float r15 = r15 + r5
            float r19 = r15 - r14
            boolean r12 = r12.isSelected()
            if (r12 == 0) goto L_0x0118
            android.graphics.Paint r10 = r0.f76117g
        L_0x0115:
            r20 = r10
            goto L_0x0120
        L_0x0118:
            if (r10 == 0) goto L_0x011d
            android.graphics.Paint r10 = r0.f76116f
            goto L_0x0115
        L_0x011d:
            android.graphics.Paint r10 = r0.f76118h
            goto L_0x0115
        L_0x0120:
            r15 = r22
            r15.drawRect(r16, r17, r18, r19, r20)
            float r10 = r0.f76111a
            float r11 = r11 + r10
            r10 = r13
            goto L_0x00c1
        L_0x012a:
            float r7 = r0.f76111a
            float r5 = r5 + r7
        L_0x012d:
            int r7 = r8.getGridRowId()
            goto L_0x008b
        L_0x0133:
            int r4 = r4 + 1
            goto L_0x0014
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.widget.BirdView.onDraw(android.graphics.Canvas):void");
    }
}
