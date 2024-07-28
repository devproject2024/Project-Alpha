package com.business.merchant_payments.newhome;

import android.app.Application;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.homepagedialogs.PaymentNotificationData;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
import com.business.merchant_payments.settlement.model.SettlementBillListDetailModel;
import com.business.merchant_payments.settlement.model.SettlementBillListModel;
import com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel;
import com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel;
import com.business.merchant_payments.utility.MPConstants;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public class AcceptPaymentViewModel extends c {
    public boolean isBillListAPIOngoing;
    public ObservableBoolean isPaymentsTabSelected;
    public final LiveData<b<SettlementBillListDetailModel>> mAlreadySettledBillListModel = new y();
    public final LiveData<b<SettlementBillListDetailModel>> mPendingSettleListModel = new y();
    public final LiveData<BWSettlementM2BTransactionDetailObservableModel> mSelectedSettledBillListDetail = new y();
    public final LiveData<b<SettlementBillListModel>> mSettlementBillListModel = new y();
    public final LiveData<SettlementRangeSummaryModel> mSettlementRangeSummary = new y();
    public final LiveData<SanitizedResponseModel> mStoreFrontAPIResponse = new y();
    public final LiveData<b<TodaySettlementSummaryCardModel>> mTodaySettlementSummary = new y();
    public y<PaymentNotificationData> paymentNotificationData = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcceptPaymentViewModel(Application application) {
        super(application);
        k.d(application, "application");
    }

    public final LiveData<b<TodaySettlementSummaryCardModel>> getMTodaySettlementSummary() {
        return this.mTodaySettlementSummary;
    }

    public final LiveData<b<SettlementBillListModel>> getMSettlementBillListModel() {
        return this.mSettlementBillListModel;
    }

    public final LiveData<b<SettlementBillListDetailModel>> getMAlreadySettledBillListModel() {
        return this.mAlreadySettledBillListModel;
    }

    public final LiveData<b<SettlementBillListDetailModel>> getMPendingSettleListModel() {
        return this.mPendingSettleListModel;
    }

    public final LiveData<BWSettlementM2BTransactionDetailObservableModel> getMSelectedSettledBillListDetail() {
        return this.mSelectedSettledBillListDetail;
    }

    public final LiveData<SanitizedResponseModel> getMStoreFrontAPIResponse() {
        return this.mStoreFrontAPIResponse;
    }

    public final y<PaymentNotificationData> getPaymentNotificationData() {
        return this.paymentNotificationData;
    }

    public final void setPaymentNotificationData(y<PaymentNotificationData> yVar) {
        k.d(yVar, "<set-?>");
        this.paymentNotificationData = yVar;
    }

    public final boolean isBillListAPIOngoing() {
        return this.isBillListAPIOngoing;
    }

    public final void setBillListAPIOngoing(boolean z) {
        this.isBillListAPIOngoing = z;
    }

    public final ObservableBoolean isPaymentsTabSelected() {
        ObservableBoolean observableBoolean = this.isPaymentsTabSelected;
        if (observableBoolean == null) {
            k.a("isPaymentsTabSelected");
        }
        return observableBoolean;
    }

    public final void setPaymentsTabSelected(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.isPaymentsTabSelected = observableBoolean;
    }

    public final boolean isBwWalletSettlement() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getMerchantDataProvider().p();
    }

    public final boolean isSettlementPermissionPresent() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().o()) {
            return true;
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        return instance2.getMerchantDataProvider().p();
    }

    public final boolean isInstantSettlementPermissionPresent() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().J()) {
            return true;
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        return instance2.getMerchantDataProvider().I();
    }

    public final boolean getShoulShowDownloadStatement() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getMerchantDataProvider().n() && MPConstants.isP4BClient();
    }

    public final boolean isBWSettleNowPermissionAllowed() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getMerchantDataProvider().m();
    }

    public final LiveData<SettlementRangeSummaryModel> getMSettlementRangeSummary() {
        return this.mSettlementRangeSummary;
    }

    public final String getMMerchantSettlemntTypeGA() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().p()) {
            return P4BSettlementsDataHelperMP.MERCHANT_TYPE_BW_GA;
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        return instance2.getMerchantDataProvider().J() ? "TWS" : "OS";
    }

    public void initDefaultParams() {
        this.isPaymentsTabSelected = new ObservableBoolean(true);
    }

    public void fetchHomepageData() {
        callStoreFrontAPI();
    }

    public final void getTodaySettlementSummary() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getTodaySettlementSummary$1(this, (d) null), 3, (Object) null);
    }

    public final void getSettlementBillList(int i2, String str, String str2, int i3) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getSettlementBillList$1(this, str, str2, i2, i3, (d) null), 3, (Object) null);
    }

    public final void getAlreadySettledBillList(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getAlreadySettledBillList$1(this, z, (d) null), 3, (Object) null);
    }

    public final void getSettlementBillListDetail(String str, String str2, int i2) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new AcceptPaymentViewModel$getSettlementBillListDetail$1(this, str, str2, i2, (d) null), 3, (Object) null);
    }

    public void callStoreFrontAPI() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new AcceptPaymentViewModel$callStoreFrontAPI$1(this, (d) null), 3, (Object) null);
    }

    public final void fetchSettlementRangeSummary(String str, String str2) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new AcceptPaymentViewModel$fetchSettlementRangeSummary$1(this, str, str2, (d) null), 3, (Object) null);
    }
}
