package com.travel.citybus.best.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.travel.citybus.R;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;

public final class g extends f {

    /* renamed from: a  reason: collision with root package name */
    private Float f23108a = Float.valueOf(0.0f);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f23109b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f23110c;

    public interface a {
        void d();
    }

    private View a(int i2) {
        if (this.f23110c == null) {
            this.f23110c = new HashMap();
        }
        View view = (View) this.f23110c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23110c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f23108a = arguments != null ? Float.valueOf(arguments.getFloat("extra_current_price")) : null;
    }

    public final void onAttach(Context context) {
        Window window;
        WindowManager.LayoutParams attributes;
        k.c(context, "context");
        super.onAttach(context);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.BottomSheetDialogTheme;
        }
        if (context instanceof a) {
            this.f23109b = (a) context;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_city_bus_recharge_bottom, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) a(R.id.rechargeLowBalanceTv);
        k.a((Object) textView, "rechargeLowBalanceTv");
        StringBuilder sb = new StringBuilder("Low Balance : ");
        Float f2 = this.f23108a;
        if (f2 == null) {
            k.a();
        }
        sb.append(com.travel.citybus.best.e.b.a(f2.floatValue()));
        textView.setText(sb.toString());
        ((RelativeLayout) a(R.id.rechargeWhatIsEPurseLl)).setOnClickListener(new b(this));
        ((TextView) a(R.id.rechargeEPurseTv)).setOnClickListener(new c(this));
        ((AppCompatImageView) a(R.id.rechargeCloseIv)).setOnClickListener(new d(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f23111a;

        b(g gVar) {
            this.f23111a = gVar;
        }

        public final void onClick(View view) {
            g.a(this.f23111a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f23112a;

        c(g gVar) {
            this.f23112a = gVar;
        }

        public final void onClick(View view) {
            a b2 = this.f23112a.f23109b;
            if (b2 != null) {
                b2.d();
            }
            this.f23112a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f23113a;

        d(g gVar) {
            this.f23113a = gVar;
        }

        public final void onClick(View view) {
            this.f23113a.dismiss();
        }
    }

    public final void onDetach() {
        this.f23109b = null;
        super.onDetach();
    }

    public static final /* synthetic */ void a(g gVar) {
        TextView textView = (TextView) gVar.a(R.id.rechargeEPurseInfoTv);
        k.a((Object) textView, "rechargeEPurseInfoTv");
        if (textView.getVisibility() == 8) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) gVar.a(R.id.imageView);
            k.a((Object) appCompatImageView, "imageView");
            appCompatImageView.setRotation(180.0f);
            TextView textView2 = (TextView) gVar.a(R.id.rechargeEPurseInfoTv);
            k.a((Object) textView2, "rechargeEPurseInfoTv");
            textView2.setVisibility(0);
            return;
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) gVar.a(R.id.imageView);
        k.a((Object) appCompatImageView2, "imageView");
        appCompatImageView2.setRotation(0.0f);
        TextView textView3 = (TextView) gVar.a(R.id.rechargeEPurseInfoTv);
        k.a((Object) textView3, "rechargeEPurseInfoTv");
        textView3.setVisibility(8);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23110c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
