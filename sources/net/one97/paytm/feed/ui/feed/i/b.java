package net.one97.paytm.feed.ui.feed.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.l;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ay;
import net.one97.paytm.feed.repository.models.polls.Options;
import net.one97.paytm.feed.repository.models.polls.Polls;

public final class b extends net.one97.paytm.feed.ui.base.b<ay, Polls, c> implements d {

    /* renamed from: b  reason: collision with root package name */
    public String f35075b;

    /* renamed from: c  reason: collision with root package name */
    public final View f35076c;

    /* renamed from: d  reason: collision with root package name */
    private int f35077d = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "view");
        this.f35076c = view;
    }

    public final void a(Context context, List<Options> list) {
        k.c(context, "context");
        k.c(list, "options");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        String str = this.f35075b;
        if (str == null) {
            k.a("pollsId");
        }
        net.one97.paytm.feed.e.b.a(str, list);
        l lVar = new l("[^0-9]");
        Collection collection = list;
        int size = collection.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f35077d <= list.get(i2).getOptionscount()) {
                this.f35077d = list.get(i2).getOptionscount();
            }
            if (i2 == 0) {
                TextView textView = ((ay) this.f34872a).f33908f;
                k.a((Object) textView, "dataBinding.option1votepercent");
                textView.setText(list.get(i2).getOptionsvalue());
                ProgressBar progressBar = ((ay) this.f34872a).f33907e;
                k.a((Object) progressBar, "dataBinding.option1vote");
                progressBar.setProgress(Integer.parseInt(lVar.replace((CharSequence) list.get(i2).getOptionsvalue(), "")));
            } else if (i2 == 1) {
                TextView textView2 = ((ay) this.f34872a).j;
                k.a((Object) textView2, "dataBinding.option2votepercent");
                textView2.setText(list.get(i2).getOptionsvalue());
                ProgressBar progressBar2 = ((ay) this.f34872a).f33911i;
                k.a((Object) progressBar2, "dataBinding.option2vote");
                progressBar2.setProgress(Integer.parseInt(lVar.replace((CharSequence) list.get(i2).getOptionsvalue(), "")));
            } else if (i2 != 2) {
                TextView textView3 = ((ay) this.f34872a).r;
                k.a((Object) textView3, "dataBinding.option4votepercent");
                textView3.setText(list.get(i2).getOptionsvalue());
                ProgressBar progressBar3 = ((ay) this.f34872a).q;
                k.a((Object) progressBar3, "dataBinding.option4vote");
                progressBar3.setProgress(Integer.parseInt(lVar.replace((CharSequence) list.get(i2).getOptionsvalue(), "")));
            } else {
                TextView textView4 = ((ay) this.f34872a).n;
                k.a((Object) textView4, "dataBinding.option3votepercent");
                textView4.setText(list.get(i2).getOptionsvalue());
                ProgressBar progressBar4 = ((ay) this.f34872a).m;
                k.a((Object) progressBar4, "dataBinding.option3vote");
                progressBar4.setProgress(Integer.parseInt(lVar.replace((CharSequence) list.get(i2).getOptionsvalue(), "")));
            }
        }
        int size2 = collection.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (this.f35077d == list.get(i3).getOptionscount()) {
                if (i3 == 0) {
                    ProgressBar progressBar5 = ((ay) this.f34872a).f33907e;
                    k.a((Object) progressBar5, "dataBinding.option1vote");
                    progressBar5.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_yes)));
                } else if (i3 == 1) {
                    ProgressBar progressBar6 = ((ay) this.f34872a).f33911i;
                    k.a((Object) progressBar6, "dataBinding.option2vote");
                    progressBar6.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_yes)));
                } else if (i3 != 2) {
                    ProgressBar progressBar7 = ((ay) this.f34872a).q;
                    k.a((Object) progressBar7, "dataBinding.option4vote");
                    progressBar7.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_yes)));
                } else {
                    ProgressBar progressBar8 = ((ay) this.f34872a).m;
                    k.a((Object) progressBar8, "dataBinding.option3vote");
                    progressBar8.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_yes)));
                }
            } else if (i3 == 0) {
                ProgressBar progressBar9 = ((ay) this.f34872a).f33907e;
                k.a((Object) progressBar9, "dataBinding.option1vote");
                progressBar9.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_no)));
            } else if (i3 == 1) {
                ProgressBar progressBar10 = ((ay) this.f34872a).f33911i;
                k.a((Object) progressBar10, "dataBinding.option2vote");
                progressBar10.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_no)));
            } else if (i3 != 2) {
                ProgressBar progressBar11 = ((ay) this.f34872a).q;
                k.a((Object) progressBar11, "dataBinding.option4vote");
                progressBar11.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_no)));
            } else {
                ProgressBar progressBar12 = ((ay) this.f34872a).m;
                k.a((Object) progressBar12, "dataBinding.option3vote");
                progressBar12.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context, R.color.feed_poll_progress_no)));
            }
        }
    }
}
