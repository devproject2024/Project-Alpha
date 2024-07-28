package net.one97.paytm.wallet.entity;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class CustomEditText extends AppCompatEditText {
    private OnCutCopyPasteListener mOnCutCopyPasteListener;

    public interface OnCutCopyPasteListener {
        void onCopy();

        void onCut();

        void onPaste();
    }

    public void setOnCutCopyPasteListener(OnCutCopyPasteListener onCutCopyPasteListener) {
        this.mOnCutCopyPasteListener = onCutCopyPasteListener;
    }

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTextContextMenuItem(int i2) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        switch (i2) {
            case 16908320:
                onCut();
                break;
            case 16908321:
                onCopy();
                break;
            case 16908322:
                onPaste();
                break;
        }
        return onTextContextMenuItem;
    }

    public void onCut() {
        OnCutCopyPasteListener onCutCopyPasteListener = this.mOnCutCopyPasteListener;
        if (onCutCopyPasteListener != null) {
            onCutCopyPasteListener.onCut();
        }
    }

    public void onCopy() {
        OnCutCopyPasteListener onCutCopyPasteListener = this.mOnCutCopyPasteListener;
        if (onCutCopyPasteListener != null) {
            onCutCopyPasteListener.onCopy();
        }
    }

    public void onPaste() {
        OnCutCopyPasteListener onCutCopyPasteListener = this.mOnCutCopyPasteListener;
        if (onCutCopyPasteListener != null) {
            onCutCopyPasteListener.onPaste();
        }
    }
}
