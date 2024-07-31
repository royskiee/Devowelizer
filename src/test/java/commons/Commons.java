package commons;

public class Commons {

    // Define test cases and expected results
    public static final String[] TEST_CASES = {
        "hello",  // Test Case 1: Basic String with Vowels
        "rhythm", // Test Case 2: String Without Vowels
        "aeiou",  // Test Case 3: String with All Vowels
        "abc123", // Test Case 4: Mixed Characters Including Numbers
        "hello!@#world", // Test Case 5: String with Special Characters
        "", // Test Case 6: Empty String
        "HELLO", // Test Case 7: Case Sensitivity
        "a", // Test Case 8: Single Character Input (Vowel)
        "b", // Test Case 9: Single Character Input (Consonant)
        "The quick brown fox jumps over 13 lazy dogs!", // Test Case 10: Long String with Random Characters
        "!@#$%^&*()ae", // Test Case 11: Special Characters with Vowels
        new String(new char[1000]).replace("\0", "a"), // Test Case 12: Maximum Input (Large String of 'a')
    };

    public static final String[] EXPECTED_RESULTS = {
        "hll", // TC1
        "rhythm", // TC2
        "", // TC3
        "bc123", // TC4
        "hll!@#wrld", // TC5
        "", // TC6 
        "HLL", // TC7
        "", // TC8
        "b", // TC9
        "Th qck brwn fx jmps vr 13 lzy dgs!", //TC10
        "!@#$%^&*()", // TC11
        new String(new char[1000]).replace("\0", ""), //TC12
    };
}
