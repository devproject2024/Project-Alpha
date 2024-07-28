package com.business.merchant_payments.payment.model.datahelpers;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.orderSummaryList.DaywiseOrderList;
import com.business.merchant_payments.model.primary.OrderList;
import com.business.merchant_payments.model.primary.OrderSummary;
import com.business.merchant_payments.payment.model.PaymentsEmptyModel;
import com.business.merchant_payments.payment.model.PaymentsHeaderModel;
import com.business.merchant_payments.payment.model.PaymentsLoaderModel;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;
import com.business.merchant_payments.payment.model.PaymentsSummaryModel;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;

public final class PaymentsDataHelper {
    public static final String CASH_WITHDRAWAL_CONSTANT = "Cash withdrawal";
    public static final String CASH_WITHDRAWAL_INCENTIVE_CONSTANT = "Cash withdrawal Incentive";
    public static final Companion Companion = new Companion((g) null);
    public static final int SUMMARY_API_MAX_AVAILABLE_TRANSACTIONS = 4;
    public boolean backgroundColor = true;
    public final boolean hasRefundPermission;
    public boolean isDateRangeScreen;
    public final boolean isMerchantMigrated;
    public final Context mContext;
    public DataState mDataState = DataState.LOADING;
    public String mDate = "";
    public String mDateForAPI = "";
    public int mGATransactionNumber = 1;
    public final PaymentsHeaderModel mHeaderModel = new PaymentsHeaderModel((String) null, 1, (g) null);
    public TransactionListState mListState = TransactionListState.UNINITIALISED;
    public final PaymentsLoaderModel mLoaderModel = new PaymentsLoaderModel();
    public int mPageForAPI = 1;
    public boolean mShouldAlternateBackground = true;
    public final PaymentsShowMoreModel mShowMoreModel = new PaymentsShowMoreModel((String) null, (ObservableBoolean) null, (ObservableBoolean) null, 7, (g) null);
    public final PaymentsSummaryModel mSummaryModel = new PaymentsSummaryModel((String) null, (String) null, (String) null, false, 15, (g) null);
    public int mTotalPayments;
    public int mTotalPaymentsReceived;
    public int mTotalTransactions;
    public final ArrayList<Object> mTransactionsList = new ArrayList<>();
    public int mVisibleTransactions;
    public boolean shouldShowSummary = true;

    public enum DataState {
        LOADING,
        EMPTY,
        ERROR,
        PAYMENTS,
        PAYMENTS_EXPANDABLE,
        MIGRATED_EXPANDED
    }

    public enum TransactionListState {
        INITIAL,
        INTERMEDIATE,
        FINAL,
        UNINITIALISED
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TransactionListState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TransactionListState.INITIAL.ordinal()] = 1;
            $EnumSwitchMapping$0[TransactionListState.INTERMEDIATE.ordinal()] = 2;
            $EnumSwitchMapping$0[TransactionListState.FINAL.ordinal()] = 3;
            int[] iArr2 = new int[DataState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[DataState.EMPTY.ordinal()] = 1;
            $EnumSwitchMapping$1[DataState.PAYMENTS.ordinal()] = 2;
            $EnumSwitchMapping$1[DataState.PAYMENTS_EXPANDABLE.ordinal()] = 3;
            $EnumSwitchMapping$1[DataState.MIGRATED_EXPANDED.ordinal()] = 4;
            $EnumSwitchMapping$1[DataState.ERROR.ordinal()] = 5;
            $EnumSwitchMapping$1[DataState.LOADING.ordinal()] = 6;
        }
    }

    public PaymentsDataHelper() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        this.mContext = instance.getAppContext();
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        this.isMerchantMigrated = instance2.getMerchantDataProvider().i();
        PaymentsConfig instance3 = PaymentsConfig.getInstance();
        k.b(instance3, "PaymentsConfig.getInstance()");
        this.hasRefundPermission = instance3.getMerchantDataProvider().k();
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final String getMDate() {
        return this.mDate;
    }

    public final void setMDate(String str) {
        k.d(str, "<set-?>");
        this.mDate = str;
    }

    private final String getNameFromData(OrderDetail orderDetail) {
        String maskedMobileNumber;
        try {
            String str = null;
            if (isReversalOrVoidTransaction(orderDetail.getAdditionalInfo())) {
                maskedMobileNumber = getRevarsalOrVoidTransactionName(orderDetail.getAdditionalInfo());
            } else {
                boolean z = true;
                if (orderDetail.getBizType() != null && p.a(orderDetail.getBizType(), AppConstants.ApiNames.CHARGEBACK, true)) {
                    maskedMobileNumber = this.mContext.getString(R.string.mp_chargeback);
                } else if (orderDetail.getBizType() == null || !p.a(orderDetail.getBizType(), "REFUND", true)) {
                    AdditionalInfo additionalInfo = orderDetail.getAdditionalInfo();
                    if (p.a("Cash withdrawal", additionalInfo != null ? additionalInfo.getPayMethod() : null, true)) {
                        maskedMobileNumber = this.mContext.getString(R.string.mp_cash_withdrawal);
                    } else {
                        AdditionalInfo additionalInfo2 = orderDetail.getAdditionalInfo();
                        if (p.a("Cash withdrawal Incentive", additionalInfo2 != null ? additionalInfo2.getPayMethod() : null, true)) {
                            maskedMobileNumber = this.mContext.getString(R.string.mp_cash_incentive);
                        } else {
                            AdditionalInfo additionalInfo3 = orderDetail.getAdditionalInfo();
                            String customerName = additionalInfo3 != null ? additionalInfo3.getCustomerName() : null;
                            if (!(customerName == null || customerName.length() == 0)) {
                                AdditionalInfo additionalInfo4 = orderDetail.getAdditionalInfo();
                                if (additionalInfo4 != null) {
                                    maskedMobileNumber = additionalInfo4.getCustomerName();
                                }
                                k.a((Object) str);
                                return str;
                            }
                            AdditionalInfo additionalInfo5 = orderDetail.getAdditionalInfo();
                            String virtualPaymentAddr = additionalInfo5 != null ? additionalInfo5.getVirtualPaymentAddr() : null;
                            if (!(virtualPaymentAddr == null || virtualPaymentAddr.length() == 0)) {
                                AdditionalInfo additionalInfo6 = orderDetail.getAdditionalInfo();
                                if (additionalInfo6 != null) {
                                    maskedMobileNumber = additionalInfo6.getVirtualPaymentAddr();
                                }
                                k.a((Object) str);
                                return str;
                            } else if (isCardTransaction(orderDetail.getAdditionalInfo())) {
                                AdditionalInfo additionalInfo7 = orderDetail.getAdditionalInfo();
                                if (additionalInfo7 != null) {
                                    maskedMobileNumber = additionalInfo7.getMaskedCardNo();
                                }
                                k.a((Object) str);
                                return str;
                            } else {
                                AdditionalInfo additionalInfo8 = orderDetail.getAdditionalInfo();
                                String userMobile = additionalInfo8 != null ? additionalInfo8.getUserMobile() : null;
                                if (!(userMobile == null || userMobile.length() == 0)) {
                                    z = false;
                                }
                                if (!z) {
                                    AdditionalInfo additionalInfo9 = orderDetail.getAdditionalInfo();
                                    if (additionalInfo9 != null) {
                                        str = additionalInfo9.getUserMobile();
                                    }
                                    maskedMobileNumber = AppUtility.getMaskedMobileNumber(str);
                                } else {
                                    str = "------";
                                    k.a((Object) str);
                                    return str;
                                }
                            }
                        }
                    }
                } else {
                    maskedMobileNumber = this.mContext.getString(R.string.mp_refunded);
                }
            }
            str = maskedMobileNumber;
            k.a((Object) str);
            return str;
        } catch (Exception unused) {
            return "----";
        }
    }

    private final boolean isReversalOrVoidTransaction(AdditionalInfo additionalInfo) {
        if ((additionalInfo != null ? additionalInfo.getCancelRequestType() : null) != null) {
            return p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.REVERSAL, true) || p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.VOID, true);
        }
        return false;
    }

    private final String getRevarsalOrVoidTransactionName(AdditionalInfo additionalInfo) {
        if ((additionalInfo != null ? additionalInfo.getCancelRequestType() : null) != null) {
            if (p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.REVERSAL, true)) {
                return this.mContext.getString(R.string.mp_reversal);
            }
            if (p.a(additionalInfo.getCancelRequestType(), AppConstants.ApiNames.VOID, true)) {
                return this.mContext.getString(R.string.mp_void_txn);
            }
        }
        return null;
    }

    private final boolean isCardTransaction(AdditionalInfo additionalInfo) {
        if (additionalInfo == null) {
            return false;
        }
        try {
            String payMethod = additionalInfo.getPayMethod();
            if (payMethod == null || payMethod.length() == 0) {
                return false;
            }
            if (!p.a(additionalInfo.getPayMethod(), AppConstants.CREDIT_CARD, true) && !p.a(additionalInfo.getPayMethod(), AppConstants.DEBIT_CARD, true) && !p.a(additionalInfo.getPayMethod(), "EMI", true) && !p.a(additionalInfo.getPayMethod(), AppConstants.EMI_CC, true) && !p.a(additionalInfo.getPayMethod(), AppConstants.EMI_DC, true)) {
                return false;
            }
            String maskedCardNo = additionalInfo.getMaskedCardNo();
            if (!(maskedCardNo == null || maskedCardNo.length() == 0)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private final String getFormattedTime(String str) {
        try {
            String format = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US).parse(str));
            k.b(format, "outputDateFormat.format(date)");
            return p.a(p.a(format, "PM", "pm", false), "AM", "am", false);
        } catch (ParseException unused) {
            return "----";
        }
    }

    public final String getFormattedDate(String str, String str2, String str3, Locale locale) {
        k.d(locale, ContactsConstant.LOCALE);
        try {
            String format = new SimpleDateFormat(str3, locale).format(new SimpleDateFormat(str2, locale).parse(str));
            k.b(format, "outputDateFormat.format(date)");
            return format;
        } catch (ParseException unused) {
            return "";
        }
    }

    public final String getCurrentFormattedDate(String str) {
        try {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            k.b(instance, "calendar");
            String format = simpleDateFormat.format(instance.getTime());
            k.b(format, "df.format(calendar.time)");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getFormattedAmountForTransaction(com.business.merchant_payments.payment.model.orderDetail.OrderDetail r7) {
        /*
            r6 = this;
            com.business.merchant_payments.payment.model.orderDetail.PayMoneyAmount r0 = r7.getPayMoneyAmount()     // Catch:{ Exception -> 0x007b }
            r1 = 0
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getValue()     // Catch:{ Exception -> 0x007b }
            if (r0 == 0) goto L_0x0016
            double r2 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x007b }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x007b }
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 == 0) goto L_0x0025
            double r2 = r0.doubleValue()     // Catch:{ Exception -> 0x007b }
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r2 = r2 / r4
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x007b }
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            if (r0 == 0) goto L_0x0036
            double r0 = r0.doubleValue()     // Catch:{ Exception -> 0x007b }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x007b }
            java.lang.String r1 = "##,##,##,##,###.##"
            java.lang.String r1 = com.business.merchant_payments.common.utility.AppUtility.formatNumber(r0, r1)     // Catch:{ Exception -> 0x007b }
        L_0x0036:
            java.lang.String r0 = r7.getBizType()     // Catch:{ Exception -> 0x007b }
            if (r0 == 0) goto L_0x0058
            java.lang.String r0 = r7.getBizType()     // Catch:{ Exception -> 0x007b }
            java.lang.String r2 = "REFUND"
            r3 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r3)     // Catch:{ Exception -> 0x007b }
            if (r0 != 0) goto L_0x0055
            java.lang.String r7 = r7.getBizType()     // Catch:{ Exception -> 0x007b }
            java.lang.String r0 = "CHARGEBACK"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r3)     // Catch:{ Exception -> 0x007b }
            if (r7 == 0) goto L_0x0058
        L_0x0055:
            java.lang.String r7 = "- "
            goto L_0x005a
        L_0x0058:
            java.lang.String r7 = "  "
        L_0x005a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
            r0.<init>()     // Catch:{ Exception -> 0x007b }
            r0.append(r7)     // Catch:{ Exception -> 0x007b }
            android.content.Context r7 = r6.mContext     // Catch:{ Exception -> 0x007b }
            int r2 = com.business.merchant_payments.R.string.mp_rupee_symbol     // Catch:{ Exception -> 0x007b }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x007b }
            r0.append(r7)     // Catch:{ Exception -> 0x007b }
            android.content.Context r7 = r6.mContext     // Catch:{ Exception -> 0x007b }
            java.lang.String r7 = com.business.merchant_payments.common.utility.AppUtility.getFormattedPrice(r1, r7)     // Catch:{ Exception -> 0x007b }
            r0.append(r7)     // Catch:{ Exception -> 0x007b }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x007b }
            goto L_0x007d
        L_0x007b:
            java.lang.String r7 = "0.00"
        L_0x007d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.getFormattedAmountForTransaction(com.business.merchant_payments.payment.model.orderDetail.OrderDetail):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00be A[SYNTHETIC, Splitter:B:58:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.business.merchant_payments.payment.model.PaymentsTransactionModel getPaymentTransactionModel(com.business.merchant_payments.payment.model.orderDetail.OrderDetail r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.String r1 = r22.getBizType()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0012
            int r1 = r1.length()
            if (r1 == 0) goto L_0x0012
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            java.lang.String r4 = "REFUND"
            r5 = 0
            if (r1 != 0) goto L_0x0027
            java.lang.String r1 = r22.getBizType()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0027
            boolean r1 = r0.hasRefundPermission
            if (r1 != 0) goto L_0x0027
            return r5
        L_0x0027:
            java.lang.String r1 = r22.getBizType()
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = r22.getBizType()
            java.lang.String r6 = "ACQUIRING"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r3)
            if (r1 == 0) goto L_0x003e
            int r1 = r0.mTotalPaymentsReceived
            int r1 = r1 + r3
            r0.mTotalPaymentsReceived = r1
        L_0x003e:
            java.lang.String r1 = r21.getNameFromData(r22)
            java.lang.String r6 = ""
            java.lang.String r7 = "null"
            java.lang.String r12 = kotlin.m.p.a(r1, r7, r6, r2)
            java.lang.String r13 = r21.getFormattedAmountForTransaction(r22)
            java.lang.String r1 = r22.getOrderCreatedTime()
            java.lang.String r11 = r0.getFormattedTime(r1)
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r22.getAdditionalInfo()     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = r1.getPayMethodIconUrl()     // Catch:{ Exception -> 0x0066 }
            goto L_0x0062
        L_0x0061:
            r1 = r5
        L_0x0062:
            java.lang.String r6 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            r14 = r6
            java.lang.String r1 = "Cash withdrawal Incentive"
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r6 = r22.getAdditionalInfo()     // Catch:{ Exception -> 0x007c }
            if (r6 == 0) goto L_0x0074
            java.lang.String r6 = r6.getPayMethod()     // Catch:{ Exception -> 0x007c }
            goto L_0x0075
        L_0x0074:
            r6 = r5
        L_0x0075:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r3)     // Catch:{ Exception -> 0x007c }
            r16 = r1
            goto L_0x007e
        L_0x007c:
            r16 = 0
        L_0x007e:
            java.lang.String r1 = r22.getBizType()     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            java.lang.String r1 = r22.getBizType()     // Catch:{ Exception -> 0x009b }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)     // Catch:{ Exception -> 0x009b }
            if (r1 != 0) goto L_0x0098
        L_0x008e:
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r22.getAdditionalInfo()     // Catch:{ Exception -> 0x009b }
            boolean r1 = r0.isReversalOrVoidTransaction(r1)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x009b
        L_0x0098:
            r19 = 1
            goto L_0x009d
        L_0x009b:
            r19 = 0
        L_0x009d:
            java.lang.String r1 = r22.getBizType()     // Catch:{ Exception -> 0x00b2 }
            if (r1 == 0) goto L_0x00b2
            java.lang.String r1 = r22.getBizType()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r4 = "CHARGEBACK"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)     // Catch:{ Exception -> 0x00b2 }
            if (r1 == 0) goto L_0x00b2
            r20 = 1
            goto L_0x00b4
        L_0x00b2:
            r20 = 0
        L_0x00b4:
            java.lang.String r1 = r22.getOrderStatus()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r4 = "(this as java.lang.String).toUpperCase(locale)"
            java.lang.String r6 = "Locale.ROOT"
            if (r1 == 0) goto L_0x00d5
            java.util.Locale r7 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x00ea }
            kotlin.g.b.k.b(r7, r6)     // Catch:{ Exception -> 0x00ea }
            if (r1 == 0) goto L_0x00cd
            java.lang.String r1 = r1.toUpperCase(r7)     // Catch:{ Exception -> 0x00ea }
            kotlin.g.b.k.b(r1, r4)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00d6
        L_0x00cd:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x00ea }
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r4)     // Catch:{ Exception -> 0x00ea }
            throw r1     // Catch:{ Exception -> 0x00ea }
        L_0x00d5:
            r1 = r5
        L_0x00d6:
            java.lang.String r7 = "Client_pending"
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x00ea }
            kotlin.g.b.k.b(r8, r6)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r6 = r7.toUpperCase(r8)     // Catch:{ Exception -> 0x00ea }
            kotlin.g.b.k.b(r6, r4)     // Catch:{ Exception -> 0x00ea }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r6)     // Catch:{ Exception -> 0x00ea }
            r15 = r2
            goto L_0x00eb
        L_0x00ea:
            r15 = 0
        L_0x00eb:
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r22.getAdditionalInfo()
            if (r1 == 0) goto L_0x00f6
            java.lang.String r1 = r1.getCancelRequestType()
            goto L_0x00f7
        L_0x00f6:
            r1 = r5
        L_0x00f7:
            java.lang.String r2 = "REVERSAL"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            if (r1 != 0) goto L_0x0115
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r22.getAdditionalInfo()
            if (r1 == 0) goto L_0x0109
            java.lang.String r5 = r1.getCancelRequestType()
        L_0x0109:
            java.lang.String r1 = "VOID"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r3)
            if (r1 == 0) goto L_0x0112
            goto L_0x0115
        L_0x0112:
            r2 = r22
            goto L_0x0125
        L_0x0115:
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r22.getAdditionalInfo()
            kotlin.g.b.k.a((java.lang.Object) r1)
            java.lang.String r1 = r1.getCancelRequestType()
            r2 = r22
            r2.setBizType(r1)
        L_0x0125:
            com.business.merchant_payments.payment.model.PaymentsTransactionModel r1 = new com.business.merchant_payments.payment.model.PaymentsTransactionModel
            int r9 = r0.mGATransactionNumber
            boolean r4 = r0.backgroundColor
            boolean r5 = r0.isDateRangeScreen
            r8 = r1
            r10 = r22
            r17 = r4
            r18 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            int r2 = r0.mGATransactionNumber
            int r2 = r2 + r3
            r0.mGATransactionNumber = r2
            boolean r2 = r0.mShouldAlternateBackground
            if (r2 == 0) goto L_0x0145
            boolean r2 = r0.backgroundColor
            r2 = r2 ^ r3
            r0.backgroundColor = r2
        L_0x0145:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.getPaymentTransactionModel(com.business.merchant_payments.payment.model.orderDetail.OrderDetail):com.business.merchant_payments.payment.model.PaymentsTransactionModel");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021 A[Catch:{ Exception -> 0x0050 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getFormattedAmount(com.business.merchant_payments.model.primary.TotalAmount r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0012
            java.lang.String r6 = r6.getValue()     // Catch:{ Exception -> 0x0050 }
            if (r6 == 0) goto L_0x0012
            double r1 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x0050 }
            java.lang.Double r6 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0013
        L_0x0012:
            r6 = r0
        L_0x0013:
            if (r6 == 0) goto L_0x0021
            double r1 = r6.doubleValue()     // Catch:{ Exception -> 0x0050 }
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r1 = r1 / r3
            java.lang.Double r6 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0022
        L_0x0021:
            r6 = r0
        L_0x0022:
            if (r6 == 0) goto L_0x0032
            double r0 = r6.doubleValue()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = "##,##,##,##,###.##"
            java.lang.String r0 = com.business.merchant_payments.common.utility.AppUtility.formatNumber(r6, r0)     // Catch:{ Exception -> 0x0050 }
        L_0x0032:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r6.<init>()     // Catch:{ Exception -> 0x0050 }
            android.content.Context r1 = r5.mContext     // Catch:{ Exception -> 0x0050 }
            int r2 = com.business.merchant_payments.R.string.mp_rupee_symbol     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x0050 }
            r6.append(r1)     // Catch:{ Exception -> 0x0050 }
            android.content.Context r1 = r5.mContext     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = com.business.merchant_payments.common.utility.AppUtility.getFormattedPrice(r0, r1)     // Catch:{ Exception -> 0x0050 }
            r6.append(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0052
        L_0x0050:
            java.lang.String r6 = "0.00"
        L_0x0052:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.getFormattedAmount(com.business.merchant_payments.model.primary.TotalAmount):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataFromPrimaryAPI(com.business.merchant_payments.model.primary.PrimaryAPIModel r11) {
        /*
            r10 = this;
            java.lang.String r0 = "data"
            kotlin.g.b.k.d(r11, r0)
            r10.resetAllData()
            com.business.merchant_payments.payment.model.PaymentsHeaderModel r0 = r10.mHeaderModel
            android.content.Context r1 = r10.mContext     // Catch:{ Exception -> 0x001a }
            int r2 = com.business.merchant_payments.R.string.mp_today     // Catch:{ Exception -> 0x001a }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x001a }
            java.lang.String r2 = "mContext.getString(R.string.mp_today)"
            kotlin.g.b.k.b(r1, r2)     // Catch:{ Exception -> 0x001a }
            r10.mDate = r1     // Catch:{ Exception -> 0x001a }
            goto L_0x001c
        L_0x001a:
            java.lang.String r1 = " "
        L_0x001c:
            r0.setDate(r1)
            com.business.merchant_payments.model.primary.OrderList r0 = r11.getOrderList()
            r1 = 0
            if (r0 == 0) goto L_0x005e
            com.business.merchant_payments.model.primary.OrderList r0 = r11.getOrderList()
            if (r0 == 0) goto L_0x0031
            java.util.List r0 = r0.getOrderList()
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            if (r0 == 0) goto L_0x005e
            com.business.merchant_payments.model.primary.OrderList r0 = r11.getOrderList()
            kotlin.g.b.k.a((java.lang.Object) r0)
            java.util.List r0 = r0.getOrderList()
            kotlin.g.b.k.a((java.lang.Object) r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005e
            java.lang.Object r2 = r0.next()
            com.business.merchant_payments.payment.model.orderDetail.OrderDetail r2 = (com.business.merchant_payments.payment.model.orderDetail.OrderDetail) r2
            com.business.merchant_payments.payment.model.PaymentsTransactionModel r2 = r10.getPaymentTransactionModel(r2)
            if (r2 == 0) goto L_0x0046
            java.util.ArrayList<java.lang.Object> r3 = r10.mTransactionsList
            r3.add(r2)
            goto L_0x0046
        L_0x005e:
            com.business.merchant_payments.model.primary.OrderSummary r0 = r11.getOrderSummary()
            if (r0 == 0) goto L_0x00fd
            r0 = 0
            com.business.merchant_payments.model.primary.OrderSummary r2 = r11.getOrderSummary()     // Catch:{ Exception -> 0x0077 }
            if (r2 == 0) goto L_0x006f
            java.lang.String r1 = r2.getTotalCount()     // Catch:{ Exception -> 0x0077 }
        L_0x006f:
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x0077 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0077 }
            goto L_0x0078
        L_0x0077:
            r1 = 0
        L_0x0078:
            r10.mTotalPayments = r1
            com.business.merchant_payments.model.primary.OrderList r1 = r11.getOrderList()     // Catch:{ Exception -> 0x00a0 }
            if (r1 == 0) goto L_0x00a0
            com.business.merchant_payments.model.primary.OrderList r1 = r11.getOrderList()     // Catch:{ Exception -> 0x00a0 }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x00a0 }
            java.util.List r1 = r1.getOrderList()     // Catch:{ Exception -> 0x00a0 }
            if (r1 == 0) goto L_0x00a0
            com.business.merchant_payments.model.primary.OrderList r1 = r11.getOrderList()     // Catch:{ Exception -> 0x00a0 }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x00a0 }
            java.util.List r1 = r1.getOrderList()     // Catch:{ Exception -> 0x00a0 }
            kotlin.g.b.k.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x00a0 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            r10.mTotalTransactions = r1
            int r2 = r10.mTotalPayments
            if (r2 != 0) goto L_0x00b1
            if (r1 != 0) goto L_0x00ac
            com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper$DataState r1 = com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.DataState.EMPTY
            goto L_0x00ae
        L_0x00ac:
            com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper$DataState r1 = com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.DataState.PAYMENTS
        L_0x00ae:
            r10.mDataState = r1
            goto L_0x00d9
        L_0x00b1:
            int r1 = r10.mTotalPaymentsReceived
            if (r1 != r2) goto L_0x00ba
            com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper$DataState r1 = com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.DataState.PAYMENTS
            r10.mDataState = r1
            goto L_0x00d9
        L_0x00ba:
            if (r1 >= r2) goto L_0x00d9
            com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper$DataState r1 = com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.DataState.PAYMENTS_EXPANDABLE
            r10.mDataState = r1
            com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper$TransactionListState r1 = com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.TransactionListState.INITIAL
            r10.mListState = r1
            com.business.merchant_payments.gtm.GAGTMTagAnalytics r2 = com.business.merchant_payments.gtm.GAGTMTagAnalytics.getSingleInstance()
            android.content.Context r3 = r10.mContext
            java.lang.String r4 = "HomePage"
            java.lang.String r5 = "Payments Show More"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r8 = "Promo Impression"
            java.lang.String r9 = ""
            r2.sendEvent(r3, r4, r5, r6, r7, r8, r9)
        L_0x00d9:
            com.business.merchant_payments.payment.model.PaymentsSummaryModel r1 = r10.mSummaryModel
            r1.setNonMigrated(r0)
            com.business.merchant_payments.payment.model.PaymentsSummaryModel r0 = r10.mSummaryModel
            int r1 = r10.mTotalPayments
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setTotalPayments(r1)
            com.business.merchant_payments.payment.model.PaymentsSummaryModel r0 = r10.mSummaryModel
            com.business.merchant_payments.model.primary.OrderSummary r11 = r11.getOrderSummary()
            kotlin.g.b.k.a((java.lang.Object) r11)
            com.business.merchant_payments.model.primary.TotalAmount r11 = r11.getTotalAmount()
            java.lang.String r11 = r10.getFormattedAmount(r11)
            r0.setTotalAmount(r11)
        L_0x00fd:
            int r11 = r10.mTotalTransactions
            r10.mVisibleTransactions = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper.setDataFromPrimaryAPI(com.business.merchant_payments.model.primary.PrimaryAPIModel):void");
    }

    private final void resetAllData() {
        this.mShowMoreModel.getShowMoreButtonState().set(true);
        this.mShowMoreModel.getShowMoreButtonProgressState().set(false);
        this.mDate = "";
        this.backgroundColor = true;
        this.mDateForAPI = "";
        this.mPageForAPI = 1;
        this.mDataState = DataState.LOADING;
        this.mTransactionsList.clear();
        this.mTotalTransactions = 0;
        this.mTotalPayments = 0;
        this.mTotalPaymentsReceived = 0;
    }

    public final ArrayList<Object> getPaymentsData() {
        ArrayList<Object> arrayList = new ArrayList<>();
        switch (WhenMappings.$EnumSwitchMapping$1[this.mDataState.ordinal()]) {
            case 1:
                arrayList.add(this.mHeaderModel);
                arrayList.add(new PaymentsEmptyModel());
                GAGTMTagAnalytics.getSingleInstance().sendEvent(this.mContext, "HomePage", "Payments Widget", "", "No Payments Today");
                break;
            case 2:
                if ((this.isMerchantMigrated || !this.isDateRangeScreen) && (!k.a((Object) this.mDate, (Object) ""))) {
                    arrayList.add(this.mHeaderModel);
                }
                if (this.shouldShowSummary) {
                    arrayList.add(this.mSummaryModel);
                }
                arrayList.addAll(this.mTransactionsList);
                this.mVisibleTransactions = this.mTransactionsList.size();
                break;
            case 3:
                arrayList.add(this.mHeaderModel);
                if (this.shouldShowSummary) {
                    arrayList.add(this.mSummaryModel);
                }
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.mListState.ordinal()];
                if (i2 == 1) {
                    if (this.mTransactionsList.size() > 4) {
                        arrayList.addAll(this.mTransactionsList.subList(0, 4));
                        this.mVisibleTransactions = 4;
                    } else {
                        arrayList.addAll(this.mTransactionsList);
                        this.mVisibleTransactions = this.mTransactionsList.size();
                    }
                    if (!this.isMerchantMigrated) {
                        this.mListState = TransactionListState.FINAL;
                    }
                } else if (i2 == 2 || i2 == 3) {
                    arrayList.addAll(this.mTransactionsList);
                    this.mVisibleTransactions = this.mTransactionsList.size();
                }
                arrayList.add(this.mShowMoreModel);
                break;
            case 4:
                if (this.shouldShowSummary) {
                    arrayList.add(this.mSummaryModel);
                }
                arrayList.addAll(this.mTransactionsList);
                break;
            case 5:
                if (this.isMerchantMigrated || !this.isDateRangeScreen) {
                    arrayList.add(this.mHeaderModel);
                }
                if (this.shouldShowSummary) {
                    arrayList.add(this.mSummaryModel);
                    break;
                }
                break;
            case 6:
                arrayList.add(this.mLoaderModel);
                break;
        }
        return arrayList;
    }

    public final ArrayList<Object> addMoreTransactions(ArrayList<OrderDetail> arrayList) {
        k.d(arrayList, "orderList");
        ArrayList<Object> arrayList2 = new ArrayList<>();
        if (this.mListState == TransactionListState.INITIAL) {
            if (arrayList.size() <= 4) {
                return arrayList2;
            }
            arrayList.subList(0, 4).clear();
        }
        Iterator<OrderDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            OrderDetail next = it2.next();
            k.b(next, "item");
            PaymentsTransactionModel paymentTransactionModel = getPaymentTransactionModel(next);
            if (paymentTransactionModel != null) {
                arrayList2.add(paymentTransactionModel);
                this.mTransactionsList.add(paymentTransactionModel);
            }
        }
        this.mListState = TransactionListState.INTERMEDIATE;
        this.mTotalTransactions += arrayList2.size();
        if (this.mTotalPaymentsReceived >= this.mTotalPayments) {
            this.mListState = TransactionListState.FINAL;
        }
        return arrayList2;
    }

    public final ArrayList<Object> getAllRemainingPayments() {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (4 <= this.mTransactionsList.size()) {
            ArrayList<Object> arrayList2 = this.mTransactionsList;
            arrayList.addAll(arrayList2.subList(4, arrayList2.size()));
        }
        return arrayList;
    }

    public final PaymentsShowMoreModel getShowMoreModel() {
        return this.mShowMoreModel;
    }

    public final PaymentsHeaderModel getHeaderModel() {
        return this.mHeaderModel;
    }

    public final void setLoadingState() {
        this.mDataState = DataState.LOADING;
    }

    public final void setErrorState() {
        this.mDataState = DataState.ERROR;
        PaymentsHeaderModel paymentsHeaderModel = this.mHeaderModel;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM", Locale.US);
        Calendar instance = Calendar.getInstance();
        k.b(instance, "Calendar.getInstance()");
        String format = simpleDateFormat.format(instance.getTime());
        k.b(format, "SimpleDateFormat(\"dd MMM…endar.getInstance().time)");
        paymentsHeaderModel.setDate(format);
        this.mSummaryModel.setTotalPayments("--");
        this.mSummaryModel.setRewardPoints("--");
        this.mSummaryModel.setTotalAmount("--");
    }

    public final boolean hasMorePayments() {
        DataState dataState = this.mDataState;
        if ((dataState == DataState.PAYMENTS_EXPANDABLE || dataState == DataState.MIGRATED_EXPANDED) && this.mListState != TransactionListState.FINAL) {
            return true;
        }
        return false;
    }

    public final ArrayList<Object> getAllPayments() {
        return this.mTransactionsList;
    }

    public final String getDateForAPI() {
        return this.mDateForAPI;
    }

    public final void incrementPageNumber() {
        this.mPageForAPI++;
    }

    public final int getPageForAPI() {
        return this.mPageForAPI;
    }

    public final void setDataFromSummaryAPI(DaywiseOrderList daywiseOrderList, boolean z) {
        int i2;
        DataState dataState;
        k.d(daywiseOrderList, "data");
        resetAllData();
        if (daywiseOrderList.getDate() != null) {
            String date = daywiseOrderList.getDate();
            Locale locale = Locale.getDefault();
            k.b(locale, "Locale.getDefault()");
            this.mDate = getFormattedDate(date, "yyyyMMdd", "dd MMMM", locale);
            String date2 = daywiseOrderList.getDate();
            Locale locale2 = Locale.US;
            k.b(locale2, "Locale.US");
            this.mDateForAPI = getFormattedDate(date2, "yyyyMMdd", "yyyy-MM-dd'T'HH:mm:ss", locale2);
        }
        this.mHeaderModel.setDate(this.mDate);
        this.mShowMoreModel.setDate(this.mDate);
        if (daywiseOrderList.getOrderList() != null) {
            List<OrderDetail> orderList = daywiseOrderList.getOrderList();
            k.a((Object) orderList);
            for (OrderDetail paymentTransactionModel : orderList) {
                PaymentsTransactionModel paymentTransactionModel2 = getPaymentTransactionModel(paymentTransactionModel);
                if (paymentTransactionModel2 != null) {
                    this.mTransactionsList.add(paymentTransactionModel2);
                }
            }
        }
        this.shouldShowSummary = z;
        int i3 = 0;
        try {
            String totalCount = daywiseOrderList.getTotalCount();
            k.a((Object) totalCount);
            i2 = Integer.parseInt(totalCount);
        } catch (Exception unused) {
            i2 = 0;
        }
        this.mTotalPayments = i2;
        try {
            if (daywiseOrderList.getOrderList() != null) {
                List<OrderDetail> orderList2 = daywiseOrderList.getOrderList();
                k.a((Object) orderList2);
                i3 = orderList2.size();
            }
        } catch (Exception unused2) {
        }
        this.mTotalTransactions = i3;
        int i4 = this.mTotalPayments;
        if (i4 == 0) {
            if (i3 == 0) {
                dataState = DataState.EMPTY;
            } else {
                dataState = DataState.PAYMENTS;
            }
            this.mDataState = dataState;
        } else {
            int i5 = this.mTotalPaymentsReceived;
            if (i5 == i4) {
                this.mDataState = DataState.PAYMENTS;
            } else if (i5 < i4) {
                this.mDataState = DataState.PAYMENTS_EXPANDABLE;
                this.mListState = TransactionListState.INITIAL;
            }
        }
        this.mSummaryModel.setTotalPayments(String.valueOf(this.mTotalPayments));
        this.mSummaryModel.setTotalAmount(getFormattedAmount(daywiseOrderList.getTotalAmount()));
        this.mVisibleTransactions = this.mTotalTransactions;
    }

    public final void checkForFinalState() {
        if (this.mTotalPaymentsReceived >= this.mTotalPayments) {
            this.mListState = TransactionListState.FINAL;
        }
    }

    public final boolean isLoadingState() {
        return this.mDataState == DataState.LOADING;
    }

    public final boolean isErrorState() {
        return this.mDataState == DataState.ERROR;
    }

    public final void setAlternateBackgrounds(boolean z) {
        this.mShouldAlternateBackground = z;
    }

    public final void setIsDateRangeScreen(boolean z) {
        this.isDateRangeScreen = z;
    }

    public final String getTotalVisibleTransactions() {
        return String.valueOf(this.mVisibleTransactions);
    }

    public final void setDataFromNonMigratedPaymentsAPI(NonMigratedPaymentsModel nonMigratedPaymentsModel) {
        int i2;
        k.d(nonMigratedPaymentsModel, "data");
        resetAllData();
        if (!this.isDateRangeScreen) {
            PaymentsHeaderModel paymentsHeaderModel = this.mHeaderModel;
            String string = this.mContext.getString(R.string.mp_today);
            k.b(string, "mContext.getString(R.string.mp_today)");
            paymentsHeaderModel.setDate(string);
        } else {
            this.mHeaderModel.setDate(getCurrentFormattedDate("dd MMMM"));
        }
        this.mTransactionsList.clear();
        if (nonMigratedPaymentsModel.getOrderList() != null) {
            OrderList orderList = nonMigratedPaymentsModel.getOrderList();
            k.a((Object) orderList);
            if (orderList.getOrderList() != null) {
                OrderList orderList2 = nonMigratedPaymentsModel.getOrderList();
                k.a((Object) orderList2);
                List<OrderDetail> orderList3 = orderList2.getOrderList();
                k.a((Object) orderList3);
                for (OrderDetail paymentTransactionModel : orderList3) {
                    PaymentsTransactionModel paymentTransactionModel2 = getPaymentTransactionModel(paymentTransactionModel);
                    if (paymentTransactionModel2 != null) {
                        this.mTransactionsList.add(paymentTransactionModel2);
                    }
                }
            }
        }
        if (nonMigratedPaymentsModel.getOrderSummary() != null) {
            int i3 = 0;
            try {
                OrderSummary orderSummary = nonMigratedPaymentsModel.getOrderSummary();
                String totalCount = orderSummary != null ? orderSummary.getTotalCount() : null;
                k.a((Object) totalCount);
                i2 = Integer.parseInt(totalCount);
            } catch (Exception unused) {
                i2 = 0;
            }
            this.mTotalPayments = i2;
            try {
                if (nonMigratedPaymentsModel.getOrderList() != null) {
                    OrderList orderList4 = nonMigratedPaymentsModel.getOrderList();
                    k.a((Object) orderList4);
                    if (orderList4.getOrderList() != null) {
                        OrderList orderList5 = nonMigratedPaymentsModel.getOrderList();
                        k.a((Object) orderList5);
                        List<OrderDetail> orderList6 = orderList5.getOrderList();
                        k.a((Object) orderList6);
                        i3 = orderList6.size();
                    }
                }
            } catch (Exception unused2) {
            }
            this.mTotalTransactions = i3;
            if (i3 == 0) {
                this.mDataState = DataState.EMPTY;
            } else if (this.isDateRangeScreen) {
                this.mDataState = DataState.MIGRATED_EXPANDED;
                this.mListState = TransactionListState.FINAL;
            } else if (i3 < 4) {
                this.mDataState = DataState.PAYMENTS;
            } else {
                this.mDataState = DataState.PAYMENTS_EXPANDABLE;
                this.mListState = TransactionListState.INITIAL;
                GAGTMTagAnalytics.getSingleInstance().sendEvent(this.mContext, "HomePage", "Payments Show More", "", "", "Promo Impression", "");
            }
            this.mSummaryModel.setNonMigrated(true);
            this.mSummaryModel.setTotalPayments(String.valueOf(this.mTotalPayments));
            PaymentsSummaryModel paymentsSummaryModel = this.mSummaryModel;
            OrderSummary orderSummary2 = nonMigratedPaymentsModel.getOrderSummary();
            k.a((Object) orderSummary2);
            paymentsSummaryModel.setTotalAmount(getFormattedAmount(orderSummary2.getTotalAmount()));
        }
        this.mVisibleTransactions = this.mTotalTransactions;
    }
}
