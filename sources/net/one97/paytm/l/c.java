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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public class c extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f52438a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f52439b;

    /* renamed from: c  reason: collision with root package name */
    private int f52440c = 100;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sec_feature_enable_success, viewGroup, false);
        this.f52438a = (TextView) inflate.findViewById(R.id.tv_got_it);
        this.f52439b = (ImageView) inflate.findViewById(R.id.iv_close_icon);
        this.f52438a.setOnClickListener(this);
        this.f52439b.setOnClickListener(this);
        return inflate;
    }

    public void show(j jVar, String str) {
        q a2 = jVar.a();
        a2.a((Fragment) this, str);
        a2.c();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f52440c = arguments.getInt("paysend");
        }
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
        if (id == R.id.tv_got_it || id == R.id.iv_close_icon) {
            dismiss();
        }
    }

    public void dismiss() {
        super.dismiss();
        WalletSharedPrefs.INSTANCE.setSecFeatureSuccessShown(getActivity(), true);
    }
}
