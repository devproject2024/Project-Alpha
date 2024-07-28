package com.business.merchant_payments.common.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseListener;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.common.utility.ScreenUtility;
import net.one97.paytm.i.g;

public class BaseDialogFragment extends g implements BaseListener {
    public ProgressDialog progressDialog;

    public void onStart() {
        super.onStart();
        try {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.getWindow().setLayout((int) (((float) ScreenUtility.getScreenWidth(getActivity())) * 0.85f), -2);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        PaymentsConfig.getInstance().getCommonUtils().a(context);
    }

    public void showProgressDialog() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 == null || !progressDialog2.isShowing()) {
            this.progressDialog = DialogUtility.showProgressDialog(getActivity(), getString(R.string.mp_please_wait));
        }
    }

    public void removeProgressDialog() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
    }
}
