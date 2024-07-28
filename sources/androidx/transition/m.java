package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class m<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f4810a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f4811b;

    /* renamed from: c  reason: collision with root package name */
    private final float f4812c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f4813d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f4814e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private float f4815f;

    public final /* synthetic */ void set(Object obj, Object obj2) {
        Float f2 = (Float) obj2;
        this.f4815f = f2.floatValue();
        this.f4811b.getPosTan(this.f4812c * f2.floatValue(), this.f4813d, (float[]) null);
        PointF pointF = this.f4814e;
        float[] fArr = this.f4813d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f4810a.set(obj, pointF);
    }

    m(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f4810a = property;
        this.f4811b = new PathMeasure(path, false);
        this.f4812c = this.f4811b.getLength();
    }

    public final /* synthetic */ Object get(Object obj) {
        return Float.valueOf(this.f4815f);
    }
}
