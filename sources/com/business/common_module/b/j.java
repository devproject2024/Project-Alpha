package com.business.common_module.b;

import android.content.Context;
import android.util.Pair;
import java.util.List;

public interface j {
    int a(Context context, String str);

    void a(Context context, String str, int i2);

    void a(Context context, String str, long j);

    void a(Context context, String str, String str2);

    void a(Context context, String str, boolean z);

    void a(Context context, List<String> list);

    long b(Context context, String str, long j);

    String b(Context context, String str, String str2);

    void b(Context context, List<? extends Pair<String, Object>> list);

    boolean b(Context context, String str, boolean z);
}
