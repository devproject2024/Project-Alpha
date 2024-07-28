package net.one97.paytm.newaddmoney.utils;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;

public final class c {
    public static final void a(TextView textView, String str) {
        k.c(textView, "receiver$0");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    public static final void a(TextView textView, boolean z) {
        k.c(textView, "receiver$0");
        if (z) {
            textView.setTypeface(textView.getTypeface(), 1);
        } else {
            textView.setTypeface((Typeface) null, 0);
        }
    }

    public static final void a(View view, boolean z) {
        k.c(view, "receiver$0");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
