//imports

import java.io.File; //file handling
import java.util.ArrayList;
import java.util.Scanner;


// Packet object that will hold a packet and data about it
class PacketObject {
    char type;
    char subType;
    String dataPortion = "";
    String checksum;
    boolean validWrapperSum = false;
    boolean validDataSum = false;

    public boolean getValidWrapperSum() {
        return validWrapperSum;
    }

    public void setValidWrapperSum(boolean validWrapperSum) {
        this.validWrapperSum = validWrapperSum;
    }

    public boolean getValidDataSum() {
        return validDataSum;
    }

    public void setValidDataSum(boolean validDataSum) {
        this.validDataSum = validDataSum;
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


public class Workspace {

    // Location of the file to be read
    public static final String fileLocation = "D:\\Nortech\\packets.txt";



    // Reads the file
    public static ArrayList<PacketObject> readFile(String inputFile) {
        ArrayList<PacketObject> output = new ArrayList<>();

        // Try catch to make sure the file location is valid ( Error Handling )
        try {
            File packetsFile = new File(inputFile);
            //System.out.println(packetsFile.canRead());

            // Prints out the file line by line
            Scanner reader = new Scanner(packetsFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                //System.out.println(data);

                output.add(fillPacket(data));
            }

        // Exception for unreadable file
        } catch (Exception e) {
            System.out.println("could not read file");
        }

        return output;
    }

    // Fill packet object with line of data
    public static PacketObject fillPacket(String input) {
        PacketObject output = new PacketObject();

        // Error handling in case the packets do not have correct syntax
            try {

                output.setType(input.charAt(0));
                output.setSubType(input.charAt(1));
                //System.out.println(input.length());

                // If the packet has a data portion
                if (input.length() > 5) {
                    output.setDataPortion(input.substring(2, input.length() - 2));
                }


                output.setChecksum(input.substring(input.length() - 2));


            } catch (Exception e) {
                System.out.println("packet does not fit: " + e + input);
            }



            //System.out.println(output.getType() + " " + output.getSubType() + " " + output.getDataPortion() + " " + output.getChecksum());

        // Outputs filled packet
        return output;
    }


    // Checks if hexadecimal value calculated will equal the checksum supplied
    public static ArrayList<PacketObject> checkWrapperCheckSums(ArrayList<PacketObject> input) {
        for ( PacketObject i : input) {

            try {

                int asciiType = i.getType();
                int asciiSubType = i.getSubType();
                int wrapperChecksum = (asciiType + asciiSubType) % 256;


                int testChecksum = Integer.parseInt(i.getChecksum(), 16);

                //System.out.println(wrapperChecksum + " " + testChecksum);

                if (testChecksum == wrapperChecksum) {
                    i.setValidWrapperSum(true);
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                //System.out.println(i.getType() + i.getSubType() + i.getDataPortion() + i.getValidWrapperSum());
                System.out.println("check sum not valid: " + e + " type: " + i.getType() + " sub-type: "+ i.getSubType() + "checksum: "  + i.getChecksum());
            }
        }
        return input;
    }

    // Checks if check sum of data matches check sum provided
    public static ArrayList<PacketObject> checkDataCheckSums(ArrayList<PacketObject> input) {
        for (PacketObject i : input) {

            // Variables for data size lengths
            String wholeChunk = i.getDataPortion();
            int chunkLength = 34;
            int numberOfFullChunks = wholeChunk.length()/chunkLength;

            boolean validData = true;


            if (wholeChunk.length() > 0) {

                try {
                    // Full length data portions
                    for (int x = 0; x < numberOfFullChunks; x++) {

                        String fullChunk = wholeChunk.substring(x * chunkLength, chunkLength + (x * chunkLength));
                        String fullChunkData = fullChunk.substring(0, fullChunk.length()-2);

                        int fullChunkCheckSum = Integer.parseInt(fullChunk.substring(fullChunk.length()-2),16);

                        //System.out.println(fullChunk + " " + fullChunkData + " " + fullChunkCheckSum + " " + getDataCheckSum(fullChunkData));
                        //System.out.println(wholeChunk.substring(x * chunkLength, chunkLength + (x * chunkLength)));

                        // throws exception to see error closer
                        if (fullChunkCheckSum != getDataCheckSum(fullChunkData)) {
                            validData = false;
                            throw new Exception();
                        }

                        x++;
                    }

                    // Remainder data portion. Enters the if statement if the data portion is not contained within full chunks

                    if (wholeChunk.length() % chunkLength != 0) {

                        String partChunk = wholeChunk.substring(numberOfFullChunks * chunkLength);
                        String partChunkData = partChunk.substring(0, partChunk.length() - 2);

                        int partChunkCheckSum = Integer.parseInt(partChunk.substring(partChunk.length() - 2), 16);

                        //System.out.println(partChunk);
                        //System.out.println(partChunk + " " + partChunkData + " " + partChunkCheckSum + " " + getDataCheckSum(partChunkData));

                        // Throws exception to see error closer
                        if (partChunkCheckSum != getDataCheckSum(partChunkData)) {
                            validData = false;
                            throw new Exception();
                        }
                    }


                // Catches exception for if a data portion of a packet does not fit or does not work
                } catch (Exception e) {
                    validData = false;
                    System.out.println("data portion not valid " + e + " data: " +  i.getDataPortion());
                    //System.out.println();
                }


            }
            //System.out.println();


            if (validData) {
                i.setValidDataSum(true);
            }

        }


        return input;
    }

    // Returns the sum of the data modulo 256
    public static long getDataCheckSum (String input) {

        int accumulator = 0;

        for (int x = 0; x < input.length(); x++) {
            accumulator = accumulator + (int) input.charAt(x);
            //System.out.println(input.charAt(x) + " " + (int) input.charAt(x));
        }



        return accumulator % 256;

    }


    // Calculates and displays validity based upon if the Data checksum and the Wrapper checksum are correct
    public static void calculateValidity(ArrayList<PacketObject> input) {
        int counter = 0;
        for (PacketObject i : input) {
            if (i.getValidWrapperSum()) {
                if (i.getValidDataSum()) {
                    counter++;
                }
            }
        }
        System.out.println("===============================================");
        System.out.println(counter + " out of 1000 packets are valid");
    }


    public static void main(String[] args) {

        ArrayList<PacketObject> myPackets = readFile(fileLocation);

        myPackets = checkWrapperCheckSums(myPackets);
        myPackets = checkDataCheckSums(myPackets);

        calculateValidity(myPackets);

        System.out.println();

    }

















}
