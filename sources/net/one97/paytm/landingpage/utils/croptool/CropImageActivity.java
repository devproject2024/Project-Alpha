package net.one97.paytm.landingpage.utils.croptool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.File;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.utils.croptool.CropImage;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;

public class CropImageActivity extends PaytmActivity implements View.OnClickListener, CropImageView.d, CropImageView.h {

    /* renamed from: a  reason: collision with root package name */
    private CropImageView f52909a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f52910b;

    /* renamed from: c  reason: collision with root package name */
    private CropImageOptions f52911c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.crop_image_activity_v2);
        this.f52909a = (CropImageView) findViewById(R.id.cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.f52910b = (Uri) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE);
        this.f52911c = (CropImageOptions) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS);
        if (bundle == null) {
            Uri uri = this.f52910b;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (CropImage.a((Context) this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
                } else {
                    Intent intent = getIntent();
                    boolean z = true;
                    boolean z2 = intent != null && intent.getBooleanExtra("is_camera_needed", false);
                    Intent intent2 = getIntent();
                    if (intent2 == null || !intent2.getBooleanExtra("is_gallery_neeedd", false)) {
                        z = false;
                    }
                    startActivityForResult(CropImage.a(this, z2, z), 200);
                }
            } else if (CropImage.a((Context) this, this.f52910b)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.f52909a.setImageUriAsync(this.f52910b);
            }
        }
        findViewById(R.id.cancelText).setOnClickListener(this);
        findViewById(R.id.chooseText).setOnClickListener(this);
        findViewById(R.id.rotateView).setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        this.f52909a.setOnSetImageUriCompleteListener(this);
        this.f52909a.setOnCropImageCompleteListener(this);
    }

    public void onStop() {
        super.onStop();
        this.f52909a.setOnSetImageUriCompleteListener((CropImageView.h) null);
        this.f52909a.setOnCropImageCompleteListener((CropImageView.d) null);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.crop_image_menu, menu);
        if (!this.f52911c.O) {
            menu.removeItem(R.id.crop_image_menu_rotate_left);
            menu.removeItem(R.id.crop_image_menu_rotate_right);
        } else if (this.f52911c.Q) {
            menu.findItem(R.id.crop_image_menu_rotate_left).setVisible(true);
        }
        if (!this.f52911c.P) {
            menu.removeItem(R.id.crop_image_menu_flip);
        }
        if (this.f52911c.U != null) {
            menu.findItem(R.id.crop_image_menu_crop).setTitle(this.f52911c.U);
        }
        Drawable drawable = null;
        try {
            if (this.f52911c.V != 0) {
                drawable = b.a((Context) this, this.f52911c.V);
                menu.findItem(R.id.crop_image_menu_crop).setIcon(drawable);
            }
        } catch (Exception unused) {
        }
        if (this.f52911c.E != 0) {
            a(menu, R.id.crop_image_menu_rotate_left, this.f52911c.E);
            a(menu, R.id.crop_image_menu_rotate_right, this.f52911c.E);
            a(menu, R.id.crop_image_menu_flip, this.f52911c.E);
            if (drawable != null) {
                a(menu, R.id.crop_image_menu_crop, this.f52911c.E);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.crop_image_menu_crop) {
            a();
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_left) {
            a(-this.f52911c.R);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_rotate_right) {
            a(this.f52911c.R);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_horizontally) {
            CropImageView cropImageView = this.f52909a;
            cropImageView.f52923c = !cropImageView.f52923c;
            cropImageView.a((float) cropImageView.getWidth(), (float) cropImageView.getHeight(), true, false);
            return true;
        } else if (menuItem.getItemId() == R.id.crop_image_menu_flip_vertically) {
            CropImageView cropImageView2 = this.f52909a;
            cropImageView2.f52924d = !cropImageView2.f52924d;
            cropImageView2.a((float) cropImageView2.getWidth(), (float) cropImageView2.getHeight(), true, false);
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
                this.f52910b = (z || intent.getData() == null) ? CropImage.b(this) : intent.getData();
                if (CropImage.a((Context) this, this.f52910b)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f52909a.setImageUriAsync(this.f52910b);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 201) {
            Uri uri = this.f52910b;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, R.string.permission_not_granted, 1).show();
                c();
            } else {
                this.f52909a.setImageUriAsync(uri);
            }
            if (s.a(iArr)) {
                a(this, "app_permissions", "app_permissions_provided", "camera=true", "crop image profile screen", "app_permission");
            } else {
                a(this, "app_permissions", "app_permissions_provided", "camera=false", "crop image profile screen", "app_permission");
            }
        }
        if (i2 == 2011) {
            startActivityForResult(CropImage.a(Activity.class.cast(this), true, true), 200);
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            d.a().a(context, str, str2, str3, str4, str5);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public final void a(Exception exc) {
        if (exc == null) {
            if (this.f52911c.M != null) {
                this.f52909a.setCropRect(this.f52911c.M);
            }
            if (this.f52911c.N >= 0) {
                this.f52909a.setRotatedDegrees(this.f52911c.N);
                return;
            }
            return;
        }
        a((Uri) null, exc, 1);
    }

    private void a() {
        if (this.f52911c.L) {
            a((Uri) null, (Exception) null, 1);
            return;
        }
        this.f52909a.a(b(), this.f52911c.G, this.f52911c.H, this.f52911c.I, this.f52911c.J, this.f52911c.K);
    }

    private void a(int i2) {
        this.f52909a.a(i2);
    }

    private Uri b() {
        if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            try {
                String str = Environment.getExternalStorageDirectory().toString() + com.paytm.utility.b.am(this);
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
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(this.f52909a.getImageUri(), uri, exc, this.f52909a.getCropPoints(), this.f52909a.getCropRect(), this.f52909a.getRotatedDegrees(), this.f52909a.getWholeImageRect(), i2);
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
        int id = view.getId();
        if (id == R.id.cancelText) {
            c();
        } else if (id == R.id.chooseText) {
            a();
        } else if (id == R.id.rotateView) {
            a(-this.f52911c.R);
        }
    }

    public final void a(CropImageView.a aVar) {
        a(aVar.f52932b, aVar.f52933c, aVar.f52938h);
    }
}
