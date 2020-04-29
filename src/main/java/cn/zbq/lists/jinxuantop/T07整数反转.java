package cn.zbq.lists.jinxuantop;

/**
 * 整数反转
 */
public class T07整数反转 {

    // 暴力求解
    public static int reverse(int x) {

        int oldNum = x;
        int newNum = 0;

        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        // 计算长度
        int len = String.valueOf(x).length();
        // 若小于0，长度减1，去掉符号位
        if (x < 0) {
            len--;
        }

        for (int i = 0; i < len; i++) {
            int a = oldNum % 10;

            int temp = newNum + a;
            // 范围判断
            if (temp < max && temp > min) {
                newNum = newNum * 10 + a;
                oldNum = oldNum / 10;

            } else {
                return 0;
            }
        }

        return newNum;
    }

    public static int reverse2(int x) {
        // 正负标志
        boolean flag = false;
        int max = Integer.MAX_VALUE / 10;
        int maxEnd = Integer.MAX_VALUE % 10;
        int min = Integer.MIN_VALUE / 10;
        int minEnd = Integer.MIN_VALUE % 10;
        // 计算长度
        int len = String.valueOf(x).length();
        // 若小于0，长度减1，去掉符号位
        if (x < 0) {
            len--;
            flag = true;
        }

        String s = new StringBuilder().append(x).reverse().toString().replace("-", "");
        if (len <= 9) {
            return flag ? -Integer.parseInt(s) : Integer.parseInt(s);

        } else {
            String s1 = s.substring(0, 9);
            String s2 = s.substring(9);
            int newNum = flag ? -Integer.parseInt(s1) : Integer.parseInt(s1);
            int oldNum = flag ? -Integer.parseInt(s2) : Integer.parseInt(s2);

            int length = s2.length();
            for (int i = 0; i < length; i++) {
                int a = oldNum % 10;
                // 范围判断
                if ((newNum < max && newNum > min) || (newNum == max && a <= maxEnd) || (newNum == min && a >= minEnd)) {
                    newNum = newNum * 10 + a;
                    oldNum = oldNum / 10;

                } else {
                    return 0;
                }
            }

            return newNum;
        }
    }

    // 官方解法优化
    public static int reverse3(int x) {
        int max = Integer.MAX_VALUE / 10;
        int maxEnd = Integer.MAX_VALUE % 10;
        int min = Integer.MIN_VALUE / 10;
        int minEnd = Integer.MIN_VALUE % 10;
        int newNum = 0;

        while (x != 0) {
            int a = x % 10;
            if (((newNum < max && newNum > min) || (newNum == max && a < maxEnd) || (newNum == min && a > minEnd))) {
                newNum = newNum * 10 + a;
            } else {
                return 0;

            }
            x = x / 10;
        }

        return newNum;
    }

    public static void main(String[] args) {
        //        System.out.println(Integer.MAX_VALUE);
//        System.out.println(reverse(Integer.MAX_VALUE));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(reverse(Integer.MIN_VALUE));
//        System.out.println(reverse(-120));
//        System.out.println(reverse(0));
//        System.out.println(reverse(1));
//        System.out.println(reverse(520));
//        System.out.println(reverse(502));
//        System.out.println(reverse(102123457));
//        System.out.println(reverse(1463847412));
//        System.out.println(reverse(-1463847412));
        System.out.println(reverse(1534236469));
    }
}
