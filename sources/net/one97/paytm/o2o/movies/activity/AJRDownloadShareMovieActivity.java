package net.one97.paytm.o2o.movies.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.s;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem;
import net.one97.paytm.o2o.movies.utils.CJRTicketView;
import net.one97.paytm.o2o.movies.utils.m;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.utils.v;
import net.one97.paytm.o2o.movies.utils.w;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class AJRDownloadShareMovieActivity extends AppBaseActivity implements View.OnClickListener {
    private LinearLayout A;
    private TextView B;
    private TextView C;
    private CJRSummaryMoviePaymentItem D;
    private TextView E;
    private ImageView F;
    private TextView G;
    private String H;
    private ProgressBar I;
    private ScrollView J;
    /* access modifiers changed from: private */
    public CJRTicketView K;
    /* access modifiers changed from: private */
    public ProgressBar L;
    /* access modifiers changed from: private */
    public ProgressBar M;
    /* access modifiers changed from: private */
    public ImageView N;
    /* access modifiers changed from: private */
    public ImageView O;
    /* access modifiers changed from: private */
    public RelativeLayout P;

    /* renamed from: a  reason: collision with root package name */
    private CJRSummaryMovieDescItemV2 f73950a;

    /* renamed from: b  reason: collision with root package name */
    private CJROrderSummaryMetadataResponseV2 f73951b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f73952c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f73953d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f73954e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f73955f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f73956g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f73957h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f73958i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private LinearLayout t;
    /* access modifiers changed from: private */
    public LinearLayout u;
    private TextView v;
    private TextView w;
    private LinearLayout x;
    private TextView y;
    private TextView z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_download_share_movie);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.parseColor("#f3f7f8"));
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
        Intent intent = getIntent();
        if (intent.hasExtra("movie_description")) {
            this.f73950a = (CJRSummaryMovieDescItemV2) intent.getSerializableExtra("movie_description");
        }
        if (intent.hasExtra("payment_info")) {
            this.D = (CJRSummaryMoviePaymentItem) intent.getSerializableExtra("payment_info");
            this.f73951b = this.D.getMetaDataResponse();
        }
        this.H = intent.getStringExtra("order_id");
        if (this.f73950a == null || this.f73951b == null) {
            Toast.makeText(this, "Something went wrong", 0).show();
        }
        this.f73952c = (TextView) findViewById(R.id.movie_name);
        this.f73953d = (TextView) findViewById(R.id.movie_language_time);
        this.f73954e = (TextView) findViewById(R.id.cinema_location);
        this.f73955f = (TextView) findViewById(R.id.cinema_name);
        this.f73956g = (TextView) findViewById(R.id.booking_id);
        this.f73957h = (TextView) findViewById(R.id.movie_audi);
        this.f73958i = (TextView) findViewById(R.id.movie_booking_date);
        this.j = (TextView) findViewById(R.id.movie_booking_time);
        this.k = (TextView) findViewById(R.id.movie_booking_date_time_separator);
        this.l = (TextView) findViewById(R.id.movie_ticket_count);
        this.m = (TextView) findViewById(R.id.movie_seats_no);
        this.J = (ScrollView) findViewById(R.id.scrollView);
        this.K = (CJRTicketView) findViewById(R.id.ticketView);
        this.O = (ImageView) findViewById(R.id.content_thumbnail_qr);
        this.N = (ImageView) findViewById(R.id.content_thumbnail_movie);
        this.M = (ProgressBar) findViewById(R.id.loading_qr);
        this.L = (ProgressBar) findViewById(R.id.loading_movie);
        this.u = (LinearLayout) findViewById(R.id.mainCardView);
        this.P = (RelativeLayout) findViewById(R.id.content_thumbnail_layout_qr);
        this.n = (LinearLayout) findViewById(R.id.ticketCountLL);
        this.o = (TextView) findViewById(R.id.ticketPriceDesc);
        this.p = (TextView) findViewById(R.id.ticketPrice);
        this.q = (LinearLayout) findViewById(R.id.foodItemPaymentLL);
        this.r = (TextView) findViewById(R.id.foodItemDesc);
        this.s = (TextView) findViewById(R.id.foodItemPrice);
        this.t = (LinearLayout) findViewById(R.id.taxesLL);
        this.v = (TextView) findViewById(R.id.taxesDesc);
        this.w = (TextView) findViewById(R.id.taxesPrice);
        this.x = (LinearLayout) findViewById(R.id.cancellationProtectLL);
        this.y = (TextView) findViewById(R.id.cancellationProtectDesc);
        this.z = (TextView) findViewById(R.id.cancellationProtectPrice);
        this.A = (LinearLayout) findViewById(R.id.totalAmountLL);
        this.B = (TextView) findViewById(R.id.totalAmountDesc);
        this.C = (TextView) findViewById(R.id.totalAmountPrice);
        this.E = (TextView) findViewById(R.id.tvShare);
        this.F = (ImageView) findViewById(R.id.ivBackButton);
        this.G = (TextView) findViewById(R.id.tvDownlaod);
        this.I = (ProgressBar) findViewById(R.id.id_movie_ticket_progress_bar);
        this.G.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2 = this.f73951b;
        if (cJROrderSummaryMetadataResponseV2 != null) {
            n.a(this.f73952c, cJROrderSummaryMetadataResponseV2.getMovie());
            TextView textView = this.f73953d;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f73951b.getCensor())) {
                sb.append(this.f73951b.getCensor());
            }
            if (!TextUtils.isEmpty(this.f73951b.getLanguage())) {
                a(sb);
                sb.append(this.f73951b.getLanguage());
            }
            if (!TextUtils.isEmpty(this.f73951b.getScreenFormat())) {
                sb.append(" " + this.f73951b.getScreenFormat());
            }
            if (this.f73951b.getDuration() > 0) {
                int duration = this.f73951b.getDuration() / 60;
                int duration2 = this.f73951b.getDuration() % 60;
                String str = "";
                if (duration > 0) {
                    str = str + duration + " hrs";
                }
                if (duration2 > 0) {
                    if (str.length() > 0) {
                        str = str + " ";
                    }
                    str = str + duration2 + " mins";
                }
                a(sb);
                sb.append(str);
            }
            n.a(textView, sb.toString());
            n.a(this.f73955f, this.f73951b.getCinema());
            n.a(this.f73954e, this.f73951b.getStringAddress());
            n.a(this.f73956g, this.f73950a.getUniqueBookingId());
            n.a(this.f73957h, this.f73951b.getAudi());
            n.a(this.m, this.f73951b.getSeatIdsReturned());
            CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV22 = this.f73951b;
            if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV22.getShowTime())) {
                String b2 = n.b(cJROrderSummaryMetadataResponseV22.getShowTime(), "yyyy-MM-dd'T'HH:mm:ss");
                if (!TextUtils.isEmpty(b2)) {
                    String d2 = b.d(b2, "yyyy-MM-dd", "EEE, d MMM  yy");
                    n.a(this.f73958i, d2);
                    String d3 = b.d(b2, "yyyy-MM-dd'T'HH:mm:ss", "h:mm a");
                    n.a(this.j, d3);
                    if (TextUtils.isEmpty(d2) || TextUtils.isEmpty(d3)) {
                        this.k.setVisibility(8);
                    } else {
                        this.k.setVisibility(0);
                        this.k.setText("|");
                    }
                }
            }
            int ticketCount = this.f73951b.getTicketCount();
            if (ticketCount > 0) {
                this.l.setVisibility(0);
                String str2 = ticketCount == 1 ? " Ticket" : " Tickets";
                this.l.setText(ticketCount + str2);
            } else {
                this.l.setVisibility(8);
            }
            if (this.f73951b.getTotalTicketPrice() <= 0.0d || this.f73951b.getTicketCount() <= 0) {
                this.n.setVisibility(8);
            } else {
                int ticketCount2 = this.f73951b.getTicketCount();
                double totalTicketPrice = this.f73951b.getTotalTicketPrice() / ((double) ticketCount2);
                String string = getResources().getString(ticketCount2 == 1 ? R.string.ticket : R.string.tickets);
                this.p.setText(a(b.a(this.f73951b.getTotalTicketPrice())));
                this.o.setText(ticketCount2 + " " + string + " @ " + getResources().getString(R.string.rupee_symbol) + b.a(totalTicketPrice));
                this.n.setVisibility(0);
            }
            if (this.f73951b.getIsInsurancePresentV2() != 1 || this.f73951b.getInsurance() == null || this.f73951b.getInsurance().getTotalInsurancePrice().floatValue() <= 0.0f) {
                this.x.setVisibility(8);
            } else {
                this.y.setText("Cancellation Protect Charges");
                this.z.setText(a(String.valueOf(this.f73951b.getInsurance().getTotalInsurancePrice())));
                this.x.setVisibility(0);
            }
            if (!TextUtils.isEmpty(this.D.getTotalFoodPrice())) {
                this.s.setText(a(this.D.getTotalFoodPrice()));
                int foodItems = this.f73950a.getFoodItems();
                if (foodItems > 0) {
                    String str3 = foodItems > 1 ? "items" : "item";
                    this.r.setText(foodItems + " food " + str3);
                } else {
                    this.r.setText(getResources().getString(R.string.food_n_bevs));
                }
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            b();
            this.A.setVisibility(0);
            this.B.setText("Total Amount Paid");
            this.C.setText(a(b.a(this.D.getGrandTotal())));
            if (this.f73951b.getMovieImageUrl() != null) {
                String movieImageUrl = this.f73951b.getMovieImageUrl();
                if (movieImageUrl != null && !movieImageUrl.startsWith("https://") && !movieImageUrl.startsWith("http://")) {
                    movieImageUrl = "https://".concat(String.valueOf(movieImageUrl));
                }
                v.INSTANCE.loadImage(movieImageUrl, new ImageLoader.ImageListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                        AJRDownloadShareMovieActivity.this.N.setBackgroundColor(AJRDownloadShareMovieActivity.this.getResources().getColor(R.color.movie_offline_img_color));
                    }

                    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                        Bitmap bitmap;
                        if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null) {
                            AJRDownloadShareMovieActivity.this.N.setImageBitmap(bitmap);
                            AJRDownloadShareMovieActivity.this.L.setVisibility(8);
                        }
                    }
                });
            }
            StringBuilder sb2 = new StringBuilder();
            c.a();
            sb2.append(c.b());
            sb2.append("?ticket_key=");
            sb2.append(this.f73950a.getEncryptedOrderId());
            sb2.append("&size=10");
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(sb3)) {
                HashMap hashMap = new HashMap();
                hashMap.put(AppConstants.SSO_TOKEN, a.q(this));
                v.INSTANCE.loadImage(sb3, new ImageLoader.ImageListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                        AJRDownloadShareMovieActivity.this.O.setBackgroundColor(AJRDownloadShareMovieActivity.this.getResources().getColor(R.color.movie_offline_img_color));
                        AJRDownloadShareMovieActivity.this.P.setVisibility(8);
                        AJRDownloadShareMovieActivity.this.a();
                    }

                    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                        Bitmap bitmap;
                        if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null) {
                            AJRDownloadShareMovieActivity.this.P.setVisibility(0);
                            AJRDownloadShareMovieActivity.this.O.setImageBitmap(bitmap);
                            AJRDownloadShareMovieActivity.this.M.setVisibility(8);
                            AJRDownloadShareMovieActivity.this.a();
                        }
                    }
                }, hashMap);
            }
            a();
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.u.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AJRDownloadShareMovieActivity.this.u.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AJRDownloadShareMovieActivity.this.K.getLayoutParams().height = AJRDownloadShareMovieActivity.this.u.getHeight();
                AJRDownloadShareMovieActivity.this.K.requestLayout();
                AJRDownloadShareMovieActivity.this.K.invalidate();
                AJRDownloadShareMovieActivity.this.m.post(new Runnable() {
                    public final void run() {
                        AJRDownloadShareMovieActivity.this.e();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        int[] iArr = new int[2];
        this.m.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.K.getLocationOnScreen(iArr2);
        int i2 = iArr[1] - iArr2[1];
        this.K.setScallopPositionPercent((float) (((i2 + (this.m.getMeasuredHeight() + 90)) * 100) / this.K.getMeasuredHeight()));
    }

    private void b() {
        if (this.D.getMetaDataObject() != null) {
            LinkedHashMap<String, String> taxInfo = this.f73951b.getTaxInfo();
            if (taxInfo.size() > 0) {
                Set<String> keySet = taxInfo.keySet();
                Double valueOf = Double.valueOf(0.0d);
                HashMap<String, String> b2 = m.b(this.D.getMetaDataObject());
                for (String str : keySet) {
                    try {
                        valueOf = Double.valueOf(valueOf.doubleValue() + Double.valueOf(b2.get(str)).doubleValue());
                    } catch (NumberFormatException unused) {
                    }
                }
                if (valueOf.doubleValue() > 0.0d) {
                    this.t.setVisibility(0);
                    this.v.setText("Taxes & Conv. fees");
                    this.w.setText(a(b.a(valueOf.doubleValue())));
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(8);
    }

    private String a(String str) {
        return getResources().getString(R.string.rupee_symbol) + str;
    }

    private static void a(StringBuilder sb) {
        if (sb.toString().length() > 0) {
            sb.append(" | ");
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tvShare) {
            a(true);
        } else if (id == R.id.ivBackButton) {
            onBackPressed();
        } else if (id == R.id.tvDownlaod) {
            a(false);
        }
    }

    private void a(boolean z2) {
        if (androidx.core.app.a.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, z2 ^ true ? 1 : 0);
        } else {
            b(z2);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        boolean z2 = true;
        if (i2 != 0 && i2 != 1) {
            return;
        }
        if (s.a(iArr)) {
            if (i2 != 0) {
                z2 = false;
            }
            b(z2);
            return;
        }
        c(false);
        if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
            w.a((Activity) this);
        }
    }

    private static Bitmap a(View view, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(Color.parseColor("#f3f7f8"));
        }
        view.draw(canvas);
        return createBitmap;
    }

    private void b(boolean z2) {
        c(true);
        ScrollView scrollView = this.J;
        Uri a2 = w.a(getApplicationContext(), a(scrollView, scrollView.getChildAt(0).getHeight(), this.J.getChildAt(0).getWidth()), this.H);
        if (a2 != null) {
            if (z2) {
                a(a2);
                return;
            }
            c(false);
            Toast.makeText(this, "Ticket downloaded successfully to image gallery", 1).show();
        } else if (!z2) {
            c();
        } else {
            d();
        }
    }

    private void a(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.putExtra("android.intent.extra.TEXT", "Hi! This looks fun. Check out my latest movie booking from Paytm");
        intent.setType("image/jpeg");
        startActivity(intent);
        c(false);
    }

    private void c() {
        c(false);
        Toast.makeText(this, "Ticket not downloaded due to a technical error", 1).show();
    }

    private void d() {
        c(false);
        Toast.makeText(this, "Ticket not shared due to a technical error", 1).show();
    }

    private void c(boolean z2) {
        ProgressBar progressBar = this.I;
        if (progressBar != null) {
            if (z2) {
                progressBar.setVisibility(0);
            } else {
                progressBar.setVisibility(8);
            }
        }
    }
}
