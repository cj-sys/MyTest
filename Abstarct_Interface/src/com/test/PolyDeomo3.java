package com.test;

interface I2{
	public String A();
}
interface I3{
	public String B();
}
class D implements I2,I3{
	@Override
	public String B() {
		return "B";
	}
	@Override
	public String A() {
		return "A";
	}
}

public class PolyDeomo3 {
	public static void main(String[] args) {
		D d = new D();
		I2 di2 = new D();
		I3 di3 = new D();
		
		d.A();
		d.B();
		
		di2.A();
		//di2.B();
		
		//di3.A();
		di3.B();
	}

}
