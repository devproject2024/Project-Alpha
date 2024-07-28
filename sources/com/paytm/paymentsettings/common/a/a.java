package com.paytm.paymentsettings.common.a;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestHead;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.p;

public final class a {

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43412a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f43413b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43414c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f43415d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f43416e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f43417f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionRequestBody f43418g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionRequestHead f43419h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.b f43420i;
        final /* synthetic */ String j;

        public c(String str, Map map, String str2, d dVar, long j2, Context context, ActiveSubscriptionRequestBody activeSubscriptionRequestBody, ActiveSubscriptionRequestHead activeSubscriptionRequestHead, com.paytm.network.b bVar, String str3) {
            this.f43412a = str;
            this.f43413b = map;
            this.f43414c = str2;
            this.f43415d = dVar;
            this.f43416e = j2;
            this.f43417f = context;
            this.f43418g = activeSubscriptionRequestBody;
            this.f43419h = activeSubscriptionRequestHead;
            this.f43420i = bVar;
            this.j = str3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0033, code lost:
            r11 = (r11 = r11.getResultInfo()).getCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r11) {
            /*
                r10 = this;
                java.lang.String r0 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r11, r0)
                kotlin.d.d r0 = r10.f43415d
                kotlin.p$a r1 = kotlin.p.Companion
                java.lang.Object r1 = kotlin.p.m530constructorimpl(r11)
                r0.resumeWith(r1)
                android.content.Context r0 = r10.f43417f
                com.paytm.paymentsettings.common.b.a r1 = com.paytm.paymentsettings.common.b.a.a(r0)
                java.lang.String r3 = r10.f43412a
                long r4 = r10.f43416e
                long r6 = java.lang.System.currentTimeMillis()
                long r8 = r10.f43416e
                long r6 = r6 - r8
                java.lang.String r6 = java.lang.String.valueOf(r6)
                com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse r11 = (com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse) r11
                com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsBody r11 = r11.getBody()
                if (r11 == 0) goto L_0x003f
                com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsResultInfo r11 = r11.getResultInfo()
                if (r11 == 0) goto L_0x003f
                java.lang.String r11 = r11.getCode()
                if (r11 == 0) goto L_0x003f
                int r11 = java.lang.Integer.parseInt(r11)
                r7 = r11
                goto L_0x0041
            L_0x003f:
                r11 = 0
                r7 = 0
            L_0x0041:
                r2 = 0
                r1.a(r2, r3, r4, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.common.a.a.c.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            d dVar = this.f43415d;
            p.a aVar = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(ResultKt.a((Throwable) networkCustomError)));
            com.paytm.paymentsettings.common.b.a.a(this.f43417f).a(true, this.f43412a, this.f43416e, String.valueOf(System.currentTimeMillis() - this.f43416e), networkCustomError.getStatusCode());
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43403a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f43404b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43405c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f43406d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f43407e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f43408f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ EditSubscriptionRequestBody f43409g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ EditSubscriptionRequestHead f43410h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.b f43411i;
        final /* synthetic */ String j;

        public b(String str, Map map, String str2, d dVar, long j2, Context context, EditSubscriptionRequestBody editSubscriptionRequestBody, EditSubscriptionRequestHead editSubscriptionRequestHead, com.paytm.network.b bVar, String str3) {
            this.f43403a = str;
            this.f43404b = map;
            this.f43405c = str2;
            this.f43406d = dVar;
            this.f43407e = j2;
            this.f43408f = context;
            this.f43409g = editSubscriptionRequestBody;
            this.f43410h = editSubscriptionRequestHead;
            this.f43411i = bVar;
            this.j = str3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0033, code lost:
            r11 = (r11 = r11.getResultInfo()).getCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r11) {
            /*
                r10 = this;
                java.lang.String r0 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r11, r0)
                kotlin.d.d r0 = r10.f43406d
                kotlin.p$a r1 = kotlin.p.Companion
                java.lang.Object r1 = kotlin.p.m530constructorimpl(r11)
                r0.resumeWith(r1)
                android.content.Context r0 = r10.f43408f
                com.paytm.paymentsettings.common.b.a r1 = com.paytm.paymentsettings.common.b.a.a(r0)
                java.lang.String r3 = r10.f43403a
                long r4 = r10.f43407e
                long r6 = java.lang.System.currentTimeMillis()
                long r8 = r10.f43407e
                long r6 = r6 - r8
                java.lang.String r6 = java.lang.String.valueOf(r6)
                com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse r11 = (com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse) r11
                com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseBody r11 = r11.getBody()
                if (r11 == 0) goto L_0x003f
                com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseResultInfo r11 = r11.getResultInfo()
                if (r11 == 0) goto L_0x003f
                java.lang.String r11 = r11.getCode()
                if (r11 == 0) goto L_0x003f
                int r11 = java.lang.Integer.parseInt(r11)
                r7 = r11
                goto L_0x0041
            L_0x003f:
                r11 = 0
                r7 = 0
            L_0x0041:
                r2 = 0
                r1.a(r2, r3, r4, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.common.a.a.b.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            d dVar = this.f43406d;
            p.a aVar = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(ResultKt.a((Throwable) networkCustomError)));
            com.paytm.paymentsettings.common.b.a.a(this.f43408f).a(true, this.f43403a, this.f43407e, String.valueOf(System.currentTimeMillis() - this.f43407e), networkCustomError.getStatusCode());
        }
    }

    /* renamed from: com.paytm.paymentsettings.common.a.a$a  reason: collision with other inner class name */
    public static final class C0734a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43394a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f43395b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43396c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f43397d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f43398e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f43399f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ AuthorisedEditSubscriptionRequestBody f43400g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ AuthorisedEditSubscriptionRequestHead f43401h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.b f43402i;
        final /* synthetic */ String j;

        public C0734a(String str, Map map, String str2, d dVar, long j2, Context context, AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody, AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead, com.paytm.network.b bVar, String str3) {
            this.f43394a = str;
            this.f43395b = map;
            this.f43396c = str2;
            this.f43397d = dVar;
            this.f43398e = j2;
            this.f43399f = context;
            this.f43400g = authorisedEditSubscriptionRequestBody;
            this.f43401h = authorisedEditSubscriptionRequestHead;
            this.f43402i = bVar;
            this.j = str3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0033, code lost:
            r11 = (r11 = r11.getResultInfo()).getCode();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r11) {
            /*
                r10 = this;
                java.lang.String r0 = "ijrPaytmDataModel"
                kotlin.g.b.k.c(r11, r0)
                kotlin.d.d r0 = r10.f43397d
                kotlin.p$a r1 = kotlin.p.Companion
                java.lang.Object r1 = kotlin.p.m530constructorimpl(r11)
                r0.resumeWith(r1)
                android.content.Context r0 = r10.f43399f
                com.paytm.paymentsettings.common.b.a r1 = com.paytm.paymentsettings.common.b.a.a(r0)
                java.lang.String r3 = r10.f43394a
                long r4 = r10.f43398e
                long r6 = java.lang.System.currentTimeMillis()
                long r8 = r10.f43398e
                long r6 = r6 - r8
                java.lang.String r6 = java.lang.String.valueOf(r6)
                com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse r11 = (com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse) r11
                com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseBody r11 = r11.getBody()
                if (r11 == 0) goto L_0x003f
                com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseResultInfo r11 = r11.getResultInfo()
                if (r11 == 0) goto L_0x003f
                java.lang.String r11 = r11.getCode()
                if (r11 == 0) goto L_0x003f
                int r11 = java.lang.Integer.parseInt(r11)
                r7 = r11
                goto L_0x0041
            L_0x003f:
                r11 = 0
                r7 = 0
            L_0x0041:
                r2 = 1
                r1.a(r2, r3, r4, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.common.a.a.C0734a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            d dVar = this.f43397d;
            p.a aVar = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(ResultKt.a((Throwable) networkCustomError)));
            com.paytm.paymentsettings.common.b.a.a(this.f43399f).a(true, this.f43394a, this.f43398e, String.valueOf(System.currentTimeMillis() - this.f43398e), networkCustomError.getStatusCode());
        }
    }
}
