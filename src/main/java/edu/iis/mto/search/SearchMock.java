package edu.iis.mto.search;

public class SearchMock implements SequenceSearcher {

    SearchResult sr = SearchResult.builder().withFound(false).withPosition(-1).build();

    @Override
    public SearchResult search(int elem, int[] seq) {

        for (int i : seq){
            if (i==elem){
                sr = SearchResult.builder().withFound(true).withPosition(i).build();
                break;
            }
        }
        return sr;
    }
}
