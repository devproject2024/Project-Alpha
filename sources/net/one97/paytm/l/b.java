package net.one97.paytm.l;

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
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public class b extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f52434a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f52435b;

    /* renamed from: c  reason: collision with root package name */
    private int f52436c = 100;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sec_feature_enable_later, viewGroup, false);
        this.f52434a = (TextView) inflate.findViewById(R.id.tv_got_it);
        this.f52435b = (ImageView) inflate.findViewById(R.id.iv_close_icon);
        this.f52434a.setOnClickListener(this);
        this.f52435b.setOnClickListener(this);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_got_it) {
            WalletSharedPrefs.INSTANCE.showSecFeatureModelPref(getActivity(), true);
            dismiss();
        } else if (id == R.id.iv_close_icon) {
            dismiss();
        }
    }

    public void dismiss() {
        super.dismiss();
        WalletSharedPrefs.INSTANCE.setSecFeatureSuccessShown(getActivity(), true);
    }
}
