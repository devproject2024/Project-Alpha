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
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;

public final class i extends g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f23119a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f23120b;

    public interface a {
        void c();
    }

    public final int getTheme() {
        return R.style.ToolTipDialogFragment;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof a) {
            this.f23119a = (a) context;
        }
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
        View inflate = layoutInflater.inflate(R.layout.city_bus_otp_validation_tool_tip_layout, viewGroup, false);
        if (inflate != null) {
            inflate.findViewById(R.id.vttOtpCardView);
        }
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        int i2 = R.id.vttGotItTv;
        if (this.f23120b == null) {
            this.f23120b = new HashMap();
        }
        View view3 = (View) this.f23120b.get(Integer.valueOf(i2));
        if (view3 == null) {
            View view4 = getView();
            if (view4 == null) {
                view2 = null;
                ((TextView) view2).setOnClickListener(new b(this));
            }
            view3 = view4.findViewById(i2);
            this.f23120b.put(Integer.valueOf(i2), view3);
        }
        view2 = view3;
        ((TextView) view2).setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f23121a;

        b(i iVar) {
            this.f23121a = iVar;
        }

        public final void onClick(View view) {
            a a2 = this.f23121a.f23119a;
            if (a2 != null) {
                a2.c();
            }
            this.f23121a.dismiss();
        }
    }

    public final void onDetach() {
        this.f23119a = null;
        super.onDetach();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23120b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
