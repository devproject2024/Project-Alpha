package com.google.zxing.client.android.c;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.client.a.q;
import com.google.zxing.client.a.w;
import com.google.zxing.client.android.R;

public final class i extends g {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f40184i = {R.string.button_sms, R.string.button_mms};

    public i(Activity activity, q qVar) {
        super(activity, qVar);
    }

    public final CharSequence a() {
        w wVar = (w) this.f40181g;
        String[] strArr = wVar.f40077a;
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = PhoneNumberUtils.formatNumber(strArr[i2]);
        }
        StringBuilder sb = new StringBuilder(50);
        q.a(strArr2, sb);
        q.a(wVar.f40078b, sb);
        q.a(wVar.f40079c, sb);
        return sb.toString();
    }
}
