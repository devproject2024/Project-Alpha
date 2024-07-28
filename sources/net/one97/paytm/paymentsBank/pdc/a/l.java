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
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.i.f;

public class l extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BottomSheetBehavior f18639a;

    /* renamed from: b  reason: collision with root package name */
    private d f18640b;

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                l.this.a(dialogInterface);
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
            this.f18639a = BottomSheetBehavior.from(frameLayout);
        }
        this.f18639a.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    l.this.f18639a.setState(3);
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(net.one97.paytm.paymentsBank.R.layout.pdc_fragment_update_app_bottom_sheet, viewGroup, false);
        getActivity();
        g.a();
        ((TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.tv_desc)).setText(net.one97.paytm.bankCommon.utils.d.a("pdcOrderUpdateDialogMsg"));
        getDialog().setCanceledOnTouchOutside(true);
        ((Button) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.open_acc_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                l.this.b(view);
            }
        });
        ((ImageView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_cross_iv)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                l.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        d dVar = this.f18640b;
        if (dVar != null) {
            dVar.onFragmentAction(107, (Object) null);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismissAllowingStateLoss();
    }
}
