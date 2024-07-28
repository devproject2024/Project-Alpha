package net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.a;

public final class c extends f implements a.C0287a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17841a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private e f17842b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f17843c;

    public final void a(int i2, String str, String str2) {
        k.c(str, "type");
        k.c(str2, "name");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            View findViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
            if (findViewById != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheetInternal)");
                Resources system = Resources.getSystem();
                k.a((Object) system, "Resources.getSystem()");
                from.setPeekHeight(system.getDisplayMetrics().heightPixels);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = getLayoutInflater().inflate(net.one97.paytm.paymentsBank.R.layout.fragment_sheet_item_selection, viewGroup, false);
        a(inflate);
        k.a((Object) inflate, "view");
        ((RoboTextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.retry)).setOnClickListener(new b(this, inflate));
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f17844a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f17845b;

        b(c cVar, View view) {
            this.f17844a = cVar;
            this.f17845b = view;
        }

        public final void onClick(View view) {
            this.f17844a.a(this.f17845b);
        }
    }

    public final int getTheme() {
        return net.one97.paytm.paymentsBank.R.style.BottomSheetDialogTheme;
    }

    /* access modifiers changed from: private */
    public final void a(View view) {
        if (view == null) {
            k.a();
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(net.one97.paytm.paymentsBank.R.id.contentView);
        k.a((Object) relativeLayout, "view!!.contentView");
        relativeLayout.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(net.one97.paytm.paymentsBank.R.id.errorView);
        k.a((Object) linearLayout, "view!!.errorView");
        linearLayout.setVisibility(8);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(net.one97.paytm.paymentsBank.R.id.cb_dot_progress_bar);
        k.a((Object) lottieAnimationView, "view!!.cb_dot_progress_bar");
        a(lottieAnimationView);
        if (this.f17842b == null) {
            k.a();
        }
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17843c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
