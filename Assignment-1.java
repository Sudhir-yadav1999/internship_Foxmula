

Ques -1) Create a class called Time, which has three private instance variables – hour, min and sec. It contains a
method called add ( ) which takes one Time object as parameter and print the added value of the calling
Time object and passes Time object. In the main method, declare two Time objects and assign values
using constructor and call the add ( ) method.

Code -1

package java_project_internship;


class Time
{
	private int hour,min,sec;
	
	public Time(int hour,int min,int sec)
	{
		this.hour=hour;
		this.min=min;
		this.sec=sec;
		
	}
	
	public Time add(Time tt) 
	{
		Time ttl=new Time(0,0,0);
		ttl.hour=this.hour+tt.hour;
		ttl.min=this.min+tt.min;
		ttl.sec=this.sec+tt.sec;
		
		return ttl;
		
	}
	 public void display()
	 {
		 System.out.println("Hour"+this.hour);
		 System.out.println("Min"+this.min);
		 System.out.println("sec"+this.sec);
	 }

}

public class time_obj {

	public static void main(String args[])
	{
		
		Time t1=new Time(10,15,20);
		Time t2=new Time(2,10,6);
		
		 System.out.println("The hour min and sec of t1 ");
		 t1.display();
		 System.out.println("The hour min and sec of t2 ");
		 t2.display();
		 System.out.println("The hour min and sec of added t1 and t2");	
		Time t3= t1.add(t2);
		 t3.display();
		 
	}
}

Ques -2

Create a class Stack that declares a stack and the methods to perform push ( ), pop ( ) and checkEmpty (
) operations on the stack. Create two stacks and write a menu-driven program to perform operations on
the two stacks. Whenever the number of elements in the two stacks becomes equal, a message should
automatically be generated displaying the number of elements in each stack.

	
	
import java.util.*;

public class Stack {
	private int stack[],top,max=10;
	
	Stack(){
		top=-1;
		stack=new int[max];
	}
	
	
	void push(int data) {
		if(top>=max)
			System.out.println("Stack Overflow!!");
		else
			stack[++top]=data;
	}
	
	
	boolean checkEmpty() {
		
		if(top==-1)
			return true;
		else
			return false;
	}
	

	int pop() {
		if(checkEmpty())
			return -1;
			
		else
			return stack[top--];
	}
	
	
	void CountCheck(Stack s2) {
		if(this.top==s2.top && s2.top>-1)
			System.out.println("The number of elements in both the stacks = "+(s2.top+1));
	}
	
	
	void display() {
		if(checkEmpty()) 
			System.out.println("Stack Underflow!!");
		for(int i=0;i<=top;i++)
			System.out.print(stack[i]+"\t");
	}
	
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		Stack s1=new Stack();
		Stack s2=new Stack();
		int ch,temp;
		do {
			System.out.println("1. Push Element in stack 1 ");
			System.out.println("2. Pop Element in stack 1 ");
			System.out.println("3. Push Element in stack 2 ");
			System.out.println("4. Pop Element in stack 2 ");
			System.out.println("Enter your choice? ");
			ch=sc.nextInt();
			s1.CountCheck(s2);
			switch(ch){
			case 1:
				System.out.println("Enter the data you want to add to stack 1");
				s1.push(sc.nextInt());
				break;
			
			case 2:
				temp=s1.pop();
				if(temp==-1) 
					System.out.println("Stack Underflow!!");
				else	
					System.out.println("The popped element is:"+temp);
				s1.display();
				break;
			
			case 3:
				System.out.println("Enter the data you want to add to stack 2");
				s2.push(sc.nextInt());
				break;
				
			case 4:
				temp=s2.pop();
				if(temp==-1) 
					System.out.println("Stack Underflow!!");
				else	
					System.out.println("The popped element is:"+temp);
					s2.display();
				break;
				
			}
			System.out.println("Do you want to continue Yes/No");
			ch=sc.nextInt();
		}while(ch==1);
	}

Ques -3
Write an inheritance hierarchy for classes Quadrilateral, Trapezoid, Parallelogram, Rectangle and Square.
Use Quadrilateral as the super class of the hierarchy. The instance variables of Quadrilateral should be
the x-y coordinate pairs for the four endpoints of the Quadrilateral. Write a program that instantiates
objects of your classes and outputs each object's area (except Quadrilateral
	
    class Quadrilateral {
    public int x1,x2,x3,x4,y1,y2,y3,y4;
    public void setCoordinate(int a, int b, int c, int d, int e , int f, int g, int h){
    x1=a;x2=b;x3=c;x4=d;y1=e;y2=f;y3=g;y4=h;    
    }
}
class Trapezoid extends Quadrilateral{
    private int height;
    Trapezoid(int a, int b, int c, int d, int e, int f , int g , int h , int height ){
        setCoordinate(a,b,c,d,e,f,g,h);
        this.height = height;
    }
        int area(){
            int d1= (int)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            int d2= (int) Math.sqrt((x3-x4)*(x3-x4)+(y3-y4)*(y3-y4));
            return (int)((d1+d2)*height)/2;
    }
}

class Paralleogram extends Quadrilateral{
    private int height;
    Paralleogram(int a, int b, int c, int d, int e, int f , int g , int h , int height ){
        setCoordinate(a,b,c,d,e,f,g,h);
        this.height = height;
    }
        int area(){
            int d1= (int)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            return  d1*height;
    }
}

class Square extends Quadrilateral{
    Square(int a, int b, int c, int d,int e, int f, int g, int h){
        setCoordinate(a,b,c,d,e,f,g,h);
    }
    int area(){
        int d= (int)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        return d*d;
    }
}
class Rectangle extends Quadrilateral{
    Rectangle(int a, int b, int c ,int d,int e, int f, int g , int h ){
          setCoordinate(a,b,c,d,e,f,g,h);
    }
    int area(){
        int d1 =(int)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        int d2 =(int)Math.sqrt((x3-x4)*(x3-x4)+(y3-y4)*(y3-y4));
        return d1*d2;
    }
}   
public class AreaSolving{
    public static void main(String args[]){
      Square sq=new Square(10,20,20,10,10,20,20,10); 
	    
      System.out.println("area  of square is:"+sq.area());
	    
      Rectangle rec= new Rectangle(10,20,30,10,30,20,20,10);
	    
      System.out.println("area of rectangle is:"+rec.area());
	    
      Paralleogram para= new Paralleogram(10,20,30,10,30,0,20,10,20);
	    
      System.out.println("area of paralleogram is:"+para.area());
	    
      Trapezoid trap= new Trapezoid(10,20,30,10,30,0,20,10,20);
	    
      System.out.println("area  of trapezoid is:"+trap.area());
    }
}


