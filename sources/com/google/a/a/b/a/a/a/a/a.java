package com.google.a.a.b.a.a.a.a;

import java.io.IOException;
import java.util.Iterator;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final String f7535a;

    /* synthetic */ a(a aVar, byte b2) {
        this(aVar);
    }

    public a(String str) {
        this.f7535a = (String) c.a(str);
    }

    private a(a aVar) {
        this.f7535a = aVar.f7535a;
    }

    public <A extends Appendable> A a(A a2, Iterator<?> it2) throws IOException {
        c.a(a2);
        if (it2.hasNext()) {
            a2.append(a(it2.next()));
            while (it2.hasNext()) {
                a2.append(this.f7535a);
                a2.append(a(it2.next()));
            }
        }
        return a2;
    }

    public final StringBuilder a(StringBuilder sb, Iterator<?> it2) {
        try {
            a(sb, it2);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    static CharSequence a(Object obj) {
        c.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
