package net.one97.paytm.nativesdk.orflow.promo.view;

import android.app.Application;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CardDetails;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.CardType;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse;
import net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData;
import net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData;
import net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails;
import net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.BalanceInfo;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public final class PromoPayOptionViewModel extends a {
    private final Application applicationContext;
    private y<CJRFetchBalanceResponse> checkBalanceObserver = new y<>();
    private y<GetCardDetailsResponse> fetchCardDetailObserver = new y<>();
    private y<NBResponse> netBankingResponseObserver = new y<>();
    private y<VerifyVpaResponse> validateVPAObserver = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoPayOptionViewModel(Application application) {
        super(application);
        k.c(application, "applicationContext");
        this.applicationContext = application;
    }

    public final y<CJRFetchBalanceResponse> getCheckBalanceObserver() {
        return this.checkBalanceObserver;
    }

    public final void setCheckBalanceObserver(y<CJRFetchBalanceResponse> yVar) {
        k.c(yVar, "<set-?>");
        this.checkBalanceObserver = yVar;
    }

    public final y<VerifyVpaResponse> getValidateVPAObserver() {
        return this.validateVPAObserver;
    }

    public final void setValidateVPAObserver(y<VerifyVpaResponse> yVar) {
        k.c(yVar, "<set-?>");
        this.validateVPAObserver = yVar;
    }

    public final y<GetCardDetailsResponse> getFetchCardDetailObserver() {
        return this.fetchCardDetailObserver;
    }

    public final void setFetchCardDetailObserver(y<GetCardDetailsResponse> yVar) {
        k.c(yVar, "<set-?>");
        this.fetchCardDetailObserver = yVar;
    }

    public final y<NBResponse> getNetBankingResponseObserver() {
        return this.netBankingResponseObserver;
    }

    public final void setNetBankingResponseObserver(y<NBResponse> yVar) {
        k.c(yVar, "<set-?>");
        this.netBankingResponseObserver = yVar;
    }

    public final ArrayList<PromoPayOptionAdapterParam> getPayOptionsList() {
        MerchantPayOption merchantPayOption;
        ArrayList<PaymentModes> paymentModes;
        MerchantPayOption merchantPayOption2;
        ArrayList<SavedInstruments> savedInstruments;
        MerchantPayOption merchantPayOption3;
        UpiProfile upiProfile;
        ResponseDetails respDetails;
        ProfileData profileDetail;
        List<VpaBankAccountDetail> bankAccounts;
        CJPayMethodResponse cjPayMethodResponse = PromoHelper.Companion.getInstance().getCjPayMethodResponse();
        if (cjPayMethodResponse == null) {
            k.a();
        }
        ArrayList<PromoPayOptionAdapterParam> arrayList = new ArrayList<>();
        Body body = cjPayMethodResponse.getBody();
        if (!(body == null || (merchantPayOption3 = body.getMerchantPayOption()) == null || (upiProfile = merchantPayOption3.getUpiProfile()) == null || (respDetails = upiProfile.getRespDetails()) == null || (profileDetail = respDetails.getProfileDetail()) == null || (bankAccounts = profileDetail.getBankAccounts()) == null)) {
            for (VpaBankAccountDetail promoPayOptionAdapterParam : SDKUtility.filterVpasOrFlow(bankAccounts)) {
                PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = new PromoPayOptionAdapterParam(3, promoPayOptionAdapterParam);
                promoPayOptionAdapterParam2.setMode("UPI");
                promoPayOptionAdapterParam2.setSortingOrder(SortingOrder.INSTANCE.getUpiPush());
                arrayList.add(promoPayOptionAdapterParam2);
            }
        }
        Body body2 = cjPayMethodResponse.getBody();
        if (!(body2 == null || (merchantPayOption2 = body2.getMerchantPayOption()) == null || (savedInstruments = merchantPayOption2.getSavedInstruments()) == null)) {
            Iterator<SavedInstruments> it2 = savedInstruments.iterator();
            while (it2.hasNext()) {
                SavedInstruments next = it2.next();
                PromoPayOptionAdapterParam promoPayOptionAdapterParam3 = new PromoPayOptionAdapterParam(0, next);
                k.a((Object) next, "item");
                CardDetails cardDetails = next.getCardDetails();
                String str = null;
                promoPayOptionAdapterParam3.setMode(cardDetails != null ? cardDetails.getCardType() : null);
                CardDetails cardDetails2 = next.getCardDetails();
                if (cardDetails2 != null) {
                    str = cardDetails2.getCardType();
                }
                if (SDKConstants.DEBIT.equals(str)) {
                    promoPayOptionAdapterParam3.setSortingOrder(SortingOrder.INSTANCE.getSavedDC());
                } else {
                    promoPayOptionAdapterParam3.setSortingOrder(SortingOrder.INSTANCE.getSavedCC());
                }
                arrayList.add(promoPayOptionAdapterParam3);
            }
        }
        Body body3 = cjPayMethodResponse.getBody();
        if (!(body3 == null || (merchantPayOption = body3.getMerchantPayOption()) == null || (paymentModes = merchantPayOption.getPaymentModes()) == null)) {
            Iterator<PaymentModes> it3 = paymentModes.iterator();
            while (it3.hasNext()) {
                PaymentModes next2 = it3.next();
                k.a((Object) next2, "item");
                if (p.a("PAYTM_DIGITAL_CREDIT", next2.getPaymentMode(), true)) {
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam4 = new PromoPayOptionAdapterParam(6, next2);
                    promoPayOptionAdapterParam4.setMode(next2.getPaymentMode());
                    promoPayOptionAdapterParam4.setSortingOrder(SortingOrder.INSTANCE.getPostpaid());
                    arrayList.add(promoPayOptionAdapterParam4);
                } else if (p.a(SDKConstants.AI_KEY_PPBL, next2.getPaymentMode(), true)) {
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam5 = new PromoPayOptionAdapterParam(5, next2);
                    promoPayOptionAdapterParam5.setMode(next2.getPaymentMode());
                    promoPayOptionAdapterParam5.setSortingOrder(SortingOrder.INSTANCE.getPPBL());
                    arrayList.add(promoPayOptionAdapterParam5);
                } else if (p.a("NET_BANKING", next2.getPaymentMode(), true)) {
                    Iterator<PayChannelOptions> it4 = next2.getPayChannelOptions().iterator();
                    while (it4.hasNext()) {
                        PromoPayOptionAdapterParam promoPayOptionAdapterParam6 = new PromoPayOptionAdapterParam(1, it4.next());
                        promoPayOptionAdapterParam6.setMode(next2.getPaymentMode());
                        promoPayOptionAdapterParam6.setSortingOrder(SortingOrder.INSTANCE.getNB());
                        arrayList.add(promoPayOptionAdapterParam6);
                    }
                } else if (p.a(SDKConstants.CREDIT, next2.getPaymentMode(), true)) {
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam7 = new PromoPayOptionAdapterParam(2, new SavedInstruments());
                    promoPayOptionAdapterParam7.setMode(next2.getPaymentMode());
                    promoPayOptionAdapterParam7.setSortingOrder(SortingOrder.INSTANCE.getNewCC());
                    arrayList.add(promoPayOptionAdapterParam7);
                } else if (p.a(SDKConstants.DEBIT, next2.getPaymentMode(), true)) {
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam8 = new PromoPayOptionAdapterParam(2, new SavedInstruments());
                    promoPayOptionAdapterParam8.setMode(next2.getPaymentMode());
                    promoPayOptionAdapterParam8.setSortingOrder(SortingOrder.INSTANCE.getNewDC());
                    arrayList.add(promoPayOptionAdapterParam8);
                } else if (p.a("UPI", next2.getPaymentMode(), true)) {
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam9 = new PromoPayOptionAdapterParam(4, new VpaBankAccountDetail((String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (BankMetaData) null, (String) null, (VpaAccountDetail) null, 8191, (g) null));
                    promoPayOptionAdapterParam9.setMode(next2.getPaymentMode());
                    promoPayOptionAdapterParam9.setSortingOrder(SortingOrder.INSTANCE.getUPICollect());
                    arrayList.add(promoPayOptionAdapterParam9);
                }
            }
        }
        sortPayOptionsList(arrayList);
        return arrayList;
    }

    private final void sortPayOptionsList(ArrayList<PromoPayOptionAdapterParam> arrayList) {
        Collections.sort(arrayList, new PromoPayOptionViewModel$sortPayOptionsList$1());
    }

    public final void getAllBanksList() {
        NativeSDKRepository.getInstance().fetchNBDetails("MERCHANT", new PromoPayOptionViewModel$getAllBanksList$1(this));
    }

    public final void checkBalance(String str) {
        NativeSDKRepository.getInstance().fetchBalance(str, new PromoPayOptionViewModel$checkBalance$1(this));
    }

    public final void validateVPA(String str) {
        PaymentRepository.Companion.getInstance(this.applicationContext).validateVPA(str, new PromoPayOptionViewModel$validateVPA$1(this));
    }

    public final void fetchCardDetails(String str) {
        NativeSDKRepository.getInstance().fetchCardDetails(str, (PaymentMethodDataSource.Callback<GetCardDetailsResponse>) new PromoPayOptionViewModel$fetchCardDetails$1(this));
    }

    public final boolean isCardNumberInvalid(String str, Integer num) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        if (CardType.detect(p.a(str, "-", "", false)) == CardType.UNKNOWN) {
            if (num == null || num.intValue() != 0) {
                CharSequence a2 = p.a(str, "-", "", false);
                int length = a2.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = a2.charAt(!z ? i2 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i2++;
                    }
                }
                int length2 = a2.subSequence(i2, length + 1).toString().length();
                if (num == null || length2 != num.intValue()) {
                    return true;
                }
            }
            String a3 = p.a(str, "-", "", false);
            if (a3.length() < 14 || !SDKUtility.applyLuhnCheck(a3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasSufficientBalance(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        BalanceInfo balanceInfo;
        String value;
        k.c(cJRFetchBalanceResponse, Payload.RESPONSE);
        net.one97.paytm.nativesdk.paymethods.model.fetchBalance.Body body = cJRFetchBalanceResponse.getBody();
        if (body == null || (balanceInfo = body.getBalanceInfo()) == null || (value = balanceInfo.getValue()) == null || Double.parseDouble(value) < PromoHelper.Companion.getInstance().getAmount() - PromoHelper.Companion.getInstance().getInstantDiscount()) {
            return false;
        }
        return true;
    }

    public final void prepareAllNBListData(ArrayList<net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions> arrayList, ArrayList<PromoPayOptionAdapterParam> arrayList2, ArrayList<PromoPayOptionAdapterParam> arrayList3) {
        k.c(arrayList, "payChannelOptions");
        TreeMap treeMap = new TreeMap();
        Iterator<net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions next = it2.next();
            char charAt = next.getChannelName().charAt(0);
            if (treeMap.containsKey(String.valueOf(charAt) + "")) {
                char charAt2 = next.getChannelName().charAt(0);
                Object obj = treeMap.get(String.valueOf(charAt2) + "");
                if (obj != null) {
                    ((ArrayList) obj).add(next);
                } else {
                    throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions>");
                }
            } else {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(next);
                char charAt3 = next.getChannelName().charAt(0);
                treeMap.put(String.valueOf(charAt3) + "", arrayList4);
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            entry.getKey();
            for (net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions promoPayOptionAdapterParam : (List) entry.getValue()) {
                PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = new PromoPayOptionAdapterParam(1, promoPayOptionAdapterParam);
                promoPayOptionAdapterParam2.setMode("NET_BANKING");
                if (arrayList2 != null) {
                    arrayList2.add(promoPayOptionAdapterParam2);
                }
                if (arrayList3 != null) {
                    arrayList3.add(promoPayOptionAdapterParam2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r2 = (r2 = r5.getBody()).getBinDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isBinPayModeSame(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "paymode"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "bin6"
            kotlin.g.b.k.c(r5, r0)
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r0 = r0.getBinResposne(r5)
            r1 = 1
            if (r0 == 0) goto L_0x004c
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r5 = r0.getBinResposne(r5)
            r0 = 0
            if (r5 == 0) goto L_0x0031
            net.one97.paytm.nativesdk.common.model.Body r2 = r5.getBody()
            if (r2 == 0) goto L_0x0031
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail r2 = r2.getBinDetail()
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = r2.getPaymentMode()
            goto L_0x0032
        L_0x0031:
            r2 = r0
        L_0x0032:
            if (r2 == 0) goto L_0x004c
            net.one97.paytm.nativesdk.common.model.Body r5 = r5.getBody()
            if (r5 == 0) goto L_0x0044
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail r5 = r5.getBinDetail()
            if (r5 == 0) goto L_0x0044
            java.lang.String r0 = r5.getPaymentMode()
        L_0x0044:
            boolean r4 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
            if (r4 != 0) goto L_0x004c
            r4 = 0
            return r4
        L_0x004c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionViewModel.isBinPayModeSame(java.lang.String, java.lang.String):boolean");
    }
}
