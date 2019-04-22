
package com.ramon.matchgame.webservice.flicker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ImageSizeResult {

    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sizes", sizes).append("stat", stat).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sizes).append(stat).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ImageSizeResult) == false) {
            return false;
        }
        ImageSizeResult rhs = ((ImageSizeResult) other);
        return new EqualsBuilder().append(sizes, rhs.sizes).append(stat, rhs.stat).isEquals();
    }

}
