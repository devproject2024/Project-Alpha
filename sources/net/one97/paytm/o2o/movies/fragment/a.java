package net.one97.paytm.o2o.movies.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJREntertainmentWebViewActivity;
import net.one97.paytm.o2o.movies.adapter.o;
import net.one97.paytm.o2o.movies.adapter.u;
import net.one97.paytm.o2o.movies.adapter.w;
import net.one97.paytm.o2o.movies.adapter.x;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieVideoViewCountResponse;
import net.one97.paytm.o2o.movies.common.movies.CJRMoviesContentCastCrewModel;
import net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse;
import net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem;
import net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem;
import net.one97.paytm.o2o.movies.entity.SentimentInterestedItem;
import net.one97.paytm.o2o.movies.fragment.i;
import net.one97.paytm.o2o.movies.utils.j;
import net.one97.paytm.o2o.movies.utils.n;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b implements View.OnClickListener, b, o.b, w.a {
    /* access modifiers changed from: private */
    public boolean A = false;
    /* access modifiers changed from: private */
    public CJRMoviesContentCastCrewModel B;
    private String C;
    private net.one97.paytm.o2o.movies.d.b D;
    private i.d E;
    private String F;
    private String G;
    private BroadcastReceiver H;
    private ProgressBar I;
    /* access modifiers changed from: private */
    public Context J;
    /* access modifiers changed from: private */
    public LinearLayout K;
    /* access modifiers changed from: private */
    public LinearLayout L;
    /* access modifiers changed from: private */
    public LinearLayout M;
    /* access modifiers changed from: private */
    public RelativeLayout N;
    private View O;
    /* access modifiers changed from: private */
    public CJRGetMetricInfoResponse P;
    private TextView Q;
    private LinearLayout R;
    private LinearLayout S;
    private View T;
    private View U;
    private ImageView V;
    private RoboTextView W;
    private ImageView X;
    private RoboTextView Y;
    /* access modifiers changed from: private */
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    private TextView f75239a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f75240b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f75241c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f75242d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f75243e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f75244f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f75245g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f75246h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f75247i;
    /* access modifiers changed from: private */
    public ImageView j;
    /* access modifiers changed from: private */
    public RoboTextView k;
    private RelativeLayout l;
    private RelativeLayout m;
    private RelativeLayout n;
    private RecyclerView o;
    private RecyclerView p;
    private RecyclerView q;
    private RelativeLayout r;
    private TextView s;
    private TextView t;
    private TextView u;
    private RecyclerView v;
    private String w;
    private String x;
    private View y;
    /* access modifiers changed from: private */
    public boolean z;

    public static a a(String str, String str2, String str3, String str4) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("movie_ticket_selected_item_value", str);
        bundle.putString("intent_extra_grid_movie_name", str2);
        bundle.putString("movie_ticket_selected_item_type", str3);
        bundle.putString("intent_movie_session", str4);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.J = context;
        this.D = (net.one97.paytm.o2o.movies.d.b) context;
        this.E = (i.d) context;
        this.H = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (a.this.B == null) {
                    a.b(a.this);
                    a.c(a.this);
                }
            }
        };
        androidx.localbroadcastmanager.a.a.a(context).a(this.H, new IntentFilter("callAboutMovieAPI"));
    }

    public void onDetach() {
        super.onDetach();
        androidx.localbroadcastmanager.a.a.a(getContext()).a(this.H);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.movie_tab_detail_layout, viewGroup, false);
        this.w = getArguments().getString("movie_ticket_selected_item_value");
        this.x = getArguments().getString("intent_extra_grid_movie_name");
        this.F = getArguments().getString("movie_ticket_selected_item_type");
        this.G = getArguments().getString("intent_movie_session");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.N = (RelativeLayout) view.findViewById(R.id.llInteresteLayout);
        this.K = (LinearLayout) view.findViewById(R.id.llInterestTextLayout);
        this.L = (LinearLayout) view.findViewById(R.id.llInterestedCTALayout);
        this.M = (LinearLayout) view.findViewById(R.id.llReleaseTextLayout);
        this.f75241c = (TextView) view.findViewById(R.id.interestedCTAText);
        this.f75242d = (TextView) view.findViewById(R.id.txt_releaseDate);
        this.f75239a = (TextView) view.findViewById(R.id.title_detail_summary);
        this.f75244f = (ImageView) view.findViewById(R.id.interestedCTAIcon);
        this.f75240b = (TextView) view.findViewById(R.id.txt_interest_count);
        this.f75243e = (TextView) view.findViewById(R.id.textInterestedLabel);
        this.f75245g = (TextView) view.findViewById(R.id.movie_detail_summary);
        this.f75246h = (TextView) view.findViewById(R.id.castTitle);
        this.f75247i = (RelativeLayout) view.findViewById(R.id.movie_detail_ReadMoreLayout);
        this.j = (ImageView) view.findViewById(R.id.readMoreArrow);
        this.k = (RoboTextView) view.findViewById(R.id.movie_detail_read_more);
        this.y = view.findViewById(R.id.synopsis_divider);
        this.l = (RelativeLayout) view.findViewById(R.id.castLayout);
        this.m = (RelativeLayout) view.findViewById(R.id.galleryLayout);
        this.n = (RelativeLayout) view.findViewById(R.id.videoLayout);
        this.o = (RecyclerView) view.findViewById(R.id.castList);
        this.p = (RecyclerView) view.findViewById(R.id.galleryList);
        this.q = (RecyclerView) view.findViewById(R.id.videoList);
        this.q.setNestedScrollingEnabled(false);
        this.r = (RelativeLayout) view.findViewById(R.id.entertainment_layout);
        this.s = (TextView) view.findViewById(R.id.gallery_title);
        this.t = (TextView) view.findViewById(R.id.video_title);
        this.u = (TextView) view.findViewById(R.id.entertainment_title);
        this.v = (RecyclerView) view.findViewById(R.id.entertainmentList);
        this.I = (ProgressBar) view.findViewById(R.id.movie_detail_progress_bar);
        this.o.setNestedScrollingEnabled(false);
        this.p.setNestedScrollingEnabled(false);
        this.O = view.findViewById(R.id.id_about_movie_like_cont);
        this.Q = (TextView) view.findViewById(R.id.id_rated_text);
        this.R = (LinearLayout) view.findViewById(R.id.id_like_cont);
        this.V = (ImageView) view.findViewById(R.id.id_like_img);
        this.W = (RoboTextView) view.findViewById(R.id.id_like_text);
        this.S = (LinearLayout) view.findViewById(R.id.id_dislike_cont);
        this.X = (ImageView) view.findViewById(R.id.id_dislike_img);
        this.Y = (RoboTextView) view.findViewById(R.id.id_dislike_text);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.T = view.findViewById(R.id.id_inc_movie_content_interested);
        this.U = view.findViewById(R.id.id_inc_movie_content_liked);
    }

    /* access modifiers changed from: private */
    public void a() {
        LikeDisLikeInfoItem e2;
        String str;
        String str2;
        if (getActivity() != null && isAdded() && !isDetached()) {
            this.T.setVisibility(8);
            this.U.setVisibility(8);
            if (this.P != null && (e2 = e()) != null) {
                if (a(this.B)) {
                    this.L.setVisibility(0);
                    this.K.setVisibility(0);
                    this.M.setVisibility(0);
                    this.N.setVisibility(0);
                    this.f75243e.setVisibility(0);
                    this.f75242d.setText(com.paytm.utility.b.h(this.B.releaseDate, "yyyy-MM-dd", "dd MMM yy"));
                    long longValue = (e2.getInterested() == null || e2.getInterested().getCountInfo() == null) ? 0 : e2.getInterested().getCountInfo().get(H5AppHandler.CHECK_VALUE).longValue();
                    if (longValue > 0) {
                        TextView textView = this.f75240b;
                        if (longValue < 1000) {
                            str2 = String.valueOf(longValue);
                        } else {
                            str2 = new DecimalFormat("##.#").format(((double) longValue) / 1000.0d) + "k";
                        }
                        textView.setText(str2);
                        if (e2.getInterested().getUserInput() == null || !e2.getInterested().getUserInput().equalsIgnoreCase(H5AppHandler.CHECK_VALUE)) {
                            this.L.setOnClickListener(this);
                            return;
                        }
                        this.f75244f.setImageResource(R.drawable.interestedselected);
                        this.f75241c.setTextColor(Color.parseColor("#ffffff"));
                        this.L.setBackground(getResources().getDrawable(R.drawable.green_interested_cta));
                        return;
                    }
                    this.f75240b.setText("No Votes");
                    this.f75243e.setVisibility(8);
                    this.K.setVisibility(0);
                    this.L.setOnClickListener(this);
                    return;
                }
                this.O.setVisibility(0);
                SentimentInterestedItem sentiment = e2.getSentiment();
                if (sentiment != null) {
                    if (!TextUtils.isEmpty(sentiment.getPercentage())) {
                        this.U.setVisibility(0);
                        HashMap<String, Long> countInfo = sentiment.getCountInfo();
                        if (countInfo != null) {
                            Long l2 = countInfo.get("liked");
                            long longValue2 = l2 != null ? l2.longValue() : 0;
                            Long l3 = countInfo.get("disliked");
                            long longValue3 = longValue2 + (l3 != null ? l3.longValue() : 0);
                            RoboTextView roboTextView = (RoboTextView) this.U.findViewById(R.id.txt_total_votes);
                            if (longValue3 > 0) {
                                StringBuilder sb = new StringBuilder();
                                if (longValue3 < 1000) {
                                    str = String.valueOf(longValue3);
                                } else {
                                    str = new DecimalFormat("##.#").format(((double) longValue3) / 1000.0d) + "k";
                                }
                                sb.append(str);
                                sb.append(" Votes");
                                roboTextView.setText(sb.toString());
                            }
                            ((RoboTextView) this.U.findViewById(R.id.txt_Like_count)).setText(sentiment.getPercentage() + "% Liked");
                        }
                    }
                    String userInput = sentiment.getUserInput();
                    if ("liked".equalsIgnoreCase(userInput)) {
                        this.Z = 1;
                        this.Q.setText("You have rated");
                        this.R.setBackground(this.J.getResources().getDrawable(R.drawable.about_movie_like_selected));
                        this.S.setBackground(this.J.getResources().getDrawable(R.drawable.about_movie_no_selection_bg));
                        this.W.setTextColor(getResources().getColor(R.color.white));
                        this.Y.setTextColor(getResources().getColor(R.color.color_222222));
                        this.V.setImageDrawable(getResources().getDrawable(R.drawable.ic_like_filled));
                        this.X.setImageDrawable(getResources().getDrawable(R.drawable.ic_dislike_disabled));
                    } else if ("disliked".equalsIgnoreCase(userInput)) {
                        this.Z = 2;
                        this.Q.setText("You have rated");
                        this.R.setBackground(this.J.getResources().getDrawable(R.drawable.about_movie_no_selection_bg));
                        this.S.setBackground(this.J.getResources().getDrawable(R.drawable.about_movie_dislike_selected));
                        this.W.setTextColor(getResources().getColor(R.color.color_222222));
                        this.Y.setTextColor(getResources().getColor(R.color.white));
                        this.V.setImageDrawable(getResources().getDrawable(R.drawable.ic_like_disabled));
                        this.X.setImageDrawable(getResources().getDrawable(R.drawable.ic_dislike_filled));
                    } else {
                        this.Z = 0;
                        this.Q.setText("Rate this movie");
                        this.R.setBackground(this.J.getResources().getDrawable(R.drawable.about_movie_no_selection_bg));
                        this.S.setBackground(this.J.getResources().getDrawable(R.drawable.about_movie_no_selection_bg));
                        this.W.setTextColor(getResources().getColor(R.color.color_222222));
                        this.Y.setTextColor(getResources().getColor(R.color.color_222222));
                        this.V.setImageDrawable(getResources().getDrawable(R.drawable.ic_like_disabled));
                        this.X.setImageDrawable(getResources().getDrawable(R.drawable.ic_dislike_disabled));
                    }
                }
            }
        }
    }

    private boolean a(CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel) {
        if (cJRMoviesContentCastCrewModel.releaseDate == null) {
            return false;
        }
        try {
            if (new Date().before(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(cJRMoviesContentCastCrewModel.releaseDate))) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            this.M.setVisibility(8);
            return false;
        }
    }

    private void a(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new RecyclerView.h() {
                public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    super.getItemOffsets(rect, view, recyclerView, sVar);
                    if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                        rect.left = n.a(20, a.this.J);
                    }
                    rect.right = n.a(10, a.this.J);
                    rect.top = n.a(4, a.this.J);
                    rect.bottom = n.a(7, a.this.J);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        String a2 = n.a(str);
        if (a2 != null) {
            this.f75245g.setText(a2.trim());
        }
        this.f75247i.setVisibility(8);
    }

    public final void a(Long l2) {
        if (com.paytm.utility.b.c(getContext())) {
            try {
                c.a();
                this.C = c.a("URLMoviesVideoViews_v2", (String) null);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", l2);
                jSONObject.put("metricType", "videoviews");
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("ClientId", "paytm");
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                cVar.f42877a = this.J;
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.POST;
                cVar.f42880d = this.C;
                cVar.f42881e = null;
                cVar.f42882f = hashMap;
                cVar.f42883g = null;
                cVar.f42884h = jSONObject.toString();
                cVar.f42885i = new CJRMovieVideoViewCountResponse();
                cVar.j = this;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("FJRAboutMovieFragment");
                com.paytm.network.a l3 = cVar.l();
                l3.f42859c = false;
                l3.a();
            } catch (JSONException unused) {
            }
        }
    }

    public final void a(String str) {
        if (!com.paytm.utility.b.c(getContext())) {
            Toast.makeText(getContext(), net.one97.paytm.common.assets.R.string.no_internet, 0).show();
        } else if (TextUtils.isEmpty(str)) {
            Toast.makeText(getContext(), "no url found", 0).show();
        } else {
            Intent intent = new Intent(getContext(), AJREntertainmentWebViewActivity.class);
            CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel = this.B;
            if (cJRMoviesContentCastCrewModel != null) {
                intent.putExtra("intent_movie_title", cJRMoviesContentCastCrewModel.getBlogHeading());
            }
            intent.putExtra("intent_movie_image_url", str);
            startActivity(intent);
        }
    }

    public void onClick(View view) {
        if (!this.z) {
            int id = view.getId();
            if (id == R.id.llInterestedCTALayout) {
                if (this.A) {
                    return;
                }
                if (!com.paytm.utility.b.c(getContext())) {
                    Toast.makeText(getContext(), net.one97.paytm.common.assets.R.string.no_internet, 0).show();
                } else if (com.paytm.utility.b.r(getContext())) {
                    c();
                } else {
                    a(107);
                }
            } else if (id == R.id.id_like_cont) {
                if (com.paytm.utility.b.r(getContext())) {
                    d();
                } else {
                    a(101);
                }
            } else if (id != R.id.id_dislike_cont) {
            } else {
                if (com.paytm.utility.b.r(getContext())) {
                    b();
                } else {
                    a(102);
                }
            }
        }
    }

    private void b() {
        int i2 = this.Z;
        if (i2 != 2) {
            j.a(getActivity(), this.w, new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean unused = a.this.z = false;
                        a aVar = a.this;
                        a.a(aVar, "disliked", true, aVar.Z != 1);
                        a.this.a();
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean unused = a.this.z = false;
                    }
                }
            }, "sentiment", "disliked");
        } else if (i2 == 2) {
            j.a((Activity) getActivity(), this.w, (b) new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean unused = a.this.z = false;
                        a.a(a.this, "disliked", false, true);
                        a.this.a();
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean unused = a.this.z = false;
                    }
                }
            }, "sentiment");
        }
    }

    private void c() {
        this.A = true;
        j.a(getActivity(), this.w, new b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (a.this.isAdded() && !a.this.isDetached()) {
                    Toast.makeText(a.this.getContext(), R.string.thanks_for_interest, 0).show();
                    boolean unused = a.this.z = false;
                    a.b(a.this, H5AppHandler.CHECK_VALUE);
                    a.this.a();
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (a.this.isAdded() && !a.this.isDetached()) {
                    boolean unused = a.this.z = false;
                    boolean unused2 = a.this.A = false;
                }
            }
        }, "interested", H5AppHandler.CHECK_VALUE);
    }

    private void d() {
        int i2 = this.Z;
        if (i2 != 1) {
            j.a(getActivity(), this.w, new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean z = false;
                        Toast.makeText(a.this.getContext(), R.string.thanks_for_interest, 0).show();
                        boolean unused = a.this.z = false;
                        a aVar = a.this;
                        if (aVar.Z != 2) {
                            z = true;
                        }
                        a.a(aVar, "liked", true, z);
                        a.this.a();
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean unused = a.this.z = false;
                    }
                }
            }, "sentiment", "liked");
        } else if (i2 == 1) {
            j.a((Activity) getActivity(), this.w, (b) new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean unused = a.this.z = false;
                        a.a(a.this, "liked", false, true);
                        a.this.a();
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (a.this.isAdded() && !a.this.isDetached()) {
                        boolean unused = a.this.z = false;
                    }
                }
            }, "sentiment");
        }
    }

    private void a(int i2) {
        startActivityForResult(new Intent(getContext(), net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), i2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 107) {
            c();
        } else if (i2 == 101) {
            d();
        } else if (i2 == 102) {
            b();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRMovieVideoViewCountResponse cJRMovieVideoViewCountResponse;
        if (isAdded() && !isDetached()) {
            this.I.setVisibility(8);
            i.d dVar = this.E;
            if (dVar != null) {
                dVar.b();
            }
            if (iJRPaytmDataModel instanceof CJRMoviesContentCastCrewModel) {
                this.B = (CJRMoviesContentCastCrewModel) iJRPaytmDataModel;
                this.f75247i.setVisibility(8);
                final CJRMoviesContentCastCrewModel cJRMoviesContentCastCrewModel = this.B;
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.T);
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.v);
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Content Tab Clicked");
                    String str = "";
                    if (this.x != null) {
                        str = str + this.x + "|" + this.w;
                    }
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str);
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
                    if (com.paytm.utility.b.r(getContext())) {
                        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(getContext()));
                    }
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, getContext());
                } catch (Exception unused) {
                }
                if (cJRMoviesContentCastCrewModel != null) {
                    this.f75239a.setText(cJRMoviesContentCastCrewModel.getmTitle());
                    b(cJRMoviesContentCastCrewModel.getmSummary());
                    if (!TextUtils.isEmpty(cJRMoviesContentCastCrewModel.getmTitle())) {
                        this.y.setVisibility(0);
                    }
                    if (cJRMoviesContentCastCrewModel.getGalleryList() != null && !cJRMoviesContentCastCrewModel.getGalleryList().isEmpty()) {
                        this.s.setText(cJRMoviesContentCastCrewModel.getPostersHeading());
                        this.m.setVisibility(0);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        linearLayoutManager.setOrientation(0);
                        this.p.setLayoutManager(linearLayoutManager);
                        this.p.setHasFixedSize(true);
                        u uVar = new u(getContext(), cJRMoviesContentCastCrewModel.getGalleryList());
                        uVar.f74777c = this.x;
                        uVar.f74778d = "/movies";
                        this.p.setAdapter(uVar);
                        a(this.p);
                    }
                    if (cJRMoviesContentCastCrewModel.getVideoList() != null && !cJRMoviesContentCastCrewModel.getVideoList().isEmpty()) {
                        this.t.setText(cJRMoviesContentCastCrewModel.getVideoHeading());
                        this.n.setVisibility(0);
                        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
                        linearLayoutManager2.setOrientation(0);
                        this.q.setLayoutManager(linearLayoutManager2);
                        this.q.setHasFixedSize(true);
                        w wVar = new w(getContext(), this, cJRMoviesContentCastCrewModel.getVideoList());
                        wVar.f74796c = net.one97.paytm.o2o.movies.common.b.b.T;
                        this.q.setAdapter(wVar);
                        a(this.q);
                    }
                    if (cJRMoviesContentCastCrewModel.getEntertainmentModels() != null && !cJRMoviesContentCastCrewModel.getEntertainmentModels().isEmpty()) {
                        this.u.setText(cJRMoviesContentCastCrewModel.getBlogHeading());
                        this.r.setVisibility(0);
                        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext());
                        linearLayoutManager3.setOrientation(0);
                        this.v.setLayoutManager(linearLayoutManager3);
                        this.v.setHasFixedSize(true);
                        this.v.setAdapter(new o(this.J, cJRMoviesContentCastCrewModel.getEntertainmentModels(), this));
                        a(this.v);
                    }
                    if (!(cJRMoviesContentCastCrewModel.getmCjrMoviesCastList() == null || cJRMoviesContentCastCrewModel.getmCjrMoviesCastList().getCastCrewList() == null || cJRMoviesContentCastCrewModel.getmCjrMoviesCastList().getCastCrewList().size() <= 0)) {
                        this.l.setVisibility(0);
                        this.f75246h.setText(cJRMoviesContentCastCrewModel.getmCjrMoviesCastList().getTitle());
                        x xVar = new x(getContext(), cJRMoviesContentCastCrewModel.getmCjrMoviesCastList().getCastCrewList(), cJRMoviesContentCastCrewModel.isActorClickable());
                        xVar.f74807d = this.x;
                        this.o.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                        this.o.setAdapter(xVar);
                        xVar.notifyDataSetChanged();
                        a(this.o);
                    }
                    this.f75247i.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (a.this.k.getText().equals(a.this.getString(R.string.read_more))) {
                                a.j(a.this);
                                a.this.k.setText(a.this.getString(R.string.read_less));
                                a.this.j.setImageResource(net.one97.paytm.common.assets.R.drawable.blue_up_arrow);
                                a.this.b(cJRMoviesContentCastCrewModel.getmSummary());
                                return;
                            }
                            a.this.b(cJRMoviesContentCastCrewModel.getmSummary());
                            a.l(a.this);
                            a.this.k.setText(a.this.getString(R.string.read_more));
                            a.this.j.setImageResource(net.one97.paytm.common.assets.R.drawable.blue_down_arrow);
                        }
                    });
                }
                if (this.P != null) {
                    a();
                }
            } else if ((iJRPaytmDataModel instanceof CJRMovieVideoViewCountResponse) && (cJRMovieVideoViewCountResponse = (CJRMovieVideoViewCountResponse) iJRPaytmDataModel) != null) {
                String status = cJRMovieVideoViewCountResponse.getStatus();
                if (com.paytm.utility.b.v) {
                    q.b(status);
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isAdded() && !isDetached()) {
            i.d dVar = this.E;
            if (dVar != null) {
                dVar.b();
            }
            if (networkCustomError != null) {
                String message = networkCustomError.getMessage();
                if (message != null && message.equalsIgnoreCase("503")) {
                    this.D.c();
                } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    this.D.d();
                    if (!networkCustomError.getFullUrl().equalsIgnoreCase(this.C)) {
                        com.paytm.utility.b.d(getContext(), networkCustomError.getUrl(), message);
                    }
                } else if (!TextUtils.isEmpty(this.G)) {
                    getActivity().finish();
                } else {
                    net.one97.paytm.o2o.movies.d.b bVar = this.D;
                    if (bVar != null) {
                        bVar.a(getResources().getString(R.string.no_movies_found_at_loc));
                    }
                    String str = this.F;
                    if (str != null) {
                        str.equalsIgnoreCase("movie");
                        this.D.a(getResources().getString(R.string.no_movies_found_at_loc));
                    }
                    if (!networkCustomError.getFullUrl().equalsIgnoreCase(this.C)) {
                        this.D.a(getResources().getString(R.string.no_movies_found_at_loc));
                    }
                }
            }
        }
    }

    private LikeDisLikeInfoItem e() {
        CJRMetricInfoDataItem cJRMetricInfoDataItem;
        CJRGetMetricInfoResponse cJRGetMetricInfoResponse = this.P;
        if (!(cJRGetMetricInfoResponse == null || cJRGetMetricInfoResponse.getData() == null || this.P.getMetaData() == null || this.P.getMetaData().getMovieMappings() == null)) {
            Iterator<String> it2 = this.P.getMetaData().getMovieMappings().keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    cJRMetricInfoDataItem = null;
                    break;
                }
                String next = it2.next();
                if (next != null && next.equalsIgnoreCase(this.w)) {
                    cJRMetricInfoDataItem = this.P.getData().get(this.P.getMetaData().getMovieMappings().get(next));
                    break;
                }
            }
            if (cJRMetricInfoDataItem != null) {
                return cJRMetricInfoDataItem.getMetricData();
            }
        }
        return null;
    }

    static /* synthetic */ void b(a aVar) {
        try {
            HashMap<String, String> n2 = com.paytm.utility.b.n();
            n2.put("ClientId", "paytm");
            n2.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(aVar.J));
            c.a();
            String d2 = com.paytm.utility.b.d(aVar.getContext(), c.a("URLMoviesFetchDetails", (String) null));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("movie_id", aVar.w);
            jSONObject.put("movie_name", aVar.x);
            if (com.paytm.utility.b.r(aVar.getContext())) {
                jSONObject.put("customer_id", com.paytm.utility.b.n(aVar.getContext()));
            }
            String jSONObject2 = jSONObject.toString();
            if (com.paytm.utility.b.c(aVar.getContext())) {
                aVar.I.setVisibility(0);
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                cVar.f42877a = aVar.J;
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.POST;
                cVar.f42880d = d2;
                cVar.f42881e = null;
                cVar.f42882f = n2;
                cVar.f42883g = null;
                cVar.f42884h = jSONObject2;
                cVar.f42885i = new CJRMoviesContentCastCrewModel();
                cVar.j = aVar;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("FJRAboutMovieFragment");
                com.paytm.network.a l2 = cVar.l();
                l2.f42859c = false;
                l2.a();
                return;
            }
            com.paytm.utility.b.b(aVar.getContext(), aVar.getResources().getString(net.one97.paytm.common.assets.R.string.no_connection), aVar.getResources().getString(net.one97.paytm.common.assets.R.string.no_internet));
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void c(a aVar) {
        try {
            HashMap<String, String> n2 = com.paytm.utility.b.n();
            n2.put("ClientId", "paytm");
            c.a();
            StringBuilder sb = new StringBuilder(com.paytm.utility.b.s(aVar.getContext(), c.f()));
            sb.append("&movieIds=");
            sb.append(aVar.w);
            sb.append("&metricType=interested,sentiment");
            if (com.paytm.utility.b.r((Context) aVar.getActivity())) {
                sb.append("&custId=" + com.paytm.utility.b.n((Context) aVar.getActivity()));
            }
            if (com.paytm.utility.b.c(aVar.getContext())) {
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                cVar.f42877a = aVar.J;
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.GET;
                cVar.f42880d = sb.toString();
                cVar.f42882f = n2;
                cVar.f42883g = null;
                cVar.f42885i = new CJRGetMetricInfoResponse();
                cVar.j = new b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (a.this.isAdded() && !a.this.isDetached() && (iJRPaytmDataModel instanceof CJRGetMetricInfoResponse)) {
                            CJRGetMetricInfoResponse unused = a.this.P = (CJRGetMetricInfoResponse) iJRPaytmDataModel;
                            if (a.this.B != null) {
                                a.this.a();
                            }
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (a.this.isAdded() && !a.this.isDetached()) {
                            a.this.L.setVisibility(8);
                            a.this.M.setVisibility(8);
                            a.this.K.setVisibility(8);
                            a.this.N.setVisibility(8);
                        }
                    }
                };
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("FJRAboutMovieFragment");
                com.paytm.network.a l2 = cVar.l();
                l2.f42859c = false;
                l2.a();
                return;
            }
            com.paytm.utility.b.b(aVar.getContext(), aVar.getResources().getString(net.one97.paytm.common.assets.R.string.no_connection), aVar.getResources().getString(net.one97.paytm.common.assets.R.string.no_internet));
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void j(a aVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.Q);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.u);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "read-more_clicked");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, aVar.x);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r(aVar.J)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(aVar.J));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aVar.J);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void l(a aVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.Q);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.u);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "read_less_clicked");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, aVar.x);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r(aVar.J)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(aVar.J));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aVar.J);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(a aVar, String str, boolean z2, boolean z3) {
        SentimentInterestedItem sentiment;
        LikeDisLikeInfoItem e2 = aVar.e();
        if (e2 != null && (sentiment = e2.getSentiment()) != null) {
            HashMap<String, Long> countInfo = sentiment.getCountInfo();
            Long l2 = countInfo.get(str);
            if (l2 != null && z3) {
                countInfo.put(str, Long.valueOf(l2.longValue() + ((long) (z2 ? 1 : -1))));
            }
            if (!z2) {
                str = "";
            }
            sentiment.setUserInput(str);
        }
    }

    static /* synthetic */ void b(a aVar, String str) {
        SentimentInterestedItem interested;
        LikeDisLikeInfoItem e2 = aVar.e();
        if (e2 != null && (interested = e2.getInterested()) != null) {
            HashMap<String, Long> countInfo = interested.getCountInfo();
            Long l2 = countInfo.get(str);
            if (l2 != null) {
                countInfo.put(str, Long.valueOf(l2.longValue() + 1));
            }
            interested.setUserInput(str);
        }
    }
}
