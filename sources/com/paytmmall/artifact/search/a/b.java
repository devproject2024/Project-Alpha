package com.paytmmall.artifact.search.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.search.a.b;
import com.paytmmall.artifact.search.activity.AJRSearchActivity;
import com.paytmmall.artifact.search.entity.CJRSearchCuration;
import com.paytmmall.artifact.search.entity.CJRSearchLayout;
import com.paytmmall.artifact.search.entity.CJRSearchPage;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public final class b extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public static int f15905b = 0;

    /* renamed from: g  reason: collision with root package name */
    private static int f15906g = 1;

    /* renamed from: a  reason: collision with root package name */
    public int f15907a;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f15908c;

    /* renamed from: d  reason: collision with root package name */
    private Context f15909d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRSearchLayout> f15910e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<C0215b> f15911f = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private a f15912h;

    public interface a {
        void a(String str, int i2, HashMap<String, String> hashMap, CJRSearchCuration cJRSearchCuration, String str2);

        void a(String str, HashMap<String, String> hashMap);

        void c();
    }

    /* renamed from: com.paytmmall.artifact.search.a.b$b  reason: collision with other inner class name */
    class C0215b {

        /* renamed from: a  reason: collision with root package name */
        public int f15913a;

        /* renamed from: b  reason: collision with root package name */
        public String f15914b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f15915c;

        /* renamed from: d  reason: collision with root package name */
        public String f15916d;

        /* renamed from: e  reason: collision with root package name */
        public CJRSearchCuration f15917e;

        C0215b(String str, int i2, HashMap<String, String> hashMap, String str2) {
            this.f15914b = str;
            this.f15913a = i2;
            this.f15915c = hashMap;
            this.f15916d = str2;
        }
    }

    public b(Context context, CJRSearchPage cJRSearchPage, a aVar) {
        this.f15908c = LayoutInflater.from(context);
        this.f15909d = context;
        this.f15910e = cJRSearchPage.getKeyWordsLayoutList();
        this.f15912h = aVar;
    }

    public final int getCount() {
        return this.f15911f.size();
    }

    public final Object getItem(int i2) {
        return this.f15911f.get(i2);
    }

    public final long getItemId(int i2) {
        return (long) this.f15911f.get(i2).hashCode();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f15908c.inflate(R.layout.mall_lyt_poular_search, viewGroup, false);
            c cVar = new c();
            cVar.f15919a = (TextView) view.findViewById(R.id.popular_search_item_text);
            cVar.f15920b = (TextView) view.findViewById(R.id.header_text);
            cVar.f15921c = (RelativeLayout) view.findViewById(R.id.search_item_text_container);
            cVar.f15922d = (RelativeLayout) view.findViewById(R.id.search_header_layout);
            cVar.f15923e = view.findViewById(R.id.trending_search);
            cVar.f15924f = view.findViewById(R.id.fill);
            cVar.f15925g = view.findViewById(R.id.clear_text);
            d.c(cVar.f15919a);
            view.setTag(cVar);
        }
        c cVar2 = (c) view.getTag();
        C0215b bVar = this.f15911f.get(i2);
        String str = bVar.f15914b;
        cVar2.f15919a.setText(str);
        cVar2.f15921c.setOnClickListener(new View.OnClickListener(str, bVar) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ b.C0215b f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                b.this.b(this.f$1, this.f$2, view);
            }
        });
        if (bVar.f15913a == f15905b) {
            cVar2.f15921c.setVisibility(0);
            cVar2.f15922d.setVisibility(8);
            cVar2.f15924f.setVisibility(0);
            cVar2.f15923e.setVisibility(8);
            cVar2.f15924f.setOnClickListener(new View.OnClickListener(str, bVar) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ b.C0215b f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    b.this.a(this.f$1, this.f$2, view);
                }
            });
        } else if (bVar.f15913a == f15906g) {
            cVar2.f15922d.setVisibility(8);
            cVar2.f15921c.setVisibility(0);
            cVar2.f15924f.setVisibility(8);
            cVar2.f15923e.setVisibility(0);
        } else {
            cVar2.f15922d.setVisibility(0);
            cVar2.f15921c.setVisibility(8);
            cVar2.f15920b.setText(str);
            if (str.equalsIgnoreCase(this.f15909d.getString(R.string.app_recent_search))) {
                cVar2.f15925g.setVisibility(0);
                cVar2.f15925g.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        b.this.a(view);
                    }
                });
            } else {
                cVar2.f15925g.setVisibility(8);
            }
        }
        return view;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str, C0215b bVar, View view) {
        this.f15912h.a(str, bVar.f15913a, bVar.f15915c, bVar.f15917e, bVar.f15916d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, C0215b bVar, View view) {
        this.f15912h.a(str, bVar.f15915c);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f15912h.c();
    }

    public final void a(CJRSearchPage cJRSearchPage) {
        CJRSearchLayout cJRSearchLayout;
        this.f15911f.clear();
        if (cJRSearchPage != null) {
            this.f15910e = cJRSearchPage.getKeyWordsLayoutList();
            int displayCount = cJRSearchPage.getDisplayCount();
            int size = this.f15910e.size();
            if (cJRSearchPage.getDisplayCount() > 0) {
                this.f15907a = displayCount - size;
            }
            if (AJRSearchActivity.f15950a != null) {
                int size2 = AJRSearchActivity.f15950a.size();
                if (size2 > 0) {
                    this.f15911f.add(new C0215b(this.f15909d.getString(R.string.app_recent_search), 2, (HashMap<String, String>) null, (String) null));
                }
                for (int i2 = 0; i2 < size2; i2++) {
                    if (i2 < this.f15907a && (cJRSearchLayout = AJRSearchActivity.f15950a.get(i2)) != null && !TextUtils.isEmpty(cJRSearchLayout.getText())) {
                        this.f15911f.add(new C0215b(a(cJRSearchLayout.getText()), f15905b, cJRSearchLayout.getmFilterAttributes(), cJRSearchLayout.getUrl()));
                    }
                }
            }
            int i3 = displayCount - this.f15907a;
            if (i3 > size || i3 <= size) {
                i3 = size;
            }
            if (i3 > 0) {
                this.f15911f.add(new C0215b(this.f15909d.getString(R.string.app_trending_search), 2, (HashMap<String, String>) null, (String) null));
            }
            for (int i4 = 0; i4 < i3; i4++) {
                CJRSearchLayout cJRSearchLayout2 = this.f15910e.get(i4);
                C0215b bVar = new C0215b(cJRSearchLayout2.getText(), f15906g, this.f15910e.get(i4).getmFilterAttributes(), (String) null);
                bVar.f15917e = cJRSearchLayout2.getSearchCuration();
                this.f15911f.add(bVar);
            }
            notifyDataSetChanged();
        }
    }

    private static String a(String str) {
        try {
            return URLDecoder.decode(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        TextView f15919a;

        /* renamed from: b  reason: collision with root package name */
        TextView f15920b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f15921c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f15922d;

        /* renamed from: e  reason: collision with root package name */
        View f15923e;

        /* renamed from: f  reason: collision with root package name */
        View f15924f;

        /* renamed from: g  reason: collision with root package name */
        View f15925g;

        public c() {
        }
    }
}
