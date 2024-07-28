package net.one97.paytm.o2o.movies.entity;

import java.io.Serializable;
import kotlin.g.b.g;

public final class ComingSoonMovie implements Serializable {
    private boolean hasComingSoonMovie;
    private boolean isSelected;

    public ComingSoonMovie() {
        this(false, false, 3, (g) null);
    }

    public static /* synthetic */ ComingSoonMovie copy$default(ComingSoonMovie comingSoonMovie, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = comingSoonMovie.hasComingSoonMovie;
        }
        if ((i2 & 2) != 0) {
            z2 = comingSoonMovie.isSelected;
        }
        return comingSoonMovie.copy(z, z2);
    }

    public final boolean component1() {
        return this.hasComingSoonMovie;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    public final ComingSoonMovie copy(boolean z, boolean z2) {
        return new ComingSoonMovie(z, z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComingSoonMovie)) {
            return false;
        }
        ComingSoonMovie comingSoonMovie = (ComingSoonMovie) obj;
        return this.hasComingSoonMovie == comingSoonMovie.hasComingSoonMovie && this.isSelected == comingSoonMovie.isSelected;
    }

    public final int hashCode() {
        boolean z = this.hasComingSoonMovie;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.isSelected;
        if (!z3) {
            z2 = z3;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "ComingSoonMovie(hasComingSoonMovie=" + this.hasComingSoonMovie + ", isSelected=" + this.isSelected + ")";
    }

    public ComingSoonMovie(boolean z, boolean z2) {
        this.hasComingSoonMovie = z;
        this.isSelected = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComingSoonMovie(boolean z, boolean z2, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2);
    }

    public final boolean getHasComingSoonMovie() {
        return this.hasComingSoonMovie;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setHasComingSoonMovie(boolean z) {
        this.hasComingSoonMovie = z;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
