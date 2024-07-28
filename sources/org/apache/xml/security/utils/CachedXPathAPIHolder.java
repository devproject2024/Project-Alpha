package org.apache.xml.security.utils;

import org.apache.xpath.CachedXPathAPI;
import org.w3c.dom.Document;

public class CachedXPathAPIHolder {

    /* renamed from: a  reason: collision with root package name */
    static ThreadLocal f72747a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    static ThreadLocal f72748b = new ThreadLocal();

    public static CachedXPathAPI a() {
        CachedXPathAPI cachedXPathAPI = (CachedXPathAPI) f72747a.get();
        if (cachedXPathAPI != null) {
            return cachedXPathAPI;
        }
        CachedXPathAPI cachedXPathAPI2 = new CachedXPathAPI();
        f72747a.set(cachedXPathAPI2);
        f72748b.set((Object) null);
        return cachedXPathAPI2;
    }

    public static void a(Document document) {
        if (f72748b.get() != document) {
            CachedXPathAPI cachedXPathAPI = (CachedXPathAPI) f72747a.get();
            if (cachedXPathAPI == null) {
                f72747a.set(new CachedXPathAPI());
                f72748b.set(document);
                return;
            }
            cachedXPathAPI.getXPathContext().reset();
            f72748b.set(document);
        }
    }
}
