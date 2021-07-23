package machine;

public class Machine {
    private int waterQty;
    private int milkQty;
    private int beansQty;
    private int disposableCups ;
    private int money;
    enum State {CHOOSE_ACTION,CHOOSE_COFFEE,FILL_WATER, FILL_MILK, FILL_BEANS, FILL_CUPS};
    private State state = State.CHOOSE_ACTION;

    public Machine(int waterQty, int milkQty, int beansQty, int disposableCups, int money) {
        this.waterQty = waterQty;
        this.milkQty = milkQty;
        this.beansQty = beansQty;
        this.disposableCups = disposableCups;
        this.money = money;
    }
    public State getState(){
        return state;
    }

    public void processInput(String input){
        switch (state){
            case CHOOSE_ACTION:
                performMenuFunction(input);
                break;
            case CHOOSE_COFFEE:
                buyCoffee(input);
                break;
            case FILL_WATER:
            case FILL_MILK:
            case FILL_BEANS:
            case FILL_CUPS:
                fill(input);
                break;
            default:
                break;
        }
    }

    private void performMenuFunction(String action){
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                this.state = State.CHOOSE_COFFEE;
                break;
            case "fill":
                fill(action);
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printStatus();
                break;
            default:
                System.out.println("Unsuitable action, please re-enter action...");
        }
    }

    private void printStatus(){
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(this.waterQty + " ml of water");
        System.out.println(this.milkQty + " ml of milk");
        System.out.println(this.beansQty + " g of coffee beans");
        System.out.println(this.disposableCups + " disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }

    private void takeMoney(){
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    private void fill(String input){
        switch (state){
            case CHOOSE_ACTION:
                System.out.println("Write how many ml of water you want to add: ");
                this.state = State.FILL_WATER;
                break;
            case FILL_WATER:
                this.waterQty = waterQty + Integer.parseInt(input);
                System.out.println("Write how many ml of milk you want to add:");
                this.state = State.FILL_MILK;
                break;
            case FILL_MILK:
                this.milkQty = milkQty + Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans you want to add:");
                this.state = State.FILL_BEANS;
                break;
            case FILL_BEANS:
                this.beansQty = beansQty + Integer.parseInt(input);
                System.out.println("Write how many disposable cups of coffee you want to add:");
                this.state = State.FILL_CUPS;
                break;
            case FILL_CUPS:
                this.disposableCups = disposableCups + Integer.parseInt(input);
                this.state = State.CHOOSE_ACTION;
                break;
            default:
                System.out.println("How did you get here..?");
                this.state = State.CHOOSE_ACTION;
                break;
        }
    }

    private void buyCoffee(String selection){
        switch (selection) {
            case "1":
                //espresso
                if(waterQty>=250 && beansQty>=16 && disposableCups>=1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterQty = waterQty - 250;
                    beansQty = beansQty - 16;
                    money = money + 4;
                    disposableCups--;
                }else{
                    if(waterQty<250){
                        System.out.println("Sorry, not enough water!");
                    }else if(beansQty<16){
                        System.out.println("Sorry, not enough coffee beans!");
                    }else{
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "2":
                //latte
                if(waterQty>=350 && milkQty >=75 && beansQty>=20 && disposableCups>=1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterQty = waterQty - 350;
                    milkQty = milkQty - 75;
                    beansQty = beansQty - 20;
                    money = money + 7;
                    disposableCups--;
                }else{
                    if(waterQty<350){
                        System.out.println("Sorry, not enough water!");
                    }else if(milkQty<75){
                        System.out.println("Sorry, not enough milk!");
                    }else if(beansQty<20){
                        System.out.println("Sorry, not enough coffee beans!");
                    }else{
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "3":
                //cappuccino
                if(waterQty>=200 && milkQty >=100 && beansQty>=12 && disposableCups>=1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterQty = waterQty - 200;
                    milkQty = milkQty - 100;
                    beansQty = beansQty - 12;
                    money = money + 6;
                    disposableCups--;
                }else{
                    if(waterQty<200){
                        System.out.println("Sorry, not enough water!");
                    }else if(milkQty<100){
                        System.out.println("Sorry, not enough milk!");
                    }else if(beansQty<12){
                        System.out.println("Sorry, not enough coffee beans!");
                    }else{
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Unsuitable selection, returning to main menu...");
        }
        state = State.CHOOSE_ACTION;
    }
}























