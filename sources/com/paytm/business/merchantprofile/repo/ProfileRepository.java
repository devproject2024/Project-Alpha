package com.paytm.business.merchantprofile.repo;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.a;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.h;
import com.google.gson.f;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.utility.GTMDataProviderImpl;
import com.paytm.business.merchantprofile.common.utility.NetworkService;
import com.paytm.business.merchantprofile.common.utility.RequestParamUtil;
import com.paytm.business.merchantprofile.model.AddressDetailsModel;
import com.paytm.business.merchantprofile.model.BasicDetailsModel;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.FetchGstinStatusResponse;
import com.paytm.business.merchantprofile.model.GAEventModel;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.model.KycDetailsModel;
import com.paytm.business.merchantprofile.model.MerchantProfileResponse;
import com.paytm.business.merchantprofile.model.ProfileTicketStatus;
import com.paytm.business.merchantprofile.model.edc.RentalPlanDetailsModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    public static ProfileRepository mProfileRepo;
    public Context mAppContext = ProfileConfig.getInstance().getAppContext();
    public NetworkService networkService = ProfileConfig.getInstance().getNetworkService();

    private void logFileException(Uri uri, Exception exc) {
    }

    public static ProfileRepository getInstance() {
        if (mProfileRepo == null) {
            synchronized (ProfileRepository.class) {
                if (mProfileRepo == null) {
                    mProfileRepo = new ProfileRepository();
                }
            }
        }
        return mProfileRepo;
    }

    public LiveData<b<AddressDetailsModel>> getProfileAddressDetailsApiCallNew(GAEventModel gAEventModel) {
        y yVar = new y();
        String merchantAddress = GTMDataProviderImpl.Companion.getMInstance().getMerchantAddress();
        final long currentTimeMillis = System.currentTimeMillis();
        final GAEventModel gAEventModel2 = gAEventModel;
        final y yVar2 = yVar;
        this.networkService.getAddressDetailsApiCall(merchantAddress, RequestParamUtil.getRequestHeaderMidParam(this.mAppContext)).enqueue(new Callback<AddressDetailsModel>(this) {
            public void onResponse(Call<AddressDetailsModel> call, Response<AddressDetailsModel> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                gAEventModel2.getEventScreenName();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<AddressDetailsModel> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<BasicDetailsModel>> getProfileBasicApiCallNew(GAEventModel gAEventModel) {
        y yVar = new y();
        String basicDetailAPI = GTMDataProviderImpl.Companion.getMInstance().getBasicDetailAPI();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(this.mAppContext);
        final long currentTimeMillis = System.currentTimeMillis();
        final GAEventModel gAEventModel2 = gAEventModel;
        final y yVar2 = yVar;
        this.networkService.getBasicDetailsApiCall(basicDetailAPI, requestHeaderMidParam).enqueue(new Callback<BasicDetailsModel>(this) {
            public void onResponse(Call<BasicDetailsModel> call, Response<BasicDetailsModel> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                gAEventModel2.getEventScreenName();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<BasicDetailsModel> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<KycDetailsModel>> getMerchantBankDetailsApi(GAEventModel gAEventModel) {
        y yVar = new y();
        String profileKYCUrl = GTMDataProviderImpl.Companion.getMInstance().getProfileKYCUrl();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(this.mAppContext);
        final long currentTimeMillis = System.currentTimeMillis();
        final GAEventModel gAEventModel2 = gAEventModel;
        final y yVar2 = yVar;
        this.networkService.getKycDetailsApiCall(profileKYCUrl, requestHeaderMidParam).enqueue(new Callback<KycDetailsModel>(this) {
            public void onResponse(Call<KycDetailsModel> call, Response<KycDetailsModel> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                gAEventModel2.getEventScreenName();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<KycDetailsModel> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<ProfileTicketStatus>> getMerchantProfileTicketStatus(String str) {
        String merchantProfileTicketStatusUrl = GTMDataProviderImpl.Companion.getMInstance().getMerchantProfileTicketStatusUrl();
        if (!URLUtil.isValidUrl(merchantProfileTicketStatusUrl)) {
            return new a();
        }
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext());
        y yVar = new y();
        final long currentTimeMillis = System.currentTimeMillis();
        final String str2 = str;
        final y yVar2 = yVar;
        this.networkService.getMerchantProfileTicketStatus(merchantProfileTicketStatusUrl, requestHeaderMidParam).enqueue(new Callback<ProfileTicketStatus>(this) {
            public void onResponse(Call<ProfileTicketStatus> call, Response<ProfileTicketStatus> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<ProfileTicketStatus> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<MerchantProfileResponse>> updateMerchantProfileSecondary(String str, String str2) {
        String merchantProfileSecondaryUrlV2 = GTMDataProviderImpl.Companion.getMInstance().getMerchantProfileSecondaryUrlV2();
        if (!URLUtil.isValidUrl(merchantProfileSecondaryUrlV2)) {
            return new a();
        }
        RequestBody requestBody = RequestParamUtil.getRequestBody(str);
        if (requestBody == null) {
            return new a();
        }
        y yVar = new y();
        yVar.setValue(b.a());
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext());
        final long currentTimeMillis = System.currentTimeMillis();
        final String str3 = str2;
        final y yVar2 = yVar;
        this.networkService.updateMerchantProfileSecondary(merchantProfileSecondaryUrlV2, requestHeaderMidParam, requestBody).enqueue(new Callback<MerchantProfileResponse>(this) {
            public void onResponse(Call<MerchantProfileResponse> call, Response<MerchantProfileResponse> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<MerchantProfileResponse> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<MerchantProfileResponse>> updateMerchantProfileDisplay(String str, String str2) {
        String merchantProfileDisplayUrl = GTMDataProviderImpl.Companion.getMInstance().getMerchantProfileDisplayUrl();
        if (!URLUtil.isValidUrl(merchantProfileDisplayUrl)) {
            return new a();
        }
        RequestBody requestBody = RequestParamUtil.getRequestBody(str);
        if (requestBody == null) {
            return new a();
        }
        y yVar = new y();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext());
        final long currentTimeMillis = System.currentTimeMillis();
        final String str3 = str2;
        final y yVar2 = yVar;
        this.networkService.updateMerchantProfileDisplay(merchantProfileDisplayUrl, requestHeaderMidParam, requestBody).enqueue(new Callback<MerchantProfileResponse>(this) {
            public void onResponse(Call<MerchantProfileResponse> call, Response<MerchantProfileResponse> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<MerchantProfileResponse> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<GenerateOtpResponseModel>> generateOtp(String str, String str2, boolean z) {
        String str3;
        if (z) {
            str3 = GTMDataProviderImpl.Companion.getMInstance().getGenerateOtpUrlV2();
        } else {
            str3 = GTMDataProviderImpl.Companion.getMInstance().getGenerateOtpUrl();
        }
        if (!URLUtil.isValidUrl(str3)) {
            return new a();
        }
        y yVar = new y();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext());
        final long currentTimeMillis = System.currentTimeMillis();
        final String str4 = str;
        final y yVar2 = yVar;
        this.networkService.generateOtp(str3, requestHeaderMidParam, getParams(str2)).enqueue(new Callback<GenerateOtpResponseModel>(this) {
            public void onResponse(Call<GenerateOtpResponseModel> call, Response<GenerateOtpResponseModel> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<GenerateOtpResponseModel> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    private Map<String, String> getParams(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", str);
        return hashMap;
    }

    public LiveData<b<MerchantProfileResponse>> updateMerchantLoginInfo(String str, String str2) {
        String merchantProfileLoginUrl = GTMDataProviderImpl.Companion.getMInstance().getMerchantProfileLoginUrl();
        if (!URLUtil.isValidUrl(merchantProfileLoginUrl)) {
            return new a();
        }
        RequestBody requestBody = RequestParamUtil.getRequestBody(str);
        if (requestBody == null) {
            return new a();
        }
        y yVar = new y();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext());
        final long currentTimeMillis = System.currentTimeMillis();
        final String str3 = str2;
        final y yVar2 = yVar;
        this.networkService.updateMerchantProfileDisplay(merchantProfileLoginUrl, requestHeaderMidParam, requestBody).enqueue(new Callback<MerchantProfileResponse>(this) {
            public void onResponse(Call<MerchantProfileResponse> call, Response<MerchantProfileResponse> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<MerchantProfileResponse> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<MerchantProfileResponse>> updateMerchantProfileGstin(EditGstinAddress editGstinAddress, String str) {
        Call<MerchantProfileResponse> call;
        String merchantProfileGstinUrl = GTMDataProviderImpl.Companion.getMInstance().getMerchantProfileGstinUrl();
        if (!URLUtil.isValidUrl(merchantProfileGstinUrl)) {
            return new a();
        }
        if (editGstinAddress == null) {
            return new a();
        }
        y yVar = new y();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext());
        requestHeaderMidParam.remove("Content-Type");
        Map<String, RequestBody> gstinRequestBodyMap = getGstinRequestBodyMap(editGstinAddress);
        if (editGstinAddress.getUri() != null) {
            try {
                MediaType parse = MediaType.parse("*/*");
                Context appContext = ProfileConfig.getInstance().getAppContext();
                call = this.networkService.updateMerchantProfileGstin(merchantProfileGstinUrl, requestHeaderMidParam, gstinRequestBodyMap, MultipartBody.Part.createFormData(CommunityPostActivity.TYPE_FILE, editGstinAddress.getFileName(), RequestBody.create(parse, h.a(appContext.getContentResolver().openInputStream(editGstinAddress.getUri())))));
            } catch (Exception e2) {
                logFileException(editGstinAddress.getUri(), e2);
                return new a();
            }
        } else {
            call = this.networkService.updateMerchantProfileGstin(merchantProfileGstinUrl, requestHeaderMidParam, gstinRequestBodyMap);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final String str2 = str;
        final y yVar2 = yVar;
        call.enqueue(new Callback<MerchantProfileResponse>(this) {
            public void onResponse(Call<MerchantProfileResponse> call, Response<MerchantProfileResponse> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<MerchantProfileResponse> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    private Map<String, RequestBody> getGstinRequestBodyMap(EditGstinAddress editGstinAddress) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(editGstinAddress.getOldGstin())) {
            hashMap.put("oldGstin", RequestParamUtil.getMultiPartFormRequestBody(editGstinAddress.getOldGstin()));
        }
        if (!TextUtils.isEmpty(editGstinAddress.getNewGstin())) {
            hashMap.put("newGstin", RequestParamUtil.getMultiPartFormRequestBody(editGstinAddress.getNewGstin()));
        }
        if (editGstinAddress.getOldBillingAddress() != null) {
            hashMap.put("oldBillingAddress", RequestParamUtil.getMultiPartFormRequestBody(new f().a((Object) editGstinAddress.getOldBillingAddress(), (Type) AddressDetailsModel.class)));
        }
        if (editGstinAddress.getNewBillingAddress() != null) {
            hashMap.put("newBillingAddress", RequestParamUtil.getMultiPartFormRequestBody(new f().a((Object) editGstinAddress.getNewBillingAddress(), (Type) AddressDetailsModel.class)));
        }
        hashMap.put("addressOnly", RequestParamUtil.getMultiPartFormRequestBody(String.valueOf(editGstinAddress.isAddressOnly())));
        return hashMap;
    }

    public LiveData<b<MerchantProfileResponse>> updateMerchantProfileTicketStatus(Map map, String str) {
        String merchantProfileUpdateTicketUrl = GTMDataProviderImpl.Companion.getMInstance().getMerchantProfileUpdateTicketUrl();
        if (!URLUtil.isValidUrl(merchantProfileUpdateTicketUrl)) {
            return new a();
        }
        y yVar = new y();
        HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext());
        final long currentTimeMillis = System.currentTimeMillis();
        final String str2 = str;
        final y yVar2 = yVar;
        this.networkService.updateMerchantProfileTicketStatus(merchantProfileUpdateTicketUrl, requestHeaderMidParam, map).enqueue(new Callback<MerchantProfileResponse>(this) {
            public void onResponse(Call<MerchantProfileResponse> call, Response<MerchantProfileResponse> response) {
                ProfileConfig.getInstance().getEventPublisher();
                response.code();
                if (!response.isSuccessful() || response.body() == null) {
                    yVar2.setValue(b.a((Response<?>) response));
                } else {
                    yVar2.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<MerchantProfileResponse> call, Throwable th) {
                yVar2.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<RentalPlanDetailsModel>> getRentalPlanDetails(String str, HashMap<String, Object> hashMap) {
        final y yVar = new y();
        this.networkService.getRentalPlanDetailsDataAPI(str, hashMap).enqueue(new Callback<RentalPlanDetailsModel>(this) {
            public void onResponse(Call<RentalPlanDetailsModel> call, Response<RentalPlanDetailsModel> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<RentalPlanDetailsModel> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }

    public LiveData<b<FetchGstinStatusResponse>> getGSTINLeadStatus(String str, HashMap<String, Object> hashMap) {
        final y yVar = new y();
        this.networkService.fetchGSTINStatus(str, hashMap).enqueue(new Callback<FetchGstinStatusResponse>(this) {
            public void onResponse(Call<FetchGstinStatusResponse> call, Response<FetchGstinStatusResponse> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<FetchGstinStatusResponse> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }
}
