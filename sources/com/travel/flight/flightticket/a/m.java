package com.travel.flight.flightticket.a;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.h;
import com.travel.flight.flightticket.g.g;
import com.travel.flight.flightticket.j.aa;
import com.travel.flight.flightticket.j.ab;
import com.travel.flight.flightticket.j.ad;
import com.travel.flight.flightticket.j.ae;
import com.travel.flight.flightticket.j.d;
import com.travel.flight.flightticket.j.k;
import com.travel.flight.flightticket.j.l;
import com.travel.flight.flightticket.j.v;
import com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRDisplayElements;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRTravellerDetails;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel;
import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger;
import com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import java.util.ArrayList;

public final class m extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ae f24702a;

    /* renamed from: b  reason: collision with root package name */
    public int f24703b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f24704c;

    /* renamed from: d  reason: collision with root package name */
    private CJRFlightDetails f24705d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f24706e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a> f24707f;

    /* renamed from: g  reason: collision with root package name */
    private ad f24708g;

    /* renamed from: h  reason: collision with root package name */
    private com.travel.flight.flightticket.j.a f24709h;

    /* renamed from: i  reason: collision with root package name */
    private h f24710i;
    private k j;
    private int k = 0;
    private String l = "";

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00aa, code lost:
        if (r4 != false) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m(android.app.Activity r3, com.travel.flight.pojo.flightticket.CJRFlightDetails r4, java.lang.String r5, int r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.k = r0
            java.lang.String r1 = ""
            r2.l = r1
            r2.f24703b = r0
            r2.f24705d = r4
            r2.f24706e = r3
            r2.f24704c = r5
            com.travel.flight.flightticket.f.h r3 = (com.travel.flight.flightticket.f.h) r3
            r2.f24710i = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.f24707f = r3
            r2.k = r6
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "htmlBox"
            r3.f24711a = r4
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r2.f24705d
            java.lang.String r4 = r4.getmTravelerDetailsInfoBoxHtml()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0039
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
        L_0x0039:
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "travellerItem"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            r4 = 1
            if (r3 == 0) goto L_0x0061
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmOnwardJourney()
            if (r3 == 0) goto L_0x0061
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmOnwardJourney()
            boolean r3 = r3.isAncillaryEligible()
            if (r3 == 0) goto L_0x0061
        L_0x005f:
            r3 = 1
            goto L_0x0079
        L_0x0061:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            if (r3 == 0) goto L_0x0078
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmReturnJourney()
            if (r3 == 0) goto L_0x0078
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmReturnJourney()
            boolean r3 = r3.isAncillaryEligible()
            if (r3 == 0) goto L_0x0078
            goto L_0x005f
        L_0x0078:
            r3 = 0
        L_0x0079:
            if (r3 != 0) goto L_0x00ac
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmOnwardJourney()
            if (r3 == 0) goto L_0x0098
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmOnwardJourney()
            boolean r3 = r3.isSeatAncillaryEligible()
            if (r3 == 0) goto L_0x0098
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmReturnJourney()
            if (r3 != 0) goto L_0x0098
            goto L_0x00aa
        L_0x0098:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmReturnJourney()
            if (r3 == 0) goto L_0x00a9
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmReturnJourney()
            r3.isSeatAncillaryEligible()
        L_0x00a9:
            r4 = 0
        L_0x00aa:
            if (r4 == 0) goto L_0x00ba
        L_0x00ac:
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "cumilativeAncillary"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
        L_0x00ba:
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "travellerItemExtended"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightReviewGst r3 = r3.getGst()
            if (r3 == 0) goto L_0x00dc
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRFlightReviewGst r3 = r3.getGst()
            boolean r3 = r3.isEnabled()
            goto L_0x00dd
        L_0x00dc:
            r3 = 0
        L_0x00dd:
            if (r3 == 0) goto L_0x0113
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            if (r3 == 0) goto L_0x0113
            com.travel.flight.pojo.flightticket.CJRMeta r3 = r3.getMeta()
            if (r3 == 0) goto L_0x0113
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRMeta r3 = r3.getMeta()
            com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPaxInfo r3 = r3.getCJRDynamicPaxInfo()
            if (r3 == 0) goto L_0x0113
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRMeta r3 = r3.getMeta()
            com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPaxInfo r3 = r3.getCJRDynamicPaxInfo()
            com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger r3 = r3.getGst()
            if (r3 == 0) goto L_0x0113
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "gstItem"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
        L_0x0113:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r3 = r3.getInsuranceData()
            if (r3 == 0) goto L_0x016d
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r3 = r3.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r3 = r3.getBody()
            if (r3 == 0) goto L_0x016d
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r3 = r3.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r3 = r3.getBody()
            java.util.List r3 = r3.getInsuranceDetail()
            if (r3 == 0) goto L_0x016d
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r3 = r3.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r3 = r3.getBody()
            java.util.List r3 = r3.getInsuranceDetail()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x016d
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r3 = r3.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r3 = r3.getBody()
            java.util.List r3 = r3.getInsuranceDetail()
            java.lang.Object r3 = r3.get(r0)
            if (r3 == 0) goto L_0x016d
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "paytmInsurance"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
        L_0x016d:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            boolean r3 = r3.isInsuranceCancelProtectApplied()
            if (r3 == 0) goto L_0x0183
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "cancelProtectInsurance"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
        L_0x0183:
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "convenience_fee_strip"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
            com.travel.flight.flightticket.a.m$a r3 = new com.travel.flight.flightticket.a.m$a
            r3.<init>(r2, r0)
            java.lang.String r4 = "paytmLogo"
            r3.f24711a = r4
            java.util.ArrayList<com.travel.flight.flightticket.a.m$a> r4 = r2.f24707f
            r4.add(r3)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            com.travel.flight.pojo.flightticket.CJRConvenienceFee r3 = r3.getmConvenienceFee()
            if (r3 == 0) goto L_0x01ad
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r2.f24705d
            int r0 = com.travel.flight.utils.c.a((com.travel.flight.pojo.flightticket.CJRFlightDetails) r3)
        L_0x01ad:
            double r3 = (double) r0
            java.lang.String r3 = com.travel.flight.utils.c.a((double) r3)
            r2.l = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.a.m.<init>(android.app.Activity, com.travel.flight.pojo.flightticket.CJRFlightDetails, java.lang.String, int):void");
    }

    public final int getItemCount() {
        return this.f24707f.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("htmlBox")) {
            return 12;
        }
        if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("travellerItem")) {
            return 0;
        }
        if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("travellerItemExtended")) {
            return 13;
        }
        if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("gstItem")) {
            return 1;
        }
        if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("paytmInsurance")) {
            this.f24703b = i2;
            return 3;
        } else if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("paytmLogo")) {
            return 5;
        } else {
            if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("convenience_fee_strip")) {
                return 15;
            }
            if (this.f24707f.get(i2).f24711a.equalsIgnoreCase("cancelProtectInsurance")) {
                return 8;
            }
            return this.f24707f.get(i2).f24711a.equalsIgnoreCase("cumilativeAncillary") ? 14 : 2;
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            this.f24702a = new ae(this.f24706e, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_item_traveller_details, viewGroup, false), this.f24710i);
            ae aeVar = this.f24702a;
            CJRFlightDetails cJRFlightDetails = this.f24705d;
            String str = this.f24704c;
            aeVar.f25095g = cJRFlightDetails.getmIsInternational();
            aeVar.o = str;
            if (aeVar.f25095g == null) {
                aeVar.f25095g = Boolean.FALSE;
            }
            g gVar = aeVar.f25091c;
            gVar.f25032b = cJRFlightDetails;
            gVar.f25038h = str;
            return this.f24702a;
        } else if (i2 == 13) {
            this.f24708g = new ad(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_item_traveller_details_extension, viewGroup, false), this.f24710i, this.f24706e.getApplicationContext());
            return this.f24708g;
        } else {
            CJRAncillaryDisplayElement cJRAncillaryDisplayElement = null;
            if (i2 == 14) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_new_flight_ancillary_reviewitenary, viewGroup, false);
                CJRDisplayElements display_elements = (this.f24705d.getMeta() == null || this.f24705d.getMeta().getmSeats() == null) ? null : this.f24705d.getMeta().getmSeats().getDisplay_elements();
                if (!(this.f24705d.getMeta() == null || this.f24705d.getMeta().getmAncillaryText() == null)) {
                    cJRAncillaryDisplayElement = this.f24705d.getMeta().getmAncillaryText().getDisplayElement();
                }
                this.f24709h = new com.travel.flight.flightticket.j.a(inflate, this.f24705d, this.f24710i, display_elements, cJRAncillaryDisplayElement);
                return this.f24709h;
            } else if (i2 == 1) {
                this.j = new k(this.f24706e, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flights_gst_details_layout, viewGroup, false), this.f24705d.getMeta().getCJRDynamicPaxInfo().getGst());
                return this.j;
            } else if (i2 == 3) {
                return new aa(this.f24706e, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_item_paytm_insurance, viewGroup, false), this.f24710i);
            } else if (i2 == 5) {
                return new ab(this.f24706e, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_item_paytm_logo, viewGroup, false), this.f24710i);
            } else if (i2 == 15) {
                return new v(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_convenience_fee_info, viewGroup, false));
            } else {
                if (i2 == 8) {
                    if (!(this.f24705d.getInsuranceData() == null || this.f24705d.getInsuranceData().getBody() == null || this.f24705d.getInsuranceData().getBody().getCancelProtectInsuranceDetail() == null || this.f24705d.getInsuranceData().getBody().getCancelProtectInsuranceDetail().size() <= 0)) {
                        return new d(this.f24706e, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_cancel_protect_insurance, viewGroup, false), this.f24705d.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0), this.f24710i, this.f24705d.isInsuranceCancelProtectApplied());
                    }
                } else if (i2 == 12) {
                    return new l(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_item_html_box, viewGroup, false), this.f24706e, "traveler_detail");
                }
                return null;
            }
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        try {
            if (vVar instanceof ae) {
                ae aeVar = (ae) vVar;
                g gVar = aeVar.f25091c;
                String str2 = "";
                gVar.f25033c = Integer.parseInt(gVar.f25032b.getmMetaDetails().getQuery().getAdults());
                if (gVar.f25033c > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(gVar.f25033c);
                    sb.append(gVar.f25033c == 1 ? " Adult" : " Adults");
                    str2 = sb.toString();
                    gVar.f25036f += gVar.f25033c;
                }
                gVar.f25034d = Integer.parseInt(gVar.f25032b.getmMetaDetails().getQuery().getChildren());
                if (gVar.f25034d > 1) {
                    str2 = str2 + ", " + gVar.f25034d + " Children";
                    gVar.f25036f += gVar.f25034d;
                } else if (gVar.f25034d == 1) {
                    str2 = str2 + ", " + gVar.f25034d + " " + gVar.f25031a.getString(R.string.child);
                    gVar.f25036f += gVar.f25034d;
                }
                gVar.f25035e = Integer.parseInt(gVar.f25032b.getmMetaDetails().getQuery().getInfants());
                if (gVar.f25035e > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(", ");
                    sb2.append(gVar.f25035e);
                    sb2.append(gVar.f25035e == 1 ? " Infant" : " Infants");
                    gVar.f25036f += gVar.f25035e;
                }
                aeVar.f25091c.a();
                aeVar.b();
            } else if (vVar instanceof k) {
                this.j = (k) vVar;
            } else if (vVar instanceof v) {
                String str3 = this.l;
                TextView textView = (TextView) ((v) vVar).itemView;
                textView.setText(textView.getContext().getString(R.string.convenience_fee_info_strip, new Object[]{str3}));
            } else if (vVar instanceof aa) {
                aa aaVar = (aa) vVar;
                CJRInsuranceModel insuranceData = this.f24705d.getInsuranceData();
                if (insuranceData != null && insuranceData.getBody() != null && insuranceData.getBody().getInsuranceDetail() != null && insuranceData.getBody().getInsuranceDetail().size() > 0) {
                    CJRInsuranceItem cJRInsuranceItem = insuranceData.getBody().getInsuranceDetail().get(0);
                    if (!TextUtils.isEmpty(cJRInsuranceItem.getTitle())) {
                        aaVar.f25052c.setText(cJRInsuranceItem.getTitle());
                    }
                    if (!TextUtils.isEmpty(cJRInsuranceItem.getInsuranceProvider())) {
                        aaVar.f25051b.setText(String.format(aaVar.f25050a.getResources().getString(R.string.flight_travel_insurance_sold_by), new Object[]{cJRInsuranceItem.getInsuranceProvider()}));
                    }
                    CJRInsuranceItem cJRInsuranceItem2 = insuranceData.getBody().getInsuranceDetail().get(0);
                    if (!cJRInsuranceItem2.isOne_way_international() || cJRInsuranceItem2.getUserInputInfo() == null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cJRInsuranceItem2.getTotalPremium());
                        String sb4 = sb3.toString();
                        if (!(cJRInsuranceItem2.getPriceDetails() == null || cJRInsuranceItem2.getPriceDetails().get(0) == null || cJRInsuranceItem2.getPriceDetails().get(0).getPremiumPerPassenger() == null)) {
                            sb4 = cJRInsuranceItem2.getPriceDetails().get(0).getPremiumPerPassenger();
                        }
                        str = String.format(aaVar.f25050a.getString(R.string.flight_travel_insurance_header_not_one_way_intl), new Object[]{sb4});
                    } else {
                        if (!TextUtils.isEmpty(cJRInsuranceItem2.getUserInputInfo().getDefault_insured_days())) {
                            aaVar.f25056g = Integer.parseInt(cJRInsuranceItem2.getUserInputInfo().getDefault_insured_days());
                        }
                        if (cJRInsuranceItem2.getUserInputInfo().getSelectedDays() != 0) {
                            aaVar.f25056g = cJRInsuranceItem2.getUserInputInfo().getSelectedDays();
                        }
                        str = String.format(aaVar.f25050a.getString(R.string.flight_travel_insurance_header_one_way_intl), new Object[]{String.valueOf((int) (((double) aaVar.f25056g) * cJRInsuranceItem2.getUserInputInfo().getPremium_per_day())), Integer.valueOf(aaVar.f25056g)});
                    }
                    aa.AnonymousClass2 r3 = new ClickableSpan(cJRInsuranceItem) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ CJRInsuranceItem f25058a;

                        {
                            this.f25058a = r2;
                        }

                        public final void onClick(View view) {
                            if (this.f25058a.getTnc() != null) {
                                aa.this.f25055f.a(Boolean.FALSE, c.INSURANCE_TnC);
                            }
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(Color.parseColor("#00baf2"));
                            textPaint.setUnderlineText(true);
                        }
                    };
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(r3, str.length() - 3, str.length(), 0);
                    aaVar.f25053d.setText(spannableStringBuilder);
                    aaVar.f25053d.setClickable(true);
                    aaVar.f25053d.setMovementMethod(LinkMovementMethod.getInstance());
                    if (aaVar.f25054e == null) {
                        return;
                    }
                    if (cJRInsuranceItem.isOptIn()) {
                        aaVar.f25054e.setChecked(true);
                    } else {
                        aaVar.f25054e.setChecked(false);
                    }
                }
            } else if (vVar instanceof l) {
                ((l) vVar).a(this.f24705d.getmTravelerDetailsInfoBoxHtml());
            }
        } catch (Exception e2) {
            new StringBuilder().append(e2.getMessage());
            b.j();
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        String f24711a;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b2) {
            this();
        }
    }

    public final boolean a() {
        boolean z = false;
        boolean z2 = this.j == null;
        if (this.f24705d.getMeta().getCJRDynamicPaxInfo().getGst() == null) {
            z = true;
        }
        if (z2 || z) {
            return true;
        }
        return this.j.a().booleanValue();
    }

    public final boolean b() {
        ae aeVar = this.f24702a;
        if (aeVar != null) {
            return aeVar.c();
        }
        return false;
    }

    public final boolean c() {
        ad adVar = this.f24708g;
        if (adVar != null) {
            return adVar.a();
        }
        return false;
    }

    public final ArrayList<CJRTravellerDetails> d() {
        ae aeVar = this.f24702a;
        if (aeVar != null) {
            return aeVar.f25092d;
        }
        return null;
    }

    public final CJRDynamicPassenger e() {
        k kVar = this.j;
        if (kVar != null) {
            return kVar.f25167b;
        }
        return null;
    }

    public final String f() {
        ad adVar = this.f24708g;
        return adVar != null ? adVar.f25082g : "";
    }

    public final String g() {
        ad adVar = this.f24708g;
        return adVar != null ? adVar.f25081f : "";
    }

    public final void h() {
        com.travel.flight.flightticket.j.a aVar = this.f24709h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        com.travel.flight.flightticket.j.a aVar = this.f24709h;
        if (aVar != null) {
            aVar.a(cJRTravellerSeatTransition);
        }
    }

    public final CJRGSTPassengerInfo i() {
        k kVar = this.j;
        if (kVar != null) {
            return kVar.f25170e;
        }
        return null;
    }
}
