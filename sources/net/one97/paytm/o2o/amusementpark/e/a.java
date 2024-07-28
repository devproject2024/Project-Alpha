package net.one97.paytm.o2o.amusementpark.e;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.amPark.AmParkBookingModel;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.o2o.amusementpark.d.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f73598a;

    /* renamed from: b  reason: collision with root package name */
    public b f73599b;

    /* renamed from: c  reason: collision with root package name */
    public AmParkBookingModel f73600c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f73601d;

    /* renamed from: e  reason: collision with root package name */
    public Looper f73602e;

    /* renamed from: f  reason: collision with root package name */
    public C1475a f73603f;

    public final void a(CJRAmParkDateTimeModel.Time time) {
        this.f73600c.setSelectedTime(time);
    }

    public final void a(String str) {
        this.f73600c.setSelectedDate(str);
    }

    public final List<CJRAmParkDateTimeModel.Time> a() {
        String selectedDate;
        Map<String, List<CJRAmParkDateTimeModel.Time>> d2 = d();
        if (d2 == null || d2.size() <= 0 || (selectedDate = this.f73600c.getSelectedDate()) == null) {
            return null;
        }
        return d2.get(selectedDate);
    }

    /* renamed from: net.one97.paytm.o2o.amusementpark.e.a$a  reason: collision with other inner class name */
    public class C1475a extends Handler {
        public C1475a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (a.this.f73599b == null) {
            }
        }
    }

    public a(Context context) {
        this.f73598a = context;
    }

    public final void a(CJRAddressDetailModel cJRAddressDetailModel) {
        this.f73600c.setSelectedAddressModel(cJRAddressDetailModel);
    }

    private Map<String, List<CJRAmParkDateTimeModel.Time>> d() {
        CJRParticularAmParkDescriptionModel eventDescriptionModel = this.f73600c.getEventDescriptionModel();
        if (eventDescriptionModel == null) {
            return null;
        }
        return eventDescriptionModel.getDateToTimeListMap();
    }

    public final Map<String, List<CJRSeatDetailsModel>> b() {
        CJRParticularAmParkDescriptionModel eventDescriptionModel = this.f73600c.getEventDescriptionModel();
        if (eventDescriptionModel == null) {
            return null;
        }
        return eventDescriptionModel.getDateTimeToSeatListMap();
    }

    public final String c() {
        AmParkBookingModel amParkBookingModel = this.f73600c;
        return (amParkBookingModel == null || amParkBookingModel.getEventDescriptionModel() == null || TextUtils.isEmpty(this.f73600c.getEventDescriptionModel().getId())) ? "" : this.f73600c.getEventDescriptionModel().getId();
    }
}
