package com.zhihu.matisse.internal.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.activity.ChatImageCropActivity;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.utility.q;
import com.zhihu.matisse.d.b;
import com.zhihu.matisse.internal.b.c;
import com.zhihu.matisse.internal.c.e;
import com.zhihu.matisse.internal.c.f;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.c;
import com.zhihu.matisse.internal.ui.widget.CheckRadioView;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;

public abstract class BasePreviewActivity extends PaytmActivity implements View.OnClickListener, ViewPager.e, b {

    /* renamed from: a  reason: collision with root package name */
    protected final c f45788a = new c(this);

    /* renamed from: b  reason: collision with root package name */
    protected com.zhihu.matisse.internal.entity.c f45789b;

    /* renamed from: c  reason: collision with root package name */
    protected ViewPager f45790c;

    /* renamed from: d  reason: collision with root package name */
    protected com.zhihu.matisse.internal.ui.a.c f45791d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f45792e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f45793f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f45794g;

    /* renamed from: h  reason: collision with root package name */
    protected int f45795h = -1;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f45796i;
    private LinearLayout j;
    /* access modifiers changed from: private */
    public CheckRadioView k;
    private FrameLayout l;
    private FrameLayout m;
    private FrameLayout n;
    private boolean o = false;

    public void b() {
    }

    public void onPageScrollStateChanged(int i2) {
    }

    public void onPageScrolled(int i2, float f2, int i3) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (FastClickUtil.isFastClick()) {
            Item a2 = this.f45791d.a(this.f45790c.getCurrentItem());
            Intent intent = new Intent(this, ChatImageCropActivity.class);
            intent.putExtra("item", a2);
            startActivityForResult(intent, 22);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f45788a.b(bundle);
        bundle.putBoolean("checkState", this.f45796i);
        super.onSaveInstanceState(bundle);
    }

    public void onBackPressed() {
        a(false);
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button_back || view.getId() == R.id.button_add_more || view.getId() == R.id.top_toolbar_left) {
            onBackPressed();
        } else if (view.getId() == R.id.button_apply || view.getId() == R.id.button_msg_send) {
            a(true);
            finish();
        }
    }

    public final void a() {
        if (this.f45789b.t) {
            if (this.o) {
                if (Build.VERSION.SDK_INT >= 14) {
                    this.m.animate().setInterpolator(new androidx.interpolator.a.a.b()).translationYBy((float) this.m.getMeasuredHeight()).start();
                    this.l.animate().translationYBy((float) (-this.l.getMeasuredHeight())).setInterpolator(new androidx.interpolator.a.a.b()).start();
                }
            } else if (Build.VERSION.SDK_INT >= 14) {
                this.m.animate().setInterpolator(new androidx.interpolator.a.a.b()).translationYBy((float) (-this.m.getMeasuredHeight())).start();
                this.l.animate().setInterpolator(new androidx.interpolator.a.a.b()).translationYBy((float) this.l.getMeasuredHeight()).start();
            }
            this.o = !this.o;
        }
    }

    public void onPageSelected(int i2) {
        com.zhihu.matisse.internal.ui.a.c cVar = (com.zhihu.matisse.internal.ui.a.c) this.f45790c.getAdapter();
        int i3 = this.f45795h;
        if (!(i3 == -1 || i3 == i2)) {
            b bVar = (b) cVar.instantiateItem(this.f45790c, i3);
            if (bVar.getView() != null) {
                ((ImageViewTouch) bVar.getView().findViewById(R.id.image_view)).a();
            }
            a(cVar.a(i2));
        }
        this.f45795h = i2;
    }

    /* access modifiers changed from: private */
    public int d() {
        int f2 = this.f45788a.f();
        int i2 = 0;
        for (int i3 = 0; i3 < f2; i3++) {
            Item item = this.f45788a.b().get(i3);
            if (com.zhihu.matisse.b.isImage(item.f45764b) && e.a(item.f45766d) > ((float) this.f45789b.u)) {
                i2++;
            }
        }
        return i2;
    }

    private void a(boolean z) {
        ArrayList arrayList = new ArrayList();
        com.zhihu.matisse.internal.ui.a.c cVar = this.f45791d;
        if (!(cVar == null || cVar.f45825a == null)) {
            for (Item item : this.f45791d.f45825a) {
                arrayList.add(item.j);
            }
        }
        Intent intent = new Intent();
        intent.putExtra("extra_result_bundle", this.f45788a.a());
        intent.putStringArrayListExtra("extra_result_bundle_caption", arrayList);
        intent.putExtra("extra_result_apply", z);
        intent.putExtra("extra_result_original_enable", this.f45796i);
        Bundle bundleExtra = getIntent().getBundleExtra("extra_default_bundle");
        if (bundleExtra != null) {
            intent.putExtra("extra_is_from_camera", bundleExtra.getBoolean("extra_is_from_camera", false));
        }
        setResult(-1, intent);
    }

    public void onResume() {
        super.onResume();
        com.paytm.android.chat.c.a(this);
    }

    public void onPause() {
        com.paytm.android.chat.c.e();
        super.onPause();
    }

    public void onDestroy() {
        com.paytm.android.chat.c.e();
        super.onDestroy();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        com.zhihu.matisse.internal.ui.a.c cVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 22 && intent != null && intent.getExtras() != null && intent.getExtras().get("cropped_image") != null && (cVar = this.f45791d) != null && cVar.f45825a != null) {
            for (Item next : this.f45791d.f45825a) {
                if (((Item) intent.getExtras().get("cropped_image")).f45763a == next.f45763a) {
                    Item item = (Item) intent.getExtras().get("cropped_image");
                    next.f45771i = item.f45771i;
                    next.f45765c = item.f45765c;
                    next.f45763a = Long.parseLong(item.k);
                    next.k = item.k;
                    this.f45791d.notifyDataSetChanged();
                    b();
                }
            }
        }
    }

    public void c() {
        this.n.setVisibility(0);
    }

    public void onCreate(Bundle bundle) {
        setTheme(c.a.f45787a.f45781d);
        super.onCreate(bundle);
        if (!c.a.f45787a.q) {
            BasePreviewActivity.class.getSimpleName();
            q.b("!!!SelectionSpec uninitialized");
            setResult(0);
            finish();
            return;
        }
        setContentView(R.layout.chat_activity_media_preview);
        if (f.a()) {
            getWindow().addFlags(67108864);
        }
        this.f45789b = c.a.f45787a;
        if (this.f45789b.c()) {
            setRequestedOrientation(this.f45789b.f45782e);
        }
        if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra("extra_default_bundle");
            this.f45788a.a(getIntent().getBundleExtra("extra_default_bundle"));
            if (bundleExtra != null) {
                this.f45796i = bundleExtra.getBoolean("extra_result_original_enable", false);
            }
        } else {
            this.f45788a.a(bundle);
            this.f45796i = bundle.getBoolean("checkState");
        }
        this.f45792e = (TextView) findViewById(R.id.button_back);
        this.f45793f = (TextView) findViewById(R.id.button_apply);
        this.n = (FrameLayout) findViewById(R.id.crop_image_btn_flt);
        this.f45794g = (TextView) findViewById(R.id.size);
        this.f45792e.setOnClickListener(this);
        this.f45793f.setOnClickListener(this);
        findViewById(R.id.button_msg_send).setOnClickListener(this);
        findViewById(R.id.button_add_more).setOnClickListener(this);
        findViewById(R.id.top_toolbar_left).setOnClickListener(this);
        this.f45790c = (ViewPager) findViewById(R.id.pager);
        this.f45790c.addOnPageChangeListener(this);
        this.f45791d = new com.zhihu.matisse.internal.ui.a.c(getSupportFragmentManager());
        this.f45790c.setAdapter(this.f45791d);
        this.l = (FrameLayout) findViewById(R.id.bottom_toolbar);
        this.m = (FrameLayout) findViewById(R.id.top_toolbar);
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BasePreviewActivity.this.a(view);
            }
        });
        this.j = (LinearLayout) findViewById(R.id.originalLayout);
        this.k = (CheckRadioView) findViewById(R.id.original);
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    int a2 = BasePreviewActivity.this.d();
                    if (a2 > 0) {
                        com.zhihu.matisse.internal.ui.widget.c.a("", BasePreviewActivity.this.getString(R.string.chat_module_error_over_original_count, new Object[]{Integer.valueOf(a2), Integer.valueOf(BasePreviewActivity.this.f45789b.u)})).show(BasePreviewActivity.this.getSupportFragmentManager(), com.zhihu.matisse.internal.ui.widget.c.class.getName());
                        return;
                    }
                    BasePreviewActivity basePreviewActivity = BasePreviewActivity.this;
                    basePreviewActivity.f45796i = true ^ basePreviewActivity.f45796i;
                    BasePreviewActivity.this.k.setChecked(BasePreviewActivity.this.f45796i);
                    if (!BasePreviewActivity.this.f45796i) {
                        BasePreviewActivity.this.k.setColor(-1);
                    }
                }
            }
        });
        int f2 = this.f45788a.f();
        if (f2 == 0) {
            this.f45793f.setText(R.string.chat_module_button_apply_default);
            this.f45793f.setEnabled(false);
        } else if (f2 != 1 || !this.f45789b.b()) {
            this.f45793f.setEnabled(true);
            this.f45793f.setText(getString(R.string.chat_module_button_apply, new Object[]{Integer.valueOf(f2)}));
        } else {
            this.f45793f.setText(R.string.chat_module_button_apply_default);
            this.f45793f.setEnabled(true);
        }
        if (this.f45789b.s) {
            this.j.setVisibility(0);
            this.k.setChecked(this.f45796i);
            if (!this.f45796i) {
                this.k.setColor(-1);
            }
            if (d() > 0 && this.f45796i) {
                com.zhihu.matisse.internal.ui.widget.c.a("", getString(R.string.chat_module_error_over_original_size, new Object[]{Integer.valueOf(this.f45789b.u)})).show(getSupportFragmentManager(), com.zhihu.matisse.internal.ui.widget.c.class.getName());
                this.k.setChecked(false);
                this.k.setColor(-1);
                this.f45796i = false;
                return;
            }
            return;
        }
        this.j.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(Item item) {
        if (com.zhihu.matisse.b.isGif(item.f45764b)) {
            this.f45794g.setVisibility(0);
            TextView textView = this.f45794g;
            textView.setText(e.a(item.f45766d) + "M");
        } else {
            this.f45794g.setVisibility(8);
        }
        if (com.zhihu.matisse.b.isVideo(item.f45764b)) {
            this.j.setVisibility(8);
        } else if (this.f45789b.s) {
            this.j.setVisibility(0);
        }
    }
}
