package net.one97.paytm.o2o.movies.actor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData;
import net.one97.paytm.o2o.movies.adapter.h;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieVideoViewCountResponse;
import net.one97.paytm.o2o.movies.utils.n;
import org.json.JSONObject;

public class AJRFilmographyPage extends PaytmActivity implements b, h.a {
    private ImageView backButton;
    private TextView headerTitleTv;
    /* access modifiers changed from: private */
    public RecyclerView listRv;
    private CJRActorMovieData movies;
    private String title = "Filmography";
    private CJRMovieVideoData videos;
    private int viewType = 0;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajrfilmography_page);
        handleIntentData(getIntent());
        initVariables();
        initRecyclerView();
        initListeners();
        setData();
    }

    private void setData() {
        int i2 = this.viewType;
        if (i2 == 0) {
            this.headerTitleTv.setText("Filmography");
        } else if (i2 == 1) {
            this.headerTitleTv.setText("Videos");
        }
    }

    private void initListeners() {
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRFilmographyPage.this.lambda$initListeners$0$AJRFilmographyPage(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListeners$0$AJRFilmographyPage(View view) {
        super.onBackPressed();
    }

    private void initRecyclerView() {
        ActorElementBaseData actorElementBaseData = new ActorElementBaseData();
        int i2 = this.viewType;
        if (i2 == 0) {
            actorElementBaseData.movies = this.movies.movieData;
            actorElementBaseData.templateId = 4;
            this.listRv.setLayoutManager(new GridLayoutManager(this, 2));
            addItemDecorationToGridView();
        } else if (i2 == 1) {
            actorElementBaseData.templateId = 5;
            actorElementBaseData.videos = this.videos.videoData;
            addItemDecoratorToVideoLayout();
            this.listRv.setLayoutManager(new LinearLayoutManager(this));
        }
        this.listRv.setAdapter(new h(this, this, actorElementBaseData));
    }

    private void addItemDecoratorToVideoLayout() {
        if (this.listRv.getItemDecorationCount() == 0) {
            this.listRv.addItemDecoration(new RecyclerView.h() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    super.getItemOffsets(rect, view, recyclerView, sVar);
                    if (AJRFilmographyPage.this.listRv.getChildAdapterPosition(view) == 0) {
                        rect.top = com.paytm.utility.b.a(16.0f, (Context) AJRFilmographyPage.this);
                    }
                    rect.bottom = com.paytm.utility.b.a(15.0f, (Context) AJRFilmographyPage.this);
                }
            });
        }
    }

    private void initVariables() {
        this.listRv = (RecyclerView) findViewById(R.id.listRv);
        this.backButton = (ImageView) findViewById(R.id.back_btn);
        this.headerTitleTv = (TextView) findViewById(R.id.titleTv);
    }

    private void addItemDecorationToGridView() {
        if (this.listRv.getItemDecorationCount() == 0) {
            this.listRv.addItemDecoration(new RecyclerView.h() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    super.getItemOffsets(rect, view, recyclerView, sVar);
                    int childAdapterPosition = AJRFilmographyPage.this.listRv.getChildAdapterPosition(view);
                    if (childAdapterPosition % 2 == 0) {
                        rect.left = n.a(20.0f);
                        rect.right = n.a(7.5f);
                    } else {
                        rect.left = n.a(7.5f);
                        rect.right = n.a(20.0f);
                    }
                    if (childAdapterPosition == 0 || childAdapterPosition == 1) {
                        rect.top = com.paytm.utility.b.a(16.0f, (Context) AJRFilmographyPage.this);
                    }
                    rect.bottom = com.paytm.utility.b.a(27.0f, (Context) AJRFilmographyPage.this);
                }
            });
        }
    }

    private void handleIntentData(Intent intent) {
        this.movies = (CJRActorMovieData) intent.getSerializableExtra("actor_movies_data");
        this.videos = (CJRMovieVideoData) intent.getSerializableExtra("actor_videos_data");
        if (this.movies != null) {
            this.viewType = 0;
        } else if (this.videos != null) {
            this.viewType = 1;
        }
    }

    public void makeApiCallForMovieVideoCount(Long l) {
        c.a();
        String a2 = c.a("URLMoviesVideoViews_v2", (String) null);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", l);
            jSONObject.put("metricType", "videoviews");
            makePostApiCall(a2, jSONObject);
        } catch (Exception unused) {
        }
    }

    private void makePostApiCall(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ClientId", "paytm");
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = getApplication().getApplicationContext();
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.POST;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = hashMap;
        cVar.f42883g = null;
        cVar.f42884h = jSONObject.toString();
        cVar.f42885i = new CJRMovieVideoViewCountResponse();
        cVar.j = this;
        cVar.n = a.b.SILENT;
        cVar.o = "movies";
        a l = cVar.l();
        l.f42859c = false;
        l.a();
    }
}
