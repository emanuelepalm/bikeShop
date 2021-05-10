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
    public Buyer buyerPopulate(    ) {
        String[] firstNameAr = {"Mario","Luca","Pippo","Riccardo","Antonio","Gerardo","Antonello","Peppino","Rosario","Mario","Celestino"};
        String[] lastNameAr = {"Rossi","Bianchi","Palmieri","Antonelli","Tiberio","Duvall","Bernini","Rodriguez","Panzerelli","Ricciardi","Smith"};
        Random random = new Random();
        int i = random.nextInt(11);
        String firstName = firstNameAr[i];
        i = random.nextInt(11);
        String lastName = lastNameAr[i];
        int rand = random.nextInt(300);
        double wallet = ((double)rand);
        Bike wantedBike = bikePopulate();
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
        ArrayList<Bike> bikeAr = new ArrayList<Bike>(num);
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
            System.out.println("Il tuo negozio è chiuso.\nVuoi:  \nTasto Qualsiasi)Aprire\n0)Uscire");
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
            System.out.println("Il negozio è aperto.\nVuoi\nTasto Qualsiasi)Proseguire\n0)Chiudere");
            int choice = checker.nextInt();
            if(choice >= 1) {
                mainMenu(bikeShop);
            } else if(choice == 0) {
                bikeShop.closeShop(bikeShop.getOwner());
                menuStart(bikeShop);
            } else {
                System.err.println("TASTO NON VALIDO!");
                menuStart(bikeShop);
            }
        }
    }
    public void mainMenu(BikeShop bikeShop) {
        System.out.println("Scegli l'operazione da eseguire\n1)Visualizza le bici in magazzino\n2)Visualizza i soldi in cassa \n3)Aggiungi bici al magazzino \n4)Vendi bici\n5)Fai un giro in bici \n6)Ripara le biciclette \n7)Chiudi il negozio e esci");
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
                ride(bikeShop);
                break;
            case 6:
                repair(bikeShop);
                break;
            case 7:
                menuStart(bikeShop);
                break;
            case (-1):
                System.err.println("Tasto non Valido!!!\nInserire un numero");
                mainMenu(bikeShop);
            default:
                System.err.println("Operazione non riconosciuta!!!");
                mainMenu(bikeShop);

        }

    }
    public void viewInStock(BikeShop bikeShop) {
        ArrayList <Bike> inStock = bikeShop.getInStock();
        System.out.println("Bici in magazzino: " +inStock.size());
        for (Bike bike: inStock) {
            System.out.println("Nome :" + bike.getName());
            System.out.println("Prezzo :"+ bike.getPrice());
            if(bike.checkState()) {
                System.out.println("OK!");
            } else {
                System.out.println("Da Riparare!");
            }
        }
        mainMenu(bikeShop);
    }
    public void viewRegister(BikeShop bikeShop) {
        double register = bikeShop.getRegister();
        System.out.println("La cassa contiene: " + register + " €.");
        mainMenu(bikeShop);
    }
    public void addBikes(BikeShop bikeShop) {
        System.out.println("Vuoi Aggiungere:\n1)Una Bici Manualmente\n2)Una o più bici generate automaticamente\n0)Tornare al Menu");
        int choice = checker.nextInt();
        switch (choice) {
            case 1:
                insertBike(bikeShop);
                break;
            case 2:
                System.out.println("Quante bici vuoi inserire?");
                int num = checker.nextInt();
                if(num<=0) {
                    System.err.println("ERRORE!\nTasto inserito non valido!!!");
                    addBikes(bikeShop);
                } else {
                    System.out.println("Generazione " + num + " bici in corso");
                    for(int i = 0; i <= num; i++) {
                        bikeShop.getInStock().add(bikePopulate());
                        System.out.println("--------------------------------------");
                    }
                    System.out.println("Inserimento effettuato!\n");
                    mainMenu(bikeShop);
                }
                break;
            case 0:
                mainMenu(bikeShop);
                break;
            case -1:
                System.err.println("Tasto non Valido!!!\nInserire un numero");
                addBikes(bikeShop);
                break;
            default:
                System.err.println("Operazione non riconosciuta!!!");
                addBikes(bikeShop);
        }

    }
    public void insertBike (BikeShop bikeShop) {
        boolean readyToMove = false;
        System.out.println("Inserisci il nome del modello di bici da inserire");
        String name = checker.nextLn();
        System.out.println("Inserisci il prezzo");
        double price = checker.nextDouble();
        System.out.println("La bici è funzionante o è da riparare?\nTasto qualsiasi)Funzionante\n0)Da riparare");
        int nextInt = checker.nextInt();
        if(nextInt > 0) {
            readyToMove = true;
        } else if(nextInt == 0) {
            readyToMove = false;
        } else {
            System.err.println("Tasto non valido!");
            insertBike(bikeShop);
        }
        bikeShop.getInStock().add(new Bike(name, price , readyToMove));
        System.out.println("Bici inserita\nVuoi inserirne un'altra?\n0)Si\nTasto qualsiasi)No");
        nextInt = checker.nextInt();
        if(nextInt > 0) {
            mainMenu(bikeShop);
        } else if(nextInt == 0) {
            addBikes(bikeShop);
        } else {
            System.err.println("Tasto non valido!");
            mainMenu(bikeShop);
        }


    }
    public void sell(BikeShop bikeShop) {
        Buyer customer = buyerPopulate();
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " è entrato nel negozio!");
        System.out.println(customer.getFirstName() + " vuole una " +customer.getWantedBike().getName());
        if(customer.pay(bikeShop)) {
            System.out.println("La bici costa " + customer.getWantedBike().getPrice() + " € e " + customer.getLastName() + "ha " + customer.getWallet() + " € nel portafoglio");
            System.out.println("Vendita effettuata con successo!");
        } else {
            System.out.println("La bici costa " + customer.getWantedBike().getPrice() + " € ma " + customer.getLastName() + "ha " + customer.getWallet() + " € nel portafoglio");
            System.out.println("Vendita fallita!");
        }
        System.out.println("Vuoi far entrare un altro cliente nel negozio?\n0)NO\nTASTO QUALSIASI)SI");
        int num = checker.nextInt();
        if(num == 0) {
            mainMenu(bikeShop);
        }   else {
            sell(bikeShop);
        }
    }
    public void ride(BikeShop bikeShop) {
        System.out.println("Scegli una bici: ");
        int num = checker.nextInt();
        if(num <= bikeShop.getInStock().size()) {
            Bike bike = bikeShop.getInStock().get(num);
            if(bike.getReadyToMove()) {
                System.out.println("Scegli la marcia:\n(Un numero da 1 a 7)");
                int speed = checker.nextInt();
                System.out.println("Quante pedalate?");
                int pedal = checker.nextInt();
                int distance = bike.pedal(pedal, speed);
                if(distance >= 0) {
                    System.out.println("Distanza percorsa: " + distance + " cm!");
                    bikeShop.getInStock().get(num).setReadyToMove(false);
                    System.out.println("La bici non sembra essere in ottime condizioni dopo il giro");
                } else {
                System.out.println("La marcia non esiste o hai provato a pedalare al contrario!");
                }
                System.out.println("Un altro giro?\nTASTO QUALSIASI)SI\n0)NO");
                num = checker.nextInt();
                if(num == 0) {
                    mainMenu(bikeShop);
                } else {
                    ride(bikeShop);
                }
            } else {
                System.out.println("Le condizioni di questa bici non permettono di farci un giro\nRiparala o scegline un'altra");
                ride(bikeShop);
            }
        } else {
            System.out.println("NON C'E' NESSUNA BICI IN QUESTO POSTO!");
            ride(bikeShop);
        }
    }
    public void repair(BikeShop bikeShop) {
        ArrayList<Bike> inStock = bikeShop.getInStock();
        for(int i = 0; i < inStock.size(); i++) {
            if(!inStock.get(i).getReadyToMove()) {
                System.out.println(inStock.get(i).getName() + " da riparare!\nTASTO QUALSIASI)Ripara\n0)Lascia stare");
                int num = checker.nextInt();
                if(num!=0) {
                    inStock.get(i).setReadyToMove(true);
                    System.out.println("Bici riparata!");
                }
            }
        }
        mainMenu(bikeShop);
    }
}
