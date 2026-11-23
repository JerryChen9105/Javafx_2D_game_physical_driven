package javafx.test.workspace.folder.test;

import javafx.test.workspace.physic_engine.Vector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        Vector vct1 = Vector.of(1, 1);
        Vector vct2 = Vector.of(1, 2);
        Vector vct3 = Vector.of(2, 2);
        Vector vct4 = Vector.of(2, 1);
        Vector vct5 = Vector.of(1, 3);
        Vector vct6 = Vector.of(2, 3);
        Vector vct7 = Vector.of(3, 3);
        Vector vct8 = Vector.of(3, 2);
        Vector vct9 = Vector.of(3, 1);




        List<Vector> vctList = List.of(
                vct1,
                vct2, vct3, vct4,
                vct5, vct6, vct7, vct8, vct9
        );

        vctList.stream()
                .sorted(new Comparator<Vector>() {
                    @Override
                    public int compare(Vector o1, Vector o2) {
                        double diff = o1.getLen() - o2.getLen();
                        if (diff > 0) return 1;
                        else if (diff < 0) return -1;
                        else return 0;
                    }
                })
                .map(Vector::toString)
                .collect(Collectors.toList()).forEach(System.out::println);


        WeekDays day = WeekDays.SUN;
        if (day.isWeekend()) System.out.println("Weekend");

        Operation op = Operation.SUBTRACT;
        System.out.println(op.apply(2, 5));


        Comparator<String> strComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                boolean e1 = o1.isEmpty(), e2 = o2.isEmpty();
                if (!e1 && !e2) return 0;
                else if (e1 && !e2) return 1;
                else if (!e1 && e2) return -1;
                return o1.compareTo(o2);
            }
        };
    }


    public static int sum(int... numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static String concatenate(String separator, String... args) {
        return String.join(separator, args);
    }


}


