package net.one97.paytm.landingpage;

import com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f52640b;

    /* renamed from: a  reason: collision with root package name */
    public HomeResponse f52641a;

    /* renamed from: c  reason: collision with root package name */
    private ISFPrewarmedResponseAvailableListener f52642c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f52643d = false;

    public static a a() {
        if (f52640b == null) {
            f52640b = new a();
        }
        return f52640b;
    }

    public final HomeResponse b() {
        HomeResponse homeResponse = this.f52641a;
        if (homeResponse != null) {
            homeResponse.setDataSource(HomeUtils.INSTANCE.getDATA_SOURCE_UNKNOWN());
        }
        return this.f52641a;
    }

    public final synchronized void a(HomeResponse homeResponse) {
        StringBuilder sb = new StringBuilder("Saving PRE-HEAT DATA ");
        sb.append(homeResponse == null);
        HomeUtils.d(sb.toString(), false);
        this.f52641a = homeResponse;
        if (this.f52642c != null) {
            if (this.f52641a != null) {
                this.f52641a.setDataSource(HomeUtils.INSTANCE.getDATA_SOURCE_UNKNOWN());
            }
            this.f52642c.onPrewarmedResponseAvailable(homeResponse);
        }
    }

    public final synchronized void a(ISFPrewarmedResponseAvailableListener iSFPrewarmedResponseAvailableListener, boolean z) {
        HomeUtils.d("setSFPrewarmedResponseAvailableListener called", true);
        HomeUtils.d("setSFPrewarmedResponseAvailableListener sharedSavedResponseIfNotNull ".concat(String.valueOf(z)), true);
        StringBuilder sb = new StringBuilder("setSFPrewarmedResponseAvailableListener sfPrewarmedResponseAvailableListener");
        sb.append(iSFPrewarmedResponseAvailableListener != null);
        HomeUtils.d(sb.toString(), true);
        HomeUtils.d("setSFPrewarmedResponseAvailableListener isPreWarmingInProgress" + c(), true);
        this.f52642c = iSFPrewarmedResponseAvailableListener;
        if (z && !c() && iSFPrewarmedResponseAvailableListener != null) {
            iSFPrewarmedResponseAvailableListener.onPrewarmedResponseAvailable(this.f52641a);
        }
    }

    private synchronized boolean c() {
        return this.f52643d;
    }

    public final synchronized void a(boolean z) {
        this.f52643d = z;
    }
}
