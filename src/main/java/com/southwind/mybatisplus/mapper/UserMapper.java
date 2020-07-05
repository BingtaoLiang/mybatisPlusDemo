package com.southwind.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.southwind.mybatisplus.entity.ProductVO;
import com.southwind.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {


    @Select("select  p.*,u.name  userName from user u,product p where p.user_id=u.id and u.id=#{id}")
    List<ProductVO> productList(Integer id);
}
