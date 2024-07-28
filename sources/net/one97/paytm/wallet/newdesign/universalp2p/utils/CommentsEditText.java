package net.one97.paytm.wallet.newdesign.universalp2p.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;

public class CommentsEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private a f71423a;

    public interface a {
        void a();
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
        a aVar;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && (aVar = this.f71423a) != null) {
            getText();
            aVar.a();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setOnEditTextImeBackListener(a aVar) {
        this.f71423a = aVar;
    }
}
