package net.one97.paytm.upgradeKyc.helper;

import java.lang.reflect.InvocationTargetException;
import kotlin.g.b.k;
import kotlin.x;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f66028b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static e f66029c;

    /* renamed from: a  reason: collision with root package name */
    public f f66030a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(f fVar) {
            k.c(fVar, "upgradeKycListener");
            if (e.f66029c == null) {
                e.f66029c = new e();
                e a2 = e.f66029c;
                if (a2 == null) {
                    k.a();
                }
                a2.f66030a = fVar;
            }
        }

        public static e a() {
            if (e.f66029c == null) {
                synchronized (e.class) {
                    a aVar = e.f66028b;
                    try {
                        Class.forName("net.one97.paytm.upgradeKyc.helper.UpgradeKycProviderHelper").getMethod("initialize", new Class[0]).invoke((Object) null, new Object[0]);
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
            if (e.f66029c != null) {
                e a2 = e.f66029c;
                if (a2 == null) {
                    k.a();
                }
                return a2;
            }
            throw new RuntimeException("getInstance() called before UpgradeKycProvider's init()");
        }

        public static f b() {
            f fVar = a().f66030a;
            if (fVar == null) {
                k.a();
            }
            return fVar;
        }
    }
}
