package com.atguigu.sbootweb02;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@DisplayName("junit5注解测试类")
public class Junit5Test {

    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testAssumptions() {
        Assumptions.assumeTrue(false, "结果不是true");
        System.out.println("111111");
    }

    /**
     * 断言：前面断言失败，后面的就不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(3, 3);

        assertEquals(5, cal, "业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2, "两个对象不一样");
    }

    @Test
    @DisplayName("数组断言测试")
    void array() {
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数组内容不相等");
    }

    @Test
    @DisplayName("组合断言")
    void all() {
        /**
         * 所有断言都需要成功
         */
        assertAll("test",
                () -> assertTrue(true && true, "结果不为true"),
                () -> assertEquals(1, 1, "结果不是1"));
        System.out.println("===================");
    }

    @DisplayName("异常断言")
    @Test
    void testException() {
        assertThrows(ArithmeticException.class,
                () -> {
                    int i = 10 / 0;
                },
                "业务逻辑居然正常运行？");
    }

    @DisplayName("快速失败")
    @Test
    void testFail() {
        if (2 == 2) {
            fail("测试失败");
        }
    }

    int cal(int i, int j) {
        return i + j;
    }

    @DisplayName(("测试displayName注解1"))
    @Test
    void testDisplayName() {
        System.out.println(1);
    }

    @Disabled //禁用测试
    @DisplayName(("测试displayName注解2"))
    @Test
    void test2() {
        System.out.println(2);
    }

    /**
     * RepeatedTest：重复测试x次
     */
    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println(5);
    }

    /**
     * 规定时间超时时间，运行超时会报错
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(500);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了……");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试就要结束了……");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了……");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试就要结束了……");
    }
}
