class Army {

    public static void createArmy() {
        // Create all objects here
        Unit unitA = new Unit("A");
        Unit unitB = new Unit("B");
        Unit unitC = new Unit("C");
        Unit unitD = new Unit("D");
        Unit unitE = new Unit("E");

        Knight knightArthur = new Knight("Arthur");
        Knight knightPeter = new Knight("Peter");
        Knight knightPauly = new Knight("Pauly");

        General generalPaul = new General("Paul");

        Doctor doctorMedy = new Doctor("Medy");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}