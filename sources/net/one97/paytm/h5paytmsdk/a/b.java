package net.one97.paytm.h5paytmsdk.a;

import android.app.Application;
import android.content.Context;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKitConfig;
import com.alipay.mobile.b.a.a.a;
import java.util.Map;
import net.one97.paytm.h5paytmsdk.d.f;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f16960a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16961b = false;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, SubAppConfig> f16962c = null;

    public static b a() {
        if (f16960a == null) {
            synchronized (b.class) {
                if (f16960a == null) {
                    f16960a = new b();
                }
            }
        }
        return f16960a;
    }

    public final void a(Application application, String str, net.one97.paytm.h5paytmsdk.c.b bVar, boolean z) {
        if (!this.f16961b) {
            c.a((Context) application);
            a.a(application);
            c.a((com.alipay.iap.android.common.b.a) new a(z));
            if (f.a(application)) {
                com.alipay.iap.android.common.d.a.a aVar = new com.alipay.iap.android.common.d.a.a();
                aVar.appId = bVar.b();
                aVar.appKey = bVar.c();
                aVar.productId = bVar.d();
                aVar.gatewayUrl = bVar.e();
                aVar.environment = bVar.a();
                aVar.authCode = bVar.i();
                aVar.addHeader("appId", bVar.b());
                aVar.addHeader("workspaceId", bVar.f());
                try {
                    com.alipay.iap.android.common.c.a.a(application, aVar.appId, aVar.appKey, aVar.gatewayUrl);
                } catch (Exception unused) {
                    c.j();
                }
                AppContainerKitConfig appContainerKitConfig = new AppContainerKitConfig();
                appContainerKitConfig.presetAppsAssetsPathName = "presets";
                appContainerKitConfig.appPublicKey = str;
                appContainerKitConfig.appendedUserAgent = "AppContainer";
                AppContainerKit.getInstance().initialize(application, appContainerKitConfig);
            }
            this.f16961b = true;
            new StringBuilder("Init: getEnvironment:").append(bVar.a());
            c.c();
            new StringBuilder("Init: getAuthCode:").append(bVar.i());
            c.c();
            new StringBuilder("Init: getLogHost:").append(bVar.j());
            c.c();
            new StringBuilder("Init: getLogProductId:").append(bVar.k());
            c.c();
            new StringBuilder("Init: getMpassAppId:").append(bVar.b());
            c.c();
            new StringBuilder("Init: getMpassAppKey:").append(bVar.c());
            c.c();
            new StringBuilder("Init: getMpassAppProductId:").append(bVar.d());
            c.c();
            new StringBuilder("Init: getMpassWorkspaceId:").append(bVar.f());
            c.c();
            new StringBuilder("Init: getRpcGatewayUrl:").append(bVar.e());
            c.c();
            new StringBuilder("Init: getSyncServerAddress:").append(bVar.g());
            c.c();
            new StringBuilder("Init: getSyncServerPort:").append(bVar.h());
            c.c();
        }
    }

    public final Map<String, SubAppConfig> b() {
        return this.f16962c;
    }
}
