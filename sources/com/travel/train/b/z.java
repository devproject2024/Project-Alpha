package com.travel.train.b;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.train.R;
import com.travel.train.i.o;
import com.travel.train.model.trainticket.j;
import com.travel.train.viewholder.aq;
import java.util.ArrayList;
import java.util.List;

public final class z extends RecyclerView.a<aq> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private Context f26586a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<com.travel.train.model.trainticket.a> f26587b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<com.travel.train.model.trainticket.a> f26588c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<? extends j> f26589d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f26590e;

    /* renamed from: f  reason: collision with root package name */
    private o f26591f;

    /* renamed from: g  reason: collision with root package name */
    private a f26592g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f26593h = "";

    public final int getItemViewType(int i2) {
        return i2;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        aq aqVar = (aq) vVar;
        com.travel.train.model.trainticket.a aVar = this.f26587b.get(i2);
        Context context = this.f26586a;
        aqVar.f27852e = aVar;
        aqVar.f27849b.setText(aVar.getContactName());
        aqVar.f27850c.setText(aVar.getContactNumber());
        if (TextUtils.isEmpty(aVar.getContactName())) {
            aqVar.f27849b.setVisibility(8);
        } else {
            aqVar.f27849b.setVisibility(0);
        }
        String photoUri = aVar.getPhotoUri();
        if (TextUtils.isEmpty(photoUri)) {
            aqVar.f27848a.setVisibility(8);
            aqVar.f27851d.setVisibility(0);
            aqVar.f27851d.setText(aVar.getDisplayChar());
            ((GradientDrawable) aqVar.f27851d.getBackground()).setColor(aVar.getColor());
            return;
        }
        b.a.C0750a a2 = b.a(context);
        a2.f43753a = photoUri;
        b.a.C0750a.a(a2, aqVar.f27848a, (com.paytm.utility.b.b.b) null, 2);
        aqVar.f27848a.setVisibility(0);
        aqVar.f27851d.setVisibility(8);
    }

    public z(Context context, List<com.travel.train.model.trainticket.a> list, o oVar) {
        this.f26586a = context;
        this.f26587b = new ArrayList(list);
        this.f26588c = new ArrayList(list);
        this.f26589d = new ArrayList();
        this.f26591f = oVar;
        this.f26590e = LayoutInflater.from(context);
        this.f26592g = new a();
    }

    public final void a(List<? extends j> list) {
        this.f26589d = list;
        getFilter().filter(this.f26593h);
    }

    public final int getItemCount() {
        List<com.travel.train.model.trainticket.a> list = this.f26587b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final Filter getFilter() {
        return this.f26592g;
    }

    class a extends Filter {
        a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            CharSequence unused = z.this.f26593h = charSequence;
            String lowerCase = charSequence.toString().toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(lowerCase)) {
                for (com.travel.train.model.trainticket.a aVar : z.this.f26588c) {
                    if (!z.this.f26589d.contains(aVar)) {
                        arrayList.add(aVar);
                    }
                }
            } else {
                for (com.travel.train.model.trainticket.a aVar2 : z.this.f26588c) {
                    if (!z.this.f26589d.contains(aVar2)) {
                        String lowerCase2 = aVar2.getContactName().toLowerCase();
                        String contactNumber = aVar2.getContactNumber();
                        if ((lowerCase2.contains(lowerCase) || contactNumber.contains(lowerCase)) && !z.this.f26589d.contains(aVar2)) {
                            arrayList.add(aVar2);
                        }
                    }
                }
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            List unused = z.this.f26587b = (List) filterResults.values;
            z.this.notifyDataSetChanged();
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new aq(this.f26590e.inflate(R.layout.pre_t_list_item_train_contact_item, viewGroup, false), this.f26591f);
    }
}
