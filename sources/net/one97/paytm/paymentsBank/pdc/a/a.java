package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.h.b;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.widget.FacilitiesView;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    private d f18604a;

    public static a a(d dVar) {
        a aVar = new a();
        aVar.f18604a = dVar;
        return aVar;
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pdc_help_activate_atm_card, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.fragment_pdc_help_activate_atm_card_btn);
        inflate.findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        try {
            ((FacilitiesView) inflate.findViewById(R.id.help_title_1)).setTitle(getString(R.string.you_can_act_atm_once_rec_it));
            ((FacilitiesView) inflate.findViewById(R.id.help_title_2)).setTitle(getString(R.string.scan_qr_back_of_atm));
            ((FacilitiesView) inflate.findViewById(R.id.help_title_3)).setTitle(getString(R.string.set_four_digit_atm_pin));
        } catch (Exception unused) {
        }
        b.t(getActivity());
        c.a("/bank/savings-account/debit-card/activate", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) getActivity());
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c.a(getActivity(), "bank_saving_account", "activate_atm_card_button_clicked", "", "", "/bank/savings-account/debit-card/activate", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        d dVar = this.f18604a;
        if (dVar != null) {
            dVar.onFragmentAction(103, (Object) null);
        }
        dismiss();
    }
}
