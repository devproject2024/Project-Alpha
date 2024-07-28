package net.one97.paytm.recharge.presentation.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.automatic.R;

public final class j extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f64791a;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_unable_to_proceed, viewGroup, false);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64791a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
