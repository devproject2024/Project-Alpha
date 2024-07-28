package net.one97.paytm.nativesdk.Utils;

import android.text.TextUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.utility.CardType;

public class CardUIValidator {
    private BinResponse binResponse;

    public void setBinResponse(BinResponse binResponse2) {
        this.binResponse = binResponse2;
    }

    public boolean isExpiryRequired() {
        return !SDKConstants.MAESTRO.equalsIgnoreCase(getCardType()) && !SDKConstants.BAJAJ.equalsIgnoreCase(getCardType()) && !SDKConstants.BAJAJ_FINSERVER_CHANNEL_CODE.equalsIgnoreCase(getCardType());
    }

    public boolean isCVVRequired() {
        BinResponse binResponse2 = this.binResponse;
        if (binResponse2 == null || binResponse2.getBody() == null || this.binResponse.getBody().getBinDetail() == null) {
            return true;
        }
        return Boolean.valueOf(this.binResponse.getBody().getBinDetail().getCvvRequired()).booleanValue();
    }

    public boolean isCardValid(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (CardType.detect(str.replace("-", "")) != CardType.UNKNOWN) {
            return true;
        }
        if (getCardLength() != 0 && str.replace("-", "").trim().length() != getCardLength()) {
            return false;
        }
        String replace = str.replace("-", "");
        if (replace.length() < 14 || !SDKUtility.applyLuhnCheck(replace)) {
            return false;
        }
        return true;
    }

    public boolean isExpiryValid(String str) {
        if (!isExpiryRequired()) {
            return true;
        }
        if (str == null || str.length() < 5 || !SDKUtility.expiryValidate(str)) {
            return false;
        }
        return true;
    }

    public int getCardLength() {
        try {
            String channelCode = this.binResponse.getBody().getBinDetail().getChannelCode();
            char c2 = 65535;
            switch (channelCode.hashCode()) {
                case -1997400446:
                    if (channelCode.equals(SDKConstants.MASTER)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2044415:
                    if (channelCode.equals(SDKConstants.AMEX)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 2634817:
                    if (channelCode.equals(SDKConstants.VISA)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 62962004:
                    if (channelCode.equals(SDKConstants.BAJAJ)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 79325029:
                    if (channelCode.equals(SDKConstants.RUPAY)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1545480463:
                    if (channelCode.equals(SDKConstants.MAESTRO)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2047129693:
                    if (channelCode.equals(SDKConstants.DINERS)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return 15;
                case 1:
                    return 14;
                case 2:
                    return 23;
                case 3:
                case 4:
                case 5:
                case 6:
                    return 16;
                default:
                    return 23;
            }
        } catch (Exception unused) {
            return 23;
        }
    }

    public int getCVVLength() {
        return SDKConstants.AMEX.equalsIgnoreCase(getCardType()) ? 4 : 3;
    }

    public boolean isCvvValid(String str) {
        if (!isCVVRequired()) {
            return true;
        }
        if (TextUtils.isEmpty(str) || str.length() != getCVVLength()) {
            return false;
        }
        return true;
    }

    private String calculateCheckDigit(String str) {
        if (str == null) {
            return null;
        }
        int[] iArr = new int[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            iArr[i2] = Character.getNumericValue(str.charAt(i2));
        }
        for (int length = iArr.length - 1; length >= 0; length -= 2) {
            iArr[length] = iArr[length] + iArr[length];
            if (iArr[length] >= 10) {
                iArr[length] = iArr[length] - 9;
            }
        }
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        String valueOf = String.valueOf(i3 * 9);
        return valueOf.substring(valueOf.length() - 1);
    }

    public String getCardType() {
        BinResponse binResponse2 = this.binResponse;
        return (binResponse2 == null || binResponse2.getBody() == null || this.binResponse.getBody().getBinDetail() == null) ? "" : this.binResponse.getBody().getBinDetail().getChannelCode();
    }

    public String getBinPayMode(String str) {
        BinResponse binResponse2 = this.binResponse;
        if (!(binResponse2 == null || binResponse2.getBody() == null || this.binResponse.getBody().getBinDetail() == null)) {
            String paymentMode = this.binResponse.getBody().getBinDetail().getPaymentMode();
            if (!TextUtils.isEmpty(paymentMode)) {
                return paymentMode;
            }
        }
        return str;
    }

    public BinResponse getBinResponse() {
        return this.binResponse;
    }
}
