package a.a.a.a.a.b;

import a.a.a.a.a.e.c;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final g f681a;

    /* renamed from: b  reason: collision with root package name */
    final WebView f682b = null;

    /* renamed from: c  reason: collision with root package name */
    public final List<h> f683c;

    /* renamed from: d  reason: collision with root package name */
    final String f684d;

    /* renamed from: e  reason: collision with root package name */
    public final String f685e;

    /* renamed from: f  reason: collision with root package name */
    public final e f686f;

    private d(g gVar, String str, List<h> list, String str2) {
        e eVar;
        ArrayList arrayList = new ArrayList();
        this.f683c = arrayList;
        this.f681a = gVar;
        this.f684d = str;
        if (list != null) {
            arrayList.addAll(list);
            eVar = e.NATIVE;
        } else {
            eVar = e.HTML;
        }
        this.f686f = eVar;
        this.f685e = str2;
    }

    public static d a(g gVar, String str, List<h> list, String str2) {
        c.a((Object) gVar, "Partner is null");
        c.a((Object) str, "OM SDK JS script content is null");
        c.a((Object) list, "VerificationScriptResources is null");
        if (str2 == null || str2.length() <= 256) {
            return new d(gVar, str, list, str2);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }
}
