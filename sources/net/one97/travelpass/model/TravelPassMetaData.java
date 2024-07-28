package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class TravelPassMetaData extends IJRPaytmDataModel {
    @b(a = "cardLevelPartnerOfferHeading")
    private String cardLevelPartnerOfferHeading;
    @b(a = "faq")
    private List<FaqData> faq;
    @b(a = "homepagePartnerOfferHeading")
    private String homepagePartnerOfferHeading;
    @b(a = "howToS")
    private HowToData howtos;
    @b(a = "internalOffers")
    private List<InternalOfferData> internalOffers;
    @b(a = "knowMore")
    private PassAboutInfo knowMore;
    @b(a = "noVisiblePassesHeading")
    private String noVisiblePassesHeading;
    @b(a = "noVisiblePassesImageUrl")
    private String noVisiblePassesImageUrl;
    @b(a = "noVisiblePassesText")
    private String noVisiblePassesText;
    @b(a = "partnerOffers")
    private List<PartnersOfferData> partnerOffers;
    @b(a = "selectedPassesHeading")
    private String selectedPassesHeading;
    @b(a = "tnc")
    private List<TncData> tnc;
    @b(a = "userPasses")
    private UserPassInfo userPassInfo;
    @b(a = "userInfo")
    private UserPassInfo userPassInfoDetails;

    public List<TncData> getTnc() {
        return this.tnc;
    }

    public void setTnc(List<TncData> list) {
        this.tnc = list;
    }

    public List<FaqData> getFaq() {
        return this.faq;
    }

    public void setFaq(List<FaqData> list) {
        this.faq = list;
    }

    public HowToData getHowtos() {
        return this.howtos;
    }

    public void setHowtos(HowToData howToData) {
        this.howtos = howToData;
    }

    public List<InternalOfferData> getInternalOffers() {
        return this.internalOffers;
    }

    public UserPassInfo getUserPassInfoDetails() {
        return this.userPassInfoDetails;
    }

    public String getHomepagePartnerOfferHeading() {
        return this.homepagePartnerOfferHeading;
    }

    public void setHomepagePartnerOfferHeading(String str) {
        this.homepagePartnerOfferHeading = str;
    }

    public String getSelectedPassesHeading() {
        return this.selectedPassesHeading;
    }

    public UserPassInfo getUserPassInfo() {
        UserPassInfo userPassInfo2 = this.userPassInfo;
        if (userPassInfo2 != null) {
            return userPassInfo2;
        }
        return this.userPassInfoDetails;
    }

    public String getCardLevelPartnerOfferHeading() {
        return this.cardLevelPartnerOfferHeading;
    }

    public PassAboutInfo getKnowMore() {
        return this.knowMore;
    }

    public String getNoVisiblePassesHeading() {
        return this.noVisiblePassesHeading;
    }

    public String getNoVisiblePassesText() {
        return this.noVisiblePassesText;
    }

    public String getNoVisiblePassesImageUrl() {
        return this.noVisiblePassesImageUrl;
    }

    public class TncData extends IJRPaytmDataModel {
        @b(a = "tncContent")
        private ArrayList<String> tncContent;
        @b(a = "tncId")
        private String tncId;
        @b(a = "tncName")
        private String tncName;

        public TncData() {
        }

        public String getTncId() {
            return this.tncId;
        }

        public void setTncId(String str) {
            this.tncId = str;
        }

        public String getTncName() {
            return this.tncName;
        }

        public void setTncName(String str) {
            this.tncName = str;
        }

        public ArrayList<String> getTncContent() {
            return this.tncContent;
        }

        public void setTncContent(ArrayList<String> arrayList) {
            this.tncContent = arrayList;
        }
    }

    public class FaqData extends IJRPaytmDataModel {
        @b(a = "faqContent")
        private ArrayList<FaqContent> faqContent;
        @b(a = "faqId")
        private String faqId;
        @b(a = "faqName")
        private String faqName;

        public FaqData() {
        }

        public String getFaqId() {
            return this.faqId;
        }

        public void setFaqId(String str) {
            this.faqId = this.faqId;
        }

        public String getFaqName() {
            return this.faqName;
        }

        public void setFaqName(String str) {
            this.faqName = this.faqName;
        }

        public ArrayList<FaqContent> getFaqContent() {
            return this.faqContent;
        }

        public void setFaqContent(ArrayList<FaqContent> arrayList) {
            this.faqContent = arrayList;
        }
    }

    public class FaqContent extends IJRPaytmDataModel {
        @b(a = "heading")
        private String heading;
        @b(a = "subheading")
        private String subheading;

        public FaqContent() {
        }

        public String getHeading() {
            return this.heading;
        }

        public void setHeading(String str) {
            this.heading = str;
        }

        public String getSubheading() {
            return this.subheading;
        }

        public void setSubheading(String str) {
            this.subheading = str;
        }
    }

    public List<PartnersOfferData> getPartnerOffers() {
        return this.partnerOffers;
    }

    public class HowToData extends IJRPaytmDataModel {
        @b(a = "howToBuy")
        private HowToBuy howtobuy;
        @b(a = "howToUse")
        private HowToUse howtouse;

        public HowToData() {
        }

        public HowToUse getHowtouse() {
            return this.howtouse;
        }

        public void setHowtouse(HowToUse howToUse) {
            this.howtouse = howToUse;
        }

        public HowToBuy getHowtobuy() {
            return this.howtobuy;
        }

        public void setHowtobuy(HowToBuy howToBuy) {
            this.howtobuy = howToBuy;
        }
    }

    public class HowToUse extends IJRPaytmDataModel {
        @b(a = "cards")
        private List<TypeCard> cards;
        @b(a = "knowMore")
        private List<KnowMore> knowMore;

        public HowToUse() {
        }

        public List<TypeCard> getCards() {
            return this.cards;
        }

        public void setCards(List<TypeCard> list) {
            this.cards = list;
        }

        public List<KnowMore> getKnowmore() {
            return this.knowMore;
        }

        public void setKnowmore(List<KnowMore> list) {
            this.knowMore = list;
        }
    }

    public class TypeCard extends IJRPaytmDataModel {
        @b(a = "howToUseContent")
        private List<TypeCardData> howToUseContent;
        @b(a = "howToUseId")
        private String howToUseId;
        @b(a = "howToUseName")
        private String howToUseName;
        @b(a = "type")
        private String type;

        public TypeCard() {
        }

        public String getHowToUseId() {
            return this.howToUseId;
        }

        public List<TypeCardData> getHowToUseContent() {
            return this.howToUseContent;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getHowToUseName() {
            return this.howToUseName;
        }
    }

    public class TypeCardData extends IJRPaytmDataModel {
        @b(a = "deeplink")
        private String deeplink;
        @b(a = "heading")
        private String heading;
        @b(a = "highlight")
        private String highlight;
        @b(a = "color")
        private String highlightColor;
        @b(a = "icon")
        private String icon;
        @b(a = "text")
        private String text;

        public TypeCardData() {
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public String getHighlight() {
            return this.highlight;
        }

        public void setHighlight(String str) {
            this.highlight = str;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public String getHeading() {
            return this.heading;
        }

        public void setHeading(String str) {
            this.heading = str;
        }

        public String getHighlightColor() {
            return this.highlightColor;
        }

        public String getDeeplink() {
            return this.deeplink;
        }

        public void setHighlightColor(String str) {
            this.highlightColor = str;
        }
    }

    public class KnowMore extends IJRPaytmDataModel {
        @b(a = "highlight")
        private String highlight;
        @b(a = "highlightColor")
        private String highlightColor;
        @b(a = "icon")
        private String icon;
        @b(a = "text")
        private String text;

        public KnowMore() {
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public String getHighlight() {
            return this.highlight;
        }

        public void setHighlight(String str) {
            this.highlight = str;
        }

        public String getHighlightColor() {
            return this.highlightColor;
        }
    }

    public class HowToBuy extends IJRPaytmDataModel {
        @b(a = "knowMore")
        private List<KnowMore> knowMore;

        public HowToBuy() {
        }

        public List<KnowMore> getKnowmore() {
            return this.knowMore;
        }

        public void setKnowmore(List<KnowMore> list) {
            this.knowMore = list;
        }
    }

    public class UserPassInfo extends IJRPaytmDataModel {
        @b(a = "message")
        private String message;
        @b(a = "shareMessage")
        private String shareMessage;
        @b(a = "totalActivePasses")
        private String totalActivePasses;
        @b(a = "travelpassCustomer")
        private Boolean travelPassCustomer;

        public UserPassInfo() {
        }

        public String getShareMessage() {
            return this.shareMessage;
        }

        public void setShareMessage(String str) {
            this.shareMessage = str;
        }

        public String getTotalActivePasses() {
            return this.totalActivePasses;
        }

        public String getMessage() {
            return this.message;
        }

        public Boolean getTravelPassCustomer() {
            return this.travelPassCustomer;
        }

        public void setTravelPassCustomer(Boolean bool) {
            this.travelPassCustomer = bool;
        }
    }

    public class PassAboutInfo extends IJRPaytmDataModel {
        public net.one97.travelpass.ui.b.b mType;
        @b(a = "smallImage1")
        public String smallImage1;
        @b(a = "smallImage2")
        public String smallImage2;
        @b(a = "text1")
        public String text1;
        @b(a = "text2")
        public String text2;
        @b(a = "topDesc")
        public String topDesc;
        @b(a = "topImage")
        public String topImage;
        @b(a = "paytmTravelLogo")
        public String topLogoUrl;
        @b(a = "topPara")
        public String topPara;
        @b(a = "topheading")
        public String topheading;

        public PassAboutInfo() {
        }
    }
}
