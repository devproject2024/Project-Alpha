package com.travel.citybus;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import net.one97.paytm.common.entity.CJRPGTokenList;

public interface a {
    ContextWrapper a(Context context);

    String a();

    String a(String str);

    String a(CJRPGTokenList cJRPGTokenList);

    void a(Context context, Intent intent);

    boolean a(Object obj);

    String b();

    String b(Object obj);

    void b(Context context, Intent intent);

    String c();

    void c(Context context, Intent intent);

    void d(Context context, Intent intent);
}
