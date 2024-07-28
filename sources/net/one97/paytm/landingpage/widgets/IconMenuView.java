package net.one97.paytm.landingpage.widgets;

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
    private RelativeLayout f53043a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f53044b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f53045c;

    public interface a {
        void onIconMenuClick(View view);
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
        this.f53043a = (RelativeLayout) findViewById(R.id.lyt_icon_menu);
        this.f53043a.setClickable(true);
        this.f53043a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                IconMenuView.this.f53045c.onIconMenuClick(view);
            }
        });
        this.f53044b = (ImageView) findViewById(R.id.icon_menu);
        this.f53044b.setImageResource(R.drawable.wallet_deals_icon);
    }

    public void setIconMenuVisibility(int i2) {
        this.f53043a.setVisibility(i2);
    }

    public void setImageIconResource(int i2) {
        this.f53044b.setImageResource(i2);
    }

    public void setImageIconFromURL(String str) {
        b.a.C0750a a2 = b.a(getContext());
        a2.f43753a = str.replace(" ", "%20");
        b.a.C0750a.a(b.a.C0750a.a(a2, a.c.HOME.name()), this.f53044b, (com.paytm.utility.b.b.b) null, 2);
    }

    public void setClickable(boolean z) {
        this.f53043a.setClickable(z);
    }

    public void setIconMenuViewClickListener(a aVar) {
        this.f53045c = aVar;
    }
}
