package org.apache.xml.security.c14n.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

public class NameSpaceSymbTable {

    /* renamed from: e  reason: collision with root package name */
    static final SymbMap f72606e = new SymbMap();

    /* renamed from: a  reason: collision with root package name */
    SymbMap f72607a = ((SymbMap) f72606e.clone());

    /* renamed from: b  reason: collision with root package name */
    int f72608b = 0;

    /* renamed from: c  reason: collision with root package name */
    List f72609c = new ArrayList(10);

    /* renamed from: d  reason: collision with root package name */
    boolean f72610d = true;

    static {
        NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry("", (Attr) null, true, "xmlns");
        nameSpaceSymbEntry.f72603d = "";
        f72606e.a("xmlns", nameSpaceSymbEntry);
    }

    public Attr a(String str) {
        NameSpaceSymbEntry a2 = this.f72607a.a(str);
        if (a2 == null || a2.f72604e) {
            return null;
        }
        NameSpaceSymbEntry nameSpaceSymbEntry = (NameSpaceSymbEntry) a2.clone();
        e();
        this.f72607a.a(str, nameSpaceSymbEntry);
        nameSpaceSymbEntry.f72604e = true;
        nameSpaceSymbEntry.f72600a = this.f72608b;
        nameSpaceSymbEntry.f72603d = nameSpaceSymbEntry.f72602c;
        return nameSpaceSymbEntry.f72605f;
    }

    public void a() {
        this.f72608b++;
        c();
    }

    public void a(Collection collection) {
        for (NameSpaceSymbEntry nameSpaceSymbEntry : this.f72607a.a()) {
            if (!nameSpaceSymbEntry.f72604e && nameSpaceSymbEntry.f72605f != null) {
                NameSpaceSymbEntry nameSpaceSymbEntry2 = (NameSpaceSymbEntry) nameSpaceSymbEntry.clone();
                e();
                this.f72607a.a(nameSpaceSymbEntry2.f72601b, nameSpaceSymbEntry2);
                nameSpaceSymbEntry2.f72603d = nameSpaceSymbEntry2.f72602c;
                nameSpaceSymbEntry2.f72604e = true;
                collection.add(nameSpaceSymbEntry2.f72605f);
            }
        }
    }

    public boolean a(String str, String str2, Attr attr) {
        NameSpaceSymbEntry a2 = this.f72607a.a(str);
        if (a2 != null && str2.equals(a2.f72602c)) {
            return false;
        }
        NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry(str2, attr, false, str);
        e();
        this.f72607a.a(str, nameSpaceSymbEntry);
        if (a2 != null) {
            nameSpaceSymbEntry.f72603d = a2.f72603d;
            if (a2.f72603d != null && a2.f72603d.equals(str2)) {
                nameSpaceSymbEntry.f72604e = true;
            }
        }
        return true;
    }

    public Attr b(String str) {
        NameSpaceSymbEntry a2 = this.f72607a.a(str);
        if (a2 != null && !a2.f72604e) {
            return a2.f72605f;
        }
        return null;
    }

    public Node b(String str, String str2, Attr attr) {
        NameSpaceSymbEntry a2 = this.f72607a.a(str);
        if (a2 == null || !str2.equals(a2.f72602c)) {
            NameSpaceSymbEntry nameSpaceSymbEntry = new NameSpaceSymbEntry(str2, attr, true, str);
            nameSpaceSymbEntry.f72603d = str2;
            e();
            this.f72607a.a(str, nameSpaceSymbEntry);
            if (a2 == null || a2.f72603d == null || !a2.f72603d.equals(str2)) {
                return nameSpaceSymbEntry.f72605f;
            }
            nameSpaceSymbEntry.f72604e = true;
            return null;
        } else if (a2.f72604e) {
            return null;
        } else {
            NameSpaceSymbEntry nameSpaceSymbEntry2 = (NameSpaceSymbEntry) a2.clone();
            e();
            this.f72607a.a(str, nameSpaceSymbEntry2);
            nameSpaceSymbEntry2.f72603d = str2;
            nameSpaceSymbEntry2.f72604e = true;
            return nameSpaceSymbEntry2.f72605f;
        }
    }

    public void b() {
        this.f72608b--;
        d();
    }

    public void c() {
        this.f72609c.add((Object) null);
        this.f72610d = false;
    }

    public void c(String str) {
        if (this.f72607a.a(str) != null) {
            e();
            this.f72607a.a(str, (NameSpaceSymbEntry) null);
        }
    }

    public void d() {
        boolean z = true;
        int size = this.f72609c.size() - 1;
        Object remove = this.f72609c.remove(size);
        if (remove != null) {
            this.f72607a = (SymbMap) remove;
            if (size != 0) {
                if (this.f72609c.get(size - 1) == this.f72607a) {
                    z = false;
                }
                this.f72610d = z;
                return;
            }
        }
        this.f72610d = false;
    }

    public void d(String str) {
        NameSpaceSymbEntry a2 = this.f72607a.a(str);
        if (a2 != null && !a2.f72604e) {
            e();
            this.f72607a.a(str, (NameSpaceSymbEntry) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f72610d) {
            List list = this.f72609c;
            list.set(list.size() - 1, this.f72607a);
            this.f72607a = (SymbMap) this.f72607a.clone();
            this.f72610d = true;
        }
    }

    public boolean e(String str) {
        NameSpaceSymbEntry a2 = this.f72607a.a(str);
        if (a2 == null || !a2.f72604e) {
            return false;
        }
        e();
        this.f72607a.a(str, (NameSpaceSymbEntry) null);
        return false;
    }

    public int f() {
        return this.f72609c.size();
    }
}
