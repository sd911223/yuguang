package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DangerAreaMapper;
import com.ruoyi.system.domain.DangerArea;
import com.ruoyi.system.service.IDangerAreaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
@Service
public class DangerAreaServiceImpl implements IDangerAreaService 
{
    @Autowired
    private DangerAreaMapper dangerAreaMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public DangerArea selectDangerAreaById(Long id)
    {
        return dangerAreaMapper.selectDangerAreaById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param dangerArea 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DangerArea> selectDangerAreaList(DangerArea dangerArea)
    {
        return dangerAreaMapper.selectDangerAreaList(dangerArea);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param dangerArea 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDangerArea(DangerArea dangerArea)
    {
        dangerArea.setCreateTime(DateUtils.getNowDate());
        return dangerAreaMapper.insertDangerArea(dangerArea);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param dangerArea 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDangerArea(DangerArea dangerArea)
    {
        return dangerAreaMapper.updateDangerArea(dangerArea);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDangerAreaByIds(String ids)
    {
        return dangerAreaMapper.deleteDangerAreaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteDangerAreaById(Long id)
    {
        return dangerAreaMapper.deleteDangerAreaById(id);
    }
}
