package net.one97.paytm.o2o.movies.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ba;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodVoucherItem;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.a;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem;
import net.one97.paytm.o2o.movies.d.i;
import net.one97.paytm.o2o.movies.d.j;
import net.one97.paytm.o2o.movies.fragment.j;
import net.one97.paytm.o2o.movies.utils.ad;
import net.one97.paytm.o2o.movies.utils.n;

public class c extends RecyclerView.v implements j, j.a {

    /* renamed from: d  reason: collision with root package name */
    private static String f74948d = c.class.getSimpleName();
    private RelativeLayout A;
    private RelativeLayout B;
    private RelativeLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private MaterialCardView F;
    private MaterialCardView G;
    private LinearLayout H;
    private ConstraintLayout I;
    private LinearLayout J;
    private LinearLayout K;
    /* access modifiers changed from: private */
    public ConstraintLayout L;
    /* access modifiers changed from: private */
    public ProgressBar M;
    /* access modifiers changed from: private */
    public ImageView N;
    private ImageView O;
    private ConstraintLayout P;
    private ConstraintLayout Q;
    private RecyclerView R;
    private View S;
    private TextView T;
    private TextView U;

    /* renamed from: a  reason: collision with root package name */
    String f74949a;

    /* renamed from: b  reason: collision with root package name */
    String f74950b;

    /* renamed from: c  reason: collision with root package name */
    String f74951c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f74952e;

    /* renamed from: f  reason: collision with root package name */
    private i f74953f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f74954g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f74955h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f74956i;
    private RoboTextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    /* access modifiers changed from: private */
    public TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    /* access modifiers changed from: private */
    public ProgressBar y;
    private String z;

    public c(Context context, View view, i iVar) {
        super(view);
        this.f74952e = context;
        this.f74953f = iVar;
        this.f74954g = (ImageView) view.findViewById(R.id.content_thumbnail_movie);
        this.y = (ProgressBar) view.findViewById(R.id.loading_movie);
        this.j = (RoboTextView) view.findViewById(R.id.movie_name);
        this.k = (TextView) view.findViewById(R.id.movie_censor);
        this.l = (TextView) view.findViewById(R.id.movie_duration);
        this.m = (TextView) view.findViewById(R.id.movie_screen_format);
        this.n = (TextView) view.findViewById(R.id.movie_language);
        this.Q = (ConstraintLayout) view.findViewById(R.id.layout_ticket_divider);
        this.C = (RelativeLayout) view.findViewById(R.id.layout_ticket_detail);
        this.o = (TextView) view.findViewById(R.id.txt_total_amount);
        this.S = view.findViewById(R.id.layout_success_color);
        this.J = (LinearLayout) view.findViewById(R.id.movieScreenLl);
        this.K = (LinearLayout) view.findViewById(R.id.movieSeatLl);
        this.L = (ConstraintLayout) view.findViewById(R.id.qrContainerRl);
        this.M = (ProgressBar) view.findViewById(R.id.qrProgressBar);
        this.N = (ImageView) view.findViewById(R.id.qrCodeIv);
        this.O = (ImageView) view.findViewById(R.id.locationIv);
        this.p = (TextView) view.findViewById(R.id.id_movie_summary_day);
        this.q = (TextView) view.findViewById(R.id.id_movie_summary_time);
        this.w = (TextView) view.findViewById(R.id.id_movie_summary_cinema_location);
        this.r = (TextView) view.findViewById(R.id.id_movie_summary_cinema_name);
        this.s = (TextView) view.findViewById(R.id.id_movie_summary_audi);
        this.t = (TextView) view.findViewById(R.id.id_movie_summary_seats);
        this.u = (TextView) view.findViewById(R.id.qr_desc);
        this.v = (TextView) view.findViewById(R.id.booking_id);
        this.f74955h = (ImageView) view.findViewById(R.id.content_thumbnail_qr);
        this.A = (RelativeLayout) view.findViewById(R.id.postorder_food_lyt);
        this.P = (ConstraintLayout) view.findViewById(R.id.viewPaymentDetailLl);
        this.f74956i = (ImageView) view.findViewById(R.id.id_summary_payment_arrow);
        this.F = (MaterialCardView) view.findViewById(R.id.downloadLl);
        this.E = (LinearLayout) view.findViewById(R.id.cancel_ticket_layout);
        this.G = (MaterialCardView) view.findViewById(R.id.btn_cancel_ticket);
        this.x = (TextView) view.findViewById(R.id.btn_cp_tnc);
        this.D = (LinearLayout) view.findViewById(R.id.screen_capture_linear_layout);
        this.H = (LinearLayout) view.findViewById(R.id.dateTimeLl);
        this.I = (ConstraintLayout) view.findViewById(R.id.movie_summary_cinema_location_layout);
        this.B = (RelativeLayout) view.findViewById(R.id.layout_food_voucher);
        this.R = (RecyclerView) view.findViewById(R.id.recycler_view_food_voucher);
        this.T = (TextView) view.findViewById(R.id.post_order_desc_tv);
        this.U = (TextView) view.findViewById(R.id.post_order_custom_promo_tv);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cc A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0146 A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0188 A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0198 A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a6 A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01ad A[Catch:{ Exception -> 0x01b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0263 A[SYNTHETIC, Splitter:B:90:0x0263] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r18, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r19) {
        /*
            r17 = this;
            r1 = r17
            if (r19 != 0) goto L_0x0005
            return
        L_0x0005:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r0 = r19.getMovieDescItem()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r2 = r19.getMovieDescItem()
            r19.getContactUsItem()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r3 = r19.getMoviePaymentItem()
            java.lang.String r0 = r19.getOrderStatus()
            int r4 = r2.getMovieTicketStatus()
            java.lang.String r5 = "SUCCESS"
            boolean r6 = r0.equalsIgnoreCase(r5)
            if (r2 != 0) goto L_0x0028
            return
        L_0x0028:
            boolean r7 = r5.equals(r0)
            java.lang.String r8 = "BOOKED"
            r9 = 7
            r10 = 15
            r11 = 8
            r12 = 0
            if (r7 != 0) goto L_0x003c
            boolean r7 = r8.equals(r0)
            if (r7 == 0) goto L_0x0041
        L_0x003c:
            if (r4 == r10) goto L_0x0047
            if (r4 != r9) goto L_0x0041
            goto L_0x0047
        L_0x0041:
            android.view.View r4 = r1.S
            r4.setVisibility(r11)
            goto L_0x004c
        L_0x0047:
            android.view.View r4 = r1.S
            r4.setVisibility(r12)
        L_0x004c:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r2.getSummary()
            java.lang.String r4 = r4.getStatus()
            boolean r4 = r4.equalsIgnoreCase(r5)
            r7 = 1
            r4 = r4 ^ r7
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r13 = r2.getMetaDataresponse()
            int r14 = r2.getMovieTicketStatus()
            if (r13 == 0) goto L_0x02e8
            if (r13 == 0) goto L_0x00a8
            java.lang.String r15 = r13.getMovieImageUrl()
            if (r15 == 0) goto L_0x00a8
            java.lang.String r15 = r13.getMovieImageUrl()
            if (r15 == 0) goto L_0x008a
            java.lang.String r7 = "https://"
            boolean r16 = r15.startsWith(r7)
            if (r16 != 0) goto L_0x008a
            java.lang.String r11 = "http://"
            boolean r11 = r15.startsWith(r11)
            if (r11 != 0) goto L_0x008a
            java.lang.String r11 = java.lang.String.valueOf(r15)
            java.lang.String r15 = r7.concat(r11)
        L_0x008a:
            net.one97.paytm.o2o.movies.common.g.a()
            android.widget.ImageView r7 = r1.f74954g
            net.one97.paytm.o2o.movies.c.c$2 r11 = new net.one97.paytm.o2o.movies.c.c$2
            r11.<init>()
            com.squareup.picasso.w r12 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r12 = r12.a((java.lang.String) r15)
            net.one97.paytm.o2o.movies.common.widgets.a r15 = new net.one97.paytm.o2o.movies.common.widgets.a
            r15.<init>()
            com.squareup.picasso.aa r12 = r12.a((com.squareup.picasso.ah) r15)
            r12.a((android.widget.ImageView) r7, (com.squareup.picasso.e) r11)
        L_0x00a8:
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x01b5 }
            if (r5 != 0) goto L_0x00b4
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x01b5 }
            if (r0 == 0) goto L_0x00b9
        L_0x00b4:
            if (r14 == r10) goto L_0x00bb
            if (r14 != r9) goto L_0x00b9
            goto L_0x00bb
        L_0x00b9:
            r0 = 0
            goto L_0x00bc
        L_0x00bb:
            r0 = 1
        L_0x00bc:
            java.lang.String r5 = r13.getMovie()     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r7 = r13.getCensor()     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r8 = ""
            int r11 = r13.getDuration()     // Catch:{ Exception -> 0x01b5 }
            if (r11 <= 0) goto L_0x011b
            int r11 = r13.getDuration()     // Catch:{ Exception -> 0x01b5 }
            int r11 = r11 / 60
            int r12 = r13.getDuration()     // Catch:{ Exception -> 0x01b5 }
            int r12 = r12 % 60
            if (r11 <= 0) goto L_0x00ee
            java.lang.String r14 = "hr"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b5 }
            r15.<init>()     // Catch:{ Exception -> 0x01b5 }
            r15.append(r8)     // Catch:{ Exception -> 0x01b5 }
            r15.append(r11)     // Catch:{ Exception -> 0x01b5 }
            r15.append(r14)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r8 = r15.toString()     // Catch:{ Exception -> 0x01b5 }
        L_0x00ee:
            if (r12 <= 0) goto L_0x011b
            int r11 = r8.length()     // Catch:{ Exception -> 0x01b5 }
            if (r11 <= 0) goto L_0x0107
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b5 }
            r11.<init>()     // Catch:{ Exception -> 0x01b5 }
            r11.append(r8)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r8 = " "
            r11.append(r8)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x01b5 }
        L_0x0107:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b5 }
            r11.<init>()     // Catch:{ Exception -> 0x01b5 }
            r11.append(r8)     // Catch:{ Exception -> 0x01b5 }
            r11.append(r12)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r8 = "min"
            r11.append(r8)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x01b5 }
        L_0x011b:
            java.lang.String r11 = r13.getLanguage()     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r12 = r13.getScreenFormat()     // Catch:{ Exception -> 0x01b5 }
            com.paytm.utility.RoboTextView r14 = r1.j     // Catch:{ Exception -> 0x01b5 }
            net.one97.paytm.o2o.movies.utils.n.a((android.widget.TextView) r14, (java.lang.String) r5)     // Catch:{ Exception -> 0x01b5 }
            android.widget.TextView r5 = r1.k     // Catch:{ Exception -> 0x01b5 }
            net.one97.paytm.o2o.movies.utils.n.a((android.widget.TextView) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x01b5 }
            android.widget.TextView r5 = r1.n     // Catch:{ Exception -> 0x01b5 }
            net.one97.paytm.o2o.movies.utils.n.a((android.widget.TextView) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x01b5 }
            android.widget.TextView r5 = r1.l     // Catch:{ Exception -> 0x01b5 }
            net.one97.paytm.o2o.movies.utils.n.a((android.widget.TextView) r5, (java.lang.String) r8)     // Catch:{ Exception -> 0x01b5 }
            android.widget.TextView r5 = r1.m     // Catch:{ Exception -> 0x01b5 }
            net.one97.paytm.o2o.movies.utils.n.a((android.widget.TextView) r5, (java.lang.String) r12)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r5 = r13.getShowTime()     // Catch:{ Exception -> 0x01b5 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01b5 }
            if (r5 != 0) goto L_0x017e
            java.lang.String r5 = r13.getShowTime()     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r7 = "EEE, d MMM"
            java.lang.String r5 = net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r7 = r13.getShowTime()     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r8 = "hh:mm a"
            java.lang.String r7 = net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x01b5 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01b5 }
            if (r8 != 0) goto L_0x0177
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01b5 }
            if (r8 != 0) goto L_0x0177
            android.widget.LinearLayout r8 = r1.H     // Catch:{ Exception -> 0x01b5 }
            r11 = 0
            r8.setVisibility(r11)     // Catch:{ Exception -> 0x01b5 }
            android.widget.TextView r8 = r1.p     // Catch:{ Exception -> 0x01b5 }
            r8.setText(r5)     // Catch:{ Exception -> 0x01b5 }
            android.widget.TextView r5 = r1.q     // Catch:{ Exception -> 0x01b5 }
            r5.setText(r7)     // Catch:{ Exception -> 0x01b5 }
            goto L_0x017e
        L_0x0177:
            android.widget.LinearLayout r5 = r1.H     // Catch:{ Exception -> 0x01b5 }
            r7 = 8
            r5.setVisibility(r7)     // Catch:{ Exception -> 0x01b5 }
        L_0x017e:
            java.lang.String r5 = r13.getCinema()     // Catch:{ Exception -> 0x01b5 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01b5 }
            if (r5 != 0) goto L_0x0198
            android.widget.TextView r5 = r1.r     // Catch:{ Exception -> 0x01b5 }
            r7 = 0
            r5.setVisibility(r7)     // Catch:{ Exception -> 0x01b5 }
            android.widget.TextView r5 = r1.r     // Catch:{ Exception -> 0x01b5 }
            java.lang.String r7 = r13.getCinema()     // Catch:{ Exception -> 0x01b5 }
            r5.setText(r7)     // Catch:{ Exception -> 0x01b5 }
            goto L_0x01a4
        L_0x0198:
            android.widget.TextView r5 = r1.r     // Catch:{ Exception -> 0x01b5 }
            r7 = 8
            r5.setVisibility(r7)     // Catch:{ Exception -> 0x01b5 }
            androidx.constraintlayout.widget.ConstraintLayout r5 = r1.I     // Catch:{ Exception -> 0x01b5 }
            r5.setVisibility(r7)     // Catch:{ Exception -> 0x01b5 }
        L_0x01a4:
            if (r0 == 0) goto L_0x01ad
            android.widget.RelativeLayout r0 = r1.C     // Catch:{ Exception -> 0x01b5 }
            r5 = 0
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x01b5 }
            goto L_0x01c1
        L_0x01ad:
            android.widget.RelativeLayout r0 = r1.C     // Catch:{ Exception -> 0x01b5 }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x01b5 }
            goto L_0x01c1
        L_0x01b5:
            r0 = move-exception
            boolean r5 = com.paytm.utility.b.v
            if (r5 == 0) goto L_0x01c1
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x01c1:
            java.lang.String r0 = r13.getLatitude()
            r1.f74949a = r0
            java.lang.String r0 = r13.getLongitude()
            r1.f74950b = r0
            java.lang.String r0 = r13.getCinema()
            java.lang.String r5 = r13.getCitySearched()
            android.widget.TextView r7 = r1.w
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$dhYi-z-hIQVkAfiW7jSJNokTi30 r8 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$dhYi-z-hIQVkAfiW7jSJNokTi30
            r8.<init>(r13, r0, r5)
            r7.setOnClickListener(r8)
            android.widget.ImageView r7 = r1.O
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$g00ijaxYVaSsAu-QF5tHy3svxYk r8 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$g00ijaxYVaSsAu-QF5tHy3svxYk
            r8.<init>(r13, r0, r5)
            r7.setOnClickListener(r8)
            android.widget.TextView r7 = r1.r
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$tceSTJL2WdqoV5keVMesB_DyKs4 r8 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$tceSTJL2WdqoV5keVMesB_DyKs4
            r8.<init>(r13, r0, r5)
            r7.setOnClickListener(r8)
            boolean r0 = r13.isFreeSeating()
            if (r0 != 0) goto L_0x0263
            java.lang.String r0 = r13.getAudi()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0213
            android.widget.TextView r0 = r1.s
            java.lang.String r5 = r13.getAudi()
            r0.setText(r5)
            android.widget.LinearLayout r0 = r1.J
            r5 = 0
            r0.setVisibility(r5)
            goto L_0x021a
        L_0x0213:
            android.widget.LinearLayout r0 = r1.J
            r5 = 8
            r0.setVisibility(r5)
        L_0x021a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = r13.getSeatIdsReturned()
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x0247
            int r7 = r0.length()
            if (r7 <= 0) goto L_0x0234
            java.lang.String r7 = ", "
            r0.append(r7)
        L_0x0234:
            java.lang.String r7 = net.one97.paytm.o2o.movies.utils.m.a((java.lang.String) r5)
            if (r7 == 0) goto L_0x0244
            int r8 = r7.length()
            if (r8 <= 0) goto L_0x0244
            r0.append(r7)
            goto L_0x0247
        L_0x0244:
            r0.append(r5)
        L_0x0247:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L_0x0256
            android.widget.LinearLayout r0 = r1.K
            r5 = 8
            r0.setVisibility(r5)
            goto L_0x02e8
        L_0x0256:
            android.widget.TextView r5 = r1.t
            r5.setText(r0)
            android.widget.LinearLayout r0 = r1.K
            r5 = 0
            r0.setVisibility(r5)
            goto L_0x02e8
        L_0x0263:
            java.lang.String r0 = r13.getCircleName()     // Catch:{ NotFoundException -> 0x02dc }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ NotFoundException -> 0x02dc }
            if (r0 != 0) goto L_0x028b
            java.lang.String r0 = r13.getCircleName()     // Catch:{ NotFoundException -> 0x02dc }
            java.lang.String r5 = "\\("
            java.lang.String[] r5 = r0.split(r5)     // Catch:{ NotFoundException -> 0x02dc }
            if (r5 == 0) goto L_0x027f
            int r7 = r5.length     // Catch:{ NotFoundException -> 0x02dc }
            if (r7 <= 0) goto L_0x027f
            r7 = 0
            r0 = r5[r7]     // Catch:{ NotFoundException -> 0x02dc }
        L_0x027f:
            android.widget.LinearLayout r5 = r1.J     // Catch:{ NotFoundException -> 0x02dc }
            r7 = 0
            r5.setVisibility(r7)     // Catch:{ NotFoundException -> 0x02dc }
            android.widget.TextView r5 = r1.s     // Catch:{ NotFoundException -> 0x02dc }
            r5.setText(r0)     // Catch:{ NotFoundException -> 0x02dc }
            goto L_0x0292
        L_0x028b:
            android.widget.LinearLayout r0 = r1.J     // Catch:{ NotFoundException -> 0x02dc }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ NotFoundException -> 0x02dc }
        L_0x0292:
            int r0 = r13.getTicketCount()     // Catch:{ NotFoundException -> 0x02dc }
            if (r0 <= 0) goto L_0x02d4
            r5 = 1
            if (r0 != r5) goto L_0x02a8
            android.content.Context r5 = r1.f74952e     // Catch:{ NotFoundException -> 0x02dc }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x02dc }
            int r7 = net.one97.paytm.o2o.movies.R.string.seat     // Catch:{ NotFoundException -> 0x02dc }
            java.lang.String r5 = r5.getString(r7)     // Catch:{ NotFoundException -> 0x02dc }
            goto L_0x02b4
        L_0x02a8:
            android.content.Context r5 = r1.f74952e     // Catch:{ NotFoundException -> 0x02dc }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x02dc }
            int r7 = net.one97.paytm.o2o.movies.R.string.seats     // Catch:{ NotFoundException -> 0x02dc }
            java.lang.String r5 = r5.getString(r7)     // Catch:{ NotFoundException -> 0x02dc }
        L_0x02b4:
            android.widget.TextView r7 = r1.t     // Catch:{ NotFoundException -> 0x02dc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NotFoundException -> 0x02dc }
            r8.<init>()     // Catch:{ NotFoundException -> 0x02dc }
            r8.append(r0)     // Catch:{ NotFoundException -> 0x02dc }
            java.lang.String r0 = "  "
            r8.append(r0)     // Catch:{ NotFoundException -> 0x02dc }
            r8.append(r5)     // Catch:{ NotFoundException -> 0x02dc }
            java.lang.String r0 = r8.toString()     // Catch:{ NotFoundException -> 0x02dc }
            r7.setText(r0)     // Catch:{ NotFoundException -> 0x02dc }
            android.widget.LinearLayout r0 = r1.K     // Catch:{ NotFoundException -> 0x02dc }
            r5 = 0
            r0.setVisibility(r5)     // Catch:{ NotFoundException -> 0x02dc }
            goto L_0x02e8
        L_0x02d4:
            android.widget.LinearLayout r0 = r1.K     // Catch:{ NotFoundException -> 0x02dc }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ NotFoundException -> 0x02dc }
            goto L_0x02e8
        L_0x02dc:
            r0 = move-exception
            boolean r5 = com.paytm.utility.b.v
            if (r5 == 0) goto L_0x02e8
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x02e8:
            if (r4 != 0) goto L_0x03a8
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r0 = r2.getMetaDataresponse()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r2.getMovieItem()
            if (r0 == 0) goto L_0x03a8
            int r5 = r0.getPostFBOrder()
            if (r5 != 0) goto L_0x03a1
            int r5 = r0.getIsPostFBPresent()
            r7 = 1
            if (r5 != r7) goto L_0x03a1
            net.one97.paytm.o2o.movies.b.c r5 = new net.one97.paytm.o2o.movies.b.c
            r5.<init>()
            int r4 = net.one97.paytm.o2o.movies.b.c.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            if (r4 == r9) goto L_0x0318
            if (r4 != r10) goto L_0x030f
            goto L_0x0318
        L_0x030f:
            android.widget.RelativeLayout r0 = r1.A
            r4 = 8
            r0.setVisibility(r4)
            goto L_0x03a8
        L_0x0318:
            android.widget.RelativeLayout r4 = r1.A
            r5 = 0
            r4.setVisibility(r5)
            net.one97.paytm.o2o.movies.common.b.c.a()
            r4 = 0
            java.lang.String r5 = "movies_fnb_label_text"
            java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.c.a(r5, r4)
            net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r7 = "movies_fnb_desc_text"
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.c.a(r7, r4)
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x038f
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x038f
            android.widget.TextView r7 = r1.T
            r7.setText(r5)
            android.widget.TextView r5 = r1.T
            int r5 = r5.getPaddingLeft()
            android.widget.TextView r7 = r1.T
            int r7 = r7.getPaddingTop()
            android.widget.TextView r8 = r1.T
            int r8 = r8.getPaddingRight()
            android.widget.TextView r11 = r1.T
            int r11 = r11.getPaddingBottom()
            android.widget.TextView r12 = r1.T
            android.content.Context r13 = r1.f74952e
            android.content.res.Resources r13 = r13.getResources()
            int r14 = net.one97.paytm.o2o.movies.R.drawable.ic_cashback
            android.graphics.drawable.Drawable r13 = r13.getDrawable(r14)
            r12.setBackground(r13)
            android.widget.TextView r12 = r1.T
            android.content.Context r13 = r1.f74952e
            android.content.res.Resources r13 = r13.getResources()
            int r14 = net.one97.paytm.o2o.movies.R.color.white
            int r13 = r13.getColor(r14)
            r12.setTextColor(r13)
            android.widget.TextView r12 = r1.T
            int r5 = r5 + 20
            int r7 = r7 + 10
            int r8 = r8 + 60
            r12.setPadding(r5, r7, r8, r11)
            android.widget.TextView r5 = r1.U
            r5.setText(r4)
            r5 = 8
            goto L_0x0396
        L_0x038f:
            android.widget.TextView r4 = r1.U
            r5 = 8
            r4.setVisibility(r5)
        L_0x0396:
            android.widget.RelativeLayout r4 = r1.A
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$PpMiVMMeVxR7zKzYBH6pFi3e1R8 r7 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$PpMiVMMeVxR7zKzYBH6pFi3e1R8
            r7.<init>(r0)
            r4.setOnClickListener(r7)
            goto L_0x03a8
        L_0x03a1:
            r5 = 8
            android.widget.RelativeLayout r0 = r1.A
            r0.setVisibility(r5)
        L_0x03a8:
            android.widget.TextView r0 = r1.o
            double r4 = r3.getGrandTotal()
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            java.lang.String r4 = net.one97.paytm.o2o.movies.utils.n.a((java.lang.Double) r4)
            r0.setText(r4)
            r1.a((net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem) r3)
            double r3 = r2.getGrandTotal()
            r7 = 0
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x03d7
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.P
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$L1BAsYHjN6WwBQHSJq1W5qVGYaw r3 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$L1BAsYHjN6WwBQHSJq1W5qVGYaw
            r3.<init>()
            r0.setOnClickListener(r3)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.P
            r3 = 0
            r0.setVisibility(r3)
            goto L_0x03df
        L_0x03d7:
            r3 = 0
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.P
            r4 = 8
            r0.setVisibility(r4)
        L_0x03df:
            if (r6 == 0) goto L_0x0508
            int r0 = r2.getMovieTicketStatus()
            if (r0 != r10) goto L_0x043b
            android.widget.LinearLayout r0 = r1.E
            r0.setVisibility(r3)
            com.google.android.material.card.MaterialCardView r0 = r1.G
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$sjU3xO94p7KyGdqUKDzc9PyTqk8 r3 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$sjU3xO94p7KyGdqUKDzc9PyTqk8
            r3.<init>(r2)
            r0.setOnClickListener(r3)
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r0 = r2.getInsuranceConfig()
            if (r0 == 0) goto L_0x0433
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r0 = r2.getInsuranceConfig()
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r0 = r0.getTerms_cond()
            if (r0 == 0) goto L_0x0433
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r0 = r2.getInsuranceConfig()
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r0 = r0.getTerms_cond()
            net.one97.paytm.o2o.movies.entity.CJRCPSlab r0 = r0.getSlabs()
            if (r0 != 0) goto L_0x0422
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r0 = r2.getInsuranceConfig()
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r0 = r0.getTerms_cond()
            net.one97.paytm.o2o.movies.entity.CJRCPTerm r0 = r0.getTerms()
            if (r0 == 0) goto L_0x0433
        L_0x0422:
            android.widget.TextView r0 = r1.x
            r3 = 0
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.x
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$iOqDdohZtdPw0eCitrCuVxgjYsc r3 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$iOqDdohZtdPw0eCitrCuVxgjYsc
            r3.<init>(r2)
            r0.setOnClickListener(r3)
            goto L_0x0442
        L_0x0433:
            android.widget.TextView r0 = r1.x
            r3 = 8
            r0.setVisibility(r3)
            goto L_0x0442
        L_0x043b:
            r3 = 8
            android.widget.LinearLayout r0 = r1.E
            r0.setVisibility(r3)
        L_0x0442:
            int r0 = r2.getMovieTicketStatus()
            if (r0 == r9) goto L_0x0468
            boolean r0 = r2.isShareBookingId()
            if (r0 == 0) goto L_0x0455
            int r0 = r2.getMovieTicketStatus()
            if (r0 != r10) goto L_0x0455
            goto L_0x0468
        L_0x0455:
            android.widget.RelativeLayout r0 = r1.C
            r2 = 8
            r0.setVisibility(r2)
            com.google.android.material.card.MaterialCardView r0 = r1.F
            r0.setVisibility(r2)
            net.one97.paytm.o2o.movies.d.i r0 = r1.f74953f
            r2 = 0
            r0.a((boolean) r2)
            return
        L_0x0468:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.c.b()
            r0.append(r3)
            java.lang.String r3 = "?ticket_key="
            r0.append(r3)
            java.lang.String r3 = r2.getEncryptedOrderId()
            r0.append(r3)
            java.lang.String r3 = "&size=10"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            android.content.Context r4 = r1.f74952e
            java.lang.String r4 = com.paytm.utility.a.q(r4)
            java.lang.String r5 = "sso_token"
            r3.put(r5, r4)
            net.one97.paytm.o2o.movies.utils.v r4 = net.one97.paytm.o2o.movies.utils.v.INSTANCE
            net.one97.paytm.o2o.movies.c.c$1 r5 = new net.one97.paytm.o2o.movies.c.c$1
            r5.<init>()
            r4.loadImage(r0, r5, r3)
            java.lang.String r0 = r2.getUniqueBookingId()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x04cd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "<font color='#506d85'>Booking ID</font> <font color='#293946'>"
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = "</font>"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.widget.TextView r2 = r1.v
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r2.setText(r0)
        L_0x04cd:
            com.google.android.material.card.MaterialCardView r0 = r1.F
            net.one97.paytm.o2o.movies.c.-$$Lambda$c$fakGGbHewVq18yzTed1JaPWLi7g r2 = new net.one97.paytm.o2o.movies.c.-$$Lambda$c$fakGGbHewVq18yzTed1JaPWLi7g
            r2.<init>()
            r0.setOnClickListener(r2)
            com.google.android.material.card.MaterialCardView r0 = r1.F
            r2 = 0
            r0.setVisibility(r2)
            net.one97.paytm.o2o.movies.d.i r0 = r1.f74953f
            r3 = 1
            r0.a((boolean) r3)
            android.widget.TextView r0 = r1.s
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x04f0
            android.widget.LinearLayout r0 = r1.J
            r0.setVisibility(r2)
        L_0x04f0:
            android.widget.TextView r0 = r1.t
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x04fd
            android.widget.LinearLayout r0 = r1.K
            r0.setVisibility(r2)
        L_0x04fd:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.L
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r1.C
            r0.setVisibility(r2)
            return
        L_0x0508:
            r2 = 0
            android.widget.RelativeLayout r0 = r1.C
            r3 = 8
            r0.setVisibility(r3)
            com.google.android.material.card.MaterialCardView r0 = r1.F
            r0.setVisibility(r3)
            net.one97.paytm.o2o.movies.d.i r0 = r1.f74953f
            r0.a((boolean) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.c.c.a(android.content.Context, net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(CJRSummaryMovieDescItemV2 cJRSummaryMovieDescItemV2, View view) {
        this.f74953f.a(ad.CANCEL_MOVIE_TICKET_CLICK, (IJRDataModel) cJRSummaryMovieDescItemV2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRSummaryMovieDescItemV2 cJRSummaryMovieDescItemV2, View view) {
        this.f74953f.a(ad.CANCEL_MOVIE_TICKET_TNC_CLICK, (IJRDataModel) cJRSummaryMovieDescItemV2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(false);
    }

    public final void a(boolean z2) {
        this.w.setVisibility(8);
        this.f74953f.a((View) this.D, z2);
        this.w.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f74953f.a(ad.SUMMARY_PAYMENT_DETAIL_CLICK, (IJRDataModel) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2, View view) {
        this.f74953f.a(cJROrderSummaryMetadataResponseV2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2, String str, String str2, View view) {
        a(cJROrderSummaryMetadataResponseV2, str, str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2, String str, String str2, View view) {
        a(cJROrderSummaryMetadataResponseV2, str, str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2, String str, String str2, View view) {
        a(cJROrderSummaryMetadataResponseV2, str, str2);
    }

    private void a(CJRSummaryMoviePaymentItem cJRSummaryMoviePaymentItem) {
        if (cJRSummaryMoviePaymentItem.getAllFoodVoucher() != null && cJRSummaryMoviePaymentItem.getAllFoodVoucher().size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (CJRFoodVoucherItem idVoucherCodeMapping : cJRSummaryMoviePaymentItem.getAllFoodVoucher()) {
                for (a next : idVoucherCodeMapping.getIdVoucherCodeMapping().values()) {
                    if (!TextUtils.isEmpty(next.f75148b)) {
                        arrayList.add(next);
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.R.setAdapter(new ba(arrayList));
                if (this.R.getItemDecorationCount() == 0) {
                    this.R.addItemDecoration(new RecyclerView.h() {
                        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                            super.getItemOffsets(rect, view, recyclerView, sVar);
                            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                            int a2 = sVar.a();
                            int c2 = b.c(20);
                            rect.left = c2;
                            if (a2 > 0 && childAdapterPosition == a2 - 1) {
                                rect.right = c2;
                            }
                        }
                    });
                }
                this.B.setVisibility(0);
                return;
            }
        }
        this.B.setVisibility(8);
    }

    public final void a() {
        String str;
        if (n.a("com.ubercab", this.f74952e)) {
            if (!TextUtils.isEmpty(this.z)) {
                str = "uber://?client_id=" + this.z + "&action=setPickup&pickup=my_location&dropoff[latitude]=" + this.f74949a + "&dropoff[longitude]=" + this.f74950b + "dropoff[formatted_address]=" + this.f74951c;
            } else {
                str = "uber://?action=setPickup&pickup=my_location&dropoff[latitude]=" + this.f74949a + "&dropoff[longitude]=" + this.f74950b + "dropoff[formatted_address]=" + this.f74951c;
            }
            q.d("uri = ".concat(String.valueOf(str)));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.f74952e.startActivity(intent);
            return;
        }
        try {
            this.f74952e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.ubercab")));
        } catch (ActivityNotFoundException unused) {
            this.f74952e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.ubercab")));
        }
    }

    private void a(CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2, String str, String str2) {
        String str3;
        try {
            HashMap hashMap = new HashMap();
            if (cJROrderSummaryMetadataResponseV2 != null) {
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getCitySearched())) {
                    hashMap.put("movie_city_name", cJROrderSummaryMetadataResponseV2.getCitySearched());
                }
                String n2 = b.n(this.f74952e);
                if (!TextUtils.isEmpty(n2)) {
                    hashMap.put("movie_user_id", n2);
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getSource())) {
                    hashMap.put("movie_cinema_listing_type", cJROrderSummaryMetadataResponseV2.getSource());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getShowTime())) {
                    hashMap.put("movie_show_timing_bucket", cJROrderSummaryMetadataResponseV2.getShowTime());
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        if (this.f74949a.equals("0") || this.f74949a.equals("0.0")) {
            str3 = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=%1s,%2s", new Object[]{str, str2});
        } else {
            str3 = String.format("http://maps.google.com/maps?q=loc:%1s,%2s(%3s,%4s)", new Object[]{this.f74949a, this.f74950b, str, str2});
        }
        this.f74952e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str3)));
    }
}
