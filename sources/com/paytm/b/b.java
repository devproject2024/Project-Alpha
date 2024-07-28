package com.paytm.b;

import com.paytm.b.a.a;
import com.paytm.utility.f;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface b {
    void a();

    <T> void a(String str, T t, boolean z);

    void a(String str, Set<String> set, boolean z);

    void a(String str, boolean z);

    void a(HashMap<String, a> hashMap);

    void a(List<String> list);

    void a(List<String> list, f.a aVar);

    <T> T b(String str, T t, boolean z);

    Set<String> b(String str, Set<String> set, boolean z);

    boolean b(String str, boolean z);
}
