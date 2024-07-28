package net.one97.paytm.o2o.movies.actor.holders;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.ActorBaseItemData;
import net.one97.paytm.o2o.movies.actor.CJRActorPageAdapter;
import net.one97.paytm.o2o.movies.adapter.h;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.utils.n;

public class HorizontalListHolder extends ActorBaseHolder implements h.a {
    private View divider;
    private View itemView;
    private RecyclerView listRv;
    private CJRActorPageAdapter.ActorPageClickListener listener;
    private TextView titleTv;
    private TextView viewAllTv;

    public HorizontalListHolder(View view, CJRActorPageAdapter.ActorPageClickListener actorPageClickListener) {
        super(view);
        this.itemView = view;
        this.listRv = (RecyclerView) view.findViewById(R.id.listRv);
        this.titleTv = (TextView) view.findViewById(R.id.titleTv);
        this.viewAllTv = (TextView) view.findViewById(R.id.viewAllTv);
        this.divider = view.findViewById(R.id.divider);
        this.listener = actorPageClickListener;
    }

    public void setData(ActorBaseItemData actorBaseItemData, Context context) {
        if (actorBaseItemData != null && actorBaseItemData.elementData != null) {
            n.a(actorBaseItemData.showDivider, this.divider);
            if (2 == actorBaseItemData.elementData.templateId) {
                int size = actorBaseItemData.elementData.movies.size();
                TextView textView = this.titleTv;
                textView.setText("Filmography (" + size + ")");
                if (size > 5) {
                    this.viewAllTv.setVisibility(0);
                    this.viewAllTv.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            HorizontalListHolder.this.lambda$setData$0$HorizontalListHolder(view);
                        }
                    });
                } else {
                    this.viewAllTv.setVisibility(8);
                }
            } else {
                if (3 == actorBaseItemData.elementData.templateId) {
                    this.titleTv.setText("Trending Stories");
                } else if (!d.a((List) actorBaseItemData.elementData.videos)) {
                    int size2 = actorBaseItemData.elementData.videos.size();
                    TextView textView2 = this.titleTv;
                    textView2.setText("Videos (" + size2 + ")");
                    if (size2 > 5) {
                        this.viewAllTv.setVisibility(0);
                        this.viewAllTv.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                HorizontalListHolder.this.lambda$setData$1$HorizontalListHolder(view);
                            }
                        });
                    }
                }
                this.viewAllTv.setVisibility(8);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(0);
            this.listRv.setLayoutManager(linearLayoutManager);
            this.listRv.setAdapter(new h(context, this, actorBaseItemData.elementData));
            addItemDecoratorToVideoRecyclerView(context);
        }
    }

    public /* synthetic */ void lambda$setData$0$HorizontalListHolder(View view) {
        this.listener.onViewAllClick(2);
    }

    public /* synthetic */ void lambda$setData$1$HorizontalListHolder(View view) {
        this.listener.onViewAllClick(1);
    }

    private void addItemDecoratorToVideoRecyclerView(final Context context) {
        if (this.listRv.getItemDecorationCount() == 0) {
            this.listRv.addItemDecoration(new RecyclerView.h() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    super.getItemOffsets(rect, view, recyclerView, sVar);
                    if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                        rect.left = n.a(20, context);
                    }
                    rect.right = n.a(12, context);
                }
            });
        }
    }

    public void makeApiCallForMovieVideoCount(Long l) {
        this.listener.makeApiCallForMovieVideoCount(l);
    }
}
