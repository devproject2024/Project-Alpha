package net.one97.paytm.vipcashback.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.vipcashback.MerchantStage;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.fragment.e;

public final class MerchantPaymentDetailsActivity extends AJRCashBackBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public String f20698a;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MerchantStage> f20699d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f20700e;

    public final View a(int i2) {
        if (this.f20700e == null) {
            this.f20700e = new HashMap();
        }
        View view = (View) this.f20700e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f20700e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final ArrayList<MerchantStage> a() {
        ArrayList<MerchantStage> arrayList = this.f20699d;
        if (arrayList == null) {
            k.a("mStages");
        }
        return arrayList;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_merchant_payment_details);
        String stringExtra = getIntent().getStringExtra("gameid");
        k.a((Object) stringExtra, "intent.getStringExtra(Ca…stants.CASHBACK_OFFER_ID)");
        this.f20698a = stringExtra;
        Serializable serializableExtra = getIntent().getSerializableExtra("stageItems");
        if (serializableExtra != null) {
            this.f20699d = (ArrayList) serializableExtra;
            a aVar = new a();
            ViewPager viewPager = (ViewPager) a(R.id.viewPager);
            k.a((Object) viewPager, "viewPager");
            viewPager.setAdapter(aVar);
            ((TabLayout) a(R.id.tabLayout)).setupWithViewPager((ViewPager) a(R.id.viewPager));
            ((TabLayout) a(R.id.tabLayout)).setSelectedTabIndicatorColor(getResources().getColor(net.one97.paytm.common.assets.R.color.excl_color_00b9f5));
            ((TabLayout) a(R.id.tabLayout)).setSelectedTabIndicatorHeight(getResources().getDimensionPixelOffset(net.one97.paytm.common.assets.R.dimen.dimen_3dp));
            ((TabLayout) a(R.id.tabLayout)).setTabTextColors(Color.parseColor("#b8c2cb"), Color.parseColor("#000000"));
            TabLayout tabLayout = (TabLayout) a(R.id.tabLayout);
            k.a((Object) tabLayout, "tabLayout");
            tabLayout.setTabGravity(1);
            TabLayout tabLayout2 = (TabLayout) a(R.id.tabLayout);
            k.a((Object) tabLayout2, "tabLayout");
            tabLayout2.setTabMode(0);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(net.one97.paytm.common.assets.R.dimen.dimen_12dp);
            ((TabLayout) a(R.id.tabLayout)).setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            if (((TabLayout) a(R.id.tabLayout)).getChildAt(0) instanceof ViewGroup) {
                View childAt = ((TabLayout) a(R.id.tabLayout)).getChildAt(0);
                if (childAt != null) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    int intValue = (viewGroup != null ? Integer.valueOf(viewGroup.getChildCount()) : null).intValue();
                    int i2 = 0;
                    while (i2 < intValue) {
                        View childAt2 = viewGroup != null ? viewGroup.getChildAt(i2) : null;
                        if (childAt2 != null) {
                            ViewGroup viewGroup2 = (ViewGroup) childAt2;
                            int intValue2 = (viewGroup2 != null ? Integer.valueOf(viewGroup2.getChildCount()) : null).intValue();
                            for (int i3 = 0; i3 < intValue2; i3++) {
                                View childAt3 = viewGroup2 != null ? viewGroup2.getChildAt(i3) : null;
                                k.a((Object) childAt3, "vgTab?.getChildAt(i)");
                                if (childAt3 instanceof TextView) {
                                    TextView textView = (TextView) childAt3;
                                    textView.setTextSize((float) textView.getResources().getDimensionPixelOffset(net.one97.paytm.common.assets.R.dimen.dimen_14sp));
                                    textView.setPadding(0, 0, 0, dimensionPixelOffset);
                                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                                    textView.setEllipsize(TextUtils.TruncateAt.END);
                                    textView.setSingleLine(true);
                                }
                            }
                            i2++;
                        } else {
                            throw new u("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            ((ImageView) a(R.id.iv_back)).setOnClickListener(new b(this));
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.common.entity.vipcashback.MerchantStage> /* = java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.MerchantStage> */");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MerchantPaymentDetailsActivity f20702a;

        b(MerchantPaymentDetailsActivity merchantPaymentDetailsActivity) {
            this.f20702a = merchantPaymentDetailsActivity;
        }

        public final void onClick(View view) {
            this.f20702a.finish();
        }
    }

    public final class a extends o {
        public a() {
            super(MerchantPaymentDetailsActivity.this.getSupportFragmentManager());
        }

        public final Fragment getItem(int i2) {
            e.a aVar = e.m;
            String str = MerchantPaymentDetailsActivity.this.f20698a;
            if (str == null) {
                k.a("mGameId");
            }
            MerchantStage merchantStage = MerchantPaymentDetailsActivity.this.a().get(i2);
            k.a((Object) merchantStage, "mStages[position]");
            MerchantStage merchantStage2 = merchantStage;
            k.c(str, "gameId");
            k.c(merchantStage2, "merchantStage");
            Bundle bundle = new Bundle();
            bundle.putSerializable("gameid", str);
            bundle.putSerializable("stageItem", merchantStage2);
            e eVar = new e();
            eVar.setArguments(bundle);
            return eVar;
        }

        public final int getCount() {
            return MerchantPaymentDetailsActivity.this.a().size();
        }

        public final CharSequence getPageTitle(int i2) {
            MerchantStage merchantStage = MerchantPaymentDetailsActivity.this.a().get(i2);
            k.a((Object) merchantStage, "mStages[position]");
            return merchantStage.getStageScreenConstruct1();
        }
    }
}
