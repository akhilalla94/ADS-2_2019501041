
import java.util.Set;
import java.util.HashSet;
import edu.princeton.cs.algs4.SET;

public class BoggleSolver {

    private TrieSET dict;


    public BoggleSolver(String[] dict) {

        this.dict = new TrieSET();

        
        for (String word : dict) {
            
            this.dict.add(word);
        }

    }


    public Iterable<String> getAllValidWords(BoggleBoard B) {

        Set<String> valid_words = new HashSet<String>();

        for (int a = 0; a < B.R(); a++) {

            for (int b = 0; b < B.C(); b++) {

                boolean[][] visit = new boolean[B.R()][B.C()];

                solver(B, a, b, visit, "", valid_words);
            }
        }
        return valid_words;

    }

    private void solver(BoggleBoard B, int R, int C, boolean[][] visit, String pre, Set<String> SET) {

        if (visit[R][C]) {
            return;
        }

        char letter = B.getLetter(R, C);

        String S = pre;

        if (letter == 'Q') {
            S = S + "QU";
        } else {
            S = S + letter;
        }
        if (!dict.hasPrefix(S)) {
            return;
        }
        if (S.length() > 2 && dict.contains(S)) {
            SET.add(S);
        }
        visit[R][C] = true;

        for (int l = -1; l <= 1; l++) {
            for (int m = -1; m <= 1; m++) {

                if (l == 0 && m == 0) {

                    continue;
                }
                if ((R + l >= 0) && (R + l < B.R() && (C + m >= 0) && (C + m < B.C()))) {

                    solver(B, R + l, C + m, visit, S, SET);
                }
            }
        }
        visit[R][C] = false;
    }

    public int scoreOf(String WORD) {

        if (dict.contains(WORD)) {

            switch (WORD.length()) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            default:
                return 11;
            }
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {

    }
}
