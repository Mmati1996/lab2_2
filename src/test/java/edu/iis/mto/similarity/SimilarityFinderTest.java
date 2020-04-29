package edu.iis.mto.similarity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimilarityFinderTest {
    SimilarityFinder sf;
    SearchMock mock;
    int[] empty1= new int[]{};
    int[] empty2= new int[]{};
    int[] sequence = new int[]{1,3,7,12};
    int[] sequence1 = new int[]{3,4,5,6};
    int[] sequence2 = new int[]{31,44,267,12};
    int[] sequence3 = new int[]{3,4,6,6};

    @BeforeEach
    void init(){
        mock = new SearchMock();
        sf=new SimilarityFinder(mock);
    }

    @Test
    void emptySequencesTest(){

        assertTrue(sf.calculateJackardSimilarity(empty1,empty2) == 1);
    }

    @Test
    void firstEmptySequencesTest(){
        assertTrue(sf.calculateJackardSimilarity(sequence1,empty2) == 0);
    }

    @Test
    void secondEmptySequencesTest(){
        assertTrue(sf.calculateJackardSimilarity(empty1, sequence1) == 0);
    }

    @Test
    void identicalSequencesTest(){
        assertTrue(sf.calculateJackardSimilarity(sequence1, sequence1) == 1);
    }

    @Test
    void absolutelyDifferentSequencesTest(){
        assertTrue(sf.calculateJackardSimilarity(sequence1, sequence2) == 0);
    }

    @Test
    void similarSequencesTest(){
        assertTrue(sf.calculateJackardSimilarity(sequence1, sequence3) > 0.5);
    }
    @Test
    void nullsTest(){
        assertThrows(NullPointerException.class,()->{
            sf.calculateJackardSimilarity(null,null);
        });
    }

    @Test
    void firstNullTest(){
        assertThrows(NullPointerException.class,()->{
            sf.calculateJackardSimilarity(sequence,null);
        });
    }

    @Test
    void secondNullTest(){
        assertThrows(NullPointerException.class,()->{
            sf.calculateJackardSimilarity(null,sequence);
        });
    }


}