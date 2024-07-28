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

public final class h extends ab {

    /* renamed from: a  reason: collision with root package name */
    public am f28850a;

    /* renamed from: b  reason: collision with root package name */
    public SRPFilterViewModel f28851b;

    /* renamed from: c  reason: collision with root package name */
    public SRPFilterLocalityAndHotelChainViewModel f28852c;

    /* renamed from: d  reason: collision with root package name */
    public SharedViewModel f28853d;

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.hotel4.view.a.c f28854e;

    static final class a<T> implements z<o<? extends String, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f28855a;

        a(h hVar) {
            this.f28855a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            h hVar = this.f28855a;
            k.a((Object) oVar, "data");
            k.c(oVar, "data");
            int i2 = -1;
            if (((Number) oVar.getSecond()).intValue() == -1) {
                net.one97.paytm.hotel4.view.a.c cVar = hVar.f28854e;
                if (cVar == null) {
                    k.a("adapter");
                }
                SRPFilterViewModel sRPFilterViewModel = hVar.f28851b;
                if (sRPFilterViewModel == null) {
                    k.a("srpFilterViewModel");
                }
                SharedViewModel sharedViewModel = hVar.f28853d;
                if (sharedViewModel == null) {
                    k.a("sharedViewModel");
                }
                cVar.a(sRPFilterViewModel.getFilterValues(sharedViewModel.getFilterHotelChainString()));
                return;
            }
            String str = (String) oVar.getFirst();
            k.c(str, "id");
            net.one97.paytm.hotel4.view.a.c cVar2 = hVar.f28854e;
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
                net.one97.paytm.hotel4.view.a.c cVar3 = hVar.f28854e;
                if (cVar3 == null) {
                    k.a("adapter");
                }
                cVar3.notifyItemChanged(i2);
            }
        }
    }

    static final class c<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f28857a;

        c(h hVar) {
            this.f28857a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            h hVar = this.f28857a;
            k.a((Object) str, "data");
            k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            if (TextUtils.isEmpty(str)) {
                net.one97.paytm.hotel4.view.a.c cVar = hVar.f28854e;
                if (cVar == null) {
                    k.a("adapter");
                }
                SRPFilterViewModel sRPFilterViewModel = hVar.f28851b;
                if (sRPFilterViewModel == null) {
                    k.a("srpFilterViewModel");
                }
                SharedViewModel sharedViewModel = hVar.f28853d;
                if (sharedViewModel == null) {
                    k.a("sharedViewModel");
                }
                cVar.a(sRPFilterViewModel.getFilterValues(sharedViewModel.getFilterHotelChainString()));
                return;
            }
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = hVar.f28852c;
            if (sRPFilterLocalityAndHotelChainViewModel == null) {
                k.a("viewModel");
            }
            SRPFilterViewModel sRPFilterViewModel2 = hVar.f28851b;
            if (sRPFilterViewModel2 == null) {
                k.a("srpFilterViewModel");
            }
            SharedViewModel sharedViewModel2 = hVar.f28853d;
            if (sharedViewModel2 == null) {
                k.a("sharedViewModel");
            }
            ArrayList<FilterValuesItem> filteredList = sRPFilterLocalityAndHotelChainViewModel.getFilteredList(sRPFilterViewModel2.getFilterValues(sharedViewModel2.getFilterHotelChainString()), str);
            net.one97.paytm.hotel4.view.a.c cVar2 = hVar.f28854e;
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
            this.f28853d = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28853d;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a3 = androidx.lifecycle.am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(SRPFilterViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…terViewModel::class.java)");
            this.f28851b = (SRPFilterViewModel) a3;
            SRPFilterViewModel sRPFilterViewModel = this.f28851b;
            if (sRPFilterViewModel == null) {
                k.a("srpFilterViewModel");
            }
            this.f28852c = new SRPFilterLocalityAndHotelChainViewModel(sRPFilterViewModel, "chain");
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.f28852c;
            if (sRPFilterLocalityAndHotelChainViewModel == null) {
                k.a("viewModel");
            }
            String string = getString(R.string.h4_filter_by_hotel_chain);
            k.a((Object) string, "getString(R.string.h4_filter_by_hotel_chain)");
            sRPFilterLocalityAndHotelChainViewModel.setTitle(string);
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel2 = this.f28852c;
            if (sRPFilterLocalityAndHotelChainViewModel2 == null) {
                k.a("viewModel");
            }
            String string2 = getString(R.string.h4_search_for_hotel_chain);
            k.a((Object) string2, "getString(R.string.h4_search_for_hotel_chain)");
            sRPFilterLocalityAndHotelChainViewModel2.setHint(string2);
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel3 = this.f28852c;
            if (sRPFilterLocalityAndHotelChainViewModel3 == null) {
                k.a("viewModel");
            }
            sRPFilterLocalityAndHotelChainViewModel3.setImageId(R.drawable.h4_ic_noimg_icon);
            SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel4 = this.f28852c;
            if (sRPFilterLocalityAndHotelChainViewModel4 == null) {
                k.a("viewModel");
            }
            sRPFilterLocalityAndHotelChainViewModel4.initFilterStatus();
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
        this.f28850a = a2;
        am amVar = this.f28850a;
        if (amVar == null) {
            k.a("dataBinding");
        }
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.f28852c;
        if (sRPFilterLocalityAndHotelChainViewModel == null) {
            k.a("viewModel");
        }
        amVar.a(sRPFilterLocalityAndHotelChainViewModel);
        am amVar2 = this.f28850a;
        if (amVar2 == null) {
            k.a("dataBinding");
        }
        amVar2.setLifecycleOwner(this);
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel2 = this.f28852c;
        if (sRPFilterLocalityAndHotelChainViewModel2 == null) {
            k.a("viewModel");
        }
        this.f28854e = new net.one97.paytm.hotel4.view.a.c(sRPFilterLocalityAndHotelChainViewModel2, "chain");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        am amVar3 = this.f28850a;
        if (amVar3 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = amVar3.f29161d;
        k.a((Object) recyclerView, "this.dataBinding.filterList");
        recyclerView.setLayoutManager(linearLayoutManager);
        am amVar4 = this.f28850a;
        if (amVar4 == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView2 = amVar4.f29161d;
        k.a((Object) recyclerView2, "this.dataBinding.filterList");
        net.one97.paytm.hotel4.view.a.c cVar = this.f28854e;
        if (cVar == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(cVar);
        net.one97.paytm.hotel4.view.a.c cVar2 = this.f28854e;
        if (cVar2 == null) {
            k.a("adapter");
        }
        SRPFilterViewModel sRPFilterViewModel = this.f28851b;
        if (sRPFilterViewModel == null) {
            k.a("srpFilterViewModel");
        }
        SharedViewModel sharedViewModel = this.f28853d;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        cVar2.a(sRPFilterViewModel.getFilterValues(sharedViewModel.getFilterHotelChainString()));
        am amVar5 = this.f28850a;
        if (amVar5 == null) {
            k.a("dataBinding");
        }
        return amVar5.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel = this.f28852c;
        if (sRPFilterLocalityAndHotelChainViewModel == null) {
            k.a("viewModel");
        }
        q qVar = this;
        sRPFilterLocalityAndHotelChainViewModel.getFilterRecyclerViewItemClick().observe(qVar, new a(this));
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel2 = this.f28852c;
        if (sRPFilterLocalityAndHotelChainViewModel2 == null) {
            k.a("viewModel");
        }
        sRPFilterLocalityAndHotelChainViewModel2.getFilterSaveClicked().observe(qVar, new b(this));
        SRPFilterLocalityAndHotelChainViewModel sRPFilterLocalityAndHotelChainViewModel3 = this.f28852c;
        if (sRPFilterLocalityAndHotelChainViewModel3 == null) {
            k.a("viewModel");
        }
        sRPFilterLocalityAndHotelChainViewModel3.getAutoSearchEevent().observe(qVar, new c(this));
    }

    static final class b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f28856a;

        b(h hVar) {
            this.f28856a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f28856a.dismiss();
        }
    }
}
