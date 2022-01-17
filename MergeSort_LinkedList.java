public class HelloWorld{
   
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head=null;
    public static void add(int data){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(data);
    }
    
    public static void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();    
        
    }
    public static Node mid(Node st,Node end){
        Node slow=st;
        Node fast=st;
        while(fast.next!=end && fast.next.next!=end){
            //System.out.println(slow.data); 
            slow=slow.next;
            if(fast.next!=null)
            fast=fast.next.next;
        }
        //System.out.println(slow.data);
        return slow;
    }
    public static Node merger(Node l,Node r){
        Node nn = new Node(-1);
        Node temp= nn;
        while(l!=null || r!=null){
            int ldata=l==null?Integer.MAX_VALUE:l.data;
            int rdata=r==null?Integer.MAX_VALUE:r.data;
            if(ldata>rdata){
                nn.next=new Node(rdata);
                nn=nn.next;
                r=r.next;
            }
            else{
                nn.next=new Node(ldata);
                nn=nn.next;
                l=l.next;
            }
        }
        return temp.next;
    }
    public static Node mergeSort(Node start,Node end){
        if(start==end)return start;
        Node mid=mid(start,end);
        Node midnxt=mid.next;
        mid.next=null;
        Node l=mergeSort(start,mid);
        Node r=mergeSort(midnxt,end);
        Node f=merger(l,r);
        return f;
        
    }
    public static void main(String []args){
        head = new Node(-1);
        add(10);
        add(30);
        add(20);
        add(50);
        //add(40);
        head=head.next;
        display();
        //mid();
        head=mergeSort(head,null);
         display();
     }
}
