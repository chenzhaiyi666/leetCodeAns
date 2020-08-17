package com.chen.leet.ans.normal;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//字符串转换整数 (atoi)
public class Ques53 {

    public static int myAtoi(String str) {

        if(str==null || str.isEmpty()) {
            return 0;
        }

        String intMax = String.valueOf(Integer.MAX_VALUE);
        String intMix = String.valueOf(Integer.MIN_VALUE).replaceAll("-","");

        boolean negative = false;

        Pattern pattern = Pattern.compile("^\\s{0,}(\\+|-|)\\d+.{0,}$");
        Pattern splitPattern = Pattern.compile("(\\+|-|)\\d+");
        Matcher sspp = splitPattern.matcher(str);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()) {

            sspp.find();
            int bbb = sspp.start();
            int eee = sspp.end();
            str = str.substring(bbb,eee);

            str = str.replaceAll(" ","");
            int head = 0;
            if(str.charAt(0)=='+') {
                head = 1;
            } else if(str.charAt(0)=='-') {
                head = 1;
                negative = true;
            }

            String num = "";
            for(int i=head ; i<=str.length()-1;i++) {
                if(str.charAt(i)=='0') {
                    head++;
                } else {
                    break;
                }
            }
            if(head == str.length()) {
                return 0;
            }

            int end = str.length();
            num = str.substring(head,end);

            if(negative) {
                if(num.length()>intMix.length()
                        || (num.equals(intMix))
                        || (num.length()==intMix.length()&&num.compareTo(intMix)>0)) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.valueOf(num)*-1;
                }
            } else {
                if(num.length()>intMax.length()
                        || (num.equals(intMax))
                        || (num.length()==intMax.length()&&num.compareTo(intMax)>0)) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.valueOf(num);
                }
            }
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(myAtoi("   -5-"));
    }

}
