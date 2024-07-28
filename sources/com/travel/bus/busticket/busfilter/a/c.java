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
import com.travel.bus.pojo.CJRBusSearchOperatorInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRTravelName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class c extends RecyclerView.a<b> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRTravelName> f22036a = this.f22040e;

    /* renamed from: b  reason: collision with root package name */
    public y<List<CJRTravelName>> f22037b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private a f22038c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final Context f22039d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<CJRTravelName> f22040e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<CJRBusSearchItem> f22041f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final e f22042g;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        String str;
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        CJRTravelName cJRTravelName = this.f22036a.get(i2);
        k.a((Object) cJRTravelName, "mAllFilteredOperator[position]");
        CJRTravelName cJRTravelName2 = cJRTravelName;
        bVar.itemView.setOnClickListener(new C0433c(this, cJRTravelName2));
        Context context = this.f22039d;
        ArrayList<CJRBusSearchItem> arrayList = this.f22041f;
        k.c(cJRTravelName2, "travelName");
        k.c(arrayList, "busSearchItem");
        if (cJRTravelName2.getTravelsName() != null) {
            Iterable<CJRBusSearchItem> iterable = arrayList;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                i3 = 0;
                for (CJRBusSearchItem operatorObj : iterable) {
                    CJRBusSearchOperatorInfo operatorObj2 = operatorObj.getOperatorObj();
                    k.a((Object) operatorObj2, "it.operatorObj");
                    String name = operatorObj2.getName();
                    k.a((Object) name, "it.operatorObj.name");
                    if (name != null) {
                        String upperCase = name.toUpperCase();
                        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        if (upperCase != null) {
                            String obj = p.b(upperCase).toString();
                            String travelsName = cJRTravelName2.getTravelsName();
                            k.a((Object) travelsName, "travelName.travelsName");
                            if (travelsName != null) {
                                String upperCase2 = travelsName.toUpperCase();
                                k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                                if (upperCase2 == null) {
                                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                                } else if (k.a((Object) obj, (Object) p.b(upperCase2).toString()) && (i3 = i3 + 1) < 0) {
                                    kotlin.a.k.b();
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
            } else {
                i3 = 0;
            }
            TextView textView = bVar.f22044a;
            if (textView != null) {
                if (context != null) {
                    int i4 = R.string.location_count;
                    Object[] objArr = new Object[2];
                    String travelsName2 = cJRTravelName2.getTravelsName();
                    k.a((Object) travelsName2, "travelName.travelsName");
                    if (travelsName2 != null) {
                        objArr[0] = p.b(travelsName2).toString();
                        objArr[1] = String.valueOf(i3);
                        str = context.getString(i4, objArr);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    str = null;
                }
                textView.setText(str, TextView.BufferType.SPANNABLE);
            }
            if (cJRTravelName2.isFilterSelected()) {
                ImageView imageView = bVar.f22045b;
                if (imageView != null) {
                    imageView.setSelected(true);
                }
                TextView textView2 = bVar.f22044a;
                if (textView2 != null) {
                    textView2.setSelected(true);
                }
                ImageView imageView2 = bVar.f22045b;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.travel_res_bus_checkbox_button);
                    return;
                }
                return;
            }
            ImageView imageView3 = bVar.f22045b;
            if (imageView3 != null) {
                imageView3.setSelected(false);
            }
            TextView textView3 = bVar.f22044a;
            if (textView3 != null) {
                textView3.setSelected(false);
            }
            ImageView imageView4 = bVar.f22045b;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.travel_res_bus_check_box_default);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new b(this, d.a(viewGroup, R.layout.filter_location_item));
    }

    public c(Context context, ArrayList<CJRTravelName> arrayList, ArrayList<CJRBusSearchItem> arrayList2, e eVar) {
        k.c(arrayList, "allOperatorList");
        k.c(arrayList2, "busSearchItem");
        k.c(eVar, "onItemClickListener");
        this.f22039d = context;
        this.f22040e = arrayList;
        this.f22041f = arrayList2;
        this.f22042g = eVar;
    }

    public final int getItemCount() {
        return this.f22036a.size();
    }

    /* renamed from: com.travel.bus.busticket.busfilter.a.c$c  reason: collision with other inner class name */
    static final class C0433c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22047a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRTravelName f22048b;

        C0433c(c cVar, CJRTravelName cJRTravelName) {
            this.f22047a = cVar;
            this.f22048b = cJRTravelName;
        }

        public final void onClick(View view) {
            this.f22047a.f22042g.a(this.f22048b);
        }
    }

    public final void a(ArrayList<CJRTravelName> arrayList) {
        k.c(arrayList, "allList");
        this.f22036a.clear();
        this.f22036a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        return this.f22038c;
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f22044a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f22045b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f22046c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, View view) {
            super(view);
            k.c(view, "v");
            this.f22046c = cVar;
            this.f22044a = (TextView) view.findViewById(R.id.ticked_text);
            this.f22045b = (ImageView) view.findViewById(R.id.img_tick);
        }
    }

    public final class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList(c.this.f22040e);
            if (charSequence != null) {
                if (charSequence.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CJRTravelName cJRTravelName = (CJRTravelName) it2.next();
                        String travelsName = cJRTravelName.getTravelsName();
                        k.a((Object) travelsName, "operatorInfo.travelsName");
                        if (travelsName != null) {
                            String upperCase = travelsName.toUpperCase();
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
                                        arrayList2.add(cJRTravelName);
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
            c cVar = c.this;
            Object obj = filterResults.values;
            if (obj != null) {
                cVar.f22036a = (ArrayList) obj;
                c.this.f22037b.setValue(c.this.f22036a);
                c.this.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.bus.pojo.busticket.CJRTravelName> /* = java.util.ArrayList<com.travel.bus.pojo.busticket.CJRTravelName> */");
        }
    }
}
