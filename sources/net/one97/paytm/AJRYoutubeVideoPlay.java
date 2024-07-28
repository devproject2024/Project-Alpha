package net.one97.paytm;

import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.c;
import net.one97.paytm.common.utility.b;
import net.one97.paytm.paytm_finance.R;

public class AJRYoutubeVideoPlay extends YouTubeBaseActivity implements c.C0610c {

    /* renamed from: b  reason: collision with root package name */
    private YouTubePlayerView f51783b;

    /* renamed from: c  reason: collision with root package name */
    private String f51784c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ajr_youtube_videoplay_layout);
        this.f51784c = getIntent().getStringExtra(b.aA);
        this.f51783b = (YouTubePlayerView) findViewById(R.id.youtube_view);
        this.f51783b.a(b.az, (c.C0610c) this);
    }

    public final void a(c cVar, boolean z) {
        if (!z) {
            try {
                cVar.a(this.f51784c);
                cVar.a(true);
                cVar.b(false);
                cVar.a((c.d) new c.d() {
                    public final void a() {
                    }

                    public final void b() {
                        AJRYoutubeVideoPlay.this.finish();
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
