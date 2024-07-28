package net.one97.paytm.o2o.movies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.AJRFilmographyPage;
import net.one97.paytm.o2o.movies.actor.ActorBaseItemData;
import net.one97.paytm.o2o.movies.actor.CJRActorModel;
import net.one97.paytm.o2o.movies.actor.CJRActorPageAdapter;
import net.one97.paytm.o2o.movies.actor.itemdata.ActorIntroItemData;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieVideoViewCountResponse;
import net.one97.paytm.o2o.movies.viewmodel.CJRDisclaimerModel;
import net.one97.paytm.o2o.movies.viewmodel.b;
import org.json.JSONObject;

public class AJRActorPage extends AppBaseActivity implements CJRActorPageAdapter.ActorPageClickListener {

    /* renamed from: a  reason: collision with root package name */
    CJRActorModel f73882a;

    /* renamed from: b  reason: collision with root package name */
    List<String> f73883b = null;

    /* renamed from: c  reason: collision with root package name */
    List<ActorBaseItemData> f73884c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    RecyclerView f73885d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f73886e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f73887f;

    /* renamed from: g  reason: collision with root package name */
    private Button f73888g;

    /* renamed from: h  reason: collision with root package name */
    private CJRActorPageAdapter f73889h;

    /* renamed from: i  reason: collision with root package name */
    private int f73890i;
    private b j;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajractor_page);
        this.f73890i = getIntent().getIntExtra("actor_id", -1);
        boolean z = false;
        if (this.f73890i == -1) {
            Toast.makeText(this, "Something went wrong. Please check back later!", 0).show();
            z = true;
        }
        if (!z) {
            this.f73885d = (RecyclerView) findViewById(R.id.actorRv);
            this.f73886e = (ProgressBar) findViewById(R.id.progress_bar);
            this.f73887f = (RelativeLayout) findViewById(R.id.api_failure_rlt);
            this.f73888g = (Button) findViewById(R.id.error_cta_btn);
            findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRActorPage.this.b(view);
                }
            });
            this.f73888g.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRActorPage.this.a(view);
                }
            });
            this.f73885d.setLayoutManager(new LinearLayoutManager(this));
            this.f73889h = new CJRActorPageAdapter(this.f73884c, this, this);
            this.f73885d.setAdapter(this.f73889h);
            a(true);
            this.j = (b) am.a((FragmentActivity) this).a(b.class);
            this.j.a(this.f73890i).observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRActorPage.this.a((CJRActorModel) obj);
                }
            });
            b bVar = this.j;
            if (bVar.f76058b == null) {
                bVar.f76058b = new y<>();
            }
            bVar.a("http://assets.paytm.com/images/cinema/disclaimer-5a581701-84ae-4b84-a9f3-715917eafb9e.txt", new CJRDisclaimerModel());
            bVar.f76058b.observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRActorPage.this.a((CJRDisclaimerModel) obj);
                }
            });
            this.j.f76057a.observe(this, new z() {
                public final void onChanged(Object obj) {
                    AJRActorPage.this.a((Boolean) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(true);
        this.j.a(this.f73890i).observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRActorPage.this.b((CJRActorModel) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(CJRActorModel cJRActorModel) {
        this.f73882a = cJRActorModel;
        a();
        a(false);
        this.f73887f.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRActorModel cJRActorModel) {
        this.f73882a = cJRActorModel;
        a();
        a(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRDisclaimerModel cJRDisclaimerModel) {
        if (cJRDisclaimerModel != null) {
            this.f73883b = cJRDisclaimerModel.disclaimers;
        }
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        this.f73887f.setVisibility(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x018f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r0 = r7.f73884c     // Catch:{ all -> 0x0190 }
            r0.clear()     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x018e
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.String r0 = r0.name     // Catch:{ all -> 0x0190 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0190 }
            r1 = 1
            if (r0 != 0) goto L_0x00c4
            net.one97.paytm.o2o.movies.actor.ActorBaseItemData r0 = new net.one97.paytm.o2o.movies.actor.ActorBaseItemData     // Catch:{ all -> 0x0190 }
            r0.<init>()     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.itemdata.ActorIntroItemData r2 = new net.one97.paytm.o2o.movies.actor.itemdata.ActorIntroItemData     // Catch:{ all -> 0x0190 }
            r2.<init>()     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r3.name     // Catch:{ all -> 0x0190 }
            r2.name = r3     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r3.birthName     // Catch:{ all -> 0x0190 }
            r2.birthName = r3     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r3.bornInfo     // Catch:{ all -> 0x0190 }
            r2.bornInfo = r3     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r3.height     // Catch:{ all -> 0x0190 }
            r2.height = r3     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r3.image     // Catch:{ all -> 0x0190 }
            r2.image = r3     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r3.summary     // Catch:{ all -> 0x0190 }
            r2.summary = r3     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.util.List<java.lang.String> r3 = r3.nickNames     // Catch:{ all -> 0x0190 }
            boolean r3 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r3)     // Catch:{ all -> 0x0190 }
            if (r3 != 0) goto L_0x008c
            java.lang.String r3 = ""
            net.one97.paytm.o2o.movies.actor.CJRActorModel r4 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.util.List<java.lang.String> r4 = r4.nickNames     // Catch:{ all -> 0x0190 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0190 }
        L_0x0057:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0190 }
            if (r5 == 0) goto L_0x008a
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0190 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0190 }
            int r6 = r3.length()     // Catch:{ all -> 0x0190 }
            if (r6 <= 0) goto L_0x007a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0190 }
            r6.<init>()     // Catch:{ all -> 0x0190 }
            r6.append(r3)     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = ", "
            r6.append(r3)     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0190 }
        L_0x007a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0190 }
            r6.<init>()     // Catch:{ all -> 0x0190 }
            r6.append(r3)     // Catch:{ all -> 0x0190 }
            r6.append(r5)     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0190 }
            goto L_0x0057
        L_0x008a:
            r2.nickName = r3     // Catch:{ all -> 0x0190 }
        L_0x008c:
            r7.a((net.one97.paytm.o2o.movies.actor.itemdata.ActorIntroItemData) r2)     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.Integer r3 = r3.moviesCount     // Catch:{ all -> 0x0190 }
            if (r3 == 0) goto L_0x00b9
            net.one97.paytm.o2o.movies.actor.CJRActorModel r3 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.Integer r3 = r3.moviesCount     // Catch:{ all -> 0x0190 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0190 }
            if (r3 <= r1) goto L_0x00a2
            java.lang.String r3 = " Movies"
            goto L_0x00a4
        L_0x00a2:
            java.lang.String r3 = " Movie"
        L_0x00a4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0190 }
            r4.<init>()     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r5 = r7.f73882a     // Catch:{ all -> 0x0190 }
            java.lang.Integer r5 = r5.moviesCount     // Catch:{ all -> 0x0190 }
            r4.append(r5)     // Catch:{ all -> 0x0190 }
            r4.append(r3)     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0190 }
            r2.movieCountText = r3     // Catch:{ all -> 0x0190 }
        L_0x00b9:
            r0.templateId = r1     // Catch:{ all -> 0x0190 }
            r0.introData = r2     // Catch:{ all -> 0x0190 }
            r0.showDivider = r1     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r2 = r7.f73884c     // Catch:{ all -> 0x0190 }
            r2.add(r0)     // Catch:{ all -> 0x0190 }
        L_0x00c4:
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorMovieData r0 = r0.movies     // Catch:{ all -> 0x0190 }
            r2 = 2
            if (r0 == 0) goto L_0x00f6
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorMovieData r0 = r0.movies     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.CJRActorMovieModel> r0 = r0.movieData     // Catch:{ all -> 0x0190 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0190 }
            if (r0 != 0) goto L_0x00f6
            net.one97.paytm.o2o.movies.actor.ActorBaseItemData r0 = new net.one97.paytm.o2o.movies.actor.ActorBaseItemData     // Catch:{ all -> 0x0190 }
            r0.<init>()     // Catch:{ all -> 0x0190 }
            r0.templateId = r2     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData r3 = new net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData     // Catch:{ all -> 0x0190 }
            r3.<init>()     // Catch:{ all -> 0x0190 }
            r3.templateId = r2     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r4 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorMovieData r4 = r4.movies     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.CJRActorMovieModel> r4 = r4.movieData     // Catch:{ all -> 0x0190 }
            r3.movies = r4     // Catch:{ all -> 0x0190 }
            r0.elementData = r3     // Catch:{ all -> 0x0190 }
            r0.showDivider = r1     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r3 = r7.f73884c     // Catch:{ all -> 0x0190 }
            r3.add(r0)     // Catch:{ all -> 0x0190 }
        L_0x00f6:
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRMovieVideoData r0 = r0.videos     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x0127
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRMovieVideoData r0 = r0.videos     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.CJRMovieVideoModelNew> r0 = r0.videoData     // Catch:{ all -> 0x0190 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0190 }
            if (r0 != 0) goto L_0x0127
            net.one97.paytm.o2o.movies.actor.ActorBaseItemData r0 = new net.one97.paytm.o2o.movies.actor.ActorBaseItemData     // Catch:{ all -> 0x0190 }
            r0.<init>()     // Catch:{ all -> 0x0190 }
            r0.templateId = r2     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData r3 = new net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData     // Catch:{ all -> 0x0190 }
            r3.<init>()     // Catch:{ all -> 0x0190 }
            r3.templateId = r1     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r4 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRMovieVideoData r4 = r4.videos     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.CJRMovieVideoModelNew> r4 = r4.videoData     // Catch:{ all -> 0x0190 }
            r3.videos = r4     // Catch:{ all -> 0x0190 }
            r0.elementData = r3     // Catch:{ all -> 0x0190 }
            r0.showDivider = r1     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r3 = r7.f73884c     // Catch:{ all -> 0x0190 }
            r3.add(r0)     // Catch:{ all -> 0x0190 }
        L_0x0127:
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorBlogData r0 = r0.blogs     // Catch:{ all -> 0x0190 }
            r3 = 3
            if (r0 == 0) goto L_0x0159
            net.one97.paytm.o2o.movies.actor.CJRActorModel r0 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorBlogData r0 = r0.blogs     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.CJRActorBlogModel> r0 = r0.blogData     // Catch:{ all -> 0x0190 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0190 }
            if (r0 != 0) goto L_0x0159
            net.one97.paytm.o2o.movies.actor.ActorBaseItemData r0 = new net.one97.paytm.o2o.movies.actor.ActorBaseItemData     // Catch:{ all -> 0x0190 }
            r0.<init>()     // Catch:{ all -> 0x0190 }
            r0.templateId = r2     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData r2 = new net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData     // Catch:{ all -> 0x0190 }
            r2.<init>()     // Catch:{ all -> 0x0190 }
            r2.templateId = r3     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorModel r4 = r7.f73882a     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.CJRActorBlogData r4 = r4.blogs     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.CJRActorBlogModel> r4 = r4.blogData     // Catch:{ all -> 0x0190 }
            r2.blogs = r4     // Catch:{ all -> 0x0190 }
            r0.elementData = r2     // Catch:{ all -> 0x0190 }
            r0.showDivider = r1     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r2 = r7.f73884c     // Catch:{ all -> 0x0190 }
            r2.add(r0)     // Catch:{ all -> 0x0190 }
        L_0x0159:
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r0 = r7.f73884c     // Catch:{ all -> 0x0190 }
            int r0 = r0.size()     // Catch:{ all -> 0x0190 }
            if (r0 != 0) goto L_0x0163
            monitor-exit(r7)
            return
        L_0x0163:
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r0 = r7.f73884c     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r2 = r7.f73884c     // Catch:{ all -> 0x0190 }
            int r2 = r2.size()     // Catch:{ all -> 0x0190 }
            int r2 = r2 - r1
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0190 }
            net.one97.paytm.o2o.movies.actor.ActorBaseItemData r0 = (net.one97.paytm.o2o.movies.actor.ActorBaseItemData) r0     // Catch:{ all -> 0x0190 }
            r1 = 0
            r0.showDivider = r1     // Catch:{ all -> 0x0190 }
            java.util.List<java.lang.String> r0 = r7.f73883b     // Catch:{ all -> 0x0190 }
            if (r0 == 0) goto L_0x0189
            net.one97.paytm.o2o.movies.actor.ActorBaseItemData r0 = new net.one97.paytm.o2o.movies.actor.ActorBaseItemData     // Catch:{ all -> 0x0190 }
            r0.<init>()     // Catch:{ all -> 0x0190 }
            r0.templateId = r3     // Catch:{ all -> 0x0190 }
            java.util.List<java.lang.String> r1 = r7.f73883b     // Catch:{ all -> 0x0190 }
            r0.disclaimerData = r1     // Catch:{ all -> 0x0190 }
            java.util.List<net.one97.paytm.o2o.movies.actor.ActorBaseItemData> r1 = r7.f73884c     // Catch:{ all -> 0x0190 }
            r1.add(r0)     // Catch:{ all -> 0x0190 }
        L_0x0189:
            net.one97.paytm.o2o.movies.actor.CJRActorPageAdapter r0 = r7.f73889h     // Catch:{ all -> 0x0190 }
            r0.notifyDataSetChanged()     // Catch:{ all -> 0x0190 }
        L_0x018e:
            monitor-exit(r7)
            return
        L_0x0190:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRActorPage.a():void");
    }

    private void a(ActorIntroItemData actorIntroItemData) {
        if (!d.a((List) this.f73882a.professions)) {
            String str = "";
            for (String next : this.f73882a.professions) {
                if (str.length() > 0) {
                    str = str + ", ";
                }
                str = str + next;
            }
            actorIntroItemData.profession = str;
        }
    }

    private void a(boolean z) {
        ProgressBar progressBar = this.f73886e;
        if (progressBar != null) {
            if (z) {
                progressBar.setVisibility(0);
            } else {
                progressBar.setVisibility(8);
            }
        }
    }

    public void onViewAllClick(int i2) {
        Intent intent = new Intent(this, AJRFilmographyPage.class);
        if (2 == i2) {
            intent.putExtra("actor_movies_data", this.f73882a.movies);
        } else if (1 == i2) {
            intent.putExtra("actor_videos_data", this.f73882a.videos);
        }
        startActivity(intent);
    }

    public void makeApiCallForMovieVideoCount(Long l) {
        b bVar = this.j;
        c.a();
        String a2 = c.a("URLMoviesVideoViews_v2", (String) null);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", l);
            jSONObject.put("metricType", "videoviews");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = bVar.getApplication().getApplicationContext();
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.POST;
            cVar.f42880d = a2;
            cVar.f42881e = null;
            cVar.f42882f = hashMap;
            cVar.f42883g = null;
            cVar.f42884h = jSONObject.toString();
            cVar.f42885i = new CJRMovieVideoViewCountResponse();
            cVar.j = bVar;
            cVar.n = a.b.SILENT;
            cVar.o = "movies";
            a l2 = cVar.l();
            l2.f42859c = false;
            l2.a();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        super.onBackPressed();
    }
}
