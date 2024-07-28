package net.one97.paytm.h5paytmsdk.a;

import android.os.Build;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.provider.H5ActivityProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5ErrorPageView;
import com.alipay.mobile.nebula.provider.H5JSApiPermissionProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.h5paytmsdk.b.aa;
import net.one97.paytm.h5paytmsdk.b.ab;
import net.one97.paytm.h5paytmsdk.b.ac;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.h5paytmsdk.b.af;
import net.one97.paytm.h5paytmsdk.b.ag;
import net.one97.paytm.h5paytmsdk.b.b;
import net.one97.paytm.h5paytmsdk.b.c;
import net.one97.paytm.h5paytmsdk.b.e;
import net.one97.paytm.h5paytmsdk.b.f;
import net.one97.paytm.h5paytmsdk.b.g;
import net.one97.paytm.h5paytmsdk.b.h;
import net.one97.paytm.h5paytmsdk.b.i;
import net.one97.paytm.h5paytmsdk.b.j;
import net.one97.paytm.h5paytmsdk.b.k;
import net.one97.paytm.h5paytmsdk.b.l;
import net.one97.paytm.h5paytmsdk.b.m;
import net.one97.paytm.h5paytmsdk.b.n;
import net.one97.paytm.h5paytmsdk.b.o;
import net.one97.paytm.h5paytmsdk.b.p;
import net.one97.paytm.h5paytmsdk.b.q;
import net.one97.paytm.h5paytmsdk.b.r;
import net.one97.paytm.h5paytmsdk.b.s;
import net.one97.paytm.h5paytmsdk.b.t;
import net.one97.paytm.h5paytmsdk.b.u;
import net.one97.paytm.h5paytmsdk.b.v;
import net.one97.paytm.h5paytmsdk.b.w;
import net.one97.paytm.h5paytmsdk.b.x;
import net.one97.paytm.h5paytmsdk.b.z;
import net.one97.paytm.h5paytmsdk.c.a;
import net.one97.paytm.h5paytmsdk.c.ae;
import net.one97.paytm.h5paytmsdk.c.y;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f16963a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, List<ad>> f16964b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, List<Object>> f16965c = new LinkedHashMap();

    private d() {
    }

    public static final void a() {
        AppContainerKit.getInstance().registerPlugin(new x());
        AppContainerKit.getInstance().registerPlugin(new z());
        AppContainerKit.getInstance().registerPlugin(new b());
        AppContainerKit.getInstance().registerPlugin(new f());
        AppContainerKit.getInstance().registerPlugin(new ac());
        AppContainerKit.getInstance().registerPlugin(new k());
        AppContainerKit.getInstance().registerPlugin(new j());
        AppContainerKit.getInstance().registerPlugin(new v());
        AppContainerKit.getInstance().registerPlugin(new u());
        AppContainerKit.getInstance().registerPlugin(new i());
        AppContainerKit.getInstance().registerPlugin(new m());
        AppContainerKit.getInstance().registerPlugin(new s());
        AppContainerKit.getInstance().registerPlugin(new l());
        AppContainerKit.getInstance().registerPlugin(new t());
        AppContainerKit.getInstance().registerPlugin(new ag());
        AppContainerKit.getInstance().registerPlugin(new h());
        AppContainerKit.getInstance().registerPlugin(new af());
        AppContainerKit.getInstance().registerPlugin(new p());
        AppContainerKit.getInstance().registerPlugin(new q());
        AppContainerKit.getInstance().registerPlugin(new w());
        AppContainerKit.getInstance().registerPlugin(new aa());
        AppContainerKit.getInstance().registerPlugin(new r());
        AppContainerKit.getInstance().registerPlugin(new c());
        AppContainerKit.getInstance().registerPlugin(new ab());
        AppContainerKit.getInstance().registerPlugin(new net.one97.paytm.h5paytmsdk.b.d());
        AppContainerKit.getInstance().registerPlugin(new o());
        AppContainerKit.getInstance().registerPlugin(new n());
        AppContainerKit.getInstance().registerPlugin(new e());
        if (Build.VERSION.SDK_INT >= 21) {
            AppContainerKit.getInstance().registerPlugin(new g());
        }
    }

    public static final void b() {
        AppContainerKit.getInstance().setProvider(H5ActivityProvider.class.getName(), new net.one97.paytm.h5paytmsdk.c.d());
        AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.ad.class.getName(), new net.one97.paytm.h5paytmsdk.c.ad());
        AppContainerKit.getInstance().setProvider(H5ErrorPageView.class.getName(), new net.one97.paytm.h5paytmsdk.c.p());
        AppContainerKit.getInstance().setProvider(H5JSApiPermissionProvider.class.getName(), new net.one97.paytm.h5paytmsdk.c.g());
        AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.a.d.class.getName(), new net.one97.paytm.h5paytmsdk.c.a.d());
        AppContainerKit.getInstance().setProvider(H5JSApiPermissionProvider.class.getName(), new net.one97.paytm.h5paytmsdk.c.c());
        AppContainerKit.getInstance().setProvider(H5ConfigProvider.class.getName(), new a());
    }

    public static final void a(List<? extends ad> list) {
        if (list != null) {
            for (ad registerPlugin : list) {
                AppContainerKit.getInstance().registerPlugin(registerPlugin);
            }
        }
    }

    public static final void a(String str, List<? extends ad> list) {
        kotlin.g.b.k.c(str, "appUniqueId");
        if (list != null) {
            f16964b.put(str, list);
        }
    }

    public static final void a(String str) {
        kotlin.g.b.k.c(str, "appUniqueId");
        List<ad> list = f16964b.get(str);
        if (list != null) {
            for (ad registerPlugin : list) {
                AppContainerKit.getInstance().registerPlugin(registerPlugin);
            }
        }
    }

    public static final void b(String str) {
        kotlin.g.b.k.c(str, "appUniqueId");
        List<ad> list = f16964b.get(str);
        if (list != null) {
            for (ad unRegisterPlugin : list) {
                AppContainerKit.getInstance().unRegisterPlugin(unRegisterPlugin);
            }
        }
    }

    public static final void b(List<? extends Object> list) {
        if (list != null) {
            for (Object next : list) {
                if (next instanceof net.one97.paytm.h5paytmsdk.c.k) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.k.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.e) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.e.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.z) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.z.class.getName(), next);
                } else if (next instanceof ae) {
                    AppContainerKit.getInstance().setProvider(ae.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.l) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.l.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.o) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.o.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.x) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.x.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.w) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.w.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.aa) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.aa.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.m) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.m.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.f) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.f.class.getName(), next);
                } else if (next instanceof y) {
                    AppContainerKit.getInstance().setProvider(y.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.v) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.v.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.u) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.u.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.ac) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.ac.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.i) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.i.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.h) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.h.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.n) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.n.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.ab) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.ab.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.s) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.s.class.getName(), next);
                } else if (next instanceof net.one97.paytm.h5paytmsdk.c.j) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.j.class.getName(), next);
                } else {
                    AppContainerKit.getInstance().setProvider(next.getClass().getName(), next);
                }
            }
        }
    }

    public static final void b(String str, List<? extends Object> list) {
        kotlin.g.b.k.c(str, "appUniqueId");
        if (list != null) {
            f16965c.put(str, list);
        }
    }

    public static final void c(String str) {
        kotlin.g.b.k.c(str, "appUniqueId");
        List list = f16965c.get(str);
        if (list != null) {
            for (Object next : list) {
                if (next instanceof net.one97.paytm.h5paytmsdk.c.q) {
                    AppContainerKit.getInstance().setProvider(net.one97.paytm.h5paytmsdk.c.q.class.getName(), next);
                } else {
                    AppContainerKit.getInstance().setProvider(next.getClass().getName(), next);
                }
            }
        }
    }

    public static final void d(String str) {
        kotlin.g.b.k.c(str, "appUniqueId");
        List list = f16965c.get(str);
        if (list != null) {
            try {
                Object findServiceByInterface = H5Utils.findServiceByInterface(H5Service.class.getName());
                if (findServiceByInterface != null) {
                    H5Service h5Service = (H5Service) findServiceByInterface;
                    for (Object next : list) {
                        if (next instanceof net.one97.paytm.h5paytmsdk.c.q) {
                            h5Service.getProviderManager().removeProvider(net.one97.paytm.h5paytmsdk.c.q.class.getName());
                        } else {
                            h5Service.getProviderManager().removeProvider(next.getClass().getName());
                        }
                    }
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type com.alipay.mobile.h5container.service.H5Service");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
