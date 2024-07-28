package net.one97.paytm.landingpage.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.i.f;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ao;

public final class PostpaidLimitIncreaseBottomSheetFragment extends f {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String ppChargesUrlGTMKey = "postpaid_li_popup_charges_url";
    /* access modifiers changed from: private */
    public String ppCibilUrlGTMKey = "postpaid_li_popup_cibil_url";
    /* access modifiers changed from: private */
    public String ppClixUrlGTMKey = "postpaid_li_popup_clix_url";
    private String ppDailyDisplayCountGTMKey = "postpaid_li_popup_daily_display_count";
    private String ppDailyDisplayCountGTMKey2 = "postpaid_li_popup_daily_display_count2";
    /* access modifiers changed from: private */
    public String ppPaytmTnCUrlGTMKey = "postpaid_li_popup_paytmtnc_url";
    private String ppPopupDisplayCountKEY = (getTodayDate() + "pp_popup_daily_disp_count");
    /* access modifiers changed from: private */
    public String proceedButtonDeeplink = "paytmmp://paytm-postpaid?url=lendermigration";
    /* access modifiers changed from: private */
    public String webviewTitle;

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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ String access$getWebviewTitle$p(PostpaidLimitIncreaseBottomSheetFragment postpaidLimitIncreaseBottomSheetFragment) {
        String str = postpaidLimitIncreaseBottomSheetFragment.webviewTitle;
        if (str == null) {
            k.a("webviewTitle");
        }
        return str;
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.fragment_postpaid_limit_increase, (ViewGroup) null);
        dialog.setContentView(inflate);
        String string = getString(R.string.postpaid_limit_increase_text1);
        k.a((Object) string, "getString(R.string.postpaid_limit_increase_text1)");
        this.webviewTitle = string;
        k.a((Object) inflate, "contentView");
        initConfigurations(inflate);
        dialog.setOnShowListener(e.f52791a);
        setupClickableLinksText1(inflate);
        setupClickableLinksText2(inflate);
    }

    static final class e implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final e f52791a = new e();

        e() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                ViewParent parent = frameLayout.getParent();
                if (parent != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                    k.a((Object) from, "BottomSheetBehavior.from(bottomSheet)");
                    from.setPeekHeight(frameLayout.getHeight());
                    ((CoordinatorLayout) parent).getParent().requestLayout();
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    private final void initConfigurations(View view) {
        try {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((View) parent).setBackgroundColor(getResources().getColor(17170445));
                ((CheckBox) view.findViewById(R.id.postpaidLimitIncreaseCheckBox)).setOnCheckedChangeListener(new a(view));
                ((CheckBox) view.findViewById(R.id.postpaidLimitIncreaseCheckBox2)).setOnCheckedChangeListener(new b(view));
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.postpaidLimitIncreaseCheckBox);
                k.a((Object) checkBox, "view.postpaidLimitIncreaseCheckBox");
                checkBox.setChecked(false);
                ((RoboButton) view.findViewById(R.id.proceedButton)).setOnClickListener(new c(this));
                ((ImageView) view.findViewById(R.id.ivClose)).setOnClickListener(new d(this));
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        } catch (Exception unused) {
        }
    }

    static final class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f52787a;

        a(View view) {
            this.f52787a = view;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CheckBox checkBox = (CheckBox) this.f52787a.findViewById(R.id.postpaidLimitIncreaseCheckBox2);
            k.a((Object) checkBox, "view.postpaidLimitIncreaseCheckBox2");
            if (checkBox.isChecked()) {
                RoboButton roboButton = (RoboButton) this.f52787a.findViewById(R.id.proceedButton);
                k.a((Object) roboButton, "view.proceedButton");
                roboButton.setEnabled(z);
            }
        }
    }

    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f52788a;

        b(View view) {
            this.f52788a = view;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CheckBox checkBox = (CheckBox) this.f52788a.findViewById(R.id.postpaidLimitIncreaseCheckBox);
            k.a((Object) checkBox, "view.postpaidLimitIncreaseCheckBox");
            if (checkBox.isChecked()) {
                RoboButton roboButton = (RoboButton) this.f52788a.findViewById(R.id.proceedButton);
                k.a((Object) roboButton, "view.proceedButton");
                roboButton.setEnabled(z);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PostpaidLimitIncreaseBottomSheetFragment f52789a;

        c(PostpaidLimitIncreaseBottomSheetFragment postpaidLimitIncreaseBottomSheetFragment) {
            this.f52789a = postpaidLimitIncreaseBottomSheetFragment;
        }

        public final void onClick(View view) {
            this.f52789a.dismiss();
            net.one97.paytm.common.b.d.b().a(this.f52789a.getContext(), this.f52789a.proceedButtonDeeplink);
            this.f52789a.gaProceedClicked();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PostpaidLimitIncreaseBottomSheetFragment f52790a;

        d(PostpaidLimitIncreaseBottomSheetFragment postpaidLimitIncreaseBottomSheetFragment) {
            this.f52790a = postpaidLimitIncreaseBottomSheetFragment;
        }

        public final void onClick(View view) {
            this.f52790a.dismiss();
        }
    }

    private final void setupClickableLinksText1(View view) {
        String string = getString(R.string.postpaid_limit_increase_text9);
        k.a((Object) string, "getString(R.string.postpaid_limit_increase_text9)");
        CharSequence charSequence = string;
        int a2 = p.a(charSequence, "Experian, CIBIL", 0, false, 6);
        RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.postpaid_limit_increase_text9);
        k.a((Object) roboTextView, "view.postpaid_limit_increase_text9");
        roboTextView.setMovementMethod(LinkMovementMethod.getInstance());
        RoboTextView roboTextView2 = (RoboTextView) view.findViewById(R.id.postpaid_limit_increase_text9);
        k.a((Object) roboTextView2, "view.postpaid_limit_increase_text9");
        roboTextView2.setHighlightColor(0);
        SpannableString spannableString = new SpannableString(charSequence);
        int i2 = 15 + a2;
        spannableString.setSpan("Experian, CIBIL", a2, i2, 33);
        spannableString.setSpan(new PostpaidLimitIncreaseBottomSheetFragment$setupClickableLinksText1$clickableSpan$1(this), a2, i2, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), a2, i2, 33);
        RoboTextView roboTextView3 = (RoboTextView) view.findViewById(R.id.postpaid_limit_increase_text9);
        k.a((Object) roboTextView3, "view.postpaid_limit_increase_text9");
        roboTextView3.setText(spannableString);
    }

    private final void setupClickableLinksText2(View view) {
        String string = getString(R.string.postpaid_limit_increase_text11);
        k.a((Object) string, "getString(R.string.postpaid_limit_increase_text11)");
        CharSequence charSequence = string;
        int a2 = p.a(charSequence, "charges", 0, false, 6);
        int a3 = p.a(charSequence, "Clix", 0, false, 6);
        int a4 = p.a(charSequence, "View Paytm T&C", 0, false, 6);
        RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.postpaid_limit_increase_text11);
        k.a((Object) roboTextView, "view.postpaid_limit_increase_text11");
        roboTextView.setMovementMethod(LinkMovementMethod.getInstance());
        RoboTextView roboTextView2 = (RoboTextView) view.findViewById(R.id.postpaid_limit_increase_text11);
        k.a((Object) roboTextView2, "view.postpaid_limit_increase_text11");
        roboTextView2.setHighlightColor(0);
        SpannableString spannableString = new SpannableString(charSequence);
        int i2 = 7 + a2;
        spannableString.setSpan("charges", a2, i2, 33);
        spannableString.setSpan(new PostpaidLimitIncreaseBottomSheetFragment$setupClickableLinksText2$clickableSpan1$1(this), a2, i2, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), a2, i2, 33);
        int i3 = 4 + a3;
        spannableString.setSpan("Clix", a3, i3, 33);
        spannableString.setSpan(new PostpaidLimitIncreaseBottomSheetFragment$setupClickableLinksText2$clickableSpan2$1(this), a3, i3, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), a3, i3, 33);
        int i4 = 14 + a4;
        spannableString.setSpan("View Paytm T&C", a4, i4, 33);
        spannableString.setSpan(new PostpaidLimitIncreaseBottomSheetFragment$setupClickableLinksText2$clickableSpan3$1(this), a4, i4, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), a4, i4, 33);
        RoboTextView roboTextView3 = (RoboTextView) view.findViewById(R.id.postpaid_limit_increase_text11);
        k.a((Object) roboTextView3, "view.postpaid_limit_increase_text11");
        roboTextView3.setText(spannableString);
    }

    /* access modifiers changed from: private */
    public final void decorateLink(TextPaint textPaint) {
        if (textPaint != null) {
            textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        }
        if (textPaint != null) {
            textPaint.setUnderlineText(false);
        }
        if (textPaint != null) {
            Context context = getContext();
            Integer valueOf = context != null ? Integer.valueOf(androidx.core.content.b.c(context, R.color.paytm_blue)) : null;
            if (valueOf == null) {
                k.a();
            }
            textPaint.setColor(valueOf.intValue());
        }
    }

    /* access modifiers changed from: private */
    public final void gaProceedClicked() {
        try {
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), "paytm_postpaid_clix", "yes_clicked", (String) null, (String) null, (String) null, "/paytm-postpaid-clix/user_consent", "Paytm_postpaid");
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final void checkAndShowPostpaidLimitIncreaseBottomSheet(AppCompatActivity appCompatActivity) {
        k.c(appCompatActivity, "activity");
        if (!appCompatActivity.isFinishing()) {
            try {
                ag.a aVar = ag.f69605a;
                Context applicationContext = appCompatActivity.getApplicationContext();
                k.a((Object) applicationContext, "activity.applicationContext");
                com.paytm.b.a.a a2 = ag.a.a(applicationContext);
                int b2 = a2.b(this.ppPopupDisplayCountKEY, 0, true);
                if (b2 < getDisplayCount()) {
                    ao.a(getClass(), "checkAndShowPostpaidLimitIncreaseBottomSheet");
                    show(appCompatActivity.getSupportFragmentManager().a(), getTag());
                    a2.a(this.ppPopupDisplayCountKEY, b2 + 1, true);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final String getTodayDate() {
        String format = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        k.a((Object) format, "sdf.format(Date())");
        return format;
    }

    private final int getDisplayCount() {
        net.one97.paytm.common.b.e a2 = net.one97.paytm.common.b.d.a();
        getContext();
        return a2.b(this.ppDailyDisplayCountGTMKey2);
    }
}
