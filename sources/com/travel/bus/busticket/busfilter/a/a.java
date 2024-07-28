package com.travel.bus.busticket.busfilter.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.busticket.busfilter.d;
import com.travel.bus.busticket.busfilter.e;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class a extends RecyclerView.a<C0431a> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRBusSearchAmenitiesInfo> f22009a = this.f22013e;

    /* renamed from: b  reason: collision with root package name */
    public y<List<CJRBusSearchAmenitiesInfo>> f22010b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private b f22011c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final Context f22012d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<CJRBusSearchAmenitiesInfo> f22013e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final e f22014f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        String str2;
        C0431a aVar = (C0431a) vVar;
        k.c(aVar, "holder");
        CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = this.f22009a.get(i2);
        k.a((Object) cJRBusSearchAmenitiesInfo, "mAllAmenitiesInfo[position]");
        CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo2 = cJRBusSearchAmenitiesInfo;
        aVar.itemView.setOnClickListener(new c(this, cJRBusSearchAmenitiesInfo2));
        Context context = this.f22012d;
        k.c(cJRBusSearchAmenitiesInfo2, "amenitiesInfo");
        if (cJRBusSearchAmenitiesInfo2.getName() != null) {
            TextView textView = aVar.f22016b;
            if (textView != null) {
                if (context != null) {
                    int i3 = R.string.location_count;
                    Object[] objArr = new Object[2];
                    String label = cJRBusSearchAmenitiesInfo2.getLabel();
                    k.a((Object) label, "amenitiesInfo.label");
                    if (label != null) {
                        objArr[0] = p.b(label).toString();
                        objArr[1] = String.valueOf(cJRBusSearchAmenitiesInfo2.getCount());
                        str2 = context.getString(i3, objArr);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    str2 = null;
                }
                textView.setText(str2, TextView.BufferType.SPANNABLE);
            }
            if (cJRBusSearchAmenitiesInfo2.isSelected()) {
                str = cJRBusSearchAmenitiesInfo2.getIconSelected();
                k.a((Object) str, "amenitiesInfo.iconSelected");
                ImageView imageView = aVar.f22017c;
                if (imageView != null) {
                    imageView.setSelected(true);
                }
                TextView textView2 = aVar.f22016b;
                if (textView2 != null) {
                    textView2.setSelected(true);
                }
                ImageView imageView2 = aVar.f22017c;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.travel_res_bus_checkbox_button);
                }
            } else {
                str = cJRBusSearchAmenitiesInfo2.getIcon();
                k.a((Object) str, "amenitiesInfo.icon");
                ImageView imageView3 = aVar.f22017c;
                if (imageView3 != null) {
                    imageView3.setSelected(false);
                }
                TextView textView3 = aVar.f22016b;
                if (textView3 != null) {
                    textView3.setSelected(false);
                }
                ImageView imageView4 = aVar.f22017c;
                if (imageView4 != null) {
                    imageView4.setImageResource(R.drawable.travel_res_bus_check_box_default);
                }
            }
            if (URLUtil.isValidUrl(str)) {
                ImageView imageView5 = aVar.f22015a;
                k.a((Object) imageView5, "amenityIcon");
                if (imageView5.getDrawable() != null) {
                    b.a aVar2 = com.paytm.utility.b.b.f43744a;
                    ImageView imageView6 = aVar.f22015a;
                    k.a((Object) imageView6, "amenityIcon");
                    Context context2 = imageView6.getContext();
                    k.a((Object) context2, "amenityIcon.context");
                    b.a.C0750a a2 = b.a.a(context2);
                    a2.f43753a = str;
                    ImageView imageView7 = aVar.f22015a;
                    k.a((Object) imageView7, "amenityIcon");
                    Drawable drawable = imageView7.getDrawable();
                    k.a((Object) drawable, "amenityIcon.drawable");
                    b.a.C0750a b2 = a2.a((Object) drawable).b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity));
                    b2.m = true;
                    b.a.C0750a.a(b2, aVar.f22015a, (com.paytm.utility.b.b.b) null, 2);
                    return;
                }
                b.a aVar3 = com.paytm.utility.b.b.f43744a;
                ImageView imageView8 = aVar.f22015a;
                k.a((Object) imageView8, "amenityIcon");
                Context context3 = imageView8.getContext();
                k.a((Object) context3, "amenityIcon.context");
                b.a.C0750a a3 = b.a.a(context3);
                a3.f43753a = str;
                b.a.C0750a b3 = a3.b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity));
                b3.m = true;
                b.a.C0750a.a(b3, aVar.f22015a, (com.paytm.utility.b.b.b) null, 2);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new C0431a(this, d.a(viewGroup, R.layout.filter_amenity_item));
    }

    public a(Context context, ArrayList<CJRBusSearchAmenitiesInfo> arrayList, e eVar) {
        k.c(arrayList, "busSearchAmenitiesInfo");
        k.c(eVar, "onItemClickListener");
        this.f22012d = context;
        this.f22013e = arrayList;
        this.f22014f = eVar;
    }

    public final int getItemCount() {
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.f22009a;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f22009a.size();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22020a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRBusSearchAmenitiesInfo f22021b;

        c(a aVar, CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo) {
            this.f22020a = aVar;
            this.f22021b = cJRBusSearchAmenitiesInfo;
        }

        public final void onClick(View view) {
            this.f22020a.f22014f.a(this.f22021b);
        }
    }

    public final void a(ArrayList<CJRBusSearchAmenitiesInfo> arrayList) {
        k.c(arrayList, "allAmenities");
        this.f22009a.clear();
        this.f22009a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        return this.f22011c;
    }

    public final class b extends Filter {
        public b() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList(a.this.f22013e);
            if (charSequence != null) {
                if (charSequence.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = (CJRBusSearchAmenitiesInfo) it2.next();
                        String label = cJRBusSearchAmenitiesInfo.getLabel();
                        k.a((Object) label, "amenitiesInfo.label");
                        if (label != null) {
                            String upperCase = label.toUpperCase();
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
                                        arrayList2.add(cJRBusSearchAmenitiesInfo);
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
            a aVar = a.this;
            Object obj = filterResults.values;
            if (obj != null) {
                aVar.f22009a = (ArrayList) obj;
                a.this.f22010b.setValue(a.this.f22009a);
                a.this.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> /* = java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> */");
        }
    }

    /* renamed from: com.travel.bus.busticket.busfilter.a.a$a  reason: collision with other inner class name */
    public final class C0431a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final ImageView f22015a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f22016b;

        /* renamed from: c  reason: collision with root package name */
        final ImageView f22017c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f22018d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0431a(a aVar, View view) {
            super(view);
            k.c(view, "v");
            this.f22018d = aVar;
            this.f22015a = (ImageView) view.findViewById(R.id.filterAmenityIcon);
            this.f22016b = (TextView) view.findViewById(R.id.amenityLable);
            this.f22017c = (ImageView) view.findViewById(R.id.tickMark);
        }
    }
}
