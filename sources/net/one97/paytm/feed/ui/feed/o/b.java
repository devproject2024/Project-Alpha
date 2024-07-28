package net.one97.paytm.feed.ui.feed.o;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.j;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.f.a.i;
import net.one97.paytm.feed.ui.feed.o.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35165a;

    /* renamed from: b  reason: collision with root package name */
    final j f35166b;

    public static final class a extends l implements kotlin.g.a.b<i, x> {
        final /* synthetic */ EditText $pnr;
        final /* synthetic */ String $pnrNo;
        final /* synthetic */ View $view;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view, EditText editText, String str) {
            super(1);
            this.this$0 = bVar;
            this.$view = view;
            this.$pnr = editText;
            this.$pnrNo = str;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((i) obj);
            return x.f47997a;
        }

        public final void invoke(i iVar) {
            if (iVar != null) {
                a.C0583a aVar = a.f35162d;
                k.c(iVar, "pnrStatus");
                a aVar2 = new a();
                Bundle bundle = new Bundle();
                bundle.putSerializable("pnrData", iVar);
                aVar2.setArguments(bundle);
                aVar2.show(this.this$0.f35166b, "CheckPnrBottomSheetFragment");
            } else {
                Toast.makeText(this.$view.getContext(), R.string.feed_server_error, 0).show();
            }
            this.$pnr.setText(this.$pnrNo);
            this.this$0.f35165a = false;
        }
    }
}
