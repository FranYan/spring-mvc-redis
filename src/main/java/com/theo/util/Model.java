package com.theo.util;

import com.theo.enums.YesOrNo;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共字段
 */
public class Model implements Serializable {

    // id
    private Long id;

    // 创建时间
    private Date createDate;

    // 是否删除 仅为YesOrNo.YES时处于被删除状态
    private YesOrNo isDeleted;

    // 删除时间
    private Date deletedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public YesOrNo getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(YesOrNo isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }
}
