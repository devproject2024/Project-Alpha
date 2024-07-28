package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class aw extends u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f56387b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f56388c;

    public final View a(int i2) {
        if (this.f56388c == null) {
            this.f56388c = new HashMap();
        }
        View view = (View) this.f56388c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56388c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56388c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogStyle);
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56389a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                aVar.setCanceledOnTouchOutside(false);
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
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
            dialog.setOnShowListener(b.f56389a);
        }
        return layoutInflater.inflate(R.layout.fragment_no_sim_card_dialog, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnOk);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        u.a("/login-signup", "login_signup", "no_sim_found_popup_loaded", (ArrayList) null, 24);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnOk;
        if (valueOf != null && valueOf.intValue() == i2) {
            u.a("/login-signup", "login_signup", "no_sim_found_ok_clicked", (ArrayList) null, 24);
            dismissAllowingStateLoss();
        }
    }
}
