package net.one97.paytm.chat;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import net.one97.paytm.chat.ChatImplProvider;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;

public class ChatInitActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        ChatImplProvider.init(getApplication());
        Bundle bundleExtra = getIntent().getBundleExtra(CommonDynamicLoaderActivity.EXTRA_TARGET_ACTIVITY_ARGS);
        if (!(bundleExtra == null || (string = bundleExtra.getString("launch_page")) == null || string.isEmpty())) {
            if (string.equals("channel_list")) {
                ChatImplProvider.a aVar = ChatImplProvider.f49553a;
                ChatImplProvider.l.b(this);
            } else if (string.equals("channel")) {
                Intent intent = getIntent();
                intent.setClassName(this, "com.paytm.android.chat.activity.APCChatActivity");
                startActivity(intent);
            } else if (string.equals("settings")) {
                ChatImplProvider.a aVar2 = ChatImplProvider.f49553a;
                ChatImplProvider unused = ChatImplProvider.l;
                ChatImplProvider.c(this);
                Intent intent2 = getIntent();
                intent2.setClassName(this, "com.paytm.android.chat.activity.PaytmChatSettingsActivity");
                startActivity(intent2);
            }
        }
        finish();
    }
}
