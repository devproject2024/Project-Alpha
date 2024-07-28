package net.one97.paytm.trustlogin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.gson.f;
import com.paytm.utility.q;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.trustLogin.SavedAppData;
import net.one97.paytm.j.c;

public final class b {
    static String a(Context context, String str) {
        PackageInfo packageInfo;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e2) {
            q.b(e2.getMessage());
            packageInfo = null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        try {
            certificateFactory = CertificateFactory.getInstance("X509");
        } catch (CertificateException e3) {
            q.b(e3.getMessage());
            certificateFactory = null;
        }
        try {
            x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
        } catch (CertificateException e4) {
            q.b(e4.getMessage());
            x509Certificate = null;
        }
        try {
            return a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e5) {
            q.b(e5.getMessage());
            return null;
        } catch (CertificateEncodingException e6) {
            q.b(e6.getMessage());
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            String hexString = Integer.toHexString(bArr[i2]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i2 < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[SYNTHETIC, Splitter:B:20:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC, Splitter:B:27:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A[SYNTHETIC, Splitter:B:34:0x005d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0044=Splitter:B:24:0x0044, B:17:0x0035=Splitter:B:17:0x0035} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r5) {
        /*
            r0 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x0042, Exception -> 0x0033, all -> 0x002e }
            java.lang.String r1 = "requestorApps.json"
            java.io.InputStream r5 = r5.open(r1)     // Catch:{ IOException -> 0x0042, Exception -> 0x0033, all -> 0x002e }
            int r1 = r5.available()     // Catch:{ IOException -> 0x002c, Exception -> 0x002a }
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x002c, Exception -> 0x002a }
            r5.read(r1)     // Catch:{ IOException -> 0x002c, Exception -> 0x002a }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x002c, Exception -> 0x002a }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x002c, Exception -> 0x002a }
            if (r5 == 0) goto L_0x0029
            r5.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0029
        L_0x0021:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x0029:
            return r2
        L_0x002a:
            r1 = move-exception
            goto L_0x0035
        L_0x002c:
            r1 = move-exception
            goto L_0x0044
        L_0x002e:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x005b
        L_0x0033:
            r1 = move-exception
            r5 = r0
        L_0x0035:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005a }
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x0059
            r5.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0059
        L_0x0042:
            r1 = move-exception
            r5 = r0
        L_0x0044:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005a }
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x0059
            r5.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x0059:
            return r0
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            if (r5 == 0) goto L_0x0069
            r5.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x0069:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.trustlogin.b.a(android.content.Context):java.lang.String");
    }

    public static SavedAppData.AppData a(Context context, String str, String str2) {
        ArrayList<SavedAppData.AppData> arrayList;
        String a2 = a(context);
        SavedAppData.AppData appData = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        f fVar = new f();
        new com.google.gson.q();
        SavedAppData savedAppData = (SavedAppData) fVar.a(com.google.gson.q.a(a2), SavedAppData.class);
        if (savedAppData == null || savedAppData.getData() == null || savedAppData.getData().size() <= 0) {
            arrayList = null;
        } else {
            Iterator<SavedAppData.BuildDataList> it2 = savedAppData.getData().iterator();
            arrayList = null;
            while (it2.hasNext()) {
                SavedAppData.BuildDataList next = it2.next();
                if (!TextUtils.isEmpty(str) && next.getBuildvariant().equalsIgnoreCase(str)) {
                    arrayList = next.getApp_data();
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<SavedAppData.AppData> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                SavedAppData.AppData next2 = it3.next();
                if (!(str2 == null || next2.getApp_package_name() == null || !next2.getApp_package_name().equals(str2))) {
                    appData = next2;
                }
            }
        }
        return appData;
    }

    public static String a() {
        String str = null;
        try {
            c.a();
            str = c.a("requestor_client_permission_url", (String) null);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) ? "https://accounts.paytm.com/validate/requestorclient" : str;
    }

    public static String b() {
        String str = null;
        try {
            c.a();
            str = c.a("trust_login_url", (String) null);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) ? "https://accounts.paytm.com/oauth2/trustlogin" : str;
    }
}
