package com.zhang.genealogy.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 家人类
 *
 * @author zhangchao
 * @date 2019-01-29
 */
@Getter
@Setter
public class Personnel {


    /**
     * 主键自增
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称，诨名
     */
    private String nickName;

    /**
     * 字
     */
    private String zi;

    /**
     * 辈分
     */
    private String bei;

    /**
     * 性别：0-女、1-男
     */
    private Integer gender;

    /**
     * 父母ID
     */
    private Long parentId;

    /**
     * 配偶ID
     */
    private Long coupleId;

    /**
     * 世代
     */
    private Integer generation;

    /**
     * 排行
     */
    private Integer ranking;

    /**
     * 是否在世：0-在世；1-去世
     */
    private Integer isLiving;
    /**
     * 出生日期
     */
    private String birthDate;

    /**
     * 死亡日期
     */
    private String deathDate;

    /**
     * 学位
     */
    private Integer degree;

    /**
     * 毕业学校
     */
    private String university;

    /**
     * 工作职务
     */
    private String work;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 头像URL
     */
    private String imageUrl;

    /**
     * 删除状态：0-未删除；1-删除
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}