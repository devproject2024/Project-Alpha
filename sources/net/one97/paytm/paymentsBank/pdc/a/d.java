package net.one97.paytm.paymentsBank.pdc.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import net.one97.paytm.i.f;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.bankCommon.f.d f18609a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BottomSheetBehavior f18610b;

    public static d a(String str, String str2, String str3) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putString(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, str2);
        bundle.putString("contact", str3);
        dVar.setArguments(bundle);
        return dVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                d.this.a(dialogInterface);
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        if (frameLayout != null) {
            this.f18610b = BottomSheetBehavior.from(frameLayout);
        }
        this.f18610b.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    d.this.f18610b.setState(3);
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(net.one97.paytm.paymentsBank.R.layout.pdc_fragment_confirm_address_bottom_sheet, viewGroup, false);
        Bundle arguments = getArguments();
        ((TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.tv_address)).setText(arguments.getString(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS));
        ((TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.tv_contact)).setText(arguments.getString("contact"));
        ((TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.tv_name)).setText(arguments.getString("name"));
        getDialog().setCanceledOnTouchOutside(true);
        ((Button) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.open_acc_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.b(view);
            }
        });
        ((ImageView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_cross_iv)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        net.one97.paytm.bankCommon.f.d dVar = this.f18609a;
        if (dVar != null) {
            dVar.onFragmentAction(106, (Object) null);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismissAllowingStateLoss();
    }
}
