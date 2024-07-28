package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.errorview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;

public class NetworkTimeoutDialog extends BaseDialogFragment {
    /* access modifiers changed from: private */
    public boolean finishParent;
    TextView mTvNoConnDesc;
    TextView mTvTryAgain;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sheroes_network_timeout, viewGroup, false);
        this.mTvNoConnDesc = (TextView) inflate.findViewById(R.id.sheroes_tv_no_conn_desc);
        this.mTvTryAgain = (TextView) inflate.findViewById(R.id.sheroes_tv_try_again);
        this.mTvTryAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NetworkTimeoutDialog.this.tryAgainClick();
            }
        });
        getDialog().getWindow().requestFeature(1);
        this.finishParent = getArguments().getBoolean(BaseDialogFragment.DISMISS_PARENT_ON_OK_OR_BACK);
        boolean z = getArguments().getBoolean(BaseDialogFragment.IS_CANCELABLE);
        String string = getArguments().getString(BaseDialogFragment.ERROR_MESSAGE);
        if (AppConstants.MARK_AS_SPAM.equalsIgnoreCase(string) || AppConstants.FACEBOOK_VERIFICATION.equalsIgnoreCase(string)) {
            this.mTvTryAgain.setText(getString(R.string.sheroes_ID_DONE));
        } else {
            this.mTvTryAgain.setText(getString(R.string.sheroes_IDS_STR_TRY_AGAIN_TEXT));
        }
        if (StringUtil.isNotNullOrEmptyString(string)) {
            this.mTvNoConnDesc.setText(string);
        }
        setCancelable(z);
        return inflate;
    }

    public void tryAgainClick() {
        dismissAllowingStateLoss();
        if (this.finishParent) {
            dismiss();
            return;
        }
        dismiss();
        getActivity().recreate();
    }

    public void onStart() {
        super.onStart();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(getActivity(), getTheme()) {
            public void onBackPressed() {
                NetworkTimeoutDialog.this.dismissAllowingStateLoss();
                if (NetworkTimeoutDialog.this.finishParent) {
                    dismiss();
                    return;
                }
                dismiss();
                NetworkTimeoutDialog.this.getActivity().recreate();
            }
        };
    }
}
