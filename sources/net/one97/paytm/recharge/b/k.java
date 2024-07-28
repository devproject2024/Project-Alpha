package net.one97.paytm.recharge.b;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.recharge.common.fragment.e;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;

public abstract class k extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CheckBox f60347a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f60348b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f60349c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f60350d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f60351e;

    /* renamed from: f  reason: collision with root package name */
    public final RoboTextView f60352f;

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f60353g;

    /* renamed from: h  reason: collision with root package name */
    protected CJRUtilityAlertV2 f60354h;

    /* renamed from: i  reason: collision with root package name */
    protected e f60355i;

    public abstract void a(e eVar);

    public abstract void a(CJRUtilityAlertV2 cJRUtilityAlertV2);

    protected k(Object obj, View view, CheckBox checkBox, Button button, LinearLayout linearLayout, ImageView imageView, TextView textView, RoboTextView roboTextView, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f60347a = checkBox;
        this.f60348b = button;
        this.f60349c = linearLayout;
        this.f60350d = imageView;
        this.f60351e = textView;
        this.f60352f = roboTextView;
        this.f60353g = recyclerView;
    }
}
