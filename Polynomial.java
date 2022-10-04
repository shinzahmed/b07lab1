package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Polynomial {
	double [] coeff;
	int [] corr_exp;
	
	public Polynomial() {
	
	}
	
	public Polynomial(double [] coefficients, int [] exp) {
		coeff = new double[coefficients.length];
		corr_exp = new int[exp.length];
		
		for(int i=0; i < this.coeff.length; i++)
			coeff[i] = coefficients[i];
		
		for(int i=0; i < this.corr_exp.length; i++)
			corr_exp[i] = exp[i];
		
	}
	//concat fn()
	public Polynomial concat(Polynomial poly) {
		int new_length = this.coeff.length + poly.coeff.length;
		
		double [] new_coeff;
		int [] new_exp;
		new_coeff = new double [new_length];
		new_exp = new int [new_length];
		
		for(int i=0; i<this.coeff.length; i++)
		{
			new_coeff[i] = this.coeff[i];
			new_exp[i] = this.corr_exp[i];
		}
		
		int k = this.coeff.length;
		for(int i= 0; i<poly.coeff.length; i++)
		{
			new_coeff[k] = poly.coeff[i];
			new_exp[k] = poly.corr_exp[i];
			k++;
		}
		Polynomial new_polynomial = new Polynomial(new_coeff, new_exp);
		return new_polynomial;
		
	}
	//add fn()
	public Polynomial add(Polynomial poly) {

		Polynomial neww = new Polynomial(poly.coeff, poly.corr_exp); 
		neww = concat(poly);
		
		for(int i=0; i<neww.corr_exp.length; i++){
			for(int j=i+1; j<neww.corr_exp.length; j++){
				if(neww.corr_exp[i]==neww.corr_exp[j]){
					neww.coeff[i]= neww.coeff[i]+neww.coeff[j];
					neww.corr_exp[j] = -1;
				}
			}
		}
		int c=0;
		for(int i=0; i<neww.corr_exp.length; i++)
		{
			if(neww.corr_exp[i]== -1)
				c++;
		}
		double [] latest_coeff;
		int [] latest_exp;
		int new_len = neww.corr_exp.length-c;
		latest_coeff = new double[new_len];
		latest_exp = new int[new_len];
		int ind=0;
		
		for(int i=0; i<neww.corr_exp.length; i++)
		{
			if(neww.corr_exp[i]!= -1)
			{
				latest_exp[ind]= neww.corr_exp[i];
				latest_coeff[ind]= neww.coeff[i];
				ind++;
			}
		}
		for(int i=0; i<new_len; i++) {
			if(latest_coeff[i]==0){
				latest_coeff[i]=-1;
			}
		}
		
		int ctr=0;
		for(int i=0; i<new_len; i++)
		{
			if(latest_coeff[i]== -1)
				ctr++;
		}
		double [] final_coeff;
		int [] final_exp;
		int final_len = new_len-ctr;
		final_coeff = new double[final_len];
		final_exp = new int[final_len];
		
		int final_ind=0;
		for(int i=0; i<latest_coeff.length; i++)
		{
			if(latest_coeff[i]!= -1)
			{
				final_exp[final_ind]= latest_exp[i];
				final_coeff[final_ind]= latest_coeff[i];
				final_ind++;
			}
		}
		
		Polynomial latest = new Polynomial(final_coeff, final_exp); 
		return latest;
	}
	//eval fn()
	public double evaluate(Polynomial poly, double val_x){
		double sum = 0;
		for(int i=0; i<this.coeff.length; i++) 
			sum += coeff[i]*Math.pow(val_x, this.corr_exp[i]);
		return sum;
	}
	//hasroot fn()
	public boolean hasRoot(double is_root, Polynomial poly) {
		if(evaluate(poly, is_root)==0)
			return true;
		else
			return false;
	}
	//add for multiply
	public Polynomial add_multiply(Polynomial poly) {
		for(int i=0; i<poly.corr_exp.length; i++){
			for(int j=i+1; j<poly.corr_exp.length; j++){
				if(poly.corr_exp[i]==poly.corr_exp[j]){
					poly.coeff[i]= poly.coeff[i]+poly.coeff[j];
					poly.corr_exp[j] = -1;
				}
			}
		}
		int c=0;
		for(int i=0; i<poly.corr_exp.length; i++)
		{
			if(poly.corr_exp[i]== -1)
				c++;
		}
		double [] latest_coeff;
		int [] latest_exp;
		int new_len = poly.corr_exp.length-c;
		latest_coeff = new double[new_len];
		latest_exp = new int[new_len];
		int ind=0;
		
		for(int i=0; i<poly.corr_exp.length; i++)
		{
			if(poly.corr_exp[i]!= -1)
			{
				latest_exp[ind]= poly.corr_exp[i];
				latest_coeff[ind]= poly.coeff[i];
				ind++;
			}
		}
		
		//////////////////
		for(int i=0; i<new_len; i++) {
			if(latest_coeff[i]==0){
				latest_coeff[i]=-1;
			}
		}
		
		int ctr=0;
		for(int i=0; i<new_len; i++)
		{
			if(latest_coeff[i]== -1)
				ctr++;
		}
		double [] final_coeff;
		int [] final_exp;
		int final_len = new_len-ctr;
		final_coeff = new double[final_len];
		final_exp = new int[final_len];
		
		int final_ind=0;
		for(int i=0; i<latest_coeff.length; i++)
		{
			if(latest_coeff[i]!= -1)
			{
				final_exp[final_ind]= latest_exp[i];
				final_coeff[final_ind]= latest_coeff[i];
				final_ind++;
			}
		}
		
		Polynomial finale = new Polynomial(final_coeff, final_exp);
		return finale;
	}
	//multiply fn()
	public Polynomial multiply(Polynomial poly) {
		
		double new_coeff [];
		int new_exp [];
		int len = this.coeff.length*poly.coeff.length;
		new_coeff = new double[len];
		new_exp = new int[len];
		
		int ind=0;
		for(int i =0; i<this.coeff.length; i++) {
			for(int j=0; j<poly.coeff.length; j++) {
				new_coeff[ind]= this.coeff[i]*poly.coeff[j];
				new_exp[ind]=this.corr_exp[i]+poly.corr_exp[j];
				ind++;
			}
		}
		
		
		
		Polynomial m_poly = new Polynomial(new_coeff, new_exp);
		Polynomial result = m_poly.add_multiply(m_poly);
				return result;
	}


	public Polynomial(File poly_file) throws FileNotFoundException {
		Scanner read_f =  new Scanner (poly_file);
		String read_line = read_f.nextLine();		
		String [] arr = read_line.split("((?=\\-)|(\\+))"); 

		coeff = new double[arr.length];
		corr_exp = new int[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			String c = "";
			String e = "";
			if(arr[i].contains("x") == false)
			{
				c+=arr[i];
				e+='0';
				double coef = Double.parseDouble(c);
				coeff[i] = coef;
				int ex = Integer.parseInt(e);
				corr_exp[i] = ex;
			}
			else {
				int j=0;
				if(arr[i].charAt(j) == 'x')
				{
					c+='1';				
				}
				while(arr[i].charAt(j) != 'x')
				{
					c += arr[i].charAt(j);				
					j++;
				}
				int k = j+1;
				while(k != arr[i].length())
				{
					e += arr[i].charAt(k);
					k++;
				}
				if(c.equals("-")) {
					c+='1';
				}
			
			}
			double coef = Double.parseDouble(c);
			coeff[i] = coef;
			int ex = Integer.parseInt(e);
			corr_exp[i] = ex;
			
		}
		
		
		read_f.close();
			
	}
	
	public void saveToFile(String file_name) throws FileNotFoundException {
		
		PrintStream f = new PrintStream(file_name);    	
    	for(int i=0; i<this.coeff.length; i++)
    	{
    		if(i==0) {
    			if(corr_exp[i] == 0) {
        			f.print(String.valueOf(coeff[i]));
        		}
        		else if(corr_exp[i] != 0) {
        			f.print(String.valueOf(coeff[i]) + "x" + String.valueOf(corr_exp[i]));    			
        			
        		}
    			
    		}
    		else if(i !=0)
    		{
//    			if((i+1<this.coeff.length) && coeff[i+1] >0) {
        
    		
    		if(corr_exp[i] == 0 && coeff[i]>0) {
    			f.print("+" + String.valueOf(coeff[i]));
    		}
    		else if(corr_exp[i] != 0 && coeff[i]>0) {
    			f.print("+" + String.valueOf(coeff[i]) + "x" + String.valueOf(corr_exp[i]));    			
    			
    		}
    		else if(corr_exp[i] != 0 && coeff[i]<0) {
    			f.print(String.valueOf(coeff[i]) + "x" + String.valueOf(corr_exp[i]));
    		}
    		   			
    		}
    		//f.println(String.valueOf(coeff[i]));
    	}
    		
    	f.close();
	}
		
		
}
	
	

//for(int j=0; j<arr[i].length(); j++)
//{
//	if((arr[i].contains("+")== false) & (arr[i].contains("-")== false))
//	{
//		
//		
//	}


