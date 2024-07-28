package com.google.firebase.crashlytics.a.c;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import com.google.firebase.c;
import com.google.firebase.crashlytics.a.a.a;
import com.google.firebase.crashlytics.a.b.b;
import com.google.firebase.crashlytics.a.k.e;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    m f38277a;

    /* renamed from: b  reason: collision with root package name */
    public i f38278b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f38279c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f38280d;

    /* renamed from: e  reason: collision with root package name */
    private final c f38281e;

    /* renamed from: f  reason: collision with root package name */
    private final r f38282f;

    /* renamed from: g  reason: collision with root package name */
    private final long f38283g = System.currentTimeMillis();

    /* renamed from: h  reason: collision with root package name */
    private m f38284h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f38285i;
    private final v j;
    private final b k;
    private final a l;
    private h m;
    private com.google.firebase.crashlytics.a.a n;

    public k(c cVar, v vVar, com.google.firebase.crashlytics.a.a aVar, r rVar, b bVar, a aVar2, ExecutorService executorService) {
        this.f38281e = cVar;
        this.f38282f = rVar;
        this.f38280d = cVar.a();
        this.j = vVar;
        this.n = aVar;
        this.k = bVar;
        this.l = aVar2;
        this.f38279c = executorService;
        this.m = new h(executorService);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x014f */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.firebase.crashlytics.a.k.e r21) {
        /*
            r20 = this;
            r0 = r20
            r14 = r21
            android.content.Context r1 = r0.f38280d
            java.lang.String r4 = com.google.firebase.crashlytics.a.c.g.i(r1)
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()
            java.lang.String r2 = java.lang.String.valueOf(r4)
            java.lang.String r3 = "Mapping file ID is: "
            r3.concat(r2)
            r15 = 3
            r1.a(r15)
            android.content.Context r1 = r0.f38280d
            java.lang.String r2 = "com.crashlytics.RequireBuildId"
            boolean r1 = com.google.firebase.crashlytics.a.c.g.a((android.content.Context) r1, (java.lang.String) r2)
            r16 = 1
            r13 = 0
            if (r1 != 0) goto L_0x0031
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()
            r1.a(r15)
        L_0x002f:
            r1 = 1
            goto L_0x0039
        L_0x0031:
            boolean r1 = com.google.firebase.crashlytics.a.c.g.c((java.lang.String) r4)
            if (r1 != 0) goto L_0x0038
            goto L_0x002f
        L_0x0038:
            r1 = 0
        L_0x0039:
            if (r1 == 0) goto L_0x0182
            com.google.firebase.c r1 = r0.f38281e
            com.google.firebase.g r1 = r1.c()
            java.lang.String r3 = r1.f38755b
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0175 }
            r2 = 4
            r1.a(r2)     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.g.i r9 = new com.google.firebase.crashlytics.a.g.i     // Catch:{ Exception -> 0x0175 }
            android.content.Context r1 = r0.f38280d     // Catch:{ Exception -> 0x0175 }
            r9.<init>(r1)     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.m r1 = new com.google.firebase.crashlytics.a.c.m     // Catch:{ Exception -> 0x0175 }
            java.lang.String r2 = "crash_marker"
            r1.<init>(r2, r9)     // Catch:{ Exception -> 0x0175 }
            r0.f38284h = r1     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.m r1 = new com.google.firebase.crashlytics.a.c.m     // Catch:{ Exception -> 0x0175 }
            java.lang.String r2 = "initialization_marker"
            r1.<init>(r2, r9)     // Catch:{ Exception -> 0x0175 }
            r0.f38277a = r1     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.f.c r10 = new com.google.firebase.crashlytics.a.f.c     // Catch:{ Exception -> 0x0175 }
            r10.<init>()     // Catch:{ Exception -> 0x0175 }
            android.content.Context r1 = r0.f38280d     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.v r2 = r0.j     // Catch:{ Exception -> 0x0175 }
            java.lang.String r6 = r1.getPackageName()     // Catch:{ Exception -> 0x0175 }
            java.lang.String r5 = r2.b()     // Catch:{ Exception -> 0x0175 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0175 }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r6, r13)     // Catch:{ Exception -> 0x0175 }
            int r2 = r1.versionCode     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = java.lang.Integer.toString(r2)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r2 = r1.versionName     // Catch:{ Exception -> 0x0175 }
            if (r2 != 0) goto L_0x008a
            java.lang.String r1 = "0.0"
            goto L_0x008c
        L_0x008a:
            java.lang.String r1 = r1.versionName     // Catch:{ Exception -> 0x0175 }
        L_0x008c:
            r8 = r1
            com.google.firebase.crashlytics.a.c.b r11 = new com.google.firebase.crashlytics.a.c.b     // Catch:{ Exception -> 0x0175 }
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.m.a r8 = new com.google.firebase.crashlytics.a.m.a     // Catch:{ Exception -> 0x0175 }
            android.content.Context r1 = r0.f38280d     // Catch:{ Exception -> 0x0175 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0175 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0175 }
            java.lang.String r3 = "Installer package name is: "
            r2.<init>(r3)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r3 = r11.f38172c     // Catch:{ Exception -> 0x0175 }
            r2.append(r3)     // Catch:{ Exception -> 0x0175 }
            r1.a(r15)     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.i r7 = new com.google.firebase.crashlytics.a.c.i     // Catch:{ Exception -> 0x0175 }
            android.content.Context r2 = r0.f38280d     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.h r3 = r0.m     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.v r5 = r0.j     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.r r6 = r0.f38282f     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.m r4 = r0.f38284h     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.a r1 = r0.n     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.a.a r12 = r0.l     // Catch:{ Exception -> 0x0175 }
            r17 = r1
            r1 = r7
            r18 = r4
            r4 = r10
            r10 = r7
            r7 = r9
            r19 = r8
            r8 = r18
            r9 = r11
            r11 = r10
            r10 = r17
            r15 = r11
            r11 = r19
            r14 = 0
            r13 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0175 }
            r0.f38278b = r15     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.m r1 = r0.f38277a     // Catch:{ Exception -> 0x0175 }
            java.io.File r1 = r1.b()     // Catch:{ Exception -> 0x0175 }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.h r2 = r0.m     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.k$4 r3 = new com.google.firebase.crashlytics.a.c.k$4     // Catch:{ Exception -> 0x0175 }
            r3.<init>()     // Catch:{ Exception -> 0x0175 }
            com.google.android.gms.tasks.Task r2 = r2.a(r3)     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r2 = com.google.firebase.crashlytics.a.c.af.a(r2)     // Catch:{ Exception -> 0x00fc }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x00fc }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0175 }
            boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x0175 }
            r0.f38285i = r2     // Catch:{ Exception -> 0x0175 }
            goto L_0x00fe
        L_0x00fc:
            r0.f38285i = r14     // Catch:{ Exception -> 0x0175 }
        L_0x00fe:
            com.google.firebase.crashlytics.a.c.i r2 = r0.f38278b     // Catch:{ Exception -> 0x0175 }
            java.lang.Thread$UncaughtExceptionHandler r3 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.h r4 = r2.j     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.i$6 r5 = new com.google.firebase.crashlytics.a.c.i$6     // Catch:{ Exception -> 0x0175 }
            r5.<init>()     // Catch:{ Exception -> 0x0175 }
            r4.a(r5)     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.i$19 r4 = new com.google.firebase.crashlytics.a.c.i$19     // Catch:{ Exception -> 0x0175 }
            r4.<init>()     // Catch:{ Exception -> 0x0175 }
            com.google.firebase.crashlytics.a.c.p r5 = new com.google.firebase.crashlytics.a.c.p     // Catch:{ Exception -> 0x0175 }
            r6 = r21
            r7 = 0
            r5.<init>(r4, r6, r3)     // Catch:{ Exception -> 0x0173 }
            r2.l = r5     // Catch:{ Exception -> 0x0173 }
            com.google.firebase.crashlytics.a.c.p r2 = r2.l     // Catch:{ Exception -> 0x0173 }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r2)     // Catch:{ Exception -> 0x0173 }
            if (r1 == 0) goto L_0x016a
            android.content.Context r1 = r0.f38280d     // Catch:{ Exception -> 0x0173 }
            boolean r1 = com.google.firebase.crashlytics.a.c.g.k(r1)     // Catch:{ Exception -> 0x0173 }
            if (r1 == 0) goto L_0x016a
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0173 }
            r2 = 3
            r1.a(r2)     // Catch:{ Exception -> 0x0173 }
            com.google.firebase.crashlytics.a.c.k$2 r1 = new com.google.firebase.crashlytics.a.c.k$2     // Catch:{ Exception -> 0x0173 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0173 }
            java.util.concurrent.ExecutorService r2 = r0.f38279c     // Catch:{ Exception -> 0x0173 }
            java.util.concurrent.Future r1 = r2.submit(r1)     // Catch:{ Exception -> 0x0173 }
            com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0173 }
            r3 = 3
            r2.a(r3)     // Catch:{ Exception -> 0x0173 }
            r2 = 4
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0161, ExecutionException -> 0x0158, TimeoutException -> 0x014f }
            r1.get(r2, r4)     // Catch:{ InterruptedException -> 0x0161, ExecutionException -> 0x0158, TimeoutException -> 0x014f }
            goto L_0x0169
        L_0x014f:
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0173 }
            r2 = 6
            r1.a(r2)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0169
        L_0x0158:
            r2 = 6
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0177 }
            r1.a(r2)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0169
        L_0x0161:
            r2 = 6
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x0177 }
            r1.a(r2)     // Catch:{ Exception -> 0x0177 }
        L_0x0169:
            return r7
        L_0x016a:
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()
            r2 = 3
            r1.a(r2)
            return r16
        L_0x0173:
            r2 = 6
            goto L_0x0177
        L_0x0175:
            r2 = 6
            r7 = 0
        L_0x0177:
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()
            r1.a(r2)
            r1 = 0
            r0.f38278b = r1
            return r7
        L_0x0182:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.k.a(com.google.firebase.crashlytics.a.k.e):boolean");
    }

    public final void a(String str) {
        this.f38278b.a(System.currentTimeMillis() - this.f38283g, str);
    }

    private void a() {
        this.m.a(new Callable<Boolean>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    boolean delete = k.this.f38277a.b().delete();
                    com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
                    "Initialization marker file removed: ".concat(String.valueOf(delete));
                    a2.a(3);
                    return Boolean.valueOf(delete);
                } catch (Exception unused) {
                    com.google.firebase.crashlytics.a.b.a().a(6);
                    return Boolean.FALSE;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final Task<Void> b(e eVar) {
        Task<TContinuationResult> task;
        Task<T> task2;
        this.m.a();
        this.f38277a.a();
        com.google.firebase.crashlytics.a.b.a().a(3);
        i iVar = this.f38278b;
        iVar.j.a((Runnable) new Runnable() {
            public final void run(
/*
Method generation error in method: com.google.firebase.crashlytics.a.c.i.7.run():void, dex: classes2.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.google.firebase.crashlytics.a.c.i.7.run():void, class status: UNLOADED
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
        try {
            this.k.a(new l(this));
            com.google.firebase.crashlytics.a.k.a.e a2 = eVar.a();
            if (!a2.b().f38670a) {
                com.google.firebase.crashlytics.a.b.a().a(3);
                return h.a((Exception) new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f38278b.a(a2.a().f38671a)) {
                com.google.firebase.crashlytics.a.b.a().a(3);
            }
            i iVar2 = this.f38278b;
            Task<com.google.firebase.crashlytics.a.k.a.b> b2 = eVar.b();
            com.google.firebase.crashlytics.a.i.a aVar = iVar2.k;
            File[] a3 = aVar.f38617a.a();
            File[] b3 = aVar.f38617a.b();
            boolean z = true;
            if (a3 == null || a3.length <= 0) {
                if (b3 == null || b3.length <= 0) {
                    z = false;
                }
            }
            if (!z) {
                com.google.firebase.crashlytics.a.b.a().a(3);
                iVar2.m.b(Boolean.FALSE);
                task = h.a(null);
            } else {
                com.google.firebase.crashlytics.a.b.a().a(3);
                if (iVar2.f38202g.a()) {
                    com.google.firebase.crashlytics.a.b.a().a(3);
                    iVar2.m.b(Boolean.FALSE);
                    task2 = h.a(Boolean.TRUE);
                } else {
                    com.google.firebase.crashlytics.a.b.a().a(3);
                    com.google.firebase.crashlytics.a.b.a().a(3);
                    iVar2.m.b(Boolean.TRUE);
                    Task<TContinuationResult> a4 = iVar2.f38202g.b().a(new com.google.android.gms.tasks.e<Void, Boolean>() {
                        public final /* bridge */ /* synthetic */ com.google.android.gms.tasks.Task a(
/*
Method generation error in method: com.google.firebase.crashlytics.a.c.i.21.a(java.lang.Object):com.google.android.gms.tasks.Task, dex: classes2.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.google.firebase.crashlytics.a.c.i.21.a(java.lang.Object):com.google.android.gms.tasks.Task, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
                    com.google.firebase.crashlytics.a.b.a().a(3);
                    task2 = af.a(a4, (Task<TContinuationResult>) iVar2.n.a());
                }
                task = task2.a((com.google.android.gms.tasks.e<T, TContinuationResult>) new com.google.android.gms.tasks.e<Boolean, Void>(b2) {

                    /* renamed from: a */
                    final /* synthetic */ Task f38241a;

                    /* renamed from: b */
                    final /* synthetic */ float f38242b;

                    public final /* synthetic */ com.google.android.gms.tasks.Task a(
/*
Method generation error in method: com.google.firebase.crashlytics.a.c.i.22.a(java.lang.Object):com.google.android.gms.tasks.Task, dex: classes2.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.google.firebase.crashlytics.a.c.i.22.a(java.lang.Object):com.google.android.gms.tasks.Task, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
            }
            a();
            return task;
        } catch (Exception e2) {
            com.google.firebase.crashlytics.a.b.a().a(6);
            return h.a(e2);
        } finally {
            a();
        }
    }
}
