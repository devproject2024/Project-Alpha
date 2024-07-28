package net.one97.paytm.o2o.movies.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.s;
import com.paytm.utility.v;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.u;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.z;
import net.one97.paytm.o2o.movies.utils.CJRGalleryViewPager;
import net.one97.paytm.o2o.movies.utils.w;
import net.one97.paytm.photoview.PhotoView;

public final class AJRDetailImageGalleryViewer extends AppBaseActivity implements z.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f73937a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f73938b;

    public final View b(int i2) {
        if (this.f73938b == null) {
            this.f73938b = new HashMap();
        }
        View view = (View) this.f73938b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f73938b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class e implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRDetailImageGalleryViewer f73943a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f73944b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f73945c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f73946d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f73947e;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        public e(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer, x.e eVar, int i2, int i3, ArrayList arrayList) {
            this.f73943a = aJRDetailImageGalleryViewer;
            this.f73944b = eVar;
            this.f73945c = i2;
            this.f73946d = i3;
            this.f73947e = arrayList;
        }

        public final void onPageSelected(int i2) {
            TextView textView = (TextView) this.f73943a.b(R.id.posterIndexText);
            k.a((Object) textView, "posterIndexText");
            textView.setText(this.f73943a.getString(R.string.movies_poster_text, new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(this.f73947e.size())}));
            if (((ArrayList) this.f73944b.element).get(i2) == null || !((b) ((ArrayList) this.f73944b.element).get(i2)).f74224b) {
                TextView textView2 = (TextView) this.f73943a.b(R.id.downloadPoster);
                k.a((Object) textView2, "downloadPoster");
                textView2.setVisibility(8);
                return;
            }
            TextView textView3 = (TextView) this.f73943a.b(R.id.downloadPoster);
            k.a((Object) textView3, "downloadPoster");
            textView3.setVisibility(0);
        }
    }

    static final /* synthetic */ class h extends i implements kotlin.g.a.b<Boolean, kotlin.x> {
        h(CJRGalleryViewPager cJRGalleryViewPager) {
            super(1, cJRGalleryViewPager);
        }

        public final String getName() {
            return "setPagingEnabled";
        }

        public final kotlin.k.d getOwner() {
            return y.b(CJRGalleryViewPager.class);
        }

        public final String getSignature() {
            return "setPagingEnabled(Z)V";
        }

        public final /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return kotlin.x.f47997a;
        }

        public final void invoke(boolean z) {
            ((CJRGalleryViewPager) this.receiver).setPagingEnabled(z);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(9);
        setContentView(R.layout.activity_detail_image_gallery_viewer);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("param_list_of_image");
        x.e eVar = new x.e();
        eVar.element = new ArrayList();
        int size = stringArrayListExtra.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!v.a(stringArrayListExtra.get(i2))) {
                b bVar = new b();
                bVar.f74223a = stringArrayListExtra.get(i2);
                ((ArrayList) eVar.element).add(bVar);
            }
        }
        int intExtra = getIntent().getIntExtra("param_selected_index", 0);
        int intExtra2 = getIntent().getIntExtra("layoutItemId", R.layout.movie_gallery_item_layout);
        ((ImageView) b(R.id.imgClose)).setOnClickListener(new f(this));
        TextView textView = (TextView) b(R.id.downloadPoster);
        k.a((Object) textView, "downloadPoster");
        textView.setVisibility(8);
        ((TextView) b(R.id.downloadPoster)).setOnClickListener(new g(this));
        TextView textView2 = (TextView) b(R.id.posterIndexText);
        k.a((Object) textView2, "posterIndexText");
        textView2.setText(getString(R.string.movies_poster_text, new Object[]{Integer.valueOf(intExtra + 1), Integer.valueOf(stringArrayListExtra.size())}));
        CJRGalleryViewPager cJRGalleryViewPager = (CJRGalleryViewPager) b(R.id.vpImage);
        cJRGalleryViewPager.setPageMargin(com.paytm.utility.b.c(10));
        cJRGalleryViewPager.setAdapter(new z((ArrayList) eVar.element, new h(cJRGalleryViewPager), intExtra2, com.paytm.utility.b.a((Activity) this), this));
        cJRGalleryViewPager.setCurrentItem(intExtra, true);
        cJRGalleryViewPager.addOnPageChangeListener(new e(this, eVar, intExtra2, intExtra, stringArrayListExtra));
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRDetailImageGalleryViewer f73948a;

        f(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer) {
            this.f73948a = aJRDetailImageGalleryViewer;
        }

        public final void onClick(View view) {
            this.f73948a.finish();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRDetailImageGalleryViewer f73949a;

        g(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer) {
            this.f73949a = aJRDetailImageGalleryViewer;
        }

        public final void onClick(View view) {
            AJRDetailImageGalleryViewer.a(this.f73949a);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 0) {
            return;
        }
        if (s.a(iArr)) {
            a();
            return;
        }
        Activity activity = this;
        if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", activity) != 1) {
            w.a(activity);
        }
    }

    private final void a() {
        CJRGalleryViewPager cJRGalleryViewPager = (CJRGalleryViewPager) b(R.id.vpImage);
        k.a((Object) cJRGalleryViewPager, "vpImage");
        View findViewById = ((CJRGalleryViewPager) b(R.id.vpImage)).findViewWithTag(Integer.valueOf(cJRGalleryViewPager.getCurrentItem())).findViewById(R.id.viewpager_image);
        if (findViewById != null) {
            PhotoView photoView = (PhotoView) findViewById;
            if (photoView.getScale() == 1.0f) {
                b();
                Bitmap a2 = w.a((View) photoView);
                k.a((Object) a2, "bitmap");
                a(a2);
                return;
            }
            Toast.makeText(this, R.string.zoomed_wallpaper_download_error_message, 1).show();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.photoview.PhotoView");
    }

    private final void a(Bitmap bitmap) {
        io.reactivex.rxjava3.a.y.a(new b(this, bitmap)).b(io.reactivex.rxjava3.i.a.d()).a(io.reactivex.rxjava3.android.b.a.a()).a(new c(this), (io.reactivex.rxjava3.d.g<? super Throwable>) new d(this));
    }

    private final void b() {
        ProgressBar progressBar = (ProgressBar) b(R.id.downloadPosterProgressbar);
        k.a((Object) progressBar, "downloadPosterProgressbar");
        progressBar.setVisibility(0);
    }

    public final void a(int i2) {
        CJRGalleryViewPager cJRGalleryViewPager = (CJRGalleryViewPager) b(R.id.vpImage);
        k.a((Object) cJRGalleryViewPager, "vpImage");
        if (i2 == cJRGalleryViewPager.getCurrentItem()) {
            TextView textView = (TextView) b(R.id.downloadPoster);
            k.a((Object) textView, "downloadPoster");
            textView.setVisibility(0);
        }
    }

    static final class b<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRDetailImageGalleryViewer f73939a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bitmap f73940b;

        b(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer, Bitmap bitmap) {
            this.f73939a = aJRDetailImageGalleryViewer;
            this.f73940b = bitmap;
        }

        public final /* synthetic */ Object call() {
            Context applicationContext = this.f73939a.getApplicationContext();
            Bitmap bitmap = this.f73940b;
            String str = "MovieWallpaper_" + System.currentTimeMillis();
            if (w.a()) {
                return w.a(applicationContext, bitmap, 100, Environment.DIRECTORY_PICTURES + File.separator + "Paytm" + File.separator + "Wallpapers" + File.separator, str);
            }
            return w.a(applicationContext, bitmap, Environment.getExternalStorageDirectory() + File.separator + "Paytm" + File.separator + "Wallpapers", str, 100);
        }
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<Uri> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRDetailImageGalleryViewer f73941a;

        c(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer) {
            this.f73941a = aJRDetailImageGalleryViewer;
        }

        public final /* synthetic */ void accept(Object obj) {
            AJRDetailImageGalleryViewer.b(this.f73941a);
            Toast.makeText(this.f73941a, R.string.download_wallpaper_success_message, 1).show();
        }
    }

    static final class d<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRDetailImageGalleryViewer f73942a;

        d(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer) {
            this.f73942a = aJRDetailImageGalleryViewer;
        }

        public final /* synthetic */ void accept(Object obj) {
            AJRDetailImageGalleryViewer.b(this.f73942a);
            Toast.makeText(this.f73942a, R.string.download_wallpaper_error_message, 1).show();
        }
    }

    public static final /* synthetic */ void a(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer) {
        if (androidx.core.app.a.a((Context) aJRDetailImageGalleryViewer, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.a(aJRDetailImageGalleryViewer, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        } else {
            aJRDetailImageGalleryViewer.a();
        }
    }

    public static final /* synthetic */ void b(AJRDetailImageGalleryViewer aJRDetailImageGalleryViewer) {
        ProgressBar progressBar = (ProgressBar) aJRDetailImageGalleryViewer.b(R.id.downloadPosterProgressbar);
        k.a((Object) progressBar, "downloadPosterProgressbar");
        progressBar.setVisibility(8);
    }

    public static final Intent a(Context context, ArrayList<String> arrayList, int i2) {
        k.c(context, "context");
        if (arrayList == null) {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.crashlyticsLogs("AJRDetailImageGalleryViewer intent list of urls can't be null".toString());
            return null;
        }
        List d2 = kotlin.a.k.d(arrayList);
        if (d2.isEmpty()) {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.crashlyticsLogs("AJRDetailImageGalleryViewer intent list of urls can't be empty".toString());
            return null;
        }
        Intent intent = new Intent(context, AJRDetailImageGalleryViewer.class);
        if (d2 != null) {
            intent.putStringArrayListExtra("param_list_of_image", (ArrayList) d2);
            intent.putExtra("param_selected_index", i2);
            return intent;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
    }
}
