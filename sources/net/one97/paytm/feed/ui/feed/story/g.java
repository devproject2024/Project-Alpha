package net.one97.paytm.feed.ui.feed.story;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.ui.feed.story.f;

public final class g extends o {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Stories> f35218a;

    /* renamed from: b  reason: collision with root package name */
    private j f35219b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(ArrayList<Stories> arrayList, j jVar) {
        super(jVar, 1);
        k.c(arrayList, "stories");
        k.c(jVar, "fm");
        this.f35218a = arrayList;
        this.f35219b = jVar;
    }

    public final Fragment getItem(int i2) {
        Stories stories = this.f35218a.get(i2);
        k.a((Object) stories, "stories[position]");
        Stories stories2 = stories;
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", stories2);
        bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
        f.a aVar = f.l;
        k.c(stories2.getStoryId(), "tag");
        f fVar = new f();
        fVar.setArguments(bundle);
        return fVar;
    }

    public final int getCount() {
        return this.f35218a.size();
    }
}
