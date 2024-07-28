package com.business.merchant_payments.utility;

import com.business.merchant_payments.model.kyc.KycBankInfoModel;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.orderList.V2OrderListModel;
import com.business.merchant_payments.model.paymentdaterangesummery.AggregateTxnDetails;
import com.business.merchant_payments.model.primary.PrimaryAPIModel;
import com.business.merchant_payments.model.user.UserDetails;
import com.business.merchant_payments.settlement.model.SettlementBillListDetailModel;
import com.business.merchant_payments.settlement.model.SettlementBillListModel;
import com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel;
import com.business.merchant_payments.settlement.model.UTRV2Request;
import com.business.merchant_payments.settlement.model.UTRV2Response;
import com.business.merchant_payments.settlement.model.UtrSummaryModel;
import com.business.merchant_payments.ups.UPSResponse;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.d;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface APKotlinNetworkService {
    @GET
    Object callHomePrimaryApi(@Url String str, @HeaderMap HashMap<String, Object> hashMap, d<? super Response<PrimaryAPIModel>> dVar);

    @GET
    Object callNonMigratedPaymentsApi(@Url String str, @HeaderMap HashMap<String, Object> hashMap, d<? super Response<NonMigratedPaymentsModel>> dVar);

    @POST
    Object callV2OrderListAPI(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2, d<? super Response<V2OrderListModel>> dVar);

    @GET
    Object getAggregateTransactionDetails(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap HashMap<String, Object> hashMap2, d<? super Response<AggregateTxnDetails>> dVar);

    @GET
    Object getBasicInfoDetails(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap HashMap<String, Object> hashMap2, d<? super Response<KycBankInfoModel>> dVar);

    @GET
    Object getPrefsFromUPS(@Url String str, @HeaderMap HashMap<String, Object> hashMap, d<? super Response<UPSResponse>> dVar);

    @POST
    Object getSettlementBillList(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody, d<? super Response<SettlementBillListModel>> dVar);

    @GET
    Object getSettlementBillListItemDetail(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap HashMap<String, Object> hashMap2, d<? super Response<SettlementBillListDetailModel>> dVar);

    @POST
    Object getStorefrontHomeData(@Url String str, @HeaderMap HashMap<String, String> hashMap, @Body RequestBody requestBody, d<? super Response<HomeResponse>> dVar);

    @GET
    Object getTodaySettlementSummary(@Url String str, @HeaderMap HashMap<String, Object> hashMap, d<? super Response<TodaySettlementSummaryCardModel>> dVar);

    @GET
    Object getUTRSummary(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap Map<String, String> map, d<? super Response<UtrSummaryModel>> dVar);

    @POST
    Object getUTRSummaryV2(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body UTRV2Request uTRV2Request, d<? super Response<UTRV2Response>> dVar);

    @GET
    Object getUserDetails(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap HashMap<String, Object> hashMap2, d<? super Response<UserDetails>> dVar);

    @POST
    Object getV2OrderSummary(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2, d<? super Response<AggregateTxnDetails>> dVar);

    @PUT
    Object savePrefsToUPS(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody, d<? super Response<UPSResponse>> dVar);
}
