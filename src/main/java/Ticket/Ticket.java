package Ticket;

import java.math.BigDecimal;

public class Ticket {
    private final BigDecimal priceKm = new BigDecimal("0.21");
    private final BigDecimal discountUnderage = new BigDecimal("0.2").setScale(2,4);
    private final BigDecimal discountOver65 = new BigDecimal("0.4").setScale(2,4);

    private int kmTravel;
    private int ageUsers;

    private BigDecimal finalPrice;

    public Ticket(int kmTravel, int ageUsers) throws IllegalArgumentException {
        if(kmTravel <= 0 || ageUsers <= 0) throw new IllegalArgumentException();
        this.kmTravel = kmTravel;
        this.ageUsers = ageUsers;
    }

    public BigDecimal finalPrice (){

        BigDecimal totalPrice = new BigDecimal(kmTravel).multiply(priceKm);

        if (ageUsers < 18){
            finalPrice = totalPrice.subtract(totalPrice.multiply(discountUnderage));
            System.out.println("Il prezzo totale del biglietto è: " + finalPrice.setScale(2,4) + "€");
            System.out.println("Hai ottenuto uno sconto MINORENNI pari al " + discountUnderage.multiply(new BigDecimal(100)).setScale(0,2) +"%");
        } else if (ageUsers >= 65){
            finalPrice = totalPrice.subtract(totalPrice.multiply(discountOver65));
            System.out.println("Il prezzo totale del biglietto è: " + finalPrice.setScale(2,4) + "€");
            System.out.println("Hai ottenuto uno sconto OVER65 pari al " + discountOver65.multiply(new BigDecimal(100)).setScale(0,2) +"%");
        } else {
            finalPrice = totalPrice;
            System.out.println("Il prezzo totale del biglietto è: " + finalPrice.setScale(2,4) + "€");
        }

        return finalPrice.setScale(2,4);
    }


}
