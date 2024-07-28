package com.paytmmall.a.b;

import net.one97.paytm.phoenix.provider.PhoenixActivityResultProvider;

public final class a implements PhoenixActivityResultProvider {

    /* renamed from: a  reason: collision with root package name */
    private String f15388a = "H5ActivityResultProvider";

    /* JADX WARNING: Can't wrap try/catch for region: R(2:31|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r9.put("status", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006a, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006b, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0066 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onActivityResult(android.content.Context r9, int r10, int r11, android.content.Intent r12) {
        /*
            r8 = this;
            java.lang.String r0 = "From"
            java.lang.String r1 = "is_cancel"
            java.lang.String r2 = "order_id"
            r3 = -1
            r4 = 101(0x65, float:1.42E-43)
            java.lang.String r5 = "status"
            r6 = 0
            if (r10 == r4) goto L_0x012b
            r4 = 201(0xc9, float:2.82E-43)
            if (r10 == r4) goto L_0x011f
            r4 = 203(0xcb, float:2.84E-43)
            if (r10 == r4) goto L_0x0113
            r4 = 1010(0x3f2, float:1.415E-42)
            if (r10 == r4) goto L_0x010c
            r4 = 1014(0x3f6, float:1.421E-42)
            if (r10 == r4) goto L_0x0105
            r4 = 2112(0x840, float:2.96E-42)
            java.lang.String r7 = ""
            if (r10 == r4) goto L_0x00f9
            r4 = 20022(0x4e36, float:2.8057E-41)
            if (r10 == r4) goto L_0x00ef
            r4 = 1221(0x4c5, float:1.711E-42)
            if (r10 == r4) goto L_0x00ea
            r4 = 1222(0x4c6, float:1.712E-42)
            if (r10 == r4) goto L_0x00e2
            switch(r10) {
                case 1224: goto L_0x007b;
                case 1225: goto L_0x0073;
                case 1226: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x015c
        L_0x0036:
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            if (r12 == 0) goto L_0x006e
            boolean r10 = r12.hasExtra(r2)     // Catch:{ Exception -> 0x0066 }
            if (r10 == 0) goto L_0x004a
            java.lang.String r10 = r12.getStringExtra(r2)     // Catch:{ Exception -> 0x0066 }
            r9.put(r2, r10)     // Catch:{ Exception -> 0x0066 }
        L_0x004a:
            boolean r10 = r12.hasExtra(r1)     // Catch:{ Exception -> 0x0066 }
            if (r10 == 0) goto L_0x0058
            r10 = 0
            boolean r10 = r12.getBooleanExtra(r1, r10)     // Catch:{ Exception -> 0x0066 }
            r9.put(r1, r10)     // Catch:{ Exception -> 0x0066 }
        L_0x0058:
            boolean r10 = r12.hasExtra(r0)     // Catch:{ Exception -> 0x0066 }
            if (r10 == 0) goto L_0x006e
            java.lang.String r10 = r12.getStringExtra(r0)     // Catch:{ Exception -> 0x0066 }
            r9.put(r0, r10)     // Catch:{ Exception -> 0x0066 }
            goto L_0x006e
        L_0x0066:
            r9.put(r5, r11)     // Catch:{ JSONException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r10 = move-exception
            r10.printStackTrace()
        L_0x006e:
            java.lang.String r9 = r9.toString()
            return r9
        L_0x0073:
            if (r11 != r3) goto L_0x0078
            java.lang.String r9 = "Success"
            return r9
        L_0x0078:
            java.lang.String r9 = "Failed"
            return r9
        L_0x007b:
            if (r12 == 0) goto L_0x00e1
            android.net.Uri r10 = r12.getData()
            if (r10 == 0) goto L_0x00e1
            android.content.ContentResolver r0 = r9.getContentResolver()
            android.net.Uri r1 = r12.getData()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5)
            boolean r10 = r9.moveToFirst()
            if (r10 == 0) goto L_0x00de
            java.lang.String r10 = "has_phone_number"
            int r10 = r9.getColumnIndexOrThrow(r10)
            java.lang.String r10 = r9.getString(r10)
            java.lang.String r11 = "1"
            boolean r10 = r11.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x00de
            java.lang.String r10 = "data1"
            int r10 = r9.getColumnIndex(r10)
            java.lang.String r10 = r9.getString(r10)
            java.lang.String r11 = "display_name"
            int r11 = r9.getColumnIndex(r11)
            java.lang.String r11 = r9.getString(r11)
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d6 }
            r12.<init>()     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r0 = "name"
            r12.put(r0, r11)     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r11 = "mobile"
            r12.put(r11, r10)     // Catch:{ Exception -> 0x00d6 }
            r9.close()     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r9 = r12.toString()     // Catch:{ Exception -> 0x00d6 }
            return r9
        L_0x00d6:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.c(r10)
        L_0x00de:
            r9.close()
        L_0x00e1:
            return r7
        L_0x00e2:
            java.lang.String r9 = "uploadResponse"
            java.lang.String r9 = r12.getStringExtra(r9)
            return r9
        L_0x00ea:
            java.lang.String r9 = com.paytmmall.artifact.d.l.a((android.content.Context) r9)
            return r9
        L_0x00ef:
            boolean r10 = r9 instanceof android.app.Activity
            if (r10 == 0) goto L_0x015c
            android.app.Activity r9 = (android.app.Activity) r9
            com.paytmmall.a.a.h.a(r9)
            goto L_0x015c
        L_0x00f9:
            if (r12 == 0) goto L_0x0104
            java.lang.String r9 = "response"
            java.lang.String r9 = r12.getStringExtra(r9)
            if (r9 == 0) goto L_0x0104
            return r9
        L_0x0104:
            return r7
        L_0x0105:
            java.lang.String r9 = "docUrl"
            java.lang.String r9 = r12.getStringExtra(r9)
            return r9
        L_0x010c:
            java.lang.String r9 = "payload"
            java.lang.String r9 = r12.getStringExtra(r9)
            return r9
        L_0x0113:
            if (r12 == 0) goto L_0x011a
            android.os.Bundle r9 = r12.getExtras()
            goto L_0x011b
        L_0x011a:
            r9 = r6
        L_0x011b:
            com.paytmmall.a.a.f.a((int) r11, (android.os.Bundle) r9)
            goto L_0x015c
        L_0x011f:
            if (r12 == 0) goto L_0x0126
            android.os.Bundle r9 = r12.getExtras()
            goto L_0x0127
        L_0x0126:
            r9 = r6
        L_0x0127:
            com.paytmmall.a.a.k.a(r10, r11, r9)
            goto L_0x015c
        L_0x012b:
            if (r10 != r4) goto L_0x015c
            net.one97.paytm.phoenix.api.b r9 = com.paytmmall.a.a.j.f15379b     // Catch:{ JSONException -> 0x0158 }
            if (r9 == 0) goto L_0x015c
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ JSONException -> 0x0158 }
            r9.<init>()     // Catch:{ JSONException -> 0x0158 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0158 }
            r9.<init>()     // Catch:{ JSONException -> 0x0158 }
            if (r11 != r3) goto L_0x014b
            java.lang.String r10 = "success"
            r9.put(r5, r10)     // Catch:{ JSONException -> 0x0158 }
            net.one97.paytm.phoenix.api.b r10 = com.paytmmall.a.a.j.f15379b     // Catch:{ JSONException -> 0x0158 }
            net.one97.paytm.phoenix.api.H5Event r11 = com.paytmmall.a.a.j.f15380c     // Catch:{ JSONException -> 0x0158 }
            r10.a(r11, r9)     // Catch:{ JSONException -> 0x0158 }
            goto L_0x015c
        L_0x014b:
            java.lang.String r10 = "failure"
            r9.put(r5, r10)     // Catch:{ JSONException -> 0x0158 }
            net.one97.paytm.phoenix.api.b r10 = com.paytmmall.a.a.j.f15379b     // Catch:{ JSONException -> 0x0158 }
            net.one97.paytm.phoenix.api.H5Event r11 = com.paytmmall.a.a.j.f15380c     // Catch:{ JSONException -> 0x0158 }
            r10.a(r11, r9)     // Catch:{ JSONException -> 0x0158 }
            goto L_0x015c
        L_0x0158:
            r9 = move-exception
            r9.printStackTrace()
        L_0x015c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.a.b.a.onActivityResult(android.content.Context, int, int, android.content.Intent):java.lang.Object");
    }
}
