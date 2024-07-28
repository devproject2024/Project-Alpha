package net.one97.paytm.o2o.amusementpark.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.paytm.utility.b;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.amPark.CJRResourceDetailModel;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.a.g;
import net.one97.paytm.o2o.amusementpark.d.e;
import net.one97.paytm.o2o.amusementpark.utils.m;

public class AJRAmParkDetailImageGalleryViewer extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    e f73304a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager f73305b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f73306c;

    /* renamed from: d  reason: collision with root package name */
    private CirclePageIndicator f73307d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f73308e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<CJRResourceDetailModel> f73309f;

    /* renamed from: g  reason: collision with root package name */
    private int f73310g;

    public void attachBaseContext(Context context) {
        if (a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(9);
        setContentView(R.layout.activity_ampark_detail_image_gallery_viewer);
        Intent intent = getIntent();
        if (!(intent == null || intent.getExtras() == null)) {
            this.f73308e = intent.getExtras().getStringArrayList("imageurls");
            this.f73310g = intent.getExtras().getInt(H5StartParamManager.index, 0);
            this.f73309f = (ArrayList) intent.getExtras().getSerializable("resource_list");
        }
        this.f73304a = new e() {
            public final void a(CJRResourceDetailModel cJRResourceDetailModel, int i2) {
                if (cJRResourceDetailModel != null) {
                    AJRAmParkDetailImageGalleryViewer aJRAmParkDetailImageGalleryViewer = AJRAmParkDetailImageGalleryViewer.this;
                    String value1 = cJRResourceDetailModel.getValue1();
                    String str = null;
                    try {
                        Intent intent = new Intent(aJRAmParkDetailImageGalleryViewer, a.a().getYoutubeActivityClass());
                        if (value1 != null && !TextUtils.isEmpty(value1)) {
                            "URL ------".concat(String.valueOf(value1));
                            b.j();
                            str = b.e(value1);
                            if (str == null) {
                                str = b.f(value1);
                            }
                            "VIDEO ID ------".concat(String.valueOf(str));
                            b.j();
                        }
                        if (str != null && !TextUtils.isEmpty(str)) {
                            intent.putExtra(com.paytm.utility.e.aA, str);
                            aJRAmParkDetailImageGalleryViewer.startActivity(intent);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        };
        this.f73305b = (ViewPager) findViewById(R.id.view_pager_event_image);
        ViewGroup.LayoutParams layoutParams = this.f73305b.getLayoutParams();
        int a2 = b.a((Activity) this);
        layoutParams.height = (int) (((double) a2) * 0.5360000133514404d);
        layoutParams.width = a2;
        this.f73306c = (ImageView) findViewById(R.id.img_view_gallery_close);
        this.f73306c.setOnClickListener(this);
        this.f73307d = (CirclePageIndicator) findViewById(R.id.page_indicator);
        this.f73305b.setAdapter(new g(this, this.f73308e, this.f73309f, this.f73304a));
        this.f73307d.setViewPager(this.f73305b);
        ArrayList<String> arrayList = this.f73308e;
        if (arrayList != null && arrayList.size() > 0) {
            this.f73305b.setCurrentItem(this.f73310g);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.img_view_gallery_close) {
            finish();
        }
    }
}
