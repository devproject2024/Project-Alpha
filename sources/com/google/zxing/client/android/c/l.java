package com.google.zxing.client.android.c;

import android.app.Activity;
import com.google.zxing.client.a.ac;
import com.google.zxing.client.a.q;
import com.google.zxing.client.android.R;
import java.util.Locale;

public final class l extends g {

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f40187i = {"otpauth:"};
    private static final int[] j = {R.string.button_open_browser, R.string.button_share_by_email, R.string.button_share_by_sms, R.string.button_search_book_contents};

    public l(Activity activity, q qVar) {
        super(activity, qVar);
    }

    public final boolean b() {
        String lowerCase = ((ac) this.f40181g).f39999a.toLowerCase(Locale.ENGLISH);
        for (String startsWith : f40187i) {
            if (lowerCase.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }
}
