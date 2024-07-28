package net.one97.paytm.hotel4.view.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.h;
import com.travel.a.c;
import com.travel.utils.t;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.dm;

public final class n extends c<PromocodeDataItem> {

    /* renamed from: b  reason: collision with root package name */
    ReviewViewModel f28708b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28709c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f28710d;

    public /* synthetic */ n(ReviewViewModel reviewViewModel) {
        this(reviewViewModel, false);
    }

    public final /* synthetic */ void a(ViewDataBinding viewDataBinding, Object obj, int i2) {
        PromocodeDataItem promocodeDataItem = (PromocodeDataItem) obj;
        k.c(viewDataBinding, "binding");
        k.c(promocodeDataItem, "item");
        if (viewDataBinding instanceof dm) {
            ReviewViewModel reviewViewModel = this.f28708b;
            if (reviewViewModel != null) {
                ((dm) viewDataBinding).a(reviewViewModel);
            }
            dm dmVar = (dm) viewDataBinding;
            dmVar.a(promocodeDataItem);
            dmVar.a(Boolean.valueOf(this.f28710d));
            TextView textView = dmVar.f29495d;
            k.a((Object) textView, "binding.tvOfferName");
            textView.setText(promocodeDataItem.getCode());
            TextView textView2 = dmVar.f29494c;
            k.a((Object) textView2, "binding.tvCashback");
            textView2.setVisibility(4);
            TextView textView3 = dmVar.f29496e;
            String str = promocodeDataItem.getOfferText() + " View T&C";
            if (textView3 == null) {
                k.a();
            }
            textView3.setText(str);
            o oVar = new o("View T&C", new a(this, promocodeDataItem));
            int parseColor = Color.parseColor("#03a9f4");
            k.c(textView3, "$this$makePartofStringClickable");
            k.c(oVar, "clickableTextPair");
            SpannableString spannableString = new SpannableString(textView3.getText());
            t.a aVar = new t.a(oVar);
            int a2 = p.a((CharSequence) textView3.getText().toString(), (String) oVar.getFirst(), 0, false, 6);
            spannableString.setSpan(aVar, a2, ((String) oVar.getFirst()).length() + a2, 33);
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            textView3.setText(spannableString, TextView.BufferType.SPANNABLE);
            textView3.setLinkTextColor(parseColor);
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            textView3.setHighlightColor(textView3.getResources().getColor(17170445));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(ReviewViewModel reviewViewModel, boolean z) {
        super(new h.c<PromocodeDataItem>() {
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                PromocodeDataItem promocodeDataItem = (PromocodeDataItem) obj;
                PromocodeDataItem promocodeDataItem2 = (PromocodeDataItem) obj2;
                k.c(promocodeDataItem, "oldItem");
                k.c(promocodeDataItem2, "newItem");
                return k.a((Object) promocodeDataItem, (Object) promocodeDataItem2);
            }

            public final /* synthetic */ boolean b(Object obj, Object obj2) {
                PromocodeDataItem promocodeDataItem = (PromocodeDataItem) obj;
                PromocodeDataItem promocodeDataItem2 = (PromocodeDataItem) obj2;
                k.c(promocodeDataItem, "oldItem");
                k.c(promocodeDataItem2, "newItem");
                return k.a((Object) promocodeDataItem, (Object) promocodeDataItem2);
            }
        });
        k.c(reviewViewModel, "reviewViewModel");
        this.f28710d = z;
        this.f28708b = reviewViewModel;
    }

    public final ViewDataBinding a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        this.f28709c = viewGroup.getContext();
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.h4_rb_promocode_cell, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        return a2;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f28711a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PromocodeDataItem f28712b;

        a(n nVar, PromocodeDataItem promocodeDataItem) {
            this.f28711a = nVar;
            this.f28712b = promocodeDataItem;
        }

        public final void onClick(View view) {
            this.f28711a.f28708b.getPromoCodeSelectedForTnC().setValue(this.f28712b);
            this.f28711a.f28708b.openTnC();
        }
    }
}
