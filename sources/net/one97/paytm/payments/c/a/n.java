package net.one97.paytm.payments.c.a;

import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.phoenix.api.H5Event;
import org.json.JSONObject;

public final class n extends net.one97.paytm.phoenix.core.a {

    static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H5Event f17255a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f17256b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f17257c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f17258d;

        a(H5Event h5Event, n nVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event2) {
            this.f17255a = h5Event;
            this.f17256b = nVar;
            this.f17257c = bVar;
            this.f17258d = h5Event2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onResponse(java.lang.Object r10) {
            /*
                r9 = this;
                com.paytm.network.model.IJRPaytmDataModel r10 = (com.paytm.network.model.IJRPaytmDataModel) r10
                net.one97.paytm.phoenix.api.H5Event r0 = r9.f17255a
                net.one97.paytm.phoenix.api.b r1 = r9.f17257c
                if (r10 == 0) goto L_0x00da
                net.one97.paytm.paymentsBank.si.response.AllSIResponse r10 = (net.one97.paytm.paymentsBank.si.response.AllSIResponse) r10
                org.json.JSONObject r2 = r0.getParams()
                if (r2 == 0) goto L_0x0017
                java.lang.String r3 = "mAccountNumber"
                java.lang.String r2 = r2.getString(r3)
                goto L_0x0018
            L_0x0017:
                r2 = 0
            L_0x0018:
                android.app.Activity r3 = r0.getActivity()
                net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r4 = r10.getPayload()
                if (r4 == 0) goto L_0x00d9
                net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r4 = r10.getPayload()
                java.lang.String r5 = "siResponse.payload"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                java.lang.String r4 = r4.getErrorMessage()
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r4 = android.text.TextUtils.isEmpty(r4)
                java.lang.String r6 = "success"
                if (r4 == 0) goto L_0x00ba
                if (r3 == 0) goto L_0x00ba
                net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r4 = r10.getPayload()
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                java.util.List r4 = r4.getStandingInstructionList()
                java.lang.String r7 = "acc_no"
                if (r4 == 0) goto L_0x0099
                net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r4 = r10.getPayload()
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                java.util.List r4 = r4.getStandingInstructionList()
                int r4 = r4.size()
                if (r4 <= 0) goto L_0x0099
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r10 = r10.getPayload()
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
                java.util.List r10 = r10.getStandingInstructionList()
                java.util.Iterator r10 = r10.iterator()
            L_0x0071:
                boolean r5 = r10.hasNext()
                if (r5 == 0) goto L_0x0081
                java.lang.Object r5 = r10.next()
                net.one97.paytm.paymentsBank.si.response.AllSIResponse$StandingInstructions r5 = (net.one97.paytm.paymentsBank.si.response.AllSIResponse.StandingInstructions) r5
                r4.add(r5)
                goto L_0x0071
            L_0x0081:
                android.content.Intent r10 = new android.content.Intent
                r5 = r3
                android.content.Context r5 = (android.content.Context) r5
                java.lang.Class<net.one97.paytm.paymentsBank.si.activity.RecurringPaymentListActivity> r8 = net.one97.paytm.paymentsBank.si.activity.RecurringPaymentListActivity.class
                r10.<init>(r5, r8)
                java.io.Serializable r4 = (java.io.Serializable) r4
                java.lang.String r5 = "extra_list"
                r10.putExtra(r5, r4)
                r10.putExtra(r7, r2)
                r3.startActivity(r10)
                goto L_0x00a9
            L_0x0099:
                android.content.Intent r10 = new android.content.Intent
                r4 = r3
                android.content.Context r4 = (android.content.Context) r4
                java.lang.Class<net.one97.paytm.paymentsBank.si.activity.RecurringPaymentAddActivity> r5 = net.one97.paytm.paymentsBank.si.activity.RecurringPaymentAddActivity.class
                r10.<init>(r4, r5)
                r10.putExtra(r7, r2)
                r3.startActivity(r10)
            L_0x00a9:
                org.json.JSONObject r10 = new org.json.JSONObject
                r10.<init>()
                java.lang.String r2 = "true"
                r10.put(r6, r2)
                if (r1 == 0) goto L_0x00b9
                r1.a(r0, r10)
            L_0x00b9:
                return
            L_0x00ba:
                org.json.JSONObject r2 = new org.json.JSONObject
                r2.<init>()
                java.lang.String r3 = "false"
                r2.put(r6, r3)
                net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r10 = r10.getPayload()
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
                java.lang.String r10 = r10.getErrorMessage()
                java.lang.String r3 = "error"
                r2.put(r3, r10)
                if (r1 == 0) goto L_0x00d9
                r1.a(r0, r2)
            L_0x00d9:
                return
            L_0x00da:
                kotlin.u r10 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.paymentsBank.si.response.AllSIResponse"
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.c.a.n.a.onResponse(java.lang.Object):void");
        }
    }

    public n() {
        super("openRecurringScreen");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        if (h5Event.getActivity() == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "javaClass.simpleName");
        hashMap.put("screen_name", simpleName);
        f a2 = net.one97.paytm.paymentsBank.si.d.a.a(h5Event.getActivity(), new a(h5Event, this, bVar, h5Event), new b(this, bVar, h5Event), a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        k.a((Object) a2, "StandingInstructionReque…                        )");
        h5Event.getActivity();
        c.a();
        c.a(a2);
        return true;
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f17259a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.api.b f17260b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f17261c;

        b(n nVar, net.one97.paytm.phoenix.api.b bVar, H5Event h5Event) {
            this.f17259a = nVar;
            this.f17260b = bVar;
            this.f17261c = h5Event;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", "false");
            jSONObject.put("error", networkCustomError != null ? networkCustomError.getAlertMessage() : null);
            net.one97.paytm.phoenix.api.b bVar = this.f17260b;
            if (bVar != null) {
                bVar.a(this.f17261c, jSONObject);
            }
        }
    }
}
