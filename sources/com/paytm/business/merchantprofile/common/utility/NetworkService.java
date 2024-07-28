package com.paytm.business.merchantprofile.common.utility;

import com.paytm.business.merchantprofile.model.AddressDetailsModel;
import com.paytm.business.merchantprofile.model.BasicDetailsModel;
import com.paytm.business.merchantprofile.model.FetchGstinStatusResponse;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.model.KycDetailsModel;
import com.paytm.business.merchantprofile.model.MerchantProfileResponse;
import com.paytm.business.merchantprofile.model.PincodeResponse;
import com.paytm.business.merchantprofile.model.ProfileTicketStatus;
import com.paytm.business.merchantprofile.model.edc.RentalPlanDetailsModel;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface NetworkService {
    @GET
    Call<FetchGstinStatusResponse> fetchGSTINStatus(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<GenerateOtpResponseModel> generateOtp(@Url String str, @HeaderMap Map<String, Object> map, @QueryMap Map<String, String> map2);

    @GET
    Call<AddressDetailsModel> getAddressDetailsApiCall(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<BasicDetailsModel> getBasicDetailsApiCall(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<KycDetailsModel> getKycDetailsApiCall(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<ProfileTicketStatus> getMerchantProfileTicketStatus(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @POST
    Call<PincodeResponse> getPincodeDetails(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body String str2);

    @GET
    Call<RentalPlanDetailsModel> getRentalPlanDetailsDataAPI(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @GET
    Call<String> getShareableQrLink(@Url String str, @HeaderMap Map<String, Object> map);

    @DELETE
    Call<ResponseBody> onSignOut(@Url String str, @HeaderMap HashMap<String, Object> hashMap);

    @POST
    Call<MerchantProfileResponse> updateMerchantProfileDisplay(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody);

    @POST
    @Multipart
    Call<MerchantProfileResponse> updateMerchantProfileGstin(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @PartMap Map<String, RequestBody> map);

    @POST
    @Multipart
    Call<MerchantProfileResponse> updateMerchantProfileGstin(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @PartMap Map<String, RequestBody> map, @Part MultipartBody.Part part);

    @POST
    Call<MerchantProfileResponse> updateMerchantProfileSecondary(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody);

    @POST
    Call<MerchantProfileResponse> updateMerchantProfileTicketStatus(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @QueryMap Map<String, String> map);
}
