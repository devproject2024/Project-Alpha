package net.one97.paytm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytm.utility.v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRAddresses;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.activity.HomeActionBarBaseActivity;
import net.one97.paytm.landingpage.utils.croptool.CropImage;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upgradeKyc.editprofile.view.c;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.r;

public class AJRProfileActivity extends HomeActionBarBaseActivity {
    private static int y = 110;

    /* renamed from: b  reason: collision with root package name */
    private CJRAddresses f51651b = new CJRAddresses();

    /* renamed from: c  reason: collision with root package name */
    private Fragment f51652c = null;
    private Resources s;
    private RelativeLayout t;
    private int u = 0;
    private String v;
    private boolean w = false;
    private boolean x = false;
    private String z = AppConstants.KEY_EMAIL;

    public void onCreate(Bundle bundle) {
        CJRHomePageItem cJRHomePageItem;
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        this.n = (FrameLayout) findViewById(R.id.content_frame);
        this.n.addView(getLayoutInflater().inflate(R.layout.activity_profile, (ViewGroup) null));
        this.s = getResources();
        a(false);
        this.f52700a = true;
        if (this.f52708d != null) {
            this.f52708d.setDrawerLockMode(1);
        }
        Intent intent = getIntent();
        setTitle(this.s.getString(R.string.edit_profile_txt));
        this.t = (RelativeLayout) findViewById(R.id.lyt_progress_bar);
        if (!isFinishing()) {
            try {
                if (getApplication() != null) {
                    this.f52711g = d.a().q();
                }
                if (this.f52711g == null) {
                    new HomeActionBarBaseActivity.a(this, (byte) 0).execute(new Void[0]);
                } else {
                    isFinishing();
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        if (intent.hasExtra("address_from_account")) {
            if (intent.getBooleanExtra("address_from_account", false)) {
                this.w = true;
                a(1);
            }
        } else if (!intent.hasExtra("saved_card_from_account")) {
            a(0);
        } else if (intent.getBooleanExtra("saved_card_from_account", false)) {
            this.x = true;
            b();
        }
        if (intent != null) {
            try {
                if (intent.hasExtra("extra_home_data") && (cJRHomePageItem = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data")) != null && !TextUtils.isEmpty(cJRHomePageItem.getURLType()) && (cJRHomePageItem.getURLType().equalsIgnoreCase("saved_card") || cJRHomePageItem.getURLType().equalsIgnoreCase("add_card"))) {
                    b();
                }
            } catch (Exception e3) {
                if (b.v) {
                    q.b(e3.getMessage());
                }
            }
        }
        this.v = n.a((Context) this, n.a());
    }

    public void onPostResume() {
        super.onPostResume();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 56) {
            if (s.a(iArr)) {
                Fragment fragment = this.f51652c;
                if (fragment != null && (fragment instanceof c)) {
                    ((c) fragment).i();
                }
            } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                    builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            s.b((Context) AJRProfileActivity.this);
                            AJRProfileActivity.this.finish();
                        }
                    });
                    builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    builder.show();
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
        } else if (i2 != 51) {
        } else {
            if (s.a(iArr)) {
                Fragment fragment2 = this.f51652c;
                if (fragment2 != null && (fragment2 instanceof c)) {
                    ((c) fragment2).j();
                    return;
                }
                return;
            }
            int a2 = s.a(strArr, iArr, "android.permission.CAMERA", this);
            if (a2 != 1 && a2 == 0) {
                try {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                    builder2.setTitle(getResources().getString(R.string.camera_permission_title)).setMessage(getResources().getString(R.string.camera_permission)).setCancelable(false);
                    builder2.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AJRProfileActivity.this.finish();
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            String B = b.B((Context) AJRProfileActivity.this);
                            if (!TextUtils.isEmpty(B)) {
                                intent.setData(Uri.parse("package:".concat(String.valueOf(B))));
                            }
                            AJRProfileActivity.this.startActivity(intent);
                        }
                    });
                    builder2.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AJRProfileActivity.this.finish();
                        }
                    });
                    builder2.show();
                } catch (Exception e3) {
                    if (b.v) {
                        q.b(e3.getMessage());
                    }
                }
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment fragment;
        String stringExtra;
        Fragment fragment2;
        c cVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 312) {
            startActivity(getIntent());
            finish();
            return;
        }
        int i4 = 0;
        if (i2 == 212) {
            if (i3 == -1 && Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
                String str = Environment.getExternalStorageDirectory().toString() + b.am(getApplicationContext());
                if (new File(str).exists()) {
                    File file = new File(str);
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    while (true) {
                        if (i4 < length) {
                            File file2 = listFiles[i4];
                            if (file2.getName().equalsIgnoreCase("picture.jpg")) {
                                file = file2;
                                break;
                            }
                            i4++;
                        }
                    }
                    try {
                        Uri fromFile = Uri.fromFile(new File(file.getAbsolutePath()));
                        if (this.f51652c != null && (this.f51652c instanceof c)) {
                            c cVar2 = (c) this.f51652c;
                            String a2 = a(file.getAbsolutePath());
                            if (a2 != null) {
                                new File(a2);
                                cVar2.a(fromFile);
                                return;
                            }
                            a("", getString(R.string.title_400));
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            }
        } else if (i2 == 211) {
            if (i3 == -1 && (stringExtra = intent.getStringExtra("mobileNumber")) != null && (fragment2 = this.f51652c) != null && (fragment2 instanceof c) && (cVar = (c) fragment2) != null) {
                cVar.a(stringExtra);
            }
        } else if (i2 == 203) {
            CropImage.ActivityResult activityResult = intent != null ? (CropImage.ActivityResult) intent.getParcelableExtra(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage.CROP_IMAGE_EXTRA_RESULT) : null;
            if (i3 != -1) {
                return;
            }
            if (activityResult == null) {
                Toast.makeText(this, getString(R.string.something_wrong_try_again), 1).show();
            } else if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
                String str2 = Environment.getExternalStorageDirectory().toString() + b.am(getApplicationContext());
                if (new File(str2).exists()) {
                    File file3 = new File(str2);
                    File[] listFiles2 = file3.listFiles();
                    int length2 = listFiles2.length;
                    while (true) {
                        if (i4 < length2) {
                            File file4 = listFiles2[i4];
                            if (file4.getName().equalsIgnoreCase("picture.jpg")) {
                                file3 = file4;
                                break;
                            }
                            i4++;
                        }
                    }
                    try {
                        Uri fromFile2 = Uri.fromFile(new File(file3.getAbsolutePath()));
                        if (this.f51652c != null && (this.f51652c instanceof c)) {
                            c cVar3 = (c) this.f51652c;
                            String a3 = a(file3.getAbsolutePath());
                            if (a3 != null) {
                                File file5 = new File(a3);
                                k.c(file5, "picUri");
                                k.c(fromFile2, "selectedImage");
                                try {
                                    FragmentActivity activity = cVar3.getActivity();
                                    if (activity == null) {
                                        k.a();
                                    }
                                    k.a((Object) activity, "this.activity!!");
                                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), fromFile2);
                                    b.a aVar = com.paytm.utility.b.b.f43744a;
                                    FragmentActivity activity2 = cVar3.getActivity();
                                    if (activity2 == null) {
                                        k.a();
                                    }
                                    k.a((Object) activity2, "activity!!");
                                    b.a.C0750a a4 = b.a.a(activity2);
                                    a4.f43753a = bitmap;
                                    b.a.C0750a a5 = b.a.C0750a.a(a4, a.c.HOME.name());
                                    a5.n = true;
                                    b.a.C0750a.a(a5, (AppCompatImageView) cVar3.a(R.id.edit_profile_user_iv), (com.paytm.utility.b.b.b) null, 2);
                                    cVar3.a(file5);
                                    cVar3.e().t.setValue(x.f47997a);
                                } catch (ActivityNotFoundException e3) {
                                    q.b(e3.getMessage());
                                } catch (FileNotFoundException e4) {
                                    q.b(e4.getMessage());
                                } catch (IOException e5) {
                                    q.b(e5.getMessage());
                                } catch (Exception unused) {
                                }
                            } else {
                                a("", getString(R.string.title_400));
                            }
                        }
                    } catch (Exception e6) {
                        q.b(e6.getMessage());
                    }
                }
            } else {
                Toast.makeText(this, getString(R.string.something_wrong_try_again), 1).show();
            }
        } else if (i2 == y && i3 == -1 && (fragment = this.f51652c) != null && (fragment instanceof c) && intent != null && intent.getStringExtra(this.z) != null) {
            c cVar4 = (c) this.f51652c;
            k.c(intent, "intent");
            ((AppCompatEditText) cVar4.a(R.id.display_email_et)).setText(intent.getStringExtra(cVar4.f65927a));
            String string = cVar4.getString(R.string.email_update_success);
            k.a((Object) string, "getString(R.string.email_update_success)");
            cVar4.b("#21C17A", string);
            Context context = cVar4.getContext();
            if (context != null) {
                androidx.localbroadcastmanager.a.a.a(context).a(new Intent("email_updated"));
            }
        }
    }

    private static String a(String str) {
        int i2;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        File file = new File(str);
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= 0) {
            i3 = 1;
        }
        if (i4 <= 0) {
            i4 = 1;
        }
        float f2 = (float) (i4 / i2);
        float f3 = (float) i2;
        if (f3 > 816.0f || ((float) i4) > 612.0f) {
            if (f2 < 0.75f) {
                i4 = (int) ((816.0f / f3) * ((float) i4));
                i2 = 816;
            } else {
                i2 = f2 > 0.75f ? (int) ((612.0f / ((float) i4)) * f3) : 816;
                i4 = 612;
            }
        }
        options.inSampleSize = a(options, i4, i2);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e2) {
            q.b(e2.getMessage());
        }
        try {
            bitmap = Bitmap.createBitmap(i4, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e3) {
            q.b(e3.getMessage());
        }
        float f4 = (float) i4;
        float f5 = f4 / ((float) options.outWidth);
        float f6 = (float) i2;
        float f7 = f6 / ((float) options.outHeight);
        float f8 = f4 / 2.0f;
        float f9 = f6 / 2.0f;
        if (decodeFile != null) {
            Matrix matrix = new Matrix();
            matrix.setScale(f5, f7, f8, f9);
            Canvas canvas = new Canvas(bitmap);
            canvas.setMatrix(matrix);
            if (decodeFile.getWidth() / 2 == 0 && decodeFile.getHeight() / 2 == 0) {
                canvas.drawBitmap(decodeFile, 0.0f, 0.0f, new Paint(2));
            } else if (decodeFile.getWidth() / 2 == 0) {
                canvas.drawBitmap(decodeFile, 0.0f, f9 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
            } else if (decodeFile.getHeight() / 2 == 0) {
                canvas.drawBitmap(decodeFile, f8 - ((float) (decodeFile.getWidth() / 2)), 0.0f, new Paint(2));
            } else {
                canvas.drawBitmap(decodeFile, f8 - ((float) (decodeFile.getWidth() / 2)), f9 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
            }
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
                Matrix matrix2 = new Matrix();
                if (attributeInt == 6) {
                    matrix2.postRotate(90.0f);
                } else if (attributeInt == 3) {
                    matrix2.postRotate(180.0f);
                } else if (attributeInt == 8) {
                    matrix2.postRotate(270.0f);
                }
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
            } catch (IOException e4) {
                q.b(e4.getMessage());
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str));
            } catch (FileNotFoundException e5) {
                q.b(e5.getMessage());
            }
        }
        return str;
    }

    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4;
        int i5 = options.outHeight;
        int i6 = options.outWidth;
        if (i5 > i3 || i6 > i2) {
            i4 = Math.round(((float) i5) / ((float) i3));
            int round = Math.round(((float) i6) / ((float) i2));
            if (i4 >= round) {
                i4 = round;
            }
        } else {
            i4 = 1;
        }
        while (((float) (i6 * i5)) / ((float) (i4 * i4)) > ((float) (i2 * i3 * 2))) {
            i4++;
        }
        return i4;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        b(false);
        c(false);
        return super.onPrepareOptionsMenu(menu);
    }

    private void a() {
        if (this.t != null && !isFinishing()) {
            this.t.setVisibility(8);
        }
    }

    private void b() {
        d.a().a("/saved-cards", "", getApplicationContext());
        a(2);
    }

    public void onResume() {
        super.onResume();
        this.u++;
        if (this.u > 1) {
            if (d.b().d(this) == null) {
                a a2 = d.a(this, d.b().a("cartv2") + com.paytm.utility.c.a(getBaseContext(), false), new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel instanceof CJRShoppingCart) {
                            CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRPaytmDataModel;
                            if (cJRShoppingCart.getCart() != null && cJRShoppingCart.getCart().getCartItems() != null) {
                                d.a().a(cJRShoppingCart, (Context) AJRProfileActivity.this);
                            }
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        net.one97.paytm.prime.f.a aVar = new net.one97.paytm.prime.f.a();
                        aVar.setAlertMessage(networkCustomError.getAlertMessage());
                        aVar.setmAlertTitle(networkCustomError.getAlertTitle());
                        StringBuilder sb = new StringBuilder();
                        sb.append(networkCustomError.getErrorType());
                        aVar.setmErrorCode(sb.toString());
                        aVar.setUniqueReference(networkCustomError.getUniqueReference());
                        aVar.setUrl(networkCustomError.getFullUrl());
                        AJRProfileActivity aJRProfileActivity = AJRProfileActivity.this;
                        net.one97.paytm.prime.f.a aVar2 = aVar;
                        if (v.a(aVar2.getFullUrl())) {
                            return;
                        }
                        if (("410".equals(aVar2.getmErrorCode()) || UpiUtils.AUTHENTICATION_FAILURE_401.equals(aVar2.getmErrorCode())) && !aJRProfileActivity.isFinishing()) {
                            String name = aJRProfileActivity.getClass().getName();
                            new NetworkCustomError();
                            r.a((Activity) aJRProfileActivity, name, (Bundle) null);
                        }
                    }
                }, com.paytm.utility.a.a((HashMap<String, String>) new HashMap(), (Context) this), (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRShoppingCart(), a.c.HOME, a.b.SILENT);
                if (!com.paytm.utility.a.m(this)) {
                    a(a2);
                } else if (a2 != null) {
                    a2.a();
                } else {
                    com.paytm.utility.a.c();
                }
            }
            String a3 = n.a((Context) this, n.a());
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            if (TextUtils.isEmpty(this.v) || !this.v.equalsIgnoreCase(a3)) {
                finish();
            }
        }
    }

    private void a(String str, CharSequence charSequence) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.layout_sucess_otp_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.sucess_msg);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sucess_number);
        View findViewById = inflate.findViewById(R.id.seperator);
        if (str.trim().length() > 0) {
            textView.setText(str);
        } else {
            textView.setVisibility(8);
            findViewById.setVisibility(8);
        }
        textView3.setVisibility(8);
        textView2.setText(charSequence);
        Button button = (Button) inflate.findViewById(R.id.btn_ok);
        button.setText(R.string.ok);
        builder.setInverseBackgroundForced(true);
        builder.setCancelable(false);
        builder.setView(inflate);
        final AlertDialog show = builder.show();
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                show.dismiss();
            }
        });
    }

    private void a(int i2) {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        if (i2 == 0) {
            c cVar = new c();
            setTitle("");
            a();
            this.f51652c = cVar;
            if (getSupportActionBar() != null) {
                getSupportActionBar().a(0.0f);
                getSupportActionBar().f();
            }
        }
        if (this.f51652c != null) {
            a2.b(R.id.activity_profile_lyt_frame, this.f51652c, (String) null).b();
        }
    }

    public void onBackPressed() {
        Fragment fragment = this.f51652c;
        if (fragment == null || !(fragment instanceof c)) {
            super.onBackPressed();
            return;
        }
        c cVar = (c) fragment;
        FrameLayout frameLayout = (FrameLayout) cVar.a(R.id.galleryContainer);
        k.a((Object) frameLayout, "galleryContainer");
        if (f.d(frameLayout)) {
            cVar.f();
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) cVar.a(R.id.viewProfileContainer);
        k.a((Object) frameLayout2, "viewProfileContainer");
        if (f.d(frameLayout2)) {
            cVar.g();
        } else {
            super.onBackPressed();
        }
    }
}
