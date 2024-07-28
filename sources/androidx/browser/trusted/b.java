package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class b {

    interface c {
        List<byte[]> a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException;

        boolean a(String str, PackageManager packageManager, d dVar) throws IOException, PackageManager.NameNotFoundException;
    }

    static List<byte[]> a(String str, PackageManager packageManager) {
        try {
            return a().a(str, packageManager);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    static boolean a(String str, PackageManager packageManager, d dVar) {
        try {
            return a().a(str, packageManager, dVar);
        } catch (PackageManager.NameNotFoundException | IOException unused) {
            return false;
        }
    }

    private static c a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new a();
        }
        return new C0029b();
    }

    static class a implements c {
        a() {
        }

        public final List<byte[]> a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            ArrayList arrayList = new ArrayList();
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo.hasMultipleSigners()) {
                for (Signature a2 : signingInfo.getApkContentsSigners()) {
                    arrayList.add(b.a(a2));
                }
            } else {
                arrayList.add(b.a(signingInfo.getSigningCertificateHistory()[0]));
            }
            return arrayList;
        }

        public final boolean a(String str, PackageManager packageManager, d dVar) throws PackageManager.NameNotFoundException, IOException {
            List<byte[]> a2 = a(str, packageManager);
            if (a2 == null) {
                return false;
            }
            if (a2.size() != 1) {
                return dVar.equals(d.a(str, a2));
            }
            dVar.a();
            if (dVar.f1939b == null) {
                throw new IllegalStateException();
            } else if (!dVar.f1939b.equals(str)) {
                return false;
            } else {
                dVar.a();
                if (dVar.f1940c != null) {
                    return packageManager.hasSigningCertificate(str, Arrays.copyOf(dVar.f1940c.get(0), dVar.f1940c.get(0).length), 1);
                }
                throw new IllegalStateException();
            }
        }
    }

    /* renamed from: androidx.browser.trusted.b$b  reason: collision with other inner class name */
    static class C0029b implements c {
        C0029b() {
        }

        public final List<byte[]> a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
            for (Signature a2 : packageInfo.signatures) {
                byte[] a3 = b.a(a2);
                if (a3 == null) {
                    return null;
                }
                arrayList.add(a3);
            }
            return arrayList;
        }

        public final boolean a(String str, PackageManager packageManager, d dVar) throws IOException, PackageManager.NameNotFoundException {
            List<byte[]> a2 = a(str, packageManager);
            if (a2 == null) {
                return false;
            }
            return dVar.equals(d.a(str, a2));
        }
    }

    static byte[] a(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
