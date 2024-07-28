package com.google.android.youtube.player;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.c;

public class d extends Fragment implements c.e {

    /* renamed from: a  reason: collision with root package name */
    private final a f37552a = new a(this, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private Bundle f37553b;

    /* renamed from: c  reason: collision with root package name */
    private YouTubePlayerView f37554c;

    /* renamed from: d  reason: collision with root package name */
    private String f37555d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public c.C0610c f37556e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37557f;

    final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void a(YouTubePlayerView youTubePlayerView) {
        }

        public final void a(YouTubePlayerView youTubePlayerView, String str, c.C0610c cVar) {
            d dVar = d.this;
            dVar.a(str, dVar.f37556e);
        }
    }

    public static d a() {
        return new d();
    }

    private void b() {
        YouTubePlayerView youTubePlayerView = this.f37554c;
        if (youTubePlayerView != null && this.f37556e != null) {
            youTubePlayerView.a(this.f37557f);
            this.f37554c.a(getActivity(), this, this.f37555d, this.f37556e, this.f37553b);
            this.f37553b = null;
            this.f37556e = null;
        }
    }

    public final void a(String str, c.C0610c cVar) {
        this.f37555d = com.google.android.youtube.player.internal.c.a(str, (Object) "Developer key cannot be null or empty");
        this.f37556e = cVar;
        b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f37553b = bundle != null ? bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f37554c = new YouTubePlayerView(getActivity(), (AttributeSet) null, 0, this.f37552a);
        b();
        return this.f37554c;
    }

    public void onDestroy() {
        if (this.f37554c != null) {
            FragmentActivity activity = getActivity();
            this.f37554c.b(activity == null || activity.isFinishing());
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f37554c.c(getActivity().isFinishing());
        this.f37554c = null;
        super.onDestroyView();
    }

    public void onPause() {
        this.f37554c.c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f37554c.b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        YouTubePlayerView youTubePlayerView = this.f37554c;
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", youTubePlayerView != null ? youTubePlayerView.e() : this.f37553b);
    }

    public void onStart() {
        super.onStart();
        this.f37554c.a();
    }

    public void onStop() {
        this.f37554c.d();
        super.onStop();
    }
}
