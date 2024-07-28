package net.one97.paytm.wallet.dialog.tooltip;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;

public final class a extends ColorDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f70326a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final int f70327b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Path f70328c;

    /* renamed from: d  reason: collision with root package name */
    private final int f70329d;

    a(int i2, int i3) {
        this.f70326a.setColor(i2);
        this.f70329d = i3;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    private synchronized void a(Rect rect) {
        this.f70328c = new Path();
        int i2 = this.f70329d;
        if (i2 == 0) {
            this.f70328c.moveTo((float) rect.width(), (float) rect.height());
            this.f70328c.lineTo(0.0f, (float) (rect.height() / 2));
            this.f70328c.lineTo((float) rect.width(), 0.0f);
            this.f70328c.lineTo((float) rect.width(), (float) rect.height());
        } else if (i2 == 1) {
            this.f70328c.moveTo(0.0f, (float) rect.height());
            this.f70328c.lineTo((float) (rect.width() / 2), 0.0f);
            this.f70328c.lineTo((float) rect.width(), (float) rect.height());
            this.f70328c.lineTo(0.0f, (float) rect.height());
        } else if (i2 == 2) {
            this.f70328c.moveTo(0.0f, 0.0f);
            this.f70328c.lineTo((float) rect.width(), (float) (rect.height() / 2));
            this.f70328c.lineTo(0.0f, (float) rect.height());
            this.f70328c.lineTo(0.0f, 0.0f);
        } else if (i2 == 3) {
            this.f70328c.moveTo(0.0f, 0.0f);
            this.f70328c.lineTo((float) (rect.width() / 2), (float) rect.height());
            this.f70328c.lineTo((float) rect.width(), 0.0f);
            this.f70328c.lineTo(0.0f, 0.0f);
        }
        this.f70328c.close();
    }

    public final void draw(Canvas canvas) {
        canvas.drawColor(this.f70327b);
        if (this.f70328c == null) {
            a(getBounds());
        }
        canvas.drawPath(this.f70328c, this.f70326a);
    }

    public final void setAlpha(int i2) {
        this.f70326a.setAlpha(i2);
    }

    public final void setColor(int i2) {
        this.f70326a.setColor(i2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f70326a.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        if (this.f70326a.getColorFilter() != null) {
            return -3;
        }
        int color = this.f70326a.getColor() >>> 24;
        if (color == 0) {
            return -2;
        }
        if (color != 255) {
            return -3;
        }
        return -1;
    }
}
