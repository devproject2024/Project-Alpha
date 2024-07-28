package net.one97.paytm.recharge.common.h;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.k.e;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.recharge.common.e.r;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.be;
import net.one97.paytm.recharge.common.utils.q;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.common.utils.x;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.model.rechargeutility.CJRFrequentOrderDeletResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public abstract class b extends ai implements net.one97.paytm.recharge.common.b.a.a, net.one97.paytm.recharge.common.e.ai, r {
    private AsyncTask<String, String, List<CJRFrequentOrder>> A;
    private String B;

    /* renamed from: a  reason: collision with root package name */
    public final be<CJRInstruct> f61408a = new be<>();

    /* renamed from: b  reason: collision with root package name */
    public final CJRCategoryDataHelper f61409b = g();

    /* renamed from: c  reason: collision with root package name */
    final x f61410c = h();

    /* renamed from: d  reason: collision with root package name */
    public boolean f61411d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61412e;

    /* renamed from: f  reason: collision with root package name */
    public y<String> f61413f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<List<CJRFrequentOrder>> f61414g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final y<Data<CJRSetUserConsentApiResponse>> f61415h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public final y<Data<CJRGetUserConsentApiResponse>> f61416i = new y<>();
    public CJRFrequentOrder j;
    protected y<CJROffers> k = new y<>();
    public io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> l;
    public final HashMap<String, String> m;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public final CJRItem r;
    public net.one97.paytm.recharge.common.b.c s;
    public w t;
    protected e<kotlin.x> u;
    public net.one97.paytm.recharge.ordersummary.h.d v;
    private y<List<CJRFrequentOrder>> w = new y<>();
    private final y<Data<UnsubscribeApiResponse>> x = new y<>();
    private HashMap<String, CJROffers> y = new HashMap<>();
    private String z = "";

    public void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
    }

    public abstract CJRCategoryDataHelper g();

    public abstract x h();

    static final /* synthetic */ class a extends i implements kotlin.g.a.b<CJRInstruct, kotlin.x> {
        a(b bVar) {
            super(1, bVar);
        }

        public final String getName() {
            return "performUIOperation";
        }

        public final kotlin.k.d getOwner() {
            return kotlin.g.b.y.b(b.class);
        }

        public final String getSignature() {
            return "performUIOperation(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            k.c(cJRInstruct, "p1");
            ((b) this.receiver).a(cJRInstruct);
        }
    }

    public final void a(e<kotlin.x> eVar) {
        k.c(eVar, "<set-?>");
        this.u = eVar;
    }

    public b(CJRItem cJRItem, net.one97.paytm.recharge.common.b.c cVar, w wVar, e<kotlin.x> eVar, net.one97.paytm.recharge.ordersummary.h.d dVar) {
        k.c(cJRItem, "rechargeItem");
        k.c(cVar, "rechargeRepo");
        k.c(eVar, "errorHandler");
        k.c(dVar, "gtmEventHelper");
        this.r = cJRItem;
        this.s = cVar;
        this.t = wVar;
        this.u = eVar;
        this.v = dVar;
        io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> a2 = io.reactivex.rxjava3.j.c.a();
        k.a((Object) a2, "ReplaySubject.create()");
        this.l = a2;
        this.m = new HashMap<>();
        this.B = "";
        this.q = "";
        w wVar2 = this.t;
        if (wVar2 != null) {
            wVar2.f61787g = new a(this);
            wVar2.f61789i = this.s;
            wVar2.f61788h = this.u;
            wVar2.j = this.f61410c;
        }
        a();
        i();
    }

    public final void a(String str, String str2, Object obj) {
        k.c(str, "tag");
        a(str, str2, false, obj);
    }

    public static final class d extends AsyncTask<String, String, List<? extends CJRFrequentOrder>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f61420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61421b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61422c = null;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f61423d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f61424e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f61425f;

        /* JADX WARNING: type inference failed for: r3v0, types: [boolean, java.lang.String] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        d(net.one97.paytm.recharge.common.h.b r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.Object r5) {
            /*
                r0 = this;
                r0.f61420a = r1
                r0.f61421b = r2
                r1 = 0
                r0.f61422c = r1
                r0.f61423d = r3
                r0.f61424e = r4
                r0.f61425f = r5
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.h.b.d.<init>(net.one97.paytm.recharge.common.h.b, java.lang.String, boolean, java.lang.String, java.lang.Object):void");
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            k.c((String[]) objArr, "params");
            if (isCancelled()) {
                return null;
            }
            q qVar = q.f61722a;
            return q.a(this.f61421b, this.f61422c);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            List list = (List) obj;
            super.onPostExecute(list);
            if (!(list != null ? list.isEmpty() : true)) {
                this.f61420a.f61414g.setValue(list);
            } else if (this.f61423d) {
                this.f61420a.f61414g.setValue(list);
            } else if (this.f61420a.s.a()) {
                this.f61420a.s.c(this.f61424e, this.f61420a, this.f61425f);
            } else {
                this.f61420a.f61414g.setValue(new ArrayList());
            }
        }
    }

    private final void a(String str, String str2, boolean z2, Object obj) {
        try {
            this.A = new d(this, str2, z2, str, obj);
            AsyncTask<String, String, List<CJRFrequentOrder>> asyncTask = this.A;
            if (asyncTask != null) {
                asyncTask.execute(new String[]{str2, null});
            }
        } catch (Exception unused) {
        }
    }

    public final void b(String str, String str2, Object obj) {
        k.c(str, "tag");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        this.f61413f.setValue(str2);
        a(str, str2, obj);
    }

    private void a() {
        String str;
        StringBuilder sb;
        String name = this.r.getName();
        if (name != null && (!p.a(name))) {
            String name2 = this.r.getName();
            if (name2 == null) {
                name2 = "";
            }
            this.q = name2;
            String name3 = this.r.getName();
            if (name3 == null || !p.a((CharSequence) name3, (CharSequence) "Landline", false)) {
                sb = new StringBuilder("utilities_");
                String name4 = this.r.getName();
                if (name4 == null) {
                    str = null;
                } else if (name4 != null) {
                    str = name4.toLowerCase();
                    k.a((Object) str, "(this as java.lang.String).toLowerCase()");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                sb = new StringBuilder("utilities_");
                str = "Landline".toLowerCase();
                k.a((Object) str, "(this as java.lang.String).toLowerCase()");
            }
            sb.append(str);
            this.B = sb.toString();
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        Uri parse = Uri.parse(this.r.getURL());
        k.a((Object) parse, "uri");
        for (String next : parse.getQueryParameterNames()) {
            String queryParameter = parse.getQueryParameter(next);
            Map map = this.m;
            k.a((Object) next, "key");
            CharSequence charSequence = next;
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = charSequence.charAt(!z2 ? i2 : length) <= ' ';
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (!z3) {
                    z2 = true;
                } else {
                    i2++;
                }
            }
            String obj = charSequence.subSequence(i2, length + 1).toString();
            if (queryParameter == null) {
                queryParameter = "";
            }
            map.put(obj, queryParameter);
        }
        if (this.m.containsKey("app_link_level_1")) {
            this.n = this.m.get("app_link_level_1");
            this.p = true;
        }
        if (this.m.containsKey("app_link_level_2")) {
            this.o = this.m.get("app_link_level_2");
            this.p = true;
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        a(net.one97.paytm.recharge.widgets.c.d.b());
    }

    public void a(CJRRechargeErrorModel cJRRechargeErrorModel) {
        CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
        k.c(cJRRechargeErrorModel2, "errorModel");
        CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
        if (flowName == null) {
            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
        }
        cJRRechargeErrorModel2.setFlowName(flowName);
        if (this.p) {
            CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.APP_LINK.name());
            }
        } else if (!this.m.isEmpty()) {
            CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
            if (flowName3 != null) {
                flowName3.setActionType(ACTION_TYPE.DEEPLINK.name());
            }
        } else {
            CRUFlowModel flowName4 = cJRRechargeErrorModel.getFlowName();
            if (flowName4 != null) {
                flowName4.setActionType(ACTION_TYPE.HOME_PAGE.name());
            }
        }
    }

    public final void a(String str, CJRFrequentOrder cJRFrequentOrder, Object obj) {
        List<CJRFrequentOrder> orderList;
        k.c(str, "tag");
        k.c(cJRFrequentOrder, "recentOrder");
        this.j = cJRFrequentOrder;
        CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
        if (!(frequentOrderList == null || (orderList = frequentOrderList.getOrderList()) == null || !orderList.contains(this.j))) {
            frequentOrderList.getOrderList().remove(this.j);
        }
        a(str, obj);
        this.s.a(str, (net.one97.paytm.recharge.common.e.ai) this, cJRFrequentOrder, obj);
    }

    public static final class c implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f61419a;

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        }

        public c(b bVar) {
            this.f61419a = bVar;
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            Integer code;
            List<CJRFrequentOrder> orderList;
            List<CJRFrequentOrder> orderList2;
            List<CJRFrequentOrder> orderList3;
            if ((iJRPaytmDataModel instanceof CJRFrequentOrderDeletResponse) && (code = ((CJRFrequentOrderDeletResponse) iJRPaytmDataModel).getCode()) != null && code.intValue() == 200) {
                CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
                int i2 = -1;
                if (frequentOrderList != null && (orderList3 = frequentOrderList.getOrderList()) != null) {
                    Iterator<CJRFrequentOrder> it2 = orderList3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        CJRFrequentOrder next = it2.next();
                        k.a((Object) next, StringSet.order);
                        String favOrderId = next.getFavOrderId();
                        CJRFrequentOrder cJRFrequentOrder = this.f61419a.j;
                        if (favOrderId.equals(cJRFrequentOrder != null ? cJRFrequentOrder.getFavOrderId() : null)) {
                            i2 = orderList3.indexOf(next);
                            break;
                        }
                    }
                }
                if (i2 >= 0) {
                    if (!(frequentOrderList == null || (orderList2 = frequentOrderList.getOrderList()) == null)) {
                        orderList2.remove(i2);
                    }
                    if (frequentOrderList != null && (orderList = frequentOrderList.getOrderList()) != null && orderList.isEmpty()) {
                        this.f61419a.f61414g.setValue(frequentOrderList.getOrderList());
                    }
                }
            }
        }
    }

    public final void a(String str, Object obj) {
        k.c(str, "tag");
        String value = this.f61413f.getValue();
        if (value != null) {
            a(str, value, obj);
        }
    }

    public final LiveData<CJROffers> c(String str, String str2, Object obj) {
        k.c(str, "tag");
        k.c(str2, "categoryId");
        if (net.one97.paytm.recharge.common.utils.g.c(str2)) {
            this.z = str2;
            if (this.y.containsKey(str2)) {
                this.k.setValue(this.y.get(str2));
            } else {
                this.s.b(str, this, str2, obj);
            }
        } else {
            String categoryId = this.r.getCategoryId();
            k.a((Object) categoryId, "rechargeItem.categoryId");
            this.s.b(str, this, categoryId, obj);
        }
        return this.k;
    }

    public final io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> f() {
        return this.l;
    }

    /* renamed from: net.one97.paytm.recharge.common.h.b$b  reason: collision with other inner class name */
    public static final class C1189b implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f61417a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.common.e.ai f61418b;

        C1189b(b bVar, net.one97.paytm.recharge.common.e.ai aiVar) {
            this.f61417a = bVar;
            this.f61418b = aiVar;
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRAutomaticSubscriptionListModel) {
                CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = (CJRAutomaticSubscriptionListModel) iJRPaytmDataModel;
                ArrayList<CJRAutomaticSubscriptionItemModel> subscriptionModelArrayList = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList();
                if (subscriptionModelArrayList == null || !(!subscriptionModelArrayList.isEmpty())) {
                    this.f61417a.l.onNext(new ArrayList());
                } else {
                    this.f61417a.l.onNext(cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList());
                }
            }
            net.one97.paytm.recharge.common.e.ai aiVar = this.f61418b;
            if (aiVar != null) {
                aiVar.a_(str, iJRPaytmDataModel, obj);
            }
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            net.one97.paytm.recharge.common.e.ai aiVar = this.f61418b;
            if (aiVar != null) {
                aiVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
        }
    }

    public final void c(String str, net.one97.paytm.recharge.common.e.ai aiVar, Object obj) {
        k.c(str, "tag");
        this.s.e(str, new C1189b(this, aiVar), obj);
    }

    public final void a(List<CJRAutomaticSubscriptionItemModel> list, net.one97.paytm.recharge.common.e.q qVar, String str, CJRFrequentOrder cJRFrequentOrder) {
        k.c(list, "paymentAutomaticSubscriptionList");
        k.c(qVar, "subscriptionStatusListener");
        k.c(str, "rechargeNumber");
        k.c(cJRFrequentOrder, "recent");
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = null;
        boolean z2 = true;
        for (CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel2 : list) {
            if (p.a(cJRAutomaticSubscriptionItemModel2.getRechargeNumber(), str, true)) {
                if (!p.a(cJRFrequentOrder.getProductID(), String.valueOf(cJRAutomaticSubscriptionItemModel2.getProductId()), true)) {
                    az azVar = az.f61525a;
                    if (!az.a(cJRAutomaticSubscriptionItemModel2, cJRFrequentOrder)) {
                    }
                }
                z2 = false;
                cJRAutomaticSubscriptionItemModel = cJRAutomaticSubscriptionItemModel2;
            }
        }
        if (z2) {
            qVar.b();
            return;
        }
        if (cJRAutomaticSubscriptionItemModel == null) {
            k.a();
        }
        qVar.a(cJRAutomaticSubscriptionItemModel);
    }

    public final void a(Fragment fragment, CJRFrequentOrder cJRFrequentOrder, Bundle bundle) {
        k.c(cJRFrequentOrder, "recent");
        this.f61408a.setValue(new CJRInstruct.openSetupAutomaticSelectDurationActivity(fragment, (FragmentActivity) null, cJRFrequentOrder, bundle));
    }

    public final void a(Fragment fragment, CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, Bundle bundle) {
        k.c(cJRFrequentOrder, "recent");
        k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
        this.f61408a.setValue(new CJRInstruct.openManageAutomaticActivity(fragment, (FragmentActivity) null, cJRFrequentOrder, cJRAutomaticSubscriptionItemModel, bundle));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c2, code lost:
        r0 = r0.getProducts();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.recharge.model.v4.CJRInstruct r11) {
        /*
            r10 = this;
            java.lang.String r0 = "cjrInstruct"
            kotlin.g.b.k.c(r11, r0)
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showAlertDialog
            if (r0 == 0) goto L_0x002f
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$showAlertDialog r8 = new net.one97.paytm.recharge.model.v4.CJRInstruct$showAlertDialog
            net.one97.paytm.recharge.model.v4.CJRInstruct$showAlertDialog r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showAlertDialog) r11
            java.lang.String r2 = r11.getTitle()
            java.lang.String r3 = r11.getMessage()
            java.lang.String r4 = r11.getActionButtonLabel()
            net.one97.paytm.recharge.model.v4.ErrorAction r5 = r11.getAction()
            java.lang.Boolean r6 = r11.getErrorInfoDialog()
            java.lang.Object r7 = r11.getHawkEyeEvent()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.setValue(r8)
            return
        L_0x002f:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showNotMandatoryFields
            if (r0 == 0) goto L_0x0044
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields r1 = new net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields
            net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showNotMandatoryFields) r11
            net.one97.paytm.common.entity.CJRRechargeCart r11 = r11.getCjrRechargeCart()
            r1.<init>(r11)
            r0.setValue(r1)
            return
        L_0x0044:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openAutomaticAddNewBill
            if (r0 == 0) goto L_0x0059
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill r1 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill
            net.one97.paytm.recharge.model.v4.CJRInstruct$openAutomaticAddNewBill r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openAutomaticAddNewBill) r11
            net.one97.paytm.common.entity.CJRRechargeCart r11 = r11.getCjrRechargeCart()
            r1.<init>(r11)
            r0.setValue(r1)
            return
        L_0x0059:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openPostOrderSummaryActivity
            if (r0 == 0) goto L_0x0076
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$openPostOrderSummaryActivity r1 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openPostOrderSummaryActivity
            net.one97.paytm.recharge.model.v4.CJRInstruct$openPostOrderSummaryActivity r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openPostOrderSummaryActivity) r11
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r2 = r11.getRechargePayment()
            net.one97.paytm.common.entity.CJRRechargeCart r3 = r11.getRechargeCart()
            java.lang.Object r11 = r11.getHawkEyeEvent()
            r1.<init>(r2, r3, r11)
            r0.setValue(r1)
            return
        L_0x0076:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x00a5
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r2 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r10.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r3.getCategoryData()
            if (r3 == 0) goto L_0x0090
            java.lang.String r3 = r3.getDisplayName()
            if (r3 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r1 = r3
        L_0x0090:
            net.one97.paytm.recharge.model.v4.CJRInstruct$openRechargePaymentActivity r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openRechargePaymentActivity) r11
            net.one97.paytm.common.entity.CJRRechargeCart r3 = r11.getRechargeCart()
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r4 = r11.getRechargePayment()
            java.lang.Object r11 = r11.getHawkEyeEvent()
            r2.<init>(r1, r3, r4, r11)
            r0.setValue(r2)
            return
        L_0x00a5:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity
            r2 = 0
            if (r0 == 0) goto L_0x00fb
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r10.f61409b
            java.lang.String r6 = r0.getProtectionURL()
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r10.f61409b
            java.lang.Boolean r7 = r0.getDealsFastForward()
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r10.f61409b
            java.lang.String r8 = r0.getGroupFieldValuesForGA()
            net.one97.paytm.recharge.common.utils.x r0 = r10.f61410c
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r0.f61812a
            if (r0 == 0) goto L_0x00cf
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x00cf
            java.lang.Object r0 = kotlin.a.k.e(r0)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            goto L_0x00d0
        L_0x00cf:
            r0 = r2
        L_0x00d0:
            if (r0 == 0) goto L_0x00d6
            java.lang.String r2 = r0.getDealsMessage()
        L_0x00d6:
            r9 = r2
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r2 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r10.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r3.getCategoryData()
            if (r3 == 0) goto L_0x00ec
            java.lang.String r3 = r3.getDisplayName()
            if (r3 != 0) goto L_0x00ea
            goto L_0x00ec
        L_0x00ea:
            r4 = r3
            goto L_0x00ed
        L_0x00ec:
            r4 = r1
        L_0x00ed:
            net.one97.paytm.recharge.model.v4.CJRInstruct$openCouponsActivity r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openCouponsActivity) r11
            net.one97.paytm.common.entity.CJRRechargeCart r5 = r11.getRechargeCart()
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.setValue(r2)
            return
        L_0x00fb:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.onContainsError
            if (r0 == 0) goto L_0x0118
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$onContainsError r1 = new net.one97.paytm.recharge.model.v4.CJRInstruct$onContainsError
            net.one97.paytm.recharge.model.v4.CJRInstruct$onContainsError r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.onContainsError) r11
            java.lang.String r2 = r11.getMessage()
            java.lang.String r3 = r11.getTag()
            java.lang.Object r11 = r11.getHawkEyeModel()
            r1.<init>(r2, r3, r11)
            r0.setValue(r1)
            return
        L_0x0118:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart
            if (r0 == 0) goto L_0x012d
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart r1 = new net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargeCart r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargeCart) r11
            net.one97.paytm.common.entity.CJRRechargeCart r11 = r11.getRechargeCart()
            r1.<init>(r11)
            r0.setValue(r1)
            return
        L_0x012d:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargePayment
            if (r0 == 0) goto L_0x0142
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargePayment r1 = new net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargePayment
            net.one97.paytm.recharge.model.v4.CJRInstruct$saveRechargePayment r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.saveRechargePayment) r11
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r11 = r11.getRechargePayment()
            r1.<init>(r11)
            r0.setValue(r1)
            return
        L_0x0142:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.updateCreateBillResponse
            if (r0 == 0) goto L_0x0159
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse>> r0 = r10.f61415h
            net.one97.paytm.recharge.model.v4.Data r1 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r3 = net.one97.paytm.recharge.model.v4.DataState.SUCCESS
            net.one97.paytm.recharge.model.v4.CJRInstruct$updateCreateBillResponse r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.updateCreateBillResponse) r11
            net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse r11 = r11.getSetUserConsentResponse()
            r1.<init>(r3, r11, r2)
            r0.postValue(r1)
            return
        L_0x0159:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.updateGetBillResponse
            if (r0 == 0) goto L_0x0170
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse>> r0 = r10.f61416i
            net.one97.paytm.recharge.model.v4.Data r1 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r3 = net.one97.paytm.recharge.model.v4.DataState.SUCCESS
            net.one97.paytm.recharge.model.v4.CJRInstruct$updateGetBillResponse r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.updateGetBillResponse) r11
            net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse r11 = r11.getGetUserConsentResponse()
            r1.<init>(r3, r11, r2)
            r0.postValue(r1)
            return
        L_0x0170:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.updateUnsubscribeBillResponse
            if (r0 == 0) goto L_0x0187
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse>> r0 = r10.x
            net.one97.paytm.recharge.model.v4.Data r1 = new net.one97.paytm.recharge.model.v4.Data
            net.one97.paytm.recharge.model.v4.DataState r3 = net.one97.paytm.recharge.model.v4.DataState.SUCCESS
            net.one97.paytm.recharge.model.v4.CJRInstruct$updateUnsubscribeBillResponse r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.updateUnsubscribeBillResponse) r11
            net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse r11 = r11.getUnsubscribeResponse()
            r1.<init>(r3, r11, r2)
            r0.postValue(r1)
            return
        L_0x0187:
            boolean r0 = r11 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openSubscriberBottomSheet
            if (r0 == 0) goto L_0x019f
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r0 = r10.f61408a
            net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet r1 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet
            net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet r11 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openSubscriberBottomSheet) r11
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r11.getRechargeCart()
            net.one97.paytm.common.entity.shopping.CJRGroupDisplay r11 = r11.getCjrGroupDisplay()
            r1.<init>(r2, r11)
            r0.setValue(r1)
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.h.b.a(net.one97.paytm.recharge.model.v4.CJRInstruct):void");
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        int hashCode = str.hashCode();
        if (hashCode != 85548875) {
            if (hashCode != 1288791337) {
                if (hashCode == 1322899172 && str.equals("delete_recents")) {
                    return;
                }
            } else if (str.equals("frequent_api")) {
                if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
                    CJRRechargeUtilities.INSTANCE.setFrequentOrderList((CJRFrequentOrderList) iJRPaytmDataModel);
                    String value = this.f61413f.getValue();
                    if (value != null) {
                        a(str, value, true, obj);
                        return;
                    }
                    return;
                }
                return;
            }
        } else if (str.equals("markAsPaid")) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRFrequentOrderDeletResponse) {
            Integer code = ((CJRFrequentOrderDeletResponse) iJRPaytmDataModel).getCode();
            if (code != null && code.intValue() == 200) {
                a(str, obj);
            }
        } else if (iJRPaytmDataModel instanceof CJROffers) {
            this.k.setValue(iJRPaytmDataModel);
            this.y.put(this.z, iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
            CJRRechargeUtilities.INSTANCE.setFrequentOrderList((CJRFrequentOrderList) iJRPaytmDataModel);
            String value2 = this.f61413f.getValue();
            if (value2 != null) {
                a(str, value2, true, obj);
            }
        }
    }

    public void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        String str2;
        k.c(str, "tag");
        int hashCode = str.hashCode();
        if (hashCode != 1288791337) {
            if (hashCode == 1322899172 && str.equals("delete_recents")) {
                ((kotlin.g.a.q) this.u).invoke(str, networkCustomError, obj);
                return;
            }
        } else if (str.equals("frequent_api")) {
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                if (flowName != null) {
                    NetworkCustomError.ErrorType errorType = networkCustomError != null ? networkCustomError.getErrorType() : null;
                    if (errorType != null) {
                        int i3 = c.f61426a[errorType.ordinal()];
                        if (i3 == 1 || i3 == 2) {
                            str2 = ERROR_TYPE.NO_CONNECTION.name();
                            flowName.setErrorType(str2);
                        } else if (i3 == 3) {
                            str2 = ERROR_TYPE.AUTH.name();
                            flowName.setErrorType(str2);
                        }
                    }
                    str2 = ERROR_TYPE.UNDEFINED.name();
                    flowName.setErrorType(str2);
                }
                CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.FETCH_RECENTS.name());
                }
                cJRRechargeErrorModel.setUserFacing(a.b.SILENT);
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
            this.f61414g.setValue(new ArrayList());
            return;
        }
        ((kotlin.g.a.q) this.u).invoke(str, networkCustomError, obj);
    }

    public final void a(String str, String str2, String str3, String str4) {
        k.c(str, "billAmount");
        k.c(str2, "groupFieldVal");
        k.c(str3, "inputFieldVal");
        k.c(str4, "serviceType");
        net.one97.paytm.recharge.ordersummary.h.d dVar = this.v;
        k.c(str, "billAmount");
        k.c(str2, "groupFieldValue");
        k.c(str3, "inputFieldValue");
        k.c(str4, "serviceType");
        try {
            HashMap hashMap = new HashMap();
            if (!p.a(str)) {
                hashMap.put("recharge_utilities_amount", str);
            }
            hashMap.put("recharge_utilities_group_field_values", str2);
            hashMap.put("recharge_utilities_input_field_values", str3);
            hashMap.put("recharge_utilities_service_type", str4);
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(dVar.a(), (Map<String, Object>) hashMap, "recharge_utilities_recent_selected_inline", dVar.f64344b);
        } catch (Throwable unused) {
        }
    }

    public final Map<String, Object> a(String str, String str2, String str3, String str4, boolean z2) {
        k.c(str, "inputFieldValues");
        k.c(str2, "groupFieldValues");
        k.c(str3, "amount");
        k.c(str4, "serviceType");
        return this.v.a(str, str2, str3, str4, z2);
    }

    public void onCleared() {
        AsyncTask<String, String, List<CJRFrequentOrder>> asyncTask = this.A;
        if (asyncTask != null && !asyncTask.isCancelled()) {
            AsyncTask<String, String, List<CJRFrequentOrder>> asyncTask2 = this.A;
            if (asyncTask2 != null) {
                asyncTask2.cancel(true);
            }
            this.A = null;
        }
        w wVar = this.t;
        if (wVar != null) {
            wVar.q = null;
        }
        this.t = null;
        this.f61412e = true;
        super.onCleared();
    }
}
