package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.view.a.h;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotels2.b.ba;

public final class z extends ab {

    /* renamed from: a  reason: collision with root package name */
    private DataViewModel f29039a;

    /* renamed from: b  reason: collision with root package name */
    private ba f29040b;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a2 = am.a(activity).a(DataViewModel.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…ataViewModel::class.java]");
        this.f29039a = (DataViewModel) a2;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ba a2 = ba.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4FragmentShowDataBindin…flater, container, false)");
        this.f29040b = a2;
        ba baVar = this.f29040b;
        if (baVar == null) {
            k.a("fragmentShowDataBinding");
        }
        return baVar.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ba baVar = this.f29040b;
        if (baVar == null) {
            k.a("fragmentShowDataBinding");
        }
        DataViewModel dataViewModel = this.f29039a;
        if (dataViewModel == null) {
            k.a("dataViewModel");
        }
        baVar.a(dataViewModel);
        DataViewModel dataViewModel2 = this.f29039a;
        if (dataViewModel2 == null) {
            k.a("dataViewModel");
        }
        if (dataViewModel2.getShowRecyclerViewList()) {
            DataViewModel dataViewModel3 = this.f29039a;
            if (dataViewModel3 == null) {
                k.a("dataViewModel");
            }
            boolean z = !dataViewModel3.getShouldHideBlueDot();
            DataViewModel dataViewModel4 = this.f29039a;
            if (dataViewModel4 == null) {
                k.a("dataViewModel");
            }
            h hVar = new h(z, dataViewModel4.isHtmlText());
            ba baVar2 = this.f29040b;
            if (baVar2 == null) {
                k.a("fragmentShowDataBinding");
            }
            RecyclerView recyclerView = baVar2.f29222c;
            k.a((Object) recyclerView, "fragmentShowDataBinding.rvPolicy");
            recyclerView.setAdapter(hVar);
            DataViewModel dataViewModel5 = this.f29039a;
            if (dataViewModel5 == null) {
                k.a("dataViewModel");
            }
            hVar.a(dataViewModel5.getRecyclerListData().getValue());
            hVar.notifyDataSetChanged();
        }
    }
}
