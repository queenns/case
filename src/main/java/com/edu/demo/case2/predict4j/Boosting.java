package com.edu.demo.case2.predict4j;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public abstract class Boosting implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(Boosting.class);
    private static final long serialVersionUID = -3370589073161617590L;

    public static Boosting createBoosting() throws IOException {
        String type = getBoostingTypeFromModelFile();
        Boosting boosting = null;
        if (type.equals("tree")) {
            boosting = new GBDT();
        } else {
            logger.error("unknown submodel type in model file");
        }
        loadFileToBoosting(boosting);
        return boosting;
    }

    /*public static Boosting createBoosting(String type, String filename) throws FileNotFoundException, IOException {
        if (filename == null || filename.length() == 0) {
            if (type.equals("gbdt")) {
                return new GBDT();
            } else if (type.equals("dart")) {
                return new DART();
            } else if (type.equals("goss")) {
                return new GOSS();
            } else {
                return null;
            }
        } else {
            Boosting boosting = null;
            String type_in_file = getBoostingTypeFromModelFile(filename);
            if (type_in_file.equals("tree")) {
                if (type.equals("gbdt")) {
                    boosting = new GBDT();
                } else if (type.equals("dart")) {
                    boosting = new DART();
                } else if (type.equals("goss")) {
                    boosting = new GOSS();
                } else {
                    logger.error("unknown boosting type " + type);
                }
                loadFileToBoosting(boosting, filename);
            } else {
                logger.error("unknown submodel type in model file " + filename);
            }
            return boosting;
        }
    }*/


    //todo 20201203 original begin
   /* public static boolean loadFileToBoosting(Boosting boosting, String filename) throws IOException {
        if (boosting != null) {
            StringBuilder sb = new StringBuilder();
            List<String> lines = IOUtils.readLines(new FileInputStream(filename));
            for (String line : lines) {
                sb.append(line).append("\n");
            }
            if (!boosting.loadModelFromString(sb.toString()))
            {
                return false;}
        }

        return true;
    }*/

    //todo 20201203 original end

    //todo 20201203 begin
    /*public static boolean loadFileToBoosting(Boosting boosting, String filename) throws IOException {
        if (boosting != null) {

            List<String> lines = IOUtils.readLines(new FileInputStream(filename));
            //String join = String.join("\n",lines);
            String join = StringUtils.join(lines, "\n");
            StringBuilder sb = new StringBuilder(join);

            if (!boosting.loadModelFromString(sb.toString())) {
                return false;
            }
        }

        return true;
    }*/

    public static boolean loadFileToBoosting(Boosting boosting) throws IOException {

        if (boosting != null) {
            //StringBuilder sb = new StringBuilder(812299291);
            //List<String> lines = IOUtils.readLines(new FileInputStream(filename));
            List<String> lines = FileReader.readLines();

            /*int roll = 0;
            try {

                for (String line : lines) {
                    sb.append(line).append("\n");
                    roll++;
                    //System.out.println("Boosting String Length:"+ String.valueOf( sb ).length());
                }

            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);

            } finally {
                System.out.println("Execute Size: " + roll);
                System.out.println("Boosting String error Length:" + String.valueOf(sb).length());
            }*/

            if (!boosting.loadModelFromString(lines)) {
                return false;
            }
        }

        return true;
    }


    static long repeatedString(String s, long n) {
        // repeat string only if has "a"
        if (s.contains("a")) {
            StringBuilder stringBuilder = new StringBuilder(s);
            String infiniteString = "";
            if (stringBuilder.length() < n) {
                //repeat String if length is less than n
                infiniteString = infiniteString(s, n);
            }
            int count = 0;
            char[] stringArray = infiniteString.toCharArray();
            for (int i = 0; i < n; i++) {

                char a = 'a';
                if (stringArray[i] == a) {
                    count++;
                }
            }
            return count;
        } else {
            return 0;
        }
    }


    static String infiniteString(String strInput, Long n) {
        //StringWriter stringWriter = new StringWriter(  );
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            //stringWriter.write( strInput );
            //stringBuilder.append( String.format(strInput));
            stringBuilder.append(strInput);
            System.out.println("Length:" + String.valueOf(stringBuilder).length());
            /*if(stringBuilder.length() == n || stringBuilder.length() > 100)*/
            if (String.valueOf(stringBuilder).length() == n) {
                break;
            }
        }

        return String.valueOf(stringBuilder);
    }


    //todo 20201203 end


    public static String getBoostingTypeFromModelFile() throws IOException {
        //List<String> lines = IOUtils.readLines(new FileInputStream(filename));
        List<String> lines = FileReader.readLines();
        return lines.get(0);
    }

    //todo 20201204 begin
    //abstract public boolean loadModelFromString(String modelStr);
    abstract public boolean loadModelFromString(List<String> lines);
    //todo 20201204 end

    abstract public boolean needAccuratePrediction();

    abstract public int numberOfClasses();

    abstract public void initPredict(int num_iteration);

    abstract public int numPredictOneRow(int num_iteration, boolean is_pred_leaf);

    abstract public int getCurrentIteration();

    abstract public int maxFeatureIdx();

    abstract public List<Double> predictLeafIndex(SparseVector vector);

    abstract public List<Double> predictRaw(SparseVector vector, PredictionEarlyStopInstance early_stop);

    abstract public List<Double> predict(SparseVector vector, PredictionEarlyStopInstance early_stop);
}
