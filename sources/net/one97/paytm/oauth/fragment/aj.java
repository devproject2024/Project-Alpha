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
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class aj extends u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private HashMap f56344b;

    public final View a(int i2) {
        if (this.f56344b == null) {
            this.f56344b = new HashMap();
        }
        View view = (View) this.f56344b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56344b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56344b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogStyle);
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56345a = new a();

        a() {
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
            dialog.setOnShowListener(a.f56345a);
        }
        return layoutInflater.inflate(R.layout.fragment_bottomsheet_forgot_passcode, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_title);
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.lbl_not_have_card));
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_description);
        if (roboTextView2 != null) {
            roboTextView2.setText(getString(R.string.lbl_forgot_card_description));
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnCall);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismissAllowingStateLoss();
            return;
        }
        int i3 = R.id.btnCall;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:".concat("1800 120130")));
            startActivity(intent);
        }
    }
}
