public class Polynomial {
	double [] coeff;
	
	public Polynomial() {
		coeff = new double[1];
	}
	
	public Polynomial(double [] arr_8) {
		coeff = new double[arr_8.length];
		for(int i=0; i < this.coeff.length; i++)
			coeff[i] = arr_8[i];
	}
	public Polynomial add(Polynomial poly) {
		
		int min = Math.min(this.coeff.length, poly.coeff.length);
		int max = Math.max(this.coeff.length, poly.coeff.length);
		
		double [] sum_array = new double[max];		
		
		
		for(int i=0; i<min; i++){
			sum_array[i] = this.coeff[i]+ poly.coeff[i];
		}
		if(this.coeff.length > poly.coeff.length) {
			for(int i=min; i<max; i++){				
				sum_array[i] = this.coeff[i];
			}
		}
		else
			for(int i=min; i<max; i++){
				sum_array[i] = poly.coeff[i];
				}
		
		Polynomial new_polynomial = new Polynomial(sum_array);
		
		return new_polynomial;
	}
	
	public double evaluate(double val_x){
		double sum = 0;
		for(int i=0; i<this.coeff.length; i++) 
			sum += coeff[i]*Math.pow(val_x, i);
		return sum;
	}
	
	public boolean hasRoot(double is_root) {
		if(evaluate(is_root)==0)
			return true;
		else
			return false;
	}
	
	
}