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
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
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

public final class a extends h implements TextWatcher, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final C0434a f22052b = new C0434a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public com.travel.bus.busticket.busfilter.a.a f22053a;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f22054c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayoutManager f22055d;

    /* renamed from: e  reason: collision with root package name */
    private Button f22056e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f22057f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f22058g;

    /* renamed from: h  reason: collision with root package name */
    private com.travel.bus.busticket.busfilter.b f22059h;

    /* renamed from: i  reason: collision with root package name */
    private CJRBusTicketFilters f22060i;
    private TextView j;
    private ArrayList<CJRBusSearchAmenitiesInfo> k;
    private HashMap<String, CJRBusSearchAmenitiesInfo> l;
    private ArrayList<CJRBusSearchAmenitiesInfo> m;
    private String n;
    private HashMap o;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    static final class c<T> implements z<List<? extends CJRBusSearchAmenitiesInfo>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22062a;

        c(a aVar) {
            this.f22062a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list.isEmpty()) {
                a.a(this.f22062a).setVisibility(0);
                a.b(this.f22062a).setVisibility(8);
            } else {
                a.a(this.f22062a).setVisibility(8);
                a.b(this.f22062a).setVisibility(0);
            }
            boolean a2 = a.a((ArrayList<CJRBusSearchAmenitiesInfo>) new ArrayList(list));
            if (!a2) {
                a2 = a.a((ArrayList<CJRBusSearchAmenitiesInfo>) new ArrayList(a.c(this.f22062a)));
            }
            a.d(this.f22062a).a(a2, 3);
        }
    }

    static final class d extends l implements kotlin.g.a.b<CJRBusSearchAmenitiesInfo, Boolean> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRBusSearchAmenitiesInfo) obj));
        }

        public final boolean invoke(CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo) {
            k.c(cJRBusSearchAmenitiesInfo, "it");
            return !cJRBusSearchAmenitiesInfo.isSelected();
        }
    }

    public static final /* synthetic */ TextView a(a aVar) {
        TextView textView = aVar.j;
        if (textView == null) {
            k.a("mNoItemsFound");
        }
        return textView;
    }

    public static final /* synthetic */ RecyclerView b(a aVar) {
        RecyclerView recyclerView = aVar.f22054c;
        if (recyclerView == null) {
            k.a("mRecyclerViewAmenities");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ArrayList c(a aVar) {
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList = aVar.k;
        if (arrayList == null) {
            k.a("mCurrentAmenitiesInfoList");
        }
        return arrayList;
    }

    public static final /* synthetic */ com.travel.bus.busticket.busfilter.b d(a aVar) {
        com.travel.bus.busticket.busfilter.b bVar = aVar.f22059h;
        if (bVar == null) {
            k.a("mBusFilterTabListener");
        }
        return bVar;
    }

    public static final /* synthetic */ com.travel.bus.busticket.busfilter.a.a e(a aVar) {
        com.travel.bus.busticket.busfilter.a.a aVar2 = aVar.f22053a;
        if (aVar2 == null) {
            k.a("mBusFilterAmenitiesAdapter");
        }
        return aVar2;
    }

    /* renamed from: com.travel.bus.busticket.busfilter.b.a$a  reason: collision with other inner class name */
    public static final class C0434a {
        private C0434a() {
        }

        public /* synthetic */ C0434a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.bus_amenities_filter_fragment, viewGroup, false);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            if (arguments.containsKey("intent_extra_bus_search_filter_amenity_items")) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                Serializable serializable = arguments2.getSerializable("intent_extra_bus_search_filter_amenity_items");
                if (serializable != null) {
                    this.k = (ArrayList) serializable;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> /* = java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> */");
                }
            }
        }
        if (getArguments() != null) {
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                k.a();
            }
            if (arguments3.containsKey("amenity_info")) {
                Bundle arguments4 = getArguments();
                if (arguments4 == null) {
                    k.a();
                }
                Serializable serializable2 = arguments4.getSerializable("amenity_info");
                if (serializable2 != null) {
                    this.l = (HashMap) serializable2;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> /* = java.util.HashMap<kotlin.String, com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> */");
                }
            }
        }
        if (getArguments() != null) {
            Bundle arguments5 = getArguments();
            if (arguments5 == null) {
                k.a();
            }
            if (arguments5.containsKey("intent_extra_bus_search_filter_items")) {
                Bundle arguments6 = getArguments();
                if (arguments6 == null) {
                    k.a();
                }
                Serializable serializable3 = arguments6.getSerializable("intent_extra_bus_search_filter_items");
                if (serializable3 != null) {
                    this.f22060i = (CJRBusTicketFilters) serializable3;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
                }
            }
        }
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.k;
        if (arrayList == null) {
            k.a("mCurrentAmenitiesInfoList");
        }
        arrayList.clear();
        ArrayList<CJRBusSearchAmenitiesInfo> d2 = d();
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList2 = this.k;
        if (arrayList2 == null) {
            k.a("mCurrentAmenitiesInfoList");
        }
        arrayList2.addAll(d2);
        k.a((Object) inflate, "view");
        View findViewById = inflate.findViewById(R.id.edit_search);
        k.a((Object) findViewById, "view.findViewById(R.id.edit_search)");
        this.f22057f = (EditText) findViewById;
        View findViewById2 = inflate.findViewById(R.id.btn_done);
        k.a((Object) findViewById2, "view.findViewById(R.id.btn_done)");
        this.f22056e = (Button) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.lyt_progress_bar);
        k.a((Object) findViewById3, "view.findViewById(R.id.lyt_progress_bar)");
        this.f22058g = (RelativeLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.rv_bpdp);
        k.a((Object) findViewById4, "view.findViewById(R.id.rv_bpdp)");
        this.f22054c = (RecyclerView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.noItemsFound);
        k.a((Object) findViewById5, "view.findViewById(R.id.noItemsFound)");
        this.j = (TextView) findViewById5;
        EditText editText = this.f22057f;
        if (editText == null) {
            k.a("mEditSearch");
        }
        editText.setHint(getResources().getString(R.string.search_amenities));
        EditText editText2 = this.f22057f;
        if (editText2 == null) {
            k.a("mEditSearch");
        }
        editText2.addTextChangedListener(this);
        Button button = this.f22056e;
        if (button == null) {
            k.a("mButtonDone");
        }
        button.setOnClickListener(this);
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList3 = this.k;
        if (arrayList3 == null) {
            k.a("mCurrentAmenitiesInfoList");
        }
        arrayList3.clear();
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList4 = this.k;
        if (arrayList4 == null) {
            k.a("mCurrentAmenitiesInfoList");
        }
        arrayList4.addAll(d());
        CJRBusTicketFilters cJRBusTicketFilters = this.f22060i;
        if (cJRBusTicketFilters == null) {
            k.a("mBusTicketFilters");
        }
        if (cJRBusTicketFilters.getBusTicketFilterItems().size() == 0) {
            ArrayList<CJRBusSearchAmenitiesInfo> arrayList5 = this.k;
            if (arrayList5 == null) {
                k.a("mCurrentAmenitiesInfoList");
            }
            Iterable<CJRBusSearchAmenitiesInfo> iterable = arrayList5;
            Collection arrayList6 = new ArrayList(kotlin.a.k.a(iterable));
            for (CJRBusSearchAmenitiesInfo selected : iterable) {
                selected.setSelected(false);
                arrayList6.add(x.f47997a);
            }
        } else {
            CJRBusTicketFilters cJRBusTicketFilters2 = this.f22060i;
            if (cJRBusTicketFilters2 == null) {
                k.a("mBusTicketFilters");
            }
            if (cJRBusTicketFilters2.getBusTicketFilterItems().size() > 0) {
                CJRBusTicketFilters cJRBusTicketFilters3 = this.f22060i;
                if (cJRBusTicketFilters3 == null) {
                    k.a("mBusTicketFilters");
                }
                ArrayList<CJRBusTicketFilterItem> busTicketFilterItems = cJRBusTicketFilters3.getBusTicketFilterItems();
                k.a((Object) busTicketFilterItems, "mBusTicketFilters.busTicketFilterItems");
                int size = busTicketFilterItems.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CJRBusTicketFilters cJRBusTicketFilters4 = this.f22060i;
                    if (cJRBusTicketFilters4 == null) {
                        k.a("mBusTicketFilters");
                    }
                    CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters4.getBusTicketFilterItems().get(i2);
                    k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters.busTicketFilterItems[i]");
                    if (k.a((Object) cJRBusTicketFilterItem.getType(), (Object) "Amenity")) {
                        ArrayList<CJRBusSearchAmenitiesInfo> arrayList7 = this.k;
                        if (arrayList7 == null) {
                            k.a("mCurrentAmenitiesInfoList");
                        }
                        int size2 = arrayList7.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            ArrayList<CJRBusSearchAmenitiesInfo> arrayList8 = this.k;
                            if (arrayList8 == null) {
                                k.a("mCurrentAmenitiesInfoList");
                            }
                            CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = arrayList8.get(i3);
                            k.a((Object) cJRBusSearchAmenitiesInfo, "mCurrentAmenitiesInfoList[j]");
                            String id = cJRBusSearchAmenitiesInfo.getId();
                            CJRBusTicketFilters cJRBusTicketFilters5 = this.f22060i;
                            if (cJRBusTicketFilters5 == null) {
                                k.a("mBusTicketFilters");
                            }
                            if (k.a((Object) id, (Object) cJRBusTicketFilters5.getBusTicketFilterItems().get(i2).getmAmenityId())) {
                                ArrayList<CJRBusSearchAmenitiesInfo> arrayList9 = this.k;
                                if (arrayList9 == null) {
                                    k.a("mCurrentAmenitiesInfoList");
                                }
                                CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo2 = arrayList9.get(i3);
                                k.a((Object) cJRBusSearchAmenitiesInfo2, "mCurrentAmenitiesInfoList[j]");
                                cJRBusSearchAmenitiesInfo2.setSelected(true);
                            }
                        }
                    }
                }
            }
        }
        return inflate;
    }

    public final void a() {
        EditText editText = this.f22057f;
        if (editText == null) {
            k.a("mEditSearch");
        }
        com.travel.bus.busticket.busfilter.d.a(editText);
    }

    public final void onClick(View view) {
        k.c(view, "v");
        if (view.getId() == R.id.btn_done) {
            a();
            c();
            com.travel.bus.busticket.busfilter.b bVar = this.f22059h;
            if (bVar == null) {
                k.a("mBusFilterTabListener");
            }
            bVar.a(0);
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        a("Amenity");
        e();
        int size = e().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (e().get(i2).isSelected()) {
                CJRBusTicketFilterItem cJRBusTicketFilterItem = new CJRBusTicketFilterItem();
                cJRBusTicketFilterItem.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_AMENITY);
                cJRBusTicketFilterItem.setTitle(e().get(i2).getLabel());
                cJRBusTicketFilterItem.setType("Amenity");
                cJRBusTicketFilterItem.setmAmenityId(e().get(i2).getId());
                CJRBusTicketFilters cJRBusTicketFilters = this.f22060i;
                if (cJRBusTicketFilters == null) {
                    k.a("mBusTicketFilters");
                }
                if (!cJRBusTicketFilters.getBusTicketFilterItems().contains(cJRBusTicketFilterItem)) {
                    CJRBusTicketFilters cJRBusTicketFilters2 = this.f22060i;
                    if (cJRBusTicketFilters2 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters2.getBusTicketFilterItems().add(cJRBusTicketFilterItem);
                }
            }
        }
        CJRBusTicketFilters cJRBusTicketFilters3 = this.f22060i;
        if (cJRBusTicketFilters3 == null) {
            k.a("mBusTicketFilters");
        }
        cJRBusTicketFilters3.setmCurrentSelectedAmenityList(new ArrayList(e()));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        ai a2 = am.a(activity).a(com.travel.bus.busticket.busfilter.c.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…terViewModel::class.java)");
        com.travel.bus.busticket.busfilter.c cVar = (com.travel.bus.busticket.busfilter.c) a2;
        CJRBusTicketFilters cJRBusTicketFilters4 = this.f22060i;
        if (cJRBusTicketFilters4 == null) {
            k.a("mBusTicketFilters");
        }
        cVar.a(cJRBusTicketFilters4);
    }

    private final void a(String str) {
        CJRBusTicketFilters cJRBusTicketFilters = this.f22060i;
        if (cJRBusTicketFilters == null) {
            k.a("mBusTicketFilters");
        }
        if (cJRBusTicketFilters != null) {
            CJRBusTicketFilters cJRBusTicketFilters2 = this.f22060i;
            if (cJRBusTicketFilters2 == null) {
                k.a("mBusTicketFilters");
            }
            if (cJRBusTicketFilters2.getBusTicketFilterItems() != null) {
                CJRBusTicketFilters cJRBusTicketFilters3 = this.f22060i;
                if (cJRBusTicketFilters3 == null) {
                    k.a("mBusTicketFilters");
                }
                if (cJRBusTicketFilters3.getBusTicketFilterItems().size() > 0) {
                    CJRBusTicketFilters cJRBusTicketFilters4 = this.f22060i;
                    if (cJRBusTicketFilters4 == null) {
                        k.a("mBusTicketFilters");
                    }
                    ArrayList arrayList = new ArrayList(cJRBusTicketFilters4.getBusTicketFilterItems());
                    CJRBusTicketFilters cJRBusTicketFilters5 = this.f22060i;
                    if (cJRBusTicketFilters5 == null) {
                        k.a("mBusTicketFilters");
                    }
                    int size = cJRBusTicketFilters5.getBusTicketFilterItems().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        CJRBusTicketFilters cJRBusTicketFilters6 = this.f22060i;
                        if (cJRBusTicketFilters6 == null) {
                            k.a("mBusTicketFilters");
                        }
                        CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters6.getBusTicketFilterItems().get(i2);
                        k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters.busTicketFilterItems[i]");
                        if (k.a((Object) cJRBusTicketFilterItem.getType(), (Object) str)) {
                            CJRBusTicketFilters cJRBusTicketFilters7 = this.f22060i;
                            if (cJRBusTicketFilters7 == null) {
                                k.a("mBusTicketFilters");
                            }
                            arrayList.remove(cJRBusTicketFilters7.getBusTicketFilterItems().get(i2));
                        }
                    }
                    CJRBusTicketFilters cJRBusTicketFilters8 = this.f22060i;
                    if (cJRBusTicketFilters8 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters8.getBusTicketFilterItems().clear();
                    CJRBusTicketFilters cJRBusTicketFilters9 = this.f22060i;
                    if (cJRBusTicketFilters9 == null) {
                        k.a("mBusTicketFilters");
                    }
                    cJRBusTicketFilters9.getBusTicketFilterItems().addAll(arrayList);
                }
            }
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        String str;
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                com.travel.bus.busticket.busfilter.a.a aVar = this.f22053a;
                if (aVar == null) {
                    k.a("mBusFilterAmenitiesAdapter");
                }
                aVar.getFilter().filter(charSequence.toString());
                str = charSequence.toString();
                this.n = str;
            }
        }
        TextView textView = this.j;
        if (textView == null) {
            k.a("mNoItemsFound");
        }
        textView.setVisibility(8);
        RecyclerView recyclerView = this.f22054c;
        if (recyclerView == null) {
            k.a("mRecyclerViewAmenities");
        }
        recyclerView.setVisibility(0);
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.m;
        if (arrayList == null) {
            k.a("mSortedList");
        }
        ArrayList arrayList2 = new ArrayList(c(arrayList));
        com.travel.bus.busticket.busfilter.a.a aVar2 = this.f22053a;
        if (aVar2 == null) {
            k.a("mBusFilterAmenitiesAdapter");
        }
        aVar2.a((ArrayList<CJRBusSearchAmenitiesInfo>) arrayList2);
        str = String.valueOf(charSequence);
        this.n = str;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f22059h = (com.travel.bus.busticket.busfilter.b) activity;
            ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.k;
            if (arrayList == null) {
                k.a("mCurrentAmenitiesInfoList");
            }
            if (arrayList != null) {
                ArrayList<CJRBusSearchAmenitiesInfo> arrayList2 = this.k;
                if (arrayList2 == null) {
                    k.a("mCurrentAmenitiesInfoList");
                }
                this.m = new ArrayList<>(c(arrayList2));
                com.travel.bus.busticket.busfilter.b bVar = this.f22059h;
                if (bVar == null) {
                    k.a("mBusFilterTabListener");
                }
                ArrayList<CJRBusSearchAmenitiesInfo> arrayList3 = this.m;
                if (arrayList3 == null) {
                    k.a("mSortedList");
                }
                bVar.a(a(arrayList3), 3);
                Context activity2 = getActivity();
                ArrayList<CJRBusSearchAmenitiesInfo> arrayList4 = this.m;
                if (arrayList4 == null) {
                    k.a("mSortedList");
                }
                this.f22053a = new com.travel.bus.busticket.busfilter.a.a(activity2, arrayList4, new b(this));
                this.f22055d = new LinearLayoutManager(getActivity());
                RecyclerView recyclerView = this.f22054c;
                if (recyclerView == null) {
                    k.a("mRecyclerViewAmenities");
                }
                LinearLayoutManager linearLayoutManager = this.f22055d;
                if (linearLayoutManager == null) {
                    k.a("mLinearLayoutManager");
                }
                recyclerView.setLayoutManager(linearLayoutManager);
                RecyclerView recyclerView2 = this.f22054c;
                if (recyclerView2 == null) {
                    k.a("mRecyclerViewAmenities");
                }
                com.travel.bus.busticket.busfilter.a.a aVar = this.f22053a;
                if (aVar == null) {
                    k.a("mBusFilterAmenitiesAdapter");
                }
                recyclerView2.setAdapter(aVar);
            }
            com.travel.bus.busticket.busfilter.a.a aVar2 = this.f22053a;
            if (aVar2 == null) {
                k.a("mBusFilterAmenitiesAdapter");
            }
            aVar2.f22010b.observe(this, new c(this));
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.bus.busticket.busfilter.BusFilterTabListener");
    }

    private final ArrayList<CJRBusSearchAmenitiesInfo> d() {
        HashMap<String, CJRBusSearchAmenitiesInfo> hashMap = this.l;
        if (hashMap == null) {
            k.a("mAmenitiesInfo");
        }
        return new ArrayList<>(hashMap.values());
    }

    public static final class b implements com.travel.bus.busticket.busfilter.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22061a;

        b(a aVar) {
            this.f22061a = aVar;
        }

        public final void a(Object obj) {
            k.c(obj, "item");
            if (obj instanceof CJRBusSearchAmenitiesInfo) {
                CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = (CJRBusSearchAmenitiesInfo) obj;
                ArrayList arrayList = new ArrayList(a.e(this.f22061a).f22009a);
                a.c(this.f22061a).remove(cJRBusSearchAmenitiesInfo);
                arrayList.remove(cJRBusSearchAmenitiesInfo);
                cJRBusSearchAmenitiesInfo.setSelected(!cJRBusSearchAmenitiesInfo.isSelected());
                a.c(this.f22061a).add(cJRBusSearchAmenitiesInfo);
                arrayList.add(cJRBusSearchAmenitiesInfo);
                ArrayList arrayList2 = new ArrayList(a.c((ArrayList<CJRBusSearchAmenitiesInfo>) arrayList));
                a.d(this.f22061a).a(a.a((ArrayList<CJRBusSearchAmenitiesInfo>) a.c(this.f22061a)), 3);
                a.e(this.f22061a).a((ArrayList<CJRBusSearchAmenitiesInfo>) arrayList2);
                this.f22061a.c();
            }
        }
    }

    public static boolean a(ArrayList<CJRBusSearchAmenitiesInfo> arrayList) {
        int i2;
        k.c(arrayList, "checkList");
        Iterable<CJRBusSearchAmenitiesInfo> iterable = arrayList;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            i2 = 0;
            for (CJRBusSearchAmenitiesInfo isSelected : iterable) {
                if (isSelected.isSelected() && (i2 = i2 + 1) < 0) {
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

    static final class e extends l implements kotlin.g.a.b<CJRBusSearchAmenitiesInfo, String> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        public final String invoke(CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo) {
            k.c(cJRBusSearchAmenitiesInfo, "it");
            return cJRBusSearchAmenitiesInfo.getLabel();
        }
    }

    /* access modifiers changed from: private */
    public static ArrayList<CJRBusSearchAmenitiesInfo> c(ArrayList<CJRBusSearchAmenitiesInfo> arrayList) {
        return new ArrayList<>(kotlin.a.k.a(arrayList, kotlin.b.a.a(d.INSTANCE, e.INSTANCE)));
    }

    private final List<CJRBusSearchAmenitiesInfo> e() {
        com.travel.bus.busticket.busfilter.a.a aVar = this.f22053a;
        if (aVar == null) {
            k.a("mBusFilterAmenitiesAdapter");
        }
        Collection arrayList = new ArrayList();
        for (Object next : aVar.f22009a) {
            if (((CJRBusSearchAmenitiesInfo) next).isSelected()) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void b() {
        com.travel.bus.busticket.busfilter.a.a aVar = this.f22053a;
        if (aVar == null) {
            k.a("mBusFilterAmenitiesAdapter");
        }
        ArrayList arrayList = new ArrayList(aVar.f22009a);
        Iterable<CJRBusSearchAmenitiesInfo> iterable = arrayList;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo : iterable) {
            k.a((Object) cJRBusSearchAmenitiesInfo, "it");
            cJRBusSearchAmenitiesInfo.setSelected(false);
            arrayList2.add(x.f47997a);
        }
        com.travel.bus.busticket.busfilter.a.a aVar2 = this.f22053a;
        if (aVar2 == null) {
            k.a("mBusFilterAmenitiesAdapter");
        }
        aVar2.a((ArrayList<CJRBusSearchAmenitiesInfo>) arrayList);
        com.travel.bus.busticket.busfilter.b bVar = this.f22059h;
        if (bVar == null) {
            k.a("mBusFilterTabListener");
        }
        bVar.a(false, 3);
        c();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
