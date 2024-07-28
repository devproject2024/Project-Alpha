package net.one97.paytm.feed.ui.feed.d.a;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.arthurivanets.arvi.model.PlaybackInfo;
import com.arthurivanets.arvi.widget.d;
import com.google.android.exoplayer2.ui.PlayerView;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.cw;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.base.c;
import net.one97.paytm.feed.ui.feed.video.FullVideoActivity;

public final class a extends c<cw, FeedGeneric, net.one97.paytm.feed.ui.feed.d.a> {

    /* renamed from: d  reason: collision with root package name */
    private String f35028d = "";

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.feed.ui.feed.a f35029e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ViewGroup viewGroup, final View view) {
        super(viewGroup, view);
        k.c(viewGroup, "viewGroup");
        k.c(view, "view");
        final ImageView imageView = (ImageView) view.findViewById(R.id.mute);
        k.a((Object) imageView, "mute");
        imageView.setSelected(true);
        imageView.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f35030a;

            {
                this.f35030a = r1;
            }

            public final void onClick(View view) {
                a aVar = this.f35030a;
                aVar.a(!a.a(aVar));
                ImageView imageView = imageView;
                k.a((Object) imageView, "mute");
                imageView.setSelected(a.a(this.f35030a));
                if (a.a(this.f35030a)) {
                    imageView.setImageDrawable(androidx.core.content.b.a(view.getContext(), R.drawable.feed_volume_off));
                } else {
                    imageView.setImageDrawable(androidx.core.content.b.a(view.getContext(), R.drawable.feed_volume_up));
                }
            }
        });
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.d.a.a$a  reason: collision with other inner class name */
    static final class C0577a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35033a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.feed.ui.feed.d.a f35034b;

        C0577a(a aVar, net.one97.paytm.feed.ui.feed.d.a aVar2) {
            this.f35033a = aVar;
            this.f35034b = aVar2;
        }

        public final void onClick(View view) {
            long j;
            FullVideoActivity.a aVar = FullVideoActivity.f35223a;
            k.a((Object) view, "it");
            Context context = view.getContext();
            k.a((Object) context, "it.context");
            FeedItem feedItem = this.f35034b.f35027e;
            com.arthurivanets.arvi.a.b m = this.f35033a.m();
            if (m != null) {
                j = m.i();
            } else {
                j = 0;
            }
            FullVideoActivity.a.a(context, feedItem, j);
        }
    }

    public static final class b extends ViewOutlineProvider {
        b() {
        }

        public final void getOutline(View view, Outline outline) {
            k.c(view, "view");
            k.c(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 15.0f);
        }
    }

    public final String g() {
        return this.f35028d;
    }

    public final void a(d dVar) {
        k.c(dVar, "playbackState");
        super.a(dVar);
        int i2 = b.f35035a[dVar.ordinal()];
        if (i2 == 1) {
            ProgressBar progressBar = ((cw) this.f34874c).k;
            k.a((Object) progressBar, "dataBinding.progress");
            progressBar.setVisibility(0);
        } else if (i2 == 2) {
            ProgressBar progressBar2 = ((cw) this.f34874c).k;
            k.a((Object) progressBar2, "dataBinding.progress");
            progressBar2.setVisibility(8);
            a(true);
        } else if (i2 == 3) {
            ProgressBar progressBar3 = ((cw) this.f34874c).k;
            k.a((Object) progressBar3, "dataBinding.progress");
            progressBar3.setVisibility(8);
        } else if (i2 == 4) {
            ProgressBar progressBar4 = ((cw) this.f34874c).k;
            k.a((Object) progressBar4, "dataBinding.progress");
            progressBar4.setVisibility(8);
        } else if (i2 == 5) {
            ProgressBar progressBar5 = ((cw) this.f34874c).k;
            k.a((Object) progressBar5, "dataBinding.progress");
            progressBar5.setVisibility(8);
        }
    }

    public final void a(net.one97.paytm.feed.ui.feed.d.a aVar, int i2) {
        String str;
        k.c(aVar, "viewModel");
        if (aVar.f35027e.getFeedGenericData().getStreamUrl() != null) {
            str = aVar.f35027e.getFeedGenericData().getStreamUrl();
            if (str == null) {
                k.a();
            }
        } else {
            str = aVar.f35027e.getFeedGenericData().getWebUrl();
            if (str == null) {
                k.a();
            }
        }
        this.f35028d = str;
        cw cwVar = (cw) this.f34874c;
        cwVar.setVariable(net.one97.paytm.feed.a.f33777d, aVar);
        cwVar.setVariable(net.one97.paytm.feed.a.f33780g, aVar.f35027e);
        cwVar.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
        cwVar.setVariable(net.one97.paytm.feed.a.m, Integer.valueOf(aVar.f35026d));
        if (this.f35029e == null) {
            this.f35029e = new net.one97.paytm.feed.ui.feed.a();
            cwVar.setVariable(net.one97.paytm.feed.a.f33775b, this.f35029e);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            cwVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            RoundedImageView roundedImageView = ((cw) this.f34874c).f34106a;
            k.a((Object) roundedImageView, "dataBinding.articleImage");
            roundedImageView.setClipToOutline(true);
        }
        ((cw) this.f34874c).executePendingBindings();
        PlayerView playerView = ((cw) this.f34874c).j;
        k.a((Object) playerView, "dataBinding.playerView");
        playerView.getVideoSurfaceView().setOnClickListener(new C0577a(this, aVar));
        if (Build.VERSION.SDK_INT > 20) {
            PlayerView playerView2 = ((cw) this.f34874c).j;
            k.a((Object) playerView2, "dataBinding.playerView");
            playerView2.setOutlineProvider(new b());
            PlayerView playerView3 = ((cw) this.f34874c).j;
            k.a((Object) playerView3, "dataBinding.playerView");
            playerView3.setClipToOutline(true);
        }
    }

    public static final /* synthetic */ boolean a(a aVar) {
        PlaybackInfo n = aVar.n();
        com.arthurivanets.arvi.a.b m = super.m();
        if (m != null) {
            return m.g().a();
        }
        return n.f31024b.f31028b;
    }
}
