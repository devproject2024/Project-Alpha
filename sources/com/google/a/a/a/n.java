package com.google.a.a.a;

import com.google.a.a.b.a.a.a.a.c;
import com.google.a.a.c.u;
import java.io.IOException;

public final class n extends IOException {
    private static final long serialVersionUID = -1875819453475890043L;
    private final String content;
    private final transient g headers;
    private final int statusCode;
    private final String statusMessage;

    public n(m mVar) {
        this(new a(mVar));
    }

    protected n(a aVar) {
        super(aVar.f7526e);
        this.statusCode = aVar.f7522a;
        this.statusMessage = aVar.f7523b;
        this.headers = aVar.f7524c;
        this.content = aVar.f7525d;
    }

    public final boolean isSuccessStatusCode() {
        return o.a(this.statusCode);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final g getHeaders() {
        return this.headers;
    }

    public final String getContent() {
        return this.content;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f7522a;

        /* renamed from: b  reason: collision with root package name */
        String f7523b;

        /* renamed from: c  reason: collision with root package name */
        g f7524c;

        /* renamed from: d  reason: collision with root package name */
        String f7525d;

        /* renamed from: e  reason: collision with root package name */
        String f7526e;

        private a(int i2, String str, g gVar) {
            c.a(i2 >= 0);
            this.f7522a = i2;
            this.f7523b = str;
            this.f7524c = (g) c.a(gVar);
        }

        public a(m mVar) {
            this(mVar.f7514b, mVar.f7515c, mVar.f7516d.f7502a);
            try {
                this.f7525d = mVar.c();
                if (this.f7525d.length() == 0) {
                    this.f7525d = null;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            StringBuilder computeMessageBuffer = n.computeMessageBuffer(mVar);
            if (this.f7525d != null) {
                computeMessageBuffer.append(u.f7617a);
                computeMessageBuffer.append(this.f7525d);
            }
            this.f7526e = computeMessageBuffer.toString();
        }
    }

    public static StringBuilder computeMessageBuffer(m mVar) {
        StringBuilder sb = new StringBuilder();
        int i2 = mVar.f7514b;
        if (i2 != 0) {
            sb.append(i2);
        }
        String str = mVar.f7515c;
        if (str != null) {
            if (i2 != 0) {
                sb.append(' ');
            }
            sb.append(str);
        }
        return sb;
    }
}
