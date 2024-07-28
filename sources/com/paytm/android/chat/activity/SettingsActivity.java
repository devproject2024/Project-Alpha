package com.paytm.android.chat.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.n;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.bean.SettingItemBean;
import com.paytm.android.chat.bean.SettingsInfoBean;
import com.paytm.android.chat.c;
import com.paytm.android.chat.network.requests.SetUserSettingsRequest;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.q;
import io.reactivex.rxjava3.d.g;
import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    String f41723a = "";

    /* renamed from: b  reason: collision with root package name */
    n f41724b = null;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f41725c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f41726d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_settings);
        this.f41725c = (RecyclerView) findViewById(R.id.settings_rv);
        this.f41726d = (FrameLayout) findViewById(R.id.settings_empty_view);
        this.f41725c.setLayoutManager(new LinearLayoutManager(this));
        this.f41726d.setVisibility(8);
        this.f41725c.setVisibility(0);
        setSupportActionBar((Toolbar) findViewById(R.id.settings_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
            getSupportActionBar().e(R.drawable.chat_ic_back_arrow);
        }
        Intent intent = getIntent();
        if (intent.hasExtra(KeyList.IntentExtraKey.SETTINGS_TITLE)) {
            this.f41723a = intent.getStringExtra(KeyList.IntentExtraKey.SETTINGS_TITLE);
        }
        String str = this.f41723a;
        if (str != null && !str.isEmpty() && getSupportActionBar() != null) {
            getSupportActionBar().a((CharSequence) this.f41723a);
        }
    }

    public void onResume() {
        int i2;
        String str;
        int i3;
        String str2;
        String str3;
        super.onResume();
        String str4 = this.f41723a;
        SettingsInfoBean f2 = c.f();
        ArrayList arrayList = new ArrayList();
        if (getResources().getString(R.string.chat_module_settings_privacy).equals(str4)) {
            String[] stringArray = getResources().getStringArray(R.array.chat_module_settings_privacy);
            TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.chat_module_settings_icon_privacy);
            for (int i4 = 0; i4 < stringArray.length; i4++) {
                String str5 = stringArray[i4];
                SettingItemBean settingItemBean = new SettingItemBean();
                settingItemBean.setTitle(str5);
                settingItemBean.setDrawableIcon(obtainTypedArray.getResourceId(i4, 0));
                settingItemBean.setStatus(0);
                if (getResources().getString(R.string.chat_module_settings_privacy_profile_pic).equals(str5) || getResources().getString(R.string.chat_module_settings_privacy_online_status).equals(str5) || getResources().getString(R.string.chat_module_settings_privacy_msg_from).equals(str5)) {
                    if (getResources().getString(R.string.chat_module_settings_privacy_profile_pic).equals(str5)) {
                        i3 = f2.settings_privacy_profile_pic;
                    } else if (getResources().getString(R.string.chat_module_settings_privacy_online_status).equals(str5)) {
                        i3 = f2.settings_privacy_online_status;
                    } else if (getResources().getString(R.string.chat_module_settings_privacy_msg_from).equals(str5)) {
                        i3 = f2.settings_privacy_msg_from;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 1) {
                        str2 = getResources().getString(R.string.chat_module_settings_privacy_visible_contacts);
                    } else if (i3 != 2) {
                        str2 = getResources().getString(R.string.chat_module_settings_privacy_visible_everyone);
                    } else {
                        str2 = !getResources().getString(R.string.chat_module_settings_privacy_msg_from).equals(str5) ? getResources().getString(R.string.chat_module_settings_privacy_visible_none) : "";
                    }
                    settingItemBean.setValue(String.valueOf(i3));
                    settingItemBean.setIntro(str2);
                } else if (getResources().getString(R.string.chat_module_settings_privacy_discover).equals(str5)) {
                    int i5 = f2.settings_privacy_discover;
                    switch (i5) {
                        case 1:
                            str3 = getResources().getString(R.string.chat_module_settings_privacy_discover_qr_code);
                            break;
                        case 2:
                            str3 = getResources().getString(R.string.chat_module_settings_privacy_discover_email);
                            break;
                        case 3:
                            str3 = getResources().getString(R.string.chat_module_settings_privacy_discover_qr_code) + " & " + getResources().getString(R.string.chat_module_settings_privacy_discover_email);
                            break;
                        case 4:
                            str3 = getResources().getString(R.string.chat_module_settings_privacy_discover_phone);
                            break;
                        case 5:
                            str3 = getResources().getString(R.string.chat_module_settings_privacy_discover_qr_code) + " & " + getResources().getString(R.string.chat_module_settings_privacy_discover_phone);
                            break;
                        case 6:
                            str3 = getResources().getString(R.string.chat_module_settings_privacy_discover_email) + " & " + getResources().getString(R.string.chat_module_settings_privacy_discover_phone);
                            break;
                        default:
                            str3 = getResources().getString(R.string.chat_module_settings_privacy_discover_qr_code) + " & " + getResources().getString(R.string.chat_module_settings_privacy_discover_email) + " & " + getResources().getString(R.string.chat_module_settings_privacy_discover_phone);
                            break;
                    }
                    settingItemBean.setValue(String.valueOf(i5));
                    settingItemBean.setIntro(str3);
                } else if (getResources().getString(R.string.chat_module_settings_privacy_blocked_users).equals(str5)) {
                    settingItemBean.setIntro(String.format(getResources().getString(R.string.chat_module_settings_privacy_blocked_users_intro), new Object[]{"--"}));
                    ChatManager.b().f40994f.getBlockedUserList().a(new g(settingItemBean, i4) {
                        private final /* synthetic */ SettingItemBean f$1;
                        private final /* synthetic */ int f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void accept(Object obj) {
                            SettingsActivity.this.a(this.f$1, this.f$2, (List) obj);
                        }
                    }, (g<? super Throwable>) $$Lambda$SettingsActivity$0a7tG7zNzURc6ZFarr_NxXOBoCY.INSTANCE);
                }
                arrayList.add(settingItemBean);
            }
        } else if (getResources().getString(R.string.chat_module_settings_media).equals(str4)) {
            String[] stringArray2 = getResources().getStringArray(R.array.chat_module_settings_media);
            TypedArray obtainTypedArray2 = getResources().obtainTypedArray(R.array.chat_module_settings_icon_media);
            for (int i6 = 0; i6 < stringArray2.length; i6++) {
                String str6 = stringArray2[i6];
                SettingItemBean settingItemBean2 = new SettingItemBean();
                settingItemBean2.setTitle(str6);
                settingItemBean2.setDrawableIcon(obtainTypedArray2.getResourceId(i6, 0));
                if (getResources().getString(R.string.chat_module_settings_media_save2camera_roll).equals(str6)) {
                    if (f2.settings_media_save2camera_roll) {
                        settingItemBean2.setStatus(1);
                    } else {
                        settingItemBean2.setStatus(2);
                    }
                    settingItemBean2.setIntro(getResources().getString(R.string.chat_module_settings_media_save2camera_roll_intro));
                } else {
                    if (getResources().getString(R.string.chat_module_settings_media_photos).equals(str6)) {
                        i2 = f2.settings_media_photos;
                    } else if (getResources().getString(R.string.chat_module_settings_media_videos).equals(str6)) {
                        i2 = f2.settings_media_videos;
                    } else if (getResources().getString(R.string.chat_module_settings_media_documents).equals(str6)) {
                        i2 = f2.settings_media_documents;
                    } else if (getResources().getString(R.string.chat_module_settings_media_audio).equals(str6)) {
                        i2 = f2.settings_media_audio;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 1) {
                        str = getResources().getString(R.string.chat_module_settings_media_download_wifi_cellular);
                    } else if (i2 != 2) {
                        str = getResources().getString(R.string.chat_module_settings_media_download_wifi);
                    } else {
                        str = getResources().getString(R.string.chat_module_settings_media_download_never);
                    }
                    settingItemBean2.setStatus(0);
                    settingItemBean2.setValue(String.valueOf(i2));
                    settingItemBean2.setIntro(str);
                }
                arrayList.add(settingItemBean2);
            }
        } else if (getResources().getString(R.string.chat_module_settings_notifications).equals(str4)) {
            String[] stringArray3 = getResources().getStringArray(R.array.chat_module_settings_notifications);
            TypedArray obtainTypedArray3 = getResources().obtainTypedArray(R.array.chat_module_settings_icon_notifications);
            for (int i7 = 0; i7 < stringArray3.length; i7++) {
                String str7 = stringArray3[i7];
                SettingItemBean settingItemBean3 = new SettingItemBean();
                settingItemBean3.setTitle(str7);
                settingItemBean3.setDrawableIcon(obtainTypedArray3.getResourceId(i7, 0));
                if (getResources().getString(R.string.chat_module_settings_notifications_sound).equals(str7)) {
                    if (f2.settings_notifications_sound) {
                        settingItemBean3.setStatus(1);
                    } else {
                        settingItemBean3.setStatus(2);
                    }
                    settingItemBean3.setIntro(getResources().getString(R.string.chat_module_settings_notifications_sound_intro));
                } else if (getResources().getString(R.string.chat_module_settings_notifications_vibrate).equals(str7)) {
                    if (f2.settings_notifications_vibrate) {
                        settingItemBean3.setStatus(1);
                    } else {
                        settingItemBean3.setStatus(2);
                    }
                    settingItemBean3.setIntro(getResources().getString(R.string.chat_module_settings_notifications_vibrate_intro));
                } else if (getResources().getString(R.string.chat_module_settings_notifications_lock_screen).equals(str7)) {
                    if (f2.settings_notifications_lock_screen) {
                        settingItemBean3.setStatus(1);
                    } else {
                        settingItemBean3.setStatus(2);
                    }
                    settingItemBean3.setIntro(getResources().getString(R.string.chat_module_settings_notifications_lock_screen_intro));
                } else if (getResources().getString(R.string.chat_module_settings_notifications_lock_screen_preview).equals(str7)) {
                    if (f2.settings_notifications_lock_screen_preview) {
                        settingItemBean3.setStatus(1);
                    } else {
                        settingItemBean3.setStatus(2);
                    }
                    settingItemBean3.setIntro(getResources().getString(R.string.chat_module_settings_notifications_lock_screen_preview_intro));
                } else if (getResources().getString(R.string.chat_module_settings_notifications_lock_screen_name).equals(str7)) {
                    if (f2.settings_notifications_lock_screen_name) {
                        settingItemBean3.setStatus(1);
                    } else {
                        settingItemBean3.setStatus(2);
                    }
                    settingItemBean3.setIntro(getResources().getString(R.string.chat_module_settings_notifications_lock_screen_name_intro));
                }
                arrayList.add(settingItemBean3);
            }
        }
        this.f41724b = new n(this, arrayList);
        this.f41725c.setAdapter(this.f41724b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SettingItemBean settingItemBean, int i2, List list) throws Throwable {
        String string = getResources().getString(R.string.chat_module_settings_privacy_blocked_users_intro);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size());
        settingItemBean.setIntro(String.format(string, new Object[]{sb.toString()}));
        n nVar = this.f41724b;
        if (nVar != null) {
            nVar.notifyItemChanged(i2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th) throws Throwable {
        SettingsActivity.class.getSimpleName();
        q.c("getUserInfo Error");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onDestroy() {
        n nVar = this.f41724b;
        if (nVar != null && nVar.f41445d) {
            new SetUserSettingsRequest(SharedPreferencesUtil.getUserId(), c.f(), new a<String>() {
                public final /* synthetic */ void a(Object obj) {
                    q.b("SetUserSettingsRequest onSuccess:".concat(String.valueOf((String) obj)));
                }

                public final void a(int i2, String str) {
                    q.b("onFailure:[" + i2 + "]" + str);
                }
            });
        }
        super.onDestroy();
    }
}
