package day3;

public class CarModel {

		class CarDetails {
			private String model;
			private int year;
			
			public void setModel(String model,int year) {
				this.model = model;
				this.year = year;
			}
			
			public String getModel() {
				return model;
			}
			public int getYear() {
				return year;
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarModel c1 = new CarModel();
		CarDetails car = c1.new CarDetails();
		car.setModel("BMW", 2000);
		System.out.println("Model name is: "+ car.getModel());
		System.out.println("Year is: "+ car.getYear());
	}
}
