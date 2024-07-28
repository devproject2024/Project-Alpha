package net.one97.paytm.recharge.common.widget;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.g.b.k;

public final class CJRInputFieldWithActionWidgetV8$showInlineMessage$spanNoUnderline$1 extends URLSpan {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CJRInputFieldWithActionWidgetV8 f61903a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SpannableStringBuilder f61904b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f61905c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CJRInputFieldWithActionWidgetV8$showInlineMessage$spanNoUnderline$1(CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8, SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        super(str2);
        this.f61903a = cJRInputFieldWithActionWidgetV8;
        this.f61904b = spannableStringBuilder;
        this.f61905c = str;
    }

    public final void updateDrawState(TextPaint textPaint) {
        k.c(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    public final void onClick(View view) {
        k.c(view, "widget");
        this.f61903a.getTxt_error().setMovementMethod((MovementMethod) null);
        this.f61903a.getTxt_error().setText(this.f61904b);
    }
}
