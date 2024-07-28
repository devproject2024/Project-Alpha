package net.one97.paytm.o2o.movies.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;

public class CJRBackPressHandledEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private a f74982a;

    public interface a {
        void a(KeyEvent keyEvent);
    }

    public CJRBackPressHandledEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        try {
            this.f74982a = (a) context;
        } catch (Exception unused) {
        }
    }

    public CJRBackPressHandledEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRBackPressHandledEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public void setOnKeyPreImeListener(a aVar) {
        this.f74982a = aVar;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        a aVar = this.f74982a;
        if (aVar != null) {
            aVar.a(keyEvent);
        }
        super.onKeyPreIme(i2, keyEvent);
        return true;
    }
}
