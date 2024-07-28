package com.paytm.notification.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.paytm.notification.g;
import com.paytm.notification.j;
import com.paytm.notification.models.callback.ErrorReportCallback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42999a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f43000b;

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.gson.f f43001c = new com.google.gson.f();

    /* renamed from: d  reason: collision with root package name */
    private static final ExecutorService f43002d = Executors.newCachedThreadPool();

    private a() {
    }

    /* access modifiers changed from: private */
    public final SharedPreferences a() {
        if (f43000b == null) {
            synchronized (this) {
                if (f43000b == null) {
                    g.c cVar = com.paytm.notification.g.f43191a;
                    if (com.paytm.notification.g.f43192h == null) {
                        e.f43014a.d("PaytmNotifications.appContext == null", new Object[0]);
                    }
                    g.c cVar2 = com.paytm.notification.g.f43191a;
                    Context d2 = com.paytm.notification.g.f43192h;
                    f43000b = d2 != null ? d2.getSharedPreferences("ActivityLog", 0) : null;
                }
                x xVar = x.f47997a;
            }
        }
        SharedPreferences sharedPreferences = f43000b;
        if (sharedPreferences == null) {
            k.a();
        }
        return sharedPreferences;
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43003a;

        c(String str) {
            this.f43003a = str;
        }

        public final void run() {
            synchronized (a.class) {
                try {
                    boolean z = false;
                    e.f43014a.a(this.f43003a, new Object[0]);
                    String str = this.f43003a;
                    if (str == null) {
                        str = "null";
                    }
                    SharedPreferences a2 = a.f42999a.a();
                    SharedPreferences.Editor edit = a2.edit();
                    a aVar = a.f42999a;
                    b f2 = a.g(a2.getString("channel_id", (String) null));
                    Collection collection = f2.f43008a;
                    if (collection == null || collection.isEmpty()) {
                        z = true;
                    }
                    if (z || (!k.a((Object) ((c) kotlin.a.k.f(f2.f43008a)).f43010b, (Object) str))) {
                        a aVar2 = a.f42999a;
                        edit.putString("channel_id", a.a(f2, str));
                        edit.apply();
                    }
                } catch (Exception e2) {
                    e.f43014a.b(e2);
                }
                x xVar = x.f47997a;
            }
        }
    }

    public static void a(String str) {
        f43002d.execute(new c(str));
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43005a;

        e(String str) {
            this.f43005a = str;
        }

        public final void run() {
            String str;
            boolean z;
            synchronized (a.class) {
                try {
                    SharedPreferences a2 = a.f42999a.a();
                    SharedPreferences.Editor edit = a2.edit();
                    a aVar = a.f42999a;
                    b f2 = a.g(a2.getString("token_first5_last5", (String) null));
                    if (this.f43005a == null) {
                        str = "token == null";
                    } else if (this.f43005a.length() > 10) {
                        StringBuilder sb = new StringBuilder();
                        String str2 = this.f43005a;
                        if (str2 != null) {
                            String substring = str2.substring(0, 5);
                            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            sb.append(substring);
                            sb.append("****");
                            String str3 = this.f43005a;
                            int length = this.f43005a.length() - 5;
                            int length2 = this.f43005a.length();
                            if (str3 != null) {
                                String substring2 = str3.substring(length, length2);
                                k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                sb.append(substring2);
                                str = sb.toString();
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        str = this.f43005a;
                    }
                    Collection collection = f2.f43008a;
                    if (collection != null) {
                        if (!collection.isEmpty()) {
                            z = false;
                            if (z || (!k.a((Object) ((c) kotlin.a.k.f(f2.f43008a)).f43010b, (Object) str))) {
                                e.f43014a.a(str, new Object[0]);
                                a aVar2 = a.f42999a;
                                edit.putString("token_first5_last5", a.a(f2, str));
                                edit.apply();
                            }
                            x xVar = x.f47997a;
                        }
                    }
                    z = true;
                    e.f43014a.a(str, new Object[0]);
                    a aVar22 = a.f42999a;
                    edit.putString("token_first5_last5", a.a(f2, str));
                    edit.apply();
                } catch (Exception e2) {
                    e.f43014a.b(e2);
                }
                x xVar2 = x.f47997a;
            }
        }
    }

    public static void b(String str) {
        f43002d.execute(new e(str));
    }

    /* renamed from: com.paytm.notification.b.a$a  reason: collision with other inner class name */
    public static final class C0718a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Long.valueOf(((c) t).f43009a), Long.valueOf(((c) t2).f43009a));
        }
    }

    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Long.valueOf(((c) t).f43009a), Long.valueOf(((c) t2).f43009a));
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43006a;

        f(String str) {
            this.f43006a = str;
        }

        public final void run() {
            synchronized (a.class) {
                try {
                    e.f43014a.a(this.f43006a, new Object[0]);
                    SharedPreferences a2 = a.f42999a.a();
                    SharedPreferences.Editor edit = a2.edit();
                    a aVar = a.f42999a;
                    b f2 = a.g(a2.getString("token_log", (String) null));
                    if (f2.f43008a.size() > 10) {
                        int size = f2.f43008a.size() - 10;
                        for (int i2 = 0; i2 < size; i2++) {
                            f2.f43008a.remove(0);
                        }
                    }
                    a aVar2 = a.f42999a;
                    edit.putString("token_log", a.a(f2, this.f43006a));
                    edit.apply();
                } catch (Exception e2) {
                    e.f43014a.b(e2);
                }
                x xVar = x.f47997a;
            }
        }
    }

    public static void c(String str) {
        k.c(str, "log");
        f43002d.execute(new f(str));
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43004a;

        d(String str) {
            this.f43004a = str;
        }

        public final void run() {
            synchronized (a.class) {
                try {
                    e.f43014a.a(this.f43004a, new Object[0]);
                    SharedPreferences a2 = a.f42999a.a();
                    SharedPreferences.Editor edit = a2.edit();
                    a aVar = a.f42999a;
                    b f2 = a.g(a2.getString("push_log", (String) null));
                    if (f2.f43008a.size() > 10) {
                        int size = f2.f43008a.size() - 10;
                        for (int i2 = 0; i2 < size && System.currentTimeMillis() - f2.f43008a.get(0).f43009a <= 259200000; i2++) {
                            f2.f43008a.remove(0);
                        }
                    }
                    a aVar2 = a.f42999a;
                    edit.putString("push_log", a.a(f2, this.f43004a));
                    edit.apply();
                } catch (Exception e2) {
                    e.f43014a.b(e2);
                }
                x xVar = x.f47997a;
            }
        }
    }

    public static void d(String str) {
        k.c(str, "log");
        f43002d.execute(new d(str));
    }

    /* access modifiers changed from: private */
    public final String b() {
        String str = "";
        try {
            SharedPreferences a2 = a();
            b g2 = g(a2.getString("channel_id", (String) null));
            b g3 = g(a2.getString("token_first5_last5", (String) null));
            b g4 = g(a2.getString("token_log", (String) null));
            b g5 = g(a2.getString("push_log", (String) null));
            ArrayList arrayList = new ArrayList();
            c(arrayList, g2.f43008a);
            b(arrayList, g3.f43008a);
            a((ArrayList<c>) arrayList, g4.f43008a);
            a((ArrayList<c>) arrayList, g5.f43008a);
            List list = arrayList;
            if (list.size() > 1) {
                kotlin.a.k.a(list, new C0718a());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                str = str + '[' + a(cVar.f43009a) + "] " + cVar.f43010b + " \n";
            }
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
        return str;
    }

    /* access modifiers changed from: private */
    public final ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            SharedPreferences a2 = a();
            b g2 = g(a2.getString("channel_id", (String) null));
            b g3 = g(a2.getString("token_first5_last5", (String) null));
            b g4 = g(a2.getString("token_log", (String) null));
            b g5 = g(a2.getString("push_log", (String) null));
            ArrayList arrayList2 = new ArrayList();
            c(arrayList2, g2.f43008a);
            b(arrayList2, g3.f43008a);
            a((ArrayList<c>) arrayList2, g4.f43008a);
            a((ArrayList<c>) arrayList2, g5.f43008a);
            List list = arrayList2;
            if (list.size() > 1) {
                kotlin.a.k.a(list, new b());
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                String a3 = a(cVar.f43009a);
                arrayList.add("[" + a3 + "] " + cVar.f43010b);
            }
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
        return arrayList;
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43007a;

        g(String str) {
            this.f43007a = str;
        }

        public final void run() {
            synchronized (a.class) {
                j.f43241a.a().a(this.f43007a, (ArrayList<String>) a.f42999a.c());
                String b2 = a.f42999a.b();
                e.f43014a.a(b2, new Object[0]);
                g.c cVar = com.paytm.notification.g.f43191a;
                ErrorReportCallback f2 = com.paytm.notification.g.l;
                if (f2 != null) {
                    f2.onError(new Throwable("[ActivityLog] ".concat(String.valueOf(b2))));
                    x xVar = x.f47997a;
                }
            }
        }
    }

    public static void e(String str) {
        k.c(str, "pushId");
        f43002d.execute(new g(str));
    }

    private static String a(long j) {
        String format = new SimpleDateFormat("MM.dd H:mm").format(new Date(j));
        k.a((Object) format, "format.format(date)");
        return format;
    }

    private static void a(ArrayList<c> arrayList, ArrayList<c> arrayList2) {
        Iterator<c> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
    }

    private static void b(ArrayList<c> arrayList, ArrayList<c> arrayList2) {
        Iterator<c> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            next.a("Token: " + next.f43010b);
            arrayList.add(next);
        }
    }

    private static void c(ArrayList<c> arrayList, ArrayList<c> arrayList2) {
        Iterator<c> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            next.a("ChannelId: " + next.f43010b);
            arrayList.add(next);
        }
    }

    /* access modifiers changed from: private */
    public static b g(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return new b(new ArrayList());
        }
        b bVar = (b) f43001c.a(str, b.class);
        if (bVar.f43008a == null) {
            bVar.a(new ArrayList());
        }
        k.a((Object) bVar, "logData");
        return bVar;
    }

    public static final /* synthetic */ String a(b bVar, String str) {
        bVar.f43008a.add(new c(System.currentTimeMillis(), str));
        String b2 = f43001c.b(bVar);
        k.a((Object) b2, "gson.toJson(logData)");
        return b2;
    }
}
