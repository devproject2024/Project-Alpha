package com.google.zxing.g.c;

import com.google.zxing.g.a.h;
import com.google.zxing.g.a.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    h f40556a;

    /* renamed from: b  reason: collision with root package name */
    com.google.zxing.g.a.f f40557b;

    /* renamed from: c  reason: collision with root package name */
    j f40558c;

    /* renamed from: d  reason: collision with root package name */
    int f40559d = -1;

    /* renamed from: e  reason: collision with root package name */
    public b f40560e;

    public final String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f40556a);
        sb.append("\n ecLevel: ");
        sb.append(this.f40557b);
        sb.append("\n version: ");
        sb.append(this.f40558c);
        sb.append("\n maskPattern: ");
        sb.append(this.f40559d);
        if (this.f40560e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f40560e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
