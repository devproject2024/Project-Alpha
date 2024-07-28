package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.c;

public class YouTubeBaseActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    a f37526a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public YouTubePlayerView f37527b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f37528c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bundle f37529d;

    final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(YouTubeBaseActivity youTubeBaseActivity, byte b2) {
            this();
        }

        public final void a(YouTubePlayerView youTubePlayerView) {
            if (!(YouTubeBaseActivity.this.f37527b == null || YouTubeBaseActivity.this.f37527b == youTubePlayerView)) {
                YouTubeBaseActivity.this.f37527b.c(true);
            }
            YouTubePlayerView unused = YouTubeBaseActivity.this.f37527b = youTubePlayerView;
            if (YouTubeBaseActivity.this.f37528c > 0) {
                youTubePlayerView.a();
            }
            if (YouTubeBaseActivity.this.f37528c >= 2) {
                youTubePlayerView.b();
            }
        }

        public final void a(YouTubePlayerView youTubePlayerView, String str, c.C0610c cVar) {
            YouTubeBaseActivity youTubeBaseActivity = YouTubeBaseActivity.this;
            youTubePlayerView.a(youTubeBaseActivity, youTubePlayerView, str, cVar, youTubeBaseActivity.f37529d);
            Bundle unused = YouTubeBaseActivity.this.f37529d = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f37526a = new a(this, (byte) 0);
        this.f37529d = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        YouTubePlayerView youTubePlayerView = this.f37527b;
        if (youTubePlayerView != null) {
            youTubePlayerView.b(isFinishing());
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f37528c = 1;
        YouTubePlayerView youTubePlayerView = this.f37527b;
        if (youTubePlayerView != null) {
            youTubePlayerView.c();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f37528c = 2;
        YouTubePlayerView youTubePlayerView = this.f37527b;
        if (youTubePlayerView != null) {
            youTubePlayerView.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        YouTubePlayerView youTubePlayerView = this.f37527b;
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", youTubePlayerView != null ? youTubePlayerView.e() : this.f37529d);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f37528c = 1;
        YouTubePlayerView youTubePlayerView = this.f37527b;
        if (youTubePlayerView != null) {
            youTubePlayerView.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f37528c = 0;
        YouTubePlayerView youTubePlayerView = this.f37527b;
        if (youTubePlayerView != null) {
            youTubePlayerView.d();
        }
        super.onStop();
    }
}
