package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class ao extends u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f56350b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f56351c;

    public final View a(int i2) {
        if (this.f56351c == null) {
            this.f56351c = new HashMap();
        }
        View view = (View) this.f56351c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56351c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56351c;
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
        public static final b f56352a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById2 != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(findViewById2);
                    k.a((Object) from, "BottomSheetBehavior.from(it)");
                    from.setState(3);
                }
                aVar.setCancelable(false);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(b.f56352a);
        }
        return layoutInflater.inflate(R.layout.fragment_bottomsheet_forgot_passcode, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnCall);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        u.a("/passcode_verification", "diy_block_logout", "helpline_number_popup_loaded", (ArrayList) null, 24);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            u.a("/passcode_verification", "diy_block_logout", "helpline_number_popup_closed", (ArrayList) null, 24);
            dismissAllowingStateLoss();
            return;
        }
        int i3 = R.id.btnCall;
        if (valueOf != null && valueOf.intValue() == i3) {
            u.a("/passcode_verification", "diy_block_logout", "helpline_number_cta_clicked", (ArrayList) null, 24);
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:".concat("1800 120130")));
            startActivity(intent);
        }
    }
}
