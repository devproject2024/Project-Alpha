package com.paytm.business.merchantprofile.common.utility;

import com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse;
import com.paytm.business.merchantprofile.inactivemerchant.ReactivationEligibility;
import com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetworkResponse;
import com.paytm.business.merchantprofile.model.AddUpdateGstinResponseModel;
import com.paytm.business.merchantprofile.model.ProfileTicketStatus;
import java.util.HashMap;
import kotlin.d.d;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ProfileKotlinNetworkService {
    @POST
    Object getAddEditGstinLead(@Url String str, @HeaderMap HashMap<String, Object> hashMap, @Body RequestBody requestBody, d<? super Response<AddUpdateGstinResponseModel>> dVar);

    @GET
    Object getMerchantProfileTicketStatus(@Url String str, @HeaderMap HashMap<String, Object> hashMap, d<? super Response<ProfileTicketStatus>> dVar);

    @GET
    Object getReactivationEligibility(@Url String str, @HeaderMap HashMap<String, Object> hashMap, d<? super Response<NetworkResponse<ReactivationEligibility>>> dVar);

    @GET
    Object getReactivationStatus(@Url String str, @QueryMap HashMap<String, Object> hashMap, @HeaderMap HashMap<String, Object> hashMap2, d<? super Response<ReactivationStatusNetworkResponse>> dVar);
}
