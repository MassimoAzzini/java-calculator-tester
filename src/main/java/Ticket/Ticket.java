package Ticket;

public class Ticket {
    private final double priceKm = 0.21;
    private final double discountUnderage = 0.2;
    private final double discountOver65 = 0.4;

    private int kmTravel;
    private int ageUsers;

    private double finalPrice;

    public Ticket(int kmTravel, int ageUsers) throws IllegalArgumentException {
        if(kmTravel <= 0 || ageUsers <= 0) throw new IllegalArgumentException();
        this.kmTravel = kmTravel;
        this.ageUsers = ageUsers;
    }

    public double finalPrice (){

        double totalPrice = kmTravel * priceKm;

        if (ageUsers < 18){
            finalPrice = totalPrice - (totalPrice * discountUnderage);
            System.out.println("Il prezzo totale del biglietto è: " + finalPrice + "€");
            System.out.println("Hai ottenuto uno sconto MINORENNI pari al " + (int)(discountUnderage * 100) +"%");
        } else if (ageUsers >= 65){
            finalPrice = totalPrice - (totalPrice * discountOver65);
            System.out.println("Il prezzo totale del biglietto è: " + finalPrice + "€");
            System.out.println("Hai ottenuto uno sconto OVER65 pari al " + (int)(discountOver65 * 100) +"%");
        } else {
            finalPrice = totalPrice;
            System.out.println("Il prezzo totale del biglietto è: " + finalPrice + "€");
        }

        return finalPrice;
    }


}
