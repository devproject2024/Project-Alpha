package com.paytm.business.merchantprofile.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.databinding.f;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.i;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseBottomSheetDialogFragment;
import com.paytm.business.merchantprofile.common.utility.GTMDataProviderImpl;
import com.paytm.business.merchantprofile.common.utility.NetworkService;
import com.paytm.business.merchantprofile.common.utility.RequestParamUtil;
import com.paytm.business.merchantprofile.databinding.PrFragmentRequestConfirmationBinding;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestConfirmationDialogFragment extends BaseBottomSheetDialogFragment {
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_SUB_TITLE = "sub_title";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TYPE_CHANGE = "type_change";
    public PrFragmentRequestConfirmationBinding mBinding;
    public String mDescription;
    public String mSubTitle;
    public String mTitle;
    public String mTypeOfChange;

    public static RequestConfirmationDialogFragment newInstance(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        RequestConfirmationDialogFragment requestConfirmationDialogFragment = new RequestConfirmationDialogFragment();
        bundle.putString("title", str);
        bundle.putString(KEY_SUB_TITLE, str2);
        bundle.putString(KEY_DESCRIPTION, str3);
        if (str4 != null) {
            bundle.putString(KEY_TYPE_CHANGE, str4);
        }
        requestConfirmationDialogFragment.setArguments(bundle);
        return requestConfirmationDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTitle = getArguments().getString("title");
        this.mSubTitle = getArguments().getString(KEY_SUB_TITLE);
        this.mDescription = getArguments().getString(KEY_DESCRIPTION);
        this.mTypeOfChange = getArguments().getString(KEY_TYPE_CHANGE);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (PrFragmentRequestConfirmationBinding) f.a(layoutInflater, R.layout.pr_fragment_request_confirmation, viewGroup, false);
        if (EditBasicDetailsDialogFragment.TYPE_LOGIN_DETAILS.equalsIgnoreCase(this.mTypeOfChange)) {
            setCancelable(false);
        }
        return this.mBinding.getRoot();
    }

    public void initUI() {
        handleBottomSheetBehavior(this.mBinding.getRoot());
        CustomTextView customTextView = this.mBinding.tvTitle;
        String str = this.mTitle;
        if (str == null) {
            str = "";
        }
        customTextView.setText(str);
        CustomTextView customTextView2 = this.mBinding.tvSubTitle;
        String str2 = this.mSubTitle;
        if (str2 == null) {
            str2 = "";
        }
        customTextView2.setText(str2);
        CustomTextView customTextView3 = this.mBinding.tvDesc;
        String str3 = this.mDescription;
        if (str3 == null) {
            str3 = "";
        }
        customTextView3.setText(str3);
        this.mBinding.tvDone.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RequestConfirmationDialogFragment.this.lambda$initUI$0$RequestConfirmationDialogFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initUI$0$RequestConfirmationDialogFragment(View view) {
        if (EditBasicDetailsDialogFragment.TYPE_LOGIN_DETAILS.equalsIgnoreCase(this.mTypeOfChange)) {
            logoutUser();
        }
        dismiss();
    }

    private void logoutUser() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                ProfileConfig.getInstance().getCommonUtils().a(getActivity(), getActivity().getLocalClassName(), (Bundle) null);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void onSignOutApiCall(String str) {
        if (i.a(ProfileConfig.getInstance().getApplication())) {
            NetworkService networkService = ProfileConfig.getInstance().getNetworkService();
            String signOutApi = GTMDataProviderImpl.Companion.getMInstance().getSignOutApi();
            if (URLUtil.isValidUrl(signOutApi)) {
                networkService.onSignOut(signOutApi + str, RequestParamUtil.getAuthHeaders()).enqueue(new Callback<ResponseBody>(this) {
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() == 200) {
                            LogUtility.d("SIGNOUT", "Success");
                        }
                    }

                    public void onFailure(Call<ResponseBody> call, Throwable th) {
                        LogUtility.d("SIGNOUT", "Error signing out");
                    }
                });
            }
        }
    }
}
