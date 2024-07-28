package org.apache.xml.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Init {

    /* renamed from: a  reason: collision with root package name */
    static Log f72524a;

    /* renamed from: b  reason: collision with root package name */
    static Class f72525b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f72526c = false;

    static {
        Class cls = f72525b;
        if (cls == null) {
            cls = a("org.apache.xml.security.Init");
            f72525b = cls;
        }
        f72524a = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public static final boolean a() {
        return f72526c;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x01c2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b() {
        /*
            java.lang.Class<org.apache.xml.security.Init> r1 = org.apache.xml.security.Init.class
            monitor-enter(r1)
            boolean r2 = f72526c     // Catch:{ all -> 0x05c1 }
            if (r2 == 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            r2 = 1
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            javax.xml.parsers.DocumentBuilderFactory r11 = javax.xml.parsers.DocumentBuilderFactory.newInstance()     // Catch:{ Exception -> 0x05b0 }
            r11.setNamespaceAware(r2)     // Catch:{ Exception -> 0x05b0 }
            r12 = 0
            r11.setValidating(r12)     // Catch:{ Exception -> 0x05b0 }
            javax.xml.parsers.DocumentBuilder r11 = r11.newDocumentBuilder()     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.Init$1 r13 = new org.apache.xml.security.Init$1     // Catch:{ Exception -> 0x05b0 }
            r13.<init>()     // Catch:{ Exception -> 0x05b0 }
            java.lang.Object r13 = java.security.AccessController.doPrivileged(r13)     // Catch:{ Exception -> 0x05b0 }
            java.io.InputStream r13 = (java.io.InputStream) r13     // Catch:{ Exception -> 0x05b0 }
            org.w3c.dom.Document r11 = r11.parse(r13)     // Catch:{ Exception -> 0x05b0 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.keys.KeyInfo.a()     // Catch:{ Exception -> 0x05aa }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.w3c.dom.Node r11 = r11.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
        L_0x004b:
            if (r11 == 0) goto L_0x0060
            java.lang.String r12 = "Configuration"
            java.lang.String r2 = r11.getLocalName()     // Catch:{ Exception -> 0x05b0 }
            boolean r2 = r12.equals(r2)     // Catch:{ Exception -> 0x05b0 }
            if (r2 != 0) goto L_0x0060
            org.w3c.dom.Node r11 = r11.getNextSibling()     // Catch:{ Exception -> 0x05b0 }
            r2 = 1
            r12 = 0
            goto L_0x004b
        L_0x0060:
            org.w3c.dom.Node r2 = r11.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
            r11 = 0
            r19 = r11
            r21 = r19
            r23 = r21
            r25 = r23
            r27 = r25
            r29 = r27
            r31 = r29
            r33 = r31
            r35 = r33
            r37 = r35
            r39 = r37
            r41 = r39
            r43 = r41
            r45 = r43
            r47 = r45
        L_0x0084:
            if (r2 == 0) goto L_0x0453
            if (r2 == 0) goto L_0x043d
            r49 = r15
            short r15 = r2.getNodeType()     // Catch:{ Exception -> 0x05b0 }
            r51 = r11
            r11 = 1
            if (r11 != r15) goto L_0x0438
            java.lang.String r11 = r2.getLocalName()     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = "ResourceBundles"
            boolean r12 = r11.equals(r12)     // Catch:{ Exception -> 0x05b0 }
            if (r12 == 0) goto L_0x00ce
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            r12 = r2
            org.w3c.dom.Element r12 = (org.w3c.dom.Element) r12     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "defaultLanguageCode"
            org.w3c.dom.Attr r15 = r12.getAttributeNode(r15)     // Catch:{ Exception -> 0x05b0 }
            r53 = r9
            java.lang.String r9 = "defaultCountryCode"
            org.w3c.dom.Attr r9 = r12.getAttributeNode(r9)     // Catch:{ Exception -> 0x05b0 }
            if (r15 != 0) goto L_0x00b8
            r15 = 0
            goto L_0x00bc
        L_0x00b8:
            java.lang.String r15 = r15.getNodeValue()     // Catch:{ Exception -> 0x05b0 }
        L_0x00bc:
            if (r9 != 0) goto L_0x00c0
            r9 = 0
            goto L_0x00c4
        L_0x00c0:
            java.lang.String r9 = r9.getNodeValue()     // Catch:{ Exception -> 0x05b0 }
        L_0x00c4:
            org.apache.xml.security.utils.I18n.a((java.lang.String) r15, (java.lang.String) r9)     // Catch:{ Exception -> 0x05b0 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            r51 = r9
            goto L_0x00d0
        L_0x00ce:
            r53 = r9
        L_0x00d0:
            java.lang.String r9 = "CanonicalizationMethods"
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x015a
            long r23 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.c14n.Canonicalizer.a()     // Catch:{ Exception -> 0x05b0 }
            org.w3c.dom.Node r9 = r2.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = "http://www.xmlsecurity.org/NS/#configuration"
            java.lang.String r15 = "CanonicalizationMethod"
            org.w3c.dom.Element[] r9 = org.apache.xml.security.utils.XMLUtils.a((org.w3c.dom.Node) r9, (java.lang.String) r12, (java.lang.String) r15)     // Catch:{ Exception -> 0x05b0 }
            r12 = 0
        L_0x00ec:
            int r15 = r9.length     // Catch:{ Exception -> 0x05b0 }
            if (r12 >= r15) goto L_0x0153
            r15 = r9[r12]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r10 = "URI"
            r56 = r13
            r13 = 0
            java.lang.String r10 = r15.getAttributeNS(r13, r10)     // Catch:{ Exception -> 0x05b0 }
            r14 = r9[r12]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "JAVACLASS"
            java.lang.String r14 = r14.getAttributeNS(r13, r15)     // Catch:{ Exception -> 0x05b0 }
            java.lang.Class.forName(r14)     // Catch:{ ClassNotFoundException -> 0x0136 }
            org.apache.commons.logging.Log r13 = f72524a     // Catch:{ ClassNotFoundException -> 0x0136 }
            boolean r13 = r13.isDebugEnabled()     // Catch:{ ClassNotFoundException -> 0x0136 }
            if (r13 == 0) goto L_0x0130
            org.apache.commons.logging.Log r13 = f72524a     // Catch:{ ClassNotFoundException -> 0x0136 }
            java.lang.StringBuffer r15 = new java.lang.StringBuffer     // Catch:{ ClassNotFoundException -> 0x0136 }
            r21 = r9
            java.lang.String r9 = "Canonicalizer.register("
            r15.<init>(r9)     // Catch:{ ClassNotFoundException -> 0x0138 }
            r15.append(r10)     // Catch:{ ClassNotFoundException -> 0x0138 }
            java.lang.String r9 = ", "
            r15.append(r9)     // Catch:{ ClassNotFoundException -> 0x0138 }
            r15.append(r14)     // Catch:{ ClassNotFoundException -> 0x0138 }
            java.lang.String r9 = ")"
            r15.append(r9)     // Catch:{ ClassNotFoundException -> 0x0138 }
            java.lang.String r9 = r15.toString()     // Catch:{ ClassNotFoundException -> 0x0138 }
            r13.debug(r9)     // Catch:{ ClassNotFoundException -> 0x0138 }
            goto L_0x0132
        L_0x0130:
            r21 = r9
        L_0x0132:
            org.apache.xml.security.c14n.Canonicalizer.a((java.lang.String) r10, (java.lang.String) r14)     // Catch:{ ClassNotFoundException -> 0x0138 }
            goto L_0x014c
        L_0x0136:
            r21 = r9
        L_0x0138:
            r9 = 2
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05b0 }
            r9 = 0
            r13[r9] = r10     // Catch:{ Exception -> 0x05b0 }
            r9 = 1
            r13[r9] = r14     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r9 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r10 = "algorithm.classDoesNotExist"
            java.lang.String r10 = org.apache.xml.security.utils.I18n.a((java.lang.String) r10, (java.lang.Object[]) r13)     // Catch:{ Exception -> 0x05b0 }
            r9.fatal(r10)     // Catch:{ Exception -> 0x05b0 }
        L_0x014c:
            int r12 = r12 + 1
            r9 = r21
            r13 = r56
            goto L_0x00ec
        L_0x0153:
            r56 = r13
            long r21 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            goto L_0x015c
        L_0x015a:
            r56 = r13
        L_0x015c:
            java.lang.String r9 = "TransformAlgorithms"
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x01e9
            long r47 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.transforms.Transform.a()     // Catch:{ Exception -> 0x05b0 }
            org.w3c.dom.Node r9 = r2.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r10 = "http://www.xmlsecurity.org/NS/#configuration"
            java.lang.String r12 = "TransformAlgorithm"
            org.w3c.dom.Element[] r9 = org.apache.xml.security.utils.XMLUtils.a((org.w3c.dom.Node) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ Exception -> 0x05b0 }
            r10 = 0
        L_0x0178:
            int r12 = r9.length     // Catch:{ Exception -> 0x05b0 }
            if (r10 >= r12) goto L_0x01e5
            r12 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = "URI"
            r14 = 0
            java.lang.String r12 = r12.getAttributeNS(r14, r13)     // Catch:{ Exception -> 0x05b0 }
            r13 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "JAVACLASS"
            java.lang.String r13 = r13.getAttributeNS(r14, r15)     // Catch:{ Exception -> 0x05b0 }
            java.lang.Class.forName(r13)     // Catch:{ ClassNotFoundException -> 0x01ca, NoClassDefFoundError -> 0x01c0 }
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ ClassNotFoundException -> 0x01ca, NoClassDefFoundError -> 0x01c0 }
            boolean r14 = r14.isDebugEnabled()     // Catch:{ ClassNotFoundException -> 0x01ca, NoClassDefFoundError -> 0x01c0 }
            if (r14 == 0) goto L_0x01ba
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ ClassNotFoundException -> 0x01ca, NoClassDefFoundError -> 0x01c0 }
            java.lang.StringBuffer r15 = new java.lang.StringBuffer     // Catch:{ ClassNotFoundException -> 0x01ca, NoClassDefFoundError -> 0x01c0 }
            r45 = r9
            java.lang.String r9 = "Transform.register("
            r15.<init>(r9)     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            r15.append(r12)     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            java.lang.String r9 = ", "
            r15.append(r9)     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            r15.append(r13)     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            java.lang.String r9 = ")"
            r15.append(r9)     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            java.lang.String r9 = r15.toString()     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            r14.debug(r9)     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            goto L_0x01bc
        L_0x01ba:
            r45 = r9
        L_0x01bc:
            org.apache.xml.security.transforms.Transform.a((java.lang.String) r12, (java.lang.String) r13)     // Catch:{ ClassNotFoundException -> 0x01cc, NoClassDefFoundError -> 0x01c2 }
            goto L_0x01e0
        L_0x01c0:
            r45 = r9
        L_0x01c2:
            org.apache.commons.logging.Log r9 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = "Not able to found dependecies for algorithm, I'm keep working."
            r9.warn(r12)     // Catch:{ Exception -> 0x05b0 }
            goto L_0x01e0
        L_0x01ca:
            r45 = r9
        L_0x01cc:
            r9 = 2
            java.lang.Object[] r14 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05b0 }
            r9 = 0
            r14[r9] = r12     // Catch:{ Exception -> 0x05b0 }
            r9 = 1
            r14[r9] = r13     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r9 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = "algorithm.classDoesNotExist"
            java.lang.String r12 = org.apache.xml.security.utils.I18n.a((java.lang.String) r12, (java.lang.Object[]) r14)     // Catch:{ Exception -> 0x05b0 }
            r9.fatal(r12)     // Catch:{ Exception -> 0x05b0 }
        L_0x01e0:
            int r10 = r10 + 1
            r9 = r45
            goto L_0x0178
        L_0x01e5:
            long r45 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
        L_0x01e9:
            java.lang.String r9 = "JCEAlgorithmMappings"
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x01ff
            long r27 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            r9 = r2
            org.w3c.dom.Element r9 = (org.w3c.dom.Element) r9     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.algorithms.JCEMapper.a((org.w3c.dom.Element) r9)     // Catch:{ Exception -> 0x05b0 }
            long r25 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
        L_0x01ff:
            java.lang.String r9 = "SignatureAlgorithms"
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x0286
            long r43 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.algorithms.SignatureAlgorithm.h()     // Catch:{ Exception -> 0x05b0 }
            org.w3c.dom.Node r9 = r2.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r10 = "http://www.xmlsecurity.org/NS/#configuration"
            java.lang.String r12 = "SignatureAlgorithm"
            org.w3c.dom.Element[] r9 = org.apache.xml.security.utils.XMLUtils.a((org.w3c.dom.Node) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ Exception -> 0x05b0 }
            r10 = 0
        L_0x021b:
            int r12 = r9.length     // Catch:{ Exception -> 0x05b0 }
            if (r10 >= r12) goto L_0x0280
            r12 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = "URI"
            r14 = 0
            java.lang.String r12 = r12.getAttributeNS(r14, r13)     // Catch:{ Exception -> 0x05b0 }
            r13 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "JAVACLASS"
            java.lang.String r13 = r13.getAttributeNS(r14, r15)     // Catch:{ Exception -> 0x05b0 }
            java.lang.Class.forName(r13)     // Catch:{ ClassNotFoundException -> 0x0265 }
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ ClassNotFoundException -> 0x0265 }
            boolean r14 = r14.isDebugEnabled()     // Catch:{ ClassNotFoundException -> 0x0265 }
            if (r14 == 0) goto L_0x025d
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ ClassNotFoundException -> 0x0265 }
            java.lang.StringBuffer r15 = new java.lang.StringBuffer     // Catch:{ ClassNotFoundException -> 0x0265 }
            r41 = r9
            java.lang.String r9 = "SignatureAlgorithm.register("
            r15.<init>(r9)     // Catch:{ ClassNotFoundException -> 0x0267 }
            r15.append(r12)     // Catch:{ ClassNotFoundException -> 0x0267 }
            java.lang.String r9 = ", "
            r15.append(r9)     // Catch:{ ClassNotFoundException -> 0x0267 }
            r15.append(r13)     // Catch:{ ClassNotFoundException -> 0x0267 }
            java.lang.String r9 = ")"
            r15.append(r9)     // Catch:{ ClassNotFoundException -> 0x0267 }
            java.lang.String r9 = r15.toString()     // Catch:{ ClassNotFoundException -> 0x0267 }
            r14.debug(r9)     // Catch:{ ClassNotFoundException -> 0x0267 }
            goto L_0x025f
        L_0x025d:
            r41 = r9
        L_0x025f:
            org.apache.xml.security.algorithms.SignatureAlgorithm.a(r12, r13)     // Catch:{ ClassNotFoundException -> 0x0267 }
            r9 = 2
            r15 = 0
            goto L_0x027b
        L_0x0265:
            r41 = r9
        L_0x0267:
            r9 = 2
            java.lang.Object[] r14 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05b0 }
            r15 = 0
            r14[r15] = r12     // Catch:{ Exception -> 0x05b0 }
            r12 = 1
            r14[r12] = r13     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r12 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = "algorithm.classDoesNotExist"
            java.lang.String r13 = org.apache.xml.security.utils.I18n.a((java.lang.String) r13, (java.lang.Object[]) r14)     // Catch:{ Exception -> 0x05b0 }
            r12.fatal(r13)     // Catch:{ Exception -> 0x05b0 }
        L_0x027b:
            int r10 = r10 + 1
            r9 = r41
            goto L_0x021b
        L_0x0280:
            r15 = 0
            long r41 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            goto L_0x0287
        L_0x0286:
            r15 = 0
        L_0x0287:
            java.lang.String r9 = "ResourceResolvers"
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x0333
            long r39 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.utils.resolver.ResourceResolver.a()     // Catch:{ Exception -> 0x05b0 }
            org.w3c.dom.Node r9 = r2.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r10 = "http://www.xmlsecurity.org/NS/#configuration"
            java.lang.String r12 = "Resolver"
            org.w3c.dom.Element[] r9 = org.apache.xml.security.utils.XMLUtils.a((org.w3c.dom.Node) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ Exception -> 0x05b0 }
            r10 = 0
        L_0x02a3:
            int r12 = r9.length     // Catch:{ Exception -> 0x05b0 }
            if (r10 >= r12) goto L_0x0333
            r12 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = "JAVACLASS"
            r14 = 0
            java.lang.String r12 = r12.getAttributeNS(r14, r13)     // Catch:{ Exception -> 0x05b0 }
            r13 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "DESCRIPTION"
            java.lang.String r13 = r13.getAttributeNS(r14, r15)     // Catch:{ Exception -> 0x05b0 }
            if (r13 == 0) goto L_0x02e8
            int r14 = r13.length()     // Catch:{ Exception -> 0x05b0 }
            if (r14 <= 0) goto L_0x02e8
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ Exception -> 0x05b0 }
            boolean r14 = r14.isDebugEnabled()     // Catch:{ Exception -> 0x05b0 }
            if (r14 == 0) goto L_0x02e5
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r15 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            r55 = r9
            java.lang.String r9 = "Register Resolver: "
            r15.<init>(r9)     // Catch:{ Exception -> 0x05b0 }
            r15.append(r12)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r9 = ": "
            r15.append(r9)     // Catch:{ Exception -> 0x05b0 }
            r15.append(r13)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r9 = r15.toString()     // Catch:{ Exception -> 0x05b0 }
            r14.debug(r9)     // Catch:{ Exception -> 0x05b0 }
            goto L_0x030a
        L_0x02e5:
            r55 = r9
            goto L_0x030a
        L_0x02e8:
            r55 = r9
            org.apache.commons.logging.Log r9 = f72524a     // Catch:{ Exception -> 0x05b0 }
            boolean r9 = r9.isDebugEnabled()     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x030a
            org.apache.commons.logging.Log r9 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r13 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r14 = "Register Resolver: "
            r13.<init>(r14)     // Catch:{ Exception -> 0x05b0 }
            r13.append(r12)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r14 = ": For unknown purposes"
            r13.append(r14)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x05b0 }
            r9.debug(r13)     // Catch:{ Exception -> 0x05b0 }
        L_0x030a:
            org.apache.xml.security.utils.resolver.ResourceResolver.a((java.lang.String) r12)     // Catch:{ all -> 0x030e }
            goto L_0x0328
        L_0x030e:
            r0 = move-exception
            r9 = r0
            org.apache.commons.logging.Log r13 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r14 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "Cannot register:"
            r14.<init>(r15)     // Catch:{ Exception -> 0x05b0 }
            r14.append(r12)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = " perhaps some needed jars are not installed"
            r14.append(r12)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = r14.toString()     // Catch:{ Exception -> 0x05b0 }
            r13.warn(r12, r9)     // Catch:{ Exception -> 0x05b0 }
        L_0x0328:
            long r37 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            int r10 = r10 + 1
            r9 = r55
            r15 = 0
            goto L_0x02a3
        L_0x0333:
            java.lang.String r9 = "KeyResolver"
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x03c2
            long r31 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.xml.security.keys.keyresolver.KeyResolver.a()     // Catch:{ Exception -> 0x05b0 }
            org.w3c.dom.Node r9 = r2.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r10 = "http://www.xmlsecurity.org/NS/#configuration"
            java.lang.String r12 = "Resolver"
            org.w3c.dom.Element[] r9 = org.apache.xml.security.utils.XMLUtils.a((org.w3c.dom.Node) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ Exception -> 0x05b0 }
            r10 = 0
        L_0x034f:
            int r12 = r9.length     // Catch:{ Exception -> 0x05b0 }
            if (r10 >= r12) goto L_0x03be
            r12 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = "JAVACLASS"
            r14 = 0
            java.lang.String r12 = r12.getAttributeNS(r14, r13)     // Catch:{ Exception -> 0x05b0 }
            r13 = r9[r10]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "DESCRIPTION"
            java.lang.String r13 = r13.getAttributeNS(r14, r15)     // Catch:{ Exception -> 0x05b0 }
            if (r13 == 0) goto L_0x0394
            int r14 = r13.length()     // Catch:{ Exception -> 0x05b0 }
            if (r14 <= 0) goto L_0x0394
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ Exception -> 0x05b0 }
            boolean r14 = r14.isDebugEnabled()     // Catch:{ Exception -> 0x05b0 }
            if (r14 == 0) goto L_0x0391
            org.apache.commons.logging.Log r14 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r15 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            r29 = r9
            java.lang.String r9 = "Register Resolver: "
            r15.<init>(r9)     // Catch:{ Exception -> 0x05b0 }
            r15.append(r12)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r9 = ": "
            r15.append(r9)     // Catch:{ Exception -> 0x05b0 }
            r15.append(r13)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r9 = r15.toString()     // Catch:{ Exception -> 0x05b0 }
            r14.debug(r9)     // Catch:{ Exception -> 0x05b0 }
            goto L_0x03b6
        L_0x0391:
            r29 = r9
            goto L_0x03b6
        L_0x0394:
            r29 = r9
            org.apache.commons.logging.Log r9 = f72524a     // Catch:{ Exception -> 0x05b0 }
            boolean r9 = r9.isDebugEnabled()     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x03b6
            org.apache.commons.logging.Log r9 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r13 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r14 = "Register Resolver: "
            r13.<init>(r14)     // Catch:{ Exception -> 0x05b0 }
            r13.append(r12)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r14 = ": For unknown purposes"
            r13.append(r14)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x05b0 }
            r9.debug(r13)     // Catch:{ Exception -> 0x05b0 }
        L_0x03b6:
            org.apache.xml.security.keys.keyresolver.KeyResolver.a(r12)     // Catch:{ Exception -> 0x05b0 }
            int r10 = r10 + 1
            r9 = r29
            goto L_0x034f
        L_0x03be:
            long r29 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
        L_0x03c2:
            java.lang.String r9 = "PrefixMappings"
            boolean r9 = r11.equals(r9)     // Catch:{ Exception -> 0x05b0 }
            if (r9 == 0) goto L_0x0445
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r11 = f72524a     // Catch:{ Exception -> 0x05b0 }
            boolean r11 = r11.isDebugEnabled()     // Catch:{ Exception -> 0x05b0 }
            if (r11 == 0) goto L_0x03dd
            org.apache.commons.logging.Log r11 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = "Now I try to bind prefixes:"
            r11.debug(r12)     // Catch:{ Exception -> 0x05b0 }
        L_0x03dd:
            org.w3c.dom.Node r11 = r2.getFirstChild()     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = "http://www.xmlsecurity.org/NS/#configuration"
            java.lang.String r13 = "PrefixMapping"
            org.w3c.dom.Element[] r11 = org.apache.xml.security.utils.XMLUtils.a((org.w3c.dom.Node) r11, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ Exception -> 0x05b0 }
            r12 = 0
        L_0x03ea:
            int r13 = r11.length     // Catch:{ Exception -> 0x05b0 }
            if (r12 >= r13) goto L_0x042b
            r13 = r11[r12]     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r14 = "namespace"
            r15 = 0
            java.lang.String r13 = r13.getAttributeNS(r15, r14)     // Catch:{ Exception -> 0x05b0 }
            r14 = r11[r12]     // Catch:{ Exception -> 0x05b0 }
            r33 = r9
            java.lang.String r9 = "prefix"
            java.lang.String r9 = r14.getAttributeNS(r15, r9)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r10 = f72524a     // Catch:{ Exception -> 0x05b0 }
            boolean r10 = r10.isDebugEnabled()     // Catch:{ Exception -> 0x05b0 }
            if (r10 == 0) goto L_0x0423
            org.apache.commons.logging.Log r10 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r14 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = "Now I try to bind "
            r14.<init>(r15)     // Catch:{ Exception -> 0x05b0 }
            r14.append(r9)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r15 = " to "
            r14.append(r15)     // Catch:{ Exception -> 0x05b0 }
            r14.append(r13)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x05b0 }
            r10.debug(r14)     // Catch:{ Exception -> 0x05b0 }
        L_0x0423:
            org.apache.xml.security.utils.ElementProxy.d(r13, r9)     // Catch:{ Exception -> 0x05b0 }
            int r12 = r12 + 1
            r9 = r33
            goto L_0x03ea
        L_0x042b:
            r33 = r9
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            r35 = r33
            r11 = r51
            r33 = r9
            goto L_0x0447
        L_0x0438:
            r53 = r9
            r56 = r13
            goto L_0x0445
        L_0x043d:
            r53 = r9
            r51 = r11
            r56 = r13
            r49 = r15
        L_0x0445:
            r11 = r51
        L_0x0447:
            org.w3c.dom.Node r2 = r2.getNextSibling()     // Catch:{ Exception -> 0x05b0 }
            r15 = r49
            r9 = r53
            r13 = r56
            goto L_0x0084
        L_0x0453:
            r53 = r9
            r51 = r11
            r56 = r13
            r49 = r15
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            boolean r2 = r2.isDebugEnabled()     // Catch:{ Exception -> 0x05b0 }
            if (r2 == 0) goto L_0x05bc
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r11 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r12 = "XX_init                             "
            r11.<init>(r12)     // Catch:{ Exception -> 0x05b0 }
            long r9 = r9 - r3
            int r3 = (int) r9     // Catch:{ Exception -> 0x05b0 }
            r11.append(r3)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = " ms"
            r11.append(r3)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r11.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_prng                           "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r7 = r7 - r5
            int r4 = (int) r7     // Catch:{ Exception -> 0x05b0 }
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_parsing                        "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r13 = r56 - r53
            int r4 = (int) r13     // Catch:{ Exception -> 0x05b0 }
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_i18n                 "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r11 = r51 - r19
            int r4 = (int) r11     // Catch:{ Exception -> 0x05b0 }
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_c14n             "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r21 - r23
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_jcemapper        "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r25 - r27
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_keyInfo          "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r17 - r49
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_keyResolver      "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r29 - r31
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_prefixes         "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r33 - r35
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_resourceresolver "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r37 - r39
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_sigalgos         "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r41 - r43
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            org.apache.commons.logging.Log r2 = f72524a     // Catch:{ Exception -> 0x05b0 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = "  XX_configure_reg_transforms       "
            r3.<init>(r4)     // Catch:{ Exception -> 0x05b0 }
            long r4 = r45 - r47
            int r5 = (int) r4     // Catch:{ Exception -> 0x05b0 }
            r3.append(r5)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r4 = " ms"
            r3.append(r4)     // Catch:{ Exception -> 0x05b0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05b0 }
            r2.debug(r3)     // Catch:{ Exception -> 0x05b0 }
            goto L_0x05bc
        L_0x05aa:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()     // Catch:{ Exception -> 0x05b0 }
            throw r2     // Catch:{ Exception -> 0x05b0 }
        L_0x05b0:
            r0 = move-exception
            r2 = r0
            org.apache.commons.logging.Log r3 = f72524a     // Catch:{ all -> 0x05c1 }
            java.lang.String r4 = "Bad: "
            r3.fatal(r4, r2)     // Catch:{ all -> 0x05c1 }
            r2.printStackTrace()     // Catch:{ all -> 0x05c1 }
        L_0x05bc:
            r2 = 1
            f72526c = r2     // Catch:{ all -> 0x05c1 }
            monitor-exit(r1)
            return
        L_0x05c1:
            r0 = move-exception
            r2 = r0
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.Init.b():void");
    }
}
