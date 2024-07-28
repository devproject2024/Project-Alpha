package net.one97.paytm.feed.utility;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class RoundCornersImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private float f35381a = 18.0f;

    /* renamed from: b  reason: collision with root package name */
    private Path f35382b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f35383c;

    public RoundCornersImageView(Context context) {
        super(context);
        a();
    }

    public RoundCornersImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RoundCornersImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f35382b = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f35383c = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        Path path = this.f35382b;
        RectF rectF = this.f35383c;
        float f2 = this.f35381a;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        canvas.clipPath(this.f35382b);
        super.onDraw(canvas);
    }
}
