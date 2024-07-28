package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.b.g;
import androidx.core.graphics.c;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    private Path f4687a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f4688b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f4689c = new Matrix();

    public PatternPathMotion() {
        this.f4688b.lineTo(1.0f, 0.0f);
        this.f4687a = this.f4688b;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.k);
        try {
            String c2 = g.c(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (c2 != null) {
                Path a2 = c.a(c2);
                PathMeasure pathMeasure = new PathMeasure(a2, false);
                float[] fArr = new float[2];
                pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
                float f2 = fArr[0];
                float f3 = fArr[1];
                pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
                float f4 = fArr[0];
                float f5 = fArr[1];
                if (f4 == f2) {
                    if (f5 == f3) {
                        throw new IllegalArgumentException("pattern must not end at the starting point");
                    }
                }
                this.f4689c.setTranslate(-f4, -f5);
                float f6 = f2 - f4;
                float f7 = f3 - f5;
                float a3 = 1.0f / a(f6, f7);
                this.f4689c.postScale(a3, a3);
                this.f4689c.postRotate((float) Math.toDegrees(-Math.atan2((double) f7, (double) f6)));
                a2.transform(this.f4689c, this.f4688b);
                this.f4687a = a2;
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final Path a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float a2 = a(f6, f7);
        double atan2 = Math.atan2((double) f7, (double) f6);
        this.f4689c.setScale(a2, a2);
        this.f4689c.postRotate((float) Math.toDegrees(atan2));
        this.f4689c.postTranslate(f2, f3);
        Path path = new Path();
        this.f4688b.transform(this.f4689c, path);
        return path;
    }

    private static float a(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }
}
