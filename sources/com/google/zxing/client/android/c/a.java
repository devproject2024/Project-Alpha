package com.google.zxing.client.android.c;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import com.google.zxing.client.a.d;
import com.google.zxing.client.a.q;
import com.google.zxing.client.android.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a extends g {

    /* renamed from: i  reason: collision with root package name */
    private static final DateFormat[] f40168i;
    private static final int[] j = {R.string.button_add_contact, R.string.button_show_map, R.string.button_dial, R.string.button_email};
    private final boolean[] k;
    private int l;

    static {
        DateFormat[] dateFormatArr = {new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH), new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)};
        f40168i = dateFormatArr;
        for (int i2 = 0; i2 < 4; i2++) {
            dateFormatArr[i2].setLenient(false);
        }
    }

    public a(Activity activity, q qVar) {
        super(activity, qVar);
        d dVar = (d) qVar;
        String[] strArr = dVar.j;
        boolean z = strArr != null && strArr.length > 0 && strArr[0] != null && !strArr[0].isEmpty();
        String[] strArr2 = dVar.f40034d;
        boolean z2 = strArr2 != null && strArr2.length > 0;
        String[] strArr3 = dVar.f40036f;
        boolean z3 = strArr3 != null && strArr3.length > 0;
        this.k = new boolean[4];
        boolean[] zArr = this.k;
        zArr[0] = true;
        zArr[1] = z;
        zArr[2] = z2;
        zArr[3] = z3;
        this.l = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            if (this.k[i2]) {
                this.l++;
            }
        }
    }

    private static Date a(String str) {
        DateFormat[] dateFormatArr = f40168i;
        int i2 = 0;
        while (i2 < dateFormatArr.length) {
            try {
                return dateFormatArr[i2].parse(str);
            } catch (ParseException unused) {
                i2++;
            }
        }
        return null;
    }

    public final CharSequence a() {
        Date a2;
        d dVar = (d) this.f40181g;
        StringBuilder sb = new StringBuilder(100);
        q.a(dVar.f40031a, sb);
        int length = sb.length();
        String str = dVar.f40033c;
        if (str != null && !str.isEmpty()) {
            sb.append("\n(");
            sb.append(str);
            sb.append(')');
        }
        q.a(dVar.n, sb);
        q.a(dVar.l, sb);
        q.a(dVar.j, sb);
        String[] strArr = dVar.f40034d;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null) {
                    q.a(PhoneNumberUtils.formatNumber(str2), sb);
                }
            }
        }
        q.a(dVar.f40036f, sb);
        q.a(dVar.o, sb);
        String str3 = dVar.m;
        if (!(str3 == null || str3.isEmpty() || (a2 = a(str3)) == null)) {
            q.a(DateFormat.getDateInstance(2).format(Long.valueOf(a2.getTime())), sb);
        }
        q.a(dVar.f40039i, sb);
        if (length <= 0) {
            return sb.toString();
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new StyleSpan(1), 0, length, 0);
        return spannableString;
    }
}
