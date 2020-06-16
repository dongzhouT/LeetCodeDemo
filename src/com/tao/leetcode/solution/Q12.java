package com.tao.leetcode.solution;

/**
 * 12. 整数转罗马数字
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q12 {
    public static String intToRoman(int num) {
        String[] one=new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] two=new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] thr=new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] fou=new String[]{"","M","MM","MMM"};
        return fou[num/1000]+thr[num%1000/100]+two[num%100/10]+one[num%10];

    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
