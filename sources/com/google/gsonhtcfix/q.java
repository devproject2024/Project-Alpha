package com.google.gsonhtcfix;

import com.google.gsonhtcfix.b.j;
import com.google.gsonhtcfix.d.a;
import com.google.gsonhtcfix.d.b;
import com.google.gsonhtcfix.d.d;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class q {
    public static l a(String str) throws v {
        return a((Reader) new StringReader(str));
    }

    private static l a(Reader reader) throws m, v {
        try {
            a aVar = new a(reader);
            l a2 = a(aVar);
            if (!(a2 instanceof n)) {
                if (aVar.f() != b.END_DOCUMENT) {
                    throw new v("Did not consume the entire document.");
                }
            }
            return a2;
        } catch (d e2) {
            throw new v((Throwable) e2);
        } catch (IOException e3) {
            throw new m((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new v((Throwable) e4);
        }
    }

    private static l a(a aVar) throws m, v {
        boolean z = aVar.f39780b;
        aVar.f39780b = true;
        try {
            l a2 = j.a(aVar);
            aVar.f39780b = z;
            return a2;
        } catch (StackOverflowError e2) {
            throw new p("Failed parsing JSON source: " + aVar + " to Json", e2);
        } catch (OutOfMemoryError e3) {
            throw new p("Failed parsing JSON source: " + aVar + " to Json", e3);
        } catch (Throwable th) {
            aVar.f39780b = z;
            throw th;
        }
    }
}
