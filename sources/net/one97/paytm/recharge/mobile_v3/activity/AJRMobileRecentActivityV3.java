package net.one97.paytm.recharge.mobile_v3.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.r;
import net.one97.paytm.recharge.common.h.b;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.e;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.utils.y;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.mobile_v3.d.c;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class AJRMobileRecentActivityV3 extends CJRRechargeBaseActivity implements p.a, p.c, e.a, c {

    /* renamed from: a  reason: collision with root package name */
    p f63756a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.recharge.mobile.d.a f63757b;

    /* renamed from: c  reason: collision with root package name */
    private CJRFrequentOrder f63758c;

    /* renamed from: d  reason: collision with root package name */
    private CJRRecentOrderV8.a f63759d;

    /* renamed from: e  reason: collision with root package name */
    private e f63760e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f63761f;

    private View a(int i2) {
        if (this.f63761f == null) {
            this.f63761f = new HashMap();
        }
        View view = (View) this.f63761f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63761f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
    }

    public final void an_() {
    }

    public final void ap_() {
    }

    public final void ar_() {
    }

    public final void d(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
    }

    public final void f() {
    }

    static final class a extends l implements b<List<? extends CJRFrequentOrder>, x> {
        final /* synthetic */ AJRMobileRecentActivityV3 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AJRMobileRecentActivityV3 aJRMobileRecentActivityV3) {
            super(1);
            this.this$0 = aJRMobileRecentActivityV3;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends CJRFrequentOrder>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<? extends CJRFrequentOrder> list) {
            if (list != null && (!list.isEmpty())) {
                AJRMobileRecentActivityV3.a(this.this$0, (List) list);
            } else if (this.this$0.f63756a != null && list != null) {
                AJRMobileRecentActivityV3.a(this.this$0, (List) list);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        LiveData liveData;
        super.onCreate(bundle);
        setContentView(R.layout.v3_activity_ajrmobile_recent);
        setSupportActionBar((Toolbar) a(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
        }
        y yVar = y.f61814b;
        this.f63757b = y.j();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63757b;
        if (aVar != null) {
            liveData = aVar.f61414g;
        } else {
            liveData = null;
        }
        g.a(this, liveData, new a(this));
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, int i2) {
        CJRFrequentOrder cJRFrequentOrder2 = cJRFrequentOrder;
        k.c(cJRFrequentOrder2, "item");
        if (com.paytm.utility.b.c((Context) this)) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63757b;
            if (aVar != null) {
                d dVar = d.f64967a;
                CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.DELETE_RECENT.name());
                }
                k.c("delete_recents", "tag");
                k.c(cJRFrequentOrder2, "recentOrder");
                aVar.j = cJRFrequentOrder2;
                aVar.a("delete_recents", a2);
                aVar.s.a("delete_recents", (ai) new b.c(aVar), cJRFrequentOrder2, (Object) a2);
                net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "clear_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                return;
            }
            return;
        }
        CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, "", this, (Fragment) null, new as(false, 1, (kotlin.g.b.g) null), false, 0, (Object) null, 16, (Object) null);
    }

    public final void a(String str, NetworkCustomError networkCustomError) {
        k.c(str, "tag");
        CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, (Object) null, 16, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.Long] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(net.one97.paytm.common.entity.recharge.CJRFrequentOrder r12, int r13) {
        /*
            r11 = this;
            java.lang.String r0 = "item"
            kotlin.g.b.k.c(r12, r0)
            r11.f63758c = r12
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.SETUP_AUTOMATIC_CLICK
            r1 = 0
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r11.f63757b
            if (r0 == 0) goto L_0x0025
            net.one97.paytm.recharge.ordersummary.h.d r2 = r0.v
            java.lang.Object r3 = r0.e()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 124(0x7c, float:1.74E-43)
            java.lang.String r4 = "setup_autopay_clicked"
            net.one97.paytm.recharge.ordersummary.h.d.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x0025:
            r0 = r11
            android.content.Context r0 = (android.content.Context) r0
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r2 == 0) goto L_0x0078
            net.one97.paytm.recharge.common.utils.e r0 = new net.one97.paytm.recharge.common.utils.e
            r4 = r11
            android.app.Activity r4 = (android.app.Activity) r4
            java.util.Map r2 = r12.getConfiguration()
            if (r2 == 0) goto L_0x0043
            java.lang.String r12 = r12.TAG_RECHARGE_NUMBER
            java.lang.Object r12 = r2.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            r5 = r12
            goto L_0x0044
        L_0x0043:
            r5 = r1
        L_0x0044:
            if (r5 != 0) goto L_0x0049
            kotlin.g.b.k.a()
        L_0x0049:
            androidx.fragment.app.j r6 = r11.getSupportFragmentManager()
            java.lang.String r12 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
            net.one97.paytm.recharge.mobile.d.a r12 = r11.f63757b
            if (r12 == 0) goto L_0x0064
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r12 = r12.f61409b
            if (r12 == 0) goto L_0x0064
            net.one97.paytm.recharge.model.v4.CJRCategoryData r12 = r12.getCategoryData()
            if (r12 == 0) goto L_0x0064
            java.lang.Long r1 = r12.getCategoryId()
        L_0x0064:
            r7 = r1
            r8 = r11
            net.one97.paytm.recharge.common.utils.e$a r8 = (net.one97.paytm.recharge.common.utils.e.a) r8
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            r11.f63760e = r0
            net.one97.paytm.recharge.common.utils.e r12 = r11.f63760e
            if (r12 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            r12.f61622g = r13
            return
        L_0x0078:
            android.content.res.Resources r12 = r11.getResources()
            if (r12 == 0) goto L_0x0085
            int r13 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r12 = r12.getString(r13)
            goto L_0x0086
        L_0x0085:
            r12 = r1
        L_0x0086:
            android.content.res.Resources r13 = r11.getResources()
            if (r13 == 0) goto L_0x0092
            int r1 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r1 = r13.getString(r1)
        L_0x0092:
            com.paytm.utility.g.c(r0, r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.activity.AJRMobileRecentActivityV3.b(net.one97.paytm.common.entity.recharge.CJRFrequentOrder, int):void");
    }

    public final void aq_() {
        e eVar;
        String str;
        int i2;
        String rechargeNumber;
        d dVar = d.f64967a;
        d.a((CJRRechargeErrorModel) null, ACTION_TYPE.PERFORM_AUTO_PAY_VERIFY_CALL);
        if (this.f63758c != null && (eVar = this.f63760e) != null && (str = eVar.f61619d) != null) {
            CJRFrequentOrder cJRFrequentOrder = this.f63758c;
            if (kotlin.m.p.a(str, cJRFrequentOrder != null ? cJRFrequentOrder.getRechargeNumber() : null, true) && this.f63757b != null) {
                Bundle bundle = new Bundle();
                e eVar2 = this.f63760e;
                if (eVar2 != null) {
                    i2 = eVar2.f61622g;
                } else {
                    i2 = -1;
                }
                bundle.putInt("key_position", i2);
                Context context = this;
                if (az.c(context)) {
                    CJRFrequentOrder cJRFrequentOrder2 = this.f63758c;
                    if (cJRFrequentOrder2 != null && (rechargeNumber = cJRFrequentOrder2.getRechargeNumber()) != null) {
                        az.g(context, rechargeNumber);
                        return;
                    }
                    return;
                }
                net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
                Activity activity = this;
                CJRFrequentOrder cJRFrequentOrder3 = this.f63758c;
                if (cJRFrequentOrder3 == null) {
                    k.a();
                }
                net.one97.paytm.recharge.common.utils.a.a((Fragment) null, activity, cJRFrequentOrder3, bundle);
            }
        }
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, int i2) {
        k.c(cJRFrequentOrder, "item");
        k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
        d dVar = d.f64967a;
        d.a((CJRRechargeErrorModel) null, ACTION_TYPE.MANAGE_AUTOMATIC_CLICK);
        Context context = this;
        if (az.c(context)) {
            az.a(context, cJRAutomaticSubscriptionItemModel.getSubscriptionId());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_position", i2);
        net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
        net.one97.paytm.recharge.common.utils.a.a((Fragment) null, (FragmentActivity) this, cJRFrequentOrder, cJRAutomaticSubscriptionItemModel, bundle);
    }

    public final void c(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
        Intent intent = new Intent();
        intent.putExtra("recentItem", cJRFrequentOrder);
        intent.putExtra("recentItemPos", i2);
        setResult(-1, intent);
        finish();
    }

    public final void a(boolean z) {
        FrameLayout frameLayout;
        if (z) {
            FrameLayout frameLayout2 = (FrameLayout) a(R.id.overlay_view);
            if (frameLayout2 != null) {
                net.one97.paytm.recharge.common.utils.ai.a(frameLayout2);
            }
        } else if (!z && (frameLayout = (FrameLayout) a(R.id.overlay_view)) != null) {
            net.one97.paytm.recharge.common.utils.ai.b(frameLayout);
        }
    }

    public static final /* synthetic */ void a(AJRMobileRecentActivityV3 aJRMobileRecentActivityV3, List list) {
        if (aJRMobileRecentActivityV3.f63757b != null) {
            if (aJRMobileRecentActivityV3.f63756a == null) {
                CJRRecentOrderV8.a a2 = new CJRRecentOrderV8.a().a((List<? extends CJRFrequentOrder>) list);
                a2.s = aJRMobileRecentActivityV3;
                CJRRecentOrderV8.a a3 = a2.a(CJRRecentOrderV8.b.MOBILE_V3.ordinal());
                a3.f61927e = aJRMobileRecentActivityV3;
                a3.f61928f = aJRMobileRecentActivityV3;
                a3.f61930h = true;
                net.one97.paytm.recharge.mobile.d.a aVar = aJRMobileRecentActivityV3.f63757b;
                if (aVar == null) {
                    k.a();
                }
                CJRRecentOrderV8.a a4 = a3.a((r) aVar);
                j supportFragmentManager = aJRMobileRecentActivityV3.getSupportFragmentManager();
                k.a((Object) supportFragmentManager, "supportFragmentManager");
                aJRMobileRecentActivityV3.f63759d = a4.a(supportFragmentManager);
                CJRRecentOrderV8.a aVar2 = aJRMobileRecentActivityV3.f63759d;
                if (aVar2 != null) {
                    if (aVar2 == null) {
                        k.a();
                    }
                    aJRMobileRecentActivityV3.f63756a = new p(aVar2);
                }
                p pVar = aJRMobileRecentActivityV3.f63756a;
                if (pVar != null) {
                    pVar.f60648a = true;
                }
                RecyclerView recyclerView = (RecyclerView) aJRMobileRecentActivityV3.a(R.id.recent_recycler_view);
                k.a((Object) recyclerView, "recent_recycler_view");
                recyclerView.setAdapter(aJRMobileRecentActivityV3.f63756a);
            } else {
                CJRRecentOrderV8.a aVar3 = aJRMobileRecentActivityV3.f63759d;
                if (aVar3 != null) {
                    aVar3.a((List<? extends CJRFrequentOrder>) list);
                }
                p pVar2 = aJRMobileRecentActivityV3.f63756a;
                if (pVar2 != null) {
                    pVar2.notifyDataSetChanged();
                }
            }
            if (com.paytm.utility.b.c((Context) aJRMobileRecentActivityV3)) {
                net.one97.paytm.recharge.mobile.d.a aVar4 = aJRMobileRecentActivityV3.f63757b;
                if (aVar4 == null) {
                    k.a();
                }
                if (aVar4.s.a()) {
                    net.one97.paytm.recharge.mobile.d.a aVar5 = aJRMobileRecentActivityV3.f63757b;
                    if (aVar5 == null) {
                        k.a();
                    }
                    if (!aVar5.R) {
                        net.one97.paytm.recharge.mobile.d.a aVar6 = aJRMobileRecentActivityV3.f63757b;
                        if (aVar6 == null) {
                            k.a();
                        }
                        if (aVar6.l.b() == null) {
                            net.one97.paytm.recharge.mobile.d.a aVar7 = aJRMobileRecentActivityV3.f63757b;
                            if (aVar7 == null) {
                                k.a();
                            }
                            aVar7.R = true;
                            d dVar = d.f64967a;
                            CJRRechargeErrorModel a5 = d.a(ACTION_TYPE.RECENT_SUBSCRIPTION_STATUS, ERROR_TYPE.UNDEFINED);
                            net.one97.paytm.recharge.mobile.d.a aVar8 = aJRMobileRecentActivityV3.f63757b;
                            if (aVar8 != null) {
                                aVar8.c("check_subscription", (ai) aVar8, (Object) a5);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        aJRMobileRecentActivityV3.finish();
    }
}
