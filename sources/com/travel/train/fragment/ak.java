package com.travel.train.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.b.at;
import com.travel.train.j.g;
import com.travel.train.j.i;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRPNRStatusDetails;
import com.travel.train.model.trainticket.CJRStationList;
import com.travel.train.model.trainticket.CJRTrainRoute;
import com.travel.train.model.trainticket.CJRTrainRouteBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.List;

public class ak extends am implements b {

    /* renamed from: a  reason: collision with root package name */
    private View f26881a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f26882b;

    /* renamed from: c  reason: collision with root package name */
    private View f26883c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainSearchResultsTrain f26884d;

    /* renamed from: e  reason: collision with root package name */
    private CJRTrainSearchInput f26885e;

    /* renamed from: f  reason: collision with root package name */
    private List<CJRStationList> f26886f;

    /* renamed from: g  reason: collision with root package name */
    private at f26887g;

    /* renamed from: h  reason: collision with root package name */
    private String f26888h;

    /* renamed from: i  reason: collision with root package name */
    private String f26889i;
    private String j;
    private CJRPNRStatusDetails k;
    private RelativeLayout l;
    private RelativeLayout m;
    private boolean n = false;
    private String o;
    private String p = "FJRTrainViewRouteFragment";

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.f26881a = layoutInflater.inflate(R.layout.pre_t_fragment_train_view_route_new, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments.containsKey("flag") && arguments.getBoolean("flag")) {
            this.k = (CJRPNRStatusDetails) arguments.getSerializable("train_detail");
            this.j = this.k.getmTrainNumber();
            this.f26889i = this.k.getmDate();
            this.f26888h = this.k.getmBoardingStation().getmStationCode();
        } else if (!arguments.containsKey("order_summary_flag") || !arguments.getBoolean("order_summary_flag")) {
            if (arguments.containsKey("extra_home_data")) {
                this.f26884d = (CJRTrainSearchResultsTrain) getArguments().getSerializable("extra_home_data");
            }
            if (arguments.containsKey("extra_selected_train_detail")) {
                this.f26885e = (CJRTrainSearchInput) getArguments().getSerializable("extra_selected_train_detail");
            }
            this.j = this.f26884d.getTrainNumber();
            this.f26889i = this.f26884d.getDeparture() != null ? this.f26884d.getDeparture() : i.j(this.f26885e.getmDate());
            this.f26888h = this.f26884d.getSource();
        } else {
            this.f26884d = (CJRTrainSearchResultsTrain) arguments.getSerializable("train_detail");
            this.n = true;
            this.o = arguments.getString("order_summary_view_route_url");
        }
        this.f26882b = (RecyclerView) this.f26881a.findViewById(R.id.view_route_list);
        this.l = (RelativeLayout) this.f26881a.findViewById(R.id.no_station_found_layout);
        this.m = (RelativeLayout) this.f26881a.findViewById(R.id.train_route_list_lyt);
        this.f26882b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f26883c = this.f26881a.findViewById(R.id.train_route_loader);
        if (getActivity() != null && !isDetached()) {
            if (getActivity() != null && !isDetached() && (this.mProgressDialog == null || !this.mProgressDialog.isShowing())) {
                this.mProgressDialog = new ProgressDialog(getActivity());
                try {
                    this.mProgressDialog.setProgressStyle(0);
                    this.mProgressDialog.setMessage("Fetching route and schedule..");
                    this.mProgressDialog.setCancelable(false);
                    this.mProgressDialog.setCanceledOnTouchOutside(false);
                    this.mProgressDialog.show();
                } catch (IllegalArgumentException e2) {
                    q.c(e2.getMessage());
                } catch (Exception unused) {
                }
            }
            if (this.n) {
                str = this.o;
            } else if (this.j == null || this.f26888h == null || this.f26889i == null) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder();
                com.travel.train.b.a();
                sb.append(com.travel.train.b.b().O());
                sb.append("trainNumber=");
                sb.append(this.j);
                sb.append("&departureDate=");
                getActivity();
                sb.append(com.paytm.utility.b.b(this.f26889i, "yyyy-mm-dd", "yyyymmdd"));
                sb.append("&source=");
                sb.append(this.f26888h);
                str = sb.toString();
            }
            if (!URLUtil.isValidUrl(str)) {
                com.paytm.utility.b.b((Context) getActivity(), getActivity().getString(R.string.error), getActivity().getString(R.string.msg_invalid_url_train));
            } else if (str != null) {
                String b2 = o.b((Context) getActivity(), com.paytm.utility.b.s(getActivity(), str));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getActivity();
                bVar.f42878b = a.c.TRAIN;
                bVar.n = a.b.SILENT;
                bVar.o = g.l;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = b2;
                bVar.f42882f = n.b((Context) getActivity());
                bVar.f42885i = new CJRTrainRoute();
                bVar.j = this;
                a l2 = bVar.l();
                l2.f42859c = false;
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    l2.a();
                } else {
                    a(l2);
                }
            }
        }
        setRetainInstance(true);
        return this.f26881a;
    }

    /* access modifiers changed from: private */
    public void a(final a aVar) {
        if (getActivity() != null && !isDetached()) {
            final h hVar = new h(getActivity());
            hVar.setTitle(getResources().getString(R.string.no_connection));
            hVar.a(getResources().getString(R.string.no_internet));
            hVar.a(-3, getResources().getString(R.string.network_retry_yes), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (com.paytm.utility.b.c((Context) ak.this.getActivity())) {
                        aVar.a();
                    } else {
                        ak.this.a(aVar);
                    }
                }
            });
            hVar.show();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (getActivity() != null && iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRTrainRoute)) {
            this.mProgressDialog.hide();
            CJRTrainRoute cJRTrainRoute = (CJRTrainRoute) iJRPaytmDataModel;
            if (cJRTrainRoute.getmStatus() != null && cJRTrainRoute.getmStatus().getmResult().equalsIgnoreCase("success")) {
                CJRTrainRouteBody cJRTrainRouteBody = cJRTrainRoute.getmRouteDetails();
                if (cJRTrainRoute == null || cJRTrainRouteBody.getmStationList() == null || cJRTrainRouteBody.getmStationList().size() <= 0) {
                    this.l.setVisibility(0);
                    this.f26882b.setVisibility(8);
                    this.m.setVisibility(8);
                    return;
                }
                this.f26886f = cJRTrainRouteBody.getmStationList();
                this.f26887g = new at(getActivity(), this.f26884d, cJRTrainRouteBody, this.k);
                this.f26882b.setAdapter(this.f26887g);
                this.l.setVisibility(8);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                this.mProgressDialog.hide();
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
                        if (TextUtils.isEmpty(networkCustomError.getMessage()) || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                                com.travel.train.b.a();
                                if (!com.travel.train.b.b().a((Context) getActivity(), (Exception) networkCustomError, "error.trains@paytm.com")) {
                                    com.paytm.utility.b.b((Context) getActivity(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                                    return;
                                }
                            }
                            if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                                com.paytm.utility.b.b((Context) getActivity(), aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
                                return;
                            } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                return;
                            } else {
                                com.paytm.utility.b.b((Context) getActivity(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                                return;
                            }
                        } else {
                            com.paytm.utility.b.f((Context) getActivity(), networkCustomError.getUrl());
                            return;
                        }
                    }
                }
                com.travel.train.b.a();
                com.travel.train.b.b().a((Activity) getActivity(), networkCustomError);
            }
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void onDetach() {
        super.onDetach();
        this.mProgressDialog.dismiss();
    }

    public final void a(String str) {
        List<CJRStationList> list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            List<CJRStationList> list2 = this.f26886f;
            if (list2 != null && list2.size() > 0) {
                for (CJRStationList next : this.f26886f) {
                    if ((next.getmStationName() != null && next.getmStationName().toLowerCase().contains(str.toLowerCase())) || (next.getmStationCode() != null && next.getmStationCode().toLowerCase().contains(str.toLowerCase()))) {
                        arrayList.add(next);
                    }
                }
            }
            if (this.f26887g == null || arrayList.size() <= 0) {
                this.f26882b.setVisibility(8);
                this.l.setVisibility(0);
                this.f26883c.setVisibility(8);
                this.m.setVisibility(8);
                return;
            }
            this.f26882b.setVisibility(0);
            this.m.setVisibility(0);
            this.f26887g.a((List<CJRStationList>) arrayList);
            this.l.setVisibility(8);
        } else if (this.f26887g == null || (list = this.f26886f) == null || list.size() <= 0) {
            this.l.setVisibility(0);
            this.f26882b.setVisibility(8);
            this.f26883c.setVisibility(8);
            this.m.setVisibility(8);
        } else {
            this.f26887g.a(this.f26886f);
            this.l.setVisibility(8);
            this.f26882b.setVisibility(0);
            this.m.setVisibility(0);
        }
    }
}
