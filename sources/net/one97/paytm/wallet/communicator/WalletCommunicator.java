package net.one97.paytm.wallet.communicator;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import easypay.manager.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRUpdateMessage;
import net.one97.paytm.ab;
import net.one97.paytm.addmoney.toppb.view.AddMoneyToPPBActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel;
import net.one97.paytm.common.entity.offline_pg.binRequest.CJRBinRequest;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.postpaid.CJRPPAccount;
import net.one97.paytm.common.entity.quick_pay.DeleteQuickPayResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateDataModel;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.i;
import net.one97.paytm.deeplink.p;
import net.one97.paytm.h.d;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.hometabs.HomeTabItem;
import net.one97.paytm.m;
import net.one97.paytm.managebeneficiary.AddNewBeneficiaryV2Activity;
import net.one97.paytm.managebeneficiary.ManageWalletBeneficiaryActivity;
import net.one97.paytm.moneytransfer.e.d;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransferv4.b.a.a.a.g.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.b;
import net.one97.paytm.network.e;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.p2mNewDesign.models.QrData;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.activity.PaymentReminderCreationActivity;
import net.one97.paytm.quickpay.utilities.f;
import net.one97.paytm.smoothpay.activity.PaymentSuccessActivity;
import net.one97.paytm.snackbar.ExpandableTextView;
import net.one97.paytm.snackbar.a;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.common.upi.UserVpaInfo;
import net.one97.paytm.upi.deeplink.UPIQRScanDeeplinkActivity;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.CustomSnackbar;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ak;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.av;
import net.one97.paytm.utils.az;
import net.one97.paytm.utils.bf;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.verifier.activity.VerifierBasicActivity;
import net.one97.paytm.wallet.c.c;
import net.one97.paytm.wallet.c.n;
import net.one97.paytm.wallet.common.entity.offline_pg.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.newdesign.activity.AJRTrustSeal;
import net.one97.paytm.wallet.newdesign.activity.EDCReceiptActivity;
import net.one97.paytm.wallet.newdesign.d.c;
import net.one97.paytm.wallet.newdesign.independencedaypostcard.IndependancePostCardMainActivity;
import net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity;

public class WalletCommunicator implements c {
    private static net.one97.paytm.h.a mActivityHelper = d.b();
    Snackbar snackbar = null;

    enum a {
        NOT_YET_SUBMITTED,
        KYC_SHARING_ACCEPTED,
        APPLICATION_IN_PROGRESS,
        APPLICATION_PENDING_APPROVAL,
        APPLICATION_ACCEPTED,
        APPLICATION_CONFIRMED,
        APPLICATION_REJECTED,
        DEACTIVE,
        NONE
    }

    public /* synthetic */ boolean a(Context context, String str) {
        return c.CC.$default$a(this, context, str);
    }

    public void cancelVolleyRequest(com.paytm.network.a aVar) {
    }

    public String getApplicationId() {
        return "net.one97.paytm";
    }

    public Intent getBRTSIntent(Context context, IJRDataModel iJRDataModel) {
        return null;
    }

    public String getBuildType() {
        return "release";
    }

    public Class getCarInfoActivityClass() {
        return null;
    }

    public View getCashbackView(Context context, String str) {
        return null;
    }

    public String getClientId() {
        return "market-app";
    }

    public String getDeeplinkSchemeID() {
        return "paytmmp";
    }

    public Class getHealthInsPreQuoteActivityClass() {
        return null;
    }

    public Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem) {
        return null;
    }

    public String getSchema() {
        return "paytmmp";
    }

    public String getSchemaId() {
        return "paytmmp";
    }

    public int getScpAnimation() {
        return R.raw.one_click_animation;
    }

    public Class getShopInsLandingActivityClass() {
        return null;
    }

    public String getShowCodeRSAKey() {
        return "63uxcxggq6kqjjsgwagub2k877w562v0qnqgkzrki7203cjfr2fwnwuofewsnq5wjv4603cnhwz8dj14mujzmirehg6ysfjuyoua6qjlvnivcxhjk5xes68umpp4mmprs369wb7i4ifp212hvl";
    }

    public b getVerifyPasscode(Context context, String str, HashMap<String, String> hashMap) {
        return null;
    }

    public String getVersionName() {
        return "9.1.3";
    }

    public void interceptHttpRequestResponse(e eVar) {
    }

    public boolean isBranchShareUrl(String str) {
        return false;
    }

    public boolean isMall() {
        return false;
    }

    public boolean onInsuranceIntent(Context context) {
        return false;
    }

    public void onMoneyTransferIntent(Context context) {
    }

    public boolean openIntendedScreen() {
        return false;
    }

    public void setInsuranceType(int i2) {
    }

    public void shareBranchLink(Activity activity, boolean z, String str) {
    }

    public void startQRDisplayActivity(Context context, Double d2, String str) {
    }

    public String getStringFromGTM(Context context, String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public boolean getBooleanFromGTM(Context context, String str, boolean z) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public Context wrapContextByRestring(Context context) {
        return net.one97.paytm.locale.b.e.a(context);
    }

    public void sendCustomGTMEvent(Context context, String str, Map<String, Object> map) {
        if (map != null) {
            net.one97.paytm.j.a.b(str, map, context);
        } else {
            net.one97.paytm.j.a.a(str, context);
        }
    }

    public void onPostcardIntent(Context context) {
        context.startActivity(new Intent(context, PostCardMainActivity.class));
    }

    public void sendGTMOpenScreenWithDeviceInfo(Context context, String str, String str2) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public Class<?> getMainActivityClass() {
        return AJRMainActivity.class;
    }

    public void isValidBharatQRCode(Context context, String str, boolean z, Long l, boolean z2, Long l2, int i2) throws Exception {
        net.one97.paytm.upi.c.d dVar = new net.one97.paytm.upi.c.d();
        net.one97.paytm.upi.c.c a2 = net.one97.paytm.upi.c.d.a(str.replace("\\n", "").replace("\\r", "").trim());
        if (a2.f66617i == null || TextUtils.isEmpty(a2.f66617i.f66625b)) {
            if ("0000".equals(a2.l)) {
                dVar.a(context, "Invalid QR code", "Non merchant transaction");
                return;
            } else if (a2.j == null || TextUtils.isEmpty(a2.j.f66628b)) {
                dVar.a(context, "Invalid QR code", "Incomplete transaction details");
                return;
            }
        }
        if (TextUtils.isEmpty(a2.f66615g) || TextUtils.isEmpty(a2.f66616h)) {
            PaytmLogs.e("BharatQrHelper", "Empty Bank IFSC or Account number");
            dVar.a(context, "Invalid Bharat QR", "Incomplete transaction details");
        } else if (TextUtils.isEmpty(a2.l)) {
            PaytmLogs.e("BharatQrHelper", "Empty MCC");
            dVar.a(context, "Invalid Bharat QR", "Incomplete transaction details");
        } else if (TextUtils.isEmpty(a2.m)) {
            PaytmLogs.e("BharatQrHelper", "Empty CC");
            dVar.a(context, "Invalid Bharat QR", "Incomplete transaction details");
        } else if (TextUtils.isEmpty(a2.s)) {
            PaytmLogs.e("BharatQrHelper", "Empty merchant name");
            dVar.a(context, "Invalid Bharat QR", "Incomplete transaction details");
        } else {
            if (!TextUtils.isEmpty(a2.n) && a2.f66617i != null && !TextUtils.isEmpty(a2.f66617i.f66626c)) {
                try {
                    if (Double.compare(Double.parseDouble(a2.n), Double.parseDouble(a2.f66617i.f66626c)) < 0) {
                        PaytmLogs.e("BharatQrHelper", "Empty amount");
                        throw new Exception();
                    }
                } catch (NumberFormatException unused) {
                    PaytmLogs.e("BharatQrHelper", "Error while parsing amount");
                    throw new Exception();
                }
            }
            PaytmLogs.e("BharatQrHelper", "Valid QR");
            StringBuilder sb = new StringBuilder(AppConstants.MapQrConstants.UPI);
            if (a2.f66617i == null || TextUtils.isEmpty(a2.f66617i.f66625b)) {
                if (TextUtils.isEmpty(a2.f66615g) || TextUtils.isEmpty(a2.f66616h)) {
                    if (a2.k == null || TextUtils.isEmpty(a2.k.f66600b)) {
                        throw new Exception();
                    } else if ("0000".equalsIgnoreCase(a2.l) || a2.j == null || TextUtils.isEmpty(a2.j.f66628b)) {
                        throw new Exception();
                    } else if (sb.toString().endsWith("?")) {
                        sb.append("pa=" + a2.k.f66600b + "@aadhaar.npci");
                    } else {
                        sb.append("&pa=" + a2.k.f66600b + "@aadhaar.npci");
                    }
                } else if ("0000".equalsIgnoreCase(a2.l) || a2.j == null || TextUtils.isEmpty(a2.j.f66628b)) {
                    throw new Exception();
                } else if (sb.toString().endsWith("?")) {
                    sb.append("pa=" + a2.f66616h + "@" + a2.f66615g + ".ifsc.npci");
                } else {
                    sb.append("&pa=" + a2.f66616h + "@" + a2.f66615g + ".ifsc.npci");
                }
            } else if (sb.toString().endsWith("?")) {
                sb.append("pa=" + a2.f66617i.f66625b);
            } else {
                sb.append("&pa=" + a2.f66617i.f66625b);
            }
            if (a2.f66617i != null && !TextUtils.isEmpty(a2.f66617i.f66626c)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("mam=" + a2.f66617i.f66626c);
                } else {
                    sb.append("&mam=" + a2.f66617i.f66626c);
                }
            }
            if (a2.j != null && !TextUtils.isEmpty(a2.j.f66628b)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("tr=" + a2.j.f66628b);
                } else {
                    sb.append("&tr=" + a2.j.f66628b);
                }
            }
            if (a2.j != null && !TextUtils.isEmpty(a2.j.f66629c)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("url=" + a2.j.f66629c);
                } else {
                    sb.append("&url=" + a2.j.f66629c);
                }
            }
            if (!TextUtils.isEmpty(a2.l)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("mc=" + a2.l);
                } else {
                    sb.append("&mc=" + a2.l);
                }
            }
            if (!TextUtils.isEmpty(a2.m)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("cu=" + a2.m);
                } else {
                    sb.append("&cu=" + a2.m);
                }
            }
            if (!TextUtils.isEmpty(a2.n)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("am=" + a2.n);
                } else {
                    sb.append("&am=" + a2.n);
                }
            }
            if (!TextUtils.isEmpty(a2.s)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("pn=" + a2.s);
                } else {
                    sb.append("&pn=" + a2.s);
                }
            }
            if (a2.v != null && !TextUtils.isEmpty(a2.v.f66608h)) {
                if (sb.toString().endsWith("?")) {
                    sb.append("tn=" + a2.v.f66608h);
                } else {
                    sb.append("&tn=" + a2.v.f66608h);
                }
            }
            sb.append("&bharatqr=1");
            PaytmLogs.i("BharatQrHelper", "UPI Deeplink - " + sb.toString());
            String sb2 = sb.toString();
            if (PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b("is_upi_user", false, true)) {
                Intent intent = new Intent(context, UPIQRScanDeeplinkActivity.class);
                intent.setData(Uri.parse(sb2));
                intent.putExtra(UpiConstants.UPI_SOURCE, 2);
                intent.putExtra(UpiConstants.IS_FROM_SCAN, true);
                intent.putExtra(UpiConstants.EVENT_START_TIME, l);
                intent.putExtra(UpiConstants.EVENT_SCAN_TIME, l2);
                intent.putExtra(UpiConstants.IS_MID_SCAN, z2);
                intent.setFlags(335544320);
                context.startActivity(intent);
            } else if (UpiUtils.isInActiveProfileExist(context)) {
                context.startActivity(UpiUtils.getUpiLandingPageActivityIntent(context));
            } else {
                Intent intent2 = new Intent(context, UpiSelectBankActivity.class);
                intent2.setFlags(536870912);
                intent2.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal());
                if (!(context instanceof Activity) || dVar.f66618a == -1) {
                    context.startActivity(intent2);
                } else {
                    ((Activity) context).startActivityForResult(intent2, dVar.f66618a);
                }
            }
        }
    }

    public void openEDCReceiptActivity(Context context, String str) {
        Intent intent = new Intent(context, EDCReceiptActivity.class);
        intent.putExtra("extra_home_data", ac.a(context, str));
        intent.putExtra("EXTRA_DEEP_LINK_DATA", str);
        intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        context.startActivity(intent);
    }

    public boolean handleUPIDeepLink(Activity activity, String str, boolean z, Long l, boolean z2, Long l2) {
        Activity activity2 = activity;
        boolean z3 = z;
        Long l3 = l;
        boolean z4 = z2;
        Long l4 = l2;
        if (!com.paytm.utility.a.p(activity)) {
            activity2.startActivityForResult(new Intent(activity2, AJRAuthActivity.class), 3112);
        } else if (ag.a(activity.getApplicationContext()).b("is_upi_user", false, true) || UpiUtils.isInActiveProfileExist(activity)) {
            Intent intent = new Intent(activity2, UPIQRScanDeeplinkActivity.class);
            intent.putExtra(UpiConstants.MONEY_TRANSFER_HEADER, activity.getResources().getString(R.string.send_money));
            intent.setData(Uri.parse(str));
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            intent.putExtra(UpiConstants.UPI_SOURCE, 1);
            intent.putExtra(UpiConstants.IS_FROM_SCAN, true);
            intent.putExtra(UpiConstants.IS_GALLERY_SCAN, z3);
            intent.putExtra(UpiConstants.EVENT_START_TIME, l3);
            intent.putExtra(UpiConstants.EVENT_SCAN_TIME, l4);
            intent.putExtra(UpiConstants.IS_MID_SCAN, z4);
            activity2.startActivityForResult(intent, 3112);
        } else {
            Intent intent2 = new Intent(activity2, UpiSelectBankActivity.class);
            intent2.setFlags(536870912);
            intent2.addFlags(67108864);
            intent2.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal());
            intent2.putExtra(UpiConstants.IS_GALLERY_SCAN, z3);
            intent2.putExtra(UpiConstants.EVENT_START_TIME, l3);
            intent2.putExtra(UpiConstants.EVENT_SCAN_TIME, l4);
            intent2.putExtra(UpiConstants.IS_MID_SCAN, z4);
            activity2.startActivityForResult(intent2, 3112);
        }
        return true;
    }

    public void sendDeeplinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context) {
        net.one97.paytm.j.a.a(str, cJRHomePageItem, context);
    }

    public void handleDeeplinkByMall(Context context, CJRHomePageItem cJRHomePageItem, String str, String str2, String str3, String str4, String str5) {
        Context context2 = context;
        final CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        Bundle a2 = net.one97.paytm.marketplace.a.a((HashMap<String, Serializable>) new HashMap<String, Serializable>() {
            {
                put("extra_home_data", cJRHomePageItem2);
                put("origin", "deeplinking");
                put("qrcode_id", str6);
                put("qrcode_order_id", str7);
                put("deeplink", str8);
                put("timestamp", str9);
                put("affiliateID", str10);
                put("source", "qrcode");
                put("is_deep_linking_data", Boolean.TRUE);
            }
        });
        h.a aVar = h.f50349a;
        if (!h.a.a(context, net.one97.paytm.marketplace.a.a(cJRHomePageItem, cJRHomePageItem.getURLType()), a2)) {
            context.startActivity(new Intent(context, AJRUpdateMessage.class));
        }
    }

    public void handlePrimeIntent(Context context, CJRHomePageItem cJRHomePageItem) {
        i iVar = i.f50350a;
        DeepLinkData a2 = i.a(context, net.one97.paytm.prime.f.b.f59794f, (Bundle) null);
        if (a2 != null) {
            p pVar = p.f50364a;
            if (p.a(context, a2)) {
                p pVar2 = p.f50364a;
                p.b(context, a2);
            }
        }
    }

    public CJRHomePageItem getDeeplinkDataItem(Context context, String str) {
        return ac.a(context, str);
    }

    public Class<?> getAuthActivityClass() {
        return AJRAuthActivity.class;
    }

    public boolean isFromAppEvoke(Activity activity) {
        return (activity == null || !(activity instanceof AJRMainActivity) || ((AJRMainActivity) activity).f52665c == null) ? false : true;
    }

    public String getCurrentDateAndTimeFromUpiUtils() {
        return UpiUtils.getCurrentDateAndTime();
    }

    public String maskNumber(String str) {
        return UpiUtils.maskNumber(str);
    }

    public long getWalletTokenExpireTime(Context context) {
        return t.d(context);
    }

    public String getWalletSSOToken(Context context) {
        return t.c(context);
    }

    public String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return t.a(cJRPGTokenList);
    }

    public int getIntegerFromGTM(Context context, String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, 0);
    }

    public long getLongFromGTM(Context context, String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, 0);
    }

    public void openAddMoneyScreen(Activity activity) {
        boolean j = j.j(activity);
        boolean i2 = j.i(activity);
        int d2 = j.d(activity);
        if (j || !i2 || d2 != 0 || !com.paytm.utility.a.p(activity)) {
            net.one97.paytm.wallet.newdesign.a.a();
            net.one97.paytm.wallet.newdesign.a.a(activity, "wallet");
            return;
        }
        try {
            net.one97.paytm.payments.d.a.a(activity, net.one97.paytm.utils.j.a("paytmmp://cash_wallet?featuretype=add_money&tab=wallet", "wallet"));
        } catch (UnsupportedEncodingException e2) {
            net.one97.paytm.wallet.newdesign.a.a();
            net.one97.paytm.wallet.newdesign.a.a(activity, "wallet");
            q.b(e2.getMessage());
        }
    }

    public boolean isMinKycDone(Context context) {
        return j.k(context);
    }

    public void startMoneyTransferActivity(Context context, boolean z, Bundle bundle) {
        Intent intent = new Intent(context, MoneyTransferV3Activity.class);
        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, z);
        if (bundle != null) {
            intent.putExtra("extra_home_data", bundle);
        }
        intent.setFlags(67108864);
        context.startActivity(intent);
    }

    public void callLoginActivity(Activity activity) {
        net.one97.paytm.auth.b.a.a(activity);
    }

    public void showNetworkRetryDialog(final Context context, final com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.a.m(context)) {
                    aVar.a();
                } else {
                    WalletCommunicator.this.showNetworkRetryDialog(context, aVar);
                }
            }
        });
        builder.show();
    }

    public void checkDeepLinking(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public String getUpgradeKycDeeplink(String str, String str2, boolean z, boolean z2) throws UnsupportedEncodingException {
        return net.one97.paytm.payments.d.a.a() + "upgrade_wallet?call_back_url=" + URLEncoder.encode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&vertical=" + str2 + "&aadhaar_otp=" + z + "&non_aadhaar=" + z2;
    }

    public void showSnackBar(Context context, String str, String str2, Fragment fragment) {
        a.C1288a aVar = new a.C1288a();
        aVar.f65123h = str;
        aVar.f65122g = str2;
        aVar.f65117b = new View.OnClickListener() {
            public final void onClick(View view) {
                if (WalletCommunicator.this.snackbar != null && WalletCommunicator.this.snackbar.e()) {
                    WalletCommunicator.this.snackbar.d();
                }
            }
        };
        aVar.f65120e = context.getResources().getString(R.string.p2p_ok);
        aVar.f65124i = fragment.getView();
        net.one97.paytm.snackbar.a aVar2 = new net.one97.paytm.snackbar.a(aVar.f65119d, aVar.f65120e, aVar.f65121f, aVar.f65116a, aVar.f65117b, aVar.f65118c, aVar.f65122g, aVar.f65123h, aVar.f65124i);
        Snackbar snackbar2 = null;
        if (aVar2.f65108i != null && !TextUtils.isEmpty(aVar2.f65106g)) {
            View inflate = LayoutInflater.from(aVar2.f65108i.getContext()).inflate(R.layout.snackbar_layout, (ViewGroup) null);
            if (aVar2.f65103d == null && aVar2.f65104e == null && aVar2.f65105f == null) {
                snackbar2 = Snackbar.a(aVar2.f65108i, (CharSequence) "", 0);
            } else {
                snackbar2 = Snackbar.a(aVar2.f65108i, (CharSequence) "", -2);
            }
            aVar2.j = (ExpandableTextView) inflate.findViewById(R.id.message_snackbar);
            TextView textView = (TextView) inflate.findViewById(R.id.heading_snackbar);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.dismiss_snackbar);
            TextView textView2 = (TextView) inflate.findViewById(R.id.snackbar_positive_action);
            TextView textView3 = (TextView) inflate.findViewById(R.id.snackbar_negative_action);
            TextView textView4 = (TextView) inflate.findViewById(R.id.snackbar_neutral_action);
            View findViewById = inflate.findViewById(R.id.snackbar_parent);
            ExpandableTextView expandableTextView = aVar2.j;
            if (expandableTextView.f65094g && !expandableTextView.f65093f && expandableTextView.f65091d >= 0) {
                for (ExpandableTextView.a b2 : expandableTextView.f65088a) {
                    b2.b();
                }
                int measuredHeight = expandableTextView.getMeasuredHeight();
                expandableTextView.f65093f = true;
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{measuredHeight, expandableTextView.f65095h});
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(
/*
Method generation error in method: net.one97.paytm.snackbar.ExpandableTextView.3.onAnimationUpdate(android.animation.ValueAnimator):void, dex: classes7.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.snackbar.ExpandableTextView.3.onAnimationUpdate(android.animation.ValueAnimator):void, class status: UNLOADED
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
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                });
                ofInt.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(
/*
Method generation error in method: net.one97.paytm.snackbar.ExpandableTextView.4.onAnimationEnd(android.animation.Animator):void, dex: classes7.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.snackbar.ExpandableTextView.4.onAnimationEnd(android.animation.Animator):void, class status: UNLOADED
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
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                });
                ofInt.setInterpolator(expandableTextView.f65090c);
                ofInt.setDuration(expandableTextView.f65092e).start();
            }
            aVar2.j.setInterpolator(new OvershootInterpolator());
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(
/*
Method generation error in method: net.one97.paytm.snackbar.a.1.onClick(android.view.View):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.snackbar.a.1.onClick(android.view.View):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            imageView.setOnClickListener(new View.OnClickListener(snackbar2) {

                /* renamed from: a */
                final /* synthetic */ Snackbar f65110a;

                public final void onClick(
/*
Method generation error in method: net.one97.paytm.snackbar.a.2.onClick(android.view.View):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.snackbar.a.2.onClick(android.view.View):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            if (!TextUtils.isEmpty(aVar2.f65106g)) {
                aVar2.j.setText(aVar2.f65106g);
            }
            if (!TextUtils.isEmpty(aVar2.f65107h)) {
                textView.setText(aVar2.f65107h);
            }
            if (!(aVar2.f65103d == null || aVar2.f65100a == null)) {
                textView2.setText(aVar2.f65100a);
                textView2.setOnClickListener(aVar2.f65103d);
            }
            if (!(aVar2.f65104e == null || aVar2.f65101b == null)) {
                textView3.setText(aVar2.f65101b);
                textView3.setOnClickListener(aVar2.f65104e);
            }
            if (!(aVar2.f65105f == null || aVar2.f65102c == null)) {
                textView4.setText(aVar2.f65102c);
                textView4.setOnClickListener(aVar2.f65105f);
            }
            ExpandableTextView expandableTextView2 = aVar2.j;
            expandableTextView2.f65088a.add(new ExpandableTextView.a(textView2, textView3, textView4) {

                /* renamed from: a */
                final /* synthetic */ TextView f65112a;

                /* renamed from: b */
                final /* synthetic */ TextView f65113b;

                /* renamed from: c */
                final /* synthetic */ TextView f65114c;

                public final void a(
/*
Method generation error in method: net.one97.paytm.snackbar.a.3.a():void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.snackbar.a.3.a():void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/

                public final void b(
/*
Method generation error in method: net.one97.paytm.snackbar.a.3.b():void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.snackbar.a.3.b():void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            ((Snackbar.SnackbarLayout) snackbar2.b()).addView(inflate, 0);
            snackbar2.c();
        }
        this.snackbar = snackbar2;
    }

    public void checkDeepLinking(Context context, String str, String str2) throws UnsupportedEncodingException {
        net.one97.paytm.payments.d.a.a(context, net.one97.paytm.payments.d.a.a(str, str2));
    }

    public void getUserVpaInfo(Context context, final net.one97.paytm.wallet.f.p pVar) {
        g.a().a((a.b) new a.b() {
            public final void a(List<UserVpaInfo> list) {
                pVar.a(list);
            }

            public final void a() {
                pVar.a();
            }
        });
    }

    public int getKYCUserStatus(Context context) {
        return j.b(context);
    }

    public boolean getIsMinKyc(Context context) {
        return j.j(context);
    }

    public void showP2PSnackBar(Context context, ViewGroup viewGroup, String str) {
        final CustomSnackbar build = CustomSnackbar.Builder(context).layout(R.layout.layout_p2p_snackbar).duration(CustomSnackbar.LENGTH.INDEFINITE).swipe(true).build(viewGroup);
        build.show();
        ((TextView) build.getContentView().findViewById(R.id.tv_snack_bar_message)).setText(str);
        ((TextView) build.getContentView().findViewById(R.id.btn_action)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                build.dismiss();
            }
        });
    }

    public void showToolTipView(AppCompatActivity appCompatActivity, View view, int i2, String str, int i3, int i4, boolean z) {
        ab.a(appCompatActivity, view, i2, str, i3, (long) i4);
    }

    public void showHelpDialog(Context context, String str, androidx.fragment.app.j jVar) {
        net.one97.paytm.wallet.c.c cVar;
        if (TextUtils.isEmpty(str)) {
            cVar = net.one97.paytm.wallet.c.c.a(c.a.ALL);
        } else if (!str.equalsIgnoreCase("AMEX")) {
            cVar = net.one97.paytm.wallet.c.c.a(c.a.NON_AMEX);
        } else {
            cVar = net.one97.paytm.wallet.c.c.a(c.a.AMEX);
        }
        cVar.show(jVar, (String) null);
    }

    public String getGoldPortFolioURL(Context context) {
        return net.one97.paytm.jeweller.a.b(context);
    }

    public void openUpdateMessageActivity(Context context) {
        context.startActivity(new Intent(context, AJRUpdateMessage.class));
    }

    public boolean isPPBCustomer(Context context) {
        return net.one97.paytm.utils.a.b.e(context);
    }

    public boolean isPaymentBankUser(Context context) {
        return net.one97.paytm.utils.a.b.f(context);
    }

    public String contactExists(Activity activity, String str) {
        return net.one97.paytm.wallet.newdesign.a.a((Context) activity, str);
    }

    public void setKYCUserStatus(Activity activity, int i2) {
        j.a((Context) activity, i2);
    }

    public boolean isFromMainActivity(Activity activity) {
        return activity != null && (activity instanceof AJRMainActivity);
    }

    public boolean instanceOfTransferToBank(Activity activity) {
        return activity != null && (activity instanceof SendMoneyToBankActivity);
    }

    public boolean instanceOfAddToPPB(Activity activity) {
        return activity != null && (activity instanceof AddMoneyToPPBActivity);
    }

    public boolean instanceOfIDPostcardActiovity(Activity activity) {
        return activity != null && (activity instanceof IndependancePostCardMainActivity);
    }

    public void getWalletToken(String str, Activity activity, com.paytm.network.listener.b bVar) {
        t.a(activity, bVar, a.c.WALLET);
    }

    public Intent getEnterPasscodeIntent(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("enter_passcode");
        ae aeVar = ae.f50307a;
        return ae.a(activity, intent);
    }

    public void setBankAccStatus(Activity activity, CustProductList custProductList) {
        if (custProductList.getIsaStatus().equals("NOT_APPLIED") || custProductList.getIsaStatus().equals("LEAD")) {
            net.one97.paytm.utils.a.b.h(activity.getApplicationContext());
        } else if (custProductList.getIsaStatus().equals("FAILED") || custProductList.getIsaStatus().equals("IN_PROGRESS") || custProductList.getIsaStatus().equals("INITIATED") || custProductList.getIsaStatus().equals("PENDING")) {
            net.one97.paytm.utils.a.b.i(activity.getApplicationContext());
        } else if (custProductList.getIsaStatus().equals("ISSUED")) {
            net.one97.paytm.utils.a.b.j(activity.getApplicationContext());
        }
    }

    public void checkAppCompatTheme(Context context) {
        az.a(context);
    }

    public IJRPaytmDataModel jsonToModel(String str) {
        return (CJPayMethodResponse) ak.a(str, new com.google.gson.b.a<CJPayMethodResponse>() {
        }.getType());
    }

    public void getCstOrderIssueIntent(Context context, Bundle bundle, m mVar) {
        mVar.show();
        net.one97.paytm.deeplink.d.a(context, bundle, mVar);
    }

    public String getBottomTabClickUrlType(Object obj) {
        if (obj instanceof HomeTabItem) {
            return ((HomeTabItem) obj).getUrlType();
        }
        return null;
    }

    public Intent getRechargeActivityIntent(Context context) {
        return new Intent(context, AJRRechargePaymentActivity.class);
    }

    public void openUpgradeKycScreen(Context context) {
        context.startActivity(new Intent(context, UpgradeKycActivity.class));
    }

    public Intent getPaymentSuccessIntent(Context context) {
        return new Intent(context, PaymentSuccessActivity.class);
    }

    public void openForgotPasswordActivity(Context context) {
        context.startActivity(new Intent(context, AJRMainActivity.class));
    }

    public String getBankRSAKey() {
        return getStringFromGTM(CJRJarvisApplication.getAppContext(), "pb_rsa_key");
    }

    public Intent getMoneyTransferIntent(Context context) {
        return new Intent(context, MoneyTransferV3Activity.class);
    }

    public String getContactName(Context context, String str) {
        return net.one97.paytm.wallet.newdesign.a.b(context, str);
    }

    public void onAddMoneyIntent(Context context, CJRHomePageItem cJRHomePageItem) {
        net.one97.paytm.j.a.b("/wallet/add-money", "Wallet", context);
        Objects.requireNonNull(net.one97.paytm.addmoney.d.g());
        Intent a2 = net.one97.paytm.addmoney.d.a(context, "wallet");
        a2.addFlags(67108864);
        a2.addFlags(268435456);
        a2.putExtra("extra_home_data", cJRHomePageItem);
        a2.putExtra("origin", "pushnotification");
        context.startActivity(a2);
    }

    public void initBottomBarTab(Activity activity, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        net.one97.paytm.landingpage.hometabs.a.a();
        net.one97.paytm.landingpage.hometabs.a.b();
        l.a((ViewGroup) linearLayout);
    }

    public boolean showSetReminderView(String str, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        net.one97.paytm.quickpay.d.a a2 = net.one97.paytm.quickpay.d.a.a();
        if (str2.equalsIgnoreCase(f.WALLET.getPayMode())) {
            if (a2.f60094a.get(0) == null || (arrayList3 = (ArrayList) a2.f60094a.get(0)) == null) {
                return true;
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                StandingInstructionList standingInstructionList = (StandingInstructionList) it2.next();
                if (standingInstructionList.getEnablePaymentsReminder() && standingInstructionList.getSupportingData() != null && standingInstructionList.getSupportingData().getBeneficiaryMobileNumber() != null && standingInstructionList.getSupportingData().getBeneficiaryMobileNumber().equalsIgnoreCase(str)) {
                    return false;
                }
            }
            return true;
        } else if (str2.equalsIgnoreCase(f.IMPS.getPayMode())) {
            if (a2.f60094a.get(0) == null || (arrayList2 = (ArrayList) a2.f60094a.get(0)) == null) {
                return true;
            }
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                StandingInstructionList standingInstructionList2 = (StandingInstructionList) it3.next();
                if (standingInstructionList2.getEnablePaymentsReminder() && standingInstructionList2.getSupportingData() != null && standingInstructionList2.getSupportingData().getBeneficiaryAccountNumber() != null && standingInstructionList2.getSupportingData().getBeneficiaryAccountNumber().equalsIgnoreCase(str)) {
                    return false;
                }
            }
            return true;
        } else if (!str2.equalsIgnoreCase(f.UPI.getPayMode()) || a2.f60094a.get(0) == null || (arrayList = (ArrayList) a2.f60094a.get(0)) == null) {
            return true;
        } else {
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                StandingInstructionList standingInstructionList3 = (StandingInstructionList) it4.next();
                if (standingInstructionList3.getEnablePaymentsReminder() && standingInstructionList3.getSupportingData() != null && standingInstructionList3.getSupportingData().getBeneficiaryUpiAddress() != null && standingInstructionList3.getSupportingData().getBeneficiaryUpiAddress().equalsIgnoreCase(str)) {
                    return false;
                }
            }
            return true;
        }
    }

    public void startManageBeneficiary(Activity activity) {
        bf.a(activity);
    }

    public Intent getPaymentReminderCreationActivity(Context context) {
        return new Intent(context, PaymentReminderCreationActivity.class);
    }

    public void signOut(Activity activity, boolean z, NetworkCustomError networkCustomError) {
        net.one97.paytm.auth.b.b.a(activity);
    }

    public void startPassbookSubwalletActivity(Activity activity) {
        net.one97.paytm.payments.d.a.a(activity, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet");
    }

    public boolean handleDeeplinkByEngine(Activity activity, String str, Bundle bundle) {
        h.a aVar = h.f50349a;
        return h.a.a(activity, str, bundle);
    }

    public void getForgotPasscodeIntent(Context context) {
        net.one97.paytm.payments.d.a.a(context, "paytmmp://payment_bank?featuretype=fgt_passcode");
    }

    public void sendCustomGTMEvents(String str, String str2, String str3, String str4, Context context, String str5, String str6) {
        net.one97.paytm.j.a.a(context, str, str2, str3, (String) null, str5, str6);
    }

    public void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6);
    }

    public boolean handleDeepLink(Context context, String str, Bundle bundle) {
        h.a aVar = h.f50349a;
        return h.a.a(context, str, bundle);
    }

    public void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public String getTokenUrl() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.f();
    }

    public Context getContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        r.a(activity, exc, str, bundle);
    }

    public void showSessionTimeoutAlert(Activity activity) {
        r.a(activity, (String) null, (Bundle) null);
    }

    public boolean checkErrorCode(Activity activity, NetworkCustomError networkCustomError) {
        return r.a((Context) activity, (Exception) networkCustomError);
    }

    public boolean reportError(Context context, NetworkCustomError networkCustomError, String str) {
        return r.a(context, (Exception) networkCustomError, str);
    }

    public boolean isAppRejected(CJRPPAccount cJRPPAccount) {
        return cJRPPAccount.getApplicationStatus() == a.APPLICATION_REJECTED.toString();
    }

    public boolean isAppConfirmed(CJRPPAccount cJRPPAccount) {
        return cJRPPAccount.getApplicationStatus() == a.APPLICATION_CONFIRMED.toString();
    }

    public boolean isAppAccepted(CJRPPAccount cJRPPAccount) {
        return cJRPPAccount.getApplicationStatus() == a.APPLICATION_ACCEPTED.toString();
    }

    public void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public String deeplinkSchemaName() {
        return net.one97.paytm.payments.d.a.a();
    }

    public void signOut(Activity activity) {
        if (mActivityHelper == null) {
            mActivityHelper = d.b();
        }
        net.one97.paytm.h.a aVar = mActivityHelper;
        if (aVar != null) {
            aVar.a(activity);
        }
    }

    public void pushHawkeyeEvent(Context context, String str, String str2, String str3, int i2, String str4, NetworkResponse networkResponse, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar) {
        int i3;
        au.e eVar = new au.e();
        String str5 = networkResponse.headers.get("ContentEncoding");
        if (!(networkResponse == null || networkResponse.data == null)) {
            if (str5 == null || !str5.equals("gzip")) {
                i3 = new String(networkResponse.data).getBytes().length;
            } else {
                i3 = networkResponse.data.length;
            }
            eVar.r = i3;
        }
        eVar.p = i2;
        eVar.o = com.paytm.utility.b.P(str4);
        eVar.q = j;
        eVar.v = str;
        eVar.n = str3;
        eVar.w = str2;
        if (!(i2 == 401 || i2 == 403 || i2 == 410)) {
            if (bVar != null) {
                eVar.t = bVar.toString();
            } else {
                eVar.t = "None";
            }
        }
        if (hashMap != null) {
            eVar.m = hashMap.get("screen_name");
        }
        if (cVar != null) {
            eVar.l = cVar.toString();
        } else {
            eVar.l = a.c.P2P.toString();
        }
        au.a(eVar, au.c.LocalError.stringValue, context);
    }

    public void pushHawkeyeEvent(Context context, int i2, String str, String str2, String str3, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar) {
        au.e eVar = new au.e();
        eVar.o = com.paytm.utility.b.P(str);
        eVar.f69690e = au.c.LocalError.stringValue;
        if (!(i2 == 401 || i2 == 403 || i2 == 410)) {
            if (bVar != null) {
                eVar.t = bVar.toString();
            } else {
                eVar.t = "None";
            }
        }
        if (hashMap != null) {
            eVar.m = hashMap.get("screen_name");
            if (!TextUtils.isEmpty(hashMap.get("flowName"))) {
                eVar.n = hashMap.get("flowName");
            }
            if (!TextUtils.isEmpty(hashMap.get("mid"))) {
                eVar.v = hashMap.get("mid");
            }
            if (!TextUtils.isEmpty(hashMap.get(Constants.RISK_TRANSACTION_ID))) {
                eVar.w = hashMap.get(Constants.RISK_TRANSACTION_ID);
            }
            if (!TextUtils.isEmpty(hashMap.get("scan_capture_time"))) {
                eVar.g("scan_capture_time " + hashMap.get("scan_capture_time"));
            }
        }
        if (cVar != null) {
            eVar.l = cVar.toString();
        } else {
            eVar.l = a.c.P2P.toString();
        }
        if (!(i2 == 401 || i2 == 403 || i2 == 410)) {
            if (bVar != null) {
                eVar.t = bVar.toString();
            } else {
                eVar.t = "None";
            }
        }
        eVar.u = str3;
        au.a(eVar, au.c.LocalError.stringValue, context);
    }

    public void pushScanSessionHawkeyeEvent(Context context, QrData qrData) {
        au.e eVar = new au.e();
        eVar.f69686a = qrData;
        au.a(eVar, "qrLog", context);
    }

    public void pushScanCodeHawkeyeEvent(Context context, QrData qrData) {
        au.e eVar = new au.e();
        eVar.f69686a = qrData;
        au.a(eVar, "qrLog", context);
    }

    public void pushClickOnPayHawkeyeEvent(Context context, String str, long j) {
        au.e eVar = new au.e();
        eVar.n = str;
        eVar.g(String.valueOf(j));
        au.a(eVar, SDKConstants.AI_PAY_BUTTON_CLICKED, context);
    }

    public String addBeneficiaryURL(Activity activity) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.L();
    }

    public void addBeneficiaryAPICall(Context context, String str, final net.one97.paytm.wallet.newdesign.addbeneficiary.h hVar, CJRAddBeneficiary cJRAddBeneficiary, Map<String, String> map, String str2) {
        net.one97.paytm.wallet.newdesign.addbeneficiary.h hVar2 = hVar;
        net.one97.paytm.common.b.d.a(context, str, new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                hVar.a((IJRDataModel) iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                hVar.a(networkCustomError);
            }
        }, map, (Map<String, String>) null, a.C0715a.POST, str2, new CJRAddBeneficiary(), a.c.PAYMENTS, a.b.SILENT).a();
    }

    public String getValidateBeneficiaryUrl(Context context) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.M();
    }

    public Intent openManageBeneficiaryIntent(Context context) {
        return new Intent(context, ManageWalletBeneficiaryActivity.class);
    }

    public void startSetMpinActivity(UpiProfileDefaultBank upiProfileDefaultBank, Activity activity) {
        Intent intent = new Intent(activity, SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
        activity.startActivityForResult(intent, 13);
    }

    public void checkPPBUpdateBalance(Context context, final net.one97.paytm.wallet.newdesign.c.c cVar, String str, String str2, String str3) {
        new net.one97.paytm.moneytransfer.e.d().a(context, new d.b() {
            public final void a(PPBPrevalidateResponseModel pPBPrevalidateResponseModel) {
                cVar.a(pPBPrevalidateResponseModel);
            }

            public final void a(NetworkCustomError networkCustomError) {
                cVar.a();
            }

            public final void a() {
                cVar.b();
            }
        }, str, str2, str3);
    }

    public void startHelpAndSupport(Context context) {
        net.one97.paytm.payments.d.a.a(context, "paytmmp://contactus");
    }

    public void openScreenViaDeeplink(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public Intent getWebViewIntent(Context context) {
        return new Intent(context, AJREmbedWebView.class);
    }

    public void pushCrashEventToCrashlytics(String str, String str2, Throwable th) {
        r.a(str, str2, th);
    }

    public void handleSessionTimeout(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        r.a(activity, str, bundle, false, z);
    }

    public void sendAdSlotImpressions(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        if (str2.equalsIgnoreCase("promotionImpression")) {
            net.one97.paytm.j.a.a(cJRHomePageItem, context, i2, str);
        } else {
            net.one97.paytm.j.a.e(cJRHomePageItem, context, i2, str);
        }
    }

    public void loadPageCJRActivityNavigation(Context context, String str, CJRHomePageItem cJRHomePageItem, String str2, int i2, ArrayList<? extends CJRItem> arrayList, String str3) {
        net.one97.paytm.utils.j.a(context, str, (IJRDataModel) cJRHomePageItem, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null, (net.one97.paytm.c) null);
    }

    public a getVSCCommunicator(Context context) {
        return new VisaSingleClickCommunicator();
    }

    public boolean isVscpEnabled(Context context) {
        return bf.a(context);
    }

    public void handleSessionTimeout(Activity activity, Exception exc, String str, Bundle bundle, boolean z, boolean z2) {
        r.a(activity, str, bundle, z2, z);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public void openH5(Activity activity, Bundle bundle, m mVar) {
        net.one97.paytm.deeplink.d.a((Context) activity, bundle, mVar);
    }

    public Fragment getPostPaymentDealsFragment() {
        return new n();
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.b(str, map, context);
    }

    public Class<?> getTrustSealActivity() {
        return AJRTrustSeal.class;
    }

    public boolean initializeCashbackJarvisHelper() {
        return net.one97.paytm.deeplink.e.a();
    }

    public void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, Object obj, Object obj2, String str5, String str6) {
        net.one97.paytm.j.a.b(context, str, str2, str3, str4, str5, str6);
    }

    public void startMoneyTransferActivity(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2) {
        net.one97.paytm.moneytransfer.utils.m.a(context, i2, iJRDataModel);
    }

    public Fragment getMTTopBlueIconFragment(Bundle bundle) {
        a.C1014a aVar = net.one97.paytm.moneytransferv4.b.a.a.a.g.a.f55292b;
        return a.C1014a.a(bundle);
    }

    public void openPaytmInviteScreen(Context context, String str, String str2) {
        net.one97.paytm.moneytransfer.utils.m.a(context, str, str2);
    }

    public void startMoneyTransferActivityForResult(Activity activity, IJRDataModel iJRDataModel, int i2) {
        net.one97.paytm.moneytransfer.utils.m.a(activity, i2, iJRDataModel);
    }

    public Intent getVerifyPasscodeActivity(Activity activity, Intent intent) {
        intent.setAction("open_passcode_screen");
        ae aeVar = ae.f50307a;
        return ae.a(activity, intent);
    }

    public int getKYCExpriy(Context context) {
        return j.d(context);
    }

    public void sendPaymentSessionEvent(Context context, QrData qrData) {
        au.e eVar = new au.e();
        eVar.f69686a = qrData;
        au.a(eVar, "qrLog", context);
    }

    public Application getApplication() {
        return (Application) CJRJarvisApplication.getAppContext();
    }

    public Fragment getSfBannerFragment(Activity activity, View view, String str, a.c cVar) {
        c.a aVar = net.one97.paytm.wallet.newdesign.d.c.f70867a;
        return c.a.a(activity, view, str, cVar);
    }

    public int getIntegerFromGTM(String str, int i2) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, i2);
    }

    public void startMoneyTransferActivityForResult(Activity activity, int i2, IJRDataModel iJRDataModel, String str, String str2, int i3) {
        net.one97.paytm.moneytransfer.utils.m.a(activity, i2, iJRDataModel, i3);
    }

    public void startMoneyTransferFromPay(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2) {
        net.one97.paytm.moneytransfer.utils.m.b(context, i2, iJRDataModel);
    }

    public void startMTFromScan(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2) {
        net.one97.paytm.moneytransfer.utils.m.d(context, i2, iJRDataModel);
    }

    public void startMTFromDeeplink(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2) {
        net.one97.paytm.moneytransfer.utils.m.c(context, i2, iJRDataModel);
    }

    public void startMoneyTransferActivityForPayResult(Activity activity, int i2, IJRDataModel iJRDataModel, String str, String str2, int i3) {
        net.one97.paytm.moneytransfer.utils.m.b(activity, i2, iJRDataModel, i3);
    }

    public String getJWTToken(Map<String, Object> map, Map<String, Object> map2, String str, String str2) {
        String str3;
        String str4;
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            if (map != null) {
                str3 = fVar.b(map);
            } else {
                str3 = "";
            }
            if (map2 != null) {
                if (!TextUtils.isEmpty(str)) {
                    map2.put("iss", str);
                }
                str4 = fVar.b(map2);
            } else {
                str4 = "";
            }
            String replaceAll = (Base64.encodeToString(str3.getBytes(), 1) + AppUtility.CENTER_DOT + Base64.encodeToString(str4.getBytes(), 1)).replaceAll(StringUtility.NEW_LINE, "").replaceAll("\r", "");
            return (replaceAll + AppUtility.CENTER_DOT + Base64.encodeToString(av.a(replaceAll, str2), 9)).replaceAll(StringUtility.NEW_LINE, "").replaceAll("\r", "");
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return "";
        }
    }

    public String modelToJson(CJRBinRequest cJRBinRequest) {
        return new com.google.gson.f().a((Object) cJRBinRequest, new com.google.gson.b.a<Object>() {
        }.getType());
    }

    public void showJewellerPriceAlert(Context context, String str) {
        if (!((Activity) context).isFinishing()) {
            String str2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f() == null ? null : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13091g;
            net.one97.paytm.jeweller.a.a(context, "/digital_gold_offline/pay_screen", "digital_gold_offline", "info_clicked", str, str2, com.paytm.utility.b.n(context));
            Dialog dialog = new Dialog(context);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            View inflate = LayoutInflater.from(context).inflate(net.one97.paytm.wallet.R.layout.gold_jeweller_price_alert_layout, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(net.one97.paytm.wallet.R.id.btn_okay_click);
            String stringFromGTM = b.a().getStringFromGTM(context, "gold_jeweller_purity_text");
            if (TextUtils.isEmpty(stringFromGTM)) {
                stringFromGTM = context.getResources().getString(net.one97.paytm.wallet.R.string.gold_24k_purity_text);
            }
            ((TextView) inflate.findViewById(net.one97.paytm.wallet.R.id.txt_message_1)).setText(context.getString(net.one97.paytm.wallet.R.string.paytm_gold_je_info_dialog_des1, new Object[]{stringFromGTM, str2}));
            ((TextView) inflate.findViewById(net.one97.paytm.wallet.R.id.txt_message_2)).setText(context.getString(net.one97.paytm.wallet.R.string.paytm_gold_je_info_dialog_des2, new Object[]{str2, stringFromGTM}));
            button.setOnClickListener(new View.OnClickListener(context, str, dialog) {

                /* renamed from: a */
                final /* synthetic */ Context f51037a;

                /* renamed from: b */
                final /* synthetic */ String f51038b;

                /* renamed from: c */
                final /* synthetic */ Dialog f51039c;

                public final void onClick(
/*
Method generation error in method: net.one97.paytm.jeweller.a.1.onClick(android.view.View):void, dex: classes3.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.jeweller.a.1.onClick(android.view.View):void, class status: UNLOADED
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
            dialog.setContentView(inflate);
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    public void openAddBeneficiaryFromP2P(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, AddNewBeneficiaryV2Activity.class);
        intent.putExtra("mobileNumber", str);
        intent.putExtra("from_p2p", str2);
        activity.startActivity(intent);
    }

    public void callVerifierIntent(Activity activity, CJRIMPSInitiateDataModel cJRIMPSInitiateDataModel) {
        Intent intent = new Intent(activity, VerifierBasicActivity.class);
        intent.putExtra("verifier_verifyID", cJRIMPSInitiateDataModel.getExtraInfoDataModel().getVerify_id());
        intent.putExtra("verifier_method", cJRIMPSInitiateDataModel.getExtraInfoDataModel().getVerification_method());
        intent.putExtra("verifier_method_list", cJRIMPSInitiateDataModel.getExtraInfoDataModel().getVerification_methods());
        activity.startActivityForResult(intent, 2020);
    }

    public void markAsPaid(String str, String str2, boolean z, Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", net.one97.paytm.common.b.d.a().b(context));
        hashMap.put("Content-Type", "application/json");
        String a2 = net.one97.paytm.common.b.d.a().a(str, "QUICK_PAYMENTS", z);
        if (!TextUtils.isEmpty(a2)) {
            String a3 = com.paytm.utility.c.a(context, false);
            if (!TextUtils.isEmpty(a3) && a3.contains("?")) {
                a2 = a2 + a3.replace("?", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
            }
            String str3 = a2;
            if (com.paytm.utility.a.m(context)) {
                net.one97.paytm.common.b.d.a(context, str3, new com.paytm.network.listener.b(str, context) {

                    /* renamed from: a */
                    final /* synthetic */ String f60133a;

                    /* renamed from: b */
                    final /* synthetic */ Context f60134b;

                    public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.quickpay.utilities.c.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes6.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.utilities.c.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
Method generation error in method: net.one97.paytm.quickpay.utilities.c.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes6.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.utilities.c.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                }, hashMap, (Map<String, String>) null, a.C0715a.PUT, "", new DeleteQuickPayResponse(), a.c.PAYMENTS, a.b.SILENT).a();
            }
        }
    }
}
