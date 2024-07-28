package org.apache.xml.security.utils.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.w3c.dom.Attr;

public class ResourceResolver {

    /* renamed from: a  reason: collision with root package name */
    static Log f72798a;

    /* renamed from: b  reason: collision with root package name */
    static boolean f72799b = false;

    /* renamed from: c  reason: collision with root package name */
    static List f72800c = null;

    /* renamed from: d  reason: collision with root package name */
    static boolean f72801d = true;

    /* renamed from: f  reason: collision with root package name */
    static Class f72802f;

    /* renamed from: e  reason: collision with root package name */
    protected ResourceResolverSpi f72803e = null;

    static {
        Class cls = f72802f;
        if (cls == null) {
            cls = b("org.apache.xml.security.utils.resolver.ResourceResolver");
            f72802f = cls;
        }
        f72798a = LogFactory.getLog(cls.getName());
    }

    private ResourceResolver(String str) {
        this.f72803e = (ResourceResolverSpi) Class.forName(str).newInstance();
    }

    public ResourceResolver(ResourceResolverSpi resourceResolverSpi) {
        this.f72803e = resourceResolverSpi;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076 A[LOOP:0: B:1:0x000a->B:20:0x0076, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0061 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.apache.xml.security.utils.resolver.ResourceResolver a(org.w3c.dom.Attr r9, java.lang.String r10) {
        /*
            java.lang.String r0 = ""
            java.util.List r1 = f72800c
            int r1 = r1.size()
            r2 = 0
            r3 = 0
        L_0x000a:
            if (r3 >= r1) goto L_0x0087
            java.util.List r4 = f72800c
            java.lang.Object r4 = r4.get(r3)
            org.apache.xml.security.utils.resolver.ResourceResolver r4 = (org.apache.xml.security.utils.resolver.ResourceResolver) r4
            boolean r5 = f72801d     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            if (r5 != 0) goto L_0x0033
            org.apache.xml.security.utils.resolver.ResourceResolverSpi r5 = r4.f72803e     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            boolean r5 = r5.a()     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            if (r5 == 0) goto L_0x0021
            goto L_0x0033
        L_0x0021:
            org.apache.xml.security.utils.resolver.ResourceResolver r5 = new org.apache.xml.security.utils.resolver.ResourceResolver     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            org.apache.xml.security.utils.resolver.ResourceResolverSpi r6 = r4.f72803e     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            java.lang.Class r6 = r6.getClass()     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            java.lang.Object r6 = r6.newInstance()     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            org.apache.xml.security.utils.resolver.ResourceResolverSpi r6 = (org.apache.xml.security.utils.resolver.ResourceResolverSpi) r6     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            r5.<init>((org.apache.xml.security.utils.resolver.ResourceResolverSpi) r6)     // Catch:{ InstantiationException -> 0x0080, IllegalAccessException -> 0x0079 }
            goto L_0x0034
        L_0x0033:
            r5 = r4
        L_0x0034:
            org.apache.commons.logging.Log r6 = f72798a
            boolean r6 = r6.isDebugEnabled()
            if (r6 == 0) goto L_0x0059
            org.apache.commons.logging.Log r6 = f72798a
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            java.lang.String r8 = "check resolvability by class "
            r7.<init>(r8)
            org.apache.xml.security.utils.resolver.ResourceResolverSpi r8 = r4.f72803e
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.debug(r7)
        L_0x0059:
            if (r4 == 0) goto L_0x0076
            boolean r6 = r5.c(r9, r10)
            if (r6 == 0) goto L_0x0076
            if (r3 == 0) goto L_0x0075
            java.util.List r9 = f72800c
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            java.lang.Object r9 = r9.clone()
            java.util.List r9 = (java.util.List) r9
            r9.remove(r3)
            r9.add(r2, r4)
            f72800c = r9
        L_0x0075:
            return r5
        L_0x0076:
            int r3 = r3 + 1
            goto L_0x000a
        L_0x0079:
            r1 = move-exception
            org.apache.xml.security.utils.resolver.ResourceResolverException r2 = new org.apache.xml.security.utils.resolver.ResourceResolverException
            r2.<init>((java.lang.String) r0, (java.lang.Exception) r1, (org.w3c.dom.Attr) r9, (java.lang.String) r10)
            throw r2
        L_0x0080:
            r1 = move-exception
            org.apache.xml.security.utils.resolver.ResourceResolverException r2 = new org.apache.xml.security.utils.resolver.ResourceResolverException
            r2.<init>((java.lang.String) r0, (java.lang.Exception) r1, (org.w3c.dom.Attr) r9, (java.lang.String) r10)
            throw r2
        L_0x0087:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            if (r9 == 0) goto L_0x0091
            java.lang.String r1 = r9.getNodeValue()
            goto L_0x0093
        L_0x0091:
            java.lang.String r1 = "null"
        L_0x0093:
            r0[r2] = r1
            r1 = 1
            r0[r1] = r10
            org.apache.xml.security.utils.resolver.ResourceResolverException r1 = new org.apache.xml.security.utils.resolver.ResourceResolverException
            java.lang.String r2 = "utils.resolver.noClass"
            r1.<init>((java.lang.String) r2, (java.lang.Object[]) r0, (org.w3c.dom.Attr) r9, (java.lang.String) r10)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.resolver.ResourceResolver.a(org.w3c.dom.Attr, java.lang.String):org.apache.xml.security.utils.resolver.ResourceResolver");
    }

    public static final ResourceResolver a(Attr attr, String str, List list) {
        int size;
        if (f72798a.isDebugEnabled()) {
            Log log = f72798a;
            StringBuffer stringBuffer = new StringBuffer("I was asked to create a ResourceResolver and got ");
            stringBuffer.append(list == null ? 0 : list.size());
            log.debug(stringBuffer.toString());
            Log log2 = f72798a;
            StringBuffer stringBuffer2 = new StringBuffer(" extra resolvers to my existing ");
            stringBuffer2.append(f72800c.size());
            stringBuffer2.append(" system-wide resolvers");
            log2.debug(stringBuffer2.toString());
        }
        if (list != null && (size = list.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                ResourceResolver resourceResolver = (ResourceResolver) list.get(i2);
                if (resourceResolver != null) {
                    String name = resourceResolver.f72803e.getClass().getName();
                    if (f72798a.isDebugEnabled()) {
                        f72798a.debug("check resolvability by class ".concat(String.valueOf(name)));
                    }
                    if (resourceResolver.c(attr, str)) {
                        return resourceResolver;
                    }
                }
            }
        }
        return a(attr, str);
    }

    public static void a() {
        if (!f72799b) {
            f72800c = new ArrayList(10);
            f72799b = true;
        }
    }

    public static void a(String str) {
        a(str, false);
    }

    private static void a(String str, boolean z) {
        Log log;
        StringBuffer stringBuffer;
        try {
            ResourceResolver resourceResolver = new ResourceResolver(str);
            if (z) {
                f72800c.add(0, resourceResolver);
                f72798a.debug("registered resolver");
            } else {
                f72800c.add(resourceResolver);
            }
            if (!resourceResolver.f72803e.a()) {
                f72801d = false;
            }
        } catch (Exception unused) {
            log = f72798a;
            stringBuffer = new StringBuffer("Error loading resolver ");
            stringBuffer.append(str);
            stringBuffer.append(" disabling it");
            log.warn(stringBuffer.toString());
        } catch (NoClassDefFoundError unused2) {
            log = f72798a;
            stringBuffer = new StringBuffer("Error loading resolver ");
            stringBuffer.append(str);
            stringBuffer.append(" disabling it");
            log.warn(stringBuffer.toString());
        }
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private boolean c(Attr attr, String str) {
        return this.f72803e.b(attr, str);
    }

    public void a(Map map) {
        this.f72803e.a(map);
    }

    public XMLSignatureInput b(Attr attr, String str) {
        return this.f72803e.a(attr, str);
    }
}
