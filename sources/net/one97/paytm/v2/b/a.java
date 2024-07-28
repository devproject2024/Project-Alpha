package net.one97.paytm.v2.b;

import android.widget.TextView;
import kotlin.g.b.k;

public final class a {
    public static final void a(TextView textView, String str) {
        k.c(textView, "receiver$0");
        if (str != null) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                return;
            }
        }
        textView.setVisibility(8);
    }
}
