package Application;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;


public class Program {

	public static void main(String[] args) {

		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com os dados do aluguel");
		System.out.println("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm)");
		LocalDateTime start =LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Retorno (dd/MM/yyyy hh:mm)");
		LocalDateTime finish =LocalDateTime.parse(sc.nextLine(), fmt);
		
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.println("entre com preço por hora");
		double pricePerHour = sc.nextDouble();	
		System.out.println("entre com preço por dia");
		double pricePerDay = sc.nextDouble();	
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		
		System.out.println("FATUTA");
		System.out.println("Pagamento basico: "+ cr.getInvoice().getBasicPayment());
		System.out.println("Imposto:" + cr.getInvoice().getTax());
		System.out.println("Pagamento Total: "+ cr.getInvoice().getTotalPayment());
		
		
		
		
		
		sc.close();
		
		
	}

}
