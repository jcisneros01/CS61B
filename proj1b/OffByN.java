public class OffByN implements CharacterComparator {
    private int _n;
    public OffByN(int N) {
        _n = N;
    }
    
    @Override
    public boolean equalChars(char x, char y) {
        int characterDifference  = Math.abs(x - y);
        return characterDifference == _n;
    }
}
