package net.one97.paytm.referral.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.referral.model.CampaignInnerReferralData;
import net.one97.paytm.referral.model.CampaignReferral;
import net.one97.paytm.referral.model.OTCLink;
import net.one97.paytm.referral.model.OtherCampaignLink;
import net.one97.paytm.referral.model.TermsAndCondition;
import net.one97.paytm.referral.model.TermsAndConditionData;
import net.one97.paytm.vipcashback.R;

public final class ReferralOfferActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public CampaignReferral f19997a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.referral.d.a f19998b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.g.a.m<String, Integer, Object> f19999c = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f20000d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f20001e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f20002f;

    public final View a(int i2) {
        if (this.f20002f == null) {
            this.f20002f = new HashMap();
        }
        View view = (View) this.f20002f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20002f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.m<String, Integer, x> {
        final /* synthetic */ ReferralOfferActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ReferralOfferActivity referralOfferActivity) {
            super(2);
            this.this$0 = referralOfferActivity;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, ((Number) obj2).intValue());
            return x.f47997a;
        }

        public final void invoke(String str, int i2) {
            kotlin.g.b.k.c(str, "url");
            ReferralOfferActivity.a(this.this$0, str, i2, true);
        }
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20005a;

        c(ReferralOfferActivity referralOfferActivity) {
            this.f20005a = referralOfferActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "isShowOrHide");
            if (bool.booleanValue()) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f20005a.a(R.id.loader));
            } else {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20005a.a(R.id.loader));
            }
        }
    }

    static final class j<T> implements z<TermsAndCondition> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20012a;

        j(ReferralOfferActivity referralOfferActivity) {
            this.f20012a = referralOfferActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            TermsAndConditionData data = ((TermsAndCondition) obj).getData();
            if (data != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20012a.a(R.id.terms_title);
                kotlin.g.b.k.a((Object) appCompatTextView, "terms_title");
                appCompatTextView.setText(data.getTermsTitle());
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.f20012a.a(R.id.termsAndConditions);
                kotlin.g.b.k.a((Object) appCompatTextView2, "termsAndConditions");
                String terms = data.getTerms();
                appCompatTextView2.setText(terms != null ? ReferralOfferActivity.a(terms) : null);
            }
        }
    }

    static final class m<T> implements z<OtherCampaignLink> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20015a;

        m(ReferralOfferActivity referralOfferActivity) {
            this.f20015a = referralOfferActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String shortUrl;
            OTCLink data;
            String link;
            OtherCampaignLink otherCampaignLink = (OtherCampaignLink) obj;
            String str = null;
            OTCLink data2 = otherCampaignLink != null ? otherCampaignLink.getData() : null;
            if (data2 != null) {
                str = data2.getShortUrl();
            }
            CharSequence charSequence = str;
            if (charSequence == null || p.a(charSequence)) {
                int i2 = 8;
                if (otherCampaignLink == null || (data = otherCampaignLink.getData()) == null || (link = data.getLink()) == null) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.f20015a.a(R.id.invite_box_relativeLayout);
                    kotlin.g.b.k.a((Object) relativeLayout, "invite_box_relativeLayout");
                    relativeLayout.setVisibility(8);
                    return;
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) this.f20015a.a(R.id.invite_box_relativeLayout);
                kotlin.g.b.k.a((Object) relativeLayout2, "invite_box_relativeLayout");
                CharSequence charSequence2 = link;
                if (!p.a(charSequence2)) {
                    i2 = 0;
                }
                relativeLayout2.setVisibility(i2);
                if (!p.a(charSequence2)) {
                    ReferralOfferActivity referralOfferActivity = this.f20015a;
                    ReferralOfferActivity.a(referralOfferActivity, link, referralOfferActivity.f20000d);
                }
            } else if (data2 != null && (shortUrl = data2.getShortUrl()) != null) {
                ReferralOfferActivity.a(this.f20015a, shortUrl, 1000, false);
            }
        }
    }

    static final class n<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20016a;

        n(ReferralOfferActivity referralOfferActivity) {
            this.f20016a = referralOfferActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if ((num != null && num.intValue() == 410) || ((num != null && num.intValue() == 401) || (num != null && num.intValue() == 403))) {
                Bundle bundle = new Bundle();
                bundle.putString("campaign_name", this.f20016a.a().getCampaign());
                net.one97.paytm.vipcashback.c.a.b().showSessionTimeOutAlert(this.f20016a, (String) null, bundle, new NetworkCustomError(), false, true);
            }
        }
    }

    public final CampaignReferral a() {
        CampaignReferral campaignReferral = this.f19997a;
        if (campaignReferral == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        return campaignReferral;
    }

    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(R.layout.activity_referral_offer);
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.referral.d.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ralViewModel::class.java]");
        this.f19998b = (net.one97.paytm.referral.d.a) a2;
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            Serializable serializable = extras.getSerializable("campaign_referral");
            if (serializable != null) {
                this.f19997a = (CampaignReferral) serializable;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.referral.model.CampaignReferral");
            }
        }
        net.one97.paytm.referral.d.a aVar = this.f19998b;
        if (aVar == null) {
            kotlin.g.b.k.a("mReferralViewModel");
        }
        q qVar = this;
        aVar.f20033d.observe(qVar, new n(this));
        net.one97.paytm.referral.d.a aVar2 = this.f19998b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("mReferralViewModel");
        }
        aVar2.f20032c.observe(qVar, new c(this));
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            net.one97.paytm.referral.d.a aVar3 = this.f19998b;
            if (aVar3 == null) {
                kotlin.g.b.k.a("mReferralViewModel");
            }
            CampaignReferral campaignReferral = this.f19997a;
            if (campaignReferral == null) {
                kotlin.g.b.k.a("mCampaignReferral");
            }
            String campaign = campaignReferral.getCampaign();
            kotlin.g.b.k.a((Object) campaign, "mCampaignReferral.campaign");
            aVar3.c(campaign);
            net.one97.paytm.referral.d.a aVar4 = this.f19998b;
            if (aVar4 == null) {
                kotlin.g.b.k.a("mReferralViewModel");
            }
            CampaignReferral campaignReferral2 = this.f19997a;
            if (campaignReferral2 == null) {
                kotlin.g.b.k.a("mCampaignReferral");
            }
            String tnc = campaignReferral2.getTnc();
            kotlin.g.b.k.a((Object) tnc, "mCampaignReferral.tnc");
            aVar4.b(tnc);
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.invite_box_relativeLayout);
            kotlin.g.b.k.a((Object) relativeLayout, "invite_box_relativeLayout");
            relativeLayout.setVisibility(8);
        }
        net.one97.paytm.referral.d.a aVar5 = this.f19998b;
        if (aVar5 == null) {
            kotlin.g.b.k.a("mReferralViewModel");
        }
        aVar5.f20031b.observe(qVar, new m(this));
        net.one97.paytm.referral.d.a aVar6 = this.f19998b;
        if (aVar6 == null) {
            kotlin.g.b.k.a("mReferralViewModel");
        }
        aVar6.f20034e.observe(qVar, new j(this));
        CampaignReferral campaignReferral3 = this.f19997a;
        if (campaignReferral3 == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        String newOffersImageUrl = campaignReferral3.getNewOffersImageUrl();
        if (newOffersImageUrl != null) {
            w.a().a(newOffersImageUrl).a((ImageView) (AppCompatImageView) a(R.id.iv_offer));
        }
        CampaignReferral campaignReferral4 = this.f19997a;
        if (campaignReferral4 == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        String offerKeyword = campaignReferral4.getOfferKeyword();
        if (offerKeyword != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) a(R.id.campaign_heading);
            kotlin.g.b.k.a((Object) appCompatTextView, "campaign_heading");
            appCompatTextView.setText(offerKeyword);
        }
        CampaignReferral campaignReferral5 = this.f19997a;
        if (campaignReferral5 == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        String offerTextOverride = campaignReferral5.getOfferTextOverride();
        if (offerTextOverride != null) {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) a(R.id.campaign_title);
            kotlin.g.b.k.a((Object) appCompatTextView2, "campaign_title");
            appCompatTextView2.setText(offerTextOverride);
        }
        CampaignReferral campaignReferral6 = this.f19997a;
        if (campaignReferral6 == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        String shortDescription = campaignReferral6.getShortDescription();
        if (shortDescription != null) {
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) a(R.id.campaign_description);
            kotlin.g.b.k.a((Object) appCompatTextView3, "campaign_description");
            appCompatTextView3.setText(shortDescription);
        }
        CampaignReferral campaignReferral7 = this.f19997a;
        if (campaignReferral7 == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        w.a().a(campaignReferral7.getBackgroundImageUrl()).a((ImageView) (AppCompatImageView) a(R.id.top_background_color));
        net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        if (!net.one97.paytm.referral.c.c.b("com.twitter.android", applicationContext)) {
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) a(R.id.btn_twitter);
            kotlin.g.b.k.a((Object) appCompatImageButton, "btn_twitter");
            appCompatImageButton.setVisibility(8);
        }
        net.one97.paytm.referral.c.c cVar2 = net.one97.paytm.referral.c.c.f20029a;
        Context applicationContext2 = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext2, "applicationContext");
        if (!net.one97.paytm.referral.c.c.b(AppConstants.WHATS_APP, applicationContext2)) {
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) a(R.id.btn_whastapps);
            kotlin.g.b.k.a((Object) appCompatImageButton2, "btn_whastapps");
            appCompatImageButton2.setVisibility(8);
        }
        ((AppCompatImageView) a(R.id.back_arrow_detail)).setOnClickListener(new k(this));
        ((AppCompatImageButton) a(R.id.btn_whastapps)).setOnClickListener(new l(this));
        ((AppCompatImageButton) a(R.id.btn_sms)).setOnClickListener(new d(this));
        ((AppCompatImageButton) a(R.id.btn_twitter)).setOnClickListener(new e(this));
        ((AppCompatImageButton) a(R.id.more_button)).setOnClickListener(new f(this));
        ((AppCompatImageButton) a(R.id.copy_to_clipboard)).setOnClickListener(new g(this));
        ((RelativeLayout) a(R.id.invite_box_relativeLayout)).setOnClickListener(new h(this));
        ((AppCompatTextView) a(R.id.invite_text)).setOnClickListener(new i(this));
        ((NestedScrollView) a(R.id.scrollView)).setOnScrollChangeListener(new o(this));
        net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
        net.one97.paytm.referral.c.b.b(context, c(), b(), "secondary_page_load", d(), e());
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20013a;

        k(ReferralOfferActivity referralOfferActivity) {
            this.f20013a = referralOfferActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
            ReferralOfferActivity referralOfferActivity = this.f20013a;
            net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20013a.b(), "back_clicked", this.f20013a.d(), this.f20013a.e());
            this.f20013a.finish();
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20014a;

        l(ReferralOfferActivity referralOfferActivity) {
            this.f20014a = referralOfferActivity;
        }

        public final void onClick(View view) {
            if (ReferralOfferActivity.a(this.f20014a, 3)) {
                net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
                CampaignInnerReferralData campaignInnerReferralData = this.f20014a.a().getCampaignInnerReferralData();
                String deepLinkText = campaignInnerReferralData != null ? campaignInnerReferralData.getDeepLinkText() : null;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20014a.a(R.id.invite_text);
                kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
                String obj = appCompatTextView.getText().toString();
                Context applicationContext = this.f20014a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                net.one97.paytm.referral.c.c.d(deepLinkText, obj, applicationContext);
                net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
                ReferralOfferActivity referralOfferActivity = this.f20014a;
                net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20014a.b(), "wa_clicked", this.f20014a.d(), this.f20014a.e());
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20006a;

        d(ReferralOfferActivity referralOfferActivity) {
            this.f20006a = referralOfferActivity;
        }

        public final void onClick(View view) {
            if (ReferralOfferActivity.a(this.f20006a, 2)) {
                net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
                CampaignInnerReferralData campaignInnerReferralData = this.f20006a.a().getCampaignInnerReferralData();
                String deepLinkText = campaignInnerReferralData != null ? campaignInnerReferralData.getDeepLinkText() : null;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20006a.a(R.id.invite_text);
                kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
                String obj = appCompatTextView.getText().toString();
                Context applicationContext = this.f20006a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                net.one97.paytm.referral.c.c.c(deepLinkText, obj, applicationContext);
                net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
                ReferralOfferActivity referralOfferActivity = this.f20006a;
                net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20006a.b(), "sms_clicked", this.f20006a.d(), this.f20006a.e());
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20007a;

        e(ReferralOfferActivity referralOfferActivity) {
            this.f20007a = referralOfferActivity;
        }

        public final void onClick(View view) {
            if (ReferralOfferActivity.a(this.f20007a, 1)) {
                net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
                CampaignInnerReferralData campaignInnerReferralData = this.f20007a.a().getCampaignInnerReferralData();
                String deepLinkText = campaignInnerReferralData != null ? campaignInnerReferralData.getDeepLinkText() : null;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20007a.a(R.id.invite_text);
                kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
                String obj = appCompatTextView.getText().toString();
                Context applicationContext = this.f20007a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                net.one97.paytm.referral.c.c.b(deepLinkText, obj, applicationContext);
                net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
                ReferralOfferActivity referralOfferActivity = this.f20007a;
                net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20007a.b(), "twitter_clicked", this.f20007a.d(), this.f20007a.e());
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20008a;

        f(ReferralOfferActivity referralOfferActivity) {
            this.f20008a = referralOfferActivity;
        }

        public final void onClick(View view) {
            if (ReferralOfferActivity.a(this.f20008a, 4)) {
                net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
                CampaignInnerReferralData campaignInnerReferralData = this.f20008a.a().getCampaignInnerReferralData();
                String deepLinkText = campaignInnerReferralData != null ? campaignInnerReferralData.getDeepLinkText() : null;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20008a.a(R.id.invite_text);
                kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
                String obj = appCompatTextView.getText().toString();
                Context applicationContext = this.f20008a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                net.one97.paytm.referral.c.c.a(deepLinkText, obj, applicationContext);
                net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
                ReferralOfferActivity referralOfferActivity = this.f20008a;
                net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20008a.b(), "more_clicked", this.f20008a.d(), this.f20008a.e());
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20009a;

        g(ReferralOfferActivity referralOfferActivity) {
            this.f20009a = referralOfferActivity;
        }

        public final void onClick(View view) {
            if (ReferralOfferActivity.a(this.f20009a, 5)) {
                net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20009a.a(R.id.invite_text);
                kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
                String obj = appCompatTextView.getText().toString();
                Context applicationContext = this.f20009a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                net.one97.paytm.referral.c.c.a(obj, applicationContext);
                net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
                ReferralOfferActivity referralOfferActivity = this.f20009a;
                net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20009a.b(), "copy_clicked", this.f20009a.d(), this.f20009a.e());
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20010a;

        h(ReferralOfferActivity referralOfferActivity) {
            this.f20010a = referralOfferActivity;
        }

        public final void onClick(View view) {
            if (ReferralOfferActivity.a(this.f20010a, 5)) {
                net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20010a.a(R.id.invite_text);
                kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
                String obj = appCompatTextView.getText().toString();
                Context applicationContext = this.f20010a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                net.one97.paytm.referral.c.c.a(obj, applicationContext);
                net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
                ReferralOfferActivity referralOfferActivity = this.f20010a;
                net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20010a.b(), "copy_clicked", this.f20010a.d(), this.f20010a.e());
            }
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20011a;

        i(ReferralOfferActivity referralOfferActivity) {
            this.f20011a = referralOfferActivity;
        }

        public final void onClick(View view) {
            if (ReferralOfferActivity.a(this.f20011a, 5)) {
                net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20011a.a(R.id.invite_text);
                kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
                String obj = appCompatTextView.getText().toString();
                Context applicationContext = this.f20011a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                net.one97.paytm.referral.c.c.a(obj, applicationContext);
                net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
                ReferralOfferActivity referralOfferActivity = this.f20011a;
                net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), this.f20011a.b(), "copy_clicked", this.f20011a.d(), this.f20011a.e());
            }
        }
    }

    static final class o implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20017a;

        o(ReferralOfferActivity referralOfferActivity) {
            this.f20017a = referralOfferActivity;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            ReferralOfferActivity referralOfferActivity = this.f20017a;
            referralOfferActivity.f20001e = referralOfferActivity.f20001e + (i3 - i5);
            if (this.f20017a.f20001e >= net.one97.paytm.coins.c.b.a(this.f20017a.getApplicationContext())) {
                this.f20017a.a(R.id.background_back_arrow_detail).setBackgroundColor(androidx.core.content.b.c(this.f20017a.getApplicationContext(), R.color.color_ffffff));
            } else {
                this.f20017a.a(R.id.background_back_arrow_detail).setBackgroundColor(androidx.core.content.b.c(this.f20017a.getApplicationContext(), R.color.transparent));
            }
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReferralOfferActivity f20003a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20004b;

        a(ReferralOfferActivity referralOfferActivity, int i2) {
            this.f20003a = referralOfferActivity;
            this.f20004b = i2;
        }

        public final void run() {
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.f20003a.a(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
            appCompatTextView.setText(this.f20003a.a().getGeneratedUrl());
            RelativeLayout relativeLayout = (RelativeLayout) this.f20003a.a(R.id.invite_box_relativeLayout);
            kotlin.g.b.k.a((Object) relativeLayout, "invite_box_relativeLayout");
            relativeLayout.setVisibility(0);
            ReferralOfferActivity.c(this.f20003a, this.f20004b);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        Bundle extras;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 3) {
            return;
        }
        if (i3 != -1) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.invite_box_relativeLayout);
            kotlin.g.b.k.a((Object) relativeLayout, "invite_box_relativeLayout");
            relativeLayout.setVisibility(8);
        } else if (intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("campaign_name");
            if (com.paytm.utility.b.c((Context) this)) {
                net.one97.paytm.referral.d.a aVar = this.f19998b;
                if (aVar == null) {
                    kotlin.g.b.k.a("mReferralViewModel");
                }
                kotlin.g.b.k.a((Object) string, "campaingName");
                aVar.c(string);
                return;
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.invite_box_relativeLayout);
            kotlin.g.b.k.a((Object) relativeLayout2, "invite_box_relativeLayout");
            relativeLayout2.setVisibility(8);
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.vipcashback.c.a.b().getBaseContext(context));
    }

    /* access modifiers changed from: private */
    public final String b() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return "";
        }
        String string = extras.getString("tag");
        return string == null ? "" : string;
    }

    /* access modifiers changed from: private */
    public final String c() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return "";
        }
        String string = extras.getString("utm_source");
        return string == null ? "" : string;
    }

    /* access modifiers changed from: private */
    public final String d() {
        CampaignReferral campaignReferral = this.f19997a;
        if (campaignReferral == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        String campaign = campaignReferral.getCampaign();
        return campaign == null ? "" : campaign;
    }

    /* access modifiers changed from: private */
    public final String e() {
        CampaignReferral campaignReferral = this.f19997a;
        if (campaignReferral == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        String valueOf = String.valueOf(campaignReferral.getId());
        return valueOf == null ? "" : valueOf;
    }

    public final void onBackPressed() {
        net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
        net.one97.paytm.referral.c.b.b(this, c(), b(), "back_clicked", d(), e());
        super.onBackPressed();
    }

    public static final /* synthetic */ Spanned a(String str) {
        return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
    }

    public static final /* synthetic */ boolean a(ReferralOfferActivity referralOfferActivity, int i2) {
        referralOfferActivity.f20000d = i2;
        CampaignReferral campaignReferral = referralOfferActivity.f19997a;
        if (campaignReferral == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        CharSequence generatedUrl = campaignReferral.getGeneratedUrl();
        if (!(generatedUrl == null || generatedUrl.length() == 0)) {
            return true;
        }
        net.one97.paytm.referral.d.a aVar = referralOfferActivity.f19998b;
        if (aVar == null) {
            kotlin.g.b.k.a("mReferralViewModel");
        }
        CampaignReferral campaignReferral2 = referralOfferActivity.f19997a;
        if (campaignReferral2 == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        String campaign = campaignReferral2.getCampaign();
        kotlin.g.b.k.a((Object) campaign, "mCampaignReferral.campaign");
        aVar.c(campaign);
        return false;
    }

    public static final /* synthetic */ void a(ReferralOfferActivity referralOfferActivity, String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("custom_campaign", "invite_campaign");
        hashMap.put("referral_unique_link", str);
        net.one97.paytm.vipcashback.c.a.b().generateBrandedLink(referralOfferActivity, "Invite", hashMap, referralOfferActivity.f19999c, i2);
    }

    public static final /* synthetic */ void a(ReferralOfferActivity referralOfferActivity, String str, int i2, boolean z) {
        String link;
        CampaignReferral campaignReferral = referralOfferActivity.f19997a;
        if (campaignReferral == null) {
            kotlin.g.b.k.a("mCampaignReferral");
        }
        campaignReferral.setGeneratedUrl(str);
        referralOfferActivity.runOnUiThread(new a(referralOfferActivity, i2));
        if (z) {
            net.one97.paytm.referral.d.a aVar = referralOfferActivity.f19998b;
            if (aVar == null) {
                kotlin.g.b.k.a("mReferralViewModel");
            }
            OtherCampaignLink value = aVar.f20031b.getValue();
            String str2 = null;
            OTCLink data = value != null ? value.getData() : null;
            if (data != null) {
                str2 = data.getShortUrl();
            }
            CharSequence charSequence = str2;
            if ((charSequence == null || p.a(charSequence)) && data != null && (link = data.getLink()) != null) {
                if (referralOfferActivity.f19998b == null) {
                    kotlin.g.b.k.a("mReferralViewModel");
                }
                net.one97.paytm.referral.d.a.a(link, str, "ReferralOfferActivity");
            }
        }
    }

    public static final /* synthetic */ void c(ReferralOfferActivity referralOfferActivity, int i2) {
        String str = null;
        if (i2 == 1) {
            net.one97.paytm.referral.c.c cVar = net.one97.paytm.referral.c.c.f20029a;
            CampaignReferral campaignReferral = referralOfferActivity.f19997a;
            if (campaignReferral == null) {
                kotlin.g.b.k.a("mCampaignReferral");
            }
            CampaignInnerReferralData campaignInnerReferralData = campaignReferral.getCampaignInnerReferralData();
            if (campaignInnerReferralData != null) {
                str = campaignInnerReferralData.getDeepLinkText();
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) referralOfferActivity.a(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView, "invite_text");
            String obj = appCompatTextView.getText().toString();
            Context applicationContext = referralOfferActivity.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
            net.one97.paytm.referral.c.c.b(str, obj, applicationContext);
            net.one97.paytm.referral.c.b bVar = net.one97.paytm.referral.c.b.f20028a;
            net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), referralOfferActivity.b(), "twitter_clicked", referralOfferActivity.d(), referralOfferActivity.e());
        } else if (i2 == 2) {
            net.one97.paytm.referral.c.c cVar2 = net.one97.paytm.referral.c.c.f20029a;
            CampaignReferral campaignReferral2 = referralOfferActivity.f19997a;
            if (campaignReferral2 == null) {
                kotlin.g.b.k.a("mCampaignReferral");
            }
            CampaignInnerReferralData campaignInnerReferralData2 = campaignReferral2.getCampaignInnerReferralData();
            if (campaignInnerReferralData2 != null) {
                str = campaignInnerReferralData2.getDeepLinkText();
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) referralOfferActivity.a(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView2, "invite_text");
            String obj2 = appCompatTextView2.getText().toString();
            Context applicationContext2 = referralOfferActivity.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext2, "applicationContext");
            net.one97.paytm.referral.c.c.c(str, obj2, applicationContext2);
            net.one97.paytm.referral.c.b bVar2 = net.one97.paytm.referral.c.b.f20028a;
            net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), referralOfferActivity.b(), "sms_clicked", referralOfferActivity.d(), referralOfferActivity.e());
        } else if (i2 == 3) {
            net.one97.paytm.referral.c.b bVar3 = net.one97.paytm.referral.c.b.f20028a;
            net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), referralOfferActivity.b(), "wa_clicked", referralOfferActivity.d(), referralOfferActivity.e());
            net.one97.paytm.referral.c.c cVar3 = net.one97.paytm.referral.c.c.f20029a;
            CampaignReferral campaignReferral3 = referralOfferActivity.f19997a;
            if (campaignReferral3 == null) {
                kotlin.g.b.k.a("mCampaignReferral");
            }
            CampaignInnerReferralData campaignInnerReferralData3 = campaignReferral3.getCampaignInnerReferralData();
            if (campaignInnerReferralData3 != null) {
                str = campaignInnerReferralData3.getDeepLinkText();
            }
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) referralOfferActivity.a(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView3, "invite_text");
            String obj3 = appCompatTextView3.getText().toString();
            Context applicationContext3 = referralOfferActivity.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext3, "applicationContext");
            net.one97.paytm.referral.c.c.d(str, obj3, applicationContext3);
        } else if (i2 == 4) {
            net.one97.paytm.referral.c.c cVar4 = net.one97.paytm.referral.c.c.f20029a;
            CampaignReferral campaignReferral4 = referralOfferActivity.f19997a;
            if (campaignReferral4 == null) {
                kotlin.g.b.k.a("mCampaignReferral");
            }
            CampaignInnerReferralData campaignInnerReferralData4 = campaignReferral4.getCampaignInnerReferralData();
            if (campaignInnerReferralData4 != null) {
                str = campaignInnerReferralData4.getDeepLinkText();
            }
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) referralOfferActivity.a(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView4, "invite_text");
            String obj4 = appCompatTextView4.getText().toString();
            Context applicationContext4 = referralOfferActivity.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext4, "applicationContext");
            net.one97.paytm.referral.c.c.a(str, obj4, applicationContext4);
            net.one97.paytm.referral.c.b bVar4 = net.one97.paytm.referral.c.b.f20028a;
            net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), referralOfferActivity.b(), "more_clicked", referralOfferActivity.d(), referralOfferActivity.e());
        } else if (i2 == 5) {
            net.one97.paytm.referral.c.c cVar5 = net.one97.paytm.referral.c.c.f20029a;
            AppCompatTextView appCompatTextView5 = (AppCompatTextView) referralOfferActivity.a(R.id.invite_text);
            kotlin.g.b.k.a((Object) appCompatTextView5, "invite_text");
            String obj5 = appCompatTextView5.getText().toString();
            Context applicationContext5 = referralOfferActivity.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext5, "applicationContext");
            net.one97.paytm.referral.c.c.a(obj5, applicationContext5);
            net.one97.paytm.referral.c.b bVar5 = net.one97.paytm.referral.c.b.f20028a;
            net.one97.paytm.referral.c.b.b(referralOfferActivity, referralOfferActivity.c(), referralOfferActivity.b(), "copy_clicked", referralOfferActivity.d(), referralOfferActivity.e());
        }
    }
}
