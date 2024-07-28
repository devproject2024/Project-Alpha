package net.one97.paytm.o2o.amusementpark.c.a;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.amPark.AmParkInputForm;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.utils.k;

public class b extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public AmParkTravellerResponseModel f73425a;

    /* renamed from: b  reason: collision with root package name */
    public Button f73426b;

    /* renamed from: c  reason: collision with root package name */
    public a f73427c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f73428d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f73429e;

    /* renamed from: f  reason: collision with root package name */
    private int f73430f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f73431g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f73432h;

    /* renamed from: i  reason: collision with root package name */
    private LayoutInflater f73433i;
    private String j;
    private String k;
    private String l;

    public interface a {
        void a();

        void a(AmParkTravellerResponseModel amParkTravellerResponseModel);

        void b(AmParkTravellerResponseModel amParkTravellerResponseModel);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.park_booking_traveller_layout, viewGroup, false);
        if (com.paytm.utility.b.r((Context) getActivity())) {
            this.j = com.paytm.utility.b.j((Context) getActivity());
            this.k = com.paytm.utility.b.m((Context) getActivity());
            this.l = com.paytm.utility.b.l((Context) getActivity());
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f73430f = arguments.getInt("traveller-num-of-passenger", 0);
            this.f73429e = arguments.getBoolean("traveller-is-static-form", true);
            if (this.f73429e) {
                this.f73430f = 1;
            }
            this.f73425a = (AmParkTravellerResponseModel) arguments.getSerializable("traveller-details");
        }
        if (inflate != null) {
            this.f73433i = LayoutInflater.from(getContext());
            this.f73432h = (LinearLayout) inflate.findViewById(R.id.events_booking_traveller_container);
            this.f73432h.setOrientation(1);
            this.f73432h.removeAllViews();
            if (this.f73429e) {
                if (this.f73430f > 1) {
                    AmParkTravellerResponseModel amParkTravellerResponseModel = this.f73425a;
                    if (amParkTravellerResponseModel != null) {
                        if (amParkTravellerResponseModel != null && amParkTravellerResponseModel.getForm() == null) {
                            this.f73425a.setForm(new ArrayList());
                        }
                        if (this.f73425a.getForm().size() == 0) {
                            for (int i2 = 0; i2 < this.f73430f; i2++) {
                                this.f73425a.getForm().add(new ArrayList());
                            }
                        }
                        int i3 = 0;
                        while (i3 < this.f73430f) {
                            View inflate2 = this.f73433i.inflate(R.layout.park_booking_traveller_form_title, (ViewGroup) null);
                            TextView textView = (TextView) inflate2.findViewById(R.id.events_passenger_title_multiple);
                            textView.setVisibility(0);
                            int i4 = i3 + 1;
                            textView.setText(getContext().getString(R.string.events_traveller_details_title, new Object[]{Integer.valueOf(i4)}));
                            this.f73432h.addView(inflate2);
                            View inflate3 = this.f73433i.inflate(R.layout.park_booking_traveller_single_passenger_static_form, (ViewGroup) null);
                            a(inflate3, this.f73425a.getForm().get(i3));
                            this.f73432h.addView(inflate3);
                            i3 = i4;
                        }
                        View inflate4 = this.f73433i.inflate(R.layout.park_booking_traveller_form_button, (ViewGroup) null);
                        this.f73426b = (Button) inflate4.findViewById(R.id.events_single_traveller_form_continue_button);
                        this.f73426b.setOnClickListener(this);
                        this.f73432h.addView(inflate4);
                    }
                } else {
                    View inflate5 = this.f73433i.inflate(R.layout.park_booking_traveller_form_title, (ViewGroup) null);
                    ((TextView) inflate5.findViewById(R.id.events_passenger_title_single)).setVisibility(0);
                    ImageView imageView = (ImageView) inflate5.findViewById(R.id.events_maximized_image_button);
                    if (c()) {
                        imageView.setVisibility(0);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                b.this.a(false);
                                if (b.this.f73427c != null) {
                                    b.this.f73427c.a();
                                }
                            }
                        });
                    } else {
                        imageView.setVisibility(8);
                    }
                    this.f73432h.addView(inflate5);
                    View inflate6 = this.f73433i.inflate(R.layout.park_booking_traveller_single_passenger_static_form, (ViewGroup) null);
                    ArrayList arrayList = new ArrayList();
                    AmParkTravellerResponseModel amParkTravellerResponseModel2 = this.f73425a;
                    if (amParkTravellerResponseModel2 != null) {
                        if (amParkTravellerResponseModel2.getForm() == null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(arrayList);
                            this.f73425a.setForm(arrayList2);
                        } else if (this.f73425a.getForm().size() > 0) {
                            arrayList = this.f73425a.getForm().get(0);
                        } else {
                            this.f73425a.getForm().add(arrayList);
                        }
                    }
                    a(inflate6, (ArrayList<AmParkInputForm>) arrayList);
                    this.f73432h.addView(inflate6);
                    View inflate7 = this.f73433i.inflate(R.layout.park_booking_traveller_form_button, (ViewGroup) null);
                    this.f73426b = (Button) inflate7.findViewById(R.id.events_single_traveller_form_continue_button);
                    this.f73426b.setOnClickListener(this);
                    this.f73432h.addView(inflate7);
                }
            } else if (this.f73430f > 1) {
                d();
            } else {
                b();
            }
        }
        k.a(viewGroup.getContext(), 5, e());
        return inflate;
    }

    private void b() {
        ArrayList<ArrayList<AmParkInputForm>> form;
        ArrayList<ArrayList<AmParkInputForm>> form2;
        ArrayList arrayList;
        AmParkInputForm amParkInputForm;
        View inflate = this.f73433i.inflate(R.layout.park_booking_traveller_form_title, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.events_passenger_title_single);
        int i2 = 0;
        textView.setVisibility(0);
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.f73425a;
        if (!(amParkTravellerResponseModel == null || (form2 = amParkTravellerResponseModel.getForm()) == null || form2.size() <= 0 || (arrayList = form2.get(0)) == null || arrayList.size() <= 0 || (amParkInputForm = (AmParkInputForm) arrayList.get(0)) == null)) {
            String title = amParkInputForm.getTitle();
            if (!TextUtils.isEmpty(title)) {
                textView.setText(title);
            }
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.events_maximized_image_button);
        if (c()) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.a(false);
                    if (b.this.f73427c != null) {
                        b.this.f73427c.a();
                    }
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        this.f73432h.addView(inflate);
        AmParkTravellerResponseModel amParkTravellerResponseModel2 = this.f73425a;
        if (amParkTravellerResponseModel2 != null && (form = amParkTravellerResponseModel2.getForm()) != null && form.size() > 0) {
            Iterator<ArrayList<AmParkInputForm>> it2 = form.iterator();
            while (it2.hasNext()) {
                List<AmParkInputForm> next = it2.next();
                i2++;
                if (i2 > 1) {
                    break;
                } else if (next != null && next.size() > 0) {
                    for (AmParkInputForm a2 : next) {
                        a(a2);
                    }
                }
            }
        }
        View inflate2 = this.f73433i.inflate(R.layout.park_booking_traveller_form_button, (ViewGroup) null);
        this.f73426b = (Button) inflate2.findViewById(R.id.events_single_traveller_form_continue_button);
        this.f73426b.setOnClickListener(this);
        this.f73432h.addView(inflate2);
    }

    private boolean c() {
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.f73425a;
        if (amParkTravellerResponseModel == null || amParkTravellerResponseModel.getForm() == null || this.f73425a.getForm().size() <= 0) {
            return false;
        }
        Iterator<ArrayList<AmParkInputForm>> it2 = this.f73425a.getForm().iterator();
        while (it2.hasNext()) {
            ArrayList next = it2.next();
            if (next != null && next.size() > 0) {
                Iterator it3 = next.iterator();
                while (it3.hasNext()) {
                    AmParkInputForm amParkInputForm = (AmParkInputForm) it3.next();
                    if (amParkInputForm != null && !TextUtils.isEmpty(amParkInputForm.getAppliedData())) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
    }

    private void a(View view, ArrayList<AmParkInputForm> arrayList) {
        final EditText editText = (EditText) view.findViewById(R.id.events_passenger_first_name_textview);
        final AmParkInputForm amParkInputForm = arrayList.size() > 0 ? arrayList.get(0) : new AmParkInputForm();
        amParkInputForm.setTitle("First Name");
        amParkInputForm.setRegex("[A-Za-z\\s]+");
        editText.setText(amParkInputForm.getAppliedData());
        editText.setTag(amParkInputForm);
        arrayList.add(amParkInputForm);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    amParkInputForm.setApplied(trim);
                }
                if (z) {
                    b.a(b.this, editText);
                }
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, editText);
            }
        });
        final EditText editText2 = (EditText) view.findViewById(R.id.events_passenger_last_name_textview);
        final AmParkInputForm amParkInputForm2 = arrayList.size() > 1 ? arrayList.get(1) : new AmParkInputForm();
        amParkInputForm2.setTitle("Last Name");
        amParkInputForm2.setRegex("[A-Za-z\\s]+");
        editText2.setText(amParkInputForm2.getAppliedData());
        editText2.setTag(amParkInputForm2);
        arrayList.add(amParkInputForm2);
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText2.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    amParkInputForm2.setApplied(trim);
                }
                if (z) {
                    b.a(b.this, editText2);
                }
            }
        });
        editText2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, editText2);
            }
        });
        final EditText editText3 = (EditText) view.findViewById(R.id.events_passenger_age_textview);
        final AmParkInputForm amParkInputForm3 = null;
        final AmParkInputForm amParkInputForm4 = arrayList.size() > 2 ? arrayList.get(2) : null;
        if (amParkInputForm4 == null) {
            amParkInputForm4 = new AmParkInputForm();
        }
        amParkInputForm4.setTitle("Age");
        editText3.setText(amParkInputForm4.getAppliedData());
        editText3.setTag(amParkInputForm4);
        arrayList.add(amParkInputForm4);
        editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText3.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    amParkInputForm4.setApplied(trim);
                }
                if (z) {
                    b.a(b.this, editText3);
                }
            }
        });
        editText3.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, editText3);
            }
        });
        final EditText editText4 = (EditText) view.findViewById(R.id.events_passenger_mobile_number_textview);
        final AmParkInputForm amParkInputForm5 = arrayList.size() > 3 ? arrayList.get(3) : null;
        if (amParkInputForm5 == null) {
            amParkInputForm5 = new AmParkInputForm();
        }
        amParkInputForm5.setTitle("Mobile Number");
        amParkInputForm5.setRegex("^[7-9][0-9]{9}$");
        editText4.setText(amParkInputForm5.getAppliedData());
        editText4.setTag(amParkInputForm5);
        arrayList.add(amParkInputForm5);
        editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText4.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    amParkInputForm5.setApplied(trim);
                }
                if (z) {
                    b.a(b.this, editText4);
                }
            }
        });
        editText4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, editText4);
            }
        });
        final EditText editText5 = (EditText) view.findViewById(R.id.events_passenger_email_id_textview);
        final AmParkInputForm amParkInputForm6 = arrayList.size() > 4 ? arrayList.get(4) : null;
        if (amParkInputForm6 == null) {
            amParkInputForm6 = new AmParkInputForm();
        }
        amParkInputForm6.setTitle("EmailID");
        amParkInputForm6.setRegex("^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$");
        editText5.setText(amParkInputForm6.getAppliedData());
        editText5.setTag(amParkInputForm6);
        arrayList.add(amParkInputForm6);
        editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText5.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    amParkInputForm6.setApplied(trim);
                }
                if (z) {
                    b.a(b.this, editText5);
                }
            }
        });
        editText5.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, editText5);
            }
        });
        final EditText editText6 = (EditText) view.findViewById(R.id.events_passenger_pincode_textview);
        final AmParkInputForm amParkInputForm7 = arrayList.size() > 5 ? arrayList.get(5) : null;
        if (amParkInputForm7 == null) {
            amParkInputForm7 = new AmParkInputForm();
        }
        amParkInputForm7.setTitle("Pin Code");
        amParkInputForm7.setRegex("^[1-9][0-9]{5}");
        editText6.setText(amParkInputForm7.getAppliedData());
        editText6.setTag(amParkInputForm7);
        arrayList.add(amParkInputForm7);
        editText6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText6.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    amParkInputForm7.setApplied(trim);
                }
                if (z) {
                    b.a(b.this, editText6);
                }
            }
        });
        editText6.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, editText6);
            }
        });
        final EditText editText7 = (EditText) view.findViewById(R.id.events_passenger_city_textview);
        if (arrayList.size() > 6) {
            amParkInputForm3 = arrayList.get(6);
        }
        if (amParkInputForm3 == null) {
            amParkInputForm3 = new AmParkInputForm();
        }
        amParkInputForm3.setTitle("City");
        amParkInputForm3.setRegex("[A-Za-z\\s]+");
        editText7.setText(amParkInputForm3.getAppliedData());
        editText7.setTag(amParkInputForm3);
        arrayList.add(amParkInputForm3);
        editText7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                String trim = editText7.getText().toString().trim();
                if (!z && !TextUtils.isEmpty(trim)) {
                    amParkInputForm3.setApplied(trim);
                }
                if (z) {
                    b.a(b.this, editText7);
                }
            }
        });
        editText7.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, editText7);
            }
        });
        editText7.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0 || i2 != 66) {
                    return false;
                }
                b.this.a(true);
                return true;
            }
        });
    }

    private void d() {
        ArrayList<ArrayList<AmParkInputForm>> form;
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.f73425a;
        if (!(amParkTravellerResponseModel == null || (form = amParkTravellerResponseModel.getForm()) == null || form.size() <= 0)) {
            Iterator<ArrayList<AmParkInputForm>> it2 = form.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                List<AmParkInputForm> next = it2.next();
                View inflate = this.f73433i.inflate(R.layout.park_booking_traveller_form_title, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.events_passenger_title_multiple);
                textView.setVisibility(0);
                String title = ((AmParkInputForm) next.get(0)).getTitle();
                if (!TextUtils.isEmpty(title)) {
                    textView.setText(title);
                } else {
                    i2++;
                    textView.setText(getContext().getString(R.string.events_traveller_details_title, new Object[]{Integer.valueOf(i2)}));
                }
                this.f73432h.addView(inflate);
                if (next != null && next.size() > 0) {
                    for (AmParkInputForm a2 : next) {
                        a(a2);
                    }
                }
            }
        }
        View inflate2 = this.f73433i.inflate(R.layout.park_booking_traveller_form_button, (ViewGroup) null);
        this.f73426b = (Button) inflate2.findViewById(R.id.events_single_traveller_form_continue_button);
        this.f73426b.setOnClickListener(this);
        this.f73432h.addView(inflate2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0290 A[Catch:{ Exception -> 0x0299 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final net.one97.paytm.common.entity.amPark.AmParkInputForm r10) {
        /*
            r9 = this;
            android.widget.LinearLayout r0 = r9.f73432h
            if (r0 == 0) goto L_0x02e4
            if (r10 != 0) goto L_0x0008
            goto L_0x02e4
        L_0x0008:
            java.lang.String r0 = r10.getType()     // Catch:{ Exception -> 0x0299 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r1 = "textbox"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = "calendar"
            r3 = 0
            r4 = 1
            r5 = 0
            if (r1 != 0) goto L_0x01b3
            boolean r1 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x0028
            goto L_0x01b3
        L_0x0028:
            java.lang.String r1 = "dropdown"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x009e
            android.view.LayoutInflater r0 = r9.f73433i     // Catch:{ Exception -> 0x0299 }
            int r1 = net.one97.paytm.o2o.amusementpark.R.layout.park_booking_traveller_form_dropdown     // Catch:{ Exception -> 0x0299 }
            android.view.View r5 = r0.inflate(r1, r5)     // Catch:{ Exception -> 0x0299 }
            int r0 = net.one97.paytm.o2o.amusementpark.R.id.events_traveller_dropdown     // Catch:{ Exception -> 0x0299 }
            android.view.View r0 = r5.findViewById(r0)     // Catch:{ Exception -> 0x0299 }
            android.widget.Spinner r0 = (android.widget.Spinner) r0     // Catch:{ Exception -> 0x0299 }
            java.util.List r1 = r10.getDropDownListValues()     // Catch:{ Exception -> 0x0299 }
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x0299 }
            android.content.Context r4 = r9.getContext()     // Catch:{ Exception -> 0x0299 }
            r6 = 17367048(0x1090008, float:2.5162948E-38)
            r2.<init>(r4, r6, r1)     // Catch:{ Exception -> 0x0299 }
            r4 = 17367049(0x1090009, float:2.516295E-38)
            r2.setDropDownViewResource(r4)     // Catch:{ Exception -> 0x0299 }
            r0.setAdapter(r2)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x0075
            int r2 = r1.size()     // Catch:{ Exception -> 0x0299 }
            if (r2 <= 0) goto L_0x0075
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 == 0) goto L_0x0075
            java.lang.Object r2 = r1.get(r3)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0299 }
            r10.setApplied(r2)     // Catch:{ Exception -> 0x0299 }
            goto L_0x0094
        L_0x0075:
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x0094
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 == 0) goto L_0x0094
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            int r2 = r1.indexOf(r2)     // Catch:{ Exception -> 0x0299 }
            r0.setSelection(r2)     // Catch:{ Exception -> 0x0299 }
        L_0x0094:
            net.one97.paytm.o2o.amusementpark.c.a.b$13 r2 = new net.one97.paytm.o2o.amusementpark.c.a.b$13     // Catch:{ Exception -> 0x0299 }
            r2.<init>(r10, r1)     // Catch:{ Exception -> 0x0299 }
            r0.setOnItemSelectedListener(r2)     // Catch:{ Exception -> 0x0299 }
            goto L_0x028e
        L_0x009e:
            java.lang.String r1 = "checkbox"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x00df
            java.util.List r0 = r10.getCheckBoxListValues()     // Catch:{ Exception -> 0x0299 }
            if (r0 == 0) goto L_0x00de
            int r1 = r0.size()     // Catch:{ Exception -> 0x0299 }
            if (r1 != 0) goto L_0x00b3
            goto L_0x00de
        L_0x00b3:
            r1 = r5
        L_0x00b4:
            int r2 = r0.size()     // Catch:{ Exception -> 0x0299 }
            if (r3 >= r2) goto L_0x00db
            java.lang.Object r1 = r0.get(r3)     // Catch:{ Exception -> 0x0299 }
            net.one97.paytm.common.entity.amPark.FormValuesData r1 = (net.one97.paytm.common.entity.amPark.FormValuesData) r1     // Catch:{ Exception -> 0x0299 }
            java.lang.String r1 = r1.getValue()     // Catch:{ Exception -> 0x0299 }
            android.view.LayoutInflater r2 = r9.f73433i     // Catch:{ Exception -> 0x0299 }
            int r4 = net.one97.paytm.o2o.amusementpark.R.layout.park_booking_traveller_form_checkbox     // Catch:{ Exception -> 0x0299 }
            android.view.View r2 = r2.inflate(r4, r5)     // Catch:{ Exception -> 0x0299 }
            int r4 = net.one97.paytm.o2o.amusementpark.R.id.events_traveller_checkbox     // Catch:{ Exception -> 0x0299 }
            android.view.View r4 = r2.findViewById(r4)     // Catch:{ Exception -> 0x0299 }
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4     // Catch:{ Exception -> 0x0299 }
            r4.setText(r1)     // Catch:{ Exception -> 0x0299 }
            int r3 = r3 + 1
            r1 = r2
            goto L_0x00b4
        L_0x00db:
            r5 = r1
            goto L_0x028e
        L_0x00de:
            return
        L_0x00df:
            java.lang.String r1 = "radio"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x0179
            java.util.List r0 = r10.getRadioListValues()     // Catch:{ Exception -> 0x0299 }
            if (r0 == 0) goto L_0x0178
            int r1 = r0.size()     // Catch:{ Exception -> 0x0299 }
            if (r1 != 0) goto L_0x00f5
            goto L_0x0178
        L_0x00f5:
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0299 }
            r2 = -1
            r6 = -2
            r1.<init>(r2, r6)     // Catch:{ Exception -> 0x0299 }
            android.widget.LinearLayout r2 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x0299 }
            android.content.Context r6 = r9.getContext()     // Catch:{ Exception -> 0x0299 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0299 }
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6     // Catch:{ Exception -> 0x0299 }
            r6.setOrientation(r4)     // Catch:{ Exception -> 0x0299 }
            r2.setLayoutParams(r1)     // Catch:{ Exception -> 0x0299 }
        L_0x010e:
            int r1 = r0.size()     // Catch:{ Exception -> 0x0299 }
            if (r3 >= r1) goto L_0x0175
            java.lang.Object r1 = r0.get(r3)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0299 }
            android.view.LayoutInflater r6 = r9.f73433i     // Catch:{ Exception -> 0x0299 }
            int r7 = net.one97.paytm.o2o.amusementpark.R.layout.park_booking_traveller_form_radio     // Catch:{ Exception -> 0x0299 }
            android.view.View r6 = r6.inflate(r7, r5)     // Catch:{ Exception -> 0x0299 }
            int r7 = net.one97.paytm.o2o.amusementpark.R.id.events_traveller_radio     // Catch:{ Exception -> 0x0299 }
            android.view.View r7 = r6.findViewById(r7)     // Catch:{ Exception -> 0x0299 }
            android.widget.RadioButton r7 = (android.widget.RadioButton) r7     // Catch:{ Exception -> 0x0299 }
            r7.setText(r1)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r1 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x0148
            if (r3 != 0) goto L_0x0164
            r7.setChecked(r4)     // Catch:{ Exception -> 0x0299 }
            java.lang.CharSequence r1 = r7.getText()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0299 }
            r10.setApplied(r1)     // Catch:{ Exception -> 0x0299 }
            goto L_0x0164
        L_0x0148:
            java.lang.String r1 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            java.lang.CharSequence r8 = r7.getText()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x0299 }
            boolean r1 = r1.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0299 }
            if (r1 == 0) goto L_0x0164
            r7.setChecked(r4)     // Catch:{ Exception -> 0x0299 }
            r7.performClick()     // Catch:{ Exception -> 0x0299 }
        L_0x0164:
            net.one97.paytm.o2o.amusementpark.c.a.b$14 r1 = new net.one97.paytm.o2o.amusementpark.c.a.b$14     // Catch:{ Exception -> 0x0299 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x0299 }
            r7.setOnClickListener(r1)     // Catch:{ Exception -> 0x0299 }
            r1 = r2
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x0299 }
            r1.addView(r6)     // Catch:{ Exception -> 0x0299 }
            int r3 = r3 + 1
            goto L_0x010e
        L_0x0175:
            r5 = r2
            goto L_0x028e
        L_0x0178:
            return
        L_0x0179:
            java.lang.String r1 = "textarea"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0299 }
            if (r0 == 0) goto L_0x028e
            android.view.LayoutInflater r0 = r9.f73433i     // Catch:{ Exception -> 0x0299 }
            int r1 = net.one97.paytm.o2o.amusementpark.R.layout.park_booking_traveller_form_textarea     // Catch:{ Exception -> 0x0299 }
            android.view.View r5 = r0.inflate(r1, r5)     // Catch:{ Exception -> 0x0299 }
            int r0 = net.one97.paytm.o2o.amusementpark.R.id.events_booking_textarea_header     // Catch:{ Exception -> 0x0299 }
            android.view.View r0 = r5.findViewById(r0)     // Catch:{ Exception -> 0x0299 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0299 }
            int r1 = net.one97.paytm.o2o.amusementpark.R.id.events_booking_textarea_edittext     // Catch:{ Exception -> 0x0299 }
            android.view.View r1 = r5.findViewById(r1)     // Catch:{ Exception -> 0x0299 }
            android.widget.EditText r1 = (android.widget.EditText) r1     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x01aa
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0299 }
        L_0x01aa:
            java.lang.String r1 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0299 }
            goto L_0x028e
        L_0x01b3:
            android.view.LayoutInflater r1 = r9.f73433i     // Catch:{ Exception -> 0x0299 }
            int r6 = net.one97.paytm.o2o.amusementpark.R.layout.parks_booking_traveller_form_textview     // Catch:{ Exception -> 0x0299 }
            android.view.View r5 = r1.inflate(r6, r5)     // Catch:{ Exception -> 0x0299 }
            int r1 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textview     // Catch:{ Exception -> 0x0299 }
            android.view.View r1 = r5.findViewById(r1)     // Catch:{ Exception -> 0x0299 }
            android.widget.EditText r1 = (android.widget.EditText) r1     // Catch:{ Exception -> 0x0299 }
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x01da
            java.lang.String r2 = r10.getAppliedData()     // Catch:{ Exception -> 0x0299 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0299 }
            goto L_0x024b
        L_0x01da:
            if (r10 == 0) goto L_0x024b
            java.lang.String r2 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            if (r2 == 0) goto L_0x024b
            java.lang.String r2 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r6 = "full name"
            boolean r2 = r2.contains(r6)     // Catch:{ Exception -> 0x0299 }
            if (r2 == 0) goto L_0x0200
            java.lang.String r2 = r9.j     // Catch:{ Exception -> 0x0299 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x0200
            java.lang.String r2 = r9.j     // Catch:{ Exception -> 0x0299 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0299 }
            goto L_0x024b
        L_0x0200:
            java.lang.String r2 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r6 = "email"
            boolean r2 = r2.contains(r6)     // Catch:{ Exception -> 0x0299 }
            if (r2 == 0) goto L_0x021e
            java.lang.String r2 = r9.k     // Catch:{ Exception -> 0x0299 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x021e
            java.lang.String r2 = r9.k     // Catch:{ Exception -> 0x0299 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0299 }
            goto L_0x024b
        L_0x021e:
            java.lang.String r2 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r6 = "mobile"
            boolean r2 = r2.contains(r6)     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x023e
            java.lang.String r2 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r6 = "phone"
            boolean r2 = r2.contains(r6)     // Catch:{ Exception -> 0x0299 }
            if (r2 == 0) goto L_0x024b
        L_0x023e:
            java.lang.String r2 = r9.l     // Catch:{ Exception -> 0x0299 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x024b
            java.lang.String r2 = r9.l     // Catch:{ Exception -> 0x0299 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0299 }
        L_0x024b:
            int r2 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textinputlayout     // Catch:{ Exception -> 0x0299 }
            android.view.View r2 = r5.findViewById(r2)     // Catch:{ Exception -> 0x0299 }
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2     // Catch:{ Exception -> 0x0299 }
            java.lang.String r6 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            r2.setHint(r6)     // Catch:{ Exception -> 0x0299 }
            if (r0 == 0) goto L_0x0263
            r1.setInputType(r3)     // Catch:{ Exception -> 0x0299 }
            r1.setFocusableInTouchMode(r3)     // Catch:{ Exception -> 0x0299 }
            goto L_0x027e
        L_0x0263:
            java.lang.String r2 = r10.getTitle()     // Catch:{ Exception -> 0x0299 }
            if (r2 == 0) goto L_0x027e
            boolean r2 = r9.f73428d     // Catch:{ Exception -> 0x0299 }
            if (r2 != 0) goto L_0x027e
            r9.f73428d = r4     // Catch:{ Exception -> 0x0299 }
            r1.requestFocus()     // Catch:{ Exception -> 0x0299 }
            androidx.fragment.app.FragmentActivity r2 = r9.getActivity()     // Catch:{ Exception -> 0x0299 }
            android.view.Window r2 = r2.getWindow()     // Catch:{ Exception -> 0x0299 }
            r3 = 4
            r2.setSoftInputMode(r3)     // Catch:{ Exception -> 0x0299 }
        L_0x027e:
            net.one97.paytm.o2o.amusementpark.c.a.b$10 r2 = new net.one97.paytm.o2o.amusementpark.c.a.b$10     // Catch:{ Exception -> 0x0299 }
            r2.<init>(r1, r10, r0)     // Catch:{ Exception -> 0x0299 }
            r1.setOnFocusChangeListener(r2)     // Catch:{ Exception -> 0x0299 }
            net.one97.paytm.o2o.amusementpark.c.a.b$11 r2 = new net.one97.paytm.o2o.amusementpark.c.a.b$11     // Catch:{ Exception -> 0x0299 }
            r2.<init>(r1, r0)     // Catch:{ Exception -> 0x0299 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0299 }
        L_0x028e:
            if (r5 == 0) goto L_0x0298
            r5.setTag(r10)     // Catch:{ Exception -> 0x0299 }
            android.widget.LinearLayout r10 = r9.f73432h     // Catch:{ Exception -> 0x0299 }
            r10.addView(r5)     // Catch:{ Exception -> 0x0299 }
        L_0x0298:
            return
        L_0x0299:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 != 0) goto L_0x02a1
            return
        L_0x02a1:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            boolean r10 = r10.isFinishing()
            if (r10 == 0) goto L_0x02ac
            return
        L_0x02ac:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = net.one97.paytm.o2o.amusementpark.R.string.error
            java.lang.String r0 = r0.getString(r1)
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.o2o.amusementpark.R.string.unable_to_fetch_form
            java.lang.String r1 = r1.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r10, (java.lang.String) r0, (java.lang.String) r1)
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x02e4
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            boolean r10 = r10 instanceof net.one97.paytm.o2o.amusementpark.activity.AJRAmParkTravellerDetailsActivity
            if (r10 == 0) goto L_0x02e4
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            r10.finish()
        L_0x02e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.c.a.b.a(net.one97.paytm.common.entity.amPark.AmParkInputForm):void");
    }

    public void onClick(View view) {
        a(true);
    }

    /* JADX WARNING: type inference failed for: r5v19, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r19) {
        /*
            r18 = this;
            r0 = r18
            android.widget.Button r1 = r0.f73426b     // Catch:{ Exception -> 0x030b }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x030b }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x030b }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x030b }
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0011:
            int r5 = r1.getChildCount()     // Catch:{ Exception -> 0x030b }
            if (r3 >= r5) goto L_0x0293
            if (r3 == 0) goto L_0x028f
            int r5 = r1.getChildCount()     // Catch:{ Exception -> 0x030b }
            r6 = 1
            int r5 = r5 - r6
            if (r3 == r5) goto L_0x028f
            android.view.View r5 = r1.getChildAt(r3)     // Catch:{ Exception -> 0x030b }
            java.lang.Object r7 = r5.getTag()     // Catch:{ Exception -> 0x030b }
            net.one97.paytm.common.entity.amPark.AmParkInputForm r7 = (net.one97.paytm.common.entity.amPark.AmParkInputForm) r7     // Catch:{ Exception -> 0x030b }
            r8 = 8
            java.lang.String r9 = ""
            java.lang.String r10 = "Please enter a valid "
            if (r7 != 0) goto L_0x014b
            boolean r7 = r5 instanceof android.widget.LinearLayout     // Catch:{ Exception -> 0x030b }
            if (r7 == 0) goto L_0x028f
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5     // Catch:{ Exception -> 0x030b }
            r7 = 0
            if (r5 == 0) goto L_0x0049
            int r11 = r5.getChildCount()     // Catch:{ Exception -> 0x030b }
            if (r11 != r6) goto L_0x0049
            android.view.View r5 = r5.getChildAt(r2)     // Catch:{ Exception -> 0x030b }
            r7 = r5
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7     // Catch:{ Exception -> 0x030b }
        L_0x0049:
            if (r7 == 0) goto L_0x028f
            int r5 = r7.getChildCount()     // Catch:{ Exception -> 0x030b }
            r11 = 21
            if (r5 != r11) goto L_0x028f
            r5 = r4
            r4 = 0
        L_0x0055:
            int r11 = r7.getChildCount()     // Catch:{ Exception -> 0x030b }
            int r11 = r11 / 3
            if (r4 >= r11) goto L_0x0148
            int r11 = r4 * 3
            android.view.View r12 = r7.getChildAt(r11)     // Catch:{ Exception -> 0x030b }
            com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12     // Catch:{ Exception -> 0x030b }
            int r11 = r11 + 2
            android.view.View r11 = r7.getChildAt(r11)     // Catch:{ Exception -> 0x030b }
            android.widget.TextView r11 = (android.widget.TextView) r11     // Catch:{ Exception -> 0x030b }
            if (r11 == 0) goto L_0x0072
            r11.setVisibility(r8)     // Catch:{ Exception -> 0x030b }
        L_0x0072:
            android.view.View r13 = r12.getChildAt(r2)     // Catch:{ Exception -> 0x030b }
            android.widget.EditText r13 = (android.widget.EditText) r13     // Catch:{ Exception -> 0x030b }
            java.lang.Object r14 = r13.getTag()     // Catch:{ Exception -> 0x030b }
            net.one97.paytm.common.entity.amPark.AmParkInputForm r14 = (net.one97.paytm.common.entity.amPark.AmParkInputForm) r14     // Catch:{ Exception -> 0x030b }
            android.text.Editable r15 = r13.getText()     // Catch:{ Exception -> 0x030b }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x030b }
            java.lang.String r15 = r15.trim()     // Catch:{ Exception -> 0x030b }
            if (r14 == 0) goto L_0x0141
            boolean r16 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x030b }
            if (r16 == 0) goto L_0x00b4
            if (r11 == 0) goto L_0x00ae
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x030b }
            java.lang.CharSequence r17 = r12.getHint()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = r17.toString()     // Catch:{ Exception -> 0x030b }
            r6.append(r8)     // Catch:{ Exception -> 0x030b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x030b }
            r11.setText(r6)     // Catch:{ Exception -> 0x030b }
            r11.setVisibility(r2)     // Catch:{ Exception -> 0x030b }
        L_0x00ae:
            if (r5 != 0) goto L_0x00b4
            r13.requestFocus()     // Catch:{ Exception -> 0x030b }
            r5 = 1
        L_0x00b4:
            java.lang.String r6 = r14.getRegex()     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x0106
            java.lang.String r6 = r14.getRegex()     // Catch:{ Exception -> 0x030b }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x030b }
            if (r8 == 0) goto L_0x00c5
            r6 = r9
        L_0x00c5:
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = r15.trim()     // Catch:{ Exception -> 0x030b }
            java.util.regex.Matcher r6 = r6.matcher(r8)     // Catch:{ Exception -> 0x030b }
            boolean r6 = r6.matches()     // Catch:{ Exception -> 0x030b }
            if (r6 != 0) goto L_0x00fc
            r14.setApplied(r9)     // Catch:{ Exception -> 0x030b }
            if (r11 == 0) goto L_0x0141
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x030b }
            java.lang.CharSequence r8 = r12.getHint()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x030b }
            r6.append(r8)     // Catch:{ Exception -> 0x030b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x030b }
            r11.setText(r6)     // Catch:{ Exception -> 0x030b }
            r11.setVisibility(r2)     // Catch:{ Exception -> 0x030b }
            if (r5 != 0) goto L_0x0141
            r13.requestFocus()     // Catch:{ Exception -> 0x030b }
            goto L_0x012c
        L_0x00fc:
            boolean r6 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x030b }
            if (r6 != 0) goto L_0x0141
            r14.setApplied(r15)     // Catch:{ Exception -> 0x030b }
            goto L_0x0141
        L_0x0106:
            java.lang.String r6 = "Age"
            java.lang.String r8 = r14.getTitle()     // Catch:{ Exception -> 0x030b }
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x012e
            java.lang.String r6 = "0"
            boolean r6 = r15.equals(r6)     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x012e
            if (r11 == 0) goto L_0x0141
            int r6 = net.one97.paytm.o2o.amusementpark.R.string.wrong_age_input     // Catch:{ Exception -> 0x030b }
            r11.setText(r6)     // Catch:{ Exception -> 0x030b }
            r11.setVisibility(r2)     // Catch:{ Exception -> 0x030b }
            r14.setApplied(r9)     // Catch:{ Exception -> 0x030b }
            if (r5 != 0) goto L_0x0141
            r13.requestFocus()     // Catch:{ Exception -> 0x030b }
        L_0x012c:
            r5 = 1
            goto L_0x0141
        L_0x012e:
            boolean r6 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x030b }
            if (r6 != 0) goto L_0x0141
            java.lang.String r6 = r14.getAppliedData()     // Catch:{ Exception -> 0x030b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x0141
            r14.setApplied(r15)     // Catch:{ Exception -> 0x030b }
        L_0x0141:
            int r4 = r4 + 1
            r6 = 1
            r8 = 8
            goto L_0x0055
        L_0x0148:
            r4 = r5
            goto L_0x028f
        L_0x014b:
            java.lang.String r6 = r7.getType()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = "textbox"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x030b }
            if (r6 != 0) goto L_0x01e6
            java.lang.String r6 = r7.getType()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = "calendar"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x0165
            goto L_0x01e6
        L_0x0165:
            java.lang.String r6 = r7.getType()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = "textarea"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x028f
            int r6 = net.one97.paytm.o2o.amusementpark.R.id.events_booking_textarea_edittext     // Catch:{ Exception -> 0x030b }
            android.view.View r6 = r5.findViewById(r6)     // Catch:{ Exception -> 0x030b }
            android.widget.EditText r6 = (android.widget.EditText) r6     // Catch:{ Exception -> 0x030b }
            int r8 = net.one97.paytm.o2o.amusementpark.R.id.events_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x030b }
            android.view.View r5 = r5.findViewById(r8)     // Catch:{ Exception -> 0x030b }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x030b }
            r8 = 8
            r5.setVisibility(r8)     // Catch:{ Exception -> 0x030b }
            android.text.Editable r8 = r6.getText()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x030b }
            r7.setApplied(r8)     // Catch:{ Exception -> 0x030b }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x030b }
            if (r9 == 0) goto L_0x01b3
            if (r4 != 0) goto L_0x019c
            r6.requestFocus()     // Catch:{ Exception -> 0x030b }
        L_0x019c:
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x030b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030b }
            r1.<init>(r10)     // Catch:{ Exception -> 0x030b }
            java.lang.String r2 = r7.getTitle()     // Catch:{ Exception -> 0x030b }
            r1.append(r2)     // Catch:{ Exception -> 0x030b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x030b }
            r5.setText(r1)     // Catch:{ Exception -> 0x030b }
            return
        L_0x01b3:
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x028f
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x030b }
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x030b }
            java.util.regex.Matcher r6 = r6.matcher(r8)     // Catch:{ Exception -> 0x030b }
            boolean r6 = r6.matches()     // Catch:{ Exception -> 0x030b }
            if (r6 != 0) goto L_0x028f
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x030b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030b }
            r1.<init>(r10)     // Catch:{ Exception -> 0x030b }
            java.lang.String r2 = r7.getTitle()     // Catch:{ Exception -> 0x030b }
            r1.append(r2)     // Catch:{ Exception -> 0x030b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x030b }
            r5.setText(r1)     // Catch:{ Exception -> 0x030b }
            return
        L_0x01e6:
            int r6 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textinputlayout     // Catch:{ Exception -> 0x030b }
            android.view.View r6 = r5.findViewById(r6)     // Catch:{ Exception -> 0x030b }
            com.google.android.material.textfield.TextInputLayout r6 = (com.google.android.material.textfield.TextInputLayout) r6     // Catch:{ Exception -> 0x030b }
            int r8 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textview     // Catch:{ Exception -> 0x030b }
            android.view.View r8 = r5.findViewById(r8)     // Catch:{ Exception -> 0x030b }
            android.widget.EditText r8 = (android.widget.EditText) r8     // Catch:{ Exception -> 0x030b }
            int r11 = net.one97.paytm.o2o.amusementpark.R.id.parks_passenger_form_textview_error_msg     // Catch:{ Exception -> 0x030b }
            android.view.View r5 = r5.findViewById(r11)     // Catch:{ Exception -> 0x030b }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x030b }
            r11 = 8
            r5.setVisibility(r11)     // Catch:{ Exception -> 0x030b }
            android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x030b }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x030b }
            boolean r11 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x030b }
            if (r11 == 0) goto L_0x0231
            if (r4 != 0) goto L_0x021b
            r6.requestFocus()     // Catch:{ Exception -> 0x030b }
            r4 = 1
        L_0x021b:
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x030b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x030b }
            java.lang.String r11 = r7.getTitle()     // Catch:{ Exception -> 0x030b }
            r6.append(r11)     // Catch:{ Exception -> 0x030b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x030b }
            r5.setText(r6)     // Catch:{ Exception -> 0x030b }
        L_0x0231:
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x030b }
            java.lang.String r11 = "FullName"
            if (r6 != 0) goto L_0x024e
            java.lang.String r6 = r7.getId()     // Catch:{ Exception -> 0x030b }
            boolean r6 = r6.contains(r11)     // Catch:{ Exception -> 0x030b }
            if (r6 == 0) goto L_0x0244
            goto L_0x024e
        L_0x0244:
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x030b }
            if (r5 != 0) goto L_0x028f
            r7.setApplied(r8)     // Catch:{ Exception -> 0x030b }
            goto L_0x028f
        L_0x024e:
            java.lang.String r6 = r7.getRegex()     // Catch:{ Exception -> 0x030b }
            java.lang.String r12 = r7.getId()     // Catch:{ Exception -> 0x030b }
            boolean r11 = r12.contains(r11)     // Catch:{ Exception -> 0x030b }
            if (r11 == 0) goto L_0x0260
            if (r6 != 0) goto L_0x0260
            java.lang.String r6 = "[A-Z\\sa-z]+"
        L_0x0260:
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ Exception -> 0x030b }
            java.lang.String r11 = r8.trim()     // Catch:{ Exception -> 0x030b }
            java.util.regex.Matcher r6 = r6.matcher(r11)     // Catch:{ Exception -> 0x030b }
            boolean r6 = r6.matches()     // Catch:{ Exception -> 0x030b }
            if (r6 != 0) goto L_0x028c
            r7.setApplied(r9)     // Catch:{ Exception -> 0x030b }
            r5.setVisibility(r2)     // Catch:{ Exception -> 0x030b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x030b }
            java.lang.String r7 = r7.getTitle()     // Catch:{ Exception -> 0x030b }
            r6.append(r7)     // Catch:{ Exception -> 0x030b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x030b }
            r5.setText(r6)     // Catch:{ Exception -> 0x030b }
            goto L_0x028f
        L_0x028c:
            r7.setApplied(r8)     // Catch:{ Exception -> 0x030b }
        L_0x028f:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x0293:
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r1 = r0.f73425a     // Catch:{ Exception -> 0x030b }
            if (r1 == 0) goto L_0x030b
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r1 = r0.f73425a     // Catch:{ Exception -> 0x030b }
            java.util.ArrayList r1 = r1.getForm()     // Catch:{ Exception -> 0x030b }
            if (r1 == 0) goto L_0x030b
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r1 = r0.f73425a     // Catch:{ Exception -> 0x030b }
            java.util.ArrayList r1 = r1.getForm()     // Catch:{ Exception -> 0x030b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x030b }
        L_0x02a9:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x030b }
            if (r2 == 0) goto L_0x02ea
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x030b }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x030b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x030b }
        L_0x02b9:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x030b }
            if (r3 == 0) goto L_0x02a9
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x030b }
            net.one97.paytm.common.entity.amPark.AmParkInputForm r3 = (net.one97.paytm.common.entity.amPark.AmParkInputForm) r3     // Catch:{ Exception -> 0x030b }
            if (r3 == 0) goto L_0x02b9
            java.lang.String r4 = "checkbox"
            java.lang.String r5 = r3.getType()     // Catch:{ Exception -> 0x030b }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x030b }
            if (r4 != 0) goto L_0x02b9
            java.lang.String r4 = "radio"
            java.lang.String r5 = r3.getType()     // Catch:{ Exception -> 0x030b }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x030b }
            if (r4 != 0) goto L_0x02b9
            java.lang.String r3 = r3.getAppliedData()     // Catch:{ Exception -> 0x030b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x030b }
            if (r3 == 0) goto L_0x02b9
            return
        L_0x02ea:
            net.one97.paytm.o2o.amusementpark.c.a.b$a r1 = r0.f73427c     // Catch:{ Exception -> 0x030b }
            if (r1 == 0) goto L_0x030b
            if (r19 == 0) goto L_0x0304
            android.content.Context r1 = r18.getContext()     // Catch:{ Exception -> 0x030b }
            r2 = 5
            java.lang.String r3 = r18.e()     // Catch:{ Exception -> 0x030b }
            net.one97.paytm.o2o.amusementpark.utils.k.b(r1, r2, r3)     // Catch:{ Exception -> 0x030b }
            net.one97.paytm.o2o.amusementpark.c.a.b$a r1 = r0.f73427c     // Catch:{ Exception -> 0x030b }
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r2 = r0.f73425a     // Catch:{ Exception -> 0x030b }
            r1.a(r2)     // Catch:{ Exception -> 0x030b }
            return
        L_0x0304:
            net.one97.paytm.o2o.amusementpark.c.a.b$a r1 = r0.f73427c     // Catch:{ Exception -> 0x030b }
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r2 = r0.f73425a     // Catch:{ Exception -> 0x030b }
            r1.b(r2)     // Catch:{ Exception -> 0x030b }
        L_0x030b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.c.a.b.a(boolean):void");
    }

    public final void a() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    /* renamed from: net.one97.paytm.o2o.amusementpark.c.a.b$b  reason: collision with other inner class name */
    static class C1474b implements DatePickerDialog.OnDateSetListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Context> f73484a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<EditText> f73485b;

        /* renamed from: c  reason: collision with root package name */
        private Locale f73486c;

        /* renamed from: d  reason: collision with root package name */
        private String f73487d;

        public C1474b(Context context, String str, EditText editText) {
            this.f73484a = new WeakReference<>(context);
            this.f73485b = new WeakReference<>(editText);
            this.f73487d = str;
            Context context2 = (Context) this.f73484a.get();
            if (context2 != null) {
                Calendar instance = Calendar.getInstance();
                int i2 = instance.get(1);
                int i3 = instance.get(2);
                int i4 = instance.get(5);
                this.f73486c = Locale.getDefault();
                a(new Locale("en"));
                DatePickerDialog datePickerDialog = new DatePickerDialog(context2, this, i2, i3, i4);
                datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis());
                datePickerDialog.show();
            }
        }

        public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            String format = new SimpleDateFormat(TextUtils.isEmpty(this.f73487d) ? "dd MMM yyyy" : this.f73487d).format(new GregorianCalendar(i2, i3, i4).getTime());
            EditText editText = (EditText) this.f73485b.get();
            if (editText != null) {
                editText.setText(format);
            }
            a(this.f73486c);
        }

        private void a(Locale locale) {
            Context context = (Context) this.f73484a.get();
            if (context != null) {
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
            }
        }
    }

    private String e() {
        if (getArguments() == null) {
            return "";
        }
        return getArguments().getString("park_id");
    }

    static /* synthetic */ void a(b bVar, EditText editText) {
        if (editText != null && bVar.f73427c != null) {
            editText.getBottom();
            editText.getLocationOnScreen(new int[2]);
            Rect rect = new Rect();
            editText.getLocalVisibleRect(rect);
            editText.getGlobalVisibleRect(rect);
            editText.getWindowVisibleDisplayFrame(rect);
        }
    }
}
