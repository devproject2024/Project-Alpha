package com.paytm.contactsSdk.api.util;

import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.paytm.contactsSdk.R;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;

public final class LinkExtensionKt$makeLinks$clickableSpan$1 extends ClickableSpan {
    final /* synthetic */ o $link;
    final /* synthetic */ TextView $this_makeLinks;

    LinkExtensionKt$makeLinks$clickableSpan$1(TextView textView, o oVar) {
        this.$this_makeLinks = textView;
        this.$link = oVar;
    }

    public final void updateDrawState(TextPaint textPaint) {
        k.c(textPaint, "textPaint");
        textPaint.setColor(this.$this_makeLinks.getResources().getColor(R.color.blue_contact_sdk));
        textPaint.setUnderlineText(false);
    }

    public final void onClick(View view) {
        k.c(view, "view");
        CharSequence text = ((TextView) view).getText();
        if (text != null) {
            Selection.setSelection((Spannable) text, 0);
            view.invalidate();
            ((View.OnClickListener) this.$link.getSecond()).onClick(view);
            return;
        }
        throw new u("null cannot be cast to non-null type android.text.Spannable");
    }
}
