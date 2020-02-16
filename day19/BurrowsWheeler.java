import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
  private static final int R = 256;
// apply Burrows-Wheeler transform, reading from standard input and writing to standard output
  public static void transform() {
    String s = BinaryStdIn.readString();
    int n = s.length();
    char[] t = new char[n];
    int first = 0;
    CircularSuffixArray csa = new CircularSuffixArray(s);
    while (first < n && csa.index(first) != 0) {
      first++;
    }
    BinaryStdOut.write(first);
    for (int i = 0; i < n; i++) {
      BinaryStdOut.write(s.charAt((csa.index(i) + s.length() - 1) % s.length()));
      t[i] = s.charAt((csa.index(i) + n - 1) % n);
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

    for (int i = 0; i < n; i++)
      count[t.charAt(i) + 1]++;

    for (int i = 1; i < R + 1; i++)
      count[i] += count[i - 1];

    for (int i = 0; i < n; i++)
      next[count[t.charAt(i)]++] = i;

    for (int i = next[first], c = 0; c < n; i = next[i], c++)
      BinaryStdOut.write(t.charAt(i));

    BinaryStdOut.close();
  }
  public static void main(String[] args) {
   
  }
}
