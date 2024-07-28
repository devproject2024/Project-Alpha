package com.travel.train.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.cdn.ResourceUtils;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.y;
import com.travel.train.i.ac;
import com.travel.train.i.m;
import com.travel.train.i.w;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainCitySearchCategory;
import com.travel.train.model.trainticket.CJRTrainOriginCityItem;
import com.travel.train.model.trainticket.CJRTrainStation;
import com.travel.train.viewholder.bj;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRTrainSelectStationActivity extends CJRTrainBaseActivity implements w {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f26116a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26117b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f26118c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26119d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f26120e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f26121f;

    /* renamed from: g  reason: collision with root package name */
    private y f26122g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<IJRDataModel> f26123h = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJRTrainStation f26124i;
    private String j;
    private ImageView k;
    private LinearLayout l;
    private String m = "AJRTrainSelectStationActivity";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_select_station);
        getSupportActionBar().f();
        this.f26120e = (RecyclerView) findViewById(R.id.recycler_view_station);
        this.f26121f = (RelativeLayout) findViewById(R.id.searched_item_container);
        this.k = (ImageView) findViewById(R.id.back_button);
        this.f26116a = (ImageView) findViewById(R.id.station_type_icon);
        this.f26117b = (TextView) findViewById(R.id.station_name);
        this.f26118c = (TextView) findViewById(R.id.station_type);
        this.f26119d = (TextView) findViewById(R.id.tv_no_station_text);
        this.f26120e.setLayoutManager(new LinearLayoutManager(this));
        this.l = (LinearLayout) findViewById(R.id.title_container);
        this.k.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        this.k.setRotation(180.0f);
        ResourceUtils.loadTrainImagesFromCDN(this.f26116a, "address_pin.png", false, false, n.a.V1);
        Intent intent = getIntent();
        if (intent != null) {
            this.f26124i = (CJRTrainStation) intent.getSerializableExtra("intent_extra_train_station_list");
            this.j = (String) intent.getSerializableExtra(UpiConstants.FROM);
        }
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainSelectStationActivity.this.a(view);
            }
        });
        this.f26117b.setText(this.f26124i.getCityItem().getDisplayName());
        if (this.f26124i.getCityItem().getType().equalsIgnoreCase("City")) {
            this.f26118c.setText(getResources().getString(R.string.select_city));
            ResourceUtils.loadTrainImagesFromCDN(this.f26116a, "ic_train_city.png", false, false, n.a.V1);
            this.f26119d.setText(getString(R.string.trains_no_station, new Object[]{this.f26124i.getCityItem().getDisplayName()}));
            this.f26119d.setVisibility(0);
        } else if (this.f26124i.getCityItem().getType().equalsIgnoreCase("state")) {
            this.f26118c.setText(getResources().getString(R.string.state));
            this.f26119d.setVisibility(4);
            ResourceUtils.loadTrainImagesFromCDN(this.f26116a, "ic_train_state.png", false, false, n.a.V1);
        } else if (this.f26124i.getCityItem().getType().equalsIgnoreCase("station")) {
            this.f26118c.setText(getResources().getString(R.string.station));
            this.f26119d.setVisibility(4);
        }
        if (this.f26124i.getExpandStationList() != null && this.f26124i.getExpandStationList().size() > 0) {
            ArrayList<IJRDataModel> arrayList = this.f26123h;
            if (arrayList != null) {
                arrayList.clear();
            }
            CJRTrainCitySearchCategory cJRTrainCitySearchCategory = new CJRTrainCitySearchCategory();
            if (!TextUtils.isEmpty(this.f26124i.getExpandStationListTitle())) {
                cJRTrainCitySearchCategory.setmCategoryTitle(this.f26124i.getExpandStationListTitle());
            } else {
                cJRTrainCitySearchCategory.setmCategoryTitle(getResources().getString(R.string.train_near_by_stations));
            }
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.pre_t_recet_popular_train_city_item, this.l, false);
            new bj(this, inflate, 0, (w) null, (m) null, ac.MOST_POPULAR).a(cJRTrainCitySearchCategory, 0, 0);
            this.l.addView(inflate);
            if (this.f26124i.getExpandStationList() != null && this.f26124i.getExpandStationList().size() > 0) {
                this.f26124i.getExpandStationList().get(0).setType(getString(R.string.train_most_popular_str));
            }
            Iterator<CJRTrainOriginCityItem> it2 = this.f26124i.getExpandStationList().iterator();
            while (it2.hasNext()) {
                CJRTrainOriginCityItem next = it2.next();
                next.setParentName(this.f26124i.getCityItem().getCityName());
                next.setParentType(this.f26124i.getType());
                this.f26123h.add(next);
            }
            ArrayList<IJRDataModel> arrayList2 = this.f26123h;
            this.f26122g = new y(this, arrayList2, arrayList2.size(), this.j, ac.MOST_POPULAR);
            this.f26122g.a(this);
            this.f26120e.setAdapter(this.f26122g);
        }
        this.f26117b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (AJRTrainSelectStationActivity.this.f26124i.getCityItem().getType().equalsIgnoreCase("station")) {
                    AJRTrainSelectStationActivity aJRTrainSelectStationActivity = AJRTrainSelectStationActivity.this;
                    aJRTrainSelectStationActivity.a(0, aJRTrainSelectStationActivity.f26124i, "recent");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, (Intent) null);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void a(int i2, IJRDataModel iJRDataModel, String str) {
        CJRTrainOriginCityItem cityItem = ((CJRTrainStation) iJRDataModel).getCityItem();
        if (!(cityItem == null || cityItem.getCityCode() == null || cityItem.getCityName() == null)) {
            String cityCode = cityItem.getCityCode();
            cityCode.concat("-" + cityItem.getCityName());
        }
        o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "orig_dest_selected", "/trains", this, (Map<String, Object>) null);
        Intent intent = new Intent();
        intent.putExtra("intent_extra_selected_city_name", cityItem);
        if (i2 >= 0) {
            intent.putExtra("intent_extra_selected_city_position", i2 + 1);
        }
        setResult(-1, intent);
        finish();
    }
}
