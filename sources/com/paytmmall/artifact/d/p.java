package com.paytmmall.artifact.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Base64;
import android.widget.Toast;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static String f15734a = "ImagePickerUtils";

    private static Object a(String str) {
        Toast.makeText(t.b(), str, 1).show();
        return c(str);
    }

    private static Object b(String str) {
        String str2;
        String str3;
        Object obj;
        int i2;
        String str4 = null;
        if (!new File(str).exists()) {
            return null;
        }
        File file = new File(str);
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                str2 = null;
                str3 = null;
                obj = "";
                break;
            }
            File file2 = listFiles[i3];
            if ("picture.jpg".equalsIgnoreCase(file2.getName())) {
                str2 = file2.getName();
                obj = "image/jpg";
                str3 = file2.getAbsolutePath().substring(file2.getAbsolutePath().lastIndexOf(AppUtility.CENTER_DOT));
                file = file2;
                break;
            }
            i3++;
        }
        String g2 = d.g(file.getAbsolutePath());
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(g2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            i2 = byteArray.length / 1000;
            try {
                str4 = Base64.encodeToString(byteArray, 0);
            } catch (Exception e2) {
                e = e2;
                q.c(e.getMessage());
                HashMap hashMap = new HashMap();
                hashMap.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, g2);
                hashMap.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, obj);
                hashMap.put("status", "success");
                hashMap.put(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT, "");
                hashMap.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_STREAM, str4);
                hashMap.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, str2);
                hashMap.put(ImagePickerUtils.IMAGE_PICKER_KEY_EXT, str3);
                hashMap.put(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, Integer.toString(i2));
                return hashMap;
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 0;
            q.c(e.getMessage());
            HashMap hashMap2 = new HashMap();
            hashMap2.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, g2);
            hashMap2.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, obj);
            hashMap2.put("status", "success");
            hashMap2.put(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT, "");
            hashMap2.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_STREAM, str4);
            hashMap2.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, str2);
            hashMap2.put(ImagePickerUtils.IMAGE_PICKER_KEY_EXT, str3);
            hashMap2.put(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, Integer.toString(i2));
            return hashMap2;
        }
        HashMap hashMap22 = new HashMap();
        hashMap22.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, g2);
        hashMap22.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, obj);
        hashMap22.put("status", "success");
        hashMap22.put(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT, "");
        hashMap22.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_STREAM, str4);
        hashMap22.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, str2);
        hashMap22.put(ImagePickerUtils.IMAGE_PICKER_KEY_EXT, str3);
        hashMap22.put(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, Integer.toString(i2));
        return hashMap22;
    }

    private static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, "");
            jSONObject.put("status", ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT, str);
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public static Object a(int i2, Bundle bundle) {
        if (i2 == -1) {
            if (bundle.getParcelable(CropImage.CROP_IMAGE_EXTRA_RESULT) == null || !"mounted".equalsIgnoreCase(Environment.getExternalStorageState())) {
                return a(Resources.getSystem().getString(R.string.something_wrong_try_again));
            }
            return b(Environment.getExternalStorageDirectory().toString() + d.i(t.b()));
        } else if (i2 != 204) {
            return null;
        } else {
            Parcelable parcelable = bundle.getParcelable(CropImage.CROP_IMAGE_EXTRA_RESULT);
            return a("Cropping failed: " + t.e().getCropError(parcelable));
        }
    }
}
