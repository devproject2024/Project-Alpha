package net.one97.paytm.o2o.movies.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity;
import net.one97.paytm.o2o.movies.activity.AJRReviewDetailActivity;
import net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem;
import net.one97.paytm.o2o.movies.adapter.CriticReviewAndRating;
import net.one97.paytm.o2o.movies.adapter.DwhSource;
import net.one97.paytm.o2o.movies.adapter.l;
import net.one97.paytm.o2o.movies.fragment.i;

public final class e extends b implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f75289a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AJRMovieDetailsV2Activity f75290b;

    /* renamed from: c  reason: collision with root package name */
    private BroadcastReceiver f75291c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CriticReviewAndRating f75292d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.o2o.movies.d.b f75293e;

    /* renamed from: f  reason: collision with root package name */
    private i.d f75294f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f75295g;

    private View a(int i2) {
        if (this.f75295g == null) {
            this.f75295g = new HashMap();
        }
        View view = (View) this.f75295g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f75295g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f75293e = (net.one97.paytm.o2o.movies.d.b) context;
        this.f75294f = (i.d) context;
        this.f75290b = (AJRMovieDetailsV2Activity) context;
        this.f75291c = new FJRCriticReviewsFragment$onAttach$1(this);
        AJRMovieDetailsV2Activity aJRMovieDetailsV2Activity = this.f75290b;
        if (aJRMovieDetailsV2Activity == null) {
            k.a();
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) aJRMovieDetailsV2Activity);
        BroadcastReceiver broadcastReceiver = this.f75291c;
        if (broadcastReceiver != null) {
            a2.a(broadcastReceiver, new IntentFilter("callReviewsListApi"));
            return;
        }
        throw new u("null cannot be cast to non-null type android.content.BroadcastReceiver");
    }

    public final void onDetach() {
        super.onDetach();
        AJRMovieDetailsV2Activity aJRMovieDetailsV2Activity = this.f75290b;
        if (aJRMovieDetailsV2Activity == null) {
            k.a();
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) aJRMovieDetailsV2Activity);
        BroadcastReceiver broadcastReceiver = this.f75291c;
        if (broadcastReceiver != null) {
            a2.a(broadcastReceiver);
            return;
        }
        throw new u("null cannot be cast to non-null type android.content.BroadcastReceiver");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.movie_review_tab_layout, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
    }

    private final void a() {
        if (((ProgressBar) a(R.id.movie_review_progress_bar)) != null && isAdded()) {
            ProgressBar progressBar = (ProgressBar) a(R.id.movie_review_progress_bar);
            k.a((Object) progressBar, "movie_review_progress_bar");
            progressBar.setVisibility(8);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f75296a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f75297b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CriticReviewAndRating f75298c;

        b(ArrayList arrayList, e eVar, CriticReviewAndRating criticReviewAndRating) {
            this.f75296a = arrayList;
            this.f75297b = eVar;
            this.f75298c = criticReviewAndRating;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f75297b.getContext(), AJRReviewDetailActivity.class);
            this.f75298c.setSelectedSourceId(((CriticRatingReviewItem) this.f75296a.get(0)).f74227a);
            CriticReviewAndRating criticReviewAndRating = this.f75298c;
            if (criticReviewAndRating != null) {
                intent.putExtra("ratingAndReview", criticReviewAndRating);
                AJRMovieDetailsV2Activity c2 = this.f75297b.f75290b;
                intent.putExtra("movieName", c2 != null ? c2.q : null);
                Context context = this.f75297b.getContext();
                if (context != null) {
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.os.Parcelable");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f75299a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f75300b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CriticReviewAndRating f75301c;

        c(ArrayList arrayList, e eVar, CriticReviewAndRating criticReviewAndRating) {
            this.f75299a = arrayList;
            this.f75300b = eVar;
            this.f75301c = criticReviewAndRating;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f75300b.getContext(), AJRReviewDetailActivity.class);
            this.f75301c.setSelectedSourceId(((CriticRatingReviewItem) this.f75299a.get(1)).f74227a);
            CriticReviewAndRating criticReviewAndRating = this.f75301c;
            if (criticReviewAndRating != null) {
                intent.putExtra("ratingAndReview", criticReviewAndRating);
                AJRMovieDetailsV2Activity c2 = this.f75300b.f75290b;
                intent.putExtra("movieName", c2 != null ? c2.q : null);
                Context context = this.f75300b.getContext();
                if (context != null) {
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.os.Parcelable");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f75302a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f75303b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CriticReviewAndRating f75304c;

        d(ArrayList arrayList, e eVar, CriticReviewAndRating criticReviewAndRating) {
            this.f75302a = arrayList;
            this.f75303b = eVar;
            this.f75304c = criticReviewAndRating;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f75303b.getContext(), AJRReviewDetailActivity.class);
            this.f75304c.setSelectedSourceId(((CriticRatingReviewItem) this.f75302a.get(2)).f74227a);
            CriticReviewAndRating criticReviewAndRating = this.f75304c;
            if (criticReviewAndRating != null) {
                intent.putExtra("ratingAndReview", criticReviewAndRating);
                AJRMovieDetailsV2Activity c2 = this.f75303b.f75290b;
                intent.putExtra("movieName", c2 != null ? c2.q : null);
                Context context = this.f75303b.getContext();
                if (context != null) {
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.os.Parcelable");
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isAdded() && !isDetached()) {
            a();
            i.d dVar = this.f75294f;
            if (dVar != null) {
                dVar.b();
            }
            if (networkCustomError != null) {
                String message = networkCustomError.getMessage();
                if (message == null || !k.a((Object) message, (Object) "503")) {
                    b();
                    return;
                }
                net.one97.paytm.o2o.movies.d.b bVar = this.f75293e;
                if (bVar != null) {
                    bVar.c();
                }
            }
        }
    }

    private final void b() {
        if (isAdded() && !isDetached()) {
            ProgressBar progressBar = (ProgressBar) a(R.id.movie_review_progress_bar);
            k.a((Object) progressBar, "movie_review_progress_bar");
            progressBar.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.root_review_no_result_found);
            k.a((Object) relativeLayout, "root_review_no_result_found");
            relativeLayout.setVisibility(0);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        String str3;
        if (isAdded() && !isDetached()) {
            a();
            i.d dVar = this.f75294f;
            if (dVar != null) {
                dVar.b();
            }
            if (iJRPaytmDataModel instanceof CriticReviewAndRating) {
                this.f75292d = (CriticReviewAndRating) iJRPaytmDataModel;
                CriticReviewAndRating criticReviewAndRating = this.f75292d;
                if (criticReviewAndRating != null) {
                    if (criticReviewAndRating == null) {
                        k.a();
                    }
                    if (!(criticReviewAndRating.getRatings() == null || criticReviewAndRating.getReviews() == null)) {
                        for (CriticRatingReviewItem criticRatingReviewItem : criticReviewAndRating.getReviews()) {
                            if (criticReviewAndRating.getRatings().contains(criticRatingReviewItem)) {
                                CriticRatingReviewItem criticRatingReviewItem2 = criticReviewAndRating.getRatings().get(criticReviewAndRating.getRatings().indexOf(criticRatingReviewItem));
                                k.a((Object) criticRatingReviewItem2, "criticReviewAndRating.ra…ting.ratings.indexOf(it)]");
                                CriticRatingReviewItem criticRatingReviewItem3 = criticRatingReviewItem2;
                                criticRatingReviewItem.f74230d = criticRatingReviewItem3.f74230d;
                                criticRatingReviewItem.f74233g = criticRatingReviewItem3.f74233g;
                            }
                        }
                    }
                    ArrayList<CriticRatingReviewItem> ratings = criticReviewAndRating.getRatings();
                    String str4 = null;
                    if (ratings == null) {
                        LinearLayout linearLayout = (LinearLayout) a(R.id.llRatingLayout);
                        k.a((Object) linearLayout, "llRatingLayout");
                        linearLayout.setVisibility(8);
                    } else if (ratings.size() >= 3) {
                        LinearLayout linearLayout2 = (LinearLayout) a(R.id.llRatingLayout);
                        k.a((Object) linearLayout2, "llRatingLayout");
                        linearLayout2.setVisibility(0);
                        View a2 = a(R.id.view_divider);
                        k.a((Object) a2, "view_divider");
                        a2.setVisibility(0);
                        TextView textView = (TextView) a(R.id.txtValueRatingOne);
                        k.a((Object) textView, "txtValueRatingOne");
                        textView.setText(ratings.get(0).f74230d);
                        TextView textView2 = (TextView) a(R.id.txtSourceRatingOne);
                        k.a((Object) textView2, "txtSourceRatingOne");
                        DwhSource dwhSource = ratings.get(0).f74228b;
                        if (dwhSource != null) {
                            str = dwhSource.f74236a;
                        } else {
                            str = null;
                        }
                        textView2.setText(str);
                        TextView textView3 = (TextView) a(R.id.txtValueRatingTwo);
                        k.a((Object) textView3, "txtValueRatingTwo");
                        textView3.setText(ratings.get(1).f74230d);
                        TextView textView4 = (TextView) a(R.id.txtSourceRatingTwo);
                        k.a((Object) textView4, "txtSourceRatingTwo");
                        DwhSource dwhSource2 = ratings.get(1).f74228b;
                        if (dwhSource2 != null) {
                            str2 = dwhSource2.f74236a;
                        } else {
                            str2 = null;
                        }
                        textView4.setText(str2);
                        TextView textView5 = (TextView) a(R.id.txtValueRatingThree);
                        k.a((Object) textView5, "txtValueRatingThree");
                        textView5.setText(ratings.get(2).f74230d);
                        TextView textView6 = (TextView) a(R.id.txtSourceRatingThree);
                        k.a((Object) textView6, "txtSourceRatingThree");
                        DwhSource dwhSource3 = ratings.get(2).f74228b;
                        if (dwhSource3 != null) {
                            str3 = dwhSource3.f74236a;
                        } else {
                            str3 = null;
                        }
                        textView6.setText(str3);
                        if (criticReviewAndRating.getReviews() != null) {
                            if (criticReviewAndRating.getReviews().contains(ratings.get(0))) {
                                ((TextView) a(R.id.txtSourceRatingOne)).setTextColor(getResources().getColor(R.color.color_00b9f5_re));
                                ((LinearLayout) a(R.id.ratingOne)).setOnClickListener(new b(ratings, this, criticReviewAndRating));
                            }
                            if (criticReviewAndRating.getReviews().contains(ratings.get(1))) {
                                ((TextView) a(R.id.txtSourceRatingTwo)).setTextColor(getResources().getColor(R.color.color_00b9f5_re));
                                ((LinearLayout) a(R.id.ratingtwo)).setOnClickListener(new c(ratings, this, criticReviewAndRating));
                            }
                            if (criticReviewAndRating.getReviews().contains(ratings.get(2))) {
                                ((TextView) a(R.id.txtSourceRatingThree)).setTextColor(getResources().getColor(R.color.color_00b9f5_re));
                                ((LinearLayout) a(R.id.ratingthree)).setOnClickListener(new d(ratings, this, criticReviewAndRating));
                            }
                        }
                    } else {
                        View a3 = a(R.id.view_divider);
                        k.a((Object) a3, "view_divider");
                        a3.setVisibility(8);
                        LinearLayout linearLayout3 = (LinearLayout) a(R.id.llRatingLayout);
                        k.a((Object) linearLayout3, "llRatingLayout");
                        linearLayout3.setVisibility(8);
                    }
                    ArrayList<CriticRatingReviewItem> reviews = criticReviewAndRating.getReviews();
                    if (reviews == null) {
                        e eVar = this;
                        LinearLayout linearLayout4 = (LinearLayout) eVar.a(R.id.llReviewLayout);
                        k.a((Object) linearLayout4, "llReviewLayout");
                        linearLayout4.setVisibility(8);
                        eVar.b();
                    } else if (reviews.size() > 0) {
                        LinearLayout linearLayout5 = (LinearLayout) a(R.id.llReviewLayout);
                        k.a((Object) linearLayout5, "llReviewLayout");
                        linearLayout5.setVisibility(0);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f75290b);
                        linearLayoutManager.setOrientation(1);
                        RecyclerView recyclerView = (RecyclerView) a(R.id.criticRecylerView);
                        k.a((Object) recyclerView, "criticRecylerView");
                        recyclerView.setLayoutManager(linearLayoutManager);
                        RecyclerView recyclerView2 = (RecyclerView) a(R.id.criticRecylerView);
                        k.a((Object) recyclerView2, "criticRecylerView");
                        AJRMovieDetailsV2Activity aJRMovieDetailsV2Activity = this.f75290b;
                        Context context = aJRMovieDetailsV2Activity;
                        if (aJRMovieDetailsV2Activity != null) {
                            str4 = aJRMovieDetailsV2Activity.q;
                        }
                        recyclerView2.setAdapter(new l(context, criticReviewAndRating, reviews, str4));
                    } else {
                        LinearLayout linearLayout6 = (LinearLayout) a(R.id.llReviewLayout);
                        k.a((Object) linearLayout6, "llReviewLayout");
                        linearLayout6.setVisibility(8);
                        b();
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) a(R.id.rlContentLayout);
                    k.a((Object) relativeLayout, "rlContentLayout");
                    relativeLayout.setVisibility(0);
                    return;
                }
                return;
            }
            b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00e2, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.o2o.movies.fragment.e r12) {
        /*
            android.content.Context r0 = r12.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            r1 = 0
            if (r0 == 0) goto L_0x00db
            net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r0 = r12.f75290b
            if (r0 == 0) goto L_0x00da
            java.lang.Integer r0 = r0.f74011f
            if (r0 == 0) goto L_0x00da
            int r0 = r0.intValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            if (r0 != 0) goto L_0x001f
            goto L_0x00da
        L_0x001f:
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_review_progress_bar
            android.view.View r2 = r12.a((int) r2)
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
            java.lang.String r3 = "movie_review_progress_bar"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 0
            r2.setVisibility(r3)
            int r2 = net.one97.paytm.o2o.movies.R.id.rlContentLayout
            android.view.View r2 = r12.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            java.lang.String r4 = "rlContentLayout"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            r4 = 8
            r2.setVisibility(r4)
            int r2 = net.one97.paytm.o2o.movies.R.id.root_review_no_result_found
            android.view.View r2 = r12.a((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            java.lang.String r5 = "root_review_no_result_found"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r2.setVisibility(r4)
            java.util.HashMap r2 = com.paytm.utility.b.n()
            java.lang.String r4 = "ClientId"
            java.lang.String r5 = "paytm"
            r2.put(r4, r5)
            net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r4 = r12.f75290b
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r4 = com.paytm.utility.a.q(r4)
            java.lang.String r5 = "sso_token"
            r2.put(r5, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r5 = "content_id"
            r4.put(r5, r0)
            net.one97.paytm.o2o.movies.common.b.c r0 = net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r5 = "MoviesGTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            java.lang.String r0 = "movieCriticReviewAndRatingUrl"
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.c.a(r0, r1)
            boolean r5 = android.webkit.URLUtil.isValidUrl(r0)
            if (r5 == 0) goto L_0x0103
            android.content.Context r5 = r12.getContext()
            java.lang.String r0 = com.paytm.utility.b.d((android.content.Context) r5, (java.lang.String) r0)
            net.one97.paytm.o2o.movies.utils.c r5 = new net.one97.paytm.o2o.movies.utils.c
            r5.<init>()
            androidx.fragment.app.FragmentActivity r6 = r12.getActivity()
            android.content.Context r6 = (android.content.Context) r6
            r5.f42877a = r6
            com.paytm.network.a$c r6 = com.paytm.network.a.c.MOVIES
            r5.f42878b = r6
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.GET
            r5.f42879c = r6
            r5.f42880d = r0
            r5.f42881e = r1
            java.util.Map r2 = (java.util.Map) r2
            r5.f42882f = r2
            java.util.Map r4 = (java.util.Map) r4
            r5.f42883g = r4
            r5.f42884h = r1
            net.one97.paytm.o2o.movies.adapter.CriticReviewAndRating r0 = new net.one97.paytm.o2o.movies.adapter.CriticReviewAndRating
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 7
            r11 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0
            r5.f42885i = r0
            com.paytm.network.listener.b r12 = (com.paytm.network.listener.b) r12
            r5.j = r12
            com.paytm.network.a$b r12 = com.paytm.network.a.b.USER_FACING
            r5.n = r12
            java.lang.String r12 = "movies"
            r5.o = r12
            r5.t = r1
            com.paytm.network.a r12 = r5.l()
            r12.f42859c = r3
            r12.a()
        L_0x00da:
            return
        L_0x00db:
            net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r0 = r12.f75290b
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            if (r0 == 0) goto L_0x00ef
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x00ef
            int r3 = net.one97.paytm.common.assets.R.string.no_connection
            java.lang.String r0 = r0.getString(r3)
            goto L_0x00f0
        L_0x00ef:
            r0 = r1
        L_0x00f0:
            net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r12 = r12.f75290b
            if (r12 == 0) goto L_0x0100
            android.content.res.Resources r12 = r12.getResources()
            if (r12 == 0) goto L_0x0100
            int r1 = net.one97.paytm.common.assets.R.string.no_internet
            java.lang.String r1 = r12.getString(r1)
        L_0x0100:
            com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r0, (java.lang.String) r1)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.e.b(net.one97.paytm.o2o.movies.fragment.e):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f75295g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
