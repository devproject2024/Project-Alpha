package com.airbnb.lottie;

import androidx.a.b;
import androidx.core.g.d;
import com.airbnb.lottie.f.f;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    boolean f6173a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Object> f6174b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, f> f6175c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<d<String, Float>> f6176d = new Comparator<d<String, Float>>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            float floatValue = ((Float) ((d) obj).f2965b).floatValue();
            float floatValue2 = ((Float) ((d) obj2).f2965b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    public final void a(String str, float f2) {
        if (this.f6173a) {
            f fVar = this.f6175c.get(str);
            if (fVar == null) {
                fVar = new f();
                this.f6175c.put(str, fVar);
            }
            fVar.f6119a += f2;
            fVar.f6120b++;
            if (fVar.f6120b == Integer.MAX_VALUE) {
                fVar.f6119a /= 2.0f;
                fVar.f6120b /= 2;
            }
            if (str.equals("__container")) {
                Iterator<Object> it2 = this.f6174b.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
        }
    }
}
