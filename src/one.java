public class one {
    public static void main(String[] args) {
        int[][] s=new int[8] [9];
        s[2][3]=3;
        s[3][4]=5;
        one x=new one();
        for (int i=0;i<s.length;i++){
            System.out.println(" ");
            for (int j=0;j<s[0].length;j++){
                System.out.print(s[i][j]+" ");
            }
        }
        int[][] tem=x.trans(s);
        System.out.println(" ");
        System.out.println("转换为稀疏数组后");
        for (int i=0;i<tem.length;i++){
            System.out.println(" ");
            for (int j=0;j<tem[0].length;j++){
                System.out.print(tem[i][j]+" ");
            }
        }

        System.out.println(" ");
        System.out.println("变回原来的数组");
        int[][] tem1=x.transTo(tem);
        for (int i=0;i<tem1.length;i++){
            System.out.println(" ");
            for (int j=0;j<tem1[0].length;j++){
                System.out.print(tem1[i][j]+" ");
            }
        }

    }

    public int[][] transTo(int[][] s){
        int[][] tem2=new int[s[0][0]][s[0][1]];
        int row=1;
        for (int i=0;i<tem2.length;i++){
            for (int j=0;j<tem2[0].length;j++){
              if (row<s.length){
                  if (i==s[row][0] & j==s[row][1]){
                      tem2[i][j]=s[row][2];
                      row++;
                  }
              }


            }
        }
        return tem2;
    }

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
