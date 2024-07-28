package androidx.core.e;

import android.util.Base64;
import androidx.core.g.f;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final String f2868a;

    /* renamed from: b  reason: collision with root package name */
    final String f2869b;

    /* renamed from: c  reason: collision with root package name */
    final String f2870c;

    /* renamed from: d  reason: collision with root package name */
    final List<List<byte[]>> f2871d;

    /* renamed from: e  reason: collision with root package name */
    final int f2872e = 0;

    /* renamed from: f  reason: collision with root package name */
    final String f2873f = (this.f2868a + "-" + this.f2869b + "-" + this.f2870c);

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2868a = (String) f.a(str);
        this.f2869b = (String) f.a(str2);
        this.f2870c = (String) f.a(str3);
        this.f2871d = (List) f.a(list);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2868a + ", mProviderPackage: " + this.f2869b + ", mQuery: " + this.f2870c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f2871d.size(); i2++) {
            sb.append(" [");
            List list = this.f2871d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2872e);
        return sb.toString();
    }
}
