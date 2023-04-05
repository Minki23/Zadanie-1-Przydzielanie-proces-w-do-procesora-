import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Proces> TestProcesowFIFO = new ArrayList<>();
        TestProcesowFIFO.add(new Proces(1,10,5));
        TestProcesowFIFO.add(new Proces(2,21,8));
        TestProcesowFIFO.add(new Proces(3,19,4));
        TestProcesowFIFO.add(new Proces(4,8,2));
        TestProcesowFIFO.add(new Proces(5,7,12));
        ArrayList<Proces> TestProcesowSJFW = new ArrayList<>();
        TestProcesowSJFW.add(new Proces(1,10,5));
        TestProcesowSJFW.add(new Proces(2,21,8));
        TestProcesowSJFW.add(new Proces(3,19,4));
        TestProcesowSJFW.add(new Proces(4,8,2));
        TestProcesowSJFW.add(new Proces(5,7,12));
        ArrayList<Proces> TestProcesowSJFN = new ArrayList<>();
        TestProcesowSJFN.add(new Proces(1,10,5));
        TestProcesowSJFN.add(new Proces(2,21,8));
        TestProcesowSJFN.add(new Proces(3,19,4));
        TestProcesowSJFN.add(new Proces(4,8,2));
        TestProcesowSJFN.add(new Proces(5,7,1));
        TestProcesowSJFN.add(new Proces(1,10,3));
        TestProcesowSJFN.add(new Proces(2,21,6));
        TestProcesowSJFN.add(new Proces(3,50,4));
        TestProcesowSJFN.add(new Proces(4,8,2));
        TestProcesowSJFN.add(new Proces(5,7,19));
        ArrayList<Proces> TestProcesowRR = new ArrayList<>();
        TestProcesowRR.add(new Proces(1,10,5));
        TestProcesowRR.add(new Proces(2,21,8));
        TestProcesowRR.add(new Proces(3,19,4));
        TestProcesowRR.add(new Proces(4,8,2));
        TestProcesowRR.add(new Proces(5,7,12));


        System.out.println("Przeprowadzam test wstepny");
        System.out.println("Wynik Fifo:"+FIFO(TestProcesowFIFO));
        System.out.println("Wynik SJF bez wywlaszczenia:"+SJF_niewywlaszczone(TestProcesowSJFN));
        System.out.println("Wynik SJF z wywlaszczeniem:"+SJF_wywlaszczone(TestProcesowSJFW));
        int zmiana1=100;
        System.out.println("Wynik RR z interwalem"+zmiana1+": "+rotacyjny(TestProcesowRR,zmiana1));
        int wybor = 1;
        int liczbaTestow;
        int liczbaProcesowNaTest;
        Scanner skaner = new Scanner(System.in);
        while (wybor!=0){
            int czas = 0;
            System.out.println("""
                    Menu
                    1. FIFO
                    2. SJF bez wywlaszczenia
                    3. SJF z wywlaszczniem
                    4. Rotacyjne
                    5. Wyjdź
                    """);
            wybor = skaner.nextInt();
            switch (wybor) {
                case 1 -> {
                    System.out.println("Ile przeprowadzic testow?");
                    try {
                        liczbaTestow = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe testow na 10");
                        liczbaTestow = 10;
                    }
                    System.out.println("Ile procesow na test?");
                    try {
                        liczbaProcesowNaTest = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe procesow na 10");
                        liczbaProcesowNaTest = 10;
                    }
                    for (int i = 0; i < liczbaTestow; i++) {
                        ArrayList<Proces> procesy = new ArrayList<>();
                        System.out.println("Test nr:"+(i+1));
                        for (int j = 0; j < liczbaProcesowNaTest; j++) {
                            procesy.add(new Proces(i));
                        }
                        czas += FIFO(procesy);
                    }
                    System.out.println("Sredni czas na proces FIFO wynosi: " + czas / liczbaTestow);
                }
                case 2 -> {
                    System.out.println("Ile przeprowadzic testow?");
                    try {
                        liczbaTestow = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe testow na 10");
                        liczbaTestow = 10;
                    }
                    System.out.println("Ile procesow na test?");
                    try {
                        liczbaProcesowNaTest = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe procesow na 10");
                        liczbaProcesowNaTest = 10;
                    }
                    for (int i = 0; i < liczbaTestow; i++) {
                        ArrayList<Proces> procesy = new ArrayList<>();
                        System.out.println("Test nr:"+(i+1));
                        for (int j = 0; j < liczbaProcesowNaTest; j++) {
                            procesy.add(new Proces(i));
                        }
                        czas += SJF_niewywlaszczone(procesy);
                    }
                    System.out.println("Sredni czas na proces SJF bez wywlaszczenia wynosi: " + czas / liczbaTestow);
                }
                case 3 -> {
                    System.out.println("Ile przeprowadzic testow?");
                    try {
                        liczbaTestow = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe testow na 10");
                        liczbaTestow = 10;
                    }
                    System.out.println("Ile procesow na test?");
                    try {
                        liczbaProcesowNaTest = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe procesow na 10");
                        liczbaProcesowNaTest = 10;
                    }
                    for (int i = 0; i < liczbaTestow; i++) {
                        System.out.println("Test nr:"+(i+1));
                        ArrayList<Proces> procesy = new ArrayList<>();
                        for (int j = 0; j < liczbaProcesowNaTest; j++) {
                            procesy.add(new Proces(i));
                        }
                        czas += SJF_wywlaszczone(procesy);
                    }
                    System.out.println("Sredni czas na proces SJF z wywlaszczeniem wynosi: " + czas / liczbaTestow);
                }
                case 4 -> {
                    int zmiana;
                    System.out.println("Ile przeprowadzic testow?");
                    try {
                        liczbaTestow = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe testow na 10");
                        liczbaTestow = 10;
                    }
                    System.out.println("Ile procesow na test?");
                    try {
                        liczbaProcesowNaTest = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam liczbe procesow na 10");
                        liczbaProcesowNaTest = 10;
                    }
                    System.out.println("Jaka ma byc dlugosc interwalu?");
                    try {
                        zmiana = skaner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wprowadzono bledne dane, ustawiam interwal na 10");
                        zmiana=10;
                    }
                    for (int i = 0; i < liczbaTestow; i++) {
                        System.out.println("Test nr:"+(i+1));
                        ArrayList<Proces> procesy = new ArrayList<>();
                        for (int j = 0; j < liczbaProcesowNaTest; j++) {
                            procesy.add(new Proces(i));
                        }
                        czas += rotacyjny(procesy, zmiana);
                    }
                    System.out.println("Sredni czas na proces rotacyjny wynosi: " + czas / liczbaTestow+" dla interwalu: "+zmiana);
                }
                case 5->{
                    System.out.println("Do widzenia");
                    return;
                }
                default -> System.out.println("Bledny wybor");
            }
        }
    }
    public static double FIFO(ArrayList<Proces> procesy){
        double size = procesy.size();
        double czas = 0;
        ArrayList<Proces> procesyTrwajace = new ArrayList<>();
        ArrayList<Proces> procesyUkonczone = new ArrayList<>();
        while(procesy.size()!=0||procesyTrwajace.size()!=0){
            for (int i=0;i<procesy.size();i++){
                procesy.get(i).zmniejszMomentZgloszenia(1);
                if (procesy.get(i).getMomentZgloszenia()==0){
                    procesyTrwajace.add(procesy.get(i));
                    procesy.remove(i);
                    i--;
                }
            }
            if (procesyTrwajace.size()!=0){
                czasMija(procesyTrwajace.get(0),procesyTrwajace);
                if (procesyTrwajace.get(0).getDlFazy()==0){
                    procesyUkonczone.add(procesyTrwajace.get(0));
                    procesyTrwajace.remove(0);
                }
            }
        }
        for(Proces proces:procesyUkonczone) {
            czas += proces.getCzasOczekiwania();
            System.out.print(proces.getCzasOczekiwania()+" | ");
        }
        System.out.println();
        return (czas/size);
    }
    public static double SJF_wywlaszczone(ArrayList<Proces> procesy){
        double size = procesy.size();
        double czas = 0;
        ArrayList<Proces> procesyTrwajace = new ArrayList<>();
        ArrayList<Proces> procesyUkonczone = new ArrayList<>();
        while(procesy.size()!=0||procesyTrwajace.size()!=0){
            for (int i=0;i<procesy.size();i++){
                procesy.get(i).zmniejszMomentZgloszenia(1);
                if (procesy.get(i).getMomentZgloszenia()==0){
                    procesyTrwajace.add(procesy.get(i));
                    procesy.remove(i);
                    i--;
                }
            }
            procesyTrwajace.sort(Comparator.comparing(Proces::getDlFazy));
            if (procesyTrwajace.size()!=0){
                czasMija(procesyTrwajace.get(0),procesyTrwajace);
                if (procesyTrwajace.get(0).getDlFazy()==0){
                    procesyUkonczone.add(procesyTrwajace.get(0));
                    procesyTrwajace.remove(0);
                }
            }
        }
        for(Proces proces:procesyUkonczone) {
            czas += proces.getCzasOczekiwania();
            System.out.print(proces.getCzasOczekiwania()+" | ");
        }
        System.out.println();
        return (czas/size);
    }
    public static double SJF_niewywlaszczone(ArrayList<Proces> procesy){
        double size = procesy.size();
        double czas = 0;
        ArrayList<Proces> procesyTrwajace = new ArrayList<>();
        ArrayList<Proces> procesyUkonczone = new ArrayList<>();
        while(procesy.size()!=0||procesyTrwajace.size()!=0){
            for (int i=0;i<procesy.size();i++){
                procesy.get(i).zmniejszMomentZgloszenia(1);
                if (procesy.get(i).getMomentZgloszenia()==0){
                    procesyTrwajace.add(procesy.get(i));
                    procesy.remove(i);
                    i--;
                }
            }
            if (procesyTrwajace.size()!=0){
                czasMija(procesyTrwajace.get(0),procesyTrwajace);
                if (procesyTrwajace.get(0).getDlFazy()==0){
                    procesyUkonczone.add(procesyTrwajace.get(0));
                    procesyTrwajace.remove(0);
                    procesyTrwajace.sort(Comparator.comparing(Proces::getDlFazy));
                }
            }
        }
        for(Proces proces:procesyUkonczone) {
            czas += proces.getCzasOczekiwania();
            System.out.print(proces.getCzasOczekiwania()+" | ");
        }
        System.out.println();
        return (czas/size);
    }

    public static double rotacyjny(ArrayList<Proces> procesy, Integer zmiana){
        double size = procesy.size();
        double czas = 0;
        boolean czyZmiana = true;
        ArrayList<Proces> procesyTrwajace = new ArrayList<>();
        ArrayList<Proces> procesyUkonczone = new ArrayList<>();
        while(procesy.size()!=0||procesyTrwajace.size()!=0){
            for (int j=0;j<zmiana;j++){
                czyZmiana = true;
                for (int i=0;i<procesy.size();i++){
                    procesy.get(i).zmniejszMomentZgloszenia(1);
                    if (procesy.get(i).getMomentZgloszenia()<=0){
                        procesyTrwajace.add(procesy.get(i));
                        procesy.remove(i);
                        i--;
                    }
                }
                if (procesyTrwajace.size()!=0){
                    czasMija(procesyTrwajace.get(0),procesyTrwajace);
                    if (procesyTrwajace.get(0).getDlFazy()<=0){
                        procesyUkonczone.add(procesyTrwajace.get(0));
                        procesyTrwajace.remove(0);
                        czyZmiana = false;
                        break;
                    }
                }
            }
            if (czyZmiana){
                if (procesyTrwajace.size()!=0){
                    Proces firstProces = procesyTrwajace.get(0);
                    for (int i=0;i<procesyTrwajace.size()-1;i++){
                        procesyTrwajace.set(i,procesyTrwajace.get(i+1));
                    }
                    procesyTrwajace.set(procesyTrwajace.size()-1,firstProces);
                }
            }
        }
        for(Proces proces:procesyUkonczone) {
            czas += proces.getCzasOczekiwania();
            System.out.print(proces.getCzasOczekiwania()+" | ");
        }
        System.out.println();
        return czas/size;
    }
    public static void czasMija(Proces proces,ArrayList<Proces> procesyTrwajace){
        proces.zmniejszDlFazy(1);
        for(Proces aktywny:procesyTrwajace){
            if(aktywny!=proces)
                aktywny.addCzasOczekiwania(1);
        }
    }
}