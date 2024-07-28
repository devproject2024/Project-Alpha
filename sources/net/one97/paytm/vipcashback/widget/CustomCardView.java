package net.one97.paytm.vipcashback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.widget.CardView;
import kotlin.g.b.k;

public final class CustomCardView extends CardView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomCardView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
    }

    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        getMeasuredWidth();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) (((double) getMeasuredHeight()) * 0.75d), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }
}
