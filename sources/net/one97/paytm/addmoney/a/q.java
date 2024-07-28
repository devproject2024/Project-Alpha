package net.one97.paytm.addmoney.a;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.addmoney.cvvHelp.d.a;

public abstract class q extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f48090a;

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatImageView f48091b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f48092c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f48093d;

    /* renamed from: e  reason: collision with root package name */
    public final RoboTextView f48094e;

    /* renamed from: f  reason: collision with root package name */
    protected a f48095f;

    public abstract void a(a aVar);

    protected q(e eVar, View view, Button button, AppCompatImageView appCompatImageView, ImageView imageView, TextView textView, RoboTextView roboTextView) {
        super(eVar, view, 2);
        this.f48090a = button;
        this.f48091b = appCompatImageView;
        this.f48092c = imageView;
        this.f48093d = textView;
        this.f48094e = roboTextView;
    }
}
