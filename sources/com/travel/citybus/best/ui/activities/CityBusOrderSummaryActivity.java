package com.travel.citybus.best.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.travel.cdn.ResourceUtils;
import com.travel.citybus.R;
import com.travel.citybus.best.c.b;
import com.travel.citybus.best.e.d;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import com.travel.citybus.best.model.BestToken;
import com.travel.citybus.brts.CJRActionBarBaseActivity;
import com.travel.citybus.brts.f;
import com.travel.utils.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class CityBusOrderSummaryActivity extends CJRActionBarBaseActivity implements com.travel.citybus.best.b.b {
    public static final a Companion = new a((byte) 0);
    private HashMap _$_findViewCache;
    private int busPurchasedUnit;
    private float busTotalFare;
    private com.travel.citybus.best.c.b cityBusOrderSummaryPresenter;
    /* access modifiers changed from: private */
    public long expiryDate;
    private CountDownTimer expiryTimeCountDownTimer;
    private boolean isActiveTicket;
    private BestEPurse mBestEPurse;
    private String mImageUrl;
    private String mOrderId;

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        setContentView(R.layout.activity_city_bus_order_summary);
        this.cityBusOrderSummaryPresenter = new com.travel.citybus.best.c.b(this);
        getIntentExtras();
        initViews();
        initClickListeners();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusOrderSummaryActivity f23125a;

        b(CityBusOrderSummaryActivity cityBusOrderSummaryActivity) {
            this.f23125a = cityBusOrderSummaryActivity;
        }

        public final void onClick(View view) {
            this.f23125a.finish();
        }
    }

    private final void initClickListeners() {
        ((AppCompatImageView) _$_findCachedViewById(R.id.osBackIv)).setOnClickListener(new b(this));
        ((TextView) _$_findCachedViewById(R.id.osStampContactUsTv)).setOnClickListener(new c(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusOrderSummaryActivity f23126a;

        c(CityBusOrderSummaryActivity cityBusOrderSummaryActivity) {
            this.f23126a = cityBusOrderSummaryActivity;
        }

        public final void onClick(View view) {
            com.paytm.utility.b.a((Context) this.f23126a, "Will be launched soon..!");
        }
    }

    private final void getIntentExtras() {
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        Intent intent = getIntent();
        Boolean bool = null;
        if ((intent != null ? intent.getStringExtra("order_id") : null) != null) {
            Intent intent2 = getIntent();
            this.mOrderId = intent2 != null ? intent2.getStringExtra("order_id") : null;
        }
        Intent intent3 = getIntent();
        if ((intent3 != null ? intent3.getSerializableExtra("validation_success") : null) != null) {
            Intent intent4 = getIntent();
            if ((intent4 != null ? intent4.getSerializableExtra("validation_success") : null) instanceof BestEPurse) {
                Intent intent5 = getIntent();
                this.mBestEPurse = (BestEPurse) (intent5 != null ? intent5.getSerializableExtra("validation_success") : null);
            }
        }
        Intent intent6 = getIntent();
        CharSequence stringExtra = intent6 != null ? intent6.getStringExtra("best_image_logo") : null;
        if (!(stringExtra == null || stringExtra.length() == 0)) {
            Intent intent7 = getIntent();
            this.mImageUrl = (intent7 == null || (extras3 = intent7.getExtras()) == null) ? null : extras3.getString("best_image_logo");
        }
        Intent intent8 = getIntent();
        if (((intent8 == null || (extras2 = intent8.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("is_active_ticket"))) != null) {
            Intent intent9 = getIntent();
            if (!(intent9 == null || (extras = intent9.getExtras()) == null)) {
                bool = Boolean.valueOf(extras.getBoolean("is_active_ticket", false));
            }
            if (bool == null) {
                k.a();
            }
            this.isActiveTicket = bool.booleanValue();
        }
    }

    private final void initViews() {
        if (this.mOrderId != null) {
            com.travel.citybus.best.c.b bVar = this.cityBusOrderSummaryPresenter;
            if (bVar == null) {
                k.a("cityBusOrderSummaryPresenter");
            }
            Context context = this;
            String str = this.mOrderId;
            if (str == null) {
                k.a();
            }
            k.c(context, "context");
            k.c(str, "tokenId");
            k.a((Object) f.d(), "TransportBrtsController.getInstance()");
            String a2 = f.e().a("cityBusTokenUrl");
            if (TextUtils.isEmpty(a2)) {
                a2 = com.travel.citybus.brts.a.m;
            }
            String str2 = a2 + '/' + str;
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            com.travel.citybus.brts.b.a.a();
            com.travel.citybus.brts.b.a.a(context, str2, hashMap, new BestEPurseTokenResponse(), new b.a(bVar));
            toggleProgressView(true);
            return;
        }
        toggleProgressView(false);
        bindData();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getToken();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindData() {
        /*
            r4 = this;
            com.travel.citybus.best.model.BestEPurse r0 = r4.mBestEPurse
            r1 = 0
            if (r0 == 0) goto L_0x0010
            com.travel.citybus.best.model.BestToken r0 = r0.getToken()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getStatus()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            r2 = 1
            java.lang.String r3 = "REFUND"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r0 == 0) goto L_0x0035
            boolean r0 = r4.isActiveTicket
            if (r0 == 0) goto L_0x0027
            com.travel.citybus.best.model.BestEPurse r0 = r4.mBestEPurse
            if (r0 == 0) goto L_0x0030
            com.travel.citybus.best.model.BestToken r0 = r0.getActiveTicket()
            goto L_0x0031
        L_0x0027:
            com.travel.citybus.best.model.BestEPurse r0 = r4.mBestEPurse
            if (r0 == 0) goto L_0x0030
            com.travel.citybus.best.model.BestToken r0 = r0.getToken()
            goto L_0x0031
        L_0x0030:
            r0 = r1
        L_0x0031:
            r4.setRefundTokenOrTicketData(r0)
            goto L_0x004f
        L_0x0035:
            boolean r0 = r4.isActiveTicket
            if (r0 == 0) goto L_0x0042
            com.travel.citybus.best.model.BestEPurse r0 = r4.mBestEPurse
            if (r0 == 0) goto L_0x004b
            com.travel.citybus.best.model.BestToken r0 = r0.getActiveTicket()
            goto L_0x004c
        L_0x0042:
            com.travel.citybus.best.model.BestEPurse r0 = r4.mBestEPurse
            if (r0 == 0) goto L_0x004b
            com.travel.citybus.best.model.BestToken r0 = r0.getToken()
            goto L_0x004c
        L_0x004b:
            r0 = r1
        L_0x004c:
            r4.setSuccessTokenOrTicketData(r0)
        L_0x004f:
            java.lang.String r0 = r4.mImageUrl
            r2 = 0
            if (r0 == 0) goto L_0x005a
            com.paytm.utility.t.a(r2)
            java.lang.String r1 = r4.mImageUrl
            goto L_0x0071
        L_0x005a:
            com.travel.citybus.best.model.BestEPurse r0 = r4.mBestEPurse
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = r0.getLogo()
            goto L_0x0064
        L_0x0063:
            r0 = r1
        L_0x0064:
            if (r0 == 0) goto L_0x007c
            com.paytm.utility.t.a(r2)
            com.travel.citybus.best.model.BestEPurse r0 = r4.mBestEPurse
            if (r0 == 0) goto L_0x0071
            java.lang.String r1 = r0.getLogo()
        L_0x0071:
            int r0 = com.travel.citybus.R.id.ivBestLogo
            android.view.View r0 = r4._$_findCachedViewById(r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            com.paytm.utility.t.b(r1, r0)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.activities.CityBusOrderSummaryActivity.bindData():void");
    }

    private final void setPassengerRouteDetails(BestToken bestToken) {
        BestEPurse bestEPurse = this.mBestEPurse;
        Long l = null;
        CharSequence passNumber = bestEPurse != null ? bestEPurse.getPassNumber() : null;
        boolean z = false;
        if (!(passNumber == null || passNumber.length() == 0)) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.osBookingIdTv);
            k.a((Object) textView, "osBookingIdTv");
            int i2 = R.string.booking_id;
            Object[] objArr = new Object[1];
            BestEPurse bestEPurse2 = this.mBestEPurse;
            objArr[0] = String.valueOf(bestEPurse2 != null ? bestEPurse2.getPassNumber() : null);
            textView.setText(getString(i2, objArr));
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.osBookingIdTv);
            k.a((Object) textView2, "osBookingIdTv");
            textView2.setVisibility(0);
        }
        if ((bestToken != null ? bestToken.getPassengerCount() : null) != null) {
            Integer passengerCount = bestToken != null ? bestToken.getPassengerCount() : null;
            if (passengerCount == null || passengerCount.intValue() != 0) {
                Integer passengerCount2 = bestToken != null ? bestToken.getPassengerCount() : null;
                if (passengerCount2 == null) {
                    k.a();
                }
                this.busPurchasedUnit = passengerCount2.intValue();
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.osPurchasedUnitTv);
                k.a((Object) textView3, "osPurchasedUnitTv");
                textView3.setText(String.valueOf(this.busPurchasedUnit));
            }
        }
        if ((bestToken != null ? bestToken.getAmount() : null) != null) {
            if (!k.a(bestToken != null ? bestToken.getAmount() : null)) {
                Float amount = bestToken != null ? bestToken.getAmount() : null;
                if (amount == null) {
                    k.a();
                }
                this.busTotalFare = amount.floatValue();
                TextView textView4 = (TextView) _$_findCachedViewById(R.id.osTotalFareTv);
                k.a((Object) textView4, "osTotalFareTv");
                textView4.setText("₹ " + com.travel.citybus.best.e.b.a(this.busTotalFare));
                TextView textView5 = (TextView) _$_findCachedViewById(R.id.osBusFareTv);
                k.a((Object) textView5, "osBusFareTv");
                textView5.setText("₹ " + com.travel.citybus.best.e.b.a(this.busTotalFare));
                TextView textView6 = (TextView) _$_findCachedViewById(R.id.osBusFarePerUnitTv);
                k.a((Object) textView6, "osBusFarePerUnitTv");
                textView6.setText("₹ " + com.travel.citybus.best.e.b.a(this.busTotalFare / ((float) this.busPurchasedUnit)));
            }
        }
        if ((bestToken != null ? bestToken.getRouteName() : null) != null) {
            Integer passengerCount3 = bestToken != null ? bestToken.getPassengerCount() : null;
            if (passengerCount3 == null || passengerCount3.intValue() != 0) {
                TextView textView7 = (TextView) _$_findCachedViewById(R.id.osRouteNumberTv);
                k.a((Object) textView7, "osRouteNumberTv");
                textView7.setText(bestToken != null ? bestToken.getRouteName() : null);
            }
        }
        CharSequence sourceName = bestToken != null ? bestToken.getSourceName() : null;
        if (!(sourceName == null || sourceName.length() == 0)) {
            TextView textView8 = (TextView) _$_findCachedViewById(R.id.osSourceNameTv);
            k.a((Object) textView8, "osSourceNameTv");
            textView8.setText(bestToken != null ? bestToken.getSourceName() : null);
        }
        CharSequence destinationName = bestToken != null ? bestToken.getDestinationName() : null;
        if (destinationName == null || destinationName.length() == 0) {
            z = true;
        }
        if (!z) {
            TextView textView9 = (TextView) _$_findCachedViewById(R.id.osDestinationNameTv);
            k.a((Object) textView9, "osDestinationNameTv");
            textView9.setText(bestToken != null ? bestToken.getDestinationName() : null);
        }
        if ((bestToken != null ? bestToken.getTokenIssuanceDatetime() : null) != null) {
            Long tokenIssuanceDatetime = bestToken != null ? bestToken.getTokenIssuanceDatetime() : null;
            if (tokenIssuanceDatetime == null || tokenIssuanceDatetime.longValue() != 0) {
                TextView textView10 = (TextView) _$_findCachedViewById(R.id.osBookingTimeTv);
                k.a((Object) textView10, "osBookingTimeTv");
                com.travel.citybus.best.e.c cVar = com.travel.citybus.best.e.c.f23051a;
                if (bestToken != null) {
                    l = bestToken.getTokenIssuanceDatetime();
                }
                if (l == null) {
                    k.a();
                }
                textView10.setText(com.travel.citybus.best.e.c.a("hh:mm a, dd EEE yyyy", l.longValue()));
            }
        }
    }

    private final void setRefundTokenOrTicketData(BestToken bestToken) {
        ResourceUtils.loadCityBusImagesFromCDN$default((AppCompatImageView) _$_findCachedViewById(R.id.osTicketStatusIv), "booking_failed.png", false, false, (n.a) null, 16, (Object) null);
        ((ConstraintLayout) _$_findCachedViewById(R.id.osSuccessCl)).setBackgroundColor(getResources().getColor(R.color.city_bus_color_failure));
        TextView textView = (TextView) _$_findCachedViewById(R.id.osTicketStatusTv);
        k.a((Object) textView, "osTicketStatusTv");
        textView.setText(getString(R.string.booking_failed));
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.osOtherDetailsLl);
        k.a((Object) linearLayout, "osOtherDetailsLl");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.osExpiryLl);
        k.a((Object) linearLayout2, "osExpiryLl");
        linearLayout2.setVisibility(8);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.osUnableToConfirmTv);
        k.a((Object) textView2, "osUnableToConfirmTv");
        textView2.setVisibility(0);
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.osUnableToConfirmTv);
        k.a((Object) textView3, "osUnableToConfirmTv");
        textView3.setText(getString(R.string.booking_failed_info));
        setPassengerRouteDetails(bestToken);
    }

    private final void setSuccessTokenOrTicketData(BestToken bestToken) {
        ResourceUtils.loadCityBusImagesFromCDN$default((AppCompatImageView) _$_findCachedViewById(R.id.osTicketStatusIv), "ticket_success.png", false, false, (n.a) null, 16, (Object) null);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.osOtherDetailsLl);
        k.a((Object) linearLayout, "osOtherDetailsLl");
        boolean z = false;
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.osExpiryLl);
        k.a((Object) linearLayout2, "osExpiryLl");
        linearLayout2.setVisibility(0);
        TextView textView = (TextView) _$_findCachedViewById(R.id.osUnableToConfirmTv);
        k.a((Object) textView, "osUnableToConfirmTv");
        textView.setVisibility(8);
        setPassengerRouteDetails(bestToken);
        String str = null;
        CharSequence status = bestToken != null ? bestToken.getStatus() : null;
        if (!(status == null || status.length() == 0)) {
            if (p.a(bestToken != null ? bestToken.getStatus() : null, "USED", true)) {
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.osTicketStatusTv);
                k.a((Object) textView2, "osTicketStatusTv");
                int i2 = R.string.purchased;
                Object[] objArr = new Object[2];
                objArr[0] = String.valueOf(this.busPurchasedUnit);
                objArr[1] = getString(this.busPurchasedUnit > 1 ? R.string.tickets : R.string.ticket);
                textView2.setText(getString(i2, objArr));
            }
        }
        if ((bestToken != null ? bestToken.getTokenExpirationDateTime() : null) != null) {
            Long tokenExpirationDateTime = bestToken != null ? bestToken.getTokenExpirationDateTime() : null;
            if (tokenExpirationDateTime == null || tokenExpirationDateTime.longValue() != 0) {
                Long tokenExpirationDateTime2 = bestToken != null ? bestToken.getTokenExpirationDateTime() : null;
                if (tokenExpirationDateTime2 == null) {
                    k.a();
                }
                this.expiryDate = tokenExpirationDateTime2.longValue();
                runExpiryTimer(this.expiryDate - System.currentTimeMillis());
            }
        }
        CharSequence conductorId = bestToken != null ? bestToken.getConductorId() : null;
        if (!(conductorId == null || conductorId.length() == 0)) {
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.osBusConductorIdTv);
            k.a((Object) textView3, "osBusConductorIdTv");
            textView3.setText(bestToken != null ? bestToken.getConductorId() : null);
        }
        CharSequence conductorName = bestToken != null ? bestToken.getConductorName() : null;
        if (!(conductorName == null || conductorName.length() == 0)) {
            TextView textView4 = (TextView) _$_findCachedViewById(R.id.osBusConductorNameTv);
            k.a((Object) textView4, "osBusConductorNameTv");
            textView4.setText(bestToken != null ? bestToken.getConductorName() : null);
        }
        CharSequence ticketId = bestToken != null ? bestToken.getTicketId() : null;
        if (!(ticketId == null || ticketId.length() == 0)) {
            TextView textView5 = (TextView) _$_findCachedViewById(R.id.osTicketIdTv);
            k.a((Object) textView5, "osTicketIdTv");
            textView5.setText(bestToken != null ? bestToken.getTicketId() : null);
        }
        CharSequence validationCode = bestToken != null ? bestToken.getValidationCode() : null;
        if (validationCode == null || validationCode.length() == 0) {
            z = true;
        }
        if (!z) {
            TextView textView6 = (TextView) _$_findCachedViewById(R.id.osValidationCodeTv);
            k.a((Object) textView6, "osValidationCodeTv");
            if (bestToken != null) {
                str = bestToken.getValidationCode();
            }
            textView6.setText(str);
        }
    }

    public static final class d extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusOrderSummaryActivity f23127a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f23128b;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException: -1
            	at jadx.core.dex.visitors.ssa.RenameState.startVar(RenameState.java:58)
            	at jadx.core.dex.visitors.ssa.RenameState.init(RenameState.java:25)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:130)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        d(long r0, long r2, long r4) {
            /*
                r-1 = this;
                r0.f23127a = r1
                r0.f23128b = r2
                r1 = 1000(0x3e8, double:4.94E-321)
                r0.<init>(r4, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.activities.CityBusOrderSummaryActivity.d.<init>(com.travel.citybus.best.ui.activities.CityBusOrderSummaryActivity, long, long):void");
        }

        public final void onTick(long j) {
            if (j / 60000 < 5) {
                ((TextView) this.f23127a._$_findCachedViewById(R.id.osExpiryTimerTv)).setTextColor(this.f23127a.getResources().getColor(R.color.color_timer_out));
            }
            TextView textView = (TextView) this.f23127a._$_findCachedViewById(R.id.osExpiryTimerTv);
            k.a((Object) textView, "osExpiryTimerTv");
            com.travel.citybus.best.e.c cVar = com.travel.citybus.best.e.c.f23051a;
            textView.setText(String.valueOf(com.travel.citybus.best.e.c.a(j)));
        }

        public final void onFinish() {
            ((ConstraintLayout) this.f23127a._$_findCachedViewById(R.id.osSuccessCl)).setBackgroundColor(this.f23127a.getResources().getColor(R.color.color_timer_out));
            ResourceUtils.loadCityBusImagesFromCDN$default((AppCompatImageView) this.f23127a._$_findCachedViewById(R.id.osTicketStatusIv), "ticket_expired.png", false, false, (n.a) null, 16, (Object) null);
            TextView textView = (TextView) this.f23127a._$_findCachedViewById(R.id.osTicketStatusTv);
            k.a((Object) textView, "osTicketStatusTv");
            textView.setText(this.f23127a.getString(R.string.ticket_expired));
            TextView textView2 = (TextView) this.f23127a._$_findCachedViewById(R.id.osBookingTimeTv);
            k.a((Object) textView2, "osBookingTimeTv");
            com.travel.citybus.best.e.c cVar = com.travel.citybus.best.e.c.f23051a;
            textView2.setText(com.travel.citybus.best.e.c.a("hh:mm a, dd EEE yyyy", this.f23127a.expiryDate));
            LinearLayout linearLayout = (LinearLayout) this.f23127a._$_findCachedViewById(R.id.osExpiryLl);
            k.a((Object) linearLayout, "osExpiryLl");
            linearLayout.setVisibility(8);
            View _$_findCachedViewById = this.f23127a._$_findCachedViewById(R.id.viewLine1);
            k.a((Object) _$_findCachedViewById, "viewLine1");
            _$_findCachedViewById.setVisibility(8);
        }
    }

    private final void runExpiryTimer(long j) {
        this.expiryTimeCountDownTimer = new d(this, j, j).start();
    }

    public final void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.expiryTimeCountDownTimer;
        if (countDownTimer != null) {
            if (countDownTimer == null) {
                k.a();
            }
            countDownTimer.cancel();
        }
    }

    private final void toggleProgressView(boolean z) {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.osProgressBar);
        k.a((Object) progressBar, "osProgressBar");
        int i2 = 0;
        progressBar.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.parent_layout);
        k.a((Object) linearLayout, "parent_layout");
        if (z) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    public final void onOrderSummaryReceived(BestEPurse bestEPurse) {
        k.c(bestEPurse, "data");
        toggleProgressView(false);
        this.mBestEPurse = bestEPurse;
        bindData();
    }

    public final void onApiError() {
        toggleProgressView(false);
        d.a aVar = com.travel.citybus.best.e.d.f23053a;
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        String string2 = getString(R.string.brts_some_went_wrong);
        k.a((Object) string2, "getString(R.string.brts_some_went_wrong)");
        d.a.a(this, string, string2);
    }
}
