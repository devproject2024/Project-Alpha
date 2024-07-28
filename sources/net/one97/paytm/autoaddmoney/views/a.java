package net.one97.paytm.autoaddmoney.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.i.f;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.autoaddmoney.c.b f49319a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f49320b;

    private View a(int i2) {
        if (this.f49320b == null) {
            this.f49320b = new HashMap();
        }
        View view = (View) this.f49320b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f49320b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ net.one97.paytm.autoaddmoney.c.b a(a aVar) {
        net.one97.paytm.autoaddmoney.c.b bVar = aVar.f49319a;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(net.one97.paytm.autoaddmoney.c.b.class);
            k.a((Object) a2, "ViewModelProviders.of(it…entViewModel::class.java)");
            this.f49319a = (net.one97.paytm.autoaddmoney.c.b) a2;
        }
        return layoutInflater.inflate(R.layout.layout_generic_bs, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) a(R.id.header_tv)).setText(getString(R.string.automatic_add_money));
        ((TextView) a(R.id.tv_desc)).setText(getString(R.string.deactivated_text));
        ((TextView) a(R.id.btn_ok)).setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f49322a;

        b(a aVar) {
            this.f49322a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f49322a).k.setValue(new net.one97.paytm.autoaddmoney.a(Boolean.TRUE));
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(C0875a.f49321a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    /* renamed from: net.one97.paytm.autoaddmoney.views.a$a  reason: collision with other inner class name */
    static final class C0875a implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C0875a f49321a = new C0875a();

        C0875a() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                aVar.setCancelable(false);
                View findViewById = aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById != null) {
                    FrameLayout frameLayout = (FrameLayout) findViewById;
                    if (frameLayout != null) {
                        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                        k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                        from.setState(3);
                        from.setPeekHeight(500);
                        from.setHideable(true);
                        from.setSkipCollapsed(false);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f49320b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
