package com.google.android.exoplayer2.b;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final b f31177a;

    /* renamed from: b  reason: collision with root package name */
    int f31178b;

    /* renamed from: c  reason: collision with root package name */
    public float f31179c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private final AudioManager f31180d;

    /* renamed from: e  reason: collision with root package name */
    private final a f31181e;

    /* renamed from: f  reason: collision with root package name */
    private c f31182f;

    /* renamed from: g  reason: collision with root package name */
    private int f31183g;

    /* renamed from: h  reason: collision with root package name */
    private AudioFocusRequest f31184h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31185i;

    public interface b {
        void c(int i2);

        void g();
    }

    public e(Context context, b bVar) {
        this.f31180d = (AudioManager) context.getApplicationContext().getSystemService(H5ResourceHandlerUtil.AUDIO);
        this.f31177a = bVar;
        this.f31181e = new a(this, (byte) 0);
        this.f31178b = 0;
    }

    public final int a(boolean z) {
        if (z) {
            return b();
        }
        return -1;
    }

    private int b() {
        int i2;
        if (this.f31183g == 0) {
            if (this.f31178b != 0) {
                b(true);
            }
            return 1;
        }
        if (this.f31178b == 0) {
            if (ae.f32499a >= 26) {
                i2 = d();
            } else {
                i2 = c();
            }
            this.f31178b = i2 == 1 ? 1 : 0;
        }
        int i3 = this.f31178b;
        if (i3 == 0) {
            return -1;
        }
        if (i3 == 2) {
            return 0;
        }
        return 1;
    }

    public final void b(boolean z) {
        if (this.f31183g != 0 || this.f31178b != 0) {
            if (this.f31183g != 1 || this.f31178b == -1 || z) {
                if (ae.f32499a >= 26) {
                    f();
                } else {
                    e();
                }
                this.f31178b = 0;
            }
        }
    }

    private int c() {
        return this.f31180d.requestAudioFocus(this.f31181e, ae.f(((c) com.google.android.exoplayer2.g.a.a(this.f31182f)).f31168d), this.f31183g);
    }

    private int d() {
        if (this.f31184h == null || this.f31185i) {
            AudioFocusRequest audioFocusRequest = this.f31184h;
            this.f31184h = (audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f31183g) : new AudioFocusRequest.Builder(audioFocusRequest)).setAudioAttributes(((c) com.google.android.exoplayer2.g.a.a(this.f31182f)).a()).setWillPauseWhenDucked(a()).setOnAudioFocusChangeListener(this.f31181e).build();
            this.f31185i = false;
        }
        return this.f31180d.requestAudioFocus(this.f31184h);
    }

    private void e() {
        this.f31180d.abandonAudioFocus(this.f31181e);
    }

    private void f() {
        AudioFocusRequest audioFocusRequest = this.f31184h;
        if (audioFocusRequest != null) {
            this.f31180d.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        c cVar = this.f31182f;
        return cVar != null && cVar.f31166b == 1;
    }

    class a implements AudioManager.OnAudioFocusChangeListener {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        public final void onAudioFocusChange(int i2) {
            if (i2 != -3) {
                if (i2 == -2) {
                    e.this.f31178b = 2;
                } else if (i2 == -1) {
                    e.this.f31178b = -1;
                } else if (i2 != 1) {
                    "Unknown focus change type: ".concat(String.valueOf(i2));
                    l.c();
                    return;
                } else {
                    e.this.f31178b = 1;
                }
            } else if (e.this.a()) {
                e.this.f31178b = 2;
            } else {
                e.this.f31178b = 3;
            }
            int i3 = e.this.f31178b;
            if (i3 == -1) {
                e.this.f31177a.c(-1);
                e.this.b(true);
            } else if (i3 != 0) {
                if (i3 == 1) {
                    e.this.f31177a.c(1);
                } else if (i3 == 2) {
                    e.this.f31177a.c(0);
                } else if (i3 != 3) {
                    throw new IllegalStateException("Unknown audio focus state: " + e.this.f31178b);
                }
            }
            float f2 = e.this.f31178b == 3 ? 0.2f : 1.0f;
            if (e.this.f31179c != f2) {
                e eVar = e.this;
                eVar.f31179c = f2;
                eVar.f31177a.g();
            }
        }
    }

    public final int a(boolean z, int i2) {
        if (!z) {
            b(false);
            return -1;
        } else if (i2 != 1) {
            return b();
        } else {
            if (z) {
                return 1;
            }
            return -1;
        }
    }
}
