package com.travel.citybus.best.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import com.travel.citybus.R;
import java.util.HashMap;
import kotlin.g.b.k;

public final class f extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f23106a;

    public final int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void onAttach(Context context) {
        Window window;
        WindowManager.LayoutParams attributes;
        k.c(context, "context");
        super.onAttach(context);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.style.BottomSheetDialogTheme;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_city_bus_how_to_buy, viewGroup, false);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f23107a;

        a(f fVar) {
            this.f23107a = fVar;
        }

        public final void onClick(View view) {
            this.f23107a.dismiss();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        int i2 = R.id.rechargeCloseIv;
        if (this.f23106a == null) {
            this.f23106a = new HashMap();
        }
        View view3 = (View) this.f23106a.get(Integer.valueOf(i2));
        if (view3 == null) {
            View view4 = getView();
            if (view4 == null) {
                view2 = null;
                ((AppCompatImageView) view2).setOnClickListener(new a(this));
            }
            view3 = view4.findViewById(i2);
            this.f23106a.put(Integer.valueOf(i2), view3);
        }
        view2 = view3;
        ((AppCompatImageView) view2).setOnClickListener(new a(this));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23106a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
