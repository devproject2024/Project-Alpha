package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.l;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.i.ac;
import com.travel.train.i.m;
import com.travel.train.i.w;
import com.travel.train.j.m;
import com.travel.train.model.trainticket.CJRTrainCitySearchCategory;
import com.travel.train.model.trainticket.CJRTrainOriginCityItem;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.train.model.trainticket.CJRTrainRouteStations;
import com.travel.train.model.trainticket.CJRTrainStation;
import com.travel.utils.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class bj extends RecyclerView.v {
    private ImageView A;
    private TextView B;
    private TextView C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private TextView G;
    private int H = 0;
    private int I;

    /* renamed from: a  reason: collision with root package name */
    String f27989a = "popular";

    /* renamed from: b  reason: collision with root package name */
    String f27990b = "recent";

    /* renamed from: c  reason: collision with root package name */
    String f27991c = "search";

    /* renamed from: d  reason: collision with root package name */
    String f27992d = "City";

    /* renamed from: e  reason: collision with root package name */
    Context f27993e;

    /* renamed from: f  reason: collision with root package name */
    int f27994f;

    /* renamed from: g  reason: collision with root package name */
    w f27995g;

    /* renamed from: h  reason: collision with root package name */
    m f27996h;

    /* renamed from: i  reason: collision with root package name */
    ac f27997i;
    String j = "CJRTrainRecentPopularViewHolder";
    private String k = "state";
    private String l = "Most Popular";
    private String m = "station";
    private RelativeLayout n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private ImageView x;
    private View y;
    private View z;

    public bj(Context context, View view, int i2, w wVar, m mVar, ac acVar) {
        super(view);
        this.f27993e = context;
        this.n = (RelativeLayout) view.findViewById(R.id.header_lyt);
        this.o = (TextView) view.findViewById(R.id.header_txt);
        this.C = (TextView) view.findViewById(R.id.stationCode);
        this.B = (TextView) view.findViewById(R.id.close_icon);
        this.A = (ImageView) view.findViewById(R.id.arrow);
        this.y = view;
        this.p = (TextView) view.findViewById(R.id.station_name);
        this.r = (TextView) view.findViewById(R.id.most_popular);
        this.q = (TextView) view.findViewById(R.id.station_name_dest);
        this.s = (TextView) view.findViewById(R.id.station_type);
        this.E = (LinearLayout) view.findViewById(R.id.station_type_lyt);
        this.t = (TextView) view.findViewById(R.id.station_distance);
        this.u = (TextView) view.findViewById(R.id.tv_popular_txt);
        this.w = (ImageView) view.findViewById(R.id.station_type_icon);
        this.z = view.findViewById(R.id.seperator);
        this.D = (LinearLayout) view.findViewById(R.id.item_container);
        this.F = (LinearLayout) view.findViewById(R.id.no_station_container);
        this.v = (TextView) view.findViewById(R.id.station_zone_name);
        this.x = (ImageView) view.findViewById(R.id.city_circle);
        this.G = (TextView) view.findViewById(R.id.tv_no_station_text);
        this.H = i2;
        this.f27995g = wVar;
        this.f27996h = mVar;
        this.f27997i = acVar;
    }

    public final void a(IJRDataModel iJRDataModel, int i2, int i3) {
        this.f27994f = i2;
        this.I = i3;
        if (iJRDataModel instanceof CJRTrainCitySearchCategory) {
            a(iJRDataModel);
        } else if ((iJRDataModel instanceof CJRTrainStation) || (iJRDataModel instanceof CJRTrainRecentsItemModel)) {
            b(iJRDataModel);
        } else if (iJRDataModel instanceof CJRTrainOriginCityItem) {
            c(iJRDataModel);
        } else if (iJRDataModel instanceof CJRTrainRouteStations) {
            d(iJRDataModel);
        }
    }

    private void a(IJRDataModel iJRDataModel) {
        CJRTrainCitySearchCategory cJRTrainCitySearchCategory = (CJRTrainCitySearchCategory) iJRDataModel;
        this.n.setVisibility(0);
        this.D.setVisibility(8);
        this.z.setVisibility(8);
        if (cJRTrainCitySearchCategory.getCategoryTitle().equalsIgnoreCase("Recently Searched")) {
            this.o.setText(this.f27993e.getResources().getString(R.string.train_recently_searched));
            this.B.setVisibility(0);
        } else {
            this.o.setText(cJRTrainCitySearchCategory.getCategoryTitle());
            this.B.setVisibility(8);
        }
        this.B.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (bj.this.f27996h != null) {
                    bj.this.f27996h.a("train_home_recent_search_removed", b.r(bj.this.f27993e) ? b.n(bj.this.f27993e) : "");
                    bj.this.f27996h.a();
                    m.a aVar = com.travel.train.j.m.f27577a;
                    Context context = bj.this.f27993e;
                    String n = b.n(bj.this.f27993e);
                    k.c("train_most_visited", "keyName");
                    if (context != null && !TextUtils.isEmpty(n)) {
                        context.getSharedPreferences("train_most_visited", 0).edit().putString(n, new f().a((l) null)).putString("searchedcitieswithdate", n).apply();
                    }
                }
            }
        });
    }

    private void b(IJRDataModel iJRDataModel) {
        int i2 = this.f27994f;
        if (i2 == this.H || i2 == this.I - 1) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
        }
        this.D.setVisibility(0);
        this.n.setVisibility(8);
        if (iJRDataModel instanceof CJRTrainRecentsItemModel) {
            final CJRTrainRecentsItemModel cJRTrainRecentsItemModel = (CJRTrainRecentsItemModel) iJRDataModel;
            this.p.setText(cJRTrainRecentsItemModel.getSourceCityName());
            this.q.setVisibility(0);
            this.q.setText(cJRTrainRecentsItemModel.getDestinationCityName());
            this.A.setVisibility(0);
            this.F.setVisibility(8);
            this.s.setVisibility(8);
            this.w.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.x.setVisibility(8);
            this.C.setVisibility(8);
            this.y.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    String str = bj.this.f27990b;
                    if (bj.this.f27997i.equals(ac.SEARCH_STATION)) {
                        str = bj.this.f27991c;
                    }
                    bj.this.f27995g.a(bj.this.f27994f, cJRTrainRecentsItemModel, str);
                }
            });
        } else if (iJRDataModel instanceof CJRTrainStation) {
            final CJRTrainStation cJRTrainStation = (CJRTrainStation) iJRDataModel;
            final CJRTrainOriginCityItem cityItem = cJRTrainStation.getCityItem();
            this.p.setText(cityItem.getCityName());
            b(cityItem);
            a(cityItem);
            a(cJRTrainStation, cityItem);
            this.q.setVisibility(8);
            this.A.setVisibility(8);
            if (TextUtils.isEmpty(cityItem.getCityName()) || cityItem.getCityName().contains(this.f27993e.getResources().getString(R.string.trains_all_station_string)) || cityItem.getCityCode() == null || cityItem.getCityCode().trim().length() <= 0) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
                this.C.setText(cityItem.getCityCode());
            }
            this.y.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    String str;
                    if (bj.this.f27995g != null) {
                        if (cJRTrainStation.isNearByStation()) {
                            bj bjVar = bj.this;
                            String cityName = cityItem.getCityName();
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put("event_category", "train_homepage");
                                hashMap.put("user_id", b.n(bjVar.f27993e) != null ? b.n(bjVar.f27993e) : "");
                                hashMap.put("event_action", d.dQ);
                                hashMap.put("event_label", cityName);
                                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/station-search");
                                hashMap.put(d.cv, "train");
                                com.travel.train.b.a();
                                com.travel.train.b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, bjVar.f27993e);
                            } catch (Exception e2) {
                                q.c(e2.getMessage());
                            }
                        }
                        if (!TextUtils.isEmpty(cJRTrainStation.getType())) {
                            if (cJRTrainStation.getType().equalsIgnoreCase("state")) {
                                bj.this.a(cityItem.getCityName(), false);
                            } else if (cJRTrainStation.getType().equalsIgnoreCase("city")) {
                                bj.this.a(cityItem.getCityName(), true);
                            }
                        }
                        if (cityItem.isRecentObject()) {
                            str = bj.this.f27990b;
                        } else {
                            str = bj.this.f27989a;
                        }
                        if (bj.this.f27997i.equals(ac.SEARCH_STATION)) {
                            str = bj.this.f27991c;
                        }
                        bj.this.f27995g.a(bj.this.f27994f, cJRTrainStation, str);
                    }
                }
            });
        }
    }

    private void c(IJRDataModel iJRDataModel) {
        int i2 = this.f27994f;
        if (i2 == this.H || i2 == this.I - 1) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
        }
        this.D.setVisibility(0);
        this.n.setVisibility(8);
        final CJRTrainOriginCityItem cJRTrainOriginCityItem = (CJRTrainOriginCityItem) iJRDataModel;
        if (cJRTrainOriginCityItem != null && !TextUtils.isEmpty(cJRTrainOriginCityItem.getDisplayName())) {
            this.p.setText(cJRTrainOriginCityItem.getCityName());
            if (cJRTrainOriginCityItem.getCityCode() == null || cJRTrainOriginCityItem.getCityCode().trim().length() <= 0) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
                this.C.setText(cJRTrainOriginCityItem.getCityCode());
            }
        }
        b(cJRTrainOriginCityItem);
        a(cJRTrainOriginCityItem);
        this.y.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                String str;
                if (bj.this.f27995g != null) {
                    if (!TextUtils.isEmpty(cJRTrainOriginCityItem.getParentName()) && !TextUtils.isEmpty(cJRTrainOriginCityItem.getParentType())) {
                        if (cJRTrainOriginCityItem.getParentType().equalsIgnoreCase(bj.this.f27992d)) {
                            bj.this.a(cJRTrainOriginCityItem.getParentName(), true);
                        } else {
                            bj.this.a(cJRTrainOriginCityItem.getParentName(), false);
                        }
                    }
                    bj.this.f27996h.a(d.dO, cJRTrainOriginCityItem.getDisplayName(), bj.this.f27994f, cJRTrainOriginCityItem.getDistanceValue());
                    CJRTrainStation cJRTrainStation = new CJRTrainStation();
                    cJRTrainStation.setExpandable(false);
                    cJRTrainStation.setCityItem(cJRTrainOriginCityItem);
                    if (cJRTrainOriginCityItem.isRecentObject()) {
                        str = bj.this.f27990b;
                    } else {
                        str = bj.this.f27989a;
                    }
                    if (bj.this.f27997i.equals(ac.SEARCH_STATION)) {
                        str = bj.this.f27991c;
                    }
                    bj.this.f27995g.a(bj.this.f27994f, cJRTrainStation, str);
                }
            }
        });
    }

    private void d(IJRDataModel iJRDataModel) {
        int i2 = this.f27994f;
        if (i2 == this.H || i2 == this.I - 1) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
        }
        this.D.setVisibility(0);
        this.n.setVisibility(8);
        final CJRTrainRouteStations cJRTrainRouteStations = (CJRTrainRouteStations) iJRDataModel;
        if (cJRTrainRouteStations != null && !TextUtils.isEmpty(cJRTrainRouteStations.getDisplayName())) {
            this.p.setText(cJRTrainRouteStations.getDisplayName());
        }
        this.s.setVisibility(8);
        this.w.setVisibility(8);
        this.t.setVisibility(8);
        this.y.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (bj.this.f27995g != null) {
                    bj.this.f27995g.a(bj.this.f27994f, cJRTrainRouteStations, "");
                }
            }
        });
    }

    private void a(CJRTrainStation cJRTrainStation, CJRTrainOriginCityItem cJRTrainOriginCityItem) {
        if (!cJRTrainStation.isShowNoStationView() || !cJRTrainOriginCityItem.getType().equalsIgnoreCase(this.f27992d)) {
            this.F.setVisibility(8);
            return;
        }
        this.F.setVisibility(0);
        this.G.setText(this.f27993e.getString(R.string.trains_no_station, new Object[]{cJRTrainOriginCityItem.getDisplayName()}));
    }

    private void a(CJRTrainOriginCityItem cJRTrainOriginCityItem) {
        if (!TextUtils.isEmpty(cJRTrainOriginCityItem.getDistance())) {
            this.t.setText(cJRTrainOriginCityItem.getDistance());
            this.t.setVisibility(0);
            this.u.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
            layoutParams.height = (int) this.f27993e.getResources().getDimension(R.dimen.train_station_distance_item_height);
            this.D.setLayoutParams(layoutParams);
        } else {
            this.t.setVisibility(8);
        }
        if (!TextUtils.isEmpty(cJRTrainOriginCityItem.getDisplayLocation())) {
            this.v.setVisibility(0);
            this.v.setText(cJRTrainOriginCityItem.getDisplayLocation());
            ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
            layoutParams2.height = (int) this.f27993e.getResources().getDimension(R.dimen.train_station_distance_item_height);
            this.D.setLayoutParams(layoutParams2);
        }
        if (this.t.getVisibility() == 0 && this.v.getVisibility() == 0) {
            this.x.setVisibility(0);
        }
    }

    private void b(CJRTrainOriginCityItem cJRTrainOriginCityItem) {
        this.r.setVisibility(8);
        if (cJRTrainOriginCityItem.getType().equalsIgnoreCase(this.f27992d)) {
            this.s.setText(this.f27993e.getResources().getString(R.string.select_city));
            ResourceUtils.loadTrainImagesFromCDN(this.w, "ic_train_city.png", false, false, n.a.V1);
            this.E.setVisibility(0);
            this.w.setVisibility(0);
        } else if (cJRTrainOriginCityItem.getType().equalsIgnoreCase(this.k)) {
            this.s.setText(this.f27993e.getResources().getString(R.string.state));
            ResourceUtils.loadTrainImagesFromCDN(this.w, "ic_train_state.png", false, false, n.a.V1);
            this.E.setVisibility(0);
            this.w.setVisibility(0);
        } else if (TextUtils.isEmpty(cJRTrainOriginCityItem.getType()) || cJRTrainOriginCityItem.getType().equalsIgnoreCase(this.m)) {
            this.w.setVisibility(8);
            this.E.setVisibility(8);
        } else if (cJRTrainOriginCityItem.getType().equalsIgnoreCase(this.l)) {
            this.s.setText(cJRTrainOriginCityItem.getType());
            this.E.setVisibility(8);
            this.w.setVisibility(8);
            this.r.setVisibility(0);
        } else {
            this.s.setText(cJRTrainOriginCityItem.getType());
            this.E.setVisibility(0);
            this.w.setVisibility(8);
        }
    }

    public final void a(String str, boolean z2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "train_homepage");
            hashMap.put("user_id", b.n(this.f27993e) != null ? b.n(this.f27993e) : "");
            if (z2) {
                hashMap.put("event_action", d.dP);
                hashMap.put("event_label", str);
            } else {
                hashMap.put("event_action", d.dW);
                hashMap.put("event_label", str);
            }
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/station-search");
            hashMap.put(d.cv, "train");
            com.travel.train.b.a();
            com.travel.train.b.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, this.f27993e);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}
