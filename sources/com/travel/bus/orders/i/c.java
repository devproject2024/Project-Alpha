package com.travel.bus.orders.i;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.i.v;
import com.travel.bus.busticket.i.y;
import com.travel.bus.orders.e.a;
import com.travel.bus.orders.f.g;
import com.travel.bus.pojo.busticket.CJRBusOperatorDetails;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.photos.BoardingPhoto;
import com.travel.bus.pojo.photos.CJRBusBPOnward;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import io.reactivex.rxjava3.a.w;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class c extends a {
    private RelativeLayout A;
    private TextView B;
    private TextView C;
    private TextView D;
    private View E;
    private TextView F;
    private LinearLayout G;
    private LinearLayout H;
    private LinearLayout I;
    private boolean J = false;
    private View K;
    private boolean L;
    private ImageView M;
    private RoboTextView N;
    private RoboTextView O;
    private ImageView P;
    private ImageView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private ImageView U;
    private RecyclerView V;
    private g W;
    private com.travel.bus.orders.a.a X;
    private LinearLayoutManager Y;
    private com.travel.bus.orders.h.c Z;

    /* renamed from: a  reason: collision with root package name */
    CJRBusOperatorDetails.b f22648a;

    /* renamed from: b  reason: collision with root package name */
    FragmentActivity f22649b;

    /* renamed from: c  reason: collision with root package name */
    CJRBusOperatorDetails.a f22650c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<BoardingPhoto> f22651d;

    /* renamed from: e  reason: collision with root package name */
    public CJRBusBPOnward f22652e;

    /* renamed from: f  reason: collision with root package name */
    private CJRBusOrderSummary f22653f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22654g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22655h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22656i = false;
    private int j;
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
    private RelativeLayout x;
    private RelativeLayout y;
    private RelativeLayout z;

    public c(View view, CJRBusOrderSummary cJRBusOrderSummary, CJRBusOperatorDetails.b bVar, FragmentActivity fragmentActivity, boolean z2, g gVar, CJRBusOperatorDetails.a aVar, CJRBusBPOnward cJRBusBPOnward) {
        super(view);
        try {
            this.L = z2;
            this.k = (TextView) view.findViewById(R.id.text_origin_city);
            this.l = (TextView) view.findViewById(R.id.text_destination_city);
            this.m = (TextView) view.findViewById(R.id.text_date_start);
            this.n = (TextView) view.findViewById(R.id.text_date_end);
            this.o = (TextView) view.findViewById(R.id.text_time);
            this.p = (TextView) view.findViewById(R.id.text_time_end);
            this.q = (TextView) view.findViewById(R.id.text_duration);
            this.r = (TextView) view.findViewById(R.id.text_bus_operator);
            this.s = (TextView) view.findViewById(R.id.text_bus_type);
            this.t = (TextView) view.findViewById(R.id.bus_rating_text);
            this.u = (TextView) view.findViewById(R.id.text_dropping_point);
            this.v = (TextView) view.findViewById(R.id.text_boarding_point_desc);
            this.w = (TextView) view.findViewById(R.id.operator_contact_value_text);
            this.x = (RelativeLayout) view.findViewById(R.id.boarding_info);
            this.y = (RelativeLayout) view.findViewById(R.id.dropping_info);
            this.B = (TextView) view.findViewById(R.id.bus_number_value_txt);
            this.C = (TextView) view.findViewById(R.id.driver_contact_text);
            this.D = (TextView) view.findViewById(R.id.driver_contact_value_text);
            this.E = view.findViewById(R.id.operator_details_lyt_devider);
            this.F = (TextView) view.findViewById(R.id.text_operator_info);
            this.G = (LinearLayout) view.findViewById(R.id.operator_info_lyt);
            this.K = view.findViewById(R.id.bd_point_info_sep);
            this.M = (ImageView) view.findViewById(R.id.operator_devider);
            this.H = (LinearLayout) view.findViewById(R.id.operator_details_lyt);
            this.A = (RelativeLayout) view.findViewById(R.id.bus_no_Lyt);
            this.I = (LinearLayout) view.findViewById(R.id.driver_contact_Lyt);
            this.z = (RelativeLayout) view.findViewById(R.id.operator_contact_Lyt);
            this.N = (RoboTextView) view.findViewById(R.id.text_bp_disclaimer);
            this.O = (RoboTextView) view.findViewById(R.id.text_dp_disclaimer);
            this.P = (ImageView) view.findViewById(R.id.bus_bp_map_icon);
            this.Q = (ImageView) view.findViewById(R.id.bus_dp_map_icon);
            this.V = (RecyclerView) view.findViewById(R.id.rv_photos);
            this.S = (ImageView) view.findViewById(R.id.bus_boarding_icon);
            this.T = (ImageView) view.findViewById(R.id.bus_dropping_icon);
            this.U = (ImageView) view.findViewById(R.id.operator_image_view);
            this.R = (ImageView) view.findViewById(R.id.bus_tracker_icon);
            ResourceUtils.loadBusImagesFromCDN(this.R, "ic_order_summary_tracking_icon.png", false, false, n.a.V1);
            ResourceUtils.loadBusImagesFromCDN(this.S, "ic_order_summary_boarding.png", false, false, n.a.V1);
            ResourceUtils.loadBusImagesFromCDN(this.T, "ic_order_summary_dropping.png", false, false, n.a.V1);
            ResourceUtils.loadBusImagesFromCDN(this.U, "ic_order_summary_icon.png", false, false, n.a.V1);
            this.f22649b = fragmentActivity;
            this.f22648a = bVar;
            this.W = gVar;
            this.f22650c = aVar;
            this.f22651d = cJRBusBPOnward.getBoardingPhotos();
            this.f22652e = cJRBusBPOnward;
            y yVar = y.f22482a;
            y.a(CJRBusOperatorDetails.b.class).subscribeOn(io.reactivex.rxjava3.android.b.a.a()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new w<CJRBusOperatorDetails.b>() {
                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final /* bridge */ /* synthetic */ void onNext(Object obj) {
                    c.this.f22648a = (CJRBusOperatorDetails.b) obj;
                }

                public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
                    v.a(cVar);
                }
            });
            y yVar2 = y.f22482a;
            y.a(CJRBusOperatorDetails.a.class).subscribeOn(io.reactivex.rxjava3.android.b.a.a()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new w<CJRBusOperatorDetails.a>() {
                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final /* bridge */ /* synthetic */ void onNext(Object obj) {
                    c.this.f22650c = (CJRBusOperatorDetails.a) obj;
                }

                public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
                    v.a(cVar);
                }
            });
            this.f22653f = cJRBusOrderSummary;
            if (this.f22653f.getPaymentStatus().equals("FAILED") || this.f22653f.getPaymentStatus().equals("PROCESSING")) {
                this.J = true;
            }
            if (this.f22653f.getStatus().equals(SDKConstants.GA_NATIVE_FAILED)) {
                this.J = true;
            }
            if (this.f22653f != null && this.f22653f.getOrderedCartList() != null) {
                this.j = this.f22653f.getOrderedCartList().size();
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    private void a(String str, String str2) {
        this.P.setVisibility(0);
        this.N.setVisibility(0);
        this.P.invalidate();
        this.N.invalidate();
        this.P.setOnClickListener(new View.OnClickListener(str, str2) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                c.this.a(this.f$1, this.f$2, view);
            }
        });
        this.N.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.c(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, View view) {
        this.f22649b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps?q=" + str + AppConstants.COMMA + str2)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        g gVar = this.W;
        if (gVar != null) {
            gVar.a("BP");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x0213 */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x021d A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0284 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x029b A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02c8 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02d6 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0312 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0318 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0374 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x037c A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x038f A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0395 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03f4 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0488 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04a3 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0515 A[Catch:{ Exception -> 0x053f }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0566  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x05d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.bus.orders.c.c.b r36) {
        /*
            r35 = this;
            r1 = r35
            java.lang.String r0 = ","
            java.lang.String r2 = "journey_detail"
            java.lang.String r3 = "items"
            java.lang.String r4 = "order_data"
            java.lang.String r5 = "E, d MMM"
            java.lang.String r6 = "yyyy-MM-dd"
            java.lang.String r7 = "pickUpContactNo"
            java.lang.String r8 = "HH:mm"
            java.lang.String r9 = "HH:mm:ss"
            java.lang.String r10 = ""
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r11 = r1.f22653f
            if (r11 != 0) goto L_0x001c
            return
        L_0x001c:
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r11 = r1.f22650c
            r12 = 8
            if (r11 == 0) goto L_0x0058
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r11 = r11.getOnward()
            if (r11 == 0) goto L_0x0058
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r11 = r1.f22650c
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r11 = r11.getOnward()
            java.lang.Object r11 = r11.f22784a
            if (r11 == 0) goto L_0x0058
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r11 = r1.f22650c
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r11 = r11.getOnward()
            java.lang.Object r11 = r11.f22785b
            if (r11 == 0) goto L_0x0058
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r11 = r1.f22650c
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r11 = r11.getOnward()
            java.lang.Object r11 = r11.f22784a
            java.lang.String r11 = r11.toString()
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r13 = r1.f22650c
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r13 = r13.getOnward()
            java.lang.Object r13 = r13.f22785b
            java.lang.String r13 = r13.toString()
            r1.a((java.lang.String) r11, (java.lang.String) r13)
            goto L_0x008c
        L_0x0058:
            com.travel.bus.pojo.photos.CJRBusBPOnward r11 = r1.f22652e
            if (r11 == 0) goto L_0x0082
            java.lang.Double r11 = r11.getLat()
            if (r11 == 0) goto L_0x0082
            com.travel.bus.pojo.photos.CJRBusBPOnward r11 = r1.f22652e
            java.lang.Double r11 = r11.getLng()
            if (r11 == 0) goto L_0x0082
            com.travel.bus.pojo.photos.CJRBusBPOnward r11 = r1.f22652e
            java.lang.Double r11 = r11.getLat()
            java.lang.String r11 = r11.toString()
            com.travel.bus.pojo.photos.CJRBusBPOnward r13 = r1.f22652e
            java.lang.Double r13 = r13.getLng()
            java.lang.String r13 = r13.toString()
            r1.a((java.lang.String) r11, (java.lang.String) r13)
            goto L_0x008c
        L_0x0082:
            android.widget.ImageView r11 = r1.P
            r11.setVisibility(r12)
            com.paytm.utility.RoboTextView r11 = r1.N
            r11.setVisibility(r12)
        L_0x008c:
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r11 = r1.f22650c
            r13 = 0
            if (r11 == 0) goto L_0x00d4
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r11 = r11.getReturn()
            if (r11 == 0) goto L_0x00d4
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r11 = r1.f22650c
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r11 = r11.getReturn()
            java.lang.Object r11 = r11.f22784a
            if (r11 == 0) goto L_0x00d4
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$a r11 = r1.f22650c
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$d r11 = r11.getReturn()
            java.lang.Object r11 = r11.f22785b
            if (r11 == 0) goto L_0x00d4
            android.widget.ImageView r11 = r1.Q
            r11.setVisibility(r13)
            com.paytm.utility.RoboTextView r11 = r1.O
            r11.setVisibility(r13)
            android.widget.ImageView r11 = r1.Q
            r11.invalidate()
            com.paytm.utility.RoboTextView r11 = r1.O
            r11.invalidate()
            android.widget.ImageView r11 = r1.Q
            com.travel.bus.orders.i.-$$Lambda$c$qCBuJIO-nWQq2Td8NfslenhKXFY r14 = new com.travel.bus.orders.i.-$$Lambda$c$qCBuJIO-nWQq2Td8NfslenhKXFY
            r14.<init>()
            r11.setOnClickListener(r14)
            com.paytm.utility.RoboTextView r11 = r1.O
            com.travel.bus.orders.i.-$$Lambda$c$O4v2PHquw6XimDoe4Tv68C7X0P0 r14 = new com.travel.bus.orders.i.-$$Lambda$c$O4v2PHquw6XimDoe4Tv68C7X0P0
            r14.<init>()
            r11.setOnClickListener(r14)
            goto L_0x00de
        L_0x00d4:
            android.widget.ImageView r11 = r1.Q
            r11.setVisibility(r12)
            com.paytm.utility.RoboTextView r11 = r1.O
            r11.setVisibility(r12)
        L_0x00de:
            boolean r11 = r1.L
            if (r11 == 0) goto L_0x00e8
            android.view.View r11 = r1.K
            r11.setVisibility(r13)
            goto L_0x00ed
        L_0x00e8:
            android.view.View r11 = r1.K
            r11.setVisibility(r12)
        L_0x00ed:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r14 = r1.f22653f     // Catch:{ Exception -> 0x0553 }
            java.util.ArrayList r14 = r14.getOrderedCartList()     // Catch:{ Exception -> 0x0553 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0553 }
            r15 = 0
        L_0x00f8:
            boolean r16 = r14.hasNext()     // Catch:{ Exception -> 0x0551 }
            if (r16 == 0) goto L_0x055c
            java.lang.Object r16 = r14.next()     // Catch:{ Exception -> 0x0551 }
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r16 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r16     // Catch:{ Exception -> 0x0551 }
            boolean r17 = com.travel.bus.orders.h.b.b(r16)     // Catch:{ Exception -> 0x0551 }
            if (r17 == 0) goto L_0x0547
            if (r16 == 0) goto L_0x0122
            java.lang.Object r11 = r16.getMetaDataResponse()     // Catch:{ Exception -> 0x0551 }
            com.google.gsonhtcfix.f r12 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0551 }
            r12.<init>()     // Catch:{ Exception -> 0x0551 }
            java.lang.String r11 = r12.a((java.lang.Object) r11)     // Catch:{ Exception -> 0x0551 }
            java.lang.Class<com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse> r13 = com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse.class
            java.lang.Object r11 = r12.a((java.lang.String) r11, r13)     // Catch:{ Exception -> 0x0551 }
            com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse r11 = (com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse) r11     // Catch:{ Exception -> 0x0551 }
            r15 = r11
        L_0x0122:
            java.lang.String r11 = r15.getArrivalDate()     // Catch:{ Exception -> 0x0543 }
            if (r11 == 0) goto L_0x012d
            java.lang.String r11 = r15.getArrivalDate()     // Catch:{ Exception -> 0x0551 }
            goto L_0x012e
        L_0x012d:
            r11 = r10
        L_0x012e:
            java.lang.String r12 = r15.getBoardingTime()     // Catch:{ Exception -> 0x0543 }
            if (r12 == 0) goto L_0x0139
            java.lang.String r12 = r15.getBoardingTime()     // Catch:{ Exception -> 0x0551 }
            goto L_0x013a
        L_0x0139:
            r12 = r10
        L_0x013a:
            java.lang.String r13 = r15.getArrivalTime()     // Catch:{ Exception -> 0x0543 }
            java.lang.String r18 = " "
            if (r13 == 0) goto L_0x0147
            java.lang.String r13 = r15.getArrivalTime()     // Catch:{ Exception -> 0x0551 }
            goto L_0x0149
        L_0x0147:
            r13 = r18
        L_0x0149:
            java.lang.String r19 = r15.getBusType()     // Catch:{ Exception -> 0x0543 }
            if (r19 == 0) goto L_0x0154
            java.lang.String r19 = r15.getBusType()     // Catch:{ Exception -> 0x0551 }
            goto L_0x0156
        L_0x0154:
            r19 = r18
        L_0x0156:
            java.lang.String r20 = r15.getSource()     // Catch:{ Exception -> 0x0543 }
            if (r20 == 0) goto L_0x0161
            java.lang.String r20 = r15.getSource()     // Catch:{ Exception -> 0x0551 }
            goto L_0x0163
        L_0x0161:
            r20 = r18
        L_0x0163:
            java.lang.String r21 = r15.getDestination()     // Catch:{ Exception -> 0x0543 }
            if (r21 == 0) goto L_0x016e
            java.lang.String r21 = r15.getDestination()     // Catch:{ Exception -> 0x0551 }
            goto L_0x0170
        L_0x016e:
            r21 = r10
        L_0x0170:
            java.lang.String r22 = r15.getTravelDate()     // Catch:{ Exception -> 0x0543 }
            if (r22 == 0) goto L_0x0181
            java.lang.String r22 = r15.getTravelDate()     // Catch:{ Exception -> 0x0551 }
            r34 = r22
            r22 = r14
            r14 = r34
            goto L_0x0184
        L_0x0181:
            r22 = r14
            r14 = r10
        L_0x0184:
            java.lang.String r23 = r15.getDuration()     // Catch:{ Exception -> 0x0543 }
            if (r23 == 0) goto L_0x018e
            java.lang.String r18 = r15.getDuration()     // Catch:{ Exception -> 0x0551 }
        L_0x018e:
            java.lang.String r23 = r15.getTravelName()     // Catch:{ Exception -> 0x0543 }
            if (r23 == 0) goto L_0x0199
            java.lang.String r23 = r15.getTravelName()     // Catch:{ Exception -> 0x0551 }
            goto L_0x019b
        L_0x0199:
            r23 = r10
        L_0x019b:
            java.lang.String r24 = r15.getBoardingPointName()     // Catch:{ Exception -> 0x0543 }
            if (r24 == 0) goto L_0x01a6
            java.lang.String r24 = r15.getBoardingPointName()     // Catch:{ Exception -> 0x0551 }
            goto L_0x01a8
        L_0x01a6:
            r24 = r10
        L_0x01a8:
            java.lang.String r25 = r15.getDroppingPointName()     // Catch:{ Exception -> 0x0543 }
            if (r25 == 0) goto L_0x01b9
            java.lang.String r25 = r15.getDroppingPointName()     // Catch:{ Exception -> 0x0551 }
            r34 = r25
            r25 = r0
            r0 = r34
            goto L_0x01bc
        L_0x01b9:
            r25 = r0
            r0 = r10
        L_0x01bc:
            java.lang.String r26 = r15.getDroppingPointAddress()     // Catch:{ Exception -> 0x0543 }
            if (r26 == 0) goto L_0x01cd
            java.lang.String r26 = r15.getDroppingPointAddress()     // Catch:{ Exception -> 0x0551 }
            r34 = r26
            r26 = r0
            r0 = r34
            goto L_0x01d0
        L_0x01cd:
            r26 = r0
            r0 = r10
        L_0x01d0:
            java.lang.String r27 = r15.getBoardingPointAddress()     // Catch:{ Exception -> 0x0543 }
            if (r27 == 0) goto L_0x01dd
            java.lang.String r27 = r15.getBoardingPointAddress()     // Catch:{ Exception -> 0x0551 }
            r28 = r27
            goto L_0x01df
        L_0x01dd:
            r28 = r10
        L_0x01df:
            java.lang.String r27 = r15.getRating()     // Catch:{ Exception -> 0x0543 }
            if (r27 == 0) goto L_0x01f0
            java.lang.String r27 = r15.getRating()     // Catch:{ Exception -> 0x0551 }
            r34 = r27
            r27 = r15
            r15 = r34
            goto L_0x01f3
        L_0x01f0:
            r27 = r15
            r15 = r10
        L_0x01f3:
            java.lang.String r12 = com.paytm.utility.b.a((java.lang.String) r12, (java.lang.String) r9, (java.lang.String) r8)     // Catch:{ Exception -> 0x053f }
            java.lang.String r13 = com.paytm.utility.b.a((java.lang.String) r13, (java.lang.String) r9, (java.lang.String) r8)     // Catch:{ Exception -> 0x053f }
            boolean r29 = r18.isEmpty()     // Catch:{ Exception -> 0x053f }
            if (r29 != 0) goto L_0x020f
            r29 = r8
            r30 = r9
            double r8 = java.lang.Double.parseDouble(r18)     // Catch:{ Exception -> 0x0213 }
            int r8 = (int) r8     // Catch:{ Exception -> 0x0213 }
            java.lang.String r18 = com.travel.bus.orders.h.b.a((int) r8)     // Catch:{ Exception -> 0x0213 }
            goto L_0x0213
        L_0x020f:
            r29 = r8
            r30 = r9
        L_0x0213:
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r8 = r16.getFullFillmentOject()     // Catch:{ Exception -> 0x053f }
            org.json.JSONObject r8 = r8.getFullFillment()     // Catch:{ Exception -> 0x053f }
            if (r8 == 0) goto L_0x0284
            boolean r9 = r8.has(r7)     // Catch:{ Exception -> 0x053f }
            if (r9 == 0) goto L_0x0228
            java.lang.String r9 = r8.getString(r7)     // Catch:{ Exception -> 0x053f }
            goto L_0x0229
        L_0x0228:
            r9 = r10
        L_0x0229:
            boolean r16 = com.travel.bus.orders.h.b.a((org.json.JSONObject) r8)     // Catch:{ Exception -> 0x053f }
            if (r16 == 0) goto L_0x0271
            r16 = r7
            org.json.JSONObject r7 = r8.getJSONObject(r4)     // Catch:{ Exception -> 0x053f }
            org.json.JSONArray r7 = r7.getJSONArray(r3)     // Catch:{ Exception -> 0x053f }
            r31 = r9
            r9 = 0
            org.json.JSONObject r7 = r7.getJSONObject(r9)     // Catch:{ Exception -> 0x053f }
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch:{ Exception -> 0x053f }
            java.lang.String r9 = "duration"
            int r9 = r7.getInt(r9)     // Catch:{ Exception -> 0x053f }
            java.lang.String r18 = com.travel.bus.orders.h.b.a((int) r9)     // Catch:{ Exception -> 0x053f }
            java.lang.String r9 = "bus_type"
            java.lang.String r19 = r7.getString(r9)     // Catch:{ Exception -> 0x053f }
            java.lang.String r9 = "operator_name"
            java.lang.String r23 = r7.getString(r9)     // Catch:{ Exception -> 0x053f }
            java.lang.String r9 = "boarding_point_name"
            java.lang.String r24 = r7.getString(r9)     // Catch:{ Exception -> 0x053f }
            org.json.JSONObject r7 = r8.getJSONObject(r4)     // Catch:{ Exception -> 0x053f }
            org.json.JSONArray r7 = r7.getJSONArray(r3)     // Catch:{ Exception -> 0x053f }
            r8 = 0
            org.json.JSONObject r7 = r7.getJSONObject(r8)     // Catch:{ Exception -> 0x053f }
            r7.getJSONObject(r2)     // Catch:{ Exception -> 0x053f }
            goto L_0x0275
        L_0x0271:
            r16 = r7
            r31 = r9
        L_0x0275:
            r7 = r18
            r8 = r19
            r9 = r23
            r18 = r2
            r19 = r3
            r3 = r24
            r2 = r31
            goto L_0x0293
        L_0x0284:
            r16 = r7
            r7 = r18
            r8 = r19
            r9 = r23
            r18 = r2
            r19 = r3
            r3 = r24
            r2 = 0
        L_0x0293:
            boolean r23 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x053f }
            r24 = r4
            if (r23 != 0) goto L_0x02c8
            android.widget.TextView r4 = r1.k     // Catch:{ Exception -> 0x053f }
            r31 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x053f }
            r3.<init>()     // Catch:{ Exception -> 0x053f }
            r32 = r0
            r33 = r9
            r0 = r20
            r9 = 0
            r20 = r2
            r2 = 1
            java.lang.String r23 = r0.substring(r9, r2)     // Catch:{ Exception -> 0x053f }
            java.lang.String r9 = r23.toUpperCase()     // Catch:{ Exception -> 0x053f }
            r3.append(r9)     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.substring(r2)     // Catch:{ Exception -> 0x053f }
            r3.append(r0)     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x053f }
            r4.setText(r0)     // Catch:{ Exception -> 0x053f }
            goto L_0x02d0
        L_0x02c8:
            r32 = r0
            r20 = r2
            r31 = r3
            r33 = r9
        L_0x02d0:
            boolean r0 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x02fa
            android.widget.TextView r0 = r1.l     // Catch:{ Exception -> 0x053f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x053f }
            r2.<init>()     // Catch:{ Exception -> 0x053f }
            r3 = r21
            r4 = 1
            r9 = 0
            java.lang.String r21 = r3.substring(r9, r4)     // Catch:{ Exception -> 0x053f }
            java.lang.String r9 = r21.toUpperCase()     // Catch:{ Exception -> 0x053f }
            r2.append(r9)     // Catch:{ Exception -> 0x053f }
            java.lang.String r3 = r3.substring(r4)     // Catch:{ Exception -> 0x053f }
            r2.append(r3)     // Catch:{ Exception -> 0x053f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x053f }
            r0.setText(r2)     // Catch:{ Exception -> 0x053f }
        L_0x02fa:
            android.widget.TextView r0 = r1.m     // Catch:{ Exception -> 0x053f }
            java.lang.String r2 = com.travel.bus.orders.h.b.a(r6, r14, r5)     // Catch:{ Exception -> 0x053f }
            r0.setText(r2)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.n     // Catch:{ Exception -> 0x053f }
            java.lang.String r2 = com.travel.bus.orders.h.b.a(r6, r11, r5)     // Catch:{ Exception -> 0x053f }
            r0.setText(r2)     // Catch:{ Exception -> 0x053f }
            boolean r0 = r15.equals(r10)     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x0318
            android.widget.TextView r0 = r1.t     // Catch:{ Exception -> 0x053f }
            r0.setText(r15)     // Catch:{ Exception -> 0x053f }
            goto L_0x031f
        L_0x0318:
            android.widget.TextView r0 = r1.t     // Catch:{ Exception -> 0x053f }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x053f }
        L_0x031f:
            android.widget.TextView r0 = r1.o     // Catch:{ Exception -> 0x053f }
            r0.setText(r12)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.p     // Catch:{ Exception -> 0x053f }
            r0.setText(r13)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.q     // Catch:{ Exception -> 0x053f }
            r0.setText(r7)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.s     // Catch:{ Exception -> 0x053f }
            r0.setText(r8)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.r     // Catch:{ Exception -> 0x053f }
            r2 = r33
            r0.setText(r2)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.w     // Catch:{ Exception -> 0x053f }
            r2 = r20
            r0.setText(r2)     // Catch:{ Exception -> 0x053f }
            r0 = 1
            r1.f22656i = r0     // Catch:{ Exception -> 0x053f }
            android.widget.RelativeLayout r0 = r1.z     // Catch:{ Exception -> 0x053f }
            r3 = 0
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x053f }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x0358
            java.lang.String r0 = "null"
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x0362
        L_0x0358:
            r3 = 0
            r1.f22656i = r3     // Catch:{ Exception -> 0x053f }
            android.widget.RelativeLayout r0 = r1.z     // Catch:{ Exception -> 0x053f }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x053f }
        L_0x0362:
            android.widget.TextView r0 = r1.w     // Catch:{ Exception -> 0x053f }
            com.travel.bus.orders.i.c$3 r3 = new com.travel.bus.orders.i.c$3     // Catch:{ Exception -> 0x053f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x053f }
            r0.setOnClickListener(r3)     // Catch:{ Exception -> 0x053f }
            r0 = r32
            boolean r3 = r0.equals(r10)     // Catch:{ Exception -> 0x053f }
            if (r3 == 0) goto L_0x037c
            android.widget.TextView r0 = r1.u     // Catch:{ Exception -> 0x053f }
            r3 = r26
            r0.setText(r3)     // Catch:{ Exception -> 0x053f }
            goto L_0x0381
        L_0x037c:
            android.widget.TextView r3 = r1.u     // Catch:{ Exception -> 0x053f }
            r3.setText(r0)     // Catch:{ Exception -> 0x053f }
        L_0x0381:
            r0 = r28
            if (r0 == 0) goto L_0x0395
            java.lang.String r3 = r0.trim()     // Catch:{ Exception -> 0x053f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x053f }
            if (r3 != 0) goto L_0x0395
            android.widget.TextView r3 = r1.v     // Catch:{ Exception -> 0x053f }
            r3.setText(r0)     // Catch:{ Exception -> 0x053f }
            goto L_0x039c
        L_0x0395:
            android.widget.TextView r0 = r1.v     // Catch:{ Exception -> 0x053f }
            r3 = r31
            r0.setText(r3)     // Catch:{ Exception -> 0x053f }
        L_0x039c:
            android.widget.TextView r0 = r1.v     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x03c3
            android.widget.TextView r0 = r1.v     // Catch:{ Exception -> 0x053f }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x03c3
            android.widget.TextView r0 = r1.v     // Catch:{ Exception -> 0x053f }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x053f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x03c3
            android.widget.RelativeLayout r0 = r1.x     // Catch:{ Exception -> 0x053f }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x053f }
        L_0x03c3:
            android.widget.TextView r0 = r1.u     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x03ea
            android.widget.TextView r0 = r1.u     // Catch:{ Exception -> 0x053f }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x03ea
            android.widget.TextView r0 = r1.u     // Catch:{ Exception -> 0x053f }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x053f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x03ea
            android.widget.RelativeLayout r0 = r1.y     // Catch:{ Exception -> 0x053f }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x053f }
        L_0x03ea:
            android.widget.ImageView r0 = r1.M     // Catch:{ Exception -> 0x053f }
            r3 = 0
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x053f }
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x0488
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getBusNumber()     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x041d
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getBusNumber()     // Catch:{ Exception -> 0x053f }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x041d
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x053f }
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r3 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r3 = r3.getBusNumber()     // Catch:{ Exception -> 0x053f }
            r0.setText(r3)     // Catch:{ Exception -> 0x053f }
            r0 = 1
            r1.f22654g = r0     // Catch:{ Exception -> 0x053f }
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ Exception -> 0x053f }
            r3 = 0
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x053f }
            goto L_0x0427
        L_0x041d:
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ Exception -> 0x053f }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x053f }
            r3 = 0
            r1.f22654g = r3     // Catch:{ Exception -> 0x053f }
        L_0x0427:
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getDriverPhones()     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x0474
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getDriverPhones()     // Catch:{ Exception -> 0x053f }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x0474
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getDriverPhones()     // Catch:{ Exception -> 0x053f }
            r3 = r25
            boolean r0 = r0.contains(r3)     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x045a
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r4 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r4 = r4.getDriverPhones()     // Catch:{ Exception -> 0x053f }
            java.lang.String r7 = "\n"
            java.lang.String r4 = r4.replaceAll(r3, r7)     // Catch:{ Exception -> 0x053f }
            r0.setDriverPhones(r4)     // Catch:{ Exception -> 0x053f }
        L_0x045a:
            r0 = 1
            r1.f22655h = r0     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.D     // Catch:{ Exception -> 0x053f }
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r4 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r4 = r4.getDriverPhones()     // Catch:{ Exception -> 0x053f }
            r0.setText(r4)     // Catch:{ Exception -> 0x053f }
            android.widget.LinearLayout r0 = r1.I     // Catch:{ Exception -> 0x053f }
            r4 = 0
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
            android.widget.ImageView r0 = r1.M     // Catch:{ Exception -> 0x053f }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
            goto L_0x0485
        L_0x0474:
            r3 = r25
            android.widget.ImageView r0 = r1.M     // Catch:{ Exception -> 0x053f }
            r4 = 8
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
            android.widget.LinearLayout r0 = r1.I     // Catch:{ Exception -> 0x053f }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
            r4 = 0
            r1.f22655h = r4     // Catch:{ Exception -> 0x053f }
        L_0x0485:
            r4 = 8
            goto L_0x049b
        L_0x0488:
            r3 = r25
            r4 = 0
            r1.f22654g = r4     // Catch:{ Exception -> 0x053f }
            r1.f22655h = r4     // Catch:{ Exception -> 0x053f }
            android.widget.RelativeLayout r0 = r1.A     // Catch:{ Exception -> 0x053f }
            r4 = 8
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
            android.widget.LinearLayout r0 = r1.I     // Catch:{ Exception -> 0x053f }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
        L_0x049b:
            boolean r0 = r1.f22655h     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x0515
            boolean r0 = r1.f22654g     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x0515
            android.view.View r0 = r1.E     // Catch:{ Exception -> 0x053f }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
            android.widget.LinearLayout r0 = r1.H     // Catch:{ Exception -> 0x053f }
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x053f }
            boolean r0 = r1.f22656i     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x0512
            com.travel.bus.orders.c.c$b r0 = com.travel.bus.orders.c.c.b.PAYMENT_SUCCESS     // Catch:{ Exception -> 0x053f }
            r4 = r36
            boolean r0 = r4.equals(r0)     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x0529
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getBusNumber()     // Catch:{ Exception -> 0x053f }
            if (r0 == 0) goto L_0x04cb
            com.travel.bus.pojo.busticket.CJRBusOperatorDetails$b r0 = r1.f22648a     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getDriverPhones()     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x0529
        L_0x04cb:
            boolean r0 = r1.L     // Catch:{ Exception -> 0x053f }
            if (r0 != 0) goto L_0x0529
            android.widget.LinearLayout r0 = r1.G     // Catch:{ Exception -> 0x053f }
            r7 = 0
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x053f }
            androidx.fragment.app.FragmentActivity r0 = r1.f22649b     // Catch:{ Exception -> 0x053f }
            int r8 = com.travel.bus.R.string.bus_order_summary_operator_info     // Catch:{ Exception -> 0x053f }
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x053f }
            r9[r7] = r2     // Catch:{ Exception -> 0x053f }
            java.lang.String r0 = r0.getString(r8, r9)     // Catch:{ Exception -> 0x053f }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x053f }
            if (r7 != 0) goto L_0x0529
            android.text.SpannableString r7 = new android.text.SpannableString     // Catch:{ Exception -> 0x053f }
            r7.<init>(r0)     // Catch:{ Exception -> 0x053f }
            com.travel.bus.orders.i.c$4 r8 = new com.travel.bus.orders.i.c$4     // Catch:{ Exception -> 0x053f }
            r8.<init>(r2)     // Catch:{ Exception -> 0x053f }
            int r9 = r0.length()     // Catch:{ Exception -> 0x053f }
            int r2 = r2.length()     // Catch:{ Exception -> 0x053f }
            int r9 = r9 - r2
            int r0 = r0.length()     // Catch:{ Exception -> 0x053f }
            r2 = 0
            r7.setSpan(r8, r9, r0, r2)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.F     // Catch:{ Exception -> 0x053f }
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x053f }
            r0.setMovementMethod(r2)     // Catch:{ Exception -> 0x053f }
            android.widget.TextView r0 = r1.F     // Catch:{ Exception -> 0x053f }
            r0.setText(r7)     // Catch:{ Exception -> 0x053f }
            goto L_0x0529
        L_0x0512:
            r4 = r36
            goto L_0x0529
        L_0x0515:
            r4 = r36
            android.widget.LinearLayout r0 = r1.G     // Catch:{ Exception -> 0x053f }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x053f }
            android.view.View r0 = r1.E     // Catch:{ Exception -> 0x053f }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x053f }
            android.widget.LinearLayout r0 = r1.H     // Catch:{ Exception -> 0x053f }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x053f }
        L_0x0529:
            r0 = r3
            r7 = r16
            r2 = r18
            r3 = r19
            r14 = r22
            r4 = r24
            r15 = r27
            r8 = r29
            r9 = r30
            r12 = 8
            r13 = 0
            goto L_0x00f8
        L_0x053f:
            r0 = move-exception
            r15 = r27
            goto L_0x0555
        L_0x0543:
            r0 = move-exception
            r27 = r15
            goto L_0x0555
        L_0x0547:
            r19 = r3
            r24 = r4
            r4 = r36
            r4 = r24
            goto L_0x00f8
        L_0x0551:
            r0 = move-exception
            goto L_0x0555
        L_0x0553:
            r0 = move-exception
            r15 = 0
        L_0x0555:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x055c:
            java.util.ArrayList<com.travel.bus.pojo.photos.BoardingPhoto> r0 = r1.f22651d
            if (r0 == 0) goto L_0x05d5
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x05d5
            com.travel.bus.orders.a.a r0 = r1.X
            if (r0 != 0) goto L_0x057c
            com.travel.bus.orders.a.a r0 = new com.travel.bus.orders.a.a
            java.util.ArrayList<com.travel.bus.pojo.photos.BoardingPhoto> r2 = r1.f22651d
            androidx.fragment.app.FragmentActivity r3 = r1.f22649b
            r0.<init>(r2, r3)
            r1.X = r0
            androidx.recyclerview.widget.RecyclerView r0 = r1.V
            com.travel.bus.orders.a.a r2 = r1.X
            r0.setAdapter(r2)
        L_0x057c:
            androidx.recyclerview.widget.LinearLayoutManager r0 = r1.Y
            if (r0 != 0) goto L_0x0595
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.view.View r2 = r1.itemView
            android.content.Context r2 = r2.getContext()
            r3 = 0
            r0.<init>(r2, r3, r3)
            r1.Y = r0
            androidx.recyclerview.widget.RecyclerView r0 = r1.V
            androidx.recyclerview.widget.LinearLayoutManager r2 = r1.Y
            r0.setLayoutManager(r2)
        L_0x0595:
            com.travel.bus.orders.h.c r0 = r1.Z
            if (r0 != 0) goto L_0x05ad
            com.travel.bus.orders.h.c r0 = new com.travel.bus.orders.h.c
            android.view.View r2 = r1.itemView
            android.content.Context r2 = r2.getContext()
            r0.<init>(r2)
            r1.Z = r0
            androidx.recyclerview.widget.RecyclerView r0 = r1.V
            com.travel.bus.orders.h.c r2 = r1.Z
            r0.addItemDecoration(r2)
        L_0x05ad:
            java.lang.String r0 = r15.getBoardingPointAddress()
            if (r0 == 0) goto L_0x05b7
            java.lang.String r10 = r15.getBoardingPointAddress()
        L_0x05b7:
            com.travel.bus.orders.a.a r0 = r1.X
            java.util.ArrayList<com.travel.bus.pojo.photos.BoardingPhoto> r2 = r1.f22651d
            java.lang.String r3 = "photos"
            kotlin.g.b.k.c(r2, r3)
            java.lang.String r3 = "boardingPoint"
            kotlin.g.b.k.c(r10, r3)
            r0.f22548b = r2
            r0.f22547a = r10
            com.travel.bus.orders.a.a r0 = r1.X
            r0.notifyDataSetChanged()
            androidx.recyclerview.widget.RecyclerView r0 = r1.V
            r2 = 0
            r0.setVisibility(r2)
            return
        L_0x05d5:
            androidx.recyclerview.widget.RecyclerView r0 = r1.V
            r2 = 8
            r0.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.c.a(com.travel.bus.orders.c.c$b):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f22649b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps?q=" + this.f22650c.getReturn().f22784a + AppConstants.COMMA + this.f22650c.getReturn().f22785b)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        g gVar = this.W;
        if (gVar != null) {
            gVar.a("DP");
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\s");
            String str2 = split.length > 0 ? split[0] : "";
            if (split.length >= 2 && split[0].length() < 10) {
                str2 = split[0] + split[1];
            }
            if (split != null && split.length > 0) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:".concat(String.valueOf(str2))));
                cVar.f22649b.startActivity(intent);
            }
        }
    }
}
