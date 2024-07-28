package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.travel.train.R;
import com.travel.train.model.trainticket.CJRCountrys;
import java.util.ArrayList;

public final class d extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private Context f26374a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRCountrys> f26375b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f26376c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRCountrys> f26377d;

    /* renamed from: e  reason: collision with root package name */
    private a f26378e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b f26379f;

    public interface b {
        void a(boolean z);
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public d(Context context, ArrayList<CJRCountrys> arrayList, b bVar) {
        this.f26374a = context;
        this.f26375b = arrayList;
        this.f26377d = arrayList;
        this.f26379f = bVar;
        this.f26376c = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.f26375b.size();
    }

    /* renamed from: a */
    public final CJRCountrys getItem(int i2) {
        return this.f26375b.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        c cVar;
        if (view == null) {
            cVar = new c(this, (byte) 0);
            view2 = this.f26376c.inflate(R.layout.pre_t_train_country_search_layout, (ViewGroup) null);
            cVar.f26381a = (TextView) view2.findViewById(R.id.country_name);
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        cVar.f26381a.setText(this.f26375b.get(i2).getCountry());
        return view2;
    }

    public final Filter getFilter() {
        if (this.f26378e == null) {
            this.f26378e = new a(this, (byte) 0);
        }
        return this.f26378e;
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        TextView f26381a;

        private c() {
        }

        /* synthetic */ c(d dVar, byte b2) {
            this();
        }
    }

    class a extends Filter {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() <= 0) {
                filterResults.count = d.this.f26377d.size();
                filterResults.values = d.this.f26377d;
            } else {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < d.this.f26377d.size(); i2++) {
                    if (((CJRCountrys) d.this.f26377d.get(i2)).getCountry().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        CJRCountrys cJRCountrys = new CJRCountrys();
                        cJRCountrys.setCountry(((CJRCountrys) d.this.f26377d.get(i2)).getCountry());
                        cJRCountrys.setCountryId(((CJRCountrys) d.this.f26377d.get(i2)).getCountryId());
                        arrayList.add(cJRCountrys);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults != null) {
                if (d.this.f26379f != null) {
                    if (filterResults.count == 0) {
                        d.this.f26379f.a(true);
                    } else {
                        d.this.f26379f.a(false);
                    }
                }
                ArrayList unused = d.this.f26375b = (ArrayList) filterResults.values;
                d.this.notifyDataSetChanged();
            }
        }
    }
}
