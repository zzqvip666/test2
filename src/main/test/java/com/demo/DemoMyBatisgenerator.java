package com.demo;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.pojo.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class DemoMyBatisgenerator {

    @Autowired
    private UserMapper userMapper;


    /**
     * *
     *    自定义条件查询个数; long countByExample(UserExample example);
     */
    @Test
    public  void  run1(){
        UserExample example=new UserExample();

        UserExample.Criteria criteria = example.createCriteria();

        //criteria.andUnameLike("%%");//条件
        criteria.andUidGreaterThan(2);
       // long count = userMapper.countByExample(null);//查寻所有个数

        long count = userMapper.countByExample(example);
        System.out.println(count);
    }

    /**
     *   自定义条件删除 int deleteByExample(UserExample example);
     */
    @Test
    public  void  run2(){
        UserExample example=new UserExample();

        example.createCriteria().andUidGreaterThan(15);
        long count = userMapper.deleteByExample(example);
        System.out.println(count);
    }
    /**
     *    int deleteByPrimaryKey(Integer uid);
     */
    @Test
    public  void  run3(){

        long count = userMapper.deleteByPrimaryKey(2039);
        System.out.println(count);
    }
    /**
     * 插入一条数据  int insert(User record);
     */
    @Test
    public  void  run4(){

        User user=new User();
        user.setUname("天地决杀 魑魅魍魉");
        long count = userMapper.insert(user);
        System.out.println(count);
    }
    /**
     *  插入一条数据：（null的字段不进行插入） int insertSelective(User record);
     */
    @Test
    public  void  run5(){

        User user=new User();
        user.setUname("天字");
        long count = userMapper.insertSelective(user);
        System.out.println(count);
    }

    /**
     * 第一个参数是要更新的数据
     * 第二个参数自定义条件查寻
     * 根据自定义条件进行更新  int updateByExample(@Param("record") User record, @Param("example") UserExample example);
     */
    @Test
    public  void  run6(){
        UserExample example=new UserExample();

        example.createCriteria().andUidEqualTo(2041);

        User user=new User();
        user.setUid(2041);
        user.setUpwd("ssssssssssssss");
        long count = userMapper.updateByExample(user,example);
        System.out.println(count);
    }

    /**
     *    int updateByPrimaryKey(User record);
     */
    @Test
    public  void  run7(){

        User user=new User();
        user.setUid(2041);
        user.setUpwd("aaaaaaaaaaaaaa");
        user.setUname("ffffffffffffffff");
        long count = userMapper.updateByPrimaryKey(user);
        System.out.println(count);
    }

    /**
     *   根据主键进行更新：（为null的不更新）  int updateByPrimaryKeySelective(User record);
     */
    @Test
    public  void  run8(){

        User user=new User();
        user.setUid(2041);
        user.setUpwd("bbbbbbbbbbb");
        long count = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(count);
    }
}
