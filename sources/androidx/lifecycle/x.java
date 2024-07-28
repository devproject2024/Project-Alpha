package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Integer> f3691a = new HashMap();

    public final boolean a(String str) {
        Integer num = this.f3691a.get(str);
        int intValue = num != null ? num.intValue() : 0;
        boolean z = (intValue & 1) != 0;
        this.f3691a.put(str, Integer.valueOf(intValue | 1));
        if (!z) {
            return true;
        }
        return false;
    }
}
