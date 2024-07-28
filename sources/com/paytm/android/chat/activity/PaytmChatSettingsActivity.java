package com.paytm.android.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.c;
import com.paytm.android.chat.utils.KeyList;
import kotlin.g.b.k;

public final class PaytmChatSettingsActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f41706a;

    /* renamed from: b  reason: collision with root package name */
    private View f41707b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f41708c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_paytm_chat_settings);
        View findViewById = findViewById(R.id.lyt_blocked_contacts);
        k.a((Object) findViewById, "findViewById(R.id.lyt_blocked_contacts)");
        this.f41706a = findViewById;
        View findViewById2 = findViewById(R.id.lyt_media_download);
        k.a((Object) findViewById2, "findViewById(R.id.lyt_media_download)");
        this.f41707b = findViewById2;
        View findViewById3 = findViewById(R.id.back_image);
        k.a((Object) findViewById3, "findViewById(R.id.back_image)");
        this.f41708c = (ImageView) findViewById3;
        View view = this.f41706a;
        if (view == null) {
            k.a("mBlockedContactsLyt");
        }
        View.OnClickListener onClickListener = this;
        view.setOnClickListener(onClickListener);
        View view2 = this.f41707b;
        if (view2 == null) {
            k.a("mMediaDownloadSettingsLyt");
        }
        view2.setOnClickListener(onClickListener);
        ImageView imageView = this.f41708c;
        if (imageView == null) {
            k.a("mBackButton");
        }
        imageView.setOnClickListener(onClickListener);
    }

    public final void onStart() {
        super.onStart();
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.lyt_blocked_contacts;
        if (valueOf != null && valueOf.intValue() == i2) {
            Intent intent = new Intent(this, SubSettingsActivity.class);
            intent.putExtra(KeyList.IntentExtraKey.SETTINGS_TITLE, getResources().getString(R.string.chat_module_settings_block_list));
            intent.putExtra(KeyList.IntentExtraKey.SETTINGS_VALUES, "0");
            startActivity(intent);
            return;
        }
        int i3 = R.id.lyt_media_download;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent2 = new Intent(this, SettingsActivity.class);
            intent2.putExtra(KeyList.IntentExtraKey.SETTINGS_TITLE, getResources().getString(R.string.chat_module_settings_media));
            intent2.putExtra(KeyList.IntentExtraKey.SETTINGS_INFO, c.f());
            startActivity(intent2);
            return;
        }
        int i4 = R.id.back_image;
        if (valueOf != null && valueOf.intValue() == i4) {
            onBackPressed();
        }
    }

    public final void onResume() {
        super.onResume();
        c.a(this);
    }

    public final void onPause() {
        c.e();
        super.onPause();
    }

    public final void onDestroy() {
        c.e();
        super.onDestroy();
    }
}
