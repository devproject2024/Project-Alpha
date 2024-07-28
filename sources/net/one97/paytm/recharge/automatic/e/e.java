package net.one97.paytm.recharge.automatic.e;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.recharge.widgets.a.d;

public final class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private final net.one97.paytm.recharge.widgets.b.d f60280a;

    /* renamed from: b  reason: collision with root package name */
    private final String f60281b;

    public e(net.one97.paytm.recharge.widgets.b.d dVar, String str) {
        k.c(dVar, "listener");
        this.f60280a = dVar;
        this.f60281b = str;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        this.f60280a.onApiSuccess(iJRPaytmDataModel);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:60|61|(1:(1:(1:79))(1:75))(1:67)|80|81) */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r0 = (com.paytm.network.model.CJRIllegalCodeError) new com.google.gsonhtcfix.f().a(r1, new com.paytm.network.model.CJRIllegalCodeError().getClass());
        r1 = new com.paytm.network.model.NetworkCustomError(r10.networkResponse, java.lang.String.valueOf(r10.getStatusCode()));
        r4 = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
        net.one97.paytm.recharge.automatic.b.a.h.a.a(r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0171, code lost:
        if (r0 == null) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0183, code lost:
        r2 = r0.getStatusError().getmMessage();
        kotlin.g.b.k.a((java.lang.Object) r2, "errorStatus.statusError.getmMessage()");
        r1.setAlertMessage(r2.getMessage());
        r0 = r0.getStatusError().getmMessage();
        kotlin.g.b.k.a((java.lang.Object) r0, "errorStatus.statusError.getmMessage()");
        r1.setmAlertTitle(r0.getTitle());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a8, code lost:
        if (r0 == null) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01cf, code lost:
        r1.setAlertMessage(r0.getError_message());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01e5, code lost:
        r1.setAlertMessage(r0.getError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ec, code lost:
        r7.f60280a.handleErrorCode(r8, r9, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f1, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0149 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleErrorCode(int r8, com.paytm.network.model.IJRPaytmDataModel r9, com.paytm.network.model.NetworkCustomError r10) {
        /*
            r7 = this;
            java.lang.String r0 = "networkError"
            kotlin.g.b.k.c(r10, r0)
            com.paytm.network.model.NetworkResponse r0 = r10.networkResponse     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0034
            com.paytm.network.model.NetworkResponse r0 = r10.networkResponse     // Catch:{ Exception -> 0x01f2 }
            byte[] r0 = r0.data     // Catch:{ Exception -> 0x01f2 }
            if (r0 == 0) goto L_0x0034
            com.paytm.network.model.NetworkResponse r0 = r10.networkResponse     // Catch:{ Exception -> 0x01f2 }
            byte[] r0 = r0.data     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r2 = "gzip"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x01f2 }
            if (r2 == 0) goto L_0x0028
            java.io.Reader r0 = com.paytm.network.b.g.a((byte[]) r0)     // Catch:{ Exception -> 0x01f2 }
            if (r0 == 0) goto L_0x0034
            java.lang.String r1 = com.paytm.network.b.g.a((java.io.Reader) r0)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x0034
        L_0x0028:
            java.lang.String r1 = "networkData"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x01f2 }
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x01f2 }
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x01f2 }
        L_0x0034:
            r0 = 401(0x191, float:5.62E-43)
            r2 = 1
            java.lang.String r3 = "errorStatus.statusError.getmMessage()"
            if (r8 == r0) goto L_0x0141
            r0 = 410(0x19a, float:5.75E-43)
            if (r8 == r0) goto L_0x0141
            r0 = 412(0x19c, float:5.77E-43)
            if (r8 == r0) goto L_0x0141
            r0 = 499(0x1f3, float:6.99E-43)
            if (r8 == r0) goto L_0x0141
            r0 = 502(0x1f6, float:7.03E-43)
            if (r8 == r0) goto L_0x0141
            r0 = 503(0x1f7, float:7.05E-43)
            if (r8 == r0) goto L_0x0141
            r0 = 504(0x1f8, float:7.06E-43)
            if (r8 == r0) goto L_0x0141
            com.paytm.network.model.CJRIllegalCodeError r0 = new com.paytm.network.model.CJRIllegalCodeError     // Catch:{ Exception -> 0x0149 }
            r0.<init>()     // Catch:{ Exception -> 0x0149 }
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0149 }
            r4.<init>()     // Catch:{ Exception -> 0x0149 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0149 }
            java.lang.Object r0 = r4.a((java.lang.String) r1, r0)     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRIllegalCodeError r0 = (com.paytm.network.model.CJRIllegalCodeError) r0     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.NetworkCustomError r4 = new com.paytm.network.model.NetworkCustomError     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.NetworkResponse r5 = r10.networkResponse     // Catch:{ Exception -> 0x0149 }
            java.lang.String r6 = "failure_error"
            r4.<init>((com.paytm.network.model.NetworkResponse) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0149 }
            net.one97.paytm.recharge.automatic.b.a.h$a r5 = net.one97.paytm.recharge.automatic.b.a.h.f60252a     // Catch:{ Exception -> 0x0149 }
            net.one97.paytm.recharge.automatic.b.a.h.a.a((com.paytm.network.model.NetworkCustomError) r4, (com.paytm.network.model.NetworkCustomError) r10)     // Catch:{ Exception -> 0x0149 }
            if (r0 == 0) goto L_0x007c
            com.paytm.network.model.ErrorAdditionalInfo r5 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x0149 }
            goto L_0x007d
        L_0x007c:
            r5 = 0
        L_0x007d:
            if (r5 == 0) goto L_0x00c9
            com.paytm.network.model.ErrorAdditionalInfo r5 = r0.getAdditionalInfo()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r6 = "errorStatus.additionalInfo"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = r5.getConfirmationFlag()     // Catch:{ Exception -> 0x0149 }
            r4.setUniqueReference(r5)     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x00c3
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRError r5 = r5.getmMessage()     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x00c3
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRError r5 = r5.getmMessage()     // Catch:{ Exception -> 0x0149 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0149 }
            r4.setAlertMessage(r5)     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRStatusError r0 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRError r0 = r0.getmMessage()     // Catch:{ Exception -> 0x0149 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r0.getTitle()     // Catch:{ Exception -> 0x0149 }
            r4.setmAlertTitle(r0)     // Catch:{ Exception -> 0x0149 }
        L_0x00c3:
            net.one97.paytm.recharge.widgets.b.d r0 = r7.f60280a     // Catch:{ Exception -> 0x0149 }
            r0.handleErrorCode(r8, r9, r4)     // Catch:{ Exception -> 0x0149 }
            return
        L_0x00c9:
            com.paytm.network.model.CJRIllegalCodeError r0 = new com.paytm.network.model.CJRIllegalCodeError     // Catch:{ Exception -> 0x0149 }
            r0.<init>()     // Catch:{ Exception -> 0x0149 }
            com.google.gsonhtcfix.f r5 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0149 }
            r5.<init>()     // Catch:{ Exception -> 0x0149 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0149 }
            java.lang.Object r0 = r5.a((java.lang.String) r1, r0)     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRIllegalCodeError r0 = (com.paytm.network.model.CJRIllegalCodeError) r0     // Catch:{ Exception -> 0x0149 }
            if (r0 == 0) goto L_0x0139
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x0139
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = r5.getmResult()     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x0139
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = r5.getmResult()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r6 = "failure"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r2)     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x0139
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x0133
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRError r5 = r5.getmMessage()     // Catch:{ Exception -> 0x0149 }
            if (r5 == 0) goto L_0x0133
            com.paytm.network.model.CJRStatusError r5 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRError r5 = r5.getmMessage()     // Catch:{ Exception -> 0x0149 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x0149 }
            r4.setAlertMessage(r5)     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRStatusError r0 = r0.getStatusError()     // Catch:{ Exception -> 0x0149 }
            com.paytm.network.model.CJRError r0 = r0.getmMessage()     // Catch:{ Exception -> 0x0149 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r0.getTitle()     // Catch:{ Exception -> 0x0149 }
            r4.setmAlertTitle(r0)     // Catch:{ Exception -> 0x0149 }
        L_0x0133:
            net.one97.paytm.recharge.widgets.b.d r0 = r7.f60280a     // Catch:{ Exception -> 0x0149 }
            r0.handleErrorCode(r8, r9, r4)     // Catch:{ Exception -> 0x0149 }
            return
        L_0x0139:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0149 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0149 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x0149 }
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x0141:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0149 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0149 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x0149 }
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x0149:
            com.paytm.network.model.CJRIllegalCodeError r0 = new com.paytm.network.model.CJRIllegalCodeError     // Catch:{ Exception -> 0x01f2 }
            r0.<init>()     // Catch:{ Exception -> 0x01f2 }
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x01f2 }
            r4.<init>()     // Catch:{ Exception -> 0x01f2 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x01f2 }
            java.lang.Object r0 = r4.a((java.lang.String) r1, r0)     // Catch:{ Exception -> 0x01f2 }
            com.paytm.network.model.CJRIllegalCodeError r0 = (com.paytm.network.model.CJRIllegalCodeError) r0     // Catch:{ Exception -> 0x01f2 }
            com.paytm.network.model.NetworkCustomError r1 = new com.paytm.network.model.NetworkCustomError     // Catch:{ Exception -> 0x01f2 }
            com.paytm.network.model.NetworkResponse r4 = r10.networkResponse     // Catch:{ Exception -> 0x01f2 }
            int r5 = r10.getStatusCode()     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x01f2 }
            r1.<init>((com.paytm.network.model.NetworkResponse) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x01f2 }
            net.one97.paytm.recharge.automatic.b.a.h$a r4 = net.one97.paytm.recharge.automatic.b.a.h.f60252a     // Catch:{ Exception -> 0x01f2 }
            net.one97.paytm.recharge.automatic.b.a.h.a.a((com.paytm.network.model.NetworkCustomError) r1, (com.paytm.network.model.NetworkCustomError) r10)     // Catch:{ Exception -> 0x01f2 }
            if (r0 == 0) goto L_0x01a8
            com.paytm.network.model.CJRStatusError r4 = r0.getStatusError()     // Catch:{ Exception -> 0x01f2 }
            if (r4 == 0) goto L_0x01a8
            com.paytm.network.model.CJRStatusError r4 = r0.getStatusError()     // Catch:{ Exception -> 0x01f2 }
            com.paytm.network.model.CJRError r4 = r4.getmMessage()     // Catch:{ Exception -> 0x01f2 }
            if (r4 == 0) goto L_0x01a8
            com.paytm.network.model.CJRStatusError r2 = r0.getStatusError()     // Catch:{ Exception -> 0x01f2 }
            com.paytm.network.model.CJRError r2 = r2.getmMessage()     // Catch:{ Exception -> 0x01f2 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x01f2 }
            r1.setAlertMessage(r2)     // Catch:{ Exception -> 0x01f2 }
            com.paytm.network.model.CJRStatusError r0 = r0.getStatusError()     // Catch:{ Exception -> 0x01f2 }
            com.paytm.network.model.CJRError r0 = r0.getmMessage()     // Catch:{ Exception -> 0x01f2 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r0 = r0.getTitle()     // Catch:{ Exception -> 0x01f2 }
            r1.setmAlertTitle(r0)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x01ec
        L_0x01a8:
            if (r0 == 0) goto L_0x01d7
            java.lang.String r3 = r0.getError()     // Catch:{ Exception -> 0x01f2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x01f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01f2 }
            if (r3 != 0) goto L_0x01d7
            java.lang.String r3 = r0.getError()     // Catch:{ Exception -> 0x01f2 }
            java.lang.String r4 = "true"
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r2)     // Catch:{ Exception -> 0x01f2 }
            if (r2 == 0) goto L_0x01d7
            java.lang.String r2 = r0.getError_message()     // Catch:{ Exception -> 0x01f2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01f2 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x01f2 }
            if (r2 != 0) goto L_0x01d7
            java.lang.String r0 = r0.getError_message()     // Catch:{ Exception -> 0x01f2 }
            r1.setAlertMessage(r0)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x01ec
        L_0x01d7:
            if (r0 == 0) goto L_0x01ec
            java.lang.String r2 = r0.getError()     // Catch:{ Exception -> 0x01f2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01f2 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x01f2 }
            if (r2 != 0) goto L_0x01ec
            java.lang.String r0 = r0.getError()     // Catch:{ Exception -> 0x01f2 }
            r1.setAlertMessage(r0)     // Catch:{ Exception -> 0x01f2 }
        L_0x01ec:
            net.one97.paytm.recharge.widgets.b.d r0 = r7.f60280a     // Catch:{ Exception -> 0x01f2 }
            r0.handleErrorCode(r8, r9, r1)     // Catch:{ Exception -> 0x01f2 }
            return
        L_0x01f2:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            net.one97.paytm.recharge.widgets.b.d r0 = r7.f60280a
            r0.handleErrorCode(r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.automatic.e.e.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }
}
