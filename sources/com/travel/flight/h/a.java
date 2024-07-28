package com.travel.flight.h;

import android.widget.ImageView;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.g.b;
import com.travel.utils.n;
import kotlin.g.b.k;
import net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse;

public final class a extends ai implements b {

    /* renamed from: d  reason: collision with root package name */
    public static final C0474a f25406d = new C0474a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public y<net.one97.paytmflight.common.entity.prioritycheckinentity.a> f25407a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public com.travel.flight.g.a f25408b = new com.travel.flight.g.a(this);

    /* renamed from: c  reason: collision with root package name */
    public y<NetworkCustomError> f25409c = new y<>();

    private void a(net.one97.paytmflight.common.entity.prioritycheckinentity.a aVar) {
        k.c(aVar, "formattedResponse");
        this.f25407a.postValue(aVar);
    }

    public final void a(NetworkCustomError networkCustomError) {
        a(false);
        this.f25409c.postValue(networkCustomError);
    }

    public final void a(IJRPriorityCheckinResponse iJRPriorityCheckinResponse) {
        k.c(iJRPriorityCheckinResponse, Payload.RESPONSE);
        Integer code = iJRPriorityCheckinResponse.getCode();
        Boolean valueOf = code != null ? Boolean.valueOf(code.equals(200)) : null;
        if (valueOf != null ? valueOf.booleanValue() : false) {
            IJRPriorityCheckinResponse.Body body = iJRPriorityCheckinResponse.getBody();
            if (body != null) {
                a(body.is_valid_booking());
                return;
            }
            return;
        }
        a(false);
    }

    public final void a(boolean z) {
        net.one97.paytmflight.common.entity.prioritycheckinentity.a aVar = new net.one97.paytmflight.common.entity.prioritycheckinentity.a();
        aVar.f30020a = z;
        if (z) {
            aVar.b(this.f25408b.a(z));
            aVar.c(this.f25408b.b(z));
            aVar.d(this.f25408b.a());
            aVar.e(this.f25408b.b());
            aVar.a(com.travel.flight.g.a.c(z));
        } else {
            aVar.b(this.f25408b.a(z));
            aVar.c(this.f25408b.b(z));
            aVar.a(com.travel.flight.g.a.c(z));
        }
        a(aVar);
    }

    /* renamed from: com.travel.flight.h.a$a  reason: collision with other inner class name */
    public static final class C0474a {
        private C0474a() {
        }

        public /* synthetic */ C0474a(byte b2) {
            this();
        }
    }

    public final void onCleared() {
        super.onCleared();
    }

    public static final void a(ImageView imageView, String str) {
        k.c(imageView, "imageView");
        k.c(str, "formattedResponseImage");
        ResourceUtils.loadFlightImagesFromCDN(imageView, str, false, false, n.a.V1);
    }
}
