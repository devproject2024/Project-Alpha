package com.business.merchant_payments.common.utility;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.widget.HTMLTextView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.e;
import com.squareup.picasso.w;

public class DataBindingUtility {
    public static final String TAG = "DataBindingUtility";

    public static void loadImage(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            w.a().a(str).a(imageView, (e) null);
        }
    }

    public static void bitmapSrc(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void loadUrl(WebView webView, String str) {
        LogUtility.i(TAG, "loadUrl");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(str);
    }

    public static void movementMethod(TextView textView, MovementMethod movementMethod) {
        textView.setMovementMethod(movementMethod);
    }

    public static void errorText(TextInputLayout textInputLayout, String str) {
        if (TextUtils.isEmpty(str)) {
            textInputLayout.setErrorEnabled(false);
        } else {
            textInputLayout.setErrorEnabled(true);
        }
        textInputLayout.setError(str);
    }

    public static void bindSrcCompat(ImageView imageView, int i2) {
        imageView.setImageResource(i2);
    }

    public static void bindSrcCompat(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    public static void bindOnUrlClick(HTMLTextView hTMLTextView, HTMLTextView.OnUrlClickListener onUrlClickListener) {
        hTMLTextView.setUrlClickListener(onUrlClickListener);
    }

    public static void bindTextColor(TextView textView, int i2) {
        textView.setTextColor(b.c(textView.getContext(), i2));
    }

    public static void bindVisibility(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static void bindViewVisibility(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    public static void setMarginTop(View view, float f2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, Math.round(f2), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setLayoutParams(marginLayoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[Catch:{ Exception -> 0x0069 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A[Catch:{ Exception -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setAmountInTextView(android.widget.TextView r8, java.lang.String r9) {
        /*
            java.lang.String r0 = ""
            if (r9 != 0) goto L_0x0008
            r8.setText(r0)
            return
        L_0x0008:
            android.graphics.Typeface r1 = r8.getTypeface()     // Catch:{ Exception -> 0x0069 }
            r2 = 0
            if (r1 == 0) goto L_0x0018
            android.graphics.Typeface r1 = r8.getTypeface()     // Catch:{ Exception -> 0x0069 }
            if (r1 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = r2
            goto L_0x001f
        L_0x0018:
            java.lang.String r1 = "sans-serif-medium"
            r3 = 1
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3)     // Catch:{ Exception -> 0x0069 }
        L_0x001f:
            android.graphics.Typeface r3 = r8.getTypeface()     // Catch:{ Exception -> 0x0069 }
            r4 = 0
            if (r3 == 0) goto L_0x002c
            android.graphics.Typeface r3 = r8.getTypeface()     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x0032
        L_0x002c:
            java.lang.String r2 = "sans-serif-light"
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r4)     // Catch:{ Exception -> 0x0069 }
        L_0x0032:
            java.lang.String r3 = "\\."
            java.lang.String[] r3 = r9.split(r3)     // Catch:{ Exception -> 0x0069 }
            int r5 = r3.length     // Catch:{ Exception -> 0x0069 }
            if (r5 > 0) goto L_0x003c
            return
        L_0x003c:
            r3 = r3[r4]     // Catch:{ Exception -> 0x0069 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0069 }
            int r5 = r9.length()     // Catch:{ Exception -> 0x0069 }
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x0069 }
            r6.<init>(r9)     // Catch:{ Exception -> 0x0069 }
            com.business.merchant_payments.common.utility.CustomTypeFaceSpan r7 = new com.business.merchant_payments.common.utility.CustomTypeFaceSpan     // Catch:{ Exception -> 0x0069 }
            r7.<init>(r0, r1)     // Catch:{ Exception -> 0x0069 }
            r1 = 34
            r6.setSpan(r7, r4, r3, r1)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "."
            boolean r9 = r9.contains(r4)     // Catch:{ Exception -> 0x0069 }
            if (r9 == 0) goto L_0x0065
            com.business.merchant_payments.common.utility.CustomTypeFaceSpan r9 = new com.business.merchant_payments.common.utility.CustomTypeFaceSpan     // Catch:{ Exception -> 0x0069 }
            r9.<init>(r0, r2)     // Catch:{ Exception -> 0x0069 }
            r6.setSpan(r9, r3, r5, r1)     // Catch:{ Exception -> 0x0069 }
        L_0x0065:
            r8.setText(r6)     // Catch:{ Exception -> 0x0069 }
            return
        L_0x0069:
            r8 = move-exception
            r8.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.common.utility.DataBindingUtility.setAmountInTextView(android.widget.TextView, java.lang.String):void");
    }

    public static void setTextWithParamsAndImage(TextView textView, String str, String[] strArr, boolean z, int i2) {
        try {
            String format = String.format(str, strArr);
            if (z) {
                textView.setText(AppUtility.getFormattedTextWithImage(new StringBuilder(format), i2, textView.getContext()));
            } else {
                textView.setText(format);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void underlineText(TextView textView, boolean z) {
        try {
            textView.setPaintFlags(textView.getPaintFlags() | 8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setTextWithParams(TextView textView, int i2, String[] strArr) {
        try {
            textView.setText(String.format(textView.getContext().getString(i2), strArr));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setTextWithParams(TextView textView, String str, String[] strArr) {
        try {
            textView.setText(String.format(str, strArr));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void loadPayMethodImage(ImageView imageView, String str) {
        if (str != null && !str.isEmpty() && imageView != null && URLUtil.isValidUrl(str)) {
            w.a().a(str).a(imageView, (e) null);
        }
    }

    public static void htmlText(TextView textView, String str) {
        textView.setText(Html.fromHtml(str));
    }

    public static void onTabClick(TabLayout tabLayout, TabLayout.c cVar) {
        tabLayout.a((TabLayout.b) cVar);
    }
}
