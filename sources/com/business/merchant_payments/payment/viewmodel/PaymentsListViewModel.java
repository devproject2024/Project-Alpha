package com.business.merchant_payments.payment.viewmodel;

import android.app.Application;
import android.net.Uri;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.orderList.V2OrderListModel;
import com.business.merchant_payments.model.orderSummaryList.DaywiseSummaryListModel;
import com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData;
import com.business.merchant_payments.payment.model.datahelpers.SummaryListDataHelper;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

public class PaymentsListViewModel extends c {
    public final y<b<SummaryDateRangeViewData>> mDateRangeSummeryAPIData = new y<>();
    public final y<b<DaywiseSummaryListModel>> mDaywiseSummaryListAPIData = new y<>();
    public String mEndDate;
    public ObservableBoolean mErrorState = new ObservableBoolean(false);
    public final y<b<NonMigratedPaymentsModel>> mNonMigratedPaymentsAPIData = new y<>();
    public ObservableBoolean mProgressState = new ObservableBoolean(false);
    public String mStartDate;
    public SummaryListDataHelper mSummaryListDataHelper;
    public final y<b<V2OrderListModel>> morePaymentsForDateAPIData = new y<>();
    public String posIdName;

    public boolean isFromMultipleQR() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentsListViewModel(Application application) {
        super(application);
        k.d(application, "application");
    }

    public final y<b<DaywiseSummaryListModel>> getMDaywiseSummaryListAPIData() {
        return this.mDaywiseSummaryListAPIData;
    }

    public final y<b<NonMigratedPaymentsModel>> getMNonMigratedPaymentsAPIData() {
        return this.mNonMigratedPaymentsAPIData;
    }

    public final y<b<V2OrderListModel>> getMorePaymentsForDateAPIData() {
        return this.morePaymentsForDateAPIData;
    }

    public final String getMStartDate() {
        String str = this.mStartDate;
        if (str == null) {
            k.a("mStartDate");
        }
        return str;
    }

    public final void setMStartDate(String str) {
        k.d(str, "<set-?>");
        this.mStartDate = str;
    }

    public final String getMEndDate() {
        String str = this.mEndDate;
        if (str == null) {
            k.a("mEndDate");
        }
        return str;
    }

    public final void setMEndDate(String str) {
        k.d(str, "<set-?>");
        this.mEndDate = str;
    }

    public final ObservableBoolean getMProgressState() {
        return this.mProgressState;
    }

    public final void setMProgressState(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.mProgressState = observableBoolean;
    }

    public final ObservableBoolean getMErrorState() {
        return this.mErrorState;
    }

    public final void setMErrorState(ObservableBoolean observableBoolean) {
        k.d(observableBoolean, "<set-?>");
        this.mErrorState = observableBoolean;
    }

    public final String getPosIdName() {
        return this.posIdName;
    }

    public final void setPosIdName(String str) {
        this.posIdName = str;
    }

    public final SummaryListDataHelper getMSummaryListDataHelper() {
        SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
        if (summaryListDataHelper == null) {
            k.a("mSummaryListDataHelper");
        }
        return summaryListDataHelper;
    }

    public final void setMSummaryListDataHelper(SummaryListDataHelper summaryListDataHelper) {
        k.d(summaryListDataHelper, "<set-?>");
        this.mSummaryListDataHelper = summaryListDataHelper;
    }

    public final y<b<SummaryDateRangeViewData>> getMDateRangeSummeryAPIData() {
        return this.mDateRangeSummeryAPIData;
    }

    public void initDefaultParams() {
        this.mSummaryListDataHelper = new SummaryListDataHelper();
    }

    public final void setDateRange(String str, String str2) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        this.mStartDate = str;
        this.mEndDate = str2;
    }

    public final void setLoadingState(boolean z) {
        this.mProgressState.set(z);
    }

    public final void setErrorState(boolean z) {
        this.mErrorState.set(z);
    }

    public void fetchPayments(int i2) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().i()) {
            SummaryListDataHelper summaryListDataHelper = this.mSummaryListDataHelper;
            if (summaryListDataHelper == null) {
                k.a("mSummaryListDataHelper");
            }
            if (summaryListDataHelper.hasMoreRecords()) {
                String str = this.mStartDate;
                if (str == null) {
                    k.a("mStartDate");
                }
                String str2 = this.mEndDate;
                if (str2 == null) {
                    k.a("mEndDate");
                }
                callDaywiseSummaryListApi(str, str2, i2);
                return;
            }
        }
        String str3 = this.mStartDate;
        if (str3 == null) {
            k.a("mStartDate");
        }
        String str4 = this.mEndDate;
        if (str4 == null) {
            k.a("mEndDate");
        }
        callNonMigratedPaymentsAPI(str3, str4);
    }

    public final void fetchOrderSummery() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new PaymentsListViewModel$fetchOrderSummery$1(this, (d) null), 3, (Object) null);
    }

    private final void callNonMigratedPaymentsAPI(String str, String str2) {
        this.mNonMigratedPaymentsAPIData.setValue(b.a());
        try {
            String nonMigratedAPIUrl = getNonMigratedAPIUrl(str, str2);
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Call<NonMigratedPaymentsModel> callNonMigratedPaymentsApi = instance.getNetworkService().callNonMigratedPaymentsApi(nonMigratedAPIUrl, RequestParamUtil.getRequestHeaderMidParam(getContext()));
            k.b(callNonMigratedPaymentsApi, "PaymentsConfig.getInstan…tHeaderMidParam(context))");
            callNonMigratedPaymentsApi.enqueue(new PaymentsListViewModel$callNonMigratedPaymentsAPI$1(this));
        } catch (Exception unused) {
            this.mNonMigratedPaymentsAPIData.setValue(b.a((Throwable) null));
        }
    }

    private final String getNonMigratedAPIUrl(String str, String str2) {
        try {
            String uri = Uri.parse(GTMDataProviderImpl.Companion.getMInstance().getNonMigratedPaymentsApi()).buildUpon().appendQueryParameter("orderCreatedStartTime", DateUtility.getStartDateOfDifferentFormat(str, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA).appendQueryParameter("orderCreatedEndTime", DateUtility.getEndDateOfDifferentFormat(str2, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA).build().toString();
            k.b(uri, "Uri.parse(baseUrl).build…      .build().toString()");
            return uri;
        } catch (Exception unused) {
            return "";
        }
    }

    public final void getMorePaymentsForDate(String str, int i2) {
        k.d(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        callV2OrderListApiForDate(str, i2);
    }

    private final void callDaywiseSummaryListApi(String str, String str2, int i2) {
        this.mDaywiseSummaryListAPIData.setValue(b.a());
        String dayWiseSummaryListApi = GTMDataProviderImpl.Companion.getMInstance().getDayWiseSummaryListApi();
        String summaryAPIBodyParams = getSummaryAPIBodyParams(str, str2, i2);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        Call<DaywiseSummaryListModel> callDaywiseSummaryListApi = instance.getNetworkService().callDaywiseSummaryListApi(dayWiseSummaryListApi, RequestParamUtil.getRequestHeaderMidParam(getContext()), summaryAPIBodyParams);
        k.b(callDaywiseSummaryListApi, "PaymentsConfig.getInstan…ram(context), bodyParams)");
        callDaywiseSummaryListApi.enqueue(new PaymentsListViewModel$callDaywiseSummaryListApi$1(this));
    }

    private final String getSummaryAPIBodyParams(String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startDate", DateUtility.getStartDateOfDifferentFormat(str, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA);
            jSONObject.put("endDate", DateUtility.getEndDateOfDifferentFormat(str2, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA);
            JSONArray jSONArray = new JSONArray();
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            if (instance.getMerchantDataProvider().l()) {
                jSONArray.put(TransactionType.ACQUIRING);
            }
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            if (instance2.getMerchantDataProvider().k()) {
                jSONArray.put("REFUND");
                jSONArray.put(TransactionType.CANCEL);
            }
            jSONArray.put(AppConstants.ApiNames.CHARGEBACK);
            jSONObject.put("bizTypeList", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put("SUCCESS");
            jSONObject.put("orderStatusList", jSONArray2);
            jSONObject.put("pageEntryNumber", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private final void callV2OrderListApiForDate(String str, int i2) {
        this.morePaymentsForDateAPIData.setValue(b.a());
        String v2OrderList = GTMDataProviderImpl.Companion.getMInstance().getV2OrderList();
        String v2OrderListAPIBodyParams = getV2OrderListAPIBodyParams(str, i2);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        Call<V2OrderListModel> v2OrderList2 = instance.getNetworkService().getV2OrderList(v2OrderList, RequestParamUtil.getRequestHeaderMidParam(getContext()), v2OrderListAPIBodyParams);
        k.b(v2OrderList2, "PaymentsConfig.getInstan…ram(context), bodyParams)");
        v2OrderList2.enqueue(new PaymentsListViewModel$callV2OrderListApiForDate$1(this));
    }

    public String getV2OrderListAPIBodyParams(String str, int i2) {
        k.d(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = DateUtility.getStartDateOfDifferentFormat(str, "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA;
            String str3 = DateUtility.getEndDateOfDifferentFormat(str, "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA;
            jSONObject.put("isSort", true);
            JSONArray jSONArray = new JSONArray();
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            if (instance.getMerchantDataProvider().l()) {
                jSONArray.put(TransactionType.ACQUIRING);
            }
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            if (instance2.getMerchantDataProvider().k()) {
                jSONArray.put("REFUND");
                jSONArray.put(TransactionType.CANCEL);
            }
            jSONArray.put(AppConstants.ApiNames.CHARGEBACK);
            jSONObject.put("bizTypeList", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put("SUCCESS");
            jSONObject.put("orderStatusList", jSONArray2);
            jSONObject.put("pageNum", i2);
            jSONObject.put("pageSize", AppConstants.API_PAGESIZE);
            jSONObject.put("orderCreatedStartTime", str2);
            jSONObject.put("orderCreatedEndTime", str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
