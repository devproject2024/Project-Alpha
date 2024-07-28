package net.one97.paytm.upgradeKyc.videokyc.b;

import android.app.Application;
import android.location.Location;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.d.b.a.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.common.entity.upgradeKyc.KYCWaitTimeResponse;
import net.one97.paytm.common.entity.upgradeKyc.VideoKYCLeadResponse;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.FulfillmentReq;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.Item;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.MyOrderApiResponse;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.Order;
import net.one97.paytm.common.utility.g;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity;
import org.json.JSONObject;

public final class d extends androidx.lifecycle.a {
    public static final a w = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public Location f66469a;

    /* renamed from: b  reason: collision with root package name */
    public g f66470b;

    /* renamed from: c  reason: collision with root package name */
    public int f66471c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66472d;

    /* renamed from: e  reason: collision with root package name */
    public int f66473e = 2;

    /* renamed from: f  reason: collision with root package name */
    public String f66474f;

    /* renamed from: g  reason: collision with root package name */
    public y<HashMap<String, String>> f66475g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public int f66476h;

    /* renamed from: i  reason: collision with root package name */
    public int f66477i = 15;
    public boolean j;
    public String k = "WORKAPPS";
    public String l = "";
    public boolean m;
    public y<net.one97.paytm.upgradeKyc.kycV3.b.b<MyOrderApiResponse>> n = new y<>();
    public y<net.one97.paytm.upgradeKyc.kycV3.b.b<VideoKYCLeadResponse>> o = new y<>();
    public String p = "user_have_no_appointment_booked";
    public FulfillmentReq q;
    public y<String> r = new y<>();
    public final w<net.one97.paytm.upgradeKyc.kycV3.b.b<MyOrderApiResponse>> s = new w<>();
    public final LiveData<Boolean> t = this.x;
    public final LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCWaitTimeResponse>> u;
    public final net.one97.paytm.upgradeKyc.kycV3.b.c v;
    private y<Boolean> x = new y<>();
    private final Application y;

    public static final class b<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<MyOrderApiResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f66478a;

        public b(d dVar) {
            this.f66478a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Order order;
            ArrayList<Item> arrayList;
            Item item;
            ArrayList<Item> arrayList2;
            Item item2;
            ArrayList<Order> arrayList3;
            Item item3;
            FulfillmentReq fulfillmentReq;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (e.f66480a[bVar.f66168a.ordinal()] == 1) {
                MyOrderApiResponse myOrderApiResponse = (MyOrderApiResponse) bVar.f66169b;
                FulfillmentReq fulfillmentReq2 = null;
                if (myOrderApiResponse == null || (arrayList3 = myOrderApiResponse.orders) == null) {
                    order = null;
                } else {
                    Iterator<Order> it2 = arrayList3.iterator();
                    order = null;
                    while (it2.hasNext()) {
                        Order next = it2.next();
                        ArrayList<Item> arrayList4 = next.items;
                        if (!(arrayList4 == null || (item3 = arrayList4.get(0)) == null || (fulfillmentReq = item3.fulfillmentReq) == null)) {
                            CharSequence charSequence = fulfillmentReq.eventSlug;
                            if (!(charSequence == null || charSequence.length() == 0) && p.a(fulfillmentReq.eventSlug, this.f66478a.l, true)) {
                                if (order != null) {
                                    Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(next.date);
                                    k.a((Object) parse, "SimpleDateFormat(\"yyyy-M…mm:ss\").parse(order.date)");
                                    long time = parse.getTime();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                    if (order == null) {
                                        k.a();
                                    }
                                    Date parse2 = simpleDateFormat.parse(order.date);
                                    k.a((Object) parse2, "SimpleDateFormat(\"yyyy-M…e(mostRecentOrder!!.date)");
                                    if (time <= parse2.getTime()) {
                                    }
                                }
                                order = next;
                            }
                        }
                    }
                }
                if (((order == null || (arrayList2 = order.items) == null || (item2 = arrayList2.get(0)) == null) ? null : item2.fulfillmentReq) != null) {
                    d dVar = this.f66478a;
                    if (!(order == null || (arrayList = order.items) == null || (item = arrayList.get(0)) == null)) {
                        fulfillmentReq2 = item.fulfillmentReq;
                    }
                    if (fulfillmentReq2 == null) {
                        k.a();
                    }
                    dVar.q = fulfillmentReq2;
                    FulfillmentReq fulfillmentReq3 = this.f66478a.q;
                    if (fulfillmentReq3 == null) {
                        k.a();
                    }
                    String str = fulfillmentReq3.itemExpiry;
                    k.a((Object) str, "appointmentDetails!!.itemExpiry");
                    long parseLong = Long.parseLong(str) * 1000;
                    long j = parseLong - ((long) ((this.f66478a.f66476h * 60) * 1000));
                    long j2 = parseLong + ((long) (this.f66478a.f66477i * 60 * 1000));
                    Calendar instance = Calendar.getInstance();
                    k.a((Object) instance, "Calendar.getInstance()");
                    long timeInMillis = instance.getTimeInMillis();
                    int i2 = (timeInMillis > j2 ? 1 : (timeInMillis == j2 ? 0 : -1));
                    if (i2 > 0) {
                        this.f66478a.p = "user_missed_appointment";
                    } else if (timeInMillis < j || i2 > 0) {
                        this.f66478a.p = "user_is_early_as_per_appointment_booked_time";
                    } else {
                        this.f66478a.p = "user_ontime";
                    }
                }
            }
            this.f66478a.s.setValue(bVar);
            if (bVar.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS || bVar.f66168a == net.one97.paytm.upgradeKyc.kycV3.b.d.ERROR) {
                this.f66478a.s.removeSource(this.f66478a.n);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application, net.one97.paytm.upgradeKyc.kycV3.b.c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.y = application;
        this.v = cVar;
        LiveData<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCWaitTimeResponse>> b2 = ah.b(this.r, new C1336d(this));
        k.a((Object) b2, "Transformations.switchMa…getVideoKYCTimeV2()\n    }");
        this.u = b2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(boolean z) {
        this.x.setValue(Boolean.valueOf(z));
    }

    @f(b = "VideoKYCSharedViewModel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.videokyc.viewmodel.VideoKYCSharedViewModel$parseAgentLanguages$1")
    public static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d dVar, kotlin.d.d dVar2) {
            super(2, dVar2);
            this.this$0 = dVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                HashMap hashMap = new HashMap();
                d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                if (d.a.a() == null) {
                    k.a();
                }
                JSONObject jSONObject = new JSONObject(net.one97.paytm.upgradeKyc.helper.d.a("VideoKycAgentLanguage"));
                Iterator<String> keys = jSONObject.keys();
                k.a((Object) keys, "obj.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    k.a((Object) string, "obj.getString(k)");
                    k.a((Object) next, "k");
                    hashMap.put(string, next);
                }
                this.this$0.f66475g.postValue(hashMap);
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.videokyc.b.d$d  reason: collision with other inner class name */
    static final class C1336d<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f66479a;

        C1336d(d dVar) {
            this.f66479a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str;
            net.one97.paytm.upgradeKyc.kycV3.b.c b2 = this.f66479a.v;
            y yVar = new y();
            b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
            yVar.setValue(b.a.a());
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() != null) {
                d.a aVar3 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                if (d.a.a() == null) {
                    k.a();
                }
                str = net.one97.paytm.upgradeKyc.helper.d.a("fetchWaitTime");
            } else {
                str = null;
            }
            if (!URLUtil.isValidUrl(str)) {
                b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(b2.b()));
            } else if (TextUtils.isEmpty(com.paytm.utility.d.a(b2.f66175b))) {
                b.a aVar5 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                yVar.setValue(b.a.a(b2.b()));
            } else {
                Map hashMap = new HashMap();
                String a2 = com.paytm.utility.d.a(b2.f66175b);
                k.a((Object) a2, "CJRNetUtility.getSSOToken(this.appContext)");
                hashMap.put("session_token", a2);
                KYCWaitTimeResponse kYCWaitTimeResponse = new KYCWaitTimeResponse();
                a.C1317a aVar6 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                com.paytm.network.a l = a.C1317a.a().a(b2.f66175b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) kYCWaitTimeResponse).a(str).c(VideoKycActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.m(yVar)).l();
                if (com.paytm.utility.b.c(b2.f66175b)) {
                    l.a();
                } else {
                    b.a aVar7 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                    yVar.setValue(b.a.a(b2.c()));
                }
            }
            return yVar;
        }
    }
}
