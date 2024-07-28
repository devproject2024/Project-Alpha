package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ReferralData extends IJRPaytmDataModel {
    @b(a = "bonus_detail")
    private ArrayList<BonusDetail> bonus_detail;
    @b(a = "campaigns")
    private ArrayList<CampaignReferral> campaigns;
    @b(a = "invite_text")
    private String invite_text;
    @b(a = "referral_links")
    private HashMap<String, AdditionProperty> referral_links;

    public ReferralData() {
        this((ArrayList) null, (HashMap) null, (ArrayList) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ ReferralData copy$default(ReferralData referralData, ArrayList<CampaignReferral> arrayList, HashMap<String, AdditionProperty> hashMap, ArrayList<BonusDetail> arrayList2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = referralData.campaigns;
        }
        if ((i2 & 2) != 0) {
            hashMap = referralData.referral_links;
        }
        if ((i2 & 4) != 0) {
            arrayList2 = referralData.bonus_detail;
        }
        if ((i2 & 8) != 0) {
            str = referralData.invite_text;
        }
        return referralData.copy(arrayList, hashMap, arrayList2, str);
    }

    public final ArrayList<CampaignReferral> component1() {
        return this.campaigns;
    }

    public final HashMap<String, AdditionProperty> component2() {
        return this.referral_links;
    }

    public final ArrayList<BonusDetail> component3() {
        return this.bonus_detail;
    }

    public final String component4() {
        return this.invite_text;
    }

    public final ReferralData copy(ArrayList<CampaignReferral> arrayList, HashMap<String, AdditionProperty> hashMap, ArrayList<BonusDetail> arrayList2, String str) {
        return new ReferralData(arrayList, hashMap, arrayList2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReferralData)) {
            return false;
        }
        ReferralData referralData = (ReferralData) obj;
        return k.a((Object) this.campaigns, (Object) referralData.campaigns) && k.a((Object) this.referral_links, (Object) referralData.referral_links) && k.a((Object) this.bonus_detail, (Object) referralData.bonus_detail) && k.a((Object) this.invite_text, (Object) referralData.invite_text);
    }

    public final int hashCode() {
        ArrayList<CampaignReferral> arrayList = this.campaigns;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        HashMap<String, AdditionProperty> hashMap = this.referral_links;
        int hashCode2 = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        ArrayList<BonusDetail> arrayList2 = this.bonus_detail;
        int hashCode3 = (hashCode2 + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        String str = this.invite_text;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ReferralData(campaigns=" + this.campaigns + ", referral_links=" + this.referral_links + ", bonus_detail=" + this.bonus_detail + ", invite_text=" + this.invite_text + ")";
    }

    public final ArrayList<CampaignReferral> getCampaigns() {
        return this.campaigns;
    }

    public final void setCampaigns(ArrayList<CampaignReferral> arrayList) {
        this.campaigns = arrayList;
    }

    public final HashMap<String, AdditionProperty> getReferral_links() {
        return this.referral_links;
    }

    public final void setReferral_links(HashMap<String, AdditionProperty> hashMap) {
        this.referral_links = hashMap;
    }

    public final ArrayList<BonusDetail> getBonus_detail() {
        return this.bonus_detail;
    }

    public final void setBonus_detail(ArrayList<BonusDetail> arrayList) {
        this.bonus_detail = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReferralData(ArrayList arrayList, HashMap hashMap, ArrayList arrayList2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, (i2 & 2) != 0 ? null : hashMap, (i2 & 4) != 0 ? null : arrayList2, (i2 & 8) != 0 ? null : str);
    }

    public final String getInvite_text() {
        return this.invite_text;
    }

    public final void setInvite_text(String str) {
        this.invite_text = str;
    }

    public ReferralData(ArrayList<CampaignReferral> arrayList, HashMap<String, AdditionProperty> hashMap, ArrayList<BonusDetail> arrayList2, String str) {
        this.campaigns = arrayList;
        this.referral_links = hashMap;
        this.bonus_detail = arrayList2;
        this.invite_text = str;
    }
}
