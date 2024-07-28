package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class an {

    /* renamed from: b  reason: collision with root package name */
    private static final String f72946b = an.class.getName();

    /* renamed from: a  reason: collision with root package name */
    JSONArray f72947a = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f72948c;

    /* renamed from: d  reason: collision with root package name */
    private x f72949d;

    /* renamed from: e  reason: collision with root package name */
    private List f72950e;

    public an(Context context) {
        this.f72948c = context;
        this.f72949d = new x(this.f72948c);
        this.f72947a = new JSONArray();
        byte[] a2 = l.a("npci_otp_rules.json", context);
        if (a2 != null) {
            try {
                this.f72947a = new JSONArray(new String(a2));
            } catch (Exception e2) {
                ad.a(f72946b, e2);
            }
        }
    }

    public static String a(String str) {
        String lowerCase = str.toLowerCase();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(lowerCase.getBytes(), 0, lowerCase.length());
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0".concat(String.valueOf(bigInteger));
            }
            return bigInteger;
        } catch (Exception e2) {
            ad.a(f72946b, e2);
            return null;
        }
    }

    private String a(ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return null;
        }
        String str = ((String) arrayList.get(0));
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            str = str + AppConstants.COMMA + ((String) arrayList.get(i2));
        }
        return str;
    }

    private am a(int i2, String str, String str2, JSONObject jSONObject) {
        String str3;
        try {
            if (!a(str2, jSONObject.getJSONArray("sender")) || !a(str, jSONObject.getString("message"))) {
                return null;
            }
            if (i2 != 0) {
                str3 = "\\d{" + i2 + "}";
            } else {
                str3 = (String) jSONObject.get("otp");
            }
            Matcher matcher = Pattern.compile(str3).matcher(str);
            am amVar = new am();
            amVar.a(str);
            if (matcher.find() && matcher.groupCount() >= 0) {
                amVar.b(matcher.group(0));
                return amVar;
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    private boolean a(String str, String str2) {
        return Pattern.compile(str2, 2).matcher(str).find();
    }

    private boolean a(String str, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (Pattern.compile(jSONArray.getString(i2), 2).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private boolean b(String str) {
        if (this.f72950e == null) {
            this.f72950e = Arrays.asList(this.f72949d.b(CLConstants.MGS_ID_PREFERENCES, "").split(AppConstants.COMMA));
        }
        return this.f72950e.contains(str);
    }

    private boolean b(am amVar) {
        return !b(amVar.c()) && !b(c(amVar));
    }

    private String c(am amVar) {
        return a(amVar.a());
    }

    private void c(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f72949d.b(CLConstants.MGS_ID_PREFERENCES, "").split(AppConstants.COMMA)));
            if (!arrayList.contains(str)) {
                if (arrayList.size() >= 10) {
                    arrayList.remove(0);
                }
                arrayList.add(str);
                this.f72949d.a(CLConstants.MGS_ID_PREFERENCES, a(arrayList));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (r12 != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        if (r12 != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r12 != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008b, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.npci.upi.security.pinactivitycomponent.am a(int r11, long r12) {
        /*
            r10 = this;
            java.lang.String r0 = "content://sms/inbox"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            java.lang.String r0 = "_id"
            java.lang.String r1 = "address"
            java.lang.String r3 = "body"
            java.lang.String r4 = "date"
            java.lang.String[] r3 = new java.lang.String[]{r0, r1, r3, r4}
            r1 = 0
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "date > ?"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            java.lang.String r6 = "date DESC"
            r7 = 0
            android.content.Context r5 = r10.f72948c     // Catch:{ SecurityException -> 0x0085, Exception -> 0x0074, all -> 0x0071 }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ SecurityException -> 0x0085, Exception -> 0x0074, all -> 0x0071 }
            r8 = 1
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ SecurityException -> 0x0085, Exception -> 0x0074, all -> 0x0071 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SecurityException -> 0x0085, Exception -> 0x0074, all -> 0x0071 }
            r9[r1] = r12     // Catch:{ SecurityException -> 0x0085, Exception -> 0x0074, all -> 0x0071 }
            r1 = r5
            r5 = r9
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ SecurityException -> 0x0085, Exception -> 0x0074, all -> 0x0071 }
        L_0x0033:
            boolean r13 = r12.moveToNext()     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            if (r13 == 0) goto L_0x006a
            java.lang.String r13 = r12.getString(r8)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            r1 = 2
            java.lang.String r1 = r12.getString(r1)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            org.npci.upi.security.pinactivitycomponent.am r13 = r10.a(r11, r13, r1)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            if (r13 == 0) goto L_0x0033
            int r1 = r12.getColumnIndex(r0)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            long r1 = r12.getLong(r1)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            r13.c(r1)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            boolean r1 = r10.b((org.npci.upi.security.pinactivitycomponent.am) r13)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            if (r1 == 0) goto L_0x0033
            r10.a((org.npci.upi.security.pinactivitycomponent.am) r13)     // Catch:{ SecurityException -> 0x006f, Exception -> 0x006d }
            if (r12 == 0) goto L_0x0069
            r12.close()
        L_0x0069:
            return r13
        L_0x006a:
            if (r12 == 0) goto L_0x008b
            goto L_0x0088
        L_0x006d:
            r11 = move-exception
            goto L_0x0076
        L_0x006f:
            goto L_0x0086
        L_0x0071:
            r11 = move-exception
            r12 = r7
            goto L_0x007f
        L_0x0074:
            r11 = move-exception
            r12 = r7
        L_0x0076:
            java.lang.String r13 = f72946b     // Catch:{ all -> 0x007e }
            org.npci.upi.security.pinactivitycomponent.ad.a((java.lang.String) r13, (java.lang.Exception) r11)     // Catch:{ all -> 0x007e }
            if (r12 == 0) goto L_0x008b
            goto L_0x0088
        L_0x007e:
            r11 = move-exception
        L_0x007f:
            if (r12 == 0) goto L_0x0084
            r12.close()
        L_0x0084:
            throw r11
        L_0x0085:
            r12 = r7
        L_0x0086:
            if (r12 == 0) goto L_0x008b
        L_0x0088:
            r12.close()
        L_0x008b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.an.a(int, long):org.npci.upi.security.pinactivitycomponent.am");
    }

    public am a(int i2, String str, String str2) {
        int i3 = 0;
        while (i3 < this.f72947a.length()) {
            try {
                am a2 = a(i2, str2, str, this.f72947a.getJSONObject(i3));
                if (a2 != null) {
                    return a2;
                }
                i3++;
            } catch (Exception e2) {
                ad.a(f72946b, e2);
                return null;
            }
        }
        return null;
    }

    public void a(am amVar) {
        c(amVar.c() != null ? amVar.c() : c(amVar));
    }
}
