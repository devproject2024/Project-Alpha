package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;

public class ScratchCard extends IJRPaytmDataModel {
    @b(a = "assured")
    private String assured;
    @b(a = "backgroundImage")
    private String backgroundImage;
    @b(a = "cardHeadline")
    private String cardHeadline;
    @b(a = "status")
    private String cardStatus;
    @b(a = "cashbackDestinationIconUrl")
    private String cashbackDestinationIconUrl;
    @b(a = "createdAt")
    private Long createdAt;
    @b(a = "displayType")
    private String displayType;
    @b(a = "earnedForText")
    private String earnedFor;
    @b(a = "earnedText")
    private String earnedText;
    @b(a = "expireAt")
    private String expireAt;
    @b(a = "expiryText")
    private String expiryText;
    @b(a = "extraInfo")
    private ScratchCardExtraInfo extraInfo;
    @b(a = "flipCtaText")
    private String flipCtaText;
    @b(a = "flipText")
    private String flipText;
    @b(a = "frontendRedemptionType")
    private String frontendRedemptionType;
    @b(a = "iconUrl")
    private String iconUrl;
    @b(a = "id")
    private String id;
    @b(a = "initializationText")
    private String initializationText;
    @b(a = "luckyDraw")
    private Boolean luckyDraw;
    @b(a = "noneRedemption")
    private String noneRedemption;
    @b(a = "redemptionCtaDeeplink")
    private String redemptionCtaDeeplink;
    @b(a = "redemptionCtaText")
    private String redemptionCtaText;
    @b(a = "redemptionMaxAmount")
    private String redemptionMaxAmount;
    @b(a = "redemptionMetaData")
    private RedemptionMetaData redemptionMetaData;
    @b(a = "redemptionText")
    private String redemptionText;
    @b(a = "redemptionType")
    private String redemptionType;
    @b(a = "referenceId")
    private String referenceId;
    @b(a = "sourceMetaData")
    private SourceMetaData sourceMetaData;
    @b(a = "statusText")
    private String statusText;
    @b(a = "subRedemptionType")
    private String subRedemptionType;
    @b(a = "unlockText")
    private String unlockText;
    @b(a = "winningText")
    private String winningText;
    @b(a = "winningTitle")
    private String winningTitle;

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    public String getFrontendRedemptionType() {
        return this.frontendRedemptionType;
    }

    public void setFrontendRedemptionType(String str) {
        this.frontendRedemptionType = str;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(String str) {
        this.displayType = str;
    }

    public SourceMetaData getSourceMetaData() {
        return this.sourceMetaData;
    }

    public void setSourceMetaData(SourceMetaData sourceMetaData2) {
        this.sourceMetaData = sourceMetaData2;
    }

    public String getWinningText() {
        return this.winningText;
    }

    public void setWinningText(String str) {
        this.winningText = str;
    }

    public RedemptionMetaData getRedemptionMetaData() {
        return this.redemptionMetaData;
    }

    public void setRedemptionMetaData(RedemptionMetaData redemptionMetaData2) {
        this.redemptionMetaData = redemptionMetaData2;
    }

    public String getUnlockText() {
        return this.unlockText;
    }

    public void setUnlockText(String str) {
        this.unlockText = str;
    }

    public String getAssured() {
        return this.assured;
    }

    public void setAssured(String str) {
        this.assured = str;
    }

    public String getExpiryText() {
        return this.expiryText;
    }

    public void setExpiryText(String str) {
        this.expiryText = str;
    }

    public String getRedemptionText() {
        return this.redemptionText;
    }

    public void setRedemptionText(String str) {
        this.redemptionText = str;
    }

    public String getEarnedText() {
        return this.earnedText;
    }

    public void setEarnedText(String str) {
        this.earnedText = str;
    }

    public String getSubRedemptionType() {
        return this.subRedemptionType;
    }

    public void setSubRedemptionType(String str) {
        this.subRedemptionType = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getWinningTitle() {
        return this.winningTitle;
    }

    public void setWinningTitle(String str) {
        this.winningTitle = str;
    }

    public String getNoneRedemption() {
        return this.noneRedemption;
    }

    public void setNoneRedemption(String str) {
        this.noneRedemption = str;
    }

    public String getInitializationText() {
        return this.initializationText;
    }

    public void setInitializationText(String str) {
        this.initializationText = str;
    }

    public String getScratchCardStatus() {
        return this.cardStatus;
    }

    public void setScratchCardStatus(String str) {
        this.cardStatus = str;
    }

    public ScratchCardExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(ScratchCardExtraInfo scratchCardExtraInfo) {
        this.extraInfo = scratchCardExtraInfo;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof ScratchCard) || (str = ((ScratchCard) obj).id) == null) {
            return false;
        }
        return str.equals(this.id);
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public String getFlipText() {
        return this.flipText;
    }

    public String getFlipCtaText() {
        return this.flipCtaText;
    }

    public String getRedemptionCtaText() {
        return this.redemptionCtaText;
    }

    public String getRedemptionCtaDeeplink() {
        return this.redemptionCtaDeeplink;
    }

    public String getExpireAt() {
        return this.expireAt;
    }

    public String getRedemptionMaxAmount() {
        String str = this.redemptionMaxAmount;
        if (str == null || str.isEmpty()) {
            return this.redemptionMaxAmount;
        }
        return FilterPriceSliderFragment.RUPEE_SYMBOL + this.redemptionMaxAmount;
    }

    public String getCardHeadline() {
        return this.cardHeadline;
    }

    public Boolean getLuckyDraw() {
        return this.luckyDraw;
    }

    public String getEarnedFor() {
        return this.earnedFor;
    }

    public String getCashbackDestinationIconUrl() {
        return this.cashbackDestinationIconUrl;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }
}
