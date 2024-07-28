package com.alipay.plus.android.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class b<Listener> {

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, List<Listener>> f15162a = new HashMap();

    public final synchronized void a(String str, Listener listener) {
        List list = this.f15162a.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f15162a.put(str, list);
        }
        list.add(listener);
    }
}
