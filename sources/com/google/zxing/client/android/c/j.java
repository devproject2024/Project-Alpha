package com.google.zxing.client.android.c;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.client.a.q;
import com.google.zxing.client.android.R;

public final class j extends g {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f40185i = {R.string.button_dial, R.string.button_add_contact};

    public j(Activity activity, q qVar) {
        super(activity, qVar);
    }

    public final CharSequence a() {
        return PhoneNumberUtils.formatNumber(this.f40181g.a().replace("\r", ""));
    }
}
