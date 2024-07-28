package com.travel.flight.flightticket.a;

import android.app.Activity;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.travel.flight.R;
import com.travel.flight.flightticket.j.x;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel;
import com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import java.util.ArrayList;

public final class k extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    x f24684a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f24685b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f24686c;

    /* renamed from: d  reason: collision with root package name */
    private com.travel.flight.flightticket.f.k f24687d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24688e = false;

    /* renamed from: f  reason: collision with root package name */
    private CJRFlightDetails f24689f;

    /* renamed from: g  reason: collision with root package name */
    private int f24690g;

    /* renamed from: h  reason: collision with root package name */
    private double f24691h = 0.0d;

    /* renamed from: i  reason: collision with root package name */
    private double f24692i = 0.0d;
    private float j = 0.0f;
    private float k;
    private double l;
    private CJRFlightPromoResponse m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private CJRTravellerSeatTransition r;
    private FlightSellingBundleResponseData s;

    public k(Activity activity, CJRFlightDetails cJRFlightDetails, CJRFlightPromoResponse cJRFlightPromoResponse, com.travel.flight.flightticket.f.k kVar, boolean z, boolean z2, CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        this.f24686c = activity;
        this.f24689f = cJRFlightDetails;
        this.f24685b = new ArrayList<>();
        this.f24687d = kVar;
        if (this.f24689f.getmReturnJourney() != null) {
            this.f24688e = true;
        } else {
            this.f24688e = false;
        }
        this.m = cJRFlightPromoResponse;
        this.o = z;
        this.q = z2;
        this.r = cJRTravellerSeatTransition;
        this.f24685b.add("fareBreakUp");
        try {
            this.f24690g = Integer.parseInt(this.f24689f.getmMetaDetails().getQuery().getAdults() + Integer.parseInt(this.f24689f.getmMetaDetails().getQuery().getChildren()) + Integer.parseInt(this.f24689f.getmMetaDetails().getQuery().getInfants()));
            if (this.f24689f.getmRepriceFareDetails().getmTotalFare() != null && !TextUtils.isEmpty(this.f24689f.getmRepriceFareDetails().getmTotalFare())) {
                this.f24691h = Double.parseDouble(this.f24689f.getmRepriceFareDetails().getmTotalFare());
                if (this.f24689f.getmRepriceFareDetails().getTotalModifyCharges() != null) {
                    this.f24691h += (double) this.f24689f.getmRepriceFareDetails().getTotalModifyCharges().intValue();
                }
            }
            if (this.f24689f.getmRepriceFareDetails().getmTax() != null && !TextUtils.isEmpty(this.f24689f.getmRepriceFareDetails().getmTax())) {
                this.f24692i = Double.parseDouble(this.f24689f.getmRepriceFareDetails().getmTax());
            }
            if (this.f24689f.getmConvenienceFee() != null) {
                this.k = Float.valueOf(this.f24689f.getmConvenienceFee().getAdultDetail().getmConvFee()).floatValue();
                this.j = this.f24689f.getmConvenienceFee().getMtotalConFee().floatValue();
            }
            this.l = this.f24691h + ((double) this.j);
            this.f24689f.getmRepriceFareDetails().setTotalFee(Double.toString(this.l));
        } catch (Exception e2) {
            new StringBuilder().append(e2.getMessage());
            b.j();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0049, code lost:
        r6 = r6.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.recyclerview.widget.RecyclerView.v onCreateViewHolder(android.view.ViewGroup r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            if (r6 != r0) goto L_0x0091
            android.content.Context r6 = r5.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r0 = com.travel.flight.R.layout.pre_f_flight_item_fare_details
            r1 = 0
            android.view.View r5 = r6.inflate(r0, r5, r1)
            com.travel.flight.flightticket.j.x r6 = new com.travel.flight.flightticket.j.x
            android.app.Activity r0 = r4.f24686c
            com.travel.flight.flightticket.f.k r2 = r4.f24687d
            r6.<init>(r0, r5, r2)
            r4.f24684a = r6
            com.travel.flight.flightticket.j.x r5 = r4.f24684a
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r4.f24689f
            r5.l = r6
            com.travel.flight.pojo.model.CJRTravellerSeatTransition r0 = r4.r
            r5.M = r0
            double r2 = r4.f24691h
            r5.n = r2
            double r2 = r4.f24692i
            r5.o = r2
            double r2 = r4.l
            r5.p = r2
            boolean r0 = r4.f24688e
            r5.u = r0
            float r0 = r4.j
            float r2 = r4.k
            r5.q = r0
            r5.r = r2
            boolean r0 = r4.o
            r5.A = r0
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r6 = r6.getInsuranceData()
            if (r6 == 0) goto L_0x007c
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r6 = r6.getBody()
            if (r6 == 0) goto L_0x007c
            java.util.List r0 = r6.getCancelProtectInsuranceDetail()
            if (r0 == 0) goto L_0x007c
            java.util.List r0 = r6.getCancelProtectInsuranceDetail()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x007c
            java.util.List r0 = r6.getCancelProtectInsuranceDetail()
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L_0x007c
            java.util.List r6 = r6.getCancelProtectInsuranceDetail()
            java.lang.Object r6 = r6.get(r1)
            com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r6 = (com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem) r6
            java.util.ArrayList r6 = r6.getPriceDetails()
            java.lang.String r6 = a((java.util.ArrayList<com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail>) r6)
            goto L_0x007e
        L_0x007c:
            java.lang.String r6 = ""
        L_0x007e:
            r5.H = r6
            com.travel.flight.flightticket.j.x r5 = r4.f24684a
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r4.f24689f
            boolean r6 = r6.isInsuranceCancelProtectApplied()
            r5.G = r6
            com.travel.flight.flightticket.j.x r5 = r4.f24684a
            boolean r6 = r4.q
            r5.L = r6
            return r5
        L_0x0091:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.a.k.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$v");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(20:34|(1:36)(1:(1:38))|39|(2:41|42)(1:(1:44))|(1:46)(1:(1:48))|49|(1:51)(1:52)|53|(1:55)(1:56)|57|58|(2:60|61)(1:62)|(1:69)(1:68)|70|71|72|(1:77)(1:76)|78|79|(3:87|(1:89)(1:90)|91)(2:83|(1:85)(1:86))) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x03e5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x04e7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x04f6 */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0546 A[Catch:{ Exception -> 0x0667 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0562 A[Catch:{ Exception -> 0x0667 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0597 A[Catch:{ Exception -> 0x0667 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x05a3 A[Catch:{ Exception -> 0x0667 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x05d5 A[Catch:{ Exception -> 0x0667 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8 A[Catch:{ Exception -> 0x0667 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f3 A[Catch:{ NumberFormatException -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f5 A[Catch:{ NumberFormatException -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x03ed A[Catch:{ NumberFormatException -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0479 A[Catch:{ NumberFormatException -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x04eb A[SYNTHETIC, Splitter:B:95:0x04eb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = ""
            boolean r3 = r1 instanceof com.travel.flight.flightticket.j.x     // Catch:{ Exception -> 0x0667 }
            if (r3 == 0) goto L_0x0667
            com.travel.flight.flightticket.j.x r1 = (com.travel.flight.flightticket.j.x) r1     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r3 = r0.m     // Catch:{ Exception -> 0x0667 }
            r4 = 8
            java.lang.String r5 = " "
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x00e5
            com.travel.flight.pojo.CJRFlightPromoBody r3 = r3.getBody()     // Catch:{ Exception -> 0x0667 }
            if (r3 == 0) goto L_0x00e5
            java.lang.String r8 = r3.getPromostatus()     // Catch:{ Exception -> 0x0667 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0667 }
            if (r8 != 0) goto L_0x00e5
            java.lang.String r8 = r3.getPromostatus()     // Catch:{ Exception -> 0x0667 }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x0667 }
            java.lang.String r9 = "SUCCESS"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0667 }
            if (r8 == 0) goto L_0x00e5
            int r8 = r3.getPaytmCashback()     // Catch:{ Exception -> 0x0667 }
            if (r8 <= 0) goto L_0x006a
            android.widget.TextView r8 = r1.t     // Catch:{ Exception -> 0x0667 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0667 }
            r9.<init>()     // Catch:{ Exception -> 0x0667 }
            android.content.Context r10 = r1.m     // Catch:{ Exception -> 0x0667 }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x0667 }
            int r11 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x0667 }
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x0667 }
            r9.append(r10)     // Catch:{ Exception -> 0x0667 }
            r9.append(r5)     // Catch:{ Exception -> 0x0667 }
            int r10 = r3.getPaytmCashback()     // Catch:{ Exception -> 0x0667 }
            r9.append(r10)     // Catch:{ Exception -> 0x0667 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0667 }
            r8.setText(r9)     // Catch:{ Exception -> 0x0667 }
            android.widget.TableRow r8 = r1.s     // Catch:{ Exception -> 0x0667 }
            r8.setVisibility(r7)     // Catch:{ Exception -> 0x0667 }
            r8 = 1
            goto L_0x0070
        L_0x006a:
            android.widget.TableRow r8 = r1.s     // Catch:{ Exception -> 0x0667 }
            r8.setVisibility(r4)     // Catch:{ Exception -> 0x0667 }
            r8 = 0
        L_0x0070:
            int r9 = r3.getPaytmDiscount()     // Catch:{ Exception -> 0x0667 }
            if (r9 <= 0) goto L_0x00a6
            android.view.ViewGroup r8 = r1.O     // Catch:{ Exception -> 0x0667 }
            r8.setVisibility(r7)     // Catch:{ Exception -> 0x0667 }
            android.widget.TextView r8 = r1.N     // Catch:{ Exception -> 0x0667 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0667 }
            java.lang.String r10 = "- "
            r9.<init>(r10)     // Catch:{ Exception -> 0x0667 }
            android.content.Context r10 = r1.m     // Catch:{ Exception -> 0x0667 }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x0667 }
            int r11 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x0667 }
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x0667 }
            r9.append(r10)     // Catch:{ Exception -> 0x0667 }
            r9.append(r5)     // Catch:{ Exception -> 0x0667 }
            int r10 = r3.getPaytmDiscount()     // Catch:{ Exception -> 0x0667 }
            r9.append(r10)     // Catch:{ Exception -> 0x0667 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0667 }
            r8.setText(r9)     // Catch:{ Exception -> 0x0667 }
            r8 = 1
            goto L_0x00ab
        L_0x00a6:
            android.view.ViewGroup r9 = r1.O     // Catch:{ Exception -> 0x0667 }
            r9.setVisibility(r4)     // Catch:{ Exception -> 0x0667 }
        L_0x00ab:
            int r9 = r3.getPaytmPgcashback()     // Catch:{ Exception -> 0x0667 }
            if (r9 <= 0) goto L_0x00df
            android.view.ViewGroup r8 = r1.P     // Catch:{ Exception -> 0x0667 }
            r8.setVisibility(r7)     // Catch:{ Exception -> 0x0667 }
            android.widget.TextView r8 = r1.Q     // Catch:{ Exception -> 0x0667 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0667 }
            r9.<init>()     // Catch:{ Exception -> 0x0667 }
            android.content.Context r10 = r1.m     // Catch:{ Exception -> 0x0667 }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x0667 }
            int r11 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x0667 }
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x0667 }
            r9.append(r10)     // Catch:{ Exception -> 0x0667 }
            r9.append(r5)     // Catch:{ Exception -> 0x0667 }
            int r3 = r3.getPaytmPgcashback()     // Catch:{ Exception -> 0x0667 }
            r9.append(r3)     // Catch:{ Exception -> 0x0667 }
            java.lang.String r3 = r9.toString()     // Catch:{ Exception -> 0x0667 }
            r8.setText(r3)     // Catch:{ Exception -> 0x0667 }
            r8 = 1
            goto L_0x00e6
        L_0x00df:
            android.view.ViewGroup r3 = r1.P     // Catch:{ Exception -> 0x0667 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x0667 }
            goto L_0x00e6
        L_0x00e5:
            r8 = 0
        L_0x00e6:
            if (r8 != 0) goto L_0x00ed
            android.widget.TableRow r3 = r1.s     // Catch:{ Exception -> 0x0667 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x0667 }
        L_0x00ed:
            com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r3 = r0.m     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r8 = r1.l     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r8 != 0) goto L_0x00f5
            goto L_0x04e7
        L_0x00f5:
            com.travel.flight.b.a()     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.c r8 = com.travel.flight.b.b()     // Catch:{ NumberFormatException -> 0x04e7 }
            boolean r8 = r8.w()     // Catch:{ NumberFormatException -> 0x04e7 }
            r1.I = r8     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r8 = r1.l     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r8 = r8.getmMetaDetails()     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.FlightSearchResultMetaQuery r8 = r8.getQuery()     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getAdults()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r9 = r1.l     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r9 = r9.getmMetaDetails()     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.FlightSearchResultMetaQuery r9 = r9.getQuery()     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = r9.getChildren()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r10 = r1.l     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRMetadetails r10 = r10.getmMetaDetails()     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.FlightSearchResultMetaQuery r10 = r10.getQuery()     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r10 = r10.getInfants()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r11.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r8 <= r6) goto L_0x0161
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r13 = com.travel.flight.R.string.adults     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r13)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r12.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r11.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x0184
        L_0x0161:
            if (r8 != r6) goto L_0x0184
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r13 = com.travel.flight.R.string.adult     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r13)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r12.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r11.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x0184:
            java.lang.String r8 = " + "
            if (r9 <= r6) goto L_0x01aa
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.<init>(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r9 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r13 = com.travel.flight.R.string.childrens     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = r9.getString(r13)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = r12.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r11.append(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x01cd
        L_0x01aa:
            if (r9 != r6) goto L_0x01cd
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.<init>(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r9 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r13 = com.travel.flight.R.string.child     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = r9.getString(r13)     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.append(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = r12.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r11.append(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x01cd:
            if (r10 <= r6) goto L_0x01f1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.<init>(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r10 = com.travel.flight.R.string.infants     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r9.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r11.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x0214
        L_0x01f1:
            if (r10 != r6) goto L_0x0214
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.<init>(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r10 = com.travel.flight.R.string.infant     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r9.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r11.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x0214:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r8 = r1.l     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r8 = r8.getmOnwardJourney()     // Catch:{ NumberFormatException -> 0x04e7 }
            boolean r8 = r8.ismIsRefundable()     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r8 == 0) goto L_0x022d
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r9 = com.travel.flight.R.string.flight_refundable     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x0239
        L_0x022d:
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r9 = com.travel.flight.R.string.flight_non_refundable     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x0239:
            android.widget.TextView r9 = r1.f25231b     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r11 = r11.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.append(r11)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r11 = " ("
            r10.append(r11)     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = ")"
            r10.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r10.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.setText(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TextView r8 = r1.f25232c     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r10 = r1.v     // Catch:{ NumberFormatException -> 0x04e7 }
            int r11 = com.travel.flight.R.string.rs_symbol     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r10 = r10.getString(r11)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            double r10 = r1.n     // Catch:{ NumberFormatException -> 0x04e7 }
            double r12 = r1.o     // Catch:{ NumberFormatException -> 0x04e7 }
            double r10 = r10 - r12
            java.lang.String r10 = com.travel.flight.utils.c.a((double) r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = r9.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r8.setText(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TextView r8 = r1.f25233d     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r10 = r1.v     // Catch:{ NumberFormatException -> 0x04e7 }
            int r11 = com.travel.flight.R.string.rs_symbol     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r10 = r10.getString(r11)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            double r10 = r1.o     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r10 = com.travel.flight.utils.c.a((double) r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9.append(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = r9.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r8.setText(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            double r8 = r1.n     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.model.CJRTravellerSeatTransition r10 = r1.M     // Catch:{ NumberFormatException -> 0x04e7 }
            boolean r10 = com.travel.flight.flightticket.j.x.a(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r10 == 0) goto L_0x02e4
            double r10 = r1.a()     // Catch:{ NumberFormatException -> 0x04e7 }
            long r10 = java.lang.Math.round(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            double r10 = (double) r10     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TextView r12 = r1.f25234e     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r13.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r14 = r1.v     // Catch:{ NumberFormatException -> 0x04e7 }
            int r15 = com.travel.flight.R.string.rs_symbol     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ NumberFormatException -> 0x04e7 }
            r13.append(r14)     // Catch:{ NumberFormatException -> 0x04e7 }
            r13.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r14 = com.travel.flight.utils.c.a((double) r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r13.append(r14)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r13 = r13.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r12.setText(r13)     // Catch:{ NumberFormatException -> 0x04e7 }
            double r12 = r1.p     // Catch:{ NumberFormatException -> 0x04e7 }
            double r12 = r12 + r10
            r1.p = r12     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x02e9
        L_0x02e4:
            android.widget.TableRow r10 = r1.f25237h     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x02e9:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r10 = r1.l     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r10 = r10.getmRepriceFareDetails()     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.Integer r10 = r10.getTotalModifyCharges()     // Catch:{ NumberFormatException -> 0x04e7 }
            r11 = 2
            java.lang.String r12 = "%s %s"
            if (r10 == 0) goto L_0x0328
            android.widget.TableRow r10 = r1.E     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.setVisibility(r7)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TextView r10 = r1.f25236g     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.Object[] r13 = new java.lang.Object[r11]     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r14 = r1.v     // Catch:{ NumberFormatException -> 0x04e7 }
            int r15 = com.travel.flight.R.string.rs_symbol     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ NumberFormatException -> 0x04e7 }
            r13[r7] = r14     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r14 = r1.l     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRRepriceFlightFare r14 = r14.getmRepriceFareDetails()     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.Integer r14 = r14.getTotalModifyCharges()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r14 = r14.intValue()     // Catch:{ NumberFormatException -> 0x04e7 }
            double r14 = (double) r14     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r14 = com.travel.flight.utils.c.a((double) r14)     // Catch:{ NumberFormatException -> 0x04e7 }
            r13[r6] = r14     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r13 = java.lang.String.format(r12, r13)     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.setText(r13)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x032d
        L_0x0328:
            android.widget.TableRow r10 = r1.E     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x032d:
            if (r3 == 0) goto L_0x0350
            com.travel.flight.pojo.CJRFlightPromoBody r10 = r3.getBody()     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r10 == 0) goto L_0x0350
            com.travel.flight.pojo.CJRFlightPromoBody r10 = r3.getBody()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r10 = r10.getPaytmDiscount()     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r10 <= 0) goto L_0x0350
            double r13 = r1.p     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.CJRFlightPromoBody r3 = r3.getBody()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r3 = r3.getPaytmDiscount()     // Catch:{ NumberFormatException -> 0x04e7 }
            r18 = r12
            double r11 = (double) r3     // Catch:{ NumberFormatException -> 0x04e7 }
            double r13 = r13 - r11
            r1.p = r13     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x0352
        L_0x0350:
            r18 = r12
        L_0x0352:
            android.widget.TextView r3 = r1.x     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r11 = r1.v     // Catch:{ NumberFormatException -> 0x04e7 }
            int r12 = com.travel.flight.R.string.rs_symbol     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r11 = r11.getString(r12)     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.append(r11)     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = com.travel.flight.utils.c.a((double) r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r10.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r10.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.setText(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r1.l     // Catch:{ Exception -> 0x03e5 }
            java.util.List r3 = r3.getBundleList()     // Catch:{ Exception -> 0x03e5 }
            if (r3 == 0) goto L_0x03d6
            int r8 = r3.size()     // Catch:{ Exception -> 0x03e5 }
            if (r8 <= 0) goto L_0x03d6
            java.lang.Object r2 = r3.get(r7)     // Catch:{ Exception -> 0x03e5 }
            com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData r2 = (com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData) r2     // Catch:{ Exception -> 0x03e5 }
            android.widget.TableRow r3 = r1.f25238i     // Catch:{ Exception -> 0x03e5 }
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x03e5 }
            android.widget.TextView r3 = r1.j     // Catch:{ Exception -> 0x03e5 }
            r8 = 2
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x03e5 }
            android.content.res.Resources r8 = r1.v     // Catch:{ Exception -> 0x03e5 }
            int r10 = com.travel.flight.R.string.package_header     // Catch:{ Exception -> 0x03e5 }
            java.lang.String r8 = r8.getString(r10)     // Catch:{ Exception -> 0x03e5 }
            r9[r7] = r8     // Catch:{ Exception -> 0x03e5 }
            java.lang.String r8 = r2.getTitle()     // Catch:{ Exception -> 0x03e5 }
            r9[r6] = r8     // Catch:{ Exception -> 0x03e5 }
            r8 = r18
            java.lang.String r9 = java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x03e5 }
            r3.setText(r9)     // Catch:{ Exception -> 0x03e5 }
            android.widget.TextView r3 = r1.k     // Catch:{ Exception -> 0x03e5 }
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x03e5 }
            android.content.res.Resources r10 = r1.v     // Catch:{ Exception -> 0x03e5 }
            int r11 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x03e5 }
            java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x03e5 }
            r9[r7] = r10     // Catch:{ Exception -> 0x03e5 }
            double r10 = r2.getProduct_selling_price()     // Catch:{ Exception -> 0x03e5 }
            java.lang.String r10 = com.travel.flight.utils.c.a((double) r10)     // Catch:{ Exception -> 0x03e5 }
            r9[r6] = r10     // Catch:{ Exception -> 0x03e5 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x03e5 }
            r3.setText(r8)     // Catch:{ Exception -> 0x03e5 }
            double r8 = r1.p     // Catch:{ Exception -> 0x03e5 }
            double r2 = r2.getProduct_selling_price()     // Catch:{ Exception -> 0x03e5 }
            double r8 = r8 + r2
            r1.p = r8     // Catch:{ Exception -> 0x03e5 }
            goto L_0x03e5
        L_0x03d6:
            android.widget.TableRow r3 = r1.f25238i     // Catch:{ Exception -> 0x03e5 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x03e5 }
            android.widget.TextView r3 = r1.j     // Catch:{ Exception -> 0x03e5 }
            r3.setText(r2)     // Catch:{ Exception -> 0x03e5 }
            android.widget.TextView r3 = r1.k     // Catch:{ Exception -> 0x03e5 }
            r3.setText(r2)     // Catch:{ Exception -> 0x03e5 }
        L_0x03e5:
            boolean r2 = r1.A     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r2 != 0) goto L_0x0479
            boolean r2 = r1.I     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r2 == 0) goto L_0x0479
            android.widget.LinearLayout r2 = r1.y     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r7)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TableRow r2 = r1.F     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TableRow r2 = r1.B     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TableRow r2 = r1.C     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TableRow r2 = r1.D     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            boolean r2 = r1.G     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r2 == 0) goto L_0x0458
            android.widget.TextView r2 = r1.z     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r9 = com.travel.flight.R.string.flight_excluding_convenience_fee_msg     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ NumberFormatException -> 0x04e7 }
            float r10 = r1.r     // Catch:{ NumberFormatException -> 0x04e7 }
            double r10 = (double) r10     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r10 = com.travel.flight.utils.c.a((double) r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9[r7] = r10     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r8 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r9 = com.travel.flight.R.string.and_cancel_protect_tooltip     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r10 = r1.H     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r10 = com.travel.flight.utils.c.h(r10)     // Catch:{ NumberFormatException -> 0x04e7 }
            r9[r7] = r10     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setText(r3)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x04e7
        L_0x0458:
            android.widget.TextView r2 = r1.z     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.Context r3 = r1.m     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ NumberFormatException -> 0x04e7 }
            int r8 = com.travel.flight.R.string.flight_excluding_convenience_fee_msg     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r3 = r3.getString(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ NumberFormatException -> 0x04e7 }
            float r9 = r1.r     // Catch:{ NumberFormatException -> 0x04e7 }
            double r9 = (double) r9     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r9 = com.travel.flight.utils.c.a((double) r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            r8[r7] = r9     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r3 = java.lang.String.format(r3, r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setText(r3)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x04e7
        L_0x0479:
            boolean r2 = r1.L     // Catch:{ NumberFormatException -> 0x04e7 }
            if (r2 == 0) goto L_0x0492
            android.widget.TableRow r2 = r1.B     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TableRow r2 = r1.C     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TableRow r2 = r1.D     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TableRow r2 = r1.F     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
            goto L_0x0497
        L_0x0492:
            android.widget.TableRow r2 = r1.F     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r7)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x0497:
            android.widget.TextView r2 = r1.f25230a     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r1.v     // Catch:{ NumberFormatException -> 0x04e7 }
            int r9 = com.travel.flight.R.string.rs_symbol     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            float r8 = r1.q     // Catch:{ NumberFormatException -> 0x04e7 }
            double r8 = (double) r8     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = com.travel.flight.utils.c.a((double) r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setText(r3)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.TextView r2 = r1.f25235f     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x04e7 }
            android.content.res.Resources r8 = r1.v     // Catch:{ NumberFormatException -> 0x04e7 }
            int r9 = com.travel.flight.R.string.rs_symbol     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r5)     // Catch:{ NumberFormatException -> 0x04e7 }
            double r8 = r1.p     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r8 = com.travel.flight.utils.c.a((double) r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            r3.append(r8)     // Catch:{ NumberFormatException -> 0x04e7 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setText(r3)     // Catch:{ NumberFormatException -> 0x04e7 }
            android.widget.LinearLayout r2 = r1.y     // Catch:{ NumberFormatException -> 0x04e7 }
            r2.setVisibility(r4)     // Catch:{ NumberFormatException -> 0x04e7 }
        L_0x04e7:
            com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData r2 = r0.s     // Catch:{ Exception -> 0x0667 }
            if (r2 == 0) goto L_0x04f6
            com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData r2 = r0.s     // Catch:{ Exception -> 0x04f6 }
            double r2 = r2.getProduct_selling_price()     // Catch:{ Exception -> 0x04f6 }
            double r8 = r0.l     // Catch:{ Exception -> 0x04f6 }
            double r8 = r8 + r2
            r0.l = r8     // Catch:{ Exception -> 0x04f6 }
        L_0x04f6:
            boolean r2 = r0.o     // Catch:{ Exception -> 0x0667 }
            if (r2 == 0) goto L_0x058b
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f24689f     // Catch:{ Exception -> 0x0667 }
            boolean r2 = r2.isInsuranceApplied()     // Catch:{ Exception -> 0x0667 }
            if (r2 == 0) goto L_0x058b
            boolean r2 = r0.n     // Catch:{ Exception -> 0x0667 }
            if (r2 != 0) goto L_0x058b
            r0.n = r6     // Catch:{ Exception -> 0x0667 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r0.f24689f     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r3 = r3.getInsuranceData()     // Catch:{ Exception -> 0x0667 }
            if (r3 == 0) goto L_0x058b
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r3 = r3.getBody()     // Catch:{ Exception -> 0x0667 }
            if (r3 == 0) goto L_0x058b
            java.util.List r8 = r3.getInsuranceDetail()     // Catch:{ Exception -> 0x0667 }
            if (r8 == 0) goto L_0x058b
            java.util.List r8 = r3.getInsuranceDetail()     // Catch:{ Exception -> 0x0667 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x0667 }
            if (r8 <= 0) goto L_0x058b
            java.util.List r8 = r3.getInsuranceDetail()     // Catch:{ Exception -> 0x0667 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ Exception -> 0x0667 }
            if (r8 == 0) goto L_0x058b
            java.util.List r8 = r3.getInsuranceDetail()     // Catch:{ Exception -> 0x0667 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r8 = (com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem) r8     // Catch:{ Exception -> 0x0667 }
            double r8 = r8.getTotalPremium()     // Catch:{ Exception -> 0x0667 }
            boolean r10 = r2.booleanValue()     // Catch:{ Exception -> 0x0667 }
            if (r10 == 0) goto L_0x0562
            com.travel.flight.flightticket.j.x r10 = r0.f24684a     // Catch:{ Exception -> 0x0667 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0667 }
            java.util.List r11 = r3.getInsuranceDetail()     // Catch:{ Exception -> 0x0667 }
            java.lang.Object r11 = r11.get(r7)     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r11 = (com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem) r11     // Catch:{ Exception -> 0x0667 }
            r11.getFarePerTraveller()     // Catch:{ Exception -> 0x0667 }
            r10.a(r3, r2)     // Catch:{ Exception -> 0x0667 }
            double r2 = r0.l     // Catch:{ Exception -> 0x0667 }
            double r2 = r2 + r8
            r0.l = r2     // Catch:{ Exception -> 0x0667 }
            goto L_0x058b
        L_0x0562:
            java.util.List r8 = r3.getInsuranceDetail()     // Catch:{ Exception -> 0x0667 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r8 = (com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem) r8     // Catch:{ Exception -> 0x0667 }
            double r8 = r8.getTotalPremium()     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.flightticket.j.x r10 = r0.f24684a     // Catch:{ Exception -> 0x0667 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0667 }
            java.util.List r11 = r3.getInsuranceDetail()     // Catch:{ Exception -> 0x0667 }
            java.lang.Object r11 = r11.get(r7)     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem r11 = (com.travel.flight.pojo.flightticket.insurance.CJRInsuranceItem) r11     // Catch:{ Exception -> 0x0667 }
            r11.getFarePerTraveller()     // Catch:{ Exception -> 0x0667 }
            r10.a(r3, r2)     // Catch:{ Exception -> 0x0667 }
            double r2 = r0.l     // Catch:{ Exception -> 0x0667 }
            double r2 = r2 - r8
            r0.l = r2     // Catch:{ Exception -> 0x0667 }
        L_0x058b:
            boolean r2 = r0.o     // Catch:{ Exception -> 0x0667 }
            if (r2 == 0) goto L_0x05a3
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f24689f     // Catch:{ Exception -> 0x0667 }
            boolean r2 = r2.isInsuranceCancelProtectApplied()     // Catch:{ Exception -> 0x0667 }
            if (r2 == 0) goto L_0x05a3
            boolean r2 = r0.p     // Catch:{ Exception -> 0x0667 }
            if (r2 != 0) goto L_0x05c3
            r0.p = r6     // Catch:{ Exception -> 0x0667 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0667 }
            r0.a((java.lang.Boolean) r2)     // Catch:{ Exception -> 0x0667 }
            goto L_0x05c3
        L_0x05a3:
            com.travel.flight.b.a()     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.c r2 = com.travel.flight.b.b()     // Catch:{ Exception -> 0x0667 }
            boolean r2 = r2.w()     // Catch:{ Exception -> 0x0667 }
            if (r2 != 0) goto L_0x05c3
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r0.f24689f     // Catch:{ Exception -> 0x0667 }
            boolean r2 = r2.isInsuranceCancelProtectApplied()     // Catch:{ Exception -> 0x0667 }
            if (r2 == 0) goto L_0x05c3
            boolean r2 = r0.p     // Catch:{ Exception -> 0x0667 }
            if (r2 != 0) goto L_0x05c3
            r0.p = r6     // Catch:{ Exception -> 0x0667 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0667 }
            r0.a((java.lang.Boolean) r2)     // Catch:{ Exception -> 0x0667 }
        L_0x05c3:
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r2 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ Exception -> 0x0667 }
            java.lang.Double r2 = r2.getmSelectedMealsTotalAmount()     // Catch:{ Exception -> 0x0667 }
            double r2 = r2.doubleValue()     // Catch:{ Exception -> 0x0667 }
            r8 = 0
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x05ec
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r2 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ Exception -> 0x0667 }
            java.lang.Double r2 = r2.getmSelectedBaggageTotalAmount()     // Catch:{ Exception -> 0x0667 }
            double r2 = r2.doubleValue()     // Catch:{ Exception -> 0x0667 }
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x05e6
            goto L_0x05ec
        L_0x05e6:
            android.widget.TableRow r1 = r1.J     // Catch:{ Exception -> 0x0667 }
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x0667 }
            goto L_0x0667
        L_0x05ec:
            android.widget.TableRow r2 = r1.J     // Catch:{ Exception -> 0x0667 }
            r2.setVisibility(r7)     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r2 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ Exception -> 0x0667 }
            java.lang.Double r2 = r2.getmSelectedMealsTotalAmount()     // Catch:{ Exception -> 0x0667 }
            double r2 = r2.doubleValue()     // Catch:{ Exception -> 0x0667 }
            com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody r4 = com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody.getInstance()     // Catch:{ Exception -> 0x0667 }
            java.lang.Double r4 = r4.getmSelectedBaggageTotalAmount()     // Catch:{ Exception -> 0x0667 }
            double r6 = r4.doubleValue()     // Catch:{ Exception -> 0x0667 }
            double r2 = r2 + r6
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0667 }
            android.widget.TextView r3 = r1.K     // Catch:{ Exception -> 0x0667 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0667 }
            r4.<init>()     // Catch:{ Exception -> 0x0667 }
            android.content.Context r6 = r1.m     // Catch:{ Exception -> 0x0667 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0667 }
            int r7 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x0667 }
            java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x0667 }
            r4.append(r6)     // Catch:{ Exception -> 0x0667 }
            r4.append(r5)     // Catch:{ Exception -> 0x0667 }
            double r6 = r2.doubleValue()     // Catch:{ Exception -> 0x0667 }
            java.lang.String r6 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x0667 }
            r4.append(r6)     // Catch:{ Exception -> 0x0667 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0667 }
            r3.setText(r4)     // Catch:{ Exception -> 0x0667 }
            double r3 = r1.p     // Catch:{ Exception -> 0x0667 }
            double r6 = r2.doubleValue()     // Catch:{ Exception -> 0x0667 }
            double r3 = r3 + r6
            r1.p = r3     // Catch:{ Exception -> 0x0667 }
            android.widget.TextView r2 = r1.f25235f     // Catch:{ Exception -> 0x0667 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0667 }
            r3.<init>()     // Catch:{ Exception -> 0x0667 }
            android.content.res.Resources r4 = r1.v     // Catch:{ Exception -> 0x0667 }
            int r6 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x0667 }
            java.lang.String r4 = r4.getString(r6)     // Catch:{ Exception -> 0x0667 }
            r3.append(r4)     // Catch:{ Exception -> 0x0667 }
            r3.append(r5)     // Catch:{ Exception -> 0x0667 }
            double r4 = r1.p     // Catch:{ Exception -> 0x0667 }
            java.lang.String r1 = com.travel.flight.utils.c.a((double) r4)     // Catch:{ Exception -> 0x0667 }
            r3.append(r1)     // Catch:{ Exception -> 0x0667 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0667 }
            r2.setText(r1)     // Catch:{ Exception -> 0x0667 }
        L_0x0667:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.a.k.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemCount() {
        return this.f24685b.size();
    }

    public final int getItemViewType(int i2) {
        return this.f24685b.get(i2).equalsIgnoreCase("fareBreakUp") ? 1 : 0;
    }

    private void a(Boolean bool) {
        CJRInsuranceBody body;
        CJRInsuranceModel insuranceData = this.f24689f.getInsuranceData();
        if (insuranceData != null && (body = insuranceData.getBody()) != null && body.getCancelProtectInsuranceDetail() != null && body.getCancelProtectInsuranceDetail().size() > 0 && body.getCancelProtectInsuranceDetail().get(0) != null) {
            double totalPremium = body.getCancelProtectInsuranceDetail().get(0).getTotalPremium();
            String a2 = a(body.getCancelProtectInsuranceDetail().get(0).getPriceDetails());
            if (bool.booleanValue()) {
                this.f24684a.a(totalPremium, bool.booleanValue(), String.format(this.f24686c.getResources().getString(R.string.cancel_protect_premium_per_traveller), new Object[]{a2}));
                this.l += totalPremium;
                return;
            }
            double totalPremium2 = body.getInsuranceDetail().get(0).getTotalPremium();
            this.f24684a.a(totalPremium2, bool.booleanValue(), a2);
            this.l -= totalPremium2;
        }
    }

    private static String a(ArrayList<CJRInsurancePriceDetail> arrayList) {
        return (arrayList == null || arrayList.size() <= 0) ? "" : arrayList.get(0).getPremiumPerPassenger();
    }
}
