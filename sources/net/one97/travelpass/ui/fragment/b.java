package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.travelpass.R;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f30688a;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.travel_pass_details_quantity, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        a.b((Context) getActivity());
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f30688a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
