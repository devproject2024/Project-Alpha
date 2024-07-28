package net.one97.paytm.paymentsBank.view;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

final class a implements MovementMethod {

    /* renamed from: a  reason: collision with root package name */
    private static a f19619a;

    public final boolean canSelectArbitrarily() {
        return false;
    }

    public final boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public final boolean onKeyDown(TextView textView, Spannable spannable, int i2, KeyEvent keyEvent) {
        return false;
    }

    public final boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        return false;
    }

    public final boolean onKeyUp(TextView textView, Spannable spannable, int i2, KeyEvent keyEvent) {
        return false;
    }

    public final void onTakeFocus(TextView textView, Spannable spannable, int i2) {
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public final boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public static MovementMethod a() {
        if (f19619a == null) {
            f19619a = new a();
        }
        return f19619a;
    }

    private a() {
    }

    public final void initialize(TextView textView, Spannable spannable) {
        Selection.setSelection(spannable, 0);
    }
}
