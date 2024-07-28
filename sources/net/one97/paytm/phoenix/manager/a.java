package net.one97.paytm.phoenix.manager;

import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebulacore.web.H5ScriptLoader;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.util.j;
import net.one97.paytm.phoenix.viewmodel.PhoenixViewModel;
import org.json.JSONObject;

public final class a implements net.one97.paytm.phoenix.api.b {

    /* renamed from: a  reason: collision with root package name */
    public PhoenixViewModel f59597a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineScope f59598b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    public final boolean a(H5Event h5Event, String str, Object obj) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(str, "key");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        return d(h5Event, jSONObject);
    }

    public final boolean a(H5Event h5Event, JSONObject jSONObject) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(jSONObject, "result");
        return d(h5Event, jSONObject);
    }

    public final boolean b(H5Event h5Event, JSONObject jSONObject) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(jSONObject, "result");
        h5Event.setKeepCallback(true);
        return d(h5Event, jSONObject);
    }

    public final boolean a(H5Event h5Event, int i2, String str) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, str);
        jSONObject.put("error", i2);
        return d(h5Event, jSONObject);
    }

    private final boolean d(H5Event h5Event, JSONObject jSONObject) {
        h5Event.setMsgType(com.alipay.mobile.h5container.api.H5Event.TYPE_CALL_BACK);
        return c(h5Event, jSONObject);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0110 A[Catch:{ Exception -> 0x011d }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0116 A[Catch:{ Exception -> 0x011d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(net.one97.paytm.phoenix.api.H5Event r14, org.json.JSONObject r15) {
        /*
            r13 = this;
            java.lang.String r0 = "fail"
            java.lang.String r1 = "H5BridgeContextImpl"
            java.lang.String r2 = "PhoenixFetchValuesForKeysPlugin"
            java.lang.String r3 = "event"
            kotlin.g.b.k.c(r14, r3)
            java.lang.String r3 = "result"
            kotlin.g.b.k.c(r15, r3)
            r3 = 1
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x011d }
            r5.<init>()     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = "bridgeName"
            java.lang.String r7 = r14.getBridgeName()     // Catch:{ Exception -> 0x011d }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = "responseData"
            r5.put(r6, r15)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = "msgType"
            java.lang.String r7 = r14.getMsgType()     // Catch:{ Exception -> 0x011d }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = "keepCallback"
            boolean r7 = r14.getKeepCallback()     // Catch:{ Exception -> 0x011d }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = "callbackId"
            java.lang.String r7 = r14.getCallbackId()     // Catch:{ Exception -> 0x011d }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = "JSBridge.invokeJS("
            java.lang.String r7 = ");"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            r8.<init>()     // Catch:{ Exception -> 0x011d }
            r8.append(r6)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = r5.toString()     // Catch:{ Exception -> 0x011d }
            r8.append(r6)     // Catch:{ Exception -> 0x011d }
            r8.append(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j r7 = net.one97.paytm.phoenix.util.j.f59646a     // Catch:{ Exception -> 0x011d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            java.lang.String r8 = "bridgeName:"
            r7.<init>(r8)     // Catch:{ Exception -> 0x011d }
            java.lang.String r8 = r14.getBridgeName()     // Catch:{ Exception -> 0x011d }
            r7.append(r8)     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j.b(r2, r7)     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j r7 = net.one97.paytm.phoenix.util.j.f59646a     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = "responseData:"
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x011d }
            java.lang.String r15 = r7.concat(r15)     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j.b(r2, r15)     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j r15 = net.one97.paytm.phoenix.util.j.f59646a     // Catch:{ Exception -> 0x011d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = "msgType:"
            r15.<init>(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = r14.getMsgType()     // Catch:{ Exception -> 0x011d }
            r15.append(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j.b(r2, r15)     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j r15 = net.one97.paytm.phoenix.util.j.f59646a     // Catch:{ Exception -> 0x011d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = "keepCallback:"
            r15.<init>(r7)     // Catch:{ Exception -> 0x011d }
            boolean r7 = r14.getKeepCallback()     // Catch:{ Exception -> 0x011d }
            r15.append(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j.b(r2, r15)     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j r15 = net.one97.paytm.phoenix.util.j.f59646a     // Catch:{ Exception -> 0x011d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = "callbackId:"
            r15.<init>(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = r14.getCallbackId()     // Catch:{ Exception -> 0x011d }
            r15.append(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j.b(r2, r15)     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j r15 = net.one97.paytm.phoenix.util.j.f59646a     // Catch:{ Exception -> 0x011d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = "jsonObject to web:"
            r15.<init>(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r7 = r5.toString()     // Catch:{ Exception -> 0x011d }
            r15.append(r7)     // Catch:{ Exception -> 0x011d }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.util.j.b(r2, r15)     // Catch:{ Exception -> 0x011d }
            net.one97.paytm.phoenix.viewmodel.PhoenixViewModel r15 = r13.f59597a     // Catch:{ Exception -> 0x011d }
            if (r15 == 0) goto L_0x00f3
            kotlinx.coroutines.CoroutineScope r7 = r13.f59598b     // Catch:{ Exception -> 0x011d }
            r8 = 0
            r9 = 0
            net.one97.paytm.phoenix.manager.a$b r15 = new net.one97.paytm.phoenix.manager.a$b     // Catch:{ Exception -> 0x011d }
            r2 = 0
            r15.<init>(r13, r6, r2)     // Catch:{ Exception -> 0x011d }
            r10 = r15
            kotlin.g.a.m r10 = (kotlin.g.a.m) r10     // Catch:{ Exception -> 0x011d }
            r11 = 3
            r12 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x011d }
            goto L_0x00fa
        L_0x00f3:
            net.one97.paytm.phoenix.util.j r15 = net.one97.paytm.phoenix.util.j.f59646a     // Catch:{ Exception -> 0x011d }
            java.lang.String r15 = "sendToWeb() error: viewModel is not initialized"
            net.one97.paytm.phoenix.util.j.c(r1, r15)     // Catch:{ Exception -> 0x011d }
        L_0x00fa:
            java.lang.String r15 = "error"
            java.lang.String r15 = r5.optString(r15)     // Catch:{ Exception -> 0x011d }
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ Exception -> 0x011d }
            if (r15 == 0) goto L_0x010d
            int r15 = r15.length()     // Catch:{ Exception -> 0x011d }
            if (r15 != 0) goto L_0x010b
            goto L_0x010d
        L_0x010b:
            r15 = 0
            goto L_0x010e
        L_0x010d:
            r15 = 1
        L_0x010e:
            if (r15 == 0) goto L_0x0116
            java.lang.String r15 = "success"
            r14.setResultAttribute(r15)     // Catch:{ Exception -> 0x011d }
            goto L_0x0119
        L_0x0116:
            r14.setResultAttribute(r0)     // Catch:{ Exception -> 0x011d }
        L_0x0119:
            r14.stopTrace()     // Catch:{ Exception -> 0x011d }
            goto L_0x012e
        L_0x011d:
            r15 = move-exception
            net.one97.paytm.phoenix.util.j r2 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.Throwable r15 = (java.lang.Throwable) r15
            java.lang.String r2 = "sendToWeb()"
            net.one97.paytm.phoenix.util.j.a(r1, r2, r15)
            r14.setResultAttribute(r0)
            r14.stopTrace()
            r3 = 0
        L_0x012e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.manager.a.c(net.one97.paytm.phoenix.api.H5Event, org.json.JSONObject):boolean");
    }

    public final boolean a(JSONObject jSONObject) {
        k.c(jSONObject, "params");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bridgeName", H5ScriptLoader.startupParams);
            jSONObject2.put("responseData", jSONObject);
            jSONObject2.put(H5Param.MSG_TYPE, "internal");
            String str = "JSBridge.invokeJS(" + jSONObject2.toString() + ");";
            if (this.f59597a != null) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59598b, (f) null, (CoroutineStart) null, new C1151a(this, str, (d) null), 3, (Object) null);
            } else {
                j jVar = j.f59646a;
                j.c("H5BridgeContextImpl", "sendToWeb() error: viewModel is not initialized");
            }
            return true;
        } catch (Exception e2) {
            j jVar2 = j.f59646a;
            j.a("H5BridgeContextImpl", "loadStartupParams()", e2);
            return false;
        }
    }

    @kotlin.d.b.a.f(b = "H5BridgeContextImpl.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.manager.H5BridgeContextImpl$loadStartupParams$1")
    /* renamed from: net.one97.paytm.phoenix.manager.a$a  reason: collision with other inner class name */
    static final class C1151a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $javascript;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1151a(a aVar, String str, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$javascript = str;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            C1151a aVar = new C1151a(this.this$0, this.$javascript, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C1151a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                PhoenixViewModel phoenixViewModel = this.this$0.f59597a;
                if (phoenixViewModel == null) {
                    k.a();
                }
                phoenixViewModel.loadJavascript("javascript:(function(){if(typeof JSBridge === 'object'){" + this.$javascript + "}})();");
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "H5BridgeContextImpl.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.manager.H5BridgeContextImpl$sendToWeb$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $javascript;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$javascript = str;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$javascript, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                PhoenixViewModel phoenixViewModel = this.this$0.f59597a;
                if (phoenixViewModel == null) {
                    k.a();
                }
                phoenixViewModel.loadJavascript("javascript:(function(){if(typeof JSBridge === 'object'){" + this.$javascript + "}})();");
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
