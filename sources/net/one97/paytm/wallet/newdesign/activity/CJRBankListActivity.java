package net.one97.paytm.wallet.newdesign.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.b.a;

public class CJRBankListActivity extends PaytmActivity implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f70478a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f70479b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f70480c;

    /* renamed from: d  reason: collision with root package name */
    private String f70481d;

    /* renamed from: e  reason: collision with root package name */
    private int f70482e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_bank_list_new);
        this.f70478a = (ArrayList) getIntent().getSerializableExtra("list");
        this.f70481d = getIntent().getStringExtra("hint");
        this.f70482e = getIntent().getIntExtra("listType", -1);
        getSupportActionBar().f();
        ((TextView) findViewById(R.id.toolbar_title)).setText(this.f70481d);
        findViewById(R.id.iv_back_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRBankListActivity.this.finish();
            }
        });
        this.f70479b = (EditText) findViewById(R.id.edit_search);
        this.f70479b.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (CJRBankListActivity.this.f70480c != null) {
                    CJRBankListActivity.this.f70480c.getFilter().filter(charSequence);
                }
            }
        });
        ArrayList<String> arrayList = this.f70478a;
        if (arrayList != null && arrayList.size() > 0) {
            ListView listView = (ListView) findViewById(R.id.list_banks);
            this.f70480c = new a(this, this.f70478a);
            listView.setAdapter(this.f70480c);
            listView.setOnItemClickListener(this);
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(e.a(context));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        a aVar = this.f70480c;
        if (aVar != null) {
            String a2 = aVar.getItem(i2);
            Intent intent = new Intent();
            intent.putExtra("selectedName", a2);
            int i3 = this.f70482e;
            if (i3 == 0) {
                setResult(107, intent);
            } else if (i3 == 1) {
                setResult(108, intent);
            } else if (i3 == 2) {
                setResult(109, intent);
            } else if (i3 == 3) {
                setResult(110, intent);
            }
            try {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f70479b.getWindowToken(), 0);
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
            finish();
        }
    }
}
