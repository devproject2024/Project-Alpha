package net.one97.paytm.recharge.common.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.contactsSdk.database.Tables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.e.j;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.model.ContactItemModel;

public final class s extends RecyclerView.a<RecyclerView.v> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends CJRFrequentOrder> f60670a;

    /* renamed from: b  reason: collision with root package name */
    public p f60671b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Object> f60672c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Object> f60673d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f60674e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60675f;

    /* renamed from: g  reason: collision with root package name */
    private List<? extends ContactItemModel> f60676g;

    /* renamed from: h  reason: collision with root package name */
    private h f60677h;

    /* renamed from: i  reason: collision with root package name */
    private final int f60678i;
    private final int j = 1;
    private final int k = 2;
    /* access modifiers changed from: private */
    public j l;

    public final void a(List<? extends ContactItemModel> list, CJRContactListV8.a aVar) {
        k.c(list, Tables.CONTACTS);
        k.c(aVar, "options");
        this.f60676g = list;
        if (this.f60672c == null) {
            this.f60672c = new ArrayList<>();
        }
        if (this.f60673d == null) {
            this.f60673d = new ArrayList<>();
        }
        List<? extends ContactItemModel> list2 = aVar.f61861b;
        if (list2 != null) {
            ArrayList<Object> arrayList = this.f60672c;
            if (arrayList == null) {
                k.a();
            }
            if (!arrayList.isEmpty()) {
                ArrayList<Object> arrayList2 = this.f60673d;
                if (arrayList2 == null) {
                    k.a();
                }
                arrayList2.add((byte) 0);
                ArrayList<Object> arrayList3 = this.f60672c;
                if (arrayList3 == null) {
                    k.a();
                }
                arrayList3.add((byte) 0);
            }
            ArrayList<Object> arrayList4 = this.f60672c;
            if (arrayList4 == null) {
                k.a();
            }
            Collection collection = list2;
            arrayList4.addAll(collection);
            ArrayList<Object> arrayList5 = this.f60673d;
            if (arrayList5 == null) {
                k.a();
            }
            arrayList5.addAll(collection);
            ArrayList<Object> arrayList6 = this.f60672c;
            if (arrayList6 == null) {
                k.a();
            }
            notifyItemRangeChanged(arrayList6.size() - 1, list2.size() + 1);
        }
        this.f60677h = new h(aVar);
    }

    public final int getItemViewType(int i2) {
        ArrayList<Object> arrayList = this.f60673d;
        if (arrayList == null) {
            k.a();
        }
        if (arrayList.get(i2) instanceof CJRFrequentOrder) {
            return this.f60678i;
        }
        ArrayList<Object> arrayList2 = this.f60673d;
        if (arrayList2 == null) {
            k.a();
        }
        if (arrayList2.get(i2) instanceof Byte) {
            return this.k;
        }
        ArrayList<Object> arrayList3 = this.f60673d;
        if (arrayList3 == null) {
            k.a();
        }
        if (arrayList3.get(i2) instanceof ContactItemModel) {
            return this.j;
        }
        return -1;
    }

    public final int getItemCount() {
        ArrayList<Object> arrayList = this.f60673d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f60678i) {
            p pVar = this.f60671b;
            if (pVar == null) {
                k.a();
            }
            return pVar.onCreateViewHolder(viewGroup, i2);
        } else if (i2 == this.k) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v8_content_enter_mobile_number_contact_header, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…ct_header, parent, false)");
            return new a(inflate);
        } else if (i2 == this.j) {
            h hVar = this.f60677h;
            if (hVar == null) {
                k.a();
            }
            return hVar.onCreateViewHolder(viewGroup, i2);
        } else {
            throw new RuntimeException("View Holder Not Defined");
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        int itemViewType = getItemViewType(i2);
        if (itemViewType == this.f60678i) {
            if (vVar instanceof p.d) {
                p.d dVar = (p.d) vVar;
                ArrayList<Object> arrayList = this.f60673d;
                if (arrayList == null) {
                    k.a();
                }
                Object obj = arrayList.get(i2);
                if (obj != null) {
                    dVar.a(i2, (CJRFrequentOrder) obj);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRFrequentOrder");
            }
        } else if (itemViewType == this.j) {
            if (vVar instanceof h.b) {
                h.b bVar = (h.b) vVar;
                ArrayList<Object> arrayList2 = this.f60673d;
                if (arrayList2 == null) {
                    k.a();
                }
                Object obj2 = arrayList2.get(i2);
                if (obj2 != null) {
                    bVar.a(i2, (ContactItemModel) obj2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.ContactItemModel");
            }
        } else if (itemViewType != this.k) {
            throw new RuntimeException("View Holder Not Defined");
        } else if (vVar instanceof a) {
            ((a) vVar).f60679a.setText(R.string.title_from_contacts);
        }
    }

    public final Filter getFilter() {
        return new b();
    }

    public final class b extends Filter {
        public b() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ea, code lost:
            if (kotlin.m.p.a(r12, (java.lang.CharSequence) r15, false) == true) goto L_0x00ec;
         */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x013a A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r17) {
            /*
                r16 = this;
                r0 = r16
                android.widget.Filter$FilterResults r1 = new android.widget.Filter$FilterResults
                r1.<init>()
                r2 = 0
                r3 = 1
                if (r17 == 0) goto L_0x0014
                boolean r4 = kotlin.m.p.a(r17)
                if (r4 == 0) goto L_0x0012
                goto L_0x0014
            L_0x0012:
                r4 = 0
                goto L_0x0015
            L_0x0014:
                r4 = 1
            L_0x0015:
                if (r4 != 0) goto L_0x014e
                java.lang.String r4 = r17.toString()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r5 = r4.length()
                int r5 = r5 - r3
                r6 = r5
                r5 = 0
                r7 = 0
            L_0x0025:
                if (r5 > r6) goto L_0x0045
                if (r7 != 0) goto L_0x002b
                r8 = r5
                goto L_0x002c
            L_0x002b:
                r8 = r6
            L_0x002c:
                char r8 = r4.charAt(r8)
                r9 = 32
                if (r8 > r9) goto L_0x0036
                r8 = 1
                goto L_0x0037
            L_0x0036:
                r8 = 0
            L_0x0037:
                if (r7 != 0) goto L_0x0040
                if (r8 != 0) goto L_0x003d
                r7 = 1
                goto L_0x0025
            L_0x003d:
                int r5 = r5 + 1
                goto L_0x0025
            L_0x0040:
                if (r8 == 0) goto L_0x0045
                int r6 = r6 + -1
                goto L_0x0025
            L_0x0045:
                int r6 = r6 + r3
                java.lang.CharSequence r4 = r4.subSequence(r5, r6)
                java.lang.String r4 = r4.toString()
                java.util.Locale r5 = java.util.Locale.getDefault()
                java.lang.String r6 = "Locale.getDefault()"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
                if (r4 == 0) goto L_0x0148
                java.lang.String r4 = r4.toLowerCase(r5)
                java.lang.String r5 = "(this as java.lang.String).toLowerCase(locale)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                net.one97.paytm.recharge.common.a.s r9 = net.one97.paytm.recharge.common.a.s.this
                java.util.ArrayList r9 = r9.f60672c
                if (r9 != 0) goto L_0x0074
                kotlin.g.b.k.a()
            L_0x0074:
                java.util.Collection r9 = (java.util.Collection) r9
                int r9 = r9.size()
                r10 = 0
            L_0x007b:
                if (r10 >= r9) goto L_0x013f
                net.one97.paytm.recharge.common.a.s r11 = net.one97.paytm.recharge.common.a.s.this
                java.util.ArrayList r11 = r11.f60672c
                if (r11 != 0) goto L_0x0088
                kotlin.g.b.k.a()
            L_0x0088:
                java.lang.Object r11 = r11.get(r10)
                java.lang.String r12 = "originalItems!![i]"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
                boolean r12 = r11 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrder
                if (r12 == 0) goto L_0x00a1
                r12 = r11
                net.one97.paytm.common.entity.recharge.CJRFrequentOrder r12 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r12
                java.lang.String r14 = r12.getRechargeNumber()
                java.lang.String r12 = r12.getContactName()
                goto L_0x00b3
            L_0x00a1:
                boolean r12 = r11 instanceof net.one97.paytm.recharge.model.ContactItemModel
                if (r12 == 0) goto L_0x00b1
                r12 = r11
                net.one97.paytm.recharge.model.ContactItemModel r12 = (net.one97.paytm.recharge.model.ContactItemModel) r12
                java.lang.String r14 = r12.getPhnNo()
                java.lang.String r12 = r12.getName()
                goto L_0x00b3
            L_0x00b1:
                r12 = 0
                r14 = 0
            L_0x00b3:
                if (r14 == 0) goto L_0x00bb
                boolean r15 = kotlin.m.p.b(r14, r4, r2)
                if (r15 == r3) goto L_0x00ec
            L_0x00bb:
                net.one97.paytm.recharge.common.a.s r15 = net.one97.paytm.recharge.common.a.s.this
                boolean r15 = r15.f60675f
                if (r15 == 0) goto L_0x00fa
                if (r12 == 0) goto L_0x00fa
                java.util.Locale r15 = java.util.Locale.getDefault()
                kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
                if (r12 == 0) goto L_0x00f4
                java.lang.String r12 = r12.toLowerCase(r15)
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
                if (r12 == 0) goto L_0x00fa
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                if (r4 == 0) goto L_0x00ee
                java.lang.String r15 = r4.toLowerCase()
                java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
                kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r2)
                java.lang.CharSequence r15 = (java.lang.CharSequence) r15
                boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r12, (java.lang.CharSequence) r15, false)
                if (r2 != r3) goto L_0x00fa
            L_0x00ec:
                r2 = 1
                goto L_0x00fb
            L_0x00ee:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r7)
                throw r1
            L_0x00f4:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r7)
                throw r1
            L_0x00fa:
                r2 = 0
            L_0x00fb:
                if (r2 == 0) goto L_0x013a
                r2 = r8
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.Iterator r2 = r2.iterator()
                r12 = 0
            L_0x0105:
                boolean r15 = r2.hasNext()
                if (r15 == 0) goto L_0x0135
                java.lang.Object r15 = r2.next()
                boolean r13 = r15 instanceof net.one97.paytm.common.entity.recharge.CJRFrequentOrder
                if (r13 == 0) goto L_0x011a
                net.one97.paytm.common.entity.recharge.CJRFrequentOrder r15 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r15
                java.lang.String r13 = r15.getRechargeNumber()
                goto L_0x0126
            L_0x011a:
                boolean r13 = r15 instanceof net.one97.paytm.recharge.model.ContactItemModel
                if (r13 == 0) goto L_0x0125
                net.one97.paytm.recharge.model.ContactItemModel r15 = (net.one97.paytm.recharge.model.ContactItemModel) r15
                java.lang.String r13 = r15.getPhnNo()
                goto L_0x0126
            L_0x0125:
                r13 = 0
            L_0x0126:
                if (r13 == 0) goto L_0x0130
                boolean r13 = r13.equals(r14)
                if (r13 != r3) goto L_0x0130
                r13 = 1
                goto L_0x0131
            L_0x0130:
                r13 = 0
            L_0x0131:
                if (r13 == 0) goto L_0x0105
                r12 = 1
                goto L_0x0105
            L_0x0135:
                if (r12 != 0) goto L_0x013a
                r8.add(r11)
            L_0x013a:
                int r10 = r10 + 1
                r2 = 0
                goto L_0x007b
            L_0x013f:
                int r2 = r8.size()
                r1.count = r2
                r1.values = r8
                goto L_0x0166
            L_0x0148:
                kotlin.u r1 = new kotlin.u
                r1.<init>(r7)
                throw r1
            L_0x014e:
                net.one97.paytm.recharge.common.a.s r2 = net.one97.paytm.recharge.common.a.s.this
                java.util.ArrayList r2 = r2.f60672c
                if (r2 == 0) goto L_0x015b
                int r2 = r2.size()
                goto L_0x015c
            L_0x015b:
                r2 = 0
            L_0x015c:
                r1.count = r2
                net.one97.paytm.recharge.common.a.s r2 = net.one97.paytm.recharge.common.a.s.this
                java.util.ArrayList r2 = r2.f60672c
                r1.values = r2
            L_0x0166:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.a.s.b.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            k.c(charSequence, "constraint");
            k.c(filterResults, "results");
            ArrayList c2 = s.this.f60673d;
            if (c2 != null) {
                c2.clear();
            }
            ArrayList c3 = s.this.f60673d;
            if (c3 != null) {
                Object obj = filterResults.values;
                if (obj != null) {
                    c3.addAll((ArrayList) obj);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */");
                }
            }
            if (filterResults.count == 0) {
                j d2 = s.this.l;
                if (d2 != null) {
                    d2.a(false);
                }
            } else {
                j d3 = s.this.l;
                if (d3 != null) {
                    d3.a(true);
                }
            }
            s.this.notifyDataSetChanged();
        }
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f60679a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f60679a = (TextView) view.findViewById(R.id.text_title_contact);
        }
    }
}
