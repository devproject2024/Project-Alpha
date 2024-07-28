package net.one97.paytm.paymentsBank.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class j extends g {
    public static j a(String str) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putString("firstTitle", str);
        jVar.setArguments(bundle);
        return jVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        new Handler().postDelayed(new Runnable(dialog) {
            private final /* synthetic */ Dialog f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                j.a(this.f$0);
            }
        }, 3000);
        return dialog;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_frag_nach_confirmed, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.paytm_card_success_title);
        Bundle arguments = getArguments();
        if (arguments.containsKey("firstTitle")) {
            textView.setText(arguments.getString("firstTitle"));
        }
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        getActivity().finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        getActivity().finish();
    }
}
