
package com.ramon.matchgame.webservice.flicker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class FlikerResults {

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("photos", photos).append("stat", stat).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(photos).append(stat).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlikerResults) == false) {
            return false;
        }
        FlikerResults rhs = ((FlikerResults) other);
        return new EqualsBuilder().append(photos, rhs.photos).append(stat, rhs.stat).isEquals();
    }

}
