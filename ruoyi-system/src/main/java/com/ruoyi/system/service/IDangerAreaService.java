package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DangerArea;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public interface IDangerAreaService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public DangerArea selectDangerAreaById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param dangerArea 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DangerArea> selectDangerAreaList(DangerArea dangerArea);

    /**
     * 新增【请填写功能名称】
     * 
     * @param dangerArea 【请填写功能名称】
     * @return 结果
     */
    public int insertDangerArea(DangerArea dangerArea);

    /**
     * 修改【请填写功能名称】
     * 
     * @param dangerArea 【请填写功能名称】
     * @return 结果
     */
    public int updateDangerArea(DangerArea dangerArea);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDangerAreaByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteDangerAreaById(Long id);
}
