package com.google.gsonhtcfix;

import com.google.gsonhtcfix.b.a;
import com.google.gsonhtcfix.b.f;
import java.math.BigInteger;

public final class s extends l {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f39824b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a  reason: collision with root package name */
    public Object f39825a;

    public s(Boolean bool) {
        a((Object) bool);
    }

    public s(Number number) {
        a((Object) number);
    }

    public s(String str) {
        a((Object) str);
    }

    s(Object obj) {
        a(obj);
    }

    private void a(Object obj) {
        if (obj instanceof Character) {
            this.f39825a = String.valueOf(((Character) obj).charValue());
            return;
        }
        a.a((obj instanceof Number) || b(obj));
        this.f39825a = obj;
    }

    public final Number a() {
        Object obj = this.f39825a;
        return obj instanceof String ? new f((String) obj) : (Number) obj;
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> isAssignableFrom : f39824b) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.f39825a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.f39825a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f39825a == null) {
            return sVar.f39825a == null;
        }
        if (a(this) && a(sVar)) {
            return a().longValue() == sVar.a().longValue();
        }
        if (!(this.f39825a instanceof Number) || !(sVar.f39825a instanceof Number)) {
            return this.f39825a.equals(sVar.f39825a);
        }
        double doubleValue = a().doubleValue();
        double doubleValue2 = sVar.a().doubleValue();
        return doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2));
    }

    private static boolean a(s sVar) {
        Object obj = sVar.f39825a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        Object obj = this.f39825a;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(b());
    }

    public final String b() {
        Object obj = this.f39825a;
        if (obj instanceof Number) {
            return a().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    public final double c() {
        return this.f39825a instanceof Number ? a().doubleValue() : Double.parseDouble(b());
    }

    public final long d() {
        return this.f39825a instanceof Number ? a().longValue() : Long.parseLong(b());
    }

    public final int e() {
        return this.f39825a instanceof Number ? a().intValue() : Integer.parseInt(b());
    }
}
