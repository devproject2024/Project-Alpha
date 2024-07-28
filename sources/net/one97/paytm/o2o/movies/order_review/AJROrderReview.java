package net.one97.paytm.o2o.movies.order_review;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRFnBDialog;
import net.one97.paytm.o2o.movies.activity.AppBaseActivity;
import net.one97.paytm.o2o.movies.adapter.p;
import net.one97.paytm.o2o.movies.b.b;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRConvenienceFee;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidgetInfo;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidgetValue;
import net.one97.paytm.o2o.movies.entity.BookingData;
import net.one97.paytm.o2o.movies.entity.CJRCPSelectionItem;
import net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond;
import net.one97.paytm.o2o.movies.entity.CJRCPUpgrade;
import net.one97.paytm.o2o.movies.entity.CJRMovieNewCancellationProtect;
import net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode;
import net.one97.paytm.o2o.movies.entity.CJRMovieOffers;
import net.one97.paytm.o2o.movies.entity.CJRMoviePromoStatus;
import net.one97.paytm.o2o.movies.entity.CJROffer;
import net.one97.paytm.o2o.movies.entity.CJROrderPricing;
import net.one97.paytm.o2o.movies.entity.CJRSetSeatData;
import net.one97.paytm.o2o.movies.entity.CJRUserWalletBalance;
import net.one97.paytm.o2o.movies.entity.SeatMapData;
import net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity;
import net.one97.paytm.o2o.movies.utils.p;
import net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS;
import net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CancellationProtectBS;
import net.one97.paytm.o2o.movies.widget.bottom_sheet_views.WebViewBS;

public final class AJROrderReview extends AppBaseActivity implements View.OnClickListener, p.c, net.one97.paytm.o2o.movies.d.d {
    private static final String V = V;
    private static final int W = 1;
    static final String t = t;
    public static final a u = new a((byte) 0);
    /* access modifiers changed from: private */
    public CJRConvenienceFee A;
    /* access modifiers changed from: private */
    public int B;
    private double C;
    private double D;
    private boolean E;
    private String F;
    private String G;
    private CJRMovieWidget H;
    /* access modifiers changed from: private */
    public String I;
    private boolean J;
    private String K;
    private float L;
    /* access modifiers changed from: private */
    public CJRMovieOffers M;
    private CPSlabAndTncBS N;
    private CancellationProtectBS O;
    private boolean P;
    /* access modifiers changed from: private */
    public boolean Q;
    /* access modifiers changed from: private */
    public net.one97.paytm.o2o.movies.b.b R;
    /* access modifiers changed from: private */
    public boolean S = true;
    /* access modifiers changed from: private */
    public WebViewBS T;
    private String U = "";
    private HashMap X;

    /* renamed from: a  reason: collision with root package name */
    boolean f75704a;

    /* renamed from: b  reason: collision with root package name */
    CJRMoviesSession f75705b;

    /* renamed from: c  reason: collision with root package name */
    CJRMovies f75706c;

    /* renamed from: d  reason: collision with root package name */
    String f75707d;

    /* renamed from: e  reason: collision with root package name */
    String f75708e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<CJRObjSeat> f75709f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public int f75710g;

    /* renamed from: h  reason: collision with root package name */
    boolean f75711h;
    /* access modifiers changed from: package-private */

    /* renamed from: i  reason: collision with root package name */
    public CJRMovieNewCancellationProtect f75712i;
    /* access modifiers changed from: package-private */
    public CJROrderPricing j = new CJROrderPricing(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
    /* access modifiers changed from: package-private */
    public List<? extends CJRMovieOfferCode> k;
    double l;
    double m;
    double n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    final kotlin.g s = kotlin.h.a(new w(this));
    private ProgressDialog v;
    private BookingData w;
    private String x;
    private String y;
    private String z;

    static final class al implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final al f75724a = new al();

        al() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    static final class ao implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final ao f75729a = new ao();

        ao() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    static final class b implements p.b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f75739a = new b();

        b() {
        }

        public final void onDialogDismissed() {
        }
    }

    static final class u implements p.b {

        /* renamed from: a  reason: collision with root package name */
        public static final u f75758a = new u();

        u() {
        }

        public final void onDialogDismissed() {
        }
    }

    static final class v implements p.b {

        /* renamed from: a  reason: collision with root package name */
        public static final v f75759a = new v();

        v() {
        }

        public final void onDialogDismissed() {
        }
    }

    public final View c(int i2) {
        if (this.X == null) {
            this.X = new HashMap();
        }
        View view = (View) this.X.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.X.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class g<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75744a;

        g(AJROrderReview aJROrderReview) {
            this.f75744a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            AJROrderReview aJROrderReview = this.f75744a;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            boolean booleanValue = bool.booleanValue();
            if (!booleanValue) {
                CheckBox checkBox = (CheckBox) aJROrderReview.c(R.id.check_box_fast_forward);
                kotlin.g.b.k.a((Object) checkBox, "check_box_fast_forward");
                checkBox.setChecked(false);
            }
            RelativeLayout relativeLayout = (RelativeLayout) aJROrderReview.c(R.id.lyt_fast_forward);
            kotlin.g.b.k.a((Object) relativeLayout, "lyt_fast_forward");
            net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout, booleanValue);
        }
    }

    static final class j<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75747a;

        j(AJROrderReview aJROrderReview) {
            this.f75747a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                AJROrderReview.i(this.f75747a);
            } else {
                this.f75747a.l();
            }
        }
    }

    static final class k<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75748a;

        k(AJROrderReview aJROrderReview) {
            this.f75748a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null && bool.booleanValue()) {
                AJROrderReview.k(this.f75748a);
            }
        }
    }

    static final class l<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75749a;

        l(AJROrderReview aJROrderReview) {
            this.f75749a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null && bool.booleanValue() && !this.f75749a.isFinishing()) {
                Toast.makeText(this.f75749a, "Try booking again", 1).show();
                this.f75749a.finish();
            }
        }
    }

    static final class m<T> implements androidx.lifecycle.z<CJRConvenienceFee> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75750a;

        m(AJROrderReview aJROrderReview) {
            this.f75750a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f75750a.A = (CJRConvenienceFee) obj;
            this.f75750a.j.setSeatPrice(this.f75750a.n());
            AJROrderReview.c(this.f75750a);
            AJROrderReview.d(this.f75750a);
        }
    }

    static final class n<T> implements androidx.lifecycle.z<CJRUserWalletBalance> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75751a;

        n(AJROrderReview aJROrderReview) {
            this.f75751a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRUserWalletBalance cJRUserWalletBalance = (CJRUserWalletBalance) obj;
            if (cJRUserWalletBalance != null) {
                double totalBalance = cJRUserWalletBalance.getTotalBalance();
                AJROrderReview aJROrderReview = this.f75751a;
                aJROrderReview.n = totalBalance;
                RelativeLayout relativeLayout = (RelativeLayout) aJROrderReview.c(R.id.lyt_fast_forward);
                kotlin.g.b.k.a((Object) relativeLayout, "lyt_fast_forward");
                if (relativeLayout.getVisibility() == 0) {
                    CheckBox checkBox = (CheckBox) aJROrderReview.c(R.id.check_box_fast_forward);
                    kotlin.g.b.k.a((Object) checkBox, "check_box_fast_forward");
                    checkBox.setChecked(aJROrderReview.n > aJROrderReview.j());
                }
            }
        }
    }

    static final class o<T> implements androidx.lifecycle.z<CJRUserMoviePassModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75752a;

        o(AJROrderReview aJROrderReview) {
            this.f75752a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AJROrderReview.a(this.f75752a, (CJRUserMoviePassModel) obj);
        }
    }

    static final class p<T> implements androidx.lifecycle.z<CJRMovieOffers> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75753a;

        p(AJROrderReview aJROrderReview) {
            this.f75753a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRMovieOffers cJRMovieOffers = (CJRMovieOffers) obj;
            if (cJRMovieOffers != null) {
                this.f75753a.M = cJRMovieOffers;
                AJROrderReview.e(this.f75753a);
                if (!net.one97.paytm.o2o.movies.common.d.a((List) cJRMovieOffers.getOfferCodes())) {
                    this.f75753a.k = cJRMovieOffers.getOfferCodes();
                    this.f75753a.s();
                    return;
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.f75753a.c(R.id.promo_code_not_applied_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout, "promo_code_not_applied_parent_rlt");
                relativeLayout.setVisibility(8);
                RelativeLayout relativeLayout2 = (RelativeLayout) this.f75753a.c(R.id.promo_code_applied_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout2, "promo_code_applied_parent_rlt");
                relativeLayout2.setVisibility(8);
                return;
            }
            RelativeLayout relativeLayout3 = (RelativeLayout) this.f75753a.c(R.id.promo_code_not_applied_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout3, "promo_code_not_applied_parent_rlt");
            relativeLayout3.setVisibility(8);
            RelativeLayout relativeLayout4 = (RelativeLayout) this.f75753a.c(R.id.promo_code_applied_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout4, "promo_code_applied_parent_rlt");
            relativeLayout4.setVisibility(8);
        }
    }

    static final class q<T> implements androidx.lifecycle.z<CJRAddSeat> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75754a;

        q(AJROrderReview aJROrderReview) {
            this.f75754a = aJROrderReview;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
            if (r4 == null) goto L_0x002f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat r4 = (net.one97.paytm.o2o.movies.common.movies.booking.CJRAddSeat) r4
                net.one97.paytm.o2o.movies.order_review.AJROrderReview r0 = r3.f75754a
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
                java.lang.String r1 = "addSeatData"
                kotlin.g.b.k.c(r4, r1)
                int r1 = r0.f75710g
                java.lang.String r4 = r4.getSeatInfo()
                if (r4 == 0) goto L_0x002f
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.a.d.b(r4)
                if (r4 == 0) goto L_0x002f
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                java.lang.String r4 = " : "
                r2.append(r4)
                java.lang.String r4 = r2.toString()
                if (r4 != 0) goto L_0x0031
            L_0x002f:
                java.lang.String r4 = ""
            L_0x0031:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r1)
                r4 = 32
                r2.append(r4)
                r4 = 1
                if (r1 <= r4) goto L_0x0047
                java.lang.String r4 = "seats"
                goto L_0x0049
            L_0x0047:
                java.lang.String r4 = "seat"
            L_0x0049:
                r2.append(r4)
                java.lang.String r4 = r2.toString()
                int r1 = net.one97.paytm.o2o.movies.R.id.selected_seat_number
                android.view.View r1 = r0.c((int) r1)
                com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
                java.lang.String r2 = "selected_seat_number"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r1.setText(r4)
                int r4 = net.one97.paytm.o2o.movies.R.id.tickets_3d_glass_subinfo_tv
                android.view.View r4 = r0.c((int) r4)
                com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
                java.lang.String r1 = "tickets_3d_glass_subinfo_tv"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
                r1 = 8
                r4.setVisibility(r1)
                int r4 = net.one97.paytm.o2o.movies.R.id.tickets_3d_glass_subinfo_price_tv
                android.view.View r4 = r0.c((int) r4)
                com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
                java.lang.String r2 = "tickets_3d_glass_subinfo_price_tv"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
                r4.setVisibility(r1)
                r0.c()
                r0.f()
                r0.h()
                r0.g()
                r0.l()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.order_review.AJROrderReview.q.onChanged(java.lang.Object):void");
        }
    }

    static final class r<T> implements androidx.lifecycle.z<CJRSetSeatData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75755a;

        r(AJROrderReview aJROrderReview) {
            this.f75755a = aJROrderReview;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x01a9 A[Catch:{ Exception -> 0x01cd }] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01dc A[Catch:{ Exception -> 0x037c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r17) {
            /*
                r16 = this;
                java.lang.String r0 = "setSeatData.setSeat"
                r1 = r17
                net.one97.paytm.o2o.movies.entity.CJRSetSeatData r1 = (net.one97.paytm.o2o.movies.entity.CJRSetSeatData) r1
                if (r1 == 0) goto L_0x0382
                r2 = r16
                net.one97.paytm.o2o.movies.order_review.AJROrderReview r3 = r2.f75755a
                java.lang.String r4 = "setSeatData"
                kotlin.g.b.k.c(r1, r4)
                net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r4 = r1.setSeat     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = r4.getSeatInfo()     // Catch:{ Exception -> 0x037c }
                java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat> r5 = r3.f75709f     // Catch:{ Exception -> 0x037c }
                if (r5 != 0) goto L_0x0023
                java.lang.String r6 = "mSelectedSeatList"
                kotlin.g.b.k.a((java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
            L_0x0023:
                int r5 = r5.size()     // Catch:{ Exception -> 0x037c }
                r6 = 0
                r7 = 1
                if (r5 <= 0) goto L_0x00de
                java.lang.String r5 = "seatNo"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x037c }
                r5 = r4
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x037c }
                int r8 = r5.length()     // Catch:{ Exception -> 0x037c }
                int r8 = r8 - r7
                r9 = r8
                r8 = 0
                r10 = 0
            L_0x003b:
                if (r8 > r9) goto L_0x005b
                if (r10 != 0) goto L_0x0041
                r11 = r8
                goto L_0x0042
            L_0x0041:
                r11 = r9
            L_0x0042:
                char r11 = r5.charAt(r11)     // Catch:{ Exception -> 0x037c }
                r12 = 32
                if (r11 > r12) goto L_0x004c
                r11 = 1
                goto L_0x004d
            L_0x004c:
                r11 = 0
            L_0x004d:
                if (r10 != 0) goto L_0x0056
                if (r11 != 0) goto L_0x0053
                r10 = 1
                goto L_0x003b
            L_0x0053:
                int r8 = r8 + 1
                goto L_0x003b
            L_0x0056:
                if (r11 == 0) goto L_0x005b
                int r9 = r9 + -1
                goto L_0x003b
            L_0x005b:
                int r9 = r9 + r7
                java.lang.CharSequence r5 = r5.subSequence(r8, r9)     // Catch:{ Exception -> 0x037c }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x037c }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x037c }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x037c }
                if (r5 != 0) goto L_0x00de
                kotlin.g r5 = r3.s     // Catch:{ Exception -> 0x037c }
                java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x037c }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x037c }
                r8 = r4
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x037c }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x037c }
                java.lang.String r9 = "selected_seat_number"
                if (r8 != 0) goto L_0x00ce
                java.lang.String r8 = net.one97.paytm.o2o.movies.utils.m.a((java.lang.String) r4)     // Catch:{ Exception -> 0x037c }
                r10 = r8
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x037c }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x037c }
                if (r10 != 0) goto L_0x008d
                r4 = r8
            L_0x008d:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x037c }
                r8.<init>()     // Catch:{ Exception -> 0x037c }
                r8.append(r5)     // Catch:{ Exception -> 0x037c }
                java.lang.String r5 = " : "
                r8.append(r5)     // Catch:{ Exception -> 0x037c }
                r8.append(r4)     // Catch:{ Exception -> 0x037c }
                java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x037c }
                android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x037c }
                r10 = r5
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x037c }
                r8.<init>(r10)     // Catch:{ Exception -> 0x037c }
                int r5 = r5.length()     // Catch:{ Exception -> 0x037c }
                android.text.style.StyleSpan r10 = new android.text.style.StyleSpan     // Catch:{ Exception -> 0x037c }
                r10.<init>(r7)     // Catch:{ Exception -> 0x037c }
                int r4 = r4.length()     // Catch:{ Exception -> 0x037c }
                int r4 = r5 - r4
                r11 = 33
                r8.setSpan(r10, r4, r5, r11)     // Catch:{ Exception -> 0x037c }
                int r4 = net.one97.paytm.o2o.movies.R.id.selected_seat_number     // Catch:{ Exception -> 0x037c }
                android.view.View r4 = r3.c((int) r4)     // Catch:{ Exception -> 0x037c }
                com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)     // Catch:{ Exception -> 0x037c }
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x037c }
                r4.setText(r8)     // Catch:{ Exception -> 0x037c }
                goto L_0x00de
            L_0x00ce:
                int r4 = net.one97.paytm.o2o.movies.R.id.selected_seat_number     // Catch:{ Exception -> 0x037c }
                android.view.View r4 = r3.c((int) r4)     // Catch:{ Exception -> 0x037c }
                com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)     // Catch:{ Exception -> 0x037c }
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x037c }
                r4.setText(r5)     // Catch:{ Exception -> 0x037c }
            L_0x00de:
                net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r4 = r1.setSeat     // Catch:{ Exception -> 0x037c }
                r3.a((net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat) r4)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r4 = r1.setSeat     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems r4 = r4.getItems()     // Catch:{ Exception -> 0x037c }
                java.lang.String r5 = "CJRMoviesGTMConstants.GTM_KEY_USER_ID"
                java.lang.String r8 = "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME"
                java.lang.String r9 = "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME"
                java.lang.String r10 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL"
                java.lang.String r11 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION"
                java.lang.String r12 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY"
                java.lang.String r13 = "CJRAppCommonUtility.getUserId(this)"
                if (r4 == 0) goto L_0x01e0
                net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat r4 = r1.setSeat     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems r0 = r4.getItems()     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x01e0
                java.util.ArrayList r0 = r0.getFnbAndVouchers()     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x01e0
                int r4 = r0.size()     // Catch:{ Exception -> 0x037c }
                if (r4 <= 0) goto L_0x01e0
                r3.p = r7     // Catch:{ Exception -> 0x037c }
                java.util.ArrayList<java.lang.String> r4 = r1.missingItem     // Catch:{ Exception -> 0x037c }
                r3.a((java.util.ArrayList<java.lang.String>) r4)     // Catch:{ Exception -> 0x037c }
                int r4 = net.one97.paytm.o2o.movies.R.id.main_rel_container     // Catch:{ Exception -> 0x037c }
                android.view.View r4 = r3.c((int) r4)     // Catch:{ Exception -> 0x037c }
                android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4     // Catch:{ Exception -> 0x037c }
                android.content.res.Resources r14 = r3.getResources()     // Catch:{ Exception -> 0x037c }
                int r15 = net.one97.paytm.o2o.movies.R.color.light_grey     // Catch:{ Exception -> 0x037c }
                int r14 = r14.getColor(r15)     // Catch:{ Exception -> 0x037c }
                r4.setBackgroundColor(r14)     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x013c
                net.one97.paytm.o2o.movies.utils.g r4 = net.one97.paytm.o2o.movies.utils.g.a()     // Catch:{ Exception -> 0x037c }
                java.lang.String r14 = "CJRFoodBeverageModel.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r14)     // Catch:{ Exception -> 0x037c }
                r4.f75924a = r0     // Catch:{ Exception -> 0x037c }
            L_0x013c:
                if (r0 == 0) goto L_0x0148
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x0145
                goto L_0x0148
            L_0x0145:
                java.lang.String r0 = "Food=Yes"
                goto L_0x014a
            L_0x0148:
                java.lang.String r0 = "Food=No"
            L_0x014a:
                boolean r4 = r3.p     // Catch:{ Exception -> 0x037c }
                if (r4 == 0) goto L_0x01d5
                boolean r4 = r3.q     // Catch:{ Exception -> 0x037c }
                if (r4 != 0) goto L_0x01d5
                r3.a((boolean) r6, (boolean) r7)     // Catch:{ Exception -> 0x037c }
                r3.q = r7     // Catch:{ Exception -> 0x037c }
                java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x01cd }
                r4.<init>()     // Catch:{ Exception -> 0x01cd }
                r14 = r4
                java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x01cd }
                java.lang.String r15 = "screenName"
                java.lang.String r7 = "/movies/review"
                r14.put(r15, r7)     // Catch:{ Exception -> 0x01cd }
                r7 = r4
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x01cd }
                java.lang.String r14 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x01cd }
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r12)     // Catch:{ Exception -> 0x01cd }
                java.lang.String r15 = net.one97.paytm.o2o.movies.common.b.b.B     // Catch:{ Exception -> 0x01cd }
                java.lang.String r6 = "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT"
                kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)     // Catch:{ Exception -> 0x01cd }
                r7.put(r14, r15)     // Catch:{ Exception -> 0x01cd }
                r6 = r4
                java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x01cd }
                java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x01cd }
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)     // Catch:{ Exception -> 0x01cd }
                java.lang.String r14 = "food_status"
                r6.put(r7, r14)     // Catch:{ Exception -> 0x01cd }
                r6 = r4
                java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x01cd }
                java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x01cd }
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ Exception -> 0x01cd }
                r6.put(r7, r0)     // Catch:{ Exception -> 0x01cd }
                r0 = r4
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x01cd }
                java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x01cd }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)     // Catch:{ Exception -> 0x01cd }
                java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x01cd }
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x01cd }
                r0.put(r6, r7)     // Catch:{ Exception -> 0x01cd }
                r0 = r3
                android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x01cd }
                boolean r0 = com.paytm.utility.b.r((android.content.Context) r0)     // Catch:{ Exception -> 0x01cd }
                if (r0 == 0) goto L_0x01be
                r0 = r4
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x01cd }
                java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x01cd }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x01cd }
                r7 = r3
                android.content.Context r7 = (android.content.Context) r7     // Catch:{ Exception -> 0x01cd }
                java.lang.String r7 = com.paytm.utility.b.n((android.content.Context) r7)     // Catch:{ Exception -> 0x01cd }
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r13)     // Catch:{ Exception -> 0x01cd }
                r0.put(r6, r7)     // Catch:{ Exception -> 0x01cd }
            L_0x01be:
                net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01cd }
                net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x01cd }
                java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x01cd }
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x01cd }
                r7 = r3
                android.content.Context r7 = (android.content.Context) r7     // Catch:{ Exception -> 0x01cd }
                r0.sendCustomEventWithMap(r6, r4, r7)     // Catch:{ Exception -> 0x01cd }
                goto L_0x01d5
            L_0x01cd:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x037c }
                com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x037c }
            L_0x01d5:
                r3.f()     // Catch:{ Exception -> 0x037c }
                java.util.ArrayList<java.lang.String> r0 = r1.missingItem     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x01e0
                r4 = 0
                r3.a((boolean) r4)     // Catch:{ Exception -> 0x037c }
            L_0x01e0:
                boolean r0 = r3.p     // Catch:{ Exception -> 0x037c }
                if (r0 != 0) goto L_0x01e7
                r3.g()     // Catch:{ Exception -> 0x037c }
            L_0x01e7:
                r3.h()     // Catch:{ Exception -> 0x037c }
                boolean r0 = r1.isLoading     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x0381
                java.util.List<? extends net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode> r0 = r3.k     // Catch:{ Exception -> 0x037c }
                boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ Exception -> 0x037c }
                if (r0 != 0) goto L_0x036b
                java.util.List<? extends net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode> r0 = r3.k     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x036b
                r1 = 0
                java.lang.Object r0 = kotlin.a.k.a(r0, (int) r1)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode r0 = (net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode) r0     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x036b
                java.lang.String r1 = net.one97.paytm.o2o.movies.order_review.AJROrderReview.t     // Catch:{ Exception -> 0x037c }
                java.util.List<? extends net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode> r4 = r3.k     // Catch:{ Exception -> 0x037c }
                if (r4 != 0) goto L_0x020c
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x037c }
            L_0x020c:
                r6 = 0
                java.lang.Object r4 = r4.get(r6)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode r4 = (net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode) r4     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = r4.getCode()     // Catch:{ Exception -> 0x037c }
                r6 = 1
                boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r6)     // Catch:{ Exception -> 0x037c }
                if (r1 == 0) goto L_0x036b
                r3.a((net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode) r0, (boolean) r6)     // Catch:{ Exception -> 0x037c }
                java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x037c }
                r1.<init>()     // Catch:{ Exception -> 0x037c }
                r4 = r1
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = "movie_tickets_order_review"
                r4.put(r6, r7)     // Catch:{ Exception -> 0x037c }
                r4 = r1
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r11)     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = "order_review_screen_loaded_with_promo_auto_apply"
                r4.put(r6, r7)     // Catch:{ Exception -> 0x037c }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x037c }
                r4.<init>()     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r6 = r3.f75706c     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = "mSelectedMovie"
                if (r6 != 0) goto L_0x024e
                kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
            L_0x024e:
                java.lang.String r6 = r6.getTitle()     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.order_review.AJROrderReview.a((java.lang.StringBuilder) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r6 = r3.f75706c     // Catch:{ Exception -> 0x037c }
                if (r6 != 0) goto L_0x025c
                kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
            L_0x025c:
                java.lang.String r6 = r6.getCode()     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.order_review.AJROrderReview.a((java.lang.StringBuilder) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r6 = r3.f75705b     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = "mSelectedMoviesSession"
                if (r6 != 0) goto L_0x026c
                kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
            L_0x026c:
                java.lang.String r6 = r6.getRealShowDateTime()     // Catch:{ Exception -> 0x037c }
                java.lang.String r11 = "EEE, h:mm a"
                java.lang.String r6 = net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r6, (java.lang.String) r11)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.order_review.AJROrderReview.a((java.lang.StringBuilder) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r6 = r3.f75705b     // Catch:{ Exception -> 0x037c }
                if (r6 != 0) goto L_0x0280
                kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
            L_0x0280:
                java.lang.String r6 = r6.getCinemaName()     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.order_review.AJROrderReview.a((java.lang.StringBuilder) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r6 = r3.f75705b     // Catch:{ Exception -> 0x037c }
                if (r6 != 0) goto L_0x028e
                kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
            L_0x028e:
                java.lang.String r6 = r6.getCinemaID()     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = "mSelectedMoviesSession.cinemaID"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = "|"
                r11 = r6
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x037c }
                boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x037c }
                if (r11 != 0) goto L_0x02ae
                int r11 = r4.length()     // Catch:{ Exception -> 0x037c }
                if (r11 <= 0) goto L_0x02ab
                r4.append(r7)     // Catch:{ Exception -> 0x037c }
            L_0x02ab:
                r4.append(r6)     // Catch:{ Exception -> 0x037c }
            L_0x02ae:
                java.lang.String r6 = r3.f75708e     // Catch:{ Exception -> 0x037c }
                if (r6 != 0) goto L_0x02b7
                java.lang.String r7 = "mCitySearched"
                kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
            L_0x02b7:
                net.one97.paytm.o2o.movies.order_review.AJROrderReview.a((java.lang.StringBuilder) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
                r6 = r1
                java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x037c }
                java.lang.String r10 = "eventLabelBuilder.toString()"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)     // Catch:{ Exception -> 0x037c }
                r6.put(r7, r4)     // Catch:{ Exception -> 0x037c }
                r4 = r1
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75010e     // Catch:{ Exception -> 0x037c }
                java.lang.String r7 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_2"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x037c }
                r7.<init>()     // Catch:{ Exception -> 0x037c }
                java.lang.String r10 = r0.getCode()     // Catch:{ Exception -> 0x037c }
                r7.append(r10)     // Catch:{ Exception -> 0x037c }
                java.lang.String r10 = ": "
                r7.append(r10)     // Catch:{ Exception -> 0x037c }
                java.lang.String r0 = r0.getOfferText()     // Catch:{ Exception -> 0x037c }
                r7.append(r0)     // Catch:{ Exception -> 0x037c }
                java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x037c }
                r4.put(r6, r0)     // Catch:{ Exception -> 0x037c }
                r0 = r1
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75011f     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_3"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
                r6 = r3
                android.content.Context r6 = (android.content.Context) r6     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = com.paytm.utility.b.n((android.content.Context) r6)     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r13)     // Catch:{ Exception -> 0x037c }
                r0.put(r4, r6)     // Catch:{ Exception -> 0x037c }
                r0 = r1
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75012g     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_4"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = r3.f75707d     // Catch:{ Exception -> 0x037c }
                if (r6 != 0) goto L_0x0321
                java.lang.String r7 = "mSelectSeatTempTransactionId"
                kotlin.g.b.k.a((java.lang.String) r7)     // Catch:{ Exception -> 0x037c }
            L_0x0321:
                if (r6 == 0) goto L_0x0363
                r0.put(r4, r6)     // Catch:{ Exception -> 0x037c }
                r0 = r1
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)     // Catch:{ Exception -> 0x037c }
                java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)     // Catch:{ Exception -> 0x037c }
                r0.put(r4, r6)     // Catch:{ Exception -> 0x037c }
                r0 = r3
                android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x037c }
                boolean r0 = com.paytm.utility.b.r((android.content.Context) r0)     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x0354
                r0 = r1
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x037c }
                r5 = r3
                android.content.Context r5 = (android.content.Context) r5     // Catch:{ Exception -> 0x037c }
                java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r5)     // Catch:{ Exception -> 0x037c }
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)     // Catch:{ Exception -> 0x037c }
                r0.put(r4, r5)     // Catch:{ Exception -> 0x037c }
            L_0x0354:
                net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x037c }
                net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x037c }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x037c }
                java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x037c }
                r5 = r3
                android.content.Context r5 = (android.content.Context) r5     // Catch:{ Exception -> 0x037c }
                r0.sendCustomEventWithMap(r4, r1, r5)     // Catch:{ Exception -> 0x037c }
                goto L_0x036b
            L_0x0363:
                kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x037c }
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
                r0.<init>(r1)     // Catch:{ Exception -> 0x037c }
                throw r0     // Catch:{ Exception -> 0x037c }
            L_0x036b:
                int r0 = net.one97.paytm.o2o.movies.R.id.loading     // Catch:{ Exception -> 0x037c }
                android.view.View r0 = r3.c((int) r0)     // Catch:{ Exception -> 0x037c }
                android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0     // Catch:{ Exception -> 0x037c }
                if (r0 == 0) goto L_0x037b
                android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x037c }
                r1 = 0
                net.one97.paytm.o2o.movies.common.a.e.a(r0, r1)     // Catch:{ Exception -> 0x037c }
            L_0x037b:
                return
            L_0x037c:
                java.lang.String r0 = "setSeatResponseError"
                com.paytm.utility.q.d(r0)
            L_0x0381:
                return
            L_0x0382:
                r2 = r16
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.order_review.AJROrderReview.r.onChanged(java.lang.Object):void");
        }
    }

    static final class s<T> implements androidx.lifecycle.z<CJRMovieNewCancellationProtect> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75756a;

        s(AJROrderReview aJROrderReview) {
            this.f75756a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List<CJRCPSelectionItem> options;
            String str;
            Boolean promocodeAllowed;
            CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = (CJRMovieNewCancellationProtect) obj;
            if (cJRMovieNewCancellationProtect != null) {
                AJROrderReview aJROrderReview = this.f75756a;
                kotlin.g.b.k.c(cJRMovieNewCancellationProtect, "movieInsuranceModel");
                try {
                    aJROrderReview.f75712i = cJRMovieNewCancellationProtect;
                    CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect2 = aJROrderReview.f75712i;
                    if (!(cJRMovieNewCancellationProtect2 == null || (promocodeAllowed = cJRMovieNewCancellationProtect2.getPromocodeAllowed()) == null)) {
                        aJROrderReview.f75711h = promocodeAllowed.booleanValue();
                    }
                    if (cJRMovieNewCancellationProtect.getInsuranceAvailable()) {
                        aJROrderReview.o = true;
                        RelativeLayout relativeLayout = (RelativeLayout) aJROrderReview.c(R.id.cancellation_protect_rlt);
                        kotlin.g.b.k.a((Object) relativeLayout, "cancellation_protect_rlt");
                        relativeLayout.setVisibility(0);
                        CJRCPUpgrade cpUpgrade = cJRMovieNewCancellationProtect.getCpUpgrade();
                        if (cpUpgrade != null && !aJROrderReview.r) {
                            String str2 = cpUpgrade.getDefault();
                            if (!(str2 == null || (options = cpUpgrade.getOptions()) == null)) {
                                for (CJRCPSelectionItem next : options) {
                                    if (str2 != null) {
                                        String obj2 = kotlin.m.p.b(str2).toString();
                                        String type = next.getType();
                                        String str3 = null;
                                        if (type == null) {
                                            str = null;
                                        } else if (type != null) {
                                            str = kotlin.m.p.b(type).toString();
                                        } else {
                                            throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                                        }
                                        if (kotlin.m.p.a(obj2, str, true)) {
                                            RoboTextView roboTextView = (RoboTextView) aJROrderReview.c(R.id.cp_title_rtv);
                                            kotlin.g.b.k.a((Object) roboTextView, "cp_title_rtv");
                                            roboTextView.setText(next.getTitle());
                                            RoboTextView roboTextView2 = (RoboTextView) aJROrderReview.c(R.id.cp_info_rtv);
                                            kotlin.g.b.k.a((Object) roboTextView2, "cp_info_rtv");
                                            roboTextView2.setText(next.getSmallDesc());
                                            String type2 = next.getType();
                                            if (type2 != null) {
                                                if (type2 != null) {
                                                    str3 = kotlin.m.p.b(type2).toString();
                                                } else {
                                                    throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                                                }
                                            }
                                            if (kotlin.m.p.a(str3, "paytm_cp", true)) {
                                                RoboTextView roboTextView3 = (RoboTextView) aJROrderReview.c(R.id.cp_upgrade_change_rtv);
                                                kotlin.g.b.k.a((Object) roboTextView3, "cp_upgrade_change_rtv");
                                                roboTextView3.setText(aJROrderReview.getString(R.string.cp_change));
                                                ((RoboTextView) aJROrderReview.c(R.id.cp_upgrade_change_rtv)).setTextColor(Color.parseColor("#ffad00"));
                                                String price = next.getPrice();
                                                if (price != null) {
                                                    RoboTextView roboTextView4 = (RoboTextView) aJROrderReview.c(R.id.cp_price_rtv);
                                                    kotlin.g.b.k.a((Object) roboTextView4, "cp_price_rtv");
                                                    roboTextView4.setText(aJROrderReview.getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.x(price));
                                                }
                                                aJROrderReview.b(true);
                                                aJROrderReview.a("Paytm Cancellation Protection");
                                            } else {
                                                RoboTextView roboTextView5 = (RoboTextView) aJROrderReview.c(R.id.cp_upgrade_change_rtv);
                                                kotlin.g.b.k.a((Object) roboTextView5, "cp_upgrade_change_rtv");
                                                roboTextView5.setText(aJROrderReview.getString(R.string.cp_upgrade));
                                                ((RoboTextView) aJROrderReview.c(R.id.cp_upgrade_change_rtv)).setTextColor(Color.parseColor("#00baf2"));
                                                String price2 = next.getPrice();
                                                if (price2 != null && kotlin.m.p.a(price2, "0", true)) {
                                                    RoboTextView roboTextView6 = (RoboTextView) aJROrderReview.c(R.id.cp_price_rtv);
                                                    kotlin.g.b.k.a((Object) roboTextView6, "cp_price_rtv");
                                                    roboTextView6.setText(aJROrderReview.getString(R.string.free));
                                                }
                                                aJROrderReview.b(false);
                                                aJROrderReview.a("No Protection");
                                            }
                                        }
                                    } else {
                                        throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                }
                            }
                            aJROrderReview.r = true;
                        }
                        ((RoboTextView) aJROrderReview.c(R.id.cp_upgrade_change_rtv)).setOnClickListener(new x(aJROrderReview));
                        ((RoboTextView) aJROrderReview.c(R.id.cp_tnc_rtv)).setOnClickListener(new y(aJROrderReview));
                        aJROrderReview.e();
                        return;
                    }
                    aJROrderReview.o = false;
                    RelativeLayout relativeLayout2 = (RelativeLayout) aJROrderReview.c(R.id.cancellation_protect_rlt);
                    kotlin.g.b.k.a((Object) relativeLayout2, "cancellation_protect_rlt");
                    relativeLayout2.setVisibility(8);
                    Boolean isCancellable = cJRMovieNewCancellationProtect.getIsCancellable();
                    kotlin.g.b.k.a((Object) isCancellable, "movieInsuranceModel.isCancellable");
                    if (isCancellable.booleanValue()) {
                        RelativeLayout relativeLayout3 = (RelativeLayout) aJROrderReview.c(R.id.pvr_only_cp_container_rlt);
                        kotlin.g.b.k.a((Object) relativeLayout3, "pvr_only_cp_container_rlt");
                        relativeLayout3.setVisibility(0);
                        ((RoboTextView) aJROrderReview.c(R.id.cp_pvr_only_tnc_rtv)).setOnClickListener(new aa(aJROrderReview));
                    }
                } catch (Exception e2) {
                    com.paytm.utility.q.b(e2.getMessage());
                }
            }
        }
    }

    static final class t<T> implements androidx.lifecycle.z<CJRMoviePromoStatus> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75757a;

        t(AJROrderReview aJROrderReview) {
            this.f75757a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRMoviePromoStatus cJRMoviePromoStatus = (CJRMoviePromoStatus) obj;
            if (cJRMoviePromoStatus == null) {
                return;
            }
            if (cJRMoviePromoStatus.isSuccess) {
                AJROrderReview aJROrderReview = this.f75757a;
                String str = cJRMoviePromoStatus.promoCode;
                String str2 = cJRMoviePromoStatus.cashBack;
                String str3 = cJRMoviePromoStatus.promoText;
                String str4 = cJRMoviePromoStatus.paytmDiscount;
                RelativeLayout relativeLayout = (RelativeLayout) aJROrderReview.c(R.id.movie_pass_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout, "movie_pass_parent_rlt");
                relativeLayout.setVisibility(8);
                RelativeLayout relativeLayout2 = (RelativeLayout) aJROrderReview.c(R.id.promo_code_not_applied_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout2, "promo_code_not_applied_parent_rlt");
                relativeLayout2.setVisibility(4);
                RelativeLayout relativeLayout3 = (RelativeLayout) aJROrderReview.c(R.id.promo_default_show_all_rlt);
                kotlin.g.b.k.a((Object) relativeLayout3, "promo_default_show_all_rlt");
                relativeLayout3.setVisibility(8);
                RelativeLayout relativeLayout4 = (RelativeLayout) aJROrderReview.c(R.id.promo_code_applied_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout4, "promo_code_applied_parent_rlt");
                relativeLayout4.setVisibility(0);
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence)) {
                    RoboTextView roboTextView = (RoboTextView) aJROrderReview.c(R.id.promo_coupon_code_rtv);
                    kotlin.g.b.k.a((Object) roboTextView, "promo_coupon_code_rtv");
                    roboTextView.setText(charSequence);
                } else {
                    RoboTextView roboTextView2 = (RoboTextView) aJROrderReview.c(R.id.promo_coupon_code_rtv);
                    kotlin.g.b.k.a((Object) roboTextView2, "promo_coupon_code_rtv");
                    roboTextView2.setText(aJROrderReview.getString(R.string.promo_default_name));
                }
                CharSequence charSequence2 = str3;
                if (!TextUtils.isEmpty(charSequence2)) {
                    RoboTextView roboTextView3 = (RoboTextView) aJROrderReview.c(R.id.promo_applied_detail_desc_rtv);
                    kotlin.g.b.k.a((Object) roboTextView3, "promo_applied_detail_desc_rtv");
                    roboTextView3.setText(charSequence2);
                } else {
                    RoboTextView roboTextView4 = (RoboTextView) aJROrderReview.c(R.id.promo_applied_detail_desc_rtv);
                    kotlin.g.b.k.a((Object) roboTextView4, "promo_applied_detail_desc_rtv");
                    roboTextView4.setText("");
                }
                if (TextUtils.isEmpty(str2)) {
                    aJROrderReview.l = 0.0d;
                } else if (str2 != null) {
                    aJROrderReview.l = Double.parseDouble(str2);
                }
                if (!TextUtils.isEmpty(str4)) {
                    if (str4 != null) {
                        aJROrderReview.m = Double.parseDouble(str4);
                        aJROrderReview.j.setPromoDiscount(aJROrderReview.m);
                    }
                    if (!aJROrderReview.f75704a) {
                        if (aJROrderReview.m > 0.0d) {
                            RelativeLayout relativeLayout5 = (RelativeLayout) aJROrderReview.c(R.id.discount_promo_rlt);
                            kotlin.g.b.k.a((Object) relativeLayout5, "discount_promo_rlt");
                            relativeLayout5.setVisibility(0);
                            RoboTextView roboTextView5 = (RoboTextView) aJROrderReview.c(R.id.discount_promo_deducted_price_rtv);
                            kotlin.g.b.k.a((Object) roboTextView5, "discount_promo_deducted_price_rtv");
                            roboTextView5.setText("- " + aJROrderReview.getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(aJROrderReview.m));
                            aJROrderReview.d();
                            aJROrderReview.f75704a = true;
                        } else {
                            RelativeLayout relativeLayout6 = (RelativeLayout) aJROrderReview.c(R.id.discount_promo_rlt);
                            kotlin.g.b.k.a((Object) relativeLayout6, "discount_promo_rlt");
                            relativeLayout6.setVisibility(8);
                        }
                    }
                } else {
                    RelativeLayout relativeLayout7 = (RelativeLayout) aJROrderReview.c(R.id.discount_promo_rlt);
                    kotlin.g.b.k.a((Object) relativeLayout7, "discount_promo_rlt");
                    relativeLayout7.setVisibility(8);
                }
                aJROrderReview.i();
                RoboTextView roboTextView6 = (RoboTextView) aJROrderReview.c(R.id.title);
                kotlin.g.b.k.a((Object) roboTextView6, AppConstants.TOOLBAR_TITTE);
                if (kotlin.m.p.a(roboTextView6.getText().toString(), aJROrderReview.getResources().getString(R.string.apply_promo_code), true)) {
                    aJROrderReview.onBackPressed();
                }
            } else if (this.f75757a.I != null) {
                AJROrderReview aJROrderReview2 = this.f75757a;
                String str5 = cJRMoviePromoStatus.promoText;
                kotlin.g.b.k.a((Object) str5, "cjrMoviePromoStatus.promoText");
                kotlin.g.b.k.c(str5, "promoText");
                RoboTextView roboTextView7 = (RoboTextView) aJROrderReview2.c(R.id.id_movie_pass_error);
                kotlin.g.b.k.a((Object) roboTextView7, "id_movie_pass_error");
                roboTextView7.setText(str5);
                RoboTextView roboTextView8 = (RoboTextView) aJROrderReview2.c(R.id.id_movie_pass_error);
                kotlin.g.b.k.a((Object) roboTextView8, "id_movie_pass_error");
                roboTextView8.setVisibility(0);
            } else {
                AJROrderReview aJROrderReview3 = this.f75757a;
                String str6 = cJRMoviePromoStatus.promoText;
                kotlin.g.b.k.a((Object) str6, "cjrMoviePromoStatus.promoText");
                kotlin.g.b.k.c(str6, "promoText");
                if (!TextUtils.isEmpty(str6)) {
                    net.one97.paytm.o2o.movies.utils.p.a(aJROrderReview3, aJROrderReview3.getResources().getString(R.string.failure), str6);
                }
            }
        }
    }

    static final class w extends kotlin.g.b.l implements kotlin.g.a.a<String> {
        final /* synthetic */ AJROrderReview this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(AJROrderReview aJROrderReview) {
            super(0);
            this.this$0 = aJROrderReview;
        }

        public final String invoke() {
            int i2;
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.f75710g);
            sb.append(" ");
            Resources resources = this.this$0.getResources();
            if (this.this$0.f75710g != 1) {
                i2 = R.string.movie_multiple_seat;
            } else {
                i2 = R.string.movie_single_seat;
            }
            sb.append(resources.getString(i2));
            return sb.toString();
        }
    }

    private final boolean m() {
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.promo_code_applied_parent_rlt);
        kotlin.g.b.k.a((Object) relativeLayout, "promo_code_applied_parent_rlt");
        return relativeLayout.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public final double n() {
        CJRMoviesSession cJRMoviesSession = this.f75705b;
        if (cJRMoviesSession == null) {
            kotlin.g.b.k.a("mSelectedMoviesSession");
        }
        double d2 = 0.0d;
        if (cJRMoviesSession.isTokenFeeOnly()) {
            return 0.0d;
        }
        ArrayList<CJRObjSeat> arrayList = this.f75709f;
        if (arrayList == null) {
            kotlin.g.b.k.a("mSelectedSeatList");
        }
        CJRObjSeat cJRObjSeat = (CJRObjSeat) kotlin.a.k.e(arrayList);
        if (cJRObjSeat != null) {
            d2 = cJRObjSeat.getPrice();
        }
        return d2 * ((double) this.f75710g);
    }

    public final void onCreate(Bundle bundle) {
        androidx.lifecycle.y<Boolean> yVar;
        androidx.lifecycle.y<Boolean> yVar2;
        androidx.lifecycle.y<Boolean> yVar3;
        androidx.lifecycle.y<Boolean> yVar4;
        androidx.lifecycle.y<Boolean> yVar5;
        androidx.lifecycle.y<Boolean> yVar6;
        androidx.lifecycle.y<CJRMoviePromoStatus> yVar7;
        androidx.lifecycle.y<CJRMovieNewCancellationProtect> yVar8;
        androidx.lifecycle.y<CJRSetSeatData> yVar9;
        androidx.lifecycle.y<CJRAddSeat> yVar10;
        androidx.lifecycle.y<CJRMovieOffers> yVar11;
        androidx.lifecycle.y<CJRUserMoviePassModel> yVar12;
        androidx.lifecycle.y<CJRUserWalletBalance> yVar13;
        androidx.lifecycle.y<CJRConvenienceFee> yVar14;
        androidx.lifecycle.y<Intent> yVar15;
        String b2;
        String a2;
        Bundle bundleExtra;
        super.onCreate(bundle);
        setContentView(R.layout.activity_movies_order_review);
        this.R = (net.one97.paytm.o2o.movies.b.b) androidx.lifecycle.am.a((FragmentActivity) this).a(net.one97.paytm.o2o.movies.b.b.class);
        net.one97.paytm.o2o.movies.b.b bVar = this.R;
        if (bVar != null) {
            Activity activity = this;
            kotlin.g.b.k.c(activity, "mActivity");
            bVar.f74888c = activity;
        }
        View.OnClickListener onClickListener = this;
        ((ImageView) c(R.id.activiy_back_btn)).setOnClickListener(onClickListener);
        ((RelativeLayout) c(R.id.promo_default_show_all_rlt)).setOnClickListener(onClickListener);
        ((RoboTextView) c(R.id.id_movie_pass_apply_btn)).setOnClickListener(onClickListener);
        ((RoboTextView) c(R.id.book_tickets_btn_rtv)).setOnClickListener(onClickListener);
        RoboTextView roboTextView = (RoboTextView) c(R.id.fnb_summary_add_change_rtv);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(new z(this));
        }
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.ticket_summary_subinfo_container);
        kotlin.g.b.k.a((Object) relativeLayout, "ticket_summary_subinfo_container");
        net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout, false);
        LinearLayout linearLayout = (LinearLayout) c(R.id.fees_tax_item_llt);
        kotlin.g.b.k.a((Object) linearLayout, "fees_tax_item_llt");
        net.one97.paytm.o2o.movies.common.a.e.a(linearLayout, false);
        LinearLayout linearLayout2 = (LinearLayout) c(R.id.cp_tax_info_llt);
        kotlin.g.b.k.a((Object) linearLayout2, "cp_tax_info_llt");
        net.one97.paytm.o2o.movies.common.a.e.a(linearLayout2, false);
        LinearLayout linearLayout3 = (LinearLayout) c(R.id.fnb_items_llt);
        kotlin.g.b.k.a((Object) linearLayout3, "fnb_items_llt");
        net.one97.paytm.o2o.movies.common.a.e.a(linearLayout3, false);
        ((RelativeLayout) c(R.id.movie_order_summary_rlt)).requestLayout();
        LinearLayout linearLayout4 = (LinearLayout) c(R.id.summary_items_llt);
        kotlin.g.b.k.a((Object) linearLayout4, "(summary_items_llt)");
        linearLayout4.getLayoutTransition().enableTransitionType(4);
        ((RelativeLayout) c(R.id.order_summary_header_rlt)).setOnClickListener(new ah(this));
        Intent intent = getIntent();
        if (!(intent == null || (bundleExtra = intent.getBundleExtra("bundle")) == null)) {
            String string = bundleExtra.getString("temptransid");
            if (string == null) {
                string = "";
            }
            this.f75707d = string;
            CJRMoviesSession cJRMoviesSession = (CJRMoviesSession) bundleExtra.getParcelable("moviesession");
            if (cJRMoviesSession == null) {
                cJRMoviesSession = new CJRMoviesSession();
            }
            this.f75705b = cJRMoviesSession;
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            this.B = cJRMoviesSession2.getmIsFoodMandatoryVoucer();
            CJRMovies cJRMovies = (CJRMovies) bundleExtra.getParcelable("selectedmovie");
            if (cJRMovies == null) {
                cJRMovies = new CJRMovies();
            }
            this.f75706c = cJRMovies;
            String string2 = bundleExtra.getString("seatselectionsource");
            if (string2 == null) {
                string2 = "";
            }
            this.x = string2;
            String string3 = bundleExtra.getString("citysearched");
            if (string3 == null) {
                string3 = "";
            }
            this.f75708e = string3;
            ArrayList<CJRObjSeat> parcelableArrayList = bundleExtra.getParcelableArrayList("selectedseats");
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList<>();
            }
            this.f75709f = parcelableArrayList;
            this.f75710g = bundleExtra.getInt("curentselectedseat", 0);
            String string4 = bundleExtra.getString("productid");
            if (string4 == null) {
                string4 = "";
            }
            this.y = string4;
            this.H = (CJRMovieWidget) bundleExtra.getParcelable("intent_extra_movie_offer_data");
            this.F = bundleExtra.getString("intent_movie_title_localized");
            this.G = bundleExtra.getString("intent_movie_language_localized");
            this.J = bundleExtra.getBoolean("movie_pass_present", true);
        }
        CJRMoviesSession cJRMoviesSession3 = this.f75705b;
        if (cJRMoviesSession3 == null) {
            kotlin.g.b.k.a("mSelectedMoviesSession");
        }
        CJRMovies cJRMovies2 = this.f75706c;
        if (cJRMovies2 == null) {
            kotlin.g.b.k.a("mSelectedMovie");
        }
        String str = this.f75707d;
        if (str == null) {
            kotlin.g.b.k.a("mSelectSeatTempTransactionId");
        }
        String str2 = this.x;
        if (str2 == null) {
            kotlin.g.b.k.a("mSeatSelectionSource");
        }
        String str3 = this.f75708e;
        if (str3 == null) {
            kotlin.g.b.k.a("mCitySearched");
        }
        ArrayList<CJRObjSeat> arrayList = this.f75709f;
        if (arrayList == null) {
            kotlin.g.b.k.a("mSelectedSeatList");
        }
        String str4 = this.y;
        if (str4 == null) {
            kotlin.g.b.k.a("mProductId");
        }
        this.w = new BookingData(cJRMoviesSession3, cJRMovies2, str, str2, str3, arrayList, str4, this.J, n(), this.f75710g);
        CJRMoviesSession cJRMoviesSession4 = this.f75705b;
        if (cJRMoviesSession4 == null) {
            kotlin.g.b.k.a("mSelectedMoviesSession");
        }
        this.K = cJRMoviesSession4.getScreenFormat();
        try {
            this.U = net.one97.paytm.o2o.movies.common.d.b((Context) this);
        } catch (Exception unused) {
        }
        CJRMovies cJRMovies3 = this.f75706c;
        if (cJRMovies3 == null) {
            kotlin.g.b.k.a("mSelectedMovie");
        }
        if (!TextUtils.isEmpty(cJRMovies3.getCensor())) {
            RoboTextView roboTextView2 = (RoboTextView) c(R.id.cinema_rating_rtv);
            kotlin.g.b.k.a((Object) roboTextView2, "cinema_rating_rtv");
            StringBuilder sb = new StringBuilder("(");
            String censor = cJRMovies3.getCensor();
            kotlin.g.b.k.a((Object) censor, "it.censor");
            if (censor != null) {
                String upperCase = censor.toUpperCase();
                kotlin.g.b.k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                sb.append(upperCase);
                sb.append(")");
                roboTextView2.setText(sb.toString());
            } else {
                throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            RoboTextView roboTextView3 = (RoboTextView) c(R.id.cinema_rating_rtv);
            kotlin.g.b.k.a((Object) roboTextView3, "cinema_rating_rtv");
            roboTextView3.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.G)) {
            RoboTextView roboTextView4 = (RoboTextView) c(R.id.cinema_language_rtv);
            kotlin.g.b.k.a((Object) roboTextView4, "cinema_language_rtv");
            String str5 = this.G;
            if (str5 == null) {
                kotlin.g.b.k.a();
            }
            if (str5 != null) {
                String upperCase2 = str5.toUpperCase();
                kotlin.g.b.k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                roboTextView4.setText(upperCase2);
            } else {
                throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            RoboTextView roboTextView5 = (RoboTextView) c(R.id.cinema_language_rtv);
            kotlin.g.b.k.a((Object) roboTextView5, "cinema_language_rtv");
            String language = cJRMovies3.getLanguage();
            kotlin.g.b.k.a((Object) language, "it.language");
            if (language != null) {
                String upperCase3 = language.toUpperCase();
                kotlin.g.b.k.a((Object) upperCase3, "(this as java.lang.String).toUpperCase()");
                roboTextView5.setText(upperCase3);
            } else {
                throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
            }
        }
        if (!TextUtils.isEmpty(this.K)) {
            RoboTextView roboTextView6 = (RoboTextView) c(R.id.cinema_format_rtv);
            kotlin.g.b.k.a((Object) roboTextView6, "cinema_format_rtv");
            String str6 = this.K;
            if (str6 == null) {
                kotlin.g.b.k.a();
            }
            if (str6 != null) {
                String upperCase4 = str6.toUpperCase();
                kotlin.g.b.k.a((Object) upperCase4, "(this as java.lang.String).toUpperCase()");
                roboTextView6.setText(upperCase4);
            } else {
                throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            RoboTextView roboTextView7 = (RoboTextView) c(R.id.cinema_format_rtv);
            kotlin.g.b.k.a((Object) roboTextView7, "cinema_format_rtv");
            roboTextView7.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.F)) {
            RoboTextView roboTextView8 = (RoboTextView) c(R.id.movie_cinema_lang_header);
            kotlin.g.b.k.a((Object) roboTextView8, "movie_cinema_lang_header");
            roboTextView8.setText(this.F);
        } else {
            RoboTextView roboTextView9 = (RoboTextView) c(R.id.movie_cinema_lang_header);
            kotlin.g.b.k.a((Object) roboTextView9, "movie_cinema_lang_header");
            roboTextView9.setText(cJRMovies3.getTitle());
        }
        CJRMovies cJRMovies4 = this.f75706c;
        if (cJRMovies4 == null) {
            kotlin.g.b.k.a("mSelectedMovie");
        }
        String imageURL = cJRMovies4.getImageURL();
        if (!(imageURL == null || (b2 = net.one97.paytm.o2o.movies.common.a.d.b(imageURL)) == null || (a2 = net.one97.paytm.o2o.movies.common.a.d.a(b2)) == null)) {
            net.one97.paytm.o2o.movies.utils.v.loadImage$default(net.one97.paytm.o2o.movies.utils.v.INSTANCE, a2, new ab(this), (Map) null, 4, (Object) null);
        }
        CJRMoviesSession cJRMoviesSession5 = this.f75705b;
        if (cJRMoviesSession5 == null) {
            kotlin.g.b.k.a("mSelectedMoviesSession");
        }
        if (cJRMoviesSession5 != null) {
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(cJRMoviesSession5.getRealShowDateTime())) {
                sb2.append(net.one97.paytm.o2o.movies.utils.n.f(cJRMoviesSession5.getRealShowDateTime()));
            }
            if (!TextUtils.isEmpty(cJRMoviesSession5.getRealShowDateTime())) {
                sb2.append(", " + net.one97.paytm.o2o.movies.utils.n.g(cJRMoviesSession5.getRealShowDateTime()));
            }
            RoboTextView roboTextView10 = (RoboTextView) c(R.id.time_date_cinema);
            kotlin.g.b.k.a((Object) roboTextView10, "time_date_cinema");
            roboTextView10.setText(sb2.toString());
        }
        CJRMoviesSession cJRMoviesSession6 = this.f75705b;
        if (cJRMoviesSession6 == null) {
            kotlin.g.b.k.a("mSelectedMoviesSession");
        }
        if (cJRMoviesSession6 != null) {
            CharSequence cinemaName = cJRMoviesSession6.getCinemaName();
            if (!(cinemaName == null || cinemaName.length() == 0)) {
                RoboTextView roboTextView11 = (RoboTextView) c(R.id.cinema_name_fnb);
                kotlin.g.b.k.a((Object) roboTextView11, "cinema_name_fnb");
                net.one97.paytm.o2o.movies.utils.h hVar = net.one97.paytm.o2o.movies.utils.h.f75928a;
                roboTextView11.setText(net.one97.paytm.o2o.movies.utils.h.a(cJRMoviesSession6));
            }
        }
        ((CheckBox) c(R.id.check_box_fast_forward)).setOnCheckedChangeListener(new e(this));
        CheckBox checkBox = (CheckBox) c(R.id.check_box_fast_forward);
        kotlin.g.b.k.a((Object) checkBox, "check_box_fast_forward");
        checkBox.setChecked(false);
        c();
        net.one97.paytm.o2o.movies.b.b bVar2 = this.R;
        if (!(bVar2 == null || (yVar15 = bVar2.z) == null)) {
            yVar15.observe(this, new f(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar3 = this.R;
        if (bVar3 != null) {
            BookingData bookingData = this.w;
            if (bookingData == null) {
                kotlin.g.b.k.a("mBookingData");
            }
            kotlin.g.b.k.c(bookingData, "bookingData");
            bVar3.f74886a = bookingData;
            bVar3.f74891f = bookingData.getMSelectSeatTempTransactionId();
            bVar3.f74890e = bookingData.getMSeatSelectionSource();
            bVar3.f74892g = bookingData.getMCitySearched();
            bVar3.f74893h = bookingData.getMProductId();
            bVar3.f74894i = bookingData.getMoviePassPresent();
            bVar3.k = true;
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(bVar3.f74887b, Dispatchers.getDefault(), (CoroutineStart) null, new b.f(bVar3, (kotlin.d.d) null), 2, (Object) null);
        }
        net.one97.paytm.o2o.movies.b.b bVar4 = this.R;
        if (!(bVar4 == null || (yVar14 = bVar4.l) == null)) {
            yVar14.observe(this, new m(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar5 = this.R;
        if (!(bVar5 == null || (yVar13 = bVar5.m) == null)) {
            yVar13.observe(this, new n(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar6 = this.R;
        if (!(bVar6 == null || (yVar12 = bVar6.n) == null)) {
            yVar12.observe(this, new o(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar7 = this.R;
        if (!(bVar7 == null || (yVar11 = bVar7.o) == null)) {
            yVar11.observe(this, new p(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar8 = this.R;
        if (!(bVar8 == null || (yVar10 = bVar8.p) == null)) {
            yVar10.observe(this, new q(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar9 = this.R;
        if (!(bVar9 == null || (yVar9 = bVar9.q) == null)) {
            yVar9.observe(this, new r(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar10 = this.R;
        if (!(bVar10 == null || (yVar8 = bVar10.r) == null)) {
            yVar8.observe(this, new s(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar11 = this.R;
        if (!(bVar11 == null || (yVar7 = bVar11.s) == null)) {
            yVar7.observe(this, new t(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar12 = this.R;
        if (!(bVar12 == null || (yVar6 = bVar12.t) == null)) {
            yVar6.observe(this, new g(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar13 = this.R;
        if (!(bVar13 == null || (yVar5 = bVar13.u) == null)) {
            yVar5.observe(this, new h(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar14 = this.R;
        if (!(bVar14 == null || (yVar4 = bVar14.v) == null)) {
            yVar4.observe(this, new i(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar15 = this.R;
        if (!(bVar15 == null || (yVar3 = bVar15.w) == null)) {
            yVar3.observe(this, new j(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar16 = this.R;
        if (!(bVar16 == null || (yVar2 = bVar16.x) == null)) {
            yVar2.observe(this, new k(this));
        }
        net.one97.paytm.o2o.movies.b.b bVar17 = this.R;
        if (!(bVar17 == null || (yVar = bVar17.y) == null)) {
            yVar.observe(this, new l(this));
        }
        try {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendOpenScreenWithDeviceInfo("/movies/review", "movies", this);
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
            String str7 = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str8 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str8, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str7, str8);
            String str9 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str9, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str9, "Screen Loaded");
            String str10 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str10, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str11 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str11, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str10, str11);
            if (ExtensionsKt.isNotNullNotBlank(this.U)) {
                String str12 = net.one97.paytm.o2o.movies.common.b.b.f75013h;
                String str13 = this.U;
                if (str13 == null) {
                    kotlin.g.b.k.a();
                }
                hashMap.put(str12, str13);
            }
            Map map = hashMap;
            String str14 = net.one97.paytm.o2o.movies.common.b.b.f75014i;
            kotlin.g.b.k.a((Object) str14, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_6");
            CJRMovies cJRMovies5 = this.f75706c;
            if (cJRMovies5 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String title = cJRMovies5.getTitle();
            kotlin.g.b.k.a((Object) title, "mSelectedMovie.title");
            map.put(str14, title);
            Map map2 = hashMap;
            String str15 = net.one97.paytm.o2o.movies.common.b.b.j;
            kotlin.g.b.k.a((Object) str15, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_7");
            CJRMovies cJRMovies6 = this.f75706c;
            if (cJRMovies6 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String code = cJRMovies6.getCode();
            kotlin.g.b.k.a((Object) code, "mSelectedMovie.code");
            map2.put(str15, code);
            Map map3 = hashMap;
            String str16 = net.one97.paytm.o2o.movies.common.b.b.k;
            kotlin.g.b.k.a((Object) str16, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_8");
            CJRMoviesSession cJRMoviesSession7 = this.f75705b;
            if (cJRMoviesSession7 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaName2 = cJRMoviesSession7.getCinemaName();
            kotlin.g.b.k.a((Object) cinemaName2, "mSelectedMoviesSession.cinemaName");
            map3.put(str16, cinemaName2);
            Map map4 = hashMap;
            String str17 = net.one97.paytm.o2o.movies.common.b.b.l;
            kotlin.g.b.k.a((Object) str17, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_9");
            CJRMoviesSession cJRMoviesSession8 = this.f75705b;
            if (cJRMoviesSession8 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaID = cJRMoviesSession8.getCinemaID();
            kotlin.g.b.k.a((Object) cinemaID, "mSelectedMoviesSession.cinemaID");
            map4.put(str17, cinemaID);
            CJRMoviesSession cJRMoviesSession9 = this.f75705b;
            if (cJRMoviesSession9 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            if (ExtensionsKt.isNotNullNotBlank(cJRMoviesSession9.getpKey())) {
                Map map5 = hashMap;
                String str18 = net.one97.paytm.o2o.movies.common.b.b.m;
                kotlin.g.b.k.a((Object) str18, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_10");
                CJRMoviesSession cJRMoviesSession10 = this.f75705b;
                if (cJRMoviesSession10 == null) {
                    kotlin.g.b.k.a("mSelectedMoviesSession");
                }
                String str19 = cJRMoviesSession10.getpKey();
                kotlin.g.b.k.a((Object) str19, "mSelectedMoviesSession.getpKey()");
                map5.put(str18, str19);
            }
            Map map6 = hashMap;
            String str20 = net.one97.paytm.o2o.movies.common.b.b.n;
            kotlin.g.b.k.a((Object) str20, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_11");
            CJRMovies cJRMovies7 = this.f75706c;
            if (cJRMovies7 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String language2 = cJRMovies7.getLanguage();
            kotlin.g.b.k.a((Object) language2, "mSelectedMovie.language");
            map6.put(str20, language2);
            if (com.paytm.utility.b.r((Context) this)) {
                String str21 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str21, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) this);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str21, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused3) {
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75741a;

        d(AJROrderReview aJROrderReview) {
            this.f75741a = aJROrderReview;
        }

        public final void onClick(View view) {
            this.f75741a.onBackPressed();
        }
    }

    public static final class ab implements ImageLoader.ImageListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75714a;

        ab(AJROrderReview aJROrderReview) {
            this.f75714a = aJROrderReview;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            kotlin.g.b.k.c(volleyError, "error");
            ImageView imageView = (ImageView) this.f75714a.c(R.id.movie_img);
            if (imageView != null) {
                imageView.setBackgroundColor(this.f75714a.getResources().getColor(R.color.movie_offline_img_color));
            }
        }

        public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            Bitmap bitmap;
            ImageView imageView;
            if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null && (imageView = (ImageView) this.f75714a.c(R.id.movie_img)) != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public final void c() {
        String str;
        ArrayList<CJRObjSeat> arrayList = this.f75709f;
        if (arrayList == null) {
            kotlin.g.b.k.a("mSelectedSeatList");
        }
        CJRObjSeat cJRObjSeat = (CJRObjSeat) kotlin.a.k.e(arrayList);
        if (cJRObjSeat != null) {
            if (this.f75710g > 1) {
                str = getString(R.string.tickets);
            } else {
                str = getString(R.string.ticket);
            }
            kotlin.g.b.k.a((Object) str, "if (mSelectedSeatsCount …etString(R.string.ticket)");
            double price = ((double) this.f75710g) * cJRObjSeat.getPrice();
            double d2 = ((double) this.L) + price;
            RoboTextView roboTextView = (RoboTextView) c(R.id.tickets_summary_price_tv);
            if (roboTextView != null) {
                roboTextView.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(d2));
            }
            String str2 = this.f75710g + " x " + str + " @ " + getString(R.string.rupee_symbol) + com.paytm.utility.b.a(cJRObjSeat.getPrice()) + " " + getString(R.string.per_ticket);
            RoboTextView roboTextView2 = (RoboTextView) c(R.id.tickets_summary_subinfo_tv);
            if (roboTextView2 != null) {
                roboTextView2.setText(str2);
            }
            if (this.f75710g > 1) {
                RoboTextView roboTextView3 = (RoboTextView) c(R.id.footer_total_seat_count_rtv);
                kotlin.g.b.k.a((Object) roboTextView3, "footer_total_seat_count_rtv");
                roboTextView3.setText(String.valueOf(this.f75710g) + " " + getString(R.string.footer_ticket_text) + "s");
            } else {
                RoboTextView roboTextView4 = (RoboTextView) c(R.id.footer_total_seat_count_rtv);
                kotlin.g.b.k.a((Object) roboTextView4, "footer_total_seat_count_rtv");
                roboTextView4.setText(String.valueOf(this.f75710g) + " " + getString(R.string.footer_ticket_text));
            }
            RoboTextView roboTextView5 = (RoboTextView) c(R.id.tickets_summary_subinfo_price_tv);
            if (roboTextView5 != null) {
                roboTextView5.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(price));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        CheckBox checkBox;
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.lyt_fast_forward);
        if (relativeLayout != null) {
            boolean z2 = true;
            if (net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout) && (checkBox = (CheckBox) c(R.id.check_box_fast_forward)) != null) {
                if (this.n <= j()) {
                    z2 = false;
                }
                checkBox.setChecked(z2);
            }
        }
        RoboTextView roboTextView = (RoboTextView) c(R.id.total_price_rtv);
        kotlin.g.b.k.a((Object) roboTextView, "total_price_rtv");
        roboTextView.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(j()));
        RoboTextView roboTextView2 = (RoboTextView) c(R.id.footer_total_price_rtv);
        kotlin.g.b.k.a((Object) roboTextView2, "footer_total_price_rtv");
        roboTextView2.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(j()));
    }

    private void o() {
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.discount_promo_rlt);
        kotlin.g.b.k.a((Object) relativeLayout, "discount_promo_rlt");
        relativeLayout.setVisibility(8);
        this.m = 0.0d;
        this.j.setPromoDiscount(this.m);
        d();
        this.f75704a = false;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        List<CJRTaxInfo> showTaxInformation;
        CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = this.f75712i;
        if (cJRMovieNewCancellationProtect != null && (showTaxInformation = cJRMovieNewCancellationProtect.getShowTaxInformation()) != null) {
            ((LinearLayout) c(R.id.cp_tax_info_llt)).removeAllViews();
            if (showTaxInformation.size() > 0) {
                for (CJRTaxInfo next : showTaxInformation) {
                    View inflate = getLayoutInflater().inflate(R.layout.order_tax_item, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.txt_label);
                    if (findViewById != null) {
                        TextView textView = (TextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.txt_value);
                        if (findViewById2 != null) {
                            kotlin.g.b.k.a((Object) next, "taxInfo");
                            textView.setText(next.getLabel());
                            ((TextView) findViewById2).setText(getResources().getString(R.string.rupee_symbol) + com.paytm.utility.b.x(next.getValue()));
                            Double.parseDouble(next.getValue());
                            ((LinearLayout) c(R.id.cp_tax_info_llt)).addView(inflate);
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                    }
                }
            }
        }
    }

    static final class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75742a;

        e(AJROrderReview aJROrderReview) {
            this.f75742a = aJROrderReview;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AJROrderReview aJROrderReview = this.f75742a;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
                String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
                kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
                String str2 = net.one97.paytm.o2o.movies.common.b.b.B;
                kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
                hashMap.put(str, str2);
                String str3 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
                kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
                hashMap.put(str3, "Fast Forward clicked");
                Map map = hashMap;
                String str4 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
                kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
                map.put(str4, z ? "true" : "false");
                String str5 = net.one97.paytm.o2o.movies.common.b.b.p;
                kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
                String str6 = net.one97.paytm.o2o.movies.common.b.b.r;
                kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
                hashMap.put(str5, str6);
                if (com.paytm.utility.b.r((Context) aJROrderReview)) {
                    String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                    kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                    String n = com.paytm.utility.b.n((Context) aJROrderReview);
                    kotlin.g.b.k.a((Object) n, "CJRAppCommonUtility.getUserId(this)");
                    hashMap.put(str7, n);
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aJROrderReview);
            } catch (Exception e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
    }

    public final void onClick(View view) {
        kotlin.g.b.k.c(view, "v");
        int id = view.getId();
        if (id == R.id.book_tickets_btn_rtv) {
            net.one97.paytm.o2o.movies.common.a.e.b((RoboTextView) c(R.id.book_tickets_btn_rtv));
            RoboTextView roboTextView = (RoboTextView) c(R.id.id_movie_pass_error);
            kotlin.g.b.k.a((Object) roboTextView, "id_movie_pass_error");
            net.one97.paytm.o2o.movies.common.a.e.a(roboTextView, false);
            try {
                RoboTextView roboTextView2 = (RoboTextView) c(R.id.book_tickets_btn_rtv);
                if (roboTextView2 != null) {
                    roboTextView2.setEnabled(false);
                }
                RoboTextView roboTextView3 = (RoboTextView) c(R.id.book_tickets_btn_rtv);
                if (roboTextView3 != null) {
                    roboTextView3.setClickable(false);
                }
                new Handler().postDelayed(new c(this), 2000);
            } catch (Exception unused) {
            }
            Context context = this;
            if (com.paytm.utility.b.r(context)) {
                q();
            } else {
                this.z = V;
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.signOut(this, false, (VolleyError) null);
                net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
                kotlin.g.b.k.a((Object) cVar, "MoviesController.getMovieEventListener()");
                startActivityForResult(new Intent(context, cVar.getPaytmActivityMap().get("authActivity")), W);
            }
            try {
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEvents("mov_seat_pay_selected", this);
            } catch (Exception unused2) {
            }
        } else if (id == R.id.id_movie_pass_apply_btn) {
            net.one97.paytm.o2o.movies.b.b bVar = this.R;
            if (bVar != null) {
                String str = this.I;
                int i2 = this.B;
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = this.f75712i;
                boolean z2 = this.Q;
                String str2 = this.y;
                if (str2 == null) {
                    kotlin.g.b.k.a("mProductId");
                }
                bVar.a(str, i2, cJRMovieNewCancellationProtect, z2, true, (String) null, false, str2, j(), (String) null, false);
            }
        } else if (id == R.id.activiy_back_btn) {
            onBackPressed();
        } else if (id == R.id.txt_cash_back_remove) {
            u();
        } else if (id == R.id.promo_applied_success_remove_image) {
            b(false, false);
        } else if (id == R.id.promo_default_show_all_rlt) {
            if (com.paytm.utility.b.c((Context) this)) {
                p();
            } else {
                try {
                    net.one97.paytm.o2o.movies.utils.p.a(this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message), u.f75758a);
                } catch (Exception e2) {
                    com.paytm.utility.q.d(e2.getMessage());
                }
            }
            t();
        }
    }

    static final class z implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75762a;

        z(AJROrderReview aJROrderReview) {
            this.f75762a = aJROrderReview;
        }

        public final void onClick(View view) {
            ArrayList<CJRFoodBeverageItemV2> a2 = net.one97.paytm.o2o.movies.utils.g.a().a(true);
            if (a2 == null) {
                this.f75762a.a(false, false);
            } else if (a2.size() == 0) {
                this.f75762a.a(false, true);
            } else {
                this.f75762a.a(true, false);
            }
        }
    }

    static final class ah implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75720a;

        ah(AJROrderReview aJROrderReview) {
            this.f75720a = aJROrderReview;
        }

        public final void onClick(View view) {
            if (this.f75720a.S) {
                RelativeLayout relativeLayout = (RelativeLayout) this.f75720a.c(R.id.ticket_summary_subinfo_container);
                kotlin.g.b.k.a((Object) relativeLayout, "ticket_summary_subinfo_container");
                net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout, true);
                LinearLayout linearLayout = (LinearLayout) this.f75720a.c(R.id.fees_tax_item_llt);
                kotlin.g.b.k.a((Object) linearLayout, "fees_tax_item_llt");
                net.one97.paytm.o2o.movies.common.a.e.a(linearLayout, true);
                if (this.f75720a.Q) {
                    LinearLayout linearLayout2 = (LinearLayout) this.f75720a.c(R.id.cp_tax_info_llt);
                    kotlin.g.b.k.a((Object) linearLayout2, "cp_tax_info_llt");
                    net.one97.paytm.o2o.movies.common.a.e.a(linearLayout2, true);
                }
                LinearLayout linearLayout3 = (LinearLayout) this.f75720a.c(R.id.fnb_items_llt);
                kotlin.g.b.k.a((Object) linearLayout3, "fnb_items_llt");
                net.one97.paytm.o2o.movies.common.a.e.a(linearLayout3, true);
                RoboTextView roboTextView = (RoboTextView) this.f75720a.c(R.id.summary_show_hide_btn_tv);
                kotlin.g.b.k.a((Object) roboTextView, "summary_show_hide_btn_tv");
                roboTextView.setText(this.f75720a.getString(R.string.btn_hide_summary_details));
                RoboTextView roboTextView2 = (RoboTextView) this.f75720a.c(R.id.txt_show_hide_indicator);
                kotlin.g.b.k.a((Object) roboTextView2, "txt_show_hide_indicator");
                roboTextView2.setText("—");
                this.f75720a.S = false;
                AJROrderReview.c(this.f75720a, false);
            } else {
                RelativeLayout relativeLayout2 = (RelativeLayout) this.f75720a.c(R.id.ticket_summary_subinfo_container);
                kotlin.g.b.k.a((Object) relativeLayout2, "ticket_summary_subinfo_container");
                net.one97.paytm.o2o.movies.common.a.e.a(relativeLayout2, false);
                LinearLayout linearLayout4 = (LinearLayout) this.f75720a.c(R.id.fees_tax_item_llt);
                kotlin.g.b.k.a((Object) linearLayout4, "fees_tax_item_llt");
                net.one97.paytm.o2o.movies.common.a.e.a(linearLayout4, false);
                LinearLayout linearLayout5 = (LinearLayout) this.f75720a.c(R.id.cp_tax_info_llt);
                kotlin.g.b.k.a((Object) linearLayout5, "cp_tax_info_llt");
                net.one97.paytm.o2o.movies.common.a.e.a(linearLayout5, false);
                LinearLayout linearLayout6 = (LinearLayout) this.f75720a.c(R.id.fnb_items_llt);
                kotlin.g.b.k.a((Object) linearLayout6, "fnb_items_llt");
                net.one97.paytm.o2o.movies.common.a.e.a(linearLayout6, false);
                RoboTextView roboTextView3 = (RoboTextView) this.f75720a.c(R.id.summary_show_hide_btn_tv);
                kotlin.g.b.k.a((Object) roboTextView3, "summary_show_hide_btn_tv");
                roboTextView3.setText(this.f75720a.getString(R.string.btn_show_summary_details));
                RoboTextView roboTextView4 = (RoboTextView) this.f75720a.c(R.id.txt_show_hide_indicator);
                kotlin.g.b.k.a((Object) roboTextView4, "txt_show_hide_indicator");
                roboTextView4.setText("+");
                this.f75720a.S = true;
                AJROrderReview.c(this.f75720a, true);
            }
            ((RelativeLayout) this.f75720a.c(R.id.movie_order_summary_rlt)).requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public final void p() {
        String str;
        CJRMovieOffers cJRMovieOffers = this.M;
        if (cJRMovieOffers != null) {
            if (kotlin.m.p.a("gzip", cJRMovieOffers.getNetworkResponse().headers.get("Content-Encoding"), true)) {
                str = com.paytm.network.b.g.a(com.paytm.network.b.g.a(cJRMovieOffers.getNetworkResponse().data));
            } else {
                byte[] bArr = cJRMovieOffers.getNetworkResponse().data;
                kotlin.g.b.k.a((Object) bArr, "it.networkResponse.data");
                str = new String(bArr, kotlin.m.d.f47971a);
            }
            ArrayList<CJRFoodBeverageItemV2> a2 = net.one97.paytm.o2o.movies.utils.g.a().a(true);
            if (a2 == null) {
                a2 = new ArrayList<>();
            }
            ArrayList<CJRFoodBeverageItemV2> arrayList = a2;
            net.one97.paytm.o2o.movies.b.b bVar = this.R;
            if (bVar != null) {
                double j2 = j();
                int i2 = this.B;
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = this.f75712i;
                boolean z2 = this.Q;
                String str2 = this.y;
                if (str2 == null) {
                    kotlin.g.b.k.a("mProductId");
                }
                bVar.a(str, j2, arrayList, i2, cJRMovieNewCancellationProtect, z2, str2);
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75740a;

        c(AJROrderReview aJROrderReview) {
            this.f75740a = aJROrderReview;
        }

        public final void run() {
            RoboTextView roboTextView = (RoboTextView) this.f75740a.c(R.id.book_tickets_btn_rtv);
            if (roboTextView != null) {
                roboTextView.setEnabled(true);
            }
            RoboTextView roboTextView2 = (RoboTextView) this.f75740a.c(R.id.book_tickets_btn_rtv);
            if (roboTextView2 != null) {
                roboTextView2.setClickable(true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (kotlin.m.p.a(r2.getCensor(), "A", true) != false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void q() {
        /*
            r11 = this;
            net.one97.paytm.o2o.movies.utils.g r0 = net.one97.paytm.o2o.movies.utils.g.a()
            r1 = 1
            java.util.ArrayList r0 = r0.a((boolean) r1)
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r2 = r11.f75706c
            java.lang.String r3 = "mSelectedMovie"
            if (r2 != 0) goto L_0x0012
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0012:
            if (r2 == 0) goto L_0x0051
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r2 = r11.f75706c
            if (r2 != 0) goto L_0x001b
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x001b:
            java.lang.String r2 = r2.getCensor()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0051
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r2 = r11.f75706c
            if (r2 != 0) goto L_0x002e
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x002e:
            java.lang.String r2 = r2.getCensor()
            java.lang.String r4 = "(A)"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r1)
            if (r2 != 0) goto L_0x004d
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovies r2 = r11.f75706c
            if (r2 != 0) goto L_0x0041
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0041:
            java.lang.String r2 = r2.getCensor()
            java.lang.String r3 = "A"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r1 == 0) goto L_0x0051
        L_0x004d:
            r11.r()
            return
        L_0x0051:
            r11.b((java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2>) r0)
            net.one97.paytm.o2o.movies.b.b r2 = r11.R
            if (r2 == 0) goto L_0x0089
            int r1 = net.one97.paytm.o2o.movies.R.id.check_box_fast_forward
            android.view.View r1 = r11.c((int) r1)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            r3 = 0
            if (r1 == 0) goto L_0x0069
            boolean r1 = r1.isChecked()
            r4 = r1
            goto L_0x006a
        L_0x0069:
            r4 = 0
        L_0x006a:
            int r5 = r11.B
            boolean r6 = r11.Q
            net.one97.paytm.o2o.movies.entity.CJRMovieNewCancellationProtect r7 = r11.f75712i
            int r1 = net.one97.paytm.o2o.movies.R.id.check_box_movie_loyal
            android.view.View r1 = r11.c((int) r1)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            if (r1 == 0) goto L_0x0080
            boolean r1 = r1.isChecked()
            r8 = r1
            goto L_0x0081
        L_0x0080:
            r8 = 0
        L_0x0081:
            double r9 = r11.j()
            r3 = r0
            r2.a((java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2>) r3, (boolean) r4, (int) r5, (boolean) r6, (net.one97.paytm.o2o.movies.entity.CJRMovieNewCancellationProtect) r7, (boolean) r8, (double) r9)
        L_0x0089:
            boolean r1 = r11.Q     // Catch:{ Exception -> 0x008e }
            r11.a((java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2>) r0, (boolean) r1)     // Catch:{ Exception -> 0x008e }
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.order_review.AJROrderReview.q():void");
    }

    /* access modifiers changed from: private */
    public final void b(ArrayList<CJRFoodBeverageItemV2> arrayList) {
        String str;
        String str2;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
            String str3 = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str4 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str3, str4);
            String str5 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str5, "Proceed to Pay Clicked");
            StringBuilder sb = new StringBuilder("Mov_name=");
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|Mov_code=");
            CJRMovies cJRMovies2 = this.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|Hall_name=");
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|Hall_code=");
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            String sb2 = sb.toString();
            if (arrayList == null || arrayList.size() <= 0) {
                str = sb2 + "|Food=No";
            } else {
                str = sb2 + "|Food=Yes";
            }
            if (this.Q) {
                str2 = str + "|CP=Yes";
            } else {
                str2 = str + "|CP=No";
            }
            if (ExtensionsKt.isNotNullNotBlank(this.U)) {
                String str6 = net.one97.paytm.o2o.movies.common.b.b.f75013h;
                String str7 = this.U;
                if (str7 == null) {
                    kotlin.g.b.k.a();
                }
                hashMap.put(str6, str7);
            }
            Map map = hashMap;
            String str8 = net.one97.paytm.o2o.movies.common.b.b.f75014i;
            kotlin.g.b.k.a((Object) str8, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_6");
            CJRMovies cJRMovies3 = this.f75706c;
            if (cJRMovies3 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String title = cJRMovies3.getTitle();
            kotlin.g.b.k.a((Object) title, "mSelectedMovie.title");
            map.put(str8, title);
            Map map2 = hashMap;
            String str9 = net.one97.paytm.o2o.movies.common.b.b.j;
            kotlin.g.b.k.a((Object) str9, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_7");
            CJRMovies cJRMovies4 = this.f75706c;
            if (cJRMovies4 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String code = cJRMovies4.getCode();
            kotlin.g.b.k.a((Object) code, "mSelectedMovie.code");
            map2.put(str9, code);
            Map map3 = hashMap;
            String str10 = net.one97.paytm.o2o.movies.common.b.b.k;
            kotlin.g.b.k.a((Object) str10, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_8");
            CJRMoviesSession cJRMoviesSession3 = this.f75705b;
            if (cJRMoviesSession3 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaName = cJRMoviesSession3.getCinemaName();
            kotlin.g.b.k.a((Object) cinemaName, "mSelectedMoviesSession.cinemaName");
            map3.put(str10, cinemaName);
            Map map4 = hashMap;
            String str11 = net.one97.paytm.o2o.movies.common.b.b.l;
            kotlin.g.b.k.a((Object) str11, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_9");
            CJRMoviesSession cJRMoviesSession4 = this.f75705b;
            if (cJRMoviesSession4 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaID = cJRMoviesSession4.getCinemaID();
            kotlin.g.b.k.a((Object) cinemaID, "mSelectedMoviesSession.cinemaID");
            map4.put(str11, cinemaID);
            CJRMoviesSession cJRMoviesSession5 = this.f75705b;
            if (cJRMoviesSession5 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            if (ExtensionsKt.isNotNullNotBlank(cJRMoviesSession5.getpKey())) {
                Map map5 = hashMap;
                String str12 = net.one97.paytm.o2o.movies.common.b.b.m;
                kotlin.g.b.k.a((Object) str12, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_10");
                CJRMoviesSession cJRMoviesSession6 = this.f75705b;
                if (cJRMoviesSession6 == null) {
                    kotlin.g.b.k.a("mSelectedMoviesSession");
                }
                String str13 = cJRMoviesSession6.getpKey();
                kotlin.g.b.k.a((Object) str13, "mSelectedMoviesSession.getpKey()");
                map5.put(str12, str13);
            }
            Map map6 = hashMap;
            String str14 = net.one97.paytm.o2o.movies.common.b.b.n;
            kotlin.g.b.k.a((Object) str14, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_11");
            CJRMovies cJRMovies5 = this.f75706c;
            if (cJRMovies5 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String language = cJRMovies5.getLanguage();
            kotlin.g.b.k.a((Object) language, "mSelectedMovie.language");
            map6.put(str14, language);
            String str15 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str15, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            hashMap.put(str15, str2);
            String str16 = net.one97.paytm.o2o.movies.common.b.b.o;
            kotlin.g.b.k.a((Object) str16, "CJRMoviesGTMConstants.GTM_KEY_EVENT_VALUE");
            hashMap.put(str16, Integer.valueOf((int) j()));
            String str17 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str17, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str18 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str18, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str17, str18);
            if (com.paytm.utility.b.r((Context) this)) {
                String str19 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str19, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) this);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str19, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    private final void r() {
        ArrayList<CJRFoodBeverageItemV2> a2 = net.one97.paytm.o2o.movies.utils.g.a().a(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.movies_content_warning_title));
        builder.setMessage(getResources().getString(R.string.movies_content_warning_message));
        builder.setPositiveButton(getResources().getString(R.string.proceed), new am(this, a2));
        builder.setCancelable(true);
        builder.show();
    }

    static final class am implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75725a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f75726b;

        am(AJROrderReview aJROrderReview, ArrayList arrayList) {
            this.f75725a = aJROrderReview;
            this.f75726b = arrayList;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f75725a.b((ArrayList<CJRFoodBeverageItemV2>) this.f75726b);
            net.one97.paytm.o2o.movies.b.b n = this.f75725a.R;
            if (n != null) {
                ArrayList arrayList = this.f75726b;
                CheckBox checkBox = (CheckBox) this.f75725a.c(R.id.check_box_fast_forward);
                boolean isChecked = checkBox != null ? checkBox.isChecked() : false;
                int o = this.f75725a.B;
                boolean m = this.f75725a.Q;
                CJRMovieNewCancellationProtect p = this.f75725a.f75712i;
                CheckBox checkBox2 = (CheckBox) this.f75725a.c(R.id.check_box_movie_loyal);
                n.a((ArrayList<CJRFoodBeverageItemV2>) arrayList, isChecked, o, m, p, checkBox2 != null ? checkBox2.isChecked() : false, this.f75725a.j());
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == W && i3 == -1) {
            if (com.paytm.utility.b.r((Context) this) && kotlin.m.p.a(V, this.z, true)) {
                q();
            }
        } else if (i2 == 2343) {
            this.E = false;
            if (i3 == -1) {
                net.one97.paytm.o2o.movies.utils.g.a().c();
                a(false);
            }
        } else if (i2 == 4524) {
            net.one97.paytm.o2o.movies.b.b bVar = this.R;
            if (bVar != null) {
                bVar.c();
            }
            l();
        }
    }

    /* access modifiers changed from: private */
    public final void s() {
        List<? extends CJRMovieOfferCode> list = this.k;
        if (list != null) {
            boolean z2 = false;
            CJRMovieOfferCode cJRMovieOfferCode = (CJRMovieOfferCode) list.get(0);
            if (cJRMovieOfferCode != null) {
                RoboTextView roboTextView = (RoboTextView) c(R.id.promo_detail_desc_rtv);
                kotlin.g.b.k.a((Object) roboTextView, "promo_detail_desc_rtv");
                roboTextView.setText(cJRMovieOfferCode.getOfferText());
                RoboTextView roboTextView2 = (RoboTextView) c(R.id.promo_detail_header_rtv);
                kotlin.g.b.k.a((Object) roboTextView2, "promo_detail_header_rtv");
                roboTextView2.setText(cJRMovieOfferCode.getCode());
                RelativeLayout relativeLayout = (RelativeLayout) c(R.id.promo_code_not_applied_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout, "promo_code_not_applied_parent_rlt");
                relativeLayout.setVisibility(0);
                RelativeLayout relativeLayout2 = (RelativeLayout) c(R.id.promo_default_show_all_rlt);
                kotlin.g.b.k.a((Object) relativeLayout2, "promo_default_show_all_rlt");
                relativeLayout2.setVisibility(8);
                ImageView imageView = (ImageView) c(R.id.promo_icon_iv);
                if (imageView != null) {
                    imageView.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.promo_icon_default_drawable));
                }
                CJROffer offer = cJRMovieOfferCode.getOffer();
                if (offer != null) {
                    String str = offer.icon;
                    kotlin.g.b.k.a((Object) str, "it.icon");
                    if (str.length() > 0) {
                        z2 = true;
                    }
                    if (z2) {
                        net.one97.paytm.o2o.movies.utils.v vVar = net.one97.paytm.o2o.movies.utils.v.INSTANCE;
                        String str2 = offer.icon;
                        kotlin.g.b.k.a((Object) str2, "it.icon");
                        net.one97.paytm.o2o.movies.utils.v.loadImage$default(vVar, net.one97.paytm.o2o.movies.common.a.d.a(str2), new ag(this), (Map) null, 4, (Object) null);
                    } else {
                        ImageView imageView2 = (ImageView) c(R.id.promo_icon_iv);
                        if (imageView2 != null) {
                            imageView2.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.promo_icon_default_drawable));
                        }
                    }
                }
            }
        }
        if (this.I != null) {
            RelativeLayout relativeLayout3 = (RelativeLayout) c(R.id.promo_code_not_applied_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout3, "promo_code_not_applied_parent_rlt");
            relativeLayout3.setVisibility(4);
            return;
        }
        RelativeLayout relativeLayout4 = (RelativeLayout) c(R.id.movie_pass_parent_rlt);
        kotlin.g.b.k.a((Object) relativeLayout4, "movie_pass_parent_rlt");
        relativeLayout4.setVisibility(8);
    }

    public static final class ag implements ImageLoader.ImageListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75719a;

        ag(AJROrderReview aJROrderReview) {
            this.f75719a = aJROrderReview;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            kotlin.g.b.k.c(volleyError, "error");
            ImageView imageView = (ImageView) this.f75719a.c(R.id.promo_icon_iv);
            if (imageView != null) {
                imageView.setImageDrawable(androidx.core.content.b.a((Context) this.f75719a, R.drawable.promo_icon_default_drawable));
            }
        }

        public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            if (imageContainer == null) {
                return;
            }
            if (imageContainer.getBitmap() != null) {
                ImageView imageView = (ImageView) this.f75719a.c(R.id.promo_icon_iv);
                if (imageView != null) {
                    imageView.setImageBitmap(imageContainer.getBitmap());
                    return;
                }
                return;
            }
            ImageView imageView2 = (ImageView) this.f75719a.c(R.id.promo_icon_iv);
            if (imageView2 != null) {
                imageView2.setImageDrawable(androidx.core.content.b.a((Context) this.f75719a, R.drawable.promo_icon_default_drawable));
            }
        }
    }

    static final class ac implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75715a;

        ac(AJROrderReview aJROrderReview) {
            this.f75715a = aJROrderReview;
        }

        public final void onClick(View view) {
            CJRMovieOfferCode cJRMovieOfferCode;
            List f2 = this.f75715a.k;
            if (f2 != null && (cJRMovieOfferCode = (CJRMovieOfferCode) kotlin.a.k.a(f2, 0)) != null) {
                this.f75715a.a(cJRMovieOfferCode, false);
            }
        }
    }

    static final class ad implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75716a;

        ad(AJROrderReview aJROrderReview) {
            this.f75716a = aJROrderReview;
        }

        public final void onClick(View view) {
            AJROrderReview.r(this.f75716a);
        }
    }

    static final class ae implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75717a;

        ae(AJROrderReview aJROrderReview) {
            this.f75717a = aJROrderReview;
        }

        public final void onClick(View view) {
            AJROrderReview.r(this.f75717a);
        }
    }

    static final class af implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75718a;

        af(AJROrderReview aJROrderReview) {
            this.f75718a = aJROrderReview;
        }

        public final void onClick(View view) {
            this.f75718a.u();
        }
    }

    static void a(StringBuilder sb, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (sb.length() > 0) {
                sb.append("/");
            }
            sb.append(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CJRMovieOfferCode cJRMovieOfferCode, boolean z2) {
        CJRMovieOfferCode cJRMovieOfferCode2 = cJRMovieOfferCode;
        if (isFinishing()) {
            return;
        }
        if (com.paytm.utility.b.c((Context) this)) {
            if (cJRMovieOfferCode2 == null) {
                kotlin.g.b.k.a();
            }
            boolean a2 = kotlin.m.p.a(Constants.BANK_OFFER_KEY, cJRMovieOfferCode2.campaignType, true);
            net.one97.paytm.o2o.movies.b.b bVar = this.R;
            if (bVar != null) {
                String code = cJRMovieOfferCode.getCode();
                int i2 = this.B;
                CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = this.f75712i;
                boolean z3 = this.Q;
                String str = cJRMovieOfferCode2.filters;
                String str2 = this.y;
                if (str2 == null) {
                    kotlin.g.b.k.a("mProductId");
                }
                bVar.a(code, i2, cJRMovieNewCancellationProtect, z3, false, str, a2, str2, j(), cJRMovieOfferCode.getOfferText(), z2);
                return;
            }
            return;
        }
        try {
            net.one97.paytm.o2o.movies.utils.p.a(this, getString(R.string.network_error_heading), getString(R.string.network_error_message), b.f75739a);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void t() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
            String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str2 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str, str2);
            String str3 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str3, "Have a Promocode clicked");
            Map map = hashMap;
            String str4 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            StringBuilder sb = new StringBuilder();
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|");
            CJRMovies cJRMovies2 = this.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            map.put(str4, sb.toString());
            if (ExtensionsKt.isNotNullNotBlank(this.U)) {
                String str5 = net.one97.paytm.o2o.movies.common.b.b.f75013h;
                String str6 = this.U;
                if (str6 == null) {
                    kotlin.g.b.k.a();
                }
                hashMap.put(str5, str6);
            }
            Map map2 = hashMap;
            String str7 = net.one97.paytm.o2o.movies.common.b.b.f75014i;
            kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_6");
            CJRMovies cJRMovies3 = this.f75706c;
            if (cJRMovies3 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String title = cJRMovies3.getTitle();
            kotlin.g.b.k.a((Object) title, "mSelectedMovie.title");
            map2.put(str7, title);
            Map map3 = hashMap;
            String str8 = net.one97.paytm.o2o.movies.common.b.b.j;
            kotlin.g.b.k.a((Object) str8, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_7");
            CJRMovies cJRMovies4 = this.f75706c;
            if (cJRMovies4 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String code = cJRMovies4.getCode();
            kotlin.g.b.k.a((Object) code, "mSelectedMovie.code");
            map3.put(str8, code);
            Map map4 = hashMap;
            String str9 = net.one97.paytm.o2o.movies.common.b.b.k;
            kotlin.g.b.k.a((Object) str9, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_8");
            CJRMoviesSession cJRMoviesSession3 = this.f75705b;
            if (cJRMoviesSession3 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaName = cJRMoviesSession3.getCinemaName();
            kotlin.g.b.k.a((Object) cinemaName, "mSelectedMoviesSession.cinemaName");
            map4.put(str9, cinemaName);
            Map map5 = hashMap;
            String str10 = net.one97.paytm.o2o.movies.common.b.b.l;
            kotlin.g.b.k.a((Object) str10, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_9");
            CJRMoviesSession cJRMoviesSession4 = this.f75705b;
            if (cJRMoviesSession4 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaID = cJRMoviesSession4.getCinemaID();
            kotlin.g.b.k.a((Object) cinemaID, "mSelectedMoviesSession.cinemaID");
            map5.put(str10, cinemaID);
            CJRMoviesSession cJRMoviesSession5 = this.f75705b;
            if (cJRMoviesSession5 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            if (ExtensionsKt.isNotNullNotBlank(cJRMoviesSession5.getpKey())) {
                Map map6 = hashMap;
                String str11 = net.one97.paytm.o2o.movies.common.b.b.m;
                kotlin.g.b.k.a((Object) str11, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_10");
                CJRMoviesSession cJRMoviesSession6 = this.f75705b;
                if (cJRMoviesSession6 == null) {
                    kotlin.g.b.k.a("mSelectedMoviesSession");
                }
                String str12 = cJRMoviesSession6.getpKey();
                kotlin.g.b.k.a((Object) str12, "mSelectedMoviesSession.getpKey()");
                map6.put(str11, str12);
            }
            Map map7 = hashMap;
            String str13 = net.one97.paytm.o2o.movies.common.b.b.n;
            kotlin.g.b.k.a((Object) str13, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL_11");
            CJRMovies cJRMovies5 = this.f75706c;
            if (cJRMovies5 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String language = cJRMovies5.getLanguage();
            kotlin.g.b.k.a((Object) language, "mSelectedMovie.language");
            map7.put(str13, language);
            String str14 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str14, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str15 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str15, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str14, str15);
            if (com.paytm.utility.b.r((Context) this)) {
                String str16 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str16, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) this);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str16, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    public final void onBackPressed() {
        net.one97.paytm.o2o.movies.utils.g.a().d();
        k();
        net.one97.paytm.o2o.movies.common.e.a(this);
        super.onBackPressed();
    }

    public final void finish() {
        super.finish();
        net.one97.paytm.o2o.movies.common.e.a(this);
    }

    /* access modifiers changed from: private */
    public final void u() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.remove_code_title));
        builder.setMessage(getResources().getString(R.string.remove_code_msg));
        builder.setPositiveButton(getResources().getString(R.string.yes), new ak(this));
        builder.setNegativeButton(getResources().getString(R.string.no), al.f75724a);
        builder.show();
    }

    static final class ak implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75723a;

        ak(AJROrderReview aJROrderReview) {
            this.f75723a = aJROrderReview;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f75723a.b(false, false);
        }
    }

    static final class ai implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75721a;

        ai(AJROrderReview aJROrderReview) {
            this.f75721a = aJROrderReview;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f75721a.b(false, false);
        }
    }

    static final class aj implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75722a;

        aj(AJROrderReview aJROrderReview) {
            this.f75722a = aJROrderReview;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f75722a.b(false);
        }
    }

    static final class an implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75727a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f75728b;

        an(AJROrderReview aJROrderReview, ArrayList arrayList) {
            this.f75727a = aJROrderReview;
            this.f75728b = arrayList;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            net.one97.paytm.o2o.movies.b.b n = this.f75727a.R;
            if (n != null) {
                ArrayList arrayList = this.f75728b;
                CheckBox checkBox = (CheckBox) this.f75727a.c(R.id.check_box_fast_forward);
                boolean isChecked = checkBox != null ? checkBox.isChecked() : false;
                int o = this.f75727a.B;
                CheckBox checkBox2 = (CheckBox) this.f75727a.c(R.id.check_box_movie_loyal);
                n.a((ArrayList<CJRFoodBeverageItemV2>) arrayList, isChecked, o, false, (CJRMovieNewCancellationProtect) null, checkBox2 != null ? checkBox2.isChecked() : false, this.f75727a.j());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(boolean z2, boolean z3) {
        net.one97.paytm.o2o.movies.b.b bVar;
        o();
        this.l = 0.0d;
        if (!z3 && (bVar = this.R) != null) {
            bVar.a(z2);
        }
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.promo_code_applied_parent_rlt);
        kotlin.g.b.k.a((Object) relativeLayout, "promo_code_applied_parent_rlt");
        relativeLayout.setVisibility(4);
        RelativeLayout relativeLayout2 = (RelativeLayout) c(R.id.promo_code_not_applied_parent_rlt);
        kotlin.g.b.k.a((Object) relativeLayout2, "promo_code_not_applied_parent_rlt");
        relativeLayout2.setVisibility(0);
        List<? extends CJRMovieOfferCode> list = this.k;
        if (list == null) {
            RelativeLayout relativeLayout3 = (RelativeLayout) c(R.id.promo_code_not_applied_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout3, "promo_code_not_applied_parent_rlt");
            relativeLayout3.setVisibility(8);
            RelativeLayout relativeLayout4 = (RelativeLayout) c(R.id.promo_default_show_all_rlt);
            kotlin.g.b.k.a((Object) relativeLayout4, "promo_default_show_all_rlt");
            relativeLayout4.setVisibility(0);
        } else {
            if (list == null) {
                kotlin.g.b.k.a();
            }
            if (list.size() == 0) {
                RelativeLayout relativeLayout5 = (RelativeLayout) c(R.id.promo_code_not_applied_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout5, "promo_code_not_applied_parent_rlt");
                relativeLayout5.setVisibility(8);
                RelativeLayout relativeLayout6 = (RelativeLayout) c(R.id.promo_default_show_all_rlt);
                kotlin.g.b.k.a((Object) relativeLayout6, "promo_default_show_all_rlt");
                relativeLayout6.setVisibility(0);
            }
        }
        if (this.I != null) {
            RelativeLayout relativeLayout7 = (RelativeLayout) c(R.id.movie_pass_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout7, "movie_pass_parent_rlt");
            relativeLayout7.setVisibility(0);
            RoboTextView roboTextView = (RoboTextView) c(R.id.id_movie_pass_error);
            kotlin.g.b.k.a((Object) roboTextView, "id_movie_pass_error");
            roboTextView.setVisibility(8);
            RelativeLayout relativeLayout8 = (RelativeLayout) c(R.id.promo_code_not_applied_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout8, "promo_code_not_applied_parent_rlt");
            relativeLayout8.setVisibility(4);
        } else {
            List<? extends CJRMovieOfferCode> list2 = this.k;
            if (list2 != null) {
                if (list2 == null) {
                    kotlin.g.b.k.a();
                }
                if (list2.size() > 0) {
                    s();
                }
            }
        }
        i();
    }

    static final class f<T> implements androidx.lifecycle.z<Intent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75743a;

        f(AJROrderReview aJROrderReview) {
            this.f75743a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.o2o.movies.common.e.a((Activity) this.f75743a, (kotlin.g.a.a<kotlin.x>) new kotlin.g.a.a<kotlin.x>(this) {
                final /* synthetic */ f this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.f75743a.k();
                    this.this$0.f75743a.finish();
                    Intent intent = this.this$0.f75743a.getIntent();
                    SeatMapData seatMapData = intent != null ? (SeatMapData) intent.getParcelableExtra("seatmap_data") : null;
                    if (!(seatMapData instanceof SeatMapData)) {
                        seatMapData = null;
                    }
                    if (seatMapData != null) {
                        SeatSelectionActivity.a aVar = SeatSelectionActivity.f75763a;
                        SeatSelectionActivity.a.a(this.this$0.f75743a, seatMapData);
                    }
                }
            });
        }
    }

    public final void a(boolean z2) {
        ArrayList<CJRFoodBeverageItemV2> a2 = net.one97.paytm.o2o.movies.utils.g.a().a(true);
        if (a2 == null || a2.size() <= 0) {
            ((LinearLayout) c(R.id.fnb_items_llt)).removeAllViews();
            this.C = 0.0d;
            RoboTextView roboTextView = (RoboTextView) c(R.id.fnb_summary_total_price_rtv);
            if (roboTextView != null) {
                roboTextView.setText("");
            }
            RoboTextView roboTextView2 = (RoboTextView) c(R.id.fnb_summary_add_change_rtv);
            if (roboTextView2 != null) {
                roboTextView2.setText(getString(R.string.food_bev_add));
                roboTextView2.setTextColor(Color.parseColor("#00baf2"));
            }
        } else {
            this.C = 0.0d;
            ((LinearLayout) c(R.id.fnb_items_llt)).removeAllViews();
            int size = a2.size();
            int i2 = 0;
            while (i2 < size) {
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = a2.get(i2);
                kotlin.g.b.k.a((Object) cJRFoodBeverageItemV2, "foodBevWithQuantity[m]");
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV22 = cJRFoodBeverageItemV2;
                int i3 = cJRFoodBeverageItemV22.getmFoodQauntitySelected();
                double parseDouble = Double.parseDouble(cJRFoodBeverageItemV22.getmPrice());
                double d2 = ((double) i3) * parseDouble;
                this.C += d2;
                RoboTextView roboTextView3 = (RoboTextView) c(R.id.fnb_summary_total_price_rtv);
                if (roboTextView3 != null) {
                    roboTextView3.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(this.C));
                }
                RoboTextView roboTextView4 = (RoboTextView) c(R.id.fnb_summary_add_change_rtv);
                if (roboTextView4 != null) {
                    roboTextView4.setText(getString(R.string.food_bev_change));
                    roboTextView4.setTextColor(Color.parseColor("#ffad00"));
                }
                View inflate = getLayoutInflater().inflate(R.layout.order_fnb_item, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.txt_label);
                if (findViewById != null) {
                    TextView textView = (TextView) findViewById;
                    View findViewById2 = inflate.findViewById(R.id.txt_value);
                    if (findViewById2 != null) {
                        TextView textView2 = (TextView) findViewById2;
                        String str = i3 + " x " + cJRFoodBeverageItemV22.getmItemName() + " @ " + getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(parseDouble) + " " + getString(R.string.per_item);
                        if (!CJRFoodBeverageItemV2.FOOD_VOUCHER.equals(cJRFoodBeverageItemV22.getType()) || net.one97.paytm.o2o.movies.common.a.d.b(cJRFoodBeverageItemV22.getTermConditionRedeemProcess()) == null) {
                            textView.setOnClickListener((View.OnClickListener) null);
                        } else {
                            str = str + " <font color=\"#00baf2\">T&C</font>";
                            textView.setOnClickListener(new av(this, cJRFoodBeverageItemV22));
                        }
                        textView.setText(Html.fromHtml(str), TextView.BufferType.SPANNABLE);
                        textView2.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(d2));
                        ((LinearLayout) c(R.id.fnb_items_llt)).addView(inflate);
                        i2++;
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                }
            }
        }
        this.j.setFnbPrice(this.C);
        d();
        i();
        if (z2 && m()) {
            v();
        }
        if (m()) {
            b(true, false);
        }
    }

    static final class av implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75737a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRFoodBeverageItemV2 f75738b;

        av(AJROrderReview aJROrderReview, CJRFoodBeverageItemV2 cJRFoodBeverageItemV2) {
            this.f75737a = aJROrderReview;
            this.f75738b = cJRFoodBeverageItemV2;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.a((Object) view, "it");
            Context context = view.getContext();
            if (context != null) {
                WebViewBS t = this.f75737a.T;
                if (t != null) {
                    t.f76195a.dismiss();
                }
                this.f75737a.T = null;
                this.f75737a.T = new WebViewBS(context);
                WebViewBS t2 = this.f75737a.T;
                if (t2 != null) {
                    t2.a(this.f75738b.getTermConditionRedeemProcess());
                }
            }
        }
    }

    static final class h<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75745a;

        h(AJROrderReview aJROrderReview) {
            this.f75745a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f75745a.b(false, true);
        }
    }

    private final void v() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.alert));
        builder.setMessage(getString(R.string.promo_code_will_be_removed));
        builder.setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.ok), as.f75734a);
        builder.show();
    }

    static final class as implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final as f75734a = new as();

        as() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public final void a(boolean z2, boolean z3) {
        if (!this.E) {
            this.E = true;
            net.one97.paytm.o2o.movies.utils.g.a().b();
            Intent intent = new Intent(this, AJRFnBDialog.class);
            intent.putExtra("showSelected", z2);
            intent.putExtra("promoApplied", m());
            intent.putExtra("showSkip", z3);
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            intent.putExtra("moviesession", cJRMoviesSession);
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            intent.putExtra("selectedmovie", cJRMovies);
            startActivityForResult(intent, 2343);
        }
    }

    public final void a(int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Movie Tickets - Checkout Screen");
            String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str2 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str, str2);
            String str3 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str3, "Food Item Added|" + (i2 + 1));
            Map map = hashMap;
            String str4 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            StringBuilder sb = new StringBuilder();
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|");
            CJRMovies cJRMovies2 = this.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            map.put(str4, sb.toString());
            String str5 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str6 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str5, str6);
            if (com.paytm.utility.b.r((Context) this)) {
                String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) this);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str7, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    public final void b(int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Movie Tickets - Checkout Screen");
            String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str2 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str, str2);
            String str3 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str3, "Food Item Removed|" + (i2 + 1));
            Map map = hashMap;
            String str4 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            StringBuilder sb = new StringBuilder();
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|");
            CJRMovies cJRMovies2 = this.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            map.put(str4, sb.toString());
            String str5 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str6 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str5, str6);
            if (com.paytm.utility.b.r((Context) this)) {
                String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) this);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str7, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    public final void f() {
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.parent_layoyt);
        kotlin.g.b.k.a((Object) relativeLayout, "parent_layoyt");
        relativeLayout.setVisibility(0);
        if (this.I == null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) c(R.id.movie_pass_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout2, "movie_pass_parent_rlt");
            relativeLayout2.setVisibility(4);
        }
        CJRMovieWidget cJRMovieWidget = this.H;
        if (cJRMovieWidget != null) {
            if (cJRMovieWidget == null) {
                kotlin.g.b.k.a();
            }
            if (kotlin.m.p.a(cJRMovieWidget.getType(), "promo", true)) {
                CJRMovieWidget cJRMovieWidget2 = this.H;
                if (cJRMovieWidget2 == null) {
                    kotlin.g.b.k.a();
                }
                if (cJRMovieWidget2.getInfo() != null) {
                    CJRMovieWidget cJRMovieWidget3 = this.H;
                    if (cJRMovieWidget3 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRMovieWidgetInfo info = cJRMovieWidget3.getInfo();
                    kotlin.g.b.k.a((Object) info, "mCJRMovieWidget!!.info");
                    ArrayList<CJRMovieWidgetValue> values = info.getValues();
                    if (values != null && values.size() > 0) {
                        CJRMovieWidgetValue cJRMovieWidgetValue = values.get(0);
                        kotlin.g.b.k.a((Object) cJRMovieWidgetValue, "offer");
                        if (!TextUtils.isEmpty(cJRMovieWidgetValue.getHeader())) {
                            TextUtils.isEmpty(cJRMovieWidgetValue.getText());
                        }
                    }
                }
            }
        }
        Toolbar toolbar = (Toolbar) c(R.id.movie_details_toolbar);
        kotlin.g.b.k.a((Object) toolbar, "movie_details_toolbar");
        toolbar.setVisibility(0);
        RelativeLayout relativeLayout3 = (RelativeLayout) c(R.id.lyt_fast_forward);
        kotlin.g.b.k.a((Object) relativeLayout3, "lyt_fast_forward");
        relativeLayout3.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) c(R.id.txt_proceed_to_pay_layout);
        kotlin.g.b.k.a((Object) linearLayout, "txt_proceed_to_pay_layout");
        linearLayout.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        ProgressBar progressBar = (ProgressBar) c(R.id.loading);
        kotlin.g.b.k.a((Object) progressBar, "loading");
        progressBar.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) c(R.id.parent_layoyt);
        kotlin.g.b.k.a((Object) relativeLayout, "parent_layoyt");
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) c(R.id.lyt_fast_forward);
        kotlin.g.b.k.a((Object) relativeLayout2, "lyt_fast_forward");
        relativeLayout2.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) c(R.id.txt_proceed_to_pay_layout);
        kotlin.g.b.k.a((Object) linearLayout, "txt_proceed_to_pay_layout");
        linearLayout.setVisibility(0);
        Toolbar toolbar = (Toolbar) c(R.id.movie_details_toolbar);
        kotlin.g.b.k.a((Object) toolbar, "movie_details_toolbar");
        toolbar.setVisibility(0);
        RelativeLayout relativeLayout3 = (RelativeLayout) c(R.id.fnb_summary_parent_rlt);
        kotlin.g.b.k.a((Object) relativeLayout3, "fnb_summary_parent_rlt");
        relativeLayout3.setVisibility(8);
        View c2 = c(R.id.id_toolbar_separator);
        kotlin.g.b.k.a((Object) c2, "id_toolbar_separator");
        c2.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        CheckBox checkBox = (CheckBox) c(R.id.check_box_fast_forward);
        if (checkBox != null && checkBox.isChecked()) {
            LinearLayout linearLayout = (LinearLayout) c(R.id.tooltipLl);
            if (linearLayout == null) {
                kotlin.g.b.k.a();
            }
            linearLayout.setVisibility(0);
            ImageView imageView = (ImageView) c(R.id.crossIconIv);
            if (imageView == null) {
                kotlin.g.b.k.a();
            }
            imageView.setOnClickListener(new at(this));
            new Handler().postDelayed(new au(this), 3200);
        }
    }

    static final class at implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75735a;

        at(AJROrderReview aJROrderReview) {
            this.f75735a = aJROrderReview;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "v");
            LinearLayout linearLayout = (LinearLayout) this.f75735a.c(R.id.tooltipLl);
            if (linearLayout == null) {
                kotlin.g.b.k.a();
            }
            linearLayout.setVisibility(8);
        }
    }

    static final class au implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75736a;

        au(AJROrderReview aJROrderReview) {
            this.f75736a = aJROrderReview;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f75736a.c(R.id.tooltipLl);
            if (linearLayout == null) {
                kotlin.g.b.k.a();
            }
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        double j2 = j();
        double d2 = this.l;
        double d3 = j2 - d2;
        if (d2 <= 0.0d || d3 <= 0.0d) {
            RelativeLayout relativeLayout = (RelativeLayout) c(R.id.promo_effective_price_rlt);
            kotlin.g.b.k.a((Object) relativeLayout, "promo_effective_price_rlt");
            relativeLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) c(R.id.promo_effective_price_rlt);
        kotlin.g.b.k.a((Object) relativeLayout2, "promo_effective_price_rlt");
        relativeLayout2.setVisibility(0);
        RoboTextView roboTextView = (RoboTextView) c(R.id.promo_effective_price_rtv);
        kotlin.g.b.k.a((Object) roboTextView, "promo_effective_price_rtv");
        roboTextView.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(d3));
    }

    static final class aa implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75713a;

        aa(AJROrderReview aJROrderReview) {
            this.f75713a = aJROrderReview;
        }

        public final void onClick(View view) {
            AJROrderReview.u(this.f75713a);
        }
    }

    static final class x implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75760a;

        x(AJROrderReview aJROrderReview) {
            this.f75760a = aJROrderReview;
        }

        public final void onClick(View view) {
            AJROrderReview.v(this.f75760a);
        }
    }

    static final class y implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75761a;

        y(AJROrderReview aJROrderReview) {
            this.f75761a = aJROrderReview;
        }

        public final void onClick(View view) {
            AJROrderReview.u(this.f75761a);
            AJROrderReview.w(this.f75761a);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "CheckOut Screen");
            String str2 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str2, str);
            String str3 = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str4 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str3, str4);
            Map map = hashMap;
            String str5 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            StringBuilder sb = new StringBuilder();
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|");
            CJRMovies cJRMovies2 = this.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            map.put(str5, sb.toString());
            String str6 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            hashMap.put(str6, "Entertainment - Movies");
            if (com.paytm.utility.b.r((Context) this)) {
                String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) this);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str7, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CJRSetSeat cJRSetSeat) {
        CJRSetSeatItems items;
        if (!(cJRSetSeat == null || (items = cJRSetSeat.getItems()) == null)) {
            ArrayList<net.one97.paytm.o2o.movies.common.movies.booking.a> arrayList = items.get_3dglasses();
            if (!(arrayList == null || arrayList.size() <= 0 || arrayList.get(0) == null)) {
                try {
                    net.one97.paytm.o2o.movies.common.movies.booking.a aVar = arrayList.get(0);
                    ArrayList<net.one97.paytm.o2o.movies.common.movies.booking.c> rules = cJRSetSeat.getRules();
                    kotlin.g.b.k.a((Object) rules, "rules");
                    int size = rules.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        net.one97.paytm.o2o.movies.common.movies.booking.c cVar = rules.get(i2);
                        if (kotlin.m.p.a("3dglasses", cVar.f75144a, true) && kotlin.m.p.a("v1", cVar.f75145b, true) && aVar != null && aVar.f75140b != null) {
                            RoboTextView roboTextView = (RoboTextView) c(R.id.tickets_3d_glass_subinfo_tv);
                            kotlin.g.b.k.a((Object) roboTextView, "tickets_3d_glass_subinfo_tv");
                            roboTextView.setVisibility(0);
                            RoboTextView roboTextView2 = (RoboTextView) c(R.id.tickets_3d_glass_subinfo_price_tv);
                            kotlin.g.b.k.a((Object) roboTextView2, "tickets_3d_glass_subinfo_price_tv");
                            roboTextView2.setVisibility(0);
                            RoboTextView roboTextView3 = (RoboTextView) c(R.id.tickets_3d_glass_subinfo_tv);
                            kotlin.g.b.k.a((Object) roboTextView3, "tickets_3d_glass_subinfo_tv");
                            roboTextView3.setText(getString(R.string._3dglassLabel) + getResources().getString(R.string.rupee_symbol) + aVar.f75140b + getResources().getString(R.string.per_ticket));
                            this.L = aVar.f75140b.floatValue() * ((float) this.f75710g);
                            RoboTextView roboTextView4 = (RoboTextView) c(R.id.tickets_3d_glass_subinfo_price_tv);
                            kotlin.g.b.k.a((Object) roboTextView4, "tickets_3d_glass_subinfo_price_tv");
                            roboTextView4.setText(getResources().getString(R.string.rupee_symbol) + net.one97.paytm.o2o.movies.utils.n.a((double) this.L));
                            this.j.setGlassPrice((double) this.L);
                            d();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            RoboTextView roboTextView5 = (RoboTextView) c(R.id.tickets_3d_glass_subinfo_tv);
            kotlin.g.b.k.a((Object) roboTextView5, "tickets_3d_glass_subinfo_tv");
            roboTextView5.setVisibility(8);
            RoboTextView roboTextView6 = (RoboTextView) c(R.id.tickets_3d_glass_subinfo_price_tv);
            kotlin.g.b.k.a((Object) roboTextView6, "tickets_3d_glass_subinfo_price_tv");
            roboTextView6.setVisibility(8);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public final double j() {
        return ((this.j.getSeatPrice() + 0.0d) - this.j.getPromoDiscount()) + this.j.getFnbPrice() + this.j.getGlassPrice() + this.j.getCpPrice() + this.j.getConvFee();
    }

    /* access modifiers changed from: package-private */
    public final void a(ArrayList<String> arrayList) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            if (arrayList.size() == 1) {
                sb.append(arrayList.get(0));
                sb.append(" is out of stock.");
            } else {
                sb.append(arrayList.get(0));
                int size = arrayList.size() - 1;
                for (int i2 = 1; i2 < size; i2++) {
                    sb.append(", ");
                    sb.append(arrayList.get(i2));
                }
                sb.append(" and ");
                sb.append(arrayList.get(size));
                sb.append(" are out of stock.");
            }
            sb.append(" Please add another item.");
            String sb2 = sb.toString();
            kotlin.g.b.k.a((Object) sb2, "message.toString()");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(sb2);
            builder.setPositiveButton(getResources().getString(R.string.proceed_to_pay), new ap(this));
            builder.setNegativeButton(R.string.review_fnb_order, new aq(this));
            builder.setCancelable(false);
            builder.show();
        }
    }

    static final class ap implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75730a;

        ap(AJROrderReview aJROrderReview) {
            this.f75730a = aJROrderReview;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            net.one97.paytm.o2o.movies.b.b n = this.f75730a.R;
            if (n != null) {
                n.b(false);
            }
        }
    }

    static final class aq implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75731a;

        aq(AJROrderReview aJROrderReview) {
            this.f75731a = aJROrderReview;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f75731a.l();
        }
    }

    static final class ar implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75732a;

        ar(AJROrderReview aJROrderReview) {
            this.f75732a = aJROrderReview;
        }

        public final void onClick(View view) {
            if (com.paytm.utility.b.c((Context) this.f75732a)) {
                this.f75732a.p();
            } else {
                try {
                    net.one97.paytm.o2o.movies.utils.p.a(this.f75732a, this.f75732a.getResources().getString(R.string.network_error_heading), this.f75732a.getResources().getString(R.string.network_error_message), AnonymousClass1.f75733a);
                } catch (Exception e2) {
                    com.paytm.utility.q.d(e2.getMessage());
                }
            }
            this.f75732a.t();
        }
    }

    public final void k() {
        net.one97.paytm.o2o.movies.b.b bVar = this.R;
        if (bVar != null) {
            bVar.d();
        }
    }

    public final void a(CJRCPSelectionItem cJRCPSelectionItem) {
        String str;
        kotlin.g.b.k.c(cJRCPSelectionItem, "cpSelectionItem");
        RoboTextView roboTextView = (RoboTextView) c(R.id.cp_title_rtv);
        kotlin.g.b.k.a((Object) roboTextView, "cp_title_rtv");
        roboTextView.setText(cJRCPSelectionItem.getTitle());
        RoboTextView roboTextView2 = (RoboTextView) c(R.id.cp_info_rtv);
        kotlin.g.b.k.a((Object) roboTextView2, "cp_info_rtv");
        roboTextView2.setText(cJRCPSelectionItem.getSmallDesc());
        String type = cJRCPSelectionItem.getType();
        if (type == null) {
            str = null;
        } else if (type != null) {
            str = kotlin.m.p.b(type).toString();
        } else {
            throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (kotlin.m.p.a(str, "paytm_cp", true)) {
            String price = cJRCPSelectionItem.getPrice();
            if (price != null) {
                RoboTextView roboTextView3 = (RoboTextView) c(R.id.cp_price_rtv);
                kotlin.g.b.k.a((Object) roboTextView3, "cp_price_rtv");
                roboTextView3.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.x(price));
            }
            RoboTextView roboTextView4 = (RoboTextView) c(R.id.cp_upgrade_change_rtv);
            kotlin.g.b.k.a((Object) roboTextView4, "cp_upgrade_change_rtv");
            roboTextView4.setText(getString(R.string.cp_change));
            ((RoboTextView) c(R.id.cp_upgrade_change_rtv)).setTextColor(Color.parseColor("#ffad00"));
            b(true);
            a("Paytm Cancellation Protection");
            return;
        }
        RoboTextView roboTextView5 = (RoboTextView) c(R.id.cp_upgrade_change_rtv);
        kotlin.g.b.k.a((Object) roboTextView5, "cp_upgrade_change_rtv");
        roboTextView5.setText(getString(R.string.cp_upgrade));
        ((RoboTextView) c(R.id.cp_upgrade_change_rtv)).setTextColor(Color.parseColor("#00baf2"));
        b(false);
        String price2 = cJRCPSelectionItem.getPrice();
        if (price2 != null) {
            if (price2 == null) {
                throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (kotlin.m.p.a(kotlin.m.p.b(price2).toString(), "0", true)) {
                RoboTextView roboTextView6 = (RoboTextView) c(R.id.cp_price_rtv);
                kotlin.g.b.k.a((Object) roboTextView6, "cp_price_rtv");
                roboTextView6.setText(getString(R.string.free));
            }
        }
        a("No Protection");
    }

    public final void a() {
        this.P = true;
    }

    public final void b() {
        this.P = false;
        if (!this.f75711h && m() && this.Q) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.movie_alert_title));
            builder.setMessage(getResources().getString(R.string.movie_Error_no_insurance_promo));
            builder.setPositiveButton(getResources().getString(R.string.ok), new ai(this));
            builder.setNegativeButton(getResources().getString(R.string.cancel), new aj(this));
            builder.show();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public final void l() {
        ProgressDialog progressDialog = this.v;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        ProgressBar progressBar = (ProgressBar) c(R.id.loading);
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    private final void a(ArrayList<CJRFoodBeverageItemV2> arrayList, boolean z2) {
        int i2;
        try {
            Map hashMap = new HashMap();
            String str = this.f75708e;
            if (str == null) {
                kotlin.g.b.k.a("mCitySearched");
            }
            hashMap.put("city_name", str);
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
            kotlin.g.b.k.a((Object) instance, "calendar");
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            instance.setTime(cJRMoviesSession.getRealDateTime());
            String valueOf = String.valueOf(instance.get(5));
            Object obj = "quantity";
            Object obj2 = "variant";
            String str2 = "mSelectedMoviesSession.getScreenFormat()";
            String displayName = instance.getDisplayName(7, 0, Locale.getDefault());
            hashMap.put("day_date", displayName + ' ' + valueOf);
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaName = cJRMoviesSession2.getCinemaName();
            kotlin.g.b.k.a((Object) cinemaName, "mSelectedMoviesSession.getCinemaName()");
            hashMap.put("theatre_name", cinemaName);
            CJRMoviesSession cJRMoviesSession3 = this.f75705b;
            if (cJRMoviesSession3 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String c2 = net.one97.paytm.o2o.movies.utils.n.c(cJRMoviesSession3.getRealShowDateTime());
            kotlin.g.b.k.a((Object) c2, "CJRMoviesUtility.getForm…on.getRealShowDateTime())");
            hashMap.put("show_time", c2);
            Map hashMap2 = new HashMap();
            Map hashMap3 = new HashMap();
            List arrayList2 = new ArrayList();
            Map hashMap4 = new HashMap();
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String title = cJRMovies.getTitle();
            kotlin.g.b.k.a((Object) title, "mSelectedMovie.title");
            hashMap4.put("name", title);
            CJRMoviesSession cJRMoviesSession4 = this.f75705b;
            if (cJRMoviesSession4 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String movieCode = cJRMoviesSession4.getMovieCode();
            Map map = hashMap;
            kotlin.g.b.k.a((Object) movieCode, "mSelectedMoviesSession.movieCode");
            hashMap4.put("id", movieCode);
            hashMap4.put("price", 0);
            CJRMoviesSession cJRMoviesSession5 = this.f75705b;
            if (cJRMoviesSession5 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaName2 = cJRMoviesSession5.getCinemaName();
            kotlin.g.b.k.a((Object) cinemaName2, "mSelectedMoviesSession.getCinemaName()");
            hashMap4.put("category", cinemaName2);
            String str3 = this.f75708e;
            if (str3 == null) {
                kotlin.g.b.k.a("mCitySearched");
            }
            hashMap4.put(CLPConstants.BRAND_PARAMS, str3);
            CJRMoviesSession cJRMoviesSession6 = this.f75705b;
            if (cJRMoviesSession6 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String screenFormat = cJRMoviesSession6.getScreenFormat();
            String str4 = str2;
            kotlin.g.b.k.a((Object) screenFormat, str4);
            Map map2 = hashMap2;
            Object obj3 = obj2;
            hashMap4.put(obj3, screenFormat);
            Map map3 = hashMap3;
            hashMap4.put(CLPConstants.ARGUMENT_KEY_POSITION, 1);
            Object obj4 = obj;
            hashMap4.put(obj4, 1);
            arrayList2.add(hashMap4);
            Map hashMap5 = new HashMap();
            CJRMoviesSession cJRMoviesSession7 = this.f75705b;
            if (cJRMoviesSession7 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaName3 = cJRMoviesSession7.getCinemaName();
            kotlin.g.b.k.a((Object) cinemaName3, "mSelectedMoviesSession.getCinemaName()");
            hashMap5.put("name", cinemaName3);
            CJRMoviesSession cJRMoviesSession8 = this.f75705b;
            if (cJRMoviesSession8 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String cinemaID = cJRMoviesSession8.getCinemaID();
            kotlin.g.b.k.a((Object) cinemaID, "mSelectedMoviesSession.getCinemaID()");
            hashMap5.put("id", cinemaID);
            int i3 = 0;
            hashMap5.put("price", 0);
            CJRMovies cJRMovies2 = this.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            String title2 = cJRMovies2.getTitle();
            kotlin.g.b.k.a((Object) title2, "mSelectedMovie.title");
            hashMap5.put("category", title2);
            String str5 = this.f75708e;
            if (str5 == null) {
                kotlin.g.b.k.a("mCitySearched");
            }
            hashMap5.put(CLPConstants.BRAND_PARAMS, str5);
            CJRMoviesSession cJRMoviesSession9 = this.f75705b;
            if (cJRMoviesSession9 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            String screenFormat2 = cJRMoviesSession9.getScreenFormat();
            kotlin.g.b.k.a((Object) screenFormat2, str4);
            hashMap5.put(obj3, screenFormat2);
            hashMap5.put(CLPConstants.ARGUMENT_KEY_POSITION, 1);
            hashMap5.put(obj4, Integer.valueOf(this.f75710g));
            arrayList2.add(hashMap5);
            Map hashMap6 = new HashMap();
            hashMap6.put("name", "Extra - Add ons");
            if (arrayList != null) {
                Iterator<CJRFoodBeverageItemV2> it2 = arrayList.iterator();
                i2 = 0;
                while (it2.hasNext()) {
                    String str6 = it2.next().getmPrice();
                    kotlin.g.b.k.a((Object) str6, "foodBeverageItem.getmPrice()");
                    i3 += Integer.parseInt(str6);
                    i2++;
                }
            } else {
                i2 = 0;
            }
            hashMap6.put("id", "");
            hashMap6.put("price", Integer.valueOf(i3));
            hashMap6.put(obj4, Integer.valueOf(i2));
            if (z2) {
                hashMap6.put("dimension106", "True");
            } else {
                hashMap6.put("dimension106", "False");
            }
            arrayList2.add(hashMap6);
            Map map4 = map3;
            map4.put("products", arrayList2);
            Map hashMap7 = new HashMap();
            hashMap7.put("step", 2);
            hashMap7.put("option", "Proceed to pay");
            map4.put("actionField", hashMap7);
            Map map5 = map2;
            map5.put("checkout", map4);
            Map map6 = map;
            map6.put("ecommerce", map5);
            net.one97.paytm.o2o.movies.b.a.INSTANCE.setCheckoutDataForPurchaseMap(map6);
            map6.put("vertical_name", "Entertainment - Movies");
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendEnhancedEcommerceEvent("checkout", map6, this);
        } catch (Exception unused) {
        }
    }

    static final class i<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJROrderReview f75746a;

        i(AJROrderReview aJROrderReview) {
            this.f75746a = aJROrderReview;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AJROrderReview aJROrderReview = this.f75746a;
            aJROrderReview.f75712i = null;
            ArrayList<CJRFoodBeverageItemV2> a2 = net.one97.paytm.o2o.movies.utils.g.a().a(true);
            AlertDialog.Builder builder = new AlertDialog.Builder(aJROrderReview);
            builder.setTitle(aJROrderReview.getResources().getString(R.string.movie_alert_title));
            builder.setMessage(aJROrderReview.getResources().getString(R.string.movie_error_get_insurance));
            builder.setPositiveButton(aJROrderReview.getResources().getString(R.string.ok), new an(aJROrderReview, a2));
            builder.setNegativeButton(aJROrderReview.getResources().getString(R.string.cancel), ao.f75729a);
            builder.show();
        }
    }

    public final void b(boolean z2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
            String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str2 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str, str2);
            String str3 = z2 ? "CP_Check" : "CP_Uncheck";
            String str4 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str4, str3);
            Map map = hashMap;
            String str5 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            StringBuilder sb = new StringBuilder();
            CJRMovies cJRMovies = this.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|");
            CJRMovies cJRMovies2 = this.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession = this.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession2 = this.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            map.put(str5, sb.toString());
            String str6 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str7 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str6, str7);
            if (com.paytm.utility.b.r((Context) this)) {
                String str8 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str8, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) this);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str8, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        if (z2) {
            CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect = this.f75712i;
            if (cJRMovieNewCancellationProtect == null) {
                kotlin.g.b.k.a();
            }
            Float totalInsurancePrice = cJRMovieNewCancellationProtect.getTotalInsurancePrice();
            if (totalInsurancePrice == null) {
                kotlin.g.b.k.a();
            }
            this.D = (double) totalInsurancePrice.floatValue();
            this.j.setCpPrice(this.D);
            d();
            if (!this.S) {
                LinearLayout linearLayout = (LinearLayout) c(R.id.cp_tax_info_llt);
                kotlin.g.b.k.a((Object) linearLayout, "cp_tax_info_llt");
                linearLayout.setVisibility(0);
            }
            RoboTextView roboTextView = (RoboTextView) c(R.id.cp_tnc_rtv);
            kotlin.g.b.k.a((Object) roboTextView, "cp_tnc_rtv");
            roboTextView.setVisibility(0);
            this.Q = true;
        } else {
            this.D = 0.0d;
            this.j.setCpPrice(this.D);
            LinearLayout linearLayout2 = (LinearLayout) c(R.id.cp_tax_info_llt);
            kotlin.g.b.k.a((Object) linearLayout2, "cp_tax_info_llt");
            linearLayout2.setVisibility(8);
            RoboTextView roboTextView2 = (RoboTextView) c(R.id.cp_tnc_rtv);
            kotlin.g.b.k.a((Object) roboTextView2, "cp_tnc_rtv");
            roboTextView2.setVisibility(0);
            this.Q = false;
            d();
        }
        i();
    }

    public static final /* synthetic */ void c(AJROrderReview aJROrderReview) {
        CJRConvenienceFee cJRConvenienceFee = aJROrderReview.A;
        if (cJRConvenienceFee == null) {
            try {
                kotlin.g.b.k.a();
            } catch (Exception unused) {
                return;
            }
        }
        ArrayList<CJRTaxInfo> totalTaxList = cJRConvenienceFee.getTotalTaxList();
        double d2 = 0.0d;
        if (totalTaxList != null && totalTaxList.size() > 0) {
            if (((LinearLayout) aJROrderReview.c(R.id.fees_tax_item_llt)) != null) {
                LinearLayout linearLayout = (LinearLayout) aJROrderReview.c(R.id.fees_tax_item_llt);
                if (linearLayout == null) {
                    kotlin.g.b.k.a();
                }
                linearLayout.removeAllViews();
            }
            Iterator<CJRTaxInfo> it2 = totalTaxList.iterator();
            while (it2.hasNext()) {
                CJRTaxInfo next = it2.next();
                kotlin.g.b.k.a((Object) next, "taxInfo");
                if (!TextUtils.isEmpty(next.getLabel()) && !TextUtils.isEmpty(next.getValue())) {
                    if (!TextUtils.isEmpty(next.getKey())) {
                        if (kotlin.m.p.a(next.getKey(), "totalPgCharges", true)) {
                            String value = next.getValue();
                            kotlin.g.b.k.a((Object) value, "taxInfo.value");
                            if (Float.parseFloat(value) == 0.0f) {
                                continue;
                            }
                        }
                    }
                    View inflate = aJROrderReview.getLayoutInflater().inflate(R.layout.order_tax_item, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.txt_label);
                    if (findViewById != null) {
                        TextView textView = (TextView) findViewById;
                        View findViewById2 = inflate.findViewById(R.id.txt_value);
                        if (findViewById2 != null) {
                            textView.setText(next.getLabel());
                            ((TextView) findViewById2).setText(aJROrderReview.getResources().getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.x(next.getValue()));
                            String value2 = next.getValue();
                            kotlin.g.b.k.a((Object) value2, "taxInfo.value");
                            d2 += Double.parseDouble(value2);
                            RoboTextView roboTextView = (RoboTextView) aJROrderReview.c(R.id.fees_total_price_rtv);
                            kotlin.g.b.k.a((Object) roboTextView, "fees_total_price_rtv");
                            roboTextView.setText(aJROrderReview.getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(d2));
                            LinearLayout linearLayout2 = (LinearLayout) aJROrderReview.c(R.id.fees_tax_item_llt);
                            if (linearLayout2 == null) {
                                kotlin.g.b.k.a();
                            }
                            linearLayout2.addView(inflate);
                            aJROrderReview.j.setConvFee(d2);
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                    }
                }
            }
        }
    }

    public static final /* synthetic */ void d(AJROrderReview aJROrderReview) {
        ArrayList<CJRObjSeat> arrayList = aJROrderReview.f75709f;
        if (arrayList == null) {
            kotlin.g.b.k.a("mSelectedSeatList");
        }
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            if (aJROrderReview.j() > 0.0d) {
                aJROrderReview.d();
            }
            aJROrderReview.i();
        }
    }

    public static final /* synthetic */ void a(AJROrderReview aJROrderReview, CJRUserMoviePassModel cJRUserMoviePassModel) {
        if (cJRUserMoviePassModel != null) {
            String heading = cJRUserMoviePassModel.getHeading();
            String promoCode = cJRUserMoviePassModel.getPromoCode();
            CharSequence charSequence = heading;
            if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(promoCode)) {
                RelativeLayout relativeLayout = (RelativeLayout) aJROrderReview.c(R.id.movie_pass_parent_rlt);
                kotlin.g.b.k.a((Object) relativeLayout, "movie_pass_parent_rlt");
                relativeLayout.setVisibility(8);
                return;
            }
            RoboTextView roboTextView = (RoboTextView) aJROrderReview.c(R.id.id_movie_pass_promo_heading);
            kotlin.g.b.k.a((Object) roboTextView, "id_movie_pass_promo_heading");
            roboTextView.setText(charSequence);
            aJROrderReview.I = promoCode;
            RelativeLayout relativeLayout2 = (RelativeLayout) aJROrderReview.c(R.id.movie_pass_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout2, "movie_pass_parent_rlt");
            relativeLayout2.setVisibility(0);
            RelativeLayout relativeLayout3 = (RelativeLayout) aJROrderReview.c(R.id.promo_default_show_all_rlt);
            kotlin.g.b.k.a((Object) relativeLayout3, "promo_default_show_all_rlt");
            relativeLayout3.setVisibility(8);
            RelativeLayout relativeLayout4 = (RelativeLayout) aJROrderReview.c(R.id.promo_code_not_applied_parent_rlt);
            kotlin.g.b.k.a((Object) relativeLayout4, "promo_code_not_applied_parent_rlt");
            relativeLayout4.setVisibility(8);
            RoboTextView roboTextView2 = (RoboTextView) aJROrderReview.c(R.id.id_movie_pass_promo_code);
            kotlin.g.b.k.a((Object) roboTextView2, "id_movie_pass_promo_code");
            StringBuilder sb = new StringBuilder("Promo code : ");
            if (promoCode == null) {
                kotlin.g.b.k.a();
            }
            sb.append(promoCode);
            roboTextView2.setText(sb.toString());
            ((RelativeLayout) aJROrderReview.c(R.id.show_all_movie_pass_rlt)).setOnClickListener(new ar(aJROrderReview));
            return;
        }
        RelativeLayout relativeLayout5 = (RelativeLayout) aJROrderReview.c(R.id.movie_pass_parent_rlt);
        kotlin.g.b.k.a((Object) relativeLayout5, "movie_pass_parent_rlt");
        relativeLayout5.setVisibility(8);
    }

    public static final /* synthetic */ void e(AJROrderReview aJROrderReview) {
        ((RoboTextView) aJROrderReview.c(R.id.promo_apply_btn_rtv)).setOnClickListener(new ac(aJROrderReview));
        ((LinearLayout) aJROrderReview.c(R.id.promo_show_all_ll)).setOnClickListener(new ad(aJROrderReview));
        ((RoboTextView) aJROrderReview.c(R.id.txt_enter_promo)).setOnClickListener(new ae(aJROrderReview));
        ((ImageView) aJROrderReview.c(R.id.promo_remove_btn)).setOnClickListener(new af(aJROrderReview));
    }

    public static final /* synthetic */ void i(AJROrderReview aJROrderReview) {
        if (aJROrderReview.v != null || aJROrderReview.isFinishing()) {
            ProgressDialog progressDialog = aJROrderReview.v;
            if (progressDialog != null && !progressDialog.isShowing()) {
                progressDialog.show();
                return;
            }
            return;
        }
        try {
            ProgressDialog progressDialog2 = new ProgressDialog(aJROrderReview);
            progressDialog2.setIndeterminateDrawable(androidx.core.content.b.a((Context) aJROrderReview, R.drawable.custom_progress_bar_movies));
            progressDialog2.setMessage(aJROrderReview.getResources().getString(R.string.please_wait_progress_msg));
            progressDialog2.setCancelable(false);
            progressDialog2.setCanceledOnTouchOutside(false);
            aJROrderReview.v = progressDialog2;
            ProgressDialog progressDialog3 = aJROrderReview.v;
            if (progressDialog3 != null) {
                progressDialog3.show();
            }
        } catch (Exception | IllegalArgumentException unused) {
        }
    }

    public static final /* synthetic */ void k(AJROrderReview aJROrderReview) {
        RelativeLayout relativeLayout = (RelativeLayout) aJROrderReview.c(R.id.api_failure_rlt);
        kotlin.g.b.k.a((Object) relativeLayout, "api_failure_rlt");
        relativeLayout.setVisibility(0);
        ((RoboTextView) aJROrderReview.c(R.id.api_error_cta_rtv)).setOnClickListener(new d(aJROrderReview));
    }

    public static final /* synthetic */ void c(AJROrderReview aJROrderReview, boolean z2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "CheckOut Screen");
            String str = z2 ? "Show details" : "Hide details";
            String str2 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str2, str);
            String str3 = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str4 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str3, str4);
            Map map = hashMap;
            String str5 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            StringBuilder sb = new StringBuilder();
            CJRMovies cJRMovies = aJROrderReview.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|");
            CJRMovies cJRMovies2 = aJROrderReview.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession = aJROrderReview.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession2 = aJROrderReview.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            map.put(str5, sb.toString());
            String str6 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            hashMap.put(str6, "Entertainment - Movies");
            if (com.paytm.utility.b.r((Context) aJROrderReview)) {
                String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) aJROrderReview);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str7, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aJROrderReview);
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void r(AJROrderReview aJROrderReview) {
        if (com.paytm.utility.b.c((Context) aJROrderReview)) {
            aJROrderReview.p();
        } else {
            try {
                net.one97.paytm.o2o.movies.utils.p.a(aJROrderReview, aJROrderReview.getResources().getString(R.string.network_error_heading), aJROrderReview.getResources().getString(R.string.network_error_message), v.f75759a);
            } catch (Exception e2) {
                com.paytm.utility.q.d(e2.getMessage());
            }
        }
        aJROrderReview.t();
    }

    public static final /* synthetic */ void u(AJROrderReview aJROrderReview) {
        CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect;
        CJRCPTermsAndCond termsAndSlab;
        if (!aJROrderReview.isFinishing() && (cJRMovieNewCancellationProtect = aJROrderReview.f75712i) != null && (termsAndSlab = cJRMovieNewCancellationProtect.getTermsAndSlab()) != null) {
            CPSlabAndTncBS cPSlabAndTncBS = aJROrderReview.N;
            if (cPSlabAndTncBS != null) {
                cPSlabAndTncBS.f76195a.dismiss();
            }
            aJROrderReview.N = new CPSlabAndTncBS(aJROrderReview, termsAndSlab);
            CPSlabAndTncBS cPSlabAndTncBS2 = aJROrderReview.N;
            if (cPSlabAndTncBS2 != null) {
                cPSlabAndTncBS2.f76195a.show();
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Movie Tickets - Checkout Screen");
                String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
                kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
                String str2 = net.one97.paytm.o2o.movies.common.b.b.B;
                kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
                hashMap.put(str, str2);
                String str3 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
                kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
                hashMap.put(str3, "CP TnC Clicked");
                Map map = hashMap;
                String str4 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
                kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
                StringBuilder sb = new StringBuilder();
                CJRMovies cJRMovies = aJROrderReview.f75706c;
                if (cJRMovies == null) {
                    kotlin.g.b.k.a("mSelectedMovie");
                }
                sb.append(cJRMovies.getTitle());
                sb.append("|");
                CJRMovies cJRMovies2 = aJROrderReview.f75706c;
                if (cJRMovies2 == null) {
                    kotlin.g.b.k.a("mSelectedMovie");
                }
                sb.append(cJRMovies2.getCode());
                sb.append("|");
                CJRMoviesSession cJRMoviesSession = aJROrderReview.f75705b;
                if (cJRMoviesSession == null) {
                    kotlin.g.b.k.a("mSelectedMoviesSession");
                }
                sb.append(cJRMoviesSession.getCinemaName());
                sb.append("|");
                CJRMoviesSession cJRMoviesSession2 = aJROrderReview.f75705b;
                if (cJRMoviesSession2 == null) {
                    kotlin.g.b.k.a("mSelectedMoviesSession");
                }
                sb.append(cJRMoviesSession2.getCinemaID());
                map.put(str4, sb.toString());
                String str5 = net.one97.paytm.o2o.movies.common.b.b.p;
                kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
                String str6 = net.one97.paytm.o2o.movies.common.b.b.r;
                kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
                hashMap.put(str5, str6);
                if (com.paytm.utility.b.r((Context) aJROrderReview)) {
                    String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                    kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                    String n2 = com.paytm.utility.b.n((Context) aJROrderReview);
                    kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                    hashMap.put(str7, n2);
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aJROrderReview);
            } catch (Exception unused) {
            }
        }
    }

    public static final /* synthetic */ void v(AJROrderReview aJROrderReview) {
        CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect;
        CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect2;
        if (!aJROrderReview.isFinishing() && (cJRMovieNewCancellationProtect = aJROrderReview.f75712i) != null && cJRMovieNewCancellationProtect.getTermsAndSlab() != null && (cJRMovieNewCancellationProtect2 = aJROrderReview.f75712i) != null && cJRMovieNewCancellationProtect2.getCpUpgrade() != null) {
            CancellationProtectBS cancellationProtectBS = aJROrderReview.O;
            if (cancellationProtectBS != null) {
                cancellationProtectBS.f76195a.dismiss();
            }
            Context context = aJROrderReview;
            CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect3 = aJROrderReview.f75712i;
            CJRCPTermsAndCond cJRCPTermsAndCond = null;
            CJRCPUpgrade cpUpgrade = cJRMovieNewCancellationProtect3 != null ? cJRMovieNewCancellationProtect3.getCpUpgrade() : null;
            CJRMovieNewCancellationProtect cJRMovieNewCancellationProtect4 = aJROrderReview.f75712i;
            if (cJRMovieNewCancellationProtect4 != null) {
                cJRCPTermsAndCond = cJRMovieNewCancellationProtect4.getTermsAndSlab();
            }
            aJROrderReview.O = new CancellationProtectBS(context, cpUpgrade, cJRCPTermsAndCond, aJROrderReview);
            CancellationProtectBS cancellationProtectBS2 = aJROrderReview.O;
            if (cancellationProtectBS2 != null) {
                cancellationProtectBS2.f76195a.show();
            }
        }
    }

    public static final /* synthetic */ void w(AJROrderReview aJROrderReview) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/review");
            String str = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            String str2 = net.one97.paytm.o2o.movies.common.b.b.B;
            kotlin.g.b.k.a((Object) str2, "CJRMoviesGTMConstants\n  …UE_MOVIE_TICKETS_CHECKOUT");
            hashMap.put(str, str2);
            String str3 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str3, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            hashMap.put(str3, "CP TnC Clicked");
            Map map = hashMap;
            String str4 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            StringBuilder sb = new StringBuilder();
            CJRMovies cJRMovies = aJROrderReview.f75706c;
            if (cJRMovies == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies.getTitle());
            sb.append("|");
            CJRMovies cJRMovies2 = aJROrderReview.f75706c;
            if (cJRMovies2 == null) {
                kotlin.g.b.k.a("mSelectedMovie");
            }
            sb.append(cJRMovies2.getCode());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession = aJROrderReview.f75705b;
            if (cJRMoviesSession == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession.getCinemaName());
            sb.append("|");
            CJRMoviesSession cJRMoviesSession2 = aJROrderReview.f75705b;
            if (cJRMoviesSession2 == null) {
                kotlin.g.b.k.a("mSelectedMoviesSession");
            }
            sb.append(cJRMoviesSession2.getCinemaID());
            map.put(str4, sb.toString());
            String str5 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str6 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str5, str6);
            if (com.paytm.utility.b.r((Context) aJROrderReview)) {
                String str7 = net.one97.paytm.o2o.movies.common.b.b.q;
                kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_USER_ID");
                String n2 = com.paytm.utility.b.n((Context) aJROrderReview);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put(str7, n2);
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aJROrderReview);
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }
}
