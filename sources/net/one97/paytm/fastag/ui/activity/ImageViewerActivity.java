package net.one97.paytm.fastag.ui.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.v;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.widget.imageZoomWidget.ZoomageView;

public class ImageViewerActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f13830a;

    /* renamed from: b  reason: collision with root package name */
    private ZoomageView f13831b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f13832c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_imave_viewer_ft);
        this.f13830a = (ImageView) findViewById(R.id.close_imv);
        this.f13830a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ImageViewerActivity.this.a(view);
            }
        });
        this.f13831b = (ZoomageView) findViewById(R.id.zoomable_imv);
        String stringExtra = getIntent().getStringExtra("pic_uri_path");
        if (v.a(stringExtra)) {
            finish();
        }
        this.f13832c = Uri.parse(stringExtra);
        this.f13831b.setImageURI(this.f13832c);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
