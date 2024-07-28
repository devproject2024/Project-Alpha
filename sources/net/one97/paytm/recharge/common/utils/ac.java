package net.one97.paytm.recharge.common.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;

public final class ac extends HashMap<String, String> {
    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return containsKey((String) obj);
    }

    public final /* bridge */ boolean containsKey(String str) {
        return super.containsKey(str);
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj != null ? obj instanceof String : true)) {
            return false;
        }
        return containsValue((String) obj);
    }

    public final /* bridge */ boolean containsValue(String str) {
        return super.containsValue(str);
    }

    public final Set<Map.Entry<String, String>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return get((String) obj);
    }

    public final /* bridge */ String get(String str) {
        return (String) super.get(str);
    }

    public final Set getEntries() {
        return super.entrySet();
    }

    public final Set getKeys() {
        return super.keySet();
    }

    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj != null ? obj instanceof String : true) ? obj2 : getOrDefault((String) obj, (String) obj2);
    }

    public final /* bridge */ String getOrDefault(String str, String str2) {
        return (String) super.getOrDefault(str, str2);
    }

    public final int getSize() {
        return super.size();
    }

    public final Collection getValues() {
        return super.values();
    }

    public final Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return remove((String) obj);
    }

    public final /* bridge */ String remove(String str) {
        return (String) super.remove(str);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        boolean z = true;
        if (!(obj != null ? obj instanceof String : true)) {
            return false;
        }
        if (obj2 != null) {
            z = obj2 instanceof String;
        }
        if (!z) {
            return false;
        }
        return remove((String) obj, (String) obj2);
    }

    public final /* bridge */ boolean remove(String str, String str2) {
        return super.remove(str, str2);
    }

    public final int size() {
        return getSize();
    }

    public final Collection<String> values() {
        return getValues();
    }

    public final String put(String str, String str2) {
        k.c(str, "key");
        String lowerCase = str.toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        return (String) super.put(lowerCase, str2);
    }
}
