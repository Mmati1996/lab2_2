package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SearchMock implements SequenceSearcher {
    int calls=0;

    SearchResult sr = SearchResult.builder().withFound(false).withPosition(-1).build();

    @Override
    public SearchResult search(int elem, int[] seq) {
        calls++;
        for (int i : seq){
            if (i==elem){
                sr = SearchResult.builder().withFound(true).withPosition(i).build();
                break;
            }
        }
        return sr;
    }
}
