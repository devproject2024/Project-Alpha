package net.one97.paytm.phoenix.c.a;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f59393a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f59394b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, List<String>> f59395c;

    /* renamed from: d  reason: collision with root package name */
    private final String f59396d;

    public b(Integer num, String str, byte[] bArr, Map<String, ? extends List<String>> map) {
        this.f59393a = num;
        this.f59396d = str;
        this.f59394b = bArr;
        this.f59395c = map;
    }

    public final String toString() {
        return "HttpResponse{statusCode=" + this.f59393a + ", statusMessage='" + this.f59396d + "', data=" + Arrays.toString(this.f59394b) + ", headers=" + this.f59395c + "}";
    }
}
