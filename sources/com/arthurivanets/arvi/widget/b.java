package com.arthurivanets.arvi.widget;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.arthurivanets.arvi.R;
import com.arthurivanets.arvi.a.b;
import com.arthurivanets.arvi.b.a.e;
import com.arthurivanets.arvi.c;
import com.arthurivanets.arvi.k;
import com.arthurivanets.arvi.model.PlaybackInfo;
import com.arthurivanets.arvi.model.VolumeInfo;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.ui.PlayerView;

public abstract class b extends RecyclerView.v implements b.a, b.C0527b, a {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f31036a;

    /* renamed from: b  reason: collision with root package name */
    public final PlayerView f31037b;

    /* access modifiers changed from: protected */
    public void a(d dVar) {
    }

    public b(ViewGroup viewGroup, View view) {
        super(view);
        this.f31036a = viewGroup;
        this.f31037b = (PlayerView) view.findViewById(R.id.player_view);
    }

    public final void a() {
        int i2;
        if (k()) {
            PlaybackInfo n = n();
            VolumeInfo volumeInfo = n.f31024b;
            a(n);
            com.arthurivanets.arvi.a.b b2 = k.a(this.itemView.getContext()).b(k.f31017a, h());
            b2.a();
            b2.a(this.f31037b);
            b2.g().a(volumeInfo.f31027a);
            b2.g().a(volumeInfo.f31028b);
            b2.a(k.a(this.itemView.getContext()).a(k.f31017a, Uri.parse(g())));
            b2.a((b.a) this);
            b2.a((b.C0527b) this);
            b2.a(n.f31023a);
            b2.b();
            b2.c();
            com.arthurivanets.arvi.a.b m = m();
            if (m != null) {
                i2 = m.h();
            } else {
                i2 = 1;
            }
            a(i2 == 3 ? d.READY : d.STARTED);
        }
    }

    public final void b() {
        if (k()) {
            com.arthurivanets.arvi.a.b m = m();
            PlaybackInfo n = n();
            if (m != null) {
                m.d();
                m.b((b.C0527b) this);
                n.f31023a = m.i();
                a(n);
            }
            a(d.PAUSED);
        }
    }

    public final void c() {
        if (k()) {
            PlaybackInfo n = n();
            com.arthurivanets.arvi.a.b m = m();
            if (m != null) {
                m.d();
                m.b(this.f31037b);
                m.a(true);
                m.a((b.a) null);
                m.b((b.C0527b) this);
                n.f31023a = 0;
                a(n);
            }
            a(d.STOPPED);
        }
    }

    public final void d() {
        if (k()) {
            com.arthurivanets.arvi.a.b m = m();
            k.a(this.itemView.getContext()).d(k.f31017a, h());
            e.a().a(h());
            if (m != null) {
                m.d();
                m.a(true);
                m.b(this.f31037b);
                m.a((b.a) null);
                m.b((b.C0527b) this);
            }
            a(d.STOPPED);
        }
    }

    public final View e() {
        return this.f31037b;
    }

    public final ViewParent f() {
        return (ViewParent) this.itemView;
    }

    public final com.arthurivanets.arvi.a.b m() {
        return k.a(this.itemView.getContext()).a(k.f31017a, h());
    }

    private void a(PlaybackInfo playbackInfo) {
        e.a().a(h(), playbackInfo);
    }

    public final PlaybackInfo n() {
        return e.a().b(h(), new PlaybackInfo());
    }

    public final c i() {
        return k.f31017a;
    }

    public final String h() {
        return g();
    }

    public final void a(boolean z) {
        PlaybackInfo n = n();
        n.f31024b.f31028b = z;
        a(n);
        com.arthurivanets.arvi.a.b m = m();
        if (m != null) {
            m.g().a(z);
        }
    }

    public final boolean j() {
        com.arthurivanets.arvi.a.b m = m();
        return m != null && m.j();
    }

    public final boolean k() {
        return this.f31037b != null;
    }

    private boolean o() {
        com.arthurivanets.arvi.a.b m = m();
        return m != null && m.h() == 4;
    }

    public final boolean b(com.arthurivanets.arvi.a.b bVar) {
        return k() && bVar.c(this.f31037b);
    }

    public final void a(com.arthurivanets.arvi.a.b bVar) {
        PlayerView playerView = this.f31037b;
        if (playerView != null) {
            bVar.b(playerView);
        }
    }

    public final void a(i iVar) {
        new StringBuilder("onPlayerError: ").append(iVar.getLocalizedMessage());
        a(d.ERROR);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0048 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l() {
        /*
            r4 = this;
            com.arthurivanets.arvi.b.b.c.a((java.lang.Object) r4)
            android.view.ViewParent r0 = r4.f()
            if (r0 == 0) goto L_0x003f
            android.view.View r0 = r4.e()
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r0.getDrawingRect(r1)
            int r3 = r1.width()
            int r1 = r1.height()
            int r3 = r3 * r1
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            boolean r0 = r0.getGlobalVisibleRect(r2, r1)
            if (r0 == 0) goto L_0x003f
            if (r3 <= 0) goto L_0x003f
            int r0 = r2.height()
            int r1 = r2.width()
            int r0 = r0 * r1
            float r0 = (float) r0
            float r1 = (float) r3
            float r0 = r0 / r1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            r1 = 1056964608(0x3f000000, float:0.5)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0048
            r0 = 1
            return r0
        L_0x0048:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arthurivanets.arvi.widget.b.l():boolean");
    }

    public final void a(int i2) {
        if (i2 == 1) {
            n().f31025c = o();
            a(d.STOPPED);
        } else if (i2 == 2) {
            n().f31025c = o();
            a(d.BUFFERING);
        } else if (i2 == 3) {
            n().f31025c = o();
            a(d.READY);
        } else if (i2 == 4) {
            a(d.STOPPED);
            PlaybackInfo n = n();
            n.f31023a = 0;
            n.f31025c = o();
            a(n);
        }
    }
}
