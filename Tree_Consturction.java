import java.util.*;
public class HelloWorld{
   

  public static class Node{
      int data;
      Node left;
      Node right;
      public Node(int data){
          this.data=data;
          this.left=null;
          this.right=null;
      }
  }
  public static class pair{
      Node nn;
      int state;
      public pair(Node nn,int state){
          this.nn=nn;
          this.state=state;
      }
  }
  public static Node construct(Integer[] data){
      Stack<pair> st = new Stack<>();
      Node r=new Node(data[0]);
      pair p = new pair(r,0);
      st.push(p);
      int idx=1;
      while(st.size()>0){
          pair rem = st.peek();
          if(rem.state==0){
              if(data[idx]==null){
                  rem.state++;
                  idx++;
              }
              else{
                  Node cn = new Node(data[idx]);
                  rem.nn.left=cn;
                  pair p1 = new pair(cn,0);
                  st.push(p1);
                  rem.state++;
                  idx++;
              }
          }
          else if(rem.state==1){
              if(data[idx]==null){
                  rem.state++;
                  idx++;
              }
              else{
                  Node cn = new Node(data[idx]);
                  rem.nn.right=cn;
                  pair p1 = new pair(cn,0);
                  st.push(p1);
                  rem.state++;
                  idx++;
              }
          }
          else{
              st.pop();
          }
          
          
      }
      return r;
  }
  public static Node BST(Integer[] data){
      Node curr= new Node(data[0]);
      for(int i=1;i<data.length;i++){
          setNode(curr,data[i]);
      }
      return curr;
  }
  public static Node setNode(Node curr,Integer data){
      if(data==null)return null;
      if(curr==null){
          Node nn = new Node(data);
          return nn;
      }
      if(curr.data>data){
          curr.left=setNode(curr.left,data);
      }
      else{
          curr.right=setNode(curr.right,data);
      }
      return curr;
          
     }
  
  public static void inorder(Node root){
      if(root==null)return;
      inorder(root.left);
      System.out.println(root.data);
      inorder(root.right);
  }
   
    public static void main(String []args){
        Integer [] data= {10,20,40,null,null,50,null,null,30,60,null,null,70,null,null};
        Node root=construct(data);
        Node root1=BST(data);
        inorder(root1);
        
        
     }
}
