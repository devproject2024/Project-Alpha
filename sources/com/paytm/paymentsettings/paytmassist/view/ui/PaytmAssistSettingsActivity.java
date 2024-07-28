package com.paytm.paymentsettings.paytmassist.view.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.paytm.b.a.a;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.common.b.c;
import com.paytm.paymentsettings.common.b.d;
import com.paytm.paymentsettings.common.data.PaymentSettingsCallBacks;
import com.paytm.paymentsettings.common.data.PaymentSettingsHelper;
import com.paytm.paymentsettings.paytmassist.model.BankUserName;
import com.paytm.paymentsettings.paytmassist.view.ui.a;
import easypay.manager.PaytmAssist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;

public final class PaytmAssistSettingsActivity extends PaytmActivity implements com.paytm.paymentsettings.paytmassist.model.a {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public com.google.android.material.bottomsheet.b bottomSheetFragment;
    private ArrayList<BankUserName> mBankNameUserList = new ArrayList<>();
    private com.paytm.paymentsettings.paytmassist.view.a.a mBankUserAdapter;
    /* access modifiers changed from: private */
    public ImageView mHowItWorks;
    private ImageView mIvBackArrow;
    private ImageView mIvEmptyListImage;
    private RecyclerView mRvBankUserName;
    private Switch mToggleSwitch;
    private TextView mTvEmptyListText;
    private TextView mTvHowItWorks;
    private HashMap<String, ArrayList<String>> mUserIdMap;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onDismiss() {
    }

    public final void onNegative() {
    }

    public final void onPositive() {
    }

    public static final /* synthetic */ ImageView access$getMHowItWorks$p(PaytmAssistSettingsActivity paytmAssistSettingsActivity) {
        ImageView imageView = paytmAssistSettingsActivity.mHowItWorks;
        if (imageView == null) {
            k.a("mHowItWorks");
        }
        return imageView;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings_paytm_assist);
        initViews();
    }

    private final void fetchUserId() {
        Context context = this;
        com.paytm.utility.b.k(context, getString(R.string.please_wait_subscriptions));
        Map<String, ArrayList<String>> fetchNBUserIds = PaytmAssist.fetchNBUserIds(context);
        if (!(fetchNBUserIds instanceof HashMap)) {
            fetchNBUserIds = null;
        }
        this.mUserIdMap = (HashMap) fetchNBUserIds;
        processUserIdMap();
    }

    private final void processUserIdMap() {
        Map map = this.mUserIdMap;
        if (map == null || map.isEmpty()) {
            showEmptyList();
        } else {
            hideEmptyList();
            HashMap<String, ArrayList<String>> hashMap = this.mUserIdMap;
            Set<String> keySet = hashMap != null ? hashMap.keySet() : null;
            if (keySet == null) {
                k.a();
            }
            k.a((Object) keySet, "mUserIdMap?.keys!!");
            for (String next : keySet) {
                String str = "https://staticgw3.paytm.in/native/bank/" + next + ".png";
                HashMap<String, ArrayList<String>> hashMap2 = this.mUserIdMap;
                Collection collection = hashMap2 != null ? hashMap2.get(next) : null;
                if (!(collection == null || collection.isEmpty())) {
                    if (this.mBankNameUserList.isEmpty()) {
                        ListIterator<BankUserName> listIterator = this.mBankNameUserList.listIterator();
                        k.a((Object) listIterator, "mBankNameUserList.listIterator()");
                        d.a aVar = com.paytm.paymentsettings.common.b.d.f43432a;
                        k.a((Object) next, "key");
                        String a2 = d.a.a(next);
                        HashMap<String, ArrayList<String>> hashMap3 = this.mUserIdMap;
                        listIterator.add(new BankUserName(a2, str, hashMap3 != null ? hashMap3.get(next) : null, false, next));
                    } else {
                        ListIterator<BankUserName> listIterator2 = this.mBankNameUserList.listIterator();
                        k.a((Object) listIterator2, "mBankNameUserList.listIterator()");
                        boolean z = false;
                        while (listIterator2.hasNext()) {
                            BankUserName next2 = listIterator2.next();
                            k.a((Object) next2, "iterator.next()");
                            BankUserName bankUserName = next2;
                            if (p.a(bankUserName.getMBankChannelCode(), next, false)) {
                                HashMap<String, ArrayList<String>> hashMap4 = this.mUserIdMap;
                                bankUserName.setMUserNameList(hashMap4 != null ? hashMap4.get(next) : null);
                                listIterator2.set(bankUserName);
                                z = true;
                            }
                        }
                        if (!z) {
                            d.a aVar2 = com.paytm.paymentsettings.common.b.d.f43432a;
                            k.a((Object) next, "key");
                            String a3 = d.a.a(next);
                            HashMap<String, ArrayList<String>> hashMap5 = this.mUserIdMap;
                            listIterator2.add(new BankUserName(a3, str, hashMap5 != null ? hashMap5.get(next) : null, false, next));
                        }
                    }
                }
            }
            com.paytm.paymentsettings.paytmassist.view.a.a aVar3 = this.mBankUserAdapter;
            if (aVar3 != null) {
                aVar3.notifyDataSetChanged();
            }
        }
        com.paytm.utility.b.Z((Context) this);
    }

    private final void initViews() {
        this.mIvBackArrow = (ImageView) findViewById(R.id.iv_back_arrow_pas);
        this.mToggleSwitch = (Switch) findViewById(R.id.s_toggle_button_pas);
        this.mIvEmptyListImage = (ImageView) findViewById(R.id.iv_empty_list);
        this.mTvEmptyListText = (TextView) findViewById(R.id.tv_empty_list);
        View findViewById = findViewById(R.id.iv_play_button_pas);
        k.a((Object) findViewById, "findViewById(R.id.iv_play_button_pas)");
        this.mHowItWorks = (ImageView) findViewById;
        ImageView imageView = this.mHowItWorks;
        if (imageView == null) {
            k.a("mHowItWorks");
        }
        imageView.setOnClickListener(new b(this));
        this.mRvBankUserName = (RecyclerView) findViewById(R.id.rv_parent_recycler_view);
        f fVar = new f(this);
        Context context = this;
        ArrayList<BankUserName> arrayList = this.mBankNameUserList;
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "this.supportFragmentManager");
        this.mBankUserAdapter = new com.paytm.paymentsettings.paytmassist.view.a.a(context, arrayList, supportFragmentManager, fVar);
        RecyclerView recyclerView = this.mRvBankUserName;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }
        RecyclerView recyclerView2 = this.mRvBankUserName;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mBankUserAdapter);
        }
        RecyclerView recyclerView3 = this.mRvBankUserName;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new a(context, R.drawable.bg_seperator_pas));
        }
        RecyclerView recyclerView4 = this.mRvBankUserName;
        RecyclerView.f itemAnimator = recyclerView4 != null ? recyclerView4.getItemAnimator() : null;
        if (itemAnimator != null) {
            ((g) itemAnimator).f();
            this.mTvHowItWorks = (TextView) findViewById(R.id.tv_how_it_works_pas);
            TextView textView = this.mTvHowItWorks;
            if (textView != null) {
                textView.setOnClickListener(new c(this));
            }
            ImageView imageView2 = this.mIvBackArrow;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new d(this));
            }
            c.a aVar = com.paytm.paymentsettings.common.b.c.f43430a;
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            k.c(applicationContext, "context");
            a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
            com.paytm.b.a.a a2 = a.C0708a.a(applicationContext, com.paytm.paymentsettings.common.b.c.f43431b);
            Switch switchR = this.mToggleSwitch;
            if (switchR != null) {
                switchR.setChecked(a2.b("easyPay", true, true));
            }
            Switch switchR2 = this.mToggleSwitch;
            if (switchR2 != null) {
                switchR2.setOnCheckedChangeListener(new e(this, a2));
            }
            PaymentSettingsHelper.Companion companion = PaymentSettingsHelper.Companion;
            PaymentSettingsCallBacks b2 = PaymentSettingsHelper.Companion.b();
            if (b2 != null) {
                b2.sendCustomGtmEventWithMap("paytm_assist_settings_screen", new HashMap(), context);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.DefaultItemAnimator");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmAssistSettingsActivity f43574a;

        b(PaytmAssistSettingsActivity paytmAssistSettingsActivity) {
            this.f43574a = paytmAssistSettingsActivity;
        }

        public final void onClick(View view) {
            PaytmAssistSettingsActivity paytmAssistSettingsActivity = this.f43574a;
            a.C0743a aVar = a.f43581a;
            paytmAssistSettingsActivity.bottomSheetFragment = a.C0743a.a("how_it_works", new com.paytm.paymentsettings.paytmassist.model.a(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f43575a;

                public final void onNegative() {
                }

                public final void onPositive() {
                }

                {
                    this.f43575a = r1;
                }

                public final void onDismiss() {
                    com.google.android.material.bottomsheet.b access$getBottomSheetFragment$p = this.f43575a.f43574a.bottomSheetFragment;
                    if (access$getBottomSheetFragment$p != null) {
                        Boolean.valueOf(access$getBottomSheetFragment$p.isAdded());
                    }
                    com.google.android.material.bottomsheet.b access$getBottomSheetFragment$p2 = this.f43575a.f43574a.bottomSheetFragment;
                    if (access$getBottomSheetFragment$p2 != null) {
                        access$getBottomSheetFragment$p2.dismiss();
                    }
                }
            });
            com.google.android.material.bottomsheet.b access$getBottomSheetFragment$p = this.f43574a.bottomSheetFragment;
            if (access$getBottomSheetFragment$p != null) {
                ((a) access$getBottomSheetFragment$p).show(this.f43574a.getSupportFragmentManager(), "how_it_works");
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.paytmassist.view.ui.PaytmAssistBottomSheetFragment");
        }
    }

    public static final class f implements com.paytm.paymentsettings.paytmassist.model.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmAssistSettingsActivity f43580a;

        f(PaytmAssistSettingsActivity paytmAssistSettingsActivity) {
            this.f43580a = paytmAssistSettingsActivity;
        }

        public final void a(boolean z) {
            if (z) {
                this.f43580a.showEmptyList();
            } else {
                this.f43580a.hideEmptyList();
            }
        }

        public final void a(String str, String str2) {
            PaytmAssist.deleteNbUserId(this.f43580a, str2, str);
            PaymentSettingsHelper.Companion companion = PaymentSettingsHelper.Companion;
            PaymentSettingsCallBacks b2 = PaymentSettingsHelper.Companion.b();
            if (b2 != null) {
                b2.sendCustomGtmEventWithMap("paytm_assist_username_delete", new HashMap(), this.f43580a);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmAssistSettingsActivity f43576a;

        c(PaytmAssistSettingsActivity paytmAssistSettingsActivity) {
            this.f43576a = paytmAssistSettingsActivity;
        }

        public final void onClick(View view) {
            PaytmAssistSettingsActivity.access$getMHowItWorks$p(this.f43576a).performClick();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmAssistSettingsActivity f43577a;

        d(PaytmAssistSettingsActivity paytmAssistSettingsActivity) {
            this.f43577a = paytmAssistSettingsActivity;
        }

        public final void onClick(View view) {
            this.f43577a.onBackPressed();
        }
    }

    static final class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmAssistSettingsActivity f43578a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.b.a.a f43579b;

        e(PaytmAssistSettingsActivity paytmAssistSettingsActivity, com.paytm.b.a.a aVar) {
            this.f43578a = paytmAssistSettingsActivity;
            this.f43579b = aVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f43578a.sendGTMEventForClick(z);
            this.f43579b.a("easyPay", z, true);
        }
    }

    /* access modifiers changed from: private */
    public final void sendGTMEventForClick(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("account_paytm_assist_toggle_state", "toggle_set_on");
        } else {
            hashMap.put("account_paytm_assist_toggle_state", "toggle_set_off");
        }
        PaymentSettingsHelper.Companion companion = PaymentSettingsHelper.Companion;
        PaymentSettingsCallBacks b2 = PaymentSettingsHelper.Companion.b();
        if (b2 != null) {
            b2.sendCustomGtmEventWithMap("paytm_assist_toggle", hashMap, this);
        }
    }

    public final void onStart() {
        super.onStart();
        fetchUserId();
    }

    public static class a extends RecyclerView.h {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f43571a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f43572b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f43573c;

        private a(Context context) {
            k.c(context, "context");
            this.f43573c = context;
            this.f43571a = new int[]{16843284};
            TypedArray obtainStyledAttributes = this.f43573c.obtainStyledAttributes(this.f43571a);
            this.f43572b = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(Context context, int i2) {
            this(context);
            k.c(context, "context");
            this.f43572b = androidx.core.content.b.a(context, i2);
        }

        public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(canvas, "c");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            int paddingLeft = recyclerView.getPaddingLeft();
            d.a aVar = com.paytm.paymentsettings.common.b.d.f43432a;
            Context context = this.f43573c;
            k.c(context, "context");
            Resources resources = context.getResources();
            k.a((Object) resources, "context.resources");
            int applyDimension = paddingLeft + ((int) TypedValue.applyDimension(1, 36.0f, resources.getDisplayMetrics()));
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount() - 1;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = recyclerView.getChildAt(i2);
                k.a((Object) childAt, "child");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                    Drawable drawable = this.f43572b;
                    Integer valueOf = drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    int intValue = valueOf.intValue() + bottom;
                    Drawable drawable2 = this.f43572b;
                    if (drawable2 != null) {
                        drawable2.setBounds(applyDimension, bottom, width, intValue);
                    }
                    Drawable drawable3 = this.f43572b;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showEmptyList() {
        TextView textView = this.mTvEmptyListText;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ImageView imageView = this.mIvEmptyListImage;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        RecyclerView recyclerView = this.mRvBankUserName;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void hideEmptyList() {
        TextView textView = this.mTvEmptyListText;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ImageView imageView = this.mIvEmptyListImage;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        RecyclerView recyclerView = this.mRvBankUserName;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }
}
