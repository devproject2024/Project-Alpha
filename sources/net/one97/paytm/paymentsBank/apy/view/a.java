package net.one97.paytm.paymentsBank.apy.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f17421a;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_atal_pension_intro, (ViewGroup) null);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17421a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
