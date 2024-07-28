package net.one97.paytm.p2mNewDesign.i;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.base.d;
import net.one97.paytm.common.entity.paymentsbank.CJRVerifyPasscodeResponse;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.p2mNewDesign.d.g;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse;
import net.one97.paytm.p2mNewDesign.entity.CJRPGInstrumentBalance;
import net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.h.b;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.communicator.c;

public final class a extends androidx.lifecycle.a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static LiveData<f> a(Context context, CJRQRScanResultModel cJRQRScanResultModel, String str, String str2) {
        String str3;
        String str4;
        String str5;
        Context context2 = context;
        k.c(context2, "context");
        k.c(cJRQRScanResultModel, "qrScanResultModel");
        k.c(str, "amount");
        b bVar = b.f51296a;
        String a2 = b.a(context, cJRQRScanResultModel, str, str2);
        b bVar2 = b.f51296a;
        HashMap<String, String> a3 = b.a(context);
        boolean z = !TextUtils.isEmpty(cJRQRScanResultModel.getMerchantTransId());
        if (net.one97.paytm.wallet.utility.a.m(context)) {
            StringBuilder sb = new StringBuilder();
            sb.append(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context2, "offlinePGFetchPayOptionsv2"));
            sb.append("?device-id=");
            sb.append(UpiUtils.getDeviceId(context));
            sb.append("&mid=");
            sb.append(cJRQRScanResultModel.getMappingId());
            if (z) {
                str5 = "&orderId=" + cJRQRScanResultModel.getMerchantTransId();
            } else {
                str5 = "";
            }
            sb.append(str5);
            str3 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context2, "offlinePGFetchPayOptions"));
            sb2.append("?mid=");
            sb2.append(cJRQRScanResultModel.getMappingId());
            if (z) {
                str4 = "&orderId=" + cJRQRScanResultModel.getMerchantTransId();
            } else {
                str4 = "";
            }
            sb2.append(str4);
            str3 = sb2.toString();
        }
        String e2 = com.paytm.utility.b.e(context2, str3);
        k.a((Object) e2, "CJRAppCommonUtility.addA…ntext!!, mFetchMethodUrl)");
        net.one97.paytm.network.b bVar3 = new net.one97.paytm.network.b(e2, new CJRFetchPayMethodResponse(), (Map<String, String>) null, a3, a2);
        bVar3.e();
        bVar3.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context2, "payment_instrument_api_timeout")));
        if (com.paytm.utility.b.c(context)) {
            return bVar3.a();
        }
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        String str6 = g.f51121a;
        k.a((Object) str6, "FJRQRSendMoneyFragmentV4.TAG");
        map.put("screen_name", str6);
        String mappingId = cJRQRScanResultModel.getMappingId();
        k.a((Object) mappingId, "qrScanResultModel.getMappingId()");
        map.put("mid", mappingId);
        map.put("flowName", "Offline_Payments");
        net.one97.paytm.wallet.communicator.b.a().pushHawkeyeEvent(context, -1, e2, a2, "Sorry,no internet connectivity detected.Please reconnect and try again", 0, a.b.USER_FACING, hashMap, a.c.PAY);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b("");
        return d.f49504d.a(context2, bVar3);
    }

    public static LiveData<f> a(Context context, String str, CJRQRScanResultModel cJRQRScanResultModel) {
        k.c(context, "context");
        k.c(str, "mobileNumber");
        k.c(cJRQRScanResultModel, "mQRScanResultModel");
        String e2 = com.paytm.utility.b.e(context, net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "pgWalletBalanceURL"));
        b bVar = b.f51296a;
        HashMap<String, String> b2 = b.b(context);
        b bVar2 = b.f51296a;
        net.one97.paytm.network.b bVar3 = new net.one97.paytm.network.b(e2, new CJRCashWallet(), (Map<String, String>) null, b2, b.a(str, cJRQRScanResultModel).toString());
        bVar3.e();
        bVar3.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        if (com.paytm.utility.b.c(context)) {
            return bVar3.a();
        }
        return d.f49504d.a(context, bVar3);
    }

    public static LiveData<f> a(Context context, CJRQRScanResultModel cJRQRScanResultModel, String str, String str2, CJRLinkBasePaymentResponse cJRLinkBasePaymentResponse, String str3, InstrumentInfo instrumentInfo, String str4, String str5, String str6) {
        String str7;
        k.c(context, "context");
        k.c(cJRQRScanResultModel, "mQRScanResultModel");
        k.c(str, "amount");
        k.c(str2, "additionInfo");
        k.c(str3, "referenceId");
        k.c(instrumentInfo, "instrumentInfo");
        HashMap hashMap = new HashMap();
        b bVar = b.f51296a;
        String a2 = b.a(context, cJRQRScanResultModel, str, str2, cJRLinkBasePaymentResponse, str3, instrumentInfo, str4, str5, str6);
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        map.put("Accept-Encoding", "gzip");
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(context, "enableGzipCompressionForPtc", false)) {
            map.put("Accept-Compression", "gzip");
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        k.a((Object) f2, "net.one97.paytm.p2mNewDe…ctPaymentBl.getInstance()");
        if (!TextUtils.isEmpty(f2.d())) {
            StringBuilder sb = new StringBuilder();
            sb.append(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "offlinePGProcessTrans"));
            sb.append("?mid=");
            sb.append(cJRQRScanResultModel.getMappingId());
            sb.append("&orderId=");
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f3, "net.one97.paytm.p2mNewDe…ctPaymentBl.getInstance()");
            sb.append(f3.d());
            str7 = sb.toString();
        } else {
            str7 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "offlinePGProcessTrans") + "?mid=" + cJRQRScanResultModel.getMappingId() + "&refId=" + str3;
        }
        String e2 = com.paytm.utility.b.e(context, str7);
        k.a((Object) e2, "CJRAppCommonUtility.addA…ontext!!, transcationUrl)");
        String u = net.one97.paytm.wallet.utility.a.u(e2);
        k.a((Object) u, "CJRWalletUtility.addUser…ImeiParam(transcationUrl)");
        net.one97.paytm.network.b bVar2 = new net.one97.paytm.network.b(u, new CJRProcessTranscationResponse(), (Map<String, String>) null, map, a2);
        bVar2.e();
        bVar2.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        if (com.paytm.utility.b.c(context)) {
            return bVar2.a();
        }
        return d.f49504d.a(context, bVar2);
    }

    public static LiveData<f> a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "passcode");
        Map hashMap = new HashMap();
        String m = com.paytm.utility.b.m();
        k.a((Object) m, "CJRAppCommonUtility.getAuthorizationValue()");
        hashMap.put("Authorization", m);
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        String a2 = com.paytm.utility.d.a(context);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        hashMap.put("session_token", a2);
        c a3 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
        String a4 = com.paytm.e.a.b.a(a3.getBankRSAKey(), str);
        c a5 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a5, "WalletCommManager.getWalletCommunicator()");
        String e2 = com.paytm.utility.b.e(context, a5.getTokenUrl());
        be.a aVar = be.f69718a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a6 = be.a.a(applicationContext);
        String str2 = "grant_type=" + URLEncoder.encode("password", AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode(a6.b("mobile", "", true), AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(a4, AppConstants.UTF_8) + "&scope=" + URLEncoder.encode(BuildConfig.BANK_TXN_SCOPE, AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("passcode", AppConstants.UTF_8);
        k.a((Object) str2, "StringBuilder(\"grant_typ…de\", \"UTF-8\")).toString()");
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(e2, new CJRVerifyPasscodeResponse(), (Map<String, String>) null, hashMap, str2);
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        if (com.paytm.utility.b.c(context)) {
            return bVar.a();
        }
        return d.f49504d.a(context, bVar);
    }

    public static LiveData<f> a(String str, Context context, String str2, boolean z) {
        int i2;
        k.c(str, SDKConstants.KEY_PAYMODE);
        k.c(context, "context");
        k.c(str2, "mappingID");
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        String a2 = com.paytm.utility.d.a(context);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        hashMap.put("Authorization", a2);
        b bVar = b.f51296a;
        net.one97.paytm.network.b bVar2 = new net.one97.paytm.network.b(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(context, "offlinePGFetchPPB") + "?mid=" + str2, new CJRPGInstrumentBalance(), (Map<String, String>) null, hashMap, b.a(str, str2, context));
        bVar2.e();
        if (z) {
            i2 = 4;
        } else {
            i2 = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "checkBalanceAPITimeOut");
        }
        bVar2.a(net.one97.paytm.wallet.utility.a.a(i2));
        if (com.paytm.utility.b.c(context)) {
            return bVar2.a();
        }
        return d.f49504d.a(context, bVar2);
    }
}
