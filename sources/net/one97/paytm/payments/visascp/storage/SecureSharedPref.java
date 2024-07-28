package net.one97.paytm.payments.visascp.storage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class SecureSharedPref {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f644 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f645;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static SecureSharedPref f646;

    /* renamed from: ˊ  reason: contains not printable characters */
    private SharedPreferences f647;

    /* renamed from: ˎ  reason: contains not printable characters */
    private SharedPreferences.Editor f648 = this.f647.edit();

    private SecureSharedPref(Context context) {
        this.f647 = context.getSharedPreferences(VisaSCPConstants.VISA_SHARED_PREF_NAME, 0);
    }

    public static SecureSharedPref getInstance(Context context) {
        int i2 = f644;
        int i3 = i2 & 123;
        int i4 = ((((i2 ^ 123) | i3) << 1) - (~(-((i2 | 123) & (~i3))))) - 1;
        f645 = i4 % 128;
        int i5 = i4 % 2;
        if (f646 == null) {
            f646 = new SecureSharedPref(context);
            int i6 = f644;
            int i7 = i6 & 41;
            int i8 = (i6 ^ 41) | i7;
            int i9 = ((i7 | i8) << 1) - (i8 ^ i7);
            f645 = i9 % 128;
            int i10 = i9 % 2;
        }
        SecureSharedPref secureSharedPref = f646;
        int i11 = f645;
        int i12 = i11 ^ 105;
        int i13 = ((((i11 & 105) | i12) << 1) - (~(-i12))) - 1;
        f644 = i13 % 128;
        int i14 = i13 % 2;
        return secureSharedPref;
    }

    public void saveData(Context context, String str, String str2) {
        int i2 = (f644 + 53) - 1;
        int i3 = ((i2 | -1) << 1) - (~i2);
        f645 = i3 % 128;
        int i4 = i3 % 2;
        if (!(this.f648 != null)) {
            int i5 = f645;
            int i6 = ((i5 ^ 39) | (i5 & 39)) << 1;
            int i7 = -(((~i5) & 39) | (i5 & -40));
            int i8 = (i6 & i7) + (i7 | i6);
            f644 = i8 % 128;
            if (i8 % 2 == 0) {
            }
            getInstance(context);
        }
        this.f648.putString(str, str2);
        this.f648.apply();
        int i9 = f645;
        int i10 = (i9 & 124) + (i9 | 124);
        int i11 = (i10 & -1) + (i10 | -1);
        f644 = i11 % 128;
        int i12 = i11 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if ((r5.f648 != null ? 'T' : 'U') != 'U') goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r2 != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveDataSynchronously(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            int r0 = f645
            int r0 = r0 + 10
            r1 = 1
            int r0 = r0 - r1
            int r2 = r0 % 128
            f644 = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L_0x0011
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            r3 = 55
            if (r0 == r1) goto L_0x0024
            android.content.SharedPreferences$Editor r0 = r5.f648
            r2 = 85
            if (r0 == 0) goto L_0x001f
            r0 = 84
            goto L_0x0021
        L_0x001f:
            r0 = 85
        L_0x0021:
            if (r0 == r2) goto L_0x0030
            goto L_0x0045
        L_0x0024:
            android.content.SharedPreferences$Editor r0 = r5.f648
            r4 = 0
            super.hashCode()     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x002d
            r2 = 1
        L_0x002d:
            if (r2 == 0) goto L_0x0030
            goto L_0x0045
        L_0x0030:
            getInstance(r6)
            int r6 = f644
            int r6 = r6 + 100
            int r6 = r6 - r1
            int r0 = r6 % 128
            f645 = r0
            int r6 = r6 % 2
            r0 = 7
            if (r6 != 0) goto L_0x0043
            r6 = 7
            goto L_0x0045
        L_0x0043:
            r6 = 55
        L_0x0045:
            android.content.SharedPreferences$Editor r6 = r5.f648
            r6.putString(r7, r8)
            android.content.SharedPreferences$Editor r6 = r5.f648
            boolean r6 = r6.commit()
            int r7 = f644
            r8 = r7 ^ 55
            r0 = r7 & 55
            r8 = r8 | r0
            int r8 = r8 << r1
            r0 = r7 & -56
            int r7 = ~r7
            r7 = r7 & r3
            r7 = r7 | r0
            int r8 = r8 - r7
            int r7 = r8 % 128
            f645 = r7
            int r8 = r8 % 2
            r7 = 42
            if (r8 != 0) goto L_0x006b
            r8 = 33
            goto L_0x006d
        L_0x006b:
            r8 = 42
        L_0x006d:
            return r6
        L_0x006e:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.storage.SecureSharedPref.saveDataSynchronously(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public void saveData(Context context, String str, long j) {
        int i2 = f644;
        int i3 = i2 & 59;
        int i4 = (i3 - (~(-(-((i2 ^ 59) | i3))))) - 1;
        f645 = i4 % 128;
        int i5 = i4 % 2;
        if (!(this.f648 != null)) {
            int i6 = f644 + 91;
            f645 = i6 % 128;
            int i7 = i6 % 2;
            getInstance(context);
            int i8 = f644;
            int i9 = i8 & 105;
            int i10 = (i8 | 105) & (~i9);
            int i11 = i9 << 1;
            int i12 = ((i10 | i11) << 1) - (i10 ^ i11);
            f645 = i12 % 128;
            if (i12 % 2 == 0) {
            }
        }
        this.f648.putLong(str, j);
        this.f648.apply();
        int i13 = f645;
        int i14 = ((i13 | 79) << 1) - (i13 ^ 79);
        f644 = i14 % 128;
        int i15 = i14 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r2 != 27) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r2 != '1') goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveDataSynchronously(android.content.Context r4, java.lang.String r5, long r6) {
        /*
            r3 = this;
            int r0 = f644
            r1 = r0 ^ 89
            r2 = r0 & 89
            r1 = r1 | r2
            int r1 = r1 << 1
            r2 = r0 & -90
            int r0 = ~r0
            r0 = r0 & 89
            r0 = r0 | r2
            int r0 = -r0
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f645 = r0
            int r2 = r2 % 2
            r0 = 66
            if (r2 != 0) goto L_0x0021
            r1 = 66
            goto L_0x0023
        L_0x0021:
            r1 = 46
        L_0x0023:
            r2 = 16
            if (r1 == r0) goto L_0x0038
            android.content.SharedPreferences$Editor r0 = r3.f648
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x0036 }
            r1 = 27
            if (r0 == 0) goto L_0x0033
            r2 = 27
        L_0x0033:
            if (r2 == r1) goto L_0x0064
            goto L_0x0042
        L_0x0036:
            r4 = move-exception
            throw r4
        L_0x0038:
            android.content.SharedPreferences$Editor r0 = r3.f648
            r1 = 49
            if (r0 == 0) goto L_0x0040
            r2 = 49
        L_0x0040:
            if (r2 == r1) goto L_0x0064
        L_0x0042:
            int r0 = f645
            r1 = r0 & 107(0x6b, float:1.5E-43)
            int r2 = ~r1
            r0 = r0 | 107(0x6b, float:1.5E-43)
            r0 = r0 & r2
            int r1 = r1 << 1
            r2 = r0 | r1
            int r2 = r2 << 1
            r0 = r0 ^ r1
            int r2 = r2 - r0
            int r0 = r2 % 128
            f644 = r0
            int r2 = r2 % 2
            r0 = 74
            if (r2 == 0) goto L_0x005f
            r1 = 50
            goto L_0x0061
        L_0x005f:
            r1 = 74
        L_0x0061:
            getInstance(r4)
        L_0x0064:
            android.content.SharedPreferences$Editor r4 = r3.f648
            r4.putLong(r5, r6)
            android.content.SharedPreferences$Editor r4 = r3.f648
            boolean r4 = r4.commit()
            int r5 = f645
            r6 = r5 & -30
            int r7 = ~r5
            r7 = r7 & 29
            r6 = r6 | r7
            r5 = r5 & 29
            int r5 = r5 << 1
            r7 = r6 | r5
            int r7 = r7 << 1
            r5 = r5 ^ r6
            int r7 = r7 - r5
            int r5 = r7 % 128
            f644 = r5
            int r7 = r7 % 2
            r5 = 93
            if (r7 == 0) goto L_0x008e
            r6 = 93
            goto L_0x0090
        L_0x008e:
            r6 = 82
        L_0x0090:
            if (r6 == r5) goto L_0x0092
        L_0x0092:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.storage.SecureSharedPref.saveDataSynchronously(android.content.Context, java.lang.String, long):boolean");
    }

    public String getData(Context context, String str) {
        int i2 = f644;
        int i3 = i2 & 35;
        int i4 = ((i2 ^ 35) | i3) << 1;
        int i5 = -((i2 | 35) & (~i3));
        int i6 = (i4 & i5) + (i5 | i4);
        f645 = i6 % 128;
        int i7 = i6 % 2;
        if ((this.f647 != null ? 27 : 'T') == 'T') {
            int i8 = f645;
            int i9 = i8 & 55;
            int i10 = -(-((i8 ^ 55) | i9));
            int i11 = (i9 ^ i10) + ((i10 & i9) << 1);
            f644 = i11 % 128;
            int i12 = i11 % 2;
            getInstance(context);
            int i13 = f644;
            int i14 = i13 ^ 111;
            int i15 = (((i13 & 111) | i14) << 1) - i14;
            f645 = i15 % 128;
            int i16 = i15 % 2;
        }
        String string = this.f647.getString(str, "");
        int i17 = f645;
        int i18 = i17 & 35;
        int i19 = (i17 | 35) & (~i18);
        int i20 = -(-(i18 << 1));
        int i21 = (i19 ^ i20) + ((i19 & i20) << 1);
        f644 = i21 % 128;
        if (i21 % 2 != 0) {
        }
        return string;
    }

    public long getLongData(Context context, String str) {
        int i2 = f644;
        int i3 = (i2 & 42) + (i2 | 42);
        boolean z = false;
        int i4 = (i3 - 0) - 1;
        f645 = i4 % 128;
        int i5 = i4 % 2;
        if (this.f647 != null) {
            z = true;
        }
        if (!z) {
            int i6 = f645;
            int i7 = (i6 & -58) | ((~i6) & 57);
            int i8 = (i6 & 57) << 1;
            int i9 = ((i7 | i8) << 1) - (i8 ^ i7);
            f644 = i9 % 128;
            int i10 = i9 % 2;
            getInstance(context);
            int i11 = f644;
            int i12 = (i11 ^ 9) + ((i11 & 9) << 1);
            f645 = i12 % 128;
            if (i12 % 2 == 0) {
            }
        }
        long j = this.f647.getLong(str, 0);
        int i13 = f645;
        int i14 = i13 & 59;
        int i15 = ((i13 ^ 59) | i14) << 1;
        int i16 = -((i13 | 59) & (~i14));
        int i17 = ((i15 | i16) << 1) - (i16 ^ i15);
        f644 = i17 % 128;
        int i18 = i17 % 2;
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r0 != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((r3.f647 != null ? '`' : '4') != '`') goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clearData(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            int r0 = f645
            r1 = r0 ^ 7
            r0 = r0 & 7
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            f644 = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 == 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x0025
            android.content.SharedPreferences r0 = r3.f647
            r1 = 96
            if (r0 == 0) goto L_0x0020
            r0 = 96
            goto L_0x0022
        L_0x0020:
            r0 = 52
        L_0x0022:
            if (r0 == r1) goto L_0x003f
            goto L_0x002d
        L_0x0025:
            android.content.SharedPreferences r1 = r3.f647
            if (r1 == 0) goto L_0x002a
            r0 = 1
        L_0x002a:
            if (r0 == 0) goto L_0x002d
            goto L_0x003f
        L_0x002d:
            getInstance(r4)
            int r4 = f645
            int r4 = r4 + 8
            r0 = r4 & -1
            r4 = r4 | -1
            int r0 = r0 + r4
            int r4 = r0 % 128
            f644 = r4
            int r0 = r0 % 2
        L_0x003f:
            android.content.SharedPreferences r4 = r3.f647
            android.content.SharedPreferences$Editor r4 = r4.edit()
            android.content.SharedPreferences$Editor r4 = r4.remove(r5)
            r4.apply()
            int r4 = f645
            r5 = r4 ^ 79
            r0 = r4 & 79
            r5 = r5 | r0
            int r5 = r5 << r2
            int r0 = ~r0
            r4 = r4 | 79
            r4 = r4 & r0
            int r4 = -r4
            r0 = r5 & r4
            r4 = r4 | r5
            int r0 = r0 + r4
            int r4 = r0 % 128
            f644 = r4
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.storage.SecureSharedPref.clearData(android.content.Context, java.lang.String):void");
    }

    public Map<String, ?> getAllPrefs(Context context) {
        int i2 = (f644 + 25) - 1;
        int i3 = (~i2) + ((i2 & -1) << 1);
        f645 = i3 % 128;
        int i4 = i3 % 2;
        if (!(this.f647 != null)) {
            int i5 = f645;
            int i6 = i5 & 117;
            int i7 = (i5 ^ 117) | i6;
            int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
            f644 = i8 % 128;
            if (i8 % 2 != 0) {
            }
            getInstance(context);
            int i9 = f644;
            int i10 = i9 & 15;
            int i11 = ((i9 ^ 15) | i10) << 1;
            int i12 = -((i9 | 15) & (~i10));
            int i13 = (i11 & i12) + (i12 | i11);
            f645 = i13 % 128;
            if (i13 % 2 == 0) {
            }
        }
        Map<String, ?> all = this.f647.getAll();
        int i14 = f644;
        int i15 = i14 & 89;
        int i16 = (((i14 ^ 89) | i15) << 1) - ((i14 | 89) & (~i15));
        f645 = i16 % 128;
        int i17 = i16 % 2;
        return all;
    }
}
