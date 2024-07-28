package com.travel.flight.flightticket.widget;

import android.app.Activity;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.v;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.a.b;
import com.travel.flight.flightticket.f.m;
import com.travel.utils.n;
import java.util.ArrayList;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;

public final class a {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f25314i = false;
    /* access modifiers changed from: private */
    public static boolean j = false;

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f25315a = LayoutInflater.from(this.f25316b);

    /* renamed from: b  reason: collision with root package name */
    public Activity f25316b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRTpUserProfileContact> f25317c = com.travel.flight.travellerProfile.a.a().f25523b;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f25318d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayout f25319e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25320f;

    /* renamed from: g  reason: collision with root package name */
    LinearLayout f25321g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public m f25322h;

    public a(Object obj, Activity activity) {
        this.f25316b = activity;
        this.f25322h = (m) obj;
    }

    public final View a(CJRDynamicValidation cJRDynamicValidation, String str) {
        View inflate = this.f25315a.inflate(R.layout.pre_f_lyt_flight_dropdown, (ViewGroup) null);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) inflate.findViewById(R.id.baggage_icon), "baggage_ancillary.png", false, false, n.a.V1);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) inflate.findViewById(R.id.close_icon), "close_icon.png", false, false, n.a.V1);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) inflate.findViewById(R.id.child_view);
        final RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.error_text);
        if (cJRDynamicValidation.getValue() != null) {
            ((TextInputLayout) inflate.findViewById(R.id.text_input_layout)).setHint(cJRDynamicValidation.getValue());
        }
        autoCompleteTextView.setKeyListener((KeyListener) null);
        autoCompleteTextView.setTag(cJRDynamicValidation);
        autoCompleteTextView.setAdapter(new b(this.f25316b, cJRDynamicValidation.getValues()));
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                autoCompleteTextView.showDropDown();
                return false;
            }
        });
        if (cJRDynamicValidation.getValues().size() == 1) {
            autoCompleteTextView.setText(cJRDynamicValidation.getValues().get(0).getValue());
        } else if (!v.a(str)) {
            autoCompleteTextView.setText(str);
            autoCompleteTextView.setTypeface(Typeface.create("sans-serif-medium", 0));
            autoCompleteTextView.setTextSize(2, 17.0f);
        }
        final AutoCompleteTextView autoCompleteTextView2 = autoCompleteTextView;
        final CJRDynamicValidation cJRDynamicValidation2 = cJRDynamicValidation;
        final View view = inflate;
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                roboTextView.setVisibility(8);
                roboTextView.setText((CharSequence) null);
                autoCompleteTextView2.setText(cJRDynamicValidation2.getValues().get(i2).getValue());
                autoCompleteTextView2.setTypeface(Typeface.create("sans-serif-medium", 0));
                autoCompleteTextView2.setTextSize(2, 17.0f);
                a.this.f25322h.a(cJRDynamicValidation2.getKey(), cJRDynamicValidation2.getValues().get(i2).getValue(), view);
            }
        });
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence == null || charSequence.toString().length() != 0) {
                    autoCompleteTextView.setTypeface(Typeface.create("sans-serif-medium", 0));
                    autoCompleteTextView.setTextSize(2, 17.0f);
                    return;
                }
                autoCompleteTextView.setTypeface(Typeface.create("sans-serif-light", 0));
                autoCompleteTextView.setTextSize(2, 15.0f);
            }
        });
        return inflate;
    }

    public final View b(final CJRDynamicValidation cJRDynamicValidation, String str) {
        try {
            View inflate = this.f25315a.inflate(R.layout.pre_f_flight_pax_edittext, (ViewGroup) null);
            final RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.error_text);
            if (cJRDynamicValidation.getValue() != null) {
                ((TextInputLayout) inflate.findViewById(R.id.text_input_layout)).setHint(cJRDynamicValidation.getValue());
            }
            final EditText editText = (EditText) inflate.findViewById(R.id.child_view);
            if (cJRDynamicValidation.getMinLength() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(cJRDynamicValidation.getMinLength());
                TextUtils.isEmpty(sb.toString());
            }
            if (cJRDynamicValidation.getMaxLength() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cJRDynamicValidation.getMaxLength());
                if (!TextUtils.isEmpty(sb2.toString())) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cJRDynamicValidation.getMaxLength().intValue())});
                }
            }
            editText.setTag(cJRDynamicValidation);
            if (!v.a(str)) {
                editText.setText(str);
                editText.setTypeface(Typeface.create("sans-serif-medium", 0));
                editText.setTextSize(2, 17.0f);
            }
            editText.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    net.one97.paytmflight.common.b.a.a(a.this.f25316b);
                    return false;
                }
            });
            editText.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    roboTextView.setVisibility(8);
                    roboTextView.setText((CharSequence) null);
                    int abs = Math.abs(i4 - i3);
                    boolean z = true;
                    if (abs != 1) {
                        z = false;
                    }
                    if (z) {
                        a.this.f25322h.a(cJRDynamicValidation.getKey(), charSequence.toString());
                    }
                    if (charSequence == null || charSequence.toString().length() != 0) {
                        editText.setTypeface(Typeface.create("sans-serif-medium", 0));
                        editText.setTextSize(2, 17.0f);
                        return;
                    }
                    editText.setTypeface(Typeface.create("sans-serif-light", 0));
                    editText.setTextSize(2, 15.0f);
                }
            });
            return inflate;
        } catch (Exception unused) {
            return null;
        }
    }

    public static ArrayList<CJRTpUserProfileContact> a(String str, ArrayList<CJRTpUserProfileContact> arrayList) {
        ArrayList<CJRTpUserProfileContact> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            int i2 = 0;
            while (i2 < arrayList.size()) {
                try {
                    int a2 = a(arrayList.get(i2).getDob(), arrayList.get(i2).getTravelDate());
                    if (a2 >= 0) {
                        if (!"Adult".equalsIgnoreCase(str) || a2 < 12 || arrayList.get(i2).getTitle().equals("Mstr")) {
                            if ("Child".equalsIgnoreCase(str) && a2 >= 2 && a2 < 12) {
                                if (!arrayList.get(i2).getTitle().equals("Mr") && !arrayList.get(i2).getTitle().equals("Mrs")) {
                                    arrayList2.add(arrayList.get(i2));
                                }
                            }
                            if ("Infant".equalsIgnoreCase(str) && a2 < 2 && !arrayList.get(i2).getTitle().equals("Mr") && !arrayList.get(i2).getTitle().equals("Mrs")) {
                                arrayList2.add(arrayList.get(i2));
                            }
                        } else {
                            arrayList2.add(arrayList.get(i2));
                        }
                    }
                    i2++;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList2;
    }

    private static int a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 12;
            }
            String f2 = com.paytm.utility.b.f(str, "dd/MM/yyyy", "yyyy-MM-dd");
            if (TextUtils.isEmpty(f2)) {
                return -1;
            }
            int parseInt = Integer.parseInt(f2.substring(0, 4));
            int parseInt2 = Integer.parseInt(f2.substring(5, 7));
            int parseInt3 = Integer.parseInt(f2.substring(8, 10));
            int parseInt4 = Integer.parseInt(str2.substring(0, 4));
            int parseInt5 = Integer.parseInt(str2.substring(5, 7));
            int i2 = parseInt4 - parseInt;
            return (parseInt5 < parseInt2 || (parseInt5 == parseInt2 && Integer.parseInt(str2.substring(8, 10)) < parseInt3)) ? i2 - 1 : i2;
        } catch (Exception unused) {
            return -1;
        }
    }

    public final View a() {
        try {
            f25314i = true;
            View inflate = this.f25315a.inflate(R.layout.pre_f_flight_frequent_flyer_item, (ViewGroup) null);
            ((CheckBox) inflate.findViewById(R.id.checkbox_ff)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    boolean unused = a.j = z;
                    a aVar = a.this;
                    if (!(aVar.f25318d == null || aVar.f25319e == null)) {
                        if (z) {
                            aVar.f25318d.setVisibility(0);
                            aVar.f25319e.setVisibility(0);
                        } else {
                            aVar.f25318d.setVisibility(8);
                            aVar.f25319e.setVisibility(8);
                        }
                    }
                    if (aVar.f25321g != null && aVar.f25320f != null) {
                        if (z) {
                            aVar.f25320f.setVisibility(0);
                            aVar.f25321g.setVisibility(0);
                            return;
                        }
                        aVar.f25320f.setVisibility(8);
                        aVar.f25321g.setVisibility(8);
                    }
                }
            });
            return inflate;
        } catch (Exception unused) {
            return null;
        }
    }

    public final View a(final CJRDynamicValidation cJRDynamicValidation, String str, boolean z) {
        try {
            View inflate = this.f25315a.inflate(R.layout.pre_f_flight_pax_edittext, (ViewGroup) null);
            this.f25319e = (LinearLayout) inflate.findViewById(R.id.ff_number_lyt);
            final RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.error_text);
            if (cJRDynamicValidation.getValue() != null) {
                ((TextInputLayout) inflate.findViewById(R.id.text_input_layout)).setHint(cJRDynamicValidation.getValue());
            }
            final EditText editText = (EditText) inflate.findViewById(R.id.child_view);
            if (cJRDynamicValidation.getMinLength() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(cJRDynamicValidation.getMinLength());
                TextUtils.isEmpty(sb.toString());
            }
            if (z) {
                editText.setInputType(2);
            }
            if (cJRDynamicValidation.getMaxLength() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cJRDynamicValidation.getMaxLength());
                if (!TextUtils.isEmpty(sb2.toString())) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cJRDynamicValidation.getMaxLength().intValue())});
                }
            }
            editText.setTag(cJRDynamicValidation);
            if (!v.a(str)) {
                editText.setText(str);
            }
            editText.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    net.one97.paytmflight.common.b.a.a(a.this.f25316b);
                    return false;
                }
            });
            editText.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    roboTextView.setVisibility(8);
                    roboTextView.setText((CharSequence) null);
                    int abs = Math.abs(i4 - i3);
                    boolean z = true;
                    if (abs != 1) {
                        z = false;
                    }
                    if (z) {
                        a.this.f25322h.a(cJRDynamicValidation.getKey(), charSequence.toString());
                    }
                    if (charSequence == null || charSequence.toString().length() != 0) {
                        editText.setTypeface(Typeface.create("sans-serif-medium", 0));
                        editText.setTextSize(2, 17.0f);
                        return;
                    }
                    editText.setTypeface(Typeface.create("sans-serif-light", 0));
                    editText.setTextSize(2, 15.0f);
                }
            });
            this.f25319e.setVisibility(8);
            return inflate;
        } catch (Exception unused) {
            return null;
        }
    }

    public final View b(final CJRDynamicValidation cJRDynamicValidation, String str, boolean z) {
        try {
            View inflate = this.f25315a.inflate(R.layout.pre_f_flight_pax_edittext, (ViewGroup) null);
            this.f25321g = (LinearLayout) inflate.findViewById(R.id.ff_number_lyt);
            final RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.error_text);
            if (cJRDynamicValidation.getValue() != null) {
                ((TextInputLayout) inflate.findViewById(R.id.text_input_layout)).setHint(cJRDynamicValidation.getValue());
            }
            final EditText editText = (EditText) inflate.findViewById(R.id.child_view);
            if (cJRDynamicValidation.getMinLength() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(cJRDynamicValidation.getMinLength());
                TextUtils.isEmpty(sb.toString());
            }
            if (z) {
                editText.setInputType(2);
            }
            if (cJRDynamicValidation.getMaxLength() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cJRDynamicValidation.getMaxLength());
                if (!TextUtils.isEmpty(sb2.toString())) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(cJRDynamicValidation.getMaxLength().intValue())});
                }
            }
            editText.setTag(cJRDynamicValidation);
            if (!v.a(str)) {
                editText.setText(str);
            }
            editText.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    net.one97.paytmflight.common.b.a.a(a.this.f25316b);
                    return false;
                }
            });
            editText.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    roboTextView.setVisibility(8);
                    roboTextView.setText((CharSequence) null);
                    int abs = Math.abs(i4 - i3);
                    boolean z = true;
                    if (abs != 1) {
                        z = false;
                    }
                    if (z) {
                        a.this.f25322h.a(cJRDynamicValidation.getKey(), charSequence.toString());
                    }
                    if (charSequence == null || charSequence.toString().length() != 0) {
                        editText.setTypeface(Typeface.create("sans-serif-medium", 0));
                        editText.setTextSize(2, 17.0f);
                        return;
                    }
                    editText.setTypeface(Typeface.create("sans-serif-light", 0));
                    editText.setTextSize(2, 15.0f);
                }
            });
            this.f25321g.setVisibility(8);
            return inflate;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        return f25314i;
    }

    public static void c() {
        f25314i = false;
    }

    public static boolean d() {
        return j;
    }
}
