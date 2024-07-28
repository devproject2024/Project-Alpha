package net.one97.paytm.games.view.pfg.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.games.R;

public final class CustomView extends LinearLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f35747a;

    public final View b(int i2) {
        if (this.f35747a == null) {
            this.f35747a = new HashMap();
        }
        View view = (View) this.f35747a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f35747a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public CustomView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(getContext()).inflate(R.layout.refresh_header, this, true);
        setBackgroundColor(-7829368);
    }

    public final void a() {
        TextView textView = (TextView) b(R.id.tv);
        k.a((Object) textView, "tv");
        net.one97.paytm.games.e.a.a aVar = net.one97.paytm.games.e.a.a.f35590a;
        Context context = getContext();
        k.a((Object) context, "context");
        textView.setText(net.one97.paytm.games.e.a.a.a(context).getString(R.string.games_pull_to_refresh));
    }

    public final void b() {
        TextView textView = (TextView) b(R.id.tv);
        k.a((Object) textView, "tv");
        net.one97.paytm.games.e.a.a aVar = net.one97.paytm.games.e.a.a.f35590a;
        Context context = getContext();
        k.a((Object) context, "context");
        textView.setText(net.one97.paytm.games.e.a.a.a(context).getString(R.string.games_refreshing));
        kotlin.c.a.a(false, new a(this), 31);
    }

    static final class a extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ CustomView this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CustomView customView) {
            super(0);
            this.this$0 = customView;
        }

        public final void invoke() {
            while (true) {
                Thread.sleep(6);
                ((ImageView) this.this$0.b(R.id.iv)).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f35748a;

                    {
                        this.f35748a = r1;
                    }

                    public final void run() {
                        ImageView imageView = (ImageView) this.f35748a.this$0.b(R.id.iv);
                        k.a((Object) imageView, "iv");
                        imageView.setRotation(imageView.getRotation() + 1.0f);
                    }
                });
            }
        }
    }

    public final void c() {
        TextView textView = (TextView) b(R.id.tv);
        k.a((Object) textView, "tv");
        net.one97.paytm.games.e.a.a aVar = net.one97.paytm.games.e.a.a.f35590a;
        Context context = getContext();
        k.a((Object) context, "context");
        textView.setText(net.one97.paytm.games.e.a.a.a(context).getString(R.string.games_refreshed));
    }

    public final void a(int i2) {
        ImageView imageView = (ImageView) b(R.id.iv);
        k.a((Object) imageView, "iv");
        imageView.setRotation((float) i2);
    }
}
