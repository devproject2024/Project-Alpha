package net.one97.paytm.wallet.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.wallet.CJRBank;
import net.one97.paytm.common.entity.wallet.CJRBranch;
import net.one97.paytm.common.entity.wallet.CJRBranchDetails;
import net.one97.paytm.common.entity.wallet.CJRCity;
import net.one97.paytm.common.entity.wallet.CJRState;
import net.one97.paytm.j.c;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.d.d;
import net.one97.paytm.wallet.newdesign.activity.CJRBankListActivity;

public class AJRConfirmIFSCActivity extends PaytmActivity implements View.OnClickListener, b {

    /* renamed from: a  reason: collision with root package name */
    private String f69877a;

    /* renamed from: b  reason: collision with root package name */
    private String f69878b;

    /* renamed from: c  reason: collision with root package name */
    private String f69879c;

    /* renamed from: d  reason: collision with root package name */
    private String f69880d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f69881e;

    /* renamed from: f  reason: collision with root package name */
    private Dialog f69882f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f69883g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRBranchDetails> f69884h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f69885i;
    private EditText j;
    private EditText k;
    private EditText l;
    private EditText m;
    private TextView n;
    private Button o;
    private boolean p;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(e.a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = getIntent().getBooleanExtra("show_ifsc_new_design", false);
        if (this.p) {
            setContentView((int) R.layout.activity_confirm_ifsc_new);
            getSupportActionBar().f();
            findViewById(R.id.iv_back_button).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRConfirmIFSCActivity.this.finish();
                }
            });
        } else {
            setContentView((int) R.layout.activity_confirm_ifsc);
            getSupportActionBar().b(true);
            getSupportActionBar();
            getSupportActionBar().c((int) R.drawable.no_home_icon);
            getSupportActionBar().b((int) R.drawable.no_home_icon);
            getSupportActionBar().a(2.0f);
            getSupportActionBar().a((Drawable) new ColorDrawable(-1));
            getSupportActionBar().a((CharSequence) getResources().getString(R.string.get_ifsc_code));
        }
        q.a("AJRConfirmIFSCActivity");
        int t = a.t(this) / 2;
        this.j = (EditText) findViewById(R.id.txt_select_bank);
        this.j.setOnClickListener(this);
        this.k = (EditText) findViewById(R.id.txt_select_state);
        this.k.setOnClickListener(this);
        this.l = (EditText) findViewById(R.id.txt_select_city);
        this.l.setOnClickListener(this);
        this.m = (EditText) findViewById(R.id.txt_select_branch);
        this.m.setOnClickListener(this);
        this.n = (TextView) findViewById(R.id.txt_error);
        this.n.setPadding(t, t, t, t);
        this.f69885i = (TextView) findViewById(R.id.ifsc_value);
        this.f69883g = (RelativeLayout) findViewById(R.id.ifsc_layout);
        this.o = (Button) findViewById(R.id.btn_continue);
        if (!this.p) {
            ((RelativeLayout.LayoutParams) this.o.getLayoutParams()).setMargins(t, t, t, t);
        }
        this.o.setOnClickListener(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.n.setVisibility(8);
        String str = "";
        if (i3 == 107) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("selectedName");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.f69877a = stringExtra;
                    this.j.setText(this.f69877a);
                    this.f69878b = null;
                    this.k.setEnabled(true);
                    a(false);
                    b(false);
                    this.f69885i.setText(str);
                    a();
                }
            }
        } else if (i3 == 108) {
            if (intent != null) {
                String stringExtra2 = intent.getStringExtra("selectedName");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    this.f69878b = stringExtra2;
                    this.k.setText(this.f69878b);
                    a(true);
                    b(false);
                    this.f69885i.setText(str);
                    b();
                }
            }
        } else if (i3 == 109) {
            if (intent != null) {
                String stringExtra3 = intent.getStringExtra("selectedName");
                if (!TextUtils.isEmpty(stringExtra3)) {
                    this.f69879c = stringExtra3;
                    this.l.setText(this.f69879c);
                    b(true);
                    this.f69885i.setText(str);
                    c();
                }
            }
        } else if (i3 == 110 && intent != null) {
            String stringExtra4 = intent.getStringExtra("selectedName");
            if (!TextUtils.isEmpty(stringExtra4)) {
                this.f69880d = stringExtra4;
                this.m.setText(stringExtra4);
                TextView textView = this.f69885i;
                ArrayList<CJRBranchDetails> arrayList = this.f69884h;
                if (arrayList != null) {
                    Iterator<CJRBranchDetails> it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        CJRBranchDetails next = it2.next();
                        if (next.getDisplayName() != null && next.getDisplayName().equalsIgnoreCase(stringExtra4)) {
                            str = next.getIfscCode();
                            break;
                        }
                    }
                }
                textView.setText(str);
                this.f69883g.setVisibility(0);
                this.o.setVisibility(0);
                this.f69881e = true;
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("wallet_error_type", "IFSC_send_money_error");
                hashMap.put("wallet_error_text", str);
                net.one97.paytm.j.a.b("wallet_error_displayed", (Map<String, Object>) hashMap, getApplicationContext());
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
            this.n.setVisibility(0);
            this.n.setText(str);
        }
    }

    private void a() {
        if (!TextUtils.isEmpty(this.f69877a)) {
            if (a.m(this)) {
                d();
                d.a((Activity) this, this.f69877a, (b) this);
                return;
            }
            net.one97.paytm.wallet.utility.a.a((Activity) this);
        }
    }

    private void b() {
        if (!TextUtils.isEmpty(this.f69877a) && !TextUtils.isEmpty(this.f69878b)) {
            if (a.m(this)) {
                d();
                d.a(this, this.f69877a, this.f69878b, this);
                return;
            }
            net.one97.paytm.wallet.utility.a.a((Activity) this);
        }
    }

    private void c() {
        if (!TextUtils.isEmpty(this.f69877a) && !TextUtils.isEmpty(this.f69878b) && !TextUtils.isEmpty(this.f69879c)) {
            if (a.m(this)) {
                d();
                d.a(this, this.f69877a, this.f69878b, this.f69879c, this);
                return;
            }
            net.one97.paytm.wallet.utility.a.a((Activity) this);
        }
    }

    private void a(ArrayList<CJRBranchDetails> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            Iterator<CJRBranchDetails> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRBranchDetails next = it2.next();
                if (!TextUtils.isEmpty(next.getDisplayName())) {
                    arrayList2.add(next.getDisplayName());
                }
            }
            Intent intent = new Intent(this, CJRBankListActivity.class);
            intent.putExtra("list", arrayList2);
            intent.putExtra("hint", getResources().getString(R.string.select_branch));
            intent.putExtra("listType", 3);
            startActivityForResult(intent, 107);
        } catch (IllegalStateException e2) {
            q.b(e2.getMessage());
        }
    }

    private void a(boolean z) {
        this.f69879c = null;
        this.l.setEnabled(z);
    }

    private void b(boolean z) {
        ArrayList<CJRBranchDetails> arrayList = this.f69884h;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f69884h = null;
        this.m.setEnabled(z);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRBranch cJRBranch;
        e();
        if (iJRPaytmDataModel instanceof CJRBank) {
            CJRBank cJRBank = (CJRBank) iJRPaytmDataModel;
            if (cJRBank != null && cJRBank.getResponse() != null && cJRBank.getResponse().getList() != null && cJRBank.getResponse().getList().size() > 0) {
                ArrayList<String> list = cJRBank.getResponse().getList();
                try {
                    Intent intent = new Intent(this, CJRBankListActivity.class);
                    intent.putExtra("list", list);
                    intent.putExtra("hint", getResources().getString(R.string.select_bank));
                    intent.putExtra("listType", 0);
                    startActivityForResult(intent, 107);
                } catch (IllegalStateException e2) {
                    q.b(e2.getMessage());
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRState) {
            CJRState cJRState = (CJRState) iJRPaytmDataModel;
            if (cJRState != null && cJRState.getResponse() != null && cJRState.getResponse().getList() != null && cJRState.getResponse().getList().size() > 0) {
                ArrayList<String> list2 = cJRState.getResponse().getList();
                try {
                    Intent intent2 = new Intent(this, CJRBankListActivity.class);
                    intent2.putExtra("list", list2);
                    intent2.putExtra("hint", getResources().getString(R.string.select_state));
                    intent2.putExtra("listType", 1);
                    startActivityForResult(intent2, 107);
                } catch (IllegalStateException e3) {
                    q.b(e3.getMessage());
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRCity) {
            CJRCity cJRCity = (CJRCity) iJRPaytmDataModel;
            if (cJRCity != null && cJRCity.getResponse() != null && cJRCity.getResponse().getList() != null && cJRCity.getResponse().getList().size() > 0) {
                ArrayList<String> list3 = cJRCity.getResponse().getList();
                try {
                    Intent intent3 = new Intent(this, CJRBankListActivity.class);
                    intent3.putExtra("list", list3);
                    intent3.putExtra("hint", getResources().getString(R.string.select_city));
                    intent3.putExtra("listType", 2);
                    startActivityForResult(intent3, 107);
                } catch (IllegalStateException e4) {
                    q.b(e4.getMessage());
                }
            }
        } else if ((iJRPaytmDataModel instanceof CJRBranch) && (cJRBranch = (CJRBranch) iJRPaytmDataModel) != null && cJRBranch.getResponse() != null && cJRBranch.getResponse().getBankBranchList() != null && cJRBranch.getResponse().getBankBranchList().size() > 0) {
            this.f69884h = cJRBranch.getResponse().getBankBranchList();
            a(this.f69884h);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_continue) {
            String charSequence = this.f69885i.getText().toString();
            if (TextUtils.isEmpty(charSequence)) {
                a(getResources().getString(R.string.enter_valid_ifsc));
            } else if (this.f69881e) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("new_wallet_screen_type", UpiConstants.WALLET_TYPE_MONEY_TRANSFER);
                    hashMap.put("new_wallet_bank_ifsc_code", charSequence);
                    net.one97.paytm.j.a.b("new_wallet_bank_ifsc_continue_clicked", (Map<String, Object>) hashMap, (Context) this);
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.b(e2.getMessage());
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("intent_extra_ifsc_code", charSequence);
                intent.putExtra("intent_extra_bank_name", this.f69877a);
                intent.putExtra("intent_extra_bank_branch", this.f69880d);
                setResult(-1, intent);
                finish();
            } else {
                a(getResources().getString(R.string.verify_ifsc));
            }
        } else if (id != R.id.txt_select_state) {
            switch (id) {
                case R.id.txt_select_bank:
                    if (a.m(this)) {
                        d();
                        c.a();
                        String o2 = c.o();
                        if (URLUtil.isValidUrl(o2)) {
                            String e3 = com.paytm.utility.b.e((Context) this, o2);
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("ssotoken", t.b((Context) this));
                            net.one97.paytm.common.b.d.a(this, e3, this, hashMap2, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRBank(), a.c.PAYMENTS, a.b.SILENT).a();
                            return;
                        }
                        return;
                    }
                    net.one97.paytm.wallet.utility.a.a((Activity) this);
                    return;
                case R.id.txt_select_branch:
                    c();
                    return;
                case R.id.txt_select_city:
                    b();
                    return;
                default:
                    return;
            }
        } else {
            a();
        }
    }

    private void d() {
        try {
            if (this.f69882f == null) {
                this.f69882f = net.one97.paytm.wallet.utility.a.b((Activity) this);
            }
            if (this.f69882f != null && !this.f69882f.isShowing()) {
                this.f69882f.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void e() {
        try {
            if (this.f69882f != null && this.f69882f.isShowing()) {
                this.f69882f.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            e();
            if (networkCustomError != null) {
                String message = networkCustomError.getMessage();
                if (TextUtils.isEmpty(message) || (!message.equalsIgnoreCase("410") && !message.equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    CJRError a2 = l.a((Context) this, networkCustomError);
                    if (a2 != null && !TextUtils.isEmpty(a2.getTitle()) && !TextUtils.isEmpty(a2.getMessage())) {
                        a(a2.getMessage());
                    } else if (message == null || !message.equalsIgnoreCase("parsing_error")) {
                        a(getResources().getString(R.string.network_error_message));
                    } else {
                        a(l.a((Context) this, networkCustomError.getUrl()).getMessage());
                    }
                } else {
                    r.a((Activity) this, (Exception) networkCustomError, (String) null, (Bundle) null);
                }
            }
        } catch (Resources.NotFoundException e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        } catch (Exception e3) {
            if (com.paytm.utility.b.v) {
                q.b(e3.getMessage());
            }
        }
    }
}
