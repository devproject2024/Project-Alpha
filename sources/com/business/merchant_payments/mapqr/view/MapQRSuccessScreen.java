package com.business.merchant_payments.mapqr.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.business.common_module.utilities.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.mapqr.model.MapQRResponse;
import com.business.merchant_payments.mapqr.model.MapResponse;
import com.business.merchant_payments.mapqr.model.Response;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class MapQRSuccessScreen extends BaseActivity {
    public static final Companion Companion = new Companion((g) null);
    public static final String SUCCESS_DATA = "SUCCESS_DATA";
    public HashMap _$_findViewCache;
    public TextView additionalText;
    public TextView businessName;
    public ImageView closeIcon;
    public String displayName;
    public ImageView mapQrCode;
    public Bitmap qRBitmap;
    public final int qrDimen = 775;
    public TextView shareQr;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mp_activity_map_qr_success);
        initUI();
        if (getIntent().getSerializableExtra(SUCCESS_DATA) != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra(SUCCESS_DATA);
            if (serializableExtra != null) {
                List<Response> response = ((MapQRResponse) serializableExtra).getResponse();
                setData(response != null ? response.get(0) : null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.business.merchant_payments.mapqr.model.MapQRResponse");
        }
    }

    private final void setData(Response response) {
        String str;
        MapResponse mapResponse;
        TextView textView = this.additionalText;
        if (textView == null) {
            k.a("additionalText");
        }
        textView.setText("");
        if (response == null || (mapResponse = response.getMapResponse()) == null || (str = mapResponse.getDisplayName()) == null) {
            str = "";
        }
        this.displayName = str;
        TextView textView2 = this.businessName;
        if (textView2 == null) {
            k.a("businessName");
        }
        String str2 = this.displayName;
        if (str2 == null) {
            k.a("displayName");
        }
        textView2.setText(str2);
        String str3 = null;
        if (!TextUtils.isEmpty(response != null ? response.getQrCodeId() : null)) {
            if (response != null) {
                str3 = response.getQrCodeId();
            }
            k.a((Object) str3);
            ImageView imageView = this.mapQrCode;
            if (imageView == null) {
                k.a("mapQrCode");
            }
            createQrImageFromText(str3, imageView);
        }
    }

    private final void initUI() {
        View findViewById = findViewById(R.id.business_name);
        k.b(findViewById, "findViewById(R.id.business_name)");
        this.businessName = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.map_qr_code);
        k.b(findViewById2, "findViewById(R.id.map_qr_code)");
        this.mapQrCode = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.additional_txt);
        k.b(findViewById3, "findViewById(R.id.additional_txt)");
        this.additionalText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.share_link_button);
        k.b(findViewById4, "findViewById(R.id.share_link_button)");
        TextView textView = (TextView) findViewById4;
        this.shareQr = textView;
        if (textView == null) {
            k.a("shareQr");
        }
        textView.setOnClickListener(new MapQRSuccessScreen$initUI$1(this));
        View findViewById5 = findViewById(R.id.close_icon);
        k.b(findViewById5, "findViewById(R.id.close_icon)");
        ImageView imageView = (ImageView) findViewById5;
        this.closeIcon = imageView;
        if (imageView == null) {
            k.a("closeIcon");
        }
        imageView.setOnClickListener(new MapQRSuccessScreen$initUI$2(this));
    }

    private final void createQrImageFromText(String str, ImageView imageView) {
        try {
            new Thread(new MapQRSuccessScreen$createQrImageFromText$1(this, str, imageView)).start();
        } catch (Exception unused) {
        }
    }

    public final void shareQrImage() {
        if (b.a(this)) {
            Bitmap bitmap = this.qRBitmap;
            String str = this.displayName;
            if (str == null) {
                k.a("displayName");
            }
            openShareSheet(bitmap, str, this);
            return;
        }
        b.b(this);
    }

    public final void openShareSheet(Bitmap bitmap, String str, Activity activity) {
        k.d(str, "displayName");
        k.d(activity, "context");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(activity, "paytmba://business-app/business-app/h/accept-payments/download-qr");
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.d(strArr, "permissions");
        k.d(iArr, "grantResults");
        if (i2 == 102) {
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                DialogUtility.showAlert(this, "", getString(R.string.mp_go_to_settings_storage));
            } else {
                Bitmap bitmap = this.qRBitmap;
                String str = this.displayName;
                if (str == null) {
                    k.a("displayName");
                }
                openShareSheet(bitmap, str, this);
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }
}
