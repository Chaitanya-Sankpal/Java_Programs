// Create abstract class Shape which has instance variables side, area and perimeter And methods 
// calculateArea(),  calculatePerimeter() as abstract methods and display() as concrete method. Write subclasses which 
// extend Shape class like Triangle, Rectangle, Circle , Cube and Squere and override abstract methods and display 
// methods in subclass take instance variable if needed as per the formula. And use parameterized constructor to initialize 
// instance variables using “this” reference variable 
// Write Test class and Create a reference variable of Shape which will hold the objects of all the sub classes and calculate 
// respective area, perimeter and display the results.
  
abstract class Shape {
   double side, area ,perimeter;

   abstract void calculateArea();
   abstract void  calculatePerimeter();

    void display(){
        System.out.println("area = "+ area);
        System.out.println("Perimeter = " +perimeter);
    }
    
}

class Triangle extends Shape{
    double base;
    double height;

    Triangle(double base,double height){
        this.base = base;
        this.height = height;
    }
    void calculateArea( ){
        area = 0.5 * base * height ;

    }
    void  calculatePerimeter(){
        perimeter = 3 * base;
    }
}

class Rectangle extends Shape{
    double length;
    double breadth;

    Rectangle(double length,double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    void calculateArea( ){
        area = length * breadth;
    }
    void  calculatePerimeter(){
        perimeter = 2 * (length+breadth);
    }
}

class Circle extends Shape{
    double radius;
    double pi = 3.14;

    Circle(double radius){
        this.radius = radius;
        this.pi = pi;
    }
    void calculateArea( ){
        area = pi * radius * radius;
    }
    void  calculatePerimeter(){
        perimeter = 2 * pi * radius;
    }
}

class Cube extends Shape{
    double side;
    

   Cube(double side){
        this.side = side;
        
    }
    void calculateArea( ){
        area = 6 * side * side;
    }
    void  calculatePerimeter(){
        perimeter = 12 * side;
    }
}

class Squere extends Shape{
    double side;

    Squere(double side){
        this.side = side;
        
    }
    void calculateArea( ){
        area =  side * side;
    }
    void  calculatePerimeter(){
        perimeter = 4 * side;
    }
}


public class Test {
    public static void main(String[] args) {
        System.out.println(" ---For Triangle---");
        Shape t = new Triangle(2,4);
        t.calculateArea();
        t.calculatePerimeter();
        t.display(); 
        System.out.println();
        System.out.println();

        System.out.println(" ---For Rectangle---");
        Shape r = new Rectangle(2,4);
        r.calculateArea();
        r.calculatePerimeter();
        r.display(); 
        System.out.println();
        System.out.println();

        System.out.println(" ---For Circle---");
        Shape c = new Circle(2);
        c.calculateArea();
        c.calculatePerimeter();
        c.display(); 
        System.out.println();
        System.out.println();

        System.out.println(" ---For Cube---");
        Shape cu = new Cube(2);
        cu.calculateArea();
        cu.calculatePerimeter();
        cu.display(); 
        System.out.println();
        System.out.println();

        System.out.println(" ---r Square---");
        Shape s = new Squere(2);
        s.calculateArea();
        s.calculatePerimeter();
        s.display(); 
        System.out.println();
        System.out.println();
    }
    
} 
