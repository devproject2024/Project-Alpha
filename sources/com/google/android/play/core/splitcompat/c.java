package com.google.android.play.core.splitcompat;

import java.io.File;

final class c extends s {

    /* renamed from: a  reason: collision with root package name */
    private final File f37499a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37500b;

    c(File file, String str) {
        if (file != null) {
            this.f37499a = file;
            if (str != null) {
                this.f37500b = str;
                return;
            }
            throw new NullPointerException("Null splitId");
        }
        throw new NullPointerException("Null splitFile");
    }

    /* access modifiers changed from: package-private */
    public final File a() {
        return this.f37499a;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.f37500b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f37499a.equals(sVar.a()) && this.f37500b.equals(sVar.b());
        }
    }

    public final int hashCode() {
        return ((this.f37499a.hashCode() ^ 1000003) * 1000003) ^ this.f37500b.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f37499a);
        String str = this.f37500b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
