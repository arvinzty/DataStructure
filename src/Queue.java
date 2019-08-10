import java.util.Scanner;

/**
 * 队列的三个数值num（数值数量），front（队列头坐标），rear（队列尾坐标）相互独立
 * num空则无法删除，num满贼无法添加
 * 每当移除，front头坐标置0，坐标向后移一位，位移到坐标尾后移到坐标头
 * 每当添加数值时，rear向后移一位，并且将值放入
 */
public class Queue {

    public static void main(String[] args) {
        boolean loop=true;
        System.out.println("输入要创建的队列的大小：");
        Scanner s=new Scanner(System.in);
        Queue queue=new Queue(s.nextInt());
        System.out.println(queue.queue);
        while (loop){
            System.out.println("输入a进行添加，输入r进行移除，输入e退出程序");
            Scanner s1=new Scanner(System.in);
            switch (s1.next().charAt(0)){
                case 'a':
                    System.out.println("输入要添加值：");
                    Scanner s2=new Scanner(System.in) ;
                    queue.add(s2.nextInt());
                    queue.query();
                    break;
                case 'r':
                    System.out.println("移除后显示");
                    queue.remove();
                    queue.query();
                    break;
                case 'e':
                    loop=false;
                    break;
                default:
                    break;
            }

        }System.out.println("退出成功");
    }

//队列最后一个属性的下标
    private int rear;
//    对了第一个属性的下标
    private int front;
//    判断满不满
    private int num;
    private int[] queue;
    private int maxSize;

    public Queue(int tem){

        this.queue=new int[tem];
        maxSize=queue.length;
        rear=-1;
        front=0;
    }
//    判断队列是否已满
    private boolean isFull(){
        return num==maxSize;
    }
    //    添加值，添加到后面
    public void add(int i){
       if (isFull()){
           System.out.println("队列满添加失败");
          return;
       }
       if (rear!=(maxSize-1)){
           rear++;
           num++;
           queue[rear]=i;
       }else {
           rear=0;
           num++;
           queue[rear]=i;
       }
    }
//    移除值，从最前面
    public void remove(){
        if (num==0){
//            throw new RuntimeException("队列空无法移除");
            System.out.println("队列空无法移除");
            return;
        }
        if (front!=(maxSize-1)){
            num--;
            queue[front]=0;
            front++;
        }else {
            num--;
            queue[front]=0;
            front=0;
        }
    }

//    查看队列
    public void query(){
        for (int tem:queue){
            System.out.printf("[%d]",tem);
        }
        System.out.println();
    }
}
