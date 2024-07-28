package net.one97.paytm.marketplace.search.a;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRSearchCuration;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.CJRSearchPage;
import net.one97.paytm.common.entity.shopping.CJRSearchPageItem;
import net.one97.paytm.common.entity.shopping.CJRSearchPopularProduct;
import net.one97.paytm.paytm_finance.R;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRSearchLayout> f53337a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRSearchLayout> f53338b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<a> f53339c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRSearchPopularProduct> f53340d;

    /* renamed from: e  reason: collision with root package name */
    e f53341e;

    /* renamed from: f  reason: collision with root package name */
    final int f53342f;

    /* renamed from: g  reason: collision with root package name */
    final Context f53343g;

    /* renamed from: h  reason: collision with root package name */
    final C0957b f53344h;

    /* renamed from: i  reason: collision with root package name */
    private final LayoutInflater f53345i;
    private final int j;
    private final int k = 1;
    private final int l = 2;

    /* renamed from: net.one97.paytm.marketplace.search.a.b$b  reason: collision with other inner class name */
    public interface C0957b {
        void a(String str, String str2, String str3, String str4, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration);

        void a(String str, String str2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration);

        void a(String str, CJRGridProduct cJRGridProduct);
    }

    public b(Context context, CJRSearchPage cJRSearchPage, C0957b bVar) {
        k.c(context, "mContext");
        k.c(cJRSearchPage, "searchpage");
        k.c(bVar, "mSearchListener");
        this.f53343g = context;
        this.f53344h = bVar;
        LayoutInflater from = LayoutInflater.from(this.f53343g);
        k.a((Object) from, "LayoutInflater.from(mContext)");
        this.f53345i = from;
        this.f53337a = cJRSearchPage.getKeyWordsLayoutList();
        this.f53338b = cJRSearchPage.getProductsLayoutList();
        this.f53340d = cJRSearchPage.getmSearchPopularProductsList();
        this.f53339c = new ArrayList<>();
        this.f53342f = com.paytm.utility.a.t(this.f53343g);
    }

    public final long getItemId(int i2) {
        ArrayList<a> arrayList = this.f53339c;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList == null) {
            k.a();
        }
        if (arrayList.size() <= i2) {
            return 0;
        }
        ArrayList<a> arrayList2 = this.f53339c;
        if (arrayList2 == null) {
            k.a();
        }
        return (long) arrayList2.get(i2).hashCode();
    }

    public final int getItemCount() {
        Collection collection = this.f53340d;
        if (collection == null || collection.isEmpty()) {
            ArrayList<a> arrayList = this.f53339c;
            if (arrayList == null) {
                k.a();
            }
            return arrayList.size();
        }
        ArrayList<a> arrayList2 = this.f53339c;
        if (arrayList2 == null) {
            k.a();
        }
        return arrayList2.size() + 1;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.j) {
            View inflate = this.f53345i.inflate(R.layout.auto_suggest_item, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…gest_item, parent, false)");
            return new f(this, inflate);
        } else if (i2 == this.k) {
            View inflate2 = this.f53345i.inflate(R.layout.auto_suggest_item, viewGroup, false);
            k.a((Object) inflate2, "mInflater.inflate(R.layo…gest_item, parent, false)");
            return new c(this, inflate2);
        } else if (i2 == this.l) {
            View inflate3 = this.f53345i.inflate(R.layout.auto_suggest_item, viewGroup, false);
            k.a((Object) inflate3, "mInflater.inflate(R.layo…gest_item, parent, false)");
            return new e(this, inflate3);
        } else {
            View inflate4 = this.f53345i.inflate(R.layout.lyt_container_popular_search_paytm, viewGroup, false);
            k.a((Object) inflate4, "mInflater.inflate(R.layo…rch_paytm, parent, false)");
            return new d(this, inflate4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0263  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.String r3 = "holder"
            kotlin.g.b.k.c(r0, r3)
            int r3 = r1.getItemViewType(r2)
            int r4 = r1.j
            java.lang.String r5 = "filterItem.searchLayout.text"
            r6 = 0
            java.lang.String r7 = "mKeyWordsFilterList!![position]"
            r8 = 0
            if (r3 != r4) goto L_0x0167
            r10 = r0
            net.one97.paytm.marketplace.search.a.b$f r10 = (net.one97.paytm.marketplace.search.a.b.f) r10
            net.one97.paytm.marketplace.search.a.b r0 = r10.f53376d
            java.util.ArrayList<net.one97.paytm.marketplace.search.a.b$a> r0 = r0.f53339c
            if (r0 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            java.lang.Object r0 = r0.get(r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            r2 = r0
            net.one97.paytm.marketplace.search.a.b$a r2 = (net.one97.paytm.marketplace.search.a.b.a) r2
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r0 = r2.f53346a
            net.one97.paytm.common.entity.shopping.CJRSearchCuration r14 = r0.getSearchCuration()
            android.view.View r0 = r10.f53375c
            r0.setVisibility(r8)
            android.widget.TextView r0 = r10.f53373a
            com.paytm.utility.b.a((android.widget.TextView) r0)
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r0 = r2.f53346a
            java.lang.String r11 = r0.getText()
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r0 = r2.f53346a
            if (r0 == 0) goto L_0x0052
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r0 = r2.f53346a
            java.lang.String r6 = r0.getmTextHtml()
        L_0x0052:
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r0 = r2.f53346a
            java.lang.String r0 = r0.getCount()
            java.lang.String r3 = ""
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r4 = r2.f53346a
            java.util.HashMap r4 = r4.getmAutoSearchMetaData()
            if (r4 == 0) goto L_0x00b8
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r4 = r2.f53346a
            java.util.HashMap r4 = r4.getmAutoSearchMetaData()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x00b8
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r4 = r2.f53346a
            java.util.HashMap r4 = r4.getmAutoSearchMetaData()
            java.lang.String r5 = "filterItem.searchLayout.getmAutoSearchMetaData()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.util.Map r4 = (java.util.Map) r4
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0083:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00b8
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r7 = r5.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r7)
            r3 = 61
            r9.append(r3)
            r9.append(r5)
            r3 = 59
            r9.append(r3)
            java.lang.String r3 = r9.toString()
            goto L_0x0083
        L_0x00b8:
            r12 = r3
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r3 = r2.f53346a
            java.util.HashMap r13 = r3.getmFilterAttributes()
            if (r0 == 0) goto L_0x0135
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r4 = r3.length()
            r5 = 1
            int r4 = r4 - r5
            r7 = r4
            r4 = 0
            r9 = 0
        L_0x00cd:
            if (r4 > r7) goto L_0x00ef
            if (r9 != 0) goto L_0x00d3
            r15 = r4
            goto L_0x00d4
        L_0x00d3:
            r15 = r7
        L_0x00d4:
            char r15 = r3.charAt(r15)
            r8 = 32
            if (r15 > r8) goto L_0x00de
            r8 = 1
            goto L_0x00df
        L_0x00de:
            r8 = 0
        L_0x00df:
            if (r9 != 0) goto L_0x00e9
            if (r8 != 0) goto L_0x00e6
            r8 = 0
            r9 = 1
            goto L_0x00cd
        L_0x00e6:
            int r4 = r4 + 1
            goto L_0x00ed
        L_0x00e9:
            if (r8 == 0) goto L_0x00ef
            int r7 = r7 + -1
        L_0x00ed:
            r8 = 0
            goto L_0x00cd
        L_0x00ef:
            int r7 = r7 + r5
            java.lang.CharSequence r3 = r3.subSequence(r4, r7)
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0102
            r3 = 1
            goto L_0x0103
        L_0x0102:
            r3 = 0
        L_0x0103:
            if (r3 == 0) goto L_0x0135
            int r3 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x012d }
            if (r3 <= 0) goto L_0x0135
            android.widget.TextView r3 = r10.f53374b     // Catch:{ Exception -> 0x012d }
            kotlin.g.b.aa r4 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x012d }
            java.lang.String r4 = " (%s)"
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x012d }
            java.lang.String r0 = com.paytm.utility.b.x((java.lang.String) r0)     // Catch:{ Exception -> 0x012d }
            r8 = 0
            r7[r8] = r0     // Catch:{ Exception -> 0x012d }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r7, r5)     // Catch:{ Exception -> 0x012d }
            java.lang.String r0 = java.lang.String.format(r4, r0)     // Catch:{ Exception -> 0x012d }
            java.lang.String r4 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.b(r0, r4)     // Catch:{ Exception -> 0x012d }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x012d }
            r3.setText(r0)     // Catch:{ Exception -> 0x012d }
            goto L_0x0135
        L_0x012d:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0135:
            if (r6 == 0) goto L_0x0143
            android.widget.TextView r0 = r10.f53373a
            android.text.Spanned r2 = android.text.Html.fromHtml(r6)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            goto L_0x0159
        L_0x0143:
            android.text.SpannableStringBuilder r0 = r2.f53349d
            if (r0 == 0) goto L_0x0151
            android.widget.TextView r0 = r10.f53373a
            android.text.SpannableStringBuilder r2 = r2.f53349d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            goto L_0x0159
        L_0x0151:
            android.widget.TextView r0 = r10.f53373a
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0159:
            android.view.View r0 = r10.itemView
            net.one97.paytm.marketplace.search.a.b$f$a r2 = new net.one97.paytm.marketplace.search.a.b$f$a
            r9 = r2
            r9.<init>(r10, r11, r12, r13, r14)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            return
        L_0x0167:
            int r4 = r1.k
            if (r3 != r4) goto L_0x0171
            net.one97.paytm.marketplace.search.a.b$c r0 = (net.one97.paytm.marketplace.search.a.b.c) r0
            r0.a(r2)
            return
        L_0x0171:
            int r4 = r1.l
            if (r3 != r4) goto L_0x01fd
            net.one97.paytm.marketplace.search.a.b$e r0 = (net.one97.paytm.marketplace.search.a.b.e) r0
            net.one97.paytm.marketplace.search.a.b r3 = r0.f53369e
            java.util.ArrayList<net.one97.paytm.marketplace.search.a.b$a> r3 = r3.f53339c
            if (r3 != 0) goto L_0x0180
            kotlin.g.b.k.a()
        L_0x0180:
            java.lang.Object r2 = r3.get(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            net.one97.paytm.marketplace.search.a.b$a r2 = (net.one97.paytm.marketplace.search.a.b.a) r2
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r3 = r2.f53346a
            net.one97.paytm.common.entity.shopping.CJRSearchCuration r3 = r3.getSearchCuration()
            androidx.constraintlayout.widget.ConstraintLayout r4 = r0.f53368d
            r7 = 0
            r4.setVisibility(r7)
            android.widget.ImageView r4 = r0.f53366b
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            net.one97.paytm.marketplace.search.a.b r7 = r0.f53369e
            int r7 = r7.f53342f
            float r7 = (float) r7
            r8 = 1069547520(0x3fc00000, float:1.5)
            float r7 = r7 * r8
            int r7 = (int) r7
            r4.width = r7
            net.one97.paytm.marketplace.search.a.b r7 = r0.f53369e
            int r7 = r7.f53342f
            float r7 = (float) r7
            float r7 = r7 * r8
            int r7 = (int) r7
            r4.height = r7
            android.widget.TextView r4 = r0.f53365a
            com.paytm.utility.b.a((android.widget.TextView) r4)
            android.widget.TextView r4 = r0.f53367c
            com.paytm.utility.b.a((android.widget.TextView) r4)
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r4 = r2.f53346a
            java.lang.String r4 = r4.getText()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r5 = r2.f53346a
            java.lang.String r5 = r5.getPrice()
            android.widget.TextView r7 = r0.f53365a
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7.setText(r4)
            android.widget.TextView r4 = r0.f53367c
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r0.f53368d
            net.one97.paytm.marketplace.search.a.b$e$a r5 = new net.one97.paytm.marketplace.search.a.b$e$a
            r5.<init>(r0, r2, r3)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            net.one97.paytm.common.entity.shopping.CJRSearchLayout r2 = r2.f53346a
            java.lang.String r2 = r2.getImageUrl()
            com.paytm.utility.b.b$a r3 = com.paytm.utility.b.b.f43744a
            net.one97.paytm.marketplace.search.a.b r3 = r0.f53369e
            android.content.Context r3 = r3.f53343g
            com.paytm.utility.b.b$a$a r3 = com.paytm.utility.b.b.a.a(r3)
            r3.f43753a = r2
            android.widget.ImageView r0 = r0.f53366b
            r2 = 2
            com.paytm.utility.b.b.a.C0750a.a(r3, r0, r6, r2)
            return
        L_0x01fd:
            net.one97.paytm.marketplace.search.a.b$d r0 = (net.one97.paytm.marketplace.search.a.b.d) r0
            net.one97.paytm.marketplace.search.a.b r2 = r0.f53364c
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRSearchPopularProduct> r2 = r2.f53340d
            if (r2 == 0) goto L_0x021b
            net.one97.paytm.marketplace.search.a.b r2 = r0.f53364c
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRSearchPopularProduct> r2 = r2.f53340d
            if (r2 != 0) goto L_0x020e
            kotlin.g.b.k.a()
        L_0x020e:
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x021b
            android.widget.LinearLayout r2 = r0.f53363b
            r3 = 0
            r2.setVisibility(r3)
            goto L_0x0222
        L_0x021b:
            android.widget.LinearLayout r2 = r0.f53363b
            r3 = 8
            r2.setVisibility(r3)
        L_0x0222:
            androidx.recyclerview.widget.RecyclerView r2 = r0.f53362a
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            net.one97.paytm.marketplace.search.a.b r4 = r0.f53364c
            android.content.Context r4 = r4.f53343g
            r5 = 0
            r3.<init>(r4, r5, r5)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r2.setLayoutManager(r3)
            net.one97.paytm.marketplace.search.a.b r2 = r0.f53364c
            net.one97.paytm.marketplace.search.a.e r2 = r2.f53341e
            if (r2 == 0) goto L_0x0263
            androidx.recyclerview.widget.RecyclerView r2 = r0.f53362a
            net.one97.paytm.marketplace.search.a.b r3 = r0.f53364c
            net.one97.paytm.marketplace.search.a.e r3 = r3.f53341e
            androidx.recyclerview.widget.RecyclerView$a r3 = (androidx.recyclerview.widget.RecyclerView.a) r3
            r2.setAdapter(r3)
            net.one97.paytm.marketplace.search.a.b r2 = r0.f53364c
            net.one97.paytm.marketplace.search.a.e r2 = r2.f53341e
            if (r2 != 0) goto L_0x024d
            kotlin.g.b.k.a()
        L_0x024d:
            net.one97.paytm.marketplace.search.a.b r3 = r0.f53364c
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRSearchPopularProduct> r3 = r3.f53340d
            r2.f53419b = r3
            r2.notifyDataSetChanged()
            net.one97.paytm.marketplace.search.a.b r0 = r0.f53364c
            net.one97.paytm.marketplace.search.a.e r0 = r0.f53341e
            if (r0 != 0) goto L_0x025f
            kotlin.g.b.k.a()
        L_0x025f:
            r0.notifyDataSetChanged()
            return
        L_0x0263:
            net.one97.paytm.marketplace.search.a.b r2 = r0.f53364c
            net.one97.paytm.marketplace.search.a.e r3 = new net.one97.paytm.marketplace.search.a.e
            net.one97.paytm.marketplace.search.a.b r4 = r0.f53364c
            android.content.Context r4 = r4.f53343g
            net.one97.paytm.marketplace.search.a.b r5 = r0.f53364c
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRSearchPopularProduct> r5 = r5.f53340d
            r3.<init>(r4, r5)
            r2.f53341e = r3
            androidx.recyclerview.widget.RecyclerView r2 = r0.f53362a
            net.one97.paytm.marketplace.search.a.b r0 = r0.f53364c
            net.one97.paytm.marketplace.search.a.e r0 = r0.f53341e
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r2.setAdapter(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.marketplace.search.a.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemViewType(int i2) {
        ArrayList<a> arrayList = this.f53339c;
        if (arrayList == null) {
            k.a();
        }
        if (i2 == arrayList.size()) {
            return 3;
        }
        ArrayList<a> arrayList2 = this.f53339c;
        if (arrayList2 == null) {
            k.a();
        }
        return arrayList2.get(i2).f53347b;
    }

    public final class f extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f53373a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f53374b;

        /* renamed from: c  reason: collision with root package name */
        final View f53375c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f53376d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(b bVar, View view) {
            super(view);
            k.c(view, "v");
            this.f53376d = bVar;
            View findViewById = view.findViewById(R.id.search_item_text);
            k.a((Object) findViewById, "v.findViewById(R.id.search_item_text)");
            this.f53373a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.search_item_count);
            k.a((Object) findViewById2, "v.findViewById(R.id.search_item_count)");
            this.f53374b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.single_keyword_container);
            k.a((Object) findViewById3, "v.findViewById(R.id.single_keyword_container)");
            this.f53375c = findViewById3;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f53377a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f53378b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f53379c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ HashMap f53380d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ CJRSearchCuration f53381e;

            a(f fVar, String str, String str2, HashMap hashMap, CJRSearchCuration cJRSearchCuration) {
                this.f53377a = fVar;
                this.f53378b = str;
                this.f53379c = str2;
                this.f53380d = hashMap;
                this.f53381e = cJRSearchCuration;
            }

            public final void onClick(View view) {
                C0957b bVar = this.f53377a.f53376d.f53344h;
                String str = this.f53378b;
                String str2 = this.f53379c;
                HashMap hashMap = this.f53380d;
                k.a((Object) hashMap, "filterAttributes");
                CJRSearchCuration cJRSearchCuration = this.f53381e;
                k.a((Object) cJRSearchCuration, "searchCuration");
                bVar.a(str, str2, hashMap, cJRSearchCuration);
            }
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f53351a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f53352b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f53353c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f53354d;

        /* renamed from: e  reason: collision with root package name */
        private final ConstraintLayout f53355e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(view);
            k.c(view, "v");
            this.f53351a = bVar;
            View findViewById = view.findViewById(R.id.search_item_main_text);
            k.a((Object) findViewById, "v.findViewById(R.id.search_item_main_text)");
            this.f53352b = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.search_item_cat_count);
            k.a((Object) findViewById2, "v.findViewById(R.id.search_item_cat_count)");
            this.f53353c = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.search_item_cat_text);
            k.a((Object) findViewById3, "v.findViewById(R.id.search_item_cat_text)");
            this.f53354d = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.keyword_cat_container);
            k.a((Object) findViewById4, "v.findViewById(R.id.keyword_cat_container)");
            this.f53355e = (ConstraintLayout) findViewById4;
        }

        public final void a(int i2) {
            ArrayList<a> arrayList = this.f53351a.f53339c;
            if (arrayList == null) {
                k.a();
            }
            a aVar = arrayList.get(i2);
            k.a((Object) aVar, "mKeyWordsFilterList!![position]");
            a aVar2 = aVar;
            CJRSearchCuration searchCuration = aVar2.f53346a.getSearchCuration();
            this.f53355e.setVisibility(0);
            com.paytm.utility.b.a(this.f53352b);
            com.paytm.utility.b.a(this.f53354d);
            String text = aVar2.f53346a.getText();
            k.a((Object) text, "filterItem.searchLayout.text");
            String count = aVar2.f53346a.getCount();
            String str = "";
            if (aVar2.f53346a.getmAutoSearchMetaData() != null && aVar2.f53346a.getmAutoSearchMetaData().size() > 0) {
                HashMap<String, String> hashMap = aVar2.f53346a.getmAutoSearchMetaData();
                k.a((Object) hashMap, "filterItem.searchLayout.getmAutoSearchMetaData()");
                for (Map.Entry entry : hashMap.entrySet()) {
                    str = str + ((String) entry.getKey()) + '=' + ((String) entry.getValue()) + ';';
                }
            }
            String str2 = str;
            HashMap<String, String> hashMap2 = aVar2.f53346a.getmFilterAttributes();
            if (count != null) {
                CharSequence charSequence = count;
                int length = charSequence.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length) {
                    boolean z2 = charSequence.charAt(!z ? i3 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i3++;
                    }
                }
                if (charSequence.subSequence(i3, length + 1).toString().length() > 0) {
                    try {
                        if (Integer.parseInt(count) > 0) {
                            TextView textView = this.f53353c;
                            aa aaVar = aa.f47921a;
                            String format = String.format(" (%s)", Arrays.copyOf(new Object[]{com.paytm.utility.b.x(count)}, 1));
                            k.b(format, "java.lang.String.format(format, *args)");
                            textView.setText(format);
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            }
            CJRSearchPageItem cJRSearchPageItem = aVar2.f53346a.getSearchPageItemList().get(aVar2.f53348c);
            if (aVar2.f53349d != null) {
                this.f53352b.setText(aVar2.f53349d);
            } else {
                this.f53352b.setText(text);
            }
            if (cJRSearchPageItem != null && !TextUtils.isEmpty(cJRSearchPageItem.getText())) {
                this.f53354d.setText(Html.fromHtml(this.f53351a.f53343g.getResources().getString(R.string.search_in, new Object[]{cJRSearchPageItem.getText()})));
            }
            this.f53355e.setOnClickListener(new a(this, cJRSearchPageItem, text, str2, hashMap2, searchCuration));
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f53356a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRSearchPageItem f53357b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f53358c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f53359d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ HashMap f53360e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ CJRSearchCuration f53361f;

            a(c cVar, CJRSearchPageItem cJRSearchPageItem, String str, String str2, HashMap hashMap, CJRSearchCuration cJRSearchCuration) {
                this.f53356a = cVar;
                this.f53357b = cJRSearchPageItem;
                this.f53358c = str;
                this.f53359d = str2;
                this.f53360e = hashMap;
                this.f53361f = cJRSearchCuration;
            }

            public final void onClick(View view) {
                CJRSearchPageItem cJRSearchPageItem = this.f53357b;
                if (cJRSearchPageItem == null) {
                    return;
                }
                if (!TextUtils.isEmpty(cJRSearchPageItem.getSearchUrl())) {
                    C0957b bVar = this.f53356a.f53351a.f53344h;
                    String searchUrl = this.f53357b.getSearchUrl();
                    k.a((Object) searchUrl, "subCategory.searchUrl");
                    String text = this.f53357b.getText();
                    k.a((Object) text, "subCategory.text");
                    String str = this.f53358c;
                    String str2 = this.f53359d;
                    HashMap hashMap = this.f53360e;
                    k.a((Object) hashMap, "catFilterAttributes");
                    CJRSearchCuration cJRSearchCuration = this.f53361f;
                    k.a((Object) cJRSearchCuration, "searchCuration");
                    bVar.a(searchUrl, text, str, str2, hashMap, cJRSearchCuration);
                } else if (!TextUtils.isEmpty(this.f53357b.getUrl())) {
                    C0957b bVar2 = this.f53356a.f53351a.f53344h;
                    String url = this.f53357b.getUrl();
                    k.a((Object) url, "subCategory.url");
                    String text2 = this.f53357b.getText();
                    k.a((Object) text2, "subCategory.text");
                    String str3 = this.f53358c;
                    String str4 = this.f53359d;
                    HashMap hashMap2 = this.f53360e;
                    k.a((Object) hashMap2, "catFilterAttributes");
                    CJRSearchCuration cJRSearchCuration2 = this.f53361f;
                    k.a((Object) cJRSearchCuration2, "searchCuration");
                    bVar2.a(url, text2, str3, str4, hashMap2, cJRSearchCuration2);
                }
            }
        }
    }

    public final class e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f53365a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f53366b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f53367c;

        /* renamed from: d  reason: collision with root package name */
        final ConstraintLayout f53368d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f53369e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, View view) {
            super(view);
            k.c(view, "v");
            this.f53369e = bVar;
            View findViewById = view.findViewById(R.id.search_item_product_text);
            k.a((Object) findViewById, "v.findViewById(R.id.search_item_product_text)");
            this.f53365a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.imgview);
            k.a((Object) findViewById2, "v.findViewById(R.id.imgview)");
            this.f53366b = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.txt_price_product);
            k.a((Object) findViewById3, "v.findViewById(R.id.txt_price_product)");
            this.f53367c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.product_container);
            k.a((Object) findViewById4, "v.findViewById(R.id.product_container)");
            this.f53368d = (ConstraintLayout) findViewById4;
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f53370a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f53371b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CJRSearchCuration f53372c;

            a(e eVar, a aVar, CJRSearchCuration cJRSearchCuration) {
                this.f53370a = eVar;
                this.f53371b = aVar;
                this.f53372c = cJRSearchCuration;
            }

            public final void onClick(View view) {
                C0957b bVar = this.f53370a.f53369e.f53344h;
                String seourl = this.f53371b.f53346a.getSeourl();
                k.a((Object) seourl, "filterItem.searchLayout.seourl");
                k.a((Object) this.f53372c, "searchCuration");
                bVar.a(seourl, (CJRGridProduct) null);
            }
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RecyclerView f53362a;

        /* renamed from: b  reason: collision with root package name */
        final LinearLayout f53363b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f53364c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, View view) {
            super(view);
            k.c(view, "v");
            this.f53364c = bVar;
            View findViewById = view.findViewById(R.id.lyt_popular_products);
            k.a((Object) findViewById, "v.findViewById(R.id.lyt_popular_products)");
            this.f53362a = (RecyclerView) findViewById;
            View findViewById2 = view.findViewById(R.id.products_container);
            k.a((Object) findViewById2, "v.findViewById(R.id.products_container)");
            this.f53363b = (LinearLayout) findViewById2;
        }
    }

    public final void a(CharSequence charSequence) {
        if (charSequence != null) {
            try {
                if (charSequence.length() > 1) {
                    ArrayList<a> arrayList = new ArrayList<>();
                    ArrayList<CJRSearchLayout> arrayList2 = this.f53337a;
                    if (arrayList2 == null) {
                        k.a();
                    }
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ArrayList<CJRSearchLayout> arrayList3 = this.f53337a;
                        if (arrayList3 == null) {
                            k.a();
                        }
                        CJRSearchLayout cJRSearchLayout = arrayList3.get(i2);
                        k.a((Object) cJRSearchLayout, "mKeyWordsList!![i]");
                        if (cJRSearchLayout.getSearchPageItemList().size() > 0) {
                            ArrayList<CJRSearchLayout> arrayList4 = this.f53337a;
                            if (arrayList4 == null) {
                                k.a();
                            }
                            CJRSearchLayout cJRSearchLayout2 = arrayList4.get(i2);
                            k.a((Object) cJRSearchLayout2, "mKeyWordsList!![i]");
                            int size2 = cJRSearchLayout2.getSearchPageItemList().size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                ArrayList<CJRSearchLayout> arrayList5 = this.f53337a;
                                if (arrayList5 == null) {
                                    k.a();
                                }
                                CJRSearchLayout cJRSearchLayout3 = arrayList5.get(i2);
                                k.a((Object) cJRSearchLayout3, "mKeyWordsList!![i]");
                                CJRSearchLayout cJRSearchLayout4 = cJRSearchLayout3;
                                int i4 = this.k;
                                ArrayList<CJRSearchLayout> arrayList6 = this.f53337a;
                                if (arrayList6 == null) {
                                    k.a();
                                }
                                CJRSearchLayout cJRSearchLayout5 = arrayList6.get(i2);
                                k.a((Object) cJRSearchLayout5, "mKeyWordsList!![i]");
                                String text = cJRSearchLayout5.getText();
                                k.a((Object) text, "mKeyWordsList!![i].text");
                                arrayList.add(new a(this, cJRSearchLayout4, i4, i3, a(text, charSequence.toString())));
                            }
                        } else {
                            ArrayList<CJRSearchLayout> arrayList7 = this.f53337a;
                            if (arrayList7 == null) {
                                k.a();
                            }
                            CJRSearchLayout cJRSearchLayout6 = arrayList7.get(i2);
                            k.a((Object) cJRSearchLayout6, "mKeyWordsList!![i]");
                            CJRSearchLayout cJRSearchLayout7 = cJRSearchLayout6;
                            int i5 = this.j;
                            ArrayList<CJRSearchLayout> arrayList8 = this.f53337a;
                            if (arrayList8 == null) {
                                k.a();
                            }
                            CJRSearchLayout cJRSearchLayout8 = arrayList8.get(i2);
                            k.a((Object) cJRSearchLayout8, "mKeyWordsList!![i]");
                            String text2 = cJRSearchLayout8.getText();
                            k.a((Object) text2, "mKeyWordsList!![i].text");
                            arrayList.add(new a(this, cJRSearchLayout7, i5, -1, a(text2, charSequence.toString())));
                        }
                    }
                    ArrayList<CJRSearchLayout> arrayList9 = this.f53338b;
                    if (arrayList9 == null) {
                        k.a();
                    }
                    int size3 = arrayList9.size();
                    for (int i6 = 0; i6 < size3; i6++) {
                        ArrayList<CJRSearchLayout> arrayList10 = this.f53338b;
                        if (arrayList10 == null) {
                            k.a();
                        }
                        CJRSearchLayout cJRSearchLayout9 = arrayList10.get(i6);
                        k.a((Object) cJRSearchLayout9, "mProductsList!![i]");
                        CJRSearchLayout cJRSearchLayout10 = cJRSearchLayout9;
                        int i7 = this.l;
                        ArrayList<CJRSearchLayout> arrayList11 = this.f53337a;
                        if (arrayList11 == null) {
                            k.a();
                        }
                        CJRSearchLayout cJRSearchLayout11 = arrayList11.get(i6);
                        k.a((Object) cJRSearchLayout11, "mKeyWordsList!![i]");
                        String text3 = cJRSearchLayout11.getText();
                        k.a((Object) text3, "mKeyWordsList!![i].text");
                        arrayList.add(new a(this, cJRSearchLayout10, i7, -1, a(text3, charSequence.toString())));
                    }
                    this.f53339c = arrayList;
                    notifyDataSetChanged();
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        this.f53339c = new ArrayList<>();
        notifyDataSetChanged();
    }

    private static SpannableStringBuilder a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CharSequence charSequence = str2;
        if (charSequence.length() > 0) {
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            if (!k.a((Object) charSequence.subSequence(i2, length + 1).toString(), (Object) "")) {
                Locale locale = Locale.getDefault();
                k.a((Object) locale, "Locale.getDefault()");
                if (str != null) {
                    String lowerCase = str.toLowerCase(locale);
                    k.b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    Locale locale2 = Locale.getDefault();
                    k.a((Object) locale2, "Locale.getDefault()");
                    if (str2 != null) {
                        String lowerCase2 = str2.toLowerCase(locale2);
                        k.b(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        int a2 = p.a((CharSequence) lowerCase, lowerCase2, 0, false, 6);
                        int length2 = lowerCase2.length() + a2;
                        if (a2 < 0 || length2 < 0) {
                            SpannableStringBuilder append = spannableStringBuilder.append(str);
                            k.a((Object) append, "builder.append(text)");
                            return append;
                        }
                        spannableStringBuilder.append(str);
                        spannableStringBuilder.setSpan(new StyleSpan(1), a2, length2, 0);
                        return spannableStringBuilder;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        SpannableStringBuilder append2 = spannableStringBuilder.append(str);
        k.a((Object) append2, "builder.append(text)");
        return append2;
    }

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        final CJRSearchLayout f53346a;

        /* renamed from: b  reason: collision with root package name */
        final int f53347b;

        /* renamed from: c  reason: collision with root package name */
        final int f53348c;

        /* renamed from: d  reason: collision with root package name */
        final SpannableStringBuilder f53349d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f53350e;

        public a(b bVar, CJRSearchLayout cJRSearchLayout, int i2, int i3, SpannableStringBuilder spannableStringBuilder) {
            k.c(cJRSearchLayout, "searchLayout");
            k.c(spannableStringBuilder, "builder");
            this.f53350e = bVar;
            this.f53346a = cJRSearchLayout;
            this.f53347b = i2;
            this.f53348c = i3;
            this.f53349d = spannableStringBuilder;
        }
    }
}
