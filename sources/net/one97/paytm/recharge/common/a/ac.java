package net.one97.paytm.recharge.common.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.youtube.player.c;
import com.paytm.utility.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.am;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.model.CJRVideo;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class ac extends RecyclerView.a<a> {
    private static String k = e.az;
    /* access modifiers changed from: private */
    public static long l = System.currentTimeMillis();

    /* renamed from: a  reason: collision with root package name */
    Context f60445a;

    /* renamed from: b  reason: collision with root package name */
    Hashtable f60446b = new Hashtable();

    /* renamed from: c  reason: collision with root package name */
    RecyclerView f60447c;

    /* renamed from: d  reason: collision with root package name */
    List<CJRVideo> f60448d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    am f60449e;

    /* renamed from: f  reason: collision with root package name */
    public String f60450f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public j f60451g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f60452h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f60453i = -1;
    /* access modifiers changed from: private */
    public int j = -1;
    /* access modifiers changed from: private */
    public d m;
    /* access modifiers changed from: private */
    public String n;

    public final int getItemViewType(int i2) {
        return 0;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        final a aVar = (a) vVar;
        final CJRVideo cJRVideo = this.f60448d.get(i2);
        if (!TextUtils.isEmpty(cJRVideo.getTitle())) {
            aVar.f60466d.setText(cJRVideo.getTitle());
        }
        ImageView imageView = aVar.f60465c;
        String imageUrl = cJRVideo.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            w.a().a(imageUrl).a(imageView, (com.squareup.picasso.e) null);
        }
        aVar.f60464b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ba.a(ac.this.f60445a, view);
                if (((AppCompatActivity) ac.this.f60445a).getCurrentFocus() != null) {
                    ((AppCompatActivity) ac.this.f60445a).getCurrentFocus().requestFocusFromTouch();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ac.l >= 2000) {
                    long unused = ac.l = currentTimeMillis;
                    if (!TextUtils.isEmpty(cJRVideo.getVideoId())) {
                        FrameLayout frameLayout = new FrameLayout(ac.this.f60445a);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, aVar.f60465c.getHeight());
                        if (ac.this.f60452h != -1) {
                            RecyclerView.v findViewHolderForAdapterPosition = ac.this.f60447c.findViewHolderForAdapterPosition(ac.this.f60452h);
                            FrameLayout frameLayout2 = (FrameLayout) findViewHolderForAdapterPosition.itemView.findViewById(ac.this.f60453i);
                            frameLayout2.setVisibility(8);
                            ((Button) findViewHolderForAdapterPosition.itemView.findViewById(ac.this.j)).setVisibility(0);
                            frameLayout2.removeView(frameLayout2);
                            ac.this.f60451g.a().a(ac.this.f60451g.c(ac.this.f60453i)).b();
                            ac acVar = ac.this;
                            acVar.notifyItemChanged(acVar.f60452h);
                        }
                        int random = ((int) (Math.random() * 9999.0d)) + 111;
                        int random2 = ((int) (Math.random() * 9999.0d)) + 111;
                        frameLayout.setId(random2);
                        frameLayout.setVisibility(0);
                        aVar.f60464b.setId(random);
                        aVar.f60464b.setVisibility(8);
                        aVar.f60463a.addView(frameLayout, layoutParams);
                        com.google.android.youtube.player.d a2 = com.google.android.youtube.player.d.a();
                        a2.a(e.az, new c.C0610c() {
                            public final void a(final c cVar, boolean z) {
                                if (!z) {
                                    cVar.a(cJRVideo.getVideoId());
                                    cVar.b(true);
                                    cVar.a();
                                    cVar.a((c.b) new c.b() {
                                        public final void a(boolean z) {
                                            if (ac.this.f60449e != null) {
                                                ac.this.f60449e.a(cVar, z);
                                            }
                                        }
                                    });
                                    cVar.a((c.d) new c.d() {
                                        public final void a() {
                                            if (e.z.equalsIgnoreCase(ac.this.n)) {
                                                ac.this.m.a(ac.this.f60450f, "help_video_played", "", "", ab.f61496a, "", "");
                                            }
                                        }

                                        public final void b() {
                                            cVar.a(false);
                                        }
                                    });
                                }
                            }
                        });
                        ac.this.f60451g.a().a(frameLayout.getId(), (Fragment) a2).b();
                        int unused2 = ac.this.f60453i = random2;
                        int unused3 = ac.this.j = random;
                        int unused4 = ac.this.f60452h = i2;
                    }
                }
            }
        });
    }

    public ac(RecyclerView recyclerView, Context context, List<CJRVideo> list, j jVar, am amVar, String str, String str2) {
        this.f60445a = context;
        this.f60451g = jVar;
        this.f60447c = recyclerView;
        this.f60448d = list;
        this.f60449e = amVar;
        this.m = new d(this.f60445a);
        this.n = str;
        this.f60450f = str2;
        a();
    }

    public final int getItemCount() {
        return this.f60448d.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f60463a;

        /* renamed from: b  reason: collision with root package name */
        Button f60464b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f60465c;

        /* renamed from: d  reason: collision with root package name */
        TextView f60466d;

        public a(View view) {
            super(view);
            this.f60463a = (RelativeLayout) view.findViewById(R.id.imageview_rl);
            this.f60464b = (Button) view.findViewById(R.id.video_button);
            this.f60465c = (ImageView) view.findViewById(R.id.video_thumbnail);
            this.f60466d = (TextView) view.findViewById(R.id.video_title);
            this.f60464b.setBackground(f.b().a(view.getContext(), R.drawable.play_button));
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("(?<=watch\\?v=|/videos/|embed/)[^#&?]*").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        List<CJRVideo> list = this.f60448d;
        if (list != null) {
            for (CJRVideo next : list) {
                String a2 = a(next.getVideoUrl());
                if (!TextUtils.isEmpty(a2)) {
                    next.setVideoId(a2);
                } else {
                    this.f60448d.remove(next);
                }
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recharge_help_fragment_item, viewGroup, false));
    }
}
