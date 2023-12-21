package hw;
import java.util.ArrayList;

    public class Sample {
        ArrayList<LapTop> catalog = new ArrayList<>();

        public Sample (ArrayList<LapTop> catalog){
            this.catalog = catalog;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            String to_string = "";
            for(LapTop lt: catalog){
                to_string += lt.toString() + "\n";
            }
            return to_string;
        }
}
