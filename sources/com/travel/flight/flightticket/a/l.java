package com.travel.flight.flightticket.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.g;
import com.travel.flight.flightticket.j.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;

public final class l extends com.travel.flight.a.a implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f24693a;

    /* renamed from: b  reason: collision with root package name */
    public int f24694b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24695c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f24696d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f24697e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private Filter f24698f;

    /* renamed from: g  reason: collision with root package name */
    private g f24699g;

    /* renamed from: h  reason: collision with root package name */
    private View f24700h;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public l(Context context, ArrayList<CJRTpUserProfileContact> arrayList, g gVar, View view, int i2) {
        this.f24695c = context;
        this.f24697e.addAll(arrayList);
        this.f24699g = gVar;
        this.f24693a = new ArrayList<>();
        this.f24693a.addAll(this.f24697e);
        this.f24696d = LayoutInflater.from(context);
        this.f24700h = view;
        this.f24694b = i2;
    }

    public final void a(ArrayList<CJRTpUserProfileContact> arrayList) {
        this.f24693a.clear();
        this.f24693a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.f24693a.size();
    }

    /* renamed from: a */
    public final CJRTpUserProfileContact getItem(int i2) {
        return this.f24693a.get(i2);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        q qVar;
        if (view == null) {
            view = this.f24696d.inflate(R.layout.pre_f_layout_filght_traveller_list_item, (ViewGroup) null);
            qVar = new q(this.f24695c, view, this.f24699g, this.f24700h);
            view.setTag(qVar);
        } else {
            qVar = (q) view.getTag();
        }
        CJRTpUserProfileContact cJRTpUserProfileContact = this.f24693a.get(i2);
        if (cJRTpUserProfileContact != null) {
            TextView textView = qVar.f25199a;
            textView.setText(cJRTpUserProfileContact.getTitle() + " " + cJRTpUserProfileContact.getFirstname() + " " + cJRTpUserProfileContact.getLastname());
            TextView textView2 = qVar.f25202d;
            Context context = qVar.f25205g;
            int i3 = R.string.traveller_are_you_sure_delete;
            textView2.setText(context.getString(i3, new Object[]{cJRTpUserProfileContact.getTitle() + " " + cJRTpUserProfileContact.getFirstname() + " " + cJRTpUserProfileContact.getLastname()}));
            qVar.f25201c.setTag(cJRTpUserProfileContact);
            qVar.f25201c.setVisibility(8);
        }
        return view;
    }

    public final Filter getFilter() {
        if (this.f24698f == null) {
            this.f24698f = new a();
        }
        return this.f24698f;
    }

    public class a extends Filter {
        public a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (TextUtils.isEmpty(charSequence) || charSequence.toString().length() == 0) {
                filterResults.values = l.this.f24697e;
                filterResults.count = l.this.f24697e.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = l.this.f24693a.iterator();
                while (it2.hasNext()) {
                    CJRTpUserProfileContact cJRTpUserProfileContact = (CJRTpUserProfileContact) it2.next();
                    if ((cJRTpUserProfileContact.getFirstname() + " " + cJRTpUserProfileContact.getLastname()).toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        arrayList.add(cJRTpUserProfileContact);
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
                ArrayList unused = l.this.f24693a = (ArrayList) filterResults.values;
                l.this.notifyDataSetChanged();
            }
        }
    }
}
