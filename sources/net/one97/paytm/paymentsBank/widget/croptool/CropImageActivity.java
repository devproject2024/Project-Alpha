package net.one97.paytm.paymentsBank.widget.croptool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.File;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.widget.croptool.CropImage;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

public class CropImageActivity extends PaytmActivity implements View.OnClickListener, PBCropImageView.d, PBCropImageView.h {

    /* renamed from: a  reason: collision with root package name */
    private PBCropImageView f19650a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f19651b;

    /* renamed from: c  reason: collision with root package name */
    private String f19652c;

    /* renamed from: d  reason: collision with root package name */
    private CropImageOptions f19653d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_crop_image_activity);
        this.f19650a = (PBCropImageView) findViewById(R.id.cropImageView);
        this.f19652c = getIntent().getStringExtra("CROP_IMAGE_FILE_PATH");
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.f19651b = (Uri) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE);
        this.f19653d = (CropImageOptions) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS);
        if (bundle == null) {
            Uri uri = this.f19651b;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (CropImage.a((Context) this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
                } else {
                    CropImage.a((Activity) this);
                }
            } else if (CropImage.a((Context) this, this.f19651b)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.f19650a.setImageUriAsync(this.f19651b);
            }
        }
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.rel_center_crop).setOnClickListener(this);
        findViewById(R.id.rel_left_crop).setOnClickListener(this);
        findViewById(R.id.rel_ryt_crop).setOnClickListener(this);
        findViewById(R.id.done_crop_tv).setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        this.f19650a.setOnSetImageUriCompleteListener(this);
        this.f19650a.setOnCropImageCompleteListener(this);
    }

    public void onStop() {
        super.onStop();
        this.f19650a.setOnSetImageUriCompleteListener((PBCropImageView.h) null);
        this.f19650a.setOnCropImageCompleteListener((PBCropImageView.d) null);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pb_crop_image_menu, menu);
        if (!this.f19653d.O) {
            menu.removeItem(R.id.crop_image_menu_rotate_left);
            menu.removeItem(R.id.crop_image_menu_rotate_right);
        } else if (this.f19653d.Q) {
            menu.findItem(R.id.crop_image_menu_rotate_left).setVisible(true);
        }
        if (!this.f19653d.P) {
            menu.removeItem(R.id.crop_image_menu_flip);
        }
        if (this.f19653d.U != null) {
            menu.findItem(R.id.crop_image_menu_crop).setTitle(this.f19653d.U);
        }
        Drawable drawable = null;
        try {
            if (this.f19653d.V != 0) {
                drawable = b.a((Context) this, this.f19653d.V);
                menu.findItem(R.id.crop_image_menu_crop).setIcon(drawable);
            }
        } catch (Exception unused) {
        }
        if (this.f19653d.E != 0) {
            a(menu, R.id.crop_image_menu_rotate_left, this.f19653d.E);
            a(menu, R.id.crop_image_menu_rotate_right, this.f19653d.E);
            a(menu, R.id.crop_image_menu_flip, this.f19653d.E);
            if (drawable != null) {
                a(menu, R.id.crop_image_menu_crop, this.f19653d.E);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.crop_image_menu_crop) {
            a();
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_left) {
            a(-this.f19653d.R);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_right) {
            a(this.f19653d.R);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_horizontally) {
            PBCropImageView pBCropImageView = this.f19650a;
            pBCropImageView.f19675c = !pBCropImageView.f19675c;
            pBCropImageView.a((float) pBCropImageView.getWidth(), (float) pBCropImageView.getHeight(), true, false);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_vertically) {
            PBCropImageView pBCropImageView2 = this.f19650a;
            pBCropImageView2.f19676d = !pBCropImageView2.f19676d;
            pBCropImageView2.a((float) pBCropImageView2.getWidth(), (float) pBCropImageView2.getHeight(), true, false);
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            c();
            return true;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String action;
        if (i2 == 200) {
            if (i3 == 0) {
                c();
            }
            if (i3 == -1) {
                boolean z = true;
                if (!(intent == null || intent.getData() == null || ((action = intent.getAction()) != null && action.equals("android.media.action.IMAGE_CAPTURE")))) {
                    z = false;
                }
                this.f19651b = (z || intent.getData() == null) ? CropImage.b(this) : intent.getData();
                if (CropImage.a((Context) this, this.f19651b)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f19650a.setImageUriAsync(this.f19651b);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 201) {
            Uri uri = this.f19651b;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, R.string.pb_permission_not_granted, 1).show();
                c();
            } else {
                this.f19650a.setImageUriAsync(uri);
            }
        }
        if (i2 == 2011) {
            CropImage.a((Activity) this);
        }
    }

    public final void a(Exception exc) {
        if (exc == null) {
            if (this.f19653d.M != null) {
                this.f19650a.setCropRect(this.f19653d.M);
            }
            if (this.f19653d.N >= 0) {
                this.f19650a.setRotatedDegrees(this.f19653d.N);
                return;
            }
            return;
        }
        a((Uri) null, exc, 1);
    }

    private void a() {
        if (this.f19653d.L) {
            a((Uri) null, (Exception) null, 1);
            return;
        }
        this.f19650a.a(b(), this.f19653d.G, this.f19653d.H, this.f19653d.I, this.f19653d.J, this.f19653d.K);
    }

    private void a(int i2) {
        this.f19650a.a(i2);
    }

    private Uri b() {
        String str;
        if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            try {
                if (!TextUtils.isEmpty(this.f19652c)) {
                    str = this.f19652c;
                } else {
                    str = Environment.getExternalStorageDirectory().toString() + com.paytm.utility.b.am(this);
                }
                File file = new File(str);
                boolean z = true;
                if (!file.exists()) {
                    z = file.mkdirs();
                }
                if (z) {
                    return Uri.fromFile(new File(str + "/picture.jpg"));
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void a(Uri uri, Exception exc, int i2) {
        setResult(exc == null ? -1 : CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, b(uri, exc, i2));
        finish();
    }

    private void c() {
        setResult(0);
        finish();
    }

    private Intent b(Uri uri, Exception exc, int i2) {
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(this.f19650a.getImageUri(), uri, exc, this.f19650a.getCropPoints(), this.f19650a.getCropRect(), this.f19650a.getRotatedDegrees(), this.f19650a.getWholeImageRect(), i2);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage.CROP_IMAGE_EXTRA_RESULT, activityResult);
        return intent;
    }

    private static void a(Menu menu, int i2, int i3) {
        Drawable icon;
        MenuItem findItem = menu.findItem(i2);
        if (findItem != null && (icon = findItem.getIcon()) != null) {
            try {
                icon.mutate();
                icon.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (Exception unused) {
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.close) {
            c();
        } else if (view.getId() == R.id.rel_center_crop) {
            a();
        } else if (view.getId() == R.id.rel_left_crop) {
            a(-this.f19653d.R);
        } else if (view.getId() == R.id.rel_ryt_crop) {
            a(this.f19653d.R);
        } else if (view.getId() == R.id.done_crop_tv) {
            a();
        }
    }

    public final void a(PBCropImageView.a aVar) {
        a(aVar.f19683b, aVar.f19684c, aVar.f19689h);
    }
}
