package net.one97.paytm.p2mNewDesign.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.p2mNewDesign.a.b;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.d;
import net.one97.paytm.wallet.R;

public class EMIBankListActivity extends AppCompatLockActivity implements d {

    /* renamed from: e  reason: collision with root package name */
    private static final String f13185e = EMIBankListActivity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private List<InstrumentInfo> f13186f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f13187g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public EditText f13188h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public b f13189i;
    private LinearLayout j;
    private TextView k;
    private ProgressBar l;
    private ImageView m;
    private String n;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.wallet.communicator.b.a().wrapContextByRestring(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lyt_emi_bank_list);
        getWindow().setSoftInputMode(35);
        this.j = (LinearLayout) findViewById(R.id.list_empty_layout_container);
        this.l = (ProgressBar) findViewById(R.id.pb_progress);
        this.l.setVisibility(8);
        this.f13188h = (EditText) findViewById(R.id.edit_search);
        findViewById(R.id.img_clear_search_text).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EMIBankListActivity.this.f13188h.setText("");
            }
        });
        this.f13187g = (RecyclerView) findViewById(R.id.rv_bank_list);
        this.k = (TextView) findViewById(R.id.tv_toolbar_title);
        this.m = (ImageView) findViewById(R.id.iv_back_arrow);
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EMIBankListActivity.this.finish();
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.n = intent.getStringExtra("amount");
            this.f13186f = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().o(this.n);
            Collections.sort(this.f13186f, new a());
            this.f13187g.setLayoutManager(new LinearLayoutManager(this));
            this.f13187g.setItemAnimator(new g());
            List<InstrumentInfo> list = this.f13186f;
            if (list != null) {
                this.f13189i = new b(this, list, this);
            }
            this.f13187g.setAdapter(this.f13189i);
            this.f13188h.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    int i2 = 8;
                    if (editable != null) {
                        View findViewById = EMIBankListActivity.this.findViewById(R.id.img_clear_search_text);
                        if (!TextUtils.isEmpty(editable.toString())) {
                            i2 = 0;
                        }
                        findViewById.setVisibility(i2);
                        if (EMIBankListActivity.this.f13189i != null) {
                            EMIBankListActivity.this.f13189i.getFilter().filter(editable.toString());
                            return;
                        }
                        return;
                    }
                    EMIBankListActivity.this.findViewById(R.id.img_clear_search_text).setVisibility(8);
                }
            });
            this.f13188h.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    if ((keyEvent == null || keyEvent.getKeyCode() != 66) && i2 != 6) {
                        return false;
                    }
                    EMIBankListActivity.this.e();
                    return false;
                }
            });
        }
    }

    public final void a() {
        this.f51786a = 105;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == i3) {
            finish();
        }
    }

    public final void c() {
        this.j.setVisibility(0);
    }

    public final void d() {
        this.j.setVisibility(8);
    }

    public final void a(InstrumentInfo instrumentInfo) {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(instrumentInfo);
        setResult(-1);
        finish();
    }

    class a implements Comparator<InstrumentInfo> {
        a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((InstrumentInfo) obj).getDisplaySecondaryInfo().compareTo(((InstrumentInfo) obj2).getDisplaySecondaryInfo());
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f13188h.getWindowToken(), 0);
    }

    public void onPause() {
        super.onPause();
        e();
    }
}
