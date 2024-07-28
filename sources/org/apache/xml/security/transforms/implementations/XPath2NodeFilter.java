package org.apache.xml.security.transforms.implementations;

import java.util.Iterator;
import java.util.Set;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Node;

class XPath2NodeFilter implements NodeFilter {

    /* renamed from: a  reason: collision with root package name */
    boolean f72736a;

    /* renamed from: b  reason: collision with root package name */
    boolean f72737b;

    /* renamed from: c  reason: collision with root package name */
    boolean f72738c;

    /* renamed from: d  reason: collision with root package name */
    Set f72739d;

    /* renamed from: e  reason: collision with root package name */
    Set f72740e;

    /* renamed from: f  reason: collision with root package name */
    Set f72741f;

    /* renamed from: g  reason: collision with root package name */
    int f72742g = -1;

    /* renamed from: h  reason: collision with root package name */
    int f72743h = -1;

    /* renamed from: i  reason: collision with root package name */
    int f72744i = -1;

    XPath2NodeFilter(Set set, Set set2, Set set3) {
        this.f72739d = set;
        this.f72736a = !set.isEmpty();
        this.f72740e = set2;
        this.f72737b = !set2.isEmpty();
        this.f72741f = set3;
        this.f72738c = !set3.isEmpty();
    }

    static boolean a(Node node, Set set) {
        if (set.contains(node)) {
            return true;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (XMLUtils.a((Node) it2.next(), node)) {
                return true;
            }
        }
        return false;
    }

    static boolean b(Node node, Set set) {
        return set.contains(node);
    }

    public int a(Node node) {
        int i2 = (!this.f72737b || !a(node, this.f72740e)) ? (!this.f72738c || a(node, this.f72741f)) ? 1 : 0 : -1;
        if (i2 == 1) {
            return 1;
        }
        return this.f72736a ? a(node, this.f72739d) ? 1 : 0 : i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(org.w3c.dom.Node r6, int r7) {
        /*
            r5 = this;
            boolean r0 = r5.f72737b
            r1 = 1
            r2 = -1
            if (r0 == 0) goto L_0x001f
            int r0 = r5.f72742g
            if (r0 == r2) goto L_0x000c
            if (r7 > r0) goto L_0x0019
        L_0x000c:
            java.util.Set r0 = r5.f72740e
            boolean r0 = b(r6, r0)
            if (r0 == 0) goto L_0x0017
            r5.f72742g = r7
            goto L_0x0019
        L_0x0017:
            r5.f72742g = r2
        L_0x0019:
            int r0 = r5.f72742g
            if (r0 == r2) goto L_0x001f
            r0 = -1
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            r3 = 0
            if (r0 == r2) goto L_0x003b
            boolean r4 = r5.f72738c
            if (r4 == 0) goto L_0x003b
            int r4 = r5.f72743h
            if (r4 == r2) goto L_0x002d
            if (r7 > r4) goto L_0x003b
        L_0x002d:
            java.util.Set r4 = r5.f72741f
            boolean r4 = b(r6, r4)
            if (r4 != 0) goto L_0x0039
            r5.f72743h = r2
            r0 = 0
            goto L_0x003b
        L_0x0039:
            r5.f72743h = r7
        L_0x003b:
            int r4 = r5.f72744i
            if (r7 > r4) goto L_0x0041
            r5.f72744i = r2
        L_0x0041:
            if (r0 != r1) goto L_0x0044
            return r1
        L_0x0044:
            boolean r4 = r5.f72736a
            if (r4 == 0) goto L_0x005c
            int r0 = r5.f72744i
            if (r0 != r2) goto L_0x0056
            java.util.Set r0 = r5.f72739d
            boolean r6 = b(r6, r0)
            if (r6 == 0) goto L_0x0056
            r5.f72744i = r7
        L_0x0056:
            int r6 = r5.f72744i
            if (r6 == r2) goto L_0x005b
            return r1
        L_0x005b:
            r0 = 0
        L_0x005c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.transforms.implementations.XPath2NodeFilter.a(org.w3c.dom.Node, int):int");
    }
}
