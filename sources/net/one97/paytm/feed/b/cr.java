package net.one97.paytm.feed.b;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.train.FeedTrain;
import net.one97.paytm.feed.repository.models.train.FeedTrainData;
import net.one97.paytm.feed.ui.feed.o.b;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.u;

public final class cr extends cq implements a.C0556a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private long n;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.feed_check_pnr, 5);
        k.put(R.id.feed_pnr_box, 6);
        k.put(R.id.feed_train_pnr_edittext, 7);
    }

    public cr(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, j, k));
    }

    private cr(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[6], objArr[4], objArr[1], objArr[2], objArr[3], objArr[7]);
        this.n = -1;
        this.f34081c.setTag((Object) null);
        this.f34082d.setTag((Object) null);
        this.f34083e.setTag((Object) null);
        this.f34084f.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f34087i = (b) obj;
            synchronized (this) {
                this.n |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f34086h = (FeedTrain) obj;
            synchronized (this) {
                this.n |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r11 = this;
            monitor-enter(r11)
            long r0 = r11.n     // Catch:{ all -> 0x004c }
            r2 = 0
            r11.n = r2     // Catch:{ all -> 0x004c }
            monitor-exit(r11)     // Catch:{ all -> 0x004c }
            net.one97.paytm.feed.repository.models.train.FeedTrain r4 = r11.f34086h
            r5 = 6
            long r5 = r5 & r0
            r7 = 0
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0029
            if (r4 == 0) goto L_0x0019
            net.one97.paytm.feed.repository.models.train.FeedTrainData r4 = r4.getFeedTrainData()
            goto L_0x001a
        L_0x0019:
            r4 = r7
        L_0x001a:
            if (r4 == 0) goto L_0x0029
            java.lang.String r5 = r4.getLogoUrl()
            java.lang.String r6 = r4.getDescription()
            java.lang.String r4 = r4.getTitle()
            goto L_0x002c
        L_0x0029:
            r4 = r7
            r5 = r4
            r6 = r5
        L_0x002c:
            r9 = 4
            long r0 = r0 & r9
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x003a
            android.widget.TextView r0 = r11.f34081c
            android.view.View$OnClickListener r1 = r11.m
            r0.setOnClickListener(r1)
        L_0x003a:
            if (r8 == 0) goto L_0x004b
            android.widget.TextView r0 = r11.f34082d
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r4)
            android.widget.TextView r0 = r11.f34083e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
            android.widget.ImageView r0 = r11.f34084f
            net.one97.paytm.feed.utility.a.a(r0, r5, r7, r7)
        L_0x004b:
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x004c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.b.cr.executeBindings():void");
    }

    public final void a(int i2, View view) {
        View view2 = view;
        b bVar = this.f34087i;
        FeedTrain feedTrain = this.f34086h;
        if (bVar != null) {
            if (feedTrain != null) {
                FeedTrainData feedTrainData = feedTrain.getFeedTrainData();
                if (feedTrainData != null) {
                    String url = feedTrainData.getUrl();
                    EditText editText = this.f34085g;
                    k.c(view2, "view");
                    k.c(editText, "pnr");
                    k.c(url, H5TabbarUtils.MATCH_TYPE_PATH);
                    Editable text = editText.getText();
                    k.a((Object) text, "pnr.text");
                    if (text.length() == 0) {
                        Toast.makeText(view.getContext(), R.string.feed_empty_pnr, 0).show();
                        return;
                    }
                    j jVar = j.f35397a;
                    Context context = view.getContext();
                    k.a((Object) context, "view.context");
                    if (j.e(context)) {
                        u uVar = u.f35438a;
                        if (!u.a() && !bVar.f35165a) {
                            bVar.f35165a = true;
                            String obj = editText.getText().toString();
                            Context context2 = view.getContext();
                            k.a((Object) context2, "view.context");
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj + context2.getString(R.string.feed_train_checking));
                            spannableStringBuilder.setSpan(new TypefaceSpan("sans-serif"), obj.length(), spannableStringBuilder.length(), 33);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context2, R.color.feed_paytm_blue)), obj.length(), spannableStringBuilder.length(), 33);
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(context2.getResources().getDimensionPixelSize(R.dimen.feed_comment_posting_size), true), obj.length(), spannableStringBuilder.length(), 33);
                            editText.setText(spannableStringBuilder);
                            net.one97.paytm.feed.repository.a.b bVar2 = net.one97.paytm.feed.repository.a.b.f34366b;
                            Context context3 = view.getContext();
                            k.a((Object) context3, "view.context");
                            kotlin.g.a.b aVar = new b.a(bVar, view2, editText, obj);
                            k.c(context3, "context");
                            k.c(url, H5TabbarUtils.MATCH_TYPE_PATH);
                            k.c(obj, "pnr");
                            k.c(aVar, "completionHandler");
                            String str = url + "?pnr_number=" + obj;
                            String str2 = net.one97.paytm.feed.repository.a.b.f34365a;
                            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                            net.one97.paytm.feed.e.b.k();
                            b.ck ckVar = new b.ck(bVar2, str, aVar, str, new b.cl(aVar), new b.cm(aVar));
                            ckVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(context3));
                            net.one97.paytm.feed.repository.a.a.f34362b.a(context3).a(ckVar);
                            return;
                        }
                        return;
                    }
                    Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
                }
            }
        }
    }
}
