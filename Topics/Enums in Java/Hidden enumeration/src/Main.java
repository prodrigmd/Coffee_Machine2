public class Main {

    public static void main(String[] args) {
    // write your program here
        int count = 0;
        for (Secret status : Secret.values()) {
            if (status.toString().startsWith("STAR")) {
                count++;
            }

        }
        System.out.println(count);
    }
}

/* sample enum for inspiration
   enum Secret {
    STAR, CRASH, START, // ...
}
*/