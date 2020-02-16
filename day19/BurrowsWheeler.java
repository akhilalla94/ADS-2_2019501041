import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
  private static final int R = 256;
// apply Burrows-Wheeler transform, reading from standard input and writing to standard output
  public static void transform() {
    String S = BinaryStdIn.readString();
    int n = S.length();
    char[] t = new char[n];
    int first = 0;
    CircularSuffixArray csa = new CircularSuffixArray(S);
    while (first < n && csa.index(first) != 0) {
      first++;
    }
    BinaryStdOut.write(first);
    for (int a = 0; a < n; a++) {
      BinaryStdOut.write(S.charAt((csa.index(a) + S.length() - 1) % S.length()));
      t[a] = S.charAt((csa.index(a) + n - 1) % n);
    }
    BinaryStdOut.close();
  }

  // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
  public static void inverseTransform() {
    int first = BinaryStdIn.readInt();
    String t = BinaryStdIn.readString();
    int n = t.length();
    int[] next = new int[n];
    int[] count = new int[R + 1];
    
    for (int a  = 0; a < n; a++)
      count[t.charAt(a) + 1]++;

    for (int a = 1; a < R + 1; a++)
      count[a] += count[a - 1];


    for (int a = 0; a < n; a++)
      next[count[t.charAt(a)]++] = a;

    for (int a = next[first], c = 0; c < n; a = next[a], c++)
      BinaryStdOut.write(t.charAt(a));

    BinaryStdOut.close();
  }

  public static void main(String[] args) {
   
  }
}
