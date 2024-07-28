package androidx.constraintlayout.motion.widget;

import java.util.HashMap;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    HashMap<Object, HashMap<String, float[]>> f2309a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final float a(Object obj, String str) {
        if (!this.f2309a.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap hashMap = this.f2309a.get(obj);
        if (!hashMap.containsKey(str)) {
            return Float.NaN;
        }
        float[] fArr = (float[]) hashMap.get(str);
        if (fArr.length > 0) {
            return fArr[0];
        }
        return Float.NaN;
    }
}
