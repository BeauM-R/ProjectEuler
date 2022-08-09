import java.io.File; //file handling
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class MyPacketObject {
    char type;
    char subType;
    String dataPortion = "";
    String checksum;

    public String generateChecksum(String input) {


        return "Test";
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getSubType() {
        return subType;
    }

    public void setSubType(char subType) {
        this.subType = subType;
    }

    public String getDataPortion() {
        return dataPortion;
    }

    public void setDataPortion(String dataPortion) {
        this.dataPortion = dataPortion;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

}

public class Workspace_2 {

    public static final String fileLocation = "D:\\Nortech\\data.txt";

    public static void main(String[] args) {
        readFile(fileLocation);
    }


    // Reads the file
    public static ArrayList<MyPacketObject> readFile(String inputFile) {
        ArrayList<MyPacketObject> output = new ArrayList<>();

        // Try catch to make sure the file location is valid ( Error Handling )
        try {
            File dataFile = new File(inputFile);
            //System.out.println(dataFile.canRead());

            // Prints out the file line by line
            Scanner reader = new Scanner(dataFile);
            int counter = 0;
            while (reader.hasNextLine()) {
                counter++;
                String data = reader.nextLine();
                //System.out.println("Line "+ counter + ":  " + data);

                System.out.println("line: " + counter);
                generatePacket(data);
                System.out.println("====================");
                output.add(generatePacket(data));
            }

            // Exception for unreadable file
        } catch (Exception e) {
            System.out.println("could not read file");
        }

        return output;
    }


    // creates a packet object from the details in the line passed
    public static MyPacketObject generatePacket(String fileLine) {
        MyPacketObject outputPacket = new MyPacketObject();
        try {
            String[] lineParts = fileLine.split("\t");
            outputPacket.setType(lineParts[0].charAt(0));
            outputPacket.setSubType(lineParts[1].charAt(0));
            // if includes data portion
            if (lineParts.length > 2) {
                outputPacket.setDataPortion(lineParts[2]);
            }

            // calculate wrapper
            outputPacket.setChecksum(calculateWrapper(outputPacket.getType(),outputPacket.getSubType()));
            dataChecksums(outputPacket.getDataPortion());


        } catch (Exception e) {
            System.out.println("Packet of incorrect size " + e);
        }


        return outputPacket;
    }

    public static String calculateWrapper(char inType, char inSubType) {

        int checksum = (Integer.valueOf(inType) + Integer.valueOf(inSubType)) % 256;

        String out = Integer.toHexString(checksum);
        System.out.println(out);
        return out;
    }

    public static String dataChecksums(String dataPortion) {
        List<String> segment = new ArrayList<String>();

        try{

            int increment = 32;

            int index = 0;
            while (index < dataPortion.length()) {
                segment.add(dataPortion.substring(index, Math.min(index + increment,dataPortion.length())));
                index += increment;

            }

            for (String x : segment) {
                System.out.println(x);

                int accumulator = 0;
                for (int letter = 0; letter < x.length(); letter++){
                    accumulator = accumulator + Integer.valueOf(x.charAt(letter));
                }

                x = x + Integer.toHexString((accumulator % 256));
                System.out.println(x);
            }

        } catch (Exception e) {
            System.out.println("data portion invalid " + e);
        }

        return "";
    }



}
