package net.one97.paytm.nativesdk.otp.view;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.databinding.FragmentVerifyOtpNativeBinding;
import net.one97.paytm.nativesdk.login.view.activity.PaytmMainActivity;
import net.one97.paytm.nativesdk.otp.Listner.OTPListner;
import net.one97.paytm.nativesdk.otp.viewmodel.OtpViewModel;

public class OtpVerificationFragment extends h implements OTPListner {
    private LottieAnimationView mFetchPayMethodsProgress;
    /* access modifiers changed from: private */
    public OtpViewModel mOtpViewholder;
    /* access modifiers changed from: private */
    public FragmentVerifyOtpNativeBinding otpBinding;
    private CountDownTimer timer;

    private void registerSmsReceiver() {
    }

    private void unregisterSmsReceiver() {
    }

    public static OtpVerificationFragment getInstance(String str) {
        OtpVerificationFragment otpVerificationFragment = new OtpVerificationFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.MOBILE_NO, str);
        otpVerificationFragment.setArguments(bundle);
        return otpVerificationFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mOtpViewholder = new OtpViewModel(getActivity(), getArguments().getString(SDKConstants.MOBILE_NO), this);
        this.mOtpViewholder.setmToken(getArguments().getString("txnToken"));
        this.otpBinding = (FragmentVerifyOtpNativeBinding) f.a(getLayoutInflater(), R.layout.fragment_verify_otp_native, (ViewGroup) null, false);
        this.otpBinding.txtPinEntry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 == 6) {
                    int length = OtpVerificationFragment.this.otpBinding.txtPinEntry.getText().toString().length();
                    if (length == 0) {
                        OtpVerificationFragment.this.mOtpViewholder.mErrorMsg.set(OtpVerificationFragment.this.getContext().getResources().getString(R.string.enter_otp));
                        OtpVerificationFragment.this.mOtpViewholder.lytErrorMsgsVisblity.set(0);
                        OtpVerificationFragment.this.onFailureOTPSend("");
                        return true;
                    } else if (length < 6) {
                        OtpVerificationFragment.this.mOtpViewholder.mErrorMsg.set(OtpVerificationFragment.this.getContext().getResources().getString(R.string.incorrect_otp));
                        OtpVerificationFragment.this.mOtpViewholder.lytErrorMsgsVisblity.set(0);
                        OtpVerificationFragment.this.onFailureOTPSend("");
                        return true;
                    } else {
                        OtpVerificationFragment.this.mOtpViewholder.onOtpReceived(OtpVerificationFragment.this.getContext(), OtpVerificationFragment.this.otpBinding.txtPinEntry.getText().toString());
                    }
                }
                return false;
            }
        });
        this.otpBinding.setOtpViewholder(this.mOtpViewholder);
        this.mFetchPayMethodsProgress = this.otpBinding.dotProgressBar;
        setAnimation(this.mFetchPayMethodsProgress);
        TextView textView = this.otpBinding.tvPhoneNumber;
        textView.setText("+91 " + getArguments().getString(SDKConstants.MOBILE_NO));
        SDKUtility.showKeyboard(this.otpBinding.txtPinEntry);
        return this.otpBinding.getRoot();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        unregisterSmsReceiver();
    }

    public void onSmsReceived(String str, String str2) {
        String otpFromSms = SDKUtility.getOtpFromSms(str, str2);
        if (otpFromSms != null) {
            this.mOtpViewholder.setmOtp(otpFromSms);
        }
    }

    public void onVerifyOTP(boolean z) {
        if (z) {
            ((PaytmMainActivity) getActivity()).startInstrumentActivity();
        }
    }

    public void onNetworkUnavailable(Request request) {
        DialogUtility.showNetworkDialog(request, getActivity());
    }

    public void onFailureOTPSend(String str) {
        setAnimation();
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void resendOtpDisable() {
        this.otpBinding.tvResendOtp.setText(getContext().getString(R.string.otp_sent));
        this.otpBinding.tvResendOtp.setTextColor(-7829368);
        this.otpBinding.tvResendOtp.setEnabled(false);
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = new CountDownTimer(10000, 1000) {
            public void onTick(long j) {
                TextView textView = OtpVerificationFragment.this.otpBinding.tvResendOtp;
                textView.setText(OtpVerificationFragment.this.getContext().getString(R.string.otp_sent) + " (" + (j / 1000) + ")");
            }

            public void onFinish() {
                OtpVerificationFragment.this.otpBinding.tvResendOtp.setText(OtpVerificationFragment.this.getContext().getString(R.string.native_resend_otp));
                OtpVerificationFragment.this.otpBinding.tvResendOtp.setTextColor(OtpVerificationFragment.this.getContext().getResources().getColor(R.color.native_light_blue));
                OtpVerificationFragment.this.otpBinding.tvResendOtp.setEnabled(true);
            }
        };
        this.timer.start();
    }

    private void setAnimation(LottieAnimationView lottieAnimationView) {
        this.mFetchPayMethodsProgress.setVisibility(0);
        this.mFetchPayMethodsProgress.setAnimation("Payments-Loader.json");
        this.mFetchPayMethodsProgress.loop(true);
        this.mFetchPayMethodsProgress.playAnimation();
    }

    public void setAnimation() {
        final Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.shake_from_left_anim);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.shake_from_right_anim);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            int count = 0;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        if (AnonymousClass3.this.count < 2) {
                            AnonymousClass3.this.count++;
                            OtpVerificationFragment.this.otpBinding.txtPinEntry.startAnimation(loadAnimation);
                        }
                    }
                });
                OtpVerificationFragment.this.otpBinding.txtPinEntry.startAnimation(loadAnimation2);
            }
        });
        this.otpBinding.txtPinEntry.startAnimation(loadAnimation);
        SDKUtility.showKeyboard(this.otpBinding.txtPinEntry);
    }
}
