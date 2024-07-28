package com.paytm.android.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.drawerlayout.widget.DrawerLayout;
import com.paytm.a;
import com.paytm.android.chat.R;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.fragment.c;
import com.paytm.android.chat.utils.ChatNotificationHelper;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.ImageUtils;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.view.RoundCornerImageView;
import kotlin.g.a.m;

public class GroupChannelActivity extends BaseActivity {

    /* renamed from: d  reason: collision with root package name */
    static boolean f41664d = false;

    /* renamed from: a  reason: collision with root package name */
    DrawerLayout f41665a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f41666b;

    /* renamed from: c  reason: collision with root package name */
    RoundCornerImageView f41667c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = a.f40823c;
        a.a((Context) this, (kotlin.g.a.a) null, (m) null, 14);
        setContentView(R.layout.chat_activity_group_channel);
        getWindow().setBackgroundDrawable((Drawable) null);
        getSupportFragmentManager().a().b(R.id.container_group_channel, c.a(false), (String) null).c();
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_channel_list));
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
            getSupportActionBar().e(R.drawable.chat_ic_back_arrow);
        }
        this.f41666b = (ImageView) findViewById(R.id.img_channel_user_pic);
        this.f41666b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    GroupChannelActivity.this.a();
                }
            }
        });
        this.f41665a = (DrawerLayout) findViewById(R.id.v4_drawerlayout);
        if (f41664d) {
            a();
        }
        this.f41667c = (RoundCornerImageView) findViewById(R.id.profile_pic);
        ((TextView) findViewById(R.id.profile_btn_change_pic)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    GroupChannelActivity.this.startActivityForResult(new Intent(GroupChannelActivity.this, ChangeProfilePicActivity.class), 101);
                }
            }
        });
        ((RelativeLayout) findViewById(R.id.rl_settings_privacy)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    Intent intent = new Intent(GroupChannelActivity.this, SettingsActivity.class);
                    intent.putExtra(KeyList.IntentExtraKey.SETTINGS_TITLE, GroupChannelActivity.this.getResources().getString(R.string.chat_module_settings_privacy));
                    intent.putExtra(KeyList.IntentExtraKey.SETTINGS_INFO, com.paytm.android.chat.c.f());
                    GroupChannelActivity.this.startActivity(intent);
                }
            }
        });
        ((RelativeLayout) findViewById(R.id.rl_settings_media)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    Intent intent = new Intent(GroupChannelActivity.this, SettingsActivity.class);
                    intent.putExtra(KeyList.IntentExtraKey.SETTINGS_TITLE, GroupChannelActivity.this.getResources().getString(R.string.chat_module_settings_media));
                    intent.putExtra(KeyList.IntentExtraKey.SETTINGS_INFO, com.paytm.android.chat.c.f());
                    GroupChannelActivity.this.startActivity(intent);
                }
            }
        });
        ((RelativeLayout) findViewById(R.id.rl_settings_notifications)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    Intent intent = new Intent(GroupChannelActivity.this, SettingsActivity.class);
                    intent.putExtra(KeyList.IntentExtraKey.SETTINGS_TITLE, GroupChannelActivity.this.getResources().getString(R.string.chat_module_settings_notifications));
                    intent.putExtra(KeyList.IntentExtraKey.SETTINGS_INFO, com.paytm.android.chat.c.f());
                    GroupChannelActivity.this.startActivity(intent);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        ChatNotificationHelper.INSTANCE.clearAllNotification(this);
    }

    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: private */
    public void a() {
        if (!this.f41665a.e(5)) {
            this.f41665a.c(5);
        } else {
            this.f41665a.d(5);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101 && i3 == -1) {
            ImageUtils.displayImageFromUrl(this, SharedPreferencesUtil.getProfileImg(), this.f41666b, b.a((Context) this, R.drawable.chat_icon_group_chat_deful_contact_pic));
            ImageUtils.displayImageFromUrl(this, SharedPreferencesUtil.getProfileImg(), this.f41667c, b.a((Context) this, R.drawable.chat_icon_group_chat_deful_contact_pic));
        }
    }
}
