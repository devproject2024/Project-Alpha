package net.one97.paytm.o2o.events.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.events.CJREventTicketDeliveryAddress;
import net.one97.paytm.common.entity.events.EventsInputForm;
import net.one97.paytm.common.entity.events.EventsTravellerResponseModel;
import net.one97.paytm.o2o.events.R;
import net.one97.paytm.o2o.events.d.a.b.b;

public class CJREventDeliveryView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final b.a f73782a;

    /* renamed from: b  reason: collision with root package name */
    private Context f73783b;

    /* renamed from: c  reason: collision with root package name */
    private EventsTravellerResponseModel f73784c = null;

    /* renamed from: d  reason: collision with root package name */
    private CJREventTicketDeliveryAddress f73785d;

    /* renamed from: e  reason: collision with root package name */
    private String f73786e;

    /* renamed from: f  reason: collision with root package name */
    private int f73787f;

    public static CJREventDeliveryView a(Context context, CJREventTicketDeliveryAddress cJREventTicketDeliveryAddress, int i2, String str, b.a aVar) {
        return new CJREventDeliveryView(context, cJREventTicketDeliveryAddress, i2, str, aVar);
    }

    private CJREventDeliveryView(Context context, CJREventTicketDeliveryAddress cJREventTicketDeliveryAddress, int i2, String str, b.a aVar) {
        super(context);
        this.f73783b = context;
        this.f73787f = i2;
        this.f73785d = cJREventTicketDeliveryAddress;
        this.f73786e = str;
        this.f73782a = aVar;
        inflate(this.f73783b, R.layout.view_event_delivery_options, this);
        StringBuilder sb = new StringBuilder();
        int i3 = this.f73787f;
        if (i3 == 1) {
            sb.append("Delivery to: ");
            sb.append(getUserNameFromUserForm());
            String userDetailsFromUserForm = getUserDetailsFromUserForm();
            findViewById(R.id.events_delivery_option_subheader).setVisibility(8);
            if (!TextUtils.isEmpty(userDetailsFromUserForm)) {
                ((TextView) findViewById(R.id.events_delivery_option_details)).setText(userDetailsFromUserForm);
            } else {
                findViewById(R.id.events_delivery_option_details).setVisibility(8);
            }
        } else if (i3 == 0) {
            sb.append("Pick-up Details");
            String str2 = !TextUtils.isEmpty(this.f73786e) ? this.f73786e : "";
            if (!TextUtils.isEmpty(str2)) {
                ((TextView) findViewById(R.id.events_delivery_option_subheader)).setText(str2);
            } else {
                findViewById(R.id.events_delivery_option_subheader).setVisibility(8);
            }
            findViewById(R.id.events_delivery_option_details).setVisibility(8);
        }
        ((TextView) findViewById(R.id.events_delivery_option_header)).setText(sb.toString());
    }

    public String getUserNameFromUserForm() {
        EventsTravellerResponseModel eventsTravellerResponseModel = this.f73784c;
        String str = "";
        if (eventsTravellerResponseModel == null || eventsTravellerResponseModel.getForm() == null || this.f73784c.getForm().size() <= 0) {
            CJREventTicketDeliveryAddress cJREventTicketDeliveryAddress = this.f73785d;
            if (cJREventTicketDeliveryAddress == null) {
                return str;
            }
            String name = cJREventTicketDeliveryAddress.getName();
            return !(name == null || name.length() == 0) ? this.f73785d.getName() : str;
        }
        Iterator<ArrayList<EventsInputForm>> it2 = this.f73784c.getForm().iterator();
        while (it2.hasNext()) {
            Iterator it3 = it2.next().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                EventsInputForm eventsInputForm = (EventsInputForm) it3.next();
                if (eventsInputForm.getTitle().toLowerCase().contains("full name") && !TextUtils.isEmpty(eventsInputForm.getAppliedData())) {
                    str = eventsInputForm.getAppliedData();
                    break;
                }
            }
        }
        return str;
    }

    public String getUserDetailsFromUserForm() {
        StringBuilder sb = new StringBuilder();
        EventsTravellerResponseModel eventsTravellerResponseModel = this.f73784c;
        if (eventsTravellerResponseModel == null || eventsTravellerResponseModel.getForm() == null || this.f73784c.getForm().size() <= 0) {
            CJREventTicketDeliveryAddress cJREventTicketDeliveryAddress = this.f73785d;
            if (cJREventTicketDeliveryAddress != null) {
                if (!TextUtils.isEmpty(cJREventTicketDeliveryAddress.getAddress1())) {
                    sb.append(this.f73785d.getAddress1());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(this.f73785d.getAddress2())) {
                    sb.append(this.f73785d.getAddress2());
                    sb.append(StringUtility.NEW_LINE);
                }
                if (!TextUtils.isEmpty(this.f73785d.getLandmark())) {
                    sb.append(this.f73785d.getLandmark());
                    sb.append(StringUtility.NEW_LINE);
                }
                if (!TextUtils.isEmpty(this.f73785d.getCity())) {
                    sb.append(this.f73785d.getCity());
                    sb.append(" - ");
                }
                if (!TextUtils.isEmpty(this.f73785d.getPincode())) {
                    sb.append(this.f73785d.getPincode());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(this.f73785d.getState())) {
                    sb.append(this.f73785d.getState());
                    sb.append(StringUtility.NEW_LINE);
                }
                if (!TextUtils.isEmpty(this.f73785d.getMobile())) {
                    sb.append(this.f73785d.getMobile());
                    sb.append(StringUtility.NEW_LINE);
                }
            }
        } else {
            Iterator<ArrayList<EventsInputForm>> it2 = this.f73784c.getForm().iterator();
            String str = "";
            String str2 = str;
            String str3 = str2;
            String str4 = str3;
            String str5 = str4;
            String str6 = str5;
            String str7 = str6;
            while (it2.hasNext()) {
                Iterator it3 = it2.next().iterator();
                while (it3.hasNext()) {
                    EventsInputForm eventsInputForm = (EventsInputForm) it3.next();
                    Iterator<ArrayList<EventsInputForm>> it4 = it2;
                    if (!eventsInputForm.getTitle().toLowerCase().contains("address_1") || eventsInputForm.getTitle().toLowerCase().contains("type") || TextUtils.isEmpty(eventsInputForm.getAppliedData())) {
                        String str8 = str;
                        if (eventsInputForm.getTitle().toLowerCase().contains("address_2") && !eventsInputForm.getTitle().toLowerCase().contains("type") && !TextUtils.isEmpty(eventsInputForm.getAppliedData())) {
                            str2 = str2 + eventsInputForm.getAppliedData();
                        } else if (eventsInputForm.getTitle().toLowerCase().contains(AddEditGstinViewModelKt.BODY_PARAM_LANDMARK) && !TextUtils.isEmpty(eventsInputForm.getAppliedData())) {
                            str3 = eventsInputForm.getAppliedData();
                        } else if (eventsInputForm.getTitle().toLowerCase().contains("city") && !TextUtils.isEmpty(eventsInputForm.getAppliedData())) {
                            str4 = eventsInputForm.getAppliedData();
                        } else if (eventsInputForm.getTitle().toLowerCase().contains(AddEditGstinViewModelKt.BODY_PARAM_PINCODE) && !TextUtils.isEmpty(eventsInputForm.getAppliedData())) {
                            str5 = eventsInputForm.getAppliedData();
                        } else if (eventsInputForm.getTitle().toLowerCase().contains("state") && !TextUtils.isEmpty(eventsInputForm.getAppliedData())) {
                            str6 = eventsInputForm.getAppliedData();
                        } else if (eventsInputForm.getTitle().toLowerCase().contains(ContactColumn.PHONE_NUMBER) || eventsInputForm.getTitle().toLowerCase().contains("contact") || (eventsInputForm.getTitle().toLowerCase().contains("mobile") && !TextUtils.isEmpty(eventsInputForm.getAppliedData()))) {
                            str7 = eventsInputForm.getAppliedData();
                        }
                        it2 = it4;
                        str = str8;
                    } else {
                        str = str + eventsInputForm.getAppliedData() + ", ";
                        it2 = it4;
                    }
                }
                String str9 = str;
            }
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb.append(StringUtility.NEW_LINE);
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str3);
                sb.append(StringUtility.NEW_LINE);
            }
            if (!TextUtils.isEmpty(str4)) {
                sb.append(str4);
                sb.append(" - ");
            }
            if (!TextUtils.isEmpty(str5)) {
                sb.append(str5);
                sb.append(", ");
            }
            if (!TextUtils.isEmpty(str6)) {
                sb.append(str6);
                sb.append(StringUtility.NEW_LINE);
            }
            if (!TextUtils.isEmpty(str7)) {
                sb.append(str7);
            }
        }
        return sb.toString();
    }
}
