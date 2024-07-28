package net.one97.paytm.transport.iocl.data;

import com.google.gsonhtcfix.a.b;

public class IOCLCommonResponse extends IOCLBaseResponseModel {
    @b(a = "earnedOrRedeemed")
    private String earnedOrRedeemed;
    @b(a = "ioclImage")
    private String ioclImage;
    @b(a = "ioclTxnNo")
    private String ioclTxnNo;
    @b(a = "message")
    private String message;
    @b(a = "minimumRedemptionPoints")
    private Double minimumRedemptionPoints;
    @b(a = "primaryMessage")
    private String primaryMessage;
    @b(a = "redeemStatus")
    private String redeemStatus;
    @b(a = "rewards")
    private Rewards rewards;
    @b(a = "secondaryMessage")
    private String secondaryMessage;
    @b(a = "transactionAmount")
    private Double transactionAmount;
    @b(a = "transactionId")
    private String transactionId;
    @b(a = "transactionPoints")
    private Double transactionPoints;
    @b(a = "transactionUpdateTime")
    private Long transactionTime;
    @b(a = "updatedWalletBalance")
    private Double updatedWalletBalance;
    @b(a = "user")
    private User user;
    @b(a = "userEnrollmentMetaData")
    private UserEnrollmentMeta userEnrollmentMeta;

    public Double getUpdatedWalletBalance() {
        return this.updatedWalletBalance;
    }

    public void setUpdatedWalletBalance(Double d2) {
        this.updatedWalletBalance = d2;
    }

    public String getIoclTxnNo() {
        return this.ioclTxnNo;
    }

    public void setIoclTxnNo(String str) {
        this.ioclTxnNo = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getPrimaryMessage() {
        return this.primaryMessage;
    }

    public void setPrimaryMessage(String str) {
        this.primaryMessage = str;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public Rewards getRewards() {
        return this.rewards;
    }

    public void setRewards(Rewards rewards2) {
        this.rewards = rewards2;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public Double getTransactionAmount() {
        Double d2 = this.transactionAmount;
        return d2 == null ? Double.valueOf(0.0d) : d2;
    }

    public void setTransactionAmount(Double d2) {
        this.transactionAmount = d2;
    }

    public Double getTransactionPoints() {
        Double d2 = this.transactionPoints;
        return d2 == null ? Double.valueOf(0.0d) : d2;
    }

    public void setTransactionPoints(Double d2) {
        this.transactionPoints = d2;
    }

    public String getRedeemStatus() {
        return this.redeemStatus;
    }

    public void setRedeemStatus(String str) {
        this.redeemStatus = str;
    }

    public String getSecondaryMessage() {
        return this.secondaryMessage;
    }

    public void setSecondaryMessage(String str) {
        this.secondaryMessage = str;
    }

    public Double getMinimumRedemptionPoints() {
        return this.minimumRedemptionPoints;
    }

    public void setMinimumRedemptionPoints(Double d2) {
        this.minimumRedemptionPoints = d2;
    }

    public String getEarnedOrRedeemed() {
        return this.earnedOrRedeemed;
    }

    public void setEarnedOrRedeemed(String str) {
        this.earnedOrRedeemed = str;
    }

    public String getIoclImage() {
        return this.ioclImage;
    }

    public void setIoclImage(String str) {
        this.ioclImage = str;
    }

    public Long getTransactionTime() {
        return this.transactionTime;
    }

    public void setTransactionTime(Long l) {
        this.transactionTime = l;
    }

    public UserEnrollmentMeta getUserEnrollmentMeta() {
        return this.userEnrollmentMeta;
    }

    public void setUserEnrollmentMeta(UserEnrollmentMeta userEnrollmentMeta2) {
        this.userEnrollmentMeta = userEnrollmentMeta2;
    }
}
