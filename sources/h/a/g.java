package h.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

public abstract class g extends a implements f {
    private String fName;

    public int countTestCases() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void setUp() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void tearDown() throws Exception {
    }

    public g() {
        this.fName = null;
    }

    public g(String str) {
        this.fName = str;
    }

    /* access modifiers changed from: protected */
    public i createResult() {
        return new i();
    }

    public i run() {
        i createResult = createResult();
        run(createResult);
        return createResult;
    }

    public void runBare() throws Throwable {
        setUp();
        try {
            runTest();
            try {
                tearDown();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable unused) {
        }
        if (th != null) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void runTest() throws Throwable {
        assertNotNull("TestCase.fName cannot be null", this.fName);
        Method method = null;
        try {
            method = getClass().getMethod(this.fName, (Class[]) null);
        } catch (NoSuchMethodException unused) {
            fail("Method \"" + this.fName + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            fail("Method \"" + this.fName + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (InvocationTargetException e2) {
            e2.fillInStackTrace();
            throw e2.getTargetException();
        } catch (IllegalAccessException e3) {
            e3.fillInStackTrace();
            throw e3;
        }
    }

    public static void assertTrue(String str, boolean z) {
        a.assertTrue(str, z);
    }

    public static void assertTrue(boolean z) {
        a.assertTrue(z);
    }

    public static void assertFalse(String str, boolean z) {
        a.assertFalse(str, z);
    }

    public static void assertFalse(boolean z) {
        a.assertFalse(z);
    }

    public static void fail(String str) {
        a.fail(str);
    }

    public static void fail() {
        a.fail();
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        a.assertEquals(str, obj, obj2);
    }

    public static void assertEquals(Object obj, Object obj2) {
        a.assertEquals(obj, obj2);
    }

    public static void assertEquals(String str, String str2, String str3) {
        a.assertEquals(str, str2, str3);
    }

    public static void assertEquals(String str, String str2) {
        a.assertEquals(str, str2);
    }

    public static void assertEquals(String str, double d2, double d3, double d4) {
        a.assertEquals(str, d2, d3, d4);
    }

    public static void assertEquals(double d2, double d3, double d4) {
        a.assertEquals(d2, d3, d4);
    }

    public static void assertEquals(String str, float f2, float f3, float f4) {
        a.assertEquals(str, f2, f3, f4);
    }

    public static void assertEquals(float f2, float f3, float f4) {
        a.assertEquals(f2, f3, f4);
    }

    public static void assertEquals(String str, long j, long j2) {
        a.assertEquals(str, j, j2);
    }

    public static void assertEquals(long j, long j2) {
        a.assertEquals(j, j2);
    }

    public static void assertEquals(String str, boolean z, boolean z2) {
        a.assertEquals(str, z, z2);
    }

    public static void assertEquals(boolean z, boolean z2) {
        a.assertEquals(z, z2);
    }

    public static void assertEquals(String str, byte b2, byte b3) {
        a.assertEquals(str, b2, b3);
    }

    public static void assertEquals(byte b2, byte b3) {
        a.assertEquals(b2, b3);
    }

    public static void assertEquals(String str, char c2, char c3) {
        a.assertEquals(str, c2, c3);
    }

    public static void assertEquals(char c2, char c3) {
        a.assertEquals(c2, c3);
    }

    public static void assertEquals(String str, short s, short s2) {
        a.assertEquals(str, s, s2);
    }

    public static void assertEquals(short s, short s2) {
        a.assertEquals(s, s2);
    }

    public static void assertEquals(String str, int i2, int i3) {
        a.assertEquals(str, i2, i3);
    }

    public static void assertEquals(int i2, int i3) {
        a.assertEquals(i2, i3);
    }

    public static void assertNotNull(Object obj) {
        a.assertNotNull(obj);
    }

    public static void assertNotNull(String str, Object obj) {
        a.assertNotNull(str, obj);
    }

    public static void assertNull(Object obj) {
        a.assertNull(obj);
    }

    public static void assertNull(String str, Object obj) {
        a.assertNull(str, obj);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        a.assertSame(str, obj, obj2);
    }

    public static void assertSame(Object obj, Object obj2) {
        a.assertSame(obj, obj2);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        a.assertNotSame(str, obj, obj2);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        a.assertNotSame(obj, obj2);
    }

    public static void failSame(String str) {
        a.failSame(str);
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        a.failNotSame(str, obj, obj2);
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        a.failNotEquals(str, obj, obj2);
    }

    public static String format(String str, Object obj, Object obj2) {
        return a.format(str, obj, obj2);
    }

    public String toString() {
        return getName() + "(" + getClass().getName() + ")";
    }

    public String getName() {
        return this.fName;
    }

    public void setName(String str) {
        this.fName = str;
    }

    public void run(i iVar) {
        iVar.a(this);
        try {
            new e(this) {

                /* renamed from: a */
                final /* synthetic */ g f46267a;

                public final void a(
/*
Method generation error in method: h.a.i.1.a():void, dex: classes3.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: h.a.i.1.a():void, class status: UNLOADED
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
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
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
            }.a();
        } catch (b e2) {
            iVar.a((f) this, e2);
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (Throwable th) {
            iVar.a((f) this, th);
        }
        Iterator<Object> it2 = iVar.a().iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }
}
