package net.one97.paytm.paymentsBank.pdc.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.paytm.utility.v;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;

public class c extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    d f18606a;

    /* renamed from: b  reason: collision with root package name */
    private String f18607b;

    /* renamed from: c  reason: collision with root package name */
    private String f18608c;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_dialog_choose_image, viewGroup, false);
        inflate.findViewById(R.id.crossButton).setOnClickListener(this);
        ((ViewGroup) inflate.findViewById(R.id.galleryLayout)).setOnClickListener(this);
        ((ViewGroup) inflate.findViewById(R.id.cameraLayout)).setOnClickListener(this);
        if (!v.a(this.f18607b)) {
            ((TextView) inflate.findViewById(R.id.dialogTitle)).setText(this.f18607b);
        }
        if (!v.a(this.f18608c)) {
            ((TextView) inflate.findViewById(R.id.gallerySubTitle)).setText(this.f18608c);
        }
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cameraLayout) {
            d dVar = this.f18606a;
            if (dVar != null) {
                dVar.onFragmentAction(101, "action-camera");
            }
            dismiss();
        } else if (id == R.id.galleryLayout) {
            d dVar2 = this.f18606a;
            if (dVar2 != null) {
                dVar2.onFragmentAction(101, "action-gallery");
            }
            dismiss();
        } else if (id == R.id.crossButton) {
            dismiss();
        }
    }
}
