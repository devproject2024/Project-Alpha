package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class IDCResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "idcDetails")
    private IdcDetails idcDetails;
    @b(a = "pdcDetails")
    private PdcDetails pdcDetails;

    public IdcDetails getIdcDetails() {
        return this.idcDetails;
    }

    public void setIdcDetails(IdcDetails idcDetails2) {
        this.idcDetails = idcDetails2;
    }

    public PdcDetails getPdcDetails() {
        return this.pdcDetails;
    }

    public void setPdcDetails(PdcDetails pdcDetails2) {
        this.pdcDetails = pdcDetails2;
    }

    public static class IdcDetails extends IJRPaytmDataModel {
        @b(a = "cardAlias")
        private String cardAlias;
        @b(a = "cardStatus")
        private String cardStatus;
        @b(a = "marketPlace")
        private boolean marketPlace;
        @b(a = "maskedCardNumber")
        private String maskedCardNumber;
        @b(a = "qrCode")
        private String qrCode;
        @b(a = "status")
        private String status;

        public String getCardAlias() {
            return this.cardAlias;
        }

        public void setCardAlias(String str) {
            this.cardAlias = str;
        }

        public String getCardStatus() {
            return this.cardStatus;
        }

        public void setCardStatus(String str) {
            this.cardStatus = str;
        }

        public String getMaskedCardNumber() {
            return this.maskedCardNumber;
        }

        public void setMaskedCardNumber(String str) {
            this.maskedCardNumber = str;
        }

        public String getQrCode() {
            return this.qrCode;
        }

        public void setQrCode(String str) {
            this.qrCode = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public boolean isMarketPlace() {
            return this.marketPlace;
        }

        public void setMarketPlace(boolean z) {
            this.marketPlace = z;
        }
    }

    public static class PdcDetails extends IJRPaytmDataModel {
        @b(a = "cardAliasNumber")
        private String cardAliasNumber;
        @b(a = "cardStatus")
        private String cardStatus;
        @b(a = "imageId")
        private String imageId;
        @b(a = "marketPlace")
        private boolean marketPlace;
        @b(a = "maskedCardNumber")
        private String maskedCardNumber;
        @b(a = "orderId")
        private String orderId;
        @b(a = "qrCode")
        private String qrCode;
        @b(a = "status")
        private String status;

        public String getCardAliasNumber() {
            return this.cardAliasNumber;
        }

        public void setCardAliasNumber(String str) {
            this.cardAliasNumber = str;
        }

        public String getCardStatus() {
            return this.cardStatus;
        }

        public void setCardStatus(String str) {
            this.cardStatus = str;
        }

        public String getImageId() {
            return this.imageId;
        }

        public void setImageId(String str) {
            this.imageId = str;
        }

        public String getMaskedCardNumber() {
            return this.maskedCardNumber;
        }

        public void setMaskedCardNumber(String str) {
            this.maskedCardNumber = str;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public String getQrCode() {
            return this.qrCode;
        }

        public void setQrCode(String str) {
            this.qrCode = str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public boolean isMarketPlace() {
            return this.marketPlace;
        }

        public void setMarketPlace(boolean z) {
            this.marketPlace = z;
        }
    }
}
