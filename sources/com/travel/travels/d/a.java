package com.travel.travels.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.d;
import com.travel.travel.CJRTravelHomePage;
import com.travel.utils.r;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.g.a.b;
import kotlin.x;
import net.one97.paytm.common.entity.IJRDataModel;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f28489a;

    /* renamed from: b  reason: collision with root package name */
    public com.travel.travels.c.a f28490b;

    /* renamed from: c  reason: collision with root package name */
    public String f28491c;

    /* renamed from: d  reason: collision with root package name */
    CJRTravelHomePage f28492d;

    /* renamed from: e  reason: collision with root package name */
    private String f28493e = "CJRTHPresenter";

    /* renamed from: f  reason: collision with root package name */
    private final String f28494f = "isTravelStoreFrontClearCache";

    /* renamed from: g  reason: collision with root package name */
    private CJRTravelHomePage f28495g;

    /* renamed from: h  reason: collision with root package name */
    private CJRTravelHomePage f28496h;

    public a(Context context, com.travel.travels.c.a aVar) {
        this.f28489a = context;
        this.f28490b = aVar;
    }

    public final void a() {
        Boolean bool;
        if (this.f28490b != null) {
            Context context = this.f28489a;
            if (context != null) {
                bool = Boolean.valueOf(r.a(context.getApplicationContext()).b("is-model-file-existing", false, false));
            } else {
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                com.paytm.utility.d.a.a(new b() {
                    public final Object invoke(Object obj) {
                        return a.this.a(obj);
                    }
                }, new kotlin.g.a.a() {
                    public final Object invoke() {
                        return a.this.d();
                    }
                }, new kotlin.g.a.a() {
                    public final Object invoke() {
                        return a.this.c();
                    }
                });
                return;
            }
            com.paytm.utility.d.a.a(new b() {
                public final Object invoke(Object obj) {
                    return a.this.a(obj);
                }
            }, new kotlin.g.a.a() {
                public final Object invoke() {
                    return a.this.b();
                }
            }, new kotlin.g.a.a() {
                public final Object invoke() {
                    return a.this.d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public CJRTravelHomePage b() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        com.paytm.utility.d.b.a(this.f28489a, a.c.TRAVEL_HOME, "CJRTravelHomePage", (Class<?>) CJRTravelHomePage.class, (b<? super Serializable, x>) new b(countDownLatch) {
            private final /* synthetic */ CountDownLatch f$1;

            {
                this.f$1 = r2;
            }

            public final Object invoke(Object obj) {
                return a.this.a(this.f$1, (Serializable) obj);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            q.c(e2.getMessage());
        }
        CJRTravelHomePage cJRTravelHomePage = this.f28496h;
        if (cJRTravelHomePage != null) {
            return cJRTravelHomePage;
        }
        return c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x a(CountDownLatch countDownLatch, Serializable serializable) {
        if (serializable instanceof CJRTravelHomePage) {
            this.f28496h = (CJRTravelHomePage) serializable;
        }
        countDownLatch.countDown();
        return null;
    }

    /* access modifiers changed from: private */
    public CJRTravelHomePage c() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            IJRDataModel a2 = a(this.f28489a, new CJRTravelHomePage(), "travel_tabs_response.json");
            if (a2 != null) {
                this.f28495g = (CJRTravelHomePage) a2;
                countDownLatch.countDown();
            }
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.getMessage();
        }
        return this.f28495g;
    }

    /* access modifiers changed from: private */
    public CJRTravelHomePage d() {
        if (!com.paytm.utility.b.c(this.f28489a)) {
            return c();
        }
        d.a();
        this.f28491c = d.b().e();
        if (!TextUtils.isEmpty(this.f28491c) && URLUtil.isValidUrl(this.f28491c)) {
            new HashMap().put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f28489a));
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f28489a;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = com.travel.utils.d.f28520a;
            bVar.f42879c = a.C0715a.POST;
            bVar.f42880d = this.f28491c;
            bVar.f42885i = new CJRTravelHomePage();
            bVar.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    a aVar = a.this;
                    aVar.f28492d = (CJRTravelHomePage) iJRPaytmDataModel;
                    if (!(aVar.f28489a == null || a.this.f28492d == null)) {
                        com.paytm.utility.d.b.a(a.this.f28489a, a.c.TRAVEL_HOME, "CJRTravelHomePage", (Serializable) a.this.f28492d, (b<? super Boolean, x>) $$Lambda$a$1$UUW4xTo_alur3iTT0hUPpayXxcw.INSTANCE);
                    }
                    a aVar2 = a.this;
                    Boolean bool = Boolean.TRUE;
                    if (aVar2.f28489a != null) {
                        r.a(aVar2.f28489a.getApplicationContext()).a("is-model-file-existing", bool.booleanValue(), false);
                    }
                    countDownLatch.countDown();
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (a.this.f28490b != null) {
                        a.this.f28490b.f();
                    }
                    countDownLatch.countDown();
                }
            };
            com.paytm.network.a l = bVar.l();
            l.f42859c = true;
            l.a();
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                q.c(e2.getMessage());
            }
        }
        return this.f28492d;
    }

    /* access modifiers changed from: private */
    public x a(Object obj) {
        com.travel.travels.c.a aVar = this.f28490b;
        if (aVar == null || !(obj instanceof CJRTravelHomePage)) {
            return null;
        }
        aVar.a((CJRTravelHomePage) obj);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[SYNTHETIC, Splitter:B:20:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC, Splitter:B:27:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A[SYNTHETIC, Splitter:B:34:0x005d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0044=Splitter:B:24:0x0044, B:17:0x0035=Splitter:B:17:0x0035} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.common.entity.IJRDataModel a(android.content.Context r2, net.one97.paytm.common.entity.IJRDataModel r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x0042, Exception -> 0x0033, all -> 0x0030 }
            java.io.InputStream r2 = r2.open(r4)     // Catch:{ IOException -> 0x0042, Exception -> 0x0033, all -> 0x0030 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x002e, Exception -> 0x002c }
            r4.<init>(r2)     // Catch:{ IOException -> 0x002e, Exception -> 0x002c }
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ IOException -> 0x002e, Exception -> 0x002c }
            r1.<init>()     // Catch:{ IOException -> 0x002e, Exception -> 0x002c }
            java.lang.Class r3 = r3.getClass()     // Catch:{ IOException -> 0x002e, Exception -> 0x002c }
            java.lang.Object r3 = r1.a((java.io.Reader) r4, r3)     // Catch:{ IOException -> 0x002e, Exception -> 0x002c }
            net.one97.paytm.common.entity.IJRDataModel r3 = (net.one97.paytm.common.entity.IJRDataModel) r3     // Catch:{ IOException -> 0x002e, Exception -> 0x002c }
            if (r2 == 0) goto L_0x002b
            r2.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x002b
        L_0x0023:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.paytm.utility.q.c(r2)
        L_0x002b:
            return r3
        L_0x002c:
            r3 = move-exception
            goto L_0x0035
        L_0x002e:
            r3 = move-exception
            goto L_0x0044
        L_0x0030:
            r3 = move-exception
            r2 = r0
            goto L_0x005b
        L_0x0033:
            r3 = move-exception
            r2 = r0
        L_0x0035:
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x005a }
            com.paytm.utility.q.c(r3)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0059
        L_0x0042:
            r3 = move-exception
            r2 = r0
        L_0x0044:
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x005a }
            com.paytm.utility.q.c(r3)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.paytm.utility.q.c(r2)
        L_0x0059:
            return r0
        L_0x005a:
            r3 = move-exception
        L_0x005b:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.paytm.utility.q.c(r2)
        L_0x0069:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.travels.d.a.a(android.content.Context, net.one97.paytm.common.entity.IJRDataModel, java.lang.String):net.one97.paytm.common.entity.IJRDataModel");
    }
}
