package net.one97.paytm.paymentsBank.form15g.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;

public final class PBFGTackingActivity extends PaytmActivity implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<net.one97.paytm.paymentsBank.a> f18425a;

    /* renamed from: b  reason: collision with root package name */
    private FGHStatusModel f18426b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.b f18427c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f18428d;

    /* renamed from: e  reason: collision with root package name */
    private View f18429e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18430f;

    /* renamed from: g  reason: collision with root package name */
    private String f18431g = "";

    /* renamed from: h  reason: collision with root package name */
    private int f18432h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f18433i;

    private View a(int i2) {
        if (this.f18433i == null) {
            this.f18433i = new HashMap();
        }
        View view = (View) this.f18433i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f18433i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        FGHResponseModel response;
        FGHResponseModel response2;
        FGHResponseModel response3;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        com.paytm.utility.b.p();
        if (iJRPaytmDataModel == null) {
            a();
        } else if (iJRPaytmDataModel instanceof FGHStatusModel) {
            this.f18426b = (FGHStatusModel) iJRPaytmDataModel;
            FGHStatusModel fGHStatusModel = this.f18426b;
            String str = null;
            if (p.a(fGHStatusModel != null ? fGHStatusModel.getStatus() : null, "REJECTED", false)) {
                View view = this.f18429e;
                if (view != null) {
                    view.setVisibility(8);
                }
                FGHStatusModel fGHStatusModel2 = this.f18426b;
                LinearLayout linearLayout = (LinearLayout) a(R.id.ll_track_fg_parent);
                k.a((Object) linearLayout, "ll_track_fg_parent");
                linearLayout.setVisibility(0);
                RecyclerView recyclerView = (RecyclerView) a(R.id.rv_track_details);
                k.a((Object) recyclerView, "rv_track_details");
                recyclerView.setVisibility(8);
                ImageView imageView = (ImageView) a(R.id.im_forward);
                k.a((Object) imageView, "im_forward");
                imageView.setVisibility(0);
                TextView textView = (TextView) a(R.id.tv_need_help);
                k.a((Object) textView, "tv_need_help");
                textView.setVisibility(0);
                ImageView imageView2 = (ImageView) a(R.id.im_help_icon);
                k.a((Object) imageView2, "im_help_icon");
                imageView2.setVisibility(0);
                TextView textView2 = (TextView) a(R.id.tv_title);
                k.a((Object) textView2, "tv_title");
                textView2.setVisibility(0);
                TextView textView3 = (TextView) a(R.id.tv_rquest_for_submission);
                k.a((Object) textView3, "tv_rquest_for_submission");
                textView3.setVisibility(4);
                TextView textView4 = (TextView) a(R.id.tv_notify_confirmed);
                k.a((Object) textView4, "tv_notify_confirmed");
                textView4.setVisibility(4);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.tv_success_failure_img);
                k.a((Object) lottieAnimationView, "tv_success_failure_img");
                lottieAnimationView.setVisibility(0);
                ((LottieAnimationView) a(R.id.tv_success_failure_img)).setImageResource(R.drawable.pb_fg_failed);
                String string = getString(R.string.pb_fg_name);
                if (p.a((fGHStatusModel2 == null || (response3 = fGHStatusModel2.getResponse()) == null) ? null : response3.getFormtype(), "Form15G", false)) {
                    string = getString(R.string.pb_fg_name);
                } else {
                    if (p.a((fGHStatusModel2 == null || (response2 = fGHStatusModel2.getResponse()) == null) ? null : response2.getFormtype(), "Form15H", false)) {
                        string = getString(R.string.pb_fh_name);
                    }
                }
                TextView textView5 = (TextView) a(R.id.tv_title);
                k.a((Object) textView5, "tv_title");
                textView5.setText(getString(R.string.pb_fg_submission_failed, new Object[]{string}));
                if (!(fGHStatusModel2 == null || (response = fGHStatusModel2.getResponse()) == null)) {
                    str = response.getSubmittedDate();
                }
                String b2 = b(k.a(str, (Object) ""));
                TextView textView6 = (TextView) a(R.id.tv_date);
                k.a((Object) textView6, "tv_date");
                textView6.setText(b2);
                TextView textView7 = (TextView) a(R.id.approved_date);
                k.a((Object) textView7, "approved_date");
                textView7.setVisibility(8);
                TextView textView8 = (TextView) a(R.id.tv_date);
                k.a((Object) textView8, "tv_date");
                textView8.setVisibility(0);
                return;
            }
            FGHStatusModel fGHStatusModel3 = this.f18426b;
            if (p.a(fGHStatusModel3 != null ? fGHStatusModel3.getStatus() : null, "APPROVED", false)) {
                View view2 = this.f18429e;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                c(this.f18426b);
                return;
            }
            FGHStatusModel fGHStatusModel4 = this.f18426b;
            if (p.a(fGHStatusModel4 != null ? fGHStatusModel4.getStatus() : null, "SUBMISSION_PENDING", false)) {
                a(this.f18426b);
                a();
                return;
            }
            FGHStatusModel fGHStatusModel5 = this.f18426b;
            if (fGHStatusModel5 != null) {
                str = fGHStatusModel5.getStatus();
            }
            if (p.a(str, "APPROVAL_PENDING", false)) {
                b(this.f18426b);
                a();
            }
        }
    }

    private final void a() {
        int i2 = this.f18432h;
        if (i2 > 3) {
            View view = this.f18429e;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (i2 == 0) {
            a(this, this);
        } else {
            new Handler().postDelayed(new b(this), 3000);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PBFGTackingActivity f18435a;

        b(PBFGTackingActivity pBFGTackingActivity) {
            this.f18435a = pBFGTackingActivity;
        }

        public final void run() {
            PBFGTackingActivity pBFGTackingActivity = this.f18435a;
            pBFGTackingActivity.a(pBFGTackingActivity, pBFGTackingActivity);
        }
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.pb_fg_track_order_activity);
        this.f18429e = findViewById(R.id.pb_fg_pending);
        View findViewById = findViewById(R.id.rv_track_details);
        k.a((Object) findViewById, "findViewById(R.id.rv_track_details)");
        this.f18428d = (RecyclerView) findViewById;
        ((TextView) a(R.id.tv_view_submited_form)).setOnClickListener(new c(this));
        ((ImageView) a(R.id.iv_back)).setOnClickListener(new d(this));
        TextView textView = (TextView) a(R.id.tv_reference_no);
        k.a((Object) textView, "tv_reference_no");
        textView.setText(getString(R.string.pb_fg_reference_no, new Object[]{com.paytm.utility.b.n((Context) this)}));
        Intent intent = getIntent();
        if (intent.hasExtra("FORM15GH_STATUS")) {
            this.f18426b = (FGHStatusModel) intent.getSerializableExtra("FORM15GH_STATUS");
            FGHStatusModel fGHStatusModel = this.f18426b;
            if (fGHStatusModel != null) {
                String str2 = null;
                if (fGHStatusModel != null) {
                    str = fGHStatusModel.getStatus();
                } else {
                    str = null;
                }
                if (p.a(str, "APPROVED", false)) {
                    View view = this.f18429e;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    c(this.f18426b);
                } else {
                    FGHStatusModel fGHStatusModel2 = this.f18426b;
                    if (p.a(fGHStatusModel2 != null ? fGHStatusModel2.getStatus() : null, "SUBMISSION_PENDING", false)) {
                        a(this.f18426b);
                    } else {
                        FGHStatusModel fGHStatusModel3 = this.f18426b;
                        if (fGHStatusModel3 != null) {
                            str2 = fGHStatusModel3.getStatus();
                        }
                        if (p.a(str2, "APPROVAL_PENDING", false)) {
                            b(this.f18426b);
                            a();
                        }
                    }
                }
                ((RelativeLayout) a(R.id.rl_need_help)).setOnClickListener(new a(this));
            }
            a(fGHStatusModel);
        } else if (intent.hasExtra(AppConstants.EXTRA_FIRST_TITLE)) {
            String stringExtra = intent.getStringExtra(AppConstants.EXTRA_FIRST_TITLE);
            String stringExtra2 = intent.getStringExtra("SUBTITLE");
            k.a((Object) stringExtra, "title");
            k.a((Object) stringExtra2, "subTitle");
            View view2 = this.f18429e;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) a(R.id.ll_track_fg_parent);
            k.a((Object) linearLayout, "ll_track_fg_parent");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = (RecyclerView) a(R.id.rv_track_details);
            k.a((Object) recyclerView, "rv_track_details");
            recyclerView.setVisibility(8);
            ImageView imageView = (ImageView) a(R.id.im_forward);
            k.a((Object) imageView, "im_forward");
            imageView.setVisibility(0);
            TextView textView2 = (TextView) a(R.id.tv_need_help);
            k.a((Object) textView2, "tv_need_help");
            textView2.setVisibility(0);
            ImageView imageView2 = (ImageView) a(R.id.im_help_icon);
            k.a((Object) imageView2, "im_help_icon");
            imageView2.setVisibility(0);
            TextView textView3 = (TextView) a(R.id.tv_title);
            k.a((Object) textView3, "tv_title");
            textView3.setVisibility(0);
            TextView textView4 = (TextView) a(R.id.tv_rquest_for_submission);
            k.a((Object) textView4, "tv_rquest_for_submission");
            textView4.setVisibility(0);
            TextView textView5 = (TextView) a(R.id.tv_notify_confirmed);
            k.a((Object) textView5, "tv_notify_confirmed");
            textView5.setVisibility(4);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.tv_success_failure_img);
            k.a((Object) lottieAnimationView, "tv_success_failure_img");
            lottieAnimationView.setVisibility(0);
            ((LottieAnimationView) a(R.id.tv_success_failure_img)).setImageResource(R.drawable.pb_fg_failed);
            TextView textView6 = (TextView) a(R.id.tv_title);
            k.a((Object) textView6, "tv_title");
            textView6.setText(stringExtra);
            TextView textView7 = (TextView) a(R.id.tv_rquest_for_submission);
            k.a((Object) textView7, "tv_rquest_for_submission");
            textView7.setText(stringExtra2);
            ((RelativeLayout) a(R.id.rl_need_help)).setOnClickListener(new a(this));
        }
        a();
        ((RelativeLayout) a(R.id.rl_need_help)).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PBFGTackingActivity f18434a;

        a(PBFGTackingActivity pBFGTackingActivity) {
            this.f18434a = pBFGTackingActivity;
        }

        public final void onClick(View view) {
            o.a().checkDeepLinking(this.f18434a, n.q());
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PBFGTackingActivity f18436a;

        c(PBFGTackingActivity pBFGTackingActivity) {
            this.f18436a = pBFGTackingActivity;
        }

        public final void onClick(View view) {
            PBFGTackingActivity.a(this.f18436a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PBFGTackingActivity f18437a;

        d(PBFGTackingActivity pBFGTackingActivity) {
            this.f18437a = pBFGTackingActivity;
        }

        public final void onClick(View view) {
            this.f18437a.onBackPressed();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x00da, code lost:
        r6 = r9.getResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r9) {
        /*
            r8 = this;
            int r0 = net.one97.paytm.paymentsBank.R.id.ll_track_fg_parent
            android.view.View r0 = r8.a((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "ll_track_fg_parent"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.rv_track_details
            android.view.View r0 = r8.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r2 = "rv_track_details"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r2 = 8
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.paymentsBank.R.id.im_forward
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r3 = "im_forward"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_need_help
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "tv_need_help"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.im_help_icon
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r3 = "im_help_icon"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_title
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "tv_title"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_rquest_for_submission
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tv_rquest_for_submission"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_rquest_for_submission
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            int r5 = net.one97.paytm.paymentsBank.R.string.pb_fg_ppb_request_for_submission
            java.lang.String r5 = r8.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_rquest_for_submission
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r5 = net.one97.paytm.paymentsBank.R.id.tv_rquest_for_submission
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            android.graphics.Typeface r4 = r5.getTypeface()
            r5 = 1
            r0.setTypeface(r4, r5)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_notify_confirmed
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tv_notify_confirmed"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_success_failure_img
            android.view.View r0 = r8.a((int) r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            java.lang.String r4 = "tv_success_failure_img"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_success_failure_img
            android.view.View r0 = r8.a((int) r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            int r4 = net.one97.paytm.paymentsBank.R.drawable.pb_fg_pending
            r0.setImageResource(r4)
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fg_name
            java.lang.String r0 = r8.getString(r0)
            r4 = 0
            if (r9 == 0) goto L_0x00e5
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r6 = r9.getResponse()
            if (r6 == 0) goto L_0x00e5
            java.lang.String r6 = r6.getFormtype()
            goto L_0x00e6
        L_0x00e5:
            r6 = r4
        L_0x00e6:
            java.lang.String r7 = "Form15G"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r1)
            if (r6 == 0) goto L_0x00f5
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fg_name
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0111
        L_0x00f5:
            if (r9 == 0) goto L_0x0102
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r6 = r9.getResponse()
            if (r6 == 0) goto L_0x0102
            java.lang.String r6 = r6.getFormtype()
            goto L_0x0103
        L_0x0102:
            r6 = r4
        L_0x0103:
            java.lang.String r7 = "Form15H"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r1)
            if (r6 == 0) goto L_0x0111
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fh_name
            java.lang.String r0 = r8.getString(r0)
        L_0x0111:
            int r6 = net.one97.paytm.paymentsBank.R.id.tv_title
            android.view.View r6 = r8.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_f15g_submission_pending
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r1] = r0
            java.lang.String r0 = r8.getString(r3, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
            if (r9 == 0) goto L_0x0137
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r9 = r9.getResponse()
            if (r9 == 0) goto L_0x0137
            java.lang.String r4 = r9.getSubmittedDate()
        L_0x0137:
            java.lang.String r9 = ""
            java.lang.String r9 = kotlin.g.b.k.a((java.lang.String) r4, (java.lang.Object) r9)
            java.lang.String r9 = b((java.lang.String) r9)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_date
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "tv_date"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            int r9 = net.one97.paytm.paymentsBank.R.id.approved_date
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r0 = "approved_date"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r9.setVisibility(r2)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_date
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
            r9.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.form15g.activity.PBFGTackingActivity.a(net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r9.getResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r9) {
        /*
            r8 = this;
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fg_name
            java.lang.String r0 = r8.getString(r0)
            r1 = 0
            if (r9 == 0) goto L_0x0014
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r2 = r9.getResponse()
            if (r2 == 0) goto L_0x0014
            java.lang.String r2 = r2.getFormtype()
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            r3 = 0
            java.lang.String r4 = "Form15G"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r2 == 0) goto L_0x0025
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fg_name
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0041
        L_0x0025:
            if (r9 == 0) goto L_0x0032
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r2 = r9.getResponse()
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = r2.getFormtype()
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            java.lang.String r4 = "Form15H"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r3)
            if (r2 == 0) goto L_0x0041
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fh_name
            java.lang.String r0 = r8.getString(r0)
        L_0x0041:
            int r2 = net.one97.paytm.paymentsBank.R.id.tv_title
            android.view.View r2 = r8.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r4 = "tv_title"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = r2.getText()
            int r5 = net.one97.paytm.paymentsBank.R.string.pb_fg_submited_successfully
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r3] = r0
            java.lang.String r5 = r8.getString(r5, r7)
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0064
            return
        L_0x0064:
            int r2 = net.one97.paytm.paymentsBank.R.id.tv_title
            android.view.View r2 = r8.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            int r5 = net.one97.paytm.paymentsBank.R.string.pb_fg_submited_successfully
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r3] = r0
            java.lang.String r0 = r8.getString(r5, r7)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            int r0 = net.one97.paytm.paymentsBank.R.id.ll_track_fg_parent
            android.view.View r0 = r8.a((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r2 = "ll_track_fg_parent"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r3)
            int r0 = net.one97.paytm.paymentsBank.R.id.rv_track_details
            android.view.View r0 = r8.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r2 = "rv_track_details"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r3)
            int r0 = net.one97.paytm.paymentsBank.R.id.im_forward
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r2 = "im_forward"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r3)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_need_help
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tv_need_help"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r3)
            int r0 = net.one97.paytm.paymentsBank.R.id.im_help_icon
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r2 = "im_help_icon"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r3)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_title
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r3)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_rquest_for_submission
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tv_rquest_for_submission"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r2 = 8
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_notify_confirmed
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tv_notify_confirmed"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_success_failure_img
            android.view.View r0 = r8.a((int) r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            java.lang.String r4 = "tv_success_failure_img"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r3)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_success_failure_img
            android.view.View r0 = r8.a((int) r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            int r4 = net.one97.paytm.paymentsBank.R.drawable.pb_fg_ic_success
            r0.setImageResource(r4)
            androidx.recyclerview.widget.RecyclerView r0 = r8.f18428d
            java.lang.String r4 = "mRvTrackingDetails"
            if (r0 != 0) goto L_0x0124
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0124:
            androidx.recyclerview.widget.LinearLayoutManager r5 = new androidx.recyclerview.widget.LinearLayoutManager
            r7 = r8
            android.content.Context r7 = (android.content.Context) r7
            r5.<init>(r7, r6, r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r5
            r0.setLayoutManager(r5)
            r8.b()
            net.one97.paytm.paymentsBank.b r0 = new net.one97.paytm.paymentsBank.b
            java.util.ArrayList<net.one97.paytm.paymentsBank.a> r5 = r8.f18425a
            if (r5 != 0) goto L_0x013f
            java.lang.String r6 = "statusFlowList"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x013f:
            java.util.List r5 = (java.util.List) r5
            r0.<init>(r5)
            r8.f18427c = r0
            androidx.recyclerview.widget.RecyclerView r0 = r8.f18428d
            if (r0 != 0) goto L_0x014d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x014d:
            net.one97.paytm.paymentsBank.b r4 = r8.f18427c
            if (r4 != 0) goto L_0x0156
            java.lang.String r5 = "adapter"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0156:
            androidx.recyclerview.widget.RecyclerView$a r4 = (androidx.recyclerview.widget.RecyclerView.a) r4
            r0.setAdapter(r4)
            android.view.View r0 = r8.f18429e
            if (r0 == 0) goto L_0x0162
            r0.setVisibility(r2)
        L_0x0162:
            if (r9 == 0) goto L_0x016e
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r9 = r9.getResponse()
            if (r9 == 0) goto L_0x016e
            java.lang.String r1 = r9.getUpdatedDate()
        L_0x016e:
            java.lang.String r9 = ""
            java.lang.String r9 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r9)
            java.lang.String r9 = b((java.lang.String) r9)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_date
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_date"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            int r9 = net.one97.paytm.paymentsBank.R.id.approved_date
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r0 = "approved_date"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r9.setVisibility(r2)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_date
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r9.setVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.form15g.activity.PBFGTackingActivity.b(net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0090, code lost:
        r5 = r9.getResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r9) {
        /*
            r8 = this;
            int r0 = net.one97.paytm.paymentsBank.R.id.ll_track_fg_parent
            android.view.View r0 = r8.a((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "ll_track_fg_parent"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            android.view.View r0 = r8.f18429e
            r2 = 8
            if (r0 == 0) goto L_0x001a
            r0.setVisibility(r2)
        L_0x001a:
            int r0 = net.one97.paytm.paymentsBank.R.id.rv_track_details
            android.view.View r0 = r8.a((int) r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r3 = "rv_track_details"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_need_help
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "tv_need_help"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.im_help_icon
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r3 = "im_help_icon"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_title
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "tv_title"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_view_submited_form
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = "tv_view_submited_form"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_success_failure_img
            android.view.View r0 = r8.a((int) r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            java.lang.String r4 = "tv_success_failure_img"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.paymentsBank.R.id.tv_success_failure_img
            android.view.View r0 = r8.a((int) r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            int r4 = net.one97.paytm.paymentsBank.R.drawable.pb_fg_ic_success
            r0.setImageResource(r4)
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fg_name
            java.lang.String r0 = r8.getString(r0)
            r4 = 0
            if (r9 == 0) goto L_0x009b
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r5 = r9.getResponse()
            if (r5 == 0) goto L_0x009b
            java.lang.String r5 = r5.getFormtype()
            goto L_0x009c
        L_0x009b:
            r5 = r4
        L_0x009c:
            java.lang.String r6 = "Form15G"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r1)
            if (r5 == 0) goto L_0x00ab
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fg_name
            java.lang.String r0 = r8.getString(r0)
            goto L_0x00c7
        L_0x00ab:
            if (r9 == 0) goto L_0x00b8
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r5 = r9.getResponse()
            if (r5 == 0) goto L_0x00b8
            java.lang.String r5 = r5.getFormtype()
            goto L_0x00b9
        L_0x00b8:
            r5 = r4
        L_0x00b9:
            java.lang.String r6 = "Form15H"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r1)
            if (r5 == 0) goto L_0x00c7
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fh_name
            java.lang.String r0 = r8.getString(r0)
        L_0x00c7:
            int r5 = net.one97.paytm.paymentsBank.R.id.tv_title
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_fg_form_approved_succ
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r1] = r0
            java.lang.String r0 = r8.getString(r3, r7)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            if (r9 == 0) goto L_0x00ee
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r9 = r9.getResponse()
            if (r9 == 0) goto L_0x00ee
            java.lang.String r4 = r9.getUpdatedDate()
        L_0x00ee:
            java.lang.String r9 = ""
            java.lang.String r9 = kotlin.g.b.k.a((java.lang.String) r4, (java.lang.Object) r9)
            java.lang.String r9 = c((java.lang.String) r9)
            int r0 = net.one97.paytm.paymentsBank.R.id.approved_date
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "approved_date"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            int r4 = net.one97.paytm.paymentsBank.R.string.pb_fg_on_date
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r5[r1] = r9
            java.lang.String r9 = r8.getString(r4, r5)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            int r9 = net.one97.paytm.paymentsBank.R.id.approved_date
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
            r9.setVisibility(r1)
            int r9 = net.one97.paytm.paymentsBank.R.id.tv_date
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r0 = "tv_date"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r9.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.form15g.activity.PBFGTackingActivity.c(net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r0.getResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.f18425a = r0
            net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r0 = r10.f18426b
            if (r0 == 0) goto L_0x00d6
            r1 = 0
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r0 = r0.getResponse()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getFormtype()
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            r2 = 0
            java.lang.String r3 = "Form15G"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            java.lang.String r3 = "statusFlowList"
            if (r0 == 0) goto L_0x0058
            java.util.ArrayList<net.one97.paytm.paymentsBank.a> r0 = r10.f18425a
            if (r0 != 0) goto L_0x002c
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x002c:
            net.one97.paytm.paymentsBank.a r2 = new net.one97.paytm.paymentsBank.a
            int r4 = net.one97.paytm.paymentsBank.R.string.pb_f15g_submited
            java.lang.String r5 = r10.getString(r4)
            net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r4 = r10.f18426b
            if (r4 == 0) goto L_0x0041
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r4 = r4.response
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = r4.getSubmittedDate()
            goto L_0x0042
        L_0x0041:
            r4 = r1
        L_0x0042:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r7 = a((java.lang.String) r4)
            r8 = 104(0x68, float:1.46E-43)
            r9 = 100
            java.lang.String r6 = ""
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            r0.add(r2)
            goto L_0x00a2
        L_0x0058:
            net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r0 = r10.f18426b
            if (r0 == 0) goto L_0x0067
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r0 = r0.getResponse()
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r0.getFormtype()
            goto L_0x0068
        L_0x0067:
            r0 = r1
        L_0x0068:
            java.lang.String r4 = "Form15H"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r2)
            if (r0 == 0) goto L_0x00a2
            java.util.ArrayList<net.one97.paytm.paymentsBank.a> r0 = r10.f18425a
            if (r0 != 0) goto L_0x0077
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0077:
            net.one97.paytm.paymentsBank.a r2 = new net.one97.paytm.paymentsBank.a
            int r4 = net.one97.paytm.paymentsBank.R.string.pb_f15h_submited
            java.lang.String r5 = r10.getString(r4)
            net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r4 = r10.f18426b
            if (r4 == 0) goto L_0x008c
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r4 = r4.response
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = r4.getUpdatedDate()
            goto L_0x008d
        L_0x008c:
            r4 = r1
        L_0x008d:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r7 = a((java.lang.String) r4)
            r8 = 104(0x68, float:1.46E-43)
            r9 = 100
            java.lang.String r6 = ""
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            r0.add(r2)
        L_0x00a2:
            java.util.ArrayList<net.one97.paytm.paymentsBank.a> r0 = r10.f18425a
            if (r0 != 0) goto L_0x00a9
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00a9:
            net.one97.paytm.paymentsBank.a r2 = new net.one97.paytm.paymentsBank.a
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_fg_approval_pending
            java.lang.String r5 = r10.getString(r3)
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_fg_time_for_form15_status
            java.lang.String r6 = r10.getString(r3)
            net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel r3 = r10.f18426b
            if (r3 == 0) goto L_0x00c3
            net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel r3 = r3.response
            if (r3 == 0) goto L_0x00c3
            java.lang.String r1 = r3.getUpdatedDate()
        L_0x00c3:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r7 = a((java.lang.String) r1)
            r8 = 100
            r9 = 102(0x66, float:1.43E-43)
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            r0.add(r2)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.form15g.activity.PBFGTackingActivity.b():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r2) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "dd/MM/yyyy HH:mm:ss"
            r0.<init>(r1)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            if (r2 == 0) goto L_0x001f
            java.util.Date r2 = r0.parse(r2)     // Catch:{ ParseException -> 0x0017 }
            goto L_0x0020
        L_0x0017:
            r2 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x001f
            r2.printStackTrace()
        L_0x001f:
            r2 = 0
        L_0x0020:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "dd MMM"
            r0.<init>(r1)
            java.lang.String r1 = "GMT+5:30"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = r0.format(r2)
            java.lang.String r0 = "S.format(formatedDate)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            goto L_0x003e
        L_0x003c:
            java.lang.String r2 = ""
        L_0x003e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.form15g.activity.PBFGTackingActivity.a(java.lang.String):java.lang.String");
    }

    private static String b(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (str != null) {
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException unused) {
            }
        } else {
            date = null;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a, dd MMM yyyy");
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        if (date != null) {
            String format = simpleDateFormat2.format(date);
            k.a((Object) format, "S.format(formatedDate)");
            return format;
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(java.lang.String r2) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "dd/MM/yyyy HH:mm:ss"
            r0.<init>(r1)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            if (r2 == 0) goto L_0x001f
            java.util.Date r2 = r0.parse(r2)     // Catch:{ ParseException -> 0x0017 }
            goto L_0x0020
        L_0x0017:
            r2 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x001f
            r2.printStackTrace()
        L_0x001f:
            r2 = 0
        L_0x0020:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "EEEE, dd MMMM yyyy"
            r0.<init>(r1)
            java.lang.String r1 = "GMT+5:30"
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = r0.format(r2)
            java.lang.String r0 = "S.format(formatedDate)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            goto L_0x003e
        L_0x003c:
            java.lang.String r2 = ""
        L_0x003e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.form15g.activity.PBFGTackingActivity.c(java.lang.String):java.lang.String");
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.p();
        View view = this.f18429e;
        if (view != null) {
            view.setVisibility(8);
        }
        if (i2 == -1) {
            try {
                net.one97.paytm.paymentsBank.fragment.k.a().show(getSupportFragmentManager().a(), "dialog");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(g.b<?> bVar, g.a aVar) {
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(context)");
        String A = net.one97.paytm.bankCommon.utils.d.A();
        Map hashMap = new HashMap();
        hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
        String k = com.paytm.utility.b.k();
        k.a((Object) k, "CJRAppCommonUtility.getClientId()");
        hashMap.put("client", k);
        hashMap.put("ccontent-type", "application/json");
        Context context = this;
        String a2 = net.one97.paytm.bankCommon.mapping.d.a(context);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(this)");
        hashMap.put("user-token", a2);
        HashMap hashMap2 = new HashMap();
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap2.put("screen_name", simpleName);
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(A, (g.b) bVar, aVar, (IJRPaytmDataModel) new FGHStatusModel(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        if (com.paytm.utility.b.c(context)) {
            View view = this.f18429e;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f18432h++;
            net.one97.paytm.bankCommon.g.c.a();
            net.one97.paytm.bankCommon.g.c.a(aVar2);
            return;
        }
        View view2 = this.f18429e;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        aVar.onErrorResponse(-1, new FGHStatusModel(), new NetworkCustomError());
    }

    public static final /* synthetic */ void a(PBFGTackingActivity pBFGTackingActivity) {
        pBFGTackingActivity.f18430f = true;
        Intent intent = new Intent(pBFGTackingActivity, PBFGViewSubmitedFormActivity.class);
        intent.putExtra("FORM15GH_STATUS", pBFGTackingActivity.f18426b);
        pBFGTackingActivity.startActivity(intent);
    }
}
