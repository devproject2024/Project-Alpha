package net.one97.paytm.payments.visascp.keygen;

import android.content.Context;
import java.sql.Timestamp;
import net.one97.paytm.payments.visascp.VisaSCPImpl;
import net.one97.paytm.payments.visascp.customAsync.CustomCallable;
import net.one97.paytm.payments.visascp.network.HawkEyeEvent;

public class KeyGeneratorCustomAsync implements CustomCallable<Boolean> {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static int f571 = 0;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static int f572 = 1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f573;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f574;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f575;

    /* renamed from: ˏ  reason: contains not printable characters */
    private VisaSCPImpl.KeyGenerationListener f576;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f577;

    public /* synthetic */ void onPostExecuteData(Object obj) {
        int i2 = f572;
        int i3 = (i2 & 6) + (i2 | 6);
        int i4 = (i3 & -1) + (i3 | -1);
        f571 = i4 % 128;
        char c2 = i4 % 2 == 0 ? '`' : '?';
        onPostExecuteData((Boolean) obj);
        if (c2 == '?') {
            Object obj2 = null;
            super.hashCode();
        }
    }

    public KeyGeneratorCustomAsync(Context context, String str, String str2, VisaSCPImpl.KeyGenerationListener keyGenerationListener) {
        this.f575 = str;
        this.f573 = str2;
        this.f576 = keyGenerationListener;
        this.f577 = context;
    }

    public Boolean call() {
        Boolean valueOf = Boolean.valueOf(new KeyGenerator().generateKeyPair(this.f577, this.f575));
        int i2 = f571;
        int i3 = ((i2 | 79) << 1) - (i2 ^ 79);
        f572 = i3 % 128;
        int i4 = i3 % 2;
        return valueOf;
    }

    public void onPostExecuteData(Boolean bool) {
        HawkEyeEvent hawkEyeEvent;
        long j;
        HawkEyeEvent hawkEyeEvent2;
        int i2 = f571;
        int i3 = i2 & 17;
        int i4 = (((i2 ^ 17) | i3) << 1) - ((i2 | 17) & (~i3));
        f572 = i4 % 128;
        char c2 = 29;
        if ((i4 % 2 != 0 ? '(' : 29) != '(') {
            j = System.currentTimeMillis() / this.f574;
            HawkEyeEvent instance = HawkEyeEvent.getInstance(this.f577);
            if ((bool == null ? (char) 28 : 12) != 28) {
                hawkEyeEvent2 = instance;
            } else {
                hawkEyeEvent = instance;
                this.f576.onKeyNotGenerated();
                hawkEyeEvent.logLocalEvent(true, "key-generation", this.f573, new Timestamp(this.f574).toString(), String.valueOf(j), 400, "Failed to generate key", this.f575, (String) null);
                int i5 = f572;
                int i6 = (i5 & 83) + (i5 | 83);
                f571 = i6 % 128;
                int i7 = i6 % 2;
            }
        } else {
            j = System.currentTimeMillis() - this.f574;
            hawkEyeEvent = HawkEyeEvent.getInstance(this.f577);
            if (bool != null) {
                c2 = '4';
            }
            if (c2 == '4') {
                hawkEyeEvent2 = hawkEyeEvent;
            }
            this.f576.onKeyNotGenerated();
            hawkEyeEvent.logLocalEvent(true, "key-generation", this.f573, new Timestamp(this.f574).toString(), String.valueOf(j), 400, "Failed to generate key", this.f575, (String) null);
            int i52 = f572;
            int i62 = (i52 & 83) + (i52 | 83);
            f571 = i62 % 128;
            int i72 = i62 % 2;
        }
        if (bool.booleanValue()) {
            this.f576.onKeyGenerated();
            hawkEyeEvent2.logLocalEvent(false, "key-generation", this.f573, new Timestamp(this.f574).toString(), String.valueOf(j), 200, "Key Generated Successfully", this.f575, (String) null);
            int i8 = (f571 + 66) - 1;
            f572 = i8 % 128;
            if (i8 % 2 == 0) {
                return;
            }
            return;
        }
        hawkEyeEvent = hawkEyeEvent2;
        this.f576.onKeyNotGenerated();
        hawkEyeEvent.logLocalEvent(true, "key-generation", this.f573, new Timestamp(this.f574).toString(), String.valueOf(j), 400, "Failed to generate key", this.f575, (String) null);
        int i522 = f572;
        int i622 = (i522 & 83) + (i522 | 83);
        f571 = i622 % 128;
        int i722 = i622 % 2;
    }

    public void onPreExecuteData() {
        int i2 = f572 + 21;
        f571 = i2 % 128;
        if ((i2 % 2 == 0 ? '`' : '$') != '$') {
            this.f574 = System.currentTimeMillis();
        } else {
            this.f574 = System.currentTimeMillis();
            Object obj = null;
            super.hashCode();
        }
        int i3 = f572;
        int i4 = (i3 ^ 9) + ((i3 & 9) << 1);
        f571 = i4 % 128;
        if (i4 % 2 != 0) {
        }
    }
}
