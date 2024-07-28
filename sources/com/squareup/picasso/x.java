package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.squareup.picasso.w;

final class x extends BitmapDrawable {

    /* renamed from: e  reason: collision with root package name */
    private static final Paint f45467e = new Paint();

    /* renamed from: a  reason: collision with root package name */
    Drawable f45468a;

    /* renamed from: b  reason: collision with root package name */
    long f45469b;

    /* renamed from: c  reason: collision with root package name */
    boolean f45470c;

    /* renamed from: d  reason: collision with root package name */
    int f45471d = PriceRangeSeekBar.INVALID_POINTER_ID;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f45472f;

    /* renamed from: g  reason: collision with root package name */
    private final float f45473g;

    /* renamed from: h  reason: collision with root package name */
    private final w.d f45474h;

    static void a(ImageView imageView, Context context, Bitmap bitmap, w.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new x(context, bitmap, drawable, dVar, z, z2));
    }

    static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    private x(Context context, Bitmap bitmap, Drawable drawable, w.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f45472f = z2;
        this.f45473g = context.getResources().getDisplayMetrics().density;
        this.f45474h = dVar;
        if (dVar != w.d.MEMORY && !z) {
            this.f45468a = drawable;
            this.f45470c = true;
            this.f45469b = SystemClock.uptimeMillis();
        }
    }

    public final void draw(Canvas canvas) {
        if (!this.f45470c) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f45469b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f45470c = false;
                this.f45468a = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f45468a;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f45471d) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f45471d);
            }
        }
        if (this.f45472f) {
            f45467e.setColor(-1);
            canvas.drawPath(a((int) (this.f45473g * 16.0f)), f45467e);
            f45467e.setColor(this.f45474h.debugColor);
            canvas.drawPath(a((int) (this.f45473g * 15.0f)), f45467e);
        }
    }

    public final void setAlpha(int i2) {
        this.f45471d = i2;
        Drawable drawable = this.f45468a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
        super.setAlpha(i2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f45468a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f45468a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private static Path a(int i2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        float f2 = (float) (i2 + 0);
        path.lineTo(f2, 0.0f);
        path.lineTo(0.0f, f2);
        return path;
    }
}
