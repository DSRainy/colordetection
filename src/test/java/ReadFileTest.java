/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RainWhileLoop
 */
public class ReadFileTest {

    public ReadFileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

/**
 * This Test method testing can read file or not
 */
    @Test
    public void readFile() {

        String file = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\threshold.txt";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String text = in.readLine().split(" ")[0];
            assertEquals("hue", text);
            text = in.readLine().split(" ")[0];
            assertEquals("sat", text);
            text = in.readLine().split(" ")[0];
            assertEquals("value", text);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFileTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFileTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReadFileTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
