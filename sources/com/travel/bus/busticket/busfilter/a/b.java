package com.travel.bus.busticket.busfilter.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.busticket.busfilter.d;
import com.travel.bus.busticket.busfilter.e;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemBoardDropCount;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class b extends RecyclerView.a<a> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRLocation> f22022a = this.f22028g;

    /* renamed from: b  reason: collision with root package name */
    public y<List<CJRLocation>> f22023b;

    /* renamed from: c  reason: collision with root package name */
    public final int f22024c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, CJRBusSearchItemBoardDropCount> f22025d;

    /* renamed from: e  reason: collision with root package name */
    private C0432b f22026e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f22027f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<CJRLocation> f22028g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final e f22029h;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        CJRLocation cJRLocation = this.f22022a.get(i2);
        k.a((Object) cJRLocation, "mAllFilteredLocations[position]");
        CJRLocation cJRLocation2 = cJRLocation;
        CJRBusSearchItemBoardDropCount cJRBusSearchItemBoardDropCount = this.f22025d.get(cJRLocation2.getLocationName());
        String str = null;
        Integer count = cJRBusSearchItemBoardDropCount != null ? cJRBusSearchItemBoardDropCount.getCount() : null;
        aVar.itemView.setOnClickListener(new c(this, cJRLocation2));
        Context context = this.f22027f;
        k.c(cJRLocation2, "location");
        if (cJRLocation2.getLocationName() != null) {
            TextView textView = aVar.f22030a;
            if (textView != null) {
                if (context != null) {
                    int i3 = R.string.location_count;
                    Object[] objArr = new Object[2];
                    String locationName = cJRLocation2.getLocationName();
                    k.a((Object) locationName, "location.locationName");
                    if (locationName != null) {
                        objArr[0] = p.b(locationName).toString();
                        objArr[1] = String.valueOf(count);
                        str = context.getString(i3, objArr);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                textView.setText(str, TextView.BufferType.SPANNABLE);
            }
            if (cJRLocation2.isFilterSelected()) {
                ImageView imageView = aVar.f22031b;
                if (imageView != null) {
                    imageView.setSelected(true);
                }
                TextView textView2 = aVar.f22030a;
                if (textView2 != null) {
                    textView2.setSelected(true);
                }
                ImageView imageView2 = aVar.f22031b;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.travel_res_bus_checkbox_button);
                    return;
                }
                return;
            }
            ImageView imageView3 = aVar.f22031b;
            if (imageView3 != null) {
                imageView3.setSelected(false);
            }
            TextView textView3 = aVar.f22030a;
            if (textView3 != null) {
                textView3.setSelected(false);
            }
            ImageView imageView4 = aVar.f22031b;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.travel_res_bus_check_box_default);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new a(this, d.a(viewGroup, R.layout.filter_location_item));
    }

    public b(Context context, ArrayList<CJRLocation> arrayList, int i2, e eVar, HashMap<String, CJRBusSearchItemBoardDropCount> hashMap) {
        k.c(arrayList, "allLocationList");
        k.c(eVar, "itemClickListener");
        k.c(hashMap, "allBPDPPointList");
        this.f22027f = context;
        this.f22028g = arrayList;
        this.f22024c = i2;
        this.f22029h = eVar;
        this.f22025d = hashMap;
        this.f22026e = new C0432b();
        this.f22023b = new y<>();
    }

    public final int getItemCount() {
        ArrayList<CJRLocation> arrayList = this.f22022a;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f22022a.size();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f22034a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRLocation f22035b;

        c(b bVar, CJRLocation cJRLocation) {
            this.f22034a = bVar;
            this.f22035b = cJRLocation;
        }

        public final void onClick(View view) {
            this.f22034a.f22029h.a(this.f22035b);
        }
    }

    public final void a(ArrayList<CJRLocation> arrayList) {
        k.c(arrayList, "allLocations");
        this.f22022a.clear();
        this.f22022a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        return this.f22026e;
    }

    /* renamed from: com.travel.bus.busticket.busfilter.a.b$b  reason: collision with other inner class name */
    public final class C0432b extends Filter {
        public C0432b() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList(b.this.f22028g);
            if (charSequence != null) {
                if (charSequence.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CJRLocation cJRLocation = (CJRLocation) it2.next();
                        String locationName = cJRLocation.getLocationName();
                        k.a((Object) locationName, "location.locationName");
                        if (locationName != null) {
                            String upperCase = locationName.toUpperCase();
                            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                            if (upperCase != null) {
                                String obj = p.b(upperCase).toString();
                                String obj2 = charSequence.toString();
                                if (obj2 != null) {
                                    String upperCase2 = obj2.toUpperCase();
                                    k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                                    if (upperCase2 == null) {
                                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                                    } else if (p.b(obj, p.b(upperCase2).toString(), false)) {
                                        if (charSequence.length() > 6) {
                                            cJRLocation.setFilterSelected(true);
                                        } else if (charSequence.length() > 5) {
                                            cJRLocation.setFilterSelected(false);
                                        }
                                        arrayList2.add(cJRLocation);
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    filterResults.count = arrayList2.size();
                    filterResults.values = arrayList2;
                    return filterResults;
                }
            }
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            k.c(charSequence, "constraint");
            k.c(filterResults, "results");
            b bVar = b.this;
            Object obj = filterResults.values;
            if (obj != null) {
                bVar.f22022a = (ArrayList) obj;
                b.this.f22023b.setValue(b.this.f22022a);
                b.this.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.bus.pojo.busticket.CJRLocation> /* = java.util.ArrayList<com.travel.bus.pojo.busticket.CJRLocation> */");
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f22030a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f22031b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f22032c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            k.c(view, "v");
            this.f22032c = bVar;
            this.f22030a = (TextView) view.findViewById(R.id.ticked_text);
            this.f22031b = (ImageView) view.findViewById(R.id.img_tick);
        }
    }
}
