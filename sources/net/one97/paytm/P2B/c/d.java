package net.one97.paytm.p2b.c;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.p2b.a.b;
import net.one97.paytm.p2b.data.a.a;

public final class d implements b.a, a.C0169a {

    /* renamed from: a  reason: collision with root package name */
    private double f56909a;

    /* renamed from: b  reason: collision with root package name */
    private double f56910b;

    /* renamed from: c  reason: collision with root package name */
    private double f56911c;

    /* renamed from: d  reason: collision with root package name */
    private double f56912d;

    /* renamed from: e  reason: collision with root package name */
    private double f56913e;

    /* renamed from: f  reason: collision with root package name */
    private String f56914f;

    /* renamed from: g  reason: collision with root package name */
    private String f56915g;

    /* renamed from: h  reason: collision with root package name */
    private String f56916h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f56917i;
    private String j;
    private String k;
    private String l;
    private b.C1058b m;
    private net.one97.paytm.p2b.data.a.b n;

    public final void a() {
    }

    public d(b.C1058b bVar, String str, net.one97.paytm.p2b.data.a.b bVar2) {
        this.l = str;
        this.m = bVar;
        this.n = bVar2;
    }

    public final void a(double d2, double d3, double d4, double d5, double d6) {
        this.f56909a = d2;
        this.f56910b = d3;
        this.f56911c = d5;
        this.f56913e = d4;
        this.f56912d = d6;
    }

    public final void a(String str, String str2, String str3, boolean z, String str4, String str5) {
        this.f56914f = str;
        this.f56915g = str2;
        this.f56916h = str3;
        this.f56917i = z;
        this.j = str4;
        this.k = str5;
    }

    public final double b() {
        return this.f56909a;
    }

    public final double c() {
        return this.f56910b;
    }

    public final double d() {
        return this.f56913e;
    }

    public final double e() {
        return this.f56911c;
    }

    public final double f() {
        return this.f56912d;
    }

    public final String g() {
        return this.f56914f;
    }

    public final String h() {
        return this.f56915g;
    }

    public final String i() {
        return this.f56916h;
    }

    public final void j() {
        this.m.b();
        this.n.a(this, (String) null, (String) null, (String) null, false, this.l);
    }

    public final String k() {
        return this.j;
    }

    public final String l() {
        return this.k;
    }

    public final void a(double d2) {
        this.f56909a = d2;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        this.m.c();
        if (iJRPaytmDataModel instanceof CJRP2BStatus) {
            this.m.a((CJRP2BStatus) iJRPaytmDataModel);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        this.m.c();
        this.m.a(networkCustomError);
    }
}
