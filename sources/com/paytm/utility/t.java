package com.paytm.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.aa;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static t f43850a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f43851b;

    public static t a(boolean z) {
        if (f43850a == null) {
            f43850a = new t();
            f43851b = z;
        }
        return f43850a;
    }

    public final void a(String str, ImageView imageView, ProgressBar progressBar) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        w.a().a(str).a(R.drawable.homepage_default_icon).b(R.drawable.homepage_default_icon).a(imageView, (e) new e() {
            public final void onError(Exception exc) {
            }

            public final void onSuccess() {
            }
        });
    }

    public static void b(String str, ImageView imageView) {
        aa b2 = w.a().a(str).a(R.drawable.homepage_default_icon).b(R.drawable.homepage_default_icon);
        b2.f45353b = true;
        b2.d().a(imageView, (e) null);
    }

    public static void a(String str, int i2, Drawable drawable, Drawable drawable2, ImageView imageView, boolean z) {
        aa a2 = w.a().a(str).a((ah) new b(i2, 0, z));
        a2.f45353b = true;
        a2.b(drawable).a(drawable2).a(imageView, (e) null);
    }

    public static void a(String str, int i2, Drawable drawable, Drawable drawable2, ImageView imageView) {
        aa a2 = w.a().a(str).a((ah) new b(i2, 0, true));
        a2.f45353b = true;
        a2.b(drawable).a(drawable2).a(imageView, (e) null);
    }

    public static void a(String str, Drawable drawable, Drawable drawable2, ImageView imageView, int i2, int i3) {
        w.a().a(str).a(i2, i3).a((ah) new b(0, 0, true)).b(drawable).a(drawable2).a(imageView, (e) null);
    }

    public final void a(String str, ImageView imageView, androidx.core.graphics.drawable.b bVar) {
        w.a().a(str).a((Drawable) bVar).a((ah) new a()).a(imageView, (e) new e() {
            public final void onSuccess() {
                q.d("onSuccess");
            }

            public final void onError(Exception exc) {
                q.d("onError");
            }
        });
    }

    public static class b implements ah {

        /* renamed from: a  reason: collision with root package name */
        private final int f43862a;

        /* renamed from: b  reason: collision with root package name */
        private final int f43863b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f43864c;

        public b(int i2, int i3, boolean z) {
            this.f43862a = i2;
            this.f43863b = i3;
            this.f43864c = z;
        }

        public final Bitmap transform(Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int i2 = this.f43863b;
            RectF rectF = new RectF((float) i2, (float) i2, (float) (bitmap.getWidth() - this.f43863b), (float) (bitmap.getHeight() - this.f43863b));
            int i3 = this.f43862a;
            canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
            if (!this.f43864c) {
                Paint paint2 = paint;
                canvas.drawRect(0.0f, (float) (bitmap.getHeight() / 2), (float) (bitmap.getWidth() / 2), (float) bitmap.getHeight(), paint2);
                canvas.drawRect((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2), (float) bitmap.getWidth(), (float) bitmap.getHeight(), paint2);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }

        public final String key() {
            return "rounded(r=" + this.f43862a + ", m=" + this.f43863b + ")";
        }
    }

    public class a implements ah {
        public final String key() {
            return "circle";
        }

        public a() {
        }

        public final Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            float f2 = ((float) min) / 2.0f;
            canvas.drawCircle(f2, f2, f2, paint);
            createBitmap.recycle();
            return createBitmap2;
        }
    }

    public final void a(final String str, final ImageView imageView) {
        Uri parse;
        if (f43851b) {
            w.a().a(str).a(R.drawable.homepage_default_icon).b(R.drawable.homepage_default_icon).a(imageView, (e) null);
            return;
        }
        w a2 = w.a();
        if (!(str == null || (parse = Uri.parse(str)) == null)) {
            a2.f45450g.b(parse.toString());
        }
        w.a().a(str).a(com.squareup.picasso.t.OFFLINE).a(R.drawable.homepage_default_icon).b(R.drawable.homepage_default_icon).a(imageView, (e) new e() {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ProgressBar f43852a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ e f43853b = null;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f43855d;

            {
                this.f43855d = -1;
            }

            public final void onSuccess() {
                ProgressBar progressBar = this.f43852a;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                e eVar = this.f43853b;
                if (eVar != null) {
                    eVar.onSuccess();
                }
            }

            public final void onError(Exception exc) {
                aa a2 = w.a().a(str);
                int i2 = this.f43855d;
                if (i2 == -1) {
                    i2 = R.drawable.homepage_default_icon;
                }
                aa a3 = a2.a(i2);
                int i3 = this.f43855d;
                if (i3 == -1) {
                    i3 = R.drawable.homepage_default_icon;
                }
                a3.b(i3).a(imageView, (e) new e() {
                    public final void onSuccess() {
                        if (AnonymousClass1.this.f43852a != null) {
                            AnonymousClass1.this.f43852a.setVisibility(8);
                        }
                        if (AnonymousClass1.this.f43853b != null) {
                            AnonymousClass1.this.f43853b.onSuccess();
                        }
                    }

                    public final void onError(Exception exc) {
                        if (AnonymousClass1.this.f43852a != null) {
                            AnonymousClass1.this.f43852a.setVisibility(8);
                        }
                        if (AnonymousClass1.this.f43853b != null) {
                            AnonymousClass1.this.f43853b.onError(exc);
                        }
                    }
                });
            }
        });
    }
}
