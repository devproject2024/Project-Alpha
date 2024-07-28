package net.one97.paytm.passbook.b;

import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
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
import com.google.firebase.crashlytics.c;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.utility.r;

public class d extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f57086a;

    /* renamed from: b  reason: collision with root package name */
    TextView f57087b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f57088c;

    /* renamed from: d  reason: collision with root package name */
    Activity f57089d;

    /* renamed from: e  reason: collision with root package name */
    private int f57090e = 100;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pass_layout_sec_feature_model, viewGroup, false);
        this.f57086a = (TextView) inflate.findViewById(R.id.tv_add_security_feature);
        this.f57088c = (ImageView) inflate.findViewById(R.id.iv_close_icon);
        this.f57087b = (TextView) inflate.findViewById(R.id.tv_dont_ask);
        this.f57086a.setOnClickListener(this);
        this.f57088c.setOnClickListener(this);
        this.f57087b.setOnClickListener(this);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f57089d = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f57090e = arguments.getInt("paysend");
        }
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
        if (view.getId() == R.id.tv_add_security_feature) {
            if (this.f57090e == 208) {
                KeyguardManager keyguardManager = (KeyguardManager) getActivity().getSystemService("keyguard");
                Intent intent = null;
                if (Build.VERSION.SDK_INT >= 21) {
                    intent = keyguardManager.createConfirmDeviceCredentialIntent(getActivity().getResources().getString(R.string.unlock_passbook), "");
                }
                if (intent != null) {
                    try {
                        getActivity().startActivityForResult(intent, 208);
                    } catch (Exception e2) {
                        c.a().a((Throwable) e2);
                    }
                } else {
                    a aVar = new a();
                    Bundle bundle = new Bundle();
                    bundle.putInt("paysend", 208);
                    aVar.setArguments(bundle);
                    aVar.show(getActivity().getSupportFragmentManager(), "Dialog");
                }
            }
        } else if (view.getId() == R.id.iv_close_icon) {
            try {
                dismiss();
            } catch (IllegalStateException unused) {
            }
        } else if (view.getId() == R.id.tv_dont_ask) {
            r.INSTANCE.showSecFeatureModelPref(true);
            new b().show(getActivity().getSupportFragmentManager(), "Dialog");
            dismiss();
        }
    }

    public void dismiss() {
        super.dismiss();
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    public void show(j jVar, String str) {
        q a2 = jVar.a();
        a2.a((Fragment) this, str);
        a2.c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 208 && i3 == -1) {
            r.INSTANCE.showSecFeatureModelPref(true);
            r.INSTANCE.setPatternLock(true);
            if (!r.INSTANCE.isLockPatternSessionSet(getContext())) {
                r.INSTANCE.setLockPatternSession(true);
            }
            if (!r.INSTANCE.isSecFeatureSuccesShown(getActivity())) {
                c cVar = new c();
                Bundle bundle = new Bundle();
                bundle.putInt("paysend", 208);
                cVar.setArguments(bundle);
                cVar.show(getActivity().getSupportFragmentManager(), "Dialog");
            }
        }
        dismiss();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
