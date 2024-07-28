package com.paytm.business.merchantprofile.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import com.paytm.business.merchantprofile.common.utility.RequestParamUtil;
import com.paytm.business.merchantprofile.model.AddUpdateGstinResponseModel;
import com.paytm.business.merchantprofile.model.AddressDetailsModel;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import okhttp3.RequestBody;
import org.json.JSONObject;

public final class AddEditGstinViewModel extends c {
    public final LiveData<b<AddUpdateGstinResponseModel>> mAddUpdateGstinLiveData = new y();

    public final void initDefaultParams() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddEditGstinViewModel(Application application) {
        super(application);
        k.d(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
    }

    public final LiveData<b<AddUpdateGstinResponseModel>> getMAddUpdateGstinLiveData() {
        return this.mAddUpdateGstinLiveData;
    }

    public final void callAddEditGstinApi(EditGstinAddress editGstinAddress, String str, String str2, String str3) {
        k.d(editGstinAddress, "gstinAddress");
        k.d(str, "otp");
        k.d(str2, "optState");
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (f) null, (CoroutineStart) null, new AddEditGstinViewModel$callAddEditGstinApi$1(this, editGstinAddress, str, str2, str3, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final RequestBody getRequestBody(EditGstinAddress editGstinAddress, String str, String str2, String str3) {
        String state;
        String pin;
        String address3;
        String address2;
        String address1;
        String city;
        String country;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("otp", str);
            jSONObject.put("state", str2);
            ProfileSharedPreferences instance = ProfileSharedPreferences.getInstance();
            k.b(instance, "ProfileSharedPreferences.getInstance()");
            jSONObject.put("mid", instance.getMerchantMid());
            jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_GSTIN, editGstinAddress.getNewGstin());
            JSONObject jSONObject2 = new JSONObject();
            AddressDetailsModel oldBillingAddress = editGstinAddress.getOldBillingAddress();
            if (!(oldBillingAddress == null || (country = oldBillingAddress.getCountry()) == null)) {
                jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_COUNTRY, country);
            }
            AddressDetailsModel oldBillingAddress2 = editGstinAddress.getOldBillingAddress();
            if (!(oldBillingAddress2 == null || (city = oldBillingAddress2.getCity()) == null)) {
                jSONObject2.put("city", city);
            }
            AddressDetailsModel oldBillingAddress3 = editGstinAddress.getOldBillingAddress();
            if (!(oldBillingAddress3 == null || (address1 = oldBillingAddress3.getAddress1()) == null)) {
                jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_LINE1, address1);
            }
            AddressDetailsModel oldBillingAddress4 = editGstinAddress.getOldBillingAddress();
            if (!(oldBillingAddress4 == null || (address2 = oldBillingAddress4.getAddress2()) == null)) {
                jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_LINE2, address2);
            }
            AddressDetailsModel oldBillingAddress5 = editGstinAddress.getOldBillingAddress();
            if (!(oldBillingAddress5 == null || (address3 = oldBillingAddress5.getAddress3()) == null)) {
                jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_LINE3, address3);
            }
            AddressDetailsModel oldBillingAddress6 = editGstinAddress.getOldBillingAddress();
            if (!(oldBillingAddress6 == null || (pin = oldBillingAddress6.getPin()) == null)) {
                jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, pin);
            }
            AddressDetailsModel oldBillingAddress7 = editGstinAddress.getOldBillingAddress();
            if (!(oldBillingAddress7 == null || (state = oldBillingAddress7.getState()) == null)) {
                jSONObject2.put("state", state);
            }
            jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, jSONObject2);
            if (!(str3 == null || p.a(str3))) {
                jSONObject.put("businessName", str3);
            }
            RequestBody requestBody = RequestParamUtil.getRequestBody(jSONObject.toString());
            k.b(requestBody, "RequestParamUtil.getRequ…dy(jsonObject.toString())");
            return requestBody;
        } catch (Exception unused) {
            RequestBody requestBody2 = RequestParamUtil.getRequestBody("{}");
            k.b(requestBody2, "RequestParamUtil.getRequestBody(\"{}\")");
            return requestBody2;
        }
    }
}
