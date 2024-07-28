package com.travel.train.f;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainAddOn;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainConfirmation;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainOffers;
import com.travel.train.model.trainticket.CJRTrainPromoVerify;
import com.travel.train.model.trainticket.CJRTrainValue;
import com.travel.train.model.travellerProfile.model.CJRTpUserProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public com.travel.train.i.e f26672a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26673b;

    /* renamed from: c  reason: collision with root package name */
    private String f26674c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainDetailsBody f26675d;

    /* renamed from: e  reason: collision with root package name */
    private String f26676e = "CJRTrainReviewItineraryPresenter";

    public e(com.travel.train.i.e eVar, CJRTrainDetailsBody cJRTrainDetailsBody, String str) {
        this.f26672a = eVar;
        this.f26674c = str;
        this.f26675d = cJRTrainDetailsBody;
    }

    public final void a() {
        if (com.paytm.utility.b.c((Context) this.f26672a.u())) {
            com.travel.train.i.e eVar = this.f26672a;
            eVar.showProgressDialog(eVar.u(), this.f26672a.u().getResources().getString(R.string.train_review_fetching_data));
            com.travel.train.b.a();
            com.travel.train.b.a(this.f26672a.u(), (b) this);
            return;
        }
        com.paytm.utility.b.c((Context) this.f26672a.u(), this.f26672a.u().getResources().getString(R.string.no_connection), this.f26672a.u().getResources().getString(R.string.no_internet_train));
    }

    public final void b() {
        StringBuilder sb = new StringBuilder();
        com.travel.train.b.a();
        sb.append(com.travel.train.b.b().u());
        sb.append("trains");
        String sb2 = sb.toString();
        if (URLUtil.isValidUrl(sb2)) {
            String s = com.paytm.utility.b.s(this.f26672a.u(), sb2);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f26672a.u();
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.j;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = s;
            bVar.f42882f = n.b((Context) this.f26672a.u());
            bVar.f42885i = new CJRTrainOffers();
            bVar.j = this;
            a l = bVar.l();
            l.f42859c = false;
            l.a();
        }
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put(PayUtility.PROMO_CODE, str);
            } catch (JSONException e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
        return jSONObject;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRTrainBooking) {
            this.f26672a.a((CJRTrainBooking) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            this.f26672a.removeProgressDialog();
            this.f26672a.a((CJRPGTokenList) iJRPaytmDataModel);
        } else if ((iJRPaytmDataModel instanceof CJRTrainOffers) && iJRPaytmDataModel != null) {
            this.f26672a.a((CJRTrainOffers) iJRPaytmDataModel);
        } else if ((iJRPaytmDataModel instanceof CJRTrainPromoVerify) && iJRPaytmDataModel != null) {
            this.f26672a.a((CJRTrainPromoVerify) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRTpUserProfile) {
            this.f26672a.a((CJRTpUserProfile) iJRPaytmDataModel);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ed A[Catch:{ Exception -> 0x01fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleErrorCode(int r7, com.paytm.network.model.IJRPaytmDataModel r8, com.paytm.network.model.NetworkCustomError r9) {
        /*
            r6 = this;
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r0 = r0.u()     // Catch:{ Exception -> 0x01fa }
            boolean r0 = r0.isFinishing()     // Catch:{ Exception -> 0x01fa }
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            r0.removeProgressDialog()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            r0.q()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = r9.getFullUrl()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.b.a()     // Catch:{ Exception -> 0x01fa }
            com.travel.common.a r1 = com.travel.train.b.b()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r1 = r1.k()     // Catch:{ Exception -> 0x01fa }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x01fa }
            if (r0 == 0) goto L_0x002d
            return
        L_0x002d:
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            r0.a()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.a r0 = new com.travel.train.model.a     // Catch:{ Exception -> 0x01fa }
            r0.<init>()     // Catch:{ Exception -> 0x01fa }
            com.paytm.network.model.NetworkResponse r1 = r9.networkResponse     // Catch:{ Exception -> 0x01fa }
            if (r1 == 0) goto L_0x005d
            com.paytm.network.model.NetworkResponse r1 = r9.networkResponse     // Catch:{ Exception -> 0x01fa }
            byte[] r2 = r1.data     // Catch:{ Exception -> 0x01fa }
            if (r2 == 0) goto L_0x005d
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0059 }
            byte[] r1 = r1.data     // Catch:{ Exception -> 0x0059 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0059 }
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0059 }
            r1.<init>()     // Catch:{ Exception -> 0x0059 }
            java.lang.Class r3 = r0.getClass()     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r1 = r1.a((java.lang.String) r2, r3)     // Catch:{ Exception -> 0x0059 }
            com.travel.train.model.a r1 = (com.travel.train.model.a) r1     // Catch:{ Exception -> 0x0059 }
            r0 = r1
            goto L_0x005d
        L_0x0059:
            r1 = move-exception
            r1.getMessage()     // Catch:{ Exception -> 0x01fa }
        L_0x005d:
            if (r0 == 0) goto L_0x006a
            java.lang.String r1 = r0.getError()     // Catch:{ Exception -> 0x01fa }
            if (r1 == 0) goto L_0x006a
            java.lang.String r1 = r0.getError()     // Catch:{ Exception -> 0x01fa }
            goto L_0x006e
        L_0x006a:
            java.lang.String r1 = r9.getMessage()     // Catch:{ Exception -> 0x01fa }
        L_0x006e:
            java.lang.String r2 = "train_traveller_details"
            java.lang.String r3 = "errors"
            java.lang.String r4 = "/trains/traveller-details"
            com.travel.train.i.e r5 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r5 = r5.u()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.j.o.a(r2, r1, r3, r4, r5)     // Catch:{ Exception -> 0x01fa }
            r1 = 401(0x191, float:5.62E-43)
            if (r7 == r1) goto L_0x01e4
            r1 = 410(0x19a, float:5.75E-43)
            if (r7 != r1) goto L_0x0088
            goto L_0x01e4
        L_0x0088:
            r1 = 449(0x1c1, float:6.29E-43)
            if (r7 == r1) goto L_0x01d2
            r1 = 499(0x1f3, float:6.99E-43)
            if (r7 == r1) goto L_0x01d2
            r1 = 502(0x1f6, float:7.03E-43)
            if (r7 == r1) goto L_0x01d2
            r1 = 503(0x1f7, float:7.05E-43)
            if (r7 == r1) goto L_0x01d2
            r1 = 504(0x1f8, float:7.06E-43)
            if (r7 != r1) goto L_0x009e
            goto L_0x01d2
        L_0x009e:
            if (r0 == 0) goto L_0x00eb
            com.travel.train.model.b r7 = r0.getStatus()     // Catch:{ Exception -> 0x01fa }
            if (r7 == 0) goto L_0x00eb
            com.travel.train.model.b r7 = r0.getStatus()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.c r7 = r7.getMessage()     // Catch:{ Exception -> 0x01fa }
            if (r7 == 0) goto L_0x00eb
            com.travel.train.model.b r7 = r0.getStatus()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.c r7 = r7.getMessage()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r7 = r7.f27692a     // Catch:{ Exception -> 0x01fa }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01fa }
            if (r7 != 0) goto L_0x00eb
            com.travel.train.model.b r7 = r0.getStatus()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.c r7 = r7.getMessage()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r7 = r7.f27693b     // Catch:{ Exception -> 0x01fa }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01fa }
            if (r7 != 0) goto L_0x00eb
            com.travel.train.i.e r7 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.b r1 = r0.getStatus()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.c r1 = r1.getMessage()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r1 = r1.f27693b     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.b r0 = r0.getStatus()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.model.c r0 = r0.getMessage()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = r0.f27692a     // Catch:{ Exception -> 0x01fa }
            r7.showErrorDialog(r1, r0)     // Catch:{ Exception -> 0x01fa }
            goto L_0x01e9
        L_0x00eb:
            java.lang.String r7 = r9.getMessage()     // Catch:{ Exception -> 0x01fa }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01fa }
            if (r7 != 0) goto L_0x0114
            java.lang.String r7 = r9.getAlertTitle()     // Catch:{ Exception -> 0x01fa }
            if (r7 == 0) goto L_0x0114
            java.lang.String r7 = r9.getAlertMessage()     // Catch:{ Exception -> 0x01fa }
            if (r7 == 0) goto L_0x0114
            java.lang.String r7 = r9.getAlertTitle()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = r9.getAlertMessage()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r1 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r1 = r1.u()     // Catch:{ Exception -> 0x01fa }
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r7, (java.lang.String) r0)     // Catch:{ Exception -> 0x01fa }
            goto L_0x01e9
        L_0x0114:
            java.lang.String r7 = r9.getMessage()     // Catch:{ Exception -> 0x01fa }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01fa }
            if (r7 != 0) goto L_0x01a8
            com.travel.train.b.a()     // Catch:{ Exception -> 0x01fa }
            com.travel.common.a r7 = com.travel.train.b.b()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r0 = r0.u()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r1 = "error.trains@paytm.com"
            boolean r7 = r7.a((android.content.Context) r0, (java.lang.Exception) r9, (java.lang.String) r1)     // Catch:{ Exception -> 0x01fa }
            if (r7 != 0) goto L_0x01a8
            com.paytm.network.model.NetworkCustomError$ErrorType r7 = r9.getErrorType()     // Catch:{ Exception -> 0x01fa }
            com.paytm.network.model.NetworkCustomError$ErrorType r0 = com.paytm.network.model.NetworkCustomError.ErrorType.ParsingError     // Catch:{ Exception -> 0x01fa }
            if (r7 != r0) goto L_0x0166
            com.travel.train.i.e r7 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r7 = r7.u()     // Catch:{ Exception -> 0x01fa }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x01fa }
            int r0 = com.travel.train.R.string.trains_message_error_data_display     // Catch:{ Exception -> 0x01fa }
            java.lang.String r7 = r7.getString(r0)     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r0 = r0.u()     // Catch:{ Exception -> 0x01fa }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x01fa }
            int r1 = com.travel.train.R.string.error_data_display     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r1 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r1 = r1.u()     // Catch:{ Exception -> 0x01fa }
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x01fa }
            goto L_0x01e9
        L_0x0166:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fa }
            r7.<init>()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r0 = r0.u()     // Catch:{ Exception -> 0x01fa }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x01fa }
            int r1 = com.travel.train.R.string.network_error_message_train     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x01fa }
            r7.append(r0)     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = " "
            r7.append(r0)     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = r9.getUrl()     // Catch:{ Exception -> 0x01fa }
            r7.append(r0)     // Catch:{ Exception -> 0x01fa }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r0 = r0.u()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r1 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r1 = r1.u()     // Catch:{ Exception -> 0x01fa }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01fa }
            int r2 = com.travel.train.R.string.network_error_heading     // Catch:{ Exception -> 0x01fa }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x01fa }
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x01fa }
            goto L_0x01e9
        L_0x01a8:
            com.travel.train.i.e r7 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r7 = r7.u()     // Catch:{ Exception -> 0x01fa }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x01fa }
            int r0 = com.travel.train.R.string.network_error_message_train     // Catch:{ Exception -> 0x01fa }
            java.lang.String r7 = r7.getString(r0)     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r0 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r0 = r0.u()     // Catch:{ Exception -> 0x01fa }
            com.travel.train.i.e r1 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r1 = r1.u()     // Catch:{ Exception -> 0x01fa }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01fa }
            int r2 = com.travel.train.R.string.network_error_heading     // Catch:{ Exception -> 0x01fa }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x01fa }
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x01fa }
            goto L_0x01e9
        L_0x01d2:
            com.travel.train.i.e r7 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            android.app.Activity r7 = r7.u()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r0 = r9.getMessage()     // Catch:{ Exception -> 0x01fa }
            java.lang.String r1 = r9.getMessage()     // Catch:{ Exception -> 0x01fa }
            com.paytm.utility.b.b((android.content.Context) r7, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01fa }
            goto L_0x01e9
        L_0x01e4:
            com.travel.train.i.e r7 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            r7.showSessionTimeoutAlert(r9)     // Catch:{ Exception -> 0x01fa }
        L_0x01e9:
            boolean r7 = r8 instanceof com.travel.train.model.trainticket.CJRTrainPromoVerify     // Catch:{ Exception -> 0x01fa }
            if (r7 == 0) goto L_0x01f9
            boolean r7 = r6.f26673b     // Catch:{ Exception -> 0x01fa }
            if (r7 == 0) goto L_0x01f4
            r7 = 0
            r6.f26673b = r7     // Catch:{ Exception -> 0x01fa }
        L_0x01f4:
            com.travel.train.i.e r7 = r6.f26672a     // Catch:{ Exception -> 0x01fa }
            r7.a((com.paytm.network.model.IJRPaytmDataModel) r8, (com.paytm.network.model.NetworkCustomError) r9)     // Catch:{ Exception -> 0x01fa }
        L_0x01f9:
            return
        L_0x01fa:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.q.c(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.f.e.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }

    public final boolean c() {
        if (this.f26672a.d() == null || this.f26672a.d().getmConfirmation() == null || this.f26672a.d().getmConfirmation().getOptOutPGCharges() == null) {
            return false;
        }
        if (Boolean.TRUE.equals(this.f26672a.d().getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered())) {
            return this.f26672a.d().getmConfirmation().isGatewayChargeEnabled();
        }
        if (!this.f26672a.d().getmConfirmation().isGatewayChargeEnabled()) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (this.f26672a.d() == null || this.f26672a.d().getmConfirmation() == null || this.f26672a.d().getmConfirmation().getOptOutServiceCharges() == null) {
            return false;
        }
        if (Boolean.TRUE.equals(this.f26672a.d().getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered())) {
            return this.f26672a.d().getmConfirmation().isServiceChargeEnabled();
        }
        if (!this.f26672a.d().getmConfirmation().isServiceChargeEnabled()) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (this.f26672a.d() == null || this.f26672a.d().getmConfirmation() == null || this.f26672a.d().getmConfirmation().getCancellationInsurance() == null || !this.f26672a.d().getmConfirmation().getCancellationInsurance().getEnabled()) {
            return false;
        }
        return this.f26672a.f();
    }

    public final void a(ArrayList<CJRTrainFareDetail> arrayList, CJRTrainConfirmation cJRTrainConfirmation, int i2) {
        arrayList.clear();
        List<CJRTrainFareDetail> fareDetails = cJRTrainConfirmation.getFareDetails();
        if (fareDetails != null) {
            for (int i3 = 0; i3 < fareDetails.size(); i3++) {
                CJRTrainFareDetail cJRTrainFareDetail = fareDetails.get(i3);
                if (cJRTrainFareDetail != null) {
                    if (cJRTrainFareDetail.getValue() != null && cJRTrainFareDetail.getValue().size() > 0) {
                        for (CJRTrainValue next : cJRTrainFareDetail.getValue()) {
                            if (next.isAmount()) {
                                next.setServerAmount(next.getText());
                            }
                        }
                    }
                    if (!b(Integer.valueOf(cJRTrainFareDetail.getKey()), cJRTrainConfirmation)) {
                        arrayList.add(cJRTrainFareDetail);
                    } else if (a(Integer.valueOf(cJRTrainFareDetail.getKey()), cJRTrainConfirmation)) {
                        cJRTrainFareDetail.setVisibility(true);
                        arrayList.add(cJRTrainFareDetail);
                    } else {
                        cJRTrainFareDetail.setVisibility(false);
                        arrayList.add(cJRTrainFareDetail);
                    }
                }
                if (cJRTrainFareDetail.getKey() == i2) {
                    String a2 = o.a(cJRTrainFareDetail.getValue());
                    com.travel.train.i.e eVar = this.f26672a;
                    eVar.c(Double.valueOf(eVar.l().doubleValue() + Double.parseDouble(a2)));
                }
            }
        }
    }

    public final void a(ArrayList<CJRTrainFareDetail> arrayList, CJRTrainBooking cJRTrainBooking, double d2, double d3) {
        List<CJRTrainFareDetail> fareDetails;
        arrayList.clear();
        if (cJRTrainBooking != null && cJRTrainBooking.getmConfirmation() != null && cJRTrainBooking.getmConfirmation().getFareDetails() != null && cJRTrainBooking.getmConfirmation().getFareDetails().size() > 0 && (fareDetails = cJRTrainBooking.getmConfirmation().getFareDetails()) != null) {
            int i2 = 0;
            while (i2 < fareDetails.size()) {
                try {
                    CJRTrainFareDetail cJRTrainFareDetail = fareDetails.get(i2);
                    if (cJRTrainFareDetail != null) {
                        for (int i3 = 0; i3 < cJRTrainFareDetail.getValue().size(); i3++) {
                            CJRTrainValue cJRTrainValue = cJRTrainFareDetail.getValue().get(i3);
                            if (cJRTrainValue != null && !TextUtils.isEmpty(cJRTrainValue.getText()) && cJRTrainValue.isAmount()) {
                                cJRTrainValue.setServerAmount(cJRTrainValue.getText());
                                if (cJRTrainFareDetail.getKey() == cJRTrainBooking.getmConfirmation().getGrandTotalKey().intValue()) {
                                    cJRTrainValue.setText(o.a(this.f26672a.l()));
                                    if (cJRTrainBooking.getmConfirmation().getOptOutPGCharges() == null || cJRTrainBooking.getmConfirmation().getOptOutServiceCharges() == null || cJRTrainBooking.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered() == null || cJRTrainBooking.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered() == null) {
                                        if (!cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && !cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - d2) - d3))));
                                        } else if (cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && !cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d3))));
                                        } else if (!cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d2))));
                                        }
                                    } else if (!cJRTrainBooking.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() || !cJRTrainBooking.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                                        if (!cJRTrainBooking.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() || cJRTrainBooking.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                                            if (!cJRTrainBooking.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() && cJRTrainBooking.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                                                if (!cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                                    cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - d2) - d3))));
                                                } else if (cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                                    cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d3))));
                                                } else if (!cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                                    cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d2))));
                                                }
                                            }
                                        } else if (cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && !cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - d2) - d3))));
                                        } else if (!cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && !cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d3))));
                                        } else if (cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d2))));
                                        }
                                    } else if (cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                        cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - d2) - d3))));
                                    } else if (!cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                        cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d3))));
                                    } else if (cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled() && !cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                        cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - d2))));
                                    }
                                } else {
                                    if (cJRTrainBooking.getmConfirmation().getOptOutPGCharges() != null) {
                                        if (cJRTrainFareDetail.getKey() == cJRTrainBooking.getmConfirmation().getOptOutPGCharges().getToggleKey().intValue()) {
                                            if (Boolean.TRUE.equals(cJRTrainBooking.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered())) {
                                                if (cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled()) {
                                                    cJRTrainValue.setText("0");
                                                }
                                            } else if (!cJRTrainBooking.getmConfirmation().isGatewayChargeEnabled()) {
                                                cJRTrainValue.setText("0");
                                            }
                                        }
                                    }
                                    if (cJRTrainBooking.getmConfirmation().getOptOutServiceCharges() != null && cJRTrainFareDetail.getKey() == cJRTrainBooking.getmConfirmation().getOptOutServiceCharges().getToggleKey().intValue()) {
                                        if (Boolean.TRUE.equals(cJRTrainBooking.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered())) {
                                            if (cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                                cJRTrainValue.setText("0");
                                            }
                                        } else if (!cJRTrainBooking.getmConfirmation().isServiceChargeEnabled()) {
                                            cJRTrainValue.setText("0");
                                        }
                                    }
                                }
                            }
                        }
                        if (!b(Integer.valueOf(cJRTrainFareDetail.getKey()), cJRTrainBooking.getmConfirmation())) {
                            arrayList.add(cJRTrainFareDetail);
                        } else if (a(Integer.valueOf(cJRTrainFareDetail.getKey()), cJRTrainBooking.getmConfirmation())) {
                            cJRTrainFareDetail.setVisibility(true);
                            arrayList.add(cJRTrainFareDetail);
                        } else {
                            cJRTrainFareDetail.setVisibility(false);
                            arrayList.add(cJRTrainFareDetail);
                        }
                    }
                    i2++;
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                    return;
                }
            }
        }
    }

    private boolean a(Integer num, CJRTrainConfirmation cJRTrainConfirmation) {
        List<CJRTrainAddOn> list = cJRTrainConfirmation.getmAddOns();
        boolean z = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            CJRTrainAddOn cJRTrainAddOn = list.get(i2);
            Iterator<Integer> it2 = cJRTrainAddOn.getToBeToggled().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Integer next = it2.next();
                if (num.equals(next) && cJRTrainAddOn.getEnabled().booleanValue() && cJRTrainAddOn.getDefaultChecked().booleanValue()) {
                    this.f26672a.e().put(next, cJRTrainAddOn.getQueryParam());
                    String a2 = o.a(o.a(num.intValue(), cJRTrainConfirmation).getValue());
                    if (!TextUtils.isEmpty(a2)) {
                        com.travel.train.i.e eVar = this.f26672a;
                        eVar.c(Double.valueOf(eVar.l().doubleValue() + Double.parseDouble(a2)));
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    private static boolean b(Integer num, CJRTrainConfirmation cJRTrainConfirmation) {
        List<CJRTrainAddOn> list = cJRTrainConfirmation.getmAddOns();
        boolean z = false;
        if (list != null) {
            for (CJRTrainAddOn toBeToggled : list) {
                List<Integer> toBeToggled2 = toBeToggled.getToBeToggled();
                if (toBeToggled2 != null) {
                    Iterator<Integer> it2 = toBeToggled2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (num.equals(it2.next())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return z;
    }
}
