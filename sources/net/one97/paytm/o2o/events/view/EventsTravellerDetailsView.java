package net.one97.paytm.o2o.events.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.events.EventsInputForm;
import net.one97.paytm.common.entity.events.EventsTravellerResponseModel;
import net.one97.paytm.o2o.events.R;

public class EventsTravellerDetailsView extends RelativeLayout implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f73812a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f73813b;

    /* renamed from: c  reason: collision with root package name */
    private int f73814c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f73815d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f73816e = false;

    /* renamed from: f  reason: collision with root package name */
    private EventsTravellerResponseModel f73817f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f73818g;

    /* renamed from: h  reason: collision with root package name */
    private LayoutInflater f73819h;

    /* renamed from: i  reason: collision with root package name */
    private Button f73820i;
    /* access modifiers changed from: private */
    public a j;
    /* access modifiers changed from: private */
    public EditText k;
    private String l;
    private String m;
    private String n;
    private boolean o;

    public interface a {
        void b(EventsTravellerResponseModel eventsTravellerResponseModel);

        void c();
    }

    public static EventsTravellerDetailsView a(Activity activity, Bundle bundle, a aVar) {
        return new EventsTravellerDetailsView(activity, bundle, aVar);
    }

    private EventsTravellerDetailsView(Activity activity, Bundle bundle, a aVar) {
        super(activity);
        this.f73812a = activity;
        this.j = aVar;
        if (b.r(this.f73812a)) {
            this.l = b.j(this.f73812a);
            this.m = b.m(this.f73812a);
            this.n = b.l(this.f73812a);
        }
        if (bundle != null) {
            this.f73814c = bundle.getInt("traveller-num-of-passenger", 0);
            this.f73813b = bundle.getBoolean("traveller-is-static-form", true);
            if (this.f73813b) {
                this.f73814c = 1;
            }
            this.f73817f = (EventsTravellerResponseModel) bundle.getSerializable("traveller-details");
        }
        setHideContinueButton(true);
        inflate(this.f73812a, R.layout.events_booking_traveller_layout, this);
        this.f73819h = LayoutInflater.from(this.f73812a);
        this.f73818g = (LinearLayout) findViewById(R.id.events_booking_traveller_container);
        this.f73818g.setOrientation(1);
        this.f73818g.removeAllViews();
        if (this.f73813b) {
            if (this.f73814c > 1) {
                d();
            } else {
                View inflate = this.f73819h.inflate(R.layout.events_booking_traveller_form_title, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.events_passenger_title_single)).setVisibility(0);
                ((ImageView) inflate.findViewById(R.id.events_maximized_image_button)).setVisibility(8);
                this.f73818g.addView(inflate);
                View inflate2 = this.f73819h.inflate(R.layout.events_booking_traveller_single_passenger_static_form, (ViewGroup) null);
                ArrayList arrayList = new ArrayList();
                EventsTravellerResponseModel eventsTravellerResponseModel = this.f73817f;
                if (eventsTravellerResponseModel != null) {
                    if (eventsTravellerResponseModel.getForm() == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(arrayList);
                        this.f73817f.setForm(arrayList2);
                    } else if (this.f73817f.getForm().size() > 0) {
                        arrayList = this.f73817f.getForm().get(0);
                    } else {
                        this.f73817f.getForm().add(arrayList);
                    }
                }
                a(inflate2, (ArrayList<EventsInputForm>) arrayList);
                this.f73818g.addView(inflate2);
                View inflate3 = this.f73819h.inflate(R.layout.events_booking_traveller_form_button, (ViewGroup) null);
                this.f73820i = (Button) inflate3.findViewById(R.id.events_single_traveller_form_continue_button);
                this.f73820i.setOnClickListener(this);
                this.f73818g.addView(inflate3);
            }
        } else if (this.f73814c > 1) {
            e();
        } else {
            c();
        }
        b();
        if (this.o) {
            this.f73820i.setVisibility(8);
        }
    }

    private void b() {
        try {
            LinearLayout linearLayout = (LinearLayout) this.f73820i.getParent().getParent();
            for (int childCount = linearLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                if (!(childCount == 0 || childCount == linearLayout.getChildCount() - 1)) {
                    View childAt = linearLayout.getChildAt(childCount);
                    if (childAt instanceof LinearLayout) {
                        LinearLayout linearLayout2 = (LinearLayout) childAt;
                        EventsInputForm eventsInputForm = (EventsInputForm) linearLayout2.getTag();
                        if (eventsInputForm != null && ((eventsInputForm.getType().equalsIgnoreCase("textbox") || eventsInputForm.getType().equalsIgnoreCase("calendar")) && (linearLayout2.getChildAt(0) instanceof TextInputLayout))) {
                            ((TextInputLayout) linearLayout2.getChildAt(0)).getEditText().setImeOptions(6);
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e2) {
            EventsTravellerDetailsView.class.getSimpleName();
            q.b(e2.getMessage());
        }
    }

    private void c() {
        ArrayList<ArrayList<EventsInputForm>> form;
        View inflate = this.f73819h.inflate(R.layout.events_booking_traveller_form_title, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.events_passenger_title_single);
        textView.setVisibility(0);
        EventsTravellerResponseModel eventsTravellerResponseModel = this.f73817f;
        if (!(eventsTravellerResponseModel == null || eventsTravellerResponseModel.getForm() == null || this.f73817f.getForm().get(0) == null || this.f73817f.getForm().get(0).get(0) == null)) {
            String title = ((EventsInputForm) this.f73817f.getForm().get(0).get(0)).getTitle();
            if (!TextUtils.isEmpty(title)) {
                textView.setText(title);
            }
        }
        ((ImageView) inflate.findViewById(R.id.events_maximized_image_button)).setVisibility(8);
        this.f73818g.addView(inflate);
        EventsTravellerResponseModel eventsTravellerResponseModel2 = this.f73817f;
        if (eventsTravellerResponseModel2 != null && (form = eventsTravellerResponseModel2.getForm()) != null && form.size() > 0) {
            Iterator<ArrayList<EventsInputForm>> it2 = form.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                List next = it2.next();
                i2++;
                if (i2 > 1) {
                    break;
                } else if (next != null && next.size() > 0) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < next.size(); i4++) {
                        if (!((EventsInputForm) next.get(i4)).getId().contains("Pincode")) {
                            a((EventsInputForm) next.get(i4), i3);
                            i3++;
                        }
                    }
                }
            }
        }
        View inflate2 = this.f73819h.inflate(R.layout.events_booking_traveller_form_button, (ViewGroup) null);
        this.f73820i = (Button) inflate2.findViewById(R.id.events_single_traveller_form_continue_button);
        this.f73820i.setOnClickListener(this);
        this.f73818g.addView(inflate2);
    }

    private void d() {
        EventsTravellerResponseModel eventsTravellerResponseModel = this.f73817f;
        if (eventsTravellerResponseModel != null) {
            if (eventsTravellerResponseModel != null && eventsTravellerResponseModel.getForm() == null) {
                this.f73817f.setForm(new ArrayList());
            }
            if (this.f73817f.getForm().size() == 0) {
                for (int i2 = 0; i2 < this.f73814c; i2++) {
                    this.f73817f.getForm().add(new ArrayList());
                }
            }
            int i3 = 0;
            while (i3 < this.f73814c) {
                View inflate = this.f73819h.inflate(R.layout.events_booking_traveller_form_title, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.events_passenger_title_multiple);
                textView.setVisibility(0);
                int i4 = i3 + 1;
                textView.setText(getContext().getString(R.string.events_traveller_details_title, new Object[]{Integer.valueOf(i4)}));
                this.f73818g.addView(inflate);
                View inflate2 = this.f73819h.inflate(R.layout.events_booking_traveller_single_passenger_static_form, (ViewGroup) null);
                a(inflate2, this.f73817f.getForm().get(i3));
                this.f73818g.addView(inflate2);
                i3 = i4;
            }
            View inflate3 = this.f73819h.inflate(R.layout.events_booking_traveller_form_button, (ViewGroup) null);
            this.f73820i = (Button) inflate3.findViewById(R.id.events_single_traveller_form_continue_button);
            this.f73820i.setOnClickListener(this);
            this.f73818g.addView(inflate3);
        }
    }

    private void a(View view, ArrayList<EventsInputForm> arrayList) {
        final EditText editText = (EditText) view.findViewById(R.id.events_passenger_first_name_textview);
        final EventsInputForm eventsInputForm = arrayList.size() > 0 ? arrayList.get(0) : new EventsInputForm();
        eventsInputForm.setTitle("First Name");
        eventsInputForm.setRegex("[A-Za-z\\s]+");
        editText.setText(eventsInputForm.getAppliedData());
        editText.setTag(eventsInputForm);
        arrayList.add(eventsInputForm);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    eventsInputForm.setApplied(trim);
                }
                if (z) {
                    EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText);
                }
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText);
            }
        });
        final EditText editText2 = (EditText) view.findViewById(R.id.events_passenger_last_name_textview);
        final EventsInputForm eventsInputForm2 = arrayList.size() > 1 ? arrayList.get(1) : new EventsInputForm();
        eventsInputForm2.setTitle("Last Name");
        eventsInputForm2.setRegex("[A-Za-z\\s]+");
        editText2.setText(eventsInputForm2.getAppliedData());
        editText2.setTag(eventsInputForm2);
        arrayList.add(eventsInputForm2);
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText2.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    eventsInputForm2.setApplied(trim);
                }
                if (z) {
                    EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText2);
                }
            }
        });
        editText2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText2);
            }
        });
        final EditText editText3 = (EditText) view.findViewById(R.id.events_passenger_age_textview);
        final EventsInputForm eventsInputForm3 = null;
        final EventsInputForm eventsInputForm4 = arrayList.size() > 2 ? arrayList.get(2) : null;
        if (eventsInputForm4 == null) {
            eventsInputForm4 = new EventsInputForm();
        }
        eventsInputForm4.setTitle("Age");
        editText3.setText(eventsInputForm4.getAppliedData());
        editText3.setTag(eventsInputForm4);
        arrayList.add(eventsInputForm4);
        editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText3.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    eventsInputForm4.setApplied(trim);
                }
                if (z) {
                    EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText3);
                }
            }
        });
        editText3.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText3);
            }
        });
        final EditText editText4 = (EditText) view.findViewById(R.id.events_passenger_mobile_number_textview);
        final EventsInputForm eventsInputForm5 = arrayList.size() > 3 ? arrayList.get(3) : null;
        if (eventsInputForm5 == null) {
            eventsInputForm5 = new EventsInputForm();
        }
        eventsInputForm5.setTitle("Mobile Number");
        eventsInputForm5.setRegex("^[7-9][0-9]{9}$");
        editText4.setText(eventsInputForm5.getAppliedData());
        editText4.setTag(eventsInputForm5);
        arrayList.add(eventsInputForm5);
        editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText4.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    eventsInputForm5.setApplied(trim);
                }
                if (z) {
                    EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText4);
                }
            }
        });
        editText4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText4);
            }
        });
        final EditText editText5 = (EditText) view.findViewById(R.id.events_passenger_email_id_textview);
        final EventsInputForm eventsInputForm6 = arrayList.size() > 4 ? arrayList.get(4) : null;
        if (eventsInputForm6 == null) {
            eventsInputForm6 = new EventsInputForm();
        }
        eventsInputForm6.setTitle("EmailID");
        eventsInputForm6.setRegex("^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$");
        editText5.setText(eventsInputForm6.getAppliedData());
        editText5.setTag(eventsInputForm6);
        arrayList.add(eventsInputForm6);
        editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText5.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    eventsInputForm6.setApplied(trim);
                }
                if (z) {
                    EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText5);
                }
            }
        });
        editText5.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText5);
            }
        });
        final EditText editText6 = (EditText) view.findViewById(R.id.events_passenger_pincode_textview);
        final EventsInputForm eventsInputForm7 = arrayList.size() > 5 ? arrayList.get(5) : null;
        if (eventsInputForm7 == null) {
            eventsInputForm7 = new EventsInputForm();
        }
        eventsInputForm7.setTitle("Pin Code");
        eventsInputForm7.setRegex("^[1-9][0-9]{5}");
        editText6.setText(eventsInputForm7.getAppliedData());
        editText6.setTag(eventsInputForm7);
        arrayList.add(eventsInputForm7);
        editText6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText6.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    eventsInputForm7.setApplied(trim);
                }
                if (z) {
                    EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText6);
                }
            }
        });
        editText6.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText6);
            }
        });
        final EditText editText7 = (EditText) view.findViewById(R.id.events_passenger_city_textview);
        if (arrayList.size() > 6) {
            eventsInputForm3 = arrayList.get(6);
        }
        if (eventsInputForm3 == null) {
            eventsInputForm3 = new EventsInputForm();
        }
        eventsInputForm3.setTitle("City");
        eventsInputForm3.setRegex("[A-Za-z\\s]+");
        editText7.setText(eventsInputForm3.getAppliedData());
        editText7.setTag(eventsInputForm3);
        arrayList.add(eventsInputForm3);
        editText7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText7.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    eventsInputForm3.setApplied(trim);
                }
                if (z) {
                    EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText7);
                }
            }
        });
        editText7.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EventsTravellerDetailsView.a(EventsTravellerDetailsView.this, editText7);
            }
        });
        editText7.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i2 != 66) {
                    return false;
                }
                EventsTravellerDetailsView.this.a();
                return true;
            }
        });
    }

    private void e() {
        ArrayList<ArrayList<EventsInputForm>> form;
        EventsTravellerResponseModel eventsTravellerResponseModel = this.f73817f;
        if (!(eventsTravellerResponseModel == null || (form = eventsTravellerResponseModel.getForm()) == null || form.size() <= 0)) {
            Iterator<ArrayList<EventsInputForm>> it2 = form.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it2.hasNext()) {
                List next = it2.next();
                View inflate = this.f73819h.inflate(R.layout.events_booking_traveller_form_title, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.events_passenger_title_multiple);
                textView.setVisibility(0);
                String title = ((EventsInputForm) next.get(0)).getTitle();
                if (!TextUtils.isEmpty(title)) {
                    textView.setText(title);
                } else {
                    i2++;
                    textView.setText(getContext().getString(R.string.events_traveller_details_title, new Object[]{Integer.valueOf(i2)}));
                }
                this.f73818g.addView(inflate);
                if (next != null && next.size() > 0) {
                    int i4 = i3;
                    for (int i5 = 0; i5 < next.size(); i5++) {
                        a((EventsInputForm) next.get(i5), i4);
                        i4++;
                    }
                    i3 = i4;
                }
            }
        }
        View inflate2 = this.f73819h.inflate(R.layout.events_booking_traveller_form_button, (ViewGroup) null);
        this.f73820i = (Button) inflate2.findViewById(R.id.events_single_traveller_form_continue_button);
        this.f73820i.setOnClickListener(this);
        this.f73818g.addView(inflate2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x032d A[Catch:{ Exception -> 0x0336 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final net.one97.paytm.common.entity.events.EventsInputForm r12, int r13) {
        /*
            r11 = this;
            android.widget.LinearLayout r0 = r11.f73818g
            if (r0 == 0) goto L_0x0351
            if (r12 != 0) goto L_0x0008
            goto L_0x0351
        L_0x0008:
            java.lang.String r0 = r12.getType()     // Catch:{ Exception -> 0x0336 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r1 == 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r1 = "textbox"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0336 }
            r2 = 1096810496(0x41600000, float:14.0)
            java.lang.String r3 = "calendar"
            r4 = 5
            r5 = 1
            r6 = 0
            r7 = 0
            if (r1 != 0) goto L_0x0237
            boolean r1 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0336 }
            if (r1 == 0) goto L_0x002c
            goto L_0x0237
        L_0x002c:
            java.lang.String r13 = "dropdown"
            boolean r13 = r0.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0336 }
            if (r13 == 0) goto L_0x00a2
            android.view.LayoutInflater r13 = r11.f73819h     // Catch:{ Exception -> 0x0336 }
            int r0 = net.one97.paytm.o2o.events.R.layout.events_booking_traveller_form_dropdown     // Catch:{ Exception -> 0x0336 }
            android.view.View r6 = r13.inflate(r0, r6)     // Catch:{ Exception -> 0x0336 }
            int r13 = net.one97.paytm.o2o.events.R.id.events_traveller_dropdown     // Catch:{ Exception -> 0x0336 }
            android.view.View r13 = r6.findViewById(r13)     // Catch:{ Exception -> 0x0336 }
            android.widget.Spinner r13 = (android.widget.Spinner) r13     // Catch:{ Exception -> 0x0336 }
            java.util.List r0 = r12.getDropDownListValues()     // Catch:{ Exception -> 0x0336 }
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x0336 }
            android.content.Context r2 = r11.getContext()     // Catch:{ Exception -> 0x0336 }
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r2, r3, r0)     // Catch:{ Exception -> 0x0336 }
            r2 = 17367049(0x1090009, float:2.516295E-38)
            r1.setDropDownViewResource(r2)     // Catch:{ Exception -> 0x0336 }
            r13.setAdapter(r1)     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x0079
            int r1 = r0.size()     // Catch:{ Exception -> 0x0336 }
            if (r1 <= 0) goto L_0x0079
            java.lang.String r1 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0336 }
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r0.get(r7)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0336 }
            r12.setApplied(r1)     // Catch:{ Exception -> 0x0336 }
            goto L_0x0098
        L_0x0079:
            java.lang.String r1 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0336 }
            if (r1 != 0) goto L_0x0098
            java.lang.String r1 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0336 }
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            int r1 = r0.indexOf(r1)     // Catch:{ Exception -> 0x0336 }
            r13.setSelection(r1)     // Catch:{ Exception -> 0x0336 }
        L_0x0098:
            net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$11 r1 = new net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$11     // Catch:{ Exception -> 0x0336 }
            r1.<init>(r12, r0)     // Catch:{ Exception -> 0x0336 }
            r13.setOnItemSelectedListener(r1)     // Catch:{ Exception -> 0x0336 }
            goto L_0x032b
        L_0x00a2:
            java.lang.String r13 = "checkbox"
            boolean r13 = r0.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0336 }
            r1 = -2
            r3 = -1
            if (r13 == 0) goto L_0x013c
            java.util.List r13 = r12.getCheckBoxListValues()     // Catch:{ Exception -> 0x0336 }
            if (r13 == 0) goto L_0x013b
            int r0 = r13.size()     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x00ba
            goto L_0x013b
        L_0x00ba:
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0336 }
            r0.<init>(r3, r1)     // Catch:{ Exception -> 0x0336 }
            r1 = 24
            r0.setMargins(r1, r4, r1, r4)     // Catch:{ Exception -> 0x0336 }
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x0336 }
            android.content.Context r2 = r11.getContext()     // Catch:{ Exception -> 0x0336 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0336 }
            r2 = r1
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0336 }
            r2.setOrientation(r5)     // Catch:{ Exception -> 0x0336 }
            r1.setLayoutParams(r0)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x010c
            android.widget.TextView r0 = new android.widget.TextView     // Catch:{ Exception -> 0x0336 }
            android.content.Context r2 = r11.f73812a     // Catch:{ Exception -> 0x0336 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r2 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0336 }
            r0.setTypeface(r6, r7)     // Catch:{ Exception -> 0x0336 }
            r2 = 10
            r0.setPadding(r2, r7, r2, r7)     // Catch:{ Exception -> 0x0336 }
            r2 = 1094713344(0x41400000, float:12.0)
            r0.setTextSize(r2)     // Catch:{ Exception -> 0x0336 }
            android.content.Context r2 = r11.f73812a     // Catch:{ Exception -> 0x0336 }
            int r3 = net.one97.paytm.o2o.events.R.color.color_7b7b7b     // Catch:{ Exception -> 0x0336 }
            int r2 = androidx.core.content.b.c(r2, r3)     // Catch:{ Exception -> 0x0336 }
            r0.setTextColor(r2)     // Catch:{ Exception -> 0x0336 }
            r2 = r1
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0336 }
            r2.addView(r0)     // Catch:{ Exception -> 0x0336 }
        L_0x010c:
            int r0 = r13.size()     // Catch:{ Exception -> 0x0336 }
            if (r7 >= r0) goto L_0x0138
            java.lang.Object r0 = r13.get(r7)     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.common.entity.events.FormValuesData r0 = (net.one97.paytm.common.entity.events.FormValuesData) r0     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r0.getValue()     // Catch:{ Exception -> 0x0336 }
            android.view.LayoutInflater r2 = r11.f73819h     // Catch:{ Exception -> 0x0336 }
            int r3 = net.one97.paytm.o2o.events.R.layout.events_booking_traveller_form_checkbox     // Catch:{ Exception -> 0x0336 }
            android.view.View r2 = r2.inflate(r3, r6)     // Catch:{ Exception -> 0x0336 }
            int r3 = net.one97.paytm.o2o.events.R.id.events_traveller_checkbox     // Catch:{ Exception -> 0x0336 }
            android.view.View r3 = r2.findViewById(r3)     // Catch:{ Exception -> 0x0336 }
            android.widget.CheckBox r3 = (android.widget.CheckBox) r3     // Catch:{ Exception -> 0x0336 }
            r3.setText(r0)     // Catch:{ Exception -> 0x0336 }
            r0 = r1
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x0336 }
            r0.addView(r2)     // Catch:{ Exception -> 0x0336 }
            int r7 = r7 + 1
            goto L_0x010c
        L_0x0138:
            r6 = r1
            goto L_0x032b
        L_0x013b:
            return
        L_0x013c:
            java.lang.String r13 = "radio"
            boolean r13 = r0.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0336 }
            if (r13 == 0) goto L_0x01fc
            java.util.List r13 = r12.getRadioListValues()     // Catch:{ Exception -> 0x0336 }
            if (r13 == 0) goto L_0x01fb
            int r0 = r13.size()     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x0152
            goto L_0x01fb
        L_0x0152:
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0336 }
            r0.<init>(r3, r1)     // Catch:{ Exception -> 0x0336 }
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x0336 }
            android.content.Context r3 = r11.getContext()     // Catch:{ Exception -> 0x0336 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0336 }
            r3 = r1
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3     // Catch:{ Exception -> 0x0336 }
            r3.setOrientation(r5)     // Catch:{ Exception -> 0x0336 }
            r1.setLayoutParams(r0)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x0194
            android.widget.TextView r0 = new android.widget.TextView     // Catch:{ Exception -> 0x0336 }
            android.content.Context r3 = r11.f73812a     // Catch:{ Exception -> 0x0336 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r3 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            r0.setText(r3)     // Catch:{ Exception -> 0x0336 }
            r3 = 30
            r4 = 12
            r0.setPadding(r3, r4, r7, r7)     // Catch:{ Exception -> 0x0336 }
            r0.setTypeface(r6, r5)     // Catch:{ Exception -> 0x0336 }
            r0.setTextSize(r2)     // Catch:{ Exception -> 0x0336 }
            r2 = r1
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0336 }
            r2.addView(r0)     // Catch:{ Exception -> 0x0336 }
        L_0x0194:
            int r0 = r13.size()     // Catch:{ Exception -> 0x0336 }
            if (r7 >= r0) goto L_0x0138
            java.lang.Object r0 = r13.get(r7)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0336 }
            android.view.LayoutInflater r2 = r11.f73819h     // Catch:{ Exception -> 0x0336 }
            int r3 = net.one97.paytm.o2o.events.R.layout.events_booking_traveller_form_radio     // Catch:{ Exception -> 0x0336 }
            android.view.View r2 = r2.inflate(r3, r6)     // Catch:{ Exception -> 0x0336 }
            int r3 = net.one97.paytm.o2o.events.R.id.events_traveller_radio     // Catch:{ Exception -> 0x0336 }
            android.view.View r3 = r2.findViewById(r3)     // Catch:{ Exception -> 0x0336 }
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3     // Catch:{ Exception -> 0x0336 }
            r3.setText(r0)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x01ce
            if (r7 != 0) goto L_0x01ea
            r3.setChecked(r5)     // Catch:{ Exception -> 0x0336 }
            java.lang.CharSequence r0 = r3.getText()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0336 }
            r12.setApplied(r0)     // Catch:{ Exception -> 0x0336 }
            goto L_0x01ea
        L_0x01ce:
            java.lang.String r0 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            java.lang.CharSequence r4 = r3.getText()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0336 }
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x01ea
            r3.setChecked(r5)     // Catch:{ Exception -> 0x0336 }
            r3.performClick()     // Catch:{ Exception -> 0x0336 }
        L_0x01ea:
            net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$12 r0 = new net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$12     // Catch:{ Exception -> 0x0336 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0336 }
            r3.setOnClickListener(r0)     // Catch:{ Exception -> 0x0336 }
            r0 = r1
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x0336 }
            r0.addView(r2)     // Catch:{ Exception -> 0x0336 }
            int r7 = r7 + 1
            goto L_0x0194
        L_0x01fb:
            return
        L_0x01fc:
            java.lang.String r13 = "textarea"
            boolean r13 = r0.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x0336 }
            if (r13 == 0) goto L_0x032b
            android.view.LayoutInflater r13 = r11.f73819h     // Catch:{ Exception -> 0x0336 }
            int r0 = net.one97.paytm.o2o.events.R.layout.events_booking_traveller_form_textarea     // Catch:{ Exception -> 0x0336 }
            android.view.View r6 = r13.inflate(r0, r6)     // Catch:{ Exception -> 0x0336 }
            int r13 = net.one97.paytm.o2o.events.R.id.events_booking_textarea_header     // Catch:{ Exception -> 0x0336 }
            android.view.View r13 = r6.findViewById(r13)     // Catch:{ Exception -> 0x0336 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0336 }
            int r0 = net.one97.paytm.o2o.events.R.id.events_booking_textarea_edittext     // Catch:{ Exception -> 0x0336 }
            android.view.View r0 = r6.findViewById(r0)     // Catch:{ Exception -> 0x0336 }
            android.widget.EditText r0 = (android.widget.EditText) r0     // Catch:{ Exception -> 0x0336 }
            java.lang.String r1 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0336 }
            if (r1 != 0) goto L_0x022e
            java.lang.String r1 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0336 }
        L_0x022e:
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            r13.setText(r0)     // Catch:{ Exception -> 0x0336 }
            goto L_0x032b
        L_0x0237:
            android.view.LayoutInflater r1 = r11.f73819h     // Catch:{ Exception -> 0x0336 }
            int r8 = net.one97.paytm.o2o.events.R.layout.events_booking_traveller_form_textview     // Catch:{ Exception -> 0x0336 }
            android.view.View r6 = r1.inflate(r8, r6)     // Catch:{ Exception -> 0x0336 }
            int r1 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textinputlayout     // Catch:{ Exception -> 0x0336 }
            android.view.View r1 = r6.findViewById(r1)     // Catch:{ Exception -> 0x0336 }
            com.google.android.material.textfield.TextInputLayout r1 = (com.google.android.material.textfield.TextInputLayout) r1     // Catch:{ Exception -> 0x0336 }
            android.widget.EditText r8 = new android.widget.EditText     // Catch:{ Exception -> 0x0336 }
            android.content.Context r9 = r11.getContext()     // Catch:{ Exception -> 0x0336 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0336 }
            android.content.Context r9 = r11.getContext()     // Catch:{ Exception -> 0x0336 }
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ Exception -> 0x0336 }
            int r10 = net.one97.paytm.o2o.events.R.color.color_7b7b7b     // Catch:{ Exception -> 0x0336 }
            int r9 = r9.getColor(r10)     // Catch:{ Exception -> 0x0336 }
            r8.setTextColor(r9)     // Catch:{ Exception -> 0x0336 }
            r9 = 2
            r8.setTextSize(r9, r2)     // Catch:{ Exception -> 0x0336 }
            r8.setSingleLine(r5)     // Catch:{ Exception -> 0x0336 }
            r8.setImeOptions(r4)     // Catch:{ Exception -> 0x0336 }
            r8.setId(r13)     // Catch:{ Exception -> 0x0336 }
            int r13 = net.one97.paytm.o2o.events.R.color.transparent     // Catch:{ Exception -> 0x0336 }
            r8.setBackgroundResource(r13)     // Catch:{ Exception -> 0x0336 }
            r1.addView(r8)     // Catch:{ Exception -> 0x0336 }
            boolean r13 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x028d
            java.lang.String r0 = r12.getAppliedData()     // Catch:{ Exception -> 0x0336 }
            r8.setText(r0)     // Catch:{ Exception -> 0x0336 }
            goto L_0x0303
        L_0x028d:
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x0303
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r2 = "full name"
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x02b1
            java.lang.String r0 = r11.l     // Catch:{ Exception -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x02b1
            java.lang.String r0 = r11.l     // Catch:{ Exception -> 0x0336 }
            r8.setText(r0)     // Catch:{ Exception -> 0x0336 }
            goto L_0x02fc
        L_0x02b1:
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r2 = "email"
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x02cf
            java.lang.String r0 = r11.m     // Catch:{ Exception -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x02cf
            java.lang.String r0 = r11.m     // Catch:{ Exception -> 0x0336 }
            r8.setText(r0)     // Catch:{ Exception -> 0x0336 }
            goto L_0x02fc
        L_0x02cf:
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r2 = "mobile"
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x02ef
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0336 }
            java.lang.String r2 = "phone"
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x02fc
        L_0x02ef:
            java.lang.String r0 = r11.n     // Catch:{ Exception -> 0x0336 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x02fc
            java.lang.String r0 = r11.n     // Catch:{ Exception -> 0x0336 }
            r8.setText(r0)     // Catch:{ Exception -> 0x0336 }
        L_0x02fc:
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            r1.setHint(r0)     // Catch:{ Exception -> 0x0336 }
        L_0x0303:
            if (r13 == 0) goto L_0x030c
            r8.setInputType(r7)     // Catch:{ Exception -> 0x0336 }
            r8.setFocusableInTouchMode(r7)     // Catch:{ Exception -> 0x0336 }
            goto L_0x031b
        L_0x030c:
            java.lang.String r0 = r12.getTitle()     // Catch:{ Exception -> 0x0336 }
            if (r0 == 0) goto L_0x031b
            boolean r0 = r11.f73816e     // Catch:{ Exception -> 0x0336 }
            if (r0 != 0) goto L_0x031b
            r0 = 24577(0x6001, float:3.444E-41)
            r8.setInputType(r0)     // Catch:{ Exception -> 0x0336 }
        L_0x031b:
            net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$9 r0 = new net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$9     // Catch:{ Exception -> 0x0336 }
            r0.<init>(r8, r12, r13)     // Catch:{ Exception -> 0x0336 }
            r8.setOnFocusChangeListener(r0)     // Catch:{ Exception -> 0x0336 }
            net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$10 r0 = new net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$10     // Catch:{ Exception -> 0x0336 }
            r0.<init>(r8, r13)     // Catch:{ Exception -> 0x0336 }
            r8.setOnClickListener(r0)     // Catch:{ Exception -> 0x0336 }
        L_0x032b:
            if (r6 == 0) goto L_0x0335
            r6.setTag(r12)     // Catch:{ Exception -> 0x0336 }
            android.widget.LinearLayout r12 = r11.f73818g     // Catch:{ Exception -> 0x0336 }
            r12.addView(r6)     // Catch:{ Exception -> 0x0336 }
        L_0x0335:
            return
        L_0x0336:
            android.content.Context r12 = r11.f73812a
            android.content.res.Resources r13 = r12.getResources()
            int r0 = net.one97.paytm.o2o.events.R.string.error
            java.lang.String r13 = r13.getString(r0)
            android.content.Context r0 = r11.f73812a
            android.content.res.Resources r0 = r0.getResources()
            int r1 = net.one97.paytm.o2o.events.R.string.unable_to_fetch_form
            java.lang.String r0 = r0.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r12, (java.lang.String) r13, (java.lang.String) r0)
        L_0x0351:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.view.EventsTravellerDetailsView.a(net.one97.paytm.common.entity.events.EventsInputForm, int):void");
    }

    public void onClick(View view) {
        a();
    }

    /* JADX WARNING: type inference failed for: r5v24, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r18 = this;
            r0 = r18
            android.widget.Button r1 = r0.f73820i     // Catch:{ Exception -> 0x031b }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x031b }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x031b }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x031b }
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0011:
            int r5 = r1.getChildCount()     // Catch:{ Exception -> 0x031b }
            if (r3 >= r5) goto L_0x02d1
            if (r3 == 0) goto L_0x02cd
            int r5 = r1.getChildCount()     // Catch:{ Exception -> 0x031b }
            r6 = 1
            int r5 = r5 - r6
            if (r3 == r5) goto L_0x02cd
            android.view.View r5 = r1.getChildAt(r3)     // Catch:{ Exception -> 0x031b }
            java.lang.Object r7 = r5.getTag()     // Catch:{ Exception -> 0x031b }
            net.one97.paytm.common.entity.events.EventsInputForm r7 = (net.one97.paytm.common.entity.events.EventsInputForm) r7     // Catch:{ Exception -> 0x031b }
            r8 = 8
            java.lang.String r9 = ""
            java.lang.String r10 = "Please enter a valid "
            if (r7 != 0) goto L_0x0141
            boolean r7 = r5 instanceof android.widget.LinearLayout     // Catch:{ Exception -> 0x031b }
            if (r7 == 0) goto L_0x02cd
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5     // Catch:{ Exception -> 0x031b }
            r7 = 0
            if (r5 == 0) goto L_0x0049
            int r11 = r5.getChildCount()     // Catch:{ Exception -> 0x031b }
            if (r11 != r6) goto L_0x0049
            android.view.View r5 = r5.getChildAt(r2)     // Catch:{ Exception -> 0x031b }
            r7 = r5
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7     // Catch:{ Exception -> 0x031b }
        L_0x0049:
            if (r7 == 0) goto L_0x02cd
            int r5 = r7.getChildCount()     // Catch:{ Exception -> 0x031b }
            r11 = 21
            if (r5 != r11) goto L_0x02cd
            r5 = r4
            r4 = 0
        L_0x0055:
            int r11 = r7.getChildCount()     // Catch:{ Exception -> 0x031b }
            int r11 = r11 / 3
            if (r4 >= r11) goto L_0x013e
            int r11 = r4 * 3
            android.view.View r12 = r7.getChildAt(r11)     // Catch:{ Exception -> 0x031b }
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12     // Catch:{ Exception -> 0x031b }
            int r11 = r11 + 2
            android.view.View r11 = r7.getChildAt(r11)     // Catch:{ Exception -> 0x031b }
            android.widget.TextView r11 = (android.widget.TextView) r11     // Catch:{ Exception -> 0x031b }
            if (r11 == 0) goto L_0x0072
            r11.setVisibility(r8)     // Catch:{ Exception -> 0x031b }
        L_0x0072:
            android.view.View r13 = r12.getChildAt(r2)     // Catch:{ Exception -> 0x031b }
            android.widget.EditText r13 = (android.widget.EditText) r13     // Catch:{ Exception -> 0x031b }
            java.lang.Object r14 = r13.getTag()     // Catch:{ Exception -> 0x031b }
            net.one97.paytm.common.entity.events.EventsInputForm r14 = (net.one97.paytm.common.entity.events.EventsInputForm) r14     // Catch:{ Exception -> 0x031b }
            android.text.Editable r15 = r13.getText()     // Catch:{ Exception -> 0x031b }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x031b }
            java.lang.String r15 = r15.trim()     // Catch:{ Exception -> 0x031b }
            if (r14 == 0) goto L_0x0137
            boolean r16 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x031b }
            if (r16 == 0) goto L_0x00b4
            if (r11 == 0) goto L_0x00ae
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x031b }
            java.lang.CharSequence r17 = r12.getHint()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r17.toString()     // Catch:{ Exception -> 0x031b }
            r6.append(r8)     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x031b }
            r11.setText(r6)     // Catch:{ Exception -> 0x031b }
            r11.setVisibility(r2)     // Catch:{ Exception -> 0x031b }
        L_0x00ae:
            if (r5 != 0) goto L_0x00b4
            r13.requestFocus()     // Catch:{ Exception -> 0x031b }
            r5 = 1
        L_0x00b4:
            java.lang.String r6 = r14.getRegex()     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x0106
            java.lang.String r6 = r14.getRegex()     // Catch:{ Exception -> 0x031b }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x031b }
            if (r8 == 0) goto L_0x00c5
            r6 = r9
        L_0x00c5:
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r15.trim()     // Catch:{ Exception -> 0x031b }
            java.util.regex.Matcher r6 = r6.matcher(r8)     // Catch:{ Exception -> 0x031b }
            boolean r6 = r6.matches()     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x00fc
            r14.setApplied(r9)     // Catch:{ Exception -> 0x031b }
            if (r11 == 0) goto L_0x0137
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x031b }
            java.lang.CharSequence r8 = r12.getHint()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x031b }
            r6.append(r8)     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x031b }
            r11.setText(r6)     // Catch:{ Exception -> 0x031b }
            r11.setVisibility(r2)     // Catch:{ Exception -> 0x031b }
            if (r5 != 0) goto L_0x0137
            r13.requestFocus()     // Catch:{ Exception -> 0x031b }
            goto L_0x012c
        L_0x00fc:
            boolean r6 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x0137
            r14.setApplied(r15)     // Catch:{ Exception -> 0x031b }
            goto L_0x0137
        L_0x0106:
            java.lang.String r6 = "Age"
            java.lang.String r8 = r14.getTitle()     // Catch:{ Exception -> 0x031b }
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x012e
            java.lang.String r6 = "0"
            boolean r6 = r15.equals(r6)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x012e
            if (r11 == 0) goto L_0x0137
            int r6 = net.one97.paytm.o2o.events.R.string.wrong_age_input     // Catch:{ Exception -> 0x031b }
            r11.setText(r6)     // Catch:{ Exception -> 0x031b }
            r11.setVisibility(r2)     // Catch:{ Exception -> 0x031b }
            r14.setApplied(r9)     // Catch:{ Exception -> 0x031b }
            if (r5 != 0) goto L_0x0137
            r13.requestFocus()     // Catch:{ Exception -> 0x031b }
        L_0x012c:
            r5 = 1
            goto L_0x0137
        L_0x012e:
            boolean r6 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x0137
            r14.setApplied(r15)     // Catch:{ Exception -> 0x031b }
        L_0x0137:
            int r4 = r4 + 1
            r6 = 1
            r8 = 8
            goto L_0x0055
        L_0x013e:
            r4 = r5
            goto L_0x02cd
        L_0x0141:
            java.lang.String r6 = r7.getType()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "textbox"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x0226
            java.lang.String r6 = r7.getType()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "calendar"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x015c
            goto L_0x0226
        L_0x015c:
            java.lang.String r6 = r7.getType()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "textarea"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x01de
            int r6 = net.one97.paytm.o2o.events.R.id.events_booking_textarea_edittext     // Catch:{ Exception -> 0x031b }
            android.view.View r6 = r5.findViewById(r6)     // Catch:{ Exception -> 0x031b }
            android.widget.EditText r6 = (android.widget.EditText) r6     // Catch:{ Exception -> 0x031b }
            int r8 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x031b }
            android.view.View r5 = r5.findViewById(r8)     // Catch:{ Exception -> 0x031b }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x031b }
            r8 = 8
            r5.setVisibility(r8)     // Catch:{ Exception -> 0x031b }
            android.text.Editable r8 = r6.getText()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x031b }
            r7.setApplied(r8)     // Catch:{ Exception -> 0x031b }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x031b }
            if (r9 == 0) goto L_0x01ab
            if (r4 != 0) goto L_0x0194
            r6.requestFocus()     // Catch:{ Exception -> 0x031b }
        L_0x0194:
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r1.<init>(r10)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = r7.getTitle()     // Catch:{ Exception -> 0x031b }
            r1.append(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031b }
            r5.setText(r1)     // Catch:{ Exception -> 0x031b }
            return
        L_0x01ab:
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x02cd
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x031b }
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x031b }
            java.util.regex.Matcher r6 = r6.matcher(r8)     // Catch:{ Exception -> 0x031b }
            boolean r6 = r6.matches()     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x02cd
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r1.<init>(r10)     // Catch:{ Exception -> 0x031b }
            java.lang.String r2 = r7.getTitle()     // Catch:{ Exception -> 0x031b }
            r1.append(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x031b }
            r5.setText(r1)     // Catch:{ Exception -> 0x031b }
            return
        L_0x01de:
            java.lang.String r6 = r7.getType()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = "checkbox"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x02cd
            int r6 = net.one97.paytm.o2o.events.R.id.events_traveller_checkbox     // Catch:{ Exception -> 0x031b }
            android.view.View r5 = r5.findViewById(r6)     // Catch:{ Exception -> 0x031b }
            android.widget.CheckBox r5 = (android.widget.CheckBox) r5     // Catch:{ Exception -> 0x031b }
            java.lang.CharSequence r6 = r5.getText()     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x031b }
            r7.setApplied(r6)     // Catch:{ Exception -> 0x031b }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x031b }
            if (r8 == 0) goto L_0x0209
            if (r4 != 0) goto L_0x0208
            r5.requestFocus()     // Catch:{ Exception -> 0x031b }
        L_0x0208:
            return
        L_0x0209:
            java.lang.String r5 = r7.getRegex()     // Catch:{ Exception -> 0x031b }
            if (r5 == 0) goto L_0x02cd
            java.lang.String r5 = r7.getRegex()     // Catch:{ Exception -> 0x031b }
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x031b }
            java.util.regex.Matcher r5 = r5.matcher(r6)     // Catch:{ Exception -> 0x031b }
            boolean r5 = r5.matches()     // Catch:{ Exception -> 0x031b }
            if (r5 != 0) goto L_0x02cd
            return
        L_0x0226:
            int r6 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textinputlayout     // Catch:{ Exception -> 0x031b }
            android.view.View r6 = r5.findViewById(r6)     // Catch:{ Exception -> 0x031b }
            com.google.android.material.textfield.TextInputLayout r6 = (com.google.android.material.textfield.TextInputLayout) r6     // Catch:{ Exception -> 0x031b }
            android.view.View r8 = r6.findViewById(r3)     // Catch:{ Exception -> 0x031b }
            android.widget.EditText r8 = (android.widget.EditText) r8     // Catch:{ Exception -> 0x031b }
            int r11 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x031b }
            android.view.View r5 = r5.findViewById(r11)     // Catch:{ Exception -> 0x031b }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x031b }
            r11 = 8
            r5.setVisibility(r11)     // Catch:{ Exception -> 0x031b }
            android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x031b }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x031b }
            boolean r11 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x031b }
            if (r11 == 0) goto L_0x026f
            if (r4 != 0) goto L_0x0259
            r6.requestFocus()     // Catch:{ Exception -> 0x031b }
            r4 = 1
        L_0x0259:
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = r7.getTitle()     // Catch:{ Exception -> 0x031b }
            r6.append(r11)     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x031b }
            r5.setText(r6)     // Catch:{ Exception -> 0x031b }
        L_0x026f:
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = "FullName"
            if (r6 != 0) goto L_0x028c
            java.lang.String r6 = r7.getId()     // Catch:{ Exception -> 0x031b }
            boolean r6 = r6.contains(r11)     // Catch:{ Exception -> 0x031b }
            if (r6 == 0) goto L_0x0282
            goto L_0x028c
        L_0x0282:
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x031b }
            if (r5 != 0) goto L_0x02cd
            r7.setApplied(r8)     // Catch:{ Exception -> 0x031b }
            goto L_0x02cd
        L_0x028c:
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x031b }
            java.lang.String r12 = r7.getId()     // Catch:{ Exception -> 0x031b }
            boolean r11 = r12.contains(r11)     // Catch:{ Exception -> 0x031b }
            if (r11 == 0) goto L_0x029e
            if (r6 != 0) goto L_0x029e
            java.lang.String r6 = "[A-Z\\sa-z]+"
        L_0x029e:
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ Exception -> 0x031b }
            java.lang.String r11 = r8.trim()     // Catch:{ Exception -> 0x031b }
            java.util.regex.Matcher r6 = r6.matcher(r11)     // Catch:{ Exception -> 0x031b }
            boolean r6 = r6.matches()     // Catch:{ Exception -> 0x031b }
            if (r6 != 0) goto L_0x02ca
            r7.setApplied(r9)     // Catch:{ Exception -> 0x031b }
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x031b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x031b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x031b }
            java.lang.String r7 = r7.getTitle()     // Catch:{ Exception -> 0x031b }
            r6.append(r7)     // Catch:{ Exception -> 0x031b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x031b }
            r5.setText(r6)     // Catch:{ Exception -> 0x031b }
            goto L_0x02cd
        L_0x02ca:
            r7.setApplied(r8)     // Catch:{ Exception -> 0x031b }
        L_0x02cd:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x02d1:
            net.one97.paytm.common.entity.events.EventsTravellerResponseModel r1 = r0.f73817f     // Catch:{ Exception -> 0x031b }
            if (r1 == 0) goto L_0x031b
            net.one97.paytm.common.entity.events.EventsTravellerResponseModel r1 = r0.f73817f     // Catch:{ Exception -> 0x031b }
            java.util.ArrayList r1 = r1.getForm()     // Catch:{ Exception -> 0x031b }
            if (r1 == 0) goto L_0x031b
            net.one97.paytm.common.entity.events.EventsTravellerResponseModel r1 = r0.f73817f     // Catch:{ Exception -> 0x031b }
            java.util.ArrayList r1 = r1.getForm()     // Catch:{ Exception -> 0x031b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x031b }
        L_0x02e7:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x031b }
            if (r2 == 0) goto L_0x0310
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x031b }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x031b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x031b }
        L_0x02f7:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x02e7
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x031b }
            net.one97.paytm.common.entity.events.EventsInputForm r3 = (net.one97.paytm.common.entity.events.EventsInputForm) r3     // Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x02f7
            java.lang.String r3 = r3.getAppliedData()     // Catch:{ Exception -> 0x031b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x02f7
            return
        L_0x0310:
            net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$a r1 = r0.j     // Catch:{ Exception -> 0x031b }
            if (r1 == 0) goto L_0x031b
            net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$a r1 = r0.j     // Catch:{ Exception -> 0x031b }
            net.one97.paytm.common.entity.events.EventsTravellerResponseModel r2 = r0.f73817f     // Catch:{ Exception -> 0x031b }
            r1.b(r2)     // Catch:{ Exception -> 0x031b }
        L_0x031b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.view.EventsTravellerDetailsView.a():void");
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        this.k.setText(new SimpleDateFormat(TextUtils.isEmpty(this.f73815d) ? "dd MMM yyyy" : this.f73815d).format(new GregorianCalendar(i2, i3, i4).getTime()));
    }

    private void setHideContinueButton(boolean z) {
        this.o = z;
    }

    /* JADX WARNING: type inference failed for: r3v16, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.one97.paytm.common.entity.events.EventsTravellerResponseModel getTravellerDetails() {
        /*
            r10 = this;
            net.one97.paytm.o2o.events.view.EventsTravellerDetailsView$a r0 = r10.j
            r0.c()
            android.widget.Button r0 = r10.f73820i     // Catch:{ Exception -> 0x019c }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ Exception -> 0x019c }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ Exception -> 0x019c }
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x019c }
            r1 = 0
            r2 = 0
        L_0x0013:
            int r3 = r0.getChildCount()     // Catch:{ Exception -> 0x019c }
            if (r2 >= r3) goto L_0x019c
            android.view.View r3 = r0.getChildAt(r2)     // Catch:{ Exception -> 0x019c }
            java.lang.Object r4 = r3.getTag()     // Catch:{ Exception -> 0x019c }
            net.one97.paytm.common.entity.events.EventsInputForm r4 = (net.one97.paytm.common.entity.events.EventsInputForm) r4     // Catch:{ Exception -> 0x019c }
            r5 = 8
            r6 = 1
            if (r4 != 0) goto L_0x00cc
            boolean r4 = r3 instanceof android.widget.LinearLayout     // Catch:{ Exception -> 0x019c }
            if (r4 == 0) goto L_0x0198
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3     // Catch:{ Exception -> 0x019c }
            r4 = 0
            if (r3 == 0) goto L_0x0046
            int r7 = r3.getChildCount()     // Catch:{ Exception -> 0x019c }
            if (r7 != r6) goto L_0x0046
            android.view.View r6 = r3.getChildAt(r1)     // Catch:{ Exception -> 0x019c }
            boolean r6 = r6 instanceof android.widget.LinearLayout     // Catch:{ Exception -> 0x019c }
            if (r6 == 0) goto L_0x0046
            android.view.View r3 = r3.getChildAt(r1)     // Catch:{ Exception -> 0x019c }
            r4 = r3
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x019c }
        L_0x0046:
            if (r4 == 0) goto L_0x0198
            int r3 = r4.getChildCount()     // Catch:{ Exception -> 0x019c }
            r6 = 21
            if (r3 != r6) goto L_0x0198
            r3 = 0
        L_0x0051:
            int r6 = r4.getChildCount()     // Catch:{ Exception -> 0x019c }
            int r6 = r6 / 3
            if (r3 >= r6) goto L_0x0198
            int r6 = r3 * 3
            android.view.View r7 = r4.getChildAt(r6)     // Catch:{ Exception -> 0x019c }
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7     // Catch:{ Exception -> 0x019c }
            int r6 = r6 + 2
            android.view.View r6 = r4.getChildAt(r6)     // Catch:{ Exception -> 0x019c }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x019c }
            if (r6 == 0) goto L_0x006e
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x019c }
        L_0x006e:
            android.view.View r6 = r7.getChildAt(r1)     // Catch:{ Exception -> 0x019c }
            android.widget.EditText r6 = (android.widget.EditText) r6     // Catch:{ Exception -> 0x019c }
            java.lang.Object r7 = r6.getTag()     // Catch:{ Exception -> 0x019c }
            net.one97.paytm.common.entity.events.EventsInputForm r7 = (net.one97.paytm.common.entity.events.EventsInputForm) r7     // Catch:{ Exception -> 0x019c }
            android.text.Editable r6 = r6.getText()     // Catch:{ Exception -> 0x019c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x019c }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x019c }
            if (r7 == 0) goto L_0x00c9
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x019c }
            if (r8 != 0) goto L_0x00c9
            java.lang.String r8 = r7.getRegex()     // Catch:{ Exception -> 0x019c }
            if (r8 == 0) goto L_0x00b6
            java.lang.String r8 = r7.getRegex()     // Catch:{ Exception -> 0x019c }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x019c }
            if (r9 == 0) goto L_0x00a0
            java.lang.String r8 = ""
        L_0x00a0:
            java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r8)     // Catch:{ Exception -> 0x019c }
            java.lang.String r9 = r6.trim()     // Catch:{ Exception -> 0x019c }
            java.util.regex.Matcher r8 = r8.matcher(r9)     // Catch:{ Exception -> 0x019c }
            boolean r8 = r8.matches()     // Catch:{ Exception -> 0x019c }
            if (r8 == 0) goto L_0x00c9
            r7.setApplied(r6)     // Catch:{ Exception -> 0x019c }
            goto L_0x00c9
        L_0x00b6:
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x019c }
            if (r8 != 0) goto L_0x00c9
            java.lang.String r8 = r7.getAppliedData()     // Catch:{ Exception -> 0x019c }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x019c }
            if (r8 == 0) goto L_0x00c9
            r7.setApplied(r6)     // Catch:{ Exception -> 0x019c }
        L_0x00c9:
            int r3 = r3 + 1
            goto L_0x0051
        L_0x00cc:
            java.lang.String r7 = r4.getType()     // Catch:{ Exception -> 0x019c }
            java.lang.String r8 = "textbox"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x019c }
            if (r7 == 0) goto L_0x016d
            int r7 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textinputlayout     // Catch:{ Exception -> 0x019c }
            r3.findViewById(r7)     // Catch:{ Exception -> 0x019c }
            int r7 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textinputlayout     // Catch:{ Exception -> 0x019c }
            r3.findViewById(r7)     // Catch:{ Exception -> 0x019c }
            android.view.View r7 = r3.findViewById(r2)     // Catch:{ Exception -> 0x019c }
            android.widget.EditText r7 = (android.widget.EditText) r7     // Catch:{ Exception -> 0x019c }
            android.content.Context r8 = r10.getContext()     // Catch:{ Exception -> 0x019c }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ Exception -> 0x019c }
            int r9 = net.one97.paytm.o2o.events.R.color.color_7b7b7b     // Catch:{ Exception -> 0x019c }
            int r8 = r8.getColor(r9)     // Catch:{ Exception -> 0x019c }
            r7.setTextColor(r8)     // Catch:{ Exception -> 0x019c }
            r8 = 1096810496(0x41600000, float:14.0)
            r9 = 2
            r7.setTextSize(r9, r8)     // Catch:{ Exception -> 0x019c }
            r7.setSingleLine(r6)     // Catch:{ Exception -> 0x019c }
            r6 = 5
            r7.setImeOptions(r6)     // Catch:{ Exception -> 0x019c }
            int r6 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x019c }
            android.view.View r3 = r3.findViewById(r6)     // Catch:{ Exception -> 0x019c }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x019c }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x019c }
            android.text.Editable r3 = r7.getText()     // Catch:{ Exception -> 0x019c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x019c }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x019c }
            java.lang.String r5 = r4.getRegex()     // Catch:{ Exception -> 0x019c }
            java.lang.String r6 = "FullName"
            if (r5 != 0) goto L_0x0145
            java.lang.String r5 = r4.getId()     // Catch:{ Exception -> 0x019c }
            boolean r5 = r5.contains(r6)     // Catch:{ Exception -> 0x019c }
            if (r5 == 0) goto L_0x0131
            goto L_0x0145
        L_0x0131:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x019c }
            if (r5 != 0) goto L_0x0198
            java.lang.String r5 = r4.getAppliedData()     // Catch:{ Exception -> 0x019c }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x019c }
            if (r5 == 0) goto L_0x0198
            r4.setApplied(r3)     // Catch:{ Exception -> 0x019c }
            goto L_0x0198
        L_0x0145:
            java.lang.String r5 = r4.getRegex()     // Catch:{ Exception -> 0x019c }
            java.lang.String r7 = r4.getId()     // Catch:{ Exception -> 0x019c }
            boolean r6 = r7.contains(r6)     // Catch:{ Exception -> 0x019c }
            if (r6 == 0) goto L_0x0157
            if (r5 != 0) goto L_0x0157
            java.lang.String r5 = "[A-Z\\sa-z]+"
        L_0x0157:
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)     // Catch:{ Exception -> 0x019c }
            java.lang.String r6 = r3.trim()     // Catch:{ Exception -> 0x019c }
            java.util.regex.Matcher r5 = r5.matcher(r6)     // Catch:{ Exception -> 0x019c }
            boolean r5 = r5.matches()     // Catch:{ Exception -> 0x019c }
            if (r5 == 0) goto L_0x0198
            r4.setApplied(r3)     // Catch:{ Exception -> 0x019c }
            goto L_0x0198
        L_0x016d:
            java.lang.String r6 = r4.getType()     // Catch:{ Exception -> 0x019c }
            java.lang.String r7 = "textarea"
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x019c }
            if (r6 == 0) goto L_0x0198
            int r6 = net.one97.paytm.o2o.events.R.id.events_booking_textarea_edittext     // Catch:{ Exception -> 0x019c }
            android.view.View r6 = r3.findViewById(r6)     // Catch:{ Exception -> 0x019c }
            android.widget.EditText r6 = (android.widget.EditText) r6     // Catch:{ Exception -> 0x019c }
            int r7 = net.one97.paytm.o2o.events.R.id.events_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x019c }
            android.view.View r3 = r3.findViewById(r7)     // Catch:{ Exception -> 0x019c }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x019c }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x019c }
            android.text.Editable r3 = r6.getText()     // Catch:{ Exception -> 0x019c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x019c }
            r4.setApplied(r3)     // Catch:{ Exception -> 0x019c }
        L_0x0198:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x019c:
            net.one97.paytm.common.entity.events.EventsTravellerResponseModel r0 = r10.f73817f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.events.view.EventsTravellerDetailsView.getTravellerDetails():net.one97.paytm.common.entity.events.EventsTravellerResponseModel");
    }

    static /* synthetic */ void a(EventsTravellerDetailsView eventsTravellerDetailsView, EditText editText) {
        if (editText != null && eventsTravellerDetailsView.j != null) {
            editText.getBottom();
            editText.getLocationOnScreen(new int[2]);
            Rect rect = new Rect();
            editText.getLocalVisibleRect(rect);
            editText.getGlobalVisibleRect(rect);
            editText.getWindowVisibleDisplayFrame(rect);
        }
    }

    static /* synthetic */ void b(EventsTravellerDetailsView eventsTravellerDetailsView) {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(eventsTravellerDetailsView.getContext(), eventsTravellerDetailsView, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis());
        datePickerDialog.show();
    }
}
