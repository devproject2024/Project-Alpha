package net.one97.paytm.landingpage.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.paytm.network.a;
import com.paytm.utility.b.b;
import net.one97.paytm.landingpage.R;

public class IconMenuView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f52880a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f52881b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f52882c;

    public interface a {
    }

    public IconMenuView(Context context) {
        super(context);
        a(context);
    }

    public IconMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public IconMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.lyt_icon_menu, this, true);
        this.f52880a = (RelativeLayout) findViewById(R.id.lyt_icon_menu);
        this.f52880a.setClickable(true);
        this.f52880a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a unused = IconMenuView.this.f52882c;
            }
        });
        this.f52881b = (ImageView) findViewById(R.id.icon_menu);
        this.f52881b.setImageResource(R.drawable.wallet_deals_icon);
    }

    public void setIconMenuVisibility(int i2) {
        this.f52880a.setVisibility(i2);
    }

    public void setImageIconResource(int i2) {
        this.f52881b.setImageResource(i2);
    }

    public void setImageIconFromURL(String str) {
        b.a.C0750a a2 = b.a(getContext());
        a2.f43753a = str.replace(" ", "%20");
        b.a.C0750a.a(b.a.C0750a.a(a2, a.c.HOME.name()), this.f52881b, (com.paytm.utility.b.b.b) null, 2);
    }

    public void setClickable(boolean z) {
        this.f52880a.setClickable(z);
    }

    public void setIconMenuViewClickListener(a aVar) {
        this.f52882c = aVar;
    }
}
