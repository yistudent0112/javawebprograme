package com.imooc.domain;

 class test {
     public int i=20;
     private  test t=new test();
   private test() {
	   
   }
   public void getA() {
	   System.out.println(t);
   }
   public void getI() {
	   System.out.println(this);
   }
     public static void main(String args[]) {
    	 test t=new test();
    	 t.getA();
    	 t.getI();
     }
}
