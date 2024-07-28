package com.paytm.android.chat.utils.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;
import com.bumptech.glide.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.d.a.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.a.a;

public class GlideBlurformation extends f {
    private static Charset CHARSET = Charset.forName(AppConstants.UTF_8);
    private static int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = "com.kevin.glidetest.BlurTransformation";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);
    private static int MAX_RADIUS = 25;
    private static String STRING_CHARSET_NAME = "UTF-8";
    private e mBitmapPool;
    private Context mContext;
    private int mRadius;
    private int mSampling;

    public GlideBlurformation(Context context) {
        this(context, b.a(context).f6425a, MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public GlideBlurformation(Context context, e eVar, int i2, int i3) {
        this.mContext = context.getApplicationContext();
        this.mBitmapPool = eVar;
        this.mRadius = i2;
        this.mSampling = i3;
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = this.mSampling;
        int i5 = width / i4;
        int i6 = height / i4;
        Bitmap a2 = this.mBitmapPool.a(i5, i6, Bitmap.Config.ARGB_8888);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(a2);
        int i7 = this.mSampling;
        canvas.scale(1.0f / ((float) i7), 1.0f / ((float) i7));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                return jp.wasabeef.glide.transformations.a.b.a(this.mContext, a2, this.mRadius);
            } catch (RSRuntimeException unused) {
            }
        }
        return a.a(a2, this.mRadius);
    }

    public int hashCode() {
        return ID.hashCode();
    }

    public boolean equals(Object obj) {
        return obj instanceof GlideBlurformation;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
