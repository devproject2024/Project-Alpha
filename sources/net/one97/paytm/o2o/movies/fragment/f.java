package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJREntertainmentWebViewActivity;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity;
import net.one97.paytm.o2o.movies.adapter.o;
import net.one97.paytm.o2o.movies.adapter.w;
import net.one97.paytm.o2o.movies.adapter.x;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieVideoViewCountResponse;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.viewmodel.a;
import org.json.JSONObject;

public final class f extends b implements q {

    /* renamed from: a  reason: collision with root package name */
    public static final a f75305a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.o2o.movies.viewmodel.a f75306b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AJRUpcomingMoviesActivity f75307c;

    /* renamed from: d  reason: collision with root package name */
    private String f75308d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f75309e = "";

    /* renamed from: f  reason: collision with root package name */
    private HashMap f75310f;

    private View a(int i2) {
        if (this.f75310f == null) {
            this.f75310f = new HashMap();
        }
        View view = (View) this.f75310f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f75310f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.o2o.movies.fragment.f$f  reason: collision with other inner class name */
    static final class C1488f<T> implements z<a.k<? extends List<? extends a.g>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f75315a;

        C1488f(f fVar) {
            this.f75315a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            a.l lVar;
            a.k kVar = (a.k) obj;
            if (kVar != null) {
                lVar = kVar.f76036a;
            } else {
                lVar = null;
            }
            if (lVar != null && g.f75317b[lVar.ordinal()] == 1) {
                AJRUpcomingMoviesActivity a2 = this.f75315a.f75307c;
                if (a2 != null) {
                    a2.a(false);
                }
                List<a.g> list = (List) kVar.f76037b;
                if (list != null) {
                    for (a.g gVar : list) {
                        int i2 = g.f75316a[gVar.f76030h.ordinal()];
                        if (i2 == 1) {
                            f fVar = this.f75315a;
                            if (gVar != null) {
                                f.a(fVar, (a.m) gVar);
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.viewmodel.AJRUpcomingViewModel.Synopsis");
                            }
                        } else if (i2 == 2) {
                            f fVar2 = this.f75315a;
                            if (gVar != null) {
                                f.a(fVar2, (a.n) gVar);
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.viewmodel.AJRUpcomingViewModel.Videos");
                            }
                        } else if (i2 == 3) {
                            f fVar3 = this.f75315a;
                            if (gVar != null) {
                                f.a(fVar3, (a.e) gVar);
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.viewmodel.AJRUpcomingViewModel.Gallery");
                            }
                        } else if (i2 == 4) {
                            f fVar4 = this.f75315a;
                            if (gVar != null) {
                                f.a(fVar4, (a.b) gVar);
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.viewmodel.AJRUpcomingViewModel.Blog");
                            }
                        } else if (i2 != 5) {
                            continue;
                        } else {
                            f fVar5 = this.f75315a;
                            if (gVar != null) {
                                f.a(fVar5, (a.i) gVar);
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.viewmodel.AJRUpcomingViewModel.LeadCast");
                            }
                        }
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.o2o.movies.viewmodel.a b(f fVar) {
        net.one97.paytm.o2o.movies.viewmodel.a aVar = fVar.f75306b;
        if (aVar == null) {
            k.a("ajrUpcomingViewModel");
        }
        return aVar;
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
        this.f75307c = (AJRUpcomingMoviesActivity) context;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_content_page, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(net.one97.paytm.o2o.movies.viewmodel.a.class);
            k.a((Object) a2, "ViewModelProviders.of(it…ingViewModel::class.java)");
            this.f75306b = (net.one97.paytm.o2o.movies.viewmodel.a) a2;
        }
        net.one97.paytm.o2o.movies.viewmodel.a aVar = this.f75306b;
        if (aVar == null) {
            k.a("ajrUpcomingViewModel");
        }
        aVar.f76005a.observe(this, new C1488f(this));
    }

    static final class e implements w.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f75314a;

        e(f fVar) {
            this.f75314a = fVar;
        }

        public final void a(Long l) {
            if (com.paytm.utility.b.c((Context) this.f75314a.getActivity())) {
                f.b(this.f75314a);
                RequestQueue b2 = com.paytm.network.f.b(this.f75314a.getActivity());
                k.a((Object) b2, "CJRVolley.getRequestQueue(activity)");
                f fVar = this.f75314a;
                k.a((Object) l, "videoId");
                net.one97.paytm.o2o.movies.viewmodel.a.a(b2, f.a(fVar, l.longValue()));
                return;
            }
            Toast.makeText(this.f75314a.getActivity(), net.one97.paytm.common.assets.R.string.no_internet, 0).show();
        }
    }

    public static final class b extends RecyclerView.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f75311a;

        b(f fVar) {
            this.f75311a = fVar;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                if (((RecyclerView.LayoutParams) layoutParams).f4054c.getAdapterPosition() == 0) {
                    rect.left = n.a(20, (Context) this.f75311a.f75307c);
                }
                rect.right = n.a(10, (Context) this.f75311a.f75307c);
                rect.top = n.a(4, (Context) this.f75311a.f75307c);
                rect.bottom = n.a(7, (Context) this.f75311a.f75307c);
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
    }

    private final void a(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new b(this));
        }
    }

    static final class d implements o.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f75312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.b f75313b;

        d(f fVar, a.b bVar) {
            this.f75312a = fVar;
            this.f75313b = bVar;
        }

        public final void a(String str) {
            if (!com.paytm.utility.b.c((Context) this.f75312a.getActivity())) {
                Toast.makeText(this.f75312a.getActivity(), net.one97.paytm.common.assets.R.string.no_internet, 0).show();
                return;
            }
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                Toast.makeText(this.f75312a.getActivity(), this.f75312a.getResources().getString(R.string.no_url_found), 0).show();
                return;
            }
            Intent intent = new Intent(this.f75312a.getActivity(), AJREntertainmentWebViewActivity.class);
            intent.putExtra("intent_movie_title", this.f75313b.f76018a);
            intent.putExtra("intent_movie_image_url", str);
            this.f75312a.startActivity(intent);
        }
    }

    private void b(RecyclerView recyclerView) {
        k.c(recyclerView, "recyclerView");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    public static final class c implements com.paytm.network.listener.b {
        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        }

        c() {
        }
    }

    public static final /* synthetic */ void a(f fVar, a.m mVar) {
        fVar.f75309e = mVar.f76039a;
        TextView textView = (TextView) fVar.a(R.id.title_detail_summary);
        k.a((Object) textView, "title_detail_summary");
        textView.setText(mVar.f76040b);
        fVar.f75308d = mVar.f76041c;
        String a2 = n.a(fVar.f75308d);
        RelativeLayout relativeLayout = (RelativeLayout) fVar.a(R.id.movie_detail_ReadMoreLayout);
        k.a((Object) relativeLayout, "movie_detail_ReadMoreLayout");
        relativeLayout.setVisibility(8);
        if (a2 != null) {
            TextView textView2 = (TextView) fVar.a(R.id.movie_detail_summary);
            k.a((Object) textView2, "movie_detail_summary");
            textView2.setText(p.b(a2).toString());
        }
        if (fVar.f75308d.length() > 0) {
            View a3 = fVar.a(R.id.synopsis_divider);
            k.a((Object) a3, "synopsis_divider");
            a3.setVisibility(0);
        }
    }

    public static final /* synthetic */ void a(f fVar, a.n nVar) {
        if (nVar.f76043b.isEmpty()) {
            RelativeLayout relativeLayout = (RelativeLayout) fVar.a(R.id.videoLayout);
            k.a((Object) relativeLayout, "videoLayout");
            relativeLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) fVar.a(R.id.videoLayout);
        k.a((Object) relativeLayout2, "videoLayout");
        relativeLayout2.setVisibility(0);
        TextView textView = (TextView) fVar.a(R.id.video_title);
        k.a((Object) textView, "video_title");
        textView.setText(nVar.f76042a);
        RecyclerView recyclerView = (RecyclerView) fVar.a(R.id.videoList);
        k.a((Object) recyclerView, "videoList");
        fVar.b(recyclerView);
        w wVar = new w(fVar.getActivity(), new e(fVar), (ArrayList) nVar.f76043b);
        wVar.f74796c = net.one97.paytm.o2o.movies.common.b.b.O;
        RecyclerView recyclerView2 = (RecyclerView) fVar.a(R.id.videoList);
        k.a((Object) recyclerView2, "videoList");
        recyclerView2.setAdapter(wVar);
        fVar.a((RecyclerView) fVar.a(R.id.videoList));
    }

    public static final /* synthetic */ void a(f fVar, a.e eVar) {
        if (eVar.f76025b.isEmpty()) {
            RelativeLayout relativeLayout = (RelativeLayout) fVar.a(R.id.galleryLayout);
            k.a((Object) relativeLayout, "galleryLayout");
            relativeLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) fVar.a(R.id.galleryLayout);
        k.a((Object) relativeLayout2, "galleryLayout");
        relativeLayout2.setVisibility(0);
        TextView textView = (TextView) fVar.a(R.id.gallery_title);
        k.a((Object) textView, "gallery_title");
        textView.setText(eVar.f76024a);
        RecyclerView recyclerView = (RecyclerView) fVar.a(R.id.galleryList);
        k.a((Object) recyclerView, "galleryList");
        fVar.b(recyclerView);
        net.one97.paytm.o2o.movies.adapter.u uVar = new net.one97.paytm.o2o.movies.adapter.u(fVar.getActivity(), (ArrayList) eVar.f76025b);
        uVar.f74777c = fVar.f75309e;
        uVar.f74778d = net.one97.paytm.o2o.movies.common.b.b.O;
        RecyclerView recyclerView2 = (RecyclerView) fVar.a(R.id.galleryList);
        k.a((Object) recyclerView2, "galleryList");
        recyclerView2.setAdapter(uVar);
        fVar.a((RecyclerView) fVar.a(R.id.galleryList));
    }

    public static final /* synthetic */ void a(f fVar, a.b bVar) {
        if (bVar.f76019b.isEmpty()) {
            RelativeLayout relativeLayout = (RelativeLayout) fVar.a(R.id.entertainment_layout);
            k.a((Object) relativeLayout, "entertainment_layout");
            relativeLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) fVar.a(R.id.entertainment_layout);
        k.a((Object) relativeLayout2, "entertainment_layout");
        relativeLayout2.setVisibility(0);
        TextView textView = (TextView) fVar.a(R.id.entertainment_title);
        k.a((Object) textView, "entertainment_title");
        textView.setText(bVar.f76018a);
        RecyclerView recyclerView = (RecyclerView) fVar.a(R.id.entertainmentList);
        k.a((Object) recyclerView, "entertainmentList");
        fVar.b(recyclerView);
        o oVar = new o(fVar.requireContext(), (ArrayList) bVar.f76019b, new d(fVar, bVar));
        RecyclerView recyclerView2 = (RecyclerView) fVar.a(R.id.entertainmentList);
        k.a((Object) recyclerView2, "entertainmentList");
        recyclerView2.setAdapter(oVar);
        fVar.a((RecyclerView) fVar.a(R.id.entertainmentList));
    }

    public static final /* synthetic */ void a(f fVar, a.i iVar) {
        if (iVar.f76032b.isEmpty()) {
            RelativeLayout relativeLayout = (RelativeLayout) fVar.a(R.id.castLayout);
            k.a((Object) relativeLayout, "castLayout");
            relativeLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) fVar.a(R.id.castLayout);
        k.a((Object) relativeLayout2, "castLayout");
        relativeLayout2.setVisibility(0);
        TextView textView = (TextView) fVar.a(R.id.castTitle);
        k.a((Object) textView, "castTitle");
        textView.setText(iVar.f76031a);
        RecyclerView recyclerView = (RecyclerView) fVar.a(R.id.castList);
        k.a((Object) recyclerView, "castList");
        fVar.b(recyclerView);
        x xVar = new x(fVar.getActivity(), iVar.f76032b, iVar.f76033c);
        RecyclerView recyclerView2 = (RecyclerView) fVar.a(R.id.castList);
        k.a((Object) recyclerView2, "castList");
        recyclerView2.setAdapter(xVar);
        xVar.notifyDataSetChanged();
        fVar.a((RecyclerView) fVar.a(R.id.castList));
    }

    public static final /* synthetic */ com.paytm.network.a a(f fVar, long j) {
        k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("URLMoviesVideoViews_v2", (String) null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", j);
        jSONObject.put("metricType", "videoviews");
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = fVar.getActivity();
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.POST;
        cVar.f42880d = a2;
        cVar.f42881e = null;
        cVar.f42882f = null;
        cVar.f42883g = null;
        cVar.f42884h = jSONObject.toString();
        cVar.f42885i = new CJRMovieVideoViewCountResponse();
        cVar.j = new c();
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h("FJRMovieContent");
        com.paytm.network.a l = cVar.l();
        k.a((Object) l, "CJRCommonNetworkCallBuil…\n                .build()");
        return l;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f75310f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
