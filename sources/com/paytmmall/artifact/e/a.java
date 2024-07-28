package com.paytmmall.artifact.e;

import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import java.lang.reflect.Type;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f15822a = "WeexSerializer";

    public static <T> T a(String str, Class<T> cls) {
        try {
            return new f().a(str, cls);
        } catch (Exception e2) {
            a.class.getName();
            q.b(e2.getMessage());
            return null;
        }
    }

    public static <T> T a(String str, Type type) {
        try {
            return new f().a(str, type);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static <T> T a(Object obj, Class<T> cls) {
        return a(com.paytmmall.artifact.d.q.a(obj), cls);
    }

    public static <T> T a(HashMap<String, Object> hashMap, String str, Class<T> cls) {
        if (hashMap != null && hashMap.containsKey(str)) {
            return a(String.valueOf(hashMap.get(str)), cls);
        }
        return null;
    }
}
