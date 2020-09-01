package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DepartureLocationMapper;
import com.ruoyi.system.domain.DepartureLocation;
import com.ruoyi.system.service.IDepartureLocationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Service
public class DepartureLocationServiceImpl implements IDepartureLocationService 
{
    @Autowired
    private DepartureLocationMapper departureLocationMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public DepartureLocation selectDepartureLocationById(Long id)
    {
        return departureLocationMapper.selectDepartureLocationById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param departureLocation 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DepartureLocation> selectDepartureLocationList(DepartureLocation departureLocation)
    {
        return departureLocationMapper.selectDepartureLocationList(departureLocation);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param departureLocation 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDepartureLocation(DepartureLocation departureLocation)
    {
        departureLocation.setCreateTime(DateUtils.getNowDate());
        return departureLocationMapper.insertDepartureLocation(departureLocation);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param departureLocation 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDepartureLocation(DepartureLocation departureLocation)
    {
        return departureLocationMapper.updateDepartureLocation(departureLocation);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDepartureLocationByIds(String ids)
    {
        return departureLocationMapper.deleteDepartureLocationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteDepartureLocationById(Long id)
    {
        return departureLocationMapper.deleteDepartureLocationById(id);
    }
}
