package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.appcompat.app.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;

public class BaseDialogFragment extends DialogFragment implements BaseMvpView {
    public static final String DISMISS_PARENT_ON_OK_OR_BACK = "DISMISS_PARENT_ON_OK_OR_BACK";
    public static final String ERROR_MESSAGE = "error_msg";
    public static final String IS_CANCELABLE = "is_cancelable";

    public void showError(String str, FeedParticipationEnum feedParticipationEnum) {
    }

    public void startProgressBar() {
    }

    public void stopProgressBar() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.m();
    }

    public void onStart() {
        super.onStart();
        if (getDialog() == null) {
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        fragmentManager.beginTransaction().add(this, str).commitAllowingStateLoss();
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }
}
