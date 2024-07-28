package com.travel.citybus.brts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.c;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.citybus.R;
import com.travel.citybus.brts.model.CJRBrtsIntermediateStop;
import com.travel.citybus.brts.model.CJRBrtsPaxInfo;
import com.travel.citybus.brts.model.CJRBrtsTxnInfo;
import com.travel.citybus.brts.model.CityBusQRModel;
import com.travel.citybus.brts.model.CitybusQrCode;
import com.travel.citybus.brts.utils.d;
import com.travel.utils.n;
import easypay.manager.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;
import org.json.JSONException;
import org.json.JSONObject;

public class BCLLSuccessBookingActivity extends PaytmActivity implements View.OnClickListener, b {
    public static String INPUT_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String TAG = BCLLSuccessBookingActivity.class.getSimpleName();
    public static String isFromPayment = "is_from_payment";
    private ImageView backButton;
    private ImageButton backButtonSuccess;
    private ConstraintLayout clBookingHeader;
    private long expiryMilli;
    private CountDownTimer expiryTimeCountDownTimer = null;
    private boolean isDirect;
    private ImageView ivTicketStatus;
    private LinearLayout linearQRImage;
    private LinearLayout lnrFareBreakUp;
    private LinearLayout lnrIntermediateStops;
    private View mExpiryView;
    private Handler mHandler = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!BCLLSuccessBookingActivity.this.isFinishing()) {
                if ((Build.VERSION.SDK_INT < 17 || !BCLLSuccessBookingActivity.this.isDestroyed()) && message.what == 1) {
                    StringBuilder sb = new StringBuilder();
                    f.d();
                    sb.append(f.d().b());
                    sb.append(BCLLSuccessBookingActivity.this.mOrderId);
                    BCLLSuccessBookingActivity.this.getOrderDetailServer(sb.toString());
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public String mOrderId;
    private CJROrderSummary mOrderSummary;
    private TextView mTicketStatus;
    private TextView mTicketStatusSuccess;
    private TextView mToken;
    private TextView mTokenNumber;
    private TextView mTvBookingTimeFront;
    private TextView mTvBookingTimeFrontSuccess;
    /* access modifiers changed from: private */
    public TextView osExpiryTimerTv;
    private LinearLayout paxDetailHolder;
    private int pendingRetry = 0;
    private RelativeLayout rlvBookingSuccess;
    private TextView tapToScan;
    private TextView textOrderId;
    private TextView textOrderIdSuccess;
    private String tokenResponse;
    private TextView tvBookingStatus;
    private TextView tvIntermediateStops;
    private View viewLine1;
    private View viewLinePax;
    private View viewStopsMainLine;
    private Window window = null;
    private CJRBrtsTxnInfo withdrawResponse;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        getWindow().addFlags(128);
        setContentView(R.layout.bcll_success_activity);
        initViews();
        if (getIntent() != null && getIntent().hasExtra(isFromPayment)) {
            this.isDirect = getIntent().getBooleanExtra(isFromPayment, false);
        }
        if (getIntent() != null && getIntent().hasExtra("order_id")) {
            this.mOrderId = getIntent().getStringExtra("order_id");
            f.d();
            String b2 = f.d().b();
            if (TextUtils.isEmpty(b2) && bundle != null && bundle.containsKey("url")) {
                b2 = bundle.getString("url");
            }
            getOrderDetailServer(b2 + this.mOrderId);
        }
    }

    public void onBackPressed() {
        if (this.isDirect) {
            launchHome((Bundle) null, "");
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public void getOrderDetailServer(String str) {
        d.a aVar = d.f23400a;
        if (!TextUtils.isEmpty(d.a.a(this).b("sso_token=", "", true))) {
            String str2 = c.b(str, (Context) this) + "&actions=1";
            if (getIntent().getBooleanExtra("is_from_pg_page", false)) {
                str2 = str2 + "&post_payment=1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, a.q(this));
            com.travel.citybus.brts.b.a.a();
            com.travel.citybus.brts.b.a.a(this, str2, hashMap, new CJROrderSummary(), this);
        }
    }

    public void showProgress() {
        findViewById(R.id.parent_layout).setVisibility(8);
        findViewById(R.id.progress_bar).setVisibility(0);
        findViewById(R.id.processing_layout).setVisibility(8);
    }

    public void hideProgress(boolean z) {
        findViewById(R.id.progress_bar).setVisibility(8);
        if (z) {
            findViewById(R.id.parent_layout).setVisibility(8);
            findViewById(R.id.processing_layout).setVisibility(0);
            return;
        }
        findViewById(R.id.parent_layout).setVisibility(0);
        findViewById(R.id.processing_layout).setVisibility(8);
    }

    private void initViews() {
        showProgress();
        this.window = getWindow();
        this.window.addFlags(Integer.MIN_VALUE);
        this.mTvBookingTimeFront = (TextView) findViewById(R.id.brts_time_txn_front_textview);
        this.mTokenNumber = (TextView) findViewById(R.id.token_number_text);
        this.mToken = (TextView) findViewById(R.id.token_number);
        this.backButton = (ImageView) findViewById(R.id.icon_back);
        this.mExpiryView = findViewById(R.id.expiry_layout);
        this.osExpiryTimerTv = (TextView) findViewById(R.id.osExpiryTimerTv);
        this.viewLine1 = findViewById(R.id.viewLine1);
        this.viewLinePax = findViewById(R.id.viewLinePax);
        this.clBookingHeader = (ConstraintLayout) findViewById(R.id.cl_booking_header);
        this.ivTicketStatus = (ImageView) findViewById(R.id.iv_ticket_status);
        this.linearQRImage = (LinearLayout) findViewById(R.id.li_qr_image);
        this.rlvBookingSuccess = (RelativeLayout) findViewById(R.id.rlv_booking_success);
        this.backButtonSuccess = (ImageButton) findViewById(R.id.icon_back_success);
        this.mTicketStatusSuccess = (TextView) findViewById(R.id.ticket_status_success);
        this.textOrderIdSuccess = (TextView) findViewById(R.id.order_id_success);
        this.mTvBookingTimeFrontSuccess = (TextView) findViewById(R.id.brts_time_txn_front_textview_success);
        this.tvIntermediateStops = (TextView) findViewById(R.id.tvIntermediateStops);
        this.viewStopsMainLine = findViewById(R.id.viewStopsMainLine);
        this.tapToScan = (TextView) findViewById(R.id.tapToScanQrCodeTv);
        ResourceUtils.loadCityBusImagesFromCDN(this.ivTicketStatus, "ticket_success.png", false, false, n.a.V1);
        TextView textView = this.tvIntermediateStops;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ImageButton imageButton = this.backButtonSuccess;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageView imageView = this.backButton;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        LinearLayout linearLayout = this.linearQRImage;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BCLLSuccessBookingActivity.this.lambda$initViews$0$BCLLSuccessBookingActivity(view);
                }
            });
        }
        this.mTicketStatus = (TextView) findViewById(R.id.ticket_status);
        this.textOrderId = (TextView) findViewById(R.id.order_id);
        this.paxDetailHolder = (LinearLayout) findViewById(R.id.pax_detail_holder);
        this.tvBookingStatus = (TextView) findViewById(R.id.tv_booking_status);
        this.lnrFareBreakUp = (LinearLayout) findViewById(R.id.lnrFareBreakUp);
        this.lnrIntermediateStops = (LinearLayout) findViewById(R.id.lnrIntermediateStops);
    }

    public /* synthetic */ void lambda$initViews$0$BCLLSuccessBookingActivity(View view) {
        if (com.travel.citybus.best.a.a(this.withdrawResponse.getMerchantName()) && this.mOrderSummary.getOrderedCartList() != null && this.mOrderSummary.getOrderedCartList().size() > 0) {
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putSerializable("Order Data", this.mOrderSummary.getOrderedCartList().get(0));
            eVar.setArguments(bundle);
            eVar.show(getSupportFragmentManager(), eVar.getTag());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f.d();
        bundle.putString("url", f.d().b());
    }

    private void setUI(CJROrderSummary cJROrderSummary) {
        hideProgress(false);
        if (v.a(this.mOrderId)) {
            this.mOrderId = cJROrderSummary.getId();
        }
        if (this.mOrderSummary.getStatus() != null && this.mOrderSummary.getOrderedCartList() != null && this.mOrderSummary.getOrderedCartList().size() > 0) {
            CJROrderedCart cJROrderedCart = this.mOrderSummary.getOrderedCartList().get(0);
            Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
            f fVar = new f();
            String a2 = fVar.a(metaDataResponse);
            try {
                if (cJROrderedCart.getFullFillmentOject() != null && !TextUtils.isEmpty(cJROrderedCart.getFullFillmentOject().getFulfillmentResponse())) {
                    JSONObject jSONObject = new JSONObject(cJROrderedCart.getFullFillmentOject().getFulfillmentResponse());
                    this.tokenResponse = jSONObject.optString("token_id");
                    this.expiryMilli = jSONObject.optLong("ticketExpiryDate");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.withdrawResponse = (CJRBrtsTxnInfo) fVar.a(a2, CJRBrtsTxnInfo.class);
            setBMTCData(cJROrderedCart);
        }
    }

    private void setBMTCData(CJROrderedCart cJROrderedCart) {
        TextView textView = this.textOrderId;
        textView.setText("Booking ID: " + this.mOrderId);
        TextView textView2 = this.textOrderIdSuccess;
        textView2.setText("Booking ID: " + this.mOrderId);
        this.mTokenNumber.setText(this.tokenResponse);
        CJRBrtsTxnInfo cJRBrtsTxnInfo = this.withdrawResponse;
        if (cJRBrtsTxnInfo != null && !cJRBrtsTxnInfo.getMerchantName().equalsIgnoreCase(com.travel.citybus.brts.utils.a.f23393f)) {
            this.mToken.setText(getString(R.string.route_number));
            if (TextUtils.isEmpty(this.tokenResponse)) {
                this.mTokenNumber.setText(this.withdrawResponse.getRouteId());
            }
        }
        CJRBrtsTxnInfo cJRBrtsTxnInfo2 = this.withdrawResponse;
        if (cJRBrtsTxnInfo2 == null || cJRBrtsTxnInfo2.getIntermediateStops() == null || this.withdrawResponse.getIntermediateStops().size() <= 2) {
            this.tvIntermediateStops.setVisibility(8);
            this.lnrIntermediateStops.setVisibility(8);
            this.viewStopsMainLine.getLayoutParams().height = (int) getResources().getDimension(R.dimen.dimen_40dp_brts);
        } else {
            List<CJRBrtsIntermediateStop> intermediateStops = this.withdrawResponse.getIntermediateStops();
            if (this.withdrawResponse.getSource().toLowerCase().equals(intermediateStops.get(0).getName().toLowerCase())) {
                intermediateStops.remove(0);
            }
            if (this.withdrawResponse.getDestination().toLowerCase().equals(intermediateStops.get(intermediateStops.size() - 1).getName().toLowerCase())) {
                intermediateStops.remove(intermediateStops.size() - 1);
            }
            if (this.withdrawResponse.getNumberOfStops() <= 0 || intermediateStops == null || intermediateStops.size() <= 0) {
                this.tvIntermediateStops.setVisibility(4);
                this.lnrIntermediateStops.setVisibility(4);
            } else {
                this.tvIntermediateStops.setVisibility(0);
                this.tvIntermediateStops.setText(com.travel.citybus.brts.utils.f.a(this.withdrawResponse.getNumberOfStops()));
                this.viewStopsMainLine.getLayoutParams().height = (int) getResources().getDimension(R.dimen.dimen_80dp_brts);
                this.lnrIntermediateStops.removeAllViews();
                for (CJRBrtsIntermediateStop name : intermediateStops) {
                    View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.brts_i_stop_item, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.tvIStopItem)).setText(name.getName());
                    this.lnrIntermediateStops.addView(inflate);
                }
            }
        }
        String ticketDate = getTicketDate(this.mOrderSummary.getCreatedAt());
        this.mTvBookingTimeFront.setText("Booked on ".concat(String.valueOf(ticketDate)));
        this.mTvBookingTimeFrontSuccess.setText("Booked on ".concat(String.valueOf(ticketDate)));
        ((TextView) findViewById(R.id.source_name)).setText(this.withdrawResponse.getSource());
        ((TextView) findViewById(R.id.bmtc_total_amount)).setText(getResources().getString(R.string.rupee_symbol) + " " + com.travel.citybus.brts.utils.a.a(Double.valueOf(this.mOrderSummary.getGrandTotal())));
        ((TextView) findViewById(R.id.tv_ticket_total)).setText(getResources().getString(R.string.rupee_symbol) + " " + com.travel.citybus.brts.utils.a.a(Double.valueOf(this.mOrderSummary.getGrandTotal())));
        ((TextView) findViewById(R.id.destination_name)).setText(this.withdrawResponse.getDestination());
        int initTicketDetails = initTicketDetails();
        this.lnrFareBreakUp.setVisibility(0);
        if (initTicketDetails == 0 || initTicketDetails != 1) {
            TextView textView3 = this.mTicketStatusSuccess;
            textView3.setText(initTicketDetails + " Tickets Booked");
        } else {
            this.mTicketStatusSuccess.setText("Ticket Booked");
        }
        ticketBookedCase();
        if (!com.travel.citybus.best.a.a(this.withdrawResponse.getMerchantName())) {
            this.tapToScan.setVisibility(4);
        }
        initPaxDetails();
        initQRCode(cJROrderedCart, initTicketDetails);
        runExpiryTimer(initTicketDetails);
    }

    private void initQRCode(CJROrderedCart cJROrderedCart, int i2) {
        this.linearQRImage.setVisibility(8);
        if (cJROrderedCart == null || cJROrderedCart.getFullFillmentOject() == null || TextUtils.isEmpty(cJROrderedCart.getFullFillmentOject().getFulfillmentResponse())) {
            this.rlvBookingSuccess.setVisibility(8);
            this.clBookingHeader.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 21) {
                this.window.setStatusBarColor(getResources().getColor(R.color.city_bus_color_success));
            }
            this.paxDetailHolder.setVisibility(0);
            this.mExpiryView.setVisibility(0);
            this.viewLine1.setVisibility(0);
            this.viewLinePax.setVisibility(0);
            runExpiryTimer(i2);
            return;
        }
        try {
            this.linearQRImage.removeAllViews();
            CityBusQRModel cityBusQRModel = (CityBusQRModel) new f().a(new JSONObject(cJROrderedCart.getFullFillmentOject().getFulfillmentResponse()).toString(), CityBusQRModel.class);
            if (cityBusQRModel != null && cityBusQRModel.getCitybusQrCode().size() > 0) {
                List<CitybusQrCode> citybusQrCode = cityBusQRModel.getCitybusQrCode();
                this.linearQRImage.setVisibility(0);
                int size = citybusQrCode.size();
                for (int i3 = 0; i3 < size; i3++) {
                    List<String> qrstrings = citybusQrCode.get(i3).getQrstrings();
                    if (qrstrings != null && qrstrings.size() > 0) {
                        int size2 = qrstrings.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            View inflate = LayoutInflater.from(this).inflate(R.layout.bcll_qr_items, this.linearQRImage, false);
                            getApplicationContext();
                            ((ImageView) inflate.findViewById(R.id.e_qr_image)).setImageBitmap(com.google.zxing.client.android.d.a.a(qrstrings.get(i4), convertDpToPixel(240.0f, getApplicationContext()), convertDpToPixel(240.0f, getApplicationContext()), false));
                            this.linearQRImage.addView(inflate);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int convertDpToPixel(float f2, Context context) {
        return (int) (f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private int initTicketDetails() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fare_detail_holder);
        Iterator<CJRBrtsPaxInfo> it2 = this.withdrawResponse.getmPaxInfo().iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            CJRBrtsPaxInfo next = it2.next();
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.bmtc_ticket_detail_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ticket_name)).setText(next.getPaxName() + " Fare");
            if (next.getCount() > 1) {
                ((TextView) inflate.findViewById(R.id.ticket_pax_count)).setText("(" + next.getCount() + " Passengers)");
            } else {
                ((TextView) inflate.findViewById(R.id.ticket_pax_count)).setText("(" + next.getCount() + " Passenger)");
            }
            double fare = next.getFare() * ((double) next.getCount());
            ((TextView) inflate.findViewById(R.id.ticket_amount)).setText(getResources().getString(R.string.rupee_symbol) + " " + com.travel.citybus.brts.utils.a.a(Double.valueOf(fare)));
            linearLayout.addView(inflate);
            i2 += next.getCount();
        }
        return i2;
    }

    private void initPaxDetails() {
        Iterator<CJRBrtsPaxInfo> it2 = this.withdrawResponse.getmPaxInfo().iterator();
        while (it2.hasNext()) {
            CJRBrtsPaxInfo next = it2.next();
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.bmtc_pax_detail_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_pax_type)).setText(next.getPaxName());
            if (next.getPaxName().contains("senior")) {
                inflate.findViewById(R.id.iv_pax_type).setBackground(androidx.core.content.b.f.a(getResources(), R.drawable.ic_senior_citizen, (Resources.Theme) null));
            } else if (next.getPaxName().equalsIgnoreCase("child")) {
                inflate.findViewById(R.id.iv_pax_type).setBackground(androidx.core.content.b.f.a(getResources(), R.drawable.ic_child, (Resources.Theme) null));
            } else {
                inflate.findViewById(R.id.iv_pax_type).setBackground(androidx.core.content.b.f.a(getResources(), R.drawable.ic_adult, (Resources.Theme) null));
            }
            ((TextView) inflate.findViewById(R.id.tv_pax_count)).setText(String.valueOf(next.getCount()));
            this.paxDetailHolder.addView(inflate);
        }
    }

    public String getTicketDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(INPUT_TIME_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date parse = simpleDateFormat.parse(str);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("E, dd MMM hh:mm a");
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat2.format(parse);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.icon_back) {
            onBackPressed();
        } else if (view.getId() == R.id.icon_back_success) {
            onBackPressed();
        } else if (view.getId() == R.id.tvIntermediateStops) {
            if (this.lnrIntermediateStops.getVisibility() == 0) {
                this.tvIntermediateStops.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.brts_down_arrow, 0);
                this.lnrIntermediateStops.setVisibility(8);
                return;
            }
            this.tvIntermediateStops.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.brts_up_arrow, 0);
            this.lnrIntermediateStops.setVisibility(0);
        } else if (!view.isSelected()) {
            Object tag = view.getTag();
            f.d();
            if (f.d().a(tag)) {
                f.d();
                launchHome((Bundle) null, f.d().b(tag));
                return;
            }
            q.c();
        }
    }

    private void launchHome(Bundle bundle, String str) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        if (!str.isEmpty()) {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, str);
        } else {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        }
        intent.putExtra("started_activity_from_recharge", true);
        f.d();
        f.d().a(this, intent);
        finish();
    }

    private void runExpiryTimer(final int i2) {
        long j = this.expiryMilli;
        if (j <= 0 || j - System.currentTimeMillis() <= 0) {
            long j2 = this.expiryMilli;
            if (j2 > 0 && j2 - System.currentTimeMillis() < 0) {
                ticketExpiredCase(i2);
            } else if (this.expiryMilli == 0) {
                this.mExpiryView.setVisibility(8);
            }
        } else {
            this.mExpiryView.setVisibility(0);
            this.expiryTimeCountDownTimer = new CountDownTimer(this.expiryMilli - System.currentTimeMillis()) {
                public final void onTick(long j) {
                    TextView access$200 = BCLLSuccessBookingActivity.this.osExpiryTimerTv;
                    com.travel.citybus.best.e.c cVar = com.travel.citybus.best.e.c.f23051a;
                    access$200.setText(String.valueOf(com.travel.citybus.best.e.c.a(j)));
                }

                public final void onFinish() {
                    BCLLSuccessBookingActivity.this.ticketExpiredCase(i2);
                }
            }.start();
        }
    }

    private void ticketBookedCase() {
        this.rlvBookingSuccess.setVisibility(0);
        this.clBookingHeader.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 21) {
            this.window.setStatusBarColor(getResources().getColor(R.color.city_bus_color_success));
        }
        this.paxDetailHolder.setVisibility(0);
        this.mExpiryView.setVisibility(8);
        this.viewLine1.setVisibility(0);
        this.viewLinePax.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void ticketExpiredCase(int i2) {
        this.rlvBookingSuccess.setVisibility(8);
        this.clBookingHeader.setVisibility(0);
        this.clBookingHeader.setBackgroundColor(getResources().getColor(R.color.city_bus_color_failure));
        ResourceUtils.loadCityBusImagesFromCDN(this.ivTicketStatus, "ticket_expired.png", false, false, n.a.V1);
        if (Build.VERSION.SDK_INT >= 21) {
            this.window.setStatusBarColor(getResources().getColor(R.color.city_bus_color_failure));
        }
        if (i2 == 0 || i2 != 1) {
            this.mTicketStatus.setText("Tickets Expired");
        } else {
            this.mTicketStatus.setText("Ticket Expired");
        }
        this.paxDetailHolder.setVisibility(8);
        this.mExpiryView.setVisibility(8);
        this.viewLine1.setVisibility(8);
        this.viewLinePax.setVisibility(8);
    }

    private void bookingPendingFailedCase(boolean z) {
        String str;
        hideProgress(false);
        this.rlvBookingSuccess.setVisibility(8);
        this.clBookingHeader.setVisibility(0);
        if (v.a(this.mOrderId)) {
            this.mOrderId = this.mOrderSummary.getId();
        }
        String str2 = "";
        if (this.mOrderSummary.getStatus() == null || this.mOrderSummary.getOrderedCartList() == null || this.mOrderSummary.getOrderedCartList().size() <= 0) {
            str = str2;
        } else {
            CJROrderedCart cJROrderedCart = this.mOrderSummary.getOrderedCartList().get(0);
            Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
            f fVar = new f();
            String a2 = fVar.a(metaDataResponse);
            try {
                if (cJROrderedCart.getFullFillmentOject() != null && !TextUtils.isEmpty(cJROrderedCart.getFullFillmentOject().getFulfillmentResponse())) {
                    this.tokenResponse = new JSONObject(cJROrderedCart.getFullFillmentOject().getFulfillmentResponse()).optString("token_id");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.withdrawResponse = (CJRBrtsTxnInfo) fVar.a(a2, CJRBrtsTxnInfo.class);
            str2 = cJROrderedCart.getItemStatus();
            str = this.mOrderSummary.getPaymentStatus();
            CJRBrtsTxnInfo cJRBrtsTxnInfo = this.withdrawResponse;
            if (cJRBrtsTxnInfo == null || cJRBrtsTxnInfo.getIntermediateStops() == null || this.withdrawResponse.getIntermediateStops().size() <= 2) {
                this.tvIntermediateStops.setVisibility(8);
                this.lnrIntermediateStops.setVisibility(8);
                this.viewStopsMainLine.getLayoutParams().height = (int) getResources().getDimension(R.dimen.dimen_40dp_brts);
            } else {
                List<CJRBrtsIntermediateStop> intermediateStops = this.withdrawResponse.getIntermediateStops();
                if (this.withdrawResponse.getSource().toLowerCase().equals(intermediateStops.get(0).getName().toLowerCase())) {
                    intermediateStops.remove(0);
                }
                if (this.withdrawResponse.getDestination().toLowerCase().equals(intermediateStops.get(intermediateStops.size() - 1).getName().toLowerCase())) {
                    intermediateStops.remove(intermediateStops.size() - 1);
                }
                if (this.withdrawResponse.getNumberOfStops() <= 0 || intermediateStops == null || intermediateStops.size() <= 0) {
                    this.tvIntermediateStops.setVisibility(4);
                    this.lnrIntermediateStops.setVisibility(4);
                } else {
                    this.tvIntermediateStops.setVisibility(0);
                    this.tvIntermediateStops.setText(com.travel.citybus.brts.utils.f.a(this.withdrawResponse.getNumberOfStops()));
                    this.viewStopsMainLine.getLayoutParams().height = (int) getResources().getDimension(R.dimen.dimen_80dp_brts);
                    this.lnrIntermediateStops.removeAllViews();
                    for (CJRBrtsIntermediateStop name : intermediateStops) {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.brts_i_stop_item, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tvIStopItem)).setText(name.getName());
                        this.lnrIntermediateStops.addView(inflate);
                    }
                }
            }
        }
        TextView textView = this.textOrderId;
        textView.setText("Booking ID: " + this.mOrderId);
        this.mTokenNumber.setText(this.tokenResponse);
        CJRBrtsTxnInfo cJRBrtsTxnInfo2 = this.withdrawResponse;
        if (cJRBrtsTxnInfo2 != null && !cJRBrtsTxnInfo2.getMerchantName().equalsIgnoreCase(com.travel.citybus.brts.utils.a.f23393f)) {
            this.mToken.setText(getString(R.string.route_number));
            if (TextUtils.isEmpty(this.tokenResponse)) {
                this.mTokenNumber.setText(this.withdrawResponse.getRouteId());
            }
        }
        this.mTvBookingTimeFront.setText(getTicketDate(this.mOrderSummary.getCreatedAt()));
        ((TextView) findViewById(R.id.source_name)).setText(this.withdrawResponse.getSource());
        ((TextView) findViewById(R.id.bmtc_total_amount)).setText(getResources().getString(R.string.rupee_symbol) + " " + com.travel.citybus.brts.utils.a.a(Double.valueOf(this.mOrderSummary.getGrandTotal())));
        ((TextView) findViewById(R.id.tv_ticket_total)).setText(getResources().getString(R.string.rupee_symbol) + " " + com.travel.citybus.brts.utils.a.a(Double.valueOf(this.mOrderSummary.getGrandTotal())));
        ((TextView) findViewById(R.id.destination_name)).setText(this.withdrawResponse.getDestination());
        String paymentBank = this.mOrderSummary.getPaymentInfo().get(0).getPaymentBank();
        if (!z) {
            this.clBookingHeader.setBackgroundColor(getResources().getColor(R.color.city_bus_color_pending));
            ResourceUtils.loadCityBusImagesFromCDN(this.ivTicketStatus, "booking_pending.png", false, false, n.a.V1);
            if (Build.VERSION.SDK_INT >= 21) {
                this.window.setStatusBarColor(getResources().getColor(R.color.city_bus_color_pending));
            }
            this.paxDetailHolder.setVisibility(8);
            this.lnrFareBreakUp.setVisibility(8);
            this.tvBookingStatus.setVisibility(0);
            this.mExpiryView.setVisibility(8);
            this.viewLine1.setVisibility(0);
            this.viewLinePax.setVisibility(8);
            if (TextUtils.isEmpty(str2) || !str2.equals("1") || !str.equalsIgnoreCase(CJRAutomaticSubscriptionHistory.PROCESSING)) {
                if (TextUtils.isEmpty(str2) || !str2.equals("1") || !str.equalsIgnoreCase(SDKConstants.GA_NATIVE_FAILED)) {
                    this.mTicketStatus.setText("Ticket generation is taking longer than usual");
                } else {
                    if (TextUtils.isEmpty(paymentBank) || paymentBank.equalsIgnoreCase("NULL") || paymentBank.equalsIgnoreCase("Wallet")) {
                        this.mTicketStatus.setText("Payment Failed ");
                    } else {
                        TextView textView2 = this.mTicketStatus;
                        textView2.setText(paymentBank + " has declined your payment. ");
                    }
                    this.clBookingHeader.setBackgroundColor(getResources().getColor(R.color.city_bus_color_failure));
                    ResourceUtils.loadCityBusImagesFromCDN(this.ivTicketStatus, "booking_failed.png", false, false, n.a.V1);
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.window.setStatusBarColor(getResources().getColor(R.color.city_bus_color_failure));
                    }
                    initTicketDetails();
                    this.lnrFareBreakUp.setVisibility(0);
                }
            } else if (TextUtils.isEmpty(paymentBank) || paymentBank.equalsIgnoreCase("NULL")) {
                this.mTicketStatus.setText("Payment Pending");
            } else {
                this.mTicketStatus.setText("Payment Pending From ".concat(String.valueOf(paymentBank)));
            }
        } else if (TextUtils.isEmpty(str2) || !str2.equals("1") || !str.equalsIgnoreCase(SDKConstants.GA_NATIVE_FAILED)) {
            this.clBookingHeader.setBackgroundColor(getResources().getColor(R.color.city_bus_color_pending));
            ResourceUtils.loadCityBusImagesFromCDN(this.ivTicketStatus, "booking_pending.png", false, false, n.a.V1);
            if (Build.VERSION.SDK_INT >= 21) {
                this.window.setStatusBarColor(getResources().getColor(R.color.city_bus_color_pending));
            }
            this.paxDetailHolder.setVisibility(8);
            this.tvBookingStatus.setVisibility(0);
            this.lnrFareBreakUp.setVisibility(8);
            this.viewLine1.setVisibility(0);
            this.viewLinePax.setVisibility(8);
            this.mExpiryView.setVisibility(8);
            this.mTicketStatus.setText("Ticket generation is taking longer than usual");
        } else {
            if (TextUtils.isEmpty(paymentBank) || paymentBank.equalsIgnoreCase("NULL") || paymentBank.equalsIgnoreCase("Wallet")) {
                this.mTicketStatus.setText("Payment Failed ");
            } else {
                TextView textView3 = this.mTicketStatus;
                textView3.setText(paymentBank + " has declined your payment. ");
            }
            this.clBookingHeader.setBackgroundColor(getResources().getColor(R.color.city_bus_color_failure));
            ResourceUtils.loadCityBusImagesFromCDN(this.ivTicketStatus, "booking_failed.png", false, false, n.a.V1);
            if (Build.VERSION.SDK_INT >= 21) {
                this.window.setStatusBarColor(getResources().getColor(R.color.city_bus_color_failure));
            }
            this.paxDetailHolder.setVisibility(8);
            this.tvBookingStatus.setVisibility(0);
            this.mExpiryView.setVisibility(8);
            this.viewLine1.setVisibility(0);
            this.viewLinePax.setVisibility(8);
            initTicketDetails();
            this.lnrFareBreakUp.setVisibility(0);
        }
        if (!z) {
            if (TextUtils.isEmpty(str2) || !str2.equals("1") || !str.equalsIgnoreCase(CJRAutomaticSubscriptionHistory.PROCESSING)) {
                if (TextUtils.isEmpty(str2) || !str2.equals("1") || !str.equalsIgnoreCase(SDKConstants.GA_NATIVE_FAILED)) {
                    this.tvBookingStatus.setText("We will send you Email and SMS once ticket is generated");
                    return;
                }
                this.tvBookingStatus.setText("This may be due to wrong OTP (one time password)/ 3D secure password entered\nPlease try again with correct details");
                if (TextUtils.isEmpty(paymentBank) || paymentBank.equalsIgnoreCase("NULL") || paymentBank.equalsIgnoreCase("Wallet")) {
                    this.tvBookingStatus.setVisibility(8);
                    this.viewLine1.setVisibility(8);
                    this.viewLinePax.setVisibility(8);
                }
            } else if (TextUtils.isEmpty(paymentBank) || paymentBank.equalsIgnoreCase("NULL")) {
                this.tvBookingStatus.setText("We are checking your payment status.");
            } else {
                this.tvBookingStatus.setText("We are checking your payment status with ".concat(String.valueOf(paymentBank)));
            }
        } else if (TextUtils.isEmpty(str2) || !str2.equals("1") || !str.equalsIgnoreCase(SDKConstants.GA_NATIVE_FAILED)) {
            this.tvBookingStatus.setText("We will send you Email and SMS once ticket is generated");
        } else {
            this.tvBookingStatus.setText("This may be due to wrong OTP (one time password)/ 3D secure password entered\nPlease try again with correct details");
            if (TextUtils.isEmpty(paymentBank) || paymentBank.equalsIgnoreCase("NULL") || paymentBank.equalsIgnoreCase("Wallet")) {
                this.tvBookingStatus.setVisibility(8);
                this.viewLine1.setVisibility(8);
                this.viewLinePax.setVisibility(8);
            }
        }
    }

    public void attachBaseContext(Context context) {
        com.travel.citybus.a.a.a(context);
        f.d();
        super.attachBaseContext(f.d().a(context));
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        if (iJRPaytmDataModel2 instanceof CJROrderSummary) {
            this.mOrderSummary = (CJROrderSummary) iJRPaytmDataModel2;
            if (this.mOrderSummary.getOrderedCartList() == null || this.mOrderSummary.getOrderedCartList().size() <= 0) {
                finish();
                return;
            }
            String itemStatus = this.mOrderSummary.getOrderedCartList().get(0).getItemStatus();
            if (itemStatus.equalsIgnoreCase("1") || itemStatus.equalsIgnoreCase("2") || itemStatus.equalsIgnoreCase("5")) {
                if (this.isDirect) {
                    hideProgress(true);
                    if (this.mOrderSummary.getPaymentInfo() == null || this.mOrderSummary.getPaymentInfo().size() <= 0 || this.mOrderSummary.getPaymentInfo().get(0).getPaymentMethod() == null) {
                        ((TextView) findViewById(R.id.payment_pending_text)).setText(getResources().getString(R.string.rupee_symbol) + " " + this.mOrderSummary.getGrandTotal());
                    } else {
                        String paymentBank = this.mOrderSummary.getPaymentInfo().get(0).getPaymentBank();
                        if (!TextUtils.isEmpty(paymentBank) && paymentBank.equalsIgnoreCase(SDKConstants.AI_KEY_WALLET)) {
                            paymentBank = "Paytm Wallet";
                        }
                        String str = "Paytm Payments Bank";
                        if (!TextUtils.isEmpty(paymentBank) && paymentBank.equalsIgnoreCase(SDKConstants.AI_KEY_PPBL)) {
                            paymentBank = str;
                        } else if (!TextUtils.isEmpty(paymentBank)) {
                            String paymentMethod = this.mOrderSummary.getPaymentInfo().get(0).getPaymentMethod();
                            if (!TextUtils.isEmpty(paymentMethod) && paymentMethod.equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                                paymentBank = paymentBank + " Debit Card";
                            } else if (!TextUtils.isEmpty(paymentMethod) && paymentMethod.equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD)) {
                                paymentBank = paymentBank + " Credit Card";
                            } else if (!TextUtils.isEmpty(paymentMethod) && paymentMethod.equalsIgnoreCase("NB")) {
                                paymentBank = paymentBank + " Net Banking";
                            }
                        }
                        if (this.mOrderSummary.getPaymentInfo().size() > 1) {
                            String paymentBank2 = this.mOrderSummary.getPaymentInfo().get(1).getPaymentBank();
                            if (!TextUtils.isEmpty(paymentBank2) && paymentBank2.equalsIgnoreCase(SDKConstants.AI_KEY_WALLET)) {
                                paymentBank2 = "Paytm Wallet";
                            }
                            if (TextUtils.isEmpty(paymentBank2) || !paymentBank2.equalsIgnoreCase(SDKConstants.AI_KEY_PPBL)) {
                                if (!TextUtils.isEmpty(paymentBank2)) {
                                    String paymentMethod2 = this.mOrderSummary.getPaymentInfo().get(1).getPaymentMethod();
                                    if (!TextUtils.isEmpty(paymentMethod2) && paymentMethod2.equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                                        paymentBank2 = paymentBank2 + " Debit Card";
                                    } else if (!TextUtils.isEmpty(paymentMethod2) && paymentMethod2.equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD)) {
                                        paymentBank2 = paymentBank2 + " Credit Card";
                                    } else if (!TextUtils.isEmpty(paymentMethod2) && paymentMethod2.equalsIgnoreCase("NB")) {
                                        paymentBank2 = paymentBank2 + " Net Banking";
                                    }
                                }
                                str = paymentBank;
                            }
                            paymentBank = paymentBank2;
                            if (!TextUtils.isEmpty(paymentBank) && !TextUtils.isEmpty(str)) {
                                paymentBank = str + "  and " + paymentBank;
                            } else if (!TextUtils.isEmpty(str)) {
                                paymentBank = str;
                            }
                        }
                        if (TextUtils.isEmpty(paymentBank) || paymentBank.equalsIgnoreCase("NULL")) {
                            ((TextView) findViewById(R.id.payment_pending_text)).setText(getResources().getString(R.string.rupee_symbol) + " " + this.mOrderSummary.getGrandTotal());
                        } else {
                            ((TextView) findViewById(R.id.payment_pending_text)).setText(getResources().getString(R.string.rupee_symbol) + " " + this.mOrderSummary.getGrandTotal() + " from your " + paymentBank);
                        }
                    }
                    if (this.mHandler == null || this.pendingRetry >= 3) {
                        bookingPendingFailedCase(false);
                        return;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    this.mHandler.sendMessageDelayed(obtain, 2000);
                    this.pendingRetry++;
                    return;
                }
                bookingPendingFailedCase(false);
            } else if (itemStatus.equalsIgnoreCase("7")) {
                setUI(this.mOrderSummary);
            } else {
                bookingPendingFailedCase(true);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Window window2 = this.window;
        if (window2 != null) {
            window2.clearFlags(67108864);
            this.window.clearFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            this.window.clearFlags(128);
        }
        CountDownTimer countDownTimer = this.expiryTimeCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
