package net.one97.paytm.landingpage.utils.bankutil;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class ICACustProductResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "ica")
    private Ica ica;
    @b(a = "isa")
    private Isa isa;
    @b(a = "pdc")
    private Pdc pdc;
    @b(a = "slfdIblCifStatus")
    private Slfd slfdIblCifStatus;
    @b(a = "vdc")
    private Vdc vdc;

    public String getIsaStatus() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.status;
        }
        return null;
    }

    public String getIcaStatus() {
        Ica ica2 = this.ica;
        if (ica2 != null) {
            return ica2.status;
        }
        return null;
    }

    public void setIsaStatus(String str) {
        this.isa.status = str;
    }

    public String getIsaIfsc() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.ifscCode;
        }
        return null;
    }

    public String getIsaAccNum() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.accountNumber;
        }
        return null;
    }

    public boolean isLimitApplicable() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return "SAINF".equals(isa2.productType);
        }
        return true;
    }

    public String getIsaProductType() {
        Isa isa2 = this.isa;
        return isa2 != null ? isa2.productType : "";
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getVdcStatus() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.status;
        }
        return null;
    }

    public String getVdcMaskedCardNum() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.maskedCardNumber;
        }
        return null;
    }

    public String getVdcCardAlias() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.cardAlias;
        }
        return null;
    }

    public String getVdcCardStatus() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.cardStatus;
        }
        return null;
    }

    public String getVdcCardType() {
        Vdc vdc2 = this.vdc;
        if (vdc2 != null) {
            return vdc2.cardType;
        }
        return null;
    }

    public String getSlfdStatus() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.status;
        }
        return null;
    }

    public String getSlfdIblCifId() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.iblCifId;
        }
        return null;
    }

    public String getSlfdActiveStatus() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.slfdStatus;
        }
        return null;
    }

    public String getSlfdProductType() {
        Slfd slfd = this.slfdIblCifStatus;
        if (slfd != null) {
            return slfd.productType;
        }
        return null;
    }

    public Ica getIca() {
        return this.ica;
    }

    public void setIca(Ica ica2) {
        this.ica = ica2;
    }

    public Vdc getVdc() {
        return this.vdc;
    }

    public Pdc getPdc() {
        return this.pdc;
    }

    public String getPdcStatus() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.status;
        }
        return null;
    }

    public String getPdcMaskedCardNum() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.maskedCardNumber;
        }
        return null;
    }

    public String getPdcCardAlias() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.cardAlias;
        }
        return null;
    }

    public String getPdcCardStatus() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.cardStatus;
        }
        return null;
    }

    public String getPdcImageId() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.imageId;
        }
        return null;
    }

    public String getPdcWalletQr() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.walletQRCode;
        }
        return null;
    }

    public String getPDCOrderId() {
        Pdc pdc2 = this.pdc;
        if (pdc2 != null) {
            return pdc2.orderId;
        }
        return null;
    }

    public String getIsaAccountStatus() {
        Isa isa2 = this.isa;
        if (isa2 != null) {
            return isa2.accountStatus;
        }
        return null;
    }

    public Isa getIsa() {
        return this.isa;
    }

    public void setIsa(Isa isa2) {
        this.isa = isa2;
    }

    public void setVdc(Vdc vdc2) {
        this.vdc = vdc2;
    }

    public Slfd getSlfdIblCifStatus() {
        return this.slfdIblCifStatus;
    }

    public void setSlfdIblCifStatus(Slfd slfd) {
        this.slfdIblCifStatus = slfd;
    }

    public void setPdc(Pdc pdc2) {
        this.pdc = pdc2;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: org.json.JSONObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.paytm.network.model.IJRPaytmDataModel parseResponse(java.lang.String r3, com.google.gsonhtcfix.f r4) throws java.lang.Exception {
        /*
            r2 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r3)
            java.lang.String r3 = "response"
            boolean r1 = r0.has(r3)
            if (r1 == 0) goto L_0x0014
            java.lang.Object r3 = r0.remove(r3)
            r0 = r3
            org.json.JSONObject r0 = (org.json.JSONObject) r0
        L_0x0014:
            java.lang.String r3 = r0.toString()
            com.paytm.network.model.IJRPaytmDataModel r3 = super.parseResponse(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.bankutil.ICACustProductResponse.parseResponse(java.lang.String, com.google.gsonhtcfix.f):com.paytm.network.model.IJRPaytmDataModel");
    }

    public class Ica implements IJRDataModel {
        @b(a = "accountNumber")
        private String accountNumber;
        @b(a = "accountStatus")
        private String accountStatus;
        @b(a = "caId")
        private String caId;
        @b(a = "ifscCode")
        private String ifscCode;
        @b(a = "nominees")
        private List<ICANomineeModel> nominees;
        @b(a = "productType")
        private String productType;
        @b(a = "status")
        String status;
        @b(a = "updatedAt")
        private String updatedAt;
        @b(a = "updatedBy")
        private String updatedBy;

        public Ica() {
        }

        public String getAccountNumber() {
            return this.accountNumber;
        }

        public void setAccountNumber(String str) {
            this.accountNumber = str;
        }

        public String getProductType() {
            return this.productType;
        }

        public void setProductType(String str) {
            this.productType = str;
        }

        public String getIfscCode() {
            return this.ifscCode;
        }

        public void setIfscCode(String str) {
            this.ifscCode = str;
        }

        public String getUpdatedBy() {
            return this.updatedBy;
        }

        public void setUpdatedBy(String str) {
            this.updatedBy = str;
        }

        public String getUpdatedAt() {
            return this.updatedAt;
        }

        public void setUpdatedAt(String str) {
            this.updatedAt = str;
        }

        public String getAccountStatus() {
            return this.accountStatus;
        }

        public void setAccountStatus(String str) {
            this.accountStatus = str;
        }

        public String getCaId() {
            return this.caId;
        }

        public void setCaId(String str) {
            this.caId = str;
        }

        public List<ICANomineeModel> getNominees() {
            return this.nominees;
        }

        public void setNominees(List<ICANomineeModel> list) {
            this.nominees = list;
        }
    }

    public class Slfd extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "iblCifId")
        String iblCifId;
        @b(a = "processId")
        String processId;
        @b(a = "productType")
        String productType;
        @b(a = "slfdStatus")
        String slfdStatus;
        @b(a = "status")
        String status;

        public Slfd() {
        }
    }

    public class Pdc extends Vdc implements IJRDataModel {
        @b(a = "imageId")
        String imageId;
        @b(a = "orderId")
        String orderId;
        @b(a = "walletQRCode")
        String walletQRCode;

        public Pdc() {
            super();
        }
    }

    public class Vdc extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "cardAlias")
        String cardAlias;
        @b(a = "cardStatus")
        String cardStatus;
        @b(a = "cardType")
        String cardType;
        @b(a = "maskedCardNumber")
        String maskedCardNumber;
        @b(a = "status")
        String status;

        public Vdc() {
        }
    }

    public class Isa extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "accountNumber")
        String accountNumber;
        @b(a = "accountStatus")
        String accountStatus;
        @b(a = "freezeDescriptionList")
        public List<FreezeDescriptionList> freezeDescriptionList = null;
        @b(a = "ifscCode")
        String ifscCode;
        @b(a = "productType")
        String productType;
        @b(a = "status")
        String status;
        @b(a = "txnActivityStatus")
        public String txnActivityStatus;

        public Isa() {
        }

        public List<FreezeDescriptionList> getFreezeDescriptionList() {
            return this.freezeDescriptionList;
        }

        public void setFreezeDescriptionList(List<FreezeDescriptionList> list) {
            this.freezeDescriptionList = list;
        }
    }

    public static class FreezeDescriptionList extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "actionDescription")
        private String actionDescription;
        @b(a = "actionable")
        private boolean actionable;
        @b(a = "freezeCode")
        private String freezeCode;
        @b(a = "freezeReason")
        private String freezeReason;

        public String getFreezeCode() {
            return this.freezeCode;
        }

        public void setFreezeCode(String str) {
            this.freezeCode = str;
        }

        public String getFreezeReason() {
            return this.freezeReason;
        }

        public void setFreezeReason(String str) {
            this.freezeReason = str;
        }

        public boolean getActionable() {
            return this.actionable;
        }

        public void setActionable(boolean z) {
            this.actionable = z;
        }

        public String getActionDescription() {
            return this.actionDescription;
        }

        public void setActionDescription(String str) {
            this.actionDescription = str;
        }
    }
}
