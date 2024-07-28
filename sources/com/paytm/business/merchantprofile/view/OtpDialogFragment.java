package com.paytm.business.merchantprofile.view;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.business.common_module.OTPSmsRetriever;
import com.business.common_module.utilities.a.e;
import com.google.android.gms.internal.b.b;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.BaseBottomSheetDialogFragment;
import com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment;
import com.paytm.business.merchantprofile.common.utility.AppUtility;
import com.paytm.business.merchantprofile.databinding.PrOtpDialogViewBinding;
import com.paytm.business.merchantprofile.event.CloseOtpScreenEvent;
import com.paytm.business.merchantprofile.event.OtpWrongEvent;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.viewmodel.OtpDialogViewModel;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class OtpDialogFragment extends BaseBottomSheetDialogFragment {
    public static final String KEY_ISEDITBANK = "key_iseditbank";
    public static final String KEY_IS_PPBL = "key_is_ppbl";
    public static final String KEY_OTP_MODEL = "otp_model";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final String TAG = "OtpDialogFragment";
    public final int SMS_CONSENT_CODE = 15;
    public boolean isEditBank = false;
    public boolean isPPBL = false;
    public PrOtpDialogViewBinding mBinding;
    public OtpDialogViewModel mViewModel;
    public OtpEditBoxesCommonFragment otpEditBoxesCommonFragment;
    public OTPSmsRetriever otpSmsRetriever;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogStyle);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        startSMSListener();
        initSMSRetriever();
    }

    public void onDetach() {
        super.onDetach();
        if (getContext() != null && this.otpSmsRetriever != null) {
            getContext().unregisterReceiver(this.otpSmsRetriever);
        }
    }

    private void startSMSListener() {
        if (getContext() != null) {
            new b(getContext()).b();
        }
    }

    private void initSMSRetriever() {
        this.otpSmsRetriever = new OTPSmsRetriever((Fragment) this);
        getContext().registerReceiver(this.otpSmsRetriever, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public static OtpDialogFragment newInstance(String str, String str2, GenerateOtpResponseModel generateOtpResponseModel, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        OtpDialogFragment otpDialogFragment = new OtpDialogFragment();
        bundle.putString("type", str);
        bundle.putString("value", str2);
        bundle.putSerializable(KEY_OTP_MODEL, generateOtpResponseModel);
        bundle.putSerializable(KEY_ISEDITBANK, Boolean.valueOf(z));
        bundle.putSerializable(KEY_IS_PPBL, Boolean.valueOf(z2));
        otpDialogFragment.setArguments(bundle);
        return otpDialogFragment;
    }

    public void initUI() {
        handleBottomSheetBehavior(this.mBinding.getRoot());
        OtpDialogViewModel otpDialogViewModel = (OtpDialogViewModel) ((BaseActivity) getActivity()).provideViewModel(OtpDialogViewModel.class, this);
        this.mViewModel = otpDialogViewModel;
        this.mBinding.setViewModel(otpDialogViewModel);
        this.mBinding.crossIv.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OtpDialogFragment.this.lambda$initUI$0$OtpDialogFragment(view);
            }
        });
        if (getArguments() != null) {
            String string = getArguments().getString("type");
            String string2 = getArguments().getString("value");
            this.isEditBank = getArguments().getBoolean(KEY_ISEDITBANK);
            boolean z = getArguments().getBoolean(KEY_IS_PPBL);
            this.isPPBL = z;
            if (z) {
                this.mBinding.tvEnterOtp.setText(getResources().getString(R.string.pr_ppbl_otp_h1));
                this.mBinding.tvSentToText.setText(getResources().getString(R.string.pr_ppbl_otp_h2));
                this.mBinding.proceedBtn.setText(getResources().getString(R.string.pr_confirm));
                this.mBinding.fillerView.setVisibility(0);
                this.mBinding.crossIv.setVisibility(8);
                this.mBinding.backIV.setVisibility(0);
                this.mBinding.backIV.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        OtpDialogFragment.this.lambda$initUI$1$OtpDialogFragment(view);
                    }
                });
            }
            this.mViewModel.setData(this.isEditBank);
            this.mViewModel.setData((GenerateOtpResponseModel) getArguments().getSerializable(KEY_OTP_MODEL), string, string2);
        }
        this.mViewModel.getHideKeyBoardCmd().observe(this, new z() {
            public final void onChanged(Object obj) {
                OtpDialogFragment.this.lambda$initUI$2$OtpDialogFragment((Boolean) obj);
            }
        });
        this.mViewModel.getCancelableChangeCmd().observe(this, new z() {
            public final void onChanged(Object obj) {
                OtpDialogFragment.this.setCancelable(((Boolean) obj).booleanValue());
            }
        });
        this.otpEditBoxesCommonFragment = new OtpEditBoxesCommonFragment();
        getChildFragmentManager().a().a(R.id.container_id, (Fragment) this.otpEditBoxesCommonFragment).b();
        this.mBinding.containerId.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OtpDialogFragment.this.lambda$initUI$3$OtpDialogFragment(view);
            }
        });
        this.mBinding.proceedBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OtpDialogFragment.this.lambda$initUI$4$OtpDialogFragment(view);
            }
        });
        this.mViewModel.getGenerateOtpEvent().observe(this, new z() {
            public final void onChanged(Object obj) {
                OtpDialogFragment.this.lambda$initUI$5$OtpDialogFragment((com.business.common_module.utilities.a.b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initUI$0$OtpDialogFragment(View view) {
        dismiss();
    }

    public /* synthetic */ void lambda$initUI$1$OtpDialogFragment(View view) {
        dismiss();
    }

    public /* synthetic */ void lambda$initUI$2$OtpDialogFragment(Boolean bool) {
        hideKeyboard(this.mBinding.btnResendOtp);
    }

    public /* synthetic */ void lambda$initUI$3$OtpDialogFragment(View view) {
        if (getActivity() != null) {
            showKeyboard(getActivity());
        }
    }

    public /* synthetic */ void lambda$initUI$4$OtpDialogFragment(View view) {
        String otpCombined = this.otpEditBoxesCommonFragment.getOtpCombined();
        if (!TextUtils.isEmpty(otpCombined)) {
            this.mViewModel.onOTPEntered(otpCombined);
        }
    }

    public /* synthetic */ void lambda$initUI$5$OtpDialogFragment(com.business.common_module.utilities.a.b bVar) {
        T t;
        if (bVar != null) {
            if (!bVar.f7357b.equals(e.LOADING)) {
                this.mViewModel.setShowProgress(false);
                if (bVar.f7356a == null || (t = bVar.f7358c) == null || ((GenerateOtpResponseModel) t).getStatus().equalsIgnoreCase("FAILURE")) {
                    T t2 = bVar.f7358c;
                    if (t2 != null) {
                        String message = ((GenerateOtpResponseModel) t2).getMessage();
                        this.mViewModel.setShowProgress(false);
                        if (TextUtils.isEmpty(message)) {
                            message = getActivity().getResources().getString(R.string.pr_lbl_please_try_again_later);
                        }
                        Toast.makeText(getContext(), message, 1).show();
                        return;
                    }
                    this.mViewModel.onErrorGeneratingOtp();
                    return;
                }
                this.mViewModel.setData((GenerateOtpResponseModel) bVar.f7358c);
                Toast.makeText(getContext(), R.string.pr_otp_sent, 1).show();
            } else if (!this.isEditBank) {
                this.mViewModel.setShowProgress(true);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 15 && i3 == -1) {
            setOTP(AppUtility.getOtpFromSms("paytm", intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE")));
        }
    }

    public void setOTP(String str) {
        OtpEditBoxesCommonFragment otpEditBoxesCommonFragment2 = this.otpEditBoxesCommonFragment;
        if (otpEditBoxesCommonFragment2 != null) {
            otpEditBoxesCommonFragment2.setOtpCombined(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PrOtpDialogViewBinding prOtpDialogViewBinding = (PrOtpDialogViewBinding) f.a(layoutInflater, R.layout.pr_otp_dialog_view, viewGroup, false);
        this.mBinding = prOtpDialogViewBinding;
        return prOtpDialogViewBinding.getRoot();
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onStop() {
        super.onStop();
        c.a().b(this);
    }

    @j
    public void onWrongOtpEntered(OtpWrongEvent otpWrongEvent) {
        String str;
        if (!TextUtils.isEmpty(otpWrongEvent.getMessage())) {
            str = otpWrongEvent.getMessage();
        } else {
            str = getContext().getString(R.string.pr_incorrect_otp);
        }
        this.otpEditBoxesCommonFragment.setOtpError(str);
        this.mViewModel.onWrongOtpEntered();
    }

    @j
    public void onOtpValidationSuccess(CloseOtpScreenEvent closeOtpScreenEvent) {
        dismiss();
    }

    public void showKeyboard(Context context) {
        if (context != null && ((InputMethodManager) context.getSystemService("input_method")) != null) {
            ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(2, 1);
        }
    }
}
