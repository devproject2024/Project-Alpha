package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class CircularTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    int f76155a;

    /* renamed from: b  reason: collision with root package name */
    int f76156b;

    /* renamed from: c  reason: collision with root package name */
    private float f76157c;

    public CircularTextView(Context context) {
        super(context);
    }

    public CircularTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.f76156b);
        paint.setFlags(1);
        Paint paint2 = new Paint();
        paint2.setColor(this.f76155a);
        paint2.setFlags(1);
        int height = getHeight();
        int width = getWidth();
        if (height <= width) {
            height = width;
        }
        setHeight(height);
        setWidth(height);
        float f2 = (float) (height / 2);
        canvas.drawCircle(f2, f2, f2, paint2);
        canvas.drawCircle(f2, f2, f2 - this.f76157c, paint);
        super.draw(canvas);
    }

    public void setStrokeWidth(int i2) {
        this.f76157c = ((float) i2) * getContext().getResources().getDisplayMetrics().density;
    }

    public void setStrokeColor(String str) {
        this.f76155a = Color.parseColor(str);
    }

    public void setSolidColor(String str) {
        this.f76156b = Color.parseColor(str);
    }

    public void setBackgroundColor(int i2) {
        this.f76156b = i2;
    }
}
