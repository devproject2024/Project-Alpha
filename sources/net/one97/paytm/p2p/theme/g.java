package net.one97.paytm.p2p.theme;

import android.content.Context;
import androidx.lifecycle.z;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.network.a;
import net.one97.paytm.network.h;
import net.one97.paytm.utils.af;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.utils.AppExecutor;

public final class g {

    /* renamed from: d  reason: collision with root package name */
    private static g f57007d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f57008a = false;

    /* renamed from: b  reason: collision with root package name */
    private Context f57009b;

    /* renamed from: c  reason: collision with root package name */
    private DealsEntity f57010c;

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (f57007d == null) {
                f57007d = new g(context);
            }
            gVar = f57007d;
        }
        return gVar;
    }

    public final DealsEntity a() {
        Object a2 = e.a(this.f57009b, "theme_data");
        if (a2 instanceof DealsEntity) {
            return (DealsEntity) a2;
        }
        return null;
    }

    public final ThemeData a(String str) {
        Object a2 = e.a(this.f57009b, "theme_data");
        if (!(a2 instanceof DealsEntity)) {
            return null;
        }
        this.f57010c = (DealsEntity) a2;
        Iterator<CJRGridProduct> it2 = this.f57010c.getGrid_layout().iterator();
        while (it2.hasNext()) {
            CJRGridProduct next = it2.next();
            if (next.getProductID().equalsIgnoreCase(str)) {
                ThemeData themeData = (ThemeData) new f().a(next.getName(), ThemeData.class);
                themeData.setThemeId(next.getProductID());
                themeData.setJsonData(next.getJsonValue());
                themeData.setImagerURL(next.getImageUrl());
                themeData.setLastUpdatedAt(next.getLastUpdatedAt());
                return themeData;
            }
        }
        return null;
    }

    private g(Context context) {
        this.f57009b = context.getApplicationContext();
    }

    public final boolean b() {
        Object a2 = e.a(this.f57009b, "theme_data");
        if (a2 instanceof DealsEntity) {
            Iterator<CJRGridProduct> it2 = ((DealsEntity) a2).getGrid_layout().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                CJRGridProduct next = it2.next();
                if (next.getJsonValue() != null && !next.getJsonValue().isEmpty()) {
                    i2++;
                }
                if (i2 >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void c() {
        if (!af.b().lowMemory) {
            String str = "https://middleware.paytmmall.com/Best-online-selling-televisions-llpid-186095";
            if (b()) {
                if (b.a().getStringFromGTM(this.f57009b, "p2pThemesBaseURL") != null && !b.a().getStringFromGTM(this.f57009b, "p2pThemesBaseURL").isEmpty()) {
                    str = b.a().getStringFromGTM(this.f57009b, "p2pThemesBaseURL");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                AppExecutor.getExecutor().runOnUiThread(new Runnable(new net.one97.paytm.network.b(str, new DealsEntity(), hashMap, (Map<String, String>) null, (String) null)) {
                    private final /* synthetic */ net.one97.paytm.network.b f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        g.this.a(this.f$1);
                    }
                });
                return;
            }
            if (b.a().getStringFromGTM(this.f57009b, "p2pThemesBaseURL") != null && !b.a().getStringFromGTM(this.f57009b, "p2pThemesBaseURL").isEmpty()) {
                str = b.a().getStringFromGTM(this.f57009b, "p2pThemesBaseURL");
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", getClass().getSimpleName());
            AppExecutor.getExecutor().runOnUiThread(new Runnable(new net.one97.paytm.network.b(str, new DealsEntity(), hashMap2, (Map<String, String>) null, (String) null)) {
                private final /* synthetic */ net.one97.paytm.network.b f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    g.this.b(this.f$1);
                }
            });
        }
    }

    private void b(String str) {
        String str2;
        if (b.a().getStringFromGTM(this.f57009b, "p2pThemesAssetsURL") == null || b.a().getStringFromGTM(this.f57009b, "p2pThemesAssetsURL").isEmpty()) {
            str2 = "https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/catalog/wallet/" + str + ".json";
        } else {
            str2 = b.a().getStringFromGTM(this.f57009b, "p2pThemesAssetsURL") + str + ".json";
        }
        new a(str2, new AnimationJson(), (Map<String, String>) null, (Map<String, String>) null).c().observeForever(new z(str) {
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                g.this.a(this.f$1, (net.one97.paytm.network.f) obj);
            }
        });
    }

    public final boolean d() {
        return this.f57008a;
    }

    public final void e() {
        this.f57008a = true;
    }

    private void a(DealsEntity dealsEntity) {
        AppExecutor.getExecutor().runOnBgThread(new Runnable(dealsEntity) {
            private final /* synthetic */ DealsEntity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                g.this.c(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DealsEntity dealsEntity) {
        e.a(this.f57009b, dealsEntity, "theme_data");
        AppExecutor.getExecutor().runOnUiThread(new Runnable(dealsEntity) {
            private final /* synthetic */ DealsEntity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                g.this.b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AnimationJson animationJson, String str) {
        String json = animationJson.getJson();
        Object a2 = e.a(this.f57009b, "theme_data");
        DealsEntity dealsEntity = (DealsEntity) a2;
        if (dealsEntity != null && dealsEntity.getGrid_layout() != null) {
            int i2 = 0;
            while (true) {
                if (i2 < dealsEntity.getGrid_layout().size()) {
                    if (dealsEntity.getGrid_layout().get(i2).getProductID() != null && dealsEntity.getGrid_layout().get(i2).getProductID().equalsIgnoreCase(str)) {
                        dealsEntity.getGrid_layout().get(i2).setJsonValue(json);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            e.a(this.f57009b, a2, "theme_data");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DealsEntity dealsEntity) {
        Iterator<CJRGridProduct> it2 = dealsEntity.getGrid_layout().iterator();
        while (it2.hasNext()) {
            b(it2.next().getProductID());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            AppExecutor.getExecutor().runOnHandlerThread(new Runnable((AnimationJson) fVar.f55797b, str) {
                private final /* synthetic */ AnimationJson f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    g.this.a(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.b bVar) {
        bVar.c().observeForever(new z() {
            public final void onChanged(Object obj) {
                g.this.a((net.one97.paytm.network.f) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            if (iJRPaytmDataModel instanceof DealsEntity) {
                DealsEntity dealsEntity = (DealsEntity) iJRPaytmDataModel;
                DealsEntity dealsEntity2 = (DealsEntity) e.a(this.f57009b, "theme_data");
                if (dealsEntity2 == null || dealsEntity.getGrid_layout().size() != dealsEntity2.getGrid_layout().size()) {
                    a(dealsEntity);
                    return;
                }
                Iterator<CJRGridProduct> it2 = dealsEntity.getGrid_layout().iterator();
                while (it2.hasNext()) {
                    CJRGridProduct next = it2.next();
                    Iterator<CJRGridProduct> it3 = dealsEntity2.getGrid_layout().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        CJRGridProduct next2 = it3.next();
                        if (next.getProductID().equalsIgnoreCase(next2.getProductID()) && !next.getLastUpdatedAt().equalsIgnoreCase(next2.getLastUpdatedAt())) {
                            b(next.getProductID());
                            break;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.b bVar) {
        bVar.c().observeForever(new z() {
            public final void onChanged(Object obj) {
                g.this.b((net.one97.paytm.network.f) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS && (fVar.f55797b instanceof DealsEntity)) {
            this.f57010c = (DealsEntity) fVar.f55797b;
            a(this.f57010c);
        }
    }
}
