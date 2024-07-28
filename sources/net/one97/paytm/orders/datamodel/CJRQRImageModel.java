package net.one97.paytm.orders.datamodel;

import android.graphics.Bitmap;
import android.view.View;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRQRImageModel implements IJRDataModel {
    /* access modifiers changed from: private */
    public Bitmap bitmap;
    /* access modifiers changed from: private */
    public View thumbView;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public View getThumbView() {
        return this.thumbView;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRQRImageModel f56864a;

        public a() {
            this.f56864a = null;
            this.f56864a = new CJRQRImageModel();
        }
    }
}
