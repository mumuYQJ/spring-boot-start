package com.csdj.springbootvue.mapper;

import com.csdj.springbootvue.pojo.Consumption;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 袁绮骏
* @description 针对表【consumption(消费表)】的数据库操作Mapper
* @createDate 2024-05-31 14:24:06
* @Entity com.csdj.springbootvue.pojo.Consumption
*/
public interface ConsumptionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Consumption record);

    int insertSelective(Consumption record);

    Consumption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Consumption record);

    int updateByPrimaryKey(Consumption record);

    @Select("select * from consumption")
    List<Consumption> list();

}
