package com.business.merchant_payments.utility;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;
import com.business.merchant_payments.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusinessShareUtility {
    public static final String TAG = "BusinessShareUtility";

    public static void share(Bitmap bitmap) {
    }

    public static void share(Uri uri) {
    }

    public static void shareLink(String str, String str2, Context context) {
        String str3;
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            if (TextUtils.isEmpty(str2)) {
                str3 = "Pay me with Paytm";
            } else if (str2.length() >= 71) {
                str3 = "Pay me with Paytm for " + str2.substring(0, 70);
            } else {
                str3 = "Pay me with Paytm for ".concat(String.valueOf(str2));
            }
            intent.putExtra("android.intent.extra.SUBJECT", str3);
            intent.putExtra("android.intent.extra.TEXT", str);
            Intent createChooser = Intent.createChooser(intent, context.getString(R.string.mp_share_link_title_share_bottom_sheet));
            if (createChooser.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(createChooser);
            } else {
                Toast.makeText(context.getApplicationContext(), context.getString(R.string.mp_no_app_found), 1).show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void shareQrImage(Uri uri, String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.mp_post_payment_share_subject));
            if (str == null) {
                str = "";
            }
            intent.putExtra("android.intent.extra.TEXT", context.getString(R.string.mp_post_payment_share_subject) + " " + str);
            intent.putExtra("android.intent.extra.STREAM", uri);
            Intent createChooser = Intent.createChooser(intent, context.getString(R.string.mp_share_link_title_share_bottom_sheet));
            if (createChooser.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(createChooser);
            } else {
                Toast.makeText(context.getApplicationContext(), context.getString(R.string.mp_no_app_found), 1).show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void sharePaymentLinkWithQR(Uri uri, String str, Context context) {
        try {
            Set<String> defaultSMSAppPackage = getDefaultSMSAppPackage(context);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            ArrayList arrayList = new ArrayList();
            if (queryIntentActivities.size() > 0) {
                for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
                    ResolveInfo resolveInfo = queryIntentActivities.get(i2);
                    String str2 = resolveInfo.activityInfo.packageName;
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str2, resolveInfo.activityInfo.name));
                    intent2.setAction("android.intent.action.SEND");
                    if (!defaultSMSAppPackage.contains(str2)) {
                        intent2.setType("image/png");
                        intent2.putExtra("android.intent.extra.STREAM", uri);
                    }
                    intent2.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.mp_post_payment_share_subject));
                    intent2.putExtra("android.intent.extra.TEXT", str);
                    arrayList.add(new LabeledIntent(intent2, str2, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
                }
                Intent createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), context.getString(R.string.mp_post_payment_share_title));
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[(arrayList.size() - 1)]));
                if (createChooser.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(createChooser);
                } else {
                    Toast.makeText(context.getApplicationContext(), context.getString(R.string.mp_no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Set<String> getDefaultSMSAppPackage(Context context) {
        HashSet hashSet = new HashSet();
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(Telephony.Sms.getDefaultSmsPackage(context));
        } else {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").setType("vnd.android-dir/mms-sms"), 0);
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    hashSet.add(resolveInfo.activityInfo.packageName);
                }
            }
        }
        return hashSet;
    }

    public static Bitmap getScreenshot(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap loadBitmapFromView(Context context, View view) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        view.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return getBlackAndWhitePrint(createBitmap);
    }

    public static Bitmap getBlackAndWhitePrint(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{85.0f, 85.0f, 85.0f, 0.0f, -32640.0f, 85.0f, 85.0f, 85.0f, 0.0f, -32640.0f, 85.0f, 85.0f, 85.0f, 0.0f, -32640.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
