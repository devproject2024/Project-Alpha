package com.paytmmall.a.a;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.paytmmall.artifact.R;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONObject;

public final class l extends a {
    public l() {
        super("mpProductShareEvents", "mpShareThroughWhatsApp");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r8, net.one97.paytm.phoenix.api.b r9) {
        /*
            r7 = this;
            org.json.JSONObject r0 = r8.getParams()
            java.lang.String r1 = "action"
            java.lang.Object r0 = r0.opt(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.hashCode()
            r2 = -1450693701(0xffffffffa9882bbb, float:-6.047199E-14)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x0029
            r2 = 513605740(0x1e9d006c, float:1.6623196E-20)
            if (r1 == r2) goto L_0x001f
            goto L_0x0033
        L_0x001f:
            java.lang.String r1 = "mpProductShareEvents"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r1 = "mpShareThroughWhatsApp"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            if (r0 == 0) goto L_0x00ed
            if (r0 == r4) goto L_0x003d
            b(r8)
            goto L_0x00f0
        L_0x003d:
            if (r8 == 0) goto L_0x00f0
            org.json.JSONObject r0 = r8.getParams()
            if (r0 == 0) goto L_0x00f0
            if (r8 == 0) goto L_0x00f0
            org.json.JSONObject r0 = r8.getParams()
            if (r0 == 0) goto L_0x00f0
            android.app.Activity r0 = r8.getActivity()
            if (r0 == 0) goto L_0x00f0
            org.json.JSONObject r1 = r8.getParams()
            java.lang.String r2 = "title"
            java.lang.Object r2 = r1.opt(r2)
            java.lang.String.valueOf(r2)
            java.lang.String r2 = "text"
            java.lang.Object r2 = r1.opt(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "url"
            java.lang.Object r1 = r1.opt(r4)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r5 = "com.whatsapp"
            if (r4 != 0) goto L_0x00be
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x00be
            java.lang.String r4 = "null"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto L_0x00be
            android.app.Activity r0 = r8.getActivity()
            org.json.JSONObject r1 = r8.getParams()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            if (r1 == 0) goto L_0x00ba
            int r3 = r1.length()
            if (r3 <= 0) goto L_0x00ba
            java.util.Iterator r3 = r1.keys()
        L_0x00a6:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00ba
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r6 = r1.optString(r4)
            r2.put(r4, r6)
            goto L_0x00a6
        L_0x00ba:
            com.paytmmall.artifact.common.b.a.a.a(r0, r2, r5)
            goto L_0x00f0
        L_0x00be:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x00f0
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x00f0
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.SEND"
            r1.<init>(r4)
            java.lang.String r4 = "text/plain"
            r1.setType(r4)
            r1.setPackage(r5)
            java.lang.String r4 = "android.intent.extra.TEXT"
            r1.putExtra(r4, r2)
            r0.startActivity(r1)     // Catch:{ ActivityNotFoundException -> 0x00e3 }
            goto L_0x00f0
        L_0x00e3:
            java.lang.String r1 = "Whatsapp have not been installed."
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r3)
            r0.show()
            goto L_0x00f0
        L_0x00ed:
            b(r8)
        L_0x00f0:
            boolean r8 = super.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.b) r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.a.a.l.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    private static void b(H5Event h5Event) {
        Activity activity;
        if (h5Event != null && h5Event.getParams() != null && (activity = h5Event.getActivity()) != null) {
            JSONObject params = h5Event.getParams();
            String valueOf = String.valueOf(params.opt("title"));
            String valueOf2 = String.valueOf(params.opt(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
            if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                a(activity, valueOf, valueOf2);
            }
        }
    }

    private static void a(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.setType("text/plain");
        activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.share_using)));
    }
}
