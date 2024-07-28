package net.one97.paytm.o2o.amusementpark.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.amPark.AmParkBookingModel;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.c.h;
import net.one97.paytm.o2o.amusementpark.c.i;
import net.one97.paytm.o2o.amusementpark.d.a;
import net.one97.paytm.o2o.amusementpark.d.b;
import net.one97.paytm.o2o.amusementpark.d.d;
import net.one97.paytm.o2o.amusementpark.d.j;
import net.one97.paytm.o2o.amusementpark.d.l;
import net.one97.paytm.o2o.amusementpark.d.m;
import net.one97.paytm.o2o.amusementpark.e.a;

public class AJRAmParkBookActivity extends PaytmActivity implements a, b, d, j, l, m {

    /* renamed from: c  reason: collision with root package name */
    private static final String f73293c = AJRAmParkBookActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRAmParkDateTimeModel.Time> f73294a;

    /* renamed from: b  reason: collision with root package name */
    ProgressBar f73295b;

    /* renamed from: d  reason: collision with root package name */
    private final String f73296d = "Book Tickets";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.o2o.amusementpark.e.a f73297e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f73298f = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!AJRAmParkBookActivity.this.isFinishing() && !AJRAmParkBookActivity.this.isDestroyed()) {
                int i2 = message.what;
                if (i2 == 16) {
                    List<CJRAmParkDateTimeModel.Time> a2 = AJRAmParkBookActivity.this.f73297e.a();
                    AJRAmParkBookActivity.this.f73294a.clear();
                    AJRAmParkBookActivity.this.f73294a.addAll(a2);
                    String selectedDate = AJRAmParkBookActivity.this.f73297e.f73600c.getSelectedDate();
                    Map<String, List<CJRSeatDetailsModel>> b2 = AJRAmParkBookActivity.this.f73297e.b();
                    if (a2.size() == 1) {
                        AJRAmParkBookActivity.this.a(a2.get(0));
                    } else {
                        AJRAmParkBookActivity.this.a(a2, selectedDate, b2);
                    }
                } else if (i2 == 19) {
                    AJRAmParkBookActivity aJRAmParkBookActivity = AJRAmParkBookActivity.this;
                    if (aJRAmParkBookActivity.f73295b != null) {
                        aJRAmParkBookActivity.f73295b.setVisibility(0);
                    }
                } else if (i2 != 20) {
                    switch (i2) {
                        case 2:
                            AJRAmParkBookActivity.this.a();
                            return;
                        case 3:
                            AJRAmParkBookActivity.this.getSupportFragmentManager().d();
                            return;
                        case 4:
                            List<CJRAmParkDateTimeModel.Time> a3 = AJRAmParkBookActivity.this.f73297e.a();
                            AJRAmParkBookActivity.this.f73294a.clear();
                            AJRAmParkBookActivity.this.f73294a.addAll(a3);
                            String selectedDate2 = AJRAmParkBookActivity.this.f73297e.f73600c.getSelectedDate();
                            Map<String, List<CJRSeatDetailsModel>> b3 = AJRAmParkBookActivity.this.f73297e.b();
                            if (a3.size() == 1) {
                                AJRAmParkBookActivity.this.a(a3.get(0));
                                return;
                            } else {
                                AJRAmParkBookActivity.this.a(a3, selectedDate2, b3);
                                return;
                            }
                        case 5:
                            AJRAmParkBookActivity.this.j();
                            return;
                        case 6:
                            AJRAmParkBookActivity.this.b(message.getData());
                            return;
                        case 7:
                            AJRAmParkBookActivity.this.onBackPressed();
                            return;
                        case 8:
                            AJRAmParkBookActivity.this.j();
                            return;
                        case 9:
                            AJRAmParkBookActivity.this.a();
                            return;
                        default:
                            return;
                    }
                } else {
                    AJRAmParkBookActivity.this.h();
                }
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private boolean f73299g = false;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f73300h;

    /* renamed from: i  reason: collision with root package name */
    private Toolbar f73301i;
    private RoboTextView j;
    private boolean k;
    private h l;

    public void attachBaseContext(Context context) {
        if (net.one97.paytm.o2o.amusementpark.a.a() == null) {
            new net.one97.paytm.o2o.amusementpark.utils.m();
            net.one97.paytm.o2o.amusementpark.utils.m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(net.one97.paytm.o2o.amusementpark.a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    /* access modifiers changed from: private */
    public void j() {
        CJRAddressDetailModel addressDetail = this.f73297e.f73600c.getAddressDetail();
        if (addressDetail != null && !this.f73299g) {
            a(addressDetail);
        }
    }

    public final void a() {
        ArrayList arrayList;
        List<CJRAmParkDateTimeModel> list;
        if (!this.f73299g) {
            CJRParticularAmParkDescriptionModel eventDescriptionModel = this.f73297e.f73600c.getEventDescriptionModel();
            if (eventDescriptionModel == null || (list = eventDescriptionModel.getmParkDateTimeList()) == null || list.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (CJRAmParkDateTimeModel cJRAmParkDateTimeModel : list) {
                    arrayList.addAll(cJRAmParkDateTimeModel.getmParkDateList());
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("event-date-list", new ArrayList(arrayList));
                bundle.putString("title", this.f73297e.f73600c.getEventDescriptionModel().getName());
                if (this.f73297e.f73600c.getEventDescriptionModel().getCategories() != null && this.f73297e.f73600c.getEventDescriptionModel().getCategories().size() > 0) {
                    bundle.putString("category", this.f73297e.f73600c.getEventDescriptionModel().getCategories().get(0).getCategory());
                }
                bundle.putString("park_id", this.f73297e.c());
                net.one97.paytm.o2o.amusementpark.c.a aVar = new net.one97.paytm.o2o.amusementpark.c.a();
                aVar.setArguments(bundle);
                getSupportFragmentManager().a().b(R.id.event_home_frame_layout, aVar, (String) null).c();
            }
        }
    }

    public final void a(List<CJRAmParkDateTimeModel.Time> list, String str, Map<String, List<CJRSeatDetailsModel>> map) {
        if (list == null || list.size() < 0 || TextUtils.isEmpty(str) || map == null) {
            if (this.k) {
                this.f73298f.sendEmptyMessage(16);
            } else {
                this.f73298f.sendEmptyMessage(4);
            }
        } else if (!this.f73299g) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("event-time-slot-list", new ArrayList(list));
            bundle.putSerializable("event-time-slot-map", new HashMap(map));
            bundle.putSerializable("event-bundle-key-date", str);
            bundle.putString("title", this.f73297e.f73600c.getEventDescriptionModel().getName());
            bundle.putString("park_id", this.f73297e.c());
            if (this.f73297e.f73600c.getEventDescriptionModel().getCategories() != null && this.f73297e.f73600c.getEventDescriptionModel().getCategories().size() > 0) {
                bundle.putString("category", this.f73297e.f73600c.getEventDescriptionModel().getCategories().get(0).getCategory());
            }
            i iVar = new i();
            iVar.setArguments(bundle);
            getSupportFragmentManager().a().b(R.id.event_home_frame_layout, iVar, (String) null).c();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            super.onRestoreInstanceState(bundle);
        }
        this.f73299g = false;
    }

    public void onResume() {
        super.onResume();
        h hVar = this.l;
        if (hVar != null) {
            hVar.f73582f = false;
        }
        this.f73299g = false;
    }

    /* access modifiers changed from: private */
    public void b(Bundle bundle) {
        boolean z;
        CJRParticularAmParkDescriptionModel eventDescriptionModel;
        Map<String, List<CJRAmParkDateTimeModel.Time>> dateToTimeListMap;
        Set<String> keySet;
        if (!this.f73299g) {
            this.l = new h();
            net.one97.paytm.o2o.amusementpark.e.a aVar = this.f73297e;
            if (aVar.f73600c.getEventDescriptionModel() == null || (eventDescriptionModel = aVar.f73600c.getEventDescriptionModel()) == null || (dateToTimeListMap = eventDescriptionModel.getDateToTimeListMap()) == null || (keySet = dateToTimeListMap.keySet()) == null || keySet.size() != 1) {
                z = false;
            } else {
                z = false;
                for (String next : keySet) {
                    List list = dateToTimeListMap.get(next);
                    if (list != null && list.size() == 1) {
                        aVar.a(eventDescriptionModel.getmAddress());
                        aVar.a(next);
                        aVar.a((CJRAmParkDateTimeModel.Time) list.get(0));
                        z = true;
                    }
                }
            }
            if (bundle == null && z) {
                bundle = k();
                bundle.putBoolean("is-single-venue-and-date-and-time", true);
            }
            h hVar = this.l;
            if (hVar != null) {
                if (bundle != null) {
                    hVar.setArguments(bundle);
                }
                h hVar2 = this.l;
                hVar2.f73584h = false;
                hVar2.a(this.f73297e.f73600c.getEventDescriptionModel());
                getSupportFragmentManager().a().b(R.id.event_home_frame_layout, this.l, (String) null).c();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.park_home_page);
        if (this.f73297e == null) {
            this.f73297e = new net.one97.paytm.o2o.amusementpark.e.a(getApplicationContext());
        }
        net.one97.paytm.o2o.amusementpark.e.a aVar = this.f73297e;
        aVar.f73599b = this;
        aVar.f73600c = new AmParkBookingModel();
        aVar.f73601d = new HandlerThread(aVar.getClass().getSimpleName());
        aVar.f73601d.start();
        aVar.f73602e = aVar.f73601d.getLooper();
        aVar.f73603f = new a.C1475a(aVar.f73602e);
        net.one97.paytm.o2o.amusementpark.e.a aVar2 = this.f73297e;
        Intent intent = getIntent();
        if (intent != null) {
            CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel = (CJRParticularAmParkDescriptionModel) intent.getSerializableExtra("event-address-list");
            CJRAddressDetailModel cJRAddressDetailModel = null;
            if (cJRParticularAmParkDescriptionModel != null) {
                cJRAddressDetailModel = cJRParticularAmParkDescriptionModel.getmAddress();
                aVar2.f73600c.setEventDescriptionModel(cJRParticularAmParkDescriptionModel);
            }
            if (cJRAddressDetailModel != null) {
                aVar2.f73600c.setAddressDetail(cJRAddressDetailModel);
            }
        }
        this.f73294a = new ArrayList<>();
        this.f73295b = (ProgressBar) findViewById(R.id.park_home_progress_bar);
        this.f73300h = (ImageView) findViewById(R.id.back_arrow);
        this.f73301i = (Toolbar) findViewById(R.id.search_toolabar);
        this.j = (RoboTextView) findViewById(R.id.top_title);
        this.j.setText("Book Tickets");
        this.f73300h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRAmParkBookActivity.this.onBackPressed();
            }
        });
        this.k = true;
        j();
    }

    public void onDestroy() {
        super.onDestroy();
        net.one97.paytm.o2o.amusementpark.e.a aVar = this.f73297e;
        if (aVar != null) {
            aVar.f73598a = null;
            aVar.f73599b = null;
            aVar.f73600c = null;
            aVar.f73601d.quit();
            aVar.f73602e = null;
            aVar.f73603f = null;
            this.f73297e = null;
        }
        h();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f73299g = true;
    }

    public final void b() {
        ImageView imageView = this.f73300h;
        if (imageView != null) {
            imageView.setImageResource(net.one97.paytm.common.assets.R.drawable.back_arrow);
        }
        RoboTextView roboTextView = this.j;
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.event_select_venue));
        }
    }

    public final void c() {
        ImageView imageView = this.f73300h;
        if (imageView != null) {
            imageView.setImageResource(net.one97.paytm.common.assets.R.drawable.back_arrow);
        }
        RoboTextView roboTextView = this.j;
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.event_select_date));
        }
    }

    public final void d() {
        ImageView imageView = this.f73300h;
        if (imageView != null) {
            imageView.setImageResource(net.one97.paytm.common.assets.R.drawable.back_arrow);
        }
        RoboTextView roboTextView = this.j;
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.event_select_time));
        }
    }

    public final void e() {
        ImageView imageView = this.f73300h;
        if (imageView != null) {
            imageView.setImageResource(net.one97.paytm.common.assets.R.drawable.back_arrow);
        }
        RoboTextView roboTextView = this.j;
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.event_title_book_tickets));
        }
    }

    public final void a(CJRAddressDetailModel cJRAddressDetailModel) {
        "selected venue id is ".concat(String.valueOf(cJRAddressDetailModel));
        com.paytm.utility.b.j();
        this.f73297e.a(cJRAddressDetailModel);
        if (this.k) {
            this.f73298f.sendEmptyMessage(9);
        } else {
            this.f73298f.sendEmptyMessage(2);
        }
    }

    public final void a(String str) {
        "selected date is ".concat(String.valueOf(str));
        com.paytm.utility.b.j();
        net.one97.paytm.o2o.amusementpark.e.a aVar = this.f73297e;
        if (aVar != null) {
            aVar.a(str);
        }
        if (this.k) {
            this.f73298f.sendEmptyMessage(16);
        } else {
            this.f73298f.sendEmptyMessage(4);
        }
    }

    public void onBackPressed() {
        int f2 = getSupportFragmentManager().f();
        h hVar = this.l;
        if (hVar != null && hVar.f73585i) {
            this.l.k();
        } else if (f2 == 0) {
            h();
            super.onBackPressed();
        } else {
            getSupportFragmentManager().d();
        }
    }

    public final void a(CJRAmParkDateTimeModel.Time time) {
        "selected time id is ".concat(String.valueOf(time));
        com.paytm.utility.b.j();
        StringBuilder sb = new StringBuilder("selected time id is ");
        sb.append(time.getmStart());
        sb.append(" : ");
        sb.append(time.getmTo());
        com.paytm.utility.b.j();
        net.one97.paytm.o2o.amusementpark.e.a aVar = this.f73297e;
        if (aVar != null) {
            aVar.a(time);
        }
        if (this.k) {
            Bundle k2 = k();
            h hVar = this.l;
            if (hVar != null) {
                String str = hVar.f73578b;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                if (!str.equals(k2.getString("event-seat-selection-fragment-key-date")) || (this.l.f73579c != null && !this.l.f73579c.equals(k2.getSerializable("event-seat-selection-fragment-key-time-model")))) {
                    this.l.f73584h = true;
                } else {
                    this.l.f73584h = false;
                }
                h hVar2 = this.l;
                hVar2.f73580d = true;
                hVar2.f73581e = k2;
                getSupportFragmentManager().a().b(R.id.event_home_frame_layout, this.l, (String) null).c();
                return;
            }
            b(k2);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.setData(k());
        this.f73298f.sendMessage(obtain);
    }

    private Bundle k() {
        List list;
        if (this.f73297e == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        CJRParticularAmParkDescriptionModel eventDescriptionModel = this.f73297e.f73600c.getEventDescriptionModel();
        if (eventDescriptionModel != null) {
            bundle.putSerializable("event-address-list", eventDescriptionModel);
        }
        CJRAmParkDateTimeModel.Time selectedTime = this.f73297e.f73600c.getSelectedTime();
        String selectedDate = this.f73297e.f73600c.getSelectedDate();
        CJRAddressDetailModel selectedAddressModel = this.f73297e.f73600c.getSelectedAddressModel();
        if (selectedAddressModel != null) {
            bundle.putSerializable("event-seat-selection-fragment-key-venue-model", selectedAddressModel);
        }
        if (selectedDate != null) {
            bundle.putString("event-seat-selection-fragment-key-date", selectedDate);
        }
        if (selectedTime != null) {
            bundle.putSerializable("event-seat-selection-fragment-key-time-model", selectedTime);
        }
        Map<String, List<CJRSeatDetailsModel>> b2 = this.f73297e.b();
        String str = selectedDate + selectedTime.getmStart() + selectedTime.getmTo();
        if (b2 == null || b2.size() <= 0 || this.f73297e.f73600c.getSelectedDate() == null || str == null || (list = b2.get(str)) == null) {
            return bundle;
        }
        bundle.putSerializable("event-seat-selection-fragment-key-seat-list", new ArrayList(list));
        return bundle;
    }

    public final void f() {
        this.k = true;
        Handler handler = this.f73298f;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
    }

    public final void g() {
        this.k = true;
        Handler handler = this.f73298f;
        if (handler != null) {
            handler.sendEmptyMessage(4);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        h hVar;
        if (i3 != -1) {
            return;
        }
        if (i2 == 257) {
            h hVar2 = this.l;
            if (hVar2 != null) {
                hVar2.a(i2);
            }
        } else if (i2 == 18) {
            if (this.l != null && intent != null) {
                Bundle extras = intent.getExtras();
                Boolean valueOf = Boolean.valueOf(extras.getBoolean("AmPark_BACK_CLICK"));
                this.l.f73583g = valueOf.booleanValue();
                this.l.a((AmParkTravellerResponseModel) extras.getSerializable("traveller-details"));
            }
        } else if (i2 == 258 && (hVar = this.l) != null) {
            hVar.a(i2);
        }
    }

    public final void a(int i2) {
        startActivityForResult(new Intent(this, net.one97.paytm.o2o.amusementpark.a.a().getLoginActivity()), i2);
    }

    public final void a(CJRRechargePayment cJRRechargePayment, String str) {
        if (cJRRechargePayment == null) {
            Toast.makeText(this, R.string.error_something_went_wrong, 0).show();
            return;
        }
        Intent intent = new Intent(this, net.one97.paytm.o2o.amusementpark.a.a().getPaymentActivity());
        if (!TextUtils.isEmpty(cJRRechargePayment.getmTxnToken())) {
            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
            intent.putExtra("mid", cJRRechargePayment.getMID());
            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
            intent.putExtra("nativeSdkEnabled", true);
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(this, R.string.error_in_payment, 0).show();
                return;
            }
            intent.putExtra("price", str);
        } else {
            intent.putExtra("nativeSdkEnabled", false);
        }
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("IS_FROM_AMPARK", true);
        startActivity(intent);
    }

    public final void a(Bundle bundle) {
        Intent intent = new Intent(getApplicationContext(), AJRAmParkTravellerDetailsActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 18);
    }

    /* access modifiers changed from: protected */
    public final void h() {
        ProgressBar progressBar = this.f73295b;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public final void b(String str) {
        Message obtain = Message.obtain();
        obtain.what = 19;
        obtain.obj = str;
        this.f73298f.sendMessage(obtain);
    }

    public final void i() {
        this.f73298f.sendEmptyMessage(20);
    }

    public final void a(boolean z) {
        if (z) {
            this.f73301i.setVisibility(8);
        } else {
            this.f73301i.setVisibility(0);
        }
    }

    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
    }
}
