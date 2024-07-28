package net.one97.paytm.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.paytm.analytics.b;
import com.paytm.analytics.models.Config;
import com.paytm.erroranalytics.c.a;
import com.paytm.utility.f;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.landingpage.utils.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;

public final class u {

    /* renamed from: c  reason: collision with root package name */
    private static u f69790c;

    /* renamed from: d  reason: collision with root package name */
    private static final long f69791d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a  reason: collision with root package name */
    public e f69792a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69793b;

    /* renamed from: e  reason: collision with root package name */
    private boolean f69794e = false;

    public static boolean a(int i2) {
        return i2 == 50002;
    }

    public static boolean b(int i2) {
        return i2 == 50001;
    }

    public static boolean c(int i2) {
        return i2 == 50000;
    }

    public static boolean d(int i2) {
        return i2 == 50003;
    }

    public static u a() {
        if (f69790c == null) {
            f69790c = new u();
        }
        return f69790c;
    }

    public static void b() {
        f69790c = null;
    }

    public final void a(Activity activity, Intent intent) {
        if (!this.f69794e) {
            this.f69794e = true;
            ((CJRJarvisApplication) activity.getApplication()).f49006b = null;
            AsyncTask.SERIAL_EXECUTOR.execute(new a(activity, intent));
            AsyncTask.SERIAL_EXECUTOR.execute(new c(this, (byte) 0));
        }
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Activity f69795a;

        /* renamed from: b  reason: collision with root package name */
        Intent f69796b;

        a(Activity activity, Intent intent) {
            this.f69795a = activity;
            this.f69796b = intent;
        }

        public final void run() {
            u.this.f69792a = new e(this.f69795a);
            ba.k(this.f69795a.getApplicationContext());
            net.one97.paytm.j.a.a(this.f69795a.getApplicationContext(), this.f69796b);
            Context applicationContext = this.f69795a.getApplicationContext();
            if (applicationContext != null && Build.VERSION.SDK_INT >= 25) {
                try {
                    ((ShortcutManager) applicationContext.getSystemService(ShortcutManager.class)).setDynamicShortcuts(d.a(applicationContext));
                } catch (Exception unused) {
                }
            }
            u.b((Context) this.f69795a);
            CJRJarvisApplication.d();
            CJRJarvisApplication.c();
            CJRJarvisApplication.e();
            u.c();
            u.b((Context) this.f69795a, this.f69796b);
            Application application = this.f69795a.getApplication();
            if (!ag.a(application.getApplicationContext()).b("is_referral_client_used", false, true)) {
                com.android.installreferrer.a.a a2 = com.android.installreferrer.a.a.a((Context) application).a();
                try {
                    a2.a((com.android.installreferrer.a.c) new com.android.installreferrer.a.c(application, a2) {

                        /* renamed from: a */
                        final /* synthetic */ Context f66490a;

                        /* renamed from: b */
                        final /* synthetic */ com.android.installreferrer.a.a f66491b;

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void onInstallReferrerSetupFinished(
/*
Method generation error in method: net.one97.paytm.upi.a.1.onInstallReferrerSetupFinished(int):void, dex: classes7.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.a.1.onInstallReferrerSetupFinished(int):void, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/

                        public final void onInstallReferrerServiceDisconnected(
/*
Method generation error in method: net.one97.paytm.upi.a.1.onInstallReferrerServiceDisconnected():void, dex: classes7.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.a.1.onInstallReferrerServiceDisconnected():void, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    });
                } catch (RuntimeException e2) {
                    com.google.firebase.crashlytics.c.a().a((Throwable) e2);
                }
            }
            OauthModule.c();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Activity f69798a;

        /* renamed from: b  reason: collision with root package name */
        Intent f69799b;

        public b(Activity activity, Intent intent) {
            this.f69798a = activity;
            this.f69799b = intent;
        }

        public final void run() {
            new StringBuilder().append(System.currentTimeMillis());
            if (u.this.f69792a != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                    public final void run(
/*
Method generation error in method: net.one97.paytm.landingpage.utils.e.2.run():void, dex: classes5.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.landingpage.utils.e.2.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                });
            }
            if (!s.a() || s.e(this.f69798a)) {
                u.c(this.f69798a, this.f69799b);
            }
            net.one97.paytm.j.c.a();
            com.paytm.utility.a.b(net.one97.paytm.j.c.a("key_child_site_id", (String) null));
            net.one97.paytm.j.c.a();
            com.paytm.utility.a.a(net.one97.paytm.j.c.a("key_site_id", (String) null));
            if (u.this.f69792a != null) {
                e eVar = u.this.f69792a;
                try {
                    if (eVar.f53012a != null && !eVar.f53012a.isFinishing()) {
                        com.paytm.b.a.a a2 = ag.a(eVar.f53012a.getApplicationContext(), f.a.PREF_KEY_USER_NOT_VERIFIED);
                        if (a2.b("USER_SKIPPED_VERIFICATION", false, false)) {
                            net.one97.paytm.auth.b.b.a(eVar.f53012a, false);
                        }
                        a2.a();
                    }
                } catch (NullPointerException e2) {
                    q.b(e2.getMessage());
                }
            }
            try {
                com.paytm.utility.a.g();
                b.C0683b bVar = com.paytm.analytics.b.f40911e;
                Config.Builder builder = new Config.Builder();
                net.one97.paytm.j.c.a();
                Config.Builder serverEndPoints = builder.serverEndPoints(net.one97.paytm.j.c.a("signalSdkUrl", (String) null));
                net.one97.paytm.j.c.a();
                Config.Builder uploadFrequency = serverEndPoints.uploadFrequency(Integer.valueOf(net.one97.paytm.j.c.a("signal_batch_freq", 0)));
                net.one97.paytm.j.c.a();
                Config.Builder isLocationEnable = uploadFrequency.isLocationEnable(Boolean.valueOf(net.one97.paytm.j.c.a("paytm_location_enabled", true)));
                net.one97.paytm.j.c.a();
                Config.Builder locationSchedulingTime = isLocationEnable.locationSchedulingTime(Integer.valueOf(net.one97.paytm.j.c.a("location_scheduling_time_sec", 0)));
                net.one97.paytm.j.c.a();
                Config.Builder locationNightModeStartHour = locationSchedulingTime.locationNightModeStartHour(Integer.valueOf(net.one97.paytm.j.c.a("location_night_mode_start_hour", 0)));
                net.one97.paytm.j.c.a();
                Config.Builder locationNightModeEndHour = locationNightModeStartHour.locationNightModeEndHour(Integer.valueOf(net.one97.paytm.j.c.a("location_night_mode_end_hour", 0)));
                net.one97.paytm.j.c.a();
                b.C0683b.a(locationNightModeEndHour.sameLocationThreshold(Integer.valueOf(net.one97.paytm.j.c.a("same_location_iteration_threshold", 0))).timeSyncFrequency(Integer.valueOf((int) TimeUnit.HOURS.toSeconds(1))).build());
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
            try {
                com.paytm.utility.a.h();
                com.paytm.erroranalytics.e a3 = com.paytm.erroranalytics.e.a();
                a.C0712a aVar = new a.C0712a();
                aVar.f42719b = com.paytm.utility.a.a(this.f69798a.getApplicationContext());
                aVar.f42718a = com.paytm.utility.a.d(this.f69798a.getApplicationContext());
                aVar.f42724g = "release";
                aVar.f42725h = "paytm";
                net.one97.paytm.j.c.a();
                aVar.f42723f = net.one97.paytm.j.c.R();
                aVar.f42726i = "androidapp";
                net.one97.paytm.j.c.a();
                aVar.j = net.one97.paytm.j.c.a("error_sdk_event_scheduling_time_sec", 0);
                net.one97.paytm.j.c.a();
                aVar.k = net.one97.paytm.j.c.a("show_error_analytics_logs", false);
                a3.a(aVar.a());
            } catch (Exception e4) {
                q.b(e4.getMessage());
            }
            new StringBuilder().append(System.currentTimeMillis());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b3 A[Catch:{ Exception -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.app.Activity r19, android.content.Intent r20) {
        /*
            r18 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "paymentmode"
            java.lang.String r4 = "mid"
            r5 = 0
            if (r2 == 0) goto L_0x0141
            java.lang.String r6 = "bill"
            android.os.Bundle r0 = r2.getBundleExtra(r6)
            if (r0 == 0) goto L_0x0141
            r7 = 2
            r8 = 1
            r9 = r18
            r9.f69793b = r8     // Catch:{ Exception -> 0x010e }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x010e }
            r10 = 26
            if (r0 < r10) goto L_0x0024
            r0 = 33554432(0x2000000, float:9.403955E-38)
            r2.removeFlags(r0)     // Catch:{ Exception -> 0x010e }
        L_0x0024:
            android.content.Context r0 = r19.getApplicationContext()     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = net.one97.paytm.utils.t.b((android.content.Context) r0)     // Catch:{ Exception -> 0x010e }
            if (r0 != 0) goto L_0x004e
            java.lang.String r0 = "before_login"
            a(r2, r1, r0)     // Catch:{ Exception -> 0x010e }
            android.content.Intent r10 = new android.content.Intent     // Catch:{ Exception -> 0x010e }
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r0 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            r10.<init>(r1, r0)     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = "launchSignUp"
            r10.putExtra(r0, r5)     // Catch:{ Exception -> 0x004b }
            java.lang.String r0 = "set_result_required"
            r10.putExtra(r0, r8)     // Catch:{ Exception -> 0x004b }
            r0 = 50001(0xc351, float:7.0066E-41)
            r1.startActivityForResult(r10, r0)     // Catch:{ Exception -> 0x004b }
            return r8
        L_0x004b:
            r0 = move-exception
            goto L_0x0110
        L_0x004e:
            int r0 = r2.getIntExtra(r3, r5)     // Catch:{ Exception -> 0x010e }
            if (r0 == r8) goto L_0x00f3
            if (r0 == r7) goto L_0x0057
            return r5
        L_0x0057:
            java.lang.String r0 = "nativeSdkForMerchantAmount"
            java.lang.String r10 = "Invalid Input Parameters"
            r11 = 0
            java.lang.String r13 = "txnToken"
            java.lang.String r14 = "orderid"
            if (r2 != 0) goto L_0x0068
            a((java.lang.String) r10, (android.app.Activity) r1)     // Catch:{ Exception -> 0x010e }
        L_0x0066:
            r10 = 0
            goto L_0x00b1
        L_0x0068:
            android.os.Bundle r15 = r2.getBundleExtra(r6)     // Catch:{ Exception -> 0x010e }
            if (r15 != 0) goto L_0x0072
            a((java.lang.String) r10, (android.app.Activity) r1)     // Catch:{ Exception -> 0x010e }
            goto L_0x0066
        L_0x0072:
            java.lang.String r10 = r15.getString(r14)     // Catch:{ Exception -> 0x010e }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x010e }
            if (r10 == 0) goto L_0x0082
            java.lang.String r10 = "Invalid Order Id"
            a((java.lang.String) r10, (android.app.Activity) r1)     // Catch:{ Exception -> 0x010e }
            goto L_0x0066
        L_0x0082:
            java.lang.String r10 = r15.getString(r13)     // Catch:{ Exception -> 0x010e }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x010e }
            if (r10 == 0) goto L_0x0092
            java.lang.String r10 = "Invalid Transaction Token"
            a((java.lang.String) r10, (android.app.Activity) r1)     // Catch:{ Exception -> 0x010e }
            goto L_0x0066
        L_0x0092:
            double r16 = r15.getDouble(r0, r11)     // Catch:{ Exception -> 0x010e }
            int r10 = (r16 > r11 ? 1 : (r16 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x00a0
            java.lang.String r10 = "Invalid Amount"
            a((java.lang.String) r10, (android.app.Activity) r1)     // Catch:{ Exception -> 0x010e }
            goto L_0x0066
        L_0x00a0:
            java.lang.String r10 = r15.getString(r4)     // Catch:{ Exception -> 0x010e }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x010e }
            if (r10 == 0) goto L_0x00b0
            java.lang.String r10 = "Invalid MID"
            a((java.lang.String) r10, (android.app.Activity) r1)     // Catch:{ Exception -> 0x010e }
            goto L_0x0066
        L_0x00b0:
            r10 = 1
        L_0x00b1:
            if (r10 == 0) goto L_0x00f2
            android.content.Context r10 = r19.getApplicationContext()     // Catch:{ Exception -> 0x010e }
            java.lang.Class<net.one97.paytm.AJRRechargePaymentActivity> r15 = net.one97.paytm.AJRRechargePaymentActivity.class
            r2.setClass(r10, r15)     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = "enable_paytm_invoke"
            r2.putExtra(r10, r8)     // Catch:{ Exception -> 0x010e }
            android.os.Bundle r10 = r2.getBundleExtra(r6)     // Catch:{ Exception -> 0x010e }
            java.lang.String r15 = r10.getString(r14)     // Catch:{ Exception -> 0x010e }
            r2.putExtra(r14, r15)     // Catch:{ Exception -> 0x010e }
            java.lang.String r14 = r10.getString(r13)     // Catch:{ Exception -> 0x010e }
            r2.putExtra(r13, r14)     // Catch:{ Exception -> 0x010e }
            java.lang.String r13 = "price"
            double r11 = r10.getDouble(r0, r11)     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x010e }
            r2.putExtra(r13, r0)     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = r10.getString(r4)     // Catch:{ Exception -> 0x010e }
            r2.putExtra(r4, r0)     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = "nativeSdkEnabled"
            r2.putExtra(r0, r8)     // Catch:{ Exception -> 0x010e }
            r0 = 50003(0xc353, float:7.0069E-41)
            r1.startActivityForResult(r2, r0)     // Catch:{ Exception -> 0x010e }
        L_0x00f2:
            return r8
        L_0x00f3:
            r19.getApplicationContext()     // Catch:{ Exception -> 0x010e }
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()     // Catch:{ Exception -> 0x010e }
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$c r10 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.c.EXTERNAL     // Catch:{ Exception -> 0x010e }
            r0.f71392d = r10     // Catch:{ Exception -> 0x010e }
            android.content.Context r0 = r19.getApplicationContext()     // Catch:{ Exception -> 0x010e }
            java.lang.Class<net.one97.paytm.wallet.newdesign.activity.P2PActivity> r10 = net.one97.paytm.wallet.newdesign.activity.P2PActivity.class
            r2.setClass(r0, r10)     // Catch:{ Exception -> 0x010e }
            r0 = 50002(0xc352, float:7.0068E-41)
            r1.startActivityForResult(r2, r0)     // Catch:{ Exception -> 0x010e }
            return r8
        L_0x010e:
            r0 = move-exception
            r10 = r2
        L_0x0110:
            int r3 = r10.getIntExtra(r3, r5)
            java.lang.String r5 = "AJRJarvisSplash"
            if (r3 != r7) goto L_0x0131
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r7 = "Mid: "
            r3.<init>(r7)
            android.os.Bundle r2 = r2.getBundleExtra(r6)
            java.lang.String r2 = r2.getString(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            net.one97.paytm.utils.r.a((java.lang.String) r5, (java.lang.String) r2)
        L_0x0131:
            java.lang.String r2 = "openPaymentActivity"
            net.one97.paytm.utils.r.a((java.lang.String) r5, (java.lang.String) r2, (java.lang.Throwable) r0)
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            r19.finish()
            return r8
        L_0x0141:
            r9 = r18
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.u.b(android.app.Activity, android.content.Intent):boolean");
    }

    public static void a(Intent intent, Context context, String str) {
        Bundle bundleExtra = intent.getBundleExtra("bill");
        if (bundleExtra != null) {
            String string = bundleExtra.getString("mid");
            String string2 = bundleExtra.getString("orderid");
            Map<String, Object> allInOneEventParams = SDKUtility.getAllInOneEventParams(str, "");
            if (!TextUtils.isEmpty(string2)) {
                allInOneEventParams.put("event_label", string2);
            }
            if (!TextUtils.isEmpty(string)) {
                allInOneEventParams.put("event_label3", string);
            }
            new Handler().postDelayed(new Runnable(allInOneEventParams, context) {
                private final /* synthetic */ Map f$0;
                private final /* synthetic */ Context f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    net.one97.paytm.j.a.b((String) GAUtil.CUSTOM_EVENT, (Map<String, Object>) this.f$0, this.f$1);
                }
            }, 3000);
        }
    }

    private static void a(String str, Activity activity) {
        Intent intent = new Intent();
        intent.putExtra(SDKConstants.RESPONSE, "");
        intent.putExtra("nativeSdkForMerchantMessage", str);
        activity.setResult(100, intent);
        activity.finish();
    }

    public static void a(Context context, Intent intent) {
        CJRHomePageItem a2 = c.a(context, intent.getData().toString());
        h.a aVar = h.f50349a;
        h.a.a(context, a2.getDeeplink(), (Bundle) null);
    }

    public static void a(Activity activity) {
        Intent intent = new Intent(activity, PaySendActivityV2.class);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, false);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
        activity.finish();
    }

    private static void a(Cursor cursor) {
        try {
            if ((true ^ cursor.isClosed()) && (cursor != null)) {
                cursor.close();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(u uVar, byte b2) {
            this();
        }

        public final void run() {
            if (u.this.f69792a != null) {
                e eVar = u.this.f69792a;
                try {
                    if (com.uninstallationtracking.b.a(eVar.f53013b)) {
                        com.paytm.b.a.a a2 = ag.a(eVar.f53013b.getApplicationContext());
                        String b2 = a2.b("acquisition_source", "", true);
                        String b3 = a2.b("acquisition_medium", "", true);
                        String b4 = a2.b("acquisition_campaign", "", true);
                        String b5 = a2.b("acquisition_content", "", true);
                        String b6 = a2.b("gclid", "", true);
                        HashMap hashMap = new HashMap();
                        hashMap.put("acquisition_source", e.a(b2));
                        hashMap.put("acquisition_medium", e.a(b3));
                        hashMap.put("acquisition_campaign", e.a(b4));
                        hashMap.put("acquisition_content", e.a(b5));
                        hashMap.put("acquisition_gclid", e.a(b6));
                        net.one97.paytm.j.a.b("first_app_launch", (Map<String, Object>) hashMap, eVar.f53013b);
                    }
                    com.uninstallationtracking.b.b(eVar.f53013b);
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
        }
    }

    static /* synthetic */ void b(Context context) {
        com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
        long currentTimeMillis = System.currentTimeMillis();
        long b2 = a2.b(net.one97.paytm.common.utility.b.q, 0, true);
        long b3 = currentTimeMillis - a2.b(net.one97.paytm.common.utility.b.r, currentTimeMillis, true);
        if (b3 == 0) {
            a2.a(net.one97.paytm.common.utility.b.r, currentTimeMillis, true);
        } else if (b3 >= f69791d) {
            a2.a(net.one97.paytm.common.utility.b.q, currentTimeMillis, true);
            a2.a(net.one97.paytm.common.utility.b.q, 1, true);
            a2.a(net.one97.paytm.common.utility.b.r, currentTimeMillis, true);
            return;
        }
        a2.a(net.one97.paytm.common.utility.b.q, b2 + 1, true);
    }

    static /* synthetic */ void c() {
        net.one97.paytm.f.a.a().f50397d = com.paytm.utility.a.r(CJRJarvisApplication.getAppContext());
        HashMap<Integer, ArrayList<String>> a2 = com.paytm.utility.a.a(new Date(System.currentTimeMillis()), CJRJarvisApplication.getAppContext());
        if (a2 != null) {
            ArrayList arrayList = a2.get(1);
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    net.one97.paytm.f.a.a().a(str, l.b(CJRJarvisApplication.getAppContext(), str).isContactExits(), true);
                    net.one97.paytm.f.a.a().b();
                }
            } else {
                net.one97.paytm.f.a a3 = net.one97.paytm.f.a.a();
                if (a3.f50394a != null) {
                    a3.f50394a.clear();
                }
                if (a3.f50399f != null) {
                    a3.f50399f.clear();
                }
            }
            net.one97.paytm.f.a.a().f50395b = a2.get(2);
        }
        net.one97.paytm.f.a.a().f50396c = com.paytm.utility.a.j();
        net.one97.paytm.f.a.a().f50398e = l.d(CJRJarvisApplication.getAppContext());
    }

    static /* synthetic */ void b(Context context, Intent intent) {
        if (intent.hasExtra("FROM") && intent.getStringExtra("FROM").equalsIgnoreCase("SMART_NOTIFICATION")) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.a.a(context.getApplicationContext()) != null ? com.paytm.utility.a.a(context.getApplicationContext()) : "");
            hashMap.put("event_label", "Paytm Home");
            net.one97.paytm.j.a.b("smart_notification", (Map<String, Object>) hashMap, context.getApplicationContext());
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x0143=Splitter:B:48:0x0143, B:26:0x00bb=Splitter:B:26:0x00bb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(android.content.Context r14, android.content.Intent r15) {
        /*
            if (r15 == 0) goto L_0x0181
            android.net.Uri r0 = r15.getData()     // Catch:{ Exception -> 0x0179 }
            if (r0 == 0) goto L_0x0181
            android.net.Uri r0 = r15.getData()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0179 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0179 }
            if (r0 != 0) goto L_0x0181
            android.net.Uri r0 = r15.getData()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r1 = "com.android.contacts"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0179 }
            if (r0 == 0) goto L_0x0181
            java.lang.String r0 = r15.getType()     // Catch:{ Exception -> 0x0179 }
            if (r0 == 0) goto L_0x0181
            java.lang.String r0 = r15.getType()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0179 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0179 }
            if (r0 != 0) goto L_0x0181
            java.lang.String r0 = r15.getType()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r1 = "send_money"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0179 }
            java.lang.String r1 = "91"
            java.lang.String r2 = "0"
            java.lang.String r3 = ""
            java.lang.String r4 = "[\\D]"
            java.lang.String r5 = "DATA1"
            r6 = 0
            r7 = 10
            if (r0 == 0) goto L_0x00cf
            android.content.ContentResolver r8 = r14.getContentResolver()     // Catch:{ Exception -> 0x00c2 }
            android.net.Uri r9 = r15.getData()     // Catch:{ Exception -> 0x00c2 }
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            android.database.Cursor r6 = r8.query(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x00c2 }
            boolean r0 = r6.moveToNext()     // Catch:{ Exception -> 0x00c2 }
            if (r0 == 0) goto L_0x00bb
            int r0 = r6.getColumnIndex(r5)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r0 = r6.getString(r0)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r5 = "Send Money to"
            int r5 = r0.lastIndexOf(r5)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r0 = r0.substring(r5)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r0 = r0.replaceAll(r4, r3)     // Catch:{ Exception -> 0x00c2 }
            int r3 = r0.length()     // Catch:{ Exception -> 0x00c2 }
            if (r3 <= r7) goto L_0x00a2
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x00c2 }
            if (r2 != 0) goto L_0x0095
            boolean r1 = r0.startsWith(r1)     // Catch:{ Exception -> 0x00c2 }
            if (r1 == 0) goto L_0x00a2
        L_0x0095:
            int r1 = r0.length()     // Catch:{ Exception -> 0x00c2 }
            int r1 = r1 - r7
            java.lang.String r0 = r0.substring(r1)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00c2 }
        L_0x00a2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r2 = "paytmmp://cash_wallet?featuretype=sendmoneymobile&recipient="
            r1.<init>(r2)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00c2 }
            r1.append(r0)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00c2 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x00c2 }
            r15.setData(r0)     // Catch:{ Exception -> 0x00c2 }
        L_0x00bb:
            a((android.database.Cursor) r6)     // Catch:{ Exception -> 0x0179 }
            goto L_0x0156
        L_0x00c0:
            r14 = move-exception
            goto L_0x00cb
        L_0x00c2:
            r15 = move-exception
            java.lang.String r15 = r15.getMessage()     // Catch:{ all -> 0x00c0 }
            com.paytm.utility.q.b(r15)     // Catch:{ all -> 0x00c0 }
            goto L_0x00bb
        L_0x00cb:
            a((android.database.Cursor) r6)     // Catch:{ Exception -> 0x0179 }
            throw r14     // Catch:{ Exception -> 0x0179 }
        L_0x00cf:
            java.lang.String r0 = r15.getType()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r8 = "recharge_mobile"
            boolean r0 = r0.contains(r8)     // Catch:{ Exception -> 0x0179 }
            if (r0 == 0) goto L_0x0156
            android.content.ContentResolver r8 = r14.getContentResolver()     // Catch:{ Exception -> 0x0149 }
            android.net.Uri r9 = r15.getData()     // Catch:{ Exception -> 0x0149 }
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            android.database.Cursor r6 = r8.query(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0149 }
            boolean r0 = r6.moveToNext()     // Catch:{ Exception -> 0x0149 }
            if (r0 == 0) goto L_0x0143
            int r0 = r6.getColumnIndex(r5)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r6.getString(r0)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r5 = "Recharge"
            int r5 = r0.lastIndexOf(r5)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r0.substring(r5)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r0.replaceAll(r4, r3)     // Catch:{ Exception -> 0x0149 }
            int r3 = r0.length()     // Catch:{ Exception -> 0x0149 }
            if (r3 <= r7) goto L_0x012a
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0149 }
            if (r2 != 0) goto L_0x011d
            boolean r1 = r0.startsWith(r1)     // Catch:{ Exception -> 0x0149 }
            if (r1 == 0) goto L_0x012a
        L_0x011d:
            int r1 = r0.length()     // Catch:{ Exception -> 0x0149 }
            int r1 = r1 - r7
            java.lang.String r0 = r0.substring(r1)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0149 }
        L_0x012a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0149 }
            java.lang.String r2 = "paytmmp://mobile_prepaid?url=https://catalog.paytm.com/v1/mobile/mobile-prepaid/17$label=Prepaid%20Mobile$related_category=[%7B%20\"url\":\"https://catalog.paytm.com/v1/mobile/mobile-postpaid/21\",%20\"label\":\"Postpaid%20Mobile\"%7D]$prepaid_on=Y$ff=N$bottom_tab=offers$title=Prepaid test$recharge_number="
            r1.<init>(r2)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0149 }
            r1.append(r0)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0149 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0149 }
            r15.setData(r0)     // Catch:{ Exception -> 0x0149 }
        L_0x0143:
            a((android.database.Cursor) r6)     // Catch:{ Exception -> 0x0179 }
            goto L_0x0156
        L_0x0147:
            r14 = move-exception
            goto L_0x0152
        L_0x0149:
            r15 = move-exception
            java.lang.String r15 = r15.getMessage()     // Catch:{ all -> 0x0147 }
            com.paytm.utility.q.b(r15)     // Catch:{ all -> 0x0147 }
            goto L_0x0143
        L_0x0152:
            a((android.database.Cursor) r6)     // Catch:{ Exception -> 0x0179 }
            throw r14     // Catch:{ Exception -> 0x0179 }
        L_0x0156:
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x016c }
            r15.<init>()     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = "mobile_homescreen_icon_name"
            java.lang.String r1 = "Phonebook"
            r15.put(r0, r1)     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = "mobile_homescreen_paytm_icon_clicked"
            android.content.Context r14 = r14.getApplicationContext()     // Catch:{ Exception -> 0x016c }
            net.one97.paytm.j.a.b((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r15, (android.content.Context) r14)     // Catch:{ Exception -> 0x016c }
            return
        L_0x016c:
            r14 = move-exception
            boolean r15 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x0179 }
            if (r15 == 0) goto L_0x0181
            java.lang.String r14 = r14.getMessage()     // Catch:{ Exception -> 0x0179 }
            com.paytm.utility.q.b(r14)     // Catch:{ Exception -> 0x0179 }
            goto L_0x0181
        L_0x0179:
            r14 = move-exception
            java.lang.String r14 = r14.getMessage()
            com.paytm.utility.q.b(r14)
        L_0x0181:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.u.c(android.content.Context, android.content.Intent):void");
    }
}
