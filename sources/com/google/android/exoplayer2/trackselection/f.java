package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.b.m;
import java.util.List;

public interface f {
    int a();

    int a(long j, List<? extends l> list);

    int a(Format format);

    Format a(int i2);

    void a(float f2);

    void a(long j, long j2, List<? extends l> list, m[] mVarArr);

    boolean a(int i2, long j);

    int b();

    int b(int i2);

    int c(int i2);

    Object c();

    void d();

    TrackGroup e();

    int f();

    Format g();

    int h();

    @Deprecated
    void i();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroup f33500a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f33501b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33502c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f33503d;

        public a(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0, (Object) null);
        }

        public a(TrackGroup trackGroup, int[] iArr, int i2, Object obj) {
            this.f33500a = trackGroup;
            this.f33501b = iArr;
            this.f33502c = i2;
            this.f33503d = obj;
        }
    }

    public interface b {
        @Deprecated
        f a();

        f[] a(a[] aVarArr, d dVar);

        /* renamed from: com.google.android.exoplayer2.trackselection.f$b$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @Deprecated
            public static f $default$a(b _this) {
                throw new UnsupportedOperationException();
            }

            public static f[] $default$a(b _this, a[] aVarArr, d dVar) {
                $$Lambda$f$b$0v96mnkdDSeEeg0Zp7hLoftdmc r0 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: CONSTRUCTOR  (r0v0 'r0' com.google.android.exoplayer2.trackselection.-$$Lambda$f$b$0v96mnkdDSeEeg0Zp7hL-oftdmc) = 
                      (r9v0 '_this' com.google.android.exoplayer2.trackselection.f$b)
                      (r11v0 'dVar' com.google.android.exoplayer2.f.d)
                     call: com.google.android.exoplayer2.trackselection.-$$Lambda$f$b$0v96mnkdDSeEeg0Zp7hL-oftdmc.<init>(com.google.android.exoplayer2.trackselection.f$b, com.google.android.exoplayer2.f.d):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.trackselection.f.b.-CC.$default$a(com.google.android.exoplayer2.trackselection.f$b, com.google.android.exoplayer2.trackselection.f$a[], com.google.android.exoplayer2.f.d):com.google.android.exoplayer2.trackselection.f[], dex: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
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
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.trackselection.-$$Lambda$f$b$0v96mnkdDSeEeg0Zp7hL-oftdmc, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 59 more
                    */
                /*
                    com.google.android.exoplayer2.trackselection.-$$Lambda$f$b$0v96mnkdDSeEeg0Zp7hL-oftdmc r0 = new com.google.android.exoplayer2.trackselection.-$$Lambda$f$b$0v96mnkdDSeEeg0Zp7hL-oftdmc
                    r0.<init>(r9, r11)
                    int r11 = r10.length
                    com.google.android.exoplayer2.trackselection.f[] r11 = new com.google.android.exoplayer2.trackselection.f[r11]
                    r1 = 0
                    r2 = 0
                    r3 = 0
                L_0x000b:
                    int r4 = r10.length
                    if (r2 >= r4) goto L_0x0036
                    r4 = r10[r2]
                    r5 = 1
                    if (r4 == 0) goto L_0x0033
                    int[] r6 = r4.f33501b
                    int r6 = r6.length
                    if (r6 <= r5) goto L_0x0022
                    if (r3 != 0) goto L_0x0022
                    com.google.android.exoplayer2.trackselection.f r3 = r0.createAdaptiveTrackSelection(r4)
                    r11[r2] = r3
                    r3 = 1
                    goto L_0x0033
                L_0x0022:
                    com.google.android.exoplayer2.trackselection.c r5 = new com.google.android.exoplayer2.trackselection.c
                    com.google.android.exoplayer2.source.TrackGroup r6 = r4.f33500a
                    int[] r7 = r4.f33501b
                    r7 = r7[r1]
                    int r8 = r4.f33502c
                    java.lang.Object r4 = r4.f33503d
                    r5.<init>(r6, r7, r8, r4)
                    r11[r2] = r5
                L_0x0033:
                    int r2 = r2 + 1
                    goto L_0x000b
                L_0x0036:
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.f.b.CC.$default$a(com.google.android.exoplayer2.trackselection.f$b, com.google.android.exoplayer2.trackselection.f$a[], com.google.android.exoplayer2.f.d):com.google.android.exoplayer2.trackselection.f[]");
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.trackselection.f$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated
        public static void $default$i(f _this) {
            throw new UnsupportedOperationException();
        }

        public static void $default$a(f _this, long j, long j2, List list, m[] mVarArr) {
            _this.i();
        }
    }
}
