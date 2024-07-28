package com.paytm.contactsSdk.api.util;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;

public final class LinkExtensionKt {
    public static final void makeLinks(TextView textView, o<String, ? extends View.OnClickListener>... oVarArr) {
        k.c(textView, "$this$makeLinks");
        k.c(oVarArr, "links");
        SpannableString spannableString = new SpannableString(textView.getText());
        for (o<String, ? extends View.OnClickListener> oVar : oVarArr) {
            LinkExtensionKt$makeLinks$clickableSpan$1 linkExtensionKt$makeLinks$clickableSpan$1 = new LinkExtensionKt$makeLinks$clickableSpan$1(textView, oVar);
            int a2 = p.a((CharSequence) textView.getText().toString(), oVar.getFirst(), 0, false, 6);
            spannableString.setSpan(linkExtensionKt$makeLinks$clickableSpan$1, a2, oVar.getFirst().length() + a2, 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }
}
