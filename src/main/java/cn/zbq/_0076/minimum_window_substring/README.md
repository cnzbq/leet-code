# 76. 最小覆盖子串

## 题目
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：
```
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
```

示例 2：
```
输入：s = "a", t = "a"
输出："a"
```

提示：
- 1 <= s.length, t.length <= 105
- s 和 t 由英文字母组成

进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

## 思路
- 通过一个HashMap记录要`t`字符串中所有字符出现的频率
- 使用左右两个指针形成一个滑动窗口，初始值均为0，方向均为左—>右滑动
- 右指针先开始向右滑动，出现的字符是t中的时，使用变量`distances+1`标记所需字符已出现一次
- 当`distances`等于`t`的长度时，左指针开始向右移动，出现的字符是t中的时，`distances-1`表示所需字符减少

遍历中还需要考虑所需字符多次重复出现时`distances`值的处理

我们可以用滑动窗口的思想解决这个问题，在滑动窗口类型的问题中都会有两个指针。一个用于「延伸」现有窗口的 r 指针，和一个用于「收缩」窗口的 l 指针。在任意时刻，只有一个指针运动，而另一个保持静止。我们在 s 上滑动窗口，通过移动 r 指针不断扩张窗口。当窗口包含 t 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
![演示](76_fig1.gif)