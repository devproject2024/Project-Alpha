package net.one97.paytm.utils.c;

import android.graphics.Typeface;
import android.widget.TextView;
import kotlin.g.b.k;

public final class a {
    public static final void a(TextView textView, boolean z) {
        k.c(textView, "$this$setTextStyleBoldOrNormal");
        if (z) {
            textView.setTypeface(textView.getTypeface(), 1);
        } else {
            textView.setTypeface((Typeface) null, 0);
        }
    }
}
