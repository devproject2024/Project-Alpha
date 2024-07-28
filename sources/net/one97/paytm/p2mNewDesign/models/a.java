package net.one97.paytm.p2mNewDesign.models;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56918a;

    /* renamed from: b  reason: collision with root package name */
    public Double f56919b;

    /* renamed from: c  reason: collision with root package name */
    public String f56920c;

    /* renamed from: d  reason: collision with root package name */
    public Double f56921d;

    /* renamed from: e  reason: collision with root package name */
    public String f56922e;

    /* renamed from: f  reason: collision with root package name */
    private String f56923f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f56924g = false;

    public a(String str, String str2, Double d2, String str3, Double d3, String str4) {
        this.f56918a = str;
        this.f56923f = str2;
        this.f56919b = d2;
        this.f56920c = str3;
        this.f56921d = d3;
        this.f56922e = str4;
    }

    public final String a() {
        String str = this.f56923f;
        if (str != null) {
            this.f56923f = str.trim();
        }
        return this.f56923f;
    }
}
