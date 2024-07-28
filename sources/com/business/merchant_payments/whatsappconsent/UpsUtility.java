package com.business.merchant_payments.whatsappconsent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.business.merchant_payments.ups.UPSDataProvider;
import kotlin.g.b.k;

public final class UpsUtility {
    public static final void invoke(Drawable drawable, Drawable drawable2) {
        k.d(drawable, "$this$invoke");
    }

    public static final boolean shouldShowRateUsBottomSheet(Context context) {
        k.d(context, "context");
        APSharedPreferences instance = APSharedPreferences.getInstance();
        k.b(instance, "APSharedPreferences.getInstance()");
        boolean userSeenDialog = instance.getUserSeenDialog();
        int i2 = GTMDataProviderImpl.Companion.getMInstance().getInt(PaymentsGTMConstants.MIN_DAYS_FIRST_OPEN_OF_APP, 0);
        int i3 = GTMDataProviderImpl.Companion.getMInstance().getInt(PaymentsGTMConstants.MIN_DAYS_SINCE_LAST_DIALOG_OPEN, 0);
        int i4 = GTMDataProviderImpl.Companion.getMInstance().getInt(PaymentsGTMConstants.MIN_APP_OPENS_SINCE_LAST_DIALOG_OPEN, 0);
        int i5 = GTMDataProviderImpl.Companion.getMInstance().getInt(PaymentsGTMConstants.MIN_APP_OPENS_SINCE_FIRST_OPEN_OF_APP, 0);
        if (!userSeenDialog) {
            i4 = i5;
        }
        if (userSeenDialog) {
            i2 = i3;
        }
        APSharedPreferences instance2 = APSharedPreferences.getInstance();
        k.b(instance2, "APSharedPreferences.getInstance()");
        int appOpenCount = instance2.getAppOpenCount();
        APSharedPreferences instance3 = APSharedPreferences.getInstance();
        k.b(instance3, "APSharedPreferences.getInstance()");
        int lastSeenDialogcount = instance3.getLastSeenDialogcount();
        if (appOpenCount < i4 || lastSeenDialogcount < i2) {
            return false;
        }
        return true;
    }

    public static final void statusRecieved(Context context) {
        if (context != null) {
            new UPSDataProvider(context).updateWhatsConsentStatusAPI("true", UpsUtility$statusRecieved$1$1.INSTANCE);
        }
    }

    public static final void statusRecieved(String str, boolean z, Context context) {
        k.d(str, "msg");
        if (z) {
            k.a((Object) context);
            String string = context.getString(R.string.mp_whatapp_consent_succcess_msg);
            k.b(string, "context!!.getString(R.st…app_consent_succcess_msg)");
            showToast(string, true, context);
            return;
        }
        showToast(str, false, context);
    }

    public static final void showToast(String str, boolean z, Context context) {
        Drawable drawable;
        k.d(str, "msg");
        View inflate = LayoutInflater.from(context).inflate(R.layout.mp_custom_toast_layout, (ViewGroup) null);
        k.b(inflate, "layoutInflater.inflate(R…ustom_toast_layout, null)");
        View findViewById = inflate.findViewById(R.id.mp_tv_msg);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.toast_layout_root);
            if (findViewById2 != null) {
                LinearLayout linearLayout = (LinearLayout) findViewById2;
                textView.setText(str);
                if (z) {
                    drawable = context != null ? b.a(context, R.drawable.mp_success_check) : null;
                    k.a((Object) context);
                    linearLayout.setBackgroundColor(b.c(context, R.color.mp_e9f9f2));
                    textView.setTextColor(b.c(context, R.color.color_21c17a));
                } else {
                    drawable = context != null ? b.a(context, R.drawable.mp_fail_icon) : null;
                    k.a((Object) context);
                    linearLayout.setBackgroundColor(b.c(context, R.color.mp_ffefef));
                    textView.setTextColor(b.c(context, R.color.color_fd5154));
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Toast toast = new Toast(context);
                toast.setGravity(48, 0, 0);
                toast.setDuration(1);
                toast.setView(inflate);
                toast.show();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
