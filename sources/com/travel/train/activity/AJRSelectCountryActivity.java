package com.travel.train.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.d;
import com.travel.train.j.c;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRCountryCode;
import com.travel.train.model.trainticket.CJRCountryCodeList;
import com.travel.train.model.trainticket.CJRCountryList;
import com.travel.train.model.trainticket.CJRCountrys;
import com.travel.train.model.trainticket.CJRIRCTCUserAvailability;
import com.travel.train.model.trainticket.CJRIRCTCUserRegister;
import com.travel.train.model.trainticket.CJRPincodeResponse;
import java.util.ArrayList;

public class AJRSelectCountryActivity extends CJRTrainBaseActivity implements View.OnClickListener, d.b, c.a {

    /* renamed from: a  reason: collision with root package name */
    private ListView f25916a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRCountrys> f25917b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public d f25918c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f25919d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f25920e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<CJRCountryCode> f25921f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f25922g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public com.travel.train.b.c f25923h;

    /* renamed from: i  reason: collision with root package name */
    private TextWatcher f25924i = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (AJRSelectCountryActivity.this.f25918c != null && AJRSelectCountryActivity.this.f25922g) {
                AJRSelectCountryActivity.this.f25918c.getFilter().filter(charSequence);
            } else if (AJRSelectCountryActivity.this.f25923h != null) {
                AJRSelectCountryActivity.this.f25923h.getFilter().filter(charSequence);
            }
        }
    };

    public final void a() {
    }

    public final void a(CJRIRCTCUserAvailability cJRIRCTCUserAvailability) {
    }

    public final void a(CJRIRCTCUserRegister cJRIRCTCUserRegister) {
    }

    public final void a(CJRPincodeResponse cJRPincodeResponse) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_country_select_layout);
        this.f25920e = (RelativeLayout) findViewById(R.id.suggestion_lyt);
        this.f25916a = (ListView) findViewById(R.id.country_list);
        ((EditText) findViewById(R.id.country_search)).addTextChangedListener(this.f25924i);
        this.f25919d = (ProgressBar) findViewById(R.id.progress_city);
        ImageView imageView = (ImageView) findViewById(R.id.back_button);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(this);
        imageView.setAlpha(95);
        ((ImageButton) findViewById(R.id.close_icon)).setOnClickListener(this);
        int g2 = b.g((Context) this);
        ((LinearLayout) findViewById(R.id.select_train_lyt)).setPadding(g2, g2, g2, g2);
        getSupportActionBar().f();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("country_list")) {
            this.f25917b = (ArrayList) intent.getSerializableExtra("country_list");
        }
        if (intent != null && intent.hasExtra("country_code_list")) {
            this.f25921f = (ArrayList) intent.getSerializableExtra("country_code_list");
        }
        if (intent != null && intent.hasExtra("sign_up")) {
            this.f25922g = intent.getBooleanExtra("sign_up", false);
        }
        if (this.f25922g) {
            ArrayList<CJRCountrys> arrayList = this.f25917b;
            if (arrayList == null || arrayList.size() <= 0) {
                this.f25919d.setVisibility(0);
                c cVar = new c(this, this);
                com.travel.train.b.a();
                String Y = com.travel.train.b.b().Y();
                if (URLUtil.isValidUrl(Y)) {
                    String b2 = o.b(c.f27512a, b.s(c.f27512a, Y));
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = c.f27512a;
                    bVar.f42878b = a.c.TRAIN;
                    bVar.n = a.b.SILENT;
                    bVar.o = g.r;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42880d = b2;
                    bVar.f42882f = n.b(c.f27512a);
                    bVar.f42885i = new CJRCountryList();
                    bVar.j = cVar;
                    a l = bVar.l();
                    l.f42859c = false;
                    if (b.c(c.f27512a)) {
                        l.a();
                    } else {
                        cVar.a(l);
                    }
                } else {
                    Context context = c.f27512a;
                    b.b(context, context.getString(R.string.error), c.f27512a.getString(R.string.msg_invalid_url_train));
                }
            } else {
                this.f25918c = new d(this, this.f25917b, this);
                this.f25916a.setAdapter(this.f25918c);
            }
        } else {
            ArrayList<CJRCountryCode> arrayList2 = this.f25921f;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                this.f25919d.setVisibility(0);
                c cVar2 = new c(this, this);
                com.travel.train.b.a();
                String W = com.travel.train.b.b().W();
                if (URLUtil.isValidUrl(W)) {
                    String b3 = o.b(c.f27512a, b.s(c.f27512a, W));
                    com.paytm.network.b bVar2 = new com.paytm.network.b();
                    bVar2.f42877a = c.f27512a;
                    bVar2.f42878b = a.c.TRAIN;
                    bVar2.n = a.b.SILENT;
                    bVar2.o = g.r;
                    bVar2.f42879c = a.C0715a.GET;
                    bVar2.f42880d = b3;
                    bVar2.f42882f = n.b((Context) this);
                    bVar2.f42885i = new CJRCountryCodeList();
                    bVar2.j = cVar2;
                    a l2 = bVar2.l();
                    l2.f42859c = false;
                    if (b.c(c.f27512a)) {
                        l2.a();
                    } else {
                        cVar2.a(l2);
                    }
                } else {
                    Context context2 = c.f27512a;
                    b.b(context2, context2.getString(R.string.error), c.f27512a.getString(R.string.msg_invalid_url_train));
                }
            } else {
                this.f25923h = new com.travel.train.b.c(this, this.f25921f, this);
                this.f25916a.setAdapter(this.f25923h);
            }
        }
        this.f25916a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (AJRSelectCountryActivity.this.f25922g) {
                    CJRCountrys a2 = AJRSelectCountryActivity.this.f25918c.getItem(i2);
                    Intent intent = new Intent();
                    intent.putExtra("selected_country", a2);
                    intent.putExtra("country_list", AJRSelectCountryActivity.this.f25917b);
                    AJRSelectCountryActivity.this.setResult(-1, intent);
                    AJRSelectCountryActivity.this.finish();
                    return;
                }
                CJRCountryCode a3 = AJRSelectCountryActivity.this.f25923h.getItem(i2);
                Intent intent2 = new Intent();
                intent2.putExtra("selected_country", a3);
                intent2.putExtra("country_list", AJRSelectCountryActivity.this.f25921f);
                AJRSelectCountryActivity.this.setResult(-1, intent2);
                AJRSelectCountryActivity.this.finish();
            }
        });
    }

    public final void a(CJRCountryList cJRCountryList) {
        if (cJRCountryList != null) {
            this.f25919d.setVisibility(8);
            if (cJRCountryList.getCountryBody() != null) {
                this.f25917b = cJRCountryList.getCountryBody().getCountryList();
                ArrayList<CJRCountrys> arrayList = this.f25917b;
                if (arrayList != null && arrayList.size() > 0) {
                    this.f25918c = new d(this, this.f25917b, this);
                    this.f25916a.setAdapter(this.f25918c);
                }
            }
        }
    }

    public final void a(CJRCountryCodeList cJRCountryCodeList) {
        if (cJRCountryCodeList != null) {
            this.f25919d.setVisibility(8);
            if (cJRCountryCodeList.getCountryBody() != null) {
                this.f25921f = cJRCountryCodeList.getCountryBody().getCountryList();
                ArrayList<CJRCountryCode> arrayList = this.f25921f;
                if (arrayList != null && arrayList.size() > 0) {
                    this.f25923h = new com.travel.train.b.c(this, this.f25921f, this);
                    this.f25916a.setAdapter(this.f25923h);
                }
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_button) {
            finish();
        } else if (id == R.id.close_icon) {
            finish();
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.f25920e.setVisibility(0);
        } else {
            this.f25920e.setVisibility(8);
        }
    }
}
