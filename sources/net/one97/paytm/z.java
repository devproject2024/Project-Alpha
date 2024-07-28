package net.one97.paytm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.Events;

public final class z extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f52631a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f52632b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f52633c;

    private View a(int i2) {
        if (this.f52633c == null) {
            this.f52633c = new HashMap();
        }
        View view = (View) this.f52633c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f52633c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getTheme() {
        return R.style.ProfileBottomSheetDialogTheme;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        return layoutInflater.inflate(R.layout.layout_scan_settings_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((Button) a(R.id.proceedBtn)).setOnClickListener(new a(this));
        ((Button) a(R.id.cancelBtn)).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f52634a;

        a(z zVar) {
            this.f52634a = zVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.r.a aVar;
            this.f52634a.f52632b = true;
            FragmentActivity activity = this.f52634a.getActivity();
            if (!(activity instanceof AJRScanSettingsActivity)) {
                activity = null;
            }
            AJRScanSettingsActivity aJRScanSettingsActivity = (AJRScanSettingsActivity) activity;
            if (!(aJRScanSettingsActivity == null || (aVar = aJRScanSettingsActivity.f51731a) == null)) {
                aVar.a(true);
            }
            net.one97.paytm.j.a.a((Context) this.f52634a.getActivity(), "allow_remote_desktop_apps", Events.Action.PROCEED_CLICKED, "", "", "", "");
            this.f52634a.dismiss();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f52635a;

        b(z zVar) {
            this.f52635a = zVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.r.a aVar;
            this.f52635a.f52631a = true;
            FragmentActivity activity = this.f52635a.getActivity();
            if (!(activity instanceof AJRScanSettingsActivity)) {
                activity = null;
            }
            AJRScanSettingsActivity aJRScanSettingsActivity = (AJRScanSettingsActivity) activity;
            if (!(aJRScanSettingsActivity == null || (aVar = aJRScanSettingsActivity.f51731a) == null)) {
                aVar.a(false);
            }
            net.one97.paytm.j.a.a((Context) this.f52635a.getActivity(), "allow_remote_desktop_apps", "popup_cancel_clicked", "", "", "", "");
            this.f52635a.dismiss();
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        if (!this.f52632b && !this.f52631a) {
            net.one97.paytm.j.a.a((Context) getActivity(), "allow_remote_desktop_apps", "popup_closed", "", "", "", "");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f52633c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
