package net.one97.paytm.p2p.theme;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import net.one97.paytm.wallet.R;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f57011a;

    /* renamed from: b  reason: collision with root package name */
    public View f57012b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f57013c = new Handler() {
        public final void handleMessage(Message message) {
            if (message.what == 100) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(h.this.f57012b, "translationY", new float[]{0.0f, 20.0f, 0.0f});
                ofFloat.setInterpolator(new b(a.EASE_IN_OUT_EXPO));
                ofFloat.setDuration(1000);
                ofFloat.setStartDelay(0);
                ofFloat.start();
                ofFloat.setRepeatCount(2);
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private Context f57014d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f57015e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f57016f;

    /* renamed from: g  reason: collision with root package name */
    private a f57017g;

    public interface a {
        void b();
    }

    public h(Context context, final a aVar) {
        this.f57014d = context;
        this.f57017g = aVar;
        this.f57011a = new PopupWindow(context);
        this.f57015e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f57012b = this.f57015e.inflate(R.layout.tooltip_p2p_theme_introduction, (ViewGroup) null);
        this.f57016f = (RelativeLayout) this.f57012b.findViewById(R.id.container);
        this.f57016f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h hVar = h.this;
                if (hVar.f57011a != null && hVar.f57011a.isShowing()) {
                    hVar.f57011a.dismiss();
                }
                aVar.b();
            }
        });
        this.f57011a.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public final void onDismiss() {
                aVar.b();
            }
        });
    }
}
