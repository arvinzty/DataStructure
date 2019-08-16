package sort;

/**
 * 排序算法
 * sort1 选择排序
 * sort2 冒泡排序
 * sort3 插入排序
 */
public class one {

    public static void main(String[] args) {
        int[] s={7,3,4,5,2,1,8,9,6};
        System.out.println("排序前");
        for (int i:s)
            System.out.printf("[%d]",i);
        System.out.println();
//        one.sort2(s);
//        System.out.println("排序后");
//        for (int i:s)
//            System.out.printf("[%d]",i);
//        System.out.println();
//        int[] tem=one.insterSort(s,6);
//        System.out.println("插入后");
//        for (int z:tem)
//            System.out.printf("[%d]",z);
//        System.out.println();
        one.sort3(s);
        System.out.println("排序后");
        for (int i:s)
            System.out.printf("[%d]",i);
        System.out.println();

    }

//    插入排序
    static public void sort3(int[] s){
        for (int i=1;i<s.length;i++){
            int tem=s[i];
            int z=i;
            while (z>=1 && tem<s[z-1]){
                s[z]=s[z-1];
                z--;
            }
            s[z]=tem;
        }
    }
//    将数据插入有序数组
    static public int[] insterSort(int[] s,int in){
        int i;
        int[] newInt=new int[s.length+1];
        for ( i=0;i<s.length;i++){
            if (in<s[i]){
                if(i==0){
                    newInt[0]=in;
                    for (int x=0;x<newInt.length-1;x++)
                        newInt[x+1]=s[x];
                    newInt[s.length]=s[s.length-1];
                    return newInt;
                }else {
                    break;
                }
            }
            if (i==s.length-1){
                newInt[i+1]=in;
                for (int j=0;j<newInt.length-1;j++)
                    newInt[j]=s[j];
                newInt[s.length]=s[s.length-1];
                return newInt;
            }
        }
        for (int z=0;z<i;z++)
            newInt[z]=s[z];
        newInt[i]=in;
        for (int c=i+1;c<newInt.length-1;c++)
            newInt[c]=s[c-1];
        newInt[s.length]=s[s.length-1];
        return newInt;
    }
//选择排序
    static public  void sort1(int[] s){
        for (int i=0;i<s.length-1;i++)
            for (int j=i+1;j<s.length;j++) {
                if (s[i]>s[j]){
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
                if (s[j]>s[j+1]){
                    int tem=s[j];
                    s[j]=s[j+1];
                    s[j+1]=tem;
                }
            }


    }

}
