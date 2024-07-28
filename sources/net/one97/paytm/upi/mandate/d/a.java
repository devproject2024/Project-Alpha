package net.one97.paytm.upi.mandate.d;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Param;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.t;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.PendingCollectMandateDetails;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.deeplink.model.ExtraIntentParams;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.data.model.MandatePayee;
import net.one97.paytm.upi.mandate.data.model.MandatePayer;
import net.one97.paytm.upi.mandate.utils.m;
import net.one97.paytm.upi.util.UpiUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67112a = new a();

    private a() {
    }

    public static MandateItem a(UpiPendingRequestModel upiPendingRequestModel) {
        k.c(upiPendingRequestModel, "upiPendingRequestModel");
        PendingCollectMandateDetails mandateDetails = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails, "mandateDetails");
        String umn = mandateDetails.getUmn();
        String str = umn;
        k.a((Object) umn, "mandateDetails.umn");
        String note = upiPendingRequestModel.getNote();
        String amount = upiPendingRequestModel.getAmount();
        PendingCollectMandateDetails mandateDetails2 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails2, "mandateDetails");
        String validityStartDate = mandateDetails2.getValidityStartDate();
        PendingCollectMandateDetails mandateDetails3 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails3, "mandateDetails");
        String validityEndDate = mandateDetails3.getValidityEndDate();
        String refUrl = upiPendingRequestModel.getRefUrl();
        String refCategory = upiPendingRequestModel.getRefCategory();
        PendingCollectMandateDetails mandateDetails4 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails4, "mandateDetails");
        String recurrence = mandateDetails4.getRecurrence();
        PendingCollectMandateDetails mandateDetails5 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails5, "mandateDetails");
        String amountRule = mandateDetails5.getAmountRule();
        MandatePayer mandatePayer = r20;
        MandatePayer mandatePayer2 = new MandatePayer((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
        MandatePayee mandatePayee = r28;
        MandatePayee mandatePayee2 = new MandatePayee((String) null, upiPendingRequestModel.getPayeeName(), (String) null, (String) null, (String) null, upiPendingRequestModel.getPayeeVa(), upiPendingRequestModel.getMcc(), upiPendingRequestModel.getLogoUrl());
        String txnId = upiPendingRequestModel.getTxnId();
        String str2 = txnId;
        k.a((Object) txnId, "txnId");
        PendingCollectMandateDetails mandateDetails6 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails6, "mandateDetails");
        String recurrenceType = mandateDetails6.getRecurrenceType();
        PendingCollectMandateDetails mandateDetails7 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails7, "mandateDetails");
        String recurrenceRule = mandateDetails7.getRecurrenceRule();
        PendingCollectMandateDetails mandateDetails8 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails8, "mandateDetails");
        String accRefId = mandateDetails8.getAccRefId();
        PendingCollectMandateDetails mandateDetails9 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails9, "mandateDetails");
        String lastAmount = mandateDetails9.getLastAmount();
        PendingCollectMandateDetails mandateDetails10 = upiPendingRequestModel.getMandateDetails();
        k.a((Object) mandateDetails10, "mandateDetails");
        String type = mandateDetails10.getType();
        k.a((Object) type, "mandateDetails.type");
        return new MandateItem(accRefId, str, (String) null, note, amount, (String) null, validityStartDate, validityEndDate, (Boolean) null, (String) null, (String) null, (String) null, refUrl, refCategory, recurrence, amountRule, mandatePayer, mandatePayee, "P2M", (String) null, (String) null, (String) null, str2, (String) null, (String) null, (String) null, recurrenceType, recurrenceRule, lastAmount, type, upiPendingRequestModel.getPurpose());
    }

    /* access modifiers changed from: private */
    public static MandateConfirmationUiModel a(MandateItem mandateItem, String str) {
        k.c(mandateItem, "mandateItem");
        CharSequence accRefId = mandateItem.getAccRefId();
        boolean z = false;
        String accRefId2 = !(accRefId == null || p.a(accRefId)) ? mandateItem.getAccRefId() : null;
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            z = true;
        }
        return new MandateConfirmationUiModel(mandateItem.getPayee().getVpa(), mandateItem.getPayee().getUserName(), mandateItem.getAmount(), mandateItem.getValidityStartDate(), mandateItem.getValidityEndDate(), mandateItem.getMandateName(), mandateItem.getNote(), mandateItem.getAmountRule(), mandateItem.getRecurrence(), mandateItem.getRecurrenceRule(), mandateItem.getRecurrenceType(), mandateItem.getTxnId(), mandateItem.getPayee().getMcc(), mandateItem.getRefUrl(), mandateItem.getPurpose(), !z ? str : accRefId2, mandateItem.getUmn(), (ExtraIntentParams) null, 131072, (g) null);
    }

    public static C1354a a(MandateItem mandateItem, Context context, String str) {
        k.c(mandateItem, "mandateItem");
        k.c(context, "context");
        k.c(str, "accRefId");
        return new C1354a(context, a(mandateItem, str), false);
    }

    /* renamed from: net.one97.paytm.upi.mandate.d.a$a  reason: collision with other inner class name */
    public static final class C1354a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f67113a;

        /* renamed from: b  reason: collision with root package name */
        public final MandateConfirmationUiModel f67114b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f67115c;

        public C1354a(Context context, MandateConfirmationUiModel mandateConfirmationUiModel, boolean z) {
            k.c(context, "context");
            k.c(mandateConfirmationUiModel, "mandateConfirmationUiModel");
            this.f67113a = context;
            this.f67114b = mandateConfirmationUiModel;
            this.f67115c = z;
        }
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        String str5;
        Context context2 = context;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        k.c(context2, "context");
        k.c(str6, "recurrenceRule");
        k.c(str7, "recurrencePattern");
        k.c(str8, "recurrenceType");
        k.c(str9, "validityStartDate");
        if (k.a((Object) str7, (Object) "DAILY")) {
            String string = context2.getString(R.string.upi_daily);
            k.a((Object) string, "context.getString(R.string.upi_daily)");
            return string;
        } else if (k.a((Object) str7, (Object) "ASPRESENTED")) {
            String string2 = context2.getString(R.string.mandate_as_presented);
            k.a((Object) string2, "context.getString(R.string.mandate_as_presented)");
            return string2;
        } else {
            Date parse = new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).parse(str9);
            Calendar instance = Calendar.getInstance();
            k.a((Object) instance, "calendar");
            instance.setTime(parse);
            String str10 = context.getResources().getStringArray(R.array.upi_months_array)[instance.get(2)];
            k.a((Object) str10, "context.resources.getStr…months_array)[monthIndex]");
            int hashCode = str3.hashCode();
            String str11 = "";
            String str12 = " ";
            if (hashCode == 2527) {
                str5 = str12;
                if (str8.equals("ON")) {
                    String a2 = a(str);
                    switch (str2.hashCode()) {
                        case -1738378111:
                            if (str7.equals("WEEKLY")) {
                                String string3 = context2.getString(R.string.upi_mandate_debit_msg_weekly, new Object[]{a(str6, context2)});
                                k.a((Object) string3, "getString(R.string.upi_m…recurrenceRule, context))");
                                return string3;
                            }
                            break;
                        case -1681232246:
                            if (str7.equals("YEARLY")) {
                                return (context2.getString(R.string.upi_mandate_starts) + str5) + context2.getString(R.string.upi_mandate_debit_msg_yearly, new Object[]{a2, str10});
                            }
                            break;
                        case 1134556285:
                            if (str7.equals("HALFYEARLY")) {
                                return (context2.getString(R.string.upi_mandate_starts) + str5) + context2.getString(R.string.upi_mandate_debit_msg_half_yearly, new Object[]{a2, str10});
                            }
                            break;
                        case 1271097434:
                            if (str7.equals("FORTNIGHTLY")) {
                                String string4 = context2.getString(R.string.upi_mandate_debit_msg_fortnightly, new Object[]{a2});
                                k.a((Object) string4, "getString(R.string.upi_m…bit_msg_fortnightly, day)");
                                return string4;
                            }
                            break;
                        case 1297843654:
                            if (str7.equals("BIMONTHLY")) {
                                return (context2.getString(R.string.upi_mandate_starts) + str5) + context2.getString(R.string.upi_mandate_debit_msg_bimonthly, new Object[]{a2, str10});
                            }
                            break;
                        case 1720567065:
                            if (str7.equals("QUARTERLY")) {
                                return (context2.getString(R.string.upi_mandate_starts) + str5) + context2.getString(R.string.upi_mandate_debit_msg_quarterly, new Object[]{a2, str10});
                            }
                            break;
                        case 1954618349:
                            if (str7.equals("MONTHLY")) {
                                String string5 = context2.getString(R.string.upi_mandate_debit_msg_monthly, new Object[]{a2});
                                k.a((Object) string5, "getString(R.string.upi_m…e_debit_msg_monthly, day)");
                                return string5;
                            }
                            break;
                    }
                    return str11;
                }
            } else if (hashCode == 1955410815 && str8.equals("BEFORE")) {
                String a3 = a(str);
                switch (str2.hashCode()) {
                    case -1738378111:
                        if (str7.equals("WEEKLY")) {
                            str11 = context2.getString(R.string.upi_mandate_debit_msg_weekly, new Object[]{a(str6, context2)});
                            break;
                        }
                        break;
                    case -1681232246:
                        if (str7.equals("YEARLY")) {
                            str11 = context2.getString(R.string.upi_mandate_debit_msg_yearly, new Object[]{a3, str10});
                            break;
                        }
                        break;
                    case 1134556285:
                        if (str7.equals("HALFYEARLY")) {
                            str11 = context2.getString(R.string.upi_mandate_debit_msg_half_yearly, new Object[]{a3, str10});
                            break;
                        }
                        break;
                    case 1271097434:
                        if (str7.equals("FORTNIGHTLY")) {
                            str11 = context2.getString(R.string.upi_mandate_debit_msg_fortnightly, new Object[]{a3});
                            break;
                        }
                        break;
                    case 1297843654:
                        if (str7.equals("BIMONTHLY")) {
                            str11 = context2.getString(R.string.upi_mandate_debit_msg_bimonthly, new Object[]{a3, str10});
                            break;
                        }
                        break;
                    case 1720567065:
                        if (str7.equals("QUARTERLY")) {
                            str11 = context2.getString(R.string.upi_mandate_debit_msg_quarterly, new Object[]{a3, str10});
                            break;
                        }
                        break;
                    case 1954618349:
                        if (str7.equals("MONTHLY")) {
                            str11 = context2.getString(R.string.upi_mandate_debit_msg_monthly, new Object[]{a3});
                            break;
                        }
                        break;
                }
                String str13 = str11;
                k.a((Object) str13, "when (recurrencePattern)… else -> \"\"\n            }");
                return (context2.getString(R.string.upi_mandate_before) + str12) + str13;
            } else {
                str5 = str12;
            }
            String a4 = a(str);
            switch (str2.hashCode()) {
                case -1738378111:
                    if (str7.equals("WEEKLY")) {
                        str11 = context2.getString(R.string.upi_mandate_debit_msg_weekly, new Object[]{a(str6, context2)});
                        break;
                    }
                    break;
                case -1681232246:
                    if (str7.equals("YEARLY")) {
                        str11 = context2.getString(R.string.upi_mandate_debit_msg_yearly, new Object[]{a4, str10});
                        break;
                    }
                    break;
                case 1134556285:
                    if (str7.equals("HALFYEARLY")) {
                        str11 = context2.getString(R.string.upi_mandate_debit_msg_half_yearly, new Object[]{a4, str10});
                        break;
                    }
                    break;
                case 1271097434:
                    if (str7.equals("FORTNIGHTLY")) {
                        str11 = context2.getString(R.string.upi_mandate_debit_msg_fortnightly, new Object[]{a4});
                        break;
                    }
                    break;
                case 1297843654:
                    if (str7.equals("BIMONTHLY")) {
                        str11 = context2.getString(R.string.upi_mandate_debit_msg_bimonthly, new Object[]{a4, str10});
                        break;
                    }
                    break;
                case 1720567065:
                    if (str7.equals("QUARTERLY")) {
                        str11 = context2.getString(R.string.upi_mandate_debit_msg_quarterly, new Object[]{a4, str10});
                        break;
                    }
                    break;
                case 1954618349:
                    if (str7.equals("MONTHLY")) {
                        str11 = context2.getString(R.string.upi_mandate_debit_msg_monthly, new Object[]{a4});
                        break;
                    }
                    break;
            }
            String str14 = str11;
            k.a((Object) str14, "when (recurrencePattern)… else -> \"\"\n            }");
            return (context2.getString(R.string.upi_mandate_after) + str5) + str14;
        }
    }

    private static String a(String str, Context context) {
        String str2 = context.getResources().getStringArray(R.array.upi_mandate_weekly_array)[Integer.parseInt(str) - 1];
        k.a((Object) str2, "context.resources.getStr…currenceRule.toInt() - 1]");
        return str2;
    }

    private static String a(String str) {
        String str2;
        Map a2 = ae.a((o<? extends K, ? extends V>[]) new o[]{t.a(1, H5Param.SHOW_TITLEBAR), t.a(2, "nd"), t.a(3, "rd")});
        int parseInt = Integer.parseInt(str) % 100;
        String str3 = "th";
        if ((10 > parseInt || 20 < parseInt) && (str2 = (String) a2.get(Integer.valueOf(Integer.parseInt(str) % 10))) != null) {
            str3 = str2;
        }
        return str + str3;
    }

    public static CharSequence a(Context context, String str, String str2) {
        k.c(context, "context");
        String convertDateFromTo = UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMMM yyyy", str);
        String convertDateFromTo2 = UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMMM yyyy", str2);
        String string = context.getString(R.string.mandate_starting_up_to_end, new Object[]{convertDateFromTo, convertDateFromTo2});
        k.a((Object) string, "context.getString(R.stri…StartDate, parsedEndDate)");
        return string;
    }

    public static CharSequence b(Context context, String str, String str2) {
        k.c(context, "context");
        String convertDateFromTo = UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMMM yyyy", str);
        String convertDateFromTo2 = UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMMM yyyy", str2);
        String string = context.getString(R.string.upi_mandate_valid_to_one_time, new Object[]{convertDateFromTo, convertDateFromTo2});
        k.a((Object) string, "context.getString(R.stri…StartDate, parsedEndDate)");
        return string;
    }

    public static MandateItem a(MandateConfirmationUiModel mandateConfirmationUiModel, UpiProfileDefaultBank upiProfileDefaultBank) {
        k.c(mandateConfirmationUiModel, "mandateConfirmationUiModel");
        k.c(upiProfileDefaultBank, "defaultBank");
        String str = mandateConfirmationUiModel.getMandateTransactionType() == m.RECURRING ? "RECURRING" : "ONETIME";
        String accRefId = mandateConfirmationUiModel.getAccRefId();
        String umn = mandateConfirmationUiModel.getUmn();
        if (umn == null) {
            k.a();
        }
        String comment = mandateConfirmationUiModel.getComment();
        String amount = mandateConfirmationUiModel.getAmount();
        String startDate = mandateConfirmationUiModel.getStartDate();
        String endDate = mandateConfirmationUiModel.getEndDate();
        String refUrl = mandateConfirmationUiModel.getRefUrl();
        String recurrencePattern = mandateConfirmationUiModel.getRecurrencePattern();
        String amountRule = mandateConfirmationUiModel.getAmountRule();
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        k.a((Object) debitBank, "defaultBank.debitBank");
        String customerName = debitBank.getCustomerName();
        BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
        k.a((Object) debitBank2, "defaultBank.debitBank");
        String account = debitBank2.getAccount();
        BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
        k.a((Object) debitBank3, "defaultBank.debitBank");
        String ifsc = debitBank3.getIfsc();
        BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank.getDebitBank();
        k.a((Object) debitBank4, "defaultBank.debitBank");
        MandatePayer mandatePayer = new MandatePayer((String) null, customerName, account, ifsc, debitBank4.getBankName(), upiProfileDefaultBank.getVirtualAddress(), (String) null);
        MandatePayee mandatePayee = new MandatePayee((String) null, mandateConfirmationUiModel.getPayeeName(), (String) null, (String) null, (String) null, mandateConfirmationUiModel.getPayeeVpa(), mandateConfirmationUiModel.getMcc(), (String) null);
        String transactionId = mandateConfirmationUiModel.getTransactionId();
        if (transactionId == null) {
            transactionId = "";
        }
        return new MandateItem(accRefId, umn, (String) null, comment, amount, (String) null, startDate, endDate, (Boolean) null, (String) null, (String) null, (String) null, refUrl, (String) null, recurrencePattern, amountRule, mandatePayer, mandatePayee, (String) null, (String) null, (String) null, (String) null, transactionId, (String) null, (String) null, (String) null, mandateConfirmationUiModel.getRecurrenceType(), mandateConfirmationUiModel.getRecurrenceRule(), (String) null, str, mandateConfirmationUiModel.getPurpose());
    }

    public static UpiPendingRequestModel b(MandateItem mandateItem) {
        k.c(mandateItem, "mandateItem");
        UpiPendingRequestModel upiPendingRequestModel = new UpiPendingRequestModel();
        upiPendingRequestModel.setAmount(mandateItem.getAmount());
        upiPendingRequestModel.setNote(mandateItem.getNote());
        upiPendingRequestModel.setmUpiTranlogId(mandateItem.getTxnId());
        upiPendingRequestModel.setPayeeName(mandateItem.getPayee().getUserName());
        upiPendingRequestModel.setTxnId(mandateItem.getTxnId());
        upiPendingRequestModel.setType("COLLECT");
        upiPendingRequestModel.setPayerVa(mandateItem.getPayer().getVpa());
        upiPendingRequestModel.setPayerName(mandateItem.getPayer().getUserName());
        PendingCollectMandateDetails pendingCollectMandateDetails = new PendingCollectMandateDetails();
        pendingCollectMandateDetails.setUmn(mandateItem.getUmn());
        upiPendingRequestModel.setMandateDetails(pendingCollectMandateDetails);
        upiPendingRequestModel.setRefUrl(mandateItem.getRefUrl());
        return upiPendingRequestModel;
    }

    public static m a(String str, String str2, String str3) {
        if (!p.a(str, "ONETIME", true)) {
            return m.RECURRING;
        }
        if (!p.a(str, "ONETIME", true) || !k.a((Object) str2, (Object) "6211") || !k.a((Object) str3, (Object) WebLogin.RESPONSE_CODE_SUCCESS)) {
            return m.ONE_TIME;
        }
        return m.ASBA;
    }
}
