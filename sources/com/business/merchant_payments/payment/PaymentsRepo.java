package com.business.merchant_payments.payment;

import android.net.Uri;
import android.text.TextUtils;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.model.paymentdaterangesummery.AggregateTxnDetails;
import com.business.merchant_payments.model.paymentdaterangesummery.PayMoneyAmount;
import com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;

public final class PaymentsRepo {
    public static final PaymentsRepo INSTANCE = new PaymentsRepo();

    private final String getNonMigratedAPIUrl(String str, String str2) {
        try {
            String uri = Uri.parse(GTMDataProviderImpl.Companion.getMInstance().getNonMigratedPaymentsApi()).buildUpon().appendQueryParameter("orderCreatedStartTime", DateUtility.getStartDateOfDifferentFormat(str, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA).appendQueryParameter("orderCreatedEndTime", DateUtility.getEndDateOfDifferentFormat(str2, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA).build().toString();
            k.b(uri, "Uri.parse(baseUrl).build…      .build().toString()");
            return uri;
        } catch (Exception unused) {
            return "";
        }
    }

    private final String getV2OrderListAPIBodyParams(String str, int i2) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            String str3 = DateUtility.getStartDateOfDifferentFormat(str, "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA;
            if (DateUtility.isDateCurrentDate(str, "dd MMMM yy")) {
                str2 = DateUtility.getCurrentFormattedDate("yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA;
            } else {
                str2 = DateUtility.getEndDateOfDifferentFormat(str, "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA;
            }
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
            jSONObject.put("orderCreatedStartTime", str3);
            jSONObject.put("orderCreatedEndTime", str2);
            String jSONObject2 = jSONObject.toString();
            k.b(jSONObject2, "bodyParams.toString()");
            return jSONObject2;
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
            String jSONObject3 = jSONObject.toString();
            k.b(jSONObject3, "bodyParams.toString()");
            return jSONObject3;
        }
    }

    public final b<SummaryDateRangeViewData> getProcessedAggregatedDataLiveDataWrapper(Response<AggregateTxnDetails> response) {
        k.d(response, "aggregateTransDetailsResponse");
        AggregateTxnDetails body = response.body();
        k.a((Object) body);
        k.b(body, "aggregateTransDetailsResponse.body()!!");
        AggregateTxnDetails aggregateTxnDetails = body;
        Integer num = null;
        if (aggregateTxnDetails.getMAggregateResponse() != null) {
            PayMoneyAmount totalAmount = aggregateTxnDetails.getTotalAmount();
            String value = totalAmount != null ? totalAmount.getValue() : null;
            String totalCount = aggregateTxnDetails.getTotalCount();
            if (totalCount != null) {
                num = Integer.valueOf(Integer.parseInt(totalCount));
            }
            b<SummaryDateRangeViewData> a2 = b.a(new SummaryDateRangeViewData(value, String.valueOf(num)));
            k.b(a2, "LiveDataWrapper.success(…unt?.toInt().toString()))");
            return a2;
        } else if (aggregateTxnDetails.getResultInfo() == null || (!p.a("S", aggregateTxnDetails.getResultInfo().getResultStatus(), true) && !p.a("SUCCESS", aggregateTxnDetails.getResultInfo().getResultCode(), true))) {
            b<SummaryDateRangeViewData> a3 = b.a((Response<?>) response);
            k.b(a3, "LiveDataWrapper.error(ag…gateTransDetailsResponse)");
            return a3;
        } else {
            SummaryDateRangeViewData summaryDateRangeViewData = new SummaryDateRangeViewData((String) null, (String) null);
            if (!TextUtils.isEmpty(aggregateTxnDetails.getTotalCount())) {
                summaryDateRangeViewData.setTotalNoOfPayments(aggregateTxnDetails.getTotalCount());
            }
            if (aggregateTxnDetails.getTotalAmount() != null && !TextUtils.isEmpty(aggregateTxnDetails.getTotalAmount().getValue())) {
                String value2 = aggregateTxnDetails.getTotalAmount().getValue();
                k.a((Object) value2);
                summaryDateRangeViewData.setPaymentAmout(String.valueOf(Double.parseDouble(value2) / 100.0d));
            }
            b<SummaryDateRangeViewData> a4 = b.a(summaryDateRangeViewData);
            k.b(a4, "LiveDataWrapper.success(summeryDateRangeViewData)");
            return a4;
        }
    }

    private final String getBodyParamsSummary(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(TransactionType.ACQUIRING);
            jSONObject.put("bizTypeList", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put("SUCCESS");
            jSONObject.put("orderStatusList", jSONArray2);
            jSONObject.put("orderCreatedStartTime", DateUtility.getStartDateOfDifferentFormat(str, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA);
            jSONObject.put("orderCreatedEndTime", DateUtility.getEndDateOfDifferentFormat(str2, "dd MMMM yy", "yyyy-MM-dd'T'HH:mm:ss") + AppConstants.TIME_ZONE_INDIA);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private final HashMap<String, Object> addAggregateURLParams(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(AppConstants.DURATION, "custom");
        hashMap.put("startDate", str);
        hashMap.put("endDate", str2);
        hashMap.put(AppConstants.TRANSACTION, AppConstants.WITHDRAW);
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7 A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b0 A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object callPrimaryAPI(int r7, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.model.primary.PrimaryAPIModel>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.business.merchant_payments.payment.PaymentsRepo$callPrimaryAPI$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.business.merchant_payments.payment.PaymentsRepo$callPrimaryAPI$1 r0 = (com.business.merchant_payments.payment.PaymentsRepo$callPrimaryAPI$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.payment.PaymentsRepo$callPrimaryAPI$1 r0 = new com.business.merchant_payments.payment.PaymentsRepo$callPrimaryAPI$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x00be }
            goto L_0x009f
        L_0x0027:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r8)
            com.business.merchant_payments.PaymentsConfig r8 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r2 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r8, r2)
            android.app.Application r8 = r8.getApplication()
            boolean r8 = com.business.common_module.utilities.i.a((android.app.Application) r8)
            if (r8 != 0) goto L_0x0051
            java.lang.String r7 = "NO NETWORK"
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.String) r7)
            java.lang.String r8 = "LiveDataWrapper.offline(…R_TYPE_NO_INTERNET, null)"
            kotlin.g.b.k.b(r7, r8)
            return r7
        L_0x0051:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r4 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r4 = r4.getMInstance()
            java.lang.String r4 = r4.getHomePrimaryApi()
            r8.append(r4)
            java.lang.String r4 = "?pageSize="
            r8.append(r4)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r4, r2)
            android.content.Context r4 = r4.getAppContext()
            java.util.HashMap r4 = com.business.merchant_payments.common.utility.RequestParamUtil.getRequestHeaderMidParam(r4)
            com.business.merchant_payments.PaymentsConfig r5 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00be }
            kotlin.g.b.k.b(r5, r2)     // Catch:{ Exception -> 0x00be }
            com.business.merchant_payments.utility.APKotlinNetworkService r2 = r5.getKotlinNetworkService()     // Catch:{ Exception -> 0x00be }
            java.lang.String r5 = "headers"
            kotlin.g.b.k.b(r4, r5)     // Catch:{ Exception -> 0x00be }
            r0.L$0 = r6     // Catch:{ Exception -> 0x00be }
            r0.I$0 = r7     // Catch:{ Exception -> 0x00be }
            r0.L$1 = r8     // Catch:{ Exception -> 0x00be }
            r0.L$2 = r4     // Catch:{ Exception -> 0x00be }
            r0.label = r3     // Catch:{ Exception -> 0x00be }
            java.lang.Object r8 = r2.callHomePrimaryApi(r8, r4, r0)     // Catch:{ Exception -> 0x00be }
            if (r8 != r1) goto L_0x009f
            return r1
        L_0x009f:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x00be }
            boolean r7 = r8.isSuccessful()     // Catch:{ Exception -> 0x00be }
            if (r7 == 0) goto L_0x00b0
            java.lang.Object r7 = r8.body()     // Catch:{ Exception -> 0x00be }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a(r8, r7)     // Catch:{ Exception -> 0x00be }
            goto L_0x00b8
        L_0x00b0:
            java.lang.Object r7 = r8.body()     // Catch:{ Exception -> 0x00be }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.b(r8, r7)     // Catch:{ Exception -> 0x00be }
        L_0x00b8:
            java.lang.String r8 = "if (response.isSuccessfu…nse.body())\n            }"
            kotlin.g.b.k.b(r7, r8)     // Catch:{ Exception -> 0x00be }
            goto L_0x00c8
        L_0x00be:
            r7 = move-exception
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r7)
            java.lang.String r8 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r7, r8)
        L_0x00c8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.PaymentsRepo.callPrimaryAPI(int, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0098 A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object callNonMigratedPaymentsAPI(java.lang.String r7, java.lang.String r8, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.business.merchant_payments.payment.PaymentsRepo$callNonMigratedPaymentsAPI$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.business.merchant_payments.payment.PaymentsRepo$callNonMigratedPaymentsAPI$1 r0 = (com.business.merchant_payments.payment.PaymentsRepo$callNonMigratedPaymentsAPI$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.payment.PaymentsRepo$callNonMigratedPaymentsAPI$1 r0 = new com.business.merchant_payments.payment.PaymentsRepo$callNonMigratedPaymentsAPI$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r9)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x0087
        L_0x0027:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r9)
            com.business.merchant_payments.PaymentsConfig r9 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r2 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r9, r2)
            android.app.Application r9 = r9.getApplication()
            boolean r9 = com.business.common_module.utilities.i.a((android.app.Application) r9)
            if (r9 != 0) goto L_0x0051
            java.lang.String r7 = "NO NETWORK"
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.String) r7)
            java.lang.String r8 = "LiveDataWrapper.offline(…R_TYPE_NO_INTERNET, null)"
            kotlin.g.b.k.b(r7, r8)
            return r7
        L_0x0051:
            java.lang.String r9 = r6.getNonMigratedAPIUrl(r7, r8)
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r4, r2)
            android.content.Context r4 = r4.getAppContext()
            java.util.HashMap r4 = com.business.merchant_payments.common.utility.RequestParamUtil.getRequestHeaderMidParam(r4)
            com.business.merchant_payments.PaymentsConfig r5 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00a6 }
            kotlin.g.b.k.b(r5, r2)     // Catch:{ Exception -> 0x00a6 }
            com.business.merchant_payments.utility.APKotlinNetworkService r2 = r5.getKotlinNetworkService()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = "headers"
            kotlin.g.b.k.b(r4, r5)     // Catch:{ Exception -> 0x00a6 }
            r0.L$0 = r6     // Catch:{ Exception -> 0x00a6 }
            r0.L$1 = r7     // Catch:{ Exception -> 0x00a6 }
            r0.L$2 = r8     // Catch:{ Exception -> 0x00a6 }
            r0.L$3 = r9     // Catch:{ Exception -> 0x00a6 }
            r0.L$4 = r4     // Catch:{ Exception -> 0x00a6 }
            r0.label = r3     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r9 = r2.callNonMigratedPaymentsApi(r9, r4, r0)     // Catch:{ Exception -> 0x00a6 }
            if (r9 != r1) goto L_0x0087
            return r1
        L_0x0087:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch:{ Exception -> 0x00a6 }
            boolean r7 = r9.isSuccessful()     // Catch:{ Exception -> 0x00a6 }
            if (r7 == 0) goto L_0x0098
            java.lang.Object r7 = r9.body()     // Catch:{ Exception -> 0x00a6 }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a(r9, r7)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00a0
        L_0x0098:
            java.lang.Object r7 = r9.body()     // Catch:{ Exception -> 0x00a6 }
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.b(r9, r7)     // Catch:{ Exception -> 0x00a6 }
        L_0x00a0:
            java.lang.String r8 = "if (response.isSuccessfu…nse.body())\n            }"
            kotlin.g.b.k.b(r7, r8)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00b0
        L_0x00a6:
            r7 = move-exception
            com.business.common_module.utilities.a.b r7 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r7)
            java.lang.String r8 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r7, r8)
        L_0x00b0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.PaymentsRepo.callNonMigratedPaymentsAPI(java.lang.String, java.lang.String, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b A[Catch:{ Exception -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a4 A[Catch:{ Exception -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object callV2OrderListAPI(java.lang.String r8, int r9, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.model.orderList.V2OrderListModel>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.business.merchant_payments.payment.PaymentsRepo$callV2OrderListAPI$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.business.merchant_payments.payment.PaymentsRepo$callV2OrderListAPI$1 r0 = (com.business.merchant_payments.payment.PaymentsRepo$callV2OrderListAPI$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.payment.PaymentsRepo$callV2OrderListAPI$1 r0 = new com.business.merchant_payments.payment.PaymentsRepo$callV2OrderListAPI$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            kotlin.ResultKt.a((java.lang.Object) r10)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x0093
        L_0x0027:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r10)
            com.business.merchant_payments.PaymentsConfig r10 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r2 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r10, r2)
            android.app.Application r10 = r10.getApplication()
            boolean r10 = com.business.common_module.utilities.i.a((android.app.Application) r10)
            if (r10 != 0) goto L_0x0051
            java.lang.String r8 = "NO NETWORK"
            com.business.common_module.utilities.a.b r8 = com.business.common_module.utilities.a.b.a((java.lang.String) r8)
            java.lang.String r9 = "LiveDataWrapper.offline(…R_TYPE_NO_INTERNET, null)"
            kotlin.g.b.k.b(r8, r9)
            return r8
        L_0x0051:
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r10 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r10 = r10.getMInstance()
            java.lang.String r10 = r10.getV2OrderList()
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r4, r2)
            android.content.Context r4 = r4.getAppContext()
            java.util.HashMap r4 = com.business.merchant_payments.common.utility.RequestParamUtil.getRequestHeaderMidParam(r4)
            java.lang.String r5 = r7.getV2OrderListAPIBodyParams(r8, r9)
            com.business.merchant_payments.PaymentsConfig r6 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00b2 }
            kotlin.g.b.k.b(r6, r2)     // Catch:{ Exception -> 0x00b2 }
            com.business.merchant_payments.utility.APKotlinNetworkService r2 = r6.getKotlinNetworkService()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r6 = "headers"
            kotlin.g.b.k.b(r4, r6)     // Catch:{ Exception -> 0x00b2 }
            r0.L$0 = r7     // Catch:{ Exception -> 0x00b2 }
            r0.L$1 = r8     // Catch:{ Exception -> 0x00b2 }
            r0.I$0 = r9     // Catch:{ Exception -> 0x00b2 }
            r0.L$2 = r10     // Catch:{ Exception -> 0x00b2 }
            r0.L$3 = r4     // Catch:{ Exception -> 0x00b2 }
            r0.L$4 = r5     // Catch:{ Exception -> 0x00b2 }
            r0.label = r3     // Catch:{ Exception -> 0x00b2 }
            java.lang.Object r10 = r2.callV2OrderListAPI(r10, r4, r5, r0)     // Catch:{ Exception -> 0x00b2 }
            if (r10 != r1) goto L_0x0093
            return r1
        L_0x0093:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch:{ Exception -> 0x00b2 }
            boolean r8 = r10.isSuccessful()     // Catch:{ Exception -> 0x00b2 }
            if (r8 == 0) goto L_0x00a4
            java.lang.Object r8 = r10.body()     // Catch:{ Exception -> 0x00b2 }
            com.business.common_module.utilities.a.b r8 = com.business.common_module.utilities.a.b.a(r10, r8)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00ac
        L_0x00a4:
            java.lang.Object r8 = r10.body()     // Catch:{ Exception -> 0x00b2 }
            com.business.common_module.utilities.a.b r8 = com.business.common_module.utilities.a.b.b(r10, r8)     // Catch:{ Exception -> 0x00b2 }
        L_0x00ac:
            java.lang.String r9 = "if (response.isSuccessfu…nse.body())\n            }"
            kotlin.g.b.k.b(r8, r9)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00bc
        L_0x00b2:
            r8 = move-exception
            com.business.common_module.utilities.a.b r8 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r8)
            java.lang.String r9 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r8, r9)
        L_0x00bc:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.PaymentsRepo.callV2OrderListAPI(java.lang.String, int, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0156 A[Catch:{ Exception -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015b A[Catch:{ Exception -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getOrderSummeryData(java.lang.String r18, java.lang.String r19, kotlin.d.d<? super com.business.common_module.utilities.a.b<com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData>> r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            boolean r4 = r3 instanceof com.business.merchant_payments.payment.PaymentsRepo$getOrderSummeryData$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            com.business.merchant_payments.payment.PaymentsRepo$getOrderSummeryData$1 r4 = (com.business.merchant_payments.payment.PaymentsRepo$getOrderSummeryData$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            com.business.merchant_payments.payment.PaymentsRepo$getOrderSummeryData$1 r4 = new com.business.merchant_payments.payment.PaymentsRepo$getOrderSummeryData$1
            r4.<init>(r1, r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            kotlin.d.a.a r5 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r6 = r4.label
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L_0x004b
            if (r6 == r8) goto L_0x003f
            if (r6 != r7) goto L_0x0037
            java.lang.Object r0 = r4.L$0
            com.business.merchant_payments.payment.PaymentsRepo r0 = (com.business.merchant_payments.payment.PaymentsRepo) r0
            kotlin.ResultKt.a((java.lang.Object) r3)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0148
        L_0x0037:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003f:
            java.lang.Object r0 = r4.L$0
            com.business.merchant_payments.payment.PaymentsRepo r0 = (com.business.merchant_payments.payment.PaymentsRepo) r0
            kotlin.ResultKt.a((java.lang.Object) r3)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0119
        L_0x0048:
            r0 = move-exception
            goto L_0x0165
        L_0x004b:
            kotlin.ResultKt.a((java.lang.Object) r3)
            com.business.merchant_payments.PaymentsConfig r3 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r6 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r3, r6)
            com.business.common_module.b.i r3 = r3.getMerchantDataProvider()
            boolean r3 = r3.q()
            com.business.merchant_payments.PaymentsConfig r9 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r9, r6)
            com.business.common_module.b.i r9 = r9.getMerchantDataProvider()
            boolean r9 = r9.r()
            com.business.merchant_payments.PaymentsConfig r10 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r10, r6)
            com.business.common_module.b.i r10 = r10.getMerchantDataProvider()
            boolean r10 = r10.i()
            com.business.merchant_payments.PaymentsConfig r11 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r11, r6)
            android.content.Context r11 = r11.getAppContext()
            java.util.HashMap r11 = com.business.merchant_payments.common.utility.RequestParamUtil.getHeaders(r11)
            java.lang.String r12 = "RequestParamUtil.getHead…getInstance().appContext)"
            kotlin.g.b.k.b(r11, r12)
            r12 = 0
            if (r10 == 0) goto L_0x00a5
            java.lang.String r13 = r17.getBodyParamsSummary(r18, r19)
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r14 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r14 = r14.getMInstance()
            java.lang.String r14 = r14.getOrderSummaryV2()
            r15 = r13
            r13 = r12
            goto L_0x00d5
        L_0x00a5:
            java.lang.String r13 = com.business.merchant_payments.common.utility.DateUtility.formatAggregateDate(r18)
            java.lang.String r14 = "DateUtility.formatAggregateDate(startDate)"
            kotlin.g.b.k.b(r13, r14)
            java.lang.String r14 = com.business.merchant_payments.common.utility.DateUtility.formatAggregateDate(r19)
            java.lang.String r15 = "DateUtility.formatAggregateDate(endDate)"
            kotlin.g.b.k.b(r14, r15)
            java.util.HashMap r13 = r1.addAggregateURLParams(r13, r14)
            if (r3 != 0) goto L_0x00ca
            if (r9 != 0) goto L_0x00ca
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r14 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r14 = r14.getMInstance()
            java.lang.String r14 = r14.getNewAggregatedApi()
            goto L_0x00d4
        L_0x00ca:
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r14 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r14 = r14.getMInstance()
            java.lang.String r14 = r14.getOnlineAggrigatedApi()
        L_0x00d4:
            r15 = r12
        L_0x00d5:
            boolean r16 = android.webkit.URLUtil.isValidUrl(r14)
            if (r16 == 0) goto L_0x016f
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r7, r6)
            android.app.Application r7 = r7.getApplication()
            boolean r7 = com.business.common_module.utilities.i.a((android.app.Application) r7)
            if (r7 == 0) goto L_0x016f
            if (r10 == 0) goto L_0x011c
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x0048 }
            kotlin.g.b.k.b(r7, r6)     // Catch:{ Exception -> 0x0048 }
            com.business.merchant_payments.utility.APKotlinNetworkService r6 = r7.getKotlinNetworkService()     // Catch:{ Exception -> 0x0048 }
            r4.L$0 = r1     // Catch:{ Exception -> 0x0048 }
            r4.L$1 = r0     // Catch:{ Exception -> 0x0048 }
            r4.L$2 = r2     // Catch:{ Exception -> 0x0048 }
            r4.Z$0 = r3     // Catch:{ Exception -> 0x0048 }
            r4.Z$1 = r9     // Catch:{ Exception -> 0x0048 }
            r4.Z$2 = r10     // Catch:{ Exception -> 0x0048 }
            r4.L$3 = r14     // Catch:{ Exception -> 0x0048 }
            r4.L$4 = r13     // Catch:{ Exception -> 0x0048 }
            r4.L$5 = r11     // Catch:{ Exception -> 0x0048 }
            r4.L$6 = r15     // Catch:{ Exception -> 0x0048 }
            r4.L$7 = r12     // Catch:{ Exception -> 0x0048 }
            r4.label = r8     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r3 = r6.getV2OrderSummary(r14, r11, r15, r4)     // Catch:{ Exception -> 0x0048 }
            if (r3 != r5) goto L_0x0118
            return r5
        L_0x0118:
            r0 = r1
        L_0x0119:
            retrofit2.Response r3 = (retrofit2.Response) r3     // Catch:{ Exception -> 0x0048 }
            goto L_0x014a
        L_0x011c:
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x0048 }
            kotlin.g.b.k.b(r7, r6)     // Catch:{ Exception -> 0x0048 }
            com.business.merchant_payments.utility.APKotlinNetworkService r6 = r7.getKotlinNetworkService()     // Catch:{ Exception -> 0x0048 }
            r4.L$0 = r1     // Catch:{ Exception -> 0x0048 }
            r4.L$1 = r0     // Catch:{ Exception -> 0x0048 }
            r4.L$2 = r2     // Catch:{ Exception -> 0x0048 }
            r4.Z$0 = r3     // Catch:{ Exception -> 0x0048 }
            r4.Z$1 = r9     // Catch:{ Exception -> 0x0048 }
            r4.Z$2 = r10     // Catch:{ Exception -> 0x0048 }
            r4.L$3 = r14     // Catch:{ Exception -> 0x0048 }
            r4.L$4 = r13     // Catch:{ Exception -> 0x0048 }
            r4.L$5 = r11     // Catch:{ Exception -> 0x0048 }
            r4.L$6 = r15     // Catch:{ Exception -> 0x0048 }
            r4.L$7 = r12     // Catch:{ Exception -> 0x0048 }
            r0 = 2
            r4.label = r0     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r3 = r6.getAggregateTransactionDetails(r14, r11, r13, r4)     // Catch:{ Exception -> 0x0048 }
            if (r3 != r5) goto L_0x0147
            return r5
        L_0x0147:
            r0 = r1
        L_0x0148:
            retrofit2.Response r3 = (retrofit2.Response) r3     // Catch:{ Exception -> 0x0048 }
        L_0x014a:
            boolean r2 = r3.isSuccessful()     // Catch:{ Exception -> 0x0048 }
            if (r2 == 0) goto L_0x015b
            java.lang.Object r2 = r3.body()     // Catch:{ Exception -> 0x0048 }
            if (r2 == 0) goto L_0x015b
            com.business.common_module.utilities.a.b r0 = r0.getProcessedAggregatedDataLiveDataWrapper(r3)     // Catch:{ Exception -> 0x0048 }
            goto L_0x016e
        L_0x015b:
            com.business.common_module.utilities.a.b r0 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r3)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r2 = "LiveDataWrapper.error(response)"
            kotlin.g.b.k.b(r0, r2)     // Catch:{ Exception -> 0x0048 }
            goto L_0x016e
        L_0x0165:
            com.business.common_module.utilities.a.b r0 = com.business.common_module.utilities.a.b.a((java.lang.Throwable) r0)
            java.lang.String r2 = "LiveDataWrapper.failure(e)"
            kotlin.g.b.k.b(r0, r2)
        L_0x016e:
            return r0
        L_0x016f:
            com.business.common_module.utilities.a.b r0 = com.business.common_module.utilities.a.b.a((retrofit2.Response<?>) r12)
            java.lang.String r2 = "LiveDataWrapper.error(null)"
            kotlin.g.b.k.b(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.PaymentsRepo.getOrderSummeryData(java.lang.String, java.lang.String, kotlin.d.d):java.lang.Object");
    }
}
