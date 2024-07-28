package com.travel.train.b;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.p;
import com.travel.train.model.trainticket.c;
import com.travel.train.model.trainticket.j;
import com.travel.train.viewholder.ar;
import java.util.ArrayList;
import java.util.List;

public final class ab extends RecyclerView.a<ar> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private Context f26162a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f26163b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<c> f26164c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<c> f26165d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<? extends j> f26166e;

    /* renamed from: f  reason: collision with root package name */
    private a f26167f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f26168g = "";

    /* renamed from: h  reason: collision with root package name */
    private p f26169h;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ar arVar = (ar) vVar;
        c cVar = this.f26164c.get(i2);
        arVar.f27856b = cVar;
        String email = cVar.getEmail();
        int searchMatchStartIndex = cVar.getSearchMatchStartIndex();
        int searchMatchEndIndex = cVar.getSearchMatchEndIndex();
        if (searchMatchStartIndex < 0 || searchMatchEndIndex < 0 || searchMatchEndIndex <= searchMatchStartIndex) {
            arVar.f27855a.setText(email);
            return;
        }
        SpannableString spannableString = new SpannableString(email);
        spannableString.setSpan(new StyleSpan(1), searchMatchStartIndex, searchMatchEndIndex, 33);
        arVar.f27855a.setText(spannableString);
    }

    public ab(Context context, List<c> list, p pVar) {
        this.f26162a = context;
        this.f26164c = new ArrayList(list);
        this.f26165d = new ArrayList(list);
        this.f26166e = new ArrayList();
        this.f26169h = pVar;
        this.f26163b = LayoutInflater.from(context);
        this.f26167f = new a();
    }

    public final void a(List<? extends j> list) {
        this.f26166e = list;
        getFilter().filter(this.f26168g);
    }

    public final int getItemCount() {
        return this.f26164c.size();
    }

    public final Filter getFilter() {
        return this.f26167f;
    }

    class a extends Filter {
        a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            CharSequence unused = ab.this.f26168g = charSequence;
            String lowerCase = charSequence.toString().toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(lowerCase)) {
                for (c cVar : ab.this.f26165d) {
                    if (!ab.this.f26166e.contains(cVar)) {
                        cVar.setSearchMatchEndIndex(-1);
                        cVar.setSearchMatchEndIndex(-1);
                        arrayList.add(cVar);
                    }
                }
            } else {
                for (c cVar2 : ab.this.f26165d) {
                    if (!ab.this.f26166e.contains(cVar2)) {
                        int indexOf = cVar2.getEmail().indexOf(lowerCase);
                        int length = lowerCase.length() + indexOf;
                        if (indexOf >= 0 && !ab.this.f26166e.contains(cVar2)) {
                            cVar2.setSearchMatchStartIndex(indexOf);
                            cVar2.setSearchMatchEndIndex(length);
                            arrayList.add(cVar2);
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
            List unused = ab.this.f26164c = (List) filterResults.values;
            ab.this.notifyDataSetChanged();
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ar(this.f26163b.inflate(R.layout.pre_t_list_item_train_email_item, viewGroup, false), this.f26169h);
    }
}
