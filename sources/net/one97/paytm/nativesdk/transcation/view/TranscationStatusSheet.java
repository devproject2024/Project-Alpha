package net.one97.paytm.nativesdk.transcation.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.view.fragment.CustomBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.databinding.LytPaymentStatusSheetBinding;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.transcation.listners.TranscationStatusListner;
import net.one97.paytm.nativesdk.transcation.viewmodel.TranscationStatusViewmodel;

public class TranscationStatusSheet extends CustomBottomSheetDialogFragment implements TranscationStatusListner {
    private LytPaymentStatusSheetBinding lytPaymentStatusSheetBinding;
    private OnBottomSheetChangeListener mBottomSheetChangeListener;
    /* access modifiers changed from: private */
    public Context mContext;
    private LottieAnimationView mFetchPayMethodsProgress;
    private TranscationStatusViewmodel transcationStatusViewmodel;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lytPaymentStatusSheetBinding = (LytPaymentStatusSheetBinding) f.a(getLayoutInflater(), R.layout.lyt_payment_status_sheet, (ViewGroup) null, false);
        this.transcationStatusViewmodel = new TranscationStatusViewmodel(this.mContext, DirectPaymentBL.getInstance().getTranscationStatusResponse(), this);
        this.lytPaymentStatusSheetBinding.setTranscationViewModel(this.transcationStatusViewmodel);
        this.mFetchPayMethodsProgress = this.lytPaymentStatusSheetBinding.dotProgressBar;
        setAnimation(this.mFetchPayMethodsProgress);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4 || SDKUtility.isPaytmApp(TranscationStatusSheet.this.mContext)) {
                    return true;
                }
                TranscationStatusSheet.this.getActivity().finish();
                return false;
            }
        });
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    TranscationStatusSheet.this.dismiss();
                } catch (Exception unused) {
                }
            }
        }, 4000);
        return this.lytPaymentStatusSheetBinding.getRoot();
    }

    private void setAnimation(LottieAnimationView lottieAnimationView) {
        this.mFetchPayMethodsProgress.setVisibility(0);
        this.mFetchPayMethodsProgress.setAnimation("Payments-Loader.json");
        this.mFetchPayMethodsProgress.loop(true);
        this.mFetchPayMethodsProgress.playAnimation();
    }

    public void onDestroy() {
        super.onDestroy();
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.RESPONSE, DirectPaymentBL.getInstance().getTranscationStatusResponse());
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
        }
        if (getContext() != null) {
            Intent intent = new Intent("kill");
            intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
            a.a(getContext().getApplicationContext()).a(intent);
        }
    }

    public void onTranscationStatus(int i2) {
        if (i2 == TranscationStatus.TXN_FAILURE.getStatus()) {
            this.lytPaymentStatusSheetBinding.iconTranscationStatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_failed_icon));
        } else if (i2 == TranscationStatus.PENDING.getStatus()) {
            this.lytPaymentStatusSheetBinding.iconTranscationStatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_pending));
        } else if (i2 == TranscationStatus.TXN_SUCCESS.getStatus()) {
            this.lytPaymentStatusSheetBinding.iconTranscationStatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_success_icon));
        } else if (i2 == TranscationStatus.UNKNOWN.getStatus()) {
            this.lytPaymentStatusSheetBinding.iconTranscationStatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_failed_icon));
        }
    }

    public void setBottomSheetChangeListener(OnBottomSheetChangeListener onBottomSheetChangeListener) {
        this.mBottomSheetChangeListener = onBottomSheetChangeListener;
    }
}
