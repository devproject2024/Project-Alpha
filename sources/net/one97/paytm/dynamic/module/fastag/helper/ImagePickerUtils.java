package net.one97.paytm.dynamic.module.fastag.helper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Base64;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import net.one97.paytm.landingpage.utils.croptool.CropImage;
import org.json.JSONException;
import org.json.JSONObject;

public class ImagePickerUtils {
    public static final int CROP_IMAGE_ACTIVITY_REQUEST_CODE = 203;
    private static final int CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE = 204;
    private static final String CROP_IMAGE_EXTRA_RESULT = "CROP_IMAGE_EXTRA_RESULT";
    public static final String IMAGE_PICKER_KEY_BASE_64 = "base64";
    public static final String IMAGE_PICKER_KEY_ERROR_MESSAGE = "errorMessage";
    public static final String IMAGE_PICKER_KEY_EXT = "ext";
    public static final String IMAGE_PICKER_KEY_FILE_NAME = "fileName";
    public static final String IMAGE_PICKER_KEY_FILE_PATH = "filePath";
    public static final String IMAGE_PICKER_KEY_FILE_STREAM = "fileStream";
    public static final String IMAGE_PICKER_KEY_IMAGE_SIZE = "imageSize";
    public static final String IMAGE_PICKER_KEY_IMAGE_TYPE = "imageType";
    public static final String IMAGE_PICKER_KEY_MIME_TYPE = "mimeType";
    public static final String IMAGE_PICKER_KEY_SIZE = "size";
    public static final String IMAGE_PICKER_KEY_STATUS = "status";
    public static final String IMAGE_PICKER_KEY_STATUS_FAILURE = "failure";
    public static final String IMAGE_PICKER_KEY_STATUS_SUCCESS = "success";
    public static final String IMAGE_PICKER_KEY_STATUS_TEXT = "statusText";
    private static final int RESULT_OK = -1;

    public static Object handleCropImageResult(Context context, int i2, Intent intent) {
        if (i2 == -1) {
            return handleCropImageResult(context, intent);
        }
        if (i2 != 204) {
            return null;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT");
        return provideFailureCallback("Cropping failed: " + getError(parcelableExtra));
    }

    private static Object handleCropImageResult(Context context, Intent intent) {
        String str;
        if (intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT") == null || !"mounted".equalsIgnoreCase(Environment.getExternalStorageState())) {
            return provideFailureCallback("Something went wrong, please try again.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getFilePath());
        if (context != null) {
            str = "/Android/data/" + context.getPackageName();
        } else {
            str = null;
        }
        sb.append(str);
        return sendFilePath(sb.toString());
    }

    private static Object provideFailureCallback(String str) {
        return getFailureFileSelectionObject(str);
    }

    private static Object sendFilePath(String str) {
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
        String compressImage = compressImage(file.getAbsolutePath());
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(compressImage);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            i2 = byteArray.length / 1000;
            try {
                str4 = Base64.encodeToString(byteArray, 0);
            } catch (Exception e2) {
                e = e2;
                q.b(e.getMessage());
                HashMap hashMap = new HashMap();
                hashMap.put(IMAGE_PICKER_KEY_FILE_PATH, compressImage);
                hashMap.put(IMAGE_PICKER_KEY_MIME_TYPE, obj);
                hashMap.put("status", "success");
                hashMap.put(IMAGE_PICKER_KEY_STATUS_TEXT, "");
                hashMap.put(IMAGE_PICKER_KEY_FILE_STREAM, str4);
                hashMap.put(IMAGE_PICKER_KEY_FILE_NAME, str2);
                hashMap.put(IMAGE_PICKER_KEY_EXT, str3);
                hashMap.put(IMAGE_PICKER_KEY_SIZE, Integer.toString(i2));
                return hashMap;
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 0;
            q.b(e.getMessage());
            HashMap hashMap2 = new HashMap();
            hashMap2.put(IMAGE_PICKER_KEY_FILE_PATH, compressImage);
            hashMap2.put(IMAGE_PICKER_KEY_MIME_TYPE, obj);
            hashMap2.put("status", "success");
            hashMap2.put(IMAGE_PICKER_KEY_STATUS_TEXT, "");
            hashMap2.put(IMAGE_PICKER_KEY_FILE_STREAM, str4);
            hashMap2.put(IMAGE_PICKER_KEY_FILE_NAME, str2);
            hashMap2.put(IMAGE_PICKER_KEY_EXT, str3);
            hashMap2.put(IMAGE_PICKER_KEY_SIZE, Integer.toString(i2));
            return hashMap2;
        }
        HashMap hashMap22 = new HashMap();
        hashMap22.put(IMAGE_PICKER_KEY_FILE_PATH, compressImage);
        hashMap22.put(IMAGE_PICKER_KEY_MIME_TYPE, obj);
        hashMap22.put("status", "success");
        hashMap22.put(IMAGE_PICKER_KEY_STATUS_TEXT, "");
        hashMap22.put(IMAGE_PICKER_KEY_FILE_STREAM, str4);
        hashMap22.put(IMAGE_PICKER_KEY_FILE_NAME, str2);
        hashMap22.put(IMAGE_PICKER_KEY_EXT, str3);
        hashMap22.put(IMAGE_PICKER_KEY_SIZE, Integer.toString(i2));
        return hashMap22;
    }

    private static String getFilePath() {
        return Environment.getExternalStorageDirectory().toString();
    }

    private static Exception getError(Object obj) {
        if (obj instanceof CropImage.ActivityResult) {
            return ((CropImage.ActivityResult) obj).f52933c;
        }
        return null;
    }

    private static JSONObject getFailureFileSelectionObject(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IMAGE_PICKER_KEY_FILE_PATH, "");
            jSONObject.put("status", IMAGE_PICKER_KEY_STATUS_FAILURE);
            jSONObject.put(IMAGE_PICKER_KEY_STATUS_TEXT, str);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    public static String compressImage(String str) {
        int i2;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        File file = new File(str);
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= 0) {
            i3 = 1;
        }
        if (i4 <= 0) {
            i4 = 1;
        }
        float f2 = (float) (i4 / i2);
        float f3 = (float) i2;
        if (f3 > 816.0f || ((float) i4) > 612.0f) {
            if (f2 < 0.75f) {
                i4 = (int) ((816.0f / f3) * ((float) i4));
                i2 = 816;
            } else {
                i2 = f2 > 0.75f ? (int) ((612.0f / ((float) i4)) * f3) : 816;
                i4 = 612;
            }
        }
        options.inSampleSize = calculateInSampleSize(options, i4, i2);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e2) {
            q.b(e2.getMessage());
        }
        try {
            bitmap = Bitmap.createBitmap(i4, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e3) {
            q.b(e3.getMessage());
        }
        float f4 = (float) i4;
        float f5 = f4 / ((float) options.outWidth);
        float f6 = (float) i2;
        float f7 = f6 / ((float) options.outHeight);
        float f8 = f4 / 2.0f;
        float f9 = f6 / 2.0f;
        if (decodeFile != null) {
            Matrix matrix = new Matrix();
            matrix.setScale(f5, f7, f8, f9);
            Canvas canvas = new Canvas(bitmap);
            canvas.setMatrix(matrix);
            if (decodeFile.getWidth() / 2 == 0 && decodeFile.getHeight() / 2 == 0) {
                canvas.drawBitmap(decodeFile, 0.0f, 0.0f, new Paint(2));
            } else if (decodeFile.getWidth() / 2 == 0) {
                canvas.drawBitmap(decodeFile, 0.0f, f9 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
            } else if (decodeFile.getHeight() / 2 == 0) {
                canvas.drawBitmap(decodeFile, f8 - ((float) (decodeFile.getWidth() / 2)), 0.0f, new Paint(2));
            } else {
                canvas.drawBitmap(decodeFile, f8 - ((float) (decodeFile.getWidth() / 2)), f9 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
            }
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
                Matrix matrix2 = new Matrix();
                if (attributeInt == 6) {
                    matrix2.postRotate(90.0f);
                } else if (attributeInt == 3) {
                    matrix2.postRotate(180.0f);
                } else if (attributeInt == 8) {
                    matrix2.postRotate(270.0f);
                }
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
            } catch (IOException e4) {
                q.b(e4.getMessage());
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str));
            } catch (FileNotFoundException e5) {
                q.b(e5.getMessage());
            }
        }
        return str;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4;
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        if (i5 > i3 || i6 > i2) {
            i4 = Math.round(((float) i5) / ((float) i3));
            int round = Math.round(((float) i6) / ((float) i2));
            if (i4 >= round) {
                i4 = round;
            }
        } else {
            i4 = 1;
        }
        while (((float) (i6 * i5)) / ((float) (i4 * i4)) > ((float) (i2 * i3 * 2))) {
            i4++;
        }
        return i4;
    }
}
