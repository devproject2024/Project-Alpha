package com.alipay.mobile.a;

import android.util.Pair;

public interface a {
    void onExecutionAfter(String str, Object obj, Object[] objArr);

    Pair<Boolean, Object> onExecutionAround(String str, Object obj, Object[] objArr);

    void onExecutionBefore(String str, Object obj, Object[] objArr);
}
