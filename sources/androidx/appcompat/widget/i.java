package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;

class i {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1748b = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    Bitmap f1749a;

    /* renamed from: c  reason: collision with root package name */
    private final ProgressBar f1750c;

    i(ProgressBar progressBar) {
        this.f1750c = progressBar;
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i2) {
        ac a2 = ac.a(this.f1750c.getContext(), attributeSet, f1748b, i2, 0);
        Drawable b2 = a2.b(0);
        if (b2 != null) {
            ProgressBar progressBar = this.f1750c;
            if (b2 instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) b2;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i3 = 0; i3 < numberOfFrames; i3++) {
                    Drawable a3 = a(animationDrawable.getFrame(i3), true);
                    a3.setLevel(AppConstants.START_OTP_FLOW);
                    animationDrawable2.addFrame(a3, animationDrawable.getDuration(i3));
                }
                animationDrawable2.setLevel(AppConstants.START_OTP_FLOW);
                b2 = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(b2);
        }
        Drawable b3 = a2.b(1);
        if (b3 != null) {
            this.f1750c.setProgressDrawable(a(b3, false));
        }
        a2.f1669a.recycle();
    }

    private Drawable a(Drawable drawable, boolean z) {
        if (drawable instanceof f) {
            f fVar = (f) drawable;
            Drawable a2 = fVar.a();
            if (a2 != null) {
                fVar.a(a(a2, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                drawableArr[i2] = a(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                layerDrawable2.setId(i3, layerDrawable.getId(i3));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1749a == null) {
                this.f1749a = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }
}
