package com.paytmmall.clpartifact.view.viewbindings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPUtils;
import com.paytmmall.clpartifact.utils.SFSColorUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewHolder.CLPItemVHWithRV;

public class CommonViewBindings {
    public static void setTagData(TextView textView, Item item) {
        if (item != null && item.getLayout() != null) {
            Item.LayoutData layout = item.getLayout();
            if (!TextUtils.isEmpty(layout.getmLabel())) {
                textView.setText(layout.getmLabel());
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView.setBackground(getRoundedDrawable(SFSColorUtils.getParsedColor(layout.getLabelBgColor(), textView.getContext(), R.color.light_green), textView.getContext()));
            textView.setTextColor(SFSColorUtils.getParsedColor(layout.getLabelColor(), textView.getContext(), R.color.green_text_color));
        }
    }

    public static Drawable getRoundedDrawable(int i2, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((float) ViewUtils.convertDpToPixel(4.0f, context));
        return gradientDrawable;
    }

    public static void setTitleItemMargin(View view, com.paytmmall.clpartifact.modal.clpCommon.View view2, CLPItemVHWithRV cLPItemVHWithRV) {
        if (view2 != null && ViewHolderFactory.TYPE_CAROUSEL_4.equalsIgnoreCase(view2.getType()) && cLPItemVHWithRV != null && CLPUtils.isHomeClient(cLPItemVHWithRV.getIgaHandlerListener())) {
            view.setVisibility(0);
        }
    }

    public static void setBannerMargins(View view, String str) {
        if (view != null) {
            int i2 = ViewHolderFactory.CLASS_FULL_WIDTH_IMAGE.equalsIgnoreCase(str) ? 0 : 16;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = a.a(i2);
                marginLayoutParams.rightMargin = a.a(i2);
            }
        }
    }

    public static void setBannerDimensionRatio(ConstraintLayout constraintLayout, String str) {
        if (constraintLayout != null) {
            View childAt = constraintLayout.getChildCount() > 0 ? constraintLayout.getChildAt(0) : null;
            if (childAt != null) {
                c cVar = new c();
                cVar.b(constraintLayout);
                cVar.a(childAt.getId(), getRatio(str));
                cVar.c(constraintLayout);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getRatio(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1766924077: goto L_0x0040;
                case -1032895166: goto L_0x0036;
                case -1032894205: goto L_0x002c;
                case 355717414: goto L_0x0022;
                case 388274352: goto L_0x0018;
                case 562539744: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x004b
        L_0x000d:
            java.lang.String r0 = "thin-banner"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x004b
            r6 = 2
            goto L_0x004c
        L_0x0018:
            java.lang.String r0 = "h1-banner"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x004b
            r6 = 5
            goto L_0x004c
        L_0x0022:
            java.lang.String r0 = "h1-full-banner"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x004b
            r6 = 4
            goto L_0x004c
        L_0x002c:
            java.lang.String r0 = "banner-3_0"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x004b
            r6 = 1
            goto L_0x004c
        L_0x0036:
            java.lang.String r0 = "banner-2_0"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x004b
            r6 = 0
            goto L_0x004c
        L_0x0040:
            java.lang.String r0 = "thin-small"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x004b
            r6 = 3
            goto L_0x004c
        L_0x004b:
            r6 = -1
        L_0x004c:
            if (r6 == 0) goto L_0x0068
            java.lang.String r0 = "3:1"
            if (r6 == r5) goto L_0x0067
            if (r6 == r4) goto L_0x0064
            if (r6 == r3) goto L_0x0061
            if (r6 == r2) goto L_0x005e
            if (r6 == r1) goto L_0x005b
            return r0
        L_0x005b:
            java.lang.String r6 = "1.6:1"
            return r6
        L_0x005e:
            java.lang.String r6 = "375:460"
            return r6
        L_0x0061:
            java.lang.String r6 = "343:50"
            return r6
        L_0x0064:
            java.lang.String r6 = "36:10"
            return r6
        L_0x0067:
            return r0
        L_0x0068:
            java.lang.String r6 = "2:1"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewbindings.CommonViewBindings.getRatio(java.lang.String):java.lang.String");
    }
}
