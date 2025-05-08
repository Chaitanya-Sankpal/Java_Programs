/*Create the interface stack which has variable size, abstract methods push(),pop(),display(),
overflow() and underflow(). We need to implement 3 subclasses IntegerStack, StringStack and DoubleStack
respectively by implementing interface. All the methods in interface are declared for string. And in subclass for
integerStack convert string to integer. Same thing to all other. Create one test class and check for the working of all the
classes */

interface Stack{
	
	int size=10;
	void push(String val);
	String pop();
	void display();
	boolean overflow();
	boolean underflow();
	
}
class IntegerStack implements Stack
{
	int stack[];
	int top;
	
	IntegerStack(){
		 top=-1;
		 stack =new int[size];
	}
	
	public void push(String value)
	{
		if (top==size-1)
		{
			System.out.println("Stack is Overflow");
		}
		else
		{
			 stack[++top]=Integer.parseInt(value);
			 System.out.println("Element pushed are:"+value);
		}	
	}
	
	public String pop()
	{
		if (top==-1)
		{
			System.out.println("Stack is Underflow");
			return "-1";
		}
		else
		{
			 System.out.println("Element poped:"+stack[top--]); 
			 return " ";
		}	
	}


	public boolean overflow()
	{
		if(top==size-1){
			return true;
		}else{
			return false;
		}
	}


	public boolean underflow()
	{
		if(top==-1){

			return true;
		}
        else{
			return false;
		}
	}

	public void display(){
		for (int i=top;i>=0;i--){
			System.out.println("Stack:"+stack[i]);
		}
	}
	
}

class StringStack implements Stack{
        
        String stack[];
        int top;
        
        StringStack(){
            top=-1;
            stack=new String[size];
        }
        
        public void push(String value){
            if(top==size-1){
                System.out.println("Stack is Overflow");
            }else{
                stack[++top]=value;
                System.out.println("Element pushed are:"+value);
            }
        }
        
        public String pop(){
            if(top==-1){
                System.out.println("Stack is Underflow");
                return "-1";
            }else{
                System.out.println("Element poped:"+stack[top--]);
                return " ";
            }
        }
        
        public boolean overflow(){
            if(top==size-1){
                return true;
            }else{
                return false;
            }
        }
        
        public boolean underflow(){
            if(top==-1){
                return true;
            }else{
                return false;
            }
        }
        
        public void display(){
            for(int i=top;i>=0;i--){
                System.out.println("Stack Elements : "+stack[i]);
            }
        }
}
class DoubleStack implements Stack  {
    double stack[];
    int top;
    
    DoubleStack(){
        top=-1;
        stack=new double[size];
    }
    
    public void push(String value){
        if(top==size-1){
            System.out.println("Stack is Overflow");
        }else{
            stack[++top]=Double.parseDouble(value);
            System.out.println("Element pushed are:"+value);
        }
    }
    
    public String pop(){
        if(top==-1){
            System.out.println("Stack is Underflow");
            return "-1";
        }else{
            System.out.println("Element poped:"+stack[top--]);
            return " "; 
        }
    }
    
    public boolean overflow(){
        if(top==size-1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean underflow(){
        if(top==-1){
            return true;
        }else{
            return false;
        }
    }
    
    public void display(){
        for(int i=top;i>=0;i--){
            System.out.println("Stack Elements : "+stack[i]);
        }
    }
    
}



public class StackTest{
	public static void main(String args[]){
        System.out.println(" --- Integer Stack ---");
		IntegerStack i=new IntegerStack();
		i.push("10");
		i.push("20");
		
		i.display();
		i.pop();
        i.display();

        System.out.println("\n\n --- String Stack ---");
        StringStack s=new StringStack();
        s.push("A");
        s.push("B");
        s.display(); 
        s.pop();
        s.display();

        System.out.println("\n\n --- Double Stack ---");
        DoubleStack d=new DoubleStack();
        d.push("10.44");
        d.display();
        d.pop();
        d.display();     
	}
}