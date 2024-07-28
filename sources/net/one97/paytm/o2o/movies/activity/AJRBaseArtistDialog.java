package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.paytm.utility.q;
import com.paytm.utility.t;
import net.one97.paytm.common.entity.events.CJREventTabDetailModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRBaseArtistDialog extends AppBaseActivity implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private static final String f73891d = AJRBaseArtistDialog.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected String f73892a;

    /* renamed from: b  reason: collision with root package name */
    protected String f73893b;

    /* renamed from: c  reason: collision with root package name */
    protected String f73894c;

    /* renamed from: e  reason: collision with root package name */
    private Context f73895e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f73896f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f73897g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f73898h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f73899i;
    private b j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        supportRequestWindowFeature(1);
        setContentView(R.layout.movies_artist_dialog_activity);
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
        this.f73895e = this;
        this.f73896f = (ImageView) findViewById(R.id.id_artist_dialog_close);
        this.f73897g = (ImageView) findViewById(R.id.artistImage);
        this.f73898h = (TextView) findViewById(R.id.artistTitle);
        this.f73899i = (TextView) findViewById(R.id.artistdesc);
        this.f73896f.setOnClickListener(this);
        a();
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.f73895e.getResources(), net.one97.paytm.common.assets.R.drawable.img_movie_placeholder_163_x_190_dp);
            this.j = d.a(this.f73895e.getResources(), decodeResource);
            this.j.b();
            this.j.a(((float) Math.max(decodeResource.getWidth(), decodeResource.getHeight())) / 2.0f);
            if (!TextUtils.isEmpty(this.f73894c)) {
                this.f73894c = this.f73894c.replace(" ", "%20");
                this.f73894c = this.f73894c.trim();
                t.a(net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPicassoIsInMemory()).a(this.f73894c, this.f73897g, this.j);
            }
            if (!TextUtils.isEmpty(this.f73893b)) {
                this.f73899i.setMovementMethod(new ScrollingMovementMethod());
                this.f73899i.setText(this.f73893b);
            }
            if (!TextUtils.isEmpty(this.f73892a)) {
                this.f73898h.setText(this.f73892a);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        CJREventTabDetailModel cJREventTabDetailModel = (CJREventTabDetailModel) getIntent().getExtras().getSerializable("value");
        if (cJREventTabDetailModel != null) {
            this.f73892a = cJREventTabDetailModel.getName();
            this.f73893b = cJREventTabDetailModel.getDiscription();
            this.f73893b = n.a(this.f73893b);
            this.f73894c = cJREventTabDetailModel.getImageUrl();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.id_artist_dialog_close) {
            finish();
        }
    }

    public void onBackPressed() {
        finish();
    }
}
