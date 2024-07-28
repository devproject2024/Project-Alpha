package com.paytm.business.merchantprofile.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.business.common_module.utilities.LogUtility;
import com.google.gson.o;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.gtm.GAGTMTagAnalytics;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.common.utility.GTMDataProviderImpl;
import com.paytm.business.merchantprofile.common.utility.NetworkService;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import com.paytm.business.merchantprofile.common.utility.RequestParamUtil;
import com.paytm.business.merchantprofile.databinding.PrActivityEditBusinessProfileDetailsBinding;
import com.paytm.business.merchantprofile.event.EditBusinessDetailEvent;
import com.paytm.business.merchantprofile.listener.IProfileBusinessDetails;
import com.paytm.business.merchantprofile.model.ChangeBankDetailsModelResponse;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.PincodeItem;
import com.paytm.business.merchantprofile.model.PincodeResponse;
import com.paytm.business.merchantprofile.model.ProfileTicketStatus;
import java.util.HashMap;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditBusinessProfileDetailsActivity extends BaseActivity implements IProfileBusinessDetails {
    public static final String TAG = "EditBusinessProfileDetailsActivity";
    public PrActivityEditBusinessProfileDetailsBinding detailsBinding;
    public j editDetailsFragmentManager;
    public FrameLayout fragmentContainer;
    public int fragmentContainerId;
    public String mBusinessName;
    public String mType;
    public NetworkService networkService;
    public int ppblPollingCount = 0;
    public q transaction;

    public void handleActiveMerchantAccountState(boolean z) {
    }

    public void handleBankChangeTicket(ProfileTicketStatus.TicketItem ticketItem) {
    }

    public void handleDisplayNameChangeTicket(ProfileTicketStatus.TicketItem ticketItem) {
    }

    public void handleFetchLeadStatusApi(String str, boolean z, String str2, boolean z2) {
    }

    public void handleGstinChangeTicket(ProfileTicketStatus.TicketItem ticketItem) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PrActivityEditBusinessProfileDetailsBinding prActivityEditBusinessProfileDetailsBinding = (PrActivityEditBusinessProfileDetailsBinding) f.a(this, R.layout.pr_activity_edit_business_profile_details);
        this.detailsBinding = prActivityEditBusinessProfileDetailsBinding;
        FrameLayout frameLayout = prActivityEditBusinessProfileDetailsBinding.fragmentContainer;
        this.fragmentContainer = frameLayout;
        this.fragmentContainerId = frameLayout.getId();
        this.editDetailsFragmentManager = getSupportFragmentManager();
        getIntent();
        launchFragment();
        this.networkService = ProfileConfig.getInstance().getNetworkService();
    }

    public void onResume() {
        super.onResume();
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("Accept Paymen/Settings/Change Bank details");
    }

    public void showBasicDetailsDialogFragment(String str, String str2) {
        startFragment(EditBasicDetailsDialogFragment.newInstance(str, str2), true);
    }

    public void showEditGstinDialogFragment(EditGstinAddress editGstinAddress) {
        startFragment(EditGstinDialogFragment.newInstance(editGstinAddress, this.mBusinessName), true);
    }

    public void showEditAddressDialogFragment(EditGstinAddress editGstinAddress) {
        startFragment(EditAddressDialogFragment.newInstance(editGstinAddress), true);
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onStop() {
        super.onStop();
        c.a().b(this);
    }

    private void launchFragment() {
        if (getIntent() != null) {
            Intent intent = getIntent();
            if (intent.getStringExtra("type") != null) {
                this.mType = intent.getStringExtra("type");
                this.mBusinessName = intent.getStringExtra("businessName");
                String str = this.mType;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1339964514) {
                    if (hashCode != -608658121) {
                        if (hashCode == 2016060030 && str.equals(AppConstants.UPDATE_DETAILS.ADDRESS)) {
                            c2 = 1;
                        }
                    } else if (str.equals("update_gstin")) {
                        c2 = 2;
                    }
                } else if (str.equals(EditBasicDetailsDialogFragment.TYPE_DISPLAY_NAME)) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(getBaseContext(), "Account", "Business Profile", "", "");
                    showBasicDetailsDialogFragment(this.mType, intent.getStringExtra("value"));
                } else if (c2 == 1) {
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(getBaseContext(), "Account", "Business Profile", "", "");
                    showEditAddressDialogFragment((EditGstinAddress) intent.getSerializableExtra("value"));
                } else if (c2 == 2) {
                    showEditGstinDialogFragment((EditGstinAddress) intent.getSerializableExtra("value"));
                }
            }
        }
    }

    @org.greenrobot.eventbus.j
    public void onEditGstinAddress(EditGstinAddress editGstinAddress) {
        if (!TextUtils.isEmpty(editGstinAddress.getNewGstin())) {
            editGstinAddress.setAddressOnly(false);
            showConfirmGstinAddressDialogFragment(editGstinAddress);
        } else if (!editGstinAddress.isAddressOnly()) {
            String[] stringArray = getResources().getStringArray(R.array.pr_gst_states);
            if (editGstinAddress.getOldBillingAddress() == null || TextUtils.isEmpty(editGstinAddress.getOldBillingAddress().getState()) || !stringArray[Integer.parseInt(editGstinAddress.getNewGstin().substring(0, 2))].contains(editGstinAddress.getOldBillingAddress().getState())) {
                showEditAddressDialogFragment(editGstinAddress);
            } else {
                showConfirmGstinAddressDialogFragment(editGstinAddress);
            }
        } else if (TextUtils.isEmpty(editGstinAddress.getOldGstin()) || editGstinAddress.getOldGstin().startsWith(editGstinAddress.getNewBillingAddress().getStateGSTCode())) {
            showConfirmGstinAddressDialogFragment(editGstinAddress);
        } else {
            showEditGstinDialogFragment(editGstinAddress);
        }
    }

    private void showConfirmGstinAddressDialogFragment(EditGstinAddress editGstinAddress) {
        startFragment(ConfirmGstinAddressDialogFragment.newInstance(editGstinAddress), true);
    }

    private void startFragment(Fragment fragment, boolean z) {
        q a2 = this.editDetailsFragmentManager.a();
        this.transaction = a2;
        a2.b(this.fragmentContainerId, fragment, (String) null);
        if (z) {
            this.transaction.a((String) null);
        }
        this.transaction.b();
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().f() <= 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @org.greenrobot.eventbus.j
    public void onEditBusinessDetailEvent(EditBusinessDetailEvent editBusinessDetailEvent) {
        Intent intent = new Intent();
        intent.putExtra(AppConstants.EDIT_OBJECT, editBusinessDetailEvent);
        setResult(-1, intent);
        finish();
    }

    @org.greenrobot.eventbus.j(a = ThreadMode.MAIN, b = true)
    public void onEditBusinessDetailEvent(ChangeBankDetailsModelResponse.BankDetails bankDetails) {
        c.a().b();
        if (bankDetails.isEmpty()) {
            setResult(201);
        } else {
            Intent intent = new Intent();
            intent.putExtra(AppConstants.EDIT_OBJECT, bankDetails);
            setResult(-1, intent);
        }
        finish();
    }

    @org.greenrobot.eventbus.j
    public void onPincodeEntered(final PincodeItem pincodeItem) {
        if (pincodeItem != null) {
            String uADPincodeApi = GTMDataProviderImpl.Companion.getMInstance().getUADPincodeApi();
            HashMap<String, Object> requestHeaderParam = RequestParamUtil.getRequestHeaderParam(ProfileConfig.getInstance().getApplication());
            requestHeaderParam.put("session_token", ProfileSharedPreferences.getInstance().getUserToken());
            this.networkService.getPincodeDetails(uADPincodeApi, requestHeaderParam, getPinCodeParams(pincodeItem.getPincode())).enqueue(new Callback<PincodeResponse>() {
                public void onResponse(Call<PincodeResponse> call, Response<PincodeResponse> response) {
                    PincodeResponse body = response.body();
                    Fragment visibleFragment = EditBusinessProfileDetailsActivity.this.getVisibleFragment();
                    if (body != null) {
                        if (visibleFragment instanceof EditAddressDialogFragment) {
                            EditAddressDialogFragment editAddressDialogFragment = (EditAddressDialogFragment) visibleFragment;
                            if (body.getResponseCode().equalsIgnoreCase("200") && body.getAddressDictionary() != null && body.getAddressDictionary().d(pincodeItem.getPincode()) != null && body.getAddressDictionary().a(pincodeItem.getPincode())) {
                                o h2 = body.getAddressDictionary().d(pincodeItem.getPincode()).a(0).h();
                                editAddressDialogFragment.setPincodeDetails(h2.b("tier3Value").c(), h2.b("state").c());
                            }
                        }
                    } else if (EditBusinessProfileDetailsActivity.this.getVisibleFragment() instanceof EditAddressDialogFragment) {
                        ((EditAddressDialogFragment) EditBusinessProfileDetailsActivity.this.getVisibleFragment()).setPincodeError();
                    }
                }

                public void onFailure(Call<PincodeResponse> call, Throwable th) {
                    LogUtility.e("AUTH", "error creating account");
                }
            });
        }
    }

    private String getPinCodeParams(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("addressResponseType", "SECONDARY");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("pincodes", jSONArray);
            jSONObject.putOpt("tier3Type", "UNIQUE");
            jSONObject.putOpt("secodaryType", "TIER3");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
