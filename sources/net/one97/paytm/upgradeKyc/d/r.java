package net.one97.paytm.upgradeKyc.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity;

public class r extends f {

    /* renamed from: a  reason: collision with root package name */
    BottomSheetBehavior f65745a;

    /* renamed from: b  reason: collision with root package name */
    String f65746b;

    /* renamed from: c  reason: collision with root package name */
    TextView f65747c;

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                r.this.a(dialogInterface);
            }
        });
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            this.f65745a = BottomSheetBehavior.from(frameLayout);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(net.one97.paytm.upgradeKyc.R.layout.pincode_unservice_sheet, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(net.one97.paytm.upgradeKyc.R.id.pincode_cross_iv);
        View findViewById = inflate.findViewById(net.one97.paytm.upgradeKyc.R.id.select_add_view);
        View findViewById2 = inflate.findViewById(net.one97.paytm.upgradeKyc.R.id.kyc_points_view);
        this.f65747c = (TextView) inflate.findViewById(net.one97.paytm.upgradeKyc.R.id.pincdoe_unservice_tv);
        if (getArguments() != null) {
            this.f65746b = getArguments().getString(AddEditGstinViewModelKt.BODY_PARAM_PINCODE);
        }
        this.f65747c.setText(getString(net.one97.paytm.upgradeKyc.R.string.pincode_unservice_text, this.f65746b));
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                r.this.c(view);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                r.this.b(view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                r.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        startActivity(new Intent(getActivity(), KycNearByActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismissAllowingStateLoss();
    }
}
