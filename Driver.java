package lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Driver {
	public static void main ( String[] args) throws FileNotFoundException {

	double [] c1 = {3,2,-2};
    int [] c2 = {3,1,0};
    

    double [] c3 = {2,1,3};
    int [] c4 = {2,3,0};
    
  Polynomial p1 = new Polynomial(c1,c2);
  Polynomial p2 = new Polynomial(c3,c4);
  
  Polynomial s1 = p1.multiply(p2);
    
    double c5[] = {6,2,4,5};
    int c6[] = {3,2,1,4};

    double c7[] = {1,2,3};
    int c8[] = {5,3,1};
    
    
  Polynomial p3 = new Polynomial(c5, c6);
  Polynomial p4 = new Polynomial(c7,c8);
  
  Polynomial s2 = p3.multiply(p4);
    
//    
//		double c9[] = {2,-2};
//		int e9[] = {3,3};
//		
//		double c10[] = {-2,2};
//		int e10[] = {5,3};
//    
//		double c3[] = {1,2,3,4,5,6};
//        int e3[] = {2,2,2,2,2,2};
//
//        double c4[] = {1,3,4,5};
//        int e4[] = {1,0,4,2};
//		
//		double k1[] = {3,-2};
//        int e1[] = {3,2};
//
//        double k2[] = {-2,2};
//        int e2[] = {3,2};
////        
//    Polynomial p1 = new Polynomial(k1,e1);
//    Polynomial p2 = new Polynomial(k2,e2);
//    
//    Polynomial s1 = p1.multiply(p2);
//		double c1[]= {2,1,-1}, c2[] = {-1,-1};
//        int e1[]= {2,1,0}, e2[] = {1,0};


//    Polynomial p1=new Polynomial(c1, e1);
//    Polynomial p2=new Polynomial(c2, e2);
//
//
//    Polynomial p3=p1.multiply(p2);
//    for(int i=0; i<p3.coeff.length; i++) {
//
//        System.out.println(p3.coeff[i]);
//        System.out.println(p3.corr_exp[i]);
//    }
//
//    System.out.println(Arrays.toString(s1.coeff));
//    System.out.println(Arrays.toString(s1.corr_exp));
		
//		 double c1[]= {1}, c2[] = {-1};
//	        int e1[]= {1}, e2[] = {0};
//
//	        
//	        Polynomial p1=new Polynomial(c1, e1);
//	        Polynomial p2=new Polynomial(c2, e2);
//	        
//	        
//	        Polynomial p3=p1.add(p2);
	        //for(int i=0; i<p3.coeff.length; i++) {
	            
//	            System.out.println(p3.coeff[i]);    
//	            System.out.println(p3.corr_exp[i]); 
//	            System.out.println(Arrays.toString(p3.coeff));
//	            System.out.println(Arrays.toString(p3.corr_exp));
	            
	       // }
	        //System.out.println("sad");
		File t = new File("C:\\Users\\shinz\\eclipse-workspace\\B07demo\\abc.txt");
    		Polynomial file = new Polynomial(t);
	        file.saveToFile("C:\\Users\\shinz\\eclipse-workspace\\B07demo\\xyz.txt");
	        
	       // Polynomial file = new Polynomial(t);
	           for ( int i=0; i<file.coeff.length; i++) {
	               System.out.println(file.coeff[i]);

	           }
	           for ( int i=0; i<file.coeff.length; i++) {
	               System.out.println(file.corr_exp[i]);

	           }
	        
	        System.out.println(Arrays.toString(file.coeff));
            System.out.println(Arrays.toString(file.corr_exp));
//            
//           
//	        String s = "-5-5x+6x2";
//	        String[] c1 = {"-5", "-5x", "6x2"};
//			String [] neww = s.split("((?=\\-)|(\\+))"); 
//			System.out.println(Arrays.toString(neww));
//			
//			int num_terms=0;
//			for(int i=0; i<s.length(); i++)
//			{
//				if(s.charAt(i)== '+' || s.charAt(i)== '-')
//				{
//					num_terms++;
//				}
//			}
//			System.out.println("terms: " + num_terms);
//			double new_coeff [];
//			int new_exp [];
//			new_coeff = new double[num_terms];
//			new_exp = new int[num_terms];
//			
//			
//			if(s.contains("x")== false)
//			{
//				double val = Double.parseDouble(s);
//				new_coeff[0] = val;
//				new_exp[0] = 0;
//			}
//			
//			for(int i=0; i<num_terms; i++)
//			{
//				String c = "";
//				String e = "";
//				if(c1[i].contains("x")== false)
//				{
//					double val = Double.parseDouble(c1[i]);
//					new_coeff[i] = val;
//					new_exp[i] = 0;
//					
//					
//				}
//				else {
//					int j=0;			
//					while(c1[i].charAt(j) != 'x')
//					{
//						c += c1[i].charAt(j);				
//						j++;
//					}
//					
//					int k = j+1;
//					while(k != c1[i].length())
//					{
//						e += c1[i].charAt(k);
//						k++;
//					}	
////					
//					//double coef = Double.parseDouble(c);
////					new_coeff[i] = coef;
//					//int ex = Integer.parseInt(e);
////					new_exp[i] = ex;
//					System.out.println("c: " + c);
//					
//					System.out.println("e: " +e);
//				}
//				
//			}
			
			

	} }
	

    






