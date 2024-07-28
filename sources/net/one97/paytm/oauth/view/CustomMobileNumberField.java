package net.one97.paytm.oauth.view;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class CustomMobileNumberField extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private final String f56825a = "^[0-9]{1,10}$";

    public CustomMobileNumberField(Context context) {
        super(context);
    }

    public CustomMobileNumberField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomMobileNumberField(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTextContextMenuItem(int i2) {
        if (i2 != 16908322 && i2 != 16908337) {
            return super.onTextContextMenuItem(i2);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemCount() <= 0 || clipboardManager.getPrimaryClip().getItemAt(0) == null || TextUtils.isEmpty(clipboardManager.getPrimaryClip().getItemAt(0).getText())) {
            return true;
        }
        String charSequence = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
        if (!charSequence.matches("^[0-9]{1,10}$")) {
            return true;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("+91 ".concat(String.valueOf(charSequence)));
        spannableStringBuilder.setSpan(new StyleSpan(0), 0, charSequence.length(), 18);
        setText(spannableStringBuilder);
        setSelection(spannableStringBuilder.length());
        return true;
    }
}
