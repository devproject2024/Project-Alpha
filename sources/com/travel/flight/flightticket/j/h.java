package com.travel.flight.flightticket.j;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.FareRules.CJRMessageKeyValueBaggage;
import com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage;
import com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification;
import java.util.ArrayList;

public final class h extends RecyclerView.v implements r {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f25153a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f25154b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f25155c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f25156d;

    /* renamed from: e  reason: collision with root package name */
    private CJRPolicyDetailsCancellationNModification f25157e;

    /* renamed from: f  reason: collision with root package name */
    private CJRPolicyDetailsBaggage f25158f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25159g = false;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f25160h;

    public h(View view) {
        super(view);
        this.f25153a = (ImageView) view.findViewById(R.id.policy_icon_view);
        this.f25154b = (RoboTextView) view.findViewById(R.id.policy_member_header);
        this.f25155c = (LinearLayout) view.findViewById(R.id.sub_policy_container);
        this.f25160h = (LinearLayout) view.findViewById(R.id.policy_notes_container);
        this.f25156d = (LinearLayout) view.findViewById(R.id.policy_gender_container);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r5, net.one97.paytm.common.entity.IJRDataModel r6, java.lang.String r7, boolean r8, java.util.List<com.travel.flight.pojo.flightticket.CJRFlightStops> r9) {
        /*
            r4 = this;
            if (r6 == 0) goto L_0x01a5
            boolean r7 = r6 instanceof com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem
            if (r7 == 0) goto L_0x01a5
            com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem r6 = (com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem) r6
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r7 = r6.getPolicyDetailsBaggage()
            if (r7 != 0) goto L_0x0014
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r7 = r6.getPolicyDetailCancellationModification()
            if (r7 == 0) goto L_0x01a5
        L_0x0014:
            java.lang.String r7 = r6.getScreenName()
            r8 = -1
            r9 = 0
            if (r7 == 0) goto L_0x0076
            java.lang.String r7 = r6.getScreenName()
            int r0 = r7.hashCode()
            r1 = -956572381(0xffffffffc6fbdd23, float:-32238.568)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x004a
            r1 = -520280644(0xffffffffe0fd25bc, float:-1.4592954E20)
            if (r0 == r1) goto L_0x0040
            r1 = 1321016096(0x4ebd1b20, float:1.58633574E9)
            if (r0 == r1) goto L_0x0036
            goto L_0x0054
        L_0x0036:
            java.lang.String r0 = "Baggage"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0054
            r7 = 1
            goto L_0x0055
        L_0x0040:
            java.lang.String r0 = "Modification"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0054
            r7 = 2
            goto L_0x0055
        L_0x004a:
            java.lang.String r0 = "Cancellation"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0054
            r7 = 0
            goto L_0x0055
        L_0x0054:
            r7 = -1
        L_0x0055:
            if (r7 == 0) goto L_0x006e
            if (r7 == r3) goto L_0x0065
            if (r7 == r2) goto L_0x005c
            goto L_0x0076
        L_0x005c:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r6.getPolicyDetailCancellationModification()
            r4.f25157e = r6
            r4.f25159g = r9
            goto L_0x0076
        L_0x0065:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r6.getPolicyDetailsBaggage()
            r4.f25158f = r6
            r4.f25159g = r3
            goto L_0x0076
        L_0x006e:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r6.getPolicyDetailCancellationModification()
            r4.f25157e = r6
            r4.f25159g = r9
        L_0x0076:
            boolean r6 = r4.f25159g
            java.lang.String r7 = ""
            r0 = -2
            r1 = 0
            if (r6 == 0) goto L_0x0113
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.lang.String r6 = r6.getBaggageType()
            if (r6 == 0) goto L_0x009f
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.lang.String r6 = r6.getBaggageType()
            java.lang.String r6 = r6.trim()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x009f
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.lang.String r6 = r6.getBaggageType()
            r4.b(r6)
        L_0x009f:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.lang.String r6 = r6.getTitle()
            if (r6 == 0) goto L_0x00b0
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.lang.String r6 = r6.getTitle()
            r4.a(r6)
        L_0x00b0:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.util.ArrayList r6 = r6.getMessages()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x00f5
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.util.ArrayList r6 = r6.getMessages()
            if (r6 == 0) goto L_0x00f5
            int r2 = r6.size()
            if (r2 <= 0) goto L_0x00f5
            java.lang.Object r6 = r6.get(r9)
            com.travel.flight.pojo.flightticket.FareRules.CJRMessageKeyValueBaggage r6 = (com.travel.flight.pojo.flightticket.FareRules.CJRMessageKeyValueBaggage) r6
            if (r6 == 0) goto L_0x00f5
            android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r5)
            int r2 = com.travel.flight.R.layout.pre_f_layout_flight_fare_rules_route_policy_item
            android.view.View r9 = r9.inflate(r2, r1)
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r1.<init>(r8, r0)
            r9.setLayoutParams(r1)
            com.travel.flight.flightticket.j.i r8 = new com.travel.flight.flightticket.j.i
            r8.<init>(r9)
            java.lang.String r6 = r6.getValue()
            r8.a(r7, r6)
            android.widget.LinearLayout r6 = r4.f25155c
            r6.addView(r9)
        L_0x00f5:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.util.ArrayList r6 = r6.getNotes()
            if (r6 == 0) goto L_0x01a5
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.util.ArrayList r6 = r6.getNotes()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x01a5
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsBaggage r6 = r4.f25158f
            java.util.ArrayList r6 = r6.getNotes()
            r4.a(r6, r5)
            return
        L_0x0113:
            android.widget.ImageView r6 = r4.f25153a
            r2 = 8
            r6.setVisibility(r2)
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r4.f25157e
            java.lang.String r6 = r6.getBaggageType()
            if (r6 == 0) goto L_0x013b
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r4.f25157e
            java.lang.String r6 = r6.getBaggageType()
            java.lang.String r6 = r6.trim()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x013b
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r4.f25157e
            java.lang.String r6 = r6.getBaggageType()
            r4.b(r6)
        L_0x013b:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r4.f25157e
            if (r6 == 0) goto L_0x0146
            java.lang.String r6 = r6.getTitle()
            r4.a(r6)
        L_0x0146:
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r4.f25157e
            java.util.ArrayList r6 = r6.getMessages()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x01a5
            com.travel.flight.pojo.flightticket.FareRules.CJRPolicyDetailsCancellationNModification r6 = r4.f25157e
            java.util.ArrayList r6 = r6.getMessages()
            if (r6 == 0) goto L_0x01a5
            int r2 = r6.size()
            if (r2 <= 0) goto L_0x01a5
            java.lang.Object r6 = r6.get(r9)
            com.travel.flight.pojo.flightticket.FareRules.CJRMessageKeyValue r6 = (com.travel.flight.pojo.flightticket.FareRules.CJRMessageKeyValue) r6
            if (r6 == 0) goto L_0x01a5
            java.util.ArrayList r2 = r6.getValue()
            if (r2 == 0) goto L_0x01a5
            java.util.ArrayList r2 = r6.getValue()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x01a5
            java.util.ArrayList r6 = r6.getValue()
            java.lang.Object r6 = r6.get(r9)
            com.travel.flight.pojo.flightticket.FareRules.CJRValueKeyValue r6 = (com.travel.flight.pojo.flightticket.FareRules.CJRValueKeyValue) r6
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            int r9 = com.travel.flight.R.layout.pre_f_layout_flight_fare_rules_route_policy_item
            android.view.View r5 = r5.inflate(r9, r1)
            android.widget.LinearLayout$LayoutParams r9 = new android.widget.LinearLayout$LayoutParams
            r9.<init>(r8, r0)
            r5.setLayoutParams(r9)
            com.travel.flight.flightticket.j.i r8 = new com.travel.flight.flightticket.j.i
            r8.<init>(r5)
            java.lang.String r6 = r6.getValue()
            r8.a(r7, r6)
            android.widget.LinearLayout r6 = r4.f25155c
            r6.addView(r5)
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.j.h.a(android.content.Context, net.one97.paytm.common.entity.IJRDataModel, java.lang.String, boolean, java.util.List):void");
    }

    private void a(ArrayList<CJRMessageKeyValueBaggage> arrayList, Context context) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f25160h.setVisibility(0);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                CJRMessageKeyValueBaggage cJRMessageKeyValueBaggage = arrayList.get(i2);
                if (cJRMessageKeyValueBaggage != null) {
                    View inflate = LayoutInflater.from(context).inflate(R.layout.pre_f_flight_policy_notes_item, (ViewGroup) null);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.policy_message_lyt);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    CJRPolicyDetailsBaggage cJRPolicyDetailsBaggage = this.f25158f;
                    if (cJRPolicyDetailsBaggage == null || !cJRPolicyDetailsBaggage.getBaggageType().equalsIgnoreCase("checkin")) {
                        CJRPolicyDetailsBaggage cJRPolicyDetailsBaggage2 = this.f25158f;
                        if (cJRPolicyDetailsBaggage2 != null && cJRPolicyDetailsBaggage2.getBaggageType().equalsIgnoreCase("cabin")) {
                            if (arrayList.size() == 1) {
                                layoutParams.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.dimen_32dp));
                            } else if (arrayList.size() > 1) {
                                layoutParams.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.dimen_8dp));
                            }
                        }
                    } else if (arrayList.size() == 1) {
                        layoutParams.setMargins(0, 0, 0, 0);
                    } else if (arrayList.size() > 1) {
                        layoutParams.setMargins(0, 0, 0, (int) context.getResources().getDimension(R.dimen.dimen_8dp));
                    }
                    linearLayout.setLayoutParams(layoutParams);
                    n nVar = new n(inflate);
                    String key = cJRMessageKeyValueBaggage.getKey();
                    String value = cJRMessageKeyValueBaggage.getValue();
                    nVar.f25184a.setText(key);
                    nVar.f25185b.setText(Html.fromHtml(value));
                    this.f25160h.addView(inflate);
                }
            }
        }
    }

    private void a(String str) {
        this.f25154b.setText(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r5) {
        /*
            r4 = this;
            android.widget.ImageView r0 = r4.f25153a
            r1 = 8
            r0.setVisibility(r1)
            int r0 = r5.hashCode()
            r1 = 94415849(0x5a0abe9, float:1.5109478E-35)
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0022
            r1 = 742314029(0x2c3ed02d, float:2.7116185E-12)
            if (r0 == r1) goto L_0x0018
            goto L_0x002c
        L_0x0018:
            java.lang.String r0 = "checkin"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x002c
            r5 = 1
            goto L_0x002d
        L_0x0022:
            java.lang.String r0 = "cabin"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x002c
            r5 = 0
            goto L_0x002d
        L_0x002c:
            r5 = -1
        L_0x002d:
            if (r5 == 0) goto L_0x0041
            if (r5 == r2) goto L_0x0032
            goto L_0x0040
        L_0x0032:
            android.widget.ImageView r5 = r4.f25153a
            r5.setVisibility(r3)
            android.widget.ImageView r5 = r4.f25153a
            com.travel.utils.n$a r0 = com.travel.utils.n.a.V1
            java.lang.String r1 = "fare_policy_baggage.png"
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r5, r1, r3, r3, r0)
        L_0x0040:
            return
        L_0x0041:
            android.widget.ImageView r5 = r4.f25153a
            r5.setVisibility(r3)
            android.widget.ImageView r5 = r4.f25153a
            com.travel.utils.n$a r0 = com.travel.utils.n.a.V1
            java.lang.String r1 = "fare_policy_cabin_baggage.png"
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r5, r1, r3, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.j.h.b(java.lang.String):void");
    }
}
