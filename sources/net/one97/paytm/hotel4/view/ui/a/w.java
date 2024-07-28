package net.one97.paytm.hotel4.view.ui.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FilterValuesItem;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.FiltersItem;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterItemViewModel;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.b.es;
import net.one97.paytm.hotels2.b.eu;
import net.one97.paytm.i.h;

public final class w extends h {

    /* renamed from: a  reason: collision with root package name */
    public es f29016a;

    /* renamed from: b  reason: collision with root package name */
    public SharedViewModel f29017b;

    /* renamed from: c  reason: collision with root package name */
    public SRPFilterViewModel f29018c;

    /* renamed from: d  reason: collision with root package name */
    net.one97.paytm.hotel4.view.a.d f29019d;

    /* renamed from: e  reason: collision with root package name */
    net.one97.paytm.hotel4.view.a.d f29020e;

    static final class a<T> implements z<o<? extends String, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f29021a;

        a(w wVar) {
            this.f29021a = wVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            w wVar = this.f29021a;
            k.a((Object) oVar, "data");
            w.a(wVar, oVar);
        }
    }

    static final class c<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f29023a;

        c(w wVar) {
            this.f29023a = wVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            w wVar = this.f29023a;
            k.a((Object) str, "data");
            k.c(str, "data");
            if (str.equals("Show More")) {
                net.one97.paytm.hotel4.view.a.d dVar = wVar.f29019d;
                if (dVar != null) {
                    SRPFilterViewModel sRPFilterViewModel = wVar.f29018c;
                    if (sRPFilterViewModel == null) {
                        k.a("viewModel");
                    }
                    dVar.a(sRPFilterViewModel.getAmenitiesFilterdata().subList(0, 6));
                    return;
                }
                return;
            }
            net.one97.paytm.hotel4.view.a.d dVar2 = wVar.f29019d;
            if (dVar2 != null) {
                SRPFilterViewModel sRPFilterViewModel2 = wVar.f29018c;
                if (sRPFilterViewModel2 == null) {
                    k.a("viewModel");
                }
                dVar2.a(sRPFilterViewModel2.getAmenitiesFilterdata());
            }
        }
    }

    static final class d<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f29024a;

        d(w wVar) {
            this.f29024a = wVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            w wVar = this.f29024a;
            k.a((Object) str, "data");
            k.c(str, "data");
            if (str.equals("Show More")) {
                net.one97.paytm.hotel4.view.a.d dVar = wVar.f29020e;
                if (dVar != null) {
                    SRPFilterViewModel sRPFilterViewModel = wVar.f29018c;
                    if (sRPFilterViewModel == null) {
                        k.a("viewModel");
                    }
                    dVar.a(sRPFilterViewModel.getHotelTypeFilterdata().subList(0, 6));
                    return;
                }
                return;
            }
            net.one97.paytm.hotel4.view.a.d dVar2 = wVar.f29020e;
            if (dVar2 != null) {
                SRPFilterViewModel sRPFilterViewModel2 = wVar.f29018c;
                if (sRPFilterViewModel2 == null) {
                    k.a("viewModel");
                }
                dVar2.a(sRPFilterViewModel2.getHotelTypeFilterdata());
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        es a2 = es.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4SrpFilterLayoutBinding…flater, container, false)");
        this.f29016a = a2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a3 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f29017b = (SharedViewModel) a3;
            SharedViewModel sharedViewModel = this.f29017b;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a4 = am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(SRPFilterViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…terViewModel::class.java)");
            this.f29018c = (SRPFilterViewModel) a4;
            SRPFilterViewModel sRPFilterViewModel = this.f29018c;
            if (sRPFilterViewModel == null) {
                k.a("viewModel");
            }
            SharedViewModel sharedViewModel2 = this.f29017b;
            if (sharedViewModel2 == null) {
                k.a("sharedViewModel");
            }
            sRPFilterViewModel.setFilterItemList(sharedViewModel2.getSRPFilters());
            SRPFilterViewModel sRPFilterViewModel2 = this.f29018c;
            if (sRPFilterViewModel2 == null) {
                k.a("viewModel");
            }
            sRPFilterViewModel2.initSelectedFilter();
        }
        es esVar = this.f29016a;
        if (esVar == null) {
            k.a("dataBinding");
        }
        SRPFilterViewModel sRPFilterViewModel3 = this.f29018c;
        if (sRPFilterViewModel3 == null) {
            k.a("viewModel");
        }
        esVar.a(sRPFilterViewModel3);
        es esVar2 = this.f29016a;
        if (esVar2 == null) {
            k.a("dataBinding");
        }
        esVar2.setLifecycleOwner(this);
        a();
        SRPFilterViewModel sRPFilterViewModel4 = this.f29018c;
        if (sRPFilterViewModel4 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel4.initSelectedFilter();
        SRPFilterViewModel sRPFilterViewModel5 = this.f29018c;
        if (sRPFilterViewModel5 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel5.updateFilterCount();
        es esVar3 = this.f29016a;
        if (esVar3 == null) {
            k.a("dataBinding");
        }
        return esVar3.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        SRPFilterViewModel sRPFilterViewModel = this.f29018c;
        if (sRPFilterViewModel == null) {
            k.a("viewModel");
        }
        q qVar = this;
        sRPFilterViewModel.getFilterRecyclerViewItemClick().observe(qVar, new a(this));
        SRPFilterViewModel sRPFilterViewModel2 = this.f29018c;
        if (sRPFilterViewModel2 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel2.getClearAllClicked().observe(qVar, new b(this));
        SRPFilterViewModel sRPFilterViewModel3 = this.f29018c;
        if (sRPFilterViewModel3 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel3.getAmenitiesShowMoreLessText().observe(qVar, new c(this));
        SRPFilterViewModel sRPFilterViewModel4 = this.f29018c;
        if (sRPFilterViewModel4 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel4.getHotelTypeShowMoreLessText().observe(qVar, new d(this));
    }

    private final void a() {
        SRPFilterViewModel sRPFilterViewModel = this.f29018c;
        if (sRPFilterViewModel == null) {
            k.a("viewModel");
        }
        if (sRPFilterViewModel.getFilterItemList() != null) {
            SRPFilterViewModel sRPFilterViewModel2 = this.f29018c;
            if (sRPFilterViewModel2 == null) {
                k.a("viewModel");
            }
            List<FiltersItem> filterItemList = sRPFilterViewModel2.getFilterItemList();
            if (filterItemList == null) {
                k.a();
            }
            for (FiltersItem filtersItem : filterItemList) {
                if (!(filtersItem == null || filtersItem.getFilterParam() == null)) {
                    String filterParam = filtersItem.getFilterParam();
                    String str = null;
                    switch (filterParam.hashCode()) {
                        case -1986480784:
                            if (filterParam.equals("starCategory")) {
                                SRPFilterViewModel sRPFilterViewModel3 = this.f29018c;
                                if (sRPFilterViewModel3 == null) {
                                    k.a("viewModel");
                                }
                                sRPFilterViewModel3.setFilterStartRatingTitle(filtersItem.getTitle());
                                if (filtersItem.getValues() != null && filtersItem.getValues().size() > 0) {
                                    SRPFilterViewModel sRPFilterViewModel4 = this.f29018c;
                                    if (sRPFilterViewModel4 == null) {
                                        k.a("viewModel");
                                    }
                                    b(sRPFilterViewModel4.getFilterValues(filtersItem.getValues().toString()));
                                    SRPFilterViewModel sRPFilterViewModel5 = this.f29018c;
                                    if (sRPFilterViewModel5 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel5.getStartRaitingsVisibility().setValue(Boolean.TRUE);
                                    break;
                                } else {
                                    SRPFilterViewModel sRPFilterViewModel6 = this.f29018c;
                                    if (sRPFilterViewModel6 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel6.getStartRaitingsVisibility().setValue(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                        case -1475740300:
                            if (filterParam.equals("priceRange")) {
                                SRPFilterViewModel sRPFilterViewModel7 = this.f29018c;
                                if (sRPFilterViewModel7 == null) {
                                    k.a("viewModel");
                                }
                                sRPFilterViewModel7.setFilterPriceRangeTitle(filtersItem.getTitle());
                                if (filtersItem.getValues() != null && filtersItem.getValues().size() > 0) {
                                    com.google.gsonhtcfix.o oVar = filtersItem.getValues().get(0);
                                    SRPFilterViewModel sRPFilterViewModel8 = this.f29018c;
                                    if (sRPFilterViewModel8 == null) {
                                        k.a("viewModel");
                                    }
                                    a(sRPFilterViewModel8.getFilterValues(oVar.c("priceRange").toString()));
                                    break;
                                }
                            } else {
                                break;
                            }
                        case -1029380188:
                            if (filterParam.equals("propertyTypes")) {
                                if (filtersItem.getValues() != null && filtersItem.getValues().size() > 0) {
                                    SRPFilterViewModel sRPFilterViewModel9 = this.f29018c;
                                    if (sRPFilterViewModel9 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel9.setFilterHotelTypeTitle(filtersItem.getTitle());
                                    SRPFilterViewModel sRPFilterViewModel10 = this.f29018c;
                                    if (sRPFilterViewModel10 == null) {
                                        k.a("viewModel");
                                    }
                                    d(sRPFilterViewModel10.getFilterValues(filtersItem.getValues().toString()));
                                    SRPFilterViewModel sRPFilterViewModel11 = this.f29018c;
                                    if (sRPFilterViewModel11 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel11.getPropertyTypeVisibility().setValue(Boolean.TRUE);
                                    break;
                                } else {
                                    SRPFilterViewModel sRPFilterViewModel12 = this.f29018c;
                                    if (sRPFilterViewModel12 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel12.getPropertyTypeVisibility().setValue(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                        case 94623425:
                            if (filterParam.equals("chain")) {
                                if (filtersItem.getValues() != null && filtersItem.getValues().size() > 0) {
                                    SRPFilterViewModel sRPFilterViewModel13 = this.f29018c;
                                    if (sRPFilterViewModel13 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel13.setFilterHotelChainTitle(filtersItem.getTitle());
                                    SharedViewModel sharedViewModel = this.f29017b;
                                    if (sharedViewModel == null) {
                                        k.a("sharedViewModel");
                                    }
                                    List<com.google.gsonhtcfix.o> values = filtersItem.getValues();
                                    if (values != null) {
                                        str = values.toString();
                                    }
                                    sharedViewModel.setFilterHotelChainString(str);
                                    SRPFilterViewModel sRPFilterViewModel14 = this.f29018c;
                                    if (sRPFilterViewModel14 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel14.getHotelChainVisibility().setValue(Boolean.TRUE);
                                    break;
                                } else {
                                    SRPFilterViewModel sRPFilterViewModel15 = this.f29018c;
                                    if (sRPFilterViewModel15 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel15.setFilterHotelChainTitle("");
                                    SRPFilterViewModel sRPFilterViewModel16 = this.f29018c;
                                    if (sRPFilterViewModel16 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel16.getHotelChainVisibility().setValue(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case 110844025:
                            if (filterParam.equals("types")) {
                                if (filtersItem.getValues() != null && filtersItem.getValues().size() > 0) {
                                    SRPFilterViewModel sRPFilterViewModel17 = this.f29018c;
                                    if (sRPFilterViewModel17 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel17.setFilterHotelThemeTitle(filtersItem.getTitle());
                                    SharedViewModel sharedViewModel2 = this.f29017b;
                                    if (sharedViewModel2 == null) {
                                        k.a("sharedViewModel");
                                    }
                                    List<com.google.gsonhtcfix.o> values2 = filtersItem.getValues();
                                    if (values2 != null) {
                                        str = values2.toString();
                                    }
                                    sharedViewModel2.setFilterHotelThemeString(str);
                                    SRPFilterViewModel sRPFilterViewModel18 = this.f29018c;
                                    if (sRPFilterViewModel18 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel18.getHoteThemeVisibility().setValue(Boolean.TRUE);
                                    break;
                                } else {
                                    SRPFilterViewModel sRPFilterViewModel19 = this.f29018c;
                                    if (sRPFilterViewModel19 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel19.setFilterHotelThemeTitle("");
                                    SRPFilterViewModel sRPFilterViewModel20 = this.f29018c;
                                    if (sRPFilterViewModel20 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel20.getHoteThemeVisibility().setValue(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case 156669207:
                            if (filterParam.equals("amenities")) {
                                SRPFilterViewModel sRPFilterViewModel21 = this.f29018c;
                                if (sRPFilterViewModel21 == null) {
                                    k.a("viewModel");
                                }
                                sRPFilterViewModel21.setFilterAmenitiesTitle(filtersItem.getTitle());
                                if (filtersItem.getValues() != null && filtersItem.getValues().size() > 0) {
                                    SRPFilterViewModel sRPFilterViewModel22 = this.f29018c;
                                    if (sRPFilterViewModel22 == null) {
                                        k.a("viewModel");
                                    }
                                    c(sRPFilterViewModel22.getFilterValues(filtersItem.getValues().toString()));
                                    SRPFilterViewModel sRPFilterViewModel23 = this.f29018c;
                                    if (sRPFilterViewModel23 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel23.getAmenitiesVisibility().setValue(Boolean.TRUE);
                                    break;
                                } else {
                                    SRPFilterViewModel sRPFilterViewModel24 = this.f29018c;
                                    if (sRPFilterViewModel24 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel24.getAmenitiesVisibility().setValue(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                        case 1312948545:
                            if (filterParam.equals("localities")) {
                                if (filtersItem.getValues() != null && filtersItem.getValues().size() > 0) {
                                    SRPFilterViewModel sRPFilterViewModel25 = this.f29018c;
                                    if (sRPFilterViewModel25 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel25.setFilterLocalityTitle(filtersItem.getTitle());
                                    SharedViewModel sharedViewModel3 = this.f29017b;
                                    if (sharedViewModel3 == null) {
                                        k.a("sharedViewModel");
                                    }
                                    List<com.google.gsonhtcfix.o> values3 = filtersItem.getValues();
                                    if (values3 != null) {
                                        str = values3.toString();
                                    }
                                    sharedViewModel3.setFilterLocalityString(str);
                                    SRPFilterViewModel sRPFilterViewModel26 = this.f29018c;
                                    if (sRPFilterViewModel26 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel26.getHoteLocalityVisibility().setValue(Boolean.TRUE);
                                    break;
                                } else {
                                    SRPFilterViewModel sRPFilterViewModel27 = this.f29018c;
                                    if (sRPFilterViewModel27 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel27.setFilterLocalityTitle("");
                                    SRPFilterViewModel sRPFilterViewModel28 = this.f29018c;
                                    if (sRPFilterViewModel28 == null) {
                                        k.a("viewModel");
                                    }
                                    sRPFilterViewModel28.getHoteLocalityVisibility().setValue(Boolean.FALSE);
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                    }
                }
            }
        }
    }

    private final void a(ArrayList<FilterValuesItem> arrayList) {
        es esVar = this.f29016a;
        if (esVar == null) {
            k.a("dataBinding");
        }
        esVar.f29650g.f29177a.removeAllViews();
        int i2 = 0;
        if (arrayList == null) {
            k.a();
        }
        for (FilterValuesItem filterValuesItem : arrayList) {
            SRPFilterViewModel sRPFilterViewModel = this.f29018c;
            if (sRPFilterViewModel == null) {
                k.a("viewModel");
            }
            SRPFilterItemViewModel sRPFilterItemViewModel = new SRPFilterItemViewModel(sRPFilterViewModel);
            eu a2 = eu.a(getLayoutInflater());
            k.a((Object) a2, "H4SrpFilterPriceRangeLis…outInflater, null, false)");
            sRPFilterItemViewModel.setItemData(filterValuesItem, "priceRange", i2);
            a2.a(sRPFilterItemViewModel);
            a2.setLifecycleOwner(this);
            es esVar2 = this.f29016a;
            if (esVar2 == null) {
                k.a("dataBinding");
            }
            esVar2.f29650g.f29177a.addView(a2.getRoot());
            i2++;
        }
    }

    private final void b(ArrayList<FilterValuesItem> arrayList) {
        String str;
        String str2;
        String str3;
        String str4;
        Iterator<FilterValuesItem> it2 = arrayList.iterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (it2.hasNext()) {
            FilterValuesItem next = it2.next();
            String str5 = null;
            if (next != null) {
                str = next.getId();
            } else {
                str = null;
            }
            if (!p.a(str, "1", false)) {
                if (next != null) {
                    str2 = next.getId();
                } else {
                    str2 = null;
                }
                if (!p.a(str2, "2", false)) {
                    if (next != null) {
                        str3 = next.getId();
                    } else {
                        str3 = null;
                    }
                    if (!p.a(str3, "3", false)) {
                        if (next != null) {
                            str4 = next.getId();
                        } else {
                            str4 = null;
                        }
                        if (!p.a(str4, "4", false)) {
                            if (next != null) {
                                str5 = next.getId();
                            }
                            if (!p.a(str5, "5", false)) {
                            }
                        }
                        if (next == null) {
                            k.a();
                        }
                        if (next.getApplied()) {
                            z3 = true;
                            z4 = true;
                        } else {
                            z3 = true;
                        }
                    }
                }
            }
            if (next == null) {
                k.a();
            }
            if (next.getApplied()) {
                z = true;
                z2 = true;
            } else {
                z = true;
            }
        }
        es esVar = this.f29016a;
        if (esVar == null) {
            k.a("dataBinding");
        }
        esVar.f29651h.f29177a.removeAllViews();
        if (z) {
            FilterValuesItem filterValuesItem = new FilterValuesItem(false, (String) null, (String) null, 7, (g) null);
            filterValuesItem.setName("Below 3 Stars");
            filterValuesItem.setId("3");
            filterValuesItem.setApplied(z2);
            SRPFilterViewModel sRPFilterViewModel = this.f29018c;
            if (sRPFilterViewModel == null) {
                k.a("viewModel");
            }
            SRPFilterItemViewModel sRPFilterItemViewModel = new SRPFilterItemViewModel(sRPFilterViewModel);
            eu a2 = eu.a(getLayoutInflater());
            k.a((Object) a2, "H4SrpFilterPriceRangeLis…outInflater, null, false)");
            sRPFilterItemViewModel.setItemData(filterValuesItem, "starCategory", 0);
            a2.a(sRPFilterItemViewModel);
            a2.setLifecycleOwner(this);
            es esVar2 = this.f29016a;
            if (esVar2 == null) {
                k.a("dataBinding");
            }
            esVar2.f29651h.f29177a.addView(a2.getRoot());
        }
        if (z3) {
            FilterValuesItem filterValuesItem2 = new FilterValuesItem(false, (String) null, (String) null, 7, (g) null);
            filterValuesItem2.setName("Above 3 Stars");
            filterValuesItem2.setId("5");
            filterValuesItem2.setApplied(z4);
            SRPFilterViewModel sRPFilterViewModel2 = this.f29018c;
            if (sRPFilterViewModel2 == null) {
                k.a("viewModel");
            }
            SRPFilterItemViewModel sRPFilterItemViewModel2 = new SRPFilterItemViewModel(sRPFilterViewModel2);
            eu a3 = eu.a(getLayoutInflater());
            k.a((Object) a3, "H4SrpFilterPriceRangeLis…outInflater, null, false)");
            sRPFilterItemViewModel2.setItemData(filterValuesItem2, "starCategory", 1);
            a3.a(sRPFilterItemViewModel2);
            a3.setLifecycleOwner(this);
            es esVar3 = this.f29016a;
            if (esVar3 == null) {
                k.a("dataBinding");
            }
            esVar3.f29651h.f29177a.addView(a3.getRoot());
        }
    }

    private final void c(ArrayList<FilterValuesItem> arrayList) {
        es esVar = this.f29016a;
        if (esVar == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = esVar.f29644a.f29131a;
        k.a((Object) recyclerView, "this.dataBinding.amenities.amenitiesList");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        SRPFilterViewModel sRPFilterViewModel = this.f29018c;
        if (sRPFilterViewModel == null) {
            k.a("viewModel");
        }
        this.f29019d = new net.one97.paytm.hotel4.view.a.d(sRPFilterViewModel, "amenities");
        recyclerView.setAdapter(this.f29019d);
        SRPFilterViewModel sRPFilterViewModel2 = this.f29018c;
        if (sRPFilterViewModel2 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel2.setAmenitiesFilterdata(arrayList);
        if ((arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue() > 6) {
            net.one97.paytm.hotel4.view.a.d dVar = this.f29019d;
            if (dVar != null) {
                dVar.a(arrayList.subList(0, 5));
            }
            SRPFilterViewModel sRPFilterViewModel3 = this.f29018c;
            if (sRPFilterViewModel3 == null) {
                k.a("viewModel");
            }
            sRPFilterViewModel3.getAmenitiesShowMoreLessText().setValue("Show More");
            return;
        }
        net.one97.paytm.hotel4.view.a.d dVar2 = this.f29019d;
        if (dVar2 != null) {
            dVar2.a(arrayList);
        }
        SRPFilterViewModel sRPFilterViewModel4 = this.f29018c;
        if (sRPFilterViewModel4 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel4.getAmenitiesShowMoreLessText().setValue("");
    }

    private final void d(ArrayList<FilterValuesItem> arrayList) {
        es esVar = this.f29016a;
        if (esVar == null) {
            k.a("dataBinding");
        }
        RecyclerView recyclerView = esVar.f29649f.f29131a;
        k.a((Object) recyclerView, "this.dataBinding.hotelsType.amenitiesList");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        SRPFilterViewModel sRPFilterViewModel = this.f29018c;
        if (sRPFilterViewModel == null) {
            k.a("viewModel");
        }
        this.f29020e = new net.one97.paytm.hotel4.view.a.d(sRPFilterViewModel, "propertyTypes");
        recyclerView.setAdapter(this.f29020e);
        SRPFilterViewModel sRPFilterViewModel2 = this.f29018c;
        if (sRPFilterViewModel2 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel2.setHotelTypeFilterdata(arrayList);
        if ((arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue() > 6) {
            net.one97.paytm.hotel4.view.a.d dVar = this.f29020e;
            if (dVar != null) {
                dVar.a(arrayList.subList(0, 5));
            }
            SRPFilterViewModel sRPFilterViewModel3 = this.f29018c;
            if (sRPFilterViewModel3 == null) {
                k.a("viewModel");
            }
            sRPFilterViewModel3.getHotelTypeShowMoreLessText().setValue("Show More");
            return;
        }
        net.one97.paytm.hotel4.view.a.d dVar2 = this.f29020e;
        if (dVar2 != null) {
            dVar2.a(arrayList);
        }
        SRPFilterViewModel sRPFilterViewModel4 = this.f29018c;
        if (sRPFilterViewModel4 == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel4.getHotelTypeShowMoreLessText().setValue("");
    }

    static final class b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f29022a;

        b(w wVar) {
            this.f29022a = wVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            w.a(this.f29022a);
        }
    }

    public static final /* synthetic */ void a(w wVar, o oVar) {
        net.one97.paytm.hotel4.view.a.d dVar;
        if (((String) oVar.getFirst()).equals("amenities")) {
            net.one97.paytm.hotel4.view.a.d dVar2 = wVar.f29019d;
            if (dVar2 != null) {
                dVar2.notifyItemChanged(((Number) oVar.getSecond()).intValue());
            }
        } else if (((String) oVar.getFirst()).equals("propertyTypes") && (dVar = wVar.f29020e) != null) {
            dVar.notifyItemChanged(((Number) oVar.getSecond()).intValue());
        }
    }

    public static final /* synthetic */ void a(w wVar) {
        wVar.a();
        SRPFilterViewModel sRPFilterViewModel = wVar.f29018c;
        if (sRPFilterViewModel == null) {
            k.a("viewModel");
        }
        sRPFilterViewModel.updateFilterCount();
    }
}
