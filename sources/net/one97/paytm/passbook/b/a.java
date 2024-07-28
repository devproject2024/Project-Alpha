package net.one97.paytm.passbook.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.utility.r;

public class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f57073a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f57074b;

    /* renamed from: c  reason: collision with root package name */
    private int f57075c = 100;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pass_layout_sec_feature_error, viewGroup, false);
        this.f57073a = (TextView) inflate.findViewById(R.id.tv_goto_settings);
        this.f57074b = (ImageView) inflate.findViewById(R.id.iv_close_icon);
        this.f57073a.setOnClickListener(this);
        this.f57074b.setOnClickListener(this);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f57075c = arguments.getInt("paysend");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_goto_settings) {
            dismiss();
        } else if (view.getId() == R.id.iv_close_icon) {
            dismiss();
        }
    }

    public void dismiss() {
        super.dismiss();
        r.INSTANCE.setSecFeatureSuccessShown(false);
        r.INSTANCE.setPatternLock(false);
    }
}
