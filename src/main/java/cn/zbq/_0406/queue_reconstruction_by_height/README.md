# 406. 根据身高重建队列

## 题目
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例
<pre>
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
</pre>

## 思路
-> **必备知识** ：Comparator、LinkedList
- 根据题意，可以得出个子矮的人实际对于个子高的人是不可见的，也就是个子矮的人站到个子高的前面对个子高的人的k值是不会产生影响的
- 将给定的输入数组按照身高降序，个数升序的原则进行排序，得到的数组第一列（身高）由高到低，第二列（个数）由小到大

|  h   | k  |
|  ----  | ----  |
| 5  | 0 |
| 7  | 0 |
| ...|
- 借助LinkedList#add(int index, E element)方法对排好序的数组逐行插入
<pre>
public void add(int index, E element) {
    checkPositionIndex(index);
    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));
}
</pre>
- 最后将list转为数组即可