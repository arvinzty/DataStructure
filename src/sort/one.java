package sort;

/**
 * 排序算法
 */
public class one {

    public static void main(String[] args) {
        int[] s={7,3,4,5,2,1,8,9,6};
        System.out.println("排序前");
        for (int i:s)
            System.out.printf("[%d]",i);
        System.out.println();
        one.sort2(s);
        System.out.println("排序后");
        for (int i:s)
            System.out.printf("[%d]",i);
        System.out.println();

    }
//选择排序
    static public  void sort1(int[] s){
        for (int i=0;i<s.length-1;i++)
            for (int j=i+1;j<s.length;j++) {
                if (s[i]<s[j]){
                    int tem=s[j];
                    s[j]=s[i];
                    s[i]=tem;
                }
            }
    }

//冒泡排序
    static public void sort2(int[] s){
        for (int i=0;i<s.length-1;i++)
            for (int j=0;j<s.length-i-1;j++){
                if (s[j]<s[j+1]){
                    int tem=s[j];
                    s[j]=s[j+1];
                    s[j+1]=tem;
                }
            }


    }

}
