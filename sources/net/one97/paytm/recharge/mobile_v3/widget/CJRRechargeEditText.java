package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.g.b.k;
import net.one97.paytm.recharge.mobile_v3.d.b;

public final class CJRRechargeEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private b f63966a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRRechargeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRRechargeEditText(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar = this.f63966a;
        if (bVar != null) {
            if (bVar == null) {
                k.a();
            }
            bVar.a("dispatch.touch.event", motionEvent);
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void setOnKeyUpDownListener(b bVar) {
        k.c(bVar, "onKeyListener");
        this.f63966a = bVar;
    }
}
