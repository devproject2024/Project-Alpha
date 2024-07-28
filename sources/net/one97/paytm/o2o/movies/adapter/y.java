package net.one97.paytm.o2o.movies.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.o;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.t;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.aa;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesGridPage;
import net.one97.paytm.o2o.movies.adapter.ad;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem;
import net.one97.paytm.o2o.movies.common.movies.search.GroupFormatObject;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem;
import net.one97.paytm.o2o.movies.entity.events.Carousel;
import net.one97.paytm.o2o.movies.utils.n;

public class y extends RecyclerView.a<RecyclerView.v> implements ad.a, net.one97.paytm.o2o.movies.d.a {
    /* access modifiers changed from: private */
    public ArrayList<CJRMovieHomeListItem> A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public int C;
    /* access modifiers changed from: private */
    public int D;

    /* renamed from: a  reason: collision with root package name */
    public o f74814a = null;

    /* renamed from: b  reason: collision with root package name */
    public Activity f74815b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public String f74816c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74817d = true;

    /* renamed from: e  reason: collision with root package name */
    public h f74818e;

    /* renamed from: f  reason: collision with root package name */
    private final String f74819f = y.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    private final int f74820g = 4;

    /* renamed from: h  reason: collision with root package name */
    private final int f74821h = 7;

    /* renamed from: i  reason: collision with root package name */
    private final int f74822i = 8;
    private final int j = 9;
    private final int k = 2;
    private final int l = 12;
    private final int m = 11;
    private final int n = 13;
    private final int o = 14;
    private final int p = 1;
    private final int q = -1;
    private ArrayList<CJRMoviesHomePageItem> r;
    /* access modifiers changed from: private */
    public int s;
    private i t;
    /* access modifiers changed from: private */
    public String u;
    private aj.a v;
    /* access modifiers changed from: private */
    public j w;
    private int x;
    private boolean y;
    /* access modifiers changed from: private */
    public boolean z;

    public interface i {
        void a(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3);
    }

    public interface j {
        void a(CJRCinemas cJRCinemas);

        void g();
    }

    public y(Activity activity, int i2, ArrayList<CJRMoviesHomePageItem> arrayList, i iVar, CJRSelectCityModel cJRSelectCityModel, String str, aj.a aVar, j jVar) {
        this.f74815b = activity;
        this.s = i2;
        this.r = arrayList;
        this.f74816c = cJRSelectCityModel.getValue();
        this.t = iVar;
        this.u = str;
        this.v = aVar;
        this.w = jVar;
        this.C = n.a(3, (Context) this.f74815b);
        this.D = n.a(4, (Context) this.f74815b);
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i2) {
            case 1:
                return new g(from.inflate(R.layout.movies_homescreen_horizontal_list, viewGroup, false), this.w);
            case 2:
                return new l(from.inflate(R.layout.movie_view_more_lyt, viewGroup, false));
            case 3:
                return new e(from.inflate(R.layout.movie_recycler_grid_item, viewGroup, false));
            case 4:
                return new k(from.inflate(R.layout.no_movies_lyt, viewGroup, false));
            case 7:
                return new f(from.inflate(R.layout.movies_home_offer, viewGroup, false));
            case 8:
                return new f(from.inflate(R.layout.movies_home_offer, viewGroup, false));
            case 9:
                return new h(from.inflate(R.layout.upcoming_movies_container_layout, viewGroup, false));
            case 11:
                return new a(from.inflate(R.layout.digital_events_row_home, viewGroup, false));
            case 12:
                return new d(from.inflate(R.layout.events_movies_home_horizontal_rv, viewGroup, false));
            case 13:
                return new c(from.inflate(R.layout.movie_event_categories_home, viewGroup, false));
            case 14:
                return new b(from.inflate(R.layout.home_row_movie_event_divider, viewGroup, false));
            default:
                return new b(from.inflate(R.layout.layout_empty_view, viewGroup, false));
        }
    }

    public final void a(IJRDataModel iJRDataModel) {
        if (iJRDataModel instanceof CJRHomePageItem) {
            this.t.a(((CJRHomePageItem) iJRDataModel).getURLType(), iJRDataModel, "", 0, (ArrayList<? extends CJRItem>) null, false, "");
        }
    }

    public int getItemCount() {
        ArrayList<CJRMoviesHomePageItem> arrayList = this.r;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            CJRMoviesHomePageItem cJRMoviesHomePageItem = this.r.get(i3);
            if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("top_movies")) {
                this.A = cJRMoviesHomePageItem.getMoviesListV2();
                this.x = this.A.size();
                this.y = this.f74817d && this.x > 8;
                if (this.y) {
                    if (this.z) {
                        this.x++;
                    } else {
                        this.x = 9;
                    }
                }
                i2 += this.x;
            } else {
                i2++;
            }
        }
        return i2;
    }

    public int getItemViewType(int i2) {
        int i3 = this.x;
        if (i2 < i3) {
            return (!this.y || i2 != i3 - 1) ? 3 : 2;
        }
        CJRMoviesHomePageItem cJRMoviesHomePageItem = this.r.get(i2 - (i3 == 0 ? 0 : i3 - 1));
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("no_movies")) {
            return 4;
        }
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("carousel_4")) {
            return 7;
        }
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("carousel_5")) {
            return 8;
        }
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("upcoming_movies")) {
            return 9;
        }
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("cinemas")) {
            return 1;
        }
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("digital_event")) {
            return 11;
        }
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("event_carousel")) {
            return 12;
        }
        if (cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("event_categories")) {
            return 13;
        }
        return cJRMoviesHomePageItem.getRowType().equalsIgnoreCase("event_movie_divider") ? 14 : -1;
    }

    class l extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f74866a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74867b;

        public l(View view) {
            super(view);
            this.f74866a = (ImageView) view.findViewById(R.id.img_view_more);
            this.f74867b = (TextView) view.findViewById(R.id.txt_view_more);
            view.setOnClickListener(new View.OnClickListener(y.this) {

                /* renamed from: a  reason: collision with root package name */
                public boolean f74869a;

                public final void onClick(View view) {
                    if (!this.f74869a) {
                        l.this.f74866a.animate().rotationBy(180.0f).setDuration(200).withEndAction(new Runnable() {
                            public final void run() {
                                boolean unused = y.this.z = !y.this.z;
                                if (y.this.z) {
                                    boolean unused2 = y.this.B = true;
                                    y.this.notifyItemRangeInserted(8, y.this.A.size() - 8);
                                } else {
                                    boolean unused3 = y.this.B = false;
                                    y.this.notifyItemRangeRemoved(8, y.this.A.size() - 8);
                                }
                                l.this.a();
                                AnonymousClass1.this.f74869a = false;
                            }
                        }).start();
                        this.f74869a = true;
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (y.this.z) {
                this.f74867b.setText(y.this.f74815b.getResources().getString(net.one97.paytm.common.assets.R.string.view_less));
            } else {
                this.f74867b.setText(y.this.f74815b.getResources().getString(R.string.movies_view_more, new Object[]{Integer.valueOf(y.this.A.size())}));
            }
            this.f74866a.setRotation(y.this.z ? 180.0f : 0.0f);
        }
    }

    public class e extends RecyclerView.v {

        /* renamed from: b  reason: collision with root package name */
        private final LinearLayout f74834b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f74835c;

        /* renamed from: d  reason: collision with root package name */
        private RoboTextView f74836d;

        /* renamed from: e  reason: collision with root package name */
        private RoboTextView f74837e;

        /* renamed from: f  reason: collision with root package name */
        private View f74838f;

        /* renamed from: g  reason: collision with root package name */
        private LinearLayout f74839g;

        /* renamed from: h  reason: collision with root package name */
        private RoboTextView f74840h;

        /* renamed from: i  reason: collision with root package name */
        private ImageView f74841i;
        private TextView j;

        public e(View view) {
            super(view);
            this.f74838f = view;
            this.f74835c = (ImageView) view.findViewById(R.id.thumb_nail);
            this.f74840h = (RoboTextView) view.findViewById(R.id.percentageCountLikeDislike);
            this.f74841i = (ImageView) view.findViewById(R.id.iconLikeDisklike);
            this.f74836d = (RoboTextView) view.findViewById(R.id.movie_name);
            this.f74837e = (RoboTextView) view.findViewById(R.id.movie_language);
            this.f74834b = (LinearLayout) view.findViewById(R.id.id_format_ll);
            this.f74839g = (LinearLayout) view.findViewById(R.id.likeDislikeLayout);
            this.j = (TextView) view.findViewById(R.id.new_movie_indicator_tv);
        }

        public final void a(int i2) {
            Drawable drawable;
            CJRMetricInfoDataItem likeDislikeInfo;
            int size;
            boolean z;
            CJRMovieHomeListItem cJRMovieHomeListItem = (CJRMovieHomeListItem) y.this.A.get(i2);
            y.a(y.this, cJRMovieHomeListItem);
            if (cJRMovieHomeListItem != null) {
                String imgPath = TextUtils.isEmpty(cJRMovieHomeListItem.getEdgeBanner()) ? cJRMovieHomeListItem.getImgPath() : cJRMovieHomeListItem.getEdgeBanner();
                if (imgPath != null && !imgPath.startsWith("https://") && !imgPath.startsWith("http://")) {
                    imgPath = "https://".concat(String.valueOf(imgPath));
                }
                try {
                    drawable = androidx.core.content.b.a((Context) y.this.f74815b, R.drawable.movie_home_banner_placeholder);
                } catch (Throwable unused) {
                    drawable = null;
                }
                if (drawable == null) {
                    drawable = new ColorDrawable(androidx.core.content.b.c(y.this.f74815b, R.color.white_smoke));
                }
                boolean z2 = false;
                if (cJRMovieHomeListItem.isNew()) {
                    this.j.setVisibility(0);
                } else {
                    this.j.setVisibility(8);
                }
                aa a2 = w.a().a(imgPath);
                a2.f45353b = true;
                a2.b(drawable).a(drawable).a((ah) new t.b(y.this.C, 0, false)).a(this.f74835c, (com.squareup.picasso.e) null);
                if (!TextUtils.isEmpty(cJRMovieHomeListItem.getLabel())) {
                    this.f74836d.setVisibility(0);
                    this.f74836d.setText(cJRMovieHomeListItem.getLabel());
                } else {
                    this.f74836d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cJRMovieHomeListItem.getLang())) {
                    String lang = cJRMovieHomeListItem.getLang();
                    if (!TextUtils.isEmpty(cJRMovieHomeListItem.getCensor())) {
                        lang = lang + " | (" + cJRMovieHomeListItem.getCensor() + ")";
                    }
                    this.f74837e.setText(lang);
                } else {
                    this.f74837e.setVisibility(8);
                }
                ArrayList<GroupFormatObject> scrnFmtList = cJRMovieHomeListItem.getScrnFmtList();
                this.f74834b.setVisibility(8);
                if (scrnFmtList != null && (size = scrnFmtList.size()) > 0) {
                    this.f74834b.removeAllViews();
                    if (scrnFmtList.size() != 1 || scrnFmtList.get(0).f75200a == null || !scrnFmtList.get(0).f75200a.equalsIgnoreCase("2D")) {
                        z = false;
                        for (int i3 = 0; i3 < size; i3++) {
                            if (!(scrnFmtList.get(i3) == null || scrnFmtList.get(i3).f75200a == null)) {
                                RoboTextView roboTextView = (RoboTextView) y.this.f74815b.getLayoutInflater().inflate(R.layout.movie_format_item, this.f74834b, false);
                                roboTextView.setText(scrnFmtList.get(i3).f75200a);
                                this.f74834b.addView(roboTextView);
                                Space space = new Space(y.this.f74815b);
                                space.setLayoutParams(new LinearLayout.LayoutParams(y.this.D, 1));
                                this.f74834b.addView(space);
                                z = true;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.f74834b.setVisibility(0);
                    }
                }
                this.f74840h.setVisibility(8);
                this.f74841i.setVisibility(8);
                this.f74839g.setVisibility(8);
                if (!(cJRMovieHomeListItem.getLikeDislikeInfo() == null || (likeDislikeInfo = cJRMovieHomeListItem.getLikeDislikeInfo()) == null || likeDislikeInfo.getMetricData() == null || likeDislikeInfo.getSessionData() == null)) {
                    if (likeDislikeInfo.getSessionData().getStatus() == 3 && likeDislikeInfo.getSessionData().getSessionCount() > 0 && likeDislikeInfo.getMetricData().getSentiment() != null && !TextUtils.isEmpty(likeDislikeInfo.getMetricData().getSentiment().getPercentage())) {
                        this.f74840h.setText(likeDislikeInfo.getMetricData().getSentiment().getPercentage() + "%");
                        this.f74840h.setVisibility(0);
                        this.f74839g.setVisibility(0);
                        this.f74841i.setImageDrawable(this.f74838f.getContext().getResources().getDrawable(R.drawable.heart));
                        this.f74841i.setVisibility(0);
                    } else if (likeDislikeInfo.getSessionData().getStatus() == 2 && likeDislikeInfo.getSessionData().getSessionCount() > 0 && cJRMovieHomeListItem.getLikeDislikeInfo().getMetricData().getInterested() != null && !TextUtils.isEmpty(n.a(cJRMovieHomeListItem.getLikeDislikeInfo().getMetricData().getInterested()))) {
                        this.f74840h.setText(n.a(cJRMovieHomeListItem.getLikeDislikeInfo().getMetricData().getInterested()));
                        this.f74840h.setVisibility(0);
                        this.f74841i.setImageDrawable(this.f74838f.getContext().getResources().getDrawable(R.drawable.thumb_up_sign));
                        this.f74841i.setVisibility(0);
                        this.f74839g.setVisibility(0);
                    }
                }
                if (y.this.B) {
                    View view = this.f74838f;
                    view.post(new Runnable(view) {
                        private final /* synthetic */ View f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            y.e.a(this.f$0);
                        }
                    });
                }
                View view2 = this.f74838f;
                if (i2 == 0) {
                    z2 = true;
                }
                view2.setFocusable(z2);
                this.f74838f.setOnClickListener(new View.OnClickListener(i2, cJRMovieHomeListItem) {
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ CJRMovieHomeListItem f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        y.e.this.a(this.f$1, this.f$2, view);
                    }
                });
                y yVar = y.this;
                try {
                    CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                    cJRHomePageItem.setName("/movies-list");
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendMoviePromotionImpression(cJRHomePageItem, yVar.f74815b, i2, "/movies/" + yVar.f74816c, cJRMovieHomeListItem.getLabel());
                } catch (Exception unused2) {
                }
                if (y.this.A.get(i2) != null && !((CJRMovieHomeListItem) y.this.A.get(i2)).getItemViewed()) {
                    ((CJRMovieHomeListItem) y.this.A.get(i2)).setItemViewed(true);
                }
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void a(View view) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            view.startAnimation(alphaAnimation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2, CJRMovieHomeListItem cJRMovieHomeListItem, View view) {
            CJRMovieHomeListItem cJRMovieHomeListItem2 = (CJRMovieHomeListItem) y.this.A.get(i2);
            String unused = y.this.f74816c;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies");
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.s);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Movie clicked");
                if (cJRMovieHomeListItem2 != null) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, cJRMovieHomeListItem2.getLabel() + "|" + cJRMovieHomeListItem2.getId() + "|" + (i2 + 1));
                }
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
                if (com.paytm.utility.b.r((Context) y.this.f74815b)) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) y.this.f74815b));
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, y.this.f74815b);
            } catch (Exception unused2) {
            }
            y yVar = y.this;
            try {
                CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                cJRHomePageItem.setName("/movies-list");
                int i3 = i2;
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendMoviePromotionImpressionClick(cJRHomePageItem, yVar.f74815b, i3, "/movies/" + yVar.f74816c, cJRMovieHomeListItem.getLabel());
                HashMap hashMap2 = new HashMap();
                hashMap2.put("city_name", yVar.f74816c);
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = new HashMap();
                HashMap hashMap5 = new HashMap();
                hashMap5.put("list", "Movie Listing");
                ArrayList arrayList = new ArrayList();
                HashMap hashMap6 = new HashMap();
                hashMap6.put("name", cJRMovieHomeListItem.getLabel());
                hashMap6.put("id", cJRMovieHomeListItem.getId());
                hashMap6.put("price", 0);
                hashMap6.put(CLPConstants.BRAND_PARAMS, yVar.f74816c);
                hashMap6.put("variant", cJRMovieHomeListItem.getScrnFmt());
                hashMap6.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2 + 1));
                net.one97.paytm.o2o.movies.b.a.INSTANCE.setPos(i2);
                arrayList.add(hashMap6);
                hashMap5.put("products", arrayList);
                hashMap4.put("actionField", hashMap5);
                hashMap3.put("click", hashMap4);
                hashMap2.put("ecommerce", hashMap3);
                hashMap2.put("vertical_name", "Entertainment - Movies");
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendEnhancedEcommerceEvent("productClick", hashMap2, yVar.f74815b);
            } catch (Exception unused3) {
            }
            Intent intent = new Intent(y.this.f74815b, AJRMovieDetailsV2Activity.class);
            ArrayList<CJRMovieHomeListItem> arrayList2 = new ArrayList<>();
            arrayList2.add(cJRMovieHomeListItem);
            net.one97.paytm.o2o.movies.utils.i.a().f75937g = arrayList2;
            intent.putExtra("movie_ticket_city_selected", y.this.f74816c);
            intent.putExtra("movie_ticket_selected_item_type", "movie");
            intent.putExtra("movie_ticket_selected_item_value", ((CJRMovieHomeListItem) y.this.A.get(i2)).getId());
            intent.putExtra("movie_ticket_selected_format_id", ((CJRMovieHomeListItem) y.this.A.get(i2)).getFrmtId());
            intent.putExtra("movie_ticket_other_screen_formats", (Parcelable) y.this.A.get(i2));
            intent.putExtra("url_type", y.this.u);
            y.this.f74815b.startActivity(intent);
            new StringBuilder("------Movie Selected----  ").append(((CJRMovieHomeListItem) y.this.A.get(i2)).getLabel());
            com.paytm.utility.b.j();
        }
    }

    class f extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f74842a;

        /* renamed from: b  reason: collision with root package name */
        int f74843b;

        public f(View view) {
            super(view);
            try {
                this.f74842a = (RecyclerView) view.findViewById(R.id.movies_horizontal_list);
                this.f74842a.setLayoutManager(new LinearLayoutManager(y.this.f74815b, 0, false));
                this.f74843b = n.a(10, (Context) y.this.f74815b);
                this.f74842a.setAdapter(new ab(y.this, n.a(3, (Context) y.this.f74815b)));
                if (this.f74842a.getItemDecorationCount() <= 0) {
                    this.f74842a.addItemDecoration(new RecyclerView.h(y.this) {
                        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                            super.getItemOffsets(rect, view, recyclerView, sVar);
                            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                            int a2 = n.a(20.0f);
                            if (childAdapterPosition == 0) {
                                rect.right = f.this.f74843b;
                                rect.left = a2;
                            } else if (f.this.f74842a.getAdapter() == null || childAdapterPosition != f.this.f74842a.getAdapter().getItemCount() - 1) {
                                rect.right = f.this.f74843b;
                            } else {
                                rect.right = a2;
                            }
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
            ((ab) this.f74842a.getAdapter()).a(cJRHomePageLayoutV2.getHomePageItemList());
        }
    }

    class g extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        int f74847a;

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView f74849c;

        /* renamed from: d  reason: collision with root package name */
        private RoboTextView f74850d;

        /* renamed from: e  reason: collision with root package name */
        private e f74851e;

        public g(View view, j jVar) {
            super(view);
            this.f74849c = (RecyclerView) view.findViewById(R.id.movies_horizontal_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(y.this.f74815b, 0, false);
            this.f74850d = (RoboTextView) view.findViewById(R.id.view_all);
            this.f74849c.setLayoutManager(linearLayoutManager);
            this.f74847a = n.a(10, (Context) y.this.f74815b);
            if (this.f74849c.getItemDecorationCount() == 0) {
                this.f74849c.addItemDecoration(new RecyclerView.h(y.this) {
                    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                        super.getItemOffsets(rect, view, recyclerView, sVar);
                        if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                            rect.left = n.a(20, (Context) y.this.f74815b);
                        }
                        rect.right = g.this.f74847a;
                    }
                });
            }
            this.f74851e = new e(y.this.f74815b, y.this.f74816c, jVar);
            this.f74849c.setAdapter(this.f74851e);
        }

        public final void a(List<CJRCinemas> list) {
            this.f74851e.f74607a = list;
            if (list.size() > 10) {
                this.f74850d.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        y.g.this.a(view);
                    }
                });
            } else {
                this.f74850d.setVisibility(8);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            y.this.w.g();
        }
    }

    class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74827a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f74828b;

        public c(View view) {
            super(view);
            try {
                this.f74827a = (TextView) view.findViewById(R.id.row_title_tv);
                this.f74828b = (RecyclerView) view.findViewById(R.id.event_categories_carousel_rv);
            } catch (Exception unused) {
            }
        }
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74823a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f74824b;

        public a(View view) {
            super(view);
            try {
                this.f74823a = (TextView) view.findViewById(R.id.row_title_tv);
                this.f74824b = (RecyclerView) view.findViewById(R.id.digital_events_carousel_rv);
            } catch (Exception unused) {
            }
        }
    }

    class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74830a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f74831b;

        public d(View view) {
            super(view);
            try {
                this.f74830a = (TextView) view.findViewById(R.id.row_title_tv);
                this.f74831b = (RecyclerView) view.findViewById(R.id.events_carousel_rv);
            } catch (Exception unused) {
            }
        }
    }

    public class h extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74854a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f74855b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f74856c;

        /* renamed from: d  reason: collision with root package name */
        int f74857d;

        public h(View view) {
            super(view);
            try {
                this.f74854a = (TextView) view.findViewById(R.id.upcoming_container_title);
                this.f74855b = (RecyclerView) view.findViewById(R.id.upcoming_container_list);
                this.f74855b.setLayoutManager(new LinearLayoutManager(y.this.f74815b, 0, false));
                this.f74856c = (RoboTextView) view.findViewById(R.id.view_all);
                this.f74857d = n.a(12, (Context) y.this.f74815b);
                if (this.f74855b.getItemDecorationCount() == 0) {
                    this.f74855b.addItemDecoration(new RecyclerView.h(y.this) {
                        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                            super.getItemOffsets(rect, view, recyclerView, sVar);
                            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                            int a2 = n.a(20.0f);
                            if (childAdapterPosition == 0) {
                                rect.right = h.this.f74857d;
                                rect.left = a2;
                            } else if (h.this.f74855b.getAdapter() == null || childAdapterPosition != h.this.f74855b.getAdapter().getItemCount() - 1) {
                                rect.right = h.this.f74857d;
                            } else {
                                rect.right = a2;
                            }
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    class k extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74863a;

        /* renamed from: b  reason: collision with root package name */
        TextView f74864b;

        public k(View view) {
            super(view);
            try {
                view.setPadding(y.this.s, y.this.s, y.this.s, y.this.s);
                this.f74863a = (TextView) view.findViewById(R.id.no_movie_title);
                this.f74864b = (TextView) view.findViewById(R.id.no_movie_desc);
                this.f74863a.setPadding(0, y.this.s * 3, 0, 0);
            } catch (Exception unused) {
            }
        }
    }

    class b extends RecyclerView.v {
        public b(View view) {
            super(view);
        }
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        Object obj;
        ArrayList arrayList = this.r;
        if (arrayList != null) {
            int i3 = this.x;
            if (i3 > 0) {
                obj = arrayList.get(i2 < i3 + -1 ? 0 : i2 - (i3 - 1));
            } else {
                obj = arrayList.get(i2);
            }
        } else {
            obj = null;
        }
        CJRMoviesHomePageItem cJRMoviesHomePageItem = (CJRMoviesHomePageItem) obj;
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 3) {
            ((e) vVar).a(i2);
        } else if (itemViewType == 2) {
            ((l) vVar).a();
        } else if (itemViewType == 4) {
            k kVar = (k) vVar;
            if (!TextUtils.isEmpty(y.this.f74816c)) {
                kVar.f74863a.setText(y.this.f74815b.getResources().getString(R.string.mo_movies_title));
                kVar.f74864b.setText(y.this.f74815b.getResources().getString(R.string.no_movies_desc));
                return;
            }
            kVar.f74863a.setText(y.this.f74815b.getResources().getString(R.string.empty_movie_location_title));
            kVar.f74864b.setText(y.this.f74815b.getResources().getString(R.string.empty_movie_location_desc));
        } else if (itemViewType == 7) {
            ((f) vVar).a(cJRMoviesHomePageItem.getBannerList());
        } else if (itemViewType == 8) {
            ((f) vVar).a(cJRMoviesHomePageItem.getBannerList());
        } else if (itemViewType == 1) {
            ((g) vVar).a(cJRMoviesHomePageItem.getCinemaListV1());
        } else if (itemViewType == 9) {
            this.f74818e = (h) vVar;
            h hVar = this.f74818e;
            CJRUpcomingMovies cJRUpcomingMovies = cJRMoviesHomePageItem.getmUpcomingMovies();
            String itemTitle = cJRMoviesHomePageItem.getItemTitle();
            if (!TextUtils.isEmpty(itemTitle)) {
                hVar.f74854a.setText(com.paytm.utility.b.E(itemTitle));
            }
            aj ajVar = new aj(cJRUpcomingMovies, 1, y.this.f74815b, y.this.v);
            hVar.f74855b.setHasFixedSize(true);
            if (cJRUpcomingMovies.getUpcomingMovieData().size() > 4) {
                hVar.f74856c.setVisibility(0);
                hVar.f74856c.setOnClickListener(new View.OnClickListener(cJRUpcomingMovies) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ CJRUpcomingMovies f74861a;

                    {
                        this.f74861a = r2;
                    }

                    public final void onClick(View view) {
                        if (!net.one97.paytm.o2o.movies.utils.y.INSTANCE.validateIsAlreadyClicked(y.this.f74815b, view)) {
                            Intent intent = new Intent(y.this.f74815b, AJRUpcomingMoviesGridPage.class);
                            intent.putExtra(y.this.f74815b.getString(R.string.upcoming_movies), this.f74861a);
                            if (y.this.f74814a != null) {
                                intent.putExtra("interest_data", new com.google.gson.f().a((com.google.gson.l) y.this.f74814a));
                            }
                            y.this.f74815b.startActivityForResult(intent, 7);
                            y.this.f74815b.overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
                        }
                    }
                });
            } else {
                hVar.f74856c.setVisibility(8);
            }
            hVar.f74855b.setAdapter(ajVar);
            if (this.f74814a != null) {
                ((aj) this.f74818e.f74855b.getAdapter()).a(this.f74814a);
            } else {
                ((aj) this.f74818e.f74855b.getAdapter()).a(net.one97.paytm.o2o.movies.utils.i.a().l);
            }
        } else if (itemViewType == 12) {
            d dVar = (d) vVar;
            Carousel eventCarousel = cJRMoviesHomePageItem.getEventCarousel();
            if (eventCarousel != null && eventCarousel.getEvents() != null && !eventCarousel.getEvents().isEmpty()) {
                if (eventCarousel.getTitle() != null) {
                    dVar.f74830a.setText(eventCarousel.getTitle());
                }
                dVar.f74831b.setLayoutManager(new LinearLayoutManager(y.this.f74815b, 0, false));
                dVar.f74831b.setAdapter(new az(eventCarousel.getEvents(), y.this));
            }
        } else if (itemViewType == 11) {
            a aVar = (a) vVar;
            if (cJRMoviesHomePageItem != null && !cJRMoviesHomePageItem.getDigitalEvents().isEmpty()) {
                if (cJRMoviesHomePageItem.getDigitalEventTitle() != null) {
                    aVar.f74823a.setText(cJRMoviesHomePageItem.getDigitalEventTitle());
                }
                GridLayoutManager gridLayoutManager = new GridLayoutManager(y.this.f74815b, 2);
                gridLayoutManager.setOrientation(0);
                aVar.f74824b.setLayoutManager(gridLayoutManager);
                aVar.f74824b.setAdapter(new ax(cJRMoviesHomePageItem.getDigitalEvents(), y.this));
            }
        } else if (itemViewType == 13) {
            c cVar = (c) vVar;
            if (cJRMoviesHomePageItem != null && !cJRMoviesHomePageItem.getEventCategories().isEmpty()) {
                if (cJRMoviesHomePageItem.getCategoryTitle() != null) {
                    cVar.f74827a.setText(cJRMoviesHomePageItem.getCategoryTitle());
                }
                GridLayoutManager gridLayoutManager2 = new GridLayoutManager(y.this.f74815b, 2);
                gridLayoutManager2.setOrientation(0);
                cVar.f74828b.setLayoutManager(gridLayoutManager2);
                cVar.f74828b.setAdapter(new ay(cJRMoviesHomePageItem.getEventCategories(), y.this));
            }
        }
    }

    public final void a(String str) {
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.openH5(this.f74815b, str);
    }

    static /* synthetic */ void a(y yVar, CJRMovieHomeListItem cJRMovieHomeListItem) {
        try {
            int indexOf = yVar.A != null ? yVar.A.indexOf(cJRMovieHomeListItem) : 0;
            String str = "";
            if (cJRMovieHomeListItem.getGrn() != null) {
                Iterator<String> it2 = cJRMovieHomeListItem.getGrn().iterator();
                String str2 = str;
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (str2.equalsIgnoreCase(str)) {
                        str2 = str2 + next;
                    } else {
                        str2 = str2 + ", " + next;
                    }
                }
                str = str2;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("name", cJRMovieHomeListItem.getLabel());
            hashMap.put("id", cJRMovieHomeListItem.getId());
            hashMap.put("price", 0);
            hashMap.put(CLPConstants.BRAND_PARAMS, yVar.f74816c);
            hashMap.put("category", str);
            hashMap.put("variant", cJRMovieHomeListItem.getScrnFmt());
            hashMap.put("list", "Movie listing");
            hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(indexOf + 1));
            net.one97.paytm.o2o.movies.b.a.INSTANCE.addProductImpression(hashMap, true);
        } catch (Exception unused) {
        }
    }
}
