package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import java.util.Map;

public class PassData extends IJRPaytmDataModel {
    @b(a = "additionalBenefitPromos")
    private AdditionalBenefitPromos additionalBenefitPromos;
    @b(a = "applicableOn")
    private List<String> applicableOn;
    @b(a = "campaignId")
    private String campaignId;
    @b(a = "canRedeem")
    private boolean canRedeem;
    @b(a = "cardLevelPartnerOfferHeading")
    private String cardLevelPartnerOfferHeading;
    @b(a = "cardName")
    private String cardName;
    @b(a = "cashbackPerBooking")
    private double cashbackPerBooking;
    @b(a = "category")
    private String category;
    @b(a = "categoryId")
    private int categoryId;
    @b(a = "createdAt")
    private String createdAt;
    @b(a = "createdBy")
    private String createdBy;
    @b(a = "endDate")
    private String endDate;
    @b(a = "faqId")
    private String faqId;
    @b(a = "fields")
    private List<PassFields> fields;
    @b(a = "hotelPassDisclaimerIcon")
    private String hotelPassDisclaimerIcon;
    @b(a = "hotelPassDisclaimerText")
    private String hotelPassDisclaimerText;
    @b(a = "howToUseId")
    private String howToUseId;
    @b(a = "imageUrl")
    private String imageUrl;
    @b(a = "internalOffers")
    private List<String> internalOffers;
    @b(a = "isDisable")
    private boolean isDisable;
    @b(a = "isOperatorPass")
    private Boolean isOperatorPass;
    @b(a = "isPromoApplicable")
    private boolean isPromoApplicable;
    @b(a = "isStockedOut")
    private boolean isStockedOut;
    @b(a = "isSubscribed")
    private boolean isSubscribed;
    @b(a = "isVisible")
    private boolean isVisible;
    @b(a = "itemId")
    private Long itemId;
    @b(a = "maxPurchaseCount")
    private int maxPurchaseCount;
    @b(a = "maxSaving")
    private double maxSaving;
    @b(a = "mid")
    private int mid;
    @b(a = "movPerBooking")
    private int movPerBooking;
    @b(a = "numberOfBookings")
    private int numberOfBookings;
    @b(a = "partnerOffers")
    private List<String> partnerOffers;
    @b(a = "pid")
    private int pid;
    @b(a = "price")
    private double price;
    @b(a = "promocode")
    private String promocode;
    @b(a = "serialNumber")
    private int serialNumber;
    @b(a = "shareMessage")
    private String shareMessage;
    @b(a = "startDate")
    private String startDate;
    @b(a = "stockAllowed")
    private int stockAllowed;
    @b(a = "stockSold")
    private int stockSold;
    @b(a = "subscriptionButtonLabel")
    private String subscriptionButtonLabel;
    @b(a = "subscriptionText")
    private String subscriptionText;
    @b(a = "tncId")
    private String tncId;
    @b(a = "totalCashback")
    private double totalCashback;
    @b(a = "travelPassId")
    private String travelPassId;
    @b(a = "updatedAt")
    private String updatedAt;
    @b(a = "updatedBy")
    private String updatedBy;
    @b(a = "validity")
    private int validity;
    @b(a = "verticalId")
    private int verticalId;

    public String getTravelPassId() {
        return this.travelPassId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getCardName() {
        return this.cardName;
    }

    public double getCashbackPerBooking() {
        return this.cashbackPerBooking;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getHotelPassDisclaimerIcon() {
        return this.hotelPassDisclaimerIcon;
    }

    public String getHotelPassDisclaimerText() {
        return this.hotelPassDisclaimerText;
    }

    public String getFaqId() {
        return this.faqId;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public boolean isDisable() {
        return this.isDisable;
    }

    public boolean isPromoApplicable() {
        return this.isPromoApplicable;
    }

    public boolean isStockedOut() {
        return this.isStockedOut;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public double getMaxSaving() {
        return this.maxSaving;
    }

    public int getMid() {
        return this.mid;
    }

    public int getMovPerBooking() {
        return this.movPerBooking;
    }

    public int getNumberOfBookings() {
        return this.numberOfBookings;
    }

    public int getPid() {
        return this.pid;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double d2) {
        this.price = d2;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public double getTotalCashback() {
        return this.totalCashback;
    }

    public int getValidity() {
        return this.validity;
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public List<PassFields> getFields() {
        return this.fields;
    }

    public void setFields(List<PassFields> list) {
        this.fields = list;
    }

    public String getCardLevelPartnerOfferHeading() {
        return this.cardLevelPartnerOfferHeading;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public String getHowToUseId() {
        return this.howToUseId;
    }

    public List<String> getPartnerOffers() {
        return this.partnerOffers;
    }

    public int getStockSold() {
        return this.stockSold;
    }

    public int getStockAllowed() {
        return this.stockAllowed;
    }

    public String getTncId() {
        return this.tncId;
    }

    public String getCategory() {
        return this.category;
    }

    public List<String> getInternalOffers() {
        return this.internalOffers;
    }

    public int getMaxPurchaseCount() {
        return this.maxPurchaseCount;
    }

    public void setMaxPurchaseCount(int i2) {
        this.maxPurchaseCount = i2;
    }

    public AdditionalBenefitPromos getAdditionalBenefitPromos() {
        return this.additionalBenefitPromos;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long l) {
        this.itemId = l;
    }

    public boolean isCanRedeem() {
        return this.canRedeem;
    }

    public void setCanRedeem(boolean z) {
        this.canRedeem = z;
    }

    public String getShareMessage() {
        return this.shareMessage;
    }

    public void setShareMessage(String str) {
        this.shareMessage = str;
    }

    public Boolean getOperatorPass() {
        return this.isOperatorPass;
    }

    public void setOperatorPass(Boolean bool) {
        this.isOperatorPass = bool;
    }

    public List<String> getApplicableOn() {
        return this.applicableOn;
    }

    public void setApplicableOn(List<String> list) {
        this.applicableOn = list;
    }

    public boolean isSubscribed() {
        return this.isSubscribed;
    }

    public void setSubscribed(boolean z) {
        this.isSubscribed = z;
    }

    public String getSubscriptionText() {
        return this.subscriptionText;
    }

    public void setSubscriptionText(String str) {
        this.subscriptionText = str;
    }

    public String getSubscriptionButtonLabel() {
        return this.subscriptionButtonLabel;
    }

    public void setSubscriptionButtonLabel(String str) {
        this.subscriptionButtonLabel = str;
    }

    public class PassFields extends IJRPaytmDataModel {
        @b(a = "clickButtonText")
        private String clickButtonText;
        @b(a = "clickUrl")
        private String clickUrl;
        @b(a = "color")
        private String color;
        @b(a = "icon")
        private String icon;
        @b(a = "isClickable")
        private boolean isClickable = false;
        @b(a = "isCopy")
        private Boolean isCopy = null;
        private boolean isPromoField;
        @b(a = "label")
        private String label;
        @b(a = "value")
        private String value;

        public PassFields() {
        }

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setCopy(boolean z) {
            this.isCopy = Boolean.valueOf(z);
        }

        public String getColor() {
            return this.color;
        }

        public Boolean isCopy() {
            return this.isCopy;
        }

        public boolean getClickable() {
            return this.isClickable;
        }

        public void setClickable(Boolean bool) {
            this.isClickable = bool.booleanValue();
        }

        public String getClickUrl() {
            return this.clickUrl;
        }

        public void setClickUrl(String str) {
            this.clickUrl = str;
        }

        public String getClickButtonText() {
            return this.clickButtonText;
        }

        public void setClickButtonText(String str) {
            this.clickButtonText = str;
        }
    }

    public class AdditionalBenefitPromos extends IJRPaytmDataModel {
        @b(a = "partnerOfferMapping")
        private Map<String, String> partnerOfferMapping;

        public AdditionalBenefitPromos() {
        }

        public Map<String, String> getPartnerOfferMapping() {
            return this.partnerOfferMapping;
        }

        public void setPartnerOfferMapping(Map<String, String> map) {
            this.partnerOfferMapping = map;
        }
    }
}
