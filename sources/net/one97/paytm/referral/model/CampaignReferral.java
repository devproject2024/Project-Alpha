package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.cashback.posttxn.Campaign;

public final class CampaignReferral extends Campaign {
    @b(a = "referral_data")
    private CampaignInnerReferralData campaignInnerReferralData;
    private String generatedUrl;

    public static /* synthetic */ CampaignReferral copy$default(CampaignReferral campaignReferral, String str, CampaignInnerReferralData campaignInnerReferralData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = campaignReferral.generatedUrl;
        }
        if ((i2 & 2) != 0) {
            campaignInnerReferralData2 = campaignReferral.campaignInnerReferralData;
        }
        return campaignReferral.copy(str, campaignInnerReferralData2);
    }

    public final String component1() {
        return this.generatedUrl;
    }

    public final CampaignInnerReferralData component2() {
        return this.campaignInnerReferralData;
    }

    public final CampaignReferral copy(String str, CampaignInnerReferralData campaignInnerReferralData2) {
        return new CampaignReferral(str, campaignInnerReferralData2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignReferral)) {
            return false;
        }
        CampaignReferral campaignReferral = (CampaignReferral) obj;
        return k.a((Object) this.generatedUrl, (Object) campaignReferral.generatedUrl) && k.a((Object) this.campaignInnerReferralData, (Object) campaignReferral.campaignInnerReferralData);
    }

    public final int hashCode() {
        String str = this.generatedUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CampaignInnerReferralData campaignInnerReferralData2 = this.campaignInnerReferralData;
        if (campaignInnerReferralData2 != null) {
            i2 = campaignInnerReferralData2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CampaignReferral(generatedUrl=" + this.generatedUrl + ", campaignInnerReferralData=" + this.campaignInnerReferralData + ")";
    }

    public final String getGeneratedUrl() {
        return this.generatedUrl;
    }

    public final void setGeneratedUrl(String str) {
        this.generatedUrl = str;
    }

    public CampaignReferral(String str, CampaignInnerReferralData campaignInnerReferralData2) {
        this.generatedUrl = str;
        this.campaignInnerReferralData = campaignInnerReferralData2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CampaignReferral(String str, CampaignInnerReferralData campaignInnerReferralData2, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? null : campaignInnerReferralData2);
    }

    public final CampaignInnerReferralData getCampaignInnerReferralData() {
        return this.campaignInnerReferralData;
    }

    public final void setCampaignInnerReferralData(CampaignInnerReferralData campaignInnerReferralData2) {
        this.campaignInnerReferralData = campaignInnerReferralData2;
    }
}
