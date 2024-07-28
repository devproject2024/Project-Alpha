package net.one97.paytm.paymentsBank.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
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
import net.one97.paytm.i.f;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    public d f18488a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BottomSheetBehavior f18489b;

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                c.this.a(dialogInterface);
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
            this.f18489b = BottomSheetBehavior.from(frameLayout);
        }
        this.f18489b.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    c.this.f18489b.setState(3);
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(net.one97.paytm.paymentsBank.R.layout.fragment_block_non_rupay_vdcbottom_sheet, viewGroup, false);
        Button button = (Button) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.btn_proceed);
        ImageView imageView = (ImageView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.iv_cross);
        TextView textView = (TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.tv_message);
        String string = getString(net.one97.paytm.paymentsBank.R.string.pb_dc_static_price);
        String string2 = getArguments().getString("cardType");
        if (TextUtils.isEmpty(string2)) {
            string2 = getString(net.one97.paytm.paymentsBank.R.string.pb_card_name_visa);
        }
        textView.setText(getString(net.one97.paytm.paymentsBank.R.string.pb_block_non_rupay_vdc_dialog_desc, string2, string));
        getDialog().setCanceledOnTouchOutside(true);
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.b(view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        d dVar = this.f18488a;
        if (dVar != null) {
            dVar.onFragmentAction(108, (Object) null);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismissAllowingStateLoss();
    }
}
