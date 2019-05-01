package com.mj.mall.member.service.impl;

import com.mj.mall.member.MJMallMemberTest;
import com.mj.mall.member.service.MemberApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemberApp.class)
@WebAppConfiguration
@ContextConfiguration
public class MemberServiceImplTest extends MJMallMemberTest {

    final static Logger logger = LoggerFactory.getLogger(MemberServiceImplTest.class);

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        logger.info("setUp()");
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @After
    public void tearDown() throws Exception {
        logger.info("tearDown()");
    }

    @Test
    public void findUserById() throws Exception {
        RequestBuilder request = null;
        //路径
        request = get("/member/findUserById")
                //参数
                .param("userId", "37")
                //接受的数据类型
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                //状态吗是否相等
                .andExpect(status().isOk())
                //得到的信息是否与特定字段匹配
                .andExpect(content().string("{\"code\":200,\"msg\":\"success\",\"data\":{\"id\":37,\"username\":\"sheliming\",\"password\":\"e10adc3949ba59abbe56e057f20f883e\",\"phone\":\"123456789\",\"email\":\"aaa@qq.com\",\"createTime\":null,\"updateTime\":null,\"openId\":null}}"))
                //输出信息
                .andDo(print());
    }

    @Test
    public void register() {
    }

    @Test
    public void login() {
    }

    @Test
    public void findByTokenUser() {
    }

    @Override
    public void createTables() {
        logger.info("createTables()");
    }

    @Override
    protected void insertTables() {
        logger.info("insertTables()");
    }
}