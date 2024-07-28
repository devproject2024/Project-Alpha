package org.apache.http.b;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.http.b;
import org.apache.http.d;
import org.apache.http.e.a;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    protected final List<b> f72501a;

    /* renamed from: b  reason: collision with root package name */
    protected int f72502b = a(-1);

    /* renamed from: c  reason: collision with root package name */
    protected int f72503c = -1;

    /* renamed from: d  reason: collision with root package name */
    protected String f72504d;

    public e(List<b> list, String str) {
        this.f72501a = (List) a.a(list, "Header list");
        this.f72504d = str;
    }

    private int a(int i2) {
        if (i2 < -1) {
            return -1;
        }
        int size = this.f72501a.size() - 1;
        boolean z = false;
        while (!z && i2 < size) {
            i2++;
            if (this.f72504d == null) {
                z = true;
            } else {
                z = this.f72504d.equalsIgnoreCase(this.f72501a.get(i2).a());
            }
        }
        if (z) {
            return i2;
        }
        return -1;
    }

    public final boolean hasNext() {
        return this.f72502b >= 0;
    }

    public final b a() throws NoSuchElementException {
        int i2 = this.f72502b;
        if (i2 >= 0) {
            this.f72503c = i2;
            this.f72502b = a(i2);
            return this.f72501a.get(i2);
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    public final Object next() throws NoSuchElementException {
        return a();
    }

    public final void remove() throws UnsupportedOperationException {
        if (this.f72503c >= 0) {
            this.f72501a.remove(this.f72503c);
            this.f72503c = -1;
            this.f72502b--;
            return;
        }
        throw new IllegalStateException("No header to remove");
    }
}
