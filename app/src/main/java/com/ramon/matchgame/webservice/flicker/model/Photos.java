
package com.ramon.matchgame.webservice.flicker.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Photos {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("perpage")
    @Expose
    private Integer perpage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("page", page).append("pages", pages).append("perpage", perpage).append("total", total).append("photo", photo).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(page).append(pages).append(photo).append(perpage).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Photos) == false) {
            return false;
        }
        Photos rhs = ((Photos) other);
        return new EqualsBuilder().append(total, rhs.total).append(page, rhs.page).append(pages, rhs.pages).append(photo, rhs.photo).append(perpage, rhs.perpage).isEquals();
    }

}
