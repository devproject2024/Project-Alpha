package net.one97.paytm.common.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.paytm.network.b.h;

public class CJRVolleyImageView extends ImageView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f49734a;

    /* renamed from: b  reason: collision with root package name */
    private String f49735b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f49736c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f49737d;

    /* renamed from: e  reason: collision with root package name */
    private ImageLoader f49738e;

    /* renamed from: f  reason: collision with root package name */
    private ImageLoader.ImageContainer f49739f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Animation f49740g;

    public interface a {
    }

    public CJRVolleyImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CJRVolleyImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRVolleyImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f49740g = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        this.f49740g.setDuration((long) context.getResources().getInteger(R.integer.grid_page_image_fade_duration));
    }

    public static void setImageUrl(CJRVolleyImageView cJRVolleyImageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            cJRVolleyImageView.setImageUrl(str, h.INSTANCE.getImageLoader());
        }
    }

    public static void setImageUrl(CJRVolleyImageView cJRVolleyImageView, Drawable drawable) {
        if (drawable != null) {
            cJRVolleyImageView.setImageDrawable(drawable);
        }
    }

    public void setResponseObserver(a aVar) {
        this.f49734a = aVar;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        this.f49735b = str;
        this.f49738e = imageLoader;
        a(false);
    }

    public void setDefaultImageResId(int i2) {
        this.f49736c = i2;
    }

    public void setErrorImageResId(int i2) {
        this.f49737d = i2;
    }

    private void a(final boolean z) {
        int width = getWidth();
        int height = getHeight();
        boolean z2 = getLayoutParams() != null && getLayoutParams().height == -2 && getLayoutParams().width == -2;
        if (width != 0 || height != 0 || z2) {
            if (TextUtils.isEmpty(this.f49735b)) {
                ImageLoader.ImageContainer imageContainer = this.f49739f;
                if (imageContainer != null) {
                    imageContainer.cancelRequest();
                    this.f49739f = null;
                }
                a();
                return;
            }
            ImageLoader.ImageContainer imageContainer2 = this.f49739f;
            if (!(imageContainer2 == null || imageContainer2.getRequestUrl() == null)) {
                if (!this.f49739f.getRequestUrl().equals(this.f49735b)) {
                    this.f49739f.cancelRequest();
                    a();
                } else {
                    return;
                }
            }
            this.f49739f = this.f49738e.get(this.f49735b, new ImageLoader.ImageListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    if (CJRVolleyImageView.this.f49737d != 0) {
                        CJRVolleyImageView cJRVolleyImageView = CJRVolleyImageView.this;
                        cJRVolleyImageView.setImageResource(cJRVolleyImageView.f49737d);
                    }
                    if (CJRVolleyImageView.this.f49734a != null) {
                        a unused = CJRVolleyImageView.this.f49734a;
                    }
                }

                public final void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
                    if (!z || !z) {
                        if (imageContainer.getBitmap() != null) {
                            CJRVolleyImageView.this.setImageBitmap(imageContainer.getBitmap());
                            if (CJRVolleyImageView.this.f49740g != null) {
                                CJRVolleyImageView cJRVolleyImageView = CJRVolleyImageView.this;
                                cJRVolleyImageView.startAnimation(cJRVolleyImageView.f49740g);
                            }
                        } else if (CJRVolleyImageView.this.f49736c != 0) {
                            CJRVolleyImageView cJRVolleyImageView2 = CJRVolleyImageView.this;
                            cJRVolleyImageView2.setImageResource(cJRVolleyImageView2.f49736c);
                        }
                        if (CJRVolleyImageView.this.f49734a != null && imageContainer.getBitmap() != null) {
                            a unused = CJRVolleyImageView.this.f49734a;
                            return;
                        }
                        return;
                    }
                    CJRVolleyImageView.this.post(new Runnable() {
                        public final void run() {
                            AnonymousClass1.this.onResponse(imageContainer, false);
                        }
                    });
                }
            });
        }
    }

    private void a() {
        int i2 = this.f49736c;
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
        ImageLoader.ImageContainer imageContainer = this.f49739f;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap((Bitmap) null);
            this.f49739f = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
