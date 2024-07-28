package com.travel.train.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.activity.AJREmbedWebView;
import com.travel.train.activity.AJRTrainFileTDRActivity;
import com.travel.train.activity.AJRTrainOrderSummaryNew;
import com.travel.train.activity.AJRTrainResendTicket;
import com.travel.train.activity.AJRTrainResendTicketSuccess;
import com.travel.train.activity.AJRTrainTicketStatusGuide;
import com.travel.train.activity.AJRTrainViewRoute;
import com.travel.train.b.al;
import com.travel.train.helper.e;
import com.travel.train.helper.g;
import com.travel.train.helper.h;
import com.travel.train.i.ab;
import com.travel.train.i.f;
import com.travel.train.i.k;
import com.travel.train.j.f;
import com.travel.train.j.o;
import com.travel.train.model.CJRNPSCaptureDataModel;
import com.travel.train.model.trainticket.CJRTrainActionResponse;
import com.travel.train.model.trainticket.CJRTrainFavouriteResponse;
import com.travel.train.model.trainticket.CJRTrainIsFavourite;
import com.travel.train.model.trainticket.CJRTrainOrderPaxInfo;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryResponse;
import com.travel.train.model.trainticket.CJRTrainPromoInfoStatusAction;
import com.travel.train.model.trainticket.CJRTrainPromotionalBanner;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import com.travel.train.model.trainticket.CJRTrainTimerStatusBar;
import com.travel.train.viewholder.ah;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.cashback.posttxn.a;
import net.one97.paytm.cashback.posttxn.c;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.trainticket.CJRTrainOrderSummaryContactUs;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class w extends am implements ab, f, k, m {
    private static String j = "NPS_TAG";
    private g A;
    private com.travel.train.j.f B;
    /* access modifiers changed from: private */
    public CountDownTimer C;
    private v D;
    /* access modifiers changed from: private */
    public e E;
    private boolean F = false;
    private ah G;
    private boolean H = false;
    private boolean I;
    /* access modifiers changed from: private */
    public String J = "FJRTrainOrderSummary";

    /* renamed from: a  reason: collision with root package name */
    public boolean f27189a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJRItem f27190b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f27191c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f27192d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f27193e;

    /* renamed from: f  reason: collision with root package name */
    private int f27194f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, Object> f27195g = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f27196h;

    /* renamed from: i  reason: collision with root package name */
    private int f27197i = 1000;
    private String k = StringSet.order;
    /* access modifiers changed from: private */
    public float l;
    private Handler m;
    private RecyclerView n;
    /* access modifiers changed from: private */
    public TextView o;
    /* access modifiers changed from: private */
    public RelativeLayout p;
    private FrameLayout q;
    private RelativeLayout r;
    private TextView s;
    private TextView t;
    private LinearLayout u;
    /* access modifiers changed from: private */
    public View v;
    private CJRNPSCaptureDataModel w;
    private al x;
    /* access modifiers changed from: private */
    public CJRTrainOrderSummaryResponse y;
    /* access modifiers changed from: private */
    public h z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void h() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pre_t_train_order_summary_fragment, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        View view = getView();
        this.n = (RecyclerView) view.findViewById(R.id.recyclerView);
        this.p = (RelativeLayout) view.findViewById(R.id.timer_lyt);
        this.o = (TextView) view.findViewById(R.id.count_down_text);
        this.v = view.findViewById(R.id.timer_bg_view);
        this.f27196h = view.getContext().getString(R.string.train_countdown_timer_count);
        this.t = (TextView) view.findViewById(R.id.description);
        this.r = (RelativeLayout) view.findViewById(R.id.tip_info_layout);
        this.s = (TextView) view.findViewById(R.id.tip_info_text);
        this.u = (LinearLayout) view.findViewById(R.id.tip_info_close_btn);
        this.u.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                w.this.b(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                w.this.a(view);
            }
        });
        this.q = (FrameLayout) view.findViewById(R.id.floating_nav_bar);
        this.E = new e(getActivity(), this.q, $$Lambda$w$0xZFHTjZMUILtADKklXi3p5is.INSTANCE);
        b();
    }

    public final void a() {
        if (getArguments() != null) {
            this.f27191c = getArguments().getString(UpiConstants.FROM);
            this.f27192d = getArguments().getString("order_id");
            if (getArguments().containsKey("extra_home_data")) {
                this.f27190b = (CJRItem) getArguments().getSerializable("extra_home_data");
                a(this.f27190b);
                this.f27193e = this.f27190b.getURL();
                this.f27191c = "Deep Linking";
            }
        }
    }

    public final void b() {
        if (this.z == null) {
            this.z = new h(getActivity(), this);
        }
        if (this.A == null) {
            this.A = new g(getActivity(), this);
        }
        if (this.f27190b != null) {
            this.z.b(this.f27193e, this.f27191c);
        } else {
            this.z.a(this.f27192d, this.f27191c);
        }
        this.B = new com.travel.train.j.f(getActivity(), this.z, this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.r.setVisibility(8);
        if (getActivity() != null && !isDetached() && this.r.getVisibility() == 8) {
            View findViewById = ((AJRTrainOrderSummaryNew) getActivity()).findViewById(R.id.toolbar_info_icon);
            ResourceUtils.loadTrainImagesFromCDN((ImageView) findViewById.findViewById(R.id.toolbar_info_icon), "info_icon.png", false, true, n.a.V1);
            findViewById.findViewById(R.id.toolbar_info_icon).setVisibility(0);
            findViewById.findViewById(R.id.toolbar_info_icon).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    w.this.g();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        g();
    }

    private void a(CJRItem cJRItem) {
        if (cJRItem != null) {
            if (!TextUtils.isEmpty(cJRItem.getURL())) {
                String queryParameter = Uri.parse(cJRItem.getURL()).buildUpon().build().getQueryParameter("url");
                if (!TextUtils.isEmpty(queryParameter)) {
                    cJRItem.setUrl(queryParameter);
                }
            } else if (cJRItem instanceof CJRHomePageItem) {
                String deeplink = ((CJRHomePageItem) cJRItem).getDeeplink();
                if (!TextUtils.isEmpty(deeplink)) {
                    cJRItem.setUrl(deeplink);
                }
            }
            this.f27195g.put("search_type", cJRItem.getSearchType());
            this.f27195g.put("search_category", cJRItem.getSearchCategory());
            this.f27195g.put("search_term", cJRItem.getSearchTerm());
            this.f27195g.put("search_result_type", cJRItem.getSearchResultType());
        }
    }

    private static ArrayList<String> a(CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse) {
        if (cJRTrainOrderSummaryResponse == null) {
            return null;
        }
        try {
            if (cJRTrainOrderSummaryResponse.getBody().getContactUsDetails() == null || cJRTrainOrderSummaryResponse.getBody().getContactUsDetails().size() == 0) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<CJRTrainOrderSummaryContactUs> it2 = cJRTrainOrderSummaryResponse.getBody().getContactUsDetails().iterator();
            while (it2.hasNext()) {
                arrayList.add(String.valueOf(it2.next().getId()));
            }
            return arrayList;
        } catch (Exception e2) {
            if (b.v) {
                q.c(e2.getMessage());
            }
            return null;
        }
    }

    private static int a(CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse, String str) {
        ArrayList<CJRTrainOrderPaxInfo> paxInfo;
        if (cJRTrainOrderSummaryResponse == null) {
            return 0;
        }
        try {
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("Payment") && (paxInfo = cJRTrainOrderSummaryResponse.getBody().getPaxInfo()) != null && paxInfo.size() > 0) {
                return paxInfo.get(0).getItemStatus().getStatus();
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        return 0;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse;
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRTrainOrderSummaryResponse) {
                this.y = (CJRTrainOrderSummaryResponse) iJRPaytmDataModel;
                if ((getActivity() instanceof AJRTrainOrderSummaryNew) && (cJRTrainOrderSummaryResponse = this.y) != null && cJRTrainOrderSummaryResponse.getBody() != null && !TextUtils.isEmpty(this.y.getBody().getBookingId())) {
                    ((AJRTrainOrderSummaryNew) getActivity()).setActionBarTitle(this.y.getBody().getBookingId());
                }
                if (getActivity() != null && !isDetached()) {
                    if (this.y.getBody() == null || !this.y.getBody().isTipEnabled() || TextUtils.isEmpty(this.y.getBody().getTipText())) {
                        this.r.setVisibility(8);
                    } else {
                        this.r.setVisibility(0);
                        SpannableString spannableString = new SpannableString(this.y.getBody().getTipText());
                        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_33b5e5)), 0, 10, 33);
                        this.s.setText(spannableString);
                    }
                    CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse2 = this.y;
                    CJRTrainTimerStatusBar statusBar = (cJRTrainOrderSummaryResponse2.getBody() == null || cJRTrainOrderSummaryResponse2.getBody().getStatusBar() == null || TextUtils.isEmpty(cJRTrainOrderSummaryResponse2.getBody().getStatusBar().getRemainingTime()) || cJRTrainOrderSummaryResponse2.getBody().getStatusBar().getRemainingTime().equalsIgnoreCase("0")) ? null : cJRTrainOrderSummaryResponse2.getBody().getStatusBar();
                    if (statusBar == null) {
                        CountDownTimer countDownTimer = this.C;
                        if (countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        this.p.setVisibility(8);
                    } else if (!TextUtils.isEmpty(statusBar.getRemainingTime()) || o.b(statusBar.getRemainingTime())) {
                        CountDownTimer countDownTimer2 = this.C;
                        if (countDownTimer2 != null) {
                            countDownTimer2.cancel();
                        }
                        this.p.setVisibility(0);
                        if (statusBar != null) {
                            this.t.setText(statusBar.getDescription());
                        }
                        final int parseInt = Integer.parseInt(statusBar.getTotalTime()) * 1000;
                        this.C = new CountDownTimer((long) (Integer.parseInt(statusBar.getRemainingTime()) * 1000), (long) this.f27197i) {
                            public final void onTick(long j) {
                                try {
                                    long minutes = TimeUnit.MILLISECONDS.toMinutes(j);
                                    long seconds = TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j));
                                    if (TimeUnit.MILLISECONDS.toSeconds(j) <= 5) {
                                        w.this.o.setTextColor(androidx.core.content.b.c(w.this.getActivity(), R.color.color_00b9f5));
                                        w.this.v.setBackgroundColor(androidx.core.content.b.c(w.this.getActivity(), R.color.color_1900b9f5));
                                    }
                                    w.this.o.setText(String.format(w.this.f27196h, new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}));
                                    ViewGroup.LayoutParams layoutParams = w.this.v.getLayoutParams();
                                    float unused = w.this.l = (float) ((j * ((long) b.a((Activity) w.this.getActivity()))) / ((long) parseInt));
                                    layoutParams.width = (int) w.this.l;
                                    w.this.v.setLayoutParams(layoutParams);
                                    new StringBuilder("incremental_value").append(w.this.l);
                                } catch (Exception e2) {
                                    String unused2 = w.this.J;
                                    q.c(e2.getMessage());
                                }
                            }

                            public final void onFinish() {
                                if (w.this.C != null) {
                                    w.this.C.cancel();
                                }
                                w.this.p.setVisibility(8);
                            }
                        };
                        this.C.start();
                    }
                    this.x = new al(getActivity(), h.a(this.y), this, this);
                    final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
                    this.n.setLayoutManager(linearLayoutManager);
                    this.n.setAdapter(this.x);
                    this.n.addOnScrollListener(new RecyclerView.l() {
                        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                            super.onScrollStateChanged(recyclerView, i2);
                        }

                        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                            ViewPropertyAnimator animate;
                            ViewPropertyAnimator translationY;
                            ViewPropertyAnimator interpolator;
                            super.onScrolled(recyclerView, i2, i3);
                            if (i3 > 0) {
                                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() != 0) {
                                    w.this.E.a();
                                }
                            } else if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 && (animate = w.this.E.f27284c.animate()) != null && (translationY = animate.translationY(0.0f)) != null && (interpolator = translationY.setInterpolator(new DecelerateInterpolator(2.0f))) != null) {
                                interpolator.start();
                            }
                        }
                    });
                    if (getActivity() != null && !getActivity().isFinishing() && !this.H) {
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                if (w.this.y != null) {
                                    w.d(w.this);
                                }
                            }
                        }, 1500);
                    }
                    CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse3 = this.y;
                    if (cJRTrainOrderSummaryResponse3.getBody() != null && cJRTrainOrderSummaryResponse3.getMeta() != null && this.z.b(cJRTrainOrderSummaryResponse3) && !this.I) {
                        net.one97.paytm.cashback.posttxn.e a2 = c.a();
                        if (a2 != null && (getActivity() instanceof AppCompatActivity)) {
                            a2.a((AppCompatActivity) getActivity());
                            f.a aVar = new f.a();
                            aVar.f49546b = cJRTrainOrderSummaryResponse3.getBody().getBookingId();
                            aVar.f49550f = "72";
                            aVar.f49551g = "82653";
                            aVar.f49549e = this.k;
                            a2.a(aVar.a(), (a) new a() {
                                public final void onAnimationEnd(String str) {
                                    if (w.this.E != null && (w.this.E.f27282a instanceof IStaticWidget)) {
                                        IStaticWidget iStaticWidget = (IStaticWidget) w.this.E.f27282a;
                                        if (TextUtils.isEmpty(str)) {
                                            str = "";
                                        }
                                        iStaticWidget.AnimateView(str);
                                    }
                                }

                                public final Point getFloatingWidgetPos(String str) {
                                    if (w.this.E == null || !(w.this.E.f27282a instanceof IStaticWidget)) {
                                        return new Point();
                                    }
                                    IStaticWidget iStaticWidget = (IStaticWidget) w.this.E.f27282a;
                                    if (TextUtils.isEmpty(str)) {
                                        str = "";
                                    }
                                    return iStaticWidget.getViewPoint(str);
                                }
                            });
                        }
                        this.I = true;
                    }
                }
                f();
            } else if (iJRPaytmDataModel instanceof CJRTrainFavouriteResponse) {
                ah ahVar = this.G;
                if (ahVar != null) {
                    this.f27189a = true;
                    if (ahVar.f27786g != null) {
                        if (ahVar.f27787h) {
                            ahVar.f27780a.setText(ahVar.f27786g.getDescAlias());
                            ahVar.f27787h = false;
                        } else {
                            ahVar.f27780a.setText(ahVar.f27786g.getDescription());
                            ahVar.f27787h = true;
                        }
                        if (ahVar.f27786g.getValue().booleanValue()) {
                            ahVar.f27781b.setVisibility(8);
                            ahVar.f27788i.setVisibility(0);
                            ahVar.a();
                            return;
                        }
                        ahVar.f27788i.setProgress(0.0f);
                        ResourceUtils.loadTrainImagesFromCDN(ahVar.f27781b, "fav_unselect.png", false, false, n.a.V1);
                        ahVar.f27781b.setVisibility(0);
                        ahVar.f27788i.setVisibility(8);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRTrainActionResponse) {
                CJRTrainActionResponse cJRTrainActionResponse = (CJRTrainActionResponse) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(cJRTrainActionResponse.getMessage())) {
                    b.b((Context) getActivity(), "", cJRTrainActionResponse.getError());
                } else if (cJRTrainActionResponse.getActions() != null) {
                    ArrayList<CJRTrainOrderSummaryAction> actions = cJRTrainActionResponse.getActions();
                    if (actions.size() > 0) {
                        CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction = actions.get(0);
                        if (cJRTrainOrderSummaryAction.getUiControl().equalsIgnoreCase("browser") && cJRTrainOrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction.getUrlParams().getUrl())) {
                            com.travel.train.j.f fVar = this.B;
                            fVar.f27535c = this.f27192d;
                            String str = com.travel.train.j.f.f27532i;
                            q.d("handle response - " + cJRTrainOrderSummaryAction.getUrlParams().getUrl());
                            String url = cJRTrainOrderSummaryAction.getUrlParams().getUrl();
                            String title = cJRTrainActionResponse.getTitle();
                            String str2 = com.travel.train.j.f.f27532i;
                            q.d("new FileLoader - with title - ".concat(String.valueOf(title)));
                            new f.a(url, title).execute(new Void[0]);
                        }
                    }
                } else if (!TextUtils.isEmpty(cJRTrainActionResponse.getError())) {
                    b.b((Context) getActivity(), cJRTrainActionResponse.getMessage(), cJRTrainActionResponse.getError());
                } else {
                    removeProgressDialog();
                }
            }
        }
    }

    public final void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, com.paytm.network.a aVar) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            removeProgressDialog();
            this.E.a();
            if (i2 == 304) {
                f();
                return;
            }
            if (i2 == 202 && (iJRPaytmDataModel instanceof CJRTrainActionResponse)) {
                CJRTrainActionResponse cJRTrainActionResponse = new CJRTrainActionResponse();
                if (networkCustomError.networkResponse != null) {
                    NetworkResponse networkResponse = networkCustomError.networkResponse;
                    if (networkResponse.data != null) {
                        try {
                            cJRTrainActionResponse = (CJRTrainActionResponse) new com.google.gsonhtcfix.f().a(new String(networkResponse.data), cJRTrainActionResponse.getClass());
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                    }
                }
                if (cJRTrainActionResponse != null) {
                    a((IJRPaytmDataModel) cJRTrainActionResponse);
                    return;
                }
            }
            try {
                com.travel.train.model.a aVar2 = new com.travel.train.model.a();
                if (networkCustomError.networkResponse != null) {
                    NetworkResponse networkResponse2 = networkCustomError.networkResponse;
                    if (networkResponse2.data != null) {
                        try {
                            aVar2 = (com.travel.train.model.a) new com.google.gsonhtcfix.f().a(new String(networkResponse2.data), aVar2.getClass());
                        } catch (Exception e3) {
                            e3.getMessage();
                        }
                    }
                }
                if (i2 != 401) {
                    if (i2 != 410) {
                        if (aVar2 != null && aVar2.getStatus() != null && aVar2.getStatus().getMessage() != null && !TextUtils.isEmpty(aVar2.getStatus().getMessage().f27692a) && !TextUtils.isEmpty(aVar2.getStatus().getMessage().f27693b)) {
                            b.b((Context) getActivity(), aVar2.getStatus().getMessage().f27692a, aVar2.getStatus().getMessage().f27693b);
                            return;
                        } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                            if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                                com.travel.train.b.a();
                                if (!com.travel.train.b.b().a((Context) getActivity(), (Exception) networkCustomError, "error.trains@paytm.com")) {
                                    if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                        b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                        return;
                                    }
                                    String string = getResources().getString(R.string.trains_message_error_data_display);
                                    b.b((Context) getActivity(), getResources().getString(R.string.error_data_display), string);
                                    return;
                                }
                            }
                            if (aVar != null) {
                                showNetworkDialog(aVar, getString(R.string.network_error_heading), getString(R.string.network_error_message_train));
                                return;
                            }
                            b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train));
                            return;
                        } else {
                            b.b((Context) getActivity(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                            return;
                        }
                    }
                }
                showSessionTimeoutAlert(networkCustomError);
            } catch (Exception unused) {
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            return;
        }
        if (i2 == 3) {
            if (com.travel.train.j.e.a((Context) getActivity())) {
                b();
            }
        } else if (i2 == 45) {
            if (com.travel.train.j.e.a((Context) getActivity())) {
                b();
            }
        } else if (i2 == this.f27194f) {
            int intExtra = intent.getIntExtra(Payload.RESPONSE, 10);
            v vVar = this.D;
            if (vVar != null && vVar.isVisible()) {
                this.D.dismiss();
            }
            h hVar = this.z;
            CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse = this.y;
            CJRNPSCaptureDataModel cJRNPSCaptureDataModel = this.w;
            if (cJRTrainOrderSummaryResponse != null && cJRNPSCaptureDataModel.getItemIds() != null) {
                String bookingId = cJRTrainOrderSummaryResponse.getBody().getBookingId();
                if (b.c(hVar.f27305a)) {
                    hVar.f27306b.d();
                    com.travel.train.b.a();
                    String P = com.travel.train.b.b().P();
                    if (URLUtil.isValidUrl(P)) {
                        String s2 = b.s(hVar.f27305a, P);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(Payload.RESPONSE, intExtra);
                            if (!TextUtils.isEmpty(bookingId)) {
                                jSONObject.put("orderid", bookingId);
                            }
                            jSONObject.put("category", "npsFeedback-train");
                            jSONObject.put("items", new JSONArray(cJRNPSCaptureDataModel.getItemIds()));
                            jSONObject.put("utm_source", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                        } catch (JSONException e2) {
                            q.c(e2.getMessage());
                        }
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = hVar.f27305a;
                        bVar.f42878b = a.c.TRAIN;
                        bVar.n = a.b.SILENT;
                        bVar.o = com.travel.train.j.g.k;
                        bVar.f42879c = a.C0715a.POST;
                        bVar.f42880d = s2;
                        bVar.f42882f = com.travel.train.j.n.c(hVar.f27305a);
                        bVar.f42884h = jSONObject.toString();
                        bVar.f42885i = new CJRNpsTrackingResponse();
                        bVar.j = hVar;
                        com.paytm.network.a l2 = bVar.l();
                        l2.f42859c = false;
                        l2.a();
                    }
                }
            }
        } else if (i2 == 569) {
            Intent intent2 = new Intent(getActivity(), AJRTrainResendTicketSuccess.class);
            intent2.putExtra("intent_extra_train_resend_tickets_to", (com.travel.train.model.f) intent.getSerializableExtra("intent_extra_train_resend_tickets_to"));
            startActivity(intent2);
        }
    }

    public final void c() {
        f();
    }

    private void f() {
        CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse = this.y;
        if (cJRTrainOrderSummaryResponse != null && cJRTrainOrderSummaryResponse.getMeta() != null && !TextUtils.isEmpty(this.y.getMeta().getRefreshInterval()) && o.b(this.y.getMeta().getRefreshInterval())) {
            try {
                int parseInt = Integer.parseInt(this.y.getMeta().getRefreshInterval()) * 1000;
                if (this.m == null) {
                    this.m = new Handler();
                }
                this.m.postDelayed(new Runnable() {
                    public final void run() {
                        if (w.this.z == null) {
                            return;
                        }
                        if (w.this.f27190b != null) {
                            w.this.z.b(w.this.f27193e, w.this.f27191c);
                        } else {
                            w.this.z.a(w.this.f27192d, w.this.f27191c);
                        }
                    }
                }, (long) parseInt);
            } catch (NumberFormatException e2) {
                q.c(e2.getMessage());
            }
        }
    }

    public final void d() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            showProgressDialog(getActivity(), getString(R.string.please_wait_progress_msg));
        }
    }

    public final void e() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            removeProgressDialog();
        }
    }

    public final void a(CJRNpsTrackingResponse cJRNpsTrackingResponse) {
        if (getActivity() != null && !getActivity().isFinishing() && cJRNpsTrackingResponse != null && cJRNpsTrackingResponse.getMessage() != null) {
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.setContentView(R.layout.pre_t_train_sellar_rating_custom_toast);
            ((TextView) dialog.findViewById(R.id.thanks_msg)).setText(cJRNpsTrackingResponse.getMessage());
            this.H = true;
            dialog.show();
            Window window = dialog.getWindow();
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setBackgroundDrawable((Drawable) null);
            ((RoboButton) dialog.findViewById(R.id.close_dialog)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            final Handler handler = new Handler();
            final AnonymousClass8 r1 = new Runnable() {
                public final void run() {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
            };
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    handler.removeCallbacks(r1);
                }
            });
            handler.postDelayed(r1, 2000);
        }
    }

    public final void a(IJRDataModel iJRDataModel, com.travel.train.i.ah ahVar) {
        CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse;
        String str = "";
        switch (ahVar) {
            case ORDER_STATUS_TEXT_ACTION:
                CJRTrainPromoInfoStatusAction cJRTrainPromoInfoStatusAction = (CJRTrainPromoInfoStatusAction) iJRDataModel;
                if (cJRTrainPromoInfoStatusAction != null && !TextUtils.isEmpty(cJRTrainPromoInfoStatusAction.getLabel()) && cJRTrainPromoInfoStatusAction.getLabel().equalsIgnoreCase("Book Return Ticket")) {
                    a(str, d.dS, "/trains/order-summary", str);
                }
                if (cJRTrainPromoInfoStatusAction.getDeeplink().booleanValue()) {
                    if (!TextUtils.isEmpty(cJRTrainPromoInfoStatusAction.getUrl())) {
                        a(cJRTrainPromoInfoStatusAction.getUrl());
                    }
                } else if (!TextUtils.isEmpty(cJRTrainPromoInfoStatusAction.getUrl())) {
                    String url = cJRTrainPromoInfoStatusAction.getUrl();
                    Intent intent = new Intent(getActivity(), AJREmbedWebView.class);
                    intent.putExtra("url", url);
                    intent.putExtra("fromTrain", true);
                    getActivity().startActivity(intent);
                    getActivity().finish();
                }
                getActivity().finish();
                return;
            case ORDER_ACTION_CLICK:
                a((CJRTrainOrderSummaryAction) iJRDataModel);
                return;
            case FAVOURITE_CLICK:
                CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse2 = this.y;
                if (!(cJRTrainOrderSummaryResponse2 == null || cJRTrainOrderSummaryResponse2.getBody() == null || this.y.getBody().getBookingDetails() == null)) {
                    String source = this.y.getBody().getBookingDetails().getSource();
                    String destinationStationCode = this.y.getBody().getBookingDetails().getDestinationStationCode();
                    a(source + AppConstants.AND_SIGN + destinationStationCode, d.dR, "/trains/order-summary", str);
                }
                CJRTrainIsFavourite cJRTrainIsFavourite = (CJRTrainIsFavourite) iJRDataModel;
                if (cJRTrainIsFavourite != null) {
                    h hVar = this.z;
                    if (!TextUtils.isEmpty(cJRTrainIsFavourite.getUrl())) {
                        Uri.Builder buildUpon = Uri.parse(o.b(hVar.f27305a, b.s(hVar.f27305a, cJRTrainIsFavourite.getUrl()))).buildUpon();
                        if (!TextUtils.isEmpty(cJRTrainIsFavourite.getQueryParam())) {
                            buildUpon.appendQueryParameter(cJRTrainIsFavourite.getQueryParam(), cJRTrainIsFavourite.getValue().booleanValue() ? "true" : "false");
                        }
                        String uri = buildUpon.build().toString();
                        if (b.c(hVar.f27305a)) {
                            hVar.f27306b.d();
                            if (TextUtils.isEmpty(cJRTrainIsFavourite.getMethod()) || !cJRTrainIsFavourite.getMethod().equalsIgnoreCase("Post")) {
                                com.paytm.network.b bVar = new com.paytm.network.b();
                                bVar.f42877a = hVar.f27305a;
                                bVar.f42878b = a.c.TRAIN;
                                bVar.n = a.b.SILENT;
                                bVar.o = com.travel.train.j.g.k;
                                bVar.f42879c = a.C0715a.GET;
                                bVar.f42880d = uri;
                                bVar.f42882f = com.travel.train.j.n.b(hVar.f27305a);
                                bVar.f42885i = new CJRTrainFavouriteResponse();
                                bVar.j = hVar;
                                com.paytm.network.a l2 = bVar.l();
                                l2.f42859c = false;
                                l2.a();
                                return;
                            }
                            com.paytm.network.b bVar2 = new com.paytm.network.b();
                            bVar2.f42877a = hVar.f27305a;
                            bVar2.f42878b = a.c.TRAIN;
                            bVar2.n = a.b.SILENT;
                            bVar2.o = com.travel.train.j.g.k;
                            bVar2.f42879c = a.C0715a.POST;
                            bVar2.f42880d = uri;
                            bVar2.f42882f = com.travel.train.j.n.b(hVar.f27305a);
                            bVar2.f42884h = null;
                            bVar2.f42885i = new CJRTrainFavouriteResponse();
                            bVar2.j = hVar;
                            com.paytm.network.a l3 = bVar2.l();
                            l3.f42859c = false;
                            l3.a();
                            return;
                        }
                        com.paytm.network.b bVar3 = new com.paytm.network.b();
                        bVar3.f42877a = hVar.f27305a;
                        bVar3.f42878b = a.c.TRAIN;
                        bVar3.n = a.b.SILENT;
                        bVar3.o = com.travel.train.j.g.k;
                        bVar3.f42879c = a.C0715a.POST;
                        bVar3.f42880d = uri;
                        bVar3.f42882f = com.travel.train.j.n.b(hVar.f27305a);
                        bVar3.f42884h = null;
                        bVar3.f42885i = new CJRTrainFavouriteResponse();
                        bVar3.j = hVar;
                        com.paytm.network.a l4 = bVar3.l();
                        l4.f42859c = false;
                        hVar.f27306b.e();
                        hVar.f27306b.showNetworkDialog(l4, hVar.f27305a.getString(R.string.no_connection), hVar.f27305a.getString(R.string.no_internet));
                        return;
                    }
                    return;
                }
                return;
            case VIEW_ROUTE:
                CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction = (CJRTrainOrderSummaryAction) iJRDataModel;
                if (cJRTrainOrderSummaryAction != null && cJRTrainOrderSummaryAction.getUrl() != null) {
                    Intent intent2 = new Intent(getActivity(), AJRTrainViewRoute.class);
                    String url2 = cJRTrainOrderSummaryAction.getUrl();
                    CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = new CJRTrainSearchResultsTrain();
                    CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse3 = this.y;
                    if (cJRTrainOrderSummaryResponse3 != null && cJRTrainOrderSummaryResponse3.getBody().getBookingDetails() != null) {
                        cJRTrainSearchResultsTrain.setTrainName(this.y.getBody().getBookingDetails().getTrainName());
                        cJRTrainSearchResultsTrain.setTrainNumber(this.y.getBody().getBookingDetails().getTrainNumber());
                        cJRTrainSearchResultsTrain.setSource(this.y.getBody().getBookingDetails().getSource());
                        cJRTrainSearchResultsTrain.setDestination(this.y.getBody().getBookingDetails().getDestinationStationCode());
                        cJRTrainSearchResultsTrain.setDeparture(this.y.getBody().getBookingDetails().getDepartureDateFull());
                        intent2.putExtra("order_summary_flag", true);
                        intent2.putExtra("train_detail", cJRTrainSearchResultsTrain);
                        intent2.putExtra("order_summary_view_route_url", url2);
                        startActivity(intent2);
                        return;
                    }
                    return;
                }
                return;
            case VIEW_COACH:
                a(iJRDataModel);
                return;
            case CANCEL_TICKET:
                a(this.f27192d, d.dV, "My orders screen", this.f27192d);
                a((CJRTrainOrderSummaryAction) iJRDataModel);
                return;
            case CHANGE_STATION:
                a(iJRDataModel);
                return;
            case INTERNAL_PROMOTION_DEEPLINK_CLICK:
                CJRTrainPromotionalBanner cJRTrainPromotionalBanner = (CJRTrainPromotionalBanner) iJRDataModel;
                if (cJRTrainPromotionalBanner.getDeeplink()) {
                    if (!TextUtils.isEmpty(cJRTrainPromotionalBanner.getRedirectUrl())) {
                        a(cJRTrainPromotionalBanner.getRedirectUrl());
                        return;
                    }
                    return;
                } else if (!TextUtils.isEmpty(cJRTrainPromotionalBanner.getRedirectUrl())) {
                    a(cJRTrainPromotionalBanner.getRedirectUrl(), str);
                    return;
                } else {
                    return;
                }
            case CONTACT_US_CLICK:
                if (iJRDataModel != null) {
                    CJRTrainSummaryItem cJRTrainSummaryItem = (CJRTrainSummaryItem) iJRDataModel;
                    if (cJRTrainSummaryItem.getItem() != null && (cJRTrainOrderSummaryResponse = (CJRTrainOrderSummaryResponse) cJRTrainSummaryItem.getItem()) != null) {
                        g gVar = this.A;
                        gVar.f27290b = cJRTrainOrderSummaryResponse;
                        gVar.a();
                        return;
                    }
                    return;
                }
                return;
            case VIEW_PASSBOOK_CLICK:
                com.travel.train.b.a();
                com.travel.train.b.b().a((Context) getActivity(), getString(R.string.savings_account));
                getActivity().finish();
                return;
            case CP_TnC:
                CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction2 = (CJRTrainOrderSummaryAction) iJRDataModel;
                if (cJRTrainOrderSummaryAction2 != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction2.getmTnc_url())) {
                    String str2 = cJRTrainOrderSummaryAction2.getmTnc_url();
                    if (!TextUtils.isEmpty(cJRTrainOrderSummaryAction2.getLabel())) {
                        str = cJRTrainOrderSummaryAction2.getLabel();
                    }
                    a(str2, str);
                    return;
                }
                return;
            case CST_HANDLING:
                if (iJRDataModel instanceof CJRTrainOrderSummaryContactUs) {
                    show();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (CJRTrainOrderSummaryContactUs) iJRDataModel);
                    bundle.putString("featuretype", "train");
                    com.travel.train.b.a();
                    com.travel.train.b.b().a((Context) getActivity(), bundle, (m) this);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction) {
        if (cJRTrainOrderSummaryAction != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction.getUiControl())) {
            b(cJRTrainOrderSummaryAction);
            if (cJRTrainOrderSummaryAction.getLabel().equalsIgnoreCase("File TDR")) {
                if (cJRTrainOrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction.getUrlParams().getUrl())) {
                    if (cJRTrainOrderSummaryAction.getmType() == null) {
                        a(cJRTrainOrderSummaryAction.getUrlParams().getUrl(), cJRTrainOrderSummaryAction.getLabel());
                    } else if (cJRTrainOrderSummaryAction.getmType().equalsIgnoreCase("file_tdr")) {
                        Intent intent = new Intent(getActivity(), AJRTrainFileTDRActivity.class);
                        intent.putExtra("order_id", this.f27192d);
                        intent.putExtra("intent_extra_train_tdr_url", cJRTrainOrderSummaryAction.getUrlParams().getUrl());
                        startActivity(intent);
                    } else {
                        a(cJRTrainOrderSummaryAction.getUrlParams().getUrl(), cJRTrainOrderSummaryAction.getLabel());
                    }
                }
            } else if (cJRTrainOrderSummaryAction.getmType() != null && cJRTrainOrderSummaryAction.getmType().equalsIgnoreCase("ticket_resend") && cJRTrainOrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction.getUrlParams().getUrl())) {
                Intent intent2 = new Intent(getActivity(), AJRTrainResendTicket.class);
                intent2.putExtra("order_id", this.f27192d);
                intent2.putExtra("intent_extra_train_resend_ticket_data", cJRTrainOrderSummaryAction);
                startActivityForResult(intent2, 569);
            } else if (cJRTrainOrderSummaryAction.getmType() != null && cJRTrainOrderSummaryAction.getmType().equalsIgnoreCase("qr_code") && cJRTrainOrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction.getUrlParams().getUrl())) {
                Bundle bundle = new Bundle();
                bundle.putString("qr_code_url", cJRTrainOrderSummaryAction.getUrlParams().getUrl());
                z.a(bundle).show(getChildFragmentManager(), z.class.getSimpleName());
            } else if (cJRTrainOrderSummaryAction.ismDeepLink()) {
                a(cJRTrainOrderSummaryAction.getUrlParams().getUrl());
            } else if (cJRTrainOrderSummaryAction.getUiControl().equalsIgnoreCase("button")) {
                this.B.a(cJRTrainOrderSummaryAction);
            } else if (cJRTrainOrderSummaryAction.getUiControl().equalsIgnoreCase("browser") && cJRTrainOrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction.getUrlParams().getUrl())) {
                a(cJRTrainOrderSummaryAction.getUrlParams().getUrl(), cJRTrainOrderSummaryAction.getLabel());
            }
        }
    }

    private void b(CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction) {
        if (cJRTrainOrderSummaryAction.getLabel().contains("TDR")) {
            if (!TextUtils.isEmpty(this.f27192d)) {
                a(this.f27192d, d.dT, "/trains/order-summary", "");
            }
        } else if (cJRTrainOrderSummaryAction.getLabel().contains("Download")) {
            if (!TextUtils.isEmpty(this.f27192d)) {
                a(this.f27192d, d.dU, "My orders screen", this.f27192d);
            }
        } else if (cJRTrainOrderSummaryAction.getLabel().contains("Cancel")) {
            a(this.f27192d, d.dV, "My orders screen", this.f27192d);
        }
    }

    private void a(String str, String str2) {
        Intent intent = new Intent(getActivity(), AJREmbedWebView.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(UpiConstants.FROM, str2);
        }
        getActivity().startActivity(intent);
    }

    private void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("origin", "deeplinking");
        bundle.putString(UpiConstants.FROM, "Order_summary");
        com.travel.train.b.a();
        com.travel.train.b.b().a((Context) getActivity(), str, bundle);
    }

    private void a(IJRDataModel iJRDataModel) {
        CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction = (CJRTrainOrderSummaryAction) iJRDataModel;
        if (cJRTrainOrderSummaryAction != null && cJRTrainOrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJRTrainOrderSummaryAction.getUrlParams().getUrl())) {
            a(cJRTrainOrderSummaryAction.getUrlParams().getUrl(), TextUtils.isEmpty(cJRTrainOrderSummaryAction.getLabel()) ? "" : cJRTrainOrderSummaryAction.getLabel());
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        startActivity(new Intent(getActivity(), AJRTrainTicketStatusGuide.class));
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.m = null;
        this.z = null;
    }

    public final void a(ah ahVar) {
        this.G = ahVar;
    }

    private void a(String str, String str2, String str3, String str4) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "train_order_page");
            hashMap.put("user_id", b.n((Context) getActivity()) != null ? b.n((Context) getActivity()) : "");
            hashMap.put("event_action", str2);
            hashMap.put("event_label", str);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
            hashMap.put(d.cv, "train");
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("trains_order_id", str4);
            }
            com.travel.train.b.a();
            com.travel.train.b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public void show() {
        d();
    }

    public void dismiss() {
        e();
    }

    static /* synthetic */ void d(w wVar) {
        if (wVar.getActivity() != null && !wVar.getActivity().isFinishing()) {
            CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse = wVar.y;
            if (cJRTrainOrderSummaryResponse != null) {
                String bookingId = cJRTrainOrderSummaryResponse.getBody().getBookingId();
                CJRTrainOrderSummaryResponse cJRTrainOrderSummaryResponse2 = wVar.y;
                CJRNPSCaptureDataModel.a aVar = new CJRNPSCaptureDataModel.a();
                String unused = aVar.f27691a.orderId = bookingId;
                ArrayList unused2 = aVar.f27691a.itemIds = a(cJRTrainOrderSummaryResponse2);
                wVar.w = aVar.f27691a;
            }
            int a2 = a(wVar.y, wVar.f27191c);
            if (a2 == 7 || a2 == 6) {
                wVar.f27194f = 10;
                if (!wVar.F) {
                    if (wVar.D == null) {
                        wVar.F = true;
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("obj", wVar.w);
                        wVar.D = v.a(bundle);
                        wVar.D.setTargetFragment(wVar, wVar.f27194f);
                    }
                    if (wVar.getFragmentManager() != null) {
                        wVar.D.show(wVar.getFragmentManager(), j);
                    }
                }
            }
        }
    }
}
