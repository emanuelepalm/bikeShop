import people.Buyer;
import people.People;
import shop.BikeShop;
import veichles.Bike;
import checker.Checker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    Random random = new Random();
    Checker checker = new Checker();
    public Menu() {

    }
    public void menuInit() {
        BikeShop bikeshop = populate();
        menuStart(bikeshop);
    }
    public Buyer buyerPopulate(Menu menu) {
        String[] firstNameAr = {"Mario","Luca","Pippo","Riccardo","Antonio","Gerardo","Antonello","Peppino","Rosario","Mario","Celestino"};
        String[] lastNameAr = {"Rossi","Bianchi","Palmieri","Antonelli","Tiberio","Duvall","Bernini","Rodriguez","Panzerelli","Ricciardi","Smith"};
        Random random = new Random();
        int i = random.nextInt(11);
        String firstName = firstNameAr[i];
        i = random.nextInt(11);
        String lastName = lastNameAr[i];
        double wallet = ((double)random.nextInt(300));
        Bike wantedBike = menu.bikePopulate();
        Buyer buyer = new Buyer(firstName,lastName,wallet,wantedBike);
        return buyer;
    }
    public Bike bikePopulate() {
        String[] brandAr = {"Bianchi","Cinelli","Cipollini","De Rosa","Olmo","Thok","Torpado","Scout"};
            double price = ((double)random.nextInt(200) - 0.01);
            String name = brandAr[random.nextInt(8)];
            Bike bike = new Bike(name, price);

        return bike;
    }
    public ArrayList<Bike> bikePopulate(int num) {
        ArrayList<Bike> bikeAr = new ArrayList<Bike>(5);
        String[] brandAr = {"Bianchi","Cinelli","Cipollini","De Rosa","Olmo","Thok","Torpado","Scout"};
        for(int i = 0; i < num; i++) {
            Random random = new Random();
            double price = ((double)random.nextInt(200) - 0.01);
            String name = brandAr[random.nextInt(8)];
            bikeAr.add(new Bike(name, price));
        }
        return bikeAr;
    }
    public People ownerPopulate() {
        People owner = new People("Emanuele","Palmieri");
        return owner;
    }
    public BikeShop populate() {
        int num = 10;
        double register = 500.00;
        BikeShop bikeShop = new BikeShop(ownerPopulate(),bikePopulate(num),register,false);
        return bikeShop;
    }

    public void menuStart(BikeShop bikeShop) {
        System.out.println("Benvenuto " + bikeShop.getOwner().getFirstName() + "!");
        if(!bikeShop.isOpen()) {
            System.out.println("Il tuo negozio è chiuso.\nVuoi:  \nQualsiasi numero per Aprire\n0)Uscire");
            int choice = checker.nextInt();
            if(choice >= 1) {
                bikeShop.openShop(bikeShop.getOwner());
                menuStart(bikeShop);
            } else if(choice == 0) {
                System.out.println("Arrivederci!!!");
            } else {
                System.err.println("TASTO NON VALIDO!");
                menuStart(bikeShop);
            }
        } else {
            System.out.println("Il negozio è aperto.\nVuoi\n1)Chiudere\n0)Proseguire");
            int choice = checker.nextInt();
            if(choice >= 1) {
                bikeShop.closeShop(bikeShop.getOwner());
                menuStart(bikeShop);
            } else if(choice == 0) {
                mainMenu(bikeShop);
            } else {
                System.err.println("TASTO NON VALIDO!");
                menuStart(bikeShop);
            }
        }
    }
    public void mainMenu(BikeShop bikeShop) {
        System.out.println("Scegli l'operazione da eseguire\n1)Visualizza le bici in magazzino\n2)Visualizza i soldi in cassa \n3)Aggiungi bici al magazzino \n4)Vendi bici \n5)Chiudi il negozio e esci");
        int num = checker.nextInt();
        switch (num) {
            case 1:
                viewInStock(bikeShop);
                break;
            case 2:
                viewRegister(bikeShop);
                break;
            case 3:
                addBikes(bikeShop);
                break;
            case 4:
                sell(bikeShop);
                break;
            case 5:
                menuStart(bikeShop);
                break;
            case (-1):
                System.err.println("Tasto non Valido!!!\nInserire un numero por favor");
                mainMenu(bikeShop);
            default:
                System.err.println("Operazione non riconosciuta!!!");
                mainMenu(bikeShop);

        }

    }
    public void viewInStock(BikeShop bikeShop) {

    }
    public void viewRegister(BikeShop bikeShop) {
        double register = bikeShop.getRegister();
        System.out.println("La cassa contiene: " + register + " €.");
        mainMenu(bikeShop);
    }
    public void addBikes(BikeShop bikeShop) {

    }
    public void sell(BikeShop bikeShop) {

    }
}
