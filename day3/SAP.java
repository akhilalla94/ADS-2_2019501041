import java.util.*;
public class SAP{

    private Digraph G;
    public SAP(Digraph G) {
        this.G = G;
    }

    public int length(int v, int w) {

        BreadthFirstDirectedPaths bfdpV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfdpW = new BreadthFirstDirectedPaths(G, w);
        int minLength = Integer.MAX_VALUE;
        for (int u = 0; u < G.V(); ++u) {
            if (!bfdpV.hasPathTo(u) || !bfdpW.hasPathTo(u)) {
                continue;
            }
            int dist = bfdpV.distTo(u) + bfdpW.distTo(u);
            if (dist < minLength) {
                minLength = dist;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLength;
        }
    }

    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths bfdpV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfdpW = new BreadthFirstDirectedPaths(G, w);
        int minLength = Integer.MAX_VALUE;
        int anc = -1;
        for (int u = 0; u < G.V(); ++u) {
            if (!bfdpV.hasPathTo(u) || !bfdpW.hasPathTo(u)) {
                continue;
            }
            int dist = bfdpV.distTo(u) + bfdpW.distTo(u);
            if (dist < minLength) {
                minLength = dist;
                anc = u;
            }
        }
        return anc;
    }

    public int length(Iterable<Integer> v, Iterable<Integer> w) {

        int minLength = Integer.MAX_VALUE;
        for (int iv : v) {
            for (int iw : w) {
                int dist = length(iv, iw);
                if (dist == -1) {
                    continue;
                }
                if (dist < minLength) {
                    minLength = dist;
                }
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLength;
        }
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {

        int minLength = Integer.MAX_VALUE;
        int anc = -1;
        for (int iv : v) {
            for (int iw : w) {
                int dist = length(iv, iw);
                if (dist == -1) {
                    continue;
                }
                if (dist < minLength) {
                    minLength = dist;
                    anc = ancestor(iv, iw);
                }
            }
        }
        return anc;
    }


    public static void main(String[] args) {
        In in = new In("E:\\ADS-2_2019501041\\ADS-2_2019501041\\day3\\wordnet\\Digraph1.txt");
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
       
            System.out.println("length" + " "  + sap.length(7,2) +" "+ "ancestor "  +" "+ sap.ancestor(7,2));
            System.out.println("length" + " "  + sap.length(9,12) +" "+ "ancestor "  +" "+ sap.ancestor(9,12));
            System.out.println("length" + " "  + sap.length(3,11) +" "+ "ancestor "  +" "+ sap.ancestor(3,11));
            System.out.println("length" + " "  + sap.length(1,6) +" "+ "ancestor "  +" "+ sap.ancestor(1,6));
        
        }

    }







