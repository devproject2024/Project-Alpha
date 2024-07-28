package net.one97.paytm.recharge.presentation.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SectionIndexer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.domain.entities.SectionWrapper;
import net.one97.paytm.recharge.presentation.d.c;
import net.one97.paytm.recharge.presentation.f.m;

public final class j extends RecyclerView.a<m> implements Filterable, SectionIndexer {

    /* renamed from: a  reason: collision with root package name */
    final a f64621a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Integer> f64622b = new ArrayList<>(26);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<SectionWrapper> f64623c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<SectionWrapper> f64624d;

    /* renamed from: e  reason: collision with root package name */
    private final c f64625e;

    public interface a {
        void a();

        void a(CJRPayChannelOptions cJRPayChannelOptions);

        void b();
    }

    public final int getSectionForPosition(int i2) {
        return 0;
    }

    public j(ArrayList<SectionWrapper> arrayList, a aVar, c cVar) {
        k.c(arrayList, "sectionWrapperList");
        k.c(aVar, "bankListener");
        this.f64624d = arrayList;
        this.f64621a = aVar;
        this.f64625e = cVar;
        this.f64623c.addAll(this.f64624d);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        m mVar = (m) vVar;
        k.c(mVar, "holder");
        mVar.a(this.f64623c.get(i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bank_list_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…list_item, parent, false)");
        return new m(inflate, this.f64621a);
    }

    public final int getItemCount() {
        if (this.f64623c.isEmpty()) {
            return 0;
        }
        return this.f64623c.size();
    }

    public final int getPositionForSection(int i2) {
        Integer num = this.f64622b.get(i2);
        k.a((Object) num, "mSectionPositions[sectionIndex]");
        return num.intValue();
    }

    public static final class b extends Filter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f64626a;

        b(j jVar) {
            this.f64626a = jVar;
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            String str;
            if (charSequence == null || (str = charSequence.toString()) == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                j jVar = this.f64626a;
                jVar.f64623c = jVar.f64624d;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = this.f64626a.f64624d.iterator();
                while (it2.hasNext()) {
                    SectionWrapper sectionWrapper = (SectionWrapper) it2.next();
                    k.a((Object) sectionWrapper, "sectionWrapper");
                    if (sectionWrapper.getChildSections() != null && !TextUtils.isEmpty(sectionWrapper.getChildSections().getChannelName())) {
                        String channelName = sectionWrapper.getChildSections().getChannelName();
                        if (channelName == null) {
                            k.a();
                        }
                        if (channelName != null) {
                            String lowerCase = channelName.toLowerCase();
                            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                            CharSequence charSequence2 = lowerCase;
                            if (str != null) {
                                String lowerCase2 = str.toLowerCase();
                                k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                if (p.a(charSequence2, (CharSequence) lowerCase2, false)) {
                                    arrayList.add(sectionWrapper);
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
                this.f64626a.f64623c = arrayList;
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = this.f64626a.f64623c;
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            j jVar = this.f64626a;
            Object obj = filterResults != null ? filterResults.values : null;
            if (obj != null) {
                jVar.f64623c = (ArrayList) obj;
                if (!this.f64626a.f64623c.isEmpty()) {
                    this.f64626a.f64621a.b();
                } else {
                    this.f64626a.f64621a.a();
                }
                this.f64626a.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.recharge.domain.entities.SectionWrapper> /* = java.util.ArrayList<net.one97.paytm.recharge.domain.entities.SectionWrapper> */");
        }
    }

    public final Filter getFilter() {
        return new b(this);
    }

    public final /* synthetic */ Object[] getSections() {
        ArrayList arrayList = new ArrayList(26);
        int size = this.f64623c.size();
        int i2 = 0;
        while (i2 < size) {
            SectionWrapper sectionWrapper = this.f64623c.get(i2);
            k.a((Object) sectionWrapper, "filteredSectionWrapper[i]");
            String channelName = sectionWrapper.getChildSections().getChannelName();
            if (channelName == null) {
                k.a();
            }
            String valueOf = String.valueOf(channelName.charAt(0));
            if (valueOf != null) {
                String upperCase = valueOf.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                if (!arrayList.contains(upperCase)) {
                    arrayList.add(upperCase);
                    this.f64622b.add(Integer.valueOf(i2));
                }
                i2++;
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
