package com.paytmmall.clpartifact.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.j;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.HSVariantBottomSheetFragment;
import com.paytmmall.clpartifact.customViews.VSVariantBottomSheetFragment;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ImageUtility;

public class ViewUtils {
    public static boolean isGridTypeLarge(String str) {
        return !TextUtils.isEmpty(str) && str.toUpperCase().startsWith("LARGE");
    }

    public static void loadImage(String str, ImageView imageView, int i2) {
        if (!ImageUtility.isActivitydestroyed(imageView)) {
            b.a.C0750a a2 = b.a(imageView.getContext());
            a2.f43753a = str;
            b.a.C0750a.a(a2.a((Object) Integer.valueOf(i2)).b(Integer.valueOf(i2)), imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public static int convertDpToPixel(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static void loadImage(String str, ImageView imageView, Drawable drawable, Context context) {
        if (!ImageUtility.isActivityDestroyed(context)) {
            b.a.C0750a a2 = b.a(context);
            a2.f43753a = str;
            b.a.C0750a.a(a2.a((Object) drawable).b(drawable), imageView, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public static void setPromoText(TextView textView, CJRGridProduct cJRGridProduct) {
        String offerV1Text = StringUtils.getOfferV1Text(cJRGridProduct);
        String offerV1Subtext = StringUtils.getOfferV1Subtext(cJRGridProduct);
        boolean isOfferV1SingleRedemptionType = StringUtils.isOfferV1SingleRedemptionType(cJRGridProduct);
        String str = offerV1Text + " " + offerV1Subtext;
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(offerV1Text)) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(isOfferV1SingleRedemptionType ? -65536 : -16711936);
            int indexOf = str.indexOf(offerV1Text);
            spannableString.setSpan(foregroundColorSpan, indexOf, offerV1Text.length() + indexOf, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf, offerV1Text.length() + indexOf, 33);
        }
        if (!TextUtils.isEmpty(offerV1Subtext)) {
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(textView.getContext().getResources().getColor(R.color.clp_label1));
            int length = offerV1Text.length() + 1;
            spannableString.setSpan(foregroundColorSpan2, length, offerV1Subtext.length() + length, 33);
        }
        textView.setText(spannableString);
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static void performVariantClick(j jVar, String str, String str2, boolean z, CJRGridProduct cJRGridProduct) {
        Bundle bundle = new Bundle();
        bundle.putString(CLPConstants.PARENT_ID, cJRGridProduct.getParentID());
        bundle.putString(CLPConstants.PRODUCT_ID, cJRGridProduct.getProductID());
        bundle.putString("item_id", cJRGridProduct.getItemID());
        bundle.putString(CLPConstants.RENDER_URL, str2);
        bundle.putString(CLPConstants.GRID_URL, str);
        bundle.putString(CLPConstants.VARIANT_LABEL, StringUtils.getVariantLabel(cJRGridProduct));
        if (cJRGridProduct.getAddToCart() == 0 || !z) {
            HSVariantBottomSheetFragment hSVariantBottomSheetFragment = new HSVariantBottomSheetFragment();
            hSVariantBottomSheetFragment.setArguments(bundle);
            hSVariantBottomSheetFragment.setCancelable(true);
            hSVariantBottomSheetFragment.show(jVar, hSVariantBottomSheetFragment.getTag());
            return;
        }
        VSVariantBottomSheetFragment vSVariantBottomSheetFragment = new VSVariantBottomSheetFragment();
        vSVariantBottomSheetFragment.setArguments(bundle);
        vSVariantBottomSheetFragment.setCancelable(true);
        vSVariantBottomSheetFragment.show(jVar, vSVariantBottomSheetFragment.getTag());
    }
}
