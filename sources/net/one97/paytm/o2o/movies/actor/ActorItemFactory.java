package net.one97.paytm.o2o.movies.actor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.CJRActorPageAdapter;
import net.one97.paytm.o2o.movies.actor.holders.ActorBaseHolder;
import net.one97.paytm.o2o.movies.actor.holders.ActorIntroViewHolder;
import net.one97.paytm.o2o.movies.actor.holders.HorizontalListHolder;
import net.one97.paytm.o2o.movies.actor.holders.ViewDisclaimerHolder;

public class ActorItemFactory {
    public ActorBaseHolder getViewHolder(int i2, Context context, ViewGroup viewGroup, CJRActorPageAdapter.ActorPageClickListener actorPageClickListener) {
        if (i2 == 1) {
            return new ActorIntroViewHolder(LayoutInflater.from(context).inflate(R.layout.actor_intro_item_layout, viewGroup, false));
        }
        if (i2 == 2) {
            return new HorizontalListHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_list_layout, viewGroup, false), actorPageClickListener);
        }
        if (i2 != 3) {
            return null;
        }
        return new ViewDisclaimerHolder(LayoutInflater.from(context).inflate(R.layout.disclaimer_list_layout, viewGroup, false));
    }
}
