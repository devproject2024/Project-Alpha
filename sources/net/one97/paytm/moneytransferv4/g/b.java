package net.one97.paytm.moneytransferv4.g;

import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.p2p.CredsAllowed;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.SenderInfo;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55426a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int a(PaymentCombinationAPIResponse paymentCombinationAPIResponse) {
            k.c(paymentCombinationAPIResponse, "paymentCombinationAPIResponse");
            List<PaymentOptionItem> paymentOptionList = paymentCombinationAPIResponse.getPaymentOptionList();
            if (paymentOptionList == null) {
                k.a();
            }
            int i2 = 0;
            for (PaymentOptionItem next : paymentOptionList) {
                SourcePayment sourcePayment = next.getSourcePayment();
                String str = null;
                if (!k.a((Object) SDKConstants.TYPE_BANK, (Object) sourcePayment != null ? sourcePayment.getPaymentType() : null)) {
                    SourcePayment sourcePayment2 = next.getSourcePayment();
                    if (!k.a((Object) SDKConstants.AI_KEY_WALLET, (Object) sourcePayment2 != null ? sourcePayment2.getPaymentType() : null)) {
                        SourcePayment sourcePayment3 = next.getSourcePayment();
                        if (!k.a((Object) "UPI", (Object) sourcePayment3 != null ? sourcePayment3.getPaymentType() : null)) {
                            continue;
                            i2++;
                        }
                    }
                }
                SourcePayment sourcePayment4 = next.getSourcePayment();
                if (sourcePayment4 != null) {
                    str = sourcePayment4.getPaymentInstrumentStatus();
                }
                if (k.a((Object) "ENABLED", (Object) str)) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }

        public static UpiProfileDefaultBank a(PaymentCombinationAPIResponse paymentCombinationAPIResponse, PaymentOptionItem paymentOptionItem) {
            k.c(paymentCombinationAPIResponse, "paymentCombinationAPIResponse");
            k.c(paymentOptionItem, "paymentOptionItem");
            SourcePayment sourcePayment = paymentOptionItem.getSourcePayment();
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
            upiProfileDefaultBank.setDebitBank(bankAccount);
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
            debitBank.setAccountType("SAVINGS");
            String str = null;
            bankAccount.setAccountType(sourcePayment != null ? sourcePayment.getAccountType() : null);
            bankAccount.setAccRefId(sourcePayment != null ? sourcePayment.getAccRefId() : null);
            bankAccount.setAccount(sourcePayment != null ? sourcePayment.getBankAccountNumber() : null);
            bankAccount.setIfsc(sourcePayment != null ? sourcePayment.getIfscCode() : null);
            bankAccount.setBankName(sourcePayment != null ? sourcePayment.getBankName() : null);
            SenderInfo senderInfo = paymentCombinationAPIResponse.getSenderInfo();
            bankAccount.setCustomerName(senderInfo != null ? senderInfo.getName() : null);
            bankAccount.setMbeba(sourcePayment != null ? sourcePayment.getMpinSet() : null);
            ArrayList arrayList = new ArrayList();
            if (!(sourcePayment == null || sourcePayment.getCredsAllowed() == null)) {
                ArrayList<CredsAllowed> credsAllowed = sourcePayment.getCredsAllowed();
                if (credsAllowed == null) {
                    k.a();
                }
                Iterator<CredsAllowed> it2 = credsAllowed.iterator();
                while (it2.hasNext()) {
                    CredsAllowed next = it2.next();
                    BankAccountDetails.BankAccountCredentials bankAccountCredentials = new BankAccountDetails.BankAccountCredentials();
                    bankAccountCredentials.setDLength1(next.getDLength());
                    bankAccountCredentials.setCredsAllowedType(next.getCredsAllowedType());
                    bankAccountCredentials.setCredsAllowedDType(next.getCredsAllowedDType());
                    bankAccountCredentials.setCredsAllowedSubType1(next.getCredsAllowedSubType());
                    bankAccountCredentials.setCredsAllowedDLength(next.getCredsAllowedDLength());
                    arrayList.add(bankAccountCredentials);
                }
                bankAccount.setBankCredsAllowed(arrayList);
            }
            if (sourcePayment != null) {
                str = sourcePayment.getVpaId();
            }
            upiProfileDefaultBank.setVirtualAddress(str);
            return upiProfileDefaultBank;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.g.b$a$a  reason: collision with other inner class name */
        public static final class C1024a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public static final C1024a f55427a = new C1024a();

            C1024a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }
    }
}
