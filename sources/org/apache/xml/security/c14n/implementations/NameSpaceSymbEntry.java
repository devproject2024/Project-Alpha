package org.apache.xml.security.c14n.implementations;

import org.w3c.dom.Attr;

class NameSpaceSymbEntry implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    int f72600a = 0;

    /* renamed from: b  reason: collision with root package name */
    String f72601b;

    /* renamed from: c  reason: collision with root package name */
    String f72602c;

    /* renamed from: d  reason: collision with root package name */
    String f72603d = null;

    /* renamed from: e  reason: collision with root package name */
    boolean f72604e = false;

    /* renamed from: f  reason: collision with root package name */
    Attr f72605f;

    NameSpaceSymbEntry(String str, Attr attr, boolean z, String str2) {
        this.f72602c = str;
        this.f72604e = z;
        this.f72605f = attr;
        this.f72601b = str2;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
