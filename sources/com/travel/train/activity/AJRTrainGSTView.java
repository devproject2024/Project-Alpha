package com.travel.train.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.paytm.utility.RoboTextView;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.x;
import com.travel.train.j.c;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRCountryCodeList;
import com.travel.train.model.trainticket.CJRCountryList;
import com.travel.train.model.trainticket.CJRIRCTCUserAvailability;
import com.travel.train.model.trainticket.CJRIRCTCUserRegister;
import com.travel.train.model.trainticket.CJRPincodeResponse;
import com.travel.train.model.trainticket.CJRTrainGstDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.widgets.CJRFloatingLabel;

public class AJRTrainGSTView extends CJRTrainBaseActivity implements View.OnClickListener, c.a {
    /* access modifiers changed from: private */
    public boolean A = false;
    private boolean B = false;
    private boolean C = false;
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public String E;
    /* access modifiers changed from: private */
    public String F;
    private View.OnClickListener G = new View.OnClickListener() {
        public final void onClick(View view) {
            int id = view.getId();
            if (id == R.id.gst_number_clear) {
                if (AJRTrainGSTView.this.k != null) {
                    AJRTrainGSTView.this.k.setText((CharSequence) "");
                    AJRTrainGSTView.this.u.setVisibility(8);
                }
            } else if (id == R.id.gst_company_clear) {
                if (AJRTrainGSTView.this.l != null) {
                    AJRTrainGSTView.this.l.setText((CharSequence) "");
                    AJRTrainGSTView.this.v.setVisibility(8);
                }
            } else if (id == R.id.gst_flat_clear) {
                if (AJRTrainGSTView.this.m != null) {
                    AJRTrainGSTView.this.m.setText((CharSequence) "");
                    AJRTrainGSTView.this.w.setVisibility(8);
                }
            } else if (id == R.id.gst_street_clear) {
                if (AJRTrainGSTView.this.n != null) {
                    AJRTrainGSTView.this.n.setText((CharSequence) "");
                    AJRTrainGSTView.this.x.setVisibility(8);
                }
            } else if (id == R.id.gst_pincode_clear && AJRTrainGSTView.this.o != null) {
                AJRTrainGSTView.this.o.setText((CharSequence) "");
                AJRTrainGSTView.this.y.setVisibility(8);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private CJRTrainGstDetails f25967a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRPincodeResponse.CJRCities> f25968b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ImageView f25969c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f25970d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f25971e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f25972f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f25973g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f25974h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJRFloatingLabel f25975i;
    private LinearLayout j;
    /* access modifiers changed from: private */
    public CJRFloatingLabel k;
    /* access modifiers changed from: private */
    public CJRFloatingLabel l;
    /* access modifiers changed from: private */
    public CJRFloatingLabel m;
    /* access modifiers changed from: private */
    public CJRFloatingLabel n;
    /* access modifiers changed from: private */
    public CJRFloatingLabel o;
    /* access modifiers changed from: private */
    public CJRFloatingLabel p;
    /* access modifiers changed from: private */
    public RoboTextView q;
    /* access modifiers changed from: private */
    public RelativeLayout r;
    /* access modifiers changed from: private */
    public RelativeLayout s;
    /* access modifiers changed from: private */
    public Spinner t;
    /* access modifiers changed from: private */
    public TextView u;
    /* access modifiers changed from: private */
    public TextView v;
    /* access modifiers changed from: private */
    public TextView w;
    /* access modifiers changed from: private */
    public TextView x;
    /* access modifiers changed from: private */
    public TextView y;
    private Button z;

    public final void a() {
    }

    public final void a(CJRCountryCodeList cJRCountryCodeList) {
    }

    public final void a(CJRCountryList cJRCountryList) {
    }

    public final void a(CJRIRCTCUserAvailability cJRIRCTCUserAvailability) {
    }

    public final void a(CJRIRCTCUserRegister cJRIRCTCUserRegister) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.train_gst_view_layout);
        if (getIntent() != null) {
            if (getIntent().hasExtra("train_gst_data")) {
                this.f25967a = (CJRTrainGstDetails) getIntent().getSerializableExtra("train_gst_data");
            }
            if (getIntent().hasExtra("is_from_quick_book")) {
                this.B = getIntent().getBooleanExtra("is_from_quick_book", false);
            }
            if (getIntent().hasExtra("intent_extra_board_station")) {
                this.D = getIntent().getStringExtra("intent_extra_board_station");
            }
            if (getIntent().hasExtra("intent_extra_dest_station")) {
                this.D = getIntent().getStringExtra("intent_extra_dest_station");
            }
            if (getIntent().hasExtra("intent_extra_date")) {
                this.D = getIntent().getStringExtra("intent_extra_date");
            }
        }
        setSupportActionBar((Toolbar) findViewById(R.id.train_review_toolbar));
        getSupportActionBar().c(false);
        TextView textView = (TextView) findViewById(R.id.train_toolbar_reset_text);
        ((TextView) findViewById(R.id.train_toolbar_title)).setText(getResources().getString(R.string.train_gst_details));
        textView.setVisibility(0);
        ((ImageView) findViewById(R.id.train_toolbar_back_arrow)).setOnClickListener(this);
        textView.setOnClickListener(this);
        this.j = (LinearLayout) findViewById(R.id.gst_container_lyt);
        this.k = (CJRFloatingLabel) findViewById(R.id.gstin_edit_text);
        this.k.setHintText(getResources().getString(R.string.train_enter_gstin_hint_text));
        this.f25969c = (ImageView) findViewById(R.id.gst_number_clear);
        this.f25969c.setOnClickListener(this.G);
        this.l = (CJRFloatingLabel) findViewById(R.id.gst_name_edit_text);
        this.l.setHintText(getResources().getString(R.string.train_enter_name_hint_text));
        this.f25970d = (ImageView) findViewById(R.id.gst_company_clear);
        this.f25970d.setOnClickListener(this.G);
        this.f25971e = (ImageView) findViewById(R.id.gst_flat_clear);
        this.f25971e.setOnClickListener(this.G);
        this.f25972f = (ImageView) findViewById(R.id.gst_street_clear);
        this.f25972f.setOnClickListener(this.G);
        this.f25973g = (ImageView) findViewById(R.id.gst_pincode_clear);
        this.f25973g.setOnClickListener(this.G);
        this.m = (CJRFloatingLabel) findViewById(R.id.flat_edit_text);
        this.m.setHintText(getResources().getString(R.string.train_enter_flat_hint_text));
        this.n = (CJRFloatingLabel) findViewById(R.id.street_edit_text);
        this.n.setHintText(getResources().getString(R.string.train_enter_street_hint_text));
        this.o = (CJRFloatingLabel) findViewById(R.id.pincode_edit_text);
        this.o.setHintText(getResources().getString(R.string.train_enter_pincode_hint_text));
        this.r = (RelativeLayout) findViewById(R.id.state_container);
        this.p = (CJRFloatingLabel) findViewById(R.id.state_edit_text);
        this.p.setHintText(getResources().getString(R.string.train_state_hint_text));
        this.f25974h = (RelativeLayout) findViewById(R.id.city_con);
        this.f25975i = (CJRFloatingLabel) findViewById(R.id.city_edit);
        this.f25975i.setHintText("City/Town");
        this.s = (RelativeLayout) findViewById(R.id.city_container);
        this.q = (RoboTextView) findViewById(R.id.city_label_view);
        this.t = (Spinner) findViewById(R.id.city_town);
        this.z = (Button) findViewById(R.id.save_button);
        this.z.setOnClickListener(this);
        this.s.setVisibility(8);
        this.r.setVisibility(8);
        this.f25974h.setVisibility(8);
        this.u = (TextView) findViewById(R.id.gstin_error);
        this.v = (TextView) findViewById(R.id.gst_name_error);
        this.w = (TextView) findViewById(R.id.flat_error);
        this.x = (TextView) findViewById(R.id.street_error);
        this.y = (TextView) findViewById(R.id.pincode_error);
        b();
        a(getResources().getString(R.string.select_city), this.t);
        this.t.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                if (!AJRTrainGSTView.this.A || AJRTrainGSTView.this.q == null || AJRTrainGSTView.this.q.getVisibility() != 8) {
                    boolean unused = AJRTrainGSTView.this.A = true;
                    return;
                }
                AJRTrainGSTView.this.s.setVisibility(0);
                AJRTrainGSTView.this.q.setVisibility(0);
            }
        });
        this.k.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                o.a("train_traveller_details", AJRTrainGSTView.this.D, AJRTrainGSTView.this.E, AJRTrainGSTView.this.F, (String) null, (String) null, (String) null, "gst_details_added", "/trains/traveller-details", AJRTrainGSTView.this, (Map<String, Object>) null);
                if (charSequence.length() > 0) {
                    AJRTrainGSTView.this.f25969c.setVisibility(0);
                    AJRTrainGSTView.this.u.setVisibility(8);
                } else {
                    AJRTrainGSTView.this.f25969c.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.train_enter_gstin_hint_text : R.string.train_gstin_hint_text;
                if (AJRTrainGSTView.this.k != null) {
                    AJRTrainGSTView.this.k.setHintText(i2);
                }
            }
        };
        this.l.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRTrainGSTView.this.f25970d.setVisibility(0);
                    AJRTrainGSTView.this.v.setVisibility(8);
                } else {
                    AJRTrainGSTView.this.f25970d.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.train_enter_name_hint_text : R.string.train_name_hint_text;
                if (AJRTrainGSTView.this.l != null) {
                    AJRTrainGSTView.this.l.setHintText(i2);
                }
            }
        };
        this.m.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRTrainGSTView.this.f25971e.setVisibility(0);
                    AJRTrainGSTView.this.w.setVisibility(8);
                } else {
                    AJRTrainGSTView.this.f25971e.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.train_enter_flat_hint_text : R.string.train_flat_hint_text;
                if (AJRTrainGSTView.this.m != null) {
                    AJRTrainGSTView.this.m.setHintText(i2);
                }
            }
        };
        this.n.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.length() > 0) {
                    AJRTrainGSTView.this.f25972f.setVisibility(0);
                    AJRTrainGSTView.this.x.setVisibility(8);
                } else {
                    AJRTrainGSTView.this.f25972f.setVisibility(8);
                }
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.train_enter_street_hint_text : R.string.train_street_hint_text;
                if (AJRTrainGSTView.this.n != null) {
                    AJRTrainGSTView.this.n.setHintText(i2);
                }
            }
        };
        this.o.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                int i2 = (charSequence == null || charSequence.length() == 0) ? R.string.train_enter_pincode_hint_text : R.string.train_pincode_hint_text;
                if (AJRTrainGSTView.this.o != null) {
                    AJRTrainGSTView.this.o.setHintText(i2);
                }
                if (charSequence.length() > 0) {
                    AJRTrainGSTView.this.f25973g.setVisibility(0);
                    AJRTrainGSTView.this.y.setVisibility(8);
                } else {
                    AJRTrainGSTView.this.f25973g.setVisibility(8);
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    String charSequence2 = charSequence.toString();
                    if (charSequence2 == null || charSequence2.length() != 6) {
                        AJRTrainGSTView.this.r.setVisibility(8);
                        AJRTrainGSTView.this.f25974h.setVisibility(8);
                        AJRTrainGSTView.this.f25975i.setText((CharSequence) "");
                        AJRTrainGSTView.this.p.setText((CharSequence) "");
                        AJRTrainGSTView.this.s.setVisibility(8);
                        AJRTrainGSTView aJRTrainGSTView = AJRTrainGSTView.this;
                        aJRTrainGSTView.a(aJRTrainGSTView.getResources().getString(R.string.select_city), AJRTrainGSTView.this.t);
                        return;
                    }
                    AJRTrainGSTView aJRTrainGSTView2 = AJRTrainGSTView.this;
                    aJRTrainGSTView2.showProgressDialog(aJRTrainGSTView2, aJRTrainGSTView2.getResources().getString(R.string.pp_please_wait));
                    AJRTrainGSTView aJRTrainGSTView3 = AJRTrainGSTView.this;
                    c cVar = new c(aJRTrainGSTView3, aJRTrainGSTView3);
                    o.a((Activity) AJRTrainGSTView.this);
                    cVar.a(charSequence2);
                    return;
                }
                AJRTrainGSTView.this.r.setVisibility(8);
                AJRTrainGSTView.this.p.setText((CharSequence) "");
                AJRTrainGSTView.this.f25974h.setVisibility(8);
                AJRTrainGSTView.this.f25975i.setText((CharSequence) "");
                AJRTrainGSTView.this.s.setVisibility(8);
                AJRTrainGSTView aJRTrainGSTView4 = AJRTrainGSTView.this;
                aJRTrainGSTView4.a(aJRTrainGSTView4.getResources().getString(R.string.select_city), AJRTrainGSTView.this.t);
            }
        };
        CJRTrainGstDetails cJRTrainGstDetails = this.f25967a;
        if (cJRTrainGstDetails != null) {
            if (!TextUtils.isEmpty(cJRTrainGstDetails.getGstIn())) {
                this.k.setText((CharSequence) this.f25967a.getGstIn());
            }
            if (!TextUtils.isEmpty(this.f25967a.getNameOnGst())) {
                this.l.setText((CharSequence) this.f25967a.getNameOnGst());
            }
            if (!TextUtils.isEmpty(this.f25967a.getFlat())) {
                this.m.setText((CharSequence) this.f25967a.getFlat());
            }
            if (!TextUtils.isEmpty(this.f25967a.getStreet())) {
                this.n.setText((CharSequence) this.f25967a.getStreet());
            }
            if (!TextUtils.isEmpty(this.f25967a.getPin())) {
                this.o.setText((CharSequence) this.f25967a.getPin());
            }
        }
    }

    private void b() {
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
    }

    public final void a(String str, Spinner spinner) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        spinner.setAdapter(new ArrayAdapter(this, R.layout.pre_t_train_spinner_item, arrayList));
        spinner.setEnabled(false);
    }

    private void c() {
        List<CJRPincodeResponse.CJRCities> list = this.f25968b;
        if (list != null && list.size() > 1 && !TextUtils.isEmpty(this.f25967a.getCity()) && this.B) {
            int i2 = 1;
            while (i2 < this.f25968b.size() + 1) {
                if (this.t.getItemAtPosition(i2) == null || !this.t.getItemAtPosition(i2).toString().equalsIgnoreCase(this.f25967a.getCity().trim())) {
                    i2++;
                } else {
                    this.t.setSelection(i2);
                    return;
                }
            }
        }
    }

    public final void a(CJRPincodeResponse cJRPincodeResponse) {
        this.A = false;
        removeProgressDialog();
        if (cJRPincodeResponse != null && cJRPincodeResponse.getPincodeBody() != null) {
            this.r.setVisibility(0);
            this.s.setVisibility(0);
            if (cJRPincodeResponse.getPincodeBody().getState() != null) {
                this.p.setFocusable(false);
                this.p.setEdittextEditable(false);
                this.p.setText((CharSequence) cJRPincodeResponse.getPincodeBody().getState());
            }
            this.f25968b = cJRPincodeResponse.getPincodeBody().getCityList();
            List<CJRPincodeResponse.CJRCities> list = this.f25968b;
            if (list != null && list.size() > 0) {
                this.C = false;
                this.f25974h.setVisibility(8);
                this.s.setVisibility(0);
                Spinner spinner = this.t;
                if (spinner != null) {
                    spinner.setEnabled(true);
                    ArrayList arrayList = new ArrayList();
                    for (CJRPincodeResponse.CJRCities next : this.f25968b) {
                        if (!(next == null || next.getCityName() == null)) {
                            arrayList.add(next.getCityName());
                        }
                    }
                    this.t.setAdapter(new x(R.layout.pre_t_train_city_item_layout, this, arrayList, this, getResources().getString(R.string.select_city)));
                    if (this.f25968b.size() == 1) {
                        this.t.setSelection(1);
                        this.t.setEnabled(false);
                    }
                    c();
                }
            }
        }
    }

    public void onBackPressed() {
        o.a((Activity) this);
        super.onBackPressed();
    }

    private void d() {
        String str;
        Intent intent = new Intent();
        CJRTrainGstDetails cJRTrainGstDetails = new CJRTrainGstDetails();
        CJRFloatingLabel cJRFloatingLabel = this.k;
        if (cJRFloatingLabel == null || cJRFloatingLabel.getEditText() == null || this.k.getEditText().getText() == null || TextUtils.isEmpty(this.k.getEditText().getText().toString().trim())) {
            cJRTrainGstDetails.setGstIn("");
        } else {
            cJRTrainGstDetails.setGstIn(this.k.getEditText().getText().toString().trim());
        }
        CJRFloatingLabel cJRFloatingLabel2 = this.l;
        if (cJRFloatingLabel2 == null || cJRFloatingLabel2.getEditText() == null || this.l.getEditText().getText() == null || TextUtils.isEmpty(this.l.getEditText().getText().toString().trim())) {
            cJRTrainGstDetails.setNameOnGst("");
        } else {
            cJRTrainGstDetails.setNameOnGst(this.l.getEditText().getText().toString().trim());
        }
        CJRFloatingLabel cJRFloatingLabel3 = this.m;
        if (cJRFloatingLabel3 == null || cJRFloatingLabel3.getEditText() == null || this.m.getEditText().getText() == null || TextUtils.isEmpty(this.m.getEditText().getText().toString().trim())) {
            cJRTrainGstDetails.setFlat("");
        } else {
            cJRTrainGstDetails.setFlat(this.m.getEditText().getText().toString().trim());
        }
        CJRFloatingLabel cJRFloatingLabel4 = this.n;
        if (cJRFloatingLabel4 == null || cJRFloatingLabel4.getEditText() == null || this.n.getEditText().getText() == null || TextUtils.isEmpty(this.n.getEditText().getText().toString().trim())) {
            cJRTrainGstDetails.setStreet("");
        } else {
            cJRTrainGstDetails.setStreet(this.n.getEditText().getText().toString().trim());
        }
        CJRFloatingLabel cJRFloatingLabel5 = this.o;
        if (cJRFloatingLabel5 == null || cJRFloatingLabel5.getEditText() == null || this.o.getEditText().getText() == null || TextUtils.isEmpty(this.o.getEditText().getText().toString().trim())) {
            cJRTrainGstDetails.setPin("");
        } else {
            cJRTrainGstDetails.setPin(this.o.getEditText().getText().toString().trim());
        }
        CJRFloatingLabel cJRFloatingLabel6 = this.p;
        if (cJRFloatingLabel6 == null || cJRFloatingLabel6.getEditText() == null || this.p.getEditText().getText() == null || TextUtils.isEmpty(this.p.getEditText().getText().toString().trim())) {
            cJRTrainGstDetails.setState("");
        } else {
            cJRTrainGstDetails.setState(this.p.getEditText().getText().toString().trim());
        }
        Spinner spinner = this.t;
        if (spinner == null || spinner.getSelectedItem() == null) {
            str = "";
        } else {
            str = (String) this.t.getSelectedItem();
        }
        if (str == null || str.equalsIgnoreCase(getResources().getString(R.string.select_city))) {
            cJRTrainGstDetails.setCity("");
        } else {
            cJRTrainGstDetails.setCity(str);
        }
        intent.putExtra("train_gst_data", cJRTrainGstDetails);
        setResult(-1, intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0264  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r8 = r8.getId()
            int r0 = com.travel.train.R.id.train_toolbar_back_arrow
            if (r8 != r0) goto L_0x000c
            r7.onBackPressed()
            return
        L_0x000c:
            int r0 = com.travel.train.R.id.train_toolbar_reset_text
            if (r8 != r0) goto L_0x0094
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.k
            r0 = 0
            if (r8 == 0) goto L_0x0020
            android.widget.EditText r8 = r8.getEditText()
            if (r8 == 0) goto L_0x0020
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.k
            r8.setText((java.lang.CharSequence) r0)
        L_0x0020:
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.l
            if (r8 == 0) goto L_0x002f
            android.widget.EditText r8 = r8.getEditText()
            if (r8 == 0) goto L_0x002f
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.l
            r8.setText((java.lang.CharSequence) r0)
        L_0x002f:
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.m
            if (r8 == 0) goto L_0x003e
            android.widget.EditText r8 = r8.getEditText()
            if (r8 == 0) goto L_0x003e
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.m
            r8.setText((java.lang.CharSequence) r0)
        L_0x003e:
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.n
            if (r8 == 0) goto L_0x004d
            android.widget.EditText r8 = r8.getEditText()
            if (r8 == 0) goto L_0x004d
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.n
            r8.setText((java.lang.CharSequence) r0)
        L_0x004d:
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.o
            if (r8 == 0) goto L_0x005c
            android.widget.EditText r8 = r8.getEditText()
            if (r8 == 0) goto L_0x005c
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.o
            r8.setText((java.lang.CharSequence) r0)
        L_0x005c:
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.p
            if (r8 == 0) goto L_0x006b
            android.widget.EditText r8 = r8.getEditText()
            if (r8 == 0) goto L_0x006b
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.n
            r8.setText((java.lang.CharSequence) r0)
        L_0x006b:
            android.widget.Spinner r8 = r7.t
            if (r8 == 0) goto L_0x008d
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.travel.train.b.x r8 = new com.travel.train.b.x
            int r1 = com.travel.train.R.layout.pre_t_train_city_item_layout
            android.content.res.Resources r0 = r7.getResources()
            int r2 = com.travel.train.R.string.select_city
            java.lang.String r5 = r0.getString(r2)
            r0 = r8
            r2 = r7
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            android.widget.Spinner r0 = r7.t
            r0.setAdapter(r8)
        L_0x008d:
            r7.b()
            r7.d()
            return
        L_0x0094:
            int r0 = com.travel.train.R.id.save_button
            if (r8 != r0) goto L_0x02ae
            com.travel.train.j.o.a((android.app.Activity) r7)
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.k
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L_0x00be
            java.lang.CharSequence r8 = r8.getText()
            if (r8 == 0) goto L_0x00be
            net.one97.paytm.common.widgets.CJRFloatingLabel r8 = r7.k
            java.lang.CharSequence r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.trim()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r8 = 1
            goto L_0x00d3
        L_0x00be:
            android.widget.TextView r8 = r7.u
            android.content.res.Resources r2 = r7.getResources()
            int r3 = com.travel.train.R.string.gst_mandatory_error
            java.lang.String r2 = r2.getString(r3)
            r8.setText(r2)
            android.widget.TextView r8 = r7.u
            r8.setVisibility(r1)
            r8 = 0
        L_0x00d3:
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.l
            java.lang.String r3 = "[a-zA-Z0-9]*"
            if (r2 == 0) goto L_0x0161
            java.lang.CharSequence r2 = r2.getText()
            if (r2 == 0) goto L_0x0161
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.l
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0161
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.l
            android.widget.EditText r2 = r2.getEditText()
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r3)
            java.util.regex.Matcher r4 = r4.matcher(r2)
            int r5 = r2.length()
            r6 = 3
            if (r5 >= r6) goto L_0x0129
            android.widget.TextView r8 = r7.v
            android.content.res.Resources r5 = r7.getResources()
            int r6 = com.travel.train.R.string.gst_name_min_character_error
            java.lang.String r5 = r5.getString(r6)
            r8.setText(r5)
            android.widget.TextView r8 = r7.v
            r8.setVisibility(r1)
            r8 = 0
        L_0x0129:
            int r2 = r2.length()
            r5 = 30
            if (r2 <= r5) goto L_0x0146
            android.widget.TextView r8 = r7.v
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.travel.train.R.string.gst_name_max_character_error
            java.lang.String r2 = r2.getString(r4)
            r8.setText(r2)
            android.widget.TextView r8 = r7.v
            r8.setVisibility(r1)
            goto L_0x0175
        L_0x0146:
            boolean r2 = r4.matches()
            if (r2 != 0) goto L_0x0176
            android.widget.TextView r8 = r7.v
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.travel.train.R.string.gst_special_char_error
            java.lang.String r2 = r2.getString(r4)
            r8.setText(r2)
            android.widget.TextView r8 = r7.v
            r8.setVisibility(r1)
            goto L_0x0175
        L_0x0161:
            android.widget.TextView r8 = r7.v
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.travel.train.R.string.gst_mandatory_error
            java.lang.String r2 = r2.getString(r4)
            r8.setText(r2)
            android.widget.TextView r8 = r7.v
            r8.setVisibility(r1)
        L_0x0175:
            r8 = 0
        L_0x0176:
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.m
            if (r2 == 0) goto L_0x01c9
            java.lang.CharSequence r2 = r2.getText()
            if (r2 == 0) goto L_0x01c9
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.m
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01c9
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.m
            android.widget.EditText r2 = r2.getEditText()
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r3)
            java.util.regex.Matcher r2 = r4.matcher(r2)
            boolean r2 = r2.matches()
            if (r2 != 0) goto L_0x01de
            android.widget.TextView r8 = r7.w
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.travel.train.R.string.gst_special_char_error
            java.lang.String r2 = r2.getString(r4)
            r8.setText(r2)
            android.widget.TextView r8 = r7.w
            r8.setVisibility(r1)
            goto L_0x01dd
        L_0x01c9:
            android.widget.TextView r8 = r7.w
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.travel.train.R.string.gst_mandatory_error
            java.lang.String r2 = r2.getString(r4)
            r8.setText(r2)
            android.widget.TextView r8 = r7.w
            r8.setVisibility(r1)
        L_0x01dd:
            r8 = 0
        L_0x01de:
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.n
            if (r2 == 0) goto L_0x0231
            java.lang.CharSequence r2 = r2.getText()
            if (r2 == 0) goto L_0x0231
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.n
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0231
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.n
            android.widget.EditText r2 = r2.getEditText()
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)
            java.util.regex.Matcher r2 = r3.matcher(r2)
            boolean r2 = r2.matches()
            if (r2 != 0) goto L_0x0246
            android.widget.TextView r8 = r7.x
            android.content.res.Resources r2 = r7.getResources()
            int r3 = com.travel.train.R.string.gst_special_char_error
            java.lang.String r2 = r2.getString(r3)
            r8.setText(r2)
            android.widget.TextView r8 = r7.x
            r8.setVisibility(r1)
            goto L_0x0245
        L_0x0231:
            android.widget.TextView r8 = r7.x
            android.content.res.Resources r2 = r7.getResources()
            int r3 = com.travel.train.R.string.gst_mandatory_error
            java.lang.String r2 = r2.getString(r3)
            r8.setText(r2)
            android.widget.TextView r8 = r7.x
            r8.setVisibility(r1)
        L_0x0245:
            r8 = 0
        L_0x0246:
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.o
            if (r2 == 0) goto L_0x0292
            java.lang.CharSequence r2 = r2.getText()
            if (r2 == 0) goto L_0x0292
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.o
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0292
            net.one97.paytm.common.widgets.CJRFloatingLabel r2 = r7.o
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            int r3 = r2.length()
            if (r3 <= r0) goto L_0x0290
            int r0 = r2.length()
            r2 = 6
            if (r0 >= r2) goto L_0x0290
            android.widget.TextView r8 = r7.y
            android.content.res.Resources r0 = r7.getResources()
            int r2 = com.travel.train.R.string.train_msg_pincode_err
            java.lang.String r0 = r0.getString(r2)
            r8.setText(r0)
            android.widget.TextView r8 = r7.y
            r8.setVisibility(r1)
            goto L_0x02a6
        L_0x0290:
            r1 = r8
            goto L_0x02a6
        L_0x0292:
            android.widget.TextView r8 = r7.y
            android.content.res.Resources r0 = r7.getResources()
            int r2 = com.travel.train.R.string.gst_mandatory_error
            java.lang.String r0 = r0.getString(r2)
            r8.setText(r0)
            android.widget.TextView r8 = r7.y
            r8.setVisibility(r1)
        L_0x02a6:
            if (r1 == 0) goto L_0x02ae
            r7.d()
            r7.finish()
        L_0x02ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJRTrainGSTView.onClick(android.view.View):void");
    }
}
