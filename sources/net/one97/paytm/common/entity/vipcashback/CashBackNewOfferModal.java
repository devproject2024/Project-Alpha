package net.one97.paytm.common.entity.vipcashback;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CashBackNewOfferModal extends IJRPaytmDataModel {
    @b(a = "auto_activate")
    private boolean autoActivate;
    @b(a = "background_image_url")
    private String backgroundImageUrl;
    @b(a = "background_overlay")
    private Boolean backgroundOverlay;
    @b(a = "bonus_amount")
    private String bonusAmount;
    @b(a = "campaign")
    private String campaign;
    @b(a = "deeplink_url")
    private String deeplinkUrl;
    @b(a = "game_expiry")
    private String gameExpiry;
    @b(a = "id")
    private int id;
    @b(a = "important_terms")
    private String importantTerms;
    @b(a = "initial_amount")
    private String initialAmount;
    private boolean isActivated;
    @b(a = "is_offus_transaction")
    private Boolean isOffusTransaction;
    @b(a = "max_cashback_value_bonus_stage")
    private String maxCashbackValueBonusStage;
    @b(a = "max_cashback_value_initial_stage")
    private int maxCashbackValueInitialStage;
    @b(a = "max_offer_allowed")
    private String maxOfferAllowed;
    @b(a = "multi_stage_campaign")
    private boolean multiStageCampaign;
    @b(a = "multi_stage_icon")
    private String multiStageIcon;
    @b(a = "new_offers_image_url")
    private String newOffersImageUrl;
    @b(a = "off_us_transaction_text")
    private String offUsTransactionText;
    @b(a = "offer_expiry")
    private String offerExpiry;
    @b(a = "offer_expiry_amount")
    private String offerExpiryAmount;
    @b(a = "offer_image_url")
    private String offerImageUrl;
    @b(a = "offer_keyword")
    private String offerKeyword;
    @b(a = "offer_text_override")
    private String offerTextOverride;
    @b(a = "offer_type_id")
    private int offerTypeId;
    @b(a = "offer_type_text")
    private String offerTypeText;
    @b(a = "percent_redemption")
    private int percentRedemption;
    @b(a = "progress_screen_cta")
    private String progressScreenCta;
    @b(a = "promocode")
    private String promocode;
    @b(a = "redemption_type")
    private String redemptionType;
    @b(a = "redemption_type_flat_percent")
    private String redemptionTypeFlatPercent;
    @b(a = "short_description")
    private String shortDescription;
    @b(a = "stage_txn_count")
    private String stageTxnCount;
    @b(a = "surprise_text")
    private String surpriseText;
    @b(a = "surprise_text_title")
    private String surpriseTextTitle;
    @b(a = "third_party_id")
    private String thirdPartyId;
    @b(a = "tnc")
    private String tnc;
    @b(a = "tnc_url")
    private String tncUrl;
    @b(a = "total_txn_count")
    private String totalTxnCount;
    @b(a = "valid_upto")
    private String validUpto;

    public boolean isAutoActivate() {
        return this.autoActivate;
    }

    public void setAutoActivate(boolean z) {
        this.autoActivate = z;
    }

    public boolean isActivated() {
        return this.isActivated;
    }

    public void setActivated(boolean z) {
        this.isActivated = z;
    }

    public String getBackgroundImageUrl() {
        return this.backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String str) {
        this.backgroundImageUrl = str;
    }

    public String getOffUsTransactionText() {
        return this.offUsTransactionText;
    }

    public void setOffUsTransactionText(String str) {
        this.offUsTransactionText = str;
    }

    public String getNewOffersImageUrl() {
        return this.newOffersImageUrl;
    }

    public void setNewOffersImageUrl(String str) {
        this.newOffersImageUrl = str;
    }

    public String getProgressScreenCta() {
        return this.progressScreenCta;
    }

    public void setProgressScreenCta(String str) {
        this.progressScreenCta = str;
    }

    public String getOfferKeyword() {
        return this.offerKeyword;
    }

    public void setOfferKeyword(String str) {
        this.offerKeyword = str;
    }

    public String getValidUpto() {
        return this.validUpto;
    }

    public void setValidUpto(String str) {
        this.validUpto = str;
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

    public String getInitialAmount() {
        return this.initialAmount;
    }

    public void setInitialAmount(String str) {
        this.initialAmount = str;
    }

    public String getBonusAmount() {
        return this.bonusAmount;
    }

    public void setBonusAmount(String str) {
        this.bonusAmount = str;
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

    public void setShortDescription(String str) {
        this.shortDescription = str;
    }

    public String getStageTxnCount() {
        return this.stageTxnCount;
    }

    public void setStageTxnCount(String str) {
        this.stageTxnCount = str;
    }

    public String getGameExpiry() {
        return this.gameExpiry;
    }

    public void setGameExpiry(String str) {
        this.gameExpiry = str;
    }

    public int getOfferTypeId() {
        return this.offerTypeId;
    }

    public void setOfferTypeId(int i2) {
        this.offerTypeId = i2;
    }

    public String getOfferTypeText() {
        return this.offerTypeText;
    }

    public void setOfferTypeText(String str) {
        this.offerTypeText = str;
    }

    public String getOfferImageUrl() {
        return this.offerImageUrl;
    }

    public void setOfferImageUrl(String str) {
        this.offerImageUrl = str;
    }

    public String getOfferTextOverride() {
        return this.offerTextOverride;
    }

    public void setOfferTextOverride(String str) {
        this.offerTextOverride = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public String getPromoCode() {
        if (TextUtils.isEmpty(this.promocode)) {
            return null;
        }
        return this.promocode;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public String getTotalTxnCount() {
        return this.totalTxnCount;
    }

    public String getOfferExpiry() {
        return this.offerExpiry;
    }

    public String getOfferExpiryAmount() {
        return this.offerExpiryAmount;
    }

    public String getMaxOfferAllowed() {
        return this.maxOfferAllowed;
    }

    public String getThirdPartyId() {
        return this.thirdPartyId;
    }

    public Boolean getOffusTransaction() {
        return this.isOffusTransaction;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public int getMaxCashbackValueInitialStage() {
        return this.maxCashbackValueInitialStage;
    }

    public String getMaxCashbackValueBonusStage() {
        return this.maxCashbackValueBonusStage;
    }

    public int getPercentRedemption() {
        return this.percentRedemption;
    }

    public String getRedemptionTypeFlatPercent() {
        return this.redemptionTypeFlatPercent;
    }

    public String getImportantTerms() {
        return this.importantTerms;
    }

    public String getSurpriseText() {
        return this.surpriseText;
    }

    public String getSurpriseTextTitle() {
        return this.surpriseTextTitle;
    }

    public boolean isMultiStageCampaign() {
        return this.multiStageCampaign;
    }

    public String getMultiStageIcon() {
        return this.multiStageIcon;
    }

    public Boolean getBackgroundOverlay() {
        Boolean bool = this.backgroundOverlay;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }
}
