package net.one97.paytm.landingpage.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.y;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.filecache.FileCache;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gsonhtcfix.f;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.notification.g;
import com.paytm.paymentsettings.paytmassist.view.ui.PaytmAssistSettingsActivity;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.AJRAppLockSettingsActivity;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJRProfileActivity;
import net.one97.paytm.AJRScanSettingsActivity;
import net.one97.paytm.AJRScreenRecordingActivity;
import net.one97.paytm.AJRWebViewActivity;
import net.one97.paytm.DebugPreferenceActivity;
import net.one97.paytm.EmailMobileActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.b.e;
import net.one97.paytm.common.entity.CJRCatalogSavedState;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.offline.OfflineLeadOTPModel;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.m;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.dynamicModule.CommonDynamicFragment;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.googlenow.HttpPostService;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.c.h;
import net.one97.paytm.landingpage.fragment.BottomSheetPostpaidInterstitialFragment;
import net.one97.paytm.landingpage.fragment.FJRScanFragment;
import net.one97.paytm.landingpage.fragment.FJRUpdatesFragment;
import net.one97.paytm.landingpage.fragment.PBOpenBankAccountBottomSheetFragment;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.paymentslimit.activity.AJRPaymentLimitHomePageNew;
import net.one97.paytm.recharge.common.a.j;
import net.one97.paytm.recharge.common.activity.AJRMyPaymentsHistoryActivity;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.e;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticOptionListActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity;
import net.one97.paytm.savedPaymentItem.AJRSavedPaymentActivity;
import net.one97.paytm.smssdk.SmsSdkProviderImpl;
import net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity;
import net.one97.paytm.upgradeKyc.activity.PanUpdateActivity;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.f.c;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.KycPointServiceTriggerReciever;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.a.a;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.al;
import net.one97.paytm.utils.ao;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.bg;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.activity.AJRConfirmIFSCActivity;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.d.k;
import net.one97.paytm.wallet.newdesign.acceptmoney.InfoActivity;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import org.json.JSONException;
import org.json.JSONObject;

public class i implements e {

    /* renamed from: a  reason: collision with root package name */
    private h f53017a = $$Lambda$i$OMwrQkhH_RuKSVtVo1kIXUc4bQ.INSTANCE;

    public final String B() {
        return "?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE";
    }

    public final String E() {
        return "1k9fbjvjknqhxoikaesrvdi6vanz05n8hd3zzzomeku37snlwpfvmwg3nrpb96fav8x8ylsfrthkc3g121td3mcoemirju47k17nwz19y6inw4jh77avjl9s44r96w8obv3x8j20aikyl9w35xsk0ji7ru345djgyiznx7owxgdox6mt9i1l3oj2xa9jd15r5ironfnwsahomu8vs0lfb2mx6i7d31ep5gmuyvuklea7sh1oz0h0tew323c0p2xwfkfoj6n0y8y82zha9cw6wyc15o44vhyf8dgv8iynh1jd6o55kwg8c0d76kon953miztjg619zcprxovkl2b5wlwkeh8i8c3bt06egtjiv4hms72snrwuovaafpbxst3izw9wscf6fpt1hqqb3vgq0934blwdbclhb7h20omvlm91awdlcylmychylg3xauk4a3x4o8pbyddlwqs54q9nk17m16emj6i1kzv6fxygdke829wxwhq9dpo0hcb378tzs5lq0eus7w4scsu1g7qhtlhmybiz8fkfne6721ncry4s05qtmetmabet904a42o55ksoufeofym418ke3wtdz32gdt691upgp4j4ufe0wmgdczlue4ml2l4yl52wt54econ40fun2ynlmocks1wrq5vzg00ewm5btvmhmosmd6fm0fbvxerhhuxc66lzqe7ag4xutzu6fae8yg6czxcsfptxas01xiyfevdeq20h5bii4en98a76ifjqu1wdnqdhcsvxd64d65l4lgadyktsm66ij94orc4yemlr9n8kle0f41meezetawkkjdx5eoki4qeurw7tdvkoeqpwghdt";
    }

    public final String I() {
        return "net.one97.paytm.action.APP_LOCK_DISCARD";
    }

    public final int a(int i2) {
        return i2;
    }

    public final String g() {
        return "redirectTo";
    }

    public final boolean h() {
        return false;
    }

    public final String o() {
        return "720656";
    }

    public final long a() {
        c.a();
        return c.a("langSuggestionPopupShownMinTimeIntervalAndroid", TimeUnit.DAYS.toMillis(7));
    }

    public final String a(String str) {
        c.a();
        return c.a(str, (String) null);
    }

    public final void a(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, String str4) {
        j.a(str4, context, str, iJRDataModel, str2, i2, arrayList, z, str3);
    }

    public final void a(Activity activity) {
        if ((activity.getApplication() instanceof CJRJarvisApplication) && !d.b().w() && !b.L(activity.getApplicationContext()) && !a.p(activity.getApplicationContext())) {
            d.b().b(activity);
        }
    }

    public final Intent a(Context context) {
        return new Intent(context.getApplicationContext(), EmailMobileActivity.class);
    }

    public final String b(Context context) {
        return t.b(context);
    }

    public final void b() {
        CJRJarvisApplication.a((CJRUrlUtmData) null);
    }

    public final Intent c(Context context) {
        net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
        return net.one97.paytm.wallet.utility.d.b((Activity) context);
    }

    public final boolean d(Context context) {
        return net.one97.paytm.utils.a.b.d(context) == net.one97.paytm.utils.a.ISSUED;
    }

    public final Intent e(Context context) {
        return new Intent(context, AJRAuthActivity.class);
    }

    public final Intent f(Context context) {
        return new Intent(context, MinKycPanAadharUpgradeActivity.class);
    }

    public final int b(String str) {
        c.a();
        return c.a(str, 0);
    }

    public final void c() {
        net.one97.paytm.marketplace.a.i();
    }

    public final boolean b(String str, String str2) {
        return net.one97.paytm.marketplace.a.b(str, str2);
    }

    public final ArrayList<CJRSearchLayout> d() {
        return net.one97.paytm.marketplace.a.b();
    }

    public final void a(Activity activity, CJRSearchLayout cJRSearchLayout) {
        net.one97.paytm.marketplace.a.a(activity, cJRSearchLayout);
    }

    public final void e() {
        net.one97.paytm.marketplace.a.c();
    }

    public final String a(String str, String str2) {
        return net.one97.paytm.marketplace.a.c(str, str2);
    }

    public final void a(AppCompatActivity appCompatActivity) {
        bg.a(appCompatActivity);
    }

    public final boolean g(Context context) {
        c.a();
        if (!c.a("shouldRunKycNearByService", true)) {
            return false;
        }
        if (net.one97.paytm.upgradeKyc.utils.j.b(context) == 0 || "otp".equalsIgnoreCase(net.one97.paytm.upgradeKyc.utils.j.c(context)) || (net.one97.paytm.upgradeKyc.utils.j.b(context) == 0 && net.one97.paytm.upgradeKyc.utils.j.j(context))) {
            return true;
        }
        return false;
    }

    public final boolean h(Context context) {
        return net.one97.paytm.upgradeKyc.utils.j.b(context) == 1;
    }

    public final void i(Context context) {
        Intent intent = new Intent(context, KycPointServiceTriggerReciever.class);
        intent.setAction("KycPointServiceTriggerReciever");
        if (!(PendingIntent.getBroadcast(context, 9999, intent, 536870912) != null)) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 9999, intent, 134217728);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setAndAllowWhileIdle(0, new Date().getTime() + 900000, broadcast);
            } else {
                alarmManager.setRepeating(0, Calendar.getInstance().getTimeInMillis() + 900000, FileCache.EXPIRE_TIME, broadcast);
            }
        }
    }

    public final void j(Context context) {
        Intent intent = new Intent(context, KycPointServiceTriggerReciever.class);
        if (PendingIntent.getBroadcast(context, 9999, intent, 536870912) != null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 9999, intent, 134217728);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                try {
                    alarmManager.cancel(broadcast);
                    broadcast.cancel();
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public final Intent b(Activity activity) {
        return new Intent(activity, AJRAuthActivity.class);
    }

    public final void a(String str, String str2, Activity activity) {
        net.one97.paytm.j.a.b(str, str2, (Context) activity);
    }

    public final Fragment f() {
        Bundle bundle = new Bundle();
        String g2 = d.a().g();
        d.a();
        bundle.putInt(g2, 100);
        return CommonDynamicFragment.newInstance(bundle, "ddbase", "net.one97.paytm.dynamic.module.bank.BankInitFragment", "");
    }

    public final Fragment i() {
        return new FJRScanFragment();
    }

    public final Fragment j() {
        return new FJRUpdatesFragment();
    }

    public final Fragment a(Bundle bundle) {
        return net.one97.paytm.marketplace.a.a(bundle);
    }

    public final void F(Context context) {
        l.c(context, true);
    }

    public final boolean k(Context context) {
        return net.one97.paytm.utils.a.b.a(context);
    }

    public final Intent l(Context context) {
        return new Intent(context, AJRProfileActivity.class);
    }

    public final boolean m(Context context) {
        return net.one97.paytm.upgradeKyc.utils.j.d(context) == 1;
    }

    public final void c(Activity activity) {
        net.one97.paytm.wallet.newdesign.a.a();
        net.one97.paytm.wallet.newdesign.a.a(activity, new String[0]);
    }

    public final void a(Item item, int i2, String str, String str2, Context context) {
        if (context != null) {
            if (str2 != null) {
                item.setContainerinstatnceid(str2);
            } else {
                item.setContainerinstatnceid("");
            }
            net.one97.paytm.j.a.e((CJRHomePageItem) new f().a(new com.google.gson.f().b(item), CJRHomePageItem.class), context, i2, str + "-");
        }
    }

    public final Intent n(Context context) {
        return new Intent(context, InfoActivity.class);
    }

    public final Intent d(Activity activity) {
        return new Intent(activity, UpgradeKycActivity.class);
    }

    public final void a(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void a(Context context, CJRQRScanResultModel cJRQRScanResultModel) {
        Intent intent = new Intent();
        intent.putExtra("NAME", cJRQRScanResultModel.getName());
        intent.putExtra("PHONE_NUMBER", cJRQRScanResultModel.getMobileNo());
        intent.putExtra("MODE", "RECENT_SCAN");
        net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
        a2.f71392d = a.c.QR_SCAN_PAYTM_P2P;
        a2.f71394f = H5AppHandler.CHECK_VALUE;
        net.one97.paytm.wallet.utility.a.a(intent, (Activity) context);
    }

    public final void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, AJRQRActivity.class);
        intent.putExtra("OPERATION", "scan");
        intent.putExtra("scan_result", str);
        intent.putExtra("QR_CODE_ID", str2);
        context.startActivity(intent);
    }

    public final int o(Context context) {
        return net.one97.paytm.upgradeKyc.utils.j.b(context);
    }

    public final int p(Context context) {
        return net.one97.paytm.upgradeKyc.utils.j.d(context);
    }

    public final Map<String, String> q(Context context) {
        return t.e(context);
    }

    public final String c(String str) {
        return net.one97.paytm.wallet.newdesign.a.a(str);
    }

    public final Intent r(Context context) {
        return new Intent(context, AJRConfirmIFSCActivity.class);
    }

    public final boolean d(String str) {
        return net.one97.paytm.wallet.utility.a.e(str);
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public final String e(String str) {
        return net.one97.paytm.wallet.utility.a.a(str);
    }

    public final String a(Activity activity, String str) {
        return net.one97.paytm.wallet.utility.a.a(activity, str);
    }

    public final void a(Context context, String str) {
        net.one97.paytm.wallet.utility.a.d(context, str);
    }

    public final void a(Intent intent, Activity activity) {
        net.one97.paytm.wallet.utility.a.a(intent, activity);
    }

    public final void a(Context context, String str, ArrayList<String> arrayList) {
        net.one97.paytm.j.a.a(context, "my_payments", str, arrayList, (String) null, "/personal-payments/success", "homescreen");
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, Activity activity, int i2) {
        activity.startActivity(new Intent(activity, AJRMyPaymentsHistoryActivity.class).setFlags(603979776).putExtra("selected_payment", cJRFrequentOrder).putExtra("extra_intent_item_position", i2));
    }

    public final String a(String str, String str2, boolean z) {
        c.a();
        return c.a(str, str2, z);
    }

    public final String a(Context context, CJRFrequentOrder cJRFrequentOrder) {
        return ab.a(context, cJRFrequentOrder.getConfiguration().get("recharge_number"));
    }

    public final String a(Double d2) {
        return ba.a(d2);
    }

    public final String a(Context context, String str, CJRBillDetails cJRBillDetails) {
        return ba.a(context, str, cJRBillDetails, j.a.PREPAID);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, Context context) {
        ba.a(cJRFrequentOrder, context);
    }

    public final int f(String str) {
        return ba.c(str);
    }

    public final CJRBillDetails a(CJRBillDetails cJRBillDetails) {
        return ba.a(cJRBillDetails, CJRJarvisApplication.getAppContext());
    }

    public final CJRFrequentOrderList k() {
        return ((CJRJarvisApplication) CJRJarvisApplication.getAppContext()).f49005a;
    }

    public final void a(Context context, StandingInstructionList standingInstructionList) {
        SQLiteDatabase sQLiteDatabase;
        net.one97.paytm.wallet.newdesign.a.a a2 = net.one97.paytm.wallet.newdesign.a.a.a(context);
        if (!a2.b()) {
            sQLiteDatabase = a2.a();
        } else {
            sQLiteDatabase = a2.f70458a;
        }
        sQLiteDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", standingInstructionList.getId());
            contentValues.put("quick_pay_details", new com.google.gson.f().b(standingInstructionList));
            sQLiteDatabase.insertWithOnConflict("quick_pay", "id", contentValues, 5);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|(2:14|15)|16|17|(1:21)|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<net.one97.paytm.common.entity.quick_pay.StandingInstructionList> s(android.content.Context r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            net.one97.paytm.wallet.newdesign.a.a r6 = net.one97.paytm.wallet.newdesign.a.a.a(r6)
            boolean r1 = r6.b()
            if (r1 != 0) goto L_0x0014
            android.database.sqlite.SQLiteDatabase r6 = r6.a()
            goto L_0x0016
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r6 = r6.f70458a
        L_0x0016:
            java.lang.String r1 = "SELECT * FROM quick_pay"
            r2 = 0
            r3 = 0
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0087 }
            android.database.Cursor r2 = r6.rawQuery(r1, r4)     // Catch:{ Exception -> 0x0087 }
            int r6 = r2.getCount()     // Catch:{ Exception -> 0x0087 }
            if (r6 <= 0) goto L_0x0027
            r3 = 1
        L_0x0027:
            if (r3 == 0) goto L_0x008f
            boolean r6 = r2.moveToFirst()     // Catch:{ Exception -> 0x0087 }
            if (r6 == 0) goto L_0x008f
        L_0x002f:
            java.lang.String r6 = "id"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087 }
            r2.getString(r6)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = "quick_pay_details"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ Exception -> 0x0087 }
            com.google.gson.f r1 = new com.google.gson.f     // Catch:{ Exception -> 0x0087 }
            r1.<init>()     // Catch:{ Exception -> 0x0087 }
            java.lang.Class<net.one97.paytm.common.entity.quick_pay.StandingInstructionList> r3 = net.one97.paytm.common.entity.quick_pay.StandingInstructionList.class
            java.lang.Object r6 = r1.a((java.lang.String) r6, r3)     // Catch:{ Exception -> 0x0087 }
            net.one97.paytm.common.entity.quick_pay.StandingInstructionList r6 = (net.one97.paytm.common.entity.quick_pay.StandingInstructionList) r6     // Catch:{ Exception -> 0x0087 }
            java.lang.String r1 = r6.getAmount()     // Catch:{ Exception -> 0x0087 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0087 }
            if (r3 != 0) goto L_0x0065
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ NumberFormatException -> 0x0065 }
            long r3 = (long) r3     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0065 }
            r6.setAmount(r1)     // Catch:{ NumberFormatException -> 0x0065 }
        L_0x0065:
            java.lang.String r1 = r6.getStatus()     // Catch:{ Exception -> 0x0087 }
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = r6.getStatus()     // Catch:{ Exception -> 0x0087 }
            net.one97.paytm.quickpay.utilities.i r3 = net.one97.paytm.quickpay.utilities.i.DEACTIVATE     // Catch:{ Exception -> 0x0087 }
            java.lang.String r3 = r3.getStatus()     // Catch:{ Exception -> 0x0087 }
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0087 }
            if (r1 != 0) goto L_0x007e
        L_0x007b:
            r0.add(r6)     // Catch:{ Exception -> 0x0087 }
        L_0x007e:
            boolean r6 = r2.moveToNext()     // Catch:{ Exception -> 0x0087 }
            if (r6 != 0) goto L_0x002f
            goto L_0x008f
        L_0x0085:
            r6 = move-exception
            goto L_0x0096
        L_0x0087:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0085 }
            com.paytm.utility.q.b(r6)     // Catch:{ all -> 0x0085 }
        L_0x008f:
            a((android.database.Cursor) r2)
            java.util.Collections.reverse(r0)
            return r0
        L_0x0096:
            a((android.database.Cursor) r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.i.s(android.content.Context):java.util.ArrayList");
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

    public final void b(Context context, String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            net.one97.paytm.wallet.newdesign.a.a a2 = net.one97.paytm.wallet.newdesign.a.a.a(context);
            if (!a2.b()) {
                sQLiteDatabase = a2.a();
            } else {
                sQLiteDatabase = a2.f70458a;
            }
            q.a("count::".concat(String.valueOf(sQLiteDatabase.delete(str, (String) null, (String[]) null))));
        } catch (Exception unused) {
        }
    }

    public final StandingInstructionList c(Context context, String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        net.one97.paytm.wallet.newdesign.a.a a2 = net.one97.paytm.wallet.newdesign.a.a.a(context);
        if (!a2.b()) {
            sQLiteDatabase = a2.a();
        } else {
            sQLiteDatabase = a2.f70458a;
        }
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM quick_pay WHERE id='" + str + "'", (String[]) null);
            try {
                if ((cursor.getCount() > 0) && cursor.moveToFirst()) {
                    cursor.getString(cursor.getColumnIndex("id"));
                    StandingInstructionList standingInstructionList = (StandingInstructionList) new com.google.gson.f().a(cursor.getString(cursor.getColumnIndex("quick_pay_details")), StandingInstructionList.class);
                    String amount = standingInstructionList.getAmount();
                    if (!TextUtils.isEmpty(amount)) {
                        try {
                            standingInstructionList.setAmount(String.valueOf((long) Double.parseDouble(amount)));
                        } catch (NumberFormatException unused) {
                        }
                    }
                    a(cursor);
                    return standingInstructionList;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.b(e.getMessage());
                    a(cursor);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    a(cursor);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.b(e.getMessage());
            a(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            a(cursor);
            throw th;
        }
        a(cursor);
        return null;
    }

    public final Context t(Context context) {
        return net.one97.paytm.locale.b.e.a(context);
    }

    public final String l() {
        c.a();
        return c.t();
    }

    public final Intent f(Activity activity) {
        return new Intent(activity, AJREmbedWebView.class);
    }

    public final void a(CJRCatalogSavedState cJRCatalogSavedState) {
        ((CJRJarvisApplication) CJRJarvisApplication.getAppContext()).f49006b = cJRCatalogSavedState;
    }

    public final void a(Context context, final net.one97.paytm.landingpage.c.b bVar) {
        net.one97.paytm.upgradeKyc.f.c.a().a(context, (c.b) new c.b() {
            public final void onNameInitialize(String str) {
                net.one97.paytm.landingpage.c.b bVar = bVar;
                if (bVar != null) {
                    bVar.a(str);
                }
            }

            public final void onNameInitializationError(String str) {
                net.one97.paytm.landingpage.c.b bVar = bVar;
                if (bVar != null) {
                    bVar.b(str);
                }
            }
        });
    }

    public final void a(CJRCatalog cJRCatalog) {
        CJRJarvisApplication.getAppContext();
        CJRJarvisApplication.a(cJRCatalog);
    }

    public final String m() {
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.j.c.a();
        sb.append(net.one97.paytm.j.c.w());
        sb.append("?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE,password_status,kyc_state");
        return sb.toString();
    }

    public final Map<String, String> u(Context context) {
        return t.f(context);
    }

    public final void g(Activity activity) {
        net.one97.paytm.account.a.a(activity);
    }

    public final String n() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("min_kyc_status_v3_url", (String) null);
    }

    public final void a(Activity activity, String str, final net.one97.paytm.landingpage.c.d dVar) {
        net.one97.paytm.wallet.d.d.a((Context) activity, str, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                dVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                dVar.a(networkCustomError);
            }
        });
    }

    public final void a(Activity activity, final net.one97.paytm.landingpage.c.d dVar) {
        net.one97.paytm.moneytransfer.utils.h.a(activity, new Response.Listener<IJRPaytmDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                dVar.a((IJRPaytmDataModel) obj);
            }
        }, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                dVar.a(new NetworkCustomError());
            }
        }, 0, 25);
    }

    public final ArrayList<IJRDataModel> h(Activity activity) {
        k.a();
        return k.a(activity);
    }

    public final void b(String str, String str2, Activity activity) {
        net.one97.paytm.j.a.a(str, str2, (Context) activity);
    }

    public final void a(String str, String str2, String str3, String str4, final net.one97.paytm.landingpage.c.e eVar) {
        g.c().a(new a.C1402a() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                eVar.a(upiBaseDataModel);
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                net.one97.paytm.landingpage.c.e eVar = eVar;
                new f();
                eVar.a();
            }
        }, str3, str4, str, str2);
    }

    public final void a(Context context, OfflineLeadOTPModel offlineLeadOTPModel) {
        if (offlineLeadOTPModel.status.equalsIgnoreCase("success")) {
            WalletSharedPrefs.INSTANCE.storeOfflineCounterCachedTime(context, System.currentTimeMillis());
            WalletSharedPrefs.INSTANCE.storeUserDeviceMap(context, offlineLeadOTPModel.ud_map);
            WalletSharedPrefs.INSTANCE.storeCGCPHeader(context, offlineLeadOTPModel.cgcp_offline_header);
            if (offlineLeadOTPModel.otp_config != null) {
                WalletSharedPrefs.INSTANCE.storeServerTime(context, offlineLeadOTPModel.otp_config.epoch_time);
                WalletSharedPrefs.INSTANCE.storeOfflineTimeCounter(context, (long) offlineLeadOTPModel.otp_config.time_interval);
            }
        }
    }

    public final void a(CJRFrequentOrderList cJRFrequentOrderList) {
        ((CJRJarvisApplication) CJRJarvisApplication.getAppContext()).f49005a = cJRFrequentOrderList;
    }

    public final void a(CJRShoppingCart cJRShoppingCart, Context context) {
        t.b(context, cJRShoppingCart.getCart().getFinalPrice());
        t.a(context, cJRShoppingCart.getCart().getCartItems().size());
        t.a(context, cJRShoppingCart.getCart().getmCartId());
        new StringBuilder("cart id ").append(cJRShoppingCart.getCart().getmCartId());
        com.paytm.utility.a.c();
    }

    public final CJRCatalog q() {
        CJRJarvisApplication.getAppContext();
        return CJRJarvisApplication.k();
    }

    public final void r() {
        net.one97.paytm.wallet.f.d.a().f70361a = null;
    }

    public final Intent i(Activity activity) {
        return new Intent(activity, net.one97.paytm.marketplace.a.g());
    }

    public final boolean v(Context context) {
        return context instanceof AJRAuthActivity;
    }

    public final boolean w(Context context) {
        return context instanceof AJRRechargeActivity;
    }

    public final boolean x(Context context) {
        return context instanceof AJRCouponsActivityV8;
    }

    public final boolean y(Context context) {
        return context instanceof AJRRechargeUtilityActivity;
    }

    public final boolean z(Context context) {
        return context instanceof AJREmbedWebView;
    }

    public final Class<?> p() {
        return net.one97.paytm.marketplace.a.j();
    }

    public final void A(Context context) {
        WalletSharedPrefs.INSTANCE.resetUserDetailV2CachedTime(context);
    }

    public final void a(CJRUserInfoV2 cJRUserInfoV2, Context context) {
        l.a(cJRUserInfoV2, context);
    }

    public final void b(CJRUserInfoV2 cJRUserInfoV2, Context context) {
        ArrayList<String> userTypes = cJRUserInfoV2.getUserTypes();
        if (userTypes == null || userTypes.size() <= 0) {
            l.a(context, false);
            l.b(context, false);
            return;
        }
        if (userTypes.contains("PRIME_USER")) {
            l.a(context, true);
        } else {
            l.a(context, false);
        }
        if (userTypes.contains("POSTPAID_USER")) {
            l.b(context, true);
        } else {
            l.b(context, false);
        }
    }

    public final void a(KYCStatusV2 kYCStatusV2, Context context) {
        if (!TextUtils.isEmpty(kYCStatusV2.getExpiryType())) {
            net.one97.paytm.upgradeKyc.utils.j.g(d.b().a(), kYCStatusV2.getExpiryType());
        }
        net.one97.paytm.upgradeKyc.utils.j.c(context.getApplicationContext(), kYCStatusV2.isAadharVerified());
        net.one97.paytm.upgradeKyc.utils.j.a(context.getApplicationContext(), kYCStatusV2.isMinKycStatus());
        net.one97.paytm.upgradeKyc.utils.j.a(context.getApplicationContext(), kYCStatusV2.getIsKycDone());
        net.one97.paytm.upgradeKyc.utils.j.b(context.getApplicationContext(), kYCStatusV2.isMinKycEligible());
        if (kYCStatusV2.isKycExpired() == 0 || kYCStatusV2.isKycExpired() == 1) {
            net.one97.paytm.upgradeKyc.utils.j.b(context.getApplicationContext(), kYCStatusV2.isKycExpired());
        } else {
            net.one97.paytm.upgradeKyc.utils.j.b(context.getApplicationContext(), 0);
        }
        if (!TextUtils.isEmpty(kYCStatusV2.getKycExpiryTime())) {
            net.one97.paytm.upgradeKyc.utils.j.d(d.b().a(), b.h(kYCStatusV2.getKycExpiryTime(), "dd/MM/yyyy", "dd MMM yyyy"));
        }
        if (!TextUtils.isEmpty(kYCStatusV2.getKycType())) {
            net.one97.paytm.upgradeKyc.utils.j.c(context.getApplicationContext(), kYCStatusV2.getKycType());
        }
        if (!TextUtils.isEmpty(kYCStatusV2.getIsMinor())) {
            net.one97.paytm.upgradeKyc.utils.j.e(context.getApplicationContext(), kYCStatusV2.getIsMinor());
        }
    }

    public final void a(CustProductList custProductList, Context context, net.one97.paytm.landingpage.c.g gVar) {
        if (com.paytm.utility.a.p(d.b().a())) {
            net.one97.paytm.j.c.a();
            if (net.one97.paytm.j.c.a("paytmPaymentBankEnabled", false) && !TextUtils.isEmpty(custProductList.getIsaStatus())) {
                if (custProductList.getIsaStatus().equals("NOT_APPLIED") || custProductList.getIsaStatus().equals("LEAD")) {
                    net.one97.paytm.payments.d.a.a(context, "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=3");
                    net.one97.paytm.utils.a.b.b(CJRJarvisApplication.getAppContext(), net.one97.paytm.utils.a.NOT_APPLIED.getNumVal());
                } else if (custProductList.getIsaStatus().equals("FAILED") || custProductList.getIsaStatus().equals("IN_PROGRESS") || custProductList.getIsaStatus().equals("INITIATED") || custProductList.getIsaStatus().equals("PENDING")) {
                    net.one97.paytm.payments.d.a.a(context, "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=6");
                    net.one97.paytm.utils.a.b.b(CJRJarvisApplication.getAppContext(), net.one97.paytm.utils.a.PROCESSING.getNumVal());
                } else if (custProductList.getIsaStatus().equals("ISSUED")) {
                    net.one97.paytm.utils.a.b.b(CJRJarvisApplication.getAppContext(), net.one97.paytm.utils.a.ISSUED.getNumVal());
                    gVar.d();
                }
            }
        }
    }

    public final boolean a(Context context, int i2) {
        return net.one97.paytm.upgradeKyc.utils.j.c(context, i2);
    }

    public final void s() {
        net.one97.paytm.upgradeKyc.utils.j.d();
    }

    public final void a(androidx.fragment.app.j jVar) {
        net.one97.paytm.upgradeKyc.d.e eVar = new net.one97.paytm.upgradeKyc.d.e();
        if (!jVar.i() && !eVar.isAdded()) {
            ao.a(i.class, "openKycExpiredBottomSheet");
            eVar.show(jVar, eVar.getTag());
        }
    }

    public final void a(Context context, androidx.fragment.app.j jVar, KYCStatusV2 kYCStatusV2) {
        if (kYCStatusV2.isMinKycStatus() && kYCStatusV2.getIsKycDone() == 0 && kYCStatusV2.getFailSafeKey().equalsIgnoreCase("1")) {
            net.one97.paytm.j.c.a();
            if (net.one97.paytm.j.c.a("full_kyc_pop_up_visiblity_v2", false)) {
                net.one97.paytm.j.c.a();
                int a2 = net.one97.paytm.j.c.a("full_kyc_pop_up_n", 0);
                int b2 = net.one97.paytm.common.utility.i.a(context.getApplicationContext()).b("full_kyc_pop_n", -1, false);
                boolean z = true;
                if (b2 == -1) {
                    net.one97.paytm.upgradeKyc.utils.j.b();
                } else if (b2 == a2) {
                    net.one97.paytm.common.utility.i.a(context.getApplicationContext()).a("full_kyc_pop_n", 0, false);
                } else {
                    z = false;
                }
                if (z) {
                    ao.a(i.class, "openFullKycBottomSheet");
                    net.one97.paytm.upgradeKyc.d.a aVar = new net.one97.paytm.upgradeKyc.d.a();
                    aVar.show(jVar, aVar.getTag());
                    return;
                }
                net.one97.paytm.upgradeKyc.utils.j.b();
            }
        }
    }

    public final void b(Context context, androidx.fragment.app.j jVar, KYCStatusV2 kYCStatusV2) {
        if (net.one97.paytm.upgradeKyc.utils.j.d(d.b().a()) == 0 && !TextUtils.isEmpty(kYCStatusV2.getKycExpiryTime())) {
            net.one97.paytm.j.c.a();
            int a2 = net.one97.paytm.j.c.a("numOfDaysToAddExpiry", 15);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            Calendar instance = Calendar.getInstance();
            instance.add(5, a2);
            if (al.a(simpleDateFormat.format(new Date(instance.getTimeInMillis())), kYCStatusV2.getKycExpiryTime())) {
                net.one97.paytm.j.c.a();
                if (net.one97.paytm.j.c.a("kycExpiredPopUpVisibility", true)) {
                    net.one97.paytm.j.c.a();
                    if (net.one97.paytm.upgradeKyc.utils.j.c(context, net.one97.paytm.j.c.a("kycExpiredPopUpNAndroid", 1))) {
                        a(jVar);
                        return;
                    }
                }
                d.a().s();
            }
        }
    }

    public final void B(Context context) {
        try {
            ao.a(i.class, "showSelectBankDialog");
            net.one97.paytm.j.c.a();
            if (!TextUtils.isEmpty(net.one97.paytm.j.c.I())) {
                net.one97.paytm.j.c.a();
                String[] split = net.one97.paytm.j.c.I().split(AppConstants.COMMA);
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt > 0 && parseInt2 > 0) {
                    net.one97.paytm.landingpage.activity.a.a(context, (parseInt * 24) / parseInt2);
                    net.one97.paytm.landingpage.activity.a.a(context, this.f53017a);
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Y() {
        try {
            BottomSheetPostpaidInterstitialFragment newInstance = BottomSheetPostpaidInterstitialFragment.newInstance();
            if (newInstance != null && newInstance.isPostpaidPopupShown()) {
                if (newInstance.isAdded() && newInstance.isVisible()) {
                    newInstance.dismiss();
                }
                com.paytm.b.a.a a2 = ag.a(d.b().a());
                a2.a("postpaid_popup_display_count", a2.b("postpaid_popup_display_count", 0, true) - 1, true);
                newInstance.setPostpaidPopupShown(false);
            }
        } catch (Exception unused) {
        }
    }

    public final boolean a(Fragment fragment) {
        return fragment instanceof FJRUpdatesFragment;
    }

    public final void t() {
        net.one97.paytm.upgradeKyc.utils.j.a();
    }

    public final void C(Context context) {
        l.b(context);
    }

    public final void D(Context context) {
        l.c(context);
    }

    public final void u() {
        net.one97.paytm.wallet.f.d.a().b();
    }

    public final void v() {
        ae aeVar = ae.f50307a;
        if (ae.a() != null) {
            ae aeVar2 = ae.f50307a;
            ae.a().logoutBank();
        }
    }

    public final void w() {
        net.one97.paytm.marketplace.a.h();
    }

    public final void a(Fragment fragment, int i2, Intent intent) {
        if (fragment != null) {
            fragment.onActivityResult(i2, -1, intent);
        }
    }

    public final void a(Context context, androidx.fragment.app.j jVar) {
        Class<i> cls = i.class;
        ao.a(cls, "checkAnShowBankAccOpenPopup");
        net.one97.paytm.j.c.a();
        if (net.one97.paytm.j.c.a("showOpenBankAccPopupFrequency", 0) == 0) {
            return;
        }
        if (net.one97.paytm.utils.a.b.d(context).getNumVal() != net.one97.paytm.utils.a.ISSUED.getNumVal()) {
            ag.a(context.getApplicationContext()).a("show_open_bank_acc_bottom_sheet_count", 1, true);
            ao.a(cls, "openBankAccountPopup");
            new PBOpenBankAccountBottomSheetFragment().show(jVar, "bottomSheetDialogFragment");
            return;
        }
        com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
        a2.a("show_open_bank_acc_bottom_sheet_count", a2.b("show_open_bank_acc_bottom_sheet_count", 1, true) + 1, true);
    }

    public final int x() {
        g.c cVar = com.paytm.notification.g.f43191a;
        return g.c.a();
    }

    public final boolean y() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("isSetPasswordMandatory", false);
    }

    public final void a(androidx.fragment.app.j jVar, final net.one97.paytm.landingpage.c.c cVar) {
        OauthModule.a(jVar, (net.one97.paytm.oauth.e.h) new net.one97.paytm.oauth.e.h() {
            public final void a() {
                cVar.e();
            }
        });
    }

    public final boolean z() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("enable_upi_pay_request_dialog_v2", true);
    }

    public final boolean A() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("min_kyc_pop_up_mandate", false);
    }

    public final void b(androidx.fragment.app.j jVar, final net.one97.paytm.landingpage.c.c cVar) {
        OauthModule.a(jVar, new net.one97.paytm.oauth.e.h() {
            public final void a() {
                cVar.e();
            }
        }, (net.one97.paytm.oauth.e.i) null, false, true);
    }

    public final String a(CJRFrequentOrder cJRFrequentOrder, String str) {
        return l.a(cJRFrequentOrder, str);
    }

    public final boolean a(IJRDataModel iJRDataModel, Context context) {
        if (iJRDataModel instanceof RecentSendMoney) {
            RecentSendMoney recentSendMoney = (RecentSendMoney) iJRDataModel;
            Intent intent = new Intent();
            intent.putExtra("NAME", recentSendMoney.getName());
            intent.putExtra("PHONE_NUMBER", recentSendMoney.getName());
            intent.putExtra("MODE", "RECENT_SCAN");
            net.one97.paytm.wallet.utility.a.a(intent, (Activity) context);
            return true;
        } else if (!(iJRDataModel instanceof RecentScan)) {
            return false;
        } else {
            RecentScan recentScan = (RecentScan) iJRDataModel;
            try {
                String scanResult = recentScan.getScanResult();
                JSONObject jSONObject = new JSONObject(scanResult);
                jSONObject.remove("ORDER_ID");
                if (!com.paytm.utility.a.p(context)) {
                    Intent c2 = d.a().c(context);
                    c2.putExtra("dest", "qr_send_money");
                    c2.putExtra("qr_scan_result", scanResult);
                    context.startActivity(c2);
                } else {
                    String uniqKey = recentScan.getUniqKey();
                    String jSONObject2 = jSONObject.toString();
                    CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                    try {
                        cJRQRScanResultModel.parseData(new JSONObject(jSONObject2), context);
                    } catch (JSONException e2) {
                        q.b(e2.getMessage());
                    }
                    if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(cJRQRScanResultModel.getRequestType())) {
                        a(context, cJRQRScanResultModel);
                    } else {
                        a(context, jSONObject2, cJRQRScanResultModel.getQrCodeId());
                    }
                    if (!TextUtils.isEmpty(uniqKey) && uniqKey.length() == 24) {
                        d.a().a(context, uniqKey);
                    }
                }
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
            return true;
        }
    }

    public final void j(Activity activity) {
        Intent intent = new Intent(activity, AJREmbedWebView.class);
        intent.putExtra("url", "https://dg-static1.paytm.com/weex/tnc_html.html");
        intent.putExtra("title", "Postpaid Terms & Condition");
        intent.putExtra("postpaidWebViewTitle", "Postpaid Terms & Condition");
        intent.putExtra(UpiConstants.FROM, "");
        intent.putExtra("Maintenance", false);
        intent.putExtra("maintaince_error_503", false);
        intent.putExtra("Close", false);
        intent.putExtra("alert_title", "");
        intent.putExtra("alert_message", "");
        activity.startActivity(intent);
    }

    public final void b(Activity activity, String str) {
        Intent intent = new Intent(activity, AJREmbedWebView.class);
        intent.putExtra("url", str);
        intent.putExtra(UpiConstants.FROM, "");
        intent.putExtra("Maintenance", false);
        intent.putExtra("maintaince_error_503", false);
        intent.putExtra("Close", false);
        intent.putExtra("alert_title", "");
        intent.putExtra("alert_message", "");
        activity.startActivity(intent);
    }

    public final void a(AJRMainActivity aJRMainActivity) {
        Intent intent = new Intent();
        intent.setAction("set_passcode");
        ae aeVar = ae.f50307a;
        ae.a((Context) aJRMainActivity, intent);
    }

    public final CJRUserInfoV2 a(CJRUserInfo cJRUserInfo) {
        return l.a(cJRUserInfo);
    }

    public final void E(Context context) {
        m.a aVar;
        m mVar = m.f50358c;
        if (DynamicModuleManager.getInstance().isInstalled("feed")) {
            m.b(context);
            if (context != null && (aVar = m.f50356a) != null) {
                aVar.onUserProfileUpdate(context);
            }
        }
    }

    public final Intent a(FragmentActivity fragmentActivity) {
        return new Intent(fragmentActivity, AJRWebViewActivity.class);
    }

    public final Intent b(FragmentActivity fragmentActivity) {
        return new Intent(fragmentActivity, PanUpdateActivity.class);
    }

    public final String C() {
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        d.a.a();
        return net.one97.paytm.upgradeKyc.helper.d.a("keyKycRbiDirectiveUrl");
    }

    public final Context D() {
        e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        return e.a.b().a();
    }

    public final void a(Context context, net.one97.paytm.common.b.c cVar) {
        net.one97.paytm.utils.a.a a2 = net.one97.paytm.utils.a.a.a();
        cVar.getClass();
        $$Lambda$KEcOSUlfOTfZUYSjrdiO4zFr3Us r1 = new a.b() {
            public final void onBankStatus(int i2, String str) {
                net.one97.paytm.common.b.c.this.a(Integer.valueOf(i2), str);
            }
        };
        Context applicationContext = context.getApplicationContext();
        a2.f69594a = r1;
        if (!net.one97.paytm.utils.a.b.b(applicationContext) || TextUtils.isEmpty(a2.f69595b)) {
            a2.f69595b = null;
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", a2.getClass().getSimpleName());
            com.paytm.network.a a3 = net.one97.paytm.payments.b.a.a.a(context, a2, a.c.PAY, a.b.SILENT, hashMap);
            if (com.paytm.utility.a.m(context)) {
                a3.a();
            }
        } else if (a2.f69594a != null) {
            a2.f69594a.onBankStatus(net.one97.paytm.utils.a.ISSUED.getNumVal(), a2.f69595b);
            a2.f69594a = null;
        }
    }

    public final void a(Context context, Bundle bundle) {
        net.one97.paytm.deeplink.d.a(context, bundle);
    }

    public final void b(androidx.fragment.app.j jVar) {
        OauthModule.b().checkSignUpReminder(jVar);
    }

    public final void a(androidx.fragment.app.j jVar, Activity activity) {
        OauthModule.b().checkSimCardChanged(jVar, activity);
    }

    public final void a(Context context, Intent intent) {
        ae aeVar = ae.f50307a;
        ae.a(context, intent);
    }

    public final void a(String str, String str2, String str3) {
        au.e eVar = new au.e();
        au.b bVar = new au.b();
        bVar.f69681e = str;
        bVar.f69682f = str2;
        bVar.f69683g = str3;
        eVar.y = bVar;
        eVar.f69690e = au.c.DeepLinkLog.stringValue;
        au.a(eVar, au.c.DeepLinkLog.stringValue, CJRJarvisApplication.getAppContext());
    }

    public final void a(Application application) {
        u.a();
        u.a(application);
    }

    public final void a(CJRShoppingCart cJRShoppingCart) {
        net.one97.paytm.marketplace.a.a(cJRShoppingCart);
    }

    public final void a(Context context, RemoteMessage remoteMessage) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("remote_message", remoteMessage);
        h.a aVar = net.one97.paytm.deeplink.h.f50349a;
        net.one97.paytm.deeplink.f fVar = net.one97.paytm.deeplink.f.f50341a;
        h.a.a(context, net.one97.paytm.deeplink.f.b(), bundle);
    }

    public final void a(Context context, kotlin.g.a.b<y<Integer>, x> bVar) {
        net.one97.paytm.deeplink.f fVar = net.one97.paytm.deeplink.f.f50341a;
        net.one97.paytm.deeplink.f.a(context, (kotlin.g.a.b<? super y<Integer>, x>) bVar);
    }

    public final void b(final Context context, final CJRFrequentOrder cJRFrequentOrder) {
        if (com.paytm.utility.a.m(context)) {
            new net.one97.paytm.recharge.common.utils.e((Activity) context, cJRFrequentOrder.getRechargeNumber(), ((AppCompatActivity) context).getSupportFragmentManager(), (Long) null, new e.a() {
                public final void ap_() {
                }

                public final void ar_() {
                }

                public final void aq_() {
                    az azVar = az.f61525a;
                    if (az.c(context)) {
                        az azVar2 = az.f61525a;
                        az.g(context, cJRFrequentOrder.getRechargeNumber());
                        return;
                    }
                    Intent intent = new Intent((Activity) context, AJRAutomaticSetupActivity.class);
                    intent.putExtra("recharge_number", cJRFrequentOrder.getRechargeNumber());
                    intent.putExtra("selected_recent", cJRFrequentOrder);
                    intent.putExtra("configuraton", (HashMap) cJRFrequentOrder.getConfiguration());
                    intent.putExtra(CLPConstants.PRODUCT_ID, cJRFrequentOrder.getProductID());
                    intent.putExtra("operator_logo", cJRFrequentOrder.getOperatorLogoURL());
                    intent.putExtra("is_from_reminder", true);
                    if (!(cJRFrequentOrder.getFrequentOrderProduct() == null || cJRFrequentOrder.getFrequentOrderProduct().getAttributes() == null || !cJRFrequentOrder.getFrequentOrderProduct().getAttributes().containsKey("is_bank_mandate_enabled"))) {
                        String str = cJRFrequentOrder.getFrequentOrderProduct().getAttributes().get("is_bank_mandate_enabled");
                        boolean z = false;
                        if (!TextUtils.isEmpty(str)) {
                            z = str.equalsIgnoreCase("1");
                        }
                        intent.putExtra("is_bank_mandate_enabled", z);
                    }
                    if (cJRFrequentOrder.getFrequentOrderProduct() != null && !TextUtils.isEmpty(cJRFrequentOrder.getFrequentOrderProduct().getService()) && !TextUtils.isEmpty(cJRFrequentOrder.getFrequentOrderProduct().getPaytype())) {
                        intent.putExtra("service_paytype", cJRFrequentOrder.getFrequentOrderProduct().getService().toLowerCase() + "_" + cJRFrequentOrder.getFrequentOrderProduct().getPaytype().toLowerCase());
                    }
                    ((Activity) context).startActivityForResult(intent, 205);
                }

                public final void an_() {
                    ((Activity) context).startActivity(new Intent((Activity) context, AJRAutomaticSubscriptionListActivity.class));
                }
            });
            return;
        }
        ao.a(i.class, "QuickDialogUtility.showErrorDialog");
        net.one97.paytm.quickpay.utilities.d.a(context, "No Internet connection", "Please check your internet connection or try again");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r7, net.one97.paytm.common.entity.recharge.CJRFrequentOrder r8, com.paytm.network.model.IJRPaytmDataModel r9) {
        /*
            r6 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity> r1 = net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity.class
            r0.<init>(r7, r1)
            boolean r1 = r9 instanceof net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel
            if (r1 == 0) goto L_0x0054
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel r9 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel) r9
            java.util.ArrayList r1 = r9.getSubscriptionModelArrayList()
            if (r1 == 0) goto L_0x0054
            if (r8 == 0) goto L_0x0054
            java.util.ArrayList r1 = r9.getSubscriptionModelArrayList()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0054
            r1 = 0
        L_0x0020:
            java.util.ArrayList r2 = r9.getSubscriptionModelArrayList()
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0054
            java.util.ArrayList r2 = r9.getSubscriptionModelArrayList()
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r2 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel) r2
            if (r2 == 0) goto L_0x0051
            java.lang.String r3 = r2.getRechargeNumber()
            java.lang.String r4 = r8.getRechargeNumber()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0051
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x0051
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0051
            goto L_0x0055
        L_0x0051:
            int r1 = r1 + 1
            goto L_0x0020
        L_0x0054:
            r2 = 0
        L_0x0055:
            if (r2 == 0) goto L_0x0075
            net.one97.paytm.recharge.common.utils.az r8 = net.one97.paytm.recharge.common.utils.az.f61525a
            boolean r8 = net.one97.paytm.recharge.common.utils.az.c(r7)
            if (r8 == 0) goto L_0x0069
            net.one97.paytm.recharge.common.utils.az r8 = net.one97.paytm.recharge.common.utils.az.f61525a
            long r8 = r2.getSubscriptionId()
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r7, (long) r8)
            return
        L_0x0069:
            java.lang.String r8 = "selected_automatic_subscribed_item"
            r0.putExtra(r8, r2)
            android.app.Activity r7 = (android.app.Activity) r7
            r8 = 204(0xcc, float:2.86E-43)
            r7.startActivityForResult(r0, r8)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.i.a(android.content.Context, net.one97.paytm.common.entity.recharge.CJRFrequentOrder, com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final IJRPaytmDataModel F() {
        return new CJRAutomaticSubscriptionListModel();
    }

    public final ArrayList<String> a(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel;
        int size;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!(iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRAutomaticSubscriptionListModel) || (cJRAutomaticSubscriptionListModel = (CJRAutomaticSubscriptionListModel) iJRPaytmDataModel) == null || cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList() == null || (size = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList().size()) <= 0)) {
            for (int i2 = 0; i2 < size; i2++) {
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList().get(i2);
                if (cJRAutomaticSubscriptionItemModel != null) {
                    String rechargeNumber = cJRAutomaticSubscriptionItemModel.getRechargeNumber();
                    if (!TextUtils.isEmpty(rechargeNumber)) {
                        arrayList.add(rechargeNumber);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void a(Context context, String str, String str2, String str3) {
        net.one97.paytm.j.a.e(context, str, str2, str3);
    }

    public final void d(Context context, String str) {
        if (context instanceof AJRMainActivity) {
            AJRMainActivity.a(context, str);
        }
    }

    public final void c(androidx.fragment.app.j jVar) {
        OauthModule.a(jVar);
    }

    public final boolean a(Activity activity, NetworkCustomError networkCustomError) {
        return OAuthUtils.a(activity, (Fragment) null, networkCustomError);
    }

    public final void b(int i2) {
        net.one97.paytm.marketplace.a.a(i2);
    }

    public final boolean G(Context context) {
        if (context != null) {
            return ag.a(context.getApplicationContext()).b("is_reseller_user", false, true);
        }
        return false;
    }

    public final boolean H(Context context) {
        if (context != null) {
            return ag.a(context.getApplicationContext()).b("is_merchant_user", false, true);
        }
        return false;
    }

    public final void e(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final void d(androidx.fragment.app.j jVar) {
        OauthModule.c(jVar);
    }

    public final void k(Activity activity) {
        net.one97.paytm.app.c.a(activity);
    }

    public final void G() {
        CJRJarvisApplication.j();
    }

    public final void H() {
        net.one97.paytm.utils.u.a();
        net.one97.paytm.utils.u.b();
    }

    public final boolean c(int i2) {
        net.one97.paytm.utils.u.a();
        return net.one97.paytm.utils.u.a(i2);
    }

    public final boolean d(int i2) {
        net.one97.paytm.utils.u.a();
        return net.one97.paytm.utils.u.b(i2);
    }

    public final boolean e(int i2) {
        net.one97.paytm.utils.u.a();
        return net.one97.paytm.utils.u.c(i2);
    }

    public final boolean f(int i2) {
        net.one97.paytm.utils.u.a();
        return net.one97.paytm.utils.u.d(i2);
    }

    public final void b(Context context, Intent intent) {
        net.one97.paytm.utils.u.a();
        net.one97.paytm.utils.u.a(context, intent);
    }

    public final boolean a(Activity activity, Intent intent) {
        return net.one97.paytm.utils.u.a().b(activity, intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        if (net.one97.paytm.oauth.utils.q.x() == false) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(androidx.appcompat.app.AppCompatActivity r12) {
        /*
            r11 = this;
            net.one97.paytm.oauth.utils.a r0 = net.one97.paytm.oauth.utils.a.f56763a
            net.one97.paytm.common.b.a r0 = net.one97.paytm.common.b.d.b()
            android.content.Context r0 = r0.a()
            com.paytm.b.a.a r0 = net.one97.paytm.utils.ag.a(r0)
            r1 = 0
            r2 = 1
            java.lang.String r3 = "is_from_signup"
            boolean r0 = r0.b((java.lang.String) r3, (boolean) r1, (boolean) r2)
            boolean r3 = net.one97.paytm.oauth.utils.a.a()
            if (r3 == 0) goto L_0x0115
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x0115
            r3 = r12
            android.content.Context r3 = (android.content.Context) r3
            boolean r4 = com.paytm.utility.b.r((android.content.Context) r3)
            if (r4 != 0) goto L_0x002d
            goto L_0x0115
        L_0x002d:
            net.one97.paytm.oauth.a r4 = net.one97.paytm.oauth.a.a()
            java.lang.String r5 = "OAuthGTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r4 = 90
            java.lang.String r5 = "oauthSetAppLockInterval"
            int r4 = net.one97.paytm.oauth.a.a((java.lang.String) r5, (int) r4)
            int r4 = r4 * 24
            int r4 = r4 * 60
            int r4 = r4 * 60
            long r4 = (long) r4
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            long r6 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q r8 = net.one97.paytm.oauth.utils.q.f56798a
            long r8 = net.one97.paytm.oauth.utils.q.y()
            long r6 = r6 - r8
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x005a
            r4 = 1
            goto L_0x005b
        L_0x005a:
            r4 = 0
        L_0x005b:
            net.one97.paytm.oauth.a.a()
            if (r0 == 0) goto L_0x0067
            java.lang.String r5 = "oauthSetAppLockSignUp"
            boolean r5 = net.one97.paytm.oauth.a.a((java.lang.String) r5, (boolean) r2)
            goto L_0x006d
        L_0x0067:
            java.lang.String r5 = "oauthSetAppLockLogin"
            boolean r5 = net.one97.paytm.oauth.a.a((java.lang.String) r5, (boolean) r2)
        L_0x006d:
            if (r5 == 0) goto L_0x0115
            boolean r3 = net.one97.paytm.oauth.utils.a.a((android.content.Context) r3)
            if (r3 == 0) goto L_0x007d
            net.one97.paytm.oauth.utils.q r3 = net.one97.paytm.oauth.utils.q.f56798a
            boolean r3 = net.one97.paytm.oauth.utils.q.x()
            if (r3 != 0) goto L_0x0088
        L_0x007d:
            net.one97.paytm.oauth.utils.q r3 = net.one97.paytm.oauth.utils.q.f56798a
            boolean r3 = net.one97.paytm.oauth.utils.q.w()
            if (r3 == 0) goto L_0x009c
            if (r4 == 0) goto L_0x0088
            goto L_0x009c
        L_0x0088:
            net.one97.paytm.oauth.a.a()
            java.lang.String r0 = "oauthVerifyLockOnLogin"
            boolean r0 = net.one97.paytm.oauth.a.a((java.lang.String) r0, (boolean) r2)
            int r1 = net.one97.paytm.oauth.R.string.lbl_unlock_paytm
            java.lang.String r1 = r12.getString(r1)
            net.one97.paytm.oauth.utils.a.a((androidx.appcompat.app.AppCompatActivity) r12, (boolean) r0, (java.lang.String) r1)
            goto L_0x0115
        L_0x009c:
            if (r0 == 0) goto L_0x00a2
            java.lang.String r0 = "new_sign_up"
        L_0x00a0:
            r5 = r0
            goto L_0x00b5
        L_0x00a2:
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            boolean r0 = net.one97.paytm.oauth.utils.q.w()
            if (r0 != 0) goto L_0x00ad
            java.lang.String r0 = "first_time"
            goto L_0x00a0
        L_0x00ad:
            if (r4 == 0) goto L_0x00b2
            java.lang.String r0 = "90_days"
            goto L_0x00a0
        L_0x00b2:
            java.lang.String r0 = "default"
            goto L_0x00a0
        L_0x00b5:
            net.one97.paytm.oauth.b r0 = net.one97.paytm.oauth.OauthModule.b()
            net.one97.paytm.oauth.models.a r10 = new net.one97.paytm.oauth.models.a
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 56
            java.lang.String r3 = "onboarding"
            java.lang.String r4 = "/app_lock"
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r0.logHawEyeEvent(r10)
            androidx.fragment.app.j r0 = r12.getSupportFragmentManager()
            boolean r0 = net.one97.paytm.oauth.utils.a.a((androidx.fragment.app.j) r0)
            if (r0 != 0) goto L_0x00fe
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            net.one97.paytm.oauth.fragment.t$a r2 = net.one97.paytm.oauth.fragment.t.f56626a
            net.one97.paytm.oauth.fragment.t r0 = net.one97.paytm.oauth.fragment.t.a.a(r0)
            r0.setCancelable(r1)
            androidx.fragment.app.j r12 = r12.getSupportFragmentManager()
            androidx.fragment.app.q r12 = r12.a()
            java.lang.String r1 = "activity.supportFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            java.lang.Class<net.one97.paytm.oauth.fragment.t> r1 = net.one97.paytm.oauth.fragment.t.class
            java.lang.String r1 = r1.getName()
            r12.a((androidx.fragment.app.Fragment) r0, (java.lang.String) r1)
            r12.c()
        L_0x00fe:
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.oauth.utils.q.v()
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            long r0 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q.e((long) r0)
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            long r0 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q.f((long) r0)
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.i.b(androidx.appcompat.app.AppCompatActivity):void");
    }

    public final boolean J() {
        return OAuthUtils.b();
    }

    public final void a(boolean z) {
        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
        net.one97.paytm.oauth.utils.q.b(z);
    }

    public final void b(Context context, String str, String str2, String str3) {
        net.one97.paytm.j.a.f(context, str, str2, str3);
    }

    public final void a(Context context, String str, Map<String, String> map) {
        net.one97.paytm.j.a.a(context, str, map);
    }

    public final void K() {
        CJRJarvisApplication.l();
    }

    public final void L() {
        CJRJarvisApplication.m();
    }

    public final void M() {
        CJRJarvisApplication.n();
    }

    public final Class<?> N() {
        return AJRAutomaticOptionListActivity.class;
    }

    public final Class<?> O() {
        return AJRPaymentLimitHomePageNew.class;
    }

    public final Class<?> P() {
        return AJRScreenRecordingActivity.class;
    }

    public final Class<?> Q() {
        return AJRAppLockSettingsActivity.class;
    }

    public final Class<?> R() {
        return AJRSavedPaymentActivity.class;
    }

    public final Class<?> S() {
        return PaytmAssistSettingsActivity.class;
    }

    public final Class<?> T() {
        return AJRScanSettingsActivity.class;
    }

    public final Class<?> U() {
        return DebugPreferenceActivity.class;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0051, code lost:
        if ((r0 - net.one97.paytm.oauth.utils.q.z()) > (((long) (((net.one97.paytm.oauth.a.a("oauthlaunchSetLockInterval", 7) * 24) * 60) * 60)) * 1000)) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x008d, code lost:
        if ((r0 - net.one97.paytm.oauth.utils.q.z()) > (((long) (((net.one97.paytm.oauth.a.a("oauthLaunchSetDeviceLockInterval", 14) * 24) * 60) * 60)) * 1000)) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(androidx.fragment.app.j r11) {
        /*
            r10 = this;
            net.one97.paytm.oauth.utils.a r0 = net.one97.paytm.oauth.utils.a.f56763a
            java.lang.String r0 = "fragmentManager"
            kotlin.g.b.k.c(r11, r0)
            net.one97.paytm.oauth.b r0 = net.one97.paytm.oauth.OauthModule.b()
            java.lang.String r1 = "OauthModule.getOathDataProvider()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r2 = "OauthModule.getOathDataP…ider().applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            boolean r0 = net.one97.paytm.oauth.utils.a.a((android.content.Context) r0)
            r3 = 1
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r6 = "OAuthGTMHelper.getInstance()"
            r7 = 0
            if (r0 == 0) goto L_0x0054
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            boolean r0 = net.one97.paytm.oauth.utils.q.x()
            if (r0 != 0) goto L_0x0054
            long r0 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q r2 = net.one97.paytm.oauth.utils.q.f56798a
            long r8 = net.one97.paytm.oauth.utils.q.z()
            long r0 = r0 - r8
            net.one97.paytm.oauth.a r2 = net.one97.paytm.oauth.a.a()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r2 = 7
            java.lang.String r6 = "oauthlaunchSetLockInterval"
            int r2 = net.one97.paytm.oauth.a.a((java.lang.String) r6, (int) r2)
            int r2 = r2 * 24
            int r2 = r2 * 60
            int r2 = r2 * 60
            long r8 = (long) r2
            long r8 = r8 * r4
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0090
            goto L_0x0091
        L_0x0054:
            net.one97.paytm.oauth.b r0 = net.one97.paytm.oauth.OauthModule.b()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = r0.getApplicationContext()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            boolean r0 = net.one97.paytm.oauth.utils.a.a((android.content.Context) r0)
            if (r0 != 0) goto L_0x0090
            long r0 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q r2 = net.one97.paytm.oauth.utils.q.f56798a
            long r8 = net.one97.paytm.oauth.utils.q.z()
            long r0 = r0 - r8
            net.one97.paytm.oauth.a r2 = net.one97.paytm.oauth.a.a()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r2 = 14
            java.lang.String r6 = "oauthLaunchSetDeviceLockInterval"
            int r2 = net.one97.paytm.oauth.a.a((java.lang.String) r6, (int) r2)
            int r2 = r2 * 24
            int r2 = r2 * 60
            int r2 = r2 * 60
            long r8 = (long) r2
            long r8 = r8 * r4
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r3 = 0
        L_0x0091:
            if (r3 == 0) goto L_0x009f
            net.one97.paytm.oauth.utils.a.a((androidx.fragment.app.j) r11, (int) r7)
            net.one97.paytm.oauth.utils.q r11 = net.one97.paytm.oauth.utils.q.f56798a
            long r0 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q.f((long) r0)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.i.e(androidx.fragment.app.j):void");
    }

    public final void a(Intent intent, Context context, String str) {
        net.one97.paytm.utils.u.a();
        net.one97.paytm.utils.u.a(intent, context, str);
    }

    public final void I(Context context) {
        if (com.paytm.utility.a.p(context)) {
            ContactsSdk.INSTANCE.startWorkerSync();
        }
    }

    public final void V() {
        boolean z = false;
        PendingIntent service = PendingIntent.getService(CJRJarvisApplication.getAppContext(), 0, new Intent(CJRJarvisApplication.getAppContext(), HttpPostService.class), 536870912);
        if (service != null) {
            z = true;
        }
        if (z) {
            service.cancel();
            ((AlarmManager) CJRJarvisApplication.getAppContext().getSystemService("alarm")).cancel(service);
        }
    }

    public final void c(Activity activity, String str) {
        net.one97.paytm.utils.m mVar = net.one97.paytm.utils.m.f69757a;
        net.one97.paytm.utils.m.a((Context) activity, str);
    }

    public final void a(HashMap<String, Object> hashMap, Activity activity) {
        String str;
        net.one97.paytm.utils.m mVar = net.one97.paytm.utils.m.f69757a;
        kotlin.g.b.k.c(activity, "context");
        if (hashMap == null) {
            return;
        }
        if (hashMap.containsKey("af_paytm_deeplink")) {
            net.one97.paytm.utils.m.a((String) hashMap.get("af_paytm_deeplink"), (Context) activity);
        } else if (hashMap.containsKey("referral_unique_link")) {
            String str2 = (String) hashMap.get("referral_unique_link");
            if (!TextUtils.isEmpty(str2) && b.c((Context) activity)) {
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.utils.m.a((Context) activity, str2);
            }
        } else if (hashMap.containsKey("af_scheme") && hashMap.get("af_scheme") != null && !TextUtils.isEmpty((String) hashMap.get("af_scheme"))) {
            String str3 = (String) hashMap.get("af_scheme");
            try {
                if (hashMap.containsKey("af_scheme_parameter")) {
                    if (hashMap.get("af_scheme_parameter") != null && !TextUtils.isEmpty((String) hashMap.get("af_scheme_parameter"))) {
                        str3 = str3 + "?" + net.one97.paytm.utils.m.a((String) hashMap.get("af_scheme_parameter"));
                    }
                }
                if (hashMap.containsKey("af_url") && hashMap.get("af_url") != null && !TextUtils.isEmpty((String) hashMap.get("af_url"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    if (str3 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (p.a((CharSequence) str3, (CharSequence) "?", false)) {
                        str = AppConstants.AND_SIGN;
                    } else {
                        str = "?";
                    }
                    sb.append(str);
                    sb.append("url=");
                    sb.append((String) hashMap.get("af_url"));
                    str3 = sb.toString();
                }
                if (hashMap.containsKey("af_url_parameter") && hashMap.get("af_url_parameter") != null && !TextUtils.isEmpty((String) hashMap.get("af_url_parameter"))) {
                    str3 = str3 + "?" + net.one97.paytm.utils.m.a((String) hashMap.get("af_url_parameter"));
                }
                net.one97.paytm.utils.m.a(str3, (Context) activity);
            } catch (Exception unused) {
            }
        } else if (hashMap.containsKey("af_dp")) {
            net.one97.paytm.utils.m.a((String) hashMap.get("af_dp"), (Context) activity);
        }
    }

    public final void W() {
        ag.a(CJRJarvisApplication.getAppContext()).a((com.paytm.utility.u) new net.one97.paytm.utils.ab());
    }

    public final void X() {
        SmsSdkProviderImpl.initSmsSdk();
    }

    public final void a(Context context, String str, HashMap hashMap, kotlin.g.a.m mVar) {
        net.one97.paytm.utils.m mVar2 = net.one97.paytm.utils.m.f69757a;
        net.one97.paytm.utils.m.a(context, str, hashMap, mVar, 0);
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5) {
        net.one97.paytm.j.a.a(context, str, str2, str3, (String) null, str4, str5);
    }

    public final void e(Activity activity) {
        net.one97.paytm.auth.b.b.a(activity, false);
        b.a((Context) activity, System.currentTimeMillis());
    }

    public final boolean b(Context context, int i2) {
        int b2 = net.one97.paytm.common.utility.i.a(context.getApplicationContext()).b("min_kyc_pop_n", -1, false);
        if (b2 == -1) {
            net.one97.paytm.upgradeKyc.utils.j.a();
            return true;
        } else if (b2 != i2) {
            return false;
        } else {
            net.one97.paytm.common.utility.i.a(context.getApplicationContext()).a("min_kyc_pop_n", 0, false);
            return true;
        }
    }

    public final void a(Context context, List<Map<String, String>> list) {
        net.one97.paytm.j.a.a(context, list, "/", "");
    }
}
