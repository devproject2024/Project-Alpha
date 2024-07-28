package com.business.merchant_payments.settlement.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.method.TransformationMethod;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.databinding.MpPaymentInfoTileBinding;
import com.business.merchant_payments.newhome.HomeRVListener;
import com.business.merchant_payments.settlement.model.LabelModel;
import com.business.merchant_payments.settlement.model.PreviouslyFailedBalanceData;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;

public final class LabelPopulationHelperMP {
    public static final String ALREADY_SETTLED_TO_BANK = "alreadySettledToBank";
    public static final String ALREADY_TRANSFERRED_TO_BANK = "alreadyTransferredToBank";
    public static final String AMOUNT_ON_HOLD = "amountOnHold";
    public static final String AMOUNT_ON_HOLD_FOR_CHANNELS = "amountOnHoldForChannels";
    public static final String AMOUNT_ON_HOLD_FOR_EDC = "amountOnHoldForEDC";
    public static final String AMOUNT_ON_HOLD_FOR_LOAN = "amountOnHoldForLoan";
    public static final String AMOUNT_ON_HOLD_FOR_SOUND_BOX = "amountOnHoldForSoundBox";
    public static final String BALANCE_FROM_FAILED_SETTLEMENT = "balanceFromFailedSettlement";
    public static final String BUSINESS_WALLET_BALANCE = "businessWalletBalance";
    public static final String CANCEL_AMOUNT = "cancelAmount";
    public static final String CANCEL_COMMISSION = "cancelCommission";
    public static final String CANCEL_TAX = "cancelTax";
    public static final String CARRY_FORWARD = "carryForward";
    public static final String CARRY_FORWARD_BALANCE = "carryForwardBalance";
    public static final String CHANNELS = "channels";
    public static final String CHARGE_BACK = "chargeBack";
    public static final String DIRECTLY_SETTLE_BY_BANK = "directlySettleByBank";
    public static final String DIRECTLY_SETTLE_BY_BANK_REFUND = "directlySettleByBankRefund";
    public static final String EDC_SUBSCRIPTION = "EDCSubscription";
    public static final String FAILED_SETTLEMENT = "failedSettlement";
    public static final LabelPopulationHelperMP INSTANCE = new LabelPopulationHelperMP();
    public static final String MDR_CHANGES = "MDRCharges";
    public static final String PENDING_AMOUNT = "pendingAmount";
    public static final String PENDING_M2B_SUM = "pendingMtoBSum";
    public static final String PREVIOUS_DAY_BALANCE = "previousDayBalance";
    public static final String REFUND = "refund";
    public static final String REFUNDS = "refunds";
    public static final String SOUND_BOX_SUBSCRIPTION = "soundBoxSubscription";
    public static final String TOTAL_COLLECTION = "totalCollection";
    public static final String TOTAL_COLLECTION_TODAY = "totalCollectionToday";
    public static final String TOTAL_REFUNDS = "totalRefunds";
    public static LinkedHashMap<String, String> holdAmountMap = new LinkedHashMap<>();
    public static final HashMap<String, String> mKeySignMap = new HashMap<>();
    public static String settlementTime;

    public final String parseAndGetAmountString(String str) {
        return parseAndGetAmountString$default(this, str, false, 2, (Object) null);
    }

    static {
        mKeySignMap.put(TOTAL_COLLECTION_TODAY, "+");
        mKeySignMap.put(TOTAL_COLLECTION, "+");
        mKeySignMap.put(PREVIOUS_DAY_BALANCE, "+");
        mKeySignMap.put(MDR_CHANGES, "-");
        mKeySignMap.put(REFUNDS, "-");
        mKeySignMap.put(CHARGE_BACK, "-");
        mKeySignMap.put(CARRY_FORWARD, "-");
        mKeySignMap.put(EDC_SUBSCRIPTION, "-");
        mKeySignMap.put(SOUND_BOX_SUBSCRIPTION, "-");
        mKeySignMap.put("channels", "-");
        mKeySignMap.put(AMOUNT_ON_HOLD_FOR_EDC, "-");
        mKeySignMap.put(AMOUNT_ON_HOLD_FOR_SOUND_BOX, "-");
        mKeySignMap.put(AMOUNT_ON_HOLD_FOR_CHANNELS, "-");
        mKeySignMap.put(TOTAL_REFUNDS, "-");
        mKeySignMap.put(ALREADY_TRANSFERRED_TO_BANK, "-");
        mKeySignMap.put(BUSINESS_WALLET_BALANCE, "-");
        mKeySignMap.put(CARRY_FORWARD_BALANCE, "-");
        mKeySignMap.put(PENDING_AMOUNT, "-");
        mKeySignMap.put(FAILED_SETTLEMENT, "-");
        mKeySignMap.put("refund", "-");
        mKeySignMap.put(ALREADY_SETTLED_TO_BANK, "-");
        mKeySignMap.put(BALANCE_FROM_FAILED_SETTLEMENT, "+");
        mKeySignMap.put(CANCEL_AMOUNT, "-");
        mKeySignMap.put(CANCEL_TAX, "+");
        mKeySignMap.put(CANCEL_COMMISSION, "+");
        mKeySignMap.put(AMOUNT_ON_HOLD, "-");
        mKeySignMap.put(AMOUNT_ON_HOLD_FOR_LOAN, "-");
        mKeySignMap.put(DIRECTLY_SETTLE_BY_BANK, "-");
        mKeySignMap.put(DIRECTLY_SETTLE_BY_BANK_REFUND, "+");
    }

    public final boolean isKeyAleadySettledToBank(String str) {
        return k.a((Object) str, (Object) ALREADY_SETTLED_TO_BANK);
    }

    public final boolean isKeyPendingM2BSum(String str) {
        return k.a((Object) str, (Object) PENDING_M2B_SUM);
    }

    public final String getAmountUsingKey(String str, String str2, boolean z) {
        if ((str == null || p.a(str)) || !mKeySignMap.containsKey(str) || !k.a((Object) mKeySignMap.get(str), (Object) "-") || z) {
            return parseAndGetAmountString$default(this, str2, false, 2, (Object) null);
        }
        return parseAndGetAmountString$default(this, "-".concat(String.valueOf(str2)), false, 2, (Object) null);
    }

    public static /* synthetic */ String parseAndGetAmountString$default(LabelPopulationHelperMP labelPopulationHelperMP, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return labelPopulationHelperMP.parseAndGetAmountString(str, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x000d A[Catch:{ Exception -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0016 A[Catch:{ Exception -> 0x001f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String parseAndGetAmountString(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x000a
            boolean r0 = kotlin.m.p.a(r2)     // Catch:{ Exception -> 0x001f }
            if (r0 != 0) goto L_0x000a
            r0 = 0
            goto L_0x000b
        L_0x000a:
            r0 = 1
        L_0x000b:
            if (r0 != 0) goto L_0x0016
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x001f }
            java.lang.String r2 = r1.amountString((double) r2)     // Catch:{ Exception -> 0x001f }
            return r2
        L_0x0016:
            if (r3 == 0) goto L_0x001f
            r2 = 0
            java.lang.String r2 = r1.amountString((double) r2)     // Catch:{ Exception -> 0x001f }
            return r2
        L_0x001f:
            java.lang.String r2 = "--"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.parseAndGetAmountString(java.lang.String, boolean):java.lang.String");
    }

    public static /* synthetic */ String getAmountWithDecimals$default(LabelPopulationHelperMP labelPopulationHelperMP, double d2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 2;
        }
        return labelPopulationHelperMP.getAmountWithDecimals(d2, i2);
    }

    public final String getAmountWithDecimals(double d2, int i2) {
        String format = String.format("%." + i2 + 'f', Arrays.copyOf(new Object[]{Double.valueOf(d2)}, 1));
        k.b(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final String amountString(double d2) {
        double d3 = d2 / 100.0d;
        if (d2 >= 0.0d) {
            return amountString(getAmountWithDecimals$default(this, d3, 0, 2, (Object) null));
        }
        return "- " + amountString(getAmountWithDecimals$default(this, -d3, 0, 2, (Object) null));
    }

    public final String amountStringWithoutRupeSign(double d2) {
        return getAmountWithDecimals$default(this, d2 / 100.0d, 0, 2, (Object) null);
    }

    private final String amountString(String str) {
        StringBuilder sb = new StringBuilder();
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        sb.append(instance.getAppContext().getString(R.string.mp_rupee_symbol));
        sb.append(' ');
        sb.append(str);
        String sb2 = sb.toString();
        k.b(sb2, "StringBuilder()\n        …)\n            .toString()");
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isAmountNonZero(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x000c
            boolean r2 = kotlin.m.p.a(r7)     // Catch:{ Exception -> 0x001a }
            if (r2 != 0) goto L_0x000c
            r2 = 0
            goto L_0x000d
        L_0x000c:
            r2 = 1
        L_0x000d:
            if (r2 != 0) goto L_0x001a
            double r2 = java.lang.Double.parseDouble(r7)     // Catch:{ Exception -> 0x001a }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x001a
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.isAmountNonZero(java.lang.String):boolean");
    }

    public final String getLocalisedString(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2084036350:
                    if (str.equals(TOTAL_COLLECTION)) {
                        PaymentsConfig instance = PaymentsConfig.getInstance();
                        k.b(instance, "PaymentsConfig.getInstance()");
                        String string = instance.getAppContext().getString(R.string.mp_label_val_total_collection);
                        k.b(string, "PaymentsConfig.getInstan…bel_val_total_collection)");
                        return string;
                    }
                    break;
                case -2035374152:
                    if (str.equals(ALREADY_SETTLED_TO_BANK)) {
                        PaymentsConfig instance2 = PaymentsConfig.getInstance();
                        k.b(instance2, "PaymentsConfig.getInstance()");
                        String string2 = instance2.getAppContext().getString(R.string.mp_label_val_already_settled_to_bank);
                        k.b(string2, "PaymentsConfig.getInstan…_already_settled_to_bank)");
                        return string2;
                    }
                    break;
                case -2016223958:
                    if (str.equals(CARRY_FORWARD)) {
                        PaymentsConfig instance3 = PaymentsConfig.getInstance();
                        k.b(instance3, "PaymentsConfig.getInstance()");
                        String string3 = instance3.getAppContext().getString(R.string.mp_label_val_carry_forward);
                        k.b(string3, "PaymentsConfig.getInstan…_label_val_carry_forward)");
                        return string3;
                    }
                    break;
                case -1346088379:
                    if (str.equals(ALREADY_TRANSFERRED_TO_BANK)) {
                        PaymentsConfig instance4 = PaymentsConfig.getInstance();
                        k.b(instance4, "PaymentsConfig.getInstance()");
                        String string4 = instance4.getAppContext().getString(R.string.mp_label_val_already_transferred_to_bank);
                        k.b(string4, "PaymentsConfig.getInstan…eady_transferred_to_bank)");
                        return string4;
                    }
                    break;
                case -1314214364:
                    if (str.equals(MDR_CHANGES)) {
                        PaymentsConfig instance5 = PaymentsConfig.getInstance();
                        k.b(instance5, "PaymentsConfig.getInstance()");
                        String string5 = instance5.getAppContext().getString(R.string.mp_label_val_mdr_charges);
                        k.b(string5, "PaymentsConfig.getInstan…mp_label_val_mdr_charges)");
                        return string5;
                    }
                    break;
                case -1236234557:
                    if (str.equals(AMOUNT_ON_HOLD_FOR_LOAN)) {
                        PaymentsConfig instance6 = PaymentsConfig.getInstance();
                        k.b(instance6, "PaymentsConfig.getInstance()");
                        String string6 = instance6.getAppContext().getString(R.string.mp_label_amount_on_hold_for_loan);
                        k.b(string6, "PaymentsConfig.getInstan…_amount_on_hold_for_loan)");
                        return string6;
                    }
                    break;
                case -1048997183:
                    if (str.equals(EDC_SUBSCRIPTION)) {
                        PaymentsConfig instance7 = PaymentsConfig.getInstance();
                        k.b(instance7, "PaymentsConfig.getInstance()");
                        String string7 = instance7.getAppContext().getString(R.string.mp_label_val_edc_subscription);
                        k.b(string7, "PaymentsConfig.getInstan…bel_val_edc_subscription)");
                        return string7;
                    }
                    break;
                case -934813832:
                    if (str.equals("refund")) {
                        PaymentsConfig instance8 = PaymentsConfig.getInstance();
                        k.b(instance8, "PaymentsConfig.getInstance()");
                        String string8 = instance8.getAppContext().getString(R.string.mp_label_val_refund);
                        k.b(string8, "PaymentsConfig.getInstan…ring.mp_label_val_refund)");
                        return string8;
                    }
                    break;
                case -867199156:
                    if (str.equals(DIRECTLY_SETTLE_BY_BANK_REFUND)) {
                        PaymentsConfig instance9 = PaymentsConfig.getInstance();
                        k.b(instance9, "PaymentsConfig.getInstance()");
                        String string9 = instance9.getAppContext().getString(R.string.mp_label_direct_refund_adjustment);
                        k.b(string9, "PaymentsConfig.getInstan…direct_refund_adjustment)");
                        return string9;
                    }
                    break;
                case -787297245:
                    if (str.equals(AMOUNT_ON_HOLD_FOR_CHANNELS)) {
                        PaymentsConfig instance10 = PaymentsConfig.getInstance();
                        k.b(instance10, "PaymentsConfig.getInstance()");
                        String string10 = instance10.getAppContext().getString(R.string.mp_label_val_amount_on_hold_for_channels);
                        k.b(string10, "PaymentsConfig.getInstan…unt_on_hold_for_channels)");
                        return string10;
                    }
                    break;
                case -595549831:
                    if (str.equals(SOUND_BOX_SUBSCRIPTION)) {
                        PaymentsConfig instance11 = PaymentsConfig.getInstance();
                        k.b(instance11, "PaymentsConfig.getInstance()");
                        String string11 = instance11.getAppContext().getString(R.string.mp_label_val_sound_box_subscription);
                        k.b(string11, "PaymentsConfig.getInstan…l_sound_box_subscription)");
                        return string11;
                    }
                    break;
                case -584806074:
                    if (str.equals(FAILED_SETTLEMENT)) {
                        PaymentsConfig instance12 = PaymentsConfig.getInstance();
                        k.b(instance12, "PaymentsConfig.getInstance()");
                        String string12 = instance12.getAppContext().getString(R.string.mp_label_val_failed_settlement);
                        k.b(string12, "PaymentsConfig.getInstan…el_val_failed_settlement)");
                        return string12;
                    }
                    break;
                case -477292913:
                    if (str.equals(AMOUNT_ON_HOLD_FOR_SOUND_BOX)) {
                        PaymentsConfig instance13 = PaymentsConfig.getInstance();
                        k.b(instance13, "PaymentsConfig.getInstance()");
                        String string13 = instance13.getAppContext().getString(R.string.mp_label_val_amount_on_hold_for_soundBox);
                        k.b(string13, "PaymentsConfig.getInstan…unt_on_hold_for_soundBox)");
                        return string13;
                    }
                    break;
                case -419954493:
                    if (str.equals(BUSINESS_WALLET_BALANCE)) {
                        PaymentsConfig instance14 = PaymentsConfig.getInstance();
                        k.b(instance14, "PaymentsConfig.getInstance()");
                        String string14 = instance14.getAppContext().getString(R.string.mp_label_val_business_wallet_balance);
                        k.b(string14, "PaymentsConfig.getInstan…_business_wallet_balance)");
                        return string14;
                    }
                    break;
                case -245244065:
                    if (str.equals(TOTAL_COLLECTION_TODAY)) {
                        PaymentsConfig instance15 = PaymentsConfig.getInstance();
                        k.b(instance15, "PaymentsConfig.getInstance()");
                        String string15 = instance15.getAppContext().getString(R.string.mp_label_val_total_collection_today);
                        k.b(string15, "PaymentsConfig.getInstan…l_total_collection_today)");
                        return string15;
                    }
                    break;
                case -101582641:
                    if (str.equals(PENDING_AMOUNT)) {
                        PaymentsConfig instance16 = PaymentsConfig.getInstance();
                        k.b(instance16, "PaymentsConfig.getInstance()");
                        String string16 = instance16.getAppContext().getString(R.string.mp_label_val_pending_amount);
                        k.b(string16, "PaymentsConfig.getInstan…label_val_pending_amount)");
                        return string16;
                    }
                    break;
                case 476565201:
                    if (str.equals(CANCEL_TAX)) {
                        PaymentsConfig instance17 = PaymentsConfig.getInstance();
                        k.b(instance17, "PaymentsConfig.getInstance()");
                        String string17 = instance17.getAppContext().getString(R.string.mp_label_cancel_tax);
                        k.b(string17, "PaymentsConfig.getInstan…ring.mp_label_cancel_tax)");
                        return string17;
                    }
                    break;
                case 513357573:
                    if (str.equals(CANCEL_COMMISSION)) {
                        PaymentsConfig instance18 = PaymentsConfig.getInstance();
                        k.b(instance18, "PaymentsConfig.getInstance()");
                        String string18 = instance18.getAppContext().getString(R.string.mp_label_cancel_commission);
                        k.b(string18, "PaymentsConfig.getInstan…_label_cancel_commission)");
                        return string18;
                    }
                    break;
                case 631039570:
                    if (str.equals(CARRY_FORWARD_BALANCE)) {
                        PaymentsConfig instance19 = PaymentsConfig.getInstance();
                        k.b(instance19, "PaymentsConfig.getInstance()");
                        String string19 = instance19.getAppContext().getString(R.string.mp_label_val_balance_amount);
                        k.b(string19, "PaymentsConfig.getInstan…label_val_balance_amount)");
                        return string19;
                    }
                    break;
                case 652347830:
                    if (str.equals(AMOUNT_ON_HOLD)) {
                        PaymentsConfig instance20 = PaymentsConfig.getInstance();
                        k.b(instance20, "PaymentsConfig.getInstance()");
                        String string20 = instance20.getAppContext().getString(R.string.mp_label_amount_on_hold);
                        k.b(string20, "PaymentsConfig.getInstan….mp_label_amount_on_hold)");
                        return string20;
                    }
                    break;
                case 652850033:
                    if (str.equals(AMOUNT_ON_HOLD_FOR_EDC)) {
                        PaymentsConfig instance21 = PaymentsConfig.getInstance();
                        k.b(instance21, "PaymentsConfig.getInstance()");
                        String string21 = instance21.getAppContext().getString(R.string.mp_label_val_amount_on_hold_for_EDC);
                        k.b(string21, "PaymentsConfig.getInstan…l_amount_on_hold_for_EDC)");
                        return string21;
                    }
                    break;
                case 1085542395:
                    if (str.equals(REFUNDS)) {
                        PaymentsConfig instance22 = PaymentsConfig.getInstance();
                        k.b(instance22, "PaymentsConfig.getInstance()");
                        String string22 = instance22.getAppContext().getString(R.string.mp_label_val_refunds);
                        k.b(string22, "PaymentsConfig.getInstan…ing.mp_label_val_refunds)");
                        return string22;
                    }
                    break;
                case 1153108471:
                    if (str.equals(PREVIOUS_DAY_BALANCE)) {
                        PaymentsConfig instance23 = PaymentsConfig.getInstance();
                        k.b(instance23, "PaymentsConfig.getInstance()");
                        String string23 = instance23.getAppContext().getString(R.string.mp_label_val_previous_day_balance);
                        k.b(string23, "PaymentsConfig.getInstan…val_previous_day_balance)");
                        return string23;
                    }
                    break;
                case 1417552315:
                    if (str.equals(CHARGE_BACK)) {
                        PaymentsConfig instance24 = PaymentsConfig.getInstance();
                        k.b(instance24, "PaymentsConfig.getInstance()");
                        String string24 = instance24.getAppContext().getString(R.string.mp_label_val_charge_back);
                        k.b(string24, "PaymentsConfig.getInstan…mp_label_val_charge_back)");
                        return string24;
                    }
                    break;
                case 1432626128:
                    if (str.equals("channels")) {
                        PaymentsConfig instance25 = PaymentsConfig.getInstance();
                        k.b(instance25, "PaymentsConfig.getInstance()");
                        String string25 = instance25.getAppContext().getString(R.string.mp_label_val_channels);
                        k.b(string25, "PaymentsConfig.getInstan…ng.mp_label_val_channels)");
                        return string25;
                    }
                    break;
                case 1640585239:
                    if (str.equals(TOTAL_REFUNDS)) {
                        PaymentsConfig instance26 = PaymentsConfig.getInstance();
                        k.b(instance26, "PaymentsConfig.getInstance()");
                        String string26 = instance26.getAppContext().getString(R.string.mp_label_val_total_refunds);
                        k.b(string26, "PaymentsConfig.getInstan…_label_val_total_refunds)");
                        return string26;
                    }
                    break;
                case 1891803828:
                    if (str.equals(DIRECTLY_SETTLE_BY_BANK)) {
                        PaymentsConfig instance27 = PaymentsConfig.getInstance();
                        k.b(instance27, "PaymentsConfig.getInstance()");
                        String string27 = instance27.getAppContext().getString(R.string.mp_label_directly_settle_by_bank);
                        k.b(string27, "PaymentsConfig.getInstan…_directly_settle_by_bank)");
                        return string27;
                    }
                    break;
                case 1953965938:
                    if (str.equals(CANCEL_AMOUNT)) {
                        PaymentsConfig instance28 = PaymentsConfig.getInstance();
                        k.b(instance28, "PaymentsConfig.getInstance()");
                        String string28 = instance28.getAppContext().getString(R.string.mp_label_cancel_amount);
                        k.b(string28, "PaymentsConfig.getInstan…g.mp_label_cancel_amount)");
                        return string28;
                    }
                    break;
            }
        }
        return str == null || p.a(str) ? "" : str;
    }

    public final boolean populateLabelsInEmptyContainer(Context context, LinearLayout linearLayout, ArrayList<LabelModel> arrayList, int i2, HomeRVListener homeRVListener) {
        LinearLayout linearLayout2 = linearLayout;
        ArrayList<LabelModel> arrayList2 = arrayList;
        Context context2 = context;
        k.d(context, "context");
        k.d(linearLayout2, Item.KEY_LAYOUT);
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (i3 < linearLayout.getChildCount()) {
            View childAt = linearLayout2.getChildAt(i3);
            if (arrayList2 == null || i4 >= arrayList.size()) {
                k.b(childAt, "child");
                childAt.setVisibility(8);
            } else if (!isAmountNonZero(arrayList2.get(i4).getValue())) {
                i4++;
            } else {
                k.b(childAt, "child");
                LabelModel labelModel = arrayList2.get(i4);
                k.b(labelModel, "labelList[j]");
                populateLabelData(childAt, labelModel, i2, context, homeRVListener);
                i4++;
                z = true;
            }
            i3++;
        }
        while (arrayList2 != null && i4 < arrayList.size()) {
            if (isAmountNonZero(arrayList2.get(i4).getValue())) {
                MpPaymentInfoTileBinding inflate = MpPaymentInfoTileBinding.inflate(LayoutInflater.from(context));
                k.b(inflate, "MpPaymentInfoTileBinding…utInflater.from(context))");
                linearLayout2.addView(inflate.getRoot());
                View root = inflate.getRoot();
                k.b(root, "childBinding.root");
                LabelModel labelModel2 = arrayList2.get(i4);
                k.b(labelModel2, "labelList[j]");
                populateLabelData(root, labelModel2, i2, context, homeRVListener);
                z = true;
            }
            i4++;
        }
        return z;
    }

    public final boolean populateAmountDetailLabels(Context context, LinearLayout linearLayout, ArrayList<LabelModel> arrayList, int i2, int i3, int i4, HomeRVListener homeRVListener) {
        LinearLayout linearLayout2 = linearLayout;
        ArrayList<LabelModel> arrayList2 = arrayList;
        k.d(context, "context");
        k.d(linearLayout2, Item.KEY_LAYOUT);
        boolean z = false;
        int i5 = i2;
        int i6 = 0;
        while (true) {
            View childAt = linearLayout2.getChildAt(i5);
            k.b(childAt, "layout.getChildAt(i)");
            if (childAt.getId() == i3) {
                break;
            }
            View childAt2 = linearLayout2.getChildAt(i5);
            if (arrayList2 == null || i6 >= arrayList.size()) {
                k.b(childAt2, "child");
                childAt2.setVisibility(8);
            } else if (!isAmountNonZero(arrayList2.get(i6).getValue())) {
                i6++;
            } else {
                k.b(childAt2, "child");
                LabelModel labelModel = arrayList2.get(i6);
                k.b(labelModel, "labelList[j]");
                populateLabelData(childAt2, labelModel, i4, context, homeRVListener);
                i6++;
                z = true;
            }
            i5++;
        }
        while (arrayList2 != null && i6 < arrayList.size()) {
            if (isAmountNonZero(arrayList2.get(i6).getValue())) {
                MpPaymentInfoTileBinding inflate = MpPaymentInfoTileBinding.inflate(LayoutInflater.from(context));
                k.b(inflate, "MpPaymentInfoTileBinding…utInflater.from(context))");
                linearLayout2.addView(inflate.getRoot(), i5);
                View root = inflate.getRoot();
                k.b(root, "childBinding.root");
                LabelModel labelModel2 = arrayList2.get(i6);
                k.b(labelModel2, "labelList[j]");
                populateLabelData(root, labelModel2, i4, context, homeRVListener);
                i5++;
                z = true;
            }
            i6++;
        }
        return z;
    }

    private final void populateLabelData(View view, LabelModel labelModel, int i2, Context context, HomeRVListener homeRVListener) {
        view.setVisibility(0);
        checkForCarryForwardAndFillKeyValues(context, homeRVListener, view, labelModel, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(i2);
            layoutParams2.setMarginEnd(i2);
            view.setLayoutParams(layoutParams);
        }
    }

    public final void populateLabelSummaryData(View view, LabelModel labelModel, Context context, HomeRVListener homeRVListener) {
        k.d(view, "root");
        k.d(labelModel, "labelData");
        k.d(context, "context");
        view.setVisibility(0);
        checkForCarryForwardAndFillKeyValuesFromSummary(context, homeRVListener, view, labelModel);
    }

    private final void checkForCarryForwardAndFillKeyValuesFromSummary(Context context, HomeRVListener homeRVListener, View view, LabelModel labelModel) {
        TextView textView = (TextView) view.findViewById(R.id.payment_info_tile_lbl);
        String key = labelModel.getKey();
        if (key != null && key.hashCode() == -1314214364 && key.equals(MDR_CHANGES)) {
            k.b(textView, "paymentText");
            addInfoIcon(labelModel, context, textView);
            textView.setOnClickListener(new LabelPopulationHelperMP$checkForCarryForwardAndFillKeyValuesFromSummary$1(homeRVListener));
        } else if (textView != null) {
            textView.setText(getLocalisedString(labelModel.getKey()));
        }
        TextView textView2 = (TextView) view.findViewById(R.id.payment_info_tile_val);
        if (textView2 != null) {
            textView2.setText(getAmountUsingKey(labelModel.getKey(), labelModel.getValue(), false));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkForCarryForwardAndFillKeyValues(android.content.Context r10, com.business.merchant_payments.newhome.HomeRVListener r11, android.view.View r12, com.business.merchant_payments.settlement.model.LabelModel r13, boolean r14) {
        /*
            r9 = this;
            int r14 = com.business.merchant_payments.R.id.payment_info_tile_lbl
            android.view.View r14 = r12.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r0 = com.business.merchant_payments.R.id.payment_info_subtext_lbl
            android.view.View r0 = r12.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r13.getKey()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0023
            java.lang.String r4 = "amountOnHold"
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r4, (boolean) r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0024
        L_0x0023:
            r1 = r2
        L_0x0024:
            kotlin.g.b.k.a((java.lang.Object) r1)
            boolean r1 = r1.booleanValue()
            r4 = 2
            if (r1 == 0) goto L_0x004f
            java.lang.String r10 = r13.getValue()
            if (r10 == 0) goto L_0x0049
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r11 = holdAmountMap
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r14 = INSTANCE
            java.lang.String r13 = r13.getKey()
            java.lang.String r13 = r14.getLocalisedString(r13)
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r14 = INSTANCE
            java.lang.String r10 = parseAndGetAmountString$default(r14, r10, r3, r4, r2)
            r11.put(r13, r10)
        L_0x0049:
            r10 = 8
            r12.setVisibility(r10)
            return
        L_0x004f:
            java.lang.String r1 = r13.getKey()
            if (r1 == 0) goto L_0x00f6
            int r5 = r1.hashCode()
            r6 = -1314214364(0xffffffffb1aaae24, float:-4.9674487E-9)
            java.lang.String r7 = "paymentText"
            if (r5 == r6) goto L_0x00df
            r6 = 631039570(0x259ce652, float:2.7217757E-16)
            if (r5 != r6) goto L_0x00f6
            java.lang.String r5 = "carryForwardBalance"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00f6
            java.lang.String r1 = r13.getValue()
            if (r1 == 0) goto L_0x0088
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r5 = holdAmountMap
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r6 = INSTANCE
            java.lang.String r8 = r13.getKey()
            java.lang.String r6 = r6.getLocalisedString(r8)
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP r8 = INSTANCE
            java.lang.String r1 = parseAndGetAmountString$default(r8, r1, r3, r4, r2)
            r5.put(r6, r1)
        L_0x0088:
            kotlin.g.b.k.b(r14, r7)
            r9.addInfoIcon(r13, r10, r14)
            if (r0 == 0) goto L_0x0093
            r0.setVisibility(r3)
        L_0x0093:
            if (r0 == 0) goto L_0x00d6
            int r1 = com.business.merchant_payments.R.string.mp_to_be_settled_text
            java.lang.String r10 = r10.getString(r1)
            java.lang.String r1 = "context.getString(R.string.mp_to_be_settled_text)"
            kotlin.g.b.k.b(r10, r1)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r2 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r2 = r2.getMInstance()
            java.lang.String r5 = "carry_fwd_time"
            java.lang.String r6 = "7 A.M"
            java.lang.String r2 = r2.getString(r5, r6)
            r1[r3] = r2
            java.lang.String r2 = settlementTime
            java.lang.String r5 = "GMT+5:30"
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r5)
            r6 = 1
            java.lang.String r7 = "yyyy-MM-dd'T'HH:mm:ssZZZZZ"
            java.lang.String r8 = "dd MMM"
            java.lang.String r2 = com.business.merchant_payments.common.utility.DateUtility.getDateAfter(r2, r7, r6, r8, r5)
            r1[r6] = r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r4)
            java.lang.String r10 = java.lang.String.format(r10, r1)
            java.lang.String r1 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.b(r10, r1)
            r0.setText(r10)
        L_0x00d6:
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP$checkForCarryForwardAndFillKeyValues$3 r10 = new com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP$checkForCarryForwardAndFillKeyValues$3
            r10.<init>(r11)
            r14.setOnClickListener(r10)
            goto L_0x0103
        L_0x00df:
            java.lang.String r0 = "MDRCharges"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00f6
            kotlin.g.b.k.b(r14, r7)
            r9.addInfoIcon(r13, r10, r14)
            com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP$checkForCarryForwardAndFillKeyValues$4 r10 = new com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP$checkForCarryForwardAndFillKeyValues$4
            r10.<init>(r11)
            r14.setOnClickListener(r10)
            goto L_0x0103
        L_0x00f6:
            if (r14 == 0) goto L_0x0103
            java.lang.String r10 = r13.getKey()
            java.lang.String r10 = r9.getLocalisedString(r10)
            r14.setText(r10)
        L_0x0103:
            int r10 = com.business.merchant_payments.R.id.payment_info_tile_val
            android.view.View r10 = r12.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x011c
            java.lang.String r11 = r13.getKey()
            java.lang.String r12 = r13.getValue()
            java.lang.String r11 = r9.getAmountUsingKey(r11, r12, r3)
            r10.setText(r11)
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.helper.LabelPopulationHelperMP.checkForCarryForwardAndFillKeyValues(android.content.Context, com.business.merchant_payments.newhome.HomeRVListener, android.view.View, com.business.merchant_payments.settlement.model.LabelModel, boolean):void");
    }

    private final void addInfoIcon(LabelModel labelModel, Context context, TextView textView) {
        SpannableString spannableString = new SpannableString(getLocalisedString(labelModel.getKey()) + "  ");
        Drawable a2 = b.a(context, R.drawable.ic_info);
        if (a2 != null) {
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
        }
        spannableString.setSpan(a2 != null ? new ImageSpan(a2, 0) : null, spannableString.length() - 1, spannableString.length(), 33);
        if (textView != null) {
            textView.setTransformationMethod((TransformationMethod) null);
        }
        if (textView != null) {
            textView.setText(spannableString);
        }
    }

    public final Object filterLabelData(ArrayList<LabelModel> arrayList, String str, d<? super x> dVar) {
        if (arrayList != null && (!arrayList.isEmpty())) {
            int i2 = 0;
            int size = arrayList.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (p.a(BALANCE_FROM_FAILED_SETTLEMENT, arrayList.get(i2).getKey(), true)) {
                    ArrayList<LabelModel> failedBalanceList = getFailedBalanceList(arrayList.get(i2).getValueArray(), str);
                    if (failedBalanceList == null || !(true ^ failedBalanceList.isEmpty())) {
                        arrayList.get(i2).setValue((String) null);
                        arrayList.get(i2).setValueArray((ArrayList<PreviouslyFailedBalanceData>) null);
                    } else {
                        arrayList.remove(i2);
                        arrayList.addAll(i2, failedBalanceList);
                    }
                } else {
                    i2++;
                }
            }
        }
        return x.f47997a;
    }

    private final ArrayList<LabelModel> getFailedBalanceList(ArrayList<PreviouslyFailedBalanceData> arrayList, String str) {
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    ArrayList<LabelModel> arrayList2 = new ArrayList<>();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (!DateUtility.areDatesOfSameDay(str, arrayList.get(i2).getDate(), "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZZZ")) {
                            PaymentsConfig instance = PaymentsConfig.getInstance();
                            k.b(instance, "PaymentsConfig.getInstance()");
                            arrayList2.add(new LabelModel(instance.getAppContext().getString(R.string.mp_label_failed_settlement_from, new Object[]{DateUtility.getDateFromTimeStamp(arrayList.get(i2).getDate())}), arrayList.get(i2).getAmountModel().getValue(), (ArrayList<PreviouslyFailedBalanceData>) null));
                        }
                    }
                    return arrayList2;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void resetAmountOnHoldMap() {
        if (!holdAmountMap.isEmpty()) {
            holdAmountMap.clear();
        }
    }

    public final void setSettlementTime(String str) {
        settlementTime = str;
    }
}
