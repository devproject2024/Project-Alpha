package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.c;
import com.bumptech.glide.gifdecoder.d;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public final class a implements k<ByteBuffer, c> {

    /* renamed from: a  reason: collision with root package name */
    private static final C0101a f7204a = new C0101a();

    /* renamed from: b  reason: collision with root package name */
    private static final b f7205b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Context f7206c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f7207d;

    /* renamed from: e  reason: collision with root package name */
    private final b f7208e;

    /* renamed from: f  reason: collision with root package name */
    private final C0101a f7209f;

    /* renamed from: g  reason: collision with root package name */
    private final b f7210g;

    public final /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        ImageHeaderParser.ImageType imageType;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (((Boolean) iVar.a(i.f7241b)).booleanValue()) {
            return false;
        }
        List<ImageHeaderParser> list = this.f7207d;
        if (byteBuffer == null) {
            imageType = ImageHeaderParser.ImageType.UNKNOWN;
        } else {
            imageType = f.a(list, (f.b) new f.b(byteBuffer) {

                /* renamed from: a */
                final /* synthetic */ ByteBuffer f7257a;

                public final com.bumptech.glide.load.ImageHeaderParser.ImageType a(
/*
Method generation error in method: com.bumptech.glide.load.f.2.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.bumptech.glide.load.f.2.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType, class status: UNLOADED
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
        return imageType == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List<ImageHeaderParser> list, e eVar, com.bumptech.glide.load.b.a.b bVar) {
        this(context, list, eVar, bVar, f7205b, f7204a);
    }

    private a(Context context, List<ImageHeaderParser> list, e eVar, com.bumptech.glide.load.b.a.b bVar, b bVar2, C0101a aVar) {
        this.f7206c = context.getApplicationContext();
        this.f7207d = list;
        this.f7209f = aVar;
        this.f7210g = new b(eVar, bVar);
        this.f7208e = bVar2;
    }

    /* access modifiers changed from: private */
    public e a(ByteBuffer byteBuffer, int i2, int i3, i iVar) {
        d a2 = this.f7208e.a(byteBuffer);
        try {
            return a(byteBuffer, i2, i3, a2, iVar);
        } finally {
            this.f7208e.a(a2);
        }
    }

    private e a(ByteBuffer byteBuffer, int i2, int i3, d dVar, i iVar) {
        Bitmap.Config config;
        int i4;
        int i5 = i2;
        int i6 = i3;
        d dVar2 = dVar;
        long a2 = com.bumptech.glide.g.f.a();
        try {
            if (dVar2.f6646b != null) {
                if (!dVar.c()) {
                    dVar.b();
                    if (!dVar.c()) {
                        dVar.a();
                        if (dVar2.f6647c.f6638c < 0) {
                            dVar2.f6647c.f6637b = 1;
                        }
                    }
                }
                c cVar = dVar2.f6647c;
                if (cVar.f6638c > 0) {
                    if (cVar.f6637b == 0) {
                        if (iVar.a(i.f7240a) == com.bumptech.glide.load.b.PREFER_RGB_565) {
                            config = Bitmap.Config.RGB_565;
                        } else {
                            config = Bitmap.Config.ARGB_8888;
                        }
                        int min = Math.min(cVar.f6642g / i6, cVar.f6641f / i5);
                        if (min == 0) {
                            i4 = 0;
                        } else {
                            i4 = Integer.highestOneBit(min);
                        }
                        int max = Math.max(1, i4);
                        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
                            StringBuilder sb = new StringBuilder("Downsampling GIF, sampleSize: ");
                            sb.append(max);
                            sb.append(", target dimens: [");
                            sb.append(i5);
                            sb.append("x");
                            sb.append(i6);
                            sb.append("], actual dimens: [");
                            sb.append(cVar.f6641f);
                            sb.append("x");
                            sb.append(cVar.f6642g);
                            sb.append("]");
                        }
                        com.bumptech.glide.gifdecoder.e eVar = new com.bumptech.glide.gifdecoder.e(this.f7210g, cVar, byteBuffer, max);
                        eVar.a(config);
                        eVar.b();
                        Bitmap h2 = eVar.h();
                        if (h2 == null) {
                            if (Log.isLoggable("BufferGifDecoder", 2)) {
                                new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.g.f.a(a2));
                            }
                            return null;
                        }
                        e eVar2 = new e(new c(this.f7206c, eVar, com.bumptech.glide.load.d.c.a(), i2, i3, h2));
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.g.f.a(a2));
                        }
                        return eVar2;
                    }
                }
                return null;
            }
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                new StringBuilder("Decoded GIF from stream in ").append(com.bumptech.glide.g.f.a(a2));
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.d.e.a$a  reason: collision with other inner class name */
    static class C0101a {
        C0101a() {
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<d> f7211a = com.bumptech.glide.g.k.a(0);

        b() {
        }

        /* access modifiers changed from: package-private */
        public final synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f7211a.poll();
            if (poll == null) {
                poll = new d();
            }
            poll.f6646b = null;
            Arrays.fill(poll.f6645a, (byte) 0);
            poll.f6647c = new c();
            poll.f6648d = 0;
            poll.f6646b = byteBuffer.asReadOnlyBuffer();
            poll.f6646b.position(0);
            poll.f6646b.order(ByteOrder.LITTLE_ENDIAN);
            return poll;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(d dVar) {
            dVar.f6646b = null;
            dVar.f6647c = null;
            this.f7211a.offer(dVar);
        }
    }
}
