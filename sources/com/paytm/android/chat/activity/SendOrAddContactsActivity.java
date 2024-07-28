package com.paytm.android.chat.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.m;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.SendContactBean;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.database.Tables;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;

public class SendOrAddContactsActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f41709a;

    /* renamed from: b  reason: collision with root package name */
    private m f41710b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<SelectContactsBean> f41711c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f41712d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<SelectContactsBean> f41713e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f41714f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f41715g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Gson f41716h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public SendContactBean f41717i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_send_contacts);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("SELECTED_CONTACTS");
        this.f41715g = intent.getBooleanExtra("IS_ADD", false);
        this.f41716h = new Gson();
        this.f41711c = (List) this.f41716h.fromJson(stringExtra, new TypeToken<List<SelectContactsBean>>() {
        }.getType());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_send_contacts);
        this.f41709a = (RecyclerView) findViewById(R.id.rv_send_contacts_select_phone);
        if (!this.f41715g) {
            toolbar.setTitle((CharSequence) getResources().getString(R.string.chat_module_send_contacts));
        } else {
            toolbar.setTitle((CharSequence) getResources().getString(R.string.chat_module_view_contacts));
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SendOrAddContactsActivity.this.finish();
            }
        });
        this.f41709a.setLayoutManager(new LinearLayoutManager(this));
        this.f41712d = (LinearLayout) findViewById(R.id.btn_send_contacts);
        if (this.f41715g) {
            this.f41712d.setVisibility(8);
        } else {
            this.f41712d.setVisibility(0);
            this.f41709a.setPadding(0, 0, 0, a());
        }
        m mVar = this.f41710b;
        if (mVar == null) {
            this.f41710b = new m(this, this.f41711c);
            this.f41709a.setAdapter(this.f41710b);
            this.f41710b.f41430c = this.f41715g;
        } else {
            mVar.notifyDataSetChanged();
        }
        this.f41710b.f41428a = new m.c() {
            public final void a(int i2, String str) {
                ((SelectContactsBean) SendOrAddContactsActivity.this.f41711c.get(i2)).getSendContactBean().setContactPhone(str);
                boolean unused = SendOrAddContactsActivity.this.f41714f = true;
                boolean z = false;
                for (int i3 = 0; i3 < SendOrAddContactsActivity.this.f41711c.size(); i3++) {
                    if (((SelectContactsBean) SendOrAddContactsActivity.this.f41711c.get(i3)).getSendContactBean().getContactPhone() != null && !"".equals(((SelectContactsBean) SendOrAddContactsActivity.this.f41711c.get(i3)).getSendContactBean().getContactPhone())) {
                        z = true;
                    }
                }
                if (z) {
                    SendOrAddContactsActivity.this.f41712d.setVisibility(0);
                    SendOrAddContactsActivity.this.f41709a.setPadding(0, 0, 0, SendOrAddContactsActivity.this.a());
                    return;
                }
                SendOrAddContactsActivity.this.f41712d.setVisibility(8);
            }
        };
        this.f41712d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    if (SendOrAddContactsActivity.this.f41714f) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < SendOrAddContactsActivity.this.f41711c.size(); i2++) {
                            if (((SelectContactsBean) SendOrAddContactsActivity.this.f41711c.get(i2)).getSendContactBean().getContactPhone() != null && !"".equals(((SelectContactsBean) SendOrAddContactsActivity.this.f41711c.get(i2)).getSendContactBean().getContactPhone())) {
                                arrayList.add(SendOrAddContactsActivity.this.f41711c.get(i2));
                            }
                        }
                        String json = SendOrAddContactsActivity.this.f41716h.toJson((Object) arrayList);
                        Intent intent = new Intent();
                        intent.putExtra("SELECTED_CONTACTS", json);
                        SendOrAddContactsActivity.this.setResult(-1, intent);
                        SendOrAddContactsActivity.this.finish();
                        return;
                    }
                    List unused = SendOrAddContactsActivity.this.f41713e = new ArrayList();
                    SendOrAddContactsActivity.this.f41713e.addAll(SendOrAddContactsActivity.this.f41711c);
                    for (int i3 = 0; i3 < SendOrAddContactsActivity.this.f41713e.size(); i3++) {
                        String[] split = ((SelectContactsBean) SendOrAddContactsActivity.this.f41713e.get(i3)).getSendContactBean().getContactPhone().split(AppConstants.COMMA);
                        if (split.length > 0) {
                            ((SelectContactsBean) SendOrAddContactsActivity.this.f41713e.get(i3)).getSendContactBean().setContactPhone(split[0]);
                        }
                    }
                    String json2 = SendOrAddContactsActivity.this.f41716h.toJson((Object) SendOrAddContactsActivity.this.f41713e);
                    Intent intent2 = new Intent();
                    intent2.putExtra("SELECTED_CONTACTS", json2);
                    SendOrAddContactsActivity.this.setResult(-1, intent2);
                    SendOrAddContactsActivity.this.finish();
                }
            }
        });
        this.f41710b.f41429b = new m.b() {
            public final void a(SendContactBean sendContactBean) {
                SendContactBean unused = SendOrAddContactsActivity.this.f41717i = sendContactBean;
                SendOrAddContactsActivity.this.a(sendContactBean.getContactName(), sendContactBean.getContactPhone().split(AppConstants.COMMA));
            }
        };
    }

    public final int a() {
        return (int) ((getResources().getDisplayMetrics().density * 70.0f) + 0.5f);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 2001) {
            a(this.f41717i.getContactName(), this.f41717i.getContactPhone().split(AppConstants.COMMA));
        }
    }

    public final void a(String str, String[] strArr) {
        Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), Tables.CONTACTS));
        intent.setType("vnd.android.cursor.dir/person");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.setType("vnd.android.cursor.dir/raw_contact");
        intent.putExtra("name", str);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 == 0) {
                intent.putExtra(ContactColumn.PHONE_NUMBER, strArr[i2]);
            } else if (i2 == 1) {
                intent.putExtra("secondary_phone", strArr[i2]);
            } else {
                intent.putExtra("tertiary_phone", strArr[i2]);
            }
        }
        startActivity(intent);
    }
}
