package net.one97.paytm.upi.profile.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.profile.a.j;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiQrCodeActivity extends PaytmActivity implements View.OnClickListener, j.b {

    /* renamed from: a  reason: collision with root package name */
    private TextView f68177a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f68178b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68179c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f68180d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68181e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f68182f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f68183g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f68184h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressBar f68185i;
    private RelativeLayout j;
    private LinearLayout k;
    /* access modifiers changed from: private */
    public EditText l;
    private boolean m;
    private RelativeLayout n;
    private RelativeLayout o;
    private j.a p;

    public final /* synthetic */ void a(Object obj) {
        ((j.a) obj).e();
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, UpiQrCodeActivity.class);
        intent.putExtra("amount", str);
        intent.putExtra(UpiConstants.EXTRA_SELECTED_VPA, str2);
        intent.putExtra(UpiConstants.EXTRA_OPTIONAL_DESC, str3);
        context.startActivity(intent);
    }

    public static void a(Context context, UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(context, UpiQrCodeActivity.class);
        intent.putExtra(UpiConstants.EXTRA_VPA_DATA, upiProfileDefaultBank);
        context.startActivity(intent);
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_qr_code);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiQrCodeActivity.this.onBackPressed();
            }
        });
        this.f68177a = (TextView) findViewById(R.id.tv_qr_amount);
        this.f68178b = (ImageView) findViewById(R.id.iv_qr_code);
        this.f68179c = (TextView) findViewById(R.id.tv_vpa);
        this.f68180d = (TextView) findViewById(R.id.tv_name);
        this.f68181e = (TextView) findViewById(R.id.tv_add_amount);
        this.f68182f = (TextView) findViewById(R.id.tv_share_qr);
        this.f68183g = (TextView) findViewById(R.id.tv_share_qr_centre);
        this.f68185i = (ProgressBar) findViewById(R.id.pb_loading);
        this.j = (RelativeLayout) findViewById(R.id.lyt_error);
        this.k = (LinearLayout) findViewById(R.id.ll_content);
        this.n = (RelativeLayout) findViewById(R.id.rl_share_qr);
        this.o = (RelativeLayout) findViewById(R.id.rl_enter_amount);
        this.l = (EditText) this.o.findViewById(R.id.edt_amount);
        this.f68184h = (TextView) findViewById(R.id.tv_done);
        if (getIntent() != null) {
            UpiProfileDefaultBank upiProfileDefaultBank = null;
            if (getIntent().hasExtra(UpiConstants.EXTRA_VPA_DATA)) {
                upiProfileDefaultBank = (UpiProfileDefaultBank) getIntent().getSerializableExtra(UpiConstants.EXTRA_VPA_DATA);
            }
            this.p = new net.one97.paytm.upi.profile.presenter.j(this, upiProfileDefaultBank, g.a());
        }
        this.l.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                UpiQrCodeActivity.this.l.setError((CharSequence) null);
            }
        });
        this.f68181e.setOnClickListener(this);
        this.f68182f.setOnClickListener(this);
        this.f68183g.setOnClickListener(this);
        this.f68184h.setOnClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public final void a() {
        this.f68185i.setVisibility(0);
    }

    public final void b() {
        this.f68185i.setVisibility(8);
    }

    public final void a(String str, String str2, String str3, String str4) {
        this.k.setVisibility(0);
        this.j.setVisibility(8);
        this.f68179c.setText(str3);
        this.f68180d.setText(str2);
        if (!TextUtils.isEmpty(str4)) {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.f68177a.setVisibility(0);
            this.f68183g.setVisibility(0);
            UpiAppUtils.updateAmount(getString(R.string.upi_qr_amount, new Object[]{str4}), this.f68177a);
        }
        try {
            this.f68178b.setImageBitmap(UpiAppUtils.generateQR(str.toString(), this, UpiAppUtils.convertDpToPixel(204.0f, this), UpiAppUtils.convertDpToPixel(204.0f, this), false));
        } catch (Exception e2) {
            e2.printStackTrace();
            this.k.setVisibility(8);
            this.j.setVisibility(0);
        }
    }

    private void c() {
        this.m = false;
        if (Build.VERSION.SDK_INT < 23 || !PermissionUtil.isVersionMarshmallowAndAbove() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            UpiUtils.shareSuccessfulTransaction(this, this.k, getString(R.string.qr_share_subject_new), getString(R.string.qr_share_body_new), getString(R.string.qr_share_title), 0);
            return;
        }
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 100) {
            return;
        }
        if (!PermissionUtil.verifyPermissions(iArr)) {
            try {
                Toast.makeText(this, R.string.write_to_sdcard_permission_alert_msg, 1).show();
            } catch (Exception unused) {
            }
        } else if (this.m) {
            this.m = true;
            if (Build.VERSION.SDK_INT < 23 || !PermissionUtil.isVersionMarshmallowAndAbove() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                LinearLayout linearLayout = this.k;
                Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Bitmap.Config.ARGB_8888);
                linearLayout.draw(new Canvas(createBitmap));
                if (!TextUtils.isEmpty(MediaStore.Images.Media.insertImage(getContentResolver(), createBitmap, getString(R.string.title), (String) null))) {
                    Toast.makeText(this, getString(R.string.saved_successfully), 0).show();
                    return;
                }
                return;
            }
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
        } else {
            c();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_share_qr || id == R.id.tv_share_qr_centre) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "share_qr_clicked", "", "", "", "/bhim-upi/qr", "wallet");
            c();
        } else if (id == R.id.tv_add_amount) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            try {
                ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.l, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (id == R.id.tv_done) {
            this.p.a(this.l.getText().toString());
            try {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.l.getWindowToken(), 0);
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str) {
        this.l.setError(str);
    }

    public final void b(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || "410".equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
            k kVar = i.a().k;
            UpiQrCodeActivity.class.getSimpleName();
            kVar.e(this);
            return;
        }
        b.b((Context) this, "Error", upiCustomVolleyError.getAlertMessage());
    }
}
