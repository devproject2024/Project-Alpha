package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.api.H5Event;
import org.json.JSONObject;

public final class p extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    final String f19842a = "orderId";

    /* renamed from: b  reason: collision with root package name */
    final String f19843b = "pgTransactionId";

    /* renamed from: c  reason: collision with root package name */
    final String f19844c = "upiTransactionId";

    /* renamed from: d  reason: collision with root package name */
    final String f19845d = "walletTransactionId";

    /* renamed from: e  reason: collision with root package name */
    final String f19846e = "verticalId";

    /* renamed from: f  reason: collision with root package name */
    final String f19847f = "transactionType";

    /* renamed from: g  reason: collision with root package name */
    final String f19848g = "categoryId";

    /* renamed from: h  reason: collision with root package name */
    final String f19849h = "merchantCategory";

    /* renamed from: i  reason: collision with root package name */
    final String f19850i = "eventType";
    final String m = "POSTTRANSACTION";
    IStaticWidget n;
    H5Event o;
    final c p = new c(this);
    private final String q = "eventId";
    private final String r = "eventValue";
    private final String s = "storeFrontUrl";
    private final CoroutineExceptionHandler t = new a(CoroutineExceptionHandler.Key);

    public p() {
        super("paytmOpenScratchCard");
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(f fVar, Throwable th) {
            System.out.println("Caught ".concat(String.valueOf(th)));
        }
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.o = h5Event;
        Activity activity = h5Event.getActivity();
        if (activity != null) {
            JSONObject params = h5Event.getParams();
            String str = null;
            String string = (params == null || !params.has(this.s)) ? null : params.getString(this.s);
            CharSequence charSequence = string;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                SFInterface.INSTANCE.getStoreFrontReponse(string, new HashMap(), a.c.CASHBACK, new b(this, activity));
                return true;
            }
            if (params != null) {
                str = params.getString(this.f19850i);
            }
            CharSequence charSequence2 = str;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z && (activity instanceof FragmentActivity)) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.t)), (f) null, (CoroutineStart) null, new d(activity, params, (kotlin.d.d) null, this, h5Event), 3, (Object) null);
            }
        }
        return true;
    }

    public static final class c implements net.one97.paytm.cashback.posttxn.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f19853a;

        public final void onAnimationEnd(String str) {
            k.c(str, "identifier");
        }

        c(p pVar) {
            this.f19853a = pVar;
        }

        public final void a(String str, boolean z) {
            IStaticWidget iStaticWidget;
            if (!(!z || str == null || (iStaticWidget = this.f19853a.n) == null)) {
                iStaticWidget.AnimateView(str);
            }
            this.f19853a.a("success", (Object) Boolean.valueOf(z));
            H5Event h5Event = this.f19853a.o;
            if (h5Event != null) {
                net.one97.paytm.phoenix.core.a.a(this.f19853a, h5Event, (Object) null, false, 6);
            }
        }

        public final Point getFloatingWidgetPos(String str) {
            k.c(str, "identifier");
            IStaticWidget iStaticWidget = this.f19853a.n;
            if (iStaticWidget != null) {
                return iStaticWidget.getViewPoint(str);
            }
            return null;
        }
    }

    public static final class b implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f19851a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19852b;

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        b(p pVar, Activity activity) {
            this.f19851a = pVar;
            this.f19852b = activity;
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            View decorView;
            if (sanitizedResponseModel != null) {
                p pVar = this.f19851a;
                LinkedHashMap<Integer, IWidgetProvider> sfWidgets = sanitizedResponseModel.getSfWidgets();
                Activity activity = this.f19852b;
                if (activity instanceof FragmentActivity) {
                    IWidgetProvider iWidgetProvider = sfWidgets.get(104);
                    Resources resources = null;
                    SFWidget widget = iWidgetProvider != null ? iWidgetProvider.getWidget((FragmentActivity) activity, (IGAHandlerListener) null) : null;
                    if (widget instanceof IStaticWidget) {
                        IStaticWidget iStaticWidget = (IStaticWidget) widget;
                        pVar.n = iStaticWidget;
                        View view = iStaticWidget.getView();
                        k.a((Object) view, "widget.view");
                        Window window = activity.getWindow();
                        ViewGroup viewGroup = (window == null || (decorView = window.getDecorView()) == null) ? null : (ViewGroup) decorView.findViewById(16908290);
                        if (viewGroup != null) {
                            if (activity != null) {
                                resources = activity.getResources();
                            }
                            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.dimen_30dp);
                            if (viewGroup instanceof ConstraintLayout) {
                                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                                layoutParams.k = 0;
                                layoutParams.f2490h = 0;
                                layoutParams.f2486d = 0;
                                layoutParams.f2489g = 0;
                                layoutParams.bottomMargin = dimensionPixelOffset;
                                viewGroup.addView(view, layoutParams);
                            } else if (viewGroup instanceof RelativeLayout) {
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams2.addRule(14);
                                layoutParams2.setMargins(0, 0, 0, dimensionPixelOffset);
                                viewGroup.addView(view, layoutParams2);
                            } else if (viewGroup instanceof FrameLayout) {
                                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                                layoutParams3.gravity = 81;
                                layoutParams3.setMargins(0, 0, 0, dimensionPixelOffset);
                                viewGroup.addView(view, layoutParams3);
                            } else if (viewGroup instanceof LinearLayout) {
                                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                                layoutParams4.gravity = 1;
                                layoutParams4.setMargins(0, 0, 0, dimensionPixelOffset);
                                viewGroup.addView(view, layoutParams4);
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                    }
                }
            }
        }
    }

    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ H5Event $event$inlined;
        final /* synthetic */ JSONObject $params;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ p this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Activity activity, JSONObject jSONObject, kotlin.d.d dVar, p pVar, H5Event h5Event) {
            super(2, dVar);
            this.$activity = activity;
            this.$params = jSONObject;
            this.this$0 = pVar;
            this.$event$inlined = h5Event;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.$activity, this.$params, dVar, this.this$0, this.$event$inlined);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0160  */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x017e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r0 = r7.label
                if (r0 != 0) goto L_0x019a
                kotlin.ResultKt.a((java.lang.Object) r8)
                net.one97.paytm.phoenix.d.p r8 = r7.this$0
                android.app.Activity r0 = r7.$activity
                androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
                org.json.JSONObject r1 = r7.$params
                net.one97.paytm.cashback.posttxn.e r2 = net.one97.paytm.cashback.posttxn.c.a()
                r3 = 1
                if (r1 == 0) goto L_0x0025
                java.lang.String r4 = "data"
                boolean r5 = r1.has(r4)
                if (r5 != r3) goto L_0x0025
                org.json.JSONObject r4 = r1.getJSONObject(r4)
                goto L_0x0026
            L_0x0025:
                r4 = 0
            L_0x0026:
                if (r4 == 0) goto L_0x018a
                java.lang.String r5 = r8.f19850i
                boolean r5 = r4.has(r5)
                if (r5 != r3) goto L_0x018a
                if (r1 == 0) goto L_0x018a
                java.lang.String r5 = r8.f19850i
                java.lang.String r1 = r1.getString(r5)
                if (r1 == 0) goto L_0x018a
                java.lang.String r5 = r8.m
                boolean r1 = r1.equals(r5)
                if (r1 != r3) goto L_0x018a
                net.one97.paytm.cashback.posttxn.f$a r0 = new net.one97.paytm.cashback.posttxn.f$a
                r0.<init>()
                java.lang.String r1 = r8.f19842a
                boolean r1 = r4.has(r1)
                r5 = 0
                if (r1 == 0) goto L_0x0070
                java.lang.String r1 = r8.f19842a
                java.lang.String r1 = r4.getString(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0063
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0061
                goto L_0x0063
            L_0x0061:
                r1 = 0
                goto L_0x0064
            L_0x0063:
                r1 = 1
            L_0x0064:
                if (r1 != 0) goto L_0x0070
                java.lang.String r1 = r8.f19842a
                java.lang.String r1 = r4.getString(r1)
                r0.f49546b = r1
                r1 = 1
                goto L_0x0071
            L_0x0070:
                r1 = 0
            L_0x0071:
                java.lang.String r6 = r8.f19843b
                boolean r6 = r4.has(r6)
                if (r6 == 0) goto L_0x0098
                java.lang.String r6 = r8.f19843b
                java.lang.String r6 = r4.getString(r6)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x008c
                int r6 = r6.length()
                if (r6 != 0) goto L_0x008a
                goto L_0x008c
            L_0x008a:
                r6 = 0
                goto L_0x008d
            L_0x008c:
                r6 = 1
            L_0x008d:
                if (r6 != 0) goto L_0x0098
                java.lang.String r1 = r8.f19843b
                java.lang.String r1 = r4.getString(r1)
                r0.f49545a = r1
                r1 = 1
            L_0x0098:
                java.lang.String r6 = r8.f19844c
                boolean r6 = r4.has(r6)
                if (r6 == 0) goto L_0x00bf
                java.lang.String r6 = r8.f19844c
                java.lang.String r6 = r4.getString(r6)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x00b3
                int r6 = r6.length()
                if (r6 != 0) goto L_0x00b1
                goto L_0x00b3
            L_0x00b1:
                r6 = 0
                goto L_0x00b4
            L_0x00b3:
                r6 = 1
            L_0x00b4:
                if (r6 != 0) goto L_0x00bf
                java.lang.String r1 = r8.f19844c
                java.lang.String r1 = r4.getString(r1)
                r0.f49547c = r1
                r1 = 1
            L_0x00bf:
                java.lang.String r6 = r8.f19845d
                boolean r6 = r4.has(r6)
                if (r6 == 0) goto L_0x00e6
                java.lang.String r6 = r8.f19845d
                java.lang.String r6 = r4.getString(r6)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x00da
                int r6 = r6.length()
                if (r6 != 0) goto L_0x00d8
                goto L_0x00da
            L_0x00d8:
                r6 = 0
                goto L_0x00db
            L_0x00da:
                r6 = 1
            L_0x00db:
                if (r6 != 0) goto L_0x00e6
                java.lang.String r1 = r8.f19845d
                java.lang.String r1 = r4.getString(r1)
                r0.f49548d = r1
                r1 = 1
            L_0x00e6:
                java.lang.String r6 = r8.f19846e
                boolean r6 = r4.has(r6)
                if (r6 == 0) goto L_0x010c
                java.lang.String r6 = r8.f19846e
                java.lang.String r6 = r4.getString(r6)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x0101
                int r6 = r6.length()
                if (r6 != 0) goto L_0x00ff
                goto L_0x0101
            L_0x00ff:
                r6 = 0
                goto L_0x0102
            L_0x0101:
                r6 = 1
            L_0x0102:
                if (r6 != 0) goto L_0x010c
                java.lang.String r6 = r8.f19846e
                java.lang.String r6 = r4.getString(r6)
                r0.f49550f = r6
            L_0x010c:
                java.lang.String r6 = r8.f19848g
                boolean r6 = r4.has(r6)
                if (r6 == 0) goto L_0x0132
                java.lang.String r6 = r8.f19848g
                java.lang.String r6 = r4.getString(r6)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x0127
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0125
                goto L_0x0127
            L_0x0125:
                r6 = 0
                goto L_0x0128
            L_0x0127:
                r6 = 1
            L_0x0128:
                if (r6 != 0) goto L_0x0132
                java.lang.String r6 = r8.f19848g
                java.lang.String r6 = r4.getString(r6)
                r0.f49551g = r6
            L_0x0132:
                java.lang.String r6 = r8.f19849h
                boolean r6 = r4.has(r6)
                if (r6 == 0) goto L_0x0158
                java.lang.String r6 = r8.f19849h
                java.lang.String r6 = r4.getString(r6)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x014d
                int r6 = r6.length()
                if (r6 != 0) goto L_0x014b
                goto L_0x014d
            L_0x014b:
                r6 = 0
                goto L_0x014e
            L_0x014d:
                r6 = 1
            L_0x014e:
                if (r6 != 0) goto L_0x0158
                java.lang.String r6 = r8.f19849h
                java.lang.String r6 = r4.getString(r6)
                r0.f49552h = r6
            L_0x0158:
                java.lang.String r6 = r8.f19847f
                boolean r6 = r4.has(r6)
                if (r6 == 0) goto L_0x017c
                java.lang.String r6 = r8.f19847f
                java.lang.String r6 = r4.getString(r6)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x0172
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0171
                goto L_0x0172
            L_0x0171:
                r3 = 0
            L_0x0172:
                if (r3 != 0) goto L_0x017c
                java.lang.String r3 = r8.f19847f
                java.lang.String r3 = r4.getString(r3)
                r0.f49549e = r3
            L_0x017c:
                if (r1 == 0) goto L_0x0197
                net.one97.paytm.cashback.posttxn.f r0 = r0.a()
                net.one97.paytm.phoenix.d.p$c r8 = r8.p
                net.one97.paytm.cashback.posttxn.a r8 = (net.one97.paytm.cashback.posttxn.a) r8
                r2.a((net.one97.paytm.cashback.posttxn.f) r0, (net.one97.paytm.cashback.posttxn.a) r8)
                goto L_0x0197
            L_0x018a:
                if (r4 == 0) goto L_0x0197
                net.one97.paytm.phoenix.d.p$c r8 = r8.p
                net.one97.paytm.cashback.posttxn.a r8 = (net.one97.paytm.cashback.posttxn.a) r8
                java.lang.String r1 = r4.toString()
                r2.a(r0, r8, r1)
            L_0x0197:
                kotlin.x r8 = kotlin.x.f47997a
                return r8
            L_0x019a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.p.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
