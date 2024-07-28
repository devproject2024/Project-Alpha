package net.one97.paytm.paymentsBank.biometricAuthWall;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.m;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class b extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17445a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private f f17446b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f17447c;

    private View a(int i2) {
        if (this.f17447c == null) {
            this.f17447c = new HashMap();
        }
        View view = (View) this.f17447c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f17447c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        setStyle(1, 16973936);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        m.a(getActivity(), "biometric_popup_load_successful ", "biometric passcode", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        return layoutInflater.inflate(R.layout.pb_ask_for_fingerprint_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        net.one97.paytm.bankCommon.h.b.k(a2.getApplicationContext(), "willdoitlater");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a3 = am.a(activity).a(f.class);
        k.a((Object) a3, "ViewModelProviders.of(ac…del::class.java\n        )");
        this.f17446b = (f) a3;
        View.OnClickListener onClickListener = this;
        ((Button) a(R.id.btn_enable)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.tv_do_it_later)).setOnClickListener(onClickListener);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(String str) {
            k.c(str, "xCode");
            Bundle bundle = new Bundle();
            bundle.putString("xCode", str);
            b bVar = new b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public final void onClick(View view) {
        String string;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tv_do_it_later;
        if (valueOf != null && valueOf.intValue() == i2) {
            m.a(getActivity(), "biometric_do_it_later ", "biometric passcode", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            if (isAdded()) {
                c cVar = new c((String) null, "Will do it later");
                f fVar = this.f17446b;
                if (fVar == null) {
                    k.a("mBioMetricViewModel");
                }
                fVar.a(cVar);
                c.a(getActivity(), "biometric_first_setup", "intent_no", "", "", "/bank/biometric_first_setup", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                dismiss();
                return;
            }
            return;
        }
        int i3 = R.id.btn_enable;
        if (valueOf != null && valueOf.intValue() == i3) {
            m.a(getActivity(), "biometric_click_enable ", "biometric passcode", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            if (isAdded()) {
                Bundle arguments = getArguments();
                if (!(arguments == null || (string = arguments.getString("xCode")) == null)) {
                    c cVar2 = new c(string, "Proceed FingerPrint");
                    f fVar2 = this.f17446b;
                    if (fVar2 == null) {
                        k.a("mBioMetricViewModel");
                    }
                    fVar2.a(cVar2);
                }
                c.a(getActivity(), "biometric_first_setup", "intent_yes", "", "", "/bank/biometric_first_setup", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                dismiss();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17447c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
