package net.one97.paytm.o2o.movies.moviepass.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassFAQDataModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemDataModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemInstructionModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AppBaseActivity;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassFaqInstructionModel;
import net.one97.paytm.o2o.movies.moviepass.a.a;
import net.one97.paytm.o2o.movies.moviepass.d.h;
import net.one97.paytm.o2o.movies.moviepass.e.c;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRMpConditionsActivity extends AppBaseActivity implements a.C1490a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f75472a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f75473b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f75474c;

    /* renamed from: d  reason: collision with root package name */
    private h.a f75475d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, CJRMoviePassFaqInstructionModel> f75476e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, CJRMoviePassRedeemInstructionModel> f75477f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f75478g;

    public void onCreate(Bundle bundle) {
        ArrayList<c> arrayList;
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajrmp_conditions);
        Intent intent = getIntent();
        this.f75475d = (h.a) intent.getSerializableExtra("conditionType");
        h.a aVar = this.f75475d;
        if (aVar == null) {
            Toast.makeText(this, "Something went wrong", 0).show();
        } else if (aVar.equals(h.a.FAQ)) {
            this.f75476e = (HashMap) intent.getSerializableExtra("instructionsMap");
        } else {
            this.f75477f = (HashMap) intent.getSerializableExtra("htrMap");
        }
        this.f75472a = (RecyclerView) findViewById(R.id.mp_conditions_rv);
        this.f75473b = (ImageView) findViewById(R.id.crossIcon);
        this.f75474c = (TextView) findViewById(R.id.title);
        this.f75478g = (LinearLayout) findViewById(R.id.bottomSheetContainer);
        this.f75473b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRMpConditionsActivity.this.setResult(-1);
                AJRMpConditionsActivity.this.finish();
            }
        });
        h.a aVar2 = this.f75475d;
        if (aVar2 != null) {
            if (aVar2.equals(h.a.FAQ)) {
                this.f75474c.setText("General FAQ’s");
                this.f75478g.getLayoutParams().height = -1;
                this.f75478g.setBackground((Drawable) null);
                this.f75478g.setBackgroundColor(getResources().getColor(R.color.white));
            } else {
                this.f75478g.getLayoutParams().height = n.a((Context) this, 433);
                this.f75474c.setText("How to Redeem Movie Pass");
                this.f75478g.setBackground((Drawable) null);
                this.f75478g.setBackground(getResources().getDrawable(R.drawable.bottomsheet_bg));
            }
            if (h.a.FAQ.equals(this.f75475d)) {
                arrayList = new ArrayList<>();
                HashMap<String, CJRMoviePassFaqInstructionModel> hashMap = this.f75476e;
                if (hashMap != null && hashMap.size() > 0) {
                    for (Map.Entry<String, CJRMoviePassFaqInstructionModel> value : this.f75476e.entrySet()) {
                        CJRMoviePassFaqInstructionModel cJRMoviePassFaqInstructionModel = (CJRMoviePassFaqInstructionModel) value.getValue();
                        if (cJRMoviePassFaqInstructionModel != null && !d.a((List) cJRMoviePassFaqInstructionModel.getInstructionsData())) {
                            for (CJRMoviePassFAQDataModel next : cJRMoviePassFaqInstructionModel.getInstructionsData()) {
                                c cVar = new c(next.getQues(), next.getAns());
                                cVar.f75585d = h.a.FAQ;
                                arrayList.add(cVar);
                            }
                        }
                    }
                }
            } else {
                arrayList = a();
            }
            if (!arrayList.isEmpty()) {
                a aVar3 = new a(this, arrayList, this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(1);
                this.f75472a.setLayoutManager(linearLayoutManager);
                this.f75472a.setAdapter(aVar3);
                this.f75478g.startAnimation(AnimationUtils.loadAnimation(this, R.anim.movie_bottom_up));
                this.f75478g.setVisibility(0);
            }
        }
    }

    private ArrayList<c> a() {
        ArrayList<c> arrayList = new ArrayList<>();
        HashMap<String, CJRMoviePassRedeemInstructionModel> hashMap = this.f75477f;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, CJRMoviePassRedeemInstructionModel> value : this.f75477f.entrySet()) {
                CJRMoviePassRedeemInstructionModel cJRMoviePassRedeemInstructionModel = (CJRMoviePassRedeemInstructionModel) value.getValue();
                List<CJRMoviePassRedeemDataModel> instructionsData = cJRMoviePassRedeemInstructionModel.getInstructionsData();
                if (cJRMoviePassRedeemInstructionModel != null && !d.a((List) instructionsData)) {
                    int i2 = 0;
                    while (i2 < instructionsData.size()) {
                        StringBuilder sb = new StringBuilder("STEP ");
                        int i3 = i2 + 1;
                        sb.append(i3);
                        c cVar = new c(sb.toString(), instructionsData.get(i2).getStep());
                        cVar.f75585d = h.a.HTR;
                        arrayList.add(cVar);
                        i2 = i3;
                    }
                }
            }
        }
        return arrayList;
    }

    public final void a(int i2) {
        this.f75472a.scrollToPosition(i2);
    }
}
