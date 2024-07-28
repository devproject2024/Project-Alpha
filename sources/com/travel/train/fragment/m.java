package com.travel.train.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainPassengerDetailActivity;
import com.travel.train.activity.AJRTrainReviewItineraryActivity;
import com.travel.train.j.b;
import com.travel.train.j.g;
import com.travel.train.j.i;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRPNRPrediction;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainDetails;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.common.views.ShimmerFrameLayout;

public final class m implements View.OnClickListener, com.paytm.network.listener.b, b.C0491b {
    public boolean A = false;
    public ShimmerFrameLayout B;
    private a C;
    private CJRTrainDetailsBody D;
    private CJRTrainSearchResultsTrain E;
    private String F;
    private com.travel.train.j.b G;
    private String H = "FJRTrainAvailabilityFragment";

    /* renamed from: a  reason: collision with root package name */
    public View f27050a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f27051b;

    /* renamed from: c  reason: collision with root package name */
    public CJRTrainSearchResultsTrain f27052c;

    /* renamed from: d  reason: collision with root package name */
    public CJRTrainDetailsBody f27053d;

    /* renamed from: e  reason: collision with root package name */
    public String f27054e;

    /* renamed from: f  reason: collision with root package name */
    public String f27055f;

    /* renamed from: g  reason: collision with root package name */
    public CJRTrainSearchInput f27056g;

    /* renamed from: h  reason: collision with root package name */
    public String f27057h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<CJRTrainAvailability> f27058i;
    public String j;
    public LinearLayout k;
    public b l;
    public boolean m = false;
    int n;
    public TextView o;
    public String p;
    public j q;
    public boolean r = false;
    public Intent s;
    public String t;
    boolean u;
    boolean v;
    public int w;
    String x;
    boolean y;
    public com.paytm.b.a.a z;

    public interface a {
        void a();
    }

    public interface b {
        void a(int i2, CJRTrainDetailsBody cJRTrainDetailsBody);
    }

    public final void onClick(View view) {
    }

    public m() {
    }

    m(a aVar) {
        this.C = aVar;
    }

    public final void b() {
        this.r = false;
        int i2 = this.n;
        if (this.f27056g != null) {
            this.f27052c.setMirctcuserid(com.paytm.utility.b.W((Context) this.f27051b));
            if (this.j != null) {
                this.f27058i.get(this.n).setmQuotaCode(this.j);
            }
            this.f27058i.get(this.n).setQuota(this.p);
            Intent intent = new Intent(this.f27051b, AJRTrainPassengerDetailActivity.class);
            intent.putExtra("train_class_code", this.f27057h);
            intent.putExtra("train_class_details", this.f27054e);
            this.f27053d.setMiSelectedPosition(i2);
            intent.putExtra("quota", this.j);
            intent.putExtra("quota_name", this.p);
            intent.putExtra("waiting_list", this.y);
            intent.putExtra("train_detail_body", this.f27053d);
            intent.putExtra("train_detail", this.f27052c);
            intent.putExtra("intent_extra_train_search_input", this.f27056g);
            intent.putExtra("chosenDate", this.x);
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27052c;
            if (cJRTrainSearchResultsTrain != null) {
                intent.putExtra("source", cJRTrainSearchResultsTrain.getSource());
                intent.putExtra("destination", this.f27052c.getDestination());
            }
            intent.putExtra("request_id", this.f27055f);
            intent.putExtra("minsuranceAlwaysTrue", this.v);
            intent.putExtra("minsuranceOption", this.u);
            this.f27051b.startActivityForResult(intent, 989);
        }
    }

    private void e() {
        if (this.l != null) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    m.this.o.measure(0, 0);
                    int dimension = (int) m.this.f27051b.getResources().getDimension(R.dimen.dimen_150dp);
                    if (m.this.o.getMeasuredHeight() > dimension) {
                        dimension = m.this.o.getMeasuredHeight();
                    }
                    m.this.l.a(dimension, m.this.f27053d);
                }
            }, 1000);
        }
    }

    public final void a() {
        com.travel.train.j.b bVar = this.G;
        if (bVar != null) {
            bVar.b();
        }
    }

    private void f() {
        this.k.setVisibility(0);
        this.B.setVisibility(8);
        this.B.b();
    }

    public final void d() {
        final CJRTrainAvailability cJRTrainAvailability = this.f27058i.get(this.n);
        HashMap<String, String> typeMap = cJRTrainAvailability.getTypeMap();
        if (!this.r) {
            for (Map.Entry<String, String> value : typeMap.entrySet()) {
                if (value.getValue().equals("0")) {
                    Activity activity = this.f27051b;
                    com.paytm.utility.b.b((Context) activity, activity.getString(R.string.train_title_booking_not_allowed), this.f27051b.getString(R.string.booking_not_accepted_text));
                } else if (cJRTrainAvailability.isBookingAllowed()) {
                    if (cJRTrainAvailability.isMessageEnable()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.f27051b);
                        builder.setMessage(cJRTrainAvailability.getMessage());
                        builder.setPositiveButton(this.f27051b.getString(R.string.ok), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                                m.this.b(cJRTrainAvailability);
                            }
                        });
                        builder.show();
                    } else {
                        b(cJRTrainAvailability);
                    }
                } else if (cJRTrainAvailability.isMessageEnable()) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this.f27051b);
                    builder2.setMessage(cJRTrainAvailability.getMessage());
                    builder2.setPositiveButton(this.f27051b.getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder2.show();
                }
            }
            return;
        }
        g();
    }

    /* access modifiers changed from: private */
    public void b(CJRTrainAvailability cJRTrainAvailability) {
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27052c;
        if (cJRTrainSearchResultsTrain == null || !cJRTrainSearchResultsTrain.isDynamicPricingEnable() || this.f27052c.getDynamicPricingMessage() == null) {
            CJRTrainDetailsBody cJRTrainDetailsBody = this.f27053d;
            if (cJRTrainDetailsBody == null || cJRTrainDetailsBody.getMessage() == null || !this.f27053d.getMessage().isEnable() || g.f27551a == null || !g.f27551a.getShowDynamicPricingAlert()) {
                a(cJRTrainAvailability);
            } else {
                d(cJRTrainAvailability);
            }
        } else {
            c(cJRTrainAvailability);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CJRTrainAvailability cJRTrainAvailability) {
        String str;
        g();
        HashMap hashMap = new HashMap();
        hashMap.put(d.l, Integer.valueOf(e(cJRTrainAvailability)));
        String valueOf = cJRTrainAvailability.getmPNRPrediction() != null ? String.valueOf(cJRTrainAvailability.getmPNRPrediction().getValue()) : null;
        String valueOf2 = String.valueOf(this.f27052c.getDelayScore());
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27052c;
        if (cJRTrainSearchResultsTrain == null || !cJRTrainSearchResultsTrain.isSearchByTrainResult()) {
            o.a("train_search_results", valueOf, valueOf2, (String) null, this.f27052c.getSourceName(), this.f27052c.getDestinationName(), this.f27052c.getDeparture(), "ticket_selected", "/trains/search-results", this.f27051b, hashMap);
        } else {
            o.a("train_search_results", "Train number", "train_ticket_selected", "/trains", this.f27051b);
        }
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2 = this.f27052c;
        if (cJRTrainSearchResultsTrain2 != null && cJRTrainSearchResultsTrain2.getDuration() != null) {
            String departureTime = !TextUtils.isEmpty(this.f27052c.getDepartureTime()) ? this.f27052c.getDepartureTime() : i.f(this.f27052c.getDeparture());
            if (!TextUtils.isEmpty(this.f27052c.getArrivalTime())) {
                str = this.f27052c.getArrivalTime();
            } else {
                str = i.b(i.d(cJRTrainAvailability.getmDate() + departureTime), this.f27052c.getDuration());
            }
            a(str);
        }
    }

    private void c(final CJRTrainAvailability cJRTrainAvailability) {
        Activity activity = this.f27051b;
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(this.f27052c.getDynamicPricingMessage());
            builder.setPositiveButton(this.f27051b.getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    m.this.a(cJRTrainAvailability);
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }

    private void d(final CJRTrainAvailability cJRTrainAvailability) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f27051b);
        View inflate = this.f27051b.getLayoutInflater().inflate(R.layout.pre_t_dynamic_pricing_layout, (ViewGroup) null);
        builder.setView(inflate);
        ((TextView) inflate.findViewById(R.id.tv_msg)).setText(this.f27053d.getMessage().getMessage());
        final AlertDialog show = builder.show();
        ((Button) inflate.findViewById(R.id.btn_proceed)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.a(cJRTrainAvailability);
                show.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                show.dismiss();
            }
        });
    }

    private int e(CJRTrainAvailability cJRTrainAvailability) {
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27052c;
        if (cJRTrainSearchResultsTrain == null) {
            return 1;
        }
        String departureTime = !TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDepartureTime()) ? this.f27052c.getDepartureTime() : i.f(this.f27052c.getDeparture());
        StringBuilder sb = new StringBuilder();
        sb.append(cJRTrainAvailability.getmDate());
        sb.append(departureTime);
        return (this.f27052c.getDeparture() == null || !this.f27052c.getDeparture().equalsIgnoreCase(i.d(sb.toString()))) ? 1 : 0;
    }

    private void a(String str) {
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27052c;
        if (cJRTrainSearchResultsTrain != null) {
            String departureTime = !TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDepartureTime()) ? this.f27052c.getDepartureTime() : i.f(this.f27052c.getDeparture());
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2 = this.f27052c;
            if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain2.getArrivalTime())) {
                str = i.d(this.f27052c.getArrival() + str);
            }
            cJRTrainSearchResultsTrain2.setMSearchedTrainArrivalTime(str);
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain3 = this.f27052c;
            cJRTrainSearchResultsTrain3.setMSearchedTrainDepartureTime(i.d(this.f27052c.getDeparture() + departureTime));
        }
    }

    private void h() {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        com.travel.train.b.a();
        com.travel.train.b.b().a((Context) this.f27051b, intent, 4);
    }

    public final void a(View view) {
        o.a(view);
        int measuredHeight = view.getMeasuredHeight();
        b bVar = this.l;
        if (bVar != null) {
            bVar.a(measuredHeight, this.f27053d);
        }
    }

    private void b(String str) {
        this.o.setText(str);
        this.o.setVisibility(0);
        e();
    }

    public final void c() {
        Intent intent = new Intent(this.f27051b, AJRTrainReviewItineraryActivity.class);
        Intent intent2 = this.s;
        if (intent2 != null) {
            if (intent2.hasExtra("train_detail_body") && this.s.getSerializableExtra("train_detail_body") != null) {
                this.D = (CJRTrainDetailsBody) this.s.getSerializableExtra("train_detail_body");
            }
            if (this.s.hasExtra("train_detail") && this.s.getSerializableExtra("train_detail") != null) {
                this.E = (CJRTrainSearchResultsTrain) this.s.getSerializableExtra("train_detail");
            }
            if (this.s.hasExtra("intent_extra_train_search_input")) {
                intent.putExtra("intent_extra_train_search_input", this.s.getSerializableExtra("intent_extra_train_search_input"));
            }
            if (this.s.hasExtra("request_id")) {
                this.F = this.s.getStringExtra("request_id");
            }
            if (this.s.hasExtra("train_class_code")) {
                this.t = this.s.getStringExtra("train_class_code");
            }
            intent.putExtra("train_detail_body", this.D);
            intent.putExtra("train_detail", this.E);
            intent.putExtra("request_id", this.F);
            intent.putExtra("train_class_code", this.t);
        }
        this.f27051b.startActivity(intent);
    }

    private void g() {
        if (com.paytm.utility.b.r((Context) this.f27051b)) {
            String W = com.paytm.utility.b.W((Context) this.f27051b);
            if (W == null || TextUtils.isEmpty(W)) {
                this.G = new com.travel.train.j.b(this.f27051b, this, false, (String) null, (String) null, this.f27056g, this.q, this.r, this.w, false, true);
                this.G.a();
                this.r = false;
                return;
            }
            this.G = new com.travel.train.j.b(this.f27051b, this, false, (String) null, W, this.f27056g, this.q, this.r, this.w, false, true);
            this.G.a(W);
            this.r = false;
            return;
        }
        h();
    }

    public final void a(final com.paytm.network.a aVar) {
        Activity activity = this.f27051b;
        if (activity != null) {
            final h hVar = new h(activity);
            hVar.setTitle(this.f27051b.getResources().getString(R.string.no_connection));
            hVar.a(this.f27051b.getResources().getString(R.string.no_internet_train));
            hVar.a(-3, this.f27051b.getString(R.string.network_retry_yes), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (com.paytm.utility.b.c((Context) m.this.f27051b)) {
                        aVar.a();
                    } else {
                        m.this.a(aVar);
                    }
                }
            });
            hVar.show();
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        ArrayList<CJRTrainAvailability> arrayList;
        String str;
        if (!this.f27051b.isFinishing() && iJRPaytmDataModel != null && iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRTrainDetails)) {
            CJRTrainDetails cJRTrainDetails = (CJRTrainDetails) iJRPaytmDataModel;
            if (!(cJRTrainDetails.getmTrainDetailsBody() == null || cJRTrainDetails.getmTrainDetailsBody().getmTrainAvailability() == null || cJRTrainDetails.getmTrainDetailsBody().getmTrainAvailability().size() <= 0)) {
                f();
                this.f27053d = cJRTrainDetails.getmTrainDetailsBody();
                this.f27058i = this.f27053d.getmTrainAvailability();
                if (!this.f27058i.isEmpty() && (arrayList = this.f27058i) != null && arrayList.size() > 0) {
                    CJRTrainSearchInput cJRTrainSearchInput = this.f27056g;
                    if (cJRTrainSearchInput == null || cJRTrainSearchInput.getmDate() == null) {
                        str = "";
                    } else {
                        str = "dd MMM yy";
                        if (!com.paytm.utility.b.c(this.f27056g.getmDate(), str)) {
                            str = "dd MMM yy, EEE";
                        }
                    }
                    for (int i2 = 0; i2 < this.f27058i.size(); i2++) {
                        View inflate = this.f27051b.getLayoutInflater().inflate(R.layout.pre_t_train_avlblty_list_item, (ViewGroup) null);
                        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                        inflate.setTag(Integer.valueOf(i2));
                        View findViewById = inflate.findViewById(R.id.divider_view_bottom);
                        if (i2 == this.f27058i.size() - 1) {
                            findViewById.setVisibility(4);
                        }
                        final CJRTrainAvailability cJRTrainAvailability = this.f27058i.get(i2);
                        if (cJRTrainAvailability != null) {
                            CJRPNRPrediction cJRPNRPrediction = cJRTrainAvailability.getmPNRPrediction();
                            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.prediction_progressBar);
                            TextView textView = (TextView) inflate.findViewById(R.id.prediction_progressBar_txt);
                            if (cJRPNRPrediction != null) {
                                progressBar.setVisibility(0);
                                textView.setVisibility(0);
                                progressBar.setProgress(cJRPNRPrediction.getValue());
                                textView.setText(cJRPNRPrediction.getValue() + "%");
                                String color = cJRPNRPrediction.getColor();
                                if (TextUtils.isEmpty(color)) {
                                    color = "#00baf2";
                                }
                                if (Build.VERSION.SDK_INT >= 21) {
                                    progressBar.getProgressDrawable().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
                                }
                                if (!this.z.b("train_show_tip_details_view", false, false)) {
                                    this.A = true;
                                    this.z.a("train_show_tip_details_view", true, false);
                                    com.travel.train.hintsbuilder.b a2 = new com.travel.train.hintsbuilder.b(this.f27051b).a((View) progressBar).b(this.f27051b.getResources().getString(R.string.train_show_tip_view_desc1)).b().c().a(true);
                                    a2.f27479a.setLayoutWidthHeight(AppConstants.READ_TIME_OUT, AppConstants.READ_TIME_OUT);
                                    a2.a(R.layout.pre_t_train_intro_srp_show_tip_layout).f27479a.a(this.f27051b);
                                }
                            } else {
                                progressBar.setVisibility(4);
                                textView.setVisibility(4);
                            }
                            if (cJRTrainAvailability.getTypeMap() != null) {
                                HashMap<String, String> typeMap = cJRTrainAvailability.getTypeMap();
                                StringBuilder sb = new StringBuilder();
                                if (typeMap != null) {
                                    sb.append(cJRTrainAvailability.getmSttaus());
                                    ((TextView) inflate.findViewById(R.id.txt_train_status)).setText(sb);
                                    ((TextView) inflate.findViewById(R.id.txt_train_status)).setTextColor(this.f27051b.getResources().getColor(n.b(n.a(typeMap.values()))));
                                    if (typeMap.values().contains(g.Y)) {
                                        cJRTrainAvailability.setBlockedTrain(true);
                                        ((TextView) inflate.findViewById(R.id.txt_train_price)).setTextColor(androidx.core.content.b.c(this.f27051b, R.color.color_00aced));
                                        inflate.findViewById(R.id.txt_train_price).setAlpha(0.48f);
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(cJRTrainAvailability.getmDate())) {
                                ((TextView) inflate.findViewById(R.id.txt_train_date)).setText(com.paytm.utility.b.d(cJRTrainAvailability.getmDate(), "yyyy-MM-dd", "EEE, dd MMM"));
                                CJRTrainSearchInput cJRTrainSearchInput2 = this.f27056g;
                                if (cJRTrainSearchInput2 != null && !TextUtils.isEmpty(cJRTrainSearchInput2.getmDate())) {
                                    if (i.a(this.f27056g.getmDate(), str, cJRTrainAvailability.getmDate(), "yyyy-MM-dd")) {
                                        inflate.setBackgroundColor(this.f27051b.getResources().getColor(R.color.color_f5f8f8));
                                    } else {
                                        inflate.setBackgroundColor(this.f27051b.getResources().getColor(R.color.transparent));
                                    }
                                }
                            }
                        }
                        this.k.addView(inflate);
                        inflate.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                m.this.n = ((Integer) view.getTag()).intValue();
                                m mVar = m.this;
                                HashMap<String, String> typeMap = mVar.f27058i.get(mVar.n).getTypeMap();
                                if (typeMap != null) {
                                    for (Map.Entry next : typeMap.entrySet()) {
                                        mVar.y = !next.getValue().equals("1") && !next.getValue().equals("2") && !next.getValue().equals("0");
                                    }
                                }
                                m.this.x = com.paytm.utility.b.d(cJRTrainAvailability.getmDate(), "yyyy-MM-dd", "EEE, dd MMM");
                                if (cJRTrainAvailability.isMinsuranceOption()) {
                                    m.this.v = cJRTrainAvailability.isMinsuranceAlwaysTrue();
                                    m.this.u = true;
                                } else {
                                    m.this.u = false;
                                }
                                m.this.d();
                            }
                        });
                    }
                }
            }
            if (this.l != null) {
                a(this.f27050a);
            }
            a aVar = this.C;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            if (!this.f27051b.isFinishing()) {
                f();
                com.travel.train.model.a aVar = new com.travel.train.model.a();
                if (networkCustomError.networkResponse != null) {
                    NetworkResponse networkResponse = networkCustomError.networkResponse;
                    if (networkResponse.data != null) {
                        try {
                            aVar = (com.travel.train.model.a) new f().a(new String(networkResponse.data), aVar.getClass());
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                    }
                }
                if (i2 != 401) {
                    if (i2 != 410) {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            com.paytm.utility.b.f((Context) this.f27051b, networkCustomError.getUrl());
                            return;
                        } else if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                            b(aVar.getStatus().getMessage().f27693b);
                            return;
                        } else if (networkCustomError.getAlertTitle() != null && networkCustomError.getAlertMessage() != null) {
                            b(networkCustomError.getAlertMessage());
                            return;
                        } else if (TextUtils.isEmpty(networkCustomError.getMessage()) || !networkCustomError.getMessage().equals("failure_error")) {
                            b(this.f27051b.getResources().getString(R.string.network_error_message_train));
                            return;
                        } else {
                            b(networkCustomError.getAlertMessage());
                            return;
                        }
                    }
                }
                com.travel.train.b.a();
                com.travel.train.b.b().a(this.f27051b, networkCustomError);
            }
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }
}
