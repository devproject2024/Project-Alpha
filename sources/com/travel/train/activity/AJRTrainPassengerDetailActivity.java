package com.travel.train.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.travel.cdn.ResourceUtils;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.fragment.r;
import com.travel.train.fragment.y;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainPromoMessage;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.utils.n;
import java.util.ArrayList;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class AJRTrainPassengerDetailActivity extends CJRTrainBaseActivity implements View.OnClickListener, y.a {

    /* renamed from: a  reason: collision with root package name */
    private j f26041a;

    /* renamed from: b  reason: collision with root package name */
    private String f26042b;

    /* renamed from: c  reason: collision with root package name */
    private String f26043c;

    /* renamed from: d  reason: collision with root package name */
    private String f26044d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f26045e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f26046f;

    /* renamed from: g  reason: collision with root package name */
    private Toolbar f26047g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f26048h;

    /* renamed from: i  reason: collision with root package name */
    private CJRTrainDetailsBody f26049i;
    private CJRTrainSearchResultsTrain j;
    private CJRTrainAvailability k;
    private CJRTrainAvailability l;
    private CJRTrainSearchInput m;
    private r n;
    private y o;

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_passenger_detail);
        int i2 = 0;
        if (getIntent() != null) {
            if (getIntent().hasExtra("train_detail_body")) {
                this.f26049i = (CJRTrainDetailsBody) getIntent().getSerializableExtra("train_detail_body");
                if (this.f26049i.getmTrainAvailability() != null && this.f26049i.getmTrainAvailability().size() > 0) {
                    this.k = this.f26049i.getmTrainAvailability().get(this.f26049i.getMiSelectedPosition());
                    this.l = this.f26049i.getmTrainAvailability().get(0);
                }
            }
            if (getIntent().hasExtra("train_detail")) {
                this.j = (CJRTrainSearchResultsTrain) getIntent().getSerializableExtra("train_detail");
            }
            if (getIntent().hasExtra("chosenDate")) {
                this.f26042b = getIntent().getStringExtra("chosenDate");
            }
            if (getIntent().hasExtra("train_class_details")) {
                this.f26043c = getIntent().getStringExtra("train_class_details");
            }
            if (getIntent().hasExtra("quota_name")) {
                this.f26044d = getIntent().getStringExtra("quota_name");
            }
            if (getIntent().hasExtra("intent_extra_train_search_input")) {
                this.m = (CJRTrainSearchInput) getIntent().getSerializableExtra("intent_extra_train_search_input");
            }
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().c(false);
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.j;
        if (cJRTrainSearchResultsTrain != null) {
            String trainNumber = cJRTrainSearchResultsTrain.getTrainNumber();
            String a2 = o.a(this.j.getTrainName());
            ((RoboTextView) findViewById(R.id.tittle)).setText(trainNumber + " - " + a2);
            ((RoboTextView) findViewById(R.id.subtittle)).setText(this.f26043c + "  | " + this.f26044d + "  | " + this.f26042b);
        }
        this.f26045e = (ImageView) findViewById(R.id.back_arrow);
        this.f26045e.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        this.f26045e.setRotation(180.0f);
        this.f26045e.setOnClickListener(this);
        this.f26046f = (LinearLayout) findViewById(R.id.promo_container);
        this.f26047g = (Toolbar) findViewById(R.id.toolbar);
        this.f26048h = (RelativeLayout) findViewById(R.id.rv_promo_divider_container);
        a();
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            int complexToDimensionPixelSize = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics()) + b.a(10.0f, (Context) this);
            if (this.f26046f.getVisibility() == 0) {
                this.f26046f.measure(0, 0);
                i2 = this.f26046f.getMeasuredHeight() + complexToDimensionPixelSize;
            } else {
                i2 = complexToDimensionPixelSize;
            }
        }
        this.f26041a = getSupportFragmentManager();
        q a3 = this.f26041a.a();
        this.o = new y();
        Bundle extras = getIntent().getExtras();
        extras.putInt("action_bar_height", i2);
        this.o.setArguments(extras);
        a3.b(R.id.fragment_container, this.o, (String) null);
        a3.b();
    }

    private void a() {
        String str;
        CJRTrainDetailsBody cJRTrainDetailsBody = this.f26049i;
        boolean z = false;
        if (!(cJRTrainDetailsBody == null || cJRTrainDetailsBody.getPromoMessageModel() == null || this.f26049i.getPromoMessageModel().getPromoMessages() == null || this.f26049i.getPromoMessageModel().getPromoMessages().size() <= 0)) {
            ArrayList<CJRTrainPromoMessage> promoMessages = this.f26049i.getPromoMessageModel().getPromoMessages();
            int i2 = 0;
            while (true) {
                if (i2 >= promoMessages.size()) {
                    str = "";
                    break;
                }
                CJRTrainPromoMessage cJRTrainPromoMessage = promoMessages.get(i2);
                if (cJRTrainPromoMessage.getType().equalsIgnoreCase(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX)) {
                    str = cJRTrainPromoMessage.getMessage();
                    break;
                }
                i2++;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f26046f.setVisibility(0);
                TextView textView = (TextView) this.f26046f.findViewById(R.id.tv_promo_text);
                ResourceUtils.loadTrainImagesFromCDN((ImageView) this.f26046f.findViewById(R.id.image_view_promo_icon), "speaker_icon.png", false, false, n.a.V1);
                if (textView != null) {
                    textView.setText(str);
                    z = true;
                }
            }
        }
        if (!z) {
            this.f26046f.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.back_arrow) {
            return;
        }
        if (this.o.f27224a.h()) {
            b();
        } else {
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.o.onActivityResult(i2, i3, intent);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void b() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        View inflate = getLayoutInflater().inflate(R.layout.pre_t_train_traveller_back_nav_alter_lyt, (ViewGroup) null);
        dialog.setContentView(inflate);
        ResourceUtils.loadTrainImagesFromCDN((ImageView) inflate.findViewById(R.id.back_nav_icon), "back_nav.png", false, false, n.a.V1);
        ((TextView) inflate.findViewById(R.id.negative_btn)).setOnClickListener(new View.OnClickListener(dialog) {
            private final /* synthetic */ Dialog f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                this.f$0.cancel();
            }
        });
        ((TextView) inflate.findViewById(R.id.positive_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainPassengerDetailActivity.this.a(view);
            }
        });
        dialog.show();
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        window.setLayout(-1, -2);
        window.setGravity(80);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().c(getResources().getString(R.string.Cancellation_policy_tag)) != null && getSupportFragmentManager().c(getResources().getString(R.string.Cancellation_policy_tag)).isVisible()) {
            getSupportFragmentManager().a().a(getSupportFragmentManager().c(getResources().getString(R.string.Cancellation_policy_tag))).b();
            a(0);
        } else if (this.o.f27224a.h()) {
            b();
        } else {
            finish();
        }
    }

    private void a(int i2) {
        this.f26047g.setVisibility(i2);
        this.f26048h.setVisibility(i2);
    }

    public final void a(String str) {
        a(8);
        this.n = r.a(getString(R.string.cancellation_policy), str);
        q a2 = getSupportFragmentManager().a();
        a2.a(R.id.fragment_container, this.n, getResources().getString(R.string.Cancellation_policy_tag));
        a2.b();
    }
}
