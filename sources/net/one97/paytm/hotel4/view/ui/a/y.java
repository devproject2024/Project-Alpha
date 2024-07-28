package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.view.a.u;
import net.one97.paytm.hotel4.viewmodel.SRPSortViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.fa;

public final class y extends ab {

    /* renamed from: a  reason: collision with root package name */
    public fa f29034a;

    /* renamed from: b  reason: collision with root package name */
    public SRPSortViewModel f29035b;

    /* renamed from: c  reason: collision with root package name */
    public u f29036c;

    /* renamed from: d  reason: collision with root package name */
    public SharedViewModel f29037d;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f29037d = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f29037d;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a3 = am.a((Fragment) this, (al.b) new ViewModelFactory(sharedViewModel)).a(SRPSortViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(th…ortViewModel::class.java)");
            this.f29035b = (SRPSortViewModel) a3;
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window == null) {
            k.a();
        }
        k.a((Object) window, "dialog?.window!!");
        window.getAttributes().windowAnimations = R.style.H4BottomSheet;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        fa a2 = fa.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4SrpSortViewBinding.inf…flater, container, false)");
        this.f29034a = a2;
        fa faVar = this.f29034a;
        if (faVar == null) {
            k.a("dataBinding");
        }
        SRPSortViewModel sRPSortViewModel = this.f29035b;
        if (sRPSortViewModel == null) {
            k.a("viewModel");
        }
        faVar.a(sRPSortViewModel);
        SRPSortViewModel sRPSortViewModel2 = this.f29035b;
        if (sRPSortViewModel2 == null) {
            k.a("viewModel");
        }
        this.f29036c = new u(sRPSortViewModel2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        fa faVar2 = this.f29034a;
        if (faVar2 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = faVar2.f29681b;
        k.a((Object) recyclerView, "this.dataBinding.recyclerviewSort");
        recyclerView.setLayoutManager(linearLayoutManager);
        fa faVar3 = this.f29034a;
        if (faVar3 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView2 = faVar3.f29681b;
        k.a((Object) recyclerView2, "this.dataBinding.recyclerviewSort");
        u uVar = this.f29036c;
        if (uVar == null) {
            k.a("sortListItemAdapter");
        }
        recyclerView2.setAdapter(uVar);
        u uVar2 = this.f29036c;
        if (uVar2 == null) {
            k.a("sortListItemAdapter");
        }
        SharedViewModel sharedViewModel = this.f29037d;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        uVar2.a(sharedViewModel.getSRPSortData());
        fa faVar4 = this.f29034a;
        if (faVar4 == null) {
            k.a("dataBinding");
        }
        return faVar4.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        SRPSortViewModel sRPSortViewModel = this.f29035b;
        if (sRPSortViewModel == null) {
            k.a("viewModel");
        }
        sRPSortViewModel.getCloseButtonClickListener().observe(this, new a(this));
    }

    static final class a<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f29038a;

        a(y yVar) {
            this.f29038a = yVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f29038a.dismiss();
        }
    }
}
