package com.paytm.android.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.a;
import com.paytm.android.chat.a.k;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.contact.c;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.SendContactsBeansHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;

public class ChatSelectContactsSendActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f41649a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f41650b;

    /* renamed from: c  reason: collision with root package name */
    private View f41651c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<SelectContactsBean> f41652d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<SelectContactsBean> f41653e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f41654f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public k f41655g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f41656h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f41657i;
    /* access modifiers changed from: private */
    public f j;
    private ContactManager k;
    private LinearLayoutManager l;
    /* access modifiers changed from: private */
    public View m;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_select_contacts);
        this.j = new f();
        ((Toolbar) findViewById(R.id.toolbar_channel_list)).setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChatSelectContactsSendActivity.this.finish();
            }
        });
        this.m = findViewById(R.id.empty_view_content);
        this.f41649a = (RecyclerView) findViewById(R.id.rv_selected_contacts);
        this.f41650b = (RecyclerView) findViewById(R.id.rv_all_contacts);
        this.f41651c = findViewById(R.id.view_divider);
        this.f41656h = (LinearLayout) findViewById(R.id.btn_messages_next);
        this.f41657i = (ImageView) findViewById(R.id.img_select_send_contacts);
        this.f41649a.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.l = new LinearLayoutManager(this, 1, false);
        this.f41650b.setLayoutManager(this.l);
        this.k = ContactManager.getInstance();
        this.f41652d = new ArrayList();
        a aVar = this.f41654f;
        if (aVar == null) {
            this.f41654f = new a(this, this.f41652d);
            this.f41650b.setAdapter(this.f41654f);
        } else {
            aVar.notifyDataSetChanged();
        }
        this.f41653e = new ArrayList();
        k kVar = this.f41655g;
        if (kVar == null) {
            this.f41655g = new k(this, this.f41653e);
            this.f41649a.setAdapter(this.f41655g);
        } else {
            kVar.notifyDataSetChanged();
        }
        this.f41654f.f41027b = new a.b() {
            public final void a(SelectContactsBean selectContactsBean) {
                ChatSelectContactsSendActivity.this.f41653e.add(0, selectContactsBean);
                ChatSelectContactsSendActivity.this.f41655g.a(ChatSelectContactsSendActivity.this.f41653e);
                ChatSelectContactsSendActivity.this.c();
            }
        };
        this.f41655g.f41409a = new k.b() {
            public final void a(int i2) {
                SelectContactsBean selectContactsBean = (SelectContactsBean) ChatSelectContactsSendActivity.this.f41653e.get(i2);
                for (int i3 = 0; i3 < ChatSelectContactsSendActivity.this.f41652d.size(); i3++) {
                    if (selectContactsBean.getSendContactBean().getContactPhone().equals(((SelectContactsBean) ChatSelectContactsSendActivity.this.f41652d.get(i3)).getSendContactBean().getContactPhone())) {
                        ((SelectContactsBean) ChatSelectContactsSendActivity.this.f41652d.get(i3)).setSelect(false);
                    }
                }
                ChatSelectContactsSendActivity.this.f41653e.remove(i2);
                ChatSelectContactsSendActivity.this.f41655g.a(ChatSelectContactsSendActivity.this.f41653e);
                ChatSelectContactsSendActivity.this.f41654f.a(ChatSelectContactsSendActivity.this.f41652d);
                ChatSelectContactsSendActivity.this.c();
            }
        };
        this.f41656h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick() && ChatSelectContactsSendActivity.this.f41653e.size() != 0) {
                    Intent intent = new Intent(ChatSelectContactsSendActivity.this, SendOrAddContactsActivity.class);
                    intent.putExtra("SELECTED_CONTACTS", ChatSelectContactsSendActivity.this.j.a((Object) ChatSelectContactsSendActivity.this.f41653e));
                    ChatSelectContactsSendActivity.this.startActivityForResult(intent, 1);
                }
            }
        });
        this.f41657i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    Intent intent = new Intent(ChatSelectContactsSendActivity.this, ChatSearchSendContactsActivity.class);
                    String str = "";
                    for (int i2 = 0; i2 < ChatSelectContactsSendActivity.this.f41653e.size(); i2++) {
                        str = str + ((SelectContactsBean) ChatSelectContactsSendActivity.this.f41653e.get(i2)).getSendContactBean().getContactId() + AppConstants.COMMA;
                    }
                    intent.putExtra("TO_BE_SELECTED", str);
                    SendContactsBeansHolder.getInstance().setData(ChatSelectContactsSendActivity.this.f41652d);
                    ChatSelectContactsSendActivity.this.startActivityForResult(intent, 0);
                }
            }
        });
        a();
    }

    public void onStart() {
        super.onStart();
        if (b.a((Context) this, "android.permission.READ_CONTACTS") == -1 && Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 2019);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 2019) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            Toast.makeText(this, getResources().getString(R.string.chat_module_need_contact_permission), 0).show();
        } else {
            a();
        }
    }

    private void a() {
        com.paytm.android.chat.contact.f.a((Context) this).a((com.paytm.android.chat.contact.b) new com.paytm.android.chat.contact.b() {
            public final void a(c cVar) {
                ChatSelectContactsSendActivity.this.b();
                ChatSelectContactsSendActivity.this.f41652d.addAll(cVar.f41851c);
                if (ChatSelectContactsSendActivity.this.f41652d.size() > 0) {
                    ChatSelectContactsSendActivity.this.m.setVisibility(8);
                } else {
                    ChatSelectContactsSendActivity.this.m.setVisibility(0);
                }
                ChatSelectContactsSendActivity.this.f41654f.a(ChatSelectContactsSendActivity.this.f41652d);
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        boolean z = true;
        if (i2 == 1 && i3 == -1) {
            setResult(-1, intent);
            finish();
        }
        if (i3 == -1 && i2 == 0) {
            SelectContactsBean selectContactsBean = null;
            if (intent != null) {
                selectContactsBean = (SelectContactsBean) intent.getSerializableExtra("RESULT_VALUE");
            }
            for (int i4 = 0; i4 < this.f41652d.size(); i4++) {
                if (selectContactsBean != null && this.f41652d.get(i4).getSendContactBean().getContactPhone().equals(selectContactsBean.getSendContactBean().getContactPhone())) {
                    this.f41652d.get(i4).setSelect(true);
                }
            }
            for (int i5 = 0; i5 < this.f41653e.size(); i5++) {
                if (this.f41653e.get(i5).getSendContactBean().getContactPhone().equals(selectContactsBean.getSendContactBean().getContactPhone())) {
                    z = false;
                }
            }
            if (z) {
                this.f41653e.add(0, selectContactsBean);
            }
            this.f41654f.a(this.f41652d);
            this.f41655g.a(this.f41653e);
            c();
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.f41653e.size() == 0) {
            this.f41649a.setVisibility(8);
            this.f41651c.setVisibility(8);
            this.f41656h.setVisibility(8);
            return;
        }
        this.f41649a.setVisibility(0);
        this.f41651c.setVisibility(0);
        this.f41656h.setVisibility(0);
    }
}
