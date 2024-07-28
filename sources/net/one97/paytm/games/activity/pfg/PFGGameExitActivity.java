package net.one97.paytm.games.activity.pfg;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.games.R;
import net.one97.paytm.games.a.a.c;
import net.one97.paytm.games.activity.GpBaseActivity;
import net.one97.paytm.games.e.a.c;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.model.pfg.Game;
import net.one97.paytm.games.model.pfg.RecommendEntity;
import net.one97.paytm.games.model.pfg.RecommendEntityWrap;

public final class PFGGameExitActivity extends GpBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final a f35555b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Game f35556c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f35557d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.games.a.a.c f35558e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f35559f;

    public final View a(int i2) {
        if (this.f35559f == null) {
            this.f35559f = new HashMap();
        }
        View view = (View) this.f35559f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f35559f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ Game b(PFGGameExitActivity pFGGameExitActivity) {
        Game game = pFGGameExitActivity.f35556c;
        if (game == null) {
            k.a("mBannerGame");
        }
        return game;
    }

    public static final /* synthetic */ net.one97.paytm.games.a.a.c d(PFGGameExitActivity pFGGameExitActivity) {
        net.one97.paytm.games.a.a.c cVar = pFGGameExitActivity.f35558e;
        if (cVar == null) {
            k.a("mAdapter");
        }
        return cVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        net.one97.paytm.games.e.f.a((Activity) this, getIntent().getIntExtra("orientation", -1));
        setContentView(R.layout.app_dialog_recommend);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.root);
        k.a((Object) constraintLayout, "root");
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        net.one97.paytm.games.e.a.f fVar = net.one97.paytm.games.e.a.f.f35598a;
        Context context = this;
        int a2 = net.one97.paytm.games.e.a.f.a(context);
        net.one97.paytm.games.e.a.f fVar2 = net.one97.paytm.games.e.a.f.f35598a;
        layoutParams.width = Math.min(a2, net.one97.paytm.games.e.a.f.b(context));
        ((LinearLayout) a(R.id.btn_keeping)).setOnClickListener(new c(this));
        ((LinearLayout) a(R.id.btn_exit)).setOnClickListener(new d(this));
        ((ImageView) a(R.id.image_first_game)).setOnClickListener(new e(this));
        RecyclerView recyclerView = (RecyclerView) a(R.id.recycler_recommend);
        k.a((Object) recyclerView, "recycler_recommend");
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        net.one97.paytm.games.a.a.c cVar = new net.one97.paytm.games.a.a.c(context, new ArrayList());
        this.f35558e = cVar;
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.recycler_recommend);
        k.a((Object) recyclerView2, "recycler_recommend");
        recyclerView2.setAdapter(cVar);
        net.one97.paytm.games.a.a.c cVar2 = this.f35558e;
        if (cVar2 == null) {
            k.a("mAdapter");
        }
        cVar2.f35447b = new f(this);
        this.f35557d = getIntent().getStringExtra(CLPConstants.PRODUCT_ID);
        String str = this.f35557d;
        com.paytm.network.listener.b bVar = new b(this);
        String gtmString = g.a().c().getGtmString("games_game_from_gameid_url");
        if (net.one97.paytm.games.e.f.a((Object) gtmString)) {
            gtmString = net.one97.paytm.games.e.e.f35608a ? "https://stagingapps.gamepind.com/api/game/getGameListFromGameId" : "https://apps.gamepind.com/api/game/getGameListFromGameId";
        }
        String uri = Uri.parse(gtmString).buildUpon().appendQueryParameter("gameId", str).build().toString();
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.GAMEPIND;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.n = a.b.USER_FACING;
        bVar2.o = PFGGameExitActivity.class.getName();
        bVar2.l = true;
        bVar2.f42880d = uri;
        bVar2.f42882f = net.one97.paytm.games.e.a.a(context, "", "");
        bVar2.f42885i = new RecommendEntityWrap();
        bVar2.j = bVar;
        bVar2.l().a();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGGameExitActivity f35561a;

        c(PFGGameExitActivity pFGGameExitActivity) {
            this.f35561a = pFGGameExitActivity;
        }

        public final void onClick(View view) {
            if (this.f35561a.f35557d != null) {
                PFGGameExitActivity pFGGameExitActivity = this.f35561a;
                net.one97.paytm.games.e.f.a(pFGGameExitActivity, net.one97.paytm.games.e.f.c(pFGGameExitActivity, "/inbox/games/webview/exit/" + this.f35561a.f35557d), "pfg_back_button", "keep_playing_clicked", this.f35561a.f35557d, (String) null);
            }
            this.f35561a.finish();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGGameExitActivity f35562a;

        d(PFGGameExitActivity pFGGameExitActivity) {
            this.f35562a = pFGGameExitActivity;
        }

        public final void onClick(View view) {
            if (this.f35562a.f35557d != null) {
                PFGGameExitActivity pFGGameExitActivity = this.f35562a;
                net.one97.paytm.games.e.f.a(pFGGameExitActivity, net.one97.paytm.games.e.f.c(pFGGameExitActivity, "/inbox/games/webview/exit/" + this.f35562a.f35557d), "pfg_back_button", "exit_clicked", this.f35562a.f35557d, (String) null);
            }
            this.f35562a.setResult(-1);
            this.f35562a.finish();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGGameExitActivity f35563a;

        e(PFGGameExitActivity pFGGameExitActivity) {
            this.f35563a = pFGGameExitActivity;
        }

        public final void onClick(View view) {
            if (this.f35563a.f35556c != null) {
                if (this.f35563a.f35557d != null) {
                    PFGGameExitActivity pFGGameExitActivity = this.f35563a;
                    net.one97.paytm.games.e.f.a(pFGGameExitActivity, net.one97.paytm.games.e.f.c(pFGGameExitActivity, "/inbox/games/webview/exit/" + this.f35563a.f35557d), "pfg_back_button", "game_clicked", this.f35563a.f35557d, PFGGameExitActivity.b(this.f35563a).getGameId());
                }
                net.one97.paytm.games.e.a.e eVar = net.one97.paytm.games.e.a.e.f35596a;
                PFGGameExitActivity pFGGameExitActivity2 = this.f35563a;
                net.one97.paytm.games.e.a.e.a(pFGGameExitActivity2, PFGGameExitActivity.b(pFGGameExitActivity2));
                this.f35563a.finish();
            }
        }
    }

    static final class f implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGGameExitActivity f35564a;

        f(PFGGameExitActivity pFGGameExitActivity) {
            this.f35564a = pFGGameExitActivity;
        }

        public final void a(Game game) {
            if (this.f35564a.f35557d != null) {
                PFGGameExitActivity pFGGameExitActivity = this.f35564a;
                net.one97.paytm.games.e.f.a(pFGGameExitActivity, net.one97.paytm.games.e.f.c(pFGGameExitActivity, "/inbox/games/webview/exit/" + this.f35564a.f35557d), "pfg_back_button", "game_clicked", this.f35564a.f35557d, game.getGameId());
            }
            net.one97.paytm.games.e.a.e eVar = net.one97.paytm.games.e.a.e.f35596a;
            k.a((Object) game, "game");
            net.one97.paytm.games.e.a.e.a(this.f35564a, game);
            this.f35564a.finish();
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGGameExitActivity f35560a;

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
        }

        b(PFGGameExitActivity pFGGameExitActivity) {
            this.f35560a = pFGGameExitActivity;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            List<Game> gameList;
            if (!net.one97.paytm.games.e.f.a((Activity) this.f35560a) && (iJRPaytmDataModel instanceof RecommendEntityWrap)) {
                RecommendEntityWrap recommendEntityWrap = (RecommendEntityWrap) iJRPaytmDataModel;
                if (recommendEntityWrap.code == 200 && recommendEntityWrap.getData() != null) {
                    List<RecommendEntity> data = recommendEntityWrap.getData();
                    k.a((Object) data, "recommendEntity");
                    if (!data.isEmpty()) {
                        Iterable iterable = data;
                        Collection arrayList = new ArrayList();
                        for (Object next : iterable) {
                            String sectionLayout = ((RecommendEntity) next).getSectionLayout();
                            if (sectionLayout == null) {
                                k.a();
                            }
                            if ("bannerstatic".contentEquals(sectionLayout)) {
                                arrayList.add(next);
                            }
                        }
                        List list = (List) arrayList;
                        List<Game> list2 = null;
                        if (!list.isEmpty()) {
                            List<Game> gameList2 = ((RecommendEntity) kotlin.a.k.d(list)).getGameList();
                            Boolean valueOf = gameList2 != null ? Boolean.valueOf(!gameList2.isEmpty()) : null;
                            if (valueOf == null) {
                                k.a();
                            }
                            if (valueOf.booleanValue()) {
                                net.one97.paytm.games.e.a.g.a((ImageView) this.f35560a.a(R.id.image_first_game));
                                PFGGameExitActivity pFGGameExitActivity = this.f35560a;
                                List<Game> gameList3 = ((RecommendEntity) kotlin.a.k.d(list)).getGameList();
                                Game game = gameList3 != null ? (Game) kotlin.a.k.d(gameList3) : null;
                                if (game == null) {
                                    k.a();
                                }
                                pFGGameExitActivity.f35556c = game;
                                c.a aVar = net.one97.paytm.games.e.a.c.f35593a;
                                c.a.a();
                                Context context = this.f35560a;
                                String image = ((RecommendEntity) kotlin.a.k.d(list)).getImage();
                                if (image == null) {
                                    k.a();
                                }
                                ImageView imageView = (ImageView) this.f35560a.a(R.id.image_first_game);
                                k.a((Object) imageView, "image_first_game");
                                net.one97.paytm.games.e.a.c.a(context, image, imageView, 4, R.drawable.games_img_defult_midcard);
                            }
                        }
                        Collection arrayList2 = new ArrayList();
                        for (Object next2 : iterable) {
                            String sectionLayout2 = ((RecommendEntity) next2).getSectionLayout();
                            if (sectionLayout2 == null) {
                                k.a();
                            }
                            if (CLPConstants.DEFAULT_GRID_VIEW_TYPE.contentEquals(sectionLayout2)) {
                                arrayList2.add(next2);
                            }
                        }
                        RecommendEntity recommendEntity = (RecommendEntity) kotlin.a.k.d((List) arrayList2);
                        boolean z = false;
                        if (!(recommendEntity == null || (gameList = recommendEntity.getGameList()) == null)) {
                            Collection arrayList3 = new ArrayList();
                            for (Object next3 : gameList) {
                                if (!p.a(((Game) next3).getGameId(), this.f35560a.getIntent().getStringExtra(CLPConstants.PRODUCT_ID), false)) {
                                    arrayList3.add(next3);
                                }
                            }
                            list2 = (List) arrayList3;
                        }
                        Collection collection = list2;
                        if (collection == null || collection.isEmpty()) {
                            z = true;
                        }
                        if (!z) {
                            TextView textView = (TextView) this.f35560a.a(R.id.text_recommend_title);
                            k.a((Object) textView, "text_recommend_title");
                            textView.setText(recommendEntity.getSectionTitle());
                            net.one97.paytm.games.a.a.c d2 = PFGGameExitActivity.d(this.f35560a);
                            d2.f35446a = list2;
                            d2.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
