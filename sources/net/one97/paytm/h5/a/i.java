package net.one97.paytm.h5.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.utility.q;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.h5paytmsdk.b.ad;
import net.one97.paytm.phoenix.provider.H5PartnerAppsDataProvider;

public final class i extends ad {
    public i() {
        super("paytmFetchPartnersAppData");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Activity activity;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!(!a(h5Event) || h5Event == null || (activity = h5Event.getActivity()) == null)) {
            kotlin.c.a.a(true, new a(activity, this), 30);
        }
        return true;
    }

    static final class a extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ i this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Activity activity, i iVar) {
            super(0);
            this.$activity = activity;
            this.this$0 = iVar;
        }

        public final void invoke() {
            H5PartnerAppsDataProvider.getPartnerData(this.$activity, new H5PartnerAppsDataProvider.H5PartnerAppsDataProviderCallback(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f16859a;

                {
                    this.f16859a = r1;
                }

                public final void onAppUrlFetched(final String str) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f16860a;

                        {
                            this.f16860a = r1;
                        }

                        public final void run() {
                            if (str != null) {
                                try {
                                    this.f16860a.f16859a.this$0.a((Object) str);
                                } catch (Exception e2) {
                                    q.b(e2.getMessage());
                                }
                            } else {
                                this.f16860a.f16859a.this$0.a(H5Event.Error.UNKNOWN_ERROR, "");
                            }
                        }
                    });
                }

                public final void onError(String str) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f16862a;

                        {
                            this.f16862a = r1;
                        }

                        public final void run() {
                            this.f16862a.f16859a.this$0.a(H5Event.Error.UNKNOWN_ERROR, "");
                        }
                    });
                }
            });
        }
    }
}
