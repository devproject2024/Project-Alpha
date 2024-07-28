package net.one97.paytm.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    private static final Context f69603a;

    /* renamed from: b  reason: collision with root package name */
    private static final c f69604b = b.a();

    public static final double a(String str) {
        k.c(str, "receiver$0");
        Double b2 = p.b(str);
        if (b2 != null) {
            return b2.doubleValue();
        }
        return 0.0d;
    }

    public static final void a(Cursor cursor) {
        k.c(cursor, "receiver$0");
        try {
            cursor.close();
        } catch (Exception unused) {
        }
    }

    public static final String b(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length());
        l lVar = new l(" ");
        Collection arrayList = new ArrayList();
        for (Object next : lVar.split(str, 0)) {
            if (true ^ (((String) next).length() == 0)) {
                arrayList.add(next);
            }
        }
        for (String str2 : (List) arrayList) {
            sb.append(Character.toUpperCase(str2.charAt(0)));
            if (str2 != null) {
                String substring = str2.substring(1);
                k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                if (substring != null) {
                    String lowerCase = substring.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    sb.append(lowerCase);
                    sb.append(" ");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        String sb2 = sb.toString();
        k.a((Object) sb2, "ret.toString()");
        if (sb2 != null) {
            return p.b(sb2).toString();
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final void a(View view, boolean z) {
        k.c(view, "receiver$0");
        view.setVisibility(z ? 0 : 8);
    }

    static {
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        Context context = a2.getContext();
        k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
        f69603a = context;
    }

    public static final Context a() {
        return f69603a;
    }

    public static final ActivityManager.MemoryInfo b() {
        Object systemService = f69603a.getSystemService("activity");
        if (systemService != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return memoryInfo;
        }
        throw new u("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public static final boolean a(String str, CharSequence charSequence) {
        k.c(str, "receiver$0");
        k.c(charSequence, "substring");
        Matcher matcher = Pattern.compile(charSequence.toString()).matcher(str);
        return matcher.find() && !matcher.find();
    }

    public static final boolean a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.length() == 0;
        }
    }
}
