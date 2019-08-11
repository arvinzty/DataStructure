package linkList;

import java.security.PrivateKey;

/**
 * 单向链表
 * HeroNode是链表的的节点，每一个节点都包含下一个节点的地址信息
 * LinkList是链表，负责添加和展示链表
 *
 */
public class one {
    public static void main(String[] args) {
        HeroNode h1=new HeroNode(1,"宋江","及时雨");
        HeroNode h2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode h3=new HeroNode(3,"吴用","智多星");
        HeroNode h4=new HeroNode(4,"林冲","豹子头");
        HeroNode h5=new HeroNode(5,"小鱼人","无敌");
        HeroNode h6=new HeroNode(5,"滚滚","滚日天");
        HeroNode h7=new HeroNode(6,"斯拉克","深海");
        LinkList linkList=new LinkList();
        linkList.list();
        linkList.addByOder(h4);
        linkList.addByOder(h5);
        linkList.addByOder(h2);
        linkList.addByOder(h3);
        linkList.addByOder(h1);
        linkList.addByOder(h3);
        linkList.addByOder(h4);
        linkList.addByOder(h4);
        linkList.list();
//        linkList.updata(h6);
//        linkList.updata(h7);
//        linkList.list();
//        System.out.println("开始删除");
//        linkList.delete(4);
        System.out.println("OrderByDESC");
        linkList.byDesc();
        linkList.list();
    }
}

class LinkList{
    private HeroNode headNode=new HeroNode(0,null,null);
//    倒叙排列
    public void byDesc(){
        HeroNode head=new HeroNode(-1,"","");
        HeroNode tem;
        while (true){
            if (headNode.getNext()==null){
                break;
            }
            tem=headNode.getNext();
            headNode.setNext(headNode.getNext().getNext());
            if (head.getNext()==null){
                tem.setNext(null);
                head.setNext(tem);
            }else {
                tem.setNext(head.getNext());
                head.setNext(tem);
            }

        }
        if (head.getNext()!=null){
            headNode.setNext(head.getNext());
        }
    }

    public void delete(int i){
        if (i<1){
            System.out.println("输入错误，删除索引不可小于1");
            return;
        }
        int num=0;
        boolean anchor=false ;
        HeroNode heroNode=headNode;
        while (true){
            if (heroNode.getNext()==null)
                break;
            num++;
            if (num==i){
                anchor=true;
                break;
            }
            heroNode=heroNode.getNext();
        }
        if (anchor){
            heroNode.setNext(heroNode.getNext().getNext());
        }else {
            System.out.println("删除失败，应该是超过了链表长度");
        }
    }
    //挨个遍历，找到ID相同的，然后修改，没有找到的话不修改
    public void updata(HeroNode node){
        boolean anchor=false;
        HeroNode heroNode=headNode;
        while (true) {
            if (heroNode.getNext()==null){
                break;
            }
            if (heroNode.getNext().getId()==node.getId()){
                anchor=true;
                break;
            }
            heroNode=heroNode.getNext();
        }
        if (anchor){
            heroNode.getNext().setName(node.getName());
            heroNode.getNext().setDesignation(node.getDesignation());
        }else{
            System.out.println("没有元素无法修改");
        }
    }

    public void list(){
        HeroNode heroNode1=headNode.getNext();
        if (heroNode1==null){
            System.out.println("当前链表无值");
            return;
        }
        boolean loop=true;
        while (loop){
            System.out.println(heroNode1);
            if (heroNode1.getNext()==null){
                loop=false;
//                break;
            }else {
                heroNode1=heroNode1.getNext();
            }

        }
    }
//第一次直接插入节点，第二次以后开始每次插入都挨次比较，当链表内的元素大于插入元素时，将元素插到节点前一个
    public void addByOder(HeroNode heroNode){
//        if (headNode.getNext()==null){
//            headNode.setNext(heroNode);
//            return;
//        }
        boolean loop=false;
        HeroNode node=headNode;
        while (true){
//            第一次进入在链表里添加一个节点后退出
            if (node.getNext()==null){
                node.setNext(heroNode);
                break;
            }
            if (node.getNext().getId()>heroNode.getId()){
                HeroNode tem=node.getNext();
                node.setNext(heroNode);
                heroNode.setNext(tem);
                break;
            }
            if (node.getNext().getId()==heroNode.getId()){
                loop=true;
                break;
            }
            node=node.getNext();
        }
        if (loop){
            System.out.println("已有重复的id，不允许添加");
        }


    }
//循环遍历到最后一个节点，插入数据
    public void add(HeroNode heroNode){
        if (headNode.getNext()==null){
            headNode.setNext(heroNode);
            return;
        }
        boolean loop=true;
        HeroNode heroNode1=headNode.getNext();
        while (loop){

            if (heroNode1.getNext()==null){
                heroNode1.setNext(heroNode);
                loop=false;
//                break;
            }else {
                heroNode1=heroNode1.getNext();
            }

        }
    }
}

class HeroNode{
    private int id;
    private String name;
    private String designation;
    private HeroNode next=null;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode(int id, String name, String designation){
        this.id=id;
        this.name=name;
        this.designation=designation;
    }
    public String toString(){
        if (next==null)
            return String.format("id=%d,name=%s.designation=%s",id,name,designation);
        else
            return String.format("id=%d,name=%s.designation=%s，next.name：%s",id,name,designation,next.getName());
    }
}