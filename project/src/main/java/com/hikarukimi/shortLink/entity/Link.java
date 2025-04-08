package com.hikarukimi.shortLink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import main.java.com.hikarukimi.shortLink.entity.Base;

/**
 * 
 * @TableName link
 */
@TableName(value ="link")
@Data
public class Link extends Base implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 域名
     */
    private String domain;

    /**
     * 短链接
     */
    private String shortUri;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 点击量
     */
    private Integer clickNum;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 网站图标
     */
    private String favicon;

    /**
     * 启用标识 0：启用 1：未启用
     */
    private Integer enableStatus;

    /**
     * 创建类型 0：接口创建 1：控制台创建
     */
    private Integer createdType;

    /**
     * 有效期类型 0：永久有效 1：自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    private Date validDate;

    /**
     * 描述
     */
    private String describe;

    /**
     * 历史PV
     */
    private Integer totalPv;

    /**
     * 历史UV
     */
    private Integer totalUv;

    /**
     * 历史UIP
     */
    private Integer totalUip;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除时间戳
     */
    private Long delTime;

    /**
     * 删除标识 0：未删除 1：已删除
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Link other = (Link) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDomain() == null ? other.getDomain() == null : this.getDomain().equals(other.getDomain()))
            && (this.getShortUri() == null ? other.getShortUri() == null : this.getShortUri().equals(other.getShortUri()))
            && (this.getFullShortUrl() == null ? other.getFullShortUrl() == null : this.getFullShortUrl().equals(other.getFullShortUrl()))
            && (this.getOriginUrl() == null ? other.getOriginUrl() == null : this.getOriginUrl().equals(other.getOriginUrl()))
            && (this.getClickNum() == null ? other.getClickNum() == null : this.getClickNum().equals(other.getClickNum()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getFavicon() == null ? other.getFavicon() == null : this.getFavicon().equals(other.getFavicon()))
            && (this.getEnableStatus() == null ? other.getEnableStatus() == null : this.getEnableStatus().equals(other.getEnableStatus()))
            && (this.getCreatedType() == null ? other.getCreatedType() == null : this.getCreatedType().equals(other.getCreatedType()))
            && (this.getValidDateType() == null ? other.getValidDateType() == null : this.getValidDateType().equals(other.getValidDateType()))
            && (this.getValidDate() == null ? other.getValidDate() == null : this.getValidDate().equals(other.getValidDate()))
            && (this.getDescribe() == null ? other.getDescribe() == null : this.getDescribe().equals(other.getDescribe()))
            && (this.getTotalPv() == null ? other.getTotalPv() == null : this.getTotalPv().equals(other.getTotalPv()))
            && (this.getTotalUv() == null ? other.getTotalUv() == null : this.getTotalUv().equals(other.getTotalUv()))
            && (this.getTotalUip() == null ? other.getTotalUip() == null : this.getTotalUip().equals(other.getTotalUip()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelTime() == null ? other.getDelTime() == null : this.getDelTime().equals(other.getDelTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDomain() == null) ? 0 : getDomain().hashCode());
        result = prime * result + ((getShortUri() == null) ? 0 : getShortUri().hashCode());
        result = prime * result + ((getFullShortUrl() == null) ? 0 : getFullShortUrl().hashCode());
        result = prime * result + ((getOriginUrl() == null) ? 0 : getOriginUrl().hashCode());
        result = prime * result + ((getClickNum() == null) ? 0 : getClickNum().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getFavicon() == null) ? 0 : getFavicon().hashCode());
        result = prime * result + ((getEnableStatus() == null) ? 0 : getEnableStatus().hashCode());
        result = prime * result + ((getCreatedType() == null) ? 0 : getCreatedType().hashCode());
        result = prime * result + ((getValidDateType() == null) ? 0 : getValidDateType().hashCode());
        result = prime * result + ((getValidDate() == null) ? 0 : getValidDate().hashCode());
        result = prime * result + ((getDescribe() == null) ? 0 : getDescribe().hashCode());
        result = prime * result + ((getTotalPv() == null) ? 0 : getTotalPv().hashCode());
        result = prime * result + ((getTotalUv() == null) ? 0 : getTotalUv().hashCode());
        result = prime * result + ((getTotalUip() == null) ? 0 : getTotalUip().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelTime() == null) ? 0 : getDelTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", domain=").append(domain);
        sb.append(", shortUri=").append(shortUri);
        sb.append(", fullShortUrl=").append(fullShortUrl);
        sb.append(", originUrl=").append(originUrl);
        sb.append(", clickNum=").append(clickNum);
        sb.append(", gid=").append(gid);
        sb.append(", favicon=").append(favicon);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", createdType=").append(createdType);
        sb.append(", validDateType=").append(validDateType);
        sb.append(", validDate=").append(validDate);
        sb.append(", describe=").append(describe);
        sb.append(", totalPv=").append(totalPv);
        sb.append(", totalUv=").append(totalUv);
        sb.append(", totalUip=").append(totalUip);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delTime=").append(delTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}