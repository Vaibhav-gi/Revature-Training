public class TwodimArray {

    public static void main(String[] args)
    {
        int x[][]=new int[][]{{12,13,1},{34,23,2},{4,5,4}};
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(x[i][j]+"\t");
            }
            System.out.println(" ");
        }

    }
}
