package com.travel.train.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.b.b;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.b;
import com.travel.train.i.f;
import com.travel.train.j.i;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRBoardingStationChanged;
import com.travel.train.model.trainticket.CJRTrainBookingDetails;
import com.travel.train.model.trainticket.CJRTrainIsFavourite;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import com.travel.train.model.trainticket.CJRTrainSummaryItem;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ah extends RecyclerView.v implements b {
    private TextView A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private CJRTrainSummaryItem E;
    private CJRTrainBookingDetails F;
    private LinearLayout G;
    private LinearLayout H;
    private View I;
    private IJRDataModel J;
    private f K;
    private boolean L = false;

    /* renamed from: a  reason: collision with root package name */
    public TextView f27780a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f27781b;

    /* renamed from: c  reason: collision with root package name */
    ab f27782c;

    /* renamed from: d  reason: collision with root package name */
    CJRTrainOrderSummaryAction f27783d;

    /* renamed from: e  reason: collision with root package name */
    CJRTrainOrderSummaryAction f27784e;

    /* renamed from: f  reason: collision with root package name */
    CJRTrainOrderSummaryAction f27785f;

    /* renamed from: g  reason: collision with root package name */
    public CJRTrainIsFavourite f27786g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27787h;

    /* renamed from: i  reason: collision with root package name */
    public LottieAnimationView f27788i;
    private Context j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public ah(View view, ab abVar, f fVar) {
        super(view);
        this.f27782c = abVar;
        this.I = view;
        this.K = fVar;
        this.k = (TextView) view.findViewById(R.id.trip_txt);
        this.l = (TextView) view.findViewById(R.id.train_num_txt);
        this.m = (TextView) view.findViewById(R.id.train_pnr_txt);
        this.n = (TextView) view.findViewById(R.id.train_class_txt);
        this.o = (TextView) view.findViewById(R.id.view_route);
        this.p = (TextView) view.findViewById(R.id.view_coach);
        this.f27780a = (TextView) view.findViewById(R.id.fav_txt);
        this.q = (TextView) view.findViewById(R.id.tx_holder_txt);
        this.r = (TextView) view.findViewById(R.id.source_date);
        this.s = (TextView) view.findViewById(R.id.source_time);
        this.t = (TextView) view.findViewById(R.id.source_station);
        this.u = (TextView) view.findViewById(R.id.destination_date);
        this.v = (TextView) view.findViewById(R.id.destination_time);
        this.w = (TextView) view.findViewById(R.id.destination_station);
        this.x = (TextView) view.findViewById(R.id.duration_txt);
        this.y = (TextView) view.findViewById(R.id.num_of_stops);
        this.z = (TextView) view.findViewById(R.id.change_station_txt);
        this.B = (ImageView) view.findViewById(R.id.source_image_view);
        this.f27781b = (ImageView) view.findViewById(R.id.fav_image);
        this.f27788i = (LottieAnimationView) view.findViewById(R.id.fav_anim);
        this.G = (LinearLayout) view.findViewById(R.id.change_station_lyt);
        this.H = (LinearLayout) view.findViewById(R.id.booking_txt_holder_lyt);
        this.A = (TextView) view.findViewById(R.id.change_station_button);
        this.C = (ImageView) view.findViewById(R.id.changed_station_icon);
        this.D = (ImageView) view.findViewById(R.id.txt_holder_icon);
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (ah.this.f27785f != null) {
                    ah.this.f27782c.a(ah.this.f27785f, com.travel.train.i.ah.VIEW_ROUTE);
                }
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (ah.this.f27784e != null) {
                    ah.this.f27782c.a(ah.this.f27784e, com.travel.train.i.ah.VIEW_COACH);
                }
            }
        });
        this.f27781b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ah.a(ah.this);
            }
        });
        this.f27788i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ah.a(ah.this);
            }
        });
        this.A.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (ah.this.f27783d != null) {
                    ah.this.f27782c.a(ah.this.f27783d, com.travel.train.i.ah.CHANGE_STATION);
                }
            }
        });
    }

    public final void a(Context context, IJRDataModel iJRDataModel, int i2) {
        this.j = context;
        this.J = iJRDataModel;
        this.E = (CJRTrainSummaryItem) iJRDataModel;
        this.F = (CJRTrainBookingDetails) this.E.getItem();
        CJRTrainBookingDetails cJRTrainBookingDetails = this.F;
        if (cJRTrainBookingDetails != null) {
            if (!TextUtils.isEmpty(cJRTrainBookingDetails.getTripText())) {
                this.k.setText(this.F.getTripText());
            }
            if (!TextUtils.isEmpty(this.F.getTrainName()) && !TextUtils.isEmpty(this.F.getTrainNumber())) {
                this.l.setText(a(this.F.getTrainName() + " (" + this.F.getTrainNumber() + ")"));
            }
            if (!TextUtils.isEmpty(this.F.getPnr())) {
                TextView textView = this.m;
                textView.setText("PNR - " + this.F.getPnr());
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.F.getClass_())) {
                sb.append(this.F.getClass_());
            }
            if (!TextUtils.isEmpty(this.F.getQuota())) {
                sb.append(" | ");
                sb.append(this.F.getQuota());
            }
            this.n.setText(sb);
            if (!TextUtils.isEmpty(this.F.getSourceDepartureDate())) {
                this.r.setText(i.c(this.F.getDepartureDate()));
            }
            if (!TextUtils.isEmpty(this.F.getSourceDepartureTime())) {
                this.s.setText(this.F.getBoardingTime());
            }
            if (!TextUtils.isEmpty(this.F.getBoardingStationName())) {
                this.t.setText(a(this.F.getBoardingStationName()) + " (" + this.F.getBoardingStationCode() + ")");
            }
            if (!TextUtils.isEmpty(this.F.getArrivalDate())) {
                this.u.setText(i.c(this.F.getArrivalDate()));
            }
            if (!TextUtils.isEmpty(this.F.getArrivalTime())) {
                this.v.setText(this.F.getArrivalTime());
            }
            if (!TextUtils.isEmpty(this.F.getDestinationStationName())) {
                this.w.setText(a(this.F.getDestinationStationName()) + " (" + this.F.getDestinationStationCode() + ")");
            }
            if (!TextUtils.isEmpty(this.F.getTravelTime())) {
                this.x.setText(this.F.getTravelTime());
            }
            if (!TextUtils.isEmpty(this.F.getNoOfStops())) {
                if (!this.F.getNoOfStops().equalsIgnoreCase("0")) {
                    this.y.setVisibility(0);
                    this.y.setText(this.F.getNoOfStops());
                } else {
                    this.y.setVisibility(8);
                }
            }
            if (this.F.getBackgroundImage() != null && URLUtil.isValidUrl(this.F.getBackgroundImage())) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                a2.f43753a = this.F.getBackgroundImage();
                a2.m = true;
                a2.a(this.B);
            }
            if (!this.L) {
                this.f27786g = this.F.getIsFavourite();
                CJRTrainIsFavourite cJRTrainIsFavourite = this.f27786g;
                if (cJRTrainIsFavourite != null && cJRTrainIsFavourite.getEnabled().booleanValue()) {
                    this.f27780a.setVisibility(0);
                    this.f27780a.setText(this.f27786g.getDescription());
                    this.f27787h = true;
                    if (this.f27786g.getValue().booleanValue()) {
                        this.f27781b.setVisibility(8);
                        this.f27788i.setVisibility(0);
                        a();
                        this.L = true;
                    } else {
                        this.f27788i.setProgress(0.0f);
                        ResourceUtils.loadTrainImagesFromCDN(this.f27781b, "fav_unselect.png", false, false, n.a.V1);
                        this.f27781b.setVisibility(0);
                        this.f27788i.setVisibility(8);
                    }
                }
            }
            b();
            CJRBoardingStationChanged boardingStationChanged = this.F.getBoardingStationChanged();
            if (boardingStationChanged != null && boardingStationChanged.getVisible()) {
                this.G.setVisibility(0);
                this.z.setText(boardingStationChanged.getTextHolder().getText());
            }
            if (boardingStationChanged.getTextHolder().getIcon() == null || !URLUtil.isValidUrl(boardingStationChanged.getTextHolder().getIcon())) {
                ResourceUtils.loadTrainImagesFromCDN(this.C, "change_station.png", false, false, n.a.V1);
            } else {
                b.a.C0750a a3 = com.paytm.utility.b.b.a(this.j);
                a3.f43753a = boardingStationChanged.getTextHolder().getIcon();
                a3.a(this.C);
            }
            if (this.F.getTextHolder() != null && !TextUtils.isEmpty(this.F.getTextHolder().getText()) && !TextUtils.isEmpty(this.F.getTextHolder().getIcon())) {
                this.H.setVisibility(0);
                this.q.setText(this.F.getTextHolder().getText());
                b.a.C0750a a4 = com.paytm.utility.b.b.a(this.j);
                a4.f43753a = this.F.getTextHolder().getIcon();
                a4.a(this.D);
            }
        }
    }

    private void b() {
        ArrayList<CJRTrainOrderSummaryAction> bookingActions = this.F.getBookingActions();
        if (bookingActions != null) {
            Iterator<CJRTrainOrderSummaryAction> it2 = bookingActions.iterator();
            while (it2.hasNext()) {
                CJRTrainOrderSummaryAction next = it2.next();
                if (next != null) {
                    if (next.getmTrainActionName().equalsIgnoreCase("coach_layout")) {
                        this.f27784e = next;
                        this.p.setVisibility(0);
                        this.p.setText(next.getLabel());
                    } else if (next.getmTrainActionName().equalsIgnoreCase("view_schedule")) {
                        this.o.setVisibility(0);
                        this.o.setText(next.getLabel());
                        this.f27785f = next;
                    } else if (next.getmTrainActionName().equalsIgnoreCase("boarding_station")) {
                        this.f27783d = next;
                        this.A.setVisibility(0);
                        this.A.setText(next.getLabel());
                    }
                }
            }
        }
    }

    public final void a() {
        String c2 = o.c(this.j, "favourite_anim.json");
        if (!TextUtils.isEmpty(c2)) {
            this.f27788i.setAnimationFromJson(c2, (String) null);
            this.f27788i.setSpeed(1.0f);
            if (this.f27788i.getProgress() == 0.0f) {
                this.f27788i.playAnimation();
            } else {
                this.f27788i.setProgress(0.0f);
            }
        }
    }

    private static String a(String str) {
        if (str.length() == 0) {
            return "";
        }
        String str2 = "" + Character.toUpperCase(str.charAt(0));
        for (int i2 = 1; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (str.charAt(i2 - 1) == ' ') {
                str2 = str2 + Character.toUpperCase(charAt);
            } else {
                str2 = str2 + Character.toLowerCase(charAt);
            }
        }
        return str2;
    }

    static /* synthetic */ void a(ah ahVar) {
        if (ahVar.f27786g.getValue().booleanValue()) {
            ahVar.f27786g.setValue(Boolean.FALSE);
        } else {
            ahVar.f27786g.setValue(Boolean.TRUE);
        }
        f fVar = ahVar.K;
        if (fVar != null) {
            fVar.a(ahVar);
        }
        ahVar.f27782c.a(ahVar.f27786g, com.travel.train.i.ah.FAVOURITE_CLICK);
    }
}
