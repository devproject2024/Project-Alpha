package com.paytmmall.clpartifact.view.viewbindings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;

public class RecoWidgetViewBindings {
    public static void setTextColor(TextView textView, String str) {
        int c2 = b.c(textView.getContext(), R.color.expand_tree_text);
        try {
            c2 = Color.parseColor(getColor(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        textView.setTextColor(c2);
    }

    private static String getColor(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("#")) {
            return TextUtils.isEmpty(str) ? "" : "#".concat(String.valueOf(str));
        }
        return str;
    }

    public static void setCircularImage(ImageView imageView, String str, Context context) {
        if (context == null) {
            context = imageView.getContext();
        }
        if (!ImageUtility.isActivityDestroyed(context) && !TextUtils.isEmpty(str)) {
            ImageUtility.loadImageAsync(imageView, context, str);
        }
    }

    public static void setTitleSize(TextView textView, View view) {
        if (view != null) {
            textView.setTextSize(2, ViewHolderFactory.TYPE_CAROUSEL_TOI.equalsIgnoreCase(view.getType()) ? 16.0f : 18.0f);
        }
    }

    public static void setTitleColor(TextView textView, View view) {
        Resources resources;
        int i2;
        if (view != null) {
            if (ViewHolderFactory.TYPE_CAROUSEL_TOI.equalsIgnoreCase(view.getType())) {
                resources = textView.getResources();
                i2 = R.color.color_1D2F54;
            } else {
                resources = textView.getResources();
                i2 = R.color.color_222222;
            }
            textView.setTextColor(resources.getColor(i2));
        }
    }
}
