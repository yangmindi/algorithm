package com.atguigu.linkedlist;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建结点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);


        //测试单链表的反转功能
        System.out.println("原链表的情况");
        singleLinkedList.list();
//        System.out.println("反转单链表");
//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();
        //测试逆序打印单链表
        System.out.println("逆序打印单链表");
        reversePrint(singleLinkedList.getHead());
/*
        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //测试修改结点的代码
        singleLinkedList.list();
        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表情况");
        //显示
        singleLinkedList.list();

        //删除一个结点
        System.out.println("修改后的链表情况");
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.list();

        //测试一下，求单链表中有效结点的个数
        System.out.println("有效的结点个数="+getLength(singleLinkedList.getHead()));

        //测试一下看看是否得到了倒数第k个元素
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),1);
        System.out.println("res="+res);
        */
    }


    //单链表的逆序打印【百度面试题】
    //利用栈，将各个结点压入栈中，然后利用栈的先进后出的特点，实现了逆序打印
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return ;//空链表无法打印
        }
        //先创建一个栈，将各个结点压入栈中
        Stack<HeroNode>stack = new Stack();
        HeroNode cur = head.next;
        //将链表的所有结点压入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.next;//后移,压入下一个结点
        }

        //将栈中的结点进行打印
        while(!stack.isEmpty()){
            System.out.println(stack.pop());//先进后出
        }
    }


    //将单链表进行反转【腾讯面试题】
    public static void reversetList(HeroNode head){
        //如果当前链表为空，或者只有一个结点，无需翻转，直接返回
        if(head.next == null || head.next.next==null){
            return ;
        }
        //先定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前结点【cur】的下一个结点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表
        //每遍历一个结点，就将其取出，并放在新的链表reverseHead的最前端
        //动脑筋
        while(cur != null){
            next = cur.next;//先暂时保存当前结点的下一个结点,因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个结点指向新的链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表反转
        head.next = reverseHead.next;
    }

    //查找单链表的倒数第k个结点【新浪面试题】
    //思路
    //1.编写一个方法，接收head结点，同时接收一个index
    //2.index表示倒数第index个结点
    //3.先把链表从右到位遍历，得到链表的长度getLength
    //4.得到size后，我们从链表的第一个开始遍历size-index个，就可以得到
    //5.如果找到返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        //判断，如果链表为空，返回null
        if(head.next == null){
            return null;//没有找到
        }
        //第一次遍历，得到链表的长度
        int size = getLength(head);
        //第二次遍历 size-inedx 位置，就是倒数第k个结点
        //先做一个index的校验
        if(index <= 0 || index > size){
            return null;
        }
        //定义一个辅助变量,指向第一个有效结点.for定位倒数的index
        HeroNode cur = head.next;
        for(int i=0; i<size-index; i++){
            cur = cur.next;
        }
        return cur;
    }

    //方法：获取到单链表的结点的个数（如果是带头结点的链表，需要不统计头结点）
    /**
     *
     * @param head 链表的头结点
     * @return 返回有效结点的个数
     */
    public static int getLength(HeroNode head){
        if(head.next == null){//空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助变量,没有统计头结点
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;//遍历
        }
        return length;
    }
}

//定义一个SingleLinkedList 管理我们的英雄
class SingleLinkedList{
    //先初始化一个头结点，头结点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加结点到单向链表
    //当不考虑编号的顺序时
    //1.找到当前链表的最后结点
    //2.将最后的这个结点的next域指向新的结点
    public void add(HeroNode heroNode){
        // 因为head结点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后,就将temp后移
            temp = temp.next;
        }
        //当退出while时，temp就指向链表的最后
        //将最后这个结点的next指向新的结点
        temp.next = heroNode;
    }

    //第二种方式再添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出显示)
    public void addByOrder(HeroNode heroNode){
        //因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个结点，否则插入失败
        HeroNode temp = head;
        boolean flag = false;//添加的编号是否存在，默认为false
        while(true){
            if(temp.next == null){//说明temp已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no){//位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){//说明希望添加的heroNode的编号已经存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;//后移，遍历当前的链表
        }
        //判断flag的值
        if(flag == true){//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在，不能加入\n",heroNode.no);
        }else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改结点的信息，根据编号来修改，即no编号不能改
    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        //是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return ;
        }
        //找到需要修改的结点，根据no编号
        //先定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while(true){
            if(temp == null){
                break;//已经遍历完链表
            }
            if(temp.no == newHeroNode.no){
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的结点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {//没有找到
            System.out.printf("没有找到编号 %d 的结点，不能修改\n",newHeroNode.no);
        }
    }

    //删除结点
    //思路
    //1.head结点不能动，因此，需要temp辅助接点找到待删除结点的前一个结点
    //2.在比较时，时temp.next.no和删除结点的no进行比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;//是否找到待删除结点
        while(true){
            if(temp.next == null){//已经到链表的最后
                break;
            }
            if(temp.next.no == no){
                //找到了待删除结点的前一个结点temp
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        //判断flag
        if(flag){//找到
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d结点不存在\n",no);
        }
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return ;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true){
            //是否到链表最后
            if(temp == null){
                break;
            }
            //输出结点的信息
            System.out.println(temp);
            //将next后移,一定小心
            temp = temp.next;
        }
    }
}

//定义一个HeroNode，每个HeroNode对象就是一个结点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    //构造器
    public HeroNode(int hNo,String name,String nickname){
        this.no = hNo;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，我们重写toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
    }
}

