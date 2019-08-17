package sort;

/**
 * 排序算法
 * sort1 选择排序
 * sort2 冒泡排序
 * sort3 插入排序
 * sort4 快速排序 交换法
 * sort5 快速排序 挖坑法
 */
public class one {

    public static void main(String[] args) {
        int[] s={7,3,4,5,2,1,8,9,6,7,6,4};
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

        one.sort5(s,0,s.length-1);
        System.out.println("排序后");
        for (int i:s)
            System.out.printf("[%d]",i);
        System.out.println();


    }

      public static void sort5(int[] s,int left,int right){
        if (right<=left)
            return;
        int i,j;
        i=left;
        j=right;
        int tem=s[i];
        while (i<j){
            while (s[j]>=tem && j>i)
                j--;
            s[i]=s[j];
            while (s[i]<=tem && j>i)
                i++;
            s[j]=s[i];
        }
        s[i]=tem;
        sort5(s,left,i-1);
        sort5(s,i+1,right);
    }

//    快速排序实现(交换法)
//    static public void sort4(int[] s,int left,int right){
//        if (left>right){{
//            return;
//        }}
//        int tem=s[0];
//        while (left!=right){
//            while (s[right]<=tem & right>left)
//                right--;
//            while (s[left]>=tem & left<right)
//                left++;
//            if(left<right){
//                int t=s[left];
//                s[left]=s[right];
//                s[right]=t;
//            }
//        }
//        s[0]=s[left];
//        s[left]=tem;
//        sort4(s,1,left-1);
//        sort4(s,left+1,s.length-1);
//    }

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
