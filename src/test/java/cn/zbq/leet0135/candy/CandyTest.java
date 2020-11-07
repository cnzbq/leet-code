package cn.zbq.leet0135.candy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 135. 分发糖果
 *
 * @author zbq
 * @date 2020/11/7
 */
public class CandyTest {
    private final Candy candy = new Candy();

    @Test
    public void case1() {
        int result = this.candy.candy(new int[]{1, 0, 2});
        Assert.assertEquals(5, result);
    }

    @Test
    public void case2() {
        int result = this.candy.candy(new int[]{1, 2, 2});
        Assert.assertEquals(4, result);
    }

    @Test
    public void case3() {
        int result = this.candy.candy(new int[]{1, 2, 87, 87, 87, 2, 1});
        Assert.assertEquals(13, result);
    }

    @Test
    public void case4() {
        int result = this.candy.candy(new int[]{1, 3, 2, 2, 1});
        Assert.assertEquals(7, result);
    }

    @Test
    public void case5() {
        int result = this.candy.candy(new int[]{3, 3, 3});
        Assert.assertEquals(3, result);
    }
}