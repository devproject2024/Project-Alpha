package com.paytmmall.artifact.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.q;
import com.paytmmall.a.a.f;
import com.paytmmall.a.a.h;
import com.paytmmall.a.b;
import com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity;
import com.paytmmall.artifact.cart.d.c;
import com.paytmmall.artifact.cart.entity.CJRAddress;
import com.paytmmall.artifact.cart.entity.CJRAddressList;
import com.paytmmall.artifact.cart.entity.CJRAddresses;
import com.paytmmall.artifact.cart.entity.CJRParcelTrackingInfo;
import com.paytmmall.artifact.cart.entity.CJRRechargePayment;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.cart.entity.WishListProduct;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.artifact.common.entity.CJRItem;
import com.paytmmall.artifact.d.m;
import com.paytmmall.b.a;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.UrlUtils;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.upi.util.UpiConstants;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static a f15736a = a.PAYTM_APP;

    /* renamed from: b  reason: collision with root package name */
    private static t f15737b;

    /* renamed from: c  reason: collision with root package name */
    private static Application f15738c;

    /* renamed from: f  reason: collision with root package name */
    private static final String f15739f = t.class.getName();

    /* renamed from: d  reason: collision with root package name */
    private com.paytmmall.artifact.common.a f15740d;

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f15741e = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private List<Object> f15742g = new ArrayList();

    public enum a {
        MALL_APP,
        P4B_APP,
        PAYTM_APP
    }

    public static int a() {
        return l.c();
    }

    private t() {
    }

    public static Context b() {
        return f15738c;
    }

    public static t c() {
        synchronized (t.class) {
            if (f15737b == null) {
                int i2 = 0;
                try {
                    String[] strArr = new String[0];
                    Method[] declaredMethods = Class.forName("net.one97.paytm.dynamic.module.mall.JarvisHelper").getDeclaredMethods();
                    int length = declaredMethods.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        Method method = declaredMethods[i2];
                        if (method.getName().equalsIgnoreCase("getMallInstance")) {
                            method.invoke((Object) null, strArr);
                            break;
                        }
                        i2++;
                    }
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
        }
        return f15737b;
    }

    public static CJRShoppingCart d() {
        return v.a().f15746a;
    }

    public static boolean a(String str) {
        if ("deals".equals(str) || "nearbuy".equals(str)) {
            return true;
        }
        return c().f15741e.contains(str);
    }

    private static void b(Context context, String str, CJRHomePageItem cJRHomePageItem, String str2, int i2, ArrayList<? extends CJRItem> arrayList, String str3) {
        String str4;
        CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
        String a2 = q.a(cJRHomePageItem, CJRHomePageItem.class);
        if (arrayList != null) {
            str4 = q.a(arrayList);
        } else {
            str4 = null;
        }
        c().f15740d.loadPage(context, str, a2, str2, i2, str4, false, str3);
    }

    public static void a(com.paytmmall.artifact.common.a aVar, Application application) {
        f15738c = application;
        if (f15737b == null) {
            f15737b = new t();
        }
        f15737b.f15740d = aVar;
        t c2 = c();
        c2.f15741e.addAll(a.a().f15665a);
        if (!c().f15740d.isMallApp()) {
            c2.f15741e.removeAll(a.a().f15666b);
        }
        CLPArtifact.init(application, c().f15740d.getCLPCommunicationListener());
        m.a().a((Context) f15738c, (m.a) null);
        if (aVar != null && aVar.isMallApp()) {
            b bVar = b.f15385c;
            Application application2 = f15738c;
            k.c(application2, "application");
            k.c("7688e1fef591b4e2ffbd679ab096e798a35bef82", "appPublicKey");
            if (!b.f15384b) {
                b.f15383a = b.a(application2);
                PhoenixManager.INSTANCE.init(application2, b.a(), b.b(), true);
                b.f15384b = true;
            }
        }
    }

    public static com.paytmmall.artifact.common.a e() {
        return c().f15740d;
    }

    public static <T> T a(String str, Class<T> cls) {
        return com.paytmmall.artifact.e.a.a(str, cls);
    }

    public static <T> T a(String str, Type type) {
        return com.paytmmall.artifact.e.a.a(str, type);
    }

    public static void a(Context context, Intent intent, CJRRechargePayment cJRRechargePayment, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str, String str2, w wVar) {
        c().f15740d.openCheckoutActivity(context, intent, q.a(cJRRechargePayment, CJRRechargePayment.class), q.a(cJRParcelTrackingInfo, CJRParcelTrackingInfo.class), str, str2, wVar);
    }

    public static void b(Context context, String str) {
        b.a(context, (CJRAddress) com.paytmmall.artifact.e.a.a(str, CJRAddress.class));
    }

    public static void c(Context context, String str) {
        b.a(context, (CJRAddressList) com.paytmmall.artifact.e.a.a(str, CJRAddressList.class));
    }

    public static String b(Context context) {
        return b.c(context);
    }

    public static String c(Context context) {
        return b.a(context);
    }

    public static void a(Context context, String str, HashMap<String, Serializable> hashMap) {
        a.a().a(context, str, hashMap);
    }

    public static boolean b(String str) {
        a a2 = a.a();
        return a2.f15665a.contains(str) || a2.f15667c.containsKey(str) || str.equals("deals") || str.equals("nearbuy");
    }

    public static Class<? extends Activity> f() {
        return AJRShoppingCartActivity.class;
    }

    public final String c(String str) {
        try {
            return this.f15740d.getBuildConstant(str);
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return "";
        }
    }

    public final boolean g() {
        return Boolean.parseBoolean(c("IS_DEBUG"));
    }

    public static void a(Context context, Map<String, Object> map) {
        v.a(context, map);
    }

    public static void d(Context context) {
        com.paytmmall.artifact.cart.d.a.b(context);
    }

    public static boolean d(Context context, String str) {
        return com.paytmmall.artifact.cart.d.a.a(context, str);
    }

    public static void a(Context context, com.paytmmall.b.b bVar, String str) {
        c.a(context, bVar, str);
    }

    public static void a(Context context, com.paytmmall.b.b bVar, String str, String str2) {
        c.a(context, bVar, str, str2);
    }

    public static String a(String str, String str2) {
        com.paytmmall.artifact.common.a.a.a();
        return com.paytmmall.artifact.common.a.a.a(str, str2);
    }

    public static List<WishListProduct> h() {
        v a2 = v.a();
        if (a2.f15747b == null) {
            return null;
        }
        return a2.f15747b.getmProduct();
    }

    public static void a(int i2, Bundle bundle) {
        f.a(i2, bundle);
    }

    public static void a(int i2, int i3, Bundle bundle) {
        com.paytmmall.a.a.k.a(i2, i3, bundle);
    }

    public static void b(Activity activity) {
        h.a(activity);
    }

    public static Fragment a(Bundle bundle) {
        String string = bundle.getString("url");
        Application application = f15738c;
        return com.paytmmall.artifact.clp.b.a.a(e.b(UrlUtils.appendGridQueryParameter(com.paytm.utility.b.s(application, string), AppConstants.TAG_LANG_ID, CLPArtifact.getInstance().getCommunicationListener().getLangId(application))), bundle.getInt("key_bottom_tab_position"));
    }

    public static void a(Context context, String str, CJRHomePageItem cJRHomePageItem, String str2, int i2, ArrayList<? extends CJRItem> arrayList, String str3) {
        boolean z;
        if (cJRHomePageItem != null && "product".equals(str) && !c().f15740d.isMallApp() && "81".equals(cJRHomePageItem.getVerticalid())) {
            b(context, str, cJRHomePageItem, str2, i2, arrayList, str3);
            return;
        }
        String name = (cJRHomePageItem == null || TextUtils.isEmpty(cJRHomePageItem.getName()) || !new HashSet<String>() {
            {
                add("myprofile");
                add(CLPConstants.WISHLIST);
                add("updates");
                add("profile");
            }
        }.contains(cJRHomePageItem.getName())) ? str : cJRHomePageItem.getName();
        if (!a(name)) {
            b(context, name, cJRHomePageItem, str2, i2, arrayList, str3);
            return;
        }
        if (cJRHomePageItem == null || TextUtils.isEmpty(cJRHomePageItem.getURL())) {
            z = false;
        } else {
            z = Uri.parse(cJRHomePageItem.getURL()).getBooleanQueryParameter(CLPConstants.IS_MGV, false);
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (((CJRItem) arrayList.get(i3)).getURL() != null) {
                    String url = ((CJRItem) arrayList.get(i3)).getURL();
                    if (!TextUtils.isEmpty(url) && z) {
                        url = Uri.parse(url).buildUpon().appendQueryParameter(CLPConstants.IS_MGV, "true").toString();
                    }
                    arrayList2.add(url);
                }
            }
        }
        final CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
        final String str4 = str2;
        final int i4 = i2;
        final ArrayList arrayList3 = arrayList2;
        final String str5 = str3;
        a(context, name, (HashMap<String, Serializable>) new HashMap<String, Serializable>(false) {
            {
                put("extra_home_data", cJRHomePageItem2);
                put("calling activity", str4);
                put("extra_intent_item_position", Integer.valueOf(i4));
                put("launched_from_catalog", Boolean.valueOf(false));
                put("extra_intent_item_list", arrayList3);
                put(UpiConstants.FROM, str5);
            }
        });
    }

    public static void a(Context context, String str) {
        if (str != null && context != null && URLUtil.isValidUrl(str) && l.b(context) && TextUtils.isEmpty(b.b(context)) && URLUtil.isValidUrl(str) && d.a(context)) {
            String a2 = g.a(context);
            Context context2 = context;
            com.paytmmall.b.a.a(context2, a.C0216a.GET, str + a2, (String) null, l.a(), new CJRAddresses(), new com.paytmmall.b.b(context) {

                /* renamed from: a */
                final /* synthetic */ Context f15690a;

                public final void handleErrorCode(
/*
Method generation error in method: com.paytmmall.artifact.d.b.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes11.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.paytmmall.artifact.d.b.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
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

                public final void onApiSuccess(
/*
Method generation error in method: com.paytmmall.artifact.d.b.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes11.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.paytmmall.artifact.d.b.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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

    public static void a(Activity activity) {
        u.a(activity.getApplicationContext()).a("SAVE_SELECTED_ADDRESS_LIST_RESPONSE", false);
        CJRAddress f2 = b.f(activity);
        if (f2 != null && !TextUtils.isEmpty(f2.getAddress1())) {
            CJRAddress cJRAddress = new CJRAddress();
            cJRAddress.setPin(f2.getPin());
            b.a((Context) activity, cJRAddress);
        }
    }

    public static String a(Context context) {
        CJRAddress f2 = b.f(context);
        if (f2 == null) {
            return "";
        }
        return f2.getName();
    }
}
