package com.paytm.business.merchantprofile.viewmodel;

import android.app.Application;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.a.d;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.event.OtpEnteredEvent;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.repo.ProfileRepository;
import com.paytm.business.merchantprofile.view.EditBasicDetailsDialogFragment;

public class OtpDialogViewModel extends c {
    public boolean isEditBank = false;
    public d<Boolean> mChangeCancelableCmd;
    public w<b<GenerateOtpResponseModel>> mGenerateOtpLiveData;
    public d<Boolean> mHideKeyboardCommand;
    public GenerateOtpResponseModel mOtpModel;
    public i<Spannable> mOtpSentToText;
    public String mOtpType;
    public String mOtpValue;
    public ObservableBoolean showProgress = new ObservableBoolean(false);

    public OtpDialogViewModel(Application application) {
        super(application);
    }

    public void initDefaultParams() {
        this.mOtpSentToText = new i<>();
        this.mHideKeyboardCommand = new d<>();
        this.mGenerateOtpLiveData = new w<>();
        this.mChangeCancelableCmd = new d<>();
    }

    public void setData(boolean z) {
        this.isEditBank = z;
    }

    public LiveData<Boolean> getHideKeyBoardCmd() {
        return this.mHideKeyboardCommand;
    }

    public void onResendOtp() {
        this.showProgress.set(true);
        LiveData<b<GenerateOtpResponseModel>> generateOtp = ProfileRepository.getInstance().generateOtp(EditBasicDetailsDialogFragment.TYPE_LOGIN_DETAILS, "", false);
        this.mGenerateOtpLiveData.addSource(generateOtp, new z(generateOtp) {
            private final /* synthetic */ LiveData f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                OtpDialogViewModel.this.lambda$onResendOtp$0$OtpDialogViewModel(this.f$1, (b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onResendOtp$0$OtpDialogViewModel(LiveData liveData, b bVar) {
        this.mGenerateOtpLiveData.setValue(bVar);
        this.mGenerateOtpLiveData.removeSource(liveData);
    }

    public void onOTPEntered(CharSequence charSequence) {
        if (!this.isEditBank) {
            this.showProgress.set(true);
        }
        OtpEnteredEvent otpEnteredEvent = new OtpEnteredEvent(charSequence.toString());
        otpEnteredEvent.setOtpModel(this.mOtpModel);
        otpEnteredEvent.setOtpType(this.mOtpType);
        otpEnteredEvent.setOtpValue(this.mOtpValue);
        org.greenrobot.eventbus.c.a().c(otpEnteredEvent);
        this.mChangeCancelableCmd.setValue(Boolean.FALSE);
    }

    public LiveData<Boolean> getCancelableChangeCmd() {
        return this.mChangeCancelableCmd;
    }

    public void setData(GenerateOtpResponseModel generateOtpResponseModel, String str, String str2) {
        String str3;
        this.mOtpModel = generateOtpResponseModel;
        this.mOtpType = str;
        this.mOtpValue = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = getContext().getString(R.string.pr_otp_sent);
        } else {
            str3 = getContext().getString(R.string.pr_otp_sent_to) + " " + this.mOtpValue;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        if (!TextUtils.isEmpty(this.mOtpValue)) {
            spannableStringBuilder.setSpan(new StyleSpan(1), str3.indexOf(this.mOtpValue), str3.length(), 18);
        }
        this.mOtpSentToText.set(spannableStringBuilder);
    }

    public void setData(GenerateOtpResponseModel generateOtpResponseModel) {
        this.showProgress.set(false);
        this.mOtpModel = generateOtpResponseModel;
    }

    public void onErrorGeneratingOtp() {
        this.showProgress.set(false);
        LogUtility.e("OTPViewModel", "Error in generating otp");
    }

    public LiveData<b<GenerateOtpResponseModel>> getGenerateOtpEvent() {
        return this.mGenerateOtpLiveData;
    }

    public void onWrongOtpEntered() {
        this.showProgress.set(false);
        this.mChangeCancelableCmd.setValue(Boolean.TRUE);
    }

    public void setShowProgress(boolean z) {
        this.showProgress.set(z);
    }
}
