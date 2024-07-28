package net.one97.paytm.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.c;
import net.one97.paytm.common.utility.b;
import net.one97.paytm.paytm_finance.R;

public class HelpVideoPlayer extends YouTubeBaseActivity implements View.OnClickListener, c.C0610c {

    /* renamed from: b  reason: collision with root package name */
    private YouTubePlayerView f52297b;

    /* renamed from: c  reason: collision with root package name */
    private String f52298c;

    /* renamed from: d  reason: collision with root package name */
    private String f52299d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f52300e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youtube_play);
        this.f52298c = getIntent().getStringExtra(b.aA);
        String str = this.f52298c;
        if (str != null) {
            String e2 = com.paytm.utility.b.e(str);
            if (e2 == null) {
                e2 = com.paytm.utility.b.f(this.f52298c);
            }
            if (e2 != null) {
                this.f52299d = e2;
            } else {
                finish();
            }
        }
        this.f52297b = (YouTubePlayerView) findViewById(R.id.youtube_view);
        this.f52297b.a(b.az, (c.C0610c) this);
        this.f52300e = (TextView) findViewById(R.id.done);
        this.f52300e.setOnClickListener(this);
    }

    public final void a(c cVar, boolean z) {
        if (!z) {
            try {
                cVar.a(this.f52299d);
                cVar.a(false);
                cVar.b(false);
            } catch (Exception unused) {
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.done) {
            finish();
        }
    }
}
