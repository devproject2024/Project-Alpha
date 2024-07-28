package net.one97.paytm.paymentsBank.form15g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class PrefixEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    float f18392a = -1.0f;

    public PrefixEditText(Context context) {
        super(context);
    }

    public PrefixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrefixEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f18392a == -1.0f) {
            String str = (String) getTag();
            float[] fArr = new float[str.length()];
            getPaint().getTextWidths(str, fArr);
            float f2 = 0.0f;
            for (float f3 : fArr) {
                f2 += f3;
            }
            this.f18392a = (float) getCompoundPaddingLeft();
            setPadding((int) (f2 + this.f18392a), getPaddingRight(), getPaddingTop(), getPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText((String) getTag(), this.f18392a, (float) getLineBounds(0, (Rect) null), getPaint());
    }
}
