package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.b;
import androidx.work.impl.j;
import androidx.work.impl.utils.a;
import androidx.work.l;
import java.util.UUID;

public class SystemForegroundService extends LifecycleService implements b.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f5312c = l.a("SystemFgService");

    /* renamed from: d  reason: collision with root package name */
    private static SystemForegroundService f5313d = null;

    /* renamed from: a  reason: collision with root package name */
    b f5314a;

    /* renamed from: b  reason: collision with root package name */
    NotificationManager f5315b;

    /* renamed from: e  reason: collision with root package name */
    private Handler f5316e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5317f;

    public void onCreate() {
        super.onCreate();
        f5313d = this;
        d();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f5317f) {
            l.a();
            this.f5314a.a();
            d();
            this.f5317f = false;
        }
        if (intent == null) {
            return 3;
        }
        b bVar = this.f5314a;
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            l.a();
            String.format("Started foreground service %s", new Object[]{intent});
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            bVar.f5330c.a(new Runnable(bVar.f5329b.f5361c, stringExtra) {

                /* renamed from: a */
                final /* synthetic */ WorkDatabase f5337a;

                /* renamed from: b */
                final /* synthetic */ String f5338b;

                public final void run(
/*
Method generation error in method: androidx.work.impl.foreground.b.1.run():void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: androidx.work.impl.foreground.b.1.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            bVar.a(intent);
            return 3;
        } else if ("ACTION_NOTIFY".equals(action)) {
            bVar.a(intent);
            return 3;
        } else if (!"ACTION_CANCEL_WORK".equals(action)) {
            return 3;
        } else {
            l.a();
            String.format("Stopping foreground work for %s", new Object[]{intent});
            String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
            if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
                return 3;
            }
            j jVar = bVar.f5329b;
            jVar.f5362d.a(a.a(UUID.fromString(stringExtra2), jVar));
            return 3;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5314a.a();
    }

    private void d() {
        this.f5316e = new Handler(Looper.getMainLooper());
        this.f5315b = (NotificationManager) getApplicationContext().getSystemService("notification");
        this.f5314a = new b(getApplicationContext());
        this.f5314a.a((b.a) this);
    }

    public final void b() {
        this.f5316e.post(new Runnable() {
            public final void run() {
                b bVar = SystemForegroundService.this.f5314a;
                l.a();
                if (bVar.k != null) {
                    if (bVar.f5333f != null) {
                        bVar.k.a(bVar.f5333f.f5096a);
                        bVar.f5333f = null;
                    }
                    bVar.k.a();
                }
            }
        });
    }

    public final void a() {
        this.f5317f = true;
        l.a();
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f5313d = null;
        stopSelf();
    }

    public final void a(final int i2, final int i3, final Notification notification) {
        this.f5316e.post(new Runnable() {
            public final void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i2, notification, i3);
                } else {
                    SystemForegroundService.this.startForeground(i2, notification);
                }
            }
        });
    }

    public final void a(final int i2, final Notification notification) {
        this.f5316e.post(new Runnable() {
            public final void run() {
                SystemForegroundService.this.f5315b.notify(i2, notification);
            }
        });
    }

    public final void a(final int i2) {
        this.f5316e.post(new Runnable() {
            public final void run() {
                SystemForegroundService.this.f5315b.cancel(i2);
            }
        });
    }

    public static SystemForegroundService c() {
        return f5313d;
    }
}
