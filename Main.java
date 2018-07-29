public class Main {
    public static void main(String[] args) {
        String st = "1 2 3 4\n5 6 7 8\n9 10 11 12\n13 19 15 16";

        int m = 4; // размер матрицы
        float summa = 0;
        String regex = "";

        String contrl = st;
        contrl = contrl.replaceAll("[0-9]", "");
        contrl = contrl.replaceAll(" ", "");
        contrl = contrl.replaceAll("\n", "");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j == m-1){
                    regex = regex+"\\d+";
                }
                else{
                    regex = regex+"\\d+\\s+";
                }
            }

            if (i < m-1){
                regex = regex+"\\n";
            }

        }

        if (contrl.length()>0) {
            throw new RuntimeException("wrong symbols exist");
        }

        if (!st.matches(regex)){
            throw new RuntimeException("string can not be converted to an array "+m+"*"+m);
        }

        int[][] NewArray;
        NewArray = new int[m][m];
        String[] nsP = st.split("\\n");

        for (int i = 0; i < m; i++) {
            String nsPP[] = nsP[i].split(" ");
            for (int j = 0; j < m; j++) {
                NewArray[i][j] = Integer.parseInt(nsPP[j]);
                summa = summa + NewArray[i][j];
            }
        }

        System.out.println(summa/2);

    }
}
