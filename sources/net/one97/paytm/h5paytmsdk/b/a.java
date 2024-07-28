package net.one97.paytm.h5paytmsdk.b;

import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final int f16966a;

    /* renamed from: b  reason: collision with root package name */
    final String f16967b;

    /* renamed from: c  reason: collision with root package name */
    String f16968c;

    /* renamed from: d  reason: collision with root package name */
    HashMap<String, List<String>> f16969d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!(this.f16966a == aVar.f16966a) || !k.a((Object) this.f16967b, (Object) aVar.f16967b) || !k.a((Object) this.f16968c, (Object) aVar.f16968c) || !k.a((Object) this.f16969d, (Object) aVar.f16969d)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f16966a * 31;
        String str = this.f16967b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f16968c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        HashMap<String, List<String>> hashMap = this.f16969d;
        if (hashMap != null) {
            i3 = hashMap.hashCode();
        }
        return hashCode2 + i3;
    }

    public final String toString() {
        return "H5HTTPResponse(statusCode=" + this.f16966a + ", statusMessage=" + this.f16967b + ", data=" + this.f16968c + ", map=" + this.f16969d + ")";
    }
}
