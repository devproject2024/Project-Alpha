package net.one97.paytm.phoenix.d;

import android.content.ClipboardManager;
import com.alipay.mobile.h5container.api.H5Plugin;
import net.one97.paytm.phoenix.core.a;

public final class z extends a {

    /* renamed from: a  reason: collision with root package name */
    public ClipboardManager f59575a;

    public z() {
        super(H5Plugin.CommonEvents.SET_CLIPBOARD, H5Plugin.CommonEvents.GET_CLIPBOARD);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r9, net.one97.paytm.phoenix.api.b r10) {
        /*
            r8 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r10, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.b) r10)
            boolean r10 = r8.a((net.one97.paytm.phoenix.api.H5Event) r9)
            r0 = 1
            if (r10 == 0) goto L_0x00d1
            android.app.Activity r10 = r9.getActivity()
            r1 = 0
            if (r10 == 0) goto L_0x0039
            android.app.Activity r10 = r9.getActivity()
            if (r10 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            boolean r10 = r10 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r10 == 0) goto L_0x0039
            android.app.Activity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x0031
            net.one97.paytm.phoenix.ui.PhoenixActivity r10 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r10
            goto L_0x003a
        L_0x0031:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            r10 = r1
        L_0x003a:
            r2 = 0
            if (r10 != 0) goto L_0x003e
            return r2
        L_0x003e:
            java.lang.String r3 = "clipboard"
            java.lang.Object r10 = r10.getSystemService(r3)
            if (r10 == 0) goto L_0x00c9
            android.content.ClipboardManager r10 = (android.content.ClipboardManager) r10
            r8.f59575a = r10
            java.lang.String r10 = r9.getAction$phoenix_debug()
            if (r10 != 0) goto L_0x0052
            goto L_0x00d1
        L_0x0052:
            int r4 = r10.hashCode()
            r5 = -1610002720(0xffffffffa0094ee0, float:-1.1630449E-19)
            r6 = 2
            java.lang.String r7 = "text"
            if (r4 == r5) goto L_0x009b
            r2 = -61010092(0xfffffffffc5d0f54, float:-4.591234E36)
            if (r4 == r2) goto L_0x0065
            goto L_0x00d1
        L_0x0065:
            java.lang.String r2 = "setClipboard"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00d1
            org.json.JSONObject r10 = r9.getParams()
            if (r10 == 0) goto L_0x0078
            java.lang.String r10 = r10.optString(r7)
            goto L_0x0079
        L_0x0078:
            r10 = r1
        L_0x0079:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0096 }
            android.content.ClipData r10 = android.content.ClipData.newPlainText(r1, r10)     // Catch:{ Exception -> 0x0096 }
            android.content.ClipboardManager r2 = r8.f59575a     // Catch:{ Exception -> 0x0096 }
            if (r2 != 0) goto L_0x0086
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0096 }
        L_0x0086:
            if (r2 == 0) goto L_0x008b
            r2.setPrimaryClip(r10)     // Catch:{ Exception -> 0x0096 }
        L_0x008b:
            java.lang.String r10 = "success"
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0096 }
            r8.a((java.lang.String) r10, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0096 }
            net.one97.paytm.phoenix.core.a.a(r8, r9, r1, r0, r6)     // Catch:{ Exception -> 0x0096 }
            goto L_0x00d1
        L_0x0096:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x00d1
        L_0x009b:
            java.lang.String r4 = "getClipboard"
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x00d1
            android.content.ClipboardManager r10 = r8.f59575a
            if (r10 != 0) goto L_0x00aa
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00aa:
            if (r10 == 0) goto L_0x00bd
            android.content.ClipData r10 = r10.getPrimaryClip()
            if (r10 == 0) goto L_0x00bd
            android.content.ClipData$Item r10 = r10.getItemAt(r2)
            if (r10 == 0) goto L_0x00bd
            java.lang.CharSequence r10 = r10.getText()
            goto L_0x00be
        L_0x00bd:
            r10 = r1
        L_0x00be:
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r8.a((java.lang.String) r7, (java.lang.Object) r10)
            net.one97.paytm.phoenix.core.a.a(r8, r9, r1, r0, r6)
            goto L_0x00d1
        L_0x00c9:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type android.content.ClipboardManager"
            r9.<init>(r10)
            throw r9
        L_0x00d1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.z.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
