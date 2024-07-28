package com.travel.flight.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.travel.flight.R;
import java.util.ArrayList;

public final class b extends a implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f23486a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f23487b;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public b(Activity activity, ArrayList<String> arrayList) {
        this.f23486a = LayoutInflater.from(activity);
        if (arrayList != null && arrayList.size() > 0) {
            this.f23487b = arrayList;
        }
    }

    public final int getCount() {
        ArrayList<String> arrayList = this.f23487b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Object getItem(int i2) {
        return this.f23487b.get(i2);
    }

    public final int getViewTypeCount() {
        return this.f23487b.size();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f23486a.inflate(R.layout.pre_f_flight_review_layout_auto_complete, (ViewGroup) null);
            aVar = new a(this, (byte) 0);
            aVar.f23489a = (TextView) view.findViewById(R.id.passport_issue_country_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = this.f23487b.get(i2);
        if (str != null) {
            aVar.f23489a.setText(str);
        } else {
            aVar.f23489a.setText("");
        }
        return view;
    }

    public final Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                return null;
            }

            /* access modifiers changed from: protected */
            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            }
        };
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f23489a;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }
    }
}
