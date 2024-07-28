package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

public class PasscodeEditText extends EditText {
    public PasscodeEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public PasscodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PasscodeEditText(Context context) {
        super(context);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        return new a(onCreateInputConnection);
    }

    class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection) {
            super(inputConnection, true);
        }

        public final boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                keyEvent.getKeyCode();
            }
            return super.sendKeyEvent(keyEvent);
        }

        public final boolean deleteSurroundingText(int i2, int i3) {
            if (i2 == 1 && i3 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(i2, i3);
        }
    }
}
