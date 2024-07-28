package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.google.android.gms.maps.model.LatLng;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicket;
import net.one97.paytm.o2o.movies.utils.q;
import net.one97.paytm.o2o.movies.utils.v;
import net.one97.paytm.orders.datamodel.CJRQRImageModel;

public final class ai extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRBookedMovieTicket> f74341a = null;

    /* renamed from: b  reason: collision with root package name */
    a f74342b;

    /* renamed from: c  reason: collision with root package name */
    HashMap<Integer, CJRQRImageModel> f74343c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f74344d;

    public interface a {
        void a(CJRQRImageModel cJRQRImageModel);

        void b(String str);
    }

    public ai(ArrayList<CJRBookedMovieTicket> arrayList, a aVar) {
        this.f74341a = arrayList;
        this.f74342b = aVar;
        this.f74343c = new HashMap<>();
    }

    public final int getCount() {
        ArrayList<CJRBookedMovieTicket> arrayList = this.f74341a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == ((RelativeLayout) obj);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        String str;
        ViewGroup viewGroup2 = viewGroup;
        final int i3 = i2;
        this.f74344d = (LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater");
        View inflate = this.f74344d.inflate(R.layout.upcomming_booked_movie_ticket_item_row, viewGroup2, false);
        ((TextView) inflate.findViewById(R.id.tv_movie_name)).setText(this.f74341a.get(i3).getMovie());
        TextView textView = (TextView) inflate.findViewById(R.id.tv_language);
        CJRBookedMovieTicket cJRBookedMovieTicket = this.f74341a.get(i3);
        String str2 = "";
        if (!TextUtils.isEmpty(cJRBookedMovieTicket.getLanguage())) {
            str = str2 + cJRBookedMovieTicket.getLanguage();
        } else {
            str = str2;
        }
        if (!TextUtils.isEmpty(cJRBookedMovieTicket.getFormat())) {
            if (!TextUtils.isEmpty(str)) {
                str = str + " | " + cJRBookedMovieTicket.getFormat();
            } else {
                str = str + cJRBookedMovieTicket.getFormat();
            }
        }
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.tv_date_time)).setText(q.a(this.f74341a.get(i3).getShowTime(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_no_of_seat);
        CJRBookedMovieTicket cJRBookedMovieTicket2 = this.f74341a.get(i3);
        if (cJRBookedMovieTicket2 != null && !TextUtils.isEmpty(cJRBookedMovieTicket2.getAudi())) {
            str2 = "Screen: " + cJRBookedMovieTicket2.getAudi() + " & ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(cJRBookedMovieTicket2.getNoOfSeats());
        sb.append(cJRBookedMovieTicket2.getNoOfSeats() > 1 ? " Seats, " : " Seat, ");
        sb.append(cJRBookedMovieTicket2.getSeatInfo());
        textView2.setText(sb.toString());
        ((TextView) inflate.findViewById(R.id.tv_cinema)).setText(this.f74341a.get(i3).getCinema());
        ((TextView) inflate.findViewById(R.id.tv_bookingId)).setText(this.f74341a.get(i3).getBookingId());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_qr_code);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_no_qr_code);
        final RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.ll_qr_code);
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.loading_qr);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ai.this.f74342b.b(ai.this.f74341a.get(i3).getOrderId());
            }
        });
        StringBuilder sb2 = new StringBuilder();
        c.a();
        sb2.append(c.b());
        sb2.append("?ticket_key=");
        sb2.append(this.f74341a.get(i3).getTicket_key());
        sb2.append("&size=10");
        String sb3 = sb2.toString();
        if (TextUtils.isEmpty(sb3)) {
            progressBar.setVisibility(8);
            relativeLayout.setVisibility(8);
            linearLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(0);
            linearLayout.setVisibility(8);
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(linearLayout.getContext()));
            progressBar.setVisibility(0);
            AnonymousClass2 r14 = r0;
            final ImageView imageView2 = imageView;
            v vVar = v.INSTANCE;
            final int i4 = i2;
            AnonymousClass2 r0 = new ImageLoader.ImageListener() {
                public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                    Bitmap bitmap = imageContainer != null ? imageContainer.getBitmap() : null;
                    if (z && bitmap == null) {
                        return;
                    }
                    if (bitmap == null) {
                        progressBar.setVisibility(8);
                        relativeLayout.setVisibility(8);
                        linearLayout.setVisibility(0);
                        return;
                    }
                    imageView2.setImageBitmap(bitmap);
                    CJRQRImageModel.a aVar = new CJRQRImageModel.a();
                    Bitmap unused = aVar.f56864a.bitmap = bitmap;
                    View unused2 = aVar.f56864a.thumbView = imageView2;
                    ai.this.f74343c.put(Integer.valueOf(i4), aVar.f56864a);
                    progressBar.setVisibility(8);
                    relativeLayout.setVisibility(0);
                    linearLayout.setVisibility(8);
                }

                public final void onErrorResponse(VolleyError volleyError) {
                    progressBar.setVisibility(8);
                    relativeLayout.setVisibility(8);
                    linearLayout.setVisibility(0);
                }
            };
            vVar.loadImage(sb3, r14, hashMap);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (ai.this.f74343c != null && ai.this.f74342b != null && ai.this.f74343c.get(Integer.valueOf(i3)) != null) {
                    ai.this.f74342b.a(ai.this.f74343c.get(Integer.valueOf(i3)));
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_zoom_icon)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (ai.this.f74343c != null && ai.this.f74342b != null && ai.this.f74343c.get(Integer.valueOf(i3)) != null) {
                    ai.this.f74342b.a(ai.this.f74343c.get(Integer.valueOf(i3)));
                }
            }
        });
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.layout_get_direction);
        CJRBookedMovieTicket cJRBookedMovieTicket3 = this.f74341a.get(i3);
        if (cJRBookedMovieTicket3.getLatitude() == null || cJRBookedMovieTicket3.getLongitude() == null) {
            relativeLayout2.setVisibility(8);
            relativeLayout2.setOnClickListener((View.OnClickListener) null);
        } else {
            relativeLayout2.setVisibility(0);
            relativeLayout2.setOnClickListener(new View.OnClickListener(cJRBookedMovieTicket3) {
                private final /* synthetic */ CJRBookedMovieTicket f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ai.this.a(this.f$1, view);
                }
            });
        }
        viewGroup2.addView(inflate);
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRBookedMovieTicket cJRBookedMovieTicket, View view) {
        Context context = view.getContext();
        LatLng latLng = new LatLng(cJRBookedMovieTicket.getLatitude().doubleValue(), cJRBookedMovieTicket.getLongitude().doubleValue());
        String cinema = cJRBookedMovieTicket.getCinema();
        if (context != null) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?q=loc:%1s,%2s(%3s)", new Object[]{String.valueOf(latLng.f11593a), String.valueOf(latLng.f11594b), cinema}))));
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((RelativeLayout) obj);
    }
}
