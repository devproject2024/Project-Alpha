package net.one97.paytm.games.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import java.util.List;
import net.one97.paytm.games.R;
import net.one97.paytm.games.a.a.c;
import net.one97.paytm.games.model.pfg.Game;

public final class c extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public List<Game> f35446a;

    /* renamed from: b  reason: collision with root package name */
    public a f35447b;

    /* renamed from: c  reason: collision with root package name */
    private Context f35448c;

    public interface a {
        void a(Game game);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        Game game = this.f35446a.get(i2);
        if (game != null) {
            bVar.f35449a.setText(game.getGameName());
            String iconUrl = game.getIconUrl();
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f35448c);
            a2.f43753a = iconUrl;
            b.a.C0750a a3 = a2.a((Object) androidx.core.content.b.a(this.f35448c, R.drawable.img_defult_smallcard));
            a3.l = true;
            b.a.C0750a a4 = a3.a(8, b.a.ALL);
            a4.M = true;
            b.a.C0750a.a(a4.a(com.paytm.utility.b.b.a.AUTOMATIC), bVar.f35450b, (com.paytm.utility.b.b.b) null, 2);
        }
    }

    public c(Context context, List<Game> list) {
        this.f35448c = context;
        this.f35446a = list;
    }

    public final int getItemCount() {
        List<Game> list = this.f35446a;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f35446a.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f35449a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f35450b;

        /* renamed from: d  reason: collision with root package name */
        private ConstraintLayout f35452d;

        public b(View view) {
            super(view);
            this.f35452d = (ConstraintLayout) view.findViewById(R.id.root_layout);
            this.f35449a = (TextView) view.findViewById(R.id.text_game_name);
            this.f35450b = (ImageView) view.findViewById(R.id.image_game_icon);
            this.f35452d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    c.b.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != -1 && c.this.f35447b != null) {
                c.this.f35447b.a(c.this.f35446a.get(adapterPosition));
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f35448c).inflate(R.layout.item_recommend_layout, viewGroup, false));
    }
}
