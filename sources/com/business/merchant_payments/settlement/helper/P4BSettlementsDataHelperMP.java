package com.business.merchant_payments.settlement.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.e;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.model.AmountModel;
import com.business.merchant_payments.settlement.model.ApiState;
import com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel;
import com.business.merchant_payments.settlement.model.LabelModel;
import com.business.merchant_payments.settlement.model.OnlineSettlementCardSummaryAdapteerModel;
import com.business.merchant_payments.settlement.model.PendingSettlementCardModel;
import com.business.merchant_payments.settlement.model.SettlementBankDetailModel;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;
import com.business.merchant_payments.settlement.model.TodaySettlementSummaryCardModel;
import com.business.merchant_payments.utility.UIUtilityMPKt;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import org.json.JSONObject;

public final class P4BSettlementsDataHelperMP {
    public static final String API_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZZZZ";
    public static final String BUSINESS_WALLET = "businessWallet";
    public static final int CONST_ONCE_A_DAY = 1;
    public static final int CONST_THRICE_A_DAY = 3;
    public static final int CONST_TWICE_A_DAY = 2;
    public static final P4BSettlementsDataHelperMP INSTANCE = new P4BSettlementsDataHelperMP();
    public static final String INSTANT_SETTLEMENT = "TWS";
    public static final String M2B_DETAIL_FAILED = "FAILURE";
    public static final String M2B_DETAIL_PENDING = "PENDING";
    public static final String M2B_DETAIL_SUCCESS = "SUCCESS";
    public static final String M2B_QUERY_ALL = "SUCCESS,PENDING,FAILURE";
    public static final String MERCHANT_STATUS_FREEZE = "SETTLE_FREEZE";
    public static final String MERCHANT_STATUS_HOLD = "HOLD";
    public static final String MERCHANT_TYPE_BW_GA = "BW";
    public static final String MERCHANT_TYPE_OS_GA = "OS";
    public static final String MERCHANT_TYPE_TWS_GA = "TWS";
    public static final int MULTIPLE_BANK_SETTLMENT = 0;
    public static final String OFFLINE_SETTLEMENT = "offline";
    public static final String ONLINE_SETTLEMENT = "online";
    public static final String PAYOUT_BANK_INITIATED = "BANK_INITIATED";
    public static final String PAYOUT_SETTLED = "PAYOUT_SETTLED";
    public static final String PAYOUT_UNSETTLED = "PAYOUT_UNSETTLED";
    public static final int SINGLE_BANK_SETTLEMENT = 1;
    public static final int UNKNOWN_BANK_SETTLEMENT = 2;

    public final ArrayList<Object> getElementShimmers() {
        return getElementShimmers$default(this, 0, 1, (Object) null);
    }

    public final Drawable geetM2BStatusDrawable(Context context, String str) {
        k.d(context, "context");
        if (p.a("PAYOUT_SETTLED", str, true) || p.a("SUCCESS", str, true)) {
            return b.a(context, R.drawable.green_tick);
        }
        if (p.a(PAYOUT_UNSETTLED, str, true) || p.a("PENDING", str, true)) {
            return b.a(context, R.drawable.mp_ic_icon_ui_warning);
        }
        if (p.a(PAYOUT_BANK_INITIATED, str, true) || p.a("PENDING", str, true)) {
            return b.a(context, R.drawable.mp_ic_icon_ui_warning);
        }
        return b.a(context, R.drawable.mp_ic_icon_red_error);
    }

    public final String getMultiAccountAccountSettlementString(String str, String str2, String str3, String str4) {
        String str5;
        k.d(str2, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        String displayBankAccountNumberMP$default = UIUtilityMPKt.getDisplayBankAccountNumberMP$default(str2, 0, 0, 6, (Object) null);
        String timeFromTimeStamp = DateUtility.getTimeFromTimeStamp(str3);
        k.b(timeFromTimeStamp, "DateUtility.getTimeFromT…tamp(settlementTimeStamp)");
        if (timeFromTimeStamp != null) {
            String lowerCase = timeFromTimeStamp.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            String convertDateToDifferentFormat = DateUtility.convertDateToDifferentFormat(str4, "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "d MMM");
            if (p.a("SUCCESS", str, true)) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                String string = instance.getAppContext().getString(R.string.mp_label_account_number_success, new Object[]{displayBankAccountNumberMP$default, lowerCase});
                k.b(string, "PaymentsConfig.getInstan…entTime\n                )");
                return string;
            } else if (p.a("PENDING", str, true)) {
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                k.b(instance2, "PaymentsConfig.getInstance()");
                String string2 = instance2.getAppContext().getString(R.string.mp_label_account_number_pending, new Object[]{displayBankAccountNumberMP$default});
                k.b(string2, "PaymentsConfig.getInstan…Process\n                )");
                return string2;
            } else {
                if (convertDateToDifferentFormat == null || p.a(convertDateToDifferentFormat)) {
                    PaymentsConfig instance3 = PaymentsConfig.getInstance();
                    k.b(instance3, "PaymentsConfig.getInstance()");
                    str5 = instance3.getAppContext().getString(R.string.mp_label_account_number_failed, new Object[]{displayBankAccountNumberMP$default});
                } else if (DateUtility.areDatesOfSameDay(str3, str4, "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZZZ")) {
                    PaymentsConfig instance4 = PaymentsConfig.getInstance();
                    k.b(instance4, "PaymentsConfig.getInstance()");
                    str5 = instance4.getAppContext().getString(R.string.mp_label_failed_settlement_with_date_with_account_number_same_day, new Object[]{displayBankAccountNumberMP$default});
                } else {
                    PaymentsConfig instance5 = PaymentsConfig.getInstance();
                    k.b(instance5, "PaymentsConfig.getInstance()");
                    str5 = instance5.getAppContext().getString(R.string.mp_label_failed_settlement_with_date_with_account_number, new Object[]{displayBankAccountNumberMP$default, convertDateToDifferentFormat});
                }
                k.b(str5, "when {\n                 …      )\n                }");
                return str5;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final String getBWSDetailStatusText(String str, int i2, String str2, String str3) {
        String str4;
        String timeFromTimeStamp = DateUtility.getTimeFromTimeStamp(str3);
        k.b(timeFromTimeStamp, "DateUtility.getTimeFromT…orderCompletionTimeStamp)");
        if (timeFromTimeStamp != null) {
            String lowerCase = timeFromTimeStamp.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            String convertDateToDifferentFormat = DateUtility.convertDateToDifferentFormat(str3, "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "d MMM");
            if (i2 == 0) {
                return getOnlineSettlementStatusText(str, ONLINE_SETTLEMENT);
            }
            if (p.a("SUCCESS", str, true)) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                String string = instance.getAppContext().getString(R.string.mp_lbl_settled_at_txt, new Object[]{lowerCase});
                k.b(string, "PaymentsConfig.getInstan…ime\n                    )");
                return string;
            } else if (p.a("PENDING", str, true)) {
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                k.b(instance2, "PaymentsConfig.getInstance()");
                String string2 = instance2.getAppContext().getString(R.string.mp_label_pending_single_bank_settlement_detail);
                k.b(string2, "PaymentsConfig.getInstan…ail\n                    )");
                return string2;
            } else {
                if (convertDateToDifferentFormat == null || p.a(convertDateToDifferentFormat)) {
                    PaymentsConfig instance3 = PaymentsConfig.getInstance();
                    k.b(instance3, "PaymentsConfig.getInstance()");
                    str4 = instance3.getAppContext().getString(R.string.mp_label_failed_single_bank_settlement_detail);
                } else {
                    PaymentsConfig instance4 = PaymentsConfig.getInstance();
                    k.b(instance4, "PaymentsConfig.getInstance()");
                    str4 = instance4.getAppContext().getString(R.string.mp_label_failed_settlement_with_date, new Object[]{convertDateToDifferentFormat});
                }
                k.b(str4, "when {\n                 … )\n\n                    }");
                return str4;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final String getOnlineSettlementStatusText(String str, String str2, ArrayList<SettlementBankDetailModel> arrayList) {
        String str3;
        if (arrayList != null && arrayList.size() > 0) {
            SettlementBankDetailModel settlementBankDetailModel = arrayList.get(0);
            k.b(settlementBankDetailModel, "bankDetails[0]");
            SettlementBankDetailModel settlementBankDetailModel2 = settlementBankDetailModel;
            String bankName = settlementBankDetailModel2.getBankName();
            if (!(bankName == null || p.a(bankName))) {
                String accountNumber = settlementBankDetailModel2.getAccountNumber();
                if (!(accountNumber == null || p.a(accountNumber))) {
                    return getOnlineSettlementStatusText(str, str2);
                }
            }
        }
        if (!p.a(ONLINE_SETTLEMENT, str2, true)) {
            return getOnlineSettlementStatusText(str, str2);
        }
        if (p.a("PAYOUT_SETTLED", str, true)) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            str3 = instance.getAppContext().getString(R.string.mp_label_settlement);
        } else if (p.a(PAYOUT_UNSETTLED, str, true)) {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            Context appContext = instance2.getAppContext();
            int i2 = R.string.mp_bw_settlement_pending_state_text;
            PaymentsConfig instance3 = PaymentsConfig.getInstance();
            k.b(instance3, "PaymentsConfig.getInstance()");
            str3 = appContext.getString(i2, new Object[]{instance3.getAppContext().getString(R.string.mp_label_settlement_to_your_account_is)});
        } else if (p.a(PAYOUT_BANK_INITIATED, str, true)) {
            PaymentsConfig instance4 = PaymentsConfig.getInstance();
            k.b(instance4, "PaymentsConfig.getInstance()");
            str3 = instance4.getAppContext().getString(R.string.mp_bank_transfer_initiated);
        } else {
            PaymentsConfig instance5 = PaymentsConfig.getInstance();
            k.b(instance5, "PaymentsConfig.getInstance()");
            str3 = instance5.getAppContext().getString(R.string.mp_label_failed_single_bank_settlement_detail);
        }
        k.b(str3, "when {\n                P…ent_detail)\n            }");
        return str3;
    }

    public final String getOnlineSettlementStatusText(String str, String str2) {
        String str3;
        String string;
        if (p.a(ONLINE_SETTLEMENT, str2, true)) {
            if (p.a("SUCCESS", str, true) || p.a("PAYOUT_SETTLED", str, true)) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                str3 = instance.getAppContext().getString(R.string.mp_label_online_settled_to);
            } else if (p.a(PAYOUT_BANK_INITIATED, str, true)) {
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                k.b(instance2, "PaymentsConfig.getInstance()");
                str3 = instance2.getAppContext().getString(R.string.mp_bank_transfer_initiated);
            } else {
                PaymentsConfig instance3 = PaymentsConfig.getInstance();
                k.b(instance3, "PaymentsConfig.getInstance()");
                str3 = instance3.getAppContext().getString(R.string.mp_label_online_settlement_to);
            }
            k.b(str3, "when {\n                M…lement_to)\n\n            }");
        } else {
            if (p.a("PAYOUT_SETTLED", str, true)) {
                PaymentsConfig instance4 = PaymentsConfig.getInstance();
                k.b(instance4, "PaymentsConfig.getInstance()");
                string = instance4.getAppContext().getString(R.string.mp_label_settlement);
            } else if (p.a(PAYOUT_UNSETTLED, str, true)) {
                PaymentsConfig instance5 = PaymentsConfig.getInstance();
                k.b(instance5, "PaymentsConfig.getInstance()");
                string = instance5.getAppContext().getString(R.string.mp_label_pending_single_bank_settlement_detail);
            } else if (p.a(PAYOUT_BANK_INITIATED, str, true)) {
                PaymentsConfig instance6 = PaymentsConfig.getInstance();
                k.b(instance6, "PaymentsConfig.getInstance()");
                string = instance6.getAppContext().getString(R.string.mp_bank_transfer_initiated);
            } else {
                PaymentsConfig instance7 = PaymentsConfig.getInstance();
                k.b(instance7, "PaymentsConfig.getInstance()");
                string = instance7.getAppContext().getString(R.string.mp_label_failed_single_bank_settlement_detail);
            }
            k.b(str3, "when {\n                P…ent_detail)\n            }");
        }
        return str3;
    }

    public final String getBWSettlementStatusText(int i2, int i3) {
        if (i3 != 1) {
            if (i2 != 0) {
                if (i2 == 1) {
                    PaymentsConfig instance = PaymentsConfig.getInstance();
                    k.b(instance, "PaymentsConfig.getInstance()");
                    String string = instance.getAppContext().getString(R.string.mp_label_bw_settlement_to_multiple_bank_accounts_is_pending);
                    k.b(string, "PaymentsConfig.getInstan…pending\n                )");
                    return string;
                } else if (i2 == 2) {
                    PaymentsConfig instance2 = PaymentsConfig.getInstance();
                    k.b(instance2, "PaymentsConfig.getInstance()");
                    String string2 = instance2.getAppContext().getString(R.string.mp_multiple_bank_settlemnt_failed_lbl);
                    k.b(string2, "PaymentsConfig.getInstan…led_lbl\n                )");
                    return string2;
                } else if (i2 == 3) {
                    PaymentsConfig instance3 = PaymentsConfig.getInstance();
                    k.b(instance3, "PaymentsConfig.getInstance()");
                    String string3 = instance3.getAppContext().getString(R.string.mp_multiple_bank_settlement_pending_faild_lbl);
                    k.b(string3, "PaymentsConfig.getInstan…ild_lbl\n                )");
                    return string3;
                } else if (i2 != 5) {
                    PaymentsConfig instance4 = PaymentsConfig.getInstance();
                    k.b(instance4, "PaymentsConfig.getInstance()");
                    String string4 = instance4.getAppContext().getString(R.string.mp_label_settlement_to_multiple_accounts);
                    k.b(string4, "PaymentsConfig.getInstan…ccounts\n                )");
                    return string4;
                }
            }
            PaymentsConfig instance5 = PaymentsConfig.getInstance();
            k.b(instance5, "PaymentsConfig.getInstance()");
            String string5 = instance5.getAppContext().getString(R.string.mp_multiple_bank_settlemnt_lbl);
            k.b(string5, "PaymentsConfig.getInstan…mnt_lbl\n                )");
            return string5;
        } else if (i2 == 0 || i2 == 5) {
            PaymentsConfig instance6 = PaymentsConfig.getInstance();
            k.b(instance6, "PaymentsConfig.getInstance()");
            String string6 = instance6.getAppContext().getString(R.string.mp_label_online_settled_to);
            k.b(string6, "PaymentsConfig.getInstan…_to\n                    )");
            return string6;
        } else {
            PaymentsConfig instance7 = PaymentsConfig.getInstance();
            k.b(instance7, "PaymentsConfig.getInstance()");
            String string7 = instance7.getAppContext().getString(R.string.mp_label_online_settlement_to);
            k.b(string7, "PaymentsConfig.getInstan…_to\n                    )");
            return string7;
        }
    }

    public final String getSingleBankSettlementStatusText(int i2, String str) {
        if (str == null) {
            str = "";
        }
        String displayBankAccountNumberMP$default = UIUtilityMPKt.getDisplayBankAccountNumberMP$default(str, 0, 0, 6, (Object) null);
        if (i2 == 1) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            String string = instance.getAppContext().getString(R.string.mp_bw_settlement_pending_state_text, new Object[]{displayBankAccountNumberMP$default});
            k.b(string, "PaymentsConfig.getInstan…erToProcess\n            )");
            return string;
        } else if (i2 != 2) {
            return displayBankAccountNumberMP$default;
        } else {
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            String string2 = instance2.getAppContext().getString(R.string.mp_label_online_settlement_failed, new Object[]{displayBankAccountNumberMP$default});
            k.b(string2, "PaymentsConfig.getInstan…erToProcess\n            )");
            return string2;
        }
    }

    public final String getOnlineSettlementAccountNumberText(String str, String str2) {
        k.d(str, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        k.d(str2, "status");
        String displayBankAccountNumberMP$default = UIUtilityMPKt.getDisplayBankAccountNumberMP$default(str, 0, 0, 6, (Object) null);
        if (p.a("PAYOUT_SETTLED", str2, true)) {
            return displayBankAccountNumberMP$default;
        }
        if (p.a(PAYOUT_UNSETTLED, str2, true)) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            String string = instance.getAppContext().getString(R.string.mp_bw_settlement_pending_state_text, new Object[]{displayBankAccountNumberMP$default});
            k.b(string, "PaymentsConfig.getInstan…, accountNumberToProcess)");
            return string;
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        String string2 = instance2.getAppContext().getString(R.string.mp_label_online_settlement_failed, new Object[]{displayBankAccountNumberMP$default});
        k.b(string2, "PaymentsConfig.getInstan…, accountNumberToProcess)");
        return string2;
    }

    public final String getSettlmentStringM2BDetail(String str, String str2) {
        k.d(str, "status");
        k.d(str2, "settlementTime");
        if (p.a("SUCCESS", str, true)) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Context appContext = instance.getAppContext();
            int i2 = R.string.mp_lbl_settled_at_txt;
            String lowerCase = str2.toLowerCase();
            k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            String string = appContext.getString(i2, new Object[]{lowerCase});
            k.b(string, "PaymentsConfig.getInstan…rCase()\n                )");
            return string;
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        Context appContext2 = instance2.getAppContext();
        int i3 = R.string.mp_lbl_settled_at_txt;
        PaymentsConfig instance3 = PaymentsConfig.getInstance();
        k.b(instance3, "PaymentsConfig.getInstance()");
        String string2 = appContext2.getString(i3, new Object[]{instance3.getAppContext().getString(R.string.mp_label_not_available)});
        k.b(string2, "PaymentsConfig.getInstan….mp_label_not_available))");
        return string2;
    }

    public final String getSettlementBillListRequestBody(String str, String str2, String str3, String str4) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        k.d(str3, "pageSize");
        k.d(str4, "pageNumber");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isSort", "true");
            jSONObject.put("pageSize", str3);
            jSONObject.put("pageNum", str4);
            jSONObject.put("settlementStartTime", str);
            jSONObject.put("settlementEndTime", str2);
            jSONObject.put("isFilterZeroAmount", true);
            String jSONObject2 = jSONObject.toString();
            k.b(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (Exception unused) {
            return "";
        }
    }

    public final HashMap<String, Object> getSettlementBillListItemDetailQueryMap(String str, String str2, int i2, int i3, String str3) {
        k.d(str, "startDate");
        k.d(str2, "endDate");
        k.d(str3, "orderStatusList");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("startDate", str);
        hashMap.put("endDate", str2);
        hashMap.put("pageNum", String.valueOf(i2));
        hashMap.put("pageSize", String.valueOf(i3));
        hashMap.put("orderStatusList", str3);
        return hashMap;
    }

    public final String getSettlmentPaymentsText(String str) {
        k.d(str, "count");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        Context appContext = instance.getAppContext();
        k.b(appContext, "PaymentsConfig.getInstance().appContext");
        Resources resources = appContext.getResources();
        int i2 = R.string.mp_total_payments_text;
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        Context appContext2 = instance2.getAppContext();
        k.b(appContext2, "PaymentsConfig.getInstance().appContext");
        String string = resources.getString(i2, new Object[]{appContext2.getResources().getString(R.string.mp_bullet, new Object[]{str})});
        k.b(string, "PaymentsConfig.getInstan…string.mp_bullet, count))");
        return string;
    }

    public final ArrayList<Object> getAdapterDataWithShimmer() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(HomeRVAdapter.SETTLEMENT_SUMMARY_SHIMMER);
        arrayList.addAll(getElementShimmers$default(this, 0, 1, (Object) null));
        return arrayList;
    }

    public final ArrayList<Object> getAdapterDataWithShimmerLayout() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(HomeRVAdapter.SETTLEMENT_SUMMARY_SHIMMER);
        arrayList.add(HomeRVAdapter.SETTLEMENT_ELEMENT_SHIMMER);
        return arrayList;
    }

    public static /* synthetic */ ArrayList getElementShimmers$default(P4BSettlementsDataHelperMP p4BSettlementsDataHelperMP, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 15;
        }
        return p4BSettlementsDataHelperMP.getElementShimmers(i2);
    }

    public final ArrayList<Object> getElementShimmers(int i2) {
        ArrayList<Object> arrayList = new ArrayList<>();
        int i3 = 1;
        if (1 <= i2) {
            while (true) {
                arrayList.add(HomeRVAdapter.SETTLEMENT_ELEMENT_SHIMMER);
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        return arrayList;
    }

    public final boolean isBW() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().p()) {
            return true;
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        return instance2.getMerchantDataProvider().F();
    }

    public final Object getSummaryCardModel(TodaySettlementSummaryCardModel todaySettlementSummaryCardModel, e eVar) {
        k.d(eVar, "status");
        if (todaySettlementSummaryCardModel == null || eVar != e.SUCCESS) {
            return new OnlineSettlementCardSummaryAdapteerModel(new TodaySettlementSummaryCardModel("--", "", (ArrayList<LabelModel>) null, "--", ApiState.ERROR));
        }
        todaySettlementSummaryCardModel.setApiState(ApiState.SUCCESS);
        String totalPayments = todaySettlementSummaryCardModel.getTotalPayments();
        if (totalPayments == null) {
            totalPayments = "0";
        }
        todaySettlementSummaryCardModel.setTotalPayments(totalPayments);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().J()) {
            return new BWSettlementCardSummaryAdapterModel(todaySettlementSummaryCardModel, false, true, (ArrayList) null, false, (ArrayList) null, false, 120, (g) null);
        }
        if (isBW()) {
            return new BWSettlementCardSummaryAdapterModel(todaySettlementSummaryCardModel, false, false, (ArrayList) null, false, (ArrayList) null, false, 120, (g) null);
        }
        if (p.a(todaySettlementSummaryCardModel.getSettlementType(), ONLINE_SETTLEMENT, true)) {
            return new OnlineSettlementCardSummaryAdapteerModel(todaySettlementSummaryCardModel);
        }
        return new OnlineSettlementCardSummaryAdapteerModel(new TodaySettlementSummaryCardModel("--", "", (ArrayList<LabelModel>) null, "--", ApiState.ERROR));
    }

    public final String getSettlementFrequencyText(int i2) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        String string = instance.getAppContext().getString(R.string.mp_label_unable_to_fetch_settleement_frequency);
        k.b(string, "PaymentsConfig.getInstan…ch_settleement_frequency)");
        int i3 = Calendar.getInstance().get(11);
        GTMDataProviderImpl mInstance = GTMDataProviderImpl.Companion.getMInstance();
        try {
            ArrayList arrayList = new ArrayList(3);
            if (i2 == 1) {
                arrayList.addAll(p.b((CharSequence) mInstance.getSettlementTime(), new String[]{AppConstants.COMMA}));
            } else if (i2 == 2) {
                arrayList.addAll(p.b((CharSequence) mInstance.getTwiceTime(), new String[]{AppConstants.COMMA}));
            } else if (i2 == 3) {
                arrayList.addAll(p.b((CharSequence) mInstance.getThriceTime(), new String[]{AppConstants.COMMA}));
            }
            int size = arrayList.size() - 1;
            int size2 = arrayList.size();
            while (size >= 0) {
                Object obj = arrayList.get(size);
                k.b(obj, "arrayList[i]");
                if (i3 >= Integer.parseInt((String) obj)) {
                    break;
                }
                size--;
            }
            Object obj2 = arrayList.get((size + 1) % size2);
            k.b(obj2, "arrayList[(i + 1) % size]");
            String str = (String) obj2;
            String timeIn12HourFormat = DateUtility.timeIn12HourFormat(p.a(str, (String) arrayList.get(0), true) ? Integer.parseInt(str) + 2 : Integer.parseInt(str));
            int i4 = size == arrayList.size() - 1 ? R.string.mp_label_next_settlement_by_tomorrow : R.string.mp_label_next_settlement_by;
            PaymentsConfig instance2 = PaymentsConfig.getInstance();
            k.b(instance2, "PaymentsConfig.getInstance()");
            String string2 = instance2.getAppContext().getString(i4, new Object[]{timeIn12HourFormat});
            k.b(string2, "PaymentsConfig.getInstan…tString(resourceId, time)");
            return string2;
        } catch (Exception unused) {
            return string;
        }
    }

    public final PendingSettlementCardModel getPendingCard(SettlementBillListItemModel settlementBillListItemModel) {
        k.d(settlementBillListItemModel, "data");
        try {
            if (settlementBillListItemModel.getPendingAmount() != null) {
                AmountModel pendingAmount = settlementBillListItemModel.getPendingAmount();
                k.a((Object) pendingAmount);
                String value = pendingAmount.getValue();
                if (!(value == null || value.length() == 0)) {
                    String settlementTime = settlementBillListItemModel.getSettlementTime();
                    if (!(settlementTime == null || settlementTime.length() == 0)) {
                        AmountModel pendingAmount2 = settlementBillListItemModel.getPendingAmount();
                        k.a((Object) pendingAmount2);
                        String value2 = pendingAmount2.getValue();
                        k.a((Object) value2);
                        StringBuilder sb = new StringBuilder();
                        PaymentsConfig instance = PaymentsConfig.getInstance();
                        k.b(instance, "PaymentsConfig.getInstance()");
                        sb.append(instance.getAppContext().getString(R.string.mp_rupee_symbol));
                        sb.append(AppUtility.formatNumber(String.valueOf(Double.parseDouble(value2) / 100.0d), com.business.merchant_payments.common.utility.AppConstants.PRICE_PATTERN));
                        String sb2 = sb.toString();
                        PaymentsConfig instance2 = PaymentsConfig.getInstance();
                        k.b(instance2, "PaymentsConfig.getInstance()");
                        String string = instance2.getAppContext().getString(R.string.mp_pending_settlement_header, new Object[]{sb2});
                        k.b(string, "PaymentsConfig.getInstan…nt_header, pendingAmount)");
                        com.business.common_module.utilities.g gVar = com.business.common_module.utilities.g.f7371a;
                        String settlementTime2 = settlementBillListItemModel.getSettlementTime();
                        k.a((Object) settlementTime2);
                        String a2 = com.business.common_module.utilities.g.a(settlementTime2, "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                        com.business.common_module.utilities.g gVar2 = com.business.common_module.utilities.g.f7371a;
                        String settlementTime3 = settlementBillListItemModel.getSettlementTime();
                        k.a((Object) settlementTime3);
                        String b2 = com.business.common_module.utilities.g.d(settlementTime3, "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                        com.business.common_module.utilities.g gVar3 = com.business.common_module.utilities.g.f7371a;
                        String a3 = com.business.common_module.utilities.g.a(b2, "yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                        PaymentsConfig instance3 = PaymentsConfig.getInstance();
                        k.b(instance3, "PaymentsConfig.getInstance()");
                        String string2 = instance3.getAppContext().getString(R.string.mp_99_99_percent);
                        k.b(string2, "PaymentsConfig.getInstan….string.mp_99_99_percent)");
                        PaymentsConfig instance4 = PaymentsConfig.getInstance();
                        k.b(instance4, "PaymentsConfig.getInstance()");
                        String string3 = instance4.getAppContext().getString(R.string.mp_pending_settlement_summary, new Object[]{a2, a3, string2});
                        k.b(string3, "PaymentsConfig.getInstan…ByTime, almostAllPercent)");
                        return new PendingSettlementCardModel(true, string, string3);
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            return null;
        }
    }
}
