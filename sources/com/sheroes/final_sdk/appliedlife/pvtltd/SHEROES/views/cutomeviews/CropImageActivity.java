package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView;
import java.io.File;
import java.io.IOException;

public class CropImageActivity extends AppCompatActivity implements CropImageView.OnCropImageCompleteListener, CropImageView.OnSetImageUriCompleteListener {
    private Uri mCropImageUri;
    CropImageView mCropImageView;
    private int mImageSelectOptionPicker;
    private CropImageOptions mOptions;

    public void onCreate(Bundle bundle) {
        CharSequence charSequence;
        super.onCreate(bundle);
        setContentView(R.layout.crop_sheroes_image_activity);
        this.mCropImageView = (CropImageView) findViewById(R.id.sheroes_cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra("bundle");
        this.mCropImageUri = (Uri) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE);
        this.mOptions = (CropImageOptions) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS);
        this.mImageSelectOptionPicker = bundleExtra.getInt(CropImage.OPTION_TO_BE_OPEN);
        if (bundle == null) {
            Uri uri = this.mCropImageUri;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (CropImage.isExplicitCameraPermissionRequired(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
                } else {
                    CropImage.startPickImageActivity(this, this.mImageSelectOptionPicker);
                }
            } else if (CropImage.isReadExternalStoragePermissionsRequired(this, this.mCropImageUri)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.mCropImageView.setImageUriAsync(this.mCropImageUri);
            }
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (this.mOptions.activityTitle == null || this.mOptions.activityTitle.length() <= 0) {
                charSequence = getResources().getString(R.string.sheroes_crop_image_activity_title);
            } else {
                charSequence = this.mOptions.activityTitle;
            }
            supportActionBar.a(charSequence);
            supportActionBar.b(true);
        }
    }

    public void onStart() {
        super.onStart();
        this.mCropImageView.setOnSetImageUriCompleteListener(this);
        this.mCropImageView.setOnCropImageCompleteListener(this);
    }

    public void onStop() {
        super.onStop();
        this.mCropImageView.setOnSetImageUriCompleteListener((CropImageView.OnSetImageUriCompleteListener) null);
        this.mCropImageView.setOnCropImageCompleteListener((CropImageView.OnCropImageCompleteListener) null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResultCancel();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 200) {
            if (i3 == 0) {
                setResultCancel();
            }
            if (i3 == -1) {
                this.mCropImageUri = CropImage.getPickImageResultUri(this, intent);
                if (CropImage.isReadExternalStoragePermissionsRequired(this, this.mCropImageUri)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.mCropImageView.setImageUriAsync(this.mCropImageUri);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 201) {
            Uri uri = this.mCropImageUri;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Cancelling, required permissions are not granted", 1).show();
                setResultCancel();
            } else {
                this.mCropImageView.setImageUriAsync(uri);
            }
        }
        if (i2 == 2011) {
            CropImage.startPickImageActivity(this, this.mImageSelectOptionPicker);
        }
    }

    public void onSetImageUriComplete(CropImageView cropImageView, Uri uri, Exception exc) {
        if (exc == null) {
            if (this.mOptions.initialCropWindowRectangle != null) {
                this.mCropImageView.setCropRect(this.mOptions.initialCropWindowRectangle);
            }
            if (this.mOptions.initialRotation >= 0) {
                this.mCropImageView.setRotatedDegrees(this.mOptions.initialRotation);
                return;
            }
            return;
        }
        setResult((Uri) null, exc, 1);
    }

    public void onCropImageComplete(CropImageView cropImageView, CropImageView.CropResult cropResult) {
        setResult(cropResult.getUri(), cropResult.getError(), cropResult.getSampleSize());
    }

    /* access modifiers changed from: protected */
    public void cropImage() {
        if (this.mOptions.noOutputImage) {
            setResult((Uri) null, (Exception) null, 1);
            return;
        }
        this.mCropImageView.saveCroppedImageAsync(getOutputUri(), this.mOptions.outputCompressFormat, this.mOptions.outputCompressQuality, this.mOptions.outputRequestWidth, this.mOptions.outputRequestHeight, this.mOptions.outputRequestSizeOptions);
    }

    /* access modifiers changed from: protected */
    public void rotateImage(int i2) {
        this.mCropImageView.rotateImage(i2);
    }

    /* access modifiers changed from: protected */
    public Uri getOutputUri() {
        Uri uri = this.mOptions.outputUri;
        if (uri != null && !uri.equals(Uri.EMPTY)) {
            return uri;
        }
        try {
            return Uri.fromFile(File.createTempFile("cropped", this.mOptions.outputCompressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" : this.mOptions.outputCompressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".webp", getCacheDir()));
        } catch (IOException e2) {
            throw new RuntimeException("Failed to create temp file for output image", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void setResult(Uri uri, Exception exc, int i2) {
        setResult(exc == null ? -1 : CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, getResultIntent(uri, exc, i2));
        finish();
    }

    /* access modifiers changed from: protected */
    public void setResultCancel() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public Intent getResultIntent(Uri uri, Exception exc, int i2) {
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(this.mCropImageView.getImageUri(), uri, exc, this.mCropImageView.getCropPoints(), this.mCropImageView.getCropRect(), this.mCropImageView.getRotatedDegrees(), this.mCropImageView.getWholeImageRect(), i2);
        Intent intent = new Intent();
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_RESULT, activityResult);
        return intent;
    }

    private void updateMenuItemIconColor(Menu menu, int i2, int i3) {
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

    public void onImageCropBackClick(View view) {
        onBackPressed();
    }

    public void onSelectImageClick(View view) {
        cropImage();
    }
}
