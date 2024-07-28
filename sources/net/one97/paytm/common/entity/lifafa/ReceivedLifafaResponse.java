package net.one97.paytm.common.entity.lifafa;

import java.math.BigDecimal;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class ReceivedLifafaResponse extends CJRWalletDataModel implements IJRDataModel {
    private List<RecievedLifafaDetails> recievedLifafaDetails;
    private String statusCode;
    private String statusMessage;

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

    public List<RecievedLifafaDetails> getRecievedLifafaDetails() {
        return this.recievedLifafaDetails;
    }

    public void setRecievedLifafaDetails(List<RecievedLifafaDetails> list) {
        this.recievedLifafaDetails = list;
    }

    public static class CreatorInfo implements IJRDataModel {
        private String email;
        private String name;
        private String phoneNo;

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String str) {
            this.email = str;
        }

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
        private String proposedReceiverCount;
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

        public String getProposedReceiverCount() {
            return this.proposedReceiverCount;
        }

        public void setProposedReceiverCount(String str) {
            this.proposedReceiverCount = str;
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

    public static class RecipientInfo implements IJRDataModel {
        private String email;
        private String name;
        private String phoneNo;

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String str) {
            this.email = str;
        }

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
    }

    public static class RecipientDetail implements IJRDataModel {
        private BigDecimal actualQuantity;
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

        public BigDecimal getActualQuantity() {
            return this.actualQuantity;
        }

        public void setActualQuantity(BigDecimal bigDecimal) {
            this.actualQuantity = bigDecimal;
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

    public static class RecievedLifafaDetails implements IJRDataModel {
        private LifafaDetail lifafaDetail;
        private RecipientDetail recipientDetail;

        public LifafaDetail getLifafaDetail() {
            return this.lifafaDetail;
        }

        public void setLifafaDetail(LifafaDetail lifafaDetail2) {
            this.lifafaDetail = lifafaDetail2;
        }

        public RecipientDetail getRecipientDetail() {
            return this.recipientDetail;
        }

        public void setRecipientDetail(RecipientDetail recipientDetail2) {
            this.recipientDetail = recipientDetail2;
        }
    }
}
