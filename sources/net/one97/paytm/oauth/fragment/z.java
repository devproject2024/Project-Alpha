package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.oauth.OauthModule;

public final class z extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56676a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f56677b;

    private View a(int i2) {
        if (this.f56677b == null) {
            this.f56677b = new HashMap();
        }
        View view = (View) this.f56677b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56677b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56678a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(R.id.design_bottom_sheet);
                if (findViewById2 != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(findViewById2);
                    k.a((Object) from, "BottomSheetBehavior.from(it)");
                    from.setState(3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(b.f56678a);
        }
        return layoutInflater.inflate(net.one97.paytm.oauth.R.layout.fragment_dialog_congrats_account, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View a2 = a(net.one97.paytm.oauth.R.id.viewBg1);
        if (a2 != null) {
            a2.setOnClickListener(this);
        }
        View a3 = a(net.one97.paytm.oauth.R.id.viewBg2);
        if (a3 != null) {
            a3.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = net.one97.paytm.oauth.R.id.viewBg1;
        if (valueOf != null && valueOf.intValue() == i2) {
            OauthModule.b().checkDeepLinking(getContext(), "paytmmp://mobile_prepaid?url=https://digitalcatalog.paytm.com/v1/mobile/mobile-prepaid/17?label=Prepaid%20Mobile$related_category=[%7B%20%22url%22:%22https://digitalcatalog.paytm.com/v1/mobile/mobile-postpaid/21%22,%20%22label%22:%22Postpaid%20Mobile%22%7D]$prepaid_on=Y");
        } else {
            int i3 = net.one97.paytm.oauth.R.id.viewBg2;
            if (valueOf != null && valueOf.intValue() == i3) {
                OauthModule.b().checkDeepLinking(getContext(), "paytmmp://cash_wallet?featuretype=money_transfer");
            }
        }
        dismissAllowingStateLoss();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56677b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
