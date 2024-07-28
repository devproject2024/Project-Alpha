package net.one97.paytm.dynamic.module.bank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.b;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.bankOpen.activity.BankAccountKycSubmittedActivity;
import net.one97.paytm.bankOpen.activity.BankAccountOpenReqSubmittedActivity;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.bankOpen.b.e;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.payments.activity.AJRSetPasscode;
import net.one97.paytm.paymentsBank.activity.PBEnteringFlowPasscodeActivity;
import net.one97.paytm.paymentsBank.activity.SavingsAccountActivity;
import net.one97.paytm.paymentsBank.activity.SavingsAccountInfoActivity;
import net.one97.paytm.paymentsBank.customView.a;
import net.one97.paytm.paymentsBank.customView.c;
import net.one97.paytm.paymentsBank.fragment.o;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCSuccessActivity;
import net.one97.paytm.paymentsBank.si.response.AllSIResponse;
import net.one97.paytm.paymentsBank.si.response.SIActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SICreationResponse;
import net.one97.paytm.paymentsBank.si.response.SIDeActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SIDeleteResponse;
import net.one97.paytm.paymentsBank.si.response.SIPrevalidateResponse;
import net.one97.paytm.paymentsBank.utils.l;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class BankUtils {
    public static String getSavingsAccountActivityPageName() {
        return SavingsAccountActivity.class.getName();
    }

    public static Intent getSavingsAccountActivityIntent(Context context) {
        return new Intent(context, SavingsAccountActivity.class);
    }

    public static Intent getSavingsAccountInfoActivityIntent(Context context) {
        return new Intent(context, SavingsAccountInfoActivity.class);
    }

    public static Intent getPaymentsBankBaseOpenAccountActivityIntent(Context context) {
        Intent intent = new Intent(context, PaymentsBankBaseActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("extraDefaultFrame", 3);
        return intent;
    }

    public static Intent getPaymentsBankBaseCheckAccountActivityIntent(Context context) {
        Intent intent = new Intent(context, PaymentsBankBaseActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("extraDefaultFrame", 6);
        return intent;
    }

    public static Intent getBankAccountOpenReqSubmittedActivityIntent(Context context) {
        Intent intent = new Intent(context, BankAccountOpenReqSubmittedActivity.class);
        intent.setFlags(67108864);
        return intent;
    }

    public static Intent getBankAccountKycSubmittedActivityIntent(Context context) {
        Intent intent = new Intent(context, BankAccountKycSubmittedActivity.class);
        intent.setFlags(67108864);
        return intent;
    }

    public static Intent getPDCPasscodePinActivityIntent(Context context) {
        Intent intent = new Intent(context, PDCPasscodePinActivity.class);
        intent.setFlags(67108864);
        return intent;
    }

    public static b getPBOpenBankAccountBottomSheetFragment() {
        return new o();
    }

    public static Fragment getPaymentBankOpenAccountFragment() {
        return new e();
    }

    public static Intent getPDCSuccessActivityIntent(Context context) {
        return new Intent(context, PDCSuccessActivity.class);
    }

    public static void clearBankHandlerData() {
        a.a(c.MASKED_CARD);
        a.c();
    }

    public static String getNachConsentPostParams(boolean z, boolean z2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", UpiConstants.B2C_ANDROID);
            jSONObject.put("umrn", str);
            jSONObject.put("consentAction", z ? "AMEND" : "CREATE");
            jSONObject.put("consentTime", System.currentTimeMillis());
            if (!z2) {
                jSONObject.put("rejectCode", "M032");
                jSONObject.put("consentStatus", "REJECTED");
            } else {
                jSONObject.put("consentStatus", "ACCEPTED");
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject.toString();
    }

    public static Intent getPassbookPasscodeActivityIntent(Context context) {
        return new Intent(context, PBEnteringFlowPasscodeActivity.class);
    }

    public static boolean isBankSiResponseInstances(IJRDataModel iJRDataModel) {
        return (iJRDataModel instanceof SIDeActivateResponse) || (iJRDataModel instanceof SIActivateResponse) || (iJRDataModel instanceof SIDeleteResponse) || (iJRDataModel instanceof SIPrevalidateResponse) || (iJRDataModel instanceof SICreationResponse) || (iJRDataModel instanceof AllSIResponse);
    }

    public static int getBankAccountStatus(Context context) {
        return net.one97.paytm.bankCommon.h.b.i(context);
    }

    public static boolean isUserPasscodeSet(Context context) {
        return net.one97.paytm.bankCommon.h.b.a(context);
    }

    public static boolean isBankAccountIssued(Context context) {
        return net.one97.paytm.bankCommon.h.b.g(context);
    }

    public static void setBankAccountStatus(Context context, int i2) {
        net.one97.paytm.bankCommon.h.b.a(context, i2);
    }

    public static void checkPasscodeExists(final Context context) {
        AnonymousClass1 r0 = new com.paytm.network.listener.b() {
            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                try {
                    ValidatePasscode validatePasscode = (ValidatePasscode) iJRPaytmDataModel;
                    if (validatePasscode != null && validatePasscode.getResponseCode() == 1100) {
                        net.one97.paytm.utils.a.b.b(context, true);
                    }
                } catch (Exception unused) {
                }
            }
        };
        a.c cVar = a.c.PAYMENTSBANK;
        a.b bVar = a.b.SILENT;
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", com.paytm.utility.a.q(context));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", "ANDROID");
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42880d = "https://oauth-origin-ite.paytmbank.com/bank-oauth/ext/v2/passcode-exists";
        bVar2.f42882f = hashMap;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42878b = cVar;
        bVar2.f42877a = context;
        bVar2.n = bVar;
        bVar2.j = r0;
        bVar2.f42885i = new ValidatePasscode();
        bVar2.l = true;
        bVar2.o = "BankUtils";
        bVar2.l().a();
    }

    public static void setBankLead(Context context, boolean z) {
        net.one97.paytm.bankCommon.h.b.b(context, z);
    }

    public static void setBankInvite(Context context, boolean z) {
        net.one97.paytm.bankCommon.h.b.c(context, z);
    }

    public static void setPPBCustomer(Context context, boolean z) {
        net.one97.paytm.bankCommon.h.b.d(context, z);
    }

    public static boolean isPPBCustomer(Context context) {
        return net.one97.paytm.bankCommon.h.b.s(context);
    }

    public static boolean isPaymentBankUser(Context context) {
        return net.one97.paytm.bankCommon.h.b.f(context);
    }

    public static void clearAllData(Context context) {
        net.one97.paytm.bankCommon.h.b.r(context);
    }

    public static int getBankTabPopupCounter(Context context) {
        return net.one97.paytm.bankCommon.h.b.y(context);
    }

    public static void decrementBankTabPopUpCounterToOne(Context context) {
        net.one97.paytm.bankCommon.h.b.A(context);
    }

    public static void incrementBankTabPopupCounter(Context context) {
        net.one97.paytm.bankCommon.h.b.z(context);
    }

    public static void setPasscodeSet(Context context, boolean z) {
        net.one97.paytm.bankCommon.h.b.a(context, z);
    }

    public static void setBankAccStatusNotApplied(Context context) {
        net.one97.paytm.bankCommon.h.b.j(context);
    }

    public static void setBankAccStatusProcessing(Context context) {
        net.one97.paytm.bankCommon.h.b.k(context);
    }

    public static void setBankAccStatusIssued(Context context) {
        net.one97.paytm.bankCommon.h.b.l(context);
    }

    public static void setBankAccStatus(Context context, int i2) {
        net.one97.paytm.bankCommon.h.b.a(context, i2);
    }

    public static void setGoToScreen(String str) {
        l.a().f19524a = str;
    }

    public static void setPDCOrderId(String str) {
        l.a().f19525b = str;
    }

    public static void decrementOpenBankAccCounterToOne(Context context) {
        net.one97.paytm.bankCommon.h.b.x(context);
    }

    public static void incrementOpenBankAccCounter(Context context) {
        net.one97.paytm.bankCommon.h.b.v(context);
    }

    public static int getOpenBankAccCounter(Context context) {
        return net.one97.paytm.bankCommon.h.b.w(context);
    }

    public static void launchAJRSetPasscode(Activity activity, int i2) {
        activity.startActivityForResult(new Intent(activity, AJRSetPasscode.class), i2);
    }
}
