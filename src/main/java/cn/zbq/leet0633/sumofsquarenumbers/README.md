# 633. 平方数之和

## 题目
 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a^2 + b^2 = c 。
 
 示例 1：
 ```
 输入：c = 5
 输出：true
 解释：1 * 1 + 2 * 2 = 5
 ```
 示例 2：
 ```
 输入：c = 3
 输出：false
 ```
 示例 3：
 ```
 输入：c = 4
 输出：true
 ```
 示例 4：
 ```
 输入：c = 2
 输出：true
 ```
 示例 5： 
 ```
 输入：c = 1
 输出：true
 ```
 提示：
 
 `0 <= c <= 2^31 - 1`

## 思路
- 判断题意，依次计算 low * low + high * high 和 c 是否相等。从 [0, sqrt(n)] 区间内进行二分，若能找到则返回 true，找不到就返回 false
- 所谓二分，也可以理解为 [167. 两数之和 II](src/main/java/cn/zbq/leet0167/twosumiiinputarrayissorted/README.md)中的两个指针