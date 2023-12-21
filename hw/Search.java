package hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Search {
    HashMap<String,Object> filters = new HashMap<>();
    public Search(ArrayList<LapTop> catalog){
        this.catalog = catalog;
        this.sample = (ArrayList<LapTop>)catalog.clone();
    }
    ArrayList<LapTop>catalog;
    ArrayList<LapTop>sample;
    
    private void addFilter(){

        sample = filter(catalog);
        LapTop dummy = new LapTop(0, 0, 0, null, null);
        System.out.println("Chose a filter: " + dummy.GetSpec().keySet());
        String criteria = new Input().c.nextLine();
        if(dummy.GetSpec().keySet().contains(criteria)){
            if (dummy.GetSpec().get(criteria) instanceof Integer){
                Integer[] filter = new Integer[]{-1,-1};
                filters.put(criteria, filter);
                Integer min_value = Integer.MAX_VALUE;
                Integer max_value = Integer.MIN_VALUE;

                filters.remove(criteria);
                sample = filter(catalog);
                if (isNoLapTops()) return;
                for(LapTop lt: sample){
                    Integer checked = (Integer)lt.GetSpec().get(criteria);
                    if (checked < min_value){
                        min_value = checked;
                    }
                    else if(checked > max_value){
                        max_value = checked;
                    }
                }
                
                System.out.print("Enter min value from "+min_value+" to " + max_value + ": ");
                filter[0] = new Input().c.nextInt();
                min_value = filter[0];
                if (min_value > max_value) {
                    System.out.println("Something went wrong");
                    run();
                    return;
                }
                System.out.print("Enter max value from "+min_value+" to "+max_value+": ");
                filter[1] = new Input().c.nextInt();
                max_value = filter[1];
                if(max_value < min_value){
                    System.out.println("Something went wrong");
                    run();
                    return;
                }
                filters.put(criteria, filter);
            }
            else
            {   
                ArrayList<String> temp_memo = (ArrayList<String>)filters.get(criteria);
                filters.remove(criteria);
                sample = filter(catalog);
                if (isNoLapTops()) return;
                HashSet<String> options = new HashSet();
                for(LapTop lt: sample){
                    options.add((String)lt.GetSpec().get(criteria));
                }
                System.out.print("Enter a value, you can remove a filter by reentering it, Available options: "+ options + " current_filters: "+ temp_memo + " Enter cancel to cancel: \n");
                filters.put(criteria, temp_memo);
                String value = new Input().c.nextLine();
                filters.putIfAbsent(criteria, new ArrayList<String>());
                ArrayList<String> filter = (ArrayList<String>)filters.get(criteria);
                if (filter.contains(value)){
                    filter.remove(value);
                }
                else if (options.contains(value)){
                    filter.add(value);
                }
                else System.out.println("No such " + criteria + " found.");
                if (filter.isEmpty()) filters.remove(criteria);
            }
        }
        else{
            System.out.println("No criteria matches\n");
        }
        run();
    }


    public void printFilters()
    {
        String repr = "";
        for(String f: filters.keySet()){
            if (filters.get(f) instanceof Integer[]){
                repr += f + " : " + Arrays.deepToString((Integer[])filters.get(f)) + "\n"; 
            }
            else repr += f + " : " + filters.get(f).toString() + "\n"; 
        }
        System.out.println(repr);
    }

    public ArrayList<LapTop> filter(ArrayList<LapTop> catalog){
        ArrayList<LapTop> filtered = (ArrayList<LapTop>) catalog.clone();
            for(String filter: filters.keySet()){
                for(int i = filtered.size()-1; i>= 0;i--)
                {
                    HashMap<String,Object> checked = filtered.get(i).GetSpec();
                    if (checked.get(filter) instanceof Integer)
                        {
                            Integer feature = (Integer)checked.get(filter);
                            Integer[] f_values = (Integer[])filters.get(filter);
                            if(feature < f_values[0] || feature > f_values[1]){
                                filtered.remove(i);
                            }
                        }
                    else{
                        String feature = (String)checked.get(filter);
                        ArrayList<String> f_values = (ArrayList<String>)filters.get(filter);
                        if(f_values.contains(feature) == false)
                        {
                            filtered.remove(i);
                        }
                    }
                }
            }
            return filtered;
        }


        public void run()
        {
        int ans = 0;
        while(ans != 2){
        System.out.println("Add/modify a filter? 1 - yes, 2 - Exit, 3 - show current filters, 4 - show available LapTops");
        try{
        ans =  new Input().c.nextInt();
        if (ans == 1) {addFilter();return;}
        if (ans == 3) printFilters();
        if (ans == 4)   {
            sample = filter(catalog);
            if (isNoLapTops()) return;
            System.out.println(new Sample(sample));
        }
        }
     catch (Exception e){System.out.println("Something went wrong\n");
}
    }
    }


    public boolean isNoLapTops()
    {
        if (sample.isEmpty()== true){
            System.out.println("No LapTops are available - remove some filters");
            run();
            return true;
        }
        return false;
    }
}

        


    

