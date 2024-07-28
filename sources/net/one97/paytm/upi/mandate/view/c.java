package net.one97.paytm.upi.mandate.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.UpiWebViewActivity;

public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f67513a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f67514b;

    /* renamed from: c  reason: collision with root package name */
    private View f67515c;

    /* renamed from: d  reason: collision with root package name */
    private View f67516d;

    /* renamed from: e  reason: collision with root package name */
    private View f67517e;

    /* renamed from: f  reason: collision with root package name */
    private View f67518f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f67519g;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_mandate_know_more, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.ivClose);
        k.a((Object) findViewById, "view.findViewById(R.id.ivClose)");
        this.f67513a = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tvHowItWorks);
        k.a((Object) findViewById2, "view.findViewById(R.id.tvHowItWorks)");
        this.f67514b = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.row1);
        k.a((Object) findViewById3, "view.findViewById(R.id.row1)");
        this.f67515c = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.row2);
        k.a((Object) findViewById4, "view.findViewById(R.id.row2)");
        this.f67516d = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.row3);
        k.a((Object) findViewById5, "view.findViewById(R.id.row3)");
        this.f67517e = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.row4);
        k.a((Object) findViewById6, "view.findViewById(R.id.row4)");
        this.f67518f = findViewById6;
        View view = this.f67515c;
        if (view == null) {
            k.a("row1");
        }
        TextView textView = (TextView) view.findViewById(R.id.tvTitle);
        k.a((Object) textView, "row1Title");
        textView.setText(getString(R.string.upi_mandate_know_more1));
        View view2 = this.f67516d;
        if (view2 == null) {
            k.a("row2");
        }
        TextView textView2 = (TextView) view2.findViewById(R.id.tvTitle);
        k.a((Object) textView2, "row2Title");
        textView2.setText(getString(R.string.upi_mandate_know_more2));
        View view3 = this.f67517e;
        if (view3 == null) {
            k.a("row3");
        }
        TextView textView3 = (TextView) view3.findViewById(R.id.tvTitle);
        k.a((Object) textView3, "row3Title");
        textView3.setText(getString(R.string.upi_mandate_know_more3));
        View view4 = this.f67518f;
        if (view4 == null) {
            k.a("row4");
        }
        TextView textView4 = (TextView) view4.findViewById(R.id.tvTitle);
        k.a((Object) textView4, "row4Title");
        textView4.setText(getString(R.string.upi_mandate_know_more4));
        TextView textView5 = this.f67514b;
        if (textView5 == null) {
            k.a("tvHowItWorks");
        }
        textView5.setOnClickListener(new b(this));
        ImageView imageView = this.f67513a;
        if (imageView == null) {
            k.a("ivClose");
        }
        imageView.setOnClickListener(new C1373c(this));
        TextView textView6 = this.f67514b;
        if (textView6 == null) {
            k.a("tvHowItWorks");
        }
        net.one97.paytm.upi.f.a((View) textView6);
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67521a;

        b(c cVar) {
            this.f67521a = cVar;
        }

        public final void onClick(View view) {
            UpiWebViewActivity.Companion companion = UpiWebViewActivity.Companion;
            FragmentActivity activity = this.f67521a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            companion.startActivity(activity, "https://paytm.com/offer/know-how-to-schedule-upi-payments", Boolean.TRUE);
        }
    }

    /* renamed from: net.one97.paytm.upi.mandate.view.c$c  reason: collision with other inner class name */
    static final class C1373c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67522a;

        C1373c(c cVar) {
            this.f67522a = cVar;
        }

        public final void onClick(View view) {
            this.f67522a.dismissAllowingStateLoss();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(a.f67520a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f67520a = new a();

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

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f67519g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
