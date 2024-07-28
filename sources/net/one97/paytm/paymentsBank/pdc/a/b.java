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
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.paymentsBank.widget.FacilitiesView;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    private d f18605a;

    public static b a(d dVar) {
        b bVar = new b();
        bVar.f18605a = dVar;
        return bVar;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_pdc_atm_activation_success, (ViewGroup) null, false);
        inflate.findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        inflate.findViewById(R.id.paytments_bank_choose_card_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        o.a().initBottomBar(inflate.findViewById(R.id.parent_layout_bottom), getActivity(), new d() {
            public final void onFragmentAction(int i2, Object obj) {
                b.this.a(i2, obj);
            }
        });
        c.a("/bank/savings-account/debit-card/activation-success", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) getActivity());
        c.a(getActivity(), "bank_saving_account", "atm_card_activated", "", "", "/bank/savings-account/debit-card/activation-success", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        try {
            ((FacilitiesView) inflate.findViewById(R.id.help_title_1)).setTitle(getString(R.string.facility_withdraw_title));
            ((FacilitiesView) inflate.findViewById(R.id.help_title_2)).setTitle(getString(R.string.facility_shop_title));
            ((FacilitiesView) inflate.findViewById(R.id.help_title_3)).setTitle(getString(R.string.facility_qr_title));
            ((FacilitiesView) inflate.findViewById(R.id.help_title_1)).setSubTitle(getString(R.string.facility_withdraw_subtitle));
            ((FacilitiesView) inflate.findViewById(R.id.help_title_2)).setSubTitle(getString(R.string.facility_shop_subtitle));
            ((FacilitiesView) inflate.findViewById(R.id.help_title_3)).setSubTitle(getString(R.string.facility_qr_subtitle));
        } catch (Exception unused) {
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        dismiss();
    }
}
