package androidx.vectordrawable.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.graphics.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import org.xmlpull.v1.XmlPullParser;

public final class g implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private float[] f4881a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f4882b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = androidx.core.content.b.g.a(resources, theme, attributeSet, a.l);
        if (androidx.core.content.b.g.a(xmlPullParser, "pathData")) {
            String c2 = androidx.core.content.b.g.c(a2, xmlPullParser, "pathData", 4);
            Path a3 = c.a(c2);
            if (a3 != null) {
                a(a3);
            } else {
                throw new InflateException("The path is null, which is created from ".concat(String.valueOf(c2)));
            }
        } else if (!androidx.core.content.b.g.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (androidx.core.content.b.g.a(xmlPullParser, "controlY1")) {
            float a4 = androidx.core.content.b.g.a(a2, xmlPullParser, "controlX1", 0, 0.0f);
            float a5 = androidx.core.content.b.g.a(a2, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a6 = androidx.core.content.b.g.a(xmlPullParser, "controlX2");
            if (a6 != androidx.core.content.b.g.a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!a6) {
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.quadTo(a4, a5, 1.0f, 1.0f);
                a(path);
            } else {
                float a7 = androidx.core.content.b.g.a(a2, xmlPullParser, "controlX2", 2, 0.0f);
                float a8 = androidx.core.content.b.g.a(a2, xmlPullParser, "controlY2", 3, 0.0f);
                Path path2 = new Path();
                path2.moveTo(0.0f, 0.0f);
                path2.cubicTo(a4, a5, a7, a8, 1.0f, 1.0f);
                a(path2);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        a2.recycle();
    }

    private void a(Path path) {
        int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f4881a = new float[min];
            this.f4882b = new float[min];
            float[] fArr = new float[2];
            for (int i3 = 0; i3 < min; i3++) {
                pathMeasure.getPosTan((((float) i3) * length) / ((float) (min - 1)), fArr, (float[]) null);
                this.f4881a[i3] = fArr[0];
                this.f4882b[i3] = fArr[1];
            }
            if (((double) Math.abs(this.f4881a[0])) <= 1.0E-5d && ((double) Math.abs(this.f4882b[0])) <= 1.0E-5d) {
                int i4 = min - 1;
                if (((double) Math.abs(this.f4881a[i4] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f4882b[i4] - 1.0f)) <= 1.0E-5d) {
                    int i5 = 0;
                    float f2 = 0.0f;
                    while (i2 < min) {
                        float[] fArr2 = this.f4881a;
                        int i6 = i5 + 1;
                        float f3 = fArr2[i5];
                        if (f3 >= f2) {
                            fArr2[i2] = f3;
                            i2++;
                            f2 = f3;
                            i5 = i6;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f3)));
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f4881a[0]);
            sb.append(AppConstants.COMMA);
            sb.append(this.f4882b[0]);
            sb.append(" end:");
            int i7 = min - 1;
            sb.append(this.f4881a[i7]);
            sb.append(AppConstants.COMMA);
            sb.append(this.f4882b[i7]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(length)));
    }

    public final float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f4881a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f4881a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f4881a;
        float f3 = fArr[length] - fArr[i2];
        if (f3 == 0.0f) {
            return this.f4882b[i2];
        }
        float[] fArr2 = this.f4882b;
        float f4 = fArr2[i2];
        return f4 + (((f2 - fArr[i2]) / f3) * (fArr2[length] - f4));
    }
}
