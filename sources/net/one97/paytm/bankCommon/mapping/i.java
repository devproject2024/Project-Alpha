package net.one97.paytm.bankCommon.mapping;

import net.one97.paytm.bankCommon.g.g;

public final class i implements g.a, g.b {

    /* renamed from: a  reason: collision with root package name */
    private g.b f16296a;

    /* renamed from: b  reason: collision with root package name */
    private g.a f16297b;

    public i(g.b bVar, g.a aVar) {
        this.f16296a = bVar;
        this.f16297b = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.paytm.network.model.IJRPaytmDataModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(java.lang.Object r7) {
        /*
            r6 = this;
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            java.lang.String r1 = ""
            net.one97.paytm.bankCommon.g.g$b r2 = r6.f16296a
            if (r2 != 0) goto L_0x000c
            return
        L_0x000c:
            r2 = 0
            r3 = r7
            com.paytm.network.model.IJRPaytmDataModel r3 = (com.paytm.network.model.IJRPaytmDataModel) r3     // Catch:{ Exception -> 0x0043 }
            com.paytm.network.model.NetworkResponse r2 = r3.getNetworkResponse()     // Catch:{ Exception -> 0x0041 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.headers     // Catch:{ Exception -> 0x0041 }
            java.lang.String r4 = "Content-Encoding"
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0041 }
            com.paytm.network.model.NetworkResponse r4 = r3.getNetworkResponse()     // Catch:{ Exception -> 0x0041 }
            byte[] r4 = r4.data     // Catch:{ Exception -> 0x0041 }
            if (r4 == 0) goto L_0x004a
            if (r2 == 0) goto L_0x004a
            java.lang.String r4 = "gzip"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0041 }
            if (r2 == 0) goto L_0x004a
            com.paytm.network.model.NetworkResponse r2 = r3.getNetworkResponse()     // Catch:{ Exception -> 0x0041 }
            byte[] r2 = r2.data     // Catch:{ Exception -> 0x0041 }
            java.io.Reader r2 = com.paytm.network.b.g.a((byte[]) r2)     // Catch:{ Exception -> 0x0041 }
            if (r2 == 0) goto L_0x004a
            java.lang.String r1 = com.paytm.network.b.g.a((java.io.Reader) r2)     // Catch:{ Exception -> 0x0041 }
            goto L_0x004a
        L_0x0041:
            r2 = move-exception
            goto L_0x0047
        L_0x0043:
            r3 = move-exception
            r5 = r3
            r3 = r2
            r2 = r5
        L_0x0047:
            r2.printStackTrace()
        L_0x004a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x005b
            java.lang.Class r7 = r7.getClass()
            java.lang.Object r7 = r0.a((java.lang.String) r1, r7)
            r3 = r7
            com.paytm.network.model.IJRPaytmDataModel r3 = (com.paytm.network.model.IJRPaytmDataModel) r3
        L_0x005b:
            net.one97.paytm.bankCommon.g.g$b r7 = r6.f16296a
            if (r7 == 0) goto L_0x0062
            r7.onResponse(r3)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankCommon.mapping.i.onResponse(java.lang.Object):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b5 A[Catch:{ Exception -> 0x00df }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d5 A[SYNTHETIC, Splitter:B:74:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onErrorResponse(int r5, com.paytm.network.model.IJRPaytmDataModel r6, com.paytm.network.model.NetworkCustomError r7) {
        /*
            r4 = this;
            com.paytm.network.model.NetworkResponse r0 = r7.networkResponse
            if (r0 == 0) goto L_0x00f6
            int r5 = r0.statusCode
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.headers
            java.lang.String r2 = "Content-Encoding"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            byte[] r2 = r0.data
            if (r2 == 0) goto L_0x0034
            if (r1 == 0) goto L_0x002b
            java.lang.String r2 = "gzip"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x002b
            byte[] r0 = r0.data
            java.io.Reader r0 = com.paytm.network.b.g.a((byte[]) r0)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = com.paytm.network.b.g.a((java.io.Reader) r0)
            goto L_0x0036
        L_0x002b:
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r0.data
            r1.<init>(r0)
            r0 = r1
            goto L_0x0036
        L_0x0034:
            java.lang.String r0 = ""
        L_0x0036:
            r1 = 401(0x191, float:5.62E-43)
            if (r5 == r1) goto L_0x00f0
            r1 = 410(0x19a, float:5.75E-43)
            if (r5 == r1) goto L_0x00f0
            r1 = 480(0x1e0, float:6.73E-43)
            if (r5 == r1) goto L_0x00f0
            r1 = 753(0x2f1, float:1.055E-42)
            if (r5 != r1) goto L_0x0048
            goto L_0x00f0
        L_0x0048:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x00e8
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x00df }
            r1.<init>()     // Catch:{ Exception -> 0x00df }
            net.one97.paytm.bankOpen.d r2 = net.one97.paytm.bankOpen.f.b()     // Catch:{ Exception -> 0x00df }
            boolean r2 = r2.handleResponse(r6)     // Catch:{ Exception -> 0x00df }
            if (r2 == 0) goto L_0x006f
            net.one97.paytm.bankCommon.g.g$b r2 = r4.f16296a     // Catch:{ Exception -> 0x00df }
            if (r2 == 0) goto L_0x006e
            net.one97.paytm.bankCommon.g.g$b r2 = r4.f16296a     // Catch:{ Exception -> 0x00df }
            java.lang.Class r3 = r6.getClass()     // Catch:{ Exception -> 0x00df }
            java.lang.Object r0 = r1.a((java.lang.String) r0, r3)     // Catch:{ Exception -> 0x00df }
            r2.onResponse(r0)     // Catch:{ Exception -> 0x00df }
        L_0x006e:
            return
        L_0x006f:
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PBVerifyPasscodeResponse     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.ResetPasscodeTokenModal     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PBCJRCard     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PBResetPasscodeTokenModal     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.NomineeAdd     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.CustProductStatus     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PBBlockUnblockCardResponse     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PDCAtmPinSetResponse     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PBUADPincode     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.CustProductList     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.IsaDetailsModel     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PBCardDetailModel     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.PBCJRAccountSummary     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.SavingAccountDetailDataModel     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.SavingAccountPassbookEntriesModal     // Catch:{ Exception -> 0x00df }
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r6 instanceof net.one97.paytm.bankCommon.model.CJRGenerateAuthAccessToken     // Catch:{ Exception -> 0x00df }
            if (r2 == 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r2 = 0
            goto L_0x00b3
        L_0x00b2:
            r2 = 1
        L_0x00b3:
            if (r2 == 0) goto L_0x00d5
            java.lang.Class r2 = r6.getClass()     // Catch:{ Exception -> 0x00df }
            java.lang.Object r0 = r1.a((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x00df }
            com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0     // Catch:{ Exception -> 0x00df }
            boolean r6 = r0 instanceof net.one97.paytm.bankCommon.model.PBVerifyPasscodeResponse     // Catch:{ Exception -> 0x00d3 }
            if (r6 == 0) goto L_0x00c9
            r6 = r0
            net.one97.paytm.bankCommon.model.PBVerifyPasscodeResponse r6 = (net.one97.paytm.bankCommon.model.PBVerifyPasscodeResponse) r6     // Catch:{ Exception -> 0x00d3 }
            r6.setResponseCodeLocal(r5)     // Catch:{ Exception -> 0x00d3 }
        L_0x00c9:
            net.one97.paytm.bankCommon.g.g$b r6 = r4.f16296a     // Catch:{ Exception -> 0x00d3 }
            if (r6 == 0) goto L_0x00d2
            net.one97.paytm.bankCommon.g.g$b r6 = r4.f16296a     // Catch:{ Exception -> 0x00d3 }
            r6.onResponse(r0)     // Catch:{ Exception -> 0x00d3 }
        L_0x00d2:
            return
        L_0x00d3:
            r6 = r0
            goto L_0x00e0
        L_0x00d5:
            net.one97.paytm.bankCommon.g.g$a r0 = r4.f16297b     // Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x00de
            net.one97.paytm.bankCommon.g.g$a r0 = r4.f16297b     // Catch:{ Exception -> 0x00df }
            r0.onErrorResponse(r5, r6, r7)     // Catch:{ Exception -> 0x00df }
        L_0x00de:
            return
        L_0x00df:
        L_0x00e0:
            net.one97.paytm.bankCommon.g.g$a r0 = r4.f16297b
            if (r0 == 0) goto L_0x00e7
            r0.onErrorResponse(r5, r6, r7)
        L_0x00e7:
            return
        L_0x00e8:
            net.one97.paytm.bankCommon.g.g$a r0 = r4.f16297b
            if (r0 == 0) goto L_0x00ef
            r0.onErrorResponse(r5, r6, r7)
        L_0x00ef:
            return
        L_0x00f0:
            net.one97.paytm.bankCommon.g.g$a r0 = r4.f16297b
            r0.onErrorResponse(r5, r6, r7)
            return
        L_0x00f6:
            net.one97.paytm.bankCommon.g.g$a r0 = r4.f16297b
            if (r0 == 0) goto L_0x00fd
            r0.onErrorResponse(r5, r6, r7)
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankCommon.mapping.i.onErrorResponse(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }
}
