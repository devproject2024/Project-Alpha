package net.one97.paytmflight.common.entity.prioritycheckinentity;

import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f30020a;

    /* renamed from: b  reason: collision with root package name */
    public String f30021b;

    /* renamed from: c  reason: collision with root package name */
    public String f30022c;

    /* renamed from: d  reason: collision with root package name */
    public String f30023d;

    /* renamed from: e  reason: collision with root package name */
    public String f30024e;

    /* renamed from: f  reason: collision with root package name */
    public String f30025f;

    public /* synthetic */ a() {
        this("priority_checkin_join_prime_status.png", "", "", "", "");
    }

    private a(String str, String str2, String str3, String str4, String str5) {
        k.c(str, H5ResourceHandlerUtil.IMAGE);
        k.c(str2, "heading");
        k.c(str3, "subHeading");
        k.c(str4, "message1");
        k.c(str5, "message2");
        this.f30020a = false;
        this.f30021b = str;
        this.f30022c = str2;
        this.f30023d = str3;
        this.f30024e = str4;
        this.f30025f = str5;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f30021b = str;
    }

    public final void b(String str) {
        k.c(str, "<set-?>");
        this.f30022c = str;
    }

    public final void c(String str) {
        k.c(str, "<set-?>");
        this.f30023d = str;
    }

    public final void d(String str) {
        k.c(str, "<set-?>");
        this.f30024e = str;
    }

    public final void e(String str) {
        k.c(str, "<set-?>");
        this.f30025f = str;
    }
}
