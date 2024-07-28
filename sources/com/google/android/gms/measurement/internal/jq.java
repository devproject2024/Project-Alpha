package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.d;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.jz;
import com.google.android.gms.internal.measurement.lw;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class jq extends fw {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f12284a = {"firebase_", "google_", "ga_"};

    /* renamed from: b  reason: collision with root package name */
    private SecureRandom f12285b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicLong f12286c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    private int f12287d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f12288e = null;

    jq(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                J_().f11831f.a("Utils falling back to Random for random id");
            }
        }
        this.f12286c.set(nextLong);
    }

    public final long c() {
        long andIncrement;
        long j;
        if (this.f12286c.get() == 0) {
            synchronized (this.f12286c) {
                long nextLong = new Random(System.nanoTime() ^ j().a()).nextLong();
                int i2 = this.f12287d + 1;
                this.f12287d = i2;
                j = nextLong + ((long) i2);
            }
            return j;
        }
        synchronized (this.f12286c) {
            this.f12286c.compareAndSet(-1, 1);
            andIncrement = this.f12286c.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom d() {
        h();
        if (this.f12285b == null) {
            this.f12285b = new SecureRandom();
        }
        return this.f12285b;
    }

    static boolean a(String str) {
        s.a(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Bundle a(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("source", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("medium", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            J_().f11831f.a("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    static boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, String str2) {
        if (str2 == null) {
            J_().f11830e.a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            J_().f11830e.a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                J_().f11830e.a("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    J_().f11830e.a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(String str, String str2) {
        if (str2 == null) {
            J_().f11830e.a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            J_().f11830e.a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        J_().f11830e.a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            J_().f11830e.a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            J_().f11830e.a("Name is required and can't be null. Type", str);
            return false;
        }
        s.a(str2);
        String[] strArr2 = f12284a;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr2[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            J_().f11830e.a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            s.a(strArr);
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z2 = false;
                    break;
                } else if (c(str2, strArr[i3])) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                J_().f11830e.a("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, int i2, String str2) {
        if (str2 == null) {
            J_().f11830e.a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i2) {
            return true;
        } else {
            J_().f11830e.a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(String str) {
        if (!b(AppConstants.NOTIFICATION_DETAILS.EVENT, str)) {
            return 2;
        }
        if (!a(AppConstants.NOTIFICATION_DETAILS.EVENT, fx.f12002a, str)) {
            return 13;
        }
        if (!a(AppConstants.NOTIFICATION_DETAILS.EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int c(String str) {
        if (!b("user property", str)) {
            return 6;
        }
        if (!a("user property", fz.f12004a, str)) {
            return 15;
        }
        if (!a("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    private final boolean a(String str, String str2, int i2, Object obj, boolean z) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.codePointCount(0, valueOf.length()) > i2) {
                    J_().f11833h.a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                    return false;
                }
            } else if ((obj instanceof Bundle) && z) {
                return true;
            } else {
                if ((obj instanceof Parcelable[]) && z) {
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (!(parcelable instanceof Bundle)) {
                            J_().f11833h.a("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof ArrayList) || !z) {
                    return false;
                } else {
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        if (!(obj2 instanceof Bundle)) {
                            J_().f11833h.a("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            jz.a();
            if (H_().d((String) null, o.aC) && !TextUtils.isEmpty(str3)) {
                return true;
            }
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(this.y.f11941a)) {
                    J_().f11830e.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                }
                return false;
            } else if (g(str2)) {
                return true;
            } else {
                J_().f11830e.a("Invalid admob_app_id. Analytics disabled.", dy.a(str2));
                return false;
            }
        } else if (g(str)) {
            return true;
        } else {
            if (TextUtils.isEmpty(this.y.f11941a)) {
                J_().f11830e.a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", dy.a(str));
            }
            return false;
        }
    }

    static boolean a(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private static boolean g(String str) {
        s.a(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private static Object a(int i2, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return a(String.valueOf(obj), i2, z);
            }
            return null;
        }
    }

    public static String a(String str, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i2) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.DOTS);
        }
        return null;
    }

    static Object a(String str, Object obj) {
        boolean equals = "_ev".equals(str);
        int i2 = UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        if (equals) {
            return a((int) UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, obj, true);
        }
        if (!e(str)) {
            i2 = 100;
        }
        return a(i2, obj, false);
    }

    static Bundle[] a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (a("event param", 40, r15) == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (a("event param", 40, r15) == false) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle a(java.lang.String r17, java.lang.String r18, android.os.Bundle r19, java.util.List<java.lang.String> r20, boolean r21, boolean r22) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            r8 = r19
            r9 = r20
            r10 = 0
            if (r8 == 0) goto L_0x0183
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>(r8)
            com.google.android.gms.measurement.internal.ke r0 = r16.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.o.aj
            boolean r0 = r0.d(r7, r1)
            if (r0 == 0) goto L_0x0026
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r19.keySet()
            r0.<init>(r1)
            goto L_0x002a
        L_0x0026:
            java.util.Set r0 = r19.keySet()
        L_0x002a:
            java.util.Iterator r12 = r0.iterator()
            r14 = 0
        L_0x002f:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0184
            java.lang.Object r0 = r12.next()
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            r5 = 40
            r0 = 3
            if (r9 == 0) goto L_0x004a
            boolean r1 = r9.contains(r15)
            if (r1 != 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r1 = 0
            goto L_0x0082
        L_0x004a:
            r1 = 14
            java.lang.String r2 = "event param"
            if (r21 == 0) goto L_0x0068
            boolean r3 = r6.a((java.lang.String) r2, (java.lang.String) r15)
            if (r3 != 0) goto L_0x0058
        L_0x0056:
            r3 = 3
            goto L_0x0069
        L_0x0058:
            boolean r3 = r6.a((java.lang.String) r2, (java.lang.String[]) r10, (java.lang.String) r15)
            if (r3 != 0) goto L_0x0061
            r3 = 14
            goto L_0x0069
        L_0x0061:
            boolean r3 = r6.a((java.lang.String) r2, (int) r5, (java.lang.String) r15)
            if (r3 != 0) goto L_0x0068
            goto L_0x0056
        L_0x0068:
            r3 = 0
        L_0x0069:
            if (r3 != 0) goto L_0x0081
            boolean r3 = r6.b((java.lang.String) r2, (java.lang.String) r15)
            if (r3 != 0) goto L_0x0073
        L_0x0071:
            r1 = 3
            goto L_0x0082
        L_0x0073:
            boolean r3 = r6.a((java.lang.String) r2, (java.lang.String[]) r10, (java.lang.String) r15)
            if (r3 != 0) goto L_0x007a
            goto L_0x0082
        L_0x007a:
            boolean r1 = r6.a((java.lang.String) r2, (int) r5, (java.lang.String) r15)
            if (r1 != 0) goto L_0x0048
            goto L_0x0071
        L_0x0081:
            r1 = r3
        L_0x0082:
            java.lang.String r4 = "_ev"
            r3 = 1
            if (r1 == 0) goto L_0x009e
            boolean r2 = a((android.os.Bundle) r11, (int) r1)
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = a((java.lang.String) r15, (int) r5, (boolean) r3)
            r11.putString(r4, r2)
            if (r1 != r0) goto L_0x0099
            a((android.os.Bundle) r11, (java.lang.Object) r15)
        L_0x0099:
            r11.remove(r15)
            goto L_0x013e
        L_0x009e:
            java.lang.Object r2 = r8.get(r15)
            r16.h()
            if (r22 == 0) goto L_0x00db
            boolean r0 = r2 instanceof android.os.Parcelable[]
            if (r0 == 0) goto L_0x00b0
            r0 = r2
            android.os.Parcelable[] r0 = (android.os.Parcelable[]) r0
            int r0 = r0.length
            goto L_0x00bb
        L_0x00b0:
            boolean r0 = r2 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x00d2
            r0 = r2
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
        L_0x00bb:
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 <= r1) goto L_0x00d2
            com.google.android.gms.measurement.internal.dy r1 = r16.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.f11833h
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "param"
            java.lang.String r5 = "Parameter array is too long; discarded. Value kind, name, array length"
            r1.a(r5, r3, r15, r0)
            r0 = 0
            goto L_0x00d3
        L_0x00d2:
            r0 = 1
        L_0x00d3:
            if (r0 != 0) goto L_0x00db
            r0 = 17
            r13 = r4
            r10 = 40
            goto L_0x011e
        L_0x00db:
            com.google.android.gms.measurement.internal.ke r0 = r16.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.o.N
            boolean r0 = r0.d(r7, r1)
            if (r0 == 0) goto L_0x00ed
            boolean r0 = e(r18)
            if (r0 != 0) goto L_0x00f3
        L_0x00ed:
            boolean r0 = e(r15)
            if (r0 == 0) goto L_0x0107
        L_0x00f3:
            r3 = 256(0x100, float:3.59E-43)
            java.lang.String r1 = "param"
            r0 = r16
            r5 = r2
            r2 = r15
            r10 = 1
            r13 = r4
            r4 = r5
            r10 = 40
            r5 = r22
            boolean r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (int) r3, (java.lang.Object) r4, (boolean) r5)
            goto L_0x0119
        L_0x0107:
            r5 = r2
            r13 = r4
            r10 = 40
            r3 = 100
            java.lang.String r1 = "param"
            r0 = r16
            r2 = r15
            r4 = r5
            r5 = r22
            boolean r0 = r0.a((java.lang.String) r1, (java.lang.String) r2, (int) r3, (java.lang.Object) r4, (boolean) r5)
        L_0x0119:
            if (r0 == 0) goto L_0x011d
            r0 = 0
            goto L_0x011e
        L_0x011d:
            r0 = 4
        L_0x011e:
            if (r0 == 0) goto L_0x0141
            boolean r1 = r13.equals(r15)
            if (r1 != 0) goto L_0x0141
            boolean r0 = a((android.os.Bundle) r11, (int) r0)
            if (r0 == 0) goto L_0x013b
            r0 = 1
            java.lang.String r0 = a((java.lang.String) r15, (int) r10, (boolean) r0)
            r11.putString(r13, r0)
            java.lang.Object r0 = r8.get(r15)
            a((android.os.Bundle) r11, (java.lang.Object) r0)
        L_0x013b:
            r11.remove(r15)
        L_0x013e:
            r10 = 0
            goto L_0x002f
        L_0x0141:
            boolean r0 = a((java.lang.String) r15)
            if (r0 == 0) goto L_0x0180
            int r14 = r14 + 1
            r0 = 25
            if (r14 <= r0) goto L_0x0180
            r0 = 48
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Event can't contain more than 25 params"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.measurement.internal.dy r1 = r16.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.f11830e
            com.google.android.gms.measurement.internal.dw r2 = r16.l()
            r3 = r18
            java.lang.String r2 = r2.a((java.lang.String) r3)
            com.google.android.gms.measurement.internal.dw r4 = r16.l()
            java.lang.String r4 = r4.a((android.os.Bundle) r8)
            r1.a(r0, r2, r4)
            r0 = 5
            a((android.os.Bundle) r11, (int) r0)
            r11.remove(r15)
            goto L_0x013e
        L_0x0180:
            r3 = r18
            goto L_0x013e
        L_0x0183:
            r11 = 0
        L_0x0184:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jq.a(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    private static boolean a(Bundle bundle, int i2) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i2);
        return true;
    }

    private static void a(Bundle bundle, Object obj) {
        s.a(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private static int h(String str) {
        if ("_ldl".equals(str)) {
            return EmiUtil.EMI_PLAN_REQUEST_CODE;
        }
        if ("_id".equals(str)) {
            return UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        }
        return 36;
    }

    /* access modifiers changed from: package-private */
    public final int b(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = a("user property referrer", str, h(str), obj, false);
        } else {
            z = a("user property", str, h(str), obj, false);
        }
        return z ? 0 : 7;
    }

    static Object c(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return a(h(str), obj, true);
        }
        return a(h(str), obj, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                J_().f11833h.a("Not putting event parameter. Invalid value type. name, type", l().b(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void a(int i2, String str, String str2, int i3) {
        b(i2, str, str2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, String str, String str2, int i3) {
        Bundle bundle = new Bundle();
        a(bundle, i2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            bundle.putString(str, str2);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", (long) i3);
        }
        this.y.d().a("auto", "_err", bundle);
    }

    static MessageDigest e() {
        int i2 = 0;
        while (i2 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i2++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    static long a(byte[] bArr) {
        s.a(bArr);
        int i2 = 0;
        s.a(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i2;
            i2 += 8;
            length--;
        }
        return j;
    }

    static boolean a(Context context) {
        s.a(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return b(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return b(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    private static boolean b(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d(String str) {
        h();
        if (c.a(k()).a(str) == 0) {
            return true;
        }
        J_().j.a("Permission not granted", str);
        return false;
    }

    static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean c(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    static boolean a(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    static boolean a(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* access modifiers changed from: package-private */
    public final boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return H_().r().equals(str);
    }

    /* access modifiers changed from: package-private */
    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a2 = a(str, bundle.get(str));
                if (a2 == null) {
                    J_().f11833h.a("Param value can't be null", l().b(str));
                } else {
                    a(bundle2, str, a2);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final zzan a(String str, String str2, Bundle bundle, String str3, long j) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (b(str2) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            return new zzan(str2, new zzam(a(a(str, str2, bundle3, Collections.singletonList("_o"), false, false))), str3, j);
        }
        J_().f11828c.a("Invalid conditional property event name", l().c(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final long a(Context context, String str) {
        h();
        s.a(context);
        s.a(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest e2 = e();
        if (e2 == null) {
            J_().f11828c.a("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!c(context, str)) {
                    PackageInfo b2 = c.a(context).b(k().getPackageName(), 64);
                    if (b2.signatures != null && b2.signatures.length > 0) {
                        return a(e2.digest(b2.signatures[0].toByteArray()));
                    }
                    J_().f11831f.a("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                J_().f11828c.a("Package name not found", e3);
            }
        }
        return 0;
    }

    private final boolean c(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo b2 = c.a(context).b(str, 64);
            if (b2 == null || b2.signatures == null || b2.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b2.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e2) {
            J_().f11828c.a("Error obtaining certificate", e2);
            return true;
        } catch (PackageManager.NameNotFoundException e3) {
            J_().f11828c.a("Package name not found", e3);
            return true;
        }
    }

    static byte[] a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        return bundle2;
    }

    public final int r() {
        if (this.f12288e == null) {
            d.b();
            this.f12288e = Integer.valueOf(d.d(k()) / 1000);
        }
        return this.f12288e.intValue();
    }

    public final int s() {
        return d.b().a(k(), (int) h.f8688b);
    }

    public static long a(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    public final String t() {
        byte[] bArr = new byte[16];
        d().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            J_().f11831f.a("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void a(lw lwVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.y.J_().f11831f.a("Error returning string value to wrapper", e2);
        }
    }

    public final void a(lw lwVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.y.J_().f11831f.a("Error returning long value to wrapper", e2);
        }
    }

    public final void a(lw lwVar, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.y.J_().f11831f.a("Error returning int value to wrapper", e2);
        }
    }

    public final void a(lw lwVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.y.J_().f11831f.a("Error returning byte array to wrapper", e2);
        }
    }

    public final void a(lw lwVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.y.J_().f11831f.a("Error returning boolean value to wrapper", e2);
        }
    }

    public final void a(lw lwVar, Bundle bundle) {
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.y.J_().f11831f.a("Error returning bundle value to wrapper", e2);
        }
    }

    public static Bundle a(List<zzkl> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkl next : list) {
            if (next.f12375d != null) {
                bundle.putString(next.f12372a, next.f12375d);
            } else if (next.f12374c != null) {
                bundle.putLong(next.f12372a, next.f12374c.longValue());
            } else if (next.f12377f != null) {
                bundle.putDouble(next.f12372a, next.f12377f.doubleValue());
            }
        }
        return bundle;
    }

    public final void a(lw lwVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.y.J_().f11831f.a("Error returning bundle list to wrapper", e2);
        }
    }

    public static ArrayList<Bundle> b(List<zzv> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzv next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.f12389a);
            bundle.putString("origin", next.f12390b);
            bundle.putLong("creation_timestamp", next.f12392d);
            bundle.putString("name", next.f12391c.f12372a);
            fy.a(bundle, next.f12391c.a());
            bundle.putBoolean("active", next.f12393e);
            if (next.f12394f != null) {
                bundle.putString("trigger_event_name", next.f12394f);
            }
            if (next.f12395g != null) {
                bundle.putString("timed_out_event_name", next.f12395g.f12368a);
                if (next.f12395g.f12369b != null) {
                    bundle.putBundle("timed_out_event_params", next.f12395g.f12369b.a());
                }
            }
            bundle.putLong("trigger_timeout", next.f12396h);
            if (next.f12397i != null) {
                bundle.putString("triggered_event_name", next.f12397i.f12368a);
                if (next.f12397i.f12369b != null) {
                    bundle.putBundle("triggered_event_params", next.f12397i.f12369b.a());
                }
            }
            bundle.putLong("triggered_timestamp", next.f12391c.f12373b);
            bundle.putLong("time_to_live", next.j);
            if (next.k != null) {
                bundle.putString("expired_event_name", next.k.f12368a);
                if (next.k.f12369b != null) {
                    bundle.putBundle("expired_event_params", next.k.f12369b.a());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final URL a(String str, String str2, long j) {
        try {
            s.a(str2);
            s.a(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{19000L, Integer.valueOf(r())}), str2, str, Long.valueOf(j)});
            if (str.equals(H_().a("debug.deferred.deeplink", ""))) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            J_().f11828c.a("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, double d2) {
        try {
            SharedPreferences.Editor edit = k().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return edit.commit();
        } catch (Exception e2) {
            J_().f11828c.a("Failed to persist Deferred Deep Link. exception", e2);
            return false;
        }
    }

    public final boolean u() {
        try {
            k().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }
}
