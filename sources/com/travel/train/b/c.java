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
import com.travel.train.b.d;
import com.travel.train.model.trainticket.CJRCountryCode;
import java.util.ArrayList;

public final class c extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private Context f26365a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRCountryCode> f26366b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f26367c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRCountryCode> f26368d;

    /* renamed from: e  reason: collision with root package name */
    private a f26369e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public d.b f26370f;

    public final long getItemId(int i2) {
        return 0;
    }

    public c(Context context, ArrayList<CJRCountryCode> arrayList, d.b bVar) {
        this.f26365a = context;
        this.f26366b = arrayList;
        this.f26368d = arrayList;
        this.f26370f = bVar;
        this.f26367c = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.f26366b.size();
    }

    /* renamed from: a */
    public final CJRCountryCode getItem(int i2) {
        return this.f26366b.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b(this, (byte) 0);
            view2 = this.f26367c.inflate(R.layout.pre_t_train_country_search_layout, (ViewGroup) null);
            bVar.f26372a = (TextView) view2.findViewById(R.id.country_name);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        bVar.f26372a.setText(this.f26366b.get(i2).getCountryName());
        return view2;
    }

    public final Filter getFilter() {
        if (this.f26369e == null) {
            this.f26369e = new a(this, (byte) 0);
        }
        return this.f26369e;
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f26372a;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }
    }

    class a extends Filter {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() <= 0) {
                filterResults.count = c.this.f26368d.size();
                filterResults.values = c.this.f26368d;
            } else {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < c.this.f26368d.size(); i2++) {
                    if (((CJRCountryCode) c.this.f26368d.get(i2)).getCountryName().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        CJRCountryCode cJRCountryCode = new CJRCountryCode();
                        cJRCountryCode.setCountryName(((CJRCountryCode) c.this.f26368d.get(i2)).getCountryName());
                        cJRCountryCode.setCountryCode(((CJRCountryCode) c.this.f26368d.get(i2)).getCountryCode());
                        arrayList.add(cJRCountryCode);
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
                if (c.this.f26370f != null) {
                    if (filterResults.count == 0) {
                        c.this.f26370f.a(true);
                    } else {
                        c.this.f26370f.a(false);
                    }
                }
                ArrayList unused = c.this.f26366b = (ArrayList) filterResults.values;
                c.this.notifyDataSetChanged();
            }
        }
    }
}
