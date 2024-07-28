package com.google.a.a.c;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class q implements t {

    /* renamed from: a  reason: collision with root package name */
    private final t f7612a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7613b;

    /* renamed from: c  reason: collision with root package name */
    private final Level f7614c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f7615d;

    public q(t tVar, Logger logger, Level level, int i2) {
        this.f7612a = tVar;
        this.f7615d = logger;
        this.f7614c = level;
        this.f7613b = i2;
    }

    /* JADX INFO: finally extract failed */
    public final void a(OutputStream outputStream) throws IOException {
        p pVar = new p(outputStream, this.f7615d, this.f7614c, this.f7613b);
        try {
            this.f7612a.a(pVar);
            pVar.f7611a.close();
            outputStream.flush();
        } catch (Throwable th) {
            pVar.f7611a.close();
            throw th;
        }
    }
}
