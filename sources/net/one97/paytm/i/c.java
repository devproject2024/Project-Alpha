package net.one97.paytm.i;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.paytm_finance.R;

public final class c extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.r.a f50554a;

    /* renamed from: b  reason: collision with root package name */
    private AppCompatTextView f50555b;

    /* renamed from: c  reason: collision with root package name */
    private AppCompatTextView f50556c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CoordinatorLayout f50557d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f50558e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f50559f;

    /* renamed from: g  reason: collision with root package name */
    private View f50560g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f50561h;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.f50554a = activity != null ? (net.one97.paytm.r.a) am.a(activity).a(net.one97.paytm.r.a.class) : null;
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        ViewParent viewParent = null;
        this.f50560g = View.inflate(getContext(), R.layout.layout_remote_apps_risk_sheet, (ViewGroup) null);
        View view = this.f50560g;
        if (view == null) {
            k.a();
        }
        dialog.setContentView(view);
        try {
            View view2 = this.f50560g;
            this.f50555b = view2 != null ? (AppCompatTextView) view2.findViewById(R.id.tv_cancel) : null;
            View view3 = this.f50560g;
            this.f50556c = view3 != null ? (AppCompatTextView) view3.findViewById(R.id.tv_understand_risk) : null;
            AppCompatTextView appCompatTextView = this.f50555b;
            if (appCompatTextView != null) {
                appCompatTextView.setOnClickListener(new a(this));
            }
            AppCompatTextView appCompatTextView2 = this.f50556c;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setOnClickListener(new b(this));
            }
        } catch (Exception unused) {
        }
        Context context = getContext();
        if (context != null) {
            int c2 = androidx.core.content.b.c(context, 17170445);
            View view4 = this.f50560g;
            if (view4 != null) {
                viewParent = view4.getParent();
            }
            if (viewParent != null) {
                ((View) viewParent).setBackgroundColor(c2);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50562a;

        a(c cVar) {
            this.f50562a = cVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.r.a a2 = this.f50562a.f50554a;
            if (a2 != null) {
                a2.a(false);
            }
            this.f50562a.dismiss();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50563a;

        b(c cVar) {
            this.f50563a = cVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.r.a a2 = this.f50563a.f50554a;
            if (a2 != null) {
                a2.a(true);
            }
            this.f50563a.dismiss();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(new C0914c(this));
        onCreateDialog.setOnKeyListener(new d(this));
        return onCreateDialog;
    }

    /* renamed from: net.one97.paytm.i.c$c  reason: collision with other inner class name */
    static final class C0914c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50564a;

        C0914c(c cVar) {
            this.f50564a = cVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                this.f50564a.f50557d = (CoordinatorLayout) aVar.findViewById(R.id.coordinator);
                this.f50564a.f50558e = (FrameLayout) aVar.findViewById(R.id.design_bottom_sheet);
                FrameLayout b2 = this.f50564a.f50558e;
                if (b2 != null) {
                    this.f50564a.f50559f = BottomSheetBehavior.from(b2);
                    BottomSheetBehavior c2 = this.f50564a.f50559f;
                    if (c2 != null) {
                        c2.setState(3);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    static final class d implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f50565a;

        d(c cVar) {
            this.f50565a = cVar;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 == 4 && this.f50565a.isAdded()) {
                net.one97.paytm.r.a a2 = this.f50565a.f50554a;
                if (a2 != null) {
                    a2.a(false);
                }
                this.f50565a.dismiss();
            }
            return false;
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        net.one97.paytm.r.a aVar = this.f50554a;
        if (aVar != null) {
            aVar.a(false);
        }
        super.onCancel(dialogInterface);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f50561h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
