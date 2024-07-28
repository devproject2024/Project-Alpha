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
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.CJRBusFilterContainer;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
import com.travel.bus.pojo.busticket.CJRTravelName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.i.h;

public final class d extends h implements TextWatcher, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f22094b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public com.travel.bus.busticket.busfilter.a.c f22095a;

    /* renamed from: c  reason: collision with root package name */
    private final String f22096c = "BusOperatorFilterFragment";

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f22097d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f22098e;

    /* renamed from: f  reason: collision with root package name */
    private Button f22099f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f22100g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22101h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f22102i;
    private com.travel.bus.busticket.busfilter.b j;
    private CJRBusFilterContainer k;
    private ArrayList<CJRBusSearchItem> l;
    private ArrayList<CJRTravelName> m;
    private CJRBusTicketFilters n;
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public String p;
    private String q;
    private ArrayList<CJRTravelName> r = new ArrayList<>();
    private HashMap s;

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    static final class c<T> implements z<List<? extends CJRTravelName>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f22104a;

        c(d dVar) {
            this.f22104a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list.isEmpty()) {
                d.a(this.f22104a).setVisibility(0);
                d.b(this.f22104a).setVisibility(8);
            } else {
                d.a(this.f22104a).setVisibility(8);
                d.b(this.f22104a).setVisibility(0);
            }
            boolean a2 = d.a((ArrayList<CJRTravelName>) new ArrayList(list));
            if (!a2) {
                a2 = d.a((ArrayList<CJRTravelName>) new ArrayList(d.c(this.f22104a)));
            }
            d.d(this.f22104a).a(a2, 2);
        }
    }

    /* renamed from: com.travel.bus.busticket.busfilter.b.d$d  reason: collision with other inner class name */
    static final class C0437d extends l implements kotlin.g.a.b<CJRTravelName, Boolean> {
        public static final C0437d INSTANCE = new C0437d();

        C0437d() {
            super(1);
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRTravelName) obj));
        }

        public final boolean invoke(CJRTravelName cJRTravelName) {
            k.c(cJRTravelName, "it");
            return !cJRTravelName.isFilterSelected();
        }
    }

    public static final /* synthetic */ TextView a(d dVar) {
        TextView textView = dVar.f22101h;
        if (textView == null) {
            k.a("mNoItemsFound");
        }
        return textView;
    }

    public static final /* synthetic */ RecyclerView b(d dVar) {
        RecyclerView recyclerView = dVar.f22097d;
        if (recyclerView == null) {
            k.a("mRecyclerViewOperator");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ArrayList c(d dVar) {
        ArrayList<CJRTravelName> arrayList = dVar.m;
        if (arrayList == null) {
            k.a("mAllOperators");
        }
        return arrayList;
    }

    public static final /* synthetic */ com.travel.bus.busticket.busfilter.b d(d dVar) {
        com.travel.bus.busticket.busfilter.b bVar = dVar.j;
        if (bVar == null) {
            k.a("mBusFilterTabListener");
        }
        return bVar;
    }

    public static final /* synthetic */ com.travel.bus.busticket.busfilter.a.c e(d dVar) {
        com.travel.bus.busticket.busfilter.a.c cVar = dVar.f22095a;
        if (cVar == null) {
            k.a("mBusFilterOperatorAdapter");
        }
        return cVar;
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
        View inflate = layoutInflater.inflate(R.layout.bus_operator_filter_fragment, viewGroup, false);
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
                    this.n = (CJRBusTicketFilters) serializable;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
                }
            }
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                k.a();
            }
            this.o = arguments3.getString("intent_extra_bus_start_city");
            Bundle arguments4 = getArguments();
            if (arguments4 == null) {
                k.a();
            }
            this.p = arguments4.getString("intent_extra_bus_dest_city");
            ArrayList<CJRBusSearchItem> c2 = com.travel.bus.busticket.i.d.a().c();
            k.a((Object) c2, "BusSearchDataUtilsSingle…ce().getmBusSearchItems()");
            this.l = c2;
            CJRBusFilterContainer d2 = com.travel.bus.busticket.i.d.a().d();
            k.a((Object) d2, "BusSearchDataUtilsSingle….getmBusFilterContainer()");
            this.k = d2;
            CJRBusFilterContainer cJRBusFilterContainer = this.k;
            if (cJRBusFilterContainer == null) {
                k.a("mBusFilterContainer");
            }
            ArrayList<CJRTravelName> busOperators = cJRBusFilterContainer.getBusOperators();
            k.a((Object) busOperators, "cjrBusFilterContainer.busOperators");
            this.m = busOperators;
            ArrayList<CJRTravelName> arrayList = this.m;
            if (arrayList == null) {
                k.a("mAllOperators");
            }
            Iterable<CJRTravelName> iterable = arrayList;
            Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
            for (CJRTravelName filterSelected : iterable) {
                filterSelected.setFilterSelected(false);
                arrayList2.add(x.f47997a);
            }
            CJRBusTicketFilters cJRBusTicketFilters = this.n;
            if (cJRBusTicketFilters == null) {
                k.a("mBusTicketFilters");
            }
            if (cJRBusTicketFilters.getBusTicketFilterItems().size() > 0) {
                CJRBusTicketFilters cJRBusTicketFilters2 = this.n;
                if (cJRBusTicketFilters2 == null) {
                    k.a("mBusTicketFilters");
                }
                ArrayList<CJRBusTicketFilterItem> busTicketFilterItems = cJRBusTicketFilters2.getBusTicketFilterItems();
                k.a((Object) busTicketFilterItems, "mBusTicketFilters.busTicketFilterItems");
                int size = busTicketFilterItems.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CJRBusTicketFilters cJRBusTicketFilters3 = this.n;
                    if (cJRBusTicketFilters3 == null) {
                        k.a("mBusTicketFilters");
                    }
                    CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters3.getBusTicketFilterItems().get(i2);
                    k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters.busTicketFilterItems[i]");
                    if (k.a((Object) cJRBusTicketFilterItem.getTitle(), (Object) "Opr")) {
                        ArrayList<CJRTravelName> arrayList3 = this.m;
                        if (arrayList3 == null) {
                            k.a("mAllOperators");
                        }
                        int size2 = arrayList3.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            ArrayList<CJRTravelName> arrayList4 = this.m;
                            if (arrayList4 == null) {
                                k.a("mAllOperators");
                            }
                            CJRTravelName cJRTravelName = arrayList4.get(i3);
                            k.a((Object) cJRTravelName, "mAllOperators[j]");
                            String travelsName = cJRTravelName.getTravelsName();
                            CJRBusTicketFilters cJRBusTicketFilters4 = this.n;
                            if (cJRBusTicketFilters4 == null) {
                                k.a("mBusTicketFilters");
                            }
                            CJRBusTicketFilterItem cJRBusTicketFilterItem2 = cJRBusTicketFilters4.getBusTicketFilterItems().get(i2);
                            k.a((Object) cJRBusTicketFilterItem2, "mBusTicketFilters.busTicketFilterItems[i]");
                            if (k.a((Object) travelsName, (Object) cJRBusTicketFilterItem2.getDisplayValue())) {
                                ArrayList<CJRTravelName> arrayList5 = this.m;
                                if (arrayList5 == null) {
                                    k.a("mAllOperators");
                                }
                                CJRTravelName cJRTravelName2 = arrayList5.get(i3);
                                k.a((Object) cJRTravelName2, "mAllOperators[j]");
                                cJRTravelName2.setFilterSelected(true);
                            }
                        }
                    }
                }
            }
        }
        k.a((Object) inflate, "view");
        View findViewById = inflate.findViewById(R.id.edit_search);
        k.a((Object) findViewById, "view.findViewById(R.id.edit_search)");
        this.f22100g = (EditText) findViewById;
        View findViewById2 = inflate.findViewById(R.id.btn_done);
        k.a((Object) findViewById2, "view.findViewById(R.id.btn_done)");
        this.f22099f = (Button) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.noItemsFound);
        k.a((Object) findViewById3, "view.findViewById(R.id.noItemsFound)");
        this.f22101h = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.lyt_progress_bar);
        k.a((Object) findViewById4, "view.findViewById(R.id.lyt_progress_bar)");
        this.f22102i = (RelativeLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.rv_bpdp);
        k.a((Object) findViewById5, "view.findViewById(R.id.rv_bpdp)");
        this.f22097d = (RecyclerView) findViewById5;
        EditText editText = this.f22100g;
        if (editText == null) {
            k.a("mEditSearch");
        }
        editText.setHint(getResources().getString(R.string.search_operators));
        EditText editText2 = this.f22100g;
        if (editText2 == null) {
            k.a("mEditSearch");
        }
        editText2.addTextChangedListener(this);
        Button button = this.f22099f;
        if (button == null) {
            k.a("mButtonDone");
        }
        button.setOnClickListener(this);
        return inflate;
    }

    public final void a() {
        EditText editText = this.f22100g;
        if (editText == null) {
            k.a("mEditSearch");
        }
        com.travel.bus.busticket.busfilter.d.a(editText);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.j = (com.travel.bus.busticket.busfilter.b) activity;
            ArrayList<CJRTravelName> arrayList = this.m;
            if (arrayList == null) {
                k.a("mAllOperators");
            }
            this.r = new ArrayList<>(c(arrayList));
            com.travel.bus.busticket.busfilter.b bVar = this.j;
            if (bVar == null) {
                k.a("mBusFilterTabListener");
            }
            bVar.a(a(this.r), 2);
            Context activity2 = getActivity();
            ArrayList<CJRTravelName> arrayList2 = this.r;
            ArrayList<CJRBusSearchItem> arrayList3 = this.l;
            if (arrayList3 == null) {
                k.a("mAllBusSearchItem");
            }
            this.f22095a = new com.travel.bus.busticket.busfilter.a.c(activity2, arrayList2, arrayList3, new b(this));
            this.f22098e = new LinearLayoutManager(getActivity());
            RecyclerView recyclerView = this.f22097d;
            if (recyclerView == null) {
                k.a("mRecyclerViewOperator");
            }
            LinearLayoutManager linearLayoutManager = this.f22098e;
            if (linearLayoutManager == null) {
                k.a("mLinearLayoutManager");
            }
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView2 = this.f22097d;
            if (recyclerView2 == null) {
                k.a("mRecyclerViewOperator");
            }
            com.travel.bus.busticket.busfilter.a.c cVar = this.f22095a;
            if (cVar == null) {
                k.a("mBusFilterOperatorAdapter");
            }
            recyclerView2.setAdapter(cVar);
            com.travel.bus.busticket.busfilter.a.c cVar2 = this.f22095a;
            if (cVar2 == null) {
                k.a("mBusFilterOperatorAdapter");
            }
            cVar2.f22037b.observe(this, new c(this));
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.bus.busticket.busfilter.BusFilterTabListener");
    }

    public static final class b implements com.travel.bus.busticket.busfilter.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f22103a;

        b(d dVar) {
            this.f22103a = dVar;
        }

        public final void a(Object obj) {
            k.c(obj, "item");
            if (obj instanceof CJRTravelName) {
                CJRTravelName cJRTravelName = (CJRTravelName) obj;
                ArrayList arrayList = new ArrayList(d.e(this.f22103a).f22036a);
                d.c(this.f22103a).remove(cJRTravelName);
                arrayList.remove(cJRTravelName);
                cJRTravelName.setFilterSelected(!cJRTravelName.isFilterSelected());
                d.c(this.f22103a).add(cJRTravelName);
                arrayList.add(cJRTravelName);
                if (cJRTravelName.isFilterSelected()) {
                    com.travel.bus.busticket.i.a.a(cJRTravelName, (Context) this.f22103a.getActivity(), this.f22103a.o, this.f22103a.p);
                    com.travel.bus.busticket.i.a.a(cJRTravelName, (Context) this.f22103a.getActivity());
                }
                ArrayList arrayList2 = new ArrayList(d.c((ArrayList<CJRTravelName>) arrayList));
                d.d(this.f22103a).a(d.a((ArrayList<CJRTravelName>) d.c(this.f22103a)), 2);
                d.e(this.f22103a).a((ArrayList<CJRTravelName>) arrayList2);
                this.f22103a.e();
            }
        }
    }

    public static boolean a(ArrayList<CJRTravelName> arrayList) {
        int i2;
        k.c(arrayList, "checkList");
        Iterable<CJRTravelName> iterable = arrayList;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            i2 = 0;
            for (CJRTravelName isFilterSelected : iterable) {
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

    static final class e extends l implements kotlin.g.a.b<CJRTravelName, String> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        public final String invoke(CJRTravelName cJRTravelName) {
            k.c(cJRTravelName, "it");
            return cJRTravelName.getTravelsName();
        }
    }

    /* access modifiers changed from: private */
    public static ArrayList<CJRTravelName> c(ArrayList<CJRTravelName> arrayList) {
        return new ArrayList<>(kotlin.a.k.a(arrayList, kotlin.b.a.a(C0437d.INSTANCE, e.INSTANCE)));
    }

    private final List<CJRTravelName> c() {
        com.travel.bus.busticket.busfilter.a.c cVar = this.f22095a;
        if (cVar == null) {
            k.a("mBusFilterOperatorAdapter");
        }
        Collection arrayList = new ArrayList();
        for (Object next : cVar.f22036a) {
            if (((CJRTravelName) next).isFilterSelected()) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void b() {
        com.travel.bus.busticket.busfilter.a.c cVar = this.f22095a;
        if (cVar == null) {
            k.a("mBusFilterOperatorAdapter");
        }
        ArrayList arrayList = new ArrayList(cVar.f22036a);
        Iterable<CJRTravelName> iterable = arrayList;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (CJRTravelName cJRTravelName : iterable) {
            k.a((Object) cJRTravelName, "it");
            cJRTravelName.setFilterSelected(false);
            arrayList2.add(x.f47997a);
        }
        ArrayList arrayList3 = new ArrayList();
        CJRBusTicketFilters cJRBusTicketFilters = this.n;
        if (cJRBusTicketFilters == null) {
            k.a("mBusTicketFilters");
        }
        arrayList3.addAll(cJRBusTicketFilters.getBusTicketFilterItems());
        CJRBusTicketFilters cJRBusTicketFilters2 = this.n;
        if (cJRBusTicketFilters2 == null) {
            k.a("mBusTicketFilters");
        }
        Iterator<CJRBusTicketFilterItem> it2 = cJRBusTicketFilters2.getBusTicketFilterItems().iterator();
        while (it2.hasNext()) {
            CJRBusTicketFilterItem next = it2.next();
            k.a((Object) next, "data");
            if (k.a((Object) next.getTitle(), (Object) "Opr")) {
                arrayList3.remove(next);
            }
        }
        CJRBusTicketFilters cJRBusTicketFilters3 = this.n;
        if (cJRBusTicketFilters3 == null) {
            k.a("mBusTicketFilters");
        }
        cJRBusTicketFilters3.setBusTicketFilterItems(arrayList3);
        com.travel.bus.busticket.busfilter.a.c cVar2 = this.f22095a;
        if (cVar2 == null) {
            k.a("mBusFilterOperatorAdapter");
        }
        cVar2.a((ArrayList<CJRTravelName>) arrayList);
        com.travel.bus.busticket.busfilter.b bVar = this.j;
        if (bVar == null) {
            k.a("mBusFilterTabListener");
        }
        bVar.a(false, 2);
    }

    public final void onClick(View view) {
        k.c(view, "v");
        if (view.getId() == R.id.btn_done) {
            a();
            com.travel.bus.busticket.busfilter.a.c cVar = this.f22095a;
            if (cVar == null) {
                k.a("mBusFilterOperatorAdapter");
            }
            if (cVar != null) {
                com.travel.bus.busticket.busfilter.a.c cVar2 = this.f22095a;
                if (cVar2 == null) {
                    k.a("mBusFilterOperatorAdapter");
                }
                com.travel.bus.busticket.i.a.a(cVar2.f22036a.size(), (List<CJRTravelName>) cVar2.f22036a, (Context) getActivity());
                HashMap hashMap = new HashMap();
                boolean z = true;
                try {
                    String str = "";
                    for (CJRTravelName travelsName : c()) {
                        str = str + travelsName.getTravelsName();
                    }
                    if (p.c(str, AppConstants.COMMA, false)) {
                        int length = str.length() - 1;
                        if (str != null) {
                            str = str.substring(0, length);
                            k.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    hashMap.put("event_label", str);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                Map map = hashMap;
                map.put("event_label2", String.valueOf(this.o) + "/" + this.p);
                CharSequence n2 = com.paytm.utility.b.n((Context) getActivity());
                if (!(n2 == null || n2.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    String n3 = com.paytm.utility.b.n((Context) getActivity());
                    k.a((Object) n3, "CJRAppCommonUtility.getUserId(activity)");
                    map.put("userid", n3);
                }
                com.travel.bus.a.a();
                com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "bus_operators_filter_selected", map);
                e();
                com.travel.bus.busticket.busfilter.b bVar = this.j;
                if (bVar == null) {
                    k.a("mBusFilterTabListener");
                }
                bVar.a(0);
            }
        }
    }

    private final List<CJRTravelName> d() {
        com.travel.bus.busticket.busfilter.a.c cVar = this.f22095a;
        if (cVar == null) {
            k.a("mBusFilterOperatorAdapter");
        }
        Collection arrayList = new ArrayList();
        for (Object next : cVar.f22036a) {
            if (((CJRTravelName) next).isFilterSelected()) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void afterTextChanged(Editable editable) {
        com.travel.bus.busticket.i.a.a(String.valueOf(editable), (Context) getActivity());
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        String str;
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                com.travel.bus.busticket.busfilter.a.c cVar = this.f22095a;
                if (cVar == null) {
                    k.a("mBusFilterOperatorAdapter");
                }
                cVar.getFilter().filter(charSequence.toString());
                str = charSequence.toString();
                this.q = str;
            }
        }
        TextView textView = this.f22101h;
        if (textView == null) {
            k.a("mNoItemsFound");
        }
        textView.setVisibility(8);
        RecyclerView recyclerView = this.f22097d;
        if (recyclerView == null) {
            k.a("mRecyclerViewOperator");
        }
        recyclerView.setVisibility(0);
        ArrayList arrayList = new ArrayList(c(this.r));
        com.travel.bus.busticket.busfilter.a.c cVar2 = this.f22095a;
        if (cVar2 == null) {
            k.a("mBusFilterOperatorAdapter");
        }
        cVar2.a((ArrayList<CJRTravelName>) arrayList);
        com.travel.bus.busticket.busfilter.b bVar = this.j;
        if (bVar == null) {
            k.a("mBusFilterTabListener");
        }
        bVar.a(a((ArrayList<CJRTravelName>) new ArrayList(arrayList)), 2);
        str = String.valueOf(charSequence);
        this.q = str;
    }

    /* access modifiers changed from: private */
    public final void e() {
        CJRBusTicketFilters cJRBusTicketFilters = this.n;
        if (cJRBusTicketFilters == null) {
            k.a("mBusTicketFilters");
        }
        if (cJRBusTicketFilters != null) {
            CJRBusTicketFilters cJRBusTicketFilters2 = this.n;
            if (cJRBusTicketFilters2 == null) {
                k.a("mBusTicketFilters");
            }
            if (cJRBusTicketFilters2.getBusTicketFilterItems() != null) {
                CJRBusTicketFilters cJRBusTicketFilters3 = this.n;
                if (cJRBusTicketFilters3 == null) {
                    k.a("mBusTicketFilters");
                }
                if (cJRBusTicketFilters3.getBusTicketFilterItems().size() > 0) {
                    CJRBusTicketFilters cJRBusTicketFilters4 = this.n;
                    if (cJRBusTicketFilters4 == null) {
                        k.a("mBusTicketFilters");
                    }
                    ArrayList arrayList = new ArrayList(cJRBusTicketFilters4.getBusTicketFilterItems());
                    CJRBusTicketFilters cJRBusTicketFilters5 = this.n;
                    if (cJRBusTicketFilters5 == null) {
                        k.a("mBusTicketFilters");
                    }
                    int size = cJRBusTicketFilters5.getBusTicketFilterItems().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        CJRBusTicketFilters cJRBusTicketFilters6 = this.n;
                        if (cJRBusTicketFilters6 == null) {
                            k.a("mBusTicketFilters");
                        }
                        CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters6.getBusTicketFilterItems().get(i2);
                        k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters.busTicketFilterItems[i]");
                        if (k.a((Object) cJRBusTicketFilterItem.getTitle(), (Object) "Opr")) {
                            CJRBusTicketFilters cJRBusTicketFilters7 = this.n;
                            if (cJRBusTicketFilters7 == null) {
                                k.a("mBusTicketFilters");
                            }
                            arrayList.remove(cJRBusTicketFilters7.getBusTicketFilterItems().get(i2));
                        }
                    }
                    CJRBusTicketFilters cJRBusTicketFilters8 = this.n;
                    if (cJRBusTicketFilters8 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters8.getBusTicketFilterItems().clear();
                    CJRBusTicketFilters cJRBusTicketFilters9 = this.n;
                    if (cJRBusTicketFilters9 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters9.getBusTicketFilterItems().addAll(arrayList);
                }
            }
        }
        d();
        int size2 = d().size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (d().get(i3).isFilterSelected()) {
                CJRBusTicketFilterItem cJRBusTicketFilterItem2 = new CJRBusTicketFilterItem();
                cJRBusTicketFilterItem2.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_OPERATOR);
                cJRBusTicketFilterItem2.setTitle("Opr");
                cJRBusTicketFilterItem2.setType("list");
                cJRBusTicketFilterItem2.setDisplayValue(d().get(i3).getTravelsName());
                cJRBusTicketFilterItem2.setFilterValue(d().get(i3).getComputedTravelsName());
                CJRBusTicketFilters cJRBusTicketFilters10 = this.n;
                if (cJRBusTicketFilters10 == null) {
                    k.a("mBusTicketFilters");
                }
                if (!cJRBusTicketFilters10.getBusTicketFilterItems().contains(cJRBusTicketFilterItem2)) {
                    CJRBusTicketFilters cJRBusTicketFilters11 = this.n;
                    if (cJRBusTicketFilters11 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters11.getBusTicketFilterItems().add(cJRBusTicketFilterItem2);
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
        CJRBusTicketFilters cJRBusTicketFilters12 = this.n;
        if (cJRBusTicketFilters12 == null) {
            k.a("mBusTicketFilters");
        }
        cVar.a(cJRBusTicketFilters12);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
