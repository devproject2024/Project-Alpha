package net.one97.paytm.common.entity.lifafa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class ReceivedLifafaDetailsResponse extends CJRWalletDataModel implements IJRDataModel {
    private LifafaDetail lifafaDetail;
    private LifafaFetcherDetails lifafaFetcherDetails;
    private ArrayList<RecipientDetails> recipientDetails;
    private String statusCode;
    private String statusMessage;
    private ThemeDetailsResponse themeDetailsResponse;

    public static class PassbookView implements IJRDataModel {
    }

    public static class PushView implements IJRDataModel {
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public LifafaDetail getLifafaDetail() {
        return this.lifafaDetail;
    }

    public void setLifafaDetail(LifafaDetail lifafaDetail2) {
        this.lifafaDetail = lifafaDetail2;
    }

    public ArrayList<RecipientDetails> getRecipientDetails() {
        return this.recipientDetails;
    }

    public void setRecipientDetails(ArrayList<RecipientDetails> arrayList) {
        this.recipientDetails = arrayList;
    }

    public LifafaFetcherDetails getLifafaFetcherDetails() {
        return this.lifafaFetcherDetails;
    }

    public void setLifafaFetcherDetails(LifafaFetcherDetails lifafaFetcherDetails2) {
        this.lifafaFetcherDetails = lifafaFetcherDetails2;
    }

    public ThemeDetailsResponse getThemeDetailsResponse() {
        return this.themeDetailsResponse;
    }

    public void setThemeDetailsResponse(ThemeDetailsResponse themeDetailsResponse2) {
        this.themeDetailsResponse = themeDetailsResponse2;
    }

    public static class CreatorInfo implements IJRDataModel {
        private String emailId;
        private String name;
        private String phoneNo;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getPhoneNo() {
            return this.phoneNo;
        }

        public void setPhoneNo(String str) {
            this.phoneNo = str;
        }

        public String getEmailId() {
            return this.emailId;
        }

        public void setEmailId(String str) {
            this.emailId = str;
        }
    }

    public static class LifafaDetail implements IJRDataModel {
        private String activationTimestamp;
        private String category;
        private String categoryMappingId;
        private String categoryResponseMetadata;
        private String createTimestamp;
        private String creatorId;
        private CreatorInfo creatorInfo;
        private String creatorLogo;
        private String creatorType;
        private String distributionType;
        private String expiryTimestamp;
        private String lifafaKey;
        private String lifafaMessage;
        private String lifafaName;
        private String lifafaStatus;
        private String metadata;
        private BigDecimal proposedQuantity;
        private int proposedReceiverCount;
        private String qrCodeId;
        private boolean showOtherRecipientsInfo;
        private String strategyType;
        private String themeGuid;
        private String unit;

        public String getLifafaKey() {
            return this.lifafaKey;
        }

        public void setLifafaKey(String str) {
            this.lifafaKey = str;
        }

        public String getLifafaName() {
            return this.lifafaName;
        }

        public void setLifafaName(String str) {
            this.lifafaName = str;
        }

        public String getLifafaMessage() {
            return this.lifafaMessage;
        }

        public void setLifafaMessage(String str) {
            this.lifafaMessage = str;
        }

        public String getCategory() {
            return this.category;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public String getCreatorId() {
            return this.creatorId;
        }

        public void setCreatorId(String str) {
            this.creatorId = str;
        }

        public String getLifafaStatus() {
            return this.lifafaStatus;
        }

        public void setLifafaStatus(String str) {
            this.lifafaStatus = str;
        }

        public CreatorInfo getCreatorInfo() {
            return this.creatorInfo;
        }

        public void setCreatorInfo(CreatorInfo creatorInfo2) {
            this.creatorInfo = creatorInfo2;
        }

        public String getStrategyType() {
            return this.strategyType;
        }

        public void setStrategyType(String str) {
            this.strategyType = str;
        }

        public String getDistributionType() {
            return this.distributionType;
        }

        public void setDistributionType(String str) {
            this.distributionType = str;
        }

        public int getProposedReceiverCount() {
            return this.proposedReceiverCount;
        }

        public void setProposedReceiverCount(int i2) {
            this.proposedReceiverCount = i2;
        }

        public BigDecimal getProposedQuantity() {
            return this.proposedQuantity;
        }

        public void setProposedQuantity(BigDecimal bigDecimal) {
            this.proposedQuantity = bigDecimal;
        }

        public String getActivationTimestamp() {
            return this.activationTimestamp;
        }

        public void setActivationTimestamp(String str) {
            this.activationTimestamp = str;
        }

        public String getExpiryTimestamp() {
            return this.expiryTimestamp;
        }

        public void setExpiryTimestamp(String str) {
            this.expiryTimestamp = str;
        }

        public String getCreateTimestamp() {
            return this.createTimestamp;
        }

        public void setCreateTimestamp(String str) {
            this.createTimestamp = str;
        }

        public String getCategoryMappingId() {
            return this.categoryMappingId;
        }

        public void setCategoryMappingId(String str) {
            this.categoryMappingId = str;
        }

        public String getThemeGuid() {
            return this.themeGuid;
        }

        public void setThemeGuid(String str) {
            this.themeGuid = str;
        }

        public String getUnit() {
            return this.unit;
        }

        public void setUnit(String str) {
            this.unit = str;
        }

        public String getCategoryResponseMetadata() {
            return this.categoryResponseMetadata;
        }

        public void setCategoryResponseMetadata(String str) {
            this.categoryResponseMetadata = str;
        }

        public String getMetadata() {
            return this.metadata;
        }

        public void setMetadata(String str) {
            this.metadata = str;
        }

        public boolean getShowOtherRecipientsInfo() {
            return this.showOtherRecipientsInfo;
        }

        public void setShowOtherRecipientsInfo(boolean z) {
            this.showOtherRecipientsInfo = z;
        }

        public String getCreatorType() {
            return this.creatorType;
        }

        public void setCreatorType(String str) {
            this.creatorType = str;
        }

        public String getCreatorLogo() {
            return this.creatorLogo;
        }

        public void setCreatorLogo(String str) {
            this.creatorLogo = str;
        }

        public String getQrCodeId() {
            return this.qrCodeId;
        }

        public void setQrCodeId(String str) {
            this.qrCodeId = str;
        }
    }

    public static class RecipientDetails implements IJRDataModel {
        private String actualQuantity;
        private String categoryProcessedMetadata;
        private String processTimestamp;
        private BigDecimal proposedQuantity;
        private RecipientInfo recipientInfo;
        private String recipientStatus;
        private String statusMessage;

        public RecipientInfo getRecipientInfo() {
            return this.recipientInfo;
        }

        public void setRecipientInfo(RecipientInfo recipientInfo2) {
            this.recipientInfo = recipientInfo2;
        }

        public String getRecipientStatus() {
            return this.recipientStatus;
        }

        public void setRecipientStatus(String str) {
            this.recipientStatus = str;
        }

        public String getStatusMessage() {
            return this.statusMessage;
        }

        public void setStatusMessage(String str) {
            this.statusMessage = str;
        }

        public BigDecimal getProposedQuantity() {
            return this.proposedQuantity;
        }

        public void setProposedQuantity(BigDecimal bigDecimal) {
            this.proposedQuantity = bigDecimal;
        }

        public String getActualQuantity() {
            return this.actualQuantity;
        }

        public void setActualQuantity(String str) {
            this.actualQuantity = str;
        }

        public String getProcessTimestamp() {
            return this.processTimestamp;
        }

        public void setProcessTimestamp(String str) {
            this.processTimestamp = str;
        }

        public String getCategoryProcessedMetadata() {
            return this.categoryProcessedMetadata;
        }

        public void setCategoryProcessedMetadata(String str) {
            this.categoryProcessedMetadata = str;
        }
    }

    public static class RecipientInfo implements IJRDataModel {
        private String emailId;
        private String name;
        private String phoneNo;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getPhoneNo() {
            return this.phoneNo;
        }

        public void setPhoneNo(String str) {
            this.phoneNo = str;
        }

        public String getEmailId() {
            return this.emailId;
        }

        public void setEmailId(String str) {
            this.emailId = str;
        }
    }

    public static class LifafaFetcherDetails implements IJRDataModel {
        private String actualQuantity;
        private String categoryProcessedMetadata;
        private String processTimestamp;
        private BigDecimal proposedQuantity;
        private RecipientInfo recipientInfo;
        private String recipientStatus;
        private String statusMessage;

        public RecipientInfo getRecipientInfo() {
            return this.recipientInfo;
        }

        public void setRecipientInfo(RecipientInfo recipientInfo2) {
            this.recipientInfo = recipientInfo2;
        }

        public String getRecipientStatus() {
            return this.recipientStatus;
        }

        public void setRecipientStatus(String str) {
            this.recipientStatus = str;
        }

        public String getStatusMessage() {
            return this.statusMessage;
        }

        public void setStatusMessage(String str) {
            this.statusMessage = str;
        }

        public BigDecimal getProposedQuantity() {
            return this.proposedQuantity;
        }

        public void setProposedQuantity(BigDecimal bigDecimal) {
            this.proposedQuantity = bigDecimal;
        }

        public String getActualQuantity() {
            return this.actualQuantity;
        }

        public void setActualQuantity(String str) {
            this.actualQuantity = str;
        }

        public String getProcessTimestamp() {
            return this.processTimestamp;
        }

        public void setProcessTimestamp(String str) {
            this.processTimestamp = str;
        }

        public String getCategoryProcessedMetadata() {
            return this.categoryProcessedMetadata;
        }

        public void setCategoryProcessedMetadata(String str) {
            this.categoryProcessedMetadata = str;
        }
    }

    public static class ThumbnailView implements IJRDataModel {
        private String resolution;
        private String url1;

        public String getResolution() {
            return this.resolution;
        }

        public void setResolution(String str) {
            this.resolution = str;
        }

        public String getUrl1() {
            return this.url1;
        }

        public void setUrl1(String str) {
            this.url1 = str;
        }
    }

    public static class SummaryView implements IJRDataModel {
        private String resolution;
        private String url1;

        public String getResolution() {
            return this.resolution;
        }

        public void setResolution(String str) {
            this.resolution = str;
        }

        public String getUrl1() {
            return this.url1;
        }

        public void setUrl1(String str) {
            this.url1 = str;
        }
    }

    public static class ApplicationView implements IJRDataModel {
        private String resolution;
        private String url1;
        private String url2;
        private String url3;
        private String url4;

        public String getResolution() {
            return this.resolution;
        }

        public void setResolution(String str) {
            this.resolution = str;
        }

        public String getUrl1() {
            return this.url1;
        }

        public void setUrl1(String str) {
            this.url1 = str;
        }

        public String getUrl2() {
            return this.url2;
        }

        public void setUrl2(String str) {
            this.url2 = str;
        }

        public String getUrl3() {
            return this.url3;
        }

        public void setUrl3(String str) {
            this.url3 = str;
        }

        public String getUrl4() {
            return this.url4;
        }

        public void setUrl4(String str) {
            this.url4 = str;
        }
    }

    public static class Themes implements IJRDataModel {
        private List<ApplicationView> applicationView;
        private List<PassbookView> passbookView;
        private List<PushView> pushView;
        private List<SummaryView> summaryView;
        private List<ThumbnailView> thumbnailView;

        public List<ThumbnailView> getThumbnailView() {
            return this.thumbnailView;
        }

        public void setThumbnailView(List<ThumbnailView> list) {
            this.thumbnailView = list;
        }

        public List<PassbookView> getPassbookView() {
            return this.passbookView;
        }

        public void setPassbookView(List<PassbookView> list) {
            this.passbookView = list;
        }

        public List<PushView> getPushView() {
            return this.pushView;
        }

        public void setPushView(List<PushView> list) {
            this.pushView = list;
        }

        public List<SummaryView> getSummaryView() {
            return this.summaryView;
        }

        public void setSummaryView(List<SummaryView> list) {
            this.summaryView = list;
        }

        public List<ApplicationView> getApplicationView() {
            return this.applicationView;
        }

        public void setApplicationView(List<ApplicationView> list) {
            this.applicationView = list;
        }
    }

    public static class ThemeDetailsResponse implements IJRDataModel {
        private String additionalCharges;
        private String amount;
        private String category;
        private String description;
        private boolean hasMoreThemes;
        private String id;
        private boolean paid;
        private String subCategory;
        private String themeName;
        private Themes themes;

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public Themes getThemes() {
            return this.themes;
        }

        public void setThemes(Themes themes2) {
            this.themes = themes2;
        }

        public String getThemeName() {
            return this.themeName;
        }

        public void setThemeName(String str) {
            this.themeName = str;
        }

        public boolean getPaid() {
            return this.paid;
        }

        public void setPaid(boolean z) {
            this.paid = z;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public String getAmount() {
            return this.amount;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public String getCategory() {
            return this.category;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public String getSubCategory() {
            return this.subCategory;
        }

        public void setSubCategory(String str) {
            this.subCategory = str;
        }

        public String getAdditionalCharges() {
            return this.additionalCharges;
        }

        public void setAdditionalCharges(String str) {
            this.additionalCharges = str;
        }

        public boolean getHasMoreThemes() {
            return this.hasMoreThemes;
        }

        public void setHasMoreThemes(boolean z) {
            this.hasMoreThemes = z;
        }
    }
}
