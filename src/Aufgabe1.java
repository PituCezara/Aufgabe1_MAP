import java.util.*;
//Die Universität hat die folgende Regeln für die Benotung:
//        ● Jeder Student bekommt eine Note zwischen 0 und 100.
//        ● Eine Note weniger als 40 ist eine nicht ausreichende Note.
//        Der Professor rundet die Note mit den folgenden Regeln ab:
//        ● Wenn die Differenz zwischen der Note und dem nächsten Vielfachen (Multipel) von
//        5 weniger als 3 ist, dann wird die Note zu dem nächsten Vielfachen (Multipel) von 5
//        aufgerundet.
//        ● Wenn die Note weniger als 38 ist, wird die Note nicht aufgerundet.
//        z.B. 84 => 85
//        29 => 29
//        1. Schreiben Sie eine Methode, die ein Array von Noten bekommen soll. Als
//        Rückgabewert soll die Methode ein Array mit nicht ausreichender Note liefern.
//        2. Schreiben Sie eine Methode, die ein Array von Noten bekommen soll. Als
//        Rückgabewert soll die Methode den Durchschnittswert liefern.
//        3. Schreiben Sie eine Methode, die ein Array von Noten bekommen soll. Als
//        Rückgabewert soll die Methode ein Array mit die abgerundeten Noten liefern.
//        4. Schreiben Sie eine Methode, die ein Array von Noten bekommen soll. Als
//        Rückgabewert soll die Methode die maximal abgerundete Note liefern.
import java.util.stream.Collectors;

public class Aufgabe1 {

    // notele insuficiente (< 40)
    public static int[] insufficient(int[] grades) {
        return Arrays.stream(grades).filter(g -> g < 40).toArray();
    }

    //media aritmetica
    public static double average(int[] grades) {
        double sum = 0;
        for (int g : grades) sum += g;
        double avg = grades.length == 0 ? 0.0 : sum / grades.length;
        return Math.round(avg * 100.0) / 100.0;
    }

    //  rotunjire pentru o singura nota

    private static int roundOne(int g) {
        if (g < 38) return g;
        int nextMultiple5 = g + ((5 - (g % 5)) % 5);
        return (nextMultiple5 - g) < 3 ? nextMultiple5 : g;
    }

    // vectorul cu notele rotunjite
    public static int[] rounded(int[] grades) {
        int[] out = new int[grades.length];
        for (int i = 0; i < grades.length; i++) out[i] = roundOne(grades[i]);
        return out;
    }
}
