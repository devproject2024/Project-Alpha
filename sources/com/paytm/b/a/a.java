package com.paytm.b.a;

import android.app.Activity;
import android.content.Context;
import com.paytm.b.a;
import com.paytm.b.b;
import com.paytm.network.a;
import com.paytm.utility.f;
import com.paytm.utility.q;
import com.paytm.utility.u;
import java.util.HashMap;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0708a f42641a = new C0708a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f42642d = f42642d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, a> f42643e = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private b f42644b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42645c = "migrated";

    public static final a a(Context context, a.c cVar) {
        return C0708a.a(context, cVar);
    }

    /* renamed from: com.paytm.b.a.a$a  reason: collision with other inner class name */
    public static final class C0708a {
        private C0708a() {
        }

        public /* synthetic */ C0708a(byte b2) {
            this();
        }

        public static a a(Context context, a.c cVar) {
            a aVar;
            k.c(context, "context");
            k.c(cVar, "verticalId");
            String unused = a.f42642d;
            new StringBuilder("Current Pref Instance : ").append(cVar.name());
            a aVar2 = (a) a.f42643e.get(cVar.name());
            if (aVar2 == null) {
                synchronized (a.f42643e) {
                    aVar = (a) a.f42643e.get(cVar.name());
                    if (aVar == null) {
                        aVar = new a();
                        String unused2 = a.f42642d;
                        StringBuilder sb = new StringBuilder("New Pref Instance Created :  ");
                        sb.append(cVar.name());
                        sb.append(" And Map Size is ");
                        sb.append(a.f42643e.size());
                        a.a(aVar, context, cVar, (f.a) null);
                        a.f42643e.put(cVar.name(), aVar);
                    }
                    x xVar = x.f47997a;
                }
                if (aVar != null) {
                    a.a(aVar, cVar, (f.a) null);
                }
                aVar2 = aVar;
            }
            if (aVar2 == null) {
                k.a();
            }
            return aVar2;
        }

        public static a a(Context context, a.c cVar, f.a aVar) {
            a aVar2;
            k.c(context, "context");
            k.c(cVar, "verticalId");
            k.c(aVar, "prefName");
            String a2 = a(cVar, aVar);
            String unused = a.f42642d;
            q.b("Current Pref Instance : ".concat(String.valueOf(a2)));
            a aVar3 = (a) a.f42643e.get(a2);
            if (aVar3 == null) {
                synchronized (a.f42643e) {
                    aVar2 = (a) a.f42643e.get(a2);
                    if (aVar2 == null) {
                        aVar2 = new a();
                        String unused2 = a.f42642d;
                        q.b("New Pref Instance Created :  " + a2 + " And Map Size is " + a.f42643e.size());
                        a.a(aVar2, context, cVar, aVar);
                        a.f42643e.put(a2, aVar2);
                    }
                    x xVar = x.f47997a;
                }
                if (aVar2 != null) {
                    a.a(aVar2, cVar, aVar);
                }
                aVar3 = aVar2;
            }
            if (aVar3 == null) {
                k.a();
            }
            return aVar3;
        }

        static String a(a.c cVar, f.a aVar) {
            return cVar.name() + "_" + aVar;
        }
    }

    public final synchronized void a(String str, String str2, boolean z) {
        k.c(str, "key");
        q.b("TYPE : putString --> KEY : " + str + " TO_COMM : " + z + " VALUE : " + str2);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(str, str2, z);
    }

    public final synchronized void a(String str, int i2, boolean z) {
        k.c(str, "key");
        q.b("TYPE : putInt --> KEY : " + str + " TO_COMM : " + z + " VALUE : " + i2);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(str, Integer.valueOf(i2), z);
    }

    public final synchronized void a(String str, long j, boolean z) {
        k.c(str, "key");
        q.b("TYPE : putLong --> KEY : " + str + " TO_COMM : " + z + " VALUE : " + j);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(str, Long.valueOf(j), z);
    }

    public final synchronized void a(String str, float f2) {
        k.c(str, "key");
        q.b("TYPE : putFloat --> KEY : " + str + " TO_COMM : true VALUE : " + f2);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(str, Float.valueOf(f2), true);
    }

    public final synchronized void a(String str, boolean z, boolean z2) {
        k.c(str, "key");
        q.b("TYPE : putBoolean --> KEY : " + str + " TO_COMM : " + z2 + " VALUE : " + z);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(str, Boolean.valueOf(z), z2);
    }

    public final synchronized void a(String str, Set<String> set, boolean z) {
        k.c(str, "key");
        k.c(set, "value");
        q.b("TYPE : putStringSet --> KEY : " + str + " TO_COMM : " + z + " VALUE : " + set);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(str, set, z);
    }

    public final String b(String str, String str2, boolean z) {
        k.c(str, "key");
        k.c(str2, "defaultValue");
        q.b("TYPE : getString --> KEY : " + str + " FROM_COMM : " + z);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        return (String) bVar.b(str, str2, z);
    }

    public final int b(String str, int i2, boolean z) {
        k.c(str, "key");
        q.b("TYPE : getInt --> KEY : " + str + " FROM_COMM : " + z);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        return ((Number) bVar.b(str, Integer.valueOf(i2), z)).intValue();
    }

    public final long b(String str, long j, boolean z) {
        k.c(str, "key");
        q.b("TYPE : getLong --> KEY : " + str + " FROM_COMM : " + z);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        return ((Number) bVar.b(str, Long.valueOf(j), z)).longValue();
    }

    public final float a(String str) {
        k.c(str, "key");
        q.b("TYPE : getFloat--> KEY : " + str + " FROM_COMM : true");
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        return ((Number) bVar.b(str, Float.valueOf(0.0f), true)).floatValue();
    }

    public final boolean b(String str, boolean z, boolean z2) {
        k.c(str, "key");
        q.b("TYPE : getBoolean --> KEY : " + str + " FROM_COMM : " + z2);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        return ((Boolean) bVar.b(str, Boolean.valueOf(z), z2)).booleanValue();
    }

    public final Set<String> b(String str, Set<String> set, boolean z) {
        k.c(str, "key");
        q.b("TYPE : getStringSet --> KEY : " + str + " FROM_COMM : " + z);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        return bVar.b(str, set, z);
    }

    public final synchronized void a() {
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a();
    }

    public final synchronized void a(String str, boolean z) {
        k.c(str, "key");
        q.b("TYPE : Delete Key is called --> KEY :  " + str + " FROM_COMM : " + z);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(str, z);
    }

    public final synchronized boolean b(String str, boolean z) {
        b bVar;
        k.c(str, "key");
        q.b("TYPE : contains is called --> KEY :  " + str + " FROM_COMM : " + z);
        bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        return bVar.b(str, z);
    }

    public final void a(u uVar) {
        k.c(uVar, "sPrefDecryptListener");
        a.C0707a aVar = com.paytm.b.a.f42632b;
        k.c(uVar, "sPrefDecryptListener");
        com.paytm.b.a.r = uVar;
        new StringBuilder("sPrefDecryptListener : ").append(com.paytm.b.a.r);
        b bVar = this.f42644b;
        if (bVar == null) {
            k.a("preferenceInterface");
        }
        bVar.a(f42643e);
    }

    public static final /* synthetic */ void a(a aVar, Context context, a.c cVar, f.a aVar2) {
        if (context instanceof Activity) {
            throw new RuntimeException(f42642d + ": Found context is activity context. Require application context.");
        } else if (aVar2 == null) {
            aVar.f42644b = new com.paytm.b.a(context, cVar.name());
        } else {
            aVar.f42644b = new com.paytm.b.a(context, C0708a.a(cVar, aVar2));
        }
    }

    public static final /* synthetic */ void a(a aVar, a.c cVar, f.a aVar2) {
        if (aVar2 == null) {
            if (!aVar.b(aVar.f42645c, false, false)) {
                b bVar = aVar.f42644b;
                if (bVar == null) {
                    k.a("preferenceInterface");
                }
                e eVar = e.f42659a;
                bVar.a(e.a(cVar.name()));
            }
        } else if (!aVar.b(aVar.f42645c, false, false)) {
            b bVar2 = aVar.f42644b;
            if (bVar2 == null) {
                k.a("preferenceInterface");
            }
            e eVar2 = e.f42659a;
            bVar2.a(e.a(aVar2.getPrefname()), aVar2);
        }
    }
}
