package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class p extends g {

    /* renamed from: a  reason: collision with root package name */
    private d f18652a;

    public static p a(d dVar) {
        p pVar = new p();
        pVar.f18652a = dVar;
        return pVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_atm_pin_changed_success, (ViewGroup) null, false);
        inflate.findViewById(R.id.btn_pay_now).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                p.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d dVar = this.f18652a;
        if (dVar != null) {
            dVar.onFragmentAction(1234, (Object) null);
        }
        dismiss();
    }
}
