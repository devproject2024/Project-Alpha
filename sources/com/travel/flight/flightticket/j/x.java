package com.travel.flight.flightticket.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem;
import com.travel.flight.pojo.model.CJRSeatSelection;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.utils.n;
import java.util.Iterator;

public final class x extends RecyclerView.v {
    public boolean A = false;
    public TableRow B;
    public TableRow C;
    public TableRow D;
    public TableRow E;
    public TableRow F;
    public boolean G = false;
    public String H = "";
    public boolean I = false;
    public TableRow J;
    public TextView K;
    public boolean L;
    public CJRTravellerSeatTransition M;
    public TextView N;
    public ViewGroup O;
    public ViewGroup P;
    public TextView Q;
    private TextView R;
    private TableRow S;
    private ImageView T;
    private TextView U;
    private TextView V;
    private TableRow W;
    private TextView X;
    private ImageView Y;

    /* renamed from: a  reason: collision with root package name */
    public TextView f25230a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25231b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25232c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25233d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25234e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25235f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25236g;

    /* renamed from: h  reason: collision with root package name */
    public TableRow f25237h;

    /* renamed from: i  reason: collision with root package name */
    public TableRow f25238i;
    public TextView j;
    public TextView k;
    public CJRFlightDetails l;
    public Context m;
    public double n;
    public double o;
    public double p;
    public float q;
    public float r;
    public TableRow s;
    public TextView t;
    public boolean u;
    public Resources v;
    k w;
    public TextView x;
    public LinearLayout y;
    public TextView z;

    public x(Activity activity, View view, k kVar) {
        super(view);
        this.w = kVar;
        this.m = activity;
        this.v = activity.getResources();
        this.f25231b = (TextView) view.findViewById(R.id.txt_passenger_details);
        this.f25232c = (TextView) view.findViewById(R.id.text_base_fare);
        this.f25233d = (TextView) view.findViewById(R.id.text_taxes_fees);
        this.f25234e = (TextView) view.findViewById(R.id.text_seat_amount);
        this.f25237h = (TableRow) view.findViewById(R.id.seat_amount_row);
        this.f25235f = (TextView) view.findViewById(R.id.text_total_fare);
        this.f25230a = (TextView) view.findViewById(R.id.text_convience_fee);
        this.f25238i = (TableRow) view.findViewById(R.id.table_row_flight_bundle);
        this.j = (TextView) view.findViewById(R.id.txt_package_header);
        this.k = (TextView) view.findViewById(R.id.txt_package_amount);
        this.s = (TableRow) view.findViewById(R.id.tv_cash_back_container);
        this.t = (TextView) view.findViewById(R.id.tv_paytm_cashback_value);
        this.R = (TextView) view.findViewById(R.id.total_insurance);
        this.S = (TableRow) view.findViewById(R.id.insurance_row);
        this.T = (ImageView) view.findViewById(R.id.image_view_conv_fee_info);
        this.x = (TextView) view.findViewById(R.id.text_total_air_fare);
        this.U = (TextView) view.findViewById(R.id.travelInsuranceHeader);
        this.z = (TextView) view.findViewById(R.id.txt_flight_exclude_conv_fee_msg);
        this.E = (TableRow) view.findViewById(R.id.table_row_flight_modification);
        this.f25236g = (TextView) view.findViewById(R.id.text_modification_fee);
        this.y = (LinearLayout) view.findViewById(R.id.linear_exclude_flight_conv_fee);
        this.B = (TableRow) view.findViewById(R.id.table_row_flight_convfee);
        this.C = (TableRow) view.findViewById(R.id.table_row_flight_grandTotal);
        this.D = (TableRow) view.findViewById(R.id.table_row_flight_line);
        this.F = (TableRow) view.findViewById(R.id.lineAboveNotes);
        this.V = (TextView) view.findViewById(R.id.cancel_protect_total_insurance);
        this.W = (TableRow) view.findViewById(R.id.cancel_protect_insurance_row);
        this.X = (TextView) view.findViewById(R.id.cancel_protect_insurance_rate_per_traveller);
        b.a();
        this.I = b.b().w();
        this.J = (TableRow) view.findViewById(R.id.table_row_flight_ancillary);
        this.K = (TextView) view.findViewById(R.id.text_ancillary_amount);
        this.Y = (ImageView) view.findViewById(R.id.image_view_ancillary_info);
        this.T.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (x.this.w != null) {
                    x.this.w.reviewIternaryActionClick("", (Intent) null, (Boolean) null, c.CONVENIENCE_FEE_DETAILS);
                }
            }
        });
        this.Y.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (x.this.w != null) {
                    x.this.w.reviewIternaryActionClick("", (Intent) null, (Boolean) null, c.ANCILLARY_DETAILS);
                }
            }
        });
        this.N = (TextView) view.findViewById(R.id.tv_paytm_instant_discount_value);
        this.O = (ViewGroup) view.findViewById(R.id.tr_instant_discount_container);
        this.P = (ViewGroup) view.findViewById(R.id.tr_bank_cash_back_container);
        this.Q = (TextView) view.findViewById(R.id.tv_bank_cashback_value);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) view.findViewById(R.id.iv_flight_note_icon), "note_icon.png", false, false, n.a.V1);
    }

    public static boolean a(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (!(cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null)) {
            Iterator<CJRSeatSelection> it2 = cJRTravellerSeatTransition.getOnwardSeatSelections().iterator();
            while (it2.hasNext()) {
                CJRSeatSelection next = it2.next();
                if (next != null && next.getmSelectedSeatsCount() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(CJRInsuranceBody cJRInsuranceBody, boolean z2) {
        String str;
        double totalPremium = cJRInsuranceBody.getInsuranceDetail().get(0).getTotalPremium();
        CJRInsuranceItem cJRInsuranceItem = cJRInsuranceBody.getInsuranceDetail().get(0);
        if (!cJRInsuranceItem.isOne_way_international() || cJRInsuranceItem.getUserInputInfo() == null) {
            str = String.format(this.m.getString(R.string.flight_travel_insurance_fare_details_not_one_way_intl), new Object[]{(cJRInsuranceItem.getPriceDetails() == null || cJRInsuranceItem.getPriceDetails().get(0) == null) ? "" : cJRInsuranceItem.getPriceDetails().get(0).getPremiumPerPassenger()});
        } else {
            totalPremium *= (double) cJRInsuranceItem.getUserInputInfo().getSelectedDays();
            str = String.format(this.m.getString(R.string.flight_travel_insurance_fare_details_one_way_intl), new Object[]{String.valueOf((int) cJRInsuranceItem.getUserInputInfo().getPremium_per_day()), String.valueOf(cJRInsuranceItem.getUserInputInfo().getSelectedDays())});
        }
        if (z2) {
            this.p += totalPremium;
            this.f25235f.setText(this.v.getString(R.string.rs_symbol) + " " + com.travel.flight.utils.c.a(this.p));
            this.S.setVisibility(0);
            this.R.setText(this.m.getResources().getString(R.string.rs_symbol) + " " + com.travel.flight.utils.c.a(totalPremium));
            String string = this.m.getString(R.string.flight_travel_insurance);
            String str2 = string + str;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this.m, R.color.color_323232)), 0, string.length() - 1, 0);
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(this.m, R.color.color_afafaf)), string.length(), str2.length(), 0);
            this.U.setText(spannableString);
            return;
        }
        this.S.setVisibility(8);
        this.p -= totalPremium;
        this.f25235f.setText(this.v.getString(R.string.rs_symbol) + " " + com.travel.flight.utils.c.a(this.p));
    }

    public final void a(double d2, boolean z2, String str) {
        this.G = z2;
        if (z2) {
            this.H = str;
            this.p += d2;
            this.f25235f.setText(this.v.getString(R.string.rs_symbol) + " " + com.travel.flight.utils.c.a(this.p));
            this.W.setVisibility(0);
            this.V.setText(this.m.getResources().getString(R.string.rs_symbol) + " " + com.travel.flight.utils.c.a(d2));
            this.X.setText(" (" + str + ")");
            return;
        }
        this.W.setVisibility(8);
        this.p -= d2;
        this.f25235f.setText(this.v.getString(R.string.rs_symbol) + " " + com.travel.flight.utils.c.a(this.p));
    }

    public final double a() {
        double d2 = 0.0d;
        for (int i2 = 0; i2 < this.M.getOnwardSeatSelections().size(); i2++) {
            CJRSeatSelection cJRSeatSelection = this.M.getOnwardSeatSelections().get(i2);
            if (cJRSeatSelection != null) {
                d2 += cJRSeatSelection.getmTotalSeatPrice();
            }
        }
        return d2;
    }
}
