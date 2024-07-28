package net.one97.paytm.o2o.movies.activity;

import net.one97.paytm.common.entity.movies.CJRMoviesCastCrewItem;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRMovieArtistDialog extends AJRBaseArtistDialog {
    /* access modifiers changed from: protected */
    public final void a() {
        CJRMoviesCastCrewItem cJRMoviesCastCrewItem = (CJRMoviesCastCrewItem) getIntent().getExtras().getSerializable("value");
        if (cJRMoviesCastCrewItem != null) {
            this.f73892a = cJRMoviesCastCrewItem.getName();
            this.f73893b = cJRMoviesCastCrewItem.getDescription();
            this.f73893b = n.a(this.f73893b);
            this.f73894c = cJRMoviesCastCrewItem.getImageUrl();
        }
    }
}
