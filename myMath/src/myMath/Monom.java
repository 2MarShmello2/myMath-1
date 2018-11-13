
package myMath;

import java.util.Iterator;

import javax.management.RuntimeErrorException;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as:
 *  construction, value at x, derivative, add and multiply. 
 * @author oren zauda and omer zohar
 * 
 *
 */

public class Monom implements function{

	// ***************** add your code below **********************
/**
 * constrction
 */
	public Monom() {
		this._coefficient=0;
		this._power=0;
	}
	/**
	 * constrction
	 * @param a- coeeficient
	 * 
	 * @param b- power of x
	 */

	public Monom(double a, int b){
		this.set_coefficient(a);//setting coeefficien
		this.set_power(b);//setting power
		if (b<0) throw new RuntimeErrorException(null, "Err wrong value");
	}
	/**
	 * copy construction
	 * @param ot-another Monom we want to copy
	 */
	public Monom(Monom ot) {
		this._coefficient=ot._coefficient;
		this._power=ot._power;

	}
	/**calculating function in point x
	 * @param x is point in the graph
	 */

	public double f(double x) {
		return(this._coefficient*Math.pow(x,this._power));}
/**
 * adding functuion
 * @param a Another Monom to add to our Monom
 */
	public void add(Monom a){
		if (this._power==a.get_power()) {
			this._coefficient=this._coefficient+a.get_coefficient();
		}
	}

	/**
	 * multoplyn function
	 * @param a another monom to multiply
	 */
	public void Multiply(Monom a) {
		this._coefficient=this._coefficient*a.get_coefficient();
		this._power=this._power+a.get_power();
	} 
	/**
	 * derivating functipn
	 */

	public void derivative() {
		this._coefficient=this._coefficient*this._power;
		this._power=this._power-1;
	}
    /**
     * 
     * @param a monom which is might be equal to this monom
     * @return true if equal false if not
     */
	public boolean Equal(Monom a) {
		if(this._coefficient==a.get_coefficient()
				&&this._power==a.get_power()) {
			return true;
		}
		else return false;
	}
	/**stringing function
	 * @return string repsent monom
	 */

	public String toString() {
		String t="";
		t=_coefficient+"x^"+_power+ " ";	
		return t;
	}
	/**
	 * constructor use string
	 * @param s is Monom wrote by string
	 */
	public Monom (String s) {
		char t[]=new char[s.length()];
		t=s.toCharArray();
		int j=-1;
		for(int i=0;i<t.length;i++) {
			if (t[i]=='x'||t[i]=='X'){
				j=i;
			}
		}
		if(j==-1) {
			//number such 3
			this._coefficient=Double.parseDouble(s);
			this._power=0;
		}

		else {
			//number such 3x
			if(j==t.length-1) {
				String h=s.substring(0,t.length-1);
				this._coefficient=Double.parseDouble(h);
				this._power=1;
			}
			//Monom such x^3/-x^3
			if(j==0||j==1) {
				this._coefficient=Double.parseDouble(s.substring(0,j));
				this._power=Integer.parseInt(s.substring(3));
			}
			else {//such as x^7
				if(s.contains("^")) {
				String y=s.substring(0,j);
				String x=s.substring(j+2);
				double a=Double.parseDouble(y);
				int b=Integer.parseInt(x);
				this._coefficient=a;
				this._power=b;
				}
				else {
					String y=s.substring(0,j);
					double a=Double.parseDouble(y);
					this._coefficient=a;
					this._power=1;

				}
			}
		}


	}


	//****************** Private Methods and Data *****************

	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		this._power = p;
	}

	int get_power() {
		return this._power;
	}

	double get_coefficient() {
		return this._coefficient;
	}




	private double _coefficient; // 
	private int _power; 


	public static void main(String args[]) {

		// checking initial methods, null constructor
		// parameters constructor, and copy constructor- clear!
		/*
    Monom a= new Monom();
    System.out.println("a: co= "+a._coefficient+", p= "+a._power);
    Monom b= new Monom (3,2);
    System.out.println("b: co= "+b._coefficient+", p= "+b._power);
    Monom c= new Monom (3,-1);
    Monom d= new Monom (a);
    System.out.println("d: co= "+d._coefficient+", p= "+d._power);
		 */

		//cheking method f, value at x - clear!
		/*
	Monom e= new Monom (4,4);
	System.out.println(e.f(1));
		 */

		//checking add function - clear!
		/*
	Monom f= new Monom (3,2);
	Monom g=new Monom (2,2);
	Monom h= new Monom (3,1);
	f.add(g);
	System.out.println("f+g: co= "+ f._coefficient+" p= "+f._power);
	f.add(h);
	System.out.println("f+h: co="+f._coefficient+"po= "+f._power );

		 */

		//checking multiply function- clear!
		/*
	Monom i= new Monom (3,2);
	Monom j= new Monom (2,2);
	i.Multiply(j);
	System.out.println("i co= "+i._coefficient+"po= "+ i._power);
		 */

		// checking derivative function - clear!
		/*
    Monom k = new Monom (4,4);
    k.derivative();
    System.out.println("derivatived k: co= "+k._coefficient+" po= "+k._power);
		 */
		//checking equal function- clear!
		/*
		Monom t = new Monom (6,9); 
		Monom c = new Monom (6,9); 
        System.out.println(t.Equal(c));
		 */
		//checking function toString-clear!
		
		Monom t = new Monom ("3x^1"); 
		System.out.println(t.get_coefficient()+" "+t.get_power());
		System.out.println(t.toString());
		
	}
}
