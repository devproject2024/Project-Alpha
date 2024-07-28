package net.one97.paytm.p2b.view.CustomView;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

public class P2BOTPPasteEditText extends EditText {

    /* renamed from: a  reason: collision with root package name */
    private a f12854a;

    public interface a {
        void a(String str);
    }

    public P2BOTPPasteEditText(Context context) {
        super(context);
    }

    public P2BOTPPasteEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public P2BOTPPasteEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTextContextMenuItem(int i2) {
        if (i2 != 16908322 && i2 != 16908337) {
            return super.onTextContextMenuItem(i2);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        new StringBuilder("OTPPasteEditText>>> ").append(clipboardManager.getPrimaryClip());
        if (this.f12854a == null || clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemCount() <= 0 || clipboardManager.getPrimaryClip().getItemAt(0) == null || TextUtils.isEmpty(clipboardManager.getPrimaryClip().getItemAt(0).getText()) || clipboardManager.getPrimaryClip().getItemAt(0).getText().length() != 6) {
            return true;
        }
        this.f12854a.a(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
        return true;
    }

    public void setOTPListner(a aVar) {
        this.f12854a = aVar;
    }
}
