package net.one97.paytm.o2o.movies.c;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import d.a.a.c;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2;
import net.one97.paytm.o2o.movies.d.i;
import net.one97.paytm.o2o.movies.d.j;
import net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond;
import net.one97.paytm.o2o.movies.utils.ad;
import net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS;

public final class g extends RecyclerView.v implements j {

    /* renamed from: a  reason: collision with root package name */
    Context f74972a;

    /* renamed from: b  reason: collision with root package name */
    CJRSummaryHeaderItemV2 f74973b;

    /* renamed from: c  reason: collision with root package name */
    CPSlabAndTncBS f74974c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f74975d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f74976e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f74977f;

    /* renamed from: g  reason: collision with root package name */
    private AppCompatImageView f74978g;

    /* renamed from: h  reason: collision with root package name */
    private i f74979h;

    /* renamed from: i  reason: collision with root package name */
    private View f74980i = null;
    private int j;
    private int k;
    private int l;
    private boolean m = false;
    private LinearLayout n;
    private ConstraintLayout o;
    private CJRSummaryMovieDescItemV2 p;

    public g(Context context, View view, i iVar) {
        super(view);
        this.f74972a = context;
        this.f74980i = view;
        this.f74979h = iVar;
        this.f74978g = (AppCompatImageView) view.findViewById(R.id.movie_status_icon);
        this.f74975d = (RoboTextView) view.findViewById(R.id.movie_summary_status);
        this.f74977f = (RoboTextView) view.findViewById(R.id.tryAgainTv);
        this.f74976e = (RoboTextView) view.findViewById(R.id.movie_header_payment_desc);
        this.n = (LinearLayout) view.findViewById(R.id.layout_cancellable);
        this.o = (ConstraintLayout) view.findViewById(R.id.movie_summary_header);
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r17, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r18) {
        /*
            r16 = this;
            r0 = r16
            if (r18 != 0) goto L_0x0005
            return
        L_0x0005:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r18.getSummaryHeader()
            if (r1 != 0) goto L_0x000c
            return
        L_0x000c:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r18.getSummaryHeader()
            r0.f74973b = r1
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r1 = r18.getMovieDescItem()
            r0.p = r1
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            int r1 = r1.getMovieTicketStatus()
            r0.l = r1
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isCancellationAllowed()
            r0.m = r1
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r1 = r0.p
            r2 = 15
            if (r1 == 0) goto L_0x0072
            int r1 = r1.getMovieTicketStatus()
            if (r1 != r2) goto L_0x0072
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r1 = r0.p
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r1 = r1.getInsuranceConfig()
            if (r1 == 0) goto L_0x0072
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r1 = r0.p
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r1 = r1.getInsuranceConfig()
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r1 = r1.getTerms_cond()
            if (r1 == 0) goto L_0x0072
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r1 = r0.p
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r1 = r1.getInsuranceConfig()
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r1 = r1.getTerms_cond()
            net.one97.paytm.o2o.movies.entity.CJRCPSlab r1 = r1.getSlabs()
            if (r1 != 0) goto L_0x0068
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r1 = r0.p
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r1 = r1.getInsuranceConfig()
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r1 = r1.getTerms_cond()
            net.one97.paytm.o2o.movies.entity.CJRCPTerm r1 = r1.getTerms()
            if (r1 == 0) goto L_0x0072
        L_0x0068:
            android.widget.LinearLayout r1 = r0.n
            net.one97.paytm.o2o.movies.c.-$$Lambda$g$QvL0fpzwAl3TrXhlwUhcAY7FAtQ r3 = new net.one97.paytm.o2o.movies.c.-$$Lambda$g$QvL0fpzwAl3TrXhlwUhcAY7FAtQ
            r3.<init>()
            r1.setOnClickListener(r3)
        L_0x0072:
            androidx.appcompat.widget.AppCompatImageView r1 = r0.f74978g
            r3 = 16
            java.lang.String r4 = "RETURNED"
            r5 = 20
            java.lang.String r6 = "FAILED"
            java.lang.String r7 = "SUCCESS"
            r8 = 0
            if (r1 == 0) goto L_0x00db
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00db
            androidx.appcompat.widget.AppCompatImageView r1 = r0.f74978g
            r1.setVisibility(r8)
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r9 = r1.equalsIgnoreCase(r7)
            if (r9 == 0) goto L_0x00b6
            int r1 = r0.l
            if (r1 != r5) goto L_0x00ab
            android.content.Context r1 = r0.f74972a
            int r9 = net.one97.paytm.common.assets.R.drawable.ic_movie_order_failure
            android.graphics.drawable.Drawable r1 = androidx.appcompat.a.a.a.b(r1, r9)
            goto L_0x00d4
        L_0x00ab:
            if (r1 == r3) goto L_0x00c3
            android.content.Context r1 = r0.f74972a
            int r9 = net.one97.paytm.o2o.movies.R.drawable.ic_movie_order_confirmed
            android.graphics.drawable.Drawable r1 = androidx.appcompat.a.a.a.b(r1, r9)
            goto L_0x00d4
        L_0x00b6:
            boolean r9 = r1.equalsIgnoreCase(r6)
            if (r9 != 0) goto L_0x00cc
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x00c3
            goto L_0x00cc
        L_0x00c3:
            android.content.Context r1 = r0.f74972a
            int r9 = net.one97.paytm.common.assets.R.drawable.ic_movie_pending_icon
            android.graphics.drawable.Drawable r1 = androidx.appcompat.a.a.a.b(r1, r9)
            goto L_0x00d4
        L_0x00cc:
            android.content.Context r1 = r0.f74972a
            int r9 = net.one97.paytm.o2o.movies.R.drawable.ic_movie_order_failed
            android.graphics.drawable.Drawable r1 = androidx.appcompat.a.a.a.b(r1, r9)
        L_0x00d4:
            if (r1 == 0) goto L_0x00db
            androidx.appcompat.widget.AppCompatImageView r9 = r0.f74978g
            r9.setImageDrawable(r1)
        L_0x00db:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            com.paytm.utility.RoboTextView r9 = r0.f74975d
            java.lang.String r10 = "BOOKED"
            r12 = 7
            r13 = -1
            if (r9 == 0) goto L_0x0229
            java.lang.String r9 = r1.getPaymentStatus()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0229
            java.lang.String r9 = r1.getSummaryType()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0229
            com.paytm.utility.RoboTextView r9 = r0.f74975d
            r9.setVisibility(r8)
            java.lang.String r9 = r1.getPaymentStatus()
            java.lang.String r14 = r1.getOrderStatus()
            r1.getSummaryType()
            r1.getMerchantName()
            r1.getOrderId()
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            r9 = 8
            if (r1 == 0) goto L_0x011a
            r1 = 0
            goto L_0x0201
        L_0x011a:
            boolean r1 = r14.equalsIgnoreCase(r7)
            r15 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r1 != 0) goto L_0x0165
            boolean r1 = r14.equalsIgnoreCase(r10)
            if (r1 == 0) goto L_0x0129
            goto L_0x0165
        L_0x0129:
            boolean r1 = r14.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x013f
            r0.j = r15
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r14 = net.one97.paytm.o2o.movies.R.string.movie_booking_failed
            java.lang.String r1 = r1.getString(r14)
            goto L_0x0201
        L_0x013f:
            boolean r1 = r14.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x0155
            r0.j = r15
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r14 = net.one97.paytm.o2o.movies.R.string.movie_returned_header
            java.lang.String r1 = r1.getString(r14)
            goto L_0x0201
        L_0x0155:
            r0.j = r15
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r14 = net.one97.paytm.o2o.movies.R.string.confirmation_pending
            java.lang.String r1 = r1.getString(r14)
            goto L_0x0201
        L_0x0165:
            r1 = 4
            r0.k = r1
            android.widget.LinearLayout r1 = r0.n
            r1.setVisibility(r9)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.o
            r1.setBackgroundColor(r13)
            boolean r1 = r0.m
            r14 = 3
            if (r1 == 0) goto L_0x01a4
            int r1 = r0.l
            if (r1 == r2) goto L_0x017d
            if (r1 != r12) goto L_0x01a4
        L_0x017d:
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r15 = net.one97.paytm.o2o.movies.R.string.movie_booking_confirmed
            java.lang.String r1 = r1.getString(r15)
            r0.j = r13
            r0.k = r14
            android.widget.LinearLayout r14 = r0.n
            r14.setVisibility(r8)
            androidx.constraintlayout.widget.ConstraintLayout r14 = r0.o
            android.content.Context r15 = r0.f74972a
            android.content.res.Resources r15 = r15.getResources()
            int r11 = net.one97.paytm.o2o.movies.R.color.greenblue
            int r11 = r15.getColor(r11)
            r14.setBackgroundColor(r11)
            goto L_0x01b6
        L_0x01a4:
            int r1 = r0.l
            if (r1 != r5) goto L_0x01b8
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r11 = net.one97.paytm.o2o.movies.R.string.movie_booking_cancelled
            java.lang.String r1 = r1.getString(r11)
            r0.j = r15
        L_0x01b6:
            r11 = r1
            goto L_0x0200
        L_0x01b8:
            if (r1 != r3) goto L_0x01c9
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r11 = net.one97.paytm.o2o.movies.R.string.movie_cancellation_pending
            java.lang.String r1 = r1.getString(r11)
            r0.j = r15
            goto L_0x01b6
        L_0x01c9:
            r0.j = r13
            r0.k = r14
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.o
            android.content.Context r11 = r0.f74972a
            android.content.res.Resources r11 = r11.getResources()
            int r14 = net.one97.paytm.o2o.movies.R.color.greenblue
            int r11 = r11.getColor(r14)
            r1.setBackgroundColor(r11)
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isFromPostOrder()
            if (r1 == 0) goto L_0x01f3
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r11 = net.one97.paytm.o2o.movies.R.string.movie_order_confirmed
            java.lang.String r1 = r1.getString(r11)
            goto L_0x01b6
        L_0x01f3:
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r11 = net.one97.paytm.o2o.movies.R.string.movie_booking_confirmed
            java.lang.String r1 = r1.getString(r11)
            goto L_0x01b6
        L_0x0200:
            r1 = r11
        L_0x0201:
            boolean r11 = android.text.TextUtils.isEmpty(r1)
            if (r11 != 0) goto L_0x0224
            com.paytm.utility.RoboTextView r9 = r0.f74975d
            r9.setText(r1)
            int r1 = r0.j
            if (r1 == 0) goto L_0x0215
            com.paytm.utility.RoboTextView r9 = r0.f74975d
            r9.setTextColor(r1)
        L_0x0215:
            int r1 = r0.k
            if (r1 == 0) goto L_0x021e
            com.paytm.utility.RoboTextView r9 = r0.f74975d
            r9.setFontType(r1)
        L_0x021e:
            com.paytm.utility.RoboTextView r1 = r0.f74975d
            r1.setVisibility(r8)
            goto L_0x0229
        L_0x0224:
            com.paytm.utility.RoboTextView r1 = r0.f74975d
            r1.setVisibility(r9)
        L_0x0229:
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            if (r1 == 0) goto L_0x03c9
            java.lang.String r1 = "#00baf2"
            int r1 = android.graphics.Color.parseColor(r1)
            boolean r9 = r0.m
            if (r9 == 0) goto L_0x0243
            int r9 = r0.l
            if (r9 == r2) goto L_0x023d
            if (r9 != r12) goto L_0x0243
        L_0x023d:
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            r1.setTextColor(r13)
            goto L_0x024f
        L_0x0243:
            com.paytm.utility.RoboTextView r9 = r0.f74976e
            java.lang.String r11 = "#e6454545"
            int r11 = android.graphics.Color.parseColor(r11)
            r9.setTextColor(r11)
            r13 = r1
        L_0x024f:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0324
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = r1.equalsIgnoreCase(r7)
            if (r1 != 0) goto L_0x0273
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = r1.equalsIgnoreCase(r10)
            if (r1 == 0) goto L_0x0324
        L_0x0273:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isFromPostOrder()
            if (r1 == 0) goto L_0x027c
            return
        L_0x027c:
            int r1 = r0.l
            if (r1 != r2) goto L_0x02ae
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isShareBookingId()
            if (r1 != 0) goto L_0x02ae
            net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r1 = "movieOrderInsuredText"
            r2 = 0
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.c.a(r1, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x02a4
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.o2o.movies.R.string.movie_order_insured_text
            java.lang.String r1 = r1.getString(r2)
        L_0x02a4:
            int r2 = r1.length()
            int r3 = r2 + -10
            r0.a(r1, r3, r2, r13)
            return
        L_0x02ae:
            int r1 = r0.l
            if (r1 != r5) goto L_0x02c8
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.o2o.movies.R.string.movie_order_insurance_cancel_text
            java.lang.String r1 = r1.getString(r2)
            int r2 = r1.length()
            int r3 = r2 + -3
            r0.a(r1, r3, r2, r13)
            return
        L_0x02c8:
            if (r1 != r3) goto L_0x02de
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.o2o.movies.R.string.click_to_know_more
            java.lang.String r1 = r1.getString(r2)
            int r2 = r1.length()
            r0.a(r1, r8, r2, r13)
            return
        L_0x02de:
            if (r1 != r12) goto L_0x02f5
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isQRcodePresent()
            if (r1 != 0) goto L_0x0304
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.o2o.movies.R.string.movie_order_success_status_no_qr
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0313
        L_0x02f5:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isQRcodePresent()
            if (r1 == 0) goto L_0x0307
            d.a.a.c r1 = d.a.a.c.a()     // Catch:{ Exception -> 0x0304 }
            r1.a((java.lang.Object) r0, (boolean) r8)     // Catch:{ Exception -> 0x0304 }
        L_0x0304:
            java.lang.String r1 = ""
            goto L_0x0313
        L_0x0307:
            android.content.Context r1 = r0.f74972a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.o2o.movies.R.string.movie_order_success_status_no_qr
            java.lang.String r1 = r1.getString(r2)
        L_0x0313:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0323
            com.paytm.utility.RoboTextView r2 = r0.f74976e
            r2.setVisibility(r8)
            com.paytm.utility.RoboTextView r2 = r0.f74976e
            r2.setText(r1)
        L_0x0323:
            return
        L_0x0324:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0384
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = r1.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x0384
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            r1.setVisibility(r8)
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isFromPostOrder()
            if (r1 != 0) goto L_0x0358
            com.paytm.utility.RoboTextView r1 = r0.f74977f
            r1.setVisibility(r8)
            com.paytm.utility.RoboTextView r1 = r0.f74977f
            net.one97.paytm.o2o.movies.c.-$$Lambda$g$CGu-hJ6KPGIX1Jwsx5GW3MxMHuY r2 = new net.one97.paytm.o2o.movies.c.-$$Lambda$g$CGu-hJ6KPGIX1Jwsx5GW3MxMHuY
            r2.<init>()
            r1.setOnClickListener(r2)
        L_0x0358:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            boolean r1 = r1.isFromPostOrder()
            if (r1 == 0) goto L_0x0372
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            android.content.Context r2 = r0.f74972a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.string.movie_order_failed_status_post_fnb
            java.lang.String r2 = r2.getString(r3)
            r1.setText(r2)
            return
        L_0x0372:
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            android.content.Context r2 = r0.f74972a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.string.movie_order_failed_status
            java.lang.String r2 = r2.getString(r3)
            r1.setText(r2)
            return
        L_0x0384:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03b3
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r0.f74973b
            java.lang.String r1 = r1.getOrderStatus()
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x03b3
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            android.content.Context r2 = r0.f74972a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.string.movie_returned_sub_header
            java.lang.String r2 = r2.getString(r3)
            r1.setText(r2)
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            r1.setVisibility(r8)
            return
        L_0x03b3:
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            r1.setVisibility(r8)
            com.paytm.utility.RoboTextView r1 = r0.f74976e
            android.content.Context r2 = r0.f74972a
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.string.movie_order_pending_status
            java.lang.String r2 = r2.getString(r3)
            r1.setText(r2)
        L_0x03c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.c.g.a(android.content.Context, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f74979h.a(ad.CANCEL_MOVIE_TICKET_TNC_CLICK, (IJRDataModel) this.p);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f74979h.a(ad.TRY_AGAIN_BUTTON_CLICK, (IJRDataModel) null);
    }

    private void a(String str, int i2, int i3, int i4) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                CJRCPTermsAndCond insuranceTerms;
                if (g.this.f74972a != null && (insuranceTerms = g.this.f74973b.getInsuranceTerms()) != null) {
                    if (g.this.f74974c != null) {
                        g.this.f74974c.f76195a.dismiss();
                        g.this.f74974c = null;
                    }
                    g gVar = g.this;
                    gVar.f74974c = new CPSlabAndTncBS(gVar.f74972a, insuranceTerms);
                    g.this.f74974c.f76195a.show();
                }
            }
        }, i2, i3, 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 18);
        this.f74976e.setText(spannableStringBuilder);
        this.f74976e.setMovementMethod(LinkMovementMethod.getInstance());
        this.f74976e.setVisibility(0);
    }

    public final void onEvent(Boolean bool) {
        if (bool != null) {
            if (this.l == 7) {
                this.f74976e.setText(this.f74972a.getResources().getString(bool.booleanValue() ? R.string.movie_insurance_delivered_status_qr : R.string.movie_order_success_status_no_qr));
            } else {
                this.f74976e.setText(this.f74972a.getResources().getString(bool.booleanValue() ? R.string.movie_order_success_status_qr : R.string.movie_order_success_status_no_qr));
            }
        }
        c.a().b(this);
    }
}
