package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class Campaign extends IJRPaytmDataModel {
    @b(a = "auto_activate")
    private boolean autoActivate;
    @b(a = "background_image_url")
    private String backgroundImageUrl;
    @b(a = "background_overlay")
    private Boolean backgroundOverlay;
    @b(a = "campaign")
    private String campaign;
    @b(a = "deeplink_url")
    private String deeplinkUrl;
    @b(a = "event")
    private String event;
    @b(a = "first_transaction_cta")
    private String firstTransactionCta;
    @b(a = "id")
    private int id;
    @b(a = "important_terms")
    private String importantTerms;
    @b(a = "isDeeplink")
    private Boolean isDeepLink;
    @b(a = "is_offus_transaction")
    private Boolean isOffusTransaction;
    @b(a = "multi_stage_campaign")
    private Boolean multiStageCampaign;
    @b(a = "multi_stage_icon")
    private String multiStageIcon;
    private int myOffersListPosition;
    @b(a = "new_offers_image_url")
    private String newOffersImageUrl;
    private int newOffersListPosition;
    @b(a = "off_us_transaction_text")
    private String offUsTransactionText;
    @b(a = "offer_keyword")
    private String offerKeyword;
    @b(a = "offer_summary")
    private String offerSummary;
    @b(a = "offer_text_override")
    private String offerTextOverride;
    @b(a = "offer_type_id")
    private Integer offerTypeId;
    @b(a = "offer_type_text")
    private String offerTypeText;
    @b(a = "progress_screen_cta")
    private String progressScreenCta;
    @b(a = "redemption_type")
    private String redemptionType;
    @b(a = "short_description")
    private String shortDescription;
    @b(a = "show_game_progress")
    private boolean showGameProgress;
    @b(a = "surprise_text")
    private String surpriseText;
    @b(a = "surprise_text_title")
    private String surpriseTextTitle;
    @b(a = "tnc")
    private String tnc;
    @b(a = "tnc_url")
    private String tncUrl;
    @b(a = "total_cashback_earned")
    private int totalCashbackEarned;
    @b(a = "valid_upto")
    private String validUpto;

    public boolean isAutoActivate() {
        return this.autoActivate;
    }

    public void setAutoActivate(boolean z) {
        this.autoActivate = z;
    }

    public String getBackgroundImageUrl() {
        return this.backgroundImageUrl;
    }

    public String getOffUsTransactionText() {
        return this.offUsTransactionText;
    }

    public String getNewOffersImageUrl() {
        return this.newOffersImageUrl;
    }

    public String getProgressScreenCta() {
        return this.progressScreenCta;
    }

    public String getOfferKeyword() {
        return this.offerKeyword;
    }

    public void setOfferKeyword(String str) {
        this.offerKeyword = str;
    }

    public String getCampaign() {
        return this.campaign;
    }

    public void setCampaign(String str) {
        this.campaign = str;
    }

    public String getTnc() {
        return this.tnc;
    }

    public void setTnc(String str) {
        this.tnc = str;
    }

    public String getTncUrl() {
        return this.tncUrl;
    }

    public String getValidUpto() {
        return this.validUpto;
    }

    public String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public Integer getOfferTypeId() {
        return this.offerTypeId;
    }

    public String getOfferTypeText() {
        return this.offerTypeText;
    }

    public String getOfferTextOverride() {
        return this.offerTextOverride;
    }

    public Boolean getOffusTransaction() {
        return this.isOffusTransaction;
    }

    public String getImportantTerms() {
        return this.importantTerms;
    }

    public Boolean getMultiStageCampaign() {
        return this.multiStageCampaign;
    }

    public String getMultiStageIcon() {
        return this.multiStageIcon;
    }

    public String getSurpriseText() {
        return this.surpriseText;
    }

    public String getSurpriseTextTitle() {
        return this.surpriseTextTitle;
    }

    public String getOfferSummary() {
        return this.offerSummary;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public int getTotalCashbackEarned() {
        return this.totalCashbackEarned;
    }

    public int getId() {
        return this.id;
    }

    public int getNewOffersListPosition() {
        return this.newOffersListPosition;
    }

    public void setNewOffersListPosition(int i2) {
        this.newOffersListPosition = i2;
    }

    public Boolean getBackgroundOverlay() {
        Boolean bool = this.backgroundOverlay;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public int getMyOffersListPosition() {
        return this.myOffersListPosition;
    }

    public void setMyOffersListPosition(int i2) {
        this.myOffersListPosition = i2;
    }

    public String getEvent() {
        return this.event;
    }

    public String getFirstTransactionCta() {
        return this.firstTransactionCta;
    }

    public Boolean getDeepLink() {
        return this.isDeepLink;
    }

    public void setDeepLink(Boolean bool) {
        this.isDeepLink = bool;
    }

    public boolean isShowGameProgress() {
        return this.showGameProgress;
    }
}
