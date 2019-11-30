package com.atguigu.linkedlist;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public Integer no;
    public String name;
    public String nickname;
    public Node next;

    public Node(Integer no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class SingleLinkList {
    Node node = new Node(0, "", "");

    public Node getHead() {
        return node;
    }

    public void delete(int no) {
        Node temp = node;
        boolean flag = false;
        while (temp != null) {
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("没有找到");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void update(Node pNode) {
        Node temp = node;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.no == pNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("没找到值");
        } else {
            temp.name = pNode.name;
            temp.nickname = pNode.nickname;
        }
    }

    public void addByOrder(Node pNode) {
        Node temp = node;
        boolean flag = false;
        while (temp.next != null) {
            if (pNode.no == temp.next.no) {
                flag = true;
                break;
            } else if (pNode.no < temp.next.no) {
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            System.out.println("编号已存在不能加入");
        } else {
            pNode.next = temp.next;
            temp.next = pNode;
        }
    }

    public void add(Node node01) {
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node01;
    }

    public void list() {
        Node temp = node.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


public class SingleLinkedListDemo01 {

    public static int getLength(Node node) {
        Node temp = node;
        if (temp == null) {
            return 0;
        }
        int length = 0;
        temp = temp.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static Node findLastIndexNode(Node node, int index) {
        Node temp = node;
        if (temp == null) {
            return null;
        }
        int length = getLength(temp);
        temp = temp.next;
        if (temp == null) {
            return null;
        }
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        Node cur = temp;
        return cur;
    }


    public static void reverseList(Node pNode) {
        if (pNode.next == null || pNode.next.next == null) {
            return;
        }
        Node cur = pNode.next;
        Node next = null;
        Node reverseHead = new Node(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        pNode.next = reverseHead.next;
    }

    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList();
        Node hero1 = new Node(1, "宋江", "及时雨");
        Node hero2 = new Node(2, "卢俊义", "玉麒麟");
        Node hero3 = new Node(3, "吴用", "智多星");
        Node hero4 = new Node(4, "林冲", "豹子头");

        singleLinkList.add(hero1);
        singleLinkList.add(hero2);
        singleLinkList.add(hero3);
        singleLinkList.add(hero4);
        System.out.println("反转之前");
        singleLinkList.list();
        reverseList(singleLinkList.getHead());

//        singleLinkList.addByOrder(hero1);
//        singleLinkList.addByOrder(hero4);
//        singleLinkList.addByOrder(hero3);
//        singleLinkList.addByOrder(hero2);
        System.out.println("反转之后");
        singleLinkList.list();

//        Node hero5 = new Node(2, "小卢", "玉麒麟~~");
//        singleLinkList.update(hero5);
//        System.out.println("修改之后：");

//        singleLinkList.list();

//        singleLinkList.delete(1);
//        singleLinkList.delete(4);
//        singleLinkList.delete(3);
//        singleLinkList.delete(2);
//        System.out.println("删除之后");
//        singleLinkList.list();

//        int length = getLength(singleLinkList.getHead());
//        System.out.println("长度为:" + length);
//        Node node = findLastIndexNode(singleLinkList.getHead(), 10);
//        System.out.println("倒是节点为:" + node);


    }
}
