package net.one97.paytm.fastag.ui.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.paytm.utility.v;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.dependencies.h;

public class b extends com.google.android.material.bottomsheet.b implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static int f13844d = 101;

    /* renamed from: a  reason: collision with root package name */
    public h f13845a;

    /* renamed from: b  reason: collision with root package name */
    public String f13846b;

    /* renamed from: c  reason: collision with root package name */
    public String f13847c;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_dialog_choose_image_ft, viewGroup, false);
        inflate.findViewById(R.id.crossButton).setOnClickListener(this);
        ((ViewGroup) inflate.findViewById(R.id.galleryLayout)).setOnClickListener(this);
        ((ViewGroup) inflate.findViewById(R.id.cameraLayout)).setOnClickListener(this);
        if (!v.a(this.f13846b)) {
            ((TextView) inflate.findViewById(R.id.dialogTitle)).setText(this.f13846b);
        }
        if (!v.a(this.f13847c)) {
            ((TextView) inflate.findViewById(R.id.gallerySubTitle)).setText(this.f13847c);
        }
        return inflate;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.cameraLayout) {
            h hVar = this.f13845a;
            if (hVar != null) {
                hVar.onFragmentAction(101, "action-camera");
            }
            dismiss();
        } else if (view.getId() == R.id.galleryLayout) {
            h hVar2 = this.f13845a;
            if (hVar2 != null) {
                hVar2.onFragmentAction(101, "action-gallery");
            }
            dismiss();
        } else if (view.getId() == R.id.crossButton) {
            dismiss();
        }
    }
}
