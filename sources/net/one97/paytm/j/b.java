package net.one97.paytm.j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    public static Map<String, Object> a(Object... objArr) {
        if (objArr.length % 2 == 0) {
            HashMap hashMap = new HashMap();
            int i2 = 0;
            while (i2 < objArr.length) {
                if (objArr[i2] instanceof String) {
                    hashMap.put(objArr[i2], objArr[i2 + 1]);
                    i2 += 2;
                } else {
                    String valueOf = String.valueOf(objArr[i2]);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 21);
                    sb.append("key is not a string: ");
                    sb.append(valueOf);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            return hashMap;
        }
        throw new IllegalArgumentException("expected even number of key-value pairs");
    }

    public static List<Object> b(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
