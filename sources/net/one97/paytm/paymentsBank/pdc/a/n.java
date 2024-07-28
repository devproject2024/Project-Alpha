package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.paytm.utility.b;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class n extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private d f18650a;

    public void onClick(View view) {
    }

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

    public static n a(d dVar) {
        n nVar = new n();
        nVar.f18650a = dVar;
        return nVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_req_atm_card_facility, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.pdc_request_atm_btm);
        inflate.findViewById(R.id.fragment_open_account_iv_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                n.this.b(view);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.payments_bank_info_btn_close);
        if (findViewById2 != null) {
            findViewById2.setVisibility(4);
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                n.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (!b.c((Context) getActivity())) {
            b.a((Context) getActivity(), getString(R.string.pb_check_your_network));
            return;
        }
        d dVar = this.f18650a;
        if (dVar != null) {
            dVar.onFragmentAction(100, (Object) null);
            dismiss();
        }
    }
}
