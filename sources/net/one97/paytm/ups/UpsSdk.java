package net.one97.paytm.ups;

import android.app.Application;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.ups.manager.DatabaseManager;
import net.one97.paytm.ups.network.UpsNetwork;
import net.one97.paytm.ups.provider.UpsJarvisInterface;
import net.one97.paytm.ups.sdk.UpsSdkInterface;

public final class UpsSdk implements UpsSdkInterface {
    public static final UpsSdk INSTANCE = new UpsSdk();
    private static Application applicationContext;
    private static boolean isSdkInitDone;
    /* access modifiers changed from: private */
    public static UpsJarvisInterface upsJarvisProvider;

    private UpsSdk() {
    }

    public static final /* synthetic */ UpsJarvisInterface access$getUpsJarvisProvider$p(UpsSdk upsSdk) {
        UpsJarvisInterface upsJarvisInterface = upsJarvisProvider;
        if (upsJarvisInterface == null) {
            k.a("upsJarvisProvider");
        }
        return upsJarvisInterface;
    }

    public final boolean initSDK(UpsJarvisInterface upsJarvisInterface) {
        k.c(upsJarvisInterface, "upsJarvisProvider");
        boolean z = isSdkInitDone;
        if (z) {
            return z;
        }
        upsJarvisProvider = upsJarvisInterface;
        applicationContext = upsJarvisInterface.getApplicationContext();
        DatabaseManager databaseManager = DatabaseManager.INSTANCE;
        Application application = applicationContext;
        if (application == null) {
            k.a("applicationContext");
        }
        databaseManager.initDatabase(application);
        UpsNetwork.INSTANCE.initUpsSdkHelper(this);
        isSdkInitDone = true;
        return true;
    }

    public final Application getApplicationContext() {
        if (!isSdkInitDone) {
            return null;
        }
        Application application = applicationContext;
        if (application != null) {
            return application;
        }
        k.a("applicationContext");
        return application;
    }

    public final String getSSOToken() {
        UpsJarvisInterface upsJarvisInterface = upsJarvisProvider;
        if (upsJarvisInterface == null) {
            k.a("upsJarvisProvider");
        }
        return upsJarvisInterface.getSSOToken();
    }

    public final boolean isLoggedIn() {
        UpsJarvisInterface upsJarvisInterface = upsJarvisProvider;
        if (upsJarvisInterface == null) {
            return false;
        }
        if (upsJarvisInterface == null) {
            k.a("upsJarvisProvider");
        }
        String sSOToken = upsJarvisInterface.getSSOToken();
        if (sSOToken == null) {
            throw null;
        } else if (sSOToken.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public final void onLogout() {
        nukeTable();
    }

    private final void nukeTable() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new UpsSdk$nukeTable$1((d) null), 2, (Object) null);
    }

    public final UpsJarvisInterface getProvider() {
        UpsJarvisInterface upsJarvisInterface = upsJarvisProvider;
        if (upsJarvisInterface == null) {
            k.a("upsJarvisProvider");
        }
        return upsJarvisInterface;
    }
}
