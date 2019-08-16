import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        StringBuilder s=new StringBuilder();
//        s.append("arvinzty");
//        System.out.printf("反转前：%s\n",s);
//        StringBuilder s1=s.reverse();
//        System.out.printf("反转后：%s\n",s1);
//        System.out.println();
//
//        String s2="qwertasdgfzxc";
//        System.out.println(s2);
//        String s3=s2.toUpperCase();
//        byte[] b=s2.getBytes();
//        System.out.println("处理后");
//        System.out.print(s3.substring(2,3));

//        List s=new ArrayList();
//        s.add("asdasd");
//        Iterator i= s.iterator();
//        System.out.println(s.get(0));
//        test t=new test();
//        String s=null;
//        System.out.println(t.checkParam(s));
//        String[] s={"qwe","dsf"};
//        List<String> list= Arrays.asList(s);
//        list.add("sdd");
//        System.out.println(list.size());
        String s1 = "a";

        String s2 = s1 + "b";

        String s3 = "a" + "b";

        System.out.println(s2 == "ab");

        System.out.println(s3 == "ab");


    }
    String ss="zxc";

    public boolean checkParam(String s){
        return s.equals(ss);
    }
}
