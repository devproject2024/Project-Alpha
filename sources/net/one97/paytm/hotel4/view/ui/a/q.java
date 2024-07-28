package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.view.a.k;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.bs;

public final class q extends ab {

    /* renamed from: a  reason: collision with root package name */
    public bs f28939a;

    /* renamed from: b  reason: collision with root package name */
    public k f28940b;

    /* renamed from: c  reason: collision with root package name */
    public DataViewModel f28941c;

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) window, "dialog?.window!!");
        window.getAttributes().windowAnimations = R.style.H4BottomSheet;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(DataViewModel.class);
            kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(it…ataViewModel::class.java)");
            this.f28941c = (DataViewModel) a2;
        }
        bs a3 = bs.a(layoutInflater, viewGroup);
        kotlin.g.b.k.a((Object) a3, "H4ImageTextBottomSheetBi…flater, container, false)");
        this.f28939a = a3;
        bs bsVar = this.f28939a;
        if (bsVar == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        bsVar.setLifecycleOwner(this);
        bs bsVar2 = this.f28939a;
        if (bsVar2 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        TextView textView = bsVar2.f29293d;
        kotlin.g.b.k.a((Object) textView, "this.dataBinding.tvTitle");
        DataViewModel dataViewModel = this.f28941c;
        if (dataViewModel == null) {
            kotlin.g.b.k.a("dataViewModel");
        }
        textView.setText(dataViewModel.getTitle());
        this.f28940b = new k();
        bs bsVar3 = this.f28939a;
        if (bsVar3 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        RecyclerView recyclerView = bsVar3.f29292c;
        kotlin.g.b.k.a((Object) recyclerView, "this.dataBinding.rvAmenities");
        k kVar = this.f28940b;
        if (kVar == null) {
            kotlin.g.b.k.a("amenitiesAdapter");
        }
        recyclerView.setAdapter(kVar);
        k kVar2 = this.f28940b;
        if (kVar2 == null) {
            kotlin.g.b.k.a("amenitiesAdapter");
        }
        DataViewModel dataViewModel2 = this.f28941c;
        if (dataViewModel2 == null) {
            kotlin.g.b.k.a("dataViewModel");
        }
        kVar2.a(dataViewModel2.getRecyclerListData().getValue());
        bs bsVar4 = this.f28939a;
        if (bsVar4 == null) {
            kotlin.g.b.k.a("dataBinding");
        }
        return bsVar4.getRoot();
    }
}
