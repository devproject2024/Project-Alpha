package com.business.merchant_payments.payment;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.primary.OrderList;
import com.business.merchant_payments.model.primary.OrderSummary;
import com.business.merchant_payments.model.primary.PrimaryAPIModel;
import com.business.merchant_payments.payment.model.PaymentsHeaderModel;
import com.business.merchant_payments.payment.model.PaymentsLoaderModel;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;
import com.business.merchant_payments.payment.model.PaymentsSummaryModel;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
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

public final class HomePaymentsDataHelper {
    public static final String CASH_WITHDRAWAL_CONSTANT = "Cash withdrawal";
    public static final String CASH_WITHDRAWAL_INCENTIVE_CONSTANT = "Cash withdrawal Incentive";
    public static final Companion Companion = new Companion((g) null);
    public static final int SUMMARY_API_MAX_AVAILABLE_TRANSACTIONS = 4;
    public boolean backgroundColor = true;
    public final boolean hasRefundPermission;
    public final boolean isMerchantMigrated;
    public final Context mContext;
    public DataState mDataState = DataState.LOADING;
    public int mGATransactionNumber = 1;
    public PaymentsHeaderModel mHeaderModel;
    public TransactionListState mListState = TransactionListState.NOT_INITIALIZED;
    public int mPageForAPI = 1;
    public boolean mShouldAlternateBackground = true;
    public final PaymentsShowMoreModel mShowMoreModel = new PaymentsShowMoreModel((String) null, (ObservableBoolean) null, (ObservableBoolean) null, 7, (g) null);
    public PaymentsSummaryModel mSummaryModel;
    public int mTotalPayments;
    public int mTotalPaymentsReceived;
    public int mTotalTransactions;
    public ArrayList<Object> mTransactionsList;
    public int mVisibleTransactions;

    public enum DataState {
        LOADING,
        EMPTY,
        PAYMENTS,
        PAYMENTS_EXPANDABLE
    }

    public enum TransactionListState {
        NOT_INITIALIZED,
        INITIAL,
        INTERMEDIATE,
        FINAL
    }

    public HomePaymentsDataHelper() {
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

    private final String getNameFromData(OrderDetail orderDetail) {
        String str;
        try {
            boolean z = true;
            String str2 = null;
            if ((orderDetail.getBizType() == null || !p.a(orderDetail.getBizType(), "REFUND", true)) && !isReversalOrVoidTransaction(orderDetail.getAdditionalInfo())) {
                AdditionalInfo additionalInfo = orderDetail.getAdditionalInfo();
                if (p.a("Cash withdrawal", additionalInfo != null ? additionalInfo.getPayMethod() : null, true)) {
                    str = this.mContext.getString(R.string.mp_cash_withdrawal);
                } else {
                    AdditionalInfo additionalInfo2 = orderDetail.getAdditionalInfo();
                    if (p.a("Cash withdrawal Incentive", additionalInfo2 != null ? additionalInfo2.getPayMethod() : null, true)) {
                        str = this.mContext.getString(R.string.mp_cash_incentive);
                    } else {
                        AdditionalInfo additionalInfo3 = orderDetail.getAdditionalInfo();
                        String customerName = additionalInfo3 != null ? additionalInfo3.getCustomerName() : null;
                        if (!(customerName == null || customerName.length() == 0)) {
                            AdditionalInfo additionalInfo4 = orderDetail.getAdditionalInfo();
                            if (additionalInfo4 != null) {
                                str = additionalInfo4.getCustomerName();
                            }
                            k.a((Object) str2);
                            k.b(str2, "when {\n                (…        }\n            }!!");
                            return str2;
                        }
                        AdditionalInfo additionalInfo5 = orderDetail.getAdditionalInfo();
                        String virtualPaymentAddr = additionalInfo5 != null ? additionalInfo5.getVirtualPaymentAddr() : null;
                        if (!(virtualPaymentAddr == null || virtualPaymentAddr.length() == 0)) {
                            AdditionalInfo additionalInfo6 = orderDetail.getAdditionalInfo();
                            if (additionalInfo6 != null) {
                                str = additionalInfo6.getVirtualPaymentAddr();
                            }
                            k.a((Object) str2);
                            k.b(str2, "when {\n                (…        }\n            }!!");
                            return str2;
                        } else if (isCardTransaction(orderDetail.getAdditionalInfo())) {
                            AdditionalInfo additionalInfo7 = orderDetail.getAdditionalInfo();
                            if (additionalInfo7 != null) {
                                str = additionalInfo7.getMaskedCardNo();
                            }
                            k.a((Object) str2);
                            k.b(str2, "when {\n                (…        }\n            }!!");
                            return str2;
                        } else {
                            AdditionalInfo additionalInfo8 = orderDetail.getAdditionalInfo();
                            String userMobile = additionalInfo8 != null ? additionalInfo8.getUserMobile() : null;
                            if (!(userMobile == null || userMobile.length() == 0)) {
                                z = false;
                            }
                            if (!z) {
                                AdditionalInfo additionalInfo9 = orderDetail.getAdditionalInfo();
                                if (additionalInfo9 != null) {
                                    str2 = additionalInfo9.getUserMobile();
                                }
                                str = AppUtility.getMaskedMobileNumber(str2);
                            } else {
                                str2 = "------";
                                k.a((Object) str2);
                                k.b(str2, "when {\n                (…        }\n            }!!");
                                return str2;
                            }
                        }
                    }
                }
            } else {
                str = this.mContext.getString(R.string.mp_refunded);
            }
            str2 = str;
            k.a((Object) str2);
            k.b(str2, "when {\n                (…        }\n            }!!");
            return str2;
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

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getFormattedAmountForTransaction(com.business.merchant_payments.payment.model.orderDetail.OrderDetail r7) {
        /*
            r6 = this;
            com.business.merchant_payments.payment.model.orderDetail.PayMoneyAmount r0 = r7.getPayMoneyAmount()     // Catch:{ Exception -> 0x006f }
            r1 = 0
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getValue()     // Catch:{ Exception -> 0x006f }
            if (r0 == 0) goto L_0x0016
            double r2 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x006f }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x006f }
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 == 0) goto L_0x0025
            double r2 = r0.doubleValue()     // Catch:{ Exception -> 0x006f }
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r2 = r2 / r4
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x006f }
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            if (r0 == 0) goto L_0x0036
            double r0 = r0.doubleValue()     // Catch:{ Exception -> 0x006f }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "##,##,##,##,###.##"
            java.lang.String r1 = com.business.merchant_payments.common.utility.AppUtility.formatNumber(r0, r1)     // Catch:{ Exception -> 0x006f }
        L_0x0036:
            java.lang.String r0 = r7.getBizType()     // Catch:{ Exception -> 0x006f }
            if (r0 == 0) goto L_0x004c
            java.lang.String r7 = r7.getBizType()     // Catch:{ Exception -> 0x006f }
            java.lang.String r0 = "REFUND"
            r2 = 1
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r2)     // Catch:{ Exception -> 0x006f }
            if (r7 == 0) goto L_0x004c
            java.lang.String r7 = "- "
            goto L_0x004e
        L_0x004c:
            java.lang.String r7 = "  "
        L_0x004e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r0.<init>()     // Catch:{ Exception -> 0x006f }
            r0.append(r7)     // Catch:{ Exception -> 0x006f }
            android.content.Context r7 = r6.mContext     // Catch:{ Exception -> 0x006f }
            int r2 = com.business.merchant_payments.R.string.mp_rupee_symbol     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x006f }
            r0.append(r7)     // Catch:{ Exception -> 0x006f }
            android.content.Context r7 = r6.mContext     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = com.business.merchant_payments.common.utility.AppUtility.getFormattedPrice(r1, r7)     // Catch:{ Exception -> 0x006f }
            r0.append(r7)     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x006f }
            goto L_0x0071
        L_0x006f:
            java.lang.String r7 = "0.00"
        L_0x0071:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.HomePaymentsDataHelper.getFormattedAmountForTransaction(com.business.merchant_payments.payment.model.orderDetail.OrderDetail):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a7 A[SYNTHETIC, Splitter:B:50:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.business.merchant_payments.payment.model.PaymentsTransactionModel getPaymentTransactionModel(com.business.merchant_payments.payment.model.orderDetail.OrderDetail r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.String r1 = r24.getBizType()
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
            java.lang.String r1 = r24.getBizType()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)
            if (r1 == 0) goto L_0x0027
            boolean r1 = r0.hasRefundPermission
            if (r1 != 0) goto L_0x0027
            return r5
        L_0x0027:
            java.lang.String r1 = r24.getBizType()
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = r24.getBizType()
            java.lang.String r6 = "ACQUIRING"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r3)
            if (r1 == 0) goto L_0x003e
            int r1 = r0.mTotalPaymentsReceived
            int r1 = r1 + r3
            r0.mTotalPaymentsReceived = r1
        L_0x003e:
            java.lang.String r1 = r23.getNameFromData(r24)
            java.lang.String r6 = ""
            java.lang.String r7 = "null"
            java.lang.String r12 = kotlin.m.p.a(r1, r7, r6, r2)
            java.lang.String r13 = r23.getFormattedAmountForTransaction(r24)
            java.lang.String r1 = r24.getOrderCreatedTime()
            java.lang.String r11 = r0.getFormattedTime(r1)
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r24.getAdditionalInfo()     // Catch:{ Exception -> 0x0066 }
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
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r6 = r24.getAdditionalInfo()     // Catch:{ Exception -> 0x007c }
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
            java.lang.String r1 = r24.getBizType()     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            java.lang.String r1 = r24.getBizType()     // Catch:{ Exception -> 0x009b }
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r3)     // Catch:{ Exception -> 0x009b }
            if (r1 != 0) goto L_0x0098
        L_0x008e:
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r24.getAdditionalInfo()     // Catch:{ Exception -> 0x009b }
            boolean r1 = r0.isReversalOrVoidTransaction(r1)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x009b
        L_0x0098:
            r19 = 1
            goto L_0x009d
        L_0x009b:
            r19 = 0
        L_0x009d:
            java.lang.String r1 = r24.getOrderStatus()     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r4 = "(this as java.lang.String).toUpperCase(locale)"
            java.lang.String r6 = "Locale.ROOT"
            if (r1 == 0) goto L_0x00be
            java.util.Locale r7 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x00d3 }
            kotlin.g.b.k.b(r7, r6)     // Catch:{ Exception -> 0x00d3 }
            if (r1 == 0) goto L_0x00b6
            java.lang.String r1 = r1.toUpperCase(r7)     // Catch:{ Exception -> 0x00d3 }
            kotlin.g.b.k.b(r1, r4)     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00bf
        L_0x00b6:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r4)     // Catch:{ Exception -> 0x00d3 }
            throw r1     // Catch:{ Exception -> 0x00d3 }
        L_0x00be:
            r1 = r5
        L_0x00bf:
            java.lang.String r7 = "Client_pending"
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x00d3 }
            kotlin.g.b.k.b(r8, r6)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r6 = r7.toUpperCase(r8)     // Catch:{ Exception -> 0x00d3 }
            kotlin.g.b.k.b(r6, r4)     // Catch:{ Exception -> 0x00d3 }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r6)     // Catch:{ Exception -> 0x00d3 }
            r15 = r2
            goto L_0x00d4
        L_0x00d3:
            r15 = 0
        L_0x00d4:
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r24.getAdditionalInfo()
            if (r1 == 0) goto L_0x00df
            java.lang.String r1 = r1.getCancelRequestType()
            goto L_0x00e0
        L_0x00df:
            r1 = r5
        L_0x00e0:
            java.lang.String r2 = "REVERSAL"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            if (r1 != 0) goto L_0x00fe
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r24.getAdditionalInfo()
            if (r1 == 0) goto L_0x00f2
            java.lang.String r5 = r1.getCancelRequestType()
        L_0x00f2:
            java.lang.String r1 = "VOID"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r3)
            if (r1 == 0) goto L_0x00fb
            goto L_0x00fe
        L_0x00fb:
            r2 = r24
            goto L_0x010e
        L_0x00fe:
            com.business.merchant_payments.payment.model.orderDetail.AdditionalInfo r1 = r24.getAdditionalInfo()
            kotlin.g.b.k.a((java.lang.Object) r1)
            java.lang.String r1 = r1.getCancelRequestType()
            r2 = r24
            r2.setBizType(r1)
        L_0x010e:
            com.business.merchant_payments.payment.model.PaymentsTransactionModel r1 = new com.business.merchant_payments.payment.model.PaymentsTransactionModel
            int r9 = r0.mGATransactionNumber
            boolean r4 = r0.backgroundColor
            r18 = 0
            r20 = 0
            r21 = 2048(0x800, float:2.87E-42)
            r22 = 0
            r8 = r1
            r10 = r24
            r17 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            int r2 = r0.mGATransactionNumber
            int r2 = r2 + r3
            r0.mGATransactionNumber = r2
            boolean r2 = r0.mShouldAlternateBackground
            if (r2 == 0) goto L_0x0132
            boolean r2 = r0.backgroundColor
            r2 = r2 ^ r3
            r0.backgroundColor = r2
        L_0x0132:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.HomePaymentsDataHelper.getPaymentTransactionModel(com.business.merchant_payments.payment.model.orderDetail.OrderDetail):com.business.merchant_payments.payment.model.PaymentsTransactionModel");
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
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.HomePaymentsDataHelper.getFormattedAmount(com.business.merchant_payments.model.primary.TotalAmount):java.lang.String");
    }

    public final void setDataFromPrimaryAPI(PrimaryAPIModel primaryAPIModel) {
        int i2;
        DataState dataState;
        k.d(primaryAPIModel, "data");
        String string = this.mContext.getString(R.string.mp_today);
        k.b(string, "mContext.getString(R.string.mp_today)");
        this.mHeaderModel = new PaymentsHeaderModel(string);
        this.mTransactionsList = new ArrayList<>();
        String str = null;
        if (primaryAPIModel.getOrderList() != null) {
            OrderList orderList = primaryAPIModel.getOrderList();
            if ((orderList != null ? orderList.getOrderList() : null) != null) {
                OrderList orderList2 = primaryAPIModel.getOrderList();
                k.a((Object) orderList2);
                List<OrderDetail> orderList3 = orderList2.getOrderList();
                k.a((Object) orderList3);
                this.mTotalTransactions = orderList3.size();
                OrderList orderList4 = primaryAPIModel.getOrderList();
                k.a((Object) orderList4);
                List<OrderDetail> orderList5 = orderList4.getOrderList();
                k.a((Object) orderList5);
                for (OrderDetail paymentTransactionModel : orderList5) {
                    PaymentsTransactionModel paymentTransactionModel2 = getPaymentTransactionModel(paymentTransactionModel);
                    if (paymentTransactionModel2 != null) {
                        ArrayList<Object> arrayList = this.mTransactionsList;
                        if (arrayList == null) {
                            k.a("mTransactionsList");
                        }
                        arrayList.add(paymentTransactionModel2);
                    }
                }
            }
        }
        if (primaryAPIModel.getOrderSummary() != null) {
            try {
                OrderSummary orderSummary = primaryAPIModel.getOrderSummary();
                if (orderSummary != null) {
                    str = orderSummary.getTotalCount();
                }
                k.a((Object) str);
                i2 = Integer.parseInt(str);
            } catch (Exception unused) {
                i2 = 0;
            }
            this.mTotalPayments = i2;
            if (i2 == 0) {
                if (this.mTotalTransactions == 0) {
                    dataState = DataState.EMPTY;
                } else {
                    dataState = DataState.PAYMENTS;
                }
                this.mDataState = dataState;
            } else {
                int i3 = this.mTotalPaymentsReceived;
                if (i3 == i2) {
                    this.mDataState = DataState.PAYMENTS;
                } else if (i3 < i2) {
                    this.mDataState = DataState.PAYMENTS_EXPANDABLE;
                    this.mListState = TransactionListState.INITIAL;
                    setShowMoreModel();
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(this.mContext, "HomePage", "Payments Show More", "", "", "Promo Impression", "");
                }
            }
            String valueOf = String.valueOf(this.mTotalPayments);
            OrderSummary orderSummary2 = primaryAPIModel.getOrderSummary();
            k.a((Object) orderSummary2);
            this.mSummaryModel = new PaymentsSummaryModel(valueOf, (String) null, getFormattedAmount(orderSummary2.getTotalAmount()), false, 2, (g) null);
        }
        this.mVisibleTransactions = this.mTotalTransactions;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getEventPublisher().a(this.mContext, "HomePage", "Payments Widget", "", getTotalVisibleTransactions(), "Promo Impression", "");
    }

    private final void setShowMoreModel() {
        PaymentsShowMoreModel paymentsShowMoreModel = this.mShowMoreModel;
        com.business.common_module.utilities.g gVar = com.business.common_module.utilities.g.f7371a;
        paymentsShowMoreModel.setDate(com.business.common_module.utilities.g.a("dd MMMM"));
        paymentsShowMoreModel.setShowMoreButtonState(new ObservableBoolean(true));
        paymentsShowMoreModel.setShowMoreButtonProgressState(new ObservableBoolean(false));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[Catch:{ Exception -> 0x007b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.Object> getInitialPaymentList() {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.business.merchant_payments.payment.model.PaymentsHeaderModel r1 = r8.mHeaderModel     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x000e
            java.lang.String r2 = "mHeaderModel"
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x007b }
        L_0x000e:
            r0.add(r1)     // Catch:{ Exception -> 0x007b }
            com.business.merchant_payments.payment.HomePaymentsDataHelper$DataState r1 = r8.mDataState     // Catch:{ Exception -> 0x007b }
            com.business.merchant_payments.payment.HomePaymentsDataHelper$DataState r2 = com.business.merchant_payments.payment.HomePaymentsDataHelper.DataState.EMPTY     // Catch:{ Exception -> 0x007b }
            if (r1 != r2) goto L_0x0031
            com.business.merchant_payments.payment.model.PaymentsEmptyModel r1 = new com.business.merchant_payments.payment.model.PaymentsEmptyModel     // Catch:{ Exception -> 0x007b }
            r1.<init>()     // Catch:{ Exception -> 0x007b }
            r0.add(r1)     // Catch:{ Exception -> 0x007b }
            com.business.merchant_payments.gtm.GAGTMTagAnalytics r2 = com.business.merchant_payments.gtm.GAGTMTagAnalytics.getSingleInstance()     // Catch:{ Exception -> 0x007b }
            android.content.Context r3 = r8.mContext     // Catch:{ Exception -> 0x007b }
            java.lang.String r4 = "HomePage"
            java.lang.String r5 = "Payments Widget"
            java.lang.String r6 = ""
            java.lang.String r7 = "No Payments Today"
            r2.sendEvent(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x007b }
            goto L_0x007a
        L_0x0031:
            com.business.merchant_payments.payment.model.PaymentsSummaryModel r1 = r8.mSummaryModel     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x003a
            java.lang.String r2 = "mSummaryModel"
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x007b }
        L_0x003a:
            r0.add(r1)     // Catch:{ Exception -> 0x007b }
            com.business.merchant_payments.payment.HomePaymentsDataHelper$DataState r1 = r8.mDataState     // Catch:{ Exception -> 0x007b }
            com.business.merchant_payments.payment.HomePaymentsDataHelper$DataState r2 = com.business.merchant_payments.payment.HomePaymentsDataHelper.DataState.PAYMENTS_EXPANDABLE     // Catch:{ Exception -> 0x007b }
            java.lang.String r3 = "mTransactionsList"
            if (r1 != r2) goto L_0x0068
            java.util.ArrayList<java.lang.Object> r1 = r8.mTransactionsList     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x004c
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x007b }
        L_0x004c:
            int r1 = r1.size()     // Catch:{ Exception -> 0x007b }
            r2 = 4
            if (r1 < r2) goto L_0x0068
            java.util.ArrayList<java.lang.Object> r1 = r8.mTransactionsList     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x005a
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x007b }
        L_0x005a:
            r3 = 0
            java.util.List r1 = r1.subList(r3, r2)     // Catch:{ Exception -> 0x007b }
            r0.addAll(r1)     // Catch:{ Exception -> 0x007b }
            com.business.merchant_payments.payment.model.PaymentsShowMoreModel r1 = r8.mShowMoreModel     // Catch:{ Exception -> 0x007b }
            r0.add(r1)     // Catch:{ Exception -> 0x007b }
            goto L_0x0072
        L_0x0068:
            java.util.ArrayList<java.lang.Object> r1 = r8.mTransactionsList     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x006f
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x007b }
        L_0x006f:
            r0.addAll(r1)     // Catch:{ Exception -> 0x007b }
        L_0x0072:
            boolean r1 = r8.isMerchantMigrated     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x007a
            com.business.merchant_payments.payment.HomePaymentsDataHelper$TransactionListState r1 = com.business.merchant_payments.payment.HomePaymentsDataHelper.TransactionListState.FINAL     // Catch:{ Exception -> 0x007b }
            r8.mListState = r1     // Catch:{ Exception -> 0x007b }
        L_0x007a:
            return r0
        L_0x007b:
            r0 = move-exception
            com.business.common_module.utilities.LogUtility.printStackTrace(r0)
            java.util.ArrayList r0 = r8.getErrorStateList()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.HomePaymentsDataHelper.getInitialPaymentList():java.util.ArrayList");
    }

    public final ArrayList<Object> getIntermediatePaymentsList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            PaymentsHeaderModel paymentsHeaderModel = this.mHeaderModel;
            if (paymentsHeaderModel == null) {
                k.a("mHeaderModel");
            }
            arrayList.add(paymentsHeaderModel);
            PaymentsSummaryModel paymentsSummaryModel = this.mSummaryModel;
            if (paymentsSummaryModel == null) {
                k.a("mSummaryModel");
            }
            arrayList.add(paymentsSummaryModel);
            ArrayList<Object> arrayList2 = this.mTransactionsList;
            if (arrayList2 == null) {
                k.a("mTransactionsList");
            }
            arrayList.addAll(arrayList2);
            if (this.mTotalPaymentsReceived >= this.mTotalPayments) {
                this.mListState = TransactionListState.FINAL;
            }
            if (!hasMorePayments()) {
                this.mShowMoreModel.getShowMoreButtonState().set(false);
            }
            arrayList.add(this.mShowMoreModel);
            return arrayList;
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return getErrorStateList();
        }
    }

    public final ArrayList<Object> getFinalPaymentList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            PaymentsHeaderModel paymentsHeaderModel = this.mHeaderModel;
            if (paymentsHeaderModel == null) {
                k.a("mHeaderModel");
            }
            arrayList.add(paymentsHeaderModel);
            PaymentsSummaryModel paymentsSummaryModel = this.mSummaryModel;
            if (paymentsSummaryModel == null) {
                k.a("mSummaryModel");
            }
            arrayList.add(paymentsSummaryModel);
            ArrayList<Object> arrayList2 = this.mTransactionsList;
            if (arrayList2 == null) {
                k.a("mTransactionsList");
            }
            arrayList.addAll(arrayList2);
            arrayList.add(this.mShowMoreModel);
            return arrayList;
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return getErrorStateList();
        }
    }

    public final ArrayList<Object> getLoadingStateList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new PaymentsLoaderModel());
        return arrayList;
    }

    public final ArrayList<Object> getErrorStateList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM", Locale.US);
            Calendar instance = Calendar.getInstance();
            k.b(instance, "Calendar.getInstance()");
            String format = simpleDateFormat.format(instance.getTime());
            k.b(format, "SimpleDateFormat(\"dd MMM…endar.getInstance().time)");
            PaymentsHeaderModel paymentsHeaderModel = new PaymentsHeaderModel(format);
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            PaymentsSummaryModel paymentsSummaryModel = new PaymentsSummaryModel("--", "--", "--", !instance2.getMerchantDataProvider().i());
            arrayList.add(paymentsHeaderModel);
            arrayList.add(paymentsSummaryModel);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
        return arrayList;
    }

    public final ArrayList<Object> addMoreTransactions(ArrayList<OrderDetail> arrayList) {
        k.d(arrayList, "orderList");
        ArrayList<Object> arrayList2 = new ArrayList<>();
        if (this.mListState == TransactionListState.INITIAL) {
            this.mListState = TransactionListState.INTERMEDIATE;
            if (arrayList.size() < 4) {
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
                this.mTotalTransactions++;
                ArrayList<Object> arrayList3 = this.mTransactionsList;
                if (arrayList3 == null) {
                    k.a("mTransactionsList");
                }
                arrayList3.add(paymentTransactionModel);
            }
        }
        this.mListState = TransactionListState.INTERMEDIATE;
        if (this.mTotalPaymentsReceived >= this.mTotalPayments) {
            this.mListState = TransactionListState.FINAL;
        }
        return arrayList2;
    }

    public final PaymentsShowMoreModel getShowMoreModel() {
        return this.mShowMoreModel;
    }

    public final boolean hasMorePayments() {
        TransactionListState transactionListState = this.mListState;
        return (transactionListState == TransactionListState.FINAL || transactionListState == TransactionListState.NOT_INITIALIZED) ? false : true;
    }

    public final int getPageForAPI() {
        int i2 = this.mPageForAPI;
        this.mPageForAPI = i2 + 1;
        return i2;
    }

    public final String getTotalVisibleTransactions() {
        return String.valueOf(this.mVisibleTransactions);
    }

    public final void setDataFromNonMigratedPaymentsAPI(NonMigratedPaymentsModel nonMigratedPaymentsModel) {
        int i2;
        k.d(nonMigratedPaymentsModel, "data");
        String string = this.mContext.getString(R.string.mp_today);
        k.b(string, "mContext.getString(R.string.mp_today)");
        this.mHeaderModel = new PaymentsHeaderModel(string);
        this.mTransactionsList = new ArrayList<>();
        if (nonMigratedPaymentsModel.getOrderList() != null) {
            OrderList orderList = nonMigratedPaymentsModel.getOrderList();
            k.a((Object) orderList);
            if (orderList.getOrderList() != null) {
                OrderList orderList2 = nonMigratedPaymentsModel.getOrderList();
                k.a((Object) orderList2);
                List<OrderDetail> orderList3 = orderList2.getOrderList();
                k.a((Object) orderList3);
                this.mTotalTransactions = orderList3.size();
                OrderList orderList4 = nonMigratedPaymentsModel.getOrderList();
                k.a((Object) orderList4);
                List<OrderDetail> orderList5 = orderList4.getOrderList();
                k.a((Object) orderList5);
                for (OrderDetail paymentTransactionModel : orderList5) {
                    PaymentsTransactionModel paymentTransactionModel2 = getPaymentTransactionModel(paymentTransactionModel);
                    if (paymentTransactionModel2 != null) {
                        ArrayList<Object> arrayList = this.mTransactionsList;
                        if (arrayList == null) {
                            k.a("mTransactionsList");
                        }
                        arrayList.add(paymentTransactionModel2);
                    }
                }
            }
        }
        if (nonMigratedPaymentsModel.getOrderSummary() != null) {
            try {
                OrderSummary orderSummary = nonMigratedPaymentsModel.getOrderSummary();
                String totalCount = orderSummary != null ? orderSummary.getTotalCount() : null;
                k.a((Object) totalCount);
                i2 = Integer.parseInt(totalCount);
            } catch (Exception unused) {
                i2 = 0;
            }
            this.mTotalPayments = i2;
            int i3 = this.mTotalTransactions;
            if (i3 == 0) {
                this.mDataState = DataState.EMPTY;
            } else if (i3 < 4) {
                this.mDataState = DataState.PAYMENTS;
            } else {
                this.mDataState = DataState.PAYMENTS_EXPANDABLE;
                setShowMoreModel();
                this.mListState = TransactionListState.INITIAL;
                GAGTMTagAnalytics.getSingleInstance().sendEvent(this.mContext, "HomePage", "Payments Show More", "", "", "Promo Impression", "");
            }
            String valueOf = String.valueOf(this.mTotalPayments);
            OrderSummary orderSummary2 = nonMigratedPaymentsModel.getOrderSummary();
            k.a((Object) orderSummary2);
            this.mSummaryModel = new PaymentsSummaryModel(valueOf, (String) null, getFormattedAmount(orderSummary2.getTotalAmount()), true, 2, (g) null);
        }
        this.mVisibleTransactions = this.mTotalTransactions;
    }
}
