package com.travel.flight.flightorder.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.travel.flight.R;
import java.util.ArrayList;

public final class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f24329a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f24330b;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f24329a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f24330b = arrayList;
    }

    public final int getCount() {
        return this.f24330b.size();
    }

    public final Object getItem(int i2) {
        return Integer.valueOf(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = this.f24329a.inflate(R.layout.pre_f_contact_all_reason_single_item, (ViewGroup) null);
            aVar.f24331a = (CheckedTextView) view2.findViewById(R.id.singleItem);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        aVar.f24331a.setText(this.f24330b.get(i2));
        return view2;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f24331a;

        a() {
        }
    }
}
