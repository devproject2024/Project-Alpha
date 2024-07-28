package com.travel.train.b;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.travel.train.R;
import com.travel.train.i.y;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import com.travel.train.viewholder.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class as extends a implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f26320a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f26321b;

    /* renamed from: c  reason: collision with root package name */
    public int f26322c;

    /* renamed from: d  reason: collision with root package name */
    private Context f26323d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f26324e;

    /* renamed from: f  reason: collision with root package name */
    private Filter f26325f;

    /* renamed from: g  reason: collision with root package name */
    private y f26326g;

    /* renamed from: h  reason: collision with root package name */
    private View f26327h;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public as(Context context, ArrayList<CJRTpUserProfileContact> arrayList, y yVar, View view, int i2) {
        this.f26323d = context;
        this.f26320a = arrayList;
        this.f26326g = yVar;
        this.f26321b = new ArrayList<>();
        this.f26321b.addAll(this.f26320a);
        this.f26324e = LayoutInflater.from(context);
        this.f26327h = view;
        this.f26322c = i2;
    }

    public final void a(ArrayList<CJRTpUserProfileContact> arrayList, Editable editable) {
        this.f26320a = new ArrayList<>(arrayList);
        if (editable == null || editable.length() <= 0) {
            this.f26321b = new ArrayList<>(arrayList);
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.f26321b.size();
    }

    /* renamed from: a */
    public final CJRTpUserProfileContact getItem(int i2) {
        return this.f26321b.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        bo boVar;
        if (view == null) {
            view = this.f26324e.inflate(R.layout.pre_t_layout_train_traveller_list_item, (ViewGroup) null);
            boVar = new bo(this.f26323d, view, this.f26326g, this.f26327h);
            view.setTag(boVar);
        } else {
            boVar = (bo) view.getTag();
        }
        CJRTpUserProfileContact cJRTpUserProfileContact = this.f26321b.get(i2);
        boVar.f28041a.setText(cJRTpUserProfileContact.getFullname());
        TextView textView = boVar.f28042b;
        textView.setText("(" + cJRTpUserProfileContact.getAge() + ", " + bo.a(cJRTpUserProfileContact.getGender()) + ")");
        TextView textView2 = boVar.f28045e;
        StringBuilder sb = new StringBuilder("Are you sure you want to delete ");
        sb.append(cJRTpUserProfileContact.getFullname());
        sb.append(" ?");
        textView2.setText(sb.toString());
        boVar.f28044d.setTag(cJRTpUserProfileContact);
        boVar.f28044d.setVisibility(8);
        return view;
    }

    public final Filter getFilter() {
        if (this.f26325f == null) {
            this.f26325f = new a();
        }
        return this.f26325f;
    }

    public class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (TextUtils.isEmpty(charSequence) || charSequence.toString().length() == 0) {
                filterResults.values = as.this.f26320a;
                filterResults.count = as.this.f26320a.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<CJRTpUserProfileContact> it2 = as.this.f26320a.iterator();
                while (it2.hasNext()) {
                    CJRTpUserProfileContact next = it2.next();
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
                ArrayList unused = as.this.f26321b = (ArrayList) filterResults.values;
                as.this.notifyDataSetChanged();
            }
        }
    }
}
