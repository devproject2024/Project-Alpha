package net.one97.paytm.fastag.d;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.fastag.d.g;

public final class f extends d implements g.a<IJRPaytmDataModel> {
    private d errorListenerWeakReference;
    private g.a listenerWeakReference;
    private com.google.gsonhtcfix.f mGson;

    public final void onError(Throwable th) {
    }

    public f(g.a aVar, d dVar) {
        this.listenerWeakReference = aVar;
        this.errorListenerWeakReference = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(com.paytm.network.model.IJRPaytmDataModel r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            r4.mGson = r1
            net.one97.paytm.fastag.d.g$a r1 = r4.listenerWeakReference
            if (r1 != 0) goto L_0x000e
            return
        L_0x000e:
            com.paytm.network.model.NetworkResponse r1 = r5.getNetworkResponse()     // Catch:{ Exception -> 0x004e }
            java.util.Map<java.lang.String, java.lang.String> r1 = r1.headers     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = "Content-Encoding"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x004e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x004e }
            com.paytm.network.model.NetworkResponse r2 = r5.getNetworkResponse()     // Catch:{ Exception -> 0x004c }
            byte[] r2 = r2.data     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x0053
            if (r1 == 0) goto L_0x003f
            java.lang.String r2 = "gzip"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x003f
            com.paytm.network.model.NetworkResponse r2 = r5.getNetworkResponse()     // Catch:{ Exception -> 0x004c }
            byte[] r2 = r2.data     // Catch:{ Exception -> 0x004c }
            java.io.Reader r2 = com.paytm.network.b.g.a((byte[]) r2)     // Catch:{ Exception -> 0x004c }
            if (r2 == 0) goto L_0x0053
            java.lang.String r0 = com.paytm.network.b.g.a((java.io.Reader) r2)     // Catch:{ Exception -> 0x004c }
            goto L_0x0053
        L_0x003f:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x004c }
            com.paytm.network.model.NetworkResponse r3 = r5.getNetworkResponse()     // Catch:{ Exception -> 0x004c }
            byte[] r3 = r3.data     // Catch:{ Exception -> 0x004c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x004c }
            r0 = r2
            goto L_0x0053
        L_0x004c:
            r2 = move-exception
            goto L_0x0050
        L_0x004e:
            r2 = move-exception
            r1 = r0
        L_0x0050:
            r2.printStackTrace()
        L_0x0053:
            if (r1 == 0) goto L_0x00b9
            boolean r1 = r5 instanceof net.one97.paytm.fastag.model.CJRAddresses
            if (r1 == 0) goto L_0x0069
            com.google.gsonhtcfix.f r5 = r4.mGson
            java.lang.Class<net.one97.paytm.fastag.model.CJRAddresses> r1 = net.one97.paytm.fastag.model.CJRAddresses.class
            java.lang.Object r5 = r5.a((java.lang.String) r0, r1)
            net.one97.paytm.fastag.model.CJRAddresses r5 = (net.one97.paytm.fastag.model.CJRAddresses) r5
            net.one97.paytm.fastag.d.g$a r0 = r4.listenerWeakReference
            r0.onResponse(r5)
            return
        L_0x0069:
            boolean r1 = r5 instanceof net.one97.paytm.fastag.model.CJRUploadDocument
            if (r1 == 0) goto L_0x007d
            com.google.gsonhtcfix.f r5 = r4.mGson
            java.lang.Class<net.one97.paytm.fastag.model.CJRUploadDocument> r1 = net.one97.paytm.fastag.model.CJRUploadDocument.class
            java.lang.Object r5 = r5.a((java.lang.String) r0, r1)
            net.one97.paytm.fastag.model.CJRUploadDocument r5 = (net.one97.paytm.fastag.model.CJRUploadDocument) r5
            net.one97.paytm.fastag.d.g$a r0 = r4.listenerWeakReference
            r0.onResponse(r5)
            return
        L_0x007d:
            boolean r1 = r5 instanceof net.one97.paytm.fastag.model.CJRDetailProduct
            if (r1 == 0) goto L_0x0091
            com.google.gsonhtcfix.f r5 = r4.mGson
            java.lang.Class<net.one97.paytm.fastag.model.CJRDetailProduct> r1 = net.one97.paytm.fastag.model.CJRDetailProduct.class
            java.lang.Object r5 = r5.a((java.lang.String) r0, r1)
            net.one97.paytm.fastag.model.CJRDetailProduct r5 = (net.one97.paytm.fastag.model.CJRDetailProduct) r5
            net.one97.paytm.fastag.d.g$a r0 = r4.listenerWeakReference
            r0.onResponse(r5)
            return
        L_0x0091:
            boolean r1 = r5 instanceof net.one97.paytm.fastag.model.CJRRechargeCart
            if (r1 == 0) goto L_0x00a5
            com.google.gsonhtcfix.f r5 = r4.mGson
            java.lang.Class<net.one97.paytm.fastag.model.CJRRechargeCart> r1 = net.one97.paytm.fastag.model.CJRRechargeCart.class
            java.lang.Object r5 = r5.a((java.lang.String) r0, r1)
            net.one97.paytm.fastag.model.CJRRechargeCart r5 = (net.one97.paytm.fastag.model.CJRRechargeCart) r5
            net.one97.paytm.fastag.d.g$a r0 = r4.listenerWeakReference
            r0.onResponse(r5)
            return
        L_0x00a5:
            boolean r5 = r5 instanceof net.one97.paytm.fastag.model.CJRAadharPanSave
            if (r5 == 0) goto L_0x00be
            com.google.gsonhtcfix.f r5 = r4.mGson
            java.lang.Class<net.one97.paytm.fastag.model.CJRAadharPanSave> r1 = net.one97.paytm.fastag.model.CJRAadharPanSave.class
            java.lang.Object r5 = r5.a((java.lang.String) r0, r1)
            net.one97.paytm.fastag.model.CJRAadharPanSave r5 = (net.one97.paytm.fastag.model.CJRAadharPanSave) r5
            net.one97.paytm.fastag.d.g$a r0 = r4.listenerWeakReference
            r0.onResponse(r5)
            return
        L_0x00b9:
            net.one97.paytm.fastag.d.g$a r0 = r4.listenerWeakReference
            r0.onResponse(r5)
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.d.f.onResponse(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onErrorResponse(int r4, com.paytm.network.model.IJRPaytmDataModel r5, com.paytm.network.model.NetworkCustomError r6) {
        /*
            r3 = this;
            net.one97.paytm.fastag.d.d r0 = r3.errorListenerWeakReference
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            r3.mGson = r0
            com.paytm.network.model.NetworkResponse r0 = r6.networkResponse
            if (r0 == 0) goto L_0x007c
            int r4 = r0.statusCode
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.headers
            java.lang.String r2 = "Content-Encoding"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            byte[] r2 = r0.data
            if (r2 == 0) goto L_0x0040
            if (r1 == 0) goto L_0x0037
            java.lang.String r2 = "gzip"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0037
            byte[] r0 = r0.data
            java.io.Reader r0 = com.paytm.network.b.g.a((byte[]) r0)
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = com.paytm.network.b.g.a((java.io.Reader) r0)
            goto L_0x0042
        L_0x0037:
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r0.data
            r1.<init>(r0)
            r0 = r1
            goto L_0x0042
        L_0x0040:
            java.lang.String r0 = ""
        L_0x0042:
            r1 = 401(0x191, float:5.62E-43)
            if (r4 == r1) goto L_0x0076
            r1 = 410(0x19a, float:5.75E-43)
            if (r4 == r1) goto L_0x0076
            r1 = 480(0x1e0, float:6.73E-43)
            if (r4 == r1) goto L_0x0076
            r1 = 753(0x2f1, float:1.055E-42)
            if (r4 != r1) goto L_0x0053
            goto L_0x0076
        L_0x0053:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0075
            boolean r1 = r5 instanceof net.one97.paytm.fastag.model.CJRUploadDocument     // Catch:{ Exception -> 0x006d }
            if (r1 == 0) goto L_0x006c
            com.google.gsonhtcfix.f r1 = r3.mGson     // Catch:{ Exception -> 0x006d }
            java.lang.Class<net.one97.paytm.fastag.model.CJRUploadDocument> r2 = net.one97.paytm.fastag.model.CJRUploadDocument.class
            java.lang.Object r0 = r1.a((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x006d }
            net.one97.paytm.fastag.model.CJRUploadDocument r0 = (net.one97.paytm.fastag.model.CJRUploadDocument) r0     // Catch:{ Exception -> 0x006d }
            net.one97.paytm.fastag.d.g$a r1 = r3.listenerWeakReference     // Catch:{ Exception -> 0x006d }
            r1.onResponse(r0)     // Catch:{ Exception -> 0x006d }
        L_0x006c:
            return
        L_0x006d:
            net.one97.paytm.fastag.d.d r0 = r3.errorListenerWeakReference
            if (r0 == 0) goto L_0x0075
            r0.onErrorResponse(r4, r5, r6)
        L_0x0075:
            return
        L_0x0076:
            net.one97.paytm.fastag.d.d r0 = r3.errorListenerWeakReference
            r0.onErrorResponse(r4, r5, r6)
            return
        L_0x007c:
            net.one97.paytm.fastag.d.d r0 = r3.errorListenerWeakReference
            if (r0 == 0) goto L_0x0083
            r0.onErrorResponse(r4, r5, r6)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.d.f.onErrorResponse(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }
}
