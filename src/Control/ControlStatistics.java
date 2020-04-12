package Control;

import Entity.Statistics;
import Entity.MostPopMeal;

public class ControlStatistics {
    //String name should be as same as Bill Entity's variable name
    public MostPopMeal getSelfMost(Statistics statistics, String string){
        MostPopMeal mostPopMeal = new MostPopMeal();
        int max = 0;
        string.toLowerCase();
        String s = "";

        if(string.equals("Soup")){
            // Use a,b and c to save the basic message of each choice.
            int a,b,c;
            a = statistics.getSoupTonkotsu();
            b = statistics.getSoupShio();
            c = statistics.getSoupShoyu();
            if(a >= max){
                max = a;
                s = "Tonkotsu";
            }
            if(b >= max){
                max = b;
                s = "Shio";
            }
            if(c >= max){
                max = c;
                s = "Shoyu";
            }
            if(a<max && b<max && c<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Noodles")) {
            // Use a,b and c to save the basic message of each choice.
            int a,b,c;
            a = statistics.getNoodleSoft();
            b = statistics.getNoodleMedium();
            c = statistics.getNoodleFirm();
            if(a >= max){
                max = a;
                s = "Soft";
            }
            if(b >= max){
                max = b;
                s = "Medium";
            }
            if(c >= max){
                max = c;
                s = "Firm";
            }
            if(a<max && b<max && c<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Spring onion")) {
            // Use a,b and c to save the basic message of each choice.
            int a,b,c;
            a = statistics.getOnionNo();
            b = statistics.getOnionLittle();
            c=statistics.getOnionLot();
            if(a >= max){
                max = a;
                s = "No-Please";
            }
            if(b >= max){
                max = b;
                s = "Little";
            }
            if(c >= max){
                max = c;
                s = "Lot";
            }
            if(a<max && b<max && c<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Nori")) {
            // Use a,b to save the basic message of each choice.
            int a,b;
            a = statistics.getNoriY();
            b = statistics.getNoriN();
            if(a >= max){
                max = a;
                s = "Add Nori";
            }
            if(b >= max){
                max = b;
                s = "No Nori Please";
            }
            if(a == b){
                s="Same Popular";
            }
            if(a<max && b<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Chashu")) {
            // Use a,b to save the basic message of each choice.
            int a,b;
            a = statistics.getChashuY();
            b = statistics.getChashuN();
            if(a >= max){
                max = a;
                s = "Add Chashu";
            }
            if(b >= max){
                max = b;
                s = "No Chashu Please";
            }
            if(a == b){
                s = "Same Popular";
            }
            if(a<max && b<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Boiled egg")) {
            // Use a,b to save the basic message of each choice.
            int a,b;
            a = statistics.getBoiledEggY();
            b = statistics.getBoiledEggN();
            if(a >= max){
                max = a;
                s = "Add Boiled Egg";
            }
            if(b >= max){
                max = b;
                s = "No Egg Please";
            }
            if(a == b){
                s = "Same Popular";
            }
            if(a<max && b<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Spiciness")) {
            // Use a,b,c,d,e,f to save the basic message of each choice.
            int a,b,c,d,e,f;
            a = statistics.getSpiciness0();
            b = statistics.getSpiciness1();
            c = statistics.getSpiciness2();
            d = statistics.getSpiciness3();
            e = statistics.getSpiciness4();
            f = statistics.getSpiciness5();

            if(a >= max){
                max=a;
                s="No Please";
            }
            if(b >= max){
                max = b;
                s = "Just Little";
            }
            if(c >= max){
                max = c;
                s = "A Little ";
            }
            if(d >= max){
                max = d;
                s = "Medium";
            }
            if(e >= max){
                max = e;
                s = "A Lot";
            }
            if(f >= max){
                max = f;
                s = "As Much As Possible";
            }
            if(a<max && b<max && c<max && d<max && e<max && f<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Extra Nori")) {
            // Use a,b to save the basic message of each choice.
            int a,b;
            a = statistics.getExtraNoriY();
            b = statistics.getExtraNoriN();
            if(a >= max){
                max = a;
                s = "Add extra Nori";
            }
            if(b >= max){
                max = b;
                s = "No Please";
            }
            if(a == b){
                s = "Same Popular";
            }
            if(a<max && b<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Extra boiled egg")) {
            // Use a,b to save the basic message of each choice.
            int a,b;
            a = statistics.getExtraBoiledEggY();
            b = statistics.getExtraBoiledEggN();
            if(a >= max){
                max = a;
                s = "Add Extra Egg";
            }
            if(b >= max){
                max = b;
                s = "No Please";
            }
            if(a == b){
                s = "Same Popular";
            }
            if(a<max && b<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else if(string.equals("Bamboo shoots")) {
            // Use a,b to save the basic message of each choice.
            int a,b;
            a = statistics.getBambooShootsY();
            b = statistics.getBambooShootsN();
            if(a >= max){
                max = a;
                s = "Add BambooShoots";
            }
            if(b >= max){
                max = b;
                s = "No Please";
            }
            if(a == b){
                s = "Same Popular";
            }
            if(a<max && b<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);

            return mostPopMeal;
        } else if(string.equals("Extra Chashu")) {
            // Use a,b to save the basic message of each choice.
            int a,b;
            a = statistics.getExtraChashuY();
            b = statistics.getExtraChashuN();
            if(a >= max){
                max = a;
                s = "Add extra Chashu";
            }
            if(b >= max){
                max = b;
                s = "No Please";
            }
            if(a == b){
                s = "Same Popular";
            }
            if(a<max && b<max){
                max = -1;
                s = "value error";
            }
            mostPopMeal.setValue(max);
            mostPopMeal.setName(s);
            return mostPopMeal;

        } else {
            mostPopMeal.setValue(-10);
            mostPopMeal.setName("error in input mealName");
            return mostPopMeal;
        }
    }
}
