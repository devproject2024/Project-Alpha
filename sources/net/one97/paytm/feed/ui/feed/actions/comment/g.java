package net.one97.paytm.feed.ui.feed.actions.comment;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.vectordrawable.a.a.i;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    final e f34970a;

    public static final class a extends l implements b<CommentResponse, x> {
        final /* synthetic */ EditText $editText;
        final /* synthetic */ ImageView $send;
        final /* synthetic */ String $textToSend;
        final /* synthetic */ g this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, ImageView imageView, EditText editText, String str) {
            super(1);
            this.this$0 = gVar;
            this.$send = imageView;
            this.$editText = editText;
            this.$textToSend = str;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CommentResponse) obj);
            return x.f47997a;
        }

        public final void invoke(CommentResponse commentResponse) {
            if (commentResponse != null) {
                ImageView imageView = this.$send;
                Context context = imageView.getContext();
                k.a((Object) context, "send.context");
                imageView.setImageDrawable(i.a(context.getResources(), R.drawable.feed_ic_send, (Resources.Theme) null));
                this.$send.setEnabled(true);
                this.this$0.f34970a.a(commentResponse);
                return;
            }
            ImageView imageView2 = this.$send;
            Context context2 = imageView2.getContext();
            k.a((Object) context2, "send.context");
            imageView2.setImageDrawable(i.a(context2.getResources(), R.drawable.feed_ic_send, (Resources.Theme) null));
            this.$send.setEnabled(true);
            this.$editText.setText(this.$textToSend);
            this.this$0.f34970a.a((CommentResponse) null);
        }
    }

    public g(e eVar) {
        k.c(eVar, "listener");
        this.f34970a = eVar;
    }
}
