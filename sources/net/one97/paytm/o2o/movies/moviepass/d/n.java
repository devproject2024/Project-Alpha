package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.d;
import com.paytm.utility.v;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.a;

public final class n extends j {

    /* renamed from: a  reason: collision with root package name */
    TextView f75559a;

    /* renamed from: b  reason: collision with root package name */
    TextView f75560b;

    /* renamed from: c  reason: collision with root package name */
    TextView f75561c;

    /* renamed from: d  reason: collision with root package name */
    TextView f75562d;

    /* renamed from: e  reason: collision with root package name */
    TextView f75563e;

    /* renamed from: f  reason: collision with root package name */
    TextView f75564f;

    /* renamed from: g  reason: collision with root package name */
    TextView f75565g;

    /* renamed from: h  reason: collision with root package name */
    TextView f75566h;

    /* renamed from: i  reason: collision with root package name */
    ImageView f75567i;

    public n(View view) {
        super(view);
        this.f75559a = (TextView) view.findViewById(R.id.mp_card_heading);
        this.f75560b = (TextView) view.findViewById(R.id.mp_card_tickets_view);
        this.f75561c = (TextView) view.findViewById(R.id.mp_card_validity_view);
        this.f75562d = (TextView) view.findViewById(R.id.mp_small_card_price_view);
        this.f75563e = (TextView) view.findViewById(R.id.mp_small_card_bottom_text);
        this.f75564f = (TextView) view.findViewById(R.id.mp_card_ticket_head);
        this.f75565g = (TextView) view.findViewById(R.id.mp_card_validity_head);
        this.f75566h = (TextView) view.findViewById(R.id.mp_card_price_view);
        this.f75567i = (ImageView) view.findViewById(R.id.activePassBg);
    }

    public final void a(a aVar, b bVar, final Context context) {
        CJRUserMoviePassModel cJRUserMoviePassModel = aVar.f75576g;
        if (cJRUserMoviePassModel != null) {
            if (!v.a(cJRUserMoviePassModel.getHeading())) {
                this.f75559a.setText(cJRUserMoviePassModel.getHeading());
            }
            if (!v.a(cJRUserMoviePassModel.getCityName())) {
                TextView textView = this.f75563e;
                textView.setText("This pass is valid in " + cJRUserMoviePassModel.getCityName() + " only");
            }
            if (cJRUserMoviePassModel.getValidity() != null) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    Date parse = simpleDateFormat.parse(cJRUserMoviePassModel.getExpirationDate());
                    Date parse2 = simpleDateFormat.parse(aVar.j);
                    this.f75565g.setText(cJRUserMoviePassModel.getValadityLabel());
                    long convert = TimeUnit.DAYS.convert(parse.getTime() - parse2.getTime(), TimeUnit.MILLISECONDS);
                    String str = convert > 1 ? " Days" : " Day";
                    TextView textView2 = this.f75561c;
                    textView2.setText(convert + str);
                } catch (Exception unused) {
                }
            }
            if (!v.a(cJRUserMoviePassModel.getQuotaLeft())) {
                this.f75564f.setText(cJRUserMoviePassModel.getQuotaLabel());
                this.f75560b.setText(cJRUserMoviePassModel.getQuotaLeft());
            }
            if (!v.a(cJRUserMoviePassModel.getMoneySaved())) {
                this.f75566h.setText(cJRUserMoviePassModel.getSavingsLabel());
                TextView textView3 = this.f75562d;
                textView3.setText(context.getResources().getString(R.string.rupee_symbol) + cJRUserMoviePassModel.getMoneySaved());
            }
            if (!v.a(cJRUserMoviePassModel.getPassImage())) {
                w.a().a(cJRUserMoviePassModel.getPassImage()).a((af) new af() {
                    public final void onBitmapFailed(Exception exc, Drawable drawable) {
                    }

                    public final void onPrepareLoad(Drawable drawable) {
                    }

                    public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                        androidx.core.graphics.drawable.b a2 = d.a(context.getResources(), bitmap);
                        a2.a((float) com.paytm.utility.b.a(12.0f, context));
                        n.this.f75567i.setImageDrawable(a2);
                    }
                });
            }
        }
    }
}
