package net.one97.paytm.referral.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.referral.model.AdditionProperty;
import net.one97.paytm.referral.model.BonusDetail;
import net.one97.paytm.referral.model.CampaignReferral;
import net.one97.paytm.referral.model.ReferralData;
import net.one97.paytm.referral.model.ReferralMain;
import net.one97.paytm.referral.model.TermsAndCondition;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;

public final class ReferralLandingActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.referral.d.a f19977a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f19978b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f19979c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.g.a.m<Integer, String, x> f19980d = new e(this);

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.g.a.b<BonusDetail, Object> f19981e = new a(this);

    /* renamed from: f  reason: collision with root package name */
    private final q<Integer, CampaignReferral, String, x> f19982f = new b(this);

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.g.a.m<String, Integer, Object> f19983g = new d(this);

    /* renamed from: h  reason: collision with root package name */
    private HashMap f19984h;

    public final View a(int i2) {
        if (this.f19984h == null) {
            this.f19984h = new HashMap();
        }
        View view = (View) this.f19984h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f19984h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.b<BonusDetail, x> {
        final /* synthetic */ ReferralLandingActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ReferralLandingActivity referralLandingActivity) {
            super(1);
            this.this$0 = referralLandingActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BonusDetail) obj);
            return x.f47997a;
        }

        public final void invoke(BonusDetail bonusDetail) {
            kotlin.g.b.k.c(bonusDetail, "it");
            net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
            ReferralLandingActivity referralLandingActivity = this.this$0;
            net.one97.paytm.referral.c.b.a(referralLandingActivity, referralLandingActivity.d(), this.this$0.c(), "total_cashback_clicked", "", "");
            new net.one97.paytm.referral.b.a().show(this.this$0.getSupportFragmentManager(), (String) null);
        }
    }

    static final class b extends kotlin.g.b.l implements q<Integer, CampaignReferral, String, x> {
        final /* synthetic */ ReferralLandingActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ReferralLandingActivity referralLandingActivity) {
            super(3);
            this.this$0 = referralLandingActivity;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke(((Number) obj).intValue(), (CampaignReferral) obj2, (String) obj3);
            return x.f47997a;
        }

        public final void invoke(int i2, CampaignReferral campaignReferral, String str) {
            kotlin.g.b.k.c(campaignReferral, "campaign");
            net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
            ReferralLandingActivity referralLandingActivity = this.this$0;
            net.one97.paytm.referral.c.b.a(referralLandingActivity, referralLandingActivity.d(), this.this$0.c(), "invite_clicked", campaignReferral.getCampaign(), String.valueOf(campaignReferral.getId()));
            Intent intent = new Intent(this.this$0, ReferralOfferActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaign_referral", campaignReferral);
            bundle.putString("tag", this.this$0.c());
            bundle.putString("utm_source", this.this$0.d());
            intent.putExtras(bundle);
            this.this$0.startActivity(intent);
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.m<String, Integer, x> {
        final /* synthetic */ ReferralLandingActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ReferralLandingActivity referralLandingActivity) {
            super(2);
            this.this$0 = referralLandingActivity;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, ((Number) obj2).intValue());
            return x.f47997a;
        }

        public final void invoke(String str, int i2) {
            kotlin.g.b.k.c(str, "url");
            ReferralLandingActivity.a(this.this$0, str, true);
        }
    }

    static final class e extends kotlin.g.b.l implements kotlin.g.a.m<Integer, String, x> {
        final /* synthetic */ ReferralLandingActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ReferralLandingActivity referralLandingActivity) {
            super(2);
            this.this$0 = referralLandingActivity;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (String) obj2);
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
            r0 = (r0 = (r0 = (r0 = r0.getData()).getCampaigns()).get(0)).getCampaignInnerReferralData();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(int r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.String r0 = "message"
                kotlin.g.b.k.c(r8, r0)
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r6.this$0
                net.one97.paytm.referral.d.a r0 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r0)
                androidx.lifecycle.y<net.one97.paytm.referral.model.ReferralMain> r0 = r0.f20030a
                java.lang.Object r0 = r0.getValue()
                net.one97.paytm.referral.model.ReferralMain r0 = (net.one97.paytm.referral.model.ReferralMain) r0
                r1 = 0
                if (r0 == 0) goto L_0x0035
                net.one97.paytm.referral.model.ReferralData r0 = r0.getData()
                if (r0 == 0) goto L_0x0035
                java.util.ArrayList r0 = r0.getCampaigns()
                if (r0 == 0) goto L_0x0035
                java.lang.Object r0 = r0.get(r1)
                net.one97.paytm.referral.model.CampaignReferral r0 = (net.one97.paytm.referral.model.CampaignReferral) r0
                if (r0 == 0) goto L_0x0035
                net.one97.paytm.referral.model.CampaignInnerReferralData r0 = r0.getCampaignInnerReferralData()
                if (r0 == 0) goto L_0x0035
                java.lang.String r0 = r0.getDeepLinkText()
                goto L_0x0036
            L_0x0035:
                r0 = 0
            L_0x0036:
                java.lang.String r2 = "applicationContext"
                switch(r7) {
                    case 1: goto L_0x016f;
                    case 2: goto L_0x0136;
                    case 3: goto L_0x00fd;
                    case 4: goto L_0x00c4;
                    case 5: goto L_0x008b;
                    case 6: goto L_0x0057;
                    default: goto L_0x003b;
                }
            L_0x003b:
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r6.this$0
                net.one97.paytm.referral.d.a r0 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r0)
                net.one97.paytm.referral.model.AdditionProperty r0 = r0.c()
                if (r0 == 0) goto L_0x01c5
                java.lang.String r2 = r0.getShortUrl()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                if (r2 == 0) goto L_0x01aa
                boolean r2 = kotlin.m.p.a(r2)
                if (r2 == 0) goto L_0x01a8
                goto L_0x01aa
            L_0x0057:
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                r7.b((java.lang.String) r8)
                net.one97.paytm.referral.c.b r7 = net.one97.paytm.referral.c.b.f20028a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = r7.d()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                java.lang.String r2 = r7.c()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r4 = r7.a()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r5 = r7.b()
                java.lang.String r3 = "know_more_clicked"
                net.one97.paytm.referral.c.b.a(r0, r1, r2, r3, r4, r5)
                return
            L_0x008b:
                net.one97.paytm.referral.c.c r7 = net.one97.paytm.referral.c.c.f20029a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                android.content.Context r7 = r7.getApplicationContext()
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
                net.one97.paytm.referral.c.c.a(r8, r7)
                net.one97.paytm.referral.c.b r7 = net.one97.paytm.referral.c.b.f20028a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = r7.d()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                java.lang.String r2 = r7.c()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r4 = r7.a()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r5 = r7.b()
                java.lang.String r3 = "copy_clicked"
                net.one97.paytm.referral.c.b.a(r0, r1, r2, r3, r4, r5)
                return
            L_0x00c4:
                net.one97.paytm.referral.c.c r7 = net.one97.paytm.referral.c.c.f20029a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                android.content.Context r7 = r7.getApplicationContext()
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
                net.one97.paytm.referral.c.c.a(r0, r8, r7)
                net.one97.paytm.referral.c.b r7 = net.one97.paytm.referral.c.b.f20028a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = r7.d()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                java.lang.String r2 = r7.c()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r4 = r7.a()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r5 = r7.b()
                java.lang.String r3 = "more_clicked"
                net.one97.paytm.referral.c.b.a(r0, r1, r2, r3, r4, r5)
                return
            L_0x00fd:
                net.one97.paytm.referral.c.c r7 = net.one97.paytm.referral.c.c.f20029a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                android.content.Context r7 = r7.getApplicationContext()
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
                net.one97.paytm.referral.c.c.d(r0, r8, r7)
                net.one97.paytm.referral.c.b r7 = net.one97.paytm.referral.c.b.f20028a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = r7.d()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                java.lang.String r2 = r7.c()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r4 = r7.a()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r5 = r7.b()
                java.lang.String r3 = "wa_clicked"
                net.one97.paytm.referral.c.b.a(r0, r1, r2, r3, r4, r5)
                return
            L_0x0136:
                net.one97.paytm.referral.c.c r7 = net.one97.paytm.referral.c.c.f20029a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                android.content.Context r7 = r7.getApplicationContext()
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
                net.one97.paytm.referral.c.c.c(r0, r8, r7)
                net.one97.paytm.referral.c.b r7 = net.one97.paytm.referral.c.b.f20028a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = r7.d()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                java.lang.String r2 = r7.c()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r4 = r7.a()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r5 = r7.b()
                java.lang.String r3 = "sms_clicked"
                net.one97.paytm.referral.c.b.a(r0, r1, r2, r3, r4, r5)
                return
            L_0x016f:
                net.one97.paytm.referral.c.c r7 = net.one97.paytm.referral.c.c.f20029a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                android.content.Context r7 = r7.getApplicationContext()
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
                net.one97.paytm.referral.c.c.b(r0, r8, r7)
                net.one97.paytm.referral.c.b r7 = net.one97.paytm.referral.c.b.f20028a
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = r7.d()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                java.lang.String r2 = r7.c()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r4 = r7.a()
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.d.a r7 = net.one97.paytm.referral.activity.ReferralLandingActivity.e(r7)
                java.lang.String r5 = r7.b()
                java.lang.String r3 = "twitter_clicked"
                net.one97.paytm.referral.c.b.a(r0, r1, r2, r3, r4, r5)
                return
            L_0x01a8:
                r2 = 0
                goto L_0x01ab
            L_0x01aa:
                r2 = 1
            L_0x01ab:
                if (r2 == 0) goto L_0x01b3
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r6.this$0
                net.one97.paytm.referral.activity.ReferralLandingActivity.a((net.one97.paytm.referral.activity.ReferralLandingActivity) r0, (java.lang.String) r8, (int) r7)
                return
            L_0x01b3:
                java.lang.String r0 = r0.getShortUrl()
                if (r0 == 0) goto L_0x01bf
                net.one97.paytm.referral.activity.ReferralLandingActivity r7 = r6.this$0
                net.one97.paytm.referral.activity.ReferralLandingActivity.a((net.one97.paytm.referral.activity.ReferralLandingActivity) r7, (java.lang.String) r0, (boolean) r1)
                return
            L_0x01bf:
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r6.this$0
                net.one97.paytm.referral.activity.ReferralLandingActivity.a((net.one97.paytm.referral.activity.ReferralLandingActivity) r0, (java.lang.String) r8, (int) r7)
                return
            L_0x01c5:
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r6.this$0
                net.one97.paytm.referral.activity.ReferralLandingActivity.a((net.one97.paytm.referral.activity.ReferralLandingActivity) r0, (java.lang.String) r8, (int) r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.activity.ReferralLandingActivity.e.invoke(int, java.lang.String):void");
        }
    }

    static final class g<T> implements z<ReferralMain> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19989a;

        g(ReferralLandingActivity referralLandingActivity) {
            this.f19989a = referralLandingActivity;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.referral.model.ReferralMain r4 = (net.one97.paytm.referral.model.ReferralMain) r4
                if (r4 == 0) goto L_0x0058
                net.one97.paytm.referral.model.ReferralData r0 = r4.getData()
                if (r0 == 0) goto L_0x0058
                net.one97.paytm.referral.model.ReferralData r0 = r4.getData()
                if (r0 == 0) goto L_0x0015
                java.util.ArrayList r0 = r0.getCampaigns()
                goto L_0x0016
            L_0x0015:
                r0 = 0
            L_0x0016:
                if (r0 == 0) goto L_0x0058
                net.one97.paytm.referral.model.ReferralData r0 = r4.getData()
                if (r0 == 0) goto L_0x002b
                java.util.ArrayList r0 = r0.getCampaigns()
                if (r0 == 0) goto L_0x002b
                int r0 = r0.size()
                if (r0 != 0) goto L_0x002b
                goto L_0x0058
            L_0x002b:
                net.one97.paytm.referral.model.ReferralData r0 = r4.getData()
                if (r0 == 0) goto L_0x005d
                java.util.ArrayList r0 = r0.getCampaigns()
                if (r0 == 0) goto L_0x005d
                int r0 = r0.size()
                r1 = 1
                if (r0 != r1) goto L_0x005d
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r3.f19989a
                int r1 = net.one97.paytm.vipcashback.R.id.recyclerView
                android.view.View r0 = r0.a((int) r1)
                androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
                net.one97.paytm.referral.activity.ReferralLandingActivity r1 = r3.f19989a
                android.content.Context r1 = r1.getApplicationContext()
                int r2 = net.one97.paytm.vipcashback.R.color.color_0f00aced
                int r1 = androidx.core.content.b.c(r1, r2)
                r0.setBackgroundColor(r1)
                goto L_0x005d
            L_0x0058:
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r3.f19989a
                r0.a()
            L_0x005d:
                if (r4 == 0) goto L_0x0064
                net.one97.paytm.referral.activity.ReferralLandingActivity r0 = r3.f19989a
                net.one97.paytm.referral.activity.ReferralLandingActivity.a((net.one97.paytm.referral.activity.ReferralLandingActivity) r0, (net.one97.paytm.referral.model.ReferralMain) r4)
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.activity.ReferralLandingActivity.g.onChanged(java.lang.Object):void");
        }
    }

    static final class h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19990a;

        h(ReferralLandingActivity referralLandingActivity) {
            this.f19990a = referralLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "isShowOrHide");
            if (bool.booleanValue()) {
                net.one97.paytm.common.widgets.a.a(ReferralLandingActivity.a(this.f19990a));
            } else {
                net.one97.paytm.common.widgets.a.b(ReferralLandingActivity.a(this.f19990a));
            }
        }
    }

    static final class i<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19991a;

        i(ReferralLandingActivity referralLandingActivity) {
            this.f19991a = referralLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "noCanpaign");
            if (bool.booleanValue()) {
                this.f19991a.a();
            }
        }
    }

    static final class k<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19993a;

        k(ReferralLandingActivity referralLandingActivity) {
            this.f19993a = referralLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if ((num != null && num.intValue() == 410) || ((num != null && num.intValue() == 401) || (num != null && num.intValue() == 403))) {
                String b2 = this.f19993a.c();
                Bundle bundle = new Bundle();
                bundle.putString("tag", b2);
                net.one97.paytm.vipcashback.c.a.b().showSessionTimeOutAlert(this.f19993a, (String) null, bundle, new NetworkCustomError(), false, true);
                return;
            }
            com.paytm.utility.g.b(this.f19993a, this.f19993a.getString(R.string.referral_error_title_message), this.f19993a.getString(R.string.referral_error_description_message), new g.c(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ k f19994a;

                {
                    this.f19994a = r1;
                }

                public final void onDialogDismissed() {
                    this.f19994a.f19993a.finish();
                }
            });
        }
    }

    public static final /* synthetic */ LottieAnimationView a(ReferralLandingActivity referralLandingActivity) {
        LottieAnimationView lottieAnimationView = referralLandingActivity.f19978b;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("loader");
        }
        return lottieAnimationView;
    }

    public static final /* synthetic */ net.one97.paytm.referral.d.a e(ReferralLandingActivity referralLandingActivity) {
        net.one97.paytm.referral.d.a aVar = referralLandingActivity.f19977a;
        if (aVar == null) {
            kotlin.g.b.k.a("referralViewModel");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_referral);
        View findViewById = findViewById(R.id.loader);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.loader)");
        this.f19978b = (LottieAnimationView) findViewById;
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.referral.d.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ralViewModel::class.java]");
        this.f19977a = (net.one97.paytm.referral.d.a) a2;
        net.one97.paytm.referral.d.a aVar = this.f19977a;
        if (aVar == null) {
            kotlin.g.b.k.a("referralViewModel");
        }
        androidx.lifecycle.q qVar = this;
        aVar.f20030a.observe(qVar, new g(this));
        net.one97.paytm.referral.d.a aVar2 = this.f19977a;
        if (aVar2 == null) {
            kotlin.g.b.k.a("referralViewModel");
        }
        aVar2.f20032c.observe(qVar, new h(this));
        net.one97.paytm.referral.d.a aVar3 = this.f19977a;
        if (aVar3 == null) {
            kotlin.g.b.k.a("referralViewModel");
        }
        aVar3.f20035f.observe(qVar, new i(this));
        net.one97.paytm.referral.d.a aVar4 = this.f19977a;
        if (aVar4 == null) {
            kotlin.g.b.k.a("referralViewModel");
        }
        aVar4.f20034e.observe(qVar, new j(this));
        net.one97.paytm.referral.d.a aVar5 = this.f19977a;
        if (aVar5 == null) {
            kotlin.g.b.k.a("referralViewModel");
        }
        aVar5.f20033d.observe(qVar, new k(this));
        b();
        ((AppCompatImageView) a(R.id.back_arrow)).setOnClickListener(new l(this));
        ((RecyclerView) a(R.id.recyclerView)).addOnScrollListener(new m(this));
        net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
        net.one97.paytm.referral.c.b.a(this, d(), c(), "primary_page_load", "", "");
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19995a;

        l(ReferralLandingActivity referralLandingActivity) {
            this.f19995a = referralLandingActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
            ReferralLandingActivity referralLandingActivity = this.f19995a;
            net.one97.paytm.referral.c.b.a(referralLandingActivity, referralLandingActivity.d(), this.f19995a.c(), "back_clicked", "", "");
            this.f19995a.finish();
        }
    }

    public static final class m extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19996a;

        m(ReferralLandingActivity referralLandingActivity) {
            this.f19996a = referralLandingActivity;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            ReferralLandingActivity referralLandingActivity = this.f19996a;
            referralLandingActivity.f19979c = referralLandingActivity.f19979c + i3;
            if (this.f19996a.f19979c >= net.one97.paytm.coins.c.b.a(this.f19996a.getApplicationContext())) {
                this.f19996a.a(R.id.background_back_arrow).setBackgroundColor(androidx.core.content.b.c(this.f19996a.getApplicationContext(), R.color.color_ffffff));
            } else {
                this.f19996a.a(R.id.background_back_arrow).setBackgroundColor(androidx.core.content.b.c(this.f19996a.getApplicationContext(), R.color.transparent));
            }
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19985a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19986b;

        c(ReferralLandingActivity referralLandingActivity, String str) {
            this.f19985a = referralLandingActivity;
            this.f19986b = str;
        }

        public final void run() {
            ReferralData data;
            ArrayList<CampaignReferral> campaigns;
            CampaignReferral campaignReferral;
            ReferralMain value = ReferralLandingActivity.e(this.f19985a).f20030a.getValue();
            if (!(value == null || (data = value.getData()) == null || (campaigns = data.getCampaigns()) == null || (campaignReferral = campaigns.get(0)) == null)) {
                campaignReferral.setGeneratedUrl(this.f19986b);
            }
            ((RecyclerView) this.f19985a.a(R.id.recyclerView)).post(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f19987a;

                {
                    this.f19987a = r1;
                }

                public final void run() {
                    RecyclerView recyclerView = (RecyclerView) this.f19987a.f19985a.a(R.id.recyclerView);
                    kotlin.g.b.k.a((Object) recyclerView, "recyclerView");
                    RecyclerView.a adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(0);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        Bundle extras;
        Context context = this;
        if (!com.paytm.utility.b.c(context)) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            d.a.a(context, false, (net.one97.paytm.coins.b.a) new f(this));
            return;
        }
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("tag");
            net.one97.paytm.referral.d.a aVar2 = this.f19977a;
            if (aVar2 == null) {
                kotlin.g.b.k.a("referralViewModel");
            }
            aVar2.a(string);
        }
    }

    public static final class f implements net.one97.paytm.coins.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19988a;

        f(ReferralLandingActivity referralLandingActivity) {
            this.f19988a = referralLandingActivity;
        }

        public final void a() {
            this.f19988a.finish();
        }

        public final void b() {
            this.f19988a.b();
        }
    }

    /* access modifiers changed from: private */
    public final String c() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return "";
        }
        String string = extras.getString("tag");
        return string == null ? "" : string;
    }

    /* access modifiers changed from: private */
    public final String d() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return "";
        }
        String string = extras.getString("utm_source");
        return string == null ? "" : string;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 3) {
            return;
        }
        if (i3 != -1) {
            finish();
        } else if (com.paytm.utility.b.r((Context) this)) {
            b();
        } else {
            finish();
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.vipcashback.c.a.b().getBaseContext(context));
    }

    public final void a() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) a(R.id.noOfferAvailable);
        kotlin.g.b.k.a((Object) appCompatTextView, "noOfferAvailable");
        appCompatTextView.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) a(R.id.recyclerView);
        kotlin.g.b.k.a((Object) recyclerView, "recyclerView");
        recyclerView.setVisibility(8);
    }

    public final void onBackPressed() {
        net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
        net.one97.paytm.referral.c.b.a(this, d(), c(), "back_clicked", "", "");
        super.onBackPressed();
    }

    static final class j<T> implements z<TermsAndCondition> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralLandingActivity f19992a;

        j(ReferralLandingActivity referralLandingActivity) {
            this.f19992a = referralLandingActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            new net.one97.paytm.referral.b.b().show(this.f19992a.getSupportFragmentManager(), "t_and_c");
        }
    }

    public static final /* synthetic */ void a(ReferralLandingActivity referralLandingActivity, ReferralMain referralMain) {
        RecyclerView recyclerView = (RecyclerView) referralLandingActivity.a(R.id.recyclerView);
        kotlin.g.b.k.a((Object) recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(referralLandingActivity));
        RecyclerView recyclerView2 = (RecyclerView) referralLandingActivity.a(R.id.recyclerView);
        kotlin.g.b.k.a((Object) recyclerView2, "recyclerView");
        Context applicationContext = referralLandingActivity.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        recyclerView2.setAdapter(new net.one97.paytm.referral.a.b(applicationContext, referralMain.getData(), referralLandingActivity.f19980d, referralLandingActivity.f19982f, referralLandingActivity.f19981e));
    }

    public static final /* synthetic */ void a(ReferralLandingActivity referralLandingActivity, String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("custom_campaign", "invite_campaign");
        hashMap.put("referral_unique_link", str);
        net.one97.paytm.vipcashback.c.a.b().generateBrandedLink(referralLandingActivity, "Invite", hashMap, referralLandingActivity.f19983g, i2);
    }

    public static final /* synthetic */ void a(ReferralLandingActivity referralLandingActivity, String str, boolean z) {
        String link;
        referralLandingActivity.runOnUiThread(new c(referralLandingActivity, str));
        if (z) {
            net.one97.paytm.referral.d.a aVar = referralLandingActivity.f19977a;
            if (aVar == null) {
                kotlin.g.b.k.a("referralViewModel");
            }
            AdditionProperty c2 = aVar.c();
            if (c2 != null) {
                CharSequence shortUrl = c2.getShortUrl();
                if ((shortUrl == null || p.a(shortUrl)) && (link = c2.getLink()) != null) {
                    if (referralLandingActivity.f19977a == null) {
                        kotlin.g.b.k.a("referralViewModel");
                    }
                    net.one97.paytm.referral.d.a.a(link, str, "ReferralLandingActivity");
                }
            }
        }
    }
}
