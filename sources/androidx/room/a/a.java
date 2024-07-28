package androidx.room.a;

import androidx.sqlite.db.b;

public abstract class a {
    public final int endVersion;
    public final int startVersion;

    public abstract void migrate(b bVar);

    public a(int i2, int i3) {
        this.startVersion = i2;
        this.endVersion = i3;
    }
}
