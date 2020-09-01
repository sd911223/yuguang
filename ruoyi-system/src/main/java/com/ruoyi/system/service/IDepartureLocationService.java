package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DepartureLocation;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public interface IDepartureLocationService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public DepartureLocation selectDepartureLocationById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param departureLocation 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DepartureLocation> selectDepartureLocationList(DepartureLocation departureLocation);

    /**
     * 新增【请填写功能名称】
     * 
     * @param departureLocation 【请填写功能名称】
     * @return 结果
     */
    public int insertDepartureLocation(DepartureLocation departureLocation);

    /**
     * 修改【请填写功能名称】
     * 
     * @param departureLocation 【请填写功能名称】
     * @return 结果
     */
    public int updateDepartureLocation(DepartureLocation departureLocation);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDepartureLocationByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteDepartureLocationById(Long id);
}
