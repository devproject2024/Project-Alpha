package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class GratificationItem extends IJRPaytmDataModel {
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
    @b(a = "supercashGameData")
    private GameGratification gameGratification;
    @b(a = "progress_text")
    private String progressText;
    @b(a = "redemption_status")
    private String redemptionStatus;
    @b(a = "redemption_text")
    private String redemptionText;
    @b(a = "redemption_type")
    private String redemptionType;
    @b(a = "redemption_type_icon")
    private String redemptionTypeIcon;
    @b(a = "scratchCardData")
    private ScratchCardInfo scratchCardInfo;
    @b(a = "winnning_title")
    private String winnningTitle;

    public String getEarnedText() {
        return this.earnedText;
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

    public String getRedemptionTypeIcon() {
        return this.redemptionTypeIcon;
    }

    public CashbackDealData getCashbackDealData() {
        return this.cashbackDealData;
    }

    public void setRedemptionTypeIcon(String str) {
        this.redemptionTypeIcon = str;
    }

    public void setCashbackDealData(CashbackDealData cashbackDealData2) {
        this.cashbackDealData = cashbackDealData2;
    }

    public ScratchCardInfo getScratchCardInfo() {
        return this.scratchCardInfo;
    }

    public String getWinnningTitle() {
        return this.winnningTitle;
    }

    public String getProgressText() {
        return this.progressText;
    }

    public String getBonusAmount() {
        return this.bonusAmount;
    }

    public GameGratification getGameGratification() {
        return this.gameGratification;
    }
}
