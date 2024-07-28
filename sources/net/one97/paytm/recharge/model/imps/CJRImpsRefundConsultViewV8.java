package net.one97.paytm.recharge.model.imps;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public final class CJRImpsRefundConsultViewV8 extends IJRPaytmDataModel {
    private String cancelUrl;
    private CJRRefundAllocatedInfoV8 locallySelectedRefundAccount;
    private String orderId;
    private CJROrderSummary orderSummary;
    private CJRRefundAllocatedInfoV8 orgSelectedRefundAccount;
    private int orgSelectedRefundAccountIndex = -1;
    @b(a = "refundConsultViews")
    private final List<CJRRefundConsultViewV8> otherRefundConsultView;
    private Double refundAmount;
    @b(a = "securityId")
    private final String securityId;
    private int selectedIndex = -1;
    private Integer status = -1;
    private HashMap<String, Boolean> usedPaymentSource = new HashMap<>();
    @b(a = "walletView")
    private final CJRWalletViewV8 walletView;

    public final CJRWalletViewV8 getWalletView() {
        return this.walletView;
    }

    public final List<CJRRefundConsultViewV8> getOtherRefundConsultView() {
        return this.otherRefundConsultView;
    }

    public final String getSecurityId() {
        return this.securityId;
    }

    public final HashMap<String, Boolean> getUsedPaymentSource() {
        return this.usedPaymentSource;
    }

    public final void setUsedPaymentSource(HashMap<String, Boolean> hashMap) {
        k.c(hashMap, "<set-?>");
        this.usedPaymentSource = hashMap;
    }

    public final Double getRefundAmount() {
        return this.refundAmount;
    }

    public final void setRefundAmount(Double d2) {
        this.refundAmount = d2;
    }

    public final CJRRefundAllocatedInfoV8 getOrgSelectedRefundAccount() {
        return this.orgSelectedRefundAccount;
    }

    public final void setOrgSelectedRefundAccount(CJRRefundAllocatedInfoV8 cJRRefundAllocatedInfoV8) {
        this.orgSelectedRefundAccount = cJRRefundAllocatedInfoV8;
    }

    public final CJRRefundAllocatedInfoV8 getLocallySelectedRefundAccount() {
        return this.locallySelectedRefundAccount;
    }

    public final void setLocallySelectedRefundAccount(CJRRefundAllocatedInfoV8 cJRRefundAllocatedInfoV8) {
        this.locallySelectedRefundAccount = cJRRefundAllocatedInfoV8;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getCancelUrl() {
        return this.cancelUrl;
    }

    public final void setCancelUrl(String str) {
        this.cancelUrl = str;
    }

    public final CJROrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public final void setOrderSummary(CJROrderSummary cJROrderSummary) {
        this.orderSummary = cJROrderSummary;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void setSelectedIndex(int i2) {
        this.selectedIndex = i2;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final int getOrgSelectedRefundAccountIndex() {
        return this.orgSelectedRefundAccountIndex;
    }

    public final void setOrgSelectedRefundAccountIndex(int i2) {
        this.orgSelectedRefundAccountIndex = i2;
    }
}
