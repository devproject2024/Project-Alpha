package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.cashback.posttxn.CashbackCrossPromoData;
import net.one97.paytm.cashback.posttxn.CashbackDealData;

public class CashbackStageItem extends IJRPaytmDataModel {
    @b(a = "bonus_amount")
    private String bonusAmount;
    @b(a = "crosspromo_data")
    private CashbackCrossPromoData cashbackCrossPromoData;
    @b(a = "deal_data")
    private CashbackDealData cashbackDealData;
    @b(a = "cashback_text")
    private String cashbackText;
    @b(a = "earned_text")
    private String earnedText;
    @b(a = "frontend_redemption_type")
    private String frontendRedemptionType;
    @b(a = "redemption_status")
    private String redemptionStatus;
    @b(a = "redemption_text")
    private String redemptionText;
    @b(a = "redemption_type")
    private String redemptionType;
    @b(a = "redemption_type_icon")
    private String redemptionTypeIcon;
    @b(a = "stage_status")
    private String stageStatus;
    @b(a = "surprise_stage")
    private boolean surpriseStage;

    public String getEarnedText() {
        return this.earnedText;
    }

    public String getBonusAmount() {
        return this.bonusAmount;
    }

    public String getStageStatus() {
        return this.stageStatus;
    }

    public String getCashbackText() {
        return this.cashbackText;
    }

    public String getRedemptionText() {
        return this.redemptionText;
    }

    public String getRedemptionStatus() {
        return this.redemptionStatus;
    }

    public CashbackCrossPromoData getCashbackCrossPromoData() {
        return this.cashbackCrossPromoData;
    }

    public String getFrontendRedemptionType() {
        return this.frontendRedemptionType;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public boolean isSurpriseStage() {
        return this.surpriseStage;
    }

    public CashbackDealData getCashbackDealData() {
        return this.cashbackDealData;
    }

    public void setBonusAmount(String str) {
        this.bonusAmount = str;
    }

    public String getRedemptionTypeIcon() {
        return this.redemptionTypeIcon;
    }

    public void setRedemptionTypeIcon(String str) {
        this.redemptionTypeIcon = str;
    }

    public void setCashbackDealData(CashbackDealData cashbackDealData2) {
        this.cashbackDealData = cashbackDealData2;
    }
}
