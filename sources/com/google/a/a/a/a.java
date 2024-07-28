package com.google.a.a.a;

import com.google.a.a.c.l;
import java.io.IOException;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    i f7460a;

    /* renamed from: b  reason: collision with root package name */
    private long f7461b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected a(String str) {
        this(str == null ? null : new i(str));
    }

    private a(i iVar) {
        this.f7461b = -1;
        this.f7460a = iVar;
    }

    public final long a() throws IOException {
        if (this.f7461b == -1) {
            this.f7461b = l.a(this);
        }
        return this.f7461b;
    }

    public final String b() {
        i iVar = this.f7460a;
        if (iVar == null) {
            return null;
        }
        return iVar.a();
    }
}
