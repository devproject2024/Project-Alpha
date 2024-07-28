package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FilterValuesItem;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterLocalityAndHotelChainViewModel;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.am;

public final class j extends ab {

    /* renamed from: a  reason: collision with root package name */
    public am f28866a;

    /* renamed from: b  reason: collision with root package name */
    public SRPFilterViewModel f28867b;

    /* renamed from: c  reason: collision with root package name */
    public SRPFilterLocalityAndHotelChainViewModel f28868c;

    /* renamed from: d  reason: collision with root package name */
    public SharedViewModel f28869d;

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.hotel4.view.a.c f28870e;

    static final class a<T> implements z<o<? extends String, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f28871a;

        a(j jVar) {
            this.f28871a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            j jVar = this.f28871a;
            k.a((Object) oVar, "data");
            k.c(oVar, "data");
            int i2 = -1;
            if (((Number) oVar.getSecond()).intValue() == -1) {
                net.one97.paytm.hotel4.view.a.c cVar = jVar.f28870e;
                if (cVar == null) {
                    k.a("adapter");
                }
                SRPFilterViewModel sRPFilterViewModel = jVar.f28867b;
                if (sRPFilterViewModel == null) {
                    k.a("srpFilterViewModel");
                }
                SharedViewModel sharedViewModel = jVar.f28869d;
                if (sharedViewModel == null) {
                    k.a("sharedViewModel");
                }
                cVar.a(sRPFilterViewModel.getFilterValues(sharedViewModel.getFilterLocalityString()));
                return;
            }
            String str = (String) oVar.getFirst();
            k.c(str, "id");
            net.one97.paytm.hotel4.view.a.c cVar2 = jVar.f28870e;
            if (cVar2 == null) {
                k.a("adapter");
            }
            List a2 = cVar2.a();
            k.a((Object) a2, "adapter.currentList");
            int i3 = 0;
            Iterator it2 = a2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String id = ((FilterValuesItem) it2.next()).getId();
                if (id == null) {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                } else if (p.a(p.b(id).toString(), p.b(str).toString(), true)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                net.one97.paytm.hotel4.view.a.c cVar3 = jVar.f28870e;
                if (cVar3 == null) {
                    k.a("adapter");
                }
                cVar3.notifyItemChanged(i2);
            }
        }
    }

    static final class c<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f28873a;

        c(j jVar) {
            this.f28873a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            j jVar = this.f28873a;
            k.a((Object) str, "data");
            k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            if (TextUtils.isEmpty(str)) {
                net.one97.paytm.hotel4.view.a.c cVar = jVar.f28870e;
                if (cVar == null) {
                    k.a("adapter");
                }
                SRPFilterViewModel sRPFilterViewModel = jVar.f28867b;
                if (sRPFilterViewModel == null) {
                    k.a("srpFilterViewModel");
                }
                SharedViewModel sharedViewModel = jVar.f28869d;
                if (sharedViewModel == null) {
                    k.a("sharedViewModel");
                }
                cVar.a(sRPFilterViewModel.getFilterValues(sharedViewModel.getFilterLocalityString()));
                return;
            }
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = jVar.f28868c;
            if (sRPFilterLocalityAndHotelChainViewModel == null) {
                k.a("viewModel");
            }
            SRPFilterViewModel sRPFilterViewModel2 = jVar.f28867b;
            if (sRPFilterViewModel2 == null) {
                k.a("srpFilterViewModel");
            }
            SharedViewModel sharedViewModel2 = jVar.f28869d;
            if (sharedViewModel2 == null) {
                k.a("sharedViewModel");
            }
            ArrayList<FilterValuesItem> filteredList = sRPFilterLocalityAndHotelChainViewModel.getFilteredList(sRPFilterViewModel2.getFilterValues(sharedViewModel2.getFilterLocalityString()), str);
            net.one97.paytm.hotel4.view.a.c cVar2 = jVar.f28870e;
            if (cVar2 == null) {
                k.a("adapter");
            }
            cVar2.a(filteredList);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = androidx.lifecycle.am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28869d = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28869d;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a3 = androidx.lifecycle.am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(SRPFilterViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…terViewModel::class.java)");
            this.f28867b = (SRPFilterViewModel) a3;
            SRPFilterViewModel sRPFilterViewModel = this.f28867b;
            if (sRPFilterViewModel == null) {
                k.a("srpFilterViewModel");
            }
            this.f28868c = new SRPFilterLocalityAndHotelChainViewModel(sRPFilterViewModel, "localities");
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.f28868c;
            if (sRPFilterLocalityAndHotelChainViewModel == null) {
                k.a("viewModel");
            }
            String string = getString(R.string.h4_filter_by_locality);
            k.a((Object) string, "getString(R.string.h4_filter_by_locality)");
            sRPFilterLocalityAndHotelChainViewModel.setTitle(string);
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel2 = this.f28868c;
            if (sRPFilterLocalityAndHotelChainViewModel2 == null) {
                k.a("viewModel");
            }
            String string2 = getString(R.string.h4_search_for_nearby);
            k.a((Object) string2, "getString(R.string.h4_search_for_nearby)");
            sRPFilterLocalityAndHotelChainViewModel2.setHint(string2);
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel3 = this.f28868c;
            if (sRPFilterLocalityAndHotelChainViewModel3 == null) {
                k.a("viewModel");
            }
            sRPFilterLocalityAndHotelChainViewModel3.setImageId(R.drawable.h4_ic_locality);
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
        am a2 = am.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4FilterLocalityHotelCha…flater, container, false)");
        this.f28866a = a2;
        am amVar = this.f28866a;
        if (amVar == null) {
            k.a("dataBinding");
        }
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.f28868c;
        if (sRPFilterLocalityAndHotelChainViewModel == null) {
            k.a("viewModel");
        }
        amVar.a(sRPFilterLocalityAndHotelChainViewModel);
        am amVar2 = this.f28866a;
        if (amVar2 == null) {
            k.a("dataBinding");
        }
        amVar2.setLifecycleOwner(this);
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel2 = this.f28868c;
        if (sRPFilterLocalityAndHotelChainViewModel2 == null) {
            k.a("viewModel");
        }
        this.f28870e = new net.one97.paytm.hotel4.view.a.c(sRPFilterLocalityAndHotelChainViewModel2, "localities");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        am amVar3 = this.f28866a;
        if (amVar3 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = amVar3.f29161d;
        k.a((Object) recyclerView, "this.dataBinding.filterList");
        recyclerView.setLayoutManager(linearLayoutManager);
        am amVar4 = this.f28866a;
        if (amVar4 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView2 = amVar4.f29161d;
        k.a((Object) recyclerView2, "this.dataBinding.filterList");
        net.one97.paytm.hotel4.view.a.c cVar = this.f28870e;
        if (cVar == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(cVar);
        net.one97.paytm.hotel4.view.a.c cVar2 = this.f28870e;
        if (cVar2 == null) {
            k.a("adapter");
        }
        SRPFilterViewModel sRPFilterViewModel = this.f28867b;
        if (sRPFilterViewModel == null) {
            k.a("srpFilterViewModel");
        }
        SharedViewModel sharedViewModel = this.f28869d;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        cVar2.a(sRPFilterViewModel.getFilterValues(sharedViewModel.getFilterLocalityString()));
        am amVar5 = this.f28866a;
        if (amVar5 == null) {
            k.a("dataBinding");
        }
        return amVar5.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.f28868c;
        if (sRPFilterLocalityAndHotelChainViewModel == null) {
            k.a("viewModel");
        }
        q qVar = this;
        sRPFilterLocalityAndHotelChainViewModel.getFilterRecyclerViewItemClick().observe(qVar, new a(this));
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel2 = this.f28868c;
        if (sRPFilterLocalityAndHotelChainViewModel2 == null) {
            k.a("viewModel");
        }
        sRPFilterLocalityAndHotelChainViewModel2.getFilterSaveClicked().observe(qVar, new b(this));
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel3 = this.f28868c;
        if (sRPFilterLocalityAndHotelChainViewModel3 == null) {
            k.a("viewModel");
        }
        sRPFilterLocalityAndHotelChainViewModel3.getAutoSearchEevent().observe(qVar, new c(this));
    }

    static final class b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f28872a;

        b(j jVar) {
            this.f28872a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f28872a.dismiss();
        }
    }
}
