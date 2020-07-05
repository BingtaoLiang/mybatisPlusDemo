package com.southwind.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.mybatisplus.entity.User;
import com.southwind.mybatisplus.enums.AgeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.sql.Wrapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class UserMapperTest {

  @Autowired private UserMapper mapper;

  @Test
  void test() {
    mapper.selectList(null).forEach(System.out::println);
  }

  @Test
  void save() {
    User user = new User();
    user.setUsername("小张");
    //        user.setAge(22);
    mapper.insert(user);
  }

  @Test
  void update() {
//    User user = mapper.selectById(5);
//    user.setUsername("一号");

//    User user2 = mapper.selectById(5);
//    user2.setUsername("二号");
//    user2.setAge(AgeEnum.THREE);

//    mapper.updateById(user2);
//    mapper.updateById(user);


      User user = mapper.selectById(3);
      user.setUsername("张三丰");
      QueryWrapper wrapper = new QueryWrapper();
      wrapper.eq("age",22);
      mapper.update(user,wrapper);

  }

  @Test
  void delete() {
    mapper.deleteById(1);
  }

  @Test
  void select1() {
    // 不加任何条件全部查询
    //mapper.selectList(null);

      QueryWrapper wrapper=new QueryWrapper();
      wrapper.eq("name","李四");
      System.out.println(mapper.selectList(wrapper));
  }

    @Test
    void select2() {
      //多条件查询，使用map封装查询条件
        Map<String,Object> map=new HashMap<>();
        map.put("name", "李四");
        map.put("age", 21);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.allEq(map);


//        wrapper.lt("age",22);
//        wrapper.like("name","小");

        //like '%张'
//        wrapper.likeLeft("name","张");

        //like '张%'
//        wrapper.likeRight("name","李");

        //inSql 联合查询
//        wrapper.inSql("id","select id from user where id <5");
//        wrapper.inSql("age","select age from user where age >21");

//        wrapper.orderByAsc("age");
//        wrapper.having("id > 3");
//        wrapper.orderByDesc("age");

        mapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void select3(){
//      mapper.selectById(4); //通过单个Id查询
//        mapper.selectBatchIds(Arrays.asList(2,3,4)).forEach(System.out::println);       //查询多个id

        //ByMap只能做等值查询，逻辑判断只能使用wrapper
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",7);
//        mapper.selectByMap(map).forEach(System.out::println);

//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.ge("id",3);
//        mapper.selectCount(wrapper);


        //将查询的结果集封装到Map中，selectByMap是将查询的条件放在map中
//        mapper.selectMaps(wrapper).forEach(System.out::println);
//    System.out.println("-------------------------------------");
//    mapper.selectList(wrapper).forEach(System.out::println);


    //分页查询
//        Page<User> page=new Page<>(1,2);
//        Page<User> result = mapper.selectPage(page, null);
//    System.out.println(result.getSize());
//    System.out.println(result.getTotal());
//    result.getRecords().forEach(System.out::println);


//        Page<Map<String,Object>> page=new Page<>(1,2);
//        mapper.selectMapsPage(page,null).getRecords().forEach(System.out::println);

        //获取所有的主键
//        mapper.selectObjs(null).forEach(System.out::println);


        //返回的结果是单个时才能使用
        QueryWrapper wrapper =new QueryWrapper();
        wrapper.eq("id",5);
        System.out.println(mapper.selectOne(wrapper));
    }


    //自定义SQL也就是多表关联查询

    @Test
    void product(){
      mapper.productList(1).forEach(System.out::println);
    }

    //删除操作
    @Test
    void delete2(){
//      mapper.deleteById(1);

//      mapper.deleteBatchIds(Arrays.asList(5,6));

//      QueryWrapper wrapper =new QueryWrapper();
//      wrapper.eq("age",20);
//      mapper.delete(wrapper);

        Map<String,Object> map=new HashMap<>();
        map.put("id",4);
        mapper.deleteByMap(map);
    }


}
