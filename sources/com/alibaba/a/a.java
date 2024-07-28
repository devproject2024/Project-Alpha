package com.alibaba.a;

import com.alibaba.a.b.a.aa;
import com.alibaba.a.b.a.m;
import com.alibaba.a.b.a.n;
import com.alibaba.a.b.b;
import com.alibaba.a.b.c;
import com.alibaba.a.b.d;
import com.alibaba.a.b.i;
import com.alibaba.a.c.ah;
import com.alibaba.a.c.ap;
import com.alibaba.a.c.av;
import com.alibaba.a.c.aw;
import com.alibaba.a.c.ay;
import com.alibaba.a.c.az;
import com.alibaba.a.c.ba;
import com.alibaba.a.c.bb;
import com.alibaba.a.c.bi;
import com.alibaba.a.d.g;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class a implements c, f {
    public static int DEFAULT_GENERATE_FEATURE = ((((bb.QuoteFieldNames.getMask() | 0) | bb.SkipTransientField.getMask()) | bb.WriteEnumUsingToString.getMask()) | bb.SortField.getMask());
    public static int DEFAULT_PARSER_FEATURE = ((((((((c.AutoCloseSource.getMask() | 0) | c.InternFieldNames.getMask()) | c.UseBigDecimal.getMask()) | c.AllowUnQuotedFieldNames.getMask()) | c.AllowSingleQuotes.getMask()) | c.AllowArbitraryCommas.getMask()) | c.SortFeidFastMatch.getMask()) | c.IgnoreNotMatch.getMask());
    public static String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DUMP_CLASS = null;
    public static final String VERSION = "1.1.46";

    public static final Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static final Object parse(String str, int i2) {
        if (str == null) {
            return null;
        }
        b bVar = new b(str, i.a(), i2);
        Object a2 = bVar.a((Object) null);
        bVar.h();
        bVar.close();
        return a2;
    }

    public static final Object parse(byte[] bArr, c... cVarArr) {
        try {
            return parseObject(new String(bArr, AppConstants.UTF_8), cVarArr);
        } catch (UnsupportedEncodingException e2) {
            throw new d("parseObject error", e2);
        }
    }

    public static final Object parse(String str, c... cVarArr) {
        int i2 = DEFAULT_PARSER_FEATURE;
        for (c config : cVarArr) {
            i2 = c.config(i2, config, true);
        }
        return parse(str, i2);
    }

    public static final e parseObject(String str, c... cVarArr) {
        return (e) parse(str, cVarArr);
    }

    public static final e parseObject(String str) {
        Object parse = parse(str);
        if (parse instanceof e) {
            return (e) parse;
        }
        return (e) toJSON(parse);
    }

    public static final <T> T parseObject(String str, g<T> gVar, c... cVarArr) {
        return parseObject(str, gVar.getType(), i.a(), DEFAULT_PARSER_FEATURE, cVarArr);
    }

    public static final <T> T parseObject(String str, Class<T> cls, c... cVarArr) {
        return parseObject(str, cls, i.a(), DEFAULT_PARSER_FEATURE, cVarArr);
    }

    public static final <T> T parseObject(String str, Class<T> cls, aa aaVar, c... cVarArr) {
        return parseObject(str, cls, i.a(), aaVar, DEFAULT_PARSER_FEATURE, cVarArr);
    }

    public static final <T> T parseObject(String str, Type type, c... cVarArr) {
        return parseObject(str, type, i.a(), DEFAULT_PARSER_FEATURE, cVarArr);
    }

    public static final <T> T parseObject(String str, Type type, aa aaVar, c... cVarArr) {
        return parseObject(str, type, i.a(), DEFAULT_PARSER_FEATURE, cVarArr);
    }

    public static final <T> T parseObject(String str, Type type, int i2, c... cVarArr) {
        if (str == null) {
            return null;
        }
        for (c config : cVarArr) {
            i2 = c.config(i2, config, true);
        }
        b bVar = new b(str, i.a(), i2);
        T a2 = bVar.a(type);
        bVar.h();
        bVar.close();
        return a2;
    }

    public static final <T> T parseObject(String str, Type type, i iVar, int i2, c... cVarArr) {
        return parseObject(str, type, iVar, (aa) null, i2, cVarArr);
    }

    public static final <T> T parseObject(String str, Type type, i iVar, aa aaVar, int i2, c... cVarArr) {
        if (str == null) {
            return null;
        }
        for (c config : cVarArr) {
            i2 = c.config(i2, config, true);
        }
        b bVar = new b(str, iVar, i2);
        if (aaVar instanceof n) {
            if (bVar.f6224g == null) {
                bVar.f6224g = new ArrayList(2);
            }
            bVar.f6224g.add((n) aaVar);
        }
        if (aaVar instanceof m) {
            if (bVar.f6225h == null) {
                bVar.f6225h = new ArrayList(2);
            }
            bVar.f6225h.add((m) aaVar);
        }
        T a2 = bVar.a(type);
        bVar.h();
        bVar.close();
        return a2;
    }

    public static final <T> T parseObject(byte[] bArr, Type type, c... cVarArr) {
        try {
            return parseObject(new String(bArr, AppConstants.UTF_8), type, cVarArr);
        } catch (UnsupportedEncodingException e2) {
            throw new d("parseObject error", e2);
        }
    }

    public static final <T> T parseObject(char[] cArr, int i2, Type type, c... cVarArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i3 = DEFAULT_PARSER_FEATURE;
        for (c config : cVarArr) {
            i3 = c.config(i3, config, true);
        }
        b bVar = new b(cArr, i2, i.a(), i3);
        T a2 = bVar.a(type);
        bVar.h();
        bVar.close();
        return a2;
    }

    public static final <T> T parseObject(String str, Class<T> cls) {
        return parseObject(str, cls, new c[0]);
    }

    public static final b parseArray(String str) {
        b bVar = null;
        if (str == null) {
            return null;
        }
        b bVar2 = new b(str, i.a());
        d g2 = bVar2.g();
        if (g2.a() == 8) {
            g2.d();
        } else if (g2.a() != 20) {
            b bVar3 = new b();
            bVar2.a((Collection) bVar3, (Object) null);
            bVar2.h();
            bVar = bVar3;
        }
        bVar2.close();
        return bVar;
    }

    public static final <T> List<T> parseArray(String str, Class<T> cls) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        b bVar = new b(str, i.a());
        d g2 = bVar.g();
        if (g2.a() == 8) {
            g2.d();
        } else {
            arrayList = new ArrayList();
            bVar.a((Type) cls, (Collection) arrayList);
            bVar.h();
        }
        bVar.close();
        return arrayList;
    }

    public static final List<Object> parseArray(String str, Type[] typeArr) {
        List<Object> list = null;
        if (str == null) {
            return null;
        }
        b bVar = new b(str, i.a());
        Object[] a2 = bVar.a(typeArr);
        if (a2 != null) {
            list = Arrays.asList(a2);
        }
        bVar.h();
        bVar.close();
        return list;
    }

    public static final String toJSONString(Object obj) {
        return toJSONString(obj, new bb[0]);
    }

    public static final String toJSONString(Object obj, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            ahVar.c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static final String toJSONStringWithDateFormat(Object obj, String str, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            ahVar.a(bb.WriteDateUseDateFormat);
            if (str != null) {
                ahVar.f6273h = str;
                if (ahVar.f6274i != null) {
                    ahVar.f6274i = null;
                }
            }
            ahVar.c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static final String toJSONString(Object obj, az azVar, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            ahVar.a(bb.WriteDateUseDateFormat);
            setFilter(ahVar, azVar);
            ahVar.c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static final String toJSONString(Object obj, az[] azVarArr, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            ahVar.a(bb.WriteDateUseDateFormat);
            setFilter(ahVar, azVarArr);
            ahVar.c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static final byte[] toJSONBytes(Object obj, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            ahVar.c(obj);
            return baVar.a(AppConstants.UTF_8);
        } finally {
            baVar.close();
        }
    }

    public static final String toJSONString(Object obj, ay ayVar, bb... bbVarArr) {
        return toJSONString(obj, ayVar, (az) null, bbVarArr);
    }

    public static final String toJSONString(Object obj, ay ayVar, az azVar, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar, ayVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            setFilter(ahVar, azVar);
            ahVar.c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static final String toJSONString(Object obj, ay ayVar, az[] azVarArr, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar, ayVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            setFilter(ahVar, azVarArr);
            ahVar.c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static final String toJSONStringZ(Object obj, ay ayVar, bb... bbVarArr) {
        ba baVar = new ba(bbVarArr);
        try {
            new ah(baVar, ayVar).c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static final byte[] toJSONBytes(Object obj, ay ayVar, bb... bbVarArr) {
        ba baVar = new ba();
        try {
            ah ahVar = new ah(baVar, ayVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            ahVar.c(obj);
            return baVar.a(AppConstants.UTF_8);
        } finally {
            baVar.close();
        }
    }

    public static final String toJSONString(Object obj, boolean z) {
        if (!z) {
            return toJSONString(obj);
        }
        return toJSONString(obj, bb.PrettyFormat);
    }

    public static final void writeJSONStringTo(Object obj, Writer writer, bb... bbVarArr) {
        ba baVar = new ba(writer);
        try {
            ah ahVar = new ah(baVar);
            for (bb a2 : bbVarArr) {
                ahVar.a(a2);
            }
            ahVar.c(obj);
        } finally {
            baVar.close();
        }
    }

    public String toString() {
        return toJSONString();
    }

    public String toJSONString() {
        ba baVar = new ba();
        try {
            new ah(baVar).c(this);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public void writeJSONString(Appendable appendable) {
        ba baVar = new ba();
        try {
            new ah(baVar).c(this);
            appendable.append(baVar.toString());
            baVar.close();
        } catch (IOException e2) {
            throw new d(e2.getMessage(), e2);
        } catch (Throwable th) {
            baVar.close();
            throw th;
        }
    }

    public static final Object toJSON(Object obj) {
        return toJSON(obj, i.a());
    }

    public static final Object toJSON(Object obj, i iVar) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            e eVar = new e(map.size());
            for (Map.Entry entry : map.entrySet()) {
                eVar.put(g.a(entry.getKey()), toJSON(entry.getValue()));
            }
            return eVar;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            b bVar = new b(collection.size());
            for (Object json : collection) {
                bVar.add(toJSON(json));
            }
            return bVar;
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                b bVar2 = new b(length);
                for (int i2 = 0; i2 < length; i2++) {
                    bVar2.add(toJSON(Array.get(obj, i2)));
                }
                return bVar2;
            } else if (iVar.f6244a.contains(cls)) {
                return obj;
            } else {
                try {
                    List<com.alibaba.a.d.c> a2 = g.a(cls);
                    e eVar2 = new e(a2.size());
                    for (com.alibaba.a.d.c next : a2) {
                        eVar2.put(next.f6351a, toJSON(next.a(obj)));
                    }
                    return eVar2;
                } catch (IllegalAccessException e2) {
                    throw new d("toJSON error", e2);
                } catch (InvocationTargetException e3) {
                    throw new d("toJSON error", e3);
                }
            }
        }
    }

    public static final <T> T toJavaObject(a aVar, Class<T> cls) {
        return g.a((Object) aVar, cls, i.a());
    }

    private static void setFilter(ah ahVar, az... azVarArr) {
        for (az filter : azVarArr) {
            setFilter(ahVar, filter);
        }
    }

    private static void setFilter(ah ahVar, az azVar) {
        if (azVar != null) {
            if (azVar instanceof aw) {
                if (ahVar.f6272g == null) {
                    ahVar.f6272g = new ArrayList();
                }
                ahVar.f6272g.add((aw) azVar);
            }
            if (azVar instanceof ap) {
                if (ahVar.f6271f == null) {
                    ahVar.f6271f = new ArrayList();
                }
                ahVar.f6271f.add((ap) azVar);
            }
            if (azVar instanceof bi) {
                if (ahVar.f6270e == null) {
                    ahVar.f6270e = new ArrayList();
                }
                ahVar.f6270e.add((bi) azVar);
            }
            if (azVar instanceof av) {
                if (ahVar.f6269d == null) {
                    ahVar.f6269d = new ArrayList();
                }
                ahVar.f6269d.add((av) azVar);
            }
            if (azVar instanceof com.alibaba.a.c.c) {
                if (ahVar.f6267b == null) {
                    ahVar.f6267b = new ArrayList();
                }
                ahVar.f6267b.add((com.alibaba.a.c.c) azVar);
            }
            if (azVar instanceof com.alibaba.a.c.a) {
                if (ahVar.f6268c == null) {
                    ahVar.f6268c = new ArrayList();
                }
                ahVar.f6268c.add((com.alibaba.a.c.a) azVar);
            }
        }
    }
}
