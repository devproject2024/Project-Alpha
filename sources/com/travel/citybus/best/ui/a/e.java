package com.travel.citybus.best.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.travel.citybus.R;
import com.travel.citybus.brts.utils.d;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;

public final class e extends g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f23104a;

    public final int getTheme() {
        return R.style.ToolTipDialogFragment;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.city_bus_e_purse_tool_tip_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        int i2 = R.id.ettGotItTv;
        if (this.f23104a == null) {
            this.f23104a = new HashMap();
        }
        View view3 = (View) this.f23104a.get(Integer.valueOf(i2));
        if (view3 == null) {
            View view4 = getView();
            if (view4 == null) {
                view2 = null;
                ((TextView) view2).setOnClickListener(new a(this));
            }
            view3 = view4.findViewById(i2);
            this.f23104a.put(Integer.valueOf(i2), view3);
        }
        view2 = view3;
        ((TextView) view2).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f23105a;

        a(e eVar) {
            this.f23105a = eVar;
        }

        public final void onClick(View view) {
            d.a aVar = d.f23400a;
            Context requireContext = this.f23105a.requireContext();
            k.a((Object) requireContext, "requireContext()");
            d.a.a(requireContext).a("e_purse_tt", true, false);
            this.f23105a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23104a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
