package net.one97.paytm.paymentsBank.utils;

public final class p {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0065 A[Catch:{ IllegalErrorCode -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A[Catch:{ IllegalErrorCode -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.paytm.network.model.IJRPaytmDataModel r6, com.paytm.network.model.NetworkCustomError r7, net.one97.paytm.bankCommon.g.g.b r8) {
        /*
            com.paytm.network.model.NetworkResponse r7 = r7.networkResponse
            java.lang.String r0 = ""
            if (r7 == 0) goto L_0x0084
            int r1 = r7.statusCode
            java.util.Map<java.lang.String, java.lang.String> r2 = r7.headers
            java.lang.String r3 = "Content-Encoding"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            byte[] r3 = r7.data
            if (r3 == 0) goto L_0x0035
            if (r2 == 0) goto L_0x002d
            java.lang.String r3 = "gzip"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x002d
            byte[] r2 = r7.data
            java.io.Reader r2 = com.paytm.network.b.g.a((byte[]) r2)
            if (r2 == 0) goto L_0x0035
            java.lang.String r2 = com.paytm.network.b.g.a((java.io.Reader) r2)
            goto L_0x0036
        L_0x002d:
            java.lang.String r2 = new java.lang.String
            byte[] r3 = r7.data
            r2.<init>(r3)
            goto L_0x0036
        L_0x0035:
            r2 = r0
        L_0x0036:
            r3 = 403(0x193, float:5.65E-43)
            r4 = 401(0x191, float:5.62E-43)
            if (r1 != r3) goto L_0x003e
            r1 = 401(0x191, float:5.62E-43)
        L_0x003e:
            byte[] r7 = r7.data     // Catch:{ IllegalErrorCode -> 0x0084 }
            if (r7 == 0) goto L_0x0084
            if (r1 == r4) goto L_0x0084
            r7 = 410(0x19a, float:5.75E-43)
            if (r1 == r7) goto L_0x0084
            com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f     // Catch:{ IllegalErrorCode -> 0x0084 }
            r3.<init>()     // Catch:{ IllegalErrorCode -> 0x0084 }
            boolean r5 = r6 instanceof net.one97.paytm.paymentsBank.si.response.SIDeActivateResponse     // Catch:{ IllegalErrorCode -> 0x0084 }
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6 instanceof net.one97.paytm.paymentsBank.si.response.SIActivateResponse     // Catch:{ IllegalErrorCode -> 0x0084 }
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6 instanceof net.one97.paytm.paymentsBank.si.response.SIDeleteResponse     // Catch:{ IllegalErrorCode -> 0x0084 }
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6 instanceof net.one97.paytm.paymentsBank.si.response.SIPrevalidateResponse     // Catch:{ IllegalErrorCode -> 0x0084 }
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6 instanceof net.one97.paytm.paymentsBank.si.response.SICreationResponse     // Catch:{ IllegalErrorCode -> 0x0084 }
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6 instanceof net.one97.paytm.paymentsBank.si.response.AllSIResponse     // Catch:{ IllegalErrorCode -> 0x0084 }
            if (r5 == 0) goto L_0x0066
            goto L_0x0079
        L_0x0066:
            if (r1 == r4) goto L_0x0073
            if (r1 == r7) goto L_0x0073
            r6 = 480(0x1e0, float:6.73E-43)
            if (r1 == r6) goto L_0x0073
            r6 = 753(0x2f1, float:1.055E-42)
            if (r1 == r6) goto L_0x0073
            goto L_0x0084
        L_0x0073:
            net.one97.paytm.bankCommon.model.IllegalErrorCode r6 = new net.one97.paytm.bankCommon.model.IllegalErrorCode     // Catch:{ IllegalErrorCode -> 0x0084 }
            r6.<init>(r2)     // Catch:{ IllegalErrorCode -> 0x0084 }
            throw r6     // Catch:{ IllegalErrorCode -> 0x0084 }
        L_0x0079:
            java.lang.Class r6 = r6.getClass()     // Catch:{ IllegalErrorCode -> 0x0084 }
            java.lang.Object r6 = r3.a((java.lang.String) r2, r6)     // Catch:{ IllegalErrorCode -> 0x0084 }
            r8.onResponse(r6)     // Catch:{ IllegalErrorCode -> 0x0084 }
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.utils.p.a(com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError, net.one97.paytm.bankCommon.g.g$b):java.lang.String");
    }
}
