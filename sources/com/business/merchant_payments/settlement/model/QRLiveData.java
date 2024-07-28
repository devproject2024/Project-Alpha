package com.business.merchant_payments.settlement.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import androidx.lifecycle.LiveData;
import com.business.merchant_payments.utility.QRCodeGenerator;

public class QRLiveData extends LiveData<Bitmap> {
    public static final int STANDARD_SHARE_QR_IMAGE_DIMENSION = 775;

    public QRLiveData(boolean z, int i2, int i3, String str) {
        loadAsyncData(z, i2, i3, str);
    }

    private void loadAsyncData(boolean z, int i2, int i3, String str) {
        new AsyncTask<Object, Void, Bitmap>() {
            public Bitmap doInBackground(Object... objArr) {
                String str = null;
                boolean z = false;
                int i2 = 775;
                int i3 = -16777216;
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    if (i4 == 0 && (objArr[i4] instanceof String)) {
                        str = objArr[i4];
                    }
                    if (i4 == 1 && (objArr[i4] instanceof Boolean)) {
                        z = objArr[i4].booleanValue();
                    }
                    if (i4 == 2 && (objArr[i4] instanceof Integer)) {
                        i2 = objArr[i4].intValue();
                    }
                    if (i4 == 3 && (objArr[i4] instanceof Integer)) {
                        i3 = objArr[i4].intValue();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (!z) {
                        return QRLiveData.this.qrPathBitMap(str, i2, i2);
                    }
                    try {
                        return QRCodeGenerator.getQrCodeBitmap(str, i2, i3);
                    } catch (Exception unused) {
                    }
                }
                return null;
            }

            public void onPostExecute(Bitmap bitmap) {
                QRLiveData.this.setValue(bitmap);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    /* access modifiers changed from: private */
    public Bitmap qrPathBitMap(String str, int i2, int i3) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return Bitmap.createScaledBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length), i2, i3, true);
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }
}
