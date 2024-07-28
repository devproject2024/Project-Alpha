package net.one97.paytm.upi.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.g.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.contactsSdk.database.ContactColumn;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiConstants;

public class UpiUtils {
    public static final String AUTHENTICATION_FAILURE_401 = "401";
    private static final String AUTHENTICATION_FAILURE_403 = "403";
    private static final String AUTHENTICATION_FAILURE_410 = "410";

    public static String getAppId(Context context) {
        return "net.one97.paytm";
    }

    public static double getMaxMandateAmountAllowed(Context context) {
        return 100000.0d;
    }

    public static String getVpaShareSmartLink() {
        return "http://m.p-y.tm/upipay";
    }

    public static boolean isPaytmFirstApp() {
        return false;
    }

    private UpiUtils() {
    }

    public static void addFragmentToActivity(j jVar, Fragment fragment, int i2) {
        f.a(jVar);
        f.a(fragment);
        q a2 = jVar.a();
        a2.a(i2, fragment, fragment.getClass().getSimpleName());
        a2.c();
    }

    public static void replaceFragmentToActivity(j jVar, Fragment fragment, int i2, boolean z) {
        f.a(jVar);
        f.a(fragment);
        q a2 = jVar.a();
        if (z) {
            a2.a(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
        }
        a2.b(i2, fragment, fragment.getClass().getSimpleName());
        a2.c();
    }

    public static void replaceFragmentToActivity(j jVar, Fragment fragment, int i2) {
        replaceFragmentToActivity(jVar, fragment, i2, false);
    }

    public static String removeNewLine(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replace(StringUtility.NEW_LINE, "").replace("\r", "");
        }
        return "";
    }

    public static boolean validateCardNum(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 6) {
            return false;
        }
        return true;
    }

    public static boolean validateCardMonth(String str) {
        if (!TextUtils.isEmpty(str)) {
            int parseInt = Integer.parseInt(str);
            if (str.length() == 2 && parseInt <= 12 && parseInt > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateCardYear(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Integer.parseInt(str);
        if (str.length() != 2) {
            return false;
        }
        return true;
    }

    public static boolean validateCardDate(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
            simpleDateFormat.setLenient(false);
            return !simpleDateFormat.parse(str).before(new Date());
        } catch (ParseException unused) {
            return false;
        }
    }

    public static String getEncryptedReferenceNumber(Context context) {
        String str = getDeviceId(context) + System.currentTimeMillis();
        try {
            str = Base64.encodeToString(new CryptLib().SHA256(str), 2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str.toLowerCase();
    }

    public static boolean isMultiSimDevice(Context context) {
        if (Build.VERSION.SDK_INT < 22) {
            return false;
        }
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
        if (subscriptionManager.getActiveSubscriptionInfoList() == null || subscriptionManager.getActiveSubscriptionInfoList().size() <= 1) {
            return false;
        }
        return true;
    }

    public static List<SubscriptionInfo> getAllCarrier(Context context) {
        if (Build.VERSION.SDK_INT >= 22) {
            return ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
        }
        return null;
    }

    public static String getCarrierName(Context context, int i2) {
        List<SubscriptionInfo> allCarrier;
        if (i2 < 0) {
            i2 = 1;
        }
        if (Build.VERSION.SDK_INT < 22 || (allCarrier = getAllCarrier(context)) == null) {
            return null;
        }
        for (SubscriptionInfo next : allCarrier) {
            if (i2 == next.getSubscriptionId()) {
                if (!TextUtils.isEmpty(next.getCarrierName())) {
                    return next.getCarrierName().toString();
                }
                return null;
            }
        }
        return null;
    }

    public static String getPaytmVpa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + "@paytm";
    }

    public static String getMobile(Context context) {
        String str = i.a().f66981b;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "91".concat(String.valueOf(str));
    }

    public static String getChannel() {
        try {
            return i.a().j;
        } catch (IllegalStateException unused) {
            return "paytm";
        }
    }

    public static String getRandomPaytmVpa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        int nextInt = new Random().nextInt(99);
        sb.append("a");
        sb.append(String.valueOf(nextInt));
        sb.append("@paytm");
        return sb.toString();
    }

    public static String getUpiSequenceNo() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        int length = replace.length();
        if (length >= 32) {
            replace = replace.substring(0, 32);
        } else {
            int i2 = 32 - length;
            for (int i3 = 1; i3 <= i2; i3++) {
                replace = replace + (i3 + 97);
            }
        }
        return "PTM".concat(String.valueOf(replace));
    }

    public static UpiConstants.UpiVpaValidationError isValidVpa(String str) {
        if (TextUtils.isEmpty(str)) {
            return UpiConstants.UpiVpaValidationError.EMPTY_VPA;
        }
        if (str.length() > 249) {
            return UpiConstants.UpiVpaValidationError.MAX_LENGTH_BREACH;
        }
        if (str.matches("[0-9]+") && str.length() >= 10 && str.length() <= 12) {
            return UpiConstants.UpiVpaValidationError.ALPHANUMERIC_ERROR;
        }
        if (!str.matches("[a-zA-Z0-9.-]+")) {
            return UpiConstants.UpiVpaValidationError.INVALID_CHARS;
        }
        return null;
    }

    public static String buildVpa(String str) {
        return (str + "@paytm").toLowerCase();
    }

    public static boolean isAmountValid(String str) {
        try {
            if (Double.compare(Double.parseDouble(str), 0.0d) <= 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String convertToTwoPlaces(String str) {
        try {
            return new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(str));
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getMonthNameAndYear(String str) {
        try {
            return new SimpleDateFormat("MMMM yyyy").format(new SimpleDateFormat("dd MMM yyyy, hh:mm a").parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String formatUpiDateTime(String str) {
        try {
            return new SimpleDateFormat("dd MMM, hh:mm a").format(new SimpleDateFormat("dd MMM yyyy, hh:mm a").parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String formatUpiDateTimeForDetail(String str) {
        try {
            return new SimpleDateFormat("hh:mm a, dd MMM yyyy").format(new SimpleDateFormat("dd MMM yyyy, hh:mm a").parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String getCustomerName(Context context) {
        String str = i.a().f66983d;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = i.a().f66985f;
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = i.a().f66986g;
        return !TextUtils.isEmpty(str3) ? str3 : "PaytmUser";
    }

    public static String getFormattedExpiryDate(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "-");
        String substring = stringTokenizer.nextToken().substring(2);
        String nextToken = stringTokenizer.nextToken();
        return nextToken + substring;
    }

    public static String getDeviceId(Context context) {
        return UpiAppUtils.getDeviceID(context);
    }

    public static String getCurrentDateAndTime() {
        return new SimpleDateFormat("hh:mm a, dd MMM yyyy").format(new Date(System.currentTimeMillis())).replace("AM", "am").replace("PM", "pm");
    }

    public static void setStatusBarColor(int i2, Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(i2);
            }
        }
    }

    public static long getMinutesfromDate(Date date) {
        try {
            long time = date.getTime() - new Date().getTime();
            long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
            TimeUnit.MILLISECONDS.toHours(time);
            TimeUnit.MILLISECONDS.toDays(time);
            return minutes;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 30;
        }
    }

    public static boolean isSimAvailable(Context context) {
        return ((TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER)).getSimState() == 5;
    }

    public static double getMinAmountAllowed(Context context) {
        try {
            return Double.parseDouble(UpiGTMLoader.getInstance().getUpiSendMoneyLowerLimit());
        } catch (NumberFormatException unused) {
            return 1.0d;
        }
    }

    public static double getMaxAmountAllowed(Context context) {
        try {
            return Double.parseDouble(UpiGTMLoader.getInstance().getUpiSendMoneyP2PUpperLimit());
        } catch (NumberFormatException unused) {
            return 100000.0d;
        }
    }

    public static double getUPIP2MMaxAmountAllowed(Context context) {
        try {
            return Double.parseDouble(UpiGTMLoader.getInstance().getUpiSendMoneyP2MUpperLimit());
        } catch (NumberFormatException unused) {
            return 200000.0d;
        }
    }

    public static double getUpiIMPSSwitchLimit(Context context) {
        try {
            return Double.parseDouble(UpiGTMLoader.getInstance().getUpiImpsSwitchLimit());
        } catch (NumberFormatException unused) {
            return 100000.0d;
        }
    }

    public static void sendReloadPassbookUpiBroadcast(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(UpiConstants.EXTRA_ACTION_RELOAD_UPI);
        intent.putExtra(UpiConstants.EXTRA_RELOAD_UPI_TRANSACTIONS, z);
        intent.putExtra(UpiConstants.EXTRA_RELOAD_UPI_PENDING_REQUESTS, z2);
        a.a(context).a(intent);
    }

    public static String maskNumber(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length() - 4; i2++) {
            sb.append("X");
        }
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    public static String getNameInitials(String str) {
        String str2;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String trim = str.trim();
        Pattern compile = Pattern.compile("[a-zA-z]");
        String[] split = trim.split(" ");
        int length = split.length;
        if (length != 1 || TextUtils.isEmpty(split[0])) {
            if (length >= 2) {
                if (!TextUtils.isEmpty(split[0])) {
                    str2 = String.valueOf(split[0].charAt(0));
                    if (str2.matches("\\d+")) {
                        return str3;
                    }
                } else {
                    str2 = str3;
                }
                if (TextUtils.isEmpty(split[1]) || !compile.matcher(split[1]).find()) {
                    str3 = str2;
                } else {
                    String valueOf = String.valueOf(split[1].charAt(0));
                    if (valueOf.matches("\\d+")) {
                        return str3;
                    }
                    str3 = str2 + valueOf;
                }
            }
        } else if (String.valueOf(split[0].charAt(0)).matches("\\d+")) {
            return str3;
        } else {
            str3 = String.valueOf(split[0].charAt(0));
        }
        return str3.toUpperCase();
    }

    public static void startWalletLoader(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation(R.raw.payments_loader);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.playAnimation();
    }

    public static void stopWalletLoader(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public static Intent getUpiLandingPageActivityIntent(Context context) {
        Intent intent = new Intent(context, UPISettingsActivity.class);
        intent.putExtra(UpiConstants.INACTIVE_USER, true);
        intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
        return intent;
    }

    public static Intent getUpiLandingPageActivityIntentWithDeepLink(Context context, Uri uri) {
        Intent intent = new Intent(context, UpiLandingPageActivity.class);
        intent.putExtra(UpiConstants.INACTIVE_USER, true);
        intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, uri.toString());
        return intent;
    }

    public static Intent getUpiLandingPageActivityIntentWithoutRedirection(Context context) {
        Intent intent = new Intent(context, UPISettingsActivity.class);
        intent.putExtra(UpiConstants.INACTIVE_USER, true);
        return intent;
    }

    public static boolean isInActiveProfileExist(Context context) {
        return PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true);
    }

    public static boolean isUpiUser(Context context) {
        return PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b("is_upi_user", false, true);
    }

    public static String getFormattedAccountNumText(Context context, String str) {
        return String.format(context.getString(R.string.money_transfer_acc_no_with_placeholder_without_bold), new Object[]{UpiAppUtils.insertSpaceAfterInterval(maskNumber(str), 4)});
    }

    public static String getMandateFormattedDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(new Date(Long.parseLong(str)));
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public static String getMandateFormattedDateTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.ENGLISH).format(new Date(Long.parseLong(str)));
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public static String convertDateFromTo(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2, Locale.ENGLISH).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void addBalanceSheet(String str, String str2, j jVar) {
        net.one97.paytm.upi.profile.view.a aVar = new net.one97.paytm.upi.profile.view.a();
        aVar.f68189b = str2;
        aVar.f68188a = str;
        aVar.show(jVar, "AccountBalanceBreakupSheet");
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static boolean isAuthenticationFailure(String str) {
        if (str != null) {
            return str.equalsIgnoreCase(AUTHENTICATION_FAILURE_401) || str.equalsIgnoreCase(AUTHENTICATION_FAILURE_403) || str.equalsIgnoreCase(AUTHENTICATION_FAILURE_410);
        }
        return false;
    }

    public static void logout(Context context) {
        if (b.a()) {
            g.a().f67825c = true;
        }
    }

    public static String getMobileNumbersFromSim(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            if (Build.VERSION.SDK_INT >= 22) {
                List<SubscriptionInfo> allCarrier = getAllCarrier(context);
                for (int i2 = 0; i2 < allCarrier.size(); i2++) {
                    SubscriptionInfo subscriptionInfo = allCarrier.get(i2);
                    String charSequence = subscriptionInfo.getCarrierName().toString();
                    String number = subscriptionInfo.getNumber();
                    sb.append("sim" + (subscriptionInfo.getSimSlotIndex() + 1) + "=" + charSequence + ";number=" + number);
                    if (i2 < allCarrier.size() - 1) {
                        sb.append(";;");
                    }
                }
            }
        } catch (Exception e2) {
            i.a().m.a("RegistrationProgressFragment", "mobile_number_capture", (Throwable) e2);
        }
        return sb.toString();
    }

    public static void showNoNetworkErrorDialog(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            com.paytm.utility.b.b((Context) activity, "No Internet Connection", "We can not detect any internet connectivity. Please check your internet connection and try again.");
        }
    }

    public static void handleCheckBalanceError(Activity activity, n.b bVar) {
        if (activity != null && !activity.isFinishing()) {
            if (bVar == n.b.NO_NETWORK) {
                CustomDialog.showAlert(activity, activity.getString(R.string.no_connection), activity.getString(R.string.no_internet));
            } else if (bVar == n.b.INCORRECT_MPIN) {
                Toast.makeText(activity, R.string.upi_incorrect_mpin, 1).show();
            } else if (bVar == n.b.UNABLE_TO_CHECK_BALANCE) {
                Toast.makeText(activity, R.string.upi_check_balance_error, 1).show();
            } else if (bVar == n.b.SESSION_TIMEOUT) {
                k kVar = i.a().k;
                new UpiCustomVolleyError();
                kVar.e(activity);
            } else if (bVar != n.b.ERROR_BACK_PRESSED) {
                Toast.makeText(activity, R.string.upi_some_went_wrong, 1).show();
            }
        }
    }

    public static String getAccountNoFormat(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return str + "   XX " + str2.substring(str2.length() - 4);
    }

    public static String getFormattedMaskedAcc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return " XX " + str.substring(str.length() - 4);
    }

    public static void clearReferralCode(Context context) {
        PaytmUpiPrefUtil.getPref(context.getApplicationContext()).a(UpiConstants.EXTRA_UPI_REFER_DEEPLINK, true);
    }

    public static String getValidityFromDateForMandates(Context context, String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        try {
            String mandateFormattedDate = getMandateFormattedDate(String.valueOf(simpleDateFormat.parse(str).getTime()));
            String mandateFormattedDate2 = getMandateFormattedDate(String.valueOf(simpleDateFormat.parse(str2).getTime()));
            return context.getString(R.string.upi_mandate_valid_to, new Object[]{mandateFormattedDate, mandateFormattedDate2});
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean doShowSecurityPopUp(Context context) {
        return PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b(UpiConstants.PREF_UPI_SECURITY_POPUP, true, false);
    }

    public static boolean isP2MIntentFlow(Uri uri) {
        if (uri == null) {
            return false;
        }
        String uri2 = uri.toString();
        return !TextUtils.isEmpty(uri2) && uri2.contains(UpiConstants.URI_IS_ORDER_CREATED_KEY) && uri2.contains("mid");
    }

    public static void showReadPhoneStatePermissionDialog(Activity activity, Boolean bool, CustomDialog.OkClickListener okClickListener, CustomDialog.OnDialogDismissListener onDialogDismissListener) {
        if (activity != null && !activity.isFinishing()) {
            CustomDialog.showAlert((Context) activity, activity.getString(R.string.upi_mandatory_permission_denied), activity.getString(R.string.upi_read_phone_state_permission_text_new), true, activity.getString(R.string.upi_grant_permission), okClickListener, onDialogDismissListener);
        }
    }

    public static void showTakeToSettingsPermissionDialog(Activity activity, Boolean bool, CustomDialog.OkClickListener okClickListener, CustomDialog.OnDialogDismissListener onDialogDismissListener) {
        if (activity != null && !activity.isFinishing()) {
            CustomDialog.showAlert((Context) activity, activity.getString(R.string.upi_mandatory_permission_denied), activity.getString(R.string.upi_read_phone_state_settings_text), true, activity.getString(R.string.upi_go_to_settings), okClickListener, onDialogDismissListener);
        }
    }

    public static void copyTextToClipboard(Activity activity, String str, String str2) {
        if (activity != null && !activity.isFinishing()) {
            ((ClipboardManager) activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
        }
    }

    public static boolean isAtleastLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static void setBankIcon(ImageView imageView, BankAccountDetails.BankAccount bankAccount, Context context) {
        String bankLogoUrl = bankAccount.getBankLogoUrl();
        if (bankLogoUrl == null || !URLUtil.isValidUrl(bankLogoUrl)) {
            setBankIcon(imageView, bankAccount.getIfsc(), imageView.getContext());
        } else {
            w.a().a(bankLogoUrl).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        }
    }

    public static void setBankIcon(ImageView imageView, String str, Context context) {
        if (!TextUtils.isEmpty(str) && str.contains("ICIC")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.icici_bank_logo));
        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(androidx.core.content.b.a(context, R.drawable.ic_bhim));
        } else if (URLUtil.isValidUrl(str)) {
            w.a().a(str).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        } else if (!TextUtils.isEmpty(str)) {
            w.a().a(UpiRequestBuilder.getBankIconUrl(context.getApplicationContext(), str)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        }
    }

    public static String maskAccNumberWithSpace(String str) {
        return !TextUtils.isEmpty(str) ? UpiAppUtils.insertSpaceAfterInterval(maskNumber(str), 4) : str;
    }

    public static boolean isPPBCustomer(Context context) {
        if (context != null) {
            return PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b("ppb_customer", false, true);
        }
        return false;
    }

    public static boolean doShowScanAndPayPopUp(Context context) {
        return PaytmUpiPrefUtil.getPref(context.getApplicationContext()).b(UpiConstants.PREF_UPI_SCAN_PAY_POPUP, true, false);
    }

    public static void shareSuccessfulTransaction(Activity activity, View view, String str, String str2, String str3, int i2) {
        final String str4 = str;
        final String str5 = str2;
        final View view2 = view;
        final Activity activity2 = activity;
        final String str6 = str3;
        final int i3 = i2;
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/png");
                    intent.putExtra("android.intent.extra.SUBJECT", str4);
                    intent.putExtra("android.intent.extra.TEXT", str5);
                    Bitmap viewToBitmap = UpiUtils.viewToBitmap(view2);
                    Calendar instance = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                    String insertImage = MediaStore.Images.Media.insertImage(activity2.getContentResolver(), viewToBitmap, activity2.getString(R.string.title) + " - " + simpleDateFormat.format(instance.getTime()), (String) null);
                    if (!TextUtils.isEmpty(insertImage)) {
                        intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                        Intent createChooser = Intent.createChooser(intent, str6);
                        if (createChooser.resolveActivity(activity2.getPackageManager()) != null) {
                            activity2.startActivity(createChooser);
                        } else {
                            Toast.makeText(activity2, activity2.getString(R.string.no_app_found), 1).show();
                        }
                        view2.setVisibility(i3);
                        viewToBitmap.recycle();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
            }
        }, 200);
    }

    public static Bitmap viewToBitmap(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        view.draw(canvas);
        return createBitmap;
    }

    public static void openPlayStorePage(Activity activity) {
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            String packageName = activity.getApplicationContext().getPackageName();
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(String.valueOf(packageName)))));
            } catch (ActivityNotFoundException unused) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=".concat(String.valueOf(packageName)))));
            }
        }
    }
}
