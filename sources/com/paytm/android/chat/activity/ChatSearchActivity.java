package com.paytm.android.chat.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import com.paytm.android.chat.R;
import com.paytm.android.chat.activity.APCChatActivity;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.contact.ChatFastScrollerLinearLayout;
import com.paytm.android.chat.contact.a;
import com.paytm.android.chat.contact.e;
import com.paytm.android.chat.contact.f;
import com.paytm.android.chat.utils.ChatOneButtonDialog;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.ContactsBeansHolder;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.q;
import io.reactivex.rxjava3.j.b;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;

public class ChatSearchActivity extends BaseActivity {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public EditText f41610a;

    /* renamed from: b  reason: collision with root package name */
    p f41611b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a> f41612c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f41613d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayoutManager f41614e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f41615f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f41616g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f41617h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f41618i;
    /* access modifiers changed from: private */
    public TextView j;
    /* access modifiers changed from: private */
    public e k;
    private int l = 12;
    private int m = 100;
    private long n = 100;
    private InputFilter.LengthFilter o = new InputFilter.LengthFilter(this.l);
    private InputFilter.LengthFilter p = new InputFilter.LengthFilter(this.m);
    /* access modifiers changed from: private */
    public ChatFastScrollerLinearLayout q;
    private ContactManager r;
    /* access modifiers changed from: private */
    public boolean s = false;
    private c t = new c() {
        public final void dispose() {
        }

        public final boolean isDisposed() {
            return false;
        }
    };
    private b<String> u = b.a();
    /* access modifiers changed from: private */
    public ArrayList<a> v;
    /* access modifiers changed from: private */
    public ArrayList<a> w;
    /* access modifiers changed from: private */
    public TextView x;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_search);
        this.f41615f = (RecyclerView) findViewById(R.id.recycler_group_channel_search_list);
        this.f41610a = (EditText) findViewById(R.id.friend_search_edit);
        this.f41616g = (ImageView) findViewById(R.id.img_friend_search);
        this.f41617h = (TextView) findViewById(R.id.tv_friend_search);
        this.f41618i = (ImageView) findViewById(R.id.tv_new_message_cancel);
        this.j = (TextView) findViewById(R.id.tv_after_the_search);
        this.x = (TextView) findViewById(R.id.empty_view_content);
        this.f41614e = new LinearLayoutManager(this);
        this.f41615f.setLayoutManager(this.f41614e);
        this.r = ContactManager.getInstance();
        this.q = (ChatFastScrollerLinearLayout) findViewById(R.id.fast_scroller);
        this.q.setUpWithRecyclerView(this.f41615f, getResources().getStringArray(R.array.chat_module_alphabet_array), new ChatFastScrollerLinearLayout.a() {
            public final void a(String str) {
                int indexOf;
                ChatSearchActivity chatSearchActivity = ChatSearchActivity.this;
                if (chatSearchActivity.f41613d == null) {
                    chatSearchActivity.f41613d = ContactsBeansHolder.getInstance().getHeadList();
                }
                if (chatSearchActivity.f41613d != null && chatSearchActivity.f41613d.size() > 0) {
                    for (int i2 = 0; i2 < chatSearchActivity.f41613d.size(); i2++) {
                        a aVar = chatSearchActivity.f41613d.get(i2);
                        if (aVar.getName().equals(str) && chatSearchActivity.f41612c != null && chatSearchActivity.f41612c.size() > 0 && (indexOf = chatSearchActivity.f41612c.indexOf(aVar)) >= 0 && indexOf < chatSearchActivity.f41612c.size() && (chatSearchActivity.f41614e instanceof LinearLayoutManager)) {
                            chatSearchActivity.f41611b.setTargetPosition(indexOf);
                            try {
                                chatSearchActivity.f41614e.startSmoothScroll(chatSearchActivity.f41611b);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        });
        this.f41611b = new p(this) {
            public final int getVerticalSnapPreference() {
                return -1;
            }

            public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return super.calculateSpeedPerPixel(displayMetrics);
            }
        };
        this.k = new e(new ArrayList(), this, new e.C0694e() {
            public final void a(a aVar) {
                if (aVar.getPhnNo() != null && !"".equals(aVar.getPhnNo())) {
                    SyncContactBean searchContactByPhone = ContactManager.getInstance().searchContactByPhone(aVar.getPhnNo());
                    if (searchContactByPhone != null) {
                        APCChatActivity.a aVar2 = APCChatActivity.f41472g;
                        APCChatActivity.a.a(ChatSearchActivity.this, searchContactByPhone.getChannelUrl(), aVar.getPhnNo(), aVar.getName(), true);
                    } else {
                        APCChatActivity.a aVar3 = APCChatActivity.f41472g;
                        APCChatActivity.a.a(ChatSearchActivity.this, "", aVar.getPhnNo(), aVar.getName(), true);
                    }
                    ChatSearchActivity.this.finish();
                }
            }
        });
        this.f41615f.setAdapter(this.k);
        this.f41610a.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (ChatSearchActivity.this.f41610a.getText() == null || ChatSearchActivity.this.f41610a.getText().toString().equals("")) {
                    ChatSearchActivity.b(ChatSearchActivity.this);
                    ChatSearchActivity.this.j.setText(ChatSearchActivity.this.getResources().getString(R.string.chat_module_contacts));
                } else if (!ChatSearchActivity.this.s) {
                    ChatSearchActivity.a(ChatSearchActivity.this, editable.toString());
                    ChatSearchActivity.this.q.setVisibility(8);
                    ChatSearchActivity.this.k.a(ChatSearchActivity.this.f41610a.getText().toString());
                }
            }
        });
        this.f41618i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (ChatSearchActivity.this.f41610a != null) {
                    com.paytm.android.chat.view.kpswitch.b.a.b(ChatSearchActivity.this.f41610a);
                }
                ChatSearchActivity.this.finish();
            }
        });
        this.t = this.u.debounce(this.n, TimeUnit.MILLISECONDS).distinctUntilChanged().observeOn(io.reactivex.rxjava3.android.b.a.a()).filter(new q<String>() {
            public final /* synthetic */ boolean test(Object obj) throws Throwable {
                return !ChatSearchActivity.this.s;
            }
        }).subscribeOn(io.reactivex.rxjava3.i.a.b()).map(new h<String, String>() {
            public final /* synthetic */ Object apply(Object obj) throws Throwable {
                return ((String) obj).toLowerCase().trim();
            }
        }).subscribe(new g<String>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    ChatSearchActivity.this.k.getFilter().filter(str);
                } else {
                    ChatSearchActivity.b(ChatSearchActivity.this);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 3) {
            this.f41610a.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    if (i2 != 3) {
                        return false;
                    }
                    ChatSearchActivity chatSearchActivity = ChatSearchActivity.this;
                    if (ChatSearchActivity.a(chatSearchActivity.f41610a.getText().toString())) {
                        TextUtils.isEmpty(chatSearchActivity.f41610a.getText().toString());
                    }
                    com.paytm.android.chat.view.kpswitch.b.a.b(ChatSearchActivity.this.f41610a);
                    return true;
                }
            });
        }
        this.f41615f.addOnScrollListener(new RecyclerView.l() {
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (ChatSearchActivity.this.q.getVisibility() == 0 && ChatSearchActivity.this.f41612c != null && findLastCompletelyVisibleItemPosition < ChatSearchActivity.this.f41612c.size() - 1 && findFirstCompletelyVisibleItemPosition >= 0 && ((a) ChatSearchActivity.this.f41612c.get(findFirstCompletelyVisibleItemPosition)).ismIsHeading()) {
                    ChatFastScrollerLinearLayout g2 = ChatSearchActivity.this.q;
                    String name = ((a) ChatSearchActivity.this.f41612c.get(findFirstCompletelyVisibleItemPosition)).getName();
                    int i4 = 0;
                    String[] strArr = g2.f41846b;
                    if (strArr == null) {
                        k.a("sectionList");
                    }
                    int length = strArr.length;
                    while (true) {
                        if (i4 >= length) {
                            i4 = -1;
                            break;
                        }
                        String[] strArr2 = g2.f41846b;
                        if (strArr2 == null) {
                            k.a("sectionList");
                        }
                        if (kotlin.m.p.a(strArr2[i4], name, true)) {
                            break;
                        }
                        i4++;
                    }
                    if (i4 != -1) {
                        g2.a(i4);
                    }
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        this.t.dispose();
    }

    public void onStart() {
        boolean z;
        super.onStart();
        if (androidx.core.content.b.a((Context) this, "android.permission.READ_CONTACTS") == -1) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (androidx.core.content.b.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.a((Context) this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                    requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 2019);
                } else {
                    requestPermissions(new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2019);
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (z) {
            a();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 2019) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            this.s = true;
            this.f41610a.setFilters(new InputFilter[]{this.o});
            if (Build.VERSION.SDK_INT >= 3) {
                this.f41610a.setInputType(2);
            }
            this.q.setVisibility(8);
            final ChatOneButtonDialog chatOneButtonDialog = new ChatOneButtonDialog(this);
            chatOneButtonDialog.hideTitle();
            chatOneButtonDialog.setMessage(getResources().getString(R.string.chat_module_need_contact_permission));
            chatOneButtonDialog.setButton(-3, getResources().getString(R.string.chat_module_button_ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    chatOneButtonDialog.dismiss();
                    ChatSearchActivity.this.finish();
                }
            });
            chatOneButtonDialog.show();
            return;
        }
        this.s = false;
        a();
    }

    private void a() {
        EditText editText = this.f41610a;
        if (editText == null || "".equals(editText.getText().toString())) {
            ArrayList<a> data = ContactsBeansHolder.getInstance().getData();
            ArrayList<a> headList = ContactsBeansHolder.getInstance().getHeadList();
            if (data == null || data.size() <= 0) {
                f.a((Context) this).b((com.paytm.android.chat.contact.b) new com.paytm.android.chat.contact.b() {
                    public final void a(com.paytm.android.chat.contact.c cVar) {
                        ChatSearchActivity.this.b();
                        ArrayList unused = ChatSearchActivity.this.v = cVar.f41849a;
                        ContactsBeansHolder.getInstance().setData(cVar.f41849a);
                        ContactsBeansHolder.getInstance().setHeanList(cVar.f41850b);
                        ArrayList unused2 = ChatSearchActivity.this.w = cVar.f41850b;
                        if (ChatSearchActivity.this.v.size() > 0) {
                            ChatSearchActivity.this.x.setVisibility(8);
                        } else {
                            try {
                                ChatSearchActivity.this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, androidx.appcompat.a.a.a.b(ChatSearchActivity.this, R.drawable.chat_ic_empty_contact), (Drawable) null, (Drawable) null);
                            } catch (Exception unused3) {
                            }
                            ChatSearchActivity.this.x.setVisibility(0);
                        }
                        ChatSearchActivity.this.a(cVar.f41849a, cVar.f41850b);
                    }
                });
                return;
            }
            this.v = data;
            a(data, headList);
        }
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<a> arrayList, ArrayList<a> arrayList2) {
        this.f41612c = arrayList;
        this.f41613d = arrayList2;
        c();
    }

    private void c() {
        ArrayList<a> arrayList = this.f41612c;
        if (arrayList == null || arrayList.size() <= 0) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.k.a(this.f41612c);
        this.k.b(this.f41612c);
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    static /* synthetic */ void b(ChatSearchActivity chatSearchActivity) {
        ArrayList<a> arrayList;
        chatSearchActivity.k.a("");
        if (!chatSearchActivity.s && (arrayList = chatSearchActivity.v) != null) {
            if (arrayList.size() > 0) {
                chatSearchActivity.a(chatSearchActivity.v, chatSearchActivity.w);
            } else if (chatSearchActivity.f41612c.size() > 0) {
                chatSearchActivity.k.a(chatSearchActivity.f41612c);
            }
            chatSearchActivity.q.setVisibility(0);
            chatSearchActivity.q.a(0);
        }
    }

    static /* synthetic */ void a(ChatSearchActivity chatSearchActivity, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < chatSearchActivity.f41612c.size(); i2++) {
            String name = chatSearchActivity.f41612c.get(i2).getName();
            if (name != null && !"".equals(name) && name.toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(chatSearchActivity.f41612c.get(i2));
            }
        }
        if (arrayList.size() > 0) {
            chatSearchActivity.j.setVisibility(0);
            chatSearchActivity.j.setText(chatSearchActivity.getResources().getString(R.string.chat_module_contacts));
        } else {
            chatSearchActivity.j.setVisibility(0);
            TextView textView = chatSearchActivity.j;
            textView.setText(chatSearchActivity.getResources().getString(R.string.chat_module_chat_no_results) + " \"" + str + "\"");
        }
        chatSearchActivity.k.a((ArrayList<a>) arrayList);
    }
}
