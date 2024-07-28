package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class VIPCashBackOffer extends IJRPaytmDataModel {
    @b(a = "bonus_amount")
    private int bonusAmount;
    @b(a = "campaign_id")
    private int campaignId;
    @b(a = "Claim_CTA")
    private String claimCTA;
    @b(a = "claim_cta")
    private String claimCta;
    @b(a = "claim_text")
    private String claimText;
    @b(a = "claim_title")
    private String claimTitle;
    @b(a = "id")
    private String cmpnId;
    private boolean expanded = false;
    @b(a = "frontend_redemption_type")
    private String frontendRedemptionType;
    @b(a = "game_expiry")
    private String gameExpiry;
    @b(a = "info")
    private Info info;
    @b(a = "initial_amount")
    private int initialAmount;
    @b(a = "initialized_transaction_construct")
    private String initializedTransactionConstruct;
    @b(a = "offer_expiry")
    private String offerExpiry;
    @b(a = "offer_expiry_amount")
    private int offerExpiryAmount;
    @b(a = "offer_id")
    private String offerId;
    @b(a = "offer_progress_construct")
    private String offerProgressConstruct;
    @b(a = "post_transaction_initialized_title")
    private String offerStatusInitialisedTitle;
    @b(a = "offer_status_text")
    private String offerStatusText;
    @b(a = "offer_tag")
    private String offerTag;
    @b(a = "opt_out_time")
    private String optOutTime;
    @b(a = "post_transaction_collapsed_completed")
    private String postTransactionCollapsedCompleted;
    @b(a = "post_transaction_collapsed_initialized")
    private String postTransactionCollapsedInitialized;
    @b(a = "post_transaction_collapsed_progress")
    private String postTransactionCollapsedProgress;
    @b(a = "post_transaction_completed")
    private String postTransactionCompletedStatus;
    @b(a = "post_transaction_initialized")
    private String postTransactionInitialized;
    @b(a = "post_transaction_progress_status")
    private String postTransactionProgressStatus;
    @b(a = "post_transaction_progress_title")
    private String postTxnProgressTitle;
    @b(a = "savings")
    private String savings;
    @b(a = "server_timestamp")
    private String serverTimestamp;
    @b(a = "stage_txn_count")
    private int stageTxnCount;
    @b(a = "status")
    private String status;
    @b(a = "success_txn_count")
    private int successTxnCount;
    @b(a = "total_txn_count")
    private int totalTxnCount;
    @b(a = "winning_text")
    private String winningText;

    public int getSuccessTxnCount() {
        return this.successTxnCount;
    }

    public void setSuccessTxnCount(int i2) {
        this.successTxnCount = i2;
    }

    public void setTotalTxnCount(int i2) {
        this.totalTxnCount = i2;
    }

    public String getPostTransactionCollapsedCompleted() {
        return this.postTransactionCollapsedCompleted;
    }

    public String getCmpnId() {
        return this.cmpnId;
    }

    public void setCmpnId(String str) {
        this.cmpnId = str;
    }

    public String getPostTransactionProgressStatus() {
        return this.postTransactionProgressStatus;
    }

    public String getPostTransactionCollapsedProgress() {
        return this.postTransactionCollapsedProgress;
    }

    public String getPostTransactionCollapsedInitialized() {
        return this.postTransactionCollapsedInitialized;
    }

    public String getPostTransactionInitialized() {
        return this.postTransactionInitialized;
    }

    public String getOfferProgressConstruct() {
        return this.offerProgressConstruct;
    }

    public String getInitializedTransactionConstruct() {
        return this.initializedTransactionConstruct;
    }

    public String getClaimCTA() {
        return this.claimCTA;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void setExpanded(boolean z) {
        this.expanded = z;
    }

    public String getId() {
        return this.offerId;
    }

    public void setId(String str) {
        this.offerId = str;
    }

    public int getCampaignId() {
        return this.campaignId;
    }

    public int getTotalTxnCount() {
        return this.totalTxnCount;
    }

    public int getStageTxnCount() {
        return this.stageTxnCount;
    }

    public int getBonusAmount() {
        return this.bonusAmount;
    }

    public Info getInfo() {
        return this.info;
    }

    public void setInfo(Info info2) {
        this.info = info2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public int getInitialAmount() {
        return this.initialAmount;
    }

    public String getOfferExpiry() {
        return this.offerExpiry;
    }

    public String getGameExpiry() {
        return this.gameExpiry;
    }

    public String getServerTimestamp() {
        return this.serverTimestamp;
    }

    public int getOfferExpiryAmount() {
        return this.offerExpiryAmount;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public String getFrontendRedemptionType() {
        return this.frontendRedemptionType;
    }

    public String getPostTransactionCompletedStatus() {
        return this.postTransactionCompletedStatus;
    }

    public String getOfferTag() {
        return this.offerTag;
    }

    public String getOptOutTime() {
        return this.optOutTime;
    }

    public void setOptOutTime(String str) {
        this.optOutTime = str;
    }

    public String getWinningText() {
        return this.winningText;
    }

    public void setWinningText(String str) {
        this.winningText = str;
    }

    public String getSavings() {
        return this.savings;
    }

    public void setSavings(String str) {
        this.savings = str;
    }

    public void setFrontendRedemptionType(String str) {
        this.frontendRedemptionType = str;
    }

    public void setPostTransactionProgressStatus(String str) {
        this.postTransactionProgressStatus = str;
    }

    public String getPostTxnProgressTitle() {
        return this.postTxnProgressTitle;
    }

    public void setPostTxnProgressTitle(String str) {
        this.postTxnProgressTitle = str;
    }

    public String getClaimTitle() {
        return this.claimTitle;
    }

    public void setClaimTitle(String str) {
        this.claimTitle = str;
    }

    public String getClaimText() {
        return this.claimText;
    }

    public void setClaimText(String str) {
        this.claimText = str;
    }

    public String getClaimCta() {
        return this.claimCta;
    }

    public void setClaimCta(String str) {
        this.claimCta = str;
    }

    public void setPostTransactionInitialized(String str) {
        this.postTransactionInitialized = str;
    }

    public String getOfferStatusText() {
        return this.offerStatusText;
    }

    public void setOfferStatusText(String str) {
        this.offerStatusText = str;
    }

    public String getOfferStatusInitialisedTitle() {
        return this.offerStatusInitialisedTitle;
    }

    public void setOfferStatusInitialisedTitle(String str) {
        this.offerStatusInitialisedTitle = str;
    }
}
