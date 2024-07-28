package net.one97.paytm.f;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.b.a;
import com.google.gson.f;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.RiskAnalysis.Contact;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f50401c;

    /* renamed from: a  reason: collision with root package name */
    public RiskExtendedInfo f50402a = new RiskExtendedInfo();

    /* renamed from: b  reason: collision with root package name */
    public boolean f50403b;

    b() {
    }

    public static b a() {
        if (f50401c == null) {
            f50401c = new b();
        }
        return f50401c;
    }

    public final RiskExtendedInfo b() {
        return this.f50402a;
    }

    public final void a(Context context, String str, String str2, boolean z, String str3, String str4, String str5) {
        boolean z2;
        try {
            String str6 = null;
            Contact a2 = !TextUtils.isEmpty(str2) ? a(context, str2) : null;
            RiskExtendedInfo riskExtendedInfo = a().f50402a;
            riskExtendedInfo.setDeviceAccounts(a.a().f50398e);
            if (!TextUtils.isEmpty(str)) {
                riskExtendedInfo.setDisplayName(URLEncoder.encode(URLDecoder.decode(str, "utf-8"), "utf-8"));
            } else {
                riskExtendedInfo.setDisplayName(str);
            }
            if (a2 != null) {
                str6 = a2.getUpdatedTime();
            }
            riskExtendedInfo.setContactCreateTime(str6);
            if (a2 == null) {
                z2 = false;
            } else {
                z2 = a2.isContactExits();
            }
            riskExtendedInfo.setIsContact(z2);
            riskExtendedInfo.setIsRooted(a.a().f50396c);
            riskExtendedInfo.setLci(a.a().f50394a);
            riskExtendedInfo.setLco(a.a().f50395b);
            riskExtendedInfo.setOtpReadFlag(z);
            ArrayList<String> arrayList = a.a().f50397d;
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(URLEncoder.encode(URLDecoder.decode(it2.next(), "utf-8"), "utf-8"));
                }
            }
            riskExtendedInfo.setWifissid(arrayList2);
            if (str4 != null) {
                riskExtendedInfo.setLatitude(str4);
            }
            if (str5 != null) {
                riskExtendedInfo.setLongitude(str5);
            }
            riskExtendedInfo.setTranscationType(str3);
            riskExtendedInfo.setLcic(a.a().f50399f);
            this.f50403b = true;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        return new net.one97.paytm.common.entity.RiskAnalysis.Contact(r12, false, "0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (r3 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        throw r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.common.entity.RiskAnalysis.Contact a(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "0"
            java.lang.String r1 = "contact_last_updated_timestamp"
            r2 = 0
            r3 = 0
            java.lang.String r4 = "data1"
            java.lang.String[] r7 = new java.lang.String[]{r1, r4}     // Catch:{ Exception -> 0x004e }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x004e }
            android.net.Uri r6 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch:{ Exception -> 0x004e }
            java.lang.String r8 = "data1 LIKE '%' || ?"
            r11 = 1
            java.lang.String[] r9 = new java.lang.String[r11]     // Catch:{ Exception -> 0x004e }
            r9[r2] = r12     // Catch:{ Exception -> 0x004e }
            r10 = 0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0043
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x004e }
            if (r4 == 0) goto L_0x0043
            int r4 = r3.getCount()     // Catch:{ Exception -> 0x004e }
            if (r4 <= 0) goto L_0x0043
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x004e }
            long r4 = r3.getLong(r1)     // Catch:{ Exception -> 0x004e }
            net.one97.paytm.common.entity.RiskAnalysis.Contact r1 = new net.one97.paytm.common.entity.RiskAnalysis.Contact     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x004e }
            r1.<init>(r12, r11, r4)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0042
            r3.close()
        L_0x0042:
            return r1
        L_0x0043:
            if (r3 == 0) goto L_0x0048
            r3.close()
        L_0x0048:
            net.one97.paytm.common.entity.RiskAnalysis.Contact r11 = new net.one97.paytm.common.entity.RiskAnalysis.Contact
            r11.<init>(r12, r2, r0)
            return r11
        L_0x004e:
            net.one97.paytm.common.entity.RiskAnalysis.Contact r11 = new net.one97.paytm.common.entity.RiskAnalysis.Contact     // Catch:{ all -> 0x0059 }
            r11.<init>(r12, r2, r0)     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x0058
            r3.close()
        L_0x0058:
            return r11
        L_0x0059:
            r11 = move-exception
            if (r3 == 0) goto L_0x005f
            r3.close()
        L_0x005f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.f.b.a(android.content.Context, java.lang.String):net.one97.paytm.common.entity.RiskAnalysis.Contact");
    }

    public final void c() {
        f50401c = null;
        this.f50402a = null;
    }

    public final String d() {
        if (this.f50402a != null) {
            try {
                return new f().a((Object) a().f50402a, new a<RiskExtendedInfo>() {
                }.getType());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final String e() {
        if (this.f50402a != null) {
            try {
                return "scanType:" + this.f50402a.getScanType() + "|isContact:" + this.f50402a.getIsContact() + "|otpReadFlag:" + this.f50402a.getOtpReadFlag() + "|contactCreateTime:" + this.f50402a.getContactCreateTime() + "|isRooted:" + this.f50402a.getIsRooted() + "|displayName:" + this.f50402a.getDisplayName() + "|mode:" + this.f50402a.getMode() + "|wifi:" + this.f50402a.getWifi() + "|mode:" + this.f50402a.getMode() + "|userLBSLatitude:" + this.f50402a.getUserLbsLatitude() + "|userLBSLongitude:" + this.f50402a.getUserLbsLongitude() + "|CHANNEL_ID:" + this.f50402a.getChannelIDV2() + "|terminalType:" + this.f50402a.getTerminalType() + "|deviceId:" + this.f50402a.getDeviceId() + "|appVersion:" + this.f50402a.getAppVersion() + "|versionCode:" + this.f50402a.getVersionCode() + "|osType:" + this.f50402a.getOsType() + "|phoneModel:" + this.f50402a.getPhoneModel() + "|IMEI:" + this.f50402a.getIMEI() + "|deviceManufacturer:" + this.f50402a.getDeviceManufacturer() + "|deviceLanguage:" + this.f50402a.getDeviceLanguage() + "|timeZone:" + this.f50402a.getTimeZone() + "|routerMac:" + this.f50402a.getRouterMac() + "|clientIp:" + this.f50402a.getClientIp() + "|productCode:" + this.f50402a.getProductCode() + "|isOfflineMerchant:" + this.f50402a.getIsOfflineMerchant() + "|isOnlineMerchant:" + this.f50402a.getIsOnlineMerchant() + "|operationOrigin:" + this.f50402a.getOperationOrigin() + "|paymentFlow:" + this.f50402a.getPaymentFlow() + "|operationType:" + this.f50402a.getOperationType() + "|requestType:" + this.f50402a.getRequestType() + "|fuzzyDeviceId:" + this.f50402a.getFuzzyDeviceId() + "|screenResolution:" + this.f50402a.getScreenResolution() + "|isGalleryScan:" + this.f50402a.isGalleryScan();
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
