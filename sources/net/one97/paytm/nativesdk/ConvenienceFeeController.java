package net.one97.paytm.nativesdk;

import android.text.TextUtils;
import com.google.gson.f;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.CardPaymentIntentData;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;

public class ConvenienceFeeController {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static ConvenienceFeeController INSTANCE;
    private double baseTxnAmount;
    private final HashMap<String, ArrayList<PaymentIntent>> convFeeCacheMap = new HashMap<>();
    private double currentConvFee;
    /* access modifiers changed from: private */
    public String currentLabel = "";
    private DecimalFormat df = new DecimalFormat("#.00");
    private double overFlowConvenienceAmount;
    private final HashMap<String, Object> verifyModelCache = new HashMap<>();
    private double walletConvenienceFee;

    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    public static final ConvenienceFeeController getInstance() {
        return Companion.getInstance();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ConvenienceFeeController getInstance() {
            if (ConvenienceFeeController.INSTANCE == null) {
                ConvenienceFeeController.INSTANCE = new ConvenienceFeeController();
            }
            ConvenienceFeeController access$getINSTANCE$cp = ConvenienceFeeController.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void destroyInstance() {
            ConvenienceFeeController.INSTANCE = null;
        }
    }

    public final boolean isConvenienceFeeEnabled() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        PaytmSDKRequestClient requestClient = instance.getRequestClient();
        if (requestClient != null) {
            return requestClient.isConvFeeEnabled();
        }
        return false;
    }

    public static /* synthetic */ ArrayList buildPaymentIntent$default(ConvenienceFeeController convenienceFeeController, String str, ArrayList arrayList, ArrayList arrayList2, CardPaymentIntentData cardPaymentIntentData, String str2, Double d2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 16) != 0) {
                str2 = null;
            }
            return convenienceFeeController.buildPaymentIntent(str, arrayList, arrayList2, cardPaymentIntentData, str2, d2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildPaymentIntent");
    }

    public final ArrayList<PaymentIntent> buildPaymentIntent(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, CardPaymentIntentData cardPaymentIntentData, String str2, Double d2) {
        k.c(str, "mode");
        ArrayList<PaymentIntent> arrayList3 = new ArrayList<>();
        String str3 = null;
        double d3 = 0.0d;
        if (isConvenienceFeeEnabled()) {
            this.baseTxnAmount = calculateBaseTxnAmount(d2 != null ? d2.doubleValue() : 0.0d);
            if (p.a(str, PayMethodType.BALANCE.name(), true)) {
                this.walletConvenienceFee = 0.0d;
                arrayList3.add(getConvFeeWalletPaymentIntent());
            } else {
                if (isConvenienceFeeHybridCase()) {
                    arrayList3.add(getConvFeeWalletPaymentIntent());
                }
                PaymentIntent paymentIntent = new PaymentIntent();
                paymentIntent.setMode(str);
                paymentIntent.setCardHash(cardPaymentIntentData != null ? cardPaymentIntentData.getCardHash() : null);
                paymentIntent.setBin6(cardPaymentIntentData != null ? cardPaymentIntentData.getBin6() : null);
                if (cardPaymentIntentData != null) {
                    str3 = cardPaymentIntentData.getBin8();
                }
                paymentIntent.setBin8(str3);
                paymentIntent.setChannels(arrayList);
                paymentIntent.setBanks(arrayList2);
                if (!TextUtils.isEmpty(str2)) {
                    paymentIntent.setMode_type(str2);
                }
                if (this.overFlowConvenienceAmount > 0.0d) {
                    paymentIntent.setTxnAmount(0.0d);
                    paymentIntent.setConvFee(this.overFlowConvenienceAmount);
                } else {
                    double instrumentPayableAmount = getInstrumentPayableAmount();
                    if (d2 != null) {
                        d3 = d2.doubleValue();
                    }
                    paymentIntent.setTxnAmount(instrumentPayableAmount + d3);
                }
                arrayList3.add(paymentIntent);
            }
        } else {
            this.baseTxnAmount = calculateBaseTxnAmount(0.0d);
            if (p.a(str, PayMethodType.BALANCE.name(), true)) {
                arrayList3.add(getWalletPaymentIntent());
            } else {
                if (SDKUtility.isHybridCase()) {
                    arrayList3.add(getWalletPaymentIntent());
                }
                PaymentIntent paymentIntent2 = new PaymentIntent();
                paymentIntent2.setMode(str);
                paymentIntent2.setCardHash(cardPaymentIntentData != null ? cardPaymentIntentData.getCardHash() : null);
                paymentIntent2.setBin6(cardPaymentIntentData != null ? cardPaymentIntentData.getBin6() : null);
                if (cardPaymentIntentData != null) {
                    str3 = cardPaymentIntentData.getBin8();
                }
                paymentIntent2.setBin8(str3);
                paymentIntent2.setChannels(arrayList);
                paymentIntent2.setBanks(arrayList2);
                if (!TextUtils.isEmpty(str2)) {
                    paymentIntent2.setMode_type(str2);
                }
                paymentIntent2.setTxnAmount(SDKUtility.getDiffAmount());
                arrayList3.add(paymentIntent2);
            }
        }
        return arrayList3;
    }

    private final PaymentIntent getWalletPaymentIntent() {
        PaymentIntent paymentIntent = new PaymentIntent();
        paymentIntent.setMode(PayMethodType.BALANCE.name());
        if (SDKUtility.isHybridCase()) {
            paymentIntent.setTxnAmount(getWalletBalance());
        } else {
            paymentIntent.setTxnAmount(this.baseTxnAmount);
        }
        return paymentIntent;
    }

    private final PaymentIntent getConvFeeWalletPaymentIntent() {
        double d2;
        PaymentIntent paymentIntent = new PaymentIntent();
        if (isConvenienceFeeHybridCase()) {
            d2 = getWalletBalance();
        } else {
            d2 = this.baseTxnAmount;
        }
        paymentIntent.setMode(PayMethodType.BALANCE.name());
        paymentIntent.setTxnAmount(d2 - this.walletConvenienceFee);
        paymentIntent.setConvFee(this.walletConvenienceFee);
        return paymentIntent;
    }

    public final boolean isConvenienceFeeHybridCase() {
        if (!isConvenienceFeeEnabled()) {
            return false;
        }
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        boolean isWalletEnabledOnMerchant = instance.isWalletEnabledOnMerchant();
        DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
        k.a((Object) instance2, "DirectPaymentBL.getInstance()");
        boolean a2 = p.a(SDKConstants.HYBRID, instance2.getPaymentFlowAvailable(), true);
        DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
        k.a((Object) instance3, "DirectPaymentBL.getInstance()");
        boolean isPaytmWalletChecked = instance3.isPaytmWalletChecked();
        boolean z = getWalletBalance() > this.baseTxnAmount + getTotalConvenienceFeePayable();
        if (!isWalletEnabledOnMerchant || !a2 || !isPaytmWalletChecked || z) {
            return false;
        }
        return true;
    }

    public final ArrayList<PaymentIntent> getCachedConvenienceFeeIntent(ArrayList<PaymentIntent> arrayList) {
        k.c(arrayList, "paymentIntents");
        return this.convFeeCacheMap.get(new f().b(arrayList));
    }

    public final ArrayList<PaymentIntent> setConvFeeResponse(PaytmSDKRequestClient.VerifyResponseData verifyResponseData, ArrayList<PaymentIntent> arrayList, Object obj) {
        k.c(arrayList, "paymentIntents");
        if (verifyResponseData == null || verifyResponseData.getConvFeeResponse() == null) {
            return null;
        }
        PaytmSDKRequestClient.ConvFeeResponse convFeeResponse = verifyResponseData.getConvFeeResponse();
        k.a((Object) convFeeResponse, "data.convFeeResponse");
        return setConvFeeResponse(convFeeResponse, arrayList, obj);
    }

    public final ArrayList<PaymentIntent> setConvFeeResponse(PaytmSDKRequestClient.ConvFeeResponse convFeeResponse, ArrayList<PaymentIntent> arrayList, Object obj) {
        PaytmSDKRequestClient.ConvFeeResponse convFeeResponse2 = convFeeResponse;
        ArrayList<PaymentIntent> arrayList2 = arrayList;
        k.c(convFeeResponse2, "convFeeResponse");
        k.c(arrayList2, "paymentIntents");
        f fVar = new f();
        String b2 = fVar.b(arrayList2);
        this.currentConvFee = SDKUtility.parseDouble(convFeeResponse.getAggregatePGConvFee());
        this.overFlowConvenienceAmount = 0.0d;
        if (isConvenienceFeeHybridCase()) {
            for (PaymentIntent paymentIntent : arrayList2) {
                if (p.a(PayMethodType.BALANCE.name(), paymentIntent.getMode(), true)) {
                    double txnAmount = paymentIntent.getTxnAmount();
                    double walletBalance = getWalletBalance();
                    if (this.currentConvFee + txnAmount > walletBalance) {
                        String format = this.df.format(walletBalance - txnAmount);
                        k.a((Object) format, "df.format(walletBalance - initialWalletTxnAmount)");
                        this.walletConvenienceFee = Double.parseDouble(format);
                        if (this.baseTxnAmount <= walletBalance) {
                            String format2 = this.df.format(this.currentConvFee - this.walletConvenienceFee);
                            k.a((Object) format2, "df.format(currentConvFee - walletConvenienceFee)");
                            this.overFlowConvenienceAmount = Double.parseDouble(format2);
                        }
                    }
                }
            }
        } else {
            this.walletConvenienceFee = this.currentConvFee;
        }
        for (PaymentIntent paymentIntent2 : arrayList2) {
            if (p.a(PayMethodType.BALANCE.name(), paymentIntent2.getMode(), true)) {
                paymentIntent2.setConvFee(this.walletConvenienceFee);
            } else {
                double d2 = this.overFlowConvenienceAmount;
                if (d2 > 0.0d) {
                    paymentIntent2.setConvFee(d2);
                } else {
                    paymentIntent2.setConvFee(this.currentConvFee);
                }
            }
            ExtensionsKt.isNotNullNotBlank(convFeeResponse.getConvFeeLabel(), new ConvenienceFeeController$setConvFeeResponse$$inlined$forEach$lambda$1(paymentIntent2, this, convFeeResponse2));
            CharSequence spannableConvFeeText = convFeeResponse.getSpannableConvFeeText();
            if (!(spannableConvFeeText == null || p.a(spannableConvFeeText))) {
                paymentIntent2.setSpannableConvFeeText(convFeeResponse.getSpannableConvFeeText());
            }
            ExtensionsKt.isNotNullNotBlank(convFeeResponse.getFeePercent(), new ConvenienceFeeController$setConvFeeResponse$2$2(paymentIntent2));
            ExtensionsKt.isNotNullNotBlank(convFeeResponse.getOfferMsg(), new ConvenienceFeeController$setConvFeeResponse$2$3(paymentIntent2));
        }
        String b3 = fVar.b(arrayList2);
        this.convFeeCacheMap.put(b2, arrayList2);
        this.verifyModelCache.put(b3, obj);
        return arrayList2;
    }

    private final double getWalletBalance() {
        return SDKUtility.parseDouble(DirectPaymentBL.getInstance().getInstrumentBalance(PayMethodType.BALANCE));
    }

    static /* synthetic */ double calculateBaseTxnAmount$default(ConvenienceFeeController convenienceFeeController, double d2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                d2 = 0.0d;
            }
            return convenienceFeeController.calculateBaseTxnAmount(d2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBaseTxnAmount");
    }

    private final double calculateBaseTxnAmount(double d2) {
        this.baseTxnAmount = getMerchantPayableAmount() - d2;
        return this.baseTxnAmount;
    }

    private final double getInstrumentPayableAmount() {
        if (!isConvenienceFeeHybridCase()) {
            return this.baseTxnAmount;
        }
        String format = this.df.format(this.baseTxnAmount - getWalletBalance());
        k.a((Object) format, "df.format(baseTxnAmount - getWalletBalance())");
        return Double.parseDouble(format);
    }

    private final double getMerchantPayableAmount() {
        return SDKUtility.parseDouble(MerchantBL.getMerchantInstance().getAmount());
    }

    public final double getPostConvFeePayableAmount() {
        if (!isConvenienceFeeHybridCase()) {
            return this.baseTxnAmount + getTotalConvenienceFeePayable();
        }
        double d2 = this.overFlowConvenienceAmount;
        if (d2 > 0.0d) {
            return d2;
        }
        String format = this.df.format(getInstrumentPayableAmount() + getTotalConvenienceFeePayable());
        k.a((Object) format, "df.format(getInstrumentP…lConvenienceFeePayable())");
        return Double.parseDouble(format);
    }

    private final double getTotalPayableAmount() {
        if (!isConvenienceFeeHybridCase()) {
            return getMerchantPayableAmount() + getTotalConvenienceFeePayable();
        }
        double d2 = this.overFlowConvenienceAmount;
        if (d2 > 0.0d) {
            return d2;
        }
        String format = this.df.format(getMerchantPayableAmount() + getTotalConvenienceFeePayable());
        k.a((Object) format, "df.format(getMerchantPay…lConvenienceFeePayable())");
        return Double.parseDouble(format);
    }

    public final String getTotalAmount() {
        String priceWithoutDecimal = SDKUtility.priceWithoutDecimal(getTotalPayableAmount());
        k.a((Object) priceWithoutDecimal, "SDKUtility.priceWithoutD…(getTotalPayableAmount())");
        return priceWithoutDecimal;
    }

    public final boolean hasOverflowConvenienceFee() {
        return isConvenienceFeeEnabled() && this.overFlowConvenienceAmount > 0.0d;
    }

    public final String getPostConvenienceFeeDisplayAmount() {
        String priceWithoutDecimal = SDKUtility.priceWithoutDecimal(getPostConvFeePayableAmount());
        k.a((Object) priceWithoutDecimal, "SDKUtility.priceWithoutD…stConvFeePayableAmount())");
        return priceWithoutDecimal;
    }

    public final boolean checkConvenienceFeeOverFlow(String str, double d2, ArrayList<PaymentIntent> arrayList) {
        k.c(str, "mode");
        k.c(arrayList, "paymentIntents");
        if (!isConvenienceFeeHybridCase() || str.equals(PayMethodType.BALANCE.name())) {
            return this.baseTxnAmount + getTotalConvenienceFeePayable() > d2;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            PaymentIntent paymentIntent = (PaymentIntent) it2.next();
            if (k.a((Object) paymentIntent.getMode(), (Object) str)) {
                if (paymentIntent.getTxnAmount() + paymentIntent.getConvFee() > d2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final double getTotalConvenienceFeePayable() {
        return this.currentConvFee;
    }

    public final String getConvenienceFeeLabel() {
        return this.currentLabel;
    }

    public final void resetConvenienceFee() {
        this.walletConvenienceFee = 0.0d;
        this.overFlowConvenienceAmount = 0.0d;
        this.currentConvFee = 0.0d;
    }

    public final Object getVerifyResponseModel(ArrayList<PaymentIntent> arrayList) {
        if (arrayList == null) {
            return null;
        }
        return this.verifyModelCache.get(new f().b(arrayList));
    }
}
