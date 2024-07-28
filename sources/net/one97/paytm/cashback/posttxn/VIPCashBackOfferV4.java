package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class VIPCashBackOfferV4 extends IJRPaytmDataModel {
    @b(a = "bonus_amount")
    private int bonusAmount;
    @b(a = "Claim_CTA")
    private String claimCTA;
    @b(a = "claim_text")
    private String claimText;
    @b(a = "claim_title")
    private String claimTitle;
    @b(a = "current_stage")
    private String currentStage;
    @b(a = "display_message")
    private String displayMessage;
    @b(a = "game_expiry")
    private String gameExpiry;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "info")
    private InfoV4 info;
    @b(a = "initialized_transaction_construct")
    private String initializedTransactionConstruct;
    @b(a = "offer_expiry")
    private String offerExpiry;
    @b(a = "id")
    private String offerId;
    @b(a = "offer_progress_construct")
    private String offerProgressConstruct;
    @b(a = "post_transaction_initialized_title")
    private String offerStatusInitialisedTitle;
    @b(a = "offer_status_text")
    private String offerStatusText;
    @b(a = "offer_summary")
    private String offerSummary;
    @b(a = "offer_badge")
    private String offer_badge;
    @b(a = "offer_status_info")
    private String offer_status_info;
    @b(a = "opt_out_time")
    private String optOutTime;
    @b(a = "post_transaction_completed")
    private String postTransactionCompletedStatus;
    @b(a = "post_transaction_initialized")
    private String postTransactionInitialized;
    @b(a = "post_transaction_progress_status")
    private String postTransactionProgressStatus;
    @b(a = "post_transaction_progress_title")
    private String postTxnProgressTitle;
    private String scratchCardImage;
    @b(a = "server_timestamp")
    private String serverTimestamp;
    @b(a = "status")
    private String status;
    @b(a = "success_txn_count")
    private int successTxnCount;
    @b(a = "total_txn_count")
    private int totalTxnCount;
    @b(a = "txn_linked")
    private TxnLinked txnLinked;
    @b(a = "unlock_text")
    private String unlock_text;
    @b(a = "winning_text")
    private String winningText;

    public String getCurrentStage() {
        return this.currentStage;
    }

    public void setCurrentStage(String str) {
        this.currentStage = str;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public void setOfferId(String str) {
        this.offerId = str;
    }

    public String getOptOutTime() {
        return this.optOutTime;
    }

    public void setOptOutTime(String str) {
        this.optOutTime = str;
    }

    public String getOfferSummary() {
        return this.offerSummary;
    }

    public String getPostTransactionProgressStatus() {
        return this.postTransactionProgressStatus;
    }

    public String getPostTxnProgressTitle() {
        return this.postTxnProgressTitle;
    }

    public void setPostTxnProgressTitle(String str) {
        this.postTxnProgressTitle = str;
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

    public String getId() {
        return this.offerId;
    }

    public int getTotalTxnCount() {
        return this.totalTxnCount;
    }

    public int getSuccessTxnCount() {
        return this.successTxnCount;
    }

    public int getBonusAmount() {
        return this.bonusAmount;
    }

    public InfoV4 getInfo() {
        return this.info;
    }

    public void setInfo(InfoV4 infoV4) {
        this.info = infoV4;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
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

    public String getPostTransactionCompletedStatus() {
        return this.postTransactionCompletedStatus;
    }

    public String getWinningText() {
        return this.winningText;
    }

    public void setWinningText(String str) {
        this.winningText = str;
    }

    public void setPostTransactionProgressStatus(String str) {
        this.postTransactionProgressStatus = str;
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

    public String getOfferBadge() {
        return this.offer_badge;
    }

    public String getOfferStatusInfo() {
        return this.offer_status_info;
    }

    public TxnLinked getTxnLinked() {
        return this.txnLinked;
    }

    public String getScratchCardImage() {
        return this.scratchCardImage;
    }

    public void setScratchCardImage(String str) {
        this.scratchCardImage = str;
    }

    public String getUnlock_text() {
        return this.unlock_text;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
