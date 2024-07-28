package net.one97.paytm.wallet.newdesign.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.models.ScanAadhaarCardModel;

public class ScanAadhaarCardActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    String f70551a = "";

    /* renamed from: b  reason: collision with root package name */
    File f70552b;

    /* renamed from: c  reason: collision with root package name */
    private ScanAadhaarCardModel f70553c = new ScanAadhaarCardModel();

    /* renamed from: d  reason: collision with root package name */
    private TextView f70554d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f70555e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70556f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70557g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70558h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f70559i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private LinearLayout r;
    private RelativeLayout s;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.scan_aadhaar_card_activity);
        if (getIntent() != null && getIntent().hasExtra("model")) {
            this.f70553c = (ScanAadhaarCardModel) getIntent().getSerializableExtra("model");
        }
        this.l = (ImageView) findViewById(R.id.back_arrow);
        this.f70554d = (TextView) findViewById(R.id.adhar_name);
        this.f70555e = (TextView) findViewById(R.id.dob_details);
        this.f70556f = (TextView) findViewById(R.id.gender);
        this.f70557g = (TextView) findViewById(R.id.adhaarnumber);
        this.f70558h = (TextView) findViewById(R.id.adhaarnumber1);
        this.f70559i = (TextView) findViewById(R.id.adhaarnumber2);
        this.j = (TextView) findViewById(R.id.adhaarnumberback);
        this.p = (TextView) findViewById(R.id.adhaarnumberback1);
        this.q = (TextView) findViewById(R.id.adhaarnumberback2);
        this.k = (TextView) findViewById(R.id.address);
        this.n = (TextView) findViewById(R.id.save_gallary);
        this.m = (ImageView) findViewById(R.id.share_click);
        this.s = (RelativeLayout) findViewById(R.id.Successfullscreen);
        this.o = (TextView) findViewById(R.id.open_gallery);
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanAadhaarCardActivity scanAadhaarCardActivity = ScanAadhaarCardActivity.this;
                if (TextUtils.isEmpty(scanAadhaarCardActivity.f70551a)) {
                    scanAadhaarCardActivity.a();
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (s.b()) {
                    Context applicationContext = scanAadhaarCardActivity.getApplicationContext();
                    Uri uriForFile = FileProvider.getUriForFile(applicationContext, b.a().getApplicationId() + ".provider", scanAadhaarCardActivity.f70552b);
                    intent.setFlags(1);
                    intent.setDataAndType(uriForFile, "image/*");
                } else {
                    intent.setDataAndType(Uri.fromFile(scanAadhaarCardActivity.f70552b), "image/*");
                }
                scanAadhaarCardActivity.startActivity(Intent.createChooser(intent, "Open [App] images"));
            }
        });
        this.r = (LinearLayout) findViewById(R.id.screenshot);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanAadhaarCardActivity.this.finish();
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanAadhaarCardActivity.this.a();
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ScanAadhaarCardActivity.b(ScanAadhaarCardActivity.this);
            }
        });
        this.f70554d.setText(this.f70553c.getName());
        if (!TextUtils.isEmpty(this.f70553c.getDob())) {
            this.f70555e.setText(this.f70553c.getDob());
        } else if (TextUtils.isEmpty(this.f70553c.getYob())) {
            this.f70555e.setText(this.f70553c.getYob());
        }
        this.f70556f.setText(this.f70553c.getGender());
        if (this.f70553c.getGender().equalsIgnoreCase("M")) {
            this.f70556f.setText("MALE");
        } else {
            this.f70556f.setText("FEMALE");
        }
        String uid = this.f70553c.getUid();
        this.f70557g.setText(uid.substring(0, 4));
        this.f70558h.setText(uid.substring(4, 8));
        this.f70559i.setText(uid.substring(8, 12));
        this.j.setText(uid.substring(0, 4));
        this.p.setText(uid.substring(4, 8));
        this.q.setText(uid.substring(8, 12));
        this.k.setText(this.f70553c.getAddress());
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!s.a() || s.c((Activity) this)) {
            a((View) this.r);
        } else {
            s.b((Activity) this);
        }
    }

    private void a(View view) {
        Date date = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);
        try {
            view.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
            this.f70552b = new File(Environment.getExternalStorageDirectory().toString() + "/" + date + ".jpeg");
            FileOutputStream fileOutputStream = new FileOutputStream(this.f70552b);
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            this.s.setVisibility(0);
            this.n.setVisibility(8);
            Toast.makeText(this, "Screenshot is sucessfully saved", 0).show();
            this.f70551a = this.f70552b.getPath();
        } catch (Throwable th) {
            q.d(String.valueOf(th));
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 56) {
            return;
        }
        if (s.a(iArr)) {
            a((View) this.r);
        } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        s.b((Context) ScanAadhaarCardActivity.this);
                        ScanAadhaarCardActivity.this.finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                builder.show();
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    static /* synthetic */ void b(ScanAadhaarCardActivity scanAadhaarCardActivity) {
        if (scanAadhaarCardActivity.f70552b != null) {
            if (TextUtils.isEmpty(scanAadhaarCardActivity.f70551a)) {
                scanAadhaarCardActivity.a();
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", "Check out adhaar screenshot!");
            if (s.b()) {
                Context applicationContext = scanAadhaarCardActivity.getApplicationContext();
                Uri uriForFile = FileProvider.getUriForFile(applicationContext, b.a().getApplicationId() + ".provider", scanAadhaarCardActivity.f70552b);
                intent.setFlags(1);
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
            } else {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(scanAadhaarCardActivity.f70552b));
            }
            intent.setType("image/jpeg");
            intent.addFlags(1);
            scanAadhaarCardActivity.startActivity(Intent.createChooser(intent, AppConstants.SHARE));
        }
    }
}
