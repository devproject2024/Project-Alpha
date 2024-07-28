package net.one97.paytm.o2o.amusementpark.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel;
import net.one97.paytm.common.entity.amPark.CJRCategoriesDetailModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.e;

public final class e extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f73110a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRHomePageItem> f73111b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRAmParkDetailModel> f73112c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<CJRAmParkDetailModel> f73113d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    d f73114e;

    /* renamed from: f  reason: collision with root package name */
    public String f73115f;

    /* renamed from: g  reason: collision with root package name */
    private int f73116g = 120;

    /* renamed from: h  reason: collision with root package name */
    private int f73117h = 121;

    /* renamed from: i  reason: collision with root package name */
    private int f73118i = 122;
    private int j = 123;
    private int k = 124;
    private int l = 125;
    private int m = 126;
    private LayoutInflater n;
    private List<String> o = new ArrayList();
    private List<String> p = new ArrayList();
    private int q = 0;
    private boolean r;

    public interface d {
        void a(IJRPaytmDataModel iJRPaytmDataModel, int i2, String str);

        void a(String str);

        void a(String str, String str2, String str3, String str4);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public e(Context context, List<String> list, ArrayList<CJRHomePageItem> arrayList, ArrayList<CJRAmParkDetailModel> arrayList2, d dVar, String str) {
        this.f73110a = context;
        this.o = list;
        this.f73111b = arrayList;
        this.f73115f = str;
        this.r = true;
        a(arrayList2, this.f73115f);
        this.f73114e = dVar;
    }

    public final void a(ArrayList<CJRAmParkDetailModel> arrayList, String str) {
        this.p = new ArrayList();
        this.f73115f = str;
        this.r = true;
        if (arrayList != null) {
            this.f73113d = new ArrayList<>();
            this.f73112c = arrayList;
            if (arrayList.size() <= 1 || TextUtils.isEmpty(str) || str.equalsIgnoreCase(AppConstants.FOR_ALL)) {
                this.f73113d = arrayList;
            } else {
                Iterator<CJRAmParkDetailModel> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRAmParkDetailModel next = it2.next();
                    ArrayList<CJRCategoriesDetailModel> categories = next.getCategories();
                    if (categories != null && !categories.isEmpty()) {
                        Iterator<CJRCategoriesDetailModel> it3 = categories.iterator();
                        while (it3.hasNext()) {
                            CJRCategoriesDetailModel next2 = it3.next();
                            if (!TextUtils.isEmpty(next2.getCategory()) && (next2.getCategory().equalsIgnoreCase(str) || next2.getCategory().contains(str))) {
                                this.f73113d.add(next);
                            }
                        }
                    }
                }
            }
        }
        ArrayList<CJRHomePageItem> arrayList2 = this.f73111b;
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.p.add("ViewPager");
        }
        List<String> list = this.o;
        if (list != null && list.size() > 0) {
            if (arrayList != null && arrayList.size() > 0 && !arrayList.get(0).getName().equals("HorizontalList")) {
                this.p.add("HorizontalList");
            }
            if (arrayList != null) {
                this.p.add("homeGridList");
            }
        }
        this.p.add("EmptyView");
        List<String> list2 = this.p;
        if (list2 != null) {
            this.q = list2.size();
        }
        Context context = this.f73110a;
        if (context != null) {
            this.n = (LayoutInflater) context.getSystemService("layout_inflater");
        }
        notifyDataSetChanged();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == this.f73116g) {
            return new C1472e(this.n.inflate(R.layout.park_top_view_pager, viewGroup, false));
        }
        if (i2 == this.f73117h) {
            return new a(this.n.inflate(R.layout.park_top_category_list, viewGroup, false));
        }
        if (i2 == this.f73118i) {
            return new c(this.n.inflate(R.layout.ampark_main_grid_list, viewGroup, false));
        }
        if (i2 == this.m) {
            return new b(this.n.inflate(R.layout.park_empty_view, viewGroup, false));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof C1472e) {
            C1472e eVar = (C1472e) vVar;
            Context context = this.f73110a;
            eVar.f73129e = this.f73111b;
            eVar.f73127c.setAdapter(new k(context, eVar.f73129e, e.this.f73114e));
            if (eVar.f73129e != null && !eVar.f73129e.isEmpty() && !eVar.f73129e.get(0).isVisited()) {
                eVar.a(0);
            }
            eVar.f73128d.setViewPager(eVar.f73127c);
        } else if (vVar instanceof a) {
            a aVar = (a) vVar;
            Context context2 = this.f73110a;
            List<String> list = this.o;
            aVar.f73120b = list;
            aVar.f73119a.setAdapter(new c(context2, list, e.this.f73114e, e.this.f73115f));
            if (list != null && list.size() > 0 && !TextUtils.isEmpty(e.this.f73115f)) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (list.get(i3).equalsIgnoreCase(e.this.f73115f)) {
                        aVar.f73119a.smoothScrollToPosition(i3);
                    }
                }
            }
        } else if (vVar instanceof c) {
            c cVar = (c) vVar;
            cVar.f73123a.setAdapter(new d(this.f73110a, e.this.f73113d, e.this.f73114e));
        }
    }

    public final int getItemViewType(int i2) {
        if (this.p.get(i2).equals("ViewPager")) {
            return this.f73116g;
        }
        if (this.p.get(i2).equals("HorizontalList")) {
            return this.f73117h;
        }
        if (this.p.get(i2).equals("ViewMore")) {
            return this.j;
        }
        if (this.p.get(i2).equals("homeGridList")) {
            return this.f73118i;
        }
        if (this.p.get(i2).equals("horizontal_C2")) {
            return this.k;
        }
        if (this.p.get(i2).equals("horizontal_C3")) {
            return this.l;
        }
        return this.m;
    }

    public final int getItemCount() {
        return this.q;
    }

    /* renamed from: net.one97.paytm.o2o.amusementpark.a.e$e  reason: collision with other inner class name */
    public class C1472e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        int f73125a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f73126b;

        /* renamed from: c  reason: collision with root package name */
        ViewPager f73127c;

        /* renamed from: d  reason: collision with root package name */
        CirclePageIndicator f73128d;

        /* renamed from: e  reason: collision with root package name */
        ArrayList<CJRHomePageItem> f73129e;

        /* renamed from: f  reason: collision with root package name */
        public Runnable f73130f;

        /* renamed from: g  reason: collision with root package name */
        public Handler f73131g;

        /* renamed from: i  reason: collision with root package name */
        private long f73133i = 2;
        private long j = ((long) net.one97.paytm.o2o.amusementpark.a.a().getIntFromGTM("banner_swipe_duration"));

        public C1472e(View view) {
            super(view);
            long j2 = this.j;
            this.f73126b = (j2 == 0 ? this.f73133i : j2) * 1000;
            this.f73127c = (ViewPager) view.findViewById(R.id.view_pager_event_image);
            this.f73128d = (CirclePageIndicator) view.findViewById(R.id.page_indicator);
            this.f73131g = new Handler();
            this.f73130f = new Runnable(e.this) {
                public final void run() {
                    if (C1472e.this.f73129e != null && !C1472e.this.f73129e.isEmpty()) {
                        if (C1472e.this.f73125a == C1472e.this.f73129e.size()) {
                            C1472e.this.f73125a = 0;
                        }
                        ViewPager viewPager = C1472e.this.f73127c;
                        C1472e eVar = C1472e.this;
                        int i2 = eVar.f73125a;
                        eVar.f73125a = i2 + 1;
                        viewPager.setCurrentItem(i2, true);
                    }
                    C1472e.this.f73131g.postDelayed(this, C1472e.this.f73126b);
                }
            };
            this.f73131g.postDelayed(this.f73130f, this.f73126b);
            this.f73127c.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return e.C1472e.this.a(view, motionEvent);
                }
            });
            this.f73127c.addOnPageChangeListener(new ViewPager.e(e.this) {
                public final void onPageScrollStateChanged(int i2) {
                }

                public final void onPageScrolled(int i2, float f2, int i3) {
                }

                public final void onPageSelected(int i2) {
                    if (!C1472e.this.f73129e.get(i2).isVisited()) {
                        C1472e.this.a(i2);
                    }
                    C1472e.this.f73125a = i2;
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                this.f73131g.removeCallbacks(this.f73130f);
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                this.f73131g.postDelayed(this.f73130f, this.f73126b);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            this.f73129e.get(i2).setVisited(true);
            StringBuilder sb = new StringBuilder("is visited: ");
            sb.append(i2);
            sb.append(" ");
            sb.append(this.f73129e.get(i2).isVisited());
            CJRHomePageItem cJRHomePageItem = this.f73129e.get(i2);
            CJRHomePageItem cJRHomePageItem2 = new CJRHomePageItem();
            cJRHomePageItem2.setParentItem("-C1");
            cJRHomePageItem2.setUrl(cJRHomePageItem.getURL());
            cJRHomePageItem2.setItemID(cJRHomePageItem.getItemID());
            cJRHomePageItem2.setName(cJRHomePageItem.getName());
            net.one97.paytm.o2o.amusementpark.a.b().sendPromotionImpression(cJRHomePageItem2, e.this.f73110a, i2, "/amusement-parks");
        }
    }

    public class b extends RecyclerView.v {
        public b(View view) {
            super(view);
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f73119a;

        /* renamed from: b  reason: collision with root package name */
        List<String> f73120b;

        public a(View view) {
            super(view);
            this.f73119a = (RecyclerView) view.findViewById(R.id.events_home_page_category_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(e.this.f73110a);
            linearLayoutManager.setOrientation(0);
            this.f73119a.setLayoutManager(linearLayoutManager);
        }
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f73123a;

        public c(View view) {
            super(view);
            this.f73123a = (RecyclerView) view.findViewById(R.id.am_park_home_grid_list);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(e.this.f73110a, 1);
            this.f73123a.setHasFixedSize(true);
            this.f73123a.setLayoutManager(gridLayoutManager);
        }
    }
}
