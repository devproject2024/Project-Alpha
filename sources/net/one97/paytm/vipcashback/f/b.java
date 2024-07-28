package net.one97.paytm.vipcashback.f;

import android.text.TextUtils;
import android.widget.TextView;
import kotlin.g.b.k;

public final class b {
    public static final void a(TextView textView) {
        k.c(textView, "receiver$0");
        textView.setMinLines(0);
        textView.setMaxLines(Integer.MAX_VALUE);
        textView.setEllipsize((TextUtils.TruncateAt) null);
    }

    public static final void b(TextView textView) {
        k.c(textView, "receiver$0");
        textView.setMinLines(2);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }
}
