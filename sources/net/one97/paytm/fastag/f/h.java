package net.one97.paytm.fastag.f;

import android.content.Context;
import com.paytm.utility.CJRSecureSharedPreferences;
import com.paytm.utility.b;
import com.paytm.utility.x;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import net.one97.paytm.fastag.c.a;

public final class h extends b {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[Catch:{ Exception -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r8, android.widget.TextView r9) {
        /*
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.Typeface r1 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            r2 = 0
            if (r1 == 0) goto L_0x0019
            android.graphics.Typeface r1 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            if (r1 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = r2
            goto L_0x0020
        L_0x0019:
            java.lang.String r1 = "sans-serif-medium"
            r3 = 1
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3)     // Catch:{ Exception -> 0x006c }
        L_0x0020:
            android.graphics.Typeface r3 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            r4 = 0
            if (r3 == 0) goto L_0x002d
            android.graphics.Typeface r3 = r9.getTypeface()     // Catch:{ Exception -> 0x006c }
            if (r3 == 0) goto L_0x0033
        L_0x002d:
            java.lang.String r2 = "sans-serif-light"
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r4)     // Catch:{ Exception -> 0x006c }
        L_0x0033:
            java.lang.String r3 = "\\."
            java.lang.String[] r3 = r8.split(r3)     // Catch:{ Exception -> 0x006c }
            if (r3 == 0) goto L_0x006b
            int r5 = r3.length     // Catch:{ Exception -> 0x006c }
            if (r5 > 0) goto L_0x003f
            goto L_0x006b
        L_0x003f:
            r3 = r3[r4]     // Catch:{ Exception -> 0x006c }
            int r3 = r3.length()     // Catch:{ Exception -> 0x006c }
            int r5 = r8.length()     // Catch:{ Exception -> 0x006c }
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x006c }
            r6.<init>(r8)     // Catch:{ Exception -> 0x006c }
            com.paytm.utility.CustomTypefaceSpan r7 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x006c }
            r7.<init>(r0, r1)     // Catch:{ Exception -> 0x006c }
            r1 = 34
            r6.setSpan(r7, r4, r3, r1)     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = "."
            boolean r8 = r8.contains(r4)     // Catch:{ Exception -> 0x006c }
            if (r8 == 0) goto L_0x0068
            com.paytm.utility.CustomTypefaceSpan r8 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x006c }
            r8.<init>(r0, r2)     // Catch:{ Exception -> 0x006c }
            r6.setSpan(r8, r3, r5, r1)     // Catch:{ Exception -> 0x006c }
        L_0x0068:
            r9.setText(r6)     // Catch:{ Exception -> 0x006c }
        L_0x006b:
            return
        L_0x006c:
            r8 = move-exception
            r8.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.f.h.b(java.lang.String, android.widget.TextView):void");
    }

    public static String j(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2);
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat2.format(simpleDateFormat.parse(str));
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1 = new net.one97.paytm.fastag.model.Contact((java.lang.String) null, false, "0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r11 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.fastag.model.Contact ao(android.content.Context r11) {
        /*
            java.lang.String r0 = "0"
            java.lang.String r1 = "contact_last_updated_timestamp"
            r2 = 0
            r3 = 0
            java.lang.String r4 = "data1"
            java.lang.String[] r7 = new java.lang.String[]{r1, r4}     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            android.net.Uri r6 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            java.lang.String r8 = "data1 LIKE '%' || ?"
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r10 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            if (r11 == 0) goto L_0x0043
            boolean r4 = r11.moveToFirst()     // Catch:{ Exception -> 0x0052 }
            if (r4 == 0) goto L_0x0043
            int r4 = r11.getCount()     // Catch:{ Exception -> 0x0052 }
            if (r4 <= 0) goto L_0x0043
            int r1 = r11.getColumnIndex(r1)     // Catch:{ Exception -> 0x0052 }
            long r4 = r11.getLong(r1)     // Catch:{ Exception -> 0x0052 }
            net.one97.paytm.fastag.model.Contact r1 = new net.one97.paytm.fastag.model.Contact     // Catch:{ Exception -> 0x0052 }
            r6 = 1
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0052 }
            r1.<init>(r3, r6, r4)     // Catch:{ Exception -> 0x0052 }
            if (r11 == 0) goto L_0x0042
            r11.close()
        L_0x0042:
            return r1
        L_0x0043:
            if (r11 == 0) goto L_0x0048
            r11.close()
        L_0x0048:
            net.one97.paytm.fastag.model.Contact r11 = new net.one97.paytm.fastag.model.Contact
            r11.<init>(r3, r2, r0)
            return r11
        L_0x004e:
            r0 = move-exception
            r11 = r3
            goto L_0x005e
        L_0x0051:
            r11 = r3
        L_0x0052:
            net.one97.paytm.fastag.model.Contact r1 = new net.one97.paytm.fastag.model.Contact     // Catch:{ all -> 0x005d }
            r1.<init>(r3, r2, r0)     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x005c
            r11.close()
        L_0x005c:
            return r1
        L_0x005d:
            r0 = move-exception
        L_0x005e:
            if (r11 == 0) goto L_0x0063
            r11.close()
        L_0x0063:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.f.h.ao(android.content.Context):net.one97.paytm.fastag.model.Contact");
    }

    private static String ap(Context context) {
        return CJRSecureSharedPreferences.getInstance(context).getString("cart_id", (String) null);
    }

    private static String aq(Context context) {
        return CJRSecureSharedPreferences.getInstance(context).getString("sso_token=", (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r17, java.lang.Throwable r18, java.lang.String r19) {
        /*
            r0 = r17
            r1 = r18
            com.paytm.network.model.NetworkCustomError r1 = (com.paytm.network.model.NetworkCustomError) r1
            if (r0 == 0) goto L_0x0293
            boolean r2 = r17.isFinishing()
            if (r2 != 0) goto L_0x0293
            if (r1 == 0) goto L_0x0293
            java.lang.String r2 = r1.getMessage()
            if (r2 == 0) goto L_0x002f
            java.lang.String r2 = r1.getMessage()
            java.lang.String r3 = "401"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 != 0) goto L_0x002e
            java.lang.String r2 = r1.getMessage()
            java.lang.String r3 = "410"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x002f
        L_0x002e:
            return
        L_0x002f:
            java.lang.String r2 = r1.getMessage()
            if (r2 == 0) goto L_0x0293
            r2 = r1
            com.paytm.network.model.NetworkCustomError r2 = (com.paytm.network.model.NetworkCustomError) r2
            java.lang.String r3 = r2.getMessage()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x006a
            java.lang.String r4 = "failure_error"
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x006a
            if (r2 == 0) goto L_0x0067
            java.lang.String r3 = r2.getAlertTitle()
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = r2.getAlertMessage()
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = r2.getAlertTitle()
            java.lang.String r2 = r2.getAlertMessage()
            com.paytm.utility.b.a((android.content.Context) r0, (java.lang.String) r3, (java.lang.String) r2, (boolean) r6)
            goto L_0x0244
        L_0x0067:
            r5 = 0
            goto L_0x0244
        L_0x006a:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r7 = "504"
            java.lang.String r8 = "502"
            java.lang.String r9 = "499"
            r10 = 0
            java.lang.String r11 = "503"
            if (r4 != 0) goto L_0x009a
            boolean r4 = r3.equalsIgnoreCase(r9)
            if (r4 != 0) goto L_0x0091
            boolean r4 = r3.equalsIgnoreCase(r8)
            if (r4 != 0) goto L_0x0091
            boolean r4 = r3.equalsIgnoreCase(r11)
            if (r4 != 0) goto L_0x0091
            boolean r4 = r3.equalsIgnoreCase(r7)
            if (r4 == 0) goto L_0x009a
        L_0x0091:
            java.lang.String r10 = r2.getAlertMessage()
            java.lang.String r4 = r2.getAlertTitle()
            goto L_0x009b
        L_0x009a:
            r4 = r10
        L_0x009b:
            boolean r12 = android.text.TextUtils.isEmpty(r4)
            if (r12 != 0) goto L_0x00a7
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 == 0) goto L_0x012a
        L_0x00a7:
            boolean r12 = android.text.TextUtils.isEmpty(r3)
            if (r12 != 0) goto L_0x00c8
            boolean r9 = r3.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x00c8
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.message_499
            java.lang.String r10 = r4.getString(r7)
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.title_499
            java.lang.String r4 = r4.getString(r7)
            goto L_0x012a
        L_0x00c8:
            boolean r9 = android.text.TextUtils.isEmpty(r3)
            if (r9 != 0) goto L_0x00e9
            boolean r8 = r3.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x00e9
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.message_502
            java.lang.String r10 = r4.getString(r7)
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.title_502
            java.lang.String r4 = r4.getString(r7)
            goto L_0x012a
        L_0x00e9:
            boolean r8 = android.text.TextUtils.isEmpty(r3)
            if (r8 != 0) goto L_0x010a
            boolean r8 = r3.equalsIgnoreCase(r11)
            if (r8 == 0) goto L_0x010a
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.message_503
            java.lang.String r10 = r4.getString(r7)
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.title_503
            java.lang.String r4 = r4.getString(r7)
            goto L_0x012a
        L_0x010a:
            boolean r8 = android.text.TextUtils.isEmpty(r3)
            if (r8 != 0) goto L_0x012a
            boolean r7 = r3.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x012a
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.message_504
            java.lang.String r10 = r4.getString(r7)
            android.content.res.Resources r4 = r17.getResources()
            int r7 = net.one97.paytm.fastag.R.string.title_504
            java.lang.String r4 = r4.getString(r7)
        L_0x012a:
            boolean r7 = android.text.TextUtils.isEmpty(r10)
            if (r7 != 0) goto L_0x0067
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 != 0) goto L_0x0198
            boolean r3 = r3.equalsIgnoreCase(r11)
            if (r3 == 0) goto L_0x0198
            if (r0 == 0) goto L_0x0244
            net.one97.paytm.fastag.c.a r2 = net.one97.paytm.fastag.c.a.a()
            net.one97.paytm.fastag.c.b r2 = r2.f13559b
            java.lang.String r2 = r2.getLeadAPIOnAppLaunchUrl()
            if (r2 == 0) goto L_0x0193
            java.lang.String r2 = com.paytm.utility.a.c(r0, r2)
            java.lang.String r3 = ap(r17)
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 != 0) goto L_0x016c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r2)
            java.lang.String r2 = "&cart_id="
            r7.append(r2)
            r7.append(r3)
            java.lang.String r2 = r7.toString()
        L_0x016c:
            r12 = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.HashMap r16 = com.paytm.utility.a.a((java.util.HashMap<java.lang.String, java.lang.String>) r2, (android.content.Context) r0)
            net.one97.paytm.fastag.d.c.a()
            net.one97.paytm.fastag.d.a r2 = new net.one97.paytm.fastag.d.a
            net.one97.paytm.fastag.f.h$1 r13 = new net.one97.paytm.fastag.f.h$1
            r13.<init>(r0, r4, r10)
            net.one97.paytm.fastag.f.h$2 r14 = new net.one97.paytm.fastag.f.h$2
            r14.<init>(r0)
            net.one97.paytm.fastag.model.CJRContingency r15 = new net.one97.paytm.fastag.model.CJRContingency
            r15.<init>()
            r11 = r2
            r11.<init>(r12, r13, r14, r15, r16)
            net.one97.paytm.fastag.d.c.a(r2)
            goto L_0x0244
        L_0x0193:
            com.paytm.utility.b.a((android.content.Context) r0, (java.lang.String) r4, (java.lang.String) r10, (boolean) r6)
            goto L_0x0244
        L_0x0198:
            if (r0 == 0) goto L_0x0244
            if (r2 != 0) goto L_0x019e
            goto L_0x0244
        L_0x019e:
            com.paytm.network.model.NetworkCustomError r2 = (com.paytm.network.model.NetworkCustomError) r2
            int r3 = net.one97.paytm.fastag.R.string.error_dialog_title
            java.lang.String r3 = r0.getString(r3)
            int r4 = net.one97.paytm.fastag.R.string.error_dialog_message
            java.lang.String r4 = r0.getString(r4)
            java.lang.String r7 = aq(r17)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r9 = ""
            java.lang.String r10 = "/"
            if (r8 != 0) goto L_0x01cc
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = r10.concat(r7)
            boolean r8 = r4.contains(r7)
            if (r8 == 0) goto L_0x01cc
            java.lang.String r4 = r4.replace(r7, r9)
        L_0x01cc:
            java.lang.String r7 = ap(r17)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x01e8
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = r10.concat(r7)
            boolean r8 = r4.contains(r7)
            if (r8 == 0) goto L_0x01e8
            java.lang.String r4 = r4.replace(r7, r9)
        L_0x01e8:
            net.one97.paytm.fastag.f.h$3 r7 = new net.one97.paytm.fastag.f.h$3
            r8 = r19
            r7.<init>(r2, r0, r8)
            boolean r2 = net.one97.paytm.fastag.f.c.f13765a
            if (r2 != 0) goto L_0x0244
            if (r0 == 0) goto L_0x0244
            boolean r2 = r0 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0244
            r2 = r0
            android.app.Activity r2 = (android.app.Activity) r2
            boolean r2 = r2.isFinishing()
            if (r2 != 0) goto L_0x0244
            com.paytm.utility.h r2 = new com.paytm.utility.h
            r2.<init>(r0)
            if (r3 == 0) goto L_0x020c
            r2.setTitle(r3)
        L_0x020c:
            if (r4 == 0) goto L_0x0211
            r2.a(r4)
        L_0x0211:
            r2.setCancelable(r6)
            android.view.WindowManager$LayoutParams r3 = net.one97.paytm.fastag.f.c.a(r2)
            r4 = -1
            int r8 = net.one97.paytm.fastag.R.string.string_report_error
            java.lang.String r8 = r0.getString(r8)
            net.one97.paytm.fastag.f.c$3 r9 = new net.one97.paytm.fastag.f.c$3
            r9.<init>(r2, r7)
            r2.a(r4, r8, r9)
            r4 = -2
            int r7 = net.one97.paytm.fastag.R.string.cancel
            java.lang.String r7 = r0.getString(r7)
            net.one97.paytm.fastag.f.c$4 r8 = new net.one97.paytm.fastag.f.c$4
            r8.<init>(r2)
            r2.a(r4, r7, r8)
            r2.show()
            if (r3 == 0) goto L_0x0242
            android.view.Window r2 = r2.getWindow()
            r2.setAttributes(r3)
        L_0x0242:
            net.one97.paytm.fastag.f.c.f13765a = r5
        L_0x0244:
            if (r5 != 0) goto L_0x0293
            java.lang.String r2 = r1.getMessage()
            if (r2 == 0) goto L_0x0264
            java.lang.String r2 = r1.getMessage()
            java.lang.String r3 = "parsing_error"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0264
            java.lang.String r2 = r1.getUrl()
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.b.d((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r1)
            return
        L_0x0264:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.res.Resources r3 = r17.getResources()
            int r4 = net.one97.paytm.fastag.R.string.network_error_message
            java.lang.String r3 = r3.getString(r4)
            r2.append(r3)
            java.lang.String r3 = " "
            r2.append(r3)
            java.lang.String r1 = r1.getUrl()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.content.res.Resources r2 = r17.getResources()
            int r3 = net.one97.paytm.fastag.R.string.network_error_heading
            java.lang.String r2 = r2.getString(r3)
            com.paytm.utility.b.a((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r1, (boolean) r6)
        L_0x0293:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.f.h.a(android.app.Activity, java.lang.Throwable, java.lang.String):void");
    }

    public static Map<String, String> v() {
        Context mallApplicationContext = a.a().f13559b.getMallApplicationContext();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("client_id", x.f43867b);
        hashMap.put("client_secret", x.f43868c);
        hashMap.put("session_token", aq(mallApplicationContext));
        hashMap.put("Authorization", x.f43869d);
        if (ap(mallApplicationContext) != null) {
            hashMap.put("cart_id", ap(mallApplicationContext));
        }
        return hashMap;
    }
}
