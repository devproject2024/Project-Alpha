package net.one97.paytm.p2mNewDesign.h;

import android.content.Context;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.utility.d;
import com.sendbird.android.constant.StringSet;
import easypay.manager.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.communicator.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f51296a = new b();

    private b() {
    }

    public static String a(Context context, CJRQRScanResultModel cJRQRScanResultModel, String str, String str2) {
        k.c(context, "context");
        k.c(cJRQRScanResultModel, "mQRScanResultModel");
        k.c(str, "amount");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(cJRQRScanResultModel.getMerchantTransId());
        try {
            String str3 = com.paytm.utility.b.v(context) + System.currentTimeMillis();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f2, "DirectPaymentBl.getInstance()");
            f2.i(cJRQRScanResultModel.getMappingId());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.put(StringSet.token, d.a(context));
            String a2 = com.paytm.utility.b.a();
            k.a((Object) a2, "CJRAppCommonUtility.getTokenType()");
            String upperCase = a2.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            jSONObject2.put("tokenType", upperCase);
            c a3 = net.one97.paytm.wallet.communicator.b.a();
            k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
            jSONObject2.put("version", a3.getVersionName());
            jSONObject2.put("channelId", "APP");
            jSONObject3.put("mid", cJRQRScanResultModel.getMappingId());
            if (z2) {
                z = false;
            }
            jSONObject3.put("generateOrderId", z);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("additionalInfo", str2);
                jSONObject3.put(Constants.RISK_EXTENDED_INFO, jSONObject4);
            }
            jSONObject2.put("requestId", str3);
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f3, "DirectPaymentBl.getInstance()");
            f3.j(str);
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f4, "DirectPaymentBl.getInstance()");
            f4.k(cJRQRScanResultModel.getMerchantTransId());
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
            String jSONObject5 = jSONObject.toString();
            k.a((Object) jSONObject5, "fetchPayJsonObject.toString()");
            return jSONObject5;
        } catch (JSONException unused) {
            return "";
        }
    }

    public static HashMap<String, String> a(Context context) {
        k.c(context, "context");
        HashMap<String, String> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        map.put("Accept-Compression", "gzip");
        return hashMap;
    }

    public static HashMap<String, String> b(Context context) {
        k.c(context, "context");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ssotoken", d.a(context));
        hashMap.put("Accept-Encoding", "gzip");
        new StringBuilder("SSO Token :: ").append(d.a(context));
        com.paytm.utility.b.j();
        return hashMap;
    }

    public static String a(String str, CJRQRScanResultModel cJRQRScanResultModel) {
        k.c(str, "mobileNumber");
        k.c(cJRQRScanResultModel, "mQRScanResultModel");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject2.put("payeePhoneNo", str);
        }
        if (cJRQRScanResultModel.getMerchantGUID() != null) {
            jSONObject2.put(CJRQRScanResultModel.KEY_MERCHANT_GUID, cJRQRScanResultModel.getMerchantGUID());
        }
        if (cJRQRScanResultModel.getMappingId() != null) {
            jSONObject2.put("mid", cJRQRScanResultModel.getMappingId());
        }
        jSONObject.put("request", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        k.a((Object) jSONObject3, "requestBody.toString()");
        return jSONObject3;
    }

    public static String a(Context context, CJRQRScanResultModel cJRQRScanResultModel, String str, String str2, CJRLinkBasePaymentResponse cJRLinkBasePaymentResponse, String str3, InstrumentInfo instrumentInfo, String str4, String str5, String str6) {
        String str7;
        String str8;
        String str9 = str;
        CJRLinkBasePaymentResponse cJRLinkBasePaymentResponse2 = cJRLinkBasePaymentResponse;
        String str10 = str4;
        String str11 = str6;
        k.c(context, "context");
        k.c(str9, "amount");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        jSONObject2.put(StringSet.token, d.a(context));
        String a2 = com.paytm.utility.b.a();
        k.a((Object) a2, "CJRAppCommonUtility.getTokenType()");
        String upperCase = a2.toUpperCase();
        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        jSONObject2.put("tokenType", upperCase);
        c a3 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
        jSONObject2.put("version", a3.getVersionName());
        jSONObject2.put("channelId", "APP");
        jSONObject3.put("mid", cJRQRScanResultModel != null ? cJRQRScanResultModel.getMappingId() : null);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        k.a((Object) f2, "DirectPaymentBl.getInstance()");
        if (!TextUtils.isEmpty(f2.d())) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f3, "DirectPaymentBl.getInstance()");
            jSONObject3.put("orderId", f3.d());
        } else {
            jSONObject3.put("refId", str3);
        }
        jSONObject3.put("deviceId", UpiUtils.getDeviceId(context));
        jSONObject3.put("requestType", "NATIVE");
        jSONObject3.put("txnAmount", str9);
        jSONObject3.put(PayUtility.WEBSITE, "retail");
        String linkType = cJRQRScanResultModel != null ? cJRQRScanResultModel.getLinkType() : null;
        JSONObject jSONObject4 = new JSONObject();
        if (!TextUtils.isEmpty(linkType)) {
            jSONObject4.put("mercUnqRef", cJRQRScanResultModel != null ? cJRQRScanResultModel.getId() : null);
        } else {
            jSONObject4.put("mercUnqRef", cJRQRScanResultModel != null ? cJRQRScanResultModel.getQrCodeId() : null);
        }
        jSONObject4.put("udf1", cJRQRScanResultModel != null ? cJRQRScanResultModel.getPosId() : null);
        jSONObject4.put("additionalInfo", str2);
        if (cJRLinkBasePaymentResponse2 != null) {
            jSONObject4.put("linkDesc", cJRLinkBasePaymentResponse2.linkDescription);
            jSONObject4.put("linkId", cJRLinkBasePaymentResponse2.id);
            jSONObject4.put("linkInvoiceId", cJRLinkBasePaymentResponse.getInvoiceId());
            jSONObject4.put(AppConstants.TAG_LINK_NAME, cJRLinkBasePaymentResponse2.linkName);
        }
        jSONObject3.put(Constants.RISK_EXTENDED_INFO, jSONObject4);
        net.one97.paytm.f.b a4 = net.one97.paytm.f.b.a();
        k.a((Object) a4, "RiskInformationController.getInstance()");
        jSONObject3.put("riskExtendInfo", a4.e());
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("currency", "INR");
        jSONObject5.put("value", str9);
        jSONObject3.put("txnAmount", jSONObject5);
        if (p.a("PAYTM_DIGITAL_CREDIT", instrumentInfo != null ? instrumentInfo.getPayMode() : null, true)) {
            jSONObject3.put("paymentMode", "PAYTM_DIGITAL_CREDIT");
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } else {
            if (p.a("GIFT_VOUCHER", instrumentInfo != null ? instrumentInfo.getPayMode() : null, true)) {
                jSONObject3.put("paymentMode", "GIFT_VOUCHER");
                jSONObject3.put(PayUtility.TEMPLATE_ID, instrumentInfo != null ? instrumentInfo.getTempleteId() : null);
                jSONObject.put("head", jSONObject2);
                jSONObject.put("body", jSONObject3);
            } else {
                if (p.a(SDKConstants.AI_KEY_PPBL, instrumentInfo != null ? instrumentInfo.getPayMode() : null, true)) {
                    jSONObject3.put("paymentMode", SDKConstants.AI_KEY_PPBL);
                    jSONObject3.put(PayUtility.MPIN, instrumentInfo != null ? instrumentInfo.getPaymentDetails() : null);
                    jSONObject.put("head", jSONObject2);
                    jSONObject.put("body", jSONObject3);
                } else {
                    if (p.a(SDKConstants.CREDIT, instrumentInfo != null ? instrumentInfo.getPayMode() : null, true)) {
                        jSONObject3.put("paymentMode", SDKConstants.CREDIT);
                        jSONObject3.put(PayUtility.CARD_INFO, instrumentInfo != null ? instrumentInfo.getPaymentDetails() : null);
                        jSONObject3.put(PayUtility.AUTH_MODE, "otp");
                        if ((instrumentInfo != null ? instrumentInfo.getmAdditionalParams() : null) != null) {
                            jSONObject3.put(PayUtility.STORE_INSTRUMENT, (instrumentInfo != null ? instrumentInfo.getmAdditionalParams() : null).optString(CJRPGTransactionRequestUtils.STORE_CARD, "0"));
                        }
                        if (!TextUtils.isEmpty(str11)) {
                            try {
                                jSONObject3.put("oneClickInfo", new JSONObject(str11));
                            } catch (JSONException unused) {
                            }
                        }
                        jSONObject.put("head", jSONObject2);
                        jSONObject.put("body", jSONObject3);
                    } else {
                        if (instrumentInfo != null) {
                            str8 = instrumentInfo.getPayMode();
                            str7 = "DirectPaymentBl.getInstance()";
                        } else {
                            str7 = "DirectPaymentBl.getInstance()";
                            str8 = null;
                        }
                        if (p.a(SDKConstants.DEBIT, str8, true)) {
                            jSONObject3.put("paymentMode", SDKConstants.DEBIT);
                            jSONObject3.put(PayUtility.CARD_INFO, instrumentInfo != null ? instrumentInfo.getPaymentDetails() : null);
                            jSONObject3.put(PayUtility.AUTH_MODE, "otp");
                            if ((instrumentInfo != null ? instrumentInfo.getmAdditionalParams() : null) != null) {
                                jSONObject3.put(PayUtility.STORE_INSTRUMENT, (instrumentInfo != null ? instrumentInfo.getmAdditionalParams() : null).optString(CJRPGTransactionRequestUtils.STORE_CARD, "0"));
                            }
                            if (!TextUtils.isEmpty(str11)) {
                                try {
                                    jSONObject3.put("oneClickInfo", new JSONObject(str11));
                                } catch (JSONException unused2) {
                                }
                            }
                            jSONObject.put("head", jSONObject2);
                            jSONObject.put("body", jSONObject3);
                        } else {
                            if (p.a("UPI", instrumentInfo != null ? instrumentInfo.getPayMode() : null, true)) {
                                jSONObject3.put("paymentMode", "UPI");
                                String str12 = str4;
                                if (!TextUtils.isEmpty(str12)) {
                                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                                    String str13 = str7;
                                    k.a((Object) f4, str13);
                                    if (f4.l() instanceof UpiInstrumentInfo) {
                                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                                        k.a((Object) f5, str13);
                                        InstrumentInfo l = f5.l();
                                        if (l != null) {
                                            UpiBaseDataModel upiDataModel = ((UpiInstrumentInfo) l).getUpiDataModel();
                                            if (upiDataModel != null) {
                                                UpiProfileDefaultBank upiProfileDefaultBank = (UpiProfileDefaultBank) upiDataModel;
                                                if (upiProfileDefaultBank.getDebitBank() != null) {
                                                    jSONObject3.put("channelCode", SDKConstants.PUSH_FROM_PUSH);
                                                    jSONObject3.put(PayUtility.MPIN, str12);
                                                    jSONObject3.put(PayUtility.PAYER_ACCOUNT, upiProfileDefaultBank.getVirtualAddress());
                                                    jSONObject3.put("seqNumber", str5);
                                                    jSONObject3.put("creditBlock", new f().b(upiProfileDefaultBank));
                                                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                                                    k.a((Object) f6, str13);
                                                    if (f6.J()) {
                                                        jSONObject3.put(PayUtility.UPI_ACC_REF_IF, instrumentInfo != null ? instrumentInfo.getAccountNumber() : null);
                                                        jSONObject3.put("bankName", upiProfileDefaultBank.getDebitBank().getBank());
                                                    } else {
                                                        jSONObject3.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, instrumentInfo != null ? instrumentInfo.getAccountNumber() : null);
                                                        jSONObject3.put("bankName", upiProfileDefaultBank.getDebitBank().getBank());
                                                    }
                                                }
                                            } else {
                                                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank");
                                            }
                                        } else {
                                            throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo");
                                        }
                                    }
                                }
                                jSONObject.put("head", jSONObject2);
                                jSONObject.put("body", jSONObject3);
                            } else {
                                if (p.a("NET_BANKING", instrumentInfo != null ? instrumentInfo.getPayMode() : null, true)) {
                                    jSONObject3.put("paymentMode", "NET_BANKING");
                                    jSONObject3.put("channelCode", instrumentInfo != null ? instrumentInfo.getBankCode() : null);
                                    jSONObject3.put("bankName", instrumentInfo != null ? instrumentInfo.getBankCode() : null);
                                    jSONObject.put("head", jSONObject2);
                                    jSONObject.put("body", jSONObject3);
                                } else {
                                    if (p.a("emi", instrumentInfo != null ? instrumentInfo.getPayMode() : null, true)) {
                                        jSONObject3.put("paymentMode", "EMI");
                                        jSONObject3.put(PayUtility.PLAN_ID, instrumentInfo != null ? instrumentInfo.getPlanId() : null);
                                        jSONObject3.put("emiType", instrumentInfo != null ? instrumentInfo.getEmiType() : null);
                                        jSONObject3.put(PayUtility.CARD_INFO, instrumentInfo != null ? instrumentInfo.getPaymentDetails() : null);
                                        jSONObject3.put(PayUtility.AUTH_MODE, "otp");
                                        if ((instrumentInfo != null ? instrumentInfo.getmAdditionalParams() : null) != null) {
                                            jSONObject3.put(PayUtility.STORE_INSTRUMENT, (instrumentInfo != null ? instrumentInfo.getmAdditionalParams() : null).optString(CJRPGTransactionRequestUtils.STORE_CARD, "0"));
                                        }
                                        jSONObject.put("head", jSONObject2);
                                        jSONObject.put("body", jSONObject3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String jSONObject6 = jSONObject.toString();
        k.a((Object) jSONObject6, "fetchPayJsonObject.toString()");
        return jSONObject6;
    }

    public static String a(String str, String str2, Context context) {
        k.c(str, SDKConstants.KEY_PAYMODE);
        k.c(str2, "mappingID");
        k.c(context, "context");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.put(StringSet.token, d.a(context));
            String a2 = com.paytm.utility.b.a();
            k.a((Object) a2, "CJRAppCommonUtility.getTokenType()");
            String upperCase = a2.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            jSONObject2.put("tokenType", upperCase);
            c a3 = net.one97.paytm.wallet.communicator.b.a();
            k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
            jSONObject2.put("version", a3.getVersionName());
            jSONObject2.put("channelId", "WEB");
            jSONObject3.put("paymentMode", str);
            jSONObject3.put("mid", str2);
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
            String jSONObject4 = jSONObject.toString();
            k.a((Object) jSONObject4, "fetchPayJsonObject.toString()");
            return jSONObject4;
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "orderId");
        k.c(str2, "mId");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.put("mid", str2);
            jSONObject.put("version", "V1");
            jSONObject.put(SDKConstants.KEY_REQUEST_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("requestId", com.paytm.utility.b.v(context) + System.currentTimeMillis());
            jSONObject.put("clientId", com.paytm.utility.b.k());
            c a2 = net.one97.paytm.wallet.communicator.b.a();
            k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            jSONObject.put(StringSet.token, net.one97.paytm.paymentslimit.b.c.a(a2.getContext()));
            jSONObject.put("tokenType", SDKConstants.SSO);
            jSONObject2.put("ORDERID", str);
            jSONObject3.put("head", jSONObject);
            jSONObject3.put("body", jSONObject2);
        } catch (Exception | JSONException unused) {
        }
        String jSONObject4 = jSONObject3.toString();
        k.a((Object) jSONObject4, "obj.toString()");
        return jSONObject4;
    }

    public static String a(String str) {
        k.c(str, "transactionID");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("txnId", str);
            jSONObject.put("request", jSONObject2);
        } catch (JSONException unused) {
        }
        String jSONObject3 = jSONObject.toString();
        k.a((Object) jSONObject3, "parent.toString()");
        return jSONObject3;
    }
}
