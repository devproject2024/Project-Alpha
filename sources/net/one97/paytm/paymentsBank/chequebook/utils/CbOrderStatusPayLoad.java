package net.one97.paytm.paymentsBank.chequebook.utils;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CbOrderStatusPayLoad extends IJRPaytmDataModel {
    @b(a = "address")
    private final String address;
    @b(a = "agentCaNumber")
    private final Integer agentCaNumber;
    @b(a = "agentCustId")
    private final Integer agentCustId;
    @b(a = "amount")
    private final Double amount;
    @b(a = "authenticationState")
    private final String authenticationState;
    @b(a = "beneficiaryName")
    private final String beneficiaryName;
    @b(a = "benfAccountNumber")
    private final Integer benfAccountNumber;
    @b(a = "benfCustId")
    private final Integer benfCustId;
    @b(a = "benfMobNumber")
    private final Integer benfMobNumber;
    @b(a = "created")
    private final Integer created;
    @b(a = "depositorName")
    private final String depositorName;
    @b(a = "modeOfTransaction")
    private final String modeOfTransaction;
    @b(a = "orderId")
    private final Integer orderId;
    @b(a = "productId")
    private final Integer productId;
    @b(a = "productName")
    private final String productName;
    @b(a = "responseMessage")
    private final String responseMessage;
    @b(a = "status")
    private final String status;
    @b(a = "transactionResponse")
    private final String transactionResponse;
    @b(a = "transactionState")
    private final String transactionState;

    public static /* synthetic */ CbOrderStatusPayLoad copy$default(CbOrderStatusPayLoad cbOrderStatusPayLoad, Integer num, String str, Integer num2, Double d2, String str2, String str3, String str4, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str5, String str6, String str7, Integer num8, String str8, String str9, String str10, int i2, Object obj) {
        CbOrderStatusPayLoad cbOrderStatusPayLoad2 = cbOrderStatusPayLoad;
        int i3 = i2;
        return cbOrderStatusPayLoad.copy((i3 & 1) != 0 ? cbOrderStatusPayLoad2.orderId : num, (i3 & 2) != 0 ? cbOrderStatusPayLoad2.productName : str, (i3 & 4) != 0 ? cbOrderStatusPayLoad2.productId : num2, (i3 & 8) != 0 ? cbOrderStatusPayLoad2.amount : d2, (i3 & 16) != 0 ? cbOrderStatusPayLoad2.modeOfTransaction : str2, (i3 & 32) != 0 ? cbOrderStatusPayLoad2.depositorName : str3, (i3 & 64) != 0 ? cbOrderStatusPayLoad2.beneficiaryName : str4, (i3 & 128) != 0 ? cbOrderStatusPayLoad2.benfAccountNumber : num3, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cbOrderStatusPayLoad2.benfMobNumber : num4, (i3 & 512) != 0 ? cbOrderStatusPayLoad2.agentCustId : num5, (i3 & TarConstants.EOF_BLOCK) != 0 ? cbOrderStatusPayLoad2.agentCaNumber : num6, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cbOrderStatusPayLoad2.benfCustId : num7, (i3 & 4096) != 0 ? cbOrderStatusPayLoad2.status : str5, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cbOrderStatusPayLoad2.transactionState : str6, (i3 & 16384) != 0 ? cbOrderStatusPayLoad2.responseMessage : str7, (i3 & 32768) != 0 ? cbOrderStatusPayLoad2.created : num8, (i3 & 65536) != 0 ? cbOrderStatusPayLoad2.transactionResponse : str8, (i3 & 131072) != 0 ? cbOrderStatusPayLoad2.address : str9, (i3 & 262144) != 0 ? cbOrderStatusPayLoad2.authenticationState : str10);
    }

    public final Integer component1() {
        return this.orderId;
    }

    public final Integer component10() {
        return this.agentCustId;
    }

    public final Integer component11() {
        return this.agentCaNumber;
    }

    public final Integer component12() {
        return this.benfCustId;
    }

    public final String component13() {
        return this.status;
    }

    public final String component14() {
        return this.transactionState;
    }

    public final String component15() {
        return this.responseMessage;
    }

    public final Integer component16() {
        return this.created;
    }

    public final String component17() {
        return this.transactionResponse;
    }

    public final String component18() {
        return this.address;
    }

    public final String component19() {
        return this.authenticationState;
    }

    public final String component2() {
        return this.productName;
    }

    public final Integer component3() {
        return this.productId;
    }

    public final Double component4() {
        return this.amount;
    }

    public final String component5() {
        return this.modeOfTransaction;
    }

    public final String component6() {
        return this.depositorName;
    }

    public final String component7() {
        return this.beneficiaryName;
    }

    public final Integer component8() {
        return this.benfAccountNumber;
    }

    public final Integer component9() {
        return this.benfMobNumber;
    }

    public final CbOrderStatusPayLoad copy(Integer num, String str, Integer num2, Double d2, String str2, String str3, String str4, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str5, String str6, String str7, Integer num8, String str8, String str9, String str10) {
        return new CbOrderStatusPayLoad(num, str, num2, d2, str2, str3, str4, num3, num4, num5, num6, num7, str5, str6, str7, num8, str8, str9, str10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbOrderStatusPayLoad)) {
            return false;
        }
        CbOrderStatusPayLoad cbOrderStatusPayLoad = (CbOrderStatusPayLoad) obj;
        return k.a((Object) this.orderId, (Object) cbOrderStatusPayLoad.orderId) && k.a((Object) this.productName, (Object) cbOrderStatusPayLoad.productName) && k.a((Object) this.productId, (Object) cbOrderStatusPayLoad.productId) && k.a((Object) this.amount, (Object) cbOrderStatusPayLoad.amount) && k.a((Object) this.modeOfTransaction, (Object) cbOrderStatusPayLoad.modeOfTransaction) && k.a((Object) this.depositorName, (Object) cbOrderStatusPayLoad.depositorName) && k.a((Object) this.beneficiaryName, (Object) cbOrderStatusPayLoad.beneficiaryName) && k.a((Object) this.benfAccountNumber, (Object) cbOrderStatusPayLoad.benfAccountNumber) && k.a((Object) this.benfMobNumber, (Object) cbOrderStatusPayLoad.benfMobNumber) && k.a((Object) this.agentCustId, (Object) cbOrderStatusPayLoad.agentCustId) && k.a((Object) this.agentCaNumber, (Object) cbOrderStatusPayLoad.agentCaNumber) && k.a((Object) this.benfCustId, (Object) cbOrderStatusPayLoad.benfCustId) && k.a((Object) this.status, (Object) cbOrderStatusPayLoad.status) && k.a((Object) this.transactionState, (Object) cbOrderStatusPayLoad.transactionState) && k.a((Object) this.responseMessage, (Object) cbOrderStatusPayLoad.responseMessage) && k.a((Object) this.created, (Object) cbOrderStatusPayLoad.created) && k.a((Object) this.transactionResponse, (Object) cbOrderStatusPayLoad.transactionResponse) && k.a((Object) this.address, (Object) cbOrderStatusPayLoad.address) && k.a((Object) this.authenticationState, (Object) cbOrderStatusPayLoad.authenticationState);
    }

    public final int hashCode() {
        Integer num = this.orderId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.productName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.productId;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str2 = this.modeOfTransaction;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.depositorName;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.beneficiaryName;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num3 = this.benfAccountNumber;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.benfMobNumber;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.agentCustId;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.agentCaNumber;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.benfCustId;
        int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 31;
        String str5 = this.status;
        int hashCode13 = (hashCode12 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.transactionState;
        int hashCode14 = (hashCode13 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.responseMessage;
        int hashCode15 = (hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Integer num8 = this.created;
        int hashCode16 = (hashCode15 + (num8 != null ? num8.hashCode() : 0)) * 31;
        String str8 = this.transactionResponse;
        int hashCode17 = (hashCode16 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.address;
        int hashCode18 = (hashCode17 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.authenticationState;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode18 + i2;
    }

    public final String toString() {
        return "CbOrderStatusPayLoad(orderId=" + this.orderId + ", productName=" + this.productName + ", productId=" + this.productId + ", amount=" + this.amount + ", modeOfTransaction=" + this.modeOfTransaction + ", depositorName=" + this.depositorName + ", beneficiaryName=" + this.beneficiaryName + ", benfAccountNumber=" + this.benfAccountNumber + ", benfMobNumber=" + this.benfMobNumber + ", agentCustId=" + this.agentCustId + ", agentCaNumber=" + this.agentCaNumber + ", benfCustId=" + this.benfCustId + ", status=" + this.status + ", transactionState=" + this.transactionState + ", responseMessage=" + this.responseMessage + ", created=" + this.created + ", transactionResponse=" + this.transactionResponse + ", address=" + this.address + ", authenticationState=" + this.authenticationState + ")";
    }

    public final Integer getOrderId() {
        return this.orderId;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final Integer getProductId() {
        return this.productId;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getModeOfTransaction() {
        return this.modeOfTransaction;
    }

    public final String getDepositorName() {
        return this.depositorName;
    }

    public final String getBeneficiaryName() {
        return this.beneficiaryName;
    }

    public final Integer getBenfAccountNumber() {
        return this.benfAccountNumber;
    }

    public final Integer getBenfMobNumber() {
        return this.benfMobNumber;
    }

    public final Integer getAgentCustId() {
        return this.agentCustId;
    }

    public final Integer getAgentCaNumber() {
        return this.agentCaNumber;
    }

    public final Integer getBenfCustId() {
        return this.benfCustId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTransactionState() {
        return this.transactionState;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final Integer getCreated() {
        return this.created;
    }

    public final String getTransactionResponse() {
        return this.transactionResponse;
    }

    public final String getAddress() {
        return this.address;
    }

    public CbOrderStatusPayLoad(Integer num, String str, Integer num2, Double d2, String str2, String str3, String str4, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str5, String str6, String str7, Integer num8, String str8, String str9, String str10) {
        this.orderId = num;
        this.productName = str;
        this.productId = num2;
        this.amount = d2;
        this.modeOfTransaction = str2;
        this.depositorName = str3;
        this.beneficiaryName = str4;
        this.benfAccountNumber = num3;
        this.benfMobNumber = num4;
        this.agentCustId = num5;
        this.agentCaNumber = num6;
        this.benfCustId = num7;
        this.status = str5;
        this.transactionState = str6;
        this.responseMessage = str7;
        this.created = num8;
        this.transactionResponse = str8;
        this.address = str9;
        this.authenticationState = str10;
    }

    public final String getAuthenticationState() {
        return this.authenticationState;
    }
}
