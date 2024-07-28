package net.one97.paytm.common.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;

public final class c extends com.google.android.material.bottomsheet.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.common.widgets.a.a f49881a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Boolean f49882b = Boolean.FALSE;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f49883c;

    private View a(int i2) {
        if (this.f49883c == null) {
            this.f49883c = new HashMap();
        }
        View view = (View) this.f49883c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f49883c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f49885a;

        b(c cVar) {
            this.f49885a = cVar;
        }

        public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
            net.one97.paytm.common.widgets.a.a a2 = this.f49885a.f49881a;
            if (a2 != null) {
                a2.a(f2);
            }
            this.f49885a.f49882b = Boolean.TRUE;
        }
    }

    /* renamed from: net.one97.paytm.common.widgets.c$c  reason: collision with other inner class name */
    static final class C0885c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f49886a;

        C0885c(c cVar) {
            this.f49886a = cVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.common.widgets.a.a a2 = this.f49886a.f49881a;
            if (a2 != null) {
                a2.a();
            }
            this.f49886a.f49882b = Boolean.TRUE;
        }
    }

    public static final class a implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f49884a;

        a(c cVar) {
            this.f49884a = cVar;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            k.c(dialogInterface, "dialog");
            k.c(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (i2 == 4) {
                Boolean b2 = this.f49884a.f49882b;
                if (b2 == null) {
                    k.a();
                }
                if (!b2.booleanValue()) {
                    net.one97.paytm.common.widgets.a.a a2 = this.f49884a.f49881a;
                    if (a2 != null) {
                        a2.a();
                    }
                    return true;
                }
            }
            if (i2 != 3) {
                return false;
            }
            Boolean b3 = this.f49884a.f49882b;
            if (b3 == null) {
                k.a();
            }
            if (b3.booleanValue()) {
                return false;
            }
            net.one97.paytm.common.widgets.a.a a3 = this.f49884a.f49881a;
            if (a3 != null) {
                a3.a();
            }
            return true;
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        net.one97.paytm.common.widgets.a.a aVar = this.f49881a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(net.one97.paytm.common.widgets.a.a aVar) {
        k.c(aVar, "appRatingListener");
        this.f49881a = aVar;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
    }

    public final void onAttachFragment(Fragment fragment) {
        k.c(fragment, "childFragment");
        super.onAttachFragment(fragment);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return View.inflate(getContext(), R.layout.lyt_app_store_rating, viewGroup);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        TextView textView = (TextView) a(R.id.tv_msg);
        k.a((Object) textView, "tv_msg");
        textView.setText(getString(R.string.enjoying_paytm));
        TextView textView2 = (TextView) a(R.id.tv_sub_msg);
        k.a((Object) textView2, "tv_sub_msg");
        textView2.setVisibility(0);
        View a2 = a(R.id.ratingBar);
        if (a2 != null) {
            ((RatingBar) a2).setOnRatingBarChangeListener(new b(this));
            ((ImageView) a(R.id.iv_close_icon)).setOnClickListener(new C0885c(this));
            setCancelable(false);
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.setOnKeyListener(new a(this));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.RatingBar");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f49883c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
