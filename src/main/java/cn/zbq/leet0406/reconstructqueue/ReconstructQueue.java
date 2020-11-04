package cn.zbq.leet0406.reconstructqueue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 根据身高重建队列
 *
 * @author zbq
 * @date 2020/11/4
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        // java.util.Comparator.compare(a,b) a - b 代表从小到大，b - a代表从大到小
        // 身高相等，按照个数升序，否则按照身高降序
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        // 到这里，总体数据身高是降序，个数是升序
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            // （h,k）
            // 如果k与当前列表大小相等，则直接在链表尾部追加h
            // 如果k与当前列表大小不相等，则在k对应的index位置前插入h（同一行数据，身高大的在前，插入身高矮的h不会影响到身高高的k值）
            // add(int index, E element) index = size，在链表尾部追加element，否则在index位置前插入element
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][2]);
    }
}
