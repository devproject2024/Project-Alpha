package net.one97.paytm.recharge.creditcard.v4.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class c extends com.google.android.material.bottomsheet.b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f62574a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public final void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            View view = null;
            if ((dialog != null ? dialog.getWindow() : null) != null && Build.VERSION.SDK_INT >= 26) {
                Dialog dialog2 = getDialog();
                Window window = dialog2 != null ? dialog2.getWindow() : null;
                if (window != null) {
                    view = window.getDecorView();
                }
                if (view != null) {
                    view.setSystemUiVisibility(view.getSystemUiVisibility() | 16);
                }
            }
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        q a2 = jVar.a();
        k.a((Object) a2, "manager.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(a.f62575a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f62575a = new a();

        a() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62576a;

        b(c cVar) {
            this.f62576a = cVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f62576a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.clearFlags(2);
        }
        new Handler().postDelayed(new b(this), 300);
        return layoutInflater.inflate(R.layout.v4_bill_reminder_activated_dialog_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        try {
            Context context = getContext();
            if (context != null) {
                k.a((Object) context, "it");
                d.a(new d(context), "onus_credit_card", "sms_consent_confirmation_shown", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        } catch (Throwable unused) {
        }
        View.OnClickListener onClickListener = this;
        ((ImageView) view.findViewById(R.id.closeIV)).setOnClickListener(onClickListener);
        ((TextView) view.findViewById(R.id.gotItBT)).setOnClickListener(onClickListener);
        View findViewById = view.findViewById(R.id.billReminderDescTV);
        k.a((Object) findViewById, "view.findViewById<TextVi…(R.id.billReminderDescTV)");
        ((TextView) findViewById).setText(getString(R.string.bill_reminder_activated_desc, com.paytm.utility.b.l(getContext())));
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.closeIV;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            return;
        }
        int i3 = R.id.gotItBT;
        if (valueOf != null && valueOf.intValue() == i3) {
            try {
                Context context = getContext();
                if (context != null) {
                    k.a((Object) context, "it");
                    d.a(new d(context), "onus_credit_card", "sms_consent_got_it_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                }
            } catch (Throwable unused) {
            }
            dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f62574a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
