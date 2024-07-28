package com.alibaba.a.c;

import com.alibaba.a.a;
import com.alibaba.a.d.e;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public final class ay extends e<Type, at> {

    /* renamed from: a  reason: collision with root package name */
    private static final ay f6299a = new ay();

    /* renamed from: b  reason: collision with root package name */
    private String f6300b;

    public static at a(Class<?> cls) {
        return new aj(cls);
    }

    public static final ay a() {
        return f6299a;
    }

    public ay() {
        this((byte) 0);
    }

    private ay(byte b2) {
        super((byte) 0);
        this.f6300b = a.DEFAULT_TYPE_KEY;
        a(Boolean.class, g.f6320a);
        a(Character.class, k.f6324a);
        a(Byte.class, ad.f6263a);
        a(Short.class, ad.f6263a);
        a(Integer.class, ad.f6263a);
        a(Long.class, an.f6282a);
        a(Float.class, z.f6342a);
        a(Double.class, s.f6332a);
        a(BigDecimal.class, d.f6317a);
        a(BigInteger.class, e.f6318a);
        a(String.class, bd.f6309a);
        a(byte[].class, h.f6321a);
        a(short[].class, bc.f6308a);
        a(int[].class, ac.f6262a);
        a(long[].class, am.f6281a);
        a(float[].class, y.f6341a);
        a(double[].class, r.f6331a);
        a(boolean[].class, f.f6319a);
        a(char[].class, j.f6323a);
        a(Object[].class, ar.f6284a);
        a(Class.class, m.f6326a);
        a(SimpleDateFormat.class, p.f6329a);
        a(Locale.class, al.f6280a);
        a(Currency.class, o.f6328a);
        a(TimeZone.class, be.f6310a);
        a(UUID.class, bh.f6313a);
        a(InetAddress.class, aa.f6260a);
        a(Inet4Address.class, aa.f6260a);
        a(Inet6Address.class, aa.f6260a);
        a(InetSocketAddress.class, ab.f6261a);
        a(URI.class, bf.f6311a);
        a(URL.class, bg.f6312a);
        a(Pattern.class, au.f6294a);
        a(Charset.class, l.f6325a);
    }
}
