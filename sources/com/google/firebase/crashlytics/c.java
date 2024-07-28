package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.a.b;
import com.google.firebase.crashlytics.a.c.i;
import com.google.firebase.crashlytics.a.c.k;
import java.util.Date;
import java.util.concurrent.Callable;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final k f38714a;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.google.firebase.crashlytics.a.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.firebase.crashlytics.a.a.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.google.firebase.crashlytics.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.google.firebase.crashlytics.a.a.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.firebase.crashlytics.a.a.c} */
    /* JADX WARNING: type inference failed for: r1v9, types: [com.google.firebase.crashlytics.a.a.f] */
    /* JADX WARNING: type inference failed for: r0v19, types: [com.google.firebase.crashlytics.a.a.b, com.google.firebase.crashlytics.a.a.d] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b4  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.crashlytics.c a(com.google.firebase.c r27, com.google.firebase.iid.internal.a r28, com.google.firebase.crashlytics.a.a r29, com.google.firebase.analytics.connector.a r30) {
        /*
            r8 = r27
            r0 = r30
            android.content.Context r9 = r27.a()
            java.lang.String r1 = r9.getPackageName()
            com.google.firebase.crashlytics.a.c.v r2 = new com.google.firebase.crashlytics.a.c.v
            r3 = r28
            r2.<init>(r9, r1, r3)
            com.google.firebase.crashlytics.a.c.r r4 = new com.google.firebase.crashlytics.a.c.r
            r4.<init>(r8)
            if (r29 != 0) goto L_0x0021
            com.google.firebase.crashlytics.a.c r1 = new com.google.firebase.crashlytics.a.c
            r1.<init>()
            r3 = r1
            goto L_0x0023
        L_0x0021:
            r3 = r29
        L_0x0023:
            com.google.firebase.crashlytics.a.e r11 = new com.google.firebase.crashlytics.a.e
            r11.<init>(r8, r9, r2, r4)
            r10 = 3
            if (r0 == 0) goto L_0x0083
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()
            r1.a(r10)
            com.google.firebase.crashlytics.a.a.e r1 = new com.google.firebase.crashlytics.a.a.e
            r1.<init>(r0)
            com.google.firebase.crashlytics.a r5 = new com.google.firebase.crashlytics.a
            r5.<init>()
            java.lang.String r6 = "clx"
            com.google.firebase.analytics.connector.a$a r6 = r0.a((java.lang.String) r6, (com.google.firebase.analytics.connector.a.b) r5)
            if (r6 != 0) goto L_0x005b
            com.google.firebase.crashlytics.a.b r6 = com.google.firebase.crashlytics.a.b.a()
            r6.a(r10)
            java.lang.String r6 = "crash"
            com.google.firebase.analytics.connector.a$a r6 = r0.a((java.lang.String) r6, (com.google.firebase.analytics.connector.a.b) r5)
            if (r6 == 0) goto L_0x005b
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r7 = 5
            r0.a(r7)
        L_0x005b:
            if (r6 == 0) goto L_0x0076
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r0.a(r10)
            com.google.firebase.crashlytics.a.a.d r0 = new com.google.firebase.crashlytics.a.a.d
            r0.<init>()
            com.google.firebase.crashlytics.a.a.c r6 = new com.google.firebase.crashlytics.a.a.c
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS
            r6.<init>(r1, r7)
            r5.f38135b = r0
            r5.f38134a = r6
            r5 = r0
            goto L_0x0096
        L_0x0076:
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r0.a(r10)
            com.google.firebase.crashlytics.a.b.c r0 = new com.google.firebase.crashlytics.a.b.c
            r0.<init>()
            goto L_0x0094
        L_0x0083:
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r0.a(r10)
            com.google.firebase.crashlytics.a.b.c r0 = new com.google.firebase.crashlytics.a.b.c
            r0.<init>()
            com.google.firebase.crashlytics.a.a.f r1 = new com.google.firebase.crashlytics.a.a.f
            r1.<init>()
        L_0x0094:
            r5 = r0
            r6 = r1
        L_0x0096:
            java.lang.String r0 = "Crashlytics Exception Handler"
            java.util.concurrent.ExecutorService r7 = com.google.firebase.crashlytics.a.c.u.a(r0)
            com.google.firebase.crashlytics.a.c.k r15 = new com.google.firebase.crashlytics.a.c.k
            r0 = r15
            r1 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r11.a()
            if (r0 != 0) goto L_0x00b4
            com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
            r1 = 6
            r0.a(r1)
            r0 = 0
            return r0
        L_0x00b4:
            java.lang.String r0 = "com.google.firebase.crashlytics.startup"
            java.util.concurrent.ExecutorService r14 = com.google.firebase.crashlytics.a.c.u.a(r0)
            com.google.firebase.g r0 = r27.c()
            java.lang.String r0 = r0.f38755b
            com.google.firebase.crashlytics.a.c.v r1 = r11.f38366e
            com.google.firebase.crashlytics.a.f.c r2 = r11.f38362a
            java.lang.String r3 = r11.f38364c
            java.lang.String r4 = r11.f38365d
            java.lang.String r5 = r11.b()
            com.google.firebase.crashlytics.a.c.r r7 = r11.f38367f
            java.lang.String r6 = r1.b()
            com.google.firebase.crashlytics.a.c.ad r8 = new com.google.firebase.crashlytics.a.c.ad
            r8.<init>()
            com.google.firebase.crashlytics.a.k.f r12 = new com.google.firebase.crashlytics.a.k.f
            r12.<init>(r8)
            com.google.firebase.crashlytics.a.k.a r13 = new com.google.firebase.crashlytics.a.k.a
            r13.<init>(r9)
            java.util.Locale r10 = java.util.Locale.US
            r29 = r15
            r15 = 1
            r26 = r11
            java.lang.Object[] r11 = new java.lang.Object[r15]
            r16 = 0
            r11[r16] = r0
            java.lang.String r15 = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings"
            java.lang.String r10 = java.lang.String.format(r10, r15, r11)
            com.google.firebase.crashlytics.a.k.b.c r11 = new com.google.firebase.crashlytics.a.k.b.c
            r11.<init>(r5, r10, r2)
            java.util.Locale r2 = java.util.Locale.US
            r5 = 2
            java.lang.Object[] r10 = new java.lang.Object[r5]
            java.lang.String r15 = android.os.Build.MANUFACTURER
            java.lang.String r15 = com.google.firebase.crashlytics.a.c.v.a(r15)
            r10[r16] = r15
            java.lang.String r15 = android.os.Build.MODEL
            java.lang.String r15 = com.google.firebase.crashlytics.a.c.v.a(r15)
            r17 = 1
            r10[r17] = r15
            java.lang.String r15 = "%s/%s"
            java.lang.String r18 = java.lang.String.format(r2, r15, r10)
            java.lang.String r2 = android.os.Build.VERSION.INCREMENTAL
            java.lang.String r19 = com.google.firebase.crashlytics.a.c.v.a(r2)
            java.lang.String r2 = android.os.Build.VERSION.RELEASE
            java.lang.String r20 = com.google.firebase.crashlytics.a.c.v.a(r2)
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r10 = com.google.firebase.crashlytics.a.c.g.i(r9)
            r2[r16] = r10
            r2[r17] = r0
            r2[r5] = r4
            r5 = 3
            r2[r5] = r3
            java.lang.String r22 = com.google.firebase.crashlytics.a.c.g.a((java.lang.String[]) r2)
            com.google.firebase.crashlytics.a.c.t r2 = com.google.firebase.crashlytics.a.c.t.determineFrom(r6)
            int r25 = r2.getId()
            com.google.firebase.crashlytics.a.k.a.g r2 = new com.google.firebase.crashlytics.a.k.a.g
            r16 = r2
            r17 = r0
            r21 = r1
            r23 = r4
            r24 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25)
            com.google.firebase.crashlytics.a.k.d r15 = new com.google.firebase.crashlytics.a.k.d
            r0 = r15
            r1 = r9
            r3 = r8
            r4 = r12
            r5 = r13
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            com.google.firebase.crashlytics.a.k.c r0 = com.google.firebase.crashlytics.a.k.c.USE_CACHE
            com.google.android.gms.tasks.Task r0 = r15.a((com.google.firebase.crashlytics.a.k.c) r0, (java.util.concurrent.Executor) r14)
            com.google.firebase.crashlytics.a.e$3 r1 = new com.google.firebase.crashlytics.a.e$3
            r2 = r26
            r1.<init>()
            r0.a((java.util.concurrent.Executor) r14, r1)
            r0 = r29
            boolean r1 = r0.a((com.google.firebase.crashlytics.a.k.e) r15)
            com.google.firebase.crashlytics.c$1 r3 = new com.google.firebase.crashlytics.c$1
            r10 = r3
            r11 = r2
            r12 = r14
            r13 = r15
            r2 = r14
            r14 = r1
            r15 = r0
            r10.<init>(r12, r13, r14, r15)
            com.google.android.gms.tasks.h.a((java.util.concurrent.Executor) r2, r3)
            com.google.firebase.crashlytics.c r1 = new com.google.firebase.crashlytics.c
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.c.a(com.google.firebase.c, com.google.firebase.iid.internal.a, com.google.firebase.crashlytics.a.a, com.google.firebase.analytics.connector.a):com.google.firebase.crashlytics.c");
    }

    private c(k kVar) {
        this.f38714a = kVar;
    }

    public static c a() {
        c cVar = (c) com.google.firebase.c.e().a(c.class);
        if (cVar != null) {
            return cVar;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    public final void a(Throwable th) {
        if (th == null) {
            b.a().a(5);
            return;
        }
        i iVar = this.f38714a.f38278b;
        Thread currentThread = Thread.currentThread();
        iVar.j.a((Runnable) new Runnable(new Date(), th, currentThread) {

            /* renamed from: a */
            final /* synthetic */ Date f38251a;

            /* renamed from: b */
            final /* synthetic */ Throwable f38252b;

            /* renamed from: c */
            final /* synthetic */ Thread f38253c;

            public final void run(
/*
Method generation error in method: com.google.firebase.crashlytics.a.c.i.3.run():void, dex: classes2.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.google.firebase.crashlytics.a.c.i.3.run():void, class status: UNLOADED
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
    }

    public final void a(String str) {
        this.f38714a.a(str);
    }

    public final void b(String str) {
        i iVar = this.f38714a.f38278b;
        iVar.f38204i.a(str);
        iVar.j.a(new Callable<Void>(iVar.f38204i) {

            /* renamed from: a */
            final /* synthetic */ ae f38255a;

            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Void call(
/*
Method generation error in method: com.google.firebase.crashlytics.a.c.i.4.a():java.lang.Void, dex: classes2.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.google.firebase.crashlytics.a.c.i.4.a():java.lang.Void, class status: UNLOADED
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
    }
}
