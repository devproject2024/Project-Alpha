package net.one97.paytm.travel;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.travel.train.model.trainticket.CJRTrainDisplayName;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65154a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f65155b = "Plain";

    /* renamed from: c  reason: collision with root package name */
    private final String f65156c = "Heading";

    /* renamed from: d  reason: collision with root package name */
    private final String f65157d = "Padded";

    /* renamed from: e  reason: collision with root package name */
    private final String f65158e = "Left";

    /* renamed from: f  reason: collision with root package name */
    private final String f65159f = "train_fare_details";

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f65160g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f65161h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f65162i;
    private ArrayList<CJRTrainFareDetail> j;
    private HashMap k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(this.f65159f)) {
            this.j = (ArrayList) arguments.getSerializable(this.f65159f);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.lyt_fare_detail, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        k.c(view, "view");
        this.f65160g = (LinearLayout) view.findViewById(R.id.fare_details_container);
        this.f65161h = (TextView) view.findViewById(R.id.fare_heading);
        this.f65162i = (ImageView) view.findViewById(R.id.detail_close);
        ImageView imageView = this.f65162i;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        ArrayList<CJRTrainFareDetail> arrayList = this.j;
        if (arrayList != null) {
            Iterator<CJRTrainFareDetail> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRTrainFareDetail next = it2.next();
                if ((next != null ? Boolean.valueOf(next.getVisibility()) : null).booleanValue()) {
                    k.a((Object) next, "detail");
                    LinearLayout linearLayout = this.f65160g;
                    if (linearLayout == null) {
                        k.a();
                    }
                    a(next, (ViewGroup) linearLayout);
                }
            }
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        q a2 = jVar.a();
        k.a((Object) a2, "manager.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65166a;

        c(b bVar) {
            this.f65166a = bVar;
        }

        public final void onClick(View view) {
            this.f65166a.dismiss();
        }
    }

    private final void a(CJRTrainFareDetail cJRTrainFareDetail, ViewGroup viewGroup) {
        CJRTrainFareDetail cJRTrainFareDetail2 = cJRTrainFareDetail;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.lyt_fare_detail_item, (ViewGroup) null);
        k.a((Object) inflate, "inflater.inflate(R.layou…t_fare_detail_item, null)");
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.fare_details_layout);
        TextView textView = (TextView) inflate.findViewById(R.id.fare_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fare_value);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sub_title);
        View findViewById = inflate.findViewById(R.id.v_left_empty_view);
        View findViewById2 = inflate.findViewById(R.id.bottom_separator_line);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.plus_symbol);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.lv_child_container);
        if (p.a(cJRTrainFareDetail.getType(), this.f65155b, true) || p.a(cJRTrainFareDetail.getType(), this.f65156c, true) || p.a(cJRTrainFareDetail.getType(), this.f65157d, true)) {
            k.a((Object) findViewById2, "seperator");
            findViewById2.setVisibility(8);
            k.a((Object) relativeLayout, "fareDetailsLayout");
            relativeLayout.setVisibility(0);
            k.a((Object) textView, "fareTitle");
            k.a((Object) textView3, "subTitle");
            k.a((Object) findViewById, "paddingView");
            a(cJRTrainFareDetail2, textView, textView3, findViewById);
            k.a((Object) textView2, "fareValue");
            a(cJRTrainFareDetail2, textView2);
            k.a((Object) imageView, "plusImg");
            k.a((Object) linearLayout, "childContainer");
            a(cJRTrainFareDetail2, imageView, linearLayout);
        } else {
            k.a((Object) findViewById2, "seperator");
            findViewById2.setVisibility(0);
            k.a((Object) relativeLayout, "fareDetailsLayout");
            relativeLayout.setVisibility(8);
        }
        viewGroup.addView(inflate);
    }

    private final void a(CJRTrainFareDetail cJRTrainFareDetail, TextView textView, TextView textView2, View view) {
        if (cJRTrainFareDetail != null) {
            if (p.a(cJRTrainFareDetail.getType(), this.f65157d, true)) {
                view.setVisibility(0);
                textView.setTextSize(2, 12.0f);
            } else {
                view.setVisibility(8);
                textView.setTextSize(2, 13.0f);
            }
            List<CJRTrainDisplayName> displayName = cJRTrainFareDetail.getDisplayName();
            if (displayName != null) {
                textView.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                int size = displayName.size();
                SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder2;
                SpannableStringBuilder spannableStringBuilder4 = spannableStringBuilder;
                for (int i2 = 0; i2 < size; i2++) {
                    CJRTrainDisplayName cJRTrainDisplayName = displayName.get(i2);
                    if (!TextUtils.isEmpty(cJRTrainDisplayName.getText())) {
                        if (!p.a(cJRTrainDisplayName.getAlignment(), this.f65158e, true)) {
                            textView2.setVisibility(0);
                            if (spannableStringBuilder3.length() == 0) {
                                String text = cJRTrainDisplayName.getText();
                                k.a((Object) text, "displayName.getText()");
                                String textType = cJRTrainDisplayName.getTextType();
                                k.a((Object) textType, "displayName.getTextType()");
                                spannableStringBuilder3 = a(spannableStringBuilder3, text, textType, 0);
                            } else {
                                String text2 = cJRTrainDisplayName.getText();
                                k.a((Object) text2, "displayName.getText()");
                                String textType2 = cJRTrainDisplayName.getTextType();
                                k.a((Object) textType2, "displayName.getTextType()");
                                spannableStringBuilder3 = a(spannableStringBuilder3, text2, textType2, spannableStringBuilder4.length());
                            }
                        } else if (spannableStringBuilder4.length() == 0) {
                            String text3 = cJRTrainDisplayName.getText();
                            k.a((Object) text3, "displayName.getText()");
                            String textType3 = cJRTrainDisplayName.getTextType();
                            k.a((Object) textType3, "displayName.getTextType()");
                            spannableStringBuilder4 = a(spannableStringBuilder4, text3, textType3, 0);
                        } else {
                            String text4 = cJRTrainDisplayName.getText();
                            k.a((Object) text4, "displayName.getText()");
                            String textType4 = cJRTrainDisplayName.getTextType();
                            k.a((Object) textType4, "displayName.getTextType()");
                            spannableStringBuilder4 = a(spannableStringBuilder4, text4, textType4, spannableStringBuilder4.length());
                        }
                    }
                }
                textView.setText(spannableStringBuilder4);
                textView2.setText(spannableStringBuilder3);
            }
        }
    }

    private final void a(CJRTrainFareDetail cJRTrainFareDetail, TextView textView) {
        List<CJRTrainValue> value;
        if (cJRTrainFareDetail != null && (value = cJRTrainFareDetail.getValue()) != null) {
            textView.setVisibility(0);
            int size = value.size();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                CJRTrainValue cJRTrainValue = value.get(i2);
                if (cJRTrainValue != null && !TextUtils.isEmpty(cJRTrainValue.getText())) {
                    if (cJRTrainValue.isAmount()) {
                        String text = cJRTrainValue.getText();
                        k.a((Object) text, "value.getText()");
                        String textType = cJRTrainValue.getTextType();
                        k.a((Object) textType, "value.getTextType()");
                        spannableStringBuilder = a(spannableStringBuilder, text, textType, spannableStringBuilder.length());
                    } else if (i2 == 0) {
                        String text2 = cJRTrainValue.getText();
                        k.a((Object) text2, "value.getText()");
                        String textType2 = cJRTrainValue.getTextType();
                        k.a((Object) textType2, "value.getTextType()");
                        spannableStringBuilder = a(spannableStringBuilder, text2, textType2, 0);
                    } else {
                        String text3 = cJRTrainValue.getText();
                        k.a((Object) text3, "value.getText()");
                        String textType3 = cJRTrainValue.getTextType();
                        k.a((Object) textType3, "value.getTextType()");
                        spannableStringBuilder = a(spannableStringBuilder, text3, textType3, spannableStringBuilder.length());
                    }
                }
            }
            textView.setText(spannableStringBuilder);
        }
    }

    private final void a(CJRTrainFareDetail cJRTrainFareDetail, ImageView imageView, LinearLayout linearLayout) {
        if (cJRTrainFareDetail != null) {
            if (cJRTrainFareDetail.getChildList() == null || cJRTrainFareDetail.getChildList().size() <= 0) {
                imageView.setVisibility(8);
                linearLayout.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                linearLayout.setVisibility(0);
                ArrayList<CJRTrainFareDetail> childList = cJRTrainFareDetail.getChildList();
                k.a((Object) childList, "fareDetail.childList");
                int size = childList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CJRTrainFareDetail cJRTrainFareDetail2 = cJRTrainFareDetail.getChildList().get(i2);
                    if (cJRTrainFareDetail2 != null) {
                        a(cJRTrainFareDetail2, (ViewGroup) linearLayout);
                    }
                }
                linearLayout.setVisibility(8);
            }
            imageView.setOnClickListener(new C1289b(this, linearLayout, imageView));
        }
    }

    /* renamed from: net.one97.paytm.travel.b$b  reason: collision with other inner class name */
    static final class C1289b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f65163a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayout f65164b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ImageView f65165c;

        C1289b(b bVar, LinearLayout linearLayout, ImageView imageView) {
            this.f65163a = bVar;
            this.f65164b = linearLayout;
            this.f65165c = imageView;
        }

        public final void onClick(View view) {
            if (this.f65164b.getVisibility() == 0) {
                this.f65164b.setVisibility(8);
                ImageView imageView = this.f65165c;
                FragmentActivity activity = this.f65163a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.sqaure_plus_thin_line));
                return;
            }
            this.f65164b.setVisibility(0);
            ImageView imageView2 = this.f65165c;
            FragmentActivity activity2 = this.f65163a.getActivity();
            if (activity2 == null) {
                k.a();
            }
            k.a((Object) activity2, "activity!!");
            imageView2.setImageDrawable(activity2.getResources().getDrawable(R.drawable.sqaure_minus_thin_line));
        }
    }

    private final SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i2) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            spannableStringBuilder.append(charSequence);
            int hashCode = str2.hashCode();
            if (hashCode != 2076325) {
                if (hashCode != 77195690) {
                    if (hashCode == 2141079518 && str2.equals("Greyed")) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.payment_success_text_grey)), i2, spannableStringBuilder.length(), 0);
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(1.0f), i2, spannableStringBuilder.length(), 0);
                    }
                } else if (str2.equals("Plain")) {
                    spannableStringBuilder.setSpan(new StyleSpan(0), i2, spannableStringBuilder.length(), 0);
                }
            } else if (str2.equals("Bold")) {
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, spannableStringBuilder.length(), 0);
            }
        }
        return spannableStringBuilder;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
