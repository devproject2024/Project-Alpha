package net.one97.paytm.o2o.movies.moviepass.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.paytm.utility.v;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCardWidgetModel;
import net.one97.paytm.o2o.movies.utils.n;

public class CJRMoviePassCardView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f75609a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f75610b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f75611c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f75612d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f75613e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f75614f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Context f75615g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f75616h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f75617i;
    private TextView j;
    private TextView k;
    private TextView l;
    private View m;
    private View n;
    private af o = new af() {
        public final void onBitmapFailed(Exception exc, Drawable drawable) {
        }

        public final void onPrepareLoad(Drawable drawable) {
        }

        public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
            b a2 = d.a(CJRMoviePassCardView.this.f75615g.getResources(), bitmap);
            a2.a((float) com.paytm.utility.b.a(12.0f, CJRMoviePassCardView.this.f75615g));
            CJRMoviePassCardView.this.f75613e.setImageDrawable(a2);
            CJRMoviePassCardView.this.f75614f.setBackground((Drawable) null);
        }
    };

    public CJRMoviePassCardView(Context context) {
        super(context);
        a(context);
    }

    public CJRMoviePassCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CJRMoviePassCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public CJRMoviePassCardView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.movie_pass_card_view, this);
        this.f75615g = context;
        a();
    }

    private void a() {
        this.f75609a = (TextView) findViewById(R.id.mp_card_heading);
        this.f75610b = (TextView) findViewById(R.id.mp_card_description);
        this.f75612d = (TextView) findViewById(R.id.mp_market_price);
        this.f75611c = (TextView) findViewById(R.id.mp_card_price_view);
        this.f75613e = (ImageView) findViewById(R.id.passBg);
        this.f75614f = (LinearLayout) findViewById(R.id.mp_card_view);
        this.f75616h = (TextView) findViewById(R.id.mp_buy_now_btn);
        this.f75617i = (ImageView) findViewById(R.id.ivMoviepassIcon);
        this.j = (TextView) findViewById(R.id.tvMovieCount);
        this.k = (TextView) findViewById(R.id.tvPassValidity);
        this.l = (TextView) findViewById(R.id.tvLocationValidity);
        this.m = findViewById(R.id.statsSeparator1);
        this.n = findViewById(R.id.statsSeparator2);
    }

    public void setData(CJRMoviePassCardWidgetModel cJRMoviePassCardWidgetModel) {
        if (cJRMoviePassCardWidgetModel != null) {
            float f2 = 1.0f;
            if (cJRMoviePassCardWidgetModel.isDisabled()) {
                f2 = 0.3f;
            }
            this.m.setEnabled(!cJRMoviePassCardWidgetModel.isDisabled());
            this.n.setEnabled(!cJRMoviePassCardWidgetModel.isDisabled());
            if (!v.a(cJRMoviePassCardWidgetModel.getHeading())) {
                this.f75609a.setVisibility(0);
                int indexOf = cJRMoviePassCardWidgetModel.getHeading().indexOf("-");
                String heading = cJRMoviePassCardWidgetModel.getHeading();
                if (indexOf >= 0) {
                    SpannableString spannableString = new SpannableString(heading);
                    spannableString.setSpan(new StyleSpan(1), indexOf + 1, heading.length(), 18);
                    this.f75609a.setText(spannableString);
                } else {
                    this.f75609a.setText(cJRMoviePassCardWidgetModel.getHeading());
                }
                this.f75609a.setAlpha(f2);
            } else {
                this.f75609a.setVisibility(8);
            }
            a(f2, this.f75610b, cJRMoviePassCardWidgetModel.getDescription());
            a(f2, this.f75611c, cJRMoviePassCardWidgetModel.getPriceText());
            a(f2, this.f75612d, cJRMoviePassCardWidgetModel.getPassMrpText());
            a(f2, this.j, cJRMoviePassCardWidgetModel.getMovieCountText());
            a(f2, this.k, cJRMoviePassCardWidgetModel.getPassValidityText());
            a(f2, this.l, cJRMoviePassCardWidgetModel.getCinemaLocationValidityText());
            TextView textView = this.f75612d;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            setIconOrBuyNowButton(cJRMoviePassCardWidgetModel);
            if (!v.a(cJRMoviePassCardWidgetModel.getBgImage()) && this.f75615g != null) {
                w.a().a(cJRMoviePassCardWidgetModel.getBgImage()).a(this.o);
            }
        }
    }

    private void setIconOrBuyNowButton(CJRMoviePassCardWidgetModel cJRMoviePassCardWidgetModel) {
        if (cJRMoviePassCardWidgetModel.isMoviePassIconVisible()) {
            this.f75617i.setVisibility(0);
            this.f75616h.setVisibility(8);
            return;
        }
        this.f75617i.setVisibility(8);
        setBuyNowButton(cJRMoviePassCardWidgetModel);
    }

    private void setBuyNowButton(CJRMoviePassCardWidgetModel cJRMoviePassCardWidgetModel) {
        this.f75616h.setVisibility(0);
        if (cJRMoviePassCardWidgetModel.isDisabled()) {
            this.f75616h.setText("OUT OF STOCK");
            this.f75616h.setTextColor(this.f75615g.getResources().getColor(R.color.white));
        } else {
            this.f75616h.setText("BUY NOW");
            this.f75616h.setTextColor(this.f75615g.getResources().getColor(R.color.excl_color_00b9f5));
        }
        this.f75616h.setEnabled(!cJRMoviePassCardWidgetModel.isDisabled());
    }

    private static void a(float f2, TextView textView, String str) {
        n.a(textView, str);
        textView.setAlpha(f2);
    }
}
