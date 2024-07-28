package net.one97.paytm.referral.d;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.referral.model.AdditionProperty;
import net.one97.paytm.referral.model.CampaignReferral;
import net.one97.paytm.referral.model.OTCLink;
import net.one97.paytm.referral.model.OtherCampaignLink;
import net.one97.paytm.referral.model.ReferralData;
import net.one97.paytm.referral.model.ReferralMain;
import net.one97.paytm.referral.model.TermsAndCondition;
import net.one97.paytm.referral.model.TermsAndConditionData;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<ReferralMain> f20030a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<OtherCampaignLink> f20031b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f20032c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Integer> f20033d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<TermsAndCondition> f20034e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<Boolean> f20035f = new y<>();

    public final void a(String str) {
        this.f20032c.postValue(Boolean.TRUE);
        StringBuilder sb = new StringBuilder();
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        sb.append(f.R());
        sb.append("?tag=");
        sb.append(str);
        String sb2 = sb.toString();
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        d.a.c().a(a.C0715a.GET).a(sb2).b((String) null).a((Map<String, String>) d()).a((IJRPaytmDataModel) new ReferralMain((String) null, (ArrayList) null, (ReferralData) null, 7, (g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("ReferralLandingActivity").a((com.paytm.network.listener.b) new b(this)).l().a();
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20037a;

        b(a aVar) {
            this.f20037a = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f20037a.f20032c.postValue(Boolean.FALSE);
            if (iJRPaytmDataModel == null) {
                this.f20037a.f20035f.postValue(Boolean.TRUE);
            } else if (iJRPaytmDataModel instanceof ReferralMain) {
                this.f20037a.f20030a.postValue(iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "p1");
            k.c(networkCustomError, "p2");
            this.f20037a.f20032c.postValue(Boolean.FALSE);
            this.f20037a.f20033d.postValue(Integer.valueOf(i2));
        }
    }

    public final void b(String str) {
        k.c(str, "termsUrl");
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        com.paytm.network.a l = d.a.c().a(a.C0715a.GET).a(str).a((IJRPaytmDataModel) new TermsAndCondition((String) null, (ArrayList) null, (TermsAndConditionData) null, 7, (g) null)).c("ReferralOfferActivity").a((com.paytm.network.listener.b) new c(this)).l();
        if (l != null) {
            l.a();
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20038a;

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }

        c(a aVar) {
            this.f20038a = aVar;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y e2 = this.f20038a.f20034e;
            if (iJRPaytmDataModel != null) {
                e2.postValue((TermsAndCondition) iJRPaytmDataModel);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.referral.model.TermsAndCondition");
        }
    }

    public final void c(String str) {
        k.c(str, "campaignName");
        this.f20032c.postValue(Boolean.TRUE);
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String str2 = (f.S() + "?identifier=") + str;
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        com.paytm.network.a l = d.a.c().a(a.C0715a.POST).a(str2).b((String) null).a((Map<String, String>) d()).a((IJRPaytmDataModel) new OtherCampaignLink((String) null, (ArrayList) null, (OTCLink) null, 7, (g) null)).a(a.c.CASHBACK).a(a.b.USER_FACING).c("ReferralLandingActivity").a((com.paytm.network.listener.b) new C0353a(this)).l();
        if (l != null) {
            l.a();
        }
    }

    /* renamed from: net.one97.paytm.referral.d.a$a  reason: collision with other inner class name */
    public static final class C0353a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20036a;

        C0353a(a aVar) {
            this.f20036a = aVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f20036a.f20033d.postValue(Integer.valueOf(i2));
            this.f20036a.f20032c.postValue(Boolean.FALSE);
            this.f20036a.f20031b.postValue(new OtherCampaignLink((String) null, (ArrayList) null, (OTCLink) null, 7, (g) null));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel == null) {
                this.f20036a.f20031b.postValue(new OtherCampaignLink((String) null, (ArrayList) null, (OTCLink) null, 7, (g) null));
            } else if (iJRPaytmDataModel instanceof OtherCampaignLink) {
                this.f20036a.f20031b.postValue(iJRPaytmDataModel);
            } else {
                this.f20036a.f20031b.postValue(new OtherCampaignLink((String) null, (ArrayList) null, (OTCLink) null, 7, (g) null));
            }
            this.f20036a.f20032c.postValue(Boolean.FALSE);
        }
    }

    public static void a(String str, String str2, String str3) {
        k.c(str, "link");
        k.c(str2, "shortUrl");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String str4 = (((f.X() + "?link=") + str) + "&short_url=") + str2;
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        com.paytm.network.a l = d.a.c().a(a.C0715a.POST).a(str4).b((String) null).a((Map<String, String>) d()).a((IJRPaytmDataModel) new OtherCampaignLink((String) null, (ArrayList) null, (OTCLink) null, 7, (g) null)).a(a.c.CASHBACK).a(a.b.SILENT).c(str3).a((com.paytm.network.listener.b) new d()).l();
        if (l != null) {
            l.a();
        }
    }

    public static final class d implements com.paytm.network.listener.b {
        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        }

        d() {
        }
    }

    private static HashMap<String, String> d() {
        net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
        k.a((Object) b2, "CashbackHelper.getImplListener()");
        HashMap<String, String> appCommonHeaders = b2.getAppCommonHeaders();
        if (appCommonHeaders == null) {
            appCommonHeaders = new HashMap<>();
        }
        appCommonHeaders.put("Content-Type", "application/json");
        net.one97.paytm.vipcashback.c.b b3 = net.one97.paytm.vipcashback.c.a.b();
        k.a((Object) b3, "CashbackHelper.getImplListener()");
        appCommonHeaders.put(AppConstants.SSO_TOKEN, b3.getSSOToken());
        return appCommonHeaders;
    }

    public final AdditionProperty c() {
        ReferralData data;
        ArrayList<CampaignReferral> campaigns;
        CampaignReferral campaignReferral;
        String campaign;
        ReferralMain value;
        ReferralData data2;
        HashMap<String, AdditionProperty> referral_links;
        ReferralMain value2 = this.f20030a.getValue();
        if (value2 == null || (data = value2.getData()) == null || (campaigns = data.getCampaigns()) == null || (campaignReferral = campaigns.get(0)) == null || (campaign = campaignReferral.getCampaign()) == null || (value = this.f20030a.getValue()) == null || (data2 = value.getData()) == null || (referral_links = data2.getReferral_links()) == null) {
            return null;
        }
        return referral_links.get(campaign);
    }

    public final String a() {
        ReferralMain value;
        ReferralData data;
        ArrayList<CampaignReferral> campaigns;
        ReferralMain value2;
        ReferralData data2;
        ArrayList<CampaignReferral> campaigns2;
        CampaignReferral campaignReferral;
        String campaign;
        y<ReferralMain> yVar = this.f20030a;
        if (yVar == null || (value = yVar.getValue()) == null || (data = value.getData()) == null || (campaigns = data.getCampaigns()) == null || campaigns.size() <= 0) {
            return "";
        }
        y<ReferralMain> yVar2 = this.f20030a;
        if (yVar2 == null || (value2 = yVar2.getValue()) == null || (data2 = value2.getData()) == null || (campaigns2 = data2.getCampaigns()) == null || (campaignReferral = campaigns2.get(0)) == null || (campaign = campaignReferral.getCampaign()) == null) {
            return "";
        }
        return campaign;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r0 = (r0 = (r0 = (r0 = r0.getValue()).getData()).getCampaigns()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b() {
        /*
            r3 = this;
            androidx.lifecycle.y<net.one97.paytm.referral.model.ReferralMain> r0 = r3.f20030a
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0053
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.referral.model.ReferralMain r0 = (net.one97.paytm.referral.model.ReferralMain) r0
            if (r0 == 0) goto L_0x0053
            net.one97.paytm.referral.model.ReferralData r0 = r0.getData()
            if (r0 == 0) goto L_0x0053
            java.util.ArrayList r0 = r0.getCampaigns()
            if (r0 == 0) goto L_0x0053
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0053
            androidx.lifecycle.y<net.one97.paytm.referral.model.ReferralMain> r0 = r3.f20030a
            if (r0 == 0) goto L_0x004a
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.referral.model.ReferralMain r0 = (net.one97.paytm.referral.model.ReferralMain) r0
            if (r0 == 0) goto L_0x004a
            net.one97.paytm.referral.model.ReferralData r0 = r0.getData()
            if (r0 == 0) goto L_0x004a
            java.util.ArrayList r0 = r0.getCampaigns()
            if (r0 == 0) goto L_0x004a
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.referral.model.CampaignReferral r0 = (net.one97.paytm.referral.model.CampaignReferral) r0
            if (r0 == 0) goto L_0x004a
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x004b
        L_0x004a:
            r0 = 0
        L_0x004b:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            if (r0 != 0) goto L_0x0052
            r0 = r1
        L_0x0052:
            return r0
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.d.a.b():java.lang.String");
    }
}
