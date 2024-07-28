package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.provider.H5PartnerAppsDataProvider;

public final class d extends net.one97.paytm.phoenix.core.a {
    public d() {
        super("paytmFetchPartnersAppData");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        Activity activity = h5Event.getActivity();
        if (activity != null) {
            kotlin.c.a.a(true, new a(activity, this, h5Event), 30);
        }
        return true;
    }

    static final class a extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ H5Event $event$inlined;
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Activity activity, d dVar, H5Event h5Event) {
            super(0);
            this.$activity = activity;
            this.this$0 = dVar;
            this.$event$inlined = h5Event;
        }

        public final void invoke() {
            H5PartnerAppsDataProvider.getPartnerData(this.$activity, new H5PartnerAppsDataProvider.H5PartnerAppsDataProviderCallback(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f19756a;

                {
                    this.f19756a = r1;
                }

                public final void onAppUrlFetched(final String str) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f19757a;

                        {
                            this.f19757a = r1;
                        }

                        public final void run() {
                            if (str != null) {
                                try {
                                    net.one97.paytm.phoenix.core.a.a(this.f19757a.f19756a.this$0, this.f19757a.f19756a.$event$inlined, str, false, 4);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            } else {
                                this.f19757a.f19756a.this$0.a(this.f19757a.f19756a.$event$inlined, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "");
                            }
                        }
                    });
                }

                public final void onError(String str) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f19759a;

                        {
                            this.f19759a = r1;
                        }

                        public final void run() {
                            this.f19759a.f19756a.this$0.a(this.f19759a.f19756a.$event$inlined, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "");
                        }
                    });
                }
            });
        }
    }
}
