package com.paytmmall.clpartifact.common;

import android.text.TextUtils;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class StringUtils {
    public static boolean isList(String str) {
        return ViewHolderFactory.getGridSpan(str) == 1;
    }

    public static boolean isNonVegFood(CJRGridProduct.Attribute attribute) {
        return attribute != null && CLPConstants.NON_VEG.equalsIgnoreCase(attribute.getVegNonveg());
    }

    public static String getOfferText(String str) {
        return str + "% Off";
    }

    public static String getOfferV1Text(CJRGridProduct cJRGridProduct) {
        return (cJRGridProduct == null || cJRGridProduct.getPromoData() == null || cJRGridProduct.getPromoData().isEmpty() || cJRGridProduct.getPromoData().get(0) == null || cJRGridProduct.getPromoData().get(0).getOffer_v1() == null) ? "" : cJRGridProduct.getPromoData().get(0).getOffer_v1().getmText();
    }

    public static String getOfferV1Text(Item item) {
        try {
            return item.getPromoData().get(0).getOffer_v1().getmText();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public static String getOfferV1Subtext(Item item) {
        try {
            return item.getPromoData().get(0).getOffer_v1().getmSubtext();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public static String getOfferV1Subtext(CJRGridProduct cJRGridProduct) {
        return (cJRGridProduct == null || cJRGridProduct.getPromoData() == null || cJRGridProduct.getPromoData().isEmpty() || cJRGridProduct.getPromoData().get(0) == null || cJRGridProduct.getPromoData().get(0).getOffer_v1() == null) ? "" : cJRGridProduct.getPromoData().get(0).getOffer_v1().getmSubtext();
    }

    public static boolean isOfferV1SingleRedemptionType(Item item) {
        try {
            return CLPConstants.SINGLE_REDEMPTION.equalsIgnoreCase(item.getPromoData().get(0).getOffer_v1().getmType());
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean isOfferV1SingleRedemptionType(CJRGridProduct cJRGridProduct) {
        if (cJRGridProduct == null || cJRGridProduct.getPromoData() == null || cJRGridProduct.getPromoData().isEmpty() || cJRGridProduct.getPromoData().get(0) == null || cJRGridProduct.getPromoData().get(0).getOffer_v1() == null) {
            return false;
        }
        return CLPConstants.SINGLE_REDEMPTION.equalsIgnoreCase(cJRGridProduct.getPromoData().get(0).getOffer_v1().getmType());
    }

    public static String toQuery(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Map.Entry next : hashMap.entrySet()) {
            if (i2 == 0) {
                sb.append(String.format("?%1$s=%2$s", new Object[]{next.getKey(), next.getValue()}));
            } else {
                sb.append(String.format("&%1$s=%2$s", new Object[]{next.getKey(), next.getValue()}));
            }
            i2++;
        }
        return sb.toString();
    }

    public static String getRupeesFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        currencyInstance.setMaximumFractionDigits(0);
        try {
            return currencyInstance.format((long) ((int) Float.parseFloat(str)));
        } catch (Exception unused) {
            return currencyInstance.format(0);
        }
    }

    public static String getDiscountPerc(String str) {
        return "-" + str + "%";
    }

    public static String getVariantLabel(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getVariant().getDimensions().get(0).getLabel();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public static String join(List<String> list, String str) {
        return TextUtils.join(str, list);
    }

    public static String getDescription(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getAttribute().getDescription();
        } catch (NullPointerException unused) {
            return "";
        }
    }

    public static boolean hasOfferV1(CJRGridProduct cJRGridProduct) {
        try {
            return !TextUtils.isEmpty(cJRGridProduct.getPromoData().get(0).getOffer_v1().getmText());
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
        }
    }
}
