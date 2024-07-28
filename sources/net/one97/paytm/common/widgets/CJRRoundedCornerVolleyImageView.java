package net.one97.paytm.common.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.paytm.network.b.h;

public class CJRRoundedCornerVolleyImageView extends ImageView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f49723a;

    /* renamed from: b  reason: collision with root package name */
    private String f49724b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f49725c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f49726d;

    /* renamed from: e  reason: collision with root package name */
    private ImageLoader f49727e;

    /* renamed from: f  reason: collision with root package name */
    private ImageLoader.ImageContainer f49728f;

    public interface a {
    }

    public CJRRoundedCornerVolleyImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CJRRoundedCornerVolleyImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRRoundedCornerVolleyImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public static void setImageUrl(CJRRoundedCornerVolleyImageView cJRRoundedCornerVolleyImageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            cJRRoundedCornerVolleyImageView.setImageUrl(str, h.INSTANCE.getImageLoader());
        }
    }

    public static void setImageUrl(CJRRoundedCornerVolleyImageView cJRRoundedCornerVolleyImageView, Drawable drawable) {
        if (drawable != null) {
            cJRRoundedCornerVolleyImageView.setImageDrawable(drawable);
        }
    }

    public void setResponseObserver(a aVar) {
        this.f49723a = aVar;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        this.f49724b = str;
        this.f49727e = imageLoader;
        a(false);
    }

    public void setDefaultImageResId(int i2) {
        this.f49725c = i2;
    }

    public void setErrorImageResId(int i2) {
        this.f49726d = i2;
    }

    private void a(final boolean z) {
        int width = getWidth();
        int height = getHeight();
        boolean z2 = getLayoutParams() != null && getLayoutParams().height == -2 && getLayoutParams().width == -2;
        if (width != 0 || height != 0 || z2) {
            if (TextUtils.isEmpty(this.f49724b)) {
                ImageLoader.ImageContainer imageContainer = this.f49728f;
                if (imageContainer != null) {
                    imageContainer.cancelRequest();
                    this.f49728f = null;
                }
                a();
                return;
            }
            ImageLoader.ImageContainer imageContainer2 = this.f49728f;
            if (!(imageContainer2 == null || imageContainer2.getRequestUrl() == null)) {
                if (!this.f49728f.getRequestUrl().equals(this.f49724b)) {
                    this.f49728f.cancelRequest();
                    a();
                } else {
                    return;
                }
            }
            this.f49728f = this.f49727e.get(this.f49724b, new ImageLoader.ImageListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    if (CJRRoundedCornerVolleyImageView.this.f49726d != 0) {
                        CJRRoundedCornerVolleyImageView cJRRoundedCornerVolleyImageView = CJRRoundedCornerVolleyImageView.this;
                        cJRRoundedCornerVolleyImageView.setImageResource(cJRRoundedCornerVolleyImageView.f49726d);
                    }
                    if (CJRRoundedCornerVolleyImageView.this.f49723a != null) {
                        a unused = CJRRoundedCornerVolleyImageView.this.f49723a;
                    }
                }

                public final void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
                    if (!z || !z) {
                        if (imageContainer.getBitmap() != null) {
                            CJRRoundedCornerVolleyImageView.this.setImageBitmap(CJRRoundedCornerVolleyImageView.a(imageContainer.getBitmap()));
                        } else if (CJRRoundedCornerVolleyImageView.this.f49725c != 0) {
                            CJRRoundedCornerVolleyImageView cJRRoundedCornerVolleyImageView = CJRRoundedCornerVolleyImageView.this;
                            cJRRoundedCornerVolleyImageView.setImageResource(cJRRoundedCornerVolleyImageView.f49725c);
                        }
                        if (CJRRoundedCornerVolleyImageView.this.f49723a != null && imageContainer.getBitmap() != null) {
                            a unused = CJRRoundedCornerVolleyImageView.this.f49723a;
                            return;
                        }
                        return;
                    }
                    CJRRoundedCornerVolleyImageView.this.post(new Runnable() {
                        public final void run() {
                            AnonymousClass1.this.onResponse(imageContainer, false);
                        }
                    });
                }
            });
        }
    }

    private void a() {
        int i2 = this.f49725c;
        if (i2 != 0) {
            setImageResource(i2);
        } else {
            setImageBitmap((Bitmap) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        a(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.f49728f;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap((Bitmap) null);
            this.f49728f = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    static /* synthetic */ Bitmap a(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
        Paint paint2 = paint;
        canvas.drawRect(0.0f, (float) (bitmap.getHeight() / 2), (float) (bitmap.getWidth() / 2), (float) bitmap.getHeight(), paint2);
        canvas.drawRect((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2), (float) bitmap.getWidth(), (float) bitmap.getHeight(), paint2);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }
}
