package com.atguigu.tree;

import java.util.Arrays;
import java.util.Stack;

class BinaryTree_Find {
    private HeroNode_Find root;

    public void setRoot(HeroNode_Find root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //==========查找===========
    public HeroNode_Find preSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode_Find infixSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode_Find postSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //==========删除==========
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
                return ;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除");
        }
    }

}

class HeroNode_Find {
    private int no;
    private String name;
    private HeroNode_Find left;
    private HeroNode_Find right;

    public HeroNode_Find(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode_Find{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode_Find getLeft() {
        return left;
    }

    public void setLeft(HeroNode_Find left) {
        this.left = left;
    }

    public HeroNode_Find getRight() {
        return right;
    }

    public void setRight(HeroNode_Find right) {
        this.right = right;
    }


    //==========删除==========
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return ;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return ;
        }
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }


    //==========
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //========查找=========

    public HeroNode_Find preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        if (this.no == no) {
            return this;
        }

        HeroNode_Find resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode_Find infixOrderSearch(int no) {
        HeroNode_Find resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode_Find postOrderSearch(int no) {
        HeroNode_Find resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}

public class BinaryTreeFindDemo {
    public static void main(String[] args) {
        BinaryTree_Find binaryTree = new BinaryTree_Find();

        HeroNode_Find root = new HeroNode_Find(1, "宋江");
        HeroNode_Find node2 = new HeroNode_Find(2, "吴用");
        HeroNode_Find node3 = new HeroNode_Find(3, "卢俊义");
        HeroNode_Find node4 = new HeroNode_Find(4, "林冲");
        HeroNode_Find node5 = new HeroNode_Find(5, "关胜");

        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);


//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();


        //后序遍历查找
//        System.out.println("后序遍历方式！！！");
//        HeroNode_Find resNode = binaryTree.postSearch(5);
//        if (resNode != null) {
//            System.out.println("找到了，信息为" + resNode);
//        } else {
//            System.out.println("空");
//        }

        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除后");
        binaryTree.preOrder();
    }


}
