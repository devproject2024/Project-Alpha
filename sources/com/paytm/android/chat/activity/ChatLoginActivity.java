package com.paytm.android.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.a;
import androidx.core.content.b;
import com.google.android.material.textfield.TextInputEditText;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.SharedPreferencesUtil;

public class ChatLoginActivity extends BaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextInputEditText f41595a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextInputEditText f41596b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextInputEditText f41597c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextInputEditText f41598d;

    /* renamed from: e  reason: collision with root package name */
    private Button f41599e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_login);
        if (b.a((Context) this, "android.permission.READ_CONTACTS") == -1) {
            a.a(this, new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.WRITE_CONTACTS"}, 201);
        } else {
            a();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 201) {
            a();
        }
    }

    private void a() {
        this.f41595a = (TextInputEditText) findViewById(R.id.chat_edittext_login_user_id);
        this.f41596b = (TextInputEditText) findViewById(R.id.chat_edittext_login_user_nickname);
        this.f41597c = (TextInputEditText) findViewById(R.id.chat_edittext_login_user_phone);
        this.f41598d = (TextInputEditText) findViewById(R.id.chat_edittext_login_token);
        this.f41595a.setText(SharedPreferencesUtil.getUserId());
        this.f41596b.setText(SharedPreferencesUtil.getNickname());
        this.f41599e = (Button) findViewById(R.id.chat_button_login_connect);
        this.f41599e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    String replaceAll = ChatLoginActivity.this.f41595a.getText().toString().replaceAll("\\s", "");
                    String obj = ChatLoginActivity.this.f41596b.getText().toString();
                    String obj2 = ChatLoginActivity.this.f41597c.getText().toString();
                    String obj3 = ChatLoginActivity.this.f41598d.getText().toString();
                    SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_ID, replaceAll);
                    SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_NAME, obj);
                    SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_MOBILE_NUMBER, obj2);
                    SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_TOKEN, obj3);
                    ChatManager.b().a(ChatLoginActivity.this, true, new ChatManager.a() {
                    });
                    ChatLoginActivity.this.startActivity(new Intent(ChatLoginActivity.this, GroupChannelActivity.class));
                    ChatLoginActivity.this.finish();
                }
            }
        });
        this.f41595a.setSelectAllOnFocus(true);
        this.f41596b.setSelectAllOnFocus(true);
        ((TextView) findViewById(R.id.chat_text_login_versions)).setText("Demo v1.0");
    }
}
