package com.travel.sale;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.travel.R;
import com.travel.sale.data.model.CampaignDetailsResponse;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;

public final class LiveSaleView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f25691a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25692b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25693c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25694d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25695e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25696f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25697g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f25698h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f25699i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public ShareView n;
    private a o;
    private CampaignDetailsResponse p;

    public interface a {
        void e();
    }

    public LiveSaleView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public LiveSaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveSaleView(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveSaleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        RelativeLayout.inflate(context, R.layout.live_sale_view, this);
        View findViewById = findViewById(R.id.live_image);
        k.a((Object) findViewById, "findViewById(R.id.live_image)");
        this.f25691a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.day_value);
        k.a((Object) findViewById2, "findViewById(R.id.day_value)");
        this.f25692b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.hour_value);
        k.a((Object) findViewById3, "findViewById(R.id.hour_value)");
        this.f25693c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.minute_value);
        k.a((Object) findViewById4, "findViewById(R.id.minute_value)");
        this.f25694d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.second_value);
        k.a((Object) findViewById5, "findViewById(R.id.second_value)");
        this.f25695e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.live_title);
        k.a((Object) findViewById6, "findViewById(R.id.live_title)");
        this.f25696f = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.counter_title);
        k.a((Object) findViewById7, "findViewById(R.id.counter_title)");
        this.f25697g = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.book_now_btn);
        k.a((Object) findViewById8, "findViewById(R.id.book_now_btn)");
        this.f25698h = (RelativeLayout) findViewById8;
        View findViewById9 = findViewById(R.id.book_now_text);
        k.a((Object) findViewById9, "findViewById(R.id.book_now_text)");
        this.f25699i = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.day_text);
        k.a((Object) findViewById10, "findViewById(R.id.day_text)");
        this.j = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.hour_text);
        k.a((Object) findViewById11, "findViewById(R.id.hour_text)");
        this.k = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.minute_text);
        k.a((Object) findViewById12, "findViewById(R.id.minute_text)");
        this.l = (TextView) findViewById12;
        View findViewById13 = findViewById(R.id.second_text);
        k.a((Object) findViewById13, "findViewById(R.id.second_text)");
        this.m = (TextView) findViewById13;
        View findViewById14 = findViewById(R.id.share_button);
        k.a((Object) findViewById14, "findViewById(R.id.share_button)");
        this.n = (ShareView) findViewById14;
    }

    public final a getLiveSaleActionListener() {
        return this.o;
    }

    public final void setLiveSaleActionListener(a aVar) {
        this.o = aVar;
    }

    public final CampaignDetailsResponse getCampaignDetails() {
        return this.p;
    }

    public final void setCampaignDetails(CampaignDetailsResponse campaignDetailsResponse) {
        this.p = campaignDetailsResponse;
    }

    public final ImageView getLiveImage() {
        ImageView imageView = this.f25691a;
        if (imageView == null) {
            k.a("liveImage");
        }
        return imageView;
    }

    public final void setLiveImage(ImageView imageView) {
        k.c(imageView, "<set-?>");
        this.f25691a = imageView;
    }

    public final TextView getDayValue() {
        TextView textView = this.f25692b;
        if (textView == null) {
            k.a("dayValue");
        }
        return textView;
    }

    public final void setDayValue(TextView textView) {
        k.c(textView, "<set-?>");
        this.f25692b = textView;
    }

    public final TextView getHourValue() {
        TextView textView = this.f25693c;
        if (textView == null) {
            k.a("hourValue");
        }
        return textView;
    }

    public final void setHourValue(TextView textView) {
        k.c(textView, "<set-?>");
        this.f25693c = textView;
    }

    public final TextView getMinuteValue() {
        TextView textView = this.f25694d;
        if (textView == null) {
            k.a("minuteValue");
        }
        return textView;
    }

    public final void setMinuteValue(TextView textView) {
        k.c(textView, "<set-?>");
        this.f25694d = textView;
    }

    public final TextView getSecondValue() {
        TextView textView = this.f25695e;
        if (textView == null) {
            k.a("secondValue");
        }
        return textView;
    }

    public final void setSecondValue(TextView textView) {
        k.c(textView, "<set-?>");
        this.f25695e = textView;
    }

    public final TextView getLiveTitle() {
        TextView textView = this.f25696f;
        if (textView == null) {
            k.a("liveTitle");
        }
        return textView;
    }

    public final void setLiveTitle(TextView textView) {
        k.c(textView, "<set-?>");
        this.f25696f = textView;
    }

    public final TextView getCounterTitle() {
        TextView textView = this.f25697g;
        if (textView == null) {
            k.a("counterTitle");
        }
        return textView;
    }

    public final void setCounterTitle(TextView textView) {
        k.c(textView, "<set-?>");
        this.f25697g = textView;
    }

    public final RelativeLayout getBookNowBtn() {
        RelativeLayout relativeLayout = this.f25698h;
        if (relativeLayout == null) {
            k.a("bookNowBtn");
        }
        return relativeLayout;
    }

    public final void setBookNowBtn(RelativeLayout relativeLayout) {
        k.c(relativeLayout, "<set-?>");
        this.f25698h = relativeLayout;
    }

    public final TextView getBookNowTextView() {
        TextView textView = this.f25699i;
        if (textView == null) {
            k.a("bookNowTextView");
        }
        return textView;
    }

    public final void setBookNowTextView(TextView textView) {
        k.c(textView, "<set-?>");
        this.f25699i = textView;
    }

    public final TextView getDayTextView() {
        TextView textView = this.j;
        if (textView == null) {
            k.a("dayTextView");
        }
        return textView;
    }

    public final void setDayTextView(TextView textView) {
        k.c(textView, "<set-?>");
        this.j = textView;
    }

    public final TextView getHourTextView() {
        TextView textView = this.k;
        if (textView == null) {
            k.a("hourTextView");
        }
        return textView;
    }

    public final void setHourTextView(TextView textView) {
        k.c(textView, "<set-?>");
        this.k = textView;
    }

    public final TextView getMinuteTextView() {
        TextView textView = this.l;
        if (textView == null) {
            k.a("minuteTextView");
        }
        return textView;
    }

    public final void setMinuteTextView(TextView textView) {
        k.c(textView, "<set-?>");
        this.l = textView;
    }

    public final TextView getSecondsTextView() {
        TextView textView = this.m;
        if (textView == null) {
            k.a("secondsTextView");
        }
        return textView;
    }

    public final void setSecondsTextView(TextView textView) {
        k.c(textView, "<set-?>");
        this.m = textView;
    }

    public final ShareView getShareButton() {
        ShareView shareView = this.n;
        if (shareView == null) {
            k.a("shareButton");
        }
        return shareView;
    }

    public final void setShareButton(ShareView shareView) {
        k.c(shareView, "<set-?>");
        this.n = shareView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = r0.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.sale.data.model.CampaignDetailsResponse r5, com.travel.sale.LiveSaleView.a r6, com.travel.sale.ShareView.a r7) {
        /*
            r4 = this;
            r4.o = r6
            r4.p = r5
            android.widget.TextView r6 = r4.f25696f
            if (r6 != 0) goto L_0x000d
            java.lang.String r0 = "liveTitle"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x000d:
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r4.p
            r1 = 0
            if (r0 == 0) goto L_0x001d
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r0.getSaleLiveText()
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
            android.widget.TextView r6 = r4.f25697g
            if (r6 != 0) goto L_0x002c
            java.lang.String r0 = "counterTitle"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x002c:
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r4.p
            if (r0 == 0) goto L_0x003b
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r0.getEndsInText()
            goto L_0x003c
        L_0x003b:
            r0 = r1
        L_0x003c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
            com.paytm.utility.b.b$a r6 = com.paytm.utility.b.b.f43744a
            android.content.Context r6 = r4.getContext()
            if (r6 != 0) goto L_0x004c
            kotlin.g.b.k.a()
        L_0x004c:
            com.paytm.utility.b.b$a$a r6 = com.paytm.utility.b.b.a.a(r6)
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r4.p
            if (r0 == 0) goto L_0x005f
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = r0.getSuccessfullySubscribedIconUrl()
            goto L_0x0060
        L_0x005f:
            r0 = r1
        L_0x0060:
            r6.f43753a = r0
            int r0 = com.travel.R.drawable.sales_placeholder_default
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.paytm.utility.b.b$a$a r6 = r6.a((java.lang.Object) r0)
            int r0 = com.travel.R.drawable.sales_placeholder_default
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.paytm.utility.b.b$a$a r6 = r6.b(r0)
            r0 = 1
            r6.m = r0
            android.widget.ImageView r0 = r4.f25691a
            if (r0 != 0) goto L_0x0082
            java.lang.String r2 = "liveImage"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0082:
            r2 = 2
            com.paytm.utility.b.b.a.C0750a.a(r6, r0, r1, r2)
            kotlin.g.b.x$d r6 = new kotlin.g.b.x$d
            r6.<init>()
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r4.p
            if (r0 == 0) goto L_0x009a
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x009a
            java.lang.Long r0 = r0.getEndEpoch()
            goto L_0x009b
        L_0x009a:
            r0 = r1
        L_0x009b:
            if (r0 != 0) goto L_0x00a0
            kotlin.g.b.k.a()
        L_0x00a0:
            long r2 = r0.longValue()
            com.travel.sale.data.model.CampaignDetailsResponse r0 = r4.p
            if (r0 == 0) goto L_0x00b2
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r0 = r0.getBody()
            if (r0 == 0) goto L_0x00b2
            java.lang.Long r1 = r0.getCurrentTimestamp()
        L_0x00b2:
            if (r1 != 0) goto L_0x00b7
            kotlin.g.b.k.a()
        L_0x00b7:
            long r0 = r1.longValue()
            long r2 = r2 - r0
            r6.element = r2
            com.travel.sale.LiveSaleView$b r0 = new com.travel.sale.LiveSaleView$b
            long r1 = r6.element
            r0.<init>(r4, r6, r1)
            r0.start()
            android.widget.RelativeLayout r6 = r4.f25698h
            if (r6 != 0) goto L_0x00d1
            java.lang.String r0 = "bookNowBtn"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00d1:
            com.travel.sale.LiveSaleView$c r0 = new com.travel.sale.LiveSaleView$c
            r0.<init>(r4)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            com.travel.sale.ShareView r6 = r4.n
            java.lang.String r0 = "shareButton"
            if (r6 != 0) goto L_0x00e5
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00e5:
            com.travel.sale.ShareView r1 = r4.n
            if (r1 != 0) goto L_0x00ec
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00ec:
            int r0 = r1.getSHARE_VIEW_TYPE_BASIC()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.a((com.travel.sale.data.model.CampaignDetailsResponse) r5, (com.travel.sale.ShareView.a) r7, (java.lang.Integer) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.LiveSaleView.a(com.travel.sale.data.model.CampaignDetailsResponse, com.travel.sale.LiveSaleView$a, com.travel.sale.ShareView$a):void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveSaleView f25702a;

        c(LiveSaleView liveSaleView) {
            this.f25702a = liveSaleView;
        }

        public final void onClick(View view) {
            LiveSaleView.a(this.f25702a);
        }
    }

    public static final class b extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveSaleView f25700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.d f25701b;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException
            */
        b(kotlin.g.b.x.d r0, long r1, long r3) {
            /*
                r-1 = this;
                r0.f25700a = r1
                r0.f25701b = r2
                r1 = 1000(0x3e8, double:4.94E-321)
                r0.<init>(r3, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.LiveSaleView.b.<init>(com.travel.sale.LiveSaleView, kotlin.g.b.x$d, long):void");
        }

        public final void onTick(long j) {
            long j2 = j / 86400000;
            long j3 = j % 86400000;
            long j4 = j3 / 3600000;
            long j5 = j3 % 3600000;
            LiveSaleView.a(this.f25700a, j2, j4, j5 / 60000, (j5 % 60000) / 1000);
        }

        public final void onFinish() {
            LiveSaleView.a(this.f25700a, 0, 0, 0, 0);
            a liveSaleActionListener = this.f25700a.getLiveSaleActionListener();
            if (liveSaleActionListener != null) {
                liveSaleActionListener.e();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r2 = r2.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.travel.sale.LiveSaleView r2) {
        /*
            com.travel.d r0 = com.travel.d.a()
            java.lang.String r1 = "TravelController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            com.travel.common.b r0 = com.travel.d.b()
            android.content.Context r1 = r2.getContext()
            com.travel.sale.data.model.CampaignDetailsResponse r2 = r2.p
            if (r2 == 0) goto L_0x0020
            com.travel.sale.data.model.CampaignDetailsResponse$CampaignDetails r2 = r2.getBody()
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = r2.getCampaignDeepLink()
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r0.a((android.content.Context) r1, (java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.sale.LiveSaleView.a(com.travel.sale.LiveSaleView):void");
    }

    public static final /* synthetic */ void a(LiveSaleView liveSaleView, long j2, long j3, long j4, long j5) {
        int i2;
        Resources resources;
        int i3;
        Resources resources2;
        int i4;
        Resources resources3;
        TextView textView = liveSaleView.j;
        if (textView == null) {
            k.a("dayTextView");
        }
        if (textView != null) {
            if (j2 <= 1) {
                resources3 = liveSaleView.getResources();
                i4 = R.string.travel_sale_day;
            } else {
                resources3 = liveSaleView.getResources();
                i4 = R.string.travel_sale_days;
            }
            textView.setText(resources3.getString(i4));
        }
        TextView textView2 = liveSaleView.k;
        if (textView2 == null) {
            k.a("hourTextView");
        }
        if (textView2 != null) {
            if (j3 <= 1) {
                resources2 = liveSaleView.getResources();
                i3 = R.string.travel_sale_hour;
            } else {
                resources2 = liveSaleView.getResources();
                i3 = R.string.travel_sale_hours;
            }
            textView2.setText(resources2.getString(i3));
        }
        TextView textView3 = liveSaleView.l;
        if (textView3 == null) {
            k.a("minuteTextView");
        }
        if (textView3 != null) {
            if (j4 <= 1) {
                resources = liveSaleView.getResources();
                i2 = R.string.travel_sale_minute;
            } else {
                resources = liveSaleView.getResources();
                i2 = R.string.travel_sale_minutes;
            }
            textView3.setText(resources.getString(i2));
        }
        TextView textView4 = liveSaleView.m;
        if (textView4 == null) {
            k.a("secondsTextView");
        }
        if (textView4 != null) {
            textView4.setText(liveSaleView.getResources().getString(j5 <= 1 ? R.string.travel_sale_second : R.string.travel_sale_seconds));
        }
        TextView textView5 = liveSaleView.f25692b;
        if (textView5 == null) {
            k.a("dayValue");
        }
        if (textView5 != null) {
            int i5 = (j2 > 10 ? 1 : (j2 == 10 ? 0 : -1));
            String valueOf = String.valueOf(j2);
            if (i5 < 0) {
                valueOf = "0".concat(valueOf);
            }
            textView5.setText(valueOf);
        }
        TextView textView6 = liveSaleView.f25693c;
        if (textView6 == null) {
            k.a("hourValue");
        }
        if (textView6 != null) {
            textView6.setText(j3 < 10 ? "0".concat(String.valueOf(j3)) : String.valueOf(j3));
        }
        TextView textView7 = liveSaleView.f25694d;
        if (textView7 == null) {
            k.a("minuteValue");
        }
        if (textView7 != null) {
            textView7.setText(j4 < 10 ? "0".concat(String.valueOf(j4)) : String.valueOf(j4));
        }
        TextView textView8 = liveSaleView.f25695e;
        if (textView8 == null) {
            k.a("secondValue");
        }
        if (textView8 != null) {
            textView8.setText(j5 < 10 ? "0".concat(String.valueOf(j5)) : String.valueOf(j5));
        }
    }
}
