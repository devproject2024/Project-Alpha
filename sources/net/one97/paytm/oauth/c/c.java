package net.one97.paytm.oauth.c;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class c extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    String f52595a;

    public void onClick(View view) {
    }

    public c(String str) {
        this.f52595a = str;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(0);
        textPaint.setUnderlineText(false);
    }
}
