package net.one97.paytm.contacts.sync;

import androidx.work.ListenableWorker;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.k;
import kotlin.x;

public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static final a f50213c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static i f50214e;

    /* renamed from: a  reason: collision with root package name */
    public volatile CountDownLatch f50215a;

    /* renamed from: b  reason: collision with root package name */
    ListenableWorker.a f50216b;

    /* renamed from: d  reason: collision with root package name */
    private int f50217d;

    public /* synthetic */ i(byte b2) {
        this();
    }

    private i() {
        this.f50217d = 30;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static i a() {
            if (i.f50214e == null) {
                synchronized (i.class) {
                    a aVar = i.f50213c;
                    if (i.f50214e == null) {
                        a aVar2 = i.f50213c;
                        i.f50214e = new i((byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            i a2 = i.f50214e;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
