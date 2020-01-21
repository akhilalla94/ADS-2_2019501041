import edu.princeton.cs.algs4.In;

public class Outcast {
    private WordNet wordnet;

    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    public String outcast(String[] nouns) {
        if (nouns == null) {
            int sum = 0;
            String out = "";

            for (int i = 0; i < nouns.length; i++) {
                int d = 0;

                for (int j = 0; j < nouns.length; j++) {
                    d += wordnet.distance(nouns[i], nouns[j]);
                }

                if (d > sum) {
                    sum = d;
                    out = nouns[i];
                }
            }
            return out;
        }
        return null;
    }
    

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            System.out.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
