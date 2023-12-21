package hw;

import java.util.ArrayList;
import java.util.Random;

public class Shop {

        public Shop(){
            buildCatalog();
        }
            //Building Catalog
        private ArrayList<LapTop> catalog = new ArrayList<>();
        
        private void buildCatalog(){
            int[] ram = {8,16,32,64};
            int[] storage = {128,256,512,1024,2048};
            String[] os = {"windows","ios","linux","ms-dos","temple-os"};
            String[] color = {"rose","red","violet","blue"};
            Random rand = new Random(1000);
            for (int i: ram){
                int price1 = (int)Math.pow(i, 0.7);
                for(int j: storage){
                    int price2 = (int)Math.log10(j)*price1;
                    for (String k: os){
                        int price3 = (int)(price2/Math.log(k.length())*10);
                        for (String l: color){
                            int price4 = price3*l.length();
                            catalog.add(new LapTop((int)(price4*(1-rand.nextInt(100)*1./1000.)),i, j, k, l));
                            catalog.get(catalog.size()-1).name = Integer.toString(catalog.get(catalog.size()-1).hashCode());
                    }
                }
            }
        }
        }

        public void search(){
            new Search(catalog).run();
        }

}
