package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.travel.bus.R;
import com.travel.bus.busticket.b.f;
import com.travel.bus.busticket.e.p;
import com.travel.bus.pojo.common.entity.travel.CJRBusTpUserProfileContact;
import java.util.ArrayList;
import java.util.Iterator;

public final class z extends e implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRBusTpUserProfileContact> f21808a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRBusTpUserProfileContact> f21809b;

    /* renamed from: c  reason: collision with root package name */
    public int f21810c;

    /* renamed from: d  reason: collision with root package name */
    private Context f21811d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f21812e;

    /* renamed from: f  reason: collision with root package name */
    private Filter f21813f;

    /* renamed from: g  reason: collision with root package name */
    private f f21814g;

    /* renamed from: h  reason: collision with root package name */
    private View f21815h;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public z(Context context, ArrayList<CJRBusTpUserProfileContact> arrayList, f fVar, View view, int i2) {
        this.f21811d = context;
        this.f21808a = arrayList;
        this.f21814g = fVar;
        this.f21809b = new ArrayList<>();
        this.f21809b.addAll(this.f21808a);
        this.f21812e = LayoutInflater.from(context);
        this.f21815h = view;
        this.f21810c = i2;
    }

    public final void a(ArrayList<CJRBusTpUserProfileContact> arrayList, Editable editable) {
        this.f21808a = new ArrayList<>(arrayList);
        if (editable == null || editable.length() <= 0) {
            this.f21809b = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void a(ArrayList<CJRBusTpUserProfileContact> arrayList) {
        this.f21808a.clear();
        this.f21808a = arrayList;
        this.f21809b.clear();
        this.f21809b.addAll(this.f21808a);
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.f21809b.size();
    }

    /* renamed from: a */
    public final CJRBusTpUserProfileContact getItem(int i2) {
        return this.f21809b.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        p pVar;
        if (view == null) {
            view = this.f21812e.inflate(R.layout.pre_b_layout_bus_traveller_list_item, (ViewGroup) null);
            pVar = new p(this.f21811d, view, this.f21814g, this.f21815h);
            view.setTag(pVar);
        } else {
            pVar = (p) view.getTag();
        }
        CJRBusTpUserProfileContact cJRBusTpUserProfileContact = this.f21809b.get(i2);
        TextView textView = pVar.f22197a;
        textView.setText(cJRBusTpUserProfileContact.getFullname() + "  (" + cJRBusTpUserProfileContact.getAge() + ", " + cJRBusTpUserProfileContact.getGender() + ")");
        pVar.f22199c.setTag(cJRBusTpUserProfileContact);
        TextView textView2 = pVar.f22200d;
        textView2.setText(pVar.f22203g.getString(R.string.are_you_sure_delete) + " " + cJRBusTpUserProfileContact.getFullname() + " ?");
        pVar.f22199c.setVisibility(8);
        return view;
    }

    public final Filter getFilter() {
        if (this.f21813f == null) {
            this.f21813f = new a();
        }
        return this.f21813f;
    }

    public class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (TextUtils.isEmpty(charSequence) || charSequence.toString().length() == 0) {
                filterResults.values = z.this.f21808a;
                filterResults.count = z.this.f21808a.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<CJRBusTpUserProfileContact> it2 = z.this.f21808a.iterator();
                while (it2.hasNext()) {
                    CJRBusTpUserProfileContact next = it2.next();
                    if (next.getFullname().toLowerCase().startsWith(String.valueOf(charSequence).toLowerCase())) {
                        arrayList.add(next);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults != null && filterResults.values != null) {
                ArrayList unused = z.this.f21809b = (ArrayList) filterResults.values;
                z.this.notifyDataSetChanged();
            }
        }
    }
}
