import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
  private static final int R = 256; // extended ASCII
  // apply move-to-front encoding, reading from standard input and writing to standard output
  public static void encode() {
    char[] chars = new char[R];
    for (char i = 0; i < R; i++) {
        chars[i] = i;
    }
    while (!BinaryStdIn.isEmpty()) {
      char ch = BinaryStdIn.readChar();
      char tmpin, count, tmpout;
      for (count = 0, tmpout = chars[0]; ch != chars[count]; count++) {
        tmpin = chars[count];
        chars[count] = tmpout;
        tmpout = tmpin;
      }
      chars[count] = tmpout;
      BinaryStdOut.write(count);
      chars[0] = ch;
    }
    BinaryStdOut.close();
  }

  // apply move-to-front decoding, reading from standard input and writing to standard output
  public static void decode() {
    char[] chars = new char[R];
    for (char i = 0; i < R; i++) {
      chars[i] = i;
    }
    while (!BinaryStdIn.isEmpty()) {
      char count = BinaryStdIn.readChar();
      BinaryStdOut.write(chars[count], 8);
      char index = chars[count];
      while (count > 0) {
        chars[count] = chars[--count];
      }
      chars[0] = index;
    }
    BinaryStdOut.close();
  }

  public static void main(String[] args) {
   
  }
}
