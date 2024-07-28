package net.one97.paytm.nativesdk.paymethods.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.MandateAccountDetails;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;

public abstract class PaymentInstrumentView {
    public static final Companion Companion = new Companion((g) null);
    public static final int MAX_VALUE = 100;

    public abstract int getPriorityOrder();

    private PaymentInstrumentView() {
    }

    public /* synthetic */ PaymentInstrumentView(g gVar) {
        this();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class WalletView extends PaymentInstrumentView {
        private final boolean isInstrumentValid;
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WalletView(PaymentModes paymentModes2, boolean z) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
            this.isInstrumentValid = z;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final boolean isInstrumentValid() {
            return this.isInstrumentValid;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class GiftVoucher extends PaymentInstrumentView {
        private final boolean isInstrumentValid;
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GiftVoucher(PaymentModes paymentModes2, boolean z) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
            this.isInstrumentValid = z;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final boolean isInstrumentValid() {
            return this.isInstrumentValid;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class UPIPushView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;
        private final String priority;
        private final VpaBankAccountDetail vpaDetails;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UPIPushView(PaymentModes paymentModes2, VpaBankAccountDetail vpaBankAccountDetail, String str) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            k.c(vpaBankAccountDetail, "vpaDetails");
            this.paymentModes = paymentModes2;
            this.vpaDetails = vpaBankAccountDetail;
            this.priority = str;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final String getPriority() {
            return this.priority;
        }

        public final VpaBankAccountDetail getVpaDetails() {
            return this.vpaDetails;
        }

        public final int getPriorityOrder() {
            String str = this.priority;
            if (str != null) {
                return Integer.parseInt(str);
            }
            return 100;
        }
    }

    public static final class UpiOnboardingView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;
        private final String priority;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpiOnboardingView(PaymentModes paymentModes2, String str) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
            this.priority = str;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final String getPriority() {
            return this.priority;
        }

        public final int getPriorityOrder() {
            String str = this.priority;
            if (str != null) {
                return Integer.parseInt(str);
            }
            return 100;
        }
    }

    public static final class PaytmBankView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaytmBankView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class PostpaidView extends PaymentInstrumentView {
        private final boolean isAddMoney;
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PostpaidView(PaymentModes paymentModes2, boolean z) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
            this.isAddMoney = z;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final boolean isAddMoney() {
            return this.isAddMoney;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class SavedCardView extends PaymentInstrumentView {
        private final SavedInstruments savedInstrument;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedCardView(SavedInstruments savedInstruments) {
            super((g) null);
            k.c(savedInstruments, "savedInstrument");
            this.savedInstrument = savedInstruments;
        }

        public final SavedInstruments getSavedInstrument() {
            return this.savedInstrument;
        }

        public final int getPriorityOrder() {
            String priority = this.savedInstrument.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class CreditCardView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreditCardView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class DebitCardView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DebitCardView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class UPIColletView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UPIColletView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class EMIView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EMIView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class NetBankingView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetBankingView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class CODView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CODView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class AOAView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AOAView(PaymentModes paymentModes2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class Divider extends PaymentInstrumentView {
        public final int getPriorityOrder() {
            return -1;
        }

        public Divider() {
            super((g) null);
        }
    }

    public static final class WalletOtpView extends PaymentInstrumentView {
        private final boolean isInstrumentValid;
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WalletOtpView(PaymentModes paymentModes2, boolean z) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
            this.isInstrumentValid = z;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final boolean isInstrumentValid() {
            return this.isInstrumentValid;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class BankMandateView extends PaymentInstrumentView {
        private final MandateAccountDetails mandateAccountDetails;
        private final PaymentModes paymentModes;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BankMandateView(PaymentModes paymentModes2, MandateAccountDetails mandateAccountDetails2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
            this.mandateAccountDetails = mandateAccountDetails2;
        }

        public final MandateAccountDetails getMandateAccountDetails() {
            return this.mandateAccountDetails;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final int getPriorityOrder() {
            String priority = this.paymentModes.getPriority();
            if (priority != null) {
                return Integer.parseInt(priority);
            }
            return 100;
        }
    }

    public static final class SavedMandateView extends PaymentInstrumentView {
        private final PaymentModes paymentModes;
        private final SavedMandateBanksItem savedMandateBanksItem;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedMandateView(PaymentModes paymentModes2, SavedMandateBanksItem savedMandateBanksItem2) {
            super((g) null);
            k.c(paymentModes2, "paymentModes");
            this.paymentModes = paymentModes2;
            this.savedMandateBanksItem = savedMandateBanksItem2;
        }

        public final PaymentModes getPaymentModes() {
            return this.paymentModes;
        }

        public final SavedMandateBanksItem getSavedMandateBanksItem() {
            return this.savedMandateBanksItem;
        }

        public final int getPriorityOrder() {
            String priority;
            SavedMandateBanksItem savedMandateBanksItem2 = this.savedMandateBanksItem;
            if (savedMandateBanksItem2 == null || (priority = savedMandateBanksItem2.getPriority()) == null) {
                return 100;
            }
            return Integer.parseInt(priority);
        }
    }
}
