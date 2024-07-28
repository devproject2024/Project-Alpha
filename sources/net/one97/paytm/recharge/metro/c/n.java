package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity;
import net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;

public final class n extends Fragment implements View.OnClickListener, ai {

    /* renamed from: a  reason: collision with root package name */
    private int f63405a = -1;

    /* renamed from: b  reason: collision with root package name */
    private float f63406b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRMetroPenaltyDetailsModel f63407c;

    /* renamed from: d  reason: collision with root package name */
    private AJRMetroTicketSupportActivity f63408d;

    /* renamed from: e  reason: collision with root package name */
    private String f63409e;

    /* renamed from: f  reason: collision with root package name */
    private String f63410f;

    /* renamed from: g  reason: collision with root package name */
    private String f63411g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f63412h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f63413i;
    private TextView j;
    private String k;
    private String l;
    private d m;
    private HashMap n;

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof AJRMetroTicketSupportActivity) {
            this.f63408d = (AJRMetroTicketSupportActivity) context;
            return;
        }
        throw new RuntimeException(n.class.getSimpleName() + " must be instantiated within " + AJRMetroTicketSupportActivity.class.getSimpleName());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.f63405a = arguments.getInt("layoutType");
            if (this.f63405a != -1) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                Serializable serializable = arguments2.getSerializable("metroPenaltyDetails");
                if (serializable != null) {
                    this.f63407c = (CJRMetroPenaltyDetailsModel) serializable;
                    if (this.f63407c != null) {
                        Bundle arguments3 = getArguments();
                        if (arguments3 == null) {
                            k.a();
                        }
                        this.f63409e = arguments3.getString("product-type");
                        if (!TextUtils.isEmpty(this.f63409e)) {
                            Bundle arguments4 = getArguments();
                            if (arguments4 == null) {
                                k.a();
                            }
                            this.f63411g = arguments4.getString("Mumbai Metro");
                            if (!TextUtils.isEmpty(this.f63411g)) {
                                Bundle arguments5 = getArguments();
                                if (arguments5 == null) {
                                    k.a();
                                }
                                this.f63410f = arguments5.getString("BALANCE");
                                Bundle arguments6 = getArguments();
                                if (arguments6 != null && arguments6.containsKey("metro_event_category")) {
                                    Bundle arguments7 = getArguments();
                                    if (arguments7 == null) {
                                        k.a();
                                    }
                                    this.l = arguments7.getString("metro_event_category");
                                }
                                Bundle arguments8 = getArguments();
                                if (arguments8 != null && arguments8.containsKey("metro_event_label")) {
                                    Bundle arguments9 = getArguments();
                                    if (arguments9 == null) {
                                        k.a();
                                    }
                                    this.k = arguments9.getString("metro_event_label");
                                }
                                if (getContext() != null) {
                                    Context context = getContext();
                                    if (context == null) {
                                        k.a();
                                    }
                                    k.a((Object) context, "context!!");
                                    this.m = new d(context);
                                    return;
                                }
                                return;
                            }
                            throw new RuntimeException("product type required");
                        }
                        throw new RuntimeException("product type required");
                    }
                    throw new RuntimeException(CJRMetroPenaltyDetailsModel.class.getName() + " model_1 required");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel");
            }
            throw new RuntimeException("Layout type required");
        }
        throw new RuntimeException("Arguments required");
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0664  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0669  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0672  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x06a7  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x06cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r37, android.view.ViewGroup r38, android.os.Bundle r39) {
        /*
            r36 = this;
            r7 = r36
            java.lang.String r0 = "inflater"
            r1 = r37
            kotlin.g.b.k.c(r1, r0)
            android.content.Context r0 = r36.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = net.one97.paytm.recharge.R.layout.fragment_metro_penalty_v2
            r8 = 0
            r9 = 0
            android.view.View r10 = r0.inflate(r1, r8, r9)
            int r0 = net.one97.paytm.recharge.R.id.txt_title_penalty
            android.view.View r0 = r10.findViewById(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
            if (r0 == 0) goto L_0x074e
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7.j = r0
            int r0 = net.one97.paytm.recharge.R.id.exceed_time_limit_text
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0748
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r0 = net.one97.paytm.recharge.R.id.know_more_txt
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0742
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7.f63413i = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_station_entry_name
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x073c
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r0 = net.one97.paytm.recharge.R.id.txt_station_exit_name
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0736
            r13 = r0
            android.widget.TextView r13 = (android.widget.TextView) r13
            int r0 = net.one97.paytm.recharge.R.id.txt_station_entry_time
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0730
            r14 = r0
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r0 = net.one97.paytm.recharge.R.id.txt_station_exit_time
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x072a
            r15 = r0
            android.widget.TextView r15 = (android.widget.TextView) r15
            int r0 = net.one97.paytm.recharge.R.id.txt_btn_proceed_to_pay
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0724
            r6 = r0
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r0 = net.one97.paytm.recharge.R.id.txt_src_station
            android.view.View r0 = r10.findViewById(r0)
            r5 = r0
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r0 = net.one97.paytm.recharge.R.id.txt_dst_station
            android.view.View r0 = r10.findViewById(r0)
            r4 = r0
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r0 = net.one97.paytm.recharge.R.id.txt_tmp_dst_station
            android.view.View r0 = r10.findViewById(r0)
            r16 = r0
            android.widget.TextView r16 = (android.widget.TextView) r16
            int r0 = net.one97.paytm.recharge.R.id.ic_arrow
            android.view.View r0 = r10.findViewById(r0)
            r3 = r0
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            int r0 = net.one97.paytm.recharge.R.id.validity
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x071e
            r2 = r0
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r0 = net.one97.paytm.recharge.R.id.txt_title_overtime
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0718
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r8 = net.one97.paytm.recharge.R.id.txt_overtime_duration_new
            android.view.View r8 = r10.findViewById(r8)
            if (r8 == 0) goto L_0x0712
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = net.one97.paytm.recharge.R.id.txt_new_destination
            android.view.View r9 = r10.findViewById(r9)
            if (r9 == 0) goto L_0x070c
            android.widget.TextView r9 = (android.widget.TextView) r9
            r39 = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_new_destination_name
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0706
            android.widget.TextView r0 = (android.widget.TextView) r0
            r17 = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_title_penalty_reason
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x0700
            android.widget.TextView r0 = (android.widget.TextView) r0
            r18 = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_penalty_total_cost
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x06fa
            android.widget.TextView r0 = (android.widget.TextView) r0
            r19 = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_title_new_destination_change_penalty
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x06f4
            android.widget.TextView r0 = (android.widget.TextView) r0
            r20 = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_destination_change_penalty_cost
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x06ee
            android.widget.TextView r0 = (android.widget.TextView) r0
            r21 = r0
            int r0 = net.one97.paytm.recharge.R.id.penalty_divider
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x06e6
            r22 = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_title_total
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x06e0
            android.widget.TextView r0 = (android.widget.TextView) r0
            r23 = r0
            int r0 = net.one97.paytm.recharge.R.id.txt_penalty_total
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x06da
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r0 = net.one97.paytm.recharge.R.id.lyt_loading
            android.view.View r0 = r10.findViewById(r0)
            if (r0 == 0) goto L_0x06d2
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r7.f63412h = r0
            java.lang.String r0 = "srcStation"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r0 = r7.f63407c
            if (r0 != 0) goto L_0x013a
            kotlin.g.b.k.a()
        L_0x013a:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = r0.getActualSource()
            r24 = r10
            java.lang.String r10 = "mPenaltyDetails!!.actualSource"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            java.lang.String r0 = r0.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            java.lang.String r0 = "dstStation"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r0 = r7.f63407c
            if (r0 != 0) goto L_0x015a
            kotlin.g.b.k.a()
        L_0x015a:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = r0.getActualDestination()
            r25 = r14
            java.lang.String r14 = "mPenaltyDetails!!.actualDestination"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r14)
            java.lang.String r0 = r0.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            android.view.ViewTreeObserver r0 = r4.getViewTreeObserver()
            if (r0 == 0) goto L_0x01b9
            net.one97.paytm.recharge.metro.c.n$b r26 = new net.one97.paytm.recharge.metro.c.n$b
            r27 = r15
            r28 = r22
            r29 = r23
            r15 = r39
            r39 = r13
            r13 = r17
            r17 = r14
            r14 = r18
            r18 = r12
            r12 = r0
            r35 = r19
            r19 = r10
            r10 = r20
            r20 = r11
            r11 = r21
            r21 = r35
            r0 = r26
            r30 = r1
            r1 = r36
            r22 = r2
            r2 = r4
            r23 = r3
            r3 = r22
            r31 = r4
            r4 = r16
            r16 = r5
            r32 = r6
            r6 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r26
            android.view.ViewTreeObserver$OnGlobalLayoutListener r0 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r0
            r12.addOnGlobalLayoutListener(r0)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x01e3
        L_0x01b9:
            r30 = r1
            r31 = r4
            r16 = r5
            r32 = r6
            r27 = r15
            r28 = r22
            r29 = r23
            r15 = r39
            r22 = r2
            r23 = r3
            r39 = r13
            r13 = r17
            r17 = r14
            r14 = r18
            r18 = r12
            r35 = r19
            r19 = r10
            r10 = r20
            r20 = r11
            r11 = r21
            r21 = r35
        L_0x01e3:
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r0 = r7.f63407c
            if (r0 != 0) goto L_0x01ea
            kotlin.g.b.k.a()
        L_0x01ea:
            java.util.List r0 = r0.getPenalties()
            int r1 = r7.f63405a
            java.lang.String r3 = "txtTitlePenalty"
            java.lang.String r4 = "java.lang.String.format(format, *args)"
            java.lang.String r5 = "getString(R.string.metro_mumbai_proceed_to_pay)"
            java.lang.String r6 = "reasons[0]"
            r2 = 1
            if (r1 == r2) goto L_0x04a4
            r12 = 2
            java.lang.String r2 = "mPenaltyDetails!!.newDestination"
            if (r1 == r12) goto L_0x03a5
            r6 = 3
            if (r1 == r6) goto L_0x0207
            r2 = r32
            goto L_0x05ca
        L_0x0207:
            r1 = 0
            r7.f63406b = r1
            java.util.Iterator r1 = r0.iterator()
        L_0x020e:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0365
            java.lang.Object r6 = r1.next()
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r6 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r6
            java.lang.String r12 = "reasonObj"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
            java.lang.String r12 = r6.getReason()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x029b
            java.lang.String r12 = r6.getReason()
            r20 = r1
            java.lang.String r1 = "Overtravelling Charges"
            r33 = r0
            r0 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r12, (boolean) r0)
            if (r1 == 0) goto L_0x029f
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_new_destination_station
            java.lang.String r0 = r7.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r0 = r7.f63407c
            if (r0 != 0) goto L_0x024e
            kotlin.g.b.k.a()
        L_0x024e:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = r0.getNewDestination()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setText(r0)
            if (r10 == 0) goto L_0x0268
            r0 = r10
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0268:
            if (r11 == 0) goto L_0x0272
            r0 = r11
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0272:
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_overtime_charges_new
            r1 = 1
            java.lang.Object[] r12 = new java.lang.Object[r1]
            float r26 = r6.getAmount()
            r34 = r13
            java.lang.String r13 = java.lang.String.valueOf(r26)
            java.lang.String r13 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r13, (boolean) r1)
            r1 = 0
            r12[r1] = r13
            java.lang.String r0 = r7.getString(r0, r12)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r11.setText(r0)
            float r0 = r7.f63406b
            float r1 = r6.getAmount()
            float r0 = r0 + r1
            r7.f63406b = r0
            goto L_0x02c7
        L_0x029b:
            r33 = r0
            r20 = r1
        L_0x029f:
            r34 = r13
            java.lang.String r0 = r6.getReason()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x032c
            java.lang.String r0 = r6.getReason()
            java.lang.String r1 = "Exit Station Excess Time Penalty"
            r12 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r12)
            if (r0 != 0) goto L_0x02cd
            java.lang.String r0 = r6.getReason()
            java.lang.String r1 = "Same Station Excess Time Penalty"
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r12)
            if (r0 == 0) goto L_0x02c7
            goto L_0x02cd
        L_0x02c7:
            r12 = r21
            r0 = r28
            r1 = 0
            goto L_0x0331
        L_0x02cd:
            java.lang.String r0 = r6.getOverTime()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02ea
            r0 = 0
            r15.setVisibility(r0)
            r8.setVisibility(r0)
            java.lang.String r0 = r6.getOverTime()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            goto L_0x02f2
        L_0x02ea:
            r0 = 8
            r15.setVisibility(r0)
            r8.setVisibility(r0)
        L_0x02f2:
            r0 = r14
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            if (r21 == 0) goto L_0x0303
            r0 = r21
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0303:
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_overtime_charges_new
            r1 = 1
            java.lang.Object[] r12 = new java.lang.Object[r1]
            float r13 = r6.getAmount()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r13 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r13, (boolean) r1)
            r1 = 0
            r12[r1] = r13
            java.lang.String r0 = r7.getString(r0, r12)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12 = r21
            r12.setText(r0)
            float r0 = r7.f63406b
            float r6 = r6.getAmount()
            float r0 = r0 + r6
            r7.f63406b = r0
            goto L_0x032f
        L_0x032c:
            r12 = r21
            r1 = 0
        L_0x032f:
            r0 = r28
        L_0x0331:
            r0.setVisibility(r1)
            r6 = r29
            r6.setVisibility(r1)
            int r13 = net.one97.paytm.recharge.R.string.metro_mumbai_overtime_charges_new
            r28 = r0
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            float r6 = r7.f63406b
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r6, (boolean) r1)
            r1 = 0
            r0[r1] = r6
            java.lang.String r0 = r7.getString(r13, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6 = r30
            r6.setText(r0)
            r6.setVisibility(r1)
            r21 = r12
            r1 = r20
            r0 = r33
            r13 = r34
            goto L_0x020e
        L_0x0365:
            r33 = r0
            android.widget.TextView r0 = r7.j
            if (r0 != 0) goto L_0x036e
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x036e:
            int r1 = net.one97.paytm.recharge.R.string.metro_mumbai_title_overtime_with_change_destination_revamp
            r0.setText(r1)
            kotlin.g.b.aa r0 = kotlin.g.b.aa.f47921a
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_proceed_to_pay
            java.lang.String r0 = r7.getString(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            float r3 = r7.f63406b
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r3, (boolean) r1)
            r5 = 0
            r2[r5] = r3
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r0 = java.lang.String.format(r0, r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = r32
            r1.setText(r0)
            r2 = r1
            r0 = r33
            goto L_0x05ca
        L_0x03a5:
            r33 = r0
            r34 = r13
            r12 = r21
            r1 = r32
            r0 = 8
            r15.setVisibility(r0)
            r8.setVisibility(r0)
            r14.setVisibility(r0)
            r12.setVisibility(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r8 = 23
            if (r0 < r8) goto L_0x03cc
            int r0 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r10.setTextAppearance(r0)
            int r0 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r11.setTextAppearance(r0)
            goto L_0x03de
        L_0x03cc:
            android.content.Context r0 = r36.getContext()
            int r8 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r10.setTextAppearance(r0, r8)
            android.content.Context r0 = r36.getContext()
            int r8 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r11.setTextAppearance(r0, r8)
        L_0x03de:
            android.widget.TextView r0 = r7.f63413i
            if (r0 == 0) goto L_0x03ed
            int r8 = net.one97.paytm.recharge.R.string.what_is_penalty
            java.lang.String r8 = r7.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
        L_0x03ed:
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_change_destination_desc
            java.lang.String r0 = r7.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13 = r20
            r13.setText(r0)
            android.widget.TextView r0 = r7.j
            if (r0 != 0) goto L_0x0401
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0401:
            int r3 = net.one97.paytm.recharge.R.string.metro_mumbai_title_change_destination_revamp
            r0.setText(r3)
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_new_destination_station
            java.lang.String r0 = r7.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r0 = r7.f63407c
            if (r0 != 0) goto L_0x0418
            kotlin.g.b.k.a()
        L_0x0418:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = r0.getNewDestination()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2 = r34
            r2.setText(r0)
            if (r10 == 0) goto L_0x0434
            r0 = r10
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0434:
            if (r11 == 0) goto L_0x043e
            r0 = r11
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x043e:
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_overtime_charges_new
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r8 = r33
            r9 = 0
            java.lang.Object r10 = r8.get(r9)
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r6)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r10 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r10
            float r10 = r10.getAmount()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r10 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r10, (boolean) r2)
            r3[r9] = r10
            java.lang.String r0 = r7.getString(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r11.setText(r0)
            java.lang.Object r0 = r8.get(r9)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r0 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r0
            float r0 = r0.getAmount()
            r7.f63406b = r0
            kotlin.g.b.aa r0 = kotlin.g.b.aa.f47921a
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_proceed_to_pay
            java.lang.String r0 = r7.getString(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            float r5 = r7.f63406b
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r5, (boolean) r2)
            r6 = 0
            r3[r6] = r5
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)
            java.lang.String r0 = java.lang.String.format(r0, r3)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            r2 = r1
            r0 = r8
            goto L_0x05ca
        L_0x04a4:
            r2 = r13
            r13 = r20
            r12 = r21
            r1 = 8
            r9.setVisibility(r1)
            r2.setVisibility(r1)
            r10.setVisibility(r1)
            r11.setVisibility(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L_0x04c8
            int r1 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r14.setTextAppearance(r1)
            int r1 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r11.setTextAppearance(r1)
            goto L_0x04da
        L_0x04c8:
            android.content.Context r1 = r36.getContext()
            int r2 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r14.setTextAppearance(r1, r2)
            android.content.Context r1 = r36.getContext()
            int r2 = net.one97.paytm.recharge.R.style.radioButtonSelectedStyle
            r11.setTextAppearance(r1, r2)
        L_0x04da:
            android.widget.TextView r1 = r7.f63413i
            if (r1 == 0) goto L_0x04e9
            int r2 = net.one97.paytm.recharge.R.string.what_is_penalty
            java.lang.String r2 = r7.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x04e9:
            int r1 = net.one97.paytm.recharge.R.string.metro_mumbai_exceed_time
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.setText(r1)
            android.widget.TextView r1 = r7.j
            if (r1 != 0) goto L_0x04fb
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x04fb:
            int r2 = net.one97.paytm.recharge.R.string.metro_mumbai_title_overtime_revamp
            r1.setText(r2)
            int r1 = net.one97.paytm.recharge.R.string.metro_mumbai_overtime_charges_new     // Catch:{ Exception -> 0x0529 }
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0529 }
            r2 = 0
            java.lang.Object r9 = r0.get(r2)     // Catch:{ Exception -> 0x0529 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)     // Catch:{ Exception -> 0x0529 }
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r9 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r9     // Catch:{ Exception -> 0x0529 }
            float r2 = r9.getAmount()     // Catch:{ Exception -> 0x0529 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0529 }
            r9 = 1
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r2, (boolean) r9)     // Catch:{ Exception -> 0x0529 }
            r9 = 0
            r3[r9] = r2     // Catch:{ Exception -> 0x0529 }
            java.lang.String r1 = r7.getString(r1, r3)     // Catch:{ Exception -> 0x0529 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0529 }
            r12.setText(r1)     // Catch:{ Exception -> 0x0529 }
            goto L_0x0553
        L_0x0529:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "₹ "
            r1.<init>(r2)
            r2 = 0
            java.lang.Object r3 = r0.get(r2)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r3 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r3
            float r2 = r3.getAmount()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 1
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r2, (boolean) r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
        L_0x0553:
            if (r14 == 0) goto L_0x055d
            r1 = r14
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.a(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x055d:
            if (r12 == 0) goto L_0x0567
            r1 = r12
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.a(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0567:
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r2 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r2
            java.lang.String r1 = r2.getOverTime()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
            if (r15 == 0) goto L_0x0584
            r1 = r15
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.a(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0584:
            if (r8 == 0) goto L_0x058d
            android.view.View r8 = (android.view.View) r8
            net.one97.paytm.recharge.common.utils.ai.a(r8)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x058d:
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r2 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r2
            float r1 = r2.getAmount()
            r7.f63406b = r1
            kotlin.g.b.aa r1 = kotlin.g.b.aa.f47921a
            int r1 = net.one97.paytm.recharge.R.string.metro_mumbai_proceed_to_pay
            java.lang.String r1 = r7.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            float r5 = r7.f63406b
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r5, (boolean) r2)
            r6 = 0
            r3[r6] = r5
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)
            java.lang.String r1 = java.lang.String.format(r1, r3)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = r32
            r2.setText(r1)
        L_0x05ca:
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r1 = r7.f63407c
            if (r1 != 0) goto L_0x05d1
            kotlin.g.b.k.a()
        L_0x05d1:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r1 = r1.getActualSource()
            r3 = r19
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r1 = r1.getName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = r18
            r3.setText(r1)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r1 = r7.f63407c
            if (r1 != 0) goto L_0x05ec
            kotlin.g.b.k.a()
        L_0x05ec:
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r1 = r1.getActualDestination()
            r3 = r17
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r1 = r1.getName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = r39
            r3.setText(r1)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r1 = r7.f63407c
            if (r1 != 0) goto L_0x0607
            kotlin.g.b.k.a()
        L_0x0607:
            java.lang.String r1 = r1.getExpiryTime()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = r27
            r3.setText(r1)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r1 = r7.f63407c
            if (r1 != 0) goto L_0x0619
            kotlin.g.b.k.a()
        L_0x0619:
            java.lang.String r1 = r1.getEntryTime()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x065b
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r1 = r7.f63407c
            if (r1 != 0) goto L_0x062c
            kotlin.g.b.k.a()
        L_0x062c:
            java.lang.String r1 = r1.getEntryTime()
            java.lang.String r3 = "-"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x065b
            r1 = r25
            r4 = 0
            r1.setVisibility(r4)
            int r5 = net.one97.paytm.recharge.R.string.metro_mumbai_entry_time
            java.lang.Object[] r6 = new java.lang.Object[r3]
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r3 = r7.f63407c
            if (r3 != 0) goto L_0x064b
            kotlin.g.b.k.a()
        L_0x064b:
            java.lang.String r3 = r3.getEntryTime()
            r6[r4] = r3
            java.lang.String r3 = r7.getString(r5, r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            goto L_0x065c
        L_0x065b:
            r4 = 0
        L_0x065c:
            java.lang.Object r1 = r0.get(r4)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r1 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r1
            if (r1 == 0) goto L_0x0669
            java.lang.String r8 = r1.getMaxAllowedTime()
            goto L_0x066a
        L_0x0669:
            r8 = 0
        L_0x066a:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L_0x06a7
            r1 = r22
            r1.setVisibility(r4)
            java.lang.Object r0 = r0.get(r4)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r0 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r0
            if (r0 == 0) goto L_0x0685
            java.lang.String r0 = r0.getMaxAllowedTime()
            if (r0 != 0) goto L_0x06a1
        L_0x0685:
            int r0 = net.one97.paytm.recharge.R.string.metro_validity
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r4 = r7.f63407c
            if (r4 != 0) goto L_0x0691
            kotlin.g.b.k.a()
        L_0x0691:
            java.lang.String r4 = r4.getValidity()
            r5 = 0
            r3[r5] = r4
            java.lang.String r0 = r7.getString(r0, r3)
            java.lang.String r3 = "getString(R.string.metro…enaltyDetails!!.validity)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
        L_0x06a1:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x06c2
        L_0x06a7:
            r5 = r16
            android.view.View r5 = (android.view.View) r5
            net.one97.paytm.recharge.common.utils.ai.a(r5)
            java.lang.String r0 = "imgArrow"
            r1 = r23
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            r3 = r1
            android.view.View r3 = (android.view.View) r3
            net.one97.paytm.recharge.common.utils.ai.a(r3)
            r4 = r31
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.recharge.common.utils.ai.a(r4)
        L_0x06c2:
            r0 = r7
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r2.setOnClickListener(r0)
            android.widget.TextView r1 = r7.f63413i
            if (r1 == 0) goto L_0x06d1
            r1.setOnClickListener(r0)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x06d1:
            return r24
        L_0x06d2:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.RelativeLayout"
            r0.<init>(r1)
            throw r0
        L_0x06da:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x06e0:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x06e6:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.view.View"
            r0.<init>(r1)
            throw r0
        L_0x06ee:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x06f4:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x06fa:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0700:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0706:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x070c:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0712:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0718:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x071e:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0724:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x072a:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0730:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0736:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x073c:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0742:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x0748:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        L_0x074e:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.n.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f63415a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f63416b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f63417c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f63418d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f63419e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ImageView f63420f;

        b(n nVar, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView) {
            this.f63415a = nVar;
            this.f63416b = textView;
            this.f63417c = textView2;
            this.f63418d = textView3;
            this.f63419e = textView4;
            this.f63420f = imageView;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver = this.f63416b.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            if (this.f63416b.getRight() <= this.f63417c.getLeft() - 10 || this.f63417c.getVisibility() != 0) {
                TextView textView = this.f63419e;
                k.a((Object) textView, "srcStation");
                net.one97.paytm.recharge.common.utils.ai.a(textView);
                ImageView imageView = this.f63420f;
                k.a((Object) imageView, "imgArrow");
                net.one97.paytm.recharge.common.utils.ai.a(imageView);
                net.one97.paytm.recharge.common.utils.ai.a(this.f63416b);
                return;
            }
            net.one97.paytm.recharge.common.utils.ai.b(this.f63416b);
            TextView textView2 = this.f63418d;
            k.a((Object) textView2, "dstTmpStation");
            CJRMetroPenaltyDetailsModel a2 = this.f63415a.f63407c;
            if (a2 == null) {
                k.a();
            }
            CJRMetroStationModel actualDestination = a2.getActualDestination();
            k.a((Object) actualDestination, "mPenaltyDetails!!.actualDestination");
            textView2.setText(actualDestination.getName());
            TextView textView3 = this.f63419e;
            k.a((Object) textView3, "srcStation");
            net.one97.paytm.recharge.common.utils.ai.a(textView3);
            ImageView imageView2 = this.f63420f;
            k.a((Object) imageView2, "imgArrow");
            net.one97.paytm.recharge.common.utils.ai.a(imageView2);
            TextView textView4 = this.f63418d;
            k.a((Object) textView4, "dstTmpStation");
            net.one97.paytm.recharge.common.utils.ai.a(textView4);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f63414a;

        a(View view) {
            this.f63414a = view;
        }

        public final void run() {
            this.f63414a.setEnabled(true);
            this.f63414a.setClickable(true);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(25:25|26|(5:28|(1:30)(1:31)|32|(1:34)(1:35)|36)|37|38|39|42|(1:44)|45|(1:47)|48|(1:50)|51|(1:53)|54|(1:56)|57|(1:59)|60|(1:62)|63|(3:65|(1:67)(1:68)|(5:70|(15:73|74|75|(1:77)(1:78)|79|(1:81)(1:82)|83|(1:85)(1:86)|87|(1:89)|90|(1:92)|93|94|(1:96)(1:97))(1:100)|101|102|(3:104|105|(4:107|108|109|110)(2:111|(2:113|114)(2:115|(2:117|119)(1:123))))(1:122)))|71|(0)(0)|(3:101|102|(0)(0))) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f8, code lost:
        net.one97.paytm.recharge.metro.c.n.class.getSimpleName();
        com.paytm.utility.q.b(r0.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00df */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0372 A[Catch:{ all -> 0x03a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r27) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            java.lang.String r2 = ""
            java.lang.String r3 = "v"
            kotlin.g.b.k.c(r0, r3)
            int r3 = r27.getId()
            int r4 = net.one97.paytm.recharge.R.id.know_more_txt
            r5 = 0
            r6 = 0
            if (r3 != r4) goto L_0x00a2
            android.content.Context r0 = r26.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0094
            android.widget.RelativeLayout r0 = r1.f63412h
            if (r0 == 0) goto L_0x0026
            r0.setVisibility(r6)
        L_0x0026:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r5, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r5)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 != 0) goto L_0x0059
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r3 = r2
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r25 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
        L_0x0059:
            r0.setFlowName(r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x006b
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r3 = r3.name()
            r2.setErrorType(r3)
        L_0x006b:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x007a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.GET_PENALTY_MSG
            java.lang.String r3 = r3.name()
            r2.setActionType(r3)
        L_0x007a:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r0.getFlowName()
            if (r2 == 0) goto L_0x0085
            java.lang.String r3 = r1.f63409e
            r2.setVariantType(r3)
        L_0x0085:
            android.content.Context r2 = r26.getContext()
            r3 = r1
            net.one97.paytm.recharge.common.e.ai r3 = (net.one97.paytm.recharge.common.e.ai) r3
            java.lang.String r4 = r1.f63411g
            java.lang.String r5 = "fetch_metro_panality_message"
            net.one97.paytm.recharge.metro.f.a.a((java.lang.String) r5, (android.content.Context) r2, (net.one97.paytm.recharge.common.e.ai) r3, (java.lang.String) r4, (java.lang.Object) r0)
            return
        L_0x0094:
            android.content.Context r0 = r26.getContext()
            int r2 = net.one97.paytm.recharge.R.string.network_error_heading_re
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r6)
            r0.show()
            return
        L_0x00a2:
            int r4 = net.one97.paytm.recharge.R.id.txt_btn_proceed_to_pay
            if (r3 != r4) goto L_0x03a9
            net.one97.paytm.recharge.ordersummary.h.d r7 = r1.m     // Catch:{ all -> 0x00df }
            if (r7 == 0) goto L_0x00ca
            java.lang.String r3 = r1.l     // Catch:{ all -> 0x00df }
            if (r3 != 0) goto L_0x00b0
            r8 = r2
            goto L_0x00b1
        L_0x00b0:
            r8 = r3
        L_0x00b1:
            java.lang.String r9 = "exit_station_proceed_to_pay_clicked"
            java.lang.String r10 = ""
            java.lang.String r3 = r1.k     // Catch:{ all -> 0x00df }
            if (r3 != 0) goto L_0x00bb
            r11 = r2
            goto L_0x00bc
        L_0x00bb:
            r11 = r3
        L_0x00bc:
            java.lang.String r12 = net.one97.paytm.recharge.common.utils.ab.f61496a     // Catch:{ all -> 0x00df }
            java.lang.String r3 = "CJRRechargeUtilityConstant.UTILITY"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)     // Catch:{ all -> 0x00df }
            r13 = 0
            r14 = 0
            r15 = 96
            net.one97.paytm.recharge.ordersummary.h.d.a(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00df }
        L_0x00ca:
            net.one97.paytm.recharge.di.helper.b r3 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x00df }
            android.content.Context r7 = r26.getContext()     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "mumbai metro qr"
            java.lang.String r9 = "over_time_proceed_to_pay_clicked"
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            java.lang.String r12 = "/utility/over time-proceed to pay"
            java.lang.String r13 = "utility"
            net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ all -> 0x00df }
        L_0x00df:
            r0.setEnabled(r6)     // Catch:{ Exception -> 0x00f7 }
            r0.setClickable(r6)     // Catch:{ Exception -> 0x00f7 }
            android.os.Handler r3 = new android.os.Handler     // Catch:{ Exception -> 0x00f7 }
            r3.<init>()     // Catch:{ Exception -> 0x00f7 }
            net.one97.paytm.recharge.metro.c.n$a r4 = new net.one97.paytm.recharge.metro.c.n$a     // Catch:{ Exception -> 0x00f7 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00f7 }
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch:{ Exception -> 0x00f7 }
            r7 = 200(0xc8, double:9.9E-322)
            r3.postDelayed(r4, r7)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x0104
        L_0x00f7:
            r0 = move-exception
            java.lang.Class<net.one97.paytm.recharge.metro.c.n> r3 = net.one97.paytm.recharge.metro.c.n.class
            r3.getSimpleName()
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0104:
            net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity r0 = r1.f63408d
            if (r0 != 0) goto L_0x010b
            kotlin.g.b.k.a()
        L_0x010b:
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r3 = r1.f63407c
            if (r3 != 0) goto L_0x0112
            kotlin.g.b.k.a()
        L_0x0112:
            float r4 = r1.f63406b
            java.lang.String r7 = "penaltyDetails"
            kotlin.g.b.k.c(r3, r7)
            net.one97.paytm.recharge.metro.a r8 = new net.one97.paytm.recharge.metro.a
            r9 = r0
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r9 = (net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity) r9
            java.lang.String r10 = r0.f63231d
            r8.<init>(r9, r10)
            r0.f63228a = r8
            net.one97.paytm.recharge.metro.a r8 = r0.f63228a
            if (r8 != 0) goto L_0x012c
            kotlin.g.b.k.a()
        L_0x012c:
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r9 = r0.f63230c
            if (r9 != 0) goto L_0x0135
            java.lang.String r10 = "mQRCode"
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0135:
            r8.f63126c = r9
            net.one97.paytm.recharge.metro.a r8 = r0.f63228a
            if (r8 != 0) goto L_0x013e
            kotlin.g.b.k.a()
        L_0x013e:
            kotlin.g.b.k.c(r3, r7)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r17 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r5, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r5)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r17.getFlowName()
            if (r0 == 0) goto L_0x0156
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r7 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.METRO_VERIFY
            java.lang.String r7 = r7.name()
            r0.setActionType(r7)
        L_0x0156:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r17.getFlowName()
            if (r0 == 0) goto L_0x0165
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r7 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r7 = r7.name()
            r0.setErrorType(r7)
        L_0x0165:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r8.f63124a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r7 = r8.f63124a
            android.content.Context r7 = (android.content.Context) r7
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r9 = r8.f63124a
            int r10 = net.one97.paytm.recharge.R.string.please_wait_progress_msg_re
            java.lang.String r9 = r9.getString(r10)
            r0.a((android.content.Context) r7, (java.lang.String) r9)
            r8.f63125b = r3
            net.one97.paytm.recharge.common.utils.ax$a r0 = net.one97.paytm.recharge.common.utils.ax.f61521a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r8.f63124a
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r7 = "mBaseActivity.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            com.paytm.b.a.a r0 = net.one97.paytm.recharge.common.utils.ax.a.a(r0)
            r7 = 1
            java.lang.String r9 = "sso_token="
            java.lang.String r0 = r0.b((java.lang.String) r9, (java.lang.String) r2, (boolean) r7)
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            r2 = r2 ^ r7
            if (r2 == 0) goto L_0x01a6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x01a1
            r0 = 1
            goto L_0x01a2
        L_0x01a1:
            r0 = 0
        L_0x01a2:
            if (r0 == 0) goto L_0x01a6
            r0 = 1
            goto L_0x01a7
        L_0x01a6:
            r0 = 0
        L_0x01a7:
            if (r0 == 0) goto L_0x0321
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r11 = "product_id"
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r12 = r8.f63126c     // Catch:{ Exception -> 0x02d8 }
            if (r12 == 0) goto L_0x01cc
            long r12 = r12.getProductId()     // Catch:{ Exception -> 0x02d8 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x02d8 }
            goto L_0x01cd
        L_0x01cc:
            r12 = r5
        L_0x01cd:
            r9.put(r11, r12)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r11 = "qty"
            r9.put(r11, r7)     // Catch:{ Exception -> 0x02d8 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x02d8 }
            r7.<init>()     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r11 = "price"
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ Exception -> 0x02d8 }
            r7.put(r11, r4)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r4 = net.one97.paytm.recharge.common.utils.ab.f61497b     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r11 = com.paytm.utility.e.z     // Catch:{ Exception -> 0x02d8 }
            r7.put(r4, r11)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r4 = "tokenType"
            int r11 = r3.getCode()     // Catch:{ Exception -> 0x02d8 }
            r10.put(r4, r11)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r4 = "source_id"
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r11 = r3.getActualSource()     // Catch:{ Exception -> 0x02d8 }
            if (r11 == 0) goto L_0x0200
            java.lang.String r11 = r11.getId()     // Catch:{ Exception -> 0x02d8 }
            goto L_0x0201
        L_0x0200:
            r11 = r5
        L_0x0201:
            r10.put(r4, r11)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r4 = "destination_id"
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r11 = r3.getNewDestination()     // Catch:{ Exception -> 0x02d8 }
            if (r11 == 0) goto L_0x0211
            java.lang.String r11 = r11.getId()     // Catch:{ Exception -> 0x02d8 }
            goto L_0x0212
        L_0x0211:
            r11 = r5
        L_0x0212:
            r10.put(r4, r11)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r4 = "parentOrderId"
            long r11 = r3.getOrderId()     // Catch:{ Exception -> 0x02d8 }
            r10.put(r4, r11)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r3 = "qrcodeid"
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r4 = r8.f63126c     // Catch:{ Exception -> 0x02d8 }
            if (r4 == 0) goto L_0x0228
            java.lang.String r5 = r4.getQrCodeId()     // Catch:{ Exception -> 0x02d8 }
        L_0x0228:
            r10.put(r3, r5)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r3 = "meta_data"
            r9.put(r3, r10)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r3 = "configuration"
            r9.put(r3, r7)     // Catch:{ Exception -> 0x02d8 }
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r17.getFlowName()     // Catch:{ Exception -> 0x02d8 }
            if (r3 == 0) goto L_0x0242
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x02d8 }
            r3.setRequestBody(r4)     // Catch:{ Exception -> 0x02d8 }
        L_0x0242:
            r2.put(r9)     // Catch:{ Exception -> 0x02d8 }
            java.lang.String r3 = "cart_items"
            r0.put(r3, r2)     // Catch:{ Exception -> 0x02d8 }
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r2.put(r3, r4)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r8.f63124a
            android.content.Context r3 = (android.content.Context) r3
            java.util.HashMap r2 = com.paytm.utility.b.a((java.util.HashMap<java.lang.String, java.lang.String>) r2, (android.content.Context) r3)
            java.lang.String r3 = "CJRAppCommonUtility.addS…r(headers, mBaseActivity)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            java.lang.String r3 = net.one97.paytm.recharge.common.utils.az.a((org.json.JSONObject) r0)
            net.one97.paytm.recharge.common.utils.y r4 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.common.utils.y.a((org.json.JSONObject) r0)
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r3 = net.one97.paytm.recharge.di.helper.c.c(r3)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r4 = r8.f63124a
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r11 = com.paytm.utility.b.s(r4, r3)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r8.f63124a
            android.content.Context r3 = (android.content.Context) r3
            boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)
            if (r3 == 0) goto L_0x02ad
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.c r3 = new net.one97.paytm.recharge.common.f.c
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r4 = r8.f63124a
            r12 = r4
            net.one97.paytm.recharge.common.e.ai r12 = (net.one97.paytm.recharge.common.e.ai) r12
            net.one97.paytm.common.entity.CJRRechargeCart r4 = new net.one97.paytm.common.entity.CJRRechargeCart
            r4.<init>()
            r13 = r4
            com.paytm.network.model.IJRPaytmDataModel r13 = (com.paytm.network.model.IJRPaytmDataModel) r13
            r14 = 0
            r15 = r2
            java.util.Map r15 = (java.util.Map) r15
            java.lang.String r16 = r0.toString()
            java.lang.String r10 = "metro_verify"
            r9 = r3
            r9.<init>((java.lang.String) r10, (java.lang.String) r11, (net.one97.paytm.recharge.common.e.ai) r12, (com.paytm.network.model.IJRPaytmDataModel) r13, (java.util.Map<java.lang.String, java.lang.String>) r14, (java.util.Map<java.lang.String, java.lang.String>) r15, (java.lang.String) r16, (java.lang.Object) r17)
            net.one97.paytm.recharge.common.f.a r3 = (net.one97.paytm.recharge.common.f.a) r3
            net.one97.paytm.recharge.common.f.d.b(r3)
            goto L_0x036e
        L_0x02ad:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r8.f63124a
            r3.o()
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r8.f63124a
            net.one97.paytm.recharge.common.f.c r4 = new net.one97.paytm.recharge.common.f.c
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r5 = r8.f63124a
            r12 = r5
            net.one97.paytm.recharge.common.e.ai r12 = (net.one97.paytm.recharge.common.e.ai) r12
            net.one97.paytm.common.entity.CJRRechargeCart r5 = new net.one97.paytm.common.entity.CJRRechargeCart
            r5.<init>()
            r13 = r5
            com.paytm.network.model.IJRPaytmDataModel r13 = (com.paytm.network.model.IJRPaytmDataModel) r13
            r14 = 0
            r15 = r2
            java.util.Map r15 = (java.util.Map) r15
            java.lang.String r16 = r0.toString()
            java.lang.String r10 = "metro_verify"
            r9 = r4
            r9.<init>((java.lang.String) r10, (java.lang.String) r11, (net.one97.paytm.recharge.common.e.ai) r12, (com.paytm.network.model.IJRPaytmDataModel) r13, (java.util.Map<java.lang.String, java.lang.String>) r14, (java.util.Map<java.lang.String, java.lang.String>) r15, (java.lang.String) r16, (java.lang.Object) r17)
            net.one97.paytm.recharge.common.f.a r4 = (net.one97.paytm.recharge.common.f.a) r4
            r3.a((net.one97.paytm.recharge.common.f.a) r4)
            goto L_0x036e
        L_0x02d8:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r8.f63124a
            r0.o()
            androidx.appcompat.app.c$a r0 = new androidx.appcompat.app.c$a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            android.content.Context r2 = (android.content.Context) r2
            r0.<init>(r2)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            int r3 = net.one97.paytm.recharge.R.string.network_error_heading_re
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            androidx.appcompat.app.c$a r2 = r0.a((java.lang.CharSequence) r2)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r8.f63124a
            int r4 = net.one97.paytm.recharge.R.string.network_error_message_re
            java.lang.String r3 = r3.getString(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.b((java.lang.CharSequence) r3)
            r0.a((boolean) r6)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            int r3 = net.one97.paytm.recharge.R.string.ok_re
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            net.one97.paytm.recharge.metro.a$c r3 = net.one97.paytm.recharge.metro.a.c.f63147a
            android.content.DialogInterface$OnClickListener r3 = (android.content.DialogInterface.OnClickListener) r3
            r0.a((java.lang.CharSequence) r2, (android.content.DialogInterface.OnClickListener) r3)
            r0.b()
            goto L_0x036e
        L_0x0321:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r8.f63124a
            r0.o()
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            android.app.Activity r2 = (android.app.Activity) r2
            r0.signOut(r2, r6, r5)
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.recharge.di.helper.a r3 = net.one97.paytm.recharge.di.helper.a.f62650a
            java.lang.Class r3 = net.one97.paytm.recharge.di.helper.a.b()
            r0.<init>(r2, r3)
            java.lang.Class<net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity> r2 = net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity.class
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "parent_activity"
            r0.putExtra(r3, r2)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            int r3 = net.one97.paytm.recharge.R.string.sign_in_recharge
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "sign_in_title"
            r0.putExtra(r3, r2)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            int r3 = net.one97.paytm.recharge.R.string.sign_up_recharge
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "sign_up_title"
            r0.putExtra(r3, r2)
            java.lang.String r2 = "set_result_required"
            r0.putExtra(r2, r7)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r8.f63124a
            r3 = 3
            r2.startActivityForResult(r0, r3)
        L_0x036e:
            java.lang.String r0 = r1.f63409e     // Catch:{ all -> 0x03a9 }
            if (r0 == 0) goto L_0x03a9
            java.lang.String r0 = "MUMBAI_METRO_QR"
            java.lang.String r2 = r1.f63409e     // Catch:{ all -> 0x03a9 }
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r6)     // Catch:{ all -> 0x03a9 }
            java.lang.String r2 = "penalty_proceed_clicked"
            if (r0 == 0) goto L_0x0386
            java.lang.String r0 = "/mumbai-metro/qr"
            java.lang.String r3 = "mumbai_metro_qr"
            r1.a(r0, r3, r2)     // Catch:{ all -> 0x03a9 }
            return
        L_0x0386:
            java.lang.String r0 = "MUMBAI_METRO_TP"
            java.lang.String r3 = r1.f63409e     // Catch:{ all -> 0x03a9 }
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r6)     // Catch:{ all -> 0x03a9 }
            if (r0 == 0) goto L_0x0398
            java.lang.String r0 = "/mumbai-metro/tp"
            java.lang.String r3 = "mumbai_metro_tp"
            r1.a(r0, r3, r2)     // Catch:{ all -> 0x03a9 }
            return
        L_0x0398:
            java.lang.String r0 = "MUMBAI_METRO_SVP"
            java.lang.String r3 = r1.f63409e     // Catch:{ all -> 0x03a9 }
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r6)     // Catch:{ all -> 0x03a9 }
            if (r0 == 0) goto L_0x03a9
            java.lang.String r0 = "/mumbai-metro/svp"
            java.lang.String r3 = "mumbai_metro_svp"
            r1.a(r0, r3, r2)     // Catch:{ all -> 0x03a9 }
        L_0x03a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.n.onClick(android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r6, com.paytm.network.model.IJRPaytmDataModel r7, java.lang.Object r8) {
        /*
            r5 = this;
            java.lang.String r8 = "DTM_201"
            java.lang.String r0 = "DTM_200"
            java.lang.String r1 = "tag"
            kotlin.g.b.k.c(r6, r1)
            android.widget.RelativeLayout r6 = r5.f63412h
            if (r6 == 0) goto L_0x0012
            r1 = 8
            r6.setVisibility(r1)
        L_0x0012:
            boolean r6 = r7 instanceof net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel
            if (r6 == 0) goto L_0x0111
            java.lang.String r6 = r7.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0111
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel r7 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel) r7
            android.widget.TextView r6 = r5.f63413i
            r1 = 0
            if (r6 == 0) goto L_0x002e
            java.lang.CharSequence r6 = r6.getText()
            goto L_0x002f
        L_0x002e:
            r6 = r1
        L_0x002f:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            android.widget.TextView r2 = r5.f63413i     // Catch:{ Exception -> 0x008b }
            if (r2 == 0) goto L_0x003c
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ Exception -> 0x008b }
            goto L_0x003d
        L_0x003c:
            r2 = r1
        L_0x003d:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x008b }
            int r3 = net.one97.paytm.recharge.R.string.know_more     // Catch:{ Exception -> 0x008b }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x008b }
            r4 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)     // Catch:{ Exception -> 0x008b }
            java.lang.String r3 = "response.penaltyMap"
            if (r2 == 0) goto L_0x008d
            java.util.HashMap r0 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            if (r0 == 0) goto L_0x008b
            java.util.HashMap r0 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x008b }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x008b }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x008b }
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x008b
            java.util.HashMap r0 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            boolean r0 = r0.containsKey(r8)     // Catch:{ Exception -> 0x008b }
            if (r0 == 0) goto L_0x008b
            java.util.HashMap r7 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x008b }
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel$Penalty r7 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel.Penalty) r7     // Catch:{ Exception -> 0x008b }
            if (r7 == 0) goto L_0x0081
            java.util.ArrayList r8 = r7.getMessage()     // Catch:{ Exception -> 0x008b }
            goto L_0x0082
        L_0x0081:
            r8 = r1
        L_0x0082:
            if (r7 == 0) goto L_0x0089
            java.lang.String r6 = r7.getTitle()     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00c7
        L_0x0089:
            r6 = r1
            goto L_0x00c7
        L_0x008b:
            r8 = r1
            goto L_0x00c7
        L_0x008d:
            java.util.HashMap r8 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            if (r8 == 0) goto L_0x008b
            java.util.HashMap r8 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)     // Catch:{ Exception -> 0x008b }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x008b }
            boolean r8 = r8.isEmpty()     // Catch:{ Exception -> 0x008b }
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x008b
            java.util.HashMap r8 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            boolean r8 = r8.containsKey(r0)     // Catch:{ Exception -> 0x008b }
            if (r8 == 0) goto L_0x008b
            java.util.HashMap r7 = r7.getPenaltyMap()     // Catch:{ Exception -> 0x008b }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Exception -> 0x008b }
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel$Penalty r7 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel.Penalty) r7     // Catch:{ Exception -> 0x008b }
            if (r7 == 0) goto L_0x00be
            java.util.ArrayList r8 = r7.getMessage()     // Catch:{ Exception -> 0x008b }
            goto L_0x00bf
        L_0x00be:
            r8 = r1
        L_0x00bf:
            if (r7 == 0) goto L_0x0089
            java.lang.String r6 = r7.getTitle()     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00c7
        L_0x00c6:
        L_0x00c7:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r0 = "messageList"
            r7.putStringArrayList(r0, r8)
            java.lang.String r8 = "title"
            r7.putString(r8, r6)
            android.content.Context r6 = r5.getContext()
            if (r6 == 0) goto L_0x00fd
            android.content.Context r6 = r5.getContext()
            if (r6 != 0) goto L_0x00e5
            kotlin.g.b.k.a()
        L_0x00e5:
            java.lang.Class<net.one97.paytm.recharge.metro.c.l> r8 = net.one97.paytm.recharge.metro.c.l.class
            java.lang.String r8 = r8.getName()
            androidx.fragment.app.Fragment r6 = androidx.fragment.app.Fragment.instantiate(r6, r8)
            if (r6 == 0) goto L_0x00f5
            r1 = r6
            net.one97.paytm.recharge.metro.c.l r1 = (net.one97.paytm.recharge.metro.c.l) r1
            goto L_0x00fd
        L_0x00f5:
            kotlin.u r6 = new kotlin.u
            java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRMetroShowPenaltyDialogFragment"
            r6.<init>(r7)
            throw r6
        L_0x00fd:
            if (r1 == 0) goto L_0x0102
            r1.setArguments(r7)
        L_0x0102:
            if (r1 == 0) goto L_0x0111
            androidx.fragment.app.j r6 = r5.getChildFragmentManager()
            java.lang.Class<net.one97.paytm.recharge.metro.c.l> r7 = net.one97.paytm.recharge.metro.c.l.class
            java.lang.String r7 = r7.getName()
            r1.show((androidx.fragment.app.j) r6, (java.lang.String) r7)
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.n.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        RelativeLayout relativeLayout = this.f63412h;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    private final void a(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", str2);
            hashMap.put("event_action", str3);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
            hashMap.put("vertical_name", "recharges_utilities");
            Map map = hashMap;
            TextView textView = this.j;
            if (textView == null) {
                k.a("txtTitlePenalty");
            }
            map.put("event_label", textView.getText());
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
        } catch (Throwable unused) {
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
