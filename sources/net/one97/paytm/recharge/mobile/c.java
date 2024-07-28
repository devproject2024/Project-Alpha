package net.one97.paytm.recharge.mobile;

import java.util.List;
import java.util.Map;
import net.one97.paytm.recharge.common.b.c.d;
import net.one97.paytm.recharge.common.e.ai;
import org.json.JSONObject;

public interface c extends d {
    void a(String str, ai aiVar, String str2, long j, Object obj);

    void a(String str, ai aiVar, String str2, long j, String str3, String str4, Object obj, boolean z);

    void a(String str, ai aiVar, String str2, String str3, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, Object obj);

    void a(String str, ai aiVar, String str2, String str3, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, String str4, int i2, int i3, boolean z, Object obj);

    void a(String str, ai aiVar, String str2, JSONObject jSONObject, String str3, String[] strArr, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, Object obj);

    void e(String str, ai aiVar, String str2, Object obj);

    void f(String str, ai aiVar, String str2, Object obj);
}
