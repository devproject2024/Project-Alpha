package net.one97.paytm.fastag.widget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.paytm.utility.s;
import java.io.File;
import net.one97.paytm.fastag.R;

public class ImageUploader extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f13953b = Uri.parse("content://com.albinmathew.samples.photocrop/");

    /* renamed from: a  reason: collision with root package name */
    public b f13954a;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f13955c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f13956d;

    /* renamed from: e  reason: collision with root package name */
    private Uri f13957e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f13958f;

    /* renamed from: g  reason: collision with root package name */
    private String f13959g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f13960h;

    /* renamed from: i  reason: collision with root package name */
    private View f13961i;
    private a j;

    public interface a {
        void a(Uri uri);

        void a(ImageUploader imageUploader);

        void b(ImageUploader imageUploader);
    }

    public enum b {
        INITIAL,
        IMAGE_SELECTED,
        IMAGE_SELECTED_AND_UPLOADING,
        IMAGE_SELECTED_AND_UPLOADING_FAILED,
        IMAGE_UPLOADED
    }

    public ImageUploader(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageUploader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ImageUploader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13954a = b.INITIAL;
        this.f13961i = LayoutInflater.from(getContext()).inflate(R.layout.image_upload_layout_ft, (ViewGroup) null);
        addView(this.f13961i);
        this.f13961i.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f13955c = (LinearLayout) this.f13961i.findViewById(R.id.initial_layout);
        this.f13956d = (RelativeLayout) this.f13961i.findViewById(R.id.image_layout);
        this.f13958f = (RelativeLayout) this.f13961i.findViewById(R.id.progress_bar_layout);
        this.f13960h = (RelativeLayout) this.f13961i.findViewById(R.id.error_layout);
        this.f13955c.setOnClickListener(this);
        this.f13960h.setOnClickListener(this);
    }

    public void setListener(a aVar) {
        this.j = aVar;
    }

    public void setText(int i2, int i3) {
        View view = this.f13961i;
        if (view != null) {
            ((TextView) view.findViewById(R.id.title1)).setText(i2);
            ((TextView) this.f13961i.findViewById(R.id.title2)).setText(i3);
        }
    }

    /* renamed from: net.one97.paytm.fastag.widget.ImageUploader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13962a = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                net.one97.paytm.fastag.widget.ImageUploader$b[] r0 = net.one97.paytm.fastag.widget.ImageUploader.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13962a = r0
                int[] r0 = f13962a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.fastag.widget.ImageUploader$b r1 = net.one97.paytm.fastag.widget.ImageUploader.b.INITIAL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f13962a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.fastag.widget.ImageUploader$b r1 = net.one97.paytm.fastag.widget.ImageUploader.b.IMAGE_SELECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f13962a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.fastag.widget.ImageUploader$b r1 = net.one97.paytm.fastag.widget.ImageUploader.b.IMAGE_SELECTED_AND_UPLOADING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f13962a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.fastag.widget.ImageUploader$b r1 = net.one97.paytm.fastag.widget.ImageUploader.b.IMAGE_SELECTED_AND_UPLOADING_FAILED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f13962a     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.fastag.widget.ImageUploader$b r1 = net.one97.paytm.fastag.widget.ImageUploader.b.IMAGE_UPLOADED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.widget.ImageUploader.AnonymousClass1.<clinit>():void");
        }
    }

    public void setState(b bVar) {
        this.f13954a = bVar;
        int i2 = AnonymousClass1.f13962a[this.f13954a.ordinal()];
        if (i2 == 1) {
            this.f13955c.setVisibility(0);
            this.f13956d.setVisibility(8);
            this.f13958f.setVisibility(8);
            this.f13960h.setVisibility(8);
        } else if (i2 == 2) {
            this.f13955c.setVisibility(8);
            this.f13956d.setVisibility(0);
            this.f13958f.setVisibility(8);
            this.f13960h.setVisibility(8);
        } else if (i2 == 3) {
            this.f13955c.setVisibility(8);
            this.f13956d.setVisibility(0);
            this.f13958f.setVisibility(0);
            this.f13960h.setVisibility(8);
        } else if (i2 == 4) {
            this.f13955c.setVisibility(8);
            this.f13956d.setVisibility(0);
            this.f13958f.setVisibility(8);
            this.f13960h.setVisibility(0);
        } else if (i2 == 5) {
            this.f13955c.setVisibility(8);
            this.f13956d.setVisibility(0);
            this.f13958f.setVisibility(8);
            this.f13960h.setVisibility(8);
        }
    }

    public void onClick(View view) {
        a aVar;
        a aVar2;
        if (view.getId() == R.id.initial_layout && (aVar2 = this.j) != null) {
            aVar2.a(this);
        } else if (view == this.f13960h && (aVar = this.j) != null) {
            aVar.b(this);
        }
    }

    public static void a(Activity activity, int i2) {
        if (activity != null && !activity.isFinishing()) {
            try {
                activity.startActivityForResult(new Intent("android.intent.action.GET_CONTENT").setType("image/*"), i2);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(activity, "No image source available", 0).show();
            }
        }
    }

    public static String a(Activity activity, int i2, String str) {
        if (activity == null || activity.isFinishing()) {
            return str;
        }
        String str2 = Environment.getExternalStorageDirectory().toString() + "/Android/data/" + activity.getPackageName() + "/" + str;
        File file = new File(str2);
        file.deleteOnExit();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                intent.putExtra("output", f13953b);
            } else if (s.b()) {
                Uri uriForFile = FileProvider.getUriForFile(activity.getApplicationContext(), "net.one97.paytm.provider", file);
                intent.setFlags(1);
                intent.putExtra("output", uriForFile);
            } else {
                intent.putExtra("output", Uri.fromFile(file));
            }
            intent.putExtra("return-data", true);
            activity.startActivityForResult(intent, i2);
            return str2;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(activity, "Can't take picture", 1).show();
            return null;
        }
    }

    public final void a(Uri uri) {
        setState(b.IMAGE_SELECTED);
        ((ImageView) this.f13961i.findViewById(R.id.sent_to_pic_imv)).setImageDrawable((Drawable) null);
        ((ImageView) this.f13961i.findViewById(R.id.sent_to_pic_imv)).setImageURI(uri);
        this.f13957e = uri;
        this.f13961i.findViewById(R.id.cross_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ImageUploader.this.b(view);
            }
        });
        this.f13961i.findViewById(R.id.sent_to_pic_imv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ImageUploader.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        setState(b.INITIAL);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.f13957e);
        }
    }

    public void setUploadedKey(String str) {
        this.f13959g = str;
    }

    public String getImageUploadedKey() {
        return this.f13959g;
    }

    public Uri getImageURI() {
        return this.f13957e;
    }
}
