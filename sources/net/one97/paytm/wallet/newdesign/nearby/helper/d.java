package net.one97.paytm.wallet.newdesign.nearby.helper;

import java.lang.reflect.InvocationTargetException;
import kotlin.g.b.k;
import kotlin.x;

public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f71130b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static d f71131c;

    /* renamed from: a  reason: collision with root package name */
    public e f71132a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(e eVar) {
            k.c(eVar, "nearbyListener");
            if (d.f71131c == null) {
                d.f71131c = new d();
                d a2 = d.f71131c;
                if (a2 == null) {
                    k.a();
                }
                a2.f71132a = eVar;
            }
        }

        public static d a() {
            if (d.f71131c == null) {
                synchronized (d.class) {
                    a aVar = d.f71130b;
                    try {
                        Class.forName("net.one97.paytm.helper.NearbyProviderHelper").getMethod("initialize", new Class[0]).invoke((Object) null, new Object[0]);
                    } catch (ClassNotFoundException e2) {
                        e2.printStackTrace();
                    } catch (NoSuchMethodException e3) {
                        e3.printStackTrace();
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                    x xVar = x.f47997a;
                }
            }
            if (d.f71131c != null) {
                d a2 = d.f71131c;
                if (a2 == null) {
                    k.a();
                }
                return a2;
            }
            throw new RuntimeException("getInstance() called before NearbyProvider's init()");
        }

        public static e b() {
            e eVar = a().f71132a;
            if (eVar == null) {
                k.a();
            }
            return eVar;
        }
    }
}
