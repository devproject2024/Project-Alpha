package net.one97.paytm.addmoney.a;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.addmoney.addmoneysource.a.e.a;

public abstract class w extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f48113a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f48114b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f48115c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f48116d;

    /* renamed from: e  reason: collision with root package name */
    public final RadioButton f48117e;

    /* renamed from: f  reason: collision with root package name */
    public final RadioButton f48118f;

    /* renamed from: g  reason: collision with root package name */
    public final RadioButton f48119g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f48120h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f48121i;
    public final RoboTextView j;
    public final RoboTextView k;
    public final RoboTextView l;
    public final RadioGroup m;
    protected a n;

    public abstract void a(a aVar);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected w(e eVar, View view, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RelativeLayout relativeLayout, LinearLayout linearLayout3, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, RadioGroup radioGroup) {
        super(eVar, view, 4);
        e eVar2 = eVar;
        View view2 = view;
        this.f48113a = linearLayout;
        this.f48114b = linearLayout2;
        this.f48115c = editText;
        this.f48116d = imageView;
        this.f48117e = radioButton;
        this.f48118f = radioButton2;
        this.f48119g = radioButton3;
        this.f48120h = relativeLayout;
        this.f48121i = linearLayout3;
        this.j = roboTextView;
        this.k = roboTextView2;
        this.l = roboTextView3;
        this.m = radioGroup;
    }
}
