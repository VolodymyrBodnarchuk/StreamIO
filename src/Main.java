import java.io.*;


class Main{
    public static  void main(String[] args) throws IOException {

        String new_path = "K:\\EpamCourse\\StreamIO\\src\\Exercises\\xanadu.txt";
        char lookSymbol = 'A';
        int count = new FileData(new_path,lookSymbol).count();
        try {
            FileData new_file = new FileData(new_path, lookSymbol);
            String[] aryStrings = new_file.OpenAndRead();

            int i;
            for(i = 0; i < aryStrings.length;i++){
                System.out.println(aryStrings[i]);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());

    }

        System.out.format("File '%s' has %d instances of letter '%c'.%n",
                new_path, count, lookSymbol);
    }
}