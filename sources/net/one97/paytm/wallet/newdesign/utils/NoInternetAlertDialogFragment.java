package net.one97.paytm.wallet.newdesign.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.i.g;
import net.one97.paytm.wallet.R;

public class NoInternetAlertDialogFragment extends g {
    private static final String SHOULD_FINISH_ACTIVITY = "should_finish";
    private static final String TAG = "NoInternetAlertDialog";
    Button btnOk;
    TextView callTollFree;
    boolean isShouldFinishActivity;
    Context mContext;
    ImageView mCrossView;

    public static NoInternetAlertDialogFragment newInstance(boolean z) {
        NoInternetAlertDialogFragment noInternetAlertDialogFragment = new NoInternetAlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(SHOULD_FINISH_ACTIVITY, z);
        noInternetAlertDialogFragment.setArguments(bundle);
        return noInternetAlertDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.isShouldFinishActivity = arguments.getBoolean(SHOULD_FINISH_ACTIVITY);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.no_internet_dialog, viewGroup, false);
        this.mContext = getActivity();
        this.mCrossView = (ImageView) inflate.findViewById(R.id.image_cross);
        this.callTollFree = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.btnOk = (Button) inflate.findViewById(R.id.ok_btn);
        this.mCrossView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NoInternetAlertDialogFragment.this.dismissDialog();
                if (NoInternetAlertDialogFragment.this.isShouldFinishActivity && NoInternetAlertDialogFragment.this.getActivity() != null) {
                    NoInternetAlertDialogFragment.this.getActivity().onBackPressed();
                }
            }
        });
        this.btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NoInternetAlertDialogFragment.this.dismissDialog();
                if (NoInternetAlertDialogFragment.this.isShouldFinishActivity && NoInternetAlertDialogFragment.this.getActivity() != null) {
                    NoInternetAlertDialogFragment.this.getActivity().onBackPressed();
                }
            }
        });
        this.callTollFree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NoInternetAlertDialogFragment noInternetAlertDialogFragment = NoInternetAlertDialogFragment.this;
                noInternetAlertDialogFragment.launchIntent(new Intent("android.intent.action.DIAL", Uri.parse(noInternetAlertDialogFragment.mContext.getString(R.string.wallet_toll_free_number))));
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public void launchIntent(Intent intent) {
        try {
            intent.setData(Uri.parse("tel:" + this.mContext.getString(R.string.wallet_toll_free_number_without_space)));
            intent.addFlags(524288);
            this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            builder.setTitle(com.google.zxing.client.android.R.string.app_name);
            builder.setMessage(com.google.zxing.client.android.R.string.msg_intent_failed);
            builder.setPositiveButton(com.google.zxing.client.android.R.string.button_ok, (DialogInterface.OnClickListener) null);
            dismiss();
            builder.show();
        }
    }

    public void dismissDialog() {
        getDialog().dismiss();
    }
}
