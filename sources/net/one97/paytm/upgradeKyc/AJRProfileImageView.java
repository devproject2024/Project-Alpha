package net.one97.paytm.upgradeKyc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRProfileImageView extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f65180a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f65181b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_profile_image);
        this.f65180a = (ImageView) findViewById(R.id.img_profile);
        this.f65181b = (ProgressBar) findViewById(R.id.progress_bar);
        String al = b.al(this);
        if (al != null && al.trim().length() > 0 && Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            Bitmap decodeFile = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().toString() + b.am(this) + UpiConstants.USER_PROFILE_PIC_FILENAME);
            if (!b.an(this) || decodeFile == null) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
                a2.f43753a = al;
                b.a.C0750a.a(a2, a.c.HOME.name()).a(this.f65181b).a(this.f65180a);
            } else {
                try {
                    this.f65180a.setImageBitmap(decodeFile);
                    this.f65181b.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        }
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRProfileImageView.this.finish();
            }
        });
    }
}
