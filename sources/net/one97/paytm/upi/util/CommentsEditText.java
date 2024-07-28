package net.one97.paytm.upi.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;

public class CommentsEditText extends AppCompatEditText {
    private EditTextImeBackListener mOnImeBack;

    public interface EditTextImeBackListener {
        void onImeBack(CommentsEditText commentsEditText, String str);
    }

    public CommentsEditText(Context context) {
        super(context);
    }

    public CommentsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommentsEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        EditTextImeBackListener editTextImeBackListener;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && (editTextImeBackListener = this.mOnImeBack) != null) {
            editTextImeBackListener.onImeBack(this, getText().toString());
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(EditTextImeBackListener editTextImeBackListener) {
        this.mOnImeBack = editTextImeBackListener;
    }
}
