package net.one97.paytm.nativesdk.emiSubvention.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.views.EMIPlanActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class EmiUtil {
    public static final int EMI_PLAN_REQUEST_CODE = 2048;

    public static void startEmiPlanActivity(Context context, String str, String str2, String str3, int i2, ArrayList<PaymentIntent> arrayList, String str4, String str5) {
        startEmiPlanActivity(context, str, str2, str3, i2, arrayList, str4, str5, false);
    }

    public static void startEmiPlanActivity(Context context, String str, String str2, String str3, int i2, ArrayList<PaymentIntent> arrayList, String str4, String str5, boolean z) {
        Intent intent = new Intent(context, EMIPlanActivity.class);
        intent.putExtra(EMIConstants.TENTURE_RESPONSE, str);
        intent.putExtra(EMIConstants.TOTAL_PRICE, str2);
        intent.putExtra(EMIConstants.PAYMENT_INTENT, arrayList);
        intent.putExtra(EMIConstants.FROM_VIEW, str3);
        intent.putExtra(EMIConstants.AND_OFFERS, str4);
        intent.putExtra(EMIConstants.SELECTED_PLAN_ID, str5);
        intent.putExtra(EMIConstants.IS_OR_FLOW, z);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i2);
        } else {
            Toast.makeText(context, "Unable to open plan screen", 1).show();
        }
    }

    public static void showErrorPopup(Activity activity, String str, String str2) {
        if (activity != null && !activity.isFinishing()) {
            try {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.error_bank_screen_popup);
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                TextView textView = (TextView) dialog.findViewById(R.id.txt_emi_availbale);
                TextView textView2 = (TextView) dialog.findViewById(R.id.otherEmiTxt);
                String string = activity.getString(R.string.emi_not_available_msg);
                String string2 = activity.getString(R.string.emi_unavailable_msg);
                if (TextUtils.isEmpty(str)) {
                    str = string;
                }
                if (!TextUtils.isEmpty(str2)) {
                    string2 = str2;
                }
                textView.setText(str);
                textView2.setText(string2);
                ((Button) dialog.findViewById(R.id.errorButton)).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public static void fetchTenures(BankData bankData, ISubventionProvider.IBankTenureListener iBankTenureListener, ArrayList<PaymentIntent> arrayList) {
        fetchTenuresWithOffers(bankData, iBankTenureListener, arrayList, (String) null);
    }

    public static void fetchTenuresWithOffers(BankData bankData, ISubventionProvider.IBankTenureListener iBankTenureListener, ArrayList<PaymentIntent> arrayList, String str) {
        JSONObject jSONObject = !TextUtils.isEmpty(str) ? getJSONObject(str) : null;
        if (DirectPaymentBL.getInstance().getSubventionProvider() != null) {
            DirectPaymentBL.getInstance().getSubventionProvider().fetchTenures(bankData, arrayList, jSONObject, iBankTenureListener);
        }
    }

    private static JSONObject getJSONObject(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        } catch (Exception e3) {
            LogUtility.printStackTrace(e3);
        }
        return null;
    }

    public static void validateEMIPlan(String str, String str2, ArrayList<PaymentIntent> arrayList, ISubventionProvider.IBankValidator iBankValidator, String str3) {
        if (DirectPaymentBL.getInstance().getSubventionProvider() != null) {
            DirectPaymentBL.getInstance().getSubventionProvider().validateTenure(str, str2, iBankValidator, arrayList, getJSONObject(str3));
        }
    }

    public static void showBottomSheet(Context context, String str, Double d2, String str2) {
        if (DirectPaymentBL.getInstance().getSubventionProvider() != null) {
            DirectPaymentBL.getInstance().getSubventionProvider().showBottomSheet(context, str, d2, str2);
        }
    }

    public static boolean isAuthError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        int statusCode = apiResponseError != null ? apiResponseError.getStatusCode() : 0;
        return statusCode == 401 || statusCode == 403 || statusCode == 410;
    }
}
