package net.one97.paytm.l;

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
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public class d extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    TextView f52442a;

    /* renamed from: b  reason: collision with root package name */
    TextView f52443b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f52444c;

    /* renamed from: d  reason: collision with root package name */
    private int f52445d = 100;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sec_feature_model, viewGroup, false);
        this.f52442a = (TextView) inflate.findViewById(R.id.tv_add_security_feature);
        this.f52444c = (ImageView) inflate.findViewById(R.id.iv_close_icon);
        this.f52443b = (TextView) inflate.findViewById(R.id.tv_dont_ask);
        this.f52442a.setOnClickListener(this);
        this.f52444c.setOnClickListener(this);
        this.f52443b.setOnClickListener(this);
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f52445d = arguments.getInt("paysend");
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
        if (id == R.id.tv_add_security_feature) {
            int i2 = this.f52445d;
            Intent intent = null;
            if (i2 == 207) {
                KeyguardManager keyguardManager = (KeyguardManager) getActivity().getSystemService("keyguard");
                if (Build.VERSION.SDK_INT >= 21) {
                    intent = keyguardManager.createConfirmDeviceCredentialIntent(getActivity().getResources().getString(R.string.unlock_wallet), "");
                }
                if (intent != null) {
                    getActivity().startActivityForResult(intent, 207);
                } else {
                    WalletSharedPrefs.INSTANCE.setIsOopsDialogShownViaModel(getActivity(), true);
                    a aVar = new a();
                    Bundle bundle = new Bundle();
                    bundle.putInt("paysend", 207);
                    aVar.setArguments(bundle);
                    aVar.show(getActivity().getSupportFragmentManager(), "Dialog");
                }
            } else if (i2 == 208) {
                KeyguardManager keyguardManager2 = (KeyguardManager) getActivity().getSystemService("keyguard");
                if (Build.VERSION.SDK_INT >= 21) {
                    intent = keyguardManager2.createConfirmDeviceCredentialIntent(getActivity().getResources().getString(R.string.unlock_passbook), "");
                }
                if (intent != null) {
                    getActivity().startActivityForResult(intent, 208);
                } else {
                    a aVar2 = new a();
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("paysend", 208);
                    aVar2.setArguments(bundle2);
                    aVar2.show(getActivity().getSupportFragmentManager(), "Dialog");
                }
            }
            dismiss();
        } else if (id == R.id.iv_close_icon) {
            try {
                dismiss();
            } catch (IllegalStateException unused) {
            }
        } else if (id == R.id.tv_dont_ask) {
            WalletSharedPrefs.INSTANCE.showSecFeatureModelPref(getActivity(), true);
            new b().show(getActivity().getSupportFragmentManager(), "Dialog");
            dismiss();
        }
    }

    public void show(j jVar, String str) {
        q a2 = jVar.a();
        a2.a((Fragment) this, str);
        a2.c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 207 && i3 == -1) {
            WalletSharedPrefs.INSTANCE.showSecFeatureModelPref(getActivity(), true);
            WalletSharedPrefs.INSTANCE.setPatternLock(getActivity(), true);
            if (!WalletSharedPrefs.INSTANCE.isLockPatternSessionSet(getContext())) {
                WalletSharedPrefs.INSTANCE.setLockPatternSession(getActivity(), true);
            }
            if (!WalletSharedPrefs.INSTANCE.isSecFeatureSuccesShown(getActivity())) {
                c cVar = new c();
                Bundle bundle = new Bundle();
                bundle.putInt("paysend", 207);
                cVar.setArguments(bundle);
                cVar.show(getActivity().getSupportFragmentManager(), "Dialog");
            }
        }
        if (i2 == 208 && i3 == -1) {
            WalletSharedPrefs.INSTANCE.showSecFeatureModelPref(getActivity(), true);
            WalletSharedPrefs.INSTANCE.setPatternLock(getActivity(), true);
            if (!WalletSharedPrefs.INSTANCE.isLockPatternSessionSet(getContext())) {
                WalletSharedPrefs.INSTANCE.setLockPatternSession(getActivity(), true);
            }
            if (!WalletSharedPrefs.INSTANCE.isSecFeatureSuccesShown(getActivity())) {
                c cVar2 = new c();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("paysend", 208);
                cVar2.setArguments(bundle2);
                cVar2.show(getActivity().getSupportFragmentManager(), "Dialog");
            }
        }
        dismiss();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
