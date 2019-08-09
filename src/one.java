import java.io.*;

public class one {
    public static void main(String[] args) {
        int[][] s = new int[8][9];
        s[2][5] = 8;
        s[3][5] = 3;
        s[6][5] = 9;
        s[1][5]=7;
        s[7][5]=2;
        one x = new one();
        x.erdogic(s);
        int[][] tem = x.trans(s);
        System.out.println(" ");
        System.out.println("转换为稀疏数组后");
        x.erdogic(tem);

        System.out.println(" ");
        System.out.println("变回原来的数组");
        int[][] tem1 = x.transTo(tem);
        x.erdogic(tem1);
        System.out.printf("\n测试结束");

        System.out.printf("\n开始从硬盘读取");
//将悉数数组写入硬盘
//        x.loadDown(tem);
//        稀疏数组所在的硬盘位置
        String path = "E:" + File.separator + "demo" + File.separator + "one.data";
//       读稀疏数组，并且转换为原数组
        int[][] tem4 = x.fetch(path);
        x.erdogic(tem4);
    }

    //    遍历数组
    public void erdogic(int[][] tem) {
        for (int[] tem2 : tem) {
            System.out.println(" ");
            for (int tem3 : tem2) {
                System.out.print(tem3 + " ");
            }
        }
    }

    //将数组从磁盘里读出来
    public int[][] fetch(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path);
//             DataInputStream dataInputStream = new DataInputStream(fileInputStream);
             InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        ) {
            String s=bufferedReader.readLine();
            System.out.println(s);
            char[] a = s.toCharArray();
            int[][] ss = new int[Integer.parseInt(a[0]+"")][Integer.parseInt(a[1]+"")];
            for (int i = 3; i < a.length-3; i = i+3) {
                int a1=Integer.parseInt(a[i] + "");
                int a2=Integer.parseInt(a[i+1] + "");
                int a3=Integer.parseInt(a[i+2] + "");
                ss[a1][a2] = a3;
            }
            return ss;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


//    把数组存盘
    public void loadDown(int[][] tem){
        try (FileOutputStream fileOutputStream=new FileOutputStream("E:"+File.separator+"demo"+File.separator+"one.data",true);
//             DataOutputStream dataOutputStream=new DataOutputStream((fileOutputStream));
             BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        ){
//  失败的实现，废弃
//            int i=0;
//            for (int[] tem1:tem) {
//                for (int tem2:tem1){
//                    bufferedOutputStream.write(tem2);
//                }
//            }
//            bufferedOutputStream.flush();
//String写入
            for (int i=0;i<tem.length;i++){
                String s=tem[i][0]+""+tem[i][1]+tem[i][2];
                byte[] b=s.getBytes();
                bufferedOutputStream.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//从稀疏数组转为原数组
    public int[][] transTo(int[][] s){
        int[][] tem2=new int[s[0][0]][s[0][1]];
        for (int i=1;i<s.length;i++){
            tem2[s[i][0]][s[i][1]]=s[i][2];
        }

        return tem2;
    }
//转为稀疏数组
    public int[][] trans(int[][] s){
        int num=0;
        for (int i=0;i<s.length;i++){
            for (int j=0;j<s[0].length;j++){
                if (s[i][j]!=0){
                    num++;

                }
            }
        }
        int row=0;
        int[][] output=new int[num+1][3];
        output[0][0]=s.length;
        output[0][1]=s[0].length;
        output[0][2]=num;
        for (int i=0;i<s.length;i++){
            for (int j=0;j<s[0].length;j++){
                if (s[i][j]!=0){
                    row++;
                    output[row][0] =i;
                    output[row][1]=j;
                    output[row][2]=s[i][j];

                }
            }
        }
        return output;
    }
}
