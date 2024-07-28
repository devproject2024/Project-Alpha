package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.h.b;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class o extends g {

    /* renamed from: a  reason: collision with root package name */
    private d f18651a;

    public Dialog onCreateDialog(Bundle bundle) {
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(relativeLayout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setLayout(-1, -1);
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pdc_help_recieve_money_atm_card, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.ok_got_it_button);
        inflate.findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.b(view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.a(view);
            }
        });
        b.t(getActivity());
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d dVar = this.f18651a;
        if (dVar != null) {
            dVar.onFragmentAction(104, (Object) null);
        }
        dismiss();
    }
}
