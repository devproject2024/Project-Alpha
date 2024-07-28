package com.business.merchant_payments.settlement.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import androidx.databinding.i;
import com.business.merchant_payments.utility.QRCodeGenerator;
import java.lang.ref.WeakReference;

public class StringToQRGenerator extends AsyncTask<String, Void, Bitmap> {
    public int color;
    public boolean needQrFromText;
    public WeakReference<i<Bitmap>> observableBitmap;
    public int qrDimen;

    public StringToQRGenerator(i<Bitmap> iVar, boolean z, int i2, int i3) {
        this.observableBitmap = new WeakReference<>(iVar);
        this.needQrFromText = z;
        this.qrDimen = i2;
        this.color = i3;
    }

    public Bitmap doInBackground(String... strArr) {
        if (TextUtils.isEmpty(strArr[0])) {
            return null;
        }
        try {
            if (this.needQrFromText) {
                return QRCodeGenerator.getQrCodeBitmap(strArr[0], this.qrDimen, this.color);
            }
            return qrPathBitMap(strArr[0], this.qrDimen, this.qrDimen);
        } catch (Exception unused) {
            return null;
        }
    }

    public void onPostExecute(Bitmap bitmap) {
        if (this.observableBitmap.get() != null) {
            ((i) this.observableBitmap.get()).set(bitmap);
        }
    }

    private Bitmap qrPathBitMap(String str, int i2, int i3) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return Bitmap.createScaledBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length), i2, i3, true);
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }
}
