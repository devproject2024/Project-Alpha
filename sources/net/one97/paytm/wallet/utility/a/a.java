package net.one97.paytm.wallet.utility.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.GlobalError;
import net.one97.paytm.common.entity.p2p.MerchantInfo;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SenderInfo;
import net.one97.paytm.network.f;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.newdesign.universalp2p.a;
import net.one97.paytm.wallet.p2p.a;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f72259a;

    /* renamed from: b  reason: collision with root package name */
    public static net.one97.paytm.network.a f72260b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f72261c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static String f72262d;

    /* renamed from: net.one97.paytm.wallet.utility.a.a$a  reason: collision with other inner class name */
    public static final class C1464a<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f72263a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.c f72264b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f72265c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f72266d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f72267e = true;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ x.e f72268f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f72269g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f72270h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f72271i;

        public C1464a(String str, a.c cVar, Activity activity, String str2, x.e eVar, String str3) {
            this.f72263a = str;
            this.f72264b = cVar;
            this.f72265c = activity;
            this.f72266d = str2;
            this.f72268f = eVar;
            this.f72269g = str3;
            this.f72270h = false;
            this.f72271i = false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: net.one97.paytm.network.g} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v7 */
        /* JADX WARNING: type inference failed for: r3v10 */
        /* JADX WARNING: type inference failed for: r3v11 */
        /* JADX WARNING: type inference failed for: r3v12 */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            r0 = (r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r13.f55797b).getReceiverInfo();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r13) {
            /*
                r12 = this;
                net.one97.paytm.network.f r13 = (net.one97.paytm.network.f) r13
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.SUCCESS
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x0096
                if (r13 == 0) goto L_0x000f
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                goto L_0x0010
            L_0x000f:
                r0 = r3
            L_0x0010:
                boolean r0 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r0 == 0) goto L_0x01c5
                if (r13 == 0) goto L_0x0027
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0027
                net.one97.paytm.common.entity.p2p.ReceiverInfo r0 = r0.getReceiverInfo()
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r0.getName()
                goto L_0x0028
            L_0x0027:
                r0 = r3
            L_0x0028:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x0043
                if (r13 == 0) goto L_0x0043
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0043
                net.one97.paytm.common.entity.p2p.ReceiverInfo r0 = r0.getReceiverInfo()
                if (r0 == 0) goto L_0x0043
                java.lang.String r1 = r12.f72263a
                r0.setContactName(r1)
            L_0x0043:
                if (r13 == 0) goto L_0x0050
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0050
                java.lang.String r0 = r0.getCategory()
                goto L_0x0051
            L_0x0050:
                r0 = r3
            L_0x0051:
                java.lang.String r1 = "P2M"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                if (r0 == 0) goto L_0x008c
                net.one97.paytm.wallet.p2p.a$c r0 = r12.f72264b
                if (r0 == 0) goto L_0x0060
                r0.stopProgress()
            L_0x0060:
                net.one97.paytm.wallet.utility.a.a r0 = net.one97.paytm.wallet.utility.a.a.f72261c
                android.app.Activity r0 = r12.f72265c
                if (r13 == 0) goto L_0x0068
                com.paytm.network.model.IJRPaytmDataModel r3 = r13.f55797b
            L_0x0068:
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r3 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r3
                java.lang.String r13 = r12.f72266d
                net.one97.paytm.wallet.utility.a.a.a((android.app.Activity) r0, (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r3, (java.lang.String) r13)
                boolean r13 = r12.f72267e
                if (r13 == 0) goto L_0x007f
                android.app.Activity r13 = r12.f72265c
                boolean r0 = r13 instanceof net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2
                if (r0 == 0) goto L_0x0086
                net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2 r13 = (net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2) r13
                r13.h()
                goto L_0x0086
            L_0x007f:
                android.app.Activity r13 = r12.f72265c
                if (r13 == 0) goto L_0x0086
                r13.finish()
            L_0x0086:
                net.one97.paytm.wallet.utility.a.a r13 = net.one97.paytm.wallet.utility.a.a.f72261c
                net.one97.paytm.wallet.utility.a.a.d()
                return
            L_0x008c:
                kotlin.g.b.x$e r0 = r12.f72268f
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x0096:
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.ERROR
                if (r0 != r1) goto L_0x01c5
                net.one97.paytm.wallet.utility.a.a r0 = net.one97.paytm.wallet.utility.a.a.f72261c
                net.one97.paytm.wallet.utility.a.a.d()
                if (r13 == 0) goto L_0x00aa
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x00aa
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x00ab
            L_0x00aa:
                r0 = r3
            L_0x00ab:
                boolean r0 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r0 == 0) goto L_0x00f3
                if (r13 == 0) goto L_0x00b8
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x00b8
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x00b9
            L_0x00b8:
                r0 = r3
            L_0x00b9:
                if (r0 == 0) goto L_0x00eb
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                java.lang.String r0 = r0.getRespCode()
                if (r0 != 0) goto L_0x00c6
                kotlin.g.b.k.a()
            L_0x00c6:
                java.lang.String r1 = "BT_INV_435"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                if (r0 == 0) goto L_0x00f3
                net.one97.paytm.wallet.utility.a.a r13 = net.one97.paytm.wallet.utility.a.a.f72261c
                android.app.Activity r13 = r12.f72265c
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r0 = r12.f72263a
                java.lang.String r1 = r12.f72266d
                net.one97.paytm.wallet.utility.a.a.a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r1)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72268f
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x00eb:
                kotlin.u r13 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse"
                r13.<init>(r0)
                throw r13
            L_0x00f3:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x0102
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x0102
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x0103
            L_0x0102:
                r0 = r3
            L_0x0103:
                if (r0 != 0) goto L_0x0108
                kotlin.g.b.k.a()
            L_0x0108:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                java.lang.String r1 = "MT_HOME_CONTACTS"
                if (r0 == 0) goto L_0x0157
                java.lang.String r0 = r12.f72269g
                if (r0 == 0) goto L_0x0121
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x0122
            L_0x0121:
                r0 = r3
            L_0x0122:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0157
                android.os.Bundle r0 = new android.os.Bundle
                r0.<init>()
                r1 = 0
                java.lang.String r2 = "key_is_from_fragment"
                r0.putBoolean(r2, r1)
                net.one97.paytm.utils.ae r1 = net.one97.paytm.utils.ae.f69602a
                android.app.Activity r1 = r12.f72265c
                if (r13 == 0) goto L_0x013b
                net.one97.paytm.network.g r3 = r13.f55798c
            L_0x013b:
                int r13 = r3.f55799a
                com.paytm.network.model.NetworkCustomError r2 = new com.paytm.network.model.NetworkCustomError
                r2.<init>()
                java.lang.String r3 = "generic_api_call_fail"
                net.one97.paytm.utils.ae.a(r1, r13, r2, r0, r3)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72268f
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x0157:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x0166
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x0166
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x0167
            L_0x0166:
                r0 = r3
            L_0x0167:
                if (r0 != 0) goto L_0x016c
                kotlin.g.b.k.a()
            L_0x016c:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                if (r0 != 0) goto L_0x01bc
                java.lang.String r0 = r12.f72269g
                if (r0 == 0) goto L_0x0182
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            L_0x0182:
                boolean r0 = r3.booleanValue()
                if (r0 == 0) goto L_0x01bc
                net.one97.paytm.wallet.utility.d r13 = net.one97.paytm.wallet.utility.d.f72319a
                android.app.Activity r0 = r12.f72265c
                r1 = 0
                r2 = 0
                r13 = r0
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r3 = com.paytm.utility.b.j((android.content.Context) r13)
                android.app.Activity r13 = r12.f72265c
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r4 = com.paytm.utility.b.l((android.content.Context) r13)
                java.lang.String r5 = r12.f72263a
                java.lang.String r6 = r12.f72266d
                r7 = 0
                r8 = 0
                boolean r9 = r12.f72267e
                boolean r10 = r12.f72270h
                boolean r11 = r12.f72271i
                net.one97.paytm.wallet.utility.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72268f
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x01bc:
                kotlin.g.b.x$e r0 = r12.f72268f
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
            L_0x01c5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.a.C1464a.onChanged(java.lang.Object):void");
        }
    }

    static final class b<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f72272a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f72273b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f72274c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f72275d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f72276e;

        b(String str, Activity activity, String str2, x.e eVar, String str3) {
            this.f72272a = str;
            this.f72273b = activity;
            this.f72274c = str2;
            this.f72275d = eVar;
            this.f72276e = str3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: net.one97.paytm.network.g} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v7 */
        /* JADX WARNING: type inference failed for: r3v10 */
        /* JADX WARNING: type inference failed for: r3v11 */
        /* JADX WARNING: type inference failed for: r3v12 */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            r0 = (r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r13.f55797b).getReceiverInfo();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r13) {
            /*
                r12 = this;
                net.one97.paytm.network.f r13 = (net.one97.paytm.network.f) r13
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.SUCCESS
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x007f
                if (r13 == 0) goto L_0x000f
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                goto L_0x0010
            L_0x000f:
                r0 = r3
            L_0x0010:
                boolean r0 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r0 == 0) goto L_0x01ab
                if (r13 == 0) goto L_0x0027
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0027
                net.one97.paytm.common.entity.p2p.ReceiverInfo r0 = r0.getReceiverInfo()
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r0.getName()
                goto L_0x0028
            L_0x0027:
                r0 = r3
            L_0x0028:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x0043
                if (r13 == 0) goto L_0x0043
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0043
                net.one97.paytm.common.entity.p2p.ReceiverInfo r0 = r0.getReceiverInfo()
                if (r0 == 0) goto L_0x0043
                java.lang.String r1 = r12.f72272a
                r0.setContactName(r1)
            L_0x0043:
                if (r13 == 0) goto L_0x0050
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0050
                java.lang.String r0 = r0.getCategory()
                goto L_0x0051
            L_0x0050:
                r0 = r3
            L_0x0051:
                java.lang.String r1 = "P2M"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                if (r0 == 0) goto L_0x0075
                net.one97.paytm.wallet.utility.a.a r0 = net.one97.paytm.wallet.utility.a.a.f72261c
                android.app.Activity r0 = r12.f72273b
                if (r13 == 0) goto L_0x0061
                com.paytm.network.model.IJRPaytmDataModel r3 = r13.f55797b
            L_0x0061:
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r3 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r3
                java.lang.String r13 = r12.f72274c
                net.one97.paytm.wallet.utility.a.a.a((android.app.Activity) r0, (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r3, (java.lang.String) r13)
                android.app.Activity r13 = r12.f72273b
                if (r13 == 0) goto L_0x006f
                r13.finish()
            L_0x006f:
                net.one97.paytm.wallet.utility.a.a r13 = net.one97.paytm.wallet.utility.a.a.f72261c
                net.one97.paytm.wallet.utility.a.a.d()
                return
            L_0x0075:
                kotlin.g.b.x$e r0 = r12.f72275d
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x007f:
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.ERROR
                if (r0 != r1) goto L_0x01ab
                net.one97.paytm.wallet.utility.a.a r0 = net.one97.paytm.wallet.utility.a.a.f72261c
                net.one97.paytm.wallet.utility.a.a.d()
                if (r13 == 0) goto L_0x0093
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x0093
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x0094
            L_0x0093:
                r0 = r3
            L_0x0094:
                boolean r0 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r0 == 0) goto L_0x00dc
                if (r13 == 0) goto L_0x00a1
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x00a1
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x00a2
            L_0x00a1:
                r0 = r3
            L_0x00a2:
                if (r0 == 0) goto L_0x00d4
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                java.lang.String r0 = r0.getRespCode()
                if (r0 != 0) goto L_0x00af
                kotlin.g.b.k.a()
            L_0x00af:
                java.lang.String r1 = "BT_INV_435"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                if (r0 == 0) goto L_0x00dc
                net.one97.paytm.wallet.utility.a.a r13 = net.one97.paytm.wallet.utility.a.a.f72261c
                android.app.Activity r13 = r12.f72273b
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r0 = r12.f72272a
                java.lang.String r1 = r12.f72274c
                net.one97.paytm.wallet.utility.a.a.a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r1)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72275d
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x00d4:
                kotlin.u r13 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse"
                r13.<init>(r0)
                throw r13
            L_0x00dc:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x00eb
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x00eb
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x00ec
            L_0x00eb:
                r0 = r3
            L_0x00ec:
                if (r0 != 0) goto L_0x00f1
                kotlin.g.b.k.a()
            L_0x00f1:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                java.lang.String r1 = "MT_HOME_CONTACTS"
                if (r0 == 0) goto L_0x0140
                java.lang.String r0 = r12.f72276e
                if (r0 == 0) goto L_0x010a
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x010b
            L_0x010a:
                r0 = r3
            L_0x010b:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x0140
                android.os.Bundle r0 = new android.os.Bundle
                r0.<init>()
                r1 = 0
                java.lang.String r2 = "key_is_from_fragment"
                r0.putBoolean(r2, r1)
                net.one97.paytm.utils.ae r1 = net.one97.paytm.utils.ae.f69602a
                android.app.Activity r1 = r12.f72273b
                if (r13 == 0) goto L_0x0124
                net.one97.paytm.network.g r3 = r13.f55798c
            L_0x0124:
                int r13 = r3.f55799a
                com.paytm.network.model.NetworkCustomError r2 = new com.paytm.network.model.NetworkCustomError
                r2.<init>()
                java.lang.String r3 = "generic_api_call_fail"
                net.one97.paytm.utils.ae.a(r1, r13, r2, r0, r3)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72275d
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x0140:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x014f
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x014f
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x0150
            L_0x014f:
                r0 = r3
            L_0x0150:
                if (r0 != 0) goto L_0x0155
                kotlin.g.b.k.a()
            L_0x0155:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                if (r0 != 0) goto L_0x01a2
                java.lang.String r0 = r12.f72276e
                if (r0 == 0) goto L_0x016b
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            L_0x016b:
                boolean r0 = r3.booleanValue()
                if (r0 == 0) goto L_0x01a2
                net.one97.paytm.wallet.utility.d r13 = net.one97.paytm.wallet.utility.d.f72319a
                android.app.Activity r0 = r12.f72273b
                r1 = 0
                r2 = 0
                r13 = r0
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r3 = com.paytm.utility.b.j((android.content.Context) r13)
                android.app.Activity r13 = r12.f72273b
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r4 = com.paytm.utility.b.l((android.content.Context) r13)
                java.lang.String r5 = r12.f72272a
                java.lang.String r6 = r12.f72274c
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                net.one97.paytm.wallet.utility.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72275d
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x01a2:
                kotlin.g.b.x$e r0 = r12.f72275d
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
            L_0x01ab:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.a.b.onChanged(java.lang.Object):void");
        }
    }

    static final class c<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f72277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f72278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f72279c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f72280d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f72281e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f72282f = false;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f72283g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f72284h;

        c(String str, x.e eVar, Activity activity, String str2, String str3, boolean z, boolean z2) {
            this.f72277a = str;
            this.f72278b = eVar;
            this.f72279c = activity;
            this.f72280d = str2;
            this.f72281e = str3;
            this.f72283g = z;
            this.f72284h = z2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: net.one97.paytm.network.g} */
        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v7 */
        /* JADX WARNING: type inference failed for: r2v10 */
        /* JADX WARNING: type inference failed for: r2v11 */
        /* JADX WARNING: type inference failed for: r2v12 */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ac, code lost:
            r0 = r13.f55798c;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r13) {
            /*
                r12 = this;
                net.one97.paytm.network.f r13 = (net.one97.paytm.network.f) r13
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.SUCCESS
                r2 = 0
                if (r0 != r1) goto L_0x004a
                if (r13 == 0) goto L_0x000e
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                goto L_0x000f
            L_0x000e:
                r0 = r2
            L_0x000f:
                boolean r0 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r0 == 0) goto L_0x017a
                if (r13 == 0) goto L_0x0025
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0025
                net.one97.paytm.common.entity.p2p.ReceiverInfo r0 = r0.getReceiverInfo()
                if (r0 == 0) goto L_0x0025
                java.lang.String r2 = r0.getName()
            L_0x0025:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r0 == 0) goto L_0x0040
                if (r13 == 0) goto L_0x0040
                com.paytm.network.model.IJRPaytmDataModel r0 = r13.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                if (r0 == 0) goto L_0x0040
                net.one97.paytm.common.entity.p2p.ReceiverInfo r0 = r0.getReceiverInfo()
                if (r0 == 0) goto L_0x0040
                java.lang.String r1 = r12.f72277a
                r0.setContactName(r1)
            L_0x0040:
                kotlin.g.b.x$e r0 = r12.f72278b
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x004a:
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.ERROR
                if (r0 != r1) goto L_0x017a
                net.one97.paytm.wallet.utility.a.a r0 = net.one97.paytm.wallet.utility.a.a.f72261c
                net.one97.paytm.wallet.utility.a.a.d()
                if (r13 == 0) goto L_0x005e
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x005e
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x005f
            L_0x005e:
                r0 = r2
            L_0x005f:
                boolean r0 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                r1 = 1
                if (r0 == 0) goto L_0x00a8
                if (r13 == 0) goto L_0x006d
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x006d
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x006e
            L_0x006d:
                r0 = r2
            L_0x006e:
                if (r0 == 0) goto L_0x00a0
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                java.lang.String r0 = r0.getRespCode()
                if (r0 != 0) goto L_0x007b
                kotlin.g.b.k.a()
            L_0x007b:
                java.lang.String r3 = "BT_INV_435"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                if (r0 == 0) goto L_0x00a8
                net.one97.paytm.wallet.utility.a.a r13 = net.one97.paytm.wallet.utility.a.a.f72261c
                android.app.Activity r13 = r12.f72279c
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r0 = r12.f72277a
                java.lang.String r1 = r12.f72280d
                net.one97.paytm.wallet.utility.a.a.a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r1)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72278b
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x00a0:
                kotlin.u r13 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse"
                r13.<init>(r0)
                throw r13
            L_0x00a8:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x00b7
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x00b7
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x00b8
            L_0x00b7:
                r0 = r2
            L_0x00b8:
                if (r0 != 0) goto L_0x00bd
                kotlin.g.b.k.a()
            L_0x00bd:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                java.lang.String r3 = "MT_HOME_CONTACTS"
                if (r0 == 0) goto L_0x010c
                java.lang.String r0 = r12.f72281e
                if (r0 == 0) goto L_0x00d6
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x00d7
            L_0x00d6:
                r0 = r2
            L_0x00d7:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x010c
                android.os.Bundle r0 = new android.os.Bundle
                r0.<init>()
                r1 = 0
                java.lang.String r3 = "key_is_from_fragment"
                r0.putBoolean(r3, r1)
                net.one97.paytm.utils.ae r1 = net.one97.paytm.utils.ae.f69602a
                android.app.Activity r1 = r12.f72279c
                if (r13 == 0) goto L_0x00f0
                net.one97.paytm.network.g r2 = r13.f55798c
            L_0x00f0:
                int r13 = r2.f55799a
                com.paytm.network.model.NetworkCustomError r2 = new com.paytm.network.model.NetworkCustomError
                r2.<init>()
                java.lang.String r3 = "generic_api_call_fail"
                net.one97.paytm.utils.ae.a(r1, r13, r2, r0, r3)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72278b
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x010c:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x011b
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x011b
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x011c
            L_0x011b:
                r0 = r2
            L_0x011c:
                if (r0 != 0) goto L_0x0121
                kotlin.g.b.k.a()
            L_0x0121:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                if (r0 != 0) goto L_0x0171
                java.lang.String r0 = r12.f72281e
                if (r0 == 0) goto L_0x0137
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            L_0x0137:
                boolean r0 = r2.booleanValue()
                if (r0 == 0) goto L_0x0171
                net.one97.paytm.wallet.utility.d r13 = net.one97.paytm.wallet.utility.d.f72319a
                android.app.Activity r0 = r12.f72279c
                r1 = 0
                r2 = 0
                r13 = r0
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r3 = com.paytm.utility.b.j((android.content.Context) r13)
                android.app.Activity r13 = r12.f72279c
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r4 = com.paytm.utility.b.l((android.content.Context) r13)
                java.lang.String r5 = r12.f72277a
                java.lang.String r6 = r12.f72280d
                r7 = 0
                r8 = 0
                boolean r9 = r12.f72282f
                boolean r10 = r12.f72283g
                boolean r11 = r12.f72284h
                net.one97.paytm.wallet.utility.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72278b
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x0171:
                kotlin.g.b.x$e r0 = r12.f72278b
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
            L_0x017a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.a.c.onChanged(java.lang.Object):void");
        }
    }

    static final class d<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f72285a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f72286b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f72287c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f72288d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f72289e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f72290f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f72291g = false;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f72292h = false;

        d(x.e eVar, Activity activity, String str, String str2, String str3, boolean z) {
            this.f72285a = eVar;
            this.f72286b = activity;
            this.f72287c = str;
            this.f72288d = str2;
            this.f72289e = str3;
            this.f72290f = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: net.one97.paytm.network.g} */
        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v7 */
        /* JADX WARNING: type inference failed for: r2v9 */
        /* JADX WARNING: type inference failed for: r2v10 */
        /* JADX WARNING: type inference failed for: r2v11 */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
            r0 = r13.f55798c;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r13) {
            /*
                r12 = this;
                net.one97.paytm.network.f r13 = (net.one97.paytm.network.f) r13
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.SUCCESS
                r2 = 0
                if (r0 != r1) goto L_0x0013
                if (r13 == 0) goto L_0x000d
                com.paytm.network.model.IJRPaytmDataModel r2 = r13.f55797b
            L_0x000d:
                boolean r0 = r2 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r0 == 0) goto L_0x0143
                goto L_0x013a
            L_0x0013:
                net.one97.paytm.network.h r0 = r13.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.ERROR
                if (r0 != r1) goto L_0x0143
                net.one97.paytm.wallet.utility.a.a r0 = net.one97.paytm.wallet.utility.a.a.f72261c
                net.one97.paytm.wallet.utility.a.a.d()
                if (r13 == 0) goto L_0x0027
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x0027
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x0028
            L_0x0027:
                r0 = r2
            L_0x0028:
                boolean r0 = r0 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                r1 = 1
                if (r0 == 0) goto L_0x0071
                if (r13 == 0) goto L_0x0036
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x0036
                com.paytm.network.model.IJRPaytmDataModel r0 = r0.f55800b
                goto L_0x0037
            L_0x0036:
                r0 = r2
            L_0x0037:
                if (r0 == 0) goto L_0x0069
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r0 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r0
                java.lang.String r0 = r0.getRespCode()
                if (r0 != 0) goto L_0x0044
                kotlin.g.b.k.a()
            L_0x0044:
                java.lang.String r3 = "BT_INV_435"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                if (r0 == 0) goto L_0x0071
                net.one97.paytm.wallet.utility.a.a r13 = net.one97.paytm.wallet.utility.a.a.f72261c
                android.app.Activity r13 = r12.f72286b
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r0 = r12.f72287c
                java.lang.String r1 = r12.f72288d
                net.one97.paytm.wallet.utility.a.a.a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r1)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72285a
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x0069:
                kotlin.u r13 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse"
                r13.<init>(r0)
                throw r13
            L_0x0071:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x0080
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x0080
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x0081
            L_0x0080:
                r0 = r2
            L_0x0081:
                if (r0 != 0) goto L_0x0086
                kotlin.g.b.k.a()
            L_0x0086:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                java.lang.String r3 = "MT_HOME_CONTACTS"
                if (r0 == 0) goto L_0x00d5
                java.lang.String r0 = r12.f72289e
                if (r0 == 0) goto L_0x009f
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x00a0
            L_0x009f:
                r0 = r2
            L_0x00a0:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x00d5
                android.os.Bundle r0 = new android.os.Bundle
                r0.<init>()
                r1 = 0
                java.lang.String r3 = "key_is_from_fragment"
                r0.putBoolean(r3, r1)
                net.one97.paytm.utils.ae r1 = net.one97.paytm.utils.ae.f69602a
                android.app.Activity r1 = r12.f72286b
                if (r13 == 0) goto L_0x00b9
                net.one97.paytm.network.g r2 = r13.f55798c
            L_0x00b9:
                int r13 = r2.f55799a
                com.paytm.network.model.NetworkCustomError r2 = new com.paytm.network.model.NetworkCustomError
                r2.<init>()
                java.lang.String r3 = "generic_api_call_fail"
                net.one97.paytm.utils.ae.a(r1, r13, r2, r0, r3)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72285a
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x00d5:
                net.one97.paytm.utils.ae r0 = net.one97.paytm.utils.ae.f69602a
                if (r13 == 0) goto L_0x00e4
                net.one97.paytm.network.g r0 = r13.f55798c
                if (r0 == 0) goto L_0x00e4
                int r0 = r0.f55799a
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x00e5
            L_0x00e4:
                r0 = r2
            L_0x00e5:
                if (r0 != 0) goto L_0x00ea
                kotlin.g.b.k.a()
            L_0x00ea:
                int r0 = r0.intValue()
                boolean r0 = net.one97.paytm.utils.ae.a((int) r0)
                if (r0 != 0) goto L_0x013a
                java.lang.String r0 = r12.f72289e
                if (r0 == 0) goto L_0x0100
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            L_0x0100:
                boolean r0 = r2.booleanValue()
                if (r0 == 0) goto L_0x013a
                net.one97.paytm.wallet.utility.d r13 = net.one97.paytm.wallet.utility.d.f72319a
                android.app.Activity r0 = r12.f72286b
                r1 = 0
                r2 = 0
                r13 = r0
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r3 = com.paytm.utility.b.j((android.content.Context) r13)
                android.app.Activity r13 = r12.f72286b
                android.content.Context r13 = (android.content.Context) r13
                java.lang.String r4 = com.paytm.utility.b.l((android.content.Context) r13)
                java.lang.String r5 = r12.f72287c
                java.lang.String r6 = r12.f72288d
                r7 = 0
                r8 = 0
                boolean r9 = r12.f72290f
                boolean r11 = r12.f72291g
                boolean r10 = r12.f72292h
                net.one97.paytm.wallet.utility.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                net.one97.paytm.network.f$a r13 = net.one97.paytm.network.f.f55795d
                net.one97.paytm.network.f r13 = net.one97.paytm.network.f.a.b()
                kotlin.g.b.x$e r0 = r12.f72285a
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
                return
            L_0x013a:
                kotlin.g.b.x$e r0 = r12.f72285a
                T r0 = r0.element
                androidx.lifecycle.y r0 = (androidx.lifecycle.y) r0
                r0.postValue(r13)
            L_0x0143:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.a.a.d.onChanged(java.lang.Object):void");
        }
    }

    private a() {
    }

    public static String a() {
        return f72259a;
    }

    public static String b() {
        return f72262d;
    }

    public static net.one97.paytm.network.a c() {
        return f72260b;
    }

    public static void d() {
        f72260b = null;
    }

    public final y<f> a(Activity activity, String str, String str2, String str3, boolean z) {
        LiveData<f> a2;
        Activity activity2 = activity;
        String str4 = str;
        String str5 = str2;
        k.c(activity2, "activity");
        k.c(str4, "payeePhoneNo");
        k.c(str5, "mode");
        f72259a = str5;
        x.e eVar = new x.e();
        eVar.element = new y();
        Context context = activity2;
        if (com.paytm.utility.b.r(context)) {
            Map hashMap = new HashMap();
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "this.javaClass.simpleName");
            hashMap.put("screen_name", simpleName);
            net.one97.paytm.wallet.newdesign.universalp2p.a aVar = new net.one97.paytm.wallet.newdesign.universalp2p.a(context);
            String b2 = aVar.b(a.C1448a.CONSOLIDATE_PAYMENT_INST, new Object[0]);
            k.a((Object) b2, "universalP2PRequestCompo…CONSOLIDATE_PAYMENT_INST)");
            String a3 = p.a(b2, "v2", "v3", false);
            Map<String, String> a4 = aVar.a(a.C1448a.CONSOLIDATE_PAYMENT_INST, str4);
            k.a((Object) a4, "universalP2PRequestCompo…YMENT_INST, payeePhoneNo)");
            net.one97.paytm.network.a aVar2 = new net.one97.paytm.network.a(a3, new PaymentCombinationAPIResponse((SenderInfo) null, (MerchantInfo) null, (ReceiverInfo) null, (List) null, (GlobalError) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (ExtraData) null, (Boolean) null, 4095, (g) null), hashMap, a4);
            f72260b = aVar2;
            aVar2.e();
            net.one97.paytm.network.a aVar3 = f72260b;
            if (aVar3 != null) {
                aVar3.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "payment_combination_api_timeout")));
            }
            net.one97.paytm.network.a aVar4 = f72260b;
            if (!(aVar4 == null || (a2 = aVar4.a()) == null)) {
                a2.observe((q) activity2, new d(eVar, activity, str3, str, str2, z));
            }
        } else {
            a(activity);
            f.a aVar5 = f.f55795d;
            ((y) eVar.element).postValue(f.a.b());
        }
        return (y) eVar.element;
    }

    public final y<f> a(Activity activity, String str, String str2, String str3) {
        LiveData<f> a2;
        Activity activity2 = activity;
        String str4 = str;
        String str5 = str2;
        k.c(activity2, "activity");
        k.c(str4, "payeePhoneNo");
        k.c(str5, "mode");
        f72259a = str5;
        x.e eVar = new x.e();
        eVar.element = new y();
        Context context = activity2;
        if (com.paytm.utility.b.r(context)) {
            Map hashMap = new HashMap();
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "this.javaClass.simpleName");
            hashMap.put("screen_name", simpleName);
            net.one97.paytm.wallet.newdesign.universalp2p.a aVar = new net.one97.paytm.wallet.newdesign.universalp2p.a(context);
            String b2 = aVar.b(a.C1448a.CONSOLIDATE_PAYMENT_INST, new Object[0]);
            k.a((Object) b2, "universalP2PRequestCompo…CONSOLIDATE_PAYMENT_INST)");
            String a3 = p.a(b2, "v2", "v3", false);
            Map<String, String> a4 = aVar.a(a.C1448a.CONSOLIDATE_PAYMENT_INST, str4);
            k.a((Object) a4, "universalP2PRequestCompo…YMENT_INST, payeePhoneNo)");
            net.one97.paytm.network.a aVar2 = new net.one97.paytm.network.a(a3, new PaymentCombinationAPIResponse((SenderInfo) null, (MerchantInfo) null, (ReceiverInfo) null, (List) null, (GlobalError) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (ExtraData) null, (Boolean) null, 4095, (g) null), hashMap, a4);
            f72260b = aVar2;
            aVar2.e();
            net.one97.paytm.network.a aVar3 = f72260b;
            if (aVar3 != null) {
                aVar3.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "payment_combination_api_timeout")));
            }
            net.one97.paytm.network.a aVar4 = f72260b;
            if (!(aVar4 == null || (a2 = aVar4.a()) == null)) {
                a2.observe((q) activity2, new b(str3, activity, str, eVar, str2));
            }
        } else {
            a(activity);
            f.a aVar5 = f.f55795d;
            ((y) eVar.element).postValue(f.a.b());
        }
        return (y) eVar.element;
    }

    public final y<f> a(Activity activity, String str, String str2, String str3, String str4, boolean z, boolean z2) {
        LiveData<f> a2;
        Activity activity2 = activity;
        String str5 = str;
        String str6 = str2;
        k.c(activity2, "activity");
        k.c(str5, "payeePhoneNo");
        k.c(str6, "mode");
        f72259a = str6;
        if (str3 != null) {
            f72262d = str3;
        }
        x.e eVar = new x.e();
        eVar.element = new y();
        Context context = activity2;
        if (com.paytm.utility.b.r(context)) {
            Map hashMap = new HashMap();
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "this.javaClass.simpleName");
            hashMap.put("screen_name", simpleName);
            net.one97.paytm.wallet.newdesign.universalp2p.a aVar = new net.one97.paytm.wallet.newdesign.universalp2p.a(context);
            String b2 = aVar.b(a.C1448a.CONSOLIDATE_PAYMENT_INST, new Object[0]);
            k.a((Object) b2, "universalP2PRequestCompo…CONSOLIDATE_PAYMENT_INST)");
            String a3 = p.a(b2, "v2", "v3", false);
            Map<String, String> a4 = aVar.a(a.C1448a.CONSOLIDATE_PAYMENT_INST, str5);
            k.a((Object) a4, "universalP2PRequestCompo…YMENT_INST, payeePhoneNo)");
            net.one97.paytm.network.a aVar2 = new net.one97.paytm.network.a(a3, new PaymentCombinationAPIResponse((SenderInfo) null, (MerchantInfo) null, (ReceiverInfo) null, (List) null, (GlobalError) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (ExtraData) null, (Boolean) null, 4095, (g) null), hashMap, a4);
            f72260b = aVar2;
            aVar2.e();
            net.one97.paytm.network.a aVar3 = f72260b;
            if (aVar3 != null) {
                aVar3.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "payment_combination_api_timeout")));
            }
            net.one97.paytm.network.a aVar4 = f72260b;
            if (!(aVar4 == null || (a2 = aVar4.a()) == null)) {
                a2.observe((q) activity2, new c(str4, eVar, activity, str, str2, z, z2));
            }
        } else {
            a(activity);
            f.a aVar5 = f.f55795d;
            ((y) eVar.element).postValue(f.a.b());
        }
        return (y) eVar.element;
    }

    public static void a(Activity activity) {
        net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        activity.startActivityForResult(new Intent(activity, a2.getAuthActivityClass()), 4);
    }

    public static final /* synthetic */ void a(Activity activity, PaymentCombinationAPIResponse paymentCombinationAPIResponse, String str) {
        if ((paymentCombinationAPIResponse != null ? paymentCombinationAPIResponse.getMerchantInfo() : null) != null) {
            Intent intent = new Intent(activity, AJRQRActivity.class);
            intent.putExtra("OPERATION", "contact");
            intent.putExtra("mobile", str);
            intent.putExtra("is_from_mobile_number", true);
            intent.putExtra("paysend_result", paymentCombinationAPIResponse);
            activity.startActivityForResult(intent, 1800);
        }
    }

    public static final /* synthetic */ void a(Context context, String str, String str2) {
        net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
        net.one97.paytm.wallet.utility.d.a(context, str, str2);
    }
}
