package net.one97.paytm.recharge.automatic.f;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.recharge.automatic.f.a;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.b;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.q;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.legacy.catalog.model.v2.TopLevelCategoryHeader;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final TopLevelCategoryHeader f60282a;

    /* renamed from: b  reason: collision with root package name */
    b f60283b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.recharge.common.f.a f60284c;

    /* renamed from: d  reason: collision with root package name */
    Context f60285d;

    /* renamed from: e  reason: collision with root package name */
    String f60286e;

    public a(b bVar, TopLevelCategoryHeader topLevelCategoryHeader) {
        this.f60283b = bVar;
        this.f60282a = topLevelCategoryHeader;
    }

    public final void a(String str, Context context, String str2, Object obj) {
        this.f60285d = context;
        this.f60286e = str2;
        c cVar = c.f62654a;
        String c2 = c.c();
        String b2 = ax.a(this.f60285d.getApplicationContext()).b(e.aQ, "", true);
        if ((!(this.f60285d == null) && !(true ^ z.a(this.f60285d))) && !TextUtils.isEmpty(b2)) {
            if (!TextUtils.isEmpty(b2)) {
                c2 = c2 + "?cust_id=" + b2;
            }
            if (URLUtil.isValidUrl(c2)) {
                this.f60284c = new b(str, com.paytm.utility.b.s(context, c2), new ai() {
                    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                        boolean z;
                        if (iJRPaytmDataModel instanceof CJRAutomaticSubscriptionListModel) {
                            CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = (CJRAutomaticSubscriptionListModel) iJRPaytmDataModel;
                            ArrayList<CJRAutomaticSubscriptionItemModel> subscriptionModelArrayList = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList();
                            List<CJRFrequentOrder> arrayList = new ArrayList<>();
                            CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
                            if (frequentOrderList != null) {
                                q qVar = q.f61722a;
                                arrayList = q.a((List<? extends CJRFrequentOrder>) frequentOrderList.getOrderList(), a.this.f60286e);
                            }
                            boolean z2 = true;
                            if (!net.one97.paytm.recharge.automatic.b.a.c.a(subscriptionModelArrayList) && a.this.f60286e != null) {
                                List<CJRAutomaticSubscriptionItemModel> a2 = net.one97.paytm.recharge.automatic.b.a.c.a((List<CJRAutomaticSubscriptionItemModel>) subscriptionModelArrayList, a.this.f60286e);
                                Iterator<CJRAutomaticSubscriptionItemModel> it2 = a2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (it2.next().getPaymentMode() == null) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (z) {
                                    a.this.f60283b.e();
                                }
                                a.this.f60283b.a(a2);
                            } else if (net.one97.paytm.recharge.automatic.b.a.c.a(arrayList)) {
                                a.this.f60283b.a(false);
                            }
                            List<CJRFrequentOrder> a3 = net.one97.paytm.recharge.automatic.b.a.c.a(arrayList, (List<CJRAutomaticSubscriptionItemModel>) subscriptionModelArrayList, a.this.f60285d);
                            if (!net.one97.paytm.recharge.automatic.b.a.c.a(net.one97.paytm.recharge.automatic.b.a.c.a(arrayList, (List<CJRAutomaticSubscriptionItemModel>) subscriptionModelArrayList, a.this.f60286e)) || net.one97.paytm.recharge.automatic.b.a.c.a(a3)) {
                                z2 = false;
                            }
                            if (z2 && a.this.f60282a != null && !TextUtils.isEmpty(a.this.f60282a.title)) {
                                net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                                    public final Object invoke() {
                                        return a.AnonymousClass1.this.a();
                                    }
                                });
                            }
                            a.this.f60283b.a(z2);
                            a.this.f60283b.a(cJRAutomaticSubscriptionListModel);
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ x a() {
                        HashMap hashMap = new HashMap();
                        hashMap.put("recharge_utilities_service_type", a.this.f60286e);
                        hashMap.put("user_id", com.paytm.utility.b.n(a.this.f60285d));
                        hashMap.put("automatic_top_strip_visible_yes_or_no", H5AppHandler.CHECK_VALUE);
                        hashMap.put("service_type", a.this.f60286e);
                        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                        net.one97.paytm.recharge.di.helper.b.a("automatic_bill_payment_top_strip_visibility", (Map<String, ? extends Object>) hashMap, a.this.f60285d);
                        return null;
                    }

                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                        a.this.f60283b.a(false);
                    }
                }, new CJRAutomaticSubscriptionListModel(), com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), context), obj);
                d.a();
                d.b(this.f60284c);
            }
        }
    }
}
