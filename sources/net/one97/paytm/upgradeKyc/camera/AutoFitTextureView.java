package net.one97.paytm.upgradeKyc.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import kotlin.g.b.k;

public final class AutoFitTextureView extends TextureView {

    /* renamed from: a  reason: collision with root package name */
    private int f65618a;

    /* renamed from: b  reason: collision with root package name */
    private int f65619b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoFitTextureView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoFitTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoFitTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
    }

    public final void setAspectRatio(int i2, int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.f65618a = i2;
        this.f65619b = i3;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i5 = this.f65618a;
        if (i5 == 0 || (i4 = this.f65619b) == 0) {
            setMeasuredDimension(size, size2);
        } else if (size < (size2 * i5) / i4) {
            setMeasuredDimension(size, (i4 * size) / i5);
        } else {
            setMeasuredDimension((i5 * size2) / i4, size2);
        }
    }
}
