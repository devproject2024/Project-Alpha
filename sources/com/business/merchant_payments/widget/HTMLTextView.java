package com.business.merchant_payments.widget;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import com.business.common_module.view.widget.CustomTextView;

public class HTMLTextView extends CustomTextView {
    public OnUrlClickListener mUrlClickListener;

    public interface OnUrlClickListener {
        void onUrlClick(String str, String str2);
    }

    public void setUrlClickListener(OnUrlClickListener onUrlClickListener) {
        this.mUrlClickListener = onUrlClickListener;
    }

    public HTMLTextView(Context context) {
        super(context);
    }

    public HTMLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HTMLTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void makeLinkClickable(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
        int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
        final URLSpan uRLSpan2 = uRLSpan;
        final SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        final int i2 = spanStart;
        final int i3 = spanEnd;
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                if (HTMLTextView.this.mUrlClickListener != null) {
                    HTMLTextView.this.mUrlClickListener.onUrlClick(uRLSpan2.getURL(), spannableStringBuilder2.toString().substring(i2, i3));
                }
            }
        }, spanStart, spanEnd, spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    public void setText(String str) {
        Spanned fromHtml = Html.fromHtml(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan makeLinkClickable : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            makeLinkClickable(spannableStringBuilder, makeLinkClickable);
        }
        setText(spannableStringBuilder);
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
