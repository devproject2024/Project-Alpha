package com.travel.bus.busticket.busfilter.b;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemBoardDropCount;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemDictionary;
import com.travel.bus.pojo.busticket.CJRBusFilterContainer;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.i.h;

public final class b extends h implements TextWatcher, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f22063b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public com.travel.bus.busticket.busfilter.a.b f22064a;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f22065c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f22066d;

    /* renamed from: e  reason: collision with root package name */
    private Button f22067e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f22068f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f22069g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22070h;

    /* renamed from: i  reason: collision with root package name */
    private CJRBusFilterContainer f22071i;
    private CJRBusSearchItemDictionary j;
    private com.travel.bus.busticket.busfilter.b k;
    private CJRBusTicketFilters l;
    private ArrayList<CJRLocation> m;
    private HashMap<String, CJRBusSearchItemBoardDropCount> n;
    private int o = 1;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public String q;
    private String r;
    private ArrayList<CJRLocation> s = new ArrayList<>();
    /* access modifiers changed from: private */
    public int t = 1;
    private HashMap u;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    static final class c<T> implements z<List<? extends CJRLocation>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f22073a;

        c(b bVar) {
            this.f22073a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list.isEmpty()) {
                b.a(this.f22073a).setVisibility(0);
                b.b(this.f22073a).setVisibility(8);
            } else {
                b.a(this.f22073a).setVisibility(8);
                b.b(this.f22073a).setVisibility(0);
            }
            boolean a2 = b.a((ArrayList<CJRLocation>) new ArrayList(list));
            if (!a2) {
                a2 = b.a((ArrayList<CJRLocation>) new ArrayList(b.c(this.f22073a)));
            }
            b.d(this.f22073a).a(a2, this.f22073a.t);
        }
    }

    static final class d extends l implements kotlin.g.a.b<CJRLocation, Boolean> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRLocation) obj));
        }

        public final boolean invoke(CJRLocation cJRLocation) {
            k.c(cJRLocation, "it");
            return !cJRLocation.isFilterSelected();
        }
    }

    public static final /* synthetic */ TextView a(b bVar) {
        TextView textView = bVar.f22070h;
        if (textView == null) {
            k.a("mNoItemsFound");
        }
        return textView;
    }

    public static final /* synthetic */ RecyclerView b(b bVar) {
        RecyclerView recyclerView = bVar.f22065c;
        if (recyclerView == null) {
            k.a("mRecyclerViewBPDP");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ArrayList c(b bVar) {
        ArrayList<CJRLocation> arrayList = bVar.m;
        if (arrayList == null) {
            k.a("mAllLocationList");
        }
        return arrayList;
    }

    public static final /* synthetic */ com.travel.bus.busticket.busfilter.b d(b bVar) {
        com.travel.bus.busticket.busfilter.b bVar2 = bVar.k;
        if (bVar2 == null) {
            k.a("mBusFilterTabListener");
        }
        return bVar2;
    }

    public static final /* synthetic */ com.travel.bus.busticket.busfilter.a.b f(b bVar) {
        com.travel.bus.busticket.busfilter.a.b bVar2 = bVar.f22064a;
        if (bVar2 == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        return bVar2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.bus_b_p_d_p_filter_fragment, viewGroup, false);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            if (arguments.containsKey("intent_extra_bus_search_filter_items")) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                Serializable serializable = arguments2.getSerializable("intent_extra_bus_search_filter_items");
                if (serializable != null) {
                    this.l = (CJRBusTicketFilters) serializable;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
                }
            }
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                k.a();
            }
            this.o = arguments3.getInt("intent_extra_location_type", 1);
            Bundle arguments4 = getArguments();
            if (arguments4 == null) {
                k.a();
            }
            this.p = arguments4.getString("intent_extra_bus_start_city");
            Bundle arguments5 = getArguments();
            if (arguments5 == null) {
                k.a();
            }
            this.q = arguments5.getString("intent_extra_bus_dest_city");
            CJRBusFilterContainer d2 = com.travel.bus.busticket.i.d.a().d();
            k.a((Object) d2, "BusSearchDataUtilsSingle….getmBusFilterContainer()");
            this.f22071i = d2;
            CJRBusSearchItemDictionary e2 = com.travel.bus.busticket.i.d.a().e();
            k.a((Object) e2, "BusSearchDataUtilsSingle…e().getmBusDictionaries()");
            this.j = e2;
            if (this.o == 1) {
                CJRBusFilterContainer cJRBusFilterContainer = this.f22071i;
                if (cJRBusFilterContainer == null) {
                    k.a("mBusFilterContainer");
                }
                ArrayList<CJRLocation> boardingLocation = cJRBusFilterContainer.getBoardingLocation();
                k.a((Object) boardingLocation, "mBusFilterContainer.boardingLocation");
                this.m = boardingLocation;
                CJRBusSearchItemDictionary cJRBusSearchItemDictionary = this.j;
                if (cJRBusSearchItemDictionary == null) {
                    k.a("mBusSearchItemDictionary");
                }
                HashMap<String, CJRBusSearchItemBoardDropCount> boardingPoints = cJRBusSearchItemDictionary.getBoardingPoints();
                k.a((Object) boardingPoints, "mBusSearchItemDictionary.boardingPoints");
                this.n = boardingPoints;
            } else {
                CJRBusFilterContainer cJRBusFilterContainer2 = this.f22071i;
                if (cJRBusFilterContainer2 == null) {
                    k.a("mBusFilterContainer");
                }
                ArrayList<CJRLocation> droppingLocations = cJRBusFilterContainer2.getDroppingLocations();
                k.a((Object) droppingLocations, "mBusFilterContainer.droppingLocations");
                this.m = droppingLocations;
                CJRBusSearchItemDictionary cJRBusSearchItemDictionary2 = this.j;
                if (cJRBusSearchItemDictionary2 == null) {
                    k.a("mBusSearchItemDictionary");
                }
                HashMap<String, CJRBusSearchItemBoardDropCount> droppingPoints = cJRBusSearchItemDictionary2.getDroppingPoints();
                k.a((Object) droppingPoints, "mBusSearchItemDictionary.droppingPoints");
                this.n = droppingPoints;
            }
            String str = this.o == 1 ? "B.Pt" : "D.Pt";
            ArrayList<CJRLocation> arrayList = this.m;
            if (arrayList == null) {
                k.a("mAllLocationList");
            }
            Iterable<CJRLocation> iterable = arrayList;
            Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
            for (CJRLocation filterSelected : iterable) {
                filterSelected.setFilterSelected(false);
                arrayList2.add(x.f47997a);
            }
            CJRBusTicketFilters cJRBusTicketFilters = this.l;
            if (cJRBusTicketFilters == null) {
                k.a("mBusTicketFilters");
            }
            if (cJRBusTicketFilters.getBusTicketFilterItems().size() > 0) {
                CJRBusTicketFilters cJRBusTicketFilters2 = this.l;
                if (cJRBusTicketFilters2 == null) {
                    k.a("mBusTicketFilters");
                }
                ArrayList<CJRBusTicketFilterItem> busTicketFilterItems = cJRBusTicketFilters2.getBusTicketFilterItems();
                k.a((Object) busTicketFilterItems, "mBusTicketFilters.busTicketFilterItems");
                int size = busTicketFilterItems.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CJRBusTicketFilters cJRBusTicketFilters3 = this.l;
                    if (cJRBusTicketFilters3 == null) {
                        k.a("mBusTicketFilters");
                    }
                    CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters3.getBusTicketFilterItems().get(i2);
                    k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters.busTicketFilterItems[i]");
                    if (k.a((Object) cJRBusTicketFilterItem.getTitle(), (Object) str)) {
                        ArrayList<CJRLocation> arrayList3 = this.m;
                        if (arrayList3 == null) {
                            k.a("mAllLocationList");
                        }
                        int size2 = arrayList3.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            ArrayList<CJRLocation> arrayList4 = this.m;
                            if (arrayList4 == null) {
                                k.a("mAllLocationList");
                            }
                            CJRLocation cJRLocation = arrayList4.get(i3);
                            k.a((Object) cJRLocation, "mAllLocationList[j]");
                            String locationName = cJRLocation.getLocationName();
                            CJRBusTicketFilters cJRBusTicketFilters4 = this.l;
                            if (cJRBusTicketFilters4 == null) {
                                k.a("mBusTicketFilters");
                            }
                            CJRBusTicketFilterItem cJRBusTicketFilterItem2 = cJRBusTicketFilters4.getBusTicketFilterItems().get(i2);
                            k.a((Object) cJRBusTicketFilterItem2, "mBusTicketFilters.busTicketFilterItems[i]");
                            if (k.a((Object) locationName, (Object) cJRBusTicketFilterItem2.getDisplayValue())) {
                                ArrayList<CJRLocation> arrayList5 = this.m;
                                if (arrayList5 == null) {
                                    k.a("mAllLocationList");
                                }
                                CJRLocation cJRLocation2 = arrayList5.get(i3);
                                k.a((Object) cJRLocation2, "mAllLocationList[j]");
                                cJRLocation2.setFilterSelected(true);
                            }
                        }
                    }
                }
            }
        }
        k.a((Object) inflate, "view");
        View findViewById = inflate.findViewById(R.id.edit_search);
        k.a((Object) findViewById, "view.findViewById(R.id.edit_search)");
        this.f22068f = (EditText) findViewById;
        View findViewById2 = inflate.findViewById(R.id.btn_done);
        k.a((Object) findViewById2, "view.findViewById(R.id.btn_done)");
        this.f22067e = (Button) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.lyt_progress_bar);
        k.a((Object) findViewById3, "view.findViewById(R.id.lyt_progress_bar)");
        this.f22069g = (RelativeLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.rv_bpdp);
        k.a((Object) findViewById4, "view.findViewById(R.id.rv_bpdp)");
        this.f22065c = (RecyclerView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.noItemsFound);
        k.a((Object) findViewById5, "view.findViewById(R.id.noItemsFound)");
        this.f22070h = (TextView) findViewById5;
        if (this.o == 1) {
            this.t = 1;
            EditText editText = this.f22068f;
            if (editText == null) {
                k.a("mEditSearch");
            }
            editText.setHint(getResources().getString(R.string.search_boarding_points));
        } else {
            this.t = 4;
            EditText editText2 = this.f22068f;
            if (editText2 == null) {
                k.a("mEditSearch");
            }
            editText2.setHint(getResources().getString(R.string.search_drop_point));
        }
        EditText editText3 = this.f22068f;
        if (editText3 == null) {
            k.a("mEditSearch");
        }
        editText3.addTextChangedListener(this);
        Button button = this.f22067e;
        if (button == null) {
            k.a("mButtonDone");
        }
        button.setOnClickListener(this);
        return inflate;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.k = (com.travel.bus.busticket.busfilter.b) activity;
            ArrayList<CJRLocation> arrayList = this.m;
            if (arrayList == null) {
                k.a("mAllLocationList");
            }
            if (arrayList != null) {
                ArrayList<CJRLocation> arrayList2 = this.m;
                if (arrayList2 == null) {
                    k.a("mAllLocationList");
                }
                this.s = new ArrayList<>(c(arrayList2));
                com.travel.bus.busticket.busfilter.b bVar = this.k;
                if (bVar == null) {
                    k.a("mBusFilterTabListener");
                }
                bVar.a(a(this.s), this.t);
                Context activity2 = getActivity();
                ArrayList<CJRLocation> arrayList3 = this.s;
                int i2 = this.o;
                com.travel.bus.busticket.busfilter.e bVar2 = new C0435b(this);
                HashMap<String, CJRBusSearchItemBoardDropCount> hashMap = this.n;
                if (hashMap == null) {
                    k.a("mAllBPDPPoints");
                }
                this.f22064a = new com.travel.bus.busticket.busfilter.a.b(activity2, arrayList3, i2, bVar2, hashMap);
                this.f22066d = new LinearLayoutManager(getActivity());
                RecyclerView recyclerView = this.f22065c;
                if (recyclerView == null) {
                    k.a("mRecyclerViewBPDP");
                }
                LinearLayoutManager linearLayoutManager = this.f22066d;
                if (linearLayoutManager == null) {
                    k.a("mLinearLayoutManager");
                }
                recyclerView.setLayoutManager(linearLayoutManager);
                RecyclerView recyclerView2 = this.f22065c;
                if (recyclerView2 == null) {
                    k.a("mRecyclerViewBPDP");
                }
                com.travel.bus.busticket.busfilter.a.b bVar3 = this.f22064a;
                if (bVar3 == null) {
                    k.a("mBusFilterBPDPAdapter");
                }
                recyclerView2.setAdapter(bVar3);
            }
            com.travel.bus.busticket.busfilter.a.b bVar4 = this.f22064a;
            if (bVar4 == null) {
                k.a("mBusFilterBPDPAdapter");
            }
            bVar4.f22023b.observe(this, new c(this));
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.bus.busticket.busfilter.BusFilterTabListener");
    }

    /* renamed from: com.travel.bus.busticket.busfilter.b.b$b  reason: collision with other inner class name */
    public static final class C0435b implements com.travel.bus.busticket.busfilter.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f22072a;

        C0435b(b bVar) {
            this.f22072a = bVar;
        }

        public final void a(Object obj) {
            k.c(obj, "item");
            if (obj instanceof CJRLocation) {
                CJRLocation cJRLocation = (CJRLocation) obj;
                ArrayList arrayList = new ArrayList(b.f(this.f22072a).f22022a);
                b.c(this.f22072a).remove(cJRLocation);
                arrayList.remove(cJRLocation);
                cJRLocation.setFilterSelected(!cJRLocation.isFilterSelected());
                b.c(this.f22072a).add(cJRLocation);
                arrayList.add(cJRLocation);
                if (cJRLocation.isFilterSelected()) {
                    com.travel.bus.busticket.i.a.a(cJRLocation, this.f22072a.d(), this.f22072a.p, this.f22072a.q, this.f22072a.getActivity());
                    com.travel.bus.busticket.i.a.a(cJRLocation, this.f22072a.d(), (Context) this.f22072a.getActivity());
                }
                ArrayList arrayList2 = new ArrayList(b.c((ArrayList<CJRLocation>) arrayList));
                b.d(this.f22072a).a(b.a((ArrayList<CJRLocation>) b.c(this.f22072a)), this.f22072a.t);
                b.f(this.f22072a).a((ArrayList<CJRLocation>) arrayList2);
                b bVar = this.f22072a;
                bVar.a(bVar.d());
            }
        }
    }

    public final void a() {
        com.travel.bus.busticket.busfilter.a.b bVar = this.f22064a;
        if (bVar == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        ArrayList arrayList = new ArrayList(bVar.f22022a);
        Iterable<CJRLocation> iterable = arrayList;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (CJRLocation cJRLocation : iterable) {
            k.a((Object) cJRLocation, "it");
            cJRLocation.setFilterSelected(false);
            arrayList2.add(x.f47997a);
        }
        com.travel.bus.busticket.busfilter.a.b bVar2 = this.f22064a;
        if (bVar2 == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        bVar2.a((ArrayList<CJRLocation>) arrayList);
        com.travel.bus.busticket.busfilter.b bVar3 = this.k;
        if (bVar3 == null) {
            k.a("mBusFilterTabListener");
        }
        bVar3.a(false, this.t);
        a(d());
    }

    public final void b() {
        EditText editText = this.f22068f;
        if (editText == null) {
            k.a("mEditSearch");
        }
        com.travel.bus.busticket.busfilter.d.a(editText);
    }

    /* access modifiers changed from: private */
    public final int d() {
        com.travel.bus.busticket.busfilter.a.b bVar = this.f22064a;
        if (bVar == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        return bVar.f22024c;
    }

    private final List<CJRLocation> e() {
        com.travel.bus.busticket.busfilter.a.b bVar = this.f22064a;
        if (bVar == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        Collection arrayList = new ArrayList();
        for (Object next : bVar.f22022a) {
            if (((CJRLocation) next).isFilterSelected()) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void c() {
        com.travel.bus.busticket.busfilter.a.b bVar = this.f22064a;
        if (bVar == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        ArrayList arrayList = new ArrayList(bVar.f22022a);
        Iterable<CJRLocation> iterable = arrayList;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (CJRLocation cJRLocation : iterable) {
            k.a((Object) cJRLocation, "it");
            cJRLocation.setFilterSelected(false);
            arrayList2.add(x.f47997a);
        }
        com.travel.bus.busticket.busfilter.a.b bVar2 = this.f22064a;
        if (bVar2 == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        bVar2.a((ArrayList<CJRLocation>) arrayList);
        com.travel.bus.busticket.busfilter.b bVar3 = this.k;
        if (bVar3 == null) {
            k.a("mBusFilterTabListener");
        }
        bVar3.a(false, this.t);
        a(d());
    }

    public static boolean a(ArrayList<CJRLocation> arrayList) {
        int i2;
        k.c(arrayList, "checkList");
        Iterable<CJRLocation> iterable = arrayList;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            i2 = 0;
            for (CJRLocation isFilterSelected : iterable) {
                if (isFilterSelected.isFilterSelected() && (i2 = i2 + 1) < 0) {
                    kotlin.a.k.b();
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    static final class e extends l implements kotlin.g.a.b<CJRLocation, String> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        public final String invoke(CJRLocation cJRLocation) {
            k.c(cJRLocation, "it");
            return cJRLocation.getLocationName();
        }
    }

    /* access modifiers changed from: private */
    public static ArrayList<CJRLocation> c(ArrayList<CJRLocation> arrayList) {
        return new ArrayList<>(kotlin.a.k.a(arrayList, kotlin.b.a.a(d.INSTANCE, e.INSTANCE)));
    }

    public final void onClick(View view) {
        k.c(view, "v");
        if (view.getId() == R.id.btn_done) {
            b();
            a(d());
            CJRBusTicketFilters cJRBusTicketFilters = this.l;
            if (cJRBusTicketFilters == null) {
                k.a("mBusTicketFilters");
            }
            int size = cJRBusTicketFilters.getBusTicketFilterItems().size();
            CJRBusTicketFilters cJRBusTicketFilters2 = this.l;
            if (cJRBusTicketFilters2 == null) {
                k.a("mBusTicketFilters");
            }
            com.travel.bus.busticket.i.a.a(size, (List<CJRBusTicketFilterItem>) cJRBusTicketFilters2.getBusTicketFilterItems(), d(), (Context) getActivity());
            com.travel.bus.busticket.busfilter.b bVar = this.k;
            if (bVar == null) {
                k.a("mBusFilterTabListener");
            }
            bVar.a(0);
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        String str;
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                com.travel.bus.busticket.busfilter.a.b bVar = this.f22064a;
                if (bVar == null) {
                    k.a("mBusFilterBPDPAdapter");
                }
                bVar.getFilter().filter(charSequence.toString());
                str = charSequence.toString();
                this.r = str;
            }
        }
        TextView textView = this.f22070h;
        if (textView == null) {
            k.a("mNoItemsFound");
        }
        textView.setVisibility(8);
        RecyclerView recyclerView = this.f22065c;
        if (recyclerView == null) {
            k.a("mRecyclerViewBPDP");
        }
        recyclerView.setVisibility(0);
        ArrayList arrayList = new ArrayList(c(this.s));
        com.travel.bus.busticket.busfilter.a.b bVar2 = this.f22064a;
        if (bVar2 == null) {
            k.a("mBusFilterBPDPAdapter");
        }
        bVar2.a((ArrayList<CJRLocation>) arrayList);
        com.travel.bus.busticket.busfilter.b bVar3 = this.k;
        if (bVar3 == null) {
            k.a("mBusFilterTabListener");
        }
        bVar3.a(a((ArrayList<CJRLocation>) new ArrayList(arrayList)), this.t);
        str = String.valueOf(charSequence);
        this.r = str;
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        CJRBusTicketFilters cJRBusTicketFilters = this.l;
        if (cJRBusTicketFilters == null) {
            k.a("mBusTicketFilters");
        }
        if (cJRBusTicketFilters != null) {
            CJRBusTicketFilters cJRBusTicketFilters2 = this.l;
            if (cJRBusTicketFilters2 == null) {
                k.a("mBusTicketFilters");
            }
            if (cJRBusTicketFilters2.getBusTicketFilterItems() != null) {
                CJRBusTicketFilters cJRBusTicketFilters3 = this.l;
                if (cJRBusTicketFilters3 == null) {
                    k.a("mBusTicketFilters");
                }
                if (cJRBusTicketFilters3.getBusTicketFilterItems().size() > 0) {
                    CJRBusTicketFilters cJRBusTicketFilters4 = this.l;
                    if (cJRBusTicketFilters4 == null) {
                        k.a("mBusTicketFilters");
                    }
                    ArrayList arrayList = new ArrayList(cJRBusTicketFilters4.getBusTicketFilterItems());
                    CJRBusTicketFilters cJRBusTicketFilters5 = this.l;
                    if (cJRBusTicketFilters5 == null) {
                        k.a("mBusTicketFilters");
                    }
                    int size = cJRBusTicketFilters5.getBusTicketFilterItems().size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (i2 == 1) {
                            CJRBusTicketFilters cJRBusTicketFilters6 = this.l;
                            if (cJRBusTicketFilters6 == null) {
                                k.a("mBusTicketFilters");
                            }
                            CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters6.getBusTicketFilterItems().get(i3);
                            k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters.busTicketFilterItems[i]");
                            if (k.a((Object) cJRBusTicketFilterItem.getTitle(), (Object) "B.Pt")) {
                                CJRBusTicketFilters cJRBusTicketFilters7 = this.l;
                                if (cJRBusTicketFilters7 == null) {
                                    k.a("mBusTicketFilters");
                                }
                                arrayList.remove(cJRBusTicketFilters7.getBusTicketFilterItems().get(i3));
                            }
                        }
                        if (i2 == 2) {
                            CJRBusTicketFilters cJRBusTicketFilters8 = this.l;
                            if (cJRBusTicketFilters8 == null) {
                                k.a("mBusTicketFilters");
                            }
                            CJRBusTicketFilterItem cJRBusTicketFilterItem2 = cJRBusTicketFilters8.getBusTicketFilterItems().get(i3);
                            k.a((Object) cJRBusTicketFilterItem2, "mBusTicketFilters.busTicketFilterItems[i]");
                            if (k.a((Object) cJRBusTicketFilterItem2.getTitle(), (Object) "D.Pt")) {
                                CJRBusTicketFilters cJRBusTicketFilters9 = this.l;
                                if (cJRBusTicketFilters9 == null) {
                                    k.a("mBusTicketFilters");
                                }
                                arrayList.remove(cJRBusTicketFilters9.getBusTicketFilterItems().get(i3));
                            }
                        }
                    }
                    CJRBusTicketFilters cJRBusTicketFilters10 = this.l;
                    if (cJRBusTicketFilters10 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters10.getBusTicketFilterItems().clear();
                    CJRBusTicketFilters cJRBusTicketFilters11 = this.l;
                    if (cJRBusTicketFilters11 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters11.getBusTicketFilterItems().addAll(arrayList);
                }
            }
        }
        e();
        int size2 = e().size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (e().get(i4).isFilterSelected()) {
                CJRBusTicketFilterItem cJRBusTicketFilterItem3 = new CJRBusTicketFilterItem();
                String str = i2 == 1 ? "B.Pt" : "D.Pt";
                cJRBusTicketFilterItem3.setFilterCategory(i2 == 1 ? com.travel.bus.pojo.busticket.e.BOARDING_POINT : com.travel.bus.pojo.busticket.e.DROPPING_POINT);
                cJRBusTicketFilterItem3.setTitle(str);
                cJRBusTicketFilterItem3.setType("list");
                cJRBusTicketFilterItem3.setDisplayValue(e().get(i4).getLocationName());
                cJRBusTicketFilterItem3.setFilterValue(e().get(i4).getLocationName());
                CJRBusTicketFilters cJRBusTicketFilters12 = this.l;
                if (cJRBusTicketFilters12 == null) {
                    k.a("mBusTicketFilters");
                }
                if (!cJRBusTicketFilters12.getBusTicketFilterItems().contains(cJRBusTicketFilterItem3)) {
                    CJRBusTicketFilters cJRBusTicketFilters13 = this.l;
                    if (cJRBusTicketFilters13 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters13.getBusTicketFilterItems().add(cJRBusTicketFilterItem3);
                }
            }
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a2 = am.a(activity).a(com.travel.bus.busticket.busfilter.c.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…terViewModel::class.java)");
        com.travel.bus.busticket.busfilter.c cVar = (com.travel.bus.busticket.busfilter.c) a2;
        CJRBusTicketFilters cJRBusTicketFilters14 = this.l;
        if (cJRBusTicketFilters14 == null) {
            k.a("mBusTicketFilters");
        }
        cVar.a(cJRBusTicketFilters14);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
