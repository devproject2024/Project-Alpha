package com.travel.flight.flightticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.travel.flight.R;
import java.util.List;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValue;

public final class b extends com.travel.flight.a.a implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private Context f24608a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f24609b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRDynamicValue> f24610c;

    /* renamed from: d  reason: collision with root package name */
    private List<CJRDynamicValue> f24611d;

    public b(Context context, List<CJRDynamicValue> list) {
        this.f24610c = list;
        this.f24611d = list;
        this.f24608a = context;
        this.f24609b = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.f24611d.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public CJRDynamicValue getItem(int i2) {
        return this.f24611d.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) this.f24611d.get(i2).hashCode();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f24609b.inflate(R.layout.pre_f_layout_flight_dropdown_view, (ViewGroup) null);
            a aVar = new a();
            aVar.f24613a = (TextView) view.findViewById(R.id.txt_value);
            view.setTag(aVar);
        }
        ((a) view.getTag()).f24613a.setText(getItem(i2).getValue());
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

    public class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f24613a;

        public a() {
        }
    }
}
