package com.alibaba.a.c;

import com.alibaba.a.a;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public final class ao implements at {

    /* renamed from: a  reason: collision with root package name */
    public static ao f6283a = new ao();

    /* JADX INFO: finally extract failed */
    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        boolean z;
        ah ahVar2 = ahVar;
        Object obj3 = obj;
        ba baVar = ahVar2.f6266a;
        if (obj3 == null) {
            baVar.write("null");
            return;
        }
        Map map = (Map) obj3;
        if (baVar.b(bb.SortField) && !(map instanceof SortedMap) && !(map instanceof LinkedHashMap)) {
            try {
                map = new TreeMap(map);
            } catch (Exception unused) {
            }
        }
        if (ahVar.a(obj)) {
            ahVar.b(obj);
            return;
        }
        ax axVar = ahVar2.j;
        ahVar2.a(axVar, obj3, obj2, 0);
        try {
            baVar.a('{');
            ahVar.b();
            if (baVar.b(bb.WriteClassName)) {
                baVar.a(a.DEFAULT_TYPE_KEY, false);
                baVar.b(obj.getClass().getName());
                z = false;
            } else {
                z = true;
            }
            Class<?> cls = null;
            at atVar = null;
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                List<aw> list = ahVar2.f6272g;
                if (list != null && list.size() > 0) {
                    if (key != null) {
                        if (!(key instanceof String)) {
                            if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                a.toJSONString(key);
                                if (x.a(ahVar)) {
                                }
                            }
                        }
                    }
                    if (!x.a(ahVar)) {
                    }
                }
                List<av> list2 = ahVar2.f6269d;
                if (list2 != null && list2.size() > 0) {
                    if (key != null) {
                        if (!(key instanceof String)) {
                            if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                a.toJSONString(key);
                                if (x.b(ahVar)) {
                                }
                            }
                        }
                    }
                    if (!x.b(ahVar)) {
                    }
                }
                List<ap> list3 = ahVar2.f6271f;
                if (list3 != null && list3.size() > 0) {
                    if (key != null) {
                        if (!(key instanceof String)) {
                            if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = x.a(ahVar2, a.toJSONString(key));
                            }
                        }
                    }
                    key = x.a(ahVar2, (String) key);
                }
                List<bi> list4 = ahVar2.f6270e;
                if (list4 != null && list4.size() > 0) {
                    if (key != null) {
                        if (!(key instanceof String)) {
                            if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                a.toJSONString(key);
                                value = x.a(ahVar2, value);
                            }
                        }
                    }
                    value = x.a(ahVar2, value);
                }
                if (value != null || ahVar2.b(bb.WriteMapNullValue)) {
                    if (key instanceof String) {
                        String str = (String) key;
                        if (!z) {
                            baVar.a(',');
                        }
                        if (baVar.b(bb.PrettyFormat)) {
                            ahVar.d();
                        }
                        baVar.a(str, true);
                    } else {
                        if (!z) {
                            baVar.a(',');
                        }
                        if (!baVar.b(bb.BrowserCompatible)) {
                            if (!baVar.b(bb.WriteNonStringKeyAsString)) {
                                ahVar2.c(key);
                                baVar.a(':');
                            }
                        }
                        ahVar2.a(a.toJSONString(key));
                        baVar.a(':');
                    }
                    if (value == null) {
                        baVar.write("null");
                    } else {
                        Class<?> cls2 = value.getClass();
                        if (cls2 == cls) {
                            atVar.a(ahVar2, value, key, (Type) null);
                        } else {
                            atVar = ahVar2.a(cls2);
                            atVar.a(ahVar2, value, key, (Type) null);
                            cls = cls2;
                        }
                    }
                    z = false;
                }
            }
            ahVar2.j = axVar;
            ahVar.c();
            if (baVar.b(bb.PrettyFormat) && map.size() > 0) {
                ahVar.d();
            }
            baVar.a('}');
        } catch (Throwable th) {
            ahVar2.j = axVar;
            throw th;
        }
    }
}
