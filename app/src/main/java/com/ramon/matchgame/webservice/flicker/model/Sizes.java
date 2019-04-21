
package com.ramon.matchgame.webservice.flicker.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Sizes {

    @SerializedName("canblog")
    @Expose
    private Integer canblog;
    @SerializedName("canprint")
    @Expose
    private Integer canprint;
    @SerializedName("candownload")
    @Expose
    private Integer candownload;
    @SerializedName("size")
    @Expose
    private List<Size> size = null;

    public Integer getCanblog() {
        return canblog;
    }

    public void setCanblog(Integer canblog) {
        this.canblog = canblog;
    }

    public Integer getCanprint() {
        return canprint;
    }

    public void setCanprint(Integer canprint) {
        this.canprint = canprint;
    }

    public Integer getCandownload() {
        return candownload;
    }

    public void setCandownload(Integer candownload) {
        this.candownload = candownload;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("canblog", canblog).append("canprint", canprint).append("candownload", candownload).append("size", size).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(candownload).append(canblog).append(canprint).append(size).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sizes) == false) {
            return false;
        }
        Sizes rhs = ((Sizes) other);
        return new EqualsBuilder().append(candownload, rhs.candownload).append(canblog, rhs.canblog).append(canprint, rhs.canprint).append(size, rhs.size).isEquals();
    }

}
