package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility;
import net.one97.paytm.nativesdk.instruments.upipush.model.BaseVpaDetail;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class UPIRequestModel extends PaymentRequestModel {
    private final String deviceId;
    private final PaymentUtility.FlowType flowType;
    private final String pin;
    private final String sequenceNo;
    private final BaseVpaDetail vpaDetail;

    public final PaymentUtility.FlowType getFlowType() {
        return this.flowType;
    }

    public final String getPin() {
        return this.pin;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UPIRequestModel(String str, PaymentUtility.FlowType flowType2, String str2, String str3, String str4, BaseVpaDetail baseVpaDetail) {
        super(str2);
        k.c(str, "pin");
        k.c(flowType2, "flowType");
        k.c(str2, PayUtility.PAYMENT_FLOW);
        k.c(str3, "sequenceNo");
        k.c(str4, "deviceId");
        k.c(baseVpaDetail, "vpaDetail");
        this.pin = str;
        this.flowType = flowType2;
        this.sequenceNo = str3;
        this.deviceId = str4;
        this.vpaDetail = baseVpaDetail;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getSequenceNo() {
        return this.sequenceNo;
    }

    public final BaseVpaDetail getVpaDetail() {
        return this.vpaDetail;
    }
}
