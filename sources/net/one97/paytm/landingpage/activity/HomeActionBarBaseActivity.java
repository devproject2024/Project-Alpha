package net.one97.paytm.landingpage.activity;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.paytm.network.f;
import com.paytm.utility.b;
import com.paytm.utility.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRFlyoutCatalog;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.utils.r;

public abstract class HomeActionBarBaseActivity extends HomeBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f52700a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f52701b;

    /* renamed from: c  reason: collision with root package name */
    private final int f52702c = 45;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = getSupportActionBar();
        if (this.o != null) {
            this.o.b(true);
            this.o.c(false);
            this.o.a(true);
            a(true);
            this.o.b();
            this.o.a(R.layout.action_bar_title);
            this.o.a(2.0f);
            this.f52701b = (TextView) findViewById(R.id.text1);
            this.f52701b.setInputType(524288);
            this.f52701b.setEllipsize(TextUtils.TruncateAt.END);
            this.f52701b.setTextSize(19.0f);
            this.f52701b.setMaxLines(1);
            this.f52701b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeActionBarBaseActivity.a(HomeActionBarBaseActivity.this);
                }
            });
            b.d(this.f52701b);
            this.o.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        }
        r.a(getClass().getSimpleName(), "Activity Created");
    }

    public void onBackPressed() {
        d.a();
        if (this.f52710f != null) {
            this.f52710f.setIconified(true);
        }
        super.onBackPressed();
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f52713i = charSequence;
            String charSequence2 = charSequence.toString();
            if (charSequence2.length() > 0) {
                charSequence2 = charSequence2.substring(0, 1).toUpperCase() + charSequence2.substring(1);
            }
            if (this.f52701b != null) {
                int i2 = 45;
                if (this.j) {
                    i2 = 40;
                }
                if (this.k) {
                    i2 -= 5;
                }
                if (d.a().v(this)) {
                    this.f52701b.setTypeface(Typeface.create("sans-serif-medium", 0));
                }
                if (d.a().w(this)) {
                    this.f52701b.setTextSize(2, 17.0f);
                }
                if (d.a().x(this)) {
                    if (charSequence2.length() > 24) {
                        charSequence2 = charSequence2.substring(0, 21) + AppConstants.DOTS;
                    }
                    this.f52701b.setText(charSequence2);
                    i2 = 24;
                }
                if (d.a().y(this)) {
                    this.f52701b.setText(charSequence2);
                    this.f52701b.setTextSize(2, 17.0f);
                } else if (!d.a().z(this)) {
                    int a2 = d.a().a(i2);
                    if (charSequence2.length() > a2) {
                        charSequence2 = charSequence2.substring(0, a2 - 3);
                        if (charSequence2.trim().length() > 0) {
                            charSequence2 = charSequence2 + AppConstants.DOTS;
                        }
                    }
                    this.f52701b.setText(charSequence2);
                } else if (!TextUtils.isEmpty(charSequence2)) {
                    if (charSequence2.length() < i2) {
                        this.f52701b.setTextSize(2, 17.0f);
                    } else {
                        charSequence2 = charSequence2.substring(0, (i2 - 5) - 3);
                        if (charSequence2.trim().length() > 0) {
                            charSequence2 = charSequence2 + AppConstants.DOTS;
                        }
                    }
                    this.f52701b.setText(charSequence2);
                }
            }
        }
    }

    public class a extends AsyncTask<Void, Void, CJRCatalog> {
        private a() {
        }

        public /* synthetic */ a(HomeActionBarBaseActivity homeActionBarBaseActivity, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            HomeActionBarBaseActivity.this.isFinishing();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            CJRFlyoutCatalog cJRFlyoutCatalog = (CJRFlyoutCatalog) f.a(d.a().l() + c.a(HomeActionBarBaseActivity.this.getApplicationContext(), true), HomeActionBarBaseActivity.this.getApplicationContext(), new CJRFlyoutCatalog());
            if (!(cJRFlyoutCatalog == null || cJRFlyoutCatalog.getFlyoutCatalog() == null)) {
                HomeActionBarBaseActivity.this.f52711g = cJRFlyoutCatalog.getFlyoutCatalog();
                HomeActionBarBaseActivity.this.f52711g.setParentNameItems(new ArrayList());
                d.a().a(HomeActionBarBaseActivity.this.f52711g);
            }
            return HomeActionBarBaseActivity.this.f52711g;
        }
    }

    static /* synthetic */ void a(HomeActionBarBaseActivity homeActionBarBaseActivity) {
        if (homeActionBarBaseActivity.f52700a) {
            homeActionBarBaseActivity.onBackPressed();
        } else if (homeActionBarBaseActivity.f52708d == null || homeActionBarBaseActivity.f52708d.e(8388611)) {
            homeActionBarBaseActivity.i();
        } else {
            homeActionBarBaseActivity.f52708d.c(8388611);
        }
    }
}
