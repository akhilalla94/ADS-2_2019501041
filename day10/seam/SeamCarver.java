import java.awt.Color;

public class SeamCarver {
    private static final boolean Vertical = false;
private static final boolean Horizontal = true;
    private Picture pic;
    private int width;
    private int height;
    private double[] distTo;
    private int[][] edgeTo;

    public SeamCarver(Picture picture){
        pic = new Picture(picture);
        width = picture.width();
        height = picture.height();
    }

    public Picture picture(){
        return pic;
    }

    public int width(){
        return width;
    }

    public int height(){
        return height;
    }

    public double energy(int x ,int y){
        if(x < 0  || x >width() -1 || y <0 || y >height() -1) {
            throw new IndexOutOfBoundsException();
        }

        if(x  == 0  || x  == width() -1 || y  == 0 || y == height() -1) {
            return 1000;
        }

        double xDiff =0.0;
        double yDiff =0.0;

        Color a,b,c,d;

        a = pic.get(x-1,y);
        b = pic.get(x+1,y);
        c = pic.get(x,y-1);
        d = pic.get(x,y+1);


        xDiff = Math.pow((a.getRed() - b.getRed()),2) + Math.pow((a.getGreen() - b.getGreen()),2) +
        Math.pow((a.getBlue() - b.getBlue()),2);

        yDiff = Math.pow((c.getRed() - d.getRed()),2) + Math.pow((c.getGreen() - d.getGreen()),2) +
        Math.pow((c.getBlue() - d.getBlue()),2);

        double energy = Math.sqrt(xDiff + yDiff);
        return energy;

    }

    public int[] findVerticalSeam() {
        return Seam(Vertical);
    }

    public int[] findHorizontalSeam() {
        return Seam(Horizontal);
    }

    private int[] Seam(boolean axis) {
        if(axis == Vertical) {
            this.distTo = new double[this.width()];
        }
        else
        {
            this.distTo =  new double[this.height()];
        }
        this.edgeTo = new int[this.width()][this.height()];
        int dim1,dim2;
        for(int i = 0; i < this.distTo.length; i++) {
            this.distTo[i] = 1000;
        }
        if(axis == Vertical) {
            dim1 =this.height();
            dim2 = this.width();
        }
        else{
            dim1 = this.width();
            dim2 = this.height();
        }
        for(int i =1; i < dim1;i++){
            double[] lastdistTo = this.distTo.clone();
            for(int k = 0; k < distTo.length; k++){
                this.distTo[k] = Double.POSITIVE_INFINITY;
            }
            int x,y;
            for(int j=1; j < dim2; j++) {
                if(axis == Vertical) {
                    x = j;
                    y = i;
                }else{
                    x = i;
                    y = j;
                }
                double energy = energy(x,y);
                relax(j-1,x,y,energy,lastdistTo,axis);
                relax(j,x,y,energy,lastdistTo,axis);
                relax(j+1,x,y,energy,lastdistTo,axis);
            }
        }
        double minimumWeight = Double.POSITIVE_INFINITY;
        int minimum = 0;
        for(int i = 0 ;i < this.distTo.length; i++){
            double Wt = this.distTo[i];
            if(Wt < minimumWeight) {
                minimum = i;
                minimumWeight = Wt;

            }
        }

        int[] Seam;
        if(axis == Vertical) {
            Seam = new  int[this.height()];

        }
        else{
            Seam = new int[this.width()];
        }
        if(axis == Vertical) {
            for(int Z =this.height() -1;Z >= 0;Z--) {
                Seam[Z] = minimum;
                minimum = edgeTo[minimum][Z];
            }
        }
        else{
            for(int X =this.width() -1;X >= 0;X--) {
                Seam[X] = minimum;
                minimum = edgeTo[X][minimum];
            }
        }
        return Seam;
    }
    public void relax(int prev,int x,int y,double energy,double[] lastdistTo,boolean axis ) {
        if(prev < 0 || prev >= lastdistTo.length) {
            return;
        }
        double Weight = lastdistTo[prev];
        int index;
        if(axis == Vertical) {
            index = x;
        }
        else {
            index = y;
        }
        if(this.distTo[index]  > Weight + energy) {
            this.distTo[index] = Weight + energy;
            this.edgeTo[x][y] =prev;

        }
     }
     public void removeVerticalSeam(int[] seam) {
        if (seam == null ) {
            throw new IllegalArgumentException();
        }

        Picture newPic = new Picture(width - 1, height);

        Color color;
        int colo;

        for (int j = 0; j < height; j++) {
            

            for (int i = 0; i < width; i++) {
                if (seam[j] == i) continue;

                color  = this.pic.get(i,j);
                colo = i;
                if(i > seam[j]) colo--;

                newPic.set(colo,j,color);

            }
        }

        this.pic = newPic;
        this.width = this.pic.width();
        this.height = this.pic.height();
        
    }
 }


     

