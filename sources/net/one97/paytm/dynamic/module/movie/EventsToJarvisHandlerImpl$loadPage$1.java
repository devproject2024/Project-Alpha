package net.one97.paytm.dynamic.module.movie;

import android.text.TextUtils;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.m.p;

public final class EventsToJarvisHandlerImpl$loadPage$1 extends HashMap<String, Serializable> {
    final /* synthetic */ HashMap $contextParam;
    final /* synthetic */ String $mCurrentPageName;
    final /* synthetic */ String $searchEntity;
    final /* synthetic */ String $searchPageName;

    EventsToJarvisHandlerImpl$loadPage$1(String str, HashMap hashMap, String str2, String str3) {
        this.$searchEntity = str;
        this.$contextParam = hashMap;
        this.$searchPageName = str2;
        this.$mCurrentPageName = str3;
        if (p.a("category", str, true)) {
            put("category", Boolean.TRUE);
        }
        if (hashMap != null) {
            put(CLPConstants.EXTRA_INTENT_CONTEXT_PARAMS_OBJECT, hashMap);
        }
        if (str2 != null) {
            put(CLPConstants.CONTEXT_STORE_CATEGORY_NAME, TextUtils.isEmpty(str3) ? "" : str3);
        }
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj != null ? obj instanceof String : true)) {
            return false;
        }
        return containsKey((String) obj);
    }

    public final /* bridge */ boolean containsKey(String str) {
        return super.containsKey(str);
    }

    public final /* bridge */ boolean containsValue(Serializable serializable) {
        return super.containsValue(serializable);
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj != null ? obj instanceof Serializable : true)) {
            return false;
        }
        return containsValue((Serializable) obj);
    }

    public final Set<Map.Entry<String, Serializable>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Serializable get(String str) {
        return (Serializable) super.get(str);
    }

    public final /* bridge */ Object get(Object obj) {
        if (!(obj != null ? obj instanceof String : true)) {
            return null;
        }
        return get((String) obj);
    }

    public final Set getEntries() {
        return super.entrySet();
    }

    public final Set getKeys() {
        return super.keySet();
    }

    public final /* bridge */ Serializable getOrDefault(String str, Serializable serializable) {
        return (Serializable) super.getOrDefault(str, serializable);
    }

    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj != null ? obj instanceof String : true) ? obj2 : getOrDefault((String) obj, (Serializable) obj2);
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

    public final /* bridge */ Serializable remove(String str) {
        return (Serializable) super.remove(str);
    }

    public final /* bridge */ Object remove(Object obj) {
        if (!(obj != null ? obj instanceof String : true)) {
            return null;
        }
        return remove((String) obj);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        boolean z = true;
        if (!(obj != null ? obj instanceof String : true)) {
            return false;
        }
        if (obj2 != null) {
            z = obj2 instanceof Serializable;
        }
        if (!z) {
            return false;
        }
        return remove((String) obj, (Serializable) obj2);
    }

    public final /* bridge */ boolean remove(String str, Serializable serializable) {
        return super.remove(str, serializable);
    }

    public final int size() {
        return getSize();
    }

    public final Collection<Serializable> values() {
        return getValues();
    }
}
