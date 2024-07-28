package net.one97.paytm.feed.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.h;
import androidx.vectordrawable.a.a.i;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.ui.feed.actions.comment.c;
import net.one97.paytm.feed.ui.feed.actions.comment.g;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.u;

public final class l extends k implements a.C0556a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final RelativeLayout l;
    private final View.OnClickListener m;
    private g n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.comments_recyclerview, 5);
        k.put(R.id.feed_loading_progress, 6);
        k.put(R.id.feed_comment_edittext_container, 7);
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, j, k));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[3], objArr[1], objArr[7], objArr[2], objArr[4], objArr[6]);
        this.n = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) l.this.f34183c);
                c cVar = l.this.f34189i;
                boolean z = true;
                if (cVar != null) {
                    k.c(a2, "value");
                    cVar.f34964e = a2;
                    cVar.a(net.one97.paytm.feed.a.y);
                    if (a2.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        cVar.a(net.one97.paytm.feed.a.w);
                    }
                }
            }
        };
        this.o = -1;
        this.f34182b.setTag((Object) null);
        this.f34183c.setTag((Object) null);
        this.f34185e.setTag((Object) null);
        this.f34186f.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.s == i2) {
            c cVar = (c) obj;
            updateRegistration(0, (h) cVar);
            this.f34189i = cVar;
            synchronized (this) {
                this.o |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.s);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.H != i2) {
            return false;
        } else {
            this.f34188h = (net.one97.paytm.feed.ui.feed.actions.comment.g) obj;
            synchronized (this) {
                this.o |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.H);
            super.requestRebind();
        }
        return true;
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 == net.one97.paytm.feed.a.f33774a) {
            synchronized (this) {
                this.o |= 1;
            }
            return true;
        } else if (i2 == net.one97.paytm.feed.a.w) {
            synchronized (this) {
                this.o |= 4;
            }
            return true;
        } else if (i2 == net.one97.paytm.feed.a.y) {
            synchronized (this) {
                this.o |= 8;
            }
            return true;
        } else if (i2 != net.one97.paytm.feed.a.l) {
            return false;
        } else {
            synchronized (this) {
                this.o |= 16;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.o     // Catch:{ all -> 0x00aa }
            r4 = 0
            r1.o = r4     // Catch:{ all -> 0x00aa }
            monitor-exit(r18)     // Catch:{ all -> 0x00aa }
            net.one97.paytm.feed.ui.feed.actions.comment.c r0 = r1.f34189i
            r6 = 61
            long r6 = r6 & r2
            r8 = 41
            r10 = 37
            r12 = 49
            r14 = 0
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x006e
            long r6 = r2 & r12
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0038
            if (r0 == 0) goto L_0x0026
            boolean r6 = r0.f34965f
            goto L_0x0027
        L_0x0026:
            r6 = 0
        L_0x0027:
            if (r16 == 0) goto L_0x0032
            if (r6 == 0) goto L_0x002e
            r16 = 128(0x80, double:6.32E-322)
            goto L_0x0030
        L_0x002e:
            r16 = 64
        L_0x0030:
            long r2 = r2 | r16
        L_0x0032:
            if (r6 == 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r6 = 8
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            long r16 = r2 & r8
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0061
            if (r0 == 0) goto L_0x0061
            java.lang.String r7 = r0.f34964e
            if (r7 == 0) goto L_0x0059
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.CharSequence r7 = kotlin.m.p.b(r7)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0061
            r15 = 1
            goto L_0x0061
        L_0x0059:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r2)
            throw r0
        L_0x0061:
            long r16 = r2 & r10
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x006c
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = r0.f34964e
            goto L_0x0070
        L_0x006c:
            r0 = r14
            goto L_0x0070
        L_0x006e:
            r0 = r14
            r6 = 0
        L_0x0070:
            long r12 = r12 & r2
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
            android.widget.TextView r7 = r1.f34182b
            r7.setVisibility(r6)
            android.widget.TextView r7 = r1.f34186f
            r7.setVisibility(r6)
        L_0x007f:
            long r6 = r2 & r10
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x008a
            android.widget.EditText r6 = r1.f34183c
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r0)
        L_0x008a:
            r6 = 32
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x009f
            android.widget.EditText r0 = r1.f34183c
            androidx.databinding.g r6 = r1.n
            androidx.databinding.a.d.a(r0, r14, r14, r6)
            android.widget.ImageView r0 = r1.f34185e
            android.view.View$OnClickListener r6 = r1.m
            r0.setOnClickListener(r6)
        L_0x009f:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a9
            android.widget.ImageView r0 = r1.f34185e
            net.one97.paytm.feed.utility.a.b((android.view.View) r0, (boolean) r15)
        L_0x00a9:
            return
        L_0x00aa:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x00aa }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.l.executeBindings():void");
    }

    public final void a(int i2, View view) {
        String pid;
        c cVar = this.f34189i;
        net.one97.paytm.feed.ui.feed.actions.comment.g gVar = this.f34188h;
        if (gVar != null) {
            if (cVar != null) {
                String str = cVar.f34964e;
                ImageView imageView = this.f34185e;
                EditText editText = this.f34183c;
                k.c(imageView, "send");
                k.c(editText, "editText");
                k.c(cVar, "viewModel");
                k.c(str, "textToSend");
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                if (net.one97.paytm.feed.e.c.a(imageView.getContext())) {
                    j jVar = j.f35397a;
                    Context context = imageView.getContext();
                    k.a((Object) context, "send.context");
                    if (!j.e(context)) {
                        Toast.makeText(imageView.getContext(), R.string.feed_no_internet, 0).show();
                    } else if (!TextUtils.isEmpty(p.b(str).toString())) {
                        u uVar = u.f35438a;
                        if (!u.a()) {
                            imageView.setEnabled(false);
                            Context context2 = imageView.getContext();
                            k.a((Object) context2, "send.context");
                            imageView.setImageDrawable(i.a(context2.getResources(), R.drawable.feed_ic_send_empty, (Resources.Theme) null));
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + imageView.getContext().getString(R.string.feed_comment_posting));
                            spannableStringBuilder.setSpan(new TypefaceSpan("sans-serif"), str.length(), spannableStringBuilder.length(), 33);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(b.c(imageView.getContext(), R.color.feed_paytm_blue)), str.length(), spannableStringBuilder.length(), 33);
                            Context context3 = imageView.getContext();
                            k.a((Object) context3, "send.context");
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(context3.getResources().getDimensionPixelSize(R.dimen.feed_comment_posting_size), true), str.length(), spannableStringBuilder.length(), 33);
                            editText.setText(spannableStringBuilder);
                            Context context4 = editText.getContext();
                            k.a((Object) context4, "editText.context");
                            Context applicationContext = context4.getApplicationContext();
                            k.a((Object) applicationContext, "editText.context.applicationContext");
                            kotlin.g.a.b aVar = new g.a(gVar, imageView, editText, str);
                            k.c(applicationContext, "context");
                            k.c(str, CJRQRScanResultModel.KEY_COMMENT_SMALL);
                            k.c(aVar, "completionHandler");
                            FeedItem feedItem = cVar.f34961b;
                            if (feedItem != null && (pid = feedItem.getPid()) != null) {
                                net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
                                net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                                String str2 = "/content-comments/v1/post/" + pid + "/comment/";
                                kotlin.g.a.b cVar3 = new c.C0571c(cVar, applicationContext, str, aVar);
                                k.c(applicationContext, "context");
                                k.c(str2, H5TabbarUtils.MATCH_TYPE_PATH);
                                k.c(pid, "pID");
                                k.c(str, CJRQRScanResultModel.KEY_COMMENT_SMALL);
                                k.c(cVar3, "completionHandler");
                                net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
                                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                                String b2 = net.one97.paytm.feed.utility.l.b(applicationContext, net.one97.paytm.feed.e.b.h(), str2, (Map<String, ? extends Object>) null);
                                String str3 = net.one97.paytm.feed.repository.a.b.f34365a;
                                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                                net.one97.paytm.feed.e.b.k();
                                b.bj bjVar = new b.bj(a2, pid, str, b2, cVar3, applicationContext, b2, new b.bk(cVar3), new b.bl(cVar3, applicationContext));
                                bjVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(applicationContext));
                                net.one97.paytm.feed.repository.a.a a3 = net.one97.paytm.feed.repository.a.a.f34362b.a(applicationContext);
                                if (a3 != null) {
                                    a3.a(bjVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
