package net.one97.paytm.recharge.metro.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.f.i;
import net.one97.paytm.recharge.ordersummary.f.p;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class b implements ai, i, p {

    /* renamed from: c  reason: collision with root package name */
    public static final a f63570c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<Long, Boolean> f63571f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public View f63572a;

    /* renamed from: b  reason: collision with root package name */
    public int f63573b = -1;

    /* renamed from: d  reason: collision with root package name */
    private final Context f63574d;

    /* renamed from: e  reason: collision with root package name */
    private final C1228b f63575e;

    /* renamed from: net.one97.paytm.recharge.metro.f.b$b  reason: collision with other inner class name */
    public interface C1228b {
        void a(View view, boolean z);
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
    }

    public final void aw_() {
    }

    public b(Context context, C1228b bVar) {
        k.c(context, "context");
        this.f63574d = context;
        this.f63575e = bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(long j, boolean z) {
            synchronized (b.f63571f) {
                b.f63571f.put(Long.valueOf(j), Boolean.valueOf(z));
                x xVar = x.f47997a;
            }
        }
    }

    public final void a(CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        Class<b> cls = b.class;
        k.c(cJRActiveMetroTicketModel, "ticket");
        synchronized (f63571f) {
            if (f63571f.containsKey(Long.valueOf(cJRActiveMetroTicketModel.getProductId()))) {
                C1228b bVar = this.f63575e;
                if (bVar != null) {
                    View view = this.f63572a;
                    Boolean bool = f63571f.get(Long.valueOf(cJRActiveMetroTicketModel.getProductId()));
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    bVar.a(view, bool.booleanValue());
                    x xVar = x.f47997a;
                }
            } else {
                try {
                    Handler handler = new Handler(Looper.getMainLooper());
                    d dVar = d.f64967a;
                    z.a("fetch_order_detail", this.f63574d, "Order_history", cJRActiveMetroTicketModel.getOrderId(), this, this, this, handler, 1, d.a(ACTION_TYPE.UNDEFINED, ERROR_TYPE.UNDEFINED));
                    x xVar2 = x.f47997a;
                } catch (NullPointerException e2) {
                    cls.getSimpleName();
                    q.b(e2.getMessage());
                    x xVar3 = x.f47997a;
                } catch (IllegalStateException e3) {
                    cls.getSimpleName();
                    q.b(e3.getMessage());
                    x xVar4 = x.f47997a;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r3 = r3.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.paytm.network.model.IJRPaytmDataModel r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            r1 = 0
            if (r0 == 0) goto L_0x001f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r3
            java.util.ArrayList r3 = r3.getOrderedCartList()
            if (r3 == 0) goto L_0x001a
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            if (r3 == 0) goto L_0x001a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r3 = r3.getTapAction()
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x001f
            r3 = 1
            return r3
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.f.b.a(com.paytm.network.model.IJRPaytmDataModel):boolean");
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        boolean z = false;
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            CJROrderedCart cJROrderedCart = ((CJROrderSummary) iJRPaytmDataModel).getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "response.orderedCartList[0]");
            CJROrderSummaryAction tapAction = cJROrderedCart.getTapAction();
            k.a((Object) tapAction, "tapAction");
            CJROrderSummaryActionURLParams urlParams = tapAction.getUrlParams();
            k.a((Object) urlParams, "tapAction.urlParams");
            String url = urlParams.getUrl();
            k.a((Object) url, "tapAction.urlParams.url");
            if (url.length() == 0) {
                z = true;
            }
            if (!z) {
                b.a aVar = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
                net.one97.paytm.recharge.ordersummary.h.b a2 = b.a.a(this.f63574d);
                d dVar = d.f64967a;
                a2.a("tap_action", tapAction, d.a(ACTION_TYPE.UNDEFINED, ERROR_TYPE.UNDEFINED), this);
            }
        } else if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
            c.a aVar2 = c.f63576a;
            CJROSActionResponseV2 cJROSActionResponseV2 = (CJROSActionResponseV2) iJRPaytmDataModel;
            List<CJRActiveMetroTicketModel> a3 = c.a.a((List<? extends CJRActiveMetroTicketModel>) cJROSActionResponseV2.getTickets(), (List<? extends CJRActiveMetroTicketModel>) cJROSActionResponseV2.getPasses());
            if (a3 != null && !a3.isEmpty()) {
                c.a aVar3 = c.f63576a;
                boolean c2 = c.a.c((List<? extends CJRActiveMetroTicketModel>) a3);
                synchronized (f63571f) {
                    f63571f.put(Long.valueOf(a3.get(0).getProductId()), Boolean.valueOf(c2));
                    C1228b bVar = this.f63575e;
                    if (bVar != null) {
                        bVar.a(this.f63572a, c2);
                        x xVar = x.f47997a;
                    }
                }
            }
        }
    }
}
