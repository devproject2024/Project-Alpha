package com.google.a.a.c;

import com.google.a.a.b.a.a.a.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class n extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f7605a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7606b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7607c;

    /* renamed from: d  reason: collision with root package name */
    private final Level f7608d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f7609e;

    public n(Logger logger, Level level, int i2) {
        this.f7609e = (Logger) c.a(logger);
        this.f7608d = (Level) c.a(level);
        c.a(i2 >= 0);
        this.f7606b = i2;
    }

    public final synchronized void write(int i2) {
        c.a(!this.f7607c);
        this.f7605a++;
        if (this.count < this.f7606b) {
            super.write(i2);
        }
    }

    public final synchronized void write(byte[] bArr, int i2, int i3) {
        c.a(!this.f7607c);
        this.f7605a += i3;
        if (this.count < this.f7606b) {
            int i4 = this.count + i3;
            if (i4 > this.f7606b) {
                i3 += this.f7606b - i4;
            }
            super.write(bArr, i2, i3);
        }
    }

    public final synchronized void close() throws IOException {
        if (!this.f7607c) {
            if (this.f7605a != 0) {
                StringBuilder sb = new StringBuilder("Total: ");
                a(sb, this.f7605a);
                if (this.count != 0 && this.count < this.f7605a) {
                    sb.append(" (logging first ");
                    a(sb, this.count);
                    sb.append(")");
                }
                this.f7609e.config(sb.toString());
                if (this.count != 0) {
                    this.f7609e.log(this.f7608d, toString(AppConstants.UTF_8).replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                }
            }
            this.f7607c = true;
        }
    }

    private static void a(StringBuilder sb, int i2) {
        if (i2 == 1) {
            sb.append("1 byte");
            return;
        }
        sb.append(NumberFormat.getInstance().format((long) i2));
        sb.append(" bytes");
    }
}
