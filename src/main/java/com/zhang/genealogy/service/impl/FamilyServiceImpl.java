package com.zhang.genealogy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.genealogy.dao.FamilyDAO;
import com.zhang.genealogy.model.Family;
import com.zhang.genealogy.qb.FamilyQB;
import com.zhang.genealogy.service.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 家人服务层实现类
 */
@Service
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private FamilyDAO familyDAO;

    /**
     * 家人分页列表
     *
     * @param familyQB
     * @return
     */
    @Override
    public PageInfo<Family> queryPage(FamilyQB familyQB) {
        // 分页参数校验
        Integer pageNum = familyQB.getPageNum();
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        Integer pageSize = familyQB.getPageSize();
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        // 启用分页
        PageHelper.startPage(pageNum, pageSize);
        List<Family> familyList = familyDAO.queryList(familyQB);
        return null;
    }
}