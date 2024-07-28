package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CampaignInnerReferralData extends IJRPaytmDataModel {
    @b(a = "deeplink_text")
    private String deepLinkText;
    @b(a = "deeplink_url")
    private String deeplinkUrl;

    public static /* synthetic */ CampaignInnerReferralData copy$default(CampaignInnerReferralData campaignInnerReferralData, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = campaignInnerReferralData.deeplinkUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = campaignInnerReferralData.deepLinkText;
        }
        return campaignInnerReferralData.copy(str, str2);
    }

    public final String component1() {
        return this.deeplinkUrl;
    }

    public final String component2() {
        return this.deepLinkText;
    }

    public final CampaignInnerReferralData copy(String str, String str2) {
        return new CampaignInnerReferralData(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignInnerReferralData)) {
            return false;
        }
        CampaignInnerReferralData campaignInnerReferralData = (CampaignInnerReferralData) obj;
        return k.a((Object) this.deeplinkUrl, (Object) campaignInnerReferralData.deeplinkUrl) && k.a((Object) this.deepLinkText, (Object) campaignInnerReferralData.deepLinkText);
    }

    public final int hashCode() {
        String str = this.deeplinkUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deepLinkText;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CampaignInnerReferralData(deeplinkUrl=" + this.deeplinkUrl + ", deepLinkText=" + this.deepLinkText + ")";
    }

    public final String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public final void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }

    public final String getDeepLinkText() {
        return this.deepLinkText;
    }

    public final void setDeepLinkText(String str) {
        this.deepLinkText = str;
    }

    public CampaignInnerReferralData(String str, String str2) {
        this.deeplinkUrl = str;
        this.deepLinkText = str2;
    }
}
