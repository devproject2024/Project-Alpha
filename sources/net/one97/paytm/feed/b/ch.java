package net.one97.paytm.feed.b;

import android.content.Context;
import android.content.Intent;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.repository.models.stories.User;
import net.one97.paytm.feed.ui.feed.story.StoryViewActivity;

public final class ch extends cg implements a.C0556a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f34050h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f34051i = null;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ch(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f34050h, f34051i));
    }

    private ch(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1]);
        this.l = -1;
        this.f34043a.setTag((Object) null);
        this.f34044b.setTag((Object) null);
        this.f34045c.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        setRootTag(view);
        this.k = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.p == i2) {
            this.f34047e = (Integer) obj;
            synchronized (this) {
                this.l |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.p);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f34049g = (net.one97.paytm.feed.ui.feed.story.e) obj;
            synchronized (this) {
                this.l |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33778e == i2) {
            this.f34046d = (Integer) obj;
            synchronized (this) {
                this.l |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33778e);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f34048f = (Stories) obj;
            synchronized (this) {
                this.l |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        User user;
        FeedOfFeed feedOfFeed;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        Stories stories = this.f34048f;
        int i2 = ((24 & j2) > 0 ? 1 : ((24 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (stories != null) {
                user = stories.getUser();
                feedOfFeed = stories.getData();
            } else {
                feedOfFeed = null;
                user = null;
            }
            if (user != null) {
                str = user.getUserName();
                str2 = user.getUserImageUrl();
            } else {
                str2 = null;
                str = null;
            }
            str3 = feedOfFeed != null ? feedOfFeed.getImageUrl() : null;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if (i2 != 0) {
            net.one97.paytm.feed.utility.a.a(this.f34043a, str2, (String) null, (String) null);
            d.a(this.f34044b, (CharSequence) str);
            net.one97.paytm.feed.utility.a.a(this.f34045c, str3, (String) null, (String) null);
        }
        if ((j2 & 16) != 0) {
            this.j.setOnClickListener(this.k);
        }
    }

    public final void a(int i2, View view) {
        Integer num = this.f34047e;
        net.one97.paytm.feed.ui.feed.story.e eVar = this.f34049g;
        Integer num2 = this.f34046d;
        Stories stories = this.f34048f;
        if (eVar != null) {
            int intValue = num2.intValue();
            int intValue2 = num.intValue();
            k.c(view, "view");
            k.c(stories, "data");
            StoryViewActivity.a aVar = StoryViewActivity.f35179f;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            List<Stories> list = eVar.f35198a;
            if (list != null) {
                ArrayList arrayList = (ArrayList) list;
                k.c(context, "context");
                k.c(stories, "data");
                k.c(arrayList, "storyList");
                Intent intent = new Intent(context, StoryViewActivity.class);
                intent.putExtra("data", stories);
                intent.putExtra(CLPConstants.ARGUMENT_KEY_POSITION, intValue);
                intent.putExtra("storyCardPosition", intValue2);
                intent.putParcelableArrayListExtra("stories", arrayList);
                context.startActivity(intent);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories> /* = java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories> */");
        }
    }
}
