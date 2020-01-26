import java.awt.Color;

public class SeamCarver {

    private Picture pic;
    private int width;
    private int height;

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
            return 0;
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
}