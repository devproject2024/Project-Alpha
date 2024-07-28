package net.one97.paytm.o2o.movies.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel;
import net.one97.paytm.o2o.movies.utils.v;
import net.one97.paytm.o2o.movies.viewmodel.a;

public final class AJRUpcomingMoviesActivity extends AppBaseActivity implements View.OnClickListener, q {

    /* renamed from: b  reason: collision with root package name */
    public static final a f74111b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    String f74112a;

    /* renamed from: c  reason: collision with root package name */
    private int f74113c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f74114d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f74115e;

    /* renamed from: f  reason: collision with root package name */
    private int f74116f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f74117g = 101;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.o2o.movies.viewmodel.a f74118h;

    /* renamed from: i  reason: collision with root package name */
    private String f74119i = "";
    /* access modifiers changed from: private */
    public String j = "";
    private String k = "";
    private HashMap l;

    public static final Intent a(Context context, String str, String str2) {
        return a.a(context, str, str2);
    }

    public final View b(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class j<T> implements z<a.k<? extends List<? extends a.g>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74131a;

        j(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74131a = aJRUpcomingMoviesActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            a.l lVar;
            a.k kVar = (a.k) obj;
            a.d dVar = null;
            if (kVar != null) {
                lVar = kVar.f76036a;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                int i2 = a.f74221c[lVar.ordinal()];
                if (i2 == 1) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.f74131a.b(R.id.movieContentRootLayout);
                    kotlin.g.b.k.a((Object) relativeLayout, "movieContentRootLayout");
                    relativeLayout.setVisibility(0);
                    if (!this.f74131a.getIntent().hasExtra("param_is_from") || !kotlin.g.b.k.a((Object) "show_list", (Object) this.f74131a.getIntent().getStringExtra("param_is_from"))) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) this.f74131a.b(R.id.movie_detail_tab_book);
                        kotlin.g.b.k.a((Object) relativeLayout2, "movie_detail_tab_book");
                        relativeLayout2.setVisibility(0);
                    } else {
                        RelativeLayout relativeLayout3 = (RelativeLayout) this.f74131a.b(R.id.movie_detail_tab_book);
                        kotlin.g.b.k.a((Object) relativeLayout3, "movie_detail_tab_book");
                        relativeLayout3.setVisibility(8);
                    }
                    ((NestedScrollView) this.f74131a.b(R.id.movie_detail_scroll_view)).a(0, false);
                    List<a.g> list = (List) kVar.f76037b;
                    if (list != null) {
                        for (a.g gVar : list) {
                            if (a.f74219a[gVar.f76030h.ordinal()] == 1) {
                                if (gVar != null) {
                                    a.C1499a aVar = (a.C1499a) gVar;
                                    AJRUpcomingMoviesActivity.a(this.f74131a, aVar);
                                    String str = aVar.f76015f;
                                    if (str != null && (!p.a(str))) {
                                        AJRUpcomingMoviesActivity.a(this.f74131a, aVar.f76015f);
                                        AJRUpcomingMoviesActivity.b(this.f74131a, aVar.f76016g);
                                        AJRUpcomingMoviesActivity.b(this.f74131a);
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.viewmodel.AJRUpcomingViewModel.Banner");
                                }
                            }
                        }
                    }
                } else if (i2 == 2) {
                    this.f74131a.a(false);
                    a.c cVar = kVar.f76038c;
                    if (cVar != null) {
                        dVar = cVar.f76020a;
                    }
                    if (dVar != null && a.f74220b[dVar.ordinal()] == 1) {
                        AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity = this.f74131a;
                        String str2 = kVar.f76038c.f76021b;
                        String str3 = kVar.f76038c.f76022c;
                        kotlin.g.b.k.c(str2, "title");
                        kotlin.g.b.k.c(str3, "message");
                        if (!aJRUpcomingMoviesActivity.isFinishing()) {
                            new AlertDialog.Builder(aJRUpcomingMoviesActivity).setTitle(str2).setMessage(str3).setCancelable(false).setPositiveButton(aJRUpcomingMoviesActivity.getResources().getString(R.string.ok), new n(aJRUpcomingMoviesActivity)).show();
                            return;
                        }
                        return;
                    }
                    AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity2 = this.f74131a;
                    if (!aJRUpcomingMoviesActivity2.isFinishing()) {
                        new AlertDialog.Builder(aJRUpcomingMoviesActivity2).setTitle(R.string.movie_maintenance_error_title).setMessage(R.string.movie_maintenance_error_description).setCancelable(false).setPositiveButton(aJRUpcomingMoviesActivity2.getResources().getString(R.string.ok), new o(aJRUpcomingMoviesActivity2)).show();
                    }
                } else if (i2 == 3) {
                    this.f74131a.a(true);
                }
            }
        }
    }

    static final class k<T> implements z<a.k<? extends a.j>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74132a;

        k(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74132a = aJRUpcomingMoviesActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            a.l lVar;
            a.f fVar;
            a.f fVar2;
            a.k kVar = (a.k) obj;
            if (kVar != null) {
                lVar = kVar.f76036a;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                int i2 = a.f74222d[lVar.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    AJRUpcomingMoviesActivity.a(this.f74132a, (a.j) kVar.f76037b, kVar.f76038c);
                } else if (i2 == 2) {
                    Toast.makeText(this.f74132a, R.string.error_something_went_wrong, 0).show();
                    LinearLayout linearLayout = (LinearLayout) this.f74132a.b(R.id.llInterestedCTALayout);
                    kotlin.g.b.k.a((Object) linearLayout, "llInterestedCTALayout");
                    a.j jVar = (a.j) kVar.f76037b;
                    if (!(jVar == null || (fVar = jVar.f76034a) == null)) {
                        z = fVar.f76029d;
                    }
                    linearLayout.setEnabled(z);
                } else if (i2 == 3) {
                    LinearLayout linearLayout2 = (LinearLayout) this.f74132a.b(R.id.llInterestedCTALayout);
                    kotlin.g.b.k.a((Object) linearLayout2, "llInterestedCTALayout");
                    a.j jVar2 = (a.j) kVar.f76037b;
                    if (!(jVar2 == null || (fVar2 = jVar2.f76034a) == null)) {
                        z = fVar2.f76029d;
                    }
                    linearLayout2.setEnabled(z);
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.o2o.movies.viewmodel.a a(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
        net.one97.paytm.o2o.movies.viewmodel.a aVar = aJRUpcomingMoviesActivity.f74118h;
        if (aVar == null) {
            kotlin.g.b.k.a("ajrUpcomingViewModel");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Intent a(Context context, String str) {
            kotlin.g.b.k.c(context, "context");
            CharSequence charSequence = str;
            if (charSequence == null || p.a(charSequence)) {
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.crashlyticsLogs("contentId data can't be null".toString());
                return null;
            }
            Intent intent = new Intent(context, AJRUpcomingMoviesActivity.class);
            intent.putExtra("param_content_id", str);
            return intent;
        }

        public static Intent a(Context context, String str, String str2) {
            kotlin.g.b.k.c(context, "context");
            CharSequence charSequence = str;
            if (charSequence == null || p.a(charSequence)) {
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.crashlyticsLogs("movieId data can't be null".toString());
                return null;
            }
            Intent intent = new Intent(context, AJRUpcomingMoviesActivity.class);
            intent.putExtra("param_movie_id", str);
            intent.putExtra("param_is_from", str2);
            return intent;
        }

        public static Intent b(Context context, String str) {
            kotlin.g.b.k.c(context, "context");
            CharSequence charSequence = str;
            if (charSequence == null || p.a(charSequence)) {
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.crashlyticsLogs("movieId data can't be null".toString());
                return null;
            }
            Intent intent = new Intent(context, AJRUpcomingMoviesActivity.class);
            intent.putExtra("param_movie_id", str);
            return intent;
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74120a;

        b(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74120a = aJRUpcomingMoviesActivity;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            AJRUpcomingMoviesActivity.a(this.f74120a).a(networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            AJRUpcomingMoviesActivity.a(this.f74120a).a(iJRPaytmDataModel);
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74121a;

        c(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74121a = aJRUpcomingMoviesActivity;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            AJRUpcomingMoviesActivity.a(this.f74121a).a(networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRMoviesContentCastCrewModel) {
                this.f74121a.f74112a = ((CJRMoviesContentCastCrewModel) iJRPaytmDataModel).releaseDate;
            }
            AJRUpcomingMoviesActivity.a(this.f74121a).a(iJRPaytmDataModel);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0268, code lost:
        if (r2 == null) goto L_0x0271;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r17) {
        /*
            r16 = this;
            r0 = r16
            super.onCreate(r17)
            int r1 = net.one97.paytm.o2o.movies.R.layout.movie_content_page
            r0.setContentView((int) r1)
            r1 = 0
            r0.a((boolean) r1)
            net.one97.paytm.o2o.movies.common.c.b r2 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r2 = r2.f75033b
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = "movies"
            java.lang.String r5 = " /movies/upcoming/content"
            r2.sendOpenScreenWithDeviceInfo(r5, r4, r3)
            r2 = r0
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2
            androidx.lifecycle.al r2 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r2)
            java.lang.Class<net.one97.paytm.o2o.movies.viewmodel.a> r5 = net.one97.paytm.o2o.movies.viewmodel.a.class
            androidx.lifecycle.ai r2 = r2.a(r5)
            java.lang.String r5 = "ViewModelProviders.of(th…ingViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            net.one97.paytm.o2o.movies.viewmodel.a r2 = (net.one97.paytm.o2o.movies.viewmodel.a) r2
            r0.f74118h = r2
            net.one97.paytm.o2o.movies.viewmodel.a r2 = r0.f74118h
            java.lang.String r5 = "ajrUpcomingViewModel"
            if (r2 != 0) goto L_0x003b
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x003b:
            androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<java.util.List<net.one97.paytm.o2o.movies.viewmodel.a$g>>> r2 = r2.f76005a
            r6 = r0
            androidx.lifecycle.q r6 = (androidx.lifecycle.q) r6
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$j r7 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$j
            r7.<init>(r0)
            androidx.lifecycle.z r7 = (androidx.lifecycle.z) r7
            r2.observe(r6, r7)
            net.one97.paytm.o2o.movies.viewmodel.a r2 = r0.f74118h
            if (r2 != 0) goto L_0x0051
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0051:
            androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r2 = r2.f76006b
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$k r7 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$k
            r7.<init>(r0)
            androidx.lifecycle.z r7 = (androidx.lifecycle.z) r7
            r2.observe(r6, r7)
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_detail_tab_book
            android.view.View r2 = r0.b((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$g r6 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$g
            r6.<init>(r0)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r2.setOnClickListener(r6)
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_details_toolbar
            android.view.View r2 = r0.b((int) r2)
            androidx.appcompat.widget.Toolbar r2 = (androidx.appcompat.widget.Toolbar) r2
            r0.setSupportActionBar(r2)
            androidx.appcompat.app.ActionBar r2 = r16.getSupportActionBar()
            r6 = 1
            if (r2 == 0) goto L_0x00a5
            java.lang.String r7 = ""
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.a((java.lang.CharSequence) r7)
            r2.b((boolean) r6)
            int r7 = net.one97.paytm.o2o.movies.R.drawable.movie_back_arrow_white
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r3, (int) r7)
            if (r7 != 0) goto L_0x0096
            kotlin.g.b.k.a()
        L_0x0096:
            r0.f74114d = r7
            android.graphics.drawable.Drawable r7 = r0.f74114d
            if (r7 != 0) goto L_0x00a2
            java.lang.String r8 = "upArrow"
            kotlin.g.b.k.a((java.lang.String) r8)
        L_0x00a2:
            r2.b((android.graphics.drawable.Drawable) r7)
        L_0x00a5:
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_details_appbar
            android.view.View r2 = r0.b((int) r2)
            com.google.android.material.appbar.AppBarLayout r2 = (com.google.android.material.appbar.AppBarLayout) r2
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$h r7 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$h
            r7.<init>(r0)
            com.google.android.material.appbar.AppBarLayout$b r7 = (com.google.android.material.appbar.AppBarLayout.b) r7
            r2.a((com.google.android.material.appbar.AppBarLayout.b) r7)
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_details_collapse_toolbar
            android.view.View r2 = r0.b((int) r2)
            com.google.android.material.appbar.CollapsingToolbarLayout r2 = (com.google.android.material.appbar.CollapsingToolbarLayout) r2
            r2.setScrimsShown(r1, r6)
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_detail_scroll_view
            android.view.View r2 = r0.b((int) r2)
            androidx.core.widget.NestedScrollView r2 = (androidx.core.widget.NestedScrollView) r2
            java.lang.String r7 = "movie_detail_scroll_view"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            r2.setSmoothScrollingEnabled(r6)
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 19
            if (r2 < r7) goto L_0x0114
            android.view.Window r2 = r16.getWindow()
            r7 = 67108864(0x4000000, float:1.5046328E-36)
            r2.addFlags(r7)
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_details_toolbar
            android.view.View r2 = r0.b((int) r2)
            androidx.appcompat.widget.Toolbar r2 = (androidx.appcompat.widget.Toolbar) r2
            java.lang.String r7 = "movie_details_toolbar"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            if (r2 == 0) goto L_0x010c
            com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams r2 = (com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams) r2
            r8 = 15
            r2.setMargins(r1, r8, r1, r1)
            int r8 = net.one97.paytm.o2o.movies.R.id.movie_details_toolbar
            android.view.View r8 = r0.b((int) r8)
            androidx.appcompat.widget.Toolbar r8 = (androidx.appcompat.widget.Toolbar) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r8.setLayoutParams(r2)
            goto L_0x0114
        L_0x010c:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams"
            r1.<init>(r2)
            throw r1
        L_0x0114:
            androidx.fragment.app.j r2 = r16.getSupportFragmentManager()
            if (r2 == 0) goto L_0x0130
            androidx.fragment.app.q r2 = r2.a()
            int r7 = net.one97.paytm.o2o.movies.R.id.content_container
            net.one97.paytm.o2o.movies.fragment.f$a r8 = net.one97.paytm.o2o.movies.fragment.f.f75305a
            net.one97.paytm.o2o.movies.fragment.f r8 = new net.one97.paytm.o2o.movies.fragment.f
            r8.<init>()
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            androidx.fragment.app.q r2 = r2.a((int) r7, (androidx.fragment.app.Fragment) r8)
            r2.b()
        L_0x0130:
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r3)
            if (r2 == 0) goto L_0x032a
            android.content.Intent r2 = r16.getIntent()
            java.lang.String r7 = "param_content_id"
            boolean r8 = r2.hasExtra(r7)
            java.lang.String r9 = "URLMoviesFetchDetails"
            java.lang.String r10 = "AJRUpcomingViewModel"
            java.lang.String r11 = "paytm"
            java.lang.String r12 = "clientId"
            java.lang.String r13 = "MoviesGTMLoader.getInstance()"
            java.lang.String r14 = "param_movie_id"
            r15 = 0
            if (r8 == 0) goto L_0x01b6
            java.lang.String r2 = r2.getStringExtra(r7)
            net.one97.paytm.o2o.movies.common.b.c r8 = net.one97.paytm.o2o.movies.common.b.c.a()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r13)
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.c.a(r9, r15)
            java.lang.String r8 = com.paytm.utility.b.d((android.content.Context) r3, (java.lang.String) r8)
            java.lang.String r9 = "content_id"
            java.lang.String r2 = net.one97.paytm.o2o.movies.utils.n.a((java.lang.String) r9, (java.lang.String) r2, (java.lang.String) r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r8.put(r12, r11)
            net.one97.paytm.o2o.movies.utils.c r9 = new net.one97.paytm.o2o.movies.utils.c
            r9.<init>()
            android.content.Context r6 = r16.getApplicationContext()
            r9.f42877a = r6
            com.paytm.network.a$c r6 = com.paytm.network.a.c.MOVIES
            r9.f42878b = r6
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.GET
            r9.f42879c = r6
            r9.f42880d = r2
            r9.f42881e = r15
            java.util.Map r8 = (java.util.Map) r8
            r9.f42882f = r8
            r9.f42883g = r15
            r9.f42884h = r15
            net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel r2 = new net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel
            r2.<init>()
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            r9.f42885i = r2
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$b r2 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$b
            r2.<init>(r0)
            com.paytm.network.listener.b r2 = (com.paytm.network.listener.b) r2
            r9.j = r2
            com.paytm.network.a$b r2 = com.paytm.network.a.b.USER_FACING
            r9.n = r2
            r9.o = r4
            org.json.JSONObject r2 = net.one97.paytm.o2o.movies.utils.n.h(r10)
            r9.t = r2
            com.paytm.network.a r2 = r9.l()
            r2.f42859c = r1
            r1 = r2
            goto L_0x0251
        L_0x01b6:
            boolean r6 = r2.hasExtra(r14)
            if (r6 == 0) goto L_0x0250
            java.lang.String r2 = r2.getStringExtra(r14)
            java.lang.String r6 = "this.getStringExtra(PARAM_MOVIE_ID)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r0.j = r2
            net.one97.paytm.o2o.movies.common.b.c r2 = net.one97.paytm.o2o.movies.common.b.c.a()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.c.a(r9, r15)
            java.lang.String r2 = com.paytm.utility.b.d((android.content.Context) r3, (java.lang.String) r2)
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            boolean r8 = com.paytm.utility.b.r((android.content.Context) r3)
            if (r8 == 0) goto L_0x01eb
            java.lang.String r8 = com.paytm.utility.b.n((android.content.Context) r3)
            java.lang.String r9 = "customer_id"
            r6.put(r9, r8)
        L_0x01eb:
            java.lang.String r8 = r0.j
            java.lang.String r9 = "movie_id"
            org.json.JSONObject r6 = r6.put(r9, r8)
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "JSONObject().let {\n     …             }.toString()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            r8.put(r12, r11)
            java.lang.String r9 = "Content-Type"
            java.lang.String r1 = "application/json"
            r8.put(r9, r1)
            net.one97.paytm.o2o.movies.utils.c r1 = new net.one97.paytm.o2o.movies.utils.c
            r1.<init>()
            android.content.Context r9 = r16.getApplicationContext()
            r1.f42877a = r9
            com.paytm.network.a$c r9 = com.paytm.network.a.c.MOVIES
            r1.f42878b = r9
            com.paytm.network.a$a r9 = com.paytm.network.a.C0715a.POST
            r1.f42879c = r9
            r1.f42880d = r2
            r1.f42881e = r15
            java.util.Map r8 = (java.util.Map) r8
            r1.f42882f = r8
            r1.f42883g = r15
            r1.f42884h = r6
            net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel r2 = new net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel
            r2.<init>()
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            r1.f42885i = r2
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$c r2 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$c
            r2.<init>(r0)
            com.paytm.network.listener.b r2 = (com.paytm.network.listener.b) r2
            r1.j = r2
            com.paytm.network.a$b r2 = com.paytm.network.a.b.USER_FACING
            r1.n = r2
            r1.o = r4
            org.json.JSONObject r2 = net.one97.paytm.o2o.movies.utils.n.h(r10)
            r1.t = r2
            com.paytm.network.a r1 = r1.l()
            r2 = 0
            r1.f42859c = r2
            goto L_0x0251
        L_0x0250:
            r1 = r15
        L_0x0251:
            android.content.Intent r2 = r16.getIntent()
            java.lang.String r2 = r2.getStringExtra(r7)
            java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r7 = "(this as java.lang.String).toUpperCase()"
            if (r2 == 0) goto L_0x0271
            if (r2 == 0) goto L_0x026b
            java.lang.String r2 = r2.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            if (r2 != 0) goto L_0x028c
            goto L_0x0271
        L_0x026b:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r6)
            throw r1
        L_0x0271:
            android.content.Intent r2 = r16.getIntent()
            java.lang.String r2 = r2.getStringExtra(r14)
            if (r2 == 0) goto L_0x028b
            if (r2 == 0) goto L_0x0285
            java.lang.String r2 = r2.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            goto L_0x028c
        L_0x0285:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r6)
            throw r1
        L_0x028b:
            r2 = r15
        L_0x028c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            net.one97.paytm.o2o.movies.common.b.c r7 = net.one97.paytm.o2o.movies.common.b.c.a()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r13)
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.c.f()
            java.lang.String r7 = com.paytm.utility.b.d((android.content.Context) r3, (java.lang.String) r7)
            r6.<init>(r7)
            java.lang.String r7 = "&movieIds="
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = "&metricType=interested,sentiment"
            r6.append(r7)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r7.put(r12, r11)
            net.one97.paytm.o2o.movies.utils.c r8 = new net.one97.paytm.o2o.movies.utils.c
            r8.<init>()
            android.content.Context r9 = r16.getApplicationContext()
            r8.f42877a = r9
            com.paytm.network.a$c r9 = com.paytm.network.a.c.MOVIES
            r8.f42878b = r9
            com.paytm.network.a$a r9 = com.paytm.network.a.C0715a.GET
            r8.f42879c = r9
            java.lang.String r6 = r6.toString()
            r8.f42880d = r6
            r8.f42881e = r15
            java.util.Map r7 = (java.util.Map) r7
            r8.f42882f = r7
            r8.f42883g = r15
            r8.f42884h = r15
            net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse r6 = new net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse
            r7 = 3
            r6.<init>(r15, r15, r7, r15)
            com.paytm.network.model.IJRPaytmDataModel r6 = (com.paytm.network.model.IJRPaytmDataModel) r6
            r8.f42885i = r6
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$d r6 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$d
            r6.<init>(r0, r2)
            com.paytm.network.listener.b r6 = (com.paytm.network.listener.b) r6
            r8.j = r6
            com.paytm.network.a$b r2 = com.paytm.network.a.b.USER_FACING
            r8.n = r2
            r8.o = r4
            org.json.JSONObject r2 = net.one97.paytm.o2o.movies.utils.n.h(r10)
            r8.t = r2
            com.paytm.network.a r2 = r8.l()
            r4 = 1
            r2.f42860d = r4
            r4 = 0
            r2.f42859c = r4
            java.lang.String r6 = "networkCall"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            if (r1 != 0) goto L_0x0315
            int r1 = net.one97.paytm.o2o.movies.R.string.error_something_went_wrong
            android.widget.Toast r1 = android.widget.Toast.makeText(r3, r1, r4)
            r1.show()
            r16.finish()
            goto L_0x0337
        L_0x0315:
            net.one97.paytm.o2o.movies.viewmodel.a r3 = r0.f74118h
            if (r3 != 0) goto L_0x031c
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x031c:
            net.one97.paytm.o2o.movies.viewmodel.a.a((com.paytm.network.a) r1)
            net.one97.paytm.o2o.movies.viewmodel.a r1 = r0.f74118h
            if (r1 != 0) goto L_0x0326
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0326:
            net.one97.paytm.o2o.movies.viewmodel.a.a((com.paytm.network.a) r2)
            goto L_0x0337
        L_0x032a:
            int r1 = net.one97.paytm.common.assets.R.string.no_internet
            r2 = 0
            android.widget.Toast r1 = android.widget.Toast.makeText(r3, r1, r2)
            r1.show()
            r16.finish()
        L_0x0337:
            r1 = 1
            r0.a((boolean) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.onCreate(android.os.Bundle):void");
    }

    public static final class d implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74122a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f74123b;

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }

        d(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity, String str) {
            this.f74122a = aJRUpcomingMoviesActivity;
            this.f74123b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
            r5 = r5.getMovieMappings();
         */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r5) {
            /*
                r4 = this;
                net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity r0 = r4.f74122a
                net.one97.paytm.o2o.movies.viewmodel.a r0 = net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.a((net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity) r0)
                java.lang.String r1 = r4.f74123b
                boolean r2 = r5 instanceof net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse
                if (r2 == 0) goto L_0x0073
                net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse r5 = (net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse) r5
                java.util.HashMap r2 = r5.getData()
                r3 = 0
                if (r2 == 0) goto L_0x003a
                java.util.Map r2 = (java.util.Map) r2
                net.one97.paytm.o2o.movies.entity.CJRMetricInfoMeta r5 = r5.getMetaData()
                if (r5 == 0) goto L_0x002c
                java.util.HashMap r5 = r5.getMovieMappings()
                if (r5 == 0) goto L_0x002c
                java.util.Map r5 = (java.util.Map) r5
                java.lang.Object r5 = r5.get(r1)
                java.lang.String r5 = (java.lang.String) r5
                goto L_0x002d
            L_0x002c:
                r5 = r3
            L_0x002d:
                java.lang.Object r5 = r2.get(r5)
                net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem r5 = (net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem) r5
                if (r5 == 0) goto L_0x003a
                net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem r5 = r5.getMetricData()
                goto L_0x003b
            L_0x003a:
                r5 = r3
            L_0x003b:
                net.one97.paytm.o2o.movies.viewmodel.a$j r1 = new net.one97.paytm.o2o.movies.viewmodel.a$j
                r1.<init>()
                if (r5 == 0) goto L_0x0048
                net.one97.paytm.o2o.movies.entity.SentimentInterestedItem r2 = r5.getInterested()
                if (r2 != 0) goto L_0x0049
            L_0x0048:
                r2 = r3
            L_0x0049:
                net.one97.paytm.o2o.movies.viewmodel.a$f r2 = net.one97.paytm.o2o.movies.viewmodel.a.a((net.one97.paytm.o2o.movies.entity.SentimentInterestedItem) r2)
                r1.f76034a = r2
                if (r5 == 0) goto L_0x0056
                net.one97.paytm.o2o.movies.entity.SentimentInterestedItem r5 = r5.getSentiment()
                goto L_0x0057
            L_0x0056:
                r5 = r3
            L_0x0057:
                r1.f76035b = r5
                boolean r5 = r0.f76007c
                if (r5 == 0) goto L_0x006a
                androidx.lifecycle.y<net.one97.paytm.o2o.movies.viewmodel.a$k<net.one97.paytm.o2o.movies.viewmodel.a$j>> r5 = r0.f76006b
                net.one97.paytm.o2o.movies.viewmodel.a$k r0 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r2 = net.one97.paytm.o2o.movies.viewmodel.a.l.SUCCESS
                r0.<init>(r2, r1, r3)
                r5.postValue(r0)
                return
            L_0x006a:
                net.one97.paytm.o2o.movies.viewmodel.a$k r5 = new net.one97.paytm.o2o.movies.viewmodel.a$k
                net.one97.paytm.o2o.movies.viewmodel.a$l r2 = net.one97.paytm.o2o.movies.viewmodel.a.l.SUCCESS
                r5.<init>(r2, r1, r3)
                r0.f76008d = r5
            L_0x0073:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.d.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74128a;

        g(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74128a = aJRUpcomingMoviesActivity;
        }

        public final void onClick(View view) {
            this.f74128a.setResult(-1);
            this.f74128a.finish();
        }
    }

    static final class h implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74129a;

        h(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74129a = aJRUpcomingMoviesActivity;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            kotlin.g.b.k.c(appBarLayout, "appBarLayout");
            this.f74129a.f74115e = i2;
            AJRUpcomingMoviesActivity.a(this.f74129a, appBarLayout);
        }
    }

    public final void a(boolean z) {
        ((ProgressBar) b(R.id.movie_content_page_progress_bar)).setVisibility(z ? 0 : 8);
    }

    public final void a(int i2) {
        startActivityForResult(new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), i2);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == this.f74117g) {
            if (i3 == -1) {
                if (this.j.length() > 0) {
                    net.one97.paytm.o2o.movies.viewmodel.a aVar = this.f74118h;
                    if (aVar == null) {
                        kotlin.g.b.k.a("ajrUpcomingViewModel");
                    }
                    aVar.a((Activity) this, this.j);
                }
            }
        } else if (i2 == 101) {
            net.one97.paytm.o2o.movies.viewmodel.a aVar2 = this.f74118h;
            if (aVar2 == null) {
                kotlin.g.b.k.a("ajrUpcomingViewModel");
            }
            aVar2.a(this.f74113c, this.j, this);
        } else if (i2 == 102) {
            net.one97.paytm.o2o.movies.viewmodel.a aVar3 = this.f74118h;
            if (aVar3 == null) {
                kotlin.g.b.k.a("ajrUpcomingViewModel");
            }
            aVar3.b(this.f74113c, this.j, this);
        }
    }

    static final class o implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74136a;

        o(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74136a = aJRUpcomingMoviesActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            AJRUpcomingMoviesActivity.c(this.f74136a);
        }
    }

    static final class n implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74135a;

        n(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74135a = aJRUpcomingMoviesActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            this.f74135a.finish();
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "base");
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.g.b.k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public static final class l implements ImageLoader.ImageListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74133a;

        l(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74133a = aJRUpcomingMoviesActivity;
        }

        public final void onErrorResponse(VolleyError volleyError) {
            kotlin.g.b.k.c(volleyError, "volleyError");
            ((ImageView) this.f74133a.b(R.id.header_image)).setBackgroundColor(androidx.core.content.b.c(this.f74133a, net.one97.paytm.common.assets.R.color.color_000000));
        }

        public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
            if (imageContainer == null || imageContainer.getBitmap() == null) {
                ((ImageView) this.f74133a.b(R.id.header_image)).setBackgroundColor(androidx.core.content.b.c(this.f74133a, net.one97.paytm.common.assets.R.color.color_000000));
            } else {
                ((ImageView) this.f74133a.b(R.id.header_image)).setImageBitmap(imageContainer.getBitmap());
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74134a;

        m(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74134a = aJRUpcomingMoviesActivity;
        }

        public final void onClick(View view) {
            this.f74134a.onBackPressed();
        }
    }

    public static final class i implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74130a;

        i(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
            this.f74130a = aJRUpcomingMoviesActivity;
        }

        public final void onGlobalLayout() {
            RelativeLayout relativeLayout = (RelativeLayout) this.f74130a.b(R.id.sub_layout);
            kotlin.g.b.k.a((Object) relativeLayout, "sub_layout");
            int height = relativeLayout.getHeight();
            if (height > 0) {
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.f74130a.b(R.id.movie_details_collapse_toolbar);
                kotlin.g.b.k.a((Object) collapsingToolbarLayout, "movie_details_collapse_toolbar");
                collapsingToolbarLayout.setExpandedTitleMarginBottom(height + com.paytm.utility.b.c(10));
                RelativeLayout relativeLayout2 = (RelativeLayout) this.f74130a.b(R.id.sub_layout);
                kotlin.g.b.k.a((Object) relativeLayout2, "sub_layout");
                relativeLayout2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r10, net.one97.paytm.o2o.movies.viewmodel.a.f r11, net.one97.paytm.o2o.movies.viewmodel.a.c r12) {
        /*
            r9 = this;
            int r0 = net.one97.paytm.o2o.movies.R.id.llInteresteLayout
            android.view.View r0 = r9.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            java.lang.String r1 = "llInteresteLayout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            if (r11 != 0) goto L_0x0014
            return
        L_0x0014:
            int r0 = net.one97.paytm.o2o.movies.R.id.llReleaseTextLayout
            android.view.View r0 = r9.b((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r2 = "llReleaseTextLayout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.o2o.movies.R.id.txt_releaseDate
            android.view.View r0 = r9.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "txt_releaseDate"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r0.setText(r10)
            r10 = 1
            if (r12 == 0) goto L_0x005a
            java.lang.String r0 = r12.f76022c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 == 0) goto L_0x005a
            android.content.Context r0 = r9.getApplicationContext()
            java.lang.String r12 = r12.f76022c
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            android.widget.Toast r12 = android.widget.Toast.makeText(r0, r12, r1)
            r12.show()
            goto L_0x00ee
        L_0x005a:
            boolean r12 = r11.f76028c
            if (r12 == 0) goto L_0x00ee
            r12 = r9
            android.content.Context r12 = (android.content.Context) r12
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.d.b((android.content.Context) r12)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.Q
            java.lang.String r4 = "screenName"
            r2.put(r4, r3)
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75007b
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.u
            r2.put(r3, r4)
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75008c
            android.content.res.Resources r4 = r9.getResources()
            int r5 = net.one97.paytm.o2o.movies.R.string.like_clicked
            java.lang.String r4 = r4.getString(r5)
            r2.put(r3, r4)
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75009d
            java.lang.String r4 = r9.f74119i
            r2.put(r3, r4)
            boolean r3 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r0)
            if (r3 == 0) goto L_0x0099
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75013h
            r2.put(r3, r0)
        L_0x0099:
            java.lang.String r0 = r9.j
            boolean r0 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r0)
            if (r0 == 0) goto L_0x00a8
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75014i
            java.lang.String r3 = r9.f74119i
            r2.put(r0, r3)
        L_0x00a8:
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.j
            java.lang.String r3 = r9.j
            r2.put(r0, r3)
            java.lang.String r0 = r9.k
            boolean r0 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r0)
            if (r0 == 0) goto L_0x00be
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.n
            java.lang.String r3 = r9.k
            r2.put(r0, r3)
        L_0x00be:
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.p
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.r
            r2.put(r0, r3)
            boolean r0 = com.paytm.utility.b.r((android.content.Context) r12)
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.q
            java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r12)
            r2.put(r0, r3)
        L_0x00d4:
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75006a
            java.util.Map r2 = (java.util.Map) r2
            r0.sendCustomEventWithMap(r3, r2, r12)
            android.content.Context r12 = r9.getApplicationContext()
            java.lang.String r0 = "We\\'ll keep you posted with exciting movie updates."
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.widget.Toast r12 = android.widget.Toast.makeText(r12, r0, r1)
            r12.show()
        L_0x00ee:
            long r2 = r11.f76026a
            r4 = 0
            java.lang.String r12 = "textInterestedLabel"
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0108
            int r0 = net.one97.paytm.o2o.movies.R.id.textInterestedLabel
            android.view.View r0 = r9.b((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            r0.setVisibility(r1)
            goto L_0x0118
        L_0x0108:
            int r0 = net.one97.paytm.o2o.movies.R.id.textInterestedLabel
            android.view.View r0 = r9.b((int) r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            r12 = 8
            r0.setVisibility(r12)
        L_0x0118:
            int r12 = net.one97.paytm.o2o.movies.R.id.txt_interest_count
            android.view.View r12 = r9.b((int) r12)
            com.paytm.utility.RoboTextView r12 = (com.paytm.utility.RoboTextView) r12
            java.lang.String r0 = "txt_interest_count"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            r2 = 999(0x3e7, double:4.936E-321)
            r4 = 1
            long r6 = r11.f76026a
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0131
            goto L_0x013e
        L_0x0131:
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x013e
            long r2 = r11.f76026a
            java.lang.String r10 = java.lang.String.valueOf(r2)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            goto L_0x0180
        L_0x013e:
            long r2 = r11.f76026a
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x017c
            android.content.res.Resources r0 = r9.getResources()
            int r2 = net.one97.paytm.o2o.movies.R.string.video_count
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.text.DecimalFormat r4 = new java.text.DecimalFormat
            java.lang.String r5 = "##.#"
            r4.<init>(r5)
            long r5 = r11.f76026a
            double r5 = (double) r5
            r7 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r5 = r5 / r7
            java.lang.String r4 = r4.format(r5)
            r3.append(r4)
            java.lang.String r4 = "k"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r10[r1] = r3
            java.lang.String r10 = r0.getString(r2, r10)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            goto L_0x0180
        L_0x017c:
            java.lang.String r10 = "No Votes"
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
        L_0x0180:
            r12.setText(r10)
            int r10 = net.one97.paytm.o2o.movies.R.id.llInterestTextLayout
            android.view.View r10 = r9.b((int) r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            java.lang.String r12 = "llInterestTextLayout"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r12)
            r10.setVisibility(r1)
            int r10 = net.one97.paytm.o2o.movies.R.id.llInterestedCTALayout
            android.view.View r10 = r9.b((int) r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r10.setVisibility(r1)
            int r12 = net.one97.paytm.o2o.movies.R.id.llInterestedCTALayout
            android.view.View r12 = r9.b((int) r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            java.lang.String r0 = "llInterestedCTALayout"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
            boolean r0 = r11.f76029d
            r12.setEnabled(r0)
            boolean r12 = r11.f76027b
            if (r12 == 0) goto L_0x01cf
            android.content.res.Resources r12 = r10.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.drawable.grey_movies_rounded_border
            android.graphics.drawable.Drawable r12 = r12.getDrawable(r0)
            r10.setBackground(r12)
            int r12 = net.one97.paytm.o2o.movies.R.id.interestedCTAIcon
            android.view.View r12 = r9.b((int) r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            int r0 = net.one97.paytm.o2o.movies.R.drawable.interested_count
            r12.setImageResource(r0)
            goto L_0x01fa
        L_0x01cf:
            int r12 = net.one97.paytm.o2o.movies.R.id.interestedCTAText
            android.view.View r12 = r9.b((int) r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r0 = "#ffffff"
            int r0 = android.graphics.Color.parseColor(r0)
            r12.setTextColor(r0)
            int r12 = net.one97.paytm.o2o.movies.R.id.interestedCTAIcon
            android.view.View r12 = r9.b((int) r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            int r0 = net.one97.paytm.o2o.movies.R.drawable.interestedselected
            r12.setImageResource(r0)
            android.content.res.Resources r12 = r10.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.drawable.green_interested_cta
            android.graphics.drawable.Drawable r12 = r12.getDrawable(r0)
            r10.setBackground(r12)
        L_0x01fa:
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$e r12 = new net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$e
            r12.<init>(r9, r11)
            android.view.View$OnClickListener r12 = (android.view.View.OnClickListener) r12
            r10.setOnClickListener(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.a(java.lang.String, net.one97.paytm.o2o.movies.viewmodel.a$f, net.one97.paytm.o2o.movies.viewmodel.a$c):void");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.f f74125b;

        e(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity, a.f fVar) {
            this.f74124a = aJRUpcomingMoviesActivity;
            this.f74125b = fVar;
        }

        public final void onClick(View view) {
            if (this.f74125b.f76027b) {
                if (!com.paytm.utility.b.c((Context) this.f74124a)) {
                    Toast.makeText(this.f74124a, net.one97.paytm.common.assets.R.string.no_internet, 0).show();
                } else if (com.paytm.utility.b.r((Context) this.f74124a)) {
                    net.one97.paytm.o2o.movies.viewmodel.a a2 = AJRUpcomingMoviesActivity.a(this.f74124a);
                    AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity = this.f74124a;
                    a2.a((Activity) aJRUpcomingMoviesActivity, aJRUpcomingMoviesActivity.j);
                } else {
                    AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity2 = this.f74124a;
                    aJRUpcomingMoviesActivity2.a(aJRUpcomingMoviesActivity2.f74117g);
                }
            }
        }
    }

    public final void onClick(View view) {
        if (view == null || view.getId() != R.id.id_like_cont) {
            if (view != null && view.getId() == R.id.id_dislike_cont) {
                if (com.paytm.utility.b.r(getApplicationContext())) {
                    net.one97.paytm.o2o.movies.viewmodel.a aVar = this.f74118h;
                    if (aVar == null) {
                        kotlin.g.b.k.a("ajrUpcomingViewModel");
                    }
                    aVar.b(this.f74113c, this.j, this);
                    return;
                }
                a(102);
            }
        } else if (com.paytm.utility.b.r(getApplicationContext())) {
            net.one97.paytm.o2o.movies.viewmodel.a aVar2 = this.f74118h;
            if (aVar2 == null) {
                kotlin.g.b.k.a("ajrUpcomingViewModel");
            }
            aVar2.a(this.f74113c, this.j, this);
        } else {
            a(101);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRUpcomingMoviesActivity f74126a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f74127b;

        f(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity, String str) {
            this.f74126a = aJRUpcomingMoviesActivity;
            this.f74127b = str;
        }

        public final void onClick(View view) {
            new StringBuilder("URL ------").append(this.f74127b);
            com.paytm.utility.b.j();
            AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity = this.f74126a;
            aJRUpcomingMoviesActivity.startActivity(new Intent(aJRUpcomingMoviesActivity, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("AJRYoutubeVideoPlay")).putExtra(com.paytm.utility.e.aA, this.f74127b));
        }
    }

    public static final /* synthetic */ void a(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity, a.C1499a aVar) {
        aJRUpcomingMoviesActivity.f74119i = aVar.f76010a;
        aJRUpcomingMoviesActivity.j = aVar.f76011b;
        try {
            if (ExtensionsKt.isNotNullNotBlank(aVar.f76012c)) {
                aJRUpcomingMoviesActivity.k = aVar.f76012c;
            }
        } catch (Exception unused) {
        }
        CharSequence charSequence = aVar.f76015f;
        if (charSequence == null || charSequence.length() == 0) {
            AppBarLayout appBarLayout = (AppBarLayout) aJRUpcomingMoviesActivity.b(R.id.movie_details_appbar);
            kotlin.g.b.k.a((Object) appBarLayout, "movie_details_appbar");
            appBarLayout.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) aJRUpcomingMoviesActivity.b(R.id.toolbar_with_out_header_image);
            kotlin.g.b.k.a((Object) relativeLayout, "toolbar_with_out_header_image");
            relativeLayout.setVisibility(0);
            TextView textView = (TextView) aJRUpcomingMoviesActivity.b(R.id.movie_name);
            kotlin.g.b.k.a((Object) textView, "movie_name");
            textView.setText(aVar.f76010a);
            TextView textView2 = (TextView) aJRUpcomingMoviesActivity.b(R.id.text_1);
            kotlin.g.b.k.a((Object) textView2, "text_1");
            textView2.setText(aVar.f76013d);
            ((ImageView) aJRUpcomingMoviesActivity.b(R.id.back_btn)).setOnClickListener(new m(aJRUpcomingMoviesActivity));
            return;
        }
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) aJRUpcomingMoviesActivity.b(R.id.movie_details_collapse_toolbar);
        kotlin.g.b.k.a((Object) collapsingToolbarLayout, "movie_details_collapse_toolbar");
        collapsingToolbarLayout.setTitle(aVar.f76010a);
        RoboTextView roboTextView = (RoboTextView) aJRUpcomingMoviesActivity.b(R.id.movie_banner_subTitle);
        kotlin.g.b.k.a((Object) roboTextView, "movie_banner_subTitle");
        roboTextView.setText(aVar.f76013d);
        RoboTextView roboTextView2 = (RoboTextView) aJRUpcomingMoviesActivity.b(R.id.movie_banner_cast);
        kotlin.g.b.k.a((Object) roboTextView2, "movie_banner_cast");
        roboTextView2.setText(aVar.f76014e);
        CollapsingToolbarLayout collapsingToolbarLayout2 = (CollapsingToolbarLayout) aJRUpcomingMoviesActivity.b(R.id.movie_details_collapse_toolbar);
        kotlin.g.b.k.a((Object) collapsingToolbarLayout2, "movie_details_collapse_toolbar");
        collapsingToolbarLayout2.setVisibility(0);
    }

    public static final /* synthetic */ void a(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity, String str) {
        if (str != null) {
            int a2 = com.paytm.utility.b.a((Activity) aJRUpcomingMoviesActivity);
            int i2 = (int) (((double) a2) / 1.8d);
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) aJRUpcomingMoviesActivity.b(R.id.movie_details_collapse_toolbar);
            kotlin.g.b.k.a((Object) collapsingToolbarLayout, "movie_details_collapse_toolbar");
            collapsingToolbarLayout.getLayoutParams().height = i2;
            ImageView imageView = (ImageView) aJRUpcomingMoviesActivity.b(R.id.header_image);
            kotlin.g.b.k.a((Object) imageView, "header_image");
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = a2;
            ImageView imageView2 = (ImageView) aJRUpcomingMoviesActivity.b(R.id.header_image);
            kotlin.g.b.k.a((Object) imageView2, "header_image");
            imageView2.setTag(str);
            v.loadImage$default(v.INSTANCE, str, new l(aJRUpcomingMoviesActivity), a2, i2, (Map) null, 16, (Object) null);
        }
    }

    public static final /* synthetic */ void b(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity, String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            ImageView imageView = (ImageView) aJRUpcomingMoviesActivity.b(R.id.youtube_play_icon);
            kotlin.g.b.k.a((Object) imageView, "youtube_play_icon");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = (ImageView) aJRUpcomingMoviesActivity.b(R.id.youtube_play_icon);
        imageView2.setVisibility(0);
        imageView2.setOnClickListener(new f(aJRUpcomingMoviesActivity, str));
    }

    public static final /* synthetic */ void b(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
        RelativeLayout relativeLayout = (RelativeLayout) aJRUpcomingMoviesActivity.b(R.id.sub_layout);
        kotlin.g.b.k.a((Object) relativeLayout, "sub_layout");
        relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new i(aJRUpcomingMoviesActivity));
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [kotlin.x] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity r13, net.one97.paytm.o2o.movies.viewmodel.a.j r14, net.one97.paytm.o2o.movies.viewmodel.a.c r15) {
        /*
            java.lang.String r0 = r13.f74112a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0015
            if (r14 == 0) goto L_0x000f
            net.one97.paytm.o2o.movies.viewmodel.a$f r1 = r14.f76034a
        L_0x000f:
            java.lang.String r14 = "Coming Soon"
            r13.a((java.lang.String) r14, (net.one97.paytm.o2o.movies.viewmodel.a.f) r1, (net.one97.paytm.o2o.movies.viewmodel.a.c) r15)
            return
        L_0x0015:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r3 = "yyyy-MM-dd"
            r0.<init>(r3, r2)
            java.lang.String r2 = r13.f74112a
            java.util.Date r0 = r0.parse(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            boolean r0 = r2.before(r0)
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r13.f74112a
            java.lang.String r2 = "dd MMM yy"
            java.lang.String r0 = com.paytm.utility.b.h(r0, r3, r2)
            java.lang.String r2 = "rd"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            if (r14 == 0) goto L_0x0041
            net.one97.paytm.o2o.movies.viewmodel.a$f r1 = r14.f76034a
        L_0x0041:
            r13.a((java.lang.String) r0, (net.one97.paytm.o2o.movies.viewmodel.a.f) r1, (net.one97.paytm.o2o.movies.viewmodel.a.c) r15)
            return
        L_0x0045:
            if (r14 == 0) goto L_0x004a
            net.one97.paytm.o2o.movies.entity.SentimentInterestedItem r14 = r14.f76035b
            goto L_0x004b
        L_0x004a:
            r14 = r1
        L_0x004b:
            int r15 = net.one97.paytm.o2o.movies.R.id.id_about_movie_like_cont
            android.view.View r15 = r13.b((int) r15)
            java.lang.String r0 = "id_about_movie_like_cont"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r0 = 0
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.o2o.movies.R.id.id_like_cont
            android.view.View r15 = r13.b((int) r15)
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            r2 = r13
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r15.setOnClickListener(r2)
            int r15 = net.one97.paytm.o2o.movies.R.id.id_dislike_cont
            android.view.View r15 = r13.b((int) r15)
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            r15.setOnClickListener(r2)
            java.lang.String r15 = "Rate this movie"
            java.lang.String r2 = "id_rated_text"
            if (r14 == 0) goto L_0x031d
            java.lang.String r3 = r14.getPercentage()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r4 = "disliked"
            java.lang.String r5 = "liked"
            java.lang.String r6 = "id_inc_movie_content_liked"
            if (r3 != 0) goto L_0x0140
            int r3 = net.one97.paytm.o2o.movies.R.id.id_inc_movie_content_liked
            android.view.View r3 = r13.b((int) r3)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            r3.setVisibility(r0)
            java.util.HashMap r3 = r14.getCountInfo()
            if (r3 == 0) goto L_0x014e
            java.lang.Object r6 = r3.get(r5)
            java.lang.Long r6 = (java.lang.Long) r6
            r7 = 0
            if (r6 == 0) goto L_0x00ac
            long r9 = r6.longValue()
            goto L_0x00ad
        L_0x00ac:
            r9 = r7
        L_0x00ad:
            java.lang.Object r3 = r3.get(r4)
            java.lang.Long r3 = (java.lang.Long) r3
            if (r3 == 0) goto L_0x00ba
            long r11 = r3.longValue()
            goto L_0x00bb
        L_0x00ba:
            r11 = r7
        L_0x00bb:
            long r9 = r9 + r11
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x0112
            int r3 = net.one97.paytm.o2o.movies.R.id.txt_total_votes
            android.view.View r3 = r13.b((int) r3)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            java.lang.String r6 = "txt_total_votes"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = 1000(0x3e8, double:4.94E-321)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 >= 0) goto L_0x00de
            java.lang.String r7 = java.lang.String.valueOf(r9)
            goto L_0x0101
        L_0x00de:
            double r7 = (double) r9
            r9 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r7 = r7 / r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.text.DecimalFormat r10 = new java.text.DecimalFormat
            java.lang.String r11 = "##.#"
            r10.<init>(r11)
            java.lang.String r7 = r10.format(r7)
            r9.append(r7)
            java.lang.String r7 = "k"
            r9.append(r7)
            java.lang.String r7 = r9.toString()
        L_0x0101:
            r6.append(r7)
            java.lang.String r7 = " Votes"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x0112:
            int r3 = net.one97.paytm.o2o.movies.R.id.txt_Like_count
            android.view.View r3 = r13.b((int) r3)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            java.lang.String r6 = "txt_Like_count"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r14.getPercentage()
            if (r7 != 0) goto L_0x012e
            kotlin.g.b.k.a()
        L_0x012e:
            r6.append(r7)
            java.lang.String r7 = "% Liked"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
            goto L_0x014e
        L_0x0140:
            int r3 = net.one97.paytm.o2o.movies.R.id.id_inc_movie_content_liked
            android.view.View r3 = r13.b((int) r3)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            r6 = 8
            r3.setVisibility(r6)
        L_0x014e:
            java.lang.String r14 = r14.getUserInput()
            if (r14 == 0) goto L_0x031b
            r1 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r14, (boolean) r1)
            java.lang.String r5 = "You have rated"
            if (r3 == 0) goto L_0x01ef
            r13.f74113c = r1
            int r14 = net.one97.paytm.o2o.movies.R.id.id_rated_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r14.setText(r5)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.about_movie_like_selected
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setBackground(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.about_movie_no_selection_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setBackground(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.color.white
            int r1 = r1.getColor(r3)
            r14.setTextColor(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.color.color_222222
            int r1 = r1.getColor(r3)
            r14.setTextColor(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.ic_like_filled
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setImageDrawable(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.ic_dislike_disabled
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setImageDrawable(r1)
            goto L_0x0319
        L_0x01ef:
            boolean r14 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r14, (boolean) r1)
            if (r14 == 0) goto L_0x0288
            r14 = 2
            r13.f74113c = r14
            int r14 = net.one97.paytm.o2o.movies.R.id.id_rated_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r14.setText(r5)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.about_movie_no_selection_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setBackground(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.about_movie_dislike_selected
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setBackground(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.color.color_222222
            int r1 = r1.getColor(r3)
            r14.setTextColor(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.color.white
            int r1 = r1.getColor(r3)
            r14.setTextColor(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.ic_like_disabled
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setImageDrawable(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.ic_dislike_filled
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setImageDrawable(r1)
            goto L_0x0319
        L_0x0288:
            r13.f74113c = r0
            int r14 = net.one97.paytm.o2o.movies.R.id.id_rated_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            r1 = r15
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.about_movie_no_selection_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setBackground(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.about_movie_no_selection_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setBackground(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.color.color_222222
            int r1 = r1.getColor(r3)
            r14.setTextColor(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.color.color_222222
            int r1 = r1.getColor(r3)
            r14.setTextColor(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.ic_like_disabled
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setImageDrawable(r1)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r1 = r13.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.drawable.ic_dislike_disabled
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r14.setImageDrawable(r1)
        L_0x0319:
            kotlin.x r1 = kotlin.x.f47997a
        L_0x031b:
            if (r1 != 0) goto L_0x03b1
        L_0x031d:
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity r13 = (net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity) r13
            r13.f74113c = r0
            int r14 = net.one97.paytm.o2o.movies.R.id.id_rated_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r14.setText(r15)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r15 = r13.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.drawable.about_movie_no_selection_bg
            android.graphics.drawable.Drawable r15 = r15.getDrawable(r0)
            r14.setBackground(r15)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_cont
            android.view.View r14 = r13.b((int) r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            android.content.res.Resources r15 = r13.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.drawable.about_movie_no_selection_bg
            android.graphics.drawable.Drawable r15 = r15.getDrawable(r0)
            r14.setBackground(r15)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r15 = r13.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.color.color_222222
            int r15 = r15.getColor(r0)
            r14.setTextColor(r15)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_text
            android.view.View r14 = r13.b((int) r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            android.content.res.Resources r15 = r13.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.color.color_222222
            int r15 = r15.getColor(r0)
            r14.setTextColor(r15)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_like_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r15 = r13.getResources()
            int r0 = net.one97.paytm.o2o.movies.R.drawable.ic_like_disabled
            android.graphics.drawable.Drawable r15 = r15.getDrawable(r0)
            r14.setImageDrawable(r15)
            int r14 = net.one97.paytm.o2o.movies.R.id.id_dislike_img
            android.view.View r14 = r13.b((int) r14)
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            android.content.res.Resources r13 = r13.getResources()
            int r15 = net.one97.paytm.o2o.movies.R.drawable.ic_dislike_disabled
            android.graphics.drawable.Drawable r13 = r13.getDrawable(r15)
            r14.setImageDrawable(r13)
            kotlin.x r13 = kotlin.x.f47997a
        L_0x03b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.a(net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity, net.one97.paytm.o2o.movies.viewmodel.a$j, net.one97.paytm.o2o.movies.viewmodel.a$c):void");
    }

    public static final /* synthetic */ void a(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity, AppBarLayout appBarLayout) {
        int totalScrollRange = appBarLayout.getTotalScrollRange();
        if (totalScrollRange != 0) {
            RelativeLayout relativeLayout = (RelativeLayout) aJRUpcomingMoviesActivity.b(R.id.lyt_header_sub_title);
            kotlin.g.b.k.a((Object) relativeLayout, "lyt_header_sub_title");
            relativeLayout.setAlpha(1.0f - ((float) (Math.abs(aJRUpcomingMoviesActivity.f74115e) / (totalScrollRange / 2))));
            if (totalScrollRange == 0 || Math.abs(aJRUpcomingMoviesActivity.f74115e) != totalScrollRange) {
                ((CollapsingToolbarLayout) aJRUpcomingMoviesActivity.b(R.id.movie_details_collapse_toolbar)).setStatusBarScrimColor(androidx.core.content.b.c(aJRUpcomingMoviesActivity, 17170445));
            } else {
                ((CollapsingToolbarLayout) aJRUpcomingMoviesActivity.b(R.id.movie_details_collapse_toolbar)).setStatusBarScrimColor(androidx.core.content.b.c(aJRUpcomingMoviesActivity, net.one97.paytm.common.assets.R.color.app_theme_color));
            }
            if (aJRUpcomingMoviesActivity.f74115e >= -180) {
                if (aJRUpcomingMoviesActivity.f74116f != 0) {
                    com.paytm.utility.b.j();
                    aJRUpcomingMoviesActivity.f74116f = 0;
                    Drawable a2 = androidx.core.content.b.a((Context) aJRUpcomingMoviesActivity, R.drawable.movie_back_arrow_white);
                    if (a2 == null) {
                        kotlin.g.b.k.a();
                    }
                    aJRUpcomingMoviesActivity.f74114d = a2;
                }
            } else if (aJRUpcomingMoviesActivity.f74116f != 1) {
                com.paytm.utility.b.j();
                aJRUpcomingMoviesActivity.f74116f = 1;
                Drawable a3 = androidx.core.content.b.a((Context) aJRUpcomingMoviesActivity, net.one97.paytm.common.widgets.R.drawable.back_arrow);
                if (a3 == null) {
                    kotlin.g.b.k.a();
                }
                aJRUpcomingMoviesActivity.f74114d = a3;
            }
            ActionBar supportActionBar = aJRUpcomingMoviesActivity.getSupportActionBar();
            if (supportActionBar != null) {
                Drawable drawable = aJRUpcomingMoviesActivity.f74114d;
                if (drawable == null) {
                    kotlin.g.b.k.a("upArrow");
                }
                supportActionBar.b(drawable);
            }
        }
    }

    public static final /* synthetic */ void c(AJRUpcomingMoviesActivity aJRUpcomingMoviesActivity) {
        aJRUpcomingMoviesActivity.setResult(-1);
        aJRUpcomingMoviesActivity.finish();
    }

    public static final Intent b(Context context, String str, String str2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str2, "isFrom");
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.crashlyticsLogs("movieId data can't be null".toString());
            return null;
        }
        Intent intent = new Intent(context, AJRUpcomingMoviesActivity.class);
        intent.putExtra("param_movie_id", str);
        intent.putExtra("param_is_from", str2);
        return intent;
    }
}
