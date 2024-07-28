package org.apache.xml.security.c14n.implementations;

import java.util.ArrayList;
import java.util.List;

class SymbMap implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    int f72611a = 23;

    /* renamed from: b  reason: collision with root package name */
    NameSpaceSymbEntry[] f72612b;

    /* renamed from: c  reason: collision with root package name */
    String[] f72613c;

    SymbMap() {
        int i2 = this.f72611a;
        this.f72612b = new NameSpaceSymbEntry[i2];
        this.f72613c = new String[i2];
    }

    /* access modifiers changed from: protected */
    public int a(Object obj) {
        String str;
        String[] strArr = this.f72613c;
        int length = strArr.length;
        int hashCode = (obj.hashCode() & Integer.MAX_VALUE) % length;
        String str2 = strArr[hashCode];
        if (str2 != null && !str2.equals(obj)) {
            int i2 = length - 1;
            do {
                hashCode = hashCode == i2 ? 0 : hashCode + 1;
                str = strArr[hashCode];
                if (str == null) {
                    break;
                }
            } while (str.equals(obj));
        }
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public List a() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            NameSpaceSymbEntry[] nameSpaceSymbEntryArr = this.f72612b;
            if (i2 >= nameSpaceSymbEntryArr.length) {
                return arrayList;
            }
            if (nameSpaceSymbEntryArr[i2] != null && !"".equals(nameSpaceSymbEntryArr[i2].f72602c)) {
                arrayList.add(this.f72612b[i2]);
            }
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public NameSpaceSymbEntry a(String str) {
        return this.f72612b[a((Object) str)];
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        String[] strArr = this.f72613c;
        int length = strArr.length;
        NameSpaceSymbEntry[] nameSpaceSymbEntryArr = this.f72612b;
        this.f72613c = new String[i2];
        this.f72612b = new NameSpaceSymbEntry[i2];
        while (true) {
            int i3 = length - 1;
            if (length > 0) {
                if (strArr[i3] != null) {
                    String str = strArr[i3];
                    int a2 = a((Object) str);
                    this.f72613c[a2] = str;
                    this.f72612b[a2] = nameSpaceSymbEntryArr[i3];
                }
                length = i3;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, NameSpaceSymbEntry nameSpaceSymbEntry) {
        int a2 = a((Object) str);
        String[] strArr = this.f72613c;
        String str2 = strArr[a2];
        strArr[a2] = str;
        this.f72612b[a2] = nameSpaceSymbEntry;
        if (str2 == null || !str2.equals(str)) {
            int i2 = this.f72611a - 1;
            this.f72611a = i2;
            if (i2 == 0) {
                this.f72611a = this.f72612b.length;
                a(this.f72611a << 2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            SymbMap symbMap = (SymbMap) super.clone();
            symbMap.f72612b = new NameSpaceSymbEntry[this.f72612b.length];
            System.arraycopy(this.f72612b, 0, symbMap.f72612b, 0, this.f72612b.length);
            symbMap.f72613c = new String[this.f72613c.length];
            System.arraycopy(this.f72613c, 0, symbMap.f72613c, 0, this.f72613c.length);
            return symbMap;
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
