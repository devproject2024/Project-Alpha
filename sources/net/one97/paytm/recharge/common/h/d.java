package net.one97.paytm.recharge.common.h;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import kotlin.k.e;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.utils.w;

public final class d implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final a f61427a;

    public enum b {
        UTILITY,
        MOBILE,
        COUPONS,
        DTH,
        CREDIT_CARD
    }

    public d(a aVar) {
        k.c(aVar, "builder");
        this.f61427a = aVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        int i2 = e.f61437a[this.f61427a.l.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)));
                        } else if (cls.isAssignableFrom(net.one97.paytm.recharge.creditcard.c.a.class)) {
                            CJRItem cJRItem = this.f61427a.f61428a;
                            if (cJRItem == null) {
                                k.a();
                            }
                            c cVar = this.f61427a.f61429b;
                            if (cVar == null) {
                                k.a();
                            }
                            w wVar = this.f61427a.f61430c;
                            if (wVar == null) {
                                k.a();
                            }
                            e<x> eVar = this.f61427a.f61431d;
                            if (eVar == null) {
                                k.a();
                            }
                            net.one97.paytm.recharge.ordersummary.h.d dVar = this.f61427a.f61432e;
                            if (dVar == null) {
                                k.a();
                            }
                            return (ai) new net.one97.paytm.recharge.creditcard.c.a(cJRItem, cVar, wVar, eVar, dVar);
                        } else {
                            throw new IllegalArgumentException("ViewModel Not Found");
                        }
                    } else if (cls.isAssignableFrom(net.one97.paytm.recharge.coupons.e.a.class)) {
                        return (ai) new net.one97.paytm.recharge.coupons.e.a(this.f61427a);
                    } else {
                        throw new IllegalArgumentException("ViewModel Not Found");
                    }
                } else if (cls.isAssignableFrom(net.one97.paytm.recharge.mobile.d.a.class)) {
                    CJRItem cJRItem2 = this.f61427a.f61428a;
                    if (cJRItem2 == null) {
                        k.a();
                    }
                    c cVar2 = this.f61427a.f61429b;
                    if (cVar2 != null) {
                        net.one97.paytm.recharge.mobile.b bVar = (net.one97.paytm.recharge.mobile.b) cVar2;
                        w wVar2 = this.f61427a.f61430c;
                        if (wVar2 == null) {
                            k.a();
                        }
                        e<x> eVar2 = this.f61427a.f61431d;
                        if (eVar2 == null) {
                            k.a();
                        }
                        net.one97.paytm.recharge.ordersummary.h.d dVar2 = this.f61427a.f61432e;
                        if (dVar2 == null) {
                            k.a();
                        }
                        return (ai) new net.one97.paytm.recharge.mobile.d.a(cJRItem2, bVar, wVar2, eVar2, dVar2);
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile.CJRMobileRechargeRepository");
                } else {
                    throw new IllegalArgumentException("ViewModel Not Found");
                }
            } else if (cls.isAssignableFrom(net.one97.paytm.recharge.dth.c.a.class)) {
                CJRItem cJRItem3 = this.f61427a.f61428a;
                if (cJRItem3 == null) {
                    k.a();
                }
                c cVar3 = this.f61427a.f61429b;
                if (cVar3 == null) {
                    k.a();
                }
                w wVar3 = this.f61427a.f61430c;
                if (wVar3 == null) {
                    k.a();
                }
                e<x> eVar3 = this.f61427a.f61431d;
                if (eVar3 == null) {
                    k.a();
                }
                net.one97.paytm.recharge.ordersummary.h.d dVar3 = this.f61427a.f61432e;
                if (dVar3 == null) {
                    k.a();
                }
                return (ai) new net.one97.paytm.recharge.dth.c.a(cJRItem3, cVar3, wVar3, eVar3, dVar3);
            } else {
                throw new IllegalArgumentException("ViewModel Not Found");
            }
        } else if (cls.isAssignableFrom(g.class)) {
            CJRItem cJRItem4 = this.f61427a.f61428a;
            if (cJRItem4 == null) {
                k.a();
            }
            c cVar4 = this.f61427a.f61429b;
            if (cVar4 == null) {
                k.a();
            }
            w wVar4 = this.f61427a.f61430c;
            if (wVar4 == null) {
                k.a();
            }
            e<x> eVar4 = this.f61427a.f61431d;
            if (eVar4 == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d dVar4 = this.f61427a.f61432e;
            if (dVar4 == null) {
                k.a();
            }
            return (ai) new g(cJRItem4, cVar4, wVar4, eVar4, dVar4);
        } else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        CJRItem f61428a;

        /* renamed from: b  reason: collision with root package name */
        public c f61429b;

        /* renamed from: c  reason: collision with root package name */
        public w f61430c;

        /* renamed from: d  reason: collision with root package name */
        public e<x> f61431d;

        /* renamed from: e  reason: collision with root package name */
        public net.one97.paytm.recharge.ordersummary.h.d f61432e;

        /* renamed from: f  reason: collision with root package name */
        public String f61433f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f61434g = "";

        /* renamed from: h  reason: collision with root package name */
        public CJRCartProduct f61435h;

        /* renamed from: i  reason: collision with root package name */
        public String f61436i = "";
        public String j = "";
        public String k = "";
        b l;

        public a(b bVar) {
            k.c(bVar, "type");
            this.l = bVar;
        }

        public final a a(CJRItem cJRItem) {
            k.c(cJRItem, "rechargeItem");
            this.f61428a = cJRItem;
            return this;
        }

        public final a a(c cVar) {
            k.c(cVar, "repository");
            this.f61429b = cVar;
            return this;
        }

        public final a a(w wVar) {
            k.c(wVar, "proceedHandler");
            this.f61430c = wVar;
            return this;
        }

        public final a a(e<x> eVar) {
            k.c(eVar, "errorHandler");
            this.f61431d = eVar;
            return this;
        }

        public final a a(net.one97.paytm.recharge.ordersummary.h.d dVar) {
            k.c(dVar, "gtmHelper");
            this.f61432e = dVar;
            return this;
        }
    }
}
