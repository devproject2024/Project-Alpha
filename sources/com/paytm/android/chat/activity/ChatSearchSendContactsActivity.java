package com.paytm.android.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.SendContactsBeansHolder;
import java.util.ArrayList;
import java.util.List;

public class ChatSearchSendContactsActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public EditText f41633a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f41634b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f41635c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f41636d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f41637e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f41638f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f41639g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public f f41640h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public View f41641i;
    private String j;
    /* access modifiers changed from: private */
    public ArrayList<SelectContactsBean> k;
    /* access modifiers changed from: private */
    public List<SelectContactsBean> l;
    /* access modifiers changed from: private */
    public k m;
    private LinearLayout n;
    private View o;
    private RecyclerView p;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_search_send_contacts);
        this.k = new ArrayList<>();
        this.f41640h = new f();
        this.j = getIntent().getStringExtra("TO_BE_SELECTED");
        List<SelectContactsBean> data = SendContactsBeansHolder.getInstance().getData();
        if (data != null && data.size() > 0) {
            this.k.addAll(data);
        }
        this.f41634b = (RecyclerView) findViewById(R.id.recycler_group_channel_search_list);
        this.f41633a = (EditText) findViewById(R.id.friend_search_edit);
        this.f41635c = (ImageView) findViewById(R.id.img_friend_search);
        this.f41636d = (TextView) findViewById(R.id.tv_friend_search);
        this.f41637e = (TextView) findViewById(R.id.tv_select_contacts);
        this.f41638f = (TextView) findViewById(R.id.tv_after_the_search);
        this.f41641i = findViewById(R.id.empty_view_content);
        this.f41634b.setLayoutManager(new LinearLayoutManager(this));
        this.p = (RecyclerView) findViewById(R.id.rv_selected_contacts);
        this.o = findViewById(R.id.view_divider);
        this.n = (LinearLayout) findViewById(R.id.btn_messages_next);
        this.p.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.l = new ArrayList();
        k kVar = this.m;
        if (kVar == null) {
            this.m = new k(this, this.l);
            this.p.setAdapter(this.m);
        } else {
            kVar.notifyDataSetChanged();
        }
        a aVar = this.f41639g;
        if (aVar == null) {
            this.f41639g = new a(this, this.k);
            this.f41634b.setAdapter(this.f41639g);
            this.f41639g.f41029d = this.j;
        } else {
            aVar.notifyDataSetChanged();
        }
        this.l = new ArrayList();
        k kVar2 = this.m;
        if (kVar2 == null) {
            this.m = new k(this, this.l);
            this.p.setAdapter(this.m);
        } else {
            kVar2.notifyDataSetChanged();
        }
        this.f41633a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                ChatSearchSendContactsActivity.a(ChatSearchSendContactsActivity.this, z);
            }
        });
        this.f41633a.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (ChatSearchSendContactsActivity.this.f41633a.getText() != null && !ChatSearchSendContactsActivity.this.f41633a.getText().toString().equals("")) {
                    ChatSearchSendContactsActivity.this.f41638f.setText("CONTACTS");
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < ChatSearchSendContactsActivity.this.k.size(); i2++) {
                        String contactName = ((SelectContactsBean) ChatSearchSendContactsActivity.this.k.get(i2)).getSendContactBean().getContactName();
                        if (contactName != null && !"".equals(contactName) && contactName.toLowerCase().contains(ChatSearchSendContactsActivity.this.f41633a.getText().toString().toLowerCase())) {
                            arrayList.add(ChatSearchSendContactsActivity.this.k.get(i2));
                        }
                    }
                    if (ChatSearchSendContactsActivity.this.f41639g != null) {
                        if (arrayList.size() > 0) {
                            ChatSearchSendContactsActivity.this.f41641i.setVisibility(8);
                        } else {
                            ChatSearchSendContactsActivity.this.f41641i.setVisibility(0);
                        }
                        ChatSearchSendContactsActivity.this.f41639g.a(arrayList);
                        ChatSearchSendContactsActivity.this.f41639g.f41028c = ChatSearchSendContactsActivity.this.f41633a.getText().toString();
                    }
                } else if (ChatSearchSendContactsActivity.this.f41639g != null) {
                    if (ChatSearchSendContactsActivity.this.k.size() > 0) {
                        ChatSearchSendContactsActivity.this.f41641i.setVisibility(8);
                    } else {
                        ChatSearchSendContactsActivity.this.f41641i.setVisibility(0);
                    }
                    ChatSearchSendContactsActivity.this.f41639g.a(ChatSearchSendContactsActivity.this.k);
                    ChatSearchSendContactsActivity.this.f41639g.f41028c = "";
                }
            }
        });
        this.f41637e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChatSearchSendContactsActivity.this.finish();
            }
        });
        this.f41639g.f41027b = new a.b() {
            public final void a(SelectContactsBean selectContactsBean) {
                ChatSearchSendContactsActivity.this.l.add(0, selectContactsBean);
                ChatSearchSendContactsActivity.this.m.a(ChatSearchSendContactsActivity.this.l);
                ChatSearchSendContactsActivity.h(ChatSearchSendContactsActivity.this);
            }
        };
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick() && ChatSearchSendContactsActivity.this.l.size() != 0) {
                    Intent intent = new Intent(ChatSearchSendContactsActivity.this, SendOrAddContactsActivity.class);
                    intent.putExtra("SELECTED_CONTACTS", ChatSearchSendContactsActivity.this.f41640h.a((Object) ChatSearchSendContactsActivity.this.l));
                    ChatSearchSendContactsActivity.this.startActivityForResult(intent, 1);
                }
            }
        });
        this.m.f41409a = new k.b() {
            public final void a(int i2) {
                SelectContactsBean selectContactsBean = (SelectContactsBean) ChatSearchSendContactsActivity.this.l.get(i2);
                for (int i3 = 0; i3 < ChatSearchSendContactsActivity.this.k.size(); i3++) {
                    if (selectContactsBean.getSendContactBean().getContactPhone().equals(((SelectContactsBean) ChatSearchSendContactsActivity.this.k.get(i3)).getSendContactBean().getContactPhone())) {
                        ((SelectContactsBean) ChatSearchSendContactsActivity.this.k.get(i3)).setSelect(false);
                    }
                }
                ChatSearchSendContactsActivity.this.l.remove(i2);
                ChatSearchSendContactsActivity.this.m.a(ChatSearchSendContactsActivity.this.l);
                ChatSearchSendContactsActivity.this.f41639g.a(ChatSearchSendContactsActivity.this.k);
                ChatSearchSendContactsActivity.h(ChatSearchSendContactsActivity.this);
            }
        };
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
                ChatSearchSendContactsActivity.this.b();
                ChatSearchSendContactsActivity.this.k.addAll(cVar.f41851c);
                ChatSearchSendContactsActivity.this.f41639g.a(ChatSearchSendContactsActivity.this.k);
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    static /* synthetic */ void a(ChatSearchSendContactsActivity chatSearchSendContactsActivity, boolean z) {
        if (!z) {
            com.paytm.android.chat.view.kpswitch.b.a.b(chatSearchSendContactsActivity.f41634b);
            chatSearchSendContactsActivity.f41633a.setText("");
        }
    }

    static /* synthetic */ void h(ChatSearchSendContactsActivity chatSearchSendContactsActivity) {
        if (chatSearchSendContactsActivity.l.size() == 0) {
            chatSearchSendContactsActivity.p.setVisibility(8);
            chatSearchSendContactsActivity.o.setVisibility(8);
            chatSearchSendContactsActivity.n.setVisibility(8);
            return;
        }
        chatSearchSendContactsActivity.p.setVisibility(0);
        chatSearchSendContactsActivity.o.setVisibility(0);
        chatSearchSendContactsActivity.n.setVisibility(0);
    }
}
