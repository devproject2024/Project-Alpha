package net.one97.paytm.o2o.amusementpark.c;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.l;
import net.one97.paytm.o2o.amusementpark.a.m;
import net.one97.paytm.o2o.amusementpark.utils.c;
import net.one97.paytm.o2o.amusementpark.utils.k;

public class g extends h {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public b f73563a;

    /* renamed from: b  reason: collision with root package name */
    boolean f73564b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<CJRSeatDetailsModel> f73565c = null;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.a f73566d = null;

    /* renamed from: e  reason: collision with root package name */
    private View f73567e = null;

    /* renamed from: f  reason: collision with root package name */
    private View f73568f = null;

    /* renamed from: g  reason: collision with root package name */
    private View f73569g = null;

    /* renamed from: h  reason: collision with root package name */
    private View f73570h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public List<RecyclerView.v> f73571i = null;
    private String j;
    private String k;
    /* access modifiers changed from: private */
    public int l = 0;
    private String m;
    /* access modifiers changed from: private */
    public ExpandableListView n;
    /* access modifiers changed from: private */
    public l o;
    private HashMap<net.one97.paytm.o2o.amusementpark.c.b.a, List<CJRSeatDetailsModel>> p;
    private List<net.one97.paytm.o2o.amusementpark.c.b.a> q;
    /* access modifiers changed from: private */
    public a r;
    private View.OnClickListener s = new View.OnClickListener() {
        public final void onClick(View view) {
            int id = view.getId();
            if (id == R.id.btn_continue) {
                k.b(view.getContext(), 4, g.this.f());
                if (g.this.f73563a != null) {
                    g.this.f73563a.b(g.this.b());
                }
            } else if (id == R.id.layout_minimized_seats_info_container) {
                g.g(g.this);
            }
        }
    };
    private m.a t = new m.a() {
        public final void a(int i2, int i3) {
            a(i2, (CJRSeatDetailsModel) g.this.f73565c.get(i3));
        }

        public final void b(int i2, int i3) {
            a(i2, (CJRSeatDetailsModel) g.this.f73565c.get(i3));
            g.d(g.this);
        }

        public final RecyclerView.v a(int i2) {
            if (i2 < 0 || i2 >= g.this.f73565c.size()) {
                return null;
            }
            return (RecyclerView.v) g.this.f73571i.get(i2);
        }

        private void a(int i2, CJRSeatDetailsModel cJRSeatDetailsModel) {
            if (cJRSeatDetailsModel != null) {
                g gVar = g.this;
                int unused = gVar.l = gVar.l + (i2 - cJRSeatDetailsModel.getSelectedQuantity());
                cJRSeatDetailsModel.setSelectedQuantity(cJRSeatDetailsModel.getSelectedQuantityAtStart());
            }
        }
    };

    public interface a {
        void a();
    }

    public interface b {
        void a(List<CJRSeatDetailsModel> list);

        void b();

        void b(List<CJRSeatDetailsModel> list);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Integer num;
        Integer num2;
        View inflate = layoutInflater.inflate(R.layout.layout_am_park_seat_selection_fragment, (ViewGroup) null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73565c = (List) arguments.getSerializable("event-seat-selection-fragment-key-seat-list");
            c.a(this.f73565c);
            this.m = arguments.getString("seat-summay-state");
            this.j = arguments.getString("title");
            this.k = arguments.getString("category");
        }
        this.f73567e = inflate.findViewById(R.id.layout_maximized_seats_info_container);
        this.f73568f = inflate.findViewById(R.id.layout_minimized_seats_info_container);
        this.f73569g = inflate.findViewById(R.id.btn_continue);
        this.f73570h = this.f73568f.findViewById(R.id.iv_maximize_package_info);
        this.n = (ExpandableListView) this.f73567e.findViewById(R.id.simple_expandable_listview);
        this.n.setGroupIndicator((Drawable) null);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        List<CJRSeatDetailsModel> list = this.f73565c;
        if (list != null && list.size() > 0) {
            for (CJRSeatDetailsModel next : this.f73565c) {
                if (!a(next, (List<net.one97.paytm.o2o.amusementpark.c.b.a>) arrayList)) {
                    net.one97.paytm.o2o.amusementpark.c.b.a aVar = new net.one97.paytm.o2o.amusementpark.c.b.a();
                    aVar.setmPackageType(next.getmPackageType());
                    aVar.setPackageDescription(next.getmPackageDescription());
                    arrayList.add(aVar);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(Integer.valueOf(next.getPrice()));
                    hashMap.put(next.getmPackageType(), arrayList2);
                } else {
                    List list2 = (List) hashMap.get(next.getmPackageType());
                    list2.add(Integer.valueOf(next.getPrice()));
                    hashMap.put(next.getmPackageType(), list2);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            List list3 = (List) hashMap.get(((net.one97.paytm.o2o.amusementpark.c.b.a) arrayList.get(i2)).getmPackageType());
            if (list3 == null || list3.size() == 0) {
                num = Integer.MAX_VALUE;
            } else {
                num = (Integer) Collections.min(list3);
            }
            int intValue = num.intValue();
            if (list3 == null || list3.size() == 0) {
                num2 = Integer.MIN_VALUE;
            } else {
                num2 = (Integer) Collections.max(list3);
            }
            ((net.one97.paytm.o2o.amusementpark.c.b.a) arrayList.get(i2)).setMaxPrice(num2.intValue());
            ((net.one97.paytm.o2o.amusementpark.c.b.a) arrayList.get(i2)).setMinPrice(intValue);
        }
        this.q = arrayList;
        this.p = c();
        this.r = new a() {
            public final void a() {
                if (g.this.o != null) {
                    g gVar = g.this;
                    l b2 = gVar.o;
                    int i2 = 0;
                    if (b2.f73207b != null) {
                        for (Map.Entry<net.one97.paytm.o2o.amusementpark.c.b.a, List<CJRSeatDetailsModel>> value : b2.f73207b.entrySet()) {
                            List<CJRSeatDetailsModel> list = (List) value.getValue();
                            if (list != null && list.size() > 0) {
                                for (CJRSeatDetailsModel cJRSeatDetailsModel : list) {
                                    if (cJRSeatDetailsModel.getSelectedQuantity() > 0) {
                                        i2 += cJRSeatDetailsModel.getSelectedQuantity();
                                    }
                                }
                            }
                        }
                    }
                    int unused = gVar.l = i2;
                    g.d(g.this);
                }
            }
        };
        this.o = new l(getContext(), this.q, this.p, this.r);
        this.n.setAdapter(this.o);
        int a2 = this.o.a();
        if (a2 != -1) {
            this.n.expandGroup(a2);
            this.r.a();
        }
        this.n.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            /* renamed from: a  reason: collision with root package name */
            int f73572a = 0;

            public final void onGroupExpand(int i2) {
                if (i2 != this.f73572a) {
                    g.this.n.collapseGroup(this.f73572a);
                }
                this.f73572a = i2;
                l b2 = g.this.o;
                int i3 = 0;
                while (i3 < b2.f73206a.size() && i3 != i2) {
                    for (int i4 = 0; i4 < b2.f73207b.get(b2.f73206a.get(i3)).size(); i4++) {
                        ((CJRSeatDetailsModel) b2.f73207b.get(b2.f73206a.get(i3)).get(i4)).setSelectedQuantity(0);
                    }
                    i3++;
                }
                if (g.this.r != null) {
                    g.this.r.a();
                }
            }
        });
        this.f73569g.setOnClickListener(this.s);
        this.f73568f.setOnClickListener(this.s);
        if ("minimized".equals(this.m)) {
            d();
        }
        k.a(viewGroup.getContext(), 4, f());
        return inflate;
    }

    private static boolean a(CJRSeatDetailsModel cJRSeatDetailsModel, List<net.one97.paytm.o2o.amusementpark.c.b.a> list) {
        if (list.size() == 0) {
            return false;
        }
        for (net.one97.paytm.o2o.amusementpark.c.b.a aVar : list) {
            if (aVar.getmPackageType().equalsIgnoreCase(cJRSeatDetailsModel.getmPackageType())) {
                return true;
            }
        }
        return false;
    }

    private HashMap<net.one97.paytm.o2o.amusementpark.c.b.a, List<CJRSeatDetailsModel>> c() {
        HashMap<net.one97.paytm.o2o.amusementpark.c.b.a, List<CJRSeatDetailsModel>> hashMap = new HashMap<>();
        for (net.one97.paytm.o2o.amusementpark.c.b.a next : this.q) {
            ArrayList arrayList = new ArrayList();
            for (CJRSeatDetailsModel next2 : this.f73565c) {
                if (next.getmPackageType().equalsIgnoreCase(next2.getmPackageType())) {
                    arrayList.add(next2);
                }
            }
            hashMap.put(next, arrayList);
        }
        return hashMap;
    }

    private void a(int i2) {
        this.f73567e.setVisibility(i2);
        this.f73569g.setVisibility(i2);
    }

    private void b(int i2) {
        this.f73568f.setVisibility(i2);
    }

    public final void a() {
        d();
        List<CJRSeatDetailsModel> b2 = b();
        b bVar = this.f73563a;
        if (bVar != null) {
            bVar.a(b2);
        }
        this.f73569g.setVisibility(8);
    }

    private void d() {
        this.f73564b = true;
        a(8);
        b(0);
        a(b());
        e();
    }

    public final List<CJRSeatDetailsModel> b() {
        ArrayList arrayList = new ArrayList();
        HashMap<net.one97.paytm.o2o.amusementpark.c.b.a, List<CJRSeatDetailsModel>> hashMap = this.p;
        if (hashMap != null) {
            this.l = 0;
            for (Map.Entry<net.one97.paytm.o2o.amusementpark.c.b.a, List<CJRSeatDetailsModel>> value : hashMap.entrySet()) {
                List<CJRSeatDetailsModel> list = (List) value.getValue();
                if (list != null && list.size() > 0) {
                    for (CJRSeatDetailsModel cJRSeatDetailsModel : list) {
                        if (cJRSeatDetailsModel.getSelectedQuantity() > 0) {
                            this.l += cJRSeatDetailsModel.getSelectedQuantity();
                            arrayList.add(cJRSeatDetailsModel);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void e() {
        TextView textView = (TextView) this.f73568f.findViewById(R.id.tv_tckts_count);
        if (isAdded()) {
            textView.setText(this.l + " " + getString(R.string.text_tickets));
        }
    }

    private void a(List<CJRSeatDetailsModel> list) {
        try {
            ((TextView) this.f73568f.findViewById(R.id.tv_tckts_desc)).setText(c.b(list));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public String f() {
        if (getArguments() == null) {
            return "";
        }
        return getArguments().getString("park_id");
    }

    static /* synthetic */ void d(g gVar) {
        if (gVar.l > 0) {
            gVar.f73569g.setVisibility(0);
        } else {
            gVar.f73569g.setVisibility(8);
        }
    }

    static /* synthetic */ void g(g gVar) {
        gVar.f73564b = false;
        gVar.a(0);
        gVar.b(8);
        b bVar = gVar.f73563a;
        if (bVar != null) {
            bVar.b();
        }
    }
}
