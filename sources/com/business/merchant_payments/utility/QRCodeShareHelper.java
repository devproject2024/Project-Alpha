package com.business.merchant_payments.utility;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.text.TextUtils;
import android.widget.Toast;
import com.business.common_module.events.d;
import com.business.merchant_payments.R;
import com.business.merchant_payments.event.DownloadQREVent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.greenrobot.eventbus.c;

public class QRCodeShareHelper {
    public static void shareQRCodeUri(Uri uri, String str, String str2, Activity activity) {
        String str3;
        Set<String> set;
        String str4;
        String str5;
        String str6;
        Uri uri2 = uri;
        String str7 = str;
        String str8 = str2;
        Activity activity2 = activity;
        if (uri2 != null || !TextUtils.isEmpty(str2)) {
            if (uri2 == null && !TextUtils.isEmpty(str2)) {
                Toast.makeText(activity2, activity2.getString(R.string.mp_unable_to_share_qr_instead_link), 1).show();
            }
            String str9 = "android.intent.action.SEND";
            Intent intent = new Intent(str9);
            String str10 = "image/png";
            intent.setType(str10);
            PackageManager packageManager = activity.getPackageManager();
            int i2 = 0;
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            ArrayList arrayList = new ArrayList();
            if (queryIntentActivities.size() > 0) {
                Set<String> defaultSMSAppPackage = getDefaultSMSAppPackage(activity);
                while (i2 < queryIntentActivities.size()) {
                    ResolveInfo resolveInfo = queryIntentActivities.get(i2);
                    String str11 = resolveInfo.activityInfo.packageName;
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str11, resolveInfo.activityInfo.name));
                    intent2.setAction(str9);
                    intent2.setType(str10);
                    List<ResolveInfo> list = queryIntentActivities;
                    String str12 = str9;
                    int i3 = i2;
                    if (str11.contains("android.apps.inbox") || str11.contains("android.gm") || str11.contains("microsoft.office.outlook") || str11.contains("yahoo.mobile.client.android.mail")) {
                        set = defaultSMSAppPackage;
                        intent2.setType(str10);
                        if (TextUtils.isEmpty(str2)) {
                            str4 = activity.getResources().getString(R.string.mp_scan_qr_to_pay);
                            str5 = activity.getResources().getString(R.string.mp_dear_customer_scan_qr_to_pay);
                        } else {
                            str4 = activity.getResources().getString(R.string.mp_scan_qr__or_link_to_pay);
                            str5 = activity.getResources().getString(R.string.mp_dear_customer_scan_qr_or_link_to_pay);
                        }
                        String str13 = str5;
                        String str14 = str4;
                        str3 = str10;
                        if (str7 != null) {
                            str14 = str14 + " " + str7;
                            str13 = str13 + " " + str7;
                            if (!TextUtils.isEmpty(str2)) {
                                str13 = str13 + StringUtility.NEW_LINE + str8;
                            }
                        }
                        intent2.putExtra("android.intent.extra.TEXT", str13);
                        intent2.putExtra("android.intent.extra.SUBJECT", str14);
                        if (uri2 != null) {
                            intent2.putExtra("android.intent.extra.STREAM", uri2);
                        }
                    } else if (!defaultSMSAppPackage.contains(str11) || TextUtils.isEmpty(str2)) {
                        intent2.setType(str10);
                        if (TextUtils.isEmpty(str2)) {
                            set = defaultSMSAppPackage;
                            str6 = activity.getResources().getString(R.string.mp_scan_qr_to_pay);
                        } else {
                            set = defaultSMSAppPackage;
                            str6 = activity.getResources().getString(R.string.mp_scan_qr__or_link_to_pay);
                        }
                        if (str7 != null) {
                            str6 = str6 + " " + str7;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            str6 = str6 + StringUtility.NEW_LINE + str8;
                        }
                        intent2.putExtra("android.intent.extra.TEXT", str6);
                        if (uri2 != null) {
                            intent2.putExtra("android.intent.extra.STREAM", uri2);
                        }
                        str3 = str10;
                    } else {
                        String string = activity2.getString(R.string.mp_click_below_url_to_pay);
                        if (str7 != null) {
                            string = string + " " + str7;
                        }
                        intent2.putExtra("android.intent.extra.TEXT", string + StringUtility.NEW_LINE + str8);
                        str3 = str10;
                        set = defaultSMSAppPackage;
                    }
                    arrayList.add(new LabeledIntent(intent2, str11, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
                    i2 = i3 + 1;
                    queryIntentActivities = list;
                    str9 = str12;
                    defaultSMSAppPackage = set;
                    str10 = str3;
                }
                Intent createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), activity.getResources().getString(R.string.mp_share_qr_code));
                if (arrayList.size() > 0) {
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
                }
                if (createChooser.resolveActivity(activity.getPackageManager()) != null) {
                    activity2.startActivity(createChooser);
                } else {
                    Toast.makeText(activity.getApplicationContext(), activity2.getString(R.string.mp_no_app_found), 1).show();
                }
            }
        }
    }

    public static void downloadQrCode(Uri uri, String str, Activity activity, Bitmap bitmap, String str2) {
        if (bitmap == null || activity == null) {
            throw new NullPointerException("Bitmap of QR code can't be null");
        } else if (uri != null) {
            Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.mp_qr_code_downloaded), 1).show();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(uri, "image/*");
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                c.a().c(new DownloadQREVent());
                activity.startActivity(intent);
            } else {
                c.a().c(new DownloadQREVent(false));
                Toast.makeText(activity, activity.getString(R.string.mp_no_suitable_app), 1).show();
            }
            c.a().c(new d(true));
        }
    }

    public static Uri getSharableQrImageUri(String str, Bitmap bitmap, String str2, Context context) {
        boolean z;
        Bitmap shareDownloadQrBitmap = ShareDownloadImageGenerator.getShareDownloadQrBitmap(str, bitmap, str2);
        if (shareDownloadQrBitmap == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "DCIM/Camera");
            z = file.exists();
            if (!z) {
                z = file.mkdirs();
            }
        } else {
            z = true;
        }
        if (z) {
            ContentResolver contentResolver = context.getContentResolver();
            String insertImage = MediaStore.Images.Media.insertImage(contentResolver, shareDownloadQrBitmap, str2 + System.currentTimeMillis(), (String) null);
            shareDownloadQrBitmap.recycle();
            if (insertImage == null) {
                return null;
            }
            return Uri.parse(insertImage);
        }
        shareDownloadQrBitmap.recycle();
        return null;
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
}
