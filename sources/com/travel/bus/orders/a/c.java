package com.travel.bus.orders.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.travel.bus.R;
import java.util.ArrayList;

public final class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f22563a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f22564b;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public c(Context context, ArrayList<String> arrayList) {
        this.f22563a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f22564b = arrayList;
    }

    public final int getCount() {
        return this.f22564b.size();
    }

    public final Object getItem(int i2) {
        return Integer.valueOf(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = this.f22563a.inflate(R.layout.pre_b_contact_all_reason_single_item, (ViewGroup) null);
            aVar.f22565a = (CheckedTextView) view2.findViewById(R.id.singleItem);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        aVar.f22565a.setText(this.f22564b.get(i2));
        return view2;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f22565a;

        a() {
        }
    }
}
