package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.PhoenixAppShortCutProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;

public final class u extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineScope f59552a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineExceptionHandler f59553b = new a(CoroutineExceptionHandler.Key);

    public interface b {
        void a(Bitmap bitmap);
    }

    public u() {
        super("createAppShortcut");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r22, net.one97.paytm.phoenix.api.b r23) {
        /*
            r21 = this;
            r12 = r21
            r13 = r22
            java.lang.String r14 = "Not supported"
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "bridgeContext"
            r1 = r23
            kotlin.g.b.k.c(r1, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r22, (net.one97.paytm.phoenix.api.b) r23)
            boolean r0 = r21.a((net.one97.paytm.phoenix.api.H5Event) r22)
            if (r0 == 0) goto L_0x0179
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixAppShortCutProvider> r1 = net.one97.paytm.phoenix.provider.PhoenixAppShortCutProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "PhoenixAppShortCutProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r0 = r0.a(r1)
            net.one97.paytm.phoenix.provider.PhoenixAppShortCutProvider r0 = (net.one97.paytm.phoenix.provider.PhoenixAppShortCutProvider) r0
            r15 = 0
            if (r0 != 0) goto L_0x003d
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r1 = "No implementation found for 'AppShortCutProvider'"
            r12.a((net.one97.paytm.phoenix.api.H5Event) r13, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r1)
            return r15
        L_0x003d:
            android.app.Activity r0 = r22.getActivity()
            r11 = 0
            if (r0 == 0) goto L_0x0063
            android.app.Activity r0 = r22.getActivity()
            if (r0 != 0) goto L_0x004d
            kotlin.g.b.k.a()
        L_0x004d:
            boolean r0 = r0 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r0 == 0) goto L_0x0063
            android.app.Activity r0 = r22.getActivity()
            if (r0 == 0) goto L_0x005b
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0
            r3 = r0
            goto L_0x0064
        L_0x005b:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r0.<init>(r1)
            throw r0
        L_0x0063:
            r3 = r11
        L_0x0064:
            if (r3 != 0) goto L_0x0067
            return r15
        L_0x0067:
            org.json.JSONObject r0 = r22.getParams()
            if (r0 == 0) goto L_0x0075
            java.lang.String r1 = "uniqueId"
            java.lang.String r1 = r0.optString(r1)
            r8 = r1
            goto L_0x0076
        L_0x0075:
            r8 = r11
        L_0x0076:
            if (r0 == 0) goto L_0x0080
            java.lang.String r1 = "shortLabel"
            java.lang.String r1 = r0.optString(r1)
            r9 = r1
            goto L_0x0081
        L_0x0080:
            r9 = r11
        L_0x0081:
            if (r0 == 0) goto L_0x008b
            java.lang.String r1 = "longLabel"
            java.lang.String r1 = r0.optString(r1)
            r10 = r1
            goto L_0x008c
        L_0x008b:
            r10 = r11
        L_0x008c:
            if (r0 == 0) goto L_0x0096
            java.lang.String r1 = "deeplink"
            java.lang.String r1 = r0.optString(r1)
            r7 = r1
            goto L_0x0097
        L_0x0096:
            r7 = r11
        L_0x0097:
            if (r0 == 0) goto L_0x00a0
            java.lang.String r1 = "disabledMessage"
            java.lang.Object r1 = r0.opt(r1)
            goto L_0x00a1
        L_0x00a0:
            r1 = r11
        L_0x00a1:
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x00a6
            r1 = r11
        L_0x00a6:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x00ac
            java.lang.String r1 = "disabled"
        L_0x00ac:
            r16 = r1
            if (r0 == 0) goto L_0x00b7
            java.lang.String r1 = "image"
            java.lang.String r0 = r0.optString(r1)
            goto L_0x00b8
        L_0x00b7:
            r0 = r11
        L_0x00b8:
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0172
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0172
            r1 = r9
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0172
            r1 = r10
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0172
            r1 = r16
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0172
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0172
        L_0x00f1:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0168 }
            r2 = 26
            if (r1 < r2) goto L_0x0162
            java.lang.Class<android.content.pm.ShortcutManager> r1 = android.content.pm.ShortcutManager.class
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch:{ Exception -> 0x0168 }
            r2 = r1
            android.content.pm.ShortcutManager r2 = (android.content.pm.ShortcutManager) r2     // Catch:{ Exception -> 0x0168 }
            if (r2 == 0) goto L_0x0179
            net.one97.paytm.phoenix.d.u$c r17 = new net.one97.paytm.phoenix.d.u$c     // Catch:{ Exception -> 0x0168 }
            r1 = r17
            r4 = r21
            r5 = r0
            r6 = r22
            r11 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0168 }
            r6 = r17
            net.one97.paytm.phoenix.d.u$b r6 = (net.one97.paytm.phoenix.d.u.b) r6     // Catch:{ Exception -> 0x0168 }
            if (r0 == 0) goto L_0x0179
            java.lang.String r1 = "http://"
            boolean r1 = kotlin.m.p.b(r0, r1, r15)     // Catch:{ Exception -> 0x0168 }
            if (r1 != 0) goto L_0x0139
            java.lang.String r1 = "https://"
            boolean r1 = kotlin.m.p.b(r0, r1, r15)     // Catch:{ Exception -> 0x0168 }
            if (r1 == 0) goto L_0x0127
            goto L_0x0139
        L_0x0127:
            byte[] r0 = android.util.Base64.decode(r0, r15)     // Catch:{ Exception -> 0x0168 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0168 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r15, r1)     // Catch:{ Exception -> 0x0168 }
            java.lang.String r1 = "BitmapFactory.decodeByte…ytes, 0, imageBytes.size)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0168 }
            r6.a(r0)     // Catch:{ Exception -> 0x0168 }
            goto L_0x0179
        L_0x0139:
            kotlin.g.b.x$e r3 = new kotlin.g.b.x$e     // Catch:{ Exception -> 0x0168 }
            r3.<init>()     // Catch:{ Exception -> 0x0168 }
            r1 = 0
            r3.element = r1     // Catch:{ Exception -> 0x0168 }
            kotlinx.coroutines.CoroutineScope r15 = r12.f59552a     // Catch:{ Exception -> 0x0168 }
            kotlinx.coroutines.CoroutineExceptionHandler r1 = r12.f59553b     // Catch:{ Exception -> 0x0168 }
            r16 = r1
            kotlin.d.f r16 = (kotlin.d.f) r16     // Catch:{ Exception -> 0x0168 }
            r17 = 0
            net.one97.paytm.phoenix.d.u$d r8 = new net.one97.paytm.phoenix.d.u$d     // Catch:{ Exception -> 0x0168 }
            r4 = 0
            r1 = r8
            r2 = r0
            r5 = r21
            r7 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0168 }
            r18 = r8
            kotlin.g.a.m r18 = (kotlin.g.a.m) r18     // Catch:{ Exception -> 0x0168 }
            r19 = 2
            r20 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x0168 }
            goto L_0x0179
        L_0x0162:
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.FORBIDDEN     // Catch:{ Exception -> 0x0168 }
            r12.a((net.one97.paytm.phoenix.api.H5Event) r13, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r14)     // Catch:{ Exception -> 0x0168 }
            goto L_0x0179
        L_0x0168:
            r0 = move-exception
            r0.printStackTrace()
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            r12.a((net.one97.paytm.phoenix.api.H5Event) r13, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r14)
            goto L_0x0179
        L_0x0172:
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r1 = "Message empty!"
            r12.a((net.one97.paytm.phoenix.api.H5Event) r13, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r1)
        L_0x0179:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.u.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(f fVar, Throwable th) {
            k.c(fVar, "context");
            k.c(th, "exception");
            j jVar = j.f59646a;
            j.b("PhoenixAppShortcutPlugin", th + " handled !");
        }
    }

    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShortcutManager f59554a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59555b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ u f59556c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f59557d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f59558e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f59559f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f59560g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f59561h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f59562i;
        final /* synthetic */ String j;

        c(ShortcutManager shortcutManager, PhoenixActivity phoenixActivity, u uVar, String str, H5Event h5Event, String str2, String str3, String str4, String str5, String str6) {
            this.f59554a = shortcutManager;
            this.f59555b = phoenixActivity;
            this.f59556c = uVar;
            this.f59557d = str;
            this.f59558e = h5Event;
            this.f59559f = str2;
            this.f59560g = str3;
            this.f59561h = str4;
            this.f59562i = str5;
            this.j = str6;
        }

        public final void a(Bitmap bitmap) {
            Intent intent;
            CharSequence charSequence;
            CharSequence charSequence2;
            CharSequence charSequence3;
            if (bitmap == null) {
                this.f59556c.a(this.f59558e, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "bitmap downloading failed");
                return;
            }
            ShortcutManager shortcutManager = this.f59554a;
            Activity activity = this.f59555b;
            String str = this.f59559f;
            String str2 = this.f59560g;
            String str3 = this.f59561h;
            String str4 = this.f59562i;
            String str5 = this.j;
            List arrayList = new ArrayList();
            net.one97.paytm.phoenix.api.f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
            String name = PhoenixAppShortCutProvider.class.getName();
            k.a((Object) name, "PhoenixAppShortCutProvider::class.java.name");
            PhoenixAppShortCutProvider phoenixAppShortCutProvider = (PhoenixAppShortCutProvider) b2.a(name);
            if (phoenixAppShortCutProvider != null) {
                Context context = activity;
                intent = phoenixAppShortCutProvider.getIntentForMiniAppDeeplink(str, context);
                ArrayList<ShortcutInfo> provideAlreadyExistingAppShortcuts = phoenixAppShortCutProvider.provideAlreadyExistingAppShortcuts(context);
                if (provideAlreadyExistingAppShortcuts != null) {
                    for (ShortcutInfo add : provideAlreadyExistingAppShortcuts) {
                        arrayList.add(add);
                    }
                }
            } else {
                intent = null;
            }
            ShortcutInfo.Builder builder = new ShortcutInfo.Builder(activity, str2);
            if (str3 != null) {
                charSequence = str3;
            } else {
                charSequence = "";
            }
            ShortcutInfo.Builder shortLabel = builder.setShortLabel(charSequence);
            if (str4 != null) {
                charSequence2 = str4;
            } else {
                charSequence2 = "";
            }
            ShortcutInfo.Builder longLabel = shortLabel.setLongLabel(charSequence2);
            if (str5 != null) {
                charSequence3 = str5;
            } else {
                charSequence3 = "";
            }
            ShortcutInfo.Builder icon = longLabel.setDisabledMessage(charSequence3).setIcon(Icon.createWithBitmap(bitmap));
            if (intent == null) {
                k.a();
            }
            ShortcutInfo build = icon.setIntent(intent).build();
            k.a((Object) build, "ShortcutInfo.Builder(act…\n                .build()");
            arrayList.add(build);
            shortcutManager.setDynamicShortcuts(arrayList);
            u uVar = this.f59556c;
            H5Event h5Event = this.f59558e;
            ShortcutManager shortcutManager2 = this.f59554a;
            Activity activity2 = this.f59555b;
            String str6 = this.f59560g;
            if (shortcutManager2.isRequestPinShortcutSupported()) {
                Context context2 = activity2;
                ShortcutInfo build2 = new ShortcutInfo.Builder(context2, str6).build();
                k.a((Object) build2, "ShortcutInfo.Builder(activity, uniqueId).build()");
                PendingIntent broadcast = PendingIntent.getBroadcast(context2, 0, shortcutManager2.createShortcutResultIntent(build2), 0);
                k.a((Object) broadcast, "successCallback");
                shortcutManager2.requestPinShortcut(build2, broadcast.getIntentSender());
                uVar.a("success", (Object) Boolean.TRUE);
                net.one97.paytm.phoenix.core.a.a(uVar, h5Event, (Object) null, false, 6);
            }
        }
    }

    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ x.e $bitmap;
        final /* synthetic */ String $image$inlined;
        final /* synthetic */ String $it;
        final /* synthetic */ b $listener$inlined;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ u this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, x.e eVar, kotlin.d.d dVar, u uVar, b bVar, String str2) {
            super(2, dVar);
            this.$it = str;
            this.$bitmap = eVar;
            this.this$0 = uVar;
            this.$listener$inlined = bVar;
            this.$image$inlined = str2;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.$it, this.$bitmap, dVar, this.this$0, this.$listener$inlined, this.$image$inlined);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                this.L$0 = this.p$;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ d this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 
                    }
