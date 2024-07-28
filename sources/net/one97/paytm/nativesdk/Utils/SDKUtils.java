package net.one97.paytm.nativesdk.Utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.MerchantDetails;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.RiskConvFeeModel;
import net.one97.paytm.nativesdk.common.model.fetchMerchantInfo.MerchantInfoResp;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper;
import net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData;
import net.one97.paytm.nativesdk.instruments.upipush.model.CredsAllowed;
import net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData;
import net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails;
import net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.BankAccountDetails;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.UpiProfileDefaultBank;
import net.one97.paytm.payments.visascp.VisaSCP;
import net.one97.paytm.payments.visascp.VisaSDK;

public final class SDKUtils {
    public static final SDKUtils INSTANCE = new SDKUtils();

    public final boolean isAddMoneyPaymentFlow() {
        return false;
    }

    private SDKUtils() {
    }

    public final CJPayMethodResponse addWalletToAddMoneyOptions(CJPayMethodResponse cJPayMethodResponse) {
        MerchantPayOption merchantPayOption;
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption merchantPayOption2;
        Object obj;
        PaymentModes paymentModes2;
        k.c(cJPayMethodResponse, "cjrPayMethodResponse");
        Body body = cJPayMethodResponse.getBody();
        if (!(body == null || (merchantPayOption = body.getMerchantPayOption()) == null || (paymentModes = merchantPayOption.getPaymentModes()) == null || paymentModes == null)) {
            Iterator it2 = paymentModes.iterator();
            while (true) {
                merchantPayOption2 = null;
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                PaymentModes paymentModes3 = (PaymentModes) obj;
                k.a((Object) paymentModes3, "it");
                if (p.a(paymentModes3.getPaymentMode(), PayMethodType.BALANCE.name(), true)) {
                    break;
                }
            }
            PaymentModes paymentModes4 = (PaymentModes) obj;
            if (paymentModes4 != null) {
                Body body2 = cJPayMethodResponse.getBody();
                if (body2 != null) {
                    merchantPayOption2 = body2.getAddMoneyPayOption();
                }
                if (merchantPayOption2 != null) {
                    try {
                        Object clone = paymentModes4.clone();
                        if (clone != null) {
                            paymentModes2 = (PaymentModes) clone;
                            paymentModes2.setPriority("0");
                            Body body3 = cJPayMethodResponse.getBody();
                            k.a((Object) body3, "cjrPayMethodResponse.body");
                            MerchantPayOption addMoneyPayOption = body3.getAddMoneyPayOption();
                            k.a((Object) addMoneyPayOption, "cjrPayMethodResponse.body.addMoneyPayOption");
                            addMoneyPayOption.getPaymentModes().add(0, paymentModes2);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.PaymentModes");
                        }
                    } catch (Exception e2) {
                        if (PaytmSDK.getCallbackListener() != null) {
                            PaytmSDK.getCallbackListener().logException("SDKUtils", "Cloning Exception", e2);
                        }
                        paymentModes2 = paymentModes4;
                    }
                }
            }
        }
        return cJPayMethodResponse;
    }

    public final void showPaymentProgressbar(View view) {
        if (view == null) {
            return;
        }
        if (view.findViewById(R.id.ltv_loading) != null || view.findViewById(R.id.ltv_loading1) != null) {
            view.setBackgroundResource(R.drawable.native_button_onloading);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading);
            if (lottieAnimationView == null) {
                lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading1);
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.playAnimation();
            }
            if (view.findViewById(R.id.ivPaysecurely) != null) {
                View findViewById = view.findViewById(R.id.ivPaysecurely);
                k.a((Object) findViewById, "proceedButtonView.findVi…View>(R.id.ivPaysecurely)");
                findViewById.setVisibility(8);
            }
            if (view.findViewById(R.id.paysecurely) != null) {
                View findViewById2 = view.findViewById(R.id.paysecurely);
                k.a((Object) findViewById2, "proceedButtonView.findVi…d<View>(R.id.paysecurely)");
                findViewById2.setVisibility(4);
            }
            if (view.findViewById(R.id.tv_proceed_securely) != null) {
                View findViewById3 = view.findViewById(R.id.tv_proceed_securely);
                k.a((Object) findViewById3, "proceedButtonView.findVi…R.id.tv_proceed_securely)");
                findViewById3.setVisibility(4);
            }
            if (view.findViewById(R.id.paysecurely2) != null) {
                View findViewById4 = view.findViewById(R.id.paysecurely2);
                k.a((Object) findViewById4, "proceedButtonView.findVi…<View>(R.id.paysecurely2)");
                findViewById4.setVisibility(4);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void dismissLoadingSheet(androidx.appcompat.app.AppCompatActivity r3) {
        /*
            if (r3 == 0) goto L_0x0053
            boolean r0 = r3.isFinishing()
            if (r0 != 0) goto L_0x0053
            androidx.fragment.app.j r3 = r3.getSupportFragmentManager()
            java.lang.String r0 = "activity.supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            java.util.List r3 = r3.g()
            java.lang.String r0 = "activity.supportFragmentManager.fragments"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r0 = 0
            if (r3 == 0) goto L_0x0024
            java.lang.Object r1 = kotlin.a.k.e(r3)
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            goto L_0x0025
        L_0x0024:
            r1 = r0
        L_0x0025:
            if (r1 == 0) goto L_0x0053
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x002d:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r3.next()
            r2 = r1
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            boolean r2 = r2 instanceof net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingSheet
            if (r2 == 0) goto L_0x002d
            r0 = r1
        L_0x003f:
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            if (r0 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x004b
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingSheet r0 = (net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingSheet) r0
            r0.dismissSheet()
            return
        L_0x004b:
            kotlin.u r3 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingSheet"
            r3.<init>(r0)
            throw r3
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.dismissLoadingSheet(androidx.appcompat.app.AppCompatActivity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r6 = (r6 = (r6 = (r6 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) kotlin.a.k.e(r6)).getBalanceInfo()).getAccountBalance()).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isGiftVoucherSufficientBalance(net.one97.paytm.nativesdk.common.model.PaymentModes r6) {
        /*
            r5 = this;
            java.lang.String r0 = "paymentModes"
            kotlin.g.b.k.c(r6, r0)
            java.util.ArrayList r6 = r6.getPayChannelOptions()
            if (r6 == 0) goto L_0x002c
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = kotlin.a.k.e(r6)
            net.one97.paytm.nativesdk.common.model.PayChannelOptions r6 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) r6
            if (r6 == 0) goto L_0x002c
            net.one97.paytm.nativesdk.common.model.BalanceInfo r6 = r6.getBalanceInfo()
            if (r6 == 0) goto L_0x002c
            net.one97.paytm.nativesdk.common.model.AccountBalance r6 = r6.getAccountBalance()
            if (r6 == 0) goto L_0x002c
            java.lang.String r6 = r6.getValue()
            if (r6 == 0) goto L_0x002c
            java.lang.Double r6 = kotlin.m.p.b(r6)
            goto L_0x002d
        L_0x002c:
            r6 = 0
        L_0x002d:
            r0 = 0
            if (r6 == 0) goto L_0x005a
            java.lang.Number r6 = (java.lang.Number) r6
            double r1 = r6.doubleValue()
            net.one97.paytm.nativesdk.MerchantBL r6 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r3 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            java.lang.String r6 = r6.getAmount()
            java.lang.String r3 = "MerchantBL.getMerchantInstance().amount"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            java.lang.String r3 = ","
            java.lang.String r4 = ""
            java.lang.String r6 = kotlin.m.p.a(r6, r3, r4, r0)
            double r3 = net.one97.paytm.nativesdk.Utils.SDKUtility.parseDouble(r6)
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x005a
            r6 = 1
            return r6
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.isGiftVoucherSufficientBalance(net.one97.paytm.nativesdk.common.model.PaymentModes):boolean");
    }

    public final void addGiftVoucher(CJPayMethodResponse cJPayMethodResponse) {
        MerchantPayOption merchantPayOption;
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption merchantPayOption2;
        Object obj;
        PaymentModes paymentModes2;
        k.c(cJPayMethodResponse, "cjPayMethodResponse");
        Body body = cJPayMethodResponse.getBody();
        if (body != null && (merchantPayOption = body.getMerchantPayOption()) != null && (paymentModes = merchantPayOption.getPaymentModes()) != null && paymentModes != null) {
            Iterator it2 = paymentModes.iterator();
            while (true) {
                merchantPayOption2 = null;
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                PaymentModes paymentModes3 = (PaymentModes) obj;
                k.a((Object) paymentModes3, "it");
                if (p.a(paymentModes3.getPaymentMode(), PayMethodType.GIFT_VOUCHER.name(), true)) {
                    break;
                }
            }
            PaymentModes paymentModes4 = (PaymentModes) obj;
            if (paymentModes4 != null) {
                Body body2 = cJPayMethodResponse.getBody();
                if (body2 != null) {
                    merchantPayOption2 = body2.getAddMoneyPayOption();
                }
                if (merchantPayOption2 != null) {
                    try {
                        Object clone = paymentModes4.clone();
                        if (clone != null) {
                            paymentModes2 = (PaymentModes) clone;
                            paymentModes2.setPriority("0");
                            Body body3 = cJPayMethodResponse.getBody();
                            k.a((Object) body3, "cjPayMethodResponse.body");
                            MerchantPayOption addMoneyPayOption = body3.getAddMoneyPayOption();
                            k.a((Object) addMoneyPayOption, "cjPayMethodResponse.body.addMoneyPayOption");
                            addMoneyPayOption.getPaymentModes().add(0, paymentModes2);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.PaymentModes");
                    } catch (Exception e2) {
                        if (PaytmSDK.getCallbackListener() != null) {
                            PaytmSDK.getCallbackListener().logException("SDKUtils", "Cloning Exception", e2);
                        }
                        paymentModes2 = paymentModes4;
                    }
                }
            }
        }
    }

    public static final int getConsentFlagType() {
        Integer num = GTMLoader.getInt(SDKConstants.KEY_VISA_CONSENT);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r0 = (r0 = (r0 = (r0 = (r0 = r0.getBody()).getAddMoneyPayOption()).getUpiProfile()).getRespDetails()).getProfileDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean checkIfAddMoneyVpaExist() {
        /*
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getAddMoneyPayOption()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r0 = r0.getRespDetails()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x0032
            java.util.List r0 = r0.getBankAccounts()
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 == 0) goto L_0x0037
            r0 = 1
            return r0
        L_0x0037:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.checkIfAddMoneyVpaExist():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r0 = (r0 = (r0 = (r0 = (r0 = r0.getBody()).getMerchantPayOption()).getUpiProfile()).getRespDetails()).getProfileDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean checkIfMerchantPayVpaExist() {
        /*
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getMerchantPayOption()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r0 = r0.getRespDetails()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x0032
            java.util.List r0 = r0.getBankAccounts()
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 == 0) goto L_0x0037
            r0 = 1
            return r0
        L_0x0037:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.checkIfMerchantPayVpaExist():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r0 = (r0 = (r0 = (r0 = (r0 = r0.getBody()).getMerchantPayOption()).getUpiProfile()).getRespDetails()).getProfileDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean checkIfMerchantVpaExist() {
        /*
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getMerchantPayOption()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r0 = r0.getRespDetails()
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x0032
            java.util.List r0 = r0.getVpaDetails()
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 == 0) goto L_0x0037
            r0 = 1
            return r0
        L_0x0037:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.checkIfMerchantVpaExist():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r1 = r11.getVpaDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final net.one97.paytm.nativesdk.instruments.upipush.pojo.UpiProfileDefaultBank convertVpaPojo(net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail r11) {
        /*
            net.one97.paytm.nativesdk.instruments.upipush.pojo.UpiProfileDefaultBank r0 = new net.one97.paytm.nativesdk.instruments.upipush.pojo.UpiProfileDefaultBank
            r0.<init>()
            if (r11 == 0) goto L_0x0012
            net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail r1 = r11.getVpaDetail()
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = r1.getName()
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            r0.setVirtualAddress(r1)
            if (r11 == 0) goto L_0x0023
            net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail r1 = r11.getVpaDetail()
            if (r1 == 0) goto L_0x0023
            boolean r1 = r1.getPrimary()
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            r0.setPrimary(r1)
            if (r11 == 0) goto L_0x00a7
            net.one97.paytm.nativesdk.instruments.upipush.pojo.BankAccountDetails$BankAccount r1 = new net.one97.paytm.nativesdk.instruments.upipush.pojo.BankAccountDetails$BankAccount
            r1.<init>()
            java.lang.String r2 = r11.getMaskedAccountNumber()
            r1.setAccount(r2)
            java.lang.String r2 = r11.getBank()
            r1.setBankName(r2)
            java.lang.String r2 = r11.getIfsc()
            r1.setIfsc(r2)
            java.lang.String r2 = r11.getAccountType()
            r1.setAccountType(r2)
            java.lang.String r2 = r11.getAccRefId()
            r1.setAccRefId(r2)
            java.lang.String r2 = r11.getMpinSet()
            r1.setMbeba(r2)
            java.lang.String r2 = r11.getName()
            if (r2 != 0) goto L_0x0061
            java.lang.String r2 = "xyz"
        L_0x0061:
            r1.setCustomerName(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r11 = r11.getCredsAllowed()
            if (r11 == 0) goto L_0x009f
            java.util.Iterator r11 = r11.iterator()
        L_0x0073:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x009f
            java.lang.Object r3 = r11.next()
            net.one97.paytm.nativesdk.instruments.upipush.model.CredsAllowed r3 = (net.one97.paytm.nativesdk.instruments.upipush.model.CredsAllowed) r3
            if (r3 == 0) goto L_0x0073
            net.one97.paytm.nativesdk.instruments.upipush.pojo.BankAccountDetails$BankAccountCredentials r10 = new net.one97.paytm.nativesdk.instruments.upipush.pojo.BankAccountDetails$BankAccountCredentials
            java.lang.String r5 = r3.getCredsAllowedSubType()
            java.lang.String r6 = r3.getDLength()
            java.lang.String r7 = r3.getCredsAllowedDLength()
            java.lang.String r8 = r3.getCredsAllowedType()
            java.lang.String r9 = r3.getCredsAllowedDType()
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r2.add(r10)
            goto L_0x0073
        L_0x009f:
            java.util.List r2 = (java.util.List) r2
            r1.setBankCredsAllowed(r2)
            r0.setDebitBank(r1)
        L_0x00a7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.convertVpaPojo(net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail):net.one97.paytm.nativesdk.instruments.upipush.pojo.UpiProfileDefaultBank");
    }

    public static final VpaBankAccountDetail convertPojoToVpa(UpiProfileDefaultBank upiProfileDefaultBank) {
        List<BankAccountDetails.BankAccountCredentials> child;
        BankAccountDetails.BankAccount bankAccount = null;
        VpaBankAccountDetail vpaBankAccountDetail = r0;
        VpaBankAccountDetail vpaBankAccountDetail2 = new VpaBankAccountDetail((String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (BankMetaData) null, (String) null, (VpaAccountDetail) null, 8191, (g) null);
        VpaBankAccountDetail vpaBankAccountDetail3 = vpaBankAccountDetail;
        vpaBankAccountDetail3.setVpaDetail(new VpaAccountDetail(upiProfileDefaultBank != null ? upiProfileDefaultBank.getVirtualAddress() : null, (String) null, (String) null, upiProfileDefaultBank != null ? upiProfileDefaultBank.isPrimary() : false));
        if (upiProfileDefaultBank != null) {
            bankAccount = upiProfileDefaultBank.getDebitBank();
        }
        if (bankAccount != null) {
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank, "bankAccountDetail.debitBank");
            vpaBankAccountDetail3.setAccountType(debitBank.getAccountType());
            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank2, "bankAccountDetail.debitBank");
            vpaBankAccountDetail3.setAccRefId(debitBank2.getAccRefId());
            BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank3, "bankAccountDetail.debitBank");
            vpaBankAccountDetail3.setBank(debitBank3.getBankName());
            ArrayList arrayList = new ArrayList();
            BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank4, "bankAccountDetail.debitBank");
            BankAccountDetails.CredsAllowed credsAllowed = debitBank4.getCredsAllowed();
            if (!(credsAllowed == null || (child = credsAllowed.getChild()) == null)) {
                for (BankAccountDetails.BankAccountCredentials next : child) {
                    if (next != null) {
                        arrayList.add(new CredsAllowed(next.getDLength(), next.getCredsAllowedSubType(), next.getCredsAllowedType(), next.getCredsAllowedDLength(), next.getCredsAllowedDType()));
                    }
                }
            }
            vpaBankAccountDetail3.setCredsAllowed(arrayList);
            BankAccountDetails.BankAccount debitBank5 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank5, "bankAccountDetail.debitBank");
            vpaBankAccountDetail3.setMaskedAccountNumber(debitBank5.getAccount());
            BankAccountDetails.BankAccount debitBank6 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank6, "bankAccountDetail.debitBank");
            vpaBankAccountDetail3.setIfsc(debitBank6.getIfsc());
            BankAccountDetails.BankAccount debitBank7 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank7, "bankAccountDetail.debitBank");
            if (debitBank7.getMbeba() != null) {
                BankAccountDetails.BankAccount debitBank8 = upiProfileDefaultBank.getDebitBank();
                k.a((Object) debitBank8, "bankAccountDetail.debitBank");
                vpaBankAccountDetail3.setMpinSet(debitBank8.getMbeba().toString());
            }
            BankAccountDetails.BankAccount debitBank9 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank9, "bankAccountDetail.debitBank");
            vpaBankAccountDetail3.setName(debitBank9.getCustomerName());
        }
        return vpaBankAccountDetail3;
    }

    public static final boolean isToShowUpiConsent(String str) {
        Body body;
        MerchantPayOption merchantPayOption;
        UpiProfile upiProfile;
        ResponseDetails respDetails;
        ProfileData profileDetail;
        List<VpaBankAccountDetail> bankAccounts;
        Body body2;
        MerchantPayOption addMoneyPayOption;
        UpiProfile upiProfile2;
        ResponseDetails respDetails2;
        ProfileData profileDetail2;
        List<VpaBankAccountDetail> bankAccounts2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (p.a(SDKConstants.ADDANDPAY, instance.getSelectedPaymentMode(), true)) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance2.getCjPayMethodResponse();
            if (cjPayMethodResponse == null || (body2 = cjPayMethodResponse.getBody()) == null || (addMoneyPayOption = body2.getAddMoneyPayOption()) == null || (upiProfile2 = addMoneyPayOption.getUpiProfile()) == null || (respDetails2 = upiProfile2.getRespDetails()) == null || (profileDetail2 = respDetails2.getProfileDetail()) == null || (bankAccounts2 = profileDetail2.getBankAccounts()) == null) {
                return false;
            }
            for (VpaBankAccountDetail pgBankCode : bankAccounts2) {
                if (p.a(str, pgBankCode.getPgBankCode(), true)) {
                    return false;
                }
            }
        } else {
            DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
            k.a((Object) instance3, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse2 = instance3.getCjPayMethodResponse();
            if (cjPayMethodResponse2 == null || (body = cjPayMethodResponse2.getBody()) == null || (merchantPayOption = body.getMerchantPayOption()) == null || (upiProfile = merchantPayOption.getUpiProfile()) == null || (respDetails = upiProfile.getRespDetails()) == null || (profileDetail = respDetails.getProfileDetail()) == null || (bankAccounts = profileDetail.getBankAccounts()) == null) {
                return false;
            }
            for (VpaBankAccountDetail pgBankCode2 : bankAccounts) {
                if (p.a(str, pgBankCode2.getPgBankCode(), true)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail isToShowUpiPayOption(java.lang.String r6, android.content.Context r7) {
        /*
            java.lang.String r0 = "bankCode"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getSelectedPaymentMode()
            r2 = 1
            java.lang.String r3 = "ADDANDPAY"
            boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r2)
            r3 = 0
            if (r0 == 0) goto L_0x006f
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getAddMoneyPayOption()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r0 = r0.getRespDetails()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x00bd
            java.util.List r0 = r0.getBankAccounts()
            if (r0 == 0) goto L_0x00bd
            java.util.Iterator r0 = r0.iterator()
            r1 = r3
        L_0x0057:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00be
            java.lang.Object r4 = r0.next()
            net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail r4 = (net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail) r4
            java.lang.String r5 = r4.getPgBankCode()
            boolean r5 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r2)
            if (r5 == 0) goto L_0x0057
            r1 = r4
            goto L_0x0057
        L_0x006f:
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getMerchantPayOption()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r0 = r0.getRespDetails()
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x00bd
            java.util.List r0 = r0.getBankAccounts()
            if (r0 == 0) goto L_0x00bd
            java.util.Iterator r0 = r0.iterator()
            r1 = r3
        L_0x00a5:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00be
            java.lang.Object r4 = r0.next()
            net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail r4 = (net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail) r4
            java.lang.String r5 = r4.getPgBankCode()
            boolean r5 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r2)
            if (r5 == 0) goto L_0x00a5
            r1 = r4
            goto L_0x00a5
        L_0x00bd:
            r1 = r3
        L_0x00be:
            if (r1 != 0) goto L_0x00c1
            return r3
        L_0x00c1:
            if (r1 != 0) goto L_0x00c6
            kotlin.g.b.k.a()
        L_0x00c6:
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r6 = getBankHealth(r7, r1)
            if (r6 == 0) goto L_0x00d1
            java.lang.String r7 = r6.getCategory()
            goto L_0x00d2
        L_0x00d1:
            r7 = r3
        L_0x00d2:
            if (r7 == 0) goto L_0x00ea
            java.lang.String r6 = r6.getCategory()
            if (r6 != 0) goto L_0x00dd
            kotlin.g.b.k.a()
        L_0x00dd:
            net.one97.paytm.nativesdk.Utils.HealthType r7 = net.one97.paytm.nativesdk.Utils.HealthType.RED
            java.lang.String r7 = r7.name()
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r2)
            if (r6 == 0) goto L_0x00ea
            r1 = r3
        L_0x00ea:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.isToShowUpiPayOption(java.lang.String, android.content.Context):net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail");
    }

    public static final boolean isToShowUpiOnboardingView() {
        Body body;
        MerchantPayOption merchantPayOption;
        UpiProfile upiProfile;
        Body body2;
        MerchantPayOption addMoneyPayOption;
        UpiProfile upiProfile2;
        if (!SDKUtility.isUpiPushEnabled()) {
            return false;
        }
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        Boolean bool = null;
        if (p.a(SDKConstants.ADDANDPAY, instance.getSelectedPaymentMode(), true)) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance2.getCjPayMethodResponse();
            if (!(cjPayMethodResponse == null || (body2 = cjPayMethodResponse.getBody()) == null || (addMoneyPayOption = body2.getAddMoneyPayOption()) == null || (upiProfile2 = addMoneyPayOption.getUpiProfile()) == null)) {
                bool = upiProfile2.getUpiOnboarding();
            }
            return k.a((Object) bool, (Object) Boolean.TRUE);
        }
        DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
        k.a((Object) instance3, "DirectPaymentBL.getInstance()");
        CJPayMethodResponse cjPayMethodResponse2 = instance3.getCjPayMethodResponse();
        if (!(cjPayMethodResponse2 == null || (body = cjPayMethodResponse2.getBody()) == null || (merchantPayOption = body.getMerchantPayOption()) == null || (upiProfile = merchantPayOption.getUpiProfile()) == null)) {
            bool = upiProfile.getUpiOnboarding();
        }
        return k.a((Object) bool, (Object) Boolean.TRUE);
    }

    public static final boolean isUpiProfileCreated() {
        Body body;
        MerchantPayOption merchantPayOption;
        UpiProfile upiProfile;
        ResponseDetails respDetails;
        ProfileData profileDetail;
        Body body2;
        MerchantPayOption addMoneyPayOption;
        UpiProfile upiProfile2;
        ResponseDetails respDetails2;
        ProfileData profileDetail2;
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        List<VpaAccountDetail> list = null;
        if (p.a(SDKConstants.ADDANDPAY, instance.getSelectedPaymentMode(), true)) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance2.getCjPayMethodResponse();
            if (!(cjPayMethodResponse == null || (body2 = cjPayMethodResponse.getBody()) == null || (addMoneyPayOption = body2.getAddMoneyPayOption()) == null || (upiProfile2 = addMoneyPayOption.getUpiProfile()) == null || (respDetails2 = upiProfile2.getRespDetails()) == null || (profileDetail2 = respDetails2.getProfileDetail()) == null)) {
                list = profileDetail2.getVpaDetails();
            }
            return list != null;
        }
        DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
        k.a((Object) instance3, "DirectPaymentBL.getInstance()");
        CJPayMethodResponse cjPayMethodResponse2 = instance3.getCjPayMethodResponse();
        if (!(cjPayMethodResponse2 == null || (body = cjPayMethodResponse2.getBody()) == null || (merchantPayOption = body.getMerchantPayOption()) == null || (upiProfile = merchantPayOption.getUpiProfile()) == null || (respDetails = upiProfile.getRespDetails()) == null || (profileDetail = respDetails.getProfileDetail()) == null)) {
            list = profileDetail.getVpaDetails();
        }
        return list != null;
    }

    public static final String getPrimaryVpa() {
        VpaAccountDetail vpaDetail;
        List<VpaBankAccountDetail> allUnFilteredVpas = SDKUtility.getAllUnFilteredVpas();
        if (allUnFilteredVpas != null && allUnFilteredVpas.size() > 0) {
            int size = allUnFilteredVpas.size();
            int i2 = 0;
            while (i2 < size) {
                if (allUnFilteredVpas.get(i2).getVpaDetail() == null || (vpaDetail = allUnFilteredVpas.get(i2).getVpaDetail()) == null || !vpaDetail.getPrimary()) {
                    i2++;
                } else {
                    VpaBankAccountDetail vpaBankAccountDetail = allUnFilteredVpas.get(i2);
                    if (vpaBankAccountDetail != null) {
                        return vpaBankAccountDetail.getName();
                    }
                    return null;
                }
            }
            VpaBankAccountDetail vpaBankAccountDetail2 = allUnFilteredVpas.get(0);
            if (vpaBankAccountDetail2 != null) {
                return vpaBankAccountDetail2.getName();
            }
        }
        return null;
    }

    public static final String getPrimaryVpaAddress() {
        List<VpaAccountDetail> allVpaDetails = SDKUtility.getAllVpaDetails();
        if (allVpaDetails != null && allVpaDetails.size() > 0) {
            for (VpaAccountDetail next : allVpaDetails) {
                if (next.getPrimary()) {
                    if (next != null) {
                        return next.getName();
                    }
                    return null;
                }
            }
            VpaAccountDetail vpaAccountDetail = allVpaDetails.get(0);
            if (vpaAccountDetail != null) {
                return vpaAccountDetail.getName();
            }
        }
        return null;
    }

    public static final void setMerchantDetails(CJPayMethodResponse cJPayMethodResponse) {
        Body body;
        MerchantDetails merchantDetails;
        if (cJPayMethodResponse != null && (body = cJPayMethodResponse.getBody()) != null && (merchantDetails = body.getMerchantDetails()) != null) {
            ExtensionsKt.isNotNullNotBlank(merchantDetails.getMerchantLogo(), SDKUtils$setMerchantDetails$1$1.INSTANCE);
            SDKUtils sDKUtils = INSTANCE;
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            sDKUtils.setMerchantDisplayName(merchantInstance.getMerchantInfoResp(), merchantDetails.getMerchantName());
        }
    }

    private final void setMerchantDisplayName(MerchantInfoResp merchantInfoResp, String str) {
        String str2 = null;
        if (ExtensionsKt.isNotNullNotBlank(merchantInfoResp != null ? merchantInfoResp.getMerDispname() : null)) {
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            if (merchantInfoResp != null) {
                str2 = merchantInfoResp.getMerDispname();
            }
            merchantInstance.setMerchantName(str2);
            return;
        }
        if (ExtensionsKt.isNotNullNotBlank(merchantInfoResp != null ? merchantInfoResp.getMerBusName() : null)) {
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            if (merchantInfoResp != null) {
                str2 = merchantInfoResp.getMerBusName();
            }
            merchantInstance2.setMerchantName(str2);
        } else if (ExtensionsKt.isNotNullNotBlank(str)) {
            MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
            merchantInstance3.setMerchantName(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final net.one97.paytm.nativesdk.instruments.upipush.model.MetaData getUPIHealth(android.content.Context r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getSelectedPaymentMode()
            r2 = 1
            java.lang.String r3 = "ADDANDPAY"
            boolean r0 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r2)
            r3 = 0
            if (r0 == 0) goto L_0x0048
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getAddMoneyPayOption()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r0 = r0.getRespDetails()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.instruments.upipush.model.MetaData r0 = r0.getMetaDetails()
            goto L_0x0071
        L_0x0046:
            r0 = r3
            goto L_0x0071
        L_0x0048:
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getMerchantPayOption()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r0 = r0.getRespDetails()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.nativesdk.instruments.upipush.model.MetaData r0 = r0.getMetaDetails()
        L_0x0071:
            if (r0 == 0) goto L_0x0078
            java.lang.String r1 = r0.getNpciHealthMsg()
            goto L_0x0079
        L_0x0078:
            r1 = r3
        L_0x0079:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00be
            if (r0 == 0) goto L_0x0088
            java.lang.String r1 = r0.getNpciHealthCategory()
            goto L_0x0089
        L_0x0088:
            r1 = r3
        L_0x0089:
            net.one97.paytm.nativesdk.Utils.HealthType r4 = net.one97.paytm.nativesdk.Utils.HealthType.RED
            java.lang.String r4 = r4.name()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r2)
            if (r1 == 0) goto L_0x00a1
            if (r0 == 0) goto L_0x00be
            int r1 = net.one97.paytm.nativesdk.R.string.upi_health_red_msg
            java.lang.String r5 = r5.getString(r1)
            r0.setNpciHealthMsg(r5)
            goto L_0x00be
        L_0x00a1:
            if (r0 == 0) goto L_0x00a7
            java.lang.String r3 = r0.getNpciHealthCategory()
        L_0x00a7:
            net.one97.paytm.nativesdk.Utils.HealthType r1 = net.one97.paytm.nativesdk.Utils.HealthType.YELLOW
            java.lang.String r1 = r1.name()
            boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x00be
            if (r0 == 0) goto L_0x00be
            int r1 = net.one97.paytm.nativesdk.R.string.upi_health_yellow_msg
            java.lang.String r5 = r5.getString(r1)
            r0.setNpciHealthMsg(r5)
        L_0x00be:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.getUPIHealth(android.content.Context):net.one97.paytm.nativesdk.instruments.upipush.model.MetaData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth getBankHealth(android.content.Context r5, net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail r6) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "accountDetail"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.nativesdk.instruments.upipush.model.MetaData r0 = getUPIHealth(r5)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00f7
            java.lang.String r3 = r0.getNpciHealthCategory()
            if (r3 == 0) goto L_0x00f7
            java.lang.String r3 = r0.getNpciHealthCategory()
            net.one97.paytm.nativesdk.Utils.HealthType r4 = net.one97.paytm.nativesdk.Utils.HealthType.RED
            java.lang.String r4 = r4.name()
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r2)
            if (r3 == 0) goto L_0x004c
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r3 = new net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth
            java.lang.String r4 = r0.getNpciHealthCategory()
            java.lang.String r0 = r0.getNpciHealthMsg()
            r3.<init>(r4, r0)
            java.lang.String r0 = r3.getDisplayMsg()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00f8
            int r0 = net.one97.paytm.nativesdk.R.string.upi_health_red_msg
            java.lang.String r0 = r5.getString(r0)
            r3.setDisplayMsg(r0)
            goto L_0x00f8
        L_0x004c:
            java.lang.String r3 = r0.getNpciHealthCategory()
            net.one97.paytm.nativesdk.Utils.HealthType r4 = net.one97.paytm.nativesdk.Utils.HealthType.YELLOW
            java.lang.String r4 = r4.name()
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r2)
            if (r3 == 0) goto L_0x00f7
            net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData r3 = r6.getBankMetaData()
            if (r3 == 0) goto L_0x00f7
            net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData r3 = r6.getBankMetaData()
            if (r3 != 0) goto L_0x006b
            kotlin.g.b.k.a()
        L_0x006b:
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r3 = r3.getBankHealth()
            if (r3 == 0) goto L_0x00f7
            net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData r3 = r6.getBankMetaData()
            if (r3 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r3 = r3.getBankHealth()
            if (r3 != 0) goto L_0x0083
            kotlin.g.b.k.a()
        L_0x0083:
            java.lang.String r3 = r3.getCategory()
            if (r3 == 0) goto L_0x00f7
            net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData r3 = r6.getBankMetaData()
            if (r3 != 0) goto L_0x0092
            kotlin.g.b.k.a()
        L_0x0092:
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r3 = r3.getBankHealth()
            if (r3 != 0) goto L_0x009b
            kotlin.g.b.k.a()
        L_0x009b:
            java.lang.String r3 = r3.getCategory()
            net.one97.paytm.nativesdk.Utils.HealthType r4 = net.one97.paytm.nativesdk.Utils.HealthType.RED
            java.lang.String r4 = r4.name()
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r2)
            if (r3 == 0) goto L_0x00d4
            net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData r0 = r6.getBankMetaData()
            if (r0 == 0) goto L_0x00b6
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r0 = r0.getBankHealth()
            goto L_0x00b7
        L_0x00b6:
            r0 = r1
        L_0x00b7:
            if (r0 == 0) goto L_0x00be
            java.lang.String r3 = r0.getDisplayMsg()
            goto L_0x00bf
        L_0x00be:
            r3 = r1
        L_0x00bf:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x00d2
            if (r0 == 0) goto L_0x00d2
            int r3 = net.one97.paytm.nativesdk.R.string.bank_health_red_msg
            java.lang.String r3 = r5.getString(r3)
            r0.setDisplayMsg(r3)
        L_0x00d2:
            r3 = r0
            goto L_0x00f8
        L_0x00d4:
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r3 = new net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth
            java.lang.String r4 = r0.getNpciHealthCategory()
            java.lang.String r0 = r0.getNpciHealthMsg()
            r3.<init>(r4, r0)
            java.lang.String r0 = r3.getDisplayMsg()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00f8
            int r0 = net.one97.paytm.nativesdk.R.string.upi_health_yellow_msg
            java.lang.String r0 = r5.getString(r0)
            r3.setDisplayMsg(r0)
            goto L_0x00f8
        L_0x00f7:
            r3 = r1
        L_0x00f8:
            if (r3 != 0) goto L_0x0146
            net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData r6 = r6.getBankMetaData()
            if (r6 == 0) goto L_0x0104
            net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth r1 = r6.getBankHealth()
        L_0x0104:
            r3 = r1
            if (r3 == 0) goto L_0x0146
            java.lang.String r6 = r3.getDisplayMsg()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0146
            java.lang.String r6 = r3.getCategory()
            net.one97.paytm.nativesdk.Utils.HealthType r0 = net.one97.paytm.nativesdk.Utils.HealthType.RED
            java.lang.String r0 = r0.name()
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r0, (boolean) r2)
            if (r6 == 0) goto L_0x012d
            int r6 = net.one97.paytm.nativesdk.R.string.bank_health_red_msg
            java.lang.String r5 = r5.getString(r6)
            r3.setDisplayMsg(r5)
            goto L_0x0146
        L_0x012d:
            java.lang.String r6 = r3.getCategory()
            net.one97.paytm.nativesdk.Utils.HealthType r0 = net.one97.paytm.nativesdk.Utils.HealthType.YELLOW
            java.lang.String r0 = r0.name()
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r0, (boolean) r2)
            if (r6 == 0) goto L_0x0146
            int r6 = net.one97.paytm.nativesdk.R.string.bank_health_yellow_msg
            java.lang.String r5 = r5.getString(r6)
            r3.setDisplayMsg(r5)
        L_0x0146:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.getBankHealth(android.content.Context, net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail):net.one97.paytm.nativesdk.instruments.upipush.model.BankHealth");
    }

    public final OneClickLoadingHelper getOneClickHelper(Context context, String str) {
        k.c(context, "context");
        if (p.a(SDKConstants.VISA, str, true)) {
            str = SDKConstants.VISA_NEW;
        }
        OneClickLoadingHelper oneClickLoadingHelper = new OneClickLoadingHelper(context, SDKUtility.getCardImage(str));
        oneClickLoadingHelper.start();
        return oneClickLoadingHelper;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r0 = r0.getBody();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.ArrayList<net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel> filterSortMandateApps(java.util.List<? extends net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel> r12) {
        /*
            java.lang.String r0 = "installedApps"
            kotlin.g.b.k.c(r12, r0)
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            r1 = 0
            if (r0 == 0) goto L_0x0020
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0020
            java.util.List r0 = r0.getMandateSupportedApps()
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = r12
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x012b
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            if (r0 == 0) goto L_0x00a4
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x0043:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00a1
            java.lang.Object r5 = r1.next()
            net.one97.paytm.nativesdk.common.model.MandateSupportedApp r5 = (net.one97.paytm.nativesdk.common.model.MandateSupportedApp) r5
            r6 = r12
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x005d:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0099
            java.lang.Object r8 = r6.next()
            r9 = r8
            net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel r9 = (net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel) r9
            java.lang.String r10 = "manDateApp"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
            java.lang.String r10 = r5.getPackageName()
            java.lang.String r11 = "manDateApp.packageName"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            if (r10 == 0) goto L_0x0093
            java.lang.String r10 = r10.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)
            android.content.pm.ResolveInfo r9 = r9.getResolveInfo()
            android.content.pm.ActivityInfo r9 = r9.activityInfo
            java.lang.String r9 = r9.packageName
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r9)
            if (r9 == 0) goto L_0x005d
            r7.add(r8)
            goto L_0x005d
        L_0x0093:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x0099:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            kotlin.a.k.a(r4, r7)
            goto L_0x0043
        L_0x00a1:
            r1 = r4
            java.util.List r1 = (java.util.List) r1
        L_0x00a4:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            if (r0 == 0) goto L_0x00e7
            java.util.Iterator r0 = r0.iterator()
        L_0x00af:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00e7
            java.lang.Object r4 = r0.next()
            net.one97.paytm.nativesdk.common.model.MandateSupportedApp r4 = (net.one97.paytm.nativesdk.common.model.MandateSupportedApp) r4
            java.lang.String r5 = "app"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r5 = r4.getPackageName()
            java.lang.String r6 = "app.packageName"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            if (r5 == 0) goto L_0x00e1
            java.lang.String r5 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            int r4 = r4.getPriority()
            r6 = r12
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.put(r5, r4)
            goto L_0x00af
        L_0x00e1:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x00e7:
            if (r1 == 0) goto L_0x0128
            java.util.Iterator r0 = r1.iterator()
        L_0x00ed:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0128
            java.lang.Object r4 = r0.next()
            net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel r4 = (net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel) r4
            android.content.pm.ResolveInfo r5 = r4.getResolveInfo()
            android.content.pm.ActivityInfo r5 = r5.activityInfo
            java.lang.String r5 = r5.packageName
            java.lang.String r6 = "insApp.resolveInfo.activityInfo.packageName"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            if (r5 == 0) goto L_0x0122
            java.lang.String r5 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            java.lang.Object r5 = r12.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L_0x011a
            kotlin.g.b.k.a()
        L_0x011a:
            int r5 = r5.intValue()
            r4.setSortingIndex(r5)
            goto L_0x00ed
        L_0x0122:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x0128:
            r2 = r1
            java.util.ArrayList r2 = (java.util.ArrayList) r2
        L_0x012b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.filterSortMandateApps(java.util.List):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r0 = (r0 = (r0 = r0.getBody()).getMerchantPayOption()).getPaymentModes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isOnlyWalletPresent() {
        /*
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isWalletEnabledOnMerchant()
            r2 = 0
            if (r0 == 0) goto L_0x007a
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            r3 = 1
            if (r0 == 0) goto L_0x0038
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0038
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getMerchantPayOption()
            if (r0 == 0) goto L_0x0038
            java.util.ArrayList r0 = r0.getPaymentModes()
            if (r0 == 0) goto L_0x0038
            int r0 = r0.size()
            if (r0 != r3) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x007a
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x0063
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0063
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r0.getMerchantPayOption()
            if (r0 == 0) goto L_0x0063
            java.util.ArrayList r0 = r0.getSavedInstruments()
            if (r0 == 0) goto L_0x0063
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r0 = 0
            goto L_0x0064
        L_0x0063:
            r0 = 1
        L_0x0064:
            if (r0 == 0) goto L_0x007a
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getPaymentFlowAvailable()
            java.lang.String r1 = "ADDANDPAY"
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x007a
            return r3
        L_0x007a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.isOnlyWalletPresent():boolean");
    }

    public static final VisaSCP getVisaSDK(Context context) {
        k.c(context, "context");
        VisaSCP instance = VisaSDK.getInstance(context, GTMLoader.getString(SDKConstants.GOOGLE_SAFTEY_NET_KEY));
        k.a((Object) instance, "VisaSDK.getInstance(cont…s.GOOGLE_SAFTEY_NET_KEY))");
        return instance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r7.getBody()).getPaymentOffer();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setPromoCodeFromApplyPromoResponse(net.one97.paytm.nativesdk.common.model.ApplyPromoResponse r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$Body r1 = r7.getBody()
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$PaymentOffer r1 = r1.getPaymentOffer()
            if (r1 == 0) goto L_0x0014
            java.util.ArrayList r1 = r1.getOfferBreakup()
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            java.lang.String r2 = ""
            java.lang.String r3 = "DirectPaymentBL.getInstance()"
            if (r1 == 0) goto L_0x00cb
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$Body r1 = r7.getBody()
            if (r1 == 0) goto L_0x0035
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$PaymentOffer r1 = r1.getPaymentOffer()
            if (r1 == 0) goto L_0x0035
            java.util.ArrayList r1 = r1.getOfferBreakup()
            if (r1 == 0) goto L_0x0035
            int r0 = r1.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0035:
            if (r0 != 0) goto L_0x003a
            kotlin.g.b.k.a()
        L_0x003a:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x00cb
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$Body r0 = r7.getBody()
            java.lang.String r1 = "response.body"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$PaymentOffer r0 = r0.getPaymentOffer()
            java.lang.String r4 = "response.body.paymentOffer"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.util.ArrayList r0 = r0.getOfferBreakup()
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r6 = "response.body.paymentOffer.offerBreakup[0]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$OfferBreakup r0 = (net.one97.paytm.nativesdk.common.model.ApplyPromoResponse.OfferBreakup) r0
            java.lang.String r0 = r0.getPromocodeApplied()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c0
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$Body r2 = r7.getBody()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$PaymentOffer r2 = r2.getPaymentOffer()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.util.ArrayList r2 = r2.getOfferBreakup()
            java.lang.Object r2 = r2.get(r5)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$OfferBreakup r2 = (net.one97.paytm.nativesdk.common.model.ApplyPromoResponse.OfferBreakup) r2
            java.lang.String r2 = r2.getPromocodeApplied()
            r0.setPromoCodeBankOfferAI(r2)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$Body r7 = r7.getBody()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$PaymentOffer r7 = r7.getPaymentOffer()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            java.util.ArrayList r7 = r7.getOfferBreakup()
            java.lang.Object r7 = r7.get(r5)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$OfferBreakup r7 = (net.one97.paytm.nativesdk.common.model.ApplyPromoResponse.OfferBreakup) r7
            java.lang.String r7 = r7.getPromocodeApplied()
            java.lang.String r0 = "apply_promo_api_code"
            java.util.Map r7 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParamsBO(r0, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r7)
            return
        L_0x00c0:
            net.one97.paytm.nativesdk.DirectPaymentBL r7 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            r7.setPromoCodeBankOfferAI(r2)
            return
        L_0x00cb:
            net.one97.paytm.nativesdk.DirectPaymentBL r7 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            r7.setPromoCodeBankOfferAI(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.setPromoCodeFromApplyPromoResponse(net.one97.paytm.nativesdk.common.model.ApplyPromoResponse):void");
    }

    public static final String getVisaAlias(String str, String str2, String str3) {
        k.c(str, "FirstSixDigit");
        k.c(str2, "LastFourDigit");
        if (str3 == null) {
            return str + str2;
        }
        return str + str2 + str3;
    }

    public static final boolean isRiskConvFeeApplicable(String str) {
        Object obj;
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            return false;
        }
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        List<RiskConvFeeModel> riskConvFeeModel = instance.getRiskConvFeeModel();
        if (riskConvFeeModel != null) {
            Iterator it2 = riskConvFeeModel.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (p.a(str, ((RiskConvFeeModel) obj).getCardHash(), true)) {
                    break;
                }
            }
            RiskConvFeeModel riskConvFeeModel2 = (RiskConvFeeModel) obj;
            if (riskConvFeeModel2 != null && !TextUtils.isEmpty(riskConvFeeModel2.getConvFee()) && Double.compare(SDKUtility.parseDouble(riskConvFeeModel2.getConvFee()), 0.0d) > 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isRiskConvFeeApplicableScheme(String str) {
        Object obj;
        boolean z;
        k.c(str, Constants.EXTRA_BANK_SCHEME);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        List<RiskConvFeeModel> riskConvFeeModel = instance.getRiskConvFeeModel();
        if (riskConvFeeModel != null) {
            Iterator it2 = riskConvFeeModel.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                RiskConvFeeModel riskConvFeeModel2 = (RiskConvFeeModel) obj;
                if (!p.a(str, riskConvFeeModel2.getCardType(), true) || riskConvFeeModel2.getCardHash() == null || TextUtils.isEmpty(riskConvFeeModel2.getConvFee()) || Double.compare(SDKUtility.parseDouble(riskConvFeeModel2.getConvFee()), 0.0d) <= 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return ((RiskConvFeeModel) obj) != null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: net.one97.paytm.nativesdk.common.model.RiskConvFeeModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: net.one97.paytm.nativesdk.common.model.RiskConvFeeModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: net.one97.paytm.nativesdk.common.model.RiskConvFeeModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: net.one97.paytm.nativesdk.common.model.RiskConvFeeModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: net.one97.paytm.nativesdk.common.model.RiskConvFeeModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isRiskConvFeeApplicable() {
        /*
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.util.List r0 = r0.getRiskConvFeeModel()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0046
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r0.next()
            r5 = r4
            net.one97.paytm.nativesdk.common.model.RiskConvFeeModel r5 = (net.one97.paytm.nativesdk.common.model.RiskConvFeeModel) r5
            java.lang.String r6 = r5.getCardHash()
            if (r6 == 0) goto L_0x0040
            java.lang.String r5 = r5.getConvFee()
            double r5 = net.one97.paytm.nativesdk.Utils.SDKUtility.parseDouble(r5)
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x003b
            r5 = 1
            goto L_0x003c
        L_0x003b:
            r5 = 0
        L_0x003c:
            if (r5 == 0) goto L_0x0040
            r5 = 1
            goto L_0x0041
        L_0x0040:
            r5 = 0
        L_0x0041:
            if (r5 == 0) goto L_0x0018
            r1 = r4
        L_0x0044:
            net.one97.paytm.nativesdk.common.model.RiskConvFeeModel r1 = (net.one97.paytm.nativesdk.common.model.RiskConvFeeModel) r1
        L_0x0046:
            if (r1 == 0) goto L_0x0049
            return r2
        L_0x0049:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.SDKUtils.isRiskConvFeeApplicable():boolean");
    }
}
