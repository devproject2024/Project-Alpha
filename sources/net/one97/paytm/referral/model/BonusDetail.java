package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class BonusDetail extends IJRPaytmDataModel {
    @b(a = "bonus_detail_screen_title")
    private String bonus_detail_screen_title;
    @b(a = "bonus_tile_icon")
    private String bonus_tile_icon;
    @b(a = "bonus_tile_title")
    private String bonus_tile_title;
    @b(a = "redemption_type")
    private String redemption_type;
    @b(a = "referee_info")
    private ArrayList<RefereeInfo> referee_info;
    @b(a = "total_bonus")
    private Integer total_bonus;

    public static /* synthetic */ BonusDetail copy$default(BonusDetail bonusDetail, Integer num, String str, String str2, String str3, String str4, ArrayList<RefereeInfo> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = bonusDetail.total_bonus;
        }
        if ((i2 & 2) != 0) {
            str = bonusDetail.bonus_tile_title;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = bonusDetail.bonus_tile_icon;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = bonusDetail.bonus_detail_screen_title;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = bonusDetail.redemption_type;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            arrayList = bonusDetail.referee_info;
        }
        return bonusDetail.copy(num, str5, str6, str7, str8, arrayList);
    }

    public final Integer component1() {
        return this.total_bonus;
    }

    public final String component2() {
        return this.bonus_tile_title;
    }

    public final String component3() {
        return this.bonus_tile_icon;
    }

    public final String component4() {
        return this.bonus_detail_screen_title;
    }

    public final String component5() {
        return this.redemption_type;
    }

    public final ArrayList<RefereeInfo> component6() {
        return this.referee_info;
    }

    public final BonusDetail copy(Integer num, String str, String str2, String str3, String str4, ArrayList<RefereeInfo> arrayList) {
        return new BonusDetail(num, str, str2, str3, str4, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BonusDetail)) {
            return false;
        }
        BonusDetail bonusDetail = (BonusDetail) obj;
        return k.a((Object) this.total_bonus, (Object) bonusDetail.total_bonus) && k.a((Object) this.bonus_tile_title, (Object) bonusDetail.bonus_tile_title) && k.a((Object) this.bonus_tile_icon, (Object) bonusDetail.bonus_tile_icon) && k.a((Object) this.bonus_detail_screen_title, (Object) bonusDetail.bonus_detail_screen_title) && k.a((Object) this.redemption_type, (Object) bonusDetail.redemption_type) && k.a((Object) this.referee_info, (Object) bonusDetail.referee_info);
    }

    public final int hashCode() {
        Integer num = this.total_bonus;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.bonus_tile_title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bonus_tile_icon;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bonus_detail_screen_title;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.redemption_type;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ArrayList<RefereeInfo> arrayList = this.referee_info;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "BonusDetail(total_bonus=" + this.total_bonus + ", bonus_tile_title=" + this.bonus_tile_title + ", bonus_tile_icon=" + this.bonus_tile_icon + ", bonus_detail_screen_title=" + this.bonus_detail_screen_title + ", redemption_type=" + this.redemption_type + ", referee_info=" + this.referee_info + ")";
    }

    public final Integer getTotal_bonus() {
        return this.total_bonus;
    }

    public final void setTotal_bonus(Integer num) {
        this.total_bonus = num;
    }

    public final String getBonus_tile_title() {
        return this.bonus_tile_title;
    }

    public final void setBonus_tile_title(String str) {
        this.bonus_tile_title = str;
    }

    public final String getBonus_tile_icon() {
        return this.bonus_tile_icon;
    }

    public final void setBonus_tile_icon(String str) {
        this.bonus_tile_icon = str;
    }

    public final String getBonus_detail_screen_title() {
        return this.bonus_detail_screen_title;
    }

    public final void setBonus_detail_screen_title(String str) {
        this.bonus_detail_screen_title = str;
    }

    public final String getRedemption_type() {
        return this.redemption_type;
    }

    public final void setRedemption_type(String str) {
        this.redemption_type = str;
    }

    public final ArrayList<RefereeInfo> getReferee_info() {
        return this.referee_info;
    }

    public final void setReferee_info(ArrayList<RefereeInfo> arrayList) {
        this.referee_info = arrayList;
    }

    public BonusDetail(Integer num, String str, String str2, String str3, String str4, ArrayList<RefereeInfo> arrayList) {
        this.total_bonus = num;
        this.bonus_tile_title = str;
        this.bonus_tile_icon = str2;
        this.bonus_detail_screen_title = str3;
        this.redemption_type = str4;
        this.referee_info = arrayList;
    }
}
