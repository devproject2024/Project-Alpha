package net.one97.paytm.contacts.entities.db_entities;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Configuration implements IJRDataModel {
    private Boolean fallbackEnabled;
    private long id;
    private long timestamp;
    private Integer type;

    public static /* synthetic */ Configuration copy$default(Configuration configuration, long j, long j2, Integer num, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = configuration.id;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = configuration.timestamp;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            num = configuration.type;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            bool = configuration.fallbackEnabled;
        }
        return configuration.copy(j3, j4, num2, bool);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Integer component3() {
        return this.type;
    }

    public final Boolean component4() {
        return this.fallbackEnabled;
    }

    public final Configuration copy(long j, long j2, Integer num, Boolean bool) {
        return new Configuration(j, j2, num, bool);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Configuration) {
                Configuration configuration = (Configuration) obj;
                if (this.id == configuration.id) {
                    if (!(this.timestamp == configuration.timestamp) || !k.a((Object) this.type, (Object) configuration.type) || !k.a((Object) this.fallbackEnabled, (Object) configuration.fallbackEnabled)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.id;
        long j2 = this.timestamp;
        int i2 = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Integer num = this.type;
        int i3 = 0;
        int hashCode = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.fallbackEnabled;
        if (bool != null) {
            i3 = bool.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "Configuration(id=" + this.id + ", timestamp=" + this.timestamp + ", type=" + this.type + ", fallbackEnabled=" + this.fallbackEnabled + ")";
    }

    public Configuration(long j, long j2, Integer num, Boolean bool) {
        this.id = j;
        this.timestamp = j2;
        this.type = num;
        this.fallbackEnabled = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Configuration(long j, long j2, Integer num, Boolean bool, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : j, j2, num, bool);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final Boolean getFallbackEnabled() {
        return this.fallbackEnabled;
    }

    public final void setFallbackEnabled(Boolean bool) {
        this.fallbackEnabled = bool;
    }
}
