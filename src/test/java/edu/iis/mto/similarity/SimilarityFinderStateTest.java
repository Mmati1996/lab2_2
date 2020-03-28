package edu.iis.mto.similarity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityFinderStateTest {
    SimilarityFinder sf;
    SearchMock mock;
    int[] empty1= new int[]{};
    int[] empty2= new int[]{};
    int[] sequence = new int[]{3,4,5};

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
        assertTrue(sf.calculateJackardSimilarity(sequence,empty2) == 0);
    }

    @Test
    void secondEmptySequencesTest(){
        assertTrue(sf.calculateJackardSimilarity(empty1,sequence) == 0);
    }


}