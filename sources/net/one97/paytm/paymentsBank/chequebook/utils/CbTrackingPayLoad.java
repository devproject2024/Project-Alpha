package net.one97.paytm.paymentsBank.chequebook.utils;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CbTrackingPayLoad extends IJRPaytmDataModel {
    @b(a = "price")
    private final Double amount;
    @b(a = "cancellationReason")
    private final String cancellationReason;
    @b(a = "courierDetail")
    private final CbCourierDetail courierDetail;
    @b(a = "createdAt")
    private final String createdAt;
    @b(a = "currentStatus")
    private final String currentStatus;
    @b(a = "currentStatusId")
    private final Integer currentStatusId;
    @b(a = "customerId")
    private final Integer customerId;
    @b(a = "expectedDateOfDelivery")
    private final String expectedDateOfDelivery;
    @b(a = "name")
    private final String name;
    @b(a = "orderId")
    private final Integer orderId;
    @b(a = "productId")
    private final String productId;
    @b(a = "paymentStatus")
    private final String productName;
    @b(a = "quantity")
    private final Integer quantity;
    @b(a = "reIssue")
    private final String reIssue;
    @b(a = "statusFlow")
    private final List<CbTrackingStatusFlow> statusFlow;
    @b(a = "userDetail")
    private final CbUserDetails userDetail;

    public static /* synthetic */ CbTrackingPayLoad copy$default(CbTrackingPayLoad cbTrackingPayLoad, Integer num, String str, String str2, Double d2, String str3, String str4, Integer num2, String str5, Integer num3, List list, CbUserDetails cbUserDetails, CbCourierDetail cbCourierDetail, String str6, Integer num4, String str7, String str8, int i2, Object obj) {
        CbTrackingPayLoad cbTrackingPayLoad2 = cbTrackingPayLoad;
        int i3 = i2;
        return cbTrackingPayLoad.copy((i3 & 1) != 0 ? cbTrackingPayLoad2.orderId : num, (i3 & 2) != 0 ? cbTrackingPayLoad2.productName : str, (i3 & 4) != 0 ? cbTrackingPayLoad2.createdAt : str2, (i3 & 8) != 0 ? cbTrackingPayLoad2.amount : d2, (i3 & 16) != 0 ? cbTrackingPayLoad2.expectedDateOfDelivery : str3, (i3 & 32) != 0 ? cbTrackingPayLoad2.currentStatus : str4, (i3 & 64) != 0 ? cbTrackingPayLoad2.currentStatusId : num2, (i3 & 128) != 0 ? cbTrackingPayLoad2.name : str5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cbTrackingPayLoad2.quantity : num3, (i3 & 512) != 0 ? cbTrackingPayLoad2.statusFlow : list, (i3 & TarConstants.EOF_BLOCK) != 0 ? cbTrackingPayLoad2.userDetail : cbUserDetails, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cbTrackingPayLoad2.courierDetail : cbCourierDetail, (i3 & 4096) != 0 ? cbTrackingPayLoad2.reIssue : str6, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cbTrackingPayLoad2.customerId : num4, (i3 & 16384) != 0 ? cbTrackingPayLoad2.cancellationReason : str7, (i3 & 32768) != 0 ? cbTrackingPayLoad2.productId : str8);
    }

    public final Integer component1() {
        return this.orderId;
    }

    public final List<CbTrackingStatusFlow> component10() {
        return this.statusFlow;
    }

    public final CbUserDetails component11() {
        return this.userDetail;
    }

    public final CbCourierDetail component12() {
        return this.courierDetail;
    }

    public final String component13() {
        return this.reIssue;
    }

    public final Integer component14() {
        return this.customerId;
    }

    public final String component15() {
        return this.cancellationReason;
    }

    public final String component16() {
        return this.productId;
    }

    public final String component2() {
        return this.productName;
    }

    public final String component3() {
        return this.createdAt;
    }

    public final Double component4() {
        return this.amount;
    }

    public final String component5() {
        return this.expectedDateOfDelivery;
    }

    public final String component6() {
        return this.currentStatus;
    }

    public final Integer component7() {
        return this.currentStatusId;
    }

    public final String component8() {
        return this.name;
    }

    public final Integer component9() {
        return this.quantity;
    }

    public final CbTrackingPayLoad copy(Integer num, String str, String str2, Double d2, String str3, String str4, Integer num2, String str5, Integer num3, List<CbTrackingStatusFlow> list, CbUserDetails cbUserDetails, CbCourierDetail cbCourierDetail, String str6, Integer num4, String str7, String str8) {
        return new CbTrackingPayLoad(num, str, str2, d2, str3, str4, num2, str5, num3, list, cbUserDetails, cbCourierDetail, str6, num4, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbTrackingPayLoad)) {
            return false;
        }
        CbTrackingPayLoad cbTrackingPayLoad = (CbTrackingPayLoad) obj;
        return k.a((Object) this.orderId, (Object) cbTrackingPayLoad.orderId) && k.a((Object) this.productName, (Object) cbTrackingPayLoad.productName) && k.a((Object) this.createdAt, (Object) cbTrackingPayLoad.createdAt) && k.a((Object) this.amount, (Object) cbTrackingPayLoad.amount) && k.a((Object) this.expectedDateOfDelivery, (Object) cbTrackingPayLoad.expectedDateOfDelivery) && k.a((Object) this.currentStatus, (Object) cbTrackingPayLoad.currentStatus) && k.a((Object) this.currentStatusId, (Object) cbTrackingPayLoad.currentStatusId) && k.a((Object) this.name, (Object) cbTrackingPayLoad.name) && k.a((Object) this.quantity, (Object) cbTrackingPayLoad.quantity) && k.a((Object) this.statusFlow, (Object) cbTrackingPayLoad.statusFlow) && k.a((Object) this.userDetail, (Object) cbTrackingPayLoad.userDetail) && k.a((Object) this.courierDetail, (Object) cbTrackingPayLoad.courierDetail) && k.a((Object) this.reIssue, (Object) cbTrackingPayLoad.reIssue) && k.a((Object) this.customerId, (Object) cbTrackingPayLoad.customerId) && k.a((Object) this.cancellationReason, (Object) cbTrackingPayLoad.cancellationReason) && k.a((Object) this.productId, (Object) cbTrackingPayLoad.productId);
    }

    public final int hashCode() {
        Integer num = this.orderId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.productName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.createdAt;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str3 = this.expectedDateOfDelivery;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.currentStatus;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num2 = this.currentStatusId;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str5 = this.name;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num3 = this.quantity;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 31;
        List<CbTrackingStatusFlow> list = this.statusFlow;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        CbUserDetails cbUserDetails = this.userDetail;
        int hashCode11 = (hashCode10 + (cbUserDetails != null ? cbUserDetails.hashCode() : 0)) * 31;
        CbCourierDetail cbCourierDetail = this.courierDetail;
        int hashCode12 = (hashCode11 + (cbCourierDetail != null ? cbCourierDetail.hashCode() : 0)) * 31;
        String str6 = this.reIssue;
        int hashCode13 = (hashCode12 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num4 = this.customerId;
        int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str7 = this.cancellationReason;
        int hashCode15 = (hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.productId;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode15 + i2;
    }

    public final String toString() {
        return "CbTrackingPayLoad(orderId=" + this.orderId + ", productName=" + this.productName + ", createdAt=" + this.createdAt + ", amount=" + this.amount + ", expectedDateOfDelivery=" + this.expectedDateOfDelivery + ", currentStatus=" + this.currentStatus + ", currentStatusId=" + this.currentStatusId + ", name=" + this.name + ", quantity=" + this.quantity + ", statusFlow=" + this.statusFlow + ", userDetail=" + this.userDetail + ", courierDetail=" + this.courierDetail + ", reIssue=" + this.reIssue + ", customerId=" + this.customerId + ", cancellationReason=" + this.cancellationReason + ", productId=" + this.productId + ")";
    }

    public final Integer getOrderId() {
        return this.orderId;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getExpectedDateOfDelivery() {
        return this.expectedDateOfDelivery;
    }

    public final String getCurrentStatus() {
        return this.currentStatus;
    }

    public final Integer getCurrentStatusId() {
        return this.currentStatusId;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final List<CbTrackingStatusFlow> getStatusFlow() {
        return this.statusFlow;
    }

    public final CbUserDetails getUserDetail() {
        return this.userDetail;
    }

    public final CbCourierDetail getCourierDetail() {
        return this.courierDetail;
    }

    public final String getReIssue() {
        return this.reIssue;
    }

    public final Integer getCustomerId() {
        return this.customerId;
    }

    public final String getCancellationReason() {
        return this.cancellationReason;
    }

    public CbTrackingPayLoad(Integer num, String str, String str2, Double d2, String str3, String str4, Integer num2, String str5, Integer num3, List<CbTrackingStatusFlow> list, CbUserDetails cbUserDetails, CbCourierDetail cbCourierDetail, String str6, Integer num4, String str7, String str8) {
        this.orderId = num;
        this.productName = str;
        this.createdAt = str2;
        this.amount = d2;
        this.expectedDateOfDelivery = str3;
        this.currentStatus = str4;
        this.currentStatusId = num2;
        this.name = str5;
        this.quantity = num3;
        this.statusFlow = list;
        this.userDetail = cbUserDetails;
        this.courierDetail = cbCourierDetail;
        this.reIssue = str6;
        this.customerId = num4;
        this.cancellationReason = str7;
        this.productId = str8;
    }

    public final String getProductId() {
        return this.productId;
    }
}
