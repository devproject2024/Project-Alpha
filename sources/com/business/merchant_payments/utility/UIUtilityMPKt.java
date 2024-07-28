package com.business.merchant_payments.utility;

import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.utility.MPConstants;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.g.b.k;

public final class UIUtilityMPKt {
    public static final void lock(AppBarLayout appBarLayout) {
        k.d(appBarLayout, "$this$lock");
        ViewGroup.LayoutParams layoutParams = appBarLayout.getLayoutParams();
        if (layoutParams != null) {
            CoordinatorLayout.Behavior a2 = ((CoordinatorLayout.d) layoutParams).a();
            if (a2 != null) {
                ((CustomScrollBehaviourMP) a2).setShouldScroll(false);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.utility.CustomScrollBehaviourMP");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    public static final void unlock(AppBarLayout appBarLayout) {
        k.d(appBarLayout, "$this$unlock");
        ViewGroup.LayoutParams layoutParams = appBarLayout.getLayoutParams();
        if (layoutParams != null) {
            CoordinatorLayout.Behavior a2 = ((CoordinatorLayout.d) layoutParams).a();
            if (a2 != null) {
                ((CustomScrollBehaviourMP) a2).setShouldScroll(true);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.utility.CustomScrollBehaviourMP");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    public static /* synthetic */ String getDisplayBankAccountNumberMP$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 8;
        }
        if ((i4 & 4) != 0) {
            i3 = 4;
        }
        return getDisplayBankAccountNumberMP(str, i2, i3);
    }

    public static final String getDisplayBankAccountNumberMP(String str, int i2, int i3) {
        k.d(str, "bankAccountNumber");
        if (i2 >= i3) {
            if (str.length() > i2) {
                str = str.substring(str.length() - i2, str.length());
                k.b(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            StringBuilder sb = new StringBuilder(str);
            int i4 = 0;
            int length = str.length();
            if (length >= 0) {
                while (true) {
                    if ((i4 - str.length()) + i3 < 0) {
                        sb.setCharAt(i4, '*');
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                }
            }
            String sb2 = sb.toString();
            k.b(sb2, "builder.toString()");
            return sb2;
        }
        throw new IllegalArgumentException("noOfUnmaskedChars should be less then totalNumberOfCharsToShow");
    }

    public static final String getEventLabelonDateSelet(String str) {
        k.d(str, "identifier");
        switch (str.hashCode()) {
            case -1778017348:
                return str.equals(AppConstants.CUSTOM_DATE) ? "Custom" : "";
            case -1621979774:
                if (str.equals(AppConstants.YESTERDAY)) {
                    return "Yesterday";
                }
                return "";
            case 3645428:
                if (str.equals("week")) {
                    return "This Week";
                }
                return "";
            case 104080000:
                if (str.equals(MPConstants.PaymentSummaryRange.MONTH)) {
                    return "This Month";
                }
                return "";
            case 110534465:
                if (str.equals("today")) {
                    return "Today";
                }
                return "";
            default:
                return "";
        }
    }
}
