package com.alibaba.a.c;

import com.alibaba.a.b.a.m;
import com.alibaba.a.b.a.n;
import com.alibaba.a.b.b;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public final class x {
    public static Type a(b bVar) {
        List<n> list = bVar.f6224g;
        Type type = null;
        if (list == null) {
            return null;
        }
        for (n a2 : list) {
            type = a2.a();
        }
        return type;
    }

    public static void b(b bVar) {
        List<m> list = bVar.f6225h;
        if (list != null) {
            Iterator<m> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public static Object a(ah ahVar, Object obj) {
        List<bi> list = ahVar.f6270e;
        if (list != null) {
            for (bi a2 : list) {
                obj = a2.a();
            }
        }
        return obj;
    }

    public static String a(ah ahVar, String str) {
        List<ap> list = ahVar.f6271f;
        if (list != null) {
            for (ap a2 : list) {
                str = a2.a();
            }
        }
        return str;
    }

    public static boolean a(ah ahVar) {
        List<aw> list = ahVar.f6272g;
        if (list == null) {
            return true;
        }
        for (aw a2 : list) {
            if (!a2.a()) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(ah ahVar) {
        List<av> list = ahVar.f6269d;
        if (list == null) {
            return true;
        }
        for (av a2 : list) {
            if (!a2.a()) {
                return false;
            }
        }
        return true;
    }
}
