package net.one97.paytm.o2o.movies.actor;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.o2o.movies.actor.holders.ActorBaseHolder;

public class CJRActorPageAdapter extends RecyclerView.a<ActorBaseHolder> {
    private Context context;
    private ActorItemFactory itemFactory;
    private List<ActorBaseItemData> itemList;
    private ActorPageClickListener listener;

    public interface ActorPageClickListener {
        void makeApiCallForMovieVideoCount(Long l);

        void onViewAllClick(int i2);
    }

    public CJRActorPageAdapter(List<ActorBaseItemData> list, Context context2, ActorPageClickListener actorPageClickListener) {
        this.itemList = list;
        this.context = context2;
        this.listener = actorPageClickListener;
    }

    public ActorBaseHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.itemFactory = new ActorItemFactory();
        return this.itemFactory.getViewHolder(i2, this.context, viewGroup, this.listener);
    }

    public void onBindViewHolder(ActorBaseHolder actorBaseHolder, int i2) {
        if (actorBaseHolder != null) {
            actorBaseHolder.setData(this.itemList.get(i2), this.context);
        }
    }

    public int getItemViewType(int i2) {
        return this.itemList.get(i2).templateId;
    }

    public int getItemCount() {
        List<ActorBaseItemData> list = this.itemList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
