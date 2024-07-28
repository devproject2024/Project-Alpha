package net.one97.paytm.upi.util;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class FlipAnimation extends Animation {
    public static final int ROTATION_X = 0;
    public static final int ROTATION_Y = 1;
    public static final float SCALE_DEFAULT = 0.75f;
    private Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private int mDirection;
    private final float mFromDegrees;
    private final float mToDegrees;
    private float scale;
    private final ScaleUpDownEnum scaleType;

    public FlipAnimation(float f2, float f3, float f4, float f5, float f6, ScaleUpDownEnum scaleUpDownEnum) {
        this.mFromDegrees = f2;
        this.mToDegrees = f3;
        this.mCenterX = f4;
        this.mCenterY = f5;
        this.scale = (f6 <= 0.0f || f6 >= 1.0f) ? 0.75f : f6;
        this.scaleType = scaleUpDownEnum == null ? ScaleUpDownEnum.SCALE_CYCLE : scaleUpDownEnum;
        this.mDirection = 1;
    }

    public void initialize(int i2, int i3, int i4, int i5) {
        super.initialize(i2, i3, i4, i5);
        this.mCamera = new Camera();
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.mFromDegrees;
        float f4 = f3 + ((this.mToDegrees - f3) * f2);
        float f5 = this.mCenterX;
        float f6 = this.mCenterY;
        Camera camera = this.mCamera;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.mDirection == 0) {
            camera.rotateX(f4);
        } else {
            camera.rotateY(f4);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f5, -f6);
        matrix.postTranslate(f5, f6);
        matrix.preScale(this.scaleType.getScale(this.scale, f2), this.scaleType.getScale(this.scale, f2), f5, f6);
    }

    public void setDirection(int i2) {
        this.mDirection = i2;
    }

    /* renamed from: net.one97.paytm.upi.util.FlipAnimation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f69533a = new int[ScaleUpDownEnum.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.upi.util.FlipAnimation$ScaleUpDownEnum[] r0 = net.one97.paytm.upi.util.FlipAnimation.ScaleUpDownEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f69533a = r0
                int[] r0 = f69533a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.upi.util.FlipAnimation$ScaleUpDownEnum r1 = net.one97.paytm.upi.util.FlipAnimation.ScaleUpDownEnum.SCALE_UP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f69533a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.upi.util.FlipAnimation$ScaleUpDownEnum r1 = net.one97.paytm.upi.util.FlipAnimation.ScaleUpDownEnum.SCALE_DOWN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f69533a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.upi.util.FlipAnimation$ScaleUpDownEnum r1 = net.one97.paytm.upi.util.FlipAnimation.ScaleUpDownEnum.SCALE_CYCLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.FlipAnimation.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ScaleUpDownEnum {
        SCALE_UP,
        SCALE_DOWN,
        SCALE_CYCLE,
        SCALE_NONE;

        public final float getScale(float f2, float f3) {
            float f4;
            float f5;
            int i2 = AnonymousClass1.f69533a[ordinal()];
            boolean z = true;
            if (i2 != 1) {
                if (i2 == 2) {
                    f5 = 1.0f - f2;
                } else if (i2 != 3) {
                    return 1.0f;
                } else {
                    if (((double) f3) <= 0.5d) {
                        z = false;
                    }
                    if (z) {
                        f4 = (1.0f - f2) * (f3 - 0.5f) * 2.0f;
                    } else {
                        f5 = 1.0f - f2;
                        f3 *= 2.0f;
                    }
                }
                return 1.0f - (f5 * f3);
            }
            f4 = (1.0f - f2) * f3;
            return f2 + f4;
        }
    }
}
