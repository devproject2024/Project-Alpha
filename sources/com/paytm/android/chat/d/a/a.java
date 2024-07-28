package com.paytm.android.chat.d.a;

import com.sendbird.android.GroupChannel;
import java.util.HashMap;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f41891a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, GroupChannel> f41892b = new HashMap<>();

    private a() {
    }

    public static GroupChannel a(String str) {
        return (GroupChannel) f41892b.get(str);
    }

    public static void a(String str, GroupChannel groupChannel) {
        k.c(str, "identifier");
        k.c(groupChannel, "provider");
        f41892b.put(str, groupChannel);
    }
}
