package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashbackCrossPromoData;
import net.one97.paytm.cashback.posttxn.CashbackDealData;

public class MerchantTasksItem extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "bonus_amount_earned")
    private String bonusAmountEarned;
    @b(a = "cap_bonus_amount")
    private int capBonusAmount;
    @b(a = "crosspromo_data")
    private ArrayList<CashbackCrossPromoData> cashbackCrossPromoData;
    @b(a = "deal_data")
    private CashbackDealData cashbackDealData;
    @b(a = "frontend_redemption_type")
    private String frontendRedemptionType;
    @b(a = "gratification_processed")
    private boolean gratificationProcessed;
    @b(a = "gratification_type_flat")
    private String gratificationTypeFlat;
    @b(a = "redemption_status")
    private String redemptionStatus;
    @b(a = "redemption_text")
    private String redemptionText;
    @b(a = "redemption_type")
    private String redemptionType;
    @b(a = "redemption_type_icon_url")
    private String redemptionTypeIconUrl;
    @b(a = "rrn_no")
    private String rrnNo;
    @b(a = "stage_redemption_type")
    private String stageRedemptionType;

    public CashbackDealData getCashbackDealData() {
        return this.cashbackDealData;
    }

    public ArrayList<CashbackCrossPromoData> getCashbackCrossPromoData() {
        return this.cashbackCrossPromoData;
    }

    public int getCapBonusAmount() {
        return this.capBonusAmount;
    }

    public boolean isGratificationProcessed() {
        return this.gratificationProcessed;
    }

    public String getRrnNo() {
        return this.rrnNo;
    }

    public String getGratificationTypeFlat() {
        return this.gratificationTypeFlat;
    }

    public String getRedemptionText() {
        return this.redemptionText;
    }

    public String getFrontendRedemptionType() {
        return this.frontendRedemptionType;
    }

    public String getBonusAmountEarned() {
        return this.bonusAmountEarned;
    }

    public String getRedemptionTypeIconUrl() {
        return this.redemptionTypeIconUrl;
    }

    public String getStageRedemptionType() {
        return this.stageRedemptionType;
    }

    public String getRedemptionStatus() {
        return this.redemptionStatus;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public void setRedemptionType(String str) {
        this.redemptionType = str;
    }
}
