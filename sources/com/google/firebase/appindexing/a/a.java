package com.google.firebase.appindexing.a;

import com.google.android.gms.common.internal.s;
import com.google.firebase.appindexing.a;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;

public final class a {
    public static com.google.firebase.appindexing.a a(String str, String str2) {
        a.C0625a aVar = new a.C0625a("ViewAction");
        s.a(str);
        s.a(str2);
        aVar.f37994c = str;
        aVar.f37995d = str2;
        s.a(aVar.f37994c, (Object) "setObject is required before calling build().");
        s.a(aVar.f37995d, (Object) "setObject is required before calling build().");
        return new zza(aVar.f37993b, aVar.f37994c, aVar.f37995d, aVar.f37996e, aVar.f37997f == null ? new zzc(new a.b.C0626a().f38003a) : aVar.f37997f, aVar.f37998g, aVar.f37992a);
    }
}
