package net.one97.paytm.deeplink;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Event;
import com.google.firebase.messaging.RemoteMessage;
import com.paytm.utility.q;
import java.lang.reflect.Method;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.upi.util.UpiConstants;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f50341a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static b f50342b;

    /* renamed from: c  reason: collision with root package name */
    private static BroadcastReceiver f50343c;

    public interface b {
        void b(Context context);

        boolean d();

        void e();

        void f();

        y<Integer> g();
    }

    private f() {
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f50344a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final String f50345b = f50345b;

        /* renamed from: c  reason: collision with root package name */
        private static final String f50346c = f50346c;

        private a() {
        }

        public static String a() {
            return f50345b;
        }

        public static String b() {
            return f50346c;
        }
    }

    public static b a() {
        return f50342b;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return b(deepLinkData);
    }

    public static String b() {
        return net.one97.paytm.payments.d.a.a() + "chat?featuretype=handle_fcm";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e A[Catch:{ Exception -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077 A[Catch:{ Exception -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r18, net.one97.paytm.deeplink.DeepLinkData r19) {
        /*
            r1 = r18
            r2 = r19
            java.lang.String r0 = "source"
            java.lang.String r3 = "phoneName"
            java.lang.String r4 = "defaultMessage"
            java.lang.String r5 = "phone"
            java.lang.String r6 = "payment_result"
            java.lang.String r7 = "fromFCM"
            java.lang.String r8 = "groupChannelUrl"
            java.lang.String r9 = ""
            java.lang.String r10 = "context"
            kotlin.g.b.k.c(r1, r10)
            java.lang.String r10 = "deepLinkData"
            kotlin.g.b.k.c(r2, r10)
            android.content.Intent r10 = new android.content.Intent
            r10.<init>()
            net.one97.paytm.deeplink.f$b r11 = f50342b
            if (r11 == 0) goto L_0x0038
            if (r11 != 0) goto L_0x002c
            kotlin.g.b.k.a()
        L_0x002c:
            boolean r11 = r11.d()
            if (r11 == 0) goto L_0x0038
            java.lang.String r11 = "com.paytm.android.chat.activity.APCChatActivity"
            r10.setClassName(r1, r11)
            goto L_0x0052
        L_0x0038:
            net.one97.paytm.deeplink.f$a r11 = net.one97.paytm.deeplink.f.a.f50344a
            java.lang.String r11 = net.one97.paytm.deeplink.f.a.a()
            r10.setClassName(r1, r11)
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            java.lang.String r12 = "launch_page"
            java.lang.String r13 = "channel"
            r11.putString(r12, r13)
            java.lang.String r12 = net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity.EXTRA_TARGET_ACTIVITY_ARGS
            r10.putExtra(r12, r11)
        L_0x0052:
            android.os.Bundle r11 = r2.f50290h
            if (r11 == 0) goto L_0x0067
            android.os.Bundle r11 = r2.f50290h
            java.lang.String r12 = "PAYMENT_DATA"
            if (r11 == 0) goto L_0x0061
            java.io.Serializable r11 = r11.getSerializable(r12)
            goto L_0x0062
        L_0x0061:
            r11 = 0
        L_0x0062:
            if (r11 == 0) goto L_0x0067
            r10.putExtra(r12, r11)
        L_0x0067:
            r11 = 1
            java.lang.String r13 = "money_transfer"
            java.lang.String r14 = r2.f50288f     // Catch:{ Exception -> 0x0149 }
            if (r14 != 0) goto L_0x0071
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0149 }
        L_0x0071:
            boolean r13 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r14, (boolean) r11)     // Catch:{ Exception -> 0x0149 }
            if (r13 == 0) goto L_0x009f
            java.lang.String r0 = r2.f50283a     // Catch:{ Exception -> 0x0149 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0149 }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x0149 }
            android.net.Uri r0 = r0.build()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r3 = r0.getQueryParameter(r6)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r0.getQueryParameter(r8)     // Catch:{ Exception -> 0x0149 }
            if (r0 != 0) goto L_0x0092
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0149 }
        L_0x0092:
            if (r3 != 0) goto L_0x0097
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0156 }
        L_0x0097:
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0156 }
            r12 = r3
            r3 = -1
            goto L_0x0158
        L_0x009f:
            java.lang.String r13 = "click_notify"
            java.lang.String r14 = r2.f50288f     // Catch:{ Exception -> 0x0149 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0149 }
            if (r13 == 0) goto L_0x00d3
            java.lang.String r0 = r2.f50283a     // Catch:{ Exception -> 0x0149 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0149 }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x0149 }
            android.net.Uri r0 = r0.build()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r3 = r0.getQueryParameter(r8)     // Catch:{ Exception -> 0x0149 }
            if (r3 != 0) goto L_0x00c0
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0149 }
        L_0x00c0:
            java.lang.String r0 = r0.getQueryParameter(r7)     // Catch:{ Exception -> 0x00cd }
            if (r0 != 0) goto L_0x00c9
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00cd }
        L_0x00c9:
            r9 = r0
            r0 = r3
            goto L_0x0156
        L_0x00cd:
            r0 = move-exception
            r17 = r9
            r9 = r3
            goto L_0x014c
        L_0x00d3:
            java.lang.String r13 = "start_chat"
            java.lang.String r14 = r2.f50288f     // Catch:{ Exception -> 0x0149 }
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0149 }
            if (r13 == 0) goto L_0x0143
            android.net.Uri r13 = r2.f50289g     // Catch:{ Exception -> 0x0149 }
            if (r13 == 0) goto L_0x0139
            java.lang.String r14 = "paytm_channel_id"
            java.lang.String r14 = r13.getQueryParameter(r14)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r15 = r13.getQueryParameter(r5)     // Catch:{ Exception -> 0x0149 }
            if (r15 != 0) goto L_0x00ef
            r15 = r9
        L_0x00ef:
            java.lang.String r11 = "uri.getQueryParameter(\"phone\") ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r11 = r13.getQueryParameter(r4)     // Catch:{ Exception -> 0x0149 }
            r16 = r14
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16     // Catch:{ Exception -> 0x0149 }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x0149 }
            if (r16 == 0) goto L_0x0112
            r16 = r15
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16     // Catch:{ Exception -> 0x0149 }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x0149 }
            if (r16 != 0) goto L_0x010e
            goto L_0x0112
        L_0x010e:
            e(r18)     // Catch:{ Exception -> 0x0149 }
            return
        L_0x0112:
            java.lang.String r12 = r13.getQueryParameter(r3)     // Catch:{ Exception -> 0x0149 }
            r17 = r9
            java.lang.String r9 = "chat_type"
            java.lang.String r9 = r13.getQueryParameter(r9)     // Catch:{ Exception -> 0x013f }
            java.lang.String r13 = r13.getQueryParameter(r0)     // Catch:{ Exception -> 0x013f }
            r10.putExtra(r5, r15)     // Catch:{ Exception -> 0x013f }
            r10.putExtra(r3, r12)     // Catch:{ Exception -> 0x013f }
            java.lang.String r3 = "paytmChannelId"
            r10.putExtra(r3, r14)     // Catch:{ Exception -> 0x013f }
            java.lang.String r3 = "chatType"
            r10.putExtra(r3, r9)     // Catch:{ Exception -> 0x013f }
            r10.putExtra(r0, r13)     // Catch:{ Exception -> 0x013f }
            r10.putExtra(r4, r11)     // Catch:{ Exception -> 0x013f }
            goto L_0x0145
        L_0x0139:
            r17 = r9
            e(r18)     // Catch:{ Exception -> 0x013f }
            return
        L_0x013f:
            r0 = move-exception
            r9 = r17
            goto L_0x014c
        L_0x0143:
            r17 = r9
        L_0x0145:
            r0 = r17
            r9 = r0
            goto L_0x0156
        L_0x0149:
            r0 = move-exception
            r17 = r9
        L_0x014c:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            r0 = r9
            r9 = r17
        L_0x0156:
            r3 = -1
            r12 = -1
        L_0x0158:
            if (r12 == r3) goto L_0x015d
            r10.putExtra(r6, r12)
        L_0x015d:
            r10.putExtra(r8, r0)
            r0 = r2
            android.os.Parcelable r0 = (android.os.Parcelable) r0
            java.lang.String r3 = "EXTRA_DEEP_LINK_DATA"
            r10.putExtra(r3, r0)
            java.lang.String r0 = "EXTRA_DEEP_LINK_FLAG"
            r3 = 1
            r10.putExtra(r0, r3)
            java.lang.String r0 = r2.f50288f
            java.lang.String r2 = "EXTRA_DEEP_LINK_TYPE"
            r10.putExtra(r2, r0)
            r10.putExtra(r7, r9)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r10.addFlags(r0)
            r1.startActivity(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.f.b(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }

    public static void a(b bVar) {
        k.c(bVar, "listener");
        f50342b = bVar;
    }

    private static void e(Context context) {
        b bVar = f50342b;
        if (bVar != null) {
            if (bVar == null) {
                k.a();
            }
            if (bVar.d()) {
                b bVar2 = f50342b;
                if (bVar2 != null) {
                    bVar2.b(context);
                    return;
                }
                return;
            }
        }
        Intent intent = new Intent();
        a aVar = a.f50344a;
        intent.setClassName("net.one97.paytm", a.a());
        Bundle bundle = new Bundle();
        bundle.putString("launch_page", "channel_list");
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_TARGET_ACTIVITY_ARGS, bundle);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static void f(Context context) {
        Context context2;
        if (context != null) {
            try {
                context2 = context.getApplicationContext();
            } catch (Exception unused) {
                return;
            }
        } else {
            context2 = null;
        }
        if (!(context2 instanceof Application)) {
            context2 = null;
        }
        Application application = (Application) context2;
        if (application != null) {
            Class<?> cls = Class.forName("net.one97.paytm.chat.ChatImplProvider");
            k.a((Object) cls, "Class.forName(\"net.one97…m.chat.ChatImplProvider\")");
            Method declaredMethod = cls.getDeclaredMethod("init", new Class[]{Application.class});
            k.a((Object) declaredMethod, "chatImpProviderClass.get… Application::class.java)");
            declaredMethod.invoke((Object) null, new Object[]{application});
        }
    }

    public static void a(Context context) {
        f(context);
        b bVar = f50342b;
        if (bVar != null) {
            bVar.e();
        }
    }

    public static void a(Context context, kotlin.g.a.b<? super y<Integer>, x> bVar) {
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        new Handler().postDelayed(new c(BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getIO(), CoroutineStart.LAZY, new d(context, bVar, (kotlin.d.d) null))), 400);
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Job f50347a;

        c(Job job) {
            this.f50347a = job;
        }

        public final void run() {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super x>, Object>(this, (kotlin.d.d) null) {
                Object L$0;
                int label;
                private CoroutineScope p$;
                final /* synthetic */ c this$0;

                {
                    this.this$0 = r1;
                }

                public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                    k.c(dVar, "completion");
                    AnonymousClass1 r0 = 

                    public static void b(Context context) {
                        k.c(context, "context");
                        if (f50343c == null) {
                            f50343c = new ChatDeepLinkHandler$registerBroadcast$1();
                        }
                        q.d("registerLoginEventListener");
                        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a(context);
                        BroadcastReceiver broadcastReceiver = f50343c;
                        if (broadcastReceiver == null) {
                            k.a();
                        }
                        a2.a(broadcastReceiver, new IntentFilter("action_update_login_status"));
                    }

                    public static void c(Context context) {
                        k.c(context, "context");
                        BroadcastReceiver broadcastReceiver = f50343c;
                        if (broadcastReceiver != null) {
                            androidx.localbroadcastmanager.a.a.a(context).a(broadcastReceiver);
                        }
                    }

                    public static boolean b(DeepLinkData deepLinkData) {
                        k.c(deepLinkData, "deepLinkData");
                        if (p.a(deepLinkData.f50284b, "chat", false) || ((p.a(deepLinkData.f50284b, "chatv2", false) && (p.a(deepLinkData.f50288f, UpiConstants.WALLET_TYPE_MONEY_TRANSFER, true) || p.a(deepLinkData.f50288f, "start_chat", false) || p.a(deepLinkData.f50288f, "click_notify", false) || p.a(deepLinkData.f50288f, "handle_fcm", false))) || c(deepLinkData))) {
                            return true;
                        }
                        return false;
                    }

                    @kotlin.d.b.a.f(b = "ChatDeepLinkHandler.kt", c = {244}, d = "invokeSuspend", e = "net.one97.paytm.deeplink.ChatDeepLinkHandler$getChatUnreadCountLiveData$initJob$1")
                    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                        final /* synthetic */ kotlin.g.a.b $callback;
                        final /* synthetic */ Context $context;
                        Object L$0;
                        Object L$1;
                        int label;
                        private CoroutineScope p$;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        d(Context context, kotlin.g.a.b bVar, kotlin.d.d dVar) {
                            super(2, dVar);
                            this.$context = context;
                            this.$callback = bVar;
                        }

                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                            k.c(dVar, "completion");
                            d dVar2 = new d(this.$context, this.$callback, dVar);
                            dVar2.p$ = (CoroutineScope) obj;
                            return dVar2;
                        }

                        public final Object invoke(Object obj, Object obj2) {
                            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                        }

                        static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                            final /* synthetic */ y $liveData;
                            int label;
                            private CoroutineScope p$;
                            final /* synthetic */ d this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            a(y yVar, kotlin.d.d dVar, d dVar2) {
                                super(2, dVar);
                                this.$liveData = yVar;
                                this.this$0 = dVar2;
                            }

                            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                                k.c(dVar, "completion");
                                a aVar = new a(this.$liveData, dVar, this.this$0);
                                aVar.p$ = (CoroutineScope) obj;
                                return aVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label == 0) {
                                    ResultKt.a(obj);
                                    this.this$0.$callback.invoke(this.$liveData);
                                    return x.f47997a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }

                        public final Object invokeSuspend(Object obj) {
                            y<Integer> g2;
                            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                            int i2 = this.label;
                            if (i2 == 0) {
                                ResultKt.a(obj);
                                CoroutineScope coroutineScope = this.p$;
                                f fVar = f.f50341a;
                                f.f(this.$context);
                                f fVar2 = f.f50341a;
                                b a2 = f.a();
                                if (!(a2 == null || (g2 = a2.g()) == null)) {
                                    this.L$0 = coroutineScope;
                                    this.L$1 = g2;
                                    this.label = 1;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new a(g2, (kotlin.d.d) null, this), this) == aVar) {
                                        return aVar;
                                    }
                                }
                            } else if (i2 == 1) {
                                ResultKt.a(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return x.f47997a;
                        }
                    }

                    private static boolean c(DeepLinkData deepLinkData) {
                        if (p.a(deepLinkData.f50284b, "paytmupdate", false) || p.a(deepLinkData.f50284b, "notification", false)) {
                            return true;
                        }
                        return false;
                    }

                    public static void a(Context context, DeepLinkData deepLinkData) {
                        RemoteMessage remoteMessage;
                        k.c(context, "context");
                        k.c(deepLinkData, "deepLinkData");
                        if (k.a((Object) "feed", (Object) deepLinkData.f50288f)) {
                            m mVar = m.f50358c;
                            m.c(context, deepLinkData);
                        } else if (k.a((Object) "start_chat", (Object) deepLinkData.f50288f)) {
                            b(context, deepLinkData);
                        } else if (k.a((Object) UpiConstants.WALLET_TYPE_MONEY_TRANSFER, (Object) deepLinkData.f50288f)) {
                            b(context, deepLinkData);
                        } else if (k.a((Object) "click_notify", (Object) deepLinkData.f50288f)) {
                            b(context, deepLinkData);
                        } else if (k.a((Object) "handle_fcm", (Object) deepLinkData.f50288f)) {
                            Intent intent = new Intent();
                            a aVar = a.f50344a;
                            intent.setClassName(context, a.b());
                            Bundle bundle = deepLinkData.f50290h;
                            if (!(bundle == null || (remoteMessage = (RemoteMessage) bundle.getParcelable("remote_message")) == null)) {
                                intent.putExtra("remote_message", remoteMessage);
                            }
                            context.sendBroadcast(intent);
                        } else {
                            e(context);
                        }
                    }
                }
