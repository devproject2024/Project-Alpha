package net.one97.paytm.o2o.movies.moviepass.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.paytm.network.b.g;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemInstructionModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AppBaseActivity;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassFaqInstructionModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew;
import net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView;
import net.one97.paytm.o2o.movies.d.e;
import net.one97.paytm.o2o.movies.entity.CJRMovieOfferCode;
import net.one97.paytm.o2o.movies.entity.CJRMovieOffers;
import net.one97.paytm.o2o.movies.moviepass.b.a;
import net.one97.paytm.o2o.movies.moviepass.b.b;
import net.one97.paytm.o2o.movies.moviepass.d;
import net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassCardView;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.utils.p;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRMoviePassDetailActivity extends AppBaseActivity implements View.OnClickListener, a.C1491a, b.a {
    private RoboTextView A;
    private double B = 0.0d;
    private View C;
    private TextView D;
    private TextView E;
    private CJRMovieOffers F;

    /* renamed from: a  reason: collision with root package name */
    private ImageView f75445a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f75446b;

    /* renamed from: c  reason: collision with root package name */
    private CJRExpandableTncView f75447c;

    /* renamed from: d  reason: collision with root package name */
    private CJRMoviePassModelNew f75448d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.o2o.movies.moviepass.f.a f75449e;

    /* renamed from: f  reason: collision with root package name */
    private CJRMoviePassCardView f75450f;

    /* renamed from: g  reason: collision with root package name */
    private CJRSelectCityModel f75451g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, CJRMoviePassTncInstructionModel> f75452h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f75453i;
    private TextView j;
    private LinearLayout k;
    private LinearLayout l;
    private Map<String, CJRMoviePassFaqInstructionModel> m;
    private Map<String, CJRMoviePassRedeemInstructionModel> n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private String r = null;
    private net.one97.paytm.o2o.movies.moviepass.c.a s;
    private ProgressDialog t;
    private ArrayList<CJRMovieOfferCode> u;
    private FrameLayout v;
    private RoboTextView w;
    private RoboTextView x;
    private View y;
    private RoboTextView z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void o() {
    }

    public final Activity e() {
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x027e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onCreate(r8)
            int r8 = net.one97.paytm.o2o.movies.R.layout.activity_ajrmovie_pass_detail
            r7.setContentView((int) r8)
            int r8 = net.one97.paytm.o2o.movies.R.id.back_button
            android.view.View r8 = r7.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.f75445a = r8
            android.widget.ImageView r8 = r7.f75445a
            r8.setOnClickListener(r7)
            int r8 = net.one97.paytm.o2o.movies.R.id.show_pass_in_text
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.f75453i = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.city_name_text
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.f75446b = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.tnc_view
            android.view.View r8 = r7.findViewById(r8)
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r8 = (net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView) r8
            r7.f75447c = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.tnc_lin_lay
            android.view.View r8 = r7.findViewById(r8)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r7.l = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.card_detail_view
            android.view.View r8 = r7.findViewById(r8)
            net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassCardView r8 = (net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassCardView) r8
            r7.f75450f = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.ll_proceed_to_pay
            android.view.View r8 = r7.findViewById(r8)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r7.k = r8
            android.widget.LinearLayout r8 = r7.k
            r8.setOnClickListener(r7)
            int r8 = net.one97.paytm.o2o.movies.R.id.mp_proceed_to_pay_btn
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.j = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.summary_lin_lay
            android.view.View r8 = r7.findViewById(r8)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r7.q = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.summary_head
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.p = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.summary_data
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.o = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.promocode_data_layout
            android.view.View r8 = r7.findViewById(r8)
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            r7.v = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.offer_code_text_view
            android.view.View r8 = r7.findViewById(r8)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            r7.w = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.offer_desc_text_view
            android.view.View r8 = r7.findViewById(r8)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            r7.x = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.id_add_item
            android.view.View r8 = r7.findViewById(r8)
            r7.y = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.promocodes_bank_offers
            android.view.View r8 = r7.findViewById(r8)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            r7.A = r8
            com.paytm.utility.RoboTextView r8 = r7.A
            r8.setOnClickListener(r7)
            int r8 = net.one97.paytm.o2o.movies.R.id.lyt_promo_applied
            android.view.View r8 = r7.findViewById(r8)
            r7.C = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.txt_proceed_to_pay_promo
            android.view.View r8 = r7.findViewById(r8)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            r7.z = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.txt_cash_back_remove
            android.view.View r8 = r7.findViewById(r8)
            r8.setOnClickListener(r7)
            int r8 = net.one97.paytm.o2o.movies.R.id.tvStartingDate
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.D = r8
            int r8 = net.one97.paytm.o2o.movies.R.id.tvEndingDate
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.E = r8
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r0 = "movie_pass_object"
            java.io.Serializable r0 = r8.getSerializableExtra(r0)
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r0 = (net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew) r0
            r7.f75448d = r0
            java.lang.String r0 = "userselectedcity"
            android.os.Parcelable r0 = r8.getParcelableExtra(r0)
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = (net.one97.paytm.common.entity.CJRSelectCityModel) r0
            r7.f75451g = r0
            java.lang.String r0 = "mp_tnc_instructions"
            java.io.Serializable r0 = r8.getSerializableExtra(r0)
            java.util.Map r0 = (java.util.Map) r0
            r7.f75452h = r0
            java.lang.String r0 = "mp_faq_instructions"
            java.io.Serializable r0 = r8.getSerializableExtra(r0)
            java.util.Map r0 = (java.util.Map) r0
            r7.m = r0
            java.lang.String r0 = "mp_redeem_instructions"
            java.io.Serializable r0 = r8.getSerializableExtra(r0)
            java.util.Map r0 = (java.util.Map) r0
            r7.n = r0
            java.lang.String r0 = "mp_current_date"
            java.lang.String r8 = r8.getStringExtra(r0)
            r7.r = r8
            net.one97.paytm.o2o.movies.moviepass.f.a r8 = new net.one97.paytm.o2o.movies.moviepass.f.a
            r8.<init>(r7)
            r7.f75449e = r8
            net.one97.paytm.o2o.movies.moviepass.f.a r8 = r7.f75449e
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r7.f75451g
            java.lang.String r0 = r0.getLabel()
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r1 = r7.f75448d
            java.util.Map<java.lang.String, net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassFaqInstructionModel> r2 = r7.m
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemInstructionModel> r3 = r7.n
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel> r4 = r7.f75452h
            r8.f75600c = r0
            r8.f75601d = r1
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r8.f75599b = r0
            if (r2 == 0) goto L_0x015f
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassBaseInstructionClass> r0 = r8.f75599b     // Catch:{ Exception -> 0x015d }
            java.lang.Object r5 = r1.getFAQ()     // Catch:{ Exception -> 0x015d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x015d }
            java.lang.Object r6 = r1.getFAQ()     // Catch:{ Exception -> 0x015d }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ Exception -> 0x015d }
            r0.put(r5, r2)     // Catch:{ Exception -> 0x015d }
            goto L_0x015f
        L_0x015d:
            goto L_0x018d
        L_0x015f:
            if (r4 == 0) goto L_0x0176
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassBaseInstructionClass> r0 = r8.f75599b     // Catch:{ Exception -> 0x015d }
            java.lang.Object r2 = r1.getTnc()     // Catch:{ Exception -> 0x015d }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x015d }
            java.lang.Object r5 = r1.getTnc()     // Catch:{ Exception -> 0x015d }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x015d }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x015d }
        L_0x0176:
            if (r3 == 0) goto L_0x018d
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassBaseInstructionClass> r8 = r8.f75599b     // Catch:{ Exception -> 0x015d }
            java.lang.Object r0 = r1.getRedeemSteps()     // Catch:{ Exception -> 0x015d }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x015d }
            java.lang.Object r1 = r1.getRedeemSteps()     // Catch:{ Exception -> 0x015d }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ Exception -> 0x015d }
            r8.put(r0, r1)     // Catch:{ Exception -> 0x015d }
        L_0x018d:
            android.widget.TextView r8 = r7.f75453i
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r0 = r7.f75448d
            java.lang.String r0 = r0.getHeading()
            r8.setText(r0)
            android.widget.TextView r8 = r7.f75446b
            net.one97.paytm.o2o.movies.utils.h r0 = net.one97.paytm.o2o.movies.utils.h.f75928a
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r7.f75451g
            java.lang.String r0 = net.one97.paytm.o2o.movies.utils.h.a((net.one97.paytm.common.entity.CJRSelectCityModel) r0)
            r8.setText(r0)
            net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassCardView r8 = r7.f75450f
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r0 = r7.f75448d
            r1 = 1
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCardWidgetModel r0 = net.one97.paytm.o2o.movies.utils.n.a((net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew) r0, (boolean) r1, (android.content.Context) r7)
            r8.setData(r0)
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r8 = r7.f75448d
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassGeneralDetail r8 = r8.getGeneral()
            r0 = 0
            r2 = 8
            if (r8 == 0) goto L_0x0200
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r8 = r7.f75448d
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassGeneralDetail r8 = r8.getGeneral()
            java.lang.String r8 = r8.getHeading()
            boolean r8 = com.paytm.utility.v.a((java.lang.String) r8)
            if (r8 != 0) goto L_0x0200
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r8 = r7.f75448d
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassGeneralDetail r8 = r8.getGeneral()
            java.lang.String r8 = r8.getSynopsis()
            boolean r8 = com.paytm.utility.v.a((java.lang.String) r8)
            if (r8 != 0) goto L_0x0200
            android.widget.LinearLayout r8 = r7.q
            r8.setVisibility(r0)
            android.widget.TextView r8 = r7.p
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r3 = r7.f75448d
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassGeneralDetail r3 = r3.getGeneral()
            java.lang.String r3 = r3.getHeading()
            r8.setText(r3)
            android.widget.TextView r8 = r7.o
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r3 = r7.f75448d
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassGeneralDetail r3 = r3.getGeneral()
            java.lang.String r3 = r3.getSynopsis()
            r8.setText(r3)
            goto L_0x0205
        L_0x0200:
            android.widget.LinearLayout r8 = r7.q
            r8.setVisibility(r2)
        L_0x0205:
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r8 = r7.f75448d
            java.lang.Object r8 = r8.getTnc()
            if (r8 == 0) goto L_0x0271
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r8 = r7.f75448d
            java.lang.Object r8 = r8.getTnc()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            boolean r8 = com.paytm.utility.v.a((java.lang.String) r8)
            if (r8 != 0) goto L_0x0271
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r8 = r7.f75447c
            r8.setVisibility(r0)
            android.widget.LinearLayout r8 = r7.l
            r8.setVisibility(r0)
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel> r8 = r7.f75452h
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r3 = r7.f75448d
            java.lang.Object r3 = r3.getTnc()
            java.lang.Object r8 = r8.get(r3)
            if (r8 != 0) goto L_0x0241
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r8 = r7.f75447c
            r8.setVisibility(r2)
            android.widget.LinearLayout r8 = r7.l
            r8.setVisibility(r2)
            r8 = 1
            goto L_0x027c
        L_0x0241:
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r8 = r7.f75447c
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel> r2 = r7.f75452h
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r3 = r7.f75448d
            java.lang.Object r3 = r3.getTnc()
            java.lang.Object r2 = r2.get(r3)
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel r2 = (net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel) r2
            java.lang.String r2 = r2.getHeading()
            r3 = 6
            r8.setTitle(r2, r3)
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r8 = r7.f75447c
            java.util.Map<java.lang.String, net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel> r2 = r7.f75452h
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r3 = r7.f75448d
            java.lang.Object r3 = r3.getTnc()
            java.lang.Object r2 = r2.get(r3)
            net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel r2 = (net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel) r2
            java.util.List r2 = r2.getInstructionsData()
            r8.setDescription(r2)
            goto L_0x027b
        L_0x0271:
            net.one97.paytm.o2o.movies.common.widgets.CJRExpandableTncView r8 = r7.f75447c
            r8.setVisibility(r2)
            android.widget.LinearLayout r8 = r7.l
            r8.setVisibility(r2)
        L_0x027b:
            r8 = 0
        L_0x027c:
            if (r8 != 0) goto L_0x02d8
            java.lang.String r8 = r7.r
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 != 0) goto L_0x02ab
            java.lang.String r2 = r7.r     // Catch:{ Exception -> 0x02ab }
            java.util.Date r2 = net.one97.paytm.o2o.movies.common.d.c((java.lang.String) r2)     // Catch:{ Exception -> 0x02ab }
            int r3 = r2.getYear()     // Catch:{ Exception -> 0x02ab }
            int r3 = r3 + 1900
            int r4 = r2.getMonth()     // Catch:{ Exception -> 0x02ab }
            int r2 = r2.getDate()     // Catch:{ Exception -> 0x02ab }
            int r4 = r4 + r1
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.d.a((int) r3, (int) r4, (int) r2, (int) r0)     // Catch:{ Exception -> 0x02ab }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r5 = r7.f75448d     // Catch:{ Exception -> 0x02ac }
            int r5 = r5.getValidityDays()     // Catch:{ Exception -> 0x02ac }
            int r5 = r5 - r1
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.d.a((int) r3, (int) r4, (int) r2, (int) r5)     // Catch:{ Exception -> 0x02ac }
            goto L_0x02ac
        L_0x02ab:
            r0 = r8
        L_0x02ac:
            android.widget.TextView r1 = r7.D
            r1.setText(r0)
            android.widget.TextView r0 = r7.E
            r0.setText(r8)
            android.widget.TextView r8 = r7.j
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Buy Pass for "
            r0.<init>(r1)
            int r1 = net.one97.paytm.o2o.movies.R.string.rupee_symbol
            java.lang.String r1 = r7.getString(r1)
            r0.append(r1)
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r1 = r7.f75448d
            java.lang.String r1 = r1.getTotalPrice()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.setText(r0)
        L_0x02d8:
            r7.f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.moviepass.activity.AJRMoviePassDetailActivity.onCreate(android.os.Bundle):void");
    }

    private void f() {
        if (com.paytm.utility.b.r((Context) this)) {
            k();
        }
    }

    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.back_button) {
            onBackPressed();
        } else if (id == R.id.ll_proceed_to_pay) {
            if (n.c((Context) this)) {
                h();
            } else {
                a(321);
            }
        } else if (id == R.id.promocodes_bank_offers) {
            if (!com.paytm.utility.b.c((Context) this)) {
                g();
            } else if (n.c((Context) this)) {
                CJRMovieOffers cJRMovieOffers = this.F;
                if (cJRMovieOffers != null) {
                    if ("gzip".equalsIgnoreCase(cJRMovieOffers.getNetworkResponse().headers.get("Content-Encoding"))) {
                        str = g.a(g.a(this.F.getNetworkResponse().data));
                    } else {
                        str = new String(this.F.getNetworkResponse().data);
                    }
                    d a2 = d.a();
                    double parseDouble = Double.parseDouble(this.f75448d.getTotalPrice());
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getSSOToken(this);
                    a2.f75502a = this.f75449e;
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.openPromoScreen("", this, parseDouble, str, a2, a2);
                    return;
                }
                i();
            } else {
                a(345);
            }
        } else if (id == R.id.txt_cash_back_remove) {
            c.a aVar = new c.a(this);
            aVar.a((CharSequence) getResources().getString(R.string.remove_code_title));
            aVar.b((CharSequence) getResources().getString(R.string.remove_code_msg));
            aVar.a((CharSequence) getResources().getString(R.string.yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRMoviePassDetailActivity.this.b(dialogInterface, i2);
                }
            });
            aVar.b((CharSequence) getResources().getString(R.string.no), (DialogInterface.OnClickListener) $$Lambda$AJRMoviePassDetailActivity$3PajSXaQkwLfIJLElYzbmGE7bE.INSTANCE);
            aVar.b();
        }
    }

    private void g() {
        try {
            p.a(this, getString(R.string.network_error_heading), getString(R.string.network_error_message), $$Lambda$AJRMoviePassDetailActivity$JbSlD6bf__h4YjXhbO3whLwvtuE.INSTANCE);
        } catch (Exception unused) {
        }
    }

    private void h() {
        this.s = new net.one97.paytm.o2o.movies.moviepass.c.a();
        Bundle bundle = new Bundle();
        bundle.putString("mp_card_heading", this.f75448d.getHeading());
        bundle.putString("mp_total_price", this.f75448d.getTotalPrice());
        bundle.putString("mp_current_date", this.r);
        this.s.setArguments(bundle);
        this.s.show(getSupportFragmentManager(), "SLIDER_DRAWER");
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().c("faq_fragment_tag") == null && getSupportFragmentManager().c("promo_fragment_tag") == null) {
            finish();
        } else {
            getSupportFragmentManager().d();
        }
    }

    private void a(int i2) {
        startActivityForResult(new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), i2);
    }

    public final void a(String str, String str2, String str3) {
        getSupportFragmentManager().c(R.id.mp_detail_fragment_frame_lay);
        this.A.setVisibility(8);
        this.v.setVisibility(8);
        this.C.setVisibility(0);
        TextView textView = (TextView) this.C.findViewById(R.id.txt_applied_promo_info);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        TextView textView2 = (TextView) this.C.findViewById(R.id.txt_cash_back_info);
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("0")) {
                textView2.setText(getString(R.string.success));
            } else {
                textView2.setText(getString(R.string.rupee_symbol) + str2 + " " + getString(R.string.cashback));
            }
            this.B = Double.parseDouble(str2);
        } else {
            textView2.setText("");
            this.B = 0.0d;
        }
        TextView textView3 = (TextView) this.C.findViewById(R.id.txt_cash_back_desc);
        if (!TextUtils.isEmpty(str3)) {
            textView3.setText(str3);
        } else {
            textView3.setText("");
        }
        j();
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.msg_invalid_recharge_promo_code);
        }
        getSupportFragmentManager().c(R.id.mp_detail_fragment_frame_lay);
        p.a(this, getString(R.string.failure), str);
    }

    public final void a() {
        m();
    }

    public final void a(CJRMovieOffers cJRMovieOffers) {
        this.F = cJRMovieOffers;
        if (cJRMovieOffers == null || cJRMovieOffers.getOfferCodes() == null || cJRMovieOffers.getOfferCodes().size() <= 0) {
            this.v.setVisibility(8);
            return;
        }
        this.v.setVisibility(0);
        this.u = cJRMovieOffers.getOfferCodes();
        l();
    }

    public final void a(CJRMovieCart cJRMovieCart, boolean z2, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        PaytmSDK.setCheckoutCallbackListener(d.a());
        d.a().a((net.one97.paytm.o2o.movies.moviepass.a) this.f75449e);
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.fetchPaymentOptions(this, this.t, cJRMovieCart, otherPayOptionsListener, z2, (net.one97.paytm.o2o.movies.b.g) null);
    }

    public final void a(CJRMovieCart cJRMovieCart, String str, String str2) {
        ArrayList<CJRMovieOfferCode> arrayList = this.u;
        String offerText = (arrayList == null || arrayList.size() <= 0) ? "" : this.u.get(0).getOfferText();
        d a2 = d.a();
        j supportFragmentManager = getSupportFragmentManager();
        double parseDouble = Double.parseDouble(this.f75448d.getTotalPrice());
        a2.f75502a = this.f75449e;
        PromoHelper.Companion.getInstance().setOnPromoActivityDestroyListener(a2);
        cJRMovieCart.getCart();
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
        verifyResponseData.setPromoCode(str);
        verifyResponseData.setIs8DigitBin(d.b(str2));
        verifyResponseData.setOfferText(offerText);
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.openPromoPayOptionsBottomSheet("", this, supportFragmentManager, parseDouble, cJRMovieCart.getCart().getInstruments(), a2, a2, verifyResponseData);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 321) {
                f();
                h();
            } else if (i2 == 123) {
                b();
            } else if (i2 == 345) {
                i();
            }
            androidx.localbroadcastmanager.a.a.a((Context) this).a(new Intent("login_event"));
        }
        if (i2 == 4524) {
            this.f75449e.f75598a = false;
        }
    }

    private void i() {
        net.one97.paytm.o2o.movies.common.b.c.a();
        String replace = net.one97.paytm.o2o.movies.common.b.c.a("moviePromoSearchUrl", (String) null).replace("v1", "v2");
        net.one97.paytm.o2o.movies.common.b.c.a();
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviePromoSearchUrlExtension", (String) null);
        String str = replace + this.f75448d.getProductId() + a2;
        if (URLUtil.isValidUrl(str)) {
            Request request = new Request(0, n.a("price", this.f75448d.getTotalPrice(), com.paytm.utility.c.b(str, (Context) this)), com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), (Context) this), (Map<String, String>) null, (String) null);
            d a3 = d.a();
            double parseDouble = Double.parseDouble(this.f75448d.getTotalPrice());
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getSSOToken(this);
            a3.a(this, parseDouble, request, this.f75449e);
        }
    }

    private void j() {
        Double valueOf = Double.valueOf(Double.parseDouble(this.f75448d.getTotalPrice()) - this.B);
        if (this.B <= 0.0d || valueOf.doubleValue() <= 0.0d) {
            this.z.setVisibility(8);
            return;
        }
        this.z.setVisibility(0);
        this.z.setText(getString(R.string.movie_effective_price) + " " + getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(valueOf.doubleValue()));
    }

    public final void b() {
        this.s.a(false);
        this.f75449e.a(this.f75451g.getLabel(), this.f75448d, this.m, this.n, this.f75452h);
    }

    public final void a(CJRRechargePayment cJRRechargePayment) {
        Intent intent = new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("AJRRechargePaymentActivity"));
        if (!TextUtils.isEmpty(cJRRechargePayment.getmTxnToken())) {
            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
            intent.putExtra("mid", cJRRechargePayment.getMID());
            intent.putExtra("nativeSdkEnabled", true);
        } else {
            intent.putExtra("nativeSdkEnabled", false);
        }
        intent.putExtra(UpiConstants.FROM, "MoviesPage");
        intent.putExtra("is_movie_ticket", true);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        startActivityForResult(intent, 4524);
    }

    public void onStop() {
        super.onStop();
        c();
    }

    public final void c() {
        net.one97.paytm.o2o.movies.moviepass.c.a aVar = this.s;
        if (aVar != null) {
            aVar.a(true);
        }
        ProgressDialog progressDialog = this.t;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.t.dismiss();
        }
    }

    public final void d() {
        net.one97.paytm.o2o.movies.moviepass.c.a aVar = this.s;
        if (aVar != null) {
            aVar.a(false);
        }
        if (this.t == null) {
            this.t = new ProgressDialog(this);
            this.t.setMessage("Please wait...");
            this.t.setIndeterminateDrawable(androidx.core.content.b.a((Context) this, R.drawable.custom_progress_bar_movies));
            this.t.setCancelable(false);
        }
        if (!this.t.isShowing() && !isFinishing()) {
            this.t.show();
        }
    }

    public final void a(String str, String str2, e.b.a aVar) {
        if (v.a(str) || v.a(str2)) {
            com.paytm.utility.b.b((Context) this, "Something is broken!", "Uh Oh! Looks like you can't place the order now. Please try after some time. ");
        } else {
            p.a(this, str, str2, new p.b(aVar) {
                private final /* synthetic */ e.b.a f$1;

                {
                    this.f$1 = r2;
                }

                public final void onDialogDismissed() {
                    AJRMoviePassDetailActivity.this.a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e.b.a aVar) {
        if (aVar == e.b.a.WALLET_TOKEN_API) {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.signOut(this, false, (VolleyError) null);
            a(123);
        }
    }

    private void k() {
        if (com.paytm.utility.b.c((Context) this)) {
            this.f75449e.b(this.f75448d.getProductId());
        }
    }

    private void l() {
        final CJRMovieOfferCode cJRMovieOfferCode = this.u.get(0);
        if (cJRMovieOfferCode != null) {
            if (TextUtils.isEmpty(cJRMovieOfferCode.getTerms()) || cJRMovieOfferCode.getTerms().equalsIgnoreCase("N/A")) {
                this.x.setText(cJRMovieOfferCode.getOfferText());
            } else {
                String obj = Html.fromHtml(cJRMovieOfferCode.getOfferText()).toString();
                SpannableString spannableString = new SpannableString(obj + " *T&Cs");
                AnonymousClass1 r4 = new ClickableSpan() {
                    public final void onClick(View view) {
                        com.paytm.utility.b.b(AJRMoviePassDetailActivity.this, cJRMovieOfferCode.getTermsTitle(), Html.fromHtml(cJRMovieOfferCode.getTerms()).toString(), true);
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(true);
                        textPaint.setColor(androidx.core.content.b.c(AJRMoviePassDetailActivity.this, R.color.paytm_blue));
                    }
                };
                spannableString.setSpan(obj, 0, obj.length(), 33);
                spannableString.setSpan(r4, obj.length() + 1, obj.length() + 6, 33);
                this.x.setText(spannableString);
                this.x.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.w.setText(cJRMovieOfferCode.getCode());
            this.y.setOnClickListener(new View.OnClickListener(cJRMovieOfferCode) {
                private final /* synthetic */ CJRMovieOfferCode f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    AJRMoviePassDetailActivity.this.a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMovieOfferCode cJRMovieOfferCode, View view) {
        this.y.setEnabled(false);
        if (com.paytm.utility.b.c((Context) this)) {
            this.f75449e.a(cJRMovieOfferCode.getCode(), 0, cJRMovieOfferCode.filters, true);
        } else {
            g();
        }
        this.y.postDelayed(new Runnable() {
            public final void run() {
                AJRMoviePassDetailActivity.this.n();
            }
        }, 1500);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n() {
        try {
            this.y.setEnabled(true);
        } catch (Exception unused) {
        }
    }

    private void m() {
        this.B = 0.0d;
        this.f75449e.a();
        this.C.setVisibility(8);
        this.A.setVisibility(0);
        ArrayList<CJRMovieOfferCode> arrayList = this.u;
        if (arrayList != null && arrayList.size() > 0) {
            this.v.setVisibility(0);
            l();
        }
        j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        m();
    }

    public void onResume() {
        super.onResume();
        net.one97.paytm.o2o.movies.moviepass.c.a aVar = this.s;
        if (aVar != null) {
            aVar.a(true);
        }
    }
}
