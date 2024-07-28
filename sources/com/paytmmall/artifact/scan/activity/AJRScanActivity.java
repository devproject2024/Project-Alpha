package com.paytmmall.artifact.scan.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.google.zxing.b.j;
import com.google.zxing.c;
import com.google.zxing.client.a.af;
import com.google.zxing.client.android.c.g;
import com.google.zxing.e;
import com.google.zxing.m;
import com.google.zxing.o;
import com.google.zxing.r;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.common.BaseActivity;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.f;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.u;
import com.paytmmall.artifact.scan.c.a;
import com.paytmmall.artifact.scan.c.b;
import com.paytmmall.artifact.scan.entity.BarcodeData;
import com.paytmmall.artifact.scan.entity.BarcodeResponse;
import com.paytmmall.artifact.scan.entity.BarcodeStatus;
import com.paytmmall.artifact.scan.entity.CJRExtendedInfoData;
import com.paytmmall.b.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRScanActivity extends BaseActivity implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15859b = AJRScanActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f15860a = null;

    /* renamed from: c  reason: collision with root package name */
    private String f15861c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Bundle> f15862d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15863e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15864f;

    /* renamed from: g  reason: collision with root package name */
    private String f15865g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f15866h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f15867i = null;
    private boolean j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mall_w_activity_pay_send);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (getIntent().getExtras() != null) {
            this.f15863e = getIntent().getBooleanExtra(UpiConstants.KEY_IS_SCAN_ONLY, false);
            this.f15864f = getIntent().getBooleanExtra("imei_validate", false);
            this.j = getIntent().getBooleanExtra("barcode_only", false);
        }
        if (this.f15863e) {
            getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
            this.f15865g = getIntent().getStringExtra("merchant_id");
            this.f15866h = getIntent().getStringExtra("store_id");
            this.f15867i = getIntent().getStringExtra("source");
            findViewById(R.id.mall_scan_only_container).setVisibility(0);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("barcode_only", this.j);
            Class<com.paytmmall.artifact.scan.a.a> cls = com.paytmmall.artifact.scan.a.a.class;
            getSupportFragmentManager().a().a(R.id.mall_scan_only_container, cls.cast(Fragment.instantiate(this, cls.getName(), bundle2)), f15859b).b();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
    }

    public void onStart() {
        ClipData primaryClip;
        super.onStart();
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null && clipboardManager.hasPrimaryClip() && (primaryClip = clipboardManager.getPrimaryClip()) != null && primaryClip.getItemCount() > 0 && !TextUtils.isEmpty(primaryClip.getItemAt(0).getText())) {
            String replaceAll = primaryClip.getItemAt(0).getText().toString().replaceAll("\\s+", "");
            if (replaceAll.length() >= 10) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, replaceAll.substring(replaceAll.length() - 10, replaceAll.length())));
            }
        }
    }

    public void onNewIntent(Intent intent) {
        Bundle bundle;
        super.onNewIntent(intent);
        if (intent.hasExtra("extra_home_data")) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data");
            bundle = new Bundle();
            bundle.putSerializable("extra_home_data", cJRHomePageItem);
            if (cJRHomePageItem != null) {
                this.f15860a = cJRHomePageItem.getQrid();
            }
        } else {
            bundle = null;
        }
        if (!TextUtils.isEmpty(this.f15861c)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            String str = this.f15861c;
            if (this.f15862d == null) {
                this.f15862d = new HashMap<>();
            }
            this.f15862d.put(str, bundle);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(DialogInterface dialogInterface) {
        b();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 3112) {
            if (intent != null) {
                Uri data = intent.getData();
                Intent intent2 = new Intent();
                intent2.setDataAndType(data, "image/*");
                intent2.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, this.f15863e);
                getIntent();
                try {
                    try {
                        String a2 = a(MediaStore.Images.Media.getBitmap(getContentResolver(), data));
                        q.b("handleViewIntent : result = ".concat(String.valueOf(a2)));
                        if (!TextUtils.isEmpty(a2)) {
                            if (com.paytmmall.artifact.scan.d.b.a(a2) == 1) {
                                a(a2, "", "");
                            }
                            finish();
                            return;
                        }
                        throw new Exception("incorrectData");
                    } catch (Exception e2) {
                        Toast.makeText(this, c(e2.getMessage()), 1).show();
                        q.c(e2.getMessage());
                        finish();
                    }
                } catch (Exception e3) {
                    Toast.makeText(this, c(e3.getMessage()), 1).show();
                    q.c(e3.getMessage());
                    finish();
                }
            }
        } else if (i2 == 3010 && intent != null) {
            setResult(-1, intent);
            finish();
        }
    }

    private static String a(Bitmap bitmap) throws m {
        try {
            if (bitmap.getByteCount() / TarConstants.EOF_BLOCK <= ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 10) {
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                int[] iArr = new int[(width * height)];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                return String.valueOf(new com.google.zxing.g.a().a(new c(new j(new o(width, height, iArr))), (Map<e, ?>) null));
            }
            throw new Exception("Size too big");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
            return null;
        }
    }

    private String c(String str) {
        String string = getString(R.string.not_paytm_qr);
        if (str == null) {
            return string;
        }
        if (str.equalsIgnoreCase("incorrectData")) {
            return getString(R.string.incorrect_qr_data_message);
        }
        return str.equalsIgnoreCase("loginError") ? getString(R.string.user_not_logged_in_error) : string;
    }

    public final void a() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        try {
            startActivityForResult(Intent.createChooser(intent, "Select Paytm QR Code"), 3112);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public final void a(String str, String str2, String str3) {
        if (this.f15864f) {
            Intent intent = new Intent();
            intent.putExtra("BarCodeResult", str);
            setResult(-1, intent);
            finish();
            return;
        }
        f.f15709g = true;
        if (com.paytmmall.artifact.d.c.b(str)) {
            a(str, str2, str3, "");
        } else if (com.paytmmall.artifact.d.c.d(str)) {
            a(h(str), str2, str3, "");
        } else if (com.paytmmall.artifact.d.c.f(str)) {
            g(str);
        } else if (com.paytmmall.artifact.d.c.g(str)) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace(com.paytmmall.artifact.d.c.h(str), "market://"))));
        } else if (com.paytmmall.artifact.d.c.i(str)) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } else {
            d(str);
        }
    }

    private void d(String str) {
        String str2;
        boolean z;
        String[] split = str.split(" ");
        if (split.length == 1) {
            if (com.paytmmall.artifact.d.c.e(str)) {
                if (!a((Context) this)) {
                    e(str);
                    return;
                } else {
                    a(str, (CJRExtendedInfoData) null);
                    return;
                }
            } else if (com.paytmmall.artifact.d.c.j(str)) {
                if (!a((Context) this)) {
                    e("http://".concat(String.valueOf(str)));
                    return;
                } else {
                    a("http://".concat(String.valueOf(str)), (CJRExtendedInfoData) null);
                    return;
                }
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= split.length) {
                str2 = null;
                break;
            }
            str2 = split[i2];
            if (com.paytmmall.artifact.d.c.e(str2)) {
                break;
            } else if (com.paytmmall.artifact.d.c.j(str2)) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        z = false;
        h hVar = new h(this);
        hVar.setTitle("utility_hide_title");
        if (str2 != null) {
            hVar.a(Html.fromHtml(str.substring(0, str.indexOf(str2)) + "<font color='#00b9f5'><b>" + str2 + "</b></font>" + str.substring(str.indexOf(str2) + str2.length(), str.length())));
            if (z) {
                str2 = "http://".concat(String.valueOf(str2));
            }
            hVar.setCancelable(true);
            hVar.a(-1, getResources().getString(R.string.go_to), new View.OnClickListener(str2, hVar) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ h f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    AJRScanActivity.this.a(this.f$1, this.f$2, view);
                }
            });
        } else {
            hVar.a(str);
            hVar.setCancelable(true);
            hVar.a(-1, getResources().getString(R.string.copy), new View.OnClickListener() {
                public final void onClick(View view) {
                    h.this.cancel();
                }
            });
        }
        hVar.a(-2, getResources().getString(R.string.close), new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.cancel();
            }
        });
        hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AJRScanActivity.this.c(dialogInterface);
            }
        });
        hVar.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, h hVar, View view) {
        a(str, (CJRExtendedInfoData) null);
        hVar.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface) {
        b();
    }

    private void e(String str) {
        h hVar = new h(this, (byte) 0);
        hVar.setTitle("utility_hide_title");
        hVar.a(String.format(getString(R.string.on_time_confirmation), new Object[]{str}));
        hVar.setCancelable(true);
        hVar.b(getString(R.string.on_time_confirmation_checkbox));
        hVar.a(-1, getResources().getString(R.string.on_time_confirmation_button), new View.OnClickListener(hVar, str) {
            private final /* synthetic */ h f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                AJRScanActivity.this.a(this.f$1, this.f$2, view);
            }
        });
        hVar.a(-2, getResources().getString(R.string.on_time_confirmation_cancel), new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.cancel();
            }
        });
        hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AJRScanActivity.this.b(dialogInterface);
            }
        });
        hVar.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface) {
        b();
    }

    private static boolean a(Context context) {
        return u.a(context.getApplicationContext()).b("OneTimeDialogCheckedForExternalQR", false, true);
    }

    private void b() {
        onPause();
        onResume();
    }

    public final void a(String str, CJRExtendedInfoData cJRExtendedInfoData) {
        if (!com.paytmmall.artifact.d.c.b(str) && com.paytmmall.artifact.d.c.e(str)) {
            f(str);
        }
        if (cJRExtendedInfoData != null) {
            a(str, cJRExtendedInfoData.getQrCodeId(), cJRExtendedInfoData.getmQrCodeTimestamp(), cJRExtendedInfoData.getmQRCodeRefrenceOrderID());
        }
    }

    private void f(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setData(Uri.parse(str));
            intent.addFlags(268435456);
            if (intent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                getApplicationContext().startActivity(intent);
            }
        }
    }

    public final void a(String str) {
        if (this.f15864f) {
            Intent intent = new Intent();
            intent.putExtra("BarCodeResult", str);
            setResult(-1, intent);
            finish();
        } else if (com.paytmmall.artifact.d.c.m(this)) {
            com.paytmmall.artifact.common.a.a.a();
            String a2 = com.paytmmall.artifact.common.a.a.a("barcode_search_url", (String) null);
            if (!TextUtils.isEmpty(a2)) {
                Uri.Builder buildUpon = Uri.parse(a2).buildUpon();
                buildUpon.appendPath(str);
                buildUpon.appendQueryParameter("code_type", "ean");
                if (!TextUtils.isEmpty(this.f15865g)) {
                    buildUpon.appendQueryParameter("merchant_id", this.f15865g);
                }
                if (!TextUtils.isEmpty(this.f15866h)) {
                    buildUpon.appendQueryParameter("store_id", this.f15866h);
                }
                if (!TextUtils.isEmpty(getIntent().getStringExtra(CLPConstants.DISCOVERABILITY))) {
                    buildUpon.appendQueryParameter(CLPConstants.DISCOVERABILITY, getIntent().getStringExtra(CLPConstants.DISCOVERABILITY));
                }
                if (TextUtils.isEmpty(this.f15867i)) {
                    buildUpon.appendQueryParameter("src", P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT);
                } else {
                    buildUpon.appendQueryParameter("src", this.f15867i);
                }
                final String uri = buildUpon.build().toString();
                d.a((Activity) this, getString(R.string.please_wait));
                com.paytmmall.b.a.a(getApplicationContext(), a.C0216a.GET, uri, (String) null, (Map<String, String>) null, new BarcodeResponse(), new com.paytmmall.b.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        AJRScanActivity.a(AJRScanActivity.this, (BarcodeResponse) iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        AJRScanActivity.a(AJRScanActivity.this, networkCustomError, uri);
                    }
                });
            }
        } else {
            try {
                if (!isFinishing()) {
                    h hVar = new h(this);
                    hVar.setTitle(getResources().getString(R.string.no_connection));
                    hVar.a(getResources().getString(R.string.no_internet));
                    hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                        public final void onClick(View view) {
                            h.this.cancel();
                        }
                    });
                    hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AJRScanActivity.this.d(dialogInterface);
                        }
                    });
                    hVar.setCancelable(true);
                    hVar.show();
                }
            } catch (Exception e2) {
                if (com.paytmmall.artifact.d.c.f15691a) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    private void g(String str) {
        startActivity(i(str));
    }

    public final void a(r rVar) {
        new af();
        new g(this, af.d(rVar)) {
        };
    }

    private static String h(String str) {
        return t.c().c("DEEPLINK_SCHEME_ID") + "://embed?url=" + str;
    }

    private void a(String str, String str2, String str3, String str4) {
        final String str5;
        try {
            if (!com.paytmmall.artifact.d.c.c(str)) {
                String k = com.paytmmall.artifact.d.c.k(str);
                if (k.equalsIgnoreCase(str)) {
                    String a2 = com.paytmmall.artifact.d.c.a(this, str);
                    if (!TextUtils.isEmpty(a2)) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(String.valueOf(a2)))));
                        return;
                    } else {
                        startActivity(i(str));
                        return;
                    }
                } else {
                    str5 = k;
                }
            } else {
                str5 = str;
            }
            final CJRHomePageItem a3 = com.paytmmall.artifact.d.o.a(getApplicationContext(), str5, "");
            if (a3 != null && a3.getURLType().equalsIgnoreCase("external")) {
                if (!TextUtils.isEmpty(a3.getURL())) {
                    str5 = a3.getURL();
                }
                startActivity(i(str5));
            } else if (a3 != null && !TextUtils.isEmpty(a3.getDeeplink()) && UpiConstants.URL_TYPE_BRANCH_SHARE.equalsIgnoreCase(a3.getURLType())) {
            } else {
                if (a3 != null && t.a(a3.getURLType())) {
                    final String str6 = str2;
                    final String str7 = str4;
                    final String str8 = str3;
                    t.a((Context) this, a3.getURLType(), (HashMap<String, Serializable>) new HashMap<String, Serializable>() {
                        {
                            put("extra_home_data", a3);
                            put("origin", "deeplinking");
                            put("qrcode_id", str6);
                            put("qrcode_order_id", str7);
                            put("deeplink", str5);
                            put("timestamp", str8);
                            put("affiliateID", AJRScanActivity.b(a3.getURL()));
                            put("source", "qrcode");
                            put("is_deep_linking_data", Boolean.TRUE);
                        }
                    });
                } else if (a3 != null) {
                    t.e().checkDeepLinking(this, str5);
                }
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    private static Intent i(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }

    private void a(String str, String str2) {
        h hVar = new h(this);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.setCancelable(true);
        hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.dismiss();
            }
        });
        hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AJRScanActivity.this.a(dialogInterface);
            }
        });
        try {
            if (!isFinishing()) {
                hVar.show();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        getSupportFragmentManager().c(f15859b);
        b();
    }

    public void onBackPressed() {
        if (this.f15863e) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    public void onDestroy() {
        HashMap<String, Bundle> hashMap = this.f15862d;
        if (hashMap != null) {
            hashMap.clear();
            this.f15862d = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, String str, View view) {
        if (hVar.f43821a.isChecked()) {
            u.a(getApplicationContext()).a("OneTimeDialogCheckedForExternalQR", true, true);
        }
        a(str, (CJRExtendedInfoData) null);
        hVar.cancel();
    }

    static /* synthetic */ void a(AJRScanActivity aJRScanActivity, BarcodeResponse barcodeResponse) {
        BarcodeStatus status = barcodeResponse.getStatus();
        if (status == null || TextUtils.isEmpty(status.getResult())) {
            aJRScanActivity.a("Error", "");
            return;
        }
        String result = status.getResult();
        if (result.equalsIgnoreCase("SUCCESS")) {
            BarcodeData data = status.getData();
            if (data != null) {
                aJRScanActivity.a(data.getDeepLink(), "", "", "");
            }
        } else if (result.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
            aJRScanActivity.a("Error", barcodeResponse.getError());
        }
    }

    static /* synthetic */ void a(AJRScanActivity aJRScanActivity, NetworkCustomError networkCustomError, String str) {
        d.b((Activity) aJRScanActivity);
        if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410) {
            d.a((Activity) aJRScanActivity, networkCustomError, aJRScanActivity.getClass().getName(), str);
        } else if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
            aJRScanActivity.a(aJRScanActivity.getString(R.string.error), networkCustomError.getAlertMessage());
        } else {
            aJRScanActivity.a(aJRScanActivity.getString(R.string.error), aJRScanActivity.getString(R.string.some_went_wrong));
        }
    }

    static /* synthetic */ String b(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str).getQueryParameter("AffiliateID");
    }
}
