package com.paytm.business.merchantprofile.common.utility;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.y;
import java.util.regex.Pattern;

public class PatternsUtil {
    public static final String AADHAAR_DELIMITER = "-";
    public static final int AADHAAR_LENGTH = 12;
    public static final String ADDRESS_PATTERN = "^[()\\[\\],\\w\\s#\\/\\.'-]+$";
    public static final int BANK_ACCOUNT_NUM_MAX_LENGTH = 18;
    public static final int BANK_ACCOUNT_NUM_MIN_LENGTH = 9;
    public static final String BANK_ACCOUNT_PATTERN = "^[0-9a-zA-Z]+$";
    public static final String BUSINESS_DISPLAY_NAME_PATTEARN = "^[a-zA-Z0-9\\s]+$";
    public static final int BUSINESS_NAME_MAX_LENGTH = 50;
    public static final int BUSINESS_NAME_MIN_LENGTH = 2;
    public static final String BUSINESS_NAME_PATTERN = "^[-A-Za-z0-9.'@:?!&()$#^\\s]+$";
    public static final String CITY_NAME = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)[(*$)]";
    public static final int EMAIL_ID_MAX_LENGTH = 254;
    public static final int GSTIN_LENGTH = 15;
    public static final String GSTIN_PATTERN = "^[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[A-Z0-9]{1}[zZ]{1}[A-Za-z0-9]{1}$";
    public static final int IFSC_CODE_LENGTH = 11;
    public static final int MAX_NAME_LENGTH = 100;
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MOBILE_NUMBER_LENGTH = 10;
    public static final String NAME_IN_ADDRESS = "[^a-z ]";
    public static final String NAME_IN_PAN_AADHAAR = "^[a-zA-Z.\\s']{2,100}$";
    public static final int PAN_LENGTH = 10;
    public static final String PAN_PATTERN = "[a-zA-Z]{3}[pP][a-zA-Z][0-9]{4}[a-zA-Z]";
    public static final String PATTERN_IFSC_CODE = "^[a-zA-Z]{4}[0]{1}[a-zA-Z0-9]{6}$";
    public static final int PINCODE_LENGTH = 6;
    public static final String PINCODE_PATTERN = "^[1-9][0-9]{5}$";

    public static boolean isPatternMatched(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    public static boolean isValidIFSC(String str) {
        return isPatternMatched("^[a-zA-Z]{4}[0]{1}[a-zA-Z0-9]{6}$", str);
    }

    public static boolean isValidAccountNumber(String str) {
        return isPatternMatched("^[0-9a-zA-Z]+$", str);
    }

    public static boolean isValidAddress(String str) {
        return isPatternMatched("^[()\\[\\],\\w\\s#\\/\\.'-]+$", str);
    }

    public static boolean isValidBusinessName(String str) {
        return isPatternMatched("^[-A-Za-z0-9.'@:?!&()$#^\\s]+$", str);
    }

    public static boolean isValidBusinessDisplayName(String str) {
        return !TextUtils.isEmpty(str) && isPatternMatched("^[a-zA-Z0-9\\s]+$", str);
    }

    public static boolean isValidPAN(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 10 && isPatternMatched("[a-zA-Z]{3}[pP][a-zA-Z][0-9]{4}[a-zA-Z]", str);
    }

    public static boolean isValidAadhaar(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replaceAll = str.replaceAll("-", "");
        if (replaceAll.length() != 12) {
            return false;
        }
        for (int i2 = 0; i2 < replaceAll.length(); i2++) {
            if (!Character.isDigit(replaceAll.charAt(i2))) {
                return false;
            }
        }
        return y.a(replaceAll);
    }

    public static boolean isValidPinCode(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 6 && isPatternMatched("^[1-9][0-9]{5}$", str);
    }

    public static boolean isValidGSTIN(String str, boolean z) {
        return z ? !TextUtils.isEmpty(str) && str.length() == 15 && isPatternMatched("^[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[A-Z0-9]{1}[zZ]{1}[A-Za-z0-9]{1}$", str) && sdMerchantCheck(str) : !TextUtils.isEmpty(str) && str.length() == 15 && isPatternMatched("^[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[A-Z0-9]{1}[zZ]{1}[A-Za-z0-9]{1}$", str);
    }

    public static boolean sdMerchantCheck(String str) {
        return str.length() > 5 && str.charAt(5) == 'P';
    }

    public static boolean isValidNamePanAadhaar(String str) {
        return !TextUtils.isEmpty(str) && isPatternMatched("^[a-zA-Z.\\s']{2,100}$", str);
    }

    public static boolean isValidPassword(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!z || str.length() >= 4) {
            return true;
        }
        return false;
    }

    public static boolean isValidMobileNo(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(AppConstants.MOB_NO_REG_EX_NEW).matcher(str).matches();
    }

    public static boolean isValidEmail(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile(AppConstants.EMAIL_REG_EX).matcher(str).find();
    }

    public static boolean isValidNameInAddress(String str) {
        return !TextUtils.isEmpty(str) && Pattern.compile("[^a-z ]", 2).matcher(str).find();
    }

    public static boolean isValidCityName(String str) {
        return !TextUtils.isEmpty(str) && isPatternMatched("^[a-zA-Z.\\s']{2,100}$", str);
    }
}
