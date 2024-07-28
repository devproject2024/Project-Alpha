package net.one97.paytm.wallet.newdesign.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.q;
import net.one97.paytm.common.widgets.a;
import net.one97.paytm.paytm_finance.R;

public class CustomWalletLoaderDialog {
    private static CustomWalletLoaderDialog customWalletLoaderDialog;
    private Dialog dialog;
    private Context mContext;
    private View mProgressView;
    private String mSubTitle;
    private String mTitle;
    private boolean setCancelable = false;
    private boolean setCanceledOnTouchOutside = false;

    public CustomWalletLoaderDialog(Context context) {
        this.mContext = context;
    }

    public static CustomWalletLoaderDialog getInstance(Context context) {
        if (customWalletLoaderDialog == null) {
            customWalletLoaderDialog = new CustomWalletLoaderDialog(context);
        }
        return customWalletLoaderDialog;
    }

    public void showLoader() {
        Dialog dialog2 = this.dialog;
        if (dialog2 == null || !dialog2.isShowing()) {
            this.dialog = new Dialog(this.mContext);
            this.dialog.requestWindowFeature(1);
            this.dialog.setContentView(R.layout.new_wallet_loader_dialog);
            if (!TextUtils.isEmpty(this.mTitle)) {
                ((TextView) this.dialog.findViewById(R.id.tv_title)).setText(this.mTitle);
            }
            if (this.mSubTitle != null) {
                ((TextView) this.dialog.findViewById(R.id.tv_subtitle)).setText(this.mSubTitle);
            }
            this.mProgressView = this.dialog.findViewById(R.id.lyt_wallet_loader);
            View view = this.mProgressView;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.a((LottieAnimationView) this.mProgressView.findViewById(R.id.wallet_loader));
            }
            this.dialog.setCancelable(this.setCancelable);
            this.dialog.setCanceledOnTouchOutside(this.setCanceledOnTouchOutside);
            try {
                if (!((Activity) this.mContext).isFinishing()) {
                    this.dialog.show();
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public void dismissLoader() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            View view = this.mProgressView;
            if (!(view == null || view.findViewById(R.id.wallet_loader) == null)) {
                a.b((LottieAnimationView) this.mProgressView.findViewById(R.id.wallet_loader));
            }
            this.dialog.dismiss();
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    public void setSetCancelable(boolean z) {
        this.setCancelable = z;
    }

    public void setSetCanceledOnTouchOutside(boolean z) {
        this.setCanceledOnTouchOutside = z;
    }
}
