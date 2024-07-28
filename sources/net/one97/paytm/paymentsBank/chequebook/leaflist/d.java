package net.one97.paytm.paymentsBank.chequebook.leaflist;

import android.app.Application;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.b;
import net.one97.paytm.paymentsBank.chequebook.model.CBChequeStatusDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward;
import net.one97.paytm.paymentsBank.chequebook.model.SectionDivider;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.model.chequebook.CbStopPaymentResponse;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;

public final class d extends net.one97.paytm.paymentsBank.chequebook.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<String> f17610a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> f17611b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> f17612c;

    /* renamed from: d  reason: collision with root package name */
    public final y<Integer> f17613d;

    /* renamed from: e  reason: collision with root package name */
    public String f17614e;

    /* renamed from: f  reason: collision with root package name */
    public final LiveData<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> f17615f;

    /* renamed from: g  reason: collision with root package name */
    private final y<String> f17616g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    private final List<IJRDataModel> f17617h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f17618i;
    /* access modifiers changed from: private */
    public final Application j;
    /* access modifiers changed from: private */
    public final g k;

    static final class a<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f17619a;

        a(d dVar) {
            this.f17619a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Integer num = (Integer) obj;
            g a2 = this.f17619a.k;
            String b2 = d.b(this.f17619a);
            String string = this.f17619a.j.getString(R.string.cb_block_reason);
            k.a((Object) string, "app.getString(R.string.cb_block_reason)");
            k.a((Object) num, "it");
            int intValue = num.intValue();
            e eVar = e.f17951a;
            return ah.a(a2.a(b2, string, intValue, e.i()), new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f17620a;

                {
                    this.f17620a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
                    k.a((Object) bVar, "it");
                    return d.a(bVar);
                }
            });
        }
    }

    static final class b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f17621a;

        b(d dVar) {
            this.f17621a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            g a2 = this.f17621a.k;
            k.a((Object) str, "it");
            e eVar = e.f17951a;
            return ah.a(a2.a(1, str, "Cleared", e.i()), new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f17622a;

                {
                    this.f17622a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
                    d dVar = this.f17622a.f17621a;
                    k.a((Object) bVar, "it");
                    return d.b(dVar, bVar);
                }
            });
        }
    }

    static final class c<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f17623a;

        c(d dVar) {
            this.f17623a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            g a2 = this.f17623a.k;
            k.a((Object) str, "it");
            e eVar = e.f17951a;
            String i2 = e.i();
            k.c(str, "cbNumber");
            k.c(i2, SDKConstants.EVENT_KEY_SCREEN_NAME);
            y yVar = new y();
            b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            yVar.setValue(b.a.a());
            String str2 = o.a().getStringFromGTM("cb_base_url") + str;
            if (!URLUtil.isValidUrl(str2)) {
                b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                yVar.setValue(b.a.a(g.a()));
            } else {
                Map hashMap = new HashMap();
                e eVar2 = e.f17951a;
                String a3 = e.a();
                String a4 = net.one97.paytm.bankCommon.mapping.d.a(a2.f17966a);
                k.a((Object) a4, "CJRServerUtility.getSSOToken(mContext)");
                hashMap.put(a3, a4);
                hashMap.put("Accept", "application/json");
                hashMap.put("Client-Id", UpiConstants.B2C_ANDROID);
                e eVar3 = e.f17951a;
                hashMap.put(e.h(), str);
                com.paytm.network.a l = new com.paytm.network.b().a(a2.f17966a).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).c(i2).a(a.C0715a.GET).a(str2).a((Map<String, String>) hashMap).a(false).a((IJRPaytmDataModel) new CBLeafDetailResponse((List) null, 1, (kotlin.g.b.g) null)).a((com.paytm.network.listener.b) new g.d(yVar)).l();
                if (com.paytm.utility.b.c(a2.f17966a)) {
                    l.a();
                }
            }
            return ah.a(yVar, new androidx.arch.core.c.a<X, Y>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f17624a;

                {
                    this.f17624a = r1;
                }

                public final /* synthetic */ Object apply(Object obj) {
                    return d.a(this.f17624a.f17623a, (net.one97.paytm.paymentsBank.chequebook.b) obj);
                }
            });
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application, g gVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(gVar, "cbRepository");
        this.j = application;
        this.k = gVar;
        LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> b2 = ah.b(this.f17616g, new c(this));
        k.a((Object) b2, "Transformations.switchMa…Model(it)\n        }\n    }");
        this.f17611b = b2;
        LiveData<net.one97.paytm.paymentsBank.chequebook.b<List<IJRDataModel>>> b3 = ah.b(this.f17610a, new b(this));
        k.a((Object) b3, "Transformations.switchMa…Model(it)\n        }\n    }");
        this.f17612c = b3;
        this.f17613d = new y<>();
        LiveData<net.one97.paytm.paymentsBank.chequebook.b<CbStopPaymentResponse>> b4 = ah.b(this.f17613d, new a(this));
        k.a((Object) b4, "Transformations.switchMa…Pay(it)\n        }\n\n\n    }");
        this.f17615f = b4;
    }

    public static final /* synthetic */ String b(d dVar) {
        String str = dVar.f17614e;
        if (str == null) {
            k.a("bankScopeToken");
        }
        return str;
    }

    public final void a(String str, boolean z) {
        k.c(str, "cbNumber");
        this.f17618i = z;
        this.f17616g.setValue(str);
    }

    private static SectionDivider a(String str) {
        return new SectionDivider(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        r1 = r1.getChqList();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.b a(net.one97.paytm.paymentsBank.chequebook.leaflist.d r9, net.one97.paytm.paymentsBank.chequebook.b r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x000a
            net.one97.paytm.paymentsBank.chequebook.b$a r9 = net.one97.paytm.paymentsBank.chequebook.b.f17485e
            net.one97.paytm.paymentsBank.chequebook.b r9 = net.one97.paytm.paymentsBank.chequebook.b.a.a(r0)
            return r9
        L_0x000a:
            net.one97.paytm.paymentsBank.chequebook.c r1 = r10.f17486a
            int[] r2 = net.one97.paytm.paymentsBank.chequebook.leaflist.e.f17625a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 0
            r3 = 1
            if (r1 == r3) goto L_0x0030
            r0 = 2
            if (r1 == r0) goto L_0x0029
            r0 = 3
            if (r1 == r0) goto L_0x0020
            goto L_0x01fe
        L_0x0020:
            net.one97.paytm.paymentsBank.chequebook.b$a r9 = net.one97.paytm.paymentsBank.chequebook.b.f17485e
            com.paytm.network.model.NetworkCustomError r9 = r10.f17488c
            net.one97.paytm.paymentsBank.chequebook.b r9 = net.one97.paytm.paymentsBank.chequebook.b.a.a(r9)
            return r9
        L_0x0029:
            net.one97.paytm.paymentsBank.chequebook.b$a r9 = net.one97.paytm.paymentsBank.chequebook.b.f17485e
            net.one97.paytm.paymentsBank.chequebook.b r9 = net.one97.paytm.paymentsBank.chequebook.b.a.a()
            return r9
        L_0x0030:
            boolean r1 = r9.f17618i
            if (r1 == 0) goto L_0x003e
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r1 = r9.f17617h
            net.one97.paytm.paymentsBank.chequebook.model.CBStopPaymentView r4 = new net.one97.paytm.paymentsBank.chequebook.model.CBStopPaymentView
            r4.<init>(r0, r3, r0)
            r1.add(r4)
        L_0x003e:
            ResultType r1 = r10.f17487b
            net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse r1 = (net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse) r1
            if (r1 == 0) goto L_0x004f
            java.util.List r1 = r1.getChqList()
            if (r1 == 0) goto L_0x004f
            int r1 = r1.size()
            goto L_0x0050
        L_0x004f:
            r1 = 0
        L_0x0050:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            ResultType r5 = r10.f17487b
            net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse r5 = (net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse) r5
            if (r5 == 0) goto L_0x006e
            java.util.List r5 = r5.getChqList()
            if (r5 == 0) goto L_0x006e
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail r5 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail) r5
            if (r5 == 0) goto L_0x006e
            java.lang.String r5 = r5.getChqNumber()
            goto L_0x006f
        L_0x006e:
            r5 = r0
        L_0x006f:
            r4.append(r5)
            java.lang.String r5 = " - "
            r4.append(r5)
            ResultType r5 = r10.f17487b
            net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse r5 = (net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse) r5
            if (r5 == 0) goto L_0x0091
            java.util.List r5 = r5.getChqList()
            if (r5 == 0) goto L_0x0091
            int r1 = r1 - r3
            java.lang.Object r1 = r5.get(r1)
            net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail r1 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail) r1
            if (r1 == 0) goto L_0x0091
            java.lang.String r1 = r1.getChqNumber()
            goto L_0x0092
        L_0x0091:
            r1 = r0
        L_0x0092:
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            net.one97.paytm.paymentsBank.chequebook.model.CBHeading r4 = new net.one97.paytm.paymentsBank.chequebook.model.CBHeading
            androidx.lifecycle.y<java.lang.String> r5 = r9.f17616g
            java.lang.Object r5 = r5.getValue()
            if (r5 != 0) goto L_0x00a6
            kotlin.g.b.k.a()
        L_0x00a6:
            java.lang.String r6 = "_leafCBNumber.value!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r5 = (java.lang.String) r5
            r4.<init>(r5, r1)
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r1 = r9.f17617h
            r1.add(r4)
            ResultType r1 = r10.f17487b
            net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse r1 = (net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse) r1
            if (r1 == 0) goto L_0x00f3
            java.util.List r1 = r1.getChqList()
            if (r1 == 0) goto L_0x00f3
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x00ce:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00ef
            java.lang.Object r5 = r1.next()
            r6 = r5
            net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail r6 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail) r6
            java.lang.String r6 = r6.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r7 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r7 = net.one97.paytm.paymentsBank.chequebook.utils.e.j()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x00ce
            r4.add(r5)
            goto L_0x00ce
        L_0x00ef:
            r1 = r4
            java.util.List r1 = (java.util.List) r1
            goto L_0x00f4
        L_0x00f3:
            r1 = r0
        L_0x00f4:
            if (r1 == 0) goto L_0x0153
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r3
            if (r4 != r3) goto L_0x0153
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r4 = r9.f17617h
            android.app.Application r5 = r9.j
            android.content.Context r5 = r5.getApplicationContext()
            int r6 = net.one97.paytm.paymentsBank.R.string.cb_cleared_chq
            java.lang.Object[] r7 = new java.lang.Object[r3]
            int r8 = r1.size()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7[r2] = r8
            java.lang.String r5 = r5.getString(r6, r7)
            java.lang.String r6 = "app.applicationContext.g…dclearedChequesList.size)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.paymentsBank.chequebook.model.SectionDivider r5 = a((java.lang.String) r5)
            r4.add(r5)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            java.util.Iterator r5 = r1.iterator()
        L_0x0131:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0149
            java.lang.Object r6 = r5.next()
            net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail r6 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail) r6
            java.lang.String r6 = r6.getChqNumber()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.add(r6)
            goto L_0x0131
        L_0x0149:
            android.app.Application r5 = r9.j
            android.content.Context r5 = (android.content.Context) r5
            net.one97.paytm.paymentsBank.chequebook.utils.h r5 = net.one97.paytm.paymentsBank.chequebook.utils.h.a((android.content.Context) r5)
            r5.f17978a = r4
        L_0x0153:
            ResultType r10 = r10.f17487b
            net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse r10 = (net.one97.paytm.paymentsBank.chequebook.model.CBLeafDetailResponse) r10
            if (r10 == 0) goto L_0x0190
            java.util.List r10 = r10.getChqList()
            if (r10 == 0) goto L_0x0190
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x016c:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x018e
            java.lang.Object r4 = r10.next()
            r5 = r4
            net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail r5 = (net.one97.paytm.paymentsBank.chequebook.model.ChequeDetail) r5
            java.lang.String r5 = r5.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r6 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r6 = net.one97.paytm.paymentsBank.chequebook.utils.e.j()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r6)
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x016c
            r0.add(r4)
            goto L_0x016c
        L_0x018e:
            java.util.List r0 = (java.util.List) r0
        L_0x0190:
            if (r0 == 0) goto L_0x01fe
            r10 = r0
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r4 = r10.isEmpty()
            r4 = r4 ^ r3
            if (r4 != r3) goto L_0x01fe
            if (r1 == 0) goto L_0x01d3
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r3
            if (r1 != r3) goto L_0x01d3
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r1 = r9.f17617h
            android.app.Application r4 = r9.j
            android.content.Context r4 = r4.getApplicationContext()
            int r5 = net.one97.paytm.paymentsBank.R.string.cb_other_chq
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r2] = r0
            java.lang.String r0 = r4.getString(r5, r3)
            java.lang.String r3 = "app.applicationContext.g…hq,otherChequesList.size)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.paymentsBank.chequebook.model.SectionDivider r0 = a((java.lang.String) r0)
            r1.add(r0)
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r0 = r9.f17617h
            r0.addAll(r10)
            goto L_0x01fe
        L_0x01d3:
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r1 = r9.f17617h
            android.app.Application r4 = r9.j
            android.content.Context r4 = r4.getApplicationContext()
            int r5 = net.one97.paytm.paymentsBank.R.string.cb_chq_num
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r2] = r0
            java.lang.String r0 = r4.getString(r5, r3)
            java.lang.String r3 = "app.applicationContext.g…um,otherChequesList.size)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.paymentsBank.chequebook.model.SectionDivider r0 = a((java.lang.String) r0)
            r1.add(r0)
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r0 = r9.f17617h
            r0.addAll(r10)
        L_0x01fe:
            net.one97.paytm.paymentsBank.chequebook.b$a r10 = net.one97.paytm.paymentsBank.chequebook.b.f17485e
            java.util.List<net.one97.paytm.common.entity.IJRDataModel> r9 = r9.f17617h
            net.one97.paytm.paymentsBank.chequebook.b r9 = net.one97.paytm.paymentsBank.chequebook.b.a.a(r9, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.leaflist.d.a(net.one97.paytm.paymentsBank.chequebook.leaflist.d, net.one97.paytm.paymentsBank.chequebook.b):net.one97.paytm.paymentsBank.chequebook.b");
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.b b(d dVar, net.one97.paytm.paymentsBank.chequebook.b bVar) {
        List<ChequeDetailsForInwardOutward> chqListForInwrdOutwrd;
        int i2 = e.f17626b[bVar.f17486a.ordinal()];
        if (i2 == 1) {
            CBChequeStatusDetailResponse cBChequeStatusDetailResponse = (CBChequeStatusDetailResponse) bVar.f17487b;
            if (!(cBChequeStatusDetailResponse == null || (chqListForInwrdOutwrd = cBChequeStatusDetailResponse.getChqListForInwrdOutwrd()) == null || !(!chqListForInwrdOutwrd.isEmpty()))) {
                CBChequeStatusDetailResponse cBChequeStatusDetailResponse2 = (CBChequeStatusDetailResponse) bVar.f17487b;
                List<ChequeDetailsForInwardOutward> chqListForInwrdOutwrd2 = cBChequeStatusDetailResponse2 != null ? cBChequeStatusDetailResponse2.getChqListForInwrdOutwrd() : null;
                if (chqListForInwrdOutwrd2 == null) {
                    throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.IJRDataModel>");
                } else if (dVar.f17618i) {
                    dVar.f17617h.addAll(3, chqListForInwrdOutwrd2);
                } else {
                    dVar.f17617h.addAll(2, chqListForInwrdOutwrd2);
                }
            }
        } else if (i2 == 2) {
            b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a(bVar.f17488c);
        } else if (i2 == 3) {
            b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a();
        }
        b.a aVar3 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
        return b.a.a(dVar.f17617h, false);
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.b a(net.one97.paytm.paymentsBank.chequebook.b bVar) {
        int i2 = e.f17627c[bVar.f17486a.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                b.a aVar = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                return b.a.a();
            } else if (i2 == 3) {
                b.a aVar2 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
                return b.a.a(bVar.f17488c);
            } else {
                throw new m();
            }
        } else if (bVar.f17487b != null) {
            b.a aVar3 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            ResultType resulttype = bVar.f17487b;
            if (resulttype == null) {
                k.a();
            }
            return b.a.a(resulttype, false);
        } else {
            b.a aVar4 = net.one97.paytm.paymentsBank.chequebook.b.f17485e;
            return b.a.a(bVar.f17488c);
        }
    }
}
