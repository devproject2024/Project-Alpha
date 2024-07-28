package com.business.merchant_payments.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public final class CircularImageView$manageElevation$1 extends ViewOutlineProvider {
    public final /* synthetic */ CircularImageView this$0;

    public CircularImageView$manageElevation$1(CircularImageView circularImageView) {
        this.this$0 = circularImageView;
    }

    public final void getOutline(View view, Outline outline) {
        if (outline != null) {
            outline.setOval(0, 0, this.this$0.heightCircle, this.this$0.heightCircle);
        }
    }
}
