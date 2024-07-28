package com.google.zxing.client.a;

public final class m extends q {

    /* renamed from: a  reason: collision with root package name */
    private final double f40065a;

    /* renamed from: b  reason: collision with root package name */
    private final double f40066b;

    /* renamed from: c  reason: collision with root package name */
    private final double f40067c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40068d;

    m(double d2, double d3, double d4, String str) {
        super(r.GEO);
        this.f40065a = d2;
        this.f40066b = d3;
        this.f40067c = d4;
        this.f40068d = str;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f40065a);
        sb.append(", ");
        sb.append(this.f40066b);
        if (this.f40067c > 0.0d) {
            sb.append(", ");
            sb.append(this.f40067c);
            sb.append('m');
        }
        if (this.f40068d != null) {
            sb.append(" (");
            sb.append(this.f40068d);
            sb.append(')');
        }
        return sb.toString();
    }
}
