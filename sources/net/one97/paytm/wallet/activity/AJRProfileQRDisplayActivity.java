package net.one97.paytm.wallet.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.g;
import com.google.zxing.g.a.f;
import com.google.zxing.l;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.p2p.P2PAppCompatActivity;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONObject;

public class AJRProfileQRDisplayActivity extends P2PAppCompatActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f69902a = AJRProfileQRDisplayActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private TextView f69903b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f69904c;

    /* renamed from: e  reason: collision with root package name */
    private TextView f69905e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f69906f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f69907g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f69908h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f69909i;
    private RelativeLayout j;
    private RelativeLayout k;
    private boolean l;
    private boolean m;
    private String n;
    private String o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(12);
        setContentView(R.layout.activity_profile_qr_display);
        getSupportActionBar().f();
        this.f69903b = (TextView) findViewById(R.id.tv_profile_name);
        this.f69904c = (TextView) findViewById(R.id.tv_mobile_no);
        this.f69905e = (TextView) findViewById(R.id.tvImageName);
        this.f69906f = (ImageView) findViewById(R.id.ivProfileImageView);
        this.f69908h = (RelativeLayout) findViewById(R.id.rl_send_money);
        this.f69908h.setOnClickListener(this);
        this.f69909i = (RelativeLayout) findViewById(R.id.rl_add_to_contact);
        this.f69909i.setOnClickListener(this);
        this.j = (RelativeLayout) findViewById(R.id.rl_start_chat);
        this.j.setOnClickListener(this);
        this.k = (RelativeLayout) findViewById(R.id.rl_save_qrt);
        this.k.setOnClickListener(this);
        this.f69907g = (ImageView) findViewById(R.id.iv_back_button);
        this.f69907g.setOnClickListener(this);
        if (getIntent() != null) {
            this.n = getIntent().getStringExtra("name");
            this.o = getIntent().getStringExtra("mobile");
            TextView textView = this.f69903b;
            textView.setText(this.n);
            TextView textView2 = this.f69904c;
            textView2.setText(this.o);
            this.f69905e.setText(a.d(this.n));
            this.l = getIntent().getBooleanExtra(UpiConstants.IS_GALLERY_SCAN, false);
            this.m = getIntent().getBooleanExtra(UpiConstants.IS_MID_SCAN, false);
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back_button) {
            finish();
        } else if (id == R.id.rl_send_money) {
            Intent intent = new Intent();
            intent.putExtra("NAME", this.n);
            intent.putExtra("PHONE_NUMBER", this.o);
            intent.putExtra("MODE", "QR_CODE");
            intent.putExtra(UpiConstants.IS_GALLERY_SCAN, this.l);
            intent.putExtra(UpiConstants.IS_MID_SCAN, this.m);
            net.one97.paytm.wallet.newdesign.universalp2p.c.a.a().f71392d = a.c.QR_SCAN_PAYTM_PROFILE;
            net.one97.paytm.wallet.utility.a.a(intent, (Activity) this);
            finish();
        } else if (id == R.id.rl_add_to_contact) {
            Intent intent2 = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
            intent2.setType("vnd.android.cursor.item/contact");
            intent2.putExtra("name", this.n);
            intent2.putExtra(ContactColumn.PHONE_NUMBER, this.o);
            startActivity(intent2);
            finish();
        } else if (id != R.id.rl_start_chat && id == R.id.rl_save_qrt) {
            try {
                a();
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private void a() throws Exception {
        if (!s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("REQUEST_TYPE", "QR_CODE_REQUEST_MONEY");
            jSONObject.put("NAME", this.n);
            jSONObject.put(CJRQRScanResultModel.KEY_MOBILE_NO, this.o);
            jSONObject.put(CJRQRScanResultModel.KEY_PAYEE_TYPE, StringSet.user);
            String jSONObject2 = jSONObject.toString();
            HashMap hashMap = new HashMap();
            hashMap.put(g.ERROR_CORRECTION, f.L);
            if (!TextUtils.isEmpty(jSONObject2)) {
                String a2 = com.google.zxing.client.android.d.b.a(jSONObject2, UpiConstants.QR_KEY);
                Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                int i2 = point.x;
                int i3 = point.y;
                int i4 = i2 < i3 ? i2 : i3;
                try {
                    com.google.zxing.b.b a3 = new l().a(a2, com.google.zxing.a.QR_CODE, i4, i4, hashMap);
                    int i5 = a3.f39889a;
                    int i6 = a3.f39890b;
                    int[] iArr = new int[(i5 * i6)];
                    for (int i7 = 0; i7 < i6; i7++) {
                        int i8 = i7 * i5;
                        for (int i9 = 0; i9 < i5; i9++) {
                            iArr[i8 + i9] = a3.a(i9, i7) ? UpiConstants.QR_KEY_BLUE : -1;
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr, 0, i5, 0, 0, i5, i6);
                    Uri parse = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, "QR_IMAGE", (String) null));
                    ContentValues contentValues = new ContentValues();
                    long currentTimeMillis = System.currentTimeMillis();
                    contentValues.put("date_added", Long.valueOf(currentTimeMillis));
                    contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
                    contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
                    ContentResolver contentResolver = getContentResolver();
                    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ContentUris.parseId(parse));
                    contentResolver.update(uri, contentValues, "_id=?", new String[]{sb.toString()});
                    Toast.makeText(this, getString(R.string.saved_successfully), 0).show();
                } catch (IllegalArgumentException unused) {
                }
            }
        } else {
            s.b((Activity) this);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (s.a(iArr)) {
            try {
                a();
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
