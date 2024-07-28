package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.recharge.R;

public class RechargeIconMenuView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f61477a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f61478b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f61479c;

    public interface a {
        void onIconMenuClick(View view);
    }

    public RechargeIconMenuView(Context context) {
        super(context);
        a(context);
    }

    public RechargeIconMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RechargeIconMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.recharge_lyt_icon_menu, this, true);
        this.f61477a = (RelativeLayout) findViewById(R.id.lyt_icon_menu);
        this.f61477a.setClickable(true);
        this.f61477a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RechargeIconMenuView.this.f61479c.onIconMenuClick(view);
            }
        });
        this.f61478b = (ImageView) findViewById(R.id.icon_menu);
    }

    public void setIconMenuVisibility(int i2) {
        this.f61477a.setVisibility(i2);
    }

    public void setImageIconResource(int i2) {
        this.f61478b.setImageResource(i2);
    }

    public void setImageIconFromURL(String str) {
        w.a().a(str.replace(" ", "%20")).a(this.f61478b, (e) null);
    }

    public void setClickable(boolean z) {
        this.f61477a.setClickable(z);
    }

    public void setIconMenuViewClickListener(a aVar) {
        this.f61479c = aVar;
    }
}
