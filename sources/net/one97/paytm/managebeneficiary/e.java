package net.one97.paytm.managebeneficiary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class e {
    public static void a(final Context context, String str, final String str2) {
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.succes_dialog_beneficiary, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.sucess_msg);
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            } else {
                textView.setText(context.getResources().getString(R.string.pb_mb_beneficiary_details_updated_successfully));
            }
            Button button = (Button) inflate.findViewById(R.id.btn_ok);
            button.setText(R.string.ok);
            builder.setInverseBackgroundForced(true);
            builder.setCancelable(false);
            builder.setView(inflate);
            final AlertDialog show = builder.show();
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    show.dismiss();
                    if ("p2p".equalsIgnoreCase(str2)) {
                        ((Activity) context).finish();
                        return;
                    }
                    ((Activity) context).setResult(-1);
                    ((Activity) context).finish();
                }
            });
        }
    }

    public static void a(final Context context, String str) {
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.succes_dialog_beneficiary, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.sucess_msg);
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            } else {
                textView.setText(context.getResources().getString(R.string.pb_mb_beneficiary_details_updated_successfully));
            }
            Button button = (Button) inflate.findViewById(R.id.btn_ok);
            button.setText(R.string.ok);
            builder.setInverseBackgroundForced(true);
            builder.setCancelable(false);
            builder.setView(inflate);
            final AlertDialog show = builder.show();
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    show.dismiss();
                    ((Activity) context).setResult(-1);
                    ((Activity) context).finish();
                }
            });
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", str);
        hashMap.put("event_action", str2);
        hashMap.put("user_id", b.n(context));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
        hashMap.put("vertical_name", "beneficiary");
        f.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", str);
        hashMap.put("event_action", str2);
        hashMap.put("user_id", b.n(context));
        hashMap.put("event_label", str3);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str4);
        hashMap.put("vertical_name", "beneficiary");
        f.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
    }
}
