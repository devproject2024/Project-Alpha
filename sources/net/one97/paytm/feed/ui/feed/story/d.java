package net.one97.paytm.feed.ui.feed.story;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.cg;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.repository.models.stories.StoryData;

public final class d extends RecyclerView.a<h<cg, ? super Stories>> {

    /* renamed from: a  reason: collision with root package name */
    public StoryData f35195a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f35196b = -1;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Stories> f35197c = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        h hVar = (h) vVar;
        k.c(hVar, "holder");
        Stories stories = this.f35197c.get(i2);
        k.a((Object) stories, "result[position]");
        Stories stories2 = stories;
        StoryData storyData = this.f35195a;
        Integer num = this.f35196b;
        k.c(stories2, "data");
        B b2 = hVar.f35220a;
        b2.setVariable(a.f33780g, stories2);
        b2.setVariable(a.f33778e, Integer.valueOf(i2));
        b2.setVariable(a.p, num);
        if (storyData == null) {
            k.a();
        }
        hVar.f35221b = new e(storyData.getStoryList());
        b2.setVariable(a.f33775b, hVar.f35221b);
        hVar.f35220a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_story_item, viewGroup, false);
        k.a((Object) inflate, "view");
        return new h(inflate);
    }

    public final int getItemCount() {
        return this.f35197c.size();
    }
}
