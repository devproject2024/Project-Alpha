package net.one97.paytm.paymentsBank.chequebook.trackingflow.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.trackingflow.a.a;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.d;
import net.one97.paytm.paymentsBank.utils.o;

public final class CBTLandingView extends ChequeBookBaseActivity implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.C0290a f17922a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f17923b = Boolean.FALSE;

    /* renamed from: c  reason: collision with root package name */
    private a f17924c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f17925d;

    public final View a(int i2) {
        if (this.f17925d == null) {
            this.f17925d = new HashMap();
        }
        View view = (View) this.f17925d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17925d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str) {
        k.c(str, H5Param.PARAM);
    }

    public final void b(String str) {
        k.c(str, H5Param.PARAM);
    }

    public final void b() {
        finish();
    }

    public final a.C0290a d() {
        a.C0290a aVar = this.f17922a;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void a(boolean z, String str, String str2) {
        k.c(str, "orderId");
        k.c(str2, "arrivingDate");
        if (z) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.rl_header_signature_flow);
            k.a((Object) relativeLayout, "rl_header_signature_flow");
            relativeLayout.setVisibility(0);
            ImageView imageView = (ImageView) a(R.id.im_motif);
            k.a((Object) imageView, "im_motif");
            imageView.setVisibility(0);
            View a2 = a(R.id.pb_cb_status_toolbar);
            k.a((Object) a2, "pb_cb_status_toolbar");
            a2.setVisibility(8);
            e();
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_header_signature_flow);
        k.a((Object) relativeLayout2, "rl_header_signature_flow");
        relativeLayout2.setVisibility(8);
        ImageView imageView2 = (ImageView) a(R.id.im_motif);
        k.a((Object) imageView2, "im_motif");
        imageView2.setVisibility(8);
        TextView textView = (TextView) a(R.id.tv_header_title);
        k.a((Object) textView, "tv_header_title");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.tv_header_title);
        k.a((Object) textView2, "tv_header_title");
        textView2.setText(getString(R.string.pb_cheque_book));
        TextView textView3 = (TextView) a(R.id.tv_header_sub_title);
        k.a((Object) textView3, "tv_header_sub_title");
        textView3.setVisibility(0);
        TextView textView4 = (TextView) a(R.id.tv_header_sub_title);
        k.a((Object) textView4, "tv_header_sub_title");
        textView4.setText(getString(R.string.pb_order_no) + " " + str);
        CharSequence charSequence = str2;
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView5 = (TextView) a(R.id.tv_arriving_by);
            k.a((Object) textView5, "tv_arriving_by");
            textView5.setVisibility(8);
            TextView textView6 = (TextView) a(R.id.tv_arriving_date);
            k.a((Object) textView6, "tv_arriving_date");
            textView6.setVisibility(8);
        } else {
            TextView textView7 = (TextView) a(R.id.tv_arriving_by);
            k.a((Object) textView7, "tv_arriving_by");
            textView7.setVisibility(0);
            TextView textView8 = (TextView) a(R.id.tv_arriving_date);
            k.a((Object) textView8, "tv_arriving_date");
            textView8.setText(charSequence);
        }
        View a3 = a(R.id.pb_cb_status_toolbar);
        k.a((Object) a3, "pb_cb_status_toolbar");
        a3.setVisibility(0);
        e();
    }

    public final void c(String str) {
        k.c(str, "leafCount");
        TextView textView = (TextView) a(R.id.tv_no_of_leaves);
        k.a((Object) textView, "tv_no_of_leaves");
        textView.setText(getString(R.string.pb_cb_leaf_cheque_book, new Object[]{str}));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_track_details);
        k.a((Object) recyclerView, "rv_track_details");
        Context context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_track_details);
        k.a((Object) recyclerView2, "rv_track_details");
        recyclerView2.setNestedScrollingEnabled(false);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loader);
        k.a((Object) lottieAnimationView, "loader");
        lottieAnimationView.setVisibility(0);
        ((LottieAnimationView) a(R.id.loader)).setAnimation("Payments-Loader.json");
        ((LottieAnimationView) a(R.id.loader)).loop(true);
        ((LottieAnimationView) a(R.id.loader)).playAnimation();
        d dVar = d.f17950a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        a.C0290a aVar = new net.one97.paytm.paymentsBank.chequebook.trackingflow.b.a(d.a(applicationContext), this, context);
        k.c(aVar, "<set-?>");
        this.f17922a = aVar;
        String stringExtra = getIntent().getStringExtra("order_id_extra");
        if (!TextUtils.isEmpty(stringExtra)) {
            a.C0290a d2 = d();
            k.a((Object) stringExtra, "orderIdFromSummaryPage");
            d2.a(stringExtra);
        }
        this.f17924c = new a(d(), this);
        d().c();
        ((TextView) a(R.id.tv_need_help)).setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBTLandingView f17927a;

        b(CBTLandingView cBTLandingView) {
            this.f17927a = cBTLandingView;
        }

        public final void onClick(View view) {
            this.f17927a.d().e();
        }
    }

    private void e() {
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_track_details);
        k.a((Object) recyclerView, "rv_track_details");
        recyclerView.setVisibility(0);
        TextView textView = (TextView) a(R.id.tv_payments_details_label);
        k.a((Object) textView, "tv_payments_details_label");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a(R.id.tv_sub_title);
        k.a((Object) textView2, "tv_sub_title");
        textView2.setVisibility(0);
        TextView textView3 = (TextView) a(R.id.tv_amount);
        k.a((Object) textView3, "tv_amount");
        textView3.setVisibility(0);
        ImageView imageView = (ImageView) a(R.id.im_forward);
        k.a((Object) imageView, "im_forward");
        imageView.setVisibility(0);
        TextView textView4 = (TextView) a(R.id.tv_need_help);
        k.a((Object) textView4, "tv_need_help");
        textView4.setVisibility(0);
        ImageView imageView2 = (ImageView) a(R.id.im_help_icon);
        k.a((Object) imageView2, "im_help_icon");
        imageView2.setVisibility(0);
        TextView textView5 = (TextView) a(R.id.tv_title);
        k.a((Object) textView5, "tv_title");
        textView5.setVisibility(0);
        View a2 = a(R.id.view_sep);
        k.a((Object) a2, "view_sep");
        a2.setVisibility(0);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loader);
        k.a((Object) lottieAnimationView, "loader");
        lottieAnimationView.setVisibility(8);
        ((ImageView) a(R.id.iv_back)).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBTLandingView f17926a;

        a(CBTLandingView cBTLandingView) {
            this.f17926a = cBTLandingView;
        }

        public final void onClick(View view) {
            this.f17926a.onBackPressed();
        }
    }

    public final void c() {
        a(false);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_track_details);
        k.a((Object) recyclerView, "rv_track_details");
        a aVar = this.f17924c;
        if (aVar == null) {
            k.a("adapter");
        }
        recyclerView.setAdapter(aVar);
    }

    public final void a(boolean z) {
        if (z) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loader);
            k.a((Object) lottieAnimationView, "loader");
            net.one97.paytm.paymentsBank.chequebook.utils.b.a(lottieAnimationView);
            return;
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) a(R.id.loader);
        k.a((Object) lottieAnimationView2, "loader");
        net.one97.paytm.paymentsBank.chequebook.utils.b.b(lottieAnimationView2);
    }

    public final int a() {
        return R.layout.cb_tracking_details_activity;
    }

    public final void a(String str, String str2, String str3) {
        k.c(str, "bankName");
        k.c(str2, "id");
        k.c(str3, "amount");
        TextView textView = (TextView) a(R.id.tv_title);
        k.a((Object) textView, "tv_title");
        textView.setText(getString(R.string.pb_pdc_ppsa));
        TextView textView2 = (TextView) a(R.id.tv_sub_title);
        k.a((Object) textView2, "tv_sub_title");
        textView2.setText(getString(R.string.pb_transaction_id) + " " + str2);
        TextView textView3 = (TextView) a(R.id.tv_amount);
        k.a((Object) textView3, "tv_amount");
        textView3.setText(str3);
        if (TextUtils.isEmpty(str2)) {
            TextView textView4 = (TextView) a(R.id.tv_sub_title);
            k.a((Object) textView4, "tv_sub_title");
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView4);
            TextView textView5 = (TextView) a(R.id.tv_amount);
            k.a((Object) textView5, "tv_amount");
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView5);
            TextView textView6 = (TextView) a(R.id.tv_title);
            k.a((Object) textView6, "tv_title");
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView6);
            TextView textView7 = (TextView) a(R.id.tv_payments_details_label);
            k.a((Object) textView7, "tv_payments_details_label");
            net.one97.paytm.paymentsBank.chequebook.utils.b.b(textView7);
            return;
        }
        TextView textView8 = (TextView) a(R.id.tv_sub_title);
        k.a((Object) textView8, "tv_sub_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView8);
        TextView textView9 = (TextView) a(R.id.tv_amount);
        k.a((Object) textView9, "tv_amount");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView9);
        TextView textView10 = (TextView) a(R.id.tv_title);
        k.a((Object) textView10, "tv_title");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView10);
        TextView textView11 = (TextView) a(R.id.tv_payments_details_label);
        k.a((Object) textView11, "tv_payments_details_label");
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(textView11);
    }
}
