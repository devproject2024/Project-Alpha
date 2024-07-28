package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.Campaign;

public class MerchantGameItem extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "bonus_amount_earned")
    private int bonusAmountEarned;
    @b(a = "campaign")
    private Campaign campaign;
    @b(a = "created_at")
    private String createdAt;
    @b(a = "game_completion_time")
    private String gameCompletionTime;
    @b(a = "game_expiry")
    private String gameExpiry;
    @b(a = "game_expiry_reason_text")
    private String gameExpiryReasonText;
    @b(a = "game_gratification_message")
    private String gameGratificationMessage;
    @b(a = "game_status")
    private String gameStatus;
    @b(a = "initialized_offer_text")
    private String initializedOfferText;
    @b(a = "max_cap_bonus_amount_game")
    private int maxCapBonusAmountGame;
    @b(a = "stages")
    private ArrayList<MerchantStage> merchantStages;
    @b(a = "offer_completion_text")
    private String offerCompletionText;
    @b(a = "offer_id")
    private String offerId;
    @b(a = "offer_progress_construct")
    private String offerProgressConstruct;
    @b(a = "offer_remaining_time")
    private String offerRemainingTime;
    @b(a = "remaining_time")
    private String remainingTime;
    @b(a = "stage")
    private int stage;
    @b(a = "success_txn_count")
    private int successTxnCount;
    @b(a = "success_txn_text")
    private String successTxnText;
    @b(a = "total_txn_count")
    private int totalTxnCount;
    @b(a = "txn_count_text")
    private String txnCountText;

    public String getGameGratificationMessage() {
        return this.gameGratificationMessage;
    }

    public int getSuccessTxnCount() {
        return this.successTxnCount;
    }

    public int getStage() {
        return this.stage;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public String getGameExpiry() {
        return this.gameExpiry;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getGameStatus() {
        return this.gameStatus;
    }

    public String getSuccessTxnText() {
        return this.successTxnText;
    }

    public String getOfferProgressConstruct() {
        return this.offerProgressConstruct;
    }

    public String getRemainingTime() {
        return this.remainingTime;
    }

    public String getOfferCompletionText() {
        return this.offerCompletionText;
    }

    public int getBonusAmountEarned() {
        return this.bonusAmountEarned;
    }

    public String getGameExpiryReasonText() {
        return this.gameExpiryReasonText;
    }

    public String getTxnCountText() {
        return this.txnCountText;
    }

    public ArrayList<MerchantStage> getMerchantStages() {
        return this.merchantStages;
    }

    public Campaign getCampaign() {
        return this.campaign;
    }

    public void setCampaign(Campaign campaign2) {
        this.campaign = campaign2;
    }

    public int getTotalTxnCount() {
        return this.totalTxnCount;
    }

    public int getMaxCapBonusAmountGame() {
        return this.maxCapBonusAmountGame;
    }

    public void setGameStatus(String str) {
        this.gameStatus = str;
    }

    public String getInitializedOfferText() {
        return this.initializedOfferText;
    }

    public String getOfferRemainingTime() {
        return this.offerRemainingTime;
    }

    public String getGameCompletionTime() {
        return this.gameCompletionTime;
    }
}
