package org.apache.http.b;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.b;
import org.apache.http.c.d;
import org.apache.http.l;

public abstract class a implements l {
    protected g headergroup;
    @Deprecated
    protected d params;

    @Deprecated
    protected a(d dVar) {
        this.headergroup = new g();
        this.params = dVar;
    }

    protected a() {
        this((d) null);
    }

    public boolean containsHeader(String str) {
        g gVar = this.headergroup;
        for (int i2 = 0; i2 < gVar.f72509b.size(); i2++) {
            if (gVar.f72509b.get(i2).a().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public b[] getHeaders(String str) {
        g gVar = this.headergroup;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < gVar.f72509b.size(); i2++) {
            b bVar = gVar.f72509b.get(i2);
            if (bVar.a().equalsIgnoreCase(str)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(bVar);
            }
        }
        return arrayList != null ? (b[]) arrayList.toArray(new b[arrayList.size()]) : gVar.f72508a;
    }

    public b getFirstHeader(String str) {
        g gVar = this.headergroup;
        for (int i2 = 0; i2 < gVar.f72509b.size(); i2++) {
            b bVar = gVar.f72509b.get(i2);
            if (bVar.a().equalsIgnoreCase(str)) {
                return bVar;
            }
        }
        return null;
    }

    public b getLastHeader(String str) {
        g gVar = this.headergroup;
        for (int size = gVar.f72509b.size() - 1; size >= 0; size--) {
            b bVar = gVar.f72509b.get(size);
            if (bVar.a().equalsIgnoreCase(str)) {
                return bVar;
            }
        }
        return null;
    }

    public b[] getAllHeaders() {
        g gVar = this.headergroup;
        return (b[]) gVar.f72509b.toArray(new b[gVar.f72509b.size()]);
    }

    public void addHeader(b bVar) {
        this.headergroup.a(bVar);
    }

    public void addHeader(String str, String str2) {
        org.apache.http.e.a.a(str, "Header name");
        this.headergroup.a(new b(str, str2));
    }

    public void setHeader(b bVar) {
        this.headergroup.b(bVar);
    }

    public void setHeader(String str, String str2) {
        org.apache.http.e.a.a(str, "Header name");
        this.headergroup.b(new b(str, str2));
    }

    public void setHeaders(b[] bVarArr) {
        g gVar = this.headergroup;
        gVar.f72509b.clear();
        if (bVarArr != null) {
            Collections.addAll(gVar.f72509b, bVarArr);
        }
    }

    public void removeHeader(b bVar) {
        g gVar = this.headergroup;
        if (bVar != null) {
            gVar.f72509b.remove(bVar);
        }
    }

    public void removeHeaders(String str) {
        if (str != null) {
            org.apache.http.d a2 = this.headergroup.a();
            while (a2.hasNext()) {
                if (str.equalsIgnoreCase(a2.a().a())) {
                    a2.remove();
                }
            }
        }
    }

    public org.apache.http.d headerIterator() {
        return this.headergroup.a();
    }

    public org.apache.http.d headerIterator(String str) {
        return new e(this.headergroup.f72509b, str);
    }

    @Deprecated
    public d getParams() {
        if (this.params == null) {
            this.params = new org.apache.http.c.b();
        }
        return this.params;
    }

    @Deprecated
    public void setParams(d dVar) {
        this.params = (d) org.apache.http.e.a.a(dVar, "HTTP parameters");
    }
}
