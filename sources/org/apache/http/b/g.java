package org.apache.http.b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.b;
import org.apache.http.d;

public final class g implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    final b[] f72508a = new b[0];

    /* renamed from: b  reason: collision with root package name */
    final List<b> f72509b = new ArrayList(16);

    public final void a(b bVar) {
        if (bVar != null) {
            this.f72509b.add(bVar);
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            for (int i2 = 0; i2 < this.f72509b.size(); i2++) {
                if (this.f72509b.get(i2).a().equalsIgnoreCase(bVar.a())) {
                    this.f72509b.set(i2, bVar);
                    return;
                }
            }
            this.f72509b.add(bVar);
        }
    }

    public final d a() {
        return new e(this.f72509b, (String) null);
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final String toString() {
        return this.f72509b.toString();
    }
}
