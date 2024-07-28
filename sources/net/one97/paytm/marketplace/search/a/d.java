package net.one97.paytm.marketplace.search.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRSearchCuration;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.CJRSearchPage;
import net.one97.paytm.marketplace.search.activity.AJRSearchActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;

public final class d extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f53394a;

    /* renamed from: b  reason: collision with root package name */
    public int f53395b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<C0959d> f53396c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    b f53397d;

    /* renamed from: e  reason: collision with root package name */
    public int f53398e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f53399f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<CJRSearchLayout> f53400g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private final int f53401h;

    /* renamed from: i  reason: collision with root package name */
    private final int f53402i;

    public interface b {
        void a(String str, int i2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration);

        void b();
    }

    public d(Context context, CJRSearchPage cJRSearchPage, b bVar) {
        k.c(context, "context");
        k.c(cJRSearchPage, "searchPage");
        k.c(bVar, "popularSearchClickListener");
        this.f53394a = context;
        this.f53397d = bVar;
        this.f53401h = 1;
        this.f53402i = 2;
        this.f53399f = LayoutInflater.from(context);
        ArrayList<CJRSearchLayout> keyWordsLayoutList = cJRSearchPage.getKeyWordsLayoutList();
        k.a((Object) keyWordsLayoutList, "searchPage.keyWordsLayoutList");
        this.f53400g = keyWordsLayoutList;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f53398e || i2 == this.f53401h) {
            LayoutInflater layoutInflater = this.f53399f;
            if (layoutInflater == null) {
                k.a();
            }
            View inflate = layoutInflater.inflate(R.layout.layout_popular_search_item, viewGroup, false);
            k.a((Object) inflate, "mInflater!!.inflate(R.la…arch_item, parent, false)");
            return new c(this, inflate);
        } else if (i2 == this.f53402i) {
            LayoutInflater layoutInflater2 = this.f53399f;
            if (layoutInflater2 == null) {
                k.a();
            }
            View inflate2 = layoutInflater2.inflate(R.layout.layout_header_item, viewGroup, false);
            k.a((Object) inflate2, "mInflater!!.inflate(R.la…ader_item, parent, false)");
            return new a(this, inflate2);
        } else {
            LayoutInflater layoutInflater3 = this.f53399f;
            if (layoutInflater3 == null) {
                k.a();
            }
            View inflate3 = layoutInflater3.inflate(R.layout.layout_popular_search_item, viewGroup, false);
            k.a((Object) inflate3, "mInflater!!.inflate(R.la…arch_item, parent, false)");
            return new c(this, inflate3);
        }
    }

    public final int getItemCount() {
        return this.f53396c.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "viewHolder");
        Collection collection = this.f53396c;
        if (!(collection == null || collection.isEmpty())) {
            int itemViewType = vVar.getItemViewType();
            if (itemViewType == this.f53398e || itemViewType == this.f53401h) {
                c cVar = (c) vVar;
                C0959d dVar = cVar.f53409c.f53396c.get(i2);
                k.a((Object) dVar, "mPopularSearchList[position]");
                C0959d dVar2 = dVar;
                TextView textView = cVar.f53407a;
                if (textView != null) {
                    textView.setText(dVar2.f53413b);
                }
                ConstraintLayout constraintLayout = cVar.f53408b;
                if (constraintLayout != null) {
                    constraintLayout.setOnClickListener(new c.a(cVar, dVar2));
                }
            } else if (itemViewType == this.f53402i) {
                a aVar = (a) vVar;
                C0959d dVar3 = aVar.f53405c.f53396c.get(i2);
                k.a((Object) dVar3, "mPopularSearchList[position]");
                C0959d dVar4 = dVar3;
                TextView textView2 = aVar.f53403a;
                if (textView2 != null) {
                    textView2.setText(dVar4.f53413b);
                }
                new ArrayList().add(aVar.f53405c.f53396c.get(i2));
                View view = aVar.f53404b;
                if (view != null) {
                    view.setOnClickListener(new a.C0958a(aVar));
                }
                boolean a2 = a();
                View view2 = aVar.f53404b;
                if (a2) {
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                } else if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }
    }

    public final int getItemViewType(int i2) {
        Collection collection = this.f53396c;
        if (!(collection == null || collection.isEmpty())) {
            return this.f53396c.get(i2).f53414c;
        }
        return this.f53398e;
    }

    private static String a(String str) {
        try {
            String decode = URLDecoder.decode(str);
            k.a((Object) decode, "URLDecoder.decode(searchText)");
            return decode;
        } catch (Exception unused) {
            return str;
        }
    }

    public final void a(CJRSearchPage cJRSearchPage) {
        CJRSearchLayout cJRSearchLayout;
        this.f53396c.clear();
        if (cJRSearchPage != null) {
            ArrayList<CJRSearchLayout> keyWordsLayoutList = cJRSearchPage.getKeyWordsLayoutList();
            k.a((Object) keyWordsLayoutList, "searchpage.keyWordsLayoutList");
            this.f53400g = keyWordsLayoutList;
            int displayCount = cJRSearchPage.getDisplayCount();
            int size = this.f53400g.size();
            if (cJRSearchPage.getDisplayCount() > 0) {
                this.f53395b = displayCount - size;
            }
            String str = null;
            if (AJRSearchActivity.f53438a != null) {
                int size2 = AJRSearchActivity.f53438a.size();
                if (size2 > 0) {
                    ArrayList<C0959d> arrayList = this.f53396c;
                    Context context = this.f53394a;
                    String string = context != null ? context.getString(R.string.recently_searched) : null;
                    if (string == null) {
                        k.a();
                    }
                    k.a((Object) string, "mContext?.getString(R.string.recently_searched)!!");
                    arrayList.add(new C0959d(this, string, this.f53402i, (HashMap<String, String>) null, (String) null));
                }
                for (int i2 = 0; i2 < size2; i2++) {
                    if (i2 < this.f53395b && (cJRSearchLayout = AJRSearchActivity.f53438a.get(i2)) != null && !TextUtils.isEmpty(cJRSearchLayout.getText())) {
                        ArrayList<C0959d> arrayList2 = this.f53396c;
                        String text = cJRSearchLayout.getText();
                        k.a((Object) text, "searchLayout.text");
                        arrayList2.add(new C0959d(this, a(text), this.f53398e, cJRSearchLayout.getmFilterAttributes(), cJRSearchLayout.getAPIUrl()));
                    }
                }
            }
            int i3 = displayCount - this.f53395b;
            if (i3 > size || i3 <= size) {
                i3 = size;
            }
            if (!a()) {
                if (i3 > 0) {
                    ArrayList<C0959d> arrayList3 = this.f53396c;
                    Context context2 = this.f53394a;
                    if (context2 != null) {
                        str = context2.getString(R.string.app_trending_search);
                    }
                    String str2 = str;
                    if (str2 == null) {
                        k.a();
                    }
                    k.a((Object) str2, "mContext?.getString(R.st…ng.app_trending_search)!!");
                    arrayList3.add(new C0959d(this, str2, this.f53402i, (HashMap<String, String>) null, (String) null));
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    CJRSearchLayout cJRSearchLayout2 = this.f53400g.get(i4);
                    k.a((Object) cJRSearchLayout2, "mKeyWordsList[j]");
                    CJRSearchLayout cJRSearchLayout3 = cJRSearchLayout2;
                    String text2 = cJRSearchLayout3.getText();
                    k.a((Object) text2, "searchItem.text");
                    C0959d dVar = new C0959d(this, text2, this.f53401h, this.f53400g.get(i4).getmFilterAttributes(), (String) null);
                    dVar.f53412a = cJRSearchLayout3.getSearchCuration();
                    this.f53396c.add(dVar);
                }
            }
            notifyDataSetChanged();
        }
    }

    private static boolean a() {
        return AJRSearchActivity.f53438a != null && !AJRSearchActivity.f53438a.isEmpty();
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f53407a;

        /* renamed from: b  reason: collision with root package name */
        ConstraintLayout f53408b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f53409c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d dVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f53409c = dVar;
            this.f53407a = (TextView) view.findViewById(R.id.popular_search_item_text);
            this.f53408b = (ConstraintLayout) view.findViewById(R.id.search_item_text_container);
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f53410a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C0959d f53411b;

            a(c cVar, C0959d dVar) {
                this.f53410a = cVar;
                this.f53411b = dVar;
            }

            public final void onClick(View view) {
                b bVar = this.f53410a.f53409c.f53397d;
                if (bVar != null) {
                    bVar.a(this.f53411b.f53413b, this.f53411b.f53414c, this.f53411b.f53415d, this.f53411b.f53412a);
                }
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f53403a;

        /* renamed from: b  reason: collision with root package name */
        View f53404b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f53405c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f53405c = dVar;
            this.f53403a = (TextView) view.findViewById(R.id.header_text);
            this.f53404b = view.findViewById(R.id.clear_text);
        }

        /* renamed from: net.one97.paytm.marketplace.search.a.d$a$a  reason: collision with other inner class name */
        static final class C0958a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f53406a;

            C0958a(a aVar) {
                this.f53406a = aVar;
            }

            public final void onClick(View view) {
                d dVar = this.f53406a.f53405c;
                Iterator<C0959d> it2 = dVar.f53396c.iterator();
                String str = "";
                String str2 = str;
                while (it2.hasNext()) {
                    C0959d next = it2.next();
                    if (Integer.valueOf(dVar.f53398e).equals(Integer.valueOf(next.f53414c))) {
                        if (!(str2.length() == 0)) {
                            str2 = str2 + ',';
                        }
                        str2 = str2 + next.f53413b;
                    }
                }
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder("search");
                Context context = dVar.f53394a;
                if (context instanceof AJRSearchActivity) {
                    str = AJRSearchActivity.a(((AJRSearchActivity) context).getIntent());
                }
                sb.append(str);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, sb.toString());
                hashMap.put("search_term", str2);
                hashMap.put("search_type", "recent");
                net.one97.paytm.j.a.b("search_term_deleted", (Map<String, Object>) hashMap, dVar.f53394a);
                b bVar = this.f53406a.f53405c.f53397d;
                if (bVar != null) {
                    bVar.b();
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.marketplace.search.a.d$d  reason: collision with other inner class name */
    public final class C0959d {

        /* renamed from: a  reason: collision with root package name */
        CJRSearchCuration f53412a;

        /* renamed from: b  reason: collision with root package name */
        String f53413b;

        /* renamed from: c  reason: collision with root package name */
        int f53414c;

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, String> f53415d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f53416e;

        /* renamed from: f  reason: collision with root package name */
        private String f53417f;

        public C0959d(d dVar, String str, int i2, HashMap<String, String> hashMap, String str2) {
            k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            this.f53416e = dVar;
            this.f53413b = str;
            this.f53414c = i2;
            this.f53415d = hashMap;
            this.f53417f = str2;
        }
    }
}
