package com.business.merchant_payments.utility;

import com.business.merchant_payments.mapqr.model.MapQRRequest;
import com.business.merchant_payments.mapqr.model.MapQRResponse;
import com.business.merchant_payments.mapqr.model.SaveResponseBody;
import com.business.merchant_payments.mapqr.model.VerifyQRResponse;
import com.business.merchant_payments.model.AcceptedPaymentMode;
import com.business.merchant_payments.model.GenerateOtpResponseModel;
import com.business.merchant_payments.model.businesswallet.BWalletOrderDetails;
import com.business.merchant_payments.model.customcards.DynamicCustomCardDataModel;
import com.business.merchant_payments.model.initiaterefundmodel.InitiateRefundResponseModel;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OfflineTransactionDetails;
import com.business.merchant_payments.model.lastcollectedpaymentmodel.OrderDetailModel;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.orderList.V2OrderListModel;
import com.business.merchant_payments.model.orderSummaryList.DaywiseSummaryListModel;
import com.business.merchant_payments.model.paymentlinks.PaymentLinkReceivedListResponse;
import com.business.merchant_payments.model.paymentlinks.PaymentLinkRequest;
import com.business.merchant_payments.model.primary.PrimaryAPIModel;
import com.business.merchant_payments.model.qrsummarymodel.QRSummary;
import com.business.merchant_payments.model.requestpayment.CreateLinkModel;
import com.business.merchant_payments.model.requestpayment.PaymentLinkData;
import com.business.merchant_payments.model.requestpayment.ShareLinkResponse;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.model.NotificationsSettingsDataModel;
import com.business.merchant_payments.reports.model.apiReportModel.OrderListModel;
import com.business.merchant_payments.reports.model.apiReportModel.settlementModel.SettlementModel;
import com.business.merchant_payments.ups.UPSResponse;
import com.google.gson.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface NetworkService {
    @GET
    Call<List<DynamicCustomCardDataModel>> callCustomCardsApi(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap HashMap<String, String> hashMap2);

    @POST
    Call<DaywiseSummaryListModel> callDaywiseSummaryListApi(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2);

    @GET
    Call<PrimaryAPIModel> callHomePrimaryApi(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<NonMigratedPaymentsModel> callNonMigratedPaymentsApi(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<NotificationsSettingsDataModel> callNotificationSettingsApi(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap HashMap<String, String> hashMap2);

    @POST
    Call<CreateLinkModel> createMerchantPaymentLink(@Url String str, @Body RequestBody requestBody, @HeaderMap Map<String, Object> map);

    @POST
    Call<OrderListModel> downloadPaymentReport(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2);

    @POST
    Call<SettlementModel> downloadSettlement(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2);

    @GET
    Call<GenerateOtpResponseModel> generateOtp(@Url String str, @HeaderMap Map<String, Object> map, @QueryMap Map<String, String> map2);

    @GET
    Call<List<PaymentLinkData>> getCreatedLinkList(@Url String str, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map2);

    @POST
    Call<MapQRResponse> getMapQRResponse(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body MapQRRequest mapQRRequest);

    @GET
    Call<OfflineTransactionDetails> getOfflineTransactionDetails(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap Map<String, String> map);

    @GET
    Call<OrderDetailModel> getOnlineOrderDetail(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap Map<String, String> map);

    @POST
    Call<PaymentLinkReceivedListResponse> getPaymentLinkReceived(@Url String str, @Body PaymentLinkRequest paymentLinkRequest, @HeaderMap Map<String, Object> map);

    @GET
    Call<AcceptedPaymentMode> getPaymentModeDetails(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<UPSResponse> getPrefsFromUPS(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<QRSummary> getQRSUmmary(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @POST
    Call<ShareLinkResponse> getShareLinkResponse(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap Map<String, String> map);

    @GET
    Call<String> getShareableQrLink(@Url String str, @HeaderMap Map<String, Object> map);

    @GET
    Call<OfflineTransactionDetails> getTxnDetailByTxnId(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap Map<String, String> map);

    @POST
    Call<OrderDetailV2Model> getV2Detail(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2);

    @POST
    Call<V2OrderListModel> getV2OrderList(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2);

    @GET
    Call<VerifyQRResponse> getVerifyQResponse(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @POST
    Call<InitiateRefundResponseModel> initiateRefund(@Url String str, @Body HashMap<String, Object> hashMap, @HeaderMap HashMap<String, Object> hashMap2);

    @POST
    Call<ResponseBody> initiateReportDownload(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody);

    @GET
    Call<BWalletOrderDetails> loadBWOrderDetails(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap HashMap<String, Object> hashMap2);

    @DELETE
    Call<ResponseBody> onSignOut(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @PUT
    Call<UPSResponse> savePrefsToUPS(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody);

    @POST
    Call<l> saveQRSurveyResponse(@Url String str, @Body SaveResponseBody saveResponseBody, @HeaderMap HashMap<String, Object> hashMap);

    @POST
    Call<MerchantProfileResponse> updateMerchantProfileSecondary(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody);

    @POST
    Call<NotificationOnOffDataModel> updateNotificationSettings(@Url String str, @Body RequestBody requestBody, @HeaderMap HashMap<String, Object> hashMap);
}
