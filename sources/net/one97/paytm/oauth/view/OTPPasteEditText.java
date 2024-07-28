package net.one97.paytm.oauth.view;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

public class OTPPasteEditText extends EditText {

    /* renamed from: a  reason: collision with root package name */
    private a f56834a;

    public interface a {
        void a(String str);
    }

    public OTPPasteEditText(Context context) {
        super(context);
    }

    public OTPPasteEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OTPPasteEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTextContextMenuItem(int i2) {
        if (i2 != 16908322 && i2 != 16908337) {
            return super.onTextContextMenuItem(i2);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        new StringBuilder("OTPPasteEditText>>> ").append(clipboardManager.getPrimaryClip());
        if (this.f56834a == null || clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemCount() <= 0 || clipboardManager.getPrimaryClip().getItemAt(0) == null || TextUtils.isEmpty(clipboardManager.getPrimaryClip().getItemAt(0).getText()) || clipboardManager.getPrimaryClip().getItemAt(0).getText().length() != 6) {
            return true;
        }
        this.f56834a.a(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
        return true;
    }

    public void setOTPListner(a aVar) {
        this.f56834a = aVar;
    }
}
