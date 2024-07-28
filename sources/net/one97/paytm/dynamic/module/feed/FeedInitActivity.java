package net.one97.paytm.dynamic.module.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.d;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;

public class FeedInitActivity extends AppCompatActivity {
    private final int LOGIN_REQ_CODE = 1232;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InboxFeedDataProvider.INSTANCE.initFeedModule(getApplication());
        InboxFeedDataProvider.INSTANCE.lateInitFeedModule(this);
        initialize();
    }

    private void initialize() {
        Intent intent = getIntent();
        if (intent.getAction() != null && intent.getAction().equalsIgnoreCase("deepLink")) {
            if (!"sheroes".equals(intent.getStringExtra("urlType"))) {
                intent.setClass(this, FeedCommentActivity.class);
                startActivity(intent);
            } else if (d.c(this)) {
                InboxFeedDataProvider.INSTANCE.openSheroes(this);
            } else {
                initiateLogin();
                return;
            }
        }
        finish();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
        a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }

    private void initiateLogin() {
        Intent intent = new Intent(this, AJRAuthActivity.class);
        intent.putExtra("set_result_required", true);
        startActivityForResult(intent, 1232);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1232 && i3 == -1) {
            initialize();
        } else {
            finish();
        }
    }
}
