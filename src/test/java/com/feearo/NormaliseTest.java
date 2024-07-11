package com.feearo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NormaliseTest {

    @Test
    public void testNormalise() {
        String jt = "Java engineer"; 
        Normaliser n = new Normaliser(); 
        String normalisedTitle = n.normalise(jt); 
        //output normalisedTitle 
        jt = "C# engineer"; 
        normalisedTitle = n.normalise(jt); 
        assertEquals("Software engineer", normalisedTitle, "Normalise of C# enginner should be Software engineer");

        jt = "Java engineer"; 
        normalisedTitle = n.normalise(jt); 
        assertEquals("Software engineer", normalisedTitle, "Normalise of Java enginner should be Software engineer");


        //output normalisedTitle 
        jt = "Accountant"; 
        normalisedTitle = n.normalise(jt); 
        assertEquals("Accountant", normalisedTitle, "Normalise of Accountant should be Accountant");


        jt = "Chief Accountant"; 
        normalisedTitle = n.normalise(jt); 
        assertEquals("Accountant", normalisedTitle, "Normalise of Chief enginner should be Accountant");
    }
}