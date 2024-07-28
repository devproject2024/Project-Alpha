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
import com.google.android.material.bottomsheet.a;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.utility.r;

public class b extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f57077a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f57078b;

    /* renamed from: c  reason: collision with root package name */
    Activity f57079c;

    /* renamed from: d  reason: collision with root package name */
    private int f57080d = 100;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pass_layout_sec_feature_enable_later, viewGroup, false);
        this.f57077a = (TextView) inflate.findViewById(R.id.tv_got_it);
        this.f57078b = (ImageView) inflate.findViewById(R.id.iv_close_icon);
        this.f57077a.setOnClickListener(this);
        this.f57078b.setOnClickListener(this);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f57079c = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_got_it) {
            r.INSTANCE.showSecFeatureModelPref(true);
            dismiss();
        } else if (view.getId() == R.id.iv_close_icon) {
            dismiss();
        }
    }

    public void dismiss() {
        super.dismiss();
        r.INSTANCE.setSecFeatureSuccessShown(true);
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }
}
