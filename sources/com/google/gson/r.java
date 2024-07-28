package com.google.gson;

import com.google.gson.internal.a;
import com.google.gson.internal.f;
import java.math.BigInteger;

public final class r extends l {

    /* renamed from: a  reason: collision with root package name */
    public final Object f39637a;

    public r(Boolean bool) {
        this.f39637a = a.a(bool);
    }

    public r(Number number) {
        this.f39637a = a.a(number);
    }

    public r(String str) {
        this.f39637a = a.a(str);
    }

    public final Number b() {
        Object obj = this.f39637a;
        return obj instanceof String ? new f((String) obj) : (Number) obj;
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.f39637a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = b().longValue();
        } else {
            Object obj = this.f39637a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(b().doubleValue());
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
        r rVar = (r) obj;
        if (this.f39637a == null) {
            return rVar.f39637a == null;
        }
        if (a(this) && a(rVar)) {
            return b().longValue() == rVar.b().longValue();
        }
        if (!(this.f39637a instanceof Number) || !(rVar.f39637a instanceof Number)) {
            return this.f39637a.equals(rVar.f39637a);
        }
        double doubleValue = b().doubleValue();
        double doubleValue2 = rVar.b().doubleValue();
        return doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2));
    }

    private static boolean a(r rVar) {
        Object obj = rVar.f39637a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        Object obj = this.f39637a;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(c());
    }

    public final String c() {
        Object obj = this.f39637a;
        if (obj instanceof Number) {
            return b().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    public final double d() {
        return this.f39637a instanceof Number ? b().doubleValue() : Double.parseDouble(c());
    }

    public final long e() {
        return this.f39637a instanceof Number ? b().longValue() : Long.parseLong(c());
    }

    public final int f() {
        return this.f39637a instanceof Number ? b().intValue() : Integer.parseInt(c());
    }
}
