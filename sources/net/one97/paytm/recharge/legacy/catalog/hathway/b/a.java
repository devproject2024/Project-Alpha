package net.one97.paytm.recharge.legacy.catalog.hathway.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.io.Serializable;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;

@Deprecated
public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private static String f62974a = "key_list";

    /* renamed from: b  reason: collision with root package name */
    private List<CJRPlanExpiryDetails> f62975b;

    public static a a(List<CJRPlanExpiryDetails> list) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f62974a, (Serializable) list);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f62975b = (List) getArguments().getSerializable(f62974a);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_on_group_selection_list, viewGroup, false);
        net.one97.paytm.recharge.legacy.catalog.hathway.a.a aVar = new net.one97.paytm.recharge.legacy.catalog.hathway.a.a(this.f62975b, getActivity());
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.stations_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(aVar);
        recyclerView.addItemDecoration(new i(getContext(), 1));
        return inflate;
    }
}
