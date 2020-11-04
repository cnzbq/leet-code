package cn.zbq.leet0406.reconstructqueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 根据身高重建队列测试
 *
 * @author zbq
 * @date 2020/11/4
 */
public class ReconstructQueueTest {
    private ReconstructQueue reconstructQueue;

    @Before
    public void before() {
        reconstructQueue = new ReconstructQueue();
    }

    @Test
    public void reconstructQueue() {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = reconstructQueue.reconstructQueue(people);
        int[][] ans = {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
        for (int i = 0; i < ans.length; i++) {
            Assert.assertArrayEquals(ans[i], result[i]);
        }
    }
}