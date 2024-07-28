package com.travel.bus.busticket.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.google.firebase.crashlytics.c;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.travel.bus.busticket.i.o;
import com.travel.bus.pojo.busticket.CJRBusNpsTrackingResponse;
import com.travel.bus.pojo.busticket.CJRBusRating;
import com.travel.bus.pojo.busticket.CJRBusRatingInfo;
import com.travel.bus.pojo.busticket.CJRBusRnRHome;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.HashMap;
import net.one97.paytm.i.f;
import org.json.JSONException;
import org.json.JSONObject;

public class n extends f implements View.OnClickListener, b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BottomSheetBehavior f22343a;

    /* renamed from: b  reason: collision with root package name */
    private CJRBusRnRHome f22344b;

    /* renamed from: c  reason: collision with root package name */
    private Context f22345c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f22346d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f22347e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22348f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f22349g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f22350h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f22351i;
    private ImageView j;
    private ImageView k;
    private RoboTextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private int q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private ProgressDialog w;
    private boolean x = false;

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                frameLayout.setBackgroundDrawable(new ColorDrawable(0));
                if (frameLayout != null) {
                    BottomSheetBehavior unused = n.this.f22343a = BottomSheetBehavior.from(frameLayout);
                }
                n.this.f22343a.setBottomSheetCallback(new BottomSheetBehavior.a() {
                    public final void onSlide(View view, float f2) {
                    }

                    public final void onStateChanged(View view, int i2) {
                        if (i2 == 1) {
                            n.this.f22343a.setState(3);
                        }
                        if (i2 == 5 && n.this.getDialog() != null) {
                            n.this.getDialog().dismiss();
                        }
                    }
                });
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    public void show(j jVar, String str) {
        try {
            q a2 = jVar.a();
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.travel.bus.R.layout.bus_new_home_rnr, viewGroup, false);
    }

    public static n a() {
        return new n();
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (!(getArguments() == null || getArguments().getSerializable("bus-rating") == null)) {
            this.f22344b = (CJRBusRnRHome) getArguments().getSerializable("bus-rating");
        }
        if (!(getArguments() == null || getArguments().getSerializable("bus-from-rnr-home") == null)) {
            this.x = getArguments().getBoolean("bus-from-rnr-home");
        }
        this.f22345c = getActivity();
        this.l = (RoboTextView) view.findViewById(com.travel.bus.R.id.rating_text1);
        this.f22351i = (ImageView) view.findViewById(com.travel.bus.R.id.close_button);
        this.m = (TextView) view.findViewById(com.travel.bus.R.id.city_src);
        this.n = (TextView) view.findViewById(com.travel.bus.R.id.city_des);
        this.p = (TextView) view.findViewById(com.travel.bus.R.id.txt_operator_name);
        this.o = (TextView) view.findViewById(com.travel.bus.R.id.travel_date);
        this.j = (ImageView) view.findViewById(com.travel.bus.R.id.arrow_image);
        ResourceUtils.loadBusImagesFromCDN(this.j, "right_arrow.png", false, true, n.a.V1);
        this.k = (ImageView) view.findViewById(com.travel.bus.R.id.bus_image);
        this.f22346d = (ImageView) view.findViewById(com.travel.bus.R.id.rating1);
        this.f22347e = (ImageView) view.findViewById(com.travel.bus.R.id.rating2);
        this.f22348f = (ImageView) view.findViewById(com.travel.bus.R.id.rating3);
        this.f22349g = (ImageView) view.findViewById(com.travel.bus.R.id.rating4);
        this.f22350h = (ImageView) view.findViewById(com.travel.bus.R.id.rating5);
        ResourceUtils.loadBusImagesFromCDN(this.k, "rating_icon.png", false, false, n.a.V1);
        this.f22346d.setOnClickListener(this);
        this.f22347e.setOnClickListener(this);
        this.f22348f.setOnClickListener(this);
        this.f22349g.setOnClickListener(this);
        this.f22350h.setOnClickListener(this);
        this.f22351i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                n.this.a(view);
            }
        });
        CJRBusRatingInfo ratingInfo = this.f22344b.getRatingInfo();
        if (ratingInfo != null) {
            this.s = ratingInfo.getSecret();
            this.u = ratingInfo.getChannel();
            this.t = ratingInfo.getOrder_id();
            this.v = ratingInfo.getTravels_name();
            String date_of_journey = ratingInfo.getDate_of_journey();
            getActivity();
            String f2 = com.paytm.utility.b.f(date_of_journey, "yyyy-MM-dd", "EEEE, d MMMM");
            this.m.setText(ratingInfo.getSource());
            this.n.setText(ratingInfo.getDestination());
            this.o.setText(f2);
            this.p.setText(this.v);
        }
        super.onViewCreated(view, bundle);
    }

    public void onClick(View view) {
        int id = view.getId();
        StringBuilder sb = new StringBuilder(getString(com.travel.bus.R.string.you_rated_bus) + " ");
        this.f22346d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        this.f22347e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        this.f22348f.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        this.f22349g.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        this.f22350h.setImageResource(com.travel.bus.R.drawable.bus_rating_star_normal);
        if (id == com.travel.bus.R.id.rating1) {
            this.q = 1;
            this.f22346d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            sb.append(getString(com.travel.bus.R.string.poor));
        } else if (id == com.travel.bus.R.id.rating2) {
            this.q = 2;
            this.f22346d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22347e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            sb.append(getString(com.travel.bus.R.string.bad));
        } else if (id == com.travel.bus.R.id.rating3) {
            this.q = 3;
            this.f22346d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22347e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22348f.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            sb.append(getString(com.travel.bus.R.string.avergae));
        } else if (id == com.travel.bus.R.id.rating4) {
            this.q = 4;
            this.f22346d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22347e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22348f.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22349g.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            sb.append(getString(com.travel.bus.R.string.good));
        } else if (id == com.travel.bus.R.id.rating5) {
            this.q = 5;
            this.f22346d.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22347e.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22348f.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22349g.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            this.f22350h.setImageResource(com.travel.bus.R.drawable.bus_rating_star_yellow);
            sb.append(getString(com.travel.bus.R.string.awesome));
        }
        this.l.setText(sb.toString());
        com.travel.bus.a.a();
        this.r = com.travel.bus.a.b().f("busRatings");
        this.r = Uri.parse(this.r).buildUpon().appendQueryParameter("r", String.valueOf(this.q)).appendQueryParameter("s", this.s).appendQueryParameter(ContactsConstant.LOCALE, com.paytm.utility.b.g()).build().toString();
        if (com.paytm.utility.b.c((Context) getActivity())) {
            FragmentActivity activity = getActivity();
            String string = getResources().getString(com.travel.bus.R.string.please_wait_progress_msg);
            this.w = new ProgressDialog(activity);
            try {
                this.w.setProgressStyle(0);
                this.w.setMessage(string);
                this.w.setCancelable(true);
                this.w.setCanceledOnTouchOutside(false);
                this.w.show();
            } catch (IllegalArgumentException e2) {
                if (com.paytm.utility.b.v) {
                    com.paytm.utility.q.c(e2.getMessage());
                }
            } catch (Exception unused) {
            }
            o.a((Context) getActivity(), this.q, this.s, this.u);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getActivity();
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = this.r;
            bVar.f42881e = null;
            bVar.f42882f = null;
            bVar.f42883g = null;
            bVar.f42885i = new CJRBusRating();
            bVar.j = this;
            bVar.n = a.b.SILENT;
            bVar.o = "bus-rating-page";
            bVar.l().a();
        }
    }

    private void b() {
        try {
            if (this.w != null && this.w.isShowing() && !isDetached()) {
                this.w.dismiss();
                this.w = null;
            }
        } catch (Exception e2) {
            c.a().a((Throwable) e2);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (getActivity() != null) {
            b();
            dismiss();
            com.travel.bus.busticket.activity.a a2 = com.travel.bus.busticket.activity.a.a();
            a2.setCancelable(false);
            Bundle bundle = new Bundle();
            bundle.putInt("star_count", this.q);
            bundle.putString("secretKey", this.s);
            bundle.putString("orderID", this.t);
            bundle.putString("channel", this.u);
            bundle.putString("operator_name", this.v);
            bundle.putBoolean("bus-from-rnr-home", this.x);
            a2.setArguments(bundle);
            a2.show(getActivity().getSupportFragmentManager(), "ratingScreenBottomSheet");
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        dismiss();
        b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        CJRBusRnRHome cJRBusRnRHome = this.f22344b;
        if (!(cJRBusRnRHome == null || cJRBusRnRHome.getRatingInfo() == null)) {
            com.travel.bus.a.a();
            String f2 = com.travel.bus.a.b().f("travelCancelRnR");
            if (TextUtils.isEmpty(f2)) {
                f2 = "https://travel-dev.paytm.com/api/travel/rnr/v1/rating/cancel";
            }
            if (!TextUtils.isEmpty(f2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("paytm_trip_id", this.f22344b.getRatingInfo().getPaytm_trip_id());
                    jSONObject.put("order_id", this.f22344b.getRatingInfo().getOrder_id());
                } catch (JSONException e2) {
                    com.paytm.utility.q.c(e2.getMessage());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                if (com.paytm.utility.b.c(this.f22345c)) {
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this.f22345c;
                    bVar.f42878b = a.c.BUS;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.f42880d = f2;
                    bVar.f42884h = jSONObject.toString();
                    bVar.f42881e = null;
                    bVar.f42882f = hashMap;
                    bVar.f42883g = null;
                    bVar.f42885i = new CJRBusNpsTrackingResponse();
                    bVar.j = new b() {
                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        }

                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        }
                    };
                    bVar.t = null;
                    bVar.n = a.b.SILENT;
                    bVar.o = "bus-order-summary-page";
                    bVar.l().a();
                }
            }
        }
        dismiss();
    }
}
