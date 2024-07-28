package net.one97.paytm.moneytransfer;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.cashback.posttxn.e;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateExtraInfoDataModel;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.m;
import net.one97.paytm.moneytransfer.contacts.b.a;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.models.QrData;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upgradeKyc.activity.TransparentActivity;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.r;
import net.one97.paytm.verifier.activity.VerifierBasicActivity;
import net.one97.paytm.wallet.activity.AJRConfirmIFSCActivity;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.d.k;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;

public final class MoneyTransferImplProvider implements net.one97.paytm.moneytransfer.d.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f53518a = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private static MoneyTransferImplProvider f53519d;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IStaticWidget f53520b;

    /* renamed from: c  reason: collision with root package name */
    private e f53521c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final Context a() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public final ContextWrapper a(Context context) {
        k.c(context, "context");
        ContextThemeWrapper a2 = net.one97.paytm.locale.b.e.a(context);
        k.a((Object) a2, "Restring.wrapContext(context)");
        return a2;
    }

    public final String a(String str) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public final String a(String str, String str2) {
        k.c(str, "key");
        k.c(str2, "defaultValue");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, str2);
    }

    public final boolean a(String str, boolean z) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public final int b(String str) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, 0);
    }

    public final void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final String b() {
        return net.one97.paytm.payments.d.a.a() + "cash_wallet?featuretype=money_transfer";
    }

    public final String c() {
        return net.one97.paytm.payments.d.a.a() + "cash_wallet?featuretype=cash_ledger&tab=savings";
    }

    public final String d() {
        String name = PaySendActivityV2.class.getName();
        k.a((Object) name, "PaySendActivityV2::class.java.name");
        return name;
    }

    public final String e() {
        String name = AJRConfirmIFSCActivity.class.getName();
        k.a((Object) name, "AJRConfirmIFSCActivity::class.java.name");
        return name;
    }

    public final String f() {
        String name = AJREmbedWebView.class.getName();
        k.a((Object) name, "AJREmbedWebView::class.java.name");
        return name;
    }

    public final Intent a(Activity activity) {
        k.c(activity, "activity");
        Intent intent = new Intent();
        intent.setAction("set_passcode");
        ae aeVar = ae.f50307a;
        return ae.a(activity, intent);
    }

    public final Intent b(Activity activity) {
        k.c(activity, "activity");
        Intent intent = new Intent();
        intent.setAction("set_passcode");
        ae aeVar = ae.f50307a;
        return ae.a(activity, intent);
    }

    public final String g() {
        String name = AJRMainActivity.class.getName();
        k.a((Object) name, "AJRMainActivity::class.java.name");
        return name;
    }

    public final void a(Context context, int i2) {
        k.c(context, "context");
        net.one97.paytm.utils.a.b.a(context, i2);
    }

    public final boolean b(Context context) {
        k.c(context, "context");
        return net.one97.paytm.utils.a.b.b(context);
    }

    public final boolean c(Context context) {
        k.c(context, "context");
        return net.one97.paytm.utils.a.b.a(context);
    }

    public final void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        k.c(context, "context");
        k.c(str, "category");
        k.c(str2, "action");
        k.c(arrayList, "labels");
        k.c(str3, "value");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str5, "verticalId");
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(context, "context");
        k.c(str, "category");
        k.c(str2, "action");
        k.c(str3, "label1");
        k.c(str7, "verticalId");
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public final void a(String str, String str2, Context context) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "vertical");
        k.c(context, "context");
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void a(Context context, j jVar) {
        k.c(context, "context");
        k.c(jVar, "fragmentManager");
        if (net.one97.paytm.deeplink.e.a()) {
            this.f53521c = net.one97.paytm.cashback.posttxn.c.a();
            e eVar = this.f53521c;
            if (eVar != null) {
                eVar.a((AppCompatActivity) context);
            }
        }
    }

    public final void a(String str, View view) {
        e eVar;
        k.c(str, "txnId");
        k.c(view, "cashBackView");
        SFInterface.INSTANCE.notifySuccessTransaction(str);
        e eVar2 = this.f53521c;
        if (eVar2 != null) {
            if (eVar2 == null) {
                k.a();
            }
            if (!eVar2.a(net.one97.paytm.utils.b.a.PAY_USING_UPI.getId(), 0)) {
                e eVar3 = this.f53521c;
                if (eVar3 == null) {
                    k.a();
                }
                if (!eVar3.a(net.one97.paytm.utils.b.a.PAY_USING_UPI_6.getId(), 0)) {
                    e eVar4 = this.f53521c;
                    if (eVar4 == null) {
                        k.a();
                    }
                    if (!eVar4.a(net.one97.paytm.utils.b.a.PAY_USING_UPI_7.getId(), 0)) {
                        return;
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && (eVar = this.f53521c) != null) {
                f.a aVar = new f.a();
                aVar.f49547c = str;
                aVar.f49550f = "0";
                aVar.f49549e = String.valueOf(net.one97.paytm.utils.b.a.PAY_USING_UPI.getId());
                eVar.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) new c(this, str));
            }
        }
    }

    public static final class c implements net.one97.paytm.cashback.posttxn.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferImplProvider f53526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f53527b;

        c(MoneyTransferImplProvider moneyTransferImplProvider, String str) {
            this.f53526a = moneyTransferImplProvider;
            this.f53527b = str;
        }

        public final void onAnimationEnd(String str) {
            IStaticWidget a2 = this.f53526a.f53520b;
            if (a2 != null) {
                if (str == null) {
                    k.a();
                }
                a2.AnimateView(str);
            }
        }

        public final Point getFloatingWidgetPos(String str) {
            IStaticWidget a2 = this.f53526a.f53520b;
            if (a2 != null) {
                if (str == null) {
                    k.a();
                }
                Point viewPoint = a2.getViewPoint(str);
                if (viewPoint != null) {
                    return viewPoint;
                }
            }
            return new Point();
        }
    }

    public final void a(View view, String str, FragmentActivity fragmentActivity, RecyclerView recyclerView) {
        k.c(view, "view");
        k.c(str, "url");
        k.c(fragmentActivity, "fragmentActivity");
        k.c(recyclerView, "recyclerView");
        HashMap hashMap = new HashMap();
        hashMap.put("", "");
        SFInterface.INSTANCE.getStoreFrontReponse(str, hashMap, a.c.MONEYTRANSFER, new b(this, recyclerView, fragmentActivity, view), "", 1004, (IGAEnableListener) null);
    }

    public static final class b implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferImplProvider f53522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView f53523b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f53524c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f53525d;

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        b(MoneyTransferImplProvider moneyTransferImplProvider, RecyclerView recyclerView, FragmentActivity fragmentActivity, View view) {
            this.f53522a = moneyTransferImplProvider;
            this.f53523b = recyclerView;
            this.f53524c = fragmentActivity;
            this.f53525d = view;
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
                RecyclerView recyclerView = this.f53523b;
                j supportFragmentManager = this.f53524c.getSupportFragmentManager();
                k.a((Object) supportFragmentManager, "fragmentActivity.supportFragmentManager");
                MoneyTransferImplProvider.a((List) rvWidgets, recyclerView, supportFragmentManager, sanitizedResponseModel.getGaListener());
                MoneyTransferImplProvider.a(this.f53522a, (LinkedHashMap) sanitizedResponseModel.getSfWidgets(), this.f53525d, this.f53524c, sanitizedResponseModel.getGaListener());
            }
        }
    }

    public final void h() {
        e eVar = this.f53521c;
        if (eVar != null) {
            if (eVar == null) {
                k.a();
            }
            eVar.a();
        }
    }

    public final void d(Context context) {
        k.c(context, "context");
        net.one97.paytm.f.b.a().c();
        net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
        a2.f71389a = a.e.SEND_MONEY_SUMMARY;
        a2.f71391c = a.C1450a.SUCCESSFUL_TRANS;
        a2.a(context);
    }

    public final void a(Context context, String str, String str2, String str3, boolean z) {
        k.c(context, "context");
        k.c(str, "name");
        k.c(str2, ContactColumn.PHONE_NUMBER);
        k.c(str3, "amount");
        k.a aVar = z ? k.a.SCANNER : k.a.NONE;
        net.one97.paytm.wallet.d.k.a();
        net.one97.paytm.wallet.d.k.a(context, str, str2, (String) null, System.currentTimeMillis(), str3, CJRPGTransactionRequestUtils.PAYER_BANK_NAME, aVar);
    }

    public final void a(Fragment fragment, CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel) {
        kotlin.g.b.k.c(fragment, "fragment");
        kotlin.g.b.k.c(cJRMoneyTransferIMPSInitiateDataModel, "sendMoneyObj");
        Intent intent = new Intent(fragment.getContext(), VerifierBasicActivity.class);
        CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
        kotlin.g.b.k.a((Object) extraInfoDataModel, "sendMoneyObj.extraInfoDataModel");
        intent.putExtra("verifier_verifyID", extraInfoDataModel.getVerify_id());
        CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel2 = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
        kotlin.g.b.k.a((Object) extraInfoDataModel2, "sendMoneyObj.extraInfoDataModel");
        intent.putExtra("verifier_method", extraInfoDataModel2.getVerification_method());
        CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel3 = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
        kotlin.g.b.k.a((Object) extraInfoDataModel3, "sendMoneyObj.extraInfoDataModel");
        intent.putExtra("verifier_method_list", extraInfoDataModel3.getVerification_methods());
        fragment.startActivityForResult(intent, 2020);
    }

    public final void a(Activity activity, CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel) {
        kotlin.g.b.k.c(activity, "activity");
        kotlin.g.b.k.c(cJRMoneyTransferIMPSInitiateDataModel, "sendMoneyObj");
        Intent intent = new Intent(activity, VerifierBasicActivity.class);
        CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
        kotlin.g.b.k.a((Object) extraInfoDataModel, "sendMoneyObj.extraInfoDataModel");
        intent.putExtra("verifier_verifyID", extraInfoDataModel.getVerify_id());
        CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel2 = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
        kotlin.g.b.k.a((Object) extraInfoDataModel2, "sendMoneyObj.extraInfoDataModel");
        intent.putExtra("verifier_method", extraInfoDataModel2.getVerification_method());
        CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel3 = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
        kotlin.g.b.k.a((Object) extraInfoDataModel3, "sendMoneyObj.extraInfoDataModel");
        intent.putExtra("verifier_method_list", extraInfoDataModel3.getVerification_methods());
        activity.startActivityForResult(intent, 2020);
    }

    public final void a(Activity activity, Exception exc, String str) {
        kotlin.g.b.k.c(activity, "activity");
        kotlin.g.b.k.c(str, "targetClassName");
        r.a(activity, exc, str, (Bundle) null);
    }

    public final boolean a(Context context, Exception exc) {
        kotlin.g.b.k.c(context, "context");
        return r.a(context, exc);
    }

    public final void a(Activity activity, String str) {
        kotlin.g.b.k.c(activity, "activity");
        r.a(activity, str, (Bundle) null);
    }

    public final void a(Activity activity, String str, boolean z) {
        kotlin.g.b.k.c(activity, "activity");
        r.a(activity, str, (Bundle) null, true, z);
    }

    public final void b(String str, String str2) {
        kotlin.g.b.k.c(str, "className");
        kotlin.g.b.k.c(str2, "label");
        r.a(str, str2);
    }

    public final void a(Activity activity, SBMarkAsPaid sBMarkAsPaid) {
        kotlin.g.b.k.c(activity, "activity");
        net.one97.paytm.wallet.splitbill.e.b.a(activity, sBMarkAsPaid);
    }

    public final void e(Context context) {
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.wallet.d.j.a().a(context);
        RecentDataNetworkManager.uploadRecentPaymentsData(context);
    }

    public final void a(Activity activity, int i2) {
        kotlin.g.b.k.c(activity, "activity");
        Intent intent = new Intent();
        intent.setAction("fd_create_new_task");
        intent.putExtra("status", i2);
        ae aeVar = ae.f50307a;
        ae.a((Context) activity, intent);
    }

    public final String i() {
        return net.one97.paytm.payments.d.a.a() + "cash_wallet?featuretype=cash_ledger&tab=ica";
    }

    public final void a(Context context, Bundle bundle) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(bundle, "bundle");
        d.a(context, bundle, (m) null);
    }

    public final void a(Context context, a.c cVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cVar, "merchantResponseBody");
        Intent intent = new Intent(context, AJRQRActivity.class);
        intent.putExtra("OPERATION", "contact");
        intent.putExtra("mobile", cVar.f53980a);
        intent.putExtra("is_from_mobile_number", true);
        intent.putExtra("paysend_result", cVar.f53981b);
        context.startActivity(intent);
    }

    public final String j() {
        String name = TransparentActivity.class.getName();
        kotlin.g.b.k.a((Object) name, "TransparentActivity::class.java.name");
        return name;
    }

    public final void a(Context context, QrData qrData) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(qrData, "qrData");
        au.e eVar = new au.e();
        eVar.f69686a = qrData;
        au.a(eVar, "qrLog", context);
    }

    public static final /* synthetic */ void a(List list, RecyclerView recyclerView, j jVar, StoreFrontGAHandler storeFrontGAHandler) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new net.one97.paytm.moneytransfer.f.a(list, jVar, storeFrontGAHandler));
    }

    public static final /* synthetic */ void a(MoneyTransferImplProvider moneyTransferImplProvider, LinkedHashMap linkedHashMap, View view, FragmentActivity fragmentActivity, StoreFrontGAHandler storeFrontGAHandler) {
        IWidgetProvider iWidgetProvider = (IWidgetProvider) linkedHashMap.get(104);
        SFWidget widget = iWidgetProvider != null ? iWidgetProvider.getWidget(fragmentActivity, storeFrontGAHandler) : null;
        if (widget instanceof IStaticWidget) {
            IStaticWidget iStaticWidget = (IStaticWidget) widget;
            moneyTransferImplProvider.f53520b = iStaticWidget;
            if (view != null) {
                ((FrameLayout) view).addView(iStaticWidget.getView());
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
        }
    }

    public static final void k() {
        if (f53519d == null) {
            f53519d = new MoneyTransferImplProvider();
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            MoneyTransferImplProvider moneyTransferImplProvider = f53519d;
            if (moneyTransferImplProvider == null) {
                kotlin.g.b.k.a();
            }
            d.a.a(moneyTransferImplProvider);
        }
    }
}
